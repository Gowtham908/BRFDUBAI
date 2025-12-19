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
@Table(name="BANKING_BOOK1_CONS1")
public class Banking_Book1_Cons {
	private String	r7_product;
	private BigDecimal	r7_tequalon;
	private BigDecimal	r7_on_t_equalto_1m;
	private BigDecimal	r7_1m_t_equalto_3m;
	private BigDecimal	r7_3m_t_equalto_6m;
	private BigDecimal	r7_6m_t_equalto_9m;
	private BigDecimal	r7_9m_t_equalto_1y;
	private BigDecimal	r7_1y_t_equalto_1point5y;
	private BigDecimal	r7_1point5y_t_equalto_2y;
	private BigDecimal	r7_2y_t_equalto_3y;
	private BigDecimal	r7_3y_t_equalto_4y;
	private BigDecimal	r7_4y_lt_t_ltequalto_5y;
	private BigDecimal	r7_5y_lt_t_ltequalto_6y;
	private BigDecimal	r7_6y_lt_t_ltequalto_7y;
	private BigDecimal	r7_7y_lt_t_ltequalto_8y;
	private BigDecimal	r7_8y_lt_t_ltequalto_9y;
	private BigDecimal	r7_9y_lt_t_ltequalto_10y;
	private BigDecimal	r7_10y_lt_t_ltequalto_15y;
	private BigDecimal	r7_15y_lt_t_ltequalto_20y;
	private BigDecimal	r7_tl_20y;
	private BigDecimal	r7_nonsensitive;
	private BigDecimal	r7_total_rsl;
	private BigDecimal	r7_total;
	private String	r8_product;
	private BigDecimal	r8_tequalon;
	private BigDecimal	r8_on_t_equalto_1m;
	private BigDecimal	r8_1m_t_equalto_3m;
	private BigDecimal	r8_3m_t_equalto_6m;
	private BigDecimal	r8_6m_t_equalto_9m;
	private BigDecimal	r8_9m_t_equalto_1y;
	private BigDecimal	r8_1y_t_equalto_1point5y;
	private BigDecimal	r8_1point5y_t_equalto_2y;
	private BigDecimal	r8_2y_t_equalto_3y;
	private BigDecimal	r8_3y_t_equalto_4y;
	private BigDecimal	r8_4y_lt_t_ltequalto_5y;
	private BigDecimal	r8_5y_lt_t_ltequalto_6y;
	private BigDecimal	r8_6y_lt_t_ltequalto_7y;
	private BigDecimal	r8_7y_lt_t_ltequalto_8y;
	private BigDecimal	r8_8y_lt_t_ltequalto_9y;
	private BigDecimal	r8_9y_lt_t_ltequalto_10y;
	private BigDecimal	r8_10y_lt_t_ltequalto_15y;
	private BigDecimal	r8_15y_lt_t_ltequalto_20y;
	private BigDecimal	r8_tl_20y;
	private BigDecimal	r8_nonsensitive;
	private BigDecimal	r8_total_rsl;
	private BigDecimal	r8_total;
	private String	r9_product;
	private BigDecimal	r9_tequalon;
	private BigDecimal	r9_on_t_equalto_1m;
	private BigDecimal	r9_1m_t_equalto_3m;
	private BigDecimal	r9_3m_t_equalto_6m;
	private BigDecimal	r9_6m_t_equalto_9m;
	private BigDecimal	r9_9m_t_equalto_1y;
	private BigDecimal	r9_1y_t_equalto_1point5y;
	private BigDecimal	r9_1point5y_t_equalto_2y;
	private BigDecimal	r9_2y_t_equalto_3y;
	private BigDecimal	r9_3y_t_equalto_4y;
	private BigDecimal	r9_4y_lt_t_ltequalto_5y;
	private BigDecimal	r9_5y_lt_t_ltequalto_6y;
	private BigDecimal	r9_6y_lt_t_ltequalto_7y;
	private BigDecimal	r9_7y_lt_t_ltequalto_8y;
	private BigDecimal	r9_8y_lt_t_ltequalto_9y;
	private BigDecimal	r9_9y_lt_t_ltequalto_10y;
	private BigDecimal	r9_10y_lt_t_ltequalto_15y;
	private BigDecimal	r9_15y_lt_t_ltequalto_20y;
	private BigDecimal	r9_tl_20y;
	private BigDecimal	r9_nonsensitive;
	private BigDecimal	r9_total_rsl;
	private BigDecimal	r9_total;
	private String	r10_product;
	private BigDecimal	r10_tequalon;
	private BigDecimal	r10_on_t_equalto_1m;
	private BigDecimal	r10_1m_t_equalto_3m;
	private BigDecimal	r10_3m_t_equalto_6m;
	private BigDecimal	r10_6m_t_equalto_9m;
	private BigDecimal	r10_9m_t_equalto_1y;
	private BigDecimal	r10_1y_t_equalto_1point5y;
	private BigDecimal	r10_1point5y_t_equalto_2y;
	private BigDecimal	r10_2y_t_equalto_3y;
	private BigDecimal	r10_3y_t_equalto_4y;
	private BigDecimal	r10_4y_lt_t_ltequalto_5y;
	private BigDecimal	r10_5y_lt_t_ltequalto_6y;
	private BigDecimal	r10_6y_lt_t_ltequalto_7y;
	private BigDecimal	r10_7y_lt_t_ltequalto_8y;
	private BigDecimal	r10_8y_lt_t_ltequalto_9y;
	private BigDecimal	r10_9y_lt_t_ltequalto_10y;
	private BigDecimal	r10_10y_lt_t_ltequalto_15y;
	private BigDecimal	r10_15y_lt_t_ltequalto_20y;
	private BigDecimal	r10_tl_20y;
	private BigDecimal	r10_nonsensitive;
	private BigDecimal	r10_total_rsl;
	private BigDecimal	r10_total;
	private String	r11_product;
	private BigDecimal	r11_tequalon;
	private BigDecimal	r11_on_t_equalto_1m;
	private BigDecimal	r11_1m_t_equalto_3m;
	private BigDecimal	r11_3m_t_equalto_6m;
	private BigDecimal	r11_6m_t_equalto_9m;
	private BigDecimal	r11_9m_t_equalto_1y;
	private BigDecimal	r11_1y_t_equalto_1point5y;
	private BigDecimal	r11_1point5y_t_equalto_2y;
	private BigDecimal	r11_2y_t_equalto_3y;
	private BigDecimal	r11_3y_t_equalto_4y;
	private BigDecimal	r11_4y_lt_t_ltequalto_5y;
	private BigDecimal	r11_5y_lt_t_ltequalto_6y;
	private BigDecimal	r11_6y_lt_t_ltequalto_7y;
	private BigDecimal	r11_7y_lt_t_ltequalto_8y;
	private BigDecimal	r11_8y_lt_t_ltequalto_9y;
	private BigDecimal	r11_9y_lt_t_ltequalto_10y;
	private BigDecimal	r11_10y_lt_t_ltequalto_15y;
	private BigDecimal	r11_15y_lt_t_ltequalto_20y;
	private BigDecimal	r11_tl_20y;
	private BigDecimal	r11_nonsensitive;
	private BigDecimal	r11_total_rsl;
	private BigDecimal	r11_total;
	private String	r12_product;
	private BigDecimal	r12_tequalon;
	private BigDecimal	r12_on_t_equalto_1m;
	private BigDecimal	r12_1m_t_equalto_3m;
	private BigDecimal	r12_3m_t_equalto_6m;
	private BigDecimal	r12_6m_t_equalto_9m;
	private BigDecimal	r12_9m_t_equalto_1y;
	private BigDecimal	r12_1y_t_equalto_1point5y;
	private BigDecimal	r12_1point5y_t_equalto_2y;
	private BigDecimal	r12_2y_t_equalto_3y;
	private BigDecimal	r12_3y_t_equalto_4y;
	private BigDecimal	r12_4y_lt_t_ltequalto_5y;
	private BigDecimal	r12_5y_lt_t_ltequalto_6y;
	private BigDecimal	r12_6y_lt_t_ltequalto_7y;
	private BigDecimal	r12_7y_lt_t_ltequalto_8y;
	private BigDecimal	r12_8y_lt_t_ltequalto_9y;
	private BigDecimal	r12_9y_lt_t_ltequalto_10y;
	private BigDecimal	r12_10y_lt_t_ltequalto_15y;
	private BigDecimal	r12_15y_lt_t_ltequalto_20y;
	private BigDecimal	r12_tl_20y;
	private BigDecimal	r12_nonsensitive;
	private BigDecimal	r12_total_rsl;
	private BigDecimal	r12_total;
	private String	r13_product;
	private BigDecimal	r13_tequalon;
	private BigDecimal	r13_on_t_equalto_1m;
	private BigDecimal	r13_1m_t_equalto_3m;
	private BigDecimal	r13_3m_t_equalto_6m;
	private BigDecimal	r13_6m_t_equalto_9m;
	private BigDecimal	r13_9m_t_equalto_1y;
	private BigDecimal	r13_1y_t_equalto_1point5y;
	private BigDecimal	r13_1point5y_t_equalto_2y;
	private BigDecimal	r13_2y_t_equalto_3y;
	private BigDecimal	r13_3y_t_equalto_4y;
	private BigDecimal	r13_4y_lt_t_ltequalto_5y;
	private BigDecimal	r13_5y_lt_t_ltequalto_6y;
	private BigDecimal	r13_6y_lt_t_ltequalto_7y;
	private BigDecimal	r13_7y_lt_t_ltequalto_8y;
	private BigDecimal	r13_8y_lt_t_ltequalto_9y;
	private BigDecimal	r13_9y_lt_t_ltequalto_10y;
	private BigDecimal	r13_10y_lt_t_ltequalto_15y;
	private BigDecimal	r13_15y_lt_t_ltequalto_20y;
	private BigDecimal	r13_tl_20y;
	private BigDecimal	r13_nonsensitive;
	private BigDecimal	r13_total_rsl;
	private BigDecimal	r13_total;
	private String	r14_product;
	private BigDecimal	r14_tequalon;
	private BigDecimal	r14_on_t_equalto_1m;
	private BigDecimal	r14_1m_t_equalto_3m;
	private BigDecimal	r14_3m_t_equalto_6m;
	private BigDecimal	r14_6m_t_equalto_9m;
	private BigDecimal	r14_9m_t_equalto_1y;
	private BigDecimal	r14_1y_t_equalto_1point5y;
	private BigDecimal	r14_1point5y_t_equalto_2y;
	private BigDecimal	r14_2y_t_equalto_3y;
	private BigDecimal	r14_3y_t_equalto_4y;
	private BigDecimal	r14_4y_lt_t_ltequalto_5y;
	private BigDecimal	r14_5y_lt_t_ltequalto_6y;
	private BigDecimal	r14_6y_lt_t_ltequalto_7y;
	private BigDecimal	r14_7y_lt_t_ltequalto_8y;
	private BigDecimal	r14_8y_lt_t_ltequalto_9y;
	private BigDecimal	r14_9y_lt_t_ltequalto_10y;
	private BigDecimal	r14_10y_lt_t_ltequalto_15y;
	private BigDecimal	r14_15y_lt_t_ltequalto_20y;
	private BigDecimal	r14_tl_20y;
	private BigDecimal	r14_nonsensitive;
	private BigDecimal	r14_total_rsl;
	private BigDecimal	r14_total;
	private String	r15_product;
	private BigDecimal	r15_tequalon;
	private BigDecimal	r15_on_t_equalto_1m;
	private BigDecimal	r15_1m_t_equalto_3m;
	private BigDecimal	r15_3m_t_equalto_6m;
	private BigDecimal	r15_6m_t_equalto_9m;
	private BigDecimal	r15_9m_t_equalto_1y;
	private BigDecimal	r15_1y_t_equalto_1point5y;
	private BigDecimal	r15_1point5y_t_equalto_2y;
	private BigDecimal	r15_2y_t_equalto_3y;
	private BigDecimal	r15_3y_t_equalto_4y;
	private BigDecimal	r15_4y_lt_t_ltequalto_5y;
	private BigDecimal	r15_5y_lt_t_ltequalto_6y;
	private BigDecimal	r15_6y_lt_t_ltequalto_7y;
	private BigDecimal	r15_7y_lt_t_ltequalto_8y;
	private BigDecimal	r15_8y_lt_t_ltequalto_9y;
	private BigDecimal	r15_9y_lt_t_ltequalto_10y;
	private BigDecimal	r15_10y_lt_t_ltequalto_15y;
	private BigDecimal	r15_15y_lt_t_ltequalto_20y;
	private BigDecimal	r15_tl_20y;
	private BigDecimal	r15_nonsensitive;
	private BigDecimal	r15_total_rsl;
	private BigDecimal	r15_total;
	private String	r16_product;
	private BigDecimal	r16_tequalon;
	private BigDecimal	r16_on_t_equalto_1m;
	private BigDecimal	r16_1m_t_equalto_3m;
	private BigDecimal	r16_3m_t_equalto_6m;
	private BigDecimal	r16_6m_t_equalto_9m;
	private BigDecimal	r16_9m_t_equalto_1y;
	private BigDecimal	r16_1y_t_equalto_1point5y;
	private BigDecimal	r16_1point5y_t_equalto_2y;
	private BigDecimal	r16_2y_t_equalto_3y;
	private BigDecimal	r16_3y_t_equalto_4y;
	private BigDecimal	r16_4y_lt_t_ltequalto_5y;
	private BigDecimal	r16_5y_lt_t_ltequalto_6y;
	private BigDecimal	r16_6y_lt_t_ltequalto_7y;
	private BigDecimal	r16_7y_lt_t_ltequalto_8y;
	private BigDecimal	r16_8y_lt_t_ltequalto_9y;
	private BigDecimal	r16_9y_lt_t_ltequalto_10y;
	private BigDecimal	r16_10y_lt_t_ltequalto_15y;
	private BigDecimal	r16_15y_lt_t_ltequalto_20y;
	private BigDecimal	r16_tl_20y;
	private BigDecimal	r16_nonsensitive;
	private BigDecimal	r16_total_rsl;
	private BigDecimal	r16_total;
	private String	r17_product;
	private BigDecimal	r17_tequalon;
	private BigDecimal	r17_on_t_equalto_1m;
	private BigDecimal	r17_1m_t_equalto_3m;
	private BigDecimal	r17_3m_t_equalto_6m;
	private BigDecimal	r17_6m_t_equalto_9m;
	private BigDecimal	r17_9m_t_equalto_1y;
	private BigDecimal	r17_1y_t_equalto_1point5y;
	private BigDecimal	r17_1point5y_t_equalto_2y;
	private BigDecimal	r17_2y_t_equalto_3y;
	private BigDecimal	r17_3y_t_equalto_4y;
	private BigDecimal	r17_4y_lt_t_ltequalto_5y;
	private BigDecimal	r17_5y_lt_t_ltequalto_6y;
	private BigDecimal	r17_6y_lt_t_ltequalto_7y;
	private BigDecimal	r17_7y_lt_t_ltequalto_8y;
	private BigDecimal	r17_8y_lt_t_ltequalto_9y;
	private BigDecimal	r17_9y_lt_t_ltequalto_10y;
	private BigDecimal	r17_10y_lt_t_ltequalto_15y;
	private BigDecimal	r17_15y_lt_t_ltequalto_20y;
	private BigDecimal	r17_tl_20y;
	private BigDecimal	r17_nonsensitive;
	private BigDecimal	r17_total_rsl;
	private BigDecimal	r17_total;
	private String	r18_product;
	private BigDecimal	r18_tequalon;
	private BigDecimal	r18_on_t_equalto_1m;
	private BigDecimal	r18_1m_t_equalto_3m;
	private BigDecimal	r18_3m_t_equalto_6m;
	private BigDecimal	r18_6m_t_equalto_9m;
	private BigDecimal	r18_9m_t_equalto_1y;
	private BigDecimal	r18_1y_t_equalto_1point5y;
	private BigDecimal	r18_1point5y_t_equalto_2y;
	private BigDecimal	r18_2y_t_equalto_3y;
	private BigDecimal	r18_3y_t_equalto_4y;
	private BigDecimal	r18_4y_lt_t_ltequalto_5y;
	private BigDecimal	r18_5y_lt_t_ltequalto_6y;
	private BigDecimal	r18_6y_lt_t_ltequalto_7y;
	private BigDecimal	r18_7y_lt_t_ltequalto_8y;
	private BigDecimal	r18_8y_lt_t_ltequalto_9y;
	private BigDecimal	r18_9y_lt_t_ltequalto_10y;
	private BigDecimal	r18_10y_lt_t_ltequalto_15y;
	private BigDecimal	r18_15y_lt_t_ltequalto_20y;
	private BigDecimal	r18_tl_20y;
	private BigDecimal	r18_nonsensitive;
	private BigDecimal	r18_total_rsl;
	private BigDecimal	r18_total;

	private String	r19_product;
	private BigDecimal	r19_tequalon;
	private BigDecimal	r19_on_t_equalto_1m;
	private BigDecimal	r19_1m_t_equalto_3m;
	private BigDecimal	r19_3m_t_equalto_6m;
	private BigDecimal	r19_6m_t_equalto_9m;
	private BigDecimal	r19_9m_t_equalto_1y;
	private BigDecimal	r19_1y_t_equalto_1point5y;
	private BigDecimal	r19_1point5y_t_equalto_2y;
	private BigDecimal	r19_2y_t_equalto_3y;
	private BigDecimal	r19_3y_t_equalto_4y;
	private BigDecimal	r19_4y_lt_t_ltequalto_5y;
	private BigDecimal	r19_5y_lt_t_ltequalto_6y;
	private BigDecimal	r19_6y_lt_t_ltequalto_7y;
	private BigDecimal	r19_7y_lt_t_ltequalto_8y;
	private BigDecimal	r19_8y_lt_t_ltequalto_9y;
	private BigDecimal	r19_9y_lt_t_ltequalto_10y;
	private BigDecimal	r19_10y_lt_t_ltequalto_15y;
	private BigDecimal	r19_15y_lt_t_ltequalto_20y;
	private BigDecimal	r19_tl_20y;
	private BigDecimal	r19_nonsensitive;
	private BigDecimal	r19_total_rsl;
	private BigDecimal	r19_total;
	private String	r20_product;
	private BigDecimal	r20_tequalon;
	private BigDecimal	r20_on_t_equalto_1m;
	private BigDecimal	r20_1m_t_equalto_3m;
	private BigDecimal	r20_3m_t_equalto_6m;
	private BigDecimal	r20_6m_t_equalto_9m;
	private BigDecimal	r20_9m_t_equalto_1y;
	private BigDecimal	r20_1y_t_equalto_1point5y;
	private BigDecimal	r20_1point5y_t_equalto_2y;
	private BigDecimal	r20_2y_t_equalto_3y;
	private BigDecimal	r20_3y_t_equalto_4y;
	private BigDecimal	r20_4y_lt_t_ltequalto_5y;
	private BigDecimal	r20_5y_lt_t_ltequalto_6y;
	private BigDecimal	r20_6y_lt_t_ltequalto_7y;
	private BigDecimal	r20_7y_lt_t_ltequalto_8y;
	private BigDecimal	r20_8y_lt_t_ltequalto_9y;
	private BigDecimal	r20_9y_lt_t_ltequalto_10y;
	private BigDecimal	r20_10y_lt_t_ltequalto_15y;
	private BigDecimal	r20_15y_lt_t_ltequalto_20y;
	private BigDecimal	r20_tl_20y;
	private BigDecimal	r20_nonsensitive;
	private BigDecimal	r20_total_rsl;
	private BigDecimal	r20_total;
	private String	r21_product;
	private BigDecimal	r21_tequalon;
	private BigDecimal	r21_on_t_equalto_1m;
	private BigDecimal	r21_1m_t_equalto_3m;
	private BigDecimal	r21_3m_t_equalto_6m;
	private BigDecimal	r21_6m_t_equalto_9m;
	private BigDecimal	r21_9m_t_equalto_1y;
	private BigDecimal	r21_1y_t_equalto_1point5y;
	private BigDecimal	r21_1point5y_t_equalto_2y;
	private BigDecimal	r21_2y_t_equalto_3y;
	private BigDecimal	r21_3y_t_equalto_4y;
	private BigDecimal	r21_4y_lt_t_ltequalto_5y;
	private BigDecimal	r21_5y_lt_t_ltequalto_6y;
	private BigDecimal	r21_6y_lt_t_ltequalto_7y;
	private BigDecimal	r21_7y_lt_t_ltequalto_8y;
	private BigDecimal	r21_8y_lt_t_ltequalto_9y;
	private BigDecimal	r21_9y_lt_t_ltequalto_10y;
	private BigDecimal	r21_10y_lt_t_ltequalto_15y;
	private BigDecimal	r21_15y_lt_t_ltequalto_20y;
	private BigDecimal	r21_tl_20y;
	private BigDecimal	r21_nonsensitive;
	private BigDecimal	r21_total_rsl;
	private BigDecimal	r21_total;
	private String	r22_product;
	private BigDecimal	r22_tequalon;
	private BigDecimal	r22_on_t_equalto_1m;
	private BigDecimal	r22_1m_t_equalto_3m;
	private BigDecimal	r22_3m_t_equalto_6m;
	private BigDecimal	r22_6m_t_equalto_9m;
	private BigDecimal	r22_9m_t_equalto_1y;
	private BigDecimal	r22_1y_t_equalto_1point5y;
	private BigDecimal	r22_1point5y_t_equalto_2y;
	private BigDecimal	r22_2y_t_equalto_3y;
	private BigDecimal	r22_3y_t_equalto_4y;
	private BigDecimal	r22_4y_lt_t_ltequalto_5y;
	private BigDecimal	r22_5y_lt_t_ltequalto_6y;
	private BigDecimal	r22_6y_lt_t_ltequalto_7y;
	private BigDecimal	r22_7y_lt_t_ltequalto_8y;
	private BigDecimal	r22_8y_lt_t_ltequalto_9y;
	private BigDecimal	r22_9y_lt_t_ltequalto_10y;
	private BigDecimal	r22_10y_lt_t_ltequalto_15y;
	private BigDecimal	r22_15y_lt_t_ltequalto_20y;
	private BigDecimal	r22_tl_20y;
	private BigDecimal	r22_nonsensitive;
	private BigDecimal	r22_total_rsl;
	private BigDecimal	r22_total;
	private String	r23_product;
	private BigDecimal	r23_tequalon;
	private BigDecimal	r23_on_t_equalto_1m;
	private BigDecimal	r23_1m_t_equalto_3m;
	private BigDecimal	r23_3m_t_equalto_6m;
	private BigDecimal	r23_6m_t_equalto_9m;
	private BigDecimal	r23_9m_t_equalto_1y;
	private BigDecimal	r23_1y_t_equalto_1point5y;
	private BigDecimal	r23_1point5y_t_equalto_2y;
	private BigDecimal	r23_2y_t_equalto_3y;
	private BigDecimal	r23_3y_t_equalto_4y;
	private BigDecimal	r23_4y_lt_t_ltequalto_5y;
	private BigDecimal	r23_5y_lt_t_ltequalto_6y;
	private BigDecimal	r23_6y_lt_t_ltequalto_7y;
	private BigDecimal	r23_7y_lt_t_ltequalto_8y;
	private BigDecimal	r23_8y_lt_t_ltequalto_9y;
	private BigDecimal	r23_9y_lt_t_ltequalto_10y;
	private BigDecimal	r23_10y_lt_t_ltequalto_15y;
	private BigDecimal	r23_15y_lt_t_ltequalto_20y;
	private BigDecimal	r23_tl_20y;
	private BigDecimal	r23_nonsensitive;
	private BigDecimal	r23_total_rsl;
	private BigDecimal	r23_total;
	private String	r24_product;
	private BigDecimal	r24_tequalon;
	private BigDecimal	r24_on_t_equalto_1m;
	private BigDecimal	r24_1m_t_equalto_3m;
	private BigDecimal	r24_3m_t_equalto_6m;
	private BigDecimal	r24_6m_t_equalto_9m;
	private BigDecimal	r24_9m_t_equalto_1y;
	private BigDecimal	r24_1y_t_equalto_1point5y;
	private BigDecimal	r24_1point5y_t_equalto_2y;
	private BigDecimal	r24_2y_t_equalto_3y;
	private BigDecimal	r24_3y_t_equalto_4y;
	private BigDecimal	r24_4y_lt_t_ltequalto_5y;
	private BigDecimal	r24_5y_lt_t_ltequalto_6y;
	private BigDecimal	r24_6y_lt_t_ltequalto_7y;
	private BigDecimal	r24_7y_lt_t_ltequalto_8y;
	private BigDecimal	r24_8y_lt_t_ltequalto_9y;
	private BigDecimal	r24_9y_lt_t_ltequalto_10y;
	private BigDecimal	r24_10y_lt_t_ltequalto_15y;
	private BigDecimal	r24_15y_lt_t_ltequalto_20y;
	private BigDecimal	r24_tl_20y;
	private BigDecimal	r24_nonsensitive;
	private BigDecimal	r24_total_rsl;
	private BigDecimal	r24_total;
	private String	r25_product;
	private BigDecimal	r25_tequalon;
	private BigDecimal	r25_on_t_equalto_1m;
	private BigDecimal	r25_1m_t_equalto_3m;
	private BigDecimal	r25_3m_t_equalto_6m;
	private BigDecimal	r25_6m_t_equalto_9m;
	private BigDecimal	r25_9m_t_equalto_1y;
	private BigDecimal	r25_1y_t_equalto_1point5y;
	private BigDecimal	r25_1point5y_t_equalto_2y;
	private BigDecimal	r25_2y_t_equalto_3y;
	private BigDecimal	r25_3y_t_equalto_4y;
	private BigDecimal	r25_4y_lt_t_ltequalto_5y;
	private BigDecimal	r25_5y_lt_t_ltequalto_6y;
	private BigDecimal	r25_6y_lt_t_ltequalto_7y;
	private BigDecimal	r25_7y_lt_t_ltequalto_8y;
	private BigDecimal	r25_8y_lt_t_ltequalto_9y;
	private BigDecimal	r25_9y_lt_t_ltequalto_10y;
	private BigDecimal	r25_10y_lt_t_ltequalto_15y;
	private BigDecimal	r25_15y_lt_t_ltequalto_20y;
	private BigDecimal	r25_tl_20y;
	private BigDecimal	r25_nonsensitive;
	private BigDecimal	r25_total_rsl;
	private BigDecimal	r25_total;
	private String	r26_product;
	private BigDecimal	r26_tequalon;
	private BigDecimal	r26_on_t_equalto_1m;
	private BigDecimal	r26_1m_t_equalto_3m;
	private BigDecimal	r26_3m_t_equalto_6m;
	private BigDecimal	r26_6m_t_equalto_9m;
	private BigDecimal	r26_9m_t_equalto_1y;
	private BigDecimal	r26_1y_t_equalto_1point5y;
	private BigDecimal	r26_1point5y_t_equalto_2y;
	private BigDecimal	r26_2y_t_equalto_3y;
	private BigDecimal	r26_3y_t_equalto_4y;
	private BigDecimal	r26_4y_lt_t_ltequalto_5y;
	private BigDecimal	r26_5y_lt_t_ltequalto_6y;
	private BigDecimal	r26_6y_lt_t_ltequalto_7y;
	private BigDecimal	r26_7y_lt_t_ltequalto_8y;
	private BigDecimal	r26_8y_lt_t_ltequalto_9y;
	private BigDecimal	r26_9y_lt_t_ltequalto_10y;
	private BigDecimal	r26_10y_lt_t_ltequalto_15y;
	private BigDecimal	r26_15y_lt_t_ltequalto_20y;
	private BigDecimal	r26_tl_20y;
	private BigDecimal	r26_nonsensitive;
	private BigDecimal	r26_total_rsl;
	private BigDecimal	r26_total;
	private String	r27_product;
	private BigDecimal	r27_tequalon;
	private BigDecimal	r27_on_t_equalto_1m;
	private BigDecimal	r27_1m_t_equalto_3m;
	private BigDecimal	r27_3m_t_equalto_6m;
	private BigDecimal	r27_6m_t_equalto_9m;
	private BigDecimal	r27_9m_t_equalto_1y;
	private BigDecimal	r27_1y_t_equalto_1point5y;
	private BigDecimal	r27_1point5y_t_equalto_2y;
	private BigDecimal	r27_2y_t_equalto_3y;
	private BigDecimal	r27_3y_t_equalto_4y;
	private BigDecimal	r27_4y_lt_t_ltequalto_5y;
	private BigDecimal	r27_5y_lt_t_ltequalto_6y;
	private BigDecimal	r27_6y_lt_t_ltequalto_7y;
	private BigDecimal	r27_7y_lt_t_ltequalto_8y;
	private BigDecimal	r27_8y_lt_t_ltequalto_9y;
	private BigDecimal	r27_9y_lt_t_ltequalto_10y;
	private BigDecimal	r27_10y_lt_t_ltequalto_15y;
	private BigDecimal	r27_15y_lt_t_ltequalto_20y;
	private BigDecimal	r27_tl_20y;
	private BigDecimal	r27_nonsensitive;
	private BigDecimal	r27_total_rsl;
	private BigDecimal	r27_total;
	private String	r28_product;
	private BigDecimal	r28_tequalon;
	private BigDecimal	r28_on_t_equalto_1m;
	private BigDecimal	r28_1m_t_equalto_3m;
	private BigDecimal	r28_3m_t_equalto_6m;
	private BigDecimal	r28_6m_t_equalto_9m;
	private BigDecimal	r28_9m_t_equalto_1y;
	private BigDecimal	r28_1y_t_equalto_1point5y;
	private BigDecimal	r28_1point5y_t_equalto_2y;
	private BigDecimal	r28_2y_t_equalto_3y;
	private BigDecimal	r28_3y_t_equalto_4y;
	private BigDecimal	r28_4y_lt_t_ltequalto_5y;
	private BigDecimal	r28_5y_lt_t_ltequalto_6y;
	private BigDecimal	r28_6y_lt_t_ltequalto_7y;
	private BigDecimal	r28_7y_lt_t_ltequalto_8y;
	private BigDecimal	r28_8y_lt_t_ltequalto_9y;
	private BigDecimal	r28_9y_lt_t_ltequalto_10y;
	private BigDecimal	r28_10y_lt_t_ltequalto_15y;
	private BigDecimal	r28_15y_lt_t_ltequalto_20y;
	private BigDecimal	r28_tl_20y;
	private BigDecimal	r28_nonsensitive;
	private BigDecimal	r28_total_rsl;
	private BigDecimal	r28_total;
	private String	r29_product;
	private BigDecimal	r29_tequalon;
	private BigDecimal	r29_on_t_equalto_1m;
	private BigDecimal	r29_1m_t_equalto_3m;
	private BigDecimal	r29_3m_t_equalto_6m;
	private BigDecimal	r29_6m_t_equalto_9m;
	private BigDecimal	r29_9m_t_equalto_1y;
	private BigDecimal	r29_1y_t_equalto_1point5y;
	private BigDecimal	r29_1point5y_t_equalto_2y;
	private BigDecimal	r29_2y_t_equalto_3y;
	private BigDecimal	r29_3y_t_equalto_4y;
	private BigDecimal	r29_4y_lt_t_ltequalto_5y;
	private BigDecimal	r29_5y_lt_t_ltequalto_6y;
	private BigDecimal	r29_6y_lt_t_ltequalto_7y;
	private BigDecimal	r29_7y_lt_t_ltequalto_8y;
	private BigDecimal	r29_8y_lt_t_ltequalto_9y;
	private BigDecimal	r29_9y_lt_t_ltequalto_10y;
	private BigDecimal	r29_10y_lt_t_ltequalto_15y;
	private BigDecimal	r29_15y_lt_t_ltequalto_20y;
	private BigDecimal	r29_tl_20y;
	private BigDecimal	r29_nonsensitive;
	private BigDecimal	r29_total_rsl;
	private BigDecimal	r29_total;
	private String	r30_product;
	private BigDecimal	r30_tequalon;
	private BigDecimal	r30_on_t_equalto_1m;
	private BigDecimal	r30_1m_t_equalto_3m;
	private BigDecimal	r30_3m_t_equalto_6m;
	private BigDecimal	r30_6m_t_equalto_9m;
	private BigDecimal	r30_9m_t_equalto_1y;
	private BigDecimal	r30_1y_t_equalto_1point5y;
	private BigDecimal	r30_1point5y_t_equalto_2y;
	private BigDecimal	r30_2y_t_equalto_3y;
	private BigDecimal	r30_3y_t_equalto_4y;
	private BigDecimal	r30_4y_lt_t_ltequalto_5y;
	private BigDecimal	r30_5y_lt_t_ltequalto_6y;
	private BigDecimal	r30_6y_lt_t_ltequalto_7y;
	private BigDecimal	r30_7y_lt_t_ltequalto_8y;
	private BigDecimal	r30_8y_lt_t_ltequalto_9y;
	private BigDecimal	r30_9y_lt_t_ltequalto_10y;
	private BigDecimal	r30_10y_lt_t_ltequalto_15y;
	private BigDecimal	r30_15y_lt_t_ltequalto_20y;
	private BigDecimal	r30_tl_20y;
	private BigDecimal	r30_nonsensitive;
	private BigDecimal	r30_total_rsl;
	private BigDecimal	r30_total;
	private String	r31_product;
	private BigDecimal	r31_tequalon;
	private BigDecimal	r31_on_t_equalto_1m;
	private BigDecimal	r31_1m_t_equalto_3m;
	private BigDecimal	r31_3m_t_equalto_6m;
	private BigDecimal	r31_6m_t_equalto_9m;
	private BigDecimal	r31_9m_t_equalto_1y;
	private BigDecimal	r31_1y_t_equalto_1point5y;
	private BigDecimal	r31_1point5y_t_equalto_2y;
	private BigDecimal	r31_2y_t_equalto_3y;
	private BigDecimal	r31_3y_t_equalto_4y;
	private BigDecimal	r31_4y_lt_t_ltequalto_5y;
	private BigDecimal	r31_5y_lt_t_ltequalto_6y;
	private BigDecimal	r31_6y_lt_t_ltequalto_7y;
	private BigDecimal	r31_7y_lt_t_ltequalto_8y;
	private BigDecimal	r31_8y_lt_t_ltequalto_9y;
	private BigDecimal	r31_9y_lt_t_ltequalto_10y;
	private BigDecimal	r31_10y_lt_t_ltequalto_15y;
	private BigDecimal	r31_15y_lt_t_ltequalto_20y;
	private BigDecimal	r31_tl_20y;
	private BigDecimal	r31_nonsensitive;
	private BigDecimal	r31_total_rsl;
	private BigDecimal	r31_total;
	private String	r32_product;
	private BigDecimal	r32_tequalon;
	private BigDecimal	r32_on_t_equalto_1m;
	private BigDecimal	r32_1m_t_equalto_3m;
	private BigDecimal	r32_3m_t_equalto_6m;
	private BigDecimal	r32_6m_t_equalto_9m;
	private BigDecimal	r32_9m_t_equalto_1y;
	private BigDecimal	r32_1y_t_equalto_1point5y;
	private BigDecimal	r32_1point5y_t_equalto_2y;
	private BigDecimal	r32_2y_t_equalto_3y;
	private BigDecimal	r32_3y_t_equalto_4y;
	private BigDecimal	r32_4y_lt_t_ltequalto_5y;
	private BigDecimal	r32_5y_lt_t_ltequalto_6y;
	private BigDecimal	r32_6y_lt_t_ltequalto_7y;
	private BigDecimal	r32_7y_lt_t_ltequalto_8y;
	private BigDecimal	r32_8y_lt_t_ltequalto_9y;
	private BigDecimal	r32_9y_lt_t_ltequalto_10y;
	private BigDecimal	r32_10y_lt_t_ltequalto_15y;
	private BigDecimal	r32_15y_lt_t_ltequalto_20y;
	private BigDecimal	r32_tl_20y;
	private BigDecimal	r32_nonsensitive;
	private BigDecimal	r32_total_rsl;
	private BigDecimal	r32_total;
	private String	r33_product;
	private BigDecimal	r33_tequalon;
	private BigDecimal	r33_on_t_equalto_1m;
	private BigDecimal	r33_1m_t_equalto_3m;
	private BigDecimal	r33_3m_t_equalto_6m;
	private BigDecimal	r33_6m_t_equalto_9m;
	private BigDecimal	r33_9m_t_equalto_1y;
	private BigDecimal	r33_1y_t_equalto_1point5y;
	private BigDecimal	r33_1point5y_t_equalto_2y;
	private BigDecimal	r33_2y_t_equalto_3y;
	private BigDecimal	r33_3y_t_equalto_4y;
	private BigDecimal	r33_4y_lt_t_ltequalto_5y;
	private BigDecimal	r33_5y_lt_t_ltequalto_6y;
	private BigDecimal	r33_6y_lt_t_ltequalto_7y;
	private BigDecimal	r33_7y_lt_t_ltequalto_8y;
	private BigDecimal	r33_8y_lt_t_ltequalto_9y;
	private BigDecimal	r33_9y_lt_t_ltequalto_10y;
	private BigDecimal	r33_10y_lt_t_ltequalto_15y;
	private BigDecimal	r33_15y_lt_t_ltequalto_20y;
	private BigDecimal	r33_tl_20y;
	private BigDecimal	r33_nonsensitive;
	private BigDecimal	r33_total_rsl;
	private BigDecimal	r33_total;
	private String	r34_product;
	private BigDecimal	r34_tequalon;
	private BigDecimal	r34_on_t_equalto_1m;
	private BigDecimal	r34_1m_t_equalto_3m;
	private BigDecimal	r34_3m_t_equalto_6m;
	private BigDecimal	r34_6m_t_equalto_9m;
	private BigDecimal	r34_9m_t_equalto_1y;
	private BigDecimal	r34_1y_t_equalto_1point5y;
	private BigDecimal	r34_1point5y_t_equalto_2y;
	private BigDecimal	r34_2y_t_equalto_3y;
	private BigDecimal	r34_3y_t_equalto_4y;
	private BigDecimal	r34_4y_lt_t_ltequalto_5y;
	private BigDecimal	r34_5y_lt_t_ltequalto_6y;
	private BigDecimal	r34_6y_lt_t_ltequalto_7y;
	private BigDecimal	r34_7y_lt_t_ltequalto_8y;
	private BigDecimal	r34_8y_lt_t_ltequalto_9y;
	private BigDecimal	r34_9y_lt_t_ltequalto_10y;
	private BigDecimal	r34_10y_lt_t_ltequalto_15y;
	private BigDecimal	r34_15y_lt_t_ltequalto_20y;
	private BigDecimal	r34_tl_20y;
	private BigDecimal	r34_nonsensitive;
	private BigDecimal	r34_total_rsl;
	private BigDecimal	r34_total;
	private String	r35_product;
	private BigDecimal	r35_tequalon;
	private BigDecimal	r35_on_t_equalto_1m;
	private BigDecimal	r35_1m_t_equalto_3m;
	private BigDecimal	r35_3m_t_equalto_6m;
	private BigDecimal	r35_6m_t_equalto_9m;
	private BigDecimal	r35_9m_t_equalto_1y;
	private BigDecimal	r35_1y_t_equalto_1point5y;
	private BigDecimal	r35_1point5y_t_equalto_2y;
	private BigDecimal	r35_2y_t_equalto_3y;
	private BigDecimal	r35_3y_t_equalto_4y;
	private BigDecimal	r35_4y_lt_t_ltequalto_5y;
	private BigDecimal	r35_5y_lt_t_ltequalto_6y;
	private BigDecimal	r35_6y_lt_t_ltequalto_7y;
	private BigDecimal	r35_7y_lt_t_ltequalto_8y;
	private BigDecimal	r35_8y_lt_t_ltequalto_9y;
	private BigDecimal	r35_9y_lt_t_ltequalto_10y;
	private BigDecimal	r35_10y_lt_t_ltequalto_15y;
	private BigDecimal	r35_15y_lt_t_ltequalto_20y;
	private BigDecimal	r35_tl_20y;
	private BigDecimal	r35_nonsensitive;
	private BigDecimal	r35_total_rsl;
	private BigDecimal	r35_total;
	private String	r36_product;
	private BigDecimal	r36_tequalon;
	private BigDecimal	r36_on_t_equalto_1m;
	private BigDecimal	r36_1m_t_equalto_3m;
	private BigDecimal	r36_3m_t_equalto_6m;
	private BigDecimal	r36_6m_t_equalto_9m;
	private BigDecimal	r36_9m_t_equalto_1y;
	private BigDecimal	r36_1y_t_equalto_1point5y;
	private BigDecimal	r36_1point5y_t_equalto_2y;
	private BigDecimal	r36_2y_t_equalto_3y;
	private BigDecimal	r36_3y_t_equalto_4y;
	private BigDecimal	r36_4y_lt_t_ltequalto_5y;
	private BigDecimal	r36_5y_lt_t_ltequalto_6y;
	private BigDecimal	r36_6y_lt_t_ltequalto_7y;
	private BigDecimal	r36_7y_lt_t_ltequalto_8y;
	private BigDecimal	r36_8y_lt_t_ltequalto_9y;
	private BigDecimal	r36_9y_lt_t_ltequalto_10y;
	private BigDecimal	r36_10y_lt_t_ltequalto_15y;
	private BigDecimal	r36_15y_lt_t_ltequalto_20y;
	private BigDecimal	r36_tl_20y;
	private BigDecimal	r36_nonsensitive;
	private BigDecimal	r36_total_rsl;
	private BigDecimal	r36_total;
	private String	r37_product;
	private BigDecimal	r37_tequalon;
	private BigDecimal	r37_on_t_equalto_1m;
	private BigDecimal	r37_1m_t_equalto_3m;
	private BigDecimal	r37_3m_t_equalto_6m;
	private BigDecimal	r37_6m_t_equalto_9m;
	private BigDecimal	r37_9m_t_equalto_1y;
	private BigDecimal	r37_1y_t_equalto_1point5y;
	private BigDecimal	r37_1point5y_t_equalto_2y;
	private BigDecimal	r37_2y_t_equalto_3y;
	private BigDecimal	r37_3y_t_equalto_4y;
	private BigDecimal	r37_4y_lt_t_ltequalto_5y;
	private BigDecimal	r37_5y_lt_t_ltequalto_6y;
	private BigDecimal	r37_6y_lt_t_ltequalto_7y;
	private BigDecimal	r37_7y_lt_t_ltequalto_8y;
	private BigDecimal	r37_8y_lt_t_ltequalto_9y;
	private BigDecimal	r37_9y_lt_t_ltequalto_10y;
	private BigDecimal	r37_10y_lt_t_ltequalto_15y;
	private BigDecimal	r37_15y_lt_t_ltequalto_20y;
	private BigDecimal	r37_tl_20y;
	private BigDecimal	r37_nonsensitive;
	private BigDecimal	r37_total_rsl;
	private BigDecimal	r37_total;
	private String	r38_product;
	private BigDecimal	r38_tequalon;
	private BigDecimal	r38_on_t_equalto_1m;
	private BigDecimal	r38_1m_t_equalto_3m;
	private BigDecimal	r38_3m_t_equalto_6m;
	private BigDecimal	r38_6m_t_equalto_9m;
	private BigDecimal	r38_9m_t_equalto_1y;
	private BigDecimal	r38_1y_t_equalto_1point5y;
	private BigDecimal	r38_1point5y_t_equalto_2y;
	private BigDecimal	r38_2y_t_equalto_3y;
	private BigDecimal	r38_3y_t_equalto_4y;
	private BigDecimal	r38_4y_lt_t_ltequalto_5y;
	private BigDecimal	r38_5y_lt_t_ltequalto_6y;
	private BigDecimal	r38_6y_lt_t_ltequalto_7y;
	private BigDecimal	r38_7y_lt_t_ltequalto_8y;
	private BigDecimal	r38_8y_lt_t_ltequalto_9y;
	private BigDecimal	r38_9y_lt_t_ltequalto_10y;
	private BigDecimal	r38_10y_lt_t_ltequalto_15y;
	private BigDecimal	r38_15y_lt_t_ltequalto_20y;
	private BigDecimal	r38_tl_20y;
	private BigDecimal	r38_nonsensitive;
	private BigDecimal	r38_total_rsl;
	private BigDecimal	r38_total;
	private String	r39_product;
	private BigDecimal	r39_tequalon;
	private BigDecimal	r39_on_t_equalto_1m;
	private BigDecimal	r39_1m_t_equalto_3m;
	private BigDecimal	r39_3m_t_equalto_6m;
	private BigDecimal	r39_6m_t_equalto_9m;
	private BigDecimal	r39_9m_t_equalto_1y;
	private BigDecimal	r39_1y_t_equalto_1point5y;
	private BigDecimal	r39_1point5y_t_equalto_2y;
	private BigDecimal	r39_2y_t_equalto_3y;
	private BigDecimal	r39_3y_t_equalto_4y;
	private BigDecimal	r39_4y_lt_t_ltequalto_5y;
	private BigDecimal	r39_5y_lt_t_ltequalto_6y;
	private BigDecimal	r39_6y_lt_t_ltequalto_7y;
	private BigDecimal	r39_7y_lt_t_ltequalto_8y;
	private BigDecimal	r39_8y_lt_t_ltequalto_9y;
	private BigDecimal	r39_9y_lt_t_ltequalto_10y;
	private BigDecimal	r39_10y_lt_t_ltequalto_15y;
	private BigDecimal	r39_15y_lt_t_ltequalto_20y;
	private BigDecimal	r39_tl_20y;
	private BigDecimal	r39_nonsensitive;
	private BigDecimal	r39_total_rsl;
	private BigDecimal	r39_total;
	private String	r40_product;
	private BigDecimal	r40_tequalon;
	private BigDecimal	r40_on_t_equalto_1m;
	private BigDecimal	r40_1m_t_equalto_3m;
	private BigDecimal	r40_3m_t_equalto_6m;
	private BigDecimal	r40_6m_t_equalto_9m;
	private BigDecimal	r40_9m_t_equalto_1y;
	private BigDecimal	r40_1y_t_equalto_1point5y;
	private BigDecimal	r40_1point5y_t_equalto_2y;
	private BigDecimal	r40_2y_t_equalto_3y;
	private BigDecimal	r40_3y_t_equalto_4y;
	private BigDecimal	r40_4y_lt_t_ltequalto_5y;
	private BigDecimal	r40_5y_lt_t_ltequalto_6y;
	private BigDecimal	r40_6y_lt_t_ltequalto_7y;
	private BigDecimal	r40_7y_lt_t_ltequalto_8y;
	private BigDecimal	r40_8y_lt_t_ltequalto_9y;
	private BigDecimal	r40_9y_lt_t_ltequalto_10y;
	private BigDecimal	r40_10y_lt_t_ltequalto_15y;
	private BigDecimal	r40_15y_lt_t_ltequalto_20y;
	private BigDecimal	r40_tl_20y;
	private BigDecimal	r40_nonsensitive;
	private BigDecimal	r40_total_rsl;
	private BigDecimal	r40_total;
	private String	r41_product;
	private BigDecimal	r41_tequalon;
	private BigDecimal	r41_on_t_equalto_1m;
	private BigDecimal	r41_1m_t_equalto_3m;
	private BigDecimal	r41_3m_t_equalto_6m;
	private BigDecimal	r41_6m_t_equalto_9m;
	private BigDecimal	r41_9m_t_equalto_1y;
	private BigDecimal	r41_1y_t_equalto_1point5y;
	private BigDecimal	r41_1point5y_t_equalto_2y;
	private BigDecimal	r41_2y_t_equalto_3y;
	private BigDecimal	r41_3y_t_equalto_4y;
	private BigDecimal	r41_4y_lt_t_ltequalto_5y;
	private BigDecimal	r41_5y_lt_t_ltequalto_6y;
	private BigDecimal	r41_6y_lt_t_ltequalto_7y;
	private BigDecimal	r41_7y_lt_t_ltequalto_8y;
	private BigDecimal	r41_8y_lt_t_ltequalto_9y;
	private BigDecimal	r41_9y_lt_t_ltequalto_10y;
	private BigDecimal	r41_10y_lt_t_ltequalto_15y;
	private BigDecimal	r41_15y_lt_t_ltequalto_20y;
	private BigDecimal	r41_tl_20y;
	private BigDecimal	r41_nonsensitive;
	private BigDecimal	r41_total_rsl;
	private BigDecimal	r41_total;
	private String	r42_product;
	private BigDecimal	r42_tequalon;
	private BigDecimal	r42_on_t_equalto_1m;
	private BigDecimal	r42_1m_t_equalto_3m;
	private BigDecimal	r42_3m_t_equalto_6m;
	private BigDecimal	r42_6m_t_equalto_9m;
	private BigDecimal	r42_9m_t_equalto_1y;
	private BigDecimal	r42_1y_t_equalto_1point5y;
	private BigDecimal	r42_1point5y_t_equalto_2y;
	private BigDecimal	r42_2y_t_equalto_3y;
	private BigDecimal	r42_3y_t_equalto_4y;
	private BigDecimal	r42_4y_lt_t_ltequalto_5y;
	private BigDecimal	r42_5y_lt_t_ltequalto_6y;
	private BigDecimal	r42_6y_lt_t_ltequalto_7y;
	private BigDecimal	r42_7y_lt_t_ltequalto_8y;
	private BigDecimal	r42_8y_lt_t_ltequalto_9y;
	private BigDecimal	r42_9y_lt_t_ltequalto_10y;
	private BigDecimal	r42_10y_lt_t_ltequalto_15y;
	private BigDecimal	r42_15y_lt_t_ltequalto_20y;
	private BigDecimal	r42_tl_20y;
	private BigDecimal	r42_nonsensitive;
	private BigDecimal	r42_total_rsl;
	private BigDecimal	r42_total;
	private String	r43_product;
	private BigDecimal	r43_tequalon;
	private BigDecimal	r43_on_t_equalto_1m;
	private BigDecimal	r43_1m_t_equalto_3m;
	private BigDecimal	r43_3m_t_equalto_6m;
	private BigDecimal	r43_6m_t_equalto_9m;
	private BigDecimal	r43_9m_t_equalto_1y;
	private BigDecimal	r43_1y_t_equalto_1point5y;
	private BigDecimal	r43_1point5y_t_equalto_2y;
	private BigDecimal	r43_2y_t_equalto_3y;
	private BigDecimal	r43_3y_t_equalto_4y;
	private BigDecimal	r43_4y_lt_t_ltequalto_5y;
	private BigDecimal	r43_5y_lt_t_ltequalto_6y;
	private BigDecimal	r43_6y_lt_t_ltequalto_7y;
	private BigDecimal	r43_7y_lt_t_ltequalto_8y;
	private BigDecimal	r43_8y_lt_t_ltequalto_9y;
	private BigDecimal	r43_9y_lt_t_ltequalto_10y;
	private BigDecimal	r43_10y_lt_t_ltequalto_15y;
	private BigDecimal	r43_15y_lt_t_ltequalto_20y;
	private BigDecimal	r43_tl_20y;
	private BigDecimal	r43_nonsensitive;
	private BigDecimal	r43_total_rsl;
	private BigDecimal	r43_total;
	private String	r44_product;
	private BigDecimal	r44_tequalon;
	private BigDecimal	r44_on_t_equalto_1m;
	private BigDecimal	r44_1m_t_equalto_3m;
	private BigDecimal	r44_3m_t_equalto_6m;
	private BigDecimal	r44_6m_t_equalto_9m;
	private BigDecimal	r44_9m_t_equalto_1y;
	private BigDecimal	r44_1y_t_equalto_1point5y;
	private BigDecimal	r44_1point5y_t_equalto_2y;
	private BigDecimal	r44_2y_t_equalto_3y;
	private BigDecimal	r44_3y_t_equalto_4y;
	private BigDecimal	r44_4y_lt_t_ltequalto_5y;
	private BigDecimal	r44_5y_lt_t_ltequalto_6y;
	private BigDecimal	r44_6y_lt_t_ltequalto_7y;
	private BigDecimal	r44_7y_lt_t_ltequalto_8y;
	private BigDecimal	r44_8y_lt_t_ltequalto_9y;
	private BigDecimal	r44_9y_lt_t_ltequalto_10y;
	private BigDecimal	r44_10y_lt_t_ltequalto_15y;
	private BigDecimal	r44_15y_lt_t_ltequalto_20y;
	private BigDecimal	r44_tl_20y;
	private BigDecimal	r44_nonsensitive;
	private BigDecimal	r44_total_rsl;
	private BigDecimal	r44_total;
	private String	r45_product;
	private BigDecimal	r45_tequalon;
	private BigDecimal	r45_on_t_equalto_1m;
	private BigDecimal	r45_1m_t_equalto_3m;
	private BigDecimal	r45_3m_t_equalto_6m;
	private BigDecimal	r45_6m_t_equalto_9m;
	private BigDecimal	r45_9m_t_equalto_1y;
	private BigDecimal	r45_1y_t_equalto_1point5y;
	private BigDecimal	r45_1point5y_t_equalto_2y;
	private BigDecimal	r45_2y_t_equalto_3y;
	private BigDecimal	r45_3y_t_equalto_4y;
	private BigDecimal	r45_4y_lt_t_ltequalto_5y;
	private BigDecimal	r45_5y_lt_t_ltequalto_6y;
	private BigDecimal	r45_6y_lt_t_ltequalto_7y;
	private BigDecimal	r45_7y_lt_t_ltequalto_8y;
	private BigDecimal	r45_8y_lt_t_ltequalto_9y;
	private BigDecimal	r45_9y_lt_t_ltequalto_10y;
	private BigDecimal	r45_10y_lt_t_ltequalto_15y;
	private BigDecimal	r45_15y_lt_t_ltequalto_20y;
	private BigDecimal	r45_tl_20y;
	private BigDecimal	r45_nonsensitive;
	private BigDecimal	r45_total_rsl;
	private BigDecimal	r45_total;
	private String	r46_product;
	private BigDecimal	r46_tequalon;
	private BigDecimal	r46_on_t_equalto_1m;
	private BigDecimal	r46_1m_t_equalto_3m;
	private BigDecimal	r46_3m_t_equalto_6m;
	private BigDecimal	r46_6m_t_equalto_9m;
	private BigDecimal	r46_9m_t_equalto_1y;
	private BigDecimal	r46_1y_t_equalto_1point5y;
	private BigDecimal	r46_1point5y_t_equalto_2y;
	private BigDecimal	r46_2y_t_equalto_3y;
	private BigDecimal	r46_3y_t_equalto_4y;
	private BigDecimal	r46_4y_lt_t_ltequalto_5y;
	private BigDecimal	r46_5y_lt_t_ltequalto_6y;
	private BigDecimal	r46_6y_lt_t_ltequalto_7y;
	private BigDecimal	r46_7y_lt_t_ltequalto_8y;
	private BigDecimal	r46_8y_lt_t_ltequalto_9y;
	private BigDecimal	r46_9y_lt_t_ltequalto_10y;
	private BigDecimal	r46_10y_lt_t_ltequalto_15y;
	private BigDecimal	r46_15y_lt_t_ltequalto_20y;
	private BigDecimal	r46_tl_20y;
	private BigDecimal	r46_nonsensitive;
	private BigDecimal	r46_total_rsl;
	private BigDecimal	r46_total;
	private String	r47_product;
	private BigDecimal	r47_tequalon;
	private BigDecimal	r47_on_t_equalto_1m;
	private BigDecimal	r47_1m_t_equalto_3m;
	private BigDecimal	r47_3m_t_equalto_6m;
	private BigDecimal	r47_6m_t_equalto_9m;
	private BigDecimal	r47_9m_t_equalto_1y;
	private BigDecimal	r47_1y_t_equalto_1point5y;
	private BigDecimal	r47_1point5y_t_equalto_2y;
	private BigDecimal	r47_2y_t_equalto_3y;
	private BigDecimal	r47_3y_t_equalto_4y;
	private BigDecimal	r47_4y_lt_t_ltequalto_5y;
	private BigDecimal	r47_5y_lt_t_ltequalto_6y;
	private BigDecimal	r47_6y_lt_t_ltequalto_7y;
	private BigDecimal	r47_7y_lt_t_ltequalto_8y;
	private BigDecimal	r47_8y_lt_t_ltequalto_9y;
	private BigDecimal	r47_9y_lt_t_ltequalto_10y;
	private BigDecimal	r47_10y_lt_t_ltequalto_15y;
	private BigDecimal	r47_15y_lt_t_ltequalto_20y;
	private BigDecimal	r47_tl_20y;
	private BigDecimal	r47_nonsensitive;
	private BigDecimal	r47_total_rsl;
	private BigDecimal	r47_total;
	private String	r48_product;
	private BigDecimal	r48_tequalon;
	private BigDecimal	r48_on_t_equalto_1m;
	private BigDecimal	r48_1m_t_equalto_3m;
	private BigDecimal	r48_3m_t_equalto_6m;
	private BigDecimal	r48_6m_t_equalto_9m;
	private BigDecimal	r48_9m_t_equalto_1y;
	private BigDecimal	r48_1y_t_equalto_1point5y;
	private BigDecimal	r48_1point5y_t_equalto_2y;
	private BigDecimal	r48_2y_t_equalto_3y;
	private BigDecimal	r48_3y_t_equalto_4y;
	private BigDecimal	r48_4y_lt_t_ltequalto_5y;
	private BigDecimal	r48_5y_lt_t_ltequalto_6y;
	private BigDecimal	r48_6y_lt_t_ltequalto_7y;
	private BigDecimal	r48_7y_lt_t_ltequalto_8y;
	private BigDecimal	r48_8y_lt_t_ltequalto_9y;
	private BigDecimal	r48_9y_lt_t_ltequalto_10y;
	private BigDecimal	r48_10y_lt_t_ltequalto_15y;
	private BigDecimal	r48_15y_lt_t_ltequalto_20y;
	private BigDecimal	r48_tl_20y;
	private BigDecimal	r48_nonsensitive;
	private BigDecimal	r48_total_rsl;
	private BigDecimal	r48_total;
	private String	r49_product;
	private BigDecimal	r49_tequalon;
	private BigDecimal	r49_on_t_equalto_1m;
	private BigDecimal	r49_1m_t_equalto_3m;
	private BigDecimal	r49_3m_t_equalto_6m;
	private BigDecimal	r49_6m_t_equalto_9m;
	private BigDecimal	r49_9m_t_equalto_1y;
	private BigDecimal	r49_1y_t_equalto_1point5y;
	private BigDecimal	r49_1point5y_t_equalto_2y;
	private BigDecimal	r49_2y_t_equalto_3y;
	private BigDecimal	r49_3y_t_equalto_4y;
	private BigDecimal	r49_4y_lt_t_ltequalto_5y;
	private BigDecimal	r49_5y_lt_t_ltequalto_6y;
	private BigDecimal	r49_6y_lt_t_ltequalto_7y;
	private BigDecimal	r49_7y_lt_t_ltequalto_8y;
	private BigDecimal	r49_8y_lt_t_ltequalto_9y;
	private BigDecimal	r49_9y_lt_t_ltequalto_10y;
	private BigDecimal	r49_10y_lt_t_ltequalto_15y;
	private BigDecimal	r49_15y_lt_t_ltequalto_20y;
	private BigDecimal	r49_tl_20y;
	private BigDecimal	r49_nonsensitive;
	private BigDecimal	r49_total_rsl;
	private BigDecimal	r49_total;
		
		@Id
		@Temporal(TemporalType.DATE)
		@DateTimeFormat(pattern = "dd-MM-yyyy")
		private Date	report_date;

		private Date	report_from_date;
		private Date	report_to_date;
		private BigDecimal	entity_flg;
		private BigDecimal	modify_flg;
		private BigDecimal	del_flg;
		private BigDecimal	report_code;
		private Date	report_submit_date;
		public String getR7_product() {
			return r7_product;
		}
		public void setR7_product(String r7_product) {
			this.r7_product = r7_product;
		}
		public BigDecimal getR7_tequalon() {
			return r7_tequalon;
		}
		public void setR7_tequalon(BigDecimal r7_tequalon) {
			this.r7_tequalon = r7_tequalon;
		}
		public BigDecimal getR7_on_t_equalto_1m() {
			return r7_on_t_equalto_1m;
		}
		public void setR7_on_t_equalto_1m(BigDecimal r7_on_t_equalto_1m) {
			this.r7_on_t_equalto_1m = r7_on_t_equalto_1m;
		}
		public BigDecimal getR7_1m_t_equalto_3m() {
			return r7_1m_t_equalto_3m;
		}
		public void setR7_1m_t_equalto_3m(BigDecimal r7_1m_t_equalto_3m) {
			this.r7_1m_t_equalto_3m = r7_1m_t_equalto_3m;
		}
		public BigDecimal getR7_3m_t_equalto_6m() {
			return r7_3m_t_equalto_6m;
		}
		public void setR7_3m_t_equalto_6m(BigDecimal r7_3m_t_equalto_6m) {
			this.r7_3m_t_equalto_6m = r7_3m_t_equalto_6m;
		}
		public BigDecimal getR7_6m_t_equalto_9m() {
			return r7_6m_t_equalto_9m;
		}
		public void setR7_6m_t_equalto_9m(BigDecimal r7_6m_t_equalto_9m) {
			this.r7_6m_t_equalto_9m = r7_6m_t_equalto_9m;
		}
		public BigDecimal getR7_9m_t_equalto_1y() {
			return r7_9m_t_equalto_1y;
		}
		public void setR7_9m_t_equalto_1y(BigDecimal r7_9m_t_equalto_1y) {
			this.r7_9m_t_equalto_1y = r7_9m_t_equalto_1y;
		}
		public BigDecimal getR7_1y_t_equalto_1point5y() {
			return r7_1y_t_equalto_1point5y;
		}
		public void setR7_1y_t_equalto_1point5y(BigDecimal r7_1y_t_equalto_1point5y) {
			this.r7_1y_t_equalto_1point5y = r7_1y_t_equalto_1point5y;
		}
		public BigDecimal getR7_1point5y_t_equalto_2y() {
			return r7_1point5y_t_equalto_2y;
		}
		public void setR7_1point5y_t_equalto_2y(BigDecimal r7_1point5y_t_equalto_2y) {
			this.r7_1point5y_t_equalto_2y = r7_1point5y_t_equalto_2y;
		}
		public BigDecimal getR7_2y_t_equalto_3y() {
			return r7_2y_t_equalto_3y;
		}
		public void setR7_2y_t_equalto_3y(BigDecimal r7_2y_t_equalto_3y) {
			this.r7_2y_t_equalto_3y = r7_2y_t_equalto_3y;
		}
		public BigDecimal getR7_3y_t_equalto_4y() {
			return r7_3y_t_equalto_4y;
		}
		public void setR7_3y_t_equalto_4y(BigDecimal r7_3y_t_equalto_4y) {
			this.r7_3y_t_equalto_4y = r7_3y_t_equalto_4y;
		}
		public BigDecimal getR7_4y_lt_t_ltequalto_5y() {
			return r7_4y_lt_t_ltequalto_5y;
		}
		public void setR7_4y_lt_t_ltequalto_5y(BigDecimal r7_4y_lt_t_ltequalto_5y) {
			this.r7_4y_lt_t_ltequalto_5y = r7_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR7_5y_lt_t_ltequalto_6y() {
			return r7_5y_lt_t_ltequalto_6y;
		}
		public void setR7_5y_lt_t_ltequalto_6y(BigDecimal r7_5y_lt_t_ltequalto_6y) {
			this.r7_5y_lt_t_ltequalto_6y = r7_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR7_6y_lt_t_ltequalto_7y() {
			return r7_6y_lt_t_ltequalto_7y;
		}
		public void setR7_6y_lt_t_ltequalto_7y(BigDecimal r7_6y_lt_t_ltequalto_7y) {
			this.r7_6y_lt_t_ltequalto_7y = r7_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR7_7y_lt_t_ltequalto_8y() {
			return r7_7y_lt_t_ltequalto_8y;
		}
		public void setR7_7y_lt_t_ltequalto_8y(BigDecimal r7_7y_lt_t_ltequalto_8y) {
			this.r7_7y_lt_t_ltequalto_8y = r7_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR7_8y_lt_t_ltequalto_9y() {
			return r7_8y_lt_t_ltequalto_9y;
		}
		public void setR7_8y_lt_t_ltequalto_9y(BigDecimal r7_8y_lt_t_ltequalto_9y) {
			this.r7_8y_lt_t_ltequalto_9y = r7_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR7_9y_lt_t_ltequalto_10y() {
			return r7_9y_lt_t_ltequalto_10y;
		}
		public void setR7_9y_lt_t_ltequalto_10y(BigDecimal r7_9y_lt_t_ltequalto_10y) {
			this.r7_9y_lt_t_ltequalto_10y = r7_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR7_10y_lt_t_ltequalto_15y() {
			return r7_10y_lt_t_ltequalto_15y;
		}
		public void setR7_10y_lt_t_ltequalto_15y(BigDecimal r7_10y_lt_t_ltequalto_15y) {
			this.r7_10y_lt_t_ltequalto_15y = r7_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR7_15y_lt_t_ltequalto_20y() {
			return r7_15y_lt_t_ltequalto_20y;
		}
		public void setR7_15y_lt_t_ltequalto_20y(BigDecimal r7_15y_lt_t_ltequalto_20y) {
			this.r7_15y_lt_t_ltequalto_20y = r7_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR7_tl_20y() {
			return r7_tl_20y;
		}
		public void setR7_tl_20y(BigDecimal r7_tl_20y) {
			this.r7_tl_20y = r7_tl_20y;
		}
		public BigDecimal getR7_nonsensitive() {
			return r7_nonsensitive;
		}
		public void setR7_nonsensitive(BigDecimal r7_nonsensitive) {
			this.r7_nonsensitive = r7_nonsensitive;
		}
		public BigDecimal getR7_total_rsl() {
			return r7_total_rsl;
		}
		public void setR7_total_rsl(BigDecimal r7_total_rsl) {
			this.r7_total_rsl = r7_total_rsl;
		}
		public BigDecimal getR7_total() {
			return r7_total;
		}
		public void setR7_total(BigDecimal r7_total) {
			this.r7_total = r7_total;
		}
		public String getR8_product() {
			return r8_product;
		}
		public void setR8_product(String r8_product) {
			this.r8_product = r8_product;
		}
		public BigDecimal getR8_tequalon() {
			return r8_tequalon;
		}
		public void setR8_tequalon(BigDecimal r8_tequalon) {
			this.r8_tequalon = r8_tequalon;
		}
		public BigDecimal getR8_on_t_equalto_1m() {
			return r8_on_t_equalto_1m;
		}
		public void setR8_on_t_equalto_1m(BigDecimal r8_on_t_equalto_1m) {
			this.r8_on_t_equalto_1m = r8_on_t_equalto_1m;
		}
		public BigDecimal getR8_1m_t_equalto_3m() {
			return r8_1m_t_equalto_3m;
		}
		public void setR8_1m_t_equalto_3m(BigDecimal r8_1m_t_equalto_3m) {
			this.r8_1m_t_equalto_3m = r8_1m_t_equalto_3m;
		}
		public BigDecimal getR8_3m_t_equalto_6m() {
			return r8_3m_t_equalto_6m;
		}
		public void setR8_3m_t_equalto_6m(BigDecimal r8_3m_t_equalto_6m) {
			this.r8_3m_t_equalto_6m = r8_3m_t_equalto_6m;
		}
		public BigDecimal getR8_6m_t_equalto_9m() {
			return r8_6m_t_equalto_9m;
		}
		public void setR8_6m_t_equalto_9m(BigDecimal r8_6m_t_equalto_9m) {
			this.r8_6m_t_equalto_9m = r8_6m_t_equalto_9m;
		}
		public BigDecimal getR8_9m_t_equalto_1y() {
			return r8_9m_t_equalto_1y;
		}
		public void setR8_9m_t_equalto_1y(BigDecimal r8_9m_t_equalto_1y) {
			this.r8_9m_t_equalto_1y = r8_9m_t_equalto_1y;
		}
		public BigDecimal getR8_1y_t_equalto_1point5y() {
			return r8_1y_t_equalto_1point5y;
		}
		public void setR8_1y_t_equalto_1point5y(BigDecimal r8_1y_t_equalto_1point5y) {
			this.r8_1y_t_equalto_1point5y = r8_1y_t_equalto_1point5y;
		}
		public BigDecimal getR8_1point5y_t_equalto_2y() {
			return r8_1point5y_t_equalto_2y;
		}
		public void setR8_1point5y_t_equalto_2y(BigDecimal r8_1point5y_t_equalto_2y) {
			this.r8_1point5y_t_equalto_2y = r8_1point5y_t_equalto_2y;
		}
		public BigDecimal getR8_2y_t_equalto_3y() {
			return r8_2y_t_equalto_3y;
		}
		public void setR8_2y_t_equalto_3y(BigDecimal r8_2y_t_equalto_3y) {
			this.r8_2y_t_equalto_3y = r8_2y_t_equalto_3y;
		}
		public BigDecimal getR8_3y_t_equalto_4y() {
			return r8_3y_t_equalto_4y;
		}
		public void setR8_3y_t_equalto_4y(BigDecimal r8_3y_t_equalto_4y) {
			this.r8_3y_t_equalto_4y = r8_3y_t_equalto_4y;
		}
		public BigDecimal getR8_4y_lt_t_ltequalto_5y() {
			return r8_4y_lt_t_ltequalto_5y;
		}
		public void setR8_4y_lt_t_ltequalto_5y(BigDecimal r8_4y_lt_t_ltequalto_5y) {
			this.r8_4y_lt_t_ltequalto_5y = r8_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR8_5y_lt_t_ltequalto_6y() {
			return r8_5y_lt_t_ltequalto_6y;
		}
		public void setR8_5y_lt_t_ltequalto_6y(BigDecimal r8_5y_lt_t_ltequalto_6y) {
			this.r8_5y_lt_t_ltequalto_6y = r8_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR8_6y_lt_t_ltequalto_7y() {
			return r8_6y_lt_t_ltequalto_7y;
		}
		public void setR8_6y_lt_t_ltequalto_7y(BigDecimal r8_6y_lt_t_ltequalto_7y) {
			this.r8_6y_lt_t_ltequalto_7y = r8_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR8_7y_lt_t_ltequalto_8y() {
			return r8_7y_lt_t_ltequalto_8y;
		}
		public void setR8_7y_lt_t_ltequalto_8y(BigDecimal r8_7y_lt_t_ltequalto_8y) {
			this.r8_7y_lt_t_ltequalto_8y = r8_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR8_8y_lt_t_ltequalto_9y() {
			return r8_8y_lt_t_ltequalto_9y;
		}
		public void setR8_8y_lt_t_ltequalto_9y(BigDecimal r8_8y_lt_t_ltequalto_9y) {
			this.r8_8y_lt_t_ltequalto_9y = r8_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR8_9y_lt_t_ltequalto_10y() {
			return r8_9y_lt_t_ltequalto_10y;
		}
		public void setR8_9y_lt_t_ltequalto_10y(BigDecimal r8_9y_lt_t_ltequalto_10y) {
			this.r8_9y_lt_t_ltequalto_10y = r8_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR8_10y_lt_t_ltequalto_15y() {
			return r8_10y_lt_t_ltequalto_15y;
		}
		public void setR8_10y_lt_t_ltequalto_15y(BigDecimal r8_10y_lt_t_ltequalto_15y) {
			this.r8_10y_lt_t_ltequalto_15y = r8_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR8_15y_lt_t_ltequalto_20y() {
			return r8_15y_lt_t_ltequalto_20y;
		}
		public void setR8_15y_lt_t_ltequalto_20y(BigDecimal r8_15y_lt_t_ltequalto_20y) {
			this.r8_15y_lt_t_ltequalto_20y = r8_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR8_tl_20y() {
			return r8_tl_20y;
		}
		public void setR8_tl_20y(BigDecimal r8_tl_20y) {
			this.r8_tl_20y = r8_tl_20y;
		}
		public BigDecimal getR8_nonsensitive() {
			return r8_nonsensitive;
		}
		public void setR8_nonsensitive(BigDecimal r8_nonsensitive) {
			this.r8_nonsensitive = r8_nonsensitive;
		}
		public BigDecimal getR8_total_rsl() {
			return r8_total_rsl;
		}
		public void setR8_total_rsl(BigDecimal r8_total_rsl) {
			this.r8_total_rsl = r8_total_rsl;
		}
		public BigDecimal getR8_total() {
			return r8_total;
		}
		public void setR8_total(BigDecimal r8_total) {
			this.r8_total = r8_total;
		}
		public String getR9_product() {
			return r9_product;
		}
		public void setR9_product(String r9_product) {
			this.r9_product = r9_product;
		}
		public BigDecimal getR9_tequalon() {
			return r9_tequalon;
		}
		public void setR9_tequalon(BigDecimal r9_tequalon) {
			this.r9_tequalon = r9_tequalon;
		}
		public BigDecimal getR9_on_t_equalto_1m() {
			return r9_on_t_equalto_1m;
		}
		public void setR9_on_t_equalto_1m(BigDecimal r9_on_t_equalto_1m) {
			this.r9_on_t_equalto_1m = r9_on_t_equalto_1m;
		}
		public BigDecimal getR9_1m_t_equalto_3m() {
			return r9_1m_t_equalto_3m;
		}
		public void setR9_1m_t_equalto_3m(BigDecimal r9_1m_t_equalto_3m) {
			this.r9_1m_t_equalto_3m = r9_1m_t_equalto_3m;
		}
		public BigDecimal getR9_3m_t_equalto_6m() {
			return r9_3m_t_equalto_6m;
		}
		public void setR9_3m_t_equalto_6m(BigDecimal r9_3m_t_equalto_6m) {
			this.r9_3m_t_equalto_6m = r9_3m_t_equalto_6m;
		}
		public BigDecimal getR9_6m_t_equalto_9m() {
			return r9_6m_t_equalto_9m;
		}
		public void setR9_6m_t_equalto_9m(BigDecimal r9_6m_t_equalto_9m) {
			this.r9_6m_t_equalto_9m = r9_6m_t_equalto_9m;
		}
		public BigDecimal getR9_9m_t_equalto_1y() {
			return r9_9m_t_equalto_1y;
		}
		public void setR9_9m_t_equalto_1y(BigDecimal r9_9m_t_equalto_1y) {
			this.r9_9m_t_equalto_1y = r9_9m_t_equalto_1y;
		}
		public BigDecimal getR9_1y_t_equalto_1point5y() {
			return r9_1y_t_equalto_1point5y;
		}
		public void setR9_1y_t_equalto_1point5y(BigDecimal r9_1y_t_equalto_1point5y) {
			this.r9_1y_t_equalto_1point5y = r9_1y_t_equalto_1point5y;
		}
		public BigDecimal getR9_1point5y_t_equalto_2y() {
			return r9_1point5y_t_equalto_2y;
		}
		public void setR9_1point5y_t_equalto_2y(BigDecimal r9_1point5y_t_equalto_2y) {
			this.r9_1point5y_t_equalto_2y = r9_1point5y_t_equalto_2y;
		}
		public BigDecimal getR9_2y_t_equalto_3y() {
			return r9_2y_t_equalto_3y;
		}
		public void setR9_2y_t_equalto_3y(BigDecimal r9_2y_t_equalto_3y) {
			this.r9_2y_t_equalto_3y = r9_2y_t_equalto_3y;
		}
		public BigDecimal getR9_3y_t_equalto_4y() {
			return r9_3y_t_equalto_4y;
		}
		public void setR9_3y_t_equalto_4y(BigDecimal r9_3y_t_equalto_4y) {
			this.r9_3y_t_equalto_4y = r9_3y_t_equalto_4y;
		}
		public BigDecimal getR9_4y_lt_t_ltequalto_5y() {
			return r9_4y_lt_t_ltequalto_5y;
		}
		public void setR9_4y_lt_t_ltequalto_5y(BigDecimal r9_4y_lt_t_ltequalto_5y) {
			this.r9_4y_lt_t_ltequalto_5y = r9_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR9_5y_lt_t_ltequalto_6y() {
			return r9_5y_lt_t_ltequalto_6y;
		}
		public void setR9_5y_lt_t_ltequalto_6y(BigDecimal r9_5y_lt_t_ltequalto_6y) {
			this.r9_5y_lt_t_ltequalto_6y = r9_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR9_6y_lt_t_ltequalto_7y() {
			return r9_6y_lt_t_ltequalto_7y;
		}
		public void setR9_6y_lt_t_ltequalto_7y(BigDecimal r9_6y_lt_t_ltequalto_7y) {
			this.r9_6y_lt_t_ltequalto_7y = r9_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR9_7y_lt_t_ltequalto_8y() {
			return r9_7y_lt_t_ltequalto_8y;
		}
		public void setR9_7y_lt_t_ltequalto_8y(BigDecimal r9_7y_lt_t_ltequalto_8y) {
			this.r9_7y_lt_t_ltequalto_8y = r9_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR9_8y_lt_t_ltequalto_9y() {
			return r9_8y_lt_t_ltequalto_9y;
		}
		public void setR9_8y_lt_t_ltequalto_9y(BigDecimal r9_8y_lt_t_ltequalto_9y) {
			this.r9_8y_lt_t_ltequalto_9y = r9_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR9_9y_lt_t_ltequalto_10y() {
			return r9_9y_lt_t_ltequalto_10y;
		}
		public void setR9_9y_lt_t_ltequalto_10y(BigDecimal r9_9y_lt_t_ltequalto_10y) {
			this.r9_9y_lt_t_ltequalto_10y = r9_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR9_10y_lt_t_ltequalto_15y() {
			return r9_10y_lt_t_ltequalto_15y;
		}
		public void setR9_10y_lt_t_ltequalto_15y(BigDecimal r9_10y_lt_t_ltequalto_15y) {
			this.r9_10y_lt_t_ltequalto_15y = r9_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR9_15y_lt_t_ltequalto_20y() {
			return r9_15y_lt_t_ltequalto_20y;
		}
		public void setR9_15y_lt_t_ltequalto_20y(BigDecimal r9_15y_lt_t_ltequalto_20y) {
			this.r9_15y_lt_t_ltequalto_20y = r9_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR9_tl_20y() {
			return r9_tl_20y;
		}
		public void setR9_tl_20y(BigDecimal r9_tl_20y) {
			this.r9_tl_20y = r9_tl_20y;
		}
		public BigDecimal getR9_nonsensitive() {
			return r9_nonsensitive;
		}
		public void setR9_nonsensitive(BigDecimal r9_nonsensitive) {
			this.r9_nonsensitive = r9_nonsensitive;
		}
		public BigDecimal getR9_total_rsl() {
			return r9_total_rsl;
		}
		public void setR9_total_rsl(BigDecimal r9_total_rsl) {
			this.r9_total_rsl = r9_total_rsl;
		}
		public BigDecimal getR9_total() {
			return r9_total;
		}
		public void setR9_total(BigDecimal r9_total) {
			this.r9_total = r9_total;
		}
		public String getR10_product() {
			return r10_product;
		}
		public void setR10_product(String r10_product) {
			this.r10_product = r10_product;
		}
		public BigDecimal getR10_tequalon() {
			return r10_tequalon;
		}
		public void setR10_tequalon(BigDecimal r10_tequalon) {
			this.r10_tequalon = r10_tequalon;
		}
		public BigDecimal getR10_on_t_equalto_1m() {
			return r10_on_t_equalto_1m;
		}
		public void setR10_on_t_equalto_1m(BigDecimal r10_on_t_equalto_1m) {
			this.r10_on_t_equalto_1m = r10_on_t_equalto_1m;
		}
		public BigDecimal getR10_1m_t_equalto_3m() {
			return r10_1m_t_equalto_3m;
		}
		public void setR10_1m_t_equalto_3m(BigDecimal r10_1m_t_equalto_3m) {
			this.r10_1m_t_equalto_3m = r10_1m_t_equalto_3m;
		}
		public BigDecimal getR10_3m_t_equalto_6m() {
			return r10_3m_t_equalto_6m;
		}
		public void setR10_3m_t_equalto_6m(BigDecimal r10_3m_t_equalto_6m) {
			this.r10_3m_t_equalto_6m = r10_3m_t_equalto_6m;
		}
		public BigDecimal getR10_6m_t_equalto_9m() {
			return r10_6m_t_equalto_9m;
		}
		public void setR10_6m_t_equalto_9m(BigDecimal r10_6m_t_equalto_9m) {
			this.r10_6m_t_equalto_9m = r10_6m_t_equalto_9m;
		}
		public BigDecimal getR10_9m_t_equalto_1y() {
			return r10_9m_t_equalto_1y;
		}
		public void setR10_9m_t_equalto_1y(BigDecimal r10_9m_t_equalto_1y) {
			this.r10_9m_t_equalto_1y = r10_9m_t_equalto_1y;
		}
		public BigDecimal getR10_1y_t_equalto_1point5y() {
			return r10_1y_t_equalto_1point5y;
		}
		public void setR10_1y_t_equalto_1point5y(BigDecimal r10_1y_t_equalto_1point5y) {
			this.r10_1y_t_equalto_1point5y = r10_1y_t_equalto_1point5y;
		}
		public BigDecimal getR10_1point5y_t_equalto_2y() {
			return r10_1point5y_t_equalto_2y;
		}
		public void setR10_1point5y_t_equalto_2y(BigDecimal r10_1point5y_t_equalto_2y) {
			this.r10_1point5y_t_equalto_2y = r10_1point5y_t_equalto_2y;
		}
		public BigDecimal getR10_2y_t_equalto_3y() {
			return r10_2y_t_equalto_3y;
		}
		public void setR10_2y_t_equalto_3y(BigDecimal r10_2y_t_equalto_3y) {
			this.r10_2y_t_equalto_3y = r10_2y_t_equalto_3y;
		}
		public BigDecimal getR10_3y_t_equalto_4y() {
			return r10_3y_t_equalto_4y;
		}
		public void setR10_3y_t_equalto_4y(BigDecimal r10_3y_t_equalto_4y) {
			this.r10_3y_t_equalto_4y = r10_3y_t_equalto_4y;
		}
		public BigDecimal getR10_4y_lt_t_ltequalto_5y() {
			return r10_4y_lt_t_ltequalto_5y;
		}
		public void setR10_4y_lt_t_ltequalto_5y(BigDecimal r10_4y_lt_t_ltequalto_5y) {
			this.r10_4y_lt_t_ltequalto_5y = r10_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR10_5y_lt_t_ltequalto_6y() {
			return r10_5y_lt_t_ltequalto_6y;
		}
		public void setR10_5y_lt_t_ltequalto_6y(BigDecimal r10_5y_lt_t_ltequalto_6y) {
			this.r10_5y_lt_t_ltequalto_6y = r10_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR10_6y_lt_t_ltequalto_7y() {
			return r10_6y_lt_t_ltequalto_7y;
		}
		public void setR10_6y_lt_t_ltequalto_7y(BigDecimal r10_6y_lt_t_ltequalto_7y) {
			this.r10_6y_lt_t_ltequalto_7y = r10_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR10_7y_lt_t_ltequalto_8y() {
			return r10_7y_lt_t_ltequalto_8y;
		}
		public void setR10_7y_lt_t_ltequalto_8y(BigDecimal r10_7y_lt_t_ltequalto_8y) {
			this.r10_7y_lt_t_ltequalto_8y = r10_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR10_8y_lt_t_ltequalto_9y() {
			return r10_8y_lt_t_ltequalto_9y;
		}
		public void setR10_8y_lt_t_ltequalto_9y(BigDecimal r10_8y_lt_t_ltequalto_9y) {
			this.r10_8y_lt_t_ltequalto_9y = r10_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR10_9y_lt_t_ltequalto_10y() {
			return r10_9y_lt_t_ltequalto_10y;
		}
		public void setR10_9y_lt_t_ltequalto_10y(BigDecimal r10_9y_lt_t_ltequalto_10y) {
			this.r10_9y_lt_t_ltequalto_10y = r10_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR10_10y_lt_t_ltequalto_15y() {
			return r10_10y_lt_t_ltequalto_15y;
		}
		public void setR10_10y_lt_t_ltequalto_15y(BigDecimal r10_10y_lt_t_ltequalto_15y) {
			this.r10_10y_lt_t_ltequalto_15y = r10_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR10_15y_lt_t_ltequalto_20y() {
			return r10_15y_lt_t_ltequalto_20y;
		}
		public void setR10_15y_lt_t_ltequalto_20y(BigDecimal r10_15y_lt_t_ltequalto_20y) {
			this.r10_15y_lt_t_ltequalto_20y = r10_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR10_tl_20y() {
			return r10_tl_20y;
		}
		public void setR10_tl_20y(BigDecimal r10_tl_20y) {
			this.r10_tl_20y = r10_tl_20y;
		}
		public BigDecimal getR10_nonsensitive() {
			return r10_nonsensitive;
		}
		public void setR10_nonsensitive(BigDecimal r10_nonsensitive) {
			this.r10_nonsensitive = r10_nonsensitive;
		}
		public BigDecimal getR10_total_rsl() {
			return r10_total_rsl;
		}
		public void setR10_total_rsl(BigDecimal r10_total_rsl) {
			this.r10_total_rsl = r10_total_rsl;
		}
		public BigDecimal getR10_total() {
			return r10_total;
		}
		public void setR10_total(BigDecimal r10_total) {
			this.r10_total = r10_total;
		}
		public String getR11_product() {
			return r11_product;
		}
		public void setR11_product(String r11_product) {
			this.r11_product = r11_product;
		}
		public BigDecimal getR11_tequalon() {
			return r11_tequalon;
		}
		public void setR11_tequalon(BigDecimal r11_tequalon) {
			this.r11_tequalon = r11_tequalon;
		}
		public BigDecimal getR11_on_t_equalto_1m() {
			return r11_on_t_equalto_1m;
		}
		public void setR11_on_t_equalto_1m(BigDecimal r11_on_t_equalto_1m) {
			this.r11_on_t_equalto_1m = r11_on_t_equalto_1m;
		}
		public BigDecimal getR11_1m_t_equalto_3m() {
			return r11_1m_t_equalto_3m;
		}
		public void setR11_1m_t_equalto_3m(BigDecimal r11_1m_t_equalto_3m) {
			this.r11_1m_t_equalto_3m = r11_1m_t_equalto_3m;
		}
		public BigDecimal getR11_3m_t_equalto_6m() {
			return r11_3m_t_equalto_6m;
		}
		public void setR11_3m_t_equalto_6m(BigDecimal r11_3m_t_equalto_6m) {
			this.r11_3m_t_equalto_6m = r11_3m_t_equalto_6m;
		}
		public BigDecimal getR11_6m_t_equalto_9m() {
			return r11_6m_t_equalto_9m;
		}
		public void setR11_6m_t_equalto_9m(BigDecimal r11_6m_t_equalto_9m) {
			this.r11_6m_t_equalto_9m = r11_6m_t_equalto_9m;
		}
		public BigDecimal getR11_9m_t_equalto_1y() {
			return r11_9m_t_equalto_1y;
		}
		public void setR11_9m_t_equalto_1y(BigDecimal r11_9m_t_equalto_1y) {
			this.r11_9m_t_equalto_1y = r11_9m_t_equalto_1y;
		}
		public BigDecimal getR11_1y_t_equalto_1point5y() {
			return r11_1y_t_equalto_1point5y;
		}
		public void setR11_1y_t_equalto_1point5y(BigDecimal r11_1y_t_equalto_1point5y) {
			this.r11_1y_t_equalto_1point5y = r11_1y_t_equalto_1point5y;
		}
		public BigDecimal getR11_1point5y_t_equalto_2y() {
			return r11_1point5y_t_equalto_2y;
		}
		public void setR11_1point5y_t_equalto_2y(BigDecimal r11_1point5y_t_equalto_2y) {
			this.r11_1point5y_t_equalto_2y = r11_1point5y_t_equalto_2y;
		}
		public BigDecimal getR11_2y_t_equalto_3y() {
			return r11_2y_t_equalto_3y;
		}
		public void setR11_2y_t_equalto_3y(BigDecimal r11_2y_t_equalto_3y) {
			this.r11_2y_t_equalto_3y = r11_2y_t_equalto_3y;
		}
		public BigDecimal getR11_3y_t_equalto_4y() {
			return r11_3y_t_equalto_4y;
		}
		public void setR11_3y_t_equalto_4y(BigDecimal r11_3y_t_equalto_4y) {
			this.r11_3y_t_equalto_4y = r11_3y_t_equalto_4y;
		}
		public BigDecimal getR11_4y_lt_t_ltequalto_5y() {
			return r11_4y_lt_t_ltequalto_5y;
		}
		public void setR11_4y_lt_t_ltequalto_5y(BigDecimal r11_4y_lt_t_ltequalto_5y) {
			this.r11_4y_lt_t_ltequalto_5y = r11_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR11_5y_lt_t_ltequalto_6y() {
			return r11_5y_lt_t_ltequalto_6y;
		}
		public void setR11_5y_lt_t_ltequalto_6y(BigDecimal r11_5y_lt_t_ltequalto_6y) {
			this.r11_5y_lt_t_ltequalto_6y = r11_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR11_6y_lt_t_ltequalto_7y() {
			return r11_6y_lt_t_ltequalto_7y;
		}
		public void setR11_6y_lt_t_ltequalto_7y(BigDecimal r11_6y_lt_t_ltequalto_7y) {
			this.r11_6y_lt_t_ltequalto_7y = r11_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR11_7y_lt_t_ltequalto_8y() {
			return r11_7y_lt_t_ltequalto_8y;
		}
		public void setR11_7y_lt_t_ltequalto_8y(BigDecimal r11_7y_lt_t_ltequalto_8y) {
			this.r11_7y_lt_t_ltequalto_8y = r11_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR11_8y_lt_t_ltequalto_9y() {
			return r11_8y_lt_t_ltequalto_9y;
		}
		public void setR11_8y_lt_t_ltequalto_9y(BigDecimal r11_8y_lt_t_ltequalto_9y) {
			this.r11_8y_lt_t_ltequalto_9y = r11_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR11_9y_lt_t_ltequalto_10y() {
			return r11_9y_lt_t_ltequalto_10y;
		}
		public void setR11_9y_lt_t_ltequalto_10y(BigDecimal r11_9y_lt_t_ltequalto_10y) {
			this.r11_9y_lt_t_ltequalto_10y = r11_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR11_10y_lt_t_ltequalto_15y() {
			return r11_10y_lt_t_ltequalto_15y;
		}
		public void setR11_10y_lt_t_ltequalto_15y(BigDecimal r11_10y_lt_t_ltequalto_15y) {
			this.r11_10y_lt_t_ltequalto_15y = r11_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR11_15y_lt_t_ltequalto_20y() {
			return r11_15y_lt_t_ltequalto_20y;
		}
		public void setR11_15y_lt_t_ltequalto_20y(BigDecimal r11_15y_lt_t_ltequalto_20y) {
			this.r11_15y_lt_t_ltequalto_20y = r11_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR11_tl_20y() {
			return r11_tl_20y;
		}
		public void setR11_tl_20y(BigDecimal r11_tl_20y) {
			this.r11_tl_20y = r11_tl_20y;
		}
		public BigDecimal getR11_nonsensitive() {
			return r11_nonsensitive;
		}
		public void setR11_nonsensitive(BigDecimal r11_nonsensitive) {
			this.r11_nonsensitive = r11_nonsensitive;
		}
		public BigDecimal getR11_total_rsl() {
			return r11_total_rsl;
		}
		public void setR11_total_rsl(BigDecimal r11_total_rsl) {
			this.r11_total_rsl = r11_total_rsl;
		}
		public BigDecimal getR11_total() {
			return r11_total;
		}
		public void setR11_total(BigDecimal r11_total) {
			this.r11_total = r11_total;
		}
		public String getR12_product() {
			return r12_product;
		}
		public void setR12_product(String r12_product) {
			this.r12_product = r12_product;
		}
		public BigDecimal getR12_tequalon() {
			return r12_tequalon;
		}
		public void setR12_tequalon(BigDecimal r12_tequalon) {
			this.r12_tequalon = r12_tequalon;
		}
		public BigDecimal getR12_on_t_equalto_1m() {
			return r12_on_t_equalto_1m;
		}
		public void setR12_on_t_equalto_1m(BigDecimal r12_on_t_equalto_1m) {
			this.r12_on_t_equalto_1m = r12_on_t_equalto_1m;
		}
		public BigDecimal getR12_1m_t_equalto_3m() {
			return r12_1m_t_equalto_3m;
		}
		public void setR12_1m_t_equalto_3m(BigDecimal r12_1m_t_equalto_3m) {
			this.r12_1m_t_equalto_3m = r12_1m_t_equalto_3m;
		}
		public BigDecimal getR12_3m_t_equalto_6m() {
			return r12_3m_t_equalto_6m;
		}
		public void setR12_3m_t_equalto_6m(BigDecimal r12_3m_t_equalto_6m) {
			this.r12_3m_t_equalto_6m = r12_3m_t_equalto_6m;
		}
		public BigDecimal getR12_6m_t_equalto_9m() {
			return r12_6m_t_equalto_9m;
		}
		public void setR12_6m_t_equalto_9m(BigDecimal r12_6m_t_equalto_9m) {
			this.r12_6m_t_equalto_9m = r12_6m_t_equalto_9m;
		}
		public BigDecimal getR12_9m_t_equalto_1y() {
			return r12_9m_t_equalto_1y;
		}
		public void setR12_9m_t_equalto_1y(BigDecimal r12_9m_t_equalto_1y) {
			this.r12_9m_t_equalto_1y = r12_9m_t_equalto_1y;
		}
		public BigDecimal getR12_1y_t_equalto_1point5y() {
			return r12_1y_t_equalto_1point5y;
		}
		public void setR12_1y_t_equalto_1point5y(BigDecimal r12_1y_t_equalto_1point5y) {
			this.r12_1y_t_equalto_1point5y = r12_1y_t_equalto_1point5y;
		}
		public BigDecimal getR12_1point5y_t_equalto_2y() {
			return r12_1point5y_t_equalto_2y;
		}
		public void setR12_1point5y_t_equalto_2y(BigDecimal r12_1point5y_t_equalto_2y) {
			this.r12_1point5y_t_equalto_2y = r12_1point5y_t_equalto_2y;
		}
		public BigDecimal getR12_2y_t_equalto_3y() {
			return r12_2y_t_equalto_3y;
		}
		public void setR12_2y_t_equalto_3y(BigDecimal r12_2y_t_equalto_3y) {
			this.r12_2y_t_equalto_3y = r12_2y_t_equalto_3y;
		}
		public BigDecimal getR12_3y_t_equalto_4y() {
			return r12_3y_t_equalto_4y;
		}
		public void setR12_3y_t_equalto_4y(BigDecimal r12_3y_t_equalto_4y) {
			this.r12_3y_t_equalto_4y = r12_3y_t_equalto_4y;
		}
		public BigDecimal getR12_4y_lt_t_ltequalto_5y() {
			return r12_4y_lt_t_ltequalto_5y;
		}
		public void setR12_4y_lt_t_ltequalto_5y(BigDecimal r12_4y_lt_t_ltequalto_5y) {
			this.r12_4y_lt_t_ltequalto_5y = r12_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR12_5y_lt_t_ltequalto_6y() {
			return r12_5y_lt_t_ltequalto_6y;
		}
		public void setR12_5y_lt_t_ltequalto_6y(BigDecimal r12_5y_lt_t_ltequalto_6y) {
			this.r12_5y_lt_t_ltequalto_6y = r12_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR12_6y_lt_t_ltequalto_7y() {
			return r12_6y_lt_t_ltequalto_7y;
		}
		public void setR12_6y_lt_t_ltequalto_7y(BigDecimal r12_6y_lt_t_ltequalto_7y) {
			this.r12_6y_lt_t_ltequalto_7y = r12_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR12_7y_lt_t_ltequalto_8y() {
			return r12_7y_lt_t_ltequalto_8y;
		}
		public void setR12_7y_lt_t_ltequalto_8y(BigDecimal r12_7y_lt_t_ltequalto_8y) {
			this.r12_7y_lt_t_ltequalto_8y = r12_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR12_8y_lt_t_ltequalto_9y() {
			return r12_8y_lt_t_ltequalto_9y;
		}
		public void setR12_8y_lt_t_ltequalto_9y(BigDecimal r12_8y_lt_t_ltequalto_9y) {
			this.r12_8y_lt_t_ltequalto_9y = r12_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR12_9y_lt_t_ltequalto_10y() {
			return r12_9y_lt_t_ltequalto_10y;
		}
		public void setR12_9y_lt_t_ltequalto_10y(BigDecimal r12_9y_lt_t_ltequalto_10y) {
			this.r12_9y_lt_t_ltequalto_10y = r12_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR12_10y_lt_t_ltequalto_15y() {
			return r12_10y_lt_t_ltequalto_15y;
		}
		public void setR12_10y_lt_t_ltequalto_15y(BigDecimal r12_10y_lt_t_ltequalto_15y) {
			this.r12_10y_lt_t_ltequalto_15y = r12_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR12_15y_lt_t_ltequalto_20y() {
			return r12_15y_lt_t_ltequalto_20y;
		}
		public void setR12_15y_lt_t_ltequalto_20y(BigDecimal r12_15y_lt_t_ltequalto_20y) {
			this.r12_15y_lt_t_ltequalto_20y = r12_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR12_tl_20y() {
			return r12_tl_20y;
		}
		public void setR12_tl_20y(BigDecimal r12_tl_20y) {
			this.r12_tl_20y = r12_tl_20y;
		}
		public BigDecimal getR12_nonsensitive() {
			return r12_nonsensitive;
		}
		public void setR12_nonsensitive(BigDecimal r12_nonsensitive) {
			this.r12_nonsensitive = r12_nonsensitive;
		}
		public BigDecimal getR12_total_rsl() {
			return r12_total_rsl;
		}
		public void setR12_total_rsl(BigDecimal r12_total_rsl) {
			this.r12_total_rsl = r12_total_rsl;
		}
		public BigDecimal getR12_total() {
			return r12_total;
		}
		public void setR12_total(BigDecimal r12_total) {
			this.r12_total = r12_total;
		}
		public String getR13_product() {
			return r13_product;
		}
		public void setR13_product(String r13_product) {
			this.r13_product = r13_product;
		}
		public BigDecimal getR13_tequalon() {
			return r13_tequalon;
		}
		public void setR13_tequalon(BigDecimal r13_tequalon) {
			this.r13_tequalon = r13_tequalon;
		}
		public BigDecimal getR13_on_t_equalto_1m() {
			return r13_on_t_equalto_1m;
		}
		public void setR13_on_t_equalto_1m(BigDecimal r13_on_t_equalto_1m) {
			this.r13_on_t_equalto_1m = r13_on_t_equalto_1m;
		}
		public BigDecimal getR13_1m_t_equalto_3m() {
			return r13_1m_t_equalto_3m;
		}
		public void setR13_1m_t_equalto_3m(BigDecimal r13_1m_t_equalto_3m) {
			this.r13_1m_t_equalto_3m = r13_1m_t_equalto_3m;
		}
		public BigDecimal getR13_3m_t_equalto_6m() {
			return r13_3m_t_equalto_6m;
		}
		public void setR13_3m_t_equalto_6m(BigDecimal r13_3m_t_equalto_6m) {
			this.r13_3m_t_equalto_6m = r13_3m_t_equalto_6m;
		}
		public BigDecimal getR13_6m_t_equalto_9m() {
			return r13_6m_t_equalto_9m;
		}
		public void setR13_6m_t_equalto_9m(BigDecimal r13_6m_t_equalto_9m) {
			this.r13_6m_t_equalto_9m = r13_6m_t_equalto_9m;
		}
		public BigDecimal getR13_9m_t_equalto_1y() {
			return r13_9m_t_equalto_1y;
		}
		public void setR13_9m_t_equalto_1y(BigDecimal r13_9m_t_equalto_1y) {
			this.r13_9m_t_equalto_1y = r13_9m_t_equalto_1y;
		}
		public BigDecimal getR13_1y_t_equalto_1point5y() {
			return r13_1y_t_equalto_1point5y;
		}
		public void setR13_1y_t_equalto_1point5y(BigDecimal r13_1y_t_equalto_1point5y) {
			this.r13_1y_t_equalto_1point5y = r13_1y_t_equalto_1point5y;
		}
		public BigDecimal getR13_1point5y_t_equalto_2y() {
			return r13_1point5y_t_equalto_2y;
		}
		public void setR13_1point5y_t_equalto_2y(BigDecimal r13_1point5y_t_equalto_2y) {
			this.r13_1point5y_t_equalto_2y = r13_1point5y_t_equalto_2y;
		}
		public BigDecimal getR13_2y_t_equalto_3y() {
			return r13_2y_t_equalto_3y;
		}
		public void setR13_2y_t_equalto_3y(BigDecimal r13_2y_t_equalto_3y) {
			this.r13_2y_t_equalto_3y = r13_2y_t_equalto_3y;
		}
		public BigDecimal getR13_3y_t_equalto_4y() {
			return r13_3y_t_equalto_4y;
		}
		public void setR13_3y_t_equalto_4y(BigDecimal r13_3y_t_equalto_4y) {
			this.r13_3y_t_equalto_4y = r13_3y_t_equalto_4y;
		}
		public BigDecimal getR13_4y_lt_t_ltequalto_5y() {
			return r13_4y_lt_t_ltequalto_5y;
		}
		public void setR13_4y_lt_t_ltequalto_5y(BigDecimal r13_4y_lt_t_ltequalto_5y) {
			this.r13_4y_lt_t_ltequalto_5y = r13_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR13_5y_lt_t_ltequalto_6y() {
			return r13_5y_lt_t_ltequalto_6y;
		}
		public void setR13_5y_lt_t_ltequalto_6y(BigDecimal r13_5y_lt_t_ltequalto_6y) {
			this.r13_5y_lt_t_ltequalto_6y = r13_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR13_6y_lt_t_ltequalto_7y() {
			return r13_6y_lt_t_ltequalto_7y;
		}
		public void setR13_6y_lt_t_ltequalto_7y(BigDecimal r13_6y_lt_t_ltequalto_7y) {
			this.r13_6y_lt_t_ltequalto_7y = r13_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR13_7y_lt_t_ltequalto_8y() {
			return r13_7y_lt_t_ltequalto_8y;
		}
		public void setR13_7y_lt_t_ltequalto_8y(BigDecimal r13_7y_lt_t_ltequalto_8y) {
			this.r13_7y_lt_t_ltequalto_8y = r13_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR13_8y_lt_t_ltequalto_9y() {
			return r13_8y_lt_t_ltequalto_9y;
		}
		public void setR13_8y_lt_t_ltequalto_9y(BigDecimal r13_8y_lt_t_ltequalto_9y) {
			this.r13_8y_lt_t_ltequalto_9y = r13_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR13_9y_lt_t_ltequalto_10y() {
			return r13_9y_lt_t_ltequalto_10y;
		}
		public void setR13_9y_lt_t_ltequalto_10y(BigDecimal r13_9y_lt_t_ltequalto_10y) {
			this.r13_9y_lt_t_ltequalto_10y = r13_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR13_10y_lt_t_ltequalto_15y() {
			return r13_10y_lt_t_ltequalto_15y;
		}
		public void setR13_10y_lt_t_ltequalto_15y(BigDecimal r13_10y_lt_t_ltequalto_15y) {
			this.r13_10y_lt_t_ltequalto_15y = r13_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR13_15y_lt_t_ltequalto_20y() {
			return r13_15y_lt_t_ltequalto_20y;
		}
		public void setR13_15y_lt_t_ltequalto_20y(BigDecimal r13_15y_lt_t_ltequalto_20y) {
			this.r13_15y_lt_t_ltequalto_20y = r13_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR13_tl_20y() {
			return r13_tl_20y;
		}
		public void setR13_tl_20y(BigDecimal r13_tl_20y) {
			this.r13_tl_20y = r13_tl_20y;
		}
		public BigDecimal getR13_nonsensitive() {
			return r13_nonsensitive;
		}
		public void setR13_nonsensitive(BigDecimal r13_nonsensitive) {
			this.r13_nonsensitive = r13_nonsensitive;
		}
		public BigDecimal getR13_total_rsl() {
			return r13_total_rsl;
		}
		public void setR13_total_rsl(BigDecimal r13_total_rsl) {
			this.r13_total_rsl = r13_total_rsl;
		}
		public BigDecimal getR13_total() {
			return r13_total;
		}
		public void setR13_total(BigDecimal r13_total) {
			this.r13_total = r13_total;
		}
		public String getR14_product() {
			return r14_product;
		}
		public void setR14_product(String r14_product) {
			this.r14_product = r14_product;
		}
		public BigDecimal getR14_tequalon() {
			return r14_tequalon;
		}
		public void setR14_tequalon(BigDecimal r14_tequalon) {
			this.r14_tequalon = r14_tequalon;
		}
		public BigDecimal getR14_on_t_equalto_1m() {
			return r14_on_t_equalto_1m;
		}
		public void setR14_on_t_equalto_1m(BigDecimal r14_on_t_equalto_1m) {
			this.r14_on_t_equalto_1m = r14_on_t_equalto_1m;
		}
		public BigDecimal getR14_1m_t_equalto_3m() {
			return r14_1m_t_equalto_3m;
		}
		public void setR14_1m_t_equalto_3m(BigDecimal r14_1m_t_equalto_3m) {
			this.r14_1m_t_equalto_3m = r14_1m_t_equalto_3m;
		}
		public BigDecimal getR14_3m_t_equalto_6m() {
			return r14_3m_t_equalto_6m;
		}
		public void setR14_3m_t_equalto_6m(BigDecimal r14_3m_t_equalto_6m) {
			this.r14_3m_t_equalto_6m = r14_3m_t_equalto_6m;
		}
		public BigDecimal getR14_6m_t_equalto_9m() {
			return r14_6m_t_equalto_9m;
		}
		public void setR14_6m_t_equalto_9m(BigDecimal r14_6m_t_equalto_9m) {
			this.r14_6m_t_equalto_9m = r14_6m_t_equalto_9m;
		}
		public BigDecimal getR14_9m_t_equalto_1y() {
			return r14_9m_t_equalto_1y;
		}
		public void setR14_9m_t_equalto_1y(BigDecimal r14_9m_t_equalto_1y) {
			this.r14_9m_t_equalto_1y = r14_9m_t_equalto_1y;
		}
		public BigDecimal getR14_1y_t_equalto_1point5y() {
			return r14_1y_t_equalto_1point5y;
		}
		public void setR14_1y_t_equalto_1point5y(BigDecimal r14_1y_t_equalto_1point5y) {
			this.r14_1y_t_equalto_1point5y = r14_1y_t_equalto_1point5y;
		}
		public BigDecimal getR14_1point5y_t_equalto_2y() {
			return r14_1point5y_t_equalto_2y;
		}
		public void setR14_1point5y_t_equalto_2y(BigDecimal r14_1point5y_t_equalto_2y) {
			this.r14_1point5y_t_equalto_2y = r14_1point5y_t_equalto_2y;
		}
		public BigDecimal getR14_2y_t_equalto_3y() {
			return r14_2y_t_equalto_3y;
		}
		public void setR14_2y_t_equalto_3y(BigDecimal r14_2y_t_equalto_3y) {
			this.r14_2y_t_equalto_3y = r14_2y_t_equalto_3y;
		}
		public BigDecimal getR14_3y_t_equalto_4y() {
			return r14_3y_t_equalto_4y;
		}
		public void setR14_3y_t_equalto_4y(BigDecimal r14_3y_t_equalto_4y) {
			this.r14_3y_t_equalto_4y = r14_3y_t_equalto_4y;
		}
		public BigDecimal getR14_4y_lt_t_ltequalto_5y() {
			return r14_4y_lt_t_ltequalto_5y;
		}
		public void setR14_4y_lt_t_ltequalto_5y(BigDecimal r14_4y_lt_t_ltequalto_5y) {
			this.r14_4y_lt_t_ltequalto_5y = r14_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR14_5y_lt_t_ltequalto_6y() {
			return r14_5y_lt_t_ltequalto_6y;
		}
		public void setR14_5y_lt_t_ltequalto_6y(BigDecimal r14_5y_lt_t_ltequalto_6y) {
			this.r14_5y_lt_t_ltequalto_6y = r14_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR14_6y_lt_t_ltequalto_7y() {
			return r14_6y_lt_t_ltequalto_7y;
		}
		public void setR14_6y_lt_t_ltequalto_7y(BigDecimal r14_6y_lt_t_ltequalto_7y) {
			this.r14_6y_lt_t_ltequalto_7y = r14_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR14_7y_lt_t_ltequalto_8y() {
			return r14_7y_lt_t_ltequalto_8y;
		}
		public void setR14_7y_lt_t_ltequalto_8y(BigDecimal r14_7y_lt_t_ltequalto_8y) {
			this.r14_7y_lt_t_ltequalto_8y = r14_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR14_8y_lt_t_ltequalto_9y() {
			return r14_8y_lt_t_ltequalto_9y;
		}
		public void setR14_8y_lt_t_ltequalto_9y(BigDecimal r14_8y_lt_t_ltequalto_9y) {
			this.r14_8y_lt_t_ltequalto_9y = r14_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR14_9y_lt_t_ltequalto_10y() {
			return r14_9y_lt_t_ltequalto_10y;
		}
		public void setR14_9y_lt_t_ltequalto_10y(BigDecimal r14_9y_lt_t_ltequalto_10y) {
			this.r14_9y_lt_t_ltequalto_10y = r14_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR14_10y_lt_t_ltequalto_15y() {
			return r14_10y_lt_t_ltequalto_15y;
		}
		public void setR14_10y_lt_t_ltequalto_15y(BigDecimal r14_10y_lt_t_ltequalto_15y) {
			this.r14_10y_lt_t_ltequalto_15y = r14_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR14_15y_lt_t_ltequalto_20y() {
			return r14_15y_lt_t_ltequalto_20y;
		}
		public void setR14_15y_lt_t_ltequalto_20y(BigDecimal r14_15y_lt_t_ltequalto_20y) {
			this.r14_15y_lt_t_ltequalto_20y = r14_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR14_tl_20y() {
			return r14_tl_20y;
		}
		public void setR14_tl_20y(BigDecimal r14_tl_20y) {
			this.r14_tl_20y = r14_tl_20y;
		}
		public BigDecimal getR14_nonsensitive() {
			return r14_nonsensitive;
		}
		public void setR14_nonsensitive(BigDecimal r14_nonsensitive) {
			this.r14_nonsensitive = r14_nonsensitive;
		}
		public BigDecimal getR14_total_rsl() {
			return r14_total_rsl;
		}
		public void setR14_total_rsl(BigDecimal r14_total_rsl) {
			this.r14_total_rsl = r14_total_rsl;
		}
		public BigDecimal getR14_total() {
			return r14_total;
		}
		public void setR14_total(BigDecimal r14_total) {
			this.r14_total = r14_total;
		}
		public String getR15_product() {
			return r15_product;
		}
		public void setR15_product(String r15_product) {
			this.r15_product = r15_product;
		}
		public BigDecimal getR15_tequalon() {
			return r15_tequalon;
		}
		public void setR15_tequalon(BigDecimal r15_tequalon) {
			this.r15_tequalon = r15_tequalon;
		}
		public BigDecimal getR15_on_t_equalto_1m() {
			return r15_on_t_equalto_1m;
		}
		public void setR15_on_t_equalto_1m(BigDecimal r15_on_t_equalto_1m) {
			this.r15_on_t_equalto_1m = r15_on_t_equalto_1m;
		}
		public BigDecimal getR15_1m_t_equalto_3m() {
			return r15_1m_t_equalto_3m;
		}
		public void setR15_1m_t_equalto_3m(BigDecimal r15_1m_t_equalto_3m) {
			this.r15_1m_t_equalto_3m = r15_1m_t_equalto_3m;
		}
		public BigDecimal getR15_3m_t_equalto_6m() {
			return r15_3m_t_equalto_6m;
		}
		public void setR15_3m_t_equalto_6m(BigDecimal r15_3m_t_equalto_6m) {
			this.r15_3m_t_equalto_6m = r15_3m_t_equalto_6m;
		}
		public BigDecimal getR15_6m_t_equalto_9m() {
			return r15_6m_t_equalto_9m;
		}
		public void setR15_6m_t_equalto_9m(BigDecimal r15_6m_t_equalto_9m) {
			this.r15_6m_t_equalto_9m = r15_6m_t_equalto_9m;
		}
		public BigDecimal getR15_9m_t_equalto_1y() {
			return r15_9m_t_equalto_1y;
		}
		public void setR15_9m_t_equalto_1y(BigDecimal r15_9m_t_equalto_1y) {
			this.r15_9m_t_equalto_1y = r15_9m_t_equalto_1y;
		}
		public BigDecimal getR15_1y_t_equalto_1point5y() {
			return r15_1y_t_equalto_1point5y;
		}
		public void setR15_1y_t_equalto_1point5y(BigDecimal r15_1y_t_equalto_1point5y) {
			this.r15_1y_t_equalto_1point5y = r15_1y_t_equalto_1point5y;
		}
		public BigDecimal getR15_1point5y_t_equalto_2y() {
			return r15_1point5y_t_equalto_2y;
		}
		public void setR15_1point5y_t_equalto_2y(BigDecimal r15_1point5y_t_equalto_2y) {
			this.r15_1point5y_t_equalto_2y = r15_1point5y_t_equalto_2y;
		}
		public BigDecimal getR15_2y_t_equalto_3y() {
			return r15_2y_t_equalto_3y;
		}
		public void setR15_2y_t_equalto_3y(BigDecimal r15_2y_t_equalto_3y) {
			this.r15_2y_t_equalto_3y = r15_2y_t_equalto_3y;
		}
		public BigDecimal getR15_3y_t_equalto_4y() {
			return r15_3y_t_equalto_4y;
		}
		public void setR15_3y_t_equalto_4y(BigDecimal r15_3y_t_equalto_4y) {
			this.r15_3y_t_equalto_4y = r15_3y_t_equalto_4y;
		}
		public BigDecimal getR15_4y_lt_t_ltequalto_5y() {
			return r15_4y_lt_t_ltequalto_5y;
		}
		public void setR15_4y_lt_t_ltequalto_5y(BigDecimal r15_4y_lt_t_ltequalto_5y) {
			this.r15_4y_lt_t_ltequalto_5y = r15_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR15_5y_lt_t_ltequalto_6y() {
			return r15_5y_lt_t_ltequalto_6y;
		}
		public void setR15_5y_lt_t_ltequalto_6y(BigDecimal r15_5y_lt_t_ltequalto_6y) {
			this.r15_5y_lt_t_ltequalto_6y = r15_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR15_6y_lt_t_ltequalto_7y() {
			return r15_6y_lt_t_ltequalto_7y;
		}
		public void setR15_6y_lt_t_ltequalto_7y(BigDecimal r15_6y_lt_t_ltequalto_7y) {
			this.r15_6y_lt_t_ltequalto_7y = r15_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR15_7y_lt_t_ltequalto_8y() {
			return r15_7y_lt_t_ltequalto_8y;
		}
		public void setR15_7y_lt_t_ltequalto_8y(BigDecimal r15_7y_lt_t_ltequalto_8y) {
			this.r15_7y_lt_t_ltequalto_8y = r15_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR15_8y_lt_t_ltequalto_9y() {
			return r15_8y_lt_t_ltequalto_9y;
		}
		public void setR15_8y_lt_t_ltequalto_9y(BigDecimal r15_8y_lt_t_ltequalto_9y) {
			this.r15_8y_lt_t_ltequalto_9y = r15_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR15_9y_lt_t_ltequalto_10y() {
			return r15_9y_lt_t_ltequalto_10y;
		}
		public void setR15_9y_lt_t_ltequalto_10y(BigDecimal r15_9y_lt_t_ltequalto_10y) {
			this.r15_9y_lt_t_ltequalto_10y = r15_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR15_10y_lt_t_ltequalto_15y() {
			return r15_10y_lt_t_ltequalto_15y;
		}
		public void setR15_10y_lt_t_ltequalto_15y(BigDecimal r15_10y_lt_t_ltequalto_15y) {
			this.r15_10y_lt_t_ltequalto_15y = r15_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR15_15y_lt_t_ltequalto_20y() {
			return r15_15y_lt_t_ltequalto_20y;
		}
		public void setR15_15y_lt_t_ltequalto_20y(BigDecimal r15_15y_lt_t_ltequalto_20y) {
			this.r15_15y_lt_t_ltequalto_20y = r15_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR15_tl_20y() {
			return r15_tl_20y;
		}
		public void setR15_tl_20y(BigDecimal r15_tl_20y) {
			this.r15_tl_20y = r15_tl_20y;
		}
		public BigDecimal getR15_nonsensitive() {
			return r15_nonsensitive;
		}
		public void setR15_nonsensitive(BigDecimal r15_nonsensitive) {
			this.r15_nonsensitive = r15_nonsensitive;
		}
		public BigDecimal getR15_total_rsl() {
			return r15_total_rsl;
		}
		public void setR15_total_rsl(BigDecimal r15_total_rsl) {
			this.r15_total_rsl = r15_total_rsl;
		}
		public BigDecimal getR15_total() {
			return r15_total;
		}
		public void setR15_total(BigDecimal r15_total) {
			this.r15_total = r15_total;
		}
		public String getR16_product() {
			return r16_product;
		}
		public void setR16_product(String r16_product) {
			this.r16_product = r16_product;
		}
		public BigDecimal getR16_tequalon() {
			return r16_tequalon;
		}
		public void setR16_tequalon(BigDecimal r16_tequalon) {
			this.r16_tequalon = r16_tequalon;
		}
		public BigDecimal getR16_on_t_equalto_1m() {
			return r16_on_t_equalto_1m;
		}
		public void setR16_on_t_equalto_1m(BigDecimal r16_on_t_equalto_1m) {
			this.r16_on_t_equalto_1m = r16_on_t_equalto_1m;
		}
		public BigDecimal getR16_1m_t_equalto_3m() {
			return r16_1m_t_equalto_3m;
		}
		public void setR16_1m_t_equalto_3m(BigDecimal r16_1m_t_equalto_3m) {
			this.r16_1m_t_equalto_3m = r16_1m_t_equalto_3m;
		}
		public BigDecimal getR16_3m_t_equalto_6m() {
			return r16_3m_t_equalto_6m;
		}
		public void setR16_3m_t_equalto_6m(BigDecimal r16_3m_t_equalto_6m) {
			this.r16_3m_t_equalto_6m = r16_3m_t_equalto_6m;
		}
		public BigDecimal getR16_6m_t_equalto_9m() {
			return r16_6m_t_equalto_9m;
		}
		public void setR16_6m_t_equalto_9m(BigDecimal r16_6m_t_equalto_9m) {
			this.r16_6m_t_equalto_9m = r16_6m_t_equalto_9m;
		}
		public BigDecimal getR16_9m_t_equalto_1y() {
			return r16_9m_t_equalto_1y;
		}
		public void setR16_9m_t_equalto_1y(BigDecimal r16_9m_t_equalto_1y) {
			this.r16_9m_t_equalto_1y = r16_9m_t_equalto_1y;
		}
		public BigDecimal getR16_1y_t_equalto_1point5y() {
			return r16_1y_t_equalto_1point5y;
		}
		public void setR16_1y_t_equalto_1point5y(BigDecimal r16_1y_t_equalto_1point5y) {
			this.r16_1y_t_equalto_1point5y = r16_1y_t_equalto_1point5y;
		}
		public BigDecimal getR16_1point5y_t_equalto_2y() {
			return r16_1point5y_t_equalto_2y;
		}
		public void setR16_1point5y_t_equalto_2y(BigDecimal r16_1point5y_t_equalto_2y) {
			this.r16_1point5y_t_equalto_2y = r16_1point5y_t_equalto_2y;
		}
		public BigDecimal getR16_2y_t_equalto_3y() {
			return r16_2y_t_equalto_3y;
		}
		public void setR16_2y_t_equalto_3y(BigDecimal r16_2y_t_equalto_3y) {
			this.r16_2y_t_equalto_3y = r16_2y_t_equalto_3y;
		}
		public BigDecimal getR16_3y_t_equalto_4y() {
			return r16_3y_t_equalto_4y;
		}
		public void setR16_3y_t_equalto_4y(BigDecimal r16_3y_t_equalto_4y) {
			this.r16_3y_t_equalto_4y = r16_3y_t_equalto_4y;
		}
		public BigDecimal getR16_4y_lt_t_ltequalto_5y() {
			return r16_4y_lt_t_ltequalto_5y;
		}
		public void setR16_4y_lt_t_ltequalto_5y(BigDecimal r16_4y_lt_t_ltequalto_5y) {
			this.r16_4y_lt_t_ltequalto_5y = r16_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR16_5y_lt_t_ltequalto_6y() {
			return r16_5y_lt_t_ltequalto_6y;
		}
		public void setR16_5y_lt_t_ltequalto_6y(BigDecimal r16_5y_lt_t_ltequalto_6y) {
			this.r16_5y_lt_t_ltequalto_6y = r16_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR16_6y_lt_t_ltequalto_7y() {
			return r16_6y_lt_t_ltequalto_7y;
		}
		public void setR16_6y_lt_t_ltequalto_7y(BigDecimal r16_6y_lt_t_ltequalto_7y) {
			this.r16_6y_lt_t_ltequalto_7y = r16_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR16_7y_lt_t_ltequalto_8y() {
			return r16_7y_lt_t_ltequalto_8y;
		}
		public void setR16_7y_lt_t_ltequalto_8y(BigDecimal r16_7y_lt_t_ltequalto_8y) {
			this.r16_7y_lt_t_ltequalto_8y = r16_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR16_8y_lt_t_ltequalto_9y() {
			return r16_8y_lt_t_ltequalto_9y;
		}
		public void setR16_8y_lt_t_ltequalto_9y(BigDecimal r16_8y_lt_t_ltequalto_9y) {
			this.r16_8y_lt_t_ltequalto_9y = r16_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR16_9y_lt_t_ltequalto_10y() {
			return r16_9y_lt_t_ltequalto_10y;
		}
		public void setR16_9y_lt_t_ltequalto_10y(BigDecimal r16_9y_lt_t_ltequalto_10y) {
			this.r16_9y_lt_t_ltequalto_10y = r16_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR16_10y_lt_t_ltequalto_15y() {
			return r16_10y_lt_t_ltequalto_15y;
		}
		public void setR16_10y_lt_t_ltequalto_15y(BigDecimal r16_10y_lt_t_ltequalto_15y) {
			this.r16_10y_lt_t_ltequalto_15y = r16_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR16_15y_lt_t_ltequalto_20y() {
			return r16_15y_lt_t_ltequalto_20y;
		}
		public void setR16_15y_lt_t_ltequalto_20y(BigDecimal r16_15y_lt_t_ltequalto_20y) {
			this.r16_15y_lt_t_ltequalto_20y = r16_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR16_tl_20y() {
			return r16_tl_20y;
		}
		public void setR16_tl_20y(BigDecimal r16_tl_20y) {
			this.r16_tl_20y = r16_tl_20y;
		}
		public BigDecimal getR16_nonsensitive() {
			return r16_nonsensitive;
		}
		public void setR16_nonsensitive(BigDecimal r16_nonsensitive) {
			this.r16_nonsensitive = r16_nonsensitive;
		}
		public BigDecimal getR16_total_rsl() {
			return r16_total_rsl;
		}
		public void setR16_total_rsl(BigDecimal r16_total_rsl) {
			this.r16_total_rsl = r16_total_rsl;
		}
		public BigDecimal getR16_total() {
			return r16_total;
		}
		public void setR16_total(BigDecimal r16_total) {
			this.r16_total = r16_total;
		}
		public String getR17_product() {
			return r17_product;
		}
		public void setR17_product(String r17_product) {
			this.r17_product = r17_product;
		}
		public BigDecimal getR17_tequalon() {
			return r17_tequalon;
		}
		public void setR17_tequalon(BigDecimal r17_tequalon) {
			this.r17_tequalon = r17_tequalon;
		}
		public BigDecimal getR17_on_t_equalto_1m() {
			return r17_on_t_equalto_1m;
		}
		public void setR17_on_t_equalto_1m(BigDecimal r17_on_t_equalto_1m) {
			this.r17_on_t_equalto_1m = r17_on_t_equalto_1m;
		}
		public BigDecimal getR17_1m_t_equalto_3m() {
			return r17_1m_t_equalto_3m;
		}
		public void setR17_1m_t_equalto_3m(BigDecimal r17_1m_t_equalto_3m) {
			this.r17_1m_t_equalto_3m = r17_1m_t_equalto_3m;
		}
		public BigDecimal getR17_3m_t_equalto_6m() {
			return r17_3m_t_equalto_6m;
		}
		public void setR17_3m_t_equalto_6m(BigDecimal r17_3m_t_equalto_6m) {
			this.r17_3m_t_equalto_6m = r17_3m_t_equalto_6m;
		}
		public BigDecimal getR17_6m_t_equalto_9m() {
			return r17_6m_t_equalto_9m;
		}
		public void setR17_6m_t_equalto_9m(BigDecimal r17_6m_t_equalto_9m) {
			this.r17_6m_t_equalto_9m = r17_6m_t_equalto_9m;
		}
		public BigDecimal getR17_9m_t_equalto_1y() {
			return r17_9m_t_equalto_1y;
		}
		public void setR17_9m_t_equalto_1y(BigDecimal r17_9m_t_equalto_1y) {
			this.r17_9m_t_equalto_1y = r17_9m_t_equalto_1y;
		}
		public BigDecimal getR17_1y_t_equalto_1point5y() {
			return r17_1y_t_equalto_1point5y;
		}
		public void setR17_1y_t_equalto_1point5y(BigDecimal r17_1y_t_equalto_1point5y) {
			this.r17_1y_t_equalto_1point5y = r17_1y_t_equalto_1point5y;
		}
		public BigDecimal getR17_1point5y_t_equalto_2y() {
			return r17_1point5y_t_equalto_2y;
		}
		public void setR17_1point5y_t_equalto_2y(BigDecimal r17_1point5y_t_equalto_2y) {
			this.r17_1point5y_t_equalto_2y = r17_1point5y_t_equalto_2y;
		}
		public BigDecimal getR17_2y_t_equalto_3y() {
			return r17_2y_t_equalto_3y;
		}
		public void setR17_2y_t_equalto_3y(BigDecimal r17_2y_t_equalto_3y) {
			this.r17_2y_t_equalto_3y = r17_2y_t_equalto_3y;
		}
		public BigDecimal getR17_3y_t_equalto_4y() {
			return r17_3y_t_equalto_4y;
		}
		public void setR17_3y_t_equalto_4y(BigDecimal r17_3y_t_equalto_4y) {
			this.r17_3y_t_equalto_4y = r17_3y_t_equalto_4y;
		}
		public BigDecimal getR17_4y_lt_t_ltequalto_5y() {
			return r17_4y_lt_t_ltequalto_5y;
		}
		public void setR17_4y_lt_t_ltequalto_5y(BigDecimal r17_4y_lt_t_ltequalto_5y) {
			this.r17_4y_lt_t_ltequalto_5y = r17_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR17_5y_lt_t_ltequalto_6y() {
			return r17_5y_lt_t_ltequalto_6y;
		}
		public void setR17_5y_lt_t_ltequalto_6y(BigDecimal r17_5y_lt_t_ltequalto_6y) {
			this.r17_5y_lt_t_ltequalto_6y = r17_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR17_6y_lt_t_ltequalto_7y() {
			return r17_6y_lt_t_ltequalto_7y;
		}
		public void setR17_6y_lt_t_ltequalto_7y(BigDecimal r17_6y_lt_t_ltequalto_7y) {
			this.r17_6y_lt_t_ltequalto_7y = r17_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR17_7y_lt_t_ltequalto_8y() {
			return r17_7y_lt_t_ltequalto_8y;
		}
		public void setR17_7y_lt_t_ltequalto_8y(BigDecimal r17_7y_lt_t_ltequalto_8y) {
			this.r17_7y_lt_t_ltequalto_8y = r17_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR17_8y_lt_t_ltequalto_9y() {
			return r17_8y_lt_t_ltequalto_9y;
		}
		public void setR17_8y_lt_t_ltequalto_9y(BigDecimal r17_8y_lt_t_ltequalto_9y) {
			this.r17_8y_lt_t_ltequalto_9y = r17_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR17_9y_lt_t_ltequalto_10y() {
			return r17_9y_lt_t_ltequalto_10y;
		}
		public void setR17_9y_lt_t_ltequalto_10y(BigDecimal r17_9y_lt_t_ltequalto_10y) {
			this.r17_9y_lt_t_ltequalto_10y = r17_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR17_10y_lt_t_ltequalto_15y() {
			return r17_10y_lt_t_ltequalto_15y;
		}
		public void setR17_10y_lt_t_ltequalto_15y(BigDecimal r17_10y_lt_t_ltequalto_15y) {
			this.r17_10y_lt_t_ltequalto_15y = r17_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR17_15y_lt_t_ltequalto_20y() {
			return r17_15y_lt_t_ltequalto_20y;
		}
		public void setR17_15y_lt_t_ltequalto_20y(BigDecimal r17_15y_lt_t_ltequalto_20y) {
			this.r17_15y_lt_t_ltequalto_20y = r17_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR17_tl_20y() {
			return r17_tl_20y;
		}
		public void setR17_tl_20y(BigDecimal r17_tl_20y) {
			this.r17_tl_20y = r17_tl_20y;
		}
		public BigDecimal getR17_nonsensitive() {
			return r17_nonsensitive;
		}
		public void setR17_nonsensitive(BigDecimal r17_nonsensitive) {
			this.r17_nonsensitive = r17_nonsensitive;
		}
		public BigDecimal getR17_total_rsl() {
			return r17_total_rsl;
		}
		public void setR17_total_rsl(BigDecimal r17_total_rsl) {
			this.r17_total_rsl = r17_total_rsl;
		}
		public BigDecimal getR17_total() {
			return r17_total;
		}
		public void setR17_total(BigDecimal r17_total) {
			this.r17_total = r17_total;
		}
		public String getR18_product() {
			return r18_product;
		}
		public void setR18_product(String r18_product) {
			this.r18_product = r18_product;
		}
		public BigDecimal getR18_tequalon() {
			return r18_tequalon;
		}
		public void setR18_tequalon(BigDecimal r18_tequalon) {
			this.r18_tequalon = r18_tequalon;
		}
		public BigDecimal getR18_on_t_equalto_1m() {
			return r18_on_t_equalto_1m;
		}
		public void setR18_on_t_equalto_1m(BigDecimal r18_on_t_equalto_1m) {
			this.r18_on_t_equalto_1m = r18_on_t_equalto_1m;
		}
		public BigDecimal getR18_1m_t_equalto_3m() {
			return r18_1m_t_equalto_3m;
		}
		public void setR18_1m_t_equalto_3m(BigDecimal r18_1m_t_equalto_3m) {
			this.r18_1m_t_equalto_3m = r18_1m_t_equalto_3m;
		}
		public BigDecimal getR18_3m_t_equalto_6m() {
			return r18_3m_t_equalto_6m;
		}
		public void setR18_3m_t_equalto_6m(BigDecimal r18_3m_t_equalto_6m) {
			this.r18_3m_t_equalto_6m = r18_3m_t_equalto_6m;
		}
		public BigDecimal getR18_6m_t_equalto_9m() {
			return r18_6m_t_equalto_9m;
		}
		public void setR18_6m_t_equalto_9m(BigDecimal r18_6m_t_equalto_9m) {
			this.r18_6m_t_equalto_9m = r18_6m_t_equalto_9m;
		}
		public BigDecimal getR18_9m_t_equalto_1y() {
			return r18_9m_t_equalto_1y;
		}
		public void setR18_9m_t_equalto_1y(BigDecimal r18_9m_t_equalto_1y) {
			this.r18_9m_t_equalto_1y = r18_9m_t_equalto_1y;
		}
		public BigDecimal getR18_1y_t_equalto_1point5y() {
			return r18_1y_t_equalto_1point5y;
		}
		public void setR18_1y_t_equalto_1point5y(BigDecimal r18_1y_t_equalto_1point5y) {
			this.r18_1y_t_equalto_1point5y = r18_1y_t_equalto_1point5y;
		}
		public BigDecimal getR18_1point5y_t_equalto_2y() {
			return r18_1point5y_t_equalto_2y;
		}
		public void setR18_1point5y_t_equalto_2y(BigDecimal r18_1point5y_t_equalto_2y) {
			this.r18_1point5y_t_equalto_2y = r18_1point5y_t_equalto_2y;
		}
		public BigDecimal getR18_2y_t_equalto_3y() {
			return r18_2y_t_equalto_3y;
		}
		public void setR18_2y_t_equalto_3y(BigDecimal r18_2y_t_equalto_3y) {
			this.r18_2y_t_equalto_3y = r18_2y_t_equalto_3y;
		}
		public BigDecimal getR18_3y_t_equalto_4y() {
			return r18_3y_t_equalto_4y;
		}
		public void setR18_3y_t_equalto_4y(BigDecimal r18_3y_t_equalto_4y) {
			this.r18_3y_t_equalto_4y = r18_3y_t_equalto_4y;
		}
		public BigDecimal getR18_4y_lt_t_ltequalto_5y() {
			return r18_4y_lt_t_ltequalto_5y;
		}
		public void setR18_4y_lt_t_ltequalto_5y(BigDecimal r18_4y_lt_t_ltequalto_5y) {
			this.r18_4y_lt_t_ltequalto_5y = r18_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR18_5y_lt_t_ltequalto_6y() {
			return r18_5y_lt_t_ltequalto_6y;
		}
		public void setR18_5y_lt_t_ltequalto_6y(BigDecimal r18_5y_lt_t_ltequalto_6y) {
			this.r18_5y_lt_t_ltequalto_6y = r18_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR18_6y_lt_t_ltequalto_7y() {
			return r18_6y_lt_t_ltequalto_7y;
		}
		public void setR18_6y_lt_t_ltequalto_7y(BigDecimal r18_6y_lt_t_ltequalto_7y) {
			this.r18_6y_lt_t_ltequalto_7y = r18_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR18_7y_lt_t_ltequalto_8y() {
			return r18_7y_lt_t_ltequalto_8y;
		}
		public void setR18_7y_lt_t_ltequalto_8y(BigDecimal r18_7y_lt_t_ltequalto_8y) {
			this.r18_7y_lt_t_ltequalto_8y = r18_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR18_8y_lt_t_ltequalto_9y() {
			return r18_8y_lt_t_ltequalto_9y;
		}
		public void setR18_8y_lt_t_ltequalto_9y(BigDecimal r18_8y_lt_t_ltequalto_9y) {
			this.r18_8y_lt_t_ltequalto_9y = r18_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR18_9y_lt_t_ltequalto_10y() {
			return r18_9y_lt_t_ltequalto_10y;
		}
		public void setR18_9y_lt_t_ltequalto_10y(BigDecimal r18_9y_lt_t_ltequalto_10y) {
			this.r18_9y_lt_t_ltequalto_10y = r18_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR18_10y_lt_t_ltequalto_15y() {
			return r18_10y_lt_t_ltequalto_15y;
		}
		public void setR18_10y_lt_t_ltequalto_15y(BigDecimal r18_10y_lt_t_ltequalto_15y) {
			this.r18_10y_lt_t_ltequalto_15y = r18_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR18_15y_lt_t_ltequalto_20y() {
			return r18_15y_lt_t_ltequalto_20y;
		}
		public void setR18_15y_lt_t_ltequalto_20y(BigDecimal r18_15y_lt_t_ltequalto_20y) {
			this.r18_15y_lt_t_ltequalto_20y = r18_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR18_tl_20y() {
			return r18_tl_20y;
		}
		public void setR18_tl_20y(BigDecimal r18_tl_20y) {
			this.r18_tl_20y = r18_tl_20y;
		}
		public BigDecimal getR18_nonsensitive() {
			return r18_nonsensitive;
		}
		public void setR18_nonsensitive(BigDecimal r18_nonsensitive) {
			this.r18_nonsensitive = r18_nonsensitive;
		}
		public BigDecimal getR18_total_rsl() {
			return r18_total_rsl;
		}
		public void setR18_total_rsl(BigDecimal r18_total_rsl) {
			this.r18_total_rsl = r18_total_rsl;
		}
		public BigDecimal getR18_total() {
			return r18_total;
		}
		public void setR18_total(BigDecimal r18_total) {
			this.r18_total = r18_total;
		}
		public String getR19_product() {
			return r19_product;
		}
		public void setR19_product(String r19_product) {
			this.r19_product = r19_product;
		}
		public BigDecimal getR19_tequalon() {
			return r19_tequalon;
		}
		public void setR19_tequalon(BigDecimal r19_tequalon) {
			this.r19_tequalon = r19_tequalon;
		}
		public BigDecimal getR19_on_t_equalto_1m() {
			return r19_on_t_equalto_1m;
		}
		public void setR19_on_t_equalto_1m(BigDecimal r19_on_t_equalto_1m) {
			this.r19_on_t_equalto_1m = r19_on_t_equalto_1m;
		}
		public BigDecimal getR19_1m_t_equalto_3m() {
			return r19_1m_t_equalto_3m;
		}
		public void setR19_1m_t_equalto_3m(BigDecimal r19_1m_t_equalto_3m) {
			this.r19_1m_t_equalto_3m = r19_1m_t_equalto_3m;
		}
		public BigDecimal getR19_3m_t_equalto_6m() {
			return r19_3m_t_equalto_6m;
		}
		public void setR19_3m_t_equalto_6m(BigDecimal r19_3m_t_equalto_6m) {
			this.r19_3m_t_equalto_6m = r19_3m_t_equalto_6m;
		}
		public BigDecimal getR19_6m_t_equalto_9m() {
			return r19_6m_t_equalto_9m;
		}
		public void setR19_6m_t_equalto_9m(BigDecimal r19_6m_t_equalto_9m) {
			this.r19_6m_t_equalto_9m = r19_6m_t_equalto_9m;
		}
		public BigDecimal getR19_9m_t_equalto_1y() {
			return r19_9m_t_equalto_1y;
		}
		public void setR19_9m_t_equalto_1y(BigDecimal r19_9m_t_equalto_1y) {
			this.r19_9m_t_equalto_1y = r19_9m_t_equalto_1y;
		}
		public BigDecimal getR19_1y_t_equalto_1point5y() {
			return r19_1y_t_equalto_1point5y;
		}
		public void setR19_1y_t_equalto_1point5y(BigDecimal r19_1y_t_equalto_1point5y) {
			this.r19_1y_t_equalto_1point5y = r19_1y_t_equalto_1point5y;
		}
		public BigDecimal getR19_1point5y_t_equalto_2y() {
			return r19_1point5y_t_equalto_2y;
		}
		public void setR19_1point5y_t_equalto_2y(BigDecimal r19_1point5y_t_equalto_2y) {
			this.r19_1point5y_t_equalto_2y = r19_1point5y_t_equalto_2y;
		}
		public BigDecimal getR19_2y_t_equalto_3y() {
			return r19_2y_t_equalto_3y;
		}
		public void setR19_2y_t_equalto_3y(BigDecimal r19_2y_t_equalto_3y) {
			this.r19_2y_t_equalto_3y = r19_2y_t_equalto_3y;
		}
		public BigDecimal getR19_3y_t_equalto_4y() {
			return r19_3y_t_equalto_4y;
		}
		public void setR19_3y_t_equalto_4y(BigDecimal r19_3y_t_equalto_4y) {
			this.r19_3y_t_equalto_4y = r19_3y_t_equalto_4y;
		}
		public BigDecimal getR19_4y_lt_t_ltequalto_5y() {
			return r19_4y_lt_t_ltequalto_5y;
		}
		public void setR19_4y_lt_t_ltequalto_5y(BigDecimal r19_4y_lt_t_ltequalto_5y) {
			this.r19_4y_lt_t_ltequalto_5y = r19_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR19_5y_lt_t_ltequalto_6y() {
			return r19_5y_lt_t_ltequalto_6y;
		}
		public void setR19_5y_lt_t_ltequalto_6y(BigDecimal r19_5y_lt_t_ltequalto_6y) {
			this.r19_5y_lt_t_ltequalto_6y = r19_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR19_6y_lt_t_ltequalto_7y() {
			return r19_6y_lt_t_ltequalto_7y;
		}
		public void setR19_6y_lt_t_ltequalto_7y(BigDecimal r19_6y_lt_t_ltequalto_7y) {
			this.r19_6y_lt_t_ltequalto_7y = r19_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR19_7y_lt_t_ltequalto_8y() {
			return r19_7y_lt_t_ltequalto_8y;
		}
		public void setR19_7y_lt_t_ltequalto_8y(BigDecimal r19_7y_lt_t_ltequalto_8y) {
			this.r19_7y_lt_t_ltequalto_8y = r19_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR19_8y_lt_t_ltequalto_9y() {
			return r19_8y_lt_t_ltequalto_9y;
		}
		public void setR19_8y_lt_t_ltequalto_9y(BigDecimal r19_8y_lt_t_ltequalto_9y) {
			this.r19_8y_lt_t_ltequalto_9y = r19_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR19_9y_lt_t_ltequalto_10y() {
			return r19_9y_lt_t_ltequalto_10y;
		}
		public void setR19_9y_lt_t_ltequalto_10y(BigDecimal r19_9y_lt_t_ltequalto_10y) {
			this.r19_9y_lt_t_ltequalto_10y = r19_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR19_10y_lt_t_ltequalto_15y() {
			return r19_10y_lt_t_ltequalto_15y;
		}
		public void setR19_10y_lt_t_ltequalto_15y(BigDecimal r19_10y_lt_t_ltequalto_15y) {
			this.r19_10y_lt_t_ltequalto_15y = r19_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR19_15y_lt_t_ltequalto_20y() {
			return r19_15y_lt_t_ltequalto_20y;
		}
		public void setR19_15y_lt_t_ltequalto_20y(BigDecimal r19_15y_lt_t_ltequalto_20y) {
			this.r19_15y_lt_t_ltequalto_20y = r19_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR19_tl_20y() {
			return r19_tl_20y;
		}
		public void setR19_tl_20y(BigDecimal r19_tl_20y) {
			this.r19_tl_20y = r19_tl_20y;
		}
		public BigDecimal getR19_nonsensitive() {
			return r19_nonsensitive;
		}
		public void setR19_nonsensitive(BigDecimal r19_nonsensitive) {
			this.r19_nonsensitive = r19_nonsensitive;
		}
		public BigDecimal getR19_total_rsl() {
			return r19_total_rsl;
		}
		public void setR19_total_rsl(BigDecimal r19_total_rsl) {
			this.r19_total_rsl = r19_total_rsl;
		}
		public BigDecimal getR19_total() {
			return r19_total;
		}
		public void setR19_total(BigDecimal r19_total) {
			this.r19_total = r19_total;
		}
		public String getR20_product() {
			return r20_product;
		}
		public void setR20_product(String r20_product) {
			this.r20_product = r20_product;
		}
		public BigDecimal getR20_tequalon() {
			return r20_tequalon;
		}
		public void setR20_tequalon(BigDecimal r20_tequalon) {
			this.r20_tequalon = r20_tequalon;
		}
		public BigDecimal getR20_on_t_equalto_1m() {
			return r20_on_t_equalto_1m;
		}
		public void setR20_on_t_equalto_1m(BigDecimal r20_on_t_equalto_1m) {
			this.r20_on_t_equalto_1m = r20_on_t_equalto_1m;
		}
		public BigDecimal getR20_1m_t_equalto_3m() {
			return r20_1m_t_equalto_3m;
		}
		public void setR20_1m_t_equalto_3m(BigDecimal r20_1m_t_equalto_3m) {
			this.r20_1m_t_equalto_3m = r20_1m_t_equalto_3m;
		}
		public BigDecimal getR20_3m_t_equalto_6m() {
			return r20_3m_t_equalto_6m;
		}
		public void setR20_3m_t_equalto_6m(BigDecimal r20_3m_t_equalto_6m) {
			this.r20_3m_t_equalto_6m = r20_3m_t_equalto_6m;
		}
		public BigDecimal getR20_6m_t_equalto_9m() {
			return r20_6m_t_equalto_9m;
		}
		public void setR20_6m_t_equalto_9m(BigDecimal r20_6m_t_equalto_9m) {
			this.r20_6m_t_equalto_9m = r20_6m_t_equalto_9m;
		}
		public BigDecimal getR20_9m_t_equalto_1y() {
			return r20_9m_t_equalto_1y;
		}
		public void setR20_9m_t_equalto_1y(BigDecimal r20_9m_t_equalto_1y) {
			this.r20_9m_t_equalto_1y = r20_9m_t_equalto_1y;
		}
		public BigDecimal getR20_1y_t_equalto_1point5y() {
			return r20_1y_t_equalto_1point5y;
		}
		public void setR20_1y_t_equalto_1point5y(BigDecimal r20_1y_t_equalto_1point5y) {
			this.r20_1y_t_equalto_1point5y = r20_1y_t_equalto_1point5y;
		}
		public BigDecimal getR20_1point5y_t_equalto_2y() {
			return r20_1point5y_t_equalto_2y;
		}
		public void setR20_1point5y_t_equalto_2y(BigDecimal r20_1point5y_t_equalto_2y) {
			this.r20_1point5y_t_equalto_2y = r20_1point5y_t_equalto_2y;
		}
		public BigDecimal getR20_2y_t_equalto_3y() {
			return r20_2y_t_equalto_3y;
		}
		public void setR20_2y_t_equalto_3y(BigDecimal r20_2y_t_equalto_3y) {
			this.r20_2y_t_equalto_3y = r20_2y_t_equalto_3y;
		}
		public BigDecimal getR20_3y_t_equalto_4y() {
			return r20_3y_t_equalto_4y;
		}
		public void setR20_3y_t_equalto_4y(BigDecimal r20_3y_t_equalto_4y) {
			this.r20_3y_t_equalto_4y = r20_3y_t_equalto_4y;
		}
		public BigDecimal getR20_4y_lt_t_ltequalto_5y() {
			return r20_4y_lt_t_ltequalto_5y;
		}
		public void setR20_4y_lt_t_ltequalto_5y(BigDecimal r20_4y_lt_t_ltequalto_5y) {
			this.r20_4y_lt_t_ltequalto_5y = r20_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR20_5y_lt_t_ltequalto_6y() {
			return r20_5y_lt_t_ltequalto_6y;
		}
		public void setR20_5y_lt_t_ltequalto_6y(BigDecimal r20_5y_lt_t_ltequalto_6y) {
			this.r20_5y_lt_t_ltequalto_6y = r20_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR20_6y_lt_t_ltequalto_7y() {
			return r20_6y_lt_t_ltequalto_7y;
		}
		public void setR20_6y_lt_t_ltequalto_7y(BigDecimal r20_6y_lt_t_ltequalto_7y) {
			this.r20_6y_lt_t_ltequalto_7y = r20_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR20_7y_lt_t_ltequalto_8y() {
			return r20_7y_lt_t_ltequalto_8y;
		}
		public void setR20_7y_lt_t_ltequalto_8y(BigDecimal r20_7y_lt_t_ltequalto_8y) {
			this.r20_7y_lt_t_ltequalto_8y = r20_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR20_8y_lt_t_ltequalto_9y() {
			return r20_8y_lt_t_ltequalto_9y;
		}
		public void setR20_8y_lt_t_ltequalto_9y(BigDecimal r20_8y_lt_t_ltequalto_9y) {
			this.r20_8y_lt_t_ltequalto_9y = r20_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR20_9y_lt_t_ltequalto_10y() {
			return r20_9y_lt_t_ltequalto_10y;
		}
		public void setR20_9y_lt_t_ltequalto_10y(BigDecimal r20_9y_lt_t_ltequalto_10y) {
			this.r20_9y_lt_t_ltequalto_10y = r20_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR20_10y_lt_t_ltequalto_15y() {
			return r20_10y_lt_t_ltequalto_15y;
		}
		public void setR20_10y_lt_t_ltequalto_15y(BigDecimal r20_10y_lt_t_ltequalto_15y) {
			this.r20_10y_lt_t_ltequalto_15y = r20_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR20_15y_lt_t_ltequalto_20y() {
			return r20_15y_lt_t_ltequalto_20y;
		}
		public void setR20_15y_lt_t_ltequalto_20y(BigDecimal r20_15y_lt_t_ltequalto_20y) {
			this.r20_15y_lt_t_ltequalto_20y = r20_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR20_tl_20y() {
			return r20_tl_20y;
		}
		public void setR20_tl_20y(BigDecimal r20_tl_20y) {
			this.r20_tl_20y = r20_tl_20y;
		}
		public BigDecimal getR20_nonsensitive() {
			return r20_nonsensitive;
		}
		public void setR20_nonsensitive(BigDecimal r20_nonsensitive) {
			this.r20_nonsensitive = r20_nonsensitive;
		}
		public BigDecimal getR20_total_rsl() {
			return r20_total_rsl;
		}
		public void setR20_total_rsl(BigDecimal r20_total_rsl) {
			this.r20_total_rsl = r20_total_rsl;
		}
		public BigDecimal getR20_total() {
			return r20_total;
		}
		public void setR20_total(BigDecimal r20_total) {
			this.r20_total = r20_total;
		}
		public String getR21_product() {
			return r21_product;
		}
		public void setR21_product(String r21_product) {
			this.r21_product = r21_product;
		}
		public BigDecimal getR21_tequalon() {
			return r21_tequalon;
		}
		public void setR21_tequalon(BigDecimal r21_tequalon) {
			this.r21_tequalon = r21_tequalon;
		}
		public BigDecimal getR21_on_t_equalto_1m() {
			return r21_on_t_equalto_1m;
		}
		public void setR21_on_t_equalto_1m(BigDecimal r21_on_t_equalto_1m) {
			this.r21_on_t_equalto_1m = r21_on_t_equalto_1m;
		}
		public BigDecimal getR21_1m_t_equalto_3m() {
			return r21_1m_t_equalto_3m;
		}
		public void setR21_1m_t_equalto_3m(BigDecimal r21_1m_t_equalto_3m) {
			this.r21_1m_t_equalto_3m = r21_1m_t_equalto_3m;
		}
		public BigDecimal getR21_3m_t_equalto_6m() {
			return r21_3m_t_equalto_6m;
		}
		public void setR21_3m_t_equalto_6m(BigDecimal r21_3m_t_equalto_6m) {
			this.r21_3m_t_equalto_6m = r21_3m_t_equalto_6m;
		}
		public BigDecimal getR21_6m_t_equalto_9m() {
			return r21_6m_t_equalto_9m;
		}
		public void setR21_6m_t_equalto_9m(BigDecimal r21_6m_t_equalto_9m) {
			this.r21_6m_t_equalto_9m = r21_6m_t_equalto_9m;
		}
		public BigDecimal getR21_9m_t_equalto_1y() {
			return r21_9m_t_equalto_1y;
		}
		public void setR21_9m_t_equalto_1y(BigDecimal r21_9m_t_equalto_1y) {
			this.r21_9m_t_equalto_1y = r21_9m_t_equalto_1y;
		}
		public BigDecimal getR21_1y_t_equalto_1point5y() {
			return r21_1y_t_equalto_1point5y;
		}
		public void setR21_1y_t_equalto_1point5y(BigDecimal r21_1y_t_equalto_1point5y) {
			this.r21_1y_t_equalto_1point5y = r21_1y_t_equalto_1point5y;
		}
		public BigDecimal getR21_1point5y_t_equalto_2y() {
			return r21_1point5y_t_equalto_2y;
		}
		public void setR21_1point5y_t_equalto_2y(BigDecimal r21_1point5y_t_equalto_2y) {
			this.r21_1point5y_t_equalto_2y = r21_1point5y_t_equalto_2y;
		}
		public BigDecimal getR21_2y_t_equalto_3y() {
			return r21_2y_t_equalto_3y;
		}
		public void setR21_2y_t_equalto_3y(BigDecimal r21_2y_t_equalto_3y) {
			this.r21_2y_t_equalto_3y = r21_2y_t_equalto_3y;
		}
		public BigDecimal getR21_3y_t_equalto_4y() {
			return r21_3y_t_equalto_4y;
		}
		public void setR21_3y_t_equalto_4y(BigDecimal r21_3y_t_equalto_4y) {
			this.r21_3y_t_equalto_4y = r21_3y_t_equalto_4y;
		}
		public BigDecimal getR21_4y_lt_t_ltequalto_5y() {
			return r21_4y_lt_t_ltequalto_5y;
		}
		public void setR21_4y_lt_t_ltequalto_5y(BigDecimal r21_4y_lt_t_ltequalto_5y) {
			this.r21_4y_lt_t_ltequalto_5y = r21_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR21_5y_lt_t_ltequalto_6y() {
			return r21_5y_lt_t_ltequalto_6y;
		}
		public void setR21_5y_lt_t_ltequalto_6y(BigDecimal r21_5y_lt_t_ltequalto_6y) {
			this.r21_5y_lt_t_ltequalto_6y = r21_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR21_6y_lt_t_ltequalto_7y() {
			return r21_6y_lt_t_ltequalto_7y;
		}
		public void setR21_6y_lt_t_ltequalto_7y(BigDecimal r21_6y_lt_t_ltequalto_7y) {
			this.r21_6y_lt_t_ltequalto_7y = r21_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR21_7y_lt_t_ltequalto_8y() {
			return r21_7y_lt_t_ltequalto_8y;
		}
		public void setR21_7y_lt_t_ltequalto_8y(BigDecimal r21_7y_lt_t_ltequalto_8y) {
			this.r21_7y_lt_t_ltequalto_8y = r21_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR21_8y_lt_t_ltequalto_9y() {
			return r21_8y_lt_t_ltequalto_9y;
		}
		public void setR21_8y_lt_t_ltequalto_9y(BigDecimal r21_8y_lt_t_ltequalto_9y) {
			this.r21_8y_lt_t_ltequalto_9y = r21_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR21_9y_lt_t_ltequalto_10y() {
			return r21_9y_lt_t_ltequalto_10y;
		}
		public void setR21_9y_lt_t_ltequalto_10y(BigDecimal r21_9y_lt_t_ltequalto_10y) {
			this.r21_9y_lt_t_ltequalto_10y = r21_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR21_10y_lt_t_ltequalto_15y() {
			return r21_10y_lt_t_ltequalto_15y;
		}
		public void setR21_10y_lt_t_ltequalto_15y(BigDecimal r21_10y_lt_t_ltequalto_15y) {
			this.r21_10y_lt_t_ltequalto_15y = r21_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR21_15y_lt_t_ltequalto_20y() {
			return r21_15y_lt_t_ltequalto_20y;
		}
		public void setR21_15y_lt_t_ltequalto_20y(BigDecimal r21_15y_lt_t_ltequalto_20y) {
			this.r21_15y_lt_t_ltequalto_20y = r21_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR21_tl_20y() {
			return r21_tl_20y;
		}
		public void setR21_tl_20y(BigDecimal r21_tl_20y) {
			this.r21_tl_20y = r21_tl_20y;
		}
		public BigDecimal getR21_nonsensitive() {
			return r21_nonsensitive;
		}
		public void setR21_nonsensitive(BigDecimal r21_nonsensitive) {
			this.r21_nonsensitive = r21_nonsensitive;
		}
		public BigDecimal getR21_total_rsl() {
			return r21_total_rsl;
		}
		public void setR21_total_rsl(BigDecimal r21_total_rsl) {
			this.r21_total_rsl = r21_total_rsl;
		}
		public BigDecimal getR21_total() {
			return r21_total;
		}
		public void setR21_total(BigDecimal r21_total) {
			this.r21_total = r21_total;
		}
		public String getR22_product() {
			return r22_product;
		}
		public void setR22_product(String r22_product) {
			this.r22_product = r22_product;
		}
		public BigDecimal getR22_tequalon() {
			return r22_tequalon;
		}
		public void setR22_tequalon(BigDecimal r22_tequalon) {
			this.r22_tequalon = r22_tequalon;
		}
		public BigDecimal getR22_on_t_equalto_1m() {
			return r22_on_t_equalto_1m;
		}
		public void setR22_on_t_equalto_1m(BigDecimal r22_on_t_equalto_1m) {
			this.r22_on_t_equalto_1m = r22_on_t_equalto_1m;
		}
		public BigDecimal getR22_1m_t_equalto_3m() {
			return r22_1m_t_equalto_3m;
		}
		public void setR22_1m_t_equalto_3m(BigDecimal r22_1m_t_equalto_3m) {
			this.r22_1m_t_equalto_3m = r22_1m_t_equalto_3m;
		}
		public BigDecimal getR22_3m_t_equalto_6m() {
			return r22_3m_t_equalto_6m;
		}
		public void setR22_3m_t_equalto_6m(BigDecimal r22_3m_t_equalto_6m) {
			this.r22_3m_t_equalto_6m = r22_3m_t_equalto_6m;
		}
		public BigDecimal getR22_6m_t_equalto_9m() {
			return r22_6m_t_equalto_9m;
		}
		public void setR22_6m_t_equalto_9m(BigDecimal r22_6m_t_equalto_9m) {
			this.r22_6m_t_equalto_9m = r22_6m_t_equalto_9m;
		}
		public BigDecimal getR22_9m_t_equalto_1y() {
			return r22_9m_t_equalto_1y;
		}
		public void setR22_9m_t_equalto_1y(BigDecimal r22_9m_t_equalto_1y) {
			this.r22_9m_t_equalto_1y = r22_9m_t_equalto_1y;
		}
		public BigDecimal getR22_1y_t_equalto_1point5y() {
			return r22_1y_t_equalto_1point5y;
		}
		public void setR22_1y_t_equalto_1point5y(BigDecimal r22_1y_t_equalto_1point5y) {
			this.r22_1y_t_equalto_1point5y = r22_1y_t_equalto_1point5y;
		}
		public BigDecimal getR22_1point5y_t_equalto_2y() {
			return r22_1point5y_t_equalto_2y;
		}
		public void setR22_1point5y_t_equalto_2y(BigDecimal r22_1point5y_t_equalto_2y) {
			this.r22_1point5y_t_equalto_2y = r22_1point5y_t_equalto_2y;
		}
		public BigDecimal getR22_2y_t_equalto_3y() {
			return r22_2y_t_equalto_3y;
		}
		public void setR22_2y_t_equalto_3y(BigDecimal r22_2y_t_equalto_3y) {
			this.r22_2y_t_equalto_3y = r22_2y_t_equalto_3y;
		}
		public BigDecimal getR22_3y_t_equalto_4y() {
			return r22_3y_t_equalto_4y;
		}
		public void setR22_3y_t_equalto_4y(BigDecimal r22_3y_t_equalto_4y) {
			this.r22_3y_t_equalto_4y = r22_3y_t_equalto_4y;
		}
		public BigDecimal getR22_4y_lt_t_ltequalto_5y() {
			return r22_4y_lt_t_ltequalto_5y;
		}
		public void setR22_4y_lt_t_ltequalto_5y(BigDecimal r22_4y_lt_t_ltequalto_5y) {
			this.r22_4y_lt_t_ltequalto_5y = r22_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR22_5y_lt_t_ltequalto_6y() {
			return r22_5y_lt_t_ltequalto_6y;
		}
		public void setR22_5y_lt_t_ltequalto_6y(BigDecimal r22_5y_lt_t_ltequalto_6y) {
			this.r22_5y_lt_t_ltequalto_6y = r22_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR22_6y_lt_t_ltequalto_7y() {
			return r22_6y_lt_t_ltequalto_7y;
		}
		public void setR22_6y_lt_t_ltequalto_7y(BigDecimal r22_6y_lt_t_ltequalto_7y) {
			this.r22_6y_lt_t_ltequalto_7y = r22_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR22_7y_lt_t_ltequalto_8y() {
			return r22_7y_lt_t_ltequalto_8y;
		}
		public void setR22_7y_lt_t_ltequalto_8y(BigDecimal r22_7y_lt_t_ltequalto_8y) {
			this.r22_7y_lt_t_ltequalto_8y = r22_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR22_8y_lt_t_ltequalto_9y() {
			return r22_8y_lt_t_ltequalto_9y;
		}
		public void setR22_8y_lt_t_ltequalto_9y(BigDecimal r22_8y_lt_t_ltequalto_9y) {
			this.r22_8y_lt_t_ltequalto_9y = r22_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR22_9y_lt_t_ltequalto_10y() {
			return r22_9y_lt_t_ltequalto_10y;
		}
		public void setR22_9y_lt_t_ltequalto_10y(BigDecimal r22_9y_lt_t_ltequalto_10y) {
			this.r22_9y_lt_t_ltequalto_10y = r22_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR22_10y_lt_t_ltequalto_15y() {
			return r22_10y_lt_t_ltequalto_15y;
		}
		public void setR22_10y_lt_t_ltequalto_15y(BigDecimal r22_10y_lt_t_ltequalto_15y) {
			this.r22_10y_lt_t_ltequalto_15y = r22_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR22_15y_lt_t_ltequalto_20y() {
			return r22_15y_lt_t_ltequalto_20y;
		}
		public void setR22_15y_lt_t_ltequalto_20y(BigDecimal r22_15y_lt_t_ltequalto_20y) {
			this.r22_15y_lt_t_ltequalto_20y = r22_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR22_tl_20y() {
			return r22_tl_20y;
		}
		public void setR22_tl_20y(BigDecimal r22_tl_20y) {
			this.r22_tl_20y = r22_tl_20y;
		}
		public BigDecimal getR22_nonsensitive() {
			return r22_nonsensitive;
		}
		public void setR22_nonsensitive(BigDecimal r22_nonsensitive) {
			this.r22_nonsensitive = r22_nonsensitive;
		}
		public BigDecimal getR22_total_rsl() {
			return r22_total_rsl;
		}
		public void setR22_total_rsl(BigDecimal r22_total_rsl) {
			this.r22_total_rsl = r22_total_rsl;
		}
		public BigDecimal getR22_total() {
			return r22_total;
		}
		public void setR22_total(BigDecimal r22_total) {
			this.r22_total = r22_total;
		}
		public String getR23_product() {
			return r23_product;
		}
		public void setR23_product(String r23_product) {
			this.r23_product = r23_product;
		}
		public BigDecimal getR23_tequalon() {
			return r23_tequalon;
		}
		public void setR23_tequalon(BigDecimal r23_tequalon) {
			this.r23_tequalon = r23_tequalon;
		}
		public BigDecimal getR23_on_t_equalto_1m() {
			return r23_on_t_equalto_1m;
		}
		public void setR23_on_t_equalto_1m(BigDecimal r23_on_t_equalto_1m) {
			this.r23_on_t_equalto_1m = r23_on_t_equalto_1m;
		}
		public BigDecimal getR23_1m_t_equalto_3m() {
			return r23_1m_t_equalto_3m;
		}
		public void setR23_1m_t_equalto_3m(BigDecimal r23_1m_t_equalto_3m) {
			this.r23_1m_t_equalto_3m = r23_1m_t_equalto_3m;
		}
		public BigDecimal getR23_3m_t_equalto_6m() {
			return r23_3m_t_equalto_6m;
		}
		public void setR23_3m_t_equalto_6m(BigDecimal r23_3m_t_equalto_6m) {
			this.r23_3m_t_equalto_6m = r23_3m_t_equalto_6m;
		}
		public BigDecimal getR23_6m_t_equalto_9m() {
			return r23_6m_t_equalto_9m;
		}
		public void setR23_6m_t_equalto_9m(BigDecimal r23_6m_t_equalto_9m) {
			this.r23_6m_t_equalto_9m = r23_6m_t_equalto_9m;
		}
		public BigDecimal getR23_9m_t_equalto_1y() {
			return r23_9m_t_equalto_1y;
		}
		public void setR23_9m_t_equalto_1y(BigDecimal r23_9m_t_equalto_1y) {
			this.r23_9m_t_equalto_1y = r23_9m_t_equalto_1y;
		}
		public BigDecimal getR23_1y_t_equalto_1point5y() {
			return r23_1y_t_equalto_1point5y;
		}
		public void setR23_1y_t_equalto_1point5y(BigDecimal r23_1y_t_equalto_1point5y) {
			this.r23_1y_t_equalto_1point5y = r23_1y_t_equalto_1point5y;
		}
		public BigDecimal getR23_1point5y_t_equalto_2y() {
			return r23_1point5y_t_equalto_2y;
		}
		public void setR23_1point5y_t_equalto_2y(BigDecimal r23_1point5y_t_equalto_2y) {
			this.r23_1point5y_t_equalto_2y = r23_1point5y_t_equalto_2y;
		}
		public BigDecimal getR23_2y_t_equalto_3y() {
			return r23_2y_t_equalto_3y;
		}
		public void setR23_2y_t_equalto_3y(BigDecimal r23_2y_t_equalto_3y) {
			this.r23_2y_t_equalto_3y = r23_2y_t_equalto_3y;
		}
		public BigDecimal getR23_3y_t_equalto_4y() {
			return r23_3y_t_equalto_4y;
		}
		public void setR23_3y_t_equalto_4y(BigDecimal r23_3y_t_equalto_4y) {
			this.r23_3y_t_equalto_4y = r23_3y_t_equalto_4y;
		}
		public BigDecimal getR23_4y_lt_t_ltequalto_5y() {
			return r23_4y_lt_t_ltequalto_5y;
		}
		public void setR23_4y_lt_t_ltequalto_5y(BigDecimal r23_4y_lt_t_ltequalto_5y) {
			this.r23_4y_lt_t_ltequalto_5y = r23_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR23_5y_lt_t_ltequalto_6y() {
			return r23_5y_lt_t_ltequalto_6y;
		}
		public void setR23_5y_lt_t_ltequalto_6y(BigDecimal r23_5y_lt_t_ltequalto_6y) {
			this.r23_5y_lt_t_ltequalto_6y = r23_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR23_6y_lt_t_ltequalto_7y() {
			return r23_6y_lt_t_ltequalto_7y;
		}
		public void setR23_6y_lt_t_ltequalto_7y(BigDecimal r23_6y_lt_t_ltequalto_7y) {
			this.r23_6y_lt_t_ltequalto_7y = r23_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR23_7y_lt_t_ltequalto_8y() {
			return r23_7y_lt_t_ltequalto_8y;
		}
		public void setR23_7y_lt_t_ltequalto_8y(BigDecimal r23_7y_lt_t_ltequalto_8y) {
			this.r23_7y_lt_t_ltequalto_8y = r23_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR23_8y_lt_t_ltequalto_9y() {
			return r23_8y_lt_t_ltequalto_9y;
		}
		public void setR23_8y_lt_t_ltequalto_9y(BigDecimal r23_8y_lt_t_ltequalto_9y) {
			this.r23_8y_lt_t_ltequalto_9y = r23_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR23_9y_lt_t_ltequalto_10y() {
			return r23_9y_lt_t_ltequalto_10y;
		}
		public void setR23_9y_lt_t_ltequalto_10y(BigDecimal r23_9y_lt_t_ltequalto_10y) {
			this.r23_9y_lt_t_ltequalto_10y = r23_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR23_10y_lt_t_ltequalto_15y() {
			return r23_10y_lt_t_ltequalto_15y;
		}
		public void setR23_10y_lt_t_ltequalto_15y(BigDecimal r23_10y_lt_t_ltequalto_15y) {
			this.r23_10y_lt_t_ltequalto_15y = r23_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR23_15y_lt_t_ltequalto_20y() {
			return r23_15y_lt_t_ltequalto_20y;
		}
		public void setR23_15y_lt_t_ltequalto_20y(BigDecimal r23_15y_lt_t_ltequalto_20y) {
			this.r23_15y_lt_t_ltequalto_20y = r23_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR23_tl_20y() {
			return r23_tl_20y;
		}
		public void setR23_tl_20y(BigDecimal r23_tl_20y) {
			this.r23_tl_20y = r23_tl_20y;
		}
		public BigDecimal getR23_nonsensitive() {
			return r23_nonsensitive;
		}
		public void setR23_nonsensitive(BigDecimal r23_nonsensitive) {
			this.r23_nonsensitive = r23_nonsensitive;
		}
		public BigDecimal getR23_total_rsl() {
			return r23_total_rsl;
		}
		public void setR23_total_rsl(BigDecimal r23_total_rsl) {
			this.r23_total_rsl = r23_total_rsl;
		}
		public BigDecimal getR23_total() {
			return r23_total;
		}
		public void setR23_total(BigDecimal r23_total) {
			this.r23_total = r23_total;
		}
		public String getR24_product() {
			return r24_product;
		}
		public void setR24_product(String r24_product) {
			this.r24_product = r24_product;
		}
		public BigDecimal getR24_tequalon() {
			return r24_tequalon;
		}
		public void setR24_tequalon(BigDecimal r24_tequalon) {
			this.r24_tequalon = r24_tequalon;
		}
		public BigDecimal getR24_on_t_equalto_1m() {
			return r24_on_t_equalto_1m;
		}
		public void setR24_on_t_equalto_1m(BigDecimal r24_on_t_equalto_1m) {
			this.r24_on_t_equalto_1m = r24_on_t_equalto_1m;
		}
		public BigDecimal getR24_1m_t_equalto_3m() {
			return r24_1m_t_equalto_3m;
		}
		public void setR24_1m_t_equalto_3m(BigDecimal r24_1m_t_equalto_3m) {
			this.r24_1m_t_equalto_3m = r24_1m_t_equalto_3m;
		}
		public BigDecimal getR24_3m_t_equalto_6m() {
			return r24_3m_t_equalto_6m;
		}
		public void setR24_3m_t_equalto_6m(BigDecimal r24_3m_t_equalto_6m) {
			this.r24_3m_t_equalto_6m = r24_3m_t_equalto_6m;
		}
		public BigDecimal getR24_6m_t_equalto_9m() {
			return r24_6m_t_equalto_9m;
		}
		public void setR24_6m_t_equalto_9m(BigDecimal r24_6m_t_equalto_9m) {
			this.r24_6m_t_equalto_9m = r24_6m_t_equalto_9m;
		}
		public BigDecimal getR24_9m_t_equalto_1y() {
			return r24_9m_t_equalto_1y;
		}
		public void setR24_9m_t_equalto_1y(BigDecimal r24_9m_t_equalto_1y) {
			this.r24_9m_t_equalto_1y = r24_9m_t_equalto_1y;
		}
		public BigDecimal getR24_1y_t_equalto_1point5y() {
			return r24_1y_t_equalto_1point5y;
		}
		public void setR24_1y_t_equalto_1point5y(BigDecimal r24_1y_t_equalto_1point5y) {
			this.r24_1y_t_equalto_1point5y = r24_1y_t_equalto_1point5y;
		}
		public BigDecimal getR24_1point5y_t_equalto_2y() {
			return r24_1point5y_t_equalto_2y;
		}
		public void setR24_1point5y_t_equalto_2y(BigDecimal r24_1point5y_t_equalto_2y) {
			this.r24_1point5y_t_equalto_2y = r24_1point5y_t_equalto_2y;
		}
		public BigDecimal getR24_2y_t_equalto_3y() {
			return r24_2y_t_equalto_3y;
		}
		public void setR24_2y_t_equalto_3y(BigDecimal r24_2y_t_equalto_3y) {
			this.r24_2y_t_equalto_3y = r24_2y_t_equalto_3y;
		}
		public BigDecimal getR24_3y_t_equalto_4y() {
			return r24_3y_t_equalto_4y;
		}
		public void setR24_3y_t_equalto_4y(BigDecimal r24_3y_t_equalto_4y) {
			this.r24_3y_t_equalto_4y = r24_3y_t_equalto_4y;
		}
		public BigDecimal getR24_4y_lt_t_ltequalto_5y() {
			return r24_4y_lt_t_ltequalto_5y;
		}
		public void setR24_4y_lt_t_ltequalto_5y(BigDecimal r24_4y_lt_t_ltequalto_5y) {
			this.r24_4y_lt_t_ltequalto_5y = r24_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR24_5y_lt_t_ltequalto_6y() {
			return r24_5y_lt_t_ltequalto_6y;
		}
		public void setR24_5y_lt_t_ltequalto_6y(BigDecimal r24_5y_lt_t_ltequalto_6y) {
			this.r24_5y_lt_t_ltequalto_6y = r24_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR24_6y_lt_t_ltequalto_7y() {
			return r24_6y_lt_t_ltequalto_7y;
		}
		public void setR24_6y_lt_t_ltequalto_7y(BigDecimal r24_6y_lt_t_ltequalto_7y) {
			this.r24_6y_lt_t_ltequalto_7y = r24_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR24_7y_lt_t_ltequalto_8y() {
			return r24_7y_lt_t_ltequalto_8y;
		}
		public void setR24_7y_lt_t_ltequalto_8y(BigDecimal r24_7y_lt_t_ltequalto_8y) {
			this.r24_7y_lt_t_ltequalto_8y = r24_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR24_8y_lt_t_ltequalto_9y() {
			return r24_8y_lt_t_ltequalto_9y;
		}
		public void setR24_8y_lt_t_ltequalto_9y(BigDecimal r24_8y_lt_t_ltequalto_9y) {
			this.r24_8y_lt_t_ltequalto_9y = r24_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR24_9y_lt_t_ltequalto_10y() {
			return r24_9y_lt_t_ltequalto_10y;
		}
		public void setR24_9y_lt_t_ltequalto_10y(BigDecimal r24_9y_lt_t_ltequalto_10y) {
			this.r24_9y_lt_t_ltequalto_10y = r24_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR24_10y_lt_t_ltequalto_15y() {
			return r24_10y_lt_t_ltequalto_15y;
		}
		public void setR24_10y_lt_t_ltequalto_15y(BigDecimal r24_10y_lt_t_ltequalto_15y) {
			this.r24_10y_lt_t_ltequalto_15y = r24_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR24_15y_lt_t_ltequalto_20y() {
			return r24_15y_lt_t_ltequalto_20y;
		}
		public void setR24_15y_lt_t_ltequalto_20y(BigDecimal r24_15y_lt_t_ltequalto_20y) {
			this.r24_15y_lt_t_ltequalto_20y = r24_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR24_tl_20y() {
			return r24_tl_20y;
		}
		public void setR24_tl_20y(BigDecimal r24_tl_20y) {
			this.r24_tl_20y = r24_tl_20y;
		}
		public BigDecimal getR24_nonsensitive() {
			return r24_nonsensitive;
		}
		public void setR24_nonsensitive(BigDecimal r24_nonsensitive) {
			this.r24_nonsensitive = r24_nonsensitive;
		}
		public BigDecimal getR24_total_rsl() {
			return r24_total_rsl;
		}
		public void setR24_total_rsl(BigDecimal r24_total_rsl) {
			this.r24_total_rsl = r24_total_rsl;
		}
		public BigDecimal getR24_total() {
			return r24_total;
		}
		public void setR24_total(BigDecimal r24_total) {
			this.r24_total = r24_total;
		}
		public String getR25_product() {
			return r25_product;
		}
		public void setR25_product(String r25_product) {
			this.r25_product = r25_product;
		}
		public BigDecimal getR25_tequalon() {
			return r25_tequalon;
		}
		public void setR25_tequalon(BigDecimal r25_tequalon) {
			this.r25_tequalon = r25_tequalon;
		}
		public BigDecimal getR25_on_t_equalto_1m() {
			return r25_on_t_equalto_1m;
		}
		public void setR25_on_t_equalto_1m(BigDecimal r25_on_t_equalto_1m) {
			this.r25_on_t_equalto_1m = r25_on_t_equalto_1m;
		}
		public BigDecimal getR25_1m_t_equalto_3m() {
			return r25_1m_t_equalto_3m;
		}
		public void setR25_1m_t_equalto_3m(BigDecimal r25_1m_t_equalto_3m) {
			this.r25_1m_t_equalto_3m = r25_1m_t_equalto_3m;
		}
		public BigDecimal getR25_3m_t_equalto_6m() {
			return r25_3m_t_equalto_6m;
		}
		public void setR25_3m_t_equalto_6m(BigDecimal r25_3m_t_equalto_6m) {
			this.r25_3m_t_equalto_6m = r25_3m_t_equalto_6m;
		}
		public BigDecimal getR25_6m_t_equalto_9m() {
			return r25_6m_t_equalto_9m;
		}
		public void setR25_6m_t_equalto_9m(BigDecimal r25_6m_t_equalto_9m) {
			this.r25_6m_t_equalto_9m = r25_6m_t_equalto_9m;
		}
		public BigDecimal getR25_9m_t_equalto_1y() {
			return r25_9m_t_equalto_1y;
		}
		public void setR25_9m_t_equalto_1y(BigDecimal r25_9m_t_equalto_1y) {
			this.r25_9m_t_equalto_1y = r25_9m_t_equalto_1y;
		}
		public BigDecimal getR25_1y_t_equalto_1point5y() {
			return r25_1y_t_equalto_1point5y;
		}
		public void setR25_1y_t_equalto_1point5y(BigDecimal r25_1y_t_equalto_1point5y) {
			this.r25_1y_t_equalto_1point5y = r25_1y_t_equalto_1point5y;
		}
		public BigDecimal getR25_1point5y_t_equalto_2y() {
			return r25_1point5y_t_equalto_2y;
		}
		public void setR25_1point5y_t_equalto_2y(BigDecimal r25_1point5y_t_equalto_2y) {
			this.r25_1point5y_t_equalto_2y = r25_1point5y_t_equalto_2y;
		}
		public BigDecimal getR25_2y_t_equalto_3y() {
			return r25_2y_t_equalto_3y;
		}
		public void setR25_2y_t_equalto_3y(BigDecimal r25_2y_t_equalto_3y) {
			this.r25_2y_t_equalto_3y = r25_2y_t_equalto_3y;
		}
		public BigDecimal getR25_3y_t_equalto_4y() {
			return r25_3y_t_equalto_4y;
		}
		public void setR25_3y_t_equalto_4y(BigDecimal r25_3y_t_equalto_4y) {
			this.r25_3y_t_equalto_4y = r25_3y_t_equalto_4y;
		}
		public BigDecimal getR25_4y_lt_t_ltequalto_5y() {
			return r25_4y_lt_t_ltequalto_5y;
		}
		public void setR25_4y_lt_t_ltequalto_5y(BigDecimal r25_4y_lt_t_ltequalto_5y) {
			this.r25_4y_lt_t_ltequalto_5y = r25_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR25_5y_lt_t_ltequalto_6y() {
			return r25_5y_lt_t_ltequalto_6y;
		}
		public void setR25_5y_lt_t_ltequalto_6y(BigDecimal r25_5y_lt_t_ltequalto_6y) {
			this.r25_5y_lt_t_ltequalto_6y = r25_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR25_6y_lt_t_ltequalto_7y() {
			return r25_6y_lt_t_ltequalto_7y;
		}
		public void setR25_6y_lt_t_ltequalto_7y(BigDecimal r25_6y_lt_t_ltequalto_7y) {
			this.r25_6y_lt_t_ltequalto_7y = r25_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR25_7y_lt_t_ltequalto_8y() {
			return r25_7y_lt_t_ltequalto_8y;
		}
		public void setR25_7y_lt_t_ltequalto_8y(BigDecimal r25_7y_lt_t_ltequalto_8y) {
			this.r25_7y_lt_t_ltequalto_8y = r25_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR25_8y_lt_t_ltequalto_9y() {
			return r25_8y_lt_t_ltequalto_9y;
		}
		public void setR25_8y_lt_t_ltequalto_9y(BigDecimal r25_8y_lt_t_ltequalto_9y) {
			this.r25_8y_lt_t_ltequalto_9y = r25_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR25_9y_lt_t_ltequalto_10y() {
			return r25_9y_lt_t_ltequalto_10y;
		}
		public void setR25_9y_lt_t_ltequalto_10y(BigDecimal r25_9y_lt_t_ltequalto_10y) {
			this.r25_9y_lt_t_ltequalto_10y = r25_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR25_10y_lt_t_ltequalto_15y() {
			return r25_10y_lt_t_ltequalto_15y;
		}
		public void setR25_10y_lt_t_ltequalto_15y(BigDecimal r25_10y_lt_t_ltequalto_15y) {
			this.r25_10y_lt_t_ltequalto_15y = r25_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR25_15y_lt_t_ltequalto_20y() {
			return r25_15y_lt_t_ltequalto_20y;
		}
		public void setR25_15y_lt_t_ltequalto_20y(BigDecimal r25_15y_lt_t_ltequalto_20y) {
			this.r25_15y_lt_t_ltequalto_20y = r25_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR25_tl_20y() {
			return r25_tl_20y;
		}
		public void setR25_tl_20y(BigDecimal r25_tl_20y) {
			this.r25_tl_20y = r25_tl_20y;
		}
		public BigDecimal getR25_nonsensitive() {
			return r25_nonsensitive;
		}
		public void setR25_nonsensitive(BigDecimal r25_nonsensitive) {
			this.r25_nonsensitive = r25_nonsensitive;
		}
		public BigDecimal getR25_total_rsl() {
			return r25_total_rsl;
		}
		public void setR25_total_rsl(BigDecimal r25_total_rsl) {
			this.r25_total_rsl = r25_total_rsl;
		}
		public BigDecimal getR25_total() {
			return r25_total;
		}
		public void setR25_total(BigDecimal r25_total) {
			this.r25_total = r25_total;
		}
		public String getR26_product() {
			return r26_product;
		}
		public void setR26_product(String r26_product) {
			this.r26_product = r26_product;
		}
		public BigDecimal getR26_tequalon() {
			return r26_tequalon;
		}
		public void setR26_tequalon(BigDecimal r26_tequalon) {
			this.r26_tequalon = r26_tequalon;
		}
		public BigDecimal getR26_on_t_equalto_1m() {
			return r26_on_t_equalto_1m;
		}
		public void setR26_on_t_equalto_1m(BigDecimal r26_on_t_equalto_1m) {
			this.r26_on_t_equalto_1m = r26_on_t_equalto_1m;
		}
		public BigDecimal getR26_1m_t_equalto_3m() {
			return r26_1m_t_equalto_3m;
		}
		public void setR26_1m_t_equalto_3m(BigDecimal r26_1m_t_equalto_3m) {
			this.r26_1m_t_equalto_3m = r26_1m_t_equalto_3m;
		}
		public BigDecimal getR26_3m_t_equalto_6m() {
			return r26_3m_t_equalto_6m;
		}
		public void setR26_3m_t_equalto_6m(BigDecimal r26_3m_t_equalto_6m) {
			this.r26_3m_t_equalto_6m = r26_3m_t_equalto_6m;
		}
		public BigDecimal getR26_6m_t_equalto_9m() {
			return r26_6m_t_equalto_9m;
		}
		public void setR26_6m_t_equalto_9m(BigDecimal r26_6m_t_equalto_9m) {
			this.r26_6m_t_equalto_9m = r26_6m_t_equalto_9m;
		}
		public BigDecimal getR26_9m_t_equalto_1y() {
			return r26_9m_t_equalto_1y;
		}
		public void setR26_9m_t_equalto_1y(BigDecimal r26_9m_t_equalto_1y) {
			this.r26_9m_t_equalto_1y = r26_9m_t_equalto_1y;
		}
		public BigDecimal getR26_1y_t_equalto_1point5y() {
			return r26_1y_t_equalto_1point5y;
		}
		public void setR26_1y_t_equalto_1point5y(BigDecimal r26_1y_t_equalto_1point5y) {
			this.r26_1y_t_equalto_1point5y = r26_1y_t_equalto_1point5y;
		}
		public BigDecimal getR26_1point5y_t_equalto_2y() {
			return r26_1point5y_t_equalto_2y;
		}
		public void setR26_1point5y_t_equalto_2y(BigDecimal r26_1point5y_t_equalto_2y) {
			this.r26_1point5y_t_equalto_2y = r26_1point5y_t_equalto_2y;
		}
		public BigDecimal getR26_2y_t_equalto_3y() {
			return r26_2y_t_equalto_3y;
		}
		public void setR26_2y_t_equalto_3y(BigDecimal r26_2y_t_equalto_3y) {
			this.r26_2y_t_equalto_3y = r26_2y_t_equalto_3y;
		}
		public BigDecimal getR26_3y_t_equalto_4y() {
			return r26_3y_t_equalto_4y;
		}
		public void setR26_3y_t_equalto_4y(BigDecimal r26_3y_t_equalto_4y) {
			this.r26_3y_t_equalto_4y = r26_3y_t_equalto_4y;
		}
		public BigDecimal getR26_4y_lt_t_ltequalto_5y() {
			return r26_4y_lt_t_ltequalto_5y;
		}
		public void setR26_4y_lt_t_ltequalto_5y(BigDecimal r26_4y_lt_t_ltequalto_5y) {
			this.r26_4y_lt_t_ltequalto_5y = r26_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR26_5y_lt_t_ltequalto_6y() {
			return r26_5y_lt_t_ltequalto_6y;
		}
		public void setR26_5y_lt_t_ltequalto_6y(BigDecimal r26_5y_lt_t_ltequalto_6y) {
			this.r26_5y_lt_t_ltequalto_6y = r26_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR26_6y_lt_t_ltequalto_7y() {
			return r26_6y_lt_t_ltequalto_7y;
		}
		public void setR26_6y_lt_t_ltequalto_7y(BigDecimal r26_6y_lt_t_ltequalto_7y) {
			this.r26_6y_lt_t_ltequalto_7y = r26_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR26_7y_lt_t_ltequalto_8y() {
			return r26_7y_lt_t_ltequalto_8y;
		}
		public void setR26_7y_lt_t_ltequalto_8y(BigDecimal r26_7y_lt_t_ltequalto_8y) {
			this.r26_7y_lt_t_ltequalto_8y = r26_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR26_8y_lt_t_ltequalto_9y() {
			return r26_8y_lt_t_ltequalto_9y;
		}
		public void setR26_8y_lt_t_ltequalto_9y(BigDecimal r26_8y_lt_t_ltequalto_9y) {
			this.r26_8y_lt_t_ltequalto_9y = r26_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR26_9y_lt_t_ltequalto_10y() {
			return r26_9y_lt_t_ltequalto_10y;
		}
		public void setR26_9y_lt_t_ltequalto_10y(BigDecimal r26_9y_lt_t_ltequalto_10y) {
			this.r26_9y_lt_t_ltequalto_10y = r26_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR26_10y_lt_t_ltequalto_15y() {
			return r26_10y_lt_t_ltequalto_15y;
		}
		public void setR26_10y_lt_t_ltequalto_15y(BigDecimal r26_10y_lt_t_ltequalto_15y) {
			this.r26_10y_lt_t_ltequalto_15y = r26_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR26_15y_lt_t_ltequalto_20y() {
			return r26_15y_lt_t_ltequalto_20y;
		}
		public void setR26_15y_lt_t_ltequalto_20y(BigDecimal r26_15y_lt_t_ltequalto_20y) {
			this.r26_15y_lt_t_ltequalto_20y = r26_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR26_tl_20y() {
			return r26_tl_20y;
		}
		public void setR26_tl_20y(BigDecimal r26_tl_20y) {
			this.r26_tl_20y = r26_tl_20y;
		}
		public BigDecimal getR26_nonsensitive() {
			return r26_nonsensitive;
		}
		public void setR26_nonsensitive(BigDecimal r26_nonsensitive) {
			this.r26_nonsensitive = r26_nonsensitive;
		}
		public BigDecimal getR26_total_rsl() {
			return r26_total_rsl;
		}
		public void setR26_total_rsl(BigDecimal r26_total_rsl) {
			this.r26_total_rsl = r26_total_rsl;
		}
		public BigDecimal getR26_total() {
			return r26_total;
		}
		public void setR26_total(BigDecimal r26_total) {
			this.r26_total = r26_total;
		}
		public String getR27_product() {
			return r27_product;
		}
		public void setR27_product(String r27_product) {
			this.r27_product = r27_product;
		}
		public BigDecimal getR27_tequalon() {
			return r27_tequalon;
		}
		public void setR27_tequalon(BigDecimal r27_tequalon) {
			this.r27_tequalon = r27_tequalon;
		}
		public BigDecimal getR27_on_t_equalto_1m() {
			return r27_on_t_equalto_1m;
		}
		public void setR27_on_t_equalto_1m(BigDecimal r27_on_t_equalto_1m) {
			this.r27_on_t_equalto_1m = r27_on_t_equalto_1m;
		}
		public BigDecimal getR27_1m_t_equalto_3m() {
			return r27_1m_t_equalto_3m;
		}
		public void setR27_1m_t_equalto_3m(BigDecimal r27_1m_t_equalto_3m) {
			this.r27_1m_t_equalto_3m = r27_1m_t_equalto_3m;
		}
		public BigDecimal getR27_3m_t_equalto_6m() {
			return r27_3m_t_equalto_6m;
		}
		public void setR27_3m_t_equalto_6m(BigDecimal r27_3m_t_equalto_6m) {
			this.r27_3m_t_equalto_6m = r27_3m_t_equalto_6m;
		}
		public BigDecimal getR27_6m_t_equalto_9m() {
			return r27_6m_t_equalto_9m;
		}
		public void setR27_6m_t_equalto_9m(BigDecimal r27_6m_t_equalto_9m) {
			this.r27_6m_t_equalto_9m = r27_6m_t_equalto_9m;
		}
		public BigDecimal getR27_9m_t_equalto_1y() {
			return r27_9m_t_equalto_1y;
		}
		public void setR27_9m_t_equalto_1y(BigDecimal r27_9m_t_equalto_1y) {
			this.r27_9m_t_equalto_1y = r27_9m_t_equalto_1y;
		}
		public BigDecimal getR27_1y_t_equalto_1point5y() {
			return r27_1y_t_equalto_1point5y;
		}
		public void setR27_1y_t_equalto_1point5y(BigDecimal r27_1y_t_equalto_1point5y) {
			this.r27_1y_t_equalto_1point5y = r27_1y_t_equalto_1point5y;
		}
		public BigDecimal getR27_1point5y_t_equalto_2y() {
			return r27_1point5y_t_equalto_2y;
		}
		public void setR27_1point5y_t_equalto_2y(BigDecimal r27_1point5y_t_equalto_2y) {
			this.r27_1point5y_t_equalto_2y = r27_1point5y_t_equalto_2y;
		}
		public BigDecimal getR27_2y_t_equalto_3y() {
			return r27_2y_t_equalto_3y;
		}
		public void setR27_2y_t_equalto_3y(BigDecimal r27_2y_t_equalto_3y) {
			this.r27_2y_t_equalto_3y = r27_2y_t_equalto_3y;
		}
		public BigDecimal getR27_3y_t_equalto_4y() {
			return r27_3y_t_equalto_4y;
		}
		public void setR27_3y_t_equalto_4y(BigDecimal r27_3y_t_equalto_4y) {
			this.r27_3y_t_equalto_4y = r27_3y_t_equalto_4y;
		}
		public BigDecimal getR27_4y_lt_t_ltequalto_5y() {
			return r27_4y_lt_t_ltequalto_5y;
		}
		public void setR27_4y_lt_t_ltequalto_5y(BigDecimal r27_4y_lt_t_ltequalto_5y) {
			this.r27_4y_lt_t_ltequalto_5y = r27_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR27_5y_lt_t_ltequalto_6y() {
			return r27_5y_lt_t_ltequalto_6y;
		}
		public void setR27_5y_lt_t_ltequalto_6y(BigDecimal r27_5y_lt_t_ltequalto_6y) {
			this.r27_5y_lt_t_ltequalto_6y = r27_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR27_6y_lt_t_ltequalto_7y() {
			return r27_6y_lt_t_ltequalto_7y;
		}
		public void setR27_6y_lt_t_ltequalto_7y(BigDecimal r27_6y_lt_t_ltequalto_7y) {
			this.r27_6y_lt_t_ltequalto_7y = r27_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR27_7y_lt_t_ltequalto_8y() {
			return r27_7y_lt_t_ltequalto_8y;
		}
		public void setR27_7y_lt_t_ltequalto_8y(BigDecimal r27_7y_lt_t_ltequalto_8y) {
			this.r27_7y_lt_t_ltequalto_8y = r27_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR27_8y_lt_t_ltequalto_9y() {
			return r27_8y_lt_t_ltequalto_9y;
		}
		public void setR27_8y_lt_t_ltequalto_9y(BigDecimal r27_8y_lt_t_ltequalto_9y) {
			this.r27_8y_lt_t_ltequalto_9y = r27_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR27_9y_lt_t_ltequalto_10y() {
			return r27_9y_lt_t_ltequalto_10y;
		}
		public void setR27_9y_lt_t_ltequalto_10y(BigDecimal r27_9y_lt_t_ltequalto_10y) {
			this.r27_9y_lt_t_ltequalto_10y = r27_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR27_10y_lt_t_ltequalto_15y() {
			return r27_10y_lt_t_ltequalto_15y;
		}
		public void setR27_10y_lt_t_ltequalto_15y(BigDecimal r27_10y_lt_t_ltequalto_15y) {
			this.r27_10y_lt_t_ltequalto_15y = r27_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR27_15y_lt_t_ltequalto_20y() {
			return r27_15y_lt_t_ltequalto_20y;
		}
		public void setR27_15y_lt_t_ltequalto_20y(BigDecimal r27_15y_lt_t_ltequalto_20y) {
			this.r27_15y_lt_t_ltequalto_20y = r27_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR27_tl_20y() {
			return r27_tl_20y;
		}
		public void setR27_tl_20y(BigDecimal r27_tl_20y) {
			this.r27_tl_20y = r27_tl_20y;
		}
		public BigDecimal getR27_nonsensitive() {
			return r27_nonsensitive;
		}
		public void setR27_nonsensitive(BigDecimal r27_nonsensitive) {
			this.r27_nonsensitive = r27_nonsensitive;
		}
		public BigDecimal getR27_total_rsl() {
			return r27_total_rsl;
		}
		public void setR27_total_rsl(BigDecimal r27_total_rsl) {
			this.r27_total_rsl = r27_total_rsl;
		}
		public BigDecimal getR27_total() {
			return r27_total;
		}
		public void setR27_total(BigDecimal r27_total) {
			this.r27_total = r27_total;
		}
		public String getR28_product() {
			return r28_product;
		}
		public void setR28_product(String r28_product) {
			this.r28_product = r28_product;
		}
		public BigDecimal getR28_tequalon() {
			return r28_tequalon;
		}
		public void setR28_tequalon(BigDecimal r28_tequalon) {
			this.r28_tequalon = r28_tequalon;
		}
		public BigDecimal getR28_on_t_equalto_1m() {
			return r28_on_t_equalto_1m;
		}
		public void setR28_on_t_equalto_1m(BigDecimal r28_on_t_equalto_1m) {
			this.r28_on_t_equalto_1m = r28_on_t_equalto_1m;
		}
		public BigDecimal getR28_1m_t_equalto_3m() {
			return r28_1m_t_equalto_3m;
		}
		public void setR28_1m_t_equalto_3m(BigDecimal r28_1m_t_equalto_3m) {
			this.r28_1m_t_equalto_3m = r28_1m_t_equalto_3m;
		}
		public BigDecimal getR28_3m_t_equalto_6m() {
			return r28_3m_t_equalto_6m;
		}
		public void setR28_3m_t_equalto_6m(BigDecimal r28_3m_t_equalto_6m) {
			this.r28_3m_t_equalto_6m = r28_3m_t_equalto_6m;
		}
		public BigDecimal getR28_6m_t_equalto_9m() {
			return r28_6m_t_equalto_9m;
		}
		public void setR28_6m_t_equalto_9m(BigDecimal r28_6m_t_equalto_9m) {
			this.r28_6m_t_equalto_9m = r28_6m_t_equalto_9m;
		}
		public BigDecimal getR28_9m_t_equalto_1y() {
			return r28_9m_t_equalto_1y;
		}
		public void setR28_9m_t_equalto_1y(BigDecimal r28_9m_t_equalto_1y) {
			this.r28_9m_t_equalto_1y = r28_9m_t_equalto_1y;
		}
		public BigDecimal getR28_1y_t_equalto_1point5y() {
			return r28_1y_t_equalto_1point5y;
		}
		public void setR28_1y_t_equalto_1point5y(BigDecimal r28_1y_t_equalto_1point5y) {
			this.r28_1y_t_equalto_1point5y = r28_1y_t_equalto_1point5y;
		}
		public BigDecimal getR28_1point5y_t_equalto_2y() {
			return r28_1point5y_t_equalto_2y;
		}
		public void setR28_1point5y_t_equalto_2y(BigDecimal r28_1point5y_t_equalto_2y) {
			this.r28_1point5y_t_equalto_2y = r28_1point5y_t_equalto_2y;
		}
		public BigDecimal getR28_2y_t_equalto_3y() {
			return r28_2y_t_equalto_3y;
		}
		public void setR28_2y_t_equalto_3y(BigDecimal r28_2y_t_equalto_3y) {
			this.r28_2y_t_equalto_3y = r28_2y_t_equalto_3y;
		}
		public BigDecimal getR28_3y_t_equalto_4y() {
			return r28_3y_t_equalto_4y;
		}
		public void setR28_3y_t_equalto_4y(BigDecimal r28_3y_t_equalto_4y) {
			this.r28_3y_t_equalto_4y = r28_3y_t_equalto_4y;
		}
		public BigDecimal getR28_4y_lt_t_ltequalto_5y() {
			return r28_4y_lt_t_ltequalto_5y;
		}
		public void setR28_4y_lt_t_ltequalto_5y(BigDecimal r28_4y_lt_t_ltequalto_5y) {
			this.r28_4y_lt_t_ltequalto_5y = r28_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR28_5y_lt_t_ltequalto_6y() {
			return r28_5y_lt_t_ltequalto_6y;
		}
		public void setR28_5y_lt_t_ltequalto_6y(BigDecimal r28_5y_lt_t_ltequalto_6y) {
			this.r28_5y_lt_t_ltequalto_6y = r28_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR28_6y_lt_t_ltequalto_7y() {
			return r28_6y_lt_t_ltequalto_7y;
		}
		public void setR28_6y_lt_t_ltequalto_7y(BigDecimal r28_6y_lt_t_ltequalto_7y) {
			this.r28_6y_lt_t_ltequalto_7y = r28_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR28_7y_lt_t_ltequalto_8y() {
			return r28_7y_lt_t_ltequalto_8y;
		}
		public void setR28_7y_lt_t_ltequalto_8y(BigDecimal r28_7y_lt_t_ltequalto_8y) {
			this.r28_7y_lt_t_ltequalto_8y = r28_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR28_8y_lt_t_ltequalto_9y() {
			return r28_8y_lt_t_ltequalto_9y;
		}
		public void setR28_8y_lt_t_ltequalto_9y(BigDecimal r28_8y_lt_t_ltequalto_9y) {
			this.r28_8y_lt_t_ltequalto_9y = r28_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR28_9y_lt_t_ltequalto_10y() {
			return r28_9y_lt_t_ltequalto_10y;
		}
		public void setR28_9y_lt_t_ltequalto_10y(BigDecimal r28_9y_lt_t_ltequalto_10y) {
			this.r28_9y_lt_t_ltequalto_10y = r28_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR28_10y_lt_t_ltequalto_15y() {
			return r28_10y_lt_t_ltequalto_15y;
		}
		public void setR28_10y_lt_t_ltequalto_15y(BigDecimal r28_10y_lt_t_ltequalto_15y) {
			this.r28_10y_lt_t_ltequalto_15y = r28_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR28_15y_lt_t_ltequalto_20y() {
			return r28_15y_lt_t_ltequalto_20y;
		}
		public void setR28_15y_lt_t_ltequalto_20y(BigDecimal r28_15y_lt_t_ltequalto_20y) {
			this.r28_15y_lt_t_ltequalto_20y = r28_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR28_tl_20y() {
			return r28_tl_20y;
		}
		public void setR28_tl_20y(BigDecimal r28_tl_20y) {
			this.r28_tl_20y = r28_tl_20y;
		}
		public BigDecimal getR28_nonsensitive() {
			return r28_nonsensitive;
		}
		public void setR28_nonsensitive(BigDecimal r28_nonsensitive) {
			this.r28_nonsensitive = r28_nonsensitive;
		}
		public BigDecimal getR28_total_rsl() {
			return r28_total_rsl;
		}
		public void setR28_total_rsl(BigDecimal r28_total_rsl) {
			this.r28_total_rsl = r28_total_rsl;
		}
		public BigDecimal getR28_total() {
			return r28_total;
		}
		public void setR28_total(BigDecimal r28_total) {
			this.r28_total = r28_total;
		}
		public String getR29_product() {
			return r29_product;
		}
		public void setR29_product(String r29_product) {
			this.r29_product = r29_product;
		}
		public BigDecimal getR29_tequalon() {
			return r29_tequalon;
		}
		public void setR29_tequalon(BigDecimal r29_tequalon) {
			this.r29_tequalon = r29_tequalon;
		}
		public BigDecimal getR29_on_t_equalto_1m() {
			return r29_on_t_equalto_1m;
		}
		public void setR29_on_t_equalto_1m(BigDecimal r29_on_t_equalto_1m) {
			this.r29_on_t_equalto_1m = r29_on_t_equalto_1m;
		}
		public BigDecimal getR29_1m_t_equalto_3m() {
			return r29_1m_t_equalto_3m;
		}
		public void setR29_1m_t_equalto_3m(BigDecimal r29_1m_t_equalto_3m) {
			this.r29_1m_t_equalto_3m = r29_1m_t_equalto_3m;
		}
		public BigDecimal getR29_3m_t_equalto_6m() {
			return r29_3m_t_equalto_6m;
		}
		public void setR29_3m_t_equalto_6m(BigDecimal r29_3m_t_equalto_6m) {
			this.r29_3m_t_equalto_6m = r29_3m_t_equalto_6m;
		}
		public BigDecimal getR29_6m_t_equalto_9m() {
			return r29_6m_t_equalto_9m;
		}
		public void setR29_6m_t_equalto_9m(BigDecimal r29_6m_t_equalto_9m) {
			this.r29_6m_t_equalto_9m = r29_6m_t_equalto_9m;
		}
		public BigDecimal getR29_9m_t_equalto_1y() {
			return r29_9m_t_equalto_1y;
		}
		public void setR29_9m_t_equalto_1y(BigDecimal r29_9m_t_equalto_1y) {
			this.r29_9m_t_equalto_1y = r29_9m_t_equalto_1y;
		}
		public BigDecimal getR29_1y_t_equalto_1point5y() {
			return r29_1y_t_equalto_1point5y;
		}
		public void setR29_1y_t_equalto_1point5y(BigDecimal r29_1y_t_equalto_1point5y) {
			this.r29_1y_t_equalto_1point5y = r29_1y_t_equalto_1point5y;
		}
		public BigDecimal getR29_1point5y_t_equalto_2y() {
			return r29_1point5y_t_equalto_2y;
		}
		public void setR29_1point5y_t_equalto_2y(BigDecimal r29_1point5y_t_equalto_2y) {
			this.r29_1point5y_t_equalto_2y = r29_1point5y_t_equalto_2y;
		}
		public BigDecimal getR29_2y_t_equalto_3y() {
			return r29_2y_t_equalto_3y;
		}
		public void setR29_2y_t_equalto_3y(BigDecimal r29_2y_t_equalto_3y) {
			this.r29_2y_t_equalto_3y = r29_2y_t_equalto_3y;
		}
		public BigDecimal getR29_3y_t_equalto_4y() {
			return r29_3y_t_equalto_4y;
		}
		public void setR29_3y_t_equalto_4y(BigDecimal r29_3y_t_equalto_4y) {
			this.r29_3y_t_equalto_4y = r29_3y_t_equalto_4y;
		}
		public BigDecimal getR29_4y_lt_t_ltequalto_5y() {
			return r29_4y_lt_t_ltequalto_5y;
		}
		public void setR29_4y_lt_t_ltequalto_5y(BigDecimal r29_4y_lt_t_ltequalto_5y) {
			this.r29_4y_lt_t_ltequalto_5y = r29_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR29_5y_lt_t_ltequalto_6y() {
			return r29_5y_lt_t_ltequalto_6y;
		}
		public void setR29_5y_lt_t_ltequalto_6y(BigDecimal r29_5y_lt_t_ltequalto_6y) {
			this.r29_5y_lt_t_ltequalto_6y = r29_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR29_6y_lt_t_ltequalto_7y() {
			return r29_6y_lt_t_ltequalto_7y;
		}
		public void setR29_6y_lt_t_ltequalto_7y(BigDecimal r29_6y_lt_t_ltequalto_7y) {
			this.r29_6y_lt_t_ltequalto_7y = r29_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR29_7y_lt_t_ltequalto_8y() {
			return r29_7y_lt_t_ltequalto_8y;
		}
		public void setR29_7y_lt_t_ltequalto_8y(BigDecimal r29_7y_lt_t_ltequalto_8y) {
			this.r29_7y_lt_t_ltequalto_8y = r29_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR29_8y_lt_t_ltequalto_9y() {
			return r29_8y_lt_t_ltequalto_9y;
		}
		public void setR29_8y_lt_t_ltequalto_9y(BigDecimal r29_8y_lt_t_ltequalto_9y) {
			this.r29_8y_lt_t_ltequalto_9y = r29_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR29_9y_lt_t_ltequalto_10y() {
			return r29_9y_lt_t_ltequalto_10y;
		}
		public void setR29_9y_lt_t_ltequalto_10y(BigDecimal r29_9y_lt_t_ltequalto_10y) {
			this.r29_9y_lt_t_ltequalto_10y = r29_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR29_10y_lt_t_ltequalto_15y() {
			return r29_10y_lt_t_ltequalto_15y;
		}
		public void setR29_10y_lt_t_ltequalto_15y(BigDecimal r29_10y_lt_t_ltequalto_15y) {
			this.r29_10y_lt_t_ltequalto_15y = r29_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR29_15y_lt_t_ltequalto_20y() {
			return r29_15y_lt_t_ltequalto_20y;
		}
		public void setR29_15y_lt_t_ltequalto_20y(BigDecimal r29_15y_lt_t_ltequalto_20y) {
			this.r29_15y_lt_t_ltequalto_20y = r29_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR29_tl_20y() {
			return r29_tl_20y;
		}
		public void setR29_tl_20y(BigDecimal r29_tl_20y) {
			this.r29_tl_20y = r29_tl_20y;
		}
		public BigDecimal getR29_nonsensitive() {
			return r29_nonsensitive;
		}
		public void setR29_nonsensitive(BigDecimal r29_nonsensitive) {
			this.r29_nonsensitive = r29_nonsensitive;
		}
		public BigDecimal getR29_total_rsl() {
			return r29_total_rsl;
		}
		public void setR29_total_rsl(BigDecimal r29_total_rsl) {
			this.r29_total_rsl = r29_total_rsl;
		}
		public BigDecimal getR29_total() {
			return r29_total;
		}
		public void setR29_total(BigDecimal r29_total) {
			this.r29_total = r29_total;
		}
		public String getR30_product() {
			return r30_product;
		}
		public void setR30_product(String r30_product) {
			this.r30_product = r30_product;
		}
		public BigDecimal getR30_tequalon() {
			return r30_tequalon;
		}
		public void setR30_tequalon(BigDecimal r30_tequalon) {
			this.r30_tequalon = r30_tequalon;
		}
		public BigDecimal getR30_on_t_equalto_1m() {
			return r30_on_t_equalto_1m;
		}
		public void setR30_on_t_equalto_1m(BigDecimal r30_on_t_equalto_1m) {
			this.r30_on_t_equalto_1m = r30_on_t_equalto_1m;
		}
		public BigDecimal getR30_1m_t_equalto_3m() {
			return r30_1m_t_equalto_3m;
		}
		public void setR30_1m_t_equalto_3m(BigDecimal r30_1m_t_equalto_3m) {
			this.r30_1m_t_equalto_3m = r30_1m_t_equalto_3m;
		}
		public BigDecimal getR30_3m_t_equalto_6m() {
			return r30_3m_t_equalto_6m;
		}
		public void setR30_3m_t_equalto_6m(BigDecimal r30_3m_t_equalto_6m) {
			this.r30_3m_t_equalto_6m = r30_3m_t_equalto_6m;
		}
		public BigDecimal getR30_6m_t_equalto_9m() {
			return r30_6m_t_equalto_9m;
		}
		public void setR30_6m_t_equalto_9m(BigDecimal r30_6m_t_equalto_9m) {
			this.r30_6m_t_equalto_9m = r30_6m_t_equalto_9m;
		}
		public BigDecimal getR30_9m_t_equalto_1y() {
			return r30_9m_t_equalto_1y;
		}
		public void setR30_9m_t_equalto_1y(BigDecimal r30_9m_t_equalto_1y) {
			this.r30_9m_t_equalto_1y = r30_9m_t_equalto_1y;
		}
		public BigDecimal getR30_1y_t_equalto_1point5y() {
			return r30_1y_t_equalto_1point5y;
		}
		public void setR30_1y_t_equalto_1point5y(BigDecimal r30_1y_t_equalto_1point5y) {
			this.r30_1y_t_equalto_1point5y = r30_1y_t_equalto_1point5y;
		}
		public BigDecimal getR30_1point5y_t_equalto_2y() {
			return r30_1point5y_t_equalto_2y;
		}
		public void setR30_1point5y_t_equalto_2y(BigDecimal r30_1point5y_t_equalto_2y) {
			this.r30_1point5y_t_equalto_2y = r30_1point5y_t_equalto_2y;
		}
		public BigDecimal getR30_2y_t_equalto_3y() {
			return r30_2y_t_equalto_3y;
		}
		public void setR30_2y_t_equalto_3y(BigDecimal r30_2y_t_equalto_3y) {
			this.r30_2y_t_equalto_3y = r30_2y_t_equalto_3y;
		}
		public BigDecimal getR30_3y_t_equalto_4y() {
			return r30_3y_t_equalto_4y;
		}
		public void setR30_3y_t_equalto_4y(BigDecimal r30_3y_t_equalto_4y) {
			this.r30_3y_t_equalto_4y = r30_3y_t_equalto_4y;
		}
		public BigDecimal getR30_4y_lt_t_ltequalto_5y() {
			return r30_4y_lt_t_ltequalto_5y;
		}
		public void setR30_4y_lt_t_ltequalto_5y(BigDecimal r30_4y_lt_t_ltequalto_5y) {
			this.r30_4y_lt_t_ltequalto_5y = r30_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR30_5y_lt_t_ltequalto_6y() {
			return r30_5y_lt_t_ltequalto_6y;
		}
		public void setR30_5y_lt_t_ltequalto_6y(BigDecimal r30_5y_lt_t_ltequalto_6y) {
			this.r30_5y_lt_t_ltequalto_6y = r30_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR30_6y_lt_t_ltequalto_7y() {
			return r30_6y_lt_t_ltequalto_7y;
		}
		public void setR30_6y_lt_t_ltequalto_7y(BigDecimal r30_6y_lt_t_ltequalto_7y) {
			this.r30_6y_lt_t_ltequalto_7y = r30_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR30_7y_lt_t_ltequalto_8y() {
			return r30_7y_lt_t_ltequalto_8y;
		}
		public void setR30_7y_lt_t_ltequalto_8y(BigDecimal r30_7y_lt_t_ltequalto_8y) {
			this.r30_7y_lt_t_ltequalto_8y = r30_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR30_8y_lt_t_ltequalto_9y() {
			return r30_8y_lt_t_ltequalto_9y;
		}
		public void setR30_8y_lt_t_ltequalto_9y(BigDecimal r30_8y_lt_t_ltequalto_9y) {
			this.r30_8y_lt_t_ltequalto_9y = r30_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR30_9y_lt_t_ltequalto_10y() {
			return r30_9y_lt_t_ltequalto_10y;
		}
		public void setR30_9y_lt_t_ltequalto_10y(BigDecimal r30_9y_lt_t_ltequalto_10y) {
			this.r30_9y_lt_t_ltequalto_10y = r30_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR30_10y_lt_t_ltequalto_15y() {
			return r30_10y_lt_t_ltequalto_15y;
		}
		public void setR30_10y_lt_t_ltequalto_15y(BigDecimal r30_10y_lt_t_ltequalto_15y) {
			this.r30_10y_lt_t_ltequalto_15y = r30_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR30_15y_lt_t_ltequalto_20y() {
			return r30_15y_lt_t_ltequalto_20y;
		}
		public void setR30_15y_lt_t_ltequalto_20y(BigDecimal r30_15y_lt_t_ltequalto_20y) {
			this.r30_15y_lt_t_ltequalto_20y = r30_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR30_tl_20y() {
			return r30_tl_20y;
		}
		public void setR30_tl_20y(BigDecimal r30_tl_20y) {
			this.r30_tl_20y = r30_tl_20y;
		}
		public BigDecimal getR30_nonsensitive() {
			return r30_nonsensitive;
		}
		public void setR30_nonsensitive(BigDecimal r30_nonsensitive) {
			this.r30_nonsensitive = r30_nonsensitive;
		}
		public BigDecimal getR30_total_rsl() {
			return r30_total_rsl;
		}
		public void setR30_total_rsl(BigDecimal r30_total_rsl) {
			this.r30_total_rsl = r30_total_rsl;
		}
		public BigDecimal getR30_total() {
			return r30_total;
		}
		public void setR30_total(BigDecimal r30_total) {
			this.r30_total = r30_total;
		}
		public String getR31_product() {
			return r31_product;
		}
		public void setR31_product(String r31_product) {
			this.r31_product = r31_product;
		}
		public BigDecimal getR31_tequalon() {
			return r31_tequalon;
		}
		public void setR31_tequalon(BigDecimal r31_tequalon) {
			this.r31_tequalon = r31_tequalon;
		}
		public BigDecimal getR31_on_t_equalto_1m() {
			return r31_on_t_equalto_1m;
		}
		public void setR31_on_t_equalto_1m(BigDecimal r31_on_t_equalto_1m) {
			this.r31_on_t_equalto_1m = r31_on_t_equalto_1m;
		}
		public BigDecimal getR31_1m_t_equalto_3m() {
			return r31_1m_t_equalto_3m;
		}
		public void setR31_1m_t_equalto_3m(BigDecimal r31_1m_t_equalto_3m) {
			this.r31_1m_t_equalto_3m = r31_1m_t_equalto_3m;
		}
		public BigDecimal getR31_3m_t_equalto_6m() {
			return r31_3m_t_equalto_6m;
		}
		public void setR31_3m_t_equalto_6m(BigDecimal r31_3m_t_equalto_6m) {
			this.r31_3m_t_equalto_6m = r31_3m_t_equalto_6m;
		}
		public BigDecimal getR31_6m_t_equalto_9m() {
			return r31_6m_t_equalto_9m;
		}
		public void setR31_6m_t_equalto_9m(BigDecimal r31_6m_t_equalto_9m) {
			this.r31_6m_t_equalto_9m = r31_6m_t_equalto_9m;
		}
		public BigDecimal getR31_9m_t_equalto_1y() {
			return r31_9m_t_equalto_1y;
		}
		public void setR31_9m_t_equalto_1y(BigDecimal r31_9m_t_equalto_1y) {
			this.r31_9m_t_equalto_1y = r31_9m_t_equalto_1y;
		}
		public BigDecimal getR31_1y_t_equalto_1point5y() {
			return r31_1y_t_equalto_1point5y;
		}
		public void setR31_1y_t_equalto_1point5y(BigDecimal r31_1y_t_equalto_1point5y) {
			this.r31_1y_t_equalto_1point5y = r31_1y_t_equalto_1point5y;
		}
		public BigDecimal getR31_1point5y_t_equalto_2y() {
			return r31_1point5y_t_equalto_2y;
		}
		public void setR31_1point5y_t_equalto_2y(BigDecimal r31_1point5y_t_equalto_2y) {
			this.r31_1point5y_t_equalto_2y = r31_1point5y_t_equalto_2y;
		}
		public BigDecimal getR31_2y_t_equalto_3y() {
			return r31_2y_t_equalto_3y;
		}
		public void setR31_2y_t_equalto_3y(BigDecimal r31_2y_t_equalto_3y) {
			this.r31_2y_t_equalto_3y = r31_2y_t_equalto_3y;
		}
		public BigDecimal getR31_3y_t_equalto_4y() {
			return r31_3y_t_equalto_4y;
		}
		public void setR31_3y_t_equalto_4y(BigDecimal r31_3y_t_equalto_4y) {
			this.r31_3y_t_equalto_4y = r31_3y_t_equalto_4y;
		}
		public BigDecimal getR31_4y_lt_t_ltequalto_5y() {
			return r31_4y_lt_t_ltequalto_5y;
		}
		public void setR31_4y_lt_t_ltequalto_5y(BigDecimal r31_4y_lt_t_ltequalto_5y) {
			this.r31_4y_lt_t_ltequalto_5y = r31_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR31_5y_lt_t_ltequalto_6y() {
			return r31_5y_lt_t_ltequalto_6y;
		}
		public void setR31_5y_lt_t_ltequalto_6y(BigDecimal r31_5y_lt_t_ltequalto_6y) {
			this.r31_5y_lt_t_ltequalto_6y = r31_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR31_6y_lt_t_ltequalto_7y() {
			return r31_6y_lt_t_ltequalto_7y;
		}
		public void setR31_6y_lt_t_ltequalto_7y(BigDecimal r31_6y_lt_t_ltequalto_7y) {
			this.r31_6y_lt_t_ltequalto_7y = r31_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR31_7y_lt_t_ltequalto_8y() {
			return r31_7y_lt_t_ltequalto_8y;
		}
		public void setR31_7y_lt_t_ltequalto_8y(BigDecimal r31_7y_lt_t_ltequalto_8y) {
			this.r31_7y_lt_t_ltequalto_8y = r31_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR31_8y_lt_t_ltequalto_9y() {
			return r31_8y_lt_t_ltequalto_9y;
		}
		public void setR31_8y_lt_t_ltequalto_9y(BigDecimal r31_8y_lt_t_ltequalto_9y) {
			this.r31_8y_lt_t_ltequalto_9y = r31_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR31_9y_lt_t_ltequalto_10y() {
			return r31_9y_lt_t_ltequalto_10y;
		}
		public void setR31_9y_lt_t_ltequalto_10y(BigDecimal r31_9y_lt_t_ltequalto_10y) {
			this.r31_9y_lt_t_ltequalto_10y = r31_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR31_10y_lt_t_ltequalto_15y() {
			return r31_10y_lt_t_ltequalto_15y;
		}
		public void setR31_10y_lt_t_ltequalto_15y(BigDecimal r31_10y_lt_t_ltequalto_15y) {
			this.r31_10y_lt_t_ltequalto_15y = r31_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR31_15y_lt_t_ltequalto_20y() {
			return r31_15y_lt_t_ltequalto_20y;
		}
		public void setR31_15y_lt_t_ltequalto_20y(BigDecimal r31_15y_lt_t_ltequalto_20y) {
			this.r31_15y_lt_t_ltequalto_20y = r31_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR31_tl_20y() {
			return r31_tl_20y;
		}
		public void setR31_tl_20y(BigDecimal r31_tl_20y) {
			this.r31_tl_20y = r31_tl_20y;
		}
		public BigDecimal getR31_nonsensitive() {
			return r31_nonsensitive;
		}
		public void setR31_nonsensitive(BigDecimal r31_nonsensitive) {
			this.r31_nonsensitive = r31_nonsensitive;
		}
		public BigDecimal getR31_total_rsl() {
			return r31_total_rsl;
		}
		public void setR31_total_rsl(BigDecimal r31_total_rsl) {
			this.r31_total_rsl = r31_total_rsl;
		}
		public BigDecimal getR31_total() {
			return r31_total;
		}
		public void setR31_total(BigDecimal r31_total) {
			this.r31_total = r31_total;
		}
		public String getR32_product() {
			return r32_product;
		}
		public void setR32_product(String r32_product) {
			this.r32_product = r32_product;
		}
		public BigDecimal getR32_tequalon() {
			return r32_tequalon;
		}
		public void setR32_tequalon(BigDecimal r32_tequalon) {
			this.r32_tequalon = r32_tequalon;
		}
		public BigDecimal getR32_on_t_equalto_1m() {
			return r32_on_t_equalto_1m;
		}
		public void setR32_on_t_equalto_1m(BigDecimal r32_on_t_equalto_1m) {
			this.r32_on_t_equalto_1m = r32_on_t_equalto_1m;
		}
		public BigDecimal getR32_1m_t_equalto_3m() {
			return r32_1m_t_equalto_3m;
		}
		public void setR32_1m_t_equalto_3m(BigDecimal r32_1m_t_equalto_3m) {
			this.r32_1m_t_equalto_3m = r32_1m_t_equalto_3m;
		}
		public BigDecimal getR32_3m_t_equalto_6m() {
			return r32_3m_t_equalto_6m;
		}
		public void setR32_3m_t_equalto_6m(BigDecimal r32_3m_t_equalto_6m) {
			this.r32_3m_t_equalto_6m = r32_3m_t_equalto_6m;
		}
		public BigDecimal getR32_6m_t_equalto_9m() {
			return r32_6m_t_equalto_9m;
		}
		public void setR32_6m_t_equalto_9m(BigDecimal r32_6m_t_equalto_9m) {
			this.r32_6m_t_equalto_9m = r32_6m_t_equalto_9m;
		}
		public BigDecimal getR32_9m_t_equalto_1y() {
			return r32_9m_t_equalto_1y;
		}
		public void setR32_9m_t_equalto_1y(BigDecimal r32_9m_t_equalto_1y) {
			this.r32_9m_t_equalto_1y = r32_9m_t_equalto_1y;
		}
		public BigDecimal getR32_1y_t_equalto_1point5y() {
			return r32_1y_t_equalto_1point5y;
		}
		public void setR32_1y_t_equalto_1point5y(BigDecimal r32_1y_t_equalto_1point5y) {
			this.r32_1y_t_equalto_1point5y = r32_1y_t_equalto_1point5y;
		}
		public BigDecimal getR32_1point5y_t_equalto_2y() {
			return r32_1point5y_t_equalto_2y;
		}
		public void setR32_1point5y_t_equalto_2y(BigDecimal r32_1point5y_t_equalto_2y) {
			this.r32_1point5y_t_equalto_2y = r32_1point5y_t_equalto_2y;
		}
		public BigDecimal getR32_2y_t_equalto_3y() {
			return r32_2y_t_equalto_3y;
		}
		public void setR32_2y_t_equalto_3y(BigDecimal r32_2y_t_equalto_3y) {
			this.r32_2y_t_equalto_3y = r32_2y_t_equalto_3y;
		}
		public BigDecimal getR32_3y_t_equalto_4y() {
			return r32_3y_t_equalto_4y;
		}
		public void setR32_3y_t_equalto_4y(BigDecimal r32_3y_t_equalto_4y) {
			this.r32_3y_t_equalto_4y = r32_3y_t_equalto_4y;
		}
		public BigDecimal getR32_4y_lt_t_ltequalto_5y() {
			return r32_4y_lt_t_ltequalto_5y;
		}
		public void setR32_4y_lt_t_ltequalto_5y(BigDecimal r32_4y_lt_t_ltequalto_5y) {
			this.r32_4y_lt_t_ltequalto_5y = r32_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR32_5y_lt_t_ltequalto_6y() {
			return r32_5y_lt_t_ltequalto_6y;
		}
		public void setR32_5y_lt_t_ltequalto_6y(BigDecimal r32_5y_lt_t_ltequalto_6y) {
			this.r32_5y_lt_t_ltequalto_6y = r32_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR32_6y_lt_t_ltequalto_7y() {
			return r32_6y_lt_t_ltequalto_7y;
		}
		public void setR32_6y_lt_t_ltequalto_7y(BigDecimal r32_6y_lt_t_ltequalto_7y) {
			this.r32_6y_lt_t_ltequalto_7y = r32_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR32_7y_lt_t_ltequalto_8y() {
			return r32_7y_lt_t_ltequalto_8y;
		}
		public void setR32_7y_lt_t_ltequalto_8y(BigDecimal r32_7y_lt_t_ltequalto_8y) {
			this.r32_7y_lt_t_ltequalto_8y = r32_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR32_8y_lt_t_ltequalto_9y() {
			return r32_8y_lt_t_ltequalto_9y;
		}
		public void setR32_8y_lt_t_ltequalto_9y(BigDecimal r32_8y_lt_t_ltequalto_9y) {
			this.r32_8y_lt_t_ltequalto_9y = r32_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR32_9y_lt_t_ltequalto_10y() {
			return r32_9y_lt_t_ltequalto_10y;
		}
		public void setR32_9y_lt_t_ltequalto_10y(BigDecimal r32_9y_lt_t_ltequalto_10y) {
			this.r32_9y_lt_t_ltequalto_10y = r32_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR32_10y_lt_t_ltequalto_15y() {
			return r32_10y_lt_t_ltequalto_15y;
		}
		public void setR32_10y_lt_t_ltequalto_15y(BigDecimal r32_10y_lt_t_ltequalto_15y) {
			this.r32_10y_lt_t_ltequalto_15y = r32_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR32_15y_lt_t_ltequalto_20y() {
			return r32_15y_lt_t_ltequalto_20y;
		}
		public void setR32_15y_lt_t_ltequalto_20y(BigDecimal r32_15y_lt_t_ltequalto_20y) {
			this.r32_15y_lt_t_ltequalto_20y = r32_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR32_tl_20y() {
			return r32_tl_20y;
		}
		public void setR32_tl_20y(BigDecimal r32_tl_20y) {
			this.r32_tl_20y = r32_tl_20y;
		}
		public BigDecimal getR32_nonsensitive() {
			return r32_nonsensitive;
		}
		public void setR32_nonsensitive(BigDecimal r32_nonsensitive) {
			this.r32_nonsensitive = r32_nonsensitive;
		}
		public BigDecimal getR32_total_rsl() {
			return r32_total_rsl;
		}
		public void setR32_total_rsl(BigDecimal r32_total_rsl) {
			this.r32_total_rsl = r32_total_rsl;
		}
		public BigDecimal getR32_total() {
			return r32_total;
		}
		public void setR32_total(BigDecimal r32_total) {
			this.r32_total = r32_total;
		}
		public String getR33_product() {
			return r33_product;
		}
		public void setR33_product(String r33_product) {
			this.r33_product = r33_product;
		}
		public BigDecimal getR33_tequalon() {
			return r33_tequalon;
		}
		public void setR33_tequalon(BigDecimal r33_tequalon) {
			this.r33_tequalon = r33_tequalon;
		}
		public BigDecimal getR33_on_t_equalto_1m() {
			return r33_on_t_equalto_1m;
		}
		public void setR33_on_t_equalto_1m(BigDecimal r33_on_t_equalto_1m) {
			this.r33_on_t_equalto_1m = r33_on_t_equalto_1m;
		}
		public BigDecimal getR33_1m_t_equalto_3m() {
			return r33_1m_t_equalto_3m;
		}
		public void setR33_1m_t_equalto_3m(BigDecimal r33_1m_t_equalto_3m) {
			this.r33_1m_t_equalto_3m = r33_1m_t_equalto_3m;
		}
		public BigDecimal getR33_3m_t_equalto_6m() {
			return r33_3m_t_equalto_6m;
		}
		public void setR33_3m_t_equalto_6m(BigDecimal r33_3m_t_equalto_6m) {
			this.r33_3m_t_equalto_6m = r33_3m_t_equalto_6m;
		}
		public BigDecimal getR33_6m_t_equalto_9m() {
			return r33_6m_t_equalto_9m;
		}
		public void setR33_6m_t_equalto_9m(BigDecimal r33_6m_t_equalto_9m) {
			this.r33_6m_t_equalto_9m = r33_6m_t_equalto_9m;
		}
		public BigDecimal getR33_9m_t_equalto_1y() {
			return r33_9m_t_equalto_1y;
		}
		public void setR33_9m_t_equalto_1y(BigDecimal r33_9m_t_equalto_1y) {
			this.r33_9m_t_equalto_1y = r33_9m_t_equalto_1y;
		}
		public BigDecimal getR33_1y_t_equalto_1point5y() {
			return r33_1y_t_equalto_1point5y;
		}
		public void setR33_1y_t_equalto_1point5y(BigDecimal r33_1y_t_equalto_1point5y) {
			this.r33_1y_t_equalto_1point5y = r33_1y_t_equalto_1point5y;
		}
		public BigDecimal getR33_1point5y_t_equalto_2y() {
			return r33_1point5y_t_equalto_2y;
		}
		public void setR33_1point5y_t_equalto_2y(BigDecimal r33_1point5y_t_equalto_2y) {
			this.r33_1point5y_t_equalto_2y = r33_1point5y_t_equalto_2y;
		}
		public BigDecimal getR33_2y_t_equalto_3y() {
			return r33_2y_t_equalto_3y;
		}
		public void setR33_2y_t_equalto_3y(BigDecimal r33_2y_t_equalto_3y) {
			this.r33_2y_t_equalto_3y = r33_2y_t_equalto_3y;
		}
		public BigDecimal getR33_3y_t_equalto_4y() {
			return r33_3y_t_equalto_4y;
		}
		public void setR33_3y_t_equalto_4y(BigDecimal r33_3y_t_equalto_4y) {
			this.r33_3y_t_equalto_4y = r33_3y_t_equalto_4y;
		}
		public BigDecimal getR33_4y_lt_t_ltequalto_5y() {
			return r33_4y_lt_t_ltequalto_5y;
		}
		public void setR33_4y_lt_t_ltequalto_5y(BigDecimal r33_4y_lt_t_ltequalto_5y) {
			this.r33_4y_lt_t_ltequalto_5y = r33_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR33_5y_lt_t_ltequalto_6y() {
			return r33_5y_lt_t_ltequalto_6y;
		}
		public void setR33_5y_lt_t_ltequalto_6y(BigDecimal r33_5y_lt_t_ltequalto_6y) {
			this.r33_5y_lt_t_ltequalto_6y = r33_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR33_6y_lt_t_ltequalto_7y() {
			return r33_6y_lt_t_ltequalto_7y;
		}
		public void setR33_6y_lt_t_ltequalto_7y(BigDecimal r33_6y_lt_t_ltequalto_7y) {
			this.r33_6y_lt_t_ltequalto_7y = r33_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR33_7y_lt_t_ltequalto_8y() {
			return r33_7y_lt_t_ltequalto_8y;
		}
		public void setR33_7y_lt_t_ltequalto_8y(BigDecimal r33_7y_lt_t_ltequalto_8y) {
			this.r33_7y_lt_t_ltequalto_8y = r33_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR33_8y_lt_t_ltequalto_9y() {
			return r33_8y_lt_t_ltequalto_9y;
		}
		public void setR33_8y_lt_t_ltequalto_9y(BigDecimal r33_8y_lt_t_ltequalto_9y) {
			this.r33_8y_lt_t_ltequalto_9y = r33_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR33_9y_lt_t_ltequalto_10y() {
			return r33_9y_lt_t_ltequalto_10y;
		}
		public void setR33_9y_lt_t_ltequalto_10y(BigDecimal r33_9y_lt_t_ltequalto_10y) {
			this.r33_9y_lt_t_ltequalto_10y = r33_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR33_10y_lt_t_ltequalto_15y() {
			return r33_10y_lt_t_ltequalto_15y;
		}
		public void setR33_10y_lt_t_ltequalto_15y(BigDecimal r33_10y_lt_t_ltequalto_15y) {
			this.r33_10y_lt_t_ltequalto_15y = r33_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR33_15y_lt_t_ltequalto_20y() {
			return r33_15y_lt_t_ltequalto_20y;
		}
		public void setR33_15y_lt_t_ltequalto_20y(BigDecimal r33_15y_lt_t_ltequalto_20y) {
			this.r33_15y_lt_t_ltequalto_20y = r33_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR33_tl_20y() {
			return r33_tl_20y;
		}
		public void setR33_tl_20y(BigDecimal r33_tl_20y) {
			this.r33_tl_20y = r33_tl_20y;
		}
		public BigDecimal getR33_nonsensitive() {
			return r33_nonsensitive;
		}
		public void setR33_nonsensitive(BigDecimal r33_nonsensitive) {
			this.r33_nonsensitive = r33_nonsensitive;
		}
		public BigDecimal getR33_total_rsl() {
			return r33_total_rsl;
		}
		public void setR33_total_rsl(BigDecimal r33_total_rsl) {
			this.r33_total_rsl = r33_total_rsl;
		}
		public BigDecimal getR33_total() {
			return r33_total;
		}
		public void setR33_total(BigDecimal r33_total) {
			this.r33_total = r33_total;
		}
		public String getR34_product() {
			return r34_product;
		}
		public void setR34_product(String r34_product) {
			this.r34_product = r34_product;
		}
		public BigDecimal getR34_tequalon() {
			return r34_tequalon;
		}
		public void setR34_tequalon(BigDecimal r34_tequalon) {
			this.r34_tequalon = r34_tequalon;
		}
		public BigDecimal getR34_on_t_equalto_1m() {
			return r34_on_t_equalto_1m;
		}
		public void setR34_on_t_equalto_1m(BigDecimal r34_on_t_equalto_1m) {
			this.r34_on_t_equalto_1m = r34_on_t_equalto_1m;
		}
		public BigDecimal getR34_1m_t_equalto_3m() {
			return r34_1m_t_equalto_3m;
		}
		public void setR34_1m_t_equalto_3m(BigDecimal r34_1m_t_equalto_3m) {
			this.r34_1m_t_equalto_3m = r34_1m_t_equalto_3m;
		}
		public BigDecimal getR34_3m_t_equalto_6m() {
			return r34_3m_t_equalto_6m;
		}
		public void setR34_3m_t_equalto_6m(BigDecimal r34_3m_t_equalto_6m) {
			this.r34_3m_t_equalto_6m = r34_3m_t_equalto_6m;
		}
		public BigDecimal getR34_6m_t_equalto_9m() {
			return r34_6m_t_equalto_9m;
		}
		public void setR34_6m_t_equalto_9m(BigDecimal r34_6m_t_equalto_9m) {
			this.r34_6m_t_equalto_9m = r34_6m_t_equalto_9m;
		}
		public BigDecimal getR34_9m_t_equalto_1y() {
			return r34_9m_t_equalto_1y;
		}
		public void setR34_9m_t_equalto_1y(BigDecimal r34_9m_t_equalto_1y) {
			this.r34_9m_t_equalto_1y = r34_9m_t_equalto_1y;
		}
		public BigDecimal getR34_1y_t_equalto_1point5y() {
			return r34_1y_t_equalto_1point5y;
		}
		public void setR34_1y_t_equalto_1point5y(BigDecimal r34_1y_t_equalto_1point5y) {
			this.r34_1y_t_equalto_1point5y = r34_1y_t_equalto_1point5y;
		}
		public BigDecimal getR34_1point5y_t_equalto_2y() {
			return r34_1point5y_t_equalto_2y;
		}
		public void setR34_1point5y_t_equalto_2y(BigDecimal r34_1point5y_t_equalto_2y) {
			this.r34_1point5y_t_equalto_2y = r34_1point5y_t_equalto_2y;
		}
		public BigDecimal getR34_2y_t_equalto_3y() {
			return r34_2y_t_equalto_3y;
		}
		public void setR34_2y_t_equalto_3y(BigDecimal r34_2y_t_equalto_3y) {
			this.r34_2y_t_equalto_3y = r34_2y_t_equalto_3y;
		}
		public BigDecimal getR34_3y_t_equalto_4y() {
			return r34_3y_t_equalto_4y;
		}
		public void setR34_3y_t_equalto_4y(BigDecimal r34_3y_t_equalto_4y) {
			this.r34_3y_t_equalto_4y = r34_3y_t_equalto_4y;
		}
		public BigDecimal getR34_4y_lt_t_ltequalto_5y() {
			return r34_4y_lt_t_ltequalto_5y;
		}
		public void setR34_4y_lt_t_ltequalto_5y(BigDecimal r34_4y_lt_t_ltequalto_5y) {
			this.r34_4y_lt_t_ltequalto_5y = r34_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR34_5y_lt_t_ltequalto_6y() {
			return r34_5y_lt_t_ltequalto_6y;
		}
		public void setR34_5y_lt_t_ltequalto_6y(BigDecimal r34_5y_lt_t_ltequalto_6y) {
			this.r34_5y_lt_t_ltequalto_6y = r34_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR34_6y_lt_t_ltequalto_7y() {
			return r34_6y_lt_t_ltequalto_7y;
		}
		public void setR34_6y_lt_t_ltequalto_7y(BigDecimal r34_6y_lt_t_ltequalto_7y) {
			this.r34_6y_lt_t_ltequalto_7y = r34_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR34_7y_lt_t_ltequalto_8y() {
			return r34_7y_lt_t_ltequalto_8y;
		}
		public void setR34_7y_lt_t_ltequalto_8y(BigDecimal r34_7y_lt_t_ltequalto_8y) {
			this.r34_7y_lt_t_ltequalto_8y = r34_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR34_8y_lt_t_ltequalto_9y() {
			return r34_8y_lt_t_ltequalto_9y;
		}
		public void setR34_8y_lt_t_ltequalto_9y(BigDecimal r34_8y_lt_t_ltequalto_9y) {
			this.r34_8y_lt_t_ltequalto_9y = r34_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR34_9y_lt_t_ltequalto_10y() {
			return r34_9y_lt_t_ltequalto_10y;
		}
		public void setR34_9y_lt_t_ltequalto_10y(BigDecimal r34_9y_lt_t_ltequalto_10y) {
			this.r34_9y_lt_t_ltequalto_10y = r34_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR34_10y_lt_t_ltequalto_15y() {
			return r34_10y_lt_t_ltequalto_15y;
		}
		public void setR34_10y_lt_t_ltequalto_15y(BigDecimal r34_10y_lt_t_ltequalto_15y) {
			this.r34_10y_lt_t_ltequalto_15y = r34_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR34_15y_lt_t_ltequalto_20y() {
			return r34_15y_lt_t_ltequalto_20y;
		}
		public void setR34_15y_lt_t_ltequalto_20y(BigDecimal r34_15y_lt_t_ltequalto_20y) {
			this.r34_15y_lt_t_ltequalto_20y = r34_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR34_tl_20y() {
			return r34_tl_20y;
		}
		public void setR34_tl_20y(BigDecimal r34_tl_20y) {
			this.r34_tl_20y = r34_tl_20y;
		}
		public BigDecimal getR34_nonsensitive() {
			return r34_nonsensitive;
		}
		public void setR34_nonsensitive(BigDecimal r34_nonsensitive) {
			this.r34_nonsensitive = r34_nonsensitive;
		}
		public BigDecimal getR34_total_rsl() {
			return r34_total_rsl;
		}
		public void setR34_total_rsl(BigDecimal r34_total_rsl) {
			this.r34_total_rsl = r34_total_rsl;
		}
		public BigDecimal getR34_total() {
			return r34_total;
		}
		public void setR34_total(BigDecimal r34_total) {
			this.r34_total = r34_total;
		}
		public String getR35_product() {
			return r35_product;
		}
		public void setR35_product(String r35_product) {
			this.r35_product = r35_product;
		}
		public BigDecimal getR35_tequalon() {
			return r35_tequalon;
		}
		public void setR35_tequalon(BigDecimal r35_tequalon) {
			this.r35_tequalon = r35_tequalon;
		}
		public BigDecimal getR35_on_t_equalto_1m() {
			return r35_on_t_equalto_1m;
		}
		public void setR35_on_t_equalto_1m(BigDecimal r35_on_t_equalto_1m) {
			this.r35_on_t_equalto_1m = r35_on_t_equalto_1m;
		}
		public BigDecimal getR35_1m_t_equalto_3m() {
			return r35_1m_t_equalto_3m;
		}
		public void setR35_1m_t_equalto_3m(BigDecimal r35_1m_t_equalto_3m) {
			this.r35_1m_t_equalto_3m = r35_1m_t_equalto_3m;
		}
		public BigDecimal getR35_3m_t_equalto_6m() {
			return r35_3m_t_equalto_6m;
		}
		public void setR35_3m_t_equalto_6m(BigDecimal r35_3m_t_equalto_6m) {
			this.r35_3m_t_equalto_6m = r35_3m_t_equalto_6m;
		}
		public BigDecimal getR35_6m_t_equalto_9m() {
			return r35_6m_t_equalto_9m;
		}
		public void setR35_6m_t_equalto_9m(BigDecimal r35_6m_t_equalto_9m) {
			this.r35_6m_t_equalto_9m = r35_6m_t_equalto_9m;
		}
		public BigDecimal getR35_9m_t_equalto_1y() {
			return r35_9m_t_equalto_1y;
		}
		public void setR35_9m_t_equalto_1y(BigDecimal r35_9m_t_equalto_1y) {
			this.r35_9m_t_equalto_1y = r35_9m_t_equalto_1y;
		}
		public BigDecimal getR35_1y_t_equalto_1point5y() {
			return r35_1y_t_equalto_1point5y;
		}
		public void setR35_1y_t_equalto_1point5y(BigDecimal r35_1y_t_equalto_1point5y) {
			this.r35_1y_t_equalto_1point5y = r35_1y_t_equalto_1point5y;
		}
		public BigDecimal getR35_1point5y_t_equalto_2y() {
			return r35_1point5y_t_equalto_2y;
		}
		public void setR35_1point5y_t_equalto_2y(BigDecimal r35_1point5y_t_equalto_2y) {
			this.r35_1point5y_t_equalto_2y = r35_1point5y_t_equalto_2y;
		}
		public BigDecimal getR35_2y_t_equalto_3y() {
			return r35_2y_t_equalto_3y;
		}
		public void setR35_2y_t_equalto_3y(BigDecimal r35_2y_t_equalto_3y) {
			this.r35_2y_t_equalto_3y = r35_2y_t_equalto_3y;
		}
		public BigDecimal getR35_3y_t_equalto_4y() {
			return r35_3y_t_equalto_4y;
		}
		public void setR35_3y_t_equalto_4y(BigDecimal r35_3y_t_equalto_4y) {
			this.r35_3y_t_equalto_4y = r35_3y_t_equalto_4y;
		}
		public BigDecimal getR35_4y_lt_t_ltequalto_5y() {
			return r35_4y_lt_t_ltequalto_5y;
		}
		public void setR35_4y_lt_t_ltequalto_5y(BigDecimal r35_4y_lt_t_ltequalto_5y) {
			this.r35_4y_lt_t_ltequalto_5y = r35_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR35_5y_lt_t_ltequalto_6y() {
			return r35_5y_lt_t_ltequalto_6y;
		}
		public void setR35_5y_lt_t_ltequalto_6y(BigDecimal r35_5y_lt_t_ltequalto_6y) {
			this.r35_5y_lt_t_ltequalto_6y = r35_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR35_6y_lt_t_ltequalto_7y() {
			return r35_6y_lt_t_ltequalto_7y;
		}
		public void setR35_6y_lt_t_ltequalto_7y(BigDecimal r35_6y_lt_t_ltequalto_7y) {
			this.r35_6y_lt_t_ltequalto_7y = r35_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR35_7y_lt_t_ltequalto_8y() {
			return r35_7y_lt_t_ltequalto_8y;
		}
		public void setR35_7y_lt_t_ltequalto_8y(BigDecimal r35_7y_lt_t_ltequalto_8y) {
			this.r35_7y_lt_t_ltequalto_8y = r35_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR35_8y_lt_t_ltequalto_9y() {
			return r35_8y_lt_t_ltequalto_9y;
		}
		public void setR35_8y_lt_t_ltequalto_9y(BigDecimal r35_8y_lt_t_ltequalto_9y) {
			this.r35_8y_lt_t_ltequalto_9y = r35_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR35_9y_lt_t_ltequalto_10y() {
			return r35_9y_lt_t_ltequalto_10y;
		}
		public void setR35_9y_lt_t_ltequalto_10y(BigDecimal r35_9y_lt_t_ltequalto_10y) {
			this.r35_9y_lt_t_ltequalto_10y = r35_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR35_10y_lt_t_ltequalto_15y() {
			return r35_10y_lt_t_ltequalto_15y;
		}
		public void setR35_10y_lt_t_ltequalto_15y(BigDecimal r35_10y_lt_t_ltequalto_15y) {
			this.r35_10y_lt_t_ltequalto_15y = r35_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR35_15y_lt_t_ltequalto_20y() {
			return r35_15y_lt_t_ltequalto_20y;
		}
		public void setR35_15y_lt_t_ltequalto_20y(BigDecimal r35_15y_lt_t_ltequalto_20y) {
			this.r35_15y_lt_t_ltequalto_20y = r35_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR35_tl_20y() {
			return r35_tl_20y;
		}
		public void setR35_tl_20y(BigDecimal r35_tl_20y) {
			this.r35_tl_20y = r35_tl_20y;
		}
		public BigDecimal getR35_nonsensitive() {
			return r35_nonsensitive;
		}
		public void setR35_nonsensitive(BigDecimal r35_nonsensitive) {
			this.r35_nonsensitive = r35_nonsensitive;
		}
		public BigDecimal getR35_total_rsl() {
			return r35_total_rsl;
		}
		public void setR35_total_rsl(BigDecimal r35_total_rsl) {
			this.r35_total_rsl = r35_total_rsl;
		}
		public BigDecimal getR35_total() {
			return r35_total;
		}
		public void setR35_total(BigDecimal r35_total) {
			this.r35_total = r35_total;
		}
		public String getR36_product() {
			return r36_product;
		}
		public void setR36_product(String r36_product) {
			this.r36_product = r36_product;
		}
		public BigDecimal getR36_tequalon() {
			return r36_tequalon;
		}
		public void setR36_tequalon(BigDecimal r36_tequalon) {
			this.r36_tequalon = r36_tequalon;
		}
		public BigDecimal getR36_on_t_equalto_1m() {
			return r36_on_t_equalto_1m;
		}
		public void setR36_on_t_equalto_1m(BigDecimal r36_on_t_equalto_1m) {
			this.r36_on_t_equalto_1m = r36_on_t_equalto_1m;
		}
		public BigDecimal getR36_1m_t_equalto_3m() {
			return r36_1m_t_equalto_3m;
		}
		public void setR36_1m_t_equalto_3m(BigDecimal r36_1m_t_equalto_3m) {
			this.r36_1m_t_equalto_3m = r36_1m_t_equalto_3m;
		}
		public BigDecimal getR36_3m_t_equalto_6m() {
			return r36_3m_t_equalto_6m;
		}
		public void setR36_3m_t_equalto_6m(BigDecimal r36_3m_t_equalto_6m) {
			this.r36_3m_t_equalto_6m = r36_3m_t_equalto_6m;
		}
		public BigDecimal getR36_6m_t_equalto_9m() {
			return r36_6m_t_equalto_9m;
		}
		public void setR36_6m_t_equalto_9m(BigDecimal r36_6m_t_equalto_9m) {
			this.r36_6m_t_equalto_9m = r36_6m_t_equalto_9m;
		}
		public BigDecimal getR36_9m_t_equalto_1y() {
			return r36_9m_t_equalto_1y;
		}
		public void setR36_9m_t_equalto_1y(BigDecimal r36_9m_t_equalto_1y) {
			this.r36_9m_t_equalto_1y = r36_9m_t_equalto_1y;
		}
		public BigDecimal getR36_1y_t_equalto_1point5y() {
			return r36_1y_t_equalto_1point5y;
		}
		public void setR36_1y_t_equalto_1point5y(BigDecimal r36_1y_t_equalto_1point5y) {
			this.r36_1y_t_equalto_1point5y = r36_1y_t_equalto_1point5y;
		}
		public BigDecimal getR36_1point5y_t_equalto_2y() {
			return r36_1point5y_t_equalto_2y;
		}
		public void setR36_1point5y_t_equalto_2y(BigDecimal r36_1point5y_t_equalto_2y) {
			this.r36_1point5y_t_equalto_2y = r36_1point5y_t_equalto_2y;
		}
		public BigDecimal getR36_2y_t_equalto_3y() {
			return r36_2y_t_equalto_3y;
		}
		public void setR36_2y_t_equalto_3y(BigDecimal r36_2y_t_equalto_3y) {
			this.r36_2y_t_equalto_3y = r36_2y_t_equalto_3y;
		}
		public BigDecimal getR36_3y_t_equalto_4y() {
			return r36_3y_t_equalto_4y;
		}
		public void setR36_3y_t_equalto_4y(BigDecimal r36_3y_t_equalto_4y) {
			this.r36_3y_t_equalto_4y = r36_3y_t_equalto_4y;
		}
		public BigDecimal getR36_4y_lt_t_ltequalto_5y() {
			return r36_4y_lt_t_ltequalto_5y;
		}
		public void setR36_4y_lt_t_ltequalto_5y(BigDecimal r36_4y_lt_t_ltequalto_5y) {
			this.r36_4y_lt_t_ltequalto_5y = r36_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR36_5y_lt_t_ltequalto_6y() {
			return r36_5y_lt_t_ltequalto_6y;
		}
		public void setR36_5y_lt_t_ltequalto_6y(BigDecimal r36_5y_lt_t_ltequalto_6y) {
			this.r36_5y_lt_t_ltequalto_6y = r36_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR36_6y_lt_t_ltequalto_7y() {
			return r36_6y_lt_t_ltequalto_7y;
		}
		public void setR36_6y_lt_t_ltequalto_7y(BigDecimal r36_6y_lt_t_ltequalto_7y) {
			this.r36_6y_lt_t_ltequalto_7y = r36_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR36_7y_lt_t_ltequalto_8y() {
			return r36_7y_lt_t_ltequalto_8y;
		}
		public void setR36_7y_lt_t_ltequalto_8y(BigDecimal r36_7y_lt_t_ltequalto_8y) {
			this.r36_7y_lt_t_ltequalto_8y = r36_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR36_8y_lt_t_ltequalto_9y() {
			return r36_8y_lt_t_ltequalto_9y;
		}
		public void setR36_8y_lt_t_ltequalto_9y(BigDecimal r36_8y_lt_t_ltequalto_9y) {
			this.r36_8y_lt_t_ltequalto_9y = r36_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR36_9y_lt_t_ltequalto_10y() {
			return r36_9y_lt_t_ltequalto_10y;
		}
		public void setR36_9y_lt_t_ltequalto_10y(BigDecimal r36_9y_lt_t_ltequalto_10y) {
			this.r36_9y_lt_t_ltequalto_10y = r36_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR36_10y_lt_t_ltequalto_15y() {
			return r36_10y_lt_t_ltequalto_15y;
		}
		public void setR36_10y_lt_t_ltequalto_15y(BigDecimal r36_10y_lt_t_ltequalto_15y) {
			this.r36_10y_lt_t_ltequalto_15y = r36_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR36_15y_lt_t_ltequalto_20y() {
			return r36_15y_lt_t_ltequalto_20y;
		}
		public void setR36_15y_lt_t_ltequalto_20y(BigDecimal r36_15y_lt_t_ltequalto_20y) {
			this.r36_15y_lt_t_ltequalto_20y = r36_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR36_tl_20y() {
			return r36_tl_20y;
		}
		public void setR36_tl_20y(BigDecimal r36_tl_20y) {
			this.r36_tl_20y = r36_tl_20y;
		}
		public BigDecimal getR36_nonsensitive() {
			return r36_nonsensitive;
		}
		public void setR36_nonsensitive(BigDecimal r36_nonsensitive) {
			this.r36_nonsensitive = r36_nonsensitive;
		}
		public BigDecimal getR36_total_rsl() {
			return r36_total_rsl;
		}
		public void setR36_total_rsl(BigDecimal r36_total_rsl) {
			this.r36_total_rsl = r36_total_rsl;
		}
		public BigDecimal getR36_total() {
			return r36_total;
		}
		public void setR36_total(BigDecimal r36_total) {
			this.r36_total = r36_total;
		}
		public String getR37_product() {
			return r37_product;
		}
		public void setR37_product(String r37_product) {
			this.r37_product = r37_product;
		}
		public BigDecimal getR37_tequalon() {
			return r37_tequalon;
		}
		public void setR37_tequalon(BigDecimal r37_tequalon) {
			this.r37_tequalon = r37_tequalon;
		}
		public BigDecimal getR37_on_t_equalto_1m() {
			return r37_on_t_equalto_1m;
		}
		public void setR37_on_t_equalto_1m(BigDecimal r37_on_t_equalto_1m) {
			this.r37_on_t_equalto_1m = r37_on_t_equalto_1m;
		}
		public BigDecimal getR37_1m_t_equalto_3m() {
			return r37_1m_t_equalto_3m;
		}
		public void setR37_1m_t_equalto_3m(BigDecimal r37_1m_t_equalto_3m) {
			this.r37_1m_t_equalto_3m = r37_1m_t_equalto_3m;
		}
		public BigDecimal getR37_3m_t_equalto_6m() {
			return r37_3m_t_equalto_6m;
		}
		public void setR37_3m_t_equalto_6m(BigDecimal r37_3m_t_equalto_6m) {
			this.r37_3m_t_equalto_6m = r37_3m_t_equalto_6m;
		}
		public BigDecimal getR37_6m_t_equalto_9m() {
			return r37_6m_t_equalto_9m;
		}
		public void setR37_6m_t_equalto_9m(BigDecimal r37_6m_t_equalto_9m) {
			this.r37_6m_t_equalto_9m = r37_6m_t_equalto_9m;
		}
		public BigDecimal getR37_9m_t_equalto_1y() {
			return r37_9m_t_equalto_1y;
		}
		public void setR37_9m_t_equalto_1y(BigDecimal r37_9m_t_equalto_1y) {
			this.r37_9m_t_equalto_1y = r37_9m_t_equalto_1y;
		}
		public BigDecimal getR37_1y_t_equalto_1point5y() {
			return r37_1y_t_equalto_1point5y;
		}
		public void setR37_1y_t_equalto_1point5y(BigDecimal r37_1y_t_equalto_1point5y) {
			this.r37_1y_t_equalto_1point5y = r37_1y_t_equalto_1point5y;
		}
		public BigDecimal getR37_1point5y_t_equalto_2y() {
			return r37_1point5y_t_equalto_2y;
		}
		public void setR37_1point5y_t_equalto_2y(BigDecimal r37_1point5y_t_equalto_2y) {
			this.r37_1point5y_t_equalto_2y = r37_1point5y_t_equalto_2y;
		}
		public BigDecimal getR37_2y_t_equalto_3y() {
			return r37_2y_t_equalto_3y;
		}
		public void setR37_2y_t_equalto_3y(BigDecimal r37_2y_t_equalto_3y) {
			this.r37_2y_t_equalto_3y = r37_2y_t_equalto_3y;
		}
		public BigDecimal getR37_3y_t_equalto_4y() {
			return r37_3y_t_equalto_4y;
		}
		public void setR37_3y_t_equalto_4y(BigDecimal r37_3y_t_equalto_4y) {
			this.r37_3y_t_equalto_4y = r37_3y_t_equalto_4y;
		}
		public BigDecimal getR37_4y_lt_t_ltequalto_5y() {
			return r37_4y_lt_t_ltequalto_5y;
		}
		public void setR37_4y_lt_t_ltequalto_5y(BigDecimal r37_4y_lt_t_ltequalto_5y) {
			this.r37_4y_lt_t_ltequalto_5y = r37_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR37_5y_lt_t_ltequalto_6y() {
			return r37_5y_lt_t_ltequalto_6y;
		}
		public void setR37_5y_lt_t_ltequalto_6y(BigDecimal r37_5y_lt_t_ltequalto_6y) {
			this.r37_5y_lt_t_ltequalto_6y = r37_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR37_6y_lt_t_ltequalto_7y() {
			return r37_6y_lt_t_ltequalto_7y;
		}
		public void setR37_6y_lt_t_ltequalto_7y(BigDecimal r37_6y_lt_t_ltequalto_7y) {
			this.r37_6y_lt_t_ltequalto_7y = r37_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR37_7y_lt_t_ltequalto_8y() {
			return r37_7y_lt_t_ltequalto_8y;
		}
		public void setR37_7y_lt_t_ltequalto_8y(BigDecimal r37_7y_lt_t_ltequalto_8y) {
			this.r37_7y_lt_t_ltequalto_8y = r37_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR37_8y_lt_t_ltequalto_9y() {
			return r37_8y_lt_t_ltequalto_9y;
		}
		public void setR37_8y_lt_t_ltequalto_9y(BigDecimal r37_8y_lt_t_ltequalto_9y) {
			this.r37_8y_lt_t_ltequalto_9y = r37_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR37_9y_lt_t_ltequalto_10y() {
			return r37_9y_lt_t_ltequalto_10y;
		}
		public void setR37_9y_lt_t_ltequalto_10y(BigDecimal r37_9y_lt_t_ltequalto_10y) {
			this.r37_9y_lt_t_ltequalto_10y = r37_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR37_10y_lt_t_ltequalto_15y() {
			return r37_10y_lt_t_ltequalto_15y;
		}
		public void setR37_10y_lt_t_ltequalto_15y(BigDecimal r37_10y_lt_t_ltequalto_15y) {
			this.r37_10y_lt_t_ltequalto_15y = r37_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR37_15y_lt_t_ltequalto_20y() {
			return r37_15y_lt_t_ltequalto_20y;
		}
		public void setR37_15y_lt_t_ltequalto_20y(BigDecimal r37_15y_lt_t_ltequalto_20y) {
			this.r37_15y_lt_t_ltequalto_20y = r37_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR37_tl_20y() {
			return r37_tl_20y;
		}
		public void setR37_tl_20y(BigDecimal r37_tl_20y) {
			this.r37_tl_20y = r37_tl_20y;
		}
		public BigDecimal getR37_nonsensitive() {
			return r37_nonsensitive;
		}
		public void setR37_nonsensitive(BigDecimal r37_nonsensitive) {
			this.r37_nonsensitive = r37_nonsensitive;
		}
		public BigDecimal getR37_total_rsl() {
			return r37_total_rsl;
		}
		public void setR37_total_rsl(BigDecimal r37_total_rsl) {
			this.r37_total_rsl = r37_total_rsl;
		}
		public BigDecimal getR37_total() {
			return r37_total;
		}
		public void setR37_total(BigDecimal r37_total) {
			this.r37_total = r37_total;
		}
		public String getR38_product() {
			return r38_product;
		}
		public void setR38_product(String r38_product) {
			this.r38_product = r38_product;
		}
		public BigDecimal getR38_tequalon() {
			return r38_tequalon;
		}
		public void setR38_tequalon(BigDecimal r38_tequalon) {
			this.r38_tequalon = r38_tequalon;
		}
		public BigDecimal getR38_on_t_equalto_1m() {
			return r38_on_t_equalto_1m;
		}
		public void setR38_on_t_equalto_1m(BigDecimal r38_on_t_equalto_1m) {
			this.r38_on_t_equalto_1m = r38_on_t_equalto_1m;
		}
		public BigDecimal getR38_1m_t_equalto_3m() {
			return r38_1m_t_equalto_3m;
		}
		public void setR38_1m_t_equalto_3m(BigDecimal r38_1m_t_equalto_3m) {
			this.r38_1m_t_equalto_3m = r38_1m_t_equalto_3m;
		}
		public BigDecimal getR38_3m_t_equalto_6m() {
			return r38_3m_t_equalto_6m;
		}
		public void setR38_3m_t_equalto_6m(BigDecimal r38_3m_t_equalto_6m) {
			this.r38_3m_t_equalto_6m = r38_3m_t_equalto_6m;
		}
		public BigDecimal getR38_6m_t_equalto_9m() {
			return r38_6m_t_equalto_9m;
		}
		public void setR38_6m_t_equalto_9m(BigDecimal r38_6m_t_equalto_9m) {
			this.r38_6m_t_equalto_9m = r38_6m_t_equalto_9m;
		}
		public BigDecimal getR38_9m_t_equalto_1y() {
			return r38_9m_t_equalto_1y;
		}
		public void setR38_9m_t_equalto_1y(BigDecimal r38_9m_t_equalto_1y) {
			this.r38_9m_t_equalto_1y = r38_9m_t_equalto_1y;
		}
		public BigDecimal getR38_1y_t_equalto_1point5y() {
			return r38_1y_t_equalto_1point5y;
		}
		public void setR38_1y_t_equalto_1point5y(BigDecimal r38_1y_t_equalto_1point5y) {
			this.r38_1y_t_equalto_1point5y = r38_1y_t_equalto_1point5y;
		}
		public BigDecimal getR38_1point5y_t_equalto_2y() {
			return r38_1point5y_t_equalto_2y;
		}
		public void setR38_1point5y_t_equalto_2y(BigDecimal r38_1point5y_t_equalto_2y) {
			this.r38_1point5y_t_equalto_2y = r38_1point5y_t_equalto_2y;
		}
		public BigDecimal getR38_2y_t_equalto_3y() {
			return r38_2y_t_equalto_3y;
		}
		public void setR38_2y_t_equalto_3y(BigDecimal r38_2y_t_equalto_3y) {
			this.r38_2y_t_equalto_3y = r38_2y_t_equalto_3y;
		}
		public BigDecimal getR38_3y_t_equalto_4y() {
			return r38_3y_t_equalto_4y;
		}
		public void setR38_3y_t_equalto_4y(BigDecimal r38_3y_t_equalto_4y) {
			this.r38_3y_t_equalto_4y = r38_3y_t_equalto_4y;
		}
		public BigDecimal getR38_4y_lt_t_ltequalto_5y() {
			return r38_4y_lt_t_ltequalto_5y;
		}
		public void setR38_4y_lt_t_ltequalto_5y(BigDecimal r38_4y_lt_t_ltequalto_5y) {
			this.r38_4y_lt_t_ltequalto_5y = r38_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR38_5y_lt_t_ltequalto_6y() {
			return r38_5y_lt_t_ltequalto_6y;
		}
		public void setR38_5y_lt_t_ltequalto_6y(BigDecimal r38_5y_lt_t_ltequalto_6y) {
			this.r38_5y_lt_t_ltequalto_6y = r38_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR38_6y_lt_t_ltequalto_7y() {
			return r38_6y_lt_t_ltequalto_7y;
		}
		public void setR38_6y_lt_t_ltequalto_7y(BigDecimal r38_6y_lt_t_ltequalto_7y) {
			this.r38_6y_lt_t_ltequalto_7y = r38_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR38_7y_lt_t_ltequalto_8y() {
			return r38_7y_lt_t_ltequalto_8y;
		}
		public void setR38_7y_lt_t_ltequalto_8y(BigDecimal r38_7y_lt_t_ltequalto_8y) {
			this.r38_7y_lt_t_ltequalto_8y = r38_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR38_8y_lt_t_ltequalto_9y() {
			return r38_8y_lt_t_ltequalto_9y;
		}
		public void setR38_8y_lt_t_ltequalto_9y(BigDecimal r38_8y_lt_t_ltequalto_9y) {
			this.r38_8y_lt_t_ltequalto_9y = r38_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR38_9y_lt_t_ltequalto_10y() {
			return r38_9y_lt_t_ltequalto_10y;
		}
		public void setR38_9y_lt_t_ltequalto_10y(BigDecimal r38_9y_lt_t_ltequalto_10y) {
			this.r38_9y_lt_t_ltequalto_10y = r38_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR38_10y_lt_t_ltequalto_15y() {
			return r38_10y_lt_t_ltequalto_15y;
		}
		public void setR38_10y_lt_t_ltequalto_15y(BigDecimal r38_10y_lt_t_ltequalto_15y) {
			this.r38_10y_lt_t_ltequalto_15y = r38_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR38_15y_lt_t_ltequalto_20y() {
			return r38_15y_lt_t_ltequalto_20y;
		}
		public void setR38_15y_lt_t_ltequalto_20y(BigDecimal r38_15y_lt_t_ltequalto_20y) {
			this.r38_15y_lt_t_ltequalto_20y = r38_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR38_tl_20y() {
			return r38_tl_20y;
		}
		public void setR38_tl_20y(BigDecimal r38_tl_20y) {
			this.r38_tl_20y = r38_tl_20y;
		}
		public BigDecimal getR38_nonsensitive() {
			return r38_nonsensitive;
		}
		public void setR38_nonsensitive(BigDecimal r38_nonsensitive) {
			this.r38_nonsensitive = r38_nonsensitive;
		}
		public BigDecimal getR38_total_rsl() {
			return r38_total_rsl;
		}
		public void setR38_total_rsl(BigDecimal r38_total_rsl) {
			this.r38_total_rsl = r38_total_rsl;
		}
		public BigDecimal getR38_total() {
			return r38_total;
		}
		public void setR38_total(BigDecimal r38_total) {
			this.r38_total = r38_total;
		}
		public String getR39_product() {
			return r39_product;
		}
		public void setR39_product(String r39_product) {
			this.r39_product = r39_product;
		}
		public BigDecimal getR39_tequalon() {
			return r39_tequalon;
		}
		public void setR39_tequalon(BigDecimal r39_tequalon) {
			this.r39_tequalon = r39_tequalon;
		}
		public BigDecimal getR39_on_t_equalto_1m() {
			return r39_on_t_equalto_1m;
		}
		public void setR39_on_t_equalto_1m(BigDecimal r39_on_t_equalto_1m) {
			this.r39_on_t_equalto_1m = r39_on_t_equalto_1m;
		}
		public BigDecimal getR39_1m_t_equalto_3m() {
			return r39_1m_t_equalto_3m;
		}
		public void setR39_1m_t_equalto_3m(BigDecimal r39_1m_t_equalto_3m) {
			this.r39_1m_t_equalto_3m = r39_1m_t_equalto_3m;
		}
		public BigDecimal getR39_3m_t_equalto_6m() {
			return r39_3m_t_equalto_6m;
		}
		public void setR39_3m_t_equalto_6m(BigDecimal r39_3m_t_equalto_6m) {
			this.r39_3m_t_equalto_6m = r39_3m_t_equalto_6m;
		}
		public BigDecimal getR39_6m_t_equalto_9m() {
			return r39_6m_t_equalto_9m;
		}
		public void setR39_6m_t_equalto_9m(BigDecimal r39_6m_t_equalto_9m) {
			this.r39_6m_t_equalto_9m = r39_6m_t_equalto_9m;
		}
		public BigDecimal getR39_9m_t_equalto_1y() {
			return r39_9m_t_equalto_1y;
		}
		public void setR39_9m_t_equalto_1y(BigDecimal r39_9m_t_equalto_1y) {
			this.r39_9m_t_equalto_1y = r39_9m_t_equalto_1y;
		}
		public BigDecimal getR39_1y_t_equalto_1point5y() {
			return r39_1y_t_equalto_1point5y;
		}
		public void setR39_1y_t_equalto_1point5y(BigDecimal r39_1y_t_equalto_1point5y) {
			this.r39_1y_t_equalto_1point5y = r39_1y_t_equalto_1point5y;
		}
		public BigDecimal getR39_1point5y_t_equalto_2y() {
			return r39_1point5y_t_equalto_2y;
		}
		public void setR39_1point5y_t_equalto_2y(BigDecimal r39_1point5y_t_equalto_2y) {
			this.r39_1point5y_t_equalto_2y = r39_1point5y_t_equalto_2y;
		}
		public BigDecimal getR39_2y_t_equalto_3y() {
			return r39_2y_t_equalto_3y;
		}
		public void setR39_2y_t_equalto_3y(BigDecimal r39_2y_t_equalto_3y) {
			this.r39_2y_t_equalto_3y = r39_2y_t_equalto_3y;
		}
		public BigDecimal getR39_3y_t_equalto_4y() {
			return r39_3y_t_equalto_4y;
		}
		public void setR39_3y_t_equalto_4y(BigDecimal r39_3y_t_equalto_4y) {
			this.r39_3y_t_equalto_4y = r39_3y_t_equalto_4y;
		}
		public BigDecimal getR39_4y_lt_t_ltequalto_5y() {
			return r39_4y_lt_t_ltequalto_5y;
		}
		public void setR39_4y_lt_t_ltequalto_5y(BigDecimal r39_4y_lt_t_ltequalto_5y) {
			this.r39_4y_lt_t_ltequalto_5y = r39_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR39_5y_lt_t_ltequalto_6y() {
			return r39_5y_lt_t_ltequalto_6y;
		}
		public void setR39_5y_lt_t_ltequalto_6y(BigDecimal r39_5y_lt_t_ltequalto_6y) {
			this.r39_5y_lt_t_ltequalto_6y = r39_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR39_6y_lt_t_ltequalto_7y() {
			return r39_6y_lt_t_ltequalto_7y;
		}
		public void setR39_6y_lt_t_ltequalto_7y(BigDecimal r39_6y_lt_t_ltequalto_7y) {
			this.r39_6y_lt_t_ltequalto_7y = r39_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR39_7y_lt_t_ltequalto_8y() {
			return r39_7y_lt_t_ltequalto_8y;
		}
		public void setR39_7y_lt_t_ltequalto_8y(BigDecimal r39_7y_lt_t_ltequalto_8y) {
			this.r39_7y_lt_t_ltequalto_8y = r39_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR39_8y_lt_t_ltequalto_9y() {
			return r39_8y_lt_t_ltequalto_9y;
		}
		public void setR39_8y_lt_t_ltequalto_9y(BigDecimal r39_8y_lt_t_ltequalto_9y) {
			this.r39_8y_lt_t_ltequalto_9y = r39_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR39_9y_lt_t_ltequalto_10y() {
			return r39_9y_lt_t_ltequalto_10y;
		}
		public void setR39_9y_lt_t_ltequalto_10y(BigDecimal r39_9y_lt_t_ltequalto_10y) {
			this.r39_9y_lt_t_ltequalto_10y = r39_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR39_10y_lt_t_ltequalto_15y() {
			return r39_10y_lt_t_ltequalto_15y;
		}
		public void setR39_10y_lt_t_ltequalto_15y(BigDecimal r39_10y_lt_t_ltequalto_15y) {
			this.r39_10y_lt_t_ltequalto_15y = r39_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR39_15y_lt_t_ltequalto_20y() {
			return r39_15y_lt_t_ltequalto_20y;
		}
		public void setR39_15y_lt_t_ltequalto_20y(BigDecimal r39_15y_lt_t_ltequalto_20y) {
			this.r39_15y_lt_t_ltequalto_20y = r39_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR39_tl_20y() {
			return r39_tl_20y;
		}
		public void setR39_tl_20y(BigDecimal r39_tl_20y) {
			this.r39_tl_20y = r39_tl_20y;
		}
		public BigDecimal getR39_nonsensitive() {
			return r39_nonsensitive;
		}
		public void setR39_nonsensitive(BigDecimal r39_nonsensitive) {
			this.r39_nonsensitive = r39_nonsensitive;
		}
		public BigDecimal getR39_total_rsl() {
			return r39_total_rsl;
		}
		public void setR39_total_rsl(BigDecimal r39_total_rsl) {
			this.r39_total_rsl = r39_total_rsl;
		}
		public BigDecimal getR39_total() {
			return r39_total;
		}
		public void setR39_total(BigDecimal r39_total) {
			this.r39_total = r39_total;
		}
		public String getR40_product() {
			return r40_product;
		}
		public void setR40_product(String r40_product) {
			this.r40_product = r40_product;
		}
		public BigDecimal getR40_tequalon() {
			return r40_tequalon;
		}
		public void setR40_tequalon(BigDecimal r40_tequalon) {
			this.r40_tequalon = r40_tequalon;
		}
		public BigDecimal getR40_on_t_equalto_1m() {
			return r40_on_t_equalto_1m;
		}
		public void setR40_on_t_equalto_1m(BigDecimal r40_on_t_equalto_1m) {
			this.r40_on_t_equalto_1m = r40_on_t_equalto_1m;
		}
		public BigDecimal getR40_1m_t_equalto_3m() {
			return r40_1m_t_equalto_3m;
		}
		public void setR40_1m_t_equalto_3m(BigDecimal r40_1m_t_equalto_3m) {
			this.r40_1m_t_equalto_3m = r40_1m_t_equalto_3m;
		}
		public BigDecimal getR40_3m_t_equalto_6m() {
			return r40_3m_t_equalto_6m;
		}
		public void setR40_3m_t_equalto_6m(BigDecimal r40_3m_t_equalto_6m) {
			this.r40_3m_t_equalto_6m = r40_3m_t_equalto_6m;
		}
		public BigDecimal getR40_6m_t_equalto_9m() {
			return r40_6m_t_equalto_9m;
		}
		public void setR40_6m_t_equalto_9m(BigDecimal r40_6m_t_equalto_9m) {
			this.r40_6m_t_equalto_9m = r40_6m_t_equalto_9m;
		}
		public BigDecimal getR40_9m_t_equalto_1y() {
			return r40_9m_t_equalto_1y;
		}
		public void setR40_9m_t_equalto_1y(BigDecimal r40_9m_t_equalto_1y) {
			this.r40_9m_t_equalto_1y = r40_9m_t_equalto_1y;
		}
		public BigDecimal getR40_1y_t_equalto_1point5y() {
			return r40_1y_t_equalto_1point5y;
		}
		public void setR40_1y_t_equalto_1point5y(BigDecimal r40_1y_t_equalto_1point5y) {
			this.r40_1y_t_equalto_1point5y = r40_1y_t_equalto_1point5y;
		}
		public BigDecimal getR40_1point5y_t_equalto_2y() {
			return r40_1point5y_t_equalto_2y;
		}
		public void setR40_1point5y_t_equalto_2y(BigDecimal r40_1point5y_t_equalto_2y) {
			this.r40_1point5y_t_equalto_2y = r40_1point5y_t_equalto_2y;
		}
		public BigDecimal getR40_2y_t_equalto_3y() {
			return r40_2y_t_equalto_3y;
		}
		public void setR40_2y_t_equalto_3y(BigDecimal r40_2y_t_equalto_3y) {
			this.r40_2y_t_equalto_3y = r40_2y_t_equalto_3y;
		}
		public BigDecimal getR40_3y_t_equalto_4y() {
			return r40_3y_t_equalto_4y;
		}
		public void setR40_3y_t_equalto_4y(BigDecimal r40_3y_t_equalto_4y) {
			this.r40_3y_t_equalto_4y = r40_3y_t_equalto_4y;
		}
		public BigDecimal getR40_4y_lt_t_ltequalto_5y() {
			return r40_4y_lt_t_ltequalto_5y;
		}
		public void setR40_4y_lt_t_ltequalto_5y(BigDecimal r40_4y_lt_t_ltequalto_5y) {
			this.r40_4y_lt_t_ltequalto_5y = r40_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR40_5y_lt_t_ltequalto_6y() {
			return r40_5y_lt_t_ltequalto_6y;
		}
		public void setR40_5y_lt_t_ltequalto_6y(BigDecimal r40_5y_lt_t_ltequalto_6y) {
			this.r40_5y_lt_t_ltequalto_6y = r40_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR40_6y_lt_t_ltequalto_7y() {
			return r40_6y_lt_t_ltequalto_7y;
		}
		public void setR40_6y_lt_t_ltequalto_7y(BigDecimal r40_6y_lt_t_ltequalto_7y) {
			this.r40_6y_lt_t_ltequalto_7y = r40_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR40_7y_lt_t_ltequalto_8y() {
			return r40_7y_lt_t_ltequalto_8y;
		}
		public void setR40_7y_lt_t_ltequalto_8y(BigDecimal r40_7y_lt_t_ltequalto_8y) {
			this.r40_7y_lt_t_ltequalto_8y = r40_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR40_8y_lt_t_ltequalto_9y() {
			return r40_8y_lt_t_ltequalto_9y;
		}
		public void setR40_8y_lt_t_ltequalto_9y(BigDecimal r40_8y_lt_t_ltequalto_9y) {
			this.r40_8y_lt_t_ltequalto_9y = r40_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR40_9y_lt_t_ltequalto_10y() {
			return r40_9y_lt_t_ltequalto_10y;
		}
		public void setR40_9y_lt_t_ltequalto_10y(BigDecimal r40_9y_lt_t_ltequalto_10y) {
			this.r40_9y_lt_t_ltequalto_10y = r40_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR40_10y_lt_t_ltequalto_15y() {
			return r40_10y_lt_t_ltequalto_15y;
		}
		public void setR40_10y_lt_t_ltequalto_15y(BigDecimal r40_10y_lt_t_ltequalto_15y) {
			this.r40_10y_lt_t_ltequalto_15y = r40_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR40_15y_lt_t_ltequalto_20y() {
			return r40_15y_lt_t_ltequalto_20y;
		}
		public void setR40_15y_lt_t_ltequalto_20y(BigDecimal r40_15y_lt_t_ltequalto_20y) {
			this.r40_15y_lt_t_ltequalto_20y = r40_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR40_tl_20y() {
			return r40_tl_20y;
		}
		public void setR40_tl_20y(BigDecimal r40_tl_20y) {
			this.r40_tl_20y = r40_tl_20y;
		}
		public BigDecimal getR40_nonsensitive() {
			return r40_nonsensitive;
		}
		public void setR40_nonsensitive(BigDecimal r40_nonsensitive) {
			this.r40_nonsensitive = r40_nonsensitive;
		}
		public BigDecimal getR40_total_rsl() {
			return r40_total_rsl;
		}
		public void setR40_total_rsl(BigDecimal r40_total_rsl) {
			this.r40_total_rsl = r40_total_rsl;
		}
		public BigDecimal getR40_total() {
			return r40_total;
		}
		public void setR40_total(BigDecimal r40_total) {
			this.r40_total = r40_total;
		}
		public String getR41_product() {
			return r41_product;
		}
		public void setR41_product(String r41_product) {
			this.r41_product = r41_product;
		}
		public BigDecimal getR41_tequalon() {
			return r41_tequalon;
		}
		public void setR41_tequalon(BigDecimal r41_tequalon) {
			this.r41_tequalon = r41_tequalon;
		}
		public BigDecimal getR41_on_t_equalto_1m() {
			return r41_on_t_equalto_1m;
		}
		public void setR41_on_t_equalto_1m(BigDecimal r41_on_t_equalto_1m) {
			this.r41_on_t_equalto_1m = r41_on_t_equalto_1m;
		}
		public BigDecimal getR41_1m_t_equalto_3m() {
			return r41_1m_t_equalto_3m;
		}
		public void setR41_1m_t_equalto_3m(BigDecimal r41_1m_t_equalto_3m) {
			this.r41_1m_t_equalto_3m = r41_1m_t_equalto_3m;
		}
		public BigDecimal getR41_3m_t_equalto_6m() {
			return r41_3m_t_equalto_6m;
		}
		public void setR41_3m_t_equalto_6m(BigDecimal r41_3m_t_equalto_6m) {
			this.r41_3m_t_equalto_6m = r41_3m_t_equalto_6m;
		}
		public BigDecimal getR41_6m_t_equalto_9m() {
			return r41_6m_t_equalto_9m;
		}
		public void setR41_6m_t_equalto_9m(BigDecimal r41_6m_t_equalto_9m) {
			this.r41_6m_t_equalto_9m = r41_6m_t_equalto_9m;
		}
		public BigDecimal getR41_9m_t_equalto_1y() {
			return r41_9m_t_equalto_1y;
		}
		public void setR41_9m_t_equalto_1y(BigDecimal r41_9m_t_equalto_1y) {
			this.r41_9m_t_equalto_1y = r41_9m_t_equalto_1y;
		}
		public BigDecimal getR41_1y_t_equalto_1point5y() {
			return r41_1y_t_equalto_1point5y;
		}
		public void setR41_1y_t_equalto_1point5y(BigDecimal r41_1y_t_equalto_1point5y) {
			this.r41_1y_t_equalto_1point5y = r41_1y_t_equalto_1point5y;
		}
		public BigDecimal getR41_1point5y_t_equalto_2y() {
			return r41_1point5y_t_equalto_2y;
		}
		public void setR41_1point5y_t_equalto_2y(BigDecimal r41_1point5y_t_equalto_2y) {
			this.r41_1point5y_t_equalto_2y = r41_1point5y_t_equalto_2y;
		}
		public BigDecimal getR41_2y_t_equalto_3y() {
			return r41_2y_t_equalto_3y;
		}
		public void setR41_2y_t_equalto_3y(BigDecimal r41_2y_t_equalto_3y) {
			this.r41_2y_t_equalto_3y = r41_2y_t_equalto_3y;
		}
		public BigDecimal getR41_3y_t_equalto_4y() {
			return r41_3y_t_equalto_4y;
		}
		public void setR41_3y_t_equalto_4y(BigDecimal r41_3y_t_equalto_4y) {
			this.r41_3y_t_equalto_4y = r41_3y_t_equalto_4y;
		}
		public BigDecimal getR41_4y_lt_t_ltequalto_5y() {
			return r41_4y_lt_t_ltequalto_5y;
		}
		public void setR41_4y_lt_t_ltequalto_5y(BigDecimal r41_4y_lt_t_ltequalto_5y) {
			this.r41_4y_lt_t_ltequalto_5y = r41_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR41_5y_lt_t_ltequalto_6y() {
			return r41_5y_lt_t_ltequalto_6y;
		}
		public void setR41_5y_lt_t_ltequalto_6y(BigDecimal r41_5y_lt_t_ltequalto_6y) {
			this.r41_5y_lt_t_ltequalto_6y = r41_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR41_6y_lt_t_ltequalto_7y() {
			return r41_6y_lt_t_ltequalto_7y;
		}
		public void setR41_6y_lt_t_ltequalto_7y(BigDecimal r41_6y_lt_t_ltequalto_7y) {
			this.r41_6y_lt_t_ltequalto_7y = r41_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR41_7y_lt_t_ltequalto_8y() {
			return r41_7y_lt_t_ltequalto_8y;
		}
		public void setR41_7y_lt_t_ltequalto_8y(BigDecimal r41_7y_lt_t_ltequalto_8y) {
			this.r41_7y_lt_t_ltequalto_8y = r41_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR41_8y_lt_t_ltequalto_9y() {
			return r41_8y_lt_t_ltequalto_9y;
		}
		public void setR41_8y_lt_t_ltequalto_9y(BigDecimal r41_8y_lt_t_ltequalto_9y) {
			this.r41_8y_lt_t_ltequalto_9y = r41_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR41_9y_lt_t_ltequalto_10y() {
			return r41_9y_lt_t_ltequalto_10y;
		}
		public void setR41_9y_lt_t_ltequalto_10y(BigDecimal r41_9y_lt_t_ltequalto_10y) {
			this.r41_9y_lt_t_ltequalto_10y = r41_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR41_10y_lt_t_ltequalto_15y() {
			return r41_10y_lt_t_ltequalto_15y;
		}
		public void setR41_10y_lt_t_ltequalto_15y(BigDecimal r41_10y_lt_t_ltequalto_15y) {
			this.r41_10y_lt_t_ltequalto_15y = r41_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR41_15y_lt_t_ltequalto_20y() {
			return r41_15y_lt_t_ltequalto_20y;
		}
		public void setR41_15y_lt_t_ltequalto_20y(BigDecimal r41_15y_lt_t_ltequalto_20y) {
			this.r41_15y_lt_t_ltequalto_20y = r41_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR41_tl_20y() {
			return r41_tl_20y;
		}
		public void setR41_tl_20y(BigDecimal r41_tl_20y) {
			this.r41_tl_20y = r41_tl_20y;
		}
		public BigDecimal getR41_nonsensitive() {
			return r41_nonsensitive;
		}
		public void setR41_nonsensitive(BigDecimal r41_nonsensitive) {
			this.r41_nonsensitive = r41_nonsensitive;
		}
		public BigDecimal getR41_total_rsl() {
			return r41_total_rsl;
		}
		public void setR41_total_rsl(BigDecimal r41_total_rsl) {
			this.r41_total_rsl = r41_total_rsl;
		}
		public BigDecimal getR41_total() {
			return r41_total;
		}
		public void setR41_total(BigDecimal r41_total) {
			this.r41_total = r41_total;
		}
		public String getR42_product() {
			return r42_product;
		}
		public void setR42_product(String r42_product) {
			this.r42_product = r42_product;
		}
		public BigDecimal getR42_tequalon() {
			return r42_tequalon;
		}
		public void setR42_tequalon(BigDecimal r42_tequalon) {
			this.r42_tequalon = r42_tequalon;
		}
		public BigDecimal getR42_on_t_equalto_1m() {
			return r42_on_t_equalto_1m;
		}
		public void setR42_on_t_equalto_1m(BigDecimal r42_on_t_equalto_1m) {
			this.r42_on_t_equalto_1m = r42_on_t_equalto_1m;
		}
		public BigDecimal getR42_1m_t_equalto_3m() {
			return r42_1m_t_equalto_3m;
		}
		public void setR42_1m_t_equalto_3m(BigDecimal r42_1m_t_equalto_3m) {
			this.r42_1m_t_equalto_3m = r42_1m_t_equalto_3m;
		}
		public BigDecimal getR42_3m_t_equalto_6m() {
			return r42_3m_t_equalto_6m;
		}
		public void setR42_3m_t_equalto_6m(BigDecimal r42_3m_t_equalto_6m) {
			this.r42_3m_t_equalto_6m = r42_3m_t_equalto_6m;
		}
		public BigDecimal getR42_6m_t_equalto_9m() {
			return r42_6m_t_equalto_9m;
		}
		public void setR42_6m_t_equalto_9m(BigDecimal r42_6m_t_equalto_9m) {
			this.r42_6m_t_equalto_9m = r42_6m_t_equalto_9m;
		}
		public BigDecimal getR42_9m_t_equalto_1y() {
			return r42_9m_t_equalto_1y;
		}
		public void setR42_9m_t_equalto_1y(BigDecimal r42_9m_t_equalto_1y) {
			this.r42_9m_t_equalto_1y = r42_9m_t_equalto_1y;
		}
		public BigDecimal getR42_1y_t_equalto_1point5y() {
			return r42_1y_t_equalto_1point5y;
		}
		public void setR42_1y_t_equalto_1point5y(BigDecimal r42_1y_t_equalto_1point5y) {
			this.r42_1y_t_equalto_1point5y = r42_1y_t_equalto_1point5y;
		}
		public BigDecimal getR42_1point5y_t_equalto_2y() {
			return r42_1point5y_t_equalto_2y;
		}
		public void setR42_1point5y_t_equalto_2y(BigDecimal r42_1point5y_t_equalto_2y) {
			this.r42_1point5y_t_equalto_2y = r42_1point5y_t_equalto_2y;
		}
		public BigDecimal getR42_2y_t_equalto_3y() {
			return r42_2y_t_equalto_3y;
		}
		public void setR42_2y_t_equalto_3y(BigDecimal r42_2y_t_equalto_3y) {
			this.r42_2y_t_equalto_3y = r42_2y_t_equalto_3y;
		}
		public BigDecimal getR42_3y_t_equalto_4y() {
			return r42_3y_t_equalto_4y;
		}
		public void setR42_3y_t_equalto_4y(BigDecimal r42_3y_t_equalto_4y) {
			this.r42_3y_t_equalto_4y = r42_3y_t_equalto_4y;
		}
		public BigDecimal getR42_4y_lt_t_ltequalto_5y() {
			return r42_4y_lt_t_ltequalto_5y;
		}
		public void setR42_4y_lt_t_ltequalto_5y(BigDecimal r42_4y_lt_t_ltequalto_5y) {
			this.r42_4y_lt_t_ltequalto_5y = r42_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR42_5y_lt_t_ltequalto_6y() {
			return r42_5y_lt_t_ltequalto_6y;
		}
		public void setR42_5y_lt_t_ltequalto_6y(BigDecimal r42_5y_lt_t_ltequalto_6y) {
			this.r42_5y_lt_t_ltequalto_6y = r42_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR42_6y_lt_t_ltequalto_7y() {
			return r42_6y_lt_t_ltequalto_7y;
		}
		public void setR42_6y_lt_t_ltequalto_7y(BigDecimal r42_6y_lt_t_ltequalto_7y) {
			this.r42_6y_lt_t_ltequalto_7y = r42_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR42_7y_lt_t_ltequalto_8y() {
			return r42_7y_lt_t_ltequalto_8y;
		}
		public void setR42_7y_lt_t_ltequalto_8y(BigDecimal r42_7y_lt_t_ltequalto_8y) {
			this.r42_7y_lt_t_ltequalto_8y = r42_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR42_8y_lt_t_ltequalto_9y() {
			return r42_8y_lt_t_ltequalto_9y;
		}
		public void setR42_8y_lt_t_ltequalto_9y(BigDecimal r42_8y_lt_t_ltequalto_9y) {
			this.r42_8y_lt_t_ltequalto_9y = r42_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR42_9y_lt_t_ltequalto_10y() {
			return r42_9y_lt_t_ltequalto_10y;
		}
		public void setR42_9y_lt_t_ltequalto_10y(BigDecimal r42_9y_lt_t_ltequalto_10y) {
			this.r42_9y_lt_t_ltequalto_10y = r42_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR42_10y_lt_t_ltequalto_15y() {
			return r42_10y_lt_t_ltequalto_15y;
		}
		public void setR42_10y_lt_t_ltequalto_15y(BigDecimal r42_10y_lt_t_ltequalto_15y) {
			this.r42_10y_lt_t_ltequalto_15y = r42_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR42_15y_lt_t_ltequalto_20y() {
			return r42_15y_lt_t_ltequalto_20y;
		}
		public void setR42_15y_lt_t_ltequalto_20y(BigDecimal r42_15y_lt_t_ltequalto_20y) {
			this.r42_15y_lt_t_ltequalto_20y = r42_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR42_tl_20y() {
			return r42_tl_20y;
		}
		public void setR42_tl_20y(BigDecimal r42_tl_20y) {
			this.r42_tl_20y = r42_tl_20y;
		}
		public BigDecimal getR42_nonsensitive() {
			return r42_nonsensitive;
		}
		public void setR42_nonsensitive(BigDecimal r42_nonsensitive) {
			this.r42_nonsensitive = r42_nonsensitive;
		}
		public BigDecimal getR42_total_rsl() {
			return r42_total_rsl;
		}
		public void setR42_total_rsl(BigDecimal r42_total_rsl) {
			this.r42_total_rsl = r42_total_rsl;
		}
		public BigDecimal getR42_total() {
			return r42_total;
		}
		public void setR42_total(BigDecimal r42_total) {
			this.r42_total = r42_total;
		}
		public String getR43_product() {
			return r43_product;
		}
		public void setR43_product(String r43_product) {
			this.r43_product = r43_product;
		}
		public BigDecimal getR43_tequalon() {
			return r43_tequalon;
		}
		public void setR43_tequalon(BigDecimal r43_tequalon) {
			this.r43_tequalon = r43_tequalon;
		}
		public BigDecimal getR43_on_t_equalto_1m() {
			return r43_on_t_equalto_1m;
		}
		public void setR43_on_t_equalto_1m(BigDecimal r43_on_t_equalto_1m) {
			this.r43_on_t_equalto_1m = r43_on_t_equalto_1m;
		}
		public BigDecimal getR43_1m_t_equalto_3m() {
			return r43_1m_t_equalto_3m;
		}
		public void setR43_1m_t_equalto_3m(BigDecimal r43_1m_t_equalto_3m) {
			this.r43_1m_t_equalto_3m = r43_1m_t_equalto_3m;
		}
		public BigDecimal getR43_3m_t_equalto_6m() {
			return r43_3m_t_equalto_6m;
		}
		public void setR43_3m_t_equalto_6m(BigDecimal r43_3m_t_equalto_6m) {
			this.r43_3m_t_equalto_6m = r43_3m_t_equalto_6m;
		}
		public BigDecimal getR43_6m_t_equalto_9m() {
			return r43_6m_t_equalto_9m;
		}
		public void setR43_6m_t_equalto_9m(BigDecimal r43_6m_t_equalto_9m) {
			this.r43_6m_t_equalto_9m = r43_6m_t_equalto_9m;
		}
		public BigDecimal getR43_9m_t_equalto_1y() {
			return r43_9m_t_equalto_1y;
		}
		public void setR43_9m_t_equalto_1y(BigDecimal r43_9m_t_equalto_1y) {
			this.r43_9m_t_equalto_1y = r43_9m_t_equalto_1y;
		}
		public BigDecimal getR43_1y_t_equalto_1point5y() {
			return r43_1y_t_equalto_1point5y;
		}
		public void setR43_1y_t_equalto_1point5y(BigDecimal r43_1y_t_equalto_1point5y) {
			this.r43_1y_t_equalto_1point5y = r43_1y_t_equalto_1point5y;
		}
		public BigDecimal getR43_1point5y_t_equalto_2y() {
			return r43_1point5y_t_equalto_2y;
		}
		public void setR43_1point5y_t_equalto_2y(BigDecimal r43_1point5y_t_equalto_2y) {
			this.r43_1point5y_t_equalto_2y = r43_1point5y_t_equalto_2y;
		}
		public BigDecimal getR43_2y_t_equalto_3y() {
			return r43_2y_t_equalto_3y;
		}
		public void setR43_2y_t_equalto_3y(BigDecimal r43_2y_t_equalto_3y) {
			this.r43_2y_t_equalto_3y = r43_2y_t_equalto_3y;
		}
		public BigDecimal getR43_3y_t_equalto_4y() {
			return r43_3y_t_equalto_4y;
		}
		public void setR43_3y_t_equalto_4y(BigDecimal r43_3y_t_equalto_4y) {
			this.r43_3y_t_equalto_4y = r43_3y_t_equalto_4y;
		}
		public BigDecimal getR43_4y_lt_t_ltequalto_5y() {
			return r43_4y_lt_t_ltequalto_5y;
		}
		public void setR43_4y_lt_t_ltequalto_5y(BigDecimal r43_4y_lt_t_ltequalto_5y) {
			this.r43_4y_lt_t_ltequalto_5y = r43_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR43_5y_lt_t_ltequalto_6y() {
			return r43_5y_lt_t_ltequalto_6y;
		}
		public void setR43_5y_lt_t_ltequalto_6y(BigDecimal r43_5y_lt_t_ltequalto_6y) {
			this.r43_5y_lt_t_ltequalto_6y = r43_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR43_6y_lt_t_ltequalto_7y() {
			return r43_6y_lt_t_ltequalto_7y;
		}
		public void setR43_6y_lt_t_ltequalto_7y(BigDecimal r43_6y_lt_t_ltequalto_7y) {
			this.r43_6y_lt_t_ltequalto_7y = r43_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR43_7y_lt_t_ltequalto_8y() {
			return r43_7y_lt_t_ltequalto_8y;
		}
		public void setR43_7y_lt_t_ltequalto_8y(BigDecimal r43_7y_lt_t_ltequalto_8y) {
			this.r43_7y_lt_t_ltequalto_8y = r43_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR43_8y_lt_t_ltequalto_9y() {
			return r43_8y_lt_t_ltequalto_9y;
		}
		public void setR43_8y_lt_t_ltequalto_9y(BigDecimal r43_8y_lt_t_ltequalto_9y) {
			this.r43_8y_lt_t_ltequalto_9y = r43_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR43_9y_lt_t_ltequalto_10y() {
			return r43_9y_lt_t_ltequalto_10y;
		}
		public void setR43_9y_lt_t_ltequalto_10y(BigDecimal r43_9y_lt_t_ltequalto_10y) {
			this.r43_9y_lt_t_ltequalto_10y = r43_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR43_10y_lt_t_ltequalto_15y() {
			return r43_10y_lt_t_ltequalto_15y;
		}
		public void setR43_10y_lt_t_ltequalto_15y(BigDecimal r43_10y_lt_t_ltequalto_15y) {
			this.r43_10y_lt_t_ltequalto_15y = r43_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR43_15y_lt_t_ltequalto_20y() {
			return r43_15y_lt_t_ltequalto_20y;
		}
		public void setR43_15y_lt_t_ltequalto_20y(BigDecimal r43_15y_lt_t_ltequalto_20y) {
			this.r43_15y_lt_t_ltequalto_20y = r43_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR43_tl_20y() {
			return r43_tl_20y;
		}
		public void setR43_tl_20y(BigDecimal r43_tl_20y) {
			this.r43_tl_20y = r43_tl_20y;
		}
		public BigDecimal getR43_nonsensitive() {
			return r43_nonsensitive;
		}
		public void setR43_nonsensitive(BigDecimal r43_nonsensitive) {
			this.r43_nonsensitive = r43_nonsensitive;
		}
		public BigDecimal getR43_total_rsl() {
			return r43_total_rsl;
		}
		public void setR43_total_rsl(BigDecimal r43_total_rsl) {
			this.r43_total_rsl = r43_total_rsl;
		}
		public BigDecimal getR43_total() {
			return r43_total;
		}
		public void setR43_total(BigDecimal r43_total) {
			this.r43_total = r43_total;
		}
		public String getR44_product() {
			return r44_product;
		}
		public void setR44_product(String r44_product) {
			this.r44_product = r44_product;
		}
		public BigDecimal getR44_tequalon() {
			return r44_tequalon;
		}
		public void setR44_tequalon(BigDecimal r44_tequalon) {
			this.r44_tequalon = r44_tequalon;
		}
		public BigDecimal getR44_on_t_equalto_1m() {
			return r44_on_t_equalto_1m;
		}
		public void setR44_on_t_equalto_1m(BigDecimal r44_on_t_equalto_1m) {
			this.r44_on_t_equalto_1m = r44_on_t_equalto_1m;
		}
		public BigDecimal getR44_1m_t_equalto_3m() {
			return r44_1m_t_equalto_3m;
		}
		public void setR44_1m_t_equalto_3m(BigDecimal r44_1m_t_equalto_3m) {
			this.r44_1m_t_equalto_3m = r44_1m_t_equalto_3m;
		}
		public BigDecimal getR44_3m_t_equalto_6m() {
			return r44_3m_t_equalto_6m;
		}
		public void setR44_3m_t_equalto_6m(BigDecimal r44_3m_t_equalto_6m) {
			this.r44_3m_t_equalto_6m = r44_3m_t_equalto_6m;
		}
		public BigDecimal getR44_6m_t_equalto_9m() {
			return r44_6m_t_equalto_9m;
		}
		public void setR44_6m_t_equalto_9m(BigDecimal r44_6m_t_equalto_9m) {
			this.r44_6m_t_equalto_9m = r44_6m_t_equalto_9m;
		}
		public BigDecimal getR44_9m_t_equalto_1y() {
			return r44_9m_t_equalto_1y;
		}
		public void setR44_9m_t_equalto_1y(BigDecimal r44_9m_t_equalto_1y) {
			this.r44_9m_t_equalto_1y = r44_9m_t_equalto_1y;
		}
		public BigDecimal getR44_1y_t_equalto_1point5y() {
			return r44_1y_t_equalto_1point5y;
		}
		public void setR44_1y_t_equalto_1point5y(BigDecimal r44_1y_t_equalto_1point5y) {
			this.r44_1y_t_equalto_1point5y = r44_1y_t_equalto_1point5y;
		}
		public BigDecimal getR44_1point5y_t_equalto_2y() {
			return r44_1point5y_t_equalto_2y;
		}
		public void setR44_1point5y_t_equalto_2y(BigDecimal r44_1point5y_t_equalto_2y) {
			this.r44_1point5y_t_equalto_2y = r44_1point5y_t_equalto_2y;
		}
		public BigDecimal getR44_2y_t_equalto_3y() {
			return r44_2y_t_equalto_3y;
		}
		public void setR44_2y_t_equalto_3y(BigDecimal r44_2y_t_equalto_3y) {
			this.r44_2y_t_equalto_3y = r44_2y_t_equalto_3y;
		}
		public BigDecimal getR44_3y_t_equalto_4y() {
			return r44_3y_t_equalto_4y;
		}
		public void setR44_3y_t_equalto_4y(BigDecimal r44_3y_t_equalto_4y) {
			this.r44_3y_t_equalto_4y = r44_3y_t_equalto_4y;
		}
		public BigDecimal getR44_4y_lt_t_ltequalto_5y() {
			return r44_4y_lt_t_ltequalto_5y;
		}
		public void setR44_4y_lt_t_ltequalto_5y(BigDecimal r44_4y_lt_t_ltequalto_5y) {
			this.r44_4y_lt_t_ltequalto_5y = r44_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR44_5y_lt_t_ltequalto_6y() {
			return r44_5y_lt_t_ltequalto_6y;
		}
		public void setR44_5y_lt_t_ltequalto_6y(BigDecimal r44_5y_lt_t_ltequalto_6y) {
			this.r44_5y_lt_t_ltequalto_6y = r44_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR44_6y_lt_t_ltequalto_7y() {
			return r44_6y_lt_t_ltequalto_7y;
		}
		public void setR44_6y_lt_t_ltequalto_7y(BigDecimal r44_6y_lt_t_ltequalto_7y) {
			this.r44_6y_lt_t_ltequalto_7y = r44_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR44_7y_lt_t_ltequalto_8y() {
			return r44_7y_lt_t_ltequalto_8y;
		}
		public void setR44_7y_lt_t_ltequalto_8y(BigDecimal r44_7y_lt_t_ltequalto_8y) {
			this.r44_7y_lt_t_ltequalto_8y = r44_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR44_8y_lt_t_ltequalto_9y() {
			return r44_8y_lt_t_ltequalto_9y;
		}
		public void setR44_8y_lt_t_ltequalto_9y(BigDecimal r44_8y_lt_t_ltequalto_9y) {
			this.r44_8y_lt_t_ltequalto_9y = r44_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR44_9y_lt_t_ltequalto_10y() {
			return r44_9y_lt_t_ltequalto_10y;
		}
		public void setR44_9y_lt_t_ltequalto_10y(BigDecimal r44_9y_lt_t_ltequalto_10y) {
			this.r44_9y_lt_t_ltequalto_10y = r44_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR44_10y_lt_t_ltequalto_15y() {
			return r44_10y_lt_t_ltequalto_15y;
		}
		public void setR44_10y_lt_t_ltequalto_15y(BigDecimal r44_10y_lt_t_ltequalto_15y) {
			this.r44_10y_lt_t_ltequalto_15y = r44_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR44_15y_lt_t_ltequalto_20y() {
			return r44_15y_lt_t_ltequalto_20y;
		}
		public void setR44_15y_lt_t_ltequalto_20y(BigDecimal r44_15y_lt_t_ltequalto_20y) {
			this.r44_15y_lt_t_ltequalto_20y = r44_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR44_tl_20y() {
			return r44_tl_20y;
		}
		public void setR44_tl_20y(BigDecimal r44_tl_20y) {
			this.r44_tl_20y = r44_tl_20y;
		}
		public BigDecimal getR44_nonsensitive() {
			return r44_nonsensitive;
		}
		public void setR44_nonsensitive(BigDecimal r44_nonsensitive) {
			this.r44_nonsensitive = r44_nonsensitive;
		}
		public BigDecimal getR44_total_rsl() {
			return r44_total_rsl;
		}
		public void setR44_total_rsl(BigDecimal r44_total_rsl) {
			this.r44_total_rsl = r44_total_rsl;
		}
		public BigDecimal getR44_total() {
			return r44_total;
		}
		public void setR44_total(BigDecimal r44_total) {
			this.r44_total = r44_total;
		}
		public String getR45_product() {
			return r45_product;
		}
		public void setR45_product(String r45_product) {
			this.r45_product = r45_product;
		}
		public BigDecimal getR45_tequalon() {
			return r45_tequalon;
		}
		public void setR45_tequalon(BigDecimal r45_tequalon) {
			this.r45_tequalon = r45_tequalon;
		}
		public BigDecimal getR45_on_t_equalto_1m() {
			return r45_on_t_equalto_1m;
		}
		public void setR45_on_t_equalto_1m(BigDecimal r45_on_t_equalto_1m) {
			this.r45_on_t_equalto_1m = r45_on_t_equalto_1m;
		}
		public BigDecimal getR45_1m_t_equalto_3m() {
			return r45_1m_t_equalto_3m;
		}
		public void setR45_1m_t_equalto_3m(BigDecimal r45_1m_t_equalto_3m) {
			this.r45_1m_t_equalto_3m = r45_1m_t_equalto_3m;
		}
		public BigDecimal getR45_3m_t_equalto_6m() {
			return r45_3m_t_equalto_6m;
		}
		public void setR45_3m_t_equalto_6m(BigDecimal r45_3m_t_equalto_6m) {
			this.r45_3m_t_equalto_6m = r45_3m_t_equalto_6m;
		}
		public BigDecimal getR45_6m_t_equalto_9m() {
			return r45_6m_t_equalto_9m;
		}
		public void setR45_6m_t_equalto_9m(BigDecimal r45_6m_t_equalto_9m) {
			this.r45_6m_t_equalto_9m = r45_6m_t_equalto_9m;
		}
		public BigDecimal getR45_9m_t_equalto_1y() {
			return r45_9m_t_equalto_1y;
		}
		public void setR45_9m_t_equalto_1y(BigDecimal r45_9m_t_equalto_1y) {
			this.r45_9m_t_equalto_1y = r45_9m_t_equalto_1y;
		}
		public BigDecimal getR45_1y_t_equalto_1point5y() {
			return r45_1y_t_equalto_1point5y;
		}
		public void setR45_1y_t_equalto_1point5y(BigDecimal r45_1y_t_equalto_1point5y) {
			this.r45_1y_t_equalto_1point5y = r45_1y_t_equalto_1point5y;
		}
		public BigDecimal getR45_1point5y_t_equalto_2y() {
			return r45_1point5y_t_equalto_2y;
		}
		public void setR45_1point5y_t_equalto_2y(BigDecimal r45_1point5y_t_equalto_2y) {
			this.r45_1point5y_t_equalto_2y = r45_1point5y_t_equalto_2y;
		}
		public BigDecimal getR45_2y_t_equalto_3y() {
			return r45_2y_t_equalto_3y;
		}
		public void setR45_2y_t_equalto_3y(BigDecimal r45_2y_t_equalto_3y) {
			this.r45_2y_t_equalto_3y = r45_2y_t_equalto_3y;
		}
		public BigDecimal getR45_3y_t_equalto_4y() {
			return r45_3y_t_equalto_4y;
		}
		public void setR45_3y_t_equalto_4y(BigDecimal r45_3y_t_equalto_4y) {
			this.r45_3y_t_equalto_4y = r45_3y_t_equalto_4y;
		}
		public BigDecimal getR45_4y_lt_t_ltequalto_5y() {
			return r45_4y_lt_t_ltequalto_5y;
		}
		public void setR45_4y_lt_t_ltequalto_5y(BigDecimal r45_4y_lt_t_ltequalto_5y) {
			this.r45_4y_lt_t_ltequalto_5y = r45_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR45_5y_lt_t_ltequalto_6y() {
			return r45_5y_lt_t_ltequalto_6y;
		}
		public void setR45_5y_lt_t_ltequalto_6y(BigDecimal r45_5y_lt_t_ltequalto_6y) {
			this.r45_5y_lt_t_ltequalto_6y = r45_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR45_6y_lt_t_ltequalto_7y() {
			return r45_6y_lt_t_ltequalto_7y;
		}
		public void setR45_6y_lt_t_ltequalto_7y(BigDecimal r45_6y_lt_t_ltequalto_7y) {
			this.r45_6y_lt_t_ltequalto_7y = r45_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR45_7y_lt_t_ltequalto_8y() {
			return r45_7y_lt_t_ltequalto_8y;
		}
		public void setR45_7y_lt_t_ltequalto_8y(BigDecimal r45_7y_lt_t_ltequalto_8y) {
			this.r45_7y_lt_t_ltequalto_8y = r45_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR45_8y_lt_t_ltequalto_9y() {
			return r45_8y_lt_t_ltequalto_9y;
		}
		public void setR45_8y_lt_t_ltequalto_9y(BigDecimal r45_8y_lt_t_ltequalto_9y) {
			this.r45_8y_lt_t_ltequalto_9y = r45_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR45_9y_lt_t_ltequalto_10y() {
			return r45_9y_lt_t_ltequalto_10y;
		}
		public void setR45_9y_lt_t_ltequalto_10y(BigDecimal r45_9y_lt_t_ltequalto_10y) {
			this.r45_9y_lt_t_ltequalto_10y = r45_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR45_10y_lt_t_ltequalto_15y() {
			return r45_10y_lt_t_ltequalto_15y;
		}
		public void setR45_10y_lt_t_ltequalto_15y(BigDecimal r45_10y_lt_t_ltequalto_15y) {
			this.r45_10y_lt_t_ltequalto_15y = r45_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR45_15y_lt_t_ltequalto_20y() {
			return r45_15y_lt_t_ltequalto_20y;
		}
		public void setR45_15y_lt_t_ltequalto_20y(BigDecimal r45_15y_lt_t_ltequalto_20y) {
			this.r45_15y_lt_t_ltequalto_20y = r45_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR45_tl_20y() {
			return r45_tl_20y;
		}
		public void setR45_tl_20y(BigDecimal r45_tl_20y) {
			this.r45_tl_20y = r45_tl_20y;
		}
		public BigDecimal getR45_nonsensitive() {
			return r45_nonsensitive;
		}
		public void setR45_nonsensitive(BigDecimal r45_nonsensitive) {
			this.r45_nonsensitive = r45_nonsensitive;
		}
		public BigDecimal getR45_total_rsl() {
			return r45_total_rsl;
		}
		public void setR45_total_rsl(BigDecimal r45_total_rsl) {
			this.r45_total_rsl = r45_total_rsl;
		}
		public BigDecimal getR45_total() {
			return r45_total;
		}
		public void setR45_total(BigDecimal r45_total) {
			this.r45_total = r45_total;
		}
		public String getR46_product() {
			return r46_product;
		}
		public void setR46_product(String r46_product) {
			this.r46_product = r46_product;
		}
		public BigDecimal getR46_tequalon() {
			return r46_tequalon;
		}
		public void setR46_tequalon(BigDecimal r46_tequalon) {
			this.r46_tequalon = r46_tequalon;
		}
		public BigDecimal getR46_on_t_equalto_1m() {
			return r46_on_t_equalto_1m;
		}
		public void setR46_on_t_equalto_1m(BigDecimal r46_on_t_equalto_1m) {
			this.r46_on_t_equalto_1m = r46_on_t_equalto_1m;
		}
		public BigDecimal getR46_1m_t_equalto_3m() {
			return r46_1m_t_equalto_3m;
		}
		public void setR46_1m_t_equalto_3m(BigDecimal r46_1m_t_equalto_3m) {
			this.r46_1m_t_equalto_3m = r46_1m_t_equalto_3m;
		}
		public BigDecimal getR46_3m_t_equalto_6m() {
			return r46_3m_t_equalto_6m;
		}
		public void setR46_3m_t_equalto_6m(BigDecimal r46_3m_t_equalto_6m) {
			this.r46_3m_t_equalto_6m = r46_3m_t_equalto_6m;
		}
		public BigDecimal getR46_6m_t_equalto_9m() {
			return r46_6m_t_equalto_9m;
		}
		public void setR46_6m_t_equalto_9m(BigDecimal r46_6m_t_equalto_9m) {
			this.r46_6m_t_equalto_9m = r46_6m_t_equalto_9m;
		}
		public BigDecimal getR46_9m_t_equalto_1y() {
			return r46_9m_t_equalto_1y;
		}
		public void setR46_9m_t_equalto_1y(BigDecimal r46_9m_t_equalto_1y) {
			this.r46_9m_t_equalto_1y = r46_9m_t_equalto_1y;
		}
		public BigDecimal getR46_1y_t_equalto_1point5y() {
			return r46_1y_t_equalto_1point5y;
		}
		public void setR46_1y_t_equalto_1point5y(BigDecimal r46_1y_t_equalto_1point5y) {
			this.r46_1y_t_equalto_1point5y = r46_1y_t_equalto_1point5y;
		}
		public BigDecimal getR46_1point5y_t_equalto_2y() {
			return r46_1point5y_t_equalto_2y;
		}
		public void setR46_1point5y_t_equalto_2y(BigDecimal r46_1point5y_t_equalto_2y) {
			this.r46_1point5y_t_equalto_2y = r46_1point5y_t_equalto_2y;
		}
		public BigDecimal getR46_2y_t_equalto_3y() {
			return r46_2y_t_equalto_3y;
		}
		public void setR46_2y_t_equalto_3y(BigDecimal r46_2y_t_equalto_3y) {
			this.r46_2y_t_equalto_3y = r46_2y_t_equalto_3y;
		}
		public BigDecimal getR46_3y_t_equalto_4y() {
			return r46_3y_t_equalto_4y;
		}
		public void setR46_3y_t_equalto_4y(BigDecimal r46_3y_t_equalto_4y) {
			this.r46_3y_t_equalto_4y = r46_3y_t_equalto_4y;
		}
		public BigDecimal getR46_4y_lt_t_ltequalto_5y() {
			return r46_4y_lt_t_ltequalto_5y;
		}
		public void setR46_4y_lt_t_ltequalto_5y(BigDecimal r46_4y_lt_t_ltequalto_5y) {
			this.r46_4y_lt_t_ltequalto_5y = r46_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR46_5y_lt_t_ltequalto_6y() {
			return r46_5y_lt_t_ltequalto_6y;
		}
		public void setR46_5y_lt_t_ltequalto_6y(BigDecimal r46_5y_lt_t_ltequalto_6y) {
			this.r46_5y_lt_t_ltequalto_6y = r46_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR46_6y_lt_t_ltequalto_7y() {
			return r46_6y_lt_t_ltequalto_7y;
		}
		public void setR46_6y_lt_t_ltequalto_7y(BigDecimal r46_6y_lt_t_ltequalto_7y) {
			this.r46_6y_lt_t_ltequalto_7y = r46_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR46_7y_lt_t_ltequalto_8y() {
			return r46_7y_lt_t_ltequalto_8y;
		}
		public void setR46_7y_lt_t_ltequalto_8y(BigDecimal r46_7y_lt_t_ltequalto_8y) {
			this.r46_7y_lt_t_ltequalto_8y = r46_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR46_8y_lt_t_ltequalto_9y() {
			return r46_8y_lt_t_ltequalto_9y;
		}
		public void setR46_8y_lt_t_ltequalto_9y(BigDecimal r46_8y_lt_t_ltequalto_9y) {
			this.r46_8y_lt_t_ltequalto_9y = r46_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR46_9y_lt_t_ltequalto_10y() {
			return r46_9y_lt_t_ltequalto_10y;
		}
		public void setR46_9y_lt_t_ltequalto_10y(BigDecimal r46_9y_lt_t_ltequalto_10y) {
			this.r46_9y_lt_t_ltequalto_10y = r46_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR46_10y_lt_t_ltequalto_15y() {
			return r46_10y_lt_t_ltequalto_15y;
		}
		public void setR46_10y_lt_t_ltequalto_15y(BigDecimal r46_10y_lt_t_ltequalto_15y) {
			this.r46_10y_lt_t_ltequalto_15y = r46_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR46_15y_lt_t_ltequalto_20y() {
			return r46_15y_lt_t_ltequalto_20y;
		}
		public void setR46_15y_lt_t_ltequalto_20y(BigDecimal r46_15y_lt_t_ltequalto_20y) {
			this.r46_15y_lt_t_ltequalto_20y = r46_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR46_tl_20y() {
			return r46_tl_20y;
		}
		public void setR46_tl_20y(BigDecimal r46_tl_20y) {
			this.r46_tl_20y = r46_tl_20y;
		}
		public BigDecimal getR46_nonsensitive() {
			return r46_nonsensitive;
		}
		public void setR46_nonsensitive(BigDecimal r46_nonsensitive) {
			this.r46_nonsensitive = r46_nonsensitive;
		}
		public BigDecimal getR46_total_rsl() {
			return r46_total_rsl;
		}
		public void setR46_total_rsl(BigDecimal r46_total_rsl) {
			this.r46_total_rsl = r46_total_rsl;
		}
		public BigDecimal getR46_total() {
			return r46_total;
		}
		public void setR46_total(BigDecimal r46_total) {
			this.r46_total = r46_total;
		}
		public String getR47_product() {
			return r47_product;
		}
		public void setR47_product(String r47_product) {
			this.r47_product = r47_product;
		}
		public BigDecimal getR47_tequalon() {
			return r47_tequalon;
		}
		public void setR47_tequalon(BigDecimal r47_tequalon) {
			this.r47_tequalon = r47_tequalon;
		}
		public BigDecimal getR47_on_t_equalto_1m() {
			return r47_on_t_equalto_1m;
		}
		public void setR47_on_t_equalto_1m(BigDecimal r47_on_t_equalto_1m) {
			this.r47_on_t_equalto_1m = r47_on_t_equalto_1m;
		}
		public BigDecimal getR47_1m_t_equalto_3m() {
			return r47_1m_t_equalto_3m;
		}
		public void setR47_1m_t_equalto_3m(BigDecimal r47_1m_t_equalto_3m) {
			this.r47_1m_t_equalto_3m = r47_1m_t_equalto_3m;
		}
		public BigDecimal getR47_3m_t_equalto_6m() {
			return r47_3m_t_equalto_6m;
		}
		public void setR47_3m_t_equalto_6m(BigDecimal r47_3m_t_equalto_6m) {
			this.r47_3m_t_equalto_6m = r47_3m_t_equalto_6m;
		}
		public BigDecimal getR47_6m_t_equalto_9m() {
			return r47_6m_t_equalto_9m;
		}
		public void setR47_6m_t_equalto_9m(BigDecimal r47_6m_t_equalto_9m) {
			this.r47_6m_t_equalto_9m = r47_6m_t_equalto_9m;
		}
		public BigDecimal getR47_9m_t_equalto_1y() {
			return r47_9m_t_equalto_1y;
		}
		public void setR47_9m_t_equalto_1y(BigDecimal r47_9m_t_equalto_1y) {
			this.r47_9m_t_equalto_1y = r47_9m_t_equalto_1y;
		}
		public BigDecimal getR47_1y_t_equalto_1point5y() {
			return r47_1y_t_equalto_1point5y;
		}
		public void setR47_1y_t_equalto_1point5y(BigDecimal r47_1y_t_equalto_1point5y) {
			this.r47_1y_t_equalto_1point5y = r47_1y_t_equalto_1point5y;
		}
		public BigDecimal getR47_1point5y_t_equalto_2y() {
			return r47_1point5y_t_equalto_2y;
		}
		public void setR47_1point5y_t_equalto_2y(BigDecimal r47_1point5y_t_equalto_2y) {
			this.r47_1point5y_t_equalto_2y = r47_1point5y_t_equalto_2y;
		}
		public BigDecimal getR47_2y_t_equalto_3y() {
			return r47_2y_t_equalto_3y;
		}
		public void setR47_2y_t_equalto_3y(BigDecimal r47_2y_t_equalto_3y) {
			this.r47_2y_t_equalto_3y = r47_2y_t_equalto_3y;
		}
		public BigDecimal getR47_3y_t_equalto_4y() {
			return r47_3y_t_equalto_4y;
		}
		public void setR47_3y_t_equalto_4y(BigDecimal r47_3y_t_equalto_4y) {
			this.r47_3y_t_equalto_4y = r47_3y_t_equalto_4y;
		}
		public BigDecimal getR47_4y_lt_t_ltequalto_5y() {
			return r47_4y_lt_t_ltequalto_5y;
		}
		public void setR47_4y_lt_t_ltequalto_5y(BigDecimal r47_4y_lt_t_ltequalto_5y) {
			this.r47_4y_lt_t_ltequalto_5y = r47_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR47_5y_lt_t_ltequalto_6y() {
			return r47_5y_lt_t_ltequalto_6y;
		}
		public void setR47_5y_lt_t_ltequalto_6y(BigDecimal r47_5y_lt_t_ltequalto_6y) {
			this.r47_5y_lt_t_ltequalto_6y = r47_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR47_6y_lt_t_ltequalto_7y() {
			return r47_6y_lt_t_ltequalto_7y;
		}
		public void setR47_6y_lt_t_ltequalto_7y(BigDecimal r47_6y_lt_t_ltequalto_7y) {
			this.r47_6y_lt_t_ltequalto_7y = r47_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR47_7y_lt_t_ltequalto_8y() {
			return r47_7y_lt_t_ltequalto_8y;
		}
		public void setR47_7y_lt_t_ltequalto_8y(BigDecimal r47_7y_lt_t_ltequalto_8y) {
			this.r47_7y_lt_t_ltequalto_8y = r47_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR47_8y_lt_t_ltequalto_9y() {
			return r47_8y_lt_t_ltequalto_9y;
		}
		public void setR47_8y_lt_t_ltequalto_9y(BigDecimal r47_8y_lt_t_ltequalto_9y) {
			this.r47_8y_lt_t_ltequalto_9y = r47_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR47_9y_lt_t_ltequalto_10y() {
			return r47_9y_lt_t_ltequalto_10y;
		}
		public void setR47_9y_lt_t_ltequalto_10y(BigDecimal r47_9y_lt_t_ltequalto_10y) {
			this.r47_9y_lt_t_ltequalto_10y = r47_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR47_10y_lt_t_ltequalto_15y() {
			return r47_10y_lt_t_ltequalto_15y;
		}
		public void setR47_10y_lt_t_ltequalto_15y(BigDecimal r47_10y_lt_t_ltequalto_15y) {
			this.r47_10y_lt_t_ltequalto_15y = r47_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR47_15y_lt_t_ltequalto_20y() {
			return r47_15y_lt_t_ltequalto_20y;
		}
		public void setR47_15y_lt_t_ltequalto_20y(BigDecimal r47_15y_lt_t_ltequalto_20y) {
			this.r47_15y_lt_t_ltequalto_20y = r47_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR47_tl_20y() {
			return r47_tl_20y;
		}
		public void setR47_tl_20y(BigDecimal r47_tl_20y) {
			this.r47_tl_20y = r47_tl_20y;
		}
		public BigDecimal getR47_nonsensitive() {
			return r47_nonsensitive;
		}
		public void setR47_nonsensitive(BigDecimal r47_nonsensitive) {
			this.r47_nonsensitive = r47_nonsensitive;
		}
		public BigDecimal getR47_total_rsl() {
			return r47_total_rsl;
		}
		public void setR47_total_rsl(BigDecimal r47_total_rsl) {
			this.r47_total_rsl = r47_total_rsl;
		}
		public BigDecimal getR47_total() {
			return r47_total;
		}
		public void setR47_total(BigDecimal r47_total) {
			this.r47_total = r47_total;
		}
		public String getR48_product() {
			return r48_product;
		}
		public void setR48_product(String r48_product) {
			this.r48_product = r48_product;
		}
		public BigDecimal getR48_tequalon() {
			return r48_tequalon;
		}
		public void setR48_tequalon(BigDecimal r48_tequalon) {
			this.r48_tequalon = r48_tequalon;
		}
		public BigDecimal getR48_on_t_equalto_1m() {
			return r48_on_t_equalto_1m;
		}
		public void setR48_on_t_equalto_1m(BigDecimal r48_on_t_equalto_1m) {
			this.r48_on_t_equalto_1m = r48_on_t_equalto_1m;
		}
		public BigDecimal getR48_1m_t_equalto_3m() {
			return r48_1m_t_equalto_3m;
		}
		public void setR48_1m_t_equalto_3m(BigDecimal r48_1m_t_equalto_3m) {
			this.r48_1m_t_equalto_3m = r48_1m_t_equalto_3m;
		}
		public BigDecimal getR48_3m_t_equalto_6m() {
			return r48_3m_t_equalto_6m;
		}
		public void setR48_3m_t_equalto_6m(BigDecimal r48_3m_t_equalto_6m) {
			this.r48_3m_t_equalto_6m = r48_3m_t_equalto_6m;
		}
		public BigDecimal getR48_6m_t_equalto_9m() {
			return r48_6m_t_equalto_9m;
		}
		public void setR48_6m_t_equalto_9m(BigDecimal r48_6m_t_equalto_9m) {
			this.r48_6m_t_equalto_9m = r48_6m_t_equalto_9m;
		}
		public BigDecimal getR48_9m_t_equalto_1y() {
			return r48_9m_t_equalto_1y;
		}
		public void setR48_9m_t_equalto_1y(BigDecimal r48_9m_t_equalto_1y) {
			this.r48_9m_t_equalto_1y = r48_9m_t_equalto_1y;
		}
		public BigDecimal getR48_1y_t_equalto_1point5y() {
			return r48_1y_t_equalto_1point5y;
		}
		public void setR48_1y_t_equalto_1point5y(BigDecimal r48_1y_t_equalto_1point5y) {
			this.r48_1y_t_equalto_1point5y = r48_1y_t_equalto_1point5y;
		}
		public BigDecimal getR48_1point5y_t_equalto_2y() {
			return r48_1point5y_t_equalto_2y;
		}
		public void setR48_1point5y_t_equalto_2y(BigDecimal r48_1point5y_t_equalto_2y) {
			this.r48_1point5y_t_equalto_2y = r48_1point5y_t_equalto_2y;
		}
		public BigDecimal getR48_2y_t_equalto_3y() {
			return r48_2y_t_equalto_3y;
		}
		public void setR48_2y_t_equalto_3y(BigDecimal r48_2y_t_equalto_3y) {
			this.r48_2y_t_equalto_3y = r48_2y_t_equalto_3y;
		}
		public BigDecimal getR48_3y_t_equalto_4y() {
			return r48_3y_t_equalto_4y;
		}
		public void setR48_3y_t_equalto_4y(BigDecimal r48_3y_t_equalto_4y) {
			this.r48_3y_t_equalto_4y = r48_3y_t_equalto_4y;
		}
		public BigDecimal getR48_4y_lt_t_ltequalto_5y() {
			return r48_4y_lt_t_ltequalto_5y;
		}
		public void setR48_4y_lt_t_ltequalto_5y(BigDecimal r48_4y_lt_t_ltequalto_5y) {
			this.r48_4y_lt_t_ltequalto_5y = r48_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR48_5y_lt_t_ltequalto_6y() {
			return r48_5y_lt_t_ltequalto_6y;
		}
		public void setR48_5y_lt_t_ltequalto_6y(BigDecimal r48_5y_lt_t_ltequalto_6y) {
			this.r48_5y_lt_t_ltequalto_6y = r48_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR48_6y_lt_t_ltequalto_7y() {
			return r48_6y_lt_t_ltequalto_7y;
		}
		public void setR48_6y_lt_t_ltequalto_7y(BigDecimal r48_6y_lt_t_ltequalto_7y) {
			this.r48_6y_lt_t_ltequalto_7y = r48_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR48_7y_lt_t_ltequalto_8y() {
			return r48_7y_lt_t_ltequalto_8y;
		}
		public void setR48_7y_lt_t_ltequalto_8y(BigDecimal r48_7y_lt_t_ltequalto_8y) {
			this.r48_7y_lt_t_ltequalto_8y = r48_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR48_8y_lt_t_ltequalto_9y() {
			return r48_8y_lt_t_ltequalto_9y;
		}
		public void setR48_8y_lt_t_ltequalto_9y(BigDecimal r48_8y_lt_t_ltequalto_9y) {
			this.r48_8y_lt_t_ltequalto_9y = r48_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR48_9y_lt_t_ltequalto_10y() {
			return r48_9y_lt_t_ltequalto_10y;
		}
		public void setR48_9y_lt_t_ltequalto_10y(BigDecimal r48_9y_lt_t_ltequalto_10y) {
			this.r48_9y_lt_t_ltequalto_10y = r48_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR48_10y_lt_t_ltequalto_15y() {
			return r48_10y_lt_t_ltequalto_15y;
		}
		public void setR48_10y_lt_t_ltequalto_15y(BigDecimal r48_10y_lt_t_ltequalto_15y) {
			this.r48_10y_lt_t_ltequalto_15y = r48_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR48_15y_lt_t_ltequalto_20y() {
			return r48_15y_lt_t_ltequalto_20y;
		}
		public void setR48_15y_lt_t_ltequalto_20y(BigDecimal r48_15y_lt_t_ltequalto_20y) {
			this.r48_15y_lt_t_ltequalto_20y = r48_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR48_tl_20y() {
			return r48_tl_20y;
		}
		public void setR48_tl_20y(BigDecimal r48_tl_20y) {
			this.r48_tl_20y = r48_tl_20y;
		}
		public BigDecimal getR48_nonsensitive() {
			return r48_nonsensitive;
		}
		public void setR48_nonsensitive(BigDecimal r48_nonsensitive) {
			this.r48_nonsensitive = r48_nonsensitive;
		}
		public BigDecimal getR48_total_rsl() {
			return r48_total_rsl;
		}
		public void setR48_total_rsl(BigDecimal r48_total_rsl) {
			this.r48_total_rsl = r48_total_rsl;
		}
		public BigDecimal getR48_total() {
			return r48_total;
		}
		public void setR48_total(BigDecimal r48_total) {
			this.r48_total = r48_total;
		}
		public String getR49_product() {
			return r49_product;
		}
		public void setR49_product(String r49_product) {
			this.r49_product = r49_product;
		}
		public BigDecimal getR49_tequalon() {
			return r49_tequalon;
		}
		public void setR49_tequalon(BigDecimal r49_tequalon) {
			this.r49_tequalon = r49_tequalon;
		}
		public BigDecimal getR49_on_t_equalto_1m() {
			return r49_on_t_equalto_1m;
		}
		public void setR49_on_t_equalto_1m(BigDecimal r49_on_t_equalto_1m) {
			this.r49_on_t_equalto_1m = r49_on_t_equalto_1m;
		}
		public BigDecimal getR49_1m_t_equalto_3m() {
			return r49_1m_t_equalto_3m;
		}
		public void setR49_1m_t_equalto_3m(BigDecimal r49_1m_t_equalto_3m) {
			this.r49_1m_t_equalto_3m = r49_1m_t_equalto_3m;
		}
		public BigDecimal getR49_3m_t_equalto_6m() {
			return r49_3m_t_equalto_6m;
		}
		public void setR49_3m_t_equalto_6m(BigDecimal r49_3m_t_equalto_6m) {
			this.r49_3m_t_equalto_6m = r49_3m_t_equalto_6m;
		}
		public BigDecimal getR49_6m_t_equalto_9m() {
			return r49_6m_t_equalto_9m;
		}
		public void setR49_6m_t_equalto_9m(BigDecimal r49_6m_t_equalto_9m) {
			this.r49_6m_t_equalto_9m = r49_6m_t_equalto_9m;
		}
		public BigDecimal getR49_9m_t_equalto_1y() {
			return r49_9m_t_equalto_1y;
		}
		public void setR49_9m_t_equalto_1y(BigDecimal r49_9m_t_equalto_1y) {
			this.r49_9m_t_equalto_1y = r49_9m_t_equalto_1y;
		}
		public BigDecimal getR49_1y_t_equalto_1point5y() {
			return r49_1y_t_equalto_1point5y;
		}
		public void setR49_1y_t_equalto_1point5y(BigDecimal r49_1y_t_equalto_1point5y) {
			this.r49_1y_t_equalto_1point5y = r49_1y_t_equalto_1point5y;
		}
		public BigDecimal getR49_1point5y_t_equalto_2y() {
			return r49_1point5y_t_equalto_2y;
		}
		public void setR49_1point5y_t_equalto_2y(BigDecimal r49_1point5y_t_equalto_2y) {
			this.r49_1point5y_t_equalto_2y = r49_1point5y_t_equalto_2y;
		}
		public BigDecimal getR49_2y_t_equalto_3y() {
			return r49_2y_t_equalto_3y;
		}
		public void setR49_2y_t_equalto_3y(BigDecimal r49_2y_t_equalto_3y) {
			this.r49_2y_t_equalto_3y = r49_2y_t_equalto_3y;
		}
		public BigDecimal getR49_3y_t_equalto_4y() {
			return r49_3y_t_equalto_4y;
		}
		public void setR49_3y_t_equalto_4y(BigDecimal r49_3y_t_equalto_4y) {
			this.r49_3y_t_equalto_4y = r49_3y_t_equalto_4y;
		}
		public BigDecimal getR49_4y_lt_t_ltequalto_5y() {
			return r49_4y_lt_t_ltequalto_5y;
		}
		public void setR49_4y_lt_t_ltequalto_5y(BigDecimal r49_4y_lt_t_ltequalto_5y) {
			this.r49_4y_lt_t_ltequalto_5y = r49_4y_lt_t_ltequalto_5y;
		}
		public BigDecimal getR49_5y_lt_t_ltequalto_6y() {
			return r49_5y_lt_t_ltequalto_6y;
		}
		public void setR49_5y_lt_t_ltequalto_6y(BigDecimal r49_5y_lt_t_ltequalto_6y) {
			this.r49_5y_lt_t_ltequalto_6y = r49_5y_lt_t_ltequalto_6y;
		}
		public BigDecimal getR49_6y_lt_t_ltequalto_7y() {
			return r49_6y_lt_t_ltequalto_7y;
		}
		public void setR49_6y_lt_t_ltequalto_7y(BigDecimal r49_6y_lt_t_ltequalto_7y) {
			this.r49_6y_lt_t_ltequalto_7y = r49_6y_lt_t_ltequalto_7y;
		}
		public BigDecimal getR49_7y_lt_t_ltequalto_8y() {
			return r49_7y_lt_t_ltequalto_8y;
		}
		public void setR49_7y_lt_t_ltequalto_8y(BigDecimal r49_7y_lt_t_ltequalto_8y) {
			this.r49_7y_lt_t_ltequalto_8y = r49_7y_lt_t_ltequalto_8y;
		}
		public BigDecimal getR49_8y_lt_t_ltequalto_9y() {
			return r49_8y_lt_t_ltequalto_9y;
		}
		public void setR49_8y_lt_t_ltequalto_9y(BigDecimal r49_8y_lt_t_ltequalto_9y) {
			this.r49_8y_lt_t_ltequalto_9y = r49_8y_lt_t_ltequalto_9y;
		}
		public BigDecimal getR49_9y_lt_t_ltequalto_10y() {
			return r49_9y_lt_t_ltequalto_10y;
		}
		public void setR49_9y_lt_t_ltequalto_10y(BigDecimal r49_9y_lt_t_ltequalto_10y) {
			this.r49_9y_lt_t_ltequalto_10y = r49_9y_lt_t_ltequalto_10y;
		}
		public BigDecimal getR49_10y_lt_t_ltequalto_15y() {
			return r49_10y_lt_t_ltequalto_15y;
		}
		public void setR49_10y_lt_t_ltequalto_15y(BigDecimal r49_10y_lt_t_ltequalto_15y) {
			this.r49_10y_lt_t_ltequalto_15y = r49_10y_lt_t_ltequalto_15y;
		}
		public BigDecimal getR49_15y_lt_t_ltequalto_20y() {
			return r49_15y_lt_t_ltequalto_20y;
		}
		public void setR49_15y_lt_t_ltequalto_20y(BigDecimal r49_15y_lt_t_ltequalto_20y) {
			this.r49_15y_lt_t_ltequalto_20y = r49_15y_lt_t_ltequalto_20y;
		}
		public BigDecimal getR49_tl_20y() {
			return r49_tl_20y;
		}
		public void setR49_tl_20y(BigDecimal r49_tl_20y) {
			this.r49_tl_20y = r49_tl_20y;
		}
		public BigDecimal getR49_nonsensitive() {
			return r49_nonsensitive;
		}
		public void setR49_nonsensitive(BigDecimal r49_nonsensitive) {
			this.r49_nonsensitive = r49_nonsensitive;
		}
		public BigDecimal getR49_total_rsl() {
			return r49_total_rsl;
		}
		public void setR49_total_rsl(BigDecimal r49_total_rsl) {
			this.r49_total_rsl = r49_total_rsl;
		}
		public BigDecimal getR49_total() {
			return r49_total;
		}
		public void setR49_total(BigDecimal r49_total) {
			this.r49_total = r49_total;
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
		public BigDecimal getEntity_flg() {
			return entity_flg;
		}
		public void setEntity_flg(BigDecimal entity_flg) {
			this.entity_flg = entity_flg;
		}
		public BigDecimal getModify_flg() {
			return modify_flg;
		}
		public void setModify_flg(BigDecimal modify_flg) {
			this.modify_flg = modify_flg;
		}
		public BigDecimal getDel_flg() {
			return del_flg;
		}
		public void setDel_flg(BigDecimal del_flg) {
			this.del_flg = del_flg;
		}
		public BigDecimal getReport_code() {
			return report_code;
		}
		public void setReport_code(BigDecimal report_code) {
			this.report_code = report_code;
		}
		public Date getReport_submit_date() {
			return report_submit_date;
		}
		public void setReport_submit_date(Date report_submit_date) {
			this.report_submit_date = report_submit_date;
		}
		public Banking_Book1_Cons() {
			super();
			// TODO Auto-generated constructor stub
		}
}	