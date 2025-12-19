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
@Table(name="BRF105A_SUMMARYTABLE")
public class BRF105_ENTITY1 {
	private String	R1_S_NO ;
	private String	R1_AMOUNT ;
	private BigDecimal	R1_TOTAL_CONSOLIDATED ;
	private BigDecimal	R1_CRWA_CONSOLIDATED ;
	private BigDecimal	R1_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R1_CRWA_RESIDENT_UAE ;
	private BigDecimal	R1_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R1_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R1_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R1_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R1_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R1_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R1_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R1_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R1_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R1_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R1_NON_PERFORMING ;
	private BigDecimal	R1_SPECIFIC_PROVISION ;
	private BigDecimal	R1_INTEREST ;
	private BigDecimal	R1_DEFAULTED ;
	private String	R2_S_NO ;
	private String	R2_AMOUNT ;
	private BigDecimal	R2_TOTAL_CONSOLIDATED ;
	private BigDecimal	R2_CRWA_CONSOLIDATED ;
	private BigDecimal	R2_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R2_CRWA_RESIDENT_UAE ;
	private BigDecimal	R2_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R2_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R2_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R2_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R2_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R2_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R2_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R2_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R2_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R2_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R2_NON_PERFORMING ;
	private BigDecimal	R2_SPECIFIC_PROVISION ;
	private BigDecimal	R2_INTEREST ;
	private BigDecimal	R2_DEFAULTED ;
	private String	R3_S_NO ;
	private String	R3_AMOUNT ;
	private BigDecimal	R3_TOTAL_CONSOLIDATED ;
	private BigDecimal	R3_CRWA_CONSOLIDATED ;
	private BigDecimal	R3_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R3_CRWA_RESIDENT_UAE ;
	private BigDecimal	R3_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R3_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R3_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R3_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R3_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R3_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R3_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R3_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R3_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R3_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R3_NON_PERFORMING ;
	private BigDecimal	R3_SPECIFIC_PROVISION ;
	private BigDecimal	R3_INTEREST ;
	private BigDecimal	R3_DEFAULTED ;
	private String	R4_S_NO ;
	private String	R4_AMOUNT ;
	private BigDecimal	R4_TOTAL_CONSOLIDATED ;
	private BigDecimal	R4_CRWA_CONSOLIDATED ;
	private BigDecimal	R4_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R4_CRWA_RESIDENT_UAE ;
	private BigDecimal	R4_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R4_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R4_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R4_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R4_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R4_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R4_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R4_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R4_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R4_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R4_NON_PERFORMING ;
	private BigDecimal	R4_SPECIFIC_PROVISION ;
	private BigDecimal	R4_INTEREST ;
	private BigDecimal	R4_DEFAULTED ;
	private String	R5_S_NO ;
	private String	R5_AMOUNT ;
	private BigDecimal	R5_TOTAL_CONSOLIDATED ;
	private BigDecimal	R5_CRWA_CONSOLIDATED ;
	private BigDecimal	R5_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R5_CRWA_RESIDENT_UAE ;
	private BigDecimal	R5_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R5_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R5_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R5_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R5_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R5_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R5_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R5_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R5_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R5_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R5_NON_PERFORMING ;
	private BigDecimal	R5_SPECIFIC_PROVISION ;
	private BigDecimal	R5_INTEREST ;
	private BigDecimal	R5_DEFAULTED ;
	private String	R6_S_NO ;
	private String	R6_AMOUNT ;
	private BigDecimal	R6_TOTAL_CONSOLIDATED ;
	private BigDecimal	R6_CRWA_CONSOLIDATED ;
	private BigDecimal	R6_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R6_CRWA_RESIDENT_UAE ;
	private BigDecimal	R6_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R6_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R6_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R6_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R6_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R6_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R6_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R6_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R6_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R6_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R6_NON_PERFORMING ;
	private BigDecimal	R6_SPECIFIC_PROVISION ;
	private BigDecimal	R6_INTEREST ;
	private BigDecimal	R6_DEFAULTED ;
	private String	R7_S_NO ;
	private String	R7_AMOUNT ;
	private BigDecimal	R7_TOTAL_CONSOLIDATED ;
	private BigDecimal	R7_CRWA_CONSOLIDATED ;
	private BigDecimal	R7_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R7_CRWA_RESIDENT_UAE ;
	private BigDecimal	R7_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R7_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R7_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R7_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R7_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R7_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R7_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R7_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R7_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R7_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R7_NON_PERFORMING ;
	private BigDecimal	R7_SPECIFIC_PROVISION ;
	private BigDecimal	R7_INTEREST ;
	private BigDecimal	R7_DEFAULTED ;
	private String	R8_S_NO ;
	private String	R8_AMOUNT ;
	private BigDecimal	R8_TOTAL_CONSOLIDATED ;
	private BigDecimal	R8_CRWA_CONSOLIDATED ;
	private BigDecimal	R8_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R8_CRWA_RESIDENT_UAE ;
	private BigDecimal	R8_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R8_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R8_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R8_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R8_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R8_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R8_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R8_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R8_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R8_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R8_NON_PERFORMING ;
	private BigDecimal	R8_SPECIFIC_PROVISION ;
	private BigDecimal	R8_INTEREST ;
	private BigDecimal	R8_DEFAULTED ;
	private String	R9_S_NO ;
	private String	R9_AMOUNT ;
	private BigDecimal	R9_TOTAL_CONSOLIDATED ;
	private BigDecimal	R9_CRWA_CONSOLIDATED ;
	private BigDecimal	R9_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R9_CRWA_RESIDENT_UAE ;
	private BigDecimal	R9_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R9_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R9_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R9_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R9_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R9_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R9_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R9_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R9_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R9_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R9_NON_PERFORMING ;
	private BigDecimal	R9_SPECIFIC_PROVISION ;
	private BigDecimal	R9_INTEREST ;
	private BigDecimal	R9_DEFAULTED ;
	private String	R10_S_NO ;
	private String	R10_AMOUNT ;
	private BigDecimal	R10_TOTAL_CONSOLIDATED ;
	private BigDecimal	R10_CRWA_CONSOLIDATED ;
	private BigDecimal	R10_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R10_CRWA_RESIDENT_UAE ;
	private BigDecimal	R10_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R10_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R10_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R10_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R10_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R10_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R10_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R10_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R10_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R10_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R10_NON_PERFORMING ;
	private BigDecimal	R10_SPECIFIC_PROVISION ;
	private BigDecimal	R10_INTEREST ;
	private BigDecimal	R10_DEFAULTED ;
	private String	R11_S_NO ;
	private String	R11_AMOUNT ;
	private BigDecimal	R11_TOTAL_CONSOLIDATED ;
	private BigDecimal	R11_CRWA_CONSOLIDATED ;
	private BigDecimal	R11_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R11_CRWA_RESIDENT_UAE ;
	private BigDecimal	R11_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R11_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R11_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R11_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R11_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R11_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R11_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R11_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R11_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R11_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R11_NON_PERFORMING ;
	private BigDecimal	R11_SPECIFIC_PROVISION ;
	private BigDecimal	R11_INTEREST ;
	private BigDecimal	R11_DEFAULTED ;
	private String	R12_S_NO ;
	private String	R12_AMOUNT ;
	private BigDecimal	R12_TOTAL_CONSOLIDATED ;
	private BigDecimal	R12_CRWA_CONSOLIDATED ;
	private BigDecimal	R12_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R12_CRWA_RESIDENT_UAE ;
	private BigDecimal	R12_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R12_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R12_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R12_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R12_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R12_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R12_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R12_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R12_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R12_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R12_NON_PERFORMING ;
	private BigDecimal	R12_SPECIFIC_PROVISION ;
	private BigDecimal	R12_INTEREST ;
	private BigDecimal	R12_DEFAULTED ;
	private String	R13_S_NO ;
	private String	R13_AMOUNT ;
	private BigDecimal	R13_TOTAL_CONSOLIDATED ;
	private BigDecimal	R13_CRWA_CONSOLIDATED ;
	private BigDecimal	R13_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R13_CRWA_RESIDENT_UAE ;
	private BigDecimal	R13_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R13_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R13_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R13_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R13_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R13_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R13_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R13_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R13_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R13_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R13_NON_PERFORMING ;
	private BigDecimal	R13_SPECIFIC_PROVISION ;
	private BigDecimal	R13_INTEREST ;
	private BigDecimal	R13_DEFAULTED ;
	private String	R14_S_NO ;
	private String	R14_AMOUNT ;
	private BigDecimal	R14_TOTAL_CONSOLIDATED ;
	private BigDecimal	R14_CRWA_CONSOLIDATED ;
	private BigDecimal	R14_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R14_CRWA_RESIDENT_UAE ;
	private BigDecimal	R14_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R14_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R14_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R14_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R14_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R14_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R14_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R14_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R14_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R14_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R14_NON_PERFORMING ;
	private BigDecimal	R14_SPECIFIC_PROVISION ;
	private BigDecimal	R14_INTEREST ;
	private BigDecimal	R14_DEFAULTED ;
	private String	R15_S_NO ;
	private String	R15_AMOUNT ;
	private BigDecimal	R15_TOTAL_CONSOLIDATED ;
	private BigDecimal	R15_CRWA_CONSOLIDATED ;
	private BigDecimal	R15_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R15_CRWA_RESIDENT_UAE ;
	private BigDecimal	R15_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R15_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R15_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R15_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R15_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R15_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R15_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R15_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R15_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R15_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R15_NON_PERFORMING ;
	private BigDecimal	R15_SPECIFIC_PROVISION ;
	private BigDecimal	R15_INTEREST ;
	private BigDecimal	R15_DEFAULTED ;
	private String	R16_S_NO ;
	private String	R16_AMOUNT ;
	private BigDecimal	R16_TOTAL_CONSOLIDATED ;
	private BigDecimal	R16_CRWA_CONSOLIDATED ;
	private BigDecimal	R16_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R16_CRWA_RESIDENT_UAE ;
	private BigDecimal	R16_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R16_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R16_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R16_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R16_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R16_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R16_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R16_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R16_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R16_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R16_NON_PERFORMING ;
	private BigDecimal	R16_SPECIFIC_PROVISION ;
	private BigDecimal	R16_INTEREST ;
	private BigDecimal	R16_DEFAULTED ;
	private String	R17_S_NO ;
	private String	R17_AMOUNT ;
	private BigDecimal	R17_TOTAL_CONSOLIDATED ;
	private BigDecimal	R17_CRWA_CONSOLIDATED ;
	private BigDecimal	R17_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R17_CRWA_RESIDENT_UAE ;
	private BigDecimal	R17_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R17_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R17_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R17_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R17_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R17_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R17_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R17_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R17_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R17_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R17_NON_PERFORMING ;
	private BigDecimal	R17_SPECIFIC_PROVISION ;
	private BigDecimal	R17_INTEREST ;
	private BigDecimal	R17_DEFAULTED ;
	private String	R18_S_NO ;
	private String	R18_AMOUNT ;
	private BigDecimal	R18_TOTAL_CONSOLIDATED ;
	private BigDecimal	R18_CRWA_CONSOLIDATED ;
	private BigDecimal	R18_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R18_CRWA_RESIDENT_UAE ;
	private BigDecimal	R18_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R18_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R18_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R18_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R18_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R18_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R18_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R18_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R18_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R18_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R18_NON_PERFORMING ;
	private BigDecimal	R18_SPECIFIC_PROVISION ;
	private BigDecimal	R18_INTEREST ;
	private BigDecimal	R18_DEFAULTED ;
	private String	R19_S_NO ;
	private String	R19_AMOUNT ;
	private BigDecimal	R19_TOTAL_CONSOLIDATED ;
	private BigDecimal	R19_CRWA_CONSOLIDATED ;
	private BigDecimal	R19_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R19_CRWA_RESIDENT_UAE ;
	private BigDecimal	R19_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R19_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R19_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R19_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R19_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R19_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R19_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R19_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R19_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R19_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R19_NON_PERFORMING ;
	private BigDecimal	R19_SPECIFIC_PROVISION ;
	private BigDecimal	R19_INTEREST ;
	private BigDecimal	R19_DEFAULTED ;
	private String	R20_S_NO ;
	private String	R20_AMOUNT ;
	private BigDecimal	R20_TOTAL_CONSOLIDATED ;
	private BigDecimal	R20_CRWA_CONSOLIDATED ;
	private BigDecimal	R20_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R20_CRWA_RESIDENT_UAE ;
	private BigDecimal	R20_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R20_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R20_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R20_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R20_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R20_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R20_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R20_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R20_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R20_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R20_NON_PERFORMING ;
	private BigDecimal	R20_SPECIFIC_PROVISION ;
	private BigDecimal	R20_INTEREST ;
	private BigDecimal	R20_DEFAULTED ;
	private String	R21_S_NO ;
	private String	R21_AMOUNT ;
	private BigDecimal	R21_TOTAL_CONSOLIDATED ;
	private BigDecimal	R21_CRWA_CONSOLIDATED ;
	private BigDecimal	R21_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R21_CRWA_RESIDENT_UAE ;
	private BigDecimal	R21_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R21_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R21_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R21_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R21_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R21_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R21_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R21_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R21_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R21_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R21_NON_PERFORMING ;
	private BigDecimal	R21_SPECIFIC_PROVISION ;
	private BigDecimal	R21_INTEREST ;
	private BigDecimal	R21_DEFAULTED ;
	private String	R22_S_NO ;
	private String	R22_AMOUNT ;
	private BigDecimal	R22_TOTAL_CONSOLIDATED ;
	private BigDecimal	R22_CRWA_CONSOLIDATED ;
	private BigDecimal	R22_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R22_CRWA_RESIDENT_UAE ;
	private BigDecimal	R22_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R22_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R22_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R22_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R22_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R22_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R22_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R22_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R22_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R22_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R22_NON_PERFORMING ;
	private BigDecimal	R22_SPECIFIC_PROVISION ;
	private BigDecimal	R22_INTEREST ;
	private BigDecimal	R22_DEFAULTED ;
	private String	R23_S_NO ;
	private String	R23_AMOUNT ;
	private BigDecimal	R23_TOTAL_CONSOLIDATED ;
	private BigDecimal	R23_CRWA_CONSOLIDATED ;
	private BigDecimal	R23_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R23_CRWA_RESIDENT_UAE ;
	private BigDecimal	R23_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R23_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R23_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R23_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R23_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R23_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R23_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R23_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R23_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R23_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R23_NON_PERFORMING ;
	private BigDecimal	R23_SPECIFIC_PROVISION ;
	private BigDecimal	R23_INTEREST ;
	private BigDecimal	R23_DEFAULTED ;
	private String	R24_S_NO ;
	private String	R24_AMOUNT ;
	private BigDecimal	R24_TOTAL_CONSOLIDATED ;
	private BigDecimal	R24_CRWA_CONSOLIDATED ;
	private BigDecimal	R24_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R24_CRWA_RESIDENT_UAE ;
	private BigDecimal	R24_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R24_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R24_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R24_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R24_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R24_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R24_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R24_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R24_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R24_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R24_NON_PERFORMING ;
	private BigDecimal	R24_SPECIFIC_PROVISION ;
	private BigDecimal	R24_INTEREST ;
	private BigDecimal	R24_DEFAULTED ;
	private String	R25_S_NO ;
	private String	R25_AMOUNT ;
	private BigDecimal	R25_TOTAL_CONSOLIDATED ;
	private BigDecimal	R25_CRWA_CONSOLIDATED ;
	private BigDecimal	R25_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R25_CRWA_RESIDENT_UAE ;
	private BigDecimal	R25_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R25_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R25_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R25_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R25_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R25_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R25_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R25_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R25_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R25_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R25_NON_PERFORMING ;
	private BigDecimal	R25_SPECIFIC_PROVISION ;
	private BigDecimal	R25_INTEREST ;
	private BigDecimal	R25_DEFAULTED ;
	private String	R26_S_NO ;
	private String	R26_AMOUNT ;
	private BigDecimal	R26_TOTAL_CONSOLIDATED ;
	private BigDecimal	R26_CRWA_CONSOLIDATED ;
	private BigDecimal	R26_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R26_CRWA_RESIDENT_UAE ;
	private BigDecimal	R26_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R26_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R26_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R26_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R26_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R26_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R26_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R26_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R26_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R26_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R26_NON_PERFORMING ;
	private BigDecimal	R26_SPECIFIC_PROVISION ;
	private BigDecimal	R26_INTEREST ;
	private BigDecimal	R26_DEFAULTED ;
	private String	R27_S_NO ;
	private String	R27_AMOUNT ;
	private BigDecimal	R27_TOTAL_CONSOLIDATED ;
	private BigDecimal	R27_CRWA_CONSOLIDATED ;
	private BigDecimal	R27_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R27_CRWA_RESIDENT_UAE ;
	private BigDecimal	R27_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R27_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R27_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R27_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R27_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R27_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R27_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R27_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R27_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R27_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R27_NON_PERFORMING ;
	private BigDecimal	R27_SPECIFIC_PROVISION ;
	private BigDecimal	R27_INTEREST ;
	private BigDecimal	R27_DEFAULTED ;
	private String	R28_S_NO ;
	private String	R28_AMOUNT ;
	private BigDecimal	R28_TOTAL_CONSOLIDATED ;
	private BigDecimal	R28_CRWA_CONSOLIDATED ;
	private BigDecimal	R28_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R28_CRWA_RESIDENT_UAE ;
	private BigDecimal	R28_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R28_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R28_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R28_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R28_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R28_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R28_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R28_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R28_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R28_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R28_NON_PERFORMING ;
	private BigDecimal	R28_SPECIFIC_PROVISION ;
	private BigDecimal	R28_INTEREST ;
	private BigDecimal	R28_DEFAULTED ;
	private String	R29_S_NO ;
	private String	R29_AMOUNT ;
	private BigDecimal	R29_TOTAL_CONSOLIDATED ;
	private BigDecimal	R29_CRWA_CONSOLIDATED ;
	private BigDecimal	R29_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R29_CRWA_RESIDENT_UAE ;
	private BigDecimal	R29_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R29_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R29_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R29_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R29_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R29_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R29_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R29_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R29_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R29_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R29_NON_PERFORMING ;
	private BigDecimal	R29_SPECIFIC_PROVISION ;
	private BigDecimal	R29_INTEREST ;
	private BigDecimal	R29_DEFAULTED ;
	private String	R30_S_NO ;
	private String	R30_AMOUNT ;
	private BigDecimal	R30_TOTAL_CONSOLIDATED ;
	private BigDecimal	R30_CRWA_CONSOLIDATED ;
	private BigDecimal	R30_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R30_CRWA_RESIDENT_UAE ;
	private BigDecimal	R30_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R30_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R30_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R30_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R30_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R30_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R30_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R30_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R30_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R30_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R30_NON_PERFORMING ;
	private BigDecimal	R30_SPECIFIC_PROVISION ;
	private BigDecimal	R30_INTEREST ;
	private BigDecimal	R30_DEFAULTED ;
	private String	R31_S_NO ;
	private String	R31_AMOUNT ;
	private BigDecimal	R31_TOTAL_CONSOLIDATED ;
	private BigDecimal	R31_CRWA_CONSOLIDATED ;
	private BigDecimal	R31_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R31_CRWA_RESIDENT_UAE ;
	private BigDecimal	R31_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R31_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R31_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R31_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R31_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R31_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R31_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R31_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R31_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R31_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R31_NON_PERFORMING ;
	private BigDecimal	R31_SPECIFIC_PROVISION ;
	private BigDecimal	R31_INTEREST ;
	private BigDecimal	R31_DEFAULTED ;
	private String	R32_S_NO ;
	private String	R32_AMOUNT ;
	private BigDecimal	R32_TOTAL_CONSOLIDATED ;
	private BigDecimal	R32_CRWA_CONSOLIDATED ;
	private BigDecimal	R32_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R32_CRWA_RESIDENT_UAE ;
	private BigDecimal	R32_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R32_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R32_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R32_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R32_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R32_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R32_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R32_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R32_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R32_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R32_NON_PERFORMING ;
	private BigDecimal	R32_SPECIFIC_PROVISION ;
	private BigDecimal	R32_INTEREST ;
	private BigDecimal	R32_DEFAULTED ;
	private String	R33_S_NO ;
	private String	R33_AMOUNT ;
	private BigDecimal	R33_TOTAL_CONSOLIDATED ;
	private BigDecimal	R33_CRWA_CONSOLIDATED ;
	private BigDecimal	R33_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R33_CRWA_RESIDENT_UAE ;
	private BigDecimal	R33_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R33_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R33_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R33_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R33_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R33_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R33_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R33_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R33_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R33_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R33_NON_PERFORMING ;
	private BigDecimal	R33_SPECIFIC_PROVISION ;
	private BigDecimal	R33_INTEREST ;
	private BigDecimal	R33_DEFAULTED ;
	private String	R34_S_NO ;
	private String	R34_AMOUNT ;
	private BigDecimal	R34_TOTAL_CONSOLIDATED ;
	private BigDecimal	R34_CRWA_CONSOLIDATED ;
	private BigDecimal	R34_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R34_CRWA_RESIDENT_UAE ;
	private BigDecimal	R34_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R34_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R34_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R34_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R34_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R34_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R34_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R34_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R34_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R34_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R34_NON_PERFORMING ;
	private BigDecimal	R34_SPECIFIC_PROVISION ;
	private BigDecimal	R34_INTEREST ;
	private BigDecimal	R34_DEFAULTED ;
	private String	R35_S_NO ;
	private String	R35_AMOUNT ;
	private BigDecimal	R35_TOTAL_CONSOLIDATED ;
	private BigDecimal	R35_CRWA_CONSOLIDATED ;
	private BigDecimal	R35_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R35_CRWA_RESIDENT_UAE ;
	private BigDecimal	R35_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R35_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R35_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R35_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R35_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R35_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R35_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R35_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R35_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R35_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R35_NON_PERFORMING ;
	private BigDecimal	R35_SPECIFIC_PROVISION ;
	private BigDecimal	R35_INTEREST ;
	private BigDecimal	R35_DEFAULTED ;
	private String	R36_S_NO ;
	private String	R36_AMOUNT ;
	private BigDecimal	R36_TOTAL_CONSOLIDATED ;
	private BigDecimal	R36_CRWA_CONSOLIDATED ;
	private BigDecimal	R36_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R36_CRWA_RESIDENT_UAE ;
	private BigDecimal	R36_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R36_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R36_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R36_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R36_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R36_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R36_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R36_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R36_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R36_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R36_NON_PERFORMING ;
	private BigDecimal	R36_SPECIFIC_PROVISION ;
	private BigDecimal	R36_INTEREST ;
	private BigDecimal	R36_DEFAULTED ;
	private String	R37_S_NO ;
	private String	R37_AMOUNT ;
	private BigDecimal	R37_TOTAL_CONSOLIDATED ;
	private BigDecimal	R37_CRWA_CONSOLIDATED ;
	private BigDecimal	R37_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R37_CRWA_RESIDENT_UAE ;
	private BigDecimal	R37_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R37_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R37_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R37_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R37_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R37_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R37_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R37_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R37_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R37_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R37_NON_PERFORMING ;
	private BigDecimal	R37_SPECIFIC_PROVISION ;
	private BigDecimal	R37_INTEREST ;
	private BigDecimal	R37_DEFAULTED ;
	private String	R38_S_NO ;
	private String	R38_AMOUNT ;
	private BigDecimal	R38_TOTAL_CONSOLIDATED ;
	private BigDecimal	R38_CRWA_CONSOLIDATED ;
	private BigDecimal	R38_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R38_CRWA_RESIDENT_UAE ;
	private BigDecimal	R38_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R38_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R38_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R38_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R38_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R38_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R38_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R38_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R38_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R38_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R38_NON_PERFORMING ;
	private BigDecimal	R38_SPECIFIC_PROVISION ;
	private BigDecimal	R38_INTEREST ;
	private BigDecimal	R38_DEFAULTED ;
	private String	R39_S_NO ;
	private String	R39_AMOUNT ;
	private BigDecimal	R39_TOTAL_CONSOLIDATED ;
	private BigDecimal	R39_CRWA_CONSOLIDATED ;
	private BigDecimal	R39_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R39_CRWA_RESIDENT_UAE ;
	private BigDecimal	R39_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R39_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R39_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R39_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R39_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R39_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R39_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R39_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R39_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R39_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R39_NON_PERFORMING ;
	private BigDecimal	R39_SPECIFIC_PROVISION ;
	private BigDecimal	R39_INTEREST ;
	private BigDecimal	R39_DEFAULTED ;
	private String	R40_S_NO ;
	private String	R40_AMOUNT ;
	private BigDecimal	R40_TOTAL_CONSOLIDATED ;
	private BigDecimal	R40_CRWA_CONSOLIDATED ;
	private BigDecimal	R40_EXPOSURE_RESIDENT_UAE ;
	private BigDecimal	R40_CRWA_RESIDENT_UAE ;
	private BigDecimal	R40_EXPOSURE_NON_RESIDENT_UAE ;
	private BigDecimal	R40_CRWA_NON_RESIDENT_UAE ;
	private BigDecimal	R40_EXPOSURE_RESIDENT_NON_UAE ;
	private BigDecimal	R40_CRWA_RESIDENT_NON_UAE ;
	private BigDecimal	R40_EXPOSURE_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R40_CRWA_NON_RESIDENT_NON_UAE ;
	private BigDecimal	R40_EXPOSURE_INSIDE_CONSOLIDATED ;
	private BigDecimal	R40_CRWA_INSIDE_CONSOLIDATED ;
	private BigDecimal	R40_EXPOSURE_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R40_CRWA_OUTSIDE_CONSOLIDATED ;
	private BigDecimal	R40_NON_PERFORMING ;
	private BigDecimal	R40_SPECIFIC_PROVISION ;
	private BigDecimal	R40_INTEREST ;
	private BigDecimal	R40_DEFAULTED ;
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
	public String getR1_AMOUNT() {
		return R1_AMOUNT;
	}
	public void setR1_AMOUNT(String r1_AMOUNT) {
		R1_AMOUNT = r1_AMOUNT;
	}
	public BigDecimal getR1_TOTAL_CONSOLIDATED() {
		return R1_TOTAL_CONSOLIDATED;
	}
	public void setR1_TOTAL_CONSOLIDATED(BigDecimal r1_TOTAL_CONSOLIDATED) {
		R1_TOTAL_CONSOLIDATED = r1_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR1_CRWA_CONSOLIDATED() {
		return R1_CRWA_CONSOLIDATED;
	}
	public void setR1_CRWA_CONSOLIDATED(BigDecimal r1_CRWA_CONSOLIDATED) {
		R1_CRWA_CONSOLIDATED = r1_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR1_EXPOSURE_RESIDENT_UAE() {
		return R1_EXPOSURE_RESIDENT_UAE;
	}
	public void setR1_EXPOSURE_RESIDENT_UAE(BigDecimal r1_EXPOSURE_RESIDENT_UAE) {
		R1_EXPOSURE_RESIDENT_UAE = r1_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR1_CRWA_RESIDENT_UAE() {
		return R1_CRWA_RESIDENT_UAE;
	}
	public void setR1_CRWA_RESIDENT_UAE(BigDecimal r1_CRWA_RESIDENT_UAE) {
		R1_CRWA_RESIDENT_UAE = r1_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR1_EXPOSURE_NON_RESIDENT_UAE() {
		return R1_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR1_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r1_EXPOSURE_NON_RESIDENT_UAE) {
		R1_EXPOSURE_NON_RESIDENT_UAE = r1_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR1_CRWA_NON_RESIDENT_UAE() {
		return R1_CRWA_NON_RESIDENT_UAE;
	}
	public void setR1_CRWA_NON_RESIDENT_UAE(BigDecimal r1_CRWA_NON_RESIDENT_UAE) {
		R1_CRWA_NON_RESIDENT_UAE = r1_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR1_EXPOSURE_RESIDENT_NON_UAE() {
		return R1_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR1_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r1_EXPOSURE_RESIDENT_NON_UAE) {
		R1_EXPOSURE_RESIDENT_NON_UAE = r1_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR1_CRWA_RESIDENT_NON_UAE() {
		return R1_CRWA_RESIDENT_NON_UAE;
	}
	public void setR1_CRWA_RESIDENT_NON_UAE(BigDecimal r1_CRWA_RESIDENT_NON_UAE) {
		R1_CRWA_RESIDENT_NON_UAE = r1_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR1_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R1_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR1_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r1_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R1_EXPOSURE_NON_RESIDENT_NON_UAE = r1_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR1_CRWA_NON_RESIDENT_NON_UAE() {
		return R1_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR1_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r1_CRWA_NON_RESIDENT_NON_UAE) {
		R1_CRWA_NON_RESIDENT_NON_UAE = r1_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR1_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R1_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR1_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r1_EXPOSURE_INSIDE_CONSOLIDATED) {
		R1_EXPOSURE_INSIDE_CONSOLIDATED = r1_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR1_CRWA_INSIDE_CONSOLIDATED() {
		return R1_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR1_CRWA_INSIDE_CONSOLIDATED(BigDecimal r1_CRWA_INSIDE_CONSOLIDATED) {
		R1_CRWA_INSIDE_CONSOLIDATED = r1_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR1_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R1_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR1_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r1_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R1_EXPOSURE_OUTSIDE_CONSOLIDATED = r1_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR1_CRWA_OUTSIDE_CONSOLIDATED() {
		return R1_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR1_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r1_CRWA_OUTSIDE_CONSOLIDATED) {
		R1_CRWA_OUTSIDE_CONSOLIDATED = r1_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR1_NON_PERFORMING() {
		return R1_NON_PERFORMING;
	}
	public void setR1_NON_PERFORMING(BigDecimal r1_NON_PERFORMING) {
		R1_NON_PERFORMING = r1_NON_PERFORMING;
	}
	public BigDecimal getR1_SPECIFIC_PROVISION() {
		return R1_SPECIFIC_PROVISION;
	}
	public void setR1_SPECIFIC_PROVISION(BigDecimal r1_SPECIFIC_PROVISION) {
		R1_SPECIFIC_PROVISION = r1_SPECIFIC_PROVISION;
	}
	public BigDecimal getR1_INTEREST() {
		return R1_INTEREST;
	}
	public void setR1_INTEREST(BigDecimal r1_INTEREST) {
		R1_INTEREST = r1_INTEREST;
	}
	public BigDecimal getR1_DEFAULTED() {
		return R1_DEFAULTED;
	}
	public void setR1_DEFAULTED(BigDecimal r1_DEFAULTED) {
		R1_DEFAULTED = r1_DEFAULTED;
	}
	public String getR2_S_NO() {
		return R2_S_NO;
	}
	public void setR2_S_NO(String r2_S_NO) {
		R2_S_NO = r2_S_NO;
	}
	public String getR2_AMOUNT() {
		return R2_AMOUNT;
	}
	public void setR2_AMOUNT(String r2_AMOUNT) {
		R2_AMOUNT = r2_AMOUNT;
	}
	public BigDecimal getR2_TOTAL_CONSOLIDATED() {
		return R2_TOTAL_CONSOLIDATED;
	}
	public void setR2_TOTAL_CONSOLIDATED(BigDecimal r2_TOTAL_CONSOLIDATED) {
		R2_TOTAL_CONSOLIDATED = r2_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR2_CRWA_CONSOLIDATED() {
		return R2_CRWA_CONSOLIDATED;
	}
	public void setR2_CRWA_CONSOLIDATED(BigDecimal r2_CRWA_CONSOLIDATED) {
		R2_CRWA_CONSOLIDATED = r2_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR2_EXPOSURE_RESIDENT_UAE() {
		return R2_EXPOSURE_RESIDENT_UAE;
	}
	public void setR2_EXPOSURE_RESIDENT_UAE(BigDecimal r2_EXPOSURE_RESIDENT_UAE) {
		R2_EXPOSURE_RESIDENT_UAE = r2_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR2_CRWA_RESIDENT_UAE() {
		return R2_CRWA_RESIDENT_UAE;
	}
	public void setR2_CRWA_RESIDENT_UAE(BigDecimal r2_CRWA_RESIDENT_UAE) {
		R2_CRWA_RESIDENT_UAE = r2_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR2_EXPOSURE_NON_RESIDENT_UAE() {
		return R2_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR2_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r2_EXPOSURE_NON_RESIDENT_UAE) {
		R2_EXPOSURE_NON_RESIDENT_UAE = r2_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR2_CRWA_NON_RESIDENT_UAE() {
		return R2_CRWA_NON_RESIDENT_UAE;
	}
	public void setR2_CRWA_NON_RESIDENT_UAE(BigDecimal r2_CRWA_NON_RESIDENT_UAE) {
		R2_CRWA_NON_RESIDENT_UAE = r2_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR2_EXPOSURE_RESIDENT_NON_UAE() {
		return R2_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR2_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r2_EXPOSURE_RESIDENT_NON_UAE) {
		R2_EXPOSURE_RESIDENT_NON_UAE = r2_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR2_CRWA_RESIDENT_NON_UAE() {
		return R2_CRWA_RESIDENT_NON_UAE;
	}
	public void setR2_CRWA_RESIDENT_NON_UAE(BigDecimal r2_CRWA_RESIDENT_NON_UAE) {
		R2_CRWA_RESIDENT_NON_UAE = r2_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR2_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R2_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR2_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r2_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R2_EXPOSURE_NON_RESIDENT_NON_UAE = r2_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR2_CRWA_NON_RESIDENT_NON_UAE() {
		return R2_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR2_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r2_CRWA_NON_RESIDENT_NON_UAE) {
		R2_CRWA_NON_RESIDENT_NON_UAE = r2_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR2_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R2_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR2_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r2_EXPOSURE_INSIDE_CONSOLIDATED) {
		R2_EXPOSURE_INSIDE_CONSOLIDATED = r2_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR2_CRWA_INSIDE_CONSOLIDATED() {
		return R2_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR2_CRWA_INSIDE_CONSOLIDATED(BigDecimal r2_CRWA_INSIDE_CONSOLIDATED) {
		R2_CRWA_INSIDE_CONSOLIDATED = r2_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR2_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R2_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR2_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r2_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R2_EXPOSURE_OUTSIDE_CONSOLIDATED = r2_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR2_CRWA_OUTSIDE_CONSOLIDATED() {
		return R2_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR2_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r2_CRWA_OUTSIDE_CONSOLIDATED) {
		R2_CRWA_OUTSIDE_CONSOLIDATED = r2_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR2_NON_PERFORMING() {
		return R2_NON_PERFORMING;
	}
	public void setR2_NON_PERFORMING(BigDecimal r2_NON_PERFORMING) {
		R2_NON_PERFORMING = r2_NON_PERFORMING;
	}
	public BigDecimal getR2_SPECIFIC_PROVISION() {
		return R2_SPECIFIC_PROVISION;
	}
	public void setR2_SPECIFIC_PROVISION(BigDecimal r2_SPECIFIC_PROVISION) {
		R2_SPECIFIC_PROVISION = r2_SPECIFIC_PROVISION;
	}
	public BigDecimal getR2_INTEREST() {
		return R2_INTEREST;
	}
	public void setR2_INTEREST(BigDecimal r2_INTEREST) {
		R2_INTEREST = r2_INTEREST;
	}
	public BigDecimal getR2_DEFAULTED() {
		return R2_DEFAULTED;
	}
	public void setR2_DEFAULTED(BigDecimal r2_DEFAULTED) {
		R2_DEFAULTED = r2_DEFAULTED;
	}
	public String getR3_S_NO() {
		return R3_S_NO;
	}
	public void setR3_S_NO(String r3_S_NO) {
		R3_S_NO = r3_S_NO;
	}
	public String getR3_AMOUNT() {
		return R3_AMOUNT;
	}
	public void setR3_AMOUNT(String r3_AMOUNT) {
		R3_AMOUNT = r3_AMOUNT;
	}
	public BigDecimal getR3_TOTAL_CONSOLIDATED() {
		return R3_TOTAL_CONSOLIDATED;
	}
	public void setR3_TOTAL_CONSOLIDATED(BigDecimal r3_TOTAL_CONSOLIDATED) {
		R3_TOTAL_CONSOLIDATED = r3_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR3_CRWA_CONSOLIDATED() {
		return R3_CRWA_CONSOLIDATED;
	}
	public void setR3_CRWA_CONSOLIDATED(BigDecimal r3_CRWA_CONSOLIDATED) {
		R3_CRWA_CONSOLIDATED = r3_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR3_EXPOSURE_RESIDENT_UAE() {
		return R3_EXPOSURE_RESIDENT_UAE;
	}
	public void setR3_EXPOSURE_RESIDENT_UAE(BigDecimal r3_EXPOSURE_RESIDENT_UAE) {
		R3_EXPOSURE_RESIDENT_UAE = r3_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR3_CRWA_RESIDENT_UAE() {
		return R3_CRWA_RESIDENT_UAE;
	}
	public void setR3_CRWA_RESIDENT_UAE(BigDecimal r3_CRWA_RESIDENT_UAE) {
		R3_CRWA_RESIDENT_UAE = r3_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR3_EXPOSURE_NON_RESIDENT_UAE() {
		return R3_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR3_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r3_EXPOSURE_NON_RESIDENT_UAE) {
		R3_EXPOSURE_NON_RESIDENT_UAE = r3_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR3_CRWA_NON_RESIDENT_UAE() {
		return R3_CRWA_NON_RESIDENT_UAE;
	}
	public void setR3_CRWA_NON_RESIDENT_UAE(BigDecimal r3_CRWA_NON_RESIDENT_UAE) {
		R3_CRWA_NON_RESIDENT_UAE = r3_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR3_EXPOSURE_RESIDENT_NON_UAE() {
		return R3_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR3_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r3_EXPOSURE_RESIDENT_NON_UAE) {
		R3_EXPOSURE_RESIDENT_NON_UAE = r3_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR3_CRWA_RESIDENT_NON_UAE() {
		return R3_CRWA_RESIDENT_NON_UAE;
	}
	public void setR3_CRWA_RESIDENT_NON_UAE(BigDecimal r3_CRWA_RESIDENT_NON_UAE) {
		R3_CRWA_RESIDENT_NON_UAE = r3_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR3_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R3_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR3_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r3_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R3_EXPOSURE_NON_RESIDENT_NON_UAE = r3_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR3_CRWA_NON_RESIDENT_NON_UAE() {
		return R3_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR3_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r3_CRWA_NON_RESIDENT_NON_UAE) {
		R3_CRWA_NON_RESIDENT_NON_UAE = r3_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR3_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R3_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR3_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r3_EXPOSURE_INSIDE_CONSOLIDATED) {
		R3_EXPOSURE_INSIDE_CONSOLIDATED = r3_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR3_CRWA_INSIDE_CONSOLIDATED() {
		return R3_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR3_CRWA_INSIDE_CONSOLIDATED(BigDecimal r3_CRWA_INSIDE_CONSOLIDATED) {
		R3_CRWA_INSIDE_CONSOLIDATED = r3_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR3_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R3_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR3_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r3_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R3_EXPOSURE_OUTSIDE_CONSOLIDATED = r3_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR3_CRWA_OUTSIDE_CONSOLIDATED() {
		return R3_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR3_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r3_CRWA_OUTSIDE_CONSOLIDATED) {
		R3_CRWA_OUTSIDE_CONSOLIDATED = r3_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR3_NON_PERFORMING() {
		return R3_NON_PERFORMING;
	}
	public void setR3_NON_PERFORMING(BigDecimal r3_NON_PERFORMING) {
		R3_NON_PERFORMING = r3_NON_PERFORMING;
	}
	public BigDecimal getR3_SPECIFIC_PROVISION() {
		return R3_SPECIFIC_PROVISION;
	}
	public void setR3_SPECIFIC_PROVISION(BigDecimal r3_SPECIFIC_PROVISION) {
		R3_SPECIFIC_PROVISION = r3_SPECIFIC_PROVISION;
	}
	public BigDecimal getR3_INTEREST() {
		return R3_INTEREST;
	}
	public void setR3_INTEREST(BigDecimal r3_INTEREST) {
		R3_INTEREST = r3_INTEREST;
	}
	public BigDecimal getR3_DEFAULTED() {
		return R3_DEFAULTED;
	}
	public void setR3_DEFAULTED(BigDecimal r3_DEFAULTED) {
		R3_DEFAULTED = r3_DEFAULTED;
	}
	public String getR4_S_NO() {
		return R4_S_NO;
	}
	public void setR4_S_NO(String r4_S_NO) {
		R4_S_NO = r4_S_NO;
	}
	public String getR4_AMOUNT() {
		return R4_AMOUNT;
	}
	public void setR4_AMOUNT(String r4_AMOUNT) {
		R4_AMOUNT = r4_AMOUNT;
	}
	public BigDecimal getR4_TOTAL_CONSOLIDATED() {
		return R4_TOTAL_CONSOLIDATED;
	}
	public void setR4_TOTAL_CONSOLIDATED(BigDecimal r4_TOTAL_CONSOLIDATED) {
		R4_TOTAL_CONSOLIDATED = r4_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR4_CRWA_CONSOLIDATED() {
		return R4_CRWA_CONSOLIDATED;
	}
	public void setR4_CRWA_CONSOLIDATED(BigDecimal r4_CRWA_CONSOLIDATED) {
		R4_CRWA_CONSOLIDATED = r4_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR4_EXPOSURE_RESIDENT_UAE() {
		return R4_EXPOSURE_RESIDENT_UAE;
	}
	public void setR4_EXPOSURE_RESIDENT_UAE(BigDecimal r4_EXPOSURE_RESIDENT_UAE) {
		R4_EXPOSURE_RESIDENT_UAE = r4_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR4_CRWA_RESIDENT_UAE() {
		return R4_CRWA_RESIDENT_UAE;
	}
	public void setR4_CRWA_RESIDENT_UAE(BigDecimal r4_CRWA_RESIDENT_UAE) {
		R4_CRWA_RESIDENT_UAE = r4_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR4_EXPOSURE_NON_RESIDENT_UAE() {
		return R4_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR4_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r4_EXPOSURE_NON_RESIDENT_UAE) {
		R4_EXPOSURE_NON_RESIDENT_UAE = r4_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR4_CRWA_NON_RESIDENT_UAE() {
		return R4_CRWA_NON_RESIDENT_UAE;
	}
	public void setR4_CRWA_NON_RESIDENT_UAE(BigDecimal r4_CRWA_NON_RESIDENT_UAE) {
		R4_CRWA_NON_RESIDENT_UAE = r4_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR4_EXPOSURE_RESIDENT_NON_UAE() {
		return R4_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR4_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r4_EXPOSURE_RESIDENT_NON_UAE) {
		R4_EXPOSURE_RESIDENT_NON_UAE = r4_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR4_CRWA_RESIDENT_NON_UAE() {
		return R4_CRWA_RESIDENT_NON_UAE;
	}
	public void setR4_CRWA_RESIDENT_NON_UAE(BigDecimal r4_CRWA_RESIDENT_NON_UAE) {
		R4_CRWA_RESIDENT_NON_UAE = r4_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR4_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R4_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR4_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r4_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R4_EXPOSURE_NON_RESIDENT_NON_UAE = r4_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR4_CRWA_NON_RESIDENT_NON_UAE() {
		return R4_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR4_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r4_CRWA_NON_RESIDENT_NON_UAE) {
		R4_CRWA_NON_RESIDENT_NON_UAE = r4_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR4_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R4_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR4_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r4_EXPOSURE_INSIDE_CONSOLIDATED) {
		R4_EXPOSURE_INSIDE_CONSOLIDATED = r4_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR4_CRWA_INSIDE_CONSOLIDATED() {
		return R4_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR4_CRWA_INSIDE_CONSOLIDATED(BigDecimal r4_CRWA_INSIDE_CONSOLIDATED) {
		R4_CRWA_INSIDE_CONSOLIDATED = r4_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR4_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R4_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR4_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r4_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R4_EXPOSURE_OUTSIDE_CONSOLIDATED = r4_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR4_CRWA_OUTSIDE_CONSOLIDATED() {
		return R4_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR4_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r4_CRWA_OUTSIDE_CONSOLIDATED) {
		R4_CRWA_OUTSIDE_CONSOLIDATED = r4_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR4_NON_PERFORMING() {
		return R4_NON_PERFORMING;
	}
	public void setR4_NON_PERFORMING(BigDecimal r4_NON_PERFORMING) {
		R4_NON_PERFORMING = r4_NON_PERFORMING;
	}
	public BigDecimal getR4_SPECIFIC_PROVISION() {
		return R4_SPECIFIC_PROVISION;
	}
	public void setR4_SPECIFIC_PROVISION(BigDecimal r4_SPECIFIC_PROVISION) {
		R4_SPECIFIC_PROVISION = r4_SPECIFIC_PROVISION;
	}
	public BigDecimal getR4_INTEREST() {
		return R4_INTEREST;
	}
	public void setR4_INTEREST(BigDecimal r4_INTEREST) {
		R4_INTEREST = r4_INTEREST;
	}
	public BigDecimal getR4_DEFAULTED() {
		return R4_DEFAULTED;
	}
	public void setR4_DEFAULTED(BigDecimal r4_DEFAULTED) {
		R4_DEFAULTED = r4_DEFAULTED;
	}
	public String getR5_S_NO() {
		return R5_S_NO;
	}
	public void setR5_S_NO(String r5_S_NO) {
		R5_S_NO = r5_S_NO;
	}
	public String getR5_AMOUNT() {
		return R5_AMOUNT;
	}
	public void setR5_AMOUNT(String r5_AMOUNT) {
		R5_AMOUNT = r5_AMOUNT;
	}
	public BigDecimal getR5_TOTAL_CONSOLIDATED() {
		return R5_TOTAL_CONSOLIDATED;
	}
	public void setR5_TOTAL_CONSOLIDATED(BigDecimal r5_TOTAL_CONSOLIDATED) {
		R5_TOTAL_CONSOLIDATED = r5_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR5_CRWA_CONSOLIDATED() {
		return R5_CRWA_CONSOLIDATED;
	}
	public void setR5_CRWA_CONSOLIDATED(BigDecimal r5_CRWA_CONSOLIDATED) {
		R5_CRWA_CONSOLIDATED = r5_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR5_EXPOSURE_RESIDENT_UAE() {
		return R5_EXPOSURE_RESIDENT_UAE;
	}
	public void setR5_EXPOSURE_RESIDENT_UAE(BigDecimal r5_EXPOSURE_RESIDENT_UAE) {
		R5_EXPOSURE_RESIDENT_UAE = r5_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR5_CRWA_RESIDENT_UAE() {
		return R5_CRWA_RESIDENT_UAE;
	}
	public void setR5_CRWA_RESIDENT_UAE(BigDecimal r5_CRWA_RESIDENT_UAE) {
		R5_CRWA_RESIDENT_UAE = r5_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR5_EXPOSURE_NON_RESIDENT_UAE() {
		return R5_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR5_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r5_EXPOSURE_NON_RESIDENT_UAE) {
		R5_EXPOSURE_NON_RESIDENT_UAE = r5_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR5_CRWA_NON_RESIDENT_UAE() {
		return R5_CRWA_NON_RESIDENT_UAE;
	}
	public void setR5_CRWA_NON_RESIDENT_UAE(BigDecimal r5_CRWA_NON_RESIDENT_UAE) {
		R5_CRWA_NON_RESIDENT_UAE = r5_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR5_EXPOSURE_RESIDENT_NON_UAE() {
		return R5_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR5_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r5_EXPOSURE_RESIDENT_NON_UAE) {
		R5_EXPOSURE_RESIDENT_NON_UAE = r5_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR5_CRWA_RESIDENT_NON_UAE() {
		return R5_CRWA_RESIDENT_NON_UAE;
	}
	public void setR5_CRWA_RESIDENT_NON_UAE(BigDecimal r5_CRWA_RESIDENT_NON_UAE) {
		R5_CRWA_RESIDENT_NON_UAE = r5_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR5_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R5_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR5_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r5_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R5_EXPOSURE_NON_RESIDENT_NON_UAE = r5_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR5_CRWA_NON_RESIDENT_NON_UAE() {
		return R5_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR5_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r5_CRWA_NON_RESIDENT_NON_UAE) {
		R5_CRWA_NON_RESIDENT_NON_UAE = r5_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR5_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R5_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR5_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r5_EXPOSURE_INSIDE_CONSOLIDATED) {
		R5_EXPOSURE_INSIDE_CONSOLIDATED = r5_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR5_CRWA_INSIDE_CONSOLIDATED() {
		return R5_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR5_CRWA_INSIDE_CONSOLIDATED(BigDecimal r5_CRWA_INSIDE_CONSOLIDATED) {
		R5_CRWA_INSIDE_CONSOLIDATED = r5_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR5_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R5_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR5_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r5_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R5_EXPOSURE_OUTSIDE_CONSOLIDATED = r5_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR5_CRWA_OUTSIDE_CONSOLIDATED() {
		return R5_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR5_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r5_CRWA_OUTSIDE_CONSOLIDATED) {
		R5_CRWA_OUTSIDE_CONSOLIDATED = r5_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR5_NON_PERFORMING() {
		return R5_NON_PERFORMING;
	}
	public void setR5_NON_PERFORMING(BigDecimal r5_NON_PERFORMING) {
		R5_NON_PERFORMING = r5_NON_PERFORMING;
	}
	public BigDecimal getR5_SPECIFIC_PROVISION() {
		return R5_SPECIFIC_PROVISION;
	}
	public void setR5_SPECIFIC_PROVISION(BigDecimal r5_SPECIFIC_PROVISION) {
		R5_SPECIFIC_PROVISION = r5_SPECIFIC_PROVISION;
	}
	public BigDecimal getR5_INTEREST() {
		return R5_INTEREST;
	}
	public void setR5_INTEREST(BigDecimal r5_INTEREST) {
		R5_INTEREST = r5_INTEREST;
	}
	public BigDecimal getR5_DEFAULTED() {
		return R5_DEFAULTED;
	}
	public void setR5_DEFAULTED(BigDecimal r5_DEFAULTED) {
		R5_DEFAULTED = r5_DEFAULTED;
	}
	public String getR6_S_NO() {
		return R6_S_NO;
	}
	public void setR6_S_NO(String r6_S_NO) {
		R6_S_NO = r6_S_NO;
	}
	public String getR6_AMOUNT() {
		return R6_AMOUNT;
	}
	public void setR6_AMOUNT(String r6_AMOUNT) {
		R6_AMOUNT = r6_AMOUNT;
	}
	public BigDecimal getR6_TOTAL_CONSOLIDATED() {
		return R6_TOTAL_CONSOLIDATED;
	}
	public void setR6_TOTAL_CONSOLIDATED(BigDecimal r6_TOTAL_CONSOLIDATED) {
		R6_TOTAL_CONSOLIDATED = r6_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR6_CRWA_CONSOLIDATED() {
		return R6_CRWA_CONSOLIDATED;
	}
	public void setR6_CRWA_CONSOLIDATED(BigDecimal r6_CRWA_CONSOLIDATED) {
		R6_CRWA_CONSOLIDATED = r6_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR6_EXPOSURE_RESIDENT_UAE() {
		return R6_EXPOSURE_RESIDENT_UAE;
	}
	public void setR6_EXPOSURE_RESIDENT_UAE(BigDecimal r6_EXPOSURE_RESIDENT_UAE) {
		R6_EXPOSURE_RESIDENT_UAE = r6_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR6_CRWA_RESIDENT_UAE() {
		return R6_CRWA_RESIDENT_UAE;
	}
	public void setR6_CRWA_RESIDENT_UAE(BigDecimal r6_CRWA_RESIDENT_UAE) {
		R6_CRWA_RESIDENT_UAE = r6_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR6_EXPOSURE_NON_RESIDENT_UAE() {
		return R6_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR6_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r6_EXPOSURE_NON_RESIDENT_UAE) {
		R6_EXPOSURE_NON_RESIDENT_UAE = r6_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR6_CRWA_NON_RESIDENT_UAE() {
		return R6_CRWA_NON_RESIDENT_UAE;
	}
	public void setR6_CRWA_NON_RESIDENT_UAE(BigDecimal r6_CRWA_NON_RESIDENT_UAE) {
		R6_CRWA_NON_RESIDENT_UAE = r6_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR6_EXPOSURE_RESIDENT_NON_UAE() {
		return R6_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR6_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r6_EXPOSURE_RESIDENT_NON_UAE) {
		R6_EXPOSURE_RESIDENT_NON_UAE = r6_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR6_CRWA_RESIDENT_NON_UAE() {
		return R6_CRWA_RESIDENT_NON_UAE;
	}
	public void setR6_CRWA_RESIDENT_NON_UAE(BigDecimal r6_CRWA_RESIDENT_NON_UAE) {
		R6_CRWA_RESIDENT_NON_UAE = r6_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR6_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R6_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR6_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r6_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R6_EXPOSURE_NON_RESIDENT_NON_UAE = r6_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR6_CRWA_NON_RESIDENT_NON_UAE() {
		return R6_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR6_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r6_CRWA_NON_RESIDENT_NON_UAE) {
		R6_CRWA_NON_RESIDENT_NON_UAE = r6_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR6_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R6_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR6_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r6_EXPOSURE_INSIDE_CONSOLIDATED) {
		R6_EXPOSURE_INSIDE_CONSOLIDATED = r6_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR6_CRWA_INSIDE_CONSOLIDATED() {
		return R6_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR6_CRWA_INSIDE_CONSOLIDATED(BigDecimal r6_CRWA_INSIDE_CONSOLIDATED) {
		R6_CRWA_INSIDE_CONSOLIDATED = r6_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR6_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R6_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR6_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r6_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R6_EXPOSURE_OUTSIDE_CONSOLIDATED = r6_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR6_CRWA_OUTSIDE_CONSOLIDATED() {
		return R6_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR6_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r6_CRWA_OUTSIDE_CONSOLIDATED) {
		R6_CRWA_OUTSIDE_CONSOLIDATED = r6_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR6_NON_PERFORMING() {
		return R6_NON_PERFORMING;
	}
	public void setR6_NON_PERFORMING(BigDecimal r6_NON_PERFORMING) {
		R6_NON_PERFORMING = r6_NON_PERFORMING;
	}
	public BigDecimal getR6_SPECIFIC_PROVISION() {
		return R6_SPECIFIC_PROVISION;
	}
	public void setR6_SPECIFIC_PROVISION(BigDecimal r6_SPECIFIC_PROVISION) {
		R6_SPECIFIC_PROVISION = r6_SPECIFIC_PROVISION;
	}
	public BigDecimal getR6_INTEREST() {
		return R6_INTEREST;
	}
	public void setR6_INTEREST(BigDecimal r6_INTEREST) {
		R6_INTEREST = r6_INTEREST;
	}
	public BigDecimal getR6_DEFAULTED() {
		return R6_DEFAULTED;
	}
	public void setR6_DEFAULTED(BigDecimal r6_DEFAULTED) {
		R6_DEFAULTED = r6_DEFAULTED;
	}
	public String getR7_S_NO() {
		return R7_S_NO;
	}
	public void setR7_S_NO(String r7_S_NO) {
		R7_S_NO = r7_S_NO;
	}
	public String getR7_AMOUNT() {
		return R7_AMOUNT;
	}
	public void setR7_AMOUNT(String r7_AMOUNT) {
		R7_AMOUNT = r7_AMOUNT;
	}
	public BigDecimal getR7_TOTAL_CONSOLIDATED() {
		return R7_TOTAL_CONSOLIDATED;
	}
	public void setR7_TOTAL_CONSOLIDATED(BigDecimal r7_TOTAL_CONSOLIDATED) {
		R7_TOTAL_CONSOLIDATED = r7_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR7_CRWA_CONSOLIDATED() {
		return R7_CRWA_CONSOLIDATED;
	}
	public void setR7_CRWA_CONSOLIDATED(BigDecimal r7_CRWA_CONSOLIDATED) {
		R7_CRWA_CONSOLIDATED = r7_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR7_EXPOSURE_RESIDENT_UAE() {
		return R7_EXPOSURE_RESIDENT_UAE;
	}
	public void setR7_EXPOSURE_RESIDENT_UAE(BigDecimal r7_EXPOSURE_RESIDENT_UAE) {
		R7_EXPOSURE_RESIDENT_UAE = r7_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR7_CRWA_RESIDENT_UAE() {
		return R7_CRWA_RESIDENT_UAE;
	}
	public void setR7_CRWA_RESIDENT_UAE(BigDecimal r7_CRWA_RESIDENT_UAE) {
		R7_CRWA_RESIDENT_UAE = r7_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR7_EXPOSURE_NON_RESIDENT_UAE() {
		return R7_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR7_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r7_EXPOSURE_NON_RESIDENT_UAE) {
		R7_EXPOSURE_NON_RESIDENT_UAE = r7_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR7_CRWA_NON_RESIDENT_UAE() {
		return R7_CRWA_NON_RESIDENT_UAE;
	}
	public void setR7_CRWA_NON_RESIDENT_UAE(BigDecimal r7_CRWA_NON_RESIDENT_UAE) {
		R7_CRWA_NON_RESIDENT_UAE = r7_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR7_EXPOSURE_RESIDENT_NON_UAE() {
		return R7_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR7_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r7_EXPOSURE_RESIDENT_NON_UAE) {
		R7_EXPOSURE_RESIDENT_NON_UAE = r7_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR7_CRWA_RESIDENT_NON_UAE() {
		return R7_CRWA_RESIDENT_NON_UAE;
	}
	public void setR7_CRWA_RESIDENT_NON_UAE(BigDecimal r7_CRWA_RESIDENT_NON_UAE) {
		R7_CRWA_RESIDENT_NON_UAE = r7_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR7_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R7_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR7_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r7_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R7_EXPOSURE_NON_RESIDENT_NON_UAE = r7_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR7_CRWA_NON_RESIDENT_NON_UAE() {
		return R7_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR7_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r7_CRWA_NON_RESIDENT_NON_UAE) {
		R7_CRWA_NON_RESIDENT_NON_UAE = r7_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR7_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R7_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR7_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r7_EXPOSURE_INSIDE_CONSOLIDATED) {
		R7_EXPOSURE_INSIDE_CONSOLIDATED = r7_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR7_CRWA_INSIDE_CONSOLIDATED() {
		return R7_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR7_CRWA_INSIDE_CONSOLIDATED(BigDecimal r7_CRWA_INSIDE_CONSOLIDATED) {
		R7_CRWA_INSIDE_CONSOLIDATED = r7_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR7_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R7_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR7_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r7_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R7_EXPOSURE_OUTSIDE_CONSOLIDATED = r7_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR7_CRWA_OUTSIDE_CONSOLIDATED() {
		return R7_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR7_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r7_CRWA_OUTSIDE_CONSOLIDATED) {
		R7_CRWA_OUTSIDE_CONSOLIDATED = r7_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR7_NON_PERFORMING() {
		return R7_NON_PERFORMING;
	}
	public void setR7_NON_PERFORMING(BigDecimal r7_NON_PERFORMING) {
		R7_NON_PERFORMING = r7_NON_PERFORMING;
	}
	public BigDecimal getR7_SPECIFIC_PROVISION() {
		return R7_SPECIFIC_PROVISION;
	}
	public void setR7_SPECIFIC_PROVISION(BigDecimal r7_SPECIFIC_PROVISION) {
		R7_SPECIFIC_PROVISION = r7_SPECIFIC_PROVISION;
	}
	public BigDecimal getR7_INTEREST() {
		return R7_INTEREST;
	}
	public void setR7_INTEREST(BigDecimal r7_INTEREST) {
		R7_INTEREST = r7_INTEREST;
	}
	public BigDecimal getR7_DEFAULTED() {
		return R7_DEFAULTED;
	}
	public void setR7_DEFAULTED(BigDecimal r7_DEFAULTED) {
		R7_DEFAULTED = r7_DEFAULTED;
	}
	public String getR8_S_NO() {
		return R8_S_NO;
	}
	public void setR8_S_NO(String r8_S_NO) {
		R8_S_NO = r8_S_NO;
	}
	public String getR8_AMOUNT() {
		return R8_AMOUNT;
	}
	public void setR8_AMOUNT(String r8_AMOUNT) {
		R8_AMOUNT = r8_AMOUNT;
	}
	public BigDecimal getR8_TOTAL_CONSOLIDATED() {
		return R8_TOTAL_CONSOLIDATED;
	}
	public void setR8_TOTAL_CONSOLIDATED(BigDecimal r8_TOTAL_CONSOLIDATED) {
		R8_TOTAL_CONSOLIDATED = r8_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR8_CRWA_CONSOLIDATED() {
		return R8_CRWA_CONSOLIDATED;
	}
	public void setR8_CRWA_CONSOLIDATED(BigDecimal r8_CRWA_CONSOLIDATED) {
		R8_CRWA_CONSOLIDATED = r8_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR8_EXPOSURE_RESIDENT_UAE() {
		return R8_EXPOSURE_RESIDENT_UAE;
	}
	public void setR8_EXPOSURE_RESIDENT_UAE(BigDecimal r8_EXPOSURE_RESIDENT_UAE) {
		R8_EXPOSURE_RESIDENT_UAE = r8_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR8_CRWA_RESIDENT_UAE() {
		return R8_CRWA_RESIDENT_UAE;
	}
	public void setR8_CRWA_RESIDENT_UAE(BigDecimal r8_CRWA_RESIDENT_UAE) {
		R8_CRWA_RESIDENT_UAE = r8_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR8_EXPOSURE_NON_RESIDENT_UAE() {
		return R8_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR8_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r8_EXPOSURE_NON_RESIDENT_UAE) {
		R8_EXPOSURE_NON_RESIDENT_UAE = r8_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR8_CRWA_NON_RESIDENT_UAE() {
		return R8_CRWA_NON_RESIDENT_UAE;
	}
	public void setR8_CRWA_NON_RESIDENT_UAE(BigDecimal r8_CRWA_NON_RESIDENT_UAE) {
		R8_CRWA_NON_RESIDENT_UAE = r8_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR8_EXPOSURE_RESIDENT_NON_UAE() {
		return R8_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR8_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r8_EXPOSURE_RESIDENT_NON_UAE) {
		R8_EXPOSURE_RESIDENT_NON_UAE = r8_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR8_CRWA_RESIDENT_NON_UAE() {
		return R8_CRWA_RESIDENT_NON_UAE;
	}
	public void setR8_CRWA_RESIDENT_NON_UAE(BigDecimal r8_CRWA_RESIDENT_NON_UAE) {
		R8_CRWA_RESIDENT_NON_UAE = r8_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR8_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R8_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR8_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r8_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R8_EXPOSURE_NON_RESIDENT_NON_UAE = r8_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR8_CRWA_NON_RESIDENT_NON_UAE() {
		return R8_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR8_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r8_CRWA_NON_RESIDENT_NON_UAE) {
		R8_CRWA_NON_RESIDENT_NON_UAE = r8_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR8_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R8_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR8_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r8_EXPOSURE_INSIDE_CONSOLIDATED) {
		R8_EXPOSURE_INSIDE_CONSOLIDATED = r8_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR8_CRWA_INSIDE_CONSOLIDATED() {
		return R8_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR8_CRWA_INSIDE_CONSOLIDATED(BigDecimal r8_CRWA_INSIDE_CONSOLIDATED) {
		R8_CRWA_INSIDE_CONSOLIDATED = r8_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR8_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R8_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR8_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r8_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R8_EXPOSURE_OUTSIDE_CONSOLIDATED = r8_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR8_CRWA_OUTSIDE_CONSOLIDATED() {
		return R8_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR8_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r8_CRWA_OUTSIDE_CONSOLIDATED) {
		R8_CRWA_OUTSIDE_CONSOLIDATED = r8_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR8_NON_PERFORMING() {
		return R8_NON_PERFORMING;
	}
	public void setR8_NON_PERFORMING(BigDecimal r8_NON_PERFORMING) {
		R8_NON_PERFORMING = r8_NON_PERFORMING;
	}
	public BigDecimal getR8_SPECIFIC_PROVISION() {
		return R8_SPECIFIC_PROVISION;
	}
	public void setR8_SPECIFIC_PROVISION(BigDecimal r8_SPECIFIC_PROVISION) {
		R8_SPECIFIC_PROVISION = r8_SPECIFIC_PROVISION;
	}
	public BigDecimal getR8_INTEREST() {
		return R8_INTEREST;
	}
	public void setR8_INTEREST(BigDecimal r8_INTEREST) {
		R8_INTEREST = r8_INTEREST;
	}
	public BigDecimal getR8_DEFAULTED() {
		return R8_DEFAULTED;
	}
	public void setR8_DEFAULTED(BigDecimal r8_DEFAULTED) {
		R8_DEFAULTED = r8_DEFAULTED;
	}
	public String getR9_S_NO() {
		return R9_S_NO;
	}
	public void setR9_S_NO(String r9_S_NO) {
		R9_S_NO = r9_S_NO;
	}
	public String getR9_AMOUNT() {
		return R9_AMOUNT;
	}
	public void setR9_AMOUNT(String r9_AMOUNT) {
		R9_AMOUNT = r9_AMOUNT;
	}
	public BigDecimal getR9_TOTAL_CONSOLIDATED() {
		return R9_TOTAL_CONSOLIDATED;
	}
	public void setR9_TOTAL_CONSOLIDATED(BigDecimal r9_TOTAL_CONSOLIDATED) {
		R9_TOTAL_CONSOLIDATED = r9_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR9_CRWA_CONSOLIDATED() {
		return R9_CRWA_CONSOLIDATED;
	}
	public void setR9_CRWA_CONSOLIDATED(BigDecimal r9_CRWA_CONSOLIDATED) {
		R9_CRWA_CONSOLIDATED = r9_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR9_EXPOSURE_RESIDENT_UAE() {
		return R9_EXPOSURE_RESIDENT_UAE;
	}
	public void setR9_EXPOSURE_RESIDENT_UAE(BigDecimal r9_EXPOSURE_RESIDENT_UAE) {
		R9_EXPOSURE_RESIDENT_UAE = r9_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR9_CRWA_RESIDENT_UAE() {
		return R9_CRWA_RESIDENT_UAE;
	}
	public void setR9_CRWA_RESIDENT_UAE(BigDecimal r9_CRWA_RESIDENT_UAE) {
		R9_CRWA_RESIDENT_UAE = r9_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR9_EXPOSURE_NON_RESIDENT_UAE() {
		return R9_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR9_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r9_EXPOSURE_NON_RESIDENT_UAE) {
		R9_EXPOSURE_NON_RESIDENT_UAE = r9_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR9_CRWA_NON_RESIDENT_UAE() {
		return R9_CRWA_NON_RESIDENT_UAE;
	}
	public void setR9_CRWA_NON_RESIDENT_UAE(BigDecimal r9_CRWA_NON_RESIDENT_UAE) {
		R9_CRWA_NON_RESIDENT_UAE = r9_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR9_EXPOSURE_RESIDENT_NON_UAE() {
		return R9_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR9_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r9_EXPOSURE_RESIDENT_NON_UAE) {
		R9_EXPOSURE_RESIDENT_NON_UAE = r9_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR9_CRWA_RESIDENT_NON_UAE() {
		return R9_CRWA_RESIDENT_NON_UAE;
	}
	public void setR9_CRWA_RESIDENT_NON_UAE(BigDecimal r9_CRWA_RESIDENT_NON_UAE) {
		R9_CRWA_RESIDENT_NON_UAE = r9_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR9_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R9_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR9_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r9_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R9_EXPOSURE_NON_RESIDENT_NON_UAE = r9_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR9_CRWA_NON_RESIDENT_NON_UAE() {
		return R9_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR9_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r9_CRWA_NON_RESIDENT_NON_UAE) {
		R9_CRWA_NON_RESIDENT_NON_UAE = r9_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR9_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R9_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR9_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r9_EXPOSURE_INSIDE_CONSOLIDATED) {
		R9_EXPOSURE_INSIDE_CONSOLIDATED = r9_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR9_CRWA_INSIDE_CONSOLIDATED() {
		return R9_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR9_CRWA_INSIDE_CONSOLIDATED(BigDecimal r9_CRWA_INSIDE_CONSOLIDATED) {
		R9_CRWA_INSIDE_CONSOLIDATED = r9_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR9_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R9_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR9_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r9_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R9_EXPOSURE_OUTSIDE_CONSOLIDATED = r9_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR9_CRWA_OUTSIDE_CONSOLIDATED() {
		return R9_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR9_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r9_CRWA_OUTSIDE_CONSOLIDATED) {
		R9_CRWA_OUTSIDE_CONSOLIDATED = r9_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR9_NON_PERFORMING() {
		return R9_NON_PERFORMING;
	}
	public void setR9_NON_PERFORMING(BigDecimal r9_NON_PERFORMING) {
		R9_NON_PERFORMING = r9_NON_PERFORMING;
	}
	public BigDecimal getR9_SPECIFIC_PROVISION() {
		return R9_SPECIFIC_PROVISION;
	}
	public void setR9_SPECIFIC_PROVISION(BigDecimal r9_SPECIFIC_PROVISION) {
		R9_SPECIFIC_PROVISION = r9_SPECIFIC_PROVISION;
	}
	public BigDecimal getR9_INTEREST() {
		return R9_INTEREST;
	}
	public void setR9_INTEREST(BigDecimal r9_INTEREST) {
		R9_INTEREST = r9_INTEREST;
	}
	public BigDecimal getR9_DEFAULTED() {
		return R9_DEFAULTED;
	}
	public void setR9_DEFAULTED(BigDecimal r9_DEFAULTED) {
		R9_DEFAULTED = r9_DEFAULTED;
	}
	public String getR10_S_NO() {
		return R10_S_NO;
	}
	public void setR10_S_NO(String r10_S_NO) {
		R10_S_NO = r10_S_NO;
	}
	public String getR10_AMOUNT() {
		return R10_AMOUNT;
	}
	public void setR10_AMOUNT(String r10_AMOUNT) {
		R10_AMOUNT = r10_AMOUNT;
	}
	public BigDecimal getR10_TOTAL_CONSOLIDATED() {
		return R10_TOTAL_CONSOLIDATED;
	}
	public void setR10_TOTAL_CONSOLIDATED(BigDecimal r10_TOTAL_CONSOLIDATED) {
		R10_TOTAL_CONSOLIDATED = r10_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR10_CRWA_CONSOLIDATED() {
		return R10_CRWA_CONSOLIDATED;
	}
	public void setR10_CRWA_CONSOLIDATED(BigDecimal r10_CRWA_CONSOLIDATED) {
		R10_CRWA_CONSOLIDATED = r10_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR10_EXPOSURE_RESIDENT_UAE() {
		return R10_EXPOSURE_RESIDENT_UAE;
	}
	public void setR10_EXPOSURE_RESIDENT_UAE(BigDecimal r10_EXPOSURE_RESIDENT_UAE) {
		R10_EXPOSURE_RESIDENT_UAE = r10_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR10_CRWA_RESIDENT_UAE() {
		return R10_CRWA_RESIDENT_UAE;
	}
	public void setR10_CRWA_RESIDENT_UAE(BigDecimal r10_CRWA_RESIDENT_UAE) {
		R10_CRWA_RESIDENT_UAE = r10_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR10_EXPOSURE_NON_RESIDENT_UAE() {
		return R10_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR10_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r10_EXPOSURE_NON_RESIDENT_UAE) {
		R10_EXPOSURE_NON_RESIDENT_UAE = r10_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR10_CRWA_NON_RESIDENT_UAE() {
		return R10_CRWA_NON_RESIDENT_UAE;
	}
	public void setR10_CRWA_NON_RESIDENT_UAE(BigDecimal r10_CRWA_NON_RESIDENT_UAE) {
		R10_CRWA_NON_RESIDENT_UAE = r10_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR10_EXPOSURE_RESIDENT_NON_UAE() {
		return R10_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR10_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r10_EXPOSURE_RESIDENT_NON_UAE) {
		R10_EXPOSURE_RESIDENT_NON_UAE = r10_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR10_CRWA_RESIDENT_NON_UAE() {
		return R10_CRWA_RESIDENT_NON_UAE;
	}
	public void setR10_CRWA_RESIDENT_NON_UAE(BigDecimal r10_CRWA_RESIDENT_NON_UAE) {
		R10_CRWA_RESIDENT_NON_UAE = r10_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR10_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R10_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR10_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r10_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R10_EXPOSURE_NON_RESIDENT_NON_UAE = r10_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR10_CRWA_NON_RESIDENT_NON_UAE() {
		return R10_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR10_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r10_CRWA_NON_RESIDENT_NON_UAE) {
		R10_CRWA_NON_RESIDENT_NON_UAE = r10_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR10_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R10_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR10_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r10_EXPOSURE_INSIDE_CONSOLIDATED) {
		R10_EXPOSURE_INSIDE_CONSOLIDATED = r10_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR10_CRWA_INSIDE_CONSOLIDATED() {
		return R10_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR10_CRWA_INSIDE_CONSOLIDATED(BigDecimal r10_CRWA_INSIDE_CONSOLIDATED) {
		R10_CRWA_INSIDE_CONSOLIDATED = r10_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR10_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R10_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR10_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r10_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R10_EXPOSURE_OUTSIDE_CONSOLIDATED = r10_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR10_CRWA_OUTSIDE_CONSOLIDATED() {
		return R10_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR10_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r10_CRWA_OUTSIDE_CONSOLIDATED) {
		R10_CRWA_OUTSIDE_CONSOLIDATED = r10_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR10_NON_PERFORMING() {
		return R10_NON_PERFORMING;
	}
	public void setR10_NON_PERFORMING(BigDecimal r10_NON_PERFORMING) {
		R10_NON_PERFORMING = r10_NON_PERFORMING;
	}
	public BigDecimal getR10_SPECIFIC_PROVISION() {
		return R10_SPECIFIC_PROVISION;
	}
	public void setR10_SPECIFIC_PROVISION(BigDecimal r10_SPECIFIC_PROVISION) {
		R10_SPECIFIC_PROVISION = r10_SPECIFIC_PROVISION;
	}
	public BigDecimal getR10_INTEREST() {
		return R10_INTEREST;
	}
	public void setR10_INTEREST(BigDecimal r10_INTEREST) {
		R10_INTEREST = r10_INTEREST;
	}
	public BigDecimal getR10_DEFAULTED() {
		return R10_DEFAULTED;
	}
	public void setR10_DEFAULTED(BigDecimal r10_DEFAULTED) {
		R10_DEFAULTED = r10_DEFAULTED;
	}
	public String getR11_S_NO() {
		return R11_S_NO;
	}
	public void setR11_S_NO(String r11_S_NO) {
		R11_S_NO = r11_S_NO;
	}
	public String getR11_AMOUNT() {
		return R11_AMOUNT;
	}
	public void setR11_AMOUNT(String r11_AMOUNT) {
		R11_AMOUNT = r11_AMOUNT;
	}
	public BigDecimal getR11_TOTAL_CONSOLIDATED() {
		return R11_TOTAL_CONSOLIDATED;
	}
	public void setR11_TOTAL_CONSOLIDATED(BigDecimal r11_TOTAL_CONSOLIDATED) {
		R11_TOTAL_CONSOLIDATED = r11_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR11_CRWA_CONSOLIDATED() {
		return R11_CRWA_CONSOLIDATED;
	}
	public void setR11_CRWA_CONSOLIDATED(BigDecimal r11_CRWA_CONSOLIDATED) {
		R11_CRWA_CONSOLIDATED = r11_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR11_EXPOSURE_RESIDENT_UAE() {
		return R11_EXPOSURE_RESIDENT_UAE;
	}
	public void setR11_EXPOSURE_RESIDENT_UAE(BigDecimal r11_EXPOSURE_RESIDENT_UAE) {
		R11_EXPOSURE_RESIDENT_UAE = r11_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR11_CRWA_RESIDENT_UAE() {
		return R11_CRWA_RESIDENT_UAE;
	}
	public void setR11_CRWA_RESIDENT_UAE(BigDecimal r11_CRWA_RESIDENT_UAE) {
		R11_CRWA_RESIDENT_UAE = r11_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR11_EXPOSURE_NON_RESIDENT_UAE() {
		return R11_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR11_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r11_EXPOSURE_NON_RESIDENT_UAE) {
		R11_EXPOSURE_NON_RESIDENT_UAE = r11_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR11_CRWA_NON_RESIDENT_UAE() {
		return R11_CRWA_NON_RESIDENT_UAE;
	}
	public void setR11_CRWA_NON_RESIDENT_UAE(BigDecimal r11_CRWA_NON_RESIDENT_UAE) {
		R11_CRWA_NON_RESIDENT_UAE = r11_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR11_EXPOSURE_RESIDENT_NON_UAE() {
		return R11_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR11_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r11_EXPOSURE_RESIDENT_NON_UAE) {
		R11_EXPOSURE_RESIDENT_NON_UAE = r11_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR11_CRWA_RESIDENT_NON_UAE() {
		return R11_CRWA_RESIDENT_NON_UAE;
	}
	public void setR11_CRWA_RESIDENT_NON_UAE(BigDecimal r11_CRWA_RESIDENT_NON_UAE) {
		R11_CRWA_RESIDENT_NON_UAE = r11_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR11_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R11_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR11_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r11_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R11_EXPOSURE_NON_RESIDENT_NON_UAE = r11_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR11_CRWA_NON_RESIDENT_NON_UAE() {
		return R11_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR11_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r11_CRWA_NON_RESIDENT_NON_UAE) {
		R11_CRWA_NON_RESIDENT_NON_UAE = r11_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR11_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R11_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR11_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r11_EXPOSURE_INSIDE_CONSOLIDATED) {
		R11_EXPOSURE_INSIDE_CONSOLIDATED = r11_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR11_CRWA_INSIDE_CONSOLIDATED() {
		return R11_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR11_CRWA_INSIDE_CONSOLIDATED(BigDecimal r11_CRWA_INSIDE_CONSOLIDATED) {
		R11_CRWA_INSIDE_CONSOLIDATED = r11_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR11_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R11_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR11_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r11_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R11_EXPOSURE_OUTSIDE_CONSOLIDATED = r11_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR11_CRWA_OUTSIDE_CONSOLIDATED() {
		return R11_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR11_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r11_CRWA_OUTSIDE_CONSOLIDATED) {
		R11_CRWA_OUTSIDE_CONSOLIDATED = r11_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR11_NON_PERFORMING() {
		return R11_NON_PERFORMING;
	}
	public void setR11_NON_PERFORMING(BigDecimal r11_NON_PERFORMING) {
		R11_NON_PERFORMING = r11_NON_PERFORMING;
	}
	public BigDecimal getR11_SPECIFIC_PROVISION() {
		return R11_SPECIFIC_PROVISION;
	}
	public void setR11_SPECIFIC_PROVISION(BigDecimal r11_SPECIFIC_PROVISION) {
		R11_SPECIFIC_PROVISION = r11_SPECIFIC_PROVISION;
	}
	public BigDecimal getR11_INTEREST() {
		return R11_INTEREST;
	}
	public void setR11_INTEREST(BigDecimal r11_INTEREST) {
		R11_INTEREST = r11_INTEREST;
	}
	public BigDecimal getR11_DEFAULTED() {
		return R11_DEFAULTED;
	}
	public void setR11_DEFAULTED(BigDecimal r11_DEFAULTED) {
		R11_DEFAULTED = r11_DEFAULTED;
	}
	public String getR12_S_NO() {
		return R12_S_NO;
	}
	public void setR12_S_NO(String r12_S_NO) {
		R12_S_NO = r12_S_NO;
	}
	public String getR12_AMOUNT() {
		return R12_AMOUNT;
	}
	public void setR12_AMOUNT(String r12_AMOUNT) {
		R12_AMOUNT = r12_AMOUNT;
	}
	public BigDecimal getR12_TOTAL_CONSOLIDATED() {
		return R12_TOTAL_CONSOLIDATED;
	}
	public void setR12_TOTAL_CONSOLIDATED(BigDecimal r12_TOTAL_CONSOLIDATED) {
		R12_TOTAL_CONSOLIDATED = r12_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR12_CRWA_CONSOLIDATED() {
		return R12_CRWA_CONSOLIDATED;
	}
	public void setR12_CRWA_CONSOLIDATED(BigDecimal r12_CRWA_CONSOLIDATED) {
		R12_CRWA_CONSOLIDATED = r12_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR12_EXPOSURE_RESIDENT_UAE() {
		return R12_EXPOSURE_RESIDENT_UAE;
	}
	public void setR12_EXPOSURE_RESIDENT_UAE(BigDecimal r12_EXPOSURE_RESIDENT_UAE) {
		R12_EXPOSURE_RESIDENT_UAE = r12_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR12_CRWA_RESIDENT_UAE() {
		return R12_CRWA_RESIDENT_UAE;
	}
	public void setR12_CRWA_RESIDENT_UAE(BigDecimal r12_CRWA_RESIDENT_UAE) {
		R12_CRWA_RESIDENT_UAE = r12_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR12_EXPOSURE_NON_RESIDENT_UAE() {
		return R12_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR12_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r12_EXPOSURE_NON_RESIDENT_UAE) {
		R12_EXPOSURE_NON_RESIDENT_UAE = r12_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR12_CRWA_NON_RESIDENT_UAE() {
		return R12_CRWA_NON_RESIDENT_UAE;
	}
	public void setR12_CRWA_NON_RESIDENT_UAE(BigDecimal r12_CRWA_NON_RESIDENT_UAE) {
		R12_CRWA_NON_RESIDENT_UAE = r12_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR12_EXPOSURE_RESIDENT_NON_UAE() {
		return R12_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR12_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r12_EXPOSURE_RESIDENT_NON_UAE) {
		R12_EXPOSURE_RESIDENT_NON_UAE = r12_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR12_CRWA_RESIDENT_NON_UAE() {
		return R12_CRWA_RESIDENT_NON_UAE;
	}
	public void setR12_CRWA_RESIDENT_NON_UAE(BigDecimal r12_CRWA_RESIDENT_NON_UAE) {
		R12_CRWA_RESIDENT_NON_UAE = r12_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR12_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R12_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR12_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r12_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R12_EXPOSURE_NON_RESIDENT_NON_UAE = r12_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR12_CRWA_NON_RESIDENT_NON_UAE() {
		return R12_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR12_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r12_CRWA_NON_RESIDENT_NON_UAE) {
		R12_CRWA_NON_RESIDENT_NON_UAE = r12_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR12_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R12_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR12_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r12_EXPOSURE_INSIDE_CONSOLIDATED) {
		R12_EXPOSURE_INSIDE_CONSOLIDATED = r12_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR12_CRWA_INSIDE_CONSOLIDATED() {
		return R12_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR12_CRWA_INSIDE_CONSOLIDATED(BigDecimal r12_CRWA_INSIDE_CONSOLIDATED) {
		R12_CRWA_INSIDE_CONSOLIDATED = r12_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR12_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R12_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR12_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r12_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R12_EXPOSURE_OUTSIDE_CONSOLIDATED = r12_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR12_CRWA_OUTSIDE_CONSOLIDATED() {
		return R12_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR12_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r12_CRWA_OUTSIDE_CONSOLIDATED) {
		R12_CRWA_OUTSIDE_CONSOLIDATED = r12_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR12_NON_PERFORMING() {
		return R12_NON_PERFORMING;
	}
	public void setR12_NON_PERFORMING(BigDecimal r12_NON_PERFORMING) {
		R12_NON_PERFORMING = r12_NON_PERFORMING;
	}
	public BigDecimal getR12_SPECIFIC_PROVISION() {
		return R12_SPECIFIC_PROVISION;
	}
	public void setR12_SPECIFIC_PROVISION(BigDecimal r12_SPECIFIC_PROVISION) {
		R12_SPECIFIC_PROVISION = r12_SPECIFIC_PROVISION;
	}
	public BigDecimal getR12_INTEREST() {
		return R12_INTEREST;
	}
	public void setR12_INTEREST(BigDecimal r12_INTEREST) {
		R12_INTEREST = r12_INTEREST;
	}
	public BigDecimal getR12_DEFAULTED() {
		return R12_DEFAULTED;
	}
	public void setR12_DEFAULTED(BigDecimal r12_DEFAULTED) {
		R12_DEFAULTED = r12_DEFAULTED;
	}
	public String getR13_S_NO() {
		return R13_S_NO;
	}
	public void setR13_S_NO(String r13_S_NO) {
		R13_S_NO = r13_S_NO;
	}
	public String getR13_AMOUNT() {
		return R13_AMOUNT;
	}
	public void setR13_AMOUNT(String r13_AMOUNT) {
		R13_AMOUNT = r13_AMOUNT;
	}
	public BigDecimal getR13_TOTAL_CONSOLIDATED() {
		return R13_TOTAL_CONSOLIDATED;
	}
	public void setR13_TOTAL_CONSOLIDATED(BigDecimal r13_TOTAL_CONSOLIDATED) {
		R13_TOTAL_CONSOLIDATED = r13_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR13_CRWA_CONSOLIDATED() {
		return R13_CRWA_CONSOLIDATED;
	}
	public void setR13_CRWA_CONSOLIDATED(BigDecimal r13_CRWA_CONSOLIDATED) {
		R13_CRWA_CONSOLIDATED = r13_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR13_EXPOSURE_RESIDENT_UAE() {
		return R13_EXPOSURE_RESIDENT_UAE;
	}
	public void setR13_EXPOSURE_RESIDENT_UAE(BigDecimal r13_EXPOSURE_RESIDENT_UAE) {
		R13_EXPOSURE_RESIDENT_UAE = r13_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR13_CRWA_RESIDENT_UAE() {
		return R13_CRWA_RESIDENT_UAE;
	}
	public void setR13_CRWA_RESIDENT_UAE(BigDecimal r13_CRWA_RESIDENT_UAE) {
		R13_CRWA_RESIDENT_UAE = r13_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR13_EXPOSURE_NON_RESIDENT_UAE() {
		return R13_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR13_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r13_EXPOSURE_NON_RESIDENT_UAE) {
		R13_EXPOSURE_NON_RESIDENT_UAE = r13_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR13_CRWA_NON_RESIDENT_UAE() {
		return R13_CRWA_NON_RESIDENT_UAE;
	}
	public void setR13_CRWA_NON_RESIDENT_UAE(BigDecimal r13_CRWA_NON_RESIDENT_UAE) {
		R13_CRWA_NON_RESIDENT_UAE = r13_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR13_EXPOSURE_RESIDENT_NON_UAE() {
		return R13_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR13_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r13_EXPOSURE_RESIDENT_NON_UAE) {
		R13_EXPOSURE_RESIDENT_NON_UAE = r13_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR13_CRWA_RESIDENT_NON_UAE() {
		return R13_CRWA_RESIDENT_NON_UAE;
	}
	public void setR13_CRWA_RESIDENT_NON_UAE(BigDecimal r13_CRWA_RESIDENT_NON_UAE) {
		R13_CRWA_RESIDENT_NON_UAE = r13_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR13_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R13_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR13_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r13_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R13_EXPOSURE_NON_RESIDENT_NON_UAE = r13_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR13_CRWA_NON_RESIDENT_NON_UAE() {
		return R13_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR13_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r13_CRWA_NON_RESIDENT_NON_UAE) {
		R13_CRWA_NON_RESIDENT_NON_UAE = r13_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR13_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R13_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR13_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r13_EXPOSURE_INSIDE_CONSOLIDATED) {
		R13_EXPOSURE_INSIDE_CONSOLIDATED = r13_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR13_CRWA_INSIDE_CONSOLIDATED() {
		return R13_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR13_CRWA_INSIDE_CONSOLIDATED(BigDecimal r13_CRWA_INSIDE_CONSOLIDATED) {
		R13_CRWA_INSIDE_CONSOLIDATED = r13_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR13_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R13_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR13_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r13_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R13_EXPOSURE_OUTSIDE_CONSOLIDATED = r13_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR13_CRWA_OUTSIDE_CONSOLIDATED() {
		return R13_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR13_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r13_CRWA_OUTSIDE_CONSOLIDATED) {
		R13_CRWA_OUTSIDE_CONSOLIDATED = r13_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR13_NON_PERFORMING() {
		return R13_NON_PERFORMING;
	}
	public void setR13_NON_PERFORMING(BigDecimal r13_NON_PERFORMING) {
		R13_NON_PERFORMING = r13_NON_PERFORMING;
	}
	public BigDecimal getR13_SPECIFIC_PROVISION() {
		return R13_SPECIFIC_PROVISION;
	}
	public void setR13_SPECIFIC_PROVISION(BigDecimal r13_SPECIFIC_PROVISION) {
		R13_SPECIFIC_PROVISION = r13_SPECIFIC_PROVISION;
	}
	public BigDecimal getR13_INTEREST() {
		return R13_INTEREST;
	}
	public void setR13_INTEREST(BigDecimal r13_INTEREST) {
		R13_INTEREST = r13_INTEREST;
	}
	public BigDecimal getR13_DEFAULTED() {
		return R13_DEFAULTED;
	}
	public void setR13_DEFAULTED(BigDecimal r13_DEFAULTED) {
		R13_DEFAULTED = r13_DEFAULTED;
	}
	public String getR14_S_NO() {
		return R14_S_NO;
	}
	public void setR14_S_NO(String r14_S_NO) {
		R14_S_NO = r14_S_NO;
	}
	public String getR14_AMOUNT() {
		return R14_AMOUNT;
	}
	public void setR14_AMOUNT(String r14_AMOUNT) {
		R14_AMOUNT = r14_AMOUNT;
	}
	public BigDecimal getR14_TOTAL_CONSOLIDATED() {
		return R14_TOTAL_CONSOLIDATED;
	}
	public void setR14_TOTAL_CONSOLIDATED(BigDecimal r14_TOTAL_CONSOLIDATED) {
		R14_TOTAL_CONSOLIDATED = r14_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR14_CRWA_CONSOLIDATED() {
		return R14_CRWA_CONSOLIDATED;
	}
	public void setR14_CRWA_CONSOLIDATED(BigDecimal r14_CRWA_CONSOLIDATED) {
		R14_CRWA_CONSOLIDATED = r14_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR14_EXPOSURE_RESIDENT_UAE() {
		return R14_EXPOSURE_RESIDENT_UAE;
	}
	public void setR14_EXPOSURE_RESIDENT_UAE(BigDecimal r14_EXPOSURE_RESIDENT_UAE) {
		R14_EXPOSURE_RESIDENT_UAE = r14_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR14_CRWA_RESIDENT_UAE() {
		return R14_CRWA_RESIDENT_UAE;
	}
	public void setR14_CRWA_RESIDENT_UAE(BigDecimal r14_CRWA_RESIDENT_UAE) {
		R14_CRWA_RESIDENT_UAE = r14_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR14_EXPOSURE_NON_RESIDENT_UAE() {
		return R14_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR14_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r14_EXPOSURE_NON_RESIDENT_UAE) {
		R14_EXPOSURE_NON_RESIDENT_UAE = r14_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR14_CRWA_NON_RESIDENT_UAE() {
		return R14_CRWA_NON_RESIDENT_UAE;
	}
	public void setR14_CRWA_NON_RESIDENT_UAE(BigDecimal r14_CRWA_NON_RESIDENT_UAE) {
		R14_CRWA_NON_RESIDENT_UAE = r14_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR14_EXPOSURE_RESIDENT_NON_UAE() {
		return R14_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR14_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r14_EXPOSURE_RESIDENT_NON_UAE) {
		R14_EXPOSURE_RESIDENT_NON_UAE = r14_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR14_CRWA_RESIDENT_NON_UAE() {
		return R14_CRWA_RESIDENT_NON_UAE;
	}
	public void setR14_CRWA_RESIDENT_NON_UAE(BigDecimal r14_CRWA_RESIDENT_NON_UAE) {
		R14_CRWA_RESIDENT_NON_UAE = r14_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR14_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R14_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR14_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r14_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R14_EXPOSURE_NON_RESIDENT_NON_UAE = r14_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR14_CRWA_NON_RESIDENT_NON_UAE() {
		return R14_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR14_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r14_CRWA_NON_RESIDENT_NON_UAE) {
		R14_CRWA_NON_RESIDENT_NON_UAE = r14_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR14_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R14_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR14_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r14_EXPOSURE_INSIDE_CONSOLIDATED) {
		R14_EXPOSURE_INSIDE_CONSOLIDATED = r14_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR14_CRWA_INSIDE_CONSOLIDATED() {
		return R14_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR14_CRWA_INSIDE_CONSOLIDATED(BigDecimal r14_CRWA_INSIDE_CONSOLIDATED) {
		R14_CRWA_INSIDE_CONSOLIDATED = r14_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR14_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R14_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR14_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r14_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R14_EXPOSURE_OUTSIDE_CONSOLIDATED = r14_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR14_CRWA_OUTSIDE_CONSOLIDATED() {
		return R14_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR14_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r14_CRWA_OUTSIDE_CONSOLIDATED) {
		R14_CRWA_OUTSIDE_CONSOLIDATED = r14_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR14_NON_PERFORMING() {
		return R14_NON_PERFORMING;
	}
	public void setR14_NON_PERFORMING(BigDecimal r14_NON_PERFORMING) {
		R14_NON_PERFORMING = r14_NON_PERFORMING;
	}
	public BigDecimal getR14_SPECIFIC_PROVISION() {
		return R14_SPECIFIC_PROVISION;
	}
	public void setR14_SPECIFIC_PROVISION(BigDecimal r14_SPECIFIC_PROVISION) {
		R14_SPECIFIC_PROVISION = r14_SPECIFIC_PROVISION;
	}
	public BigDecimal getR14_INTEREST() {
		return R14_INTEREST;
	}
	public void setR14_INTEREST(BigDecimal r14_INTEREST) {
		R14_INTEREST = r14_INTEREST;
	}
	public BigDecimal getR14_DEFAULTED() {
		return R14_DEFAULTED;
	}
	public void setR14_DEFAULTED(BigDecimal r14_DEFAULTED) {
		R14_DEFAULTED = r14_DEFAULTED;
	}
	public String getR15_S_NO() {
		return R15_S_NO;
	}
	public void setR15_S_NO(String r15_S_NO) {
		R15_S_NO = r15_S_NO;
	}
	public String getR15_AMOUNT() {
		return R15_AMOUNT;
	}
	public void setR15_AMOUNT(String r15_AMOUNT) {
		R15_AMOUNT = r15_AMOUNT;
	}
	public BigDecimal getR15_TOTAL_CONSOLIDATED() {
		return R15_TOTAL_CONSOLIDATED;
	}
	public void setR15_TOTAL_CONSOLIDATED(BigDecimal r15_TOTAL_CONSOLIDATED) {
		R15_TOTAL_CONSOLIDATED = r15_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR15_CRWA_CONSOLIDATED() {
		return R15_CRWA_CONSOLIDATED;
	}
	public void setR15_CRWA_CONSOLIDATED(BigDecimal r15_CRWA_CONSOLIDATED) {
		R15_CRWA_CONSOLIDATED = r15_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR15_EXPOSURE_RESIDENT_UAE() {
		return R15_EXPOSURE_RESIDENT_UAE;
	}
	public void setR15_EXPOSURE_RESIDENT_UAE(BigDecimal r15_EXPOSURE_RESIDENT_UAE) {
		R15_EXPOSURE_RESIDENT_UAE = r15_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR15_CRWA_RESIDENT_UAE() {
		return R15_CRWA_RESIDENT_UAE;
	}
	public void setR15_CRWA_RESIDENT_UAE(BigDecimal r15_CRWA_RESIDENT_UAE) {
		R15_CRWA_RESIDENT_UAE = r15_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR15_EXPOSURE_NON_RESIDENT_UAE() {
		return R15_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR15_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r15_EXPOSURE_NON_RESIDENT_UAE) {
		R15_EXPOSURE_NON_RESIDENT_UAE = r15_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR15_CRWA_NON_RESIDENT_UAE() {
		return R15_CRWA_NON_RESIDENT_UAE;
	}
	public void setR15_CRWA_NON_RESIDENT_UAE(BigDecimal r15_CRWA_NON_RESIDENT_UAE) {
		R15_CRWA_NON_RESIDENT_UAE = r15_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR15_EXPOSURE_RESIDENT_NON_UAE() {
		return R15_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR15_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r15_EXPOSURE_RESIDENT_NON_UAE) {
		R15_EXPOSURE_RESIDENT_NON_UAE = r15_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR15_CRWA_RESIDENT_NON_UAE() {
		return R15_CRWA_RESIDENT_NON_UAE;
	}
	public void setR15_CRWA_RESIDENT_NON_UAE(BigDecimal r15_CRWA_RESIDENT_NON_UAE) {
		R15_CRWA_RESIDENT_NON_UAE = r15_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR15_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R15_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR15_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r15_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R15_EXPOSURE_NON_RESIDENT_NON_UAE = r15_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR15_CRWA_NON_RESIDENT_NON_UAE() {
		return R15_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR15_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r15_CRWA_NON_RESIDENT_NON_UAE) {
		R15_CRWA_NON_RESIDENT_NON_UAE = r15_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR15_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R15_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR15_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r15_EXPOSURE_INSIDE_CONSOLIDATED) {
		R15_EXPOSURE_INSIDE_CONSOLIDATED = r15_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR15_CRWA_INSIDE_CONSOLIDATED() {
		return R15_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR15_CRWA_INSIDE_CONSOLIDATED(BigDecimal r15_CRWA_INSIDE_CONSOLIDATED) {
		R15_CRWA_INSIDE_CONSOLIDATED = r15_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR15_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R15_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR15_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r15_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R15_EXPOSURE_OUTSIDE_CONSOLIDATED = r15_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR15_CRWA_OUTSIDE_CONSOLIDATED() {
		return R15_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR15_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r15_CRWA_OUTSIDE_CONSOLIDATED) {
		R15_CRWA_OUTSIDE_CONSOLIDATED = r15_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR15_NON_PERFORMING() {
		return R15_NON_PERFORMING;
	}
	public void setR15_NON_PERFORMING(BigDecimal r15_NON_PERFORMING) {
		R15_NON_PERFORMING = r15_NON_PERFORMING;
	}
	public BigDecimal getR15_SPECIFIC_PROVISION() {
		return R15_SPECIFIC_PROVISION;
	}
	public void setR15_SPECIFIC_PROVISION(BigDecimal r15_SPECIFIC_PROVISION) {
		R15_SPECIFIC_PROVISION = r15_SPECIFIC_PROVISION;
	}
	public BigDecimal getR15_INTEREST() {
		return R15_INTEREST;
	}
	public void setR15_INTEREST(BigDecimal r15_INTEREST) {
		R15_INTEREST = r15_INTEREST;
	}
	public BigDecimal getR15_DEFAULTED() {
		return R15_DEFAULTED;
	}
	public void setR15_DEFAULTED(BigDecimal r15_DEFAULTED) {
		R15_DEFAULTED = r15_DEFAULTED;
	}
	public String getR16_S_NO() {
		return R16_S_NO;
	}
	public void setR16_S_NO(String r16_S_NO) {
		R16_S_NO = r16_S_NO;
	}
	public String getR16_AMOUNT() {
		return R16_AMOUNT;
	}
	public void setR16_AMOUNT(String r16_AMOUNT) {
		R16_AMOUNT = r16_AMOUNT;
	}
	public BigDecimal getR16_TOTAL_CONSOLIDATED() {
		return R16_TOTAL_CONSOLIDATED;
	}
	public void setR16_TOTAL_CONSOLIDATED(BigDecimal r16_TOTAL_CONSOLIDATED) {
		R16_TOTAL_CONSOLIDATED = r16_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR16_CRWA_CONSOLIDATED() {
		return R16_CRWA_CONSOLIDATED;
	}
	public void setR16_CRWA_CONSOLIDATED(BigDecimal r16_CRWA_CONSOLIDATED) {
		R16_CRWA_CONSOLIDATED = r16_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR16_EXPOSURE_RESIDENT_UAE() {
		return R16_EXPOSURE_RESIDENT_UAE;
	}
	public void setR16_EXPOSURE_RESIDENT_UAE(BigDecimal r16_EXPOSURE_RESIDENT_UAE) {
		R16_EXPOSURE_RESIDENT_UAE = r16_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR16_CRWA_RESIDENT_UAE() {
		return R16_CRWA_RESIDENT_UAE;
	}
	public void setR16_CRWA_RESIDENT_UAE(BigDecimal r16_CRWA_RESIDENT_UAE) {
		R16_CRWA_RESIDENT_UAE = r16_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR16_EXPOSURE_NON_RESIDENT_UAE() {
		return R16_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR16_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r16_EXPOSURE_NON_RESIDENT_UAE) {
		R16_EXPOSURE_NON_RESIDENT_UAE = r16_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR16_CRWA_NON_RESIDENT_UAE() {
		return R16_CRWA_NON_RESIDENT_UAE;
	}
	public void setR16_CRWA_NON_RESIDENT_UAE(BigDecimal r16_CRWA_NON_RESIDENT_UAE) {
		R16_CRWA_NON_RESIDENT_UAE = r16_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR16_EXPOSURE_RESIDENT_NON_UAE() {
		return R16_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR16_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r16_EXPOSURE_RESIDENT_NON_UAE) {
		R16_EXPOSURE_RESIDENT_NON_UAE = r16_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR16_CRWA_RESIDENT_NON_UAE() {
		return R16_CRWA_RESIDENT_NON_UAE;
	}
	public void setR16_CRWA_RESIDENT_NON_UAE(BigDecimal r16_CRWA_RESIDENT_NON_UAE) {
		R16_CRWA_RESIDENT_NON_UAE = r16_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR16_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R16_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR16_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r16_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R16_EXPOSURE_NON_RESIDENT_NON_UAE = r16_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR16_CRWA_NON_RESIDENT_NON_UAE() {
		return R16_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR16_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r16_CRWA_NON_RESIDENT_NON_UAE) {
		R16_CRWA_NON_RESIDENT_NON_UAE = r16_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR16_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R16_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR16_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r16_EXPOSURE_INSIDE_CONSOLIDATED) {
		R16_EXPOSURE_INSIDE_CONSOLIDATED = r16_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR16_CRWA_INSIDE_CONSOLIDATED() {
		return R16_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR16_CRWA_INSIDE_CONSOLIDATED(BigDecimal r16_CRWA_INSIDE_CONSOLIDATED) {
		R16_CRWA_INSIDE_CONSOLIDATED = r16_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR16_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R16_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR16_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r16_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R16_EXPOSURE_OUTSIDE_CONSOLIDATED = r16_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR16_CRWA_OUTSIDE_CONSOLIDATED() {
		return R16_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR16_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r16_CRWA_OUTSIDE_CONSOLIDATED) {
		R16_CRWA_OUTSIDE_CONSOLIDATED = r16_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR16_NON_PERFORMING() {
		return R16_NON_PERFORMING;
	}
	public void setR16_NON_PERFORMING(BigDecimal r16_NON_PERFORMING) {
		R16_NON_PERFORMING = r16_NON_PERFORMING;
	}
	public BigDecimal getR16_SPECIFIC_PROVISION() {
		return R16_SPECIFIC_PROVISION;
	}
	public void setR16_SPECIFIC_PROVISION(BigDecimal r16_SPECIFIC_PROVISION) {
		R16_SPECIFIC_PROVISION = r16_SPECIFIC_PROVISION;
	}
	public BigDecimal getR16_INTEREST() {
		return R16_INTEREST;
	}
	public void setR16_INTEREST(BigDecimal r16_INTEREST) {
		R16_INTEREST = r16_INTEREST;
	}
	public BigDecimal getR16_DEFAULTED() {
		return R16_DEFAULTED;
	}
	public void setR16_DEFAULTED(BigDecimal r16_DEFAULTED) {
		R16_DEFAULTED = r16_DEFAULTED;
	}
	public String getR17_S_NO() {
		return R17_S_NO;
	}
	public void setR17_S_NO(String r17_S_NO) {
		R17_S_NO = r17_S_NO;
	}
	public String getR17_AMOUNT() {
		return R17_AMOUNT;
	}
	public void setR17_AMOUNT(String r17_AMOUNT) {
		R17_AMOUNT = r17_AMOUNT;
	}
	public BigDecimal getR17_TOTAL_CONSOLIDATED() {
		return R17_TOTAL_CONSOLIDATED;
	}
	public void setR17_TOTAL_CONSOLIDATED(BigDecimal r17_TOTAL_CONSOLIDATED) {
		R17_TOTAL_CONSOLIDATED = r17_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR17_CRWA_CONSOLIDATED() {
		return R17_CRWA_CONSOLIDATED;
	}
	public void setR17_CRWA_CONSOLIDATED(BigDecimal r17_CRWA_CONSOLIDATED) {
		R17_CRWA_CONSOLIDATED = r17_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR17_EXPOSURE_RESIDENT_UAE() {
		return R17_EXPOSURE_RESIDENT_UAE;
	}
	public void setR17_EXPOSURE_RESIDENT_UAE(BigDecimal r17_EXPOSURE_RESIDENT_UAE) {
		R17_EXPOSURE_RESIDENT_UAE = r17_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR17_CRWA_RESIDENT_UAE() {
		return R17_CRWA_RESIDENT_UAE;
	}
	public void setR17_CRWA_RESIDENT_UAE(BigDecimal r17_CRWA_RESIDENT_UAE) {
		R17_CRWA_RESIDENT_UAE = r17_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR17_EXPOSURE_NON_RESIDENT_UAE() {
		return R17_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR17_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r17_EXPOSURE_NON_RESIDENT_UAE) {
		R17_EXPOSURE_NON_RESIDENT_UAE = r17_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR17_CRWA_NON_RESIDENT_UAE() {
		return R17_CRWA_NON_RESIDENT_UAE;
	}
	public void setR17_CRWA_NON_RESIDENT_UAE(BigDecimal r17_CRWA_NON_RESIDENT_UAE) {
		R17_CRWA_NON_RESIDENT_UAE = r17_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR17_EXPOSURE_RESIDENT_NON_UAE() {
		return R17_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR17_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r17_EXPOSURE_RESIDENT_NON_UAE) {
		R17_EXPOSURE_RESIDENT_NON_UAE = r17_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR17_CRWA_RESIDENT_NON_UAE() {
		return R17_CRWA_RESIDENT_NON_UAE;
	}
	public void setR17_CRWA_RESIDENT_NON_UAE(BigDecimal r17_CRWA_RESIDENT_NON_UAE) {
		R17_CRWA_RESIDENT_NON_UAE = r17_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR17_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R17_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR17_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r17_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R17_EXPOSURE_NON_RESIDENT_NON_UAE = r17_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR17_CRWA_NON_RESIDENT_NON_UAE() {
		return R17_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR17_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r17_CRWA_NON_RESIDENT_NON_UAE) {
		R17_CRWA_NON_RESIDENT_NON_UAE = r17_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR17_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R17_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR17_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r17_EXPOSURE_INSIDE_CONSOLIDATED) {
		R17_EXPOSURE_INSIDE_CONSOLIDATED = r17_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR17_CRWA_INSIDE_CONSOLIDATED() {
		return R17_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR17_CRWA_INSIDE_CONSOLIDATED(BigDecimal r17_CRWA_INSIDE_CONSOLIDATED) {
		R17_CRWA_INSIDE_CONSOLIDATED = r17_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR17_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R17_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR17_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r17_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R17_EXPOSURE_OUTSIDE_CONSOLIDATED = r17_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR17_CRWA_OUTSIDE_CONSOLIDATED() {
		return R17_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR17_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r17_CRWA_OUTSIDE_CONSOLIDATED) {
		R17_CRWA_OUTSIDE_CONSOLIDATED = r17_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR17_NON_PERFORMING() {
		return R17_NON_PERFORMING;
	}
	public void setR17_NON_PERFORMING(BigDecimal r17_NON_PERFORMING) {
		R17_NON_PERFORMING = r17_NON_PERFORMING;
	}
	public BigDecimal getR17_SPECIFIC_PROVISION() {
		return R17_SPECIFIC_PROVISION;
	}
	public void setR17_SPECIFIC_PROVISION(BigDecimal r17_SPECIFIC_PROVISION) {
		R17_SPECIFIC_PROVISION = r17_SPECIFIC_PROVISION;
	}
	public BigDecimal getR17_INTEREST() {
		return R17_INTEREST;
	}
	public void setR17_INTEREST(BigDecimal r17_INTEREST) {
		R17_INTEREST = r17_INTEREST;
	}
	public BigDecimal getR17_DEFAULTED() {
		return R17_DEFAULTED;
	}
	public void setR17_DEFAULTED(BigDecimal r17_DEFAULTED) {
		R17_DEFAULTED = r17_DEFAULTED;
	}
	public String getR18_S_NO() {
		return R18_S_NO;
	}
	public void setR18_S_NO(String r18_S_NO) {
		R18_S_NO = r18_S_NO;
	}
	public String getR18_AMOUNT() {
		return R18_AMOUNT;
	}
	public void setR18_AMOUNT(String r18_AMOUNT) {
		R18_AMOUNT = r18_AMOUNT;
	}
	public BigDecimal getR18_TOTAL_CONSOLIDATED() {
		return R18_TOTAL_CONSOLIDATED;
	}
	public void setR18_TOTAL_CONSOLIDATED(BigDecimal r18_TOTAL_CONSOLIDATED) {
		R18_TOTAL_CONSOLIDATED = r18_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR18_CRWA_CONSOLIDATED() {
		return R18_CRWA_CONSOLIDATED;
	}
	public void setR18_CRWA_CONSOLIDATED(BigDecimal r18_CRWA_CONSOLIDATED) {
		R18_CRWA_CONSOLIDATED = r18_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR18_EXPOSURE_RESIDENT_UAE() {
		return R18_EXPOSURE_RESIDENT_UAE;
	}
	public void setR18_EXPOSURE_RESIDENT_UAE(BigDecimal r18_EXPOSURE_RESIDENT_UAE) {
		R18_EXPOSURE_RESIDENT_UAE = r18_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR18_CRWA_RESIDENT_UAE() {
		return R18_CRWA_RESIDENT_UAE;
	}
	public void setR18_CRWA_RESIDENT_UAE(BigDecimal r18_CRWA_RESIDENT_UAE) {
		R18_CRWA_RESIDENT_UAE = r18_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR18_EXPOSURE_NON_RESIDENT_UAE() {
		return R18_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR18_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r18_EXPOSURE_NON_RESIDENT_UAE) {
		R18_EXPOSURE_NON_RESIDENT_UAE = r18_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR18_CRWA_NON_RESIDENT_UAE() {
		return R18_CRWA_NON_RESIDENT_UAE;
	}
	public void setR18_CRWA_NON_RESIDENT_UAE(BigDecimal r18_CRWA_NON_RESIDENT_UAE) {
		R18_CRWA_NON_RESIDENT_UAE = r18_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR18_EXPOSURE_RESIDENT_NON_UAE() {
		return R18_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR18_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r18_EXPOSURE_RESIDENT_NON_UAE) {
		R18_EXPOSURE_RESIDENT_NON_UAE = r18_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR18_CRWA_RESIDENT_NON_UAE() {
		return R18_CRWA_RESIDENT_NON_UAE;
	}
	public void setR18_CRWA_RESIDENT_NON_UAE(BigDecimal r18_CRWA_RESIDENT_NON_UAE) {
		R18_CRWA_RESIDENT_NON_UAE = r18_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR18_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R18_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR18_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r18_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R18_EXPOSURE_NON_RESIDENT_NON_UAE = r18_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR18_CRWA_NON_RESIDENT_NON_UAE() {
		return R18_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR18_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r18_CRWA_NON_RESIDENT_NON_UAE) {
		R18_CRWA_NON_RESIDENT_NON_UAE = r18_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR18_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R18_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR18_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r18_EXPOSURE_INSIDE_CONSOLIDATED) {
		R18_EXPOSURE_INSIDE_CONSOLIDATED = r18_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR18_CRWA_INSIDE_CONSOLIDATED() {
		return R18_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR18_CRWA_INSIDE_CONSOLIDATED(BigDecimal r18_CRWA_INSIDE_CONSOLIDATED) {
		R18_CRWA_INSIDE_CONSOLIDATED = r18_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR18_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R18_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR18_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r18_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R18_EXPOSURE_OUTSIDE_CONSOLIDATED = r18_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR18_CRWA_OUTSIDE_CONSOLIDATED() {
		return R18_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR18_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r18_CRWA_OUTSIDE_CONSOLIDATED) {
		R18_CRWA_OUTSIDE_CONSOLIDATED = r18_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR18_NON_PERFORMING() {
		return R18_NON_PERFORMING;
	}
	public void setR18_NON_PERFORMING(BigDecimal r18_NON_PERFORMING) {
		R18_NON_PERFORMING = r18_NON_PERFORMING;
	}
	public BigDecimal getR18_SPECIFIC_PROVISION() {
		return R18_SPECIFIC_PROVISION;
	}
	public void setR18_SPECIFIC_PROVISION(BigDecimal r18_SPECIFIC_PROVISION) {
		R18_SPECIFIC_PROVISION = r18_SPECIFIC_PROVISION;
	}
	public BigDecimal getR18_INTEREST() {
		return R18_INTEREST;
	}
	public void setR18_INTEREST(BigDecimal r18_INTEREST) {
		R18_INTEREST = r18_INTEREST;
	}
	public BigDecimal getR18_DEFAULTED() {
		return R18_DEFAULTED;
	}
	public void setR18_DEFAULTED(BigDecimal r18_DEFAULTED) {
		R18_DEFAULTED = r18_DEFAULTED;
	}
	public String getR19_S_NO() {
		return R19_S_NO;
	}
	public void setR19_S_NO(String r19_S_NO) {
		R19_S_NO = r19_S_NO;
	}
	public String getR19_AMOUNT() {
		return R19_AMOUNT;
	}
	public void setR19_AMOUNT(String r19_AMOUNT) {
		R19_AMOUNT = r19_AMOUNT;
	}
	public BigDecimal getR19_TOTAL_CONSOLIDATED() {
		return R19_TOTAL_CONSOLIDATED;
	}
	public void setR19_TOTAL_CONSOLIDATED(BigDecimal r19_TOTAL_CONSOLIDATED) {
		R19_TOTAL_CONSOLIDATED = r19_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR19_CRWA_CONSOLIDATED() {
		return R19_CRWA_CONSOLIDATED;
	}
	public void setR19_CRWA_CONSOLIDATED(BigDecimal r19_CRWA_CONSOLIDATED) {
		R19_CRWA_CONSOLIDATED = r19_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR19_EXPOSURE_RESIDENT_UAE() {
		return R19_EXPOSURE_RESIDENT_UAE;
	}
	public void setR19_EXPOSURE_RESIDENT_UAE(BigDecimal r19_EXPOSURE_RESIDENT_UAE) {
		R19_EXPOSURE_RESIDENT_UAE = r19_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR19_CRWA_RESIDENT_UAE() {
		return R19_CRWA_RESIDENT_UAE;
	}
	public void setR19_CRWA_RESIDENT_UAE(BigDecimal r19_CRWA_RESIDENT_UAE) {
		R19_CRWA_RESIDENT_UAE = r19_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR19_EXPOSURE_NON_RESIDENT_UAE() {
		return R19_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR19_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r19_EXPOSURE_NON_RESIDENT_UAE) {
		R19_EXPOSURE_NON_RESIDENT_UAE = r19_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR19_CRWA_NON_RESIDENT_UAE() {
		return R19_CRWA_NON_RESIDENT_UAE;
	}
	public void setR19_CRWA_NON_RESIDENT_UAE(BigDecimal r19_CRWA_NON_RESIDENT_UAE) {
		R19_CRWA_NON_RESIDENT_UAE = r19_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR19_EXPOSURE_RESIDENT_NON_UAE() {
		return R19_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR19_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r19_EXPOSURE_RESIDENT_NON_UAE) {
		R19_EXPOSURE_RESIDENT_NON_UAE = r19_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR19_CRWA_RESIDENT_NON_UAE() {
		return R19_CRWA_RESIDENT_NON_UAE;
	}
	public void setR19_CRWA_RESIDENT_NON_UAE(BigDecimal r19_CRWA_RESIDENT_NON_UAE) {
		R19_CRWA_RESIDENT_NON_UAE = r19_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR19_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R19_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR19_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r19_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R19_EXPOSURE_NON_RESIDENT_NON_UAE = r19_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR19_CRWA_NON_RESIDENT_NON_UAE() {
		return R19_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR19_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r19_CRWA_NON_RESIDENT_NON_UAE) {
		R19_CRWA_NON_RESIDENT_NON_UAE = r19_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR19_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R19_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR19_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r19_EXPOSURE_INSIDE_CONSOLIDATED) {
		R19_EXPOSURE_INSIDE_CONSOLIDATED = r19_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR19_CRWA_INSIDE_CONSOLIDATED() {
		return R19_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR19_CRWA_INSIDE_CONSOLIDATED(BigDecimal r19_CRWA_INSIDE_CONSOLIDATED) {
		R19_CRWA_INSIDE_CONSOLIDATED = r19_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR19_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R19_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR19_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r19_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R19_EXPOSURE_OUTSIDE_CONSOLIDATED = r19_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR19_CRWA_OUTSIDE_CONSOLIDATED() {
		return R19_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR19_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r19_CRWA_OUTSIDE_CONSOLIDATED) {
		R19_CRWA_OUTSIDE_CONSOLIDATED = r19_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR19_NON_PERFORMING() {
		return R19_NON_PERFORMING;
	}
	public void setR19_NON_PERFORMING(BigDecimal r19_NON_PERFORMING) {
		R19_NON_PERFORMING = r19_NON_PERFORMING;
	}
	public BigDecimal getR19_SPECIFIC_PROVISION() {
		return R19_SPECIFIC_PROVISION;
	}
	public void setR19_SPECIFIC_PROVISION(BigDecimal r19_SPECIFIC_PROVISION) {
		R19_SPECIFIC_PROVISION = r19_SPECIFIC_PROVISION;
	}
	public BigDecimal getR19_INTEREST() {
		return R19_INTEREST;
	}
	public void setR19_INTEREST(BigDecimal r19_INTEREST) {
		R19_INTEREST = r19_INTEREST;
	}
	public BigDecimal getR19_DEFAULTED() {
		return R19_DEFAULTED;
	}
	public void setR19_DEFAULTED(BigDecimal r19_DEFAULTED) {
		R19_DEFAULTED = r19_DEFAULTED;
	}
	public String getR20_S_NO() {
		return R20_S_NO;
	}
	public void setR20_S_NO(String r20_S_NO) {
		R20_S_NO = r20_S_NO;
	}
	public String getR20_AMOUNT() {
		return R20_AMOUNT;
	}
	public void setR20_AMOUNT(String r20_AMOUNT) {
		R20_AMOUNT = r20_AMOUNT;
	}
	public BigDecimal getR20_TOTAL_CONSOLIDATED() {
		return R20_TOTAL_CONSOLIDATED;
	}
	public void setR20_TOTAL_CONSOLIDATED(BigDecimal r20_TOTAL_CONSOLIDATED) {
		R20_TOTAL_CONSOLIDATED = r20_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR20_CRWA_CONSOLIDATED() {
		return R20_CRWA_CONSOLIDATED;
	}
	public void setR20_CRWA_CONSOLIDATED(BigDecimal r20_CRWA_CONSOLIDATED) {
		R20_CRWA_CONSOLIDATED = r20_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR20_EXPOSURE_RESIDENT_UAE() {
		return R20_EXPOSURE_RESIDENT_UAE;
	}
	public void setR20_EXPOSURE_RESIDENT_UAE(BigDecimal r20_EXPOSURE_RESIDENT_UAE) {
		R20_EXPOSURE_RESIDENT_UAE = r20_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR20_CRWA_RESIDENT_UAE() {
		return R20_CRWA_RESIDENT_UAE;
	}
	public void setR20_CRWA_RESIDENT_UAE(BigDecimal r20_CRWA_RESIDENT_UAE) {
		R20_CRWA_RESIDENT_UAE = r20_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR20_EXPOSURE_NON_RESIDENT_UAE() {
		return R20_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR20_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r20_EXPOSURE_NON_RESIDENT_UAE) {
		R20_EXPOSURE_NON_RESIDENT_UAE = r20_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR20_CRWA_NON_RESIDENT_UAE() {
		return R20_CRWA_NON_RESIDENT_UAE;
	}
	public void setR20_CRWA_NON_RESIDENT_UAE(BigDecimal r20_CRWA_NON_RESIDENT_UAE) {
		R20_CRWA_NON_RESIDENT_UAE = r20_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR20_EXPOSURE_RESIDENT_NON_UAE() {
		return R20_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR20_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r20_EXPOSURE_RESIDENT_NON_UAE) {
		R20_EXPOSURE_RESIDENT_NON_UAE = r20_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR20_CRWA_RESIDENT_NON_UAE() {
		return R20_CRWA_RESIDENT_NON_UAE;
	}
	public void setR20_CRWA_RESIDENT_NON_UAE(BigDecimal r20_CRWA_RESIDENT_NON_UAE) {
		R20_CRWA_RESIDENT_NON_UAE = r20_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR20_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R20_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR20_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r20_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R20_EXPOSURE_NON_RESIDENT_NON_UAE = r20_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR20_CRWA_NON_RESIDENT_NON_UAE() {
		return R20_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR20_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r20_CRWA_NON_RESIDENT_NON_UAE) {
		R20_CRWA_NON_RESIDENT_NON_UAE = r20_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR20_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R20_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR20_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r20_EXPOSURE_INSIDE_CONSOLIDATED) {
		R20_EXPOSURE_INSIDE_CONSOLIDATED = r20_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR20_CRWA_INSIDE_CONSOLIDATED() {
		return R20_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR20_CRWA_INSIDE_CONSOLIDATED(BigDecimal r20_CRWA_INSIDE_CONSOLIDATED) {
		R20_CRWA_INSIDE_CONSOLIDATED = r20_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR20_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R20_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR20_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r20_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R20_EXPOSURE_OUTSIDE_CONSOLIDATED = r20_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR20_CRWA_OUTSIDE_CONSOLIDATED() {
		return R20_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR20_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r20_CRWA_OUTSIDE_CONSOLIDATED) {
		R20_CRWA_OUTSIDE_CONSOLIDATED = r20_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR20_NON_PERFORMING() {
		return R20_NON_PERFORMING;
	}
	public void setR20_NON_PERFORMING(BigDecimal r20_NON_PERFORMING) {
		R20_NON_PERFORMING = r20_NON_PERFORMING;
	}
	public BigDecimal getR20_SPECIFIC_PROVISION() {
		return R20_SPECIFIC_PROVISION;
	}
	public void setR20_SPECIFIC_PROVISION(BigDecimal r20_SPECIFIC_PROVISION) {
		R20_SPECIFIC_PROVISION = r20_SPECIFIC_PROVISION;
	}
	public BigDecimal getR20_INTEREST() {
		return R20_INTEREST;
	}
	public void setR20_INTEREST(BigDecimal r20_INTEREST) {
		R20_INTEREST = r20_INTEREST;
	}
	public BigDecimal getR20_DEFAULTED() {
		return R20_DEFAULTED;
	}
	public void setR20_DEFAULTED(BigDecimal r20_DEFAULTED) {
		R20_DEFAULTED = r20_DEFAULTED;
	}
	public String getR21_S_NO() {
		return R21_S_NO;
	}
	public void setR21_S_NO(String r21_S_NO) {
		R21_S_NO = r21_S_NO;
	}
	public String getR21_AMOUNT() {
		return R21_AMOUNT;
	}
	public void setR21_AMOUNT(String r21_AMOUNT) {
		R21_AMOUNT = r21_AMOUNT;
	}
	public BigDecimal getR21_TOTAL_CONSOLIDATED() {
		return R21_TOTAL_CONSOLIDATED;
	}
	public void setR21_TOTAL_CONSOLIDATED(BigDecimal r21_TOTAL_CONSOLIDATED) {
		R21_TOTAL_CONSOLIDATED = r21_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR21_CRWA_CONSOLIDATED() {
		return R21_CRWA_CONSOLIDATED;
	}
	public void setR21_CRWA_CONSOLIDATED(BigDecimal r21_CRWA_CONSOLIDATED) {
		R21_CRWA_CONSOLIDATED = r21_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR21_EXPOSURE_RESIDENT_UAE() {
		return R21_EXPOSURE_RESIDENT_UAE;
	}
	public void setR21_EXPOSURE_RESIDENT_UAE(BigDecimal r21_EXPOSURE_RESIDENT_UAE) {
		R21_EXPOSURE_RESIDENT_UAE = r21_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR21_CRWA_RESIDENT_UAE() {
		return R21_CRWA_RESIDENT_UAE;
	}
	public void setR21_CRWA_RESIDENT_UAE(BigDecimal r21_CRWA_RESIDENT_UAE) {
		R21_CRWA_RESIDENT_UAE = r21_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR21_EXPOSURE_NON_RESIDENT_UAE() {
		return R21_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR21_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r21_EXPOSURE_NON_RESIDENT_UAE) {
		R21_EXPOSURE_NON_RESIDENT_UAE = r21_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR21_CRWA_NON_RESIDENT_UAE() {
		return R21_CRWA_NON_RESIDENT_UAE;
	}
	public void setR21_CRWA_NON_RESIDENT_UAE(BigDecimal r21_CRWA_NON_RESIDENT_UAE) {
		R21_CRWA_NON_RESIDENT_UAE = r21_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR21_EXPOSURE_RESIDENT_NON_UAE() {
		return R21_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR21_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r21_EXPOSURE_RESIDENT_NON_UAE) {
		R21_EXPOSURE_RESIDENT_NON_UAE = r21_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR21_CRWA_RESIDENT_NON_UAE() {
		return R21_CRWA_RESIDENT_NON_UAE;
	}
	public void setR21_CRWA_RESIDENT_NON_UAE(BigDecimal r21_CRWA_RESIDENT_NON_UAE) {
		R21_CRWA_RESIDENT_NON_UAE = r21_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR21_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R21_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR21_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r21_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R21_EXPOSURE_NON_RESIDENT_NON_UAE = r21_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR21_CRWA_NON_RESIDENT_NON_UAE() {
		return R21_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR21_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r21_CRWA_NON_RESIDENT_NON_UAE) {
		R21_CRWA_NON_RESIDENT_NON_UAE = r21_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR21_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R21_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR21_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r21_EXPOSURE_INSIDE_CONSOLIDATED) {
		R21_EXPOSURE_INSIDE_CONSOLIDATED = r21_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR21_CRWA_INSIDE_CONSOLIDATED() {
		return R21_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR21_CRWA_INSIDE_CONSOLIDATED(BigDecimal r21_CRWA_INSIDE_CONSOLIDATED) {
		R21_CRWA_INSIDE_CONSOLIDATED = r21_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR21_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R21_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR21_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r21_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R21_EXPOSURE_OUTSIDE_CONSOLIDATED = r21_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR21_CRWA_OUTSIDE_CONSOLIDATED() {
		return R21_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR21_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r21_CRWA_OUTSIDE_CONSOLIDATED) {
		R21_CRWA_OUTSIDE_CONSOLIDATED = r21_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR21_NON_PERFORMING() {
		return R21_NON_PERFORMING;
	}
	public void setR21_NON_PERFORMING(BigDecimal r21_NON_PERFORMING) {
		R21_NON_PERFORMING = r21_NON_PERFORMING;
	}
	public BigDecimal getR21_SPECIFIC_PROVISION() {
		return R21_SPECIFIC_PROVISION;
	}
	public void setR21_SPECIFIC_PROVISION(BigDecimal r21_SPECIFIC_PROVISION) {
		R21_SPECIFIC_PROVISION = r21_SPECIFIC_PROVISION;
	}
	public BigDecimal getR21_INTEREST() {
		return R21_INTEREST;
	}
	public void setR21_INTEREST(BigDecimal r21_INTEREST) {
		R21_INTEREST = r21_INTEREST;
	}
	public BigDecimal getR21_DEFAULTED() {
		return R21_DEFAULTED;
	}
	public void setR21_DEFAULTED(BigDecimal r21_DEFAULTED) {
		R21_DEFAULTED = r21_DEFAULTED;
	}
	public String getR22_S_NO() {
		return R22_S_NO;
	}
	public void setR22_S_NO(String r22_S_NO) {
		R22_S_NO = r22_S_NO;
	}
	public String getR22_AMOUNT() {
		return R22_AMOUNT;
	}
	public void setR22_AMOUNT(String r22_AMOUNT) {
		R22_AMOUNT = r22_AMOUNT;
	}
	public BigDecimal getR22_TOTAL_CONSOLIDATED() {
		return R22_TOTAL_CONSOLIDATED;
	}
	public void setR22_TOTAL_CONSOLIDATED(BigDecimal r22_TOTAL_CONSOLIDATED) {
		R22_TOTAL_CONSOLIDATED = r22_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR22_CRWA_CONSOLIDATED() {
		return R22_CRWA_CONSOLIDATED;
	}
	public void setR22_CRWA_CONSOLIDATED(BigDecimal r22_CRWA_CONSOLIDATED) {
		R22_CRWA_CONSOLIDATED = r22_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR22_EXPOSURE_RESIDENT_UAE() {
		return R22_EXPOSURE_RESIDENT_UAE;
	}
	public void setR22_EXPOSURE_RESIDENT_UAE(BigDecimal r22_EXPOSURE_RESIDENT_UAE) {
		R22_EXPOSURE_RESIDENT_UAE = r22_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR22_CRWA_RESIDENT_UAE() {
		return R22_CRWA_RESIDENT_UAE;
	}
	public void setR22_CRWA_RESIDENT_UAE(BigDecimal r22_CRWA_RESIDENT_UAE) {
		R22_CRWA_RESIDENT_UAE = r22_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR22_EXPOSURE_NON_RESIDENT_UAE() {
		return R22_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR22_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r22_EXPOSURE_NON_RESIDENT_UAE) {
		R22_EXPOSURE_NON_RESIDENT_UAE = r22_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR22_CRWA_NON_RESIDENT_UAE() {
		return R22_CRWA_NON_RESIDENT_UAE;
	}
	public void setR22_CRWA_NON_RESIDENT_UAE(BigDecimal r22_CRWA_NON_RESIDENT_UAE) {
		R22_CRWA_NON_RESIDENT_UAE = r22_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR22_EXPOSURE_RESIDENT_NON_UAE() {
		return R22_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR22_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r22_EXPOSURE_RESIDENT_NON_UAE) {
		R22_EXPOSURE_RESIDENT_NON_UAE = r22_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR22_CRWA_RESIDENT_NON_UAE() {
		return R22_CRWA_RESIDENT_NON_UAE;
	}
	public void setR22_CRWA_RESIDENT_NON_UAE(BigDecimal r22_CRWA_RESIDENT_NON_UAE) {
		R22_CRWA_RESIDENT_NON_UAE = r22_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR22_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R22_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR22_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r22_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R22_EXPOSURE_NON_RESIDENT_NON_UAE = r22_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR22_CRWA_NON_RESIDENT_NON_UAE() {
		return R22_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR22_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r22_CRWA_NON_RESIDENT_NON_UAE) {
		R22_CRWA_NON_RESIDENT_NON_UAE = r22_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR22_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R22_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR22_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r22_EXPOSURE_INSIDE_CONSOLIDATED) {
		R22_EXPOSURE_INSIDE_CONSOLIDATED = r22_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR22_CRWA_INSIDE_CONSOLIDATED() {
		return R22_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR22_CRWA_INSIDE_CONSOLIDATED(BigDecimal r22_CRWA_INSIDE_CONSOLIDATED) {
		R22_CRWA_INSIDE_CONSOLIDATED = r22_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR22_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R22_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR22_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r22_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R22_EXPOSURE_OUTSIDE_CONSOLIDATED = r22_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR22_CRWA_OUTSIDE_CONSOLIDATED() {
		return R22_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR22_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r22_CRWA_OUTSIDE_CONSOLIDATED) {
		R22_CRWA_OUTSIDE_CONSOLIDATED = r22_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR22_NON_PERFORMING() {
		return R22_NON_PERFORMING;
	}
	public void setR22_NON_PERFORMING(BigDecimal r22_NON_PERFORMING) {
		R22_NON_PERFORMING = r22_NON_PERFORMING;
	}
	public BigDecimal getR22_SPECIFIC_PROVISION() {
		return R22_SPECIFIC_PROVISION;
	}
	public void setR22_SPECIFIC_PROVISION(BigDecimal r22_SPECIFIC_PROVISION) {
		R22_SPECIFIC_PROVISION = r22_SPECIFIC_PROVISION;
	}
	public BigDecimal getR22_INTEREST() {
		return R22_INTEREST;
	}
	public void setR22_INTEREST(BigDecimal r22_INTEREST) {
		R22_INTEREST = r22_INTEREST;
	}
	public BigDecimal getR22_DEFAULTED() {
		return R22_DEFAULTED;
	}
	public void setR22_DEFAULTED(BigDecimal r22_DEFAULTED) {
		R22_DEFAULTED = r22_DEFAULTED;
	}
	public String getR23_S_NO() {
		return R23_S_NO;
	}
	public void setR23_S_NO(String r23_S_NO) {
		R23_S_NO = r23_S_NO;
	}
	public String getR23_AMOUNT() {
		return R23_AMOUNT;
	}
	public void setR23_AMOUNT(String r23_AMOUNT) {
		R23_AMOUNT = r23_AMOUNT;
	}
	public BigDecimal getR23_TOTAL_CONSOLIDATED() {
		return R23_TOTAL_CONSOLIDATED;
	}
	public void setR23_TOTAL_CONSOLIDATED(BigDecimal r23_TOTAL_CONSOLIDATED) {
		R23_TOTAL_CONSOLIDATED = r23_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR23_CRWA_CONSOLIDATED() {
		return R23_CRWA_CONSOLIDATED;
	}
	public void setR23_CRWA_CONSOLIDATED(BigDecimal r23_CRWA_CONSOLIDATED) {
		R23_CRWA_CONSOLIDATED = r23_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR23_EXPOSURE_RESIDENT_UAE() {
		return R23_EXPOSURE_RESIDENT_UAE;
	}
	public void setR23_EXPOSURE_RESIDENT_UAE(BigDecimal r23_EXPOSURE_RESIDENT_UAE) {
		R23_EXPOSURE_RESIDENT_UAE = r23_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR23_CRWA_RESIDENT_UAE() {
		return R23_CRWA_RESIDENT_UAE;
	}
	public void setR23_CRWA_RESIDENT_UAE(BigDecimal r23_CRWA_RESIDENT_UAE) {
		R23_CRWA_RESIDENT_UAE = r23_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR23_EXPOSURE_NON_RESIDENT_UAE() {
		return R23_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR23_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r23_EXPOSURE_NON_RESIDENT_UAE) {
		R23_EXPOSURE_NON_RESIDENT_UAE = r23_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR23_CRWA_NON_RESIDENT_UAE() {
		return R23_CRWA_NON_RESIDENT_UAE;
	}
	public void setR23_CRWA_NON_RESIDENT_UAE(BigDecimal r23_CRWA_NON_RESIDENT_UAE) {
		R23_CRWA_NON_RESIDENT_UAE = r23_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR23_EXPOSURE_RESIDENT_NON_UAE() {
		return R23_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR23_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r23_EXPOSURE_RESIDENT_NON_UAE) {
		R23_EXPOSURE_RESIDENT_NON_UAE = r23_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR23_CRWA_RESIDENT_NON_UAE() {
		return R23_CRWA_RESIDENT_NON_UAE;
	}
	public void setR23_CRWA_RESIDENT_NON_UAE(BigDecimal r23_CRWA_RESIDENT_NON_UAE) {
		R23_CRWA_RESIDENT_NON_UAE = r23_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR23_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R23_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR23_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r23_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R23_EXPOSURE_NON_RESIDENT_NON_UAE = r23_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR23_CRWA_NON_RESIDENT_NON_UAE() {
		return R23_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR23_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r23_CRWA_NON_RESIDENT_NON_UAE) {
		R23_CRWA_NON_RESIDENT_NON_UAE = r23_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR23_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R23_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR23_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r23_EXPOSURE_INSIDE_CONSOLIDATED) {
		R23_EXPOSURE_INSIDE_CONSOLIDATED = r23_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR23_CRWA_INSIDE_CONSOLIDATED() {
		return R23_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR23_CRWA_INSIDE_CONSOLIDATED(BigDecimal r23_CRWA_INSIDE_CONSOLIDATED) {
		R23_CRWA_INSIDE_CONSOLIDATED = r23_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR23_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R23_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR23_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r23_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R23_EXPOSURE_OUTSIDE_CONSOLIDATED = r23_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR23_CRWA_OUTSIDE_CONSOLIDATED() {
		return R23_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR23_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r23_CRWA_OUTSIDE_CONSOLIDATED) {
		R23_CRWA_OUTSIDE_CONSOLIDATED = r23_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR23_NON_PERFORMING() {
		return R23_NON_PERFORMING;
	}
	public void setR23_NON_PERFORMING(BigDecimal r23_NON_PERFORMING) {
		R23_NON_PERFORMING = r23_NON_PERFORMING;
	}
	public BigDecimal getR23_SPECIFIC_PROVISION() {
		return R23_SPECIFIC_PROVISION;
	}
	public void setR23_SPECIFIC_PROVISION(BigDecimal r23_SPECIFIC_PROVISION) {
		R23_SPECIFIC_PROVISION = r23_SPECIFIC_PROVISION;
	}
	public BigDecimal getR23_INTEREST() {
		return R23_INTEREST;
	}
	public void setR23_INTEREST(BigDecimal r23_INTEREST) {
		R23_INTEREST = r23_INTEREST;
	}
	public BigDecimal getR23_DEFAULTED() {
		return R23_DEFAULTED;
	}
	public void setR23_DEFAULTED(BigDecimal r23_DEFAULTED) {
		R23_DEFAULTED = r23_DEFAULTED;
	}
	public String getR24_S_NO() {
		return R24_S_NO;
	}
	public void setR24_S_NO(String r24_S_NO) {
		R24_S_NO = r24_S_NO;
	}
	public String getR24_AMOUNT() {
		return R24_AMOUNT;
	}
	public void setR24_AMOUNT(String r24_AMOUNT) {
		R24_AMOUNT = r24_AMOUNT;
	}
	public BigDecimal getR24_TOTAL_CONSOLIDATED() {
		return R24_TOTAL_CONSOLIDATED;
	}
	public void setR24_TOTAL_CONSOLIDATED(BigDecimal r24_TOTAL_CONSOLIDATED) {
		R24_TOTAL_CONSOLIDATED = r24_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR24_CRWA_CONSOLIDATED() {
		return R24_CRWA_CONSOLIDATED;
	}
	public void setR24_CRWA_CONSOLIDATED(BigDecimal r24_CRWA_CONSOLIDATED) {
		R24_CRWA_CONSOLIDATED = r24_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR24_EXPOSURE_RESIDENT_UAE() {
		return R24_EXPOSURE_RESIDENT_UAE;
	}
	public void setR24_EXPOSURE_RESIDENT_UAE(BigDecimal r24_EXPOSURE_RESIDENT_UAE) {
		R24_EXPOSURE_RESIDENT_UAE = r24_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR24_CRWA_RESIDENT_UAE() {
		return R24_CRWA_RESIDENT_UAE;
	}
	public void setR24_CRWA_RESIDENT_UAE(BigDecimal r24_CRWA_RESIDENT_UAE) {
		R24_CRWA_RESIDENT_UAE = r24_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR24_EXPOSURE_NON_RESIDENT_UAE() {
		return R24_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR24_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r24_EXPOSURE_NON_RESIDENT_UAE) {
		R24_EXPOSURE_NON_RESIDENT_UAE = r24_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR24_CRWA_NON_RESIDENT_UAE() {
		return R24_CRWA_NON_RESIDENT_UAE;
	}
	public void setR24_CRWA_NON_RESIDENT_UAE(BigDecimal r24_CRWA_NON_RESIDENT_UAE) {
		R24_CRWA_NON_RESIDENT_UAE = r24_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR24_EXPOSURE_RESIDENT_NON_UAE() {
		return R24_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR24_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r24_EXPOSURE_RESIDENT_NON_UAE) {
		R24_EXPOSURE_RESIDENT_NON_UAE = r24_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR24_CRWA_RESIDENT_NON_UAE() {
		return R24_CRWA_RESIDENT_NON_UAE;
	}
	public void setR24_CRWA_RESIDENT_NON_UAE(BigDecimal r24_CRWA_RESIDENT_NON_UAE) {
		R24_CRWA_RESIDENT_NON_UAE = r24_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR24_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R24_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR24_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r24_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R24_EXPOSURE_NON_RESIDENT_NON_UAE = r24_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR24_CRWA_NON_RESIDENT_NON_UAE() {
		return R24_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR24_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r24_CRWA_NON_RESIDENT_NON_UAE) {
		R24_CRWA_NON_RESIDENT_NON_UAE = r24_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR24_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R24_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR24_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r24_EXPOSURE_INSIDE_CONSOLIDATED) {
		R24_EXPOSURE_INSIDE_CONSOLIDATED = r24_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR24_CRWA_INSIDE_CONSOLIDATED() {
		return R24_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR24_CRWA_INSIDE_CONSOLIDATED(BigDecimal r24_CRWA_INSIDE_CONSOLIDATED) {
		R24_CRWA_INSIDE_CONSOLIDATED = r24_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR24_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R24_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR24_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r24_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R24_EXPOSURE_OUTSIDE_CONSOLIDATED = r24_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR24_CRWA_OUTSIDE_CONSOLIDATED() {
		return R24_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR24_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r24_CRWA_OUTSIDE_CONSOLIDATED) {
		R24_CRWA_OUTSIDE_CONSOLIDATED = r24_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR24_NON_PERFORMING() {
		return R24_NON_PERFORMING;
	}
	public void setR24_NON_PERFORMING(BigDecimal r24_NON_PERFORMING) {
		R24_NON_PERFORMING = r24_NON_PERFORMING;
	}
	public BigDecimal getR24_SPECIFIC_PROVISION() {
		return R24_SPECIFIC_PROVISION;
	}
	public void setR24_SPECIFIC_PROVISION(BigDecimal r24_SPECIFIC_PROVISION) {
		R24_SPECIFIC_PROVISION = r24_SPECIFIC_PROVISION;
	}
	public BigDecimal getR24_INTEREST() {
		return R24_INTEREST;
	}
	public void setR24_INTEREST(BigDecimal r24_INTEREST) {
		R24_INTEREST = r24_INTEREST;
	}
	public BigDecimal getR24_DEFAULTED() {
		return R24_DEFAULTED;
	}
	public void setR24_DEFAULTED(BigDecimal r24_DEFAULTED) {
		R24_DEFAULTED = r24_DEFAULTED;
	}
	public String getR25_S_NO() {
		return R25_S_NO;
	}
	public void setR25_S_NO(String r25_S_NO) {
		R25_S_NO = r25_S_NO;
	}
	public String getR25_AMOUNT() {
		return R25_AMOUNT;
	}
	public void setR25_AMOUNT(String r25_AMOUNT) {
		R25_AMOUNT = r25_AMOUNT;
	}
	public BigDecimal getR25_TOTAL_CONSOLIDATED() {
		return R25_TOTAL_CONSOLIDATED;
	}
	public void setR25_TOTAL_CONSOLIDATED(BigDecimal r25_TOTAL_CONSOLIDATED) {
		R25_TOTAL_CONSOLIDATED = r25_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR25_CRWA_CONSOLIDATED() {
		return R25_CRWA_CONSOLIDATED;
	}
	public void setR25_CRWA_CONSOLIDATED(BigDecimal r25_CRWA_CONSOLIDATED) {
		R25_CRWA_CONSOLIDATED = r25_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR25_EXPOSURE_RESIDENT_UAE() {
		return R25_EXPOSURE_RESIDENT_UAE;
	}
	public void setR25_EXPOSURE_RESIDENT_UAE(BigDecimal r25_EXPOSURE_RESIDENT_UAE) {
		R25_EXPOSURE_RESIDENT_UAE = r25_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR25_CRWA_RESIDENT_UAE() {
		return R25_CRWA_RESIDENT_UAE;
	}
	public void setR25_CRWA_RESIDENT_UAE(BigDecimal r25_CRWA_RESIDENT_UAE) {
		R25_CRWA_RESIDENT_UAE = r25_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR25_EXPOSURE_NON_RESIDENT_UAE() {
		return R25_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR25_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r25_EXPOSURE_NON_RESIDENT_UAE) {
		R25_EXPOSURE_NON_RESIDENT_UAE = r25_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR25_CRWA_NON_RESIDENT_UAE() {
		return R25_CRWA_NON_RESIDENT_UAE;
	}
	public void setR25_CRWA_NON_RESIDENT_UAE(BigDecimal r25_CRWA_NON_RESIDENT_UAE) {
		R25_CRWA_NON_RESIDENT_UAE = r25_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR25_EXPOSURE_RESIDENT_NON_UAE() {
		return R25_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR25_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r25_EXPOSURE_RESIDENT_NON_UAE) {
		R25_EXPOSURE_RESIDENT_NON_UAE = r25_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR25_CRWA_RESIDENT_NON_UAE() {
		return R25_CRWA_RESIDENT_NON_UAE;
	}
	public void setR25_CRWA_RESIDENT_NON_UAE(BigDecimal r25_CRWA_RESIDENT_NON_UAE) {
		R25_CRWA_RESIDENT_NON_UAE = r25_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR25_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R25_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR25_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r25_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R25_EXPOSURE_NON_RESIDENT_NON_UAE = r25_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR25_CRWA_NON_RESIDENT_NON_UAE() {
		return R25_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR25_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r25_CRWA_NON_RESIDENT_NON_UAE) {
		R25_CRWA_NON_RESIDENT_NON_UAE = r25_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR25_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R25_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR25_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r25_EXPOSURE_INSIDE_CONSOLIDATED) {
		R25_EXPOSURE_INSIDE_CONSOLIDATED = r25_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR25_CRWA_INSIDE_CONSOLIDATED() {
		return R25_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR25_CRWA_INSIDE_CONSOLIDATED(BigDecimal r25_CRWA_INSIDE_CONSOLIDATED) {
		R25_CRWA_INSIDE_CONSOLIDATED = r25_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR25_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R25_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR25_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r25_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R25_EXPOSURE_OUTSIDE_CONSOLIDATED = r25_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR25_CRWA_OUTSIDE_CONSOLIDATED() {
		return R25_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR25_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r25_CRWA_OUTSIDE_CONSOLIDATED) {
		R25_CRWA_OUTSIDE_CONSOLIDATED = r25_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR25_NON_PERFORMING() {
		return R25_NON_PERFORMING;
	}
	public void setR25_NON_PERFORMING(BigDecimal r25_NON_PERFORMING) {
		R25_NON_PERFORMING = r25_NON_PERFORMING;
	}
	public BigDecimal getR25_SPECIFIC_PROVISION() {
		return R25_SPECIFIC_PROVISION;
	}
	public void setR25_SPECIFIC_PROVISION(BigDecimal r25_SPECIFIC_PROVISION) {
		R25_SPECIFIC_PROVISION = r25_SPECIFIC_PROVISION;
	}
	public BigDecimal getR25_INTEREST() {
		return R25_INTEREST;
	}
	public void setR25_INTEREST(BigDecimal r25_INTEREST) {
		R25_INTEREST = r25_INTEREST;
	}
	public BigDecimal getR25_DEFAULTED() {
		return R25_DEFAULTED;
	}
	public void setR25_DEFAULTED(BigDecimal r25_DEFAULTED) {
		R25_DEFAULTED = r25_DEFAULTED;
	}
	public String getR26_S_NO() {
		return R26_S_NO;
	}
	public void setR26_S_NO(String r26_S_NO) {
		R26_S_NO = r26_S_NO;
	}
	public String getR26_AMOUNT() {
		return R26_AMOUNT;
	}
	public void setR26_AMOUNT(String r26_AMOUNT) {
		R26_AMOUNT = r26_AMOUNT;
	}
	public BigDecimal getR26_TOTAL_CONSOLIDATED() {
		return R26_TOTAL_CONSOLIDATED;
	}
	public void setR26_TOTAL_CONSOLIDATED(BigDecimal r26_TOTAL_CONSOLIDATED) {
		R26_TOTAL_CONSOLIDATED = r26_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR26_CRWA_CONSOLIDATED() {
		return R26_CRWA_CONSOLIDATED;
	}
	public void setR26_CRWA_CONSOLIDATED(BigDecimal r26_CRWA_CONSOLIDATED) {
		R26_CRWA_CONSOLIDATED = r26_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR26_EXPOSURE_RESIDENT_UAE() {
		return R26_EXPOSURE_RESIDENT_UAE;
	}
	public void setR26_EXPOSURE_RESIDENT_UAE(BigDecimal r26_EXPOSURE_RESIDENT_UAE) {
		R26_EXPOSURE_RESIDENT_UAE = r26_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR26_CRWA_RESIDENT_UAE() {
		return R26_CRWA_RESIDENT_UAE;
	}
	public void setR26_CRWA_RESIDENT_UAE(BigDecimal r26_CRWA_RESIDENT_UAE) {
		R26_CRWA_RESIDENT_UAE = r26_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR26_EXPOSURE_NON_RESIDENT_UAE() {
		return R26_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR26_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r26_EXPOSURE_NON_RESIDENT_UAE) {
		R26_EXPOSURE_NON_RESIDENT_UAE = r26_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR26_CRWA_NON_RESIDENT_UAE() {
		return R26_CRWA_NON_RESIDENT_UAE;
	}
	public void setR26_CRWA_NON_RESIDENT_UAE(BigDecimal r26_CRWA_NON_RESIDENT_UAE) {
		R26_CRWA_NON_RESIDENT_UAE = r26_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR26_EXPOSURE_RESIDENT_NON_UAE() {
		return R26_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR26_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r26_EXPOSURE_RESIDENT_NON_UAE) {
		R26_EXPOSURE_RESIDENT_NON_UAE = r26_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR26_CRWA_RESIDENT_NON_UAE() {
		return R26_CRWA_RESIDENT_NON_UAE;
	}
	public void setR26_CRWA_RESIDENT_NON_UAE(BigDecimal r26_CRWA_RESIDENT_NON_UAE) {
		R26_CRWA_RESIDENT_NON_UAE = r26_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR26_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R26_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR26_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r26_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R26_EXPOSURE_NON_RESIDENT_NON_UAE = r26_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR26_CRWA_NON_RESIDENT_NON_UAE() {
		return R26_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR26_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r26_CRWA_NON_RESIDENT_NON_UAE) {
		R26_CRWA_NON_RESIDENT_NON_UAE = r26_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR26_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R26_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR26_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r26_EXPOSURE_INSIDE_CONSOLIDATED) {
		R26_EXPOSURE_INSIDE_CONSOLIDATED = r26_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR26_CRWA_INSIDE_CONSOLIDATED() {
		return R26_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR26_CRWA_INSIDE_CONSOLIDATED(BigDecimal r26_CRWA_INSIDE_CONSOLIDATED) {
		R26_CRWA_INSIDE_CONSOLIDATED = r26_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR26_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R26_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR26_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r26_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R26_EXPOSURE_OUTSIDE_CONSOLIDATED = r26_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR26_CRWA_OUTSIDE_CONSOLIDATED() {
		return R26_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR26_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r26_CRWA_OUTSIDE_CONSOLIDATED) {
		R26_CRWA_OUTSIDE_CONSOLIDATED = r26_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR26_NON_PERFORMING() {
		return R26_NON_PERFORMING;
	}
	public void setR26_NON_PERFORMING(BigDecimal r26_NON_PERFORMING) {
		R26_NON_PERFORMING = r26_NON_PERFORMING;
	}
	public BigDecimal getR26_SPECIFIC_PROVISION() {
		return R26_SPECIFIC_PROVISION;
	}
	public void setR26_SPECIFIC_PROVISION(BigDecimal r26_SPECIFIC_PROVISION) {
		R26_SPECIFIC_PROVISION = r26_SPECIFIC_PROVISION;
	}
	public BigDecimal getR26_INTEREST() {
		return R26_INTEREST;
	}
	public void setR26_INTEREST(BigDecimal r26_INTEREST) {
		R26_INTEREST = r26_INTEREST;
	}
	public BigDecimal getR26_DEFAULTED() {
		return R26_DEFAULTED;
	}
	public void setR26_DEFAULTED(BigDecimal r26_DEFAULTED) {
		R26_DEFAULTED = r26_DEFAULTED;
	}
	public String getR27_S_NO() {
		return R27_S_NO;
	}
	public void setR27_S_NO(String r27_S_NO) {
		R27_S_NO = r27_S_NO;
	}
	public String getR27_AMOUNT() {
		return R27_AMOUNT;
	}
	public void setR27_AMOUNT(String r27_AMOUNT) {
		R27_AMOUNT = r27_AMOUNT;
	}
	public BigDecimal getR27_TOTAL_CONSOLIDATED() {
		return R27_TOTAL_CONSOLIDATED;
	}
	public void setR27_TOTAL_CONSOLIDATED(BigDecimal r27_TOTAL_CONSOLIDATED) {
		R27_TOTAL_CONSOLIDATED = r27_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR27_CRWA_CONSOLIDATED() {
		return R27_CRWA_CONSOLIDATED;
	}
	public void setR27_CRWA_CONSOLIDATED(BigDecimal r27_CRWA_CONSOLIDATED) {
		R27_CRWA_CONSOLIDATED = r27_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR27_EXPOSURE_RESIDENT_UAE() {
		return R27_EXPOSURE_RESIDENT_UAE;
	}
	public void setR27_EXPOSURE_RESIDENT_UAE(BigDecimal r27_EXPOSURE_RESIDENT_UAE) {
		R27_EXPOSURE_RESIDENT_UAE = r27_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR27_CRWA_RESIDENT_UAE() {
		return R27_CRWA_RESIDENT_UAE;
	}
	public void setR27_CRWA_RESIDENT_UAE(BigDecimal r27_CRWA_RESIDENT_UAE) {
		R27_CRWA_RESIDENT_UAE = r27_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR27_EXPOSURE_NON_RESIDENT_UAE() {
		return R27_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR27_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r27_EXPOSURE_NON_RESIDENT_UAE) {
		R27_EXPOSURE_NON_RESIDENT_UAE = r27_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR27_CRWA_NON_RESIDENT_UAE() {
		return R27_CRWA_NON_RESIDENT_UAE;
	}
	public void setR27_CRWA_NON_RESIDENT_UAE(BigDecimal r27_CRWA_NON_RESIDENT_UAE) {
		R27_CRWA_NON_RESIDENT_UAE = r27_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR27_EXPOSURE_RESIDENT_NON_UAE() {
		return R27_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR27_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r27_EXPOSURE_RESIDENT_NON_UAE) {
		R27_EXPOSURE_RESIDENT_NON_UAE = r27_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR27_CRWA_RESIDENT_NON_UAE() {
		return R27_CRWA_RESIDENT_NON_UAE;
	}
	public void setR27_CRWA_RESIDENT_NON_UAE(BigDecimal r27_CRWA_RESIDENT_NON_UAE) {
		R27_CRWA_RESIDENT_NON_UAE = r27_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR27_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R27_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR27_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r27_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R27_EXPOSURE_NON_RESIDENT_NON_UAE = r27_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR27_CRWA_NON_RESIDENT_NON_UAE() {
		return R27_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR27_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r27_CRWA_NON_RESIDENT_NON_UAE) {
		R27_CRWA_NON_RESIDENT_NON_UAE = r27_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR27_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R27_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR27_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r27_EXPOSURE_INSIDE_CONSOLIDATED) {
		R27_EXPOSURE_INSIDE_CONSOLIDATED = r27_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR27_CRWA_INSIDE_CONSOLIDATED() {
		return R27_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR27_CRWA_INSIDE_CONSOLIDATED(BigDecimal r27_CRWA_INSIDE_CONSOLIDATED) {
		R27_CRWA_INSIDE_CONSOLIDATED = r27_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR27_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R27_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR27_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r27_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R27_EXPOSURE_OUTSIDE_CONSOLIDATED = r27_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR27_CRWA_OUTSIDE_CONSOLIDATED() {
		return R27_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR27_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r27_CRWA_OUTSIDE_CONSOLIDATED) {
		R27_CRWA_OUTSIDE_CONSOLIDATED = r27_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR27_NON_PERFORMING() {
		return R27_NON_PERFORMING;
	}
	public void setR27_NON_PERFORMING(BigDecimal r27_NON_PERFORMING) {
		R27_NON_PERFORMING = r27_NON_PERFORMING;
	}
	public BigDecimal getR27_SPECIFIC_PROVISION() {
		return R27_SPECIFIC_PROVISION;
	}
	public void setR27_SPECIFIC_PROVISION(BigDecimal r27_SPECIFIC_PROVISION) {
		R27_SPECIFIC_PROVISION = r27_SPECIFIC_PROVISION;
	}
	public BigDecimal getR27_INTEREST() {
		return R27_INTEREST;
	}
	public void setR27_INTEREST(BigDecimal r27_INTEREST) {
		R27_INTEREST = r27_INTEREST;
	}
	public BigDecimal getR27_DEFAULTED() {
		return R27_DEFAULTED;
	}
	public void setR27_DEFAULTED(BigDecimal r27_DEFAULTED) {
		R27_DEFAULTED = r27_DEFAULTED;
	}
	public String getR28_S_NO() {
		return R28_S_NO;
	}
	public void setR28_S_NO(String r28_S_NO) {
		R28_S_NO = r28_S_NO;
	}
	public String getR28_AMOUNT() {
		return R28_AMOUNT;
	}
	public void setR28_AMOUNT(String r28_AMOUNT) {
		R28_AMOUNT = r28_AMOUNT;
	}
	public BigDecimal getR28_TOTAL_CONSOLIDATED() {
		return R28_TOTAL_CONSOLIDATED;
	}
	public void setR28_TOTAL_CONSOLIDATED(BigDecimal r28_TOTAL_CONSOLIDATED) {
		R28_TOTAL_CONSOLIDATED = r28_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR28_CRWA_CONSOLIDATED() {
		return R28_CRWA_CONSOLIDATED;
	}
	public void setR28_CRWA_CONSOLIDATED(BigDecimal r28_CRWA_CONSOLIDATED) {
		R28_CRWA_CONSOLIDATED = r28_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR28_EXPOSURE_RESIDENT_UAE() {
		return R28_EXPOSURE_RESIDENT_UAE;
	}
	public void setR28_EXPOSURE_RESIDENT_UAE(BigDecimal r28_EXPOSURE_RESIDENT_UAE) {
		R28_EXPOSURE_RESIDENT_UAE = r28_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR28_CRWA_RESIDENT_UAE() {
		return R28_CRWA_RESIDENT_UAE;
	}
	public void setR28_CRWA_RESIDENT_UAE(BigDecimal r28_CRWA_RESIDENT_UAE) {
		R28_CRWA_RESIDENT_UAE = r28_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR28_EXPOSURE_NON_RESIDENT_UAE() {
		return R28_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR28_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r28_EXPOSURE_NON_RESIDENT_UAE) {
		R28_EXPOSURE_NON_RESIDENT_UAE = r28_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR28_CRWA_NON_RESIDENT_UAE() {
		return R28_CRWA_NON_RESIDENT_UAE;
	}
	public void setR28_CRWA_NON_RESIDENT_UAE(BigDecimal r28_CRWA_NON_RESIDENT_UAE) {
		R28_CRWA_NON_RESIDENT_UAE = r28_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR28_EXPOSURE_RESIDENT_NON_UAE() {
		return R28_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR28_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r28_EXPOSURE_RESIDENT_NON_UAE) {
		R28_EXPOSURE_RESIDENT_NON_UAE = r28_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR28_CRWA_RESIDENT_NON_UAE() {
		return R28_CRWA_RESIDENT_NON_UAE;
	}
	public void setR28_CRWA_RESIDENT_NON_UAE(BigDecimal r28_CRWA_RESIDENT_NON_UAE) {
		R28_CRWA_RESIDENT_NON_UAE = r28_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR28_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R28_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR28_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r28_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R28_EXPOSURE_NON_RESIDENT_NON_UAE = r28_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR28_CRWA_NON_RESIDENT_NON_UAE() {
		return R28_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR28_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r28_CRWA_NON_RESIDENT_NON_UAE) {
		R28_CRWA_NON_RESIDENT_NON_UAE = r28_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR28_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R28_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR28_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r28_EXPOSURE_INSIDE_CONSOLIDATED) {
		R28_EXPOSURE_INSIDE_CONSOLIDATED = r28_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR28_CRWA_INSIDE_CONSOLIDATED() {
		return R28_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR28_CRWA_INSIDE_CONSOLIDATED(BigDecimal r28_CRWA_INSIDE_CONSOLIDATED) {
		R28_CRWA_INSIDE_CONSOLIDATED = r28_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR28_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R28_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR28_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r28_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R28_EXPOSURE_OUTSIDE_CONSOLIDATED = r28_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR28_CRWA_OUTSIDE_CONSOLIDATED() {
		return R28_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR28_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r28_CRWA_OUTSIDE_CONSOLIDATED) {
		R28_CRWA_OUTSIDE_CONSOLIDATED = r28_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR28_NON_PERFORMING() {
		return R28_NON_PERFORMING;
	}
	public void setR28_NON_PERFORMING(BigDecimal r28_NON_PERFORMING) {
		R28_NON_PERFORMING = r28_NON_PERFORMING;
	}
	public BigDecimal getR28_SPECIFIC_PROVISION() {
		return R28_SPECIFIC_PROVISION;
	}
	public void setR28_SPECIFIC_PROVISION(BigDecimal r28_SPECIFIC_PROVISION) {
		R28_SPECIFIC_PROVISION = r28_SPECIFIC_PROVISION;
	}
	public BigDecimal getR28_INTEREST() {
		return R28_INTEREST;
	}
	public void setR28_INTEREST(BigDecimal r28_INTEREST) {
		R28_INTEREST = r28_INTEREST;
	}
	public BigDecimal getR28_DEFAULTED() {
		return R28_DEFAULTED;
	}
	public void setR28_DEFAULTED(BigDecimal r28_DEFAULTED) {
		R28_DEFAULTED = r28_DEFAULTED;
	}
	public String getR29_S_NO() {
		return R29_S_NO;
	}
	public void setR29_S_NO(String r29_S_NO) {
		R29_S_NO = r29_S_NO;
	}
	public String getR29_AMOUNT() {
		return R29_AMOUNT;
	}
	public void setR29_AMOUNT(String r29_AMOUNT) {
		R29_AMOUNT = r29_AMOUNT;
	}
	public BigDecimal getR29_TOTAL_CONSOLIDATED() {
		return R29_TOTAL_CONSOLIDATED;
	}
	public void setR29_TOTAL_CONSOLIDATED(BigDecimal r29_TOTAL_CONSOLIDATED) {
		R29_TOTAL_CONSOLIDATED = r29_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR29_CRWA_CONSOLIDATED() {
		return R29_CRWA_CONSOLIDATED;
	}
	public void setR29_CRWA_CONSOLIDATED(BigDecimal r29_CRWA_CONSOLIDATED) {
		R29_CRWA_CONSOLIDATED = r29_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR29_EXPOSURE_RESIDENT_UAE() {
		return R29_EXPOSURE_RESIDENT_UAE;
	}
	public void setR29_EXPOSURE_RESIDENT_UAE(BigDecimal r29_EXPOSURE_RESIDENT_UAE) {
		R29_EXPOSURE_RESIDENT_UAE = r29_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR29_CRWA_RESIDENT_UAE() {
		return R29_CRWA_RESIDENT_UAE;
	}
	public void setR29_CRWA_RESIDENT_UAE(BigDecimal r29_CRWA_RESIDENT_UAE) {
		R29_CRWA_RESIDENT_UAE = r29_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR29_EXPOSURE_NON_RESIDENT_UAE() {
		return R29_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR29_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r29_EXPOSURE_NON_RESIDENT_UAE) {
		R29_EXPOSURE_NON_RESIDENT_UAE = r29_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR29_CRWA_NON_RESIDENT_UAE() {
		return R29_CRWA_NON_RESIDENT_UAE;
	}
	public void setR29_CRWA_NON_RESIDENT_UAE(BigDecimal r29_CRWA_NON_RESIDENT_UAE) {
		R29_CRWA_NON_RESIDENT_UAE = r29_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR29_EXPOSURE_RESIDENT_NON_UAE() {
		return R29_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR29_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r29_EXPOSURE_RESIDENT_NON_UAE) {
		R29_EXPOSURE_RESIDENT_NON_UAE = r29_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR29_CRWA_RESIDENT_NON_UAE() {
		return R29_CRWA_RESIDENT_NON_UAE;
	}
	public void setR29_CRWA_RESIDENT_NON_UAE(BigDecimal r29_CRWA_RESIDENT_NON_UAE) {
		R29_CRWA_RESIDENT_NON_UAE = r29_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR29_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R29_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR29_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r29_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R29_EXPOSURE_NON_RESIDENT_NON_UAE = r29_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR29_CRWA_NON_RESIDENT_NON_UAE() {
		return R29_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR29_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r29_CRWA_NON_RESIDENT_NON_UAE) {
		R29_CRWA_NON_RESIDENT_NON_UAE = r29_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR29_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R29_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR29_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r29_EXPOSURE_INSIDE_CONSOLIDATED) {
		R29_EXPOSURE_INSIDE_CONSOLIDATED = r29_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR29_CRWA_INSIDE_CONSOLIDATED() {
		return R29_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR29_CRWA_INSIDE_CONSOLIDATED(BigDecimal r29_CRWA_INSIDE_CONSOLIDATED) {
		R29_CRWA_INSIDE_CONSOLIDATED = r29_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR29_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R29_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR29_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r29_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R29_EXPOSURE_OUTSIDE_CONSOLIDATED = r29_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR29_CRWA_OUTSIDE_CONSOLIDATED() {
		return R29_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR29_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r29_CRWA_OUTSIDE_CONSOLIDATED) {
		R29_CRWA_OUTSIDE_CONSOLIDATED = r29_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR29_NON_PERFORMING() {
		return R29_NON_PERFORMING;
	}
	public void setR29_NON_PERFORMING(BigDecimal r29_NON_PERFORMING) {
		R29_NON_PERFORMING = r29_NON_PERFORMING;
	}
	public BigDecimal getR29_SPECIFIC_PROVISION() {
		return R29_SPECIFIC_PROVISION;
	}
	public void setR29_SPECIFIC_PROVISION(BigDecimal r29_SPECIFIC_PROVISION) {
		R29_SPECIFIC_PROVISION = r29_SPECIFIC_PROVISION;
	}
	public BigDecimal getR29_INTEREST() {
		return R29_INTEREST;
	}
	public void setR29_INTEREST(BigDecimal r29_INTEREST) {
		R29_INTEREST = r29_INTEREST;
	}
	public BigDecimal getR29_DEFAULTED() {
		return R29_DEFAULTED;
	}
	public void setR29_DEFAULTED(BigDecimal r29_DEFAULTED) {
		R29_DEFAULTED = r29_DEFAULTED;
	}
	public String getR30_S_NO() {
		return R30_S_NO;
	}
	public void setR30_S_NO(String r30_S_NO) {
		R30_S_NO = r30_S_NO;
	}
	public String getR30_AMOUNT() {
		return R30_AMOUNT;
	}
	public void setR30_AMOUNT(String r30_AMOUNT) {
		R30_AMOUNT = r30_AMOUNT;
	}
	public BigDecimal getR30_TOTAL_CONSOLIDATED() {
		return R30_TOTAL_CONSOLIDATED;
	}
	public void setR30_TOTAL_CONSOLIDATED(BigDecimal r30_TOTAL_CONSOLIDATED) {
		R30_TOTAL_CONSOLIDATED = r30_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR30_CRWA_CONSOLIDATED() {
		return R30_CRWA_CONSOLIDATED;
	}
	public void setR30_CRWA_CONSOLIDATED(BigDecimal r30_CRWA_CONSOLIDATED) {
		R30_CRWA_CONSOLIDATED = r30_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR30_EXPOSURE_RESIDENT_UAE() {
		return R30_EXPOSURE_RESIDENT_UAE;
	}
	public void setR30_EXPOSURE_RESIDENT_UAE(BigDecimal r30_EXPOSURE_RESIDENT_UAE) {
		R30_EXPOSURE_RESIDENT_UAE = r30_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR30_CRWA_RESIDENT_UAE() {
		return R30_CRWA_RESIDENT_UAE;
	}
	public void setR30_CRWA_RESIDENT_UAE(BigDecimal r30_CRWA_RESIDENT_UAE) {
		R30_CRWA_RESIDENT_UAE = r30_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR30_EXPOSURE_NON_RESIDENT_UAE() {
		return R30_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR30_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r30_EXPOSURE_NON_RESIDENT_UAE) {
		R30_EXPOSURE_NON_RESIDENT_UAE = r30_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR30_CRWA_NON_RESIDENT_UAE() {
		return R30_CRWA_NON_RESIDENT_UAE;
	}
	public void setR30_CRWA_NON_RESIDENT_UAE(BigDecimal r30_CRWA_NON_RESIDENT_UAE) {
		R30_CRWA_NON_RESIDENT_UAE = r30_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR30_EXPOSURE_RESIDENT_NON_UAE() {
		return R30_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR30_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r30_EXPOSURE_RESIDENT_NON_UAE) {
		R30_EXPOSURE_RESIDENT_NON_UAE = r30_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR30_CRWA_RESIDENT_NON_UAE() {
		return R30_CRWA_RESIDENT_NON_UAE;
	}
	public void setR30_CRWA_RESIDENT_NON_UAE(BigDecimal r30_CRWA_RESIDENT_NON_UAE) {
		R30_CRWA_RESIDENT_NON_UAE = r30_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR30_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R30_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR30_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r30_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R30_EXPOSURE_NON_RESIDENT_NON_UAE = r30_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR30_CRWA_NON_RESIDENT_NON_UAE() {
		return R30_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR30_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r30_CRWA_NON_RESIDENT_NON_UAE) {
		R30_CRWA_NON_RESIDENT_NON_UAE = r30_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR30_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R30_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR30_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r30_EXPOSURE_INSIDE_CONSOLIDATED) {
		R30_EXPOSURE_INSIDE_CONSOLIDATED = r30_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR30_CRWA_INSIDE_CONSOLIDATED() {
		return R30_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR30_CRWA_INSIDE_CONSOLIDATED(BigDecimal r30_CRWA_INSIDE_CONSOLIDATED) {
		R30_CRWA_INSIDE_CONSOLIDATED = r30_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR30_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R30_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR30_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r30_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R30_EXPOSURE_OUTSIDE_CONSOLIDATED = r30_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR30_CRWA_OUTSIDE_CONSOLIDATED() {
		return R30_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR30_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r30_CRWA_OUTSIDE_CONSOLIDATED) {
		R30_CRWA_OUTSIDE_CONSOLIDATED = r30_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR30_NON_PERFORMING() {
		return R30_NON_PERFORMING;
	}
	public void setR30_NON_PERFORMING(BigDecimal r30_NON_PERFORMING) {
		R30_NON_PERFORMING = r30_NON_PERFORMING;
	}
	public BigDecimal getR30_SPECIFIC_PROVISION() {
		return R30_SPECIFIC_PROVISION;
	}
	public void setR30_SPECIFIC_PROVISION(BigDecimal r30_SPECIFIC_PROVISION) {
		R30_SPECIFIC_PROVISION = r30_SPECIFIC_PROVISION;
	}
	public BigDecimal getR30_INTEREST() {
		return R30_INTEREST;
	}
	public void setR30_INTEREST(BigDecimal r30_INTEREST) {
		R30_INTEREST = r30_INTEREST;
	}
	public BigDecimal getR30_DEFAULTED() {
		return R30_DEFAULTED;
	}
	public void setR30_DEFAULTED(BigDecimal r30_DEFAULTED) {
		R30_DEFAULTED = r30_DEFAULTED;
	}
	public String getR31_S_NO() {
		return R31_S_NO;
	}
	public void setR31_S_NO(String r31_S_NO) {
		R31_S_NO = r31_S_NO;
	}
	public String getR31_AMOUNT() {
		return R31_AMOUNT;
	}
	public void setR31_AMOUNT(String r31_AMOUNT) {
		R31_AMOUNT = r31_AMOUNT;
	}
	public BigDecimal getR31_TOTAL_CONSOLIDATED() {
		return R31_TOTAL_CONSOLIDATED;
	}
	public void setR31_TOTAL_CONSOLIDATED(BigDecimal r31_TOTAL_CONSOLIDATED) {
		R31_TOTAL_CONSOLIDATED = r31_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR31_CRWA_CONSOLIDATED() {
		return R31_CRWA_CONSOLIDATED;
	}
	public void setR31_CRWA_CONSOLIDATED(BigDecimal r31_CRWA_CONSOLIDATED) {
		R31_CRWA_CONSOLIDATED = r31_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR31_EXPOSURE_RESIDENT_UAE() {
		return R31_EXPOSURE_RESIDENT_UAE;
	}
	public void setR31_EXPOSURE_RESIDENT_UAE(BigDecimal r31_EXPOSURE_RESIDENT_UAE) {
		R31_EXPOSURE_RESIDENT_UAE = r31_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR31_CRWA_RESIDENT_UAE() {
		return R31_CRWA_RESIDENT_UAE;
	}
	public void setR31_CRWA_RESIDENT_UAE(BigDecimal r31_CRWA_RESIDENT_UAE) {
		R31_CRWA_RESIDENT_UAE = r31_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR31_EXPOSURE_NON_RESIDENT_UAE() {
		return R31_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR31_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r31_EXPOSURE_NON_RESIDENT_UAE) {
		R31_EXPOSURE_NON_RESIDENT_UAE = r31_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR31_CRWA_NON_RESIDENT_UAE() {
		return R31_CRWA_NON_RESIDENT_UAE;
	}
	public void setR31_CRWA_NON_RESIDENT_UAE(BigDecimal r31_CRWA_NON_RESIDENT_UAE) {
		R31_CRWA_NON_RESIDENT_UAE = r31_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR31_EXPOSURE_RESIDENT_NON_UAE() {
		return R31_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR31_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r31_EXPOSURE_RESIDENT_NON_UAE) {
		R31_EXPOSURE_RESIDENT_NON_UAE = r31_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR31_CRWA_RESIDENT_NON_UAE() {
		return R31_CRWA_RESIDENT_NON_UAE;
	}
	public void setR31_CRWA_RESIDENT_NON_UAE(BigDecimal r31_CRWA_RESIDENT_NON_UAE) {
		R31_CRWA_RESIDENT_NON_UAE = r31_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR31_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R31_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR31_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r31_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R31_EXPOSURE_NON_RESIDENT_NON_UAE = r31_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR31_CRWA_NON_RESIDENT_NON_UAE() {
		return R31_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR31_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r31_CRWA_NON_RESIDENT_NON_UAE) {
		R31_CRWA_NON_RESIDENT_NON_UAE = r31_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR31_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R31_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR31_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r31_EXPOSURE_INSIDE_CONSOLIDATED) {
		R31_EXPOSURE_INSIDE_CONSOLIDATED = r31_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR31_CRWA_INSIDE_CONSOLIDATED() {
		return R31_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR31_CRWA_INSIDE_CONSOLIDATED(BigDecimal r31_CRWA_INSIDE_CONSOLIDATED) {
		R31_CRWA_INSIDE_CONSOLIDATED = r31_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR31_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R31_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR31_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r31_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R31_EXPOSURE_OUTSIDE_CONSOLIDATED = r31_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR31_CRWA_OUTSIDE_CONSOLIDATED() {
		return R31_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR31_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r31_CRWA_OUTSIDE_CONSOLIDATED) {
		R31_CRWA_OUTSIDE_CONSOLIDATED = r31_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR31_NON_PERFORMING() {
		return R31_NON_PERFORMING;
	}
	public void setR31_NON_PERFORMING(BigDecimal r31_NON_PERFORMING) {
		R31_NON_PERFORMING = r31_NON_PERFORMING;
	}
	public BigDecimal getR31_SPECIFIC_PROVISION() {
		return R31_SPECIFIC_PROVISION;
	}
	public void setR31_SPECIFIC_PROVISION(BigDecimal r31_SPECIFIC_PROVISION) {
		R31_SPECIFIC_PROVISION = r31_SPECIFIC_PROVISION;
	}
	public BigDecimal getR31_INTEREST() {
		return R31_INTEREST;
	}
	public void setR31_INTEREST(BigDecimal r31_INTEREST) {
		R31_INTEREST = r31_INTEREST;
	}
	public BigDecimal getR31_DEFAULTED() {
		return R31_DEFAULTED;
	}
	public void setR31_DEFAULTED(BigDecimal r31_DEFAULTED) {
		R31_DEFAULTED = r31_DEFAULTED;
	}
	public String getR32_S_NO() {
		return R32_S_NO;
	}
	public void setR32_S_NO(String r32_S_NO) {
		R32_S_NO = r32_S_NO;
	}
	public String getR32_AMOUNT() {
		return R32_AMOUNT;
	}
	public void setR32_AMOUNT(String r32_AMOUNT) {
		R32_AMOUNT = r32_AMOUNT;
	}
	public BigDecimal getR32_TOTAL_CONSOLIDATED() {
		return R32_TOTAL_CONSOLIDATED;
	}
	public void setR32_TOTAL_CONSOLIDATED(BigDecimal r32_TOTAL_CONSOLIDATED) {
		R32_TOTAL_CONSOLIDATED = r32_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR32_CRWA_CONSOLIDATED() {
		return R32_CRWA_CONSOLIDATED;
	}
	public void setR32_CRWA_CONSOLIDATED(BigDecimal r32_CRWA_CONSOLIDATED) {
		R32_CRWA_CONSOLIDATED = r32_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR32_EXPOSURE_RESIDENT_UAE() {
		return R32_EXPOSURE_RESIDENT_UAE;
	}
	public void setR32_EXPOSURE_RESIDENT_UAE(BigDecimal r32_EXPOSURE_RESIDENT_UAE) {
		R32_EXPOSURE_RESIDENT_UAE = r32_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR32_CRWA_RESIDENT_UAE() {
		return R32_CRWA_RESIDENT_UAE;
	}
	public void setR32_CRWA_RESIDENT_UAE(BigDecimal r32_CRWA_RESIDENT_UAE) {
		R32_CRWA_RESIDENT_UAE = r32_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR32_EXPOSURE_NON_RESIDENT_UAE() {
		return R32_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR32_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r32_EXPOSURE_NON_RESIDENT_UAE) {
		R32_EXPOSURE_NON_RESIDENT_UAE = r32_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR32_CRWA_NON_RESIDENT_UAE() {
		return R32_CRWA_NON_RESIDENT_UAE;
	}
	public void setR32_CRWA_NON_RESIDENT_UAE(BigDecimal r32_CRWA_NON_RESIDENT_UAE) {
		R32_CRWA_NON_RESIDENT_UAE = r32_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR32_EXPOSURE_RESIDENT_NON_UAE() {
		return R32_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR32_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r32_EXPOSURE_RESIDENT_NON_UAE) {
		R32_EXPOSURE_RESIDENT_NON_UAE = r32_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR32_CRWA_RESIDENT_NON_UAE() {
		return R32_CRWA_RESIDENT_NON_UAE;
	}
	public void setR32_CRWA_RESIDENT_NON_UAE(BigDecimal r32_CRWA_RESIDENT_NON_UAE) {
		R32_CRWA_RESIDENT_NON_UAE = r32_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR32_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R32_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR32_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r32_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R32_EXPOSURE_NON_RESIDENT_NON_UAE = r32_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR32_CRWA_NON_RESIDENT_NON_UAE() {
		return R32_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR32_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r32_CRWA_NON_RESIDENT_NON_UAE) {
		R32_CRWA_NON_RESIDENT_NON_UAE = r32_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR32_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R32_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR32_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r32_EXPOSURE_INSIDE_CONSOLIDATED) {
		R32_EXPOSURE_INSIDE_CONSOLIDATED = r32_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR32_CRWA_INSIDE_CONSOLIDATED() {
		return R32_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR32_CRWA_INSIDE_CONSOLIDATED(BigDecimal r32_CRWA_INSIDE_CONSOLIDATED) {
		R32_CRWA_INSIDE_CONSOLIDATED = r32_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR32_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R32_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR32_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r32_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R32_EXPOSURE_OUTSIDE_CONSOLIDATED = r32_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR32_CRWA_OUTSIDE_CONSOLIDATED() {
		return R32_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR32_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r32_CRWA_OUTSIDE_CONSOLIDATED) {
		R32_CRWA_OUTSIDE_CONSOLIDATED = r32_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR32_NON_PERFORMING() {
		return R32_NON_PERFORMING;
	}
	public void setR32_NON_PERFORMING(BigDecimal r32_NON_PERFORMING) {
		R32_NON_PERFORMING = r32_NON_PERFORMING;
	}
	public BigDecimal getR32_SPECIFIC_PROVISION() {
		return R32_SPECIFIC_PROVISION;
	}
	public void setR32_SPECIFIC_PROVISION(BigDecimal r32_SPECIFIC_PROVISION) {
		R32_SPECIFIC_PROVISION = r32_SPECIFIC_PROVISION;
	}
	public BigDecimal getR32_INTEREST() {
		return R32_INTEREST;
	}
	public void setR32_INTEREST(BigDecimal r32_INTEREST) {
		R32_INTEREST = r32_INTEREST;
	}
	public BigDecimal getR32_DEFAULTED() {
		return R32_DEFAULTED;
	}
	public void setR32_DEFAULTED(BigDecimal r32_DEFAULTED) {
		R32_DEFAULTED = r32_DEFAULTED;
	}
	public String getR33_S_NO() {
		return R33_S_NO;
	}
	public void setR33_S_NO(String r33_S_NO) {
		R33_S_NO = r33_S_NO;
	}
	public String getR33_AMOUNT() {
		return R33_AMOUNT;
	}
	public void setR33_AMOUNT(String r33_AMOUNT) {
		R33_AMOUNT = r33_AMOUNT;
	}
	public BigDecimal getR33_TOTAL_CONSOLIDATED() {
		return R33_TOTAL_CONSOLIDATED;
	}
	public void setR33_TOTAL_CONSOLIDATED(BigDecimal r33_TOTAL_CONSOLIDATED) {
		R33_TOTAL_CONSOLIDATED = r33_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR33_CRWA_CONSOLIDATED() {
		return R33_CRWA_CONSOLIDATED;
	}
	public void setR33_CRWA_CONSOLIDATED(BigDecimal r33_CRWA_CONSOLIDATED) {
		R33_CRWA_CONSOLIDATED = r33_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR33_EXPOSURE_RESIDENT_UAE() {
		return R33_EXPOSURE_RESIDENT_UAE;
	}
	public void setR33_EXPOSURE_RESIDENT_UAE(BigDecimal r33_EXPOSURE_RESIDENT_UAE) {
		R33_EXPOSURE_RESIDENT_UAE = r33_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR33_CRWA_RESIDENT_UAE() {
		return R33_CRWA_RESIDENT_UAE;
	}
	public void setR33_CRWA_RESIDENT_UAE(BigDecimal r33_CRWA_RESIDENT_UAE) {
		R33_CRWA_RESIDENT_UAE = r33_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR33_EXPOSURE_NON_RESIDENT_UAE() {
		return R33_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR33_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r33_EXPOSURE_NON_RESIDENT_UAE) {
		R33_EXPOSURE_NON_RESIDENT_UAE = r33_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR33_CRWA_NON_RESIDENT_UAE() {
		return R33_CRWA_NON_RESIDENT_UAE;
	}
	public void setR33_CRWA_NON_RESIDENT_UAE(BigDecimal r33_CRWA_NON_RESIDENT_UAE) {
		R33_CRWA_NON_RESIDENT_UAE = r33_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR33_EXPOSURE_RESIDENT_NON_UAE() {
		return R33_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR33_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r33_EXPOSURE_RESIDENT_NON_UAE) {
		R33_EXPOSURE_RESIDENT_NON_UAE = r33_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR33_CRWA_RESIDENT_NON_UAE() {
		return R33_CRWA_RESIDENT_NON_UAE;
	}
	public void setR33_CRWA_RESIDENT_NON_UAE(BigDecimal r33_CRWA_RESIDENT_NON_UAE) {
		R33_CRWA_RESIDENT_NON_UAE = r33_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR33_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R33_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR33_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r33_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R33_EXPOSURE_NON_RESIDENT_NON_UAE = r33_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR33_CRWA_NON_RESIDENT_NON_UAE() {
		return R33_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR33_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r33_CRWA_NON_RESIDENT_NON_UAE) {
		R33_CRWA_NON_RESIDENT_NON_UAE = r33_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR33_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R33_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR33_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r33_EXPOSURE_INSIDE_CONSOLIDATED) {
		R33_EXPOSURE_INSIDE_CONSOLIDATED = r33_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR33_CRWA_INSIDE_CONSOLIDATED() {
		return R33_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR33_CRWA_INSIDE_CONSOLIDATED(BigDecimal r33_CRWA_INSIDE_CONSOLIDATED) {
		R33_CRWA_INSIDE_CONSOLIDATED = r33_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR33_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R33_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR33_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r33_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R33_EXPOSURE_OUTSIDE_CONSOLIDATED = r33_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR33_CRWA_OUTSIDE_CONSOLIDATED() {
		return R33_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR33_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r33_CRWA_OUTSIDE_CONSOLIDATED) {
		R33_CRWA_OUTSIDE_CONSOLIDATED = r33_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR33_NON_PERFORMING() {
		return R33_NON_PERFORMING;
	}
	public void setR33_NON_PERFORMING(BigDecimal r33_NON_PERFORMING) {
		R33_NON_PERFORMING = r33_NON_PERFORMING;
	}
	public BigDecimal getR33_SPECIFIC_PROVISION() {
		return R33_SPECIFIC_PROVISION;
	}
	public void setR33_SPECIFIC_PROVISION(BigDecimal r33_SPECIFIC_PROVISION) {
		R33_SPECIFIC_PROVISION = r33_SPECIFIC_PROVISION;
	}
	public BigDecimal getR33_INTEREST() {
		return R33_INTEREST;
	}
	public void setR33_INTEREST(BigDecimal r33_INTEREST) {
		R33_INTEREST = r33_INTEREST;
	}
	public BigDecimal getR33_DEFAULTED() {
		return R33_DEFAULTED;
	}
	public void setR33_DEFAULTED(BigDecimal r33_DEFAULTED) {
		R33_DEFAULTED = r33_DEFAULTED;
	}
	public String getR34_S_NO() {
		return R34_S_NO;
	}
	public void setR34_S_NO(String r34_S_NO) {
		R34_S_NO = r34_S_NO;
	}
	public String getR34_AMOUNT() {
		return R34_AMOUNT;
	}
	public void setR34_AMOUNT(String r34_AMOUNT) {
		R34_AMOUNT = r34_AMOUNT;
	}
	public BigDecimal getR34_TOTAL_CONSOLIDATED() {
		return R34_TOTAL_CONSOLIDATED;
	}
	public void setR34_TOTAL_CONSOLIDATED(BigDecimal r34_TOTAL_CONSOLIDATED) {
		R34_TOTAL_CONSOLIDATED = r34_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR34_CRWA_CONSOLIDATED() {
		return R34_CRWA_CONSOLIDATED;
	}
	public void setR34_CRWA_CONSOLIDATED(BigDecimal r34_CRWA_CONSOLIDATED) {
		R34_CRWA_CONSOLIDATED = r34_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR34_EXPOSURE_RESIDENT_UAE() {
		return R34_EXPOSURE_RESIDENT_UAE;
	}
	public void setR34_EXPOSURE_RESIDENT_UAE(BigDecimal r34_EXPOSURE_RESIDENT_UAE) {
		R34_EXPOSURE_RESIDENT_UAE = r34_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR34_CRWA_RESIDENT_UAE() {
		return R34_CRWA_RESIDENT_UAE;
	}
	public void setR34_CRWA_RESIDENT_UAE(BigDecimal r34_CRWA_RESIDENT_UAE) {
		R34_CRWA_RESIDENT_UAE = r34_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR34_EXPOSURE_NON_RESIDENT_UAE() {
		return R34_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR34_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r34_EXPOSURE_NON_RESIDENT_UAE) {
		R34_EXPOSURE_NON_RESIDENT_UAE = r34_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR34_CRWA_NON_RESIDENT_UAE() {
		return R34_CRWA_NON_RESIDENT_UAE;
	}
	public void setR34_CRWA_NON_RESIDENT_UAE(BigDecimal r34_CRWA_NON_RESIDENT_UAE) {
		R34_CRWA_NON_RESIDENT_UAE = r34_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR34_EXPOSURE_RESIDENT_NON_UAE() {
		return R34_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR34_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r34_EXPOSURE_RESIDENT_NON_UAE) {
		R34_EXPOSURE_RESIDENT_NON_UAE = r34_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR34_CRWA_RESIDENT_NON_UAE() {
		return R34_CRWA_RESIDENT_NON_UAE;
	}
	public void setR34_CRWA_RESIDENT_NON_UAE(BigDecimal r34_CRWA_RESIDENT_NON_UAE) {
		R34_CRWA_RESIDENT_NON_UAE = r34_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR34_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R34_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR34_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r34_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R34_EXPOSURE_NON_RESIDENT_NON_UAE = r34_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR34_CRWA_NON_RESIDENT_NON_UAE() {
		return R34_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR34_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r34_CRWA_NON_RESIDENT_NON_UAE) {
		R34_CRWA_NON_RESIDENT_NON_UAE = r34_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR34_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R34_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR34_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r34_EXPOSURE_INSIDE_CONSOLIDATED) {
		R34_EXPOSURE_INSIDE_CONSOLIDATED = r34_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR34_CRWA_INSIDE_CONSOLIDATED() {
		return R34_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR34_CRWA_INSIDE_CONSOLIDATED(BigDecimal r34_CRWA_INSIDE_CONSOLIDATED) {
		R34_CRWA_INSIDE_CONSOLIDATED = r34_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR34_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R34_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR34_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r34_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R34_EXPOSURE_OUTSIDE_CONSOLIDATED = r34_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR34_CRWA_OUTSIDE_CONSOLIDATED() {
		return R34_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR34_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r34_CRWA_OUTSIDE_CONSOLIDATED) {
		R34_CRWA_OUTSIDE_CONSOLIDATED = r34_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR34_NON_PERFORMING() {
		return R34_NON_PERFORMING;
	}
	public void setR34_NON_PERFORMING(BigDecimal r34_NON_PERFORMING) {
		R34_NON_PERFORMING = r34_NON_PERFORMING;
	}
	public BigDecimal getR34_SPECIFIC_PROVISION() {
		return R34_SPECIFIC_PROVISION;
	}
	public void setR34_SPECIFIC_PROVISION(BigDecimal r34_SPECIFIC_PROVISION) {
		R34_SPECIFIC_PROVISION = r34_SPECIFIC_PROVISION;
	}
	public BigDecimal getR34_INTEREST() {
		return R34_INTEREST;
	}
	public void setR34_INTEREST(BigDecimal r34_INTEREST) {
		R34_INTEREST = r34_INTEREST;
	}
	public BigDecimal getR34_DEFAULTED() {
		return R34_DEFAULTED;
	}
	public void setR34_DEFAULTED(BigDecimal r34_DEFAULTED) {
		R34_DEFAULTED = r34_DEFAULTED;
	}
	public String getR35_S_NO() {
		return R35_S_NO;
	}
	public void setR35_S_NO(String r35_S_NO) {
		R35_S_NO = r35_S_NO;
	}
	public String getR35_AMOUNT() {
		return R35_AMOUNT;
	}
	public void setR35_AMOUNT(String r35_AMOUNT) {
		R35_AMOUNT = r35_AMOUNT;
	}
	public BigDecimal getR35_TOTAL_CONSOLIDATED() {
		return R35_TOTAL_CONSOLIDATED;
	}
	public void setR35_TOTAL_CONSOLIDATED(BigDecimal r35_TOTAL_CONSOLIDATED) {
		R35_TOTAL_CONSOLIDATED = r35_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR35_CRWA_CONSOLIDATED() {
		return R35_CRWA_CONSOLIDATED;
	}
	public void setR35_CRWA_CONSOLIDATED(BigDecimal r35_CRWA_CONSOLIDATED) {
		R35_CRWA_CONSOLIDATED = r35_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR35_EXPOSURE_RESIDENT_UAE() {
		return R35_EXPOSURE_RESIDENT_UAE;
	}
	public void setR35_EXPOSURE_RESIDENT_UAE(BigDecimal r35_EXPOSURE_RESIDENT_UAE) {
		R35_EXPOSURE_RESIDENT_UAE = r35_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR35_CRWA_RESIDENT_UAE() {
		return R35_CRWA_RESIDENT_UAE;
	}
	public void setR35_CRWA_RESIDENT_UAE(BigDecimal r35_CRWA_RESIDENT_UAE) {
		R35_CRWA_RESIDENT_UAE = r35_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR35_EXPOSURE_NON_RESIDENT_UAE() {
		return R35_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR35_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r35_EXPOSURE_NON_RESIDENT_UAE) {
		R35_EXPOSURE_NON_RESIDENT_UAE = r35_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR35_CRWA_NON_RESIDENT_UAE() {
		return R35_CRWA_NON_RESIDENT_UAE;
	}
	public void setR35_CRWA_NON_RESIDENT_UAE(BigDecimal r35_CRWA_NON_RESIDENT_UAE) {
		R35_CRWA_NON_RESIDENT_UAE = r35_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR35_EXPOSURE_RESIDENT_NON_UAE() {
		return R35_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR35_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r35_EXPOSURE_RESIDENT_NON_UAE) {
		R35_EXPOSURE_RESIDENT_NON_UAE = r35_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR35_CRWA_RESIDENT_NON_UAE() {
		return R35_CRWA_RESIDENT_NON_UAE;
	}
	public void setR35_CRWA_RESIDENT_NON_UAE(BigDecimal r35_CRWA_RESIDENT_NON_UAE) {
		R35_CRWA_RESIDENT_NON_UAE = r35_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR35_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R35_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR35_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r35_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R35_EXPOSURE_NON_RESIDENT_NON_UAE = r35_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR35_CRWA_NON_RESIDENT_NON_UAE() {
		return R35_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR35_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r35_CRWA_NON_RESIDENT_NON_UAE) {
		R35_CRWA_NON_RESIDENT_NON_UAE = r35_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR35_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R35_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR35_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r35_EXPOSURE_INSIDE_CONSOLIDATED) {
		R35_EXPOSURE_INSIDE_CONSOLIDATED = r35_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR35_CRWA_INSIDE_CONSOLIDATED() {
		return R35_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR35_CRWA_INSIDE_CONSOLIDATED(BigDecimal r35_CRWA_INSIDE_CONSOLIDATED) {
		R35_CRWA_INSIDE_CONSOLIDATED = r35_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR35_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R35_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR35_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r35_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R35_EXPOSURE_OUTSIDE_CONSOLIDATED = r35_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR35_CRWA_OUTSIDE_CONSOLIDATED() {
		return R35_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR35_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r35_CRWA_OUTSIDE_CONSOLIDATED) {
		R35_CRWA_OUTSIDE_CONSOLIDATED = r35_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR35_NON_PERFORMING() {
		return R35_NON_PERFORMING;
	}
	public void setR35_NON_PERFORMING(BigDecimal r35_NON_PERFORMING) {
		R35_NON_PERFORMING = r35_NON_PERFORMING;
	}
	public BigDecimal getR35_SPECIFIC_PROVISION() {
		return R35_SPECIFIC_PROVISION;
	}
	public void setR35_SPECIFIC_PROVISION(BigDecimal r35_SPECIFIC_PROVISION) {
		R35_SPECIFIC_PROVISION = r35_SPECIFIC_PROVISION;
	}
	public BigDecimal getR35_INTEREST() {
		return R35_INTEREST;
	}
	public void setR35_INTEREST(BigDecimal r35_INTEREST) {
		R35_INTEREST = r35_INTEREST;
	}
	public BigDecimal getR35_DEFAULTED() {
		return R35_DEFAULTED;
	}
	public void setR35_DEFAULTED(BigDecimal r35_DEFAULTED) {
		R35_DEFAULTED = r35_DEFAULTED;
	}
	public String getR36_S_NO() {
		return R36_S_NO;
	}
	public void setR36_S_NO(String r36_S_NO) {
		R36_S_NO = r36_S_NO;
	}
	public String getR36_AMOUNT() {
		return R36_AMOUNT;
	}
	public void setR36_AMOUNT(String r36_AMOUNT) {
		R36_AMOUNT = r36_AMOUNT;
	}
	public BigDecimal getR36_TOTAL_CONSOLIDATED() {
		return R36_TOTAL_CONSOLIDATED;
	}
	public void setR36_TOTAL_CONSOLIDATED(BigDecimal r36_TOTAL_CONSOLIDATED) {
		R36_TOTAL_CONSOLIDATED = r36_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR36_CRWA_CONSOLIDATED() {
		return R36_CRWA_CONSOLIDATED;
	}
	public void setR36_CRWA_CONSOLIDATED(BigDecimal r36_CRWA_CONSOLIDATED) {
		R36_CRWA_CONSOLIDATED = r36_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR36_EXPOSURE_RESIDENT_UAE() {
		return R36_EXPOSURE_RESIDENT_UAE;
	}
	public void setR36_EXPOSURE_RESIDENT_UAE(BigDecimal r36_EXPOSURE_RESIDENT_UAE) {
		R36_EXPOSURE_RESIDENT_UAE = r36_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR36_CRWA_RESIDENT_UAE() {
		return R36_CRWA_RESIDENT_UAE;
	}
	public void setR36_CRWA_RESIDENT_UAE(BigDecimal r36_CRWA_RESIDENT_UAE) {
		R36_CRWA_RESIDENT_UAE = r36_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR36_EXPOSURE_NON_RESIDENT_UAE() {
		return R36_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR36_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r36_EXPOSURE_NON_RESIDENT_UAE) {
		R36_EXPOSURE_NON_RESIDENT_UAE = r36_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR36_CRWA_NON_RESIDENT_UAE() {
		return R36_CRWA_NON_RESIDENT_UAE;
	}
	public void setR36_CRWA_NON_RESIDENT_UAE(BigDecimal r36_CRWA_NON_RESIDENT_UAE) {
		R36_CRWA_NON_RESIDENT_UAE = r36_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR36_EXPOSURE_RESIDENT_NON_UAE() {
		return R36_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR36_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r36_EXPOSURE_RESIDENT_NON_UAE) {
		R36_EXPOSURE_RESIDENT_NON_UAE = r36_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR36_CRWA_RESIDENT_NON_UAE() {
		return R36_CRWA_RESIDENT_NON_UAE;
	}
	public void setR36_CRWA_RESIDENT_NON_UAE(BigDecimal r36_CRWA_RESIDENT_NON_UAE) {
		R36_CRWA_RESIDENT_NON_UAE = r36_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR36_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R36_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR36_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r36_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R36_EXPOSURE_NON_RESIDENT_NON_UAE = r36_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR36_CRWA_NON_RESIDENT_NON_UAE() {
		return R36_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR36_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r36_CRWA_NON_RESIDENT_NON_UAE) {
		R36_CRWA_NON_RESIDENT_NON_UAE = r36_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR36_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R36_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR36_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r36_EXPOSURE_INSIDE_CONSOLIDATED) {
		R36_EXPOSURE_INSIDE_CONSOLIDATED = r36_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR36_CRWA_INSIDE_CONSOLIDATED() {
		return R36_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR36_CRWA_INSIDE_CONSOLIDATED(BigDecimal r36_CRWA_INSIDE_CONSOLIDATED) {
		R36_CRWA_INSIDE_CONSOLIDATED = r36_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR36_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R36_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR36_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r36_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R36_EXPOSURE_OUTSIDE_CONSOLIDATED = r36_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR36_CRWA_OUTSIDE_CONSOLIDATED() {
		return R36_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR36_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r36_CRWA_OUTSIDE_CONSOLIDATED) {
		R36_CRWA_OUTSIDE_CONSOLIDATED = r36_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR36_NON_PERFORMING() {
		return R36_NON_PERFORMING;
	}
	public void setR36_NON_PERFORMING(BigDecimal r36_NON_PERFORMING) {
		R36_NON_PERFORMING = r36_NON_PERFORMING;
	}
	public BigDecimal getR36_SPECIFIC_PROVISION() {
		return R36_SPECIFIC_PROVISION;
	}
	public void setR36_SPECIFIC_PROVISION(BigDecimal r36_SPECIFIC_PROVISION) {
		R36_SPECIFIC_PROVISION = r36_SPECIFIC_PROVISION;
	}
	public BigDecimal getR36_INTEREST() {
		return R36_INTEREST;
	}
	public void setR36_INTEREST(BigDecimal r36_INTEREST) {
		R36_INTEREST = r36_INTEREST;
	}
	public BigDecimal getR36_DEFAULTED() {
		return R36_DEFAULTED;
	}
	public void setR36_DEFAULTED(BigDecimal r36_DEFAULTED) {
		R36_DEFAULTED = r36_DEFAULTED;
	}
	public String getR37_S_NO() {
		return R37_S_NO;
	}
	public void setR37_S_NO(String r37_S_NO) {
		R37_S_NO = r37_S_NO;
	}
	public String getR37_AMOUNT() {
		return R37_AMOUNT;
	}
	public void setR37_AMOUNT(String r37_AMOUNT) {
		R37_AMOUNT = r37_AMOUNT;
	}
	public BigDecimal getR37_TOTAL_CONSOLIDATED() {
		return R37_TOTAL_CONSOLIDATED;
	}
	public void setR37_TOTAL_CONSOLIDATED(BigDecimal r37_TOTAL_CONSOLIDATED) {
		R37_TOTAL_CONSOLIDATED = r37_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR37_CRWA_CONSOLIDATED() {
		return R37_CRWA_CONSOLIDATED;
	}
	public void setR37_CRWA_CONSOLIDATED(BigDecimal r37_CRWA_CONSOLIDATED) {
		R37_CRWA_CONSOLIDATED = r37_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR37_EXPOSURE_RESIDENT_UAE() {
		return R37_EXPOSURE_RESIDENT_UAE;
	}
	public void setR37_EXPOSURE_RESIDENT_UAE(BigDecimal r37_EXPOSURE_RESIDENT_UAE) {
		R37_EXPOSURE_RESIDENT_UAE = r37_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR37_CRWA_RESIDENT_UAE() {
		return R37_CRWA_RESIDENT_UAE;
	}
	public void setR37_CRWA_RESIDENT_UAE(BigDecimal r37_CRWA_RESIDENT_UAE) {
		R37_CRWA_RESIDENT_UAE = r37_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR37_EXPOSURE_NON_RESIDENT_UAE() {
		return R37_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR37_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r37_EXPOSURE_NON_RESIDENT_UAE) {
		R37_EXPOSURE_NON_RESIDENT_UAE = r37_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR37_CRWA_NON_RESIDENT_UAE() {
		return R37_CRWA_NON_RESIDENT_UAE;
	}
	public void setR37_CRWA_NON_RESIDENT_UAE(BigDecimal r37_CRWA_NON_RESIDENT_UAE) {
		R37_CRWA_NON_RESIDENT_UAE = r37_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR37_EXPOSURE_RESIDENT_NON_UAE() {
		return R37_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR37_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r37_EXPOSURE_RESIDENT_NON_UAE) {
		R37_EXPOSURE_RESIDENT_NON_UAE = r37_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR37_CRWA_RESIDENT_NON_UAE() {
		return R37_CRWA_RESIDENT_NON_UAE;
	}
	public void setR37_CRWA_RESIDENT_NON_UAE(BigDecimal r37_CRWA_RESIDENT_NON_UAE) {
		R37_CRWA_RESIDENT_NON_UAE = r37_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR37_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R37_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR37_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r37_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R37_EXPOSURE_NON_RESIDENT_NON_UAE = r37_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR37_CRWA_NON_RESIDENT_NON_UAE() {
		return R37_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR37_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r37_CRWA_NON_RESIDENT_NON_UAE) {
		R37_CRWA_NON_RESIDENT_NON_UAE = r37_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR37_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R37_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR37_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r37_EXPOSURE_INSIDE_CONSOLIDATED) {
		R37_EXPOSURE_INSIDE_CONSOLIDATED = r37_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR37_CRWA_INSIDE_CONSOLIDATED() {
		return R37_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR37_CRWA_INSIDE_CONSOLIDATED(BigDecimal r37_CRWA_INSIDE_CONSOLIDATED) {
		R37_CRWA_INSIDE_CONSOLIDATED = r37_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR37_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R37_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR37_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r37_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R37_EXPOSURE_OUTSIDE_CONSOLIDATED = r37_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR37_CRWA_OUTSIDE_CONSOLIDATED() {
		return R37_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR37_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r37_CRWA_OUTSIDE_CONSOLIDATED) {
		R37_CRWA_OUTSIDE_CONSOLIDATED = r37_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR37_NON_PERFORMING() {
		return R37_NON_PERFORMING;
	}
	public void setR37_NON_PERFORMING(BigDecimal r37_NON_PERFORMING) {
		R37_NON_PERFORMING = r37_NON_PERFORMING;
	}
	public BigDecimal getR37_SPECIFIC_PROVISION() {
		return R37_SPECIFIC_PROVISION;
	}
	public void setR37_SPECIFIC_PROVISION(BigDecimal r37_SPECIFIC_PROVISION) {
		R37_SPECIFIC_PROVISION = r37_SPECIFIC_PROVISION;
	}
	public BigDecimal getR37_INTEREST() {
		return R37_INTEREST;
	}
	public void setR37_INTEREST(BigDecimal r37_INTEREST) {
		R37_INTEREST = r37_INTEREST;
	}
	public BigDecimal getR37_DEFAULTED() {
		return R37_DEFAULTED;
	}
	public void setR37_DEFAULTED(BigDecimal r37_DEFAULTED) {
		R37_DEFAULTED = r37_DEFAULTED;
	}
	public String getR38_S_NO() {
		return R38_S_NO;
	}
	public void setR38_S_NO(String r38_S_NO) {
		R38_S_NO = r38_S_NO;
	}
	public String getR38_AMOUNT() {
		return R38_AMOUNT;
	}
	public void setR38_AMOUNT(String r38_AMOUNT) {
		R38_AMOUNT = r38_AMOUNT;
	}
	public BigDecimal getR38_TOTAL_CONSOLIDATED() {
		return R38_TOTAL_CONSOLIDATED;
	}
	public void setR38_TOTAL_CONSOLIDATED(BigDecimal r38_TOTAL_CONSOLIDATED) {
		R38_TOTAL_CONSOLIDATED = r38_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR38_CRWA_CONSOLIDATED() {
		return R38_CRWA_CONSOLIDATED;
	}
	public void setR38_CRWA_CONSOLIDATED(BigDecimal r38_CRWA_CONSOLIDATED) {
		R38_CRWA_CONSOLIDATED = r38_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR38_EXPOSURE_RESIDENT_UAE() {
		return R38_EXPOSURE_RESIDENT_UAE;
	}
	public void setR38_EXPOSURE_RESIDENT_UAE(BigDecimal r38_EXPOSURE_RESIDENT_UAE) {
		R38_EXPOSURE_RESIDENT_UAE = r38_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR38_CRWA_RESIDENT_UAE() {
		return R38_CRWA_RESIDENT_UAE;
	}
	public void setR38_CRWA_RESIDENT_UAE(BigDecimal r38_CRWA_RESIDENT_UAE) {
		R38_CRWA_RESIDENT_UAE = r38_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR38_EXPOSURE_NON_RESIDENT_UAE() {
		return R38_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR38_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r38_EXPOSURE_NON_RESIDENT_UAE) {
		R38_EXPOSURE_NON_RESIDENT_UAE = r38_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR38_CRWA_NON_RESIDENT_UAE() {
		return R38_CRWA_NON_RESIDENT_UAE;
	}
	public void setR38_CRWA_NON_RESIDENT_UAE(BigDecimal r38_CRWA_NON_RESIDENT_UAE) {
		R38_CRWA_NON_RESIDENT_UAE = r38_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR38_EXPOSURE_RESIDENT_NON_UAE() {
		return R38_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR38_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r38_EXPOSURE_RESIDENT_NON_UAE) {
		R38_EXPOSURE_RESIDENT_NON_UAE = r38_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR38_CRWA_RESIDENT_NON_UAE() {
		return R38_CRWA_RESIDENT_NON_UAE;
	}
	public void setR38_CRWA_RESIDENT_NON_UAE(BigDecimal r38_CRWA_RESIDENT_NON_UAE) {
		R38_CRWA_RESIDENT_NON_UAE = r38_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR38_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R38_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR38_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r38_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R38_EXPOSURE_NON_RESIDENT_NON_UAE = r38_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR38_CRWA_NON_RESIDENT_NON_UAE() {
		return R38_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR38_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r38_CRWA_NON_RESIDENT_NON_UAE) {
		R38_CRWA_NON_RESIDENT_NON_UAE = r38_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR38_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R38_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR38_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r38_EXPOSURE_INSIDE_CONSOLIDATED) {
		R38_EXPOSURE_INSIDE_CONSOLIDATED = r38_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR38_CRWA_INSIDE_CONSOLIDATED() {
		return R38_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR38_CRWA_INSIDE_CONSOLIDATED(BigDecimal r38_CRWA_INSIDE_CONSOLIDATED) {
		R38_CRWA_INSIDE_CONSOLIDATED = r38_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR38_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R38_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR38_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r38_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R38_EXPOSURE_OUTSIDE_CONSOLIDATED = r38_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR38_CRWA_OUTSIDE_CONSOLIDATED() {
		return R38_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR38_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r38_CRWA_OUTSIDE_CONSOLIDATED) {
		R38_CRWA_OUTSIDE_CONSOLIDATED = r38_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR38_NON_PERFORMING() {
		return R38_NON_PERFORMING;
	}
	public void setR38_NON_PERFORMING(BigDecimal r38_NON_PERFORMING) {
		R38_NON_PERFORMING = r38_NON_PERFORMING;
	}
	public BigDecimal getR38_SPECIFIC_PROVISION() {
		return R38_SPECIFIC_PROVISION;
	}
	public void setR38_SPECIFIC_PROVISION(BigDecimal r38_SPECIFIC_PROVISION) {
		R38_SPECIFIC_PROVISION = r38_SPECIFIC_PROVISION;
	}
	public BigDecimal getR38_INTEREST() {
		return R38_INTEREST;
	}
	public void setR38_INTEREST(BigDecimal r38_INTEREST) {
		R38_INTEREST = r38_INTEREST;
	}
	public BigDecimal getR38_DEFAULTED() {
		return R38_DEFAULTED;
	}
	public void setR38_DEFAULTED(BigDecimal r38_DEFAULTED) {
		R38_DEFAULTED = r38_DEFAULTED;
	}
	public String getR39_S_NO() {
		return R39_S_NO;
	}
	public void setR39_S_NO(String r39_S_NO) {
		R39_S_NO = r39_S_NO;
	}
	public String getR39_AMOUNT() {
		return R39_AMOUNT;
	}
	public void setR39_AMOUNT(String r39_AMOUNT) {
		R39_AMOUNT = r39_AMOUNT;
	}
	public BigDecimal getR39_TOTAL_CONSOLIDATED() {
		return R39_TOTAL_CONSOLIDATED;
	}
	public void setR39_TOTAL_CONSOLIDATED(BigDecimal r39_TOTAL_CONSOLIDATED) {
		R39_TOTAL_CONSOLIDATED = r39_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR39_CRWA_CONSOLIDATED() {
		return R39_CRWA_CONSOLIDATED;
	}
	public void setR39_CRWA_CONSOLIDATED(BigDecimal r39_CRWA_CONSOLIDATED) {
		R39_CRWA_CONSOLIDATED = r39_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR39_EXPOSURE_RESIDENT_UAE() {
		return R39_EXPOSURE_RESIDENT_UAE;
	}
	public void setR39_EXPOSURE_RESIDENT_UAE(BigDecimal r39_EXPOSURE_RESIDENT_UAE) {
		R39_EXPOSURE_RESIDENT_UAE = r39_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR39_CRWA_RESIDENT_UAE() {
		return R39_CRWA_RESIDENT_UAE;
	}
	public void setR39_CRWA_RESIDENT_UAE(BigDecimal r39_CRWA_RESIDENT_UAE) {
		R39_CRWA_RESIDENT_UAE = r39_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR39_EXPOSURE_NON_RESIDENT_UAE() {
		return R39_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR39_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r39_EXPOSURE_NON_RESIDENT_UAE) {
		R39_EXPOSURE_NON_RESIDENT_UAE = r39_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR39_CRWA_NON_RESIDENT_UAE() {
		return R39_CRWA_NON_RESIDENT_UAE;
	}
	public void setR39_CRWA_NON_RESIDENT_UAE(BigDecimal r39_CRWA_NON_RESIDENT_UAE) {
		R39_CRWA_NON_RESIDENT_UAE = r39_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR39_EXPOSURE_RESIDENT_NON_UAE() {
		return R39_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR39_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r39_EXPOSURE_RESIDENT_NON_UAE) {
		R39_EXPOSURE_RESIDENT_NON_UAE = r39_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR39_CRWA_RESIDENT_NON_UAE() {
		return R39_CRWA_RESIDENT_NON_UAE;
	}
	public void setR39_CRWA_RESIDENT_NON_UAE(BigDecimal r39_CRWA_RESIDENT_NON_UAE) {
		R39_CRWA_RESIDENT_NON_UAE = r39_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR39_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R39_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR39_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r39_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R39_EXPOSURE_NON_RESIDENT_NON_UAE = r39_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR39_CRWA_NON_RESIDENT_NON_UAE() {
		return R39_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR39_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r39_CRWA_NON_RESIDENT_NON_UAE) {
		R39_CRWA_NON_RESIDENT_NON_UAE = r39_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR39_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R39_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR39_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r39_EXPOSURE_INSIDE_CONSOLIDATED) {
		R39_EXPOSURE_INSIDE_CONSOLIDATED = r39_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR39_CRWA_INSIDE_CONSOLIDATED() {
		return R39_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR39_CRWA_INSIDE_CONSOLIDATED(BigDecimal r39_CRWA_INSIDE_CONSOLIDATED) {
		R39_CRWA_INSIDE_CONSOLIDATED = r39_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR39_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R39_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR39_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r39_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R39_EXPOSURE_OUTSIDE_CONSOLIDATED = r39_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR39_CRWA_OUTSIDE_CONSOLIDATED() {
		return R39_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR39_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r39_CRWA_OUTSIDE_CONSOLIDATED) {
		R39_CRWA_OUTSIDE_CONSOLIDATED = r39_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR39_NON_PERFORMING() {
		return R39_NON_PERFORMING;
	}
	public void setR39_NON_PERFORMING(BigDecimal r39_NON_PERFORMING) {
		R39_NON_PERFORMING = r39_NON_PERFORMING;
	}
	public BigDecimal getR39_SPECIFIC_PROVISION() {
		return R39_SPECIFIC_PROVISION;
	}
	public void setR39_SPECIFIC_PROVISION(BigDecimal r39_SPECIFIC_PROVISION) {
		R39_SPECIFIC_PROVISION = r39_SPECIFIC_PROVISION;
	}
	public BigDecimal getR39_INTEREST() {
		return R39_INTEREST;
	}
	public void setR39_INTEREST(BigDecimal r39_INTEREST) {
		R39_INTEREST = r39_INTEREST;
	}
	public BigDecimal getR39_DEFAULTED() {
		return R39_DEFAULTED;
	}
	public void setR39_DEFAULTED(BigDecimal r39_DEFAULTED) {
		R39_DEFAULTED = r39_DEFAULTED;
	}
	public String getR40_S_NO() {
		return R40_S_NO;
	}
	public void setR40_S_NO(String r40_S_NO) {
		R40_S_NO = r40_S_NO;
	}
	public String getR40_AMOUNT() {
		return R40_AMOUNT;
	}
	public void setR40_AMOUNT(String r40_AMOUNT) {
		R40_AMOUNT = r40_AMOUNT;
	}
	public BigDecimal getR40_TOTAL_CONSOLIDATED() {
		return R40_TOTAL_CONSOLIDATED;
	}
	public void setR40_TOTAL_CONSOLIDATED(BigDecimal r40_TOTAL_CONSOLIDATED) {
		R40_TOTAL_CONSOLIDATED = r40_TOTAL_CONSOLIDATED;
	}
	public BigDecimal getR40_CRWA_CONSOLIDATED() {
		return R40_CRWA_CONSOLIDATED;
	}
	public void setR40_CRWA_CONSOLIDATED(BigDecimal r40_CRWA_CONSOLIDATED) {
		R40_CRWA_CONSOLIDATED = r40_CRWA_CONSOLIDATED;
	}
	public BigDecimal getR40_EXPOSURE_RESIDENT_UAE() {
		return R40_EXPOSURE_RESIDENT_UAE;
	}
	public void setR40_EXPOSURE_RESIDENT_UAE(BigDecimal r40_EXPOSURE_RESIDENT_UAE) {
		R40_EXPOSURE_RESIDENT_UAE = r40_EXPOSURE_RESIDENT_UAE;
	}
	public BigDecimal getR40_CRWA_RESIDENT_UAE() {
		return R40_CRWA_RESIDENT_UAE;
	}
	public void setR40_CRWA_RESIDENT_UAE(BigDecimal r40_CRWA_RESIDENT_UAE) {
		R40_CRWA_RESIDENT_UAE = r40_CRWA_RESIDENT_UAE;
	}
	public BigDecimal getR40_EXPOSURE_NON_RESIDENT_UAE() {
		return R40_EXPOSURE_NON_RESIDENT_UAE;
	}
	public void setR40_EXPOSURE_NON_RESIDENT_UAE(BigDecimal r40_EXPOSURE_NON_RESIDENT_UAE) {
		R40_EXPOSURE_NON_RESIDENT_UAE = r40_EXPOSURE_NON_RESIDENT_UAE;
	}
	public BigDecimal getR40_CRWA_NON_RESIDENT_UAE() {
		return R40_CRWA_NON_RESIDENT_UAE;
	}
	public void setR40_CRWA_NON_RESIDENT_UAE(BigDecimal r40_CRWA_NON_RESIDENT_UAE) {
		R40_CRWA_NON_RESIDENT_UAE = r40_CRWA_NON_RESIDENT_UAE;
	}
	public BigDecimal getR40_EXPOSURE_RESIDENT_NON_UAE() {
		return R40_EXPOSURE_RESIDENT_NON_UAE;
	}
	public void setR40_EXPOSURE_RESIDENT_NON_UAE(BigDecimal r40_EXPOSURE_RESIDENT_NON_UAE) {
		R40_EXPOSURE_RESIDENT_NON_UAE = r40_EXPOSURE_RESIDENT_NON_UAE;
	}
	public BigDecimal getR40_CRWA_RESIDENT_NON_UAE() {
		return R40_CRWA_RESIDENT_NON_UAE;
	}
	public void setR40_CRWA_RESIDENT_NON_UAE(BigDecimal r40_CRWA_RESIDENT_NON_UAE) {
		R40_CRWA_RESIDENT_NON_UAE = r40_CRWA_RESIDENT_NON_UAE;
	}
	public BigDecimal getR40_EXPOSURE_NON_RESIDENT_NON_UAE() {
		return R40_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public void setR40_EXPOSURE_NON_RESIDENT_NON_UAE(BigDecimal r40_EXPOSURE_NON_RESIDENT_NON_UAE) {
		R40_EXPOSURE_NON_RESIDENT_NON_UAE = r40_EXPOSURE_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR40_CRWA_NON_RESIDENT_NON_UAE() {
		return R40_CRWA_NON_RESIDENT_NON_UAE;
	}
	public void setR40_CRWA_NON_RESIDENT_NON_UAE(BigDecimal r40_CRWA_NON_RESIDENT_NON_UAE) {
		R40_CRWA_NON_RESIDENT_NON_UAE = r40_CRWA_NON_RESIDENT_NON_UAE;
	}
	public BigDecimal getR40_EXPOSURE_INSIDE_CONSOLIDATED() {
		return R40_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public void setR40_EXPOSURE_INSIDE_CONSOLIDATED(BigDecimal r40_EXPOSURE_INSIDE_CONSOLIDATED) {
		R40_EXPOSURE_INSIDE_CONSOLIDATED = r40_EXPOSURE_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR40_CRWA_INSIDE_CONSOLIDATED() {
		return R40_CRWA_INSIDE_CONSOLIDATED;
	}
	public void setR40_CRWA_INSIDE_CONSOLIDATED(BigDecimal r40_CRWA_INSIDE_CONSOLIDATED) {
		R40_CRWA_INSIDE_CONSOLIDATED = r40_CRWA_INSIDE_CONSOLIDATED;
	}
	public BigDecimal getR40_EXPOSURE_OUTSIDE_CONSOLIDATED() {
		return R40_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public void setR40_EXPOSURE_OUTSIDE_CONSOLIDATED(BigDecimal r40_EXPOSURE_OUTSIDE_CONSOLIDATED) {
		R40_EXPOSURE_OUTSIDE_CONSOLIDATED = r40_EXPOSURE_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR40_CRWA_OUTSIDE_CONSOLIDATED() {
		return R40_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public void setR40_CRWA_OUTSIDE_CONSOLIDATED(BigDecimal r40_CRWA_OUTSIDE_CONSOLIDATED) {
		R40_CRWA_OUTSIDE_CONSOLIDATED = r40_CRWA_OUTSIDE_CONSOLIDATED;
	}
	public BigDecimal getR40_NON_PERFORMING() {
		return R40_NON_PERFORMING;
	}
	public void setR40_NON_PERFORMING(BigDecimal r40_NON_PERFORMING) {
		R40_NON_PERFORMING = r40_NON_PERFORMING;
	}
	public BigDecimal getR40_SPECIFIC_PROVISION() {
		return R40_SPECIFIC_PROVISION;
	}
	public void setR40_SPECIFIC_PROVISION(BigDecimal r40_SPECIFIC_PROVISION) {
		R40_SPECIFIC_PROVISION = r40_SPECIFIC_PROVISION;
	}
	public BigDecimal getR40_INTEREST() {
		return R40_INTEREST;
	}
	public void setR40_INTEREST(BigDecimal r40_INTEREST) {
		R40_INTEREST = r40_INTEREST;
	}
	public BigDecimal getR40_DEFAULTED() {
		return R40_DEFAULTED;
	}
	public void setR40_DEFAULTED(BigDecimal r40_DEFAULTED) {
		R40_DEFAULTED = r40_DEFAULTED;
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
	public BRF105_ENTITY1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}