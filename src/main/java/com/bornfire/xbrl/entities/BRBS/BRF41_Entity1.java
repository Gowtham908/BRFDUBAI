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
@Table(name="BRF41A_SUMMARYTABLE")
public class BRF41_Entity1 {

	private String	r10_product;
	private BigDecimal	r10_no_of_accounts_uae;
	private BigDecimal	r10_amount_uae;
	private BigDecimal	r10_no_of_accounts_resident;
	private BigDecimal	r10_amount_resident;
	private BigDecimal	r10_no_of_accounts_non_resident;
	private BigDecimal	r10_amount_non_resident;
	private BigDecimal	r10_total_account;
	private BigDecimal	r10_total_amount;
	private BigDecimal	r10_no_of_accounts_uae_abu;
	private BigDecimal	r10_amount_uae_abu;
	private BigDecimal	r10_no_of_accounts_non_uae_abu;
	private BigDecimal	r10_amount_non_uae_abu;
	private BigDecimal	r10_total_abu;
	private BigDecimal	r10_no_of_accounts_uae_dubai;
	private BigDecimal	r10_amount_uae_dubai;
	private BigDecimal	r10_no_of_accounts_non_uae_dubai;
	private BigDecimal	r10_amount_non_uae_dubai;
	private BigDecimal	r10_total_dubai;
	private BigDecimal	r10_no_of_accounts_uae_sharjah;
	private BigDecimal	r10_amount_uae_sharjah;
	private BigDecimal	r10_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r10_amount_non_uae_sharjah;
	private BigDecimal	r10_total_sharjah;
	private BigDecimal	r10_no_of_accounts_uae_ajman;
	private BigDecimal	r10_amount_uae_ajman;
	private BigDecimal	r10_no_of_accounts_non_uae_ajman;
	private BigDecimal	r10_amount_non_uae_ajman;
	private BigDecimal	r10_total_ajman;
	private BigDecimal	r10_no_of_accounts_uae_ras ;
	private BigDecimal	r10_amount_uae_ras ;
	private BigDecimal	r10_no_of_accounts_non_uae_ras ;
	private BigDecimal	r10_amount_non_uae_ras ;
	private BigDecimal	r10_total_ras ;
	private BigDecimal	r10_no_of_accounts_uae_umm ;
	private BigDecimal	r10_amount_uae_umm ;
	private BigDecimal	r10_no_of_accounts_non_uae_umm ;
	private BigDecimal	r10_amount_non_uae_umm ;
	private BigDecimal	r10_total_umm ;
	private BigDecimal	r10_no_of_accounts_uae_fujairah;
	private BigDecimal	r10_amount_uae_fujairah;
	private BigDecimal	r10_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r10_amount_non_uae_fujairah;
	private BigDecimal	r10_total_fujairah;
	private String	r11_product;
	private BigDecimal	r11_no_of_accounts_uae;
	private BigDecimal	r11_amount_uae;
	private BigDecimal	r11_no_of_accounts_resident;
	private BigDecimal	r11_amount_resident;
	private BigDecimal	r11_no_of_accounts_non_resident;
	private BigDecimal	r11_amount_non_resident;
	private BigDecimal	r11_total_account;
	private BigDecimal	r11_total_amount;
	private BigDecimal	r11_no_of_accounts_uae_abu;
	private BigDecimal	r11_amount_uae_abu;
	private BigDecimal	r11_no_of_accounts_non_uae_abu;
	private BigDecimal	r11_amount_non_uae_abu;
	private BigDecimal	r11_total_abu;
	private BigDecimal	r11_no_of_accounts_uae_dubai;
	private BigDecimal	r11_amount_uae_dubai;
	private BigDecimal	r11_no_of_accounts_non_uae_dubai;
	private BigDecimal	r11_amount_non_uae_dubai;
	private BigDecimal	r11_total_dubai;
	private BigDecimal	r11_no_of_accounts_uae_sharjah;
	private BigDecimal	r11_amount_uae_sharjah;
	private BigDecimal	r11_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r11_amount_non_uae_sharjah;
	private BigDecimal	r11_total_sharjah;
	private BigDecimal	r11_no_of_accounts_uae_ajman;
	private BigDecimal	r11_amount_uae_ajman;
	private BigDecimal	r11_no_of_accounts_non_uae_ajman;
	private BigDecimal	r11_amount_non_uae_ajman;
	private BigDecimal	r11_total_ajman;
	private BigDecimal	r11_no_of_accounts_uae_ras ;
	private BigDecimal	r11_amount_uae_ras ;
	private BigDecimal	r11_no_of_accounts_non_uae_ras ;
	private BigDecimal	r11_amount_non_uae_ras ;
	private BigDecimal	r11_total_ras ;
	private BigDecimal	r11_no_of_accounts_uae_umm ;
	private BigDecimal	r11_amount_uae_umm ;
	private BigDecimal	r11_no_of_accounts_non_uae_umm ;
	private BigDecimal	r11_amount_non_uae_umm ;
	private BigDecimal	r11_total_umm ;
	private BigDecimal	r11_no_of_accounts_uae_fujairah;
	private BigDecimal	r11_amount_uae_fujairah;
	private BigDecimal	r11_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r11_amount_non_uae_fujairah;
	private BigDecimal	r11_total_fujairah;
	private String	r12_product;
	private BigDecimal	r12_no_of_accounts_uae;
	private BigDecimal	r12_amount_uae;
	private BigDecimal	r12_no_of_accounts_resident;
	private BigDecimal	r12_amount_resident;
	private BigDecimal	r12_no_of_accounts_non_resident;
	private BigDecimal	r12_amount_non_resident;
	private BigDecimal	r12_total_account;
	private BigDecimal	r12_total_amount;
	private BigDecimal	r12_no_of_accounts_uae_abu;
	private BigDecimal	r12_amount_uae_abu;
	private BigDecimal	r12_no_of_accounts_non_uae_abu;
	private BigDecimal	r12_amount_non_uae_abu;
	private BigDecimal	r12_total_abu;
	private BigDecimal	r12_no_of_accounts_uae_dubai;
	private BigDecimal	r12_amount_uae_dubai;
	private BigDecimal	r12_no_of_accounts_non_uae_dubai;
	private BigDecimal	r12_amount_non_uae_dubai;
	private BigDecimal	r12_total_dubai;
	private BigDecimal	r12_no_of_accounts_uae_sharjah;
	private BigDecimal	r12_amount_uae_sharjah;
	private BigDecimal	r12_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r12_amount_non_uae_sharjah;
	private BigDecimal	r12_total_sharjah;
	private BigDecimal	r12_no_of_accounts_uae_ajman;
	private BigDecimal	r12_amount_uae_ajman;
	private BigDecimal	r12_no_of_accounts_non_uae_ajman;
	private BigDecimal	r12_amount_non_uae_ajman;
	private BigDecimal	r12_total_ajman;
	private BigDecimal	r12_no_of_accounts_uae_ras ;
	private BigDecimal	r12_amount_uae_ras ;
	private BigDecimal	r12_no_of_accounts_non_uae_ras ;
	private BigDecimal	r12_amount_non_uae_ras ;
	private BigDecimal	r12_total_ras ;
	private BigDecimal	r12_no_of_accounts_uae_umm ;
	private BigDecimal	r12_amount_uae_umm ;
	private BigDecimal	r12_no_of_accounts_non_uae_umm ;
	private BigDecimal	r12_amount_non_uae_umm ;
	private BigDecimal	r12_total_umm ;
	private BigDecimal	r12_no_of_accounts_uae_fujairah;
	private BigDecimal	r12_amount_uae_fujairah;
	private BigDecimal	r12_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r12_amount_non_uae_fujairah;
	private BigDecimal	r12_total_fujairah;
	private String	r13_product;
	private BigDecimal	r13_no_of_accounts_uae;
	private BigDecimal	r13_amount_uae;
	private BigDecimal	r13_no_of_accounts_resident;
	private BigDecimal	r13_amount_resident;
	private BigDecimal	r13_no_of_accounts_non_resident;
	private BigDecimal	r13_amount_non_resident;
	private BigDecimal	r13_total_account;
	private BigDecimal	r13_total_amount;
	private BigDecimal	r13_no_of_accounts_uae_abu;
	private BigDecimal	r13_amount_uae_abu;
	private BigDecimal	r13_no_of_accounts_non_uae_abu;
	private BigDecimal	r13_amount_non_uae_abu;
	private BigDecimal	r13_total_abu;
	private BigDecimal	r13_no_of_accounts_uae_dubai;
	private BigDecimal	r13_amount_uae_dubai;
	private BigDecimal	r13_no_of_accounts_non_uae_dubai;
	private BigDecimal	r13_amount_non_uae_dubai;
	private BigDecimal	r13_total_dubai;
	private BigDecimal	r13_no_of_accounts_uae_sharjah;
	private BigDecimal	r13_amount_uae_sharjah;
	private BigDecimal	r13_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r13_amount_non_uae_sharjah;
	private BigDecimal	r13_total_sharjah;
	private BigDecimal	r13_no_of_accounts_uae_ajman;
	private BigDecimal	r13_amount_uae_ajman;
	private BigDecimal	r13_no_of_accounts_non_uae_ajman;
	private BigDecimal	r13_amount_non_uae_ajman;
	private BigDecimal	r13_total_ajman;
	private BigDecimal	r13_no_of_accounts_uae_ras ;
	private BigDecimal	r13_amount_uae_ras ;
	private BigDecimal	r13_no_of_accounts_non_uae_ras ;
	private BigDecimal	r13_amount_non_uae_ras ;
	private BigDecimal	r13_total_ras ;
	private BigDecimal	r13_no_of_accounts_uae_umm ;
	private BigDecimal	r13_amount_uae_umm ;
	private BigDecimal	r13_no_of_accounts_non_uae_umm ;
	private BigDecimal	r13_amount_non_uae_umm ;
	private BigDecimal	r13_total_umm ;
	private BigDecimal	r13_no_of_accounts_uae_fujairah;
	private BigDecimal	r13_amount_uae_fujairah;
	private BigDecimal	r13_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r13_amount_non_uae_fujairah;
	private BigDecimal	r13_total_fujairah;
	private String	r14_product;
	private BigDecimal	r14_no_of_accounts_uae;
	private BigDecimal	r14_amount_uae;
	private BigDecimal	r14_no_of_accounts_resident;
	private BigDecimal	r14_amount_resident;
	private BigDecimal	r14_no_of_accounts_non_resident;
	private BigDecimal	r14_amount_non_resident;
	private BigDecimal	r14_total_account;
	private BigDecimal	r14_total_amount;
	private BigDecimal	r14_no_of_accounts_uae_abu;
	private BigDecimal	r14_amount_uae_abu;
	private BigDecimal	r14_no_of_accounts_non_uae_abu;
	private BigDecimal	r14_amount_non_uae_abu;
	private BigDecimal	r14_total_abu;
	private BigDecimal	r14_no_of_accounts_uae_dubai;
	private BigDecimal	r14_amount_uae_dubai;
	private BigDecimal	r14_no_of_accounts_non_uae_dubai;
	private BigDecimal	r14_amount_non_uae_dubai;
	private BigDecimal	r14_total_dubai;
	private BigDecimal	r14_no_of_accounts_uae_sharjah;
	private BigDecimal	r14_amount_uae_sharjah;
	private BigDecimal	r14_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r14_amount_non_uae_sharjah;
	private BigDecimal	r14_total_sharjah;
	private BigDecimal	r14_no_of_accounts_uae_ajman;
	private BigDecimal	r14_amount_uae_ajman;
	private BigDecimal	r14_no_of_accounts_non_uae_ajman;
	private BigDecimal	r14_amount_non_uae_ajman;
	private BigDecimal	r14_total_ajman;
	private BigDecimal	r14_no_of_accounts_uae_ras ;
	private BigDecimal	r14_amount_uae_ras ;
	private BigDecimal	r14_no_of_accounts_non_uae_ras ;
	private BigDecimal	r14_amount_non_uae_ras ;
	private BigDecimal	r14_total_ras ;
	private BigDecimal	r14_no_of_accounts_uae_umm ;
	private BigDecimal	r14_amount_uae_umm ;
	private BigDecimal	r14_no_of_accounts_non_uae_umm ;
	private BigDecimal	r14_amount_non_uae_umm ;
	private BigDecimal	r14_total_umm ;
	private BigDecimal	r14_no_of_accounts_uae_fujairah;
	private BigDecimal	r14_amount_uae_fujairah;
	private BigDecimal	r14_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r14_amount_non_uae_fujairah;
	private BigDecimal	r14_total_fujairah;
	private String	r15_product;
	private BigDecimal	r15_no_of_accounts_uae;
	private BigDecimal	r15_amount_uae;
	private BigDecimal	r15_no_of_accounts_resident;
	private BigDecimal	r15_amount_resident;
	private BigDecimal	r15_no_of_accounts_non_resident;
	private BigDecimal	r15_amount_non_resident;
	private BigDecimal	r15_total_account;
	private BigDecimal	r15_total_amount;
	private BigDecimal	r15_no_of_accounts_uae_abu;
	private BigDecimal	r15_amount_uae_abu;
	private BigDecimal	r15_no_of_accounts_non_uae_abu;
	private BigDecimal	r15_amount_non_uae_abu;
	private BigDecimal	r15_total_abu;
	private BigDecimal	r15_no_of_accounts_uae_dubai;
	private BigDecimal	r15_amount_uae_dubai;
	private BigDecimal	r15_no_of_accounts_non_uae_dubai;
	private BigDecimal	r15_amount_non_uae_dubai;
	private BigDecimal	r15_total_dubai;
	private BigDecimal	r15_no_of_accounts_uae_sharjah;
	private BigDecimal	r15_amount_uae_sharjah;
	private BigDecimal	r15_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r15_amount_non_uae_sharjah;
	private BigDecimal	r15_total_sharjah;
	private BigDecimal	r15_no_of_accounts_uae_ajman;
	private BigDecimal	r15_amount_uae_ajman;
	private BigDecimal	r15_no_of_accounts_non_uae_ajman;
	private BigDecimal	r15_amount_non_uae_ajman;
	private BigDecimal	r15_total_ajman;
	private BigDecimal	r15_no_of_accounts_uae_ras ;
	private BigDecimal	r15_amount_uae_ras ;
	private BigDecimal	r15_no_of_accounts_non_uae_ras ;
	private BigDecimal	r15_amount_non_uae_ras ;
	private BigDecimal	r15_total_ras ;
	private BigDecimal	r15_no_of_accounts_uae_umm ;
	private BigDecimal	r15_amount_uae_umm ;
	private BigDecimal	r15_no_of_accounts_non_uae_umm ;
	private BigDecimal	r15_amount_non_uae_umm ;
	private BigDecimal	r15_total_umm ;
	private BigDecimal	r15_no_of_accounts_uae_fujairah;
	private BigDecimal	r15_amount_uae_fujairah;
	private BigDecimal	r15_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r15_amount_non_uae_fujairah;
	private BigDecimal	r15_total_fujairah;
	private String	r16_product;
	private BigDecimal	r16_no_of_accounts_uae;
	private BigDecimal	r16_amount_uae;
	private BigDecimal	r16_no_of_accounts_resident;
	private BigDecimal	r16_amount_resident;
	private BigDecimal	r16_no_of_accounts_non_resident;
	private BigDecimal	r16_amount_non_resident;
	private BigDecimal	r16_total_account;
	private BigDecimal	r16_total_amount;
	private BigDecimal	r16_no_of_accounts_uae_abu;
	private BigDecimal	r16_amount_uae_abu;
	private BigDecimal	r16_no_of_accounts_non_uae_abu;
	private BigDecimal	r16_amount_non_uae_abu;
	private BigDecimal	r16_total_abu;
	private BigDecimal	r16_no_of_accounts_uae_dubai;
	private BigDecimal	r16_amount_uae_dubai;
	private BigDecimal	r16_no_of_accounts_non_uae_dubai;
	private BigDecimal	r16_amount_non_uae_dubai;
	private BigDecimal	r16_total_dubai;
	private BigDecimal	r16_no_of_accounts_uae_sharjah;
	private BigDecimal	r16_amount_uae_sharjah;
	private BigDecimal	r16_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r16_amount_non_uae_sharjah;
	private BigDecimal	r16_total_sharjah;
	private BigDecimal	r16_no_of_accounts_uae_ajman;
	private BigDecimal	r16_amount_uae_ajman;
	private BigDecimal	r16_no_of_accounts_non_uae_ajman;
	private BigDecimal	r16_amount_non_uae_ajman;
	private BigDecimal	r16_total_ajman;
	private BigDecimal	r16_no_of_accounts_uae_ras ;
	private BigDecimal	r16_amount_uae_ras ;
	private BigDecimal	r16_no_of_accounts_non_uae_ras ;
	private BigDecimal	r16_amount_non_uae_ras ;
	private BigDecimal	r16_total_ras ;
	private BigDecimal	r16_no_of_accounts_uae_umm ;
	private BigDecimal	r16_amount_uae_umm ;
	private BigDecimal	r16_no_of_accounts_non_uae_umm ;
	private BigDecimal	r16_amount_non_uae_umm ;
	private BigDecimal	r16_total_umm ;
	private BigDecimal	r16_no_of_accounts_uae_fujairah;
	private BigDecimal	r16_amount_uae_fujairah;
	private BigDecimal	r16_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r16_amount_non_uae_fujairah;
	private BigDecimal	r16_total_fujairah;
	private String	r17_product;
	private BigDecimal	r17_no_of_accounts_uae;
	private BigDecimal	r17_amount_uae;
	private BigDecimal	r17_no_of_accounts_resident;
	private BigDecimal	r17_amount_resident;
	private BigDecimal	r17_no_of_accounts_non_resident;
	private BigDecimal	r17_amount_non_resident;
	private BigDecimal	r17_total_account;
	private BigDecimal	r17_total_amount;
	private BigDecimal	r17_no_of_accounts_uae_abu;
	private BigDecimal	r17_amount_uae_abu;
	private BigDecimal	r17_no_of_accounts_non_uae_abu;
	private BigDecimal	r17_amount_non_uae_abu;
	private BigDecimal	r17_total_abu;
	private BigDecimal	r17_no_of_accounts_uae_dubai;
	private BigDecimal	r17_amount_uae_dubai;
	private BigDecimal	r17_no_of_accounts_non_uae_dubai;
	private BigDecimal	r17_amount_non_uae_dubai;
	private BigDecimal	r17_total_dubai;
	private BigDecimal	r17_no_of_accounts_uae_sharjah;
	private BigDecimal	r17_amount_uae_sharjah;
	private BigDecimal	r17_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r17_amount_non_uae_sharjah;
	private BigDecimal	r17_total_sharjah;
	private BigDecimal	r17_no_of_accounts_uae_ajman;
	private BigDecimal	r17_amount_uae_ajman;
	private BigDecimal	r17_no_of_accounts_non_uae_ajman;
	private BigDecimal	r17_amount_non_uae_ajman;
	private BigDecimal	r17_total_ajman;
	private BigDecimal	r17_no_of_accounts_uae_ras ;
	private BigDecimal	r17_amount_uae_ras ;
	private BigDecimal	r17_no_of_accounts_non_uae_ras ;
	private BigDecimal	r17_amount_non_uae_ras ;
	private BigDecimal	r17_total_ras ;
	private BigDecimal	r17_no_of_accounts_uae_umm ;
	private BigDecimal	r17_amount_uae_umm ;
	private BigDecimal	r17_no_of_accounts_non_uae_umm ;
	private BigDecimal	r17_amount_non_uae_umm ;
	private BigDecimal	r17_total_umm ;
	private BigDecimal	r17_no_of_accounts_uae_fujairah;
	private BigDecimal	r17_amount_uae_fujairah;
	private BigDecimal	r17_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r17_amount_non_uae_fujairah;
	private BigDecimal	r17_total_fujairah;
	private String	r18_product;
	private BigDecimal	r18_no_of_accounts_uae;
	private BigDecimal	r18_amount_uae;
	private BigDecimal	r18_no_of_accounts_resident;
	private BigDecimal	r18_amount_resident;
	private BigDecimal	r18_no_of_accounts_non_resident;
	private BigDecimal	r18_amount_non_resident;
	private BigDecimal	r18_total_account;
	private BigDecimal	r18_total_amount;
	private BigDecimal	r18_no_of_accounts_uae_abu;
	private BigDecimal	r18_amount_uae_abu;
	private BigDecimal	r18_no_of_accounts_non_uae_abu;
	private BigDecimal	r18_amount_non_uae_abu;
	private BigDecimal	r18_total_abu;
	private BigDecimal	r18_no_of_accounts_uae_dubai;
	private BigDecimal	r18_amount_uae_dubai;
	private BigDecimal	r18_no_of_accounts_non_uae_dubai;
	private BigDecimal	r18_amount_non_uae_dubai;
	private BigDecimal	r18_total_dubai;
	private BigDecimal	r18_no_of_accounts_uae_sharjah;
	private BigDecimal	r18_amount_uae_sharjah;
	private BigDecimal	r18_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r18_amount_non_uae_sharjah;
	private BigDecimal	r18_total_sharjah;
	private BigDecimal	r18_no_of_accounts_uae_ajman;
	private BigDecimal	r18_amount_uae_ajman;
	private BigDecimal	r18_no_of_accounts_non_uae_ajman;
	private BigDecimal	r18_amount_non_uae_ajman;
	private BigDecimal	r18_total_ajman;
	private BigDecimal	r18_no_of_accounts_uae_ras ;
	private BigDecimal	r18_amount_uae_ras ;
	private BigDecimal	r18_no_of_accounts_non_uae_ras ;
	private BigDecimal	r18_amount_non_uae_ras ;
	private BigDecimal	r18_total_ras ;
	private BigDecimal	r18_no_of_accounts_uae_umm ;
	private BigDecimal	r18_amount_uae_umm ;
	private BigDecimal	r18_no_of_accounts_non_uae_umm ;
	private BigDecimal	r18_amount_non_uae_umm ;
	private BigDecimal	r18_total_umm ;
	private BigDecimal	r18_no_of_accounts_uae_fujairah;
	private BigDecimal	r18_amount_uae_fujairah;
	private BigDecimal	r18_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r18_amount_non_uae_fujairah;
	private BigDecimal	r18_total_fujairah;
	private String	r19_product;
	private BigDecimal	r19_no_of_accounts_uae;
	private BigDecimal	r19_amount_uae;
	private BigDecimal	r19_no_of_accounts_resident;
	private BigDecimal	r19_amount_resident;
	private BigDecimal	r19_no_of_accounts_non_resident;
	private BigDecimal	r19_amount_non_resident;
	private BigDecimal	r19_total_account;
	private BigDecimal	r19_total_amount;
	private BigDecimal	r19_no_of_accounts_uae_abu;
	private BigDecimal	r19_amount_uae_abu;
	private BigDecimal	r19_no_of_accounts_non_uae_abu;
	private BigDecimal	r19_amount_non_uae_abu;
	private BigDecimal	r19_total_abu;
	private BigDecimal	r19_no_of_accounts_uae_dubai;
	private BigDecimal	r19_amount_uae_dubai;
	private BigDecimal	r19_no_of_accounts_non_uae_dubai;
	private BigDecimal	r19_amount_non_uae_dubai;
	private BigDecimal	r19_total_dubai;
	private BigDecimal	r19_no_of_accounts_uae_sharjah;
	private BigDecimal	r19_amount_uae_sharjah;
	private BigDecimal	r19_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r19_amount_non_uae_sharjah;
	private BigDecimal	r19_total_sharjah;
	private BigDecimal	r19_no_of_accounts_uae_ajman;
	private BigDecimal	r19_amount_uae_ajman;
	private BigDecimal	r19_no_of_accounts_non_uae_ajman;
	private BigDecimal	r19_amount_non_uae_ajman;
	private BigDecimal	r19_total_ajman;
	private BigDecimal	r19_no_of_accounts_uae_ras ;
	private BigDecimal	r19_amount_uae_ras ;
	private BigDecimal	r19_no_of_accounts_non_uae_ras ;
	private BigDecimal	r19_amount_non_uae_ras ;
	private BigDecimal	r19_total_ras ;
	private BigDecimal	r19_no_of_accounts_uae_umm ;
	private BigDecimal	r19_amount_uae_umm ;
	private BigDecimal	r19_no_of_accounts_non_uae_umm ;
	private BigDecimal	r19_amount_non_uae_umm ;
	private BigDecimal	r19_total_umm ;
	private BigDecimal	r19_no_of_accounts_uae_fujairah;
	private BigDecimal	r19_amount_uae_fujairah;
	private BigDecimal	r19_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r19_amount_non_uae_fujairah;
	private BigDecimal	r19_total_fujairah;
	private String	r20_product;
	private BigDecimal	r20_no_of_accounts_uae;
	private BigDecimal	r20_amount_uae;
	private BigDecimal	r20_no_of_accounts_resident;
	private BigDecimal	r20_amount_resident;
	private BigDecimal	r20_no_of_accounts_non_resident;
	private BigDecimal	r20_amount_non_resident;
	private BigDecimal	r20_total_account;
	private BigDecimal	r20_total_amount;
	private BigDecimal	r20_no_of_accounts_uae_abu;
	private BigDecimal	r20_amount_uae_abu;
	private BigDecimal	r20_no_of_accounts_non_uae_abu;
	private BigDecimal	r20_amount_non_uae_abu;
	private BigDecimal	r20_total_abu;
	private BigDecimal	r20_no_of_accounts_uae_dubai;
	private BigDecimal	r20_amount_uae_dubai;
	private BigDecimal	r20_no_of_accounts_non_uae_dubai;
	private BigDecimal	r20_amount_non_uae_dubai;
	private BigDecimal	r20_total_dubai;
	private BigDecimal	r20_no_of_accounts_uae_sharjah;
	private BigDecimal	r20_amount_uae_sharjah;
	private BigDecimal	r20_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r20_amount_non_uae_sharjah;
	private BigDecimal	r20_total_sharjah;
	private BigDecimal	r20_no_of_accounts_uae_ajman;
	private BigDecimal	r20_amount_uae_ajman;
	private BigDecimal	r20_no_of_accounts_non_uae_ajman;
	private BigDecimal	r20_amount_non_uae_ajman;
	private BigDecimal	r20_total_ajman;
	private BigDecimal	r20_no_of_accounts_uae_ras ;
	private BigDecimal	r20_amount_uae_ras ;
	private BigDecimal	r20_no_of_accounts_non_uae_ras ;
	private BigDecimal	r20_amount_non_uae_ras ;
	private BigDecimal	r20_total_ras ;
	private BigDecimal	r20_no_of_accounts_uae_umm ;
	private BigDecimal	r20_amount_uae_umm ;
	private BigDecimal	r20_no_of_accounts_non_uae_umm ;
	private BigDecimal	r20_amount_non_uae_umm ;
	private BigDecimal	r20_total_umm ;
	private BigDecimal	r20_no_of_accounts_uae_fujairah;
	private BigDecimal	r20_amount_uae_fujairah;
	private BigDecimal	r20_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r20_amount_non_uae_fujairah;
	private BigDecimal	r20_total_fujairah;
	private String	r21_product;
	private BigDecimal	r21_no_of_accounts_uae;
	private BigDecimal	r21_amount_uae;
	private BigDecimal	r21_no_of_accounts_resident;
	private BigDecimal	r21_amount_resident;
	private BigDecimal	r21_no_of_accounts_non_resident;
	private BigDecimal	r21_amount_non_resident;
	private BigDecimal	r21_total_account;
	private BigDecimal	r21_total_amount;
	private BigDecimal	r21_no_of_accounts_uae_abu;
	private BigDecimal	r21_amount_uae_abu;
	private BigDecimal	r21_no_of_accounts_non_uae_abu;
	private BigDecimal	r21_amount_non_uae_abu;
	private BigDecimal	r21_total_abu;
	private BigDecimal	r21_no_of_accounts_uae_dubai;
	private BigDecimal	r21_amount_uae_dubai;
	private BigDecimal	r21_no_of_accounts_non_uae_dubai;
	private BigDecimal	r21_amount_non_uae_dubai;
	private BigDecimal	r21_total_dubai;
	private BigDecimal	r21_no_of_accounts_uae_sharjah;
	private BigDecimal	r21_amount_uae_sharjah;
	private BigDecimal	r21_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r21_amount_non_uae_sharjah;
	private BigDecimal	r21_total_sharjah;
	private BigDecimal	r21_no_of_accounts_uae_ajman;
	private BigDecimal	r21_amount_uae_ajman;
	private BigDecimal	r21_no_of_accounts_non_uae_ajman;
	private BigDecimal	r21_amount_non_uae_ajman;
	private BigDecimal	r21_total_ajman;
	private BigDecimal	r21_no_of_accounts_uae_ras ;
	private BigDecimal	r21_amount_uae_ras ;
	private BigDecimal	r21_no_of_accounts_non_uae_ras ;
	private BigDecimal	r21_amount_non_uae_ras ;
	private BigDecimal	r21_total_ras ;
	private BigDecimal	r21_no_of_accounts_uae_umm ;
	private BigDecimal	r21_amount_uae_umm ;
	private BigDecimal	r21_no_of_accounts_non_uae_umm ;
	private BigDecimal	r21_amount_non_uae_umm ;
	private BigDecimal	r21_total_umm ;
	private BigDecimal	r21_no_of_accounts_uae_fujairah;
	private BigDecimal	r21_amount_uae_fujairah;
	private BigDecimal	r21_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r21_amount_non_uae_fujairah;
	private BigDecimal	r21_total_fujairah;
	private String	r22_product;
	private BigDecimal	r22_no_of_accounts_uae;
	private BigDecimal	r22_amount_uae;
	private BigDecimal	r22_no_of_accounts_resident;
	private BigDecimal	r22_amount_resident;
	private BigDecimal	r22_no_of_accounts_non_resident;
	private BigDecimal	r22_amount_non_resident;
	private BigDecimal	r22_total_account;
	private BigDecimal	r22_total_amount;
	private BigDecimal	r22_no_of_accounts_uae_abu;
	private BigDecimal	r22_amount_uae_abu;
	private BigDecimal	r22_no_of_accounts_non_uae_abu;
	private BigDecimal	r22_amount_non_uae_abu;
	private BigDecimal	r22_total_abu;
	private BigDecimal	r22_no_of_accounts_uae_dubai;
	private BigDecimal	r22_amount_uae_dubai;
	private BigDecimal	r22_no_of_accounts_non_uae_dubai;
	private BigDecimal	r22_amount_non_uae_dubai;
	private BigDecimal	r22_total_dubai;
	private BigDecimal	r22_no_of_accounts_uae_sharjah;
	private BigDecimal	r22_amount_uae_sharjah;
	private BigDecimal	r22_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r22_amount_non_uae_sharjah;
	private BigDecimal	r22_total_sharjah;
	private BigDecimal	r22_no_of_accounts_uae_ajman;
	private BigDecimal	r22_amount_uae_ajman;
	private BigDecimal	r22_no_of_accounts_non_uae_ajman;
	private BigDecimal	r22_amount_non_uae_ajman;
	private BigDecimal	r22_total_ajman;
	private BigDecimal	r22_no_of_accounts_uae_ras ;
	private BigDecimal	r22_amount_uae_ras ;
	private BigDecimal	r22_no_of_accounts_non_uae_ras ;
	private BigDecimal	r22_amount_non_uae_ras ;
	private BigDecimal	r22_total_ras ;
	private BigDecimal	r22_no_of_accounts_uae_umm ;
	private BigDecimal	r22_amount_uae_umm ;
	private BigDecimal	r22_no_of_accounts_non_uae_umm ;
	private BigDecimal	r22_amount_non_uae_umm ;
	private BigDecimal	r22_total_umm ;
	private BigDecimal	r22_no_of_accounts_uae_fujairah;
	private BigDecimal	r22_amount_uae_fujairah;
	private BigDecimal	r22_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r22_amount_non_uae_fujairah;
	private BigDecimal	r22_total_fujairah;
	private String	r23_product;
	private BigDecimal	r23_no_of_accounts_uae;
	private BigDecimal	r23_amount_uae;
	private BigDecimal	r23_no_of_accounts_resident;
	private BigDecimal	r23_amount_resident;
	private BigDecimal	r23_no_of_accounts_non_resident;
	private BigDecimal	r23_amount_non_resident;
	private BigDecimal	r23_total_account;
	private BigDecimal	r23_total_amount;
	private BigDecimal	r23_no_of_accounts_uae_abu;
	private BigDecimal	r23_amount_uae_abu;
	private BigDecimal	r23_no_of_accounts_non_uae_abu;
	private BigDecimal	r23_amount_non_uae_abu;
	private BigDecimal	r23_total_abu;
	private BigDecimal	r23_no_of_accounts_uae_dubai;
	private BigDecimal	r23_amount_uae_dubai;
	private BigDecimal	r23_no_of_accounts_non_uae_dubai;
	private BigDecimal	r23_amount_non_uae_dubai;
	private BigDecimal	r23_total_dubai;
	private BigDecimal	r23_no_of_accounts_uae_sharjah;
	private BigDecimal	r23_amount_uae_sharjah;
	private BigDecimal	r23_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r23_amount_non_uae_sharjah;
	private BigDecimal	r23_total_sharjah;
	private BigDecimal	r23_no_of_accounts_uae_ajman;
	private BigDecimal	r23_amount_uae_ajman;
	private BigDecimal	r23_no_of_accounts_non_uae_ajman;
	private BigDecimal	r23_amount_non_uae_ajman;
	private BigDecimal	r23_total_ajman;
	private BigDecimal	r23_no_of_accounts_uae_ras ;
	private BigDecimal	r23_amount_uae_ras ;
	private BigDecimal	r23_no_of_accounts_non_uae_ras ;
	private BigDecimal	r23_amount_non_uae_ras ;
	private BigDecimal	r23_total_ras ;
	private BigDecimal	r23_no_of_accounts_uae_umm ;
	private BigDecimal	r23_amount_uae_umm ;
	private BigDecimal	r23_no_of_accounts_non_uae_umm ;
	private BigDecimal	r23_amount_non_uae_umm ;
	private BigDecimal	r23_total_umm ;
	private BigDecimal	r23_no_of_accounts_uae_fujairah;
	private BigDecimal	r23_amount_uae_fujairah;
	private BigDecimal	r23_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r23_amount_non_uae_fujairah;
	private BigDecimal	r23_total_fujairah;
	private String	r24_product;
	private BigDecimal	r24_no_of_accounts_uae;
	private BigDecimal	r24_amount_uae;
	private BigDecimal	r24_no_of_accounts_resident;
	private BigDecimal	r24_amount_resident;
	private BigDecimal	r24_no_of_accounts_non_resident;
	private BigDecimal	r24_amount_non_resident;
	private BigDecimal	r24_total_account;
	private BigDecimal	r24_total_amount;
	private BigDecimal	r24_no_of_accounts_uae_abu;
	private BigDecimal	r24_amount_uae_abu;
	private BigDecimal	r24_no_of_accounts_non_uae_abu;
	private BigDecimal	r24_amount_non_uae_abu;
	private BigDecimal	r24_total_abu;
	private BigDecimal	r24_no_of_accounts_uae_dubai;
	private BigDecimal	r24_amount_uae_dubai;
	private BigDecimal	r24_no_of_accounts_non_uae_dubai;
	private BigDecimal	r24_amount_non_uae_dubai;
	private BigDecimal	r24_total_dubai;
	private BigDecimal	r24_no_of_accounts_uae_sharjah;
	private BigDecimal	r24_amount_uae_sharjah;
	private BigDecimal	r24_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r24_amount_non_uae_sharjah;
	private BigDecimal	r24_total_sharjah;
	private BigDecimal	r24_no_of_accounts_uae_ajman;
	private BigDecimal	r24_amount_uae_ajman;
	private BigDecimal	r24_no_of_accounts_non_uae_ajman;
	private BigDecimal	r24_amount_non_uae_ajman;
	private BigDecimal	r24_total_ajman;
	private BigDecimal	r24_no_of_accounts_uae_ras ;
	private BigDecimal	r24_amount_uae_ras ;
	private BigDecimal	r24_no_of_accounts_non_uae_ras ;
	private BigDecimal	r24_amount_non_uae_ras ;
	private BigDecimal	r24_total_ras ;
	private BigDecimal	r24_no_of_accounts_uae_umm ;
	private BigDecimal	r24_amount_uae_umm ;
	private BigDecimal	r24_no_of_accounts_non_uae_umm ;
	private BigDecimal	r24_amount_non_uae_umm ;
	private BigDecimal	r24_total_umm ;
	private BigDecimal	r24_no_of_accounts_uae_fujairah;
	private BigDecimal	r24_amount_uae_fujairah;
	private BigDecimal	r24_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r24_amount_non_uae_fujairah;
	private BigDecimal	r24_total_fujairah;
	private String	r25_product;
	private BigDecimal	r25_no_of_accounts_uae;
	private BigDecimal	r25_amount_uae;
	private BigDecimal	r25_no_of_accounts_resident;
	private BigDecimal	r25_amount_resident;
	private BigDecimal	r25_no_of_accounts_non_resident;
	private BigDecimal	r25_amount_non_resident;
	private BigDecimal	r25_total_account;
	private BigDecimal	r25_total_amount;
	private BigDecimal	r25_no_of_accounts_uae_abu;
	private BigDecimal	r25_amount_uae_abu;
	private BigDecimal	r25_no_of_accounts_non_uae_abu;
	private BigDecimal	r25_amount_non_uae_abu;
	private BigDecimal	r25_total_abu;
	private BigDecimal	r25_no_of_accounts_uae_dubai;
	private BigDecimal	r25_amount_uae_dubai;
	private BigDecimal	r25_no_of_accounts_non_uae_dubai;
	private BigDecimal	r25_amount_non_uae_dubai;
	private BigDecimal	r25_total_dubai;
	private BigDecimal	r25_no_of_accounts_uae_sharjah;
	private BigDecimal	r25_amount_uae_sharjah;
	private BigDecimal	r25_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r25_amount_non_uae_sharjah;
	private BigDecimal	r25_total_sharjah;
	private BigDecimal	r25_no_of_accounts_uae_ajman;
	private BigDecimal	r25_amount_uae_ajman;
	private BigDecimal	r25_no_of_accounts_non_uae_ajman;
	private BigDecimal	r25_amount_non_uae_ajman;
	private BigDecimal	r25_total_ajman;
	private BigDecimal	r25_no_of_accounts_uae_ras ;
	private BigDecimal	r25_amount_uae_ras ;
	private BigDecimal	r25_no_of_accounts_non_uae_ras ;
	private BigDecimal	r25_amount_non_uae_ras ;
	private BigDecimal	r25_total_ras ;
	private BigDecimal	r25_no_of_accounts_uae_umm ;
	private BigDecimal	r25_amount_uae_umm ;
	private BigDecimal	r25_no_of_accounts_non_uae_umm ;
	private BigDecimal	r25_amount_non_uae_umm ;
	private BigDecimal	r25_total_umm ;
	private BigDecimal	r25_no_of_accounts_uae_fujairah;
	private BigDecimal	r25_amount_uae_fujairah;
	private BigDecimal	r25_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r25_amount_non_uae_fujairah;
	private BigDecimal	r25_total_fujairah;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private String	repdesc;
	private String	frequency;
	public String getR10_product() {
		return r10_product;
	}
	public void setR10_product(String r10_product) {
		this.r10_product = r10_product;
	}
	public BigDecimal getR10_no_of_accounts_uae() {
		return r10_no_of_accounts_uae;
	}
	public void setR10_no_of_accounts_uae(BigDecimal r10_no_of_accounts_uae) {
		this.r10_no_of_accounts_uae = r10_no_of_accounts_uae;
	}
	public BigDecimal getR10_amount_uae() {
		return r10_amount_uae;
	}
	public void setR10_amount_uae(BigDecimal r10_amount_uae) {
		this.r10_amount_uae = r10_amount_uae;
	}
	public BigDecimal getR10_no_of_accounts_resident() {
		return r10_no_of_accounts_resident;
	}
	public void setR10_no_of_accounts_resident(BigDecimal r10_no_of_accounts_resident) {
		this.r10_no_of_accounts_resident = r10_no_of_accounts_resident;
	}
	public BigDecimal getR10_amount_resident() {
		return r10_amount_resident;
	}
	public void setR10_amount_resident(BigDecimal r10_amount_resident) {
		this.r10_amount_resident = r10_amount_resident;
	}
	public BigDecimal getR10_no_of_accounts_non_resident() {
		return r10_no_of_accounts_non_resident;
	}
	public void setR10_no_of_accounts_non_resident(BigDecimal r10_no_of_accounts_non_resident) {
		this.r10_no_of_accounts_non_resident = r10_no_of_accounts_non_resident;
	}
	public BigDecimal getR10_amount_non_resident() {
		return r10_amount_non_resident;
	}
	public void setR10_amount_non_resident(BigDecimal r10_amount_non_resident) {
		this.r10_amount_non_resident = r10_amount_non_resident;
	}
	public BigDecimal getR10_total_account() {
		return r10_total_account;
	}
	public void setR10_total_account(BigDecimal r10_total_account) {
		this.r10_total_account = r10_total_account;
	}
	public BigDecimal getR10_total_amount() {
		return r10_total_amount;
	}
	public void setR10_total_amount(BigDecimal r10_total_amount) {
		this.r10_total_amount = r10_total_amount;
	}
	public BigDecimal getR10_no_of_accounts_uae_abu() {
		return r10_no_of_accounts_uae_abu;
	}
	public void setR10_no_of_accounts_uae_abu(BigDecimal r10_no_of_accounts_uae_abu) {
		this.r10_no_of_accounts_uae_abu = r10_no_of_accounts_uae_abu;
	}
	public BigDecimal getR10_amount_uae_abu() {
		return r10_amount_uae_abu;
	}
	public void setR10_amount_uae_abu(BigDecimal r10_amount_uae_abu) {
		this.r10_amount_uae_abu = r10_amount_uae_abu;
	}
	public BigDecimal getR10_no_of_accounts_non_uae_abu() {
		return r10_no_of_accounts_non_uae_abu;
	}
	public void setR10_no_of_accounts_non_uae_abu(BigDecimal r10_no_of_accounts_non_uae_abu) {
		this.r10_no_of_accounts_non_uae_abu = r10_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR10_amount_non_uae_abu() {
		return r10_amount_non_uae_abu;
	}
	public void setR10_amount_non_uae_abu(BigDecimal r10_amount_non_uae_abu) {
		this.r10_amount_non_uae_abu = r10_amount_non_uae_abu;
	}
	public BigDecimal getR10_total_abu() {
		return r10_total_abu;
	}
	public void setR10_total_abu(BigDecimal r10_total_abu) {
		this.r10_total_abu = r10_total_abu;
	}
	public BigDecimal getR10_no_of_accounts_uae_dubai() {
		return r10_no_of_accounts_uae_dubai;
	}
	public void setR10_no_of_accounts_uae_dubai(BigDecimal r10_no_of_accounts_uae_dubai) {
		this.r10_no_of_accounts_uae_dubai = r10_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR10_amount_uae_dubai() {
		return r10_amount_uae_dubai;
	}
	public void setR10_amount_uae_dubai(BigDecimal r10_amount_uae_dubai) {
		this.r10_amount_uae_dubai = r10_amount_uae_dubai;
	}
	public BigDecimal getR10_no_of_accounts_non_uae_dubai() {
		return r10_no_of_accounts_non_uae_dubai;
	}
	public void setR10_no_of_accounts_non_uae_dubai(BigDecimal r10_no_of_accounts_non_uae_dubai) {
		this.r10_no_of_accounts_non_uae_dubai = r10_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR10_amount_non_uae_dubai() {
		return r10_amount_non_uae_dubai;
	}
	public void setR10_amount_non_uae_dubai(BigDecimal r10_amount_non_uae_dubai) {
		this.r10_amount_non_uae_dubai = r10_amount_non_uae_dubai;
	}
	public BigDecimal getR10_total_dubai() {
		return r10_total_dubai;
	}
	public void setR10_total_dubai(BigDecimal r10_total_dubai) {
		this.r10_total_dubai = r10_total_dubai;
	}
	public BigDecimal getR10_no_of_accounts_uae_sharjah() {
		return r10_no_of_accounts_uae_sharjah;
	}
	public void setR10_no_of_accounts_uae_sharjah(BigDecimal r10_no_of_accounts_uae_sharjah) {
		this.r10_no_of_accounts_uae_sharjah = r10_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR10_amount_uae_sharjah() {
		return r10_amount_uae_sharjah;
	}
	public void setR10_amount_uae_sharjah(BigDecimal r10_amount_uae_sharjah) {
		this.r10_amount_uae_sharjah = r10_amount_uae_sharjah;
	}
	public BigDecimal getR10_no_of_accounts_non_uae_sharjah() {
		return r10_no_of_accounts_non_uae_sharjah;
	}
	public void setR10_no_of_accounts_non_uae_sharjah(BigDecimal r10_no_of_accounts_non_uae_sharjah) {
		this.r10_no_of_accounts_non_uae_sharjah = r10_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR10_amount_non_uae_sharjah() {
		return r10_amount_non_uae_sharjah;
	}
	public void setR10_amount_non_uae_sharjah(BigDecimal r10_amount_non_uae_sharjah) {
		this.r10_amount_non_uae_sharjah = r10_amount_non_uae_sharjah;
	}
	public BigDecimal getR10_total_sharjah() {
		return r10_total_sharjah;
	}
	public void setR10_total_sharjah(BigDecimal r10_total_sharjah) {
		this.r10_total_sharjah = r10_total_sharjah;
	}
	public BigDecimal getR10_no_of_accounts_uae_ajman() {
		return r10_no_of_accounts_uae_ajman;
	}
	public void setR10_no_of_accounts_uae_ajman(BigDecimal r10_no_of_accounts_uae_ajman) {
		this.r10_no_of_accounts_uae_ajman = r10_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR10_amount_uae_ajman() {
		return r10_amount_uae_ajman;
	}
	public void setR10_amount_uae_ajman(BigDecimal r10_amount_uae_ajman) {
		this.r10_amount_uae_ajman = r10_amount_uae_ajman;
	}
	public BigDecimal getR10_no_of_accounts_non_uae_ajman() {
		return r10_no_of_accounts_non_uae_ajman;
	}
	public void setR10_no_of_accounts_non_uae_ajman(BigDecimal r10_no_of_accounts_non_uae_ajman) {
		this.r10_no_of_accounts_non_uae_ajman = r10_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR10_amount_non_uae_ajman() {
		return r10_amount_non_uae_ajman;
	}
	public void setR10_amount_non_uae_ajman(BigDecimal r10_amount_non_uae_ajman) {
		this.r10_amount_non_uae_ajman = r10_amount_non_uae_ajman;
	}
	public BigDecimal getR10_total_ajman() {
		return r10_total_ajman;
	}
	public void setR10_total_ajman(BigDecimal r10_total_ajman) {
		this.r10_total_ajman = r10_total_ajman;
	}
	public BigDecimal getR10_no_of_accounts_uae_ras() {
		return r10_no_of_accounts_uae_ras;
	}
	public void setR10_no_of_accounts_uae_ras(BigDecimal r10_no_of_accounts_uae_ras) {
		this.r10_no_of_accounts_uae_ras = r10_no_of_accounts_uae_ras;
	}
	public BigDecimal getR10_amount_uae_ras() {
		return r10_amount_uae_ras;
	}
	public void setR10_amount_uae_ras(BigDecimal r10_amount_uae_ras) {
		this.r10_amount_uae_ras = r10_amount_uae_ras;
	}
	public BigDecimal getR10_no_of_accounts_non_uae_ras() {
		return r10_no_of_accounts_non_uae_ras;
	}
	public void setR10_no_of_accounts_non_uae_ras(BigDecimal r10_no_of_accounts_non_uae_ras) {
		this.r10_no_of_accounts_non_uae_ras = r10_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR10_amount_non_uae_ras() {
		return r10_amount_non_uae_ras;
	}
	public void setR10_amount_non_uae_ras(BigDecimal r10_amount_non_uae_ras) {
		this.r10_amount_non_uae_ras = r10_amount_non_uae_ras;
	}
	public BigDecimal getR10_total_ras() {
		return r10_total_ras;
	}
	public void setR10_total_ras(BigDecimal r10_total_ras) {
		this.r10_total_ras = r10_total_ras;
	}
	public BigDecimal getR10_no_of_accounts_uae_umm() {
		return r10_no_of_accounts_uae_umm;
	}
	public void setR10_no_of_accounts_uae_umm(BigDecimal r10_no_of_accounts_uae_umm) {
		this.r10_no_of_accounts_uae_umm = r10_no_of_accounts_uae_umm;
	}
	public BigDecimal getR10_amount_uae_umm() {
		return r10_amount_uae_umm;
	}
	public void setR10_amount_uae_umm(BigDecimal r10_amount_uae_umm) {
		this.r10_amount_uae_umm = r10_amount_uae_umm;
	}
	public BigDecimal getR10_no_of_accounts_non_uae_umm() {
		return r10_no_of_accounts_non_uae_umm;
	}
	public void setR10_no_of_accounts_non_uae_umm(BigDecimal r10_no_of_accounts_non_uae_umm) {
		this.r10_no_of_accounts_non_uae_umm = r10_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR10_amount_non_uae_umm() {
		return r10_amount_non_uae_umm;
	}
	public void setR10_amount_non_uae_umm(BigDecimal r10_amount_non_uae_umm) {
		this.r10_amount_non_uae_umm = r10_amount_non_uae_umm;
	}
	public BigDecimal getR10_total_umm() {
		return r10_total_umm;
	}
	public void setR10_total_umm(BigDecimal r10_total_umm) {
		this.r10_total_umm = r10_total_umm;
	}
	public BigDecimal getR10_no_of_accounts_uae_fujairah() {
		return r10_no_of_accounts_uae_fujairah;
	}
	public void setR10_no_of_accounts_uae_fujairah(BigDecimal r10_no_of_accounts_uae_fujairah) {
		this.r10_no_of_accounts_uae_fujairah = r10_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR10_amount_uae_fujairah() {
		return r10_amount_uae_fujairah;
	}
	public void setR10_amount_uae_fujairah(BigDecimal r10_amount_uae_fujairah) {
		this.r10_amount_uae_fujairah = r10_amount_uae_fujairah;
	}
	public BigDecimal getR10_no_of_accounts_non_uae_fujairah() {
		return r10_no_of_accounts_non_uae_fujairah;
	}
	public void setR10_no_of_accounts_non_uae_fujairah(BigDecimal r10_no_of_accounts_non_uae_fujairah) {
		this.r10_no_of_accounts_non_uae_fujairah = r10_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR10_amount_non_uae_fujairah() {
		return r10_amount_non_uae_fujairah;
	}
	public void setR10_amount_non_uae_fujairah(BigDecimal r10_amount_non_uae_fujairah) {
		this.r10_amount_non_uae_fujairah = r10_amount_non_uae_fujairah;
	}
	public BigDecimal getR10_total_fujairah() {
		return r10_total_fujairah;
	}
	public void setR10_total_fujairah(BigDecimal r10_total_fujairah) {
		this.r10_total_fujairah = r10_total_fujairah;
	}
	public String getR11_product() {
		return r11_product;
	}
	public void setR11_product(String r11_product) {
		this.r11_product = r11_product;
	}
	public BigDecimal getR11_no_of_accounts_uae() {
		return r11_no_of_accounts_uae;
	}
	public void setR11_no_of_accounts_uae(BigDecimal r11_no_of_accounts_uae) {
		this.r11_no_of_accounts_uae = r11_no_of_accounts_uae;
	}
	public BigDecimal getR11_amount_uae() {
		return r11_amount_uae;
	}
	public void setR11_amount_uae(BigDecimal r11_amount_uae) {
		this.r11_amount_uae = r11_amount_uae;
	}
	public BigDecimal getR11_no_of_accounts_resident() {
		return r11_no_of_accounts_resident;
	}
	public void setR11_no_of_accounts_resident(BigDecimal r11_no_of_accounts_resident) {
		this.r11_no_of_accounts_resident = r11_no_of_accounts_resident;
	}
	public BigDecimal getR11_amount_resident() {
		return r11_amount_resident;
	}
	public void setR11_amount_resident(BigDecimal r11_amount_resident) {
		this.r11_amount_resident = r11_amount_resident;
	}
	public BigDecimal getR11_no_of_accounts_non_resident() {
		return r11_no_of_accounts_non_resident;
	}
	public void setR11_no_of_accounts_non_resident(BigDecimal r11_no_of_accounts_non_resident) {
		this.r11_no_of_accounts_non_resident = r11_no_of_accounts_non_resident;
	}
	public BigDecimal getR11_amount_non_resident() {
		return r11_amount_non_resident;
	}
	public void setR11_amount_non_resident(BigDecimal r11_amount_non_resident) {
		this.r11_amount_non_resident = r11_amount_non_resident;
	}
	public BigDecimal getR11_total_account() {
		return r11_total_account;
	}
	public void setR11_total_account(BigDecimal r11_total_account) {
		this.r11_total_account = r11_total_account;
	}
	public BigDecimal getR11_total_amount() {
		return r11_total_amount;
	}
	public void setR11_total_amount(BigDecimal r11_total_amount) {
		this.r11_total_amount = r11_total_amount;
	}
	public BigDecimal getR11_no_of_accounts_uae_abu() {
		return r11_no_of_accounts_uae_abu;
	}
	public void setR11_no_of_accounts_uae_abu(BigDecimal r11_no_of_accounts_uae_abu) {
		this.r11_no_of_accounts_uae_abu = r11_no_of_accounts_uae_abu;
	}
	public BigDecimal getR11_amount_uae_abu() {
		return r11_amount_uae_abu;
	}
	public void setR11_amount_uae_abu(BigDecimal r11_amount_uae_abu) {
		this.r11_amount_uae_abu = r11_amount_uae_abu;
	}
	public BigDecimal getR11_no_of_accounts_non_uae_abu() {
		return r11_no_of_accounts_non_uae_abu;
	}
	public void setR11_no_of_accounts_non_uae_abu(BigDecimal r11_no_of_accounts_non_uae_abu) {
		this.r11_no_of_accounts_non_uae_abu = r11_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR11_amount_non_uae_abu() {
		return r11_amount_non_uae_abu;
	}
	public void setR11_amount_non_uae_abu(BigDecimal r11_amount_non_uae_abu) {
		this.r11_amount_non_uae_abu = r11_amount_non_uae_abu;
	}
	public BigDecimal getR11_total_abu() {
		return r11_total_abu;
	}
	public void setR11_total_abu(BigDecimal r11_total_abu) {
		this.r11_total_abu = r11_total_abu;
	}
	public BigDecimal getR11_no_of_accounts_uae_dubai() {
		return r11_no_of_accounts_uae_dubai;
	}
	public void setR11_no_of_accounts_uae_dubai(BigDecimal r11_no_of_accounts_uae_dubai) {
		this.r11_no_of_accounts_uae_dubai = r11_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR11_amount_uae_dubai() {
		return r11_amount_uae_dubai;
	}
	public void setR11_amount_uae_dubai(BigDecimal r11_amount_uae_dubai) {
		this.r11_amount_uae_dubai = r11_amount_uae_dubai;
	}
	public BigDecimal getR11_no_of_accounts_non_uae_dubai() {
		return r11_no_of_accounts_non_uae_dubai;
	}
	public void setR11_no_of_accounts_non_uae_dubai(BigDecimal r11_no_of_accounts_non_uae_dubai) {
		this.r11_no_of_accounts_non_uae_dubai = r11_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR11_amount_non_uae_dubai() {
		return r11_amount_non_uae_dubai;
	}
	public void setR11_amount_non_uae_dubai(BigDecimal r11_amount_non_uae_dubai) {
		this.r11_amount_non_uae_dubai = r11_amount_non_uae_dubai;
	}
	public BigDecimal getR11_total_dubai() {
		return r11_total_dubai;
	}
	public void setR11_total_dubai(BigDecimal r11_total_dubai) {
		this.r11_total_dubai = r11_total_dubai;
	}
	public BigDecimal getR11_no_of_accounts_uae_sharjah() {
		return r11_no_of_accounts_uae_sharjah;
	}
	public void setR11_no_of_accounts_uae_sharjah(BigDecimal r11_no_of_accounts_uae_sharjah) {
		this.r11_no_of_accounts_uae_sharjah = r11_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR11_amount_uae_sharjah() {
		return r11_amount_uae_sharjah;
	}
	public void setR11_amount_uae_sharjah(BigDecimal r11_amount_uae_sharjah) {
		this.r11_amount_uae_sharjah = r11_amount_uae_sharjah;
	}
	public BigDecimal getR11_no_of_accounts_non_uae_sharjah() {
		return r11_no_of_accounts_non_uae_sharjah;
	}
	public void setR11_no_of_accounts_non_uae_sharjah(BigDecimal r11_no_of_accounts_non_uae_sharjah) {
		this.r11_no_of_accounts_non_uae_sharjah = r11_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR11_amount_non_uae_sharjah() {
		return r11_amount_non_uae_sharjah;
	}
	public void setR11_amount_non_uae_sharjah(BigDecimal r11_amount_non_uae_sharjah) {
		this.r11_amount_non_uae_sharjah = r11_amount_non_uae_sharjah;
	}
	public BigDecimal getR11_total_sharjah() {
		return r11_total_sharjah;
	}
	public void setR11_total_sharjah(BigDecimal r11_total_sharjah) {
		this.r11_total_sharjah = r11_total_sharjah;
	}
	public BigDecimal getR11_no_of_accounts_uae_ajman() {
		return r11_no_of_accounts_uae_ajman;
	}
	public void setR11_no_of_accounts_uae_ajman(BigDecimal r11_no_of_accounts_uae_ajman) {
		this.r11_no_of_accounts_uae_ajman = r11_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR11_amount_uae_ajman() {
		return r11_amount_uae_ajman;
	}
	public void setR11_amount_uae_ajman(BigDecimal r11_amount_uae_ajman) {
		this.r11_amount_uae_ajman = r11_amount_uae_ajman;
	}
	public BigDecimal getR11_no_of_accounts_non_uae_ajman() {
		return r11_no_of_accounts_non_uae_ajman;
	}
	public void setR11_no_of_accounts_non_uae_ajman(BigDecimal r11_no_of_accounts_non_uae_ajman) {
		this.r11_no_of_accounts_non_uae_ajman = r11_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR11_amount_non_uae_ajman() {
		return r11_amount_non_uae_ajman;
	}
	public void setR11_amount_non_uae_ajman(BigDecimal r11_amount_non_uae_ajman) {
		this.r11_amount_non_uae_ajman = r11_amount_non_uae_ajman;
	}
	public BigDecimal getR11_total_ajman() {
		return r11_total_ajman;
	}
	public void setR11_total_ajman(BigDecimal r11_total_ajman) {
		this.r11_total_ajman = r11_total_ajman;
	}
	public BigDecimal getR11_no_of_accounts_uae_ras() {
		return r11_no_of_accounts_uae_ras;
	}
	public void setR11_no_of_accounts_uae_ras(BigDecimal r11_no_of_accounts_uae_ras) {
		this.r11_no_of_accounts_uae_ras = r11_no_of_accounts_uae_ras;
	}
	public BigDecimal getR11_amount_uae_ras() {
		return r11_amount_uae_ras;
	}
	public void setR11_amount_uae_ras(BigDecimal r11_amount_uae_ras) {
		this.r11_amount_uae_ras = r11_amount_uae_ras;
	}
	public BigDecimal getR11_no_of_accounts_non_uae_ras() {
		return r11_no_of_accounts_non_uae_ras;
	}
	public void setR11_no_of_accounts_non_uae_ras(BigDecimal r11_no_of_accounts_non_uae_ras) {
		this.r11_no_of_accounts_non_uae_ras = r11_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR11_amount_non_uae_ras() {
		return r11_amount_non_uae_ras;
	}
	public void setR11_amount_non_uae_ras(BigDecimal r11_amount_non_uae_ras) {
		this.r11_amount_non_uae_ras = r11_amount_non_uae_ras;
	}
	public BigDecimal getR11_total_ras() {
		return r11_total_ras;
	}
	public void setR11_total_ras(BigDecimal r11_total_ras) {
		this.r11_total_ras = r11_total_ras;
	}
	public BigDecimal getR11_no_of_accounts_uae_umm() {
		return r11_no_of_accounts_uae_umm;
	}
	public void setR11_no_of_accounts_uae_umm(BigDecimal r11_no_of_accounts_uae_umm) {
		this.r11_no_of_accounts_uae_umm = r11_no_of_accounts_uae_umm;
	}
	public BigDecimal getR11_amount_uae_umm() {
		return r11_amount_uae_umm;
	}
	public void setR11_amount_uae_umm(BigDecimal r11_amount_uae_umm) {
		this.r11_amount_uae_umm = r11_amount_uae_umm;
	}
	public BigDecimal getR11_no_of_accounts_non_uae_umm() {
		return r11_no_of_accounts_non_uae_umm;
	}
	public void setR11_no_of_accounts_non_uae_umm(BigDecimal r11_no_of_accounts_non_uae_umm) {
		this.r11_no_of_accounts_non_uae_umm = r11_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR11_amount_non_uae_umm() {
		return r11_amount_non_uae_umm;
	}
	public void setR11_amount_non_uae_umm(BigDecimal r11_amount_non_uae_umm) {
		this.r11_amount_non_uae_umm = r11_amount_non_uae_umm;
	}
	public BigDecimal getR11_total_umm() {
		return r11_total_umm;
	}
	public void setR11_total_umm(BigDecimal r11_total_umm) {
		this.r11_total_umm = r11_total_umm;
	}
	public BigDecimal getR11_no_of_accounts_uae_fujairah() {
		return r11_no_of_accounts_uae_fujairah;
	}
	public void setR11_no_of_accounts_uae_fujairah(BigDecimal r11_no_of_accounts_uae_fujairah) {
		this.r11_no_of_accounts_uae_fujairah = r11_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR11_amount_uae_fujairah() {
		return r11_amount_uae_fujairah;
	}
	public void setR11_amount_uae_fujairah(BigDecimal r11_amount_uae_fujairah) {
		this.r11_amount_uae_fujairah = r11_amount_uae_fujairah;
	}
	public BigDecimal getR11_no_of_accounts_non_uae_fujairah() {
		return r11_no_of_accounts_non_uae_fujairah;
	}
	public void setR11_no_of_accounts_non_uae_fujairah(BigDecimal r11_no_of_accounts_non_uae_fujairah) {
		this.r11_no_of_accounts_non_uae_fujairah = r11_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR11_amount_non_uae_fujairah() {
		return r11_amount_non_uae_fujairah;
	}
	public void setR11_amount_non_uae_fujairah(BigDecimal r11_amount_non_uae_fujairah) {
		this.r11_amount_non_uae_fujairah = r11_amount_non_uae_fujairah;
	}
	public BigDecimal getR11_total_fujairah() {
		return r11_total_fujairah;
	}
	public void setR11_total_fujairah(BigDecimal r11_total_fujairah) {
		this.r11_total_fujairah = r11_total_fujairah;
	}
	public String getR12_product() {
		return r12_product;
	}
	public void setR12_product(String r12_product) {
		this.r12_product = r12_product;
	}
	public BigDecimal getR12_no_of_accounts_uae() {
		return r12_no_of_accounts_uae;
	}
	public void setR12_no_of_accounts_uae(BigDecimal r12_no_of_accounts_uae) {
		this.r12_no_of_accounts_uae = r12_no_of_accounts_uae;
	}
	public BigDecimal getR12_amount_uae() {
		return r12_amount_uae;
	}
	public void setR12_amount_uae(BigDecimal r12_amount_uae) {
		this.r12_amount_uae = r12_amount_uae;
	}
	public BigDecimal getR12_no_of_accounts_resident() {
		return r12_no_of_accounts_resident;
	}
	public void setR12_no_of_accounts_resident(BigDecimal r12_no_of_accounts_resident) {
		this.r12_no_of_accounts_resident = r12_no_of_accounts_resident;
	}
	public BigDecimal getR12_amount_resident() {
		return r12_amount_resident;
	}
	public void setR12_amount_resident(BigDecimal r12_amount_resident) {
		this.r12_amount_resident = r12_amount_resident;
	}
	public BigDecimal getR12_no_of_accounts_non_resident() {
		return r12_no_of_accounts_non_resident;
	}
	public void setR12_no_of_accounts_non_resident(BigDecimal r12_no_of_accounts_non_resident) {
		this.r12_no_of_accounts_non_resident = r12_no_of_accounts_non_resident;
	}
	public BigDecimal getR12_amount_non_resident() {
		return r12_amount_non_resident;
	}
	public void setR12_amount_non_resident(BigDecimal r12_amount_non_resident) {
		this.r12_amount_non_resident = r12_amount_non_resident;
	}
	public BigDecimal getR12_total_account() {
		return r12_total_account;
	}
	public void setR12_total_account(BigDecimal r12_total_account) {
		this.r12_total_account = r12_total_account;
	}
	public BigDecimal getR12_total_amount() {
		return r12_total_amount;
	}
	public void setR12_total_amount(BigDecimal r12_total_amount) {
		this.r12_total_amount = r12_total_amount;
	}
	public BigDecimal getR12_no_of_accounts_uae_abu() {
		return r12_no_of_accounts_uae_abu;
	}
	public void setR12_no_of_accounts_uae_abu(BigDecimal r12_no_of_accounts_uae_abu) {
		this.r12_no_of_accounts_uae_abu = r12_no_of_accounts_uae_abu;
	}
	public BigDecimal getR12_amount_uae_abu() {
		return r12_amount_uae_abu;
	}
	public void setR12_amount_uae_abu(BigDecimal r12_amount_uae_abu) {
		this.r12_amount_uae_abu = r12_amount_uae_abu;
	}
	public BigDecimal getR12_no_of_accounts_non_uae_abu() {
		return r12_no_of_accounts_non_uae_abu;
	}
	public void setR12_no_of_accounts_non_uae_abu(BigDecimal r12_no_of_accounts_non_uae_abu) {
		this.r12_no_of_accounts_non_uae_abu = r12_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR12_amount_non_uae_abu() {
		return r12_amount_non_uae_abu;
	}
	public void setR12_amount_non_uae_abu(BigDecimal r12_amount_non_uae_abu) {
		this.r12_amount_non_uae_abu = r12_amount_non_uae_abu;
	}
	public BigDecimal getR12_total_abu() {
		return r12_total_abu;
	}
	public void setR12_total_abu(BigDecimal r12_total_abu) {
		this.r12_total_abu = r12_total_abu;
	}
	public BigDecimal getR12_no_of_accounts_uae_dubai() {
		return r12_no_of_accounts_uae_dubai;
	}
	public void setR12_no_of_accounts_uae_dubai(BigDecimal r12_no_of_accounts_uae_dubai) {
		this.r12_no_of_accounts_uae_dubai = r12_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR12_amount_uae_dubai() {
		return r12_amount_uae_dubai;
	}
	public void setR12_amount_uae_dubai(BigDecimal r12_amount_uae_dubai) {
		this.r12_amount_uae_dubai = r12_amount_uae_dubai;
	}
	public BigDecimal getR12_no_of_accounts_non_uae_dubai() {
		return r12_no_of_accounts_non_uae_dubai;
	}
	public void setR12_no_of_accounts_non_uae_dubai(BigDecimal r12_no_of_accounts_non_uae_dubai) {
		this.r12_no_of_accounts_non_uae_dubai = r12_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR12_amount_non_uae_dubai() {
		return r12_amount_non_uae_dubai;
	}
	public void setR12_amount_non_uae_dubai(BigDecimal r12_amount_non_uae_dubai) {
		this.r12_amount_non_uae_dubai = r12_amount_non_uae_dubai;
	}
	public BigDecimal getR12_total_dubai() {
		return r12_total_dubai;
	}
	public void setR12_total_dubai(BigDecimal r12_total_dubai) {
		this.r12_total_dubai = r12_total_dubai;
	}
	public BigDecimal getR12_no_of_accounts_uae_sharjah() {
		return r12_no_of_accounts_uae_sharjah;
	}
	public void setR12_no_of_accounts_uae_sharjah(BigDecimal r12_no_of_accounts_uae_sharjah) {
		this.r12_no_of_accounts_uae_sharjah = r12_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR12_amount_uae_sharjah() {
		return r12_amount_uae_sharjah;
	}
	public void setR12_amount_uae_sharjah(BigDecimal r12_amount_uae_sharjah) {
		this.r12_amount_uae_sharjah = r12_amount_uae_sharjah;
	}
	public BigDecimal getR12_no_of_accounts_non_uae_sharjah() {
		return r12_no_of_accounts_non_uae_sharjah;
	}
	public void setR12_no_of_accounts_non_uae_sharjah(BigDecimal r12_no_of_accounts_non_uae_sharjah) {
		this.r12_no_of_accounts_non_uae_sharjah = r12_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR12_amount_non_uae_sharjah() {
		return r12_amount_non_uae_sharjah;
	}
	public void setR12_amount_non_uae_sharjah(BigDecimal r12_amount_non_uae_sharjah) {
		this.r12_amount_non_uae_sharjah = r12_amount_non_uae_sharjah;
	}
	public BigDecimal getR12_total_sharjah() {
		return r12_total_sharjah;
	}
	public void setR12_total_sharjah(BigDecimal r12_total_sharjah) {
		this.r12_total_sharjah = r12_total_sharjah;
	}
	public BigDecimal getR12_no_of_accounts_uae_ajman() {
		return r12_no_of_accounts_uae_ajman;
	}
	public void setR12_no_of_accounts_uae_ajman(BigDecimal r12_no_of_accounts_uae_ajman) {
		this.r12_no_of_accounts_uae_ajman = r12_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR12_amount_uae_ajman() {
		return r12_amount_uae_ajman;
	}
	public void setR12_amount_uae_ajman(BigDecimal r12_amount_uae_ajman) {
		this.r12_amount_uae_ajman = r12_amount_uae_ajman;
	}
	public BigDecimal getR12_no_of_accounts_non_uae_ajman() {
		return r12_no_of_accounts_non_uae_ajman;
	}
	public void setR12_no_of_accounts_non_uae_ajman(BigDecimal r12_no_of_accounts_non_uae_ajman) {
		this.r12_no_of_accounts_non_uae_ajman = r12_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR12_amount_non_uae_ajman() {
		return r12_amount_non_uae_ajman;
	}
	public void setR12_amount_non_uae_ajman(BigDecimal r12_amount_non_uae_ajman) {
		this.r12_amount_non_uae_ajman = r12_amount_non_uae_ajman;
	}
	public BigDecimal getR12_total_ajman() {
		return r12_total_ajman;
	}
	public void setR12_total_ajman(BigDecimal r12_total_ajman) {
		this.r12_total_ajman = r12_total_ajman;
	}
	public BigDecimal getR12_no_of_accounts_uae_ras() {
		return r12_no_of_accounts_uae_ras;
	}
	public void setR12_no_of_accounts_uae_ras(BigDecimal r12_no_of_accounts_uae_ras) {
		this.r12_no_of_accounts_uae_ras = r12_no_of_accounts_uae_ras;
	}
	public BigDecimal getR12_amount_uae_ras() {
		return r12_amount_uae_ras;
	}
	public void setR12_amount_uae_ras(BigDecimal r12_amount_uae_ras) {
		this.r12_amount_uae_ras = r12_amount_uae_ras;
	}
	public BigDecimal getR12_no_of_accounts_non_uae_ras() {
		return r12_no_of_accounts_non_uae_ras;
	}
	public void setR12_no_of_accounts_non_uae_ras(BigDecimal r12_no_of_accounts_non_uae_ras) {
		this.r12_no_of_accounts_non_uae_ras = r12_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR12_amount_non_uae_ras() {
		return r12_amount_non_uae_ras;
	}
	public void setR12_amount_non_uae_ras(BigDecimal r12_amount_non_uae_ras) {
		this.r12_amount_non_uae_ras = r12_amount_non_uae_ras;
	}
	public BigDecimal getR12_total_ras() {
		return r12_total_ras;
	}
	public void setR12_total_ras(BigDecimal r12_total_ras) {
		this.r12_total_ras = r12_total_ras;
	}
	public BigDecimal getR12_no_of_accounts_uae_umm() {
		return r12_no_of_accounts_uae_umm;
	}
	public void setR12_no_of_accounts_uae_umm(BigDecimal r12_no_of_accounts_uae_umm) {
		this.r12_no_of_accounts_uae_umm = r12_no_of_accounts_uae_umm;
	}
	public BigDecimal getR12_amount_uae_umm() {
		return r12_amount_uae_umm;
	}
	public void setR12_amount_uae_umm(BigDecimal r12_amount_uae_umm) {
		this.r12_amount_uae_umm = r12_amount_uae_umm;
	}
	public BigDecimal getR12_no_of_accounts_non_uae_umm() {
		return r12_no_of_accounts_non_uae_umm;
	}
	public void setR12_no_of_accounts_non_uae_umm(BigDecimal r12_no_of_accounts_non_uae_umm) {
		this.r12_no_of_accounts_non_uae_umm = r12_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR12_amount_non_uae_umm() {
		return r12_amount_non_uae_umm;
	}
	public void setR12_amount_non_uae_umm(BigDecimal r12_amount_non_uae_umm) {
		this.r12_amount_non_uae_umm = r12_amount_non_uae_umm;
	}
	public BigDecimal getR12_total_umm() {
		return r12_total_umm;
	}
	public void setR12_total_umm(BigDecimal r12_total_umm) {
		this.r12_total_umm = r12_total_umm;
	}
	public BigDecimal getR12_no_of_accounts_uae_fujairah() {
		return r12_no_of_accounts_uae_fujairah;
	}
	public void setR12_no_of_accounts_uae_fujairah(BigDecimal r12_no_of_accounts_uae_fujairah) {
		this.r12_no_of_accounts_uae_fujairah = r12_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR12_amount_uae_fujairah() {
		return r12_amount_uae_fujairah;
	}
	public void setR12_amount_uae_fujairah(BigDecimal r12_amount_uae_fujairah) {
		this.r12_amount_uae_fujairah = r12_amount_uae_fujairah;
	}
	public BigDecimal getR12_no_of_accounts_non_uae_fujairah() {
		return r12_no_of_accounts_non_uae_fujairah;
	}
	public void setR12_no_of_accounts_non_uae_fujairah(BigDecimal r12_no_of_accounts_non_uae_fujairah) {
		this.r12_no_of_accounts_non_uae_fujairah = r12_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR12_amount_non_uae_fujairah() {
		return r12_amount_non_uae_fujairah;
	}
	public void setR12_amount_non_uae_fujairah(BigDecimal r12_amount_non_uae_fujairah) {
		this.r12_amount_non_uae_fujairah = r12_amount_non_uae_fujairah;
	}
	public BigDecimal getR12_total_fujairah() {
		return r12_total_fujairah;
	}
	public void setR12_total_fujairah(BigDecimal r12_total_fujairah) {
		this.r12_total_fujairah = r12_total_fujairah;
	}
	public String getR13_product() {
		return r13_product;
	}
	public void setR13_product(String r13_product) {
		this.r13_product = r13_product;
	}
	public BigDecimal getR13_no_of_accounts_uae() {
		return r13_no_of_accounts_uae;
	}
	public void setR13_no_of_accounts_uae(BigDecimal r13_no_of_accounts_uae) {
		this.r13_no_of_accounts_uae = r13_no_of_accounts_uae;
	}
	public BigDecimal getR13_amount_uae() {
		return r13_amount_uae;
	}
	public void setR13_amount_uae(BigDecimal r13_amount_uae) {
		this.r13_amount_uae = r13_amount_uae;
	}
	public BigDecimal getR13_no_of_accounts_resident() {
		return r13_no_of_accounts_resident;
	}
	public void setR13_no_of_accounts_resident(BigDecimal r13_no_of_accounts_resident) {
		this.r13_no_of_accounts_resident = r13_no_of_accounts_resident;
	}
	public BigDecimal getR13_amount_resident() {
		return r13_amount_resident;
	}
	public void setR13_amount_resident(BigDecimal r13_amount_resident) {
		this.r13_amount_resident = r13_amount_resident;
	}
	public BigDecimal getR13_no_of_accounts_non_resident() {
		return r13_no_of_accounts_non_resident;
	}
	public void setR13_no_of_accounts_non_resident(BigDecimal r13_no_of_accounts_non_resident) {
		this.r13_no_of_accounts_non_resident = r13_no_of_accounts_non_resident;
	}
	public BigDecimal getR13_amount_non_resident() {
		return r13_amount_non_resident;
	}
	public void setR13_amount_non_resident(BigDecimal r13_amount_non_resident) {
		this.r13_amount_non_resident = r13_amount_non_resident;
	}
	public BigDecimal getR13_total_account() {
		return r13_total_account;
	}
	public void setR13_total_account(BigDecimal r13_total_account) {
		this.r13_total_account = r13_total_account;
	}
	public BigDecimal getR13_total_amount() {
		return r13_total_amount;
	}
	public void setR13_total_amount(BigDecimal r13_total_amount) {
		this.r13_total_amount = r13_total_amount;
	}
	public BigDecimal getR13_no_of_accounts_uae_abu() {
		return r13_no_of_accounts_uae_abu;
	}
	public void setR13_no_of_accounts_uae_abu(BigDecimal r13_no_of_accounts_uae_abu) {
		this.r13_no_of_accounts_uae_abu = r13_no_of_accounts_uae_abu;
	}
	public BigDecimal getR13_amount_uae_abu() {
		return r13_amount_uae_abu;
	}
	public void setR13_amount_uae_abu(BigDecimal r13_amount_uae_abu) {
		this.r13_amount_uae_abu = r13_amount_uae_abu;
	}
	public BigDecimal getR13_no_of_accounts_non_uae_abu() {
		return r13_no_of_accounts_non_uae_abu;
	}
	public void setR13_no_of_accounts_non_uae_abu(BigDecimal r13_no_of_accounts_non_uae_abu) {
		this.r13_no_of_accounts_non_uae_abu = r13_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR13_amount_non_uae_abu() {
		return r13_amount_non_uae_abu;
	}
	public void setR13_amount_non_uae_abu(BigDecimal r13_amount_non_uae_abu) {
		this.r13_amount_non_uae_abu = r13_amount_non_uae_abu;
	}
	public BigDecimal getR13_total_abu() {
		return r13_total_abu;
	}
	public void setR13_total_abu(BigDecimal r13_total_abu) {
		this.r13_total_abu = r13_total_abu;
	}
	public BigDecimal getR13_no_of_accounts_uae_dubai() {
		return r13_no_of_accounts_uae_dubai;
	}
	public void setR13_no_of_accounts_uae_dubai(BigDecimal r13_no_of_accounts_uae_dubai) {
		this.r13_no_of_accounts_uae_dubai = r13_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR13_amount_uae_dubai() {
		return r13_amount_uae_dubai;
	}
	public void setR13_amount_uae_dubai(BigDecimal r13_amount_uae_dubai) {
		this.r13_amount_uae_dubai = r13_amount_uae_dubai;
	}
	public BigDecimal getR13_no_of_accounts_non_uae_dubai() {
		return r13_no_of_accounts_non_uae_dubai;
	}
	public void setR13_no_of_accounts_non_uae_dubai(BigDecimal r13_no_of_accounts_non_uae_dubai) {
		this.r13_no_of_accounts_non_uae_dubai = r13_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR13_amount_non_uae_dubai() {
		return r13_amount_non_uae_dubai;
	}
	public void setR13_amount_non_uae_dubai(BigDecimal r13_amount_non_uae_dubai) {
		this.r13_amount_non_uae_dubai = r13_amount_non_uae_dubai;
	}
	public BigDecimal getR13_total_dubai() {
		return r13_total_dubai;
	}
	public void setR13_total_dubai(BigDecimal r13_total_dubai) {
		this.r13_total_dubai = r13_total_dubai;
	}
	public BigDecimal getR13_no_of_accounts_uae_sharjah() {
		return r13_no_of_accounts_uae_sharjah;
	}
	public void setR13_no_of_accounts_uae_sharjah(BigDecimal r13_no_of_accounts_uae_sharjah) {
		this.r13_no_of_accounts_uae_sharjah = r13_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR13_amount_uae_sharjah() {
		return r13_amount_uae_sharjah;
	}
	public void setR13_amount_uae_sharjah(BigDecimal r13_amount_uae_sharjah) {
		this.r13_amount_uae_sharjah = r13_amount_uae_sharjah;
	}
	public BigDecimal getR13_no_of_accounts_non_uae_sharjah() {
		return r13_no_of_accounts_non_uae_sharjah;
	}
	public void setR13_no_of_accounts_non_uae_sharjah(BigDecimal r13_no_of_accounts_non_uae_sharjah) {
		this.r13_no_of_accounts_non_uae_sharjah = r13_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR13_amount_non_uae_sharjah() {
		return r13_amount_non_uae_sharjah;
	}
	public void setR13_amount_non_uae_sharjah(BigDecimal r13_amount_non_uae_sharjah) {
		this.r13_amount_non_uae_sharjah = r13_amount_non_uae_sharjah;
	}
	public BigDecimal getR13_total_sharjah() {
		return r13_total_sharjah;
	}
	public void setR13_total_sharjah(BigDecimal r13_total_sharjah) {
		this.r13_total_sharjah = r13_total_sharjah;
	}
	public BigDecimal getR13_no_of_accounts_uae_ajman() {
		return r13_no_of_accounts_uae_ajman;
	}
	public void setR13_no_of_accounts_uae_ajman(BigDecimal r13_no_of_accounts_uae_ajman) {
		this.r13_no_of_accounts_uae_ajman = r13_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR13_amount_uae_ajman() {
		return r13_amount_uae_ajman;
	}
	public void setR13_amount_uae_ajman(BigDecimal r13_amount_uae_ajman) {
		this.r13_amount_uae_ajman = r13_amount_uae_ajman;
	}
	public BigDecimal getR13_no_of_accounts_non_uae_ajman() {
		return r13_no_of_accounts_non_uae_ajman;
	}
	public void setR13_no_of_accounts_non_uae_ajman(BigDecimal r13_no_of_accounts_non_uae_ajman) {
		this.r13_no_of_accounts_non_uae_ajman = r13_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR13_amount_non_uae_ajman() {
		return r13_amount_non_uae_ajman;
	}
	public void setR13_amount_non_uae_ajman(BigDecimal r13_amount_non_uae_ajman) {
		this.r13_amount_non_uae_ajman = r13_amount_non_uae_ajman;
	}
	public BigDecimal getR13_total_ajman() {
		return r13_total_ajman;
	}
	public void setR13_total_ajman(BigDecimal r13_total_ajman) {
		this.r13_total_ajman = r13_total_ajman;
	}
	public BigDecimal getR13_no_of_accounts_uae_ras() {
		return r13_no_of_accounts_uae_ras;
	}
	public void setR13_no_of_accounts_uae_ras(BigDecimal r13_no_of_accounts_uae_ras) {
		this.r13_no_of_accounts_uae_ras = r13_no_of_accounts_uae_ras;
	}
	public BigDecimal getR13_amount_uae_ras() {
		return r13_amount_uae_ras;
	}
	public void setR13_amount_uae_ras(BigDecimal r13_amount_uae_ras) {
		this.r13_amount_uae_ras = r13_amount_uae_ras;
	}
	public BigDecimal getR13_no_of_accounts_non_uae_ras() {
		return r13_no_of_accounts_non_uae_ras;
	}
	public void setR13_no_of_accounts_non_uae_ras(BigDecimal r13_no_of_accounts_non_uae_ras) {
		this.r13_no_of_accounts_non_uae_ras = r13_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR13_amount_non_uae_ras() {
		return r13_amount_non_uae_ras;
	}
	public void setR13_amount_non_uae_ras(BigDecimal r13_amount_non_uae_ras) {
		this.r13_amount_non_uae_ras = r13_amount_non_uae_ras;
	}
	public BigDecimal getR13_total_ras() {
		return r13_total_ras;
	}
	public void setR13_total_ras(BigDecimal r13_total_ras) {
		this.r13_total_ras = r13_total_ras;
	}
	public BigDecimal getR13_no_of_accounts_uae_umm() {
		return r13_no_of_accounts_uae_umm;
	}
	public void setR13_no_of_accounts_uae_umm(BigDecimal r13_no_of_accounts_uae_umm) {
		this.r13_no_of_accounts_uae_umm = r13_no_of_accounts_uae_umm;
	}
	public BigDecimal getR13_amount_uae_umm() {
		return r13_amount_uae_umm;
	}
	public void setR13_amount_uae_umm(BigDecimal r13_amount_uae_umm) {
		this.r13_amount_uae_umm = r13_amount_uae_umm;
	}
	public BigDecimal getR13_no_of_accounts_non_uae_umm() {
		return r13_no_of_accounts_non_uae_umm;
	}
	public void setR13_no_of_accounts_non_uae_umm(BigDecimal r13_no_of_accounts_non_uae_umm) {
		this.r13_no_of_accounts_non_uae_umm = r13_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR13_amount_non_uae_umm() {
		return r13_amount_non_uae_umm;
	}
	public void setR13_amount_non_uae_umm(BigDecimal r13_amount_non_uae_umm) {
		this.r13_amount_non_uae_umm = r13_amount_non_uae_umm;
	}
	public BigDecimal getR13_total_umm() {
		return r13_total_umm;
	}
	public void setR13_total_umm(BigDecimal r13_total_umm) {
		this.r13_total_umm = r13_total_umm;
	}
	public BigDecimal getR13_no_of_accounts_uae_fujairah() {
		return r13_no_of_accounts_uae_fujairah;
	}
	public void setR13_no_of_accounts_uae_fujairah(BigDecimal r13_no_of_accounts_uae_fujairah) {
		this.r13_no_of_accounts_uae_fujairah = r13_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR13_amount_uae_fujairah() {
		return r13_amount_uae_fujairah;
	}
	public void setR13_amount_uae_fujairah(BigDecimal r13_amount_uae_fujairah) {
		this.r13_amount_uae_fujairah = r13_amount_uae_fujairah;
	}
	public BigDecimal getR13_no_of_accounts_non_uae_fujairah() {
		return r13_no_of_accounts_non_uae_fujairah;
	}
	public void setR13_no_of_accounts_non_uae_fujairah(BigDecimal r13_no_of_accounts_non_uae_fujairah) {
		this.r13_no_of_accounts_non_uae_fujairah = r13_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR13_amount_non_uae_fujairah() {
		return r13_amount_non_uae_fujairah;
	}
	public void setR13_amount_non_uae_fujairah(BigDecimal r13_amount_non_uae_fujairah) {
		this.r13_amount_non_uae_fujairah = r13_amount_non_uae_fujairah;
	}
	public BigDecimal getR13_total_fujairah() {
		return r13_total_fujairah;
	}
	public void setR13_total_fujairah(BigDecimal r13_total_fujairah) {
		this.r13_total_fujairah = r13_total_fujairah;
	}
	public String getR14_product() {
		return r14_product;
	}
	public void setR14_product(String r14_product) {
		this.r14_product = r14_product;
	}
	public BigDecimal getR14_no_of_accounts_uae() {
		return r14_no_of_accounts_uae;
	}
	public void setR14_no_of_accounts_uae(BigDecimal r14_no_of_accounts_uae) {
		this.r14_no_of_accounts_uae = r14_no_of_accounts_uae;
	}
	public BigDecimal getR14_amount_uae() {
		return r14_amount_uae;
	}
	public void setR14_amount_uae(BigDecimal r14_amount_uae) {
		this.r14_amount_uae = r14_amount_uae;
	}
	public BigDecimal getR14_no_of_accounts_resident() {
		return r14_no_of_accounts_resident;
	}
	public void setR14_no_of_accounts_resident(BigDecimal r14_no_of_accounts_resident) {
		this.r14_no_of_accounts_resident = r14_no_of_accounts_resident;
	}
	public BigDecimal getR14_amount_resident() {
		return r14_amount_resident;
	}
	public void setR14_amount_resident(BigDecimal r14_amount_resident) {
		this.r14_amount_resident = r14_amount_resident;
	}
	public BigDecimal getR14_no_of_accounts_non_resident() {
		return r14_no_of_accounts_non_resident;
	}
	public void setR14_no_of_accounts_non_resident(BigDecimal r14_no_of_accounts_non_resident) {
		this.r14_no_of_accounts_non_resident = r14_no_of_accounts_non_resident;
	}
	public BigDecimal getR14_amount_non_resident() {
		return r14_amount_non_resident;
	}
	public void setR14_amount_non_resident(BigDecimal r14_amount_non_resident) {
		this.r14_amount_non_resident = r14_amount_non_resident;
	}
	public BigDecimal getR14_total_account() {
		return r14_total_account;
	}
	public void setR14_total_account(BigDecimal r14_total_account) {
		this.r14_total_account = r14_total_account;
	}
	public BigDecimal getR14_total_amount() {
		return r14_total_amount;
	}
	public void setR14_total_amount(BigDecimal r14_total_amount) {
		this.r14_total_amount = r14_total_amount;
	}
	public BigDecimal getR14_no_of_accounts_uae_abu() {
		return r14_no_of_accounts_uae_abu;
	}
	public void setR14_no_of_accounts_uae_abu(BigDecimal r14_no_of_accounts_uae_abu) {
		this.r14_no_of_accounts_uae_abu = r14_no_of_accounts_uae_abu;
	}
	public BigDecimal getR14_amount_uae_abu() {
		return r14_amount_uae_abu;
	}
	public void setR14_amount_uae_abu(BigDecimal r14_amount_uae_abu) {
		this.r14_amount_uae_abu = r14_amount_uae_abu;
	}
	public BigDecimal getR14_no_of_accounts_non_uae_abu() {
		return r14_no_of_accounts_non_uae_abu;
	}
	public void setR14_no_of_accounts_non_uae_abu(BigDecimal r14_no_of_accounts_non_uae_abu) {
		this.r14_no_of_accounts_non_uae_abu = r14_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR14_amount_non_uae_abu() {
		return r14_amount_non_uae_abu;
	}
	public void setR14_amount_non_uae_abu(BigDecimal r14_amount_non_uae_abu) {
		this.r14_amount_non_uae_abu = r14_amount_non_uae_abu;
	}
	public BigDecimal getR14_total_abu() {
		return r14_total_abu;
	}
	public void setR14_total_abu(BigDecimal r14_total_abu) {
		this.r14_total_abu = r14_total_abu;
	}
	public BigDecimal getR14_no_of_accounts_uae_dubai() {
		return r14_no_of_accounts_uae_dubai;
	}
	public void setR14_no_of_accounts_uae_dubai(BigDecimal r14_no_of_accounts_uae_dubai) {
		this.r14_no_of_accounts_uae_dubai = r14_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR14_amount_uae_dubai() {
		return r14_amount_uae_dubai;
	}
	public void setR14_amount_uae_dubai(BigDecimal r14_amount_uae_dubai) {
		this.r14_amount_uae_dubai = r14_amount_uae_dubai;
	}
	public BigDecimal getR14_no_of_accounts_non_uae_dubai() {
		return r14_no_of_accounts_non_uae_dubai;
	}
	public void setR14_no_of_accounts_non_uae_dubai(BigDecimal r14_no_of_accounts_non_uae_dubai) {
		this.r14_no_of_accounts_non_uae_dubai = r14_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR14_amount_non_uae_dubai() {
		return r14_amount_non_uae_dubai;
	}
	public void setR14_amount_non_uae_dubai(BigDecimal r14_amount_non_uae_dubai) {
		this.r14_amount_non_uae_dubai = r14_amount_non_uae_dubai;
	}
	public BigDecimal getR14_total_dubai() {
		return r14_total_dubai;
	}
	public void setR14_total_dubai(BigDecimal r14_total_dubai) {
		this.r14_total_dubai = r14_total_dubai;
	}
	public BigDecimal getR14_no_of_accounts_uae_sharjah() {
		return r14_no_of_accounts_uae_sharjah;
	}
	public void setR14_no_of_accounts_uae_sharjah(BigDecimal r14_no_of_accounts_uae_sharjah) {
		this.r14_no_of_accounts_uae_sharjah = r14_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR14_amount_uae_sharjah() {
		return r14_amount_uae_sharjah;
	}
	public void setR14_amount_uae_sharjah(BigDecimal r14_amount_uae_sharjah) {
		this.r14_amount_uae_sharjah = r14_amount_uae_sharjah;
	}
	public BigDecimal getR14_no_of_accounts_non_uae_sharjah() {
		return r14_no_of_accounts_non_uae_sharjah;
	}
	public void setR14_no_of_accounts_non_uae_sharjah(BigDecimal r14_no_of_accounts_non_uae_sharjah) {
		this.r14_no_of_accounts_non_uae_sharjah = r14_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR14_amount_non_uae_sharjah() {
		return r14_amount_non_uae_sharjah;
	}
	public void setR14_amount_non_uae_sharjah(BigDecimal r14_amount_non_uae_sharjah) {
		this.r14_amount_non_uae_sharjah = r14_amount_non_uae_sharjah;
	}
	public BigDecimal getR14_total_sharjah() {
		return r14_total_sharjah;
	}
	public void setR14_total_sharjah(BigDecimal r14_total_sharjah) {
		this.r14_total_sharjah = r14_total_sharjah;
	}
	public BigDecimal getR14_no_of_accounts_uae_ajman() {
		return r14_no_of_accounts_uae_ajman;
	}
	public void setR14_no_of_accounts_uae_ajman(BigDecimal r14_no_of_accounts_uae_ajman) {
		this.r14_no_of_accounts_uae_ajman = r14_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR14_amount_uae_ajman() {
		return r14_amount_uae_ajman;
	}
	public void setR14_amount_uae_ajman(BigDecimal r14_amount_uae_ajman) {
		this.r14_amount_uae_ajman = r14_amount_uae_ajman;
	}
	public BigDecimal getR14_no_of_accounts_non_uae_ajman() {
		return r14_no_of_accounts_non_uae_ajman;
	}
	public void setR14_no_of_accounts_non_uae_ajman(BigDecimal r14_no_of_accounts_non_uae_ajman) {
		this.r14_no_of_accounts_non_uae_ajman = r14_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR14_amount_non_uae_ajman() {
		return r14_amount_non_uae_ajman;
	}
	public void setR14_amount_non_uae_ajman(BigDecimal r14_amount_non_uae_ajman) {
		this.r14_amount_non_uae_ajman = r14_amount_non_uae_ajman;
	}
	public BigDecimal getR14_total_ajman() {
		return r14_total_ajman;
	}
	public void setR14_total_ajman(BigDecimal r14_total_ajman) {
		this.r14_total_ajman = r14_total_ajman;
	}
	public BigDecimal getR14_no_of_accounts_uae_ras() {
		return r14_no_of_accounts_uae_ras;
	}
	public void setR14_no_of_accounts_uae_ras(BigDecimal r14_no_of_accounts_uae_ras) {
		this.r14_no_of_accounts_uae_ras = r14_no_of_accounts_uae_ras;
	}
	public BigDecimal getR14_amount_uae_ras() {
		return r14_amount_uae_ras;
	}
	public void setR14_amount_uae_ras(BigDecimal r14_amount_uae_ras) {
		this.r14_amount_uae_ras = r14_amount_uae_ras;
	}
	public BigDecimal getR14_no_of_accounts_non_uae_ras() {
		return r14_no_of_accounts_non_uae_ras;
	}
	public void setR14_no_of_accounts_non_uae_ras(BigDecimal r14_no_of_accounts_non_uae_ras) {
		this.r14_no_of_accounts_non_uae_ras = r14_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR14_amount_non_uae_ras() {
		return r14_amount_non_uae_ras;
	}
	public void setR14_amount_non_uae_ras(BigDecimal r14_amount_non_uae_ras) {
		this.r14_amount_non_uae_ras = r14_amount_non_uae_ras;
	}
	public BigDecimal getR14_total_ras() {
		return r14_total_ras;
	}
	public void setR14_total_ras(BigDecimal r14_total_ras) {
		this.r14_total_ras = r14_total_ras;
	}
	public BigDecimal getR14_no_of_accounts_uae_umm() {
		return r14_no_of_accounts_uae_umm;
	}
	public void setR14_no_of_accounts_uae_umm(BigDecimal r14_no_of_accounts_uae_umm) {
		this.r14_no_of_accounts_uae_umm = r14_no_of_accounts_uae_umm;
	}
	public BigDecimal getR14_amount_uae_umm() {
		return r14_amount_uae_umm;
	}
	public void setR14_amount_uae_umm(BigDecimal r14_amount_uae_umm) {
		this.r14_amount_uae_umm = r14_amount_uae_umm;
	}
	public BigDecimal getR14_no_of_accounts_non_uae_umm() {
		return r14_no_of_accounts_non_uae_umm;
	}
	public void setR14_no_of_accounts_non_uae_umm(BigDecimal r14_no_of_accounts_non_uae_umm) {
		this.r14_no_of_accounts_non_uae_umm = r14_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR14_amount_non_uae_umm() {
		return r14_amount_non_uae_umm;
	}
	public void setR14_amount_non_uae_umm(BigDecimal r14_amount_non_uae_umm) {
		this.r14_amount_non_uae_umm = r14_amount_non_uae_umm;
	}
	public BigDecimal getR14_total_umm() {
		return r14_total_umm;
	}
	public void setR14_total_umm(BigDecimal r14_total_umm) {
		this.r14_total_umm = r14_total_umm;
	}
	public BigDecimal getR14_no_of_accounts_uae_fujairah() {
		return r14_no_of_accounts_uae_fujairah;
	}
	public void setR14_no_of_accounts_uae_fujairah(BigDecimal r14_no_of_accounts_uae_fujairah) {
		this.r14_no_of_accounts_uae_fujairah = r14_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR14_amount_uae_fujairah() {
		return r14_amount_uae_fujairah;
	}
	public void setR14_amount_uae_fujairah(BigDecimal r14_amount_uae_fujairah) {
		this.r14_amount_uae_fujairah = r14_amount_uae_fujairah;
	}
	public BigDecimal getR14_no_of_accounts_non_uae_fujairah() {
		return r14_no_of_accounts_non_uae_fujairah;
	}
	public void setR14_no_of_accounts_non_uae_fujairah(BigDecimal r14_no_of_accounts_non_uae_fujairah) {
		this.r14_no_of_accounts_non_uae_fujairah = r14_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR14_amount_non_uae_fujairah() {
		return r14_amount_non_uae_fujairah;
	}
	public void setR14_amount_non_uae_fujairah(BigDecimal r14_amount_non_uae_fujairah) {
		this.r14_amount_non_uae_fujairah = r14_amount_non_uae_fujairah;
	}
	public BigDecimal getR14_total_fujairah() {
		return r14_total_fujairah;
	}
	public void setR14_total_fujairah(BigDecimal r14_total_fujairah) {
		this.r14_total_fujairah = r14_total_fujairah;
	}
	public String getR15_product() {
		return r15_product;
	}
	public void setR15_product(String r15_product) {
		this.r15_product = r15_product;
	}
	public BigDecimal getR15_no_of_accounts_uae() {
		return r15_no_of_accounts_uae;
	}
	public void setR15_no_of_accounts_uae(BigDecimal r15_no_of_accounts_uae) {
		this.r15_no_of_accounts_uae = r15_no_of_accounts_uae;
	}
	public BigDecimal getR15_amount_uae() {
		return r15_amount_uae;
	}
	public void setR15_amount_uae(BigDecimal r15_amount_uae) {
		this.r15_amount_uae = r15_amount_uae;
	}
	public BigDecimal getR15_no_of_accounts_resident() {
		return r15_no_of_accounts_resident;
	}
	public void setR15_no_of_accounts_resident(BigDecimal r15_no_of_accounts_resident) {
		this.r15_no_of_accounts_resident = r15_no_of_accounts_resident;
	}
	public BigDecimal getR15_amount_resident() {
		return r15_amount_resident;
	}
	public void setR15_amount_resident(BigDecimal r15_amount_resident) {
		this.r15_amount_resident = r15_amount_resident;
	}
	public BigDecimal getR15_no_of_accounts_non_resident() {
		return r15_no_of_accounts_non_resident;
	}
	public void setR15_no_of_accounts_non_resident(BigDecimal r15_no_of_accounts_non_resident) {
		this.r15_no_of_accounts_non_resident = r15_no_of_accounts_non_resident;
	}
	public BigDecimal getR15_amount_non_resident() {
		return r15_amount_non_resident;
	}
	public void setR15_amount_non_resident(BigDecimal r15_amount_non_resident) {
		this.r15_amount_non_resident = r15_amount_non_resident;
	}
	public BigDecimal getR15_total_account() {
		return r15_total_account;
	}
	public void setR15_total_account(BigDecimal r15_total_account) {
		this.r15_total_account = r15_total_account;
	}
	public BigDecimal getR15_total_amount() {
		return r15_total_amount;
	}
	public void setR15_total_amount(BigDecimal r15_total_amount) {
		this.r15_total_amount = r15_total_amount;
	}
	public BigDecimal getR15_no_of_accounts_uae_abu() {
		return r15_no_of_accounts_uae_abu;
	}
	public void setR15_no_of_accounts_uae_abu(BigDecimal r15_no_of_accounts_uae_abu) {
		this.r15_no_of_accounts_uae_abu = r15_no_of_accounts_uae_abu;
	}
	public BigDecimal getR15_amount_uae_abu() {
		return r15_amount_uae_abu;
	}
	public void setR15_amount_uae_abu(BigDecimal r15_amount_uae_abu) {
		this.r15_amount_uae_abu = r15_amount_uae_abu;
	}
	public BigDecimal getR15_no_of_accounts_non_uae_abu() {
		return r15_no_of_accounts_non_uae_abu;
	}
	public void setR15_no_of_accounts_non_uae_abu(BigDecimal r15_no_of_accounts_non_uae_abu) {
		this.r15_no_of_accounts_non_uae_abu = r15_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR15_amount_non_uae_abu() {
		return r15_amount_non_uae_abu;
	}
	public void setR15_amount_non_uae_abu(BigDecimal r15_amount_non_uae_abu) {
		this.r15_amount_non_uae_abu = r15_amount_non_uae_abu;
	}
	public BigDecimal getR15_total_abu() {
		return r15_total_abu;
	}
	public void setR15_total_abu(BigDecimal r15_total_abu) {
		this.r15_total_abu = r15_total_abu;
	}
	public BigDecimal getR15_no_of_accounts_uae_dubai() {
		return r15_no_of_accounts_uae_dubai;
	}
	public void setR15_no_of_accounts_uae_dubai(BigDecimal r15_no_of_accounts_uae_dubai) {
		this.r15_no_of_accounts_uae_dubai = r15_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR15_amount_uae_dubai() {
		return r15_amount_uae_dubai;
	}
	public void setR15_amount_uae_dubai(BigDecimal r15_amount_uae_dubai) {
		this.r15_amount_uae_dubai = r15_amount_uae_dubai;
	}
	public BigDecimal getR15_no_of_accounts_non_uae_dubai() {
		return r15_no_of_accounts_non_uae_dubai;
	}
	public void setR15_no_of_accounts_non_uae_dubai(BigDecimal r15_no_of_accounts_non_uae_dubai) {
		this.r15_no_of_accounts_non_uae_dubai = r15_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR15_amount_non_uae_dubai() {
		return r15_amount_non_uae_dubai;
	}
	public void setR15_amount_non_uae_dubai(BigDecimal r15_amount_non_uae_dubai) {
		this.r15_amount_non_uae_dubai = r15_amount_non_uae_dubai;
	}
	public BigDecimal getR15_total_dubai() {
		return r15_total_dubai;
	}
	public void setR15_total_dubai(BigDecimal r15_total_dubai) {
		this.r15_total_dubai = r15_total_dubai;
	}
	public BigDecimal getR15_no_of_accounts_uae_sharjah() {
		return r15_no_of_accounts_uae_sharjah;
	}
	public void setR15_no_of_accounts_uae_sharjah(BigDecimal r15_no_of_accounts_uae_sharjah) {
		this.r15_no_of_accounts_uae_sharjah = r15_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR15_amount_uae_sharjah() {
		return r15_amount_uae_sharjah;
	}
	public void setR15_amount_uae_sharjah(BigDecimal r15_amount_uae_sharjah) {
		this.r15_amount_uae_sharjah = r15_amount_uae_sharjah;
	}
	public BigDecimal getR15_no_of_accounts_non_uae_sharjah() {
		return r15_no_of_accounts_non_uae_sharjah;
	}
	public void setR15_no_of_accounts_non_uae_sharjah(BigDecimal r15_no_of_accounts_non_uae_sharjah) {
		this.r15_no_of_accounts_non_uae_sharjah = r15_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR15_amount_non_uae_sharjah() {
		return r15_amount_non_uae_sharjah;
	}
	public void setR15_amount_non_uae_sharjah(BigDecimal r15_amount_non_uae_sharjah) {
		this.r15_amount_non_uae_sharjah = r15_amount_non_uae_sharjah;
	}
	public BigDecimal getR15_total_sharjah() {
		return r15_total_sharjah;
	}
	public void setR15_total_sharjah(BigDecimal r15_total_sharjah) {
		this.r15_total_sharjah = r15_total_sharjah;
	}
	public BigDecimal getR15_no_of_accounts_uae_ajman() {
		return r15_no_of_accounts_uae_ajman;
	}
	public void setR15_no_of_accounts_uae_ajman(BigDecimal r15_no_of_accounts_uae_ajman) {
		this.r15_no_of_accounts_uae_ajman = r15_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR15_amount_uae_ajman() {
		return r15_amount_uae_ajman;
	}
	public void setR15_amount_uae_ajman(BigDecimal r15_amount_uae_ajman) {
		this.r15_amount_uae_ajman = r15_amount_uae_ajman;
	}
	public BigDecimal getR15_no_of_accounts_non_uae_ajman() {
		return r15_no_of_accounts_non_uae_ajman;
	}
	public void setR15_no_of_accounts_non_uae_ajman(BigDecimal r15_no_of_accounts_non_uae_ajman) {
		this.r15_no_of_accounts_non_uae_ajman = r15_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR15_amount_non_uae_ajman() {
		return r15_amount_non_uae_ajman;
	}
	public void setR15_amount_non_uae_ajman(BigDecimal r15_amount_non_uae_ajman) {
		this.r15_amount_non_uae_ajman = r15_amount_non_uae_ajman;
	}
	public BigDecimal getR15_total_ajman() {
		return r15_total_ajman;
	}
	public void setR15_total_ajman(BigDecimal r15_total_ajman) {
		this.r15_total_ajman = r15_total_ajman;
	}
	public BigDecimal getR15_no_of_accounts_uae_ras() {
		return r15_no_of_accounts_uae_ras;
	}
	public void setR15_no_of_accounts_uae_ras(BigDecimal r15_no_of_accounts_uae_ras) {
		this.r15_no_of_accounts_uae_ras = r15_no_of_accounts_uae_ras;
	}
	public BigDecimal getR15_amount_uae_ras() {
		return r15_amount_uae_ras;
	}
	public void setR15_amount_uae_ras(BigDecimal r15_amount_uae_ras) {
		this.r15_amount_uae_ras = r15_amount_uae_ras;
	}
	public BigDecimal getR15_no_of_accounts_non_uae_ras() {
		return r15_no_of_accounts_non_uae_ras;
	}
	public void setR15_no_of_accounts_non_uae_ras(BigDecimal r15_no_of_accounts_non_uae_ras) {
		this.r15_no_of_accounts_non_uae_ras = r15_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR15_amount_non_uae_ras() {
		return r15_amount_non_uae_ras;
	}
	public void setR15_amount_non_uae_ras(BigDecimal r15_amount_non_uae_ras) {
		this.r15_amount_non_uae_ras = r15_amount_non_uae_ras;
	}
	public BigDecimal getR15_total_ras() {
		return r15_total_ras;
	}
	public void setR15_total_ras(BigDecimal r15_total_ras) {
		this.r15_total_ras = r15_total_ras;
	}
	public BigDecimal getR15_no_of_accounts_uae_umm() {
		return r15_no_of_accounts_uae_umm;
	}
	public void setR15_no_of_accounts_uae_umm(BigDecimal r15_no_of_accounts_uae_umm) {
		this.r15_no_of_accounts_uae_umm = r15_no_of_accounts_uae_umm;
	}
	public BigDecimal getR15_amount_uae_umm() {
		return r15_amount_uae_umm;
	}
	public void setR15_amount_uae_umm(BigDecimal r15_amount_uae_umm) {
		this.r15_amount_uae_umm = r15_amount_uae_umm;
	}
	public BigDecimal getR15_no_of_accounts_non_uae_umm() {
		return r15_no_of_accounts_non_uae_umm;
	}
	public void setR15_no_of_accounts_non_uae_umm(BigDecimal r15_no_of_accounts_non_uae_umm) {
		this.r15_no_of_accounts_non_uae_umm = r15_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR15_amount_non_uae_umm() {
		return r15_amount_non_uae_umm;
	}
	public void setR15_amount_non_uae_umm(BigDecimal r15_amount_non_uae_umm) {
		this.r15_amount_non_uae_umm = r15_amount_non_uae_umm;
	}
	public BigDecimal getR15_total_umm() {
		return r15_total_umm;
	}
	public void setR15_total_umm(BigDecimal r15_total_umm) {
		this.r15_total_umm = r15_total_umm;
	}
	public BigDecimal getR15_no_of_accounts_uae_fujairah() {
		return r15_no_of_accounts_uae_fujairah;
	}
	public void setR15_no_of_accounts_uae_fujairah(BigDecimal r15_no_of_accounts_uae_fujairah) {
		this.r15_no_of_accounts_uae_fujairah = r15_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR15_amount_uae_fujairah() {
		return r15_amount_uae_fujairah;
	}
	public void setR15_amount_uae_fujairah(BigDecimal r15_amount_uae_fujairah) {
		this.r15_amount_uae_fujairah = r15_amount_uae_fujairah;
	}
	public BigDecimal getR15_no_of_accounts_non_uae_fujairah() {
		return r15_no_of_accounts_non_uae_fujairah;
	}
	public void setR15_no_of_accounts_non_uae_fujairah(BigDecimal r15_no_of_accounts_non_uae_fujairah) {
		this.r15_no_of_accounts_non_uae_fujairah = r15_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR15_amount_non_uae_fujairah() {
		return r15_amount_non_uae_fujairah;
	}
	public void setR15_amount_non_uae_fujairah(BigDecimal r15_amount_non_uae_fujairah) {
		this.r15_amount_non_uae_fujairah = r15_amount_non_uae_fujairah;
	}
	public BigDecimal getR15_total_fujairah() {
		return r15_total_fujairah;
	}
	public void setR15_total_fujairah(BigDecimal r15_total_fujairah) {
		this.r15_total_fujairah = r15_total_fujairah;
	}
	public String getR16_product() {
		return r16_product;
	}
	public void setR16_product(String r16_product) {
		this.r16_product = r16_product;
	}
	public BigDecimal getR16_no_of_accounts_uae() {
		return r16_no_of_accounts_uae;
	}
	public void setR16_no_of_accounts_uae(BigDecimal r16_no_of_accounts_uae) {
		this.r16_no_of_accounts_uae = r16_no_of_accounts_uae;
	}
	public BigDecimal getR16_amount_uae() {
		return r16_amount_uae;
	}
	public void setR16_amount_uae(BigDecimal r16_amount_uae) {
		this.r16_amount_uae = r16_amount_uae;
	}
	public BigDecimal getR16_no_of_accounts_resident() {
		return r16_no_of_accounts_resident;
	}
	public void setR16_no_of_accounts_resident(BigDecimal r16_no_of_accounts_resident) {
		this.r16_no_of_accounts_resident = r16_no_of_accounts_resident;
	}
	public BigDecimal getR16_amount_resident() {
		return r16_amount_resident;
	}
	public void setR16_amount_resident(BigDecimal r16_amount_resident) {
		this.r16_amount_resident = r16_amount_resident;
	}
	public BigDecimal getR16_no_of_accounts_non_resident() {
		return r16_no_of_accounts_non_resident;
	}
	public void setR16_no_of_accounts_non_resident(BigDecimal r16_no_of_accounts_non_resident) {
		this.r16_no_of_accounts_non_resident = r16_no_of_accounts_non_resident;
	}
	public BigDecimal getR16_amount_non_resident() {
		return r16_amount_non_resident;
	}
	public void setR16_amount_non_resident(BigDecimal r16_amount_non_resident) {
		this.r16_amount_non_resident = r16_amount_non_resident;
	}
	public BigDecimal getR16_total_account() {
		return r16_total_account;
	}
	public void setR16_total_account(BigDecimal r16_total_account) {
		this.r16_total_account = r16_total_account;
	}
	public BigDecimal getR16_total_amount() {
		return r16_total_amount;
	}
	public void setR16_total_amount(BigDecimal r16_total_amount) {
		this.r16_total_amount = r16_total_amount;
	}
	public BigDecimal getR16_no_of_accounts_uae_abu() {
		return r16_no_of_accounts_uae_abu;
	}
	public void setR16_no_of_accounts_uae_abu(BigDecimal r16_no_of_accounts_uae_abu) {
		this.r16_no_of_accounts_uae_abu = r16_no_of_accounts_uae_abu;
	}
	public BigDecimal getR16_amount_uae_abu() {
		return r16_amount_uae_abu;
	}
	public void setR16_amount_uae_abu(BigDecimal r16_amount_uae_abu) {
		this.r16_amount_uae_abu = r16_amount_uae_abu;
	}
	public BigDecimal getR16_no_of_accounts_non_uae_abu() {
		return r16_no_of_accounts_non_uae_abu;
	}
	public void setR16_no_of_accounts_non_uae_abu(BigDecimal r16_no_of_accounts_non_uae_abu) {
		this.r16_no_of_accounts_non_uae_abu = r16_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR16_amount_non_uae_abu() {
		return r16_amount_non_uae_abu;
	}
	public void setR16_amount_non_uae_abu(BigDecimal r16_amount_non_uae_abu) {
		this.r16_amount_non_uae_abu = r16_amount_non_uae_abu;
	}
	public BigDecimal getR16_total_abu() {
		return r16_total_abu;
	}
	public void setR16_total_abu(BigDecimal r16_total_abu) {
		this.r16_total_abu = r16_total_abu;
	}
	public BigDecimal getR16_no_of_accounts_uae_dubai() {
		return r16_no_of_accounts_uae_dubai;
	}
	public void setR16_no_of_accounts_uae_dubai(BigDecimal r16_no_of_accounts_uae_dubai) {
		this.r16_no_of_accounts_uae_dubai = r16_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR16_amount_uae_dubai() {
		return r16_amount_uae_dubai;
	}
	public void setR16_amount_uae_dubai(BigDecimal r16_amount_uae_dubai) {
		this.r16_amount_uae_dubai = r16_amount_uae_dubai;
	}
	public BigDecimal getR16_no_of_accounts_non_uae_dubai() {
		return r16_no_of_accounts_non_uae_dubai;
	}
	public void setR16_no_of_accounts_non_uae_dubai(BigDecimal r16_no_of_accounts_non_uae_dubai) {
		this.r16_no_of_accounts_non_uae_dubai = r16_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR16_amount_non_uae_dubai() {
		return r16_amount_non_uae_dubai;
	}
	public void setR16_amount_non_uae_dubai(BigDecimal r16_amount_non_uae_dubai) {
		this.r16_amount_non_uae_dubai = r16_amount_non_uae_dubai;
	}
	public BigDecimal getR16_total_dubai() {
		return r16_total_dubai;
	}
	public void setR16_total_dubai(BigDecimal r16_total_dubai) {
		this.r16_total_dubai = r16_total_dubai;
	}
	public BigDecimal getR16_no_of_accounts_uae_sharjah() {
		return r16_no_of_accounts_uae_sharjah;
	}
	public void setR16_no_of_accounts_uae_sharjah(BigDecimal r16_no_of_accounts_uae_sharjah) {
		this.r16_no_of_accounts_uae_sharjah = r16_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR16_amount_uae_sharjah() {
		return r16_amount_uae_sharjah;
	}
	public void setR16_amount_uae_sharjah(BigDecimal r16_amount_uae_sharjah) {
		this.r16_amount_uae_sharjah = r16_amount_uae_sharjah;
	}
	public BigDecimal getR16_no_of_accounts_non_uae_sharjah() {
		return r16_no_of_accounts_non_uae_sharjah;
	}
	public void setR16_no_of_accounts_non_uae_sharjah(BigDecimal r16_no_of_accounts_non_uae_sharjah) {
		this.r16_no_of_accounts_non_uae_sharjah = r16_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR16_amount_non_uae_sharjah() {
		return r16_amount_non_uae_sharjah;
	}
	public void setR16_amount_non_uae_sharjah(BigDecimal r16_amount_non_uae_sharjah) {
		this.r16_amount_non_uae_sharjah = r16_amount_non_uae_sharjah;
	}
	public BigDecimal getR16_total_sharjah() {
		return r16_total_sharjah;
	}
	public void setR16_total_sharjah(BigDecimal r16_total_sharjah) {
		this.r16_total_sharjah = r16_total_sharjah;
	}
	public BigDecimal getR16_no_of_accounts_uae_ajman() {
		return r16_no_of_accounts_uae_ajman;
	}
	public void setR16_no_of_accounts_uae_ajman(BigDecimal r16_no_of_accounts_uae_ajman) {
		this.r16_no_of_accounts_uae_ajman = r16_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR16_amount_uae_ajman() {
		return r16_amount_uae_ajman;
	}
	public void setR16_amount_uae_ajman(BigDecimal r16_amount_uae_ajman) {
		this.r16_amount_uae_ajman = r16_amount_uae_ajman;
	}
	public BigDecimal getR16_no_of_accounts_non_uae_ajman() {
		return r16_no_of_accounts_non_uae_ajman;
	}
	public void setR16_no_of_accounts_non_uae_ajman(BigDecimal r16_no_of_accounts_non_uae_ajman) {
		this.r16_no_of_accounts_non_uae_ajman = r16_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR16_amount_non_uae_ajman() {
		return r16_amount_non_uae_ajman;
	}
	public void setR16_amount_non_uae_ajman(BigDecimal r16_amount_non_uae_ajman) {
		this.r16_amount_non_uae_ajman = r16_amount_non_uae_ajman;
	}
	public BigDecimal getR16_total_ajman() {
		return r16_total_ajman;
	}
	public void setR16_total_ajman(BigDecimal r16_total_ajman) {
		this.r16_total_ajman = r16_total_ajman;
	}
	public BigDecimal getR16_no_of_accounts_uae_ras() {
		return r16_no_of_accounts_uae_ras;
	}
	public void setR16_no_of_accounts_uae_ras(BigDecimal r16_no_of_accounts_uae_ras) {
		this.r16_no_of_accounts_uae_ras = r16_no_of_accounts_uae_ras;
	}
	public BigDecimal getR16_amount_uae_ras() {
		return r16_amount_uae_ras;
	}
	public void setR16_amount_uae_ras(BigDecimal r16_amount_uae_ras) {
		this.r16_amount_uae_ras = r16_amount_uae_ras;
	}
	public BigDecimal getR16_no_of_accounts_non_uae_ras() {
		return r16_no_of_accounts_non_uae_ras;
	}
	public void setR16_no_of_accounts_non_uae_ras(BigDecimal r16_no_of_accounts_non_uae_ras) {
		this.r16_no_of_accounts_non_uae_ras = r16_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR16_amount_non_uae_ras() {
		return r16_amount_non_uae_ras;
	}
	public void setR16_amount_non_uae_ras(BigDecimal r16_amount_non_uae_ras) {
		this.r16_amount_non_uae_ras = r16_amount_non_uae_ras;
	}
	public BigDecimal getR16_total_ras() {
		return r16_total_ras;
	}
	public void setR16_total_ras(BigDecimal r16_total_ras) {
		this.r16_total_ras = r16_total_ras;
	}
	public BigDecimal getR16_no_of_accounts_uae_umm() {
		return r16_no_of_accounts_uae_umm;
	}
	public void setR16_no_of_accounts_uae_umm(BigDecimal r16_no_of_accounts_uae_umm) {
		this.r16_no_of_accounts_uae_umm = r16_no_of_accounts_uae_umm;
	}
	public BigDecimal getR16_amount_uae_umm() {
		return r16_amount_uae_umm;
	}
	public void setR16_amount_uae_umm(BigDecimal r16_amount_uae_umm) {
		this.r16_amount_uae_umm = r16_amount_uae_umm;
	}
	public BigDecimal getR16_no_of_accounts_non_uae_umm() {
		return r16_no_of_accounts_non_uae_umm;
	}
	public void setR16_no_of_accounts_non_uae_umm(BigDecimal r16_no_of_accounts_non_uae_umm) {
		this.r16_no_of_accounts_non_uae_umm = r16_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR16_amount_non_uae_umm() {
		return r16_amount_non_uae_umm;
	}
	public void setR16_amount_non_uae_umm(BigDecimal r16_amount_non_uae_umm) {
		this.r16_amount_non_uae_umm = r16_amount_non_uae_umm;
	}
	public BigDecimal getR16_total_umm() {
		return r16_total_umm;
	}
	public void setR16_total_umm(BigDecimal r16_total_umm) {
		this.r16_total_umm = r16_total_umm;
	}
	public BigDecimal getR16_no_of_accounts_uae_fujairah() {
		return r16_no_of_accounts_uae_fujairah;
	}
	public void setR16_no_of_accounts_uae_fujairah(BigDecimal r16_no_of_accounts_uae_fujairah) {
		this.r16_no_of_accounts_uae_fujairah = r16_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR16_amount_uae_fujairah() {
		return r16_amount_uae_fujairah;
	}
	public void setR16_amount_uae_fujairah(BigDecimal r16_amount_uae_fujairah) {
		this.r16_amount_uae_fujairah = r16_amount_uae_fujairah;
	}
	public BigDecimal getR16_no_of_accounts_non_uae_fujairah() {
		return r16_no_of_accounts_non_uae_fujairah;
	}
	public void setR16_no_of_accounts_non_uae_fujairah(BigDecimal r16_no_of_accounts_non_uae_fujairah) {
		this.r16_no_of_accounts_non_uae_fujairah = r16_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR16_amount_non_uae_fujairah() {
		return r16_amount_non_uae_fujairah;
	}
	public void setR16_amount_non_uae_fujairah(BigDecimal r16_amount_non_uae_fujairah) {
		this.r16_amount_non_uae_fujairah = r16_amount_non_uae_fujairah;
	}
	public BigDecimal getR16_total_fujairah() {
		return r16_total_fujairah;
	}
	public void setR16_total_fujairah(BigDecimal r16_total_fujairah) {
		this.r16_total_fujairah = r16_total_fujairah;
	}
	public String getR17_product() {
		return r17_product;
	}
	public void setR17_product(String r17_product) {
		this.r17_product = r17_product;
	}
	public BigDecimal getR17_no_of_accounts_uae() {
		return r17_no_of_accounts_uae;
	}
	public void setR17_no_of_accounts_uae(BigDecimal r17_no_of_accounts_uae) {
		this.r17_no_of_accounts_uae = r17_no_of_accounts_uae;
	}
	public BigDecimal getR17_amount_uae() {
		return r17_amount_uae;
	}
	public void setR17_amount_uae(BigDecimal r17_amount_uae) {
		this.r17_amount_uae = r17_amount_uae;
	}
	public BigDecimal getR17_no_of_accounts_resident() {
		return r17_no_of_accounts_resident;
	}
	public void setR17_no_of_accounts_resident(BigDecimal r17_no_of_accounts_resident) {
		this.r17_no_of_accounts_resident = r17_no_of_accounts_resident;
	}
	public BigDecimal getR17_amount_resident() {
		return r17_amount_resident;
	}
	public void setR17_amount_resident(BigDecimal r17_amount_resident) {
		this.r17_amount_resident = r17_amount_resident;
	}
	public BigDecimal getR17_no_of_accounts_non_resident() {
		return r17_no_of_accounts_non_resident;
	}
	public void setR17_no_of_accounts_non_resident(BigDecimal r17_no_of_accounts_non_resident) {
		this.r17_no_of_accounts_non_resident = r17_no_of_accounts_non_resident;
	}
	public BigDecimal getR17_amount_non_resident() {
		return r17_amount_non_resident;
	}
	public void setR17_amount_non_resident(BigDecimal r17_amount_non_resident) {
		this.r17_amount_non_resident = r17_amount_non_resident;
	}
	public BigDecimal getR17_total_account() {
		return r17_total_account;
	}
	public void setR17_total_account(BigDecimal r17_total_account) {
		this.r17_total_account = r17_total_account;
	}
	public BigDecimal getR17_total_amount() {
		return r17_total_amount;
	}
	public void setR17_total_amount(BigDecimal r17_total_amount) {
		this.r17_total_amount = r17_total_amount;
	}
	public BigDecimal getR17_no_of_accounts_uae_abu() {
		return r17_no_of_accounts_uae_abu;
	}
	public void setR17_no_of_accounts_uae_abu(BigDecimal r17_no_of_accounts_uae_abu) {
		this.r17_no_of_accounts_uae_abu = r17_no_of_accounts_uae_abu;
	}
	public BigDecimal getR17_amount_uae_abu() {
		return r17_amount_uae_abu;
	}
	public void setR17_amount_uae_abu(BigDecimal r17_amount_uae_abu) {
		this.r17_amount_uae_abu = r17_amount_uae_abu;
	}
	public BigDecimal getR17_no_of_accounts_non_uae_abu() {
		return r17_no_of_accounts_non_uae_abu;
	}
	public void setR17_no_of_accounts_non_uae_abu(BigDecimal r17_no_of_accounts_non_uae_abu) {
		this.r17_no_of_accounts_non_uae_abu = r17_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR17_amount_non_uae_abu() {
		return r17_amount_non_uae_abu;
	}
	public void setR17_amount_non_uae_abu(BigDecimal r17_amount_non_uae_abu) {
		this.r17_amount_non_uae_abu = r17_amount_non_uae_abu;
	}
	public BigDecimal getR17_total_abu() {
		return r17_total_abu;
	}
	public void setR17_total_abu(BigDecimal r17_total_abu) {
		this.r17_total_abu = r17_total_abu;
	}
	public BigDecimal getR17_no_of_accounts_uae_dubai() {
		return r17_no_of_accounts_uae_dubai;
	}
	public void setR17_no_of_accounts_uae_dubai(BigDecimal r17_no_of_accounts_uae_dubai) {
		this.r17_no_of_accounts_uae_dubai = r17_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR17_amount_uae_dubai() {
		return r17_amount_uae_dubai;
	}
	public void setR17_amount_uae_dubai(BigDecimal r17_amount_uae_dubai) {
		this.r17_amount_uae_dubai = r17_amount_uae_dubai;
	}
	public BigDecimal getR17_no_of_accounts_non_uae_dubai() {
		return r17_no_of_accounts_non_uae_dubai;
	}
	public void setR17_no_of_accounts_non_uae_dubai(BigDecimal r17_no_of_accounts_non_uae_dubai) {
		this.r17_no_of_accounts_non_uae_dubai = r17_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR17_amount_non_uae_dubai() {
		return r17_amount_non_uae_dubai;
	}
	public void setR17_amount_non_uae_dubai(BigDecimal r17_amount_non_uae_dubai) {
		this.r17_amount_non_uae_dubai = r17_amount_non_uae_dubai;
	}
	public BigDecimal getR17_total_dubai() {
		return r17_total_dubai;
	}
	public void setR17_total_dubai(BigDecimal r17_total_dubai) {
		this.r17_total_dubai = r17_total_dubai;
	}
	public BigDecimal getR17_no_of_accounts_uae_sharjah() {
		return r17_no_of_accounts_uae_sharjah;
	}
	public void setR17_no_of_accounts_uae_sharjah(BigDecimal r17_no_of_accounts_uae_sharjah) {
		this.r17_no_of_accounts_uae_sharjah = r17_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR17_amount_uae_sharjah() {
		return r17_amount_uae_sharjah;
	}
	public void setR17_amount_uae_sharjah(BigDecimal r17_amount_uae_sharjah) {
		this.r17_amount_uae_sharjah = r17_amount_uae_sharjah;
	}
	public BigDecimal getR17_no_of_accounts_non_uae_sharjah() {
		return r17_no_of_accounts_non_uae_sharjah;
	}
	public void setR17_no_of_accounts_non_uae_sharjah(BigDecimal r17_no_of_accounts_non_uae_sharjah) {
		this.r17_no_of_accounts_non_uae_sharjah = r17_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR17_amount_non_uae_sharjah() {
		return r17_amount_non_uae_sharjah;
	}
	public void setR17_amount_non_uae_sharjah(BigDecimal r17_amount_non_uae_sharjah) {
		this.r17_amount_non_uae_sharjah = r17_amount_non_uae_sharjah;
	}
	public BigDecimal getR17_total_sharjah() {
		return r17_total_sharjah;
	}
	public void setR17_total_sharjah(BigDecimal r17_total_sharjah) {
		this.r17_total_sharjah = r17_total_sharjah;
	}
	public BigDecimal getR17_no_of_accounts_uae_ajman() {
		return r17_no_of_accounts_uae_ajman;
	}
	public void setR17_no_of_accounts_uae_ajman(BigDecimal r17_no_of_accounts_uae_ajman) {
		this.r17_no_of_accounts_uae_ajman = r17_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR17_amount_uae_ajman() {
		return r17_amount_uae_ajman;
	}
	public void setR17_amount_uae_ajman(BigDecimal r17_amount_uae_ajman) {
		this.r17_amount_uae_ajman = r17_amount_uae_ajman;
	}
	public BigDecimal getR17_no_of_accounts_non_uae_ajman() {
		return r17_no_of_accounts_non_uae_ajman;
	}
	public void setR17_no_of_accounts_non_uae_ajman(BigDecimal r17_no_of_accounts_non_uae_ajman) {
		this.r17_no_of_accounts_non_uae_ajman = r17_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR17_amount_non_uae_ajman() {
		return r17_amount_non_uae_ajman;
	}
	public void setR17_amount_non_uae_ajman(BigDecimal r17_amount_non_uae_ajman) {
		this.r17_amount_non_uae_ajman = r17_amount_non_uae_ajman;
	}
	public BigDecimal getR17_total_ajman() {
		return r17_total_ajman;
	}
	public void setR17_total_ajman(BigDecimal r17_total_ajman) {
		this.r17_total_ajman = r17_total_ajman;
	}
	public BigDecimal getR17_no_of_accounts_uae_ras() {
		return r17_no_of_accounts_uae_ras;
	}
	public void setR17_no_of_accounts_uae_ras(BigDecimal r17_no_of_accounts_uae_ras) {
		this.r17_no_of_accounts_uae_ras = r17_no_of_accounts_uae_ras;
	}
	public BigDecimal getR17_amount_uae_ras() {
		return r17_amount_uae_ras;
	}
	public void setR17_amount_uae_ras(BigDecimal r17_amount_uae_ras) {
		this.r17_amount_uae_ras = r17_amount_uae_ras;
	}
	public BigDecimal getR17_no_of_accounts_non_uae_ras() {
		return r17_no_of_accounts_non_uae_ras;
	}
	public void setR17_no_of_accounts_non_uae_ras(BigDecimal r17_no_of_accounts_non_uae_ras) {
		this.r17_no_of_accounts_non_uae_ras = r17_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR17_amount_non_uae_ras() {
		return r17_amount_non_uae_ras;
	}
	public void setR17_amount_non_uae_ras(BigDecimal r17_amount_non_uae_ras) {
		this.r17_amount_non_uae_ras = r17_amount_non_uae_ras;
	}
	public BigDecimal getR17_total_ras() {
		return r17_total_ras;
	}
	public void setR17_total_ras(BigDecimal r17_total_ras) {
		this.r17_total_ras = r17_total_ras;
	}
	public BigDecimal getR17_no_of_accounts_uae_umm() {
		return r17_no_of_accounts_uae_umm;
	}
	public void setR17_no_of_accounts_uae_umm(BigDecimal r17_no_of_accounts_uae_umm) {
		this.r17_no_of_accounts_uae_umm = r17_no_of_accounts_uae_umm;
	}
	public BigDecimal getR17_amount_uae_umm() {
		return r17_amount_uae_umm;
	}
	public void setR17_amount_uae_umm(BigDecimal r17_amount_uae_umm) {
		this.r17_amount_uae_umm = r17_amount_uae_umm;
	}
	public BigDecimal getR17_no_of_accounts_non_uae_umm() {
		return r17_no_of_accounts_non_uae_umm;
	}
	public void setR17_no_of_accounts_non_uae_umm(BigDecimal r17_no_of_accounts_non_uae_umm) {
		this.r17_no_of_accounts_non_uae_umm = r17_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR17_amount_non_uae_umm() {
		return r17_amount_non_uae_umm;
	}
	public void setR17_amount_non_uae_umm(BigDecimal r17_amount_non_uae_umm) {
		this.r17_amount_non_uae_umm = r17_amount_non_uae_umm;
	}
	public BigDecimal getR17_total_umm() {
		return r17_total_umm;
	}
	public void setR17_total_umm(BigDecimal r17_total_umm) {
		this.r17_total_umm = r17_total_umm;
	}
	public BigDecimal getR17_no_of_accounts_uae_fujairah() {
		return r17_no_of_accounts_uae_fujairah;
	}
	public void setR17_no_of_accounts_uae_fujairah(BigDecimal r17_no_of_accounts_uae_fujairah) {
		this.r17_no_of_accounts_uae_fujairah = r17_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR17_amount_uae_fujairah() {
		return r17_amount_uae_fujairah;
	}
	public void setR17_amount_uae_fujairah(BigDecimal r17_amount_uae_fujairah) {
		this.r17_amount_uae_fujairah = r17_amount_uae_fujairah;
	}
	public BigDecimal getR17_no_of_accounts_non_uae_fujairah() {
		return r17_no_of_accounts_non_uae_fujairah;
	}
	public void setR17_no_of_accounts_non_uae_fujairah(BigDecimal r17_no_of_accounts_non_uae_fujairah) {
		this.r17_no_of_accounts_non_uae_fujairah = r17_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR17_amount_non_uae_fujairah() {
		return r17_amount_non_uae_fujairah;
	}
	public void setR17_amount_non_uae_fujairah(BigDecimal r17_amount_non_uae_fujairah) {
		this.r17_amount_non_uae_fujairah = r17_amount_non_uae_fujairah;
	}
	public BigDecimal getR17_total_fujairah() {
		return r17_total_fujairah;
	}
	public void setR17_total_fujairah(BigDecimal r17_total_fujairah) {
		this.r17_total_fujairah = r17_total_fujairah;
	}
	public String getR18_product() {
		return r18_product;
	}
	public void setR18_product(String r18_product) {
		this.r18_product = r18_product;
	}
	public BigDecimal getR18_no_of_accounts_uae() {
		return r18_no_of_accounts_uae;
	}
	public void setR18_no_of_accounts_uae(BigDecimal r18_no_of_accounts_uae) {
		this.r18_no_of_accounts_uae = r18_no_of_accounts_uae;
	}
	public BigDecimal getR18_amount_uae() {
		return r18_amount_uae;
	}
	public void setR18_amount_uae(BigDecimal r18_amount_uae) {
		this.r18_amount_uae = r18_amount_uae;
	}
	public BigDecimal getR18_no_of_accounts_resident() {
		return r18_no_of_accounts_resident;
	}
	public void setR18_no_of_accounts_resident(BigDecimal r18_no_of_accounts_resident) {
		this.r18_no_of_accounts_resident = r18_no_of_accounts_resident;
	}
	public BigDecimal getR18_amount_resident() {
		return r18_amount_resident;
	}
	public void setR18_amount_resident(BigDecimal r18_amount_resident) {
		this.r18_amount_resident = r18_amount_resident;
	}
	public BigDecimal getR18_no_of_accounts_non_resident() {
		return r18_no_of_accounts_non_resident;
	}
	public void setR18_no_of_accounts_non_resident(BigDecimal r18_no_of_accounts_non_resident) {
		this.r18_no_of_accounts_non_resident = r18_no_of_accounts_non_resident;
	}
	public BigDecimal getR18_amount_non_resident() {
		return r18_amount_non_resident;
	}
	public void setR18_amount_non_resident(BigDecimal r18_amount_non_resident) {
		this.r18_amount_non_resident = r18_amount_non_resident;
	}
	public BigDecimal getR18_total_account() {
		return r18_total_account;
	}
	public void setR18_total_account(BigDecimal r18_total_account) {
		this.r18_total_account = r18_total_account;
	}
	public BigDecimal getR18_total_amount() {
		return r18_total_amount;
	}
	public void setR18_total_amount(BigDecimal r18_total_amount) {
		this.r18_total_amount = r18_total_amount;
	}
	public BigDecimal getR18_no_of_accounts_uae_abu() {
		return r18_no_of_accounts_uae_abu;
	}
	public void setR18_no_of_accounts_uae_abu(BigDecimal r18_no_of_accounts_uae_abu) {
		this.r18_no_of_accounts_uae_abu = r18_no_of_accounts_uae_abu;
	}
	public BigDecimal getR18_amount_uae_abu() {
		return r18_amount_uae_abu;
	}
	public void setR18_amount_uae_abu(BigDecimal r18_amount_uae_abu) {
		this.r18_amount_uae_abu = r18_amount_uae_abu;
	}
	public BigDecimal getR18_no_of_accounts_non_uae_abu() {
		return r18_no_of_accounts_non_uae_abu;
	}
	public void setR18_no_of_accounts_non_uae_abu(BigDecimal r18_no_of_accounts_non_uae_abu) {
		this.r18_no_of_accounts_non_uae_abu = r18_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR18_amount_non_uae_abu() {
		return r18_amount_non_uae_abu;
	}
	public void setR18_amount_non_uae_abu(BigDecimal r18_amount_non_uae_abu) {
		this.r18_amount_non_uae_abu = r18_amount_non_uae_abu;
	}
	public BigDecimal getR18_total_abu() {
		return r18_total_abu;
	}
	public void setR18_total_abu(BigDecimal r18_total_abu) {
		this.r18_total_abu = r18_total_abu;
	}
	public BigDecimal getR18_no_of_accounts_uae_dubai() {
		return r18_no_of_accounts_uae_dubai;
	}
	public void setR18_no_of_accounts_uae_dubai(BigDecimal r18_no_of_accounts_uae_dubai) {
		this.r18_no_of_accounts_uae_dubai = r18_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR18_amount_uae_dubai() {
		return r18_amount_uae_dubai;
	}
	public void setR18_amount_uae_dubai(BigDecimal r18_amount_uae_dubai) {
		this.r18_amount_uae_dubai = r18_amount_uae_dubai;
	}
	public BigDecimal getR18_no_of_accounts_non_uae_dubai() {
		return r18_no_of_accounts_non_uae_dubai;
	}
	public void setR18_no_of_accounts_non_uae_dubai(BigDecimal r18_no_of_accounts_non_uae_dubai) {
		this.r18_no_of_accounts_non_uae_dubai = r18_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR18_amount_non_uae_dubai() {
		return r18_amount_non_uae_dubai;
	}
	public void setR18_amount_non_uae_dubai(BigDecimal r18_amount_non_uae_dubai) {
		this.r18_amount_non_uae_dubai = r18_amount_non_uae_dubai;
	}
	public BigDecimal getR18_total_dubai() {
		return r18_total_dubai;
	}
	public void setR18_total_dubai(BigDecimal r18_total_dubai) {
		this.r18_total_dubai = r18_total_dubai;
	}
	public BigDecimal getR18_no_of_accounts_uae_sharjah() {
		return r18_no_of_accounts_uae_sharjah;
	}
	public void setR18_no_of_accounts_uae_sharjah(BigDecimal r18_no_of_accounts_uae_sharjah) {
		this.r18_no_of_accounts_uae_sharjah = r18_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR18_amount_uae_sharjah() {
		return r18_amount_uae_sharjah;
	}
	public void setR18_amount_uae_sharjah(BigDecimal r18_amount_uae_sharjah) {
		this.r18_amount_uae_sharjah = r18_amount_uae_sharjah;
	}
	public BigDecimal getR18_no_of_accounts_non_uae_sharjah() {
		return r18_no_of_accounts_non_uae_sharjah;
	}
	public void setR18_no_of_accounts_non_uae_sharjah(BigDecimal r18_no_of_accounts_non_uae_sharjah) {
		this.r18_no_of_accounts_non_uae_sharjah = r18_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR18_amount_non_uae_sharjah() {
		return r18_amount_non_uae_sharjah;
	}
	public void setR18_amount_non_uae_sharjah(BigDecimal r18_amount_non_uae_sharjah) {
		this.r18_amount_non_uae_sharjah = r18_amount_non_uae_sharjah;
	}
	public BigDecimal getR18_total_sharjah() {
		return r18_total_sharjah;
	}
	public void setR18_total_sharjah(BigDecimal r18_total_sharjah) {
		this.r18_total_sharjah = r18_total_sharjah;
	}
	public BigDecimal getR18_no_of_accounts_uae_ajman() {
		return r18_no_of_accounts_uae_ajman;
	}
	public void setR18_no_of_accounts_uae_ajman(BigDecimal r18_no_of_accounts_uae_ajman) {
		this.r18_no_of_accounts_uae_ajman = r18_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR18_amount_uae_ajman() {
		return r18_amount_uae_ajman;
	}
	public void setR18_amount_uae_ajman(BigDecimal r18_amount_uae_ajman) {
		this.r18_amount_uae_ajman = r18_amount_uae_ajman;
	}
	public BigDecimal getR18_no_of_accounts_non_uae_ajman() {
		return r18_no_of_accounts_non_uae_ajman;
	}
	public void setR18_no_of_accounts_non_uae_ajman(BigDecimal r18_no_of_accounts_non_uae_ajman) {
		this.r18_no_of_accounts_non_uae_ajman = r18_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR18_amount_non_uae_ajman() {
		return r18_amount_non_uae_ajman;
	}
	public void setR18_amount_non_uae_ajman(BigDecimal r18_amount_non_uae_ajman) {
		this.r18_amount_non_uae_ajman = r18_amount_non_uae_ajman;
	}
	public BigDecimal getR18_total_ajman() {
		return r18_total_ajman;
	}
	public void setR18_total_ajman(BigDecimal r18_total_ajman) {
		this.r18_total_ajman = r18_total_ajman;
	}
	public BigDecimal getR18_no_of_accounts_uae_ras() {
		return r18_no_of_accounts_uae_ras;
	}
	public void setR18_no_of_accounts_uae_ras(BigDecimal r18_no_of_accounts_uae_ras) {
		this.r18_no_of_accounts_uae_ras = r18_no_of_accounts_uae_ras;
	}
	public BigDecimal getR18_amount_uae_ras() {
		return r18_amount_uae_ras;
	}
	public void setR18_amount_uae_ras(BigDecimal r18_amount_uae_ras) {
		this.r18_amount_uae_ras = r18_amount_uae_ras;
	}
	public BigDecimal getR18_no_of_accounts_non_uae_ras() {
		return r18_no_of_accounts_non_uae_ras;
	}
	public void setR18_no_of_accounts_non_uae_ras(BigDecimal r18_no_of_accounts_non_uae_ras) {
		this.r18_no_of_accounts_non_uae_ras = r18_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR18_amount_non_uae_ras() {
		return r18_amount_non_uae_ras;
	}
	public void setR18_amount_non_uae_ras(BigDecimal r18_amount_non_uae_ras) {
		this.r18_amount_non_uae_ras = r18_amount_non_uae_ras;
	}
	public BigDecimal getR18_total_ras() {
		return r18_total_ras;
	}
	public void setR18_total_ras(BigDecimal r18_total_ras) {
		this.r18_total_ras = r18_total_ras;
	}
	public BigDecimal getR18_no_of_accounts_uae_umm() {
		return r18_no_of_accounts_uae_umm;
	}
	public void setR18_no_of_accounts_uae_umm(BigDecimal r18_no_of_accounts_uae_umm) {
		this.r18_no_of_accounts_uae_umm = r18_no_of_accounts_uae_umm;
	}
	public BigDecimal getR18_amount_uae_umm() {
		return r18_amount_uae_umm;
	}
	public void setR18_amount_uae_umm(BigDecimal r18_amount_uae_umm) {
		this.r18_amount_uae_umm = r18_amount_uae_umm;
	}
	public BigDecimal getR18_no_of_accounts_non_uae_umm() {
		return r18_no_of_accounts_non_uae_umm;
	}
	public void setR18_no_of_accounts_non_uae_umm(BigDecimal r18_no_of_accounts_non_uae_umm) {
		this.r18_no_of_accounts_non_uae_umm = r18_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR18_amount_non_uae_umm() {
		return r18_amount_non_uae_umm;
	}
	public void setR18_amount_non_uae_umm(BigDecimal r18_amount_non_uae_umm) {
		this.r18_amount_non_uae_umm = r18_amount_non_uae_umm;
	}
	public BigDecimal getR18_total_umm() {
		return r18_total_umm;
	}
	public void setR18_total_umm(BigDecimal r18_total_umm) {
		this.r18_total_umm = r18_total_umm;
	}
	public BigDecimal getR18_no_of_accounts_uae_fujairah() {
		return r18_no_of_accounts_uae_fujairah;
	}
	public void setR18_no_of_accounts_uae_fujairah(BigDecimal r18_no_of_accounts_uae_fujairah) {
		this.r18_no_of_accounts_uae_fujairah = r18_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR18_amount_uae_fujairah() {
		return r18_amount_uae_fujairah;
	}
	public void setR18_amount_uae_fujairah(BigDecimal r18_amount_uae_fujairah) {
		this.r18_amount_uae_fujairah = r18_amount_uae_fujairah;
	}
	public BigDecimal getR18_no_of_accounts_non_uae_fujairah() {
		return r18_no_of_accounts_non_uae_fujairah;
	}
	public void setR18_no_of_accounts_non_uae_fujairah(BigDecimal r18_no_of_accounts_non_uae_fujairah) {
		this.r18_no_of_accounts_non_uae_fujairah = r18_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR18_amount_non_uae_fujairah() {
		return r18_amount_non_uae_fujairah;
	}
	public void setR18_amount_non_uae_fujairah(BigDecimal r18_amount_non_uae_fujairah) {
		this.r18_amount_non_uae_fujairah = r18_amount_non_uae_fujairah;
	}
	public BigDecimal getR18_total_fujairah() {
		return r18_total_fujairah;
	}
	public void setR18_total_fujairah(BigDecimal r18_total_fujairah) {
		this.r18_total_fujairah = r18_total_fujairah;
	}
	public String getR19_product() {
		return r19_product;
	}
	public void setR19_product(String r19_product) {
		this.r19_product = r19_product;
	}
	public BigDecimal getR19_no_of_accounts_uae() {
		return r19_no_of_accounts_uae;
	}
	public void setR19_no_of_accounts_uae(BigDecimal r19_no_of_accounts_uae) {
		this.r19_no_of_accounts_uae = r19_no_of_accounts_uae;
	}
	public BigDecimal getR19_amount_uae() {
		return r19_amount_uae;
	}
	public void setR19_amount_uae(BigDecimal r19_amount_uae) {
		this.r19_amount_uae = r19_amount_uae;
	}
	public BigDecimal getR19_no_of_accounts_resident() {
		return r19_no_of_accounts_resident;
	}
	public void setR19_no_of_accounts_resident(BigDecimal r19_no_of_accounts_resident) {
		this.r19_no_of_accounts_resident = r19_no_of_accounts_resident;
	}
	public BigDecimal getR19_amount_resident() {
		return r19_amount_resident;
	}
	public void setR19_amount_resident(BigDecimal r19_amount_resident) {
		this.r19_amount_resident = r19_amount_resident;
	}
	public BigDecimal getR19_no_of_accounts_non_resident() {
		return r19_no_of_accounts_non_resident;
	}
	public void setR19_no_of_accounts_non_resident(BigDecimal r19_no_of_accounts_non_resident) {
		this.r19_no_of_accounts_non_resident = r19_no_of_accounts_non_resident;
	}
	public BigDecimal getR19_amount_non_resident() {
		return r19_amount_non_resident;
	}
	public void setR19_amount_non_resident(BigDecimal r19_amount_non_resident) {
		this.r19_amount_non_resident = r19_amount_non_resident;
	}
	public BigDecimal getR19_total_account() {
		return r19_total_account;
	}
	public void setR19_total_account(BigDecimal r19_total_account) {
		this.r19_total_account = r19_total_account;
	}
	public BigDecimal getR19_total_amount() {
		return r19_total_amount;
	}
	public void setR19_total_amount(BigDecimal r19_total_amount) {
		this.r19_total_amount = r19_total_amount;
	}
	public BigDecimal getR19_no_of_accounts_uae_abu() {
		return r19_no_of_accounts_uae_abu;
	}
	public void setR19_no_of_accounts_uae_abu(BigDecimal r19_no_of_accounts_uae_abu) {
		this.r19_no_of_accounts_uae_abu = r19_no_of_accounts_uae_abu;
	}
	public BigDecimal getR19_amount_uae_abu() {
		return r19_amount_uae_abu;
	}
	public void setR19_amount_uae_abu(BigDecimal r19_amount_uae_abu) {
		this.r19_amount_uae_abu = r19_amount_uae_abu;
	}
	public BigDecimal getR19_no_of_accounts_non_uae_abu() {
		return r19_no_of_accounts_non_uae_abu;
	}
	public void setR19_no_of_accounts_non_uae_abu(BigDecimal r19_no_of_accounts_non_uae_abu) {
		this.r19_no_of_accounts_non_uae_abu = r19_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR19_amount_non_uae_abu() {
		return r19_amount_non_uae_abu;
	}
	public void setR19_amount_non_uae_abu(BigDecimal r19_amount_non_uae_abu) {
		this.r19_amount_non_uae_abu = r19_amount_non_uae_abu;
	}
	public BigDecimal getR19_total_abu() {
		return r19_total_abu;
	}
	public void setR19_total_abu(BigDecimal r19_total_abu) {
		this.r19_total_abu = r19_total_abu;
	}
	public BigDecimal getR19_no_of_accounts_uae_dubai() {
		return r19_no_of_accounts_uae_dubai;
	}
	public void setR19_no_of_accounts_uae_dubai(BigDecimal r19_no_of_accounts_uae_dubai) {
		this.r19_no_of_accounts_uae_dubai = r19_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR19_amount_uae_dubai() {
		return r19_amount_uae_dubai;
	}
	public void setR19_amount_uae_dubai(BigDecimal r19_amount_uae_dubai) {
		this.r19_amount_uae_dubai = r19_amount_uae_dubai;
	}
	public BigDecimal getR19_no_of_accounts_non_uae_dubai() {
		return r19_no_of_accounts_non_uae_dubai;
	}
	public void setR19_no_of_accounts_non_uae_dubai(BigDecimal r19_no_of_accounts_non_uae_dubai) {
		this.r19_no_of_accounts_non_uae_dubai = r19_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR19_amount_non_uae_dubai() {
		return r19_amount_non_uae_dubai;
	}
	public void setR19_amount_non_uae_dubai(BigDecimal r19_amount_non_uae_dubai) {
		this.r19_amount_non_uae_dubai = r19_amount_non_uae_dubai;
	}
	public BigDecimal getR19_total_dubai() {
		return r19_total_dubai;
	}
	public void setR19_total_dubai(BigDecimal r19_total_dubai) {
		this.r19_total_dubai = r19_total_dubai;
	}
	public BigDecimal getR19_no_of_accounts_uae_sharjah() {
		return r19_no_of_accounts_uae_sharjah;
	}
	public void setR19_no_of_accounts_uae_sharjah(BigDecimal r19_no_of_accounts_uae_sharjah) {
		this.r19_no_of_accounts_uae_sharjah = r19_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR19_amount_uae_sharjah() {
		return r19_amount_uae_sharjah;
	}
	public void setR19_amount_uae_sharjah(BigDecimal r19_amount_uae_sharjah) {
		this.r19_amount_uae_sharjah = r19_amount_uae_sharjah;
	}
	public BigDecimal getR19_no_of_accounts_non_uae_sharjah() {
		return r19_no_of_accounts_non_uae_sharjah;
	}
	public void setR19_no_of_accounts_non_uae_sharjah(BigDecimal r19_no_of_accounts_non_uae_sharjah) {
		this.r19_no_of_accounts_non_uae_sharjah = r19_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR19_amount_non_uae_sharjah() {
		return r19_amount_non_uae_sharjah;
	}
	public void setR19_amount_non_uae_sharjah(BigDecimal r19_amount_non_uae_sharjah) {
		this.r19_amount_non_uae_sharjah = r19_amount_non_uae_sharjah;
	}
	public BigDecimal getR19_total_sharjah() {
		return r19_total_sharjah;
	}
	public void setR19_total_sharjah(BigDecimal r19_total_sharjah) {
		this.r19_total_sharjah = r19_total_sharjah;
	}
	public BigDecimal getR19_no_of_accounts_uae_ajman() {
		return r19_no_of_accounts_uae_ajman;
	}
	public void setR19_no_of_accounts_uae_ajman(BigDecimal r19_no_of_accounts_uae_ajman) {
		this.r19_no_of_accounts_uae_ajman = r19_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR19_amount_uae_ajman() {
		return r19_amount_uae_ajman;
	}
	public void setR19_amount_uae_ajman(BigDecimal r19_amount_uae_ajman) {
		this.r19_amount_uae_ajman = r19_amount_uae_ajman;
	}
	public BigDecimal getR19_no_of_accounts_non_uae_ajman() {
		return r19_no_of_accounts_non_uae_ajman;
	}
	public void setR19_no_of_accounts_non_uae_ajman(BigDecimal r19_no_of_accounts_non_uae_ajman) {
		this.r19_no_of_accounts_non_uae_ajman = r19_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR19_amount_non_uae_ajman() {
		return r19_amount_non_uae_ajman;
	}
	public void setR19_amount_non_uae_ajman(BigDecimal r19_amount_non_uae_ajman) {
		this.r19_amount_non_uae_ajman = r19_amount_non_uae_ajman;
	}
	public BigDecimal getR19_total_ajman() {
		return r19_total_ajman;
	}
	public void setR19_total_ajman(BigDecimal r19_total_ajman) {
		this.r19_total_ajman = r19_total_ajman;
	}
	public BigDecimal getR19_no_of_accounts_uae_ras() {
		return r19_no_of_accounts_uae_ras;
	}
	public void setR19_no_of_accounts_uae_ras(BigDecimal r19_no_of_accounts_uae_ras) {
		this.r19_no_of_accounts_uae_ras = r19_no_of_accounts_uae_ras;
	}
	public BigDecimal getR19_amount_uae_ras() {
		return r19_amount_uae_ras;
	}
	public void setR19_amount_uae_ras(BigDecimal r19_amount_uae_ras) {
		this.r19_amount_uae_ras = r19_amount_uae_ras;
	}
	public BigDecimal getR19_no_of_accounts_non_uae_ras() {
		return r19_no_of_accounts_non_uae_ras;
	}
	public void setR19_no_of_accounts_non_uae_ras(BigDecimal r19_no_of_accounts_non_uae_ras) {
		this.r19_no_of_accounts_non_uae_ras = r19_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR19_amount_non_uae_ras() {
		return r19_amount_non_uae_ras;
	}
	public void setR19_amount_non_uae_ras(BigDecimal r19_amount_non_uae_ras) {
		this.r19_amount_non_uae_ras = r19_amount_non_uae_ras;
	}
	public BigDecimal getR19_total_ras() {
		return r19_total_ras;
	}
	public void setR19_total_ras(BigDecimal r19_total_ras) {
		this.r19_total_ras = r19_total_ras;
	}
	public BigDecimal getR19_no_of_accounts_uae_umm() {
		return r19_no_of_accounts_uae_umm;
	}
	public void setR19_no_of_accounts_uae_umm(BigDecimal r19_no_of_accounts_uae_umm) {
		this.r19_no_of_accounts_uae_umm = r19_no_of_accounts_uae_umm;
	}
	public BigDecimal getR19_amount_uae_umm() {
		return r19_amount_uae_umm;
	}
	public void setR19_amount_uae_umm(BigDecimal r19_amount_uae_umm) {
		this.r19_amount_uae_umm = r19_amount_uae_umm;
	}
	public BigDecimal getR19_no_of_accounts_non_uae_umm() {
		return r19_no_of_accounts_non_uae_umm;
	}
	public void setR19_no_of_accounts_non_uae_umm(BigDecimal r19_no_of_accounts_non_uae_umm) {
		this.r19_no_of_accounts_non_uae_umm = r19_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR19_amount_non_uae_umm() {
		return r19_amount_non_uae_umm;
	}
	public void setR19_amount_non_uae_umm(BigDecimal r19_amount_non_uae_umm) {
		this.r19_amount_non_uae_umm = r19_amount_non_uae_umm;
	}
	public BigDecimal getR19_total_umm() {
		return r19_total_umm;
	}
	public void setR19_total_umm(BigDecimal r19_total_umm) {
		this.r19_total_umm = r19_total_umm;
	}
	public BigDecimal getR19_no_of_accounts_uae_fujairah() {
		return r19_no_of_accounts_uae_fujairah;
	}
	public void setR19_no_of_accounts_uae_fujairah(BigDecimal r19_no_of_accounts_uae_fujairah) {
		this.r19_no_of_accounts_uae_fujairah = r19_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR19_amount_uae_fujairah() {
		return r19_amount_uae_fujairah;
	}
	public void setR19_amount_uae_fujairah(BigDecimal r19_amount_uae_fujairah) {
		this.r19_amount_uae_fujairah = r19_amount_uae_fujairah;
	}
	public BigDecimal getR19_no_of_accounts_non_uae_fujairah() {
		return r19_no_of_accounts_non_uae_fujairah;
	}
	public void setR19_no_of_accounts_non_uae_fujairah(BigDecimal r19_no_of_accounts_non_uae_fujairah) {
		this.r19_no_of_accounts_non_uae_fujairah = r19_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR19_amount_non_uae_fujairah() {
		return r19_amount_non_uae_fujairah;
	}
	public void setR19_amount_non_uae_fujairah(BigDecimal r19_amount_non_uae_fujairah) {
		this.r19_amount_non_uae_fujairah = r19_amount_non_uae_fujairah;
	}
	public BigDecimal getR19_total_fujairah() {
		return r19_total_fujairah;
	}
	public void setR19_total_fujairah(BigDecimal r19_total_fujairah) {
		this.r19_total_fujairah = r19_total_fujairah;
	}
	public String getR20_product() {
		return r20_product;
	}
	public void setR20_product(String r20_product) {
		this.r20_product = r20_product;
	}
	public BigDecimal getR20_no_of_accounts_uae() {
		return r20_no_of_accounts_uae;
	}
	public void setR20_no_of_accounts_uae(BigDecimal r20_no_of_accounts_uae) {
		this.r20_no_of_accounts_uae = r20_no_of_accounts_uae;
	}
	public BigDecimal getR20_amount_uae() {
		return r20_amount_uae;
	}
	public void setR20_amount_uae(BigDecimal r20_amount_uae) {
		this.r20_amount_uae = r20_amount_uae;
	}
	public BigDecimal getR20_no_of_accounts_resident() {
		return r20_no_of_accounts_resident;
	}
	public void setR20_no_of_accounts_resident(BigDecimal r20_no_of_accounts_resident) {
		this.r20_no_of_accounts_resident = r20_no_of_accounts_resident;
	}
	public BigDecimal getR20_amount_resident() {
		return r20_amount_resident;
	}
	public void setR20_amount_resident(BigDecimal r20_amount_resident) {
		this.r20_amount_resident = r20_amount_resident;
	}
	public BigDecimal getR20_no_of_accounts_non_resident() {
		return r20_no_of_accounts_non_resident;
	}
	public void setR20_no_of_accounts_non_resident(BigDecimal r20_no_of_accounts_non_resident) {
		this.r20_no_of_accounts_non_resident = r20_no_of_accounts_non_resident;
	}
	public BigDecimal getR20_amount_non_resident() {
		return r20_amount_non_resident;
	}
	public void setR20_amount_non_resident(BigDecimal r20_amount_non_resident) {
		this.r20_amount_non_resident = r20_amount_non_resident;
	}
	public BigDecimal getR20_total_account() {
		return r20_total_account;
	}
	public void setR20_total_account(BigDecimal r20_total_account) {
		this.r20_total_account = r20_total_account;
	}
	public BigDecimal getR20_total_amount() {
		return r20_total_amount;
	}
	public void setR20_total_amount(BigDecimal r20_total_amount) {
		this.r20_total_amount = r20_total_amount;
	}
	public BigDecimal getR20_no_of_accounts_uae_abu() {
		return r20_no_of_accounts_uae_abu;
	}
	public void setR20_no_of_accounts_uae_abu(BigDecimal r20_no_of_accounts_uae_abu) {
		this.r20_no_of_accounts_uae_abu = r20_no_of_accounts_uae_abu;
	}
	public BigDecimal getR20_amount_uae_abu() {
		return r20_amount_uae_abu;
	}
	public void setR20_amount_uae_abu(BigDecimal r20_amount_uae_abu) {
		this.r20_amount_uae_abu = r20_amount_uae_abu;
	}
	public BigDecimal getR20_no_of_accounts_non_uae_abu() {
		return r20_no_of_accounts_non_uae_abu;
	}
	public void setR20_no_of_accounts_non_uae_abu(BigDecimal r20_no_of_accounts_non_uae_abu) {
		this.r20_no_of_accounts_non_uae_abu = r20_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR20_amount_non_uae_abu() {
		return r20_amount_non_uae_abu;
	}
	public void setR20_amount_non_uae_abu(BigDecimal r20_amount_non_uae_abu) {
		this.r20_amount_non_uae_abu = r20_amount_non_uae_abu;
	}
	public BigDecimal getR20_total_abu() {
		return r20_total_abu;
	}
	public void setR20_total_abu(BigDecimal r20_total_abu) {
		this.r20_total_abu = r20_total_abu;
	}
	public BigDecimal getR20_no_of_accounts_uae_dubai() {
		return r20_no_of_accounts_uae_dubai;
	}
	public void setR20_no_of_accounts_uae_dubai(BigDecimal r20_no_of_accounts_uae_dubai) {
		this.r20_no_of_accounts_uae_dubai = r20_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR20_amount_uae_dubai() {
		return r20_amount_uae_dubai;
	}
	public void setR20_amount_uae_dubai(BigDecimal r20_amount_uae_dubai) {
		this.r20_amount_uae_dubai = r20_amount_uae_dubai;
	}
	public BigDecimal getR20_no_of_accounts_non_uae_dubai() {
		return r20_no_of_accounts_non_uae_dubai;
	}
	public void setR20_no_of_accounts_non_uae_dubai(BigDecimal r20_no_of_accounts_non_uae_dubai) {
		this.r20_no_of_accounts_non_uae_dubai = r20_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR20_amount_non_uae_dubai() {
		return r20_amount_non_uae_dubai;
	}
	public void setR20_amount_non_uae_dubai(BigDecimal r20_amount_non_uae_dubai) {
		this.r20_amount_non_uae_dubai = r20_amount_non_uae_dubai;
	}
	public BigDecimal getR20_total_dubai() {
		return r20_total_dubai;
	}
	public void setR20_total_dubai(BigDecimal r20_total_dubai) {
		this.r20_total_dubai = r20_total_dubai;
	}
	public BigDecimal getR20_no_of_accounts_uae_sharjah() {
		return r20_no_of_accounts_uae_sharjah;
	}
	public void setR20_no_of_accounts_uae_sharjah(BigDecimal r20_no_of_accounts_uae_sharjah) {
		this.r20_no_of_accounts_uae_sharjah = r20_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR20_amount_uae_sharjah() {
		return r20_amount_uae_sharjah;
	}
	public void setR20_amount_uae_sharjah(BigDecimal r20_amount_uae_sharjah) {
		this.r20_amount_uae_sharjah = r20_amount_uae_sharjah;
	}
	public BigDecimal getR20_no_of_accounts_non_uae_sharjah() {
		return r20_no_of_accounts_non_uae_sharjah;
	}
	public void setR20_no_of_accounts_non_uae_sharjah(BigDecimal r20_no_of_accounts_non_uae_sharjah) {
		this.r20_no_of_accounts_non_uae_sharjah = r20_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR20_amount_non_uae_sharjah() {
		return r20_amount_non_uae_sharjah;
	}
	public void setR20_amount_non_uae_sharjah(BigDecimal r20_amount_non_uae_sharjah) {
		this.r20_amount_non_uae_sharjah = r20_amount_non_uae_sharjah;
	}
	public BigDecimal getR20_total_sharjah() {
		return r20_total_sharjah;
	}
	public void setR20_total_sharjah(BigDecimal r20_total_sharjah) {
		this.r20_total_sharjah = r20_total_sharjah;
	}
	public BigDecimal getR20_no_of_accounts_uae_ajman() {
		return r20_no_of_accounts_uae_ajman;
	}
	public void setR20_no_of_accounts_uae_ajman(BigDecimal r20_no_of_accounts_uae_ajman) {
		this.r20_no_of_accounts_uae_ajman = r20_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR20_amount_uae_ajman() {
		return r20_amount_uae_ajman;
	}
	public void setR20_amount_uae_ajman(BigDecimal r20_amount_uae_ajman) {
		this.r20_amount_uae_ajman = r20_amount_uae_ajman;
	}
	public BigDecimal getR20_no_of_accounts_non_uae_ajman() {
		return r20_no_of_accounts_non_uae_ajman;
	}
	public void setR20_no_of_accounts_non_uae_ajman(BigDecimal r20_no_of_accounts_non_uae_ajman) {
		this.r20_no_of_accounts_non_uae_ajman = r20_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR20_amount_non_uae_ajman() {
		return r20_amount_non_uae_ajman;
	}
	public void setR20_amount_non_uae_ajman(BigDecimal r20_amount_non_uae_ajman) {
		this.r20_amount_non_uae_ajman = r20_amount_non_uae_ajman;
	}
	public BigDecimal getR20_total_ajman() {
		return r20_total_ajman;
	}
	public void setR20_total_ajman(BigDecimal r20_total_ajman) {
		this.r20_total_ajman = r20_total_ajman;
	}
	public BigDecimal getR20_no_of_accounts_uae_ras() {
		return r20_no_of_accounts_uae_ras;
	}
	public void setR20_no_of_accounts_uae_ras(BigDecimal r20_no_of_accounts_uae_ras) {
		this.r20_no_of_accounts_uae_ras = r20_no_of_accounts_uae_ras;
	}
	public BigDecimal getR20_amount_uae_ras() {
		return r20_amount_uae_ras;
	}
	public void setR20_amount_uae_ras(BigDecimal r20_amount_uae_ras) {
		this.r20_amount_uae_ras = r20_amount_uae_ras;
	}
	public BigDecimal getR20_no_of_accounts_non_uae_ras() {
		return r20_no_of_accounts_non_uae_ras;
	}
	public void setR20_no_of_accounts_non_uae_ras(BigDecimal r20_no_of_accounts_non_uae_ras) {
		this.r20_no_of_accounts_non_uae_ras = r20_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR20_amount_non_uae_ras() {
		return r20_amount_non_uae_ras;
	}
	public void setR20_amount_non_uae_ras(BigDecimal r20_amount_non_uae_ras) {
		this.r20_amount_non_uae_ras = r20_amount_non_uae_ras;
	}
	public BigDecimal getR20_total_ras() {
		return r20_total_ras;
	}
	public void setR20_total_ras(BigDecimal r20_total_ras) {
		this.r20_total_ras = r20_total_ras;
	}
	public BigDecimal getR20_no_of_accounts_uae_umm() {
		return r20_no_of_accounts_uae_umm;
	}
	public void setR20_no_of_accounts_uae_umm(BigDecimal r20_no_of_accounts_uae_umm) {
		this.r20_no_of_accounts_uae_umm = r20_no_of_accounts_uae_umm;
	}
	public BigDecimal getR20_amount_uae_umm() {
		return r20_amount_uae_umm;
	}
	public void setR20_amount_uae_umm(BigDecimal r20_amount_uae_umm) {
		this.r20_amount_uae_umm = r20_amount_uae_umm;
	}
	public BigDecimal getR20_no_of_accounts_non_uae_umm() {
		return r20_no_of_accounts_non_uae_umm;
	}
	public void setR20_no_of_accounts_non_uae_umm(BigDecimal r20_no_of_accounts_non_uae_umm) {
		this.r20_no_of_accounts_non_uae_umm = r20_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR20_amount_non_uae_umm() {
		return r20_amount_non_uae_umm;
	}
	public void setR20_amount_non_uae_umm(BigDecimal r20_amount_non_uae_umm) {
		this.r20_amount_non_uae_umm = r20_amount_non_uae_umm;
	}
	public BigDecimal getR20_total_umm() {
		return r20_total_umm;
	}
	public void setR20_total_umm(BigDecimal r20_total_umm) {
		this.r20_total_umm = r20_total_umm;
	}
	public BigDecimal getR20_no_of_accounts_uae_fujairah() {
		return r20_no_of_accounts_uae_fujairah;
	}
	public void setR20_no_of_accounts_uae_fujairah(BigDecimal r20_no_of_accounts_uae_fujairah) {
		this.r20_no_of_accounts_uae_fujairah = r20_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR20_amount_uae_fujairah() {
		return r20_amount_uae_fujairah;
	}
	public void setR20_amount_uae_fujairah(BigDecimal r20_amount_uae_fujairah) {
		this.r20_amount_uae_fujairah = r20_amount_uae_fujairah;
	}
	public BigDecimal getR20_no_of_accounts_non_uae_fujairah() {
		return r20_no_of_accounts_non_uae_fujairah;
	}
	public void setR20_no_of_accounts_non_uae_fujairah(BigDecimal r20_no_of_accounts_non_uae_fujairah) {
		this.r20_no_of_accounts_non_uae_fujairah = r20_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR20_amount_non_uae_fujairah() {
		return r20_amount_non_uae_fujairah;
	}
	public void setR20_amount_non_uae_fujairah(BigDecimal r20_amount_non_uae_fujairah) {
		this.r20_amount_non_uae_fujairah = r20_amount_non_uae_fujairah;
	}
	public BigDecimal getR20_total_fujairah() {
		return r20_total_fujairah;
	}
	public void setR20_total_fujairah(BigDecimal r20_total_fujairah) {
		this.r20_total_fujairah = r20_total_fujairah;
	}
	public String getR21_product() {
		return r21_product;
	}
	public void setR21_product(String r21_product) {
		this.r21_product = r21_product;
	}
	public BigDecimal getR21_no_of_accounts_uae() {
		return r21_no_of_accounts_uae;
	}
	public void setR21_no_of_accounts_uae(BigDecimal r21_no_of_accounts_uae) {
		this.r21_no_of_accounts_uae = r21_no_of_accounts_uae;
	}
	public BigDecimal getR21_amount_uae() {
		return r21_amount_uae;
	}
	public void setR21_amount_uae(BigDecimal r21_amount_uae) {
		this.r21_amount_uae = r21_amount_uae;
	}
	public BigDecimal getR21_no_of_accounts_resident() {
		return r21_no_of_accounts_resident;
	}
	public void setR21_no_of_accounts_resident(BigDecimal r21_no_of_accounts_resident) {
		this.r21_no_of_accounts_resident = r21_no_of_accounts_resident;
	}
	public BigDecimal getR21_amount_resident() {
		return r21_amount_resident;
	}
	public void setR21_amount_resident(BigDecimal r21_amount_resident) {
		this.r21_amount_resident = r21_amount_resident;
	}
	public BigDecimal getR21_no_of_accounts_non_resident() {
		return r21_no_of_accounts_non_resident;
	}
	public void setR21_no_of_accounts_non_resident(BigDecimal r21_no_of_accounts_non_resident) {
		this.r21_no_of_accounts_non_resident = r21_no_of_accounts_non_resident;
	}
	public BigDecimal getR21_amount_non_resident() {
		return r21_amount_non_resident;
	}
	public void setR21_amount_non_resident(BigDecimal r21_amount_non_resident) {
		this.r21_amount_non_resident = r21_amount_non_resident;
	}
	public BigDecimal getR21_total_account() {
		return r21_total_account;
	}
	public void setR21_total_account(BigDecimal r21_total_account) {
		this.r21_total_account = r21_total_account;
	}
	public BigDecimal getR21_total_amount() {
		return r21_total_amount;
	}
	public void setR21_total_amount(BigDecimal r21_total_amount) {
		this.r21_total_amount = r21_total_amount;
	}
	public BigDecimal getR21_no_of_accounts_uae_abu() {
		return r21_no_of_accounts_uae_abu;
	}
	public void setR21_no_of_accounts_uae_abu(BigDecimal r21_no_of_accounts_uae_abu) {
		this.r21_no_of_accounts_uae_abu = r21_no_of_accounts_uae_abu;
	}
	public BigDecimal getR21_amount_uae_abu() {
		return r21_amount_uae_abu;
	}
	public void setR21_amount_uae_abu(BigDecimal r21_amount_uae_abu) {
		this.r21_amount_uae_abu = r21_amount_uae_abu;
	}
	public BigDecimal getR21_no_of_accounts_non_uae_abu() {
		return r21_no_of_accounts_non_uae_abu;
	}
	public void setR21_no_of_accounts_non_uae_abu(BigDecimal r21_no_of_accounts_non_uae_abu) {
		this.r21_no_of_accounts_non_uae_abu = r21_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR21_amount_non_uae_abu() {
		return r21_amount_non_uae_abu;
	}
	public void setR21_amount_non_uae_abu(BigDecimal r21_amount_non_uae_abu) {
		this.r21_amount_non_uae_abu = r21_amount_non_uae_abu;
	}
	public BigDecimal getR21_total_abu() {
		return r21_total_abu;
	}
	public void setR21_total_abu(BigDecimal r21_total_abu) {
		this.r21_total_abu = r21_total_abu;
	}
	public BigDecimal getR21_no_of_accounts_uae_dubai() {
		return r21_no_of_accounts_uae_dubai;
	}
	public void setR21_no_of_accounts_uae_dubai(BigDecimal r21_no_of_accounts_uae_dubai) {
		this.r21_no_of_accounts_uae_dubai = r21_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR21_amount_uae_dubai() {
		return r21_amount_uae_dubai;
	}
	public void setR21_amount_uae_dubai(BigDecimal r21_amount_uae_dubai) {
		this.r21_amount_uae_dubai = r21_amount_uae_dubai;
	}
	public BigDecimal getR21_no_of_accounts_non_uae_dubai() {
		return r21_no_of_accounts_non_uae_dubai;
	}
	public void setR21_no_of_accounts_non_uae_dubai(BigDecimal r21_no_of_accounts_non_uae_dubai) {
		this.r21_no_of_accounts_non_uae_dubai = r21_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR21_amount_non_uae_dubai() {
		return r21_amount_non_uae_dubai;
	}
	public void setR21_amount_non_uae_dubai(BigDecimal r21_amount_non_uae_dubai) {
		this.r21_amount_non_uae_dubai = r21_amount_non_uae_dubai;
	}
	public BigDecimal getR21_total_dubai() {
		return r21_total_dubai;
	}
	public void setR21_total_dubai(BigDecimal r21_total_dubai) {
		this.r21_total_dubai = r21_total_dubai;
	}
	public BigDecimal getR21_no_of_accounts_uae_sharjah() {
		return r21_no_of_accounts_uae_sharjah;
	}
	public void setR21_no_of_accounts_uae_sharjah(BigDecimal r21_no_of_accounts_uae_sharjah) {
		this.r21_no_of_accounts_uae_sharjah = r21_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR21_amount_uae_sharjah() {
		return r21_amount_uae_sharjah;
	}
	public void setR21_amount_uae_sharjah(BigDecimal r21_amount_uae_sharjah) {
		this.r21_amount_uae_sharjah = r21_amount_uae_sharjah;
	}
	public BigDecimal getR21_no_of_accounts_non_uae_sharjah() {
		return r21_no_of_accounts_non_uae_sharjah;
	}
	public void setR21_no_of_accounts_non_uae_sharjah(BigDecimal r21_no_of_accounts_non_uae_sharjah) {
		this.r21_no_of_accounts_non_uae_sharjah = r21_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR21_amount_non_uae_sharjah() {
		return r21_amount_non_uae_sharjah;
	}
	public void setR21_amount_non_uae_sharjah(BigDecimal r21_amount_non_uae_sharjah) {
		this.r21_amount_non_uae_sharjah = r21_amount_non_uae_sharjah;
	}
	public BigDecimal getR21_total_sharjah() {
		return r21_total_sharjah;
	}
	public void setR21_total_sharjah(BigDecimal r21_total_sharjah) {
		this.r21_total_sharjah = r21_total_sharjah;
	}
	public BigDecimal getR21_no_of_accounts_uae_ajman() {
		return r21_no_of_accounts_uae_ajman;
	}
	public void setR21_no_of_accounts_uae_ajman(BigDecimal r21_no_of_accounts_uae_ajman) {
		this.r21_no_of_accounts_uae_ajman = r21_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR21_amount_uae_ajman() {
		return r21_amount_uae_ajman;
	}
	public void setR21_amount_uae_ajman(BigDecimal r21_amount_uae_ajman) {
		this.r21_amount_uae_ajman = r21_amount_uae_ajman;
	}
	public BigDecimal getR21_no_of_accounts_non_uae_ajman() {
		return r21_no_of_accounts_non_uae_ajman;
	}
	public void setR21_no_of_accounts_non_uae_ajman(BigDecimal r21_no_of_accounts_non_uae_ajman) {
		this.r21_no_of_accounts_non_uae_ajman = r21_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR21_amount_non_uae_ajman() {
		return r21_amount_non_uae_ajman;
	}
	public void setR21_amount_non_uae_ajman(BigDecimal r21_amount_non_uae_ajman) {
		this.r21_amount_non_uae_ajman = r21_amount_non_uae_ajman;
	}
	public BigDecimal getR21_total_ajman() {
		return r21_total_ajman;
	}
	public void setR21_total_ajman(BigDecimal r21_total_ajman) {
		this.r21_total_ajman = r21_total_ajman;
	}
	public BigDecimal getR21_no_of_accounts_uae_ras() {
		return r21_no_of_accounts_uae_ras;
	}
	public void setR21_no_of_accounts_uae_ras(BigDecimal r21_no_of_accounts_uae_ras) {
		this.r21_no_of_accounts_uae_ras = r21_no_of_accounts_uae_ras;
	}
	public BigDecimal getR21_amount_uae_ras() {
		return r21_amount_uae_ras;
	}
	public void setR21_amount_uae_ras(BigDecimal r21_amount_uae_ras) {
		this.r21_amount_uae_ras = r21_amount_uae_ras;
	}
	public BigDecimal getR21_no_of_accounts_non_uae_ras() {
		return r21_no_of_accounts_non_uae_ras;
	}
	public void setR21_no_of_accounts_non_uae_ras(BigDecimal r21_no_of_accounts_non_uae_ras) {
		this.r21_no_of_accounts_non_uae_ras = r21_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR21_amount_non_uae_ras() {
		return r21_amount_non_uae_ras;
	}
	public void setR21_amount_non_uae_ras(BigDecimal r21_amount_non_uae_ras) {
		this.r21_amount_non_uae_ras = r21_amount_non_uae_ras;
	}
	public BigDecimal getR21_total_ras() {
		return r21_total_ras;
	}
	public void setR21_total_ras(BigDecimal r21_total_ras) {
		this.r21_total_ras = r21_total_ras;
	}
	public BigDecimal getR21_no_of_accounts_uae_umm() {
		return r21_no_of_accounts_uae_umm;
	}
	public void setR21_no_of_accounts_uae_umm(BigDecimal r21_no_of_accounts_uae_umm) {
		this.r21_no_of_accounts_uae_umm = r21_no_of_accounts_uae_umm;
	}
	public BigDecimal getR21_amount_uae_umm() {
		return r21_amount_uae_umm;
	}
	public void setR21_amount_uae_umm(BigDecimal r21_amount_uae_umm) {
		this.r21_amount_uae_umm = r21_amount_uae_umm;
	}
	public BigDecimal getR21_no_of_accounts_non_uae_umm() {
		return r21_no_of_accounts_non_uae_umm;
	}
	public void setR21_no_of_accounts_non_uae_umm(BigDecimal r21_no_of_accounts_non_uae_umm) {
		this.r21_no_of_accounts_non_uae_umm = r21_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR21_amount_non_uae_umm() {
		return r21_amount_non_uae_umm;
	}
	public void setR21_amount_non_uae_umm(BigDecimal r21_amount_non_uae_umm) {
		this.r21_amount_non_uae_umm = r21_amount_non_uae_umm;
	}
	public BigDecimal getR21_total_umm() {
		return r21_total_umm;
	}
	public void setR21_total_umm(BigDecimal r21_total_umm) {
		this.r21_total_umm = r21_total_umm;
	}
	public BigDecimal getR21_no_of_accounts_uae_fujairah() {
		return r21_no_of_accounts_uae_fujairah;
	}
	public void setR21_no_of_accounts_uae_fujairah(BigDecimal r21_no_of_accounts_uae_fujairah) {
		this.r21_no_of_accounts_uae_fujairah = r21_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR21_amount_uae_fujairah() {
		return r21_amount_uae_fujairah;
	}
	public void setR21_amount_uae_fujairah(BigDecimal r21_amount_uae_fujairah) {
		this.r21_amount_uae_fujairah = r21_amount_uae_fujairah;
	}
	public BigDecimal getR21_no_of_accounts_non_uae_fujairah() {
		return r21_no_of_accounts_non_uae_fujairah;
	}
	public void setR21_no_of_accounts_non_uae_fujairah(BigDecimal r21_no_of_accounts_non_uae_fujairah) {
		this.r21_no_of_accounts_non_uae_fujairah = r21_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR21_amount_non_uae_fujairah() {
		return r21_amount_non_uae_fujairah;
	}
	public void setR21_amount_non_uae_fujairah(BigDecimal r21_amount_non_uae_fujairah) {
		this.r21_amount_non_uae_fujairah = r21_amount_non_uae_fujairah;
	}
	public BigDecimal getR21_total_fujairah() {
		return r21_total_fujairah;
	}
	public void setR21_total_fujairah(BigDecimal r21_total_fujairah) {
		this.r21_total_fujairah = r21_total_fujairah;
	}
	public String getR22_product() {
		return r22_product;
	}
	public void setR22_product(String r22_product) {
		this.r22_product = r22_product;
	}
	public BigDecimal getR22_no_of_accounts_uae() {
		return r22_no_of_accounts_uae;
	}
	public void setR22_no_of_accounts_uae(BigDecimal r22_no_of_accounts_uae) {
		this.r22_no_of_accounts_uae = r22_no_of_accounts_uae;
	}
	public BigDecimal getR22_amount_uae() {
		return r22_amount_uae;
	}
	public void setR22_amount_uae(BigDecimal r22_amount_uae) {
		this.r22_amount_uae = r22_amount_uae;
	}
	public BigDecimal getR22_no_of_accounts_resident() {
		return r22_no_of_accounts_resident;
	}
	public void setR22_no_of_accounts_resident(BigDecimal r22_no_of_accounts_resident) {
		this.r22_no_of_accounts_resident = r22_no_of_accounts_resident;
	}
	public BigDecimal getR22_amount_resident() {
		return r22_amount_resident;
	}
	public void setR22_amount_resident(BigDecimal r22_amount_resident) {
		this.r22_amount_resident = r22_amount_resident;
	}
	public BigDecimal getR22_no_of_accounts_non_resident() {
		return r22_no_of_accounts_non_resident;
	}
	public void setR22_no_of_accounts_non_resident(BigDecimal r22_no_of_accounts_non_resident) {
		this.r22_no_of_accounts_non_resident = r22_no_of_accounts_non_resident;
	}
	public BigDecimal getR22_amount_non_resident() {
		return r22_amount_non_resident;
	}
	public void setR22_amount_non_resident(BigDecimal r22_amount_non_resident) {
		this.r22_amount_non_resident = r22_amount_non_resident;
	}
	public BigDecimal getR22_total_account() {
		return r22_total_account;
	}
	public void setR22_total_account(BigDecimal r22_total_account) {
		this.r22_total_account = r22_total_account;
	}
	public BigDecimal getR22_total_amount() {
		return r22_total_amount;
	}
	public void setR22_total_amount(BigDecimal r22_total_amount) {
		this.r22_total_amount = r22_total_amount;
	}
	public BigDecimal getR22_no_of_accounts_uae_abu() {
		return r22_no_of_accounts_uae_abu;
	}
	public void setR22_no_of_accounts_uae_abu(BigDecimal r22_no_of_accounts_uae_abu) {
		this.r22_no_of_accounts_uae_abu = r22_no_of_accounts_uae_abu;
	}
	public BigDecimal getR22_amount_uae_abu() {
		return r22_amount_uae_abu;
	}
	public void setR22_amount_uae_abu(BigDecimal r22_amount_uae_abu) {
		this.r22_amount_uae_abu = r22_amount_uae_abu;
	}
	public BigDecimal getR22_no_of_accounts_non_uae_abu() {
		return r22_no_of_accounts_non_uae_abu;
	}
	public void setR22_no_of_accounts_non_uae_abu(BigDecimal r22_no_of_accounts_non_uae_abu) {
		this.r22_no_of_accounts_non_uae_abu = r22_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR22_amount_non_uae_abu() {
		return r22_amount_non_uae_abu;
	}
	public void setR22_amount_non_uae_abu(BigDecimal r22_amount_non_uae_abu) {
		this.r22_amount_non_uae_abu = r22_amount_non_uae_abu;
	}
	public BigDecimal getR22_total_abu() {
		return r22_total_abu;
	}
	public void setR22_total_abu(BigDecimal r22_total_abu) {
		this.r22_total_abu = r22_total_abu;
	}
	public BigDecimal getR22_no_of_accounts_uae_dubai() {
		return r22_no_of_accounts_uae_dubai;
	}
	public void setR22_no_of_accounts_uae_dubai(BigDecimal r22_no_of_accounts_uae_dubai) {
		this.r22_no_of_accounts_uae_dubai = r22_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR22_amount_uae_dubai() {
		return r22_amount_uae_dubai;
	}
	public void setR22_amount_uae_dubai(BigDecimal r22_amount_uae_dubai) {
		this.r22_amount_uae_dubai = r22_amount_uae_dubai;
	}
	public BigDecimal getR22_no_of_accounts_non_uae_dubai() {
		return r22_no_of_accounts_non_uae_dubai;
	}
	public void setR22_no_of_accounts_non_uae_dubai(BigDecimal r22_no_of_accounts_non_uae_dubai) {
		this.r22_no_of_accounts_non_uae_dubai = r22_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR22_amount_non_uae_dubai() {
		return r22_amount_non_uae_dubai;
	}
	public void setR22_amount_non_uae_dubai(BigDecimal r22_amount_non_uae_dubai) {
		this.r22_amount_non_uae_dubai = r22_amount_non_uae_dubai;
	}
	public BigDecimal getR22_total_dubai() {
		return r22_total_dubai;
	}
	public void setR22_total_dubai(BigDecimal r22_total_dubai) {
		this.r22_total_dubai = r22_total_dubai;
	}
	public BigDecimal getR22_no_of_accounts_uae_sharjah() {
		return r22_no_of_accounts_uae_sharjah;
	}
	public void setR22_no_of_accounts_uae_sharjah(BigDecimal r22_no_of_accounts_uae_sharjah) {
		this.r22_no_of_accounts_uae_sharjah = r22_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR22_amount_uae_sharjah() {
		return r22_amount_uae_sharjah;
	}
	public void setR22_amount_uae_sharjah(BigDecimal r22_amount_uae_sharjah) {
		this.r22_amount_uae_sharjah = r22_amount_uae_sharjah;
	}
	public BigDecimal getR22_no_of_accounts_non_uae_sharjah() {
		return r22_no_of_accounts_non_uae_sharjah;
	}
	public void setR22_no_of_accounts_non_uae_sharjah(BigDecimal r22_no_of_accounts_non_uae_sharjah) {
		this.r22_no_of_accounts_non_uae_sharjah = r22_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR22_amount_non_uae_sharjah() {
		return r22_amount_non_uae_sharjah;
	}
	public void setR22_amount_non_uae_sharjah(BigDecimal r22_amount_non_uae_sharjah) {
		this.r22_amount_non_uae_sharjah = r22_amount_non_uae_sharjah;
	}
	public BigDecimal getR22_total_sharjah() {
		return r22_total_sharjah;
	}
	public void setR22_total_sharjah(BigDecimal r22_total_sharjah) {
		this.r22_total_sharjah = r22_total_sharjah;
	}
	public BigDecimal getR22_no_of_accounts_uae_ajman() {
		return r22_no_of_accounts_uae_ajman;
	}
	public void setR22_no_of_accounts_uae_ajman(BigDecimal r22_no_of_accounts_uae_ajman) {
		this.r22_no_of_accounts_uae_ajman = r22_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR22_amount_uae_ajman() {
		return r22_amount_uae_ajman;
	}
	public void setR22_amount_uae_ajman(BigDecimal r22_amount_uae_ajman) {
		this.r22_amount_uae_ajman = r22_amount_uae_ajman;
	}
	public BigDecimal getR22_no_of_accounts_non_uae_ajman() {
		return r22_no_of_accounts_non_uae_ajman;
	}
	public void setR22_no_of_accounts_non_uae_ajman(BigDecimal r22_no_of_accounts_non_uae_ajman) {
		this.r22_no_of_accounts_non_uae_ajman = r22_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR22_amount_non_uae_ajman() {
		return r22_amount_non_uae_ajman;
	}
	public void setR22_amount_non_uae_ajman(BigDecimal r22_amount_non_uae_ajman) {
		this.r22_amount_non_uae_ajman = r22_amount_non_uae_ajman;
	}
	public BigDecimal getR22_total_ajman() {
		return r22_total_ajman;
	}
	public void setR22_total_ajman(BigDecimal r22_total_ajman) {
		this.r22_total_ajman = r22_total_ajman;
	}
	public BigDecimal getR22_no_of_accounts_uae_ras() {
		return r22_no_of_accounts_uae_ras;
	}
	public void setR22_no_of_accounts_uae_ras(BigDecimal r22_no_of_accounts_uae_ras) {
		this.r22_no_of_accounts_uae_ras = r22_no_of_accounts_uae_ras;
	}
	public BigDecimal getR22_amount_uae_ras() {
		return r22_amount_uae_ras;
	}
	public void setR22_amount_uae_ras(BigDecimal r22_amount_uae_ras) {
		this.r22_amount_uae_ras = r22_amount_uae_ras;
	}
	public BigDecimal getR22_no_of_accounts_non_uae_ras() {
		return r22_no_of_accounts_non_uae_ras;
	}
	public void setR22_no_of_accounts_non_uae_ras(BigDecimal r22_no_of_accounts_non_uae_ras) {
		this.r22_no_of_accounts_non_uae_ras = r22_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR22_amount_non_uae_ras() {
		return r22_amount_non_uae_ras;
	}
	public void setR22_amount_non_uae_ras(BigDecimal r22_amount_non_uae_ras) {
		this.r22_amount_non_uae_ras = r22_amount_non_uae_ras;
	}
	public BigDecimal getR22_total_ras() {
		return r22_total_ras;
	}
	public void setR22_total_ras(BigDecimal r22_total_ras) {
		this.r22_total_ras = r22_total_ras;
	}
	public BigDecimal getR22_no_of_accounts_uae_umm() {
		return r22_no_of_accounts_uae_umm;
	}
	public void setR22_no_of_accounts_uae_umm(BigDecimal r22_no_of_accounts_uae_umm) {
		this.r22_no_of_accounts_uae_umm = r22_no_of_accounts_uae_umm;
	}
	public BigDecimal getR22_amount_uae_umm() {
		return r22_amount_uae_umm;
	}
	public void setR22_amount_uae_umm(BigDecimal r22_amount_uae_umm) {
		this.r22_amount_uae_umm = r22_amount_uae_umm;
	}
	public BigDecimal getR22_no_of_accounts_non_uae_umm() {
		return r22_no_of_accounts_non_uae_umm;
	}
	public void setR22_no_of_accounts_non_uae_umm(BigDecimal r22_no_of_accounts_non_uae_umm) {
		this.r22_no_of_accounts_non_uae_umm = r22_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR22_amount_non_uae_umm() {
		return r22_amount_non_uae_umm;
	}
	public void setR22_amount_non_uae_umm(BigDecimal r22_amount_non_uae_umm) {
		this.r22_amount_non_uae_umm = r22_amount_non_uae_umm;
	}
	public BigDecimal getR22_total_umm() {
		return r22_total_umm;
	}
	public void setR22_total_umm(BigDecimal r22_total_umm) {
		this.r22_total_umm = r22_total_umm;
	}
	public BigDecimal getR22_no_of_accounts_uae_fujairah() {
		return r22_no_of_accounts_uae_fujairah;
	}
	public void setR22_no_of_accounts_uae_fujairah(BigDecimal r22_no_of_accounts_uae_fujairah) {
		this.r22_no_of_accounts_uae_fujairah = r22_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR22_amount_uae_fujairah() {
		return r22_amount_uae_fujairah;
	}
	public void setR22_amount_uae_fujairah(BigDecimal r22_amount_uae_fujairah) {
		this.r22_amount_uae_fujairah = r22_amount_uae_fujairah;
	}
	public BigDecimal getR22_no_of_accounts_non_uae_fujairah() {
		return r22_no_of_accounts_non_uae_fujairah;
	}
	public void setR22_no_of_accounts_non_uae_fujairah(BigDecimal r22_no_of_accounts_non_uae_fujairah) {
		this.r22_no_of_accounts_non_uae_fujairah = r22_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR22_amount_non_uae_fujairah() {
		return r22_amount_non_uae_fujairah;
	}
	public void setR22_amount_non_uae_fujairah(BigDecimal r22_amount_non_uae_fujairah) {
		this.r22_amount_non_uae_fujairah = r22_amount_non_uae_fujairah;
	}
	public BigDecimal getR22_total_fujairah() {
		return r22_total_fujairah;
	}
	public void setR22_total_fujairah(BigDecimal r22_total_fujairah) {
		this.r22_total_fujairah = r22_total_fujairah;
	}
	public String getR23_product() {
		return r23_product;
	}
	public void setR23_product(String r23_product) {
		this.r23_product = r23_product;
	}
	public BigDecimal getR23_no_of_accounts_uae() {
		return r23_no_of_accounts_uae;
	}
	public void setR23_no_of_accounts_uae(BigDecimal r23_no_of_accounts_uae) {
		this.r23_no_of_accounts_uae = r23_no_of_accounts_uae;
	}
	public BigDecimal getR23_amount_uae() {
		return r23_amount_uae;
	}
	public void setR23_amount_uae(BigDecimal r23_amount_uae) {
		this.r23_amount_uae = r23_amount_uae;
	}
	public BigDecimal getR23_no_of_accounts_resident() {
		return r23_no_of_accounts_resident;
	}
	public void setR23_no_of_accounts_resident(BigDecimal r23_no_of_accounts_resident) {
		this.r23_no_of_accounts_resident = r23_no_of_accounts_resident;
	}
	public BigDecimal getR23_amount_resident() {
		return r23_amount_resident;
	}
	public void setR23_amount_resident(BigDecimal r23_amount_resident) {
		this.r23_amount_resident = r23_amount_resident;
	}
	public BigDecimal getR23_no_of_accounts_non_resident() {
		return r23_no_of_accounts_non_resident;
	}
	public void setR23_no_of_accounts_non_resident(BigDecimal r23_no_of_accounts_non_resident) {
		this.r23_no_of_accounts_non_resident = r23_no_of_accounts_non_resident;
	}
	public BigDecimal getR23_amount_non_resident() {
		return r23_amount_non_resident;
	}
	public void setR23_amount_non_resident(BigDecimal r23_amount_non_resident) {
		this.r23_amount_non_resident = r23_amount_non_resident;
	}
	public BigDecimal getR23_total_account() {
		return r23_total_account;
	}
	public void setR23_total_account(BigDecimal r23_total_account) {
		this.r23_total_account = r23_total_account;
	}
	public BigDecimal getR23_total_amount() {
		return r23_total_amount;
	}
	public void setR23_total_amount(BigDecimal r23_total_amount) {
		this.r23_total_amount = r23_total_amount;
	}
	public BigDecimal getR23_no_of_accounts_uae_abu() {
		return r23_no_of_accounts_uae_abu;
	}
	public void setR23_no_of_accounts_uae_abu(BigDecimal r23_no_of_accounts_uae_abu) {
		this.r23_no_of_accounts_uae_abu = r23_no_of_accounts_uae_abu;
	}
	public BigDecimal getR23_amount_uae_abu() {
		return r23_amount_uae_abu;
	}
	public void setR23_amount_uae_abu(BigDecimal r23_amount_uae_abu) {
		this.r23_amount_uae_abu = r23_amount_uae_abu;
	}
	public BigDecimal getR23_no_of_accounts_non_uae_abu() {
		return r23_no_of_accounts_non_uae_abu;
	}
	public void setR23_no_of_accounts_non_uae_abu(BigDecimal r23_no_of_accounts_non_uae_abu) {
		this.r23_no_of_accounts_non_uae_abu = r23_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR23_amount_non_uae_abu() {
		return r23_amount_non_uae_abu;
	}
	public void setR23_amount_non_uae_abu(BigDecimal r23_amount_non_uae_abu) {
		this.r23_amount_non_uae_abu = r23_amount_non_uae_abu;
	}
	public BigDecimal getR23_total_abu() {
		return r23_total_abu;
	}
	public void setR23_total_abu(BigDecimal r23_total_abu) {
		this.r23_total_abu = r23_total_abu;
	}
	public BigDecimal getR23_no_of_accounts_uae_dubai() {
		return r23_no_of_accounts_uae_dubai;
	}
	public void setR23_no_of_accounts_uae_dubai(BigDecimal r23_no_of_accounts_uae_dubai) {
		this.r23_no_of_accounts_uae_dubai = r23_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR23_amount_uae_dubai() {
		return r23_amount_uae_dubai;
	}
	public void setR23_amount_uae_dubai(BigDecimal r23_amount_uae_dubai) {
		this.r23_amount_uae_dubai = r23_amount_uae_dubai;
	}
	public BigDecimal getR23_no_of_accounts_non_uae_dubai() {
		return r23_no_of_accounts_non_uae_dubai;
	}
	public void setR23_no_of_accounts_non_uae_dubai(BigDecimal r23_no_of_accounts_non_uae_dubai) {
		this.r23_no_of_accounts_non_uae_dubai = r23_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR23_amount_non_uae_dubai() {
		return r23_amount_non_uae_dubai;
	}
	public void setR23_amount_non_uae_dubai(BigDecimal r23_amount_non_uae_dubai) {
		this.r23_amount_non_uae_dubai = r23_amount_non_uae_dubai;
	}
	public BigDecimal getR23_total_dubai() {
		return r23_total_dubai;
	}
	public void setR23_total_dubai(BigDecimal r23_total_dubai) {
		this.r23_total_dubai = r23_total_dubai;
	}
	public BigDecimal getR23_no_of_accounts_uae_sharjah() {
		return r23_no_of_accounts_uae_sharjah;
	}
	public void setR23_no_of_accounts_uae_sharjah(BigDecimal r23_no_of_accounts_uae_sharjah) {
		this.r23_no_of_accounts_uae_sharjah = r23_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR23_amount_uae_sharjah() {
		return r23_amount_uae_sharjah;
	}
	public void setR23_amount_uae_sharjah(BigDecimal r23_amount_uae_sharjah) {
		this.r23_amount_uae_sharjah = r23_amount_uae_sharjah;
	}
	public BigDecimal getR23_no_of_accounts_non_uae_sharjah() {
		return r23_no_of_accounts_non_uae_sharjah;
	}
	public void setR23_no_of_accounts_non_uae_sharjah(BigDecimal r23_no_of_accounts_non_uae_sharjah) {
		this.r23_no_of_accounts_non_uae_sharjah = r23_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR23_amount_non_uae_sharjah() {
		return r23_amount_non_uae_sharjah;
	}
	public void setR23_amount_non_uae_sharjah(BigDecimal r23_amount_non_uae_sharjah) {
		this.r23_amount_non_uae_sharjah = r23_amount_non_uae_sharjah;
	}
	public BigDecimal getR23_total_sharjah() {
		return r23_total_sharjah;
	}
	public void setR23_total_sharjah(BigDecimal r23_total_sharjah) {
		this.r23_total_sharjah = r23_total_sharjah;
	}
	public BigDecimal getR23_no_of_accounts_uae_ajman() {
		return r23_no_of_accounts_uae_ajman;
	}
	public void setR23_no_of_accounts_uae_ajman(BigDecimal r23_no_of_accounts_uae_ajman) {
		this.r23_no_of_accounts_uae_ajman = r23_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR23_amount_uae_ajman() {
		return r23_amount_uae_ajman;
	}
	public void setR23_amount_uae_ajman(BigDecimal r23_amount_uae_ajman) {
		this.r23_amount_uae_ajman = r23_amount_uae_ajman;
	}
	public BigDecimal getR23_no_of_accounts_non_uae_ajman() {
		return r23_no_of_accounts_non_uae_ajman;
	}
	public void setR23_no_of_accounts_non_uae_ajman(BigDecimal r23_no_of_accounts_non_uae_ajman) {
		this.r23_no_of_accounts_non_uae_ajman = r23_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR23_amount_non_uae_ajman() {
		return r23_amount_non_uae_ajman;
	}
	public void setR23_amount_non_uae_ajman(BigDecimal r23_amount_non_uae_ajman) {
		this.r23_amount_non_uae_ajman = r23_amount_non_uae_ajman;
	}
	public BigDecimal getR23_total_ajman() {
		return r23_total_ajman;
	}
	public void setR23_total_ajman(BigDecimal r23_total_ajman) {
		this.r23_total_ajman = r23_total_ajman;
	}
	public BigDecimal getR23_no_of_accounts_uae_ras() {
		return r23_no_of_accounts_uae_ras;
	}
	public void setR23_no_of_accounts_uae_ras(BigDecimal r23_no_of_accounts_uae_ras) {
		this.r23_no_of_accounts_uae_ras = r23_no_of_accounts_uae_ras;
	}
	public BigDecimal getR23_amount_uae_ras() {
		return r23_amount_uae_ras;
	}
	public void setR23_amount_uae_ras(BigDecimal r23_amount_uae_ras) {
		this.r23_amount_uae_ras = r23_amount_uae_ras;
	}
	public BigDecimal getR23_no_of_accounts_non_uae_ras() {
		return r23_no_of_accounts_non_uae_ras;
	}
	public void setR23_no_of_accounts_non_uae_ras(BigDecimal r23_no_of_accounts_non_uae_ras) {
		this.r23_no_of_accounts_non_uae_ras = r23_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR23_amount_non_uae_ras() {
		return r23_amount_non_uae_ras;
	}
	public void setR23_amount_non_uae_ras(BigDecimal r23_amount_non_uae_ras) {
		this.r23_amount_non_uae_ras = r23_amount_non_uae_ras;
	}
	public BigDecimal getR23_total_ras() {
		return r23_total_ras;
	}
	public void setR23_total_ras(BigDecimal r23_total_ras) {
		this.r23_total_ras = r23_total_ras;
	}
	public BigDecimal getR23_no_of_accounts_uae_umm() {
		return r23_no_of_accounts_uae_umm;
	}
	public void setR23_no_of_accounts_uae_umm(BigDecimal r23_no_of_accounts_uae_umm) {
		this.r23_no_of_accounts_uae_umm = r23_no_of_accounts_uae_umm;
	}
	public BigDecimal getR23_amount_uae_umm() {
		return r23_amount_uae_umm;
	}
	public void setR23_amount_uae_umm(BigDecimal r23_amount_uae_umm) {
		this.r23_amount_uae_umm = r23_amount_uae_umm;
	}
	public BigDecimal getR23_no_of_accounts_non_uae_umm() {
		return r23_no_of_accounts_non_uae_umm;
	}
	public void setR23_no_of_accounts_non_uae_umm(BigDecimal r23_no_of_accounts_non_uae_umm) {
		this.r23_no_of_accounts_non_uae_umm = r23_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR23_amount_non_uae_umm() {
		return r23_amount_non_uae_umm;
	}
	public void setR23_amount_non_uae_umm(BigDecimal r23_amount_non_uae_umm) {
		this.r23_amount_non_uae_umm = r23_amount_non_uae_umm;
	}
	public BigDecimal getR23_total_umm() {
		return r23_total_umm;
	}
	public void setR23_total_umm(BigDecimal r23_total_umm) {
		this.r23_total_umm = r23_total_umm;
	}
	public BigDecimal getR23_no_of_accounts_uae_fujairah() {
		return r23_no_of_accounts_uae_fujairah;
	}
	public void setR23_no_of_accounts_uae_fujairah(BigDecimal r23_no_of_accounts_uae_fujairah) {
		this.r23_no_of_accounts_uae_fujairah = r23_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR23_amount_uae_fujairah() {
		return r23_amount_uae_fujairah;
	}
	public void setR23_amount_uae_fujairah(BigDecimal r23_amount_uae_fujairah) {
		this.r23_amount_uae_fujairah = r23_amount_uae_fujairah;
	}
	public BigDecimal getR23_no_of_accounts_non_uae_fujairah() {
		return r23_no_of_accounts_non_uae_fujairah;
	}
	public void setR23_no_of_accounts_non_uae_fujairah(BigDecimal r23_no_of_accounts_non_uae_fujairah) {
		this.r23_no_of_accounts_non_uae_fujairah = r23_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR23_amount_non_uae_fujairah() {
		return r23_amount_non_uae_fujairah;
	}
	public void setR23_amount_non_uae_fujairah(BigDecimal r23_amount_non_uae_fujairah) {
		this.r23_amount_non_uae_fujairah = r23_amount_non_uae_fujairah;
	}
	public BigDecimal getR23_total_fujairah() {
		return r23_total_fujairah;
	}
	public void setR23_total_fujairah(BigDecimal r23_total_fujairah) {
		this.r23_total_fujairah = r23_total_fujairah;
	}
	public String getR24_product() {
		return r24_product;
	}
	public void setR24_product(String r24_product) {
		this.r24_product = r24_product;
	}
	public BigDecimal getR24_no_of_accounts_uae() {
		return r24_no_of_accounts_uae;
	}
	public void setR24_no_of_accounts_uae(BigDecimal r24_no_of_accounts_uae) {
		this.r24_no_of_accounts_uae = r24_no_of_accounts_uae;
	}
	public BigDecimal getR24_amount_uae() {
		return r24_amount_uae;
	}
	public void setR24_amount_uae(BigDecimal r24_amount_uae) {
		this.r24_amount_uae = r24_amount_uae;
	}
	public BigDecimal getR24_no_of_accounts_resident() {
		return r24_no_of_accounts_resident;
	}
	public void setR24_no_of_accounts_resident(BigDecimal r24_no_of_accounts_resident) {
		this.r24_no_of_accounts_resident = r24_no_of_accounts_resident;
	}
	public BigDecimal getR24_amount_resident() {
		return r24_amount_resident;
	}
	public void setR24_amount_resident(BigDecimal r24_amount_resident) {
		this.r24_amount_resident = r24_amount_resident;
	}
	public BigDecimal getR24_no_of_accounts_non_resident() {
		return r24_no_of_accounts_non_resident;
	}
	public void setR24_no_of_accounts_non_resident(BigDecimal r24_no_of_accounts_non_resident) {
		this.r24_no_of_accounts_non_resident = r24_no_of_accounts_non_resident;
	}
	public BigDecimal getR24_amount_non_resident() {
		return r24_amount_non_resident;
	}
	public void setR24_amount_non_resident(BigDecimal r24_amount_non_resident) {
		this.r24_amount_non_resident = r24_amount_non_resident;
	}
	public BigDecimal getR24_total_account() {
		return r24_total_account;
	}
	public void setR24_total_account(BigDecimal r24_total_account) {
		this.r24_total_account = r24_total_account;
	}
	public BigDecimal getR24_total_amount() {
		return r24_total_amount;
	}
	public void setR24_total_amount(BigDecimal r24_total_amount) {
		this.r24_total_amount = r24_total_amount;
	}
	public BigDecimal getR24_no_of_accounts_uae_abu() {
		return r24_no_of_accounts_uae_abu;
	}
	public void setR24_no_of_accounts_uae_abu(BigDecimal r24_no_of_accounts_uae_abu) {
		this.r24_no_of_accounts_uae_abu = r24_no_of_accounts_uae_abu;
	}
	public BigDecimal getR24_amount_uae_abu() {
		return r24_amount_uae_abu;
	}
	public void setR24_amount_uae_abu(BigDecimal r24_amount_uae_abu) {
		this.r24_amount_uae_abu = r24_amount_uae_abu;
	}
	public BigDecimal getR24_no_of_accounts_non_uae_abu() {
		return r24_no_of_accounts_non_uae_abu;
	}
	public void setR24_no_of_accounts_non_uae_abu(BigDecimal r24_no_of_accounts_non_uae_abu) {
		this.r24_no_of_accounts_non_uae_abu = r24_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR24_amount_non_uae_abu() {
		return r24_amount_non_uae_abu;
	}
	public void setR24_amount_non_uae_abu(BigDecimal r24_amount_non_uae_abu) {
		this.r24_amount_non_uae_abu = r24_amount_non_uae_abu;
	}
	public BigDecimal getR24_total_abu() {
		return r24_total_abu;
	}
	public void setR24_total_abu(BigDecimal r24_total_abu) {
		this.r24_total_abu = r24_total_abu;
	}
	public BigDecimal getR24_no_of_accounts_uae_dubai() {
		return r24_no_of_accounts_uae_dubai;
	}
	public void setR24_no_of_accounts_uae_dubai(BigDecimal r24_no_of_accounts_uae_dubai) {
		this.r24_no_of_accounts_uae_dubai = r24_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR24_amount_uae_dubai() {
		return r24_amount_uae_dubai;
	}
	public void setR24_amount_uae_dubai(BigDecimal r24_amount_uae_dubai) {
		this.r24_amount_uae_dubai = r24_amount_uae_dubai;
	}
	public BigDecimal getR24_no_of_accounts_non_uae_dubai() {
		return r24_no_of_accounts_non_uae_dubai;
	}
	public void setR24_no_of_accounts_non_uae_dubai(BigDecimal r24_no_of_accounts_non_uae_dubai) {
		this.r24_no_of_accounts_non_uae_dubai = r24_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR24_amount_non_uae_dubai() {
		return r24_amount_non_uae_dubai;
	}
	public void setR24_amount_non_uae_dubai(BigDecimal r24_amount_non_uae_dubai) {
		this.r24_amount_non_uae_dubai = r24_amount_non_uae_dubai;
	}
	public BigDecimal getR24_total_dubai() {
		return r24_total_dubai;
	}
	public void setR24_total_dubai(BigDecimal r24_total_dubai) {
		this.r24_total_dubai = r24_total_dubai;
	}
	public BigDecimal getR24_no_of_accounts_uae_sharjah() {
		return r24_no_of_accounts_uae_sharjah;
	}
	public void setR24_no_of_accounts_uae_sharjah(BigDecimal r24_no_of_accounts_uae_sharjah) {
		this.r24_no_of_accounts_uae_sharjah = r24_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR24_amount_uae_sharjah() {
		return r24_amount_uae_sharjah;
	}
	public void setR24_amount_uae_sharjah(BigDecimal r24_amount_uae_sharjah) {
		this.r24_amount_uae_sharjah = r24_amount_uae_sharjah;
	}
	public BigDecimal getR24_no_of_accounts_non_uae_sharjah() {
		return r24_no_of_accounts_non_uae_sharjah;
	}
	public void setR24_no_of_accounts_non_uae_sharjah(BigDecimal r24_no_of_accounts_non_uae_sharjah) {
		this.r24_no_of_accounts_non_uae_sharjah = r24_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR24_amount_non_uae_sharjah() {
		return r24_amount_non_uae_sharjah;
	}
	public void setR24_amount_non_uae_sharjah(BigDecimal r24_amount_non_uae_sharjah) {
		this.r24_amount_non_uae_sharjah = r24_amount_non_uae_sharjah;
	}
	public BigDecimal getR24_total_sharjah() {
		return r24_total_sharjah;
	}
	public void setR24_total_sharjah(BigDecimal r24_total_sharjah) {
		this.r24_total_sharjah = r24_total_sharjah;
	}
	public BigDecimal getR24_no_of_accounts_uae_ajman() {
		return r24_no_of_accounts_uae_ajman;
	}
	public void setR24_no_of_accounts_uae_ajman(BigDecimal r24_no_of_accounts_uae_ajman) {
		this.r24_no_of_accounts_uae_ajman = r24_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR24_amount_uae_ajman() {
		return r24_amount_uae_ajman;
	}
	public void setR24_amount_uae_ajman(BigDecimal r24_amount_uae_ajman) {
		this.r24_amount_uae_ajman = r24_amount_uae_ajman;
	}
	public BigDecimal getR24_no_of_accounts_non_uae_ajman() {
		return r24_no_of_accounts_non_uae_ajman;
	}
	public void setR24_no_of_accounts_non_uae_ajman(BigDecimal r24_no_of_accounts_non_uae_ajman) {
		this.r24_no_of_accounts_non_uae_ajman = r24_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR24_amount_non_uae_ajman() {
		return r24_amount_non_uae_ajman;
	}
	public void setR24_amount_non_uae_ajman(BigDecimal r24_amount_non_uae_ajman) {
		this.r24_amount_non_uae_ajman = r24_amount_non_uae_ajman;
	}
	public BigDecimal getR24_total_ajman() {
		return r24_total_ajman;
	}
	public void setR24_total_ajman(BigDecimal r24_total_ajman) {
		this.r24_total_ajman = r24_total_ajman;
	}
	public BigDecimal getR24_no_of_accounts_uae_ras() {
		return r24_no_of_accounts_uae_ras;
	}
	public void setR24_no_of_accounts_uae_ras(BigDecimal r24_no_of_accounts_uae_ras) {
		this.r24_no_of_accounts_uae_ras = r24_no_of_accounts_uae_ras;
	}
	public BigDecimal getR24_amount_uae_ras() {
		return r24_amount_uae_ras;
	}
	public void setR24_amount_uae_ras(BigDecimal r24_amount_uae_ras) {
		this.r24_amount_uae_ras = r24_amount_uae_ras;
	}
	public BigDecimal getR24_no_of_accounts_non_uae_ras() {
		return r24_no_of_accounts_non_uae_ras;
	}
	public void setR24_no_of_accounts_non_uae_ras(BigDecimal r24_no_of_accounts_non_uae_ras) {
		this.r24_no_of_accounts_non_uae_ras = r24_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR24_amount_non_uae_ras() {
		return r24_amount_non_uae_ras;
	}
	public void setR24_amount_non_uae_ras(BigDecimal r24_amount_non_uae_ras) {
		this.r24_amount_non_uae_ras = r24_amount_non_uae_ras;
	}
	public BigDecimal getR24_total_ras() {
		return r24_total_ras;
	}
	public void setR24_total_ras(BigDecimal r24_total_ras) {
		this.r24_total_ras = r24_total_ras;
	}
	public BigDecimal getR24_no_of_accounts_uae_umm() {
		return r24_no_of_accounts_uae_umm;
	}
	public void setR24_no_of_accounts_uae_umm(BigDecimal r24_no_of_accounts_uae_umm) {
		this.r24_no_of_accounts_uae_umm = r24_no_of_accounts_uae_umm;
	}
	public BigDecimal getR24_amount_uae_umm() {
		return r24_amount_uae_umm;
	}
	public void setR24_amount_uae_umm(BigDecimal r24_amount_uae_umm) {
		this.r24_amount_uae_umm = r24_amount_uae_umm;
	}
	public BigDecimal getR24_no_of_accounts_non_uae_umm() {
		return r24_no_of_accounts_non_uae_umm;
	}
	public void setR24_no_of_accounts_non_uae_umm(BigDecimal r24_no_of_accounts_non_uae_umm) {
		this.r24_no_of_accounts_non_uae_umm = r24_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR24_amount_non_uae_umm() {
		return r24_amount_non_uae_umm;
	}
	public void setR24_amount_non_uae_umm(BigDecimal r24_amount_non_uae_umm) {
		this.r24_amount_non_uae_umm = r24_amount_non_uae_umm;
	}
	public BigDecimal getR24_total_umm() {
		return r24_total_umm;
	}
	public void setR24_total_umm(BigDecimal r24_total_umm) {
		this.r24_total_umm = r24_total_umm;
	}
	public BigDecimal getR24_no_of_accounts_uae_fujairah() {
		return r24_no_of_accounts_uae_fujairah;
	}
	public void setR24_no_of_accounts_uae_fujairah(BigDecimal r24_no_of_accounts_uae_fujairah) {
		this.r24_no_of_accounts_uae_fujairah = r24_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR24_amount_uae_fujairah() {
		return r24_amount_uae_fujairah;
	}
	public void setR24_amount_uae_fujairah(BigDecimal r24_amount_uae_fujairah) {
		this.r24_amount_uae_fujairah = r24_amount_uae_fujairah;
	}
	public BigDecimal getR24_no_of_accounts_non_uae_fujairah() {
		return r24_no_of_accounts_non_uae_fujairah;
	}
	public void setR24_no_of_accounts_non_uae_fujairah(BigDecimal r24_no_of_accounts_non_uae_fujairah) {
		this.r24_no_of_accounts_non_uae_fujairah = r24_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR24_amount_non_uae_fujairah() {
		return r24_amount_non_uae_fujairah;
	}
	public void setR24_amount_non_uae_fujairah(BigDecimal r24_amount_non_uae_fujairah) {
		this.r24_amount_non_uae_fujairah = r24_amount_non_uae_fujairah;
	}
	public BigDecimal getR24_total_fujairah() {
		return r24_total_fujairah;
	}
	public void setR24_total_fujairah(BigDecimal r24_total_fujairah) {
		this.r24_total_fujairah = r24_total_fujairah;
	}
	public String getR25_product() {
		return r25_product;
	}
	public void setR25_product(String r25_product) {
		this.r25_product = r25_product;
	}
	public BigDecimal getR25_no_of_accounts_uae() {
		return r25_no_of_accounts_uae;
	}
	public void setR25_no_of_accounts_uae(BigDecimal r25_no_of_accounts_uae) {
		this.r25_no_of_accounts_uae = r25_no_of_accounts_uae;
	}
	public BigDecimal getR25_amount_uae() {
		return r25_amount_uae;
	}
	public void setR25_amount_uae(BigDecimal r25_amount_uae) {
		this.r25_amount_uae = r25_amount_uae;
	}
	public BigDecimal getR25_no_of_accounts_resident() {
		return r25_no_of_accounts_resident;
	}
	public void setR25_no_of_accounts_resident(BigDecimal r25_no_of_accounts_resident) {
		this.r25_no_of_accounts_resident = r25_no_of_accounts_resident;
	}
	public BigDecimal getR25_amount_resident() {
		return r25_amount_resident;
	}
	public void setR25_amount_resident(BigDecimal r25_amount_resident) {
		this.r25_amount_resident = r25_amount_resident;
	}
	public BigDecimal getR25_no_of_accounts_non_resident() {
		return r25_no_of_accounts_non_resident;
	}
	public void setR25_no_of_accounts_non_resident(BigDecimal r25_no_of_accounts_non_resident) {
		this.r25_no_of_accounts_non_resident = r25_no_of_accounts_non_resident;
	}
	public BigDecimal getR25_amount_non_resident() {
		return r25_amount_non_resident;
	}
	public void setR25_amount_non_resident(BigDecimal r25_amount_non_resident) {
		this.r25_amount_non_resident = r25_amount_non_resident;
	}
	public BigDecimal getR25_total_account() {
		return r25_total_account;
	}
	public void setR25_total_account(BigDecimal r25_total_account) {
		this.r25_total_account = r25_total_account;
	}
	public BigDecimal getR25_total_amount() {
		return r25_total_amount;
	}
	public void setR25_total_amount(BigDecimal r25_total_amount) {
		this.r25_total_amount = r25_total_amount;
	}
	public BigDecimal getR25_no_of_accounts_uae_abu() {
		return r25_no_of_accounts_uae_abu;
	}
	public void setR25_no_of_accounts_uae_abu(BigDecimal r25_no_of_accounts_uae_abu) {
		this.r25_no_of_accounts_uae_abu = r25_no_of_accounts_uae_abu;
	}
	public BigDecimal getR25_amount_uae_abu() {
		return r25_amount_uae_abu;
	}
	public void setR25_amount_uae_abu(BigDecimal r25_amount_uae_abu) {
		this.r25_amount_uae_abu = r25_amount_uae_abu;
	}
	public BigDecimal getR25_no_of_accounts_non_uae_abu() {
		return r25_no_of_accounts_non_uae_abu;
	}
	public void setR25_no_of_accounts_non_uae_abu(BigDecimal r25_no_of_accounts_non_uae_abu) {
		this.r25_no_of_accounts_non_uae_abu = r25_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR25_amount_non_uae_abu() {
		return r25_amount_non_uae_abu;
	}
	public void setR25_amount_non_uae_abu(BigDecimal r25_amount_non_uae_abu) {
		this.r25_amount_non_uae_abu = r25_amount_non_uae_abu;
	}
	public BigDecimal getR25_total_abu() {
		return r25_total_abu;
	}
	public void setR25_total_abu(BigDecimal r25_total_abu) {
		this.r25_total_abu = r25_total_abu;
	}
	public BigDecimal getR25_no_of_accounts_uae_dubai() {
		return r25_no_of_accounts_uae_dubai;
	}
	public void setR25_no_of_accounts_uae_dubai(BigDecimal r25_no_of_accounts_uae_dubai) {
		this.r25_no_of_accounts_uae_dubai = r25_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR25_amount_uae_dubai() {
		return r25_amount_uae_dubai;
	}
	public void setR25_amount_uae_dubai(BigDecimal r25_amount_uae_dubai) {
		this.r25_amount_uae_dubai = r25_amount_uae_dubai;
	}
	public BigDecimal getR25_no_of_accounts_non_uae_dubai() {
		return r25_no_of_accounts_non_uae_dubai;
	}
	public void setR25_no_of_accounts_non_uae_dubai(BigDecimal r25_no_of_accounts_non_uae_dubai) {
		this.r25_no_of_accounts_non_uae_dubai = r25_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR25_amount_non_uae_dubai() {
		return r25_amount_non_uae_dubai;
	}
	public void setR25_amount_non_uae_dubai(BigDecimal r25_amount_non_uae_dubai) {
		this.r25_amount_non_uae_dubai = r25_amount_non_uae_dubai;
	}
	public BigDecimal getR25_total_dubai() {
		return r25_total_dubai;
	}
	public void setR25_total_dubai(BigDecimal r25_total_dubai) {
		this.r25_total_dubai = r25_total_dubai;
	}
	public BigDecimal getR25_no_of_accounts_uae_sharjah() {
		return r25_no_of_accounts_uae_sharjah;
	}
	public void setR25_no_of_accounts_uae_sharjah(BigDecimal r25_no_of_accounts_uae_sharjah) {
		this.r25_no_of_accounts_uae_sharjah = r25_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR25_amount_uae_sharjah() {
		return r25_amount_uae_sharjah;
	}
	public void setR25_amount_uae_sharjah(BigDecimal r25_amount_uae_sharjah) {
		this.r25_amount_uae_sharjah = r25_amount_uae_sharjah;
	}
	public BigDecimal getR25_no_of_accounts_non_uae_sharjah() {
		return r25_no_of_accounts_non_uae_sharjah;
	}
	public void setR25_no_of_accounts_non_uae_sharjah(BigDecimal r25_no_of_accounts_non_uae_sharjah) {
		this.r25_no_of_accounts_non_uae_sharjah = r25_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR25_amount_non_uae_sharjah() {
		return r25_amount_non_uae_sharjah;
	}
	public void setR25_amount_non_uae_sharjah(BigDecimal r25_amount_non_uae_sharjah) {
		this.r25_amount_non_uae_sharjah = r25_amount_non_uae_sharjah;
	}
	public BigDecimal getR25_total_sharjah() {
		return r25_total_sharjah;
	}
	public void setR25_total_sharjah(BigDecimal r25_total_sharjah) {
		this.r25_total_sharjah = r25_total_sharjah;
	}
	public BigDecimal getR25_no_of_accounts_uae_ajman() {
		return r25_no_of_accounts_uae_ajman;
	}
	public void setR25_no_of_accounts_uae_ajman(BigDecimal r25_no_of_accounts_uae_ajman) {
		this.r25_no_of_accounts_uae_ajman = r25_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR25_amount_uae_ajman() {
		return r25_amount_uae_ajman;
	}
	public void setR25_amount_uae_ajman(BigDecimal r25_amount_uae_ajman) {
		this.r25_amount_uae_ajman = r25_amount_uae_ajman;
	}
	public BigDecimal getR25_no_of_accounts_non_uae_ajman() {
		return r25_no_of_accounts_non_uae_ajman;
	}
	public void setR25_no_of_accounts_non_uae_ajman(BigDecimal r25_no_of_accounts_non_uae_ajman) {
		this.r25_no_of_accounts_non_uae_ajman = r25_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR25_amount_non_uae_ajman() {
		return r25_amount_non_uae_ajman;
	}
	public void setR25_amount_non_uae_ajman(BigDecimal r25_amount_non_uae_ajman) {
		this.r25_amount_non_uae_ajman = r25_amount_non_uae_ajman;
	}
	public BigDecimal getR25_total_ajman() {
		return r25_total_ajman;
	}
	public void setR25_total_ajman(BigDecimal r25_total_ajman) {
		this.r25_total_ajman = r25_total_ajman;
	}
	public BigDecimal getR25_no_of_accounts_uae_ras() {
		return r25_no_of_accounts_uae_ras;
	}
	public void setR25_no_of_accounts_uae_ras(BigDecimal r25_no_of_accounts_uae_ras) {
		this.r25_no_of_accounts_uae_ras = r25_no_of_accounts_uae_ras;
	}
	public BigDecimal getR25_amount_uae_ras() {
		return r25_amount_uae_ras;
	}
	public void setR25_amount_uae_ras(BigDecimal r25_amount_uae_ras) {
		this.r25_amount_uae_ras = r25_amount_uae_ras;
	}
	public BigDecimal getR25_no_of_accounts_non_uae_ras() {
		return r25_no_of_accounts_non_uae_ras;
	}
	public void setR25_no_of_accounts_non_uae_ras(BigDecimal r25_no_of_accounts_non_uae_ras) {
		this.r25_no_of_accounts_non_uae_ras = r25_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR25_amount_non_uae_ras() {
		return r25_amount_non_uae_ras;
	}
	public void setR25_amount_non_uae_ras(BigDecimal r25_amount_non_uae_ras) {
		this.r25_amount_non_uae_ras = r25_amount_non_uae_ras;
	}
	public BigDecimal getR25_total_ras() {
		return r25_total_ras;
	}
	public void setR25_total_ras(BigDecimal r25_total_ras) {
		this.r25_total_ras = r25_total_ras;
	}
	public BigDecimal getR25_no_of_accounts_uae_umm() {
		return r25_no_of_accounts_uae_umm;
	}
	public void setR25_no_of_accounts_uae_umm(BigDecimal r25_no_of_accounts_uae_umm) {
		this.r25_no_of_accounts_uae_umm = r25_no_of_accounts_uae_umm;
	}
	public BigDecimal getR25_amount_uae_umm() {
		return r25_amount_uae_umm;
	}
	public void setR25_amount_uae_umm(BigDecimal r25_amount_uae_umm) {
		this.r25_amount_uae_umm = r25_amount_uae_umm;
	}
	public BigDecimal getR25_no_of_accounts_non_uae_umm() {
		return r25_no_of_accounts_non_uae_umm;
	}
	public void setR25_no_of_accounts_non_uae_umm(BigDecimal r25_no_of_accounts_non_uae_umm) {
		this.r25_no_of_accounts_non_uae_umm = r25_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR25_amount_non_uae_umm() {
		return r25_amount_non_uae_umm;
	}
	public void setR25_amount_non_uae_umm(BigDecimal r25_amount_non_uae_umm) {
		this.r25_amount_non_uae_umm = r25_amount_non_uae_umm;
	}
	public BigDecimal getR25_total_umm() {
		return r25_total_umm;
	}
	public void setR25_total_umm(BigDecimal r25_total_umm) {
		this.r25_total_umm = r25_total_umm;
	}
	public BigDecimal getR25_no_of_accounts_uae_fujairah() {
		return r25_no_of_accounts_uae_fujairah;
	}
	public void setR25_no_of_accounts_uae_fujairah(BigDecimal r25_no_of_accounts_uae_fujairah) {
		this.r25_no_of_accounts_uae_fujairah = r25_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR25_amount_uae_fujairah() {
		return r25_amount_uae_fujairah;
	}
	public void setR25_amount_uae_fujairah(BigDecimal r25_amount_uae_fujairah) {
		this.r25_amount_uae_fujairah = r25_amount_uae_fujairah;
	}
	public BigDecimal getR25_no_of_accounts_non_uae_fujairah() {
		return r25_no_of_accounts_non_uae_fujairah;
	}
	public void setR25_no_of_accounts_non_uae_fujairah(BigDecimal r25_no_of_accounts_non_uae_fujairah) {
		this.r25_no_of_accounts_non_uae_fujairah = r25_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR25_amount_non_uae_fujairah() {
		return r25_amount_non_uae_fujairah;
	}
	public void setR25_amount_non_uae_fujairah(BigDecimal r25_amount_non_uae_fujairah) {
		this.r25_amount_non_uae_fujairah = r25_amount_non_uae_fujairah;
	}
	public BigDecimal getR25_total_fujairah() {
		return r25_total_fujairah;
	}
	public void setR25_total_fujairah(BigDecimal r25_total_fujairah) {
		this.r25_total_fujairah = r25_total_fujairah;
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
	public Date getReport_date() {
		return report_date;
	}
	public void setReport_date(Date report_date) {
		this.report_date = report_date;
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
	public BRF41_Entity1() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	


}
