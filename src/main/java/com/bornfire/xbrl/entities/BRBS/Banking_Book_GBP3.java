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
@Table(name = "BANKING_BOOK1_GBP3")
public class Banking_Book_GBP3 {
	private String RETAIL_1_PRODUCT;
	private BigDecimal RETAIL_1_TEQUALON;
	private BigDecimal RETAIL_1_ON_T_EQUALTO_1M;
	private BigDecimal RETAIL_1_1M_T_EQUALTO_3M;
	private BigDecimal RETAIL_1_3M_T_EQUALTO_6M;
	private BigDecimal RETAIL_1_6M_T_EQUALTO_9M;
	private BigDecimal RETAIL_1_9M_T_EQUALTO_1Y;
	private BigDecimal RETAIL_1_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal RETAIL_1_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal RETAIL_1_2Y_T_EQUALTO_3Y;
	private BigDecimal RETAIL_1_3Y_T_EQUALTO_4Y;
	private BigDecimal RETAIL_1_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal RETAIL_1_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal RETAIL_1_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal RETAIL_1_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal RETAIL_1_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal RETAIL_1_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal RETAIL_1_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal RETAIL_1_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal RETAIL_1_TL_20Y;
	private BigDecimal RETAIL_1_NONSENSITIVE;
	private BigDecimal RETAIL_1_TOTAL_RSL;
	private BigDecimal RETAIL_1_TOTAL;
	private String WHOLESALE_1_PRODUCT;
	private BigDecimal WHOLESALE_1_TEQUALON;
	private BigDecimal WHOLESALE_1_ON_T_EQUALTO_1M;
	private BigDecimal WHOLESALE_1_1M_T_EQUALTO_3M;
	private BigDecimal WHOLESALE_1_3M_T_EQUALTO_6M;
	private BigDecimal WHOLESALE_1_6M_T_EQUALTO_9M;
	private BigDecimal WHOLESALE_1_9M_T_EQUALTO_1Y;
	private BigDecimal WHOLESALE_1_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal WHOLESALE_1_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal WHOLESALE_1_2Y_T_EQUALTO_3Y;
	private BigDecimal WHOLESALE_1_3Y_T_EQUALTO_4Y;
	private BigDecimal WHOLESALE_1_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal WHOLESALE_1_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal WHOLESALE_1_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal WHOLESALE_1_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal WHOLESALE_1_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal WHOLESALE_1_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal WHOLESALE_1_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal WHOLESALE_1_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal WHOLESALE_1_TL_20Y;
	private BigDecimal WHOLESALE_1_NONSENSITIVE;
	private BigDecimal WHOLESALE_1_TOTAL_RSL;
	private BigDecimal WHOLESALE_1_TOTAL;
	private String RETAIL_2_PRODUCT;
	private BigDecimal RETAIL_2_TEQUALON;
	private BigDecimal RETAIL_2_ON_T_EQUALTO_1M;
	private BigDecimal RETAIL_2_1M_T_EQUALTO_3M;
	private BigDecimal RETAIL_2_3M_T_EQUALTO_6M;
	private BigDecimal RETAIL_2_6M_T_EQUALTO_9M;
	private BigDecimal RETAIL_2_9M_T_EQUALTO_1Y;
	private BigDecimal RETAIL_2_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal RETAIL_2_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal RETAIL_2_2Y_T_EQUALTO_3Y;
	private BigDecimal RETAIL_2_3Y_T_EQUALTO_4Y;
	private BigDecimal RETAIL_2_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal RETAIL_2_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal RETAIL_2_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal RETAIL_2_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal RETAIL_2_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal RETAIL_2_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal RETAIL_2_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal RETAIL_2_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal RETAIL_2_TL_20Y;
	private BigDecimal RETAIL_2_NONSENSITIVE;
	private BigDecimal RETAIL_2_TOTAL_RSL;
	private BigDecimal RETAIL_2_TOTAL;
	private String WHOLESALE_2_PRODUCT;
	private BigDecimal WHOLESALE_2_TEQUALON;
	private BigDecimal WHOLESALE_2_ON_T_EQUALTO_1M;
	private BigDecimal WHOLESALE_2_1M_T_EQUALTO_3M;
	private BigDecimal WHOLESALE_2_3M_T_EQUALTO_6M;
	private BigDecimal WHOLESALE_2_6M_T_EQUALTO_9M;
	private BigDecimal WHOLESALE_2_9M_T_EQUALTO_1Y;
	private BigDecimal WHOLESALE_2_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal WHOLESALE_2_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal WHOLESALE_2_2Y_T_EQUALTO_3Y;
	private BigDecimal WHOLESALE_2_3Y_T_EQUALTO_4Y;
	private BigDecimal WHOLESALE_2_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal WHOLESALE_2_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal WHOLESALE_2_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal WHOLESALE_2_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal WHOLESALE_2_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal WHOLESALE_2_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal WHOLESALE_2_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal WHOLESALE_2_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal WHOLESALE_2_TL_20Y;
	private BigDecimal WHOLESALE_2_NONSENSITIVE;
	private BigDecimal WHOLESALE_2_TOTAL_RSL;
	private BigDecimal WHOLESALE_2_TOTAL;
	private String RETAIL_FIXED_PRODUCT;
	private BigDecimal RETAIL_FIXED_TEQUALON;
	private BigDecimal RETAIL_FIXED_ON_T_EQUALTO_1M;
	private BigDecimal RETAIL_FIXED_1M_T_EQUALTO_3M;
	private BigDecimal RETAIL_FIXED_3M_T_EQUALTO_6M;
	private BigDecimal RETAIL_FIXED_6M_T_EQUALTO_9M;
	private BigDecimal RETAIL_FIXED_9M_T_EQUALTO_1Y;
	private BigDecimal RETAIL_FIXED_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal RETAIL_FIXED_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal RETAIL_FIXED_2Y_T_EQUALTO_3Y;
	private BigDecimal RETAIL_FIXED_3Y_T_EQUALTO_4Y;
	private BigDecimal RETAIL_FIXED_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal RETAIL_FIXED_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal RETAIL_FIXED_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal RETAIL_FIXED_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal RETAIL_FIXED_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal RETAIL_FIXED_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal RETAIL_FIXED_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal RETAIL_FIXED_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal RETAIL_FIXED_TL_20Y;
	private BigDecimal RETAIL_FIXED_NONSENSITIVE;
	private BigDecimal RETAIL_FIXED_TOTAL_RSL;
	private BigDecimal RETAIL_FIXED_TOTAL;
	private String R97_PRODUCT;
	private BigDecimal R97_TEQUALON;
	private BigDecimal R97_ON_T_EQUALTO_1M;
	private BigDecimal R97_1M_T_EQUALTO_3M;
	private BigDecimal R97_3M_T_EQUALTO_6M;
	private BigDecimal R97_6M_T_EQUALTO_9M;
	private BigDecimal R97_9M_T_EQUALTO_1Y;
	private BigDecimal R97_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R97_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R97_2Y_T_EQUALTO_3Y;
	private BigDecimal R97_3Y_T_EQUALTO_4Y;
	private BigDecimal R97_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R97_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R97_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R97_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R97_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R97_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R97_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R97_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R97_TL_20Y;
	private BigDecimal R97_NONSENSITIVE;
	private BigDecimal R97_TOTAL_RSL;
	private BigDecimal R97_TOTAL;
	private String R98_PRODUCT;
	private BigDecimal R98_TEQUALON;
	private BigDecimal R98_ON_T_EQUALTO_1M;
	private BigDecimal R98_1M_T_EQUALTO_3M;
	private BigDecimal R98_3M_T_EQUALTO_6M;
	private BigDecimal R98_6M_T_EQUALTO_9M;
	private BigDecimal R98_9M_T_EQUALTO_1Y;
	private BigDecimal R98_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R98_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R98_2Y_T_EQUALTO_3Y;
	private BigDecimal R98_3Y_T_EQUALTO_4Y;
	private BigDecimal R98_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R98_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R98_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R98_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R98_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R98_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R98_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R98_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R98_TL_20Y;
	private BigDecimal R98_NONSENSITIVE;
	private BigDecimal R98_TOTAL_RSL;
	private BigDecimal R98_TOTAL;
	private String R99_PRODUCT;
	private BigDecimal R99_TEQUALON;
	private BigDecimal R99_ON_T_EQUALTO_1M;
	private BigDecimal R99_1M_T_EQUALTO_3M;
	private BigDecimal R99_3M_T_EQUALTO_6M;
	private BigDecimal R99_6M_T_EQUALTO_9M;
	private BigDecimal R99_9M_T_EQUALTO_1Y;
	private BigDecimal R99_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R99_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R99_2Y_T_EQUALTO_3Y;
	private BigDecimal R99_3Y_T_EQUALTO_4Y;
	private BigDecimal R99_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R99_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R99_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R99_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R99_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R99_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R99_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R99_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R99_TL_20Y;
	private BigDecimal R99_NONSENSITIVE;
	private BigDecimal R99_TOTAL_RSL;
	private BigDecimal R99_TOTAL;
	private String R100_PRODUCT;
	private BigDecimal R100_TEQUALON;
	private BigDecimal R100_ON_T_EQUALTO_1M;
	private BigDecimal R100_1M_T_EQUALTO_3M;
	private BigDecimal R100_3M_T_EQUALTO_6M;
	private BigDecimal R100_6M_T_EQUALTO_9M;
	private BigDecimal R100_9M_T_EQUALTO_1Y;
	private BigDecimal R100_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R100_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R100_2Y_T_EQUALTO_3Y;
	private BigDecimal R100_3Y_T_EQUALTO_4Y;
	private BigDecimal R100_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R100_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R100_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R100_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R100_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R100_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R100_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R100_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R100_TL_20Y;
	private BigDecimal R100_NONSENSITIVE;
	private BigDecimal R100_TOTAL_RSL;
	private BigDecimal R100_TOTAL;
	private String R102_PRODUCT;
	private BigDecimal R102_TEQUALON;
	private BigDecimal R102_ON_T_EQUALTO_1M;
	private BigDecimal R102_1M_T_EQUALTO_3M;
	private BigDecimal R102_3M_T_EQUALTO_6M;
	private BigDecimal R102_6M_T_EQUALTO_9M;
	private BigDecimal R102_9M_T_EQUALTO_1Y;
	private BigDecimal R102_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R102_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R102_2Y_T_EQUALTO_3Y;
	private BigDecimal R102_3Y_T_EQUALTO_4Y;
	private BigDecimal R102_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R102_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R102_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R102_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R102_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R102_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R102_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R102_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R102_TL_20Y;
	private BigDecimal R102_NONSENSITIVE;
	private BigDecimal R102_TOTAL_RSL;
	private BigDecimal R102_TOTAL;
	private String R103_PRODUCT;
	private BigDecimal R103_TEQUALON;
	private BigDecimal R103_ON_T_EQUALTO_1M;
	private BigDecimal R103_1M_T_EQUALTO_3M;
	private BigDecimal R103_3M_T_EQUALTO_6M;
	private BigDecimal R103_6M_T_EQUALTO_9M;
	private BigDecimal R103_9M_T_EQUALTO_1Y;
	private BigDecimal R103_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R103_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R103_2Y_T_EQUALTO_3Y;
	private BigDecimal R103_3Y_T_EQUALTO_4Y;
	private BigDecimal R103_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R103_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R103_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R103_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R103_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R103_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R103_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R103_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R103_TL_20Y;
	private BigDecimal R103_NONSENSITIVE;
	private BigDecimal R103_TOTAL_RSL;
	private BigDecimal R103_TOTAL;
	private String R104_PRODUCT;
	private BigDecimal R104_TEQUALON;
	private BigDecimal R104_ON_T_EQUALTO_1M;
	private BigDecimal R104_1M_T_EQUALTO_3M;
	private BigDecimal R104_3M_T_EQUALTO_6M;
	private BigDecimal R104_6M_T_EQUALTO_9M;
	private BigDecimal R104_9M_T_EQUALTO_1Y;
	private BigDecimal R104_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R104_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R104_2Y_T_EQUALTO_3Y;
	private BigDecimal R104_3Y_T_EQUALTO_4Y;
	private BigDecimal R104_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R104_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R104_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R104_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R104_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R104_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R104_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R104_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R104_TL_20Y;
	private BigDecimal R104_NONSENSITIVE;
	private BigDecimal R104_TOTAL_RSL;
	private BigDecimal R104_TOTAL;
	private String R107_PRODUCT;
	private BigDecimal R107_TEQUALON;
	private BigDecimal R107_ON_T_EQUALTO_1M;
	private BigDecimal R107_1M_T_EQUALTO_3M;
	private BigDecimal R107_3M_T_EQUALTO_6M;
	private BigDecimal R107_6M_T_EQUALTO_9M;
	private BigDecimal R107_9M_T_EQUALTO_1Y;
	private BigDecimal R107_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R107_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R107_2Y_T_EQUALTO_3Y;
	private BigDecimal R107_3Y_T_EQUALTO_4Y;
	private BigDecimal R107_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R107_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R107_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R107_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R107_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R107_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R107_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R107_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R107_TL_20Y;
	private BigDecimal R107_NONSENSITIVE;
	private BigDecimal R107_TOTAL_RSL;
	private BigDecimal R107_TOTAL;
	private String R108_PRODUCT;
	private BigDecimal R108_TEQUALON;
	private BigDecimal R108_ON_T_EQUALTO_1M;
	private BigDecimal R108_1M_T_EQUALTO_3M;
	private BigDecimal R108_3M_T_EQUALTO_6M;
	private BigDecimal R108_6M_T_EQUALTO_9M;
	private BigDecimal R108_9M_T_EQUALTO_1Y;
	private BigDecimal R108_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R108_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R108_2Y_T_EQUALTO_3Y;
	private BigDecimal R108_3Y_T_EQUALTO_4Y;
	private BigDecimal R108_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R108_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R108_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R108_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R108_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R108_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R108_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R108_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R108_TL_20Y;
	private BigDecimal R108_NONSENSITIVE;
	private BigDecimal R108_TOTAL_RSL;
	private BigDecimal R108_TOTAL;
	private String R109_PRODUCT;
	private BigDecimal R109_TEQUALON;
	private BigDecimal R109_ON_T_EQUALTO_1M;
	private BigDecimal R109_1M_T_EQUALTO_3M;
	private BigDecimal R109_3M_T_EQUALTO_6M;
	private BigDecimal R109_6M_T_EQUALTO_9M;
	private BigDecimal R109_9M_T_EQUALTO_1Y;
	private BigDecimal R109_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R109_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R109_2Y_T_EQUALTO_3Y;
	private BigDecimal R109_3Y_T_EQUALTO_4Y;
	private BigDecimal R109_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R109_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R109_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R109_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R109_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R109_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R109_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R109_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R109_TL_20Y;
	private BigDecimal R109_NONSENSITIVE;
	private BigDecimal R109_TOTAL_RSL;
	private BigDecimal R109_TOTAL;
	private String R117_PRODUCT;
	private BigDecimal R117_TEQUALON;
	private BigDecimal R117_ON_T_EQUALTO_1M;
	private BigDecimal R117_1M_T_EQUALTO_3M;
	private BigDecimal R117_3M_T_EQUALTO_6M;
	private BigDecimal R117_6M_T_EQUALTO_9M;
	private BigDecimal R117_9M_T_EQUALTO_1Y;
	private BigDecimal R117_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R117_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R117_2Y_T_EQUALTO_3Y;
	private BigDecimal R117_3Y_T_EQUALTO_4Y;
	private BigDecimal R117_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R117_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R117_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R117_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R117_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R117_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R117_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R117_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R117_TL_20Y;
	private BigDecimal R117_NONSENSITIVE;
	private BigDecimal R117_TOTAL_RSL;
	private BigDecimal R117_TOTAL;
	private String R118_PRODUCT;
	private BigDecimal R118_TEQUALON;
	private BigDecimal R118_ON_T_EQUALTO_1M;
	private BigDecimal R118_1M_T_EQUALTO_3M;
	private BigDecimal R118_3M_T_EQUALTO_6M;
	private BigDecimal R118_6M_T_EQUALTO_9M;
	private BigDecimal R118_9M_T_EQUALTO_1Y;
	private BigDecimal R118_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R118_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R118_2Y_T_EQUALTO_3Y;
	private BigDecimal R118_3Y_T_EQUALTO_4Y;
	private BigDecimal R118_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R118_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R118_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R118_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R118_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R118_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R118_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R118_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R118_TL_20Y;
	private BigDecimal R118_NONSENSITIVE;
	private BigDecimal R118_TOTAL_RSL;
	private BigDecimal R118_TOTAL;
	private String R119_PRODUCT;
	private BigDecimal R119_TEQUALON;
	private BigDecimal R119_ON_T_EQUALTO_1M;
	private BigDecimal R119_1M_T_EQUALTO_3M;
	private BigDecimal R119_3M_T_EQUALTO_6M;
	private BigDecimal R119_6M_T_EQUALTO_9M;
	private BigDecimal R119_9M_T_EQUALTO_1Y;
	private BigDecimal R119_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R119_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R119_2Y_T_EQUALTO_3Y;
	private BigDecimal R119_3Y_T_EQUALTO_4Y;
	private BigDecimal R119_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R119_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R119_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R119_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R119_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R119_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R119_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R119_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R119_TL_20Y;
	private BigDecimal R119_NONSENSITIVE;
	private BigDecimal R119_TOTAL_RSL;
	private BigDecimal R119_TOTAL;
	private String R120_PRODUCT;
	private BigDecimal R120_TEQUALON;
	private BigDecimal R120_ON_T_EQUALTO_1M;
	private BigDecimal R120_1M_T_EQUALTO_3M;
	private BigDecimal R120_3M_T_EQUALTO_6M;
	private BigDecimal R120_6M_T_EQUALTO_9M;
	private BigDecimal R120_9M_T_EQUALTO_1Y;
	private BigDecimal R120_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R120_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R120_2Y_T_EQUALTO_3Y;
	private BigDecimal R120_3Y_T_EQUALTO_4Y;
	private BigDecimal R120_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R120_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R120_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R120_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R120_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R120_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R120_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R120_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R120_TL_20Y;
	private BigDecimal R120_NONSENSITIVE;
	private BigDecimal R120_TOTAL_RSL;
	private BigDecimal R120_TOTAL;
	private String R121_PRODUCT;
	private BigDecimal R121_TEQUALON;
	private BigDecimal R121_ON_T_EQUALTO_1M;
	private BigDecimal R121_1M_T_EQUALTO_3M;
	private BigDecimal R121_3M_T_EQUALTO_6M;
	private BigDecimal R121_6M_T_EQUALTO_9M;
	private BigDecimal R121_9M_T_EQUALTO_1Y;
	private BigDecimal R121_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R121_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R121_2Y_T_EQUALTO_3Y;
	private BigDecimal R121_3Y_T_EQUALTO_4Y;
	private BigDecimal R121_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R121_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R121_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R121_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R121_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R121_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R121_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R121_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R121_TL_20Y;
	private BigDecimal R121_NONSENSITIVE;
	private BigDecimal R121_TOTAL_RSL;
	private BigDecimal R121_TOTAL;
	private String R122_PRODUCT;
	private BigDecimal R122_TEQUALON;
	private BigDecimal R122_ON_T_EQUALTO_1M;
	private BigDecimal R122_1M_T_EQUALTO_3M;
	private BigDecimal R122_3M_T_EQUALTO_6M;
	private BigDecimal R122_6M_T_EQUALTO_9M;
	private BigDecimal R122_9M_T_EQUALTO_1Y;
	private BigDecimal R122_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R122_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R122_2Y_T_EQUALTO_3Y;
	private BigDecimal R122_3Y_T_EQUALTO_4Y;
	private BigDecimal R122_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R122_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R122_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R122_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R122_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R122_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R122_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R122_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R122_TL_20Y;
	private BigDecimal R122_NONSENSITIVE;
	private BigDecimal R122_TOTAL_RSL;
	private BigDecimal R122_TOTAL;
	private String R125_PRODUCT;
	private BigDecimal R125_TEQUALON;
	private BigDecimal R125_ON_T_EQUALTO_1M;
	private BigDecimal R125_1M_T_EQUALTO_3M;
	private BigDecimal R125_3M_T_EQUALTO_6M;
	private BigDecimal R125_6M_T_EQUALTO_9M;
	private BigDecimal R125_9M_T_EQUALTO_1Y;
	private BigDecimal R125_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R125_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R125_2Y_T_EQUALTO_3Y;
	private BigDecimal R125_3Y_T_EQUALTO_4Y;
	private BigDecimal R125_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R125_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R125_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R125_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R125_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R125_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R125_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R125_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R125_TL_20Y;
	private BigDecimal R125_NONSENSITIVE;
	private BigDecimal R125_TOTAL_RSL;
	private BigDecimal R125_TOTAL;
	private String R126_PRODUCT;
	private BigDecimal R126_TEQUALON;
	private BigDecimal R126_ON_T_EQUALTO_1M;
	private BigDecimal R126_1M_T_EQUALTO_3M;
	private BigDecimal R126_3M_T_EQUALTO_6M;
	private BigDecimal R126_6M_T_EQUALTO_9M;
	private BigDecimal R126_9M_T_EQUALTO_1Y;
	private BigDecimal R126_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R126_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R126_2Y_T_EQUALTO_3Y;
	private BigDecimal R126_3Y_T_EQUALTO_4Y;
	private BigDecimal R126_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R126_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R126_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R126_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R126_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R126_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R126_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R126_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R126_TL_20Y;
	private BigDecimal R126_NONSENSITIVE;
	private BigDecimal R126_TOTAL_RSL;
	private BigDecimal R126_TOTAL;
	private String R127_PRODUCT;
	private BigDecimal R127_TEQUALON;
	private BigDecimal R127_ON_T_EQUALTO_1M;
	private BigDecimal R127_1M_T_EQUALTO_3M;
	private BigDecimal R127_3M_T_EQUALTO_6M;
	private BigDecimal R127_6M_T_EQUALTO_9M;
	private BigDecimal R127_9M_T_EQUALTO_1Y;
	private BigDecimal R127_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R127_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R127_2Y_T_EQUALTO_3Y;
	private BigDecimal R127_3Y_T_EQUALTO_4Y;
	private BigDecimal R127_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R127_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R127_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R127_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R127_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R127_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R127_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R127_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R127_TL_20Y;
	private BigDecimal R127_NONSENSITIVE;
	private BigDecimal R127_TOTAL_RSL;
	private BigDecimal R127_TOTAL;
	private String R128_PRODUCT;
	private BigDecimal R128_TEQUALON;
	private BigDecimal R128_ON_T_EQUALTO_1M;
	private BigDecimal R128_1M_T_EQUALTO_3M;
	private BigDecimal R128_3M_T_EQUALTO_6M;
	private BigDecimal R128_6M_T_EQUALTO_9M;
	private BigDecimal R128_9M_T_EQUALTO_1Y;
	private BigDecimal R128_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R128_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R128_2Y_T_EQUALTO_3Y;
	private BigDecimal R128_3Y_T_EQUALTO_4Y;
	private BigDecimal R128_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R128_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R128_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R128_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R128_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R128_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R128_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R128_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R128_TL_20Y;
	private BigDecimal R128_NONSENSITIVE;
	private BigDecimal R128_TOTAL_RSL;
	private BigDecimal R128_TOTAL;
	private String R129_PRODUCT;
	private BigDecimal R129_TEQUALON;
	private BigDecimal R129_ON_T_EQUALTO_1M;
	private BigDecimal R129_1M_T_EQUALTO_3M;
	private BigDecimal R129_3M_T_EQUALTO_6M;
	private BigDecimal R129_6M_T_EQUALTO_9M;
	private BigDecimal R129_9M_T_EQUALTO_1Y;
	private BigDecimal R129_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R129_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R129_2Y_T_EQUALTO_3Y;
	private BigDecimal R129_3Y_T_EQUALTO_4Y;
	private BigDecimal R129_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R129_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R129_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R129_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R129_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R129_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R129_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R129_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R129_TL_20Y;
	private BigDecimal R129_NONSENSITIVE;
	private BigDecimal R129_TOTAL_RSL;
	private BigDecimal R129_TOTAL;
	private String R130_PRODUCT;
	private BigDecimal R130_TEQUALON;
	private BigDecimal R130_ON_T_EQUALTO_1M;
	private BigDecimal R130_1M_T_EQUALTO_3M;
	private BigDecimal R130_3M_T_EQUALTO_6M;
	private BigDecimal R130_6M_T_EQUALTO_9M;
	private BigDecimal R130_9M_T_EQUALTO_1Y;
	private BigDecimal R130_1Y_T_EQUALTO_1POINT5Y;
	private BigDecimal R130_1POINT5Y_T_EQUALTO_2Y;
	private BigDecimal R130_2Y_T_EQUALTO_3Y;
	private BigDecimal R130_3Y_T_EQUALTO_4Y;
	private BigDecimal R130_4Y_LT_T_LTEQUALTO_5Y;
	private BigDecimal R130_5Y_LT_T_LTEQUALTO_6Y;
	private BigDecimal R130_6Y_LT_T_LTEQUALTO_7Y;
	private BigDecimal R130_7Y_LT_T_LTEQUALTO_8Y;
	private BigDecimal R130_8Y_LT_T_LTEQUALTO_9Y;
	private BigDecimal R130_9Y_LT_T_LTEQUALTO_10Y;
	private BigDecimal R130_10Y_LT_T_LTEQUALTO_15Y;
	private BigDecimal R130_15Y_LT_T_LTEQUALTO_20Y;
	private BigDecimal R130_TL_20Y;
	private BigDecimal R130_NONSENSITIVE;
	private BigDecimal R130_TOTAL_RSL;
	private BigDecimal R130_TOTAL;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date REPORT_Date;
	private Date REPORT_FROM_Date;
	private Date REPORT_TO_Date;
	private String ENTITY_FLG;
	private String MODIFY_FLG;
	private String DEL_FLG;
	private String REPORT_CODE;
	private Date REPORT_SUBMIT_Date;
	public String getRETAIL_1_PRODUCT() {
		return RETAIL_1_PRODUCT;
	}
	public void setRETAIL_1_PRODUCT(String rETAIL_1_PRODUCT) {
		RETAIL_1_PRODUCT = rETAIL_1_PRODUCT;
	}
	public BigDecimal getRETAIL_1_TEQUALON() {
		return RETAIL_1_TEQUALON;
	}
	public void setRETAIL_1_TEQUALON(BigDecimal rETAIL_1_TEQUALON) {
		RETAIL_1_TEQUALON = rETAIL_1_TEQUALON;
	}
	public BigDecimal getRETAIL_1_ON_T_EQUALTO_1M() {
		return RETAIL_1_ON_T_EQUALTO_1M;
	}
	public void setRETAIL_1_ON_T_EQUALTO_1M(BigDecimal rETAIL_1_ON_T_EQUALTO_1M) {
		RETAIL_1_ON_T_EQUALTO_1M = rETAIL_1_ON_T_EQUALTO_1M;
	}
	public BigDecimal getRETAIL_1_1M_T_EQUALTO_3M() {
		return RETAIL_1_1M_T_EQUALTO_3M;
	}
	public void setRETAIL_1_1M_T_EQUALTO_3M(BigDecimal rETAIL_1_1M_T_EQUALTO_3M) {
		RETAIL_1_1M_T_EQUALTO_3M = rETAIL_1_1M_T_EQUALTO_3M;
	}
	public BigDecimal getRETAIL_1_3M_T_EQUALTO_6M() {
		return RETAIL_1_3M_T_EQUALTO_6M;
	}
	public void setRETAIL_1_3M_T_EQUALTO_6M(BigDecimal rETAIL_1_3M_T_EQUALTO_6M) {
		RETAIL_1_3M_T_EQUALTO_6M = rETAIL_1_3M_T_EQUALTO_6M;
	}
	public BigDecimal getRETAIL_1_6M_T_EQUALTO_9M() {
		return RETAIL_1_6M_T_EQUALTO_9M;
	}
	public void setRETAIL_1_6M_T_EQUALTO_9M(BigDecimal rETAIL_1_6M_T_EQUALTO_9M) {
		RETAIL_1_6M_T_EQUALTO_9M = rETAIL_1_6M_T_EQUALTO_9M;
	}
	public BigDecimal getRETAIL_1_9M_T_EQUALTO_1Y() {
		return RETAIL_1_9M_T_EQUALTO_1Y;
	}
	public void setRETAIL_1_9M_T_EQUALTO_1Y(BigDecimal rETAIL_1_9M_T_EQUALTO_1Y) {
		RETAIL_1_9M_T_EQUALTO_1Y = rETAIL_1_9M_T_EQUALTO_1Y;
	}
	public BigDecimal getRETAIL_1_1Y_T_EQUALTO_1POINT5Y() {
		return RETAIL_1_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setRETAIL_1_1Y_T_EQUALTO_1POINT5Y(BigDecimal rETAIL_1_1Y_T_EQUALTO_1POINT5Y) {
		RETAIL_1_1Y_T_EQUALTO_1POINT5Y = rETAIL_1_1Y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getRETAIL_1_1POINT5Y_T_EQUALTO_2Y() {
		return RETAIL_1_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setRETAIL_1_1POINT5Y_T_EQUALTO_2Y(BigDecimal rETAIL_1_1POINT5Y_T_EQUALTO_2Y) {
		RETAIL_1_1POINT5Y_T_EQUALTO_2Y = rETAIL_1_1POINT5Y_T_EQUALTO_2Y;
	}
	public BigDecimal getRETAIL_1_2Y_T_EQUALTO_3Y() {
		return RETAIL_1_2Y_T_EQUALTO_3Y;
	}
	public void setRETAIL_1_2Y_T_EQUALTO_3Y(BigDecimal rETAIL_1_2Y_T_EQUALTO_3Y) {
		RETAIL_1_2Y_T_EQUALTO_3Y = rETAIL_1_2Y_T_EQUALTO_3Y;
	}
	public BigDecimal getRETAIL_1_3Y_T_EQUALTO_4Y() {
		return RETAIL_1_3Y_T_EQUALTO_4Y;
	}
	public void setRETAIL_1_3Y_T_EQUALTO_4Y(BigDecimal rETAIL_1_3Y_T_EQUALTO_4Y) {
		RETAIL_1_3Y_T_EQUALTO_4Y = rETAIL_1_3Y_T_EQUALTO_4Y;
	}
	public BigDecimal getRETAIL_1_4Y_LT_T_LTEQUALTO_5Y() {
		return RETAIL_1_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setRETAIL_1_4Y_LT_T_LTEQUALTO_5Y(BigDecimal rETAIL_1_4Y_LT_T_LTEQUALTO_5Y) {
		RETAIL_1_4Y_LT_T_LTEQUALTO_5Y = rETAIL_1_4Y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getRETAIL_1_5Y_LT_T_LTEQUALTO_6Y() {
		return RETAIL_1_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setRETAIL_1_5Y_LT_T_LTEQUALTO_6Y(BigDecimal rETAIL_1_5Y_LT_T_LTEQUALTO_6Y) {
		RETAIL_1_5Y_LT_T_LTEQUALTO_6Y = rETAIL_1_5Y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getRETAIL_1_6Y_LT_T_LTEQUALTO_7Y() {
		return RETAIL_1_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setRETAIL_1_6Y_LT_T_LTEQUALTO_7Y(BigDecimal rETAIL_1_6Y_LT_T_LTEQUALTO_7Y) {
		RETAIL_1_6Y_LT_T_LTEQUALTO_7Y = rETAIL_1_6Y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getRETAIL_1_7Y_LT_T_LTEQUALTO_8Y() {
		return RETAIL_1_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setRETAIL_1_7Y_LT_T_LTEQUALTO_8Y(BigDecimal rETAIL_1_7Y_LT_T_LTEQUALTO_8Y) {
		RETAIL_1_7Y_LT_T_LTEQUALTO_8Y = rETAIL_1_7Y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getRETAIL_1_8Y_LT_T_LTEQUALTO_9Y() {
		return RETAIL_1_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setRETAIL_1_8Y_LT_T_LTEQUALTO_9Y(BigDecimal rETAIL_1_8Y_LT_T_LTEQUALTO_9Y) {
		RETAIL_1_8Y_LT_T_LTEQUALTO_9Y = rETAIL_1_8Y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getRETAIL_1_9Y_LT_T_LTEQUALTO_10Y() {
		return RETAIL_1_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setRETAIL_1_9Y_LT_T_LTEQUALTO_10Y(BigDecimal rETAIL_1_9Y_LT_T_LTEQUALTO_10Y) {
		RETAIL_1_9Y_LT_T_LTEQUALTO_10Y = rETAIL_1_9Y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getRETAIL_1_10Y_LT_T_LTEQUALTO_15Y() {
		return RETAIL_1_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setRETAIL_1_10Y_LT_T_LTEQUALTO_15Y(BigDecimal rETAIL_1_10Y_LT_T_LTEQUALTO_15Y) {
		RETAIL_1_10Y_LT_T_LTEQUALTO_15Y = rETAIL_1_10Y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getRETAIL_1_15Y_LT_T_LTEQUALTO_20Y() {
		return RETAIL_1_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setRETAIL_1_15Y_LT_T_LTEQUALTO_20Y(BigDecimal rETAIL_1_15Y_LT_T_LTEQUALTO_20Y) {
		RETAIL_1_15Y_LT_T_LTEQUALTO_20Y = rETAIL_1_15Y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getRETAIL_1_TL_20Y() {
		return RETAIL_1_TL_20Y;
	}
	public void setRETAIL_1_TL_20Y(BigDecimal rETAIL_1_TL_20Y) {
		RETAIL_1_TL_20Y = rETAIL_1_TL_20Y;
	}
	public BigDecimal getRETAIL_1_NONSENSITIVE() {
		return RETAIL_1_NONSENSITIVE;
	}
	public void setRETAIL_1_NONSENSITIVE(BigDecimal rETAIL_1_NONSENSITIVE) {
		RETAIL_1_NONSENSITIVE = rETAIL_1_NONSENSITIVE;
	}
	public BigDecimal getRETAIL_1_TOTAL_RSL() {
		return RETAIL_1_TOTAL_RSL;
	}
	public void setRETAIL_1_TOTAL_RSL(BigDecimal rETAIL_1_TOTAL_RSL) {
		RETAIL_1_TOTAL_RSL = rETAIL_1_TOTAL_RSL;
	}
	public BigDecimal getRETAIL_1_TOTAL() {
		return RETAIL_1_TOTAL;
	}
	public void setRETAIL_1_TOTAL(BigDecimal rETAIL_1_TOTAL) {
		RETAIL_1_TOTAL = rETAIL_1_TOTAL;
	}
	public String getWHOLESALE_1_PRODUCT() {
		return WHOLESALE_1_PRODUCT;
	}
	public void setWHOLESALE_1_PRODUCT(String wHOLESALE_1_PRODUCT) {
		WHOLESALE_1_PRODUCT = wHOLESALE_1_PRODUCT;
	}
	public BigDecimal getWHOLESALE_1_TEQUALON() {
		return WHOLESALE_1_TEQUALON;
	}
	public void setWHOLESALE_1_TEQUALON(BigDecimal wHOLESALE_1_TEQUALON) {
		WHOLESALE_1_TEQUALON = wHOLESALE_1_TEQUALON;
	}
	public BigDecimal getWHOLESALE_1_ON_T_EQUALTO_1M() {
		return WHOLESALE_1_ON_T_EQUALTO_1M;
	}
	public void setWHOLESALE_1_ON_T_EQUALTO_1M(BigDecimal wHOLESALE_1_ON_T_EQUALTO_1M) {
		WHOLESALE_1_ON_T_EQUALTO_1M = wHOLESALE_1_ON_T_EQUALTO_1M;
	}
	public BigDecimal getWHOLESALE_1_1M_T_EQUALTO_3M() {
		return WHOLESALE_1_1M_T_EQUALTO_3M;
	}
	public void setWHOLESALE_1_1M_T_EQUALTO_3M(BigDecimal wHOLESALE_1_1M_T_EQUALTO_3M) {
		WHOLESALE_1_1M_T_EQUALTO_3M = wHOLESALE_1_1M_T_EQUALTO_3M;
	}
	public BigDecimal getWHOLESALE_1_3M_T_EQUALTO_6M() {
		return WHOLESALE_1_3M_T_EQUALTO_6M;
	}
	public void setWHOLESALE_1_3M_T_EQUALTO_6M(BigDecimal wHOLESALE_1_3M_T_EQUALTO_6M) {
		WHOLESALE_1_3M_T_EQUALTO_6M = wHOLESALE_1_3M_T_EQUALTO_6M;
	}
	public BigDecimal getWHOLESALE_1_6M_T_EQUALTO_9M() {
		return WHOLESALE_1_6M_T_EQUALTO_9M;
	}
	public void setWHOLESALE_1_6M_T_EQUALTO_9M(BigDecimal wHOLESALE_1_6M_T_EQUALTO_9M) {
		WHOLESALE_1_6M_T_EQUALTO_9M = wHOLESALE_1_6M_T_EQUALTO_9M;
	}
	public BigDecimal getWHOLESALE_1_9M_T_EQUALTO_1Y() {
		return WHOLESALE_1_9M_T_EQUALTO_1Y;
	}
	public void setWHOLESALE_1_9M_T_EQUALTO_1Y(BigDecimal wHOLESALE_1_9M_T_EQUALTO_1Y) {
		WHOLESALE_1_9M_T_EQUALTO_1Y = wHOLESALE_1_9M_T_EQUALTO_1Y;
	}
	public BigDecimal getWHOLESALE_1_1Y_T_EQUALTO_1POINT5Y() {
		return WHOLESALE_1_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setWHOLESALE_1_1Y_T_EQUALTO_1POINT5Y(BigDecimal wHOLESALE_1_1Y_T_EQUALTO_1POINT5Y) {
		WHOLESALE_1_1Y_T_EQUALTO_1POINT5Y = wHOLESALE_1_1Y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getWHOLESALE_1_1POINT5Y_T_EQUALTO_2Y() {
		return WHOLESALE_1_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setWHOLESALE_1_1POINT5Y_T_EQUALTO_2Y(BigDecimal wHOLESALE_1_1POINT5Y_T_EQUALTO_2Y) {
		WHOLESALE_1_1POINT5Y_T_EQUALTO_2Y = wHOLESALE_1_1POINT5Y_T_EQUALTO_2Y;
	}
	public BigDecimal getWHOLESALE_1_2Y_T_EQUALTO_3Y() {
		return WHOLESALE_1_2Y_T_EQUALTO_3Y;
	}
	public void setWHOLESALE_1_2Y_T_EQUALTO_3Y(BigDecimal wHOLESALE_1_2Y_T_EQUALTO_3Y) {
		WHOLESALE_1_2Y_T_EQUALTO_3Y = wHOLESALE_1_2Y_T_EQUALTO_3Y;
	}
	public BigDecimal getWHOLESALE_1_3Y_T_EQUALTO_4Y() {
		return WHOLESALE_1_3Y_T_EQUALTO_4Y;
	}
	public void setWHOLESALE_1_3Y_T_EQUALTO_4Y(BigDecimal wHOLESALE_1_3Y_T_EQUALTO_4Y) {
		WHOLESALE_1_3Y_T_EQUALTO_4Y = wHOLESALE_1_3Y_T_EQUALTO_4Y;
	}
	public BigDecimal getWHOLESALE_1_4Y_LT_T_LTEQUALTO_5Y() {
		return WHOLESALE_1_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setWHOLESALE_1_4Y_LT_T_LTEQUALTO_5Y(BigDecimal wHOLESALE_1_4Y_LT_T_LTEQUALTO_5Y) {
		WHOLESALE_1_4Y_LT_T_LTEQUALTO_5Y = wHOLESALE_1_4Y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getWHOLESALE_1_5Y_LT_T_LTEQUALTO_6Y() {
		return WHOLESALE_1_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setWHOLESALE_1_5Y_LT_T_LTEQUALTO_6Y(BigDecimal wHOLESALE_1_5Y_LT_T_LTEQUALTO_6Y) {
		WHOLESALE_1_5Y_LT_T_LTEQUALTO_6Y = wHOLESALE_1_5Y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getWHOLESALE_1_6Y_LT_T_LTEQUALTO_7Y() {
		return WHOLESALE_1_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setWHOLESALE_1_6Y_LT_T_LTEQUALTO_7Y(BigDecimal wHOLESALE_1_6Y_LT_T_LTEQUALTO_7Y) {
		WHOLESALE_1_6Y_LT_T_LTEQUALTO_7Y = wHOLESALE_1_6Y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getWHOLESALE_1_7Y_LT_T_LTEQUALTO_8Y() {
		return WHOLESALE_1_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setWHOLESALE_1_7Y_LT_T_LTEQUALTO_8Y(BigDecimal wHOLESALE_1_7Y_LT_T_LTEQUALTO_8Y) {
		WHOLESALE_1_7Y_LT_T_LTEQUALTO_8Y = wHOLESALE_1_7Y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getWHOLESALE_1_8Y_LT_T_LTEQUALTO_9Y() {
		return WHOLESALE_1_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setWHOLESALE_1_8Y_LT_T_LTEQUALTO_9Y(BigDecimal wHOLESALE_1_8Y_LT_T_LTEQUALTO_9Y) {
		WHOLESALE_1_8Y_LT_T_LTEQUALTO_9Y = wHOLESALE_1_8Y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getWHOLESALE_1_9Y_LT_T_LTEQUALTO_10Y() {
		return WHOLESALE_1_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setWHOLESALE_1_9Y_LT_T_LTEQUALTO_10Y(BigDecimal wHOLESALE_1_9Y_LT_T_LTEQUALTO_10Y) {
		WHOLESALE_1_9Y_LT_T_LTEQUALTO_10Y = wHOLESALE_1_9Y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getWHOLESALE_1_10Y_LT_T_LTEQUALTO_15Y() {
		return WHOLESALE_1_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setWHOLESALE_1_10Y_LT_T_LTEQUALTO_15Y(BigDecimal wHOLESALE_1_10Y_LT_T_LTEQUALTO_15Y) {
		WHOLESALE_1_10Y_LT_T_LTEQUALTO_15Y = wHOLESALE_1_10Y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getWHOLESALE_1_15Y_LT_T_LTEQUALTO_20Y() {
		return WHOLESALE_1_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setWHOLESALE_1_15Y_LT_T_LTEQUALTO_20Y(BigDecimal wHOLESALE_1_15Y_LT_T_LTEQUALTO_20Y) {
		WHOLESALE_1_15Y_LT_T_LTEQUALTO_20Y = wHOLESALE_1_15Y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getWHOLESALE_1_TL_20Y() {
		return WHOLESALE_1_TL_20Y;
	}
	public void setWHOLESALE_1_TL_20Y(BigDecimal wHOLESALE_1_TL_20Y) {
		WHOLESALE_1_TL_20Y = wHOLESALE_1_TL_20Y;
	}
	public BigDecimal getWHOLESALE_1_NONSENSITIVE() {
		return WHOLESALE_1_NONSENSITIVE;
	}
	public void setWHOLESALE_1_NONSENSITIVE(BigDecimal wHOLESALE_1_NONSENSITIVE) {
		WHOLESALE_1_NONSENSITIVE = wHOLESALE_1_NONSENSITIVE;
	}
	public BigDecimal getWHOLESALE_1_TOTAL_RSL() {
		return WHOLESALE_1_TOTAL_RSL;
	}
	public void setWHOLESALE_1_TOTAL_RSL(BigDecimal wHOLESALE_1_TOTAL_RSL) {
		WHOLESALE_1_TOTAL_RSL = wHOLESALE_1_TOTAL_RSL;
	}
	public BigDecimal getWHOLESALE_1_TOTAL() {
		return WHOLESALE_1_TOTAL;
	}
	public void setWHOLESALE_1_TOTAL(BigDecimal wHOLESALE_1_TOTAL) {
		WHOLESALE_1_TOTAL = wHOLESALE_1_TOTAL;
	}
	public String getRETAIL_2_PRODUCT() {
		return RETAIL_2_PRODUCT;
	}
	public void setRETAIL_2_PRODUCT(String rETAIL_2_PRODUCT) {
		RETAIL_2_PRODUCT = rETAIL_2_PRODUCT;
	}
	public BigDecimal getRETAIL_2_TEQUALON() {
		return RETAIL_2_TEQUALON;
	}
	public void setRETAIL_2_TEQUALON(BigDecimal rETAIL_2_TEQUALON) {
		RETAIL_2_TEQUALON = rETAIL_2_TEQUALON;
	}
	public BigDecimal getRETAIL_2_ON_T_EQUALTO_1M() {
		return RETAIL_2_ON_T_EQUALTO_1M;
	}
	public void setRETAIL_2_ON_T_EQUALTO_1M(BigDecimal rETAIL_2_ON_T_EQUALTO_1M) {
		RETAIL_2_ON_T_EQUALTO_1M = rETAIL_2_ON_T_EQUALTO_1M;
	}
	public BigDecimal getRETAIL_2_1M_T_EQUALTO_3M() {
		return RETAIL_2_1M_T_EQUALTO_3M;
	}
	public void setRETAIL_2_1M_T_EQUALTO_3M(BigDecimal rETAIL_2_1M_T_EQUALTO_3M) {
		RETAIL_2_1M_T_EQUALTO_3M = rETAIL_2_1M_T_EQUALTO_3M;
	}
	public BigDecimal getRETAIL_2_3M_T_EQUALTO_6M() {
		return RETAIL_2_3M_T_EQUALTO_6M;
	}
	public void setRETAIL_2_3M_T_EQUALTO_6M(BigDecimal rETAIL_2_3M_T_EQUALTO_6M) {
		RETAIL_2_3M_T_EQUALTO_6M = rETAIL_2_3M_T_EQUALTO_6M;
	}
	public BigDecimal getRETAIL_2_6M_T_EQUALTO_9M() {
		return RETAIL_2_6M_T_EQUALTO_9M;
	}
	public void setRETAIL_2_6M_T_EQUALTO_9M(BigDecimal rETAIL_2_6M_T_EQUALTO_9M) {
		RETAIL_2_6M_T_EQUALTO_9M = rETAIL_2_6M_T_EQUALTO_9M;
	}
	public BigDecimal getRETAIL_2_9M_T_EQUALTO_1Y() {
		return RETAIL_2_9M_T_EQUALTO_1Y;
	}
	public void setRETAIL_2_9M_T_EQUALTO_1Y(BigDecimal rETAIL_2_9M_T_EQUALTO_1Y) {
		RETAIL_2_9M_T_EQUALTO_1Y = rETAIL_2_9M_T_EQUALTO_1Y;
	}
	public BigDecimal getRETAIL_2_1Y_T_EQUALTO_1POINT5Y() {
		return RETAIL_2_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setRETAIL_2_1Y_T_EQUALTO_1POINT5Y(BigDecimal rETAIL_2_1Y_T_EQUALTO_1POINT5Y) {
		RETAIL_2_1Y_T_EQUALTO_1POINT5Y = rETAIL_2_1Y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getRETAIL_2_1POINT5Y_T_EQUALTO_2Y() {
		return RETAIL_2_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setRETAIL_2_1POINT5Y_T_EQUALTO_2Y(BigDecimal rETAIL_2_1POINT5Y_T_EQUALTO_2Y) {
		RETAIL_2_1POINT5Y_T_EQUALTO_2Y = rETAIL_2_1POINT5Y_T_EQUALTO_2Y;
	}
	public BigDecimal getRETAIL_2_2Y_T_EQUALTO_3Y() {
		return RETAIL_2_2Y_T_EQUALTO_3Y;
	}
	public void setRETAIL_2_2Y_T_EQUALTO_3Y(BigDecimal rETAIL_2_2Y_T_EQUALTO_3Y) {
		RETAIL_2_2Y_T_EQUALTO_3Y = rETAIL_2_2Y_T_EQUALTO_3Y;
	}
	public BigDecimal getRETAIL_2_3Y_T_EQUALTO_4Y() {
		return RETAIL_2_3Y_T_EQUALTO_4Y;
	}
	public void setRETAIL_2_3Y_T_EQUALTO_4Y(BigDecimal rETAIL_2_3Y_T_EQUALTO_4Y) {
		RETAIL_2_3Y_T_EQUALTO_4Y = rETAIL_2_3Y_T_EQUALTO_4Y;
	}
	public BigDecimal getRETAIL_2_4Y_LT_T_LTEQUALTO_5Y() {
		return RETAIL_2_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setRETAIL_2_4Y_LT_T_LTEQUALTO_5Y(BigDecimal rETAIL_2_4Y_LT_T_LTEQUALTO_5Y) {
		RETAIL_2_4Y_LT_T_LTEQUALTO_5Y = rETAIL_2_4Y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getRETAIL_2_5Y_LT_T_LTEQUALTO_6Y() {
		return RETAIL_2_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setRETAIL_2_5Y_LT_T_LTEQUALTO_6Y(BigDecimal rETAIL_2_5Y_LT_T_LTEQUALTO_6Y) {
		RETAIL_2_5Y_LT_T_LTEQUALTO_6Y = rETAIL_2_5Y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getRETAIL_2_6Y_LT_T_LTEQUALTO_7Y() {
		return RETAIL_2_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setRETAIL_2_6Y_LT_T_LTEQUALTO_7Y(BigDecimal rETAIL_2_6Y_LT_T_LTEQUALTO_7Y) {
		RETAIL_2_6Y_LT_T_LTEQUALTO_7Y = rETAIL_2_6Y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getRETAIL_2_7Y_LT_T_LTEQUALTO_8Y() {
		return RETAIL_2_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setRETAIL_2_7Y_LT_T_LTEQUALTO_8Y(BigDecimal rETAIL_2_7Y_LT_T_LTEQUALTO_8Y) {
		RETAIL_2_7Y_LT_T_LTEQUALTO_8Y = rETAIL_2_7Y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getRETAIL_2_8Y_LT_T_LTEQUALTO_9Y() {
		return RETAIL_2_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setRETAIL_2_8Y_LT_T_LTEQUALTO_9Y(BigDecimal rETAIL_2_8Y_LT_T_LTEQUALTO_9Y) {
		RETAIL_2_8Y_LT_T_LTEQUALTO_9Y = rETAIL_2_8Y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getRETAIL_2_9Y_LT_T_LTEQUALTO_10Y() {
		return RETAIL_2_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setRETAIL_2_9Y_LT_T_LTEQUALTO_10Y(BigDecimal rETAIL_2_9Y_LT_T_LTEQUALTO_10Y) {
		RETAIL_2_9Y_LT_T_LTEQUALTO_10Y = rETAIL_2_9Y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getRETAIL_2_10Y_LT_T_LTEQUALTO_15Y() {
		return RETAIL_2_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setRETAIL_2_10Y_LT_T_LTEQUALTO_15Y(BigDecimal rETAIL_2_10Y_LT_T_LTEQUALTO_15Y) {
		RETAIL_2_10Y_LT_T_LTEQUALTO_15Y = rETAIL_2_10Y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getRETAIL_2_15Y_LT_T_LTEQUALTO_20Y() {
		return RETAIL_2_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setRETAIL_2_15Y_LT_T_LTEQUALTO_20Y(BigDecimal rETAIL_2_15Y_LT_T_LTEQUALTO_20Y) {
		RETAIL_2_15Y_LT_T_LTEQUALTO_20Y = rETAIL_2_15Y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getRETAIL_2_TL_20Y() {
		return RETAIL_2_TL_20Y;
	}
	public void setRETAIL_2_TL_20Y(BigDecimal rETAIL_2_TL_20Y) {
		RETAIL_2_TL_20Y = rETAIL_2_TL_20Y;
	}
	public BigDecimal getRETAIL_2_NONSENSITIVE() {
		return RETAIL_2_NONSENSITIVE;
	}
	public void setRETAIL_2_NONSENSITIVE(BigDecimal rETAIL_2_NONSENSITIVE) {
		RETAIL_2_NONSENSITIVE = rETAIL_2_NONSENSITIVE;
	}
	public BigDecimal getRETAIL_2_TOTAL_RSL() {
		return RETAIL_2_TOTAL_RSL;
	}
	public void setRETAIL_2_TOTAL_RSL(BigDecimal rETAIL_2_TOTAL_RSL) {
		RETAIL_2_TOTAL_RSL = rETAIL_2_TOTAL_RSL;
	}
	public BigDecimal getRETAIL_2_TOTAL() {
		return RETAIL_2_TOTAL;
	}
	public void setRETAIL_2_TOTAL(BigDecimal rETAIL_2_TOTAL) {
		RETAIL_2_TOTAL = rETAIL_2_TOTAL;
	}
	public String getWHOLESALE_2_PRODUCT() {
		return WHOLESALE_2_PRODUCT;
	}
	public void setWHOLESALE_2_PRODUCT(String wHOLESALE_2_PRODUCT) {
		WHOLESALE_2_PRODUCT = wHOLESALE_2_PRODUCT;
	}
	public BigDecimal getWHOLESALE_2_TEQUALON() {
		return WHOLESALE_2_TEQUALON;
	}
	public void setWHOLESALE_2_TEQUALON(BigDecimal wHOLESALE_2_TEQUALON) {
		WHOLESALE_2_TEQUALON = wHOLESALE_2_TEQUALON;
	}
	public BigDecimal getWHOLESALE_2_ON_T_EQUALTO_1M() {
		return WHOLESALE_2_ON_T_EQUALTO_1M;
	}
	public void setWHOLESALE_2_ON_T_EQUALTO_1M(BigDecimal wHOLESALE_2_ON_T_EQUALTO_1M) {
		WHOLESALE_2_ON_T_EQUALTO_1M = wHOLESALE_2_ON_T_EQUALTO_1M;
	}
	public BigDecimal getWHOLESALE_2_1M_T_EQUALTO_3M() {
		return WHOLESALE_2_1M_T_EQUALTO_3M;
	}
	public void setWHOLESALE_2_1M_T_EQUALTO_3M(BigDecimal wHOLESALE_2_1M_T_EQUALTO_3M) {
		WHOLESALE_2_1M_T_EQUALTO_3M = wHOLESALE_2_1M_T_EQUALTO_3M;
	}
	public BigDecimal getWHOLESALE_2_3M_T_EQUALTO_6M() {
		return WHOLESALE_2_3M_T_EQUALTO_6M;
	}
	public void setWHOLESALE_2_3M_T_EQUALTO_6M(BigDecimal wHOLESALE_2_3M_T_EQUALTO_6M) {
		WHOLESALE_2_3M_T_EQUALTO_6M = wHOLESALE_2_3M_T_EQUALTO_6M;
	}
	public BigDecimal getWHOLESALE_2_6M_T_EQUALTO_9M() {
		return WHOLESALE_2_6M_T_EQUALTO_9M;
	}
	public void setWHOLESALE_2_6M_T_EQUALTO_9M(BigDecimal wHOLESALE_2_6M_T_EQUALTO_9M) {
		WHOLESALE_2_6M_T_EQUALTO_9M = wHOLESALE_2_6M_T_EQUALTO_9M;
	}
	public BigDecimal getWHOLESALE_2_9M_T_EQUALTO_1Y() {
		return WHOLESALE_2_9M_T_EQUALTO_1Y;
	}
	public void setWHOLESALE_2_9M_T_EQUALTO_1Y(BigDecimal wHOLESALE_2_9M_T_EQUALTO_1Y) {
		WHOLESALE_2_9M_T_EQUALTO_1Y = wHOLESALE_2_9M_T_EQUALTO_1Y;
	}
	public BigDecimal getWHOLESALE_2_1Y_T_EQUALTO_1POINT5Y() {
		return WHOLESALE_2_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setWHOLESALE_2_1Y_T_EQUALTO_1POINT5Y(BigDecimal wHOLESALE_2_1Y_T_EQUALTO_1POINT5Y) {
		WHOLESALE_2_1Y_T_EQUALTO_1POINT5Y = wHOLESALE_2_1Y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getWHOLESALE_2_1POINT5Y_T_EQUALTO_2Y() {
		return WHOLESALE_2_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setWHOLESALE_2_1POINT5Y_T_EQUALTO_2Y(BigDecimal wHOLESALE_2_1POINT5Y_T_EQUALTO_2Y) {
		WHOLESALE_2_1POINT5Y_T_EQUALTO_2Y = wHOLESALE_2_1POINT5Y_T_EQUALTO_2Y;
	}
	public BigDecimal getWHOLESALE_2_2Y_T_EQUALTO_3Y() {
		return WHOLESALE_2_2Y_T_EQUALTO_3Y;
	}
	public void setWHOLESALE_2_2Y_T_EQUALTO_3Y(BigDecimal wHOLESALE_2_2Y_T_EQUALTO_3Y) {
		WHOLESALE_2_2Y_T_EQUALTO_3Y = wHOLESALE_2_2Y_T_EQUALTO_3Y;
	}
	public BigDecimal getWHOLESALE_2_3Y_T_EQUALTO_4Y() {
		return WHOLESALE_2_3Y_T_EQUALTO_4Y;
	}
	public void setWHOLESALE_2_3Y_T_EQUALTO_4Y(BigDecimal wHOLESALE_2_3Y_T_EQUALTO_4Y) {
		WHOLESALE_2_3Y_T_EQUALTO_4Y = wHOLESALE_2_3Y_T_EQUALTO_4Y;
	}
	public BigDecimal getWHOLESALE_2_4Y_LT_T_LTEQUALTO_5Y() {
		return WHOLESALE_2_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setWHOLESALE_2_4Y_LT_T_LTEQUALTO_5Y(BigDecimal wHOLESALE_2_4Y_LT_T_LTEQUALTO_5Y) {
		WHOLESALE_2_4Y_LT_T_LTEQUALTO_5Y = wHOLESALE_2_4Y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getWHOLESALE_2_5Y_LT_T_LTEQUALTO_6Y() {
		return WHOLESALE_2_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setWHOLESALE_2_5Y_LT_T_LTEQUALTO_6Y(BigDecimal wHOLESALE_2_5Y_LT_T_LTEQUALTO_6Y) {
		WHOLESALE_2_5Y_LT_T_LTEQUALTO_6Y = wHOLESALE_2_5Y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getWHOLESALE_2_6Y_LT_T_LTEQUALTO_7Y() {
		return WHOLESALE_2_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setWHOLESALE_2_6Y_LT_T_LTEQUALTO_7Y(BigDecimal wHOLESALE_2_6Y_LT_T_LTEQUALTO_7Y) {
		WHOLESALE_2_6Y_LT_T_LTEQUALTO_7Y = wHOLESALE_2_6Y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getWHOLESALE_2_7Y_LT_T_LTEQUALTO_8Y() {
		return WHOLESALE_2_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setWHOLESALE_2_7Y_LT_T_LTEQUALTO_8Y(BigDecimal wHOLESALE_2_7Y_LT_T_LTEQUALTO_8Y) {
		WHOLESALE_2_7Y_LT_T_LTEQUALTO_8Y = wHOLESALE_2_7Y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getWHOLESALE_2_8Y_LT_T_LTEQUALTO_9Y() {
		return WHOLESALE_2_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setWHOLESALE_2_8Y_LT_T_LTEQUALTO_9Y(BigDecimal wHOLESALE_2_8Y_LT_T_LTEQUALTO_9Y) {
		WHOLESALE_2_8Y_LT_T_LTEQUALTO_9Y = wHOLESALE_2_8Y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getWHOLESALE_2_9Y_LT_T_LTEQUALTO_10Y() {
		return WHOLESALE_2_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setWHOLESALE_2_9Y_LT_T_LTEQUALTO_10Y(BigDecimal wHOLESALE_2_9Y_LT_T_LTEQUALTO_10Y) {
		WHOLESALE_2_9Y_LT_T_LTEQUALTO_10Y = wHOLESALE_2_9Y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getWHOLESALE_2_10Y_LT_T_LTEQUALTO_15Y() {
		return WHOLESALE_2_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setWHOLESALE_2_10Y_LT_T_LTEQUALTO_15Y(BigDecimal wHOLESALE_2_10Y_LT_T_LTEQUALTO_15Y) {
		WHOLESALE_2_10Y_LT_T_LTEQUALTO_15Y = wHOLESALE_2_10Y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getWHOLESALE_2_15Y_LT_T_LTEQUALTO_20Y() {
		return WHOLESALE_2_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setWHOLESALE_2_15Y_LT_T_LTEQUALTO_20Y(BigDecimal wHOLESALE_2_15Y_LT_T_LTEQUALTO_20Y) {
		WHOLESALE_2_15Y_LT_T_LTEQUALTO_20Y = wHOLESALE_2_15Y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getWHOLESALE_2_TL_20Y() {
		return WHOLESALE_2_TL_20Y;
	}
	public void setWHOLESALE_2_TL_20Y(BigDecimal wHOLESALE_2_TL_20Y) {
		WHOLESALE_2_TL_20Y = wHOLESALE_2_TL_20Y;
	}
	public BigDecimal getWHOLESALE_2_NONSENSITIVE() {
		return WHOLESALE_2_NONSENSITIVE;
	}
	public void setWHOLESALE_2_NONSENSITIVE(BigDecimal wHOLESALE_2_NONSENSITIVE) {
		WHOLESALE_2_NONSENSITIVE = wHOLESALE_2_NONSENSITIVE;
	}
	public BigDecimal getWHOLESALE_2_TOTAL_RSL() {
		return WHOLESALE_2_TOTAL_RSL;
	}
	public void setWHOLESALE_2_TOTAL_RSL(BigDecimal wHOLESALE_2_TOTAL_RSL) {
		WHOLESALE_2_TOTAL_RSL = wHOLESALE_2_TOTAL_RSL;
	}
	public BigDecimal getWHOLESALE_2_TOTAL() {
		return WHOLESALE_2_TOTAL;
	}
	public void setWHOLESALE_2_TOTAL(BigDecimal wHOLESALE_2_TOTAL) {
		WHOLESALE_2_TOTAL = wHOLESALE_2_TOTAL;
	}
	public String getRETAIL_FIXED_PRODUCT() {
		return RETAIL_FIXED_PRODUCT;
	}
	public void setRETAIL_FIXED_PRODUCT(String rETAIL_FIXED_PRODUCT) {
		RETAIL_FIXED_PRODUCT = rETAIL_FIXED_PRODUCT;
	}
	public BigDecimal getRETAIL_FIXED_TEQUALON() {
		return RETAIL_FIXED_TEQUALON;
	}
	public void setRETAIL_FIXED_TEQUALON(BigDecimal rETAIL_FIXED_TEQUALON) {
		RETAIL_FIXED_TEQUALON = rETAIL_FIXED_TEQUALON;
	}
	public BigDecimal getRETAIL_FIXED_ON_T_EQUALTO_1M() {
		return RETAIL_FIXED_ON_T_EQUALTO_1M;
	}
	public void setRETAIL_FIXED_ON_T_EQUALTO_1M(BigDecimal rETAIL_FIXED_ON_T_EQUALTO_1M) {
		RETAIL_FIXED_ON_T_EQUALTO_1M = rETAIL_FIXED_ON_T_EQUALTO_1M;
	}
	public BigDecimal getRETAIL_FIXED_1M_T_EQUALTO_3M() {
		return RETAIL_FIXED_1M_T_EQUALTO_3M;
	}
	public void setRETAIL_FIXED_1M_T_EQUALTO_3M(BigDecimal rETAIL_FIXED_1M_T_EQUALTO_3M) {
		RETAIL_FIXED_1M_T_EQUALTO_3M = rETAIL_FIXED_1M_T_EQUALTO_3M;
	}
	public BigDecimal getRETAIL_FIXED_3M_T_EQUALTO_6M() {
		return RETAIL_FIXED_3M_T_EQUALTO_6M;
	}
	public void setRETAIL_FIXED_3M_T_EQUALTO_6M(BigDecimal rETAIL_FIXED_3M_T_EQUALTO_6M) {
		RETAIL_FIXED_3M_T_EQUALTO_6M = rETAIL_FIXED_3M_T_EQUALTO_6M;
	}
	public BigDecimal getRETAIL_FIXED_6M_T_EQUALTO_9M() {
		return RETAIL_FIXED_6M_T_EQUALTO_9M;
	}
	public void setRETAIL_FIXED_6M_T_EQUALTO_9M(BigDecimal rETAIL_FIXED_6M_T_EQUALTO_9M) {
		RETAIL_FIXED_6M_T_EQUALTO_9M = rETAIL_FIXED_6M_T_EQUALTO_9M;
	}
	public BigDecimal getRETAIL_FIXED_9M_T_EQUALTO_1Y() {
		return RETAIL_FIXED_9M_T_EQUALTO_1Y;
	}
	public void setRETAIL_FIXED_9M_T_EQUALTO_1Y(BigDecimal rETAIL_FIXED_9M_T_EQUALTO_1Y) {
		RETAIL_FIXED_9M_T_EQUALTO_1Y = rETAIL_FIXED_9M_T_EQUALTO_1Y;
	}
	public BigDecimal getRETAIL_FIXED_1Y_T_EQUALTO_1POINT5Y() {
		return RETAIL_FIXED_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setRETAIL_FIXED_1Y_T_EQUALTO_1POINT5Y(BigDecimal rETAIL_FIXED_1Y_T_EQUALTO_1POINT5Y) {
		RETAIL_FIXED_1Y_T_EQUALTO_1POINT5Y = rETAIL_FIXED_1Y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getRETAIL_FIXED_1POINT5Y_T_EQUALTO_2Y() {
		return RETAIL_FIXED_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setRETAIL_FIXED_1POINT5Y_T_EQUALTO_2Y(BigDecimal rETAIL_FIXED_1POINT5Y_T_EQUALTO_2Y) {
		RETAIL_FIXED_1POINT5Y_T_EQUALTO_2Y = rETAIL_FIXED_1POINT5Y_T_EQUALTO_2Y;
	}
	public BigDecimal getRETAIL_FIXED_2Y_T_EQUALTO_3Y() {
		return RETAIL_FIXED_2Y_T_EQUALTO_3Y;
	}
	public void setRETAIL_FIXED_2Y_T_EQUALTO_3Y(BigDecimal rETAIL_FIXED_2Y_T_EQUALTO_3Y) {
		RETAIL_FIXED_2Y_T_EQUALTO_3Y = rETAIL_FIXED_2Y_T_EQUALTO_3Y;
	}
	public BigDecimal getRETAIL_FIXED_3Y_T_EQUALTO_4Y() {
		return RETAIL_FIXED_3Y_T_EQUALTO_4Y;
	}
	public void setRETAIL_FIXED_3Y_T_EQUALTO_4Y(BigDecimal rETAIL_FIXED_3Y_T_EQUALTO_4Y) {
		RETAIL_FIXED_3Y_T_EQUALTO_4Y = rETAIL_FIXED_3Y_T_EQUALTO_4Y;
	}
	public BigDecimal getRETAIL_FIXED_4Y_LT_T_LTEQUALTO_5Y() {
		return RETAIL_FIXED_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setRETAIL_FIXED_4Y_LT_T_LTEQUALTO_5Y(BigDecimal rETAIL_FIXED_4Y_LT_T_LTEQUALTO_5Y) {
		RETAIL_FIXED_4Y_LT_T_LTEQUALTO_5Y = rETAIL_FIXED_4Y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getRETAIL_FIXED_5Y_LT_T_LTEQUALTO_6Y() {
		return RETAIL_FIXED_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setRETAIL_FIXED_5Y_LT_T_LTEQUALTO_6Y(BigDecimal rETAIL_FIXED_5Y_LT_T_LTEQUALTO_6Y) {
		RETAIL_FIXED_5Y_LT_T_LTEQUALTO_6Y = rETAIL_FIXED_5Y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getRETAIL_FIXED_6Y_LT_T_LTEQUALTO_7Y() {
		return RETAIL_FIXED_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setRETAIL_FIXED_6Y_LT_T_LTEQUALTO_7Y(BigDecimal rETAIL_FIXED_6Y_LT_T_LTEQUALTO_7Y) {
		RETAIL_FIXED_6Y_LT_T_LTEQUALTO_7Y = rETAIL_FIXED_6Y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getRETAIL_FIXED_7Y_LT_T_LTEQUALTO_8Y() {
		return RETAIL_FIXED_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setRETAIL_FIXED_7Y_LT_T_LTEQUALTO_8Y(BigDecimal rETAIL_FIXED_7Y_LT_T_LTEQUALTO_8Y) {
		RETAIL_FIXED_7Y_LT_T_LTEQUALTO_8Y = rETAIL_FIXED_7Y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getRETAIL_FIXED_8Y_LT_T_LTEQUALTO_9Y() {
		return RETAIL_FIXED_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setRETAIL_FIXED_8Y_LT_T_LTEQUALTO_9Y(BigDecimal rETAIL_FIXED_8Y_LT_T_LTEQUALTO_9Y) {
		RETAIL_FIXED_8Y_LT_T_LTEQUALTO_9Y = rETAIL_FIXED_8Y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getRETAIL_FIXED_9Y_LT_T_LTEQUALTO_10Y() {
		return RETAIL_FIXED_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setRETAIL_FIXED_9Y_LT_T_LTEQUALTO_10Y(BigDecimal rETAIL_FIXED_9Y_LT_T_LTEQUALTO_10Y) {
		RETAIL_FIXED_9Y_LT_T_LTEQUALTO_10Y = rETAIL_FIXED_9Y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getRETAIL_FIXED_10Y_LT_T_LTEQUALTO_15Y() {
		return RETAIL_FIXED_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setRETAIL_FIXED_10Y_LT_T_LTEQUALTO_15Y(BigDecimal rETAIL_FIXED_10Y_LT_T_LTEQUALTO_15Y) {
		RETAIL_FIXED_10Y_LT_T_LTEQUALTO_15Y = rETAIL_FIXED_10Y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getRETAIL_FIXED_15Y_LT_T_LTEQUALTO_20Y() {
		return RETAIL_FIXED_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setRETAIL_FIXED_15Y_LT_T_LTEQUALTO_20Y(BigDecimal rETAIL_FIXED_15Y_LT_T_LTEQUALTO_20Y) {
		RETAIL_FIXED_15Y_LT_T_LTEQUALTO_20Y = rETAIL_FIXED_15Y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getRETAIL_FIXED_TL_20Y() {
		return RETAIL_FIXED_TL_20Y;
	}
	public void setRETAIL_FIXED_TL_20Y(BigDecimal rETAIL_FIXED_TL_20Y) {
		RETAIL_FIXED_TL_20Y = rETAIL_FIXED_TL_20Y;
	}
	public BigDecimal getRETAIL_FIXED_NONSENSITIVE() {
		return RETAIL_FIXED_NONSENSITIVE;
	}
	public void setRETAIL_FIXED_NONSENSITIVE(BigDecimal rETAIL_FIXED_NONSENSITIVE) {
		RETAIL_FIXED_NONSENSITIVE = rETAIL_FIXED_NONSENSITIVE;
	}
	public BigDecimal getRETAIL_FIXED_TOTAL_RSL() {
		return RETAIL_FIXED_TOTAL_RSL;
	}
	public void setRETAIL_FIXED_TOTAL_RSL(BigDecimal rETAIL_FIXED_TOTAL_RSL) {
		RETAIL_FIXED_TOTAL_RSL = rETAIL_FIXED_TOTAL_RSL;
	}
	public BigDecimal getRETAIL_FIXED_TOTAL() {
		return RETAIL_FIXED_TOTAL;
	}
	public void setRETAIL_FIXED_TOTAL(BigDecimal rETAIL_FIXED_TOTAL) {
		RETAIL_FIXED_TOTAL = rETAIL_FIXED_TOTAL;
	}
	public String getR97_PRODUCT() {
		return R97_PRODUCT;
	}
	public void setR97_PRODUCT(String r97_PRODUCT) {
		R97_PRODUCT = r97_PRODUCT;
	}
	public BigDecimal getR97_TEQUALON() {
		return R97_TEQUALON;
	}
	public void setR97_TEQUALON(BigDecimal r97_TEQUALON) {
		R97_TEQUALON = r97_TEQUALON;
	}
	public BigDecimal getR97_ON_T_EQUALTO_1M() {
		return R97_ON_T_EQUALTO_1M;
	}
	public void setR97_ON_T_EQUALTO_1M(BigDecimal r97_ON_T_EQUALTO_1M) {
		R97_ON_T_EQUALTO_1M = r97_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR97_1M_T_EQUALTO_3M() {
		return R97_1M_T_EQUALTO_3M;
	}
	public void setR97_1M_T_EQUALTO_3M(BigDecimal r97_1m_T_EQUALTO_3M) {
		R97_1M_T_EQUALTO_3M = r97_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR97_3M_T_EQUALTO_6M() {
		return R97_3M_T_EQUALTO_6M;
	}
	public void setR97_3M_T_EQUALTO_6M(BigDecimal r97_3m_T_EQUALTO_6M) {
		R97_3M_T_EQUALTO_6M = r97_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR97_6M_T_EQUALTO_9M() {
		return R97_6M_T_EQUALTO_9M;
	}
	public void setR97_6M_T_EQUALTO_9M(BigDecimal r97_6m_T_EQUALTO_9M) {
		R97_6M_T_EQUALTO_9M = r97_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR97_9M_T_EQUALTO_1Y() {
		return R97_9M_T_EQUALTO_1Y;
	}
	public void setR97_9M_T_EQUALTO_1Y(BigDecimal r97_9m_T_EQUALTO_1Y) {
		R97_9M_T_EQUALTO_1Y = r97_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR97_1Y_T_EQUALTO_1POINT5Y() {
		return R97_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR97_1Y_T_EQUALTO_1POINT5Y(BigDecimal r97_1y_T_EQUALTO_1POINT5Y) {
		R97_1Y_T_EQUALTO_1POINT5Y = r97_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR97_1POINT5Y_T_EQUALTO_2Y() {
		return R97_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR97_1POINT5Y_T_EQUALTO_2Y(BigDecimal r97_1point5y_T_EQUALTO_2Y) {
		R97_1POINT5Y_T_EQUALTO_2Y = r97_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR97_2Y_T_EQUALTO_3Y() {
		return R97_2Y_T_EQUALTO_3Y;
	}
	public void setR97_2Y_T_EQUALTO_3Y(BigDecimal r97_2y_T_EQUALTO_3Y) {
		R97_2Y_T_EQUALTO_3Y = r97_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR97_3Y_T_EQUALTO_4Y() {
		return R97_3Y_T_EQUALTO_4Y;
	}
	public void setR97_3Y_T_EQUALTO_4Y(BigDecimal r97_3y_T_EQUALTO_4Y) {
		R97_3Y_T_EQUALTO_4Y = r97_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR97_4Y_LT_T_LTEQUALTO_5Y() {
		return R97_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR97_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r97_4y_LT_T_LTEQUALTO_5Y) {
		R97_4Y_LT_T_LTEQUALTO_5Y = r97_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR97_5Y_LT_T_LTEQUALTO_6Y() {
		return R97_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR97_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r97_5y_LT_T_LTEQUALTO_6Y) {
		R97_5Y_LT_T_LTEQUALTO_6Y = r97_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR97_6Y_LT_T_LTEQUALTO_7Y() {
		return R97_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR97_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r97_6y_LT_T_LTEQUALTO_7Y) {
		R97_6Y_LT_T_LTEQUALTO_7Y = r97_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR97_7Y_LT_T_LTEQUALTO_8Y() {
		return R97_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR97_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r97_7y_LT_T_LTEQUALTO_8Y) {
		R97_7Y_LT_T_LTEQUALTO_8Y = r97_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR97_8Y_LT_T_LTEQUALTO_9Y() {
		return R97_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR97_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r97_8y_LT_T_LTEQUALTO_9Y) {
		R97_8Y_LT_T_LTEQUALTO_9Y = r97_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR97_9Y_LT_T_LTEQUALTO_10Y() {
		return R97_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR97_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r97_9y_LT_T_LTEQUALTO_10Y) {
		R97_9Y_LT_T_LTEQUALTO_10Y = r97_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR97_10Y_LT_T_LTEQUALTO_15Y() {
		return R97_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR97_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r97_10y_LT_T_LTEQUALTO_15Y) {
		R97_10Y_LT_T_LTEQUALTO_15Y = r97_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR97_15Y_LT_T_LTEQUALTO_20Y() {
		return R97_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR97_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r97_15y_LT_T_LTEQUALTO_20Y) {
		R97_15Y_LT_T_LTEQUALTO_20Y = r97_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR97_TL_20Y() {
		return R97_TL_20Y;
	}
	public void setR97_TL_20Y(BigDecimal r97_TL_20Y) {
		R97_TL_20Y = r97_TL_20Y;
	}
	public BigDecimal getR97_NONSENSITIVE() {
		return R97_NONSENSITIVE;
	}
	public void setR97_NONSENSITIVE(BigDecimal r97_NONSENSITIVE) {
		R97_NONSENSITIVE = r97_NONSENSITIVE;
	}
	public BigDecimal getR97_TOTAL_RSL() {
		return R97_TOTAL_RSL;
	}
	public void setR97_TOTAL_RSL(BigDecimal r97_TOTAL_RSL) {
		R97_TOTAL_RSL = r97_TOTAL_RSL;
	}
	public BigDecimal getR97_TOTAL() {
		return R97_TOTAL;
	}
	public void setR97_TOTAL(BigDecimal r97_TOTAL) {
		R97_TOTAL = r97_TOTAL;
	}
	public String getR98_PRODUCT() {
		return R98_PRODUCT;
	}
	public void setR98_PRODUCT(String r98_PRODUCT) {
		R98_PRODUCT = r98_PRODUCT;
	}
	public BigDecimal getR98_TEQUALON() {
		return R98_TEQUALON;
	}
	public void setR98_TEQUALON(BigDecimal r98_TEQUALON) {
		R98_TEQUALON = r98_TEQUALON;
	}
	public BigDecimal getR98_ON_T_EQUALTO_1M() {
		return R98_ON_T_EQUALTO_1M;
	}
	public void setR98_ON_T_EQUALTO_1M(BigDecimal r98_ON_T_EQUALTO_1M) {
		R98_ON_T_EQUALTO_1M = r98_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR98_1M_T_EQUALTO_3M() {
		return R98_1M_T_EQUALTO_3M;
	}
	public void setR98_1M_T_EQUALTO_3M(BigDecimal r98_1m_T_EQUALTO_3M) {
		R98_1M_T_EQUALTO_3M = r98_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR98_3M_T_EQUALTO_6M() {
		return R98_3M_T_EQUALTO_6M;
	}
	public void setR98_3M_T_EQUALTO_6M(BigDecimal r98_3m_T_EQUALTO_6M) {
		R98_3M_T_EQUALTO_6M = r98_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR98_6M_T_EQUALTO_9M() {
		return R98_6M_T_EQUALTO_9M;
	}
	public void setR98_6M_T_EQUALTO_9M(BigDecimal r98_6m_T_EQUALTO_9M) {
		R98_6M_T_EQUALTO_9M = r98_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR98_9M_T_EQUALTO_1Y() {
		return R98_9M_T_EQUALTO_1Y;
	}
	public void setR98_9M_T_EQUALTO_1Y(BigDecimal r98_9m_T_EQUALTO_1Y) {
		R98_9M_T_EQUALTO_1Y = r98_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR98_1Y_T_EQUALTO_1POINT5Y() {
		return R98_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR98_1Y_T_EQUALTO_1POINT5Y(BigDecimal r98_1y_T_EQUALTO_1POINT5Y) {
		R98_1Y_T_EQUALTO_1POINT5Y = r98_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR98_1POINT5Y_T_EQUALTO_2Y() {
		return R98_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR98_1POINT5Y_T_EQUALTO_2Y(BigDecimal r98_1point5y_T_EQUALTO_2Y) {
		R98_1POINT5Y_T_EQUALTO_2Y = r98_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR98_2Y_T_EQUALTO_3Y() {
		return R98_2Y_T_EQUALTO_3Y;
	}
	public void setR98_2Y_T_EQUALTO_3Y(BigDecimal r98_2y_T_EQUALTO_3Y) {
		R98_2Y_T_EQUALTO_3Y = r98_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR98_3Y_T_EQUALTO_4Y() {
		return R98_3Y_T_EQUALTO_4Y;
	}
	public void setR98_3Y_T_EQUALTO_4Y(BigDecimal r98_3y_T_EQUALTO_4Y) {
		R98_3Y_T_EQUALTO_4Y = r98_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR98_4Y_LT_T_LTEQUALTO_5Y() {
		return R98_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR98_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r98_4y_LT_T_LTEQUALTO_5Y) {
		R98_4Y_LT_T_LTEQUALTO_5Y = r98_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR98_5Y_LT_T_LTEQUALTO_6Y() {
		return R98_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR98_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r98_5y_LT_T_LTEQUALTO_6Y) {
		R98_5Y_LT_T_LTEQUALTO_6Y = r98_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR98_6Y_LT_T_LTEQUALTO_7Y() {
		return R98_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR98_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r98_6y_LT_T_LTEQUALTO_7Y) {
		R98_6Y_LT_T_LTEQUALTO_7Y = r98_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR98_7Y_LT_T_LTEQUALTO_8Y() {
		return R98_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR98_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r98_7y_LT_T_LTEQUALTO_8Y) {
		R98_7Y_LT_T_LTEQUALTO_8Y = r98_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR98_8Y_LT_T_LTEQUALTO_9Y() {
		return R98_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR98_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r98_8y_LT_T_LTEQUALTO_9Y) {
		R98_8Y_LT_T_LTEQUALTO_9Y = r98_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR98_9Y_LT_T_LTEQUALTO_10Y() {
		return R98_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR98_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r98_9y_LT_T_LTEQUALTO_10Y) {
		R98_9Y_LT_T_LTEQUALTO_10Y = r98_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR98_10Y_LT_T_LTEQUALTO_15Y() {
		return R98_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR98_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r98_10y_LT_T_LTEQUALTO_15Y) {
		R98_10Y_LT_T_LTEQUALTO_15Y = r98_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR98_15Y_LT_T_LTEQUALTO_20Y() {
		return R98_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR98_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r98_15y_LT_T_LTEQUALTO_20Y) {
		R98_15Y_LT_T_LTEQUALTO_20Y = r98_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR98_TL_20Y() {
		return R98_TL_20Y;
	}
	public void setR98_TL_20Y(BigDecimal r98_TL_20Y) {
		R98_TL_20Y = r98_TL_20Y;
	}
	public BigDecimal getR98_NONSENSITIVE() {
		return R98_NONSENSITIVE;
	}
	public void setR98_NONSENSITIVE(BigDecimal r98_NONSENSITIVE) {
		R98_NONSENSITIVE = r98_NONSENSITIVE;
	}
	public BigDecimal getR98_TOTAL_RSL() {
		return R98_TOTAL_RSL;
	}
	public void setR98_TOTAL_RSL(BigDecimal r98_TOTAL_RSL) {
		R98_TOTAL_RSL = r98_TOTAL_RSL;
	}
	public BigDecimal getR98_TOTAL() {
		return R98_TOTAL;
	}
	public void setR98_TOTAL(BigDecimal r98_TOTAL) {
		R98_TOTAL = r98_TOTAL;
	}
	public String getR99_PRODUCT() {
		return R99_PRODUCT;
	}
	public void setR99_PRODUCT(String r99_PRODUCT) {
		R99_PRODUCT = r99_PRODUCT;
	}
	public BigDecimal getR99_TEQUALON() {
		return R99_TEQUALON;
	}
	public void setR99_TEQUALON(BigDecimal r99_TEQUALON) {
		R99_TEQUALON = r99_TEQUALON;
	}
	public BigDecimal getR99_ON_T_EQUALTO_1M() {
		return R99_ON_T_EQUALTO_1M;
	}
	public void setR99_ON_T_EQUALTO_1M(BigDecimal r99_ON_T_EQUALTO_1M) {
		R99_ON_T_EQUALTO_1M = r99_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR99_1M_T_EQUALTO_3M() {
		return R99_1M_T_EQUALTO_3M;
	}
	public void setR99_1M_T_EQUALTO_3M(BigDecimal r99_1m_T_EQUALTO_3M) {
		R99_1M_T_EQUALTO_3M = r99_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR99_3M_T_EQUALTO_6M() {
		return R99_3M_T_EQUALTO_6M;
	}
	public void setR99_3M_T_EQUALTO_6M(BigDecimal r99_3m_T_EQUALTO_6M) {
		R99_3M_T_EQUALTO_6M = r99_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR99_6M_T_EQUALTO_9M() {
		return R99_6M_T_EQUALTO_9M;
	}
	public void setR99_6M_T_EQUALTO_9M(BigDecimal r99_6m_T_EQUALTO_9M) {
		R99_6M_T_EQUALTO_9M = r99_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR99_9M_T_EQUALTO_1Y() {
		return R99_9M_T_EQUALTO_1Y;
	}
	public void setR99_9M_T_EQUALTO_1Y(BigDecimal r99_9m_T_EQUALTO_1Y) {
		R99_9M_T_EQUALTO_1Y = r99_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR99_1Y_T_EQUALTO_1POINT5Y() {
		return R99_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR99_1Y_T_EQUALTO_1POINT5Y(BigDecimal r99_1y_T_EQUALTO_1POINT5Y) {
		R99_1Y_T_EQUALTO_1POINT5Y = r99_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR99_1POINT5Y_T_EQUALTO_2Y() {
		return R99_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR99_1POINT5Y_T_EQUALTO_2Y(BigDecimal r99_1point5y_T_EQUALTO_2Y) {
		R99_1POINT5Y_T_EQUALTO_2Y = r99_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR99_2Y_T_EQUALTO_3Y() {
		return R99_2Y_T_EQUALTO_3Y;
	}
	public void setR99_2Y_T_EQUALTO_3Y(BigDecimal r99_2y_T_EQUALTO_3Y) {
		R99_2Y_T_EQUALTO_3Y = r99_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR99_3Y_T_EQUALTO_4Y() {
		return R99_3Y_T_EQUALTO_4Y;
	}
	public void setR99_3Y_T_EQUALTO_4Y(BigDecimal r99_3y_T_EQUALTO_4Y) {
		R99_3Y_T_EQUALTO_4Y = r99_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR99_4Y_LT_T_LTEQUALTO_5Y() {
		return R99_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR99_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r99_4y_LT_T_LTEQUALTO_5Y) {
		R99_4Y_LT_T_LTEQUALTO_5Y = r99_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR99_5Y_LT_T_LTEQUALTO_6Y() {
		return R99_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR99_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r99_5y_LT_T_LTEQUALTO_6Y) {
		R99_5Y_LT_T_LTEQUALTO_6Y = r99_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR99_6Y_LT_T_LTEQUALTO_7Y() {
		return R99_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR99_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r99_6y_LT_T_LTEQUALTO_7Y) {
		R99_6Y_LT_T_LTEQUALTO_7Y = r99_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR99_7Y_LT_T_LTEQUALTO_8Y() {
		return R99_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR99_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r99_7y_LT_T_LTEQUALTO_8Y) {
		R99_7Y_LT_T_LTEQUALTO_8Y = r99_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR99_8Y_LT_T_LTEQUALTO_9Y() {
		return R99_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR99_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r99_8y_LT_T_LTEQUALTO_9Y) {
		R99_8Y_LT_T_LTEQUALTO_9Y = r99_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR99_9Y_LT_T_LTEQUALTO_10Y() {
		return R99_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR99_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r99_9y_LT_T_LTEQUALTO_10Y) {
		R99_9Y_LT_T_LTEQUALTO_10Y = r99_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR99_10Y_LT_T_LTEQUALTO_15Y() {
		return R99_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR99_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r99_10y_LT_T_LTEQUALTO_15Y) {
		R99_10Y_LT_T_LTEQUALTO_15Y = r99_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR99_15Y_LT_T_LTEQUALTO_20Y() {
		return R99_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR99_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r99_15y_LT_T_LTEQUALTO_20Y) {
		R99_15Y_LT_T_LTEQUALTO_20Y = r99_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR99_TL_20Y() {
		return R99_TL_20Y;
	}
	public void setR99_TL_20Y(BigDecimal r99_TL_20Y) {
		R99_TL_20Y = r99_TL_20Y;
	}
	public BigDecimal getR99_NONSENSITIVE() {
		return R99_NONSENSITIVE;
	}
	public void setR99_NONSENSITIVE(BigDecimal r99_NONSENSITIVE) {
		R99_NONSENSITIVE = r99_NONSENSITIVE;
	}
	public BigDecimal getR99_TOTAL_RSL() {
		return R99_TOTAL_RSL;
	}
	public void setR99_TOTAL_RSL(BigDecimal r99_TOTAL_RSL) {
		R99_TOTAL_RSL = r99_TOTAL_RSL;
	}
	public BigDecimal getR99_TOTAL() {
		return R99_TOTAL;
	}
	public void setR99_TOTAL(BigDecimal r99_TOTAL) {
		R99_TOTAL = r99_TOTAL;
	}
	public String getR100_PRODUCT() {
		return R100_PRODUCT;
	}
	public void setR100_PRODUCT(String r100_PRODUCT) {
		R100_PRODUCT = r100_PRODUCT;
	}
	public BigDecimal getR100_TEQUALON() {
		return R100_TEQUALON;
	}
	public void setR100_TEQUALON(BigDecimal r100_TEQUALON) {
		R100_TEQUALON = r100_TEQUALON;
	}
	public BigDecimal getR100_ON_T_EQUALTO_1M() {
		return R100_ON_T_EQUALTO_1M;
	}
	public void setR100_ON_T_EQUALTO_1M(BigDecimal r100_ON_T_EQUALTO_1M) {
		R100_ON_T_EQUALTO_1M = r100_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR100_1M_T_EQUALTO_3M() {
		return R100_1M_T_EQUALTO_3M;
	}
	public void setR100_1M_T_EQUALTO_3M(BigDecimal r100_1m_T_EQUALTO_3M) {
		R100_1M_T_EQUALTO_3M = r100_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR100_3M_T_EQUALTO_6M() {
		return R100_3M_T_EQUALTO_6M;
	}
	public void setR100_3M_T_EQUALTO_6M(BigDecimal r100_3m_T_EQUALTO_6M) {
		R100_3M_T_EQUALTO_6M = r100_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR100_6M_T_EQUALTO_9M() {
		return R100_6M_T_EQUALTO_9M;
	}
	public void setR100_6M_T_EQUALTO_9M(BigDecimal r100_6m_T_EQUALTO_9M) {
		R100_6M_T_EQUALTO_9M = r100_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR100_9M_T_EQUALTO_1Y() {
		return R100_9M_T_EQUALTO_1Y;
	}
	public void setR100_9M_T_EQUALTO_1Y(BigDecimal r100_9m_T_EQUALTO_1Y) {
		R100_9M_T_EQUALTO_1Y = r100_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR100_1Y_T_EQUALTO_1POINT5Y() {
		return R100_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR100_1Y_T_EQUALTO_1POINT5Y(BigDecimal r100_1y_T_EQUALTO_1POINT5Y) {
		R100_1Y_T_EQUALTO_1POINT5Y = r100_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR100_1POINT5Y_T_EQUALTO_2Y() {
		return R100_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR100_1POINT5Y_T_EQUALTO_2Y(BigDecimal r100_1point5y_T_EQUALTO_2Y) {
		R100_1POINT5Y_T_EQUALTO_2Y = r100_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR100_2Y_T_EQUALTO_3Y() {
		return R100_2Y_T_EQUALTO_3Y;
	}
	public void setR100_2Y_T_EQUALTO_3Y(BigDecimal r100_2y_T_EQUALTO_3Y) {
		R100_2Y_T_EQUALTO_3Y = r100_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR100_3Y_T_EQUALTO_4Y() {
		return R100_3Y_T_EQUALTO_4Y;
	}
	public void setR100_3Y_T_EQUALTO_4Y(BigDecimal r100_3y_T_EQUALTO_4Y) {
		R100_3Y_T_EQUALTO_4Y = r100_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR100_4Y_LT_T_LTEQUALTO_5Y() {
		return R100_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR100_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r100_4y_LT_T_LTEQUALTO_5Y) {
		R100_4Y_LT_T_LTEQUALTO_5Y = r100_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR100_5Y_LT_T_LTEQUALTO_6Y() {
		return R100_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR100_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r100_5y_LT_T_LTEQUALTO_6Y) {
		R100_5Y_LT_T_LTEQUALTO_6Y = r100_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR100_6Y_LT_T_LTEQUALTO_7Y() {
		return R100_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR100_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r100_6y_LT_T_LTEQUALTO_7Y) {
		R100_6Y_LT_T_LTEQUALTO_7Y = r100_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR100_7Y_LT_T_LTEQUALTO_8Y() {
		return R100_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR100_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r100_7y_LT_T_LTEQUALTO_8Y) {
		R100_7Y_LT_T_LTEQUALTO_8Y = r100_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR100_8Y_LT_T_LTEQUALTO_9Y() {
		return R100_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR100_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r100_8y_LT_T_LTEQUALTO_9Y) {
		R100_8Y_LT_T_LTEQUALTO_9Y = r100_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR100_9Y_LT_T_LTEQUALTO_10Y() {
		return R100_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR100_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r100_9y_LT_T_LTEQUALTO_10Y) {
		R100_9Y_LT_T_LTEQUALTO_10Y = r100_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR100_10Y_LT_T_LTEQUALTO_15Y() {
		return R100_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR100_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r100_10y_LT_T_LTEQUALTO_15Y) {
		R100_10Y_LT_T_LTEQUALTO_15Y = r100_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR100_15Y_LT_T_LTEQUALTO_20Y() {
		return R100_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR100_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r100_15y_LT_T_LTEQUALTO_20Y) {
		R100_15Y_LT_T_LTEQUALTO_20Y = r100_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR100_TL_20Y() {
		return R100_TL_20Y;
	}
	public void setR100_TL_20Y(BigDecimal r100_TL_20Y) {
		R100_TL_20Y = r100_TL_20Y;
	}
	public BigDecimal getR100_NONSENSITIVE() {
		return R100_NONSENSITIVE;
	}
	public void setR100_NONSENSITIVE(BigDecimal r100_NONSENSITIVE) {
		R100_NONSENSITIVE = r100_NONSENSITIVE;
	}
	public BigDecimal getR100_TOTAL_RSL() {
		return R100_TOTAL_RSL;
	}
	public void setR100_TOTAL_RSL(BigDecimal r100_TOTAL_RSL) {
		R100_TOTAL_RSL = r100_TOTAL_RSL;
	}
	public BigDecimal getR100_TOTAL() {
		return R100_TOTAL;
	}
	public void setR100_TOTAL(BigDecimal r100_TOTAL) {
		R100_TOTAL = r100_TOTAL;
	}
	public String getR102_PRODUCT() {
		return R102_PRODUCT;
	}
	public void setR102_PRODUCT(String r102_PRODUCT) {
		R102_PRODUCT = r102_PRODUCT;
	}
	public BigDecimal getR102_TEQUALON() {
		return R102_TEQUALON;
	}
	public void setR102_TEQUALON(BigDecimal r102_TEQUALON) {
		R102_TEQUALON = r102_TEQUALON;
	}
	public BigDecimal getR102_ON_T_EQUALTO_1M() {
		return R102_ON_T_EQUALTO_1M;
	}
	public void setR102_ON_T_EQUALTO_1M(BigDecimal r102_ON_T_EQUALTO_1M) {
		R102_ON_T_EQUALTO_1M = r102_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR102_1M_T_EQUALTO_3M() {
		return R102_1M_T_EQUALTO_3M;
	}
	public void setR102_1M_T_EQUALTO_3M(BigDecimal r102_1m_T_EQUALTO_3M) {
		R102_1M_T_EQUALTO_3M = r102_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR102_3M_T_EQUALTO_6M() {
		return R102_3M_T_EQUALTO_6M;
	}
	public void setR102_3M_T_EQUALTO_6M(BigDecimal r102_3m_T_EQUALTO_6M) {
		R102_3M_T_EQUALTO_6M = r102_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR102_6M_T_EQUALTO_9M() {
		return R102_6M_T_EQUALTO_9M;
	}
	public void setR102_6M_T_EQUALTO_9M(BigDecimal r102_6m_T_EQUALTO_9M) {
		R102_6M_T_EQUALTO_9M = r102_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR102_9M_T_EQUALTO_1Y() {
		return R102_9M_T_EQUALTO_1Y;
	}
	public void setR102_9M_T_EQUALTO_1Y(BigDecimal r102_9m_T_EQUALTO_1Y) {
		R102_9M_T_EQUALTO_1Y = r102_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR102_1Y_T_EQUALTO_1POINT5Y() {
		return R102_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR102_1Y_T_EQUALTO_1POINT5Y(BigDecimal r102_1y_T_EQUALTO_1POINT5Y) {
		R102_1Y_T_EQUALTO_1POINT5Y = r102_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR102_1POINT5Y_T_EQUALTO_2Y() {
		return R102_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR102_1POINT5Y_T_EQUALTO_2Y(BigDecimal r102_1point5y_T_EQUALTO_2Y) {
		R102_1POINT5Y_T_EQUALTO_2Y = r102_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR102_2Y_T_EQUALTO_3Y() {
		return R102_2Y_T_EQUALTO_3Y;
	}
	public void setR102_2Y_T_EQUALTO_3Y(BigDecimal r102_2y_T_EQUALTO_3Y) {
		R102_2Y_T_EQUALTO_3Y = r102_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR102_3Y_T_EQUALTO_4Y() {
		return R102_3Y_T_EQUALTO_4Y;
	}
	public void setR102_3Y_T_EQUALTO_4Y(BigDecimal r102_3y_T_EQUALTO_4Y) {
		R102_3Y_T_EQUALTO_4Y = r102_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR102_4Y_LT_T_LTEQUALTO_5Y() {
		return R102_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR102_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r102_4y_LT_T_LTEQUALTO_5Y) {
		R102_4Y_LT_T_LTEQUALTO_5Y = r102_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR102_5Y_LT_T_LTEQUALTO_6Y() {
		return R102_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR102_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r102_5y_LT_T_LTEQUALTO_6Y) {
		R102_5Y_LT_T_LTEQUALTO_6Y = r102_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR102_6Y_LT_T_LTEQUALTO_7Y() {
		return R102_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR102_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r102_6y_LT_T_LTEQUALTO_7Y) {
		R102_6Y_LT_T_LTEQUALTO_7Y = r102_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR102_7Y_LT_T_LTEQUALTO_8Y() {
		return R102_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR102_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r102_7y_LT_T_LTEQUALTO_8Y) {
		R102_7Y_LT_T_LTEQUALTO_8Y = r102_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR102_8Y_LT_T_LTEQUALTO_9Y() {
		return R102_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR102_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r102_8y_LT_T_LTEQUALTO_9Y) {
		R102_8Y_LT_T_LTEQUALTO_9Y = r102_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR102_9Y_LT_T_LTEQUALTO_10Y() {
		return R102_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR102_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r102_9y_LT_T_LTEQUALTO_10Y) {
		R102_9Y_LT_T_LTEQUALTO_10Y = r102_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR102_10Y_LT_T_LTEQUALTO_15Y() {
		return R102_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR102_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r102_10y_LT_T_LTEQUALTO_15Y) {
		R102_10Y_LT_T_LTEQUALTO_15Y = r102_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR102_15Y_LT_T_LTEQUALTO_20Y() {
		return R102_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR102_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r102_15y_LT_T_LTEQUALTO_20Y) {
		R102_15Y_LT_T_LTEQUALTO_20Y = r102_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR102_TL_20Y() {
		return R102_TL_20Y;
	}
	public void setR102_TL_20Y(BigDecimal r102_TL_20Y) {
		R102_TL_20Y = r102_TL_20Y;
	}
	public BigDecimal getR102_NONSENSITIVE() {
		return R102_NONSENSITIVE;
	}
	public void setR102_NONSENSITIVE(BigDecimal r102_NONSENSITIVE) {
		R102_NONSENSITIVE = r102_NONSENSITIVE;
	}
	public BigDecimal getR102_TOTAL_RSL() {
		return R102_TOTAL_RSL;
	}
	public void setR102_TOTAL_RSL(BigDecimal r102_TOTAL_RSL) {
		R102_TOTAL_RSL = r102_TOTAL_RSL;
	}
	public BigDecimal getR102_TOTAL() {
		return R102_TOTAL;
	}
	public void setR102_TOTAL(BigDecimal r102_TOTAL) {
		R102_TOTAL = r102_TOTAL;
	}
	public String getR103_PRODUCT() {
		return R103_PRODUCT;
	}
	public void setR103_PRODUCT(String r103_PRODUCT) {
		R103_PRODUCT = r103_PRODUCT;
	}
	public BigDecimal getR103_TEQUALON() {
		return R103_TEQUALON;
	}
	public void setR103_TEQUALON(BigDecimal r103_TEQUALON) {
		R103_TEQUALON = r103_TEQUALON;
	}
	public BigDecimal getR103_ON_T_EQUALTO_1M() {
		return R103_ON_T_EQUALTO_1M;
	}
	public void setR103_ON_T_EQUALTO_1M(BigDecimal r103_ON_T_EQUALTO_1M) {
		R103_ON_T_EQUALTO_1M = r103_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR103_1M_T_EQUALTO_3M() {
		return R103_1M_T_EQUALTO_3M;
	}
	public void setR103_1M_T_EQUALTO_3M(BigDecimal r103_1m_T_EQUALTO_3M) {
		R103_1M_T_EQUALTO_3M = r103_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR103_3M_T_EQUALTO_6M() {
		return R103_3M_T_EQUALTO_6M;
	}
	public void setR103_3M_T_EQUALTO_6M(BigDecimal r103_3m_T_EQUALTO_6M) {
		R103_3M_T_EQUALTO_6M = r103_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR103_6M_T_EQUALTO_9M() {
		return R103_6M_T_EQUALTO_9M;
	}
	public void setR103_6M_T_EQUALTO_9M(BigDecimal r103_6m_T_EQUALTO_9M) {
		R103_6M_T_EQUALTO_9M = r103_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR103_9M_T_EQUALTO_1Y() {
		return R103_9M_T_EQUALTO_1Y;
	}
	public void setR103_9M_T_EQUALTO_1Y(BigDecimal r103_9m_T_EQUALTO_1Y) {
		R103_9M_T_EQUALTO_1Y = r103_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR103_1Y_T_EQUALTO_1POINT5Y() {
		return R103_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR103_1Y_T_EQUALTO_1POINT5Y(BigDecimal r103_1y_T_EQUALTO_1POINT5Y) {
		R103_1Y_T_EQUALTO_1POINT5Y = r103_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR103_1POINT5Y_T_EQUALTO_2Y() {
		return R103_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR103_1POINT5Y_T_EQUALTO_2Y(BigDecimal r103_1point5y_T_EQUALTO_2Y) {
		R103_1POINT5Y_T_EQUALTO_2Y = r103_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR103_2Y_T_EQUALTO_3Y() {
		return R103_2Y_T_EQUALTO_3Y;
	}
	public void setR103_2Y_T_EQUALTO_3Y(BigDecimal r103_2y_T_EQUALTO_3Y) {
		R103_2Y_T_EQUALTO_3Y = r103_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR103_3Y_T_EQUALTO_4Y() {
		return R103_3Y_T_EQUALTO_4Y;
	}
	public void setR103_3Y_T_EQUALTO_4Y(BigDecimal r103_3y_T_EQUALTO_4Y) {
		R103_3Y_T_EQUALTO_4Y = r103_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR103_4Y_LT_T_LTEQUALTO_5Y() {
		return R103_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR103_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r103_4y_LT_T_LTEQUALTO_5Y) {
		R103_4Y_LT_T_LTEQUALTO_5Y = r103_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR103_5Y_LT_T_LTEQUALTO_6Y() {
		return R103_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR103_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r103_5y_LT_T_LTEQUALTO_6Y) {
		R103_5Y_LT_T_LTEQUALTO_6Y = r103_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR103_6Y_LT_T_LTEQUALTO_7Y() {
		return R103_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR103_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r103_6y_LT_T_LTEQUALTO_7Y) {
		R103_6Y_LT_T_LTEQUALTO_7Y = r103_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR103_7Y_LT_T_LTEQUALTO_8Y() {
		return R103_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR103_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r103_7y_LT_T_LTEQUALTO_8Y) {
		R103_7Y_LT_T_LTEQUALTO_8Y = r103_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR103_8Y_LT_T_LTEQUALTO_9Y() {
		return R103_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR103_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r103_8y_LT_T_LTEQUALTO_9Y) {
		R103_8Y_LT_T_LTEQUALTO_9Y = r103_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR103_9Y_LT_T_LTEQUALTO_10Y() {
		return R103_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR103_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r103_9y_LT_T_LTEQUALTO_10Y) {
		R103_9Y_LT_T_LTEQUALTO_10Y = r103_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR103_10Y_LT_T_LTEQUALTO_15Y() {
		return R103_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR103_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r103_10y_LT_T_LTEQUALTO_15Y) {
		R103_10Y_LT_T_LTEQUALTO_15Y = r103_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR103_15Y_LT_T_LTEQUALTO_20Y() {
		return R103_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR103_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r103_15y_LT_T_LTEQUALTO_20Y) {
		R103_15Y_LT_T_LTEQUALTO_20Y = r103_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR103_TL_20Y() {
		return R103_TL_20Y;
	}
	public void setR103_TL_20Y(BigDecimal r103_TL_20Y) {
		R103_TL_20Y = r103_TL_20Y;
	}
	public BigDecimal getR103_NONSENSITIVE() {
		return R103_NONSENSITIVE;
	}
	public void setR103_NONSENSITIVE(BigDecimal r103_NONSENSITIVE) {
		R103_NONSENSITIVE = r103_NONSENSITIVE;
	}
	public BigDecimal getR103_TOTAL_RSL() {
		return R103_TOTAL_RSL;
	}
	public void setR103_TOTAL_RSL(BigDecimal r103_TOTAL_RSL) {
		R103_TOTAL_RSL = r103_TOTAL_RSL;
	}
	public BigDecimal getR103_TOTAL() {
		return R103_TOTAL;
	}
	public void setR103_TOTAL(BigDecimal r103_TOTAL) {
		R103_TOTAL = r103_TOTAL;
	}
	public String getR104_PRODUCT() {
		return R104_PRODUCT;
	}
	public void setR104_PRODUCT(String r104_PRODUCT) {
		R104_PRODUCT = r104_PRODUCT;
	}
	public BigDecimal getR104_TEQUALON() {
		return R104_TEQUALON;
	}
	public void setR104_TEQUALON(BigDecimal r104_TEQUALON) {
		R104_TEQUALON = r104_TEQUALON;
	}
	public BigDecimal getR104_ON_T_EQUALTO_1M() {
		return R104_ON_T_EQUALTO_1M;
	}
	public void setR104_ON_T_EQUALTO_1M(BigDecimal r104_ON_T_EQUALTO_1M) {
		R104_ON_T_EQUALTO_1M = r104_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR104_1M_T_EQUALTO_3M() {
		return R104_1M_T_EQUALTO_3M;
	}
	public void setR104_1M_T_EQUALTO_3M(BigDecimal r104_1m_T_EQUALTO_3M) {
		R104_1M_T_EQUALTO_3M = r104_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR104_3M_T_EQUALTO_6M() {
		return R104_3M_T_EQUALTO_6M;
	}
	public void setR104_3M_T_EQUALTO_6M(BigDecimal r104_3m_T_EQUALTO_6M) {
		R104_3M_T_EQUALTO_6M = r104_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR104_6M_T_EQUALTO_9M() {
		return R104_6M_T_EQUALTO_9M;
	}
	public void setR104_6M_T_EQUALTO_9M(BigDecimal r104_6m_T_EQUALTO_9M) {
		R104_6M_T_EQUALTO_9M = r104_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR104_9M_T_EQUALTO_1Y() {
		return R104_9M_T_EQUALTO_1Y;
	}
	public void setR104_9M_T_EQUALTO_1Y(BigDecimal r104_9m_T_EQUALTO_1Y) {
		R104_9M_T_EQUALTO_1Y = r104_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR104_1Y_T_EQUALTO_1POINT5Y() {
		return R104_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR104_1Y_T_EQUALTO_1POINT5Y(BigDecimal r104_1y_T_EQUALTO_1POINT5Y) {
		R104_1Y_T_EQUALTO_1POINT5Y = r104_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR104_1POINT5Y_T_EQUALTO_2Y() {
		return R104_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR104_1POINT5Y_T_EQUALTO_2Y(BigDecimal r104_1point5y_T_EQUALTO_2Y) {
		R104_1POINT5Y_T_EQUALTO_2Y = r104_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR104_2Y_T_EQUALTO_3Y() {
		return R104_2Y_T_EQUALTO_3Y;
	}
	public void setR104_2Y_T_EQUALTO_3Y(BigDecimal r104_2y_T_EQUALTO_3Y) {
		R104_2Y_T_EQUALTO_3Y = r104_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR104_3Y_T_EQUALTO_4Y() {
		return R104_3Y_T_EQUALTO_4Y;
	}
	public void setR104_3Y_T_EQUALTO_4Y(BigDecimal r104_3y_T_EQUALTO_4Y) {
		R104_3Y_T_EQUALTO_4Y = r104_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR104_4Y_LT_T_LTEQUALTO_5Y() {
		return R104_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR104_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r104_4y_LT_T_LTEQUALTO_5Y) {
		R104_4Y_LT_T_LTEQUALTO_5Y = r104_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR104_5Y_LT_T_LTEQUALTO_6Y() {
		return R104_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR104_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r104_5y_LT_T_LTEQUALTO_6Y) {
		R104_5Y_LT_T_LTEQUALTO_6Y = r104_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR104_6Y_LT_T_LTEQUALTO_7Y() {
		return R104_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR104_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r104_6y_LT_T_LTEQUALTO_7Y) {
		R104_6Y_LT_T_LTEQUALTO_7Y = r104_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR104_7Y_LT_T_LTEQUALTO_8Y() {
		return R104_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR104_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r104_7y_LT_T_LTEQUALTO_8Y) {
		R104_7Y_LT_T_LTEQUALTO_8Y = r104_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR104_8Y_LT_T_LTEQUALTO_9Y() {
		return R104_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR104_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r104_8y_LT_T_LTEQUALTO_9Y) {
		R104_8Y_LT_T_LTEQUALTO_9Y = r104_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR104_9Y_LT_T_LTEQUALTO_10Y() {
		return R104_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR104_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r104_9y_LT_T_LTEQUALTO_10Y) {
		R104_9Y_LT_T_LTEQUALTO_10Y = r104_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR104_10Y_LT_T_LTEQUALTO_15Y() {
		return R104_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR104_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r104_10y_LT_T_LTEQUALTO_15Y) {
		R104_10Y_LT_T_LTEQUALTO_15Y = r104_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR104_15Y_LT_T_LTEQUALTO_20Y() {
		return R104_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR104_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r104_15y_LT_T_LTEQUALTO_20Y) {
		R104_15Y_LT_T_LTEQUALTO_20Y = r104_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR104_TL_20Y() {
		return R104_TL_20Y;
	}
	public void setR104_TL_20Y(BigDecimal r104_TL_20Y) {
		R104_TL_20Y = r104_TL_20Y;
	}
	public BigDecimal getR104_NONSENSITIVE() {
		return R104_NONSENSITIVE;
	}
	public void setR104_NONSENSITIVE(BigDecimal r104_NONSENSITIVE) {
		R104_NONSENSITIVE = r104_NONSENSITIVE;
	}
	public BigDecimal getR104_TOTAL_RSL() {
		return R104_TOTAL_RSL;
	}
	public void setR104_TOTAL_RSL(BigDecimal r104_TOTAL_RSL) {
		R104_TOTAL_RSL = r104_TOTAL_RSL;
	}
	public BigDecimal getR104_TOTAL() {
		return R104_TOTAL;
	}
	public void setR104_TOTAL(BigDecimal r104_TOTAL) {
		R104_TOTAL = r104_TOTAL;
	}
	public String getR107_PRODUCT() {
		return R107_PRODUCT;
	}
	public void setR107_PRODUCT(String r107_PRODUCT) {
		R107_PRODUCT = r107_PRODUCT;
	}
	public BigDecimal getR107_TEQUALON() {
		return R107_TEQUALON;
	}
	public void setR107_TEQUALON(BigDecimal r107_TEQUALON) {
		R107_TEQUALON = r107_TEQUALON;
	}
	public BigDecimal getR107_ON_T_EQUALTO_1M() {
		return R107_ON_T_EQUALTO_1M;
	}
	public void setR107_ON_T_EQUALTO_1M(BigDecimal r107_ON_T_EQUALTO_1M) {
		R107_ON_T_EQUALTO_1M = r107_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR107_1M_T_EQUALTO_3M() {
		return R107_1M_T_EQUALTO_3M;
	}
	public void setR107_1M_T_EQUALTO_3M(BigDecimal r107_1m_T_EQUALTO_3M) {
		R107_1M_T_EQUALTO_3M = r107_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR107_3M_T_EQUALTO_6M() {
		return R107_3M_T_EQUALTO_6M;
	}
	public void setR107_3M_T_EQUALTO_6M(BigDecimal r107_3m_T_EQUALTO_6M) {
		R107_3M_T_EQUALTO_6M = r107_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR107_6M_T_EQUALTO_9M() {
		return R107_6M_T_EQUALTO_9M;
	}
	public void setR107_6M_T_EQUALTO_9M(BigDecimal r107_6m_T_EQUALTO_9M) {
		R107_6M_T_EQUALTO_9M = r107_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR107_9M_T_EQUALTO_1Y() {
		return R107_9M_T_EQUALTO_1Y;
	}
	public void setR107_9M_T_EQUALTO_1Y(BigDecimal r107_9m_T_EQUALTO_1Y) {
		R107_9M_T_EQUALTO_1Y = r107_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR107_1Y_T_EQUALTO_1POINT5Y() {
		return R107_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR107_1Y_T_EQUALTO_1POINT5Y(BigDecimal r107_1y_T_EQUALTO_1POINT5Y) {
		R107_1Y_T_EQUALTO_1POINT5Y = r107_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR107_1POINT5Y_T_EQUALTO_2Y() {
		return R107_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR107_1POINT5Y_T_EQUALTO_2Y(BigDecimal r107_1point5y_T_EQUALTO_2Y) {
		R107_1POINT5Y_T_EQUALTO_2Y = r107_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR107_2Y_T_EQUALTO_3Y() {
		return R107_2Y_T_EQUALTO_3Y;
	}
	public void setR107_2Y_T_EQUALTO_3Y(BigDecimal r107_2y_T_EQUALTO_3Y) {
		R107_2Y_T_EQUALTO_3Y = r107_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR107_3Y_T_EQUALTO_4Y() {
		return R107_3Y_T_EQUALTO_4Y;
	}
	public void setR107_3Y_T_EQUALTO_4Y(BigDecimal r107_3y_T_EQUALTO_4Y) {
		R107_3Y_T_EQUALTO_4Y = r107_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR107_4Y_LT_T_LTEQUALTO_5Y() {
		return R107_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR107_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r107_4y_LT_T_LTEQUALTO_5Y) {
		R107_4Y_LT_T_LTEQUALTO_5Y = r107_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR107_5Y_LT_T_LTEQUALTO_6Y() {
		return R107_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR107_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r107_5y_LT_T_LTEQUALTO_6Y) {
		R107_5Y_LT_T_LTEQUALTO_6Y = r107_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR107_6Y_LT_T_LTEQUALTO_7Y() {
		return R107_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR107_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r107_6y_LT_T_LTEQUALTO_7Y) {
		R107_6Y_LT_T_LTEQUALTO_7Y = r107_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR107_7Y_LT_T_LTEQUALTO_8Y() {
		return R107_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR107_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r107_7y_LT_T_LTEQUALTO_8Y) {
		R107_7Y_LT_T_LTEQUALTO_8Y = r107_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR107_8Y_LT_T_LTEQUALTO_9Y() {
		return R107_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR107_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r107_8y_LT_T_LTEQUALTO_9Y) {
		R107_8Y_LT_T_LTEQUALTO_9Y = r107_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR107_9Y_LT_T_LTEQUALTO_10Y() {
		return R107_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR107_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r107_9y_LT_T_LTEQUALTO_10Y) {
		R107_9Y_LT_T_LTEQUALTO_10Y = r107_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR107_10Y_LT_T_LTEQUALTO_15Y() {
		return R107_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR107_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r107_10y_LT_T_LTEQUALTO_15Y) {
		R107_10Y_LT_T_LTEQUALTO_15Y = r107_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR107_15Y_LT_T_LTEQUALTO_20Y() {
		return R107_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR107_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r107_15y_LT_T_LTEQUALTO_20Y) {
		R107_15Y_LT_T_LTEQUALTO_20Y = r107_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR107_TL_20Y() {
		return R107_TL_20Y;
	}
	public void setR107_TL_20Y(BigDecimal r107_TL_20Y) {
		R107_TL_20Y = r107_TL_20Y;
	}
	public BigDecimal getR107_NONSENSITIVE() {
		return R107_NONSENSITIVE;
	}
	public void setR107_NONSENSITIVE(BigDecimal r107_NONSENSITIVE) {
		R107_NONSENSITIVE = r107_NONSENSITIVE;
	}
	public BigDecimal getR107_TOTAL_RSL() {
		return R107_TOTAL_RSL;
	}
	public void setR107_TOTAL_RSL(BigDecimal r107_TOTAL_RSL) {
		R107_TOTAL_RSL = r107_TOTAL_RSL;
	}
	public BigDecimal getR107_TOTAL() {
		return R107_TOTAL;
	}
	public void setR107_TOTAL(BigDecimal r107_TOTAL) {
		R107_TOTAL = r107_TOTAL;
	}
	public String getR108_PRODUCT() {
		return R108_PRODUCT;
	}
	public void setR108_PRODUCT(String r108_PRODUCT) {
		R108_PRODUCT = r108_PRODUCT;
	}
	public BigDecimal getR108_TEQUALON() {
		return R108_TEQUALON;
	}
	public void setR108_TEQUALON(BigDecimal r108_TEQUALON) {
		R108_TEQUALON = r108_TEQUALON;
	}
	public BigDecimal getR108_ON_T_EQUALTO_1M() {
		return R108_ON_T_EQUALTO_1M;
	}
	public void setR108_ON_T_EQUALTO_1M(BigDecimal r108_ON_T_EQUALTO_1M) {
		R108_ON_T_EQUALTO_1M = r108_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR108_1M_T_EQUALTO_3M() {
		return R108_1M_T_EQUALTO_3M;
	}
	public void setR108_1M_T_EQUALTO_3M(BigDecimal r108_1m_T_EQUALTO_3M) {
		R108_1M_T_EQUALTO_3M = r108_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR108_3M_T_EQUALTO_6M() {
		return R108_3M_T_EQUALTO_6M;
	}
	public void setR108_3M_T_EQUALTO_6M(BigDecimal r108_3m_T_EQUALTO_6M) {
		R108_3M_T_EQUALTO_6M = r108_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR108_6M_T_EQUALTO_9M() {
		return R108_6M_T_EQUALTO_9M;
	}
	public void setR108_6M_T_EQUALTO_9M(BigDecimal r108_6m_T_EQUALTO_9M) {
		R108_6M_T_EQUALTO_9M = r108_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR108_9M_T_EQUALTO_1Y() {
		return R108_9M_T_EQUALTO_1Y;
	}
	public void setR108_9M_T_EQUALTO_1Y(BigDecimal r108_9m_T_EQUALTO_1Y) {
		R108_9M_T_EQUALTO_1Y = r108_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR108_1Y_T_EQUALTO_1POINT5Y() {
		return R108_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR108_1Y_T_EQUALTO_1POINT5Y(BigDecimal r108_1y_T_EQUALTO_1POINT5Y) {
		R108_1Y_T_EQUALTO_1POINT5Y = r108_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR108_1POINT5Y_T_EQUALTO_2Y() {
		return R108_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR108_1POINT5Y_T_EQUALTO_2Y(BigDecimal r108_1point5y_T_EQUALTO_2Y) {
		R108_1POINT5Y_T_EQUALTO_2Y = r108_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR108_2Y_T_EQUALTO_3Y() {
		return R108_2Y_T_EQUALTO_3Y;
	}
	public void setR108_2Y_T_EQUALTO_3Y(BigDecimal r108_2y_T_EQUALTO_3Y) {
		R108_2Y_T_EQUALTO_3Y = r108_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR108_3Y_T_EQUALTO_4Y() {
		return R108_3Y_T_EQUALTO_4Y;
	}
	public void setR108_3Y_T_EQUALTO_4Y(BigDecimal r108_3y_T_EQUALTO_4Y) {
		R108_3Y_T_EQUALTO_4Y = r108_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR108_4Y_LT_T_LTEQUALTO_5Y() {
		return R108_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR108_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r108_4y_LT_T_LTEQUALTO_5Y) {
		R108_4Y_LT_T_LTEQUALTO_5Y = r108_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR108_5Y_LT_T_LTEQUALTO_6Y() {
		return R108_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR108_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r108_5y_LT_T_LTEQUALTO_6Y) {
		R108_5Y_LT_T_LTEQUALTO_6Y = r108_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR108_6Y_LT_T_LTEQUALTO_7Y() {
		return R108_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR108_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r108_6y_LT_T_LTEQUALTO_7Y) {
		R108_6Y_LT_T_LTEQUALTO_7Y = r108_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR108_7Y_LT_T_LTEQUALTO_8Y() {
		return R108_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR108_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r108_7y_LT_T_LTEQUALTO_8Y) {
		R108_7Y_LT_T_LTEQUALTO_8Y = r108_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR108_8Y_LT_T_LTEQUALTO_9Y() {
		return R108_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR108_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r108_8y_LT_T_LTEQUALTO_9Y) {
		R108_8Y_LT_T_LTEQUALTO_9Y = r108_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR108_9Y_LT_T_LTEQUALTO_10Y() {
		return R108_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR108_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r108_9y_LT_T_LTEQUALTO_10Y) {
		R108_9Y_LT_T_LTEQUALTO_10Y = r108_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR108_10Y_LT_T_LTEQUALTO_15Y() {
		return R108_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR108_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r108_10y_LT_T_LTEQUALTO_15Y) {
		R108_10Y_LT_T_LTEQUALTO_15Y = r108_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR108_15Y_LT_T_LTEQUALTO_20Y() {
		return R108_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR108_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r108_15y_LT_T_LTEQUALTO_20Y) {
		R108_15Y_LT_T_LTEQUALTO_20Y = r108_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR108_TL_20Y() {
		return R108_TL_20Y;
	}
	public void setR108_TL_20Y(BigDecimal r108_TL_20Y) {
		R108_TL_20Y = r108_TL_20Y;
	}
	public BigDecimal getR108_NONSENSITIVE() {
		return R108_NONSENSITIVE;
	}
	public void setR108_NONSENSITIVE(BigDecimal r108_NONSENSITIVE) {
		R108_NONSENSITIVE = r108_NONSENSITIVE;
	}
	public BigDecimal getR108_TOTAL_RSL() {
		return R108_TOTAL_RSL;
	}
	public void setR108_TOTAL_RSL(BigDecimal r108_TOTAL_RSL) {
		R108_TOTAL_RSL = r108_TOTAL_RSL;
	}
	public BigDecimal getR108_TOTAL() {
		return R108_TOTAL;
	}
	public void setR108_TOTAL(BigDecimal r108_TOTAL) {
		R108_TOTAL = r108_TOTAL;
	}
	public String getR109_PRODUCT() {
		return R109_PRODUCT;
	}
	public void setR109_PRODUCT(String r109_PRODUCT) {
		R109_PRODUCT = r109_PRODUCT;
	}
	public BigDecimal getR109_TEQUALON() {
		return R109_TEQUALON;
	}
	public void setR109_TEQUALON(BigDecimal r109_TEQUALON) {
		R109_TEQUALON = r109_TEQUALON;
	}
	public BigDecimal getR109_ON_T_EQUALTO_1M() {
		return R109_ON_T_EQUALTO_1M;
	}
	public void setR109_ON_T_EQUALTO_1M(BigDecimal r109_ON_T_EQUALTO_1M) {
		R109_ON_T_EQUALTO_1M = r109_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR109_1M_T_EQUALTO_3M() {
		return R109_1M_T_EQUALTO_3M;
	}
	public void setR109_1M_T_EQUALTO_3M(BigDecimal r109_1m_T_EQUALTO_3M) {
		R109_1M_T_EQUALTO_3M = r109_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR109_3M_T_EQUALTO_6M() {
		return R109_3M_T_EQUALTO_6M;
	}
	public void setR109_3M_T_EQUALTO_6M(BigDecimal r109_3m_T_EQUALTO_6M) {
		R109_3M_T_EQUALTO_6M = r109_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR109_6M_T_EQUALTO_9M() {
		return R109_6M_T_EQUALTO_9M;
	}
	public void setR109_6M_T_EQUALTO_9M(BigDecimal r109_6m_T_EQUALTO_9M) {
		R109_6M_T_EQUALTO_9M = r109_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR109_9M_T_EQUALTO_1Y() {
		return R109_9M_T_EQUALTO_1Y;
	}
	public void setR109_9M_T_EQUALTO_1Y(BigDecimal r109_9m_T_EQUALTO_1Y) {
		R109_9M_T_EQUALTO_1Y = r109_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR109_1Y_T_EQUALTO_1POINT5Y() {
		return R109_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR109_1Y_T_EQUALTO_1POINT5Y(BigDecimal r109_1y_T_EQUALTO_1POINT5Y) {
		R109_1Y_T_EQUALTO_1POINT5Y = r109_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR109_1POINT5Y_T_EQUALTO_2Y() {
		return R109_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR109_1POINT5Y_T_EQUALTO_2Y(BigDecimal r109_1point5y_T_EQUALTO_2Y) {
		R109_1POINT5Y_T_EQUALTO_2Y = r109_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR109_2Y_T_EQUALTO_3Y() {
		return R109_2Y_T_EQUALTO_3Y;
	}
	public void setR109_2Y_T_EQUALTO_3Y(BigDecimal r109_2y_T_EQUALTO_3Y) {
		R109_2Y_T_EQUALTO_3Y = r109_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR109_3Y_T_EQUALTO_4Y() {
		return R109_3Y_T_EQUALTO_4Y;
	}
	public void setR109_3Y_T_EQUALTO_4Y(BigDecimal r109_3y_T_EQUALTO_4Y) {
		R109_3Y_T_EQUALTO_4Y = r109_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR109_4Y_LT_T_LTEQUALTO_5Y() {
		return R109_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR109_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r109_4y_LT_T_LTEQUALTO_5Y) {
		R109_4Y_LT_T_LTEQUALTO_5Y = r109_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR109_5Y_LT_T_LTEQUALTO_6Y() {
		return R109_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR109_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r109_5y_LT_T_LTEQUALTO_6Y) {
		R109_5Y_LT_T_LTEQUALTO_6Y = r109_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR109_6Y_LT_T_LTEQUALTO_7Y() {
		return R109_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR109_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r109_6y_LT_T_LTEQUALTO_7Y) {
		R109_6Y_LT_T_LTEQUALTO_7Y = r109_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR109_7Y_LT_T_LTEQUALTO_8Y() {
		return R109_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR109_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r109_7y_LT_T_LTEQUALTO_8Y) {
		R109_7Y_LT_T_LTEQUALTO_8Y = r109_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR109_8Y_LT_T_LTEQUALTO_9Y() {
		return R109_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR109_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r109_8y_LT_T_LTEQUALTO_9Y) {
		R109_8Y_LT_T_LTEQUALTO_9Y = r109_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR109_9Y_LT_T_LTEQUALTO_10Y() {
		return R109_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR109_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r109_9y_LT_T_LTEQUALTO_10Y) {
		R109_9Y_LT_T_LTEQUALTO_10Y = r109_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR109_10Y_LT_T_LTEQUALTO_15Y() {
		return R109_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR109_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r109_10y_LT_T_LTEQUALTO_15Y) {
		R109_10Y_LT_T_LTEQUALTO_15Y = r109_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR109_15Y_LT_T_LTEQUALTO_20Y() {
		return R109_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR109_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r109_15y_LT_T_LTEQUALTO_20Y) {
		R109_15Y_LT_T_LTEQUALTO_20Y = r109_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR109_TL_20Y() {
		return R109_TL_20Y;
	}
	public void setR109_TL_20Y(BigDecimal r109_TL_20Y) {
		R109_TL_20Y = r109_TL_20Y;
	}
	public BigDecimal getR109_NONSENSITIVE() {
		return R109_NONSENSITIVE;
	}
	public void setR109_NONSENSITIVE(BigDecimal r109_NONSENSITIVE) {
		R109_NONSENSITIVE = r109_NONSENSITIVE;
	}
	public BigDecimal getR109_TOTAL_RSL() {
		return R109_TOTAL_RSL;
	}
	public void setR109_TOTAL_RSL(BigDecimal r109_TOTAL_RSL) {
		R109_TOTAL_RSL = r109_TOTAL_RSL;
	}
	public BigDecimal getR109_TOTAL() {
		return R109_TOTAL;
	}
	public void setR109_TOTAL(BigDecimal r109_TOTAL) {
		R109_TOTAL = r109_TOTAL;
	}
	public String getR117_PRODUCT() {
		return R117_PRODUCT;
	}
	public void setR117_PRODUCT(String r117_PRODUCT) {
		R117_PRODUCT = r117_PRODUCT;
	}
	public BigDecimal getR117_TEQUALON() {
		return R117_TEQUALON;
	}
	public void setR117_TEQUALON(BigDecimal r117_TEQUALON) {
		R117_TEQUALON = r117_TEQUALON;
	}
	public BigDecimal getR117_ON_T_EQUALTO_1M() {
		return R117_ON_T_EQUALTO_1M;
	}
	public void setR117_ON_T_EQUALTO_1M(BigDecimal r117_ON_T_EQUALTO_1M) {
		R117_ON_T_EQUALTO_1M = r117_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR117_1M_T_EQUALTO_3M() {
		return R117_1M_T_EQUALTO_3M;
	}
	public void setR117_1M_T_EQUALTO_3M(BigDecimal r117_1m_T_EQUALTO_3M) {
		R117_1M_T_EQUALTO_3M = r117_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR117_3M_T_EQUALTO_6M() {
		return R117_3M_T_EQUALTO_6M;
	}
	public void setR117_3M_T_EQUALTO_6M(BigDecimal r117_3m_T_EQUALTO_6M) {
		R117_3M_T_EQUALTO_6M = r117_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR117_6M_T_EQUALTO_9M() {
		return R117_6M_T_EQUALTO_9M;
	}
	public void setR117_6M_T_EQUALTO_9M(BigDecimal r117_6m_T_EQUALTO_9M) {
		R117_6M_T_EQUALTO_9M = r117_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR117_9M_T_EQUALTO_1Y() {
		return R117_9M_T_EQUALTO_1Y;
	}
	public void setR117_9M_T_EQUALTO_1Y(BigDecimal r117_9m_T_EQUALTO_1Y) {
		R117_9M_T_EQUALTO_1Y = r117_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR117_1Y_T_EQUALTO_1POINT5Y() {
		return R117_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR117_1Y_T_EQUALTO_1POINT5Y(BigDecimal r117_1y_T_EQUALTO_1POINT5Y) {
		R117_1Y_T_EQUALTO_1POINT5Y = r117_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR117_1POINT5Y_T_EQUALTO_2Y() {
		return R117_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR117_1POINT5Y_T_EQUALTO_2Y(BigDecimal r117_1point5y_T_EQUALTO_2Y) {
		R117_1POINT5Y_T_EQUALTO_2Y = r117_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR117_2Y_T_EQUALTO_3Y() {
		return R117_2Y_T_EQUALTO_3Y;
	}
	public void setR117_2Y_T_EQUALTO_3Y(BigDecimal r117_2y_T_EQUALTO_3Y) {
		R117_2Y_T_EQUALTO_3Y = r117_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR117_3Y_T_EQUALTO_4Y() {
		return R117_3Y_T_EQUALTO_4Y;
	}
	public void setR117_3Y_T_EQUALTO_4Y(BigDecimal r117_3y_T_EQUALTO_4Y) {
		R117_3Y_T_EQUALTO_4Y = r117_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR117_4Y_LT_T_LTEQUALTO_5Y() {
		return R117_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR117_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r117_4y_LT_T_LTEQUALTO_5Y) {
		R117_4Y_LT_T_LTEQUALTO_5Y = r117_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR117_5Y_LT_T_LTEQUALTO_6Y() {
		return R117_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR117_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r117_5y_LT_T_LTEQUALTO_6Y) {
		R117_5Y_LT_T_LTEQUALTO_6Y = r117_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR117_6Y_LT_T_LTEQUALTO_7Y() {
		return R117_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR117_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r117_6y_LT_T_LTEQUALTO_7Y) {
		R117_6Y_LT_T_LTEQUALTO_7Y = r117_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR117_7Y_LT_T_LTEQUALTO_8Y() {
		return R117_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR117_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r117_7y_LT_T_LTEQUALTO_8Y) {
		R117_7Y_LT_T_LTEQUALTO_8Y = r117_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR117_8Y_LT_T_LTEQUALTO_9Y() {
		return R117_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR117_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r117_8y_LT_T_LTEQUALTO_9Y) {
		R117_8Y_LT_T_LTEQUALTO_9Y = r117_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR117_9Y_LT_T_LTEQUALTO_10Y() {
		return R117_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR117_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r117_9y_LT_T_LTEQUALTO_10Y) {
		R117_9Y_LT_T_LTEQUALTO_10Y = r117_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR117_10Y_LT_T_LTEQUALTO_15Y() {
		return R117_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR117_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r117_10y_LT_T_LTEQUALTO_15Y) {
		R117_10Y_LT_T_LTEQUALTO_15Y = r117_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR117_15Y_LT_T_LTEQUALTO_20Y() {
		return R117_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR117_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r117_15y_LT_T_LTEQUALTO_20Y) {
		R117_15Y_LT_T_LTEQUALTO_20Y = r117_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR117_TL_20Y() {
		return R117_TL_20Y;
	}
	public void setR117_TL_20Y(BigDecimal r117_TL_20Y) {
		R117_TL_20Y = r117_TL_20Y;
	}
	public BigDecimal getR117_NONSENSITIVE() {
		return R117_NONSENSITIVE;
	}
	public void setR117_NONSENSITIVE(BigDecimal r117_NONSENSITIVE) {
		R117_NONSENSITIVE = r117_NONSENSITIVE;
	}
	public BigDecimal getR117_TOTAL_RSL() {
		return R117_TOTAL_RSL;
	}
	public void setR117_TOTAL_RSL(BigDecimal r117_TOTAL_RSL) {
		R117_TOTAL_RSL = r117_TOTAL_RSL;
	}
	public BigDecimal getR117_TOTAL() {
		return R117_TOTAL;
	}
	public void setR117_TOTAL(BigDecimal r117_TOTAL) {
		R117_TOTAL = r117_TOTAL;
	}
	public String getR118_PRODUCT() {
		return R118_PRODUCT;
	}
	public void setR118_PRODUCT(String r118_PRODUCT) {
		R118_PRODUCT = r118_PRODUCT;
	}
	public BigDecimal getR118_TEQUALON() {
		return R118_TEQUALON;
	}
	public void setR118_TEQUALON(BigDecimal r118_TEQUALON) {
		R118_TEQUALON = r118_TEQUALON;
	}
	public BigDecimal getR118_ON_T_EQUALTO_1M() {
		return R118_ON_T_EQUALTO_1M;
	}
	public void setR118_ON_T_EQUALTO_1M(BigDecimal r118_ON_T_EQUALTO_1M) {
		R118_ON_T_EQUALTO_1M = r118_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR118_1M_T_EQUALTO_3M() {
		return R118_1M_T_EQUALTO_3M;
	}
	public void setR118_1M_T_EQUALTO_3M(BigDecimal r118_1m_T_EQUALTO_3M) {
		R118_1M_T_EQUALTO_3M = r118_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR118_3M_T_EQUALTO_6M() {
		return R118_3M_T_EQUALTO_6M;
	}
	public void setR118_3M_T_EQUALTO_6M(BigDecimal r118_3m_T_EQUALTO_6M) {
		R118_3M_T_EQUALTO_6M = r118_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR118_6M_T_EQUALTO_9M() {
		return R118_6M_T_EQUALTO_9M;
	}
	public void setR118_6M_T_EQUALTO_9M(BigDecimal r118_6m_T_EQUALTO_9M) {
		R118_6M_T_EQUALTO_9M = r118_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR118_9M_T_EQUALTO_1Y() {
		return R118_9M_T_EQUALTO_1Y;
	}
	public void setR118_9M_T_EQUALTO_1Y(BigDecimal r118_9m_T_EQUALTO_1Y) {
		R118_9M_T_EQUALTO_1Y = r118_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR118_1Y_T_EQUALTO_1POINT5Y() {
		return R118_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR118_1Y_T_EQUALTO_1POINT5Y(BigDecimal r118_1y_T_EQUALTO_1POINT5Y) {
		R118_1Y_T_EQUALTO_1POINT5Y = r118_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR118_1POINT5Y_T_EQUALTO_2Y() {
		return R118_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR118_1POINT5Y_T_EQUALTO_2Y(BigDecimal r118_1point5y_T_EQUALTO_2Y) {
		R118_1POINT5Y_T_EQUALTO_2Y = r118_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR118_2Y_T_EQUALTO_3Y() {
		return R118_2Y_T_EQUALTO_3Y;
	}
	public void setR118_2Y_T_EQUALTO_3Y(BigDecimal r118_2y_T_EQUALTO_3Y) {
		R118_2Y_T_EQUALTO_3Y = r118_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR118_3Y_T_EQUALTO_4Y() {
		return R118_3Y_T_EQUALTO_4Y;
	}
	public void setR118_3Y_T_EQUALTO_4Y(BigDecimal r118_3y_T_EQUALTO_4Y) {
		R118_3Y_T_EQUALTO_4Y = r118_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR118_4Y_LT_T_LTEQUALTO_5Y() {
		return R118_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR118_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r118_4y_LT_T_LTEQUALTO_5Y) {
		R118_4Y_LT_T_LTEQUALTO_5Y = r118_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR118_5Y_LT_T_LTEQUALTO_6Y() {
		return R118_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR118_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r118_5y_LT_T_LTEQUALTO_6Y) {
		R118_5Y_LT_T_LTEQUALTO_6Y = r118_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR118_6Y_LT_T_LTEQUALTO_7Y() {
		return R118_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR118_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r118_6y_LT_T_LTEQUALTO_7Y) {
		R118_6Y_LT_T_LTEQUALTO_7Y = r118_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR118_7Y_LT_T_LTEQUALTO_8Y() {
		return R118_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR118_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r118_7y_LT_T_LTEQUALTO_8Y) {
		R118_7Y_LT_T_LTEQUALTO_8Y = r118_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR118_8Y_LT_T_LTEQUALTO_9Y() {
		return R118_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR118_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r118_8y_LT_T_LTEQUALTO_9Y) {
		R118_8Y_LT_T_LTEQUALTO_9Y = r118_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR118_9Y_LT_T_LTEQUALTO_10Y() {
		return R118_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR118_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r118_9y_LT_T_LTEQUALTO_10Y) {
		R118_9Y_LT_T_LTEQUALTO_10Y = r118_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR118_10Y_LT_T_LTEQUALTO_15Y() {
		return R118_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR118_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r118_10y_LT_T_LTEQUALTO_15Y) {
		R118_10Y_LT_T_LTEQUALTO_15Y = r118_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR118_15Y_LT_T_LTEQUALTO_20Y() {
		return R118_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR118_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r118_15y_LT_T_LTEQUALTO_20Y) {
		R118_15Y_LT_T_LTEQUALTO_20Y = r118_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR118_TL_20Y() {
		return R118_TL_20Y;
	}
	public void setR118_TL_20Y(BigDecimal r118_TL_20Y) {
		R118_TL_20Y = r118_TL_20Y;
	}
	public BigDecimal getR118_NONSENSITIVE() {
		return R118_NONSENSITIVE;
	}
	public void setR118_NONSENSITIVE(BigDecimal r118_NONSENSITIVE) {
		R118_NONSENSITIVE = r118_NONSENSITIVE;
	}
	public BigDecimal getR118_TOTAL_RSL() {
		return R118_TOTAL_RSL;
	}
	public void setR118_TOTAL_RSL(BigDecimal r118_TOTAL_RSL) {
		R118_TOTAL_RSL = r118_TOTAL_RSL;
	}
	public BigDecimal getR118_TOTAL() {
		return R118_TOTAL;
	}
	public void setR118_TOTAL(BigDecimal r118_TOTAL) {
		R118_TOTAL = r118_TOTAL;
	}
	public String getR119_PRODUCT() {
		return R119_PRODUCT;
	}
	public void setR119_PRODUCT(String r119_PRODUCT) {
		R119_PRODUCT = r119_PRODUCT;
	}
	public BigDecimal getR119_TEQUALON() {
		return R119_TEQUALON;
	}
	public void setR119_TEQUALON(BigDecimal r119_TEQUALON) {
		R119_TEQUALON = r119_TEQUALON;
	}
	public BigDecimal getR119_ON_T_EQUALTO_1M() {
		return R119_ON_T_EQUALTO_1M;
	}
	public void setR119_ON_T_EQUALTO_1M(BigDecimal r119_ON_T_EQUALTO_1M) {
		R119_ON_T_EQUALTO_1M = r119_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR119_1M_T_EQUALTO_3M() {
		return R119_1M_T_EQUALTO_3M;
	}
	public void setR119_1M_T_EQUALTO_3M(BigDecimal r119_1m_T_EQUALTO_3M) {
		R119_1M_T_EQUALTO_3M = r119_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR119_3M_T_EQUALTO_6M() {
		return R119_3M_T_EQUALTO_6M;
	}
	public void setR119_3M_T_EQUALTO_6M(BigDecimal r119_3m_T_EQUALTO_6M) {
		R119_3M_T_EQUALTO_6M = r119_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR119_6M_T_EQUALTO_9M() {
		return R119_6M_T_EQUALTO_9M;
	}
	public void setR119_6M_T_EQUALTO_9M(BigDecimal r119_6m_T_EQUALTO_9M) {
		R119_6M_T_EQUALTO_9M = r119_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR119_9M_T_EQUALTO_1Y() {
		return R119_9M_T_EQUALTO_1Y;
	}
	public void setR119_9M_T_EQUALTO_1Y(BigDecimal r119_9m_T_EQUALTO_1Y) {
		R119_9M_T_EQUALTO_1Y = r119_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR119_1Y_T_EQUALTO_1POINT5Y() {
		return R119_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR119_1Y_T_EQUALTO_1POINT5Y(BigDecimal r119_1y_T_EQUALTO_1POINT5Y) {
		R119_1Y_T_EQUALTO_1POINT5Y = r119_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR119_1POINT5Y_T_EQUALTO_2Y() {
		return R119_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR119_1POINT5Y_T_EQUALTO_2Y(BigDecimal r119_1point5y_T_EQUALTO_2Y) {
		R119_1POINT5Y_T_EQUALTO_2Y = r119_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR119_2Y_T_EQUALTO_3Y() {
		return R119_2Y_T_EQUALTO_3Y;
	}
	public void setR119_2Y_T_EQUALTO_3Y(BigDecimal r119_2y_T_EQUALTO_3Y) {
		R119_2Y_T_EQUALTO_3Y = r119_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR119_3Y_T_EQUALTO_4Y() {
		return R119_3Y_T_EQUALTO_4Y;
	}
	public void setR119_3Y_T_EQUALTO_4Y(BigDecimal r119_3y_T_EQUALTO_4Y) {
		R119_3Y_T_EQUALTO_4Y = r119_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR119_4Y_LT_T_LTEQUALTO_5Y() {
		return R119_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR119_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r119_4y_LT_T_LTEQUALTO_5Y) {
		R119_4Y_LT_T_LTEQUALTO_5Y = r119_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR119_5Y_LT_T_LTEQUALTO_6Y() {
		return R119_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR119_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r119_5y_LT_T_LTEQUALTO_6Y) {
		R119_5Y_LT_T_LTEQUALTO_6Y = r119_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR119_6Y_LT_T_LTEQUALTO_7Y() {
		return R119_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR119_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r119_6y_LT_T_LTEQUALTO_7Y) {
		R119_6Y_LT_T_LTEQUALTO_7Y = r119_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR119_7Y_LT_T_LTEQUALTO_8Y() {
		return R119_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR119_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r119_7y_LT_T_LTEQUALTO_8Y) {
		R119_7Y_LT_T_LTEQUALTO_8Y = r119_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR119_8Y_LT_T_LTEQUALTO_9Y() {
		return R119_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR119_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r119_8y_LT_T_LTEQUALTO_9Y) {
		R119_8Y_LT_T_LTEQUALTO_9Y = r119_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR119_9Y_LT_T_LTEQUALTO_10Y() {
		return R119_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR119_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r119_9y_LT_T_LTEQUALTO_10Y) {
		R119_9Y_LT_T_LTEQUALTO_10Y = r119_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR119_10Y_LT_T_LTEQUALTO_15Y() {
		return R119_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR119_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r119_10y_LT_T_LTEQUALTO_15Y) {
		R119_10Y_LT_T_LTEQUALTO_15Y = r119_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR119_15Y_LT_T_LTEQUALTO_20Y() {
		return R119_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR119_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r119_15y_LT_T_LTEQUALTO_20Y) {
		R119_15Y_LT_T_LTEQUALTO_20Y = r119_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR119_TL_20Y() {
		return R119_TL_20Y;
	}
	public void setR119_TL_20Y(BigDecimal r119_TL_20Y) {
		R119_TL_20Y = r119_TL_20Y;
	}
	public BigDecimal getR119_NONSENSITIVE() {
		return R119_NONSENSITIVE;
	}
	public void setR119_NONSENSITIVE(BigDecimal r119_NONSENSITIVE) {
		R119_NONSENSITIVE = r119_NONSENSITIVE;
	}
	public BigDecimal getR119_TOTAL_RSL() {
		return R119_TOTAL_RSL;
	}
	public void setR119_TOTAL_RSL(BigDecimal r119_TOTAL_RSL) {
		R119_TOTAL_RSL = r119_TOTAL_RSL;
	}
	public BigDecimal getR119_TOTAL() {
		return R119_TOTAL;
	}
	public void setR119_TOTAL(BigDecimal r119_TOTAL) {
		R119_TOTAL = r119_TOTAL;
	}
	public String getR120_PRODUCT() {
		return R120_PRODUCT;
	}
	public void setR120_PRODUCT(String r120_PRODUCT) {
		R120_PRODUCT = r120_PRODUCT;
	}
	public BigDecimal getR120_TEQUALON() {
		return R120_TEQUALON;
	}
	public void setR120_TEQUALON(BigDecimal r120_TEQUALON) {
		R120_TEQUALON = r120_TEQUALON;
	}
	public BigDecimal getR120_ON_T_EQUALTO_1M() {
		return R120_ON_T_EQUALTO_1M;
	}
	public void setR120_ON_T_EQUALTO_1M(BigDecimal r120_ON_T_EQUALTO_1M) {
		R120_ON_T_EQUALTO_1M = r120_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR120_1M_T_EQUALTO_3M() {
		return R120_1M_T_EQUALTO_3M;
	}
	public void setR120_1M_T_EQUALTO_3M(BigDecimal r120_1m_T_EQUALTO_3M) {
		R120_1M_T_EQUALTO_3M = r120_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR120_3M_T_EQUALTO_6M() {
		return R120_3M_T_EQUALTO_6M;
	}
	public void setR120_3M_T_EQUALTO_6M(BigDecimal r120_3m_T_EQUALTO_6M) {
		R120_3M_T_EQUALTO_6M = r120_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR120_6M_T_EQUALTO_9M() {
		return R120_6M_T_EQUALTO_9M;
	}
	public void setR120_6M_T_EQUALTO_9M(BigDecimal r120_6m_T_EQUALTO_9M) {
		R120_6M_T_EQUALTO_9M = r120_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR120_9M_T_EQUALTO_1Y() {
		return R120_9M_T_EQUALTO_1Y;
	}
	public void setR120_9M_T_EQUALTO_1Y(BigDecimal r120_9m_T_EQUALTO_1Y) {
		R120_9M_T_EQUALTO_1Y = r120_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR120_1Y_T_EQUALTO_1POINT5Y() {
		return R120_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR120_1Y_T_EQUALTO_1POINT5Y(BigDecimal r120_1y_T_EQUALTO_1POINT5Y) {
		R120_1Y_T_EQUALTO_1POINT5Y = r120_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR120_1POINT5Y_T_EQUALTO_2Y() {
		return R120_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR120_1POINT5Y_T_EQUALTO_2Y(BigDecimal r120_1point5y_T_EQUALTO_2Y) {
		R120_1POINT5Y_T_EQUALTO_2Y = r120_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR120_2Y_T_EQUALTO_3Y() {
		return R120_2Y_T_EQUALTO_3Y;
	}
	public void setR120_2Y_T_EQUALTO_3Y(BigDecimal r120_2y_T_EQUALTO_3Y) {
		R120_2Y_T_EQUALTO_3Y = r120_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR120_3Y_T_EQUALTO_4Y() {
		return R120_3Y_T_EQUALTO_4Y;
	}
	public void setR120_3Y_T_EQUALTO_4Y(BigDecimal r120_3y_T_EQUALTO_4Y) {
		R120_3Y_T_EQUALTO_4Y = r120_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR120_4Y_LT_T_LTEQUALTO_5Y() {
		return R120_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR120_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r120_4y_LT_T_LTEQUALTO_5Y) {
		R120_4Y_LT_T_LTEQUALTO_5Y = r120_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR120_5Y_LT_T_LTEQUALTO_6Y() {
		return R120_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR120_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r120_5y_LT_T_LTEQUALTO_6Y) {
		R120_5Y_LT_T_LTEQUALTO_6Y = r120_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR120_6Y_LT_T_LTEQUALTO_7Y() {
		return R120_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR120_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r120_6y_LT_T_LTEQUALTO_7Y) {
		R120_6Y_LT_T_LTEQUALTO_7Y = r120_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR120_7Y_LT_T_LTEQUALTO_8Y() {
		return R120_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR120_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r120_7y_LT_T_LTEQUALTO_8Y) {
		R120_7Y_LT_T_LTEQUALTO_8Y = r120_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR120_8Y_LT_T_LTEQUALTO_9Y() {
		return R120_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR120_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r120_8y_LT_T_LTEQUALTO_9Y) {
		R120_8Y_LT_T_LTEQUALTO_9Y = r120_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR120_9Y_LT_T_LTEQUALTO_10Y() {
		return R120_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR120_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r120_9y_LT_T_LTEQUALTO_10Y) {
		R120_9Y_LT_T_LTEQUALTO_10Y = r120_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR120_10Y_LT_T_LTEQUALTO_15Y() {
		return R120_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR120_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r120_10y_LT_T_LTEQUALTO_15Y) {
		R120_10Y_LT_T_LTEQUALTO_15Y = r120_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR120_15Y_LT_T_LTEQUALTO_20Y() {
		return R120_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR120_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r120_15y_LT_T_LTEQUALTO_20Y) {
		R120_15Y_LT_T_LTEQUALTO_20Y = r120_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR120_TL_20Y() {
		return R120_TL_20Y;
	}
	public void setR120_TL_20Y(BigDecimal r120_TL_20Y) {
		R120_TL_20Y = r120_TL_20Y;
	}
	public BigDecimal getR120_NONSENSITIVE() {
		return R120_NONSENSITIVE;
	}
	public void setR120_NONSENSITIVE(BigDecimal r120_NONSENSITIVE) {
		R120_NONSENSITIVE = r120_NONSENSITIVE;
	}
	public BigDecimal getR120_TOTAL_RSL() {
		return R120_TOTAL_RSL;
	}
	public void setR120_TOTAL_RSL(BigDecimal r120_TOTAL_RSL) {
		R120_TOTAL_RSL = r120_TOTAL_RSL;
	}
	public BigDecimal getR120_TOTAL() {
		return R120_TOTAL;
	}
	public void setR120_TOTAL(BigDecimal r120_TOTAL) {
		R120_TOTAL = r120_TOTAL;
	}
	public String getR121_PRODUCT() {
		return R121_PRODUCT;
	}
	public void setR121_PRODUCT(String r121_PRODUCT) {
		R121_PRODUCT = r121_PRODUCT;
	}
	public BigDecimal getR121_TEQUALON() {
		return R121_TEQUALON;
	}
	public void setR121_TEQUALON(BigDecimal r121_TEQUALON) {
		R121_TEQUALON = r121_TEQUALON;
	}
	public BigDecimal getR121_ON_T_EQUALTO_1M() {
		return R121_ON_T_EQUALTO_1M;
	}
	public void setR121_ON_T_EQUALTO_1M(BigDecimal r121_ON_T_EQUALTO_1M) {
		R121_ON_T_EQUALTO_1M = r121_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR121_1M_T_EQUALTO_3M() {
		return R121_1M_T_EQUALTO_3M;
	}
	public void setR121_1M_T_EQUALTO_3M(BigDecimal r121_1m_T_EQUALTO_3M) {
		R121_1M_T_EQUALTO_3M = r121_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR121_3M_T_EQUALTO_6M() {
		return R121_3M_T_EQUALTO_6M;
	}
	public void setR121_3M_T_EQUALTO_6M(BigDecimal r121_3m_T_EQUALTO_6M) {
		R121_3M_T_EQUALTO_6M = r121_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR121_6M_T_EQUALTO_9M() {
		return R121_6M_T_EQUALTO_9M;
	}
	public void setR121_6M_T_EQUALTO_9M(BigDecimal r121_6m_T_EQUALTO_9M) {
		R121_6M_T_EQUALTO_9M = r121_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR121_9M_T_EQUALTO_1Y() {
		return R121_9M_T_EQUALTO_1Y;
	}
	public void setR121_9M_T_EQUALTO_1Y(BigDecimal r121_9m_T_EQUALTO_1Y) {
		R121_9M_T_EQUALTO_1Y = r121_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR121_1Y_T_EQUALTO_1POINT5Y() {
		return R121_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR121_1Y_T_EQUALTO_1POINT5Y(BigDecimal r121_1y_T_EQUALTO_1POINT5Y) {
		R121_1Y_T_EQUALTO_1POINT5Y = r121_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR121_1POINT5Y_T_EQUALTO_2Y() {
		return R121_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR121_1POINT5Y_T_EQUALTO_2Y(BigDecimal r121_1point5y_T_EQUALTO_2Y) {
		R121_1POINT5Y_T_EQUALTO_2Y = r121_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR121_2Y_T_EQUALTO_3Y() {
		return R121_2Y_T_EQUALTO_3Y;
	}
	public void setR121_2Y_T_EQUALTO_3Y(BigDecimal r121_2y_T_EQUALTO_3Y) {
		R121_2Y_T_EQUALTO_3Y = r121_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR121_3Y_T_EQUALTO_4Y() {
		return R121_3Y_T_EQUALTO_4Y;
	}
	public void setR121_3Y_T_EQUALTO_4Y(BigDecimal r121_3y_T_EQUALTO_4Y) {
		R121_3Y_T_EQUALTO_4Y = r121_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR121_4Y_LT_T_LTEQUALTO_5Y() {
		return R121_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR121_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r121_4y_LT_T_LTEQUALTO_5Y) {
		R121_4Y_LT_T_LTEQUALTO_5Y = r121_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR121_5Y_LT_T_LTEQUALTO_6Y() {
		return R121_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR121_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r121_5y_LT_T_LTEQUALTO_6Y) {
		R121_5Y_LT_T_LTEQUALTO_6Y = r121_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR121_6Y_LT_T_LTEQUALTO_7Y() {
		return R121_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR121_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r121_6y_LT_T_LTEQUALTO_7Y) {
		R121_6Y_LT_T_LTEQUALTO_7Y = r121_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR121_7Y_LT_T_LTEQUALTO_8Y() {
		return R121_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR121_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r121_7y_LT_T_LTEQUALTO_8Y) {
		R121_7Y_LT_T_LTEQUALTO_8Y = r121_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR121_8Y_LT_T_LTEQUALTO_9Y() {
		return R121_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR121_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r121_8y_LT_T_LTEQUALTO_9Y) {
		R121_8Y_LT_T_LTEQUALTO_9Y = r121_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR121_9Y_LT_T_LTEQUALTO_10Y() {
		return R121_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR121_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r121_9y_LT_T_LTEQUALTO_10Y) {
		R121_9Y_LT_T_LTEQUALTO_10Y = r121_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR121_10Y_LT_T_LTEQUALTO_15Y() {
		return R121_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR121_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r121_10y_LT_T_LTEQUALTO_15Y) {
		R121_10Y_LT_T_LTEQUALTO_15Y = r121_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR121_15Y_LT_T_LTEQUALTO_20Y() {
		return R121_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR121_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r121_15y_LT_T_LTEQUALTO_20Y) {
		R121_15Y_LT_T_LTEQUALTO_20Y = r121_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR121_TL_20Y() {
		return R121_TL_20Y;
	}
	public void setR121_TL_20Y(BigDecimal r121_TL_20Y) {
		R121_TL_20Y = r121_TL_20Y;
	}
	public BigDecimal getR121_NONSENSITIVE() {
		return R121_NONSENSITIVE;
	}
	public void setR121_NONSENSITIVE(BigDecimal r121_NONSENSITIVE) {
		R121_NONSENSITIVE = r121_NONSENSITIVE;
	}
	public BigDecimal getR121_TOTAL_RSL() {
		return R121_TOTAL_RSL;
	}
	public void setR121_TOTAL_RSL(BigDecimal r121_TOTAL_RSL) {
		R121_TOTAL_RSL = r121_TOTAL_RSL;
	}
	public BigDecimal getR121_TOTAL() {
		return R121_TOTAL;
	}
	public void setR121_TOTAL(BigDecimal r121_TOTAL) {
		R121_TOTAL = r121_TOTAL;
	}
	public String getR122_PRODUCT() {
		return R122_PRODUCT;
	}
	public void setR122_PRODUCT(String r122_PRODUCT) {
		R122_PRODUCT = r122_PRODUCT;
	}
	public BigDecimal getR122_TEQUALON() {
		return R122_TEQUALON;
	}
	public void setR122_TEQUALON(BigDecimal r122_TEQUALON) {
		R122_TEQUALON = r122_TEQUALON;
	}
	public BigDecimal getR122_ON_T_EQUALTO_1M() {
		return R122_ON_T_EQUALTO_1M;
	}
	public void setR122_ON_T_EQUALTO_1M(BigDecimal r122_ON_T_EQUALTO_1M) {
		R122_ON_T_EQUALTO_1M = r122_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR122_1M_T_EQUALTO_3M() {
		return R122_1M_T_EQUALTO_3M;
	}
	public void setR122_1M_T_EQUALTO_3M(BigDecimal r122_1m_T_EQUALTO_3M) {
		R122_1M_T_EQUALTO_3M = r122_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR122_3M_T_EQUALTO_6M() {
		return R122_3M_T_EQUALTO_6M;
	}
	public void setR122_3M_T_EQUALTO_6M(BigDecimal r122_3m_T_EQUALTO_6M) {
		R122_3M_T_EQUALTO_6M = r122_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR122_6M_T_EQUALTO_9M() {
		return R122_6M_T_EQUALTO_9M;
	}
	public void setR122_6M_T_EQUALTO_9M(BigDecimal r122_6m_T_EQUALTO_9M) {
		R122_6M_T_EQUALTO_9M = r122_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR122_9M_T_EQUALTO_1Y() {
		return R122_9M_T_EQUALTO_1Y;
	}
	public void setR122_9M_T_EQUALTO_1Y(BigDecimal r122_9m_T_EQUALTO_1Y) {
		R122_9M_T_EQUALTO_1Y = r122_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR122_1Y_T_EQUALTO_1POINT5Y() {
		return R122_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR122_1Y_T_EQUALTO_1POINT5Y(BigDecimal r122_1y_T_EQUALTO_1POINT5Y) {
		R122_1Y_T_EQUALTO_1POINT5Y = r122_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR122_1POINT5Y_T_EQUALTO_2Y() {
		return R122_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR122_1POINT5Y_T_EQUALTO_2Y(BigDecimal r122_1point5y_T_EQUALTO_2Y) {
		R122_1POINT5Y_T_EQUALTO_2Y = r122_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR122_2Y_T_EQUALTO_3Y() {
		return R122_2Y_T_EQUALTO_3Y;
	}
	public void setR122_2Y_T_EQUALTO_3Y(BigDecimal r122_2y_T_EQUALTO_3Y) {
		R122_2Y_T_EQUALTO_3Y = r122_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR122_3Y_T_EQUALTO_4Y() {
		return R122_3Y_T_EQUALTO_4Y;
	}
	public void setR122_3Y_T_EQUALTO_4Y(BigDecimal r122_3y_T_EQUALTO_4Y) {
		R122_3Y_T_EQUALTO_4Y = r122_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR122_4Y_LT_T_LTEQUALTO_5Y() {
		return R122_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR122_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r122_4y_LT_T_LTEQUALTO_5Y) {
		R122_4Y_LT_T_LTEQUALTO_5Y = r122_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR122_5Y_LT_T_LTEQUALTO_6Y() {
		return R122_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR122_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r122_5y_LT_T_LTEQUALTO_6Y) {
		R122_5Y_LT_T_LTEQUALTO_6Y = r122_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR122_6Y_LT_T_LTEQUALTO_7Y() {
		return R122_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR122_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r122_6y_LT_T_LTEQUALTO_7Y) {
		R122_6Y_LT_T_LTEQUALTO_7Y = r122_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR122_7Y_LT_T_LTEQUALTO_8Y() {
		return R122_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR122_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r122_7y_LT_T_LTEQUALTO_8Y) {
		R122_7Y_LT_T_LTEQUALTO_8Y = r122_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR122_8Y_LT_T_LTEQUALTO_9Y() {
		return R122_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR122_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r122_8y_LT_T_LTEQUALTO_9Y) {
		R122_8Y_LT_T_LTEQUALTO_9Y = r122_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR122_9Y_LT_T_LTEQUALTO_10Y() {
		return R122_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR122_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r122_9y_LT_T_LTEQUALTO_10Y) {
		R122_9Y_LT_T_LTEQUALTO_10Y = r122_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR122_10Y_LT_T_LTEQUALTO_15Y() {
		return R122_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR122_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r122_10y_LT_T_LTEQUALTO_15Y) {
		R122_10Y_LT_T_LTEQUALTO_15Y = r122_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR122_15Y_LT_T_LTEQUALTO_20Y() {
		return R122_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR122_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r122_15y_LT_T_LTEQUALTO_20Y) {
		R122_15Y_LT_T_LTEQUALTO_20Y = r122_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR122_TL_20Y() {
		return R122_TL_20Y;
	}
	public void setR122_TL_20Y(BigDecimal r122_TL_20Y) {
		R122_TL_20Y = r122_TL_20Y;
	}
	public BigDecimal getR122_NONSENSITIVE() {
		return R122_NONSENSITIVE;
	}
	public void setR122_NONSENSITIVE(BigDecimal r122_NONSENSITIVE) {
		R122_NONSENSITIVE = r122_NONSENSITIVE;
	}
	public BigDecimal getR122_TOTAL_RSL() {
		return R122_TOTAL_RSL;
	}
	public void setR122_TOTAL_RSL(BigDecimal r122_TOTAL_RSL) {
		R122_TOTAL_RSL = r122_TOTAL_RSL;
	}
	public BigDecimal getR122_TOTAL() {
		return R122_TOTAL;
	}
	public void setR122_TOTAL(BigDecimal r122_TOTAL) {
		R122_TOTAL = r122_TOTAL;
	}
	public String getR125_PRODUCT() {
		return R125_PRODUCT;
	}
	public void setR125_PRODUCT(String r125_PRODUCT) {
		R125_PRODUCT = r125_PRODUCT;
	}
	public BigDecimal getR125_TEQUALON() {
		return R125_TEQUALON;
	}
	public void setR125_TEQUALON(BigDecimal r125_TEQUALON) {
		R125_TEQUALON = r125_TEQUALON;
	}
	public BigDecimal getR125_ON_T_EQUALTO_1M() {
		return R125_ON_T_EQUALTO_1M;
	}
	public void setR125_ON_T_EQUALTO_1M(BigDecimal r125_ON_T_EQUALTO_1M) {
		R125_ON_T_EQUALTO_1M = r125_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR125_1M_T_EQUALTO_3M() {
		return R125_1M_T_EQUALTO_3M;
	}
	public void setR125_1M_T_EQUALTO_3M(BigDecimal r125_1m_T_EQUALTO_3M) {
		R125_1M_T_EQUALTO_3M = r125_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR125_3M_T_EQUALTO_6M() {
		return R125_3M_T_EQUALTO_6M;
	}
	public void setR125_3M_T_EQUALTO_6M(BigDecimal r125_3m_T_EQUALTO_6M) {
		R125_3M_T_EQUALTO_6M = r125_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR125_6M_T_EQUALTO_9M() {
		return R125_6M_T_EQUALTO_9M;
	}
	public void setR125_6M_T_EQUALTO_9M(BigDecimal r125_6m_T_EQUALTO_9M) {
		R125_6M_T_EQUALTO_9M = r125_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR125_9M_T_EQUALTO_1Y() {
		return R125_9M_T_EQUALTO_1Y;
	}
	public void setR125_9M_T_EQUALTO_1Y(BigDecimal r125_9m_T_EQUALTO_1Y) {
		R125_9M_T_EQUALTO_1Y = r125_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR125_1Y_T_EQUALTO_1POINT5Y() {
		return R125_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR125_1Y_T_EQUALTO_1POINT5Y(BigDecimal r125_1y_T_EQUALTO_1POINT5Y) {
		R125_1Y_T_EQUALTO_1POINT5Y = r125_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR125_1POINT5Y_T_EQUALTO_2Y() {
		return R125_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR125_1POINT5Y_T_EQUALTO_2Y(BigDecimal r125_1point5y_T_EQUALTO_2Y) {
		R125_1POINT5Y_T_EQUALTO_2Y = r125_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR125_2Y_T_EQUALTO_3Y() {
		return R125_2Y_T_EQUALTO_3Y;
	}
	public void setR125_2Y_T_EQUALTO_3Y(BigDecimal r125_2y_T_EQUALTO_3Y) {
		R125_2Y_T_EQUALTO_3Y = r125_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR125_3Y_T_EQUALTO_4Y() {
		return R125_3Y_T_EQUALTO_4Y;
	}
	public void setR125_3Y_T_EQUALTO_4Y(BigDecimal r125_3y_T_EQUALTO_4Y) {
		R125_3Y_T_EQUALTO_4Y = r125_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR125_4Y_LT_T_LTEQUALTO_5Y() {
		return R125_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR125_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r125_4y_LT_T_LTEQUALTO_5Y) {
		R125_4Y_LT_T_LTEQUALTO_5Y = r125_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR125_5Y_LT_T_LTEQUALTO_6Y() {
		return R125_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR125_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r125_5y_LT_T_LTEQUALTO_6Y) {
		R125_5Y_LT_T_LTEQUALTO_6Y = r125_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR125_6Y_LT_T_LTEQUALTO_7Y() {
		return R125_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR125_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r125_6y_LT_T_LTEQUALTO_7Y) {
		R125_6Y_LT_T_LTEQUALTO_7Y = r125_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR125_7Y_LT_T_LTEQUALTO_8Y() {
		return R125_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR125_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r125_7y_LT_T_LTEQUALTO_8Y) {
		R125_7Y_LT_T_LTEQUALTO_8Y = r125_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR125_8Y_LT_T_LTEQUALTO_9Y() {
		return R125_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR125_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r125_8y_LT_T_LTEQUALTO_9Y) {
		R125_8Y_LT_T_LTEQUALTO_9Y = r125_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR125_9Y_LT_T_LTEQUALTO_10Y() {
		return R125_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR125_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r125_9y_LT_T_LTEQUALTO_10Y) {
		R125_9Y_LT_T_LTEQUALTO_10Y = r125_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR125_10Y_LT_T_LTEQUALTO_15Y() {
		return R125_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR125_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r125_10y_LT_T_LTEQUALTO_15Y) {
		R125_10Y_LT_T_LTEQUALTO_15Y = r125_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR125_15Y_LT_T_LTEQUALTO_20Y() {
		return R125_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR125_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r125_15y_LT_T_LTEQUALTO_20Y) {
		R125_15Y_LT_T_LTEQUALTO_20Y = r125_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR125_TL_20Y() {
		return R125_TL_20Y;
	}
	public void setR125_TL_20Y(BigDecimal r125_TL_20Y) {
		R125_TL_20Y = r125_TL_20Y;
	}
	public BigDecimal getR125_NONSENSITIVE() {
		return R125_NONSENSITIVE;
	}
	public void setR125_NONSENSITIVE(BigDecimal r125_NONSENSITIVE) {
		R125_NONSENSITIVE = r125_NONSENSITIVE;
	}
	public BigDecimal getR125_TOTAL_RSL() {
		return R125_TOTAL_RSL;
	}
	public void setR125_TOTAL_RSL(BigDecimal r125_TOTAL_RSL) {
		R125_TOTAL_RSL = r125_TOTAL_RSL;
	}
	public BigDecimal getR125_TOTAL() {
		return R125_TOTAL;
	}
	public void setR125_TOTAL(BigDecimal r125_TOTAL) {
		R125_TOTAL = r125_TOTAL;
	}
	public String getR126_PRODUCT() {
		return R126_PRODUCT;
	}
	public void setR126_PRODUCT(String r126_PRODUCT) {
		R126_PRODUCT = r126_PRODUCT;
	}
	public BigDecimal getR126_TEQUALON() {
		return R126_TEQUALON;
	}
	public void setR126_TEQUALON(BigDecimal r126_TEQUALON) {
		R126_TEQUALON = r126_TEQUALON;
	}
	public BigDecimal getR126_ON_T_EQUALTO_1M() {
		return R126_ON_T_EQUALTO_1M;
	}
	public void setR126_ON_T_EQUALTO_1M(BigDecimal r126_ON_T_EQUALTO_1M) {
		R126_ON_T_EQUALTO_1M = r126_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR126_1M_T_EQUALTO_3M() {
		return R126_1M_T_EQUALTO_3M;
	}
	public void setR126_1M_T_EQUALTO_3M(BigDecimal r126_1m_T_EQUALTO_3M) {
		R126_1M_T_EQUALTO_3M = r126_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR126_3M_T_EQUALTO_6M() {
		return R126_3M_T_EQUALTO_6M;
	}
	public void setR126_3M_T_EQUALTO_6M(BigDecimal r126_3m_T_EQUALTO_6M) {
		R126_3M_T_EQUALTO_6M = r126_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR126_6M_T_EQUALTO_9M() {
		return R126_6M_T_EQUALTO_9M;
	}
	public void setR126_6M_T_EQUALTO_9M(BigDecimal r126_6m_T_EQUALTO_9M) {
		R126_6M_T_EQUALTO_9M = r126_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR126_9M_T_EQUALTO_1Y() {
		return R126_9M_T_EQUALTO_1Y;
	}
	public void setR126_9M_T_EQUALTO_1Y(BigDecimal r126_9m_T_EQUALTO_1Y) {
		R126_9M_T_EQUALTO_1Y = r126_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR126_1Y_T_EQUALTO_1POINT5Y() {
		return R126_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR126_1Y_T_EQUALTO_1POINT5Y(BigDecimal r126_1y_T_EQUALTO_1POINT5Y) {
		R126_1Y_T_EQUALTO_1POINT5Y = r126_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR126_1POINT5Y_T_EQUALTO_2Y() {
		return R126_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR126_1POINT5Y_T_EQUALTO_2Y(BigDecimal r126_1point5y_T_EQUALTO_2Y) {
		R126_1POINT5Y_T_EQUALTO_2Y = r126_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR126_2Y_T_EQUALTO_3Y() {
		return R126_2Y_T_EQUALTO_3Y;
	}
	public void setR126_2Y_T_EQUALTO_3Y(BigDecimal r126_2y_T_EQUALTO_3Y) {
		R126_2Y_T_EQUALTO_3Y = r126_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR126_3Y_T_EQUALTO_4Y() {
		return R126_3Y_T_EQUALTO_4Y;
	}
	public void setR126_3Y_T_EQUALTO_4Y(BigDecimal r126_3y_T_EQUALTO_4Y) {
		R126_3Y_T_EQUALTO_4Y = r126_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR126_4Y_LT_T_LTEQUALTO_5Y() {
		return R126_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR126_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r126_4y_LT_T_LTEQUALTO_5Y) {
		R126_4Y_LT_T_LTEQUALTO_5Y = r126_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR126_5Y_LT_T_LTEQUALTO_6Y() {
		return R126_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR126_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r126_5y_LT_T_LTEQUALTO_6Y) {
		R126_5Y_LT_T_LTEQUALTO_6Y = r126_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR126_6Y_LT_T_LTEQUALTO_7Y() {
		return R126_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR126_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r126_6y_LT_T_LTEQUALTO_7Y) {
		R126_6Y_LT_T_LTEQUALTO_7Y = r126_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR126_7Y_LT_T_LTEQUALTO_8Y() {
		return R126_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR126_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r126_7y_LT_T_LTEQUALTO_8Y) {
		R126_7Y_LT_T_LTEQUALTO_8Y = r126_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR126_8Y_LT_T_LTEQUALTO_9Y() {
		return R126_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR126_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r126_8y_LT_T_LTEQUALTO_9Y) {
		R126_8Y_LT_T_LTEQUALTO_9Y = r126_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR126_9Y_LT_T_LTEQUALTO_10Y() {
		return R126_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR126_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r126_9y_LT_T_LTEQUALTO_10Y) {
		R126_9Y_LT_T_LTEQUALTO_10Y = r126_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR126_10Y_LT_T_LTEQUALTO_15Y() {
		return R126_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR126_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r126_10y_LT_T_LTEQUALTO_15Y) {
		R126_10Y_LT_T_LTEQUALTO_15Y = r126_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR126_15Y_LT_T_LTEQUALTO_20Y() {
		return R126_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR126_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r126_15y_LT_T_LTEQUALTO_20Y) {
		R126_15Y_LT_T_LTEQUALTO_20Y = r126_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR126_TL_20Y() {
		return R126_TL_20Y;
	}
	public void setR126_TL_20Y(BigDecimal r126_TL_20Y) {
		R126_TL_20Y = r126_TL_20Y;
	}
	public BigDecimal getR126_NONSENSITIVE() {
		return R126_NONSENSITIVE;
	}
	public void setR126_NONSENSITIVE(BigDecimal r126_NONSENSITIVE) {
		R126_NONSENSITIVE = r126_NONSENSITIVE;
	}
	public BigDecimal getR126_TOTAL_RSL() {
		return R126_TOTAL_RSL;
	}
	public void setR126_TOTAL_RSL(BigDecimal r126_TOTAL_RSL) {
		R126_TOTAL_RSL = r126_TOTAL_RSL;
	}
	public BigDecimal getR126_TOTAL() {
		return R126_TOTAL;
	}
	public void setR126_TOTAL(BigDecimal r126_TOTAL) {
		R126_TOTAL = r126_TOTAL;
	}
	public String getR127_PRODUCT() {
		return R127_PRODUCT;
	}
	public void setR127_PRODUCT(String r127_PRODUCT) {
		R127_PRODUCT = r127_PRODUCT;
	}
	public BigDecimal getR127_TEQUALON() {
		return R127_TEQUALON;
	}
	public void setR127_TEQUALON(BigDecimal r127_TEQUALON) {
		R127_TEQUALON = r127_TEQUALON;
	}
	public BigDecimal getR127_ON_T_EQUALTO_1M() {
		return R127_ON_T_EQUALTO_1M;
	}
	public void setR127_ON_T_EQUALTO_1M(BigDecimal r127_ON_T_EQUALTO_1M) {
		R127_ON_T_EQUALTO_1M = r127_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR127_1M_T_EQUALTO_3M() {
		return R127_1M_T_EQUALTO_3M;
	}
	public void setR127_1M_T_EQUALTO_3M(BigDecimal r127_1m_T_EQUALTO_3M) {
		R127_1M_T_EQUALTO_3M = r127_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR127_3M_T_EQUALTO_6M() {
		return R127_3M_T_EQUALTO_6M;
	}
	public void setR127_3M_T_EQUALTO_6M(BigDecimal r127_3m_T_EQUALTO_6M) {
		R127_3M_T_EQUALTO_6M = r127_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR127_6M_T_EQUALTO_9M() {
		return R127_6M_T_EQUALTO_9M;
	}
	public void setR127_6M_T_EQUALTO_9M(BigDecimal r127_6m_T_EQUALTO_9M) {
		R127_6M_T_EQUALTO_9M = r127_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR127_9M_T_EQUALTO_1Y() {
		return R127_9M_T_EQUALTO_1Y;
	}
	public void setR127_9M_T_EQUALTO_1Y(BigDecimal r127_9m_T_EQUALTO_1Y) {
		R127_9M_T_EQUALTO_1Y = r127_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR127_1Y_T_EQUALTO_1POINT5Y() {
		return R127_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR127_1Y_T_EQUALTO_1POINT5Y(BigDecimal r127_1y_T_EQUALTO_1POINT5Y) {
		R127_1Y_T_EQUALTO_1POINT5Y = r127_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR127_1POINT5Y_T_EQUALTO_2Y() {
		return R127_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR127_1POINT5Y_T_EQUALTO_2Y(BigDecimal r127_1point5y_T_EQUALTO_2Y) {
		R127_1POINT5Y_T_EQUALTO_2Y = r127_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR127_2Y_T_EQUALTO_3Y() {
		return R127_2Y_T_EQUALTO_3Y;
	}
	public void setR127_2Y_T_EQUALTO_3Y(BigDecimal r127_2y_T_EQUALTO_3Y) {
		R127_2Y_T_EQUALTO_3Y = r127_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR127_3Y_T_EQUALTO_4Y() {
		return R127_3Y_T_EQUALTO_4Y;
	}
	public void setR127_3Y_T_EQUALTO_4Y(BigDecimal r127_3y_T_EQUALTO_4Y) {
		R127_3Y_T_EQUALTO_4Y = r127_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR127_4Y_LT_T_LTEQUALTO_5Y() {
		return R127_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR127_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r127_4y_LT_T_LTEQUALTO_5Y) {
		R127_4Y_LT_T_LTEQUALTO_5Y = r127_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR127_5Y_LT_T_LTEQUALTO_6Y() {
		return R127_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR127_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r127_5y_LT_T_LTEQUALTO_6Y) {
		R127_5Y_LT_T_LTEQUALTO_6Y = r127_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR127_6Y_LT_T_LTEQUALTO_7Y() {
		return R127_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR127_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r127_6y_LT_T_LTEQUALTO_7Y) {
		R127_6Y_LT_T_LTEQUALTO_7Y = r127_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR127_7Y_LT_T_LTEQUALTO_8Y() {
		return R127_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR127_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r127_7y_LT_T_LTEQUALTO_8Y) {
		R127_7Y_LT_T_LTEQUALTO_8Y = r127_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR127_8Y_LT_T_LTEQUALTO_9Y() {
		return R127_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR127_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r127_8y_LT_T_LTEQUALTO_9Y) {
		R127_8Y_LT_T_LTEQUALTO_9Y = r127_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR127_9Y_LT_T_LTEQUALTO_10Y() {
		return R127_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR127_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r127_9y_LT_T_LTEQUALTO_10Y) {
		R127_9Y_LT_T_LTEQUALTO_10Y = r127_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR127_10Y_LT_T_LTEQUALTO_15Y() {
		return R127_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR127_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r127_10y_LT_T_LTEQUALTO_15Y) {
		R127_10Y_LT_T_LTEQUALTO_15Y = r127_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR127_15Y_LT_T_LTEQUALTO_20Y() {
		return R127_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR127_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r127_15y_LT_T_LTEQUALTO_20Y) {
		R127_15Y_LT_T_LTEQUALTO_20Y = r127_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR127_TL_20Y() {
		return R127_TL_20Y;
	}
	public void setR127_TL_20Y(BigDecimal r127_TL_20Y) {
		R127_TL_20Y = r127_TL_20Y;
	}
	public BigDecimal getR127_NONSENSITIVE() {
		return R127_NONSENSITIVE;
	}
	public void setR127_NONSENSITIVE(BigDecimal r127_NONSENSITIVE) {
		R127_NONSENSITIVE = r127_NONSENSITIVE;
	}
	public BigDecimal getR127_TOTAL_RSL() {
		return R127_TOTAL_RSL;
	}
	public void setR127_TOTAL_RSL(BigDecimal r127_TOTAL_RSL) {
		R127_TOTAL_RSL = r127_TOTAL_RSL;
	}
	public BigDecimal getR127_TOTAL() {
		return R127_TOTAL;
	}
	public void setR127_TOTAL(BigDecimal r127_TOTAL) {
		R127_TOTAL = r127_TOTAL;
	}
	public String getR128_PRODUCT() {
		return R128_PRODUCT;
	}
	public void setR128_PRODUCT(String r128_PRODUCT) {
		R128_PRODUCT = r128_PRODUCT;
	}
	public BigDecimal getR128_TEQUALON() {
		return R128_TEQUALON;
	}
	public void setR128_TEQUALON(BigDecimal r128_TEQUALON) {
		R128_TEQUALON = r128_TEQUALON;
	}
	public BigDecimal getR128_ON_T_EQUALTO_1M() {
		return R128_ON_T_EQUALTO_1M;
	}
	public void setR128_ON_T_EQUALTO_1M(BigDecimal r128_ON_T_EQUALTO_1M) {
		R128_ON_T_EQUALTO_1M = r128_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR128_1M_T_EQUALTO_3M() {
		return R128_1M_T_EQUALTO_3M;
	}
	public void setR128_1M_T_EQUALTO_3M(BigDecimal r128_1m_T_EQUALTO_3M) {
		R128_1M_T_EQUALTO_3M = r128_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR128_3M_T_EQUALTO_6M() {
		return R128_3M_T_EQUALTO_6M;
	}
	public void setR128_3M_T_EQUALTO_6M(BigDecimal r128_3m_T_EQUALTO_6M) {
		R128_3M_T_EQUALTO_6M = r128_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR128_6M_T_EQUALTO_9M() {
		return R128_6M_T_EQUALTO_9M;
	}
	public void setR128_6M_T_EQUALTO_9M(BigDecimal r128_6m_T_EQUALTO_9M) {
		R128_6M_T_EQUALTO_9M = r128_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR128_9M_T_EQUALTO_1Y() {
		return R128_9M_T_EQUALTO_1Y;
	}
	public void setR128_9M_T_EQUALTO_1Y(BigDecimal r128_9m_T_EQUALTO_1Y) {
		R128_9M_T_EQUALTO_1Y = r128_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR128_1Y_T_EQUALTO_1POINT5Y() {
		return R128_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR128_1Y_T_EQUALTO_1POINT5Y(BigDecimal r128_1y_T_EQUALTO_1POINT5Y) {
		R128_1Y_T_EQUALTO_1POINT5Y = r128_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR128_1POINT5Y_T_EQUALTO_2Y() {
		return R128_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR128_1POINT5Y_T_EQUALTO_2Y(BigDecimal r128_1point5y_T_EQUALTO_2Y) {
		R128_1POINT5Y_T_EQUALTO_2Y = r128_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR128_2Y_T_EQUALTO_3Y() {
		return R128_2Y_T_EQUALTO_3Y;
	}
	public void setR128_2Y_T_EQUALTO_3Y(BigDecimal r128_2y_T_EQUALTO_3Y) {
		R128_2Y_T_EQUALTO_3Y = r128_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR128_3Y_T_EQUALTO_4Y() {
		return R128_3Y_T_EQUALTO_4Y;
	}
	public void setR128_3Y_T_EQUALTO_4Y(BigDecimal r128_3y_T_EQUALTO_4Y) {
		R128_3Y_T_EQUALTO_4Y = r128_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR128_4Y_LT_T_LTEQUALTO_5Y() {
		return R128_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR128_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r128_4y_LT_T_LTEQUALTO_5Y) {
		R128_4Y_LT_T_LTEQUALTO_5Y = r128_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR128_5Y_LT_T_LTEQUALTO_6Y() {
		return R128_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR128_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r128_5y_LT_T_LTEQUALTO_6Y) {
		R128_5Y_LT_T_LTEQUALTO_6Y = r128_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR128_6Y_LT_T_LTEQUALTO_7Y() {
		return R128_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR128_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r128_6y_LT_T_LTEQUALTO_7Y) {
		R128_6Y_LT_T_LTEQUALTO_7Y = r128_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR128_7Y_LT_T_LTEQUALTO_8Y() {
		return R128_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR128_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r128_7y_LT_T_LTEQUALTO_8Y) {
		R128_7Y_LT_T_LTEQUALTO_8Y = r128_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR128_8Y_LT_T_LTEQUALTO_9Y() {
		return R128_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR128_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r128_8y_LT_T_LTEQUALTO_9Y) {
		R128_8Y_LT_T_LTEQUALTO_9Y = r128_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR128_9Y_LT_T_LTEQUALTO_10Y() {
		return R128_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR128_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r128_9y_LT_T_LTEQUALTO_10Y) {
		R128_9Y_LT_T_LTEQUALTO_10Y = r128_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR128_10Y_LT_T_LTEQUALTO_15Y() {
		return R128_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR128_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r128_10y_LT_T_LTEQUALTO_15Y) {
		R128_10Y_LT_T_LTEQUALTO_15Y = r128_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR128_15Y_LT_T_LTEQUALTO_20Y() {
		return R128_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR128_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r128_15y_LT_T_LTEQUALTO_20Y) {
		R128_15Y_LT_T_LTEQUALTO_20Y = r128_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR128_TL_20Y() {
		return R128_TL_20Y;
	}
	public void setR128_TL_20Y(BigDecimal r128_TL_20Y) {
		R128_TL_20Y = r128_TL_20Y;
	}
	public BigDecimal getR128_NONSENSITIVE() {
		return R128_NONSENSITIVE;
	}
	public void setR128_NONSENSITIVE(BigDecimal r128_NONSENSITIVE) {
		R128_NONSENSITIVE = r128_NONSENSITIVE;
	}
	public BigDecimal getR128_TOTAL_RSL() {
		return R128_TOTAL_RSL;
	}
	public void setR128_TOTAL_RSL(BigDecimal r128_TOTAL_RSL) {
		R128_TOTAL_RSL = r128_TOTAL_RSL;
	}
	public BigDecimal getR128_TOTAL() {
		return R128_TOTAL;
	}
	public void setR128_TOTAL(BigDecimal r128_TOTAL) {
		R128_TOTAL = r128_TOTAL;
	}
	public String getR129_PRODUCT() {
		return R129_PRODUCT;
	}
	public void setR129_PRODUCT(String r129_PRODUCT) {
		R129_PRODUCT = r129_PRODUCT;
	}
	public BigDecimal getR129_TEQUALON() {
		return R129_TEQUALON;
	}
	public void setR129_TEQUALON(BigDecimal r129_TEQUALON) {
		R129_TEQUALON = r129_TEQUALON;
	}
	public BigDecimal getR129_ON_T_EQUALTO_1M() {
		return R129_ON_T_EQUALTO_1M;
	}
	public void setR129_ON_T_EQUALTO_1M(BigDecimal r129_ON_T_EQUALTO_1M) {
		R129_ON_T_EQUALTO_1M = r129_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR129_1M_T_EQUALTO_3M() {
		return R129_1M_T_EQUALTO_3M;
	}
	public void setR129_1M_T_EQUALTO_3M(BigDecimal r129_1m_T_EQUALTO_3M) {
		R129_1M_T_EQUALTO_3M = r129_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR129_3M_T_EQUALTO_6M() {
		return R129_3M_T_EQUALTO_6M;
	}
	public void setR129_3M_T_EQUALTO_6M(BigDecimal r129_3m_T_EQUALTO_6M) {
		R129_3M_T_EQUALTO_6M = r129_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR129_6M_T_EQUALTO_9M() {
		return R129_6M_T_EQUALTO_9M;
	}
	public void setR129_6M_T_EQUALTO_9M(BigDecimal r129_6m_T_EQUALTO_9M) {
		R129_6M_T_EQUALTO_9M = r129_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR129_9M_T_EQUALTO_1Y() {
		return R129_9M_T_EQUALTO_1Y;
	}
	public void setR129_9M_T_EQUALTO_1Y(BigDecimal r129_9m_T_EQUALTO_1Y) {
		R129_9M_T_EQUALTO_1Y = r129_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR129_1Y_T_EQUALTO_1POINT5Y() {
		return R129_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR129_1Y_T_EQUALTO_1POINT5Y(BigDecimal r129_1y_T_EQUALTO_1POINT5Y) {
		R129_1Y_T_EQUALTO_1POINT5Y = r129_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR129_1POINT5Y_T_EQUALTO_2Y() {
		return R129_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR129_1POINT5Y_T_EQUALTO_2Y(BigDecimal r129_1point5y_T_EQUALTO_2Y) {
		R129_1POINT5Y_T_EQUALTO_2Y = r129_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR129_2Y_T_EQUALTO_3Y() {
		return R129_2Y_T_EQUALTO_3Y;
	}
	public void setR129_2Y_T_EQUALTO_3Y(BigDecimal r129_2y_T_EQUALTO_3Y) {
		R129_2Y_T_EQUALTO_3Y = r129_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR129_3Y_T_EQUALTO_4Y() {
		return R129_3Y_T_EQUALTO_4Y;
	}
	public void setR129_3Y_T_EQUALTO_4Y(BigDecimal r129_3y_T_EQUALTO_4Y) {
		R129_3Y_T_EQUALTO_4Y = r129_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR129_4Y_LT_T_LTEQUALTO_5Y() {
		return R129_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR129_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r129_4y_LT_T_LTEQUALTO_5Y) {
		R129_4Y_LT_T_LTEQUALTO_5Y = r129_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR129_5Y_LT_T_LTEQUALTO_6Y() {
		return R129_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR129_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r129_5y_LT_T_LTEQUALTO_6Y) {
		R129_5Y_LT_T_LTEQUALTO_6Y = r129_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR129_6Y_LT_T_LTEQUALTO_7Y() {
		return R129_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR129_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r129_6y_LT_T_LTEQUALTO_7Y) {
		R129_6Y_LT_T_LTEQUALTO_7Y = r129_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR129_7Y_LT_T_LTEQUALTO_8Y() {
		return R129_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR129_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r129_7y_LT_T_LTEQUALTO_8Y) {
		R129_7Y_LT_T_LTEQUALTO_8Y = r129_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR129_8Y_LT_T_LTEQUALTO_9Y() {
		return R129_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR129_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r129_8y_LT_T_LTEQUALTO_9Y) {
		R129_8Y_LT_T_LTEQUALTO_9Y = r129_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR129_9Y_LT_T_LTEQUALTO_10Y() {
		return R129_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR129_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r129_9y_LT_T_LTEQUALTO_10Y) {
		R129_9Y_LT_T_LTEQUALTO_10Y = r129_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR129_10Y_LT_T_LTEQUALTO_15Y() {
		return R129_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR129_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r129_10y_LT_T_LTEQUALTO_15Y) {
		R129_10Y_LT_T_LTEQUALTO_15Y = r129_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR129_15Y_LT_T_LTEQUALTO_20Y() {
		return R129_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR129_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r129_15y_LT_T_LTEQUALTO_20Y) {
		R129_15Y_LT_T_LTEQUALTO_20Y = r129_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR129_TL_20Y() {
		return R129_TL_20Y;
	}
	public void setR129_TL_20Y(BigDecimal r129_TL_20Y) {
		R129_TL_20Y = r129_TL_20Y;
	}
	public BigDecimal getR129_NONSENSITIVE() {
		return R129_NONSENSITIVE;
	}
	public void setR129_NONSENSITIVE(BigDecimal r129_NONSENSITIVE) {
		R129_NONSENSITIVE = r129_NONSENSITIVE;
	}
	public BigDecimal getR129_TOTAL_RSL() {
		return R129_TOTAL_RSL;
	}
	public void setR129_TOTAL_RSL(BigDecimal r129_TOTAL_RSL) {
		R129_TOTAL_RSL = r129_TOTAL_RSL;
	}
	public BigDecimal getR129_TOTAL() {
		return R129_TOTAL;
	}
	public void setR129_TOTAL(BigDecimal r129_TOTAL) {
		R129_TOTAL = r129_TOTAL;
	}
	public String getR130_PRODUCT() {
		return R130_PRODUCT;
	}
	public void setR130_PRODUCT(String r130_PRODUCT) {
		R130_PRODUCT = r130_PRODUCT;
	}
	public BigDecimal getR130_TEQUALON() {
		return R130_TEQUALON;
	}
	public void setR130_TEQUALON(BigDecimal r130_TEQUALON) {
		R130_TEQUALON = r130_TEQUALON;
	}
	public BigDecimal getR130_ON_T_EQUALTO_1M() {
		return R130_ON_T_EQUALTO_1M;
	}
	public void setR130_ON_T_EQUALTO_1M(BigDecimal r130_ON_T_EQUALTO_1M) {
		R130_ON_T_EQUALTO_1M = r130_ON_T_EQUALTO_1M;
	}
	public BigDecimal getR130_1M_T_EQUALTO_3M() {
		return R130_1M_T_EQUALTO_3M;
	}
	public void setR130_1M_T_EQUALTO_3M(BigDecimal r130_1m_T_EQUALTO_3M) {
		R130_1M_T_EQUALTO_3M = r130_1m_T_EQUALTO_3M;
	}
	public BigDecimal getR130_3M_T_EQUALTO_6M() {
		return R130_3M_T_EQUALTO_6M;
	}
	public void setR130_3M_T_EQUALTO_6M(BigDecimal r130_3m_T_EQUALTO_6M) {
		R130_3M_T_EQUALTO_6M = r130_3m_T_EQUALTO_6M;
	}
	public BigDecimal getR130_6M_T_EQUALTO_9M() {
		return R130_6M_T_EQUALTO_9M;
	}
	public void setR130_6M_T_EQUALTO_9M(BigDecimal r130_6m_T_EQUALTO_9M) {
		R130_6M_T_EQUALTO_9M = r130_6m_T_EQUALTO_9M;
	}
	public BigDecimal getR130_9M_T_EQUALTO_1Y() {
		return R130_9M_T_EQUALTO_1Y;
	}
	public void setR130_9M_T_EQUALTO_1Y(BigDecimal r130_9m_T_EQUALTO_1Y) {
		R130_9M_T_EQUALTO_1Y = r130_9m_T_EQUALTO_1Y;
	}
	public BigDecimal getR130_1Y_T_EQUALTO_1POINT5Y() {
		return R130_1Y_T_EQUALTO_1POINT5Y;
	}
	public void setR130_1Y_T_EQUALTO_1POINT5Y(BigDecimal r130_1y_T_EQUALTO_1POINT5Y) {
		R130_1Y_T_EQUALTO_1POINT5Y = r130_1y_T_EQUALTO_1POINT5Y;
	}
	public BigDecimal getR130_1POINT5Y_T_EQUALTO_2Y() {
		return R130_1POINT5Y_T_EQUALTO_2Y;
	}
	public void setR130_1POINT5Y_T_EQUALTO_2Y(BigDecimal r130_1point5y_T_EQUALTO_2Y) {
		R130_1POINT5Y_T_EQUALTO_2Y = r130_1point5y_T_EQUALTO_2Y;
	}
	public BigDecimal getR130_2Y_T_EQUALTO_3Y() {
		return R130_2Y_T_EQUALTO_3Y;
	}
	public void setR130_2Y_T_EQUALTO_3Y(BigDecimal r130_2y_T_EQUALTO_3Y) {
		R130_2Y_T_EQUALTO_3Y = r130_2y_T_EQUALTO_3Y;
	}
	public BigDecimal getR130_3Y_T_EQUALTO_4Y() {
		return R130_3Y_T_EQUALTO_4Y;
	}
	public void setR130_3Y_T_EQUALTO_4Y(BigDecimal r130_3y_T_EQUALTO_4Y) {
		R130_3Y_T_EQUALTO_4Y = r130_3y_T_EQUALTO_4Y;
	}
	public BigDecimal getR130_4Y_LT_T_LTEQUALTO_5Y() {
		return R130_4Y_LT_T_LTEQUALTO_5Y;
	}
	public void setR130_4Y_LT_T_LTEQUALTO_5Y(BigDecimal r130_4y_LT_T_LTEQUALTO_5Y) {
		R130_4Y_LT_T_LTEQUALTO_5Y = r130_4y_LT_T_LTEQUALTO_5Y;
	}
	public BigDecimal getR130_5Y_LT_T_LTEQUALTO_6Y() {
		return R130_5Y_LT_T_LTEQUALTO_6Y;
	}
	public void setR130_5Y_LT_T_LTEQUALTO_6Y(BigDecimal r130_5y_LT_T_LTEQUALTO_6Y) {
		R130_5Y_LT_T_LTEQUALTO_6Y = r130_5y_LT_T_LTEQUALTO_6Y;
	}
	public BigDecimal getR130_6Y_LT_T_LTEQUALTO_7Y() {
		return R130_6Y_LT_T_LTEQUALTO_7Y;
	}
	public void setR130_6Y_LT_T_LTEQUALTO_7Y(BigDecimal r130_6y_LT_T_LTEQUALTO_7Y) {
		R130_6Y_LT_T_LTEQUALTO_7Y = r130_6y_LT_T_LTEQUALTO_7Y;
	}
	public BigDecimal getR130_7Y_LT_T_LTEQUALTO_8Y() {
		return R130_7Y_LT_T_LTEQUALTO_8Y;
	}
	public void setR130_7Y_LT_T_LTEQUALTO_8Y(BigDecimal r130_7y_LT_T_LTEQUALTO_8Y) {
		R130_7Y_LT_T_LTEQUALTO_8Y = r130_7y_LT_T_LTEQUALTO_8Y;
	}
	public BigDecimal getR130_8Y_LT_T_LTEQUALTO_9Y() {
		return R130_8Y_LT_T_LTEQUALTO_9Y;
	}
	public void setR130_8Y_LT_T_LTEQUALTO_9Y(BigDecimal r130_8y_LT_T_LTEQUALTO_9Y) {
		R130_8Y_LT_T_LTEQUALTO_9Y = r130_8y_LT_T_LTEQUALTO_9Y;
	}
	public BigDecimal getR130_9Y_LT_T_LTEQUALTO_10Y() {
		return R130_9Y_LT_T_LTEQUALTO_10Y;
	}
	public void setR130_9Y_LT_T_LTEQUALTO_10Y(BigDecimal r130_9y_LT_T_LTEQUALTO_10Y) {
		R130_9Y_LT_T_LTEQUALTO_10Y = r130_9y_LT_T_LTEQUALTO_10Y;
	}
	public BigDecimal getR130_10Y_LT_T_LTEQUALTO_15Y() {
		return R130_10Y_LT_T_LTEQUALTO_15Y;
	}
	public void setR130_10Y_LT_T_LTEQUALTO_15Y(BigDecimal r130_10y_LT_T_LTEQUALTO_15Y) {
		R130_10Y_LT_T_LTEQUALTO_15Y = r130_10y_LT_T_LTEQUALTO_15Y;
	}
	public BigDecimal getR130_15Y_LT_T_LTEQUALTO_20Y() {
		return R130_15Y_LT_T_LTEQUALTO_20Y;
	}
	public void setR130_15Y_LT_T_LTEQUALTO_20Y(BigDecimal r130_15y_LT_T_LTEQUALTO_20Y) {
		R130_15Y_LT_T_LTEQUALTO_20Y = r130_15y_LT_T_LTEQUALTO_20Y;
	}
	public BigDecimal getR130_TL_20Y() {
		return R130_TL_20Y;
	}
	public void setR130_TL_20Y(BigDecimal r130_TL_20Y) {
		R130_TL_20Y = r130_TL_20Y;
	}
	public BigDecimal getR130_NONSENSITIVE() {
		return R130_NONSENSITIVE;
	}
	public void setR130_NONSENSITIVE(BigDecimal r130_NONSENSITIVE) {
		R130_NONSENSITIVE = r130_NONSENSITIVE;
	}
	public BigDecimal getR130_TOTAL_RSL() {
		return R130_TOTAL_RSL;
	}
	public void setR130_TOTAL_RSL(BigDecimal r130_TOTAL_RSL) {
		R130_TOTAL_RSL = r130_TOTAL_RSL;
	}
	public BigDecimal getR130_TOTAL() {
		return R130_TOTAL;
	}
	public void setR130_TOTAL(BigDecimal r130_TOTAL) {
		R130_TOTAL = r130_TOTAL;
	}
	public Date getREPORT_Date() {
		return REPORT_Date;
	}
	public void setREPORT_Date(Date rEPORT_Date) {
		REPORT_Date = rEPORT_Date;
	}
	public Date getREPORT_FROM_Date() {
		return REPORT_FROM_Date;
	}
	public void setREPORT_FROM_Date(Date rEPORT_FROM_Date) {
		REPORT_FROM_Date = rEPORT_FROM_Date;
	}
	public Date getREPORT_TO_Date() {
		return REPORT_TO_Date;
	}
	public void setREPORT_TO_Date(Date rEPORT_TO_Date) {
		REPORT_TO_Date = rEPORT_TO_Date;
	}
	public String getENTITY_FLG() {
		return ENTITY_FLG;
	}
	public void setENTITY_FLG(String eNTITY_FLG) {
		ENTITY_FLG = eNTITY_FLG;
	}
	public String getMODIFY_FLG() {
		return MODIFY_FLG;
	}
	public void setMODIFY_FLG(String mODIFY_FLG) {
		MODIFY_FLG = mODIFY_FLG;
	}
	public String getDEL_FLG() {
		return DEL_FLG;
	}
	public void setDEL_FLG(String dEL_FLG) {
		DEL_FLG = dEL_FLG;
	}
	public String getREPORT_CODE() {
		return REPORT_CODE;
	}
	public void setREPORT_CODE(String rEPORT_CODE) {
		REPORT_CODE = rEPORT_CODE;
	}
	public Date getREPORT_SUBMIT_Date() {
		return REPORT_SUBMIT_Date;
	}
	public void setREPORT_SUBMIT_Date(Date rEPORT_SUBMIT_Date) {
		REPORT_SUBMIT_Date = rEPORT_SUBMIT_Date;
	}

}