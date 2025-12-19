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
@Table(name="BRF96_SUMMARYTABLE")
public class BRF_96_REPORT_ENTITY {
	private BigDecimal	R1_S_No;
	private String	R1_Product ;
	private BigDecimal	R1_Total;
	private BigDecimal	R2_S_No;
	private String	R2_Product ;
	private BigDecimal	R2_Total;
	private BigDecimal	R3_S_No;
	private String	R3_Product ;
	private BigDecimal	R3_Total;
	private BigDecimal	R4_S_No;
	private String	R4_Product ;
	private BigDecimal	R4_Total;
	private BigDecimal	R5_S_No;
	private String	R5_Product ;
	private BigDecimal	R5_Total;
	private BigDecimal	R6_S_No;
	private String	R6_Product ;
	private BigDecimal	R6_Total;
	private BigDecimal	R7_S_No;
	private String	R7_Product ;
	private BigDecimal	R7_Total;
	private BigDecimal	R8_S_No;
	private String	R8_Product ;
	private BigDecimal	R8_Total;
	private BigDecimal	R9_S_No;
	private String	R9_Product ;
	private BigDecimal	R9_Total;
	private BigDecimal	R10_S_No;
	private String	R10_Product ;
	private BigDecimal	R10_Total;
	private BigDecimal	R11_S_No;
	private String	R11_Product ;
	private BigDecimal	R11_Total;
	private BigDecimal	R12_S_No;
	private String	R12_Product ;
	private BigDecimal	R12_Total;
	private BigDecimal	R13_S_No;
	private String	R13_Product ;
	private BigDecimal	R13_Total;
	private BigDecimal	R14_S_No;
	private String	R14_Product ;
	private BigDecimal	R14_Total;
	private BigDecimal	R15_S_No;
	private String	R15_Product ;
	private BigDecimal	R15_Total;
	private BigDecimal	R16_S_No;
	private String	R16_Product ;
	private BigDecimal	R16_Total;
	private BigDecimal	R17_S_No;
	private String	R17_Product ;
	private BigDecimal	R17_Total;
	private BigDecimal	R18_S_No;
	private String	R18_Product ;
	private BigDecimal	R18_Total;
	private BigDecimal	R19_S_No;
	private String	R19_Product ;
	private BigDecimal	R19_Total;
	private BigDecimal	R20_S_No;
	private String	R20_Product ;
	private BigDecimal	R20_Total;
	private BigDecimal	R21_S_No;
	private String	R21_Product ;
	private BigDecimal	R21_Total;
	private BigDecimal	R22_S_No;
	private String	R22_Product ;
	private BigDecimal	R22_Total;
	private BigDecimal	R23_S_No;
	private String	R23_Product ;
	private BigDecimal	R23_Total;
	private BigDecimal	R24_S_No;
	private String	R24_Product ;
	private BigDecimal	R24_Exposure_Before_CCF;
	private BigDecimal	R24_Credit_Conversion_Factor;
	private BigDecimal	R24_Exposure_After_CCF;
	private BigDecimal	R25_S_No;
	private String	R25_Product ;
	private BigDecimal	R25_Exposure_Before_CCF;
	private BigDecimal	R25_Credit_Conversion_Factor;
	private BigDecimal	R25_Exposure_After_CCF;
	private BigDecimal	R26_S_No;
	private String	R26_Product ;
	private BigDecimal	R26_Exposure_Before_CCF;
	private BigDecimal	R26_Credit_Conversion_Factor;
	private BigDecimal	R26_Exposure_After_CCF;
	private BigDecimal	R27_S_No;
	private String	R27_Product ;
	private BigDecimal	R27_Exposure_Before_CCF;
	private BigDecimal	R27_Credit_Conversion_Factor;
	private BigDecimal	R27_Exposure_After_CCF;
	private BigDecimal	R28_S_No;
	private String	R28_Product ;
	private BigDecimal	R28_Exposure_Before_CCF;
	private BigDecimal	R28_Credit_Conversion_Factor;
	private BigDecimal	R28_Exposure_After_CCF;
	private BigDecimal	R29_S_No;
	private String	R29_Product ;
	private BigDecimal	R29_Exposure_Before_CCF;
	private BigDecimal	R29_Credit_Conversion_Factor;
	private BigDecimal	R29_Exposure_After_CCF;
	private BigDecimal	R30_S_No;
	private String	R30_Product ;
	private BigDecimal	R30_Exposure_Before_CCF;
	private BigDecimal	R30_Credit_Conversion_Factor;
	private BigDecimal	R30_Exposure_After_CCF;
	private BigDecimal	R31_S_No;
	private String	R31_Product ;
	private BigDecimal	R31_Exposure_Before_CCF;
	private BigDecimal	R31_Credit_Conversion_Factor;
	private BigDecimal	R31_Exposure_After_CCF;
	private BigDecimal	R32_S_No;
	private String	R32_Product ;
	private BigDecimal	R32_Exposure_Before_CCF;
	private BigDecimal	R32_Credit_Conversion_Factor;
	private BigDecimal	R32_Exposure_After_CCF;
	private BigDecimal	R33_S_No;
	private String	R33_Product ;
	private BigDecimal	R33_Exposure_Before_CCF;
	private BigDecimal	R33_Credit_Conversion_Factor;
	private BigDecimal	R33_Exposure_After_CCF;
	private BigDecimal	R34_S_No;
	private String	R34_Product ;
	private BigDecimal	R34_Exposure_Before_CCF;
	private BigDecimal	R34_Credit_Conversion_Factor;
	private BigDecimal	R34_Exposure_After_CCF;
	private BigDecimal	R35_S_No;
	private String	R35_Product ;
	private BigDecimal	R35_Exposure_Before_CCF;
	private BigDecimal	R35_Credit_Conversion_Factor;
	private BigDecimal	R35_Exposure_After_CCF;
	private BigDecimal	R36_S_No;
	private String	R36_Product ;
	private BigDecimal	R36_Exposure_Before_CCF;
	private BigDecimal	R36_Credit_Conversion_Factor;
	private BigDecimal	R36_Exposure_After_CCF;
	private BigDecimal	R37_S_No;
	private String	R37_Product ;
	private BigDecimal	R37_Exposure_Before_CCF;
	private BigDecimal	R37_Credit_Conversion_Factor;
	private BigDecimal	R37_Exposure_After_CCF;
	private BigDecimal	R38_S_No;
	private String	R38_Product ;
	private BigDecimal	R38_Exposure_Before_CCF;
	private BigDecimal	R38_Credit_Conversion_Factor;
	private BigDecimal	R38_Exposure_After_CCF;
	private BigDecimal	R39_S_No ;
	private String	R39_Product;
	private BigDecimal	R39_AED_000s;
	private BigDecimal	R40_S_No ;
	private String	R40_Product;
	private BigDecimal	R40_AED_000s;
	private BigDecimal	R41_S_No ;
	private String	R41_Product;
	private BigDecimal	R41_AED_000s;
	private BigDecimal	R42_S_No ;
	private String	R42_Product;
	private BigDecimal	R42_AED_000s;
	private BigDecimal	R43_S_No ;
	private String	R43_Product;
	private BigDecimal	R43_AED_000s;
	private BigDecimal	R44_S_No ;
	private String	R44_Product;
	private BigDecimal	R44_AED_000s;
	private BigDecimal	R45_S_No ;
	private String	R45_Product;
	private BigDecimal	R45_AED_000s;
	private BigDecimal	R46_S_No ;
	private String	R46_Product;
	private BigDecimal	R46_AED_000s;

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
	public BigDecimal getR1_S_No() {
		return R1_S_No;
	}
	public void setR1_S_No(BigDecimal r1_S_No) {
		R1_S_No = r1_S_No;
	}
	public String getR1_Product() {
		return R1_Product;
	}
	public void setR1_Product(String r1_Product) {
		R1_Product = r1_Product;
	}
	public BigDecimal getR1_Total() {
		return R1_Total;
	}
	public void setR1_Total(BigDecimal r1_Total) {
		R1_Total = r1_Total;
	}
	public BigDecimal getR2_S_No() {
		return R2_S_No;
	}
	public void setR2_S_No(BigDecimal r2_S_No) {
		R2_S_No = r2_S_No;
	}
	public String getR2_Product() {
		return R2_Product;
	}
	public void setR2_Product(String r2_Product) {
		R2_Product = r2_Product;
	}
	public BigDecimal getR2_Total() {
		return R2_Total;
	}
	public void setR2_Total(BigDecimal r2_Total) {
		R2_Total = r2_Total;
	}
	public BigDecimal getR3_S_No() {
		return R3_S_No;
	}
	public void setR3_S_No(BigDecimal r3_S_No) {
		R3_S_No = r3_S_No;
	}
	public String getR3_Product() {
		return R3_Product;
	}
	public void setR3_Product(String r3_Product) {
		R3_Product = r3_Product;
	}
	public BigDecimal getR3_Total() {
		return R3_Total;
	}
	public void setR3_Total(BigDecimal r3_Total) {
		R3_Total = r3_Total;
	}
	public BigDecimal getR4_S_No() {
		return R4_S_No;
	}
	public void setR4_S_No(BigDecimal r4_S_No) {
		R4_S_No = r4_S_No;
	}
	public String getR4_Product() {
		return R4_Product;
	}
	public void setR4_Product(String r4_Product) {
		R4_Product = r4_Product;
	}
	public BigDecimal getR4_Total() {
		return R4_Total;
	}
	public void setR4_Total(BigDecimal r4_Total) {
		R4_Total = r4_Total;
	}
	public BigDecimal getR5_S_No() {
		return R5_S_No;
	}
	public void setR5_S_No(BigDecimal r5_S_No) {
		R5_S_No = r5_S_No;
	}
	public String getR5_Product() {
		return R5_Product;
	}
	public void setR5_Product(String r5_Product) {
		R5_Product = r5_Product;
	}
	public BigDecimal getR5_Total() {
		return R5_Total;
	}
	public void setR5_Total(BigDecimal r5_Total) {
		R5_Total = r5_Total;
	}
	public BigDecimal getR6_S_No() {
		return R6_S_No;
	}
	public void setR6_S_No(BigDecimal r6_S_No) {
		R6_S_No = r6_S_No;
	}
	public String getR6_Product() {
		return R6_Product;
	}
	public void setR6_Product(String r6_Product) {
		R6_Product = r6_Product;
	}
	public BigDecimal getR6_Total() {
		return R6_Total;
	}
	public void setR6_Total(BigDecimal r6_Total) {
		R6_Total = r6_Total;
	}
	public BigDecimal getR7_S_No() {
		return R7_S_No;
	}
	public void setR7_S_No(BigDecimal r7_S_No) {
		R7_S_No = r7_S_No;
	}
	public String getR7_Product() {
		return R7_Product;
	}
	public void setR7_Product(String r7_Product) {
		R7_Product = r7_Product;
	}
	public BigDecimal getR7_Total() {
		return R7_Total;
	}
	public void setR7_Total(BigDecimal r7_Total) {
		R7_Total = r7_Total;
	}
	public BigDecimal getR8_S_No() {
		return R8_S_No;
	}
	public void setR8_S_No(BigDecimal r8_S_No) {
		R8_S_No = r8_S_No;
	}
	public String getR8_Product() {
		return R8_Product;
	}
	public void setR8_Product(String r8_Product) {
		R8_Product = r8_Product;
	}
	public BigDecimal getR8_Total() {
		return R8_Total;
	}
	public void setR8_Total(BigDecimal r8_Total) {
		R8_Total = r8_Total;
	}
	public BigDecimal getR9_S_No() {
		return R9_S_No;
	}
	public void setR9_S_No(BigDecimal r9_S_No) {
		R9_S_No = r9_S_No;
	}
	public String getR9_Product() {
		return R9_Product;
	}
	public void setR9_Product(String r9_Product) {
		R9_Product = r9_Product;
	}
	public BigDecimal getR9_Total() {
		return R9_Total;
	}
	public void setR9_Total(BigDecimal r9_Total) {
		R9_Total = r9_Total;
	}
	public BigDecimal getR10_S_No() {
		return R10_S_No;
	}
	public void setR10_S_No(BigDecimal r10_S_No) {
		R10_S_No = r10_S_No;
	}
	public String getR10_Product() {
		return R10_Product;
	}
	public void setR10_Product(String r10_Product) {
		R10_Product = r10_Product;
	}
	public BigDecimal getR10_Total() {
		return R10_Total;
	}
	public void setR10_Total(BigDecimal r10_Total) {
		R10_Total = r10_Total;
	}
	public BigDecimal getR11_S_No() {
		return R11_S_No;
	}
	public void setR11_S_No(BigDecimal r11_S_No) {
		R11_S_No = r11_S_No;
	}
	public String getR11_Product() {
		return R11_Product;
	}
	public void setR11_Product(String r11_Product) {
		R11_Product = r11_Product;
	}
	public BigDecimal getR11_Total() {
		return R11_Total;
	}
	public void setR11_Total(BigDecimal r11_Total) {
		R11_Total = r11_Total;
	}
	public BigDecimal getR12_S_No() {
		return R12_S_No;
	}
	public void setR12_S_No(BigDecimal r12_S_No) {
		R12_S_No = r12_S_No;
	}
	public String getR12_Product() {
		return R12_Product;
	}
	public void setR12_Product(String r12_Product) {
		R12_Product = r12_Product;
	}
	public BigDecimal getR12_Total() {
		return R12_Total;
	}
	public void setR12_Total(BigDecimal r12_Total) {
		R12_Total = r12_Total;
	}
	public BigDecimal getR13_S_No() {
		return R13_S_No;
	}
	public void setR13_S_No(BigDecimal r13_S_No) {
		R13_S_No = r13_S_No;
	}
	public String getR13_Product() {
		return R13_Product;
	}
	public void setR13_Product(String r13_Product) {
		R13_Product = r13_Product;
	}
	public BigDecimal getR13_Total() {
		return R13_Total;
	}
	public void setR13_Total(BigDecimal r13_Total) {
		R13_Total = r13_Total;
	}
	public BigDecimal getR14_S_No() {
		return R14_S_No;
	}
	public void setR14_S_No(BigDecimal r14_S_No) {
		R14_S_No = r14_S_No;
	}
	public String getR14_Product() {
		return R14_Product;
	}
	public void setR14_Product(String r14_Product) {
		R14_Product = r14_Product;
	}
	public BigDecimal getR14_Total() {
		return R14_Total;
	}
	public void setR14_Total(BigDecimal r14_Total) {
		R14_Total = r14_Total;
	}
	public BigDecimal getR15_S_No() {
		return R15_S_No;
	}
	public void setR15_S_No(BigDecimal r15_S_No) {
		R15_S_No = r15_S_No;
	}
	public String getR15_Product() {
		return R15_Product;
	}
	public void setR15_Product(String r15_Product) {
		R15_Product = r15_Product;
	}
	public BigDecimal getR15_Total() {
		return R15_Total;
	}
	public void setR15_Total(BigDecimal r15_Total) {
		R15_Total = r15_Total;
	}
	public BigDecimal getR16_S_No() {
		return R16_S_No;
	}
	public void setR16_S_No(BigDecimal r16_S_No) {
		R16_S_No = r16_S_No;
	}
	public String getR16_Product() {
		return R16_Product;
	}
	public void setR16_Product(String r16_Product) {
		R16_Product = r16_Product;
	}
	public BigDecimal getR16_Total() {
		return R16_Total;
	}
	public void setR16_Total(BigDecimal r16_Total) {
		R16_Total = r16_Total;
	}
	public BigDecimal getR17_S_No() {
		return R17_S_No;
	}
	public void setR17_S_No(BigDecimal r17_S_No) {
		R17_S_No = r17_S_No;
	}
	public String getR17_Product() {
		return R17_Product;
	}
	public void setR17_Product(String r17_Product) {
		R17_Product = r17_Product;
	}
	public BigDecimal getR17_Total() {
		return R17_Total;
	}
	public void setR17_Total(BigDecimal r17_Total) {
		R17_Total = r17_Total;
	}
	public BigDecimal getR18_S_No() {
		return R18_S_No;
	}
	public void setR18_S_No(BigDecimal r18_S_No) {
		R18_S_No = r18_S_No;
	}
	public String getR18_Product() {
		return R18_Product;
	}
	public void setR18_Product(String r18_Product) {
		R18_Product = r18_Product;
	}
	public BigDecimal getR18_Total() {
		return R18_Total;
	}
	public void setR18_Total(BigDecimal r18_Total) {
		R18_Total = r18_Total;
	}
	public BigDecimal getR19_S_No() {
		return R19_S_No;
	}
	public void setR19_S_No(BigDecimal r19_S_No) {
		R19_S_No = r19_S_No;
	}
	public String getR19_Product() {
		return R19_Product;
	}
	public void setR19_Product(String r19_Product) {
		R19_Product = r19_Product;
	}
	public BigDecimal getR19_Total() {
		return R19_Total;
	}
	public void setR19_Total(BigDecimal r19_Total) {
		R19_Total = r19_Total;
	}
	public BigDecimal getR20_S_No() {
		return R20_S_No;
	}
	public void setR20_S_No(BigDecimal r20_S_No) {
		R20_S_No = r20_S_No;
	}
	public String getR20_Product() {
		return R20_Product;
	}
	public void setR20_Product(String r20_Product) {
		R20_Product = r20_Product;
	}
	public BigDecimal getR20_Total() {
		return R20_Total;
	}
	public void setR20_Total(BigDecimal r20_Total) {
		R20_Total = r20_Total;
	}
	public BigDecimal getR21_S_No() {
		return R21_S_No;
	}
	public void setR21_S_No(BigDecimal r21_S_No) {
		R21_S_No = r21_S_No;
	}
	public String getR21_Product() {
		return R21_Product;
	}
	public void setR21_Product(String r21_Product) {
		R21_Product = r21_Product;
	}
	public BigDecimal getR21_Total() {
		return R21_Total;
	}
	public void setR21_Total(BigDecimal r21_Total) {
		R21_Total = r21_Total;
	}
	public BigDecimal getR22_S_No() {
		return R22_S_No;
	}
	public void setR22_S_No(BigDecimal r22_S_No) {
		R22_S_No = r22_S_No;
	}
	public String getR22_Product() {
		return R22_Product;
	}
	public void setR22_Product(String r22_Product) {
		R22_Product = r22_Product;
	}
	public BigDecimal getR22_Total() {
		return R22_Total;
	}
	public void setR22_Total(BigDecimal r22_Total) {
		R22_Total = r22_Total;
	}
	public BigDecimal getR23_S_No() {
		return R23_S_No;
	}
	public void setR23_S_No(BigDecimal r23_S_No) {
		R23_S_No = r23_S_No;
	}
	public String getR23_Product() {
		return R23_Product;
	}
	public void setR23_Product(String r23_Product) {
		R23_Product = r23_Product;
	}
	public BigDecimal getR23_Total() {
		return R23_Total;
	}
	public void setR23_Total(BigDecimal r23_Total) {
		R23_Total = r23_Total;
	}
	public BigDecimal getR24_S_No() {
		return R24_S_No;
	}
	public void setR24_S_No(BigDecimal r24_S_No) {
		R24_S_No = r24_S_No;
	}
	public String getR24_Product() {
		return R24_Product;
	}
	public void setR24_Product(String r24_Product) {
		R24_Product = r24_Product;
	}
	public BigDecimal getR24_Exposure_Before_CCF() {
		return R24_Exposure_Before_CCF;
	}
	public void setR24_Exposure_Before_CCF(BigDecimal r24_Exposure_Before_CCF) {
		R24_Exposure_Before_CCF = r24_Exposure_Before_CCF;
	}
	public BigDecimal getR24_Credit_Conversion_Factor() {
		return R24_Credit_Conversion_Factor;
	}
	public void setR24_Credit_Conversion_Factor(BigDecimal r24_Credit_Conversion_Factor) {
		R24_Credit_Conversion_Factor = r24_Credit_Conversion_Factor;
	}
	public BigDecimal getR24_Exposure_After_CCF() {
		return R24_Exposure_After_CCF;
	}
	public void setR24_Exposure_After_CCF(BigDecimal r24_Exposure_After_CCF) {
		R24_Exposure_After_CCF = r24_Exposure_After_CCF;
	}
	public BigDecimal getR25_S_No() {
		return R25_S_No;
	}
	public void setR25_S_No(BigDecimal r25_S_No) {
		R25_S_No = r25_S_No;
	}
	public String getR25_Product() {
		return R25_Product;
	}
	public void setR25_Product(String r25_Product) {
		R25_Product = r25_Product;
	}
	public BigDecimal getR25_Exposure_Before_CCF() {
		return R25_Exposure_Before_CCF;
	}
	public void setR25_Exposure_Before_CCF(BigDecimal r25_Exposure_Before_CCF) {
		R25_Exposure_Before_CCF = r25_Exposure_Before_CCF;
	}
	public BigDecimal getR25_Credit_Conversion_Factor() {
		return R25_Credit_Conversion_Factor;
	}
	public void setR25_Credit_Conversion_Factor(BigDecimal r25_Credit_Conversion_Factor) {
		R25_Credit_Conversion_Factor = r25_Credit_Conversion_Factor;
	}
	public BigDecimal getR25_Exposure_After_CCF() {
		return R25_Exposure_After_CCF;
	}
	public void setR25_Exposure_After_CCF(BigDecimal r25_Exposure_After_CCF) {
		R25_Exposure_After_CCF = r25_Exposure_After_CCF;
	}
	public BigDecimal getR26_S_No() {
		return R26_S_No;
	}
	public void setR26_S_No(BigDecimal r26_S_No) {
		R26_S_No = r26_S_No;
	}
	public String getR26_Product() {
		return R26_Product;
	}
	public void setR26_Product(String r26_Product) {
		R26_Product = r26_Product;
	}
	public BigDecimal getR26_Exposure_Before_CCF() {
		return R26_Exposure_Before_CCF;
	}
	public void setR26_Exposure_Before_CCF(BigDecimal r26_Exposure_Before_CCF) {
		R26_Exposure_Before_CCF = r26_Exposure_Before_CCF;
	}
	public BigDecimal getR26_Credit_Conversion_Factor() {
		return R26_Credit_Conversion_Factor;
	}
	public void setR26_Credit_Conversion_Factor(BigDecimal r26_Credit_Conversion_Factor) {
		R26_Credit_Conversion_Factor = r26_Credit_Conversion_Factor;
	}
	public BigDecimal getR26_Exposure_After_CCF() {
		return R26_Exposure_After_CCF;
	}
	public void setR26_Exposure_After_CCF(BigDecimal r26_Exposure_After_CCF) {
		R26_Exposure_After_CCF = r26_Exposure_After_CCF;
	}
	public BigDecimal getR27_S_No() {
		return R27_S_No;
	}
	public void setR27_S_No(BigDecimal r27_S_No) {
		R27_S_No = r27_S_No;
	}
	public String getR27_Product() {
		return R27_Product;
	}
	public void setR27_Product(String r27_Product) {
		R27_Product = r27_Product;
	}
	public BigDecimal getR27_Exposure_Before_CCF() {
		return R27_Exposure_Before_CCF;
	}
	public void setR27_Exposure_Before_CCF(BigDecimal r27_Exposure_Before_CCF) {
		R27_Exposure_Before_CCF = r27_Exposure_Before_CCF;
	}
	public BigDecimal getR27_Credit_Conversion_Factor() {
		return R27_Credit_Conversion_Factor;
	}
	public void setR27_Credit_Conversion_Factor(BigDecimal r27_Credit_Conversion_Factor) {
		R27_Credit_Conversion_Factor = r27_Credit_Conversion_Factor;
	}
	public BigDecimal getR27_Exposure_After_CCF() {
		return R27_Exposure_After_CCF;
	}
	public void setR27_Exposure_After_CCF(BigDecimal r27_Exposure_After_CCF) {
		R27_Exposure_After_CCF = r27_Exposure_After_CCF;
	}
	public BigDecimal getR28_S_No() {
		return R28_S_No;
	}
	public void setR28_S_No(BigDecimal r28_S_No) {
		R28_S_No = r28_S_No;
	}
	public String getR28_Product() {
		return R28_Product;
	}
	public void setR28_Product(String r28_Product) {
		R28_Product = r28_Product;
	}
	public BigDecimal getR28_Exposure_Before_CCF() {
		return R28_Exposure_Before_CCF;
	}
	public void setR28_Exposure_Before_CCF(BigDecimal r28_Exposure_Before_CCF) {
		R28_Exposure_Before_CCF = r28_Exposure_Before_CCF;
	}
	public BigDecimal getR28_Credit_Conversion_Factor() {
		return R28_Credit_Conversion_Factor;
	}
	public void setR28_Credit_Conversion_Factor(BigDecimal r28_Credit_Conversion_Factor) {
		R28_Credit_Conversion_Factor = r28_Credit_Conversion_Factor;
	}
	public BigDecimal getR28_Exposure_After_CCF() {
		return R28_Exposure_After_CCF;
	}
	public void setR28_Exposure_After_CCF(BigDecimal r28_Exposure_After_CCF) {
		R28_Exposure_After_CCF = r28_Exposure_After_CCF;
	}
	public BigDecimal getR29_S_No() {
		return R29_S_No;
	}
	public void setR29_S_No(BigDecimal r29_S_No) {
		R29_S_No = r29_S_No;
	}
	public String getR29_Product() {
		return R29_Product;
	}
	public void setR29_Product(String r29_Product) {
		R29_Product = r29_Product;
	}
	public BigDecimal getR29_Exposure_Before_CCF() {
		return R29_Exposure_Before_CCF;
	}
	public void setR29_Exposure_Before_CCF(BigDecimal r29_Exposure_Before_CCF) {
		R29_Exposure_Before_CCF = r29_Exposure_Before_CCF;
	}
	public BigDecimal getR29_Credit_Conversion_Factor() {
		return R29_Credit_Conversion_Factor;
	}
	public void setR29_Credit_Conversion_Factor(BigDecimal r29_Credit_Conversion_Factor) {
		R29_Credit_Conversion_Factor = r29_Credit_Conversion_Factor;
	}
	public BigDecimal getR29_Exposure_After_CCF() {
		return R29_Exposure_After_CCF;
	}
	public void setR29_Exposure_After_CCF(BigDecimal r29_Exposure_After_CCF) {
		R29_Exposure_After_CCF = r29_Exposure_After_CCF;
	}
	public BigDecimal getR30_S_No() {
		return R30_S_No;
	}
	public void setR30_S_No(BigDecimal r30_S_No) {
		R30_S_No = r30_S_No;
	}
	public String getR30_Product() {
		return R30_Product;
	}
	public void setR30_Product(String r30_Product) {
		R30_Product = r30_Product;
	}
	public BigDecimal getR30_Exposure_Before_CCF() {
		return R30_Exposure_Before_CCF;
	}
	public void setR30_Exposure_Before_CCF(BigDecimal r30_Exposure_Before_CCF) {
		R30_Exposure_Before_CCF = r30_Exposure_Before_CCF;
	}
	public BigDecimal getR30_Credit_Conversion_Factor() {
		return R30_Credit_Conversion_Factor;
	}
	public void setR30_Credit_Conversion_Factor(BigDecimal r30_Credit_Conversion_Factor) {
		R30_Credit_Conversion_Factor = r30_Credit_Conversion_Factor;
	}
	public BigDecimal getR30_Exposure_After_CCF() {
		return R30_Exposure_After_CCF;
	}
	public void setR30_Exposure_After_CCF(BigDecimal r30_Exposure_After_CCF) {
		R30_Exposure_After_CCF = r30_Exposure_After_CCF;
	}
	public BigDecimal getR31_S_No() {
		return R31_S_No;
	}
	public void setR31_S_No(BigDecimal r31_S_No) {
		R31_S_No = r31_S_No;
	}
	public String getR31_Product() {
		return R31_Product;
	}
	public void setR31_Product(String r31_Product) {
		R31_Product = r31_Product;
	}
	public BigDecimal getR31_Exposure_Before_CCF() {
		return R31_Exposure_Before_CCF;
	}
	public void setR31_Exposure_Before_CCF(BigDecimal r31_Exposure_Before_CCF) {
		R31_Exposure_Before_CCF = r31_Exposure_Before_CCF;
	}
	public BigDecimal getR31_Credit_Conversion_Factor() {
		return R31_Credit_Conversion_Factor;
	}
	public void setR31_Credit_Conversion_Factor(BigDecimal r31_Credit_Conversion_Factor) {
		R31_Credit_Conversion_Factor = r31_Credit_Conversion_Factor;
	}
	public BigDecimal getR31_Exposure_After_CCF() {
		return R31_Exposure_After_CCF;
	}
	public void setR31_Exposure_After_CCF(BigDecimal r31_Exposure_After_CCF) {
		R31_Exposure_After_CCF = r31_Exposure_After_CCF;
	}
	public BigDecimal getR32_S_No() {
		return R32_S_No;
	}
	public void setR32_S_No(BigDecimal r32_S_No) {
		R32_S_No = r32_S_No;
	}
	public String getR32_Product() {
		return R32_Product;
	}
	public void setR32_Product(String r32_Product) {
		R32_Product = r32_Product;
	}
	public BigDecimal getR32_Exposure_Before_CCF() {
		return R32_Exposure_Before_CCF;
	}
	public void setR32_Exposure_Before_CCF(BigDecimal r32_Exposure_Before_CCF) {
		R32_Exposure_Before_CCF = r32_Exposure_Before_CCF;
	}
	public BigDecimal getR32_Credit_Conversion_Factor() {
		return R32_Credit_Conversion_Factor;
	}
	public void setR32_Credit_Conversion_Factor(BigDecimal r32_Credit_Conversion_Factor) {
		R32_Credit_Conversion_Factor = r32_Credit_Conversion_Factor;
	}
	public BigDecimal getR32_Exposure_After_CCF() {
		return R32_Exposure_After_CCF;
	}
	public void setR32_Exposure_After_CCF(BigDecimal r32_Exposure_After_CCF) {
		R32_Exposure_After_CCF = r32_Exposure_After_CCF;
	}
	public BigDecimal getR33_S_No() {
		return R33_S_No;
	}
	public void setR33_S_No(BigDecimal r33_S_No) {
		R33_S_No = r33_S_No;
	}
	public String getR33_Product() {
		return R33_Product;
	}
	public void setR33_Product(String r33_Product) {
		R33_Product = r33_Product;
	}
	public BigDecimal getR33_Exposure_Before_CCF() {
		return R33_Exposure_Before_CCF;
	}
	public void setR33_Exposure_Before_CCF(BigDecimal r33_Exposure_Before_CCF) {
		R33_Exposure_Before_CCF = r33_Exposure_Before_CCF;
	}
	public BigDecimal getR33_Credit_Conversion_Factor() {
		return R33_Credit_Conversion_Factor;
	}
	public void setR33_Credit_Conversion_Factor(BigDecimal r33_Credit_Conversion_Factor) {
		R33_Credit_Conversion_Factor = r33_Credit_Conversion_Factor;
	}
	public BigDecimal getR33_Exposure_After_CCF() {
		return R33_Exposure_After_CCF;
	}
	public void setR33_Exposure_After_CCF(BigDecimal r33_Exposure_After_CCF) {
		R33_Exposure_After_CCF = r33_Exposure_After_CCF;
	}
	public BigDecimal getR34_S_No() {
		return R34_S_No;
	}
	public void setR34_S_No(BigDecimal r34_S_No) {
		R34_S_No = r34_S_No;
	}
	public String getR34_Product() {
		return R34_Product;
	}
	public void setR34_Product(String r34_Product) {
		R34_Product = r34_Product;
	}
	public BigDecimal getR34_Exposure_Before_CCF() {
		return R34_Exposure_Before_CCF;
	}
	public void setR34_Exposure_Before_CCF(BigDecimal r34_Exposure_Before_CCF) {
		R34_Exposure_Before_CCF = r34_Exposure_Before_CCF;
	}
	public BigDecimal getR34_Credit_Conversion_Factor() {
		return R34_Credit_Conversion_Factor;
	}
	public void setR34_Credit_Conversion_Factor(BigDecimal r34_Credit_Conversion_Factor) {
		R34_Credit_Conversion_Factor = r34_Credit_Conversion_Factor;
	}
	public BigDecimal getR34_Exposure_After_CCF() {
		return R34_Exposure_After_CCF;
	}
	public void setR34_Exposure_After_CCF(BigDecimal r34_Exposure_After_CCF) {
		R34_Exposure_After_CCF = r34_Exposure_After_CCF;
	}
	public BigDecimal getR35_S_No() {
		return R35_S_No;
	}
	public void setR35_S_No(BigDecimal r35_S_No) {
		R35_S_No = r35_S_No;
	}
	public String getR35_Product() {
		return R35_Product;
	}
	public void setR35_Product(String r35_Product) {
		R35_Product = r35_Product;
	}
	public BigDecimal getR35_Exposure_Before_CCF() {
		return R35_Exposure_Before_CCF;
	}
	public void setR35_Exposure_Before_CCF(BigDecimal r35_Exposure_Before_CCF) {
		R35_Exposure_Before_CCF = r35_Exposure_Before_CCF;
	}
	public BigDecimal getR35_Credit_Conversion_Factor() {
		return R35_Credit_Conversion_Factor;
	}
	public void setR35_Credit_Conversion_Factor(BigDecimal r35_Credit_Conversion_Factor) {
		R35_Credit_Conversion_Factor = r35_Credit_Conversion_Factor;
	}
	public BigDecimal getR35_Exposure_After_CCF() {
		return R35_Exposure_After_CCF;
	}
	public void setR35_Exposure_After_CCF(BigDecimal r35_Exposure_After_CCF) {
		R35_Exposure_After_CCF = r35_Exposure_After_CCF;
	}
	public BigDecimal getR36_S_No() {
		return R36_S_No;
	}
	public void setR36_S_No(BigDecimal r36_S_No) {
		R36_S_No = r36_S_No;
	}
	public String getR36_Product() {
		return R36_Product;
	}
	public void setR36_Product(String r36_Product) {
		R36_Product = r36_Product;
	}
	public BigDecimal getR36_Exposure_Before_CCF() {
		return R36_Exposure_Before_CCF;
	}
	public void setR36_Exposure_Before_CCF(BigDecimal r36_Exposure_Before_CCF) {
		R36_Exposure_Before_CCF = r36_Exposure_Before_CCF;
	}
	public BigDecimal getR36_Credit_Conversion_Factor() {
		return R36_Credit_Conversion_Factor;
	}
	public void setR36_Credit_Conversion_Factor(BigDecimal r36_Credit_Conversion_Factor) {
		R36_Credit_Conversion_Factor = r36_Credit_Conversion_Factor;
	}
	public BigDecimal getR36_Exposure_After_CCF() {
		return R36_Exposure_After_CCF;
	}
	public void setR36_Exposure_After_CCF(BigDecimal r36_Exposure_After_CCF) {
		R36_Exposure_After_CCF = r36_Exposure_After_CCF;
	}
	public BigDecimal getR37_S_No() {
		return R37_S_No;
	}
	public void setR37_S_No(BigDecimal r37_S_No) {
		R37_S_No = r37_S_No;
	}
	public String getR37_Product() {
		return R37_Product;
	}
	public void setR37_Product(String r37_Product) {
		R37_Product = r37_Product;
	}
	public BigDecimal getR37_Exposure_Before_CCF() {
		return R37_Exposure_Before_CCF;
	}
	public void setR37_Exposure_Before_CCF(BigDecimal r37_Exposure_Before_CCF) {
		R37_Exposure_Before_CCF = r37_Exposure_Before_CCF;
	}
	public BigDecimal getR37_Credit_Conversion_Factor() {
		return R37_Credit_Conversion_Factor;
	}
	public void setR37_Credit_Conversion_Factor(BigDecimal r37_Credit_Conversion_Factor) {
		R37_Credit_Conversion_Factor = r37_Credit_Conversion_Factor;
	}
	public BigDecimal getR37_Exposure_After_CCF() {
		return R37_Exposure_After_CCF;
	}
	public void setR37_Exposure_After_CCF(BigDecimal r37_Exposure_After_CCF) {
		R37_Exposure_After_CCF = r37_Exposure_After_CCF;
	}
	public BigDecimal getR38_S_No() {
		return R38_S_No;
	}
	public void setR38_S_No(BigDecimal r38_S_No) {
		R38_S_No = r38_S_No;
	}
	public String getR38_Product() {
		return R38_Product;
	}
	public void setR38_Product(String r38_Product) {
		R38_Product = r38_Product;
	}
	public BigDecimal getR38_Exposure_Before_CCF() {
		return R38_Exposure_Before_CCF;
	}
	public void setR38_Exposure_Before_CCF(BigDecimal r38_Exposure_Before_CCF) {
		R38_Exposure_Before_CCF = r38_Exposure_Before_CCF;
	}
	public BigDecimal getR38_Credit_Conversion_Factor() {
		return R38_Credit_Conversion_Factor;
	}
	public void setR38_Credit_Conversion_Factor(BigDecimal r38_Credit_Conversion_Factor) {
		R38_Credit_Conversion_Factor = r38_Credit_Conversion_Factor;
	}
	public BigDecimal getR38_Exposure_After_CCF() {
		return R38_Exposure_After_CCF;
	}
	public void setR38_Exposure_After_CCF(BigDecimal r38_Exposure_After_CCF) {
		R38_Exposure_After_CCF = r38_Exposure_After_CCF;
	}
	public BigDecimal getR39_S_No() {
		return R39_S_No;
	}
	public void setR39_S_No(BigDecimal r39_S_No) {
		R39_S_No = r39_S_No;
	}
	public String getR39_Product() {
		return R39_Product;
	}
	public void setR39_Product(String r39_Product) {
		R39_Product = r39_Product;
	}
	public BigDecimal getR39_AED_000s() {
		return R39_AED_000s;
	}
	public void setR39_AED_000s(BigDecimal r39_AED_000s) {
		R39_AED_000s = r39_AED_000s;
	}
	public BigDecimal getR40_S_No() {
		return R40_S_No;
	}
	public void setR40_S_No(BigDecimal r40_S_No) {
		R40_S_No = r40_S_No;
	}
	public String getR40_Product() {
		return R40_Product;
	}
	public void setR40_Product(String r40_Product) {
		R40_Product = r40_Product;
	}
	public BigDecimal getR40_AED_000s() {
		return R40_AED_000s;
	}
	public void setR40_AED_000s(BigDecimal r40_AED_000s) {
		R40_AED_000s = r40_AED_000s;
	}
	public BigDecimal getR41_S_No() {
		return R41_S_No;
	}
	public void setR41_S_No(BigDecimal r41_S_No) {
		R41_S_No = r41_S_No;
	}
	public String getR41_Product() {
		return R41_Product;
	}
	public void setR41_Product(String r41_Product) {
		R41_Product = r41_Product;
	}
	public BigDecimal getR41_AED_000s() {
		return R41_AED_000s;
	}
	public void setR41_AED_000s(BigDecimal r41_AED_000s) {
		R41_AED_000s = r41_AED_000s;
	}
	public BigDecimal getR42_S_No() {
		return R42_S_No;
	}
	public void setR42_S_No(BigDecimal r42_S_No) {
		R42_S_No = r42_S_No;
	}
	public String getR42_Product() {
		return R42_Product;
	}
	public void setR42_Product(String r42_Product) {
		R42_Product = r42_Product;
	}
	public BigDecimal getR42_AED_000s() {
		return R42_AED_000s;
	}
	public void setR42_AED_000s(BigDecimal r42_AED_000s) {
		R42_AED_000s = r42_AED_000s;
	}
	public BigDecimal getR43_S_No() {
		return R43_S_No;
	}
	public void setR43_S_No(BigDecimal r43_S_No) {
		R43_S_No = r43_S_No;
	}
	public String getR43_Product() {
		return R43_Product;
	}
	public void setR43_Product(String r43_Product) {
		R43_Product = r43_Product;
	}
	public BigDecimal getR43_AED_000s() {
		return R43_AED_000s;
	}
	public void setR43_AED_000s(BigDecimal r43_AED_000s) {
		R43_AED_000s = r43_AED_000s;
	}
	public BigDecimal getR44_S_No() {
		return R44_S_No;
	}
	public void setR44_S_No(BigDecimal r44_S_No) {
		R44_S_No = r44_S_No;
	}
	public String getR44_Product() {
		return R44_Product;
	}
	public void setR44_Product(String r44_Product) {
		R44_Product = r44_Product;
	}
	public BigDecimal getR44_AED_000s() {
		return R44_AED_000s;
	}
	public void setR44_AED_000s(BigDecimal r44_AED_000s) {
		R44_AED_000s = r44_AED_000s;
	}
	public BigDecimal getR45_S_No() {
		return R45_S_No;
	}
	public void setR45_S_No(BigDecimal r45_S_No) {
		R45_S_No = r45_S_No;
	}
	public String getR45_Product() {
		return R45_Product;
	}
	public void setR45_Product(String r45_Product) {
		R45_Product = r45_Product;
	}
	public BigDecimal getR45_AED_000s() {
		return R45_AED_000s;
	}
	public void setR45_AED_000s(BigDecimal r45_AED_000s) {
		R45_AED_000s = r45_AED_000s;
	}
	public BigDecimal getR46_S_No() {
		return R46_S_No;
	}
	public void setR46_S_No(BigDecimal r46_S_No) {
		R46_S_No = r46_S_No;
	}
	public String getR46_Product() {
		return R46_Product;
	}
	public void setR46_Product(String r46_Product) {
		R46_Product = r46_Product;
	}
	public BigDecimal getR46_AED_000s() {
		return R46_AED_000s;
	}
	public void setR46_AED_000s(BigDecimal r46_AED_000s) {
		R46_AED_000s = r46_AED_000s;
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
	public BRF_96_REPORT_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
