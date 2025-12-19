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
@Table(name="BRF107_SUMMARYTABLE")
public class BRF_107_A_REPORT_ENTITY {
	private String	R1_S_NO  ;
	private String	R1_STAGES  ;
	private BigDecimal	R1_OUTSTANDING_NBFI  ;
	private BigDecimal	R1_PROVISION_NBFI  ;
	private BigDecimal	R1_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R1_PROVISION_FEDERAL ;
	private BigDecimal	R1_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R1_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R1_OUTSTANDING_EMIRATES ;
	private BigDecimal	R1_PROVISION_EMIRATES ;
	private BigDecimal	R1_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R1_PROVISION_GOVT_GROSS ;
	private BigDecimal	R1_OUTSTANDING_GRE ;
	private BigDecimal	R1_PROVISION_GRE ;
	private BigDecimal	R1_OUTSTANDING_CORPORATE ;
	private BigDecimal	R1_PROVISION_CORPORATE ;
	private BigDecimal	R1_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R1_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R1_OUTSTANDING_HIGH ;
	private BigDecimal	R1_PROVISION_HIGH ;
	private BigDecimal	R1_OUTSTANDING_SMALL ;
	private BigDecimal	R1_PROVISION_SMALL ;
	private BigDecimal	R1_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R1_PROVISION_INDIVIDUAL ;
	private BigDecimal	R1_OUTSTANDING_GROSS ;
	private BigDecimal	R1_PROVISION_GROSS ;
	private String	R2_S_NO  ;
	private String	R2_STAGES  ;
	private BigDecimal	R2_OUTSTANDING_NBFI  ;
	private BigDecimal	R2_PROVISION_NBFI  ;
	private BigDecimal	R2_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R2_PROVISION_FEDERAL ;
	private BigDecimal	R2_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R2_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R2_OUTSTANDING_EMIRATES ;
	private BigDecimal	R2_PROVISION_EMIRATES ;
	private BigDecimal	R2_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R2_PROVISION_GOVT_GROSS ;
	private BigDecimal	R2_OUTSTANDING_GRE ;
	private BigDecimal	R2_PROVISION_GRE ;
	private BigDecimal	R2_OUTSTANDING_CORPORATE ;
	private BigDecimal	R2_PROVISION_CORPORATE ;
	private BigDecimal	R2_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R2_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R2_OUTSTANDING_HIGH ;
	private BigDecimal	R2_PROVISION_HIGH ;
	private BigDecimal	R2_OUTSTANDING_SMALL ;
	private BigDecimal	R2_PROVISION_SMALL ;
	private BigDecimal	R2_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R2_PROVISION_INDIVIDUAL ;
	private BigDecimal	R2_OUTSTANDING_GROSS ;
	private BigDecimal	R2_PROVISION_GROSS ;
	private String	R3_S_NO  ;
	private String	R3_STAGES  ;
	private BigDecimal	R3_OUTSTANDING_NBFI  ;
	private BigDecimal	R3_PROVISION_NBFI  ;
	private BigDecimal	R3_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R3_PROVISION_FEDERAL ;
	private BigDecimal	R3_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R3_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R3_OUTSTANDING_EMIRATES ;
	private BigDecimal	R3_PROVISION_EMIRATES ;
	private BigDecimal	R3_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R3_PROVISION_GOVT_GROSS ;
	private BigDecimal	R3_OUTSTANDING_GRE ;
	private BigDecimal	R3_PROVISION_GRE ;
	private BigDecimal	R3_OUTSTANDING_CORPORATE ;
	private BigDecimal	R3_PROVISION_CORPORATE ;
	private BigDecimal	R3_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R3_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R3_OUTSTANDING_HIGH ;
	private BigDecimal	R3_PROVISION_HIGH ;
	private BigDecimal	R3_OUTSTANDING_SMALL ;
	private BigDecimal	R3_PROVISION_SMALL ;
	private BigDecimal	R3_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R3_PROVISION_INDIVIDUAL ;
	private BigDecimal	R3_OUTSTANDING_GROSS ;
	private BigDecimal	R3_PROVISION_GROSS ;
	private String	R4_S_NO  ;
	private String	R4_STAGES  ;
	private BigDecimal	R4_OUTSTANDING_NBFI  ;
	private BigDecimal	R4_PROVISION_NBFI  ;
	private BigDecimal	R4_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R4_PROVISION_FEDERAL ;
	private BigDecimal	R4_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R4_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R4_OUTSTANDING_EMIRATES ;
	private BigDecimal	R4_PROVISION_EMIRATES ;
	private BigDecimal	R4_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R4_PROVISION_GOVT_GROSS ;
	private BigDecimal	R4_OUTSTANDING_GRE ;
	private BigDecimal	R4_PROVISION_GRE ;
	private BigDecimal	R4_OUTSTANDING_CORPORATE ;
	private BigDecimal	R4_PROVISION_CORPORATE ;
	private BigDecimal	R4_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R4_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R4_OUTSTANDING_HIGH ;
	private BigDecimal	R4_PROVISION_HIGH ;
	private BigDecimal	R4_OUTSTANDING_SMALL ;
	private BigDecimal	R4_PROVISION_SMALL ;
	private BigDecimal	R4_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R4_PROVISION_INDIVIDUAL ;
	private BigDecimal	R4_OUTSTANDING_GROSS ;
	private BigDecimal	R4_PROVISION_GROSS ;
	private String	R5_S_NO  ;
	private String	R5_STAGES  ;
	private BigDecimal	R5_OUTSTANDING_NBFI  ;
	private BigDecimal	R5_PROVISION_NBFI  ;
	private BigDecimal	R5_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R5_PROVISION_FEDERAL ;
	private BigDecimal	R5_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R5_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R5_OUTSTANDING_EMIRATES ;
	private BigDecimal	R5_PROVISION_EMIRATES ;
	private BigDecimal	R5_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R5_PROVISION_GOVT_GROSS ;
	private BigDecimal	R5_OUTSTANDING_GRE ;
	private BigDecimal	R5_PROVISION_GRE ;
	private BigDecimal	R5_OUTSTANDING_CORPORATE ;
	private BigDecimal	R5_PROVISION_CORPORATE ;
	private BigDecimal	R5_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R5_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R5_OUTSTANDING_HIGH ;
	private BigDecimal	R5_PROVISION_HIGH ;
	private BigDecimal	R5_OUTSTANDING_SMALL ;
	private BigDecimal	R5_PROVISION_SMALL ;
	private BigDecimal	R5_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R5_PROVISION_INDIVIDUAL ;
	private BigDecimal	R5_OUTSTANDING_GROSS ;
	private BigDecimal	R5_PROVISION_GROSS ;
	private String	R6_S_NO  ;
	private String	R6_STAGES  ;
	private BigDecimal	R6_OUTSTANDING_NBFI  ;
	private BigDecimal	R6_PROVISION_NBFI  ;
	private BigDecimal	R6_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R6_PROVISION_FEDERAL ;
	private BigDecimal	R6_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R6_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R6_OUTSTANDING_EMIRATES ;
	private BigDecimal	R6_PROVISION_EMIRATES ;
	private BigDecimal	R6_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R6_PROVISION_GOVT_GROSS ;
	private BigDecimal	R6_OUTSTANDING_GRE ;
	private BigDecimal	R6_PROVISION_GRE ;
	private BigDecimal	R6_OUTSTANDING_CORPORATE ;
	private BigDecimal	R6_PROVISION_CORPORATE ;
	private BigDecimal	R6_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R6_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R6_OUTSTANDING_HIGH ;
	private BigDecimal	R6_PROVISION_HIGH ;
	private BigDecimal	R6_OUTSTANDING_SMALL ;
	private BigDecimal	R6_PROVISION_SMALL ;
	private BigDecimal	R6_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R6_PROVISION_INDIVIDUAL ;
	private BigDecimal	R6_OUTSTANDING_GROSS ;
	private BigDecimal	R6_PROVISION_GROSS ;
	private String	R7_S_NO  ;
	private String	R7_STAGES  ;
	private BigDecimal	R7_OUTSTANDING_NBFI  ;
	private BigDecimal	R7_PROVISION_NBFI  ;
	private BigDecimal	R7_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R7_PROVISION_FEDERAL ;
	private BigDecimal	R7_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R7_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R7_OUTSTANDING_EMIRATES ;
	private BigDecimal	R7_PROVISION_EMIRATES ;
	private BigDecimal	R7_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R7_PROVISION_GOVT_GROSS ;
	private BigDecimal	R7_OUTSTANDING_GRE ;
	private BigDecimal	R7_PROVISION_GRE ;
	private BigDecimal	R7_OUTSTANDING_CORPORATE ;
	private BigDecimal	R7_PROVISION_CORPORATE ;
	private BigDecimal	R7_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R7_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R7_OUTSTANDING_HIGH ;
	private BigDecimal	R7_PROVISION_HIGH ;
	private BigDecimal	R7_OUTSTANDING_SMALL ;
	private BigDecimal	R7_PROVISION_SMALL ;
	private BigDecimal	R7_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R7_PROVISION_INDIVIDUAL ;
	private BigDecimal	R7_OUTSTANDING_GROSS ;
	private BigDecimal	R7_PROVISION_GROSS ;
	private String	R8_S_NO  ;
	private String	R8_STAGES  ;
	private BigDecimal	R8_OUTSTANDING_NBFI  ;
	private BigDecimal	R8_PROVISION_NBFI  ;
	private BigDecimal	R8_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R8_PROVISION_FEDERAL ;
	private BigDecimal	R8_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R8_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R8_OUTSTANDING_EMIRATES ;
	private BigDecimal	R8_PROVISION_EMIRATES ;
	private BigDecimal	R8_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R8_PROVISION_GOVT_GROSS ;
	private BigDecimal	R8_OUTSTANDING_GRE ;
	private BigDecimal	R8_PROVISION_GRE ;
	private BigDecimal	R8_OUTSTANDING_CORPORATE ;
	private BigDecimal	R8_PROVISION_CORPORATE ;
	private BigDecimal	R8_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R8_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R8_OUTSTANDING_HIGH ;
	private BigDecimal	R8_PROVISION_HIGH ;
	private BigDecimal	R8_OUTSTANDING_SMALL ;
	private BigDecimal	R8_PROVISION_SMALL ;
	private BigDecimal	R8_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R8_PROVISION_INDIVIDUAL ;
	private BigDecimal	R8_OUTSTANDING_GROSS ;
	private BigDecimal	R8_PROVISION_GROSS ;
	private String	R9_S_NO  ;
	private String	R9_STAGES  ;
	private BigDecimal	R9_OUTSTANDING_NBFI  ;
	private BigDecimal	R9_PROVISION_NBFI  ;
	private BigDecimal	R9_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R9_PROVISION_FEDERAL ;
	private BigDecimal	R9_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R9_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R9_OUTSTANDING_EMIRATES ;
	private BigDecimal	R9_PROVISION_EMIRATES ;
	private BigDecimal	R9_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R9_PROVISION_GOVT_GROSS ;
	private BigDecimal	R9_OUTSTANDING_GRE ;
	private BigDecimal	R9_PROVISION_GRE ;
	private BigDecimal	R9_OUTSTANDING_CORPORATE ;
	private BigDecimal	R9_PROVISION_CORPORATE ;
	private BigDecimal	R9_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R9_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R9_OUTSTANDING_HIGH ;
	private BigDecimal	R9_PROVISION_HIGH ;
	private BigDecimal	R9_OUTSTANDING_SMALL ;
	private BigDecimal	R9_PROVISION_SMALL ;
	private BigDecimal	R9_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R9_PROVISION_INDIVIDUAL ;
	private BigDecimal	R9_OUTSTANDING_GROSS ;
	private BigDecimal	R9_PROVISION_GROSS ;
	private String	R10_S_NO  ;
	private String	R10_STAGES  ;
	private BigDecimal	R10_OUTSTANDING_NBFI  ;
	private BigDecimal	R10_PROVISION_NBFI  ;
	private BigDecimal	R10_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R10_PROVISION_FEDERAL ;
	private BigDecimal	R10_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R10_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R10_OUTSTANDING_EMIRATES ;
	private BigDecimal	R10_PROVISION_EMIRATES ;
	private BigDecimal	R10_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R10_PROVISION_GOVT_GROSS ;
	private BigDecimal	R10_OUTSTANDING_GRE ;
	private BigDecimal	R10_PROVISION_GRE ;
	private BigDecimal	R10_OUTSTANDING_CORPORATE ;
	private BigDecimal	R10_PROVISION_CORPORATE ;
	private BigDecimal	R10_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R10_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R10_OUTSTANDING_HIGH ;
	private BigDecimal	R10_PROVISION_HIGH ;
	private BigDecimal	R10_OUTSTANDING_SMALL ;
	private BigDecimal	R10_PROVISION_SMALL ;
	private BigDecimal	R10_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R10_PROVISION_INDIVIDUAL ;
	private BigDecimal	R10_OUTSTANDING_GROSS ;
	private BigDecimal	R10_PROVISION_GROSS ;
	private String	R11_S_NO  ;
	private String	R11_STAGES  ;
	private BigDecimal	R11_OUTSTANDING_NBFI  ;
	private BigDecimal	R11_PROVISION_NBFI  ;
	private BigDecimal	R11_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R11_PROVISION_FEDERAL ;
	private BigDecimal	R11_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R11_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R11_OUTSTANDING_EMIRATES ;
	private BigDecimal	R11_PROVISION_EMIRATES ;
	private BigDecimal	R11_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R11_PROVISION_GOVT_GROSS ;
	private BigDecimal	R11_OUTSTANDING_GRE ;
	private BigDecimal	R11_PROVISION_GRE ;
	private BigDecimal	R11_OUTSTANDING_CORPORATE ;
	private BigDecimal	R11_PROVISION_CORPORATE ;
	private BigDecimal	R11_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R11_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R11_OUTSTANDING_HIGH ;
	private BigDecimal	R11_PROVISION_HIGH ;
	private BigDecimal	R11_OUTSTANDING_SMALL ;
	private BigDecimal	R11_PROVISION_SMALL ;
	private BigDecimal	R11_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R11_PROVISION_INDIVIDUAL ;
	private BigDecimal	R11_OUTSTANDING_GROSS ;
	private BigDecimal	R11_PROVISION_GROSS ;
	private String	R12_S_NO  ;
	private String	R12_STAGES  ;
	private BigDecimal	R12_OUTSTANDING_NBFI  ;
	private BigDecimal	R12_PROVISION_NBFI  ;
	private BigDecimal	R12_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R12_PROVISION_FEDERAL ;
	private BigDecimal	R12_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R12_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R12_OUTSTANDING_EMIRATES ;
	private BigDecimal	R12_PROVISION_EMIRATES ;
	private BigDecimal	R12_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R12_PROVISION_GOVT_GROSS ;
	private BigDecimal	R12_OUTSTANDING_GRE ;
	private BigDecimal	R12_PROVISION_GRE ;
	private BigDecimal	R12_OUTSTANDING_CORPORATE ;
	private BigDecimal	R12_PROVISION_CORPORATE ;
	private BigDecimal	R12_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R12_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R12_OUTSTANDING_HIGH ;
	private BigDecimal	R12_PROVISION_HIGH ;
	private BigDecimal	R12_OUTSTANDING_SMALL ;
	private BigDecimal	R12_PROVISION_SMALL ;
	private BigDecimal	R12_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R12_PROVISION_INDIVIDUAL ;
	private BigDecimal	R12_OUTSTANDING_GROSS ;
	private BigDecimal	R12_PROVISION_GROSS ;
	private String	R13_S_NO  ;
	private String	R13_STAGES  ;
	private BigDecimal	R13_OUTSTANDING_NBFI  ;
	private BigDecimal	R13_PROVISION_NBFI  ;
	private BigDecimal	R13_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R13_PROVISION_FEDERAL ;
	private BigDecimal	R13_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R13_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R13_OUTSTANDING_EMIRATES ;
	private BigDecimal	R13_PROVISION_EMIRATES ;
	private BigDecimal	R13_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R13_PROVISION_GOVT_GROSS ;
	private BigDecimal	R13_OUTSTANDING_GRE ;
	private BigDecimal	R13_PROVISION_GRE ;
	private BigDecimal	R13_OUTSTANDING_CORPORATE ;
	private BigDecimal	R13_PROVISION_CORPORATE ;
	private BigDecimal	R13_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R13_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R13_OUTSTANDING_HIGH ;
	private BigDecimal	R13_PROVISION_HIGH ;
	private BigDecimal	R13_OUTSTANDING_SMALL ;
	private BigDecimal	R13_PROVISION_SMALL ;
	private BigDecimal	R13_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R13_PROVISION_INDIVIDUAL ;
	private BigDecimal	R13_OUTSTANDING_GROSS ;
	private BigDecimal	R13_PROVISION_GROSS ;
	private String	R14_S_NO  ;
	private String	R14_STAGES  ;
	private BigDecimal	R14_OUTSTANDING_NBFI  ;
	private BigDecimal	R14_PROVISION_NBFI  ;
	private BigDecimal	R14_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R14_PROVISION_FEDERAL ;
	private BigDecimal	R14_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R14_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R14_OUTSTANDING_EMIRATES ;
	private BigDecimal	R14_PROVISION_EMIRATES ;
	private BigDecimal	R14_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R14_PROVISION_GOVT_GROSS ;
	private BigDecimal	R14_OUTSTANDING_GRE ;
	private BigDecimal	R14_PROVISION_GRE ;
	private BigDecimal	R14_OUTSTANDING_CORPORATE ;
	private BigDecimal	R14_PROVISION_CORPORATE ;
	private BigDecimal	R14_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R14_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R14_OUTSTANDING_HIGH ;
	private BigDecimal	R14_PROVISION_HIGH ;
	private BigDecimal	R14_OUTSTANDING_SMALL ;
	private BigDecimal	R14_PROVISION_SMALL ;
	private BigDecimal	R14_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R14_PROVISION_INDIVIDUAL ;
	private BigDecimal	R14_OUTSTANDING_GROSS ;
	private BigDecimal	R14_PROVISION_GROSS ;
	private String	R15_S_NO  ;
	private String	R15_STAGES  ;
	private BigDecimal	R15_OUTSTANDING_NBFI  ;
	private BigDecimal	R15_PROVISION_NBFI  ;
	private BigDecimal	R15_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R15_PROVISION_FEDERAL ;
	private BigDecimal	R15_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R15_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R15_OUTSTANDING_EMIRATES ;
	private BigDecimal	R15_PROVISION_EMIRATES ;
	private BigDecimal	R15_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R15_PROVISION_GOVT_GROSS ;
	private BigDecimal	R15_OUTSTANDING_GRE ;
	private BigDecimal	R15_PROVISION_GRE ;
	private BigDecimal	R15_OUTSTANDING_CORPORATE ;
	private BigDecimal	R15_PROVISION_CORPORATE ;
	private BigDecimal	R15_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R15_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R15_OUTSTANDING_HIGH ;
	private BigDecimal	R15_PROVISION_HIGH ;
	private BigDecimal	R15_OUTSTANDING_SMALL ;
	private BigDecimal	R15_PROVISION_SMALL ;
	private BigDecimal	R15_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R15_PROVISION_INDIVIDUAL ;
	private BigDecimal	R15_OUTSTANDING_GROSS ;
	private BigDecimal	R15_PROVISION_GROSS ;
	private String	R16_S_NO  ;
	private String	R16_STAGES  ;
	private BigDecimal	R16_OUTSTANDING_NBFI  ;
	private BigDecimal	R16_PROVISION_NBFI  ;
	private BigDecimal	R16_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R16_PROVISION_FEDERAL ;
	private BigDecimal	R16_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R16_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R16_OUTSTANDING_EMIRATES ;
	private BigDecimal	R16_PROVISION_EMIRATES ;
	private BigDecimal	R16_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R16_PROVISION_GOVT_GROSS ;
	private BigDecimal	R16_OUTSTANDING_GRE ;
	private BigDecimal	R16_PROVISION_GRE ;
	private BigDecimal	R16_OUTSTANDING_CORPORATE ;
	private BigDecimal	R16_PROVISION_CORPORATE ;
	private BigDecimal	R16_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R16_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R16_OUTSTANDING_HIGH ;
	private BigDecimal	R16_PROVISION_HIGH ;
	private BigDecimal	R16_OUTSTANDING_SMALL ;
	private BigDecimal	R16_PROVISION_SMALL ;
	private BigDecimal	R16_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R16_PROVISION_INDIVIDUAL ;
	private BigDecimal	R16_OUTSTANDING_GROSS ;
	private BigDecimal	R16_PROVISION_GROSS ;
	private String	R17_S_NO  ;
	private String	R17_STAGES  ;
	private BigDecimal	R17_OUTSTANDING_NBFI  ;
	private BigDecimal	R17_PROVISION_NBFI  ;
	private BigDecimal	R17_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R17_PROVISION_FEDERAL ;
	private BigDecimal	R17_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R17_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R17_OUTSTANDING_EMIRATES ;
	private BigDecimal	R17_PROVISION_EMIRATES ;
	private BigDecimal	R17_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R17_PROVISION_GOVT_GROSS ;
	private BigDecimal	R17_OUTSTANDING_GRE ;
	private BigDecimal	R17_PROVISION_GRE ;
	private BigDecimal	R17_OUTSTANDING_CORPORATE ;
	private BigDecimal	R17_PROVISION_CORPORATE ;
	private BigDecimal	R17_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R17_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R17_OUTSTANDING_HIGH ;
	private BigDecimal	R17_PROVISION_HIGH ;
	private BigDecimal	R17_OUTSTANDING_SMALL ;
	private BigDecimal	R17_PROVISION_SMALL ;
	private BigDecimal	R17_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R17_PROVISION_INDIVIDUAL ;
	private BigDecimal	R17_OUTSTANDING_GROSS ;
	private BigDecimal	R17_PROVISION_GROSS ;
	private String	R18_S_NO  ;
	private String	R18_STAGES  ;
	private BigDecimal	R18_OUTSTANDING_NBFI  ;
	private BigDecimal	R18_PROVISION_NBFI  ;
	private BigDecimal	R18_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R18_PROVISION_FEDERAL ;
	private BigDecimal	R18_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R18_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R18_OUTSTANDING_EMIRATES ;
	private BigDecimal	R18_PROVISION_EMIRATES ;
	private BigDecimal	R18_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R18_PROVISION_GOVT_GROSS ;
	private BigDecimal	R18_OUTSTANDING_GRE ;
	private BigDecimal	R18_PROVISION_GRE ;
	private BigDecimal	R18_OUTSTANDING_CORPORATE ;
	private BigDecimal	R18_PROVISION_CORPORATE ;
	private BigDecimal	R18_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R18_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R18_OUTSTANDING_HIGH ;
	private BigDecimal	R18_PROVISION_HIGH ;
	private BigDecimal	R18_OUTSTANDING_SMALL ;
	private BigDecimal	R18_PROVISION_SMALL ;
	private BigDecimal	R18_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R18_PROVISION_INDIVIDUAL ;
	private BigDecimal	R18_OUTSTANDING_GROSS ;
	private BigDecimal	R18_PROVISION_GROSS ;
	private String	R19_S_NO  ;
	private String	R19_STAGES  ;
	private BigDecimal	R19_OUTSTANDING_NBFI  ;
	private BigDecimal	R19_PROVISION_NBFI  ;
	private BigDecimal	R19_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R19_PROVISION_FEDERAL ;
	private BigDecimal	R19_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R19_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R19_OUTSTANDING_EMIRATES ;
	private BigDecimal	R19_PROVISION_EMIRATES ;
	private BigDecimal	R19_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R19_PROVISION_GOVT_GROSS ;
	private BigDecimal	R19_OUTSTANDING_GRE ;
	private BigDecimal	R19_PROVISION_GRE ;
	private BigDecimal	R19_OUTSTANDING_CORPORATE ;
	private BigDecimal	R19_PROVISION_CORPORATE ;
	private BigDecimal	R19_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R19_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R19_OUTSTANDING_HIGH ;
	private BigDecimal	R19_PROVISION_HIGH ;
	private BigDecimal	R19_OUTSTANDING_SMALL ;
	private BigDecimal	R19_PROVISION_SMALL ;
	private BigDecimal	R19_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R19_PROVISION_INDIVIDUAL ;
	private BigDecimal	R19_OUTSTANDING_GROSS ;
	private BigDecimal	R19_PROVISION_GROSS ;
	private String	R20_S_NO  ;
	private String	R20_STAGES  ;
	private BigDecimal	R20_OUTSTANDING_NBFI  ;
	private BigDecimal	R20_PROVISION_NBFI  ;
	private BigDecimal	R20_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R20_PROVISION_FEDERAL ;
	private BigDecimal	R20_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R20_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R20_OUTSTANDING_EMIRATES ;
	private BigDecimal	R20_PROVISION_EMIRATES ;
	private BigDecimal	R20_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R20_PROVISION_GOVT_GROSS ;
	private BigDecimal	R20_OUTSTANDING_GRE ;
	private BigDecimal	R20_PROVISION_GRE ;
	private BigDecimal	R20_OUTSTANDING_CORPORATE ;
	private BigDecimal	R20_PROVISION_CORPORATE ;
	private BigDecimal	R20_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R20_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R20_OUTSTANDING_HIGH ;
	private BigDecimal	R20_PROVISION_HIGH ;
	private BigDecimal	R20_OUTSTANDING_SMALL ;
	private BigDecimal	R20_PROVISION_SMALL ;
	private BigDecimal	R20_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R20_PROVISION_INDIVIDUAL ;
	private BigDecimal	R20_OUTSTANDING_GROSS ;
	private BigDecimal	R20_PROVISION_GROSS ;
	private String	R21_S_NO  ;
	private String	R21_STAGES  ;
	private BigDecimal	R21_OUTSTANDING_NBFI  ;
	private BigDecimal	R21_PROVISION_NBFI  ;
	private BigDecimal	R21_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R21_PROVISION_FEDERAL ;
	private BigDecimal	R21_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R21_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R21_OUTSTANDING_EMIRATES ;
	private BigDecimal	R21_PROVISION_EMIRATES ;
	private BigDecimal	R21_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R21_PROVISION_GOVT_GROSS ;
	private BigDecimal	R21_OUTSTANDING_GRE ;
	private BigDecimal	R21_PROVISION_GRE ;
	private BigDecimal	R21_OUTSTANDING_CORPORATE ;
	private BigDecimal	R21_PROVISION_CORPORATE ;
	private BigDecimal	R21_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R21_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R21_OUTSTANDING_HIGH ;
	private BigDecimal	R21_PROVISION_HIGH ;
	private BigDecimal	R21_OUTSTANDING_SMALL ;
	private BigDecimal	R21_PROVISION_SMALL ;
	private BigDecimal	R21_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R21_PROVISION_INDIVIDUAL ;
	private BigDecimal	R21_OUTSTANDING_GROSS ;
	private BigDecimal	R21_PROVISION_GROSS ;
	private String	R22_S_NO  ;
	private String	R22_STAGES  ;
	private BigDecimal	R22_OUTSTANDING_NBFI  ;
	private BigDecimal	R22_PROVISION_NBFI  ;
	private BigDecimal	R22_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R22_PROVISION_FEDERAL ;
	private BigDecimal	R22_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R22_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R22_OUTSTANDING_EMIRATES ;
	private BigDecimal	R22_PROVISION_EMIRATES ;
	private BigDecimal	R22_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R22_PROVISION_GOVT_GROSS ;
	private BigDecimal	R22_OUTSTANDING_GRE ;
	private BigDecimal	R22_PROVISION_GRE ;
	private BigDecimal	R22_OUTSTANDING_CORPORATE ;
	private BigDecimal	R22_PROVISION_CORPORATE ;
	private BigDecimal	R22_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R22_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R22_OUTSTANDING_HIGH ;
	private BigDecimal	R22_PROVISION_HIGH ;
	private BigDecimal	R22_OUTSTANDING_SMALL ;
	private BigDecimal	R22_PROVISION_SMALL ;
	private BigDecimal	R22_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R22_PROVISION_INDIVIDUAL ;
	private BigDecimal	R22_OUTSTANDING_GROSS ;
	private BigDecimal	R22_PROVISION_GROSS ;
	private String	R23_S_NO  ;
	private String	R23_STAGES  ;
	private BigDecimal	R23_OUTSTANDING_NBFI  ;
	private BigDecimal	R23_PROVISION_NBFI  ;
	private BigDecimal	R23_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R23_PROVISION_FEDERAL ;
	private BigDecimal	R23_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R23_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R23_OUTSTANDING_EMIRATES ;
	private BigDecimal	R23_PROVISION_EMIRATES ;
	private BigDecimal	R23_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R23_PROVISION_GOVT_GROSS ;
	private BigDecimal	R23_OUTSTANDING_GRE ;
	private BigDecimal	R23_PROVISION_GRE ;
	private BigDecimal	R23_OUTSTANDING_CORPORATE ;
	private BigDecimal	R23_PROVISION_CORPORATE ;
	private BigDecimal	R23_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R23_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R23_OUTSTANDING_HIGH ;
	private BigDecimal	R23_PROVISION_HIGH ;
	private BigDecimal	R23_OUTSTANDING_SMALL ;
	private BigDecimal	R23_PROVISION_SMALL ;
	private BigDecimal	R23_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R23_PROVISION_INDIVIDUAL ;
	private BigDecimal	R23_OUTSTANDING_GROSS ;
	private BigDecimal	R23_PROVISION_GROSS ;
	private String	R24_S_NO  ;
	private String	R24_STAGES  ;
	private BigDecimal	R24_OUTSTANDING_NBFI  ;
	private BigDecimal	R24_PROVISION_NBFI  ;
	private BigDecimal	R24_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R24_PROVISION_FEDERAL ;
	private BigDecimal	R24_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R24_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R24_OUTSTANDING_EMIRATES ;
	private BigDecimal	R24_PROVISION_EMIRATES ;
	private BigDecimal	R24_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R24_PROVISION_GOVT_GROSS ;
	private BigDecimal	R24_OUTSTANDING_GRE ;
	private BigDecimal	R24_PROVISION_GRE ;
	private BigDecimal	R24_OUTSTANDING_CORPORATE ;
	private BigDecimal	R24_PROVISION_CORPORATE ;
	private BigDecimal	R24_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R24_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R24_OUTSTANDING_HIGH ;
	private BigDecimal	R24_PROVISION_HIGH ;
	private BigDecimal	R24_OUTSTANDING_SMALL ;
	private BigDecimal	R24_PROVISION_SMALL ;
	private BigDecimal	R24_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R24_PROVISION_INDIVIDUAL ;
	private BigDecimal	R24_OUTSTANDING_GROSS ;
	private BigDecimal	R24_PROVISION_GROSS ;
	private String	R25_S_NO  ;
	private String	R25_STAGES  ;
	private BigDecimal	R25_OUTSTANDING_NBFI  ;
	private BigDecimal	R25_PROVISION_NBFI  ;
	private BigDecimal	R25_OUTSTANDING_FEDERAL  ;
	private BigDecimal	R25_PROVISION_FEDERAL ;
	private BigDecimal	R25_OUTSTANDING_NON_COMMERCIAL ;
	private BigDecimal	R25_PROVISON_NON_COMMERCIAL ;
	private BigDecimal	R25_OUTSTANDING_EMIRATES ;
	private BigDecimal	R25_PROVISION_EMIRATES ;
	private BigDecimal	R25_OUTSTANDING_GOVT_GROSS ;
	private BigDecimal	R25_PROVISION_GOVT_GROSS ;
	private BigDecimal	R25_OUTSTANDING_GRE ;
	private BigDecimal	R25_PROVISION_GRE ;
	private BigDecimal	R25_OUTSTANDING_CORPORATE ;
	private BigDecimal	R25_PROVISION_CORPORATE ;
	private BigDecimal	R25_OUTSTANDING_OTHER_CORPORATE ;
	private BigDecimal	R25_PROVISION_OTHER_CORPORATE ;
	private BigDecimal	R25_OUTSTANDING_HIGH ;
	private BigDecimal	R25_PROVISION_HIGH ;
	private BigDecimal	R25_OUTSTANDING_SMALL ;
	private BigDecimal	R25_PROVISION_SMALL ;
	private BigDecimal	R25_OUTSTANDING_INDIVIDUAL ;
	private BigDecimal	R25_PROVISION_INDIVIDUAL ;
	private BigDecimal	R25_OUTSTANDING_GROSS ;
	private BigDecimal	R25_PROVISION_GROSS ;
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
	private String	repdesc;
	private String	frequency;
	public String getR1_S_NO() {
		return R1_S_NO;
	}
	public void setR1_S_NO(String r1_S_NO) {
		R1_S_NO = r1_S_NO;
	}
	public String getR1_STAGES() {
		return R1_STAGES;
	}
	public void setR1_STAGES(String r1_STAGES) {
		R1_STAGES = r1_STAGES;
	}
	public BigDecimal getR1_OUTSTANDING_NBFI() {
		return R1_OUTSTANDING_NBFI;
	}
	public void setR1_OUTSTANDING_NBFI(BigDecimal r1_OUTSTANDING_NBFI) {
		R1_OUTSTANDING_NBFI = r1_OUTSTANDING_NBFI;
	}
	public BigDecimal getR1_PROVISION_NBFI() {
		return R1_PROVISION_NBFI;
	}
	public void setR1_PROVISION_NBFI(BigDecimal r1_PROVISION_NBFI) {
		R1_PROVISION_NBFI = r1_PROVISION_NBFI;
	}
	public BigDecimal getR1_OUTSTANDING_FEDERAL() {
		return R1_OUTSTANDING_FEDERAL;
	}
	public void setR1_OUTSTANDING_FEDERAL(BigDecimal r1_OUTSTANDING_FEDERAL) {
		R1_OUTSTANDING_FEDERAL = r1_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR1_PROVISION_FEDERAL() {
		return R1_PROVISION_FEDERAL;
	}
	public void setR1_PROVISION_FEDERAL(BigDecimal r1_PROVISION_FEDERAL) {
		R1_PROVISION_FEDERAL = r1_PROVISION_FEDERAL;
	}
	public BigDecimal getR1_OUTSTANDING_NON_COMMERCIAL() {
		return R1_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR1_OUTSTANDING_NON_COMMERCIAL(BigDecimal r1_OUTSTANDING_NON_COMMERCIAL) {
		R1_OUTSTANDING_NON_COMMERCIAL = r1_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR1_PROVISON_NON_COMMERCIAL() {
		return R1_PROVISON_NON_COMMERCIAL;
	}
	public void setR1_PROVISON_NON_COMMERCIAL(BigDecimal r1_PROVISON_NON_COMMERCIAL) {
		R1_PROVISON_NON_COMMERCIAL = r1_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR1_OUTSTANDING_EMIRATES() {
		return R1_OUTSTANDING_EMIRATES;
	}
	public void setR1_OUTSTANDING_EMIRATES(BigDecimal r1_OUTSTANDING_EMIRATES) {
		R1_OUTSTANDING_EMIRATES = r1_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR1_PROVISION_EMIRATES() {
		return R1_PROVISION_EMIRATES;
	}
	public void setR1_PROVISION_EMIRATES(BigDecimal r1_PROVISION_EMIRATES) {
		R1_PROVISION_EMIRATES = r1_PROVISION_EMIRATES;
	}
	public BigDecimal getR1_OUTSTANDING_GOVT_GROSS() {
		return R1_OUTSTANDING_GOVT_GROSS;
	}
	public void setR1_OUTSTANDING_GOVT_GROSS(BigDecimal r1_OUTSTANDING_GOVT_GROSS) {
		R1_OUTSTANDING_GOVT_GROSS = r1_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR1_PROVISION_GOVT_GROSS() {
		return R1_PROVISION_GOVT_GROSS;
	}
	public void setR1_PROVISION_GOVT_GROSS(BigDecimal r1_PROVISION_GOVT_GROSS) {
		R1_PROVISION_GOVT_GROSS = r1_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR1_OUTSTANDING_GRE() {
		return R1_OUTSTANDING_GRE;
	}
	public void setR1_OUTSTANDING_GRE(BigDecimal r1_OUTSTANDING_GRE) {
		R1_OUTSTANDING_GRE = r1_OUTSTANDING_GRE;
	}
	public BigDecimal getR1_PROVISION_GRE() {
		return R1_PROVISION_GRE;
	}
	public void setR1_PROVISION_GRE(BigDecimal r1_PROVISION_GRE) {
		R1_PROVISION_GRE = r1_PROVISION_GRE;
	}
	public BigDecimal getR1_OUTSTANDING_CORPORATE() {
		return R1_OUTSTANDING_CORPORATE;
	}
	public void setR1_OUTSTANDING_CORPORATE(BigDecimal r1_OUTSTANDING_CORPORATE) {
		R1_OUTSTANDING_CORPORATE = r1_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR1_PROVISION_CORPORATE() {
		return R1_PROVISION_CORPORATE;
	}
	public void setR1_PROVISION_CORPORATE(BigDecimal r1_PROVISION_CORPORATE) {
		R1_PROVISION_CORPORATE = r1_PROVISION_CORPORATE;
	}
	public BigDecimal getR1_OUTSTANDING_OTHER_CORPORATE() {
		return R1_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR1_OUTSTANDING_OTHER_CORPORATE(BigDecimal r1_OUTSTANDING_OTHER_CORPORATE) {
		R1_OUTSTANDING_OTHER_CORPORATE = r1_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR1_PROVISION_OTHER_CORPORATE() {
		return R1_PROVISION_OTHER_CORPORATE;
	}
	public void setR1_PROVISION_OTHER_CORPORATE(BigDecimal r1_PROVISION_OTHER_CORPORATE) {
		R1_PROVISION_OTHER_CORPORATE = r1_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR1_OUTSTANDING_HIGH() {
		return R1_OUTSTANDING_HIGH;
	}
	public void setR1_OUTSTANDING_HIGH(BigDecimal r1_OUTSTANDING_HIGH) {
		R1_OUTSTANDING_HIGH = r1_OUTSTANDING_HIGH;
	}
	public BigDecimal getR1_PROVISION_HIGH() {
		return R1_PROVISION_HIGH;
	}
	public void setR1_PROVISION_HIGH(BigDecimal r1_PROVISION_HIGH) {
		R1_PROVISION_HIGH = r1_PROVISION_HIGH;
	}
	public BigDecimal getR1_OUTSTANDING_SMALL() {
		return R1_OUTSTANDING_SMALL;
	}
	public void setR1_OUTSTANDING_SMALL(BigDecimal r1_OUTSTANDING_SMALL) {
		R1_OUTSTANDING_SMALL = r1_OUTSTANDING_SMALL;
	}
	public BigDecimal getR1_PROVISION_SMALL() {
		return R1_PROVISION_SMALL;
	}
	public void setR1_PROVISION_SMALL(BigDecimal r1_PROVISION_SMALL) {
		R1_PROVISION_SMALL = r1_PROVISION_SMALL;
	}
	public BigDecimal getR1_OUTSTANDING_INDIVIDUAL() {
		return R1_OUTSTANDING_INDIVIDUAL;
	}
	public void setR1_OUTSTANDING_INDIVIDUAL(BigDecimal r1_OUTSTANDING_INDIVIDUAL) {
		R1_OUTSTANDING_INDIVIDUAL = r1_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR1_PROVISION_INDIVIDUAL() {
		return R1_PROVISION_INDIVIDUAL;
	}
	public void setR1_PROVISION_INDIVIDUAL(BigDecimal r1_PROVISION_INDIVIDUAL) {
		R1_PROVISION_INDIVIDUAL = r1_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR1_OUTSTANDING_GROSS() {
		return R1_OUTSTANDING_GROSS;
	}
	public void setR1_OUTSTANDING_GROSS(BigDecimal r1_OUTSTANDING_GROSS) {
		R1_OUTSTANDING_GROSS = r1_OUTSTANDING_GROSS;
	}
	public BigDecimal getR1_PROVISION_GROSS() {
		return R1_PROVISION_GROSS;
	}
	public void setR1_PROVISION_GROSS(BigDecimal r1_PROVISION_GROSS) {
		R1_PROVISION_GROSS = r1_PROVISION_GROSS;
	}
	public String getR2_S_NO() {
		return R2_S_NO;
	}
	public void setR2_S_NO(String r2_S_NO) {
		R2_S_NO = r2_S_NO;
	}
	public String getR2_STAGES() {
		return R2_STAGES;
	}
	public void setR2_STAGES(String r2_STAGES) {
		R2_STAGES = r2_STAGES;
	}
	public BigDecimal getR2_OUTSTANDING_NBFI() {
		return R2_OUTSTANDING_NBFI;
	}
	public void setR2_OUTSTANDING_NBFI(BigDecimal r2_OUTSTANDING_NBFI) {
		R2_OUTSTANDING_NBFI = r2_OUTSTANDING_NBFI;
	}
	public BigDecimal getR2_PROVISION_NBFI() {
		return R2_PROVISION_NBFI;
	}
	public void setR2_PROVISION_NBFI(BigDecimal r2_PROVISION_NBFI) {
		R2_PROVISION_NBFI = r2_PROVISION_NBFI;
	}
	public BigDecimal getR2_OUTSTANDING_FEDERAL() {
		return R2_OUTSTANDING_FEDERAL;
	}
	public void setR2_OUTSTANDING_FEDERAL(BigDecimal r2_OUTSTANDING_FEDERAL) {
		R2_OUTSTANDING_FEDERAL = r2_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR2_PROVISION_FEDERAL() {
		return R2_PROVISION_FEDERAL;
	}
	public void setR2_PROVISION_FEDERAL(BigDecimal r2_PROVISION_FEDERAL) {
		R2_PROVISION_FEDERAL = r2_PROVISION_FEDERAL;
	}
	public BigDecimal getR2_OUTSTANDING_NON_COMMERCIAL() {
		return R2_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR2_OUTSTANDING_NON_COMMERCIAL(BigDecimal r2_OUTSTANDING_NON_COMMERCIAL) {
		R2_OUTSTANDING_NON_COMMERCIAL = r2_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR2_PROVISON_NON_COMMERCIAL() {
		return R2_PROVISON_NON_COMMERCIAL;
	}
	public void setR2_PROVISON_NON_COMMERCIAL(BigDecimal r2_PROVISON_NON_COMMERCIAL) {
		R2_PROVISON_NON_COMMERCIAL = r2_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR2_OUTSTANDING_EMIRATES() {
		return R2_OUTSTANDING_EMIRATES;
	}
	public void setR2_OUTSTANDING_EMIRATES(BigDecimal r2_OUTSTANDING_EMIRATES) {
		R2_OUTSTANDING_EMIRATES = r2_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR2_PROVISION_EMIRATES() {
		return R2_PROVISION_EMIRATES;
	}
	public void setR2_PROVISION_EMIRATES(BigDecimal r2_PROVISION_EMIRATES) {
		R2_PROVISION_EMIRATES = r2_PROVISION_EMIRATES;
	}
	public BigDecimal getR2_OUTSTANDING_GOVT_GROSS() {
		return R2_OUTSTANDING_GOVT_GROSS;
	}
	public void setR2_OUTSTANDING_GOVT_GROSS(BigDecimal r2_OUTSTANDING_GOVT_GROSS) {
		R2_OUTSTANDING_GOVT_GROSS = r2_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR2_PROVISION_GOVT_GROSS() {
		return R2_PROVISION_GOVT_GROSS;
	}
	public void setR2_PROVISION_GOVT_GROSS(BigDecimal r2_PROVISION_GOVT_GROSS) {
		R2_PROVISION_GOVT_GROSS = r2_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR2_OUTSTANDING_GRE() {
		return R2_OUTSTANDING_GRE;
	}
	public void setR2_OUTSTANDING_GRE(BigDecimal r2_OUTSTANDING_GRE) {
		R2_OUTSTANDING_GRE = r2_OUTSTANDING_GRE;
	}
	public BigDecimal getR2_PROVISION_GRE() {
		return R2_PROVISION_GRE;
	}
	public void setR2_PROVISION_GRE(BigDecimal r2_PROVISION_GRE) {
		R2_PROVISION_GRE = r2_PROVISION_GRE;
	}
	public BigDecimal getR2_OUTSTANDING_CORPORATE() {
		return R2_OUTSTANDING_CORPORATE;
	}
	public void setR2_OUTSTANDING_CORPORATE(BigDecimal r2_OUTSTANDING_CORPORATE) {
		R2_OUTSTANDING_CORPORATE = r2_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR2_PROVISION_CORPORATE() {
		return R2_PROVISION_CORPORATE;
	}
	public void setR2_PROVISION_CORPORATE(BigDecimal r2_PROVISION_CORPORATE) {
		R2_PROVISION_CORPORATE = r2_PROVISION_CORPORATE;
	}
	public BigDecimal getR2_OUTSTANDING_OTHER_CORPORATE() {
		return R2_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR2_OUTSTANDING_OTHER_CORPORATE(BigDecimal r2_OUTSTANDING_OTHER_CORPORATE) {
		R2_OUTSTANDING_OTHER_CORPORATE = r2_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR2_PROVISION_OTHER_CORPORATE() {
		return R2_PROVISION_OTHER_CORPORATE;
	}
	public void setR2_PROVISION_OTHER_CORPORATE(BigDecimal r2_PROVISION_OTHER_CORPORATE) {
		R2_PROVISION_OTHER_CORPORATE = r2_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR2_OUTSTANDING_HIGH() {
		return R2_OUTSTANDING_HIGH;
	}
	public void setR2_OUTSTANDING_HIGH(BigDecimal r2_OUTSTANDING_HIGH) {
		R2_OUTSTANDING_HIGH = r2_OUTSTANDING_HIGH;
	}
	public BigDecimal getR2_PROVISION_HIGH() {
		return R2_PROVISION_HIGH;
	}
	public void setR2_PROVISION_HIGH(BigDecimal r2_PROVISION_HIGH) {
		R2_PROVISION_HIGH = r2_PROVISION_HIGH;
	}
	public BigDecimal getR2_OUTSTANDING_SMALL() {
		return R2_OUTSTANDING_SMALL;
	}
	public void setR2_OUTSTANDING_SMALL(BigDecimal r2_OUTSTANDING_SMALL) {
		R2_OUTSTANDING_SMALL = r2_OUTSTANDING_SMALL;
	}
	public BigDecimal getR2_PROVISION_SMALL() {
		return R2_PROVISION_SMALL;
	}
	public void setR2_PROVISION_SMALL(BigDecimal r2_PROVISION_SMALL) {
		R2_PROVISION_SMALL = r2_PROVISION_SMALL;
	}
	public BigDecimal getR2_OUTSTANDING_INDIVIDUAL() {
		return R2_OUTSTANDING_INDIVIDUAL;
	}
	public void setR2_OUTSTANDING_INDIVIDUAL(BigDecimal r2_OUTSTANDING_INDIVIDUAL) {
		R2_OUTSTANDING_INDIVIDUAL = r2_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR2_PROVISION_INDIVIDUAL() {
		return R2_PROVISION_INDIVIDUAL;
	}
	public void setR2_PROVISION_INDIVIDUAL(BigDecimal r2_PROVISION_INDIVIDUAL) {
		R2_PROVISION_INDIVIDUAL = r2_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR2_OUTSTANDING_GROSS() {
		return R2_OUTSTANDING_GROSS;
	}
	public void setR2_OUTSTANDING_GROSS(BigDecimal r2_OUTSTANDING_GROSS) {
		R2_OUTSTANDING_GROSS = r2_OUTSTANDING_GROSS;
	}
	public BigDecimal getR2_PROVISION_GROSS() {
		return R2_PROVISION_GROSS;
	}
	public void setR2_PROVISION_GROSS(BigDecimal r2_PROVISION_GROSS) {
		R2_PROVISION_GROSS = r2_PROVISION_GROSS;
	}
	public String getR3_S_NO() {
		return R3_S_NO;
	}
	public void setR3_S_NO(String r3_S_NO) {
		R3_S_NO = r3_S_NO;
	}
	public String getR3_STAGES() {
		return R3_STAGES;
	}
	public void setR3_STAGES(String r3_STAGES) {
		R3_STAGES = r3_STAGES;
	}
	public BigDecimal getR3_OUTSTANDING_NBFI() {
		return R3_OUTSTANDING_NBFI;
	}
	public void setR3_OUTSTANDING_NBFI(BigDecimal r3_OUTSTANDING_NBFI) {
		R3_OUTSTANDING_NBFI = r3_OUTSTANDING_NBFI;
	}
	public BigDecimal getR3_PROVISION_NBFI() {
		return R3_PROVISION_NBFI;
	}
	public void setR3_PROVISION_NBFI(BigDecimal r3_PROVISION_NBFI) {
		R3_PROVISION_NBFI = r3_PROVISION_NBFI;
	}
	public BigDecimal getR3_OUTSTANDING_FEDERAL() {
		return R3_OUTSTANDING_FEDERAL;
	}
	public void setR3_OUTSTANDING_FEDERAL(BigDecimal r3_OUTSTANDING_FEDERAL) {
		R3_OUTSTANDING_FEDERAL = r3_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR3_PROVISION_FEDERAL() {
		return R3_PROVISION_FEDERAL;
	}
	public void setR3_PROVISION_FEDERAL(BigDecimal r3_PROVISION_FEDERAL) {
		R3_PROVISION_FEDERAL = r3_PROVISION_FEDERAL;
	}
	public BigDecimal getR3_OUTSTANDING_NON_COMMERCIAL() {
		return R3_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR3_OUTSTANDING_NON_COMMERCIAL(BigDecimal r3_OUTSTANDING_NON_COMMERCIAL) {
		R3_OUTSTANDING_NON_COMMERCIAL = r3_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR3_PROVISON_NON_COMMERCIAL() {
		return R3_PROVISON_NON_COMMERCIAL;
	}
	public void setR3_PROVISON_NON_COMMERCIAL(BigDecimal r3_PROVISON_NON_COMMERCIAL) {
		R3_PROVISON_NON_COMMERCIAL = r3_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR3_OUTSTANDING_EMIRATES() {
		return R3_OUTSTANDING_EMIRATES;
	}
	public void setR3_OUTSTANDING_EMIRATES(BigDecimal r3_OUTSTANDING_EMIRATES) {
		R3_OUTSTANDING_EMIRATES = r3_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR3_PROVISION_EMIRATES() {
		return R3_PROVISION_EMIRATES;
	}
	public void setR3_PROVISION_EMIRATES(BigDecimal r3_PROVISION_EMIRATES) {
		R3_PROVISION_EMIRATES = r3_PROVISION_EMIRATES;
	}
	public BigDecimal getR3_OUTSTANDING_GOVT_GROSS() {
		return R3_OUTSTANDING_GOVT_GROSS;
	}
	public void setR3_OUTSTANDING_GOVT_GROSS(BigDecimal r3_OUTSTANDING_GOVT_GROSS) {
		R3_OUTSTANDING_GOVT_GROSS = r3_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR3_PROVISION_GOVT_GROSS() {
		return R3_PROVISION_GOVT_GROSS;
	}
	public void setR3_PROVISION_GOVT_GROSS(BigDecimal r3_PROVISION_GOVT_GROSS) {
		R3_PROVISION_GOVT_GROSS = r3_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR3_OUTSTANDING_GRE() {
		return R3_OUTSTANDING_GRE;
	}
	public void setR3_OUTSTANDING_GRE(BigDecimal r3_OUTSTANDING_GRE) {
		R3_OUTSTANDING_GRE = r3_OUTSTANDING_GRE;
	}
	public BigDecimal getR3_PROVISION_GRE() {
		return R3_PROVISION_GRE;
	}
	public void setR3_PROVISION_GRE(BigDecimal r3_PROVISION_GRE) {
		R3_PROVISION_GRE = r3_PROVISION_GRE;
	}
	public BigDecimal getR3_OUTSTANDING_CORPORATE() {
		return R3_OUTSTANDING_CORPORATE;
	}
	public void setR3_OUTSTANDING_CORPORATE(BigDecimal r3_OUTSTANDING_CORPORATE) {
		R3_OUTSTANDING_CORPORATE = r3_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR3_PROVISION_CORPORATE() {
		return R3_PROVISION_CORPORATE;
	}
	public void setR3_PROVISION_CORPORATE(BigDecimal r3_PROVISION_CORPORATE) {
		R3_PROVISION_CORPORATE = r3_PROVISION_CORPORATE;
	}
	public BigDecimal getR3_OUTSTANDING_OTHER_CORPORATE() {
		return R3_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR3_OUTSTANDING_OTHER_CORPORATE(BigDecimal r3_OUTSTANDING_OTHER_CORPORATE) {
		R3_OUTSTANDING_OTHER_CORPORATE = r3_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR3_PROVISION_OTHER_CORPORATE() {
		return R3_PROVISION_OTHER_CORPORATE;
	}
	public void setR3_PROVISION_OTHER_CORPORATE(BigDecimal r3_PROVISION_OTHER_CORPORATE) {
		R3_PROVISION_OTHER_CORPORATE = r3_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR3_OUTSTANDING_HIGH() {
		return R3_OUTSTANDING_HIGH;
	}
	public void setR3_OUTSTANDING_HIGH(BigDecimal r3_OUTSTANDING_HIGH) {
		R3_OUTSTANDING_HIGH = r3_OUTSTANDING_HIGH;
	}
	public BigDecimal getR3_PROVISION_HIGH() {
		return R3_PROVISION_HIGH;
	}
	public void setR3_PROVISION_HIGH(BigDecimal r3_PROVISION_HIGH) {
		R3_PROVISION_HIGH = r3_PROVISION_HIGH;
	}
	public BigDecimal getR3_OUTSTANDING_SMALL() {
		return R3_OUTSTANDING_SMALL;
	}
	public void setR3_OUTSTANDING_SMALL(BigDecimal r3_OUTSTANDING_SMALL) {
		R3_OUTSTANDING_SMALL = r3_OUTSTANDING_SMALL;
	}
	public BigDecimal getR3_PROVISION_SMALL() {
		return R3_PROVISION_SMALL;
	}
	public void setR3_PROVISION_SMALL(BigDecimal r3_PROVISION_SMALL) {
		R3_PROVISION_SMALL = r3_PROVISION_SMALL;
	}
	public BigDecimal getR3_OUTSTANDING_INDIVIDUAL() {
		return R3_OUTSTANDING_INDIVIDUAL;
	}
	public void setR3_OUTSTANDING_INDIVIDUAL(BigDecimal r3_OUTSTANDING_INDIVIDUAL) {
		R3_OUTSTANDING_INDIVIDUAL = r3_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR3_PROVISION_INDIVIDUAL() {
		return R3_PROVISION_INDIVIDUAL;
	}
	public void setR3_PROVISION_INDIVIDUAL(BigDecimal r3_PROVISION_INDIVIDUAL) {
		R3_PROVISION_INDIVIDUAL = r3_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR3_OUTSTANDING_GROSS() {
		return R3_OUTSTANDING_GROSS;
	}
	public void setR3_OUTSTANDING_GROSS(BigDecimal r3_OUTSTANDING_GROSS) {
		R3_OUTSTANDING_GROSS = r3_OUTSTANDING_GROSS;
	}
	public BigDecimal getR3_PROVISION_GROSS() {
		return R3_PROVISION_GROSS;
	}
	public void setR3_PROVISION_GROSS(BigDecimal r3_PROVISION_GROSS) {
		R3_PROVISION_GROSS = r3_PROVISION_GROSS;
	}
	public String getR4_S_NO() {
		return R4_S_NO;
	}
	public void setR4_S_NO(String r4_S_NO) {
		R4_S_NO = r4_S_NO;
	}
	public String getR4_STAGES() {
		return R4_STAGES;
	}
	public void setR4_STAGES(String r4_STAGES) {
		R4_STAGES = r4_STAGES;
	}
	public BigDecimal getR4_OUTSTANDING_NBFI() {
		return R4_OUTSTANDING_NBFI;
	}
	public void setR4_OUTSTANDING_NBFI(BigDecimal r4_OUTSTANDING_NBFI) {
		R4_OUTSTANDING_NBFI = r4_OUTSTANDING_NBFI;
	}
	public BigDecimal getR4_PROVISION_NBFI() {
		return R4_PROVISION_NBFI;
	}
	public void setR4_PROVISION_NBFI(BigDecimal r4_PROVISION_NBFI) {
		R4_PROVISION_NBFI = r4_PROVISION_NBFI;
	}
	public BigDecimal getR4_OUTSTANDING_FEDERAL() {
		return R4_OUTSTANDING_FEDERAL;
	}
	public void setR4_OUTSTANDING_FEDERAL(BigDecimal r4_OUTSTANDING_FEDERAL) {
		R4_OUTSTANDING_FEDERAL = r4_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR4_PROVISION_FEDERAL() {
		return R4_PROVISION_FEDERAL;
	}
	public void setR4_PROVISION_FEDERAL(BigDecimal r4_PROVISION_FEDERAL) {
		R4_PROVISION_FEDERAL = r4_PROVISION_FEDERAL;
	}
	public BigDecimal getR4_OUTSTANDING_NON_COMMERCIAL() {
		return R4_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR4_OUTSTANDING_NON_COMMERCIAL(BigDecimal r4_OUTSTANDING_NON_COMMERCIAL) {
		R4_OUTSTANDING_NON_COMMERCIAL = r4_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR4_PROVISON_NON_COMMERCIAL() {
		return R4_PROVISON_NON_COMMERCIAL;
	}
	public void setR4_PROVISON_NON_COMMERCIAL(BigDecimal r4_PROVISON_NON_COMMERCIAL) {
		R4_PROVISON_NON_COMMERCIAL = r4_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR4_OUTSTANDING_EMIRATES() {
		return R4_OUTSTANDING_EMIRATES;
	}
	public void setR4_OUTSTANDING_EMIRATES(BigDecimal r4_OUTSTANDING_EMIRATES) {
		R4_OUTSTANDING_EMIRATES = r4_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR4_PROVISION_EMIRATES() {
		return R4_PROVISION_EMIRATES;
	}
	public void setR4_PROVISION_EMIRATES(BigDecimal r4_PROVISION_EMIRATES) {
		R4_PROVISION_EMIRATES = r4_PROVISION_EMIRATES;
	}
	public BigDecimal getR4_OUTSTANDING_GOVT_GROSS() {
		return R4_OUTSTANDING_GOVT_GROSS;
	}
	public void setR4_OUTSTANDING_GOVT_GROSS(BigDecimal r4_OUTSTANDING_GOVT_GROSS) {
		R4_OUTSTANDING_GOVT_GROSS = r4_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR4_PROVISION_GOVT_GROSS() {
		return R4_PROVISION_GOVT_GROSS;
	}
	public void setR4_PROVISION_GOVT_GROSS(BigDecimal r4_PROVISION_GOVT_GROSS) {
		R4_PROVISION_GOVT_GROSS = r4_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR4_OUTSTANDING_GRE() {
		return R4_OUTSTANDING_GRE;
	}
	public void setR4_OUTSTANDING_GRE(BigDecimal r4_OUTSTANDING_GRE) {
		R4_OUTSTANDING_GRE = r4_OUTSTANDING_GRE;
	}
	public BigDecimal getR4_PROVISION_GRE() {
		return R4_PROVISION_GRE;
	}
	public void setR4_PROVISION_GRE(BigDecimal r4_PROVISION_GRE) {
		R4_PROVISION_GRE = r4_PROVISION_GRE;
	}
	public BigDecimal getR4_OUTSTANDING_CORPORATE() {
		return R4_OUTSTANDING_CORPORATE;
	}
	public void setR4_OUTSTANDING_CORPORATE(BigDecimal r4_OUTSTANDING_CORPORATE) {
		R4_OUTSTANDING_CORPORATE = r4_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR4_PROVISION_CORPORATE() {
		return R4_PROVISION_CORPORATE;
	}
	public void setR4_PROVISION_CORPORATE(BigDecimal r4_PROVISION_CORPORATE) {
		R4_PROVISION_CORPORATE = r4_PROVISION_CORPORATE;
	}
	public BigDecimal getR4_OUTSTANDING_OTHER_CORPORATE() {
		return R4_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR4_OUTSTANDING_OTHER_CORPORATE(BigDecimal r4_OUTSTANDING_OTHER_CORPORATE) {
		R4_OUTSTANDING_OTHER_CORPORATE = r4_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR4_PROVISION_OTHER_CORPORATE() {
		return R4_PROVISION_OTHER_CORPORATE;
	}
	public void setR4_PROVISION_OTHER_CORPORATE(BigDecimal r4_PROVISION_OTHER_CORPORATE) {
		R4_PROVISION_OTHER_CORPORATE = r4_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR4_OUTSTANDING_HIGH() {
		return R4_OUTSTANDING_HIGH;
	}
	public void setR4_OUTSTANDING_HIGH(BigDecimal r4_OUTSTANDING_HIGH) {
		R4_OUTSTANDING_HIGH = r4_OUTSTANDING_HIGH;
	}
	public BigDecimal getR4_PROVISION_HIGH() {
		return R4_PROVISION_HIGH;
	}
	public void setR4_PROVISION_HIGH(BigDecimal r4_PROVISION_HIGH) {
		R4_PROVISION_HIGH = r4_PROVISION_HIGH;
	}
	public BigDecimal getR4_OUTSTANDING_SMALL() {
		return R4_OUTSTANDING_SMALL;
	}
	public void setR4_OUTSTANDING_SMALL(BigDecimal r4_OUTSTANDING_SMALL) {
		R4_OUTSTANDING_SMALL = r4_OUTSTANDING_SMALL;
	}
	public BigDecimal getR4_PROVISION_SMALL() {
		return R4_PROVISION_SMALL;
	}
	public void setR4_PROVISION_SMALL(BigDecimal r4_PROVISION_SMALL) {
		R4_PROVISION_SMALL = r4_PROVISION_SMALL;
	}
	public BigDecimal getR4_OUTSTANDING_INDIVIDUAL() {
		return R4_OUTSTANDING_INDIVIDUAL;
	}
	public void setR4_OUTSTANDING_INDIVIDUAL(BigDecimal r4_OUTSTANDING_INDIVIDUAL) {
		R4_OUTSTANDING_INDIVIDUAL = r4_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR4_PROVISION_INDIVIDUAL() {
		return R4_PROVISION_INDIVIDUAL;
	}
	public void setR4_PROVISION_INDIVIDUAL(BigDecimal r4_PROVISION_INDIVIDUAL) {
		R4_PROVISION_INDIVIDUAL = r4_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR4_OUTSTANDING_GROSS() {
		return R4_OUTSTANDING_GROSS;
	}
	public void setR4_OUTSTANDING_GROSS(BigDecimal r4_OUTSTANDING_GROSS) {
		R4_OUTSTANDING_GROSS = r4_OUTSTANDING_GROSS;
	}
	public BigDecimal getR4_PROVISION_GROSS() {
		return R4_PROVISION_GROSS;
	}
	public void setR4_PROVISION_GROSS(BigDecimal r4_PROVISION_GROSS) {
		R4_PROVISION_GROSS = r4_PROVISION_GROSS;
	}
	public String getR5_S_NO() {
		return R5_S_NO;
	}
	public void setR5_S_NO(String r5_S_NO) {
		R5_S_NO = r5_S_NO;
	}
	public String getR5_STAGES() {
		return R5_STAGES;
	}
	public void setR5_STAGES(String r5_STAGES) {
		R5_STAGES = r5_STAGES;
	}
	public BigDecimal getR5_OUTSTANDING_NBFI() {
		return R5_OUTSTANDING_NBFI;
	}
	public void setR5_OUTSTANDING_NBFI(BigDecimal r5_OUTSTANDING_NBFI) {
		R5_OUTSTANDING_NBFI = r5_OUTSTANDING_NBFI;
	}
	public BigDecimal getR5_PROVISION_NBFI() {
		return R5_PROVISION_NBFI;
	}
	public void setR5_PROVISION_NBFI(BigDecimal r5_PROVISION_NBFI) {
		R5_PROVISION_NBFI = r5_PROVISION_NBFI;
	}
	public BigDecimal getR5_OUTSTANDING_FEDERAL() {
		return R5_OUTSTANDING_FEDERAL;
	}
	public void setR5_OUTSTANDING_FEDERAL(BigDecimal r5_OUTSTANDING_FEDERAL) {
		R5_OUTSTANDING_FEDERAL = r5_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR5_PROVISION_FEDERAL() {
		return R5_PROVISION_FEDERAL;
	}
	public void setR5_PROVISION_FEDERAL(BigDecimal r5_PROVISION_FEDERAL) {
		R5_PROVISION_FEDERAL = r5_PROVISION_FEDERAL;
	}
	public BigDecimal getR5_OUTSTANDING_NON_COMMERCIAL() {
		return R5_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR5_OUTSTANDING_NON_COMMERCIAL(BigDecimal r5_OUTSTANDING_NON_COMMERCIAL) {
		R5_OUTSTANDING_NON_COMMERCIAL = r5_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR5_PROVISON_NON_COMMERCIAL() {
		return R5_PROVISON_NON_COMMERCIAL;
	}
	public void setR5_PROVISON_NON_COMMERCIAL(BigDecimal r5_PROVISON_NON_COMMERCIAL) {
		R5_PROVISON_NON_COMMERCIAL = r5_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR5_OUTSTANDING_EMIRATES() {
		return R5_OUTSTANDING_EMIRATES;
	}
	public void setR5_OUTSTANDING_EMIRATES(BigDecimal r5_OUTSTANDING_EMIRATES) {
		R5_OUTSTANDING_EMIRATES = r5_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR5_PROVISION_EMIRATES() {
		return R5_PROVISION_EMIRATES;
	}
	public void setR5_PROVISION_EMIRATES(BigDecimal r5_PROVISION_EMIRATES) {
		R5_PROVISION_EMIRATES = r5_PROVISION_EMIRATES;
	}
	public BigDecimal getR5_OUTSTANDING_GOVT_GROSS() {
		return R5_OUTSTANDING_GOVT_GROSS;
	}
	public void setR5_OUTSTANDING_GOVT_GROSS(BigDecimal r5_OUTSTANDING_GOVT_GROSS) {
		R5_OUTSTANDING_GOVT_GROSS = r5_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR5_PROVISION_GOVT_GROSS() {
		return R5_PROVISION_GOVT_GROSS;
	}
	public void setR5_PROVISION_GOVT_GROSS(BigDecimal r5_PROVISION_GOVT_GROSS) {
		R5_PROVISION_GOVT_GROSS = r5_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR5_OUTSTANDING_GRE() {
		return R5_OUTSTANDING_GRE;
	}
	public void setR5_OUTSTANDING_GRE(BigDecimal r5_OUTSTANDING_GRE) {
		R5_OUTSTANDING_GRE = r5_OUTSTANDING_GRE;
	}
	public BigDecimal getR5_PROVISION_GRE() {
		return R5_PROVISION_GRE;
	}
	public void setR5_PROVISION_GRE(BigDecimal r5_PROVISION_GRE) {
		R5_PROVISION_GRE = r5_PROVISION_GRE;
	}
	public BigDecimal getR5_OUTSTANDING_CORPORATE() {
		return R5_OUTSTANDING_CORPORATE;
	}
	public void setR5_OUTSTANDING_CORPORATE(BigDecimal r5_OUTSTANDING_CORPORATE) {
		R5_OUTSTANDING_CORPORATE = r5_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR5_PROVISION_CORPORATE() {
		return R5_PROVISION_CORPORATE;
	}
	public void setR5_PROVISION_CORPORATE(BigDecimal r5_PROVISION_CORPORATE) {
		R5_PROVISION_CORPORATE = r5_PROVISION_CORPORATE;
	}
	public BigDecimal getR5_OUTSTANDING_OTHER_CORPORATE() {
		return R5_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR5_OUTSTANDING_OTHER_CORPORATE(BigDecimal r5_OUTSTANDING_OTHER_CORPORATE) {
		R5_OUTSTANDING_OTHER_CORPORATE = r5_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR5_PROVISION_OTHER_CORPORATE() {
		return R5_PROVISION_OTHER_CORPORATE;
	}
	public void setR5_PROVISION_OTHER_CORPORATE(BigDecimal r5_PROVISION_OTHER_CORPORATE) {
		R5_PROVISION_OTHER_CORPORATE = r5_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR5_OUTSTANDING_HIGH() {
		return R5_OUTSTANDING_HIGH;
	}
	public void setR5_OUTSTANDING_HIGH(BigDecimal r5_OUTSTANDING_HIGH) {
		R5_OUTSTANDING_HIGH = r5_OUTSTANDING_HIGH;
	}
	public BigDecimal getR5_PROVISION_HIGH() {
		return R5_PROVISION_HIGH;
	}
	public void setR5_PROVISION_HIGH(BigDecimal r5_PROVISION_HIGH) {
		R5_PROVISION_HIGH = r5_PROVISION_HIGH;
	}
	public BigDecimal getR5_OUTSTANDING_SMALL() {
		return R5_OUTSTANDING_SMALL;
	}
	public void setR5_OUTSTANDING_SMALL(BigDecimal r5_OUTSTANDING_SMALL) {
		R5_OUTSTANDING_SMALL = r5_OUTSTANDING_SMALL;
	}
	public BigDecimal getR5_PROVISION_SMALL() {
		return R5_PROVISION_SMALL;
	}
	public void setR5_PROVISION_SMALL(BigDecimal r5_PROVISION_SMALL) {
		R5_PROVISION_SMALL = r5_PROVISION_SMALL;
	}
	public BigDecimal getR5_OUTSTANDING_INDIVIDUAL() {
		return R5_OUTSTANDING_INDIVIDUAL;
	}
	public void setR5_OUTSTANDING_INDIVIDUAL(BigDecimal r5_OUTSTANDING_INDIVIDUAL) {
		R5_OUTSTANDING_INDIVIDUAL = r5_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR5_PROVISION_INDIVIDUAL() {
		return R5_PROVISION_INDIVIDUAL;
	}
	public void setR5_PROVISION_INDIVIDUAL(BigDecimal r5_PROVISION_INDIVIDUAL) {
		R5_PROVISION_INDIVIDUAL = r5_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR5_OUTSTANDING_GROSS() {
		return R5_OUTSTANDING_GROSS;
	}
	public void setR5_OUTSTANDING_GROSS(BigDecimal r5_OUTSTANDING_GROSS) {
		R5_OUTSTANDING_GROSS = r5_OUTSTANDING_GROSS;
	}
	public BigDecimal getR5_PROVISION_GROSS() {
		return R5_PROVISION_GROSS;
	}
	public void setR5_PROVISION_GROSS(BigDecimal r5_PROVISION_GROSS) {
		R5_PROVISION_GROSS = r5_PROVISION_GROSS;
	}
	public String getR6_S_NO() {
		return R6_S_NO;
	}
	public void setR6_S_NO(String r6_S_NO) {
		R6_S_NO = r6_S_NO;
	}
	public String getR6_STAGES() {
		return R6_STAGES;
	}
	public void setR6_STAGES(String r6_STAGES) {
		R6_STAGES = r6_STAGES;
	}
	public BigDecimal getR6_OUTSTANDING_NBFI() {
		return R6_OUTSTANDING_NBFI;
	}
	public void setR6_OUTSTANDING_NBFI(BigDecimal r6_OUTSTANDING_NBFI) {
		R6_OUTSTANDING_NBFI = r6_OUTSTANDING_NBFI;
	}
	public BigDecimal getR6_PROVISION_NBFI() {
		return R6_PROVISION_NBFI;
	}
	public void setR6_PROVISION_NBFI(BigDecimal r6_PROVISION_NBFI) {
		R6_PROVISION_NBFI = r6_PROVISION_NBFI;
	}
	public BigDecimal getR6_OUTSTANDING_FEDERAL() {
		return R6_OUTSTANDING_FEDERAL;
	}
	public void setR6_OUTSTANDING_FEDERAL(BigDecimal r6_OUTSTANDING_FEDERAL) {
		R6_OUTSTANDING_FEDERAL = r6_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR6_PROVISION_FEDERAL() {
		return R6_PROVISION_FEDERAL;
	}
	public void setR6_PROVISION_FEDERAL(BigDecimal r6_PROVISION_FEDERAL) {
		R6_PROVISION_FEDERAL = r6_PROVISION_FEDERAL;
	}
	public BigDecimal getR6_OUTSTANDING_NON_COMMERCIAL() {
		return R6_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR6_OUTSTANDING_NON_COMMERCIAL(BigDecimal r6_OUTSTANDING_NON_COMMERCIAL) {
		R6_OUTSTANDING_NON_COMMERCIAL = r6_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR6_PROVISON_NON_COMMERCIAL() {
		return R6_PROVISON_NON_COMMERCIAL;
	}
	public void setR6_PROVISON_NON_COMMERCIAL(BigDecimal r6_PROVISON_NON_COMMERCIAL) {
		R6_PROVISON_NON_COMMERCIAL = r6_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR6_OUTSTANDING_EMIRATES() {
		return R6_OUTSTANDING_EMIRATES;
	}
	public void setR6_OUTSTANDING_EMIRATES(BigDecimal r6_OUTSTANDING_EMIRATES) {
		R6_OUTSTANDING_EMIRATES = r6_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR6_PROVISION_EMIRATES() {
		return R6_PROVISION_EMIRATES;
	}
	public void setR6_PROVISION_EMIRATES(BigDecimal r6_PROVISION_EMIRATES) {
		R6_PROVISION_EMIRATES = r6_PROVISION_EMIRATES;
	}
	public BigDecimal getR6_OUTSTANDING_GOVT_GROSS() {
		return R6_OUTSTANDING_GOVT_GROSS;
	}
	public void setR6_OUTSTANDING_GOVT_GROSS(BigDecimal r6_OUTSTANDING_GOVT_GROSS) {
		R6_OUTSTANDING_GOVT_GROSS = r6_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR6_PROVISION_GOVT_GROSS() {
		return R6_PROVISION_GOVT_GROSS;
	}
	public void setR6_PROVISION_GOVT_GROSS(BigDecimal r6_PROVISION_GOVT_GROSS) {
		R6_PROVISION_GOVT_GROSS = r6_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR6_OUTSTANDING_GRE() {
		return R6_OUTSTANDING_GRE;
	}
	public void setR6_OUTSTANDING_GRE(BigDecimal r6_OUTSTANDING_GRE) {
		R6_OUTSTANDING_GRE = r6_OUTSTANDING_GRE;
	}
	public BigDecimal getR6_PROVISION_GRE() {
		return R6_PROVISION_GRE;
	}
	public void setR6_PROVISION_GRE(BigDecimal r6_PROVISION_GRE) {
		R6_PROVISION_GRE = r6_PROVISION_GRE;
	}
	public BigDecimal getR6_OUTSTANDING_CORPORATE() {
		return R6_OUTSTANDING_CORPORATE;
	}
	public void setR6_OUTSTANDING_CORPORATE(BigDecimal r6_OUTSTANDING_CORPORATE) {
		R6_OUTSTANDING_CORPORATE = r6_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR6_PROVISION_CORPORATE() {
		return R6_PROVISION_CORPORATE;
	}
	public void setR6_PROVISION_CORPORATE(BigDecimal r6_PROVISION_CORPORATE) {
		R6_PROVISION_CORPORATE = r6_PROVISION_CORPORATE;
	}
	public BigDecimal getR6_OUTSTANDING_OTHER_CORPORATE() {
		return R6_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR6_OUTSTANDING_OTHER_CORPORATE(BigDecimal r6_OUTSTANDING_OTHER_CORPORATE) {
		R6_OUTSTANDING_OTHER_CORPORATE = r6_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR6_PROVISION_OTHER_CORPORATE() {
		return R6_PROVISION_OTHER_CORPORATE;
	}
	public void setR6_PROVISION_OTHER_CORPORATE(BigDecimal r6_PROVISION_OTHER_CORPORATE) {
		R6_PROVISION_OTHER_CORPORATE = r6_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR6_OUTSTANDING_HIGH() {
		return R6_OUTSTANDING_HIGH;
	}
	public void setR6_OUTSTANDING_HIGH(BigDecimal r6_OUTSTANDING_HIGH) {
		R6_OUTSTANDING_HIGH = r6_OUTSTANDING_HIGH;
	}
	public BigDecimal getR6_PROVISION_HIGH() {
		return R6_PROVISION_HIGH;
	}
	public void setR6_PROVISION_HIGH(BigDecimal r6_PROVISION_HIGH) {
		R6_PROVISION_HIGH = r6_PROVISION_HIGH;
	}
	public BigDecimal getR6_OUTSTANDING_SMALL() {
		return R6_OUTSTANDING_SMALL;
	}
	public void setR6_OUTSTANDING_SMALL(BigDecimal r6_OUTSTANDING_SMALL) {
		R6_OUTSTANDING_SMALL = r6_OUTSTANDING_SMALL;
	}
	public BigDecimal getR6_PROVISION_SMALL() {
		return R6_PROVISION_SMALL;
	}
	public void setR6_PROVISION_SMALL(BigDecimal r6_PROVISION_SMALL) {
		R6_PROVISION_SMALL = r6_PROVISION_SMALL;
	}
	public BigDecimal getR6_OUTSTANDING_INDIVIDUAL() {
		return R6_OUTSTANDING_INDIVIDUAL;
	}
	public void setR6_OUTSTANDING_INDIVIDUAL(BigDecimal r6_OUTSTANDING_INDIVIDUAL) {
		R6_OUTSTANDING_INDIVIDUAL = r6_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR6_PROVISION_INDIVIDUAL() {
		return R6_PROVISION_INDIVIDUAL;
	}
	public void setR6_PROVISION_INDIVIDUAL(BigDecimal r6_PROVISION_INDIVIDUAL) {
		R6_PROVISION_INDIVIDUAL = r6_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR6_OUTSTANDING_GROSS() {
		return R6_OUTSTANDING_GROSS;
	}
	public void setR6_OUTSTANDING_GROSS(BigDecimal r6_OUTSTANDING_GROSS) {
		R6_OUTSTANDING_GROSS = r6_OUTSTANDING_GROSS;
	}
	public BigDecimal getR6_PROVISION_GROSS() {
		return R6_PROVISION_GROSS;
	}
	public void setR6_PROVISION_GROSS(BigDecimal r6_PROVISION_GROSS) {
		R6_PROVISION_GROSS = r6_PROVISION_GROSS;
	}
	public String getR7_S_NO() {
		return R7_S_NO;
	}
	public void setR7_S_NO(String r7_S_NO) {
		R7_S_NO = r7_S_NO;
	}
	public String getR7_STAGES() {
		return R7_STAGES;
	}
	public void setR7_STAGES(String r7_STAGES) {
		R7_STAGES = r7_STAGES;
	}
	public BigDecimal getR7_OUTSTANDING_NBFI() {
		return R7_OUTSTANDING_NBFI;
	}
	public void setR7_OUTSTANDING_NBFI(BigDecimal r7_OUTSTANDING_NBFI) {
		R7_OUTSTANDING_NBFI = r7_OUTSTANDING_NBFI;
	}
	public BigDecimal getR7_PROVISION_NBFI() {
		return R7_PROVISION_NBFI;
	}
	public void setR7_PROVISION_NBFI(BigDecimal r7_PROVISION_NBFI) {
		R7_PROVISION_NBFI = r7_PROVISION_NBFI;
	}
	public BigDecimal getR7_OUTSTANDING_FEDERAL() {
		return R7_OUTSTANDING_FEDERAL;
	}
	public void setR7_OUTSTANDING_FEDERAL(BigDecimal r7_OUTSTANDING_FEDERAL) {
		R7_OUTSTANDING_FEDERAL = r7_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR7_PROVISION_FEDERAL() {
		return R7_PROVISION_FEDERAL;
	}
	public void setR7_PROVISION_FEDERAL(BigDecimal r7_PROVISION_FEDERAL) {
		R7_PROVISION_FEDERAL = r7_PROVISION_FEDERAL;
	}
	public BigDecimal getR7_OUTSTANDING_NON_COMMERCIAL() {
		return R7_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR7_OUTSTANDING_NON_COMMERCIAL(BigDecimal r7_OUTSTANDING_NON_COMMERCIAL) {
		R7_OUTSTANDING_NON_COMMERCIAL = r7_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR7_PROVISON_NON_COMMERCIAL() {
		return R7_PROVISON_NON_COMMERCIAL;
	}
	public void setR7_PROVISON_NON_COMMERCIAL(BigDecimal r7_PROVISON_NON_COMMERCIAL) {
		R7_PROVISON_NON_COMMERCIAL = r7_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR7_OUTSTANDING_EMIRATES() {
		return R7_OUTSTANDING_EMIRATES;
	}
	public void setR7_OUTSTANDING_EMIRATES(BigDecimal r7_OUTSTANDING_EMIRATES) {
		R7_OUTSTANDING_EMIRATES = r7_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR7_PROVISION_EMIRATES() {
		return R7_PROVISION_EMIRATES;
	}
	public void setR7_PROVISION_EMIRATES(BigDecimal r7_PROVISION_EMIRATES) {
		R7_PROVISION_EMIRATES = r7_PROVISION_EMIRATES;
	}
	public BigDecimal getR7_OUTSTANDING_GOVT_GROSS() {
		return R7_OUTSTANDING_GOVT_GROSS;
	}
	public void setR7_OUTSTANDING_GOVT_GROSS(BigDecimal r7_OUTSTANDING_GOVT_GROSS) {
		R7_OUTSTANDING_GOVT_GROSS = r7_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR7_PROVISION_GOVT_GROSS() {
		return R7_PROVISION_GOVT_GROSS;
	}
	public void setR7_PROVISION_GOVT_GROSS(BigDecimal r7_PROVISION_GOVT_GROSS) {
		R7_PROVISION_GOVT_GROSS = r7_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR7_OUTSTANDING_GRE() {
		return R7_OUTSTANDING_GRE;
	}
	public void setR7_OUTSTANDING_GRE(BigDecimal r7_OUTSTANDING_GRE) {
		R7_OUTSTANDING_GRE = r7_OUTSTANDING_GRE;
	}
	public BigDecimal getR7_PROVISION_GRE() {
		return R7_PROVISION_GRE;
	}
	public void setR7_PROVISION_GRE(BigDecimal r7_PROVISION_GRE) {
		R7_PROVISION_GRE = r7_PROVISION_GRE;
	}
	public BigDecimal getR7_OUTSTANDING_CORPORATE() {
		return R7_OUTSTANDING_CORPORATE;
	}
	public void setR7_OUTSTANDING_CORPORATE(BigDecimal r7_OUTSTANDING_CORPORATE) {
		R7_OUTSTANDING_CORPORATE = r7_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR7_PROVISION_CORPORATE() {
		return R7_PROVISION_CORPORATE;
	}
	public void setR7_PROVISION_CORPORATE(BigDecimal r7_PROVISION_CORPORATE) {
		R7_PROVISION_CORPORATE = r7_PROVISION_CORPORATE;
	}
	public BigDecimal getR7_OUTSTANDING_OTHER_CORPORATE() {
		return R7_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR7_OUTSTANDING_OTHER_CORPORATE(BigDecimal r7_OUTSTANDING_OTHER_CORPORATE) {
		R7_OUTSTANDING_OTHER_CORPORATE = r7_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR7_PROVISION_OTHER_CORPORATE() {
		return R7_PROVISION_OTHER_CORPORATE;
	}
	public void setR7_PROVISION_OTHER_CORPORATE(BigDecimal r7_PROVISION_OTHER_CORPORATE) {
		R7_PROVISION_OTHER_CORPORATE = r7_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR7_OUTSTANDING_HIGH() {
		return R7_OUTSTANDING_HIGH;
	}
	public void setR7_OUTSTANDING_HIGH(BigDecimal r7_OUTSTANDING_HIGH) {
		R7_OUTSTANDING_HIGH = r7_OUTSTANDING_HIGH;
	}
	public BigDecimal getR7_PROVISION_HIGH() {
		return R7_PROVISION_HIGH;
	}
	public void setR7_PROVISION_HIGH(BigDecimal r7_PROVISION_HIGH) {
		R7_PROVISION_HIGH = r7_PROVISION_HIGH;
	}
	public BigDecimal getR7_OUTSTANDING_SMALL() {
		return R7_OUTSTANDING_SMALL;
	}
	public void setR7_OUTSTANDING_SMALL(BigDecimal r7_OUTSTANDING_SMALL) {
		R7_OUTSTANDING_SMALL = r7_OUTSTANDING_SMALL;
	}
	public BigDecimal getR7_PROVISION_SMALL() {
		return R7_PROVISION_SMALL;
	}
	public void setR7_PROVISION_SMALL(BigDecimal r7_PROVISION_SMALL) {
		R7_PROVISION_SMALL = r7_PROVISION_SMALL;
	}
	public BigDecimal getR7_OUTSTANDING_INDIVIDUAL() {
		return R7_OUTSTANDING_INDIVIDUAL;
	}
	public void setR7_OUTSTANDING_INDIVIDUAL(BigDecimal r7_OUTSTANDING_INDIVIDUAL) {
		R7_OUTSTANDING_INDIVIDUAL = r7_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR7_PROVISION_INDIVIDUAL() {
		return R7_PROVISION_INDIVIDUAL;
	}
	public void setR7_PROVISION_INDIVIDUAL(BigDecimal r7_PROVISION_INDIVIDUAL) {
		R7_PROVISION_INDIVIDUAL = r7_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR7_OUTSTANDING_GROSS() {
		return R7_OUTSTANDING_GROSS;
	}
	public void setR7_OUTSTANDING_GROSS(BigDecimal r7_OUTSTANDING_GROSS) {
		R7_OUTSTANDING_GROSS = r7_OUTSTANDING_GROSS;
	}
	public BigDecimal getR7_PROVISION_GROSS() {
		return R7_PROVISION_GROSS;
	}
	public void setR7_PROVISION_GROSS(BigDecimal r7_PROVISION_GROSS) {
		R7_PROVISION_GROSS = r7_PROVISION_GROSS;
	}
	public String getR8_S_NO() {
		return R8_S_NO;
	}
	public void setR8_S_NO(String r8_S_NO) {
		R8_S_NO = r8_S_NO;
	}
	public String getR8_STAGES() {
		return R8_STAGES;
	}
	public void setR8_STAGES(String r8_STAGES) {
		R8_STAGES = r8_STAGES;
	}
	public BigDecimal getR8_OUTSTANDING_NBFI() {
		return R8_OUTSTANDING_NBFI;
	}
	public void setR8_OUTSTANDING_NBFI(BigDecimal r8_OUTSTANDING_NBFI) {
		R8_OUTSTANDING_NBFI = r8_OUTSTANDING_NBFI;
	}
	public BigDecimal getR8_PROVISION_NBFI() {
		return R8_PROVISION_NBFI;
	}
	public void setR8_PROVISION_NBFI(BigDecimal r8_PROVISION_NBFI) {
		R8_PROVISION_NBFI = r8_PROVISION_NBFI;
	}
	public BigDecimal getR8_OUTSTANDING_FEDERAL() {
		return R8_OUTSTANDING_FEDERAL;
	}
	public void setR8_OUTSTANDING_FEDERAL(BigDecimal r8_OUTSTANDING_FEDERAL) {
		R8_OUTSTANDING_FEDERAL = r8_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR8_PROVISION_FEDERAL() {
		return R8_PROVISION_FEDERAL;
	}
	public void setR8_PROVISION_FEDERAL(BigDecimal r8_PROVISION_FEDERAL) {
		R8_PROVISION_FEDERAL = r8_PROVISION_FEDERAL;
	}
	public BigDecimal getR8_OUTSTANDING_NON_COMMERCIAL() {
		return R8_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR8_OUTSTANDING_NON_COMMERCIAL(BigDecimal r8_OUTSTANDING_NON_COMMERCIAL) {
		R8_OUTSTANDING_NON_COMMERCIAL = r8_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR8_PROVISON_NON_COMMERCIAL() {
		return R8_PROVISON_NON_COMMERCIAL;
	}
	public void setR8_PROVISON_NON_COMMERCIAL(BigDecimal r8_PROVISON_NON_COMMERCIAL) {
		R8_PROVISON_NON_COMMERCIAL = r8_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR8_OUTSTANDING_EMIRATES() {
		return R8_OUTSTANDING_EMIRATES;
	}
	public void setR8_OUTSTANDING_EMIRATES(BigDecimal r8_OUTSTANDING_EMIRATES) {
		R8_OUTSTANDING_EMIRATES = r8_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR8_PROVISION_EMIRATES() {
		return R8_PROVISION_EMIRATES;
	}
	public void setR8_PROVISION_EMIRATES(BigDecimal r8_PROVISION_EMIRATES) {
		R8_PROVISION_EMIRATES = r8_PROVISION_EMIRATES;
	}
	public BigDecimal getR8_OUTSTANDING_GOVT_GROSS() {
		return R8_OUTSTANDING_GOVT_GROSS;
	}
	public void setR8_OUTSTANDING_GOVT_GROSS(BigDecimal r8_OUTSTANDING_GOVT_GROSS) {
		R8_OUTSTANDING_GOVT_GROSS = r8_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR8_PROVISION_GOVT_GROSS() {
		return R8_PROVISION_GOVT_GROSS;
	}
	public void setR8_PROVISION_GOVT_GROSS(BigDecimal r8_PROVISION_GOVT_GROSS) {
		R8_PROVISION_GOVT_GROSS = r8_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR8_OUTSTANDING_GRE() {
		return R8_OUTSTANDING_GRE;
	}
	public void setR8_OUTSTANDING_GRE(BigDecimal r8_OUTSTANDING_GRE) {
		R8_OUTSTANDING_GRE = r8_OUTSTANDING_GRE;
	}
	public BigDecimal getR8_PROVISION_GRE() {
		return R8_PROVISION_GRE;
	}
	public void setR8_PROVISION_GRE(BigDecimal r8_PROVISION_GRE) {
		R8_PROVISION_GRE = r8_PROVISION_GRE;
	}
	public BigDecimal getR8_OUTSTANDING_CORPORATE() {
		return R8_OUTSTANDING_CORPORATE;
	}
	public void setR8_OUTSTANDING_CORPORATE(BigDecimal r8_OUTSTANDING_CORPORATE) {
		R8_OUTSTANDING_CORPORATE = r8_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR8_PROVISION_CORPORATE() {
		return R8_PROVISION_CORPORATE;
	}
	public void setR8_PROVISION_CORPORATE(BigDecimal r8_PROVISION_CORPORATE) {
		R8_PROVISION_CORPORATE = r8_PROVISION_CORPORATE;
	}
	public BigDecimal getR8_OUTSTANDING_OTHER_CORPORATE() {
		return R8_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR8_OUTSTANDING_OTHER_CORPORATE(BigDecimal r8_OUTSTANDING_OTHER_CORPORATE) {
		R8_OUTSTANDING_OTHER_CORPORATE = r8_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR8_PROVISION_OTHER_CORPORATE() {
		return R8_PROVISION_OTHER_CORPORATE;
	}
	public void setR8_PROVISION_OTHER_CORPORATE(BigDecimal r8_PROVISION_OTHER_CORPORATE) {
		R8_PROVISION_OTHER_CORPORATE = r8_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR8_OUTSTANDING_HIGH() {
		return R8_OUTSTANDING_HIGH;
	}
	public void setR8_OUTSTANDING_HIGH(BigDecimal r8_OUTSTANDING_HIGH) {
		R8_OUTSTANDING_HIGH = r8_OUTSTANDING_HIGH;
	}
	public BigDecimal getR8_PROVISION_HIGH() {
		return R8_PROVISION_HIGH;
	}
	public void setR8_PROVISION_HIGH(BigDecimal r8_PROVISION_HIGH) {
		R8_PROVISION_HIGH = r8_PROVISION_HIGH;
	}
	public BigDecimal getR8_OUTSTANDING_SMALL() {
		return R8_OUTSTANDING_SMALL;
	}
	public void setR8_OUTSTANDING_SMALL(BigDecimal r8_OUTSTANDING_SMALL) {
		R8_OUTSTANDING_SMALL = r8_OUTSTANDING_SMALL;
	}
	public BigDecimal getR8_PROVISION_SMALL() {
		return R8_PROVISION_SMALL;
	}
	public void setR8_PROVISION_SMALL(BigDecimal r8_PROVISION_SMALL) {
		R8_PROVISION_SMALL = r8_PROVISION_SMALL;
	}
	public BigDecimal getR8_OUTSTANDING_INDIVIDUAL() {
		return R8_OUTSTANDING_INDIVIDUAL;
	}
	public void setR8_OUTSTANDING_INDIVIDUAL(BigDecimal r8_OUTSTANDING_INDIVIDUAL) {
		R8_OUTSTANDING_INDIVIDUAL = r8_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR8_PROVISION_INDIVIDUAL() {
		return R8_PROVISION_INDIVIDUAL;
	}
	public void setR8_PROVISION_INDIVIDUAL(BigDecimal r8_PROVISION_INDIVIDUAL) {
		R8_PROVISION_INDIVIDUAL = r8_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR8_OUTSTANDING_GROSS() {
		return R8_OUTSTANDING_GROSS;
	}
	public void setR8_OUTSTANDING_GROSS(BigDecimal r8_OUTSTANDING_GROSS) {
		R8_OUTSTANDING_GROSS = r8_OUTSTANDING_GROSS;
	}
	public BigDecimal getR8_PROVISION_GROSS() {
		return R8_PROVISION_GROSS;
	}
	public void setR8_PROVISION_GROSS(BigDecimal r8_PROVISION_GROSS) {
		R8_PROVISION_GROSS = r8_PROVISION_GROSS;
	}
	public String getR9_S_NO() {
		return R9_S_NO;
	}
	public void setR9_S_NO(String r9_S_NO) {
		R9_S_NO = r9_S_NO;
	}
	public String getR9_STAGES() {
		return R9_STAGES;
	}
	public void setR9_STAGES(String r9_STAGES) {
		R9_STAGES = r9_STAGES;
	}
	public BigDecimal getR9_OUTSTANDING_NBFI() {
		return R9_OUTSTANDING_NBFI;
	}
	public void setR9_OUTSTANDING_NBFI(BigDecimal r9_OUTSTANDING_NBFI) {
		R9_OUTSTANDING_NBFI = r9_OUTSTANDING_NBFI;
	}
	public BigDecimal getR9_PROVISION_NBFI() {
		return R9_PROVISION_NBFI;
	}
	public void setR9_PROVISION_NBFI(BigDecimal r9_PROVISION_NBFI) {
		R9_PROVISION_NBFI = r9_PROVISION_NBFI;
	}
	public BigDecimal getR9_OUTSTANDING_FEDERAL() {
		return R9_OUTSTANDING_FEDERAL;
	}
	public void setR9_OUTSTANDING_FEDERAL(BigDecimal r9_OUTSTANDING_FEDERAL) {
		R9_OUTSTANDING_FEDERAL = r9_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR9_PROVISION_FEDERAL() {
		return R9_PROVISION_FEDERAL;
	}
	public void setR9_PROVISION_FEDERAL(BigDecimal r9_PROVISION_FEDERAL) {
		R9_PROVISION_FEDERAL = r9_PROVISION_FEDERAL;
	}
	public BigDecimal getR9_OUTSTANDING_NON_COMMERCIAL() {
		return R9_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR9_OUTSTANDING_NON_COMMERCIAL(BigDecimal r9_OUTSTANDING_NON_COMMERCIAL) {
		R9_OUTSTANDING_NON_COMMERCIAL = r9_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR9_PROVISON_NON_COMMERCIAL() {
		return R9_PROVISON_NON_COMMERCIAL;
	}
	public void setR9_PROVISON_NON_COMMERCIAL(BigDecimal r9_PROVISON_NON_COMMERCIAL) {
		R9_PROVISON_NON_COMMERCIAL = r9_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR9_OUTSTANDING_EMIRATES() {
		return R9_OUTSTANDING_EMIRATES;
	}
	public void setR9_OUTSTANDING_EMIRATES(BigDecimal r9_OUTSTANDING_EMIRATES) {
		R9_OUTSTANDING_EMIRATES = r9_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR9_PROVISION_EMIRATES() {
		return R9_PROVISION_EMIRATES;
	}
	public void setR9_PROVISION_EMIRATES(BigDecimal r9_PROVISION_EMIRATES) {
		R9_PROVISION_EMIRATES = r9_PROVISION_EMIRATES;
	}
	public BigDecimal getR9_OUTSTANDING_GOVT_GROSS() {
		return R9_OUTSTANDING_GOVT_GROSS;
	}
	public void setR9_OUTSTANDING_GOVT_GROSS(BigDecimal r9_OUTSTANDING_GOVT_GROSS) {
		R9_OUTSTANDING_GOVT_GROSS = r9_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR9_PROVISION_GOVT_GROSS() {
		return R9_PROVISION_GOVT_GROSS;
	}
	public void setR9_PROVISION_GOVT_GROSS(BigDecimal r9_PROVISION_GOVT_GROSS) {
		R9_PROVISION_GOVT_GROSS = r9_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR9_OUTSTANDING_GRE() {
		return R9_OUTSTANDING_GRE;
	}
	public void setR9_OUTSTANDING_GRE(BigDecimal r9_OUTSTANDING_GRE) {
		R9_OUTSTANDING_GRE = r9_OUTSTANDING_GRE;
	}
	public BigDecimal getR9_PROVISION_GRE() {
		return R9_PROVISION_GRE;
	}
	public void setR9_PROVISION_GRE(BigDecimal r9_PROVISION_GRE) {
		R9_PROVISION_GRE = r9_PROVISION_GRE;
	}
	public BigDecimal getR9_OUTSTANDING_CORPORATE() {
		return R9_OUTSTANDING_CORPORATE;
	}
	public void setR9_OUTSTANDING_CORPORATE(BigDecimal r9_OUTSTANDING_CORPORATE) {
		R9_OUTSTANDING_CORPORATE = r9_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR9_PROVISION_CORPORATE() {
		return R9_PROVISION_CORPORATE;
	}
	public void setR9_PROVISION_CORPORATE(BigDecimal r9_PROVISION_CORPORATE) {
		R9_PROVISION_CORPORATE = r9_PROVISION_CORPORATE;
	}
	public BigDecimal getR9_OUTSTANDING_OTHER_CORPORATE() {
		return R9_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR9_OUTSTANDING_OTHER_CORPORATE(BigDecimal r9_OUTSTANDING_OTHER_CORPORATE) {
		R9_OUTSTANDING_OTHER_CORPORATE = r9_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR9_PROVISION_OTHER_CORPORATE() {
		return R9_PROVISION_OTHER_CORPORATE;
	}
	public void setR9_PROVISION_OTHER_CORPORATE(BigDecimal r9_PROVISION_OTHER_CORPORATE) {
		R9_PROVISION_OTHER_CORPORATE = r9_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR9_OUTSTANDING_HIGH() {
		return R9_OUTSTANDING_HIGH;
	}
	public void setR9_OUTSTANDING_HIGH(BigDecimal r9_OUTSTANDING_HIGH) {
		R9_OUTSTANDING_HIGH = r9_OUTSTANDING_HIGH;
	}
	public BigDecimal getR9_PROVISION_HIGH() {
		return R9_PROVISION_HIGH;
	}
	public void setR9_PROVISION_HIGH(BigDecimal r9_PROVISION_HIGH) {
		R9_PROVISION_HIGH = r9_PROVISION_HIGH;
	}
	public BigDecimal getR9_OUTSTANDING_SMALL() {
		return R9_OUTSTANDING_SMALL;
	}
	public void setR9_OUTSTANDING_SMALL(BigDecimal r9_OUTSTANDING_SMALL) {
		R9_OUTSTANDING_SMALL = r9_OUTSTANDING_SMALL;
	}
	public BigDecimal getR9_PROVISION_SMALL() {
		return R9_PROVISION_SMALL;
	}
	public void setR9_PROVISION_SMALL(BigDecimal r9_PROVISION_SMALL) {
		R9_PROVISION_SMALL = r9_PROVISION_SMALL;
	}
	public BigDecimal getR9_OUTSTANDING_INDIVIDUAL() {
		return R9_OUTSTANDING_INDIVIDUAL;
	}
	public void setR9_OUTSTANDING_INDIVIDUAL(BigDecimal r9_OUTSTANDING_INDIVIDUAL) {
		R9_OUTSTANDING_INDIVIDUAL = r9_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR9_PROVISION_INDIVIDUAL() {
		return R9_PROVISION_INDIVIDUAL;
	}
	public void setR9_PROVISION_INDIVIDUAL(BigDecimal r9_PROVISION_INDIVIDUAL) {
		R9_PROVISION_INDIVIDUAL = r9_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR9_OUTSTANDING_GROSS() {
		return R9_OUTSTANDING_GROSS;
	}
	public void setR9_OUTSTANDING_GROSS(BigDecimal r9_OUTSTANDING_GROSS) {
		R9_OUTSTANDING_GROSS = r9_OUTSTANDING_GROSS;
	}
	public BigDecimal getR9_PROVISION_GROSS() {
		return R9_PROVISION_GROSS;
	}
	public void setR9_PROVISION_GROSS(BigDecimal r9_PROVISION_GROSS) {
		R9_PROVISION_GROSS = r9_PROVISION_GROSS;
	}
	public String getR10_S_NO() {
		return R10_S_NO;
	}
	public void setR10_S_NO(String r10_S_NO) {
		R10_S_NO = r10_S_NO;
	}
	public String getR10_STAGES() {
		return R10_STAGES;
	}
	public void setR10_STAGES(String r10_STAGES) {
		R10_STAGES = r10_STAGES;
	}
	public BigDecimal getR10_OUTSTANDING_NBFI() {
		return R10_OUTSTANDING_NBFI;
	}
	public void setR10_OUTSTANDING_NBFI(BigDecimal r10_OUTSTANDING_NBFI) {
		R10_OUTSTANDING_NBFI = r10_OUTSTANDING_NBFI;
	}
	public BigDecimal getR10_PROVISION_NBFI() {
		return R10_PROVISION_NBFI;
	}
	public void setR10_PROVISION_NBFI(BigDecimal r10_PROVISION_NBFI) {
		R10_PROVISION_NBFI = r10_PROVISION_NBFI;
	}
	public BigDecimal getR10_OUTSTANDING_FEDERAL() {
		return R10_OUTSTANDING_FEDERAL;
	}
	public void setR10_OUTSTANDING_FEDERAL(BigDecimal r10_OUTSTANDING_FEDERAL) {
		R10_OUTSTANDING_FEDERAL = r10_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR10_PROVISION_FEDERAL() {
		return R10_PROVISION_FEDERAL;
	}
	public void setR10_PROVISION_FEDERAL(BigDecimal r10_PROVISION_FEDERAL) {
		R10_PROVISION_FEDERAL = r10_PROVISION_FEDERAL;
	}
	public BigDecimal getR10_OUTSTANDING_NON_COMMERCIAL() {
		return R10_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR10_OUTSTANDING_NON_COMMERCIAL(BigDecimal r10_OUTSTANDING_NON_COMMERCIAL) {
		R10_OUTSTANDING_NON_COMMERCIAL = r10_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR10_PROVISON_NON_COMMERCIAL() {
		return R10_PROVISON_NON_COMMERCIAL;
	}
	public void setR10_PROVISON_NON_COMMERCIAL(BigDecimal r10_PROVISON_NON_COMMERCIAL) {
		R10_PROVISON_NON_COMMERCIAL = r10_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR10_OUTSTANDING_EMIRATES() {
		return R10_OUTSTANDING_EMIRATES;
	}
	public void setR10_OUTSTANDING_EMIRATES(BigDecimal r10_OUTSTANDING_EMIRATES) {
		R10_OUTSTANDING_EMIRATES = r10_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR10_PROVISION_EMIRATES() {
		return R10_PROVISION_EMIRATES;
	}
	public void setR10_PROVISION_EMIRATES(BigDecimal r10_PROVISION_EMIRATES) {
		R10_PROVISION_EMIRATES = r10_PROVISION_EMIRATES;
	}
	public BigDecimal getR10_OUTSTANDING_GOVT_GROSS() {
		return R10_OUTSTANDING_GOVT_GROSS;
	}
	public void setR10_OUTSTANDING_GOVT_GROSS(BigDecimal r10_OUTSTANDING_GOVT_GROSS) {
		R10_OUTSTANDING_GOVT_GROSS = r10_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR10_PROVISION_GOVT_GROSS() {
		return R10_PROVISION_GOVT_GROSS;
	}
	public void setR10_PROVISION_GOVT_GROSS(BigDecimal r10_PROVISION_GOVT_GROSS) {
		R10_PROVISION_GOVT_GROSS = r10_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR10_OUTSTANDING_GRE() {
		return R10_OUTSTANDING_GRE;
	}
	public void setR10_OUTSTANDING_GRE(BigDecimal r10_OUTSTANDING_GRE) {
		R10_OUTSTANDING_GRE = r10_OUTSTANDING_GRE;
	}
	public BigDecimal getR10_PROVISION_GRE() {
		return R10_PROVISION_GRE;
	}
	public void setR10_PROVISION_GRE(BigDecimal r10_PROVISION_GRE) {
		R10_PROVISION_GRE = r10_PROVISION_GRE;
	}
	public BigDecimal getR10_OUTSTANDING_CORPORATE() {
		return R10_OUTSTANDING_CORPORATE;
	}
	public void setR10_OUTSTANDING_CORPORATE(BigDecimal r10_OUTSTANDING_CORPORATE) {
		R10_OUTSTANDING_CORPORATE = r10_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR10_PROVISION_CORPORATE() {
		return R10_PROVISION_CORPORATE;
	}
	public void setR10_PROVISION_CORPORATE(BigDecimal r10_PROVISION_CORPORATE) {
		R10_PROVISION_CORPORATE = r10_PROVISION_CORPORATE;
	}
	public BigDecimal getR10_OUTSTANDING_OTHER_CORPORATE() {
		return R10_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR10_OUTSTANDING_OTHER_CORPORATE(BigDecimal r10_OUTSTANDING_OTHER_CORPORATE) {
		R10_OUTSTANDING_OTHER_CORPORATE = r10_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR10_PROVISION_OTHER_CORPORATE() {
		return R10_PROVISION_OTHER_CORPORATE;
	}
	public void setR10_PROVISION_OTHER_CORPORATE(BigDecimal r10_PROVISION_OTHER_CORPORATE) {
		R10_PROVISION_OTHER_CORPORATE = r10_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR10_OUTSTANDING_HIGH() {
		return R10_OUTSTANDING_HIGH;
	}
	public void setR10_OUTSTANDING_HIGH(BigDecimal r10_OUTSTANDING_HIGH) {
		R10_OUTSTANDING_HIGH = r10_OUTSTANDING_HIGH;
	}
	public BigDecimal getR10_PROVISION_HIGH() {
		return R10_PROVISION_HIGH;
	}
	public void setR10_PROVISION_HIGH(BigDecimal r10_PROVISION_HIGH) {
		R10_PROVISION_HIGH = r10_PROVISION_HIGH;
	}
	public BigDecimal getR10_OUTSTANDING_SMALL() {
		return R10_OUTSTANDING_SMALL;
	}
	public void setR10_OUTSTANDING_SMALL(BigDecimal r10_OUTSTANDING_SMALL) {
		R10_OUTSTANDING_SMALL = r10_OUTSTANDING_SMALL;
	}
	public BigDecimal getR10_PROVISION_SMALL() {
		return R10_PROVISION_SMALL;
	}
	public void setR10_PROVISION_SMALL(BigDecimal r10_PROVISION_SMALL) {
		R10_PROVISION_SMALL = r10_PROVISION_SMALL;
	}
	public BigDecimal getR10_OUTSTANDING_INDIVIDUAL() {
		return R10_OUTSTANDING_INDIVIDUAL;
	}
	public void setR10_OUTSTANDING_INDIVIDUAL(BigDecimal r10_OUTSTANDING_INDIVIDUAL) {
		R10_OUTSTANDING_INDIVIDUAL = r10_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR10_PROVISION_INDIVIDUAL() {
		return R10_PROVISION_INDIVIDUAL;
	}
	public void setR10_PROVISION_INDIVIDUAL(BigDecimal r10_PROVISION_INDIVIDUAL) {
		R10_PROVISION_INDIVIDUAL = r10_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR10_OUTSTANDING_GROSS() {
		return R10_OUTSTANDING_GROSS;
	}
	public void setR10_OUTSTANDING_GROSS(BigDecimal r10_OUTSTANDING_GROSS) {
		R10_OUTSTANDING_GROSS = r10_OUTSTANDING_GROSS;
	}
	public BigDecimal getR10_PROVISION_GROSS() {
		return R10_PROVISION_GROSS;
	}
	public void setR10_PROVISION_GROSS(BigDecimal r10_PROVISION_GROSS) {
		R10_PROVISION_GROSS = r10_PROVISION_GROSS;
	}
	public String getR11_S_NO() {
		return R11_S_NO;
	}
	public void setR11_S_NO(String r11_S_NO) {
		R11_S_NO = r11_S_NO;
	}
	public String getR11_STAGES() {
		return R11_STAGES;
	}
	public void setR11_STAGES(String r11_STAGES) {
		R11_STAGES = r11_STAGES;
	}
	public BigDecimal getR11_OUTSTANDING_NBFI() {
		return R11_OUTSTANDING_NBFI;
	}
	public void setR11_OUTSTANDING_NBFI(BigDecimal r11_OUTSTANDING_NBFI) {
		R11_OUTSTANDING_NBFI = r11_OUTSTANDING_NBFI;
	}
	public BigDecimal getR11_PROVISION_NBFI() {
		return R11_PROVISION_NBFI;
	}
	public void setR11_PROVISION_NBFI(BigDecimal r11_PROVISION_NBFI) {
		R11_PROVISION_NBFI = r11_PROVISION_NBFI;
	}
	public BigDecimal getR11_OUTSTANDING_FEDERAL() {
		return R11_OUTSTANDING_FEDERAL;
	}
	public void setR11_OUTSTANDING_FEDERAL(BigDecimal r11_OUTSTANDING_FEDERAL) {
		R11_OUTSTANDING_FEDERAL = r11_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR11_PROVISION_FEDERAL() {
		return R11_PROVISION_FEDERAL;
	}
	public void setR11_PROVISION_FEDERAL(BigDecimal r11_PROVISION_FEDERAL) {
		R11_PROVISION_FEDERAL = r11_PROVISION_FEDERAL;
	}
	public BigDecimal getR11_OUTSTANDING_NON_COMMERCIAL() {
		return R11_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR11_OUTSTANDING_NON_COMMERCIAL(BigDecimal r11_OUTSTANDING_NON_COMMERCIAL) {
		R11_OUTSTANDING_NON_COMMERCIAL = r11_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR11_PROVISON_NON_COMMERCIAL() {
		return R11_PROVISON_NON_COMMERCIAL;
	}
	public void setR11_PROVISON_NON_COMMERCIAL(BigDecimal r11_PROVISON_NON_COMMERCIAL) {
		R11_PROVISON_NON_COMMERCIAL = r11_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR11_OUTSTANDING_EMIRATES() {
		return R11_OUTSTANDING_EMIRATES;
	}
	public void setR11_OUTSTANDING_EMIRATES(BigDecimal r11_OUTSTANDING_EMIRATES) {
		R11_OUTSTANDING_EMIRATES = r11_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR11_PROVISION_EMIRATES() {
		return R11_PROVISION_EMIRATES;
	}
	public void setR11_PROVISION_EMIRATES(BigDecimal r11_PROVISION_EMIRATES) {
		R11_PROVISION_EMIRATES = r11_PROVISION_EMIRATES;
	}
	public BigDecimal getR11_OUTSTANDING_GOVT_GROSS() {
		return R11_OUTSTANDING_GOVT_GROSS;
	}
	public void setR11_OUTSTANDING_GOVT_GROSS(BigDecimal r11_OUTSTANDING_GOVT_GROSS) {
		R11_OUTSTANDING_GOVT_GROSS = r11_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR11_PROVISION_GOVT_GROSS() {
		return R11_PROVISION_GOVT_GROSS;
	}
	public void setR11_PROVISION_GOVT_GROSS(BigDecimal r11_PROVISION_GOVT_GROSS) {
		R11_PROVISION_GOVT_GROSS = r11_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR11_OUTSTANDING_GRE() {
		return R11_OUTSTANDING_GRE;
	}
	public void setR11_OUTSTANDING_GRE(BigDecimal r11_OUTSTANDING_GRE) {
		R11_OUTSTANDING_GRE = r11_OUTSTANDING_GRE;
	}
	public BigDecimal getR11_PROVISION_GRE() {
		return R11_PROVISION_GRE;
	}
	public void setR11_PROVISION_GRE(BigDecimal r11_PROVISION_GRE) {
		R11_PROVISION_GRE = r11_PROVISION_GRE;
	}
	public BigDecimal getR11_OUTSTANDING_CORPORATE() {
		return R11_OUTSTANDING_CORPORATE;
	}
	public void setR11_OUTSTANDING_CORPORATE(BigDecimal r11_OUTSTANDING_CORPORATE) {
		R11_OUTSTANDING_CORPORATE = r11_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR11_PROVISION_CORPORATE() {
		return R11_PROVISION_CORPORATE;
	}
	public void setR11_PROVISION_CORPORATE(BigDecimal r11_PROVISION_CORPORATE) {
		R11_PROVISION_CORPORATE = r11_PROVISION_CORPORATE;
	}
	public BigDecimal getR11_OUTSTANDING_OTHER_CORPORATE() {
		return R11_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR11_OUTSTANDING_OTHER_CORPORATE(BigDecimal r11_OUTSTANDING_OTHER_CORPORATE) {
		R11_OUTSTANDING_OTHER_CORPORATE = r11_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR11_PROVISION_OTHER_CORPORATE() {
		return R11_PROVISION_OTHER_CORPORATE;
	}
	public void setR11_PROVISION_OTHER_CORPORATE(BigDecimal r11_PROVISION_OTHER_CORPORATE) {
		R11_PROVISION_OTHER_CORPORATE = r11_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR11_OUTSTANDING_HIGH() {
		return R11_OUTSTANDING_HIGH;
	}
	public void setR11_OUTSTANDING_HIGH(BigDecimal r11_OUTSTANDING_HIGH) {
		R11_OUTSTANDING_HIGH = r11_OUTSTANDING_HIGH;
	}
	public BigDecimal getR11_PROVISION_HIGH() {
		return R11_PROVISION_HIGH;
	}
	public void setR11_PROVISION_HIGH(BigDecimal r11_PROVISION_HIGH) {
		R11_PROVISION_HIGH = r11_PROVISION_HIGH;
	}
	public BigDecimal getR11_OUTSTANDING_SMALL() {
		return R11_OUTSTANDING_SMALL;
	}
	public void setR11_OUTSTANDING_SMALL(BigDecimal r11_OUTSTANDING_SMALL) {
		R11_OUTSTANDING_SMALL = r11_OUTSTANDING_SMALL;
	}
	public BigDecimal getR11_PROVISION_SMALL() {
		return R11_PROVISION_SMALL;
	}
	public void setR11_PROVISION_SMALL(BigDecimal r11_PROVISION_SMALL) {
		R11_PROVISION_SMALL = r11_PROVISION_SMALL;
	}
	public BigDecimal getR11_OUTSTANDING_INDIVIDUAL() {
		return R11_OUTSTANDING_INDIVIDUAL;
	}
	public void setR11_OUTSTANDING_INDIVIDUAL(BigDecimal r11_OUTSTANDING_INDIVIDUAL) {
		R11_OUTSTANDING_INDIVIDUAL = r11_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR11_PROVISION_INDIVIDUAL() {
		return R11_PROVISION_INDIVIDUAL;
	}
	public void setR11_PROVISION_INDIVIDUAL(BigDecimal r11_PROVISION_INDIVIDUAL) {
		R11_PROVISION_INDIVIDUAL = r11_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR11_OUTSTANDING_GROSS() {
		return R11_OUTSTANDING_GROSS;
	}
	public void setR11_OUTSTANDING_GROSS(BigDecimal r11_OUTSTANDING_GROSS) {
		R11_OUTSTANDING_GROSS = r11_OUTSTANDING_GROSS;
	}
	public BigDecimal getR11_PROVISION_GROSS() {
		return R11_PROVISION_GROSS;
	}
	public void setR11_PROVISION_GROSS(BigDecimal r11_PROVISION_GROSS) {
		R11_PROVISION_GROSS = r11_PROVISION_GROSS;
	}
	public String getR12_S_NO() {
		return R12_S_NO;
	}
	public void setR12_S_NO(String r12_S_NO) {
		R12_S_NO = r12_S_NO;
	}
	public String getR12_STAGES() {
		return R12_STAGES;
	}
	public void setR12_STAGES(String r12_STAGES) {
		R12_STAGES = r12_STAGES;
	}
	public BigDecimal getR12_OUTSTANDING_NBFI() {
		return R12_OUTSTANDING_NBFI;
	}
	public void setR12_OUTSTANDING_NBFI(BigDecimal r12_OUTSTANDING_NBFI) {
		R12_OUTSTANDING_NBFI = r12_OUTSTANDING_NBFI;
	}
	public BigDecimal getR12_PROVISION_NBFI() {
		return R12_PROVISION_NBFI;
	}
	public void setR12_PROVISION_NBFI(BigDecimal r12_PROVISION_NBFI) {
		R12_PROVISION_NBFI = r12_PROVISION_NBFI;
	}
	public BigDecimal getR12_OUTSTANDING_FEDERAL() {
		return R12_OUTSTANDING_FEDERAL;
	}
	public void setR12_OUTSTANDING_FEDERAL(BigDecimal r12_OUTSTANDING_FEDERAL) {
		R12_OUTSTANDING_FEDERAL = r12_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR12_PROVISION_FEDERAL() {
		return R12_PROVISION_FEDERAL;
	}
	public void setR12_PROVISION_FEDERAL(BigDecimal r12_PROVISION_FEDERAL) {
		R12_PROVISION_FEDERAL = r12_PROVISION_FEDERAL;
	}
	public BigDecimal getR12_OUTSTANDING_NON_COMMERCIAL() {
		return R12_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR12_OUTSTANDING_NON_COMMERCIAL(BigDecimal r12_OUTSTANDING_NON_COMMERCIAL) {
		R12_OUTSTANDING_NON_COMMERCIAL = r12_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR12_PROVISON_NON_COMMERCIAL() {
		return R12_PROVISON_NON_COMMERCIAL;
	}
	public void setR12_PROVISON_NON_COMMERCIAL(BigDecimal r12_PROVISON_NON_COMMERCIAL) {
		R12_PROVISON_NON_COMMERCIAL = r12_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR12_OUTSTANDING_EMIRATES() {
		return R12_OUTSTANDING_EMIRATES;
	}
	public void setR12_OUTSTANDING_EMIRATES(BigDecimal r12_OUTSTANDING_EMIRATES) {
		R12_OUTSTANDING_EMIRATES = r12_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR12_PROVISION_EMIRATES() {
		return R12_PROVISION_EMIRATES;
	}
	public void setR12_PROVISION_EMIRATES(BigDecimal r12_PROVISION_EMIRATES) {
		R12_PROVISION_EMIRATES = r12_PROVISION_EMIRATES;
	}
	public BigDecimal getR12_OUTSTANDING_GOVT_GROSS() {
		return R12_OUTSTANDING_GOVT_GROSS;
	}
	public void setR12_OUTSTANDING_GOVT_GROSS(BigDecimal r12_OUTSTANDING_GOVT_GROSS) {
		R12_OUTSTANDING_GOVT_GROSS = r12_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR12_PROVISION_GOVT_GROSS() {
		return R12_PROVISION_GOVT_GROSS;
	}
	public void setR12_PROVISION_GOVT_GROSS(BigDecimal r12_PROVISION_GOVT_GROSS) {
		R12_PROVISION_GOVT_GROSS = r12_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR12_OUTSTANDING_GRE() {
		return R12_OUTSTANDING_GRE;
	}
	public void setR12_OUTSTANDING_GRE(BigDecimal r12_OUTSTANDING_GRE) {
		R12_OUTSTANDING_GRE = r12_OUTSTANDING_GRE;
	}
	public BigDecimal getR12_PROVISION_GRE() {
		return R12_PROVISION_GRE;
	}
	public void setR12_PROVISION_GRE(BigDecimal r12_PROVISION_GRE) {
		R12_PROVISION_GRE = r12_PROVISION_GRE;
	}
	public BigDecimal getR12_OUTSTANDING_CORPORATE() {
		return R12_OUTSTANDING_CORPORATE;
	}
	public void setR12_OUTSTANDING_CORPORATE(BigDecimal r12_OUTSTANDING_CORPORATE) {
		R12_OUTSTANDING_CORPORATE = r12_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR12_PROVISION_CORPORATE() {
		return R12_PROVISION_CORPORATE;
	}
	public void setR12_PROVISION_CORPORATE(BigDecimal r12_PROVISION_CORPORATE) {
		R12_PROVISION_CORPORATE = r12_PROVISION_CORPORATE;
	}
	public BigDecimal getR12_OUTSTANDING_OTHER_CORPORATE() {
		return R12_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR12_OUTSTANDING_OTHER_CORPORATE(BigDecimal r12_OUTSTANDING_OTHER_CORPORATE) {
		R12_OUTSTANDING_OTHER_CORPORATE = r12_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR12_PROVISION_OTHER_CORPORATE() {
		return R12_PROVISION_OTHER_CORPORATE;
	}
	public void setR12_PROVISION_OTHER_CORPORATE(BigDecimal r12_PROVISION_OTHER_CORPORATE) {
		R12_PROVISION_OTHER_CORPORATE = r12_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR12_OUTSTANDING_HIGH() {
		return R12_OUTSTANDING_HIGH;
	}
	public void setR12_OUTSTANDING_HIGH(BigDecimal r12_OUTSTANDING_HIGH) {
		R12_OUTSTANDING_HIGH = r12_OUTSTANDING_HIGH;
	}
	public BigDecimal getR12_PROVISION_HIGH() {
		return R12_PROVISION_HIGH;
	}
	public void setR12_PROVISION_HIGH(BigDecimal r12_PROVISION_HIGH) {
		R12_PROVISION_HIGH = r12_PROVISION_HIGH;
	}
	public BigDecimal getR12_OUTSTANDING_SMALL() {
		return R12_OUTSTANDING_SMALL;
	}
	public void setR12_OUTSTANDING_SMALL(BigDecimal r12_OUTSTANDING_SMALL) {
		R12_OUTSTANDING_SMALL = r12_OUTSTANDING_SMALL;
	}
	public BigDecimal getR12_PROVISION_SMALL() {
		return R12_PROVISION_SMALL;
	}
	public void setR12_PROVISION_SMALL(BigDecimal r12_PROVISION_SMALL) {
		R12_PROVISION_SMALL = r12_PROVISION_SMALL;
	}
	public BigDecimal getR12_OUTSTANDING_INDIVIDUAL() {
		return R12_OUTSTANDING_INDIVIDUAL;
	}
	public void setR12_OUTSTANDING_INDIVIDUAL(BigDecimal r12_OUTSTANDING_INDIVIDUAL) {
		R12_OUTSTANDING_INDIVIDUAL = r12_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR12_PROVISION_INDIVIDUAL() {
		return R12_PROVISION_INDIVIDUAL;
	}
	public void setR12_PROVISION_INDIVIDUAL(BigDecimal r12_PROVISION_INDIVIDUAL) {
		R12_PROVISION_INDIVIDUAL = r12_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR12_OUTSTANDING_GROSS() {
		return R12_OUTSTANDING_GROSS;
	}
	public void setR12_OUTSTANDING_GROSS(BigDecimal r12_OUTSTANDING_GROSS) {
		R12_OUTSTANDING_GROSS = r12_OUTSTANDING_GROSS;
	}
	public BigDecimal getR12_PROVISION_GROSS() {
		return R12_PROVISION_GROSS;
	}
	public void setR12_PROVISION_GROSS(BigDecimal r12_PROVISION_GROSS) {
		R12_PROVISION_GROSS = r12_PROVISION_GROSS;
	}
	public String getR13_S_NO() {
		return R13_S_NO;
	}
	public void setR13_S_NO(String r13_S_NO) {
		R13_S_NO = r13_S_NO;
	}
	public String getR13_STAGES() {
		return R13_STAGES;
	}
	public void setR13_STAGES(String r13_STAGES) {
		R13_STAGES = r13_STAGES;
	}
	public BigDecimal getR13_OUTSTANDING_NBFI() {
		return R13_OUTSTANDING_NBFI;
	}
	public void setR13_OUTSTANDING_NBFI(BigDecimal r13_OUTSTANDING_NBFI) {
		R13_OUTSTANDING_NBFI = r13_OUTSTANDING_NBFI;
	}
	public BigDecimal getR13_PROVISION_NBFI() {
		return R13_PROVISION_NBFI;
	}
	public void setR13_PROVISION_NBFI(BigDecimal r13_PROVISION_NBFI) {
		R13_PROVISION_NBFI = r13_PROVISION_NBFI;
	}
	public BigDecimal getR13_OUTSTANDING_FEDERAL() {
		return R13_OUTSTANDING_FEDERAL;
	}
	public void setR13_OUTSTANDING_FEDERAL(BigDecimal r13_OUTSTANDING_FEDERAL) {
		R13_OUTSTANDING_FEDERAL = r13_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR13_PROVISION_FEDERAL() {
		return R13_PROVISION_FEDERAL;
	}
	public void setR13_PROVISION_FEDERAL(BigDecimal r13_PROVISION_FEDERAL) {
		R13_PROVISION_FEDERAL = r13_PROVISION_FEDERAL;
	}
	public BigDecimal getR13_OUTSTANDING_NON_COMMERCIAL() {
		return R13_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR13_OUTSTANDING_NON_COMMERCIAL(BigDecimal r13_OUTSTANDING_NON_COMMERCIAL) {
		R13_OUTSTANDING_NON_COMMERCIAL = r13_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR13_PROVISON_NON_COMMERCIAL() {
		return R13_PROVISON_NON_COMMERCIAL;
	}
	public void setR13_PROVISON_NON_COMMERCIAL(BigDecimal r13_PROVISON_NON_COMMERCIAL) {
		R13_PROVISON_NON_COMMERCIAL = r13_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR13_OUTSTANDING_EMIRATES() {
		return R13_OUTSTANDING_EMIRATES;
	}
	public void setR13_OUTSTANDING_EMIRATES(BigDecimal r13_OUTSTANDING_EMIRATES) {
		R13_OUTSTANDING_EMIRATES = r13_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR13_PROVISION_EMIRATES() {
		return R13_PROVISION_EMIRATES;
	}
	public void setR13_PROVISION_EMIRATES(BigDecimal r13_PROVISION_EMIRATES) {
		R13_PROVISION_EMIRATES = r13_PROVISION_EMIRATES;
	}
	public BigDecimal getR13_OUTSTANDING_GOVT_GROSS() {
		return R13_OUTSTANDING_GOVT_GROSS;
	}
	public void setR13_OUTSTANDING_GOVT_GROSS(BigDecimal r13_OUTSTANDING_GOVT_GROSS) {
		R13_OUTSTANDING_GOVT_GROSS = r13_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR13_PROVISION_GOVT_GROSS() {
		return R13_PROVISION_GOVT_GROSS;
	}
	public void setR13_PROVISION_GOVT_GROSS(BigDecimal r13_PROVISION_GOVT_GROSS) {
		R13_PROVISION_GOVT_GROSS = r13_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR13_OUTSTANDING_GRE() {
		return R13_OUTSTANDING_GRE;
	}
	public void setR13_OUTSTANDING_GRE(BigDecimal r13_OUTSTANDING_GRE) {
		R13_OUTSTANDING_GRE = r13_OUTSTANDING_GRE;
	}
	public BigDecimal getR13_PROVISION_GRE() {
		return R13_PROVISION_GRE;
	}
	public void setR13_PROVISION_GRE(BigDecimal r13_PROVISION_GRE) {
		R13_PROVISION_GRE = r13_PROVISION_GRE;
	}
	public BigDecimal getR13_OUTSTANDING_CORPORATE() {
		return R13_OUTSTANDING_CORPORATE;
	}
	public void setR13_OUTSTANDING_CORPORATE(BigDecimal r13_OUTSTANDING_CORPORATE) {
		R13_OUTSTANDING_CORPORATE = r13_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR13_PROVISION_CORPORATE() {
		return R13_PROVISION_CORPORATE;
	}
	public void setR13_PROVISION_CORPORATE(BigDecimal r13_PROVISION_CORPORATE) {
		R13_PROVISION_CORPORATE = r13_PROVISION_CORPORATE;
	}
	public BigDecimal getR13_OUTSTANDING_OTHER_CORPORATE() {
		return R13_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR13_OUTSTANDING_OTHER_CORPORATE(BigDecimal r13_OUTSTANDING_OTHER_CORPORATE) {
		R13_OUTSTANDING_OTHER_CORPORATE = r13_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR13_PROVISION_OTHER_CORPORATE() {
		return R13_PROVISION_OTHER_CORPORATE;
	}
	public void setR13_PROVISION_OTHER_CORPORATE(BigDecimal r13_PROVISION_OTHER_CORPORATE) {
		R13_PROVISION_OTHER_CORPORATE = r13_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR13_OUTSTANDING_HIGH() {
		return R13_OUTSTANDING_HIGH;
	}
	public void setR13_OUTSTANDING_HIGH(BigDecimal r13_OUTSTANDING_HIGH) {
		R13_OUTSTANDING_HIGH = r13_OUTSTANDING_HIGH;
	}
	public BigDecimal getR13_PROVISION_HIGH() {
		return R13_PROVISION_HIGH;
	}
	public void setR13_PROVISION_HIGH(BigDecimal r13_PROVISION_HIGH) {
		R13_PROVISION_HIGH = r13_PROVISION_HIGH;
	}
	public BigDecimal getR13_OUTSTANDING_SMALL() {
		return R13_OUTSTANDING_SMALL;
	}
	public void setR13_OUTSTANDING_SMALL(BigDecimal r13_OUTSTANDING_SMALL) {
		R13_OUTSTANDING_SMALL = r13_OUTSTANDING_SMALL;
	}
	public BigDecimal getR13_PROVISION_SMALL() {
		return R13_PROVISION_SMALL;
	}
	public void setR13_PROVISION_SMALL(BigDecimal r13_PROVISION_SMALL) {
		R13_PROVISION_SMALL = r13_PROVISION_SMALL;
	}
	public BigDecimal getR13_OUTSTANDING_INDIVIDUAL() {
		return R13_OUTSTANDING_INDIVIDUAL;
	}
	public void setR13_OUTSTANDING_INDIVIDUAL(BigDecimal r13_OUTSTANDING_INDIVIDUAL) {
		R13_OUTSTANDING_INDIVIDUAL = r13_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR13_PROVISION_INDIVIDUAL() {
		return R13_PROVISION_INDIVIDUAL;
	}
	public void setR13_PROVISION_INDIVIDUAL(BigDecimal r13_PROVISION_INDIVIDUAL) {
		R13_PROVISION_INDIVIDUAL = r13_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR13_OUTSTANDING_GROSS() {
		return R13_OUTSTANDING_GROSS;
	}
	public void setR13_OUTSTANDING_GROSS(BigDecimal r13_OUTSTANDING_GROSS) {
		R13_OUTSTANDING_GROSS = r13_OUTSTANDING_GROSS;
	}
	public BigDecimal getR13_PROVISION_GROSS() {
		return R13_PROVISION_GROSS;
	}
	public void setR13_PROVISION_GROSS(BigDecimal r13_PROVISION_GROSS) {
		R13_PROVISION_GROSS = r13_PROVISION_GROSS;
	}
	public String getR14_S_NO() {
		return R14_S_NO;
	}
	public void setR14_S_NO(String r14_S_NO) {
		R14_S_NO = r14_S_NO;
	}
	public String getR14_STAGES() {
		return R14_STAGES;
	}
	public void setR14_STAGES(String r14_STAGES) {
		R14_STAGES = r14_STAGES;
	}
	public BigDecimal getR14_OUTSTANDING_NBFI() {
		return R14_OUTSTANDING_NBFI;
	}
	public void setR14_OUTSTANDING_NBFI(BigDecimal r14_OUTSTANDING_NBFI) {
		R14_OUTSTANDING_NBFI = r14_OUTSTANDING_NBFI;
	}
	public BigDecimal getR14_PROVISION_NBFI() {
		return R14_PROVISION_NBFI;
	}
	public void setR14_PROVISION_NBFI(BigDecimal r14_PROVISION_NBFI) {
		R14_PROVISION_NBFI = r14_PROVISION_NBFI;
	}
	public BigDecimal getR14_OUTSTANDING_FEDERAL() {
		return R14_OUTSTANDING_FEDERAL;
	}
	public void setR14_OUTSTANDING_FEDERAL(BigDecimal r14_OUTSTANDING_FEDERAL) {
		R14_OUTSTANDING_FEDERAL = r14_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR14_PROVISION_FEDERAL() {
		return R14_PROVISION_FEDERAL;
	}
	public void setR14_PROVISION_FEDERAL(BigDecimal r14_PROVISION_FEDERAL) {
		R14_PROVISION_FEDERAL = r14_PROVISION_FEDERAL;
	}
	public BigDecimal getR14_OUTSTANDING_NON_COMMERCIAL() {
		return R14_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR14_OUTSTANDING_NON_COMMERCIAL(BigDecimal r14_OUTSTANDING_NON_COMMERCIAL) {
		R14_OUTSTANDING_NON_COMMERCIAL = r14_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR14_PROVISON_NON_COMMERCIAL() {
		return R14_PROVISON_NON_COMMERCIAL;
	}
	public void setR14_PROVISON_NON_COMMERCIAL(BigDecimal r14_PROVISON_NON_COMMERCIAL) {
		R14_PROVISON_NON_COMMERCIAL = r14_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR14_OUTSTANDING_EMIRATES() {
		return R14_OUTSTANDING_EMIRATES;
	}
	public void setR14_OUTSTANDING_EMIRATES(BigDecimal r14_OUTSTANDING_EMIRATES) {
		R14_OUTSTANDING_EMIRATES = r14_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR14_PROVISION_EMIRATES() {
		return R14_PROVISION_EMIRATES;
	}
	public void setR14_PROVISION_EMIRATES(BigDecimal r14_PROVISION_EMIRATES) {
		R14_PROVISION_EMIRATES = r14_PROVISION_EMIRATES;
	}
	public BigDecimal getR14_OUTSTANDING_GOVT_GROSS() {
		return R14_OUTSTANDING_GOVT_GROSS;
	}
	public void setR14_OUTSTANDING_GOVT_GROSS(BigDecimal r14_OUTSTANDING_GOVT_GROSS) {
		R14_OUTSTANDING_GOVT_GROSS = r14_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR14_PROVISION_GOVT_GROSS() {
		return R14_PROVISION_GOVT_GROSS;
	}
	public void setR14_PROVISION_GOVT_GROSS(BigDecimal r14_PROVISION_GOVT_GROSS) {
		R14_PROVISION_GOVT_GROSS = r14_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR14_OUTSTANDING_GRE() {
		return R14_OUTSTANDING_GRE;
	}
	public void setR14_OUTSTANDING_GRE(BigDecimal r14_OUTSTANDING_GRE) {
		R14_OUTSTANDING_GRE = r14_OUTSTANDING_GRE;
	}
	public BigDecimal getR14_PROVISION_GRE() {
		return R14_PROVISION_GRE;
	}
	public void setR14_PROVISION_GRE(BigDecimal r14_PROVISION_GRE) {
		R14_PROVISION_GRE = r14_PROVISION_GRE;
	}
	public BigDecimal getR14_OUTSTANDING_CORPORATE() {
		return R14_OUTSTANDING_CORPORATE;
	}
	public void setR14_OUTSTANDING_CORPORATE(BigDecimal r14_OUTSTANDING_CORPORATE) {
		R14_OUTSTANDING_CORPORATE = r14_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR14_PROVISION_CORPORATE() {
		return R14_PROVISION_CORPORATE;
	}
	public void setR14_PROVISION_CORPORATE(BigDecimal r14_PROVISION_CORPORATE) {
		R14_PROVISION_CORPORATE = r14_PROVISION_CORPORATE;
	}
	public BigDecimal getR14_OUTSTANDING_OTHER_CORPORATE() {
		return R14_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR14_OUTSTANDING_OTHER_CORPORATE(BigDecimal r14_OUTSTANDING_OTHER_CORPORATE) {
		R14_OUTSTANDING_OTHER_CORPORATE = r14_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR14_PROVISION_OTHER_CORPORATE() {
		return R14_PROVISION_OTHER_CORPORATE;
	}
	public void setR14_PROVISION_OTHER_CORPORATE(BigDecimal r14_PROVISION_OTHER_CORPORATE) {
		R14_PROVISION_OTHER_CORPORATE = r14_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR14_OUTSTANDING_HIGH() {
		return R14_OUTSTANDING_HIGH;
	}
	public void setR14_OUTSTANDING_HIGH(BigDecimal r14_OUTSTANDING_HIGH) {
		R14_OUTSTANDING_HIGH = r14_OUTSTANDING_HIGH;
	}
	public BigDecimal getR14_PROVISION_HIGH() {
		return R14_PROVISION_HIGH;
	}
	public void setR14_PROVISION_HIGH(BigDecimal r14_PROVISION_HIGH) {
		R14_PROVISION_HIGH = r14_PROVISION_HIGH;
	}
	public BigDecimal getR14_OUTSTANDING_SMALL() {
		return R14_OUTSTANDING_SMALL;
	}
	public void setR14_OUTSTANDING_SMALL(BigDecimal r14_OUTSTANDING_SMALL) {
		R14_OUTSTANDING_SMALL = r14_OUTSTANDING_SMALL;
	}
	public BigDecimal getR14_PROVISION_SMALL() {
		return R14_PROVISION_SMALL;
	}
	public void setR14_PROVISION_SMALL(BigDecimal r14_PROVISION_SMALL) {
		R14_PROVISION_SMALL = r14_PROVISION_SMALL;
	}
	public BigDecimal getR14_OUTSTANDING_INDIVIDUAL() {
		return R14_OUTSTANDING_INDIVIDUAL;
	}
	public void setR14_OUTSTANDING_INDIVIDUAL(BigDecimal r14_OUTSTANDING_INDIVIDUAL) {
		R14_OUTSTANDING_INDIVIDUAL = r14_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR14_PROVISION_INDIVIDUAL() {
		return R14_PROVISION_INDIVIDUAL;
	}
	public void setR14_PROVISION_INDIVIDUAL(BigDecimal r14_PROVISION_INDIVIDUAL) {
		R14_PROVISION_INDIVIDUAL = r14_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR14_OUTSTANDING_GROSS() {
		return R14_OUTSTANDING_GROSS;
	}
	public void setR14_OUTSTANDING_GROSS(BigDecimal r14_OUTSTANDING_GROSS) {
		R14_OUTSTANDING_GROSS = r14_OUTSTANDING_GROSS;
	}
	public BigDecimal getR14_PROVISION_GROSS() {
		return R14_PROVISION_GROSS;
	}
	public void setR14_PROVISION_GROSS(BigDecimal r14_PROVISION_GROSS) {
		R14_PROVISION_GROSS = r14_PROVISION_GROSS;
	}
	public String getR15_S_NO() {
		return R15_S_NO;
	}
	public void setR15_S_NO(String r15_S_NO) {
		R15_S_NO = r15_S_NO;
	}
	public String getR15_STAGES() {
		return R15_STAGES;
	}
	public void setR15_STAGES(String r15_STAGES) {
		R15_STAGES = r15_STAGES;
	}
	public BigDecimal getR15_OUTSTANDING_NBFI() {
		return R15_OUTSTANDING_NBFI;
	}
	public void setR15_OUTSTANDING_NBFI(BigDecimal r15_OUTSTANDING_NBFI) {
		R15_OUTSTANDING_NBFI = r15_OUTSTANDING_NBFI;
	}
	public BigDecimal getR15_PROVISION_NBFI() {
		return R15_PROVISION_NBFI;
	}
	public void setR15_PROVISION_NBFI(BigDecimal r15_PROVISION_NBFI) {
		R15_PROVISION_NBFI = r15_PROVISION_NBFI;
	}
	public BigDecimal getR15_OUTSTANDING_FEDERAL() {
		return R15_OUTSTANDING_FEDERAL;
	}
	public void setR15_OUTSTANDING_FEDERAL(BigDecimal r15_OUTSTANDING_FEDERAL) {
		R15_OUTSTANDING_FEDERAL = r15_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR15_PROVISION_FEDERAL() {
		return R15_PROVISION_FEDERAL;
	}
	public void setR15_PROVISION_FEDERAL(BigDecimal r15_PROVISION_FEDERAL) {
		R15_PROVISION_FEDERAL = r15_PROVISION_FEDERAL;
	}
	public BigDecimal getR15_OUTSTANDING_NON_COMMERCIAL() {
		return R15_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR15_OUTSTANDING_NON_COMMERCIAL(BigDecimal r15_OUTSTANDING_NON_COMMERCIAL) {
		R15_OUTSTANDING_NON_COMMERCIAL = r15_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR15_PROVISON_NON_COMMERCIAL() {
		return R15_PROVISON_NON_COMMERCIAL;
	}
	public void setR15_PROVISON_NON_COMMERCIAL(BigDecimal r15_PROVISON_NON_COMMERCIAL) {
		R15_PROVISON_NON_COMMERCIAL = r15_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR15_OUTSTANDING_EMIRATES() {
		return R15_OUTSTANDING_EMIRATES;
	}
	public void setR15_OUTSTANDING_EMIRATES(BigDecimal r15_OUTSTANDING_EMIRATES) {
		R15_OUTSTANDING_EMIRATES = r15_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR15_PROVISION_EMIRATES() {
		return R15_PROVISION_EMIRATES;
	}
	public void setR15_PROVISION_EMIRATES(BigDecimal r15_PROVISION_EMIRATES) {
		R15_PROVISION_EMIRATES = r15_PROVISION_EMIRATES;
	}
	public BigDecimal getR15_OUTSTANDING_GOVT_GROSS() {
		return R15_OUTSTANDING_GOVT_GROSS;
	}
	public void setR15_OUTSTANDING_GOVT_GROSS(BigDecimal r15_OUTSTANDING_GOVT_GROSS) {
		R15_OUTSTANDING_GOVT_GROSS = r15_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR15_PROVISION_GOVT_GROSS() {
		return R15_PROVISION_GOVT_GROSS;
	}
	public void setR15_PROVISION_GOVT_GROSS(BigDecimal r15_PROVISION_GOVT_GROSS) {
		R15_PROVISION_GOVT_GROSS = r15_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR15_OUTSTANDING_GRE() {
		return R15_OUTSTANDING_GRE;
	}
	public void setR15_OUTSTANDING_GRE(BigDecimal r15_OUTSTANDING_GRE) {
		R15_OUTSTANDING_GRE = r15_OUTSTANDING_GRE;
	}
	public BigDecimal getR15_PROVISION_GRE() {
		return R15_PROVISION_GRE;
	}
	public void setR15_PROVISION_GRE(BigDecimal r15_PROVISION_GRE) {
		R15_PROVISION_GRE = r15_PROVISION_GRE;
	}
	public BigDecimal getR15_OUTSTANDING_CORPORATE() {
		return R15_OUTSTANDING_CORPORATE;
	}
	public void setR15_OUTSTANDING_CORPORATE(BigDecimal r15_OUTSTANDING_CORPORATE) {
		R15_OUTSTANDING_CORPORATE = r15_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR15_PROVISION_CORPORATE() {
		return R15_PROVISION_CORPORATE;
	}
	public void setR15_PROVISION_CORPORATE(BigDecimal r15_PROVISION_CORPORATE) {
		R15_PROVISION_CORPORATE = r15_PROVISION_CORPORATE;
	}
	public BigDecimal getR15_OUTSTANDING_OTHER_CORPORATE() {
		return R15_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR15_OUTSTANDING_OTHER_CORPORATE(BigDecimal r15_OUTSTANDING_OTHER_CORPORATE) {
		R15_OUTSTANDING_OTHER_CORPORATE = r15_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR15_PROVISION_OTHER_CORPORATE() {
		return R15_PROVISION_OTHER_CORPORATE;
	}
	public void setR15_PROVISION_OTHER_CORPORATE(BigDecimal r15_PROVISION_OTHER_CORPORATE) {
		R15_PROVISION_OTHER_CORPORATE = r15_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR15_OUTSTANDING_HIGH() {
		return R15_OUTSTANDING_HIGH;
	}
	public void setR15_OUTSTANDING_HIGH(BigDecimal r15_OUTSTANDING_HIGH) {
		R15_OUTSTANDING_HIGH = r15_OUTSTANDING_HIGH;
	}
	public BigDecimal getR15_PROVISION_HIGH() {
		return R15_PROVISION_HIGH;
	}
	public void setR15_PROVISION_HIGH(BigDecimal r15_PROVISION_HIGH) {
		R15_PROVISION_HIGH = r15_PROVISION_HIGH;
	}
	public BigDecimal getR15_OUTSTANDING_SMALL() {
		return R15_OUTSTANDING_SMALL;
	}
	public void setR15_OUTSTANDING_SMALL(BigDecimal r15_OUTSTANDING_SMALL) {
		R15_OUTSTANDING_SMALL = r15_OUTSTANDING_SMALL;
	}
	public BigDecimal getR15_PROVISION_SMALL() {
		return R15_PROVISION_SMALL;
	}
	public void setR15_PROVISION_SMALL(BigDecimal r15_PROVISION_SMALL) {
		R15_PROVISION_SMALL = r15_PROVISION_SMALL;
	}
	public BigDecimal getR15_OUTSTANDING_INDIVIDUAL() {
		return R15_OUTSTANDING_INDIVIDUAL;
	}
	public void setR15_OUTSTANDING_INDIVIDUAL(BigDecimal r15_OUTSTANDING_INDIVIDUAL) {
		R15_OUTSTANDING_INDIVIDUAL = r15_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR15_PROVISION_INDIVIDUAL() {
		return R15_PROVISION_INDIVIDUAL;
	}
	public void setR15_PROVISION_INDIVIDUAL(BigDecimal r15_PROVISION_INDIVIDUAL) {
		R15_PROVISION_INDIVIDUAL = r15_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR15_OUTSTANDING_GROSS() {
		return R15_OUTSTANDING_GROSS;
	}
	public void setR15_OUTSTANDING_GROSS(BigDecimal r15_OUTSTANDING_GROSS) {
		R15_OUTSTANDING_GROSS = r15_OUTSTANDING_GROSS;
	}
	public BigDecimal getR15_PROVISION_GROSS() {
		return R15_PROVISION_GROSS;
	}
	public void setR15_PROVISION_GROSS(BigDecimal r15_PROVISION_GROSS) {
		R15_PROVISION_GROSS = r15_PROVISION_GROSS;
	}
	public String getR16_S_NO() {
		return R16_S_NO;
	}
	public void setR16_S_NO(String r16_S_NO) {
		R16_S_NO = r16_S_NO;
	}
	public String getR16_STAGES() {
		return R16_STAGES;
	}
	public void setR16_STAGES(String r16_STAGES) {
		R16_STAGES = r16_STAGES;
	}
	public BigDecimal getR16_OUTSTANDING_NBFI() {
		return R16_OUTSTANDING_NBFI;
	}
	public void setR16_OUTSTANDING_NBFI(BigDecimal r16_OUTSTANDING_NBFI) {
		R16_OUTSTANDING_NBFI = r16_OUTSTANDING_NBFI;
	}
	public BigDecimal getR16_PROVISION_NBFI() {
		return R16_PROVISION_NBFI;
	}
	public void setR16_PROVISION_NBFI(BigDecimal r16_PROVISION_NBFI) {
		R16_PROVISION_NBFI = r16_PROVISION_NBFI;
	}
	public BigDecimal getR16_OUTSTANDING_FEDERAL() {
		return R16_OUTSTANDING_FEDERAL;
	}
	public void setR16_OUTSTANDING_FEDERAL(BigDecimal r16_OUTSTANDING_FEDERAL) {
		R16_OUTSTANDING_FEDERAL = r16_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR16_PROVISION_FEDERAL() {
		return R16_PROVISION_FEDERAL;
	}
	public void setR16_PROVISION_FEDERAL(BigDecimal r16_PROVISION_FEDERAL) {
		R16_PROVISION_FEDERAL = r16_PROVISION_FEDERAL;
	}
	public BigDecimal getR16_OUTSTANDING_NON_COMMERCIAL() {
		return R16_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR16_OUTSTANDING_NON_COMMERCIAL(BigDecimal r16_OUTSTANDING_NON_COMMERCIAL) {
		R16_OUTSTANDING_NON_COMMERCIAL = r16_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR16_PROVISON_NON_COMMERCIAL() {
		return R16_PROVISON_NON_COMMERCIAL;
	}
	public void setR16_PROVISON_NON_COMMERCIAL(BigDecimal r16_PROVISON_NON_COMMERCIAL) {
		R16_PROVISON_NON_COMMERCIAL = r16_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR16_OUTSTANDING_EMIRATES() {
		return R16_OUTSTANDING_EMIRATES;
	}
	public void setR16_OUTSTANDING_EMIRATES(BigDecimal r16_OUTSTANDING_EMIRATES) {
		R16_OUTSTANDING_EMIRATES = r16_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR16_PROVISION_EMIRATES() {
		return R16_PROVISION_EMIRATES;
	}
	public void setR16_PROVISION_EMIRATES(BigDecimal r16_PROVISION_EMIRATES) {
		R16_PROVISION_EMIRATES = r16_PROVISION_EMIRATES;
	}
	public BigDecimal getR16_OUTSTANDING_GOVT_GROSS() {
		return R16_OUTSTANDING_GOVT_GROSS;
	}
	public void setR16_OUTSTANDING_GOVT_GROSS(BigDecimal r16_OUTSTANDING_GOVT_GROSS) {
		R16_OUTSTANDING_GOVT_GROSS = r16_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR16_PROVISION_GOVT_GROSS() {
		return R16_PROVISION_GOVT_GROSS;
	}
	public void setR16_PROVISION_GOVT_GROSS(BigDecimal r16_PROVISION_GOVT_GROSS) {
		R16_PROVISION_GOVT_GROSS = r16_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR16_OUTSTANDING_GRE() {
		return R16_OUTSTANDING_GRE;
	}
	public void setR16_OUTSTANDING_GRE(BigDecimal r16_OUTSTANDING_GRE) {
		R16_OUTSTANDING_GRE = r16_OUTSTANDING_GRE;
	}
	public BigDecimal getR16_PROVISION_GRE() {
		return R16_PROVISION_GRE;
	}
	public void setR16_PROVISION_GRE(BigDecimal r16_PROVISION_GRE) {
		R16_PROVISION_GRE = r16_PROVISION_GRE;
	}
	public BigDecimal getR16_OUTSTANDING_CORPORATE() {
		return R16_OUTSTANDING_CORPORATE;
	}
	public void setR16_OUTSTANDING_CORPORATE(BigDecimal r16_OUTSTANDING_CORPORATE) {
		R16_OUTSTANDING_CORPORATE = r16_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR16_PROVISION_CORPORATE() {
		return R16_PROVISION_CORPORATE;
	}
	public void setR16_PROVISION_CORPORATE(BigDecimal r16_PROVISION_CORPORATE) {
		R16_PROVISION_CORPORATE = r16_PROVISION_CORPORATE;
	}
	public BigDecimal getR16_OUTSTANDING_OTHER_CORPORATE() {
		return R16_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR16_OUTSTANDING_OTHER_CORPORATE(BigDecimal r16_OUTSTANDING_OTHER_CORPORATE) {
		R16_OUTSTANDING_OTHER_CORPORATE = r16_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR16_PROVISION_OTHER_CORPORATE() {
		return R16_PROVISION_OTHER_CORPORATE;
	}
	public void setR16_PROVISION_OTHER_CORPORATE(BigDecimal r16_PROVISION_OTHER_CORPORATE) {
		R16_PROVISION_OTHER_CORPORATE = r16_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR16_OUTSTANDING_HIGH() {
		return R16_OUTSTANDING_HIGH;
	}
	public void setR16_OUTSTANDING_HIGH(BigDecimal r16_OUTSTANDING_HIGH) {
		R16_OUTSTANDING_HIGH = r16_OUTSTANDING_HIGH;
	}
	public BigDecimal getR16_PROVISION_HIGH() {
		return R16_PROVISION_HIGH;
	}
	public void setR16_PROVISION_HIGH(BigDecimal r16_PROVISION_HIGH) {
		R16_PROVISION_HIGH = r16_PROVISION_HIGH;
	}
	public BigDecimal getR16_OUTSTANDING_SMALL() {
		return R16_OUTSTANDING_SMALL;
	}
	public void setR16_OUTSTANDING_SMALL(BigDecimal r16_OUTSTANDING_SMALL) {
		R16_OUTSTANDING_SMALL = r16_OUTSTANDING_SMALL;
	}
	public BigDecimal getR16_PROVISION_SMALL() {
		return R16_PROVISION_SMALL;
	}
	public void setR16_PROVISION_SMALL(BigDecimal r16_PROVISION_SMALL) {
		R16_PROVISION_SMALL = r16_PROVISION_SMALL;
	}
	public BigDecimal getR16_OUTSTANDING_INDIVIDUAL() {
		return R16_OUTSTANDING_INDIVIDUAL;
	}
	public void setR16_OUTSTANDING_INDIVIDUAL(BigDecimal r16_OUTSTANDING_INDIVIDUAL) {
		R16_OUTSTANDING_INDIVIDUAL = r16_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR16_PROVISION_INDIVIDUAL() {
		return R16_PROVISION_INDIVIDUAL;
	}
	public void setR16_PROVISION_INDIVIDUAL(BigDecimal r16_PROVISION_INDIVIDUAL) {
		R16_PROVISION_INDIVIDUAL = r16_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR16_OUTSTANDING_GROSS() {
		return R16_OUTSTANDING_GROSS;
	}
	public void setR16_OUTSTANDING_GROSS(BigDecimal r16_OUTSTANDING_GROSS) {
		R16_OUTSTANDING_GROSS = r16_OUTSTANDING_GROSS;
	}
	public BigDecimal getR16_PROVISION_GROSS() {
		return R16_PROVISION_GROSS;
	}
	public void setR16_PROVISION_GROSS(BigDecimal r16_PROVISION_GROSS) {
		R16_PROVISION_GROSS = r16_PROVISION_GROSS;
	}
	public String getR17_S_NO() {
		return R17_S_NO;
	}
	public void setR17_S_NO(String r17_S_NO) {
		R17_S_NO = r17_S_NO;
	}
	public String getR17_STAGES() {
		return R17_STAGES;
	}
	public void setR17_STAGES(String r17_STAGES) {
		R17_STAGES = r17_STAGES;
	}
	public BigDecimal getR17_OUTSTANDING_NBFI() {
		return R17_OUTSTANDING_NBFI;
	}
	public void setR17_OUTSTANDING_NBFI(BigDecimal r17_OUTSTANDING_NBFI) {
		R17_OUTSTANDING_NBFI = r17_OUTSTANDING_NBFI;
	}
	public BigDecimal getR17_PROVISION_NBFI() {
		return R17_PROVISION_NBFI;
	}
	public void setR17_PROVISION_NBFI(BigDecimal r17_PROVISION_NBFI) {
		R17_PROVISION_NBFI = r17_PROVISION_NBFI;
	}
	public BigDecimal getR17_OUTSTANDING_FEDERAL() {
		return R17_OUTSTANDING_FEDERAL;
	}
	public void setR17_OUTSTANDING_FEDERAL(BigDecimal r17_OUTSTANDING_FEDERAL) {
		R17_OUTSTANDING_FEDERAL = r17_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR17_PROVISION_FEDERAL() {
		return R17_PROVISION_FEDERAL;
	}
	public void setR17_PROVISION_FEDERAL(BigDecimal r17_PROVISION_FEDERAL) {
		R17_PROVISION_FEDERAL = r17_PROVISION_FEDERAL;
	}
	public BigDecimal getR17_OUTSTANDING_NON_COMMERCIAL() {
		return R17_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR17_OUTSTANDING_NON_COMMERCIAL(BigDecimal r17_OUTSTANDING_NON_COMMERCIAL) {
		R17_OUTSTANDING_NON_COMMERCIAL = r17_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR17_PROVISON_NON_COMMERCIAL() {
		return R17_PROVISON_NON_COMMERCIAL;
	}
	public void setR17_PROVISON_NON_COMMERCIAL(BigDecimal r17_PROVISON_NON_COMMERCIAL) {
		R17_PROVISON_NON_COMMERCIAL = r17_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR17_OUTSTANDING_EMIRATES() {
		return R17_OUTSTANDING_EMIRATES;
	}
	public void setR17_OUTSTANDING_EMIRATES(BigDecimal r17_OUTSTANDING_EMIRATES) {
		R17_OUTSTANDING_EMIRATES = r17_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR17_PROVISION_EMIRATES() {
		return R17_PROVISION_EMIRATES;
	}
	public void setR17_PROVISION_EMIRATES(BigDecimal r17_PROVISION_EMIRATES) {
		R17_PROVISION_EMIRATES = r17_PROVISION_EMIRATES;
	}
	public BigDecimal getR17_OUTSTANDING_GOVT_GROSS() {
		return R17_OUTSTANDING_GOVT_GROSS;
	}
	public void setR17_OUTSTANDING_GOVT_GROSS(BigDecimal r17_OUTSTANDING_GOVT_GROSS) {
		R17_OUTSTANDING_GOVT_GROSS = r17_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR17_PROVISION_GOVT_GROSS() {
		return R17_PROVISION_GOVT_GROSS;
	}
	public void setR17_PROVISION_GOVT_GROSS(BigDecimal r17_PROVISION_GOVT_GROSS) {
		R17_PROVISION_GOVT_GROSS = r17_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR17_OUTSTANDING_GRE() {
		return R17_OUTSTANDING_GRE;
	}
	public void setR17_OUTSTANDING_GRE(BigDecimal r17_OUTSTANDING_GRE) {
		R17_OUTSTANDING_GRE = r17_OUTSTANDING_GRE;
	}
	public BigDecimal getR17_PROVISION_GRE() {
		return R17_PROVISION_GRE;
	}
	public void setR17_PROVISION_GRE(BigDecimal r17_PROVISION_GRE) {
		R17_PROVISION_GRE = r17_PROVISION_GRE;
	}
	public BigDecimal getR17_OUTSTANDING_CORPORATE() {
		return R17_OUTSTANDING_CORPORATE;
	}
	public void setR17_OUTSTANDING_CORPORATE(BigDecimal r17_OUTSTANDING_CORPORATE) {
		R17_OUTSTANDING_CORPORATE = r17_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR17_PROVISION_CORPORATE() {
		return R17_PROVISION_CORPORATE;
	}
	public void setR17_PROVISION_CORPORATE(BigDecimal r17_PROVISION_CORPORATE) {
		R17_PROVISION_CORPORATE = r17_PROVISION_CORPORATE;
	}
	public BigDecimal getR17_OUTSTANDING_OTHER_CORPORATE() {
		return R17_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR17_OUTSTANDING_OTHER_CORPORATE(BigDecimal r17_OUTSTANDING_OTHER_CORPORATE) {
		R17_OUTSTANDING_OTHER_CORPORATE = r17_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR17_PROVISION_OTHER_CORPORATE() {
		return R17_PROVISION_OTHER_CORPORATE;
	}
	public void setR17_PROVISION_OTHER_CORPORATE(BigDecimal r17_PROVISION_OTHER_CORPORATE) {
		R17_PROVISION_OTHER_CORPORATE = r17_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR17_OUTSTANDING_HIGH() {
		return R17_OUTSTANDING_HIGH;
	}
	public void setR17_OUTSTANDING_HIGH(BigDecimal r17_OUTSTANDING_HIGH) {
		R17_OUTSTANDING_HIGH = r17_OUTSTANDING_HIGH;
	}
	public BigDecimal getR17_PROVISION_HIGH() {
		return R17_PROVISION_HIGH;
	}
	public void setR17_PROVISION_HIGH(BigDecimal r17_PROVISION_HIGH) {
		R17_PROVISION_HIGH = r17_PROVISION_HIGH;
	}
	public BigDecimal getR17_OUTSTANDING_SMALL() {
		return R17_OUTSTANDING_SMALL;
	}
	public void setR17_OUTSTANDING_SMALL(BigDecimal r17_OUTSTANDING_SMALL) {
		R17_OUTSTANDING_SMALL = r17_OUTSTANDING_SMALL;
	}
	public BigDecimal getR17_PROVISION_SMALL() {
		return R17_PROVISION_SMALL;
	}
	public void setR17_PROVISION_SMALL(BigDecimal r17_PROVISION_SMALL) {
		R17_PROVISION_SMALL = r17_PROVISION_SMALL;
	}
	public BigDecimal getR17_OUTSTANDING_INDIVIDUAL() {
		return R17_OUTSTANDING_INDIVIDUAL;
	}
	public void setR17_OUTSTANDING_INDIVIDUAL(BigDecimal r17_OUTSTANDING_INDIVIDUAL) {
		R17_OUTSTANDING_INDIVIDUAL = r17_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR17_PROVISION_INDIVIDUAL() {
		return R17_PROVISION_INDIVIDUAL;
	}
	public void setR17_PROVISION_INDIVIDUAL(BigDecimal r17_PROVISION_INDIVIDUAL) {
		R17_PROVISION_INDIVIDUAL = r17_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR17_OUTSTANDING_GROSS() {
		return R17_OUTSTANDING_GROSS;
	}
	public void setR17_OUTSTANDING_GROSS(BigDecimal r17_OUTSTANDING_GROSS) {
		R17_OUTSTANDING_GROSS = r17_OUTSTANDING_GROSS;
	}
	public BigDecimal getR17_PROVISION_GROSS() {
		return R17_PROVISION_GROSS;
	}
	public void setR17_PROVISION_GROSS(BigDecimal r17_PROVISION_GROSS) {
		R17_PROVISION_GROSS = r17_PROVISION_GROSS;
	}
	public String getR18_S_NO() {
		return R18_S_NO;
	}
	public void setR18_S_NO(String r18_S_NO) {
		R18_S_NO = r18_S_NO;
	}
	public String getR18_STAGES() {
		return R18_STAGES;
	}
	public void setR18_STAGES(String r18_STAGES) {
		R18_STAGES = r18_STAGES;
	}
	public BigDecimal getR18_OUTSTANDING_NBFI() {
		return R18_OUTSTANDING_NBFI;
	}
	public void setR18_OUTSTANDING_NBFI(BigDecimal r18_OUTSTANDING_NBFI) {
		R18_OUTSTANDING_NBFI = r18_OUTSTANDING_NBFI;
	}
	public BigDecimal getR18_PROVISION_NBFI() {
		return R18_PROVISION_NBFI;
	}
	public void setR18_PROVISION_NBFI(BigDecimal r18_PROVISION_NBFI) {
		R18_PROVISION_NBFI = r18_PROVISION_NBFI;
	}
	public BigDecimal getR18_OUTSTANDING_FEDERAL() {
		return R18_OUTSTANDING_FEDERAL;
	}
	public void setR18_OUTSTANDING_FEDERAL(BigDecimal r18_OUTSTANDING_FEDERAL) {
		R18_OUTSTANDING_FEDERAL = r18_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR18_PROVISION_FEDERAL() {
		return R18_PROVISION_FEDERAL;
	}
	public void setR18_PROVISION_FEDERAL(BigDecimal r18_PROVISION_FEDERAL) {
		R18_PROVISION_FEDERAL = r18_PROVISION_FEDERAL;
	}
	public BigDecimal getR18_OUTSTANDING_NON_COMMERCIAL() {
		return R18_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR18_OUTSTANDING_NON_COMMERCIAL(BigDecimal r18_OUTSTANDING_NON_COMMERCIAL) {
		R18_OUTSTANDING_NON_COMMERCIAL = r18_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR18_PROVISON_NON_COMMERCIAL() {
		return R18_PROVISON_NON_COMMERCIAL;
	}
	public void setR18_PROVISON_NON_COMMERCIAL(BigDecimal r18_PROVISON_NON_COMMERCIAL) {
		R18_PROVISON_NON_COMMERCIAL = r18_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR18_OUTSTANDING_EMIRATES() {
		return R18_OUTSTANDING_EMIRATES;
	}
	public void setR18_OUTSTANDING_EMIRATES(BigDecimal r18_OUTSTANDING_EMIRATES) {
		R18_OUTSTANDING_EMIRATES = r18_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR18_PROVISION_EMIRATES() {
		return R18_PROVISION_EMIRATES;
	}
	public void setR18_PROVISION_EMIRATES(BigDecimal r18_PROVISION_EMIRATES) {
		R18_PROVISION_EMIRATES = r18_PROVISION_EMIRATES;
	}
	public BigDecimal getR18_OUTSTANDING_GOVT_GROSS() {
		return R18_OUTSTANDING_GOVT_GROSS;
	}
	public void setR18_OUTSTANDING_GOVT_GROSS(BigDecimal r18_OUTSTANDING_GOVT_GROSS) {
		R18_OUTSTANDING_GOVT_GROSS = r18_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR18_PROVISION_GOVT_GROSS() {
		return R18_PROVISION_GOVT_GROSS;
	}
	public void setR18_PROVISION_GOVT_GROSS(BigDecimal r18_PROVISION_GOVT_GROSS) {
		R18_PROVISION_GOVT_GROSS = r18_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR18_OUTSTANDING_GRE() {
		return R18_OUTSTANDING_GRE;
	}
	public void setR18_OUTSTANDING_GRE(BigDecimal r18_OUTSTANDING_GRE) {
		R18_OUTSTANDING_GRE = r18_OUTSTANDING_GRE;
	}
	public BigDecimal getR18_PROVISION_GRE() {
		return R18_PROVISION_GRE;
	}
	public void setR18_PROVISION_GRE(BigDecimal r18_PROVISION_GRE) {
		R18_PROVISION_GRE = r18_PROVISION_GRE;
	}
	public BigDecimal getR18_OUTSTANDING_CORPORATE() {
		return R18_OUTSTANDING_CORPORATE;
	}
	public void setR18_OUTSTANDING_CORPORATE(BigDecimal r18_OUTSTANDING_CORPORATE) {
		R18_OUTSTANDING_CORPORATE = r18_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR18_PROVISION_CORPORATE() {
		return R18_PROVISION_CORPORATE;
	}
	public void setR18_PROVISION_CORPORATE(BigDecimal r18_PROVISION_CORPORATE) {
		R18_PROVISION_CORPORATE = r18_PROVISION_CORPORATE;
	}
	public BigDecimal getR18_OUTSTANDING_OTHER_CORPORATE() {
		return R18_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR18_OUTSTANDING_OTHER_CORPORATE(BigDecimal r18_OUTSTANDING_OTHER_CORPORATE) {
		R18_OUTSTANDING_OTHER_CORPORATE = r18_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR18_PROVISION_OTHER_CORPORATE() {
		return R18_PROVISION_OTHER_CORPORATE;
	}
	public void setR18_PROVISION_OTHER_CORPORATE(BigDecimal r18_PROVISION_OTHER_CORPORATE) {
		R18_PROVISION_OTHER_CORPORATE = r18_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR18_OUTSTANDING_HIGH() {
		return R18_OUTSTANDING_HIGH;
	}
	public void setR18_OUTSTANDING_HIGH(BigDecimal r18_OUTSTANDING_HIGH) {
		R18_OUTSTANDING_HIGH = r18_OUTSTANDING_HIGH;
	}
	public BigDecimal getR18_PROVISION_HIGH() {
		return R18_PROVISION_HIGH;
	}
	public void setR18_PROVISION_HIGH(BigDecimal r18_PROVISION_HIGH) {
		R18_PROVISION_HIGH = r18_PROVISION_HIGH;
	}
	public BigDecimal getR18_OUTSTANDING_SMALL() {
		return R18_OUTSTANDING_SMALL;
	}
	public void setR18_OUTSTANDING_SMALL(BigDecimal r18_OUTSTANDING_SMALL) {
		R18_OUTSTANDING_SMALL = r18_OUTSTANDING_SMALL;
	}
	public BigDecimal getR18_PROVISION_SMALL() {
		return R18_PROVISION_SMALL;
	}
	public void setR18_PROVISION_SMALL(BigDecimal r18_PROVISION_SMALL) {
		R18_PROVISION_SMALL = r18_PROVISION_SMALL;
	}
	public BigDecimal getR18_OUTSTANDING_INDIVIDUAL() {
		return R18_OUTSTANDING_INDIVIDUAL;
	}
	public void setR18_OUTSTANDING_INDIVIDUAL(BigDecimal r18_OUTSTANDING_INDIVIDUAL) {
		R18_OUTSTANDING_INDIVIDUAL = r18_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR18_PROVISION_INDIVIDUAL() {
		return R18_PROVISION_INDIVIDUAL;
	}
	public void setR18_PROVISION_INDIVIDUAL(BigDecimal r18_PROVISION_INDIVIDUAL) {
		R18_PROVISION_INDIVIDUAL = r18_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR18_OUTSTANDING_GROSS() {
		return R18_OUTSTANDING_GROSS;
	}
	public void setR18_OUTSTANDING_GROSS(BigDecimal r18_OUTSTANDING_GROSS) {
		R18_OUTSTANDING_GROSS = r18_OUTSTANDING_GROSS;
	}
	public BigDecimal getR18_PROVISION_GROSS() {
		return R18_PROVISION_GROSS;
	}
	public void setR18_PROVISION_GROSS(BigDecimal r18_PROVISION_GROSS) {
		R18_PROVISION_GROSS = r18_PROVISION_GROSS;
	}
	public String getR19_S_NO() {
		return R19_S_NO;
	}
	public void setR19_S_NO(String r19_S_NO) {
		R19_S_NO = r19_S_NO;
	}
	public String getR19_STAGES() {
		return R19_STAGES;
	}
	public void setR19_STAGES(String r19_STAGES) {
		R19_STAGES = r19_STAGES;
	}
	public BigDecimal getR19_OUTSTANDING_NBFI() {
		return R19_OUTSTANDING_NBFI;
	}
	public void setR19_OUTSTANDING_NBFI(BigDecimal r19_OUTSTANDING_NBFI) {
		R19_OUTSTANDING_NBFI = r19_OUTSTANDING_NBFI;
	}
	public BigDecimal getR19_PROVISION_NBFI() {
		return R19_PROVISION_NBFI;
	}
	public void setR19_PROVISION_NBFI(BigDecimal r19_PROVISION_NBFI) {
		R19_PROVISION_NBFI = r19_PROVISION_NBFI;
	}
	public BigDecimal getR19_OUTSTANDING_FEDERAL() {
		return R19_OUTSTANDING_FEDERAL;
	}
	public void setR19_OUTSTANDING_FEDERAL(BigDecimal r19_OUTSTANDING_FEDERAL) {
		R19_OUTSTANDING_FEDERAL = r19_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR19_PROVISION_FEDERAL() {
		return R19_PROVISION_FEDERAL;
	}
	public void setR19_PROVISION_FEDERAL(BigDecimal r19_PROVISION_FEDERAL) {
		R19_PROVISION_FEDERAL = r19_PROVISION_FEDERAL;
	}
	public BigDecimal getR19_OUTSTANDING_NON_COMMERCIAL() {
		return R19_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR19_OUTSTANDING_NON_COMMERCIAL(BigDecimal r19_OUTSTANDING_NON_COMMERCIAL) {
		R19_OUTSTANDING_NON_COMMERCIAL = r19_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR19_PROVISON_NON_COMMERCIAL() {
		return R19_PROVISON_NON_COMMERCIAL;
	}
	public void setR19_PROVISON_NON_COMMERCIAL(BigDecimal r19_PROVISON_NON_COMMERCIAL) {
		R19_PROVISON_NON_COMMERCIAL = r19_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR19_OUTSTANDING_EMIRATES() {
		return R19_OUTSTANDING_EMIRATES;
	}
	public void setR19_OUTSTANDING_EMIRATES(BigDecimal r19_OUTSTANDING_EMIRATES) {
		R19_OUTSTANDING_EMIRATES = r19_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR19_PROVISION_EMIRATES() {
		return R19_PROVISION_EMIRATES;
	}
	public void setR19_PROVISION_EMIRATES(BigDecimal r19_PROVISION_EMIRATES) {
		R19_PROVISION_EMIRATES = r19_PROVISION_EMIRATES;
	}
	public BigDecimal getR19_OUTSTANDING_GOVT_GROSS() {
		return R19_OUTSTANDING_GOVT_GROSS;
	}
	public void setR19_OUTSTANDING_GOVT_GROSS(BigDecimal r19_OUTSTANDING_GOVT_GROSS) {
		R19_OUTSTANDING_GOVT_GROSS = r19_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR19_PROVISION_GOVT_GROSS() {
		return R19_PROVISION_GOVT_GROSS;
	}
	public void setR19_PROVISION_GOVT_GROSS(BigDecimal r19_PROVISION_GOVT_GROSS) {
		R19_PROVISION_GOVT_GROSS = r19_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR19_OUTSTANDING_GRE() {
		return R19_OUTSTANDING_GRE;
	}
	public void setR19_OUTSTANDING_GRE(BigDecimal r19_OUTSTANDING_GRE) {
		R19_OUTSTANDING_GRE = r19_OUTSTANDING_GRE;
	}
	public BigDecimal getR19_PROVISION_GRE() {
		return R19_PROVISION_GRE;
	}
	public void setR19_PROVISION_GRE(BigDecimal r19_PROVISION_GRE) {
		R19_PROVISION_GRE = r19_PROVISION_GRE;
	}
	public BigDecimal getR19_OUTSTANDING_CORPORATE() {
		return R19_OUTSTANDING_CORPORATE;
	}
	public void setR19_OUTSTANDING_CORPORATE(BigDecimal r19_OUTSTANDING_CORPORATE) {
		R19_OUTSTANDING_CORPORATE = r19_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR19_PROVISION_CORPORATE() {
		return R19_PROVISION_CORPORATE;
	}
	public void setR19_PROVISION_CORPORATE(BigDecimal r19_PROVISION_CORPORATE) {
		R19_PROVISION_CORPORATE = r19_PROVISION_CORPORATE;
	}
	public BigDecimal getR19_OUTSTANDING_OTHER_CORPORATE() {
		return R19_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR19_OUTSTANDING_OTHER_CORPORATE(BigDecimal r19_OUTSTANDING_OTHER_CORPORATE) {
		R19_OUTSTANDING_OTHER_CORPORATE = r19_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR19_PROVISION_OTHER_CORPORATE() {
		return R19_PROVISION_OTHER_CORPORATE;
	}
	public void setR19_PROVISION_OTHER_CORPORATE(BigDecimal r19_PROVISION_OTHER_CORPORATE) {
		R19_PROVISION_OTHER_CORPORATE = r19_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR19_OUTSTANDING_HIGH() {
		return R19_OUTSTANDING_HIGH;
	}
	public void setR19_OUTSTANDING_HIGH(BigDecimal r19_OUTSTANDING_HIGH) {
		R19_OUTSTANDING_HIGH = r19_OUTSTANDING_HIGH;
	}
	public BigDecimal getR19_PROVISION_HIGH() {
		return R19_PROVISION_HIGH;
	}
	public void setR19_PROVISION_HIGH(BigDecimal r19_PROVISION_HIGH) {
		R19_PROVISION_HIGH = r19_PROVISION_HIGH;
	}
	public BigDecimal getR19_OUTSTANDING_SMALL() {
		return R19_OUTSTANDING_SMALL;
	}
	public void setR19_OUTSTANDING_SMALL(BigDecimal r19_OUTSTANDING_SMALL) {
		R19_OUTSTANDING_SMALL = r19_OUTSTANDING_SMALL;
	}
	public BigDecimal getR19_PROVISION_SMALL() {
		return R19_PROVISION_SMALL;
	}
	public void setR19_PROVISION_SMALL(BigDecimal r19_PROVISION_SMALL) {
		R19_PROVISION_SMALL = r19_PROVISION_SMALL;
	}
	public BigDecimal getR19_OUTSTANDING_INDIVIDUAL() {
		return R19_OUTSTANDING_INDIVIDUAL;
	}
	public void setR19_OUTSTANDING_INDIVIDUAL(BigDecimal r19_OUTSTANDING_INDIVIDUAL) {
		R19_OUTSTANDING_INDIVIDUAL = r19_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR19_PROVISION_INDIVIDUAL() {
		return R19_PROVISION_INDIVIDUAL;
	}
	public void setR19_PROVISION_INDIVIDUAL(BigDecimal r19_PROVISION_INDIVIDUAL) {
		R19_PROVISION_INDIVIDUAL = r19_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR19_OUTSTANDING_GROSS() {
		return R19_OUTSTANDING_GROSS;
	}
	public void setR19_OUTSTANDING_GROSS(BigDecimal r19_OUTSTANDING_GROSS) {
		R19_OUTSTANDING_GROSS = r19_OUTSTANDING_GROSS;
	}
	public BigDecimal getR19_PROVISION_GROSS() {
		return R19_PROVISION_GROSS;
	}
	public void setR19_PROVISION_GROSS(BigDecimal r19_PROVISION_GROSS) {
		R19_PROVISION_GROSS = r19_PROVISION_GROSS;
	}
	public String getR20_S_NO() {
		return R20_S_NO;
	}
	public void setR20_S_NO(String r20_S_NO) {
		R20_S_NO = r20_S_NO;
	}
	public String getR20_STAGES() {
		return R20_STAGES;
	}
	public void setR20_STAGES(String r20_STAGES) {
		R20_STAGES = r20_STAGES;
	}
	public BigDecimal getR20_OUTSTANDING_NBFI() {
		return R20_OUTSTANDING_NBFI;
	}
	public void setR20_OUTSTANDING_NBFI(BigDecimal r20_OUTSTANDING_NBFI) {
		R20_OUTSTANDING_NBFI = r20_OUTSTANDING_NBFI;
	}
	public BigDecimal getR20_PROVISION_NBFI() {
		return R20_PROVISION_NBFI;
	}
	public void setR20_PROVISION_NBFI(BigDecimal r20_PROVISION_NBFI) {
		R20_PROVISION_NBFI = r20_PROVISION_NBFI;
	}
	public BigDecimal getR20_OUTSTANDING_FEDERAL() {
		return R20_OUTSTANDING_FEDERAL;
	}
	public void setR20_OUTSTANDING_FEDERAL(BigDecimal r20_OUTSTANDING_FEDERAL) {
		R20_OUTSTANDING_FEDERAL = r20_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR20_PROVISION_FEDERAL() {
		return R20_PROVISION_FEDERAL;
	}
	public void setR20_PROVISION_FEDERAL(BigDecimal r20_PROVISION_FEDERAL) {
		R20_PROVISION_FEDERAL = r20_PROVISION_FEDERAL;
	}
	public BigDecimal getR20_OUTSTANDING_NON_COMMERCIAL() {
		return R20_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR20_OUTSTANDING_NON_COMMERCIAL(BigDecimal r20_OUTSTANDING_NON_COMMERCIAL) {
		R20_OUTSTANDING_NON_COMMERCIAL = r20_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR20_PROVISON_NON_COMMERCIAL() {
		return R20_PROVISON_NON_COMMERCIAL;
	}
	public void setR20_PROVISON_NON_COMMERCIAL(BigDecimal r20_PROVISON_NON_COMMERCIAL) {
		R20_PROVISON_NON_COMMERCIAL = r20_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR20_OUTSTANDING_EMIRATES() {
		return R20_OUTSTANDING_EMIRATES;
	}
	public void setR20_OUTSTANDING_EMIRATES(BigDecimal r20_OUTSTANDING_EMIRATES) {
		R20_OUTSTANDING_EMIRATES = r20_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR20_PROVISION_EMIRATES() {
		return R20_PROVISION_EMIRATES;
	}
	public void setR20_PROVISION_EMIRATES(BigDecimal r20_PROVISION_EMIRATES) {
		R20_PROVISION_EMIRATES = r20_PROVISION_EMIRATES;
	}
	public BigDecimal getR20_OUTSTANDING_GOVT_GROSS() {
		return R20_OUTSTANDING_GOVT_GROSS;
	}
	public void setR20_OUTSTANDING_GOVT_GROSS(BigDecimal r20_OUTSTANDING_GOVT_GROSS) {
		R20_OUTSTANDING_GOVT_GROSS = r20_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR20_PROVISION_GOVT_GROSS() {
		return R20_PROVISION_GOVT_GROSS;
	}
	public void setR20_PROVISION_GOVT_GROSS(BigDecimal r20_PROVISION_GOVT_GROSS) {
		R20_PROVISION_GOVT_GROSS = r20_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR20_OUTSTANDING_GRE() {
		return R20_OUTSTANDING_GRE;
	}
	public void setR20_OUTSTANDING_GRE(BigDecimal r20_OUTSTANDING_GRE) {
		R20_OUTSTANDING_GRE = r20_OUTSTANDING_GRE;
	}
	public BigDecimal getR20_PROVISION_GRE() {
		return R20_PROVISION_GRE;
	}
	public void setR20_PROVISION_GRE(BigDecimal r20_PROVISION_GRE) {
		R20_PROVISION_GRE = r20_PROVISION_GRE;
	}
	public BigDecimal getR20_OUTSTANDING_CORPORATE() {
		return R20_OUTSTANDING_CORPORATE;
	}
	public void setR20_OUTSTANDING_CORPORATE(BigDecimal r20_OUTSTANDING_CORPORATE) {
		R20_OUTSTANDING_CORPORATE = r20_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR20_PROVISION_CORPORATE() {
		return R20_PROVISION_CORPORATE;
	}
	public void setR20_PROVISION_CORPORATE(BigDecimal r20_PROVISION_CORPORATE) {
		R20_PROVISION_CORPORATE = r20_PROVISION_CORPORATE;
	}
	public BigDecimal getR20_OUTSTANDING_OTHER_CORPORATE() {
		return R20_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR20_OUTSTANDING_OTHER_CORPORATE(BigDecimal r20_OUTSTANDING_OTHER_CORPORATE) {
		R20_OUTSTANDING_OTHER_CORPORATE = r20_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR20_PROVISION_OTHER_CORPORATE() {
		return R20_PROVISION_OTHER_CORPORATE;
	}
	public void setR20_PROVISION_OTHER_CORPORATE(BigDecimal r20_PROVISION_OTHER_CORPORATE) {
		R20_PROVISION_OTHER_CORPORATE = r20_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR20_OUTSTANDING_HIGH() {
		return R20_OUTSTANDING_HIGH;
	}
	public void setR20_OUTSTANDING_HIGH(BigDecimal r20_OUTSTANDING_HIGH) {
		R20_OUTSTANDING_HIGH = r20_OUTSTANDING_HIGH;
	}
	public BigDecimal getR20_PROVISION_HIGH() {
		return R20_PROVISION_HIGH;
	}
	public void setR20_PROVISION_HIGH(BigDecimal r20_PROVISION_HIGH) {
		R20_PROVISION_HIGH = r20_PROVISION_HIGH;
	}
	public BigDecimal getR20_OUTSTANDING_SMALL() {
		return R20_OUTSTANDING_SMALL;
	}
	public void setR20_OUTSTANDING_SMALL(BigDecimal r20_OUTSTANDING_SMALL) {
		R20_OUTSTANDING_SMALL = r20_OUTSTANDING_SMALL;
	}
	public BigDecimal getR20_PROVISION_SMALL() {
		return R20_PROVISION_SMALL;
	}
	public void setR20_PROVISION_SMALL(BigDecimal r20_PROVISION_SMALL) {
		R20_PROVISION_SMALL = r20_PROVISION_SMALL;
	}
	public BigDecimal getR20_OUTSTANDING_INDIVIDUAL() {
		return R20_OUTSTANDING_INDIVIDUAL;
	}
	public void setR20_OUTSTANDING_INDIVIDUAL(BigDecimal r20_OUTSTANDING_INDIVIDUAL) {
		R20_OUTSTANDING_INDIVIDUAL = r20_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR20_PROVISION_INDIVIDUAL() {
		return R20_PROVISION_INDIVIDUAL;
	}
	public void setR20_PROVISION_INDIVIDUAL(BigDecimal r20_PROVISION_INDIVIDUAL) {
		R20_PROVISION_INDIVIDUAL = r20_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR20_OUTSTANDING_GROSS() {
		return R20_OUTSTANDING_GROSS;
	}
	public void setR20_OUTSTANDING_GROSS(BigDecimal r20_OUTSTANDING_GROSS) {
		R20_OUTSTANDING_GROSS = r20_OUTSTANDING_GROSS;
	}
	public BigDecimal getR20_PROVISION_GROSS() {
		return R20_PROVISION_GROSS;
	}
	public void setR20_PROVISION_GROSS(BigDecimal r20_PROVISION_GROSS) {
		R20_PROVISION_GROSS = r20_PROVISION_GROSS;
	}
	public String getR21_S_NO() {
		return R21_S_NO;
	}
	public void setR21_S_NO(String r21_S_NO) {
		R21_S_NO = r21_S_NO;
	}
	public String getR21_STAGES() {
		return R21_STAGES;
	}
	public void setR21_STAGES(String r21_STAGES) {
		R21_STAGES = r21_STAGES;
	}
	public BigDecimal getR21_OUTSTANDING_NBFI() {
		return R21_OUTSTANDING_NBFI;
	}
	public void setR21_OUTSTANDING_NBFI(BigDecimal r21_OUTSTANDING_NBFI) {
		R21_OUTSTANDING_NBFI = r21_OUTSTANDING_NBFI;
	}
	public BigDecimal getR21_PROVISION_NBFI() {
		return R21_PROVISION_NBFI;
	}
	public void setR21_PROVISION_NBFI(BigDecimal r21_PROVISION_NBFI) {
		R21_PROVISION_NBFI = r21_PROVISION_NBFI;
	}
	public BigDecimal getR21_OUTSTANDING_FEDERAL() {
		return R21_OUTSTANDING_FEDERAL;
	}
	public void setR21_OUTSTANDING_FEDERAL(BigDecimal r21_OUTSTANDING_FEDERAL) {
		R21_OUTSTANDING_FEDERAL = r21_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR21_PROVISION_FEDERAL() {
		return R21_PROVISION_FEDERAL;
	}
	public void setR21_PROVISION_FEDERAL(BigDecimal r21_PROVISION_FEDERAL) {
		R21_PROVISION_FEDERAL = r21_PROVISION_FEDERAL;
	}
	public BigDecimal getR21_OUTSTANDING_NON_COMMERCIAL() {
		return R21_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR21_OUTSTANDING_NON_COMMERCIAL(BigDecimal r21_OUTSTANDING_NON_COMMERCIAL) {
		R21_OUTSTANDING_NON_COMMERCIAL = r21_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR21_PROVISON_NON_COMMERCIAL() {
		return R21_PROVISON_NON_COMMERCIAL;
	}
	public void setR21_PROVISON_NON_COMMERCIAL(BigDecimal r21_PROVISON_NON_COMMERCIAL) {
		R21_PROVISON_NON_COMMERCIAL = r21_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR21_OUTSTANDING_EMIRATES() {
		return R21_OUTSTANDING_EMIRATES;
	}
	public void setR21_OUTSTANDING_EMIRATES(BigDecimal r21_OUTSTANDING_EMIRATES) {
		R21_OUTSTANDING_EMIRATES = r21_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR21_PROVISION_EMIRATES() {
		return R21_PROVISION_EMIRATES;
	}
	public void setR21_PROVISION_EMIRATES(BigDecimal r21_PROVISION_EMIRATES) {
		R21_PROVISION_EMIRATES = r21_PROVISION_EMIRATES;
	}
	public BigDecimal getR21_OUTSTANDING_GOVT_GROSS() {
		return R21_OUTSTANDING_GOVT_GROSS;
	}
	public void setR21_OUTSTANDING_GOVT_GROSS(BigDecimal r21_OUTSTANDING_GOVT_GROSS) {
		R21_OUTSTANDING_GOVT_GROSS = r21_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR21_PROVISION_GOVT_GROSS() {
		return R21_PROVISION_GOVT_GROSS;
	}
	public void setR21_PROVISION_GOVT_GROSS(BigDecimal r21_PROVISION_GOVT_GROSS) {
		R21_PROVISION_GOVT_GROSS = r21_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR21_OUTSTANDING_GRE() {
		return R21_OUTSTANDING_GRE;
	}
	public void setR21_OUTSTANDING_GRE(BigDecimal r21_OUTSTANDING_GRE) {
		R21_OUTSTANDING_GRE = r21_OUTSTANDING_GRE;
	}
	public BigDecimal getR21_PROVISION_GRE() {
		return R21_PROVISION_GRE;
	}
	public void setR21_PROVISION_GRE(BigDecimal r21_PROVISION_GRE) {
		R21_PROVISION_GRE = r21_PROVISION_GRE;
	}
	public BigDecimal getR21_OUTSTANDING_CORPORATE() {
		return R21_OUTSTANDING_CORPORATE;
	}
	public void setR21_OUTSTANDING_CORPORATE(BigDecimal r21_OUTSTANDING_CORPORATE) {
		R21_OUTSTANDING_CORPORATE = r21_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR21_PROVISION_CORPORATE() {
		return R21_PROVISION_CORPORATE;
	}
	public void setR21_PROVISION_CORPORATE(BigDecimal r21_PROVISION_CORPORATE) {
		R21_PROVISION_CORPORATE = r21_PROVISION_CORPORATE;
	}
	public BigDecimal getR21_OUTSTANDING_OTHER_CORPORATE() {
		return R21_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR21_OUTSTANDING_OTHER_CORPORATE(BigDecimal r21_OUTSTANDING_OTHER_CORPORATE) {
		R21_OUTSTANDING_OTHER_CORPORATE = r21_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR21_PROVISION_OTHER_CORPORATE() {
		return R21_PROVISION_OTHER_CORPORATE;
	}
	public void setR21_PROVISION_OTHER_CORPORATE(BigDecimal r21_PROVISION_OTHER_CORPORATE) {
		R21_PROVISION_OTHER_CORPORATE = r21_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR21_OUTSTANDING_HIGH() {
		return R21_OUTSTANDING_HIGH;
	}
	public void setR21_OUTSTANDING_HIGH(BigDecimal r21_OUTSTANDING_HIGH) {
		R21_OUTSTANDING_HIGH = r21_OUTSTANDING_HIGH;
	}
	public BigDecimal getR21_PROVISION_HIGH() {
		return R21_PROVISION_HIGH;
	}
	public void setR21_PROVISION_HIGH(BigDecimal r21_PROVISION_HIGH) {
		R21_PROVISION_HIGH = r21_PROVISION_HIGH;
	}
	public BigDecimal getR21_OUTSTANDING_SMALL() {
		return R21_OUTSTANDING_SMALL;
	}
	public void setR21_OUTSTANDING_SMALL(BigDecimal r21_OUTSTANDING_SMALL) {
		R21_OUTSTANDING_SMALL = r21_OUTSTANDING_SMALL;
	}
	public BigDecimal getR21_PROVISION_SMALL() {
		return R21_PROVISION_SMALL;
	}
	public void setR21_PROVISION_SMALL(BigDecimal r21_PROVISION_SMALL) {
		R21_PROVISION_SMALL = r21_PROVISION_SMALL;
	}
	public BigDecimal getR21_OUTSTANDING_INDIVIDUAL() {
		return R21_OUTSTANDING_INDIVIDUAL;
	}
	public void setR21_OUTSTANDING_INDIVIDUAL(BigDecimal r21_OUTSTANDING_INDIVIDUAL) {
		R21_OUTSTANDING_INDIVIDUAL = r21_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR21_PROVISION_INDIVIDUAL() {
		return R21_PROVISION_INDIVIDUAL;
	}
	public void setR21_PROVISION_INDIVIDUAL(BigDecimal r21_PROVISION_INDIVIDUAL) {
		R21_PROVISION_INDIVIDUAL = r21_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR21_OUTSTANDING_GROSS() {
		return R21_OUTSTANDING_GROSS;
	}
	public void setR21_OUTSTANDING_GROSS(BigDecimal r21_OUTSTANDING_GROSS) {
		R21_OUTSTANDING_GROSS = r21_OUTSTANDING_GROSS;
	}
	public BigDecimal getR21_PROVISION_GROSS() {
		return R21_PROVISION_GROSS;
	}
	public void setR21_PROVISION_GROSS(BigDecimal r21_PROVISION_GROSS) {
		R21_PROVISION_GROSS = r21_PROVISION_GROSS;
	}
	public String getR22_S_NO() {
		return R22_S_NO;
	}
	public void setR22_S_NO(String r22_S_NO) {
		R22_S_NO = r22_S_NO;
	}
	public String getR22_STAGES() {
		return R22_STAGES;
	}
	public void setR22_STAGES(String r22_STAGES) {
		R22_STAGES = r22_STAGES;
	}
	public BigDecimal getR22_OUTSTANDING_NBFI() {
		return R22_OUTSTANDING_NBFI;
	}
	public void setR22_OUTSTANDING_NBFI(BigDecimal r22_OUTSTANDING_NBFI) {
		R22_OUTSTANDING_NBFI = r22_OUTSTANDING_NBFI;
	}
	public BigDecimal getR22_PROVISION_NBFI() {
		return R22_PROVISION_NBFI;
	}
	public void setR22_PROVISION_NBFI(BigDecimal r22_PROVISION_NBFI) {
		R22_PROVISION_NBFI = r22_PROVISION_NBFI;
	}
	public BigDecimal getR22_OUTSTANDING_FEDERAL() {
		return R22_OUTSTANDING_FEDERAL;
	}
	public void setR22_OUTSTANDING_FEDERAL(BigDecimal r22_OUTSTANDING_FEDERAL) {
		R22_OUTSTANDING_FEDERAL = r22_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR22_PROVISION_FEDERAL() {
		return R22_PROVISION_FEDERAL;
	}
	public void setR22_PROVISION_FEDERAL(BigDecimal r22_PROVISION_FEDERAL) {
		R22_PROVISION_FEDERAL = r22_PROVISION_FEDERAL;
	}
	public BigDecimal getR22_OUTSTANDING_NON_COMMERCIAL() {
		return R22_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR22_OUTSTANDING_NON_COMMERCIAL(BigDecimal r22_OUTSTANDING_NON_COMMERCIAL) {
		R22_OUTSTANDING_NON_COMMERCIAL = r22_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR22_PROVISON_NON_COMMERCIAL() {
		return R22_PROVISON_NON_COMMERCIAL;
	}
	public void setR22_PROVISON_NON_COMMERCIAL(BigDecimal r22_PROVISON_NON_COMMERCIAL) {
		R22_PROVISON_NON_COMMERCIAL = r22_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR22_OUTSTANDING_EMIRATES() {
		return R22_OUTSTANDING_EMIRATES;
	}
	public void setR22_OUTSTANDING_EMIRATES(BigDecimal r22_OUTSTANDING_EMIRATES) {
		R22_OUTSTANDING_EMIRATES = r22_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR22_PROVISION_EMIRATES() {
		return R22_PROVISION_EMIRATES;
	}
	public void setR22_PROVISION_EMIRATES(BigDecimal r22_PROVISION_EMIRATES) {
		R22_PROVISION_EMIRATES = r22_PROVISION_EMIRATES;
	}
	public BigDecimal getR22_OUTSTANDING_GOVT_GROSS() {
		return R22_OUTSTANDING_GOVT_GROSS;
	}
	public void setR22_OUTSTANDING_GOVT_GROSS(BigDecimal r22_OUTSTANDING_GOVT_GROSS) {
		R22_OUTSTANDING_GOVT_GROSS = r22_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR22_PROVISION_GOVT_GROSS() {
		return R22_PROVISION_GOVT_GROSS;
	}
	public void setR22_PROVISION_GOVT_GROSS(BigDecimal r22_PROVISION_GOVT_GROSS) {
		R22_PROVISION_GOVT_GROSS = r22_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR22_OUTSTANDING_GRE() {
		return R22_OUTSTANDING_GRE;
	}
	public void setR22_OUTSTANDING_GRE(BigDecimal r22_OUTSTANDING_GRE) {
		R22_OUTSTANDING_GRE = r22_OUTSTANDING_GRE;
	}
	public BigDecimal getR22_PROVISION_GRE() {
		return R22_PROVISION_GRE;
	}
	public void setR22_PROVISION_GRE(BigDecimal r22_PROVISION_GRE) {
		R22_PROVISION_GRE = r22_PROVISION_GRE;
	}
	public BigDecimal getR22_OUTSTANDING_CORPORATE() {
		return R22_OUTSTANDING_CORPORATE;
	}
	public void setR22_OUTSTANDING_CORPORATE(BigDecimal r22_OUTSTANDING_CORPORATE) {
		R22_OUTSTANDING_CORPORATE = r22_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR22_PROVISION_CORPORATE() {
		return R22_PROVISION_CORPORATE;
	}
	public void setR22_PROVISION_CORPORATE(BigDecimal r22_PROVISION_CORPORATE) {
		R22_PROVISION_CORPORATE = r22_PROVISION_CORPORATE;
	}
	public BigDecimal getR22_OUTSTANDING_OTHER_CORPORATE() {
		return R22_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR22_OUTSTANDING_OTHER_CORPORATE(BigDecimal r22_OUTSTANDING_OTHER_CORPORATE) {
		R22_OUTSTANDING_OTHER_CORPORATE = r22_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR22_PROVISION_OTHER_CORPORATE() {
		return R22_PROVISION_OTHER_CORPORATE;
	}
	public void setR22_PROVISION_OTHER_CORPORATE(BigDecimal r22_PROVISION_OTHER_CORPORATE) {
		R22_PROVISION_OTHER_CORPORATE = r22_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR22_OUTSTANDING_HIGH() {
		return R22_OUTSTANDING_HIGH;
	}
	public void setR22_OUTSTANDING_HIGH(BigDecimal r22_OUTSTANDING_HIGH) {
		R22_OUTSTANDING_HIGH = r22_OUTSTANDING_HIGH;
	}
	public BigDecimal getR22_PROVISION_HIGH() {
		return R22_PROVISION_HIGH;
	}
	public void setR22_PROVISION_HIGH(BigDecimal r22_PROVISION_HIGH) {
		R22_PROVISION_HIGH = r22_PROVISION_HIGH;
	}
	public BigDecimal getR22_OUTSTANDING_SMALL() {
		return R22_OUTSTANDING_SMALL;
	}
	public void setR22_OUTSTANDING_SMALL(BigDecimal r22_OUTSTANDING_SMALL) {
		R22_OUTSTANDING_SMALL = r22_OUTSTANDING_SMALL;
	}
	public BigDecimal getR22_PROVISION_SMALL() {
		return R22_PROVISION_SMALL;
	}
	public void setR22_PROVISION_SMALL(BigDecimal r22_PROVISION_SMALL) {
		R22_PROVISION_SMALL = r22_PROVISION_SMALL;
	}
	public BigDecimal getR22_OUTSTANDING_INDIVIDUAL() {
		return R22_OUTSTANDING_INDIVIDUAL;
	}
	public void setR22_OUTSTANDING_INDIVIDUAL(BigDecimal r22_OUTSTANDING_INDIVIDUAL) {
		R22_OUTSTANDING_INDIVIDUAL = r22_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR22_PROVISION_INDIVIDUAL() {
		return R22_PROVISION_INDIVIDUAL;
	}
	public void setR22_PROVISION_INDIVIDUAL(BigDecimal r22_PROVISION_INDIVIDUAL) {
		R22_PROVISION_INDIVIDUAL = r22_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR22_OUTSTANDING_GROSS() {
		return R22_OUTSTANDING_GROSS;
	}
	public void setR22_OUTSTANDING_GROSS(BigDecimal r22_OUTSTANDING_GROSS) {
		R22_OUTSTANDING_GROSS = r22_OUTSTANDING_GROSS;
	}
	public BigDecimal getR22_PROVISION_GROSS() {
		return R22_PROVISION_GROSS;
	}
	public void setR22_PROVISION_GROSS(BigDecimal r22_PROVISION_GROSS) {
		R22_PROVISION_GROSS = r22_PROVISION_GROSS;
	}
	public String getR23_S_NO() {
		return R23_S_NO;
	}
	public void setR23_S_NO(String r23_S_NO) {
		R23_S_NO = r23_S_NO;
	}
	public String getR23_STAGES() {
		return R23_STAGES;
	}
	public void setR23_STAGES(String r23_STAGES) {
		R23_STAGES = r23_STAGES;
	}
	public BigDecimal getR23_OUTSTANDING_NBFI() {
		return R23_OUTSTANDING_NBFI;
	}
	public void setR23_OUTSTANDING_NBFI(BigDecimal r23_OUTSTANDING_NBFI) {
		R23_OUTSTANDING_NBFI = r23_OUTSTANDING_NBFI;
	}
	public BigDecimal getR23_PROVISION_NBFI() {
		return R23_PROVISION_NBFI;
	}
	public void setR23_PROVISION_NBFI(BigDecimal r23_PROVISION_NBFI) {
		R23_PROVISION_NBFI = r23_PROVISION_NBFI;
	}
	public BigDecimal getR23_OUTSTANDING_FEDERAL() {
		return R23_OUTSTANDING_FEDERAL;
	}
	public void setR23_OUTSTANDING_FEDERAL(BigDecimal r23_OUTSTANDING_FEDERAL) {
		R23_OUTSTANDING_FEDERAL = r23_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR23_PROVISION_FEDERAL() {
		return R23_PROVISION_FEDERAL;
	}
	public void setR23_PROVISION_FEDERAL(BigDecimal r23_PROVISION_FEDERAL) {
		R23_PROVISION_FEDERAL = r23_PROVISION_FEDERAL;
	}
	public BigDecimal getR23_OUTSTANDING_NON_COMMERCIAL() {
		return R23_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR23_OUTSTANDING_NON_COMMERCIAL(BigDecimal r23_OUTSTANDING_NON_COMMERCIAL) {
		R23_OUTSTANDING_NON_COMMERCIAL = r23_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR23_PROVISON_NON_COMMERCIAL() {
		return R23_PROVISON_NON_COMMERCIAL;
	}
	public void setR23_PROVISON_NON_COMMERCIAL(BigDecimal r23_PROVISON_NON_COMMERCIAL) {
		R23_PROVISON_NON_COMMERCIAL = r23_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR23_OUTSTANDING_EMIRATES() {
		return R23_OUTSTANDING_EMIRATES;
	}
	public void setR23_OUTSTANDING_EMIRATES(BigDecimal r23_OUTSTANDING_EMIRATES) {
		R23_OUTSTANDING_EMIRATES = r23_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR23_PROVISION_EMIRATES() {
		return R23_PROVISION_EMIRATES;
	}
	public void setR23_PROVISION_EMIRATES(BigDecimal r23_PROVISION_EMIRATES) {
		R23_PROVISION_EMIRATES = r23_PROVISION_EMIRATES;
	}
	public BigDecimal getR23_OUTSTANDING_GOVT_GROSS() {
		return R23_OUTSTANDING_GOVT_GROSS;
	}
	public void setR23_OUTSTANDING_GOVT_GROSS(BigDecimal r23_OUTSTANDING_GOVT_GROSS) {
		R23_OUTSTANDING_GOVT_GROSS = r23_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR23_PROVISION_GOVT_GROSS() {
		return R23_PROVISION_GOVT_GROSS;
	}
	public void setR23_PROVISION_GOVT_GROSS(BigDecimal r23_PROVISION_GOVT_GROSS) {
		R23_PROVISION_GOVT_GROSS = r23_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR23_OUTSTANDING_GRE() {
		return R23_OUTSTANDING_GRE;
	}
	public void setR23_OUTSTANDING_GRE(BigDecimal r23_OUTSTANDING_GRE) {
		R23_OUTSTANDING_GRE = r23_OUTSTANDING_GRE;
	}
	public BigDecimal getR23_PROVISION_GRE() {
		return R23_PROVISION_GRE;
	}
	public void setR23_PROVISION_GRE(BigDecimal r23_PROVISION_GRE) {
		R23_PROVISION_GRE = r23_PROVISION_GRE;
	}
	public BigDecimal getR23_OUTSTANDING_CORPORATE() {
		return R23_OUTSTANDING_CORPORATE;
	}
	public void setR23_OUTSTANDING_CORPORATE(BigDecimal r23_OUTSTANDING_CORPORATE) {
		R23_OUTSTANDING_CORPORATE = r23_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR23_PROVISION_CORPORATE() {
		return R23_PROVISION_CORPORATE;
	}
	public void setR23_PROVISION_CORPORATE(BigDecimal r23_PROVISION_CORPORATE) {
		R23_PROVISION_CORPORATE = r23_PROVISION_CORPORATE;
	}
	public BigDecimal getR23_OUTSTANDING_OTHER_CORPORATE() {
		return R23_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR23_OUTSTANDING_OTHER_CORPORATE(BigDecimal r23_OUTSTANDING_OTHER_CORPORATE) {
		R23_OUTSTANDING_OTHER_CORPORATE = r23_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR23_PROVISION_OTHER_CORPORATE() {
		return R23_PROVISION_OTHER_CORPORATE;
	}
	public void setR23_PROVISION_OTHER_CORPORATE(BigDecimal r23_PROVISION_OTHER_CORPORATE) {
		R23_PROVISION_OTHER_CORPORATE = r23_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR23_OUTSTANDING_HIGH() {
		return R23_OUTSTANDING_HIGH;
	}
	public void setR23_OUTSTANDING_HIGH(BigDecimal r23_OUTSTANDING_HIGH) {
		R23_OUTSTANDING_HIGH = r23_OUTSTANDING_HIGH;
	}
	public BigDecimal getR23_PROVISION_HIGH() {
		return R23_PROVISION_HIGH;
	}
	public void setR23_PROVISION_HIGH(BigDecimal r23_PROVISION_HIGH) {
		R23_PROVISION_HIGH = r23_PROVISION_HIGH;
	}
	public BigDecimal getR23_OUTSTANDING_SMALL() {
		return R23_OUTSTANDING_SMALL;
	}
	public void setR23_OUTSTANDING_SMALL(BigDecimal r23_OUTSTANDING_SMALL) {
		R23_OUTSTANDING_SMALL = r23_OUTSTANDING_SMALL;
	}
	public BigDecimal getR23_PROVISION_SMALL() {
		return R23_PROVISION_SMALL;
	}
	public void setR23_PROVISION_SMALL(BigDecimal r23_PROVISION_SMALL) {
		R23_PROVISION_SMALL = r23_PROVISION_SMALL;
	}
	public BigDecimal getR23_OUTSTANDING_INDIVIDUAL() {
		return R23_OUTSTANDING_INDIVIDUAL;
	}
	public void setR23_OUTSTANDING_INDIVIDUAL(BigDecimal r23_OUTSTANDING_INDIVIDUAL) {
		R23_OUTSTANDING_INDIVIDUAL = r23_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR23_PROVISION_INDIVIDUAL() {
		return R23_PROVISION_INDIVIDUAL;
	}
	public void setR23_PROVISION_INDIVIDUAL(BigDecimal r23_PROVISION_INDIVIDUAL) {
		R23_PROVISION_INDIVIDUAL = r23_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR23_OUTSTANDING_GROSS() {
		return R23_OUTSTANDING_GROSS;
	}
	public void setR23_OUTSTANDING_GROSS(BigDecimal r23_OUTSTANDING_GROSS) {
		R23_OUTSTANDING_GROSS = r23_OUTSTANDING_GROSS;
	}
	public BigDecimal getR23_PROVISION_GROSS() {
		return R23_PROVISION_GROSS;
	}
	public void setR23_PROVISION_GROSS(BigDecimal r23_PROVISION_GROSS) {
		R23_PROVISION_GROSS = r23_PROVISION_GROSS;
	}
	public String getR24_S_NO() {
		return R24_S_NO;
	}
	public void setR24_S_NO(String r24_S_NO) {
		R24_S_NO = r24_S_NO;
	}
	public String getR24_STAGES() {
		return R24_STAGES;
	}
	public void setR24_STAGES(String r24_STAGES) {
		R24_STAGES = r24_STAGES;
	}
	public BigDecimal getR24_OUTSTANDING_NBFI() {
		return R24_OUTSTANDING_NBFI;
	}
	public void setR24_OUTSTANDING_NBFI(BigDecimal r24_OUTSTANDING_NBFI) {
		R24_OUTSTANDING_NBFI = r24_OUTSTANDING_NBFI;
	}
	public BigDecimal getR24_PROVISION_NBFI() {
		return R24_PROVISION_NBFI;
	}
	public void setR24_PROVISION_NBFI(BigDecimal r24_PROVISION_NBFI) {
		R24_PROVISION_NBFI = r24_PROVISION_NBFI;
	}
	public BigDecimal getR24_OUTSTANDING_FEDERAL() {
		return R24_OUTSTANDING_FEDERAL;
	}
	public void setR24_OUTSTANDING_FEDERAL(BigDecimal r24_OUTSTANDING_FEDERAL) {
		R24_OUTSTANDING_FEDERAL = r24_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR24_PROVISION_FEDERAL() {
		return R24_PROVISION_FEDERAL;
	}
	public void setR24_PROVISION_FEDERAL(BigDecimal r24_PROVISION_FEDERAL) {
		R24_PROVISION_FEDERAL = r24_PROVISION_FEDERAL;
	}
	public BigDecimal getR24_OUTSTANDING_NON_COMMERCIAL() {
		return R24_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR24_OUTSTANDING_NON_COMMERCIAL(BigDecimal r24_OUTSTANDING_NON_COMMERCIAL) {
		R24_OUTSTANDING_NON_COMMERCIAL = r24_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR24_PROVISON_NON_COMMERCIAL() {
		return R24_PROVISON_NON_COMMERCIAL;
	}
	public void setR24_PROVISON_NON_COMMERCIAL(BigDecimal r24_PROVISON_NON_COMMERCIAL) {
		R24_PROVISON_NON_COMMERCIAL = r24_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR24_OUTSTANDING_EMIRATES() {
		return R24_OUTSTANDING_EMIRATES;
	}
	public void setR24_OUTSTANDING_EMIRATES(BigDecimal r24_OUTSTANDING_EMIRATES) {
		R24_OUTSTANDING_EMIRATES = r24_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR24_PROVISION_EMIRATES() {
		return R24_PROVISION_EMIRATES;
	}
	public void setR24_PROVISION_EMIRATES(BigDecimal r24_PROVISION_EMIRATES) {
		R24_PROVISION_EMIRATES = r24_PROVISION_EMIRATES;
	}
	public BigDecimal getR24_OUTSTANDING_GOVT_GROSS() {
		return R24_OUTSTANDING_GOVT_GROSS;
	}
	public void setR24_OUTSTANDING_GOVT_GROSS(BigDecimal r24_OUTSTANDING_GOVT_GROSS) {
		R24_OUTSTANDING_GOVT_GROSS = r24_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR24_PROVISION_GOVT_GROSS() {
		return R24_PROVISION_GOVT_GROSS;
	}
	public void setR24_PROVISION_GOVT_GROSS(BigDecimal r24_PROVISION_GOVT_GROSS) {
		R24_PROVISION_GOVT_GROSS = r24_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR24_OUTSTANDING_GRE() {
		return R24_OUTSTANDING_GRE;
	}
	public void setR24_OUTSTANDING_GRE(BigDecimal r24_OUTSTANDING_GRE) {
		R24_OUTSTANDING_GRE = r24_OUTSTANDING_GRE;
	}
	public BigDecimal getR24_PROVISION_GRE() {
		return R24_PROVISION_GRE;
	}
	public void setR24_PROVISION_GRE(BigDecimal r24_PROVISION_GRE) {
		R24_PROVISION_GRE = r24_PROVISION_GRE;
	}
	public BigDecimal getR24_OUTSTANDING_CORPORATE() {
		return R24_OUTSTANDING_CORPORATE;
	}
	public void setR24_OUTSTANDING_CORPORATE(BigDecimal r24_OUTSTANDING_CORPORATE) {
		R24_OUTSTANDING_CORPORATE = r24_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR24_PROVISION_CORPORATE() {
		return R24_PROVISION_CORPORATE;
	}
	public void setR24_PROVISION_CORPORATE(BigDecimal r24_PROVISION_CORPORATE) {
		R24_PROVISION_CORPORATE = r24_PROVISION_CORPORATE;
	}
	public BigDecimal getR24_OUTSTANDING_OTHER_CORPORATE() {
		return R24_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR24_OUTSTANDING_OTHER_CORPORATE(BigDecimal r24_OUTSTANDING_OTHER_CORPORATE) {
		R24_OUTSTANDING_OTHER_CORPORATE = r24_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR24_PROVISION_OTHER_CORPORATE() {
		return R24_PROVISION_OTHER_CORPORATE;
	}
	public void setR24_PROVISION_OTHER_CORPORATE(BigDecimal r24_PROVISION_OTHER_CORPORATE) {
		R24_PROVISION_OTHER_CORPORATE = r24_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR24_OUTSTANDING_HIGH() {
		return R24_OUTSTANDING_HIGH;
	}
	public void setR24_OUTSTANDING_HIGH(BigDecimal r24_OUTSTANDING_HIGH) {
		R24_OUTSTANDING_HIGH = r24_OUTSTANDING_HIGH;
	}
	public BigDecimal getR24_PROVISION_HIGH() {
		return R24_PROVISION_HIGH;
	}
	public void setR24_PROVISION_HIGH(BigDecimal r24_PROVISION_HIGH) {
		R24_PROVISION_HIGH = r24_PROVISION_HIGH;
	}
	public BigDecimal getR24_OUTSTANDING_SMALL() {
		return R24_OUTSTANDING_SMALL;
	}
	public void setR24_OUTSTANDING_SMALL(BigDecimal r24_OUTSTANDING_SMALL) {
		R24_OUTSTANDING_SMALL = r24_OUTSTANDING_SMALL;
	}
	public BigDecimal getR24_PROVISION_SMALL() {
		return R24_PROVISION_SMALL;
	}
	public void setR24_PROVISION_SMALL(BigDecimal r24_PROVISION_SMALL) {
		R24_PROVISION_SMALL = r24_PROVISION_SMALL;
	}
	public BigDecimal getR24_OUTSTANDING_INDIVIDUAL() {
		return R24_OUTSTANDING_INDIVIDUAL;
	}
	public void setR24_OUTSTANDING_INDIVIDUAL(BigDecimal r24_OUTSTANDING_INDIVIDUAL) {
		R24_OUTSTANDING_INDIVIDUAL = r24_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR24_PROVISION_INDIVIDUAL() {
		return R24_PROVISION_INDIVIDUAL;
	}
	public void setR24_PROVISION_INDIVIDUAL(BigDecimal r24_PROVISION_INDIVIDUAL) {
		R24_PROVISION_INDIVIDUAL = r24_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR24_OUTSTANDING_GROSS() {
		return R24_OUTSTANDING_GROSS;
	}
	public void setR24_OUTSTANDING_GROSS(BigDecimal r24_OUTSTANDING_GROSS) {
		R24_OUTSTANDING_GROSS = r24_OUTSTANDING_GROSS;
	}
	public BigDecimal getR24_PROVISION_GROSS() {
		return R24_PROVISION_GROSS;
	}
	public void setR24_PROVISION_GROSS(BigDecimal r24_PROVISION_GROSS) {
		R24_PROVISION_GROSS = r24_PROVISION_GROSS;
	}
	public String getR25_S_NO() {
		return R25_S_NO;
	}
	public void setR25_S_NO(String r25_S_NO) {
		R25_S_NO = r25_S_NO;
	}
	public String getR25_STAGES() {
		return R25_STAGES;
	}
	public void setR25_STAGES(String r25_STAGES) {
		R25_STAGES = r25_STAGES;
	}
	public BigDecimal getR25_OUTSTANDING_NBFI() {
		return R25_OUTSTANDING_NBFI;
	}
	public void setR25_OUTSTANDING_NBFI(BigDecimal r25_OUTSTANDING_NBFI) {
		R25_OUTSTANDING_NBFI = r25_OUTSTANDING_NBFI;
	}
	public BigDecimal getR25_PROVISION_NBFI() {
		return R25_PROVISION_NBFI;
	}
	public void setR25_PROVISION_NBFI(BigDecimal r25_PROVISION_NBFI) {
		R25_PROVISION_NBFI = r25_PROVISION_NBFI;
	}
	public BigDecimal getR25_OUTSTANDING_FEDERAL() {
		return R25_OUTSTANDING_FEDERAL;
	}
	public void setR25_OUTSTANDING_FEDERAL(BigDecimal r25_OUTSTANDING_FEDERAL) {
		R25_OUTSTANDING_FEDERAL = r25_OUTSTANDING_FEDERAL;
	}
	public BigDecimal getR25_PROVISION_FEDERAL() {
		return R25_PROVISION_FEDERAL;
	}
	public void setR25_PROVISION_FEDERAL(BigDecimal r25_PROVISION_FEDERAL) {
		R25_PROVISION_FEDERAL = r25_PROVISION_FEDERAL;
	}
	public BigDecimal getR25_OUTSTANDING_NON_COMMERCIAL() {
		return R25_OUTSTANDING_NON_COMMERCIAL;
	}
	public void setR25_OUTSTANDING_NON_COMMERCIAL(BigDecimal r25_OUTSTANDING_NON_COMMERCIAL) {
		R25_OUTSTANDING_NON_COMMERCIAL = r25_OUTSTANDING_NON_COMMERCIAL;
	}
	public BigDecimal getR25_PROVISON_NON_COMMERCIAL() {
		return R25_PROVISON_NON_COMMERCIAL;
	}
	public void setR25_PROVISON_NON_COMMERCIAL(BigDecimal r25_PROVISON_NON_COMMERCIAL) {
		R25_PROVISON_NON_COMMERCIAL = r25_PROVISON_NON_COMMERCIAL;
	}
	public BigDecimal getR25_OUTSTANDING_EMIRATES() {
		return R25_OUTSTANDING_EMIRATES;
	}
	public void setR25_OUTSTANDING_EMIRATES(BigDecimal r25_OUTSTANDING_EMIRATES) {
		R25_OUTSTANDING_EMIRATES = r25_OUTSTANDING_EMIRATES;
	}
	public BigDecimal getR25_PROVISION_EMIRATES() {
		return R25_PROVISION_EMIRATES;
	}
	public void setR25_PROVISION_EMIRATES(BigDecimal r25_PROVISION_EMIRATES) {
		R25_PROVISION_EMIRATES = r25_PROVISION_EMIRATES;
	}
	public BigDecimal getR25_OUTSTANDING_GOVT_GROSS() {
		return R25_OUTSTANDING_GOVT_GROSS;
	}
	public void setR25_OUTSTANDING_GOVT_GROSS(BigDecimal r25_OUTSTANDING_GOVT_GROSS) {
		R25_OUTSTANDING_GOVT_GROSS = r25_OUTSTANDING_GOVT_GROSS;
	}
	public BigDecimal getR25_PROVISION_GOVT_GROSS() {
		return R25_PROVISION_GOVT_GROSS;
	}
	public void setR25_PROVISION_GOVT_GROSS(BigDecimal r25_PROVISION_GOVT_GROSS) {
		R25_PROVISION_GOVT_GROSS = r25_PROVISION_GOVT_GROSS;
	}
	public BigDecimal getR25_OUTSTANDING_GRE() {
		return R25_OUTSTANDING_GRE;
	}
	public void setR25_OUTSTANDING_GRE(BigDecimal r25_OUTSTANDING_GRE) {
		R25_OUTSTANDING_GRE = r25_OUTSTANDING_GRE;
	}
	public BigDecimal getR25_PROVISION_GRE() {
		return R25_PROVISION_GRE;
	}
	public void setR25_PROVISION_GRE(BigDecimal r25_PROVISION_GRE) {
		R25_PROVISION_GRE = r25_PROVISION_GRE;
	}
	public BigDecimal getR25_OUTSTANDING_CORPORATE() {
		return R25_OUTSTANDING_CORPORATE;
	}
	public void setR25_OUTSTANDING_CORPORATE(BigDecimal r25_OUTSTANDING_CORPORATE) {
		R25_OUTSTANDING_CORPORATE = r25_OUTSTANDING_CORPORATE;
	}
	public BigDecimal getR25_PROVISION_CORPORATE() {
		return R25_PROVISION_CORPORATE;
	}
	public void setR25_PROVISION_CORPORATE(BigDecimal r25_PROVISION_CORPORATE) {
		R25_PROVISION_CORPORATE = r25_PROVISION_CORPORATE;
	}
	public BigDecimal getR25_OUTSTANDING_OTHER_CORPORATE() {
		return R25_OUTSTANDING_OTHER_CORPORATE;
	}
	public void setR25_OUTSTANDING_OTHER_CORPORATE(BigDecimal r25_OUTSTANDING_OTHER_CORPORATE) {
		R25_OUTSTANDING_OTHER_CORPORATE = r25_OUTSTANDING_OTHER_CORPORATE;
	}
	public BigDecimal getR25_PROVISION_OTHER_CORPORATE() {
		return R25_PROVISION_OTHER_CORPORATE;
	}
	public void setR25_PROVISION_OTHER_CORPORATE(BigDecimal r25_PROVISION_OTHER_CORPORATE) {
		R25_PROVISION_OTHER_CORPORATE = r25_PROVISION_OTHER_CORPORATE;
	}
	public BigDecimal getR25_OUTSTANDING_HIGH() {
		return R25_OUTSTANDING_HIGH;
	}
	public void setR25_OUTSTANDING_HIGH(BigDecimal r25_OUTSTANDING_HIGH) {
		R25_OUTSTANDING_HIGH = r25_OUTSTANDING_HIGH;
	}
	public BigDecimal getR25_PROVISION_HIGH() {
		return R25_PROVISION_HIGH;
	}
	public void setR25_PROVISION_HIGH(BigDecimal r25_PROVISION_HIGH) {
		R25_PROVISION_HIGH = r25_PROVISION_HIGH;
	}
	public BigDecimal getR25_OUTSTANDING_SMALL() {
		return R25_OUTSTANDING_SMALL;
	}
	public void setR25_OUTSTANDING_SMALL(BigDecimal r25_OUTSTANDING_SMALL) {
		R25_OUTSTANDING_SMALL = r25_OUTSTANDING_SMALL;
	}
	public BigDecimal getR25_PROVISION_SMALL() {
		return R25_PROVISION_SMALL;
	}
	public void setR25_PROVISION_SMALL(BigDecimal r25_PROVISION_SMALL) {
		R25_PROVISION_SMALL = r25_PROVISION_SMALL;
	}
	public BigDecimal getR25_OUTSTANDING_INDIVIDUAL() {
		return R25_OUTSTANDING_INDIVIDUAL;
	}
	public void setR25_OUTSTANDING_INDIVIDUAL(BigDecimal r25_OUTSTANDING_INDIVIDUAL) {
		R25_OUTSTANDING_INDIVIDUAL = r25_OUTSTANDING_INDIVIDUAL;
	}
	public BigDecimal getR25_PROVISION_INDIVIDUAL() {
		return R25_PROVISION_INDIVIDUAL;
	}
	public void setR25_PROVISION_INDIVIDUAL(BigDecimal r25_PROVISION_INDIVIDUAL) {
		R25_PROVISION_INDIVIDUAL = r25_PROVISION_INDIVIDUAL;
	}
	public BigDecimal getR25_OUTSTANDING_GROSS() {
		return R25_OUTSTANDING_GROSS;
	}
	public void setR25_OUTSTANDING_GROSS(BigDecimal r25_OUTSTANDING_GROSS) {
		R25_OUTSTANDING_GROSS = r25_OUTSTANDING_GROSS;
	}
	public BigDecimal getR25_PROVISION_GROSS() {
		return R25_PROVISION_GROSS;
	}
	public void setR25_PROVISION_GROSS(BigDecimal r25_PROVISION_GROSS) {
		R25_PROVISION_GROSS = r25_PROVISION_GROSS;
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
	public BRF_107_A_REPORT_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}