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
@Table(name="BRF106_SUMMARYTABLE")
public class BRF_106_A_REPORT_ENTITY {
	private String	R1_S_NO    ;
	private String	R1_STAGES   ;
	private BigDecimal	R1_OUTSTANDING_CASH    ;
	private BigDecimal	R1_PROVISION_CASH ;
	private BigDecimal	R1_OUTSTANDING_BALANCE ;
	private BigDecimal	R1_PROVISION_BALANCE ;
	private BigDecimal	R1_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R1_PROVISION_NON_BANKING ;
	private BigDecimal	R1_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R1_PROVISION_INVESTMENT ;
	private BigDecimal	R1_OUTSTANDING_TRADE ;
	private BigDecimal	R1_PROVISION_TRADE ;
	private BigDecimal	R1_OUTSTANDING_LOAN ;
	private BigDecimal	R1_PROVISION_LOAN ;
	private BigDecimal	R1_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R1_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R1_OUTSTANDING_TOTAL ;
	private BigDecimal	R1_PROVISION_TOTAL ;
	private BigDecimal	R1_INTERESTS ;
	private BigDecimal	R1_EXPOSURE ;
	private BigDecimal	R1_UNFUNDED ;
	private BigDecimal	R1_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R1_PROVISION_UNFUNDED ;
	private String	R2_S_NO    ;
	private String	R2_STAGES   ;
	private BigDecimal	R2_OUTSTANDING_CASH    ;
	private BigDecimal	R2_PROVISION_CASH ;
	private BigDecimal	R2_OUTSTANDING_BALANCE ;
	private BigDecimal	R2_PROVISION_BALANCE ;
	private BigDecimal	R2_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R2_PROVISION_NON_BANKING ;
	private BigDecimal	R2_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R2_PROVISION_INVESTMENT ;
	private BigDecimal	R2_OUTSTANDING_TRADE ;
	private BigDecimal	R2_PROVISION_TRADE ;
	private BigDecimal	R2_OUTSTANDING_LOAN ;
	private BigDecimal	R2_PROVISION_LOAN ;
	private BigDecimal	R2_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R2_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R2_OUTSTANDING_TOTAL ;
	private BigDecimal	R2_PROVISION_TOTAL ;
	private BigDecimal	R2_INTERESTS ;
	private BigDecimal	R2_EXPOSURE ;
	private BigDecimal	R2_UNFUNDED ;
	private BigDecimal	R2_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R2_PROVISION_UNFUNDED ;
	private String	R3_S_NO    ;
	private String	R3_STAGES   ;
	private BigDecimal	R3_OUTSTANDING_CASH    ;
	private BigDecimal	R3_PROVISION_CASH ;
	private BigDecimal	R3_OUTSTANDING_BALANCE ;
	private BigDecimal	R3_PROVISION_BALANCE ;
	private BigDecimal	R3_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R3_PROVISION_NON_BANKING ;
	private BigDecimal	R3_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R3_PROVISION_INVESTMENT ;
	private BigDecimal	R3_OUTSTANDING_TRADE ;
	private BigDecimal	R3_PROVISION_TRADE ;
	private BigDecimal	R3_OUTSTANDING_LOAN ;
	private BigDecimal	R3_PROVISION_LOAN ;
	private BigDecimal	R3_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R3_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R3_OUTSTANDING_TOTAL ;
	private BigDecimal	R3_PROVISION_TOTAL ;
	private BigDecimal	R3_INTERESTS ;
	private BigDecimal	R3_EXPOSURE ;
	private BigDecimal	R3_UNFUNDED ;
	private BigDecimal	R3_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R3_PROVISION_UNFUNDED ;
	private String	R4_S_NO    ;
	private String	R4_STAGES   ;
	private BigDecimal	R4_OUTSTANDING_CASH    ;
	private BigDecimal	R4_PROVISION_CASH ;
	private BigDecimal	R4_OUTSTANDING_BALANCE ;
	private BigDecimal	R4_PROVISION_BALANCE ;
	private BigDecimal	R4_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R4_PROVISION_NON_BANKING ;
	private BigDecimal	R4_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R4_PROVISION_INVESTMENT ;
	private BigDecimal	R4_OUTSTANDING_TRADE ;
	private BigDecimal	R4_PROVISION_TRADE ;
	private BigDecimal	R4_OUTSTANDING_LOAN ;
	private BigDecimal	R4_PROVISION_LOAN ;
	private BigDecimal	R4_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R4_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R4_OUTSTANDING_TOTAL ;
	private BigDecimal	R4_PROVISION_TOTAL ;
	private BigDecimal	R4_INTERESTS ;
	private BigDecimal	R4_EXPOSURE ;
	private BigDecimal	R4_UNFUNDED ;
	private BigDecimal	R4_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R4_PROVISION_UNFUNDED ;
	private String	R5_S_NO    ;
	private String	R5_STAGES   ;
	private BigDecimal	R5_OUTSTANDING_CASH    ;
	private BigDecimal	R5_PROVISION_CASH ;
	private BigDecimal	R5_OUTSTANDING_BALANCE ;
	private BigDecimal	R5_PROVISION_BALANCE ;
	private BigDecimal	R5_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R5_PROVISION_NON_BANKING ;
	private BigDecimal	R5_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R5_PROVISION_INVESTMENT ;
	private BigDecimal	R5_OUTSTANDING_TRADE ;
	private BigDecimal	R5_PROVISION_TRADE ;
	private BigDecimal	R5_OUTSTANDING_LOAN ;
	private BigDecimal	R5_PROVISION_LOAN ;
	private BigDecimal	R5_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R5_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R5_OUTSTANDING_TOTAL ;
	private BigDecimal	R5_PROVISION_TOTAL ;
	private BigDecimal	R5_INTERESTS ;
	private BigDecimal	R5_EXPOSURE ;
	private BigDecimal	R5_UNFUNDED ;
	private BigDecimal	R5_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R5_PROVISION_UNFUNDED ;
	private String	R6_S_NO    ;
	private String	R6_STAGES   ;
	private BigDecimal	R6_OUTSTANDING_CASH    ;
	private BigDecimal	R6_PROVISION_CASH ;
	private BigDecimal	R6_OUTSTANDING_BALANCE ;
	private BigDecimal	R6_PROVISION_BALANCE ;
	private BigDecimal	R6_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R6_PROVISION_NON_BANKING ;
	private BigDecimal	R6_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R6_PROVISION_INVESTMENT ;
	private BigDecimal	R6_OUTSTANDING_TRADE ;
	private BigDecimal	R6_PROVISION_TRADE ;
	private BigDecimal	R6_OUTSTANDING_LOAN ;
	private BigDecimal	R6_PROVISION_LOAN ;
	private BigDecimal	R6_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R6_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R6_OUTSTANDING_TOTAL ;
	private BigDecimal	R6_PROVISION_TOTAL ;
	private BigDecimal	R6_INTERESTS ;
	private BigDecimal	R6_EXPOSURE ;
	private BigDecimal	R6_UNFUNDED ;
	private BigDecimal	R6_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R6_PROVISION_UNFUNDED ;
	private String	R7_S_NO    ;
	private String	R7_STAGES   ;
	private BigDecimal	R7_OUTSTANDING_CASH    ;
	private BigDecimal	R7_PROVISION_CASH ;
	private BigDecimal	R7_OUTSTANDING_BALANCE ;
	private BigDecimal	R7_PROVISION_BALANCE ;
	private BigDecimal	R7_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R7_PROVISION_NON_BANKING ;
	private BigDecimal	R7_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R7_PROVISION_INVESTMENT ;
	private BigDecimal	R7_OUTSTANDING_TRADE ;
	private BigDecimal	R7_PROVISION_TRADE ;
	private BigDecimal	R7_OUTSTANDING_LOAN ;
	private BigDecimal	R7_PROVISION_LOAN ;
	private BigDecimal	R7_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R7_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R7_OUTSTANDING_TOTAL ;
	private BigDecimal	R7_PROVISION_TOTAL ;
	private BigDecimal	R7_INTERESTS ;
	private BigDecimal	R7_EXPOSURE ;
	private BigDecimal	R7_UNFUNDED ;
	private BigDecimal	R7_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R7_PROVISION_UNFUNDED ;
	private String	R8_S_NO    ;
	private String	R8_STAGES   ;
	private BigDecimal	R8_OUTSTANDING_CASH    ;
	private BigDecimal	R8_PROVISION_CASH ;
	private BigDecimal	R8_OUTSTANDING_BALANCE ;
	private BigDecimal	R8_PROVISION_BALANCE ;
	private BigDecimal	R8_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R8_PROVISION_NON_BANKING ;
	private BigDecimal	R8_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R8_PROVISION_INVESTMENT ;
	private BigDecimal	R8_OUTSTANDING_TRADE ;
	private BigDecimal	R8_PROVISION_TRADE ;
	private BigDecimal	R8_OUTSTANDING_LOAN ;
	private BigDecimal	R8_PROVISION_LOAN ;
	private BigDecimal	R8_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R8_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R8_OUTSTANDING_TOTAL ;
	private BigDecimal	R8_PROVISION_TOTAL ;
	private BigDecimal	R8_INTERESTS ;
	private BigDecimal	R8_EXPOSURE ;
	private BigDecimal	R8_UNFUNDED ;
	private BigDecimal	R8_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R8_PROVISION_UNFUNDED ;
	private String	R9_S_NO    ;
	private String	R9_STAGES   ;
	private BigDecimal	R9_OUTSTANDING_CASH    ;
	private BigDecimal	R9_PROVISION_CASH ;
	private BigDecimal	R9_OUTSTANDING_BALANCE ;
	private BigDecimal	R9_PROVISION_BALANCE ;
	private BigDecimal	R9_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R9_PROVISION_NON_BANKING ;
	private BigDecimal	R9_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R9_PROVISION_INVESTMENT ;
	private BigDecimal	R9_OUTSTANDING_TRADE ;
	private BigDecimal	R9_PROVISION_TRADE ;
	private BigDecimal	R9_OUTSTANDING_LOAN ;
	private BigDecimal	R9_PROVISION_LOAN ;
	private BigDecimal	R9_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R9_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R9_OUTSTANDING_TOTAL ;
	private BigDecimal	R9_PROVISION_TOTAL ;
	private BigDecimal	R9_INTERESTS ;
	private BigDecimal	R9_EXPOSURE ;
	private BigDecimal	R9_UNFUNDED ;
	private BigDecimal	R9_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R9_PROVISION_UNFUNDED ;
	private String	R10_S_NO    ;
	private String	R10_STAGES   ;
	private BigDecimal	R10_OUTSTANDING_CASH    ;
	private BigDecimal	R10_PROVISION_CASH ;
	private BigDecimal	R10_OUTSTANDING_BALANCE ;
	private BigDecimal	R10_PROVISION_BALANCE ;
	private BigDecimal	R10_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R10_PROVISION_NON_BANKING ;
	private BigDecimal	R10_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R10_PROVISION_INVESTMENT ;
	private BigDecimal	R10_OUTSTANDING_TRADE ;
	private BigDecimal	R10_PROVISION_TRADE ;
	private BigDecimal	R10_OUTSTANDING_LOAN ;
	private BigDecimal	R10_PROVISION_LOAN ;
	private BigDecimal	R10_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R10_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R10_OUTSTANDING_TOTAL ;
	private BigDecimal	R10_PROVISION_TOTAL ;
	private BigDecimal	R10_INTERESTS ;
	private BigDecimal	R10_EXPOSURE ;
	private BigDecimal	R10_UNFUNDED ;
	private BigDecimal	R10_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R10_PROVISION_UNFUNDED ;
	private String	R11_S_NO    ;
	private String	R11_STAGES   ;
	private BigDecimal	R11_OUTSTANDING_CASH    ;
	private BigDecimal	R11_PROVISION_CASH ;
	private BigDecimal	R11_OUTSTANDING_BALANCE ;
	private BigDecimal	R11_PROVISION_BALANCE ;
	private BigDecimal	R11_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R11_PROVISION_NON_BANKING ;
	private BigDecimal	R11_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R11_PROVISION_INVESTMENT ;
	private BigDecimal	R11_OUTSTANDING_TRADE ;
	private BigDecimal	R11_PROVISION_TRADE ;
	private BigDecimal	R11_OUTSTANDING_LOAN ;
	private BigDecimal	R11_PROVISION_LOAN ;
	private BigDecimal	R11_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R11_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R11_OUTSTANDING_TOTAL ;
	private BigDecimal	R11_PROVISION_TOTAL ;
	private BigDecimal	R11_INTERESTS ;
	private BigDecimal	R11_EXPOSURE ;
	private BigDecimal	R11_UNFUNDED ;
	private BigDecimal	R11_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R11_PROVISION_UNFUNDED ;
	private String	R12_S_NO    ;
	private String	R12_STAGES   ;
	private BigDecimal	R12_OUTSTANDING_CASH    ;
	private BigDecimal	R12_PROVISION_CASH ;
	private BigDecimal	R12_OUTSTANDING_BALANCE ;
	private BigDecimal	R12_PROVISION_BALANCE ;
	private BigDecimal	R12_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R12_PROVISION_NON_BANKING ;
	private BigDecimal	R12_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R12_PROVISION_INVESTMENT ;
	private BigDecimal	R12_OUTSTANDING_TRADE ;
	private BigDecimal	R12_PROVISION_TRADE ;
	private BigDecimal	R12_OUTSTANDING_LOAN ;
	private BigDecimal	R12_PROVISION_LOAN ;
	private BigDecimal	R12_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R12_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R12_OUTSTANDING_TOTAL ;
	private BigDecimal	R12_PROVISION_TOTAL ;
	private BigDecimal	R12_INTERESTS ;
	private BigDecimal	R12_EXPOSURE ;
	private BigDecimal	R12_UNFUNDED ;
	private BigDecimal	R12_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R12_PROVISION_UNFUNDED ;
	private String	R13_S_NO    ;
	private String	R13_STAGES   ;
	private BigDecimal	R13_OUTSTANDING_CASH    ;
	private BigDecimal	R13_PROVISION_CASH ;
	private BigDecimal	R13_OUTSTANDING_BALANCE ;
	private BigDecimal	R13_PROVISION_BALANCE ;
	private BigDecimal	R13_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R13_PROVISION_NON_BANKING ;
	private BigDecimal	R13_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R13_PROVISION_INVESTMENT ;
	private BigDecimal	R13_OUTSTANDING_TRADE ;
	private BigDecimal	R13_PROVISION_TRADE ;
	private BigDecimal	R13_OUTSTANDING_LOAN ;
	private BigDecimal	R13_PROVISION_LOAN ;
	private BigDecimal	R13_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R13_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R13_OUTSTANDING_TOTAL ;
	private BigDecimal	R13_PROVISION_TOTAL ;
	private BigDecimal	R13_INTERESTS ;
	private BigDecimal	R13_EXPOSURE ;
	private BigDecimal	R13_UNFUNDED ;
	private BigDecimal	R13_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R13_PROVISION_UNFUNDED ;
	private String	R14_S_NO    ;
	private String	R14_STAGES   ;
	private BigDecimal	R14_OUTSTANDING_CASH    ;
	private BigDecimal	R14_PROVISION_CASH ;
	private BigDecimal	R14_OUTSTANDING_BALANCE ;
	private BigDecimal	R14_PROVISION_BALANCE ;
	private BigDecimal	R14_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R14_PROVISION_NON_BANKING ;
	private BigDecimal	R14_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R14_PROVISION_INVESTMENT ;
	private BigDecimal	R14_OUTSTANDING_TRADE ;
	private BigDecimal	R14_PROVISION_TRADE ;
	private BigDecimal	R14_OUTSTANDING_LOAN ;
	private BigDecimal	R14_PROVISION_LOAN ;
	private BigDecimal	R14_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R14_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R14_OUTSTANDING_TOTAL ;
	private BigDecimal	R14_PROVISION_TOTAL ;
	private BigDecimal	R14_INTERESTS ;
	private BigDecimal	R14_EXPOSURE ;
	private BigDecimal	R14_UNFUNDED ;
	private BigDecimal	R14_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R14_PROVISION_UNFUNDED ;
	private String	R15_S_NO    ;
	private String	R15_STAGES   ;
	private BigDecimal	R15_OUTSTANDING_CASH    ;
	private BigDecimal	R15_PROVISION_CASH ;
	private BigDecimal	R15_OUTSTANDING_BALANCE ;
	private BigDecimal	R15_PROVISION_BALANCE ;
	private BigDecimal	R15_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R15_PROVISION_NON_BANKING ;
	private BigDecimal	R15_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R15_PROVISION_INVESTMENT ;
	private BigDecimal	R15_OUTSTANDING_TRADE ;
	private BigDecimal	R15_PROVISION_TRADE ;
	private BigDecimal	R15_OUTSTANDING_LOAN ;
	private BigDecimal	R15_PROVISION_LOAN ;
	private BigDecimal	R15_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R15_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R15_OUTSTANDING_TOTAL ;
	private BigDecimal	R15_PROVISION_TOTAL ;
	private BigDecimal	R15_INTERESTS ;
	private BigDecimal	R15_EXPOSURE ;
	private BigDecimal	R15_UNFUNDED ;
	private BigDecimal	R15_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R15_PROVISION_UNFUNDED ;
	private String	R16_S_NO    ;
	private String	R16_STAGES   ;
	private BigDecimal	R16_OUTSTANDING_CASH    ;
	private BigDecimal	R16_PROVISION_CASH ;
	private BigDecimal	R16_OUTSTANDING_BALANCE ;
	private BigDecimal	R16_PROVISION_BALANCE ;
	private BigDecimal	R16_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R16_PROVISION_NON_BANKING ;
	private BigDecimal	R16_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R16_PROVISION_INVESTMENT ;
	private BigDecimal	R16_OUTSTANDING_TRADE ;
	private BigDecimal	R16_PROVISION_TRADE ;
	private BigDecimal	R16_OUTSTANDING_LOAN ;
	private BigDecimal	R16_PROVISION_LOAN ;
	private BigDecimal	R16_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R16_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R16_OUTSTANDING_TOTAL ;
	private BigDecimal	R16_PROVISION_TOTAL ;
	private BigDecimal	R16_INTERESTS ;
	private BigDecimal	R16_EXPOSURE ;
	private BigDecimal	R16_UNFUNDED ;
	private BigDecimal	R16_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R16_PROVISION_UNFUNDED ;
	private String	R17_S_NO    ;
	private String	R17_STAGES   ;
	private BigDecimal	R17_OUTSTANDING_CASH    ;
	private BigDecimal	R17_PROVISION_CASH ;
	private BigDecimal	R17_OUTSTANDING_BALANCE ;
	private BigDecimal	R17_PROVISION_BALANCE ;
	private BigDecimal	R17_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R17_PROVISION_NON_BANKING ;
	private BigDecimal	R17_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R17_PROVISION_INVESTMENT ;
	private BigDecimal	R17_OUTSTANDING_TRADE ;
	private BigDecimal	R17_PROVISION_TRADE ;
	private BigDecimal	R17_OUTSTANDING_LOAN ;
	private BigDecimal	R17_PROVISION_LOAN ;
	private BigDecimal	R17_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R17_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R17_OUTSTANDING_TOTAL ;
	private BigDecimal	R17_PROVISION_TOTAL ;
	private BigDecimal	R17_INTERESTS ;
	private BigDecimal	R17_EXPOSURE ;
	private BigDecimal	R17_UNFUNDED ;
	private BigDecimal	R17_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R17_PROVISION_UNFUNDED ;
	private String	R18_S_NO    ;
	private String	R18_STAGES   ;
	private BigDecimal	R18_OUTSTANDING_CASH    ;
	private BigDecimal	R18_PROVISION_CASH ;
	private BigDecimal	R18_OUTSTANDING_BALANCE ;
	private BigDecimal	R18_PROVISION_BALANCE ;
	private BigDecimal	R18_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R18_PROVISION_NON_BANKING ;
	private BigDecimal	R18_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R18_PROVISION_INVESTMENT ;
	private BigDecimal	R18_OUTSTANDING_TRADE ;
	private BigDecimal	R18_PROVISION_TRADE ;
	private BigDecimal	R18_OUTSTANDING_LOAN ;
	private BigDecimal	R18_PROVISION_LOAN ;
	private BigDecimal	R18_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R18_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R18_OUTSTANDING_TOTAL ;
	private BigDecimal	R18_PROVISION_TOTAL ;
	private BigDecimal	R18_INTERESTS ;
	private BigDecimal	R18_EXPOSURE ;
	private BigDecimal	R18_UNFUNDED ;
	private BigDecimal	R18_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R18_PROVISION_UNFUNDED ;
	private String	R19_S_NO    ;
	private String	R19_STAGES   ;
	private BigDecimal	R19_OUTSTANDING_CASH    ;
	private BigDecimal	R19_PROVISION_CASH ;
	private BigDecimal	R19_OUTSTANDING_BALANCE ;
	private BigDecimal	R19_PROVISION_BALANCE ;
	private BigDecimal	R19_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R19_PROVISION_NON_BANKING ;
	private BigDecimal	R19_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R19_PROVISION_INVESTMENT ;
	private BigDecimal	R19_OUTSTANDING_TRADE ;
	private BigDecimal	R19_PROVISION_TRADE ;
	private BigDecimal	R19_OUTSTANDING_LOAN ;
	private BigDecimal	R19_PROVISION_LOAN ;
	private BigDecimal	R19_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R19_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R19_OUTSTANDING_TOTAL ;
	private BigDecimal	R19_PROVISION_TOTAL ;
	private BigDecimal	R19_INTERESTS ;
	private BigDecimal	R19_EXPOSURE ;
	private BigDecimal	R19_UNFUNDED ;
	private BigDecimal	R19_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R19_PROVISION_UNFUNDED ;
	private String	R20_S_NO    ;
	private String	R20_STAGES   ;
	private BigDecimal	R20_OUTSTANDING_CASH    ;
	private BigDecimal	R20_PROVISION_CASH ;
	private BigDecimal	R20_OUTSTANDING_BALANCE ;
	private BigDecimal	R20_PROVISION_BALANCE ;
	private BigDecimal	R20_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R20_PROVISION_NON_BANKING ;
	private BigDecimal	R20_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R20_PROVISION_INVESTMENT ;
	private BigDecimal	R20_OUTSTANDING_TRADE ;
	private BigDecimal	R20_PROVISION_TRADE ;
	private BigDecimal	R20_OUTSTANDING_LOAN ;
	private BigDecimal	R20_PROVISION_LOAN ;
	private BigDecimal	R20_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R20_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R20_OUTSTANDING_TOTAL ;
	private BigDecimal	R20_PROVISION_TOTAL ;
	private BigDecimal	R20_INTERESTS ;
	private BigDecimal	R20_EXPOSURE ;
	private BigDecimal	R20_UNFUNDED ;
	private BigDecimal	R20_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R20_PROVISION_UNFUNDED ;
	private String	R21_S_NO    ;
	private String	R21_STAGES   ;
	private BigDecimal	R21_OUTSTANDING_CASH    ;
	private BigDecimal	R21_PROVISION_CASH ;
	private BigDecimal	R21_OUTSTANDING_BALANCE ;
	private BigDecimal	R21_PROVISION_BALANCE ;
	private BigDecimal	R21_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R21_PROVISION_NON_BANKING ;
	private BigDecimal	R21_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R21_PROVISION_INVESTMENT ;
	private BigDecimal	R21_OUTSTANDING_TRADE ;
	private BigDecimal	R21_PROVISION_TRADE ;
	private BigDecimal	R21_OUTSTANDING_LOAN ;
	private BigDecimal	R21_PROVISION_LOAN ;
	private BigDecimal	R21_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R21_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R21_OUTSTANDING_TOTAL ;
	private BigDecimal	R21_PROVISION_TOTAL ;
	private BigDecimal	R21_INTERESTS ;
	private BigDecimal	R21_EXPOSURE ;
	private BigDecimal	R21_UNFUNDED ;
	private BigDecimal	R21_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R21_PROVISION_UNFUNDED ;
	private String	R22_S_NO    ;
	private String	R22_STAGES   ;
	private BigDecimal	R22_OUTSTANDING_CASH    ;
	private BigDecimal	R22_PROVISION_CASH ;
	private BigDecimal	R22_OUTSTANDING_BALANCE ;
	private BigDecimal	R22_PROVISION_BALANCE ;
	private BigDecimal	R22_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R22_PROVISION_NON_BANKING ;
	private BigDecimal	R22_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R22_PROVISION_INVESTMENT ;
	private BigDecimal	R22_OUTSTANDING_TRADE ;
	private BigDecimal	R22_PROVISION_TRADE ;
	private BigDecimal	R22_OUTSTANDING_LOAN ;
	private BigDecimal	R22_PROVISION_LOAN ;
	private BigDecimal	R22_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R22_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R22_OUTSTANDING_TOTAL ;
	private BigDecimal	R22_PROVISION_TOTAL ;
	private BigDecimal	R22_INTERESTS ;
	private BigDecimal	R22_EXPOSURE ;
	private BigDecimal	R22_UNFUNDED ;
	private BigDecimal	R22_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R22_PROVISION_UNFUNDED ;
	private String	R23_S_NO    ;
	private String	R23_STAGES   ;
	private BigDecimal	R23_OUTSTANDING_CASH    ;
	private BigDecimal	R23_PROVISION_CASH ;
	private BigDecimal	R23_OUTSTANDING_BALANCE ;
	private BigDecimal	R23_PROVISION_BALANCE ;
	private BigDecimal	R23_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R23_PROVISION_NON_BANKING ;
	private BigDecimal	R23_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R23_PROVISION_INVESTMENT ;
	private BigDecimal	R23_OUTSTANDING_TRADE ;
	private BigDecimal	R23_PROVISION_TRADE ;
	private BigDecimal	R23_OUTSTANDING_LOAN ;
	private BigDecimal	R23_PROVISION_LOAN ;
	private BigDecimal	R23_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R23_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R23_OUTSTANDING_TOTAL ;
	private BigDecimal	R23_PROVISION_TOTAL ;
	private BigDecimal	R23_INTERESTS ;
	private BigDecimal	R23_EXPOSURE ;
	private BigDecimal	R23_UNFUNDED ;
	private BigDecimal	R23_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R23_PROVISION_UNFUNDED ;
	private String	R24_S_NO    ;
	private String	R24_STAGES   ;
	private BigDecimal	R24_OUTSTANDING_CASH    ;
	private BigDecimal	R24_PROVISION_CASH ;
	private BigDecimal	R24_OUTSTANDING_BALANCE ;
	private BigDecimal	R24_PROVISION_BALANCE ;
	private BigDecimal	R24_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R24_PROVISION_NON_BANKING ;
	private BigDecimal	R24_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R24_PROVISION_INVESTMENT ;
	private BigDecimal	R24_OUTSTANDING_TRADE ;
	private BigDecimal	R24_PROVISION_TRADE ;
	private BigDecimal	R24_OUTSTANDING_LOAN ;
	private BigDecimal	R24_PROVISION_LOAN ;
	private BigDecimal	R24_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R24_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R24_OUTSTANDING_TOTAL ;
	private BigDecimal	R24_PROVISION_TOTAL ;
	private BigDecimal	R24_INTERESTS ;
	private BigDecimal	R24_EXPOSURE ;
	private BigDecimal	R24_UNFUNDED ;
	private BigDecimal	R24_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R24_PROVISION_UNFUNDED ;
	private String	R25_S_NO    ;
	private String	R25_STAGES   ;
	private BigDecimal	R25_OUTSTANDING_CASH    ;
	private BigDecimal	R25_PROVISION_CASH ;
	private BigDecimal	R25_OUTSTANDING_BALANCE ;
	private BigDecimal	R25_PROVISION_BALANCE ;
	private BigDecimal	R25_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R25_PROVISION_NON_BANKING ;
	private BigDecimal	R25_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R25_PROVISION_INVESTMENT ;
	private BigDecimal	R25_OUTSTANDING_TRADE ;
	private BigDecimal	R25_PROVISION_TRADE ;
	private BigDecimal	R25_OUTSTANDING_LOAN ;
	private BigDecimal	R25_PROVISION_LOAN ;
	private BigDecimal	R25_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R25_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R25_OUTSTANDING_TOTAL ;
	private BigDecimal	R25_PROVISION_TOTAL ;
	private BigDecimal	R25_INTERESTS ;
	private BigDecimal	R25_EXPOSURE ;
	private BigDecimal	R25_UNFUNDED ;
	private BigDecimal	R25_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R25_PROVISION_UNFUNDED ;
	private String	R26_S_NO    ;
	private String	R26_STAGES   ;
	private BigDecimal	R26_OUTSTANDING_CASH    ;
	private BigDecimal	R26_PROVISION_CASH ;
	private BigDecimal	R26_OUTSTANDING_BALANCE ;
	private BigDecimal	R26_PROVISION_BALANCE ;
	private BigDecimal	R26_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R26_PROVISION_NON_BANKING ;
	private BigDecimal	R26_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R26_PROVISION_INVESTMENT ;
	private BigDecimal	R26_OUTSTANDING_TRADE ;
	private BigDecimal	R26_PROVISION_TRADE ;
	private BigDecimal	R26_OUTSTANDING_LOAN ;
	private BigDecimal	R26_PROVISION_LOAN ;
	private BigDecimal	R26_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R26_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R26_OUTSTANDING_TOTAL ;
	private BigDecimal	R26_PROVISION_TOTAL ;
	private BigDecimal	R26_INTERESTS ;
	private BigDecimal	R26_EXPOSURE ;
	private BigDecimal	R26_UNFUNDED ;
	private BigDecimal	R26_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R26_PROVISION_UNFUNDED ;
	private String	R27_S_NO    ;
	private String	R27_STAGES   ;
	private BigDecimal	R27_OUTSTANDING_CASH    ;
	private BigDecimal	R27_PROVISION_CASH ;
	private BigDecimal	R27_OUTSTANDING_BALANCE ;
	private BigDecimal	R27_PROVISION_BALANCE ;
	private BigDecimal	R27_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R27_PROVISION_NON_BANKING ;
	private BigDecimal	R27_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R27_PROVISION_INVESTMENT ;
	private BigDecimal	R27_OUTSTANDING_TRADE ;
	private BigDecimal	R27_PROVISION_TRADE ;
	private BigDecimal	R27_OUTSTANDING_LOAN ;
	private BigDecimal	R27_PROVISION_LOAN ;
	private BigDecimal	R27_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R27_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R27_OUTSTANDING_TOTAL ;
	private BigDecimal	R27_PROVISION_TOTAL ;
	private BigDecimal	R27_INTERESTS ;
	private BigDecimal	R27_EXPOSURE ;
	private BigDecimal	R27_UNFUNDED ;
	private BigDecimal	R27_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R27_PROVISION_UNFUNDED ;
	private String	R28_S_NO    ;
	private String	R28_STAGES   ;
	private BigDecimal	R28_OUTSTANDING_CASH    ;
	private BigDecimal	R28_PROVISION_CASH ;
	private BigDecimal	R28_OUTSTANDING_BALANCE ;
	private BigDecimal	R28_PROVISION_BALANCE ;
	private BigDecimal	R28_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R28_PROVISION_NON_BANKING ;
	private BigDecimal	R28_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R28_PROVISION_INVESTMENT ;
	private BigDecimal	R28_OUTSTANDING_TRADE ;
	private BigDecimal	R28_PROVISION_TRADE ;
	private BigDecimal	R28_OUTSTANDING_LOAN ;
	private BigDecimal	R28_PROVISION_LOAN ;
	private BigDecimal	R28_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R28_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R28_OUTSTANDING_TOTAL ;
	private BigDecimal	R28_PROVISION_TOTAL ;
	private BigDecimal	R28_INTERESTS ;
	private BigDecimal	R28_EXPOSURE ;
	private BigDecimal	R28_UNFUNDED ;
	private BigDecimal	R28_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R28_PROVISION_UNFUNDED ;
	private String	R29_S_NO    ;
	private String	R29_STAGES   ;
	private BigDecimal	R29_OUTSTANDING_CASH    ;
	private BigDecimal	R29_PROVISION_CASH ;
	private BigDecimal	R29_OUTSTANDING_BALANCE ;
	private BigDecimal	R29_PROVISION_BALANCE ;
	private BigDecimal	R29_OUTSTANDING_NON_BANKING ;
	private BigDecimal	R29_PROVISION_NON_BANKING ;
	private BigDecimal	R29_OUTSTANDING_INVESTMENT ;
	private BigDecimal	R29_PROVISION_INVESTMENT ;
	private BigDecimal	R29_OUTSTANDING_TRADE ;
	private BigDecimal	R29_PROVISION_TRADE ;
	private BigDecimal	R29_OUTSTANDING_LOAN ;
	private BigDecimal	R29_PROVISION_LOAN ;
	private BigDecimal	R29_OUTSTANDING_OTHER_ASSETS ;
	private BigDecimal	R29_PROVISION_OTHER_ASSETS ;
	private BigDecimal	R29_OUTSTANDING_TOTAL ;
	private BigDecimal	R29_PROVISION_TOTAL ;
	private BigDecimal	R29_INTERESTS ;
	private BigDecimal	R29_EXPOSURE ;
	private BigDecimal	R29_UNFUNDED ;
	private BigDecimal	R29_OUTSTANDING_UNFUNDED ;
	private BigDecimal	R29_PROVISION_UNFUNDED ;
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
	public BigDecimal getR1_OUTSTANDING_CASH() {
		return R1_OUTSTANDING_CASH;
	}
	public void setR1_OUTSTANDING_CASH(BigDecimal r1_OUTSTANDING_CASH) {
		R1_OUTSTANDING_CASH = r1_OUTSTANDING_CASH;
	}
	public BigDecimal getR1_PROVISION_CASH() {
		return R1_PROVISION_CASH;
	}
	public void setR1_PROVISION_CASH(BigDecimal r1_PROVISION_CASH) {
		R1_PROVISION_CASH = r1_PROVISION_CASH;
	}
	public BigDecimal getR1_OUTSTANDING_BALANCE() {
		return R1_OUTSTANDING_BALANCE;
	}
	public void setR1_OUTSTANDING_BALANCE(BigDecimal r1_OUTSTANDING_BALANCE) {
		R1_OUTSTANDING_BALANCE = r1_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR1_PROVISION_BALANCE() {
		return R1_PROVISION_BALANCE;
	}
	public void setR1_PROVISION_BALANCE(BigDecimal r1_PROVISION_BALANCE) {
		R1_PROVISION_BALANCE = r1_PROVISION_BALANCE;
	}
	public BigDecimal getR1_OUTSTANDING_NON_BANKING() {
		return R1_OUTSTANDING_NON_BANKING;
	}
	public void setR1_OUTSTANDING_NON_BANKING(BigDecimal r1_OUTSTANDING_NON_BANKING) {
		R1_OUTSTANDING_NON_BANKING = r1_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR1_PROVISION_NON_BANKING() {
		return R1_PROVISION_NON_BANKING;
	}
	public void setR1_PROVISION_NON_BANKING(BigDecimal r1_PROVISION_NON_BANKING) {
		R1_PROVISION_NON_BANKING = r1_PROVISION_NON_BANKING;
	}
	public BigDecimal getR1_OUTSTANDING_INVESTMENT() {
		return R1_OUTSTANDING_INVESTMENT;
	}
	public void setR1_OUTSTANDING_INVESTMENT(BigDecimal r1_OUTSTANDING_INVESTMENT) {
		R1_OUTSTANDING_INVESTMENT = r1_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR1_PROVISION_INVESTMENT() {
		return R1_PROVISION_INVESTMENT;
	}
	public void setR1_PROVISION_INVESTMENT(BigDecimal r1_PROVISION_INVESTMENT) {
		R1_PROVISION_INVESTMENT = r1_PROVISION_INVESTMENT;
	}
	public BigDecimal getR1_OUTSTANDING_TRADE() {
		return R1_OUTSTANDING_TRADE;
	}
	public void setR1_OUTSTANDING_TRADE(BigDecimal r1_OUTSTANDING_TRADE) {
		R1_OUTSTANDING_TRADE = r1_OUTSTANDING_TRADE;
	}
	public BigDecimal getR1_PROVISION_TRADE() {
		return R1_PROVISION_TRADE;
	}
	public void setR1_PROVISION_TRADE(BigDecimal r1_PROVISION_TRADE) {
		R1_PROVISION_TRADE = r1_PROVISION_TRADE;
	}
	public BigDecimal getR1_OUTSTANDING_LOAN() {
		return R1_OUTSTANDING_LOAN;
	}
	public void setR1_OUTSTANDING_LOAN(BigDecimal r1_OUTSTANDING_LOAN) {
		R1_OUTSTANDING_LOAN = r1_OUTSTANDING_LOAN;
	}
	public BigDecimal getR1_PROVISION_LOAN() {
		return R1_PROVISION_LOAN;
	}
	public void setR1_PROVISION_LOAN(BigDecimal r1_PROVISION_LOAN) {
		R1_PROVISION_LOAN = r1_PROVISION_LOAN;
	}
	public BigDecimal getR1_OUTSTANDING_OTHER_ASSETS() {
		return R1_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR1_OUTSTANDING_OTHER_ASSETS(BigDecimal r1_OUTSTANDING_OTHER_ASSETS) {
		R1_OUTSTANDING_OTHER_ASSETS = r1_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR1_PROVISION_OTHER_ASSETS() {
		return R1_PROVISION_OTHER_ASSETS;
	}
	public void setR1_PROVISION_OTHER_ASSETS(BigDecimal r1_PROVISION_OTHER_ASSETS) {
		R1_PROVISION_OTHER_ASSETS = r1_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR1_OUTSTANDING_TOTAL() {
		return R1_OUTSTANDING_TOTAL;
	}
	public void setR1_OUTSTANDING_TOTAL(BigDecimal r1_OUTSTANDING_TOTAL) {
		R1_OUTSTANDING_TOTAL = r1_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR1_PROVISION_TOTAL() {
		return R1_PROVISION_TOTAL;
	}
	public void setR1_PROVISION_TOTAL(BigDecimal r1_PROVISION_TOTAL) {
		R1_PROVISION_TOTAL = r1_PROVISION_TOTAL;
	}
	public BigDecimal getR1_INTERESTS() {
		return R1_INTERESTS;
	}
	public void setR1_INTERESTS(BigDecimal r1_INTERESTS) {
		R1_INTERESTS = r1_INTERESTS;
	}
	public BigDecimal getR1_EXPOSURE() {
		return R1_EXPOSURE;
	}
	public void setR1_EXPOSURE(BigDecimal r1_EXPOSURE) {
		R1_EXPOSURE = r1_EXPOSURE;
	}
	public BigDecimal getR1_UNFUNDED() {
		return R1_UNFUNDED;
	}
	public void setR1_UNFUNDED(BigDecimal r1_UNFUNDED) {
		R1_UNFUNDED = r1_UNFUNDED;
	}
	public BigDecimal getR1_OUTSTANDING_UNFUNDED() {
		return R1_OUTSTANDING_UNFUNDED;
	}
	public void setR1_OUTSTANDING_UNFUNDED(BigDecimal r1_OUTSTANDING_UNFUNDED) {
		R1_OUTSTANDING_UNFUNDED = r1_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR1_PROVISION_UNFUNDED() {
		return R1_PROVISION_UNFUNDED;
	}
	public void setR1_PROVISION_UNFUNDED(BigDecimal r1_PROVISION_UNFUNDED) {
		R1_PROVISION_UNFUNDED = r1_PROVISION_UNFUNDED;
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
	public BigDecimal getR2_OUTSTANDING_CASH() {
		return R2_OUTSTANDING_CASH;
	}
	public void setR2_OUTSTANDING_CASH(BigDecimal r2_OUTSTANDING_CASH) {
		R2_OUTSTANDING_CASH = r2_OUTSTANDING_CASH;
	}
	public BigDecimal getR2_PROVISION_CASH() {
		return R2_PROVISION_CASH;
	}
	public void setR2_PROVISION_CASH(BigDecimal r2_PROVISION_CASH) {
		R2_PROVISION_CASH = r2_PROVISION_CASH;
	}
	public BigDecimal getR2_OUTSTANDING_BALANCE() {
		return R2_OUTSTANDING_BALANCE;
	}
	public void setR2_OUTSTANDING_BALANCE(BigDecimal r2_OUTSTANDING_BALANCE) {
		R2_OUTSTANDING_BALANCE = r2_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR2_PROVISION_BALANCE() {
		return R2_PROVISION_BALANCE;
	}
	public void setR2_PROVISION_BALANCE(BigDecimal r2_PROVISION_BALANCE) {
		R2_PROVISION_BALANCE = r2_PROVISION_BALANCE;
	}
	public BigDecimal getR2_OUTSTANDING_NON_BANKING() {
		return R2_OUTSTANDING_NON_BANKING;
	}
	public void setR2_OUTSTANDING_NON_BANKING(BigDecimal r2_OUTSTANDING_NON_BANKING) {
		R2_OUTSTANDING_NON_BANKING = r2_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR2_PROVISION_NON_BANKING() {
		return R2_PROVISION_NON_BANKING;
	}
	public void setR2_PROVISION_NON_BANKING(BigDecimal r2_PROVISION_NON_BANKING) {
		R2_PROVISION_NON_BANKING = r2_PROVISION_NON_BANKING;
	}
	public BigDecimal getR2_OUTSTANDING_INVESTMENT() {
		return R2_OUTSTANDING_INVESTMENT;
	}
	public void setR2_OUTSTANDING_INVESTMENT(BigDecimal r2_OUTSTANDING_INVESTMENT) {
		R2_OUTSTANDING_INVESTMENT = r2_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR2_PROVISION_INVESTMENT() {
		return R2_PROVISION_INVESTMENT;
	}
	public void setR2_PROVISION_INVESTMENT(BigDecimal r2_PROVISION_INVESTMENT) {
		R2_PROVISION_INVESTMENT = r2_PROVISION_INVESTMENT;
	}
	public BigDecimal getR2_OUTSTANDING_TRADE() {
		return R2_OUTSTANDING_TRADE;
	}
	public void setR2_OUTSTANDING_TRADE(BigDecimal r2_OUTSTANDING_TRADE) {
		R2_OUTSTANDING_TRADE = r2_OUTSTANDING_TRADE;
	}
	public BigDecimal getR2_PROVISION_TRADE() {
		return R2_PROVISION_TRADE;
	}
	public void setR2_PROVISION_TRADE(BigDecimal r2_PROVISION_TRADE) {
		R2_PROVISION_TRADE = r2_PROVISION_TRADE;
	}
	public BigDecimal getR2_OUTSTANDING_LOAN() {
		return R2_OUTSTANDING_LOAN;
	}
	public void setR2_OUTSTANDING_LOAN(BigDecimal r2_OUTSTANDING_LOAN) {
		R2_OUTSTANDING_LOAN = r2_OUTSTANDING_LOAN;
	}
	public BigDecimal getR2_PROVISION_LOAN() {
		return R2_PROVISION_LOAN;
	}
	public void setR2_PROVISION_LOAN(BigDecimal r2_PROVISION_LOAN) {
		R2_PROVISION_LOAN = r2_PROVISION_LOAN;
	}
	public BigDecimal getR2_OUTSTANDING_OTHER_ASSETS() {
		return R2_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR2_OUTSTANDING_OTHER_ASSETS(BigDecimal r2_OUTSTANDING_OTHER_ASSETS) {
		R2_OUTSTANDING_OTHER_ASSETS = r2_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR2_PROVISION_OTHER_ASSETS() {
		return R2_PROVISION_OTHER_ASSETS;
	}
	public void setR2_PROVISION_OTHER_ASSETS(BigDecimal r2_PROVISION_OTHER_ASSETS) {
		R2_PROVISION_OTHER_ASSETS = r2_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR2_OUTSTANDING_TOTAL() {
		return R2_OUTSTANDING_TOTAL;
	}
	public void setR2_OUTSTANDING_TOTAL(BigDecimal r2_OUTSTANDING_TOTAL) {
		R2_OUTSTANDING_TOTAL = r2_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR2_PROVISION_TOTAL() {
		return R2_PROVISION_TOTAL;
	}
	public void setR2_PROVISION_TOTAL(BigDecimal r2_PROVISION_TOTAL) {
		R2_PROVISION_TOTAL = r2_PROVISION_TOTAL;
	}
	public BigDecimal getR2_INTERESTS() {
		return R2_INTERESTS;
	}
	public void setR2_INTERESTS(BigDecimal r2_INTERESTS) {
		R2_INTERESTS = r2_INTERESTS;
	}
	public BigDecimal getR2_EXPOSURE() {
		return R2_EXPOSURE;
	}
	public void setR2_EXPOSURE(BigDecimal r2_EXPOSURE) {
		R2_EXPOSURE = r2_EXPOSURE;
	}
	public BigDecimal getR2_UNFUNDED() {
		return R2_UNFUNDED;
	}
	public void setR2_UNFUNDED(BigDecimal r2_UNFUNDED) {
		R2_UNFUNDED = r2_UNFUNDED;
	}
	public BigDecimal getR2_OUTSTANDING_UNFUNDED() {
		return R2_OUTSTANDING_UNFUNDED;
	}
	public void setR2_OUTSTANDING_UNFUNDED(BigDecimal r2_OUTSTANDING_UNFUNDED) {
		R2_OUTSTANDING_UNFUNDED = r2_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR2_PROVISION_UNFUNDED() {
		return R2_PROVISION_UNFUNDED;
	}
	public void setR2_PROVISION_UNFUNDED(BigDecimal r2_PROVISION_UNFUNDED) {
		R2_PROVISION_UNFUNDED = r2_PROVISION_UNFUNDED;
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
	public BigDecimal getR3_OUTSTANDING_CASH() {
		return R3_OUTSTANDING_CASH;
	}
	public void setR3_OUTSTANDING_CASH(BigDecimal r3_OUTSTANDING_CASH) {
		R3_OUTSTANDING_CASH = r3_OUTSTANDING_CASH;
	}
	public BigDecimal getR3_PROVISION_CASH() {
		return R3_PROVISION_CASH;
	}
	public void setR3_PROVISION_CASH(BigDecimal r3_PROVISION_CASH) {
		R3_PROVISION_CASH = r3_PROVISION_CASH;
	}
	public BigDecimal getR3_OUTSTANDING_BALANCE() {
		return R3_OUTSTANDING_BALANCE;
	}
	public void setR3_OUTSTANDING_BALANCE(BigDecimal r3_OUTSTANDING_BALANCE) {
		R3_OUTSTANDING_BALANCE = r3_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR3_PROVISION_BALANCE() {
		return R3_PROVISION_BALANCE;
	}
	public void setR3_PROVISION_BALANCE(BigDecimal r3_PROVISION_BALANCE) {
		R3_PROVISION_BALANCE = r3_PROVISION_BALANCE;
	}
	public BigDecimal getR3_OUTSTANDING_NON_BANKING() {
		return R3_OUTSTANDING_NON_BANKING;
	}
	public void setR3_OUTSTANDING_NON_BANKING(BigDecimal r3_OUTSTANDING_NON_BANKING) {
		R3_OUTSTANDING_NON_BANKING = r3_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR3_PROVISION_NON_BANKING() {
		return R3_PROVISION_NON_BANKING;
	}
	public void setR3_PROVISION_NON_BANKING(BigDecimal r3_PROVISION_NON_BANKING) {
		R3_PROVISION_NON_BANKING = r3_PROVISION_NON_BANKING;
	}
	public BigDecimal getR3_OUTSTANDING_INVESTMENT() {
		return R3_OUTSTANDING_INVESTMENT;
	}
	public void setR3_OUTSTANDING_INVESTMENT(BigDecimal r3_OUTSTANDING_INVESTMENT) {
		R3_OUTSTANDING_INVESTMENT = r3_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR3_PROVISION_INVESTMENT() {
		return R3_PROVISION_INVESTMENT;
	}
	public void setR3_PROVISION_INVESTMENT(BigDecimal r3_PROVISION_INVESTMENT) {
		R3_PROVISION_INVESTMENT = r3_PROVISION_INVESTMENT;
	}
	public BigDecimal getR3_OUTSTANDING_TRADE() {
		return R3_OUTSTANDING_TRADE;
	}
	public void setR3_OUTSTANDING_TRADE(BigDecimal r3_OUTSTANDING_TRADE) {
		R3_OUTSTANDING_TRADE = r3_OUTSTANDING_TRADE;
	}
	public BigDecimal getR3_PROVISION_TRADE() {
		return R3_PROVISION_TRADE;
	}
	public void setR3_PROVISION_TRADE(BigDecimal r3_PROVISION_TRADE) {
		R3_PROVISION_TRADE = r3_PROVISION_TRADE;
	}
	public BigDecimal getR3_OUTSTANDING_LOAN() {
		return R3_OUTSTANDING_LOAN;
	}
	public void setR3_OUTSTANDING_LOAN(BigDecimal r3_OUTSTANDING_LOAN) {
		R3_OUTSTANDING_LOAN = r3_OUTSTANDING_LOAN;
	}
	public BigDecimal getR3_PROVISION_LOAN() {
		return R3_PROVISION_LOAN;
	}
	public void setR3_PROVISION_LOAN(BigDecimal r3_PROVISION_LOAN) {
		R3_PROVISION_LOAN = r3_PROVISION_LOAN;
	}
	public BigDecimal getR3_OUTSTANDING_OTHER_ASSETS() {
		return R3_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR3_OUTSTANDING_OTHER_ASSETS(BigDecimal r3_OUTSTANDING_OTHER_ASSETS) {
		R3_OUTSTANDING_OTHER_ASSETS = r3_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR3_PROVISION_OTHER_ASSETS() {
		return R3_PROVISION_OTHER_ASSETS;
	}
	public void setR3_PROVISION_OTHER_ASSETS(BigDecimal r3_PROVISION_OTHER_ASSETS) {
		R3_PROVISION_OTHER_ASSETS = r3_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR3_OUTSTANDING_TOTAL() {
		return R3_OUTSTANDING_TOTAL;
	}
	public void setR3_OUTSTANDING_TOTAL(BigDecimal r3_OUTSTANDING_TOTAL) {
		R3_OUTSTANDING_TOTAL = r3_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR3_PROVISION_TOTAL() {
		return R3_PROVISION_TOTAL;
	}
	public void setR3_PROVISION_TOTAL(BigDecimal r3_PROVISION_TOTAL) {
		R3_PROVISION_TOTAL = r3_PROVISION_TOTAL;
	}
	public BigDecimal getR3_INTERESTS() {
		return R3_INTERESTS;
	}
	public void setR3_INTERESTS(BigDecimal r3_INTERESTS) {
		R3_INTERESTS = r3_INTERESTS;
	}
	public BigDecimal getR3_EXPOSURE() {
		return R3_EXPOSURE;
	}
	public void setR3_EXPOSURE(BigDecimal r3_EXPOSURE) {
		R3_EXPOSURE = r3_EXPOSURE;
	}
	public BigDecimal getR3_UNFUNDED() {
		return R3_UNFUNDED;
	}
	public void setR3_UNFUNDED(BigDecimal r3_UNFUNDED) {
		R3_UNFUNDED = r3_UNFUNDED;
	}
	public BigDecimal getR3_OUTSTANDING_UNFUNDED() {
		return R3_OUTSTANDING_UNFUNDED;
	}
	public void setR3_OUTSTANDING_UNFUNDED(BigDecimal r3_OUTSTANDING_UNFUNDED) {
		R3_OUTSTANDING_UNFUNDED = r3_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR3_PROVISION_UNFUNDED() {
		return R3_PROVISION_UNFUNDED;
	}
	public void setR3_PROVISION_UNFUNDED(BigDecimal r3_PROVISION_UNFUNDED) {
		R3_PROVISION_UNFUNDED = r3_PROVISION_UNFUNDED;
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
	public BigDecimal getR4_OUTSTANDING_CASH() {
		return R4_OUTSTANDING_CASH;
	}
	public void setR4_OUTSTANDING_CASH(BigDecimal r4_OUTSTANDING_CASH) {
		R4_OUTSTANDING_CASH = r4_OUTSTANDING_CASH;
	}
	public BigDecimal getR4_PROVISION_CASH() {
		return R4_PROVISION_CASH;
	}
	public void setR4_PROVISION_CASH(BigDecimal r4_PROVISION_CASH) {
		R4_PROVISION_CASH = r4_PROVISION_CASH;
	}
	public BigDecimal getR4_OUTSTANDING_BALANCE() {
		return R4_OUTSTANDING_BALANCE;
	}
	public void setR4_OUTSTANDING_BALANCE(BigDecimal r4_OUTSTANDING_BALANCE) {
		R4_OUTSTANDING_BALANCE = r4_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR4_PROVISION_BALANCE() {
		return R4_PROVISION_BALANCE;
	}
	public void setR4_PROVISION_BALANCE(BigDecimal r4_PROVISION_BALANCE) {
		R4_PROVISION_BALANCE = r4_PROVISION_BALANCE;
	}
	public BigDecimal getR4_OUTSTANDING_NON_BANKING() {
		return R4_OUTSTANDING_NON_BANKING;
	}
	public void setR4_OUTSTANDING_NON_BANKING(BigDecimal r4_OUTSTANDING_NON_BANKING) {
		R4_OUTSTANDING_NON_BANKING = r4_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR4_PROVISION_NON_BANKING() {
		return R4_PROVISION_NON_BANKING;
	}
	public void setR4_PROVISION_NON_BANKING(BigDecimal r4_PROVISION_NON_BANKING) {
		R4_PROVISION_NON_BANKING = r4_PROVISION_NON_BANKING;
	}
	public BigDecimal getR4_OUTSTANDING_INVESTMENT() {
		return R4_OUTSTANDING_INVESTMENT;
	}
	public void setR4_OUTSTANDING_INVESTMENT(BigDecimal r4_OUTSTANDING_INVESTMENT) {
		R4_OUTSTANDING_INVESTMENT = r4_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR4_PROVISION_INVESTMENT() {
		return R4_PROVISION_INVESTMENT;
	}
	public void setR4_PROVISION_INVESTMENT(BigDecimal r4_PROVISION_INVESTMENT) {
		R4_PROVISION_INVESTMENT = r4_PROVISION_INVESTMENT;
	}
	public BigDecimal getR4_OUTSTANDING_TRADE() {
		return R4_OUTSTANDING_TRADE;
	}
	public void setR4_OUTSTANDING_TRADE(BigDecimal r4_OUTSTANDING_TRADE) {
		R4_OUTSTANDING_TRADE = r4_OUTSTANDING_TRADE;
	}
	public BigDecimal getR4_PROVISION_TRADE() {
		return R4_PROVISION_TRADE;
	}
	public void setR4_PROVISION_TRADE(BigDecimal r4_PROVISION_TRADE) {
		R4_PROVISION_TRADE = r4_PROVISION_TRADE;
	}
	public BigDecimal getR4_OUTSTANDING_LOAN() {
		return R4_OUTSTANDING_LOAN;
	}
	public void setR4_OUTSTANDING_LOAN(BigDecimal r4_OUTSTANDING_LOAN) {
		R4_OUTSTANDING_LOAN = r4_OUTSTANDING_LOAN;
	}
	public BigDecimal getR4_PROVISION_LOAN() {
		return R4_PROVISION_LOAN;
	}
	public void setR4_PROVISION_LOAN(BigDecimal r4_PROVISION_LOAN) {
		R4_PROVISION_LOAN = r4_PROVISION_LOAN;
	}
	public BigDecimal getR4_OUTSTANDING_OTHER_ASSETS() {
		return R4_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR4_OUTSTANDING_OTHER_ASSETS(BigDecimal r4_OUTSTANDING_OTHER_ASSETS) {
		R4_OUTSTANDING_OTHER_ASSETS = r4_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR4_PROVISION_OTHER_ASSETS() {
		return R4_PROVISION_OTHER_ASSETS;
	}
	public void setR4_PROVISION_OTHER_ASSETS(BigDecimal r4_PROVISION_OTHER_ASSETS) {
		R4_PROVISION_OTHER_ASSETS = r4_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR4_OUTSTANDING_TOTAL() {
		return R4_OUTSTANDING_TOTAL;
	}
	public void setR4_OUTSTANDING_TOTAL(BigDecimal r4_OUTSTANDING_TOTAL) {
		R4_OUTSTANDING_TOTAL = r4_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR4_PROVISION_TOTAL() {
		return R4_PROVISION_TOTAL;
	}
	public void setR4_PROVISION_TOTAL(BigDecimal r4_PROVISION_TOTAL) {
		R4_PROVISION_TOTAL = r4_PROVISION_TOTAL;
	}
	public BigDecimal getR4_INTERESTS() {
		return R4_INTERESTS;
	}
	public void setR4_INTERESTS(BigDecimal r4_INTERESTS) {
		R4_INTERESTS = r4_INTERESTS;
	}
	public BigDecimal getR4_EXPOSURE() {
		return R4_EXPOSURE;
	}
	public void setR4_EXPOSURE(BigDecimal r4_EXPOSURE) {
		R4_EXPOSURE = r4_EXPOSURE;
	}
	public BigDecimal getR4_UNFUNDED() {
		return R4_UNFUNDED;
	}
	public void setR4_UNFUNDED(BigDecimal r4_UNFUNDED) {
		R4_UNFUNDED = r4_UNFUNDED;
	}
	public BigDecimal getR4_OUTSTANDING_UNFUNDED() {
		return R4_OUTSTANDING_UNFUNDED;
	}
	public void setR4_OUTSTANDING_UNFUNDED(BigDecimal r4_OUTSTANDING_UNFUNDED) {
		R4_OUTSTANDING_UNFUNDED = r4_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR4_PROVISION_UNFUNDED() {
		return R4_PROVISION_UNFUNDED;
	}
	public void setR4_PROVISION_UNFUNDED(BigDecimal r4_PROVISION_UNFUNDED) {
		R4_PROVISION_UNFUNDED = r4_PROVISION_UNFUNDED;
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
	public BigDecimal getR5_OUTSTANDING_CASH() {
		return R5_OUTSTANDING_CASH;
	}
	public void setR5_OUTSTANDING_CASH(BigDecimal r5_OUTSTANDING_CASH) {
		R5_OUTSTANDING_CASH = r5_OUTSTANDING_CASH;
	}
	public BigDecimal getR5_PROVISION_CASH() {
		return R5_PROVISION_CASH;
	}
	public void setR5_PROVISION_CASH(BigDecimal r5_PROVISION_CASH) {
		R5_PROVISION_CASH = r5_PROVISION_CASH;
	}
	public BigDecimal getR5_OUTSTANDING_BALANCE() {
		return R5_OUTSTANDING_BALANCE;
	}
	public void setR5_OUTSTANDING_BALANCE(BigDecimal r5_OUTSTANDING_BALANCE) {
		R5_OUTSTANDING_BALANCE = r5_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR5_PROVISION_BALANCE() {
		return R5_PROVISION_BALANCE;
	}
	public void setR5_PROVISION_BALANCE(BigDecimal r5_PROVISION_BALANCE) {
		R5_PROVISION_BALANCE = r5_PROVISION_BALANCE;
	}
	public BigDecimal getR5_OUTSTANDING_NON_BANKING() {
		return R5_OUTSTANDING_NON_BANKING;
	}
	public void setR5_OUTSTANDING_NON_BANKING(BigDecimal r5_OUTSTANDING_NON_BANKING) {
		R5_OUTSTANDING_NON_BANKING = r5_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR5_PROVISION_NON_BANKING() {
		return R5_PROVISION_NON_BANKING;
	}
	public void setR5_PROVISION_NON_BANKING(BigDecimal r5_PROVISION_NON_BANKING) {
		R5_PROVISION_NON_BANKING = r5_PROVISION_NON_BANKING;
	}
	public BigDecimal getR5_OUTSTANDING_INVESTMENT() {
		return R5_OUTSTANDING_INVESTMENT;
	}
	public void setR5_OUTSTANDING_INVESTMENT(BigDecimal r5_OUTSTANDING_INVESTMENT) {
		R5_OUTSTANDING_INVESTMENT = r5_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR5_PROVISION_INVESTMENT() {
		return R5_PROVISION_INVESTMENT;
	}
	public void setR5_PROVISION_INVESTMENT(BigDecimal r5_PROVISION_INVESTMENT) {
		R5_PROVISION_INVESTMENT = r5_PROVISION_INVESTMENT;
	}
	public BigDecimal getR5_OUTSTANDING_TRADE() {
		return R5_OUTSTANDING_TRADE;
	}
	public void setR5_OUTSTANDING_TRADE(BigDecimal r5_OUTSTANDING_TRADE) {
		R5_OUTSTANDING_TRADE = r5_OUTSTANDING_TRADE;
	}
	public BigDecimal getR5_PROVISION_TRADE() {
		return R5_PROVISION_TRADE;
	}
	public void setR5_PROVISION_TRADE(BigDecimal r5_PROVISION_TRADE) {
		R5_PROVISION_TRADE = r5_PROVISION_TRADE;
	}
	public BigDecimal getR5_OUTSTANDING_LOAN() {
		return R5_OUTSTANDING_LOAN;
	}
	public void setR5_OUTSTANDING_LOAN(BigDecimal r5_OUTSTANDING_LOAN) {
		R5_OUTSTANDING_LOAN = r5_OUTSTANDING_LOAN;
	}
	public BigDecimal getR5_PROVISION_LOAN() {
		return R5_PROVISION_LOAN;
	}
	public void setR5_PROVISION_LOAN(BigDecimal r5_PROVISION_LOAN) {
		R5_PROVISION_LOAN = r5_PROVISION_LOAN;
	}
	public BigDecimal getR5_OUTSTANDING_OTHER_ASSETS() {
		return R5_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR5_OUTSTANDING_OTHER_ASSETS(BigDecimal r5_OUTSTANDING_OTHER_ASSETS) {
		R5_OUTSTANDING_OTHER_ASSETS = r5_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR5_PROVISION_OTHER_ASSETS() {
		return R5_PROVISION_OTHER_ASSETS;
	}
	public void setR5_PROVISION_OTHER_ASSETS(BigDecimal r5_PROVISION_OTHER_ASSETS) {
		R5_PROVISION_OTHER_ASSETS = r5_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR5_OUTSTANDING_TOTAL() {
		return R5_OUTSTANDING_TOTAL;
	}
	public void setR5_OUTSTANDING_TOTAL(BigDecimal r5_OUTSTANDING_TOTAL) {
		R5_OUTSTANDING_TOTAL = r5_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR5_PROVISION_TOTAL() {
		return R5_PROVISION_TOTAL;
	}
	public void setR5_PROVISION_TOTAL(BigDecimal r5_PROVISION_TOTAL) {
		R5_PROVISION_TOTAL = r5_PROVISION_TOTAL;
	}
	public BigDecimal getR5_INTERESTS() {
		return R5_INTERESTS;
	}
	public void setR5_INTERESTS(BigDecimal r5_INTERESTS) {
		R5_INTERESTS = r5_INTERESTS;
	}
	public BigDecimal getR5_EXPOSURE() {
		return R5_EXPOSURE;
	}
	public void setR5_EXPOSURE(BigDecimal r5_EXPOSURE) {
		R5_EXPOSURE = r5_EXPOSURE;
	}
	public BigDecimal getR5_UNFUNDED() {
		return R5_UNFUNDED;
	}
	public void setR5_UNFUNDED(BigDecimal r5_UNFUNDED) {
		R5_UNFUNDED = r5_UNFUNDED;
	}
	public BigDecimal getR5_OUTSTANDING_UNFUNDED() {
		return R5_OUTSTANDING_UNFUNDED;
	}
	public void setR5_OUTSTANDING_UNFUNDED(BigDecimal r5_OUTSTANDING_UNFUNDED) {
		R5_OUTSTANDING_UNFUNDED = r5_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR5_PROVISION_UNFUNDED() {
		return R5_PROVISION_UNFUNDED;
	}
	public void setR5_PROVISION_UNFUNDED(BigDecimal r5_PROVISION_UNFUNDED) {
		R5_PROVISION_UNFUNDED = r5_PROVISION_UNFUNDED;
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
	public BigDecimal getR6_OUTSTANDING_CASH() {
		return R6_OUTSTANDING_CASH;
	}
	public void setR6_OUTSTANDING_CASH(BigDecimal r6_OUTSTANDING_CASH) {
		R6_OUTSTANDING_CASH = r6_OUTSTANDING_CASH;
	}
	public BigDecimal getR6_PROVISION_CASH() {
		return R6_PROVISION_CASH;
	}
	public void setR6_PROVISION_CASH(BigDecimal r6_PROVISION_CASH) {
		R6_PROVISION_CASH = r6_PROVISION_CASH;
	}
	public BigDecimal getR6_OUTSTANDING_BALANCE() {
		return R6_OUTSTANDING_BALANCE;
	}
	public void setR6_OUTSTANDING_BALANCE(BigDecimal r6_OUTSTANDING_BALANCE) {
		R6_OUTSTANDING_BALANCE = r6_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR6_PROVISION_BALANCE() {
		return R6_PROVISION_BALANCE;
	}
	public void setR6_PROVISION_BALANCE(BigDecimal r6_PROVISION_BALANCE) {
		R6_PROVISION_BALANCE = r6_PROVISION_BALANCE;
	}
	public BigDecimal getR6_OUTSTANDING_NON_BANKING() {
		return R6_OUTSTANDING_NON_BANKING;
	}
	public void setR6_OUTSTANDING_NON_BANKING(BigDecimal r6_OUTSTANDING_NON_BANKING) {
		R6_OUTSTANDING_NON_BANKING = r6_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR6_PROVISION_NON_BANKING() {
		return R6_PROVISION_NON_BANKING;
	}
	public void setR6_PROVISION_NON_BANKING(BigDecimal r6_PROVISION_NON_BANKING) {
		R6_PROVISION_NON_BANKING = r6_PROVISION_NON_BANKING;
	}
	public BigDecimal getR6_OUTSTANDING_INVESTMENT() {
		return R6_OUTSTANDING_INVESTMENT;
	}
	public void setR6_OUTSTANDING_INVESTMENT(BigDecimal r6_OUTSTANDING_INVESTMENT) {
		R6_OUTSTANDING_INVESTMENT = r6_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR6_PROVISION_INVESTMENT() {
		return R6_PROVISION_INVESTMENT;
	}
	public void setR6_PROVISION_INVESTMENT(BigDecimal r6_PROVISION_INVESTMENT) {
		R6_PROVISION_INVESTMENT = r6_PROVISION_INVESTMENT;
	}
	public BigDecimal getR6_OUTSTANDING_TRADE() {
		return R6_OUTSTANDING_TRADE;
	}
	public void setR6_OUTSTANDING_TRADE(BigDecimal r6_OUTSTANDING_TRADE) {
		R6_OUTSTANDING_TRADE = r6_OUTSTANDING_TRADE;
	}
	public BigDecimal getR6_PROVISION_TRADE() {
		return R6_PROVISION_TRADE;
	}
	public void setR6_PROVISION_TRADE(BigDecimal r6_PROVISION_TRADE) {
		R6_PROVISION_TRADE = r6_PROVISION_TRADE;
	}
	public BigDecimal getR6_OUTSTANDING_LOAN() {
		return R6_OUTSTANDING_LOAN;
	}
	public void setR6_OUTSTANDING_LOAN(BigDecimal r6_OUTSTANDING_LOAN) {
		R6_OUTSTANDING_LOAN = r6_OUTSTANDING_LOAN;
	}
	public BigDecimal getR6_PROVISION_LOAN() {
		return R6_PROVISION_LOAN;
	}
	public void setR6_PROVISION_LOAN(BigDecimal r6_PROVISION_LOAN) {
		R6_PROVISION_LOAN = r6_PROVISION_LOAN;
	}
	public BigDecimal getR6_OUTSTANDING_OTHER_ASSETS() {
		return R6_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR6_OUTSTANDING_OTHER_ASSETS(BigDecimal r6_OUTSTANDING_OTHER_ASSETS) {
		R6_OUTSTANDING_OTHER_ASSETS = r6_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR6_PROVISION_OTHER_ASSETS() {
		return R6_PROVISION_OTHER_ASSETS;
	}
	public void setR6_PROVISION_OTHER_ASSETS(BigDecimal r6_PROVISION_OTHER_ASSETS) {
		R6_PROVISION_OTHER_ASSETS = r6_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR6_OUTSTANDING_TOTAL() {
		return R6_OUTSTANDING_TOTAL;
	}
	public void setR6_OUTSTANDING_TOTAL(BigDecimal r6_OUTSTANDING_TOTAL) {
		R6_OUTSTANDING_TOTAL = r6_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR6_PROVISION_TOTAL() {
		return R6_PROVISION_TOTAL;
	}
	public void setR6_PROVISION_TOTAL(BigDecimal r6_PROVISION_TOTAL) {
		R6_PROVISION_TOTAL = r6_PROVISION_TOTAL;
	}
	public BigDecimal getR6_INTERESTS() {
		return R6_INTERESTS;
	}
	public void setR6_INTERESTS(BigDecimal r6_INTERESTS) {
		R6_INTERESTS = r6_INTERESTS;
	}
	public BigDecimal getR6_EXPOSURE() {
		return R6_EXPOSURE;
	}
	public void setR6_EXPOSURE(BigDecimal r6_EXPOSURE) {
		R6_EXPOSURE = r6_EXPOSURE;
	}
	public BigDecimal getR6_UNFUNDED() {
		return R6_UNFUNDED;
	}
	public void setR6_UNFUNDED(BigDecimal r6_UNFUNDED) {
		R6_UNFUNDED = r6_UNFUNDED;
	}
	public BigDecimal getR6_OUTSTANDING_UNFUNDED() {
		return R6_OUTSTANDING_UNFUNDED;
	}
	public void setR6_OUTSTANDING_UNFUNDED(BigDecimal r6_OUTSTANDING_UNFUNDED) {
		R6_OUTSTANDING_UNFUNDED = r6_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR6_PROVISION_UNFUNDED() {
		return R6_PROVISION_UNFUNDED;
	}
	public void setR6_PROVISION_UNFUNDED(BigDecimal r6_PROVISION_UNFUNDED) {
		R6_PROVISION_UNFUNDED = r6_PROVISION_UNFUNDED;
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
	public BigDecimal getR7_OUTSTANDING_CASH() {
		return R7_OUTSTANDING_CASH;
	}
	public void setR7_OUTSTANDING_CASH(BigDecimal r7_OUTSTANDING_CASH) {
		R7_OUTSTANDING_CASH = r7_OUTSTANDING_CASH;
	}
	public BigDecimal getR7_PROVISION_CASH() {
		return R7_PROVISION_CASH;
	}
	public void setR7_PROVISION_CASH(BigDecimal r7_PROVISION_CASH) {
		R7_PROVISION_CASH = r7_PROVISION_CASH;
	}
	public BigDecimal getR7_OUTSTANDING_BALANCE() {
		return R7_OUTSTANDING_BALANCE;
	}
	public void setR7_OUTSTANDING_BALANCE(BigDecimal r7_OUTSTANDING_BALANCE) {
		R7_OUTSTANDING_BALANCE = r7_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR7_PROVISION_BALANCE() {
		return R7_PROVISION_BALANCE;
	}
	public void setR7_PROVISION_BALANCE(BigDecimal r7_PROVISION_BALANCE) {
		R7_PROVISION_BALANCE = r7_PROVISION_BALANCE;
	}
	public BigDecimal getR7_OUTSTANDING_NON_BANKING() {
		return R7_OUTSTANDING_NON_BANKING;
	}
	public void setR7_OUTSTANDING_NON_BANKING(BigDecimal r7_OUTSTANDING_NON_BANKING) {
		R7_OUTSTANDING_NON_BANKING = r7_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR7_PROVISION_NON_BANKING() {
		return R7_PROVISION_NON_BANKING;
	}
	public void setR7_PROVISION_NON_BANKING(BigDecimal r7_PROVISION_NON_BANKING) {
		R7_PROVISION_NON_BANKING = r7_PROVISION_NON_BANKING;
	}
	public BigDecimal getR7_OUTSTANDING_INVESTMENT() {
		return R7_OUTSTANDING_INVESTMENT;
	}
	public void setR7_OUTSTANDING_INVESTMENT(BigDecimal r7_OUTSTANDING_INVESTMENT) {
		R7_OUTSTANDING_INVESTMENT = r7_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR7_PROVISION_INVESTMENT() {
		return R7_PROVISION_INVESTMENT;
	}
	public void setR7_PROVISION_INVESTMENT(BigDecimal r7_PROVISION_INVESTMENT) {
		R7_PROVISION_INVESTMENT = r7_PROVISION_INVESTMENT;
	}
	public BigDecimal getR7_OUTSTANDING_TRADE() {
		return R7_OUTSTANDING_TRADE;
	}
	public void setR7_OUTSTANDING_TRADE(BigDecimal r7_OUTSTANDING_TRADE) {
		R7_OUTSTANDING_TRADE = r7_OUTSTANDING_TRADE;
	}
	public BigDecimal getR7_PROVISION_TRADE() {
		return R7_PROVISION_TRADE;
	}
	public void setR7_PROVISION_TRADE(BigDecimal r7_PROVISION_TRADE) {
		R7_PROVISION_TRADE = r7_PROVISION_TRADE;
	}
	public BigDecimal getR7_OUTSTANDING_LOAN() {
		return R7_OUTSTANDING_LOAN;
	}
	public void setR7_OUTSTANDING_LOAN(BigDecimal r7_OUTSTANDING_LOAN) {
		R7_OUTSTANDING_LOAN = r7_OUTSTANDING_LOAN;
	}
	public BigDecimal getR7_PROVISION_LOAN() {
		return R7_PROVISION_LOAN;
	}
	public void setR7_PROVISION_LOAN(BigDecimal r7_PROVISION_LOAN) {
		R7_PROVISION_LOAN = r7_PROVISION_LOAN;
	}
	public BigDecimal getR7_OUTSTANDING_OTHER_ASSETS() {
		return R7_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR7_OUTSTANDING_OTHER_ASSETS(BigDecimal r7_OUTSTANDING_OTHER_ASSETS) {
		R7_OUTSTANDING_OTHER_ASSETS = r7_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR7_PROVISION_OTHER_ASSETS() {
		return R7_PROVISION_OTHER_ASSETS;
	}
	public void setR7_PROVISION_OTHER_ASSETS(BigDecimal r7_PROVISION_OTHER_ASSETS) {
		R7_PROVISION_OTHER_ASSETS = r7_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR7_OUTSTANDING_TOTAL() {
		return R7_OUTSTANDING_TOTAL;
	}
	public void setR7_OUTSTANDING_TOTAL(BigDecimal r7_OUTSTANDING_TOTAL) {
		R7_OUTSTANDING_TOTAL = r7_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR7_PROVISION_TOTAL() {
		return R7_PROVISION_TOTAL;
	}
	public void setR7_PROVISION_TOTAL(BigDecimal r7_PROVISION_TOTAL) {
		R7_PROVISION_TOTAL = r7_PROVISION_TOTAL;
	}
	public BigDecimal getR7_INTERESTS() {
		return R7_INTERESTS;
	}
	public void setR7_INTERESTS(BigDecimal r7_INTERESTS) {
		R7_INTERESTS = r7_INTERESTS;
	}
	public BigDecimal getR7_EXPOSURE() {
		return R7_EXPOSURE;
	}
	public void setR7_EXPOSURE(BigDecimal r7_EXPOSURE) {
		R7_EXPOSURE = r7_EXPOSURE;
	}
	public BigDecimal getR7_UNFUNDED() {
		return R7_UNFUNDED;
	}
	public void setR7_UNFUNDED(BigDecimal r7_UNFUNDED) {
		R7_UNFUNDED = r7_UNFUNDED;
	}
	public BigDecimal getR7_OUTSTANDING_UNFUNDED() {
		return R7_OUTSTANDING_UNFUNDED;
	}
	public void setR7_OUTSTANDING_UNFUNDED(BigDecimal r7_OUTSTANDING_UNFUNDED) {
		R7_OUTSTANDING_UNFUNDED = r7_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR7_PROVISION_UNFUNDED() {
		return R7_PROVISION_UNFUNDED;
	}
	public void setR7_PROVISION_UNFUNDED(BigDecimal r7_PROVISION_UNFUNDED) {
		R7_PROVISION_UNFUNDED = r7_PROVISION_UNFUNDED;
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
	public BigDecimal getR8_OUTSTANDING_CASH() {
		return R8_OUTSTANDING_CASH;
	}
	public void setR8_OUTSTANDING_CASH(BigDecimal r8_OUTSTANDING_CASH) {
		R8_OUTSTANDING_CASH = r8_OUTSTANDING_CASH;
	}
	public BigDecimal getR8_PROVISION_CASH() {
		return R8_PROVISION_CASH;
	}
	public void setR8_PROVISION_CASH(BigDecimal r8_PROVISION_CASH) {
		R8_PROVISION_CASH = r8_PROVISION_CASH;
	}
	public BigDecimal getR8_OUTSTANDING_BALANCE() {
		return R8_OUTSTANDING_BALANCE;
	}
	public void setR8_OUTSTANDING_BALANCE(BigDecimal r8_OUTSTANDING_BALANCE) {
		R8_OUTSTANDING_BALANCE = r8_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR8_PROVISION_BALANCE() {
		return R8_PROVISION_BALANCE;
	}
	public void setR8_PROVISION_BALANCE(BigDecimal r8_PROVISION_BALANCE) {
		R8_PROVISION_BALANCE = r8_PROVISION_BALANCE;
	}
	public BigDecimal getR8_OUTSTANDING_NON_BANKING() {
		return R8_OUTSTANDING_NON_BANKING;
	}
	public void setR8_OUTSTANDING_NON_BANKING(BigDecimal r8_OUTSTANDING_NON_BANKING) {
		R8_OUTSTANDING_NON_BANKING = r8_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR8_PROVISION_NON_BANKING() {
		return R8_PROVISION_NON_BANKING;
	}
	public void setR8_PROVISION_NON_BANKING(BigDecimal r8_PROVISION_NON_BANKING) {
		R8_PROVISION_NON_BANKING = r8_PROVISION_NON_BANKING;
	}
	public BigDecimal getR8_OUTSTANDING_INVESTMENT() {
		return R8_OUTSTANDING_INVESTMENT;
	}
	public void setR8_OUTSTANDING_INVESTMENT(BigDecimal r8_OUTSTANDING_INVESTMENT) {
		R8_OUTSTANDING_INVESTMENT = r8_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR8_PROVISION_INVESTMENT() {
		return R8_PROVISION_INVESTMENT;
	}
	public void setR8_PROVISION_INVESTMENT(BigDecimal r8_PROVISION_INVESTMENT) {
		R8_PROVISION_INVESTMENT = r8_PROVISION_INVESTMENT;
	}
	public BigDecimal getR8_OUTSTANDING_TRADE() {
		return R8_OUTSTANDING_TRADE;
	}
	public void setR8_OUTSTANDING_TRADE(BigDecimal r8_OUTSTANDING_TRADE) {
		R8_OUTSTANDING_TRADE = r8_OUTSTANDING_TRADE;
	}
	public BigDecimal getR8_PROVISION_TRADE() {
		return R8_PROVISION_TRADE;
	}
	public void setR8_PROVISION_TRADE(BigDecimal r8_PROVISION_TRADE) {
		R8_PROVISION_TRADE = r8_PROVISION_TRADE;
	}
	public BigDecimal getR8_OUTSTANDING_LOAN() {
		return R8_OUTSTANDING_LOAN;
	}
	public void setR8_OUTSTANDING_LOAN(BigDecimal r8_OUTSTANDING_LOAN) {
		R8_OUTSTANDING_LOAN = r8_OUTSTANDING_LOAN;
	}
	public BigDecimal getR8_PROVISION_LOAN() {
		return R8_PROVISION_LOAN;
	}
	public void setR8_PROVISION_LOAN(BigDecimal r8_PROVISION_LOAN) {
		R8_PROVISION_LOAN = r8_PROVISION_LOAN;
	}
	public BigDecimal getR8_OUTSTANDING_OTHER_ASSETS() {
		return R8_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR8_OUTSTANDING_OTHER_ASSETS(BigDecimal r8_OUTSTANDING_OTHER_ASSETS) {
		R8_OUTSTANDING_OTHER_ASSETS = r8_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR8_PROVISION_OTHER_ASSETS() {
		return R8_PROVISION_OTHER_ASSETS;
	}
	public void setR8_PROVISION_OTHER_ASSETS(BigDecimal r8_PROVISION_OTHER_ASSETS) {
		R8_PROVISION_OTHER_ASSETS = r8_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR8_OUTSTANDING_TOTAL() {
		return R8_OUTSTANDING_TOTAL;
	}
	public void setR8_OUTSTANDING_TOTAL(BigDecimal r8_OUTSTANDING_TOTAL) {
		R8_OUTSTANDING_TOTAL = r8_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR8_PROVISION_TOTAL() {
		return R8_PROVISION_TOTAL;
	}
	public void setR8_PROVISION_TOTAL(BigDecimal r8_PROVISION_TOTAL) {
		R8_PROVISION_TOTAL = r8_PROVISION_TOTAL;
	}
	public BigDecimal getR8_INTERESTS() {
		return R8_INTERESTS;
	}
	public void setR8_INTERESTS(BigDecimal r8_INTERESTS) {
		R8_INTERESTS = r8_INTERESTS;
	}
	public BigDecimal getR8_EXPOSURE() {
		return R8_EXPOSURE;
	}
	public void setR8_EXPOSURE(BigDecimal r8_EXPOSURE) {
		R8_EXPOSURE = r8_EXPOSURE;
	}
	public BigDecimal getR8_UNFUNDED() {
		return R8_UNFUNDED;
	}
	public void setR8_UNFUNDED(BigDecimal r8_UNFUNDED) {
		R8_UNFUNDED = r8_UNFUNDED;
	}
	public BigDecimal getR8_OUTSTANDING_UNFUNDED() {
		return R8_OUTSTANDING_UNFUNDED;
	}
	public void setR8_OUTSTANDING_UNFUNDED(BigDecimal r8_OUTSTANDING_UNFUNDED) {
		R8_OUTSTANDING_UNFUNDED = r8_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR8_PROVISION_UNFUNDED() {
		return R8_PROVISION_UNFUNDED;
	}
	public void setR8_PROVISION_UNFUNDED(BigDecimal r8_PROVISION_UNFUNDED) {
		R8_PROVISION_UNFUNDED = r8_PROVISION_UNFUNDED;
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
	public BigDecimal getR9_OUTSTANDING_CASH() {
		return R9_OUTSTANDING_CASH;
	}
	public void setR9_OUTSTANDING_CASH(BigDecimal r9_OUTSTANDING_CASH) {
		R9_OUTSTANDING_CASH = r9_OUTSTANDING_CASH;
	}
	public BigDecimal getR9_PROVISION_CASH() {
		return R9_PROVISION_CASH;
	}
	public void setR9_PROVISION_CASH(BigDecimal r9_PROVISION_CASH) {
		R9_PROVISION_CASH = r9_PROVISION_CASH;
	}
	public BigDecimal getR9_OUTSTANDING_BALANCE() {
		return R9_OUTSTANDING_BALANCE;
	}
	public void setR9_OUTSTANDING_BALANCE(BigDecimal r9_OUTSTANDING_BALANCE) {
		R9_OUTSTANDING_BALANCE = r9_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR9_PROVISION_BALANCE() {
		return R9_PROVISION_BALANCE;
	}
	public void setR9_PROVISION_BALANCE(BigDecimal r9_PROVISION_BALANCE) {
		R9_PROVISION_BALANCE = r9_PROVISION_BALANCE;
	}
	public BigDecimal getR9_OUTSTANDING_NON_BANKING() {
		return R9_OUTSTANDING_NON_BANKING;
	}
	public void setR9_OUTSTANDING_NON_BANKING(BigDecimal r9_OUTSTANDING_NON_BANKING) {
		R9_OUTSTANDING_NON_BANKING = r9_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR9_PROVISION_NON_BANKING() {
		return R9_PROVISION_NON_BANKING;
	}
	public void setR9_PROVISION_NON_BANKING(BigDecimal r9_PROVISION_NON_BANKING) {
		R9_PROVISION_NON_BANKING = r9_PROVISION_NON_BANKING;
	}
	public BigDecimal getR9_OUTSTANDING_INVESTMENT() {
		return R9_OUTSTANDING_INVESTMENT;
	}
	public void setR9_OUTSTANDING_INVESTMENT(BigDecimal r9_OUTSTANDING_INVESTMENT) {
		R9_OUTSTANDING_INVESTMENT = r9_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR9_PROVISION_INVESTMENT() {
		return R9_PROVISION_INVESTMENT;
	}
	public void setR9_PROVISION_INVESTMENT(BigDecimal r9_PROVISION_INVESTMENT) {
		R9_PROVISION_INVESTMENT = r9_PROVISION_INVESTMENT;
	}
	public BigDecimal getR9_OUTSTANDING_TRADE() {
		return R9_OUTSTANDING_TRADE;
	}
	public void setR9_OUTSTANDING_TRADE(BigDecimal r9_OUTSTANDING_TRADE) {
		R9_OUTSTANDING_TRADE = r9_OUTSTANDING_TRADE;
	}
	public BigDecimal getR9_PROVISION_TRADE() {
		return R9_PROVISION_TRADE;
	}
	public void setR9_PROVISION_TRADE(BigDecimal r9_PROVISION_TRADE) {
		R9_PROVISION_TRADE = r9_PROVISION_TRADE;
	}
	public BigDecimal getR9_OUTSTANDING_LOAN() {
		return R9_OUTSTANDING_LOAN;
	}
	public void setR9_OUTSTANDING_LOAN(BigDecimal r9_OUTSTANDING_LOAN) {
		R9_OUTSTANDING_LOAN = r9_OUTSTANDING_LOAN;
	}
	public BigDecimal getR9_PROVISION_LOAN() {
		return R9_PROVISION_LOAN;
	}
	public void setR9_PROVISION_LOAN(BigDecimal r9_PROVISION_LOAN) {
		R9_PROVISION_LOAN = r9_PROVISION_LOAN;
	}
	public BigDecimal getR9_OUTSTANDING_OTHER_ASSETS() {
		return R9_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR9_OUTSTANDING_OTHER_ASSETS(BigDecimal r9_OUTSTANDING_OTHER_ASSETS) {
		R9_OUTSTANDING_OTHER_ASSETS = r9_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR9_PROVISION_OTHER_ASSETS() {
		return R9_PROVISION_OTHER_ASSETS;
	}
	public void setR9_PROVISION_OTHER_ASSETS(BigDecimal r9_PROVISION_OTHER_ASSETS) {
		R9_PROVISION_OTHER_ASSETS = r9_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR9_OUTSTANDING_TOTAL() {
		return R9_OUTSTANDING_TOTAL;
	}
	public void setR9_OUTSTANDING_TOTAL(BigDecimal r9_OUTSTANDING_TOTAL) {
		R9_OUTSTANDING_TOTAL = r9_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR9_PROVISION_TOTAL() {
		return R9_PROVISION_TOTAL;
	}
	public void setR9_PROVISION_TOTAL(BigDecimal r9_PROVISION_TOTAL) {
		R9_PROVISION_TOTAL = r9_PROVISION_TOTAL;
	}
	public BigDecimal getR9_INTERESTS() {
		return R9_INTERESTS;
	}
	public void setR9_INTERESTS(BigDecimal r9_INTERESTS) {
		R9_INTERESTS = r9_INTERESTS;
	}
	public BigDecimal getR9_EXPOSURE() {
		return R9_EXPOSURE;
	}
	public void setR9_EXPOSURE(BigDecimal r9_EXPOSURE) {
		R9_EXPOSURE = r9_EXPOSURE;
	}
	public BigDecimal getR9_UNFUNDED() {
		return R9_UNFUNDED;
	}
	public void setR9_UNFUNDED(BigDecimal r9_UNFUNDED) {
		R9_UNFUNDED = r9_UNFUNDED;
	}
	public BigDecimal getR9_OUTSTANDING_UNFUNDED() {
		return R9_OUTSTANDING_UNFUNDED;
	}
	public void setR9_OUTSTANDING_UNFUNDED(BigDecimal r9_OUTSTANDING_UNFUNDED) {
		R9_OUTSTANDING_UNFUNDED = r9_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR9_PROVISION_UNFUNDED() {
		return R9_PROVISION_UNFUNDED;
	}
	public void setR9_PROVISION_UNFUNDED(BigDecimal r9_PROVISION_UNFUNDED) {
		R9_PROVISION_UNFUNDED = r9_PROVISION_UNFUNDED;
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
	public BigDecimal getR10_OUTSTANDING_CASH() {
		return R10_OUTSTANDING_CASH;
	}
	public void setR10_OUTSTANDING_CASH(BigDecimal r10_OUTSTANDING_CASH) {
		R10_OUTSTANDING_CASH = r10_OUTSTANDING_CASH;
	}
	public BigDecimal getR10_PROVISION_CASH() {
		return R10_PROVISION_CASH;
	}
	public void setR10_PROVISION_CASH(BigDecimal r10_PROVISION_CASH) {
		R10_PROVISION_CASH = r10_PROVISION_CASH;
	}
	public BigDecimal getR10_OUTSTANDING_BALANCE() {
		return R10_OUTSTANDING_BALANCE;
	}
	public void setR10_OUTSTANDING_BALANCE(BigDecimal r10_OUTSTANDING_BALANCE) {
		R10_OUTSTANDING_BALANCE = r10_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR10_PROVISION_BALANCE() {
		return R10_PROVISION_BALANCE;
	}
	public void setR10_PROVISION_BALANCE(BigDecimal r10_PROVISION_BALANCE) {
		R10_PROVISION_BALANCE = r10_PROVISION_BALANCE;
	}
	public BigDecimal getR10_OUTSTANDING_NON_BANKING() {
		return R10_OUTSTANDING_NON_BANKING;
	}
	public void setR10_OUTSTANDING_NON_BANKING(BigDecimal r10_OUTSTANDING_NON_BANKING) {
		R10_OUTSTANDING_NON_BANKING = r10_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR10_PROVISION_NON_BANKING() {
		return R10_PROVISION_NON_BANKING;
	}
	public void setR10_PROVISION_NON_BANKING(BigDecimal r10_PROVISION_NON_BANKING) {
		R10_PROVISION_NON_BANKING = r10_PROVISION_NON_BANKING;
	}
	public BigDecimal getR10_OUTSTANDING_INVESTMENT() {
		return R10_OUTSTANDING_INVESTMENT;
	}
	public void setR10_OUTSTANDING_INVESTMENT(BigDecimal r10_OUTSTANDING_INVESTMENT) {
		R10_OUTSTANDING_INVESTMENT = r10_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR10_PROVISION_INVESTMENT() {
		return R10_PROVISION_INVESTMENT;
	}
	public void setR10_PROVISION_INVESTMENT(BigDecimal r10_PROVISION_INVESTMENT) {
		R10_PROVISION_INVESTMENT = r10_PROVISION_INVESTMENT;
	}
	public BigDecimal getR10_OUTSTANDING_TRADE() {
		return R10_OUTSTANDING_TRADE;
	}
	public void setR10_OUTSTANDING_TRADE(BigDecimal r10_OUTSTANDING_TRADE) {
		R10_OUTSTANDING_TRADE = r10_OUTSTANDING_TRADE;
	}
	public BigDecimal getR10_PROVISION_TRADE() {
		return R10_PROVISION_TRADE;
	}
	public void setR10_PROVISION_TRADE(BigDecimal r10_PROVISION_TRADE) {
		R10_PROVISION_TRADE = r10_PROVISION_TRADE;
	}
	public BigDecimal getR10_OUTSTANDING_LOAN() {
		return R10_OUTSTANDING_LOAN;
	}
	public void setR10_OUTSTANDING_LOAN(BigDecimal r10_OUTSTANDING_LOAN) {
		R10_OUTSTANDING_LOAN = r10_OUTSTANDING_LOAN;
	}
	public BigDecimal getR10_PROVISION_LOAN() {
		return R10_PROVISION_LOAN;
	}
	public void setR10_PROVISION_LOAN(BigDecimal r10_PROVISION_LOAN) {
		R10_PROVISION_LOAN = r10_PROVISION_LOAN;
	}
	public BigDecimal getR10_OUTSTANDING_OTHER_ASSETS() {
		return R10_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR10_OUTSTANDING_OTHER_ASSETS(BigDecimal r10_OUTSTANDING_OTHER_ASSETS) {
		R10_OUTSTANDING_OTHER_ASSETS = r10_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR10_PROVISION_OTHER_ASSETS() {
		return R10_PROVISION_OTHER_ASSETS;
	}
	public void setR10_PROVISION_OTHER_ASSETS(BigDecimal r10_PROVISION_OTHER_ASSETS) {
		R10_PROVISION_OTHER_ASSETS = r10_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR10_OUTSTANDING_TOTAL() {
		return R10_OUTSTANDING_TOTAL;
	}
	public void setR10_OUTSTANDING_TOTAL(BigDecimal r10_OUTSTANDING_TOTAL) {
		R10_OUTSTANDING_TOTAL = r10_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR10_PROVISION_TOTAL() {
		return R10_PROVISION_TOTAL;
	}
	public void setR10_PROVISION_TOTAL(BigDecimal r10_PROVISION_TOTAL) {
		R10_PROVISION_TOTAL = r10_PROVISION_TOTAL;
	}
	public BigDecimal getR10_INTERESTS() {
		return R10_INTERESTS;
	}
	public void setR10_INTERESTS(BigDecimal r10_INTERESTS) {
		R10_INTERESTS = r10_INTERESTS;
	}
	public BigDecimal getR10_EXPOSURE() {
		return R10_EXPOSURE;
	}
	public void setR10_EXPOSURE(BigDecimal r10_EXPOSURE) {
		R10_EXPOSURE = r10_EXPOSURE;
	}
	public BigDecimal getR10_UNFUNDED() {
		return R10_UNFUNDED;
	}
	public void setR10_UNFUNDED(BigDecimal r10_UNFUNDED) {
		R10_UNFUNDED = r10_UNFUNDED;
	}
	public BigDecimal getR10_OUTSTANDING_UNFUNDED() {
		return R10_OUTSTANDING_UNFUNDED;
	}
	public void setR10_OUTSTANDING_UNFUNDED(BigDecimal r10_OUTSTANDING_UNFUNDED) {
		R10_OUTSTANDING_UNFUNDED = r10_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR10_PROVISION_UNFUNDED() {
		return R10_PROVISION_UNFUNDED;
	}
	public void setR10_PROVISION_UNFUNDED(BigDecimal r10_PROVISION_UNFUNDED) {
		R10_PROVISION_UNFUNDED = r10_PROVISION_UNFUNDED;
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
	public BigDecimal getR11_OUTSTANDING_CASH() {
		return R11_OUTSTANDING_CASH;
	}
	public void setR11_OUTSTANDING_CASH(BigDecimal r11_OUTSTANDING_CASH) {
		R11_OUTSTANDING_CASH = r11_OUTSTANDING_CASH;
	}
	public BigDecimal getR11_PROVISION_CASH() {
		return R11_PROVISION_CASH;
	}
	public void setR11_PROVISION_CASH(BigDecimal r11_PROVISION_CASH) {
		R11_PROVISION_CASH = r11_PROVISION_CASH;
	}
	public BigDecimal getR11_OUTSTANDING_BALANCE() {
		return R11_OUTSTANDING_BALANCE;
	}
	public void setR11_OUTSTANDING_BALANCE(BigDecimal r11_OUTSTANDING_BALANCE) {
		R11_OUTSTANDING_BALANCE = r11_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR11_PROVISION_BALANCE() {
		return R11_PROVISION_BALANCE;
	}
	public void setR11_PROVISION_BALANCE(BigDecimal r11_PROVISION_BALANCE) {
		R11_PROVISION_BALANCE = r11_PROVISION_BALANCE;
	}
	public BigDecimal getR11_OUTSTANDING_NON_BANKING() {
		return R11_OUTSTANDING_NON_BANKING;
	}
	public void setR11_OUTSTANDING_NON_BANKING(BigDecimal r11_OUTSTANDING_NON_BANKING) {
		R11_OUTSTANDING_NON_BANKING = r11_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR11_PROVISION_NON_BANKING() {
		return R11_PROVISION_NON_BANKING;
	}
	public void setR11_PROVISION_NON_BANKING(BigDecimal r11_PROVISION_NON_BANKING) {
		R11_PROVISION_NON_BANKING = r11_PROVISION_NON_BANKING;
	}
	public BigDecimal getR11_OUTSTANDING_INVESTMENT() {
		return R11_OUTSTANDING_INVESTMENT;
	}
	public void setR11_OUTSTANDING_INVESTMENT(BigDecimal r11_OUTSTANDING_INVESTMENT) {
		R11_OUTSTANDING_INVESTMENT = r11_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR11_PROVISION_INVESTMENT() {
		return R11_PROVISION_INVESTMENT;
	}
	public void setR11_PROVISION_INVESTMENT(BigDecimal r11_PROVISION_INVESTMENT) {
		R11_PROVISION_INVESTMENT = r11_PROVISION_INVESTMENT;
	}
	public BigDecimal getR11_OUTSTANDING_TRADE() {
		return R11_OUTSTANDING_TRADE;
	}
	public void setR11_OUTSTANDING_TRADE(BigDecimal r11_OUTSTANDING_TRADE) {
		R11_OUTSTANDING_TRADE = r11_OUTSTANDING_TRADE;
	}
	public BigDecimal getR11_PROVISION_TRADE() {
		return R11_PROVISION_TRADE;
	}
	public void setR11_PROVISION_TRADE(BigDecimal r11_PROVISION_TRADE) {
		R11_PROVISION_TRADE = r11_PROVISION_TRADE;
	}
	public BigDecimal getR11_OUTSTANDING_LOAN() {
		return R11_OUTSTANDING_LOAN;
	}
	public void setR11_OUTSTANDING_LOAN(BigDecimal r11_OUTSTANDING_LOAN) {
		R11_OUTSTANDING_LOAN = r11_OUTSTANDING_LOAN;
	}
	public BigDecimal getR11_PROVISION_LOAN() {
		return R11_PROVISION_LOAN;
	}
	public void setR11_PROVISION_LOAN(BigDecimal r11_PROVISION_LOAN) {
		R11_PROVISION_LOAN = r11_PROVISION_LOAN;
	}
	public BigDecimal getR11_OUTSTANDING_OTHER_ASSETS() {
		return R11_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR11_OUTSTANDING_OTHER_ASSETS(BigDecimal r11_OUTSTANDING_OTHER_ASSETS) {
		R11_OUTSTANDING_OTHER_ASSETS = r11_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR11_PROVISION_OTHER_ASSETS() {
		return R11_PROVISION_OTHER_ASSETS;
	}
	public void setR11_PROVISION_OTHER_ASSETS(BigDecimal r11_PROVISION_OTHER_ASSETS) {
		R11_PROVISION_OTHER_ASSETS = r11_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR11_OUTSTANDING_TOTAL() {
		return R11_OUTSTANDING_TOTAL;
	}
	public void setR11_OUTSTANDING_TOTAL(BigDecimal r11_OUTSTANDING_TOTAL) {
		R11_OUTSTANDING_TOTAL = r11_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR11_PROVISION_TOTAL() {
		return R11_PROVISION_TOTAL;
	}
	public void setR11_PROVISION_TOTAL(BigDecimal r11_PROVISION_TOTAL) {
		R11_PROVISION_TOTAL = r11_PROVISION_TOTAL;
	}
	public BigDecimal getR11_INTERESTS() {
		return R11_INTERESTS;
	}
	public void setR11_INTERESTS(BigDecimal r11_INTERESTS) {
		R11_INTERESTS = r11_INTERESTS;
	}
	public BigDecimal getR11_EXPOSURE() {
		return R11_EXPOSURE;
	}
	public void setR11_EXPOSURE(BigDecimal r11_EXPOSURE) {
		R11_EXPOSURE = r11_EXPOSURE;
	}
	public BigDecimal getR11_UNFUNDED() {
		return R11_UNFUNDED;
	}
	public void setR11_UNFUNDED(BigDecimal r11_UNFUNDED) {
		R11_UNFUNDED = r11_UNFUNDED;
	}
	public BigDecimal getR11_OUTSTANDING_UNFUNDED() {
		return R11_OUTSTANDING_UNFUNDED;
	}
	public void setR11_OUTSTANDING_UNFUNDED(BigDecimal r11_OUTSTANDING_UNFUNDED) {
		R11_OUTSTANDING_UNFUNDED = r11_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR11_PROVISION_UNFUNDED() {
		return R11_PROVISION_UNFUNDED;
	}
	public void setR11_PROVISION_UNFUNDED(BigDecimal r11_PROVISION_UNFUNDED) {
		R11_PROVISION_UNFUNDED = r11_PROVISION_UNFUNDED;
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
	public BigDecimal getR12_OUTSTANDING_CASH() {
		return R12_OUTSTANDING_CASH;
	}
	public void setR12_OUTSTANDING_CASH(BigDecimal r12_OUTSTANDING_CASH) {
		R12_OUTSTANDING_CASH = r12_OUTSTANDING_CASH;
	}
	public BigDecimal getR12_PROVISION_CASH() {
		return R12_PROVISION_CASH;
	}
	public void setR12_PROVISION_CASH(BigDecimal r12_PROVISION_CASH) {
		R12_PROVISION_CASH = r12_PROVISION_CASH;
	}
	public BigDecimal getR12_OUTSTANDING_BALANCE() {
		return R12_OUTSTANDING_BALANCE;
	}
	public void setR12_OUTSTANDING_BALANCE(BigDecimal r12_OUTSTANDING_BALANCE) {
		R12_OUTSTANDING_BALANCE = r12_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR12_PROVISION_BALANCE() {
		return R12_PROVISION_BALANCE;
	}
	public void setR12_PROVISION_BALANCE(BigDecimal r12_PROVISION_BALANCE) {
		R12_PROVISION_BALANCE = r12_PROVISION_BALANCE;
	}
	public BigDecimal getR12_OUTSTANDING_NON_BANKING() {
		return R12_OUTSTANDING_NON_BANKING;
	}
	public void setR12_OUTSTANDING_NON_BANKING(BigDecimal r12_OUTSTANDING_NON_BANKING) {
		R12_OUTSTANDING_NON_BANKING = r12_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR12_PROVISION_NON_BANKING() {
		return R12_PROVISION_NON_BANKING;
	}
	public void setR12_PROVISION_NON_BANKING(BigDecimal r12_PROVISION_NON_BANKING) {
		R12_PROVISION_NON_BANKING = r12_PROVISION_NON_BANKING;
	}
	public BigDecimal getR12_OUTSTANDING_INVESTMENT() {
		return R12_OUTSTANDING_INVESTMENT;
	}
	public void setR12_OUTSTANDING_INVESTMENT(BigDecimal r12_OUTSTANDING_INVESTMENT) {
		R12_OUTSTANDING_INVESTMENT = r12_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR12_PROVISION_INVESTMENT() {
		return R12_PROVISION_INVESTMENT;
	}
	public void setR12_PROVISION_INVESTMENT(BigDecimal r12_PROVISION_INVESTMENT) {
		R12_PROVISION_INVESTMENT = r12_PROVISION_INVESTMENT;
	}
	public BigDecimal getR12_OUTSTANDING_TRADE() {
		return R12_OUTSTANDING_TRADE;
	}
	public void setR12_OUTSTANDING_TRADE(BigDecimal r12_OUTSTANDING_TRADE) {
		R12_OUTSTANDING_TRADE = r12_OUTSTANDING_TRADE;
	}
	public BigDecimal getR12_PROVISION_TRADE() {
		return R12_PROVISION_TRADE;
	}
	public void setR12_PROVISION_TRADE(BigDecimal r12_PROVISION_TRADE) {
		R12_PROVISION_TRADE = r12_PROVISION_TRADE;
	}
	public BigDecimal getR12_OUTSTANDING_LOAN() {
		return R12_OUTSTANDING_LOAN;
	}
	public void setR12_OUTSTANDING_LOAN(BigDecimal r12_OUTSTANDING_LOAN) {
		R12_OUTSTANDING_LOAN = r12_OUTSTANDING_LOAN;
	}
	public BigDecimal getR12_PROVISION_LOAN() {
		return R12_PROVISION_LOAN;
	}
	public void setR12_PROVISION_LOAN(BigDecimal r12_PROVISION_LOAN) {
		R12_PROVISION_LOAN = r12_PROVISION_LOAN;
	}
	public BigDecimal getR12_OUTSTANDING_OTHER_ASSETS() {
		return R12_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR12_OUTSTANDING_OTHER_ASSETS(BigDecimal r12_OUTSTANDING_OTHER_ASSETS) {
		R12_OUTSTANDING_OTHER_ASSETS = r12_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR12_PROVISION_OTHER_ASSETS() {
		return R12_PROVISION_OTHER_ASSETS;
	}
	public void setR12_PROVISION_OTHER_ASSETS(BigDecimal r12_PROVISION_OTHER_ASSETS) {
		R12_PROVISION_OTHER_ASSETS = r12_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR12_OUTSTANDING_TOTAL() {
		return R12_OUTSTANDING_TOTAL;
	}
	public void setR12_OUTSTANDING_TOTAL(BigDecimal r12_OUTSTANDING_TOTAL) {
		R12_OUTSTANDING_TOTAL = r12_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR12_PROVISION_TOTAL() {
		return R12_PROVISION_TOTAL;
	}
	public void setR12_PROVISION_TOTAL(BigDecimal r12_PROVISION_TOTAL) {
		R12_PROVISION_TOTAL = r12_PROVISION_TOTAL;
	}
	public BigDecimal getR12_INTERESTS() {
		return R12_INTERESTS;
	}
	public void setR12_INTERESTS(BigDecimal r12_INTERESTS) {
		R12_INTERESTS = r12_INTERESTS;
	}
	public BigDecimal getR12_EXPOSURE() {
		return R12_EXPOSURE;
	}
	public void setR12_EXPOSURE(BigDecimal r12_EXPOSURE) {
		R12_EXPOSURE = r12_EXPOSURE;
	}
	public BigDecimal getR12_UNFUNDED() {
		return R12_UNFUNDED;
	}
	public void setR12_UNFUNDED(BigDecimal r12_UNFUNDED) {
		R12_UNFUNDED = r12_UNFUNDED;
	}
	public BigDecimal getR12_OUTSTANDING_UNFUNDED() {
		return R12_OUTSTANDING_UNFUNDED;
	}
	public void setR12_OUTSTANDING_UNFUNDED(BigDecimal r12_OUTSTANDING_UNFUNDED) {
		R12_OUTSTANDING_UNFUNDED = r12_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR12_PROVISION_UNFUNDED() {
		return R12_PROVISION_UNFUNDED;
	}
	public void setR12_PROVISION_UNFUNDED(BigDecimal r12_PROVISION_UNFUNDED) {
		R12_PROVISION_UNFUNDED = r12_PROVISION_UNFUNDED;
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
	public BigDecimal getR13_OUTSTANDING_CASH() {
		return R13_OUTSTANDING_CASH;
	}
	public void setR13_OUTSTANDING_CASH(BigDecimal r13_OUTSTANDING_CASH) {
		R13_OUTSTANDING_CASH = r13_OUTSTANDING_CASH;
	}
	public BigDecimal getR13_PROVISION_CASH() {
		return R13_PROVISION_CASH;
	}
	public void setR13_PROVISION_CASH(BigDecimal r13_PROVISION_CASH) {
		R13_PROVISION_CASH = r13_PROVISION_CASH;
	}
	public BigDecimal getR13_OUTSTANDING_BALANCE() {
		return R13_OUTSTANDING_BALANCE;
	}
	public void setR13_OUTSTANDING_BALANCE(BigDecimal r13_OUTSTANDING_BALANCE) {
		R13_OUTSTANDING_BALANCE = r13_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR13_PROVISION_BALANCE() {
		return R13_PROVISION_BALANCE;
	}
	public void setR13_PROVISION_BALANCE(BigDecimal r13_PROVISION_BALANCE) {
		R13_PROVISION_BALANCE = r13_PROVISION_BALANCE;
	}
	public BigDecimal getR13_OUTSTANDING_NON_BANKING() {
		return R13_OUTSTANDING_NON_BANKING;
	}
	public void setR13_OUTSTANDING_NON_BANKING(BigDecimal r13_OUTSTANDING_NON_BANKING) {
		R13_OUTSTANDING_NON_BANKING = r13_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR13_PROVISION_NON_BANKING() {
		return R13_PROVISION_NON_BANKING;
	}
	public void setR13_PROVISION_NON_BANKING(BigDecimal r13_PROVISION_NON_BANKING) {
		R13_PROVISION_NON_BANKING = r13_PROVISION_NON_BANKING;
	}
	public BigDecimal getR13_OUTSTANDING_INVESTMENT() {
		return R13_OUTSTANDING_INVESTMENT;
	}
	public void setR13_OUTSTANDING_INVESTMENT(BigDecimal r13_OUTSTANDING_INVESTMENT) {
		R13_OUTSTANDING_INVESTMENT = r13_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR13_PROVISION_INVESTMENT() {
		return R13_PROVISION_INVESTMENT;
	}
	public void setR13_PROVISION_INVESTMENT(BigDecimal r13_PROVISION_INVESTMENT) {
		R13_PROVISION_INVESTMENT = r13_PROVISION_INVESTMENT;
	}
	public BigDecimal getR13_OUTSTANDING_TRADE() {
		return R13_OUTSTANDING_TRADE;
	}
	public void setR13_OUTSTANDING_TRADE(BigDecimal r13_OUTSTANDING_TRADE) {
		R13_OUTSTANDING_TRADE = r13_OUTSTANDING_TRADE;
	}
	public BigDecimal getR13_PROVISION_TRADE() {
		return R13_PROVISION_TRADE;
	}
	public void setR13_PROVISION_TRADE(BigDecimal r13_PROVISION_TRADE) {
		R13_PROVISION_TRADE = r13_PROVISION_TRADE;
	}
	public BigDecimal getR13_OUTSTANDING_LOAN() {
		return R13_OUTSTANDING_LOAN;
	}
	public void setR13_OUTSTANDING_LOAN(BigDecimal r13_OUTSTANDING_LOAN) {
		R13_OUTSTANDING_LOAN = r13_OUTSTANDING_LOAN;
	}
	public BigDecimal getR13_PROVISION_LOAN() {
		return R13_PROVISION_LOAN;
	}
	public void setR13_PROVISION_LOAN(BigDecimal r13_PROVISION_LOAN) {
		R13_PROVISION_LOAN = r13_PROVISION_LOAN;
	}
	public BigDecimal getR13_OUTSTANDING_OTHER_ASSETS() {
		return R13_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR13_OUTSTANDING_OTHER_ASSETS(BigDecimal r13_OUTSTANDING_OTHER_ASSETS) {
		R13_OUTSTANDING_OTHER_ASSETS = r13_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR13_PROVISION_OTHER_ASSETS() {
		return R13_PROVISION_OTHER_ASSETS;
	}
	public void setR13_PROVISION_OTHER_ASSETS(BigDecimal r13_PROVISION_OTHER_ASSETS) {
		R13_PROVISION_OTHER_ASSETS = r13_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR13_OUTSTANDING_TOTAL() {
		return R13_OUTSTANDING_TOTAL;
	}
	public void setR13_OUTSTANDING_TOTAL(BigDecimal r13_OUTSTANDING_TOTAL) {
		R13_OUTSTANDING_TOTAL = r13_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR13_PROVISION_TOTAL() {
		return R13_PROVISION_TOTAL;
	}
	public void setR13_PROVISION_TOTAL(BigDecimal r13_PROVISION_TOTAL) {
		R13_PROVISION_TOTAL = r13_PROVISION_TOTAL;
	}
	public BigDecimal getR13_INTERESTS() {
		return R13_INTERESTS;
	}
	public void setR13_INTERESTS(BigDecimal r13_INTERESTS) {
		R13_INTERESTS = r13_INTERESTS;
	}
	public BigDecimal getR13_EXPOSURE() {
		return R13_EXPOSURE;
	}
	public void setR13_EXPOSURE(BigDecimal r13_EXPOSURE) {
		R13_EXPOSURE = r13_EXPOSURE;
	}
	public BigDecimal getR13_UNFUNDED() {
		return R13_UNFUNDED;
	}
	public void setR13_UNFUNDED(BigDecimal r13_UNFUNDED) {
		R13_UNFUNDED = r13_UNFUNDED;
	}
	public BigDecimal getR13_OUTSTANDING_UNFUNDED() {
		return R13_OUTSTANDING_UNFUNDED;
	}
	public void setR13_OUTSTANDING_UNFUNDED(BigDecimal r13_OUTSTANDING_UNFUNDED) {
		R13_OUTSTANDING_UNFUNDED = r13_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR13_PROVISION_UNFUNDED() {
		return R13_PROVISION_UNFUNDED;
	}
	public void setR13_PROVISION_UNFUNDED(BigDecimal r13_PROVISION_UNFUNDED) {
		R13_PROVISION_UNFUNDED = r13_PROVISION_UNFUNDED;
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
	public BigDecimal getR14_OUTSTANDING_CASH() {
		return R14_OUTSTANDING_CASH;
	}
	public void setR14_OUTSTANDING_CASH(BigDecimal r14_OUTSTANDING_CASH) {
		R14_OUTSTANDING_CASH = r14_OUTSTANDING_CASH;
	}
	public BigDecimal getR14_PROVISION_CASH() {
		return R14_PROVISION_CASH;
	}
	public void setR14_PROVISION_CASH(BigDecimal r14_PROVISION_CASH) {
		R14_PROVISION_CASH = r14_PROVISION_CASH;
	}
	public BigDecimal getR14_OUTSTANDING_BALANCE() {
		return R14_OUTSTANDING_BALANCE;
	}
	public void setR14_OUTSTANDING_BALANCE(BigDecimal r14_OUTSTANDING_BALANCE) {
		R14_OUTSTANDING_BALANCE = r14_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR14_PROVISION_BALANCE() {
		return R14_PROVISION_BALANCE;
	}
	public void setR14_PROVISION_BALANCE(BigDecimal r14_PROVISION_BALANCE) {
		R14_PROVISION_BALANCE = r14_PROVISION_BALANCE;
	}
	public BigDecimal getR14_OUTSTANDING_NON_BANKING() {
		return R14_OUTSTANDING_NON_BANKING;
	}
	public void setR14_OUTSTANDING_NON_BANKING(BigDecimal r14_OUTSTANDING_NON_BANKING) {
		R14_OUTSTANDING_NON_BANKING = r14_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR14_PROVISION_NON_BANKING() {
		return R14_PROVISION_NON_BANKING;
	}
	public void setR14_PROVISION_NON_BANKING(BigDecimal r14_PROVISION_NON_BANKING) {
		R14_PROVISION_NON_BANKING = r14_PROVISION_NON_BANKING;
	}
	public BigDecimal getR14_OUTSTANDING_INVESTMENT() {
		return R14_OUTSTANDING_INVESTMENT;
	}
	public void setR14_OUTSTANDING_INVESTMENT(BigDecimal r14_OUTSTANDING_INVESTMENT) {
		R14_OUTSTANDING_INVESTMENT = r14_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR14_PROVISION_INVESTMENT() {
		return R14_PROVISION_INVESTMENT;
	}
	public void setR14_PROVISION_INVESTMENT(BigDecimal r14_PROVISION_INVESTMENT) {
		R14_PROVISION_INVESTMENT = r14_PROVISION_INVESTMENT;
	}
	public BigDecimal getR14_OUTSTANDING_TRADE() {
		return R14_OUTSTANDING_TRADE;
	}
	public void setR14_OUTSTANDING_TRADE(BigDecimal r14_OUTSTANDING_TRADE) {
		R14_OUTSTANDING_TRADE = r14_OUTSTANDING_TRADE;
	}
	public BigDecimal getR14_PROVISION_TRADE() {
		return R14_PROVISION_TRADE;
	}
	public void setR14_PROVISION_TRADE(BigDecimal r14_PROVISION_TRADE) {
		R14_PROVISION_TRADE = r14_PROVISION_TRADE;
	}
	public BigDecimal getR14_OUTSTANDING_LOAN() {
		return R14_OUTSTANDING_LOAN;
	}
	public void setR14_OUTSTANDING_LOAN(BigDecimal r14_OUTSTANDING_LOAN) {
		R14_OUTSTANDING_LOAN = r14_OUTSTANDING_LOAN;
	}
	public BigDecimal getR14_PROVISION_LOAN() {
		return R14_PROVISION_LOAN;
	}
	public void setR14_PROVISION_LOAN(BigDecimal r14_PROVISION_LOAN) {
		R14_PROVISION_LOAN = r14_PROVISION_LOAN;
	}
	public BigDecimal getR14_OUTSTANDING_OTHER_ASSETS() {
		return R14_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR14_OUTSTANDING_OTHER_ASSETS(BigDecimal r14_OUTSTANDING_OTHER_ASSETS) {
		R14_OUTSTANDING_OTHER_ASSETS = r14_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR14_PROVISION_OTHER_ASSETS() {
		return R14_PROVISION_OTHER_ASSETS;
	}
	public void setR14_PROVISION_OTHER_ASSETS(BigDecimal r14_PROVISION_OTHER_ASSETS) {
		R14_PROVISION_OTHER_ASSETS = r14_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR14_OUTSTANDING_TOTAL() {
		return R14_OUTSTANDING_TOTAL;
	}
	public void setR14_OUTSTANDING_TOTAL(BigDecimal r14_OUTSTANDING_TOTAL) {
		R14_OUTSTANDING_TOTAL = r14_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR14_PROVISION_TOTAL() {
		return R14_PROVISION_TOTAL;
	}
	public void setR14_PROVISION_TOTAL(BigDecimal r14_PROVISION_TOTAL) {
		R14_PROVISION_TOTAL = r14_PROVISION_TOTAL;
	}
	public BigDecimal getR14_INTERESTS() {
		return R14_INTERESTS;
	}
	public void setR14_INTERESTS(BigDecimal r14_INTERESTS) {
		R14_INTERESTS = r14_INTERESTS;
	}
	public BigDecimal getR14_EXPOSURE() {
		return R14_EXPOSURE;
	}
	public void setR14_EXPOSURE(BigDecimal r14_EXPOSURE) {
		R14_EXPOSURE = r14_EXPOSURE;
	}
	public BigDecimal getR14_UNFUNDED() {
		return R14_UNFUNDED;
	}
	public void setR14_UNFUNDED(BigDecimal r14_UNFUNDED) {
		R14_UNFUNDED = r14_UNFUNDED;
	}
	public BigDecimal getR14_OUTSTANDING_UNFUNDED() {
		return R14_OUTSTANDING_UNFUNDED;
	}
	public void setR14_OUTSTANDING_UNFUNDED(BigDecimal r14_OUTSTANDING_UNFUNDED) {
		R14_OUTSTANDING_UNFUNDED = r14_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR14_PROVISION_UNFUNDED() {
		return R14_PROVISION_UNFUNDED;
	}
	public void setR14_PROVISION_UNFUNDED(BigDecimal r14_PROVISION_UNFUNDED) {
		R14_PROVISION_UNFUNDED = r14_PROVISION_UNFUNDED;
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
	public BigDecimal getR15_OUTSTANDING_CASH() {
		return R15_OUTSTANDING_CASH;
	}
	public void setR15_OUTSTANDING_CASH(BigDecimal r15_OUTSTANDING_CASH) {
		R15_OUTSTANDING_CASH = r15_OUTSTANDING_CASH;
	}
	public BigDecimal getR15_PROVISION_CASH() {
		return R15_PROVISION_CASH;
	}
	public void setR15_PROVISION_CASH(BigDecimal r15_PROVISION_CASH) {
		R15_PROVISION_CASH = r15_PROVISION_CASH;
	}
	public BigDecimal getR15_OUTSTANDING_BALANCE() {
		return R15_OUTSTANDING_BALANCE;
	}
	public void setR15_OUTSTANDING_BALANCE(BigDecimal r15_OUTSTANDING_BALANCE) {
		R15_OUTSTANDING_BALANCE = r15_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR15_PROVISION_BALANCE() {
		return R15_PROVISION_BALANCE;
	}
	public void setR15_PROVISION_BALANCE(BigDecimal r15_PROVISION_BALANCE) {
		R15_PROVISION_BALANCE = r15_PROVISION_BALANCE;
	}
	public BigDecimal getR15_OUTSTANDING_NON_BANKING() {
		return R15_OUTSTANDING_NON_BANKING;
	}
	public void setR15_OUTSTANDING_NON_BANKING(BigDecimal r15_OUTSTANDING_NON_BANKING) {
		R15_OUTSTANDING_NON_BANKING = r15_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR15_PROVISION_NON_BANKING() {
		return R15_PROVISION_NON_BANKING;
	}
	public void setR15_PROVISION_NON_BANKING(BigDecimal r15_PROVISION_NON_BANKING) {
		R15_PROVISION_NON_BANKING = r15_PROVISION_NON_BANKING;
	}
	public BigDecimal getR15_OUTSTANDING_INVESTMENT() {
		return R15_OUTSTANDING_INVESTMENT;
	}
	public void setR15_OUTSTANDING_INVESTMENT(BigDecimal r15_OUTSTANDING_INVESTMENT) {
		R15_OUTSTANDING_INVESTMENT = r15_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR15_PROVISION_INVESTMENT() {
		return R15_PROVISION_INVESTMENT;
	}
	public void setR15_PROVISION_INVESTMENT(BigDecimal r15_PROVISION_INVESTMENT) {
		R15_PROVISION_INVESTMENT = r15_PROVISION_INVESTMENT;
	}
	public BigDecimal getR15_OUTSTANDING_TRADE() {
		return R15_OUTSTANDING_TRADE;
	}
	public void setR15_OUTSTANDING_TRADE(BigDecimal r15_OUTSTANDING_TRADE) {
		R15_OUTSTANDING_TRADE = r15_OUTSTANDING_TRADE;
	}
	public BigDecimal getR15_PROVISION_TRADE() {
		return R15_PROVISION_TRADE;
	}
	public void setR15_PROVISION_TRADE(BigDecimal r15_PROVISION_TRADE) {
		R15_PROVISION_TRADE = r15_PROVISION_TRADE;
	}
	public BigDecimal getR15_OUTSTANDING_LOAN() {
		return R15_OUTSTANDING_LOAN;
	}
	public void setR15_OUTSTANDING_LOAN(BigDecimal r15_OUTSTANDING_LOAN) {
		R15_OUTSTANDING_LOAN = r15_OUTSTANDING_LOAN;
	}
	public BigDecimal getR15_PROVISION_LOAN() {
		return R15_PROVISION_LOAN;
	}
	public void setR15_PROVISION_LOAN(BigDecimal r15_PROVISION_LOAN) {
		R15_PROVISION_LOAN = r15_PROVISION_LOAN;
	}
	public BigDecimal getR15_OUTSTANDING_OTHER_ASSETS() {
		return R15_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR15_OUTSTANDING_OTHER_ASSETS(BigDecimal r15_OUTSTANDING_OTHER_ASSETS) {
		R15_OUTSTANDING_OTHER_ASSETS = r15_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR15_PROVISION_OTHER_ASSETS() {
		return R15_PROVISION_OTHER_ASSETS;
	}
	public void setR15_PROVISION_OTHER_ASSETS(BigDecimal r15_PROVISION_OTHER_ASSETS) {
		R15_PROVISION_OTHER_ASSETS = r15_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR15_OUTSTANDING_TOTAL() {
		return R15_OUTSTANDING_TOTAL;
	}
	public void setR15_OUTSTANDING_TOTAL(BigDecimal r15_OUTSTANDING_TOTAL) {
		R15_OUTSTANDING_TOTAL = r15_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR15_PROVISION_TOTAL() {
		return R15_PROVISION_TOTAL;
	}
	public void setR15_PROVISION_TOTAL(BigDecimal r15_PROVISION_TOTAL) {
		R15_PROVISION_TOTAL = r15_PROVISION_TOTAL;
	}
	public BigDecimal getR15_INTERESTS() {
		return R15_INTERESTS;
	}
	public void setR15_INTERESTS(BigDecimal r15_INTERESTS) {
		R15_INTERESTS = r15_INTERESTS;
	}
	public BigDecimal getR15_EXPOSURE() {
		return R15_EXPOSURE;
	}
	public void setR15_EXPOSURE(BigDecimal r15_EXPOSURE) {
		R15_EXPOSURE = r15_EXPOSURE;
	}
	public BigDecimal getR15_UNFUNDED() {
		return R15_UNFUNDED;
	}
	public void setR15_UNFUNDED(BigDecimal r15_UNFUNDED) {
		R15_UNFUNDED = r15_UNFUNDED;
	}
	public BigDecimal getR15_OUTSTANDING_UNFUNDED() {
		return R15_OUTSTANDING_UNFUNDED;
	}
	public void setR15_OUTSTANDING_UNFUNDED(BigDecimal r15_OUTSTANDING_UNFUNDED) {
		R15_OUTSTANDING_UNFUNDED = r15_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR15_PROVISION_UNFUNDED() {
		return R15_PROVISION_UNFUNDED;
	}
	public void setR15_PROVISION_UNFUNDED(BigDecimal r15_PROVISION_UNFUNDED) {
		R15_PROVISION_UNFUNDED = r15_PROVISION_UNFUNDED;
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
	public BigDecimal getR16_OUTSTANDING_CASH() {
		return R16_OUTSTANDING_CASH;
	}
	public void setR16_OUTSTANDING_CASH(BigDecimal r16_OUTSTANDING_CASH) {
		R16_OUTSTANDING_CASH = r16_OUTSTANDING_CASH;
	}
	public BigDecimal getR16_PROVISION_CASH() {
		return R16_PROVISION_CASH;
	}
	public void setR16_PROVISION_CASH(BigDecimal r16_PROVISION_CASH) {
		R16_PROVISION_CASH = r16_PROVISION_CASH;
	}
	public BigDecimal getR16_OUTSTANDING_BALANCE() {
		return R16_OUTSTANDING_BALANCE;
	}
	public void setR16_OUTSTANDING_BALANCE(BigDecimal r16_OUTSTANDING_BALANCE) {
		R16_OUTSTANDING_BALANCE = r16_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR16_PROVISION_BALANCE() {
		return R16_PROVISION_BALANCE;
	}
	public void setR16_PROVISION_BALANCE(BigDecimal r16_PROVISION_BALANCE) {
		R16_PROVISION_BALANCE = r16_PROVISION_BALANCE;
	}
	public BigDecimal getR16_OUTSTANDING_NON_BANKING() {
		return R16_OUTSTANDING_NON_BANKING;
	}
	public void setR16_OUTSTANDING_NON_BANKING(BigDecimal r16_OUTSTANDING_NON_BANKING) {
		R16_OUTSTANDING_NON_BANKING = r16_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR16_PROVISION_NON_BANKING() {
		return R16_PROVISION_NON_BANKING;
	}
	public void setR16_PROVISION_NON_BANKING(BigDecimal r16_PROVISION_NON_BANKING) {
		R16_PROVISION_NON_BANKING = r16_PROVISION_NON_BANKING;
	}
	public BigDecimal getR16_OUTSTANDING_INVESTMENT() {
		return R16_OUTSTANDING_INVESTMENT;
	}
	public void setR16_OUTSTANDING_INVESTMENT(BigDecimal r16_OUTSTANDING_INVESTMENT) {
		R16_OUTSTANDING_INVESTMENT = r16_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR16_PROVISION_INVESTMENT() {
		return R16_PROVISION_INVESTMENT;
	}
	public void setR16_PROVISION_INVESTMENT(BigDecimal r16_PROVISION_INVESTMENT) {
		R16_PROVISION_INVESTMENT = r16_PROVISION_INVESTMENT;
	}
	public BigDecimal getR16_OUTSTANDING_TRADE() {
		return R16_OUTSTANDING_TRADE;
	}
	public void setR16_OUTSTANDING_TRADE(BigDecimal r16_OUTSTANDING_TRADE) {
		R16_OUTSTANDING_TRADE = r16_OUTSTANDING_TRADE;
	}
	public BigDecimal getR16_PROVISION_TRADE() {
		return R16_PROVISION_TRADE;
	}
	public void setR16_PROVISION_TRADE(BigDecimal r16_PROVISION_TRADE) {
		R16_PROVISION_TRADE = r16_PROVISION_TRADE;
	}
	public BigDecimal getR16_OUTSTANDING_LOAN() {
		return R16_OUTSTANDING_LOAN;
	}
	public void setR16_OUTSTANDING_LOAN(BigDecimal r16_OUTSTANDING_LOAN) {
		R16_OUTSTANDING_LOAN = r16_OUTSTANDING_LOAN;
	}
	public BigDecimal getR16_PROVISION_LOAN() {
		return R16_PROVISION_LOAN;
	}
	public void setR16_PROVISION_LOAN(BigDecimal r16_PROVISION_LOAN) {
		R16_PROVISION_LOAN = r16_PROVISION_LOAN;
	}
	public BigDecimal getR16_OUTSTANDING_OTHER_ASSETS() {
		return R16_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR16_OUTSTANDING_OTHER_ASSETS(BigDecimal r16_OUTSTANDING_OTHER_ASSETS) {
		R16_OUTSTANDING_OTHER_ASSETS = r16_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR16_PROVISION_OTHER_ASSETS() {
		return R16_PROVISION_OTHER_ASSETS;
	}
	public void setR16_PROVISION_OTHER_ASSETS(BigDecimal r16_PROVISION_OTHER_ASSETS) {
		R16_PROVISION_OTHER_ASSETS = r16_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR16_OUTSTANDING_TOTAL() {
		return R16_OUTSTANDING_TOTAL;
	}
	public void setR16_OUTSTANDING_TOTAL(BigDecimal r16_OUTSTANDING_TOTAL) {
		R16_OUTSTANDING_TOTAL = r16_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR16_PROVISION_TOTAL() {
		return R16_PROVISION_TOTAL;
	}
	public void setR16_PROVISION_TOTAL(BigDecimal r16_PROVISION_TOTAL) {
		R16_PROVISION_TOTAL = r16_PROVISION_TOTAL;
	}
	public BigDecimal getR16_INTERESTS() {
		return R16_INTERESTS;
	}
	public void setR16_INTERESTS(BigDecimal r16_INTERESTS) {
		R16_INTERESTS = r16_INTERESTS;
	}
	public BigDecimal getR16_EXPOSURE() {
		return R16_EXPOSURE;
	}
	public void setR16_EXPOSURE(BigDecimal r16_EXPOSURE) {
		R16_EXPOSURE = r16_EXPOSURE;
	}
	public BigDecimal getR16_UNFUNDED() {
		return R16_UNFUNDED;
	}
	public void setR16_UNFUNDED(BigDecimal r16_UNFUNDED) {
		R16_UNFUNDED = r16_UNFUNDED;
	}
	public BigDecimal getR16_OUTSTANDING_UNFUNDED() {
		return R16_OUTSTANDING_UNFUNDED;
	}
	public void setR16_OUTSTANDING_UNFUNDED(BigDecimal r16_OUTSTANDING_UNFUNDED) {
		R16_OUTSTANDING_UNFUNDED = r16_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR16_PROVISION_UNFUNDED() {
		return R16_PROVISION_UNFUNDED;
	}
	public void setR16_PROVISION_UNFUNDED(BigDecimal r16_PROVISION_UNFUNDED) {
		R16_PROVISION_UNFUNDED = r16_PROVISION_UNFUNDED;
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
	public BigDecimal getR17_OUTSTANDING_CASH() {
		return R17_OUTSTANDING_CASH;
	}
	public void setR17_OUTSTANDING_CASH(BigDecimal r17_OUTSTANDING_CASH) {
		R17_OUTSTANDING_CASH = r17_OUTSTANDING_CASH;
	}
	public BigDecimal getR17_PROVISION_CASH() {
		return R17_PROVISION_CASH;
	}
	public void setR17_PROVISION_CASH(BigDecimal r17_PROVISION_CASH) {
		R17_PROVISION_CASH = r17_PROVISION_CASH;
	}
	public BigDecimal getR17_OUTSTANDING_BALANCE() {
		return R17_OUTSTANDING_BALANCE;
	}
	public void setR17_OUTSTANDING_BALANCE(BigDecimal r17_OUTSTANDING_BALANCE) {
		R17_OUTSTANDING_BALANCE = r17_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR17_PROVISION_BALANCE() {
		return R17_PROVISION_BALANCE;
	}
	public void setR17_PROVISION_BALANCE(BigDecimal r17_PROVISION_BALANCE) {
		R17_PROVISION_BALANCE = r17_PROVISION_BALANCE;
	}
	public BigDecimal getR17_OUTSTANDING_NON_BANKING() {
		return R17_OUTSTANDING_NON_BANKING;
	}
	public void setR17_OUTSTANDING_NON_BANKING(BigDecimal r17_OUTSTANDING_NON_BANKING) {
		R17_OUTSTANDING_NON_BANKING = r17_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR17_PROVISION_NON_BANKING() {
		return R17_PROVISION_NON_BANKING;
	}
	public void setR17_PROVISION_NON_BANKING(BigDecimal r17_PROVISION_NON_BANKING) {
		R17_PROVISION_NON_BANKING = r17_PROVISION_NON_BANKING;
	}
	public BigDecimal getR17_OUTSTANDING_INVESTMENT() {
		return R17_OUTSTANDING_INVESTMENT;
	}
	public void setR17_OUTSTANDING_INVESTMENT(BigDecimal r17_OUTSTANDING_INVESTMENT) {
		R17_OUTSTANDING_INVESTMENT = r17_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR17_PROVISION_INVESTMENT() {
		return R17_PROVISION_INVESTMENT;
	}
	public void setR17_PROVISION_INVESTMENT(BigDecimal r17_PROVISION_INVESTMENT) {
		R17_PROVISION_INVESTMENT = r17_PROVISION_INVESTMENT;
	}
	public BigDecimal getR17_OUTSTANDING_TRADE() {
		return R17_OUTSTANDING_TRADE;
	}
	public void setR17_OUTSTANDING_TRADE(BigDecimal r17_OUTSTANDING_TRADE) {
		R17_OUTSTANDING_TRADE = r17_OUTSTANDING_TRADE;
	}
	public BigDecimal getR17_PROVISION_TRADE() {
		return R17_PROVISION_TRADE;
	}
	public void setR17_PROVISION_TRADE(BigDecimal r17_PROVISION_TRADE) {
		R17_PROVISION_TRADE = r17_PROVISION_TRADE;
	}
	public BigDecimal getR17_OUTSTANDING_LOAN() {
		return R17_OUTSTANDING_LOAN;
	}
	public void setR17_OUTSTANDING_LOAN(BigDecimal r17_OUTSTANDING_LOAN) {
		R17_OUTSTANDING_LOAN = r17_OUTSTANDING_LOAN;
	}
	public BigDecimal getR17_PROVISION_LOAN() {
		return R17_PROVISION_LOAN;
	}
	public void setR17_PROVISION_LOAN(BigDecimal r17_PROVISION_LOAN) {
		R17_PROVISION_LOAN = r17_PROVISION_LOAN;
	}
	public BigDecimal getR17_OUTSTANDING_OTHER_ASSETS() {
		return R17_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR17_OUTSTANDING_OTHER_ASSETS(BigDecimal r17_OUTSTANDING_OTHER_ASSETS) {
		R17_OUTSTANDING_OTHER_ASSETS = r17_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR17_PROVISION_OTHER_ASSETS() {
		return R17_PROVISION_OTHER_ASSETS;
	}
	public void setR17_PROVISION_OTHER_ASSETS(BigDecimal r17_PROVISION_OTHER_ASSETS) {
		R17_PROVISION_OTHER_ASSETS = r17_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR17_OUTSTANDING_TOTAL() {
		return R17_OUTSTANDING_TOTAL;
	}
	public void setR17_OUTSTANDING_TOTAL(BigDecimal r17_OUTSTANDING_TOTAL) {
		R17_OUTSTANDING_TOTAL = r17_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR17_PROVISION_TOTAL() {
		return R17_PROVISION_TOTAL;
	}
	public void setR17_PROVISION_TOTAL(BigDecimal r17_PROVISION_TOTAL) {
		R17_PROVISION_TOTAL = r17_PROVISION_TOTAL;
	}
	public BigDecimal getR17_INTERESTS() {
		return R17_INTERESTS;
	}
	public void setR17_INTERESTS(BigDecimal r17_INTERESTS) {
		R17_INTERESTS = r17_INTERESTS;
	}
	public BigDecimal getR17_EXPOSURE() {
		return R17_EXPOSURE;
	}
	public void setR17_EXPOSURE(BigDecimal r17_EXPOSURE) {
		R17_EXPOSURE = r17_EXPOSURE;
	}
	public BigDecimal getR17_UNFUNDED() {
		return R17_UNFUNDED;
	}
	public void setR17_UNFUNDED(BigDecimal r17_UNFUNDED) {
		R17_UNFUNDED = r17_UNFUNDED;
	}
	public BigDecimal getR17_OUTSTANDING_UNFUNDED() {
		return R17_OUTSTANDING_UNFUNDED;
	}
	public void setR17_OUTSTANDING_UNFUNDED(BigDecimal r17_OUTSTANDING_UNFUNDED) {
		R17_OUTSTANDING_UNFUNDED = r17_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR17_PROVISION_UNFUNDED() {
		return R17_PROVISION_UNFUNDED;
	}
	public void setR17_PROVISION_UNFUNDED(BigDecimal r17_PROVISION_UNFUNDED) {
		R17_PROVISION_UNFUNDED = r17_PROVISION_UNFUNDED;
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
	public BigDecimal getR18_OUTSTANDING_CASH() {
		return R18_OUTSTANDING_CASH;
	}
	public void setR18_OUTSTANDING_CASH(BigDecimal r18_OUTSTANDING_CASH) {
		R18_OUTSTANDING_CASH = r18_OUTSTANDING_CASH;
	}
	public BigDecimal getR18_PROVISION_CASH() {
		return R18_PROVISION_CASH;
	}
	public void setR18_PROVISION_CASH(BigDecimal r18_PROVISION_CASH) {
		R18_PROVISION_CASH = r18_PROVISION_CASH;
	}
	public BigDecimal getR18_OUTSTANDING_BALANCE() {
		return R18_OUTSTANDING_BALANCE;
	}
	public void setR18_OUTSTANDING_BALANCE(BigDecimal r18_OUTSTANDING_BALANCE) {
		R18_OUTSTANDING_BALANCE = r18_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR18_PROVISION_BALANCE() {
		return R18_PROVISION_BALANCE;
	}
	public void setR18_PROVISION_BALANCE(BigDecimal r18_PROVISION_BALANCE) {
		R18_PROVISION_BALANCE = r18_PROVISION_BALANCE;
	}
	public BigDecimal getR18_OUTSTANDING_NON_BANKING() {
		return R18_OUTSTANDING_NON_BANKING;
	}
	public void setR18_OUTSTANDING_NON_BANKING(BigDecimal r18_OUTSTANDING_NON_BANKING) {
		R18_OUTSTANDING_NON_BANKING = r18_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR18_PROVISION_NON_BANKING() {
		return R18_PROVISION_NON_BANKING;
	}
	public void setR18_PROVISION_NON_BANKING(BigDecimal r18_PROVISION_NON_BANKING) {
		R18_PROVISION_NON_BANKING = r18_PROVISION_NON_BANKING;
	}
	public BigDecimal getR18_OUTSTANDING_INVESTMENT() {
		return R18_OUTSTANDING_INVESTMENT;
	}
	public void setR18_OUTSTANDING_INVESTMENT(BigDecimal r18_OUTSTANDING_INVESTMENT) {
		R18_OUTSTANDING_INVESTMENT = r18_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR18_PROVISION_INVESTMENT() {
		return R18_PROVISION_INVESTMENT;
	}
	public void setR18_PROVISION_INVESTMENT(BigDecimal r18_PROVISION_INVESTMENT) {
		R18_PROVISION_INVESTMENT = r18_PROVISION_INVESTMENT;
	}
	public BigDecimal getR18_OUTSTANDING_TRADE() {
		return R18_OUTSTANDING_TRADE;
	}
	public void setR18_OUTSTANDING_TRADE(BigDecimal r18_OUTSTANDING_TRADE) {
		R18_OUTSTANDING_TRADE = r18_OUTSTANDING_TRADE;
	}
	public BigDecimal getR18_PROVISION_TRADE() {
		return R18_PROVISION_TRADE;
	}
	public void setR18_PROVISION_TRADE(BigDecimal r18_PROVISION_TRADE) {
		R18_PROVISION_TRADE = r18_PROVISION_TRADE;
	}
	public BigDecimal getR18_OUTSTANDING_LOAN() {
		return R18_OUTSTANDING_LOAN;
	}
	public void setR18_OUTSTANDING_LOAN(BigDecimal r18_OUTSTANDING_LOAN) {
		R18_OUTSTANDING_LOAN = r18_OUTSTANDING_LOAN;
	}
	public BigDecimal getR18_PROVISION_LOAN() {
		return R18_PROVISION_LOAN;
	}
	public void setR18_PROVISION_LOAN(BigDecimal r18_PROVISION_LOAN) {
		R18_PROVISION_LOAN = r18_PROVISION_LOAN;
	}
	public BigDecimal getR18_OUTSTANDING_OTHER_ASSETS() {
		return R18_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR18_OUTSTANDING_OTHER_ASSETS(BigDecimal r18_OUTSTANDING_OTHER_ASSETS) {
		R18_OUTSTANDING_OTHER_ASSETS = r18_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR18_PROVISION_OTHER_ASSETS() {
		return R18_PROVISION_OTHER_ASSETS;
	}
	public void setR18_PROVISION_OTHER_ASSETS(BigDecimal r18_PROVISION_OTHER_ASSETS) {
		R18_PROVISION_OTHER_ASSETS = r18_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR18_OUTSTANDING_TOTAL() {
		return R18_OUTSTANDING_TOTAL;
	}
	public void setR18_OUTSTANDING_TOTAL(BigDecimal r18_OUTSTANDING_TOTAL) {
		R18_OUTSTANDING_TOTAL = r18_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR18_PROVISION_TOTAL() {
		return R18_PROVISION_TOTAL;
	}
	public void setR18_PROVISION_TOTAL(BigDecimal r18_PROVISION_TOTAL) {
		R18_PROVISION_TOTAL = r18_PROVISION_TOTAL;
	}
	public BigDecimal getR18_INTERESTS() {
		return R18_INTERESTS;
	}
	public void setR18_INTERESTS(BigDecimal r18_INTERESTS) {
		R18_INTERESTS = r18_INTERESTS;
	}
	public BigDecimal getR18_EXPOSURE() {
		return R18_EXPOSURE;
	}
	public void setR18_EXPOSURE(BigDecimal r18_EXPOSURE) {
		R18_EXPOSURE = r18_EXPOSURE;
	}
	public BigDecimal getR18_UNFUNDED() {
		return R18_UNFUNDED;
	}
	public void setR18_UNFUNDED(BigDecimal r18_UNFUNDED) {
		R18_UNFUNDED = r18_UNFUNDED;
	}
	public BigDecimal getR18_OUTSTANDING_UNFUNDED() {
		return R18_OUTSTANDING_UNFUNDED;
	}
	public void setR18_OUTSTANDING_UNFUNDED(BigDecimal r18_OUTSTANDING_UNFUNDED) {
		R18_OUTSTANDING_UNFUNDED = r18_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR18_PROVISION_UNFUNDED() {
		return R18_PROVISION_UNFUNDED;
	}
	public void setR18_PROVISION_UNFUNDED(BigDecimal r18_PROVISION_UNFUNDED) {
		R18_PROVISION_UNFUNDED = r18_PROVISION_UNFUNDED;
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
	public BigDecimal getR19_OUTSTANDING_CASH() {
		return R19_OUTSTANDING_CASH;
	}
	public void setR19_OUTSTANDING_CASH(BigDecimal r19_OUTSTANDING_CASH) {
		R19_OUTSTANDING_CASH = r19_OUTSTANDING_CASH;
	}
	public BigDecimal getR19_PROVISION_CASH() {
		return R19_PROVISION_CASH;
	}
	public void setR19_PROVISION_CASH(BigDecimal r19_PROVISION_CASH) {
		R19_PROVISION_CASH = r19_PROVISION_CASH;
	}
	public BigDecimal getR19_OUTSTANDING_BALANCE() {
		return R19_OUTSTANDING_BALANCE;
	}
	public void setR19_OUTSTANDING_BALANCE(BigDecimal r19_OUTSTANDING_BALANCE) {
		R19_OUTSTANDING_BALANCE = r19_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR19_PROVISION_BALANCE() {
		return R19_PROVISION_BALANCE;
	}
	public void setR19_PROVISION_BALANCE(BigDecimal r19_PROVISION_BALANCE) {
		R19_PROVISION_BALANCE = r19_PROVISION_BALANCE;
	}
	public BigDecimal getR19_OUTSTANDING_NON_BANKING() {
		return R19_OUTSTANDING_NON_BANKING;
	}
	public void setR19_OUTSTANDING_NON_BANKING(BigDecimal r19_OUTSTANDING_NON_BANKING) {
		R19_OUTSTANDING_NON_BANKING = r19_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR19_PROVISION_NON_BANKING() {
		return R19_PROVISION_NON_BANKING;
	}
	public void setR19_PROVISION_NON_BANKING(BigDecimal r19_PROVISION_NON_BANKING) {
		R19_PROVISION_NON_BANKING = r19_PROVISION_NON_BANKING;
	}
	public BigDecimal getR19_OUTSTANDING_INVESTMENT() {
		return R19_OUTSTANDING_INVESTMENT;
	}
	public void setR19_OUTSTANDING_INVESTMENT(BigDecimal r19_OUTSTANDING_INVESTMENT) {
		R19_OUTSTANDING_INVESTMENT = r19_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR19_PROVISION_INVESTMENT() {
		return R19_PROVISION_INVESTMENT;
	}
	public void setR19_PROVISION_INVESTMENT(BigDecimal r19_PROVISION_INVESTMENT) {
		R19_PROVISION_INVESTMENT = r19_PROVISION_INVESTMENT;
	}
	public BigDecimal getR19_OUTSTANDING_TRADE() {
		return R19_OUTSTANDING_TRADE;
	}
	public void setR19_OUTSTANDING_TRADE(BigDecimal r19_OUTSTANDING_TRADE) {
		R19_OUTSTANDING_TRADE = r19_OUTSTANDING_TRADE;
	}
	public BigDecimal getR19_PROVISION_TRADE() {
		return R19_PROVISION_TRADE;
	}
	public void setR19_PROVISION_TRADE(BigDecimal r19_PROVISION_TRADE) {
		R19_PROVISION_TRADE = r19_PROVISION_TRADE;
	}
	public BigDecimal getR19_OUTSTANDING_LOAN() {
		return R19_OUTSTANDING_LOAN;
	}
	public void setR19_OUTSTANDING_LOAN(BigDecimal r19_OUTSTANDING_LOAN) {
		R19_OUTSTANDING_LOAN = r19_OUTSTANDING_LOAN;
	}
	public BigDecimal getR19_PROVISION_LOAN() {
		return R19_PROVISION_LOAN;
	}
	public void setR19_PROVISION_LOAN(BigDecimal r19_PROVISION_LOAN) {
		R19_PROVISION_LOAN = r19_PROVISION_LOAN;
	}
	public BigDecimal getR19_OUTSTANDING_OTHER_ASSETS() {
		return R19_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR19_OUTSTANDING_OTHER_ASSETS(BigDecimal r19_OUTSTANDING_OTHER_ASSETS) {
		R19_OUTSTANDING_OTHER_ASSETS = r19_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR19_PROVISION_OTHER_ASSETS() {
		return R19_PROVISION_OTHER_ASSETS;
	}
	public void setR19_PROVISION_OTHER_ASSETS(BigDecimal r19_PROVISION_OTHER_ASSETS) {
		R19_PROVISION_OTHER_ASSETS = r19_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR19_OUTSTANDING_TOTAL() {
		return R19_OUTSTANDING_TOTAL;
	}
	public void setR19_OUTSTANDING_TOTAL(BigDecimal r19_OUTSTANDING_TOTAL) {
		R19_OUTSTANDING_TOTAL = r19_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR19_PROVISION_TOTAL() {
		return R19_PROVISION_TOTAL;
	}
	public void setR19_PROVISION_TOTAL(BigDecimal r19_PROVISION_TOTAL) {
		R19_PROVISION_TOTAL = r19_PROVISION_TOTAL;
	}
	public BigDecimal getR19_INTERESTS() {
		return R19_INTERESTS;
	}
	public void setR19_INTERESTS(BigDecimal r19_INTERESTS) {
		R19_INTERESTS = r19_INTERESTS;
	}
	public BigDecimal getR19_EXPOSURE() {
		return R19_EXPOSURE;
	}
	public void setR19_EXPOSURE(BigDecimal r19_EXPOSURE) {
		R19_EXPOSURE = r19_EXPOSURE;
	}
	public BigDecimal getR19_UNFUNDED() {
		return R19_UNFUNDED;
	}
	public void setR19_UNFUNDED(BigDecimal r19_UNFUNDED) {
		R19_UNFUNDED = r19_UNFUNDED;
	}
	public BigDecimal getR19_OUTSTANDING_UNFUNDED() {
		return R19_OUTSTANDING_UNFUNDED;
	}
	public void setR19_OUTSTANDING_UNFUNDED(BigDecimal r19_OUTSTANDING_UNFUNDED) {
		R19_OUTSTANDING_UNFUNDED = r19_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR19_PROVISION_UNFUNDED() {
		return R19_PROVISION_UNFUNDED;
	}
	public void setR19_PROVISION_UNFUNDED(BigDecimal r19_PROVISION_UNFUNDED) {
		R19_PROVISION_UNFUNDED = r19_PROVISION_UNFUNDED;
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
	public BigDecimal getR20_OUTSTANDING_CASH() {
		return R20_OUTSTANDING_CASH;
	}
	public void setR20_OUTSTANDING_CASH(BigDecimal r20_OUTSTANDING_CASH) {
		R20_OUTSTANDING_CASH = r20_OUTSTANDING_CASH;
	}
	public BigDecimal getR20_PROVISION_CASH() {
		return R20_PROVISION_CASH;
	}
	public void setR20_PROVISION_CASH(BigDecimal r20_PROVISION_CASH) {
		R20_PROVISION_CASH = r20_PROVISION_CASH;
	}
	public BigDecimal getR20_OUTSTANDING_BALANCE() {
		return R20_OUTSTANDING_BALANCE;
	}
	public void setR20_OUTSTANDING_BALANCE(BigDecimal r20_OUTSTANDING_BALANCE) {
		R20_OUTSTANDING_BALANCE = r20_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR20_PROVISION_BALANCE() {
		return R20_PROVISION_BALANCE;
	}
	public void setR20_PROVISION_BALANCE(BigDecimal r20_PROVISION_BALANCE) {
		R20_PROVISION_BALANCE = r20_PROVISION_BALANCE;
	}
	public BigDecimal getR20_OUTSTANDING_NON_BANKING() {
		return R20_OUTSTANDING_NON_BANKING;
	}
	public void setR20_OUTSTANDING_NON_BANKING(BigDecimal r20_OUTSTANDING_NON_BANKING) {
		R20_OUTSTANDING_NON_BANKING = r20_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR20_PROVISION_NON_BANKING() {
		return R20_PROVISION_NON_BANKING;
	}
	public void setR20_PROVISION_NON_BANKING(BigDecimal r20_PROVISION_NON_BANKING) {
		R20_PROVISION_NON_BANKING = r20_PROVISION_NON_BANKING;
	}
	public BigDecimal getR20_OUTSTANDING_INVESTMENT() {
		return R20_OUTSTANDING_INVESTMENT;
	}
	public void setR20_OUTSTANDING_INVESTMENT(BigDecimal r20_OUTSTANDING_INVESTMENT) {
		R20_OUTSTANDING_INVESTMENT = r20_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR20_PROVISION_INVESTMENT() {
		return R20_PROVISION_INVESTMENT;
	}
	public void setR20_PROVISION_INVESTMENT(BigDecimal r20_PROVISION_INVESTMENT) {
		R20_PROVISION_INVESTMENT = r20_PROVISION_INVESTMENT;
	}
	public BigDecimal getR20_OUTSTANDING_TRADE() {
		return R20_OUTSTANDING_TRADE;
	}
	public void setR20_OUTSTANDING_TRADE(BigDecimal r20_OUTSTANDING_TRADE) {
		R20_OUTSTANDING_TRADE = r20_OUTSTANDING_TRADE;
	}
	public BigDecimal getR20_PROVISION_TRADE() {
		return R20_PROVISION_TRADE;
	}
	public void setR20_PROVISION_TRADE(BigDecimal r20_PROVISION_TRADE) {
		R20_PROVISION_TRADE = r20_PROVISION_TRADE;
	}
	public BigDecimal getR20_OUTSTANDING_LOAN() {
		return R20_OUTSTANDING_LOAN;
	}
	public void setR20_OUTSTANDING_LOAN(BigDecimal r20_OUTSTANDING_LOAN) {
		R20_OUTSTANDING_LOAN = r20_OUTSTANDING_LOAN;
	}
	public BigDecimal getR20_PROVISION_LOAN() {
		return R20_PROVISION_LOAN;
	}
	public void setR20_PROVISION_LOAN(BigDecimal r20_PROVISION_LOAN) {
		R20_PROVISION_LOAN = r20_PROVISION_LOAN;
	}
	public BigDecimal getR20_OUTSTANDING_OTHER_ASSETS() {
		return R20_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR20_OUTSTANDING_OTHER_ASSETS(BigDecimal r20_OUTSTANDING_OTHER_ASSETS) {
		R20_OUTSTANDING_OTHER_ASSETS = r20_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR20_PROVISION_OTHER_ASSETS() {
		return R20_PROVISION_OTHER_ASSETS;
	}
	public void setR20_PROVISION_OTHER_ASSETS(BigDecimal r20_PROVISION_OTHER_ASSETS) {
		R20_PROVISION_OTHER_ASSETS = r20_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR20_OUTSTANDING_TOTAL() {
		return R20_OUTSTANDING_TOTAL;
	}
	public void setR20_OUTSTANDING_TOTAL(BigDecimal r20_OUTSTANDING_TOTAL) {
		R20_OUTSTANDING_TOTAL = r20_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR20_PROVISION_TOTAL() {
		return R20_PROVISION_TOTAL;
	}
	public void setR20_PROVISION_TOTAL(BigDecimal r20_PROVISION_TOTAL) {
		R20_PROVISION_TOTAL = r20_PROVISION_TOTAL;
	}
	public BigDecimal getR20_INTERESTS() {
		return R20_INTERESTS;
	}
	public void setR20_INTERESTS(BigDecimal r20_INTERESTS) {
		R20_INTERESTS = r20_INTERESTS;
	}
	public BigDecimal getR20_EXPOSURE() {
		return R20_EXPOSURE;
	}
	public void setR20_EXPOSURE(BigDecimal r20_EXPOSURE) {
		R20_EXPOSURE = r20_EXPOSURE;
	}
	public BigDecimal getR20_UNFUNDED() {
		return R20_UNFUNDED;
	}
	public void setR20_UNFUNDED(BigDecimal r20_UNFUNDED) {
		R20_UNFUNDED = r20_UNFUNDED;
	}
	public BigDecimal getR20_OUTSTANDING_UNFUNDED() {
		return R20_OUTSTANDING_UNFUNDED;
	}
	public void setR20_OUTSTANDING_UNFUNDED(BigDecimal r20_OUTSTANDING_UNFUNDED) {
		R20_OUTSTANDING_UNFUNDED = r20_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR20_PROVISION_UNFUNDED() {
		return R20_PROVISION_UNFUNDED;
	}
	public void setR20_PROVISION_UNFUNDED(BigDecimal r20_PROVISION_UNFUNDED) {
		R20_PROVISION_UNFUNDED = r20_PROVISION_UNFUNDED;
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
	public BigDecimal getR21_OUTSTANDING_CASH() {
		return R21_OUTSTANDING_CASH;
	}
	public void setR21_OUTSTANDING_CASH(BigDecimal r21_OUTSTANDING_CASH) {
		R21_OUTSTANDING_CASH = r21_OUTSTANDING_CASH;
	}
	public BigDecimal getR21_PROVISION_CASH() {
		return R21_PROVISION_CASH;
	}
	public void setR21_PROVISION_CASH(BigDecimal r21_PROVISION_CASH) {
		R21_PROVISION_CASH = r21_PROVISION_CASH;
	}
	public BigDecimal getR21_OUTSTANDING_BALANCE() {
		return R21_OUTSTANDING_BALANCE;
	}
	public void setR21_OUTSTANDING_BALANCE(BigDecimal r21_OUTSTANDING_BALANCE) {
		R21_OUTSTANDING_BALANCE = r21_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR21_PROVISION_BALANCE() {
		return R21_PROVISION_BALANCE;
	}
	public void setR21_PROVISION_BALANCE(BigDecimal r21_PROVISION_BALANCE) {
		R21_PROVISION_BALANCE = r21_PROVISION_BALANCE;
	}
	public BigDecimal getR21_OUTSTANDING_NON_BANKING() {
		return R21_OUTSTANDING_NON_BANKING;
	}
	public void setR21_OUTSTANDING_NON_BANKING(BigDecimal r21_OUTSTANDING_NON_BANKING) {
		R21_OUTSTANDING_NON_BANKING = r21_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR21_PROVISION_NON_BANKING() {
		return R21_PROVISION_NON_BANKING;
	}
	public void setR21_PROVISION_NON_BANKING(BigDecimal r21_PROVISION_NON_BANKING) {
		R21_PROVISION_NON_BANKING = r21_PROVISION_NON_BANKING;
	}
	public BigDecimal getR21_OUTSTANDING_INVESTMENT() {
		return R21_OUTSTANDING_INVESTMENT;
	}
	public void setR21_OUTSTANDING_INVESTMENT(BigDecimal r21_OUTSTANDING_INVESTMENT) {
		R21_OUTSTANDING_INVESTMENT = r21_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR21_PROVISION_INVESTMENT() {
		return R21_PROVISION_INVESTMENT;
	}
	public void setR21_PROVISION_INVESTMENT(BigDecimal r21_PROVISION_INVESTMENT) {
		R21_PROVISION_INVESTMENT = r21_PROVISION_INVESTMENT;
	}
	public BigDecimal getR21_OUTSTANDING_TRADE() {
		return R21_OUTSTANDING_TRADE;
	}
	public void setR21_OUTSTANDING_TRADE(BigDecimal r21_OUTSTANDING_TRADE) {
		R21_OUTSTANDING_TRADE = r21_OUTSTANDING_TRADE;
	}
	public BigDecimal getR21_PROVISION_TRADE() {
		return R21_PROVISION_TRADE;
	}
	public void setR21_PROVISION_TRADE(BigDecimal r21_PROVISION_TRADE) {
		R21_PROVISION_TRADE = r21_PROVISION_TRADE;
	}
	public BigDecimal getR21_OUTSTANDING_LOAN() {
		return R21_OUTSTANDING_LOAN;
	}
	public void setR21_OUTSTANDING_LOAN(BigDecimal r21_OUTSTANDING_LOAN) {
		R21_OUTSTANDING_LOAN = r21_OUTSTANDING_LOAN;
	}
	public BigDecimal getR21_PROVISION_LOAN() {
		return R21_PROVISION_LOAN;
	}
	public void setR21_PROVISION_LOAN(BigDecimal r21_PROVISION_LOAN) {
		R21_PROVISION_LOAN = r21_PROVISION_LOAN;
	}
	public BigDecimal getR21_OUTSTANDING_OTHER_ASSETS() {
		return R21_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR21_OUTSTANDING_OTHER_ASSETS(BigDecimal r21_OUTSTANDING_OTHER_ASSETS) {
		R21_OUTSTANDING_OTHER_ASSETS = r21_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR21_PROVISION_OTHER_ASSETS() {
		return R21_PROVISION_OTHER_ASSETS;
	}
	public void setR21_PROVISION_OTHER_ASSETS(BigDecimal r21_PROVISION_OTHER_ASSETS) {
		R21_PROVISION_OTHER_ASSETS = r21_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR21_OUTSTANDING_TOTAL() {
		return R21_OUTSTANDING_TOTAL;
	}
	public void setR21_OUTSTANDING_TOTAL(BigDecimal r21_OUTSTANDING_TOTAL) {
		R21_OUTSTANDING_TOTAL = r21_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR21_PROVISION_TOTAL() {
		return R21_PROVISION_TOTAL;
	}
	public void setR21_PROVISION_TOTAL(BigDecimal r21_PROVISION_TOTAL) {
		R21_PROVISION_TOTAL = r21_PROVISION_TOTAL;
	}
	public BigDecimal getR21_INTERESTS() {
		return R21_INTERESTS;
	}
	public void setR21_INTERESTS(BigDecimal r21_INTERESTS) {
		R21_INTERESTS = r21_INTERESTS;
	}
	public BigDecimal getR21_EXPOSURE() {
		return R21_EXPOSURE;
	}
	public void setR21_EXPOSURE(BigDecimal r21_EXPOSURE) {
		R21_EXPOSURE = r21_EXPOSURE;
	}
	public BigDecimal getR21_UNFUNDED() {
		return R21_UNFUNDED;
	}
	public void setR21_UNFUNDED(BigDecimal r21_UNFUNDED) {
		R21_UNFUNDED = r21_UNFUNDED;
	}
	public BigDecimal getR21_OUTSTANDING_UNFUNDED() {
		return R21_OUTSTANDING_UNFUNDED;
	}
	public void setR21_OUTSTANDING_UNFUNDED(BigDecimal r21_OUTSTANDING_UNFUNDED) {
		R21_OUTSTANDING_UNFUNDED = r21_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR21_PROVISION_UNFUNDED() {
		return R21_PROVISION_UNFUNDED;
	}
	public void setR21_PROVISION_UNFUNDED(BigDecimal r21_PROVISION_UNFUNDED) {
		R21_PROVISION_UNFUNDED = r21_PROVISION_UNFUNDED;
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
	public BigDecimal getR22_OUTSTANDING_CASH() {
		return R22_OUTSTANDING_CASH;
	}
	public void setR22_OUTSTANDING_CASH(BigDecimal r22_OUTSTANDING_CASH) {
		R22_OUTSTANDING_CASH = r22_OUTSTANDING_CASH;
	}
	public BigDecimal getR22_PROVISION_CASH() {
		return R22_PROVISION_CASH;
	}
	public void setR22_PROVISION_CASH(BigDecimal r22_PROVISION_CASH) {
		R22_PROVISION_CASH = r22_PROVISION_CASH;
	}
	public BigDecimal getR22_OUTSTANDING_BALANCE() {
		return R22_OUTSTANDING_BALANCE;
	}
	public void setR22_OUTSTANDING_BALANCE(BigDecimal r22_OUTSTANDING_BALANCE) {
		R22_OUTSTANDING_BALANCE = r22_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR22_PROVISION_BALANCE() {
		return R22_PROVISION_BALANCE;
	}
	public void setR22_PROVISION_BALANCE(BigDecimal r22_PROVISION_BALANCE) {
		R22_PROVISION_BALANCE = r22_PROVISION_BALANCE;
	}
	public BigDecimal getR22_OUTSTANDING_NON_BANKING() {
		return R22_OUTSTANDING_NON_BANKING;
	}
	public void setR22_OUTSTANDING_NON_BANKING(BigDecimal r22_OUTSTANDING_NON_BANKING) {
		R22_OUTSTANDING_NON_BANKING = r22_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR22_PROVISION_NON_BANKING() {
		return R22_PROVISION_NON_BANKING;
	}
	public void setR22_PROVISION_NON_BANKING(BigDecimal r22_PROVISION_NON_BANKING) {
		R22_PROVISION_NON_BANKING = r22_PROVISION_NON_BANKING;
	}
	public BigDecimal getR22_OUTSTANDING_INVESTMENT() {
		return R22_OUTSTANDING_INVESTMENT;
	}
	public void setR22_OUTSTANDING_INVESTMENT(BigDecimal r22_OUTSTANDING_INVESTMENT) {
		R22_OUTSTANDING_INVESTMENT = r22_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR22_PROVISION_INVESTMENT() {
		return R22_PROVISION_INVESTMENT;
	}
	public void setR22_PROVISION_INVESTMENT(BigDecimal r22_PROVISION_INVESTMENT) {
		R22_PROVISION_INVESTMENT = r22_PROVISION_INVESTMENT;
	}
	public BigDecimal getR22_OUTSTANDING_TRADE() {
		return R22_OUTSTANDING_TRADE;
	}
	public void setR22_OUTSTANDING_TRADE(BigDecimal r22_OUTSTANDING_TRADE) {
		R22_OUTSTANDING_TRADE = r22_OUTSTANDING_TRADE;
	}
	public BigDecimal getR22_PROVISION_TRADE() {
		return R22_PROVISION_TRADE;
	}
	public void setR22_PROVISION_TRADE(BigDecimal r22_PROVISION_TRADE) {
		R22_PROVISION_TRADE = r22_PROVISION_TRADE;
	}
	public BigDecimal getR22_OUTSTANDING_LOAN() {
		return R22_OUTSTANDING_LOAN;
	}
	public void setR22_OUTSTANDING_LOAN(BigDecimal r22_OUTSTANDING_LOAN) {
		R22_OUTSTANDING_LOAN = r22_OUTSTANDING_LOAN;
	}
	public BigDecimal getR22_PROVISION_LOAN() {
		return R22_PROVISION_LOAN;
	}
	public void setR22_PROVISION_LOAN(BigDecimal r22_PROVISION_LOAN) {
		R22_PROVISION_LOAN = r22_PROVISION_LOAN;
	}
	public BigDecimal getR22_OUTSTANDING_OTHER_ASSETS() {
		return R22_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR22_OUTSTANDING_OTHER_ASSETS(BigDecimal r22_OUTSTANDING_OTHER_ASSETS) {
		R22_OUTSTANDING_OTHER_ASSETS = r22_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR22_PROVISION_OTHER_ASSETS() {
		return R22_PROVISION_OTHER_ASSETS;
	}
	public void setR22_PROVISION_OTHER_ASSETS(BigDecimal r22_PROVISION_OTHER_ASSETS) {
		R22_PROVISION_OTHER_ASSETS = r22_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR22_OUTSTANDING_TOTAL() {
		return R22_OUTSTANDING_TOTAL;
	}
	public void setR22_OUTSTANDING_TOTAL(BigDecimal r22_OUTSTANDING_TOTAL) {
		R22_OUTSTANDING_TOTAL = r22_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR22_PROVISION_TOTAL() {
		return R22_PROVISION_TOTAL;
	}
	public void setR22_PROVISION_TOTAL(BigDecimal r22_PROVISION_TOTAL) {
		R22_PROVISION_TOTAL = r22_PROVISION_TOTAL;
	}
	public BigDecimal getR22_INTERESTS() {
		return R22_INTERESTS;
	}
	public void setR22_INTERESTS(BigDecimal r22_INTERESTS) {
		R22_INTERESTS = r22_INTERESTS;
	}
	public BigDecimal getR22_EXPOSURE() {
		return R22_EXPOSURE;
	}
	public void setR22_EXPOSURE(BigDecimal r22_EXPOSURE) {
		R22_EXPOSURE = r22_EXPOSURE;
	}
	public BigDecimal getR22_UNFUNDED() {
		return R22_UNFUNDED;
	}
	public void setR22_UNFUNDED(BigDecimal r22_UNFUNDED) {
		R22_UNFUNDED = r22_UNFUNDED;
	}
	public BigDecimal getR22_OUTSTANDING_UNFUNDED() {
		return R22_OUTSTANDING_UNFUNDED;
	}
	public void setR22_OUTSTANDING_UNFUNDED(BigDecimal r22_OUTSTANDING_UNFUNDED) {
		R22_OUTSTANDING_UNFUNDED = r22_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR22_PROVISION_UNFUNDED() {
		return R22_PROVISION_UNFUNDED;
	}
	public void setR22_PROVISION_UNFUNDED(BigDecimal r22_PROVISION_UNFUNDED) {
		R22_PROVISION_UNFUNDED = r22_PROVISION_UNFUNDED;
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
	public BigDecimal getR23_OUTSTANDING_CASH() {
		return R23_OUTSTANDING_CASH;
	}
	public void setR23_OUTSTANDING_CASH(BigDecimal r23_OUTSTANDING_CASH) {
		R23_OUTSTANDING_CASH = r23_OUTSTANDING_CASH;
	}
	public BigDecimal getR23_PROVISION_CASH() {
		return R23_PROVISION_CASH;
	}
	public void setR23_PROVISION_CASH(BigDecimal r23_PROVISION_CASH) {
		R23_PROVISION_CASH = r23_PROVISION_CASH;
	}
	public BigDecimal getR23_OUTSTANDING_BALANCE() {
		return R23_OUTSTANDING_BALANCE;
	}
	public void setR23_OUTSTANDING_BALANCE(BigDecimal r23_OUTSTANDING_BALANCE) {
		R23_OUTSTANDING_BALANCE = r23_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR23_PROVISION_BALANCE() {
		return R23_PROVISION_BALANCE;
	}
	public void setR23_PROVISION_BALANCE(BigDecimal r23_PROVISION_BALANCE) {
		R23_PROVISION_BALANCE = r23_PROVISION_BALANCE;
	}
	public BigDecimal getR23_OUTSTANDING_NON_BANKING() {
		return R23_OUTSTANDING_NON_BANKING;
	}
	public void setR23_OUTSTANDING_NON_BANKING(BigDecimal r23_OUTSTANDING_NON_BANKING) {
		R23_OUTSTANDING_NON_BANKING = r23_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR23_PROVISION_NON_BANKING() {
		return R23_PROVISION_NON_BANKING;
	}
	public void setR23_PROVISION_NON_BANKING(BigDecimal r23_PROVISION_NON_BANKING) {
		R23_PROVISION_NON_BANKING = r23_PROVISION_NON_BANKING;
	}
	public BigDecimal getR23_OUTSTANDING_INVESTMENT() {
		return R23_OUTSTANDING_INVESTMENT;
	}
	public void setR23_OUTSTANDING_INVESTMENT(BigDecimal r23_OUTSTANDING_INVESTMENT) {
		R23_OUTSTANDING_INVESTMENT = r23_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR23_PROVISION_INVESTMENT() {
		return R23_PROVISION_INVESTMENT;
	}
	public void setR23_PROVISION_INVESTMENT(BigDecimal r23_PROVISION_INVESTMENT) {
		R23_PROVISION_INVESTMENT = r23_PROVISION_INVESTMENT;
	}
	public BigDecimal getR23_OUTSTANDING_TRADE() {
		return R23_OUTSTANDING_TRADE;
	}
	public void setR23_OUTSTANDING_TRADE(BigDecimal r23_OUTSTANDING_TRADE) {
		R23_OUTSTANDING_TRADE = r23_OUTSTANDING_TRADE;
	}
	public BigDecimal getR23_PROVISION_TRADE() {
		return R23_PROVISION_TRADE;
	}
	public void setR23_PROVISION_TRADE(BigDecimal r23_PROVISION_TRADE) {
		R23_PROVISION_TRADE = r23_PROVISION_TRADE;
	}
	public BigDecimal getR23_OUTSTANDING_LOAN() {
		return R23_OUTSTANDING_LOAN;
	}
	public void setR23_OUTSTANDING_LOAN(BigDecimal r23_OUTSTANDING_LOAN) {
		R23_OUTSTANDING_LOAN = r23_OUTSTANDING_LOAN;
	}
	public BigDecimal getR23_PROVISION_LOAN() {
		return R23_PROVISION_LOAN;
	}
	public void setR23_PROVISION_LOAN(BigDecimal r23_PROVISION_LOAN) {
		R23_PROVISION_LOAN = r23_PROVISION_LOAN;
	}
	public BigDecimal getR23_OUTSTANDING_OTHER_ASSETS() {
		return R23_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR23_OUTSTANDING_OTHER_ASSETS(BigDecimal r23_OUTSTANDING_OTHER_ASSETS) {
		R23_OUTSTANDING_OTHER_ASSETS = r23_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR23_PROVISION_OTHER_ASSETS() {
		return R23_PROVISION_OTHER_ASSETS;
	}
	public void setR23_PROVISION_OTHER_ASSETS(BigDecimal r23_PROVISION_OTHER_ASSETS) {
		R23_PROVISION_OTHER_ASSETS = r23_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR23_OUTSTANDING_TOTAL() {
		return R23_OUTSTANDING_TOTAL;
	}
	public void setR23_OUTSTANDING_TOTAL(BigDecimal r23_OUTSTANDING_TOTAL) {
		R23_OUTSTANDING_TOTAL = r23_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR23_PROVISION_TOTAL() {
		return R23_PROVISION_TOTAL;
	}
	public void setR23_PROVISION_TOTAL(BigDecimal r23_PROVISION_TOTAL) {
		R23_PROVISION_TOTAL = r23_PROVISION_TOTAL;
	}
	public BigDecimal getR23_INTERESTS() {
		return R23_INTERESTS;
	}
	public void setR23_INTERESTS(BigDecimal r23_INTERESTS) {
		R23_INTERESTS = r23_INTERESTS;
	}
	public BigDecimal getR23_EXPOSURE() {
		return R23_EXPOSURE;
	}
	public void setR23_EXPOSURE(BigDecimal r23_EXPOSURE) {
		R23_EXPOSURE = r23_EXPOSURE;
	}
	public BigDecimal getR23_UNFUNDED() {
		return R23_UNFUNDED;
	}
	public void setR23_UNFUNDED(BigDecimal r23_UNFUNDED) {
		R23_UNFUNDED = r23_UNFUNDED;
	}
	public BigDecimal getR23_OUTSTANDING_UNFUNDED() {
		return R23_OUTSTANDING_UNFUNDED;
	}
	public void setR23_OUTSTANDING_UNFUNDED(BigDecimal r23_OUTSTANDING_UNFUNDED) {
		R23_OUTSTANDING_UNFUNDED = r23_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR23_PROVISION_UNFUNDED() {
		return R23_PROVISION_UNFUNDED;
	}
	public void setR23_PROVISION_UNFUNDED(BigDecimal r23_PROVISION_UNFUNDED) {
		R23_PROVISION_UNFUNDED = r23_PROVISION_UNFUNDED;
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
	public BigDecimal getR24_OUTSTANDING_CASH() {
		return R24_OUTSTANDING_CASH;
	}
	public void setR24_OUTSTANDING_CASH(BigDecimal r24_OUTSTANDING_CASH) {
		R24_OUTSTANDING_CASH = r24_OUTSTANDING_CASH;
	}
	public BigDecimal getR24_PROVISION_CASH() {
		return R24_PROVISION_CASH;
	}
	public void setR24_PROVISION_CASH(BigDecimal r24_PROVISION_CASH) {
		R24_PROVISION_CASH = r24_PROVISION_CASH;
	}
	public BigDecimal getR24_OUTSTANDING_BALANCE() {
		return R24_OUTSTANDING_BALANCE;
	}
	public void setR24_OUTSTANDING_BALANCE(BigDecimal r24_OUTSTANDING_BALANCE) {
		R24_OUTSTANDING_BALANCE = r24_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR24_PROVISION_BALANCE() {
		return R24_PROVISION_BALANCE;
	}
	public void setR24_PROVISION_BALANCE(BigDecimal r24_PROVISION_BALANCE) {
		R24_PROVISION_BALANCE = r24_PROVISION_BALANCE;
	}
	public BigDecimal getR24_OUTSTANDING_NON_BANKING() {
		return R24_OUTSTANDING_NON_BANKING;
	}
	public void setR24_OUTSTANDING_NON_BANKING(BigDecimal r24_OUTSTANDING_NON_BANKING) {
		R24_OUTSTANDING_NON_BANKING = r24_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR24_PROVISION_NON_BANKING() {
		return R24_PROVISION_NON_BANKING;
	}
	public void setR24_PROVISION_NON_BANKING(BigDecimal r24_PROVISION_NON_BANKING) {
		R24_PROVISION_NON_BANKING = r24_PROVISION_NON_BANKING;
	}
	public BigDecimal getR24_OUTSTANDING_INVESTMENT() {
		return R24_OUTSTANDING_INVESTMENT;
	}
	public void setR24_OUTSTANDING_INVESTMENT(BigDecimal r24_OUTSTANDING_INVESTMENT) {
		R24_OUTSTANDING_INVESTMENT = r24_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR24_PROVISION_INVESTMENT() {
		return R24_PROVISION_INVESTMENT;
	}
	public void setR24_PROVISION_INVESTMENT(BigDecimal r24_PROVISION_INVESTMENT) {
		R24_PROVISION_INVESTMENT = r24_PROVISION_INVESTMENT;
	}
	public BigDecimal getR24_OUTSTANDING_TRADE() {
		return R24_OUTSTANDING_TRADE;
	}
	public void setR24_OUTSTANDING_TRADE(BigDecimal r24_OUTSTANDING_TRADE) {
		R24_OUTSTANDING_TRADE = r24_OUTSTANDING_TRADE;
	}
	public BigDecimal getR24_PROVISION_TRADE() {
		return R24_PROVISION_TRADE;
	}
	public void setR24_PROVISION_TRADE(BigDecimal r24_PROVISION_TRADE) {
		R24_PROVISION_TRADE = r24_PROVISION_TRADE;
	}
	public BigDecimal getR24_OUTSTANDING_LOAN() {
		return R24_OUTSTANDING_LOAN;
	}
	public void setR24_OUTSTANDING_LOAN(BigDecimal r24_OUTSTANDING_LOAN) {
		R24_OUTSTANDING_LOAN = r24_OUTSTANDING_LOAN;
	}
	public BigDecimal getR24_PROVISION_LOAN() {
		return R24_PROVISION_LOAN;
	}
	public void setR24_PROVISION_LOAN(BigDecimal r24_PROVISION_LOAN) {
		R24_PROVISION_LOAN = r24_PROVISION_LOAN;
	}
	public BigDecimal getR24_OUTSTANDING_OTHER_ASSETS() {
		return R24_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR24_OUTSTANDING_OTHER_ASSETS(BigDecimal r24_OUTSTANDING_OTHER_ASSETS) {
		R24_OUTSTANDING_OTHER_ASSETS = r24_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR24_PROVISION_OTHER_ASSETS() {
		return R24_PROVISION_OTHER_ASSETS;
	}
	public void setR24_PROVISION_OTHER_ASSETS(BigDecimal r24_PROVISION_OTHER_ASSETS) {
		R24_PROVISION_OTHER_ASSETS = r24_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR24_OUTSTANDING_TOTAL() {
		return R24_OUTSTANDING_TOTAL;
	}
	public void setR24_OUTSTANDING_TOTAL(BigDecimal r24_OUTSTANDING_TOTAL) {
		R24_OUTSTANDING_TOTAL = r24_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR24_PROVISION_TOTAL() {
		return R24_PROVISION_TOTAL;
	}
	public void setR24_PROVISION_TOTAL(BigDecimal r24_PROVISION_TOTAL) {
		R24_PROVISION_TOTAL = r24_PROVISION_TOTAL;
	}
	public BigDecimal getR24_INTERESTS() {
		return R24_INTERESTS;
	}
	public void setR24_INTERESTS(BigDecimal r24_INTERESTS) {
		R24_INTERESTS = r24_INTERESTS;
	}
	public BigDecimal getR24_EXPOSURE() {
		return R24_EXPOSURE;
	}
	public void setR24_EXPOSURE(BigDecimal r24_EXPOSURE) {
		R24_EXPOSURE = r24_EXPOSURE;
	}
	public BigDecimal getR24_UNFUNDED() {
		return R24_UNFUNDED;
	}
	public void setR24_UNFUNDED(BigDecimal r24_UNFUNDED) {
		R24_UNFUNDED = r24_UNFUNDED;
	}
	public BigDecimal getR24_OUTSTANDING_UNFUNDED() {
		return R24_OUTSTANDING_UNFUNDED;
	}
	public void setR24_OUTSTANDING_UNFUNDED(BigDecimal r24_OUTSTANDING_UNFUNDED) {
		R24_OUTSTANDING_UNFUNDED = r24_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR24_PROVISION_UNFUNDED() {
		return R24_PROVISION_UNFUNDED;
	}
	public void setR24_PROVISION_UNFUNDED(BigDecimal r24_PROVISION_UNFUNDED) {
		R24_PROVISION_UNFUNDED = r24_PROVISION_UNFUNDED;
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
	public BigDecimal getR25_OUTSTANDING_CASH() {
		return R25_OUTSTANDING_CASH;
	}
	public void setR25_OUTSTANDING_CASH(BigDecimal r25_OUTSTANDING_CASH) {
		R25_OUTSTANDING_CASH = r25_OUTSTANDING_CASH;
	}
	public BigDecimal getR25_PROVISION_CASH() {
		return R25_PROVISION_CASH;
	}
	public void setR25_PROVISION_CASH(BigDecimal r25_PROVISION_CASH) {
		R25_PROVISION_CASH = r25_PROVISION_CASH;
	}
	public BigDecimal getR25_OUTSTANDING_BALANCE() {
		return R25_OUTSTANDING_BALANCE;
	}
	public void setR25_OUTSTANDING_BALANCE(BigDecimal r25_OUTSTANDING_BALANCE) {
		R25_OUTSTANDING_BALANCE = r25_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR25_PROVISION_BALANCE() {
		return R25_PROVISION_BALANCE;
	}
	public void setR25_PROVISION_BALANCE(BigDecimal r25_PROVISION_BALANCE) {
		R25_PROVISION_BALANCE = r25_PROVISION_BALANCE;
	}
	public BigDecimal getR25_OUTSTANDING_NON_BANKING() {
		return R25_OUTSTANDING_NON_BANKING;
	}
	public void setR25_OUTSTANDING_NON_BANKING(BigDecimal r25_OUTSTANDING_NON_BANKING) {
		R25_OUTSTANDING_NON_BANKING = r25_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR25_PROVISION_NON_BANKING() {
		return R25_PROVISION_NON_BANKING;
	}
	public void setR25_PROVISION_NON_BANKING(BigDecimal r25_PROVISION_NON_BANKING) {
		R25_PROVISION_NON_BANKING = r25_PROVISION_NON_BANKING;
	}
	public BigDecimal getR25_OUTSTANDING_INVESTMENT() {
		return R25_OUTSTANDING_INVESTMENT;
	}
	public void setR25_OUTSTANDING_INVESTMENT(BigDecimal r25_OUTSTANDING_INVESTMENT) {
		R25_OUTSTANDING_INVESTMENT = r25_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR25_PROVISION_INVESTMENT() {
		return R25_PROVISION_INVESTMENT;
	}
	public void setR25_PROVISION_INVESTMENT(BigDecimal r25_PROVISION_INVESTMENT) {
		R25_PROVISION_INVESTMENT = r25_PROVISION_INVESTMENT;
	}
	public BigDecimal getR25_OUTSTANDING_TRADE() {
		return R25_OUTSTANDING_TRADE;
	}
	public void setR25_OUTSTANDING_TRADE(BigDecimal r25_OUTSTANDING_TRADE) {
		R25_OUTSTANDING_TRADE = r25_OUTSTANDING_TRADE;
	}
	public BigDecimal getR25_PROVISION_TRADE() {
		return R25_PROVISION_TRADE;
	}
	public void setR25_PROVISION_TRADE(BigDecimal r25_PROVISION_TRADE) {
		R25_PROVISION_TRADE = r25_PROVISION_TRADE;
	}
	public BigDecimal getR25_OUTSTANDING_LOAN() {
		return R25_OUTSTANDING_LOAN;
	}
	public void setR25_OUTSTANDING_LOAN(BigDecimal r25_OUTSTANDING_LOAN) {
		R25_OUTSTANDING_LOAN = r25_OUTSTANDING_LOAN;
	}
	public BigDecimal getR25_PROVISION_LOAN() {
		return R25_PROVISION_LOAN;
	}
	public void setR25_PROVISION_LOAN(BigDecimal r25_PROVISION_LOAN) {
		R25_PROVISION_LOAN = r25_PROVISION_LOAN;
	}
	public BigDecimal getR25_OUTSTANDING_OTHER_ASSETS() {
		return R25_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR25_OUTSTANDING_OTHER_ASSETS(BigDecimal r25_OUTSTANDING_OTHER_ASSETS) {
		R25_OUTSTANDING_OTHER_ASSETS = r25_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR25_PROVISION_OTHER_ASSETS() {
		return R25_PROVISION_OTHER_ASSETS;
	}
	public void setR25_PROVISION_OTHER_ASSETS(BigDecimal r25_PROVISION_OTHER_ASSETS) {
		R25_PROVISION_OTHER_ASSETS = r25_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR25_OUTSTANDING_TOTAL() {
		return R25_OUTSTANDING_TOTAL;
	}
	public void setR25_OUTSTANDING_TOTAL(BigDecimal r25_OUTSTANDING_TOTAL) {
		R25_OUTSTANDING_TOTAL = r25_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR25_PROVISION_TOTAL() {
		return R25_PROVISION_TOTAL;
	}
	public void setR25_PROVISION_TOTAL(BigDecimal r25_PROVISION_TOTAL) {
		R25_PROVISION_TOTAL = r25_PROVISION_TOTAL;
	}
	public BigDecimal getR25_INTERESTS() {
		return R25_INTERESTS;
	}
	public void setR25_INTERESTS(BigDecimal r25_INTERESTS) {
		R25_INTERESTS = r25_INTERESTS;
	}
	public BigDecimal getR25_EXPOSURE() {
		return R25_EXPOSURE;
	}
	public void setR25_EXPOSURE(BigDecimal r25_EXPOSURE) {
		R25_EXPOSURE = r25_EXPOSURE;
	}
	public BigDecimal getR25_UNFUNDED() {
		return R25_UNFUNDED;
	}
	public void setR25_UNFUNDED(BigDecimal r25_UNFUNDED) {
		R25_UNFUNDED = r25_UNFUNDED;
	}
	public BigDecimal getR25_OUTSTANDING_UNFUNDED() {
		return R25_OUTSTANDING_UNFUNDED;
	}
	public void setR25_OUTSTANDING_UNFUNDED(BigDecimal r25_OUTSTANDING_UNFUNDED) {
		R25_OUTSTANDING_UNFUNDED = r25_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR25_PROVISION_UNFUNDED() {
		return R25_PROVISION_UNFUNDED;
	}
	public void setR25_PROVISION_UNFUNDED(BigDecimal r25_PROVISION_UNFUNDED) {
		R25_PROVISION_UNFUNDED = r25_PROVISION_UNFUNDED;
	}
	public String getR26_S_NO() {
		return R26_S_NO;
	}
	public void setR26_S_NO(String r26_S_NO) {
		R26_S_NO = r26_S_NO;
	}
	public String getR26_STAGES() {
		return R26_STAGES;
	}
	public void setR26_STAGES(String r26_STAGES) {
		R26_STAGES = r26_STAGES;
	}
	public BigDecimal getR26_OUTSTANDING_CASH() {
		return R26_OUTSTANDING_CASH;
	}
	public void setR26_OUTSTANDING_CASH(BigDecimal r26_OUTSTANDING_CASH) {
		R26_OUTSTANDING_CASH = r26_OUTSTANDING_CASH;
	}
	public BigDecimal getR26_PROVISION_CASH() {
		return R26_PROVISION_CASH;
	}
	public void setR26_PROVISION_CASH(BigDecimal r26_PROVISION_CASH) {
		R26_PROVISION_CASH = r26_PROVISION_CASH;
	}
	public BigDecimal getR26_OUTSTANDING_BALANCE() {
		return R26_OUTSTANDING_BALANCE;
	}
	public void setR26_OUTSTANDING_BALANCE(BigDecimal r26_OUTSTANDING_BALANCE) {
		R26_OUTSTANDING_BALANCE = r26_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR26_PROVISION_BALANCE() {
		return R26_PROVISION_BALANCE;
	}
	public void setR26_PROVISION_BALANCE(BigDecimal r26_PROVISION_BALANCE) {
		R26_PROVISION_BALANCE = r26_PROVISION_BALANCE;
	}
	public BigDecimal getR26_OUTSTANDING_NON_BANKING() {
		return R26_OUTSTANDING_NON_BANKING;
	}
	public void setR26_OUTSTANDING_NON_BANKING(BigDecimal r26_OUTSTANDING_NON_BANKING) {
		R26_OUTSTANDING_NON_BANKING = r26_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR26_PROVISION_NON_BANKING() {
		return R26_PROVISION_NON_BANKING;
	}
	public void setR26_PROVISION_NON_BANKING(BigDecimal r26_PROVISION_NON_BANKING) {
		R26_PROVISION_NON_BANKING = r26_PROVISION_NON_BANKING;
	}
	public BigDecimal getR26_OUTSTANDING_INVESTMENT() {
		return R26_OUTSTANDING_INVESTMENT;
	}
	public void setR26_OUTSTANDING_INVESTMENT(BigDecimal r26_OUTSTANDING_INVESTMENT) {
		R26_OUTSTANDING_INVESTMENT = r26_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR26_PROVISION_INVESTMENT() {
		return R26_PROVISION_INVESTMENT;
	}
	public void setR26_PROVISION_INVESTMENT(BigDecimal r26_PROVISION_INVESTMENT) {
		R26_PROVISION_INVESTMENT = r26_PROVISION_INVESTMENT;
	}
	public BigDecimal getR26_OUTSTANDING_TRADE() {
		return R26_OUTSTANDING_TRADE;
	}
	public void setR26_OUTSTANDING_TRADE(BigDecimal r26_OUTSTANDING_TRADE) {
		R26_OUTSTANDING_TRADE = r26_OUTSTANDING_TRADE;
	}
	public BigDecimal getR26_PROVISION_TRADE() {
		return R26_PROVISION_TRADE;
	}
	public void setR26_PROVISION_TRADE(BigDecimal r26_PROVISION_TRADE) {
		R26_PROVISION_TRADE = r26_PROVISION_TRADE;
	}
	public BigDecimal getR26_OUTSTANDING_LOAN() {
		return R26_OUTSTANDING_LOAN;
	}
	public void setR26_OUTSTANDING_LOAN(BigDecimal r26_OUTSTANDING_LOAN) {
		R26_OUTSTANDING_LOAN = r26_OUTSTANDING_LOAN;
	}
	public BigDecimal getR26_PROVISION_LOAN() {
		return R26_PROVISION_LOAN;
	}
	public void setR26_PROVISION_LOAN(BigDecimal r26_PROVISION_LOAN) {
		R26_PROVISION_LOAN = r26_PROVISION_LOAN;
	}
	public BigDecimal getR26_OUTSTANDING_OTHER_ASSETS() {
		return R26_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR26_OUTSTANDING_OTHER_ASSETS(BigDecimal r26_OUTSTANDING_OTHER_ASSETS) {
		R26_OUTSTANDING_OTHER_ASSETS = r26_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR26_PROVISION_OTHER_ASSETS() {
		return R26_PROVISION_OTHER_ASSETS;
	}
	public void setR26_PROVISION_OTHER_ASSETS(BigDecimal r26_PROVISION_OTHER_ASSETS) {
		R26_PROVISION_OTHER_ASSETS = r26_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR26_OUTSTANDING_TOTAL() {
		return R26_OUTSTANDING_TOTAL;
	}
	public void setR26_OUTSTANDING_TOTAL(BigDecimal r26_OUTSTANDING_TOTAL) {
		R26_OUTSTANDING_TOTAL = r26_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR26_PROVISION_TOTAL() {
		return R26_PROVISION_TOTAL;
	}
	public void setR26_PROVISION_TOTAL(BigDecimal r26_PROVISION_TOTAL) {
		R26_PROVISION_TOTAL = r26_PROVISION_TOTAL;
	}
	public BigDecimal getR26_INTERESTS() {
		return R26_INTERESTS;
	}
	public void setR26_INTERESTS(BigDecimal r26_INTERESTS) {
		R26_INTERESTS = r26_INTERESTS;
	}
	public BigDecimal getR26_EXPOSURE() {
		return R26_EXPOSURE;
	}
	public void setR26_EXPOSURE(BigDecimal r26_EXPOSURE) {
		R26_EXPOSURE = r26_EXPOSURE;
	}
	public BigDecimal getR26_UNFUNDED() {
		return R26_UNFUNDED;
	}
	public void setR26_UNFUNDED(BigDecimal r26_UNFUNDED) {
		R26_UNFUNDED = r26_UNFUNDED;
	}
	public BigDecimal getR26_OUTSTANDING_UNFUNDED() {
		return R26_OUTSTANDING_UNFUNDED;
	}
	public void setR26_OUTSTANDING_UNFUNDED(BigDecimal r26_OUTSTANDING_UNFUNDED) {
		R26_OUTSTANDING_UNFUNDED = r26_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR26_PROVISION_UNFUNDED() {
		return R26_PROVISION_UNFUNDED;
	}
	public void setR26_PROVISION_UNFUNDED(BigDecimal r26_PROVISION_UNFUNDED) {
		R26_PROVISION_UNFUNDED = r26_PROVISION_UNFUNDED;
	}
	public String getR27_S_NO() {
		return R27_S_NO;
	}
	public void setR27_S_NO(String r27_S_NO) {
		R27_S_NO = r27_S_NO;
	}
	public String getR27_STAGES() {
		return R27_STAGES;
	}
	public void setR27_STAGES(String r27_STAGES) {
		R27_STAGES = r27_STAGES;
	}
	public BigDecimal getR27_OUTSTANDING_CASH() {
		return R27_OUTSTANDING_CASH;
	}
	public void setR27_OUTSTANDING_CASH(BigDecimal r27_OUTSTANDING_CASH) {
		R27_OUTSTANDING_CASH = r27_OUTSTANDING_CASH;
	}
	public BigDecimal getR27_PROVISION_CASH() {
		return R27_PROVISION_CASH;
	}
	public void setR27_PROVISION_CASH(BigDecimal r27_PROVISION_CASH) {
		R27_PROVISION_CASH = r27_PROVISION_CASH;
	}
	public BigDecimal getR27_OUTSTANDING_BALANCE() {
		return R27_OUTSTANDING_BALANCE;
	}
	public void setR27_OUTSTANDING_BALANCE(BigDecimal r27_OUTSTANDING_BALANCE) {
		R27_OUTSTANDING_BALANCE = r27_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR27_PROVISION_BALANCE() {
		return R27_PROVISION_BALANCE;
	}
	public void setR27_PROVISION_BALANCE(BigDecimal r27_PROVISION_BALANCE) {
		R27_PROVISION_BALANCE = r27_PROVISION_BALANCE;
	}
	public BigDecimal getR27_OUTSTANDING_NON_BANKING() {
		return R27_OUTSTANDING_NON_BANKING;
	}
	public void setR27_OUTSTANDING_NON_BANKING(BigDecimal r27_OUTSTANDING_NON_BANKING) {
		R27_OUTSTANDING_NON_BANKING = r27_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR27_PROVISION_NON_BANKING() {
		return R27_PROVISION_NON_BANKING;
	}
	public void setR27_PROVISION_NON_BANKING(BigDecimal r27_PROVISION_NON_BANKING) {
		R27_PROVISION_NON_BANKING = r27_PROVISION_NON_BANKING;
	}
	public BigDecimal getR27_OUTSTANDING_INVESTMENT() {
		return R27_OUTSTANDING_INVESTMENT;
	}
	public void setR27_OUTSTANDING_INVESTMENT(BigDecimal r27_OUTSTANDING_INVESTMENT) {
		R27_OUTSTANDING_INVESTMENT = r27_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR27_PROVISION_INVESTMENT() {
		return R27_PROVISION_INVESTMENT;
	}
	public void setR27_PROVISION_INVESTMENT(BigDecimal r27_PROVISION_INVESTMENT) {
		R27_PROVISION_INVESTMENT = r27_PROVISION_INVESTMENT;
	}
	public BigDecimal getR27_OUTSTANDING_TRADE() {
		return R27_OUTSTANDING_TRADE;
	}
	public void setR27_OUTSTANDING_TRADE(BigDecimal r27_OUTSTANDING_TRADE) {
		R27_OUTSTANDING_TRADE = r27_OUTSTANDING_TRADE;
	}
	public BigDecimal getR27_PROVISION_TRADE() {
		return R27_PROVISION_TRADE;
	}
	public void setR27_PROVISION_TRADE(BigDecimal r27_PROVISION_TRADE) {
		R27_PROVISION_TRADE = r27_PROVISION_TRADE;
	}
	public BigDecimal getR27_OUTSTANDING_LOAN() {
		return R27_OUTSTANDING_LOAN;
	}
	public void setR27_OUTSTANDING_LOAN(BigDecimal r27_OUTSTANDING_LOAN) {
		R27_OUTSTANDING_LOAN = r27_OUTSTANDING_LOAN;
	}
	public BigDecimal getR27_PROVISION_LOAN() {
		return R27_PROVISION_LOAN;
	}
	public void setR27_PROVISION_LOAN(BigDecimal r27_PROVISION_LOAN) {
		R27_PROVISION_LOAN = r27_PROVISION_LOAN;
	}
	public BigDecimal getR27_OUTSTANDING_OTHER_ASSETS() {
		return R27_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR27_OUTSTANDING_OTHER_ASSETS(BigDecimal r27_OUTSTANDING_OTHER_ASSETS) {
		R27_OUTSTANDING_OTHER_ASSETS = r27_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR27_PROVISION_OTHER_ASSETS() {
		return R27_PROVISION_OTHER_ASSETS;
	}
	public void setR27_PROVISION_OTHER_ASSETS(BigDecimal r27_PROVISION_OTHER_ASSETS) {
		R27_PROVISION_OTHER_ASSETS = r27_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR27_OUTSTANDING_TOTAL() {
		return R27_OUTSTANDING_TOTAL;
	}
	public void setR27_OUTSTANDING_TOTAL(BigDecimal r27_OUTSTANDING_TOTAL) {
		R27_OUTSTANDING_TOTAL = r27_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR27_PROVISION_TOTAL() {
		return R27_PROVISION_TOTAL;
	}
	public void setR27_PROVISION_TOTAL(BigDecimal r27_PROVISION_TOTAL) {
		R27_PROVISION_TOTAL = r27_PROVISION_TOTAL;
	}
	public BigDecimal getR27_INTERESTS() {
		return R27_INTERESTS;
	}
	public void setR27_INTERESTS(BigDecimal r27_INTERESTS) {
		R27_INTERESTS = r27_INTERESTS;
	}
	public BigDecimal getR27_EXPOSURE() {
		return R27_EXPOSURE;
	}
	public void setR27_EXPOSURE(BigDecimal r27_EXPOSURE) {
		R27_EXPOSURE = r27_EXPOSURE;
	}
	public BigDecimal getR27_UNFUNDED() {
		return R27_UNFUNDED;
	}
	public void setR27_UNFUNDED(BigDecimal r27_UNFUNDED) {
		R27_UNFUNDED = r27_UNFUNDED;
	}
	public BigDecimal getR27_OUTSTANDING_UNFUNDED() {
		return R27_OUTSTANDING_UNFUNDED;
	}
	public void setR27_OUTSTANDING_UNFUNDED(BigDecimal r27_OUTSTANDING_UNFUNDED) {
		R27_OUTSTANDING_UNFUNDED = r27_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR27_PROVISION_UNFUNDED() {
		return R27_PROVISION_UNFUNDED;
	}
	public void setR27_PROVISION_UNFUNDED(BigDecimal r27_PROVISION_UNFUNDED) {
		R27_PROVISION_UNFUNDED = r27_PROVISION_UNFUNDED;
	}
	public String getR28_S_NO() {
		return R28_S_NO;
	}
	public void setR28_S_NO(String r28_S_NO) {
		R28_S_NO = r28_S_NO;
	}
	public String getR28_STAGES() {
		return R28_STAGES;
	}
	public void setR28_STAGES(String r28_STAGES) {
		R28_STAGES = r28_STAGES;
	}
	public BigDecimal getR28_OUTSTANDING_CASH() {
		return R28_OUTSTANDING_CASH;
	}
	public void setR28_OUTSTANDING_CASH(BigDecimal r28_OUTSTANDING_CASH) {
		R28_OUTSTANDING_CASH = r28_OUTSTANDING_CASH;
	}
	public BigDecimal getR28_PROVISION_CASH() {
		return R28_PROVISION_CASH;
	}
	public void setR28_PROVISION_CASH(BigDecimal r28_PROVISION_CASH) {
		R28_PROVISION_CASH = r28_PROVISION_CASH;
	}
	public BigDecimal getR28_OUTSTANDING_BALANCE() {
		return R28_OUTSTANDING_BALANCE;
	}
	public void setR28_OUTSTANDING_BALANCE(BigDecimal r28_OUTSTANDING_BALANCE) {
		R28_OUTSTANDING_BALANCE = r28_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR28_PROVISION_BALANCE() {
		return R28_PROVISION_BALANCE;
	}
	public void setR28_PROVISION_BALANCE(BigDecimal r28_PROVISION_BALANCE) {
		R28_PROVISION_BALANCE = r28_PROVISION_BALANCE;
	}
	public BigDecimal getR28_OUTSTANDING_NON_BANKING() {
		return R28_OUTSTANDING_NON_BANKING;
	}
	public void setR28_OUTSTANDING_NON_BANKING(BigDecimal r28_OUTSTANDING_NON_BANKING) {
		R28_OUTSTANDING_NON_BANKING = r28_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR28_PROVISION_NON_BANKING() {
		return R28_PROVISION_NON_BANKING;
	}
	public void setR28_PROVISION_NON_BANKING(BigDecimal r28_PROVISION_NON_BANKING) {
		R28_PROVISION_NON_BANKING = r28_PROVISION_NON_BANKING;
	}
	public BigDecimal getR28_OUTSTANDING_INVESTMENT() {
		return R28_OUTSTANDING_INVESTMENT;
	}
	public void setR28_OUTSTANDING_INVESTMENT(BigDecimal r28_OUTSTANDING_INVESTMENT) {
		R28_OUTSTANDING_INVESTMENT = r28_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR28_PROVISION_INVESTMENT() {
		return R28_PROVISION_INVESTMENT;
	}
	public void setR28_PROVISION_INVESTMENT(BigDecimal r28_PROVISION_INVESTMENT) {
		R28_PROVISION_INVESTMENT = r28_PROVISION_INVESTMENT;
	}
	public BigDecimal getR28_OUTSTANDING_TRADE() {
		return R28_OUTSTANDING_TRADE;
	}
	public void setR28_OUTSTANDING_TRADE(BigDecimal r28_OUTSTANDING_TRADE) {
		R28_OUTSTANDING_TRADE = r28_OUTSTANDING_TRADE;
	}
	public BigDecimal getR28_PROVISION_TRADE() {
		return R28_PROVISION_TRADE;
	}
	public void setR28_PROVISION_TRADE(BigDecimal r28_PROVISION_TRADE) {
		R28_PROVISION_TRADE = r28_PROVISION_TRADE;
	}
	public BigDecimal getR28_OUTSTANDING_LOAN() {
		return R28_OUTSTANDING_LOAN;
	}
	public void setR28_OUTSTANDING_LOAN(BigDecimal r28_OUTSTANDING_LOAN) {
		R28_OUTSTANDING_LOAN = r28_OUTSTANDING_LOAN;
	}
	public BigDecimal getR28_PROVISION_LOAN() {
		return R28_PROVISION_LOAN;
	}
	public void setR28_PROVISION_LOAN(BigDecimal r28_PROVISION_LOAN) {
		R28_PROVISION_LOAN = r28_PROVISION_LOAN;
	}
	public BigDecimal getR28_OUTSTANDING_OTHER_ASSETS() {
		return R28_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR28_OUTSTANDING_OTHER_ASSETS(BigDecimal r28_OUTSTANDING_OTHER_ASSETS) {
		R28_OUTSTANDING_OTHER_ASSETS = r28_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR28_PROVISION_OTHER_ASSETS() {
		return R28_PROVISION_OTHER_ASSETS;
	}
	public void setR28_PROVISION_OTHER_ASSETS(BigDecimal r28_PROVISION_OTHER_ASSETS) {
		R28_PROVISION_OTHER_ASSETS = r28_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR28_OUTSTANDING_TOTAL() {
		return R28_OUTSTANDING_TOTAL;
	}
	public void setR28_OUTSTANDING_TOTAL(BigDecimal r28_OUTSTANDING_TOTAL) {
		R28_OUTSTANDING_TOTAL = r28_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR28_PROVISION_TOTAL() {
		return R28_PROVISION_TOTAL;
	}
	public void setR28_PROVISION_TOTAL(BigDecimal r28_PROVISION_TOTAL) {
		R28_PROVISION_TOTAL = r28_PROVISION_TOTAL;
	}
	public BigDecimal getR28_INTERESTS() {
		return R28_INTERESTS;
	}
	public void setR28_INTERESTS(BigDecimal r28_INTERESTS) {
		R28_INTERESTS = r28_INTERESTS;
	}
	public BigDecimal getR28_EXPOSURE() {
		return R28_EXPOSURE;
	}
	public void setR28_EXPOSURE(BigDecimal r28_EXPOSURE) {
		R28_EXPOSURE = r28_EXPOSURE;
	}
	public BigDecimal getR28_UNFUNDED() {
		return R28_UNFUNDED;
	}
	public void setR28_UNFUNDED(BigDecimal r28_UNFUNDED) {
		R28_UNFUNDED = r28_UNFUNDED;
	}
	public BigDecimal getR28_OUTSTANDING_UNFUNDED() {
		return R28_OUTSTANDING_UNFUNDED;
	}
	public void setR28_OUTSTANDING_UNFUNDED(BigDecimal r28_OUTSTANDING_UNFUNDED) {
		R28_OUTSTANDING_UNFUNDED = r28_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR28_PROVISION_UNFUNDED() {
		return R28_PROVISION_UNFUNDED;
	}
	public void setR28_PROVISION_UNFUNDED(BigDecimal r28_PROVISION_UNFUNDED) {
		R28_PROVISION_UNFUNDED = r28_PROVISION_UNFUNDED;
	}
	public String getR29_S_NO() {
		return R29_S_NO;
	}
	public void setR29_S_NO(String r29_S_NO) {
		R29_S_NO = r29_S_NO;
	}
	public String getR29_STAGES() {
		return R29_STAGES;
	}
	public void setR29_STAGES(String r29_STAGES) {
		R29_STAGES = r29_STAGES;
	}
	public BigDecimal getR29_OUTSTANDING_CASH() {
		return R29_OUTSTANDING_CASH;
	}
	public void setR29_OUTSTANDING_CASH(BigDecimal r29_OUTSTANDING_CASH) {
		R29_OUTSTANDING_CASH = r29_OUTSTANDING_CASH;
	}
	public BigDecimal getR29_PROVISION_CASH() {
		return R29_PROVISION_CASH;
	}
	public void setR29_PROVISION_CASH(BigDecimal r29_PROVISION_CASH) {
		R29_PROVISION_CASH = r29_PROVISION_CASH;
	}
	public BigDecimal getR29_OUTSTANDING_BALANCE() {
		return R29_OUTSTANDING_BALANCE;
	}
	public void setR29_OUTSTANDING_BALANCE(BigDecimal r29_OUTSTANDING_BALANCE) {
		R29_OUTSTANDING_BALANCE = r29_OUTSTANDING_BALANCE;
	}
	public BigDecimal getR29_PROVISION_BALANCE() {
		return R29_PROVISION_BALANCE;
	}
	public void setR29_PROVISION_BALANCE(BigDecimal r29_PROVISION_BALANCE) {
		R29_PROVISION_BALANCE = r29_PROVISION_BALANCE;
	}
	public BigDecimal getR29_OUTSTANDING_NON_BANKING() {
		return R29_OUTSTANDING_NON_BANKING;
	}
	public void setR29_OUTSTANDING_NON_BANKING(BigDecimal r29_OUTSTANDING_NON_BANKING) {
		R29_OUTSTANDING_NON_BANKING = r29_OUTSTANDING_NON_BANKING;
	}
	public BigDecimal getR29_PROVISION_NON_BANKING() {
		return R29_PROVISION_NON_BANKING;
	}
	public void setR29_PROVISION_NON_BANKING(BigDecimal r29_PROVISION_NON_BANKING) {
		R29_PROVISION_NON_BANKING = r29_PROVISION_NON_BANKING;
	}
	public BigDecimal getR29_OUTSTANDING_INVESTMENT() {
		return R29_OUTSTANDING_INVESTMENT;
	}
	public void setR29_OUTSTANDING_INVESTMENT(BigDecimal r29_OUTSTANDING_INVESTMENT) {
		R29_OUTSTANDING_INVESTMENT = r29_OUTSTANDING_INVESTMENT;
	}
	public BigDecimal getR29_PROVISION_INVESTMENT() {
		return R29_PROVISION_INVESTMENT;
	}
	public void setR29_PROVISION_INVESTMENT(BigDecimal r29_PROVISION_INVESTMENT) {
		R29_PROVISION_INVESTMENT = r29_PROVISION_INVESTMENT;
	}
	public BigDecimal getR29_OUTSTANDING_TRADE() {
		return R29_OUTSTANDING_TRADE;
	}
	public void setR29_OUTSTANDING_TRADE(BigDecimal r29_OUTSTANDING_TRADE) {
		R29_OUTSTANDING_TRADE = r29_OUTSTANDING_TRADE;
	}
	public BigDecimal getR29_PROVISION_TRADE() {
		return R29_PROVISION_TRADE;
	}
	public void setR29_PROVISION_TRADE(BigDecimal r29_PROVISION_TRADE) {
		R29_PROVISION_TRADE = r29_PROVISION_TRADE;
	}
	public BigDecimal getR29_OUTSTANDING_LOAN() {
		return R29_OUTSTANDING_LOAN;
	}
	public void setR29_OUTSTANDING_LOAN(BigDecimal r29_OUTSTANDING_LOAN) {
		R29_OUTSTANDING_LOAN = r29_OUTSTANDING_LOAN;
	}
	public BigDecimal getR29_PROVISION_LOAN() {
		return R29_PROVISION_LOAN;
	}
	public void setR29_PROVISION_LOAN(BigDecimal r29_PROVISION_LOAN) {
		R29_PROVISION_LOAN = r29_PROVISION_LOAN;
	}
	public BigDecimal getR29_OUTSTANDING_OTHER_ASSETS() {
		return R29_OUTSTANDING_OTHER_ASSETS;
	}
	public void setR29_OUTSTANDING_OTHER_ASSETS(BigDecimal r29_OUTSTANDING_OTHER_ASSETS) {
		R29_OUTSTANDING_OTHER_ASSETS = r29_OUTSTANDING_OTHER_ASSETS;
	}
	public BigDecimal getR29_PROVISION_OTHER_ASSETS() {
		return R29_PROVISION_OTHER_ASSETS;
	}
	public void setR29_PROVISION_OTHER_ASSETS(BigDecimal r29_PROVISION_OTHER_ASSETS) {
		R29_PROVISION_OTHER_ASSETS = r29_PROVISION_OTHER_ASSETS;
	}
	public BigDecimal getR29_OUTSTANDING_TOTAL() {
		return R29_OUTSTANDING_TOTAL;
	}
	public void setR29_OUTSTANDING_TOTAL(BigDecimal r29_OUTSTANDING_TOTAL) {
		R29_OUTSTANDING_TOTAL = r29_OUTSTANDING_TOTAL;
	}
	public BigDecimal getR29_PROVISION_TOTAL() {
		return R29_PROVISION_TOTAL;
	}
	public void setR29_PROVISION_TOTAL(BigDecimal r29_PROVISION_TOTAL) {
		R29_PROVISION_TOTAL = r29_PROVISION_TOTAL;
	}
	public BigDecimal getR29_INTERESTS() {
		return R29_INTERESTS;
	}
	public void setR29_INTERESTS(BigDecimal r29_INTERESTS) {
		R29_INTERESTS = r29_INTERESTS;
	}
	public BigDecimal getR29_EXPOSURE() {
		return R29_EXPOSURE;
	}
	public void setR29_EXPOSURE(BigDecimal r29_EXPOSURE) {
		R29_EXPOSURE = r29_EXPOSURE;
	}
	public BigDecimal getR29_UNFUNDED() {
		return R29_UNFUNDED;
	}
	public void setR29_UNFUNDED(BigDecimal r29_UNFUNDED) {
		R29_UNFUNDED = r29_UNFUNDED;
	}
	public BigDecimal getR29_OUTSTANDING_UNFUNDED() {
		return R29_OUTSTANDING_UNFUNDED;
	}
	public void setR29_OUTSTANDING_UNFUNDED(BigDecimal r29_OUTSTANDING_UNFUNDED) {
		R29_OUTSTANDING_UNFUNDED = r29_OUTSTANDING_UNFUNDED;
	}
	public BigDecimal getR29_PROVISION_UNFUNDED() {
		return R29_PROVISION_UNFUNDED;
	}
	public void setR29_PROVISION_UNFUNDED(BigDecimal r29_PROVISION_UNFUNDED) {
		R29_PROVISION_UNFUNDED = r29_PROVISION_UNFUNDED;
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
	public BRF_106_A_REPORT_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}