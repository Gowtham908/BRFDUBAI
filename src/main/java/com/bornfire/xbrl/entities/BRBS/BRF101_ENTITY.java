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
@Table(name="BRF101_SUMMARY_TABLE")
public class BRF101_ENTITY {
	
	private String	R1_S_NO ;
	private String	R1_SWIFT_PAYMENT ;
	private String	R1_DESCRIPTION ;
	private BigDecimal	R1_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R1_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R1_TOTAL_INFLOWS ;
	private BigDecimal	R1_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R1_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R1_TOTAL_OUTFLOWS ;
	private String	R2_S_NO ;
	private String	R2_SWIFT_PAYMENT ;
	private String	R2_DESCRIPTION ;
	private BigDecimal	R2_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R2_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R2_TOTAL_INFLOWS ;
	private BigDecimal	R2_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R2_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R2_TOTAL_OUTFLOWS ;
	private String	R3_S_NO ;
	private String	R3_SWIFT_PAYMENT ;
	private String	R3_DESCRIPTION ;
	private BigDecimal	R3_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R3_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R3_TOTAL_INFLOWS ;
	private BigDecimal	R3_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R3_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R3_TOTAL_OUTFLOWS ;
	private String	R4_S_NO ;
	private String	R4_SWIFT_PAYMENT ;
	private String	R4_DESCRIPTION ;
	private BigDecimal	R4_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R4_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R4_TOTAL_INFLOWS ;
	private BigDecimal	R4_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R4_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R4_TOTAL_OUTFLOWS ;
	private String	R5_S_NO ;
	private String	R5_SWIFT_PAYMENT ;
	private String	R5_DESCRIPTION ;
	private BigDecimal	R5_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R5_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R5_TOTAL_INFLOWS ;
	private BigDecimal	R5_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R5_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R5_TOTAL_OUTFLOWS ;
	private String	R6_S_NO ;
	private String	R6_SWIFT_PAYMENT ;
	private String	R6_DESCRIPTION ;
	private BigDecimal	R6_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R6_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R6_TOTAL_INFLOWS ;
	private BigDecimal	R6_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R6_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R6_TOTAL_OUTFLOWS ;
	private String	R7_S_NO ;
	private String	R7_SWIFT_PAYMENT ;
	private String	R7_DESCRIPTION ;
	private BigDecimal	R7_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R7_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R7_TOTAL_INFLOWS ;
	private BigDecimal	R7_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R7_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R7_TOTAL_OUTFLOWS ;
	private String	R8_S_NO ;
	private String	R8_SWIFT_PAYMENT ;
	private String	R8_DESCRIPTION ;
	private BigDecimal	R8_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R8_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R8_TOTAL_INFLOWS ;
	private BigDecimal	R8_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R8_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R8_TOTAL_OUTFLOWS ;
	private String	R9_S_NO ;
	private String	R9_SWIFT_PAYMENT ;
	private String	R9_DESCRIPTION ;
	private BigDecimal	R9_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R9_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R9_TOTAL_INFLOWS ;
	private BigDecimal	R9_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R9_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R9_TOTAL_OUTFLOWS ;
	private String	R10_S_NO ;
	private String	R10_SWIFT_PAYMENT ;
	private String	R10_DESCRIPTION ;
	private BigDecimal	R10_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R10_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R10_TOTAL_INFLOWS ;
	private BigDecimal	R10_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R10_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R10_TOTAL_OUTFLOWS ;
	private String	R11_S_NO ;
	private String	R11_SWIFT_PAYMENT ;
	private String	R11_DESCRIPTION ;
	private BigDecimal	R11_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R11_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R11_TOTAL_INFLOWS ;
	private BigDecimal	R11_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R11_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R11_TOTAL_OUTFLOWS ;
	private String	R12_S_NO ;
	private String	R12_SWIFT_PAYMENT ;
	private String	R12_DESCRIPTION ;
	private BigDecimal	R12_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R12_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R12_TOTAL_INFLOWS ;
	private BigDecimal	R12_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R12_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R12_TOTAL_OUTFLOWS ;
	private String	R13_S_NO ;
	private String	R13_SWIFT_PAYMENT ;
	private String	R13_DESCRIPTION ;
	private BigDecimal	R13_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R13_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R13_TOTAL_INFLOWS ;
	private BigDecimal	R13_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R13_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R13_TOTAL_OUTFLOWS ;
	private String	R14_S_NO ;
	private String	R14_SWIFT_PAYMENT ;
	private String	R14_DESCRIPTION ;
	private BigDecimal	R14_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R14_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R14_TOTAL_INFLOWS ;
	private BigDecimal	R14_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R14_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R14_TOTAL_OUTFLOWS ;
	private String	R15_S_NO ;
	private String	R15_SWIFT_PAYMENT ;
	private String	R15_DESCRIPTION ;
	private BigDecimal	R15_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R15_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R15_TOTAL_INFLOWS ;
	private BigDecimal	R15_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R15_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R15_TOTAL_OUTFLOWS ;
	private String	R16_S_NO ;
	private String	R16_SWIFT_PAYMENT ;
	private String	R16_DESCRIPTION ;
	private BigDecimal	R16_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R16_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R16_TOTAL_INFLOWS ;
	private BigDecimal	R16_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R16_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R16_TOTAL_OUTFLOWS ;
	private String	R17_S_NO ;
	private String	R17_SWIFT_PAYMENT ;
	private String	R17_DESCRIPTION ;
	private BigDecimal	R17_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R17_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R17_TOTAL_INFLOWS ;
	private BigDecimal	R17_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R17_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R17_TOTAL_OUTFLOWS ;
	private String	R18_S_NO ;
	private String	R18_SWIFT_PAYMENT ;
	private String	R18_DESCRIPTION ;
	private BigDecimal	R18_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R18_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R18_TOTAL_INFLOWS ;
	private BigDecimal	R18_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R18_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R18_TOTAL_OUTFLOWS ;
	private String	R19_S_NO ;
	private String	R19_SWIFT_PAYMENT ;
	private String	R19_DESCRIPTION ;
	private BigDecimal	R19_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R19_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R19_TOTAL_INFLOWS ;
	private BigDecimal	R19_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R19_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R19_TOTAL_OUTFLOWS ;
	private String	R20_S_NO ;
	private String	R20_SWIFT_PAYMENT ;
	private String	R20_DESCRIPTION ;
	private BigDecimal	R20_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R20_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R20_TOTAL_INFLOWS ;
	private BigDecimal	R20_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R20_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R20_TOTAL_OUTFLOWS ;
	private String	R21_S_NO ;
	private String	R21_SWIFT_PAYMENT ;
	private String	R21_DESCRIPTION ;
	private BigDecimal	R21_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R21_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R21_TOTAL_INFLOWS ;
	private BigDecimal	R21_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R21_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R21_TOTAL_OUTFLOWS ;
	private String	R22_S_NO ;
	private String	R22_SWIFT_PAYMENT ;
	private String	R22_DESCRIPTION ;
	private BigDecimal	R22_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R22_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R22_TOTAL_INFLOWS ;
	private BigDecimal	R22_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R22_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R22_TOTAL_OUTFLOWS ;
	private String	R23_S_NO ;
	private String	R23_SWIFT_PAYMENT ;
	private String	R23_DESCRIPTION ;
	private BigDecimal	R23_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R23_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R23_TOTAL_INFLOWS ;
	private BigDecimal	R23_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R23_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R23_TOTAL_OUTFLOWS ;
	private String	R24_S_NO ;
	private String	R24_SWIFT_PAYMENT ;
	private String	R24_DESCRIPTION ;
	private BigDecimal	R24_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R24_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R24_TOTAL_INFLOWS ;
	private BigDecimal	R24_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R24_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R24_TOTAL_OUTFLOWS ;
	private String	R25_S_NO ;
	private String	R25_SWIFT_PAYMENT ;
	private String	R25_DESCRIPTION ;
	private BigDecimal	R25_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R25_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R25_TOTAL_INFLOWS ;
	private BigDecimal	R25_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R25_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R25_TOTAL_OUTFLOWS ;
	private String	R26_S_NO ;
	private String	R26_SWIFT_PAYMENT ;
	private String	R26_DESCRIPTION ;
	private BigDecimal	R26_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R26_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R26_TOTAL_INFLOWS ;
	private BigDecimal	R26_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R26_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R26_TOTAL_OUTFLOWS ;
	private String	R27_S_NO ;
	private String	R27_SWIFT_PAYMENT ;
	private String	R27_DESCRIPTION ;
	private BigDecimal	R27_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R27_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R27_TOTAL_INFLOWS ;
	private BigDecimal	R27_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R27_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R27_TOTAL_OUTFLOWS ;
	private String	R28_S_NO ;
	private String	R28_SWIFT_PAYMENT ;
	private String	R28_DESCRIPTION ;
	private BigDecimal	R28_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R28_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R28_TOTAL_INFLOWS ;
	private BigDecimal	R28_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R28_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R28_TOTAL_OUTFLOWS ;
	private String	R29_S_NO ;
	private String	R29_SWIFT_PAYMENT ;
	private String	R29_DESCRIPTION ;
	private BigDecimal	R29_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R29_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R29_TOTAL_INFLOWS ;
	private BigDecimal	R29_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R29_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R29_TOTAL_OUTFLOWS ;
	private String	R30_S_NO ;
	private String	R30_SWIFT_PAYMENT ;
	private String	R30_DESCRIPTION ;
	private BigDecimal	R30_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R30_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R30_TOTAL_INFLOWS ;
	private BigDecimal	R30_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R30_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R30_TOTAL_OUTFLOWS ;
	private String	R31_S_NO ;
	private String	R31_SWIFT_PAYMENT ;
	private String	R31_DESCRIPTION ;
	private BigDecimal	R31_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R31_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R31_TOTAL_INFLOWS ;
	private BigDecimal	R31_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R31_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R31_TOTAL_OUTFLOWS ;
	private String	R32_S_NO ;
	private String	R32_SWIFT_PAYMENT ;
	private String	R32_DESCRIPTION ;
	private BigDecimal	R32_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R32_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R32_TOTAL_INFLOWS ;
	private BigDecimal	R32_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R32_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R32_TOTAL_OUTFLOWS ;
	private String	R33_S_NO ;
	private String	R33_SWIFT_PAYMENT ;
	private String	R33_DESCRIPTION ;
	private BigDecimal	R33_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R33_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R33_TOTAL_INFLOWS ;
	private BigDecimal	R33_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R33_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R33_TOTAL_OUTFLOWS ;
	private String	R34_S_NO ;
	private String	R34_SWIFT_PAYMENT ;
	private String	R34_DESCRIPTION ;
	private BigDecimal	R34_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R34_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R34_TOTAL_INFLOWS ;
	private BigDecimal	R34_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R34_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R34_TOTAL_OUTFLOWS ;
	private String	R35_S_NO ;
	private String	R35_SWIFT_PAYMENT ;
	private String	R35_DESCRIPTION ;
	private BigDecimal	R35_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R35_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R35_TOTAL_INFLOWS ;
	private BigDecimal	R35_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R35_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R35_TOTAL_OUTFLOWS ;
	private String	R36_S_NO ;
	private String	R36_SWIFT_PAYMENT ;
	private String	R36_DESCRIPTION ;
	private BigDecimal	R36_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R36_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R36_TOTAL_INFLOWS ;
	private BigDecimal	R36_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R36_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R36_TOTAL_OUTFLOWS ;
	private String	R37_S_NO ;
	private String	R37_SWIFT_PAYMENT ;
	private String	R37_DESCRIPTION ;
	private BigDecimal	R37_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R37_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R37_TOTAL_INFLOWS ;
	private BigDecimal	R37_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R37_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R37_TOTAL_OUTFLOWS ;
	private String	R38_S_NO ;
	private String	R38_SWIFT_PAYMENT ;
	private String	R38_DESCRIPTION ;
	private BigDecimal	R38_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R38_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R38_TOTAL_INFLOWS ;
	private BigDecimal	R38_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R38_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R38_TOTAL_OUTFLOWS ;
	private String	R39_S_NO ;
	private String	R39_SWIFT_PAYMENT ;
	private String	R39_DESCRIPTION ;
	private BigDecimal	R39_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R39_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R39_TOTAL_INFLOWS ;
	private BigDecimal	R39_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R39_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R39_TOTAL_OUTFLOWS ;
	private String	R40_S_NO ;
	private String	R40_SWIFT_PAYMENT ;
	private String	R40_DESCRIPTION ;
	private BigDecimal	R40_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R40_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R40_TOTAL_INFLOWS ;
	private BigDecimal	R40_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R40_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R40_TOTAL_OUTFLOWS ;
	private String	R41_S_NO ;
	private String	R41_SWIFT_PAYMENT ;
	private String	R41_DESCRIPTION ;
	private BigDecimal	R41_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R41_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R41_TOTAL_INFLOWS ;
	private BigDecimal	R41_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R41_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R41_TOTAL_OUTFLOWS ;
	private String	R42_S_NO ;
	private String	R42_SWIFT_PAYMENT ;
	private String	R42_DESCRIPTION ;
	private BigDecimal	R42_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R42_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R42_TOTAL_INFLOWS ;
	private BigDecimal	R42_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R42_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R42_TOTAL_OUTFLOWS ;
	private String	R43_S_NO ;
	private String	R43_SWIFT_PAYMENT ;
	private String	R43_DESCRIPTION ;
	private BigDecimal	R43_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R43_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R43_TOTAL_INFLOWS ;
	private BigDecimal	R43_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R43_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R43_TOTAL_OUTFLOWS ;
	private String	R44_S_NO ;
	private String	R44_SWIFT_PAYMENT ;
	private String	R44_DESCRIPTION ;
	private BigDecimal	R44_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R44_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R44_TOTAL_INFLOWS ;
	private BigDecimal	R44_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R44_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R44_TOTAL_OUTFLOWS ;
	private String	R45_S_NO ;
	private String	R45_SWIFT_PAYMENT ;
	private String	R45_DESCRIPTION ;
	private BigDecimal	R45_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R45_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R45_TOTAL_INFLOWS ;
	private BigDecimal	R45_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R45_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R45_TOTAL_OUTFLOWS ;
	private String	R46_S_NO ;
	private String	R46_SWIFT_PAYMENT ;
	private String	R46_DESCRIPTION ;
	private BigDecimal	R46_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R46_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R46_TOTAL_INFLOWS ;
	private BigDecimal	R46_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R46_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R46_TOTAL_OUTFLOWS ;
	private String	R47_S_NO ;
	private String	R47_SWIFT_PAYMENT ;
	private String	R47_DESCRIPTION ;
	private BigDecimal	R47_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R47_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R47_TOTAL_INFLOWS ;
	private BigDecimal	R47_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R47_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R47_TOTAL_OUTFLOWS ;
	private String	R48_S_NO ;
	private String	R48_SWIFT_PAYMENT ;
	private String	R48_DESCRIPTION ;
	private BigDecimal	R48_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R48_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R48_TOTAL_INFLOWS ;
	private BigDecimal	R48_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R48_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R48_TOTAL_OUTFLOWS ;
	private String	R49_S_NO ;
	private String	R49_SWIFT_PAYMENT ;
	private String	R49_DESCRIPTION ;
	private BigDecimal	R49_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R49_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R49_TOTAL_INFLOWS ;
	private BigDecimal	R49_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R49_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R49_TOTAL_OUTFLOWS ;
	private String	R50_S_NO ;
	private String	R50_SWIFT_PAYMENT ;
	private String	R50_DESCRIPTION ;
	private BigDecimal	R50_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R50_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R50_TOTAL_INFLOWS ;
	private BigDecimal	R50_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R50_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R50_TOTAL_OUTFLOWS ;
	private String	R51_S_NO ;
	private String	R51_SWIFT_PAYMENT ;
	private String	R51_DESCRIPTION ;
	private BigDecimal	R51_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R51_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R51_TOTAL_INFLOWS ;
	private BigDecimal	R51_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R51_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R51_TOTAL_OUTFLOWS ;
	private String	R52_S_NO ;
	private String	R52_SWIFT_PAYMENT ;
	private String	R52_DESCRIPTION ;
	private BigDecimal	R52_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R52_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R52_TOTAL_INFLOWS ;
	private BigDecimal	R52_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R52_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R52_TOTAL_OUTFLOWS ;
	private String	R53_S_NO ;
	private String	R53_SWIFT_PAYMENT ;
	private String	R53_DESCRIPTION ;
	private BigDecimal	R53_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R53_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R53_TOTAL_INFLOWS ;
	private BigDecimal	R53_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R53_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R53_TOTAL_OUTFLOWS ;
	private String	R54_S_NO ;
	private String	R54_SWIFT_PAYMENT ;
	private String	R54_DESCRIPTION ;
	private BigDecimal	R54_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R54_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R54_TOTAL_INFLOWS ;
	private BigDecimal	R54_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R54_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R54_TOTAL_OUTFLOWS ;
	private String	R55_S_NO ;
	private String	R55_SWIFT_PAYMENT ;
	private String	R55_DESCRIPTION ;
	private BigDecimal	R55_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R55_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R55_TOTAL_INFLOWS ;
	private BigDecimal	R55_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R55_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R55_TOTAL_OUTFLOWS ;
	private String	R56_S_NO ;
	private String	R56_SWIFT_PAYMENT ;
	private String	R56_DESCRIPTION ;
	private BigDecimal	R56_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R56_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R56_TOTAL_INFLOWS ;
	private BigDecimal	R56_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R56_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R56_TOTAL_OUTFLOWS ;
	private String	R57_S_NO ;
	private String	R57_SWIFT_PAYMENT ;
	private String	R57_DESCRIPTION ;
	private BigDecimal	R57_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R57_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R57_TOTAL_INFLOWS ;
	private BigDecimal	R57_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R57_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R57_TOTAL_OUTFLOWS ;
	private String	R58_S_NO ;
	private String	R58_SWIFT_PAYMENT ;
	private String	R58_DESCRIPTION ;
	private BigDecimal	R58_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R58_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R58_TOTAL_INFLOWS ;
	private BigDecimal	R58_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R58_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R58_TOTAL_OUTFLOWS ;
	private String	R59_S_NO ;
	private String	R59_SWIFT_PAYMENT ;
	private String	R59_DESCRIPTION ;
	private BigDecimal	R59_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R59_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R59_TOTAL_INFLOWS ;
	private BigDecimal	R59_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R59_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R59_TOTAL_OUTFLOWS ;
	private String	R60_S_NO ;
	private String	R60_SWIFT_PAYMENT ;
	private String	R60_DESCRIPTION ;
	private BigDecimal	R60_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R60_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R60_TOTAL_INFLOWS ;
	private BigDecimal	R60_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R60_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R60_TOTAL_OUTFLOWS ;
	private String	R61_S_NO ;
	private String	R61_SWIFT_PAYMENT ;
	private String	R61_DESCRIPTION ;
	private BigDecimal	R61_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R61_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R61_TOTAL_INFLOWS ;
	private BigDecimal	R61_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R61_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R61_TOTAL_OUTFLOWS ;
	private String	R62_S_NO ;
	private String	R62_SWIFT_PAYMENT ;
	private String	R62_DESCRIPTION ;
	private BigDecimal	R62_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R62_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R62_TOTAL_INFLOWS ;
	private BigDecimal	R62_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R62_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R62_TOTAL_OUTFLOWS ;
	private String	R63_S_NO ;
	private String	R63_SWIFT_PAYMENT ;
	private String	R63_DESCRIPTION ;
	private BigDecimal	R63_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R63_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R63_TOTAL_INFLOWS ;
	private BigDecimal	R63_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R63_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R63_TOTAL_OUTFLOWS ;
	private String	R64_S_NO ;
	private String	R64_SWIFT_PAYMENT ;
	private String	R64_DESCRIPTION ;
	private BigDecimal	R64_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R64_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R64_TOTAL_INFLOWS ;
	private BigDecimal	R64_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R64_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R64_TOTAL_OUTFLOWS ;
	private String	R65_S_NO ;
	private String	R65_SWIFT_PAYMENT ;
	private String	R65_DESCRIPTION ;
	private BigDecimal	R65_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R65_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R65_TOTAL_INFLOWS ;
	private BigDecimal	R65_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R65_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R65_TOTAL_OUTFLOWS ;
	private String	R66_S_NO ;
	private String	R66_SWIFT_PAYMENT ;
	private String	R66_DESCRIPTION ;
	private BigDecimal	R66_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R66_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R66_TOTAL_INFLOWS ;
	private BigDecimal	R66_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R66_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R66_TOTAL_OUTFLOWS ;
	private String	R67_S_NO ;
	private String	R67_SWIFT_PAYMENT ;
	private String	R67_DESCRIPTION ;
	private BigDecimal	R67_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R67_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R67_TOTAL_INFLOWS ;
	private BigDecimal	R67_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R67_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R67_TOTAL_OUTFLOWS ;
	private String	R68_S_NO ;
	private String	R68_SWIFT_PAYMENT ;
	private String	R68_DESCRIPTION ;
	private BigDecimal	R68_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R68_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R68_TOTAL_INFLOWS ;
	private BigDecimal	R68_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R68_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R68_TOTAL_OUTFLOWS ;
	private String	R69_S_NO ;
	private String	R69_SWIFT_PAYMENT ;
	private String	R69_DESCRIPTION ;
	private BigDecimal	R69_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R69_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R69_TOTAL_INFLOWS ;
	private BigDecimal	R69_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R69_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R69_TOTAL_OUTFLOWS ;
	private String	R70_S_NO ;
	private String	R70_SWIFT_PAYMENT ;
	private String	R70_DESCRIPTION ;
	private BigDecimal	R70_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R70_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R70_TOTAL_INFLOWS ;
	private BigDecimal	R70_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R70_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R70_TOTAL_OUTFLOWS ;
	private String	R71_S_NO ;
	private String	R71_SWIFT_PAYMENT ;
	private String	R71_DESCRIPTION ;
	private BigDecimal	R71_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R71_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R71_TOTAL_INFLOWS ;
	private BigDecimal	R71_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R71_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R71_TOTAL_OUTFLOWS ;
	private String	R72_S_NO ;
	private String	R72_SWIFT_PAYMENT ;
	private String	R72_DESCRIPTION ;
	private BigDecimal	R72_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R72_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R72_TOTAL_INFLOWS ;
	private BigDecimal	R72_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R72_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R72_TOTAL_OUTFLOWS ;
	private String	R73_S_NO ;
	private String	R73_SWIFT_PAYMENT ;
	private String	R73_DESCRIPTION ;
	private BigDecimal	R73_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R73_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R73_TOTAL_INFLOWS ;
	private BigDecimal	R73_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R73_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R73_TOTAL_OUTFLOWS ;
	private String	R74_S_NO ;
	private String	R74_SWIFT_PAYMENT ;
	private String	R74_DESCRIPTION ;
	private BigDecimal	R74_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R74_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R74_TOTAL_INFLOWS ;
	private BigDecimal	R74_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R74_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R74_TOTAL_OUTFLOWS ;
	private String	R75_S_NO ;
	private String	R75_SWIFT_PAYMENT ;
	private String	R75_DESCRIPTION ;
	private BigDecimal	R75_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R75_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R75_TOTAL_INFLOWS ;
	private BigDecimal	R75_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R75_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R75_TOTAL_OUTFLOWS ;
	private String	R76_S_NO ;
	private String	R76_SWIFT_PAYMENT ;
	private String	R76_DESCRIPTION ;
	private BigDecimal	R76_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R76_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R76_TOTAL_INFLOWS ;
	private BigDecimal	R76_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R76_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R76_TOTAL_OUTFLOWS ;
	private String	R77_S_NO ;
	private String	R77_SWIFT_PAYMENT ;
	private String	R77_DESCRIPTION ;
	private BigDecimal	R77_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R77_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R77_TOTAL_INFLOWS ;
	private BigDecimal	R77_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R77_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R77_TOTAL_OUTFLOWS ;
	private String	R78_S_NO ;
	private String	R78_SWIFT_PAYMENT ;
	private String	R78_DESCRIPTION ;
	private BigDecimal	R78_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R78_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R78_TOTAL_INFLOWS ;
	private BigDecimal	R78_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R78_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R78_TOTAL_OUTFLOWS ;
	private String	R79_S_NO ;
	private String	R79_SWIFT_PAYMENT ;
	private String	R79_DESCRIPTION ;
	private BigDecimal	R79_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R79_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R79_TOTAL_INFLOWS ;
	private BigDecimal	R79_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R79_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R79_TOTAL_OUTFLOWS ;
	private String	R80_S_NO ;
	private String	R80_SWIFT_PAYMENT ;
	private String	R80_DESCRIPTION ;
	private BigDecimal	R80_All_TRANSACTIONS_INFLOWS ;
	private BigDecimal	R80_FINANCIAL_FREE_ZONE_INFLOWS ;
	private BigDecimal	R80_TOTAL_INFLOWS ;
	private BigDecimal	R80_All_TRANSACTIONS_OUTFLOWS ;
	private BigDecimal	R80_FINANCIAL_FREE_ZONE_OUTFLOWS ;
	private BigDecimal	R80_TOTAL_OUTFLOWS ;
	private String	R81_S_NO ;
	private String	R81_DESCRIPTION ;
	private BigDecimal	R81_TOTAL_OUTFLOWS ;
	private String	R82_S_NO ;
	private String	R82_DESCRIPTION ;
	private BigDecimal	R82_TOTAL_OUTFLOWS ;
	private String	R83_S_NO ;
	private String	R83_DESCRIPTION ;
	private BigDecimal	R83_TOTAL_OUTFLOWS ;
	private String	R84_S_NO ;
	private String	R84_DESCRIPTION ;
	private BigDecimal	R84_TOTAL_OUTFLOWS ;
	private String	R85_S_NO ;
	private String	R85_DESCRIPTION ;
	private BigDecimal	R85_TOTAL_OUTFLOWS ;
	private String	R86_S_NO ;
	private String	R86_DESCRIPTION ;
	private BigDecimal	R86_TOTAL_OUTFLOWS ;
	private String	R87_S_NO ;
	private String	R87_DESCRIPTION ;
	private BigDecimal	R87_TOTAL_OUTFLOWS ;
	private String	R88_S_NO ;
	private String	R88_DESCRIPTION ;
	private BigDecimal	R88_TOTAL_OUTFLOWS ;
	private String	R89_S_NO ;
	private String	R89_DESCRIPTION ;
	private BigDecimal	R89_TOTAL_OUTFLOWS ;
	private String	R90_S_NO ;
	private String	R90_DESCRIPTION ;
	private BigDecimal	R90_TOTAL_OUTFLOWS ;
	private String	R91_S_NO ;
	private String	R91_DESCRIPTION ;
	private BigDecimal	R91_TOTAL_OUTFLOWS ;
	private String	R92_S_NO ;
	private String	R92_DESCRIPTION ;
	private BigDecimal	R92_TOTAL_OUTFLOWS ;
	private String	R93_S_NO ;
	private String	R93_DESCRIPTION ;
	private BigDecimal	R93_TOTAL_OUTFLOWS ;
	private String	R94_S_NO ;
	private String	R94_DESCRIPTION ;
	private BigDecimal	R94_TOTAL_OUTFLOWS ;
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
	public String getR1_S_NO() {
		return R1_S_NO;
	}
	public void setR1_S_NO(String r1_S_NO) {
		R1_S_NO = r1_S_NO;
	}
	public String getR1_SWIFT_PAYMENT() {
		return R1_SWIFT_PAYMENT;
	}
	public void setR1_SWIFT_PAYMENT(String r1_SWIFT_PAYMENT) {
		R1_SWIFT_PAYMENT = r1_SWIFT_PAYMENT;
	}
	public String getR1_DESCRIPTION() {
		return R1_DESCRIPTION;
	}
	public void setR1_DESCRIPTION(String r1_DESCRIPTION) {
		R1_DESCRIPTION = r1_DESCRIPTION;
	}
	public BigDecimal getR1_All_TRANSACTIONS_INFLOWS() {
		return R1_All_TRANSACTIONS_INFLOWS;
	}
	public void setR1_All_TRANSACTIONS_INFLOWS(BigDecimal r1_All_TRANSACTIONS_INFLOWS) {
		R1_All_TRANSACTIONS_INFLOWS = r1_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR1_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R1_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR1_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r1_FINANCIAL_FREE_ZONE_INFLOWS) {
		R1_FINANCIAL_FREE_ZONE_INFLOWS = r1_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR1_TOTAL_INFLOWS() {
		return R1_TOTAL_INFLOWS;
	}
	public void setR1_TOTAL_INFLOWS(BigDecimal r1_TOTAL_INFLOWS) {
		R1_TOTAL_INFLOWS = r1_TOTAL_INFLOWS;
	}
	public BigDecimal getR1_All_TRANSACTIONS_OUTFLOWS() {
		return R1_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR1_All_TRANSACTIONS_OUTFLOWS(BigDecimal r1_All_TRANSACTIONS_OUTFLOWS) {
		R1_All_TRANSACTIONS_OUTFLOWS = r1_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR1_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R1_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR1_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r1_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R1_FINANCIAL_FREE_ZONE_OUTFLOWS = r1_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR1_TOTAL_OUTFLOWS() {
		return R1_TOTAL_OUTFLOWS;
	}
	public void setR1_TOTAL_OUTFLOWS(BigDecimal r1_TOTAL_OUTFLOWS) {
		R1_TOTAL_OUTFLOWS = r1_TOTAL_OUTFLOWS;
	}
	public String getR2_S_NO() {
		return R2_S_NO;
	}
	public void setR2_S_NO(String r2_S_NO) {
		R2_S_NO = r2_S_NO;
	}
	public String getR2_SWIFT_PAYMENT() {
		return R2_SWIFT_PAYMENT;
	}
	public void setR2_SWIFT_PAYMENT(String r2_SWIFT_PAYMENT) {
		R2_SWIFT_PAYMENT = r2_SWIFT_PAYMENT;
	}
	public String getR2_DESCRIPTION() {
		return R2_DESCRIPTION;
	}
	public void setR2_DESCRIPTION(String r2_DESCRIPTION) {
		R2_DESCRIPTION = r2_DESCRIPTION;
	}
	public BigDecimal getR2_All_TRANSACTIONS_INFLOWS() {
		return R2_All_TRANSACTIONS_INFLOWS;
	}
	public void setR2_All_TRANSACTIONS_INFLOWS(BigDecimal r2_All_TRANSACTIONS_INFLOWS) {
		R2_All_TRANSACTIONS_INFLOWS = r2_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR2_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R2_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR2_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r2_FINANCIAL_FREE_ZONE_INFLOWS) {
		R2_FINANCIAL_FREE_ZONE_INFLOWS = r2_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR2_TOTAL_INFLOWS() {
		return R2_TOTAL_INFLOWS;
	}
	public void setR2_TOTAL_INFLOWS(BigDecimal r2_TOTAL_INFLOWS) {
		R2_TOTAL_INFLOWS = r2_TOTAL_INFLOWS;
	}
	public BigDecimal getR2_All_TRANSACTIONS_OUTFLOWS() {
		return R2_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR2_All_TRANSACTIONS_OUTFLOWS(BigDecimal r2_All_TRANSACTIONS_OUTFLOWS) {
		R2_All_TRANSACTIONS_OUTFLOWS = r2_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR2_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R2_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR2_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r2_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R2_FINANCIAL_FREE_ZONE_OUTFLOWS = r2_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR2_TOTAL_OUTFLOWS() {
		return R2_TOTAL_OUTFLOWS;
	}
	public void setR2_TOTAL_OUTFLOWS(BigDecimal r2_TOTAL_OUTFLOWS) {
		R2_TOTAL_OUTFLOWS = r2_TOTAL_OUTFLOWS;
	}
	public String getR3_S_NO() {
		return R3_S_NO;
	}
	public void setR3_S_NO(String r3_S_NO) {
		R3_S_NO = r3_S_NO;
	}
	public String getR3_SWIFT_PAYMENT() {
		return R3_SWIFT_PAYMENT;
	}
	public void setR3_SWIFT_PAYMENT(String r3_SWIFT_PAYMENT) {
		R3_SWIFT_PAYMENT = r3_SWIFT_PAYMENT;
	}
	public String getR3_DESCRIPTION() {
		return R3_DESCRIPTION;
	}
	public void setR3_DESCRIPTION(String r3_DESCRIPTION) {
		R3_DESCRIPTION = r3_DESCRIPTION;
	}
	public BigDecimal getR3_All_TRANSACTIONS_INFLOWS() {
		return R3_All_TRANSACTIONS_INFLOWS;
	}
	public void setR3_All_TRANSACTIONS_INFLOWS(BigDecimal r3_All_TRANSACTIONS_INFLOWS) {
		R3_All_TRANSACTIONS_INFLOWS = r3_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR3_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R3_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR3_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r3_FINANCIAL_FREE_ZONE_INFLOWS) {
		R3_FINANCIAL_FREE_ZONE_INFLOWS = r3_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR3_TOTAL_INFLOWS() {
		return R3_TOTAL_INFLOWS;
	}
	public void setR3_TOTAL_INFLOWS(BigDecimal r3_TOTAL_INFLOWS) {
		R3_TOTAL_INFLOWS = r3_TOTAL_INFLOWS;
	}
	public BigDecimal getR3_All_TRANSACTIONS_OUTFLOWS() {
		return R3_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR3_All_TRANSACTIONS_OUTFLOWS(BigDecimal r3_All_TRANSACTIONS_OUTFLOWS) {
		R3_All_TRANSACTIONS_OUTFLOWS = r3_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR3_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R3_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR3_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r3_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R3_FINANCIAL_FREE_ZONE_OUTFLOWS = r3_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR3_TOTAL_OUTFLOWS() {
		return R3_TOTAL_OUTFLOWS;
	}
	public void setR3_TOTAL_OUTFLOWS(BigDecimal r3_TOTAL_OUTFLOWS) {
		R3_TOTAL_OUTFLOWS = r3_TOTAL_OUTFLOWS;
	}
	public String getR4_S_NO() {
		return R4_S_NO;
	}
	public void setR4_S_NO(String r4_S_NO) {
		R4_S_NO = r4_S_NO;
	}
	public String getR4_SWIFT_PAYMENT() {
		return R4_SWIFT_PAYMENT;
	}
	public void setR4_SWIFT_PAYMENT(String r4_SWIFT_PAYMENT) {
		R4_SWIFT_PAYMENT = r4_SWIFT_PAYMENT;
	}
	public String getR4_DESCRIPTION() {
		return R4_DESCRIPTION;
	}
	public void setR4_DESCRIPTION(String r4_DESCRIPTION) {
		R4_DESCRIPTION = r4_DESCRIPTION;
	}
	public BigDecimal getR4_All_TRANSACTIONS_INFLOWS() {
		return R4_All_TRANSACTIONS_INFLOWS;
	}
	public void setR4_All_TRANSACTIONS_INFLOWS(BigDecimal r4_All_TRANSACTIONS_INFLOWS) {
		R4_All_TRANSACTIONS_INFLOWS = r4_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR4_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R4_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR4_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r4_FINANCIAL_FREE_ZONE_INFLOWS) {
		R4_FINANCIAL_FREE_ZONE_INFLOWS = r4_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR4_TOTAL_INFLOWS() {
		return R4_TOTAL_INFLOWS;
	}
	public void setR4_TOTAL_INFLOWS(BigDecimal r4_TOTAL_INFLOWS) {
		R4_TOTAL_INFLOWS = r4_TOTAL_INFLOWS;
	}
	public BigDecimal getR4_All_TRANSACTIONS_OUTFLOWS() {
		return R4_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR4_All_TRANSACTIONS_OUTFLOWS(BigDecimal r4_All_TRANSACTIONS_OUTFLOWS) {
		R4_All_TRANSACTIONS_OUTFLOWS = r4_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR4_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R4_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR4_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r4_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R4_FINANCIAL_FREE_ZONE_OUTFLOWS = r4_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR4_TOTAL_OUTFLOWS() {
		return R4_TOTAL_OUTFLOWS;
	}
	public void setR4_TOTAL_OUTFLOWS(BigDecimal r4_TOTAL_OUTFLOWS) {
		R4_TOTAL_OUTFLOWS = r4_TOTAL_OUTFLOWS;
	}
	public String getR5_S_NO() {
		return R5_S_NO;
	}
	public void setR5_S_NO(String r5_S_NO) {
		R5_S_NO = r5_S_NO;
	}
	public String getR5_SWIFT_PAYMENT() {
		return R5_SWIFT_PAYMENT;
	}
	public void setR5_SWIFT_PAYMENT(String r5_SWIFT_PAYMENT) {
		R5_SWIFT_PAYMENT = r5_SWIFT_PAYMENT;
	}
	public String getR5_DESCRIPTION() {
		return R5_DESCRIPTION;
	}
	public void setR5_DESCRIPTION(String r5_DESCRIPTION) {
		R5_DESCRIPTION = r5_DESCRIPTION;
	}
	public BigDecimal getR5_All_TRANSACTIONS_INFLOWS() {
		return R5_All_TRANSACTIONS_INFLOWS;
	}
	public void setR5_All_TRANSACTIONS_INFLOWS(BigDecimal r5_All_TRANSACTIONS_INFLOWS) {
		R5_All_TRANSACTIONS_INFLOWS = r5_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR5_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R5_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR5_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r5_FINANCIAL_FREE_ZONE_INFLOWS) {
		R5_FINANCIAL_FREE_ZONE_INFLOWS = r5_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR5_TOTAL_INFLOWS() {
		return R5_TOTAL_INFLOWS;
	}
	public void setR5_TOTAL_INFLOWS(BigDecimal r5_TOTAL_INFLOWS) {
		R5_TOTAL_INFLOWS = r5_TOTAL_INFLOWS;
	}
	public BigDecimal getR5_All_TRANSACTIONS_OUTFLOWS() {
		return R5_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR5_All_TRANSACTIONS_OUTFLOWS(BigDecimal r5_All_TRANSACTIONS_OUTFLOWS) {
		R5_All_TRANSACTIONS_OUTFLOWS = r5_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR5_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R5_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR5_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r5_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R5_FINANCIAL_FREE_ZONE_OUTFLOWS = r5_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR5_TOTAL_OUTFLOWS() {
		return R5_TOTAL_OUTFLOWS;
	}
	public void setR5_TOTAL_OUTFLOWS(BigDecimal r5_TOTAL_OUTFLOWS) {
		R5_TOTAL_OUTFLOWS = r5_TOTAL_OUTFLOWS;
	}
	public String getR6_S_NO() {
		return R6_S_NO;
	}
	public void setR6_S_NO(String r6_S_NO) {
		R6_S_NO = r6_S_NO;
	}
	public String getR6_SWIFT_PAYMENT() {
		return R6_SWIFT_PAYMENT;
	}
	public void setR6_SWIFT_PAYMENT(String r6_SWIFT_PAYMENT) {
		R6_SWIFT_PAYMENT = r6_SWIFT_PAYMENT;
	}
	public String getR6_DESCRIPTION() {
		return R6_DESCRIPTION;
	}
	public void setR6_DESCRIPTION(String r6_DESCRIPTION) {
		R6_DESCRIPTION = r6_DESCRIPTION;
	}
	public BigDecimal getR6_All_TRANSACTIONS_INFLOWS() {
		return R6_All_TRANSACTIONS_INFLOWS;
	}
	public void setR6_All_TRANSACTIONS_INFLOWS(BigDecimal r6_All_TRANSACTIONS_INFLOWS) {
		R6_All_TRANSACTIONS_INFLOWS = r6_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR6_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R6_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR6_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r6_FINANCIAL_FREE_ZONE_INFLOWS) {
		R6_FINANCIAL_FREE_ZONE_INFLOWS = r6_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR6_TOTAL_INFLOWS() {
		return R6_TOTAL_INFLOWS;
	}
	public void setR6_TOTAL_INFLOWS(BigDecimal r6_TOTAL_INFLOWS) {
		R6_TOTAL_INFLOWS = r6_TOTAL_INFLOWS;
	}
	public BigDecimal getR6_All_TRANSACTIONS_OUTFLOWS() {
		return R6_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR6_All_TRANSACTIONS_OUTFLOWS(BigDecimal r6_All_TRANSACTIONS_OUTFLOWS) {
		R6_All_TRANSACTIONS_OUTFLOWS = r6_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR6_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R6_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR6_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r6_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R6_FINANCIAL_FREE_ZONE_OUTFLOWS = r6_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR6_TOTAL_OUTFLOWS() {
		return R6_TOTAL_OUTFLOWS;
	}
	public void setR6_TOTAL_OUTFLOWS(BigDecimal r6_TOTAL_OUTFLOWS) {
		R6_TOTAL_OUTFLOWS = r6_TOTAL_OUTFLOWS;
	}
	public String getR7_S_NO() {
		return R7_S_NO;
	}
	public void setR7_S_NO(String r7_S_NO) {
		R7_S_NO = r7_S_NO;
	}
	public String getR7_SWIFT_PAYMENT() {
		return R7_SWIFT_PAYMENT;
	}
	public void setR7_SWIFT_PAYMENT(String r7_SWIFT_PAYMENT) {
		R7_SWIFT_PAYMENT = r7_SWIFT_PAYMENT;
	}
	public String getR7_DESCRIPTION() {
		return R7_DESCRIPTION;
	}
	public void setR7_DESCRIPTION(String r7_DESCRIPTION) {
		R7_DESCRIPTION = r7_DESCRIPTION;
	}
	public BigDecimal getR7_All_TRANSACTIONS_INFLOWS() {
		return R7_All_TRANSACTIONS_INFLOWS;
	}
	public void setR7_All_TRANSACTIONS_INFLOWS(BigDecimal r7_All_TRANSACTIONS_INFLOWS) {
		R7_All_TRANSACTIONS_INFLOWS = r7_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR7_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R7_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR7_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r7_FINANCIAL_FREE_ZONE_INFLOWS) {
		R7_FINANCIAL_FREE_ZONE_INFLOWS = r7_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR7_TOTAL_INFLOWS() {
		return R7_TOTAL_INFLOWS;
	}
	public void setR7_TOTAL_INFLOWS(BigDecimal r7_TOTAL_INFLOWS) {
		R7_TOTAL_INFLOWS = r7_TOTAL_INFLOWS;
	}
	public BigDecimal getR7_All_TRANSACTIONS_OUTFLOWS() {
		return R7_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR7_All_TRANSACTIONS_OUTFLOWS(BigDecimal r7_All_TRANSACTIONS_OUTFLOWS) {
		R7_All_TRANSACTIONS_OUTFLOWS = r7_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR7_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R7_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR7_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r7_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R7_FINANCIAL_FREE_ZONE_OUTFLOWS = r7_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR7_TOTAL_OUTFLOWS() {
		return R7_TOTAL_OUTFLOWS;
	}
	public void setR7_TOTAL_OUTFLOWS(BigDecimal r7_TOTAL_OUTFLOWS) {
		R7_TOTAL_OUTFLOWS = r7_TOTAL_OUTFLOWS;
	}
	public String getR8_S_NO() {
		return R8_S_NO;
	}
	public void setR8_S_NO(String r8_S_NO) {
		R8_S_NO = r8_S_NO;
	}
	public String getR8_SWIFT_PAYMENT() {
		return R8_SWIFT_PAYMENT;
	}
	public void setR8_SWIFT_PAYMENT(String r8_SWIFT_PAYMENT) {
		R8_SWIFT_PAYMENT = r8_SWIFT_PAYMENT;
	}
	public String getR8_DESCRIPTION() {
		return R8_DESCRIPTION;
	}
	public void setR8_DESCRIPTION(String r8_DESCRIPTION) {
		R8_DESCRIPTION = r8_DESCRIPTION;
	}
	public BigDecimal getR8_All_TRANSACTIONS_INFLOWS() {
		return R8_All_TRANSACTIONS_INFLOWS;
	}
	public void setR8_All_TRANSACTIONS_INFLOWS(BigDecimal r8_All_TRANSACTIONS_INFLOWS) {
		R8_All_TRANSACTIONS_INFLOWS = r8_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR8_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R8_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR8_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r8_FINANCIAL_FREE_ZONE_INFLOWS) {
		R8_FINANCIAL_FREE_ZONE_INFLOWS = r8_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR8_TOTAL_INFLOWS() {
		return R8_TOTAL_INFLOWS;
	}
	public void setR8_TOTAL_INFLOWS(BigDecimal r8_TOTAL_INFLOWS) {
		R8_TOTAL_INFLOWS = r8_TOTAL_INFLOWS;
	}
	public BigDecimal getR8_All_TRANSACTIONS_OUTFLOWS() {
		return R8_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR8_All_TRANSACTIONS_OUTFLOWS(BigDecimal r8_All_TRANSACTIONS_OUTFLOWS) {
		R8_All_TRANSACTIONS_OUTFLOWS = r8_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR8_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R8_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR8_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r8_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R8_FINANCIAL_FREE_ZONE_OUTFLOWS = r8_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR8_TOTAL_OUTFLOWS() {
		return R8_TOTAL_OUTFLOWS;
	}
	public void setR8_TOTAL_OUTFLOWS(BigDecimal r8_TOTAL_OUTFLOWS) {
		R8_TOTAL_OUTFLOWS = r8_TOTAL_OUTFLOWS;
	}
	public String getR9_S_NO() {
		return R9_S_NO;
	}
	public void setR9_S_NO(String r9_S_NO) {
		R9_S_NO = r9_S_NO;
	}
	public String getR9_SWIFT_PAYMENT() {
		return R9_SWIFT_PAYMENT;
	}
	public void setR9_SWIFT_PAYMENT(String r9_SWIFT_PAYMENT) {
		R9_SWIFT_PAYMENT = r9_SWIFT_PAYMENT;
	}
	public String getR9_DESCRIPTION() {
		return R9_DESCRIPTION;
	}
	public void setR9_DESCRIPTION(String r9_DESCRIPTION) {
		R9_DESCRIPTION = r9_DESCRIPTION;
	}
	public BigDecimal getR9_All_TRANSACTIONS_INFLOWS() {
		return R9_All_TRANSACTIONS_INFLOWS;
	}
	public void setR9_All_TRANSACTIONS_INFLOWS(BigDecimal r9_All_TRANSACTIONS_INFLOWS) {
		R9_All_TRANSACTIONS_INFLOWS = r9_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR9_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R9_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR9_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r9_FINANCIAL_FREE_ZONE_INFLOWS) {
		R9_FINANCIAL_FREE_ZONE_INFLOWS = r9_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR9_TOTAL_INFLOWS() {
		return R9_TOTAL_INFLOWS;
	}
	public void setR9_TOTAL_INFLOWS(BigDecimal r9_TOTAL_INFLOWS) {
		R9_TOTAL_INFLOWS = r9_TOTAL_INFLOWS;
	}
	public BigDecimal getR9_All_TRANSACTIONS_OUTFLOWS() {
		return R9_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR9_All_TRANSACTIONS_OUTFLOWS(BigDecimal r9_All_TRANSACTIONS_OUTFLOWS) {
		R9_All_TRANSACTIONS_OUTFLOWS = r9_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR9_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R9_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR9_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r9_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R9_FINANCIAL_FREE_ZONE_OUTFLOWS = r9_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR9_TOTAL_OUTFLOWS() {
		return R9_TOTAL_OUTFLOWS;
	}
	public void setR9_TOTAL_OUTFLOWS(BigDecimal r9_TOTAL_OUTFLOWS) {
		R9_TOTAL_OUTFLOWS = r9_TOTAL_OUTFLOWS;
	}
	public String getR10_S_NO() {
		return R10_S_NO;
	}
	public void setR10_S_NO(String r10_S_NO) {
		R10_S_NO = r10_S_NO;
	}
	public String getR10_SWIFT_PAYMENT() {
		return R10_SWIFT_PAYMENT;
	}
	public void setR10_SWIFT_PAYMENT(String r10_SWIFT_PAYMENT) {
		R10_SWIFT_PAYMENT = r10_SWIFT_PAYMENT;
	}
	public String getR10_DESCRIPTION() {
		return R10_DESCRIPTION;
	}
	public void setR10_DESCRIPTION(String r10_DESCRIPTION) {
		R10_DESCRIPTION = r10_DESCRIPTION;
	}
	public BigDecimal getR10_All_TRANSACTIONS_INFLOWS() {
		return R10_All_TRANSACTIONS_INFLOWS;
	}
	public void setR10_All_TRANSACTIONS_INFLOWS(BigDecimal r10_All_TRANSACTIONS_INFLOWS) {
		R10_All_TRANSACTIONS_INFLOWS = r10_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR10_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R10_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR10_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r10_FINANCIAL_FREE_ZONE_INFLOWS) {
		R10_FINANCIAL_FREE_ZONE_INFLOWS = r10_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR10_TOTAL_INFLOWS() {
		return R10_TOTAL_INFLOWS;
	}
	public void setR10_TOTAL_INFLOWS(BigDecimal r10_TOTAL_INFLOWS) {
		R10_TOTAL_INFLOWS = r10_TOTAL_INFLOWS;
	}
	public BigDecimal getR10_All_TRANSACTIONS_OUTFLOWS() {
		return R10_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR10_All_TRANSACTIONS_OUTFLOWS(BigDecimal r10_All_TRANSACTIONS_OUTFLOWS) {
		R10_All_TRANSACTIONS_OUTFLOWS = r10_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR10_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R10_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR10_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r10_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R10_FINANCIAL_FREE_ZONE_OUTFLOWS = r10_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR10_TOTAL_OUTFLOWS() {
		return R10_TOTAL_OUTFLOWS;
	}
	public void setR10_TOTAL_OUTFLOWS(BigDecimal r10_TOTAL_OUTFLOWS) {
		R10_TOTAL_OUTFLOWS = r10_TOTAL_OUTFLOWS;
	}
	public String getR11_S_NO() {
		return R11_S_NO;
	}
	public void setR11_S_NO(String r11_S_NO) {
		R11_S_NO = r11_S_NO;
	}
	public String getR11_SWIFT_PAYMENT() {
		return R11_SWIFT_PAYMENT;
	}
	public void setR11_SWIFT_PAYMENT(String r11_SWIFT_PAYMENT) {
		R11_SWIFT_PAYMENT = r11_SWIFT_PAYMENT;
	}
	public String getR11_DESCRIPTION() {
		return R11_DESCRIPTION;
	}
	public void setR11_DESCRIPTION(String r11_DESCRIPTION) {
		R11_DESCRIPTION = r11_DESCRIPTION;
	}
	public BigDecimal getR11_All_TRANSACTIONS_INFLOWS() {
		return R11_All_TRANSACTIONS_INFLOWS;
	}
	public void setR11_All_TRANSACTIONS_INFLOWS(BigDecimal r11_All_TRANSACTIONS_INFLOWS) {
		R11_All_TRANSACTIONS_INFLOWS = r11_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR11_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R11_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR11_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r11_FINANCIAL_FREE_ZONE_INFLOWS) {
		R11_FINANCIAL_FREE_ZONE_INFLOWS = r11_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR11_TOTAL_INFLOWS() {
		return R11_TOTAL_INFLOWS;
	}
	public void setR11_TOTAL_INFLOWS(BigDecimal r11_TOTAL_INFLOWS) {
		R11_TOTAL_INFLOWS = r11_TOTAL_INFLOWS;
	}
	public BigDecimal getR11_All_TRANSACTIONS_OUTFLOWS() {
		return R11_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR11_All_TRANSACTIONS_OUTFLOWS(BigDecimal r11_All_TRANSACTIONS_OUTFLOWS) {
		R11_All_TRANSACTIONS_OUTFLOWS = r11_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR11_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R11_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR11_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r11_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R11_FINANCIAL_FREE_ZONE_OUTFLOWS = r11_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR11_TOTAL_OUTFLOWS() {
		return R11_TOTAL_OUTFLOWS;
	}
	public void setR11_TOTAL_OUTFLOWS(BigDecimal r11_TOTAL_OUTFLOWS) {
		R11_TOTAL_OUTFLOWS = r11_TOTAL_OUTFLOWS;
	}
	public String getR12_S_NO() {
		return R12_S_NO;
	}
	public void setR12_S_NO(String r12_S_NO) {
		R12_S_NO = r12_S_NO;
	}
	public String getR12_SWIFT_PAYMENT() {
		return R12_SWIFT_PAYMENT;
	}
	public void setR12_SWIFT_PAYMENT(String r12_SWIFT_PAYMENT) {
		R12_SWIFT_PAYMENT = r12_SWIFT_PAYMENT;
	}
	public String getR12_DESCRIPTION() {
		return R12_DESCRIPTION;
	}
	public void setR12_DESCRIPTION(String r12_DESCRIPTION) {
		R12_DESCRIPTION = r12_DESCRIPTION;
	}
	public BigDecimal getR12_All_TRANSACTIONS_INFLOWS() {
		return R12_All_TRANSACTIONS_INFLOWS;
	}
	public void setR12_All_TRANSACTIONS_INFLOWS(BigDecimal r12_All_TRANSACTIONS_INFLOWS) {
		R12_All_TRANSACTIONS_INFLOWS = r12_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR12_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R12_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR12_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r12_FINANCIAL_FREE_ZONE_INFLOWS) {
		R12_FINANCIAL_FREE_ZONE_INFLOWS = r12_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR12_TOTAL_INFLOWS() {
		return R12_TOTAL_INFLOWS;
	}
	public void setR12_TOTAL_INFLOWS(BigDecimal r12_TOTAL_INFLOWS) {
		R12_TOTAL_INFLOWS = r12_TOTAL_INFLOWS;
	}
	public BigDecimal getR12_All_TRANSACTIONS_OUTFLOWS() {
		return R12_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR12_All_TRANSACTIONS_OUTFLOWS(BigDecimal r12_All_TRANSACTIONS_OUTFLOWS) {
		R12_All_TRANSACTIONS_OUTFLOWS = r12_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR12_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R12_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR12_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r12_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R12_FINANCIAL_FREE_ZONE_OUTFLOWS = r12_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR12_TOTAL_OUTFLOWS() {
		return R12_TOTAL_OUTFLOWS;
	}
	public void setR12_TOTAL_OUTFLOWS(BigDecimal r12_TOTAL_OUTFLOWS) {
		R12_TOTAL_OUTFLOWS = r12_TOTAL_OUTFLOWS;
	}
	public String getR13_S_NO() {
		return R13_S_NO;
	}
	public void setR13_S_NO(String r13_S_NO) {
		R13_S_NO = r13_S_NO;
	}
	public String getR13_SWIFT_PAYMENT() {
		return R13_SWIFT_PAYMENT;
	}
	public void setR13_SWIFT_PAYMENT(String r13_SWIFT_PAYMENT) {
		R13_SWIFT_PAYMENT = r13_SWIFT_PAYMENT;
	}
	public String getR13_DESCRIPTION() {
		return R13_DESCRIPTION;
	}
	public void setR13_DESCRIPTION(String r13_DESCRIPTION) {
		R13_DESCRIPTION = r13_DESCRIPTION;
	}
	public BigDecimal getR13_All_TRANSACTIONS_INFLOWS() {
		return R13_All_TRANSACTIONS_INFLOWS;
	}
	public void setR13_All_TRANSACTIONS_INFLOWS(BigDecimal r13_All_TRANSACTIONS_INFLOWS) {
		R13_All_TRANSACTIONS_INFLOWS = r13_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR13_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R13_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR13_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r13_FINANCIAL_FREE_ZONE_INFLOWS) {
		R13_FINANCIAL_FREE_ZONE_INFLOWS = r13_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR13_TOTAL_INFLOWS() {
		return R13_TOTAL_INFLOWS;
	}
	public void setR13_TOTAL_INFLOWS(BigDecimal r13_TOTAL_INFLOWS) {
		R13_TOTAL_INFLOWS = r13_TOTAL_INFLOWS;
	}
	public BigDecimal getR13_All_TRANSACTIONS_OUTFLOWS() {
		return R13_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR13_All_TRANSACTIONS_OUTFLOWS(BigDecimal r13_All_TRANSACTIONS_OUTFLOWS) {
		R13_All_TRANSACTIONS_OUTFLOWS = r13_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR13_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R13_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR13_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r13_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R13_FINANCIAL_FREE_ZONE_OUTFLOWS = r13_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR13_TOTAL_OUTFLOWS() {
		return R13_TOTAL_OUTFLOWS;
	}
	public void setR13_TOTAL_OUTFLOWS(BigDecimal r13_TOTAL_OUTFLOWS) {
		R13_TOTAL_OUTFLOWS = r13_TOTAL_OUTFLOWS;
	}
	public String getR14_S_NO() {
		return R14_S_NO;
	}
	public void setR14_S_NO(String r14_S_NO) {
		R14_S_NO = r14_S_NO;
	}
	public String getR14_SWIFT_PAYMENT() {
		return R14_SWIFT_PAYMENT;
	}
	public void setR14_SWIFT_PAYMENT(String r14_SWIFT_PAYMENT) {
		R14_SWIFT_PAYMENT = r14_SWIFT_PAYMENT;
	}
	public String getR14_DESCRIPTION() {
		return R14_DESCRIPTION;
	}
	public void setR14_DESCRIPTION(String r14_DESCRIPTION) {
		R14_DESCRIPTION = r14_DESCRIPTION;
	}
	public BigDecimal getR14_All_TRANSACTIONS_INFLOWS() {
		return R14_All_TRANSACTIONS_INFLOWS;
	}
	public void setR14_All_TRANSACTIONS_INFLOWS(BigDecimal r14_All_TRANSACTIONS_INFLOWS) {
		R14_All_TRANSACTIONS_INFLOWS = r14_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR14_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R14_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR14_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r14_FINANCIAL_FREE_ZONE_INFLOWS) {
		R14_FINANCIAL_FREE_ZONE_INFLOWS = r14_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR14_TOTAL_INFLOWS() {
		return R14_TOTAL_INFLOWS;
	}
	public void setR14_TOTAL_INFLOWS(BigDecimal r14_TOTAL_INFLOWS) {
		R14_TOTAL_INFLOWS = r14_TOTAL_INFLOWS;
	}
	public BigDecimal getR14_All_TRANSACTIONS_OUTFLOWS() {
		return R14_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR14_All_TRANSACTIONS_OUTFLOWS(BigDecimal r14_All_TRANSACTIONS_OUTFLOWS) {
		R14_All_TRANSACTIONS_OUTFLOWS = r14_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR14_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R14_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR14_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r14_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R14_FINANCIAL_FREE_ZONE_OUTFLOWS = r14_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR14_TOTAL_OUTFLOWS() {
		return R14_TOTAL_OUTFLOWS;
	}
	public void setR14_TOTAL_OUTFLOWS(BigDecimal r14_TOTAL_OUTFLOWS) {
		R14_TOTAL_OUTFLOWS = r14_TOTAL_OUTFLOWS;
	}
	public String getR15_S_NO() {
		return R15_S_NO;
	}
	public void setR15_S_NO(String r15_S_NO) {
		R15_S_NO = r15_S_NO;
	}
	public String getR15_SWIFT_PAYMENT() {
		return R15_SWIFT_PAYMENT;
	}
	public void setR15_SWIFT_PAYMENT(String r15_SWIFT_PAYMENT) {
		R15_SWIFT_PAYMENT = r15_SWIFT_PAYMENT;
	}
	public String getR15_DESCRIPTION() {
		return R15_DESCRIPTION;
	}
	public void setR15_DESCRIPTION(String r15_DESCRIPTION) {
		R15_DESCRIPTION = r15_DESCRIPTION;
	}
	public BigDecimal getR15_All_TRANSACTIONS_INFLOWS() {
		return R15_All_TRANSACTIONS_INFLOWS;
	}
	public void setR15_All_TRANSACTIONS_INFLOWS(BigDecimal r15_All_TRANSACTIONS_INFLOWS) {
		R15_All_TRANSACTIONS_INFLOWS = r15_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR15_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R15_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR15_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r15_FINANCIAL_FREE_ZONE_INFLOWS) {
		R15_FINANCIAL_FREE_ZONE_INFLOWS = r15_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR15_TOTAL_INFLOWS() {
		return R15_TOTAL_INFLOWS;
	}
	public void setR15_TOTAL_INFLOWS(BigDecimal r15_TOTAL_INFLOWS) {
		R15_TOTAL_INFLOWS = r15_TOTAL_INFLOWS;
	}
	public BigDecimal getR15_All_TRANSACTIONS_OUTFLOWS() {
		return R15_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR15_All_TRANSACTIONS_OUTFLOWS(BigDecimal r15_All_TRANSACTIONS_OUTFLOWS) {
		R15_All_TRANSACTIONS_OUTFLOWS = r15_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR15_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R15_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR15_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r15_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R15_FINANCIAL_FREE_ZONE_OUTFLOWS = r15_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR15_TOTAL_OUTFLOWS() {
		return R15_TOTAL_OUTFLOWS;
	}
	public void setR15_TOTAL_OUTFLOWS(BigDecimal r15_TOTAL_OUTFLOWS) {
		R15_TOTAL_OUTFLOWS = r15_TOTAL_OUTFLOWS;
	}
	public String getR16_S_NO() {
		return R16_S_NO;
	}
	public void setR16_S_NO(String r16_S_NO) {
		R16_S_NO = r16_S_NO;
	}
	public String getR16_SWIFT_PAYMENT() {
		return R16_SWIFT_PAYMENT;
	}
	public void setR16_SWIFT_PAYMENT(String r16_SWIFT_PAYMENT) {
		R16_SWIFT_PAYMENT = r16_SWIFT_PAYMENT;
	}
	public String getR16_DESCRIPTION() {
		return R16_DESCRIPTION;
	}
	public void setR16_DESCRIPTION(String r16_DESCRIPTION) {
		R16_DESCRIPTION = r16_DESCRIPTION;
	}
	public BigDecimal getR16_All_TRANSACTIONS_INFLOWS() {
		return R16_All_TRANSACTIONS_INFLOWS;
	}
	public void setR16_All_TRANSACTIONS_INFLOWS(BigDecimal r16_All_TRANSACTIONS_INFLOWS) {
		R16_All_TRANSACTIONS_INFLOWS = r16_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR16_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R16_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR16_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r16_FINANCIAL_FREE_ZONE_INFLOWS) {
		R16_FINANCIAL_FREE_ZONE_INFLOWS = r16_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR16_TOTAL_INFLOWS() {
		return R16_TOTAL_INFLOWS;
	}
	public void setR16_TOTAL_INFLOWS(BigDecimal r16_TOTAL_INFLOWS) {
		R16_TOTAL_INFLOWS = r16_TOTAL_INFLOWS;
	}
	public BigDecimal getR16_All_TRANSACTIONS_OUTFLOWS() {
		return R16_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR16_All_TRANSACTIONS_OUTFLOWS(BigDecimal r16_All_TRANSACTIONS_OUTFLOWS) {
		R16_All_TRANSACTIONS_OUTFLOWS = r16_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR16_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R16_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR16_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r16_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R16_FINANCIAL_FREE_ZONE_OUTFLOWS = r16_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR16_TOTAL_OUTFLOWS() {
		return R16_TOTAL_OUTFLOWS;
	}
	public void setR16_TOTAL_OUTFLOWS(BigDecimal r16_TOTAL_OUTFLOWS) {
		R16_TOTAL_OUTFLOWS = r16_TOTAL_OUTFLOWS;
	}
	public String getR17_S_NO() {
		return R17_S_NO;
	}
	public void setR17_S_NO(String r17_S_NO) {
		R17_S_NO = r17_S_NO;
	}
	public String getR17_SWIFT_PAYMENT() {
		return R17_SWIFT_PAYMENT;
	}
	public void setR17_SWIFT_PAYMENT(String r17_SWIFT_PAYMENT) {
		R17_SWIFT_PAYMENT = r17_SWIFT_PAYMENT;
	}
	public String getR17_DESCRIPTION() {
		return R17_DESCRIPTION;
	}
	public void setR17_DESCRIPTION(String r17_DESCRIPTION) {
		R17_DESCRIPTION = r17_DESCRIPTION;
	}
	public BigDecimal getR17_All_TRANSACTIONS_INFLOWS() {
		return R17_All_TRANSACTIONS_INFLOWS;
	}
	public void setR17_All_TRANSACTIONS_INFLOWS(BigDecimal r17_All_TRANSACTIONS_INFLOWS) {
		R17_All_TRANSACTIONS_INFLOWS = r17_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR17_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R17_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR17_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r17_FINANCIAL_FREE_ZONE_INFLOWS) {
		R17_FINANCIAL_FREE_ZONE_INFLOWS = r17_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR17_TOTAL_INFLOWS() {
		return R17_TOTAL_INFLOWS;
	}
	public void setR17_TOTAL_INFLOWS(BigDecimal r17_TOTAL_INFLOWS) {
		R17_TOTAL_INFLOWS = r17_TOTAL_INFLOWS;
	}
	public BigDecimal getR17_All_TRANSACTIONS_OUTFLOWS() {
		return R17_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR17_All_TRANSACTIONS_OUTFLOWS(BigDecimal r17_All_TRANSACTIONS_OUTFLOWS) {
		R17_All_TRANSACTIONS_OUTFLOWS = r17_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR17_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R17_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR17_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r17_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R17_FINANCIAL_FREE_ZONE_OUTFLOWS = r17_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR17_TOTAL_OUTFLOWS() {
		return R17_TOTAL_OUTFLOWS;
	}
	public void setR17_TOTAL_OUTFLOWS(BigDecimal r17_TOTAL_OUTFLOWS) {
		R17_TOTAL_OUTFLOWS = r17_TOTAL_OUTFLOWS;
	}
	public String getR18_S_NO() {
		return R18_S_NO;
	}
	public void setR18_S_NO(String r18_S_NO) {
		R18_S_NO = r18_S_NO;
	}
	public String getR18_SWIFT_PAYMENT() {
		return R18_SWIFT_PAYMENT;
	}
	public void setR18_SWIFT_PAYMENT(String r18_SWIFT_PAYMENT) {
		R18_SWIFT_PAYMENT = r18_SWIFT_PAYMENT;
	}
	public String getR18_DESCRIPTION() {
		return R18_DESCRIPTION;
	}
	public void setR18_DESCRIPTION(String r18_DESCRIPTION) {
		R18_DESCRIPTION = r18_DESCRIPTION;
	}
	public BigDecimal getR18_All_TRANSACTIONS_INFLOWS() {
		return R18_All_TRANSACTIONS_INFLOWS;
	}
	public void setR18_All_TRANSACTIONS_INFLOWS(BigDecimal r18_All_TRANSACTIONS_INFLOWS) {
		R18_All_TRANSACTIONS_INFLOWS = r18_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR18_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R18_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR18_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r18_FINANCIAL_FREE_ZONE_INFLOWS) {
		R18_FINANCIAL_FREE_ZONE_INFLOWS = r18_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR18_TOTAL_INFLOWS() {
		return R18_TOTAL_INFLOWS;
	}
	public void setR18_TOTAL_INFLOWS(BigDecimal r18_TOTAL_INFLOWS) {
		R18_TOTAL_INFLOWS = r18_TOTAL_INFLOWS;
	}
	public BigDecimal getR18_All_TRANSACTIONS_OUTFLOWS() {
		return R18_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR18_All_TRANSACTIONS_OUTFLOWS(BigDecimal r18_All_TRANSACTIONS_OUTFLOWS) {
		R18_All_TRANSACTIONS_OUTFLOWS = r18_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR18_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R18_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR18_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r18_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R18_FINANCIAL_FREE_ZONE_OUTFLOWS = r18_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR18_TOTAL_OUTFLOWS() {
		return R18_TOTAL_OUTFLOWS;
	}
	public void setR18_TOTAL_OUTFLOWS(BigDecimal r18_TOTAL_OUTFLOWS) {
		R18_TOTAL_OUTFLOWS = r18_TOTAL_OUTFLOWS;
	}
	public String getR19_S_NO() {
		return R19_S_NO;
	}
	public void setR19_S_NO(String r19_S_NO) {
		R19_S_NO = r19_S_NO;
	}
	public String getR19_SWIFT_PAYMENT() {
		return R19_SWIFT_PAYMENT;
	}
	public void setR19_SWIFT_PAYMENT(String r19_SWIFT_PAYMENT) {
		R19_SWIFT_PAYMENT = r19_SWIFT_PAYMENT;
	}
	public String getR19_DESCRIPTION() {
		return R19_DESCRIPTION;
	}
	public void setR19_DESCRIPTION(String r19_DESCRIPTION) {
		R19_DESCRIPTION = r19_DESCRIPTION;
	}
	public BigDecimal getR19_All_TRANSACTIONS_INFLOWS() {
		return R19_All_TRANSACTIONS_INFLOWS;
	}
	public void setR19_All_TRANSACTIONS_INFLOWS(BigDecimal r19_All_TRANSACTIONS_INFLOWS) {
		R19_All_TRANSACTIONS_INFLOWS = r19_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR19_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R19_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR19_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r19_FINANCIAL_FREE_ZONE_INFLOWS) {
		R19_FINANCIAL_FREE_ZONE_INFLOWS = r19_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR19_TOTAL_INFLOWS() {
		return R19_TOTAL_INFLOWS;
	}
	public void setR19_TOTAL_INFLOWS(BigDecimal r19_TOTAL_INFLOWS) {
		R19_TOTAL_INFLOWS = r19_TOTAL_INFLOWS;
	}
	public BigDecimal getR19_All_TRANSACTIONS_OUTFLOWS() {
		return R19_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR19_All_TRANSACTIONS_OUTFLOWS(BigDecimal r19_All_TRANSACTIONS_OUTFLOWS) {
		R19_All_TRANSACTIONS_OUTFLOWS = r19_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR19_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R19_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR19_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r19_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R19_FINANCIAL_FREE_ZONE_OUTFLOWS = r19_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR19_TOTAL_OUTFLOWS() {
		return R19_TOTAL_OUTFLOWS;
	}
	public void setR19_TOTAL_OUTFLOWS(BigDecimal r19_TOTAL_OUTFLOWS) {
		R19_TOTAL_OUTFLOWS = r19_TOTAL_OUTFLOWS;
	}
	public String getR20_S_NO() {
		return R20_S_NO;
	}
	public void setR20_S_NO(String r20_S_NO) {
		R20_S_NO = r20_S_NO;
	}
	public String getR20_SWIFT_PAYMENT() {
		return R20_SWIFT_PAYMENT;
	}
	public void setR20_SWIFT_PAYMENT(String r20_SWIFT_PAYMENT) {
		R20_SWIFT_PAYMENT = r20_SWIFT_PAYMENT;
	}
	public String getR20_DESCRIPTION() {
		return R20_DESCRIPTION;
	}
	public void setR20_DESCRIPTION(String r20_DESCRIPTION) {
		R20_DESCRIPTION = r20_DESCRIPTION;
	}
	public BigDecimal getR20_All_TRANSACTIONS_INFLOWS() {
		return R20_All_TRANSACTIONS_INFLOWS;
	}
	public void setR20_All_TRANSACTIONS_INFLOWS(BigDecimal r20_All_TRANSACTIONS_INFLOWS) {
		R20_All_TRANSACTIONS_INFLOWS = r20_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR20_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R20_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR20_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r20_FINANCIAL_FREE_ZONE_INFLOWS) {
		R20_FINANCIAL_FREE_ZONE_INFLOWS = r20_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR20_TOTAL_INFLOWS() {
		return R20_TOTAL_INFLOWS;
	}
	public void setR20_TOTAL_INFLOWS(BigDecimal r20_TOTAL_INFLOWS) {
		R20_TOTAL_INFLOWS = r20_TOTAL_INFLOWS;
	}
	public BigDecimal getR20_All_TRANSACTIONS_OUTFLOWS() {
		return R20_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR20_All_TRANSACTIONS_OUTFLOWS(BigDecimal r20_All_TRANSACTIONS_OUTFLOWS) {
		R20_All_TRANSACTIONS_OUTFLOWS = r20_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR20_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R20_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR20_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r20_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R20_FINANCIAL_FREE_ZONE_OUTFLOWS = r20_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR20_TOTAL_OUTFLOWS() {
		return R20_TOTAL_OUTFLOWS;
	}
	public void setR20_TOTAL_OUTFLOWS(BigDecimal r20_TOTAL_OUTFLOWS) {
		R20_TOTAL_OUTFLOWS = r20_TOTAL_OUTFLOWS;
	}
	public String getR21_S_NO() {
		return R21_S_NO;
	}
	public void setR21_S_NO(String r21_S_NO) {
		R21_S_NO = r21_S_NO;
	}
	public String getR21_SWIFT_PAYMENT() {
		return R21_SWIFT_PAYMENT;
	}
	public void setR21_SWIFT_PAYMENT(String r21_SWIFT_PAYMENT) {
		R21_SWIFT_PAYMENT = r21_SWIFT_PAYMENT;
	}
	public String getR21_DESCRIPTION() {
		return R21_DESCRIPTION;
	}
	public void setR21_DESCRIPTION(String r21_DESCRIPTION) {
		R21_DESCRIPTION = r21_DESCRIPTION;
	}
	public BigDecimal getR21_All_TRANSACTIONS_INFLOWS() {
		return R21_All_TRANSACTIONS_INFLOWS;
	}
	public void setR21_All_TRANSACTIONS_INFLOWS(BigDecimal r21_All_TRANSACTIONS_INFLOWS) {
		R21_All_TRANSACTIONS_INFLOWS = r21_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR21_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R21_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR21_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r21_FINANCIAL_FREE_ZONE_INFLOWS) {
		R21_FINANCIAL_FREE_ZONE_INFLOWS = r21_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR21_TOTAL_INFLOWS() {
		return R21_TOTAL_INFLOWS;
	}
	public void setR21_TOTAL_INFLOWS(BigDecimal r21_TOTAL_INFLOWS) {
		R21_TOTAL_INFLOWS = r21_TOTAL_INFLOWS;
	}
	public BigDecimal getR21_All_TRANSACTIONS_OUTFLOWS() {
		return R21_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR21_All_TRANSACTIONS_OUTFLOWS(BigDecimal r21_All_TRANSACTIONS_OUTFLOWS) {
		R21_All_TRANSACTIONS_OUTFLOWS = r21_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR21_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R21_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR21_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r21_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R21_FINANCIAL_FREE_ZONE_OUTFLOWS = r21_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR21_TOTAL_OUTFLOWS() {
		return R21_TOTAL_OUTFLOWS;
	}
	public void setR21_TOTAL_OUTFLOWS(BigDecimal r21_TOTAL_OUTFLOWS) {
		R21_TOTAL_OUTFLOWS = r21_TOTAL_OUTFLOWS;
	}
	public String getR22_S_NO() {
		return R22_S_NO;
	}
	public void setR22_S_NO(String r22_S_NO) {
		R22_S_NO = r22_S_NO;
	}
	public String getR22_SWIFT_PAYMENT() {
		return R22_SWIFT_PAYMENT;
	}
	public void setR22_SWIFT_PAYMENT(String r22_SWIFT_PAYMENT) {
		R22_SWIFT_PAYMENT = r22_SWIFT_PAYMENT;
	}
	public String getR22_DESCRIPTION() {
		return R22_DESCRIPTION;
	}
	public void setR22_DESCRIPTION(String r22_DESCRIPTION) {
		R22_DESCRIPTION = r22_DESCRIPTION;
	}
	public BigDecimal getR22_All_TRANSACTIONS_INFLOWS() {
		return R22_All_TRANSACTIONS_INFLOWS;
	}
	public void setR22_All_TRANSACTIONS_INFLOWS(BigDecimal r22_All_TRANSACTIONS_INFLOWS) {
		R22_All_TRANSACTIONS_INFLOWS = r22_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR22_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R22_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR22_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r22_FINANCIAL_FREE_ZONE_INFLOWS) {
		R22_FINANCIAL_FREE_ZONE_INFLOWS = r22_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR22_TOTAL_INFLOWS() {
		return R22_TOTAL_INFLOWS;
	}
	public void setR22_TOTAL_INFLOWS(BigDecimal r22_TOTAL_INFLOWS) {
		R22_TOTAL_INFLOWS = r22_TOTAL_INFLOWS;
	}
	public BigDecimal getR22_All_TRANSACTIONS_OUTFLOWS() {
		return R22_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR22_All_TRANSACTIONS_OUTFLOWS(BigDecimal r22_All_TRANSACTIONS_OUTFLOWS) {
		R22_All_TRANSACTIONS_OUTFLOWS = r22_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR22_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R22_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR22_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r22_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R22_FINANCIAL_FREE_ZONE_OUTFLOWS = r22_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR22_TOTAL_OUTFLOWS() {
		return R22_TOTAL_OUTFLOWS;
	}
	public void setR22_TOTAL_OUTFLOWS(BigDecimal r22_TOTAL_OUTFLOWS) {
		R22_TOTAL_OUTFLOWS = r22_TOTAL_OUTFLOWS;
	}
	public String getR23_S_NO() {
		return R23_S_NO;
	}
	public void setR23_S_NO(String r23_S_NO) {
		R23_S_NO = r23_S_NO;
	}
	public String getR23_SWIFT_PAYMENT() {
		return R23_SWIFT_PAYMENT;
	}
	public void setR23_SWIFT_PAYMENT(String r23_SWIFT_PAYMENT) {
		R23_SWIFT_PAYMENT = r23_SWIFT_PAYMENT;
	}
	public String getR23_DESCRIPTION() {
		return R23_DESCRIPTION;
	}
	public void setR23_DESCRIPTION(String r23_DESCRIPTION) {
		R23_DESCRIPTION = r23_DESCRIPTION;
	}
	public BigDecimal getR23_All_TRANSACTIONS_INFLOWS() {
		return R23_All_TRANSACTIONS_INFLOWS;
	}
	public void setR23_All_TRANSACTIONS_INFLOWS(BigDecimal r23_All_TRANSACTIONS_INFLOWS) {
		R23_All_TRANSACTIONS_INFLOWS = r23_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR23_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R23_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR23_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r23_FINANCIAL_FREE_ZONE_INFLOWS) {
		R23_FINANCIAL_FREE_ZONE_INFLOWS = r23_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR23_TOTAL_INFLOWS() {
		return R23_TOTAL_INFLOWS;
	}
	public void setR23_TOTAL_INFLOWS(BigDecimal r23_TOTAL_INFLOWS) {
		R23_TOTAL_INFLOWS = r23_TOTAL_INFLOWS;
	}
	public BigDecimal getR23_All_TRANSACTIONS_OUTFLOWS() {
		return R23_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR23_All_TRANSACTIONS_OUTFLOWS(BigDecimal r23_All_TRANSACTIONS_OUTFLOWS) {
		R23_All_TRANSACTIONS_OUTFLOWS = r23_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR23_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R23_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR23_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r23_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R23_FINANCIAL_FREE_ZONE_OUTFLOWS = r23_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR23_TOTAL_OUTFLOWS() {
		return R23_TOTAL_OUTFLOWS;
	}
	public void setR23_TOTAL_OUTFLOWS(BigDecimal r23_TOTAL_OUTFLOWS) {
		R23_TOTAL_OUTFLOWS = r23_TOTAL_OUTFLOWS;
	}
	public String getR24_S_NO() {
		return R24_S_NO;
	}
	public void setR24_S_NO(String r24_S_NO) {
		R24_S_NO = r24_S_NO;
	}
	public String getR24_SWIFT_PAYMENT() {
		return R24_SWIFT_PAYMENT;
	}
	public void setR24_SWIFT_PAYMENT(String r24_SWIFT_PAYMENT) {
		R24_SWIFT_PAYMENT = r24_SWIFT_PAYMENT;
	}
	public String getR24_DESCRIPTION() {
		return R24_DESCRIPTION;
	}
	public void setR24_DESCRIPTION(String r24_DESCRIPTION) {
		R24_DESCRIPTION = r24_DESCRIPTION;
	}
	public BigDecimal getR24_All_TRANSACTIONS_INFLOWS() {
		return R24_All_TRANSACTIONS_INFLOWS;
	}
	public void setR24_All_TRANSACTIONS_INFLOWS(BigDecimal r24_All_TRANSACTIONS_INFLOWS) {
		R24_All_TRANSACTIONS_INFLOWS = r24_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR24_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R24_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR24_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r24_FINANCIAL_FREE_ZONE_INFLOWS) {
		R24_FINANCIAL_FREE_ZONE_INFLOWS = r24_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR24_TOTAL_INFLOWS() {
		return R24_TOTAL_INFLOWS;
	}
	public void setR24_TOTAL_INFLOWS(BigDecimal r24_TOTAL_INFLOWS) {
		R24_TOTAL_INFLOWS = r24_TOTAL_INFLOWS;
	}
	public BigDecimal getR24_All_TRANSACTIONS_OUTFLOWS() {
		return R24_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR24_All_TRANSACTIONS_OUTFLOWS(BigDecimal r24_All_TRANSACTIONS_OUTFLOWS) {
		R24_All_TRANSACTIONS_OUTFLOWS = r24_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR24_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R24_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR24_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r24_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R24_FINANCIAL_FREE_ZONE_OUTFLOWS = r24_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR24_TOTAL_OUTFLOWS() {
		return R24_TOTAL_OUTFLOWS;
	}
	public void setR24_TOTAL_OUTFLOWS(BigDecimal r24_TOTAL_OUTFLOWS) {
		R24_TOTAL_OUTFLOWS = r24_TOTAL_OUTFLOWS;
	}
	public String getR25_S_NO() {
		return R25_S_NO;
	}
	public void setR25_S_NO(String r25_S_NO) {
		R25_S_NO = r25_S_NO;
	}
	public String getR25_SWIFT_PAYMENT() {
		return R25_SWIFT_PAYMENT;
	}
	public void setR25_SWIFT_PAYMENT(String r25_SWIFT_PAYMENT) {
		R25_SWIFT_PAYMENT = r25_SWIFT_PAYMENT;
	}
	public String getR25_DESCRIPTION() {
		return R25_DESCRIPTION;
	}
	public void setR25_DESCRIPTION(String r25_DESCRIPTION) {
		R25_DESCRIPTION = r25_DESCRIPTION;
	}
	public BigDecimal getR25_All_TRANSACTIONS_INFLOWS() {
		return R25_All_TRANSACTIONS_INFLOWS;
	}
	public void setR25_All_TRANSACTIONS_INFLOWS(BigDecimal r25_All_TRANSACTIONS_INFLOWS) {
		R25_All_TRANSACTIONS_INFLOWS = r25_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR25_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R25_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR25_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r25_FINANCIAL_FREE_ZONE_INFLOWS) {
		R25_FINANCIAL_FREE_ZONE_INFLOWS = r25_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR25_TOTAL_INFLOWS() {
		return R25_TOTAL_INFLOWS;
	}
	public void setR25_TOTAL_INFLOWS(BigDecimal r25_TOTAL_INFLOWS) {
		R25_TOTAL_INFLOWS = r25_TOTAL_INFLOWS;
	}
	public BigDecimal getR25_All_TRANSACTIONS_OUTFLOWS() {
		return R25_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR25_All_TRANSACTIONS_OUTFLOWS(BigDecimal r25_All_TRANSACTIONS_OUTFLOWS) {
		R25_All_TRANSACTIONS_OUTFLOWS = r25_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR25_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R25_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR25_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r25_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R25_FINANCIAL_FREE_ZONE_OUTFLOWS = r25_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR25_TOTAL_OUTFLOWS() {
		return R25_TOTAL_OUTFLOWS;
	}
	public void setR25_TOTAL_OUTFLOWS(BigDecimal r25_TOTAL_OUTFLOWS) {
		R25_TOTAL_OUTFLOWS = r25_TOTAL_OUTFLOWS;
	}
	public String getR26_S_NO() {
		return R26_S_NO;
	}
	public void setR26_S_NO(String r26_S_NO) {
		R26_S_NO = r26_S_NO;
	}
	public String getR26_SWIFT_PAYMENT() {
		return R26_SWIFT_PAYMENT;
	}
	public void setR26_SWIFT_PAYMENT(String r26_SWIFT_PAYMENT) {
		R26_SWIFT_PAYMENT = r26_SWIFT_PAYMENT;
	}
	public String getR26_DESCRIPTION() {
		return R26_DESCRIPTION;
	}
	public void setR26_DESCRIPTION(String r26_DESCRIPTION) {
		R26_DESCRIPTION = r26_DESCRIPTION;
	}
	public BigDecimal getR26_All_TRANSACTIONS_INFLOWS() {
		return R26_All_TRANSACTIONS_INFLOWS;
	}
	public void setR26_All_TRANSACTIONS_INFLOWS(BigDecimal r26_All_TRANSACTIONS_INFLOWS) {
		R26_All_TRANSACTIONS_INFLOWS = r26_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR26_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R26_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR26_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r26_FINANCIAL_FREE_ZONE_INFLOWS) {
		R26_FINANCIAL_FREE_ZONE_INFLOWS = r26_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR26_TOTAL_INFLOWS() {
		return R26_TOTAL_INFLOWS;
	}
	public void setR26_TOTAL_INFLOWS(BigDecimal r26_TOTAL_INFLOWS) {
		R26_TOTAL_INFLOWS = r26_TOTAL_INFLOWS;
	}
	public BigDecimal getR26_All_TRANSACTIONS_OUTFLOWS() {
		return R26_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR26_All_TRANSACTIONS_OUTFLOWS(BigDecimal r26_All_TRANSACTIONS_OUTFLOWS) {
		R26_All_TRANSACTIONS_OUTFLOWS = r26_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR26_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R26_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR26_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r26_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R26_FINANCIAL_FREE_ZONE_OUTFLOWS = r26_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR26_TOTAL_OUTFLOWS() {
		return R26_TOTAL_OUTFLOWS;
	}
	public void setR26_TOTAL_OUTFLOWS(BigDecimal r26_TOTAL_OUTFLOWS) {
		R26_TOTAL_OUTFLOWS = r26_TOTAL_OUTFLOWS;
	}
	public String getR27_S_NO() {
		return R27_S_NO;
	}
	public void setR27_S_NO(String r27_S_NO) {
		R27_S_NO = r27_S_NO;
	}
	public String getR27_SWIFT_PAYMENT() {
		return R27_SWIFT_PAYMENT;
	}
	public void setR27_SWIFT_PAYMENT(String r27_SWIFT_PAYMENT) {
		R27_SWIFT_PAYMENT = r27_SWIFT_PAYMENT;
	}
	public String getR27_DESCRIPTION() {
		return R27_DESCRIPTION;
	}
	public void setR27_DESCRIPTION(String r27_DESCRIPTION) {
		R27_DESCRIPTION = r27_DESCRIPTION;
	}
	public BigDecimal getR27_All_TRANSACTIONS_INFLOWS() {
		return R27_All_TRANSACTIONS_INFLOWS;
	}
	public void setR27_All_TRANSACTIONS_INFLOWS(BigDecimal r27_All_TRANSACTIONS_INFLOWS) {
		R27_All_TRANSACTIONS_INFLOWS = r27_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR27_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R27_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR27_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r27_FINANCIAL_FREE_ZONE_INFLOWS) {
		R27_FINANCIAL_FREE_ZONE_INFLOWS = r27_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR27_TOTAL_INFLOWS() {
		return R27_TOTAL_INFLOWS;
	}
	public void setR27_TOTAL_INFLOWS(BigDecimal r27_TOTAL_INFLOWS) {
		R27_TOTAL_INFLOWS = r27_TOTAL_INFLOWS;
	}
	public BigDecimal getR27_All_TRANSACTIONS_OUTFLOWS() {
		return R27_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR27_All_TRANSACTIONS_OUTFLOWS(BigDecimal r27_All_TRANSACTIONS_OUTFLOWS) {
		R27_All_TRANSACTIONS_OUTFLOWS = r27_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR27_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R27_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR27_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r27_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R27_FINANCIAL_FREE_ZONE_OUTFLOWS = r27_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR27_TOTAL_OUTFLOWS() {
		return R27_TOTAL_OUTFLOWS;
	}
	public void setR27_TOTAL_OUTFLOWS(BigDecimal r27_TOTAL_OUTFLOWS) {
		R27_TOTAL_OUTFLOWS = r27_TOTAL_OUTFLOWS;
	}
	public String getR28_S_NO() {
		return R28_S_NO;
	}
	public void setR28_S_NO(String r28_S_NO) {
		R28_S_NO = r28_S_NO;
	}
	public String getR28_SWIFT_PAYMENT() {
		return R28_SWIFT_PAYMENT;
	}
	public void setR28_SWIFT_PAYMENT(String r28_SWIFT_PAYMENT) {
		R28_SWIFT_PAYMENT = r28_SWIFT_PAYMENT;
	}
	public String getR28_DESCRIPTION() {
		return R28_DESCRIPTION;
	}
	public void setR28_DESCRIPTION(String r28_DESCRIPTION) {
		R28_DESCRIPTION = r28_DESCRIPTION;
	}
	public BigDecimal getR28_All_TRANSACTIONS_INFLOWS() {
		return R28_All_TRANSACTIONS_INFLOWS;
	}
	public void setR28_All_TRANSACTIONS_INFLOWS(BigDecimal r28_All_TRANSACTIONS_INFLOWS) {
		R28_All_TRANSACTIONS_INFLOWS = r28_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR28_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R28_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR28_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r28_FINANCIAL_FREE_ZONE_INFLOWS) {
		R28_FINANCIAL_FREE_ZONE_INFLOWS = r28_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR28_TOTAL_INFLOWS() {
		return R28_TOTAL_INFLOWS;
	}
	public void setR28_TOTAL_INFLOWS(BigDecimal r28_TOTAL_INFLOWS) {
		R28_TOTAL_INFLOWS = r28_TOTAL_INFLOWS;
	}
	public BigDecimal getR28_All_TRANSACTIONS_OUTFLOWS() {
		return R28_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR28_All_TRANSACTIONS_OUTFLOWS(BigDecimal r28_All_TRANSACTIONS_OUTFLOWS) {
		R28_All_TRANSACTIONS_OUTFLOWS = r28_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR28_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R28_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR28_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r28_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R28_FINANCIAL_FREE_ZONE_OUTFLOWS = r28_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR28_TOTAL_OUTFLOWS() {
		return R28_TOTAL_OUTFLOWS;
	}
	public void setR28_TOTAL_OUTFLOWS(BigDecimal r28_TOTAL_OUTFLOWS) {
		R28_TOTAL_OUTFLOWS = r28_TOTAL_OUTFLOWS;
	}
	public String getR29_S_NO() {
		return R29_S_NO;
	}
	public void setR29_S_NO(String r29_S_NO) {
		R29_S_NO = r29_S_NO;
	}
	public String getR29_SWIFT_PAYMENT() {
		return R29_SWIFT_PAYMENT;
	}
	public void setR29_SWIFT_PAYMENT(String r29_SWIFT_PAYMENT) {
		R29_SWIFT_PAYMENT = r29_SWIFT_PAYMENT;
	}
	public String getR29_DESCRIPTION() {
		return R29_DESCRIPTION;
	}
	public void setR29_DESCRIPTION(String r29_DESCRIPTION) {
		R29_DESCRIPTION = r29_DESCRIPTION;
	}
	public BigDecimal getR29_All_TRANSACTIONS_INFLOWS() {
		return R29_All_TRANSACTIONS_INFLOWS;
	}
	public void setR29_All_TRANSACTIONS_INFLOWS(BigDecimal r29_All_TRANSACTIONS_INFLOWS) {
		R29_All_TRANSACTIONS_INFLOWS = r29_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR29_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R29_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR29_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r29_FINANCIAL_FREE_ZONE_INFLOWS) {
		R29_FINANCIAL_FREE_ZONE_INFLOWS = r29_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR29_TOTAL_INFLOWS() {
		return R29_TOTAL_INFLOWS;
	}
	public void setR29_TOTAL_INFLOWS(BigDecimal r29_TOTAL_INFLOWS) {
		R29_TOTAL_INFLOWS = r29_TOTAL_INFLOWS;
	}
	public BigDecimal getR29_All_TRANSACTIONS_OUTFLOWS() {
		return R29_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR29_All_TRANSACTIONS_OUTFLOWS(BigDecimal r29_All_TRANSACTIONS_OUTFLOWS) {
		R29_All_TRANSACTIONS_OUTFLOWS = r29_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR29_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R29_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR29_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r29_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R29_FINANCIAL_FREE_ZONE_OUTFLOWS = r29_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR29_TOTAL_OUTFLOWS() {
		return R29_TOTAL_OUTFLOWS;
	}
	public void setR29_TOTAL_OUTFLOWS(BigDecimal r29_TOTAL_OUTFLOWS) {
		R29_TOTAL_OUTFLOWS = r29_TOTAL_OUTFLOWS;
	}
	public String getR30_S_NO() {
		return R30_S_NO;
	}
	public void setR30_S_NO(String r30_S_NO) {
		R30_S_NO = r30_S_NO;
	}
	public String getR30_SWIFT_PAYMENT() {
		return R30_SWIFT_PAYMENT;
	}
	public void setR30_SWIFT_PAYMENT(String r30_SWIFT_PAYMENT) {
		R30_SWIFT_PAYMENT = r30_SWIFT_PAYMENT;
	}
	public String getR30_DESCRIPTION() {
		return R30_DESCRIPTION;
	}
	public void setR30_DESCRIPTION(String r30_DESCRIPTION) {
		R30_DESCRIPTION = r30_DESCRIPTION;
	}
	public BigDecimal getR30_All_TRANSACTIONS_INFLOWS() {
		return R30_All_TRANSACTIONS_INFLOWS;
	}
	public void setR30_All_TRANSACTIONS_INFLOWS(BigDecimal r30_All_TRANSACTIONS_INFLOWS) {
		R30_All_TRANSACTIONS_INFLOWS = r30_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR30_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R30_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR30_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r30_FINANCIAL_FREE_ZONE_INFLOWS) {
		R30_FINANCIAL_FREE_ZONE_INFLOWS = r30_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR30_TOTAL_INFLOWS() {
		return R30_TOTAL_INFLOWS;
	}
	public void setR30_TOTAL_INFLOWS(BigDecimal r30_TOTAL_INFLOWS) {
		R30_TOTAL_INFLOWS = r30_TOTAL_INFLOWS;
	}
	public BigDecimal getR30_All_TRANSACTIONS_OUTFLOWS() {
		return R30_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR30_All_TRANSACTIONS_OUTFLOWS(BigDecimal r30_All_TRANSACTIONS_OUTFLOWS) {
		R30_All_TRANSACTIONS_OUTFLOWS = r30_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR30_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R30_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR30_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r30_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R30_FINANCIAL_FREE_ZONE_OUTFLOWS = r30_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR30_TOTAL_OUTFLOWS() {
		return R30_TOTAL_OUTFLOWS;
	}
	public void setR30_TOTAL_OUTFLOWS(BigDecimal r30_TOTAL_OUTFLOWS) {
		R30_TOTAL_OUTFLOWS = r30_TOTAL_OUTFLOWS;
	}
	public String getR31_S_NO() {
		return R31_S_NO;
	}
	public void setR31_S_NO(String r31_S_NO) {
		R31_S_NO = r31_S_NO;
	}
	public String getR31_SWIFT_PAYMENT() {
		return R31_SWIFT_PAYMENT;
	}
	public void setR31_SWIFT_PAYMENT(String r31_SWIFT_PAYMENT) {
		R31_SWIFT_PAYMENT = r31_SWIFT_PAYMENT;
	}
	public String getR31_DESCRIPTION() {
		return R31_DESCRIPTION;
	}
	public void setR31_DESCRIPTION(String r31_DESCRIPTION) {
		R31_DESCRIPTION = r31_DESCRIPTION;
	}
	public BigDecimal getR31_All_TRANSACTIONS_INFLOWS() {
		return R31_All_TRANSACTIONS_INFLOWS;
	}
	public void setR31_All_TRANSACTIONS_INFLOWS(BigDecimal r31_All_TRANSACTIONS_INFLOWS) {
		R31_All_TRANSACTIONS_INFLOWS = r31_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR31_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R31_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR31_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r31_FINANCIAL_FREE_ZONE_INFLOWS) {
		R31_FINANCIAL_FREE_ZONE_INFLOWS = r31_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR31_TOTAL_INFLOWS() {
		return R31_TOTAL_INFLOWS;
	}
	public void setR31_TOTAL_INFLOWS(BigDecimal r31_TOTAL_INFLOWS) {
		R31_TOTAL_INFLOWS = r31_TOTAL_INFLOWS;
	}
	public BigDecimal getR31_All_TRANSACTIONS_OUTFLOWS() {
		return R31_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR31_All_TRANSACTIONS_OUTFLOWS(BigDecimal r31_All_TRANSACTIONS_OUTFLOWS) {
		R31_All_TRANSACTIONS_OUTFLOWS = r31_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR31_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R31_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR31_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r31_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R31_FINANCIAL_FREE_ZONE_OUTFLOWS = r31_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR31_TOTAL_OUTFLOWS() {
		return R31_TOTAL_OUTFLOWS;
	}
	public void setR31_TOTAL_OUTFLOWS(BigDecimal r31_TOTAL_OUTFLOWS) {
		R31_TOTAL_OUTFLOWS = r31_TOTAL_OUTFLOWS;
	}
	public String getR32_S_NO() {
		return R32_S_NO;
	}
	public void setR32_S_NO(String r32_S_NO) {
		R32_S_NO = r32_S_NO;
	}
	public String getR32_SWIFT_PAYMENT() {
		return R32_SWIFT_PAYMENT;
	}
	public void setR32_SWIFT_PAYMENT(String r32_SWIFT_PAYMENT) {
		R32_SWIFT_PAYMENT = r32_SWIFT_PAYMENT;
	}
	public String getR32_DESCRIPTION() {
		return R32_DESCRIPTION;
	}
	public void setR32_DESCRIPTION(String r32_DESCRIPTION) {
		R32_DESCRIPTION = r32_DESCRIPTION;
	}
	public BigDecimal getR32_All_TRANSACTIONS_INFLOWS() {
		return R32_All_TRANSACTIONS_INFLOWS;
	}
	public void setR32_All_TRANSACTIONS_INFLOWS(BigDecimal r32_All_TRANSACTIONS_INFLOWS) {
		R32_All_TRANSACTIONS_INFLOWS = r32_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR32_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R32_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR32_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r32_FINANCIAL_FREE_ZONE_INFLOWS) {
		R32_FINANCIAL_FREE_ZONE_INFLOWS = r32_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR32_TOTAL_INFLOWS() {
		return R32_TOTAL_INFLOWS;
	}
	public void setR32_TOTAL_INFLOWS(BigDecimal r32_TOTAL_INFLOWS) {
		R32_TOTAL_INFLOWS = r32_TOTAL_INFLOWS;
	}
	public BigDecimal getR32_All_TRANSACTIONS_OUTFLOWS() {
		return R32_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR32_All_TRANSACTIONS_OUTFLOWS(BigDecimal r32_All_TRANSACTIONS_OUTFLOWS) {
		R32_All_TRANSACTIONS_OUTFLOWS = r32_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR32_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R32_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR32_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r32_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R32_FINANCIAL_FREE_ZONE_OUTFLOWS = r32_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR32_TOTAL_OUTFLOWS() {
		return R32_TOTAL_OUTFLOWS;
	}
	public void setR32_TOTAL_OUTFLOWS(BigDecimal r32_TOTAL_OUTFLOWS) {
		R32_TOTAL_OUTFLOWS = r32_TOTAL_OUTFLOWS;
	}
	public String getR33_S_NO() {
		return R33_S_NO;
	}
	public void setR33_S_NO(String r33_S_NO) {
		R33_S_NO = r33_S_NO;
	}
	public String getR33_SWIFT_PAYMENT() {
		return R33_SWIFT_PAYMENT;
	}
	public void setR33_SWIFT_PAYMENT(String r33_SWIFT_PAYMENT) {
		R33_SWIFT_PAYMENT = r33_SWIFT_PAYMENT;
	}
	public String getR33_DESCRIPTION() {
		return R33_DESCRIPTION;
	}
	public void setR33_DESCRIPTION(String r33_DESCRIPTION) {
		R33_DESCRIPTION = r33_DESCRIPTION;
	}
	public BigDecimal getR33_All_TRANSACTIONS_INFLOWS() {
		return R33_All_TRANSACTIONS_INFLOWS;
	}
	public void setR33_All_TRANSACTIONS_INFLOWS(BigDecimal r33_All_TRANSACTIONS_INFLOWS) {
		R33_All_TRANSACTIONS_INFLOWS = r33_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR33_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R33_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR33_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r33_FINANCIAL_FREE_ZONE_INFLOWS) {
		R33_FINANCIAL_FREE_ZONE_INFLOWS = r33_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR33_TOTAL_INFLOWS() {
		return R33_TOTAL_INFLOWS;
	}
	public void setR33_TOTAL_INFLOWS(BigDecimal r33_TOTAL_INFLOWS) {
		R33_TOTAL_INFLOWS = r33_TOTAL_INFLOWS;
	}
	public BigDecimal getR33_All_TRANSACTIONS_OUTFLOWS() {
		return R33_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR33_All_TRANSACTIONS_OUTFLOWS(BigDecimal r33_All_TRANSACTIONS_OUTFLOWS) {
		R33_All_TRANSACTIONS_OUTFLOWS = r33_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR33_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R33_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR33_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r33_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R33_FINANCIAL_FREE_ZONE_OUTFLOWS = r33_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR33_TOTAL_OUTFLOWS() {
		return R33_TOTAL_OUTFLOWS;
	}
	public void setR33_TOTAL_OUTFLOWS(BigDecimal r33_TOTAL_OUTFLOWS) {
		R33_TOTAL_OUTFLOWS = r33_TOTAL_OUTFLOWS;
	}
	public String getR34_S_NO() {
		return R34_S_NO;
	}
	public void setR34_S_NO(String r34_S_NO) {
		R34_S_NO = r34_S_NO;
	}
	public String getR34_SWIFT_PAYMENT() {
		return R34_SWIFT_PAYMENT;
	}
	public void setR34_SWIFT_PAYMENT(String r34_SWIFT_PAYMENT) {
		R34_SWIFT_PAYMENT = r34_SWIFT_PAYMENT;
	}
	public String getR34_DESCRIPTION() {
		return R34_DESCRIPTION;
	}
	public void setR34_DESCRIPTION(String r34_DESCRIPTION) {
		R34_DESCRIPTION = r34_DESCRIPTION;
	}
	public BigDecimal getR34_All_TRANSACTIONS_INFLOWS() {
		return R34_All_TRANSACTIONS_INFLOWS;
	}
	public void setR34_All_TRANSACTIONS_INFLOWS(BigDecimal r34_All_TRANSACTIONS_INFLOWS) {
		R34_All_TRANSACTIONS_INFLOWS = r34_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR34_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R34_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR34_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r34_FINANCIAL_FREE_ZONE_INFLOWS) {
		R34_FINANCIAL_FREE_ZONE_INFLOWS = r34_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR34_TOTAL_INFLOWS() {
		return R34_TOTAL_INFLOWS;
	}
	public void setR34_TOTAL_INFLOWS(BigDecimal r34_TOTAL_INFLOWS) {
		R34_TOTAL_INFLOWS = r34_TOTAL_INFLOWS;
	}
	public BigDecimal getR34_All_TRANSACTIONS_OUTFLOWS() {
		return R34_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR34_All_TRANSACTIONS_OUTFLOWS(BigDecimal r34_All_TRANSACTIONS_OUTFLOWS) {
		R34_All_TRANSACTIONS_OUTFLOWS = r34_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR34_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R34_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR34_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r34_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R34_FINANCIAL_FREE_ZONE_OUTFLOWS = r34_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR34_TOTAL_OUTFLOWS() {
		return R34_TOTAL_OUTFLOWS;
	}
	public void setR34_TOTAL_OUTFLOWS(BigDecimal r34_TOTAL_OUTFLOWS) {
		R34_TOTAL_OUTFLOWS = r34_TOTAL_OUTFLOWS;
	}
	public String getR35_S_NO() {
		return R35_S_NO;
	}
	public void setR35_S_NO(String r35_S_NO) {
		R35_S_NO = r35_S_NO;
	}
	public String getR35_SWIFT_PAYMENT() {
		return R35_SWIFT_PAYMENT;
	}
	public void setR35_SWIFT_PAYMENT(String r35_SWIFT_PAYMENT) {
		R35_SWIFT_PAYMENT = r35_SWIFT_PAYMENT;
	}
	public String getR35_DESCRIPTION() {
		return R35_DESCRIPTION;
	}
	public void setR35_DESCRIPTION(String r35_DESCRIPTION) {
		R35_DESCRIPTION = r35_DESCRIPTION;
	}
	public BigDecimal getR35_All_TRANSACTIONS_INFLOWS() {
		return R35_All_TRANSACTIONS_INFLOWS;
	}
	public void setR35_All_TRANSACTIONS_INFLOWS(BigDecimal r35_All_TRANSACTIONS_INFLOWS) {
		R35_All_TRANSACTIONS_INFLOWS = r35_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR35_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R35_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR35_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r35_FINANCIAL_FREE_ZONE_INFLOWS) {
		R35_FINANCIAL_FREE_ZONE_INFLOWS = r35_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR35_TOTAL_INFLOWS() {
		return R35_TOTAL_INFLOWS;
	}
	public void setR35_TOTAL_INFLOWS(BigDecimal r35_TOTAL_INFLOWS) {
		R35_TOTAL_INFLOWS = r35_TOTAL_INFLOWS;
	}
	public BigDecimal getR35_All_TRANSACTIONS_OUTFLOWS() {
		return R35_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR35_All_TRANSACTIONS_OUTFLOWS(BigDecimal r35_All_TRANSACTIONS_OUTFLOWS) {
		R35_All_TRANSACTIONS_OUTFLOWS = r35_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR35_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R35_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR35_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r35_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R35_FINANCIAL_FREE_ZONE_OUTFLOWS = r35_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR35_TOTAL_OUTFLOWS() {
		return R35_TOTAL_OUTFLOWS;
	}
	public void setR35_TOTAL_OUTFLOWS(BigDecimal r35_TOTAL_OUTFLOWS) {
		R35_TOTAL_OUTFLOWS = r35_TOTAL_OUTFLOWS;
	}
	public String getR36_S_NO() {
		return R36_S_NO;
	}
	public void setR36_S_NO(String r36_S_NO) {
		R36_S_NO = r36_S_NO;
	}
	public String getR36_SWIFT_PAYMENT() {
		return R36_SWIFT_PAYMENT;
	}
	public void setR36_SWIFT_PAYMENT(String r36_SWIFT_PAYMENT) {
		R36_SWIFT_PAYMENT = r36_SWIFT_PAYMENT;
	}
	public String getR36_DESCRIPTION() {
		return R36_DESCRIPTION;
	}
	public void setR36_DESCRIPTION(String r36_DESCRIPTION) {
		R36_DESCRIPTION = r36_DESCRIPTION;
	}
	public BigDecimal getR36_All_TRANSACTIONS_INFLOWS() {
		return R36_All_TRANSACTIONS_INFLOWS;
	}
	public void setR36_All_TRANSACTIONS_INFLOWS(BigDecimal r36_All_TRANSACTIONS_INFLOWS) {
		R36_All_TRANSACTIONS_INFLOWS = r36_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR36_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R36_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR36_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r36_FINANCIAL_FREE_ZONE_INFLOWS) {
		R36_FINANCIAL_FREE_ZONE_INFLOWS = r36_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR36_TOTAL_INFLOWS() {
		return R36_TOTAL_INFLOWS;
	}
	public void setR36_TOTAL_INFLOWS(BigDecimal r36_TOTAL_INFLOWS) {
		R36_TOTAL_INFLOWS = r36_TOTAL_INFLOWS;
	}
	public BigDecimal getR36_All_TRANSACTIONS_OUTFLOWS() {
		return R36_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR36_All_TRANSACTIONS_OUTFLOWS(BigDecimal r36_All_TRANSACTIONS_OUTFLOWS) {
		R36_All_TRANSACTIONS_OUTFLOWS = r36_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR36_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R36_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR36_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r36_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R36_FINANCIAL_FREE_ZONE_OUTFLOWS = r36_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR36_TOTAL_OUTFLOWS() {
		return R36_TOTAL_OUTFLOWS;
	}
	public void setR36_TOTAL_OUTFLOWS(BigDecimal r36_TOTAL_OUTFLOWS) {
		R36_TOTAL_OUTFLOWS = r36_TOTAL_OUTFLOWS;
	}
	public String getR37_S_NO() {
		return R37_S_NO;
	}
	public void setR37_S_NO(String r37_S_NO) {
		R37_S_NO = r37_S_NO;
	}
	public String getR37_SWIFT_PAYMENT() {
		return R37_SWIFT_PAYMENT;
	}
	public void setR37_SWIFT_PAYMENT(String r37_SWIFT_PAYMENT) {
		R37_SWIFT_PAYMENT = r37_SWIFT_PAYMENT;
	}
	public String getR37_DESCRIPTION() {
		return R37_DESCRIPTION;
	}
	public void setR37_DESCRIPTION(String r37_DESCRIPTION) {
		R37_DESCRIPTION = r37_DESCRIPTION;
	}
	public BigDecimal getR37_All_TRANSACTIONS_INFLOWS() {
		return R37_All_TRANSACTIONS_INFLOWS;
	}
	public void setR37_All_TRANSACTIONS_INFLOWS(BigDecimal r37_All_TRANSACTIONS_INFLOWS) {
		R37_All_TRANSACTIONS_INFLOWS = r37_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR37_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R37_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR37_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r37_FINANCIAL_FREE_ZONE_INFLOWS) {
		R37_FINANCIAL_FREE_ZONE_INFLOWS = r37_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR37_TOTAL_INFLOWS() {
		return R37_TOTAL_INFLOWS;
	}
	public void setR37_TOTAL_INFLOWS(BigDecimal r37_TOTAL_INFLOWS) {
		R37_TOTAL_INFLOWS = r37_TOTAL_INFLOWS;
	}
	public BigDecimal getR37_All_TRANSACTIONS_OUTFLOWS() {
		return R37_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR37_All_TRANSACTIONS_OUTFLOWS(BigDecimal r37_All_TRANSACTIONS_OUTFLOWS) {
		R37_All_TRANSACTIONS_OUTFLOWS = r37_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR37_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R37_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR37_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r37_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R37_FINANCIAL_FREE_ZONE_OUTFLOWS = r37_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR37_TOTAL_OUTFLOWS() {
		return R37_TOTAL_OUTFLOWS;
	}
	public void setR37_TOTAL_OUTFLOWS(BigDecimal r37_TOTAL_OUTFLOWS) {
		R37_TOTAL_OUTFLOWS = r37_TOTAL_OUTFLOWS;
	}
	public String getR38_S_NO() {
		return R38_S_NO;
	}
	public void setR38_S_NO(String r38_S_NO) {
		R38_S_NO = r38_S_NO;
	}
	public String getR38_SWIFT_PAYMENT() {
		return R38_SWIFT_PAYMENT;
	}
	public void setR38_SWIFT_PAYMENT(String r38_SWIFT_PAYMENT) {
		R38_SWIFT_PAYMENT = r38_SWIFT_PAYMENT;
	}
	public String getR38_DESCRIPTION() {
		return R38_DESCRIPTION;
	}
	public void setR38_DESCRIPTION(String r38_DESCRIPTION) {
		R38_DESCRIPTION = r38_DESCRIPTION;
	}
	public BigDecimal getR38_All_TRANSACTIONS_INFLOWS() {
		return R38_All_TRANSACTIONS_INFLOWS;
	}
	public void setR38_All_TRANSACTIONS_INFLOWS(BigDecimal r38_All_TRANSACTIONS_INFLOWS) {
		R38_All_TRANSACTIONS_INFLOWS = r38_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR38_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R38_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR38_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r38_FINANCIAL_FREE_ZONE_INFLOWS) {
		R38_FINANCIAL_FREE_ZONE_INFLOWS = r38_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR38_TOTAL_INFLOWS() {
		return R38_TOTAL_INFLOWS;
	}
	public void setR38_TOTAL_INFLOWS(BigDecimal r38_TOTAL_INFLOWS) {
		R38_TOTAL_INFLOWS = r38_TOTAL_INFLOWS;
	}
	public BigDecimal getR38_All_TRANSACTIONS_OUTFLOWS() {
		return R38_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR38_All_TRANSACTIONS_OUTFLOWS(BigDecimal r38_All_TRANSACTIONS_OUTFLOWS) {
		R38_All_TRANSACTIONS_OUTFLOWS = r38_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR38_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R38_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR38_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r38_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R38_FINANCIAL_FREE_ZONE_OUTFLOWS = r38_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR38_TOTAL_OUTFLOWS() {
		return R38_TOTAL_OUTFLOWS;
	}
	public void setR38_TOTAL_OUTFLOWS(BigDecimal r38_TOTAL_OUTFLOWS) {
		R38_TOTAL_OUTFLOWS = r38_TOTAL_OUTFLOWS;
	}
	public String getR39_S_NO() {
		return R39_S_NO;
	}
	public void setR39_S_NO(String r39_S_NO) {
		R39_S_NO = r39_S_NO;
	}
	public String getR39_SWIFT_PAYMENT() {
		return R39_SWIFT_PAYMENT;
	}
	public void setR39_SWIFT_PAYMENT(String r39_SWIFT_PAYMENT) {
		R39_SWIFT_PAYMENT = r39_SWIFT_PAYMENT;
	}
	public String getR39_DESCRIPTION() {
		return R39_DESCRIPTION;
	}
	public void setR39_DESCRIPTION(String r39_DESCRIPTION) {
		R39_DESCRIPTION = r39_DESCRIPTION;
	}
	public BigDecimal getR39_All_TRANSACTIONS_INFLOWS() {
		return R39_All_TRANSACTIONS_INFLOWS;
	}
	public void setR39_All_TRANSACTIONS_INFLOWS(BigDecimal r39_All_TRANSACTIONS_INFLOWS) {
		R39_All_TRANSACTIONS_INFLOWS = r39_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR39_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R39_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR39_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r39_FINANCIAL_FREE_ZONE_INFLOWS) {
		R39_FINANCIAL_FREE_ZONE_INFLOWS = r39_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR39_TOTAL_INFLOWS() {
		return R39_TOTAL_INFLOWS;
	}
	public void setR39_TOTAL_INFLOWS(BigDecimal r39_TOTAL_INFLOWS) {
		R39_TOTAL_INFLOWS = r39_TOTAL_INFLOWS;
	}
	public BigDecimal getR39_All_TRANSACTIONS_OUTFLOWS() {
		return R39_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR39_All_TRANSACTIONS_OUTFLOWS(BigDecimal r39_All_TRANSACTIONS_OUTFLOWS) {
		R39_All_TRANSACTIONS_OUTFLOWS = r39_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR39_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R39_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR39_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r39_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R39_FINANCIAL_FREE_ZONE_OUTFLOWS = r39_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR39_TOTAL_OUTFLOWS() {
		return R39_TOTAL_OUTFLOWS;
	}
	public void setR39_TOTAL_OUTFLOWS(BigDecimal r39_TOTAL_OUTFLOWS) {
		R39_TOTAL_OUTFLOWS = r39_TOTAL_OUTFLOWS;
	}
	public String getR40_S_NO() {
		return R40_S_NO;
	}
	public void setR40_S_NO(String r40_S_NO) {
		R40_S_NO = r40_S_NO;
	}
	public String getR40_SWIFT_PAYMENT() {
		return R40_SWIFT_PAYMENT;
	}
	public void setR40_SWIFT_PAYMENT(String r40_SWIFT_PAYMENT) {
		R40_SWIFT_PAYMENT = r40_SWIFT_PAYMENT;
	}
	public String getR40_DESCRIPTION() {
		return R40_DESCRIPTION;
	}
	public void setR40_DESCRIPTION(String r40_DESCRIPTION) {
		R40_DESCRIPTION = r40_DESCRIPTION;
	}
	public BigDecimal getR40_All_TRANSACTIONS_INFLOWS() {
		return R40_All_TRANSACTIONS_INFLOWS;
	}
	public void setR40_All_TRANSACTIONS_INFLOWS(BigDecimal r40_All_TRANSACTIONS_INFLOWS) {
		R40_All_TRANSACTIONS_INFLOWS = r40_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR40_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R40_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR40_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r40_FINANCIAL_FREE_ZONE_INFLOWS) {
		R40_FINANCIAL_FREE_ZONE_INFLOWS = r40_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR40_TOTAL_INFLOWS() {
		return R40_TOTAL_INFLOWS;
	}
	public void setR40_TOTAL_INFLOWS(BigDecimal r40_TOTAL_INFLOWS) {
		R40_TOTAL_INFLOWS = r40_TOTAL_INFLOWS;
	}
	public BigDecimal getR40_All_TRANSACTIONS_OUTFLOWS() {
		return R40_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR40_All_TRANSACTIONS_OUTFLOWS(BigDecimal r40_All_TRANSACTIONS_OUTFLOWS) {
		R40_All_TRANSACTIONS_OUTFLOWS = r40_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR40_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R40_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR40_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r40_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R40_FINANCIAL_FREE_ZONE_OUTFLOWS = r40_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR40_TOTAL_OUTFLOWS() {
		return R40_TOTAL_OUTFLOWS;
	}
	public void setR40_TOTAL_OUTFLOWS(BigDecimal r40_TOTAL_OUTFLOWS) {
		R40_TOTAL_OUTFLOWS = r40_TOTAL_OUTFLOWS;
	}
	public String getR41_S_NO() {
		return R41_S_NO;
	}
	public void setR41_S_NO(String r41_S_NO) {
		R41_S_NO = r41_S_NO;
	}
	public String getR41_SWIFT_PAYMENT() {
		return R41_SWIFT_PAYMENT;
	}
	public void setR41_SWIFT_PAYMENT(String r41_SWIFT_PAYMENT) {
		R41_SWIFT_PAYMENT = r41_SWIFT_PAYMENT;
	}
	public String getR41_DESCRIPTION() {
		return R41_DESCRIPTION;
	}
	public void setR41_DESCRIPTION(String r41_DESCRIPTION) {
		R41_DESCRIPTION = r41_DESCRIPTION;
	}
	public BigDecimal getR41_All_TRANSACTIONS_INFLOWS() {
		return R41_All_TRANSACTIONS_INFLOWS;
	}
	public void setR41_All_TRANSACTIONS_INFLOWS(BigDecimal r41_All_TRANSACTIONS_INFLOWS) {
		R41_All_TRANSACTIONS_INFLOWS = r41_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR41_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R41_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR41_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r41_FINANCIAL_FREE_ZONE_INFLOWS) {
		R41_FINANCIAL_FREE_ZONE_INFLOWS = r41_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR41_TOTAL_INFLOWS() {
		return R41_TOTAL_INFLOWS;
	}
	public void setR41_TOTAL_INFLOWS(BigDecimal r41_TOTAL_INFLOWS) {
		R41_TOTAL_INFLOWS = r41_TOTAL_INFLOWS;
	}
	public BigDecimal getR41_All_TRANSACTIONS_OUTFLOWS() {
		return R41_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR41_All_TRANSACTIONS_OUTFLOWS(BigDecimal r41_All_TRANSACTIONS_OUTFLOWS) {
		R41_All_TRANSACTIONS_OUTFLOWS = r41_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR41_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R41_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR41_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r41_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R41_FINANCIAL_FREE_ZONE_OUTFLOWS = r41_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR41_TOTAL_OUTFLOWS() {
		return R41_TOTAL_OUTFLOWS;
	}
	public void setR41_TOTAL_OUTFLOWS(BigDecimal r41_TOTAL_OUTFLOWS) {
		R41_TOTAL_OUTFLOWS = r41_TOTAL_OUTFLOWS;
	}
	public String getR42_S_NO() {
		return R42_S_NO;
	}
	public void setR42_S_NO(String r42_S_NO) {
		R42_S_NO = r42_S_NO;
	}
	public String getR42_SWIFT_PAYMENT() {
		return R42_SWIFT_PAYMENT;
	}
	public void setR42_SWIFT_PAYMENT(String r42_SWIFT_PAYMENT) {
		R42_SWIFT_PAYMENT = r42_SWIFT_PAYMENT;
	}
	public String getR42_DESCRIPTION() {
		return R42_DESCRIPTION;
	}
	public void setR42_DESCRIPTION(String r42_DESCRIPTION) {
		R42_DESCRIPTION = r42_DESCRIPTION;
	}
	public BigDecimal getR42_All_TRANSACTIONS_INFLOWS() {
		return R42_All_TRANSACTIONS_INFLOWS;
	}
	public void setR42_All_TRANSACTIONS_INFLOWS(BigDecimal r42_All_TRANSACTIONS_INFLOWS) {
		R42_All_TRANSACTIONS_INFLOWS = r42_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR42_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R42_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR42_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r42_FINANCIAL_FREE_ZONE_INFLOWS) {
		R42_FINANCIAL_FREE_ZONE_INFLOWS = r42_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR42_TOTAL_INFLOWS() {
		return R42_TOTAL_INFLOWS;
	}
	public void setR42_TOTAL_INFLOWS(BigDecimal r42_TOTAL_INFLOWS) {
		R42_TOTAL_INFLOWS = r42_TOTAL_INFLOWS;
	}
	public BigDecimal getR42_All_TRANSACTIONS_OUTFLOWS() {
		return R42_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR42_All_TRANSACTIONS_OUTFLOWS(BigDecimal r42_All_TRANSACTIONS_OUTFLOWS) {
		R42_All_TRANSACTIONS_OUTFLOWS = r42_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR42_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R42_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR42_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r42_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R42_FINANCIAL_FREE_ZONE_OUTFLOWS = r42_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR42_TOTAL_OUTFLOWS() {
		return R42_TOTAL_OUTFLOWS;
	}
	public void setR42_TOTAL_OUTFLOWS(BigDecimal r42_TOTAL_OUTFLOWS) {
		R42_TOTAL_OUTFLOWS = r42_TOTAL_OUTFLOWS;
	}
	public String getR43_S_NO() {
		return R43_S_NO;
	}
	public void setR43_S_NO(String r43_S_NO) {
		R43_S_NO = r43_S_NO;
	}
	public String getR43_SWIFT_PAYMENT() {
		return R43_SWIFT_PAYMENT;
	}
	public void setR43_SWIFT_PAYMENT(String r43_SWIFT_PAYMENT) {
		R43_SWIFT_PAYMENT = r43_SWIFT_PAYMENT;
	}
	public String getR43_DESCRIPTION() {
		return R43_DESCRIPTION;
	}
	public void setR43_DESCRIPTION(String r43_DESCRIPTION) {
		R43_DESCRIPTION = r43_DESCRIPTION;
	}
	public BigDecimal getR43_All_TRANSACTIONS_INFLOWS() {
		return R43_All_TRANSACTIONS_INFLOWS;
	}
	public void setR43_All_TRANSACTIONS_INFLOWS(BigDecimal r43_All_TRANSACTIONS_INFLOWS) {
		R43_All_TRANSACTIONS_INFLOWS = r43_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR43_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R43_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR43_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r43_FINANCIAL_FREE_ZONE_INFLOWS) {
		R43_FINANCIAL_FREE_ZONE_INFLOWS = r43_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR43_TOTAL_INFLOWS() {
		return R43_TOTAL_INFLOWS;
	}
	public void setR43_TOTAL_INFLOWS(BigDecimal r43_TOTAL_INFLOWS) {
		R43_TOTAL_INFLOWS = r43_TOTAL_INFLOWS;
	}
	public BigDecimal getR43_All_TRANSACTIONS_OUTFLOWS() {
		return R43_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR43_All_TRANSACTIONS_OUTFLOWS(BigDecimal r43_All_TRANSACTIONS_OUTFLOWS) {
		R43_All_TRANSACTIONS_OUTFLOWS = r43_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR43_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R43_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR43_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r43_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R43_FINANCIAL_FREE_ZONE_OUTFLOWS = r43_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR43_TOTAL_OUTFLOWS() {
		return R43_TOTAL_OUTFLOWS;
	}
	public void setR43_TOTAL_OUTFLOWS(BigDecimal r43_TOTAL_OUTFLOWS) {
		R43_TOTAL_OUTFLOWS = r43_TOTAL_OUTFLOWS;
	}
	public String getR44_S_NO() {
		return R44_S_NO;
	}
	public void setR44_S_NO(String r44_S_NO) {
		R44_S_NO = r44_S_NO;
	}
	public String getR44_SWIFT_PAYMENT() {
		return R44_SWIFT_PAYMENT;
	}
	public void setR44_SWIFT_PAYMENT(String r44_SWIFT_PAYMENT) {
		R44_SWIFT_PAYMENT = r44_SWIFT_PAYMENT;
	}
	public String getR44_DESCRIPTION() {
		return R44_DESCRIPTION;
	}
	public void setR44_DESCRIPTION(String r44_DESCRIPTION) {
		R44_DESCRIPTION = r44_DESCRIPTION;
	}
	public BigDecimal getR44_All_TRANSACTIONS_INFLOWS() {
		return R44_All_TRANSACTIONS_INFLOWS;
	}
	public void setR44_All_TRANSACTIONS_INFLOWS(BigDecimal r44_All_TRANSACTIONS_INFLOWS) {
		R44_All_TRANSACTIONS_INFLOWS = r44_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR44_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R44_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR44_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r44_FINANCIAL_FREE_ZONE_INFLOWS) {
		R44_FINANCIAL_FREE_ZONE_INFLOWS = r44_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR44_TOTAL_INFLOWS() {
		return R44_TOTAL_INFLOWS;
	}
	public void setR44_TOTAL_INFLOWS(BigDecimal r44_TOTAL_INFLOWS) {
		R44_TOTAL_INFLOWS = r44_TOTAL_INFLOWS;
	}
	public BigDecimal getR44_All_TRANSACTIONS_OUTFLOWS() {
		return R44_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR44_All_TRANSACTIONS_OUTFLOWS(BigDecimal r44_All_TRANSACTIONS_OUTFLOWS) {
		R44_All_TRANSACTIONS_OUTFLOWS = r44_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR44_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R44_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR44_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r44_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R44_FINANCIAL_FREE_ZONE_OUTFLOWS = r44_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR44_TOTAL_OUTFLOWS() {
		return R44_TOTAL_OUTFLOWS;
	}
	public void setR44_TOTAL_OUTFLOWS(BigDecimal r44_TOTAL_OUTFLOWS) {
		R44_TOTAL_OUTFLOWS = r44_TOTAL_OUTFLOWS;
	}
	public String getR45_S_NO() {
		return R45_S_NO;
	}
	public void setR45_S_NO(String r45_S_NO) {
		R45_S_NO = r45_S_NO;
	}
	public String getR45_SWIFT_PAYMENT() {
		return R45_SWIFT_PAYMENT;
	}
	public void setR45_SWIFT_PAYMENT(String r45_SWIFT_PAYMENT) {
		R45_SWIFT_PAYMENT = r45_SWIFT_PAYMENT;
	}
	public String getR45_DESCRIPTION() {
		return R45_DESCRIPTION;
	}
	public void setR45_DESCRIPTION(String r45_DESCRIPTION) {
		R45_DESCRIPTION = r45_DESCRIPTION;
	}
	public BigDecimal getR45_All_TRANSACTIONS_INFLOWS() {
		return R45_All_TRANSACTIONS_INFLOWS;
	}
	public void setR45_All_TRANSACTIONS_INFLOWS(BigDecimal r45_All_TRANSACTIONS_INFLOWS) {
		R45_All_TRANSACTIONS_INFLOWS = r45_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR45_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R45_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR45_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r45_FINANCIAL_FREE_ZONE_INFLOWS) {
		R45_FINANCIAL_FREE_ZONE_INFLOWS = r45_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR45_TOTAL_INFLOWS() {
		return R45_TOTAL_INFLOWS;
	}
	public void setR45_TOTAL_INFLOWS(BigDecimal r45_TOTAL_INFLOWS) {
		R45_TOTAL_INFLOWS = r45_TOTAL_INFLOWS;
	}
	public BigDecimal getR45_All_TRANSACTIONS_OUTFLOWS() {
		return R45_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR45_All_TRANSACTIONS_OUTFLOWS(BigDecimal r45_All_TRANSACTIONS_OUTFLOWS) {
		R45_All_TRANSACTIONS_OUTFLOWS = r45_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR45_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R45_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR45_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r45_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R45_FINANCIAL_FREE_ZONE_OUTFLOWS = r45_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR45_TOTAL_OUTFLOWS() {
		return R45_TOTAL_OUTFLOWS;
	}
	public void setR45_TOTAL_OUTFLOWS(BigDecimal r45_TOTAL_OUTFLOWS) {
		R45_TOTAL_OUTFLOWS = r45_TOTAL_OUTFLOWS;
	}
	public String getR46_S_NO() {
		return R46_S_NO;
	}
	public void setR46_S_NO(String r46_S_NO) {
		R46_S_NO = r46_S_NO;
	}
	public String getR46_SWIFT_PAYMENT() {
		return R46_SWIFT_PAYMENT;
	}
	public void setR46_SWIFT_PAYMENT(String r46_SWIFT_PAYMENT) {
		R46_SWIFT_PAYMENT = r46_SWIFT_PAYMENT;
	}
	public String getR46_DESCRIPTION() {
		return R46_DESCRIPTION;
	}
	public void setR46_DESCRIPTION(String r46_DESCRIPTION) {
		R46_DESCRIPTION = r46_DESCRIPTION;
	}
	public BigDecimal getR46_All_TRANSACTIONS_INFLOWS() {
		return R46_All_TRANSACTIONS_INFLOWS;
	}
	public void setR46_All_TRANSACTIONS_INFLOWS(BigDecimal r46_All_TRANSACTIONS_INFLOWS) {
		R46_All_TRANSACTIONS_INFLOWS = r46_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR46_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R46_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR46_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r46_FINANCIAL_FREE_ZONE_INFLOWS) {
		R46_FINANCIAL_FREE_ZONE_INFLOWS = r46_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR46_TOTAL_INFLOWS() {
		return R46_TOTAL_INFLOWS;
	}
	public void setR46_TOTAL_INFLOWS(BigDecimal r46_TOTAL_INFLOWS) {
		R46_TOTAL_INFLOWS = r46_TOTAL_INFLOWS;
	}
	public BigDecimal getR46_All_TRANSACTIONS_OUTFLOWS() {
		return R46_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR46_All_TRANSACTIONS_OUTFLOWS(BigDecimal r46_All_TRANSACTIONS_OUTFLOWS) {
		R46_All_TRANSACTIONS_OUTFLOWS = r46_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR46_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R46_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR46_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r46_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R46_FINANCIAL_FREE_ZONE_OUTFLOWS = r46_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR46_TOTAL_OUTFLOWS() {
		return R46_TOTAL_OUTFLOWS;
	}
	public void setR46_TOTAL_OUTFLOWS(BigDecimal r46_TOTAL_OUTFLOWS) {
		R46_TOTAL_OUTFLOWS = r46_TOTAL_OUTFLOWS;
	}
	public String getR47_S_NO() {
		return R47_S_NO;
	}
	public void setR47_S_NO(String r47_S_NO) {
		R47_S_NO = r47_S_NO;
	}
	public String getR47_SWIFT_PAYMENT() {
		return R47_SWIFT_PAYMENT;
	}
	public void setR47_SWIFT_PAYMENT(String r47_SWIFT_PAYMENT) {
		R47_SWIFT_PAYMENT = r47_SWIFT_PAYMENT;
	}
	public String getR47_DESCRIPTION() {
		return R47_DESCRIPTION;
	}
	public void setR47_DESCRIPTION(String r47_DESCRIPTION) {
		R47_DESCRIPTION = r47_DESCRIPTION;
	}
	public BigDecimal getR47_All_TRANSACTIONS_INFLOWS() {
		return R47_All_TRANSACTIONS_INFLOWS;
	}
	public void setR47_All_TRANSACTIONS_INFLOWS(BigDecimal r47_All_TRANSACTIONS_INFLOWS) {
		R47_All_TRANSACTIONS_INFLOWS = r47_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR47_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R47_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR47_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r47_FINANCIAL_FREE_ZONE_INFLOWS) {
		R47_FINANCIAL_FREE_ZONE_INFLOWS = r47_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR47_TOTAL_INFLOWS() {
		return R47_TOTAL_INFLOWS;
	}
	public void setR47_TOTAL_INFLOWS(BigDecimal r47_TOTAL_INFLOWS) {
		R47_TOTAL_INFLOWS = r47_TOTAL_INFLOWS;
	}
	public BigDecimal getR47_All_TRANSACTIONS_OUTFLOWS() {
		return R47_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR47_All_TRANSACTIONS_OUTFLOWS(BigDecimal r47_All_TRANSACTIONS_OUTFLOWS) {
		R47_All_TRANSACTIONS_OUTFLOWS = r47_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR47_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R47_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR47_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r47_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R47_FINANCIAL_FREE_ZONE_OUTFLOWS = r47_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR47_TOTAL_OUTFLOWS() {
		return R47_TOTAL_OUTFLOWS;
	}
	public void setR47_TOTAL_OUTFLOWS(BigDecimal r47_TOTAL_OUTFLOWS) {
		R47_TOTAL_OUTFLOWS = r47_TOTAL_OUTFLOWS;
	}
	public String getR48_S_NO() {
		return R48_S_NO;
	}
	public void setR48_S_NO(String r48_S_NO) {
		R48_S_NO = r48_S_NO;
	}
	public String getR48_SWIFT_PAYMENT() {
		return R48_SWIFT_PAYMENT;
	}
	public void setR48_SWIFT_PAYMENT(String r48_SWIFT_PAYMENT) {
		R48_SWIFT_PAYMENT = r48_SWIFT_PAYMENT;
	}
	public String getR48_DESCRIPTION() {
		return R48_DESCRIPTION;
	}
	public void setR48_DESCRIPTION(String r48_DESCRIPTION) {
		R48_DESCRIPTION = r48_DESCRIPTION;
	}
	public BigDecimal getR48_All_TRANSACTIONS_INFLOWS() {
		return R48_All_TRANSACTIONS_INFLOWS;
	}
	public void setR48_All_TRANSACTIONS_INFLOWS(BigDecimal r48_All_TRANSACTIONS_INFLOWS) {
		R48_All_TRANSACTIONS_INFLOWS = r48_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR48_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R48_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR48_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r48_FINANCIAL_FREE_ZONE_INFLOWS) {
		R48_FINANCIAL_FREE_ZONE_INFLOWS = r48_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR48_TOTAL_INFLOWS() {
		return R48_TOTAL_INFLOWS;
	}
	public void setR48_TOTAL_INFLOWS(BigDecimal r48_TOTAL_INFLOWS) {
		R48_TOTAL_INFLOWS = r48_TOTAL_INFLOWS;
	}
	public BigDecimal getR48_All_TRANSACTIONS_OUTFLOWS() {
		return R48_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR48_All_TRANSACTIONS_OUTFLOWS(BigDecimal r48_All_TRANSACTIONS_OUTFLOWS) {
		R48_All_TRANSACTIONS_OUTFLOWS = r48_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR48_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R48_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR48_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r48_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R48_FINANCIAL_FREE_ZONE_OUTFLOWS = r48_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR48_TOTAL_OUTFLOWS() {
		return R48_TOTAL_OUTFLOWS;
	}
	public void setR48_TOTAL_OUTFLOWS(BigDecimal r48_TOTAL_OUTFLOWS) {
		R48_TOTAL_OUTFLOWS = r48_TOTAL_OUTFLOWS;
	}
	public String getR49_S_NO() {
		return R49_S_NO;
	}
	public void setR49_S_NO(String r49_S_NO) {
		R49_S_NO = r49_S_NO;
	}
	public String getR49_SWIFT_PAYMENT() {
		return R49_SWIFT_PAYMENT;
	}
	public void setR49_SWIFT_PAYMENT(String r49_SWIFT_PAYMENT) {
		R49_SWIFT_PAYMENT = r49_SWIFT_PAYMENT;
	}
	public String getR49_DESCRIPTION() {
		return R49_DESCRIPTION;
	}
	public void setR49_DESCRIPTION(String r49_DESCRIPTION) {
		R49_DESCRIPTION = r49_DESCRIPTION;
	}
	public BigDecimal getR49_All_TRANSACTIONS_INFLOWS() {
		return R49_All_TRANSACTIONS_INFLOWS;
	}
	public void setR49_All_TRANSACTIONS_INFLOWS(BigDecimal r49_All_TRANSACTIONS_INFLOWS) {
		R49_All_TRANSACTIONS_INFLOWS = r49_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR49_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R49_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR49_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r49_FINANCIAL_FREE_ZONE_INFLOWS) {
		R49_FINANCIAL_FREE_ZONE_INFLOWS = r49_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR49_TOTAL_INFLOWS() {
		return R49_TOTAL_INFLOWS;
	}
	public void setR49_TOTAL_INFLOWS(BigDecimal r49_TOTAL_INFLOWS) {
		R49_TOTAL_INFLOWS = r49_TOTAL_INFLOWS;
	}
	public BigDecimal getR49_All_TRANSACTIONS_OUTFLOWS() {
		return R49_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR49_All_TRANSACTIONS_OUTFLOWS(BigDecimal r49_All_TRANSACTIONS_OUTFLOWS) {
		R49_All_TRANSACTIONS_OUTFLOWS = r49_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR49_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R49_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR49_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r49_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R49_FINANCIAL_FREE_ZONE_OUTFLOWS = r49_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR49_TOTAL_OUTFLOWS() {
		return R49_TOTAL_OUTFLOWS;
	}
	public void setR49_TOTAL_OUTFLOWS(BigDecimal r49_TOTAL_OUTFLOWS) {
		R49_TOTAL_OUTFLOWS = r49_TOTAL_OUTFLOWS;
	}
	public String getR50_S_NO() {
		return R50_S_NO;
	}
	public void setR50_S_NO(String r50_S_NO) {
		R50_S_NO = r50_S_NO;
	}
	public String getR50_SWIFT_PAYMENT() {
		return R50_SWIFT_PAYMENT;
	}
	public void setR50_SWIFT_PAYMENT(String r50_SWIFT_PAYMENT) {
		R50_SWIFT_PAYMENT = r50_SWIFT_PAYMENT;
	}
	public String getR50_DESCRIPTION() {
		return R50_DESCRIPTION;
	}
	public void setR50_DESCRIPTION(String r50_DESCRIPTION) {
		R50_DESCRIPTION = r50_DESCRIPTION;
	}
	public BigDecimal getR50_All_TRANSACTIONS_INFLOWS() {
		return R50_All_TRANSACTIONS_INFLOWS;
	}
	public void setR50_All_TRANSACTIONS_INFLOWS(BigDecimal r50_All_TRANSACTIONS_INFLOWS) {
		R50_All_TRANSACTIONS_INFLOWS = r50_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR50_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R50_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR50_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r50_FINANCIAL_FREE_ZONE_INFLOWS) {
		R50_FINANCIAL_FREE_ZONE_INFLOWS = r50_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR50_TOTAL_INFLOWS() {
		return R50_TOTAL_INFLOWS;
	}
	public void setR50_TOTAL_INFLOWS(BigDecimal r50_TOTAL_INFLOWS) {
		R50_TOTAL_INFLOWS = r50_TOTAL_INFLOWS;
	}
	public BigDecimal getR50_All_TRANSACTIONS_OUTFLOWS() {
		return R50_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR50_All_TRANSACTIONS_OUTFLOWS(BigDecimal r50_All_TRANSACTIONS_OUTFLOWS) {
		R50_All_TRANSACTIONS_OUTFLOWS = r50_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR50_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R50_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR50_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r50_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R50_FINANCIAL_FREE_ZONE_OUTFLOWS = r50_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR50_TOTAL_OUTFLOWS() {
		return R50_TOTAL_OUTFLOWS;
	}
	public void setR50_TOTAL_OUTFLOWS(BigDecimal r50_TOTAL_OUTFLOWS) {
		R50_TOTAL_OUTFLOWS = r50_TOTAL_OUTFLOWS;
	}
	public String getR51_S_NO() {
		return R51_S_NO;
	}
	public void setR51_S_NO(String r51_S_NO) {
		R51_S_NO = r51_S_NO;
	}
	public String getR51_SWIFT_PAYMENT() {
		return R51_SWIFT_PAYMENT;
	}
	public void setR51_SWIFT_PAYMENT(String r51_SWIFT_PAYMENT) {
		R51_SWIFT_PAYMENT = r51_SWIFT_PAYMENT;
	}
	public String getR51_DESCRIPTION() {
		return R51_DESCRIPTION;
	}
	public void setR51_DESCRIPTION(String r51_DESCRIPTION) {
		R51_DESCRIPTION = r51_DESCRIPTION;
	}
	public BigDecimal getR51_All_TRANSACTIONS_INFLOWS() {
		return R51_All_TRANSACTIONS_INFLOWS;
	}
	public void setR51_All_TRANSACTIONS_INFLOWS(BigDecimal r51_All_TRANSACTIONS_INFLOWS) {
		R51_All_TRANSACTIONS_INFLOWS = r51_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR51_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R51_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR51_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r51_FINANCIAL_FREE_ZONE_INFLOWS) {
		R51_FINANCIAL_FREE_ZONE_INFLOWS = r51_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR51_TOTAL_INFLOWS() {
		return R51_TOTAL_INFLOWS;
	}
	public void setR51_TOTAL_INFLOWS(BigDecimal r51_TOTAL_INFLOWS) {
		R51_TOTAL_INFLOWS = r51_TOTAL_INFLOWS;
	}
	public BigDecimal getR51_All_TRANSACTIONS_OUTFLOWS() {
		return R51_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR51_All_TRANSACTIONS_OUTFLOWS(BigDecimal r51_All_TRANSACTIONS_OUTFLOWS) {
		R51_All_TRANSACTIONS_OUTFLOWS = r51_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR51_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R51_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR51_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r51_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R51_FINANCIAL_FREE_ZONE_OUTFLOWS = r51_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR51_TOTAL_OUTFLOWS() {
		return R51_TOTAL_OUTFLOWS;
	}
	public void setR51_TOTAL_OUTFLOWS(BigDecimal r51_TOTAL_OUTFLOWS) {
		R51_TOTAL_OUTFLOWS = r51_TOTAL_OUTFLOWS;
	}
	public String getR52_S_NO() {
		return R52_S_NO;
	}
	public void setR52_S_NO(String r52_S_NO) {
		R52_S_NO = r52_S_NO;
	}
	public String getR52_SWIFT_PAYMENT() {
		return R52_SWIFT_PAYMENT;
	}
	public void setR52_SWIFT_PAYMENT(String r52_SWIFT_PAYMENT) {
		R52_SWIFT_PAYMENT = r52_SWIFT_PAYMENT;
	}
	public String getR52_DESCRIPTION() {
		return R52_DESCRIPTION;
	}
	public void setR52_DESCRIPTION(String r52_DESCRIPTION) {
		R52_DESCRIPTION = r52_DESCRIPTION;
	}
	public BigDecimal getR52_All_TRANSACTIONS_INFLOWS() {
		return R52_All_TRANSACTIONS_INFLOWS;
	}
	public void setR52_All_TRANSACTIONS_INFLOWS(BigDecimal r52_All_TRANSACTIONS_INFLOWS) {
		R52_All_TRANSACTIONS_INFLOWS = r52_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR52_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R52_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR52_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r52_FINANCIAL_FREE_ZONE_INFLOWS) {
		R52_FINANCIAL_FREE_ZONE_INFLOWS = r52_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR52_TOTAL_INFLOWS() {
		return R52_TOTAL_INFLOWS;
	}
	public void setR52_TOTAL_INFLOWS(BigDecimal r52_TOTAL_INFLOWS) {
		R52_TOTAL_INFLOWS = r52_TOTAL_INFLOWS;
	}
	public BigDecimal getR52_All_TRANSACTIONS_OUTFLOWS() {
		return R52_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR52_All_TRANSACTIONS_OUTFLOWS(BigDecimal r52_All_TRANSACTIONS_OUTFLOWS) {
		R52_All_TRANSACTIONS_OUTFLOWS = r52_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR52_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R52_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR52_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r52_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R52_FINANCIAL_FREE_ZONE_OUTFLOWS = r52_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR52_TOTAL_OUTFLOWS() {
		return R52_TOTAL_OUTFLOWS;
	}
	public void setR52_TOTAL_OUTFLOWS(BigDecimal r52_TOTAL_OUTFLOWS) {
		R52_TOTAL_OUTFLOWS = r52_TOTAL_OUTFLOWS;
	}
	public String getR53_S_NO() {
		return R53_S_NO;
	}
	public void setR53_S_NO(String r53_S_NO) {
		R53_S_NO = r53_S_NO;
	}
	public String getR53_SWIFT_PAYMENT() {
		return R53_SWIFT_PAYMENT;
	}
	public void setR53_SWIFT_PAYMENT(String r53_SWIFT_PAYMENT) {
		R53_SWIFT_PAYMENT = r53_SWIFT_PAYMENT;
	}
	public String getR53_DESCRIPTION() {
		return R53_DESCRIPTION;
	}
	public void setR53_DESCRIPTION(String r53_DESCRIPTION) {
		R53_DESCRIPTION = r53_DESCRIPTION;
	}
	public BigDecimal getR53_All_TRANSACTIONS_INFLOWS() {
		return R53_All_TRANSACTIONS_INFLOWS;
	}
	public void setR53_All_TRANSACTIONS_INFLOWS(BigDecimal r53_All_TRANSACTIONS_INFLOWS) {
		R53_All_TRANSACTIONS_INFLOWS = r53_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR53_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R53_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR53_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r53_FINANCIAL_FREE_ZONE_INFLOWS) {
		R53_FINANCIAL_FREE_ZONE_INFLOWS = r53_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR53_TOTAL_INFLOWS() {
		return R53_TOTAL_INFLOWS;
	}
	public void setR53_TOTAL_INFLOWS(BigDecimal r53_TOTAL_INFLOWS) {
		R53_TOTAL_INFLOWS = r53_TOTAL_INFLOWS;
	}
	public BigDecimal getR53_All_TRANSACTIONS_OUTFLOWS() {
		return R53_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR53_All_TRANSACTIONS_OUTFLOWS(BigDecimal r53_All_TRANSACTIONS_OUTFLOWS) {
		R53_All_TRANSACTIONS_OUTFLOWS = r53_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR53_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R53_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR53_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r53_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R53_FINANCIAL_FREE_ZONE_OUTFLOWS = r53_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR53_TOTAL_OUTFLOWS() {
		return R53_TOTAL_OUTFLOWS;
	}
	public void setR53_TOTAL_OUTFLOWS(BigDecimal r53_TOTAL_OUTFLOWS) {
		R53_TOTAL_OUTFLOWS = r53_TOTAL_OUTFLOWS;
	}
	public String getR54_S_NO() {
		return R54_S_NO;
	}
	public void setR54_S_NO(String r54_S_NO) {
		R54_S_NO = r54_S_NO;
	}
	public String getR54_SWIFT_PAYMENT() {
		return R54_SWIFT_PAYMENT;
	}
	public void setR54_SWIFT_PAYMENT(String r54_SWIFT_PAYMENT) {
		R54_SWIFT_PAYMENT = r54_SWIFT_PAYMENT;
	}
	public String getR54_DESCRIPTION() {
		return R54_DESCRIPTION;
	}
	public void setR54_DESCRIPTION(String r54_DESCRIPTION) {
		R54_DESCRIPTION = r54_DESCRIPTION;
	}
	public BigDecimal getR54_All_TRANSACTIONS_INFLOWS() {
		return R54_All_TRANSACTIONS_INFLOWS;
	}
	public void setR54_All_TRANSACTIONS_INFLOWS(BigDecimal r54_All_TRANSACTIONS_INFLOWS) {
		R54_All_TRANSACTIONS_INFLOWS = r54_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR54_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R54_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR54_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r54_FINANCIAL_FREE_ZONE_INFLOWS) {
		R54_FINANCIAL_FREE_ZONE_INFLOWS = r54_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR54_TOTAL_INFLOWS() {
		return R54_TOTAL_INFLOWS;
	}
	public void setR54_TOTAL_INFLOWS(BigDecimal r54_TOTAL_INFLOWS) {
		R54_TOTAL_INFLOWS = r54_TOTAL_INFLOWS;
	}
	public BigDecimal getR54_All_TRANSACTIONS_OUTFLOWS() {
		return R54_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR54_All_TRANSACTIONS_OUTFLOWS(BigDecimal r54_All_TRANSACTIONS_OUTFLOWS) {
		R54_All_TRANSACTIONS_OUTFLOWS = r54_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR54_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R54_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR54_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r54_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R54_FINANCIAL_FREE_ZONE_OUTFLOWS = r54_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR54_TOTAL_OUTFLOWS() {
		return R54_TOTAL_OUTFLOWS;
	}
	public void setR54_TOTAL_OUTFLOWS(BigDecimal r54_TOTAL_OUTFLOWS) {
		R54_TOTAL_OUTFLOWS = r54_TOTAL_OUTFLOWS;
	}
	public String getR55_S_NO() {
		return R55_S_NO;
	}
	public void setR55_S_NO(String r55_S_NO) {
		R55_S_NO = r55_S_NO;
	}
	public String getR55_SWIFT_PAYMENT() {
		return R55_SWIFT_PAYMENT;
	}
	public void setR55_SWIFT_PAYMENT(String r55_SWIFT_PAYMENT) {
		R55_SWIFT_PAYMENT = r55_SWIFT_PAYMENT;
	}
	public String getR55_DESCRIPTION() {
		return R55_DESCRIPTION;
	}
	public void setR55_DESCRIPTION(String r55_DESCRIPTION) {
		R55_DESCRIPTION = r55_DESCRIPTION;
	}
	public BigDecimal getR55_All_TRANSACTIONS_INFLOWS() {
		return R55_All_TRANSACTIONS_INFLOWS;
	}
	public void setR55_All_TRANSACTIONS_INFLOWS(BigDecimal r55_All_TRANSACTIONS_INFLOWS) {
		R55_All_TRANSACTIONS_INFLOWS = r55_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR55_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R55_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR55_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r55_FINANCIAL_FREE_ZONE_INFLOWS) {
		R55_FINANCIAL_FREE_ZONE_INFLOWS = r55_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR55_TOTAL_INFLOWS() {
		return R55_TOTAL_INFLOWS;
	}
	public void setR55_TOTAL_INFLOWS(BigDecimal r55_TOTAL_INFLOWS) {
		R55_TOTAL_INFLOWS = r55_TOTAL_INFLOWS;
	}
	public BigDecimal getR55_All_TRANSACTIONS_OUTFLOWS() {
		return R55_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR55_All_TRANSACTIONS_OUTFLOWS(BigDecimal r55_All_TRANSACTIONS_OUTFLOWS) {
		R55_All_TRANSACTIONS_OUTFLOWS = r55_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR55_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R55_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR55_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r55_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R55_FINANCIAL_FREE_ZONE_OUTFLOWS = r55_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR55_TOTAL_OUTFLOWS() {
		return R55_TOTAL_OUTFLOWS;
	}
	public void setR55_TOTAL_OUTFLOWS(BigDecimal r55_TOTAL_OUTFLOWS) {
		R55_TOTAL_OUTFLOWS = r55_TOTAL_OUTFLOWS;
	}
	public String getR56_S_NO() {
		return R56_S_NO;
	}
	public void setR56_S_NO(String r56_S_NO) {
		R56_S_NO = r56_S_NO;
	}
	public String getR56_SWIFT_PAYMENT() {
		return R56_SWIFT_PAYMENT;
	}
	public void setR56_SWIFT_PAYMENT(String r56_SWIFT_PAYMENT) {
		R56_SWIFT_PAYMENT = r56_SWIFT_PAYMENT;
	}
	public String getR56_DESCRIPTION() {
		return R56_DESCRIPTION;
	}
	public void setR56_DESCRIPTION(String r56_DESCRIPTION) {
		R56_DESCRIPTION = r56_DESCRIPTION;
	}
	public BigDecimal getR56_All_TRANSACTIONS_INFLOWS() {
		return R56_All_TRANSACTIONS_INFLOWS;
	}
	public void setR56_All_TRANSACTIONS_INFLOWS(BigDecimal r56_All_TRANSACTIONS_INFLOWS) {
		R56_All_TRANSACTIONS_INFLOWS = r56_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR56_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R56_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR56_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r56_FINANCIAL_FREE_ZONE_INFLOWS) {
		R56_FINANCIAL_FREE_ZONE_INFLOWS = r56_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR56_TOTAL_INFLOWS() {
		return R56_TOTAL_INFLOWS;
	}
	public void setR56_TOTAL_INFLOWS(BigDecimal r56_TOTAL_INFLOWS) {
		R56_TOTAL_INFLOWS = r56_TOTAL_INFLOWS;
	}
	public BigDecimal getR56_All_TRANSACTIONS_OUTFLOWS() {
		return R56_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR56_All_TRANSACTIONS_OUTFLOWS(BigDecimal r56_All_TRANSACTIONS_OUTFLOWS) {
		R56_All_TRANSACTIONS_OUTFLOWS = r56_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR56_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R56_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR56_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r56_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R56_FINANCIAL_FREE_ZONE_OUTFLOWS = r56_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR56_TOTAL_OUTFLOWS() {
		return R56_TOTAL_OUTFLOWS;
	}
	public void setR56_TOTAL_OUTFLOWS(BigDecimal r56_TOTAL_OUTFLOWS) {
		R56_TOTAL_OUTFLOWS = r56_TOTAL_OUTFLOWS;
	}
	public String getR57_S_NO() {
		return R57_S_NO;
	}
	public void setR57_S_NO(String r57_S_NO) {
		R57_S_NO = r57_S_NO;
	}
	public String getR57_SWIFT_PAYMENT() {
		return R57_SWIFT_PAYMENT;
	}
	public void setR57_SWIFT_PAYMENT(String r57_SWIFT_PAYMENT) {
		R57_SWIFT_PAYMENT = r57_SWIFT_PAYMENT;
	}
	public String getR57_DESCRIPTION() {
		return R57_DESCRIPTION;
	}
	public void setR57_DESCRIPTION(String r57_DESCRIPTION) {
		R57_DESCRIPTION = r57_DESCRIPTION;
	}
	public BigDecimal getR57_All_TRANSACTIONS_INFLOWS() {
		return R57_All_TRANSACTIONS_INFLOWS;
	}
	public void setR57_All_TRANSACTIONS_INFLOWS(BigDecimal r57_All_TRANSACTIONS_INFLOWS) {
		R57_All_TRANSACTIONS_INFLOWS = r57_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR57_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R57_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR57_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r57_FINANCIAL_FREE_ZONE_INFLOWS) {
		R57_FINANCIAL_FREE_ZONE_INFLOWS = r57_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR57_TOTAL_INFLOWS() {
		return R57_TOTAL_INFLOWS;
	}
	public void setR57_TOTAL_INFLOWS(BigDecimal r57_TOTAL_INFLOWS) {
		R57_TOTAL_INFLOWS = r57_TOTAL_INFLOWS;
	}
	public BigDecimal getR57_All_TRANSACTIONS_OUTFLOWS() {
		return R57_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR57_All_TRANSACTIONS_OUTFLOWS(BigDecimal r57_All_TRANSACTIONS_OUTFLOWS) {
		R57_All_TRANSACTIONS_OUTFLOWS = r57_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR57_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R57_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR57_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r57_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R57_FINANCIAL_FREE_ZONE_OUTFLOWS = r57_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR57_TOTAL_OUTFLOWS() {
		return R57_TOTAL_OUTFLOWS;
	}
	public void setR57_TOTAL_OUTFLOWS(BigDecimal r57_TOTAL_OUTFLOWS) {
		R57_TOTAL_OUTFLOWS = r57_TOTAL_OUTFLOWS;
	}
	public String getR58_S_NO() {
		return R58_S_NO;
	}
	public void setR58_S_NO(String r58_S_NO) {
		R58_S_NO = r58_S_NO;
	}
	public String getR58_SWIFT_PAYMENT() {
		return R58_SWIFT_PAYMENT;
	}
	public void setR58_SWIFT_PAYMENT(String r58_SWIFT_PAYMENT) {
		R58_SWIFT_PAYMENT = r58_SWIFT_PAYMENT;
	}
	public String getR58_DESCRIPTION() {
		return R58_DESCRIPTION;
	}
	public void setR58_DESCRIPTION(String r58_DESCRIPTION) {
		R58_DESCRIPTION = r58_DESCRIPTION;
	}
	public BigDecimal getR58_All_TRANSACTIONS_INFLOWS() {
		return R58_All_TRANSACTIONS_INFLOWS;
	}
	public void setR58_All_TRANSACTIONS_INFLOWS(BigDecimal r58_All_TRANSACTIONS_INFLOWS) {
		R58_All_TRANSACTIONS_INFLOWS = r58_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR58_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R58_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR58_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r58_FINANCIAL_FREE_ZONE_INFLOWS) {
		R58_FINANCIAL_FREE_ZONE_INFLOWS = r58_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR58_TOTAL_INFLOWS() {
		return R58_TOTAL_INFLOWS;
	}
	public void setR58_TOTAL_INFLOWS(BigDecimal r58_TOTAL_INFLOWS) {
		R58_TOTAL_INFLOWS = r58_TOTAL_INFLOWS;
	}
	public BigDecimal getR58_All_TRANSACTIONS_OUTFLOWS() {
		return R58_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR58_All_TRANSACTIONS_OUTFLOWS(BigDecimal r58_All_TRANSACTIONS_OUTFLOWS) {
		R58_All_TRANSACTIONS_OUTFLOWS = r58_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR58_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R58_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR58_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r58_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R58_FINANCIAL_FREE_ZONE_OUTFLOWS = r58_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR58_TOTAL_OUTFLOWS() {
		return R58_TOTAL_OUTFLOWS;
	}
	public void setR58_TOTAL_OUTFLOWS(BigDecimal r58_TOTAL_OUTFLOWS) {
		R58_TOTAL_OUTFLOWS = r58_TOTAL_OUTFLOWS;
	}
	public String getR59_S_NO() {
		return R59_S_NO;
	}
	public void setR59_S_NO(String r59_S_NO) {
		R59_S_NO = r59_S_NO;
	}
	public String getR59_SWIFT_PAYMENT() {
		return R59_SWIFT_PAYMENT;
	}
	public void setR59_SWIFT_PAYMENT(String r59_SWIFT_PAYMENT) {
		R59_SWIFT_PAYMENT = r59_SWIFT_PAYMENT;
	}
	public String getR59_DESCRIPTION() {
		return R59_DESCRIPTION;
	}
	public void setR59_DESCRIPTION(String r59_DESCRIPTION) {
		R59_DESCRIPTION = r59_DESCRIPTION;
	}
	public BigDecimal getR59_All_TRANSACTIONS_INFLOWS() {
		return R59_All_TRANSACTIONS_INFLOWS;
	}
	public void setR59_All_TRANSACTIONS_INFLOWS(BigDecimal r59_All_TRANSACTIONS_INFLOWS) {
		R59_All_TRANSACTIONS_INFLOWS = r59_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR59_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R59_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR59_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r59_FINANCIAL_FREE_ZONE_INFLOWS) {
		R59_FINANCIAL_FREE_ZONE_INFLOWS = r59_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR59_TOTAL_INFLOWS() {
		return R59_TOTAL_INFLOWS;
	}
	public void setR59_TOTAL_INFLOWS(BigDecimal r59_TOTAL_INFLOWS) {
		R59_TOTAL_INFLOWS = r59_TOTAL_INFLOWS;
	}
	public BigDecimal getR59_All_TRANSACTIONS_OUTFLOWS() {
		return R59_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR59_All_TRANSACTIONS_OUTFLOWS(BigDecimal r59_All_TRANSACTIONS_OUTFLOWS) {
		R59_All_TRANSACTIONS_OUTFLOWS = r59_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR59_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R59_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR59_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r59_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R59_FINANCIAL_FREE_ZONE_OUTFLOWS = r59_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR59_TOTAL_OUTFLOWS() {
		return R59_TOTAL_OUTFLOWS;
	}
	public void setR59_TOTAL_OUTFLOWS(BigDecimal r59_TOTAL_OUTFLOWS) {
		R59_TOTAL_OUTFLOWS = r59_TOTAL_OUTFLOWS;
	}
	public String getR60_S_NO() {
		return R60_S_NO;
	}
	public void setR60_S_NO(String r60_S_NO) {
		R60_S_NO = r60_S_NO;
	}
	public String getR60_SWIFT_PAYMENT() {
		return R60_SWIFT_PAYMENT;
	}
	public void setR60_SWIFT_PAYMENT(String r60_SWIFT_PAYMENT) {
		R60_SWIFT_PAYMENT = r60_SWIFT_PAYMENT;
	}
	public String getR60_DESCRIPTION() {
		return R60_DESCRIPTION;
	}
	public void setR60_DESCRIPTION(String r60_DESCRIPTION) {
		R60_DESCRIPTION = r60_DESCRIPTION;
	}
	public BigDecimal getR60_All_TRANSACTIONS_INFLOWS() {
		return R60_All_TRANSACTIONS_INFLOWS;
	}
	public void setR60_All_TRANSACTIONS_INFLOWS(BigDecimal r60_All_TRANSACTIONS_INFLOWS) {
		R60_All_TRANSACTIONS_INFLOWS = r60_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR60_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R60_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR60_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r60_FINANCIAL_FREE_ZONE_INFLOWS) {
		R60_FINANCIAL_FREE_ZONE_INFLOWS = r60_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR60_TOTAL_INFLOWS() {
		return R60_TOTAL_INFLOWS;
	}
	public void setR60_TOTAL_INFLOWS(BigDecimal r60_TOTAL_INFLOWS) {
		R60_TOTAL_INFLOWS = r60_TOTAL_INFLOWS;
	}
	public BigDecimal getR60_All_TRANSACTIONS_OUTFLOWS() {
		return R60_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR60_All_TRANSACTIONS_OUTFLOWS(BigDecimal r60_All_TRANSACTIONS_OUTFLOWS) {
		R60_All_TRANSACTIONS_OUTFLOWS = r60_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR60_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R60_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR60_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r60_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R60_FINANCIAL_FREE_ZONE_OUTFLOWS = r60_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR60_TOTAL_OUTFLOWS() {
		return R60_TOTAL_OUTFLOWS;
	}
	public void setR60_TOTAL_OUTFLOWS(BigDecimal r60_TOTAL_OUTFLOWS) {
		R60_TOTAL_OUTFLOWS = r60_TOTAL_OUTFLOWS;
	}
	public String getR61_S_NO() {
		return R61_S_NO;
	}
	public void setR61_S_NO(String r61_S_NO) {
		R61_S_NO = r61_S_NO;
	}
	public String getR61_SWIFT_PAYMENT() {
		return R61_SWIFT_PAYMENT;
	}
	public void setR61_SWIFT_PAYMENT(String r61_SWIFT_PAYMENT) {
		R61_SWIFT_PAYMENT = r61_SWIFT_PAYMENT;
	}
	public String getR61_DESCRIPTION() {
		return R61_DESCRIPTION;
	}
	public void setR61_DESCRIPTION(String r61_DESCRIPTION) {
		R61_DESCRIPTION = r61_DESCRIPTION;
	}
	public BigDecimal getR61_All_TRANSACTIONS_INFLOWS() {
		return R61_All_TRANSACTIONS_INFLOWS;
	}
	public void setR61_All_TRANSACTIONS_INFLOWS(BigDecimal r61_All_TRANSACTIONS_INFLOWS) {
		R61_All_TRANSACTIONS_INFLOWS = r61_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR61_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R61_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR61_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r61_FINANCIAL_FREE_ZONE_INFLOWS) {
		R61_FINANCIAL_FREE_ZONE_INFLOWS = r61_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR61_TOTAL_INFLOWS() {
		return R61_TOTAL_INFLOWS;
	}
	public void setR61_TOTAL_INFLOWS(BigDecimal r61_TOTAL_INFLOWS) {
		R61_TOTAL_INFLOWS = r61_TOTAL_INFLOWS;
	}
	public BigDecimal getR61_All_TRANSACTIONS_OUTFLOWS() {
		return R61_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR61_All_TRANSACTIONS_OUTFLOWS(BigDecimal r61_All_TRANSACTIONS_OUTFLOWS) {
		R61_All_TRANSACTIONS_OUTFLOWS = r61_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR61_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R61_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR61_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r61_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R61_FINANCIAL_FREE_ZONE_OUTFLOWS = r61_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR61_TOTAL_OUTFLOWS() {
		return R61_TOTAL_OUTFLOWS;
	}
	public void setR61_TOTAL_OUTFLOWS(BigDecimal r61_TOTAL_OUTFLOWS) {
		R61_TOTAL_OUTFLOWS = r61_TOTAL_OUTFLOWS;
	}
	public String getR62_S_NO() {
		return R62_S_NO;
	}
	public void setR62_S_NO(String r62_S_NO) {
		R62_S_NO = r62_S_NO;
	}
	public String getR62_SWIFT_PAYMENT() {
		return R62_SWIFT_PAYMENT;
	}
	public void setR62_SWIFT_PAYMENT(String r62_SWIFT_PAYMENT) {
		R62_SWIFT_PAYMENT = r62_SWIFT_PAYMENT;
	}
	public String getR62_DESCRIPTION() {
		return R62_DESCRIPTION;
	}
	public void setR62_DESCRIPTION(String r62_DESCRIPTION) {
		R62_DESCRIPTION = r62_DESCRIPTION;
	}
	public BigDecimal getR62_All_TRANSACTIONS_INFLOWS() {
		return R62_All_TRANSACTIONS_INFLOWS;
	}
	public void setR62_All_TRANSACTIONS_INFLOWS(BigDecimal r62_All_TRANSACTIONS_INFLOWS) {
		R62_All_TRANSACTIONS_INFLOWS = r62_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR62_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R62_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR62_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r62_FINANCIAL_FREE_ZONE_INFLOWS) {
		R62_FINANCIAL_FREE_ZONE_INFLOWS = r62_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR62_TOTAL_INFLOWS() {
		return R62_TOTAL_INFLOWS;
	}
	public void setR62_TOTAL_INFLOWS(BigDecimal r62_TOTAL_INFLOWS) {
		R62_TOTAL_INFLOWS = r62_TOTAL_INFLOWS;
	}
	public BigDecimal getR62_All_TRANSACTIONS_OUTFLOWS() {
		return R62_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR62_All_TRANSACTIONS_OUTFLOWS(BigDecimal r62_All_TRANSACTIONS_OUTFLOWS) {
		R62_All_TRANSACTIONS_OUTFLOWS = r62_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR62_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R62_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR62_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r62_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R62_FINANCIAL_FREE_ZONE_OUTFLOWS = r62_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR62_TOTAL_OUTFLOWS() {
		return R62_TOTAL_OUTFLOWS;
	}
	public void setR62_TOTAL_OUTFLOWS(BigDecimal r62_TOTAL_OUTFLOWS) {
		R62_TOTAL_OUTFLOWS = r62_TOTAL_OUTFLOWS;
	}
	public String getR63_S_NO() {
		return R63_S_NO;
	}
	public void setR63_S_NO(String r63_S_NO) {
		R63_S_NO = r63_S_NO;
	}
	public String getR63_SWIFT_PAYMENT() {
		return R63_SWIFT_PAYMENT;
	}
	public void setR63_SWIFT_PAYMENT(String r63_SWIFT_PAYMENT) {
		R63_SWIFT_PAYMENT = r63_SWIFT_PAYMENT;
	}
	public String getR63_DESCRIPTION() {
		return R63_DESCRIPTION;
	}
	public void setR63_DESCRIPTION(String r63_DESCRIPTION) {
		R63_DESCRIPTION = r63_DESCRIPTION;
	}
	public BigDecimal getR63_All_TRANSACTIONS_INFLOWS() {
		return R63_All_TRANSACTIONS_INFLOWS;
	}
	public void setR63_All_TRANSACTIONS_INFLOWS(BigDecimal r63_All_TRANSACTIONS_INFLOWS) {
		R63_All_TRANSACTIONS_INFLOWS = r63_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR63_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R63_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR63_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r63_FINANCIAL_FREE_ZONE_INFLOWS) {
		R63_FINANCIAL_FREE_ZONE_INFLOWS = r63_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR63_TOTAL_INFLOWS() {
		return R63_TOTAL_INFLOWS;
	}
	public void setR63_TOTAL_INFLOWS(BigDecimal r63_TOTAL_INFLOWS) {
		R63_TOTAL_INFLOWS = r63_TOTAL_INFLOWS;
	}
	public BigDecimal getR63_All_TRANSACTIONS_OUTFLOWS() {
		return R63_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR63_All_TRANSACTIONS_OUTFLOWS(BigDecimal r63_All_TRANSACTIONS_OUTFLOWS) {
		R63_All_TRANSACTIONS_OUTFLOWS = r63_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR63_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R63_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR63_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r63_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R63_FINANCIAL_FREE_ZONE_OUTFLOWS = r63_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR63_TOTAL_OUTFLOWS() {
		return R63_TOTAL_OUTFLOWS;
	}
	public void setR63_TOTAL_OUTFLOWS(BigDecimal r63_TOTAL_OUTFLOWS) {
		R63_TOTAL_OUTFLOWS = r63_TOTAL_OUTFLOWS;
	}
	public String getR64_S_NO() {
		return R64_S_NO;
	}
	public void setR64_S_NO(String r64_S_NO) {
		R64_S_NO = r64_S_NO;
	}
	public String getR64_SWIFT_PAYMENT() {
		return R64_SWIFT_PAYMENT;
	}
	public void setR64_SWIFT_PAYMENT(String r64_SWIFT_PAYMENT) {
		R64_SWIFT_PAYMENT = r64_SWIFT_PAYMENT;
	}
	public String getR64_DESCRIPTION() {
		return R64_DESCRIPTION;
	}
	public void setR64_DESCRIPTION(String r64_DESCRIPTION) {
		R64_DESCRIPTION = r64_DESCRIPTION;
	}
	public BigDecimal getR64_All_TRANSACTIONS_INFLOWS() {
		return R64_All_TRANSACTIONS_INFLOWS;
	}
	public void setR64_All_TRANSACTIONS_INFLOWS(BigDecimal r64_All_TRANSACTIONS_INFLOWS) {
		R64_All_TRANSACTIONS_INFLOWS = r64_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR64_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R64_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR64_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r64_FINANCIAL_FREE_ZONE_INFLOWS) {
		R64_FINANCIAL_FREE_ZONE_INFLOWS = r64_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR64_TOTAL_INFLOWS() {
		return R64_TOTAL_INFLOWS;
	}
	public void setR64_TOTAL_INFLOWS(BigDecimal r64_TOTAL_INFLOWS) {
		R64_TOTAL_INFLOWS = r64_TOTAL_INFLOWS;
	}
	public BigDecimal getR64_All_TRANSACTIONS_OUTFLOWS() {
		return R64_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR64_All_TRANSACTIONS_OUTFLOWS(BigDecimal r64_All_TRANSACTIONS_OUTFLOWS) {
		R64_All_TRANSACTIONS_OUTFLOWS = r64_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR64_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R64_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR64_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r64_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R64_FINANCIAL_FREE_ZONE_OUTFLOWS = r64_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR64_TOTAL_OUTFLOWS() {
		return R64_TOTAL_OUTFLOWS;
	}
	public void setR64_TOTAL_OUTFLOWS(BigDecimal r64_TOTAL_OUTFLOWS) {
		R64_TOTAL_OUTFLOWS = r64_TOTAL_OUTFLOWS;
	}
	public String getR65_S_NO() {
		return R65_S_NO;
	}
	public void setR65_S_NO(String r65_S_NO) {
		R65_S_NO = r65_S_NO;
	}
	public String getR65_SWIFT_PAYMENT() {
		return R65_SWIFT_PAYMENT;
	}
	public void setR65_SWIFT_PAYMENT(String r65_SWIFT_PAYMENT) {
		R65_SWIFT_PAYMENT = r65_SWIFT_PAYMENT;
	}
	public String getR65_DESCRIPTION() {
		return R65_DESCRIPTION;
	}
	public void setR65_DESCRIPTION(String r65_DESCRIPTION) {
		R65_DESCRIPTION = r65_DESCRIPTION;
	}
	public BigDecimal getR65_All_TRANSACTIONS_INFLOWS() {
		return R65_All_TRANSACTIONS_INFLOWS;
	}
	public void setR65_All_TRANSACTIONS_INFLOWS(BigDecimal r65_All_TRANSACTIONS_INFLOWS) {
		R65_All_TRANSACTIONS_INFLOWS = r65_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR65_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R65_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR65_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r65_FINANCIAL_FREE_ZONE_INFLOWS) {
		R65_FINANCIAL_FREE_ZONE_INFLOWS = r65_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR65_TOTAL_INFLOWS() {
		return R65_TOTAL_INFLOWS;
	}
	public void setR65_TOTAL_INFLOWS(BigDecimal r65_TOTAL_INFLOWS) {
		R65_TOTAL_INFLOWS = r65_TOTAL_INFLOWS;
	}
	public BigDecimal getR65_All_TRANSACTIONS_OUTFLOWS() {
		return R65_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR65_All_TRANSACTIONS_OUTFLOWS(BigDecimal r65_All_TRANSACTIONS_OUTFLOWS) {
		R65_All_TRANSACTIONS_OUTFLOWS = r65_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR65_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R65_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR65_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r65_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R65_FINANCIAL_FREE_ZONE_OUTFLOWS = r65_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR65_TOTAL_OUTFLOWS() {
		return R65_TOTAL_OUTFLOWS;
	}
	public void setR65_TOTAL_OUTFLOWS(BigDecimal r65_TOTAL_OUTFLOWS) {
		R65_TOTAL_OUTFLOWS = r65_TOTAL_OUTFLOWS;
	}
	public String getR66_S_NO() {
		return R66_S_NO;
	}
	public void setR66_S_NO(String r66_S_NO) {
		R66_S_NO = r66_S_NO;
	}
	public String getR66_SWIFT_PAYMENT() {
		return R66_SWIFT_PAYMENT;
	}
	public void setR66_SWIFT_PAYMENT(String r66_SWIFT_PAYMENT) {
		R66_SWIFT_PAYMENT = r66_SWIFT_PAYMENT;
	}
	public String getR66_DESCRIPTION() {
		return R66_DESCRIPTION;
	}
	public void setR66_DESCRIPTION(String r66_DESCRIPTION) {
		R66_DESCRIPTION = r66_DESCRIPTION;
	}
	public BigDecimal getR66_All_TRANSACTIONS_INFLOWS() {
		return R66_All_TRANSACTIONS_INFLOWS;
	}
	public void setR66_All_TRANSACTIONS_INFLOWS(BigDecimal r66_All_TRANSACTIONS_INFLOWS) {
		R66_All_TRANSACTIONS_INFLOWS = r66_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR66_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R66_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR66_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r66_FINANCIAL_FREE_ZONE_INFLOWS) {
		R66_FINANCIAL_FREE_ZONE_INFLOWS = r66_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR66_TOTAL_INFLOWS() {
		return R66_TOTAL_INFLOWS;
	}
	public void setR66_TOTAL_INFLOWS(BigDecimal r66_TOTAL_INFLOWS) {
		R66_TOTAL_INFLOWS = r66_TOTAL_INFLOWS;
	}
	public BigDecimal getR66_All_TRANSACTIONS_OUTFLOWS() {
		return R66_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR66_All_TRANSACTIONS_OUTFLOWS(BigDecimal r66_All_TRANSACTIONS_OUTFLOWS) {
		R66_All_TRANSACTIONS_OUTFLOWS = r66_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR66_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R66_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR66_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r66_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R66_FINANCIAL_FREE_ZONE_OUTFLOWS = r66_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR66_TOTAL_OUTFLOWS() {
		return R66_TOTAL_OUTFLOWS;
	}
	public void setR66_TOTAL_OUTFLOWS(BigDecimal r66_TOTAL_OUTFLOWS) {
		R66_TOTAL_OUTFLOWS = r66_TOTAL_OUTFLOWS;
	}
	public String getR67_S_NO() {
		return R67_S_NO;
	}
	public void setR67_S_NO(String r67_S_NO) {
		R67_S_NO = r67_S_NO;
	}
	public String getR67_SWIFT_PAYMENT() {
		return R67_SWIFT_PAYMENT;
	}
	public void setR67_SWIFT_PAYMENT(String r67_SWIFT_PAYMENT) {
		R67_SWIFT_PAYMENT = r67_SWIFT_PAYMENT;
	}
	public String getR67_DESCRIPTION() {
		return R67_DESCRIPTION;
	}
	public void setR67_DESCRIPTION(String r67_DESCRIPTION) {
		R67_DESCRIPTION = r67_DESCRIPTION;
	}
	public BigDecimal getR67_All_TRANSACTIONS_INFLOWS() {
		return R67_All_TRANSACTIONS_INFLOWS;
	}
	public void setR67_All_TRANSACTIONS_INFLOWS(BigDecimal r67_All_TRANSACTIONS_INFLOWS) {
		R67_All_TRANSACTIONS_INFLOWS = r67_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR67_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R67_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR67_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r67_FINANCIAL_FREE_ZONE_INFLOWS) {
		R67_FINANCIAL_FREE_ZONE_INFLOWS = r67_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR67_TOTAL_INFLOWS() {
		return R67_TOTAL_INFLOWS;
	}
	public void setR67_TOTAL_INFLOWS(BigDecimal r67_TOTAL_INFLOWS) {
		R67_TOTAL_INFLOWS = r67_TOTAL_INFLOWS;
	}
	public BigDecimal getR67_All_TRANSACTIONS_OUTFLOWS() {
		return R67_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR67_All_TRANSACTIONS_OUTFLOWS(BigDecimal r67_All_TRANSACTIONS_OUTFLOWS) {
		R67_All_TRANSACTIONS_OUTFLOWS = r67_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR67_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R67_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR67_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r67_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R67_FINANCIAL_FREE_ZONE_OUTFLOWS = r67_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR67_TOTAL_OUTFLOWS() {
		return R67_TOTAL_OUTFLOWS;
	}
	public void setR67_TOTAL_OUTFLOWS(BigDecimal r67_TOTAL_OUTFLOWS) {
		R67_TOTAL_OUTFLOWS = r67_TOTAL_OUTFLOWS;
	}
	public String getR68_S_NO() {
		return R68_S_NO;
	}
	public void setR68_S_NO(String r68_S_NO) {
		R68_S_NO = r68_S_NO;
	}
	public String getR68_SWIFT_PAYMENT() {
		return R68_SWIFT_PAYMENT;
	}
	public void setR68_SWIFT_PAYMENT(String r68_SWIFT_PAYMENT) {
		R68_SWIFT_PAYMENT = r68_SWIFT_PAYMENT;
	}
	public String getR68_DESCRIPTION() {
		return R68_DESCRIPTION;
	}
	public void setR68_DESCRIPTION(String r68_DESCRIPTION) {
		R68_DESCRIPTION = r68_DESCRIPTION;
	}
	public BigDecimal getR68_All_TRANSACTIONS_INFLOWS() {
		return R68_All_TRANSACTIONS_INFLOWS;
	}
	public void setR68_All_TRANSACTIONS_INFLOWS(BigDecimal r68_All_TRANSACTIONS_INFLOWS) {
		R68_All_TRANSACTIONS_INFLOWS = r68_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR68_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R68_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR68_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r68_FINANCIAL_FREE_ZONE_INFLOWS) {
		R68_FINANCIAL_FREE_ZONE_INFLOWS = r68_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR68_TOTAL_INFLOWS() {
		return R68_TOTAL_INFLOWS;
	}
	public void setR68_TOTAL_INFLOWS(BigDecimal r68_TOTAL_INFLOWS) {
		R68_TOTAL_INFLOWS = r68_TOTAL_INFLOWS;
	}
	public BigDecimal getR68_All_TRANSACTIONS_OUTFLOWS() {
		return R68_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR68_All_TRANSACTIONS_OUTFLOWS(BigDecimal r68_All_TRANSACTIONS_OUTFLOWS) {
		R68_All_TRANSACTIONS_OUTFLOWS = r68_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR68_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R68_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR68_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r68_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R68_FINANCIAL_FREE_ZONE_OUTFLOWS = r68_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR68_TOTAL_OUTFLOWS() {
		return R68_TOTAL_OUTFLOWS;
	}
	public void setR68_TOTAL_OUTFLOWS(BigDecimal r68_TOTAL_OUTFLOWS) {
		R68_TOTAL_OUTFLOWS = r68_TOTAL_OUTFLOWS;
	}
	public String getR69_S_NO() {
		return R69_S_NO;
	}
	public void setR69_S_NO(String r69_S_NO) {
		R69_S_NO = r69_S_NO;
	}
	public String getR69_SWIFT_PAYMENT() {
		return R69_SWIFT_PAYMENT;
	}
	public void setR69_SWIFT_PAYMENT(String r69_SWIFT_PAYMENT) {
		R69_SWIFT_PAYMENT = r69_SWIFT_PAYMENT;
	}
	public String getR69_DESCRIPTION() {
		return R69_DESCRIPTION;
	}
	public void setR69_DESCRIPTION(String r69_DESCRIPTION) {
		R69_DESCRIPTION = r69_DESCRIPTION;
	}
	public BigDecimal getR69_All_TRANSACTIONS_INFLOWS() {
		return R69_All_TRANSACTIONS_INFLOWS;
	}
	public void setR69_All_TRANSACTIONS_INFLOWS(BigDecimal r69_All_TRANSACTIONS_INFLOWS) {
		R69_All_TRANSACTIONS_INFLOWS = r69_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR69_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R69_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR69_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r69_FINANCIAL_FREE_ZONE_INFLOWS) {
		R69_FINANCIAL_FREE_ZONE_INFLOWS = r69_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR69_TOTAL_INFLOWS() {
		return R69_TOTAL_INFLOWS;
	}
	public void setR69_TOTAL_INFLOWS(BigDecimal r69_TOTAL_INFLOWS) {
		R69_TOTAL_INFLOWS = r69_TOTAL_INFLOWS;
	}
	public BigDecimal getR69_All_TRANSACTIONS_OUTFLOWS() {
		return R69_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR69_All_TRANSACTIONS_OUTFLOWS(BigDecimal r69_All_TRANSACTIONS_OUTFLOWS) {
		R69_All_TRANSACTIONS_OUTFLOWS = r69_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR69_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R69_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR69_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r69_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R69_FINANCIAL_FREE_ZONE_OUTFLOWS = r69_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR69_TOTAL_OUTFLOWS() {
		return R69_TOTAL_OUTFLOWS;
	}
	public void setR69_TOTAL_OUTFLOWS(BigDecimal r69_TOTAL_OUTFLOWS) {
		R69_TOTAL_OUTFLOWS = r69_TOTAL_OUTFLOWS;
	}
	public String getR70_S_NO() {
		return R70_S_NO;
	}
	public void setR70_S_NO(String r70_S_NO) {
		R70_S_NO = r70_S_NO;
	}
	public String getR70_SWIFT_PAYMENT() {
		return R70_SWIFT_PAYMENT;
	}
	public void setR70_SWIFT_PAYMENT(String r70_SWIFT_PAYMENT) {
		R70_SWIFT_PAYMENT = r70_SWIFT_PAYMENT;
	}
	public String getR70_DESCRIPTION() {
		return R70_DESCRIPTION;
	}
	public void setR70_DESCRIPTION(String r70_DESCRIPTION) {
		R70_DESCRIPTION = r70_DESCRIPTION;
	}
	public BigDecimal getR70_All_TRANSACTIONS_INFLOWS() {
		return R70_All_TRANSACTIONS_INFLOWS;
	}
	public void setR70_All_TRANSACTIONS_INFLOWS(BigDecimal r70_All_TRANSACTIONS_INFLOWS) {
		R70_All_TRANSACTIONS_INFLOWS = r70_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR70_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R70_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR70_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r70_FINANCIAL_FREE_ZONE_INFLOWS) {
		R70_FINANCIAL_FREE_ZONE_INFLOWS = r70_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR70_TOTAL_INFLOWS() {
		return R70_TOTAL_INFLOWS;
	}
	public void setR70_TOTAL_INFLOWS(BigDecimal r70_TOTAL_INFLOWS) {
		R70_TOTAL_INFLOWS = r70_TOTAL_INFLOWS;
	}
	public BigDecimal getR70_All_TRANSACTIONS_OUTFLOWS() {
		return R70_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR70_All_TRANSACTIONS_OUTFLOWS(BigDecimal r70_All_TRANSACTIONS_OUTFLOWS) {
		R70_All_TRANSACTIONS_OUTFLOWS = r70_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR70_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R70_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR70_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r70_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R70_FINANCIAL_FREE_ZONE_OUTFLOWS = r70_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR70_TOTAL_OUTFLOWS() {
		return R70_TOTAL_OUTFLOWS;
	}
	public void setR70_TOTAL_OUTFLOWS(BigDecimal r70_TOTAL_OUTFLOWS) {
		R70_TOTAL_OUTFLOWS = r70_TOTAL_OUTFLOWS;
	}
	public String getR71_S_NO() {
		return R71_S_NO;
	}
	public void setR71_S_NO(String r71_S_NO) {
		R71_S_NO = r71_S_NO;
	}
	public String getR71_SWIFT_PAYMENT() {
		return R71_SWIFT_PAYMENT;
	}
	public void setR71_SWIFT_PAYMENT(String r71_SWIFT_PAYMENT) {
		R71_SWIFT_PAYMENT = r71_SWIFT_PAYMENT;
	}
	public String getR71_DESCRIPTION() {
		return R71_DESCRIPTION;
	}
	public void setR71_DESCRIPTION(String r71_DESCRIPTION) {
		R71_DESCRIPTION = r71_DESCRIPTION;
	}
	public BigDecimal getR71_All_TRANSACTIONS_INFLOWS() {
		return R71_All_TRANSACTIONS_INFLOWS;
	}
	public void setR71_All_TRANSACTIONS_INFLOWS(BigDecimal r71_All_TRANSACTIONS_INFLOWS) {
		R71_All_TRANSACTIONS_INFLOWS = r71_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR71_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R71_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR71_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r71_FINANCIAL_FREE_ZONE_INFLOWS) {
		R71_FINANCIAL_FREE_ZONE_INFLOWS = r71_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR71_TOTAL_INFLOWS() {
		return R71_TOTAL_INFLOWS;
	}
	public void setR71_TOTAL_INFLOWS(BigDecimal r71_TOTAL_INFLOWS) {
		R71_TOTAL_INFLOWS = r71_TOTAL_INFLOWS;
	}
	public BigDecimal getR71_All_TRANSACTIONS_OUTFLOWS() {
		return R71_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR71_All_TRANSACTIONS_OUTFLOWS(BigDecimal r71_All_TRANSACTIONS_OUTFLOWS) {
		R71_All_TRANSACTIONS_OUTFLOWS = r71_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR71_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R71_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR71_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r71_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R71_FINANCIAL_FREE_ZONE_OUTFLOWS = r71_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR71_TOTAL_OUTFLOWS() {
		return R71_TOTAL_OUTFLOWS;
	}
	public void setR71_TOTAL_OUTFLOWS(BigDecimal r71_TOTAL_OUTFLOWS) {
		R71_TOTAL_OUTFLOWS = r71_TOTAL_OUTFLOWS;
	}
	public String getR72_S_NO() {
		return R72_S_NO;
	}
	public void setR72_S_NO(String r72_S_NO) {
		R72_S_NO = r72_S_NO;
	}
	public String getR72_SWIFT_PAYMENT() {
		return R72_SWIFT_PAYMENT;
	}
	public void setR72_SWIFT_PAYMENT(String r72_SWIFT_PAYMENT) {
		R72_SWIFT_PAYMENT = r72_SWIFT_PAYMENT;
	}
	public String getR72_DESCRIPTION() {
		return R72_DESCRIPTION;
	}
	public void setR72_DESCRIPTION(String r72_DESCRIPTION) {
		R72_DESCRIPTION = r72_DESCRIPTION;
	}
	public BigDecimal getR72_All_TRANSACTIONS_INFLOWS() {
		return R72_All_TRANSACTIONS_INFLOWS;
	}
	public void setR72_All_TRANSACTIONS_INFLOWS(BigDecimal r72_All_TRANSACTIONS_INFLOWS) {
		R72_All_TRANSACTIONS_INFLOWS = r72_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR72_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R72_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR72_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r72_FINANCIAL_FREE_ZONE_INFLOWS) {
		R72_FINANCIAL_FREE_ZONE_INFLOWS = r72_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR72_TOTAL_INFLOWS() {
		return R72_TOTAL_INFLOWS;
	}
	public void setR72_TOTAL_INFLOWS(BigDecimal r72_TOTAL_INFLOWS) {
		R72_TOTAL_INFLOWS = r72_TOTAL_INFLOWS;
	}
	public BigDecimal getR72_All_TRANSACTIONS_OUTFLOWS() {
		return R72_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR72_All_TRANSACTIONS_OUTFLOWS(BigDecimal r72_All_TRANSACTIONS_OUTFLOWS) {
		R72_All_TRANSACTIONS_OUTFLOWS = r72_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR72_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R72_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR72_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r72_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R72_FINANCIAL_FREE_ZONE_OUTFLOWS = r72_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR72_TOTAL_OUTFLOWS() {
		return R72_TOTAL_OUTFLOWS;
	}
	public void setR72_TOTAL_OUTFLOWS(BigDecimal r72_TOTAL_OUTFLOWS) {
		R72_TOTAL_OUTFLOWS = r72_TOTAL_OUTFLOWS;
	}
	public String getR73_S_NO() {
		return R73_S_NO;
	}
	public void setR73_S_NO(String r73_S_NO) {
		R73_S_NO = r73_S_NO;
	}
	public String getR73_SWIFT_PAYMENT() {
		return R73_SWIFT_PAYMENT;
	}
	public void setR73_SWIFT_PAYMENT(String r73_SWIFT_PAYMENT) {
		R73_SWIFT_PAYMENT = r73_SWIFT_PAYMENT;
	}
	public String getR73_DESCRIPTION() {
		return R73_DESCRIPTION;
	}
	public void setR73_DESCRIPTION(String r73_DESCRIPTION) {
		R73_DESCRIPTION = r73_DESCRIPTION;
	}
	public BigDecimal getR73_All_TRANSACTIONS_INFLOWS() {
		return R73_All_TRANSACTIONS_INFLOWS;
	}
	public void setR73_All_TRANSACTIONS_INFLOWS(BigDecimal r73_All_TRANSACTIONS_INFLOWS) {
		R73_All_TRANSACTIONS_INFLOWS = r73_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR73_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R73_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR73_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r73_FINANCIAL_FREE_ZONE_INFLOWS) {
		R73_FINANCIAL_FREE_ZONE_INFLOWS = r73_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR73_TOTAL_INFLOWS() {
		return R73_TOTAL_INFLOWS;
	}
	public void setR73_TOTAL_INFLOWS(BigDecimal r73_TOTAL_INFLOWS) {
		R73_TOTAL_INFLOWS = r73_TOTAL_INFLOWS;
	}
	public BigDecimal getR73_All_TRANSACTIONS_OUTFLOWS() {
		return R73_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR73_All_TRANSACTIONS_OUTFLOWS(BigDecimal r73_All_TRANSACTIONS_OUTFLOWS) {
		R73_All_TRANSACTIONS_OUTFLOWS = r73_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR73_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R73_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR73_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r73_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R73_FINANCIAL_FREE_ZONE_OUTFLOWS = r73_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR73_TOTAL_OUTFLOWS() {
		return R73_TOTAL_OUTFLOWS;
	}
	public void setR73_TOTAL_OUTFLOWS(BigDecimal r73_TOTAL_OUTFLOWS) {
		R73_TOTAL_OUTFLOWS = r73_TOTAL_OUTFLOWS;
	}
	public String getR74_S_NO() {
		return R74_S_NO;
	}
	public void setR74_S_NO(String r74_S_NO) {
		R74_S_NO = r74_S_NO;
	}
	public String getR74_SWIFT_PAYMENT() {
		return R74_SWIFT_PAYMENT;
	}
	public void setR74_SWIFT_PAYMENT(String r74_SWIFT_PAYMENT) {
		R74_SWIFT_PAYMENT = r74_SWIFT_PAYMENT;
	}
	public String getR74_DESCRIPTION() {
		return R74_DESCRIPTION;
	}
	public void setR74_DESCRIPTION(String r74_DESCRIPTION) {
		R74_DESCRIPTION = r74_DESCRIPTION;
	}
	public BigDecimal getR74_All_TRANSACTIONS_INFLOWS() {
		return R74_All_TRANSACTIONS_INFLOWS;
	}
	public void setR74_All_TRANSACTIONS_INFLOWS(BigDecimal r74_All_TRANSACTIONS_INFLOWS) {
		R74_All_TRANSACTIONS_INFLOWS = r74_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR74_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R74_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR74_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r74_FINANCIAL_FREE_ZONE_INFLOWS) {
		R74_FINANCIAL_FREE_ZONE_INFLOWS = r74_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR74_TOTAL_INFLOWS() {
		return R74_TOTAL_INFLOWS;
	}
	public void setR74_TOTAL_INFLOWS(BigDecimal r74_TOTAL_INFLOWS) {
		R74_TOTAL_INFLOWS = r74_TOTAL_INFLOWS;
	}
	public BigDecimal getR74_All_TRANSACTIONS_OUTFLOWS() {
		return R74_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR74_All_TRANSACTIONS_OUTFLOWS(BigDecimal r74_All_TRANSACTIONS_OUTFLOWS) {
		R74_All_TRANSACTIONS_OUTFLOWS = r74_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR74_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R74_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR74_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r74_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R74_FINANCIAL_FREE_ZONE_OUTFLOWS = r74_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR74_TOTAL_OUTFLOWS() {
		return R74_TOTAL_OUTFLOWS;
	}
	public void setR74_TOTAL_OUTFLOWS(BigDecimal r74_TOTAL_OUTFLOWS) {
		R74_TOTAL_OUTFLOWS = r74_TOTAL_OUTFLOWS;
	}
	public String getR75_S_NO() {
		return R75_S_NO;
	}
	public void setR75_S_NO(String r75_S_NO) {
		R75_S_NO = r75_S_NO;
	}
	public String getR75_SWIFT_PAYMENT() {
		return R75_SWIFT_PAYMENT;
	}
	public void setR75_SWIFT_PAYMENT(String r75_SWIFT_PAYMENT) {
		R75_SWIFT_PAYMENT = r75_SWIFT_PAYMENT;
	}
	public String getR75_DESCRIPTION() {
		return R75_DESCRIPTION;
	}
	public void setR75_DESCRIPTION(String r75_DESCRIPTION) {
		R75_DESCRIPTION = r75_DESCRIPTION;
	}
	public BigDecimal getR75_All_TRANSACTIONS_INFLOWS() {
		return R75_All_TRANSACTIONS_INFLOWS;
	}
	public void setR75_All_TRANSACTIONS_INFLOWS(BigDecimal r75_All_TRANSACTIONS_INFLOWS) {
		R75_All_TRANSACTIONS_INFLOWS = r75_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR75_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R75_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR75_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r75_FINANCIAL_FREE_ZONE_INFLOWS) {
		R75_FINANCIAL_FREE_ZONE_INFLOWS = r75_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR75_TOTAL_INFLOWS() {
		return R75_TOTAL_INFLOWS;
	}
	public void setR75_TOTAL_INFLOWS(BigDecimal r75_TOTAL_INFLOWS) {
		R75_TOTAL_INFLOWS = r75_TOTAL_INFLOWS;
	}
	public BigDecimal getR75_All_TRANSACTIONS_OUTFLOWS() {
		return R75_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR75_All_TRANSACTIONS_OUTFLOWS(BigDecimal r75_All_TRANSACTIONS_OUTFLOWS) {
		R75_All_TRANSACTIONS_OUTFLOWS = r75_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR75_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R75_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR75_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r75_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R75_FINANCIAL_FREE_ZONE_OUTFLOWS = r75_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR75_TOTAL_OUTFLOWS() {
		return R75_TOTAL_OUTFLOWS;
	}
	public void setR75_TOTAL_OUTFLOWS(BigDecimal r75_TOTAL_OUTFLOWS) {
		R75_TOTAL_OUTFLOWS = r75_TOTAL_OUTFLOWS;
	}
	public String getR76_S_NO() {
		return R76_S_NO;
	}
	public void setR76_S_NO(String r76_S_NO) {
		R76_S_NO = r76_S_NO;
	}
	public String getR76_SWIFT_PAYMENT() {
		return R76_SWIFT_PAYMENT;
	}
	public void setR76_SWIFT_PAYMENT(String r76_SWIFT_PAYMENT) {
		R76_SWIFT_PAYMENT = r76_SWIFT_PAYMENT;
	}
	public String getR76_DESCRIPTION() {
		return R76_DESCRIPTION;
	}
	public void setR76_DESCRIPTION(String r76_DESCRIPTION) {
		R76_DESCRIPTION = r76_DESCRIPTION;
	}
	public BigDecimal getR76_All_TRANSACTIONS_INFLOWS() {
		return R76_All_TRANSACTIONS_INFLOWS;
	}
	public void setR76_All_TRANSACTIONS_INFLOWS(BigDecimal r76_All_TRANSACTIONS_INFLOWS) {
		R76_All_TRANSACTIONS_INFLOWS = r76_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR76_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R76_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR76_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r76_FINANCIAL_FREE_ZONE_INFLOWS) {
		R76_FINANCIAL_FREE_ZONE_INFLOWS = r76_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR76_TOTAL_INFLOWS() {
		return R76_TOTAL_INFLOWS;
	}
	public void setR76_TOTAL_INFLOWS(BigDecimal r76_TOTAL_INFLOWS) {
		R76_TOTAL_INFLOWS = r76_TOTAL_INFLOWS;
	}
	public BigDecimal getR76_All_TRANSACTIONS_OUTFLOWS() {
		return R76_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR76_All_TRANSACTIONS_OUTFLOWS(BigDecimal r76_All_TRANSACTIONS_OUTFLOWS) {
		R76_All_TRANSACTIONS_OUTFLOWS = r76_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR76_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R76_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR76_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r76_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R76_FINANCIAL_FREE_ZONE_OUTFLOWS = r76_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR76_TOTAL_OUTFLOWS() {
		return R76_TOTAL_OUTFLOWS;
	}
	public void setR76_TOTAL_OUTFLOWS(BigDecimal r76_TOTAL_OUTFLOWS) {
		R76_TOTAL_OUTFLOWS = r76_TOTAL_OUTFLOWS;
	}
	public String getR77_S_NO() {
		return R77_S_NO;
	}
	public void setR77_S_NO(String r77_S_NO) {
		R77_S_NO = r77_S_NO;
	}
	public String getR77_SWIFT_PAYMENT() {
		return R77_SWIFT_PAYMENT;
	}
	public void setR77_SWIFT_PAYMENT(String r77_SWIFT_PAYMENT) {
		R77_SWIFT_PAYMENT = r77_SWIFT_PAYMENT;
	}
	public String getR77_DESCRIPTION() {
		return R77_DESCRIPTION;
	}
	public void setR77_DESCRIPTION(String r77_DESCRIPTION) {
		R77_DESCRIPTION = r77_DESCRIPTION;
	}
	public BigDecimal getR77_All_TRANSACTIONS_INFLOWS() {
		return R77_All_TRANSACTIONS_INFLOWS;
	}
	public void setR77_All_TRANSACTIONS_INFLOWS(BigDecimal r77_All_TRANSACTIONS_INFLOWS) {
		R77_All_TRANSACTIONS_INFLOWS = r77_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR77_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R77_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR77_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r77_FINANCIAL_FREE_ZONE_INFLOWS) {
		R77_FINANCIAL_FREE_ZONE_INFLOWS = r77_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR77_TOTAL_INFLOWS() {
		return R77_TOTAL_INFLOWS;
	}
	public void setR77_TOTAL_INFLOWS(BigDecimal r77_TOTAL_INFLOWS) {
		R77_TOTAL_INFLOWS = r77_TOTAL_INFLOWS;
	}
	public BigDecimal getR77_All_TRANSACTIONS_OUTFLOWS() {
		return R77_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR77_All_TRANSACTIONS_OUTFLOWS(BigDecimal r77_All_TRANSACTIONS_OUTFLOWS) {
		R77_All_TRANSACTIONS_OUTFLOWS = r77_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR77_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R77_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR77_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r77_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R77_FINANCIAL_FREE_ZONE_OUTFLOWS = r77_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR77_TOTAL_OUTFLOWS() {
		return R77_TOTAL_OUTFLOWS;
	}
	public void setR77_TOTAL_OUTFLOWS(BigDecimal r77_TOTAL_OUTFLOWS) {
		R77_TOTAL_OUTFLOWS = r77_TOTAL_OUTFLOWS;
	}
	public String getR78_S_NO() {
		return R78_S_NO;
	}
	public void setR78_S_NO(String r78_S_NO) {
		R78_S_NO = r78_S_NO;
	}
	public String getR78_SWIFT_PAYMENT() {
		return R78_SWIFT_PAYMENT;
	}
	public void setR78_SWIFT_PAYMENT(String r78_SWIFT_PAYMENT) {
		R78_SWIFT_PAYMENT = r78_SWIFT_PAYMENT;
	}
	public String getR78_DESCRIPTION() {
		return R78_DESCRIPTION;
	}
	public void setR78_DESCRIPTION(String r78_DESCRIPTION) {
		R78_DESCRIPTION = r78_DESCRIPTION;
	}
	public BigDecimal getR78_All_TRANSACTIONS_INFLOWS() {
		return R78_All_TRANSACTIONS_INFLOWS;
	}
	public void setR78_All_TRANSACTIONS_INFLOWS(BigDecimal r78_All_TRANSACTIONS_INFLOWS) {
		R78_All_TRANSACTIONS_INFLOWS = r78_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR78_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R78_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR78_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r78_FINANCIAL_FREE_ZONE_INFLOWS) {
		R78_FINANCIAL_FREE_ZONE_INFLOWS = r78_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR78_TOTAL_INFLOWS() {
		return R78_TOTAL_INFLOWS;
	}
	public void setR78_TOTAL_INFLOWS(BigDecimal r78_TOTAL_INFLOWS) {
		R78_TOTAL_INFLOWS = r78_TOTAL_INFLOWS;
	}
	public BigDecimal getR78_All_TRANSACTIONS_OUTFLOWS() {
		return R78_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR78_All_TRANSACTIONS_OUTFLOWS(BigDecimal r78_All_TRANSACTIONS_OUTFLOWS) {
		R78_All_TRANSACTIONS_OUTFLOWS = r78_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR78_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R78_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR78_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r78_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R78_FINANCIAL_FREE_ZONE_OUTFLOWS = r78_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR78_TOTAL_OUTFLOWS() {
		return R78_TOTAL_OUTFLOWS;
	}
	public void setR78_TOTAL_OUTFLOWS(BigDecimal r78_TOTAL_OUTFLOWS) {
		R78_TOTAL_OUTFLOWS = r78_TOTAL_OUTFLOWS;
	}
	public String getR79_S_NO() {
		return R79_S_NO;
	}
	public void setR79_S_NO(String r79_S_NO) {
		R79_S_NO = r79_S_NO;
	}
	public String getR79_SWIFT_PAYMENT() {
		return R79_SWIFT_PAYMENT;
	}
	public void setR79_SWIFT_PAYMENT(String r79_SWIFT_PAYMENT) {
		R79_SWIFT_PAYMENT = r79_SWIFT_PAYMENT;
	}
	public String getR79_DESCRIPTION() {
		return R79_DESCRIPTION;
	}
	public void setR79_DESCRIPTION(String r79_DESCRIPTION) {
		R79_DESCRIPTION = r79_DESCRIPTION;
	}
	public BigDecimal getR79_All_TRANSACTIONS_INFLOWS() {
		return R79_All_TRANSACTIONS_INFLOWS;
	}
	public void setR79_All_TRANSACTIONS_INFLOWS(BigDecimal r79_All_TRANSACTIONS_INFLOWS) {
		R79_All_TRANSACTIONS_INFLOWS = r79_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR79_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R79_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR79_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r79_FINANCIAL_FREE_ZONE_INFLOWS) {
		R79_FINANCIAL_FREE_ZONE_INFLOWS = r79_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR79_TOTAL_INFLOWS() {
		return R79_TOTAL_INFLOWS;
	}
	public void setR79_TOTAL_INFLOWS(BigDecimal r79_TOTAL_INFLOWS) {
		R79_TOTAL_INFLOWS = r79_TOTAL_INFLOWS;
	}
	public BigDecimal getR79_All_TRANSACTIONS_OUTFLOWS() {
		return R79_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR79_All_TRANSACTIONS_OUTFLOWS(BigDecimal r79_All_TRANSACTIONS_OUTFLOWS) {
		R79_All_TRANSACTIONS_OUTFLOWS = r79_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR79_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R79_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR79_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r79_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R79_FINANCIAL_FREE_ZONE_OUTFLOWS = r79_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR79_TOTAL_OUTFLOWS() {
		return R79_TOTAL_OUTFLOWS;
	}
	public void setR79_TOTAL_OUTFLOWS(BigDecimal r79_TOTAL_OUTFLOWS) {
		R79_TOTAL_OUTFLOWS = r79_TOTAL_OUTFLOWS;
	}
	public String getR80_S_NO() {
		return R80_S_NO;
	}
	public void setR80_S_NO(String r80_S_NO) {
		R80_S_NO = r80_S_NO;
	}
	public String getR80_SWIFT_PAYMENT() {
		return R80_SWIFT_PAYMENT;
	}
	public void setR80_SWIFT_PAYMENT(String r80_SWIFT_PAYMENT) {
		R80_SWIFT_PAYMENT = r80_SWIFT_PAYMENT;
	}
	public String getR80_DESCRIPTION() {
		return R80_DESCRIPTION;
	}
	public void setR80_DESCRIPTION(String r80_DESCRIPTION) {
		R80_DESCRIPTION = r80_DESCRIPTION;
	}
	public BigDecimal getR80_All_TRANSACTIONS_INFLOWS() {
		return R80_All_TRANSACTIONS_INFLOWS;
	}
	public void setR80_All_TRANSACTIONS_INFLOWS(BigDecimal r80_All_TRANSACTIONS_INFLOWS) {
		R80_All_TRANSACTIONS_INFLOWS = r80_All_TRANSACTIONS_INFLOWS;
	}
	public BigDecimal getR80_FINANCIAL_FREE_ZONE_INFLOWS() {
		return R80_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public void setR80_FINANCIAL_FREE_ZONE_INFLOWS(BigDecimal r80_FINANCIAL_FREE_ZONE_INFLOWS) {
		R80_FINANCIAL_FREE_ZONE_INFLOWS = r80_FINANCIAL_FREE_ZONE_INFLOWS;
	}
	public BigDecimal getR80_TOTAL_INFLOWS() {
		return R80_TOTAL_INFLOWS;
	}
	public void setR80_TOTAL_INFLOWS(BigDecimal r80_TOTAL_INFLOWS) {
		R80_TOTAL_INFLOWS = r80_TOTAL_INFLOWS;
	}
	public BigDecimal getR80_All_TRANSACTIONS_OUTFLOWS() {
		return R80_All_TRANSACTIONS_OUTFLOWS;
	}
	public void setR80_All_TRANSACTIONS_OUTFLOWS(BigDecimal r80_All_TRANSACTIONS_OUTFLOWS) {
		R80_All_TRANSACTIONS_OUTFLOWS = r80_All_TRANSACTIONS_OUTFLOWS;
	}
	public BigDecimal getR80_FINANCIAL_FREE_ZONE_OUTFLOWS() {
		return R80_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public void setR80_FINANCIAL_FREE_ZONE_OUTFLOWS(BigDecimal r80_FINANCIAL_FREE_ZONE_OUTFLOWS) {
		R80_FINANCIAL_FREE_ZONE_OUTFLOWS = r80_FINANCIAL_FREE_ZONE_OUTFLOWS;
	}
	public BigDecimal getR80_TOTAL_OUTFLOWS() {
		return R80_TOTAL_OUTFLOWS;
	}
	public void setR80_TOTAL_OUTFLOWS(BigDecimal r80_TOTAL_OUTFLOWS) {
		R80_TOTAL_OUTFLOWS = r80_TOTAL_OUTFLOWS;
	}
	public String getR81_S_NO() {
		return R81_S_NO;
	}
	public void setR81_S_NO(String r81_S_NO) {
		R81_S_NO = r81_S_NO;
	}
	public String getR81_DESCRIPTION() {
		return R81_DESCRIPTION;
	}
	public void setR81_DESCRIPTION(String r81_DESCRIPTION) {
		R81_DESCRIPTION = r81_DESCRIPTION;
	}
	public BigDecimal getR81_TOTAL_OUTFLOWS() {
		return R81_TOTAL_OUTFLOWS;
	}
	public void setR81_TOTAL_OUTFLOWS(BigDecimal r81_TOTAL_OUTFLOWS) {
		R81_TOTAL_OUTFLOWS = r81_TOTAL_OUTFLOWS;
	}
	public String getR82_S_NO() {
		return R82_S_NO;
	}
	public void setR82_S_NO(String r82_S_NO) {
		R82_S_NO = r82_S_NO;
	}
	public String getR82_DESCRIPTION() {
		return R82_DESCRIPTION;
	}
	public void setR82_DESCRIPTION(String r82_DESCRIPTION) {
		R82_DESCRIPTION = r82_DESCRIPTION;
	}
	public BigDecimal getR82_TOTAL_OUTFLOWS() {
		return R82_TOTAL_OUTFLOWS;
	}
	public void setR82_TOTAL_OUTFLOWS(BigDecimal r82_TOTAL_OUTFLOWS) {
		R82_TOTAL_OUTFLOWS = r82_TOTAL_OUTFLOWS;
	}
	public String getR83_S_NO() {
		return R83_S_NO;
	}
	public void setR83_S_NO(String r83_S_NO) {
		R83_S_NO = r83_S_NO;
	}
	public String getR83_DESCRIPTION() {
		return R83_DESCRIPTION;
	}
	public void setR83_DESCRIPTION(String r83_DESCRIPTION) {
		R83_DESCRIPTION = r83_DESCRIPTION;
	}
	public BigDecimal getR83_TOTAL_OUTFLOWS() {
		return R83_TOTAL_OUTFLOWS;
	}
	public void setR83_TOTAL_OUTFLOWS(BigDecimal r83_TOTAL_OUTFLOWS) {
		R83_TOTAL_OUTFLOWS = r83_TOTAL_OUTFLOWS;
	}
	public String getR84_S_NO() {
		return R84_S_NO;
	}
	public void setR84_S_NO(String r84_S_NO) {
		R84_S_NO = r84_S_NO;
	}
	public String getR84_DESCRIPTION() {
		return R84_DESCRIPTION;
	}
	public void setR84_DESCRIPTION(String r84_DESCRIPTION) {
		R84_DESCRIPTION = r84_DESCRIPTION;
	}
	public BigDecimal getR84_TOTAL_OUTFLOWS() {
		return R84_TOTAL_OUTFLOWS;
	}
	public void setR84_TOTAL_OUTFLOWS(BigDecimal r84_TOTAL_OUTFLOWS) {
		R84_TOTAL_OUTFLOWS = r84_TOTAL_OUTFLOWS;
	}
	public String getR85_S_NO() {
		return R85_S_NO;
	}
	public void setR85_S_NO(String r85_S_NO) {
		R85_S_NO = r85_S_NO;
	}
	public String getR85_DESCRIPTION() {
		return R85_DESCRIPTION;
	}
	public void setR85_DESCRIPTION(String r85_DESCRIPTION) {
		R85_DESCRIPTION = r85_DESCRIPTION;
	}
	public BigDecimal getR85_TOTAL_OUTFLOWS() {
		return R85_TOTAL_OUTFLOWS;
	}
	public void setR85_TOTAL_OUTFLOWS(BigDecimal r85_TOTAL_OUTFLOWS) {
		R85_TOTAL_OUTFLOWS = r85_TOTAL_OUTFLOWS;
	}
	public String getR86_S_NO() {
		return R86_S_NO;
	}
	public void setR86_S_NO(String r86_S_NO) {
		R86_S_NO = r86_S_NO;
	}
	public String getR86_DESCRIPTION() {
		return R86_DESCRIPTION;
	}
	public void setR86_DESCRIPTION(String r86_DESCRIPTION) {
		R86_DESCRIPTION = r86_DESCRIPTION;
	}
	public BigDecimal getR86_TOTAL_OUTFLOWS() {
		return R86_TOTAL_OUTFLOWS;
	}
	public void setR86_TOTAL_OUTFLOWS(BigDecimal r86_TOTAL_OUTFLOWS) {
		R86_TOTAL_OUTFLOWS = r86_TOTAL_OUTFLOWS;
	}
	public String getR87_S_NO() {
		return R87_S_NO;
	}
	public void setR87_S_NO(String r87_S_NO) {
		R87_S_NO = r87_S_NO;
	}
	public String getR87_DESCRIPTION() {
		return R87_DESCRIPTION;
	}
	public void setR87_DESCRIPTION(String r87_DESCRIPTION) {
		R87_DESCRIPTION = r87_DESCRIPTION;
	}
	public BigDecimal getR87_TOTAL_OUTFLOWS() {
		return R87_TOTAL_OUTFLOWS;
	}
	public void setR87_TOTAL_OUTFLOWS(BigDecimal r87_TOTAL_OUTFLOWS) {
		R87_TOTAL_OUTFLOWS = r87_TOTAL_OUTFLOWS;
	}
	public String getR88_S_NO() {
		return R88_S_NO;
	}
	public void setR88_S_NO(String r88_S_NO) {
		R88_S_NO = r88_S_NO;
	}
	public String getR88_DESCRIPTION() {
		return R88_DESCRIPTION;
	}
	public void setR88_DESCRIPTION(String r88_DESCRIPTION) {
		R88_DESCRIPTION = r88_DESCRIPTION;
	}
	public BigDecimal getR88_TOTAL_OUTFLOWS() {
		return R88_TOTAL_OUTFLOWS;
	}
	public void setR88_TOTAL_OUTFLOWS(BigDecimal r88_TOTAL_OUTFLOWS) {
		R88_TOTAL_OUTFLOWS = r88_TOTAL_OUTFLOWS;
	}
	public String getR89_S_NO() {
		return R89_S_NO;
	}
	public void setR89_S_NO(String r89_S_NO) {
		R89_S_NO = r89_S_NO;
	}
	public String getR89_DESCRIPTION() {
		return R89_DESCRIPTION;
	}
	public void setR89_DESCRIPTION(String r89_DESCRIPTION) {
		R89_DESCRIPTION = r89_DESCRIPTION;
	}
	public BigDecimal getR89_TOTAL_OUTFLOWS() {
		return R89_TOTAL_OUTFLOWS;
	}
	public void setR89_TOTAL_OUTFLOWS(BigDecimal r89_TOTAL_OUTFLOWS) {
		R89_TOTAL_OUTFLOWS = r89_TOTAL_OUTFLOWS;
	}
	public String getR90_S_NO() {
		return R90_S_NO;
	}
	public void setR90_S_NO(String r90_S_NO) {
		R90_S_NO = r90_S_NO;
	}
	public String getR90_DESCRIPTION() {
		return R90_DESCRIPTION;
	}
	public void setR90_DESCRIPTION(String r90_DESCRIPTION) {
		R90_DESCRIPTION = r90_DESCRIPTION;
	}
	public BigDecimal getR90_TOTAL_OUTFLOWS() {
		return R90_TOTAL_OUTFLOWS;
	}
	public void setR90_TOTAL_OUTFLOWS(BigDecimal r90_TOTAL_OUTFLOWS) {
		R90_TOTAL_OUTFLOWS = r90_TOTAL_OUTFLOWS;
	}
	public String getR91_S_NO() {
		return R91_S_NO;
	}
	public void setR91_S_NO(String r91_S_NO) {
		R91_S_NO = r91_S_NO;
	}
	public String getR91_DESCRIPTION() {
		return R91_DESCRIPTION;
	}
	public void setR91_DESCRIPTION(String r91_DESCRIPTION) {
		R91_DESCRIPTION = r91_DESCRIPTION;
	}
	public BigDecimal getR91_TOTAL_OUTFLOWS() {
		return R91_TOTAL_OUTFLOWS;
	}
	public void setR91_TOTAL_OUTFLOWS(BigDecimal r91_TOTAL_OUTFLOWS) {
		R91_TOTAL_OUTFLOWS = r91_TOTAL_OUTFLOWS;
	}
	public String getR92_S_NO() {
		return R92_S_NO;
	}
	public void setR92_S_NO(String r92_S_NO) {
		R92_S_NO = r92_S_NO;
	}
	public String getR92_DESCRIPTION() {
		return R92_DESCRIPTION;
	}
	public void setR92_DESCRIPTION(String r92_DESCRIPTION) {
		R92_DESCRIPTION = r92_DESCRIPTION;
	}
	public BigDecimal getR92_TOTAL_OUTFLOWS() {
		return R92_TOTAL_OUTFLOWS;
	}
	public void setR92_TOTAL_OUTFLOWS(BigDecimal r92_TOTAL_OUTFLOWS) {
		R92_TOTAL_OUTFLOWS = r92_TOTAL_OUTFLOWS;
	}
	public String getR93_S_NO() {
		return R93_S_NO;
	}
	public void setR93_S_NO(String r93_S_NO) {
		R93_S_NO = r93_S_NO;
	}
	public String getR93_DESCRIPTION() {
		return R93_DESCRIPTION;
	}
	public void setR93_DESCRIPTION(String r93_DESCRIPTION) {
		R93_DESCRIPTION = r93_DESCRIPTION;
	}
	public BigDecimal getR93_TOTAL_OUTFLOWS() {
		return R93_TOTAL_OUTFLOWS;
	}
	public void setR93_TOTAL_OUTFLOWS(BigDecimal r93_TOTAL_OUTFLOWS) {
		R93_TOTAL_OUTFLOWS = r93_TOTAL_OUTFLOWS;
	}
	public String getR94_S_NO() {
		return R94_S_NO;
	}
	public void setR94_S_NO(String r94_S_NO) {
		R94_S_NO = r94_S_NO;
	}
	public String getR94_DESCRIPTION() {
		return R94_DESCRIPTION;
	}
	public void setR94_DESCRIPTION(String r94_DESCRIPTION) {
		R94_DESCRIPTION = r94_DESCRIPTION;
	}
	public BigDecimal getR94_TOTAL_OUTFLOWS() {
		return R94_TOTAL_OUTFLOWS;
	}
	public void setR94_TOTAL_OUTFLOWS(BigDecimal r94_TOTAL_OUTFLOWS) {
		R94_TOTAL_OUTFLOWS = r94_TOTAL_OUTFLOWS;
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
	public BRF101_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
