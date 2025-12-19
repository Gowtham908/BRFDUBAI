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
@Table(name = "BRF41B_SUMMARYTABLE")
public class BRF41_Entity2 {
	private String r26_product;
	private BigDecimal r26_no_of_accounts_uae;
	private BigDecimal r26_amount_uae;
	private BigDecimal r26_no_of_accounts_resident;
	private BigDecimal r26_amount_resident;
	private BigDecimal r26_no_of_accounts_non_resident;
	private BigDecimal r26_amount_non_resident;
	private BigDecimal r26_total_account;
	private BigDecimal r26_total_amount;
	private BigDecimal r26_no_of_accounts_uae_abu;
	private BigDecimal r26_amount_uae_abu;
	private BigDecimal r26_no_of_accounts_non_uae_abu;
	private BigDecimal r26_amount_non_uae_abu;
	private BigDecimal r26_total_abu;
	private BigDecimal r26_no_of_accounts_uae_dubai;
	private BigDecimal r26_amount_uae_dubai;
	private BigDecimal r26_no_of_accounts_non_uae_dubai;
	private BigDecimal r26_amount_non_uae_dubai;
	private BigDecimal r26_total_dubai;
	private BigDecimal r26_no_of_accounts_uae_sharjah;
	private BigDecimal r26_amount_uae_sharjah;
	private BigDecimal r26_no_of_accounts_non_uae_sharjah;
	private BigDecimal r26_amount_non_uae_sharjah;
	private BigDecimal r26_total_sharjah;
	private BigDecimal r26_no_of_accounts_uae_ajman;
	private BigDecimal r26_amount_uae_ajman;
	private BigDecimal r26_no_of_accounts_non_uae_ajman;
	private BigDecimal r26_amount_non_uae_ajman;
	private BigDecimal r26_total_ajman;
	private BigDecimal r26_no_of_accounts_uae_ras;
	private BigDecimal r26_amount_uae_ras;
	private BigDecimal r26_no_of_accounts_non_uae_ras;
	private BigDecimal r26_amount_non_uae_ras;
	private BigDecimal r26_total_ras;
	private BigDecimal r26_no_of_accounts_uae_umm;
	private BigDecimal r26_amount_uae_umm;
	private BigDecimal r26_no_of_accounts_non_uae_umm;
	private BigDecimal r26_amount_non_uae_umm;
	private BigDecimal r26_total_umm;
	private BigDecimal r26_no_of_accounts_uae_fujairah;
	private BigDecimal r26_amount_uae_fujairah;
	private BigDecimal r26_no_of_accounts_non_uae_fujairah;
	private BigDecimal r26_amount_non_uae_fujairah;
	private BigDecimal r26_total_fujairah;
	private String r27_product;
	private BigDecimal r27_no_of_accounts_uae;
	private BigDecimal r27_amount_uae;
	private BigDecimal r27_no_of_accounts_resident;
	private BigDecimal r27_amount_resident;
	private BigDecimal r27_no_of_accounts_non_resident;
	private BigDecimal r27_amount_non_resident;
	private BigDecimal r27_total_account;
	private BigDecimal r27_total_amount;
	private BigDecimal r27_no_of_accounts_uae_abu;
	private BigDecimal r27_amount_uae_abu;
	private BigDecimal r27_no_of_accounts_non_uae_abu;
	private BigDecimal r27_amount_non_uae_abu;
	private BigDecimal r27_total_abu;
	private BigDecimal r27_no_of_accounts_uae_dubai;
	private BigDecimal r27_amount_uae_dubai;
	private BigDecimal r27_no_of_accounts_non_uae_dubai;
	private BigDecimal r27_amount_non_uae_dubai;
	private BigDecimal r27_total_dubai;
	private BigDecimal r27_no_of_accounts_uae_sharjah;
	private BigDecimal r27_amount_uae_sharjah;
	private BigDecimal r27_no_of_accounts_non_uae_sharjah;
	private BigDecimal r27_amount_non_uae_sharjah;
	private BigDecimal r27_total_sharjah;
	private BigDecimal r27_no_of_accounts_uae_ajman;
	private BigDecimal r27_amount_uae_ajman;
	private BigDecimal r27_no_of_accounts_non_uae_ajman;
	private BigDecimal r27_amount_non_uae_ajman;
	private BigDecimal r27_total_ajman;
	private BigDecimal r27_no_of_accounts_uae_ras;
	private BigDecimal r27_amount_uae_ras;
	private BigDecimal r27_no_of_accounts_non_uae_ras;
	private BigDecimal r27_amount_non_uae_ras;
	private BigDecimal r27_total_ras;
	private BigDecimal r27_no_of_accounts_uae_umm;
	private BigDecimal r27_amount_uae_umm;
	private BigDecimal r27_no_of_accounts_non_uae_umm;
	private BigDecimal r27_amount_non_uae_umm;
	private BigDecimal r27_total_umm;
	private BigDecimal r27_no_of_accounts_uae_fujairah;
	private BigDecimal r27_amount_uae_fujairah;
	private BigDecimal r27_no_of_accounts_non_uae_fujairah;
	private BigDecimal r27_amount_non_uae_fujairah;
	private BigDecimal r27_total_fujairah;
	private String r28_product;
	private BigDecimal r28_no_of_accounts_uae;
	private BigDecimal r28_amount_uae;
	private BigDecimal r28_no_of_accounts_resident;
	private BigDecimal r28_amount_resident;
	private BigDecimal r28_no_of_accounts_non_resident;
	private BigDecimal r28_amount_non_resident;
	private BigDecimal r28_total_account;
	private BigDecimal r28_total_amount;
	private BigDecimal r28_no_of_accounts_uae_abu;
	private BigDecimal r28_amount_uae_abu;
	private BigDecimal r28_no_of_accounts_non_uae_abu;
	private BigDecimal r28_amount_non_uae_abu;
	private BigDecimal r28_total_abu;
	private BigDecimal r28_no_of_accounts_uae_dubai;
	private BigDecimal r28_amount_uae_dubai;
	private BigDecimal r28_no_of_accounts_non_uae_dubai;
	private BigDecimal r28_amount_non_uae_dubai;
	private BigDecimal r28_total_dubai;
	private BigDecimal r28_no_of_accounts_uae_sharjah;
	private BigDecimal r28_amount_uae_sharjah;
	private BigDecimal r28_no_of_accounts_non_uae_sharjah;
	private BigDecimal r28_amount_non_uae_sharjah;
	private BigDecimal r28_total_sharjah;
	private BigDecimal r28_no_of_accounts_uae_ajman;
	private BigDecimal r28_amount_uae_ajman;
	private BigDecimal r28_no_of_accounts_non_uae_ajman;
	private BigDecimal r28_amount_non_uae_ajman;
	private BigDecimal r28_total_ajman;
	private BigDecimal r28_no_of_accounts_uae_ras;
	private BigDecimal r28_amount_uae_ras;
	private BigDecimal r28_no_of_accounts_non_uae_ras;
	private BigDecimal r28_amount_non_uae_ras;
	private BigDecimal r28_total_ras;
	private BigDecimal r28_no_of_accounts_uae_umm;
	private BigDecimal r28_amount_uae_umm;
	private BigDecimal r28_no_of_accounts_non_uae_umm;
	private BigDecimal r28_amount_non_uae_umm;
	private BigDecimal r28_total_umm;
	private BigDecimal r28_no_of_accounts_uae_fujairah;
	private BigDecimal r28_amount_uae_fujairah;
	private BigDecimal r28_no_of_accounts_non_uae_fujairah;
	private BigDecimal r28_amount_non_uae_fujairah;
	private BigDecimal r28_total_fujairah;
	private String r29_product;
	private BigDecimal r29_no_of_accounts_uae;
	private BigDecimal r29_amount_uae;
	private BigDecimal r29_no_of_accounts_resident;
	private BigDecimal r29_amount_resident;
	private BigDecimal r29_no_of_accounts_non_resident;
	private BigDecimal r29_amount_non_resident;
	private BigDecimal r29_total_account;
	private BigDecimal r29_total_amount;
	private BigDecimal r29_no_of_accounts_uae_abu;
	private BigDecimal r29_amount_uae_abu;
	private BigDecimal r29_no_of_accounts_non_uae_abu;
	private BigDecimal r29_amount_non_uae_abu;
	private BigDecimal r29_total_abu;
	private BigDecimal r29_no_of_accounts_uae_dubai;
	private BigDecimal r29_amount_uae_dubai;
	private BigDecimal r29_no_of_accounts_non_uae_dubai;
	private BigDecimal r29_amount_non_uae_dubai;
	private BigDecimal r29_total_dubai;
	private BigDecimal r29_no_of_accounts_uae_sharjah;
	private BigDecimal r29_amount_uae_sharjah;
	private BigDecimal r29_no_of_accounts_non_uae_sharjah;
	private BigDecimal r29_amount_non_uae_sharjah;
	private BigDecimal r29_total_sharjah;
	private BigDecimal r29_no_of_accounts_uae_ajman;
	private BigDecimal r29_amount_uae_ajman;
	private BigDecimal r29_no_of_accounts_non_uae_ajman;
	private BigDecimal r29_amount_non_uae_ajman;
	private BigDecimal r29_total_ajman;
	private BigDecimal r29_no_of_accounts_uae_ras;
	private BigDecimal r29_amount_uae_ras;
	private BigDecimal r29_no_of_accounts_non_uae_ras;
	private BigDecimal r29_amount_non_uae_ras;
	private BigDecimal r29_total_ras;
	private BigDecimal r29_no_of_accounts_uae_umm;
	private BigDecimal r29_amount_uae_umm;
	private BigDecimal r29_no_of_accounts_non_uae_umm;
	private BigDecimal r29_amount_non_uae_umm;
	private BigDecimal r29_total_umm;
	private BigDecimal r29_no_of_accounts_uae_fujairah;
	private BigDecimal r29_amount_uae_fujairah;
	private BigDecimal r29_no_of_accounts_non_uae_fujairah;
	private BigDecimal r29_amount_non_uae_fujairah;
	private BigDecimal r29_total_fujairah;
	private String r30_product;
	private BigDecimal r30_no_of_accounts_uae;
	private BigDecimal r30_amount_uae;
	private BigDecimal r30_no_of_accounts_resident;
	private BigDecimal r30_amount_resident;
	private BigDecimal r30_no_of_accounts_non_resident;
	private BigDecimal r30_amount_non_resident;
	private BigDecimal r30_total_account;
	private BigDecimal r30_total_amount;
	private BigDecimal r30_no_of_accounts_uae_abu;
	private BigDecimal r30_amount_uae_abu;
	private BigDecimal r30_no_of_accounts_non_uae_abu;
	private BigDecimal r30_amount_non_uae_abu;
	private BigDecimal r30_total_abu;
	private BigDecimal r30_no_of_accounts_uae_dubai;
	private BigDecimal r30_amount_uae_dubai;
	private BigDecimal r30_no_of_accounts_non_uae_dubai;
	private BigDecimal r30_amount_non_uae_dubai;
	private BigDecimal r30_total_dubai;
	private BigDecimal r30_no_of_accounts_uae_sharjah;
	private BigDecimal r30_amount_uae_sharjah;
	private BigDecimal r30_no_of_accounts_non_uae_sharjah;
	private BigDecimal r30_amount_non_uae_sharjah;
	private BigDecimal r30_total_sharjah;
	private BigDecimal r30_no_of_accounts_uae_ajman;
	private BigDecimal r30_amount_uae_ajman;
	private BigDecimal r30_no_of_accounts_non_uae_ajman;
	private BigDecimal r30_amount_non_uae_ajman;
	private BigDecimal r30_total_ajman;
	private BigDecimal r30_no_of_accounts_uae_ras;
	private BigDecimal r30_amount_uae_ras;
	private BigDecimal r30_no_of_accounts_non_uae_ras;
	private BigDecimal r30_amount_non_uae_ras;
	private BigDecimal r30_total_ras;
	private BigDecimal r30_no_of_accounts_uae_umm;
	private BigDecimal r30_amount_uae_umm;
	private BigDecimal r30_no_of_accounts_non_uae_umm;
	private BigDecimal r30_amount_non_uae_umm;
	private BigDecimal r30_total_umm;
	private BigDecimal r30_no_of_accounts_uae_fujairah;
	private BigDecimal r30_amount_uae_fujairah;
	private BigDecimal r30_no_of_accounts_non_uae_fujairah;
	private BigDecimal r30_amount_non_uae_fujairah;
	private BigDecimal r30_total_fujairah;
	private String r31_product;
	private BigDecimal r31_no_of_accounts_uae;
	private BigDecimal r31_amount_uae;
	private BigDecimal r31_no_of_accounts_resident;
	private BigDecimal r31_amount_resident;
	private BigDecimal r31_no_of_accounts_non_resident;
	private BigDecimal r31_amount_non_resident;
	private BigDecimal r31_total_account;
	private BigDecimal r31_total_amount;
	private BigDecimal r31_no_of_accounts_uae_abu;
	private BigDecimal r31_amount_uae_abu;
	private BigDecimal r31_no_of_accounts_non_uae_abu;
	private BigDecimal r31_amount_non_uae_abu;
	private BigDecimal r31_total_abu;
	private BigDecimal r31_no_of_accounts_uae_dubai;
	private BigDecimal r31_amount_uae_dubai;
	private BigDecimal r31_no_of_accounts_non_uae_dubai;
	private BigDecimal r31_amount_non_uae_dubai;
	private BigDecimal r31_total_dubai;
	private BigDecimal r31_no_of_accounts_uae_sharjah;
	private BigDecimal r31_amount_uae_sharjah;
	private BigDecimal r31_no_of_accounts_non_uae_sharjah;
	private BigDecimal r31_amount_non_uae_sharjah;
	private BigDecimal r31_total_sharjah;
	private BigDecimal r31_no_of_accounts_uae_ajman;
	private BigDecimal r31_amount_uae_ajman;
	private BigDecimal r31_no_of_accounts_non_uae_ajman;
	private BigDecimal r31_amount_non_uae_ajman;
	private BigDecimal r31_total_ajman;
	private BigDecimal r31_no_of_accounts_uae_ras;
	private BigDecimal r31_amount_uae_ras;
	private BigDecimal r31_no_of_accounts_non_uae_ras;
	private BigDecimal r31_amount_non_uae_ras;
	private BigDecimal r31_total_ras;
	private BigDecimal r31_no_of_accounts_uae_umm;
	private BigDecimal r31_amount_uae_umm;
	private BigDecimal r31_no_of_accounts_non_uae_umm;
	private BigDecimal r31_amount_non_uae_umm;
	private BigDecimal r31_total_umm;
	private BigDecimal r31_no_of_accounts_uae_fujairah;
	private BigDecimal r31_amount_uae_fujairah;
	private BigDecimal r31_no_of_accounts_non_uae_fujairah;
	private BigDecimal r31_amount_non_uae_fujairah;
	private BigDecimal r31_total_fujairah;
	private String r32_product;
	private BigDecimal r32_no_of_accounts_uae;
	private BigDecimal r32_amount_uae;
	private BigDecimal r32_no_of_accounts_resident;
	private BigDecimal r32_amount_resident;
	private BigDecimal r32_no_of_accounts_non_resident;
	private BigDecimal r32_amount_non_resident;
	private BigDecimal r32_total_account;
	private BigDecimal r32_total_amount;
	private BigDecimal r32_no_of_accounts_uae_abu;
	private BigDecimal r32_amount_uae_abu;
	private BigDecimal r32_no_of_accounts_non_uae_abu;
	private BigDecimal r32_amount_non_uae_abu;
	private BigDecimal r32_total_abu;
	private BigDecimal r32_no_of_accounts_uae_dubai;
	private BigDecimal r32_amount_uae_dubai;
	private BigDecimal r32_no_of_accounts_non_uae_dubai;
	private BigDecimal r32_amount_non_uae_dubai;
	private BigDecimal r32_total_dubai;
	private BigDecimal r32_no_of_accounts_uae_sharjah;
	private BigDecimal r32_amount_uae_sharjah;
	private BigDecimal r32_no_of_accounts_non_uae_sharjah;
	private BigDecimal r32_amount_non_uae_sharjah;
	private BigDecimal r32_total_sharjah;
	private BigDecimal r32_no_of_accounts_uae_ajman;
	private BigDecimal r32_amount_uae_ajman;
	private BigDecimal r32_no_of_accounts_non_uae_ajman;
	private BigDecimal r32_amount_non_uae_ajman;
	private BigDecimal r32_total_ajman;
	private BigDecimal r32_no_of_accounts_uae_ras;
	private BigDecimal r32_amount_uae_ras;
	private BigDecimal r32_no_of_accounts_non_uae_ras;
	private BigDecimal r32_amount_non_uae_ras;
	private BigDecimal r32_total_ras;
	private BigDecimal r32_no_of_accounts_uae_umm;
	private BigDecimal r32_amount_uae_umm;
	private BigDecimal r32_no_of_accounts_non_uae_umm;
	private BigDecimal r32_amount_non_uae_umm;
	private BigDecimal r32_total_umm;
	private BigDecimal r32_no_of_accounts_uae_fujairah;
	private BigDecimal r32_amount_uae_fujairah;
	private BigDecimal r32_no_of_accounts_non_uae_fujairah;
	private BigDecimal r32_amount_non_uae_fujairah;
	private BigDecimal r32_total_fujairah;
	private String r33_product;
	private BigDecimal r33_no_of_accounts_uae;
	private BigDecimal r33_amount_uae;
	private BigDecimal r33_no_of_accounts_resident;
	private BigDecimal r33_amount_resident;
	private BigDecimal r33_no_of_accounts_non_resident;
	private BigDecimal r33_amount_non_resident;
	private BigDecimal r33_total_account;
	private BigDecimal r33_total_amount;
	private BigDecimal r33_no_of_accounts_uae_abu;
	private BigDecimal r33_amount_uae_abu;
	private BigDecimal r33_no_of_accounts_non_uae_abu;
	private BigDecimal r33_amount_non_uae_abu;
	private BigDecimal r33_total_abu;
	private BigDecimal r33_no_of_accounts_uae_dubai;
	private BigDecimal r33_amount_uae_dubai;
	private BigDecimal r33_no_of_accounts_non_uae_dubai;
	private BigDecimal r33_amount_non_uae_dubai;
	private BigDecimal r33_total_dubai;
	private BigDecimal r33_no_of_accounts_uae_sharjah;
	private BigDecimal r33_amount_uae_sharjah;
	private BigDecimal r33_no_of_accounts_non_uae_sharjah;
	private BigDecimal r33_amount_non_uae_sharjah;
	private BigDecimal r33_total_sharjah;
	private BigDecimal r33_no_of_accounts_uae_ajman;
	private BigDecimal r33_amount_uae_ajman;
	private BigDecimal r33_no_of_accounts_non_uae_ajman;
	private BigDecimal r33_amount_non_uae_ajman;
	private BigDecimal r33_total_ajman;
	private BigDecimal r33_no_of_accounts_uae_ras;
	private BigDecimal r33_amount_uae_ras;
	private BigDecimal r33_no_of_accounts_non_uae_ras;
	private BigDecimal r33_amount_non_uae_ras;
	private BigDecimal r33_total_ras;
	private BigDecimal r33_no_of_accounts_uae_umm;
	private BigDecimal r33_amount_uae_umm;
	private BigDecimal r33_no_of_accounts_non_uae_umm;
	private BigDecimal r33_amount_non_uae_umm;
	private BigDecimal r33_total_umm;
	private BigDecimal r33_no_of_accounts_uae_fujairah;
	private BigDecimal r33_amount_uae_fujairah;
	private BigDecimal r33_no_of_accounts_non_uae_fujairah;
	private BigDecimal r33_amount_non_uae_fujairah;
	private BigDecimal r33_total_fujairah;
	private String r34_product;
	private BigDecimal r34_no_of_accounts_uae;
	private BigDecimal r34_amount_uae;
	private BigDecimal r34_no_of_accounts_resident;
	private BigDecimal r34_amount_resident;
	private BigDecimal r34_no_of_accounts_non_resident;
	private BigDecimal r34_amount_non_resident;
	private BigDecimal r34_total_account;
	private BigDecimal r34_total_amount;
	private BigDecimal r34_no_of_accounts_uae_abu;
	private BigDecimal r34_amount_uae_abu;
	private BigDecimal r34_no_of_accounts_non_uae_abu;
	private BigDecimal r34_amount_non_uae_abu;
	private BigDecimal r34_total_abu;
	private BigDecimal r34_no_of_accounts_uae_dubai;
	private BigDecimal r34_amount_uae_dubai;
	private BigDecimal r34_no_of_accounts_non_uae_dubai;
	private BigDecimal r34_amount_non_uae_dubai;
	private BigDecimal r34_total_dubai;
	private BigDecimal r34_no_of_accounts_uae_sharjah;
	private BigDecimal r34_amount_uae_sharjah;
	private BigDecimal r34_no_of_accounts_non_uae_sharjah;
	private BigDecimal r34_amount_non_uae_sharjah;
	private BigDecimal r34_total_sharjah;
	private BigDecimal r34_no_of_accounts_uae_ajman;
	private BigDecimal r34_amount_uae_ajman;
	private BigDecimal r34_no_of_accounts_non_uae_ajman;
	private BigDecimal r34_amount_non_uae_ajman;
	private BigDecimal r34_total_ajman;
	private BigDecimal r34_no_of_accounts_uae_ras;
	private BigDecimal r34_amount_uae_ras;
	private BigDecimal r34_no_of_accounts_non_uae_ras;
	private BigDecimal r34_amount_non_uae_ras;
	private BigDecimal r34_total_ras;
	private BigDecimal r34_no_of_accounts_uae_umm;
	private BigDecimal r34_amount_uae_umm;
	private BigDecimal r34_no_of_accounts_non_uae_umm;
	private BigDecimal r34_amount_non_uae_umm;
	private BigDecimal r34_total_umm;
	private BigDecimal r34_no_of_accounts_uae_fujairah;
	private BigDecimal r34_amount_uae_fujairah;
	private BigDecimal r34_no_of_accounts_non_uae_fujairah;
	private BigDecimal r34_amount_non_uae_fujairah;
	private BigDecimal r34_total_fujairah;
	private String r35_product;
	private BigDecimal r35_no_of_accounts_uae;
	private BigDecimal r35_amount_uae;
	private BigDecimal r35_no_of_accounts_resident;
	private BigDecimal r35_amount_resident;
	private BigDecimal r35_no_of_accounts_non_resident;
	private BigDecimal r35_amount_non_resident;
	private BigDecimal r35_total_account;
	private BigDecimal r35_total_amount;
	private BigDecimal r35_no_of_accounts_uae_abu;
	private BigDecimal r35_amount_uae_abu;
	private BigDecimal r35_no_of_accounts_non_uae_abu;
	private BigDecimal r35_amount_non_uae_abu;
	private BigDecimal r35_total_abu;
	private BigDecimal r35_no_of_accounts_uae_dubai;
	private BigDecimal r35_amount_uae_dubai;
	private BigDecimal r35_no_of_accounts_non_uae_dubai;
	private BigDecimal r35_amount_non_uae_dubai;
	private BigDecimal r35_total_dubai;
	private BigDecimal r35_no_of_accounts_uae_sharjah;
	private BigDecimal r35_amount_uae_sharjah;
	private BigDecimal r35_no_of_accounts_non_uae_sharjah;
	private BigDecimal r35_amount_non_uae_sharjah;
	private BigDecimal r35_total_sharjah;
	private BigDecimal r35_no_of_accounts_uae_ajman;
	private BigDecimal r35_amount_uae_ajman;
	private BigDecimal r35_no_of_accounts_non_uae_ajman;
	private BigDecimal r35_amount_non_uae_ajman;
	private BigDecimal r35_total_ajman;
	private BigDecimal r35_no_of_accounts_uae_ras;
	private BigDecimal r35_amount_uae_ras;
	private BigDecimal r35_no_of_accounts_non_uae_ras;
	private BigDecimal r35_amount_non_uae_ras;
	private BigDecimal r35_total_ras;
	private BigDecimal r35_no_of_accounts_uae_umm;
	private BigDecimal r35_amount_uae_umm;
	private BigDecimal r35_no_of_accounts_non_uae_umm;
	private BigDecimal r35_amount_non_uae_umm;
	private BigDecimal r35_total_umm;
	private BigDecimal r35_no_of_accounts_uae_fujairah;
	private BigDecimal r35_amount_uae_fujairah;
	private BigDecimal r35_no_of_accounts_non_uae_fujairah;
	private BigDecimal r35_amount_non_uae_fujairah;
	private BigDecimal r35_total_fujairah;
	private String r36_product;
	private BigDecimal r36_no_of_accounts_uae;
	private BigDecimal r36_amount_uae;
	private BigDecimal r36_no_of_accounts_resident;
	private BigDecimal r36_amount_resident;
	private BigDecimal r36_no_of_accounts_non_resident;
	private BigDecimal r36_amount_non_resident;
	private BigDecimal r36_total_account;
	private BigDecimal r36_total_amount;
	private BigDecimal r36_no_of_accounts_uae_abu;
	private BigDecimal r36_amount_uae_abu;
	private BigDecimal r36_no_of_accounts_non_uae_abu;
	private BigDecimal r36_amount_non_uae_abu;
	private BigDecimal r36_total_abu;
	private BigDecimal r36_no_of_accounts_uae_dubai;
	private BigDecimal r36_amount_uae_dubai;
	private BigDecimal r36_no_of_accounts_non_uae_dubai;
	private BigDecimal r36_amount_non_uae_dubai;
	private BigDecimal r36_total_dubai;
	private BigDecimal r36_no_of_accounts_uae_sharjah;
	private BigDecimal r36_amount_uae_sharjah;
	private BigDecimal r36_no_of_accounts_non_uae_sharjah;
	private BigDecimal r36_amount_non_uae_sharjah;
	private BigDecimal r36_total_sharjah;
	private BigDecimal r36_no_of_accounts_uae_ajman;
	private BigDecimal r36_amount_uae_ajman;
	private BigDecimal r36_no_of_accounts_non_uae_ajman;
	private BigDecimal r36_amount_non_uae_ajman;
	private BigDecimal r36_total_ajman;
	private BigDecimal r36_no_of_accounts_uae_ras;
	private BigDecimal r36_amount_uae_ras;
	private BigDecimal r36_no_of_accounts_non_uae_ras;
	private BigDecimal r36_amount_non_uae_ras;
	private BigDecimal r36_total_ras;
	private BigDecimal r36_no_of_accounts_uae_umm;
	private BigDecimal r36_amount_uae_umm;
	private BigDecimal r36_no_of_accounts_non_uae_umm;
	private BigDecimal r36_amount_non_uae_umm;
	private BigDecimal r36_total_umm;
	private BigDecimal r36_no_of_accounts_uae_fujairah;
	private BigDecimal r36_amount_uae_fujairah;
	private BigDecimal r36_no_of_accounts_non_uae_fujairah;
	private BigDecimal r36_amount_non_uae_fujairah;
	private BigDecimal r36_total_fujairah;
	private String r37_product;
	private BigDecimal r37_no_of_accounts_uae;
	private BigDecimal r37_amount_uae;
	private BigDecimal r37_no_of_accounts_resident;
	private BigDecimal r37_amount_resident;
	private BigDecimal r37_no_of_accounts_non_resident;
	private BigDecimal r37_amount_non_resident;
	private BigDecimal r37_total_account;
	private BigDecimal r37_total_amount;
	private BigDecimal r37_no_of_accounts_uae_abu;
	private BigDecimal r37_amount_uae_abu;
	private BigDecimal r37_no_of_accounts_non_uae_abu;
	private BigDecimal r37_amount_non_uae_abu;
	private BigDecimal r37_total_abu;
	private BigDecimal r37_no_of_accounts_uae_dubai;
	private BigDecimal r37_amount_uae_dubai;
	private BigDecimal r37_no_of_accounts_non_uae_dubai;
	private BigDecimal r37_amount_non_uae_dubai;
	private BigDecimal r37_total_dubai;
	private BigDecimal r37_no_of_accounts_uae_sharjah;
	private BigDecimal r37_amount_uae_sharjah;
	private BigDecimal r37_no_of_accounts_non_uae_sharjah;
	private BigDecimal r37_amount_non_uae_sharjah;
	private BigDecimal r37_total_sharjah;
	private BigDecimal r37_no_of_accounts_uae_ajman;
	private BigDecimal r37_amount_uae_ajman;
	private BigDecimal r37_no_of_accounts_non_uae_ajman;
	private BigDecimal r37_amount_non_uae_ajman;
	private BigDecimal r37_total_ajman;
	private BigDecimal r37_no_of_accounts_uae_ras;
	private BigDecimal r37_amount_uae_ras;
	private BigDecimal r37_no_of_accounts_non_uae_ras;
	private BigDecimal r37_amount_non_uae_ras;
	private BigDecimal r37_total_ras;
	private BigDecimal r37_no_of_accounts_uae_umm;
	private BigDecimal r37_amount_uae_umm;
	private BigDecimal r37_no_of_accounts_non_uae_umm;
	private BigDecimal r37_amount_non_uae_umm;
	private BigDecimal r37_total_umm;
	private BigDecimal r37_no_of_accounts_uae_fujairah;
	private BigDecimal r37_amount_uae_fujairah;
	private BigDecimal r37_no_of_accounts_non_uae_fujairah;
	private BigDecimal r37_amount_non_uae_fujairah;
	private BigDecimal r37_total_fujairah;
	private String r38_product;
	private BigDecimal r38_no_of_accounts_uae;
	private BigDecimal r38_amount_uae;
	private BigDecimal r38_no_of_accounts_resident;
	private BigDecimal r38_amount_resident;
	private BigDecimal r38_no_of_accounts_non_resident;
	private BigDecimal r38_amount_non_resident;
	private BigDecimal r38_total_account;
	private BigDecimal r38_total_amount;
	private BigDecimal r38_no_of_accounts_uae_abu;
	private BigDecimal r38_amount_uae_abu;
	private BigDecimal r38_no_of_accounts_non_uae_abu;
	private BigDecimal r38_amount_non_uae_abu;
	private BigDecimal r38_total_abu;
	private BigDecimal r38_no_of_accounts_uae_dubai;
	private BigDecimal r38_amount_uae_dubai;
	private BigDecimal r38_no_of_accounts_non_uae_dubai;
	private BigDecimal r38_amount_non_uae_dubai;
	private BigDecimal r38_total_dubai;
	private BigDecimal r38_no_of_accounts_uae_sharjah;
	private BigDecimal r38_amount_uae_sharjah;
	private BigDecimal r38_no_of_accounts_non_uae_sharjah;
	private BigDecimal r38_amount_non_uae_sharjah;
	private BigDecimal r38_total_sharjah;
	private BigDecimal r38_no_of_accounts_uae_ajman;
	private BigDecimal r38_amount_uae_ajman;
	private BigDecimal r38_no_of_accounts_non_uae_ajman;
	private BigDecimal r38_amount_non_uae_ajman;
	private BigDecimal r38_total_ajman;
	private BigDecimal r38_no_of_accounts_uae_ras;
	private BigDecimal r38_amount_uae_ras;
	private BigDecimal r38_no_of_accounts_non_uae_ras;
	private BigDecimal r38_amount_non_uae_ras;
	private BigDecimal r38_total_ras;
	private BigDecimal r38_no_of_accounts_uae_umm;
	private BigDecimal r38_amount_uae_umm;
	private BigDecimal r38_no_of_accounts_non_uae_umm;
	private BigDecimal r38_amount_non_uae_umm;
	private BigDecimal r38_total_umm;
	private BigDecimal r38_no_of_accounts_uae_fujairah;
	private BigDecimal r38_amount_uae_fujairah;
	private BigDecimal r38_no_of_accounts_non_uae_fujairah;
	private BigDecimal r38_amount_non_uae_fujairah;
	private BigDecimal r38_total_fujairah;
	private String r39_product;
	private BigDecimal r39_no_of_accounts_uae;
	private BigDecimal r39_amount_uae;
	private BigDecimal r39_no_of_accounts_resident;
	private BigDecimal r39_amount_resident;
	private BigDecimal r39_no_of_accounts_non_resident;
	private BigDecimal r39_amount_non_resident;
	private BigDecimal r39_total_account;
	private BigDecimal r39_total_amount;
	private BigDecimal r39_no_of_accounts_uae_abu;
	private BigDecimal r39_amount_uae_abu;
	private BigDecimal r39_no_of_accounts_non_uae_abu;
	private BigDecimal r39_amount_non_uae_abu;
	private BigDecimal r39_total_abu;
	private BigDecimal r39_no_of_accounts_uae_dubai;
	private BigDecimal r39_amount_uae_dubai;
	private BigDecimal r39_no_of_accounts_non_uae_dubai;
	private BigDecimal r39_amount_non_uae_dubai;
	private BigDecimal r39_total_dubai;
	private BigDecimal r39_no_of_accounts_uae_sharjah;
	private BigDecimal r39_amount_uae_sharjah;
	private BigDecimal r39_no_of_accounts_non_uae_sharjah;
	private BigDecimal r39_amount_non_uae_sharjah;
	private BigDecimal r39_total_sharjah;
	private BigDecimal r39_no_of_accounts_uae_ajman;
	private BigDecimal r39_amount_uae_ajman;
	private BigDecimal r39_no_of_accounts_non_uae_ajman;
	private BigDecimal r39_amount_non_uae_ajman;
	private BigDecimal r39_total_ajman;
	private BigDecimal r39_no_of_accounts_uae_ras;
	private BigDecimal r39_amount_uae_ras;
	private BigDecimal r39_no_of_accounts_non_uae_ras;
	private BigDecimal r39_amount_non_uae_ras;
	private BigDecimal r39_total_ras;
	private BigDecimal r39_no_of_accounts_uae_umm;
	private BigDecimal r39_amount_uae_umm;
	private BigDecimal r39_no_of_accounts_non_uae_umm;
	private BigDecimal r39_amount_non_uae_umm;
	private BigDecimal r39_total_umm;
	private BigDecimal r39_no_of_accounts_uae_fujairah;
	private BigDecimal r39_amount_uae_fujairah;
	private BigDecimal r39_no_of_accounts_non_uae_fujairah;
	private BigDecimal r39_amount_non_uae_fujairah;
	private BigDecimal r39_total_fujairah;
	private String r40_product;
	private BigDecimal r40_no_of_accounts_uae;
	private BigDecimal r40_amount_uae;
	private BigDecimal r40_no_of_accounts_resident;
	private BigDecimal r40_amount_resident;
	private BigDecimal r40_no_of_accounts_non_resident;
	private BigDecimal r40_amount_non_resident;
	private BigDecimal r40_total_account;
	private BigDecimal r40_total_amount;
	private BigDecimal r40_no_of_accounts_uae_abu;
	private BigDecimal r40_amount_uae_abu;
	private BigDecimal r40_no_of_accounts_non_uae_abu;
	private BigDecimal r40_amount_non_uae_abu;
	private BigDecimal r40_total_abu;
	private BigDecimal r40_no_of_accounts_uae_dubai;
	private BigDecimal r40_amount_uae_dubai;
	private BigDecimal r40_no_of_accounts_non_uae_dubai;
	private BigDecimal r40_amount_non_uae_dubai;
	private BigDecimal r40_total_dubai;
	private BigDecimal r40_no_of_accounts_uae_sharjah;
	private BigDecimal r40_amount_uae_sharjah;
	private BigDecimal r40_no_of_accounts_non_uae_sharjah;
	private BigDecimal r40_amount_non_uae_sharjah;
	private BigDecimal r40_total_sharjah;
	private BigDecimal r40_no_of_accounts_uae_ajman;
	private BigDecimal r40_amount_uae_ajman;
	private BigDecimal r40_no_of_accounts_non_uae_ajman;
	private BigDecimal r40_amount_non_uae_ajman;
	private BigDecimal r40_total_ajman;
	private BigDecimal r40_no_of_accounts_uae_ras;
	private BigDecimal r40_amount_uae_ras;
	private BigDecimal r40_no_of_accounts_non_uae_ras;
	private BigDecimal r40_amount_non_uae_ras;
	private BigDecimal r40_total_ras;
	private BigDecimal r40_no_of_accounts_uae_umm;
	private BigDecimal r40_amount_uae_umm;
	private BigDecimal r40_no_of_accounts_non_uae_umm;
	private BigDecimal r40_amount_non_uae_umm;
	private BigDecimal r40_total_umm;
	private BigDecimal r40_no_of_accounts_uae_fujairah;
	private BigDecimal r40_amount_uae_fujairah;
	private BigDecimal r40_no_of_accounts_non_uae_fujairah;
	private BigDecimal r40_amount_non_uae_fujairah;
	private BigDecimal r40_total_fujairah;
	private Date report_from_date;
	private Date report_to_date;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String report_code;
	private Date report_submit_date;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date report_date;
	public String getR26_product() {
		return r26_product;
	}
	public void setR26_product(String r26_product) {
		this.r26_product = r26_product;
	}
	public BigDecimal getR26_no_of_accounts_uae() {
		return r26_no_of_accounts_uae;
	}
	public void setR26_no_of_accounts_uae(BigDecimal r26_no_of_accounts_uae) {
		this.r26_no_of_accounts_uae = r26_no_of_accounts_uae;
	}
	public BigDecimal getR26_amount_uae() {
		return r26_amount_uae;
	}
	public void setR26_amount_uae(BigDecimal r26_amount_uae) {
		this.r26_amount_uae = r26_amount_uae;
	}
	public BigDecimal getR26_no_of_accounts_resident() {
		return r26_no_of_accounts_resident;
	}
	public void setR26_no_of_accounts_resident(BigDecimal r26_no_of_accounts_resident) {
		this.r26_no_of_accounts_resident = r26_no_of_accounts_resident;
	}
	public BigDecimal getR26_amount_resident() {
		return r26_amount_resident;
	}
	public void setR26_amount_resident(BigDecimal r26_amount_resident) {
		this.r26_amount_resident = r26_amount_resident;
	}
	public BigDecimal getR26_no_of_accounts_non_resident() {
		return r26_no_of_accounts_non_resident;
	}
	public void setR26_no_of_accounts_non_resident(BigDecimal r26_no_of_accounts_non_resident) {
		this.r26_no_of_accounts_non_resident = r26_no_of_accounts_non_resident;
	}
	public BigDecimal getR26_amount_non_resident() {
		return r26_amount_non_resident;
	}
	public void setR26_amount_non_resident(BigDecimal r26_amount_non_resident) {
		this.r26_amount_non_resident = r26_amount_non_resident;
	}
	public BigDecimal getR26_total_account() {
		return r26_total_account;
	}
	public void setR26_total_account(BigDecimal r26_total_account) {
		this.r26_total_account = r26_total_account;
	}
	public BigDecimal getR26_total_amount() {
		return r26_total_amount;
	}
	public void setR26_total_amount(BigDecimal r26_total_amount) {
		this.r26_total_amount = r26_total_amount;
	}
	public BigDecimal getR26_no_of_accounts_uae_abu() {
		return r26_no_of_accounts_uae_abu;
	}
	public void setR26_no_of_accounts_uae_abu(BigDecimal r26_no_of_accounts_uae_abu) {
		this.r26_no_of_accounts_uae_abu = r26_no_of_accounts_uae_abu;
	}
	public BigDecimal getR26_amount_uae_abu() {
		return r26_amount_uae_abu;
	}
	public void setR26_amount_uae_abu(BigDecimal r26_amount_uae_abu) {
		this.r26_amount_uae_abu = r26_amount_uae_abu;
	}
	public BigDecimal getR26_no_of_accounts_non_uae_abu() {
		return r26_no_of_accounts_non_uae_abu;
	}
	public void setR26_no_of_accounts_non_uae_abu(BigDecimal r26_no_of_accounts_non_uae_abu) {
		this.r26_no_of_accounts_non_uae_abu = r26_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR26_amount_non_uae_abu() {
		return r26_amount_non_uae_abu;
	}
	public void setR26_amount_non_uae_abu(BigDecimal r26_amount_non_uae_abu) {
		this.r26_amount_non_uae_abu = r26_amount_non_uae_abu;
	}
	public BigDecimal getR26_total_abu() {
		return r26_total_abu;
	}
	public void setR26_total_abu(BigDecimal r26_total_abu) {
		this.r26_total_abu = r26_total_abu;
	}
	public BigDecimal getR26_no_of_accounts_uae_dubai() {
		return r26_no_of_accounts_uae_dubai;
	}
	public void setR26_no_of_accounts_uae_dubai(BigDecimal r26_no_of_accounts_uae_dubai) {
		this.r26_no_of_accounts_uae_dubai = r26_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR26_amount_uae_dubai() {
		return r26_amount_uae_dubai;
	}
	public void setR26_amount_uae_dubai(BigDecimal r26_amount_uae_dubai) {
		this.r26_amount_uae_dubai = r26_amount_uae_dubai;
	}
	public BigDecimal getR26_no_of_accounts_non_uae_dubai() {
		return r26_no_of_accounts_non_uae_dubai;
	}
	public void setR26_no_of_accounts_non_uae_dubai(BigDecimal r26_no_of_accounts_non_uae_dubai) {
		this.r26_no_of_accounts_non_uae_dubai = r26_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR26_amount_non_uae_dubai() {
		return r26_amount_non_uae_dubai;
	}
	public void setR26_amount_non_uae_dubai(BigDecimal r26_amount_non_uae_dubai) {
		this.r26_amount_non_uae_dubai = r26_amount_non_uae_dubai;
	}
	public BigDecimal getR26_total_dubai() {
		return r26_total_dubai;
	}
	public void setR26_total_dubai(BigDecimal r26_total_dubai) {
		this.r26_total_dubai = r26_total_dubai;
	}
	public BigDecimal getR26_no_of_accounts_uae_sharjah() {
		return r26_no_of_accounts_uae_sharjah;
	}
	public void setR26_no_of_accounts_uae_sharjah(BigDecimal r26_no_of_accounts_uae_sharjah) {
		this.r26_no_of_accounts_uae_sharjah = r26_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR26_amount_uae_sharjah() {
		return r26_amount_uae_sharjah;
	}
	public void setR26_amount_uae_sharjah(BigDecimal r26_amount_uae_sharjah) {
		this.r26_amount_uae_sharjah = r26_amount_uae_sharjah;
	}
	public BigDecimal getR26_no_of_accounts_non_uae_sharjah() {
		return r26_no_of_accounts_non_uae_sharjah;
	}
	public void setR26_no_of_accounts_non_uae_sharjah(BigDecimal r26_no_of_accounts_non_uae_sharjah) {
		this.r26_no_of_accounts_non_uae_sharjah = r26_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR26_amount_non_uae_sharjah() {
		return r26_amount_non_uae_sharjah;
	}
	public void setR26_amount_non_uae_sharjah(BigDecimal r26_amount_non_uae_sharjah) {
		this.r26_amount_non_uae_sharjah = r26_amount_non_uae_sharjah;
	}
	public BigDecimal getR26_total_sharjah() {
		return r26_total_sharjah;
	}
	public void setR26_total_sharjah(BigDecimal r26_total_sharjah) {
		this.r26_total_sharjah = r26_total_sharjah;
	}
	public BigDecimal getR26_no_of_accounts_uae_ajman() {
		return r26_no_of_accounts_uae_ajman;
	}
	public void setR26_no_of_accounts_uae_ajman(BigDecimal r26_no_of_accounts_uae_ajman) {
		this.r26_no_of_accounts_uae_ajman = r26_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR26_amount_uae_ajman() {
		return r26_amount_uae_ajman;
	}
	public void setR26_amount_uae_ajman(BigDecimal r26_amount_uae_ajman) {
		this.r26_amount_uae_ajman = r26_amount_uae_ajman;
	}
	public BigDecimal getR26_no_of_accounts_non_uae_ajman() {
		return r26_no_of_accounts_non_uae_ajman;
	}
	public void setR26_no_of_accounts_non_uae_ajman(BigDecimal r26_no_of_accounts_non_uae_ajman) {
		this.r26_no_of_accounts_non_uae_ajman = r26_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR26_amount_non_uae_ajman() {
		return r26_amount_non_uae_ajman;
	}
	public void setR26_amount_non_uae_ajman(BigDecimal r26_amount_non_uae_ajman) {
		this.r26_amount_non_uae_ajman = r26_amount_non_uae_ajman;
	}
	public BigDecimal getR26_total_ajman() {
		return r26_total_ajman;
	}
	public void setR26_total_ajman(BigDecimal r26_total_ajman) {
		this.r26_total_ajman = r26_total_ajman;
	}
	public BigDecimal getR26_no_of_accounts_uae_ras() {
		return r26_no_of_accounts_uae_ras;
	}
	public void setR26_no_of_accounts_uae_ras(BigDecimal r26_no_of_accounts_uae_ras) {
		this.r26_no_of_accounts_uae_ras = r26_no_of_accounts_uae_ras;
	}
	public BigDecimal getR26_amount_uae_ras() {
		return r26_amount_uae_ras;
	}
	public void setR26_amount_uae_ras(BigDecimal r26_amount_uae_ras) {
		this.r26_amount_uae_ras = r26_amount_uae_ras;
	}
	public BigDecimal getR26_no_of_accounts_non_uae_ras() {
		return r26_no_of_accounts_non_uae_ras;
	}
	public void setR26_no_of_accounts_non_uae_ras(BigDecimal r26_no_of_accounts_non_uae_ras) {
		this.r26_no_of_accounts_non_uae_ras = r26_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR26_amount_non_uae_ras() {
		return r26_amount_non_uae_ras;
	}
	public void setR26_amount_non_uae_ras(BigDecimal r26_amount_non_uae_ras) {
		this.r26_amount_non_uae_ras = r26_amount_non_uae_ras;
	}
	public BigDecimal getR26_total_ras() {
		return r26_total_ras;
	}
	public void setR26_total_ras(BigDecimal r26_total_ras) {
		this.r26_total_ras = r26_total_ras;
	}
	public BigDecimal getR26_no_of_accounts_uae_umm() {
		return r26_no_of_accounts_uae_umm;
	}
	public void setR26_no_of_accounts_uae_umm(BigDecimal r26_no_of_accounts_uae_umm) {
		this.r26_no_of_accounts_uae_umm = r26_no_of_accounts_uae_umm;
	}
	public BigDecimal getR26_amount_uae_umm() {
		return r26_amount_uae_umm;
	}
	public void setR26_amount_uae_umm(BigDecimal r26_amount_uae_umm) {
		this.r26_amount_uae_umm = r26_amount_uae_umm;
	}
	public BigDecimal getR26_no_of_accounts_non_uae_umm() {
		return r26_no_of_accounts_non_uae_umm;
	}
	public void setR26_no_of_accounts_non_uae_umm(BigDecimal r26_no_of_accounts_non_uae_umm) {
		this.r26_no_of_accounts_non_uae_umm = r26_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR26_amount_non_uae_umm() {
		return r26_amount_non_uae_umm;
	}
	public void setR26_amount_non_uae_umm(BigDecimal r26_amount_non_uae_umm) {
		this.r26_amount_non_uae_umm = r26_amount_non_uae_umm;
	}
	public BigDecimal getR26_total_umm() {
		return r26_total_umm;
	}
	public void setR26_total_umm(BigDecimal r26_total_umm) {
		this.r26_total_umm = r26_total_umm;
	}
	public BigDecimal getR26_no_of_accounts_uae_fujairah() {
		return r26_no_of_accounts_uae_fujairah;
	}
	public void setR26_no_of_accounts_uae_fujairah(BigDecimal r26_no_of_accounts_uae_fujairah) {
		this.r26_no_of_accounts_uae_fujairah = r26_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR26_amount_uae_fujairah() {
		return r26_amount_uae_fujairah;
	}
	public void setR26_amount_uae_fujairah(BigDecimal r26_amount_uae_fujairah) {
		this.r26_amount_uae_fujairah = r26_amount_uae_fujairah;
	}
	public BigDecimal getR26_no_of_accounts_non_uae_fujairah() {
		return r26_no_of_accounts_non_uae_fujairah;
	}
	public void setR26_no_of_accounts_non_uae_fujairah(BigDecimal r26_no_of_accounts_non_uae_fujairah) {
		this.r26_no_of_accounts_non_uae_fujairah = r26_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR26_amount_non_uae_fujairah() {
		return r26_amount_non_uae_fujairah;
	}
	public void setR26_amount_non_uae_fujairah(BigDecimal r26_amount_non_uae_fujairah) {
		this.r26_amount_non_uae_fujairah = r26_amount_non_uae_fujairah;
	}
	public BigDecimal getR26_total_fujairah() {
		return r26_total_fujairah;
	}
	public void setR26_total_fujairah(BigDecimal r26_total_fujairah) {
		this.r26_total_fujairah = r26_total_fujairah;
	}
	public String getR27_product() {
		return r27_product;
	}
	public void setR27_product(String r27_product) {
		this.r27_product = r27_product;
	}
	public BigDecimal getR27_no_of_accounts_uae() {
		return r27_no_of_accounts_uae;
	}
	public void setR27_no_of_accounts_uae(BigDecimal r27_no_of_accounts_uae) {
		this.r27_no_of_accounts_uae = r27_no_of_accounts_uae;
	}
	public BigDecimal getR27_amount_uae() {
		return r27_amount_uae;
	}
	public void setR27_amount_uae(BigDecimal r27_amount_uae) {
		this.r27_amount_uae = r27_amount_uae;
	}
	public BigDecimal getR27_no_of_accounts_resident() {
		return r27_no_of_accounts_resident;
	}
	public void setR27_no_of_accounts_resident(BigDecimal r27_no_of_accounts_resident) {
		this.r27_no_of_accounts_resident = r27_no_of_accounts_resident;
	}
	public BigDecimal getR27_amount_resident() {
		return r27_amount_resident;
	}
	public void setR27_amount_resident(BigDecimal r27_amount_resident) {
		this.r27_amount_resident = r27_amount_resident;
	}
	public BigDecimal getR27_no_of_accounts_non_resident() {
		return r27_no_of_accounts_non_resident;
	}
	public void setR27_no_of_accounts_non_resident(BigDecimal r27_no_of_accounts_non_resident) {
		this.r27_no_of_accounts_non_resident = r27_no_of_accounts_non_resident;
	}
	public BigDecimal getR27_amount_non_resident() {
		return r27_amount_non_resident;
	}
	public void setR27_amount_non_resident(BigDecimal r27_amount_non_resident) {
		this.r27_amount_non_resident = r27_amount_non_resident;
	}
	public BigDecimal getR27_total_account() {
		return r27_total_account;
	}
	public void setR27_total_account(BigDecimal r27_total_account) {
		this.r27_total_account = r27_total_account;
	}
	public BigDecimal getR27_total_amount() {
		return r27_total_amount;
	}
	public void setR27_total_amount(BigDecimal r27_total_amount) {
		this.r27_total_amount = r27_total_amount;
	}
	public BigDecimal getR27_no_of_accounts_uae_abu() {
		return r27_no_of_accounts_uae_abu;
	}
	public void setR27_no_of_accounts_uae_abu(BigDecimal r27_no_of_accounts_uae_abu) {
		this.r27_no_of_accounts_uae_abu = r27_no_of_accounts_uae_abu;
	}
	public BigDecimal getR27_amount_uae_abu() {
		return r27_amount_uae_abu;
	}
	public void setR27_amount_uae_abu(BigDecimal r27_amount_uae_abu) {
		this.r27_amount_uae_abu = r27_amount_uae_abu;
	}
	public BigDecimal getR27_no_of_accounts_non_uae_abu() {
		return r27_no_of_accounts_non_uae_abu;
	}
	public void setR27_no_of_accounts_non_uae_abu(BigDecimal r27_no_of_accounts_non_uae_abu) {
		this.r27_no_of_accounts_non_uae_abu = r27_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR27_amount_non_uae_abu() {
		return r27_amount_non_uae_abu;
	}
	public void setR27_amount_non_uae_abu(BigDecimal r27_amount_non_uae_abu) {
		this.r27_amount_non_uae_abu = r27_amount_non_uae_abu;
	}
	public BigDecimal getR27_total_abu() {
		return r27_total_abu;
	}
	public void setR27_total_abu(BigDecimal r27_total_abu) {
		this.r27_total_abu = r27_total_abu;
	}
	public BigDecimal getR27_no_of_accounts_uae_dubai() {
		return r27_no_of_accounts_uae_dubai;
	}
	public void setR27_no_of_accounts_uae_dubai(BigDecimal r27_no_of_accounts_uae_dubai) {
		this.r27_no_of_accounts_uae_dubai = r27_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR27_amount_uae_dubai() {
		return r27_amount_uae_dubai;
	}
	public void setR27_amount_uae_dubai(BigDecimal r27_amount_uae_dubai) {
		this.r27_amount_uae_dubai = r27_amount_uae_dubai;
	}
	public BigDecimal getR27_no_of_accounts_non_uae_dubai() {
		return r27_no_of_accounts_non_uae_dubai;
	}
	public void setR27_no_of_accounts_non_uae_dubai(BigDecimal r27_no_of_accounts_non_uae_dubai) {
		this.r27_no_of_accounts_non_uae_dubai = r27_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR27_amount_non_uae_dubai() {
		return r27_amount_non_uae_dubai;
	}
	public void setR27_amount_non_uae_dubai(BigDecimal r27_amount_non_uae_dubai) {
		this.r27_amount_non_uae_dubai = r27_amount_non_uae_dubai;
	}
	public BigDecimal getR27_total_dubai() {
		return r27_total_dubai;
	}
	public void setR27_total_dubai(BigDecimal r27_total_dubai) {
		this.r27_total_dubai = r27_total_dubai;
	}
	public BigDecimal getR27_no_of_accounts_uae_sharjah() {
		return r27_no_of_accounts_uae_sharjah;
	}
	public void setR27_no_of_accounts_uae_sharjah(BigDecimal r27_no_of_accounts_uae_sharjah) {
		this.r27_no_of_accounts_uae_sharjah = r27_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR27_amount_uae_sharjah() {
		return r27_amount_uae_sharjah;
	}
	public void setR27_amount_uae_sharjah(BigDecimal r27_amount_uae_sharjah) {
		this.r27_amount_uae_sharjah = r27_amount_uae_sharjah;
	}
	public BigDecimal getR27_no_of_accounts_non_uae_sharjah() {
		return r27_no_of_accounts_non_uae_sharjah;
	}
	public void setR27_no_of_accounts_non_uae_sharjah(BigDecimal r27_no_of_accounts_non_uae_sharjah) {
		this.r27_no_of_accounts_non_uae_sharjah = r27_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR27_amount_non_uae_sharjah() {
		return r27_amount_non_uae_sharjah;
	}
	public void setR27_amount_non_uae_sharjah(BigDecimal r27_amount_non_uae_sharjah) {
		this.r27_amount_non_uae_sharjah = r27_amount_non_uae_sharjah;
	}
	public BigDecimal getR27_total_sharjah() {
		return r27_total_sharjah;
	}
	public void setR27_total_sharjah(BigDecimal r27_total_sharjah) {
		this.r27_total_sharjah = r27_total_sharjah;
	}
	public BigDecimal getR27_no_of_accounts_uae_ajman() {
		return r27_no_of_accounts_uae_ajman;
	}
	public void setR27_no_of_accounts_uae_ajman(BigDecimal r27_no_of_accounts_uae_ajman) {
		this.r27_no_of_accounts_uae_ajman = r27_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR27_amount_uae_ajman() {
		return r27_amount_uae_ajman;
	}
	public void setR27_amount_uae_ajman(BigDecimal r27_amount_uae_ajman) {
		this.r27_amount_uae_ajman = r27_amount_uae_ajman;
	}
	public BigDecimal getR27_no_of_accounts_non_uae_ajman() {
		return r27_no_of_accounts_non_uae_ajman;
	}
	public void setR27_no_of_accounts_non_uae_ajman(BigDecimal r27_no_of_accounts_non_uae_ajman) {
		this.r27_no_of_accounts_non_uae_ajman = r27_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR27_amount_non_uae_ajman() {
		return r27_amount_non_uae_ajman;
	}
	public void setR27_amount_non_uae_ajman(BigDecimal r27_amount_non_uae_ajman) {
		this.r27_amount_non_uae_ajman = r27_amount_non_uae_ajman;
	}
	public BigDecimal getR27_total_ajman() {
		return r27_total_ajman;
	}
	public void setR27_total_ajman(BigDecimal r27_total_ajman) {
		this.r27_total_ajman = r27_total_ajman;
	}
	public BigDecimal getR27_no_of_accounts_uae_ras() {
		return r27_no_of_accounts_uae_ras;
	}
	public void setR27_no_of_accounts_uae_ras(BigDecimal r27_no_of_accounts_uae_ras) {
		this.r27_no_of_accounts_uae_ras = r27_no_of_accounts_uae_ras;
	}
	public BigDecimal getR27_amount_uae_ras() {
		return r27_amount_uae_ras;
	}
	public void setR27_amount_uae_ras(BigDecimal r27_amount_uae_ras) {
		this.r27_amount_uae_ras = r27_amount_uae_ras;
	}
	public BigDecimal getR27_no_of_accounts_non_uae_ras() {
		return r27_no_of_accounts_non_uae_ras;
	}
	public void setR27_no_of_accounts_non_uae_ras(BigDecimal r27_no_of_accounts_non_uae_ras) {
		this.r27_no_of_accounts_non_uae_ras = r27_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR27_amount_non_uae_ras() {
		return r27_amount_non_uae_ras;
	}
	public void setR27_amount_non_uae_ras(BigDecimal r27_amount_non_uae_ras) {
		this.r27_amount_non_uae_ras = r27_amount_non_uae_ras;
	}
	public BigDecimal getR27_total_ras() {
		return r27_total_ras;
	}
	public void setR27_total_ras(BigDecimal r27_total_ras) {
		this.r27_total_ras = r27_total_ras;
	}
	public BigDecimal getR27_no_of_accounts_uae_umm() {
		return r27_no_of_accounts_uae_umm;
	}
	public void setR27_no_of_accounts_uae_umm(BigDecimal r27_no_of_accounts_uae_umm) {
		this.r27_no_of_accounts_uae_umm = r27_no_of_accounts_uae_umm;
	}
	public BigDecimal getR27_amount_uae_umm() {
		return r27_amount_uae_umm;
	}
	public void setR27_amount_uae_umm(BigDecimal r27_amount_uae_umm) {
		this.r27_amount_uae_umm = r27_amount_uae_umm;
	}
	public BigDecimal getR27_no_of_accounts_non_uae_umm() {
		return r27_no_of_accounts_non_uae_umm;
	}
	public void setR27_no_of_accounts_non_uae_umm(BigDecimal r27_no_of_accounts_non_uae_umm) {
		this.r27_no_of_accounts_non_uae_umm = r27_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR27_amount_non_uae_umm() {
		return r27_amount_non_uae_umm;
	}
	public void setR27_amount_non_uae_umm(BigDecimal r27_amount_non_uae_umm) {
		this.r27_amount_non_uae_umm = r27_amount_non_uae_umm;
	}
	public BigDecimal getR27_total_umm() {
		return r27_total_umm;
	}
	public void setR27_total_umm(BigDecimal r27_total_umm) {
		this.r27_total_umm = r27_total_umm;
	}
	public BigDecimal getR27_no_of_accounts_uae_fujairah() {
		return r27_no_of_accounts_uae_fujairah;
	}
	public void setR27_no_of_accounts_uae_fujairah(BigDecimal r27_no_of_accounts_uae_fujairah) {
		this.r27_no_of_accounts_uae_fujairah = r27_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR27_amount_uae_fujairah() {
		return r27_amount_uae_fujairah;
	}
	public void setR27_amount_uae_fujairah(BigDecimal r27_amount_uae_fujairah) {
		this.r27_amount_uae_fujairah = r27_amount_uae_fujairah;
	}
	public BigDecimal getR27_no_of_accounts_non_uae_fujairah() {
		return r27_no_of_accounts_non_uae_fujairah;
	}
	public void setR27_no_of_accounts_non_uae_fujairah(BigDecimal r27_no_of_accounts_non_uae_fujairah) {
		this.r27_no_of_accounts_non_uae_fujairah = r27_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR27_amount_non_uae_fujairah() {
		return r27_amount_non_uae_fujairah;
	}
	public void setR27_amount_non_uae_fujairah(BigDecimal r27_amount_non_uae_fujairah) {
		this.r27_amount_non_uae_fujairah = r27_amount_non_uae_fujairah;
	}
	public BigDecimal getR27_total_fujairah() {
		return r27_total_fujairah;
	}
	public void setR27_total_fujairah(BigDecimal r27_total_fujairah) {
		this.r27_total_fujairah = r27_total_fujairah;
	}
	public String getR28_product() {
		return r28_product;
	}
	public void setR28_product(String r28_product) {
		this.r28_product = r28_product;
	}
	public BigDecimal getR28_no_of_accounts_uae() {
		return r28_no_of_accounts_uae;
	}
	public void setR28_no_of_accounts_uae(BigDecimal r28_no_of_accounts_uae) {
		this.r28_no_of_accounts_uae = r28_no_of_accounts_uae;
	}
	public BigDecimal getR28_amount_uae() {
		return r28_amount_uae;
	}
	public void setR28_amount_uae(BigDecimal r28_amount_uae) {
		this.r28_amount_uae = r28_amount_uae;
	}
	public BigDecimal getR28_no_of_accounts_resident() {
		return r28_no_of_accounts_resident;
	}
	public void setR28_no_of_accounts_resident(BigDecimal r28_no_of_accounts_resident) {
		this.r28_no_of_accounts_resident = r28_no_of_accounts_resident;
	}
	public BigDecimal getR28_amount_resident() {
		return r28_amount_resident;
	}
	public void setR28_amount_resident(BigDecimal r28_amount_resident) {
		this.r28_amount_resident = r28_amount_resident;
	}
	public BigDecimal getR28_no_of_accounts_non_resident() {
		return r28_no_of_accounts_non_resident;
	}
	public void setR28_no_of_accounts_non_resident(BigDecimal r28_no_of_accounts_non_resident) {
		this.r28_no_of_accounts_non_resident = r28_no_of_accounts_non_resident;
	}
	public BigDecimal getR28_amount_non_resident() {
		return r28_amount_non_resident;
	}
	public void setR28_amount_non_resident(BigDecimal r28_amount_non_resident) {
		this.r28_amount_non_resident = r28_amount_non_resident;
	}
	public BigDecimal getR28_total_account() {
		return r28_total_account;
	}
	public void setR28_total_account(BigDecimal r28_total_account) {
		this.r28_total_account = r28_total_account;
	}
	public BigDecimal getR28_total_amount() {
		return r28_total_amount;
	}
	public void setR28_total_amount(BigDecimal r28_total_amount) {
		this.r28_total_amount = r28_total_amount;
	}
	public BigDecimal getR28_no_of_accounts_uae_abu() {
		return r28_no_of_accounts_uae_abu;
	}
	public void setR28_no_of_accounts_uae_abu(BigDecimal r28_no_of_accounts_uae_abu) {
		this.r28_no_of_accounts_uae_abu = r28_no_of_accounts_uae_abu;
	}
	public BigDecimal getR28_amount_uae_abu() {
		return r28_amount_uae_abu;
	}
	public void setR28_amount_uae_abu(BigDecimal r28_amount_uae_abu) {
		this.r28_amount_uae_abu = r28_amount_uae_abu;
	}
	public BigDecimal getR28_no_of_accounts_non_uae_abu() {
		return r28_no_of_accounts_non_uae_abu;
	}
	public void setR28_no_of_accounts_non_uae_abu(BigDecimal r28_no_of_accounts_non_uae_abu) {
		this.r28_no_of_accounts_non_uae_abu = r28_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR28_amount_non_uae_abu() {
		return r28_amount_non_uae_abu;
	}
	public void setR28_amount_non_uae_abu(BigDecimal r28_amount_non_uae_abu) {
		this.r28_amount_non_uae_abu = r28_amount_non_uae_abu;
	}
	public BigDecimal getR28_total_abu() {
		return r28_total_abu;
	}
	public void setR28_total_abu(BigDecimal r28_total_abu) {
		this.r28_total_abu = r28_total_abu;
	}
	public BigDecimal getR28_no_of_accounts_uae_dubai() {
		return r28_no_of_accounts_uae_dubai;
	}
	public void setR28_no_of_accounts_uae_dubai(BigDecimal r28_no_of_accounts_uae_dubai) {
		this.r28_no_of_accounts_uae_dubai = r28_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR28_amount_uae_dubai() {
		return r28_amount_uae_dubai;
	}
	public void setR28_amount_uae_dubai(BigDecimal r28_amount_uae_dubai) {
		this.r28_amount_uae_dubai = r28_amount_uae_dubai;
	}
	public BigDecimal getR28_no_of_accounts_non_uae_dubai() {
		return r28_no_of_accounts_non_uae_dubai;
	}
	public void setR28_no_of_accounts_non_uae_dubai(BigDecimal r28_no_of_accounts_non_uae_dubai) {
		this.r28_no_of_accounts_non_uae_dubai = r28_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR28_amount_non_uae_dubai() {
		return r28_amount_non_uae_dubai;
	}
	public void setR28_amount_non_uae_dubai(BigDecimal r28_amount_non_uae_dubai) {
		this.r28_amount_non_uae_dubai = r28_amount_non_uae_dubai;
	}
	public BigDecimal getR28_total_dubai() {
		return r28_total_dubai;
	}
	public void setR28_total_dubai(BigDecimal r28_total_dubai) {
		this.r28_total_dubai = r28_total_dubai;
	}
	public BigDecimal getR28_no_of_accounts_uae_sharjah() {
		return r28_no_of_accounts_uae_sharjah;
	}
	public void setR28_no_of_accounts_uae_sharjah(BigDecimal r28_no_of_accounts_uae_sharjah) {
		this.r28_no_of_accounts_uae_sharjah = r28_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR28_amount_uae_sharjah() {
		return r28_amount_uae_sharjah;
	}
	public void setR28_amount_uae_sharjah(BigDecimal r28_amount_uae_sharjah) {
		this.r28_amount_uae_sharjah = r28_amount_uae_sharjah;
	}
	public BigDecimal getR28_no_of_accounts_non_uae_sharjah() {
		return r28_no_of_accounts_non_uae_sharjah;
	}
	public void setR28_no_of_accounts_non_uae_sharjah(BigDecimal r28_no_of_accounts_non_uae_sharjah) {
		this.r28_no_of_accounts_non_uae_sharjah = r28_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR28_amount_non_uae_sharjah() {
		return r28_amount_non_uae_sharjah;
	}
	public void setR28_amount_non_uae_sharjah(BigDecimal r28_amount_non_uae_sharjah) {
		this.r28_amount_non_uae_sharjah = r28_amount_non_uae_sharjah;
	}
	public BigDecimal getR28_total_sharjah() {
		return r28_total_sharjah;
	}
	public void setR28_total_sharjah(BigDecimal r28_total_sharjah) {
		this.r28_total_sharjah = r28_total_sharjah;
	}
	public BigDecimal getR28_no_of_accounts_uae_ajman() {
		return r28_no_of_accounts_uae_ajman;
	}
	public void setR28_no_of_accounts_uae_ajman(BigDecimal r28_no_of_accounts_uae_ajman) {
		this.r28_no_of_accounts_uae_ajman = r28_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR28_amount_uae_ajman() {
		return r28_amount_uae_ajman;
	}
	public void setR28_amount_uae_ajman(BigDecimal r28_amount_uae_ajman) {
		this.r28_amount_uae_ajman = r28_amount_uae_ajman;
	}
	public BigDecimal getR28_no_of_accounts_non_uae_ajman() {
		return r28_no_of_accounts_non_uae_ajman;
	}
	public void setR28_no_of_accounts_non_uae_ajman(BigDecimal r28_no_of_accounts_non_uae_ajman) {
		this.r28_no_of_accounts_non_uae_ajman = r28_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR28_amount_non_uae_ajman() {
		return r28_amount_non_uae_ajman;
	}
	public void setR28_amount_non_uae_ajman(BigDecimal r28_amount_non_uae_ajman) {
		this.r28_amount_non_uae_ajman = r28_amount_non_uae_ajman;
	}
	public BigDecimal getR28_total_ajman() {
		return r28_total_ajman;
	}
	public void setR28_total_ajman(BigDecimal r28_total_ajman) {
		this.r28_total_ajman = r28_total_ajman;
	}
	public BigDecimal getR28_no_of_accounts_uae_ras() {
		return r28_no_of_accounts_uae_ras;
	}
	public void setR28_no_of_accounts_uae_ras(BigDecimal r28_no_of_accounts_uae_ras) {
		this.r28_no_of_accounts_uae_ras = r28_no_of_accounts_uae_ras;
	}
	public BigDecimal getR28_amount_uae_ras() {
		return r28_amount_uae_ras;
	}
	public void setR28_amount_uae_ras(BigDecimal r28_amount_uae_ras) {
		this.r28_amount_uae_ras = r28_amount_uae_ras;
	}
	public BigDecimal getR28_no_of_accounts_non_uae_ras() {
		return r28_no_of_accounts_non_uae_ras;
	}
	public void setR28_no_of_accounts_non_uae_ras(BigDecimal r28_no_of_accounts_non_uae_ras) {
		this.r28_no_of_accounts_non_uae_ras = r28_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR28_amount_non_uae_ras() {
		return r28_amount_non_uae_ras;
	}
	public void setR28_amount_non_uae_ras(BigDecimal r28_amount_non_uae_ras) {
		this.r28_amount_non_uae_ras = r28_amount_non_uae_ras;
	}
	public BigDecimal getR28_total_ras() {
		return r28_total_ras;
	}
	public void setR28_total_ras(BigDecimal r28_total_ras) {
		this.r28_total_ras = r28_total_ras;
	}
	public BigDecimal getR28_no_of_accounts_uae_umm() {
		return r28_no_of_accounts_uae_umm;
	}
	public void setR28_no_of_accounts_uae_umm(BigDecimal r28_no_of_accounts_uae_umm) {
		this.r28_no_of_accounts_uae_umm = r28_no_of_accounts_uae_umm;
	}
	public BigDecimal getR28_amount_uae_umm() {
		return r28_amount_uae_umm;
	}
	public void setR28_amount_uae_umm(BigDecimal r28_amount_uae_umm) {
		this.r28_amount_uae_umm = r28_amount_uae_umm;
	}
	public BigDecimal getR28_no_of_accounts_non_uae_umm() {
		return r28_no_of_accounts_non_uae_umm;
	}
	public void setR28_no_of_accounts_non_uae_umm(BigDecimal r28_no_of_accounts_non_uae_umm) {
		this.r28_no_of_accounts_non_uae_umm = r28_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR28_amount_non_uae_umm() {
		return r28_amount_non_uae_umm;
	}
	public void setR28_amount_non_uae_umm(BigDecimal r28_amount_non_uae_umm) {
		this.r28_amount_non_uae_umm = r28_amount_non_uae_umm;
	}
	public BigDecimal getR28_total_umm() {
		return r28_total_umm;
	}
	public void setR28_total_umm(BigDecimal r28_total_umm) {
		this.r28_total_umm = r28_total_umm;
	}
	public BigDecimal getR28_no_of_accounts_uae_fujairah() {
		return r28_no_of_accounts_uae_fujairah;
	}
	public void setR28_no_of_accounts_uae_fujairah(BigDecimal r28_no_of_accounts_uae_fujairah) {
		this.r28_no_of_accounts_uae_fujairah = r28_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR28_amount_uae_fujairah() {
		return r28_amount_uae_fujairah;
	}
	public void setR28_amount_uae_fujairah(BigDecimal r28_amount_uae_fujairah) {
		this.r28_amount_uae_fujairah = r28_amount_uae_fujairah;
	}
	public BigDecimal getR28_no_of_accounts_non_uae_fujairah() {
		return r28_no_of_accounts_non_uae_fujairah;
	}
	public void setR28_no_of_accounts_non_uae_fujairah(BigDecimal r28_no_of_accounts_non_uae_fujairah) {
		this.r28_no_of_accounts_non_uae_fujairah = r28_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR28_amount_non_uae_fujairah() {
		return r28_amount_non_uae_fujairah;
	}
	public void setR28_amount_non_uae_fujairah(BigDecimal r28_amount_non_uae_fujairah) {
		this.r28_amount_non_uae_fujairah = r28_amount_non_uae_fujairah;
	}
	public BigDecimal getR28_total_fujairah() {
		return r28_total_fujairah;
	}
	public void setR28_total_fujairah(BigDecimal r28_total_fujairah) {
		this.r28_total_fujairah = r28_total_fujairah;
	}
	public String getR29_product() {
		return r29_product;
	}
	public void setR29_product(String r29_product) {
		this.r29_product = r29_product;
	}
	public BigDecimal getR29_no_of_accounts_uae() {
		return r29_no_of_accounts_uae;
	}
	public void setR29_no_of_accounts_uae(BigDecimal r29_no_of_accounts_uae) {
		this.r29_no_of_accounts_uae = r29_no_of_accounts_uae;
	}
	public BigDecimal getR29_amount_uae() {
		return r29_amount_uae;
	}
	public void setR29_amount_uae(BigDecimal r29_amount_uae) {
		this.r29_amount_uae = r29_amount_uae;
	}
	public BigDecimal getR29_no_of_accounts_resident() {
		return r29_no_of_accounts_resident;
	}
	public void setR29_no_of_accounts_resident(BigDecimal r29_no_of_accounts_resident) {
		this.r29_no_of_accounts_resident = r29_no_of_accounts_resident;
	}
	public BigDecimal getR29_amount_resident() {
		return r29_amount_resident;
	}
	public void setR29_amount_resident(BigDecimal r29_amount_resident) {
		this.r29_amount_resident = r29_amount_resident;
	}
	public BigDecimal getR29_no_of_accounts_non_resident() {
		return r29_no_of_accounts_non_resident;
	}
	public void setR29_no_of_accounts_non_resident(BigDecimal r29_no_of_accounts_non_resident) {
		this.r29_no_of_accounts_non_resident = r29_no_of_accounts_non_resident;
	}
	public BigDecimal getR29_amount_non_resident() {
		return r29_amount_non_resident;
	}
	public void setR29_amount_non_resident(BigDecimal r29_amount_non_resident) {
		this.r29_amount_non_resident = r29_amount_non_resident;
	}
	public BigDecimal getR29_total_account() {
		return r29_total_account;
	}
	public void setR29_total_account(BigDecimal r29_total_account) {
		this.r29_total_account = r29_total_account;
	}
	public BigDecimal getR29_total_amount() {
		return r29_total_amount;
	}
	public void setR29_total_amount(BigDecimal r29_total_amount) {
		this.r29_total_amount = r29_total_amount;
	}
	public BigDecimal getR29_no_of_accounts_uae_abu() {
		return r29_no_of_accounts_uae_abu;
	}
	public void setR29_no_of_accounts_uae_abu(BigDecimal r29_no_of_accounts_uae_abu) {
		this.r29_no_of_accounts_uae_abu = r29_no_of_accounts_uae_abu;
	}
	public BigDecimal getR29_amount_uae_abu() {
		return r29_amount_uae_abu;
	}
	public void setR29_amount_uae_abu(BigDecimal r29_amount_uae_abu) {
		this.r29_amount_uae_abu = r29_amount_uae_abu;
	}
	public BigDecimal getR29_no_of_accounts_non_uae_abu() {
		return r29_no_of_accounts_non_uae_abu;
	}
	public void setR29_no_of_accounts_non_uae_abu(BigDecimal r29_no_of_accounts_non_uae_abu) {
		this.r29_no_of_accounts_non_uae_abu = r29_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR29_amount_non_uae_abu() {
		return r29_amount_non_uae_abu;
	}
	public void setR29_amount_non_uae_abu(BigDecimal r29_amount_non_uae_abu) {
		this.r29_amount_non_uae_abu = r29_amount_non_uae_abu;
	}
	public BigDecimal getR29_total_abu() {
		return r29_total_abu;
	}
	public void setR29_total_abu(BigDecimal r29_total_abu) {
		this.r29_total_abu = r29_total_abu;
	}
	public BigDecimal getR29_no_of_accounts_uae_dubai() {
		return r29_no_of_accounts_uae_dubai;
	}
	public void setR29_no_of_accounts_uae_dubai(BigDecimal r29_no_of_accounts_uae_dubai) {
		this.r29_no_of_accounts_uae_dubai = r29_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR29_amount_uae_dubai() {
		return r29_amount_uae_dubai;
	}
	public void setR29_amount_uae_dubai(BigDecimal r29_amount_uae_dubai) {
		this.r29_amount_uae_dubai = r29_amount_uae_dubai;
	}
	public BigDecimal getR29_no_of_accounts_non_uae_dubai() {
		return r29_no_of_accounts_non_uae_dubai;
	}
	public void setR29_no_of_accounts_non_uae_dubai(BigDecimal r29_no_of_accounts_non_uae_dubai) {
		this.r29_no_of_accounts_non_uae_dubai = r29_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR29_amount_non_uae_dubai() {
		return r29_amount_non_uae_dubai;
	}
	public void setR29_amount_non_uae_dubai(BigDecimal r29_amount_non_uae_dubai) {
		this.r29_amount_non_uae_dubai = r29_amount_non_uae_dubai;
	}
	public BigDecimal getR29_total_dubai() {
		return r29_total_dubai;
	}
	public void setR29_total_dubai(BigDecimal r29_total_dubai) {
		this.r29_total_dubai = r29_total_dubai;
	}
	public BigDecimal getR29_no_of_accounts_uae_sharjah() {
		return r29_no_of_accounts_uae_sharjah;
	}
	public void setR29_no_of_accounts_uae_sharjah(BigDecimal r29_no_of_accounts_uae_sharjah) {
		this.r29_no_of_accounts_uae_sharjah = r29_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR29_amount_uae_sharjah() {
		return r29_amount_uae_sharjah;
	}
	public void setR29_amount_uae_sharjah(BigDecimal r29_amount_uae_sharjah) {
		this.r29_amount_uae_sharjah = r29_amount_uae_sharjah;
	}
	public BigDecimal getR29_no_of_accounts_non_uae_sharjah() {
		return r29_no_of_accounts_non_uae_sharjah;
	}
	public void setR29_no_of_accounts_non_uae_sharjah(BigDecimal r29_no_of_accounts_non_uae_sharjah) {
		this.r29_no_of_accounts_non_uae_sharjah = r29_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR29_amount_non_uae_sharjah() {
		return r29_amount_non_uae_sharjah;
	}
	public void setR29_amount_non_uae_sharjah(BigDecimal r29_amount_non_uae_sharjah) {
		this.r29_amount_non_uae_sharjah = r29_amount_non_uae_sharjah;
	}
	public BigDecimal getR29_total_sharjah() {
		return r29_total_sharjah;
	}
	public void setR29_total_sharjah(BigDecimal r29_total_sharjah) {
		this.r29_total_sharjah = r29_total_sharjah;
	}
	public BigDecimal getR29_no_of_accounts_uae_ajman() {
		return r29_no_of_accounts_uae_ajman;
	}
	public void setR29_no_of_accounts_uae_ajman(BigDecimal r29_no_of_accounts_uae_ajman) {
		this.r29_no_of_accounts_uae_ajman = r29_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR29_amount_uae_ajman() {
		return r29_amount_uae_ajman;
	}
	public void setR29_amount_uae_ajman(BigDecimal r29_amount_uae_ajman) {
		this.r29_amount_uae_ajman = r29_amount_uae_ajman;
	}
	public BigDecimal getR29_no_of_accounts_non_uae_ajman() {
		return r29_no_of_accounts_non_uae_ajman;
	}
	public void setR29_no_of_accounts_non_uae_ajman(BigDecimal r29_no_of_accounts_non_uae_ajman) {
		this.r29_no_of_accounts_non_uae_ajman = r29_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR29_amount_non_uae_ajman() {
		return r29_amount_non_uae_ajman;
	}
	public void setR29_amount_non_uae_ajman(BigDecimal r29_amount_non_uae_ajman) {
		this.r29_amount_non_uae_ajman = r29_amount_non_uae_ajman;
	}
	public BigDecimal getR29_total_ajman() {
		return r29_total_ajman;
	}
	public void setR29_total_ajman(BigDecimal r29_total_ajman) {
		this.r29_total_ajman = r29_total_ajman;
	}
	public BigDecimal getR29_no_of_accounts_uae_ras() {
		return r29_no_of_accounts_uae_ras;
	}
	public void setR29_no_of_accounts_uae_ras(BigDecimal r29_no_of_accounts_uae_ras) {
		this.r29_no_of_accounts_uae_ras = r29_no_of_accounts_uae_ras;
	}
	public BigDecimal getR29_amount_uae_ras() {
		return r29_amount_uae_ras;
	}
	public void setR29_amount_uae_ras(BigDecimal r29_amount_uae_ras) {
		this.r29_amount_uae_ras = r29_amount_uae_ras;
	}
	public BigDecimal getR29_no_of_accounts_non_uae_ras() {
		return r29_no_of_accounts_non_uae_ras;
	}
	public void setR29_no_of_accounts_non_uae_ras(BigDecimal r29_no_of_accounts_non_uae_ras) {
		this.r29_no_of_accounts_non_uae_ras = r29_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR29_amount_non_uae_ras() {
		return r29_amount_non_uae_ras;
	}
	public void setR29_amount_non_uae_ras(BigDecimal r29_amount_non_uae_ras) {
		this.r29_amount_non_uae_ras = r29_amount_non_uae_ras;
	}
	public BigDecimal getR29_total_ras() {
		return r29_total_ras;
	}
	public void setR29_total_ras(BigDecimal r29_total_ras) {
		this.r29_total_ras = r29_total_ras;
	}
	public BigDecimal getR29_no_of_accounts_uae_umm() {
		return r29_no_of_accounts_uae_umm;
	}
	public void setR29_no_of_accounts_uae_umm(BigDecimal r29_no_of_accounts_uae_umm) {
		this.r29_no_of_accounts_uae_umm = r29_no_of_accounts_uae_umm;
	}
	public BigDecimal getR29_amount_uae_umm() {
		return r29_amount_uae_umm;
	}
	public void setR29_amount_uae_umm(BigDecimal r29_amount_uae_umm) {
		this.r29_amount_uae_umm = r29_amount_uae_umm;
	}
	public BigDecimal getR29_no_of_accounts_non_uae_umm() {
		return r29_no_of_accounts_non_uae_umm;
	}
	public void setR29_no_of_accounts_non_uae_umm(BigDecimal r29_no_of_accounts_non_uae_umm) {
		this.r29_no_of_accounts_non_uae_umm = r29_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR29_amount_non_uae_umm() {
		return r29_amount_non_uae_umm;
	}
	public void setR29_amount_non_uae_umm(BigDecimal r29_amount_non_uae_umm) {
		this.r29_amount_non_uae_umm = r29_amount_non_uae_umm;
	}
	public BigDecimal getR29_total_umm() {
		return r29_total_umm;
	}
	public void setR29_total_umm(BigDecimal r29_total_umm) {
		this.r29_total_umm = r29_total_umm;
	}
	public BigDecimal getR29_no_of_accounts_uae_fujairah() {
		return r29_no_of_accounts_uae_fujairah;
	}
	public void setR29_no_of_accounts_uae_fujairah(BigDecimal r29_no_of_accounts_uae_fujairah) {
		this.r29_no_of_accounts_uae_fujairah = r29_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR29_amount_uae_fujairah() {
		return r29_amount_uae_fujairah;
	}
	public void setR29_amount_uae_fujairah(BigDecimal r29_amount_uae_fujairah) {
		this.r29_amount_uae_fujairah = r29_amount_uae_fujairah;
	}
	public BigDecimal getR29_no_of_accounts_non_uae_fujairah() {
		return r29_no_of_accounts_non_uae_fujairah;
	}
	public void setR29_no_of_accounts_non_uae_fujairah(BigDecimal r29_no_of_accounts_non_uae_fujairah) {
		this.r29_no_of_accounts_non_uae_fujairah = r29_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR29_amount_non_uae_fujairah() {
		return r29_amount_non_uae_fujairah;
	}
	public void setR29_amount_non_uae_fujairah(BigDecimal r29_amount_non_uae_fujairah) {
		this.r29_amount_non_uae_fujairah = r29_amount_non_uae_fujairah;
	}
	public BigDecimal getR29_total_fujairah() {
		return r29_total_fujairah;
	}
	public void setR29_total_fujairah(BigDecimal r29_total_fujairah) {
		this.r29_total_fujairah = r29_total_fujairah;
	}
	public String getR30_product() {
		return r30_product;
	}
	public void setR30_product(String r30_product) {
		this.r30_product = r30_product;
	}
	public BigDecimal getR30_no_of_accounts_uae() {
		return r30_no_of_accounts_uae;
	}
	public void setR30_no_of_accounts_uae(BigDecimal r30_no_of_accounts_uae) {
		this.r30_no_of_accounts_uae = r30_no_of_accounts_uae;
	}
	public BigDecimal getR30_amount_uae() {
		return r30_amount_uae;
	}
	public void setR30_amount_uae(BigDecimal r30_amount_uae) {
		this.r30_amount_uae = r30_amount_uae;
	}
	public BigDecimal getR30_no_of_accounts_resident() {
		return r30_no_of_accounts_resident;
	}
	public void setR30_no_of_accounts_resident(BigDecimal r30_no_of_accounts_resident) {
		this.r30_no_of_accounts_resident = r30_no_of_accounts_resident;
	}
	public BigDecimal getR30_amount_resident() {
		return r30_amount_resident;
	}
	public void setR30_amount_resident(BigDecimal r30_amount_resident) {
		this.r30_amount_resident = r30_amount_resident;
	}
	public BigDecimal getR30_no_of_accounts_non_resident() {
		return r30_no_of_accounts_non_resident;
	}
	public void setR30_no_of_accounts_non_resident(BigDecimal r30_no_of_accounts_non_resident) {
		this.r30_no_of_accounts_non_resident = r30_no_of_accounts_non_resident;
	}
	public BigDecimal getR30_amount_non_resident() {
		return r30_amount_non_resident;
	}
	public void setR30_amount_non_resident(BigDecimal r30_amount_non_resident) {
		this.r30_amount_non_resident = r30_amount_non_resident;
	}
	public BigDecimal getR30_total_account() {
		return r30_total_account;
	}
	public void setR30_total_account(BigDecimal r30_total_account) {
		this.r30_total_account = r30_total_account;
	}
	public BigDecimal getR30_total_amount() {
		return r30_total_amount;
	}
	public void setR30_total_amount(BigDecimal r30_total_amount) {
		this.r30_total_amount = r30_total_amount;
	}
	public BigDecimal getR30_no_of_accounts_uae_abu() {
		return r30_no_of_accounts_uae_abu;
	}
	public void setR30_no_of_accounts_uae_abu(BigDecimal r30_no_of_accounts_uae_abu) {
		this.r30_no_of_accounts_uae_abu = r30_no_of_accounts_uae_abu;
	}
	public BigDecimal getR30_amount_uae_abu() {
		return r30_amount_uae_abu;
	}
	public void setR30_amount_uae_abu(BigDecimal r30_amount_uae_abu) {
		this.r30_amount_uae_abu = r30_amount_uae_abu;
	}
	public BigDecimal getR30_no_of_accounts_non_uae_abu() {
		return r30_no_of_accounts_non_uae_abu;
	}
	public void setR30_no_of_accounts_non_uae_abu(BigDecimal r30_no_of_accounts_non_uae_abu) {
		this.r30_no_of_accounts_non_uae_abu = r30_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR30_amount_non_uae_abu() {
		return r30_amount_non_uae_abu;
	}
	public void setR30_amount_non_uae_abu(BigDecimal r30_amount_non_uae_abu) {
		this.r30_amount_non_uae_abu = r30_amount_non_uae_abu;
	}
	public BigDecimal getR30_total_abu() {
		return r30_total_abu;
	}
	public void setR30_total_abu(BigDecimal r30_total_abu) {
		this.r30_total_abu = r30_total_abu;
	}
	public BigDecimal getR30_no_of_accounts_uae_dubai() {
		return r30_no_of_accounts_uae_dubai;
	}
	public void setR30_no_of_accounts_uae_dubai(BigDecimal r30_no_of_accounts_uae_dubai) {
		this.r30_no_of_accounts_uae_dubai = r30_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR30_amount_uae_dubai() {
		return r30_amount_uae_dubai;
	}
	public void setR30_amount_uae_dubai(BigDecimal r30_amount_uae_dubai) {
		this.r30_amount_uae_dubai = r30_amount_uae_dubai;
	}
	public BigDecimal getR30_no_of_accounts_non_uae_dubai() {
		return r30_no_of_accounts_non_uae_dubai;
	}
	public void setR30_no_of_accounts_non_uae_dubai(BigDecimal r30_no_of_accounts_non_uae_dubai) {
		this.r30_no_of_accounts_non_uae_dubai = r30_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR30_amount_non_uae_dubai() {
		return r30_amount_non_uae_dubai;
	}
	public void setR30_amount_non_uae_dubai(BigDecimal r30_amount_non_uae_dubai) {
		this.r30_amount_non_uae_dubai = r30_amount_non_uae_dubai;
	}
	public BigDecimal getR30_total_dubai() {
		return r30_total_dubai;
	}
	public void setR30_total_dubai(BigDecimal r30_total_dubai) {
		this.r30_total_dubai = r30_total_dubai;
	}
	public BigDecimal getR30_no_of_accounts_uae_sharjah() {
		return r30_no_of_accounts_uae_sharjah;
	}
	public void setR30_no_of_accounts_uae_sharjah(BigDecimal r30_no_of_accounts_uae_sharjah) {
		this.r30_no_of_accounts_uae_sharjah = r30_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR30_amount_uae_sharjah() {
		return r30_amount_uae_sharjah;
	}
	public void setR30_amount_uae_sharjah(BigDecimal r30_amount_uae_sharjah) {
		this.r30_amount_uae_sharjah = r30_amount_uae_sharjah;
	}
	public BigDecimal getR30_no_of_accounts_non_uae_sharjah() {
		return r30_no_of_accounts_non_uae_sharjah;
	}
	public void setR30_no_of_accounts_non_uae_sharjah(BigDecimal r30_no_of_accounts_non_uae_sharjah) {
		this.r30_no_of_accounts_non_uae_sharjah = r30_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR30_amount_non_uae_sharjah() {
		return r30_amount_non_uae_sharjah;
	}
	public void setR30_amount_non_uae_sharjah(BigDecimal r30_amount_non_uae_sharjah) {
		this.r30_amount_non_uae_sharjah = r30_amount_non_uae_sharjah;
	}
	public BigDecimal getR30_total_sharjah() {
		return r30_total_sharjah;
	}
	public void setR30_total_sharjah(BigDecimal r30_total_sharjah) {
		this.r30_total_sharjah = r30_total_sharjah;
	}
	public BigDecimal getR30_no_of_accounts_uae_ajman() {
		return r30_no_of_accounts_uae_ajman;
	}
	public void setR30_no_of_accounts_uae_ajman(BigDecimal r30_no_of_accounts_uae_ajman) {
		this.r30_no_of_accounts_uae_ajman = r30_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR30_amount_uae_ajman() {
		return r30_amount_uae_ajman;
	}
	public void setR30_amount_uae_ajman(BigDecimal r30_amount_uae_ajman) {
		this.r30_amount_uae_ajman = r30_amount_uae_ajman;
	}
	public BigDecimal getR30_no_of_accounts_non_uae_ajman() {
		return r30_no_of_accounts_non_uae_ajman;
	}
	public void setR30_no_of_accounts_non_uae_ajman(BigDecimal r30_no_of_accounts_non_uae_ajman) {
		this.r30_no_of_accounts_non_uae_ajman = r30_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR30_amount_non_uae_ajman() {
		return r30_amount_non_uae_ajman;
	}
	public void setR30_amount_non_uae_ajman(BigDecimal r30_amount_non_uae_ajman) {
		this.r30_amount_non_uae_ajman = r30_amount_non_uae_ajman;
	}
	public BigDecimal getR30_total_ajman() {
		return r30_total_ajman;
	}
	public void setR30_total_ajman(BigDecimal r30_total_ajman) {
		this.r30_total_ajman = r30_total_ajman;
	}
	public BigDecimal getR30_no_of_accounts_uae_ras() {
		return r30_no_of_accounts_uae_ras;
	}
	public void setR30_no_of_accounts_uae_ras(BigDecimal r30_no_of_accounts_uae_ras) {
		this.r30_no_of_accounts_uae_ras = r30_no_of_accounts_uae_ras;
	}
	public BigDecimal getR30_amount_uae_ras() {
		return r30_amount_uae_ras;
	}
	public void setR30_amount_uae_ras(BigDecimal r30_amount_uae_ras) {
		this.r30_amount_uae_ras = r30_amount_uae_ras;
	}
	public BigDecimal getR30_no_of_accounts_non_uae_ras() {
		return r30_no_of_accounts_non_uae_ras;
	}
	public void setR30_no_of_accounts_non_uae_ras(BigDecimal r30_no_of_accounts_non_uae_ras) {
		this.r30_no_of_accounts_non_uae_ras = r30_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR30_amount_non_uae_ras() {
		return r30_amount_non_uae_ras;
	}
	public void setR30_amount_non_uae_ras(BigDecimal r30_amount_non_uae_ras) {
		this.r30_amount_non_uae_ras = r30_amount_non_uae_ras;
	}
	public BigDecimal getR30_total_ras() {
		return r30_total_ras;
	}
	public void setR30_total_ras(BigDecimal r30_total_ras) {
		this.r30_total_ras = r30_total_ras;
	}
	public BigDecimal getR30_no_of_accounts_uae_umm() {
		return r30_no_of_accounts_uae_umm;
	}
	public void setR30_no_of_accounts_uae_umm(BigDecimal r30_no_of_accounts_uae_umm) {
		this.r30_no_of_accounts_uae_umm = r30_no_of_accounts_uae_umm;
	}
	public BigDecimal getR30_amount_uae_umm() {
		return r30_amount_uae_umm;
	}
	public void setR30_amount_uae_umm(BigDecimal r30_amount_uae_umm) {
		this.r30_amount_uae_umm = r30_amount_uae_umm;
	}
	public BigDecimal getR30_no_of_accounts_non_uae_umm() {
		return r30_no_of_accounts_non_uae_umm;
	}
	public void setR30_no_of_accounts_non_uae_umm(BigDecimal r30_no_of_accounts_non_uae_umm) {
		this.r30_no_of_accounts_non_uae_umm = r30_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR30_amount_non_uae_umm() {
		return r30_amount_non_uae_umm;
	}
	public void setR30_amount_non_uae_umm(BigDecimal r30_amount_non_uae_umm) {
		this.r30_amount_non_uae_umm = r30_amount_non_uae_umm;
	}
	public BigDecimal getR30_total_umm() {
		return r30_total_umm;
	}
	public void setR30_total_umm(BigDecimal r30_total_umm) {
		this.r30_total_umm = r30_total_umm;
	}
	public BigDecimal getR30_no_of_accounts_uae_fujairah() {
		return r30_no_of_accounts_uae_fujairah;
	}
	public void setR30_no_of_accounts_uae_fujairah(BigDecimal r30_no_of_accounts_uae_fujairah) {
		this.r30_no_of_accounts_uae_fujairah = r30_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR30_amount_uae_fujairah() {
		return r30_amount_uae_fujairah;
	}
	public void setR30_amount_uae_fujairah(BigDecimal r30_amount_uae_fujairah) {
		this.r30_amount_uae_fujairah = r30_amount_uae_fujairah;
	}
	public BigDecimal getR30_no_of_accounts_non_uae_fujairah() {
		return r30_no_of_accounts_non_uae_fujairah;
	}
	public void setR30_no_of_accounts_non_uae_fujairah(BigDecimal r30_no_of_accounts_non_uae_fujairah) {
		this.r30_no_of_accounts_non_uae_fujairah = r30_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR30_amount_non_uae_fujairah() {
		return r30_amount_non_uae_fujairah;
	}
	public void setR30_amount_non_uae_fujairah(BigDecimal r30_amount_non_uae_fujairah) {
		this.r30_amount_non_uae_fujairah = r30_amount_non_uae_fujairah;
	}
	public BigDecimal getR30_total_fujairah() {
		return r30_total_fujairah;
	}
	public void setR30_total_fujairah(BigDecimal r30_total_fujairah) {
		this.r30_total_fujairah = r30_total_fujairah;
	}
	public String getR31_product() {
		return r31_product;
	}
	public void setR31_product(String r31_product) {
		this.r31_product = r31_product;
	}
	public BigDecimal getR31_no_of_accounts_uae() {
		return r31_no_of_accounts_uae;
	}
	public void setR31_no_of_accounts_uae(BigDecimal r31_no_of_accounts_uae) {
		this.r31_no_of_accounts_uae = r31_no_of_accounts_uae;
	}
	public BigDecimal getR31_amount_uae() {
		return r31_amount_uae;
	}
	public void setR31_amount_uae(BigDecimal r31_amount_uae) {
		this.r31_amount_uae = r31_amount_uae;
	}
	public BigDecimal getR31_no_of_accounts_resident() {
		return r31_no_of_accounts_resident;
	}
	public void setR31_no_of_accounts_resident(BigDecimal r31_no_of_accounts_resident) {
		this.r31_no_of_accounts_resident = r31_no_of_accounts_resident;
	}
	public BigDecimal getR31_amount_resident() {
		return r31_amount_resident;
	}
	public void setR31_amount_resident(BigDecimal r31_amount_resident) {
		this.r31_amount_resident = r31_amount_resident;
	}
	public BigDecimal getR31_no_of_accounts_non_resident() {
		return r31_no_of_accounts_non_resident;
	}
	public void setR31_no_of_accounts_non_resident(BigDecimal r31_no_of_accounts_non_resident) {
		this.r31_no_of_accounts_non_resident = r31_no_of_accounts_non_resident;
	}
	public BigDecimal getR31_amount_non_resident() {
		return r31_amount_non_resident;
	}
	public void setR31_amount_non_resident(BigDecimal r31_amount_non_resident) {
		this.r31_amount_non_resident = r31_amount_non_resident;
	}
	public BigDecimal getR31_total_account() {
		return r31_total_account;
	}
	public void setR31_total_account(BigDecimal r31_total_account) {
		this.r31_total_account = r31_total_account;
	}
	public BigDecimal getR31_total_amount() {
		return r31_total_amount;
	}
	public void setR31_total_amount(BigDecimal r31_total_amount) {
		this.r31_total_amount = r31_total_amount;
	}
	public BigDecimal getR31_no_of_accounts_uae_abu() {
		return r31_no_of_accounts_uae_abu;
	}
	public void setR31_no_of_accounts_uae_abu(BigDecimal r31_no_of_accounts_uae_abu) {
		this.r31_no_of_accounts_uae_abu = r31_no_of_accounts_uae_abu;
	}
	public BigDecimal getR31_amount_uae_abu() {
		return r31_amount_uae_abu;
	}
	public void setR31_amount_uae_abu(BigDecimal r31_amount_uae_abu) {
		this.r31_amount_uae_abu = r31_amount_uae_abu;
	}
	public BigDecimal getR31_no_of_accounts_non_uae_abu() {
		return r31_no_of_accounts_non_uae_abu;
	}
	public void setR31_no_of_accounts_non_uae_abu(BigDecimal r31_no_of_accounts_non_uae_abu) {
		this.r31_no_of_accounts_non_uae_abu = r31_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR31_amount_non_uae_abu() {
		return r31_amount_non_uae_abu;
	}
	public void setR31_amount_non_uae_abu(BigDecimal r31_amount_non_uae_abu) {
		this.r31_amount_non_uae_abu = r31_amount_non_uae_abu;
	}
	public BigDecimal getR31_total_abu() {
		return r31_total_abu;
	}
	public void setR31_total_abu(BigDecimal r31_total_abu) {
		this.r31_total_abu = r31_total_abu;
	}
	public BigDecimal getR31_no_of_accounts_uae_dubai() {
		return r31_no_of_accounts_uae_dubai;
	}
	public void setR31_no_of_accounts_uae_dubai(BigDecimal r31_no_of_accounts_uae_dubai) {
		this.r31_no_of_accounts_uae_dubai = r31_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR31_amount_uae_dubai() {
		return r31_amount_uae_dubai;
	}
	public void setR31_amount_uae_dubai(BigDecimal r31_amount_uae_dubai) {
		this.r31_amount_uae_dubai = r31_amount_uae_dubai;
	}
	public BigDecimal getR31_no_of_accounts_non_uae_dubai() {
		return r31_no_of_accounts_non_uae_dubai;
	}
	public void setR31_no_of_accounts_non_uae_dubai(BigDecimal r31_no_of_accounts_non_uae_dubai) {
		this.r31_no_of_accounts_non_uae_dubai = r31_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR31_amount_non_uae_dubai() {
		return r31_amount_non_uae_dubai;
	}
	public void setR31_amount_non_uae_dubai(BigDecimal r31_amount_non_uae_dubai) {
		this.r31_amount_non_uae_dubai = r31_amount_non_uae_dubai;
	}
	public BigDecimal getR31_total_dubai() {
		return r31_total_dubai;
	}
	public void setR31_total_dubai(BigDecimal r31_total_dubai) {
		this.r31_total_dubai = r31_total_dubai;
	}
	public BigDecimal getR31_no_of_accounts_uae_sharjah() {
		return r31_no_of_accounts_uae_sharjah;
	}
	public void setR31_no_of_accounts_uae_sharjah(BigDecimal r31_no_of_accounts_uae_sharjah) {
		this.r31_no_of_accounts_uae_sharjah = r31_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR31_amount_uae_sharjah() {
		return r31_amount_uae_sharjah;
	}
	public void setR31_amount_uae_sharjah(BigDecimal r31_amount_uae_sharjah) {
		this.r31_amount_uae_sharjah = r31_amount_uae_sharjah;
	}
	public BigDecimal getR31_no_of_accounts_non_uae_sharjah() {
		return r31_no_of_accounts_non_uae_sharjah;
	}
	public void setR31_no_of_accounts_non_uae_sharjah(BigDecimal r31_no_of_accounts_non_uae_sharjah) {
		this.r31_no_of_accounts_non_uae_sharjah = r31_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR31_amount_non_uae_sharjah() {
		return r31_amount_non_uae_sharjah;
	}
	public void setR31_amount_non_uae_sharjah(BigDecimal r31_amount_non_uae_sharjah) {
		this.r31_amount_non_uae_sharjah = r31_amount_non_uae_sharjah;
	}
	public BigDecimal getR31_total_sharjah() {
		return r31_total_sharjah;
	}
	public void setR31_total_sharjah(BigDecimal r31_total_sharjah) {
		this.r31_total_sharjah = r31_total_sharjah;
	}
	public BigDecimal getR31_no_of_accounts_uae_ajman() {
		return r31_no_of_accounts_uae_ajman;
	}
	public void setR31_no_of_accounts_uae_ajman(BigDecimal r31_no_of_accounts_uae_ajman) {
		this.r31_no_of_accounts_uae_ajman = r31_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR31_amount_uae_ajman() {
		return r31_amount_uae_ajman;
	}
	public void setR31_amount_uae_ajman(BigDecimal r31_amount_uae_ajman) {
		this.r31_amount_uae_ajman = r31_amount_uae_ajman;
	}
	public BigDecimal getR31_no_of_accounts_non_uae_ajman() {
		return r31_no_of_accounts_non_uae_ajman;
	}
	public void setR31_no_of_accounts_non_uae_ajman(BigDecimal r31_no_of_accounts_non_uae_ajman) {
		this.r31_no_of_accounts_non_uae_ajman = r31_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR31_amount_non_uae_ajman() {
		return r31_amount_non_uae_ajman;
	}
	public void setR31_amount_non_uae_ajman(BigDecimal r31_amount_non_uae_ajman) {
		this.r31_amount_non_uae_ajman = r31_amount_non_uae_ajman;
	}
	public BigDecimal getR31_total_ajman() {
		return r31_total_ajman;
	}
	public void setR31_total_ajman(BigDecimal r31_total_ajman) {
		this.r31_total_ajman = r31_total_ajman;
	}
	public BigDecimal getR31_no_of_accounts_uae_ras() {
		return r31_no_of_accounts_uae_ras;
	}
	public void setR31_no_of_accounts_uae_ras(BigDecimal r31_no_of_accounts_uae_ras) {
		this.r31_no_of_accounts_uae_ras = r31_no_of_accounts_uae_ras;
	}
	public BigDecimal getR31_amount_uae_ras() {
		return r31_amount_uae_ras;
	}
	public void setR31_amount_uae_ras(BigDecimal r31_amount_uae_ras) {
		this.r31_amount_uae_ras = r31_amount_uae_ras;
	}
	public BigDecimal getR31_no_of_accounts_non_uae_ras() {
		return r31_no_of_accounts_non_uae_ras;
	}
	public void setR31_no_of_accounts_non_uae_ras(BigDecimal r31_no_of_accounts_non_uae_ras) {
		this.r31_no_of_accounts_non_uae_ras = r31_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR31_amount_non_uae_ras() {
		return r31_amount_non_uae_ras;
	}
	public void setR31_amount_non_uae_ras(BigDecimal r31_amount_non_uae_ras) {
		this.r31_amount_non_uae_ras = r31_amount_non_uae_ras;
	}
	public BigDecimal getR31_total_ras() {
		return r31_total_ras;
	}
	public void setR31_total_ras(BigDecimal r31_total_ras) {
		this.r31_total_ras = r31_total_ras;
	}
	public BigDecimal getR31_no_of_accounts_uae_umm() {
		return r31_no_of_accounts_uae_umm;
	}
	public void setR31_no_of_accounts_uae_umm(BigDecimal r31_no_of_accounts_uae_umm) {
		this.r31_no_of_accounts_uae_umm = r31_no_of_accounts_uae_umm;
	}
	public BigDecimal getR31_amount_uae_umm() {
		return r31_amount_uae_umm;
	}
	public void setR31_amount_uae_umm(BigDecimal r31_amount_uae_umm) {
		this.r31_amount_uae_umm = r31_amount_uae_umm;
	}
	public BigDecimal getR31_no_of_accounts_non_uae_umm() {
		return r31_no_of_accounts_non_uae_umm;
	}
	public void setR31_no_of_accounts_non_uae_umm(BigDecimal r31_no_of_accounts_non_uae_umm) {
		this.r31_no_of_accounts_non_uae_umm = r31_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR31_amount_non_uae_umm() {
		return r31_amount_non_uae_umm;
	}
	public void setR31_amount_non_uae_umm(BigDecimal r31_amount_non_uae_umm) {
		this.r31_amount_non_uae_umm = r31_amount_non_uae_umm;
	}
	public BigDecimal getR31_total_umm() {
		return r31_total_umm;
	}
	public void setR31_total_umm(BigDecimal r31_total_umm) {
		this.r31_total_umm = r31_total_umm;
	}
	public BigDecimal getR31_no_of_accounts_uae_fujairah() {
		return r31_no_of_accounts_uae_fujairah;
	}
	public void setR31_no_of_accounts_uae_fujairah(BigDecimal r31_no_of_accounts_uae_fujairah) {
		this.r31_no_of_accounts_uae_fujairah = r31_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR31_amount_uae_fujairah() {
		return r31_amount_uae_fujairah;
	}
	public void setR31_amount_uae_fujairah(BigDecimal r31_amount_uae_fujairah) {
		this.r31_amount_uae_fujairah = r31_amount_uae_fujairah;
	}
	public BigDecimal getR31_no_of_accounts_non_uae_fujairah() {
		return r31_no_of_accounts_non_uae_fujairah;
	}
	public void setR31_no_of_accounts_non_uae_fujairah(BigDecimal r31_no_of_accounts_non_uae_fujairah) {
		this.r31_no_of_accounts_non_uae_fujairah = r31_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR31_amount_non_uae_fujairah() {
		return r31_amount_non_uae_fujairah;
	}
	public void setR31_amount_non_uae_fujairah(BigDecimal r31_amount_non_uae_fujairah) {
		this.r31_amount_non_uae_fujairah = r31_amount_non_uae_fujairah;
	}
	public BigDecimal getR31_total_fujairah() {
		return r31_total_fujairah;
	}
	public void setR31_total_fujairah(BigDecimal r31_total_fujairah) {
		this.r31_total_fujairah = r31_total_fujairah;
	}
	public String getR32_product() {
		return r32_product;
	}
	public void setR32_product(String r32_product) {
		this.r32_product = r32_product;
	}
	public BigDecimal getR32_no_of_accounts_uae() {
		return r32_no_of_accounts_uae;
	}
	public void setR32_no_of_accounts_uae(BigDecimal r32_no_of_accounts_uae) {
		this.r32_no_of_accounts_uae = r32_no_of_accounts_uae;
	}
	public BigDecimal getR32_amount_uae() {
		return r32_amount_uae;
	}
	public void setR32_amount_uae(BigDecimal r32_amount_uae) {
		this.r32_amount_uae = r32_amount_uae;
	}
	public BigDecimal getR32_no_of_accounts_resident() {
		return r32_no_of_accounts_resident;
	}
	public void setR32_no_of_accounts_resident(BigDecimal r32_no_of_accounts_resident) {
		this.r32_no_of_accounts_resident = r32_no_of_accounts_resident;
	}
	public BigDecimal getR32_amount_resident() {
		return r32_amount_resident;
	}
	public void setR32_amount_resident(BigDecimal r32_amount_resident) {
		this.r32_amount_resident = r32_amount_resident;
	}
	public BigDecimal getR32_no_of_accounts_non_resident() {
		return r32_no_of_accounts_non_resident;
	}
	public void setR32_no_of_accounts_non_resident(BigDecimal r32_no_of_accounts_non_resident) {
		this.r32_no_of_accounts_non_resident = r32_no_of_accounts_non_resident;
	}
	public BigDecimal getR32_amount_non_resident() {
		return r32_amount_non_resident;
	}
	public void setR32_amount_non_resident(BigDecimal r32_amount_non_resident) {
		this.r32_amount_non_resident = r32_amount_non_resident;
	}
	public BigDecimal getR32_total_account() {
		return r32_total_account;
	}
	public void setR32_total_account(BigDecimal r32_total_account) {
		this.r32_total_account = r32_total_account;
	}
	public BigDecimal getR32_total_amount() {
		return r32_total_amount;
	}
	public void setR32_total_amount(BigDecimal r32_total_amount) {
		this.r32_total_amount = r32_total_amount;
	}
	public BigDecimal getR32_no_of_accounts_uae_abu() {
		return r32_no_of_accounts_uae_abu;
	}
	public void setR32_no_of_accounts_uae_abu(BigDecimal r32_no_of_accounts_uae_abu) {
		this.r32_no_of_accounts_uae_abu = r32_no_of_accounts_uae_abu;
	}
	public BigDecimal getR32_amount_uae_abu() {
		return r32_amount_uae_abu;
	}
	public void setR32_amount_uae_abu(BigDecimal r32_amount_uae_abu) {
		this.r32_amount_uae_abu = r32_amount_uae_abu;
	}
	public BigDecimal getR32_no_of_accounts_non_uae_abu() {
		return r32_no_of_accounts_non_uae_abu;
	}
	public void setR32_no_of_accounts_non_uae_abu(BigDecimal r32_no_of_accounts_non_uae_abu) {
		this.r32_no_of_accounts_non_uae_abu = r32_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR32_amount_non_uae_abu() {
		return r32_amount_non_uae_abu;
	}
	public void setR32_amount_non_uae_abu(BigDecimal r32_amount_non_uae_abu) {
		this.r32_amount_non_uae_abu = r32_amount_non_uae_abu;
	}
	public BigDecimal getR32_total_abu() {
		return r32_total_abu;
	}
	public void setR32_total_abu(BigDecimal r32_total_abu) {
		this.r32_total_abu = r32_total_abu;
	}
	public BigDecimal getR32_no_of_accounts_uae_dubai() {
		return r32_no_of_accounts_uae_dubai;
	}
	public void setR32_no_of_accounts_uae_dubai(BigDecimal r32_no_of_accounts_uae_dubai) {
		this.r32_no_of_accounts_uae_dubai = r32_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR32_amount_uae_dubai() {
		return r32_amount_uae_dubai;
	}
	public void setR32_amount_uae_dubai(BigDecimal r32_amount_uae_dubai) {
		this.r32_amount_uae_dubai = r32_amount_uae_dubai;
	}
	public BigDecimal getR32_no_of_accounts_non_uae_dubai() {
		return r32_no_of_accounts_non_uae_dubai;
	}
	public void setR32_no_of_accounts_non_uae_dubai(BigDecimal r32_no_of_accounts_non_uae_dubai) {
		this.r32_no_of_accounts_non_uae_dubai = r32_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR32_amount_non_uae_dubai() {
		return r32_amount_non_uae_dubai;
	}
	public void setR32_amount_non_uae_dubai(BigDecimal r32_amount_non_uae_dubai) {
		this.r32_amount_non_uae_dubai = r32_amount_non_uae_dubai;
	}
	public BigDecimal getR32_total_dubai() {
		return r32_total_dubai;
	}
	public void setR32_total_dubai(BigDecimal r32_total_dubai) {
		this.r32_total_dubai = r32_total_dubai;
	}
	public BigDecimal getR32_no_of_accounts_uae_sharjah() {
		return r32_no_of_accounts_uae_sharjah;
	}
	public void setR32_no_of_accounts_uae_sharjah(BigDecimal r32_no_of_accounts_uae_sharjah) {
		this.r32_no_of_accounts_uae_sharjah = r32_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR32_amount_uae_sharjah() {
		return r32_amount_uae_sharjah;
	}
	public void setR32_amount_uae_sharjah(BigDecimal r32_amount_uae_sharjah) {
		this.r32_amount_uae_sharjah = r32_amount_uae_sharjah;
	}
	public BigDecimal getR32_no_of_accounts_non_uae_sharjah() {
		return r32_no_of_accounts_non_uae_sharjah;
	}
	public void setR32_no_of_accounts_non_uae_sharjah(BigDecimal r32_no_of_accounts_non_uae_sharjah) {
		this.r32_no_of_accounts_non_uae_sharjah = r32_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR32_amount_non_uae_sharjah() {
		return r32_amount_non_uae_sharjah;
	}
	public void setR32_amount_non_uae_sharjah(BigDecimal r32_amount_non_uae_sharjah) {
		this.r32_amount_non_uae_sharjah = r32_amount_non_uae_sharjah;
	}
	public BigDecimal getR32_total_sharjah() {
		return r32_total_sharjah;
	}
	public void setR32_total_sharjah(BigDecimal r32_total_sharjah) {
		this.r32_total_sharjah = r32_total_sharjah;
	}
	public BigDecimal getR32_no_of_accounts_uae_ajman() {
		return r32_no_of_accounts_uae_ajman;
	}
	public void setR32_no_of_accounts_uae_ajman(BigDecimal r32_no_of_accounts_uae_ajman) {
		this.r32_no_of_accounts_uae_ajman = r32_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR32_amount_uae_ajman() {
		return r32_amount_uae_ajman;
	}
	public void setR32_amount_uae_ajman(BigDecimal r32_amount_uae_ajman) {
		this.r32_amount_uae_ajman = r32_amount_uae_ajman;
	}
	public BigDecimal getR32_no_of_accounts_non_uae_ajman() {
		return r32_no_of_accounts_non_uae_ajman;
	}
	public void setR32_no_of_accounts_non_uae_ajman(BigDecimal r32_no_of_accounts_non_uae_ajman) {
		this.r32_no_of_accounts_non_uae_ajman = r32_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR32_amount_non_uae_ajman() {
		return r32_amount_non_uae_ajman;
	}
	public void setR32_amount_non_uae_ajman(BigDecimal r32_amount_non_uae_ajman) {
		this.r32_amount_non_uae_ajman = r32_amount_non_uae_ajman;
	}
	public BigDecimal getR32_total_ajman() {
		return r32_total_ajman;
	}
	public void setR32_total_ajman(BigDecimal r32_total_ajman) {
		this.r32_total_ajman = r32_total_ajman;
	}
	public BigDecimal getR32_no_of_accounts_uae_ras() {
		return r32_no_of_accounts_uae_ras;
	}
	public void setR32_no_of_accounts_uae_ras(BigDecimal r32_no_of_accounts_uae_ras) {
		this.r32_no_of_accounts_uae_ras = r32_no_of_accounts_uae_ras;
	}
	public BigDecimal getR32_amount_uae_ras() {
		return r32_amount_uae_ras;
	}
	public void setR32_amount_uae_ras(BigDecimal r32_amount_uae_ras) {
		this.r32_amount_uae_ras = r32_amount_uae_ras;
	}
	public BigDecimal getR32_no_of_accounts_non_uae_ras() {
		return r32_no_of_accounts_non_uae_ras;
	}
	public void setR32_no_of_accounts_non_uae_ras(BigDecimal r32_no_of_accounts_non_uae_ras) {
		this.r32_no_of_accounts_non_uae_ras = r32_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR32_amount_non_uae_ras() {
		return r32_amount_non_uae_ras;
	}
	public void setR32_amount_non_uae_ras(BigDecimal r32_amount_non_uae_ras) {
		this.r32_amount_non_uae_ras = r32_amount_non_uae_ras;
	}
	public BigDecimal getR32_total_ras() {
		return r32_total_ras;
	}
	public void setR32_total_ras(BigDecimal r32_total_ras) {
		this.r32_total_ras = r32_total_ras;
	}
	public BigDecimal getR32_no_of_accounts_uae_umm() {
		return r32_no_of_accounts_uae_umm;
	}
	public void setR32_no_of_accounts_uae_umm(BigDecimal r32_no_of_accounts_uae_umm) {
		this.r32_no_of_accounts_uae_umm = r32_no_of_accounts_uae_umm;
	}
	public BigDecimal getR32_amount_uae_umm() {
		return r32_amount_uae_umm;
	}
	public void setR32_amount_uae_umm(BigDecimal r32_amount_uae_umm) {
		this.r32_amount_uae_umm = r32_amount_uae_umm;
	}
	public BigDecimal getR32_no_of_accounts_non_uae_umm() {
		return r32_no_of_accounts_non_uae_umm;
	}
	public void setR32_no_of_accounts_non_uae_umm(BigDecimal r32_no_of_accounts_non_uae_umm) {
		this.r32_no_of_accounts_non_uae_umm = r32_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR32_amount_non_uae_umm() {
		return r32_amount_non_uae_umm;
	}
	public void setR32_amount_non_uae_umm(BigDecimal r32_amount_non_uae_umm) {
		this.r32_amount_non_uae_umm = r32_amount_non_uae_umm;
	}
	public BigDecimal getR32_total_umm() {
		return r32_total_umm;
	}
	public void setR32_total_umm(BigDecimal r32_total_umm) {
		this.r32_total_umm = r32_total_umm;
	}
	public BigDecimal getR32_no_of_accounts_uae_fujairah() {
		return r32_no_of_accounts_uae_fujairah;
	}
	public void setR32_no_of_accounts_uae_fujairah(BigDecimal r32_no_of_accounts_uae_fujairah) {
		this.r32_no_of_accounts_uae_fujairah = r32_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR32_amount_uae_fujairah() {
		return r32_amount_uae_fujairah;
	}
	public void setR32_amount_uae_fujairah(BigDecimal r32_amount_uae_fujairah) {
		this.r32_amount_uae_fujairah = r32_amount_uae_fujairah;
	}
	public BigDecimal getR32_no_of_accounts_non_uae_fujairah() {
		return r32_no_of_accounts_non_uae_fujairah;
	}
	public void setR32_no_of_accounts_non_uae_fujairah(BigDecimal r32_no_of_accounts_non_uae_fujairah) {
		this.r32_no_of_accounts_non_uae_fujairah = r32_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR32_amount_non_uae_fujairah() {
		return r32_amount_non_uae_fujairah;
	}
	public void setR32_amount_non_uae_fujairah(BigDecimal r32_amount_non_uae_fujairah) {
		this.r32_amount_non_uae_fujairah = r32_amount_non_uae_fujairah;
	}
	public BigDecimal getR32_total_fujairah() {
		return r32_total_fujairah;
	}
	public void setR32_total_fujairah(BigDecimal r32_total_fujairah) {
		this.r32_total_fujairah = r32_total_fujairah;
	}
	public String getR33_product() {
		return r33_product;
	}
	public void setR33_product(String r33_product) {
		this.r33_product = r33_product;
	}
	public BigDecimal getR33_no_of_accounts_uae() {
		return r33_no_of_accounts_uae;
	}
	public void setR33_no_of_accounts_uae(BigDecimal r33_no_of_accounts_uae) {
		this.r33_no_of_accounts_uae = r33_no_of_accounts_uae;
	}
	public BigDecimal getR33_amount_uae() {
		return r33_amount_uae;
	}
	public void setR33_amount_uae(BigDecimal r33_amount_uae) {
		this.r33_amount_uae = r33_amount_uae;
	}
	public BigDecimal getR33_no_of_accounts_resident() {
		return r33_no_of_accounts_resident;
	}
	public void setR33_no_of_accounts_resident(BigDecimal r33_no_of_accounts_resident) {
		this.r33_no_of_accounts_resident = r33_no_of_accounts_resident;
	}
	public BigDecimal getR33_amount_resident() {
		return r33_amount_resident;
	}
	public void setR33_amount_resident(BigDecimal r33_amount_resident) {
		this.r33_amount_resident = r33_amount_resident;
	}
	public BigDecimal getR33_no_of_accounts_non_resident() {
		return r33_no_of_accounts_non_resident;
	}
	public void setR33_no_of_accounts_non_resident(BigDecimal r33_no_of_accounts_non_resident) {
		this.r33_no_of_accounts_non_resident = r33_no_of_accounts_non_resident;
	}
	public BigDecimal getR33_amount_non_resident() {
		return r33_amount_non_resident;
	}
	public void setR33_amount_non_resident(BigDecimal r33_amount_non_resident) {
		this.r33_amount_non_resident = r33_amount_non_resident;
	}
	public BigDecimal getR33_total_account() {
		return r33_total_account;
	}
	public void setR33_total_account(BigDecimal r33_total_account) {
		this.r33_total_account = r33_total_account;
	}
	public BigDecimal getR33_total_amount() {
		return r33_total_amount;
	}
	public void setR33_total_amount(BigDecimal r33_total_amount) {
		this.r33_total_amount = r33_total_amount;
	}
	public BigDecimal getR33_no_of_accounts_uae_abu() {
		return r33_no_of_accounts_uae_abu;
	}
	public void setR33_no_of_accounts_uae_abu(BigDecimal r33_no_of_accounts_uae_abu) {
		this.r33_no_of_accounts_uae_abu = r33_no_of_accounts_uae_abu;
	}
	public BigDecimal getR33_amount_uae_abu() {
		return r33_amount_uae_abu;
	}
	public void setR33_amount_uae_abu(BigDecimal r33_amount_uae_abu) {
		this.r33_amount_uae_abu = r33_amount_uae_abu;
	}
	public BigDecimal getR33_no_of_accounts_non_uae_abu() {
		return r33_no_of_accounts_non_uae_abu;
	}
	public void setR33_no_of_accounts_non_uae_abu(BigDecimal r33_no_of_accounts_non_uae_abu) {
		this.r33_no_of_accounts_non_uae_abu = r33_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR33_amount_non_uae_abu() {
		return r33_amount_non_uae_abu;
	}
	public void setR33_amount_non_uae_abu(BigDecimal r33_amount_non_uae_abu) {
		this.r33_amount_non_uae_abu = r33_amount_non_uae_abu;
	}
	public BigDecimal getR33_total_abu() {
		return r33_total_abu;
	}
	public void setR33_total_abu(BigDecimal r33_total_abu) {
		this.r33_total_abu = r33_total_abu;
	}
	public BigDecimal getR33_no_of_accounts_uae_dubai() {
		return r33_no_of_accounts_uae_dubai;
	}
	public void setR33_no_of_accounts_uae_dubai(BigDecimal r33_no_of_accounts_uae_dubai) {
		this.r33_no_of_accounts_uae_dubai = r33_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR33_amount_uae_dubai() {
		return r33_amount_uae_dubai;
	}
	public void setR33_amount_uae_dubai(BigDecimal r33_amount_uae_dubai) {
		this.r33_amount_uae_dubai = r33_amount_uae_dubai;
	}
	public BigDecimal getR33_no_of_accounts_non_uae_dubai() {
		return r33_no_of_accounts_non_uae_dubai;
	}
	public void setR33_no_of_accounts_non_uae_dubai(BigDecimal r33_no_of_accounts_non_uae_dubai) {
		this.r33_no_of_accounts_non_uae_dubai = r33_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR33_amount_non_uae_dubai() {
		return r33_amount_non_uae_dubai;
	}
	public void setR33_amount_non_uae_dubai(BigDecimal r33_amount_non_uae_dubai) {
		this.r33_amount_non_uae_dubai = r33_amount_non_uae_dubai;
	}
	public BigDecimal getR33_total_dubai() {
		return r33_total_dubai;
	}
	public void setR33_total_dubai(BigDecimal r33_total_dubai) {
		this.r33_total_dubai = r33_total_dubai;
	}
	public BigDecimal getR33_no_of_accounts_uae_sharjah() {
		return r33_no_of_accounts_uae_sharjah;
	}
	public void setR33_no_of_accounts_uae_sharjah(BigDecimal r33_no_of_accounts_uae_sharjah) {
		this.r33_no_of_accounts_uae_sharjah = r33_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR33_amount_uae_sharjah() {
		return r33_amount_uae_sharjah;
	}
	public void setR33_amount_uae_sharjah(BigDecimal r33_amount_uae_sharjah) {
		this.r33_amount_uae_sharjah = r33_amount_uae_sharjah;
	}
	public BigDecimal getR33_no_of_accounts_non_uae_sharjah() {
		return r33_no_of_accounts_non_uae_sharjah;
	}
	public void setR33_no_of_accounts_non_uae_sharjah(BigDecimal r33_no_of_accounts_non_uae_sharjah) {
		this.r33_no_of_accounts_non_uae_sharjah = r33_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR33_amount_non_uae_sharjah() {
		return r33_amount_non_uae_sharjah;
	}
	public void setR33_amount_non_uae_sharjah(BigDecimal r33_amount_non_uae_sharjah) {
		this.r33_amount_non_uae_sharjah = r33_amount_non_uae_sharjah;
	}
	public BigDecimal getR33_total_sharjah() {
		return r33_total_sharjah;
	}
	public void setR33_total_sharjah(BigDecimal r33_total_sharjah) {
		this.r33_total_sharjah = r33_total_sharjah;
	}
	public BigDecimal getR33_no_of_accounts_uae_ajman() {
		return r33_no_of_accounts_uae_ajman;
	}
	public void setR33_no_of_accounts_uae_ajman(BigDecimal r33_no_of_accounts_uae_ajman) {
		this.r33_no_of_accounts_uae_ajman = r33_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR33_amount_uae_ajman() {
		return r33_amount_uae_ajman;
	}
	public void setR33_amount_uae_ajman(BigDecimal r33_amount_uae_ajman) {
		this.r33_amount_uae_ajman = r33_amount_uae_ajman;
	}
	public BigDecimal getR33_no_of_accounts_non_uae_ajman() {
		return r33_no_of_accounts_non_uae_ajman;
	}
	public void setR33_no_of_accounts_non_uae_ajman(BigDecimal r33_no_of_accounts_non_uae_ajman) {
		this.r33_no_of_accounts_non_uae_ajman = r33_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR33_amount_non_uae_ajman() {
		return r33_amount_non_uae_ajman;
	}
	public void setR33_amount_non_uae_ajman(BigDecimal r33_amount_non_uae_ajman) {
		this.r33_amount_non_uae_ajman = r33_amount_non_uae_ajman;
	}
	public BigDecimal getR33_total_ajman() {
		return r33_total_ajman;
	}
	public void setR33_total_ajman(BigDecimal r33_total_ajman) {
		this.r33_total_ajman = r33_total_ajman;
	}
	public BigDecimal getR33_no_of_accounts_uae_ras() {
		return r33_no_of_accounts_uae_ras;
	}
	public void setR33_no_of_accounts_uae_ras(BigDecimal r33_no_of_accounts_uae_ras) {
		this.r33_no_of_accounts_uae_ras = r33_no_of_accounts_uae_ras;
	}
	public BigDecimal getR33_amount_uae_ras() {
		return r33_amount_uae_ras;
	}
	public void setR33_amount_uae_ras(BigDecimal r33_amount_uae_ras) {
		this.r33_amount_uae_ras = r33_amount_uae_ras;
	}
	public BigDecimal getR33_no_of_accounts_non_uae_ras() {
		return r33_no_of_accounts_non_uae_ras;
	}
	public void setR33_no_of_accounts_non_uae_ras(BigDecimal r33_no_of_accounts_non_uae_ras) {
		this.r33_no_of_accounts_non_uae_ras = r33_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR33_amount_non_uae_ras() {
		return r33_amount_non_uae_ras;
	}
	public void setR33_amount_non_uae_ras(BigDecimal r33_amount_non_uae_ras) {
		this.r33_amount_non_uae_ras = r33_amount_non_uae_ras;
	}
	public BigDecimal getR33_total_ras() {
		return r33_total_ras;
	}
	public void setR33_total_ras(BigDecimal r33_total_ras) {
		this.r33_total_ras = r33_total_ras;
	}
	public BigDecimal getR33_no_of_accounts_uae_umm() {
		return r33_no_of_accounts_uae_umm;
	}
	public void setR33_no_of_accounts_uae_umm(BigDecimal r33_no_of_accounts_uae_umm) {
		this.r33_no_of_accounts_uae_umm = r33_no_of_accounts_uae_umm;
	}
	public BigDecimal getR33_amount_uae_umm() {
		return r33_amount_uae_umm;
	}
	public void setR33_amount_uae_umm(BigDecimal r33_amount_uae_umm) {
		this.r33_amount_uae_umm = r33_amount_uae_umm;
	}
	public BigDecimal getR33_no_of_accounts_non_uae_umm() {
		return r33_no_of_accounts_non_uae_umm;
	}
	public void setR33_no_of_accounts_non_uae_umm(BigDecimal r33_no_of_accounts_non_uae_umm) {
		this.r33_no_of_accounts_non_uae_umm = r33_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR33_amount_non_uae_umm() {
		return r33_amount_non_uae_umm;
	}
	public void setR33_amount_non_uae_umm(BigDecimal r33_amount_non_uae_umm) {
		this.r33_amount_non_uae_umm = r33_amount_non_uae_umm;
	}
	public BigDecimal getR33_total_umm() {
		return r33_total_umm;
	}
	public void setR33_total_umm(BigDecimal r33_total_umm) {
		this.r33_total_umm = r33_total_umm;
	}
	public BigDecimal getR33_no_of_accounts_uae_fujairah() {
		return r33_no_of_accounts_uae_fujairah;
	}
	public void setR33_no_of_accounts_uae_fujairah(BigDecimal r33_no_of_accounts_uae_fujairah) {
		this.r33_no_of_accounts_uae_fujairah = r33_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR33_amount_uae_fujairah() {
		return r33_amount_uae_fujairah;
	}
	public void setR33_amount_uae_fujairah(BigDecimal r33_amount_uae_fujairah) {
		this.r33_amount_uae_fujairah = r33_amount_uae_fujairah;
	}
	public BigDecimal getR33_no_of_accounts_non_uae_fujairah() {
		return r33_no_of_accounts_non_uae_fujairah;
	}
	public void setR33_no_of_accounts_non_uae_fujairah(BigDecimal r33_no_of_accounts_non_uae_fujairah) {
		this.r33_no_of_accounts_non_uae_fujairah = r33_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR33_amount_non_uae_fujairah() {
		return r33_amount_non_uae_fujairah;
	}
	public void setR33_amount_non_uae_fujairah(BigDecimal r33_amount_non_uae_fujairah) {
		this.r33_amount_non_uae_fujairah = r33_amount_non_uae_fujairah;
	}
	public BigDecimal getR33_total_fujairah() {
		return r33_total_fujairah;
	}
	public void setR33_total_fujairah(BigDecimal r33_total_fujairah) {
		this.r33_total_fujairah = r33_total_fujairah;
	}
	public String getR34_product() {
		return r34_product;
	}
	public void setR34_product(String r34_product) {
		this.r34_product = r34_product;
	}
	public BigDecimal getR34_no_of_accounts_uae() {
		return r34_no_of_accounts_uae;
	}
	public void setR34_no_of_accounts_uae(BigDecimal r34_no_of_accounts_uae) {
		this.r34_no_of_accounts_uae = r34_no_of_accounts_uae;
	}
	public BigDecimal getR34_amount_uae() {
		return r34_amount_uae;
	}
	public void setR34_amount_uae(BigDecimal r34_amount_uae) {
		this.r34_amount_uae = r34_amount_uae;
	}
	public BigDecimal getR34_no_of_accounts_resident() {
		return r34_no_of_accounts_resident;
	}
	public void setR34_no_of_accounts_resident(BigDecimal r34_no_of_accounts_resident) {
		this.r34_no_of_accounts_resident = r34_no_of_accounts_resident;
	}
	public BigDecimal getR34_amount_resident() {
		return r34_amount_resident;
	}
	public void setR34_amount_resident(BigDecimal r34_amount_resident) {
		this.r34_amount_resident = r34_amount_resident;
	}
	public BigDecimal getR34_no_of_accounts_non_resident() {
		return r34_no_of_accounts_non_resident;
	}
	public void setR34_no_of_accounts_non_resident(BigDecimal r34_no_of_accounts_non_resident) {
		this.r34_no_of_accounts_non_resident = r34_no_of_accounts_non_resident;
	}
	public BigDecimal getR34_amount_non_resident() {
		return r34_amount_non_resident;
	}
	public void setR34_amount_non_resident(BigDecimal r34_amount_non_resident) {
		this.r34_amount_non_resident = r34_amount_non_resident;
	}
	public BigDecimal getR34_total_account() {
		return r34_total_account;
	}
	public void setR34_total_account(BigDecimal r34_total_account) {
		this.r34_total_account = r34_total_account;
	}
	public BigDecimal getR34_total_amount() {
		return r34_total_amount;
	}
	public void setR34_total_amount(BigDecimal r34_total_amount) {
		this.r34_total_amount = r34_total_amount;
	}
	public BigDecimal getR34_no_of_accounts_uae_abu() {
		return r34_no_of_accounts_uae_abu;
	}
	public void setR34_no_of_accounts_uae_abu(BigDecimal r34_no_of_accounts_uae_abu) {
		this.r34_no_of_accounts_uae_abu = r34_no_of_accounts_uae_abu;
	}
	public BigDecimal getR34_amount_uae_abu() {
		return r34_amount_uae_abu;
	}
	public void setR34_amount_uae_abu(BigDecimal r34_amount_uae_abu) {
		this.r34_amount_uae_abu = r34_amount_uae_abu;
	}
	public BigDecimal getR34_no_of_accounts_non_uae_abu() {
		return r34_no_of_accounts_non_uae_abu;
	}
	public void setR34_no_of_accounts_non_uae_abu(BigDecimal r34_no_of_accounts_non_uae_abu) {
		this.r34_no_of_accounts_non_uae_abu = r34_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR34_amount_non_uae_abu() {
		return r34_amount_non_uae_abu;
	}
	public void setR34_amount_non_uae_abu(BigDecimal r34_amount_non_uae_abu) {
		this.r34_amount_non_uae_abu = r34_amount_non_uae_abu;
	}
	public BigDecimal getR34_total_abu() {
		return r34_total_abu;
	}
	public void setR34_total_abu(BigDecimal r34_total_abu) {
		this.r34_total_abu = r34_total_abu;
	}
	public BigDecimal getR34_no_of_accounts_uae_dubai() {
		return r34_no_of_accounts_uae_dubai;
	}
	public void setR34_no_of_accounts_uae_dubai(BigDecimal r34_no_of_accounts_uae_dubai) {
		this.r34_no_of_accounts_uae_dubai = r34_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR34_amount_uae_dubai() {
		return r34_amount_uae_dubai;
	}
	public void setR34_amount_uae_dubai(BigDecimal r34_amount_uae_dubai) {
		this.r34_amount_uae_dubai = r34_amount_uae_dubai;
	}
	public BigDecimal getR34_no_of_accounts_non_uae_dubai() {
		return r34_no_of_accounts_non_uae_dubai;
	}
	public void setR34_no_of_accounts_non_uae_dubai(BigDecimal r34_no_of_accounts_non_uae_dubai) {
		this.r34_no_of_accounts_non_uae_dubai = r34_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR34_amount_non_uae_dubai() {
		return r34_amount_non_uae_dubai;
	}
	public void setR34_amount_non_uae_dubai(BigDecimal r34_amount_non_uae_dubai) {
		this.r34_amount_non_uae_dubai = r34_amount_non_uae_dubai;
	}
	public BigDecimal getR34_total_dubai() {
		return r34_total_dubai;
	}
	public void setR34_total_dubai(BigDecimal r34_total_dubai) {
		this.r34_total_dubai = r34_total_dubai;
	}
	public BigDecimal getR34_no_of_accounts_uae_sharjah() {
		return r34_no_of_accounts_uae_sharjah;
	}
	public void setR34_no_of_accounts_uae_sharjah(BigDecimal r34_no_of_accounts_uae_sharjah) {
		this.r34_no_of_accounts_uae_sharjah = r34_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR34_amount_uae_sharjah() {
		return r34_amount_uae_sharjah;
	}
	public void setR34_amount_uae_sharjah(BigDecimal r34_amount_uae_sharjah) {
		this.r34_amount_uae_sharjah = r34_amount_uae_sharjah;
	}
	public BigDecimal getR34_no_of_accounts_non_uae_sharjah() {
		return r34_no_of_accounts_non_uae_sharjah;
	}
	public void setR34_no_of_accounts_non_uae_sharjah(BigDecimal r34_no_of_accounts_non_uae_sharjah) {
		this.r34_no_of_accounts_non_uae_sharjah = r34_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR34_amount_non_uae_sharjah() {
		return r34_amount_non_uae_sharjah;
	}
	public void setR34_amount_non_uae_sharjah(BigDecimal r34_amount_non_uae_sharjah) {
		this.r34_amount_non_uae_sharjah = r34_amount_non_uae_sharjah;
	}
	public BigDecimal getR34_total_sharjah() {
		return r34_total_sharjah;
	}
	public void setR34_total_sharjah(BigDecimal r34_total_sharjah) {
		this.r34_total_sharjah = r34_total_sharjah;
	}
	public BigDecimal getR34_no_of_accounts_uae_ajman() {
		return r34_no_of_accounts_uae_ajman;
	}
	public void setR34_no_of_accounts_uae_ajman(BigDecimal r34_no_of_accounts_uae_ajman) {
		this.r34_no_of_accounts_uae_ajman = r34_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR34_amount_uae_ajman() {
		return r34_amount_uae_ajman;
	}
	public void setR34_amount_uae_ajman(BigDecimal r34_amount_uae_ajman) {
		this.r34_amount_uae_ajman = r34_amount_uae_ajman;
	}
	public BigDecimal getR34_no_of_accounts_non_uae_ajman() {
		return r34_no_of_accounts_non_uae_ajman;
	}
	public void setR34_no_of_accounts_non_uae_ajman(BigDecimal r34_no_of_accounts_non_uae_ajman) {
		this.r34_no_of_accounts_non_uae_ajman = r34_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR34_amount_non_uae_ajman() {
		return r34_amount_non_uae_ajman;
	}
	public void setR34_amount_non_uae_ajman(BigDecimal r34_amount_non_uae_ajman) {
		this.r34_amount_non_uae_ajman = r34_amount_non_uae_ajman;
	}
	public BigDecimal getR34_total_ajman() {
		return r34_total_ajman;
	}
	public void setR34_total_ajman(BigDecimal r34_total_ajman) {
		this.r34_total_ajman = r34_total_ajman;
	}
	public BigDecimal getR34_no_of_accounts_uae_ras() {
		return r34_no_of_accounts_uae_ras;
	}
	public void setR34_no_of_accounts_uae_ras(BigDecimal r34_no_of_accounts_uae_ras) {
		this.r34_no_of_accounts_uae_ras = r34_no_of_accounts_uae_ras;
	}
	public BigDecimal getR34_amount_uae_ras() {
		return r34_amount_uae_ras;
	}
	public void setR34_amount_uae_ras(BigDecimal r34_amount_uae_ras) {
		this.r34_amount_uae_ras = r34_amount_uae_ras;
	}
	public BigDecimal getR34_no_of_accounts_non_uae_ras() {
		return r34_no_of_accounts_non_uae_ras;
	}
	public void setR34_no_of_accounts_non_uae_ras(BigDecimal r34_no_of_accounts_non_uae_ras) {
		this.r34_no_of_accounts_non_uae_ras = r34_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR34_amount_non_uae_ras() {
		return r34_amount_non_uae_ras;
	}
	public void setR34_amount_non_uae_ras(BigDecimal r34_amount_non_uae_ras) {
		this.r34_amount_non_uae_ras = r34_amount_non_uae_ras;
	}
	public BigDecimal getR34_total_ras() {
		return r34_total_ras;
	}
	public void setR34_total_ras(BigDecimal r34_total_ras) {
		this.r34_total_ras = r34_total_ras;
	}
	public BigDecimal getR34_no_of_accounts_uae_umm() {
		return r34_no_of_accounts_uae_umm;
	}
	public void setR34_no_of_accounts_uae_umm(BigDecimal r34_no_of_accounts_uae_umm) {
		this.r34_no_of_accounts_uae_umm = r34_no_of_accounts_uae_umm;
	}
	public BigDecimal getR34_amount_uae_umm() {
		return r34_amount_uae_umm;
	}
	public void setR34_amount_uae_umm(BigDecimal r34_amount_uae_umm) {
		this.r34_amount_uae_umm = r34_amount_uae_umm;
	}
	public BigDecimal getR34_no_of_accounts_non_uae_umm() {
		return r34_no_of_accounts_non_uae_umm;
	}
	public void setR34_no_of_accounts_non_uae_umm(BigDecimal r34_no_of_accounts_non_uae_umm) {
		this.r34_no_of_accounts_non_uae_umm = r34_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR34_amount_non_uae_umm() {
		return r34_amount_non_uae_umm;
	}
	public void setR34_amount_non_uae_umm(BigDecimal r34_amount_non_uae_umm) {
		this.r34_amount_non_uae_umm = r34_amount_non_uae_umm;
	}
	public BigDecimal getR34_total_umm() {
		return r34_total_umm;
	}
	public void setR34_total_umm(BigDecimal r34_total_umm) {
		this.r34_total_umm = r34_total_umm;
	}
	public BigDecimal getR34_no_of_accounts_uae_fujairah() {
		return r34_no_of_accounts_uae_fujairah;
	}
	public void setR34_no_of_accounts_uae_fujairah(BigDecimal r34_no_of_accounts_uae_fujairah) {
		this.r34_no_of_accounts_uae_fujairah = r34_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR34_amount_uae_fujairah() {
		return r34_amount_uae_fujairah;
	}
	public void setR34_amount_uae_fujairah(BigDecimal r34_amount_uae_fujairah) {
		this.r34_amount_uae_fujairah = r34_amount_uae_fujairah;
	}
	public BigDecimal getR34_no_of_accounts_non_uae_fujairah() {
		return r34_no_of_accounts_non_uae_fujairah;
	}
	public void setR34_no_of_accounts_non_uae_fujairah(BigDecimal r34_no_of_accounts_non_uae_fujairah) {
		this.r34_no_of_accounts_non_uae_fujairah = r34_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR34_amount_non_uae_fujairah() {
		return r34_amount_non_uae_fujairah;
	}
	public void setR34_amount_non_uae_fujairah(BigDecimal r34_amount_non_uae_fujairah) {
		this.r34_amount_non_uae_fujairah = r34_amount_non_uae_fujairah;
	}
	public BigDecimal getR34_total_fujairah() {
		return r34_total_fujairah;
	}
	public void setR34_total_fujairah(BigDecimal r34_total_fujairah) {
		this.r34_total_fujairah = r34_total_fujairah;
	}
	public String getR35_product() {
		return r35_product;
	}
	public void setR35_product(String r35_product) {
		this.r35_product = r35_product;
	}
	public BigDecimal getR35_no_of_accounts_uae() {
		return r35_no_of_accounts_uae;
	}
	public void setR35_no_of_accounts_uae(BigDecimal r35_no_of_accounts_uae) {
		this.r35_no_of_accounts_uae = r35_no_of_accounts_uae;
	}
	public BigDecimal getR35_amount_uae() {
		return r35_amount_uae;
	}
	public void setR35_amount_uae(BigDecimal r35_amount_uae) {
		this.r35_amount_uae = r35_amount_uae;
	}
	public BigDecimal getR35_no_of_accounts_resident() {
		return r35_no_of_accounts_resident;
	}
	public void setR35_no_of_accounts_resident(BigDecimal r35_no_of_accounts_resident) {
		this.r35_no_of_accounts_resident = r35_no_of_accounts_resident;
	}
	public BigDecimal getR35_amount_resident() {
		return r35_amount_resident;
	}
	public void setR35_amount_resident(BigDecimal r35_amount_resident) {
		this.r35_amount_resident = r35_amount_resident;
	}
	public BigDecimal getR35_no_of_accounts_non_resident() {
		return r35_no_of_accounts_non_resident;
	}
	public void setR35_no_of_accounts_non_resident(BigDecimal r35_no_of_accounts_non_resident) {
		this.r35_no_of_accounts_non_resident = r35_no_of_accounts_non_resident;
	}
	public BigDecimal getR35_amount_non_resident() {
		return r35_amount_non_resident;
	}
	public void setR35_amount_non_resident(BigDecimal r35_amount_non_resident) {
		this.r35_amount_non_resident = r35_amount_non_resident;
	}
	public BigDecimal getR35_total_account() {
		return r35_total_account;
	}
	public void setR35_total_account(BigDecimal r35_total_account) {
		this.r35_total_account = r35_total_account;
	}
	public BigDecimal getR35_total_amount() {
		return r35_total_amount;
	}
	public void setR35_total_amount(BigDecimal r35_total_amount) {
		this.r35_total_amount = r35_total_amount;
	}
	public BigDecimal getR35_no_of_accounts_uae_abu() {
		return r35_no_of_accounts_uae_abu;
	}
	public void setR35_no_of_accounts_uae_abu(BigDecimal r35_no_of_accounts_uae_abu) {
		this.r35_no_of_accounts_uae_abu = r35_no_of_accounts_uae_abu;
	}
	public BigDecimal getR35_amount_uae_abu() {
		return r35_amount_uae_abu;
	}
	public void setR35_amount_uae_abu(BigDecimal r35_amount_uae_abu) {
		this.r35_amount_uae_abu = r35_amount_uae_abu;
	}
	public BigDecimal getR35_no_of_accounts_non_uae_abu() {
		return r35_no_of_accounts_non_uae_abu;
	}
	public void setR35_no_of_accounts_non_uae_abu(BigDecimal r35_no_of_accounts_non_uae_abu) {
		this.r35_no_of_accounts_non_uae_abu = r35_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR35_amount_non_uae_abu() {
		return r35_amount_non_uae_abu;
	}
	public void setR35_amount_non_uae_abu(BigDecimal r35_amount_non_uae_abu) {
		this.r35_amount_non_uae_abu = r35_amount_non_uae_abu;
	}
	public BigDecimal getR35_total_abu() {
		return r35_total_abu;
	}
	public void setR35_total_abu(BigDecimal r35_total_abu) {
		this.r35_total_abu = r35_total_abu;
	}
	public BigDecimal getR35_no_of_accounts_uae_dubai() {
		return r35_no_of_accounts_uae_dubai;
	}
	public void setR35_no_of_accounts_uae_dubai(BigDecimal r35_no_of_accounts_uae_dubai) {
		this.r35_no_of_accounts_uae_dubai = r35_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR35_amount_uae_dubai() {
		return r35_amount_uae_dubai;
	}
	public void setR35_amount_uae_dubai(BigDecimal r35_amount_uae_dubai) {
		this.r35_amount_uae_dubai = r35_amount_uae_dubai;
	}
	public BigDecimal getR35_no_of_accounts_non_uae_dubai() {
		return r35_no_of_accounts_non_uae_dubai;
	}
	public void setR35_no_of_accounts_non_uae_dubai(BigDecimal r35_no_of_accounts_non_uae_dubai) {
		this.r35_no_of_accounts_non_uae_dubai = r35_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR35_amount_non_uae_dubai() {
		return r35_amount_non_uae_dubai;
	}
	public void setR35_amount_non_uae_dubai(BigDecimal r35_amount_non_uae_dubai) {
		this.r35_amount_non_uae_dubai = r35_amount_non_uae_dubai;
	}
	public BigDecimal getR35_total_dubai() {
		return r35_total_dubai;
	}
	public void setR35_total_dubai(BigDecimal r35_total_dubai) {
		this.r35_total_dubai = r35_total_dubai;
	}
	public BigDecimal getR35_no_of_accounts_uae_sharjah() {
		return r35_no_of_accounts_uae_sharjah;
	}
	public void setR35_no_of_accounts_uae_sharjah(BigDecimal r35_no_of_accounts_uae_sharjah) {
		this.r35_no_of_accounts_uae_sharjah = r35_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR35_amount_uae_sharjah() {
		return r35_amount_uae_sharjah;
	}
	public void setR35_amount_uae_sharjah(BigDecimal r35_amount_uae_sharjah) {
		this.r35_amount_uae_sharjah = r35_amount_uae_sharjah;
	}
	public BigDecimal getR35_no_of_accounts_non_uae_sharjah() {
		return r35_no_of_accounts_non_uae_sharjah;
	}
	public void setR35_no_of_accounts_non_uae_sharjah(BigDecimal r35_no_of_accounts_non_uae_sharjah) {
		this.r35_no_of_accounts_non_uae_sharjah = r35_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR35_amount_non_uae_sharjah() {
		return r35_amount_non_uae_sharjah;
	}
	public void setR35_amount_non_uae_sharjah(BigDecimal r35_amount_non_uae_sharjah) {
		this.r35_amount_non_uae_sharjah = r35_amount_non_uae_sharjah;
	}
	public BigDecimal getR35_total_sharjah() {
		return r35_total_sharjah;
	}
	public void setR35_total_sharjah(BigDecimal r35_total_sharjah) {
		this.r35_total_sharjah = r35_total_sharjah;
	}
	public BigDecimal getR35_no_of_accounts_uae_ajman() {
		return r35_no_of_accounts_uae_ajman;
	}
	public void setR35_no_of_accounts_uae_ajman(BigDecimal r35_no_of_accounts_uae_ajman) {
		this.r35_no_of_accounts_uae_ajman = r35_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR35_amount_uae_ajman() {
		return r35_amount_uae_ajman;
	}
	public void setR35_amount_uae_ajman(BigDecimal r35_amount_uae_ajman) {
		this.r35_amount_uae_ajman = r35_amount_uae_ajman;
	}
	public BigDecimal getR35_no_of_accounts_non_uae_ajman() {
		return r35_no_of_accounts_non_uae_ajman;
	}
	public void setR35_no_of_accounts_non_uae_ajman(BigDecimal r35_no_of_accounts_non_uae_ajman) {
		this.r35_no_of_accounts_non_uae_ajman = r35_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR35_amount_non_uae_ajman() {
		return r35_amount_non_uae_ajman;
	}
	public void setR35_amount_non_uae_ajman(BigDecimal r35_amount_non_uae_ajman) {
		this.r35_amount_non_uae_ajman = r35_amount_non_uae_ajman;
	}
	public BigDecimal getR35_total_ajman() {
		return r35_total_ajman;
	}
	public void setR35_total_ajman(BigDecimal r35_total_ajman) {
		this.r35_total_ajman = r35_total_ajman;
	}
	public BigDecimal getR35_no_of_accounts_uae_ras() {
		return r35_no_of_accounts_uae_ras;
	}
	public void setR35_no_of_accounts_uae_ras(BigDecimal r35_no_of_accounts_uae_ras) {
		this.r35_no_of_accounts_uae_ras = r35_no_of_accounts_uae_ras;
	}
	public BigDecimal getR35_amount_uae_ras() {
		return r35_amount_uae_ras;
	}
	public void setR35_amount_uae_ras(BigDecimal r35_amount_uae_ras) {
		this.r35_amount_uae_ras = r35_amount_uae_ras;
	}
	public BigDecimal getR35_no_of_accounts_non_uae_ras() {
		return r35_no_of_accounts_non_uae_ras;
	}
	public void setR35_no_of_accounts_non_uae_ras(BigDecimal r35_no_of_accounts_non_uae_ras) {
		this.r35_no_of_accounts_non_uae_ras = r35_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR35_amount_non_uae_ras() {
		return r35_amount_non_uae_ras;
	}
	public void setR35_amount_non_uae_ras(BigDecimal r35_amount_non_uae_ras) {
		this.r35_amount_non_uae_ras = r35_amount_non_uae_ras;
	}
	public BigDecimal getR35_total_ras() {
		return r35_total_ras;
	}
	public void setR35_total_ras(BigDecimal r35_total_ras) {
		this.r35_total_ras = r35_total_ras;
	}
	public BigDecimal getR35_no_of_accounts_uae_umm() {
		return r35_no_of_accounts_uae_umm;
	}
	public void setR35_no_of_accounts_uae_umm(BigDecimal r35_no_of_accounts_uae_umm) {
		this.r35_no_of_accounts_uae_umm = r35_no_of_accounts_uae_umm;
	}
	public BigDecimal getR35_amount_uae_umm() {
		return r35_amount_uae_umm;
	}
	public void setR35_amount_uae_umm(BigDecimal r35_amount_uae_umm) {
		this.r35_amount_uae_umm = r35_amount_uae_umm;
	}
	public BigDecimal getR35_no_of_accounts_non_uae_umm() {
		return r35_no_of_accounts_non_uae_umm;
	}
	public void setR35_no_of_accounts_non_uae_umm(BigDecimal r35_no_of_accounts_non_uae_umm) {
		this.r35_no_of_accounts_non_uae_umm = r35_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR35_amount_non_uae_umm() {
		return r35_amount_non_uae_umm;
	}
	public void setR35_amount_non_uae_umm(BigDecimal r35_amount_non_uae_umm) {
		this.r35_amount_non_uae_umm = r35_amount_non_uae_umm;
	}
	public BigDecimal getR35_total_umm() {
		return r35_total_umm;
	}
	public void setR35_total_umm(BigDecimal r35_total_umm) {
		this.r35_total_umm = r35_total_umm;
	}
	public BigDecimal getR35_no_of_accounts_uae_fujairah() {
		return r35_no_of_accounts_uae_fujairah;
	}
	public void setR35_no_of_accounts_uae_fujairah(BigDecimal r35_no_of_accounts_uae_fujairah) {
		this.r35_no_of_accounts_uae_fujairah = r35_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR35_amount_uae_fujairah() {
		return r35_amount_uae_fujairah;
	}
	public void setR35_amount_uae_fujairah(BigDecimal r35_amount_uae_fujairah) {
		this.r35_amount_uae_fujairah = r35_amount_uae_fujairah;
	}
	public BigDecimal getR35_no_of_accounts_non_uae_fujairah() {
		return r35_no_of_accounts_non_uae_fujairah;
	}
	public void setR35_no_of_accounts_non_uae_fujairah(BigDecimal r35_no_of_accounts_non_uae_fujairah) {
		this.r35_no_of_accounts_non_uae_fujairah = r35_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR35_amount_non_uae_fujairah() {
		return r35_amount_non_uae_fujairah;
	}
	public void setR35_amount_non_uae_fujairah(BigDecimal r35_amount_non_uae_fujairah) {
		this.r35_amount_non_uae_fujairah = r35_amount_non_uae_fujairah;
	}
	public BigDecimal getR35_total_fujairah() {
		return r35_total_fujairah;
	}
	public void setR35_total_fujairah(BigDecimal r35_total_fujairah) {
		this.r35_total_fujairah = r35_total_fujairah;
	}
	public String getR36_product() {
		return r36_product;
	}
	public void setR36_product(String r36_product) {
		this.r36_product = r36_product;
	}
	public BigDecimal getR36_no_of_accounts_uae() {
		return r36_no_of_accounts_uae;
	}
	public void setR36_no_of_accounts_uae(BigDecimal r36_no_of_accounts_uae) {
		this.r36_no_of_accounts_uae = r36_no_of_accounts_uae;
	}
	public BigDecimal getR36_amount_uae() {
		return r36_amount_uae;
	}
	public void setR36_amount_uae(BigDecimal r36_amount_uae) {
		this.r36_amount_uae = r36_amount_uae;
	}
	public BigDecimal getR36_no_of_accounts_resident() {
		return r36_no_of_accounts_resident;
	}
	public void setR36_no_of_accounts_resident(BigDecimal r36_no_of_accounts_resident) {
		this.r36_no_of_accounts_resident = r36_no_of_accounts_resident;
	}
	public BigDecimal getR36_amount_resident() {
		return r36_amount_resident;
	}
	public void setR36_amount_resident(BigDecimal r36_amount_resident) {
		this.r36_amount_resident = r36_amount_resident;
	}
	public BigDecimal getR36_no_of_accounts_non_resident() {
		return r36_no_of_accounts_non_resident;
	}
	public void setR36_no_of_accounts_non_resident(BigDecimal r36_no_of_accounts_non_resident) {
		this.r36_no_of_accounts_non_resident = r36_no_of_accounts_non_resident;
	}
	public BigDecimal getR36_amount_non_resident() {
		return r36_amount_non_resident;
	}
	public void setR36_amount_non_resident(BigDecimal r36_amount_non_resident) {
		this.r36_amount_non_resident = r36_amount_non_resident;
	}
	public BigDecimal getR36_total_account() {
		return r36_total_account;
	}
	public void setR36_total_account(BigDecimal r36_total_account) {
		this.r36_total_account = r36_total_account;
	}
	public BigDecimal getR36_total_amount() {
		return r36_total_amount;
	}
	public void setR36_total_amount(BigDecimal r36_total_amount) {
		this.r36_total_amount = r36_total_amount;
	}
	public BigDecimal getR36_no_of_accounts_uae_abu() {
		return r36_no_of_accounts_uae_abu;
	}
	public void setR36_no_of_accounts_uae_abu(BigDecimal r36_no_of_accounts_uae_abu) {
		this.r36_no_of_accounts_uae_abu = r36_no_of_accounts_uae_abu;
	}
	public BigDecimal getR36_amount_uae_abu() {
		return r36_amount_uae_abu;
	}
	public void setR36_amount_uae_abu(BigDecimal r36_amount_uae_abu) {
		this.r36_amount_uae_abu = r36_amount_uae_abu;
	}
	public BigDecimal getR36_no_of_accounts_non_uae_abu() {
		return r36_no_of_accounts_non_uae_abu;
	}
	public void setR36_no_of_accounts_non_uae_abu(BigDecimal r36_no_of_accounts_non_uae_abu) {
		this.r36_no_of_accounts_non_uae_abu = r36_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR36_amount_non_uae_abu() {
		return r36_amount_non_uae_abu;
	}
	public void setR36_amount_non_uae_abu(BigDecimal r36_amount_non_uae_abu) {
		this.r36_amount_non_uae_abu = r36_amount_non_uae_abu;
	}
	public BigDecimal getR36_total_abu() {
		return r36_total_abu;
	}
	public void setR36_total_abu(BigDecimal r36_total_abu) {
		this.r36_total_abu = r36_total_abu;
	}
	public BigDecimal getR36_no_of_accounts_uae_dubai() {
		return r36_no_of_accounts_uae_dubai;
	}
	public void setR36_no_of_accounts_uae_dubai(BigDecimal r36_no_of_accounts_uae_dubai) {
		this.r36_no_of_accounts_uae_dubai = r36_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR36_amount_uae_dubai() {
		return r36_amount_uae_dubai;
	}
	public void setR36_amount_uae_dubai(BigDecimal r36_amount_uae_dubai) {
		this.r36_amount_uae_dubai = r36_amount_uae_dubai;
	}
	public BigDecimal getR36_no_of_accounts_non_uae_dubai() {
		return r36_no_of_accounts_non_uae_dubai;
	}
	public void setR36_no_of_accounts_non_uae_dubai(BigDecimal r36_no_of_accounts_non_uae_dubai) {
		this.r36_no_of_accounts_non_uae_dubai = r36_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR36_amount_non_uae_dubai() {
		return r36_amount_non_uae_dubai;
	}
	public void setR36_amount_non_uae_dubai(BigDecimal r36_amount_non_uae_dubai) {
		this.r36_amount_non_uae_dubai = r36_amount_non_uae_dubai;
	}
	public BigDecimal getR36_total_dubai() {
		return r36_total_dubai;
	}
	public void setR36_total_dubai(BigDecimal r36_total_dubai) {
		this.r36_total_dubai = r36_total_dubai;
	}
	public BigDecimal getR36_no_of_accounts_uae_sharjah() {
		return r36_no_of_accounts_uae_sharjah;
	}
	public void setR36_no_of_accounts_uae_sharjah(BigDecimal r36_no_of_accounts_uae_sharjah) {
		this.r36_no_of_accounts_uae_sharjah = r36_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR36_amount_uae_sharjah() {
		return r36_amount_uae_sharjah;
	}
	public void setR36_amount_uae_sharjah(BigDecimal r36_amount_uae_sharjah) {
		this.r36_amount_uae_sharjah = r36_amount_uae_sharjah;
	}
	public BigDecimal getR36_no_of_accounts_non_uae_sharjah() {
		return r36_no_of_accounts_non_uae_sharjah;
	}
	public void setR36_no_of_accounts_non_uae_sharjah(BigDecimal r36_no_of_accounts_non_uae_sharjah) {
		this.r36_no_of_accounts_non_uae_sharjah = r36_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR36_amount_non_uae_sharjah() {
		return r36_amount_non_uae_sharjah;
	}
	public void setR36_amount_non_uae_sharjah(BigDecimal r36_amount_non_uae_sharjah) {
		this.r36_amount_non_uae_sharjah = r36_amount_non_uae_sharjah;
	}
	public BigDecimal getR36_total_sharjah() {
		return r36_total_sharjah;
	}
	public void setR36_total_sharjah(BigDecimal r36_total_sharjah) {
		this.r36_total_sharjah = r36_total_sharjah;
	}
	public BigDecimal getR36_no_of_accounts_uae_ajman() {
		return r36_no_of_accounts_uae_ajman;
	}
	public void setR36_no_of_accounts_uae_ajman(BigDecimal r36_no_of_accounts_uae_ajman) {
		this.r36_no_of_accounts_uae_ajman = r36_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR36_amount_uae_ajman() {
		return r36_amount_uae_ajman;
	}
	public void setR36_amount_uae_ajman(BigDecimal r36_amount_uae_ajman) {
		this.r36_amount_uae_ajman = r36_amount_uae_ajman;
	}
	public BigDecimal getR36_no_of_accounts_non_uae_ajman() {
		return r36_no_of_accounts_non_uae_ajman;
	}
	public void setR36_no_of_accounts_non_uae_ajman(BigDecimal r36_no_of_accounts_non_uae_ajman) {
		this.r36_no_of_accounts_non_uae_ajman = r36_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR36_amount_non_uae_ajman() {
		return r36_amount_non_uae_ajman;
	}
	public void setR36_amount_non_uae_ajman(BigDecimal r36_amount_non_uae_ajman) {
		this.r36_amount_non_uae_ajman = r36_amount_non_uae_ajman;
	}
	public BigDecimal getR36_total_ajman() {
		return r36_total_ajman;
	}
	public void setR36_total_ajman(BigDecimal r36_total_ajman) {
		this.r36_total_ajman = r36_total_ajman;
	}
	public BigDecimal getR36_no_of_accounts_uae_ras() {
		return r36_no_of_accounts_uae_ras;
	}
	public void setR36_no_of_accounts_uae_ras(BigDecimal r36_no_of_accounts_uae_ras) {
		this.r36_no_of_accounts_uae_ras = r36_no_of_accounts_uae_ras;
	}
	public BigDecimal getR36_amount_uae_ras() {
		return r36_amount_uae_ras;
	}
	public void setR36_amount_uae_ras(BigDecimal r36_amount_uae_ras) {
		this.r36_amount_uae_ras = r36_amount_uae_ras;
	}
	public BigDecimal getR36_no_of_accounts_non_uae_ras() {
		return r36_no_of_accounts_non_uae_ras;
	}
	public void setR36_no_of_accounts_non_uae_ras(BigDecimal r36_no_of_accounts_non_uae_ras) {
		this.r36_no_of_accounts_non_uae_ras = r36_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR36_amount_non_uae_ras() {
		return r36_amount_non_uae_ras;
	}
	public void setR36_amount_non_uae_ras(BigDecimal r36_amount_non_uae_ras) {
		this.r36_amount_non_uae_ras = r36_amount_non_uae_ras;
	}
	public BigDecimal getR36_total_ras() {
		return r36_total_ras;
	}
	public void setR36_total_ras(BigDecimal r36_total_ras) {
		this.r36_total_ras = r36_total_ras;
	}
	public BigDecimal getR36_no_of_accounts_uae_umm() {
		return r36_no_of_accounts_uae_umm;
	}
	public void setR36_no_of_accounts_uae_umm(BigDecimal r36_no_of_accounts_uae_umm) {
		this.r36_no_of_accounts_uae_umm = r36_no_of_accounts_uae_umm;
	}
	public BigDecimal getR36_amount_uae_umm() {
		return r36_amount_uae_umm;
	}
	public void setR36_amount_uae_umm(BigDecimal r36_amount_uae_umm) {
		this.r36_amount_uae_umm = r36_amount_uae_umm;
	}
	public BigDecimal getR36_no_of_accounts_non_uae_umm() {
		return r36_no_of_accounts_non_uae_umm;
	}
	public void setR36_no_of_accounts_non_uae_umm(BigDecimal r36_no_of_accounts_non_uae_umm) {
		this.r36_no_of_accounts_non_uae_umm = r36_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR36_amount_non_uae_umm() {
		return r36_amount_non_uae_umm;
	}
	public void setR36_amount_non_uae_umm(BigDecimal r36_amount_non_uae_umm) {
		this.r36_amount_non_uae_umm = r36_amount_non_uae_umm;
	}
	public BigDecimal getR36_total_umm() {
		return r36_total_umm;
	}
	public void setR36_total_umm(BigDecimal r36_total_umm) {
		this.r36_total_umm = r36_total_umm;
	}
	public BigDecimal getR36_no_of_accounts_uae_fujairah() {
		return r36_no_of_accounts_uae_fujairah;
	}
	public void setR36_no_of_accounts_uae_fujairah(BigDecimal r36_no_of_accounts_uae_fujairah) {
		this.r36_no_of_accounts_uae_fujairah = r36_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR36_amount_uae_fujairah() {
		return r36_amount_uae_fujairah;
	}
	public void setR36_amount_uae_fujairah(BigDecimal r36_amount_uae_fujairah) {
		this.r36_amount_uae_fujairah = r36_amount_uae_fujairah;
	}
	public BigDecimal getR36_no_of_accounts_non_uae_fujairah() {
		return r36_no_of_accounts_non_uae_fujairah;
	}
	public void setR36_no_of_accounts_non_uae_fujairah(BigDecimal r36_no_of_accounts_non_uae_fujairah) {
		this.r36_no_of_accounts_non_uae_fujairah = r36_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR36_amount_non_uae_fujairah() {
		return r36_amount_non_uae_fujairah;
	}
	public void setR36_amount_non_uae_fujairah(BigDecimal r36_amount_non_uae_fujairah) {
		this.r36_amount_non_uae_fujairah = r36_amount_non_uae_fujairah;
	}
	public BigDecimal getR36_total_fujairah() {
		return r36_total_fujairah;
	}
	public void setR36_total_fujairah(BigDecimal r36_total_fujairah) {
		this.r36_total_fujairah = r36_total_fujairah;
	}
	public String getR37_product() {
		return r37_product;
	}
	public void setR37_product(String r37_product) {
		this.r37_product = r37_product;
	}
	public BigDecimal getR37_no_of_accounts_uae() {
		return r37_no_of_accounts_uae;
	}
	public void setR37_no_of_accounts_uae(BigDecimal r37_no_of_accounts_uae) {
		this.r37_no_of_accounts_uae = r37_no_of_accounts_uae;
	}
	public BigDecimal getR37_amount_uae() {
		return r37_amount_uae;
	}
	public void setR37_amount_uae(BigDecimal r37_amount_uae) {
		this.r37_amount_uae = r37_amount_uae;
	}
	public BigDecimal getR37_no_of_accounts_resident() {
		return r37_no_of_accounts_resident;
	}
	public void setR37_no_of_accounts_resident(BigDecimal r37_no_of_accounts_resident) {
		this.r37_no_of_accounts_resident = r37_no_of_accounts_resident;
	}
	public BigDecimal getR37_amount_resident() {
		return r37_amount_resident;
	}
	public void setR37_amount_resident(BigDecimal r37_amount_resident) {
		this.r37_amount_resident = r37_amount_resident;
	}
	public BigDecimal getR37_no_of_accounts_non_resident() {
		return r37_no_of_accounts_non_resident;
	}
	public void setR37_no_of_accounts_non_resident(BigDecimal r37_no_of_accounts_non_resident) {
		this.r37_no_of_accounts_non_resident = r37_no_of_accounts_non_resident;
	}
	public BigDecimal getR37_amount_non_resident() {
		return r37_amount_non_resident;
	}
	public void setR37_amount_non_resident(BigDecimal r37_amount_non_resident) {
		this.r37_amount_non_resident = r37_amount_non_resident;
	}
	public BigDecimal getR37_total_account() {
		return r37_total_account;
	}
	public void setR37_total_account(BigDecimal r37_total_account) {
		this.r37_total_account = r37_total_account;
	}
	public BigDecimal getR37_total_amount() {
		return r37_total_amount;
	}
	public void setR37_total_amount(BigDecimal r37_total_amount) {
		this.r37_total_amount = r37_total_amount;
	}
	public BigDecimal getR37_no_of_accounts_uae_abu() {
		return r37_no_of_accounts_uae_abu;
	}
	public void setR37_no_of_accounts_uae_abu(BigDecimal r37_no_of_accounts_uae_abu) {
		this.r37_no_of_accounts_uae_abu = r37_no_of_accounts_uae_abu;
	}
	public BigDecimal getR37_amount_uae_abu() {
		return r37_amount_uae_abu;
	}
	public void setR37_amount_uae_abu(BigDecimal r37_amount_uae_abu) {
		this.r37_amount_uae_abu = r37_amount_uae_abu;
	}
	public BigDecimal getR37_no_of_accounts_non_uae_abu() {
		return r37_no_of_accounts_non_uae_abu;
	}
	public void setR37_no_of_accounts_non_uae_abu(BigDecimal r37_no_of_accounts_non_uae_abu) {
		this.r37_no_of_accounts_non_uae_abu = r37_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR37_amount_non_uae_abu() {
		return r37_amount_non_uae_abu;
	}
	public void setR37_amount_non_uae_abu(BigDecimal r37_amount_non_uae_abu) {
		this.r37_amount_non_uae_abu = r37_amount_non_uae_abu;
	}
	public BigDecimal getR37_total_abu() {
		return r37_total_abu;
	}
	public void setR37_total_abu(BigDecimal r37_total_abu) {
		this.r37_total_abu = r37_total_abu;
	}
	public BigDecimal getR37_no_of_accounts_uae_dubai() {
		return r37_no_of_accounts_uae_dubai;
	}
	public void setR37_no_of_accounts_uae_dubai(BigDecimal r37_no_of_accounts_uae_dubai) {
		this.r37_no_of_accounts_uae_dubai = r37_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR37_amount_uae_dubai() {
		return r37_amount_uae_dubai;
	}
	public void setR37_amount_uae_dubai(BigDecimal r37_amount_uae_dubai) {
		this.r37_amount_uae_dubai = r37_amount_uae_dubai;
	}
	public BigDecimal getR37_no_of_accounts_non_uae_dubai() {
		return r37_no_of_accounts_non_uae_dubai;
	}
	public void setR37_no_of_accounts_non_uae_dubai(BigDecimal r37_no_of_accounts_non_uae_dubai) {
		this.r37_no_of_accounts_non_uae_dubai = r37_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR37_amount_non_uae_dubai() {
		return r37_amount_non_uae_dubai;
	}
	public void setR37_amount_non_uae_dubai(BigDecimal r37_amount_non_uae_dubai) {
		this.r37_amount_non_uae_dubai = r37_amount_non_uae_dubai;
	}
	public BigDecimal getR37_total_dubai() {
		return r37_total_dubai;
	}
	public void setR37_total_dubai(BigDecimal r37_total_dubai) {
		this.r37_total_dubai = r37_total_dubai;
	}
	public BigDecimal getR37_no_of_accounts_uae_sharjah() {
		return r37_no_of_accounts_uae_sharjah;
	}
	public void setR37_no_of_accounts_uae_sharjah(BigDecimal r37_no_of_accounts_uae_sharjah) {
		this.r37_no_of_accounts_uae_sharjah = r37_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR37_amount_uae_sharjah() {
		return r37_amount_uae_sharjah;
	}
	public void setR37_amount_uae_sharjah(BigDecimal r37_amount_uae_sharjah) {
		this.r37_amount_uae_sharjah = r37_amount_uae_sharjah;
	}
	public BigDecimal getR37_no_of_accounts_non_uae_sharjah() {
		return r37_no_of_accounts_non_uae_sharjah;
	}
	public void setR37_no_of_accounts_non_uae_sharjah(BigDecimal r37_no_of_accounts_non_uae_sharjah) {
		this.r37_no_of_accounts_non_uae_sharjah = r37_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR37_amount_non_uae_sharjah() {
		return r37_amount_non_uae_sharjah;
	}
	public void setR37_amount_non_uae_sharjah(BigDecimal r37_amount_non_uae_sharjah) {
		this.r37_amount_non_uae_sharjah = r37_amount_non_uae_sharjah;
	}
	public BigDecimal getR37_total_sharjah() {
		return r37_total_sharjah;
	}
	public void setR37_total_sharjah(BigDecimal r37_total_sharjah) {
		this.r37_total_sharjah = r37_total_sharjah;
	}
	public BigDecimal getR37_no_of_accounts_uae_ajman() {
		return r37_no_of_accounts_uae_ajman;
	}
	public void setR37_no_of_accounts_uae_ajman(BigDecimal r37_no_of_accounts_uae_ajman) {
		this.r37_no_of_accounts_uae_ajman = r37_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR37_amount_uae_ajman() {
		return r37_amount_uae_ajman;
	}
	public void setR37_amount_uae_ajman(BigDecimal r37_amount_uae_ajman) {
		this.r37_amount_uae_ajman = r37_amount_uae_ajman;
	}
	public BigDecimal getR37_no_of_accounts_non_uae_ajman() {
		return r37_no_of_accounts_non_uae_ajman;
	}
	public void setR37_no_of_accounts_non_uae_ajman(BigDecimal r37_no_of_accounts_non_uae_ajman) {
		this.r37_no_of_accounts_non_uae_ajman = r37_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR37_amount_non_uae_ajman() {
		return r37_amount_non_uae_ajman;
	}
	public void setR37_amount_non_uae_ajman(BigDecimal r37_amount_non_uae_ajman) {
		this.r37_amount_non_uae_ajman = r37_amount_non_uae_ajman;
	}
	public BigDecimal getR37_total_ajman() {
		return r37_total_ajman;
	}
	public void setR37_total_ajman(BigDecimal r37_total_ajman) {
		this.r37_total_ajman = r37_total_ajman;
	}
	public BigDecimal getR37_no_of_accounts_uae_ras() {
		return r37_no_of_accounts_uae_ras;
	}
	public void setR37_no_of_accounts_uae_ras(BigDecimal r37_no_of_accounts_uae_ras) {
		this.r37_no_of_accounts_uae_ras = r37_no_of_accounts_uae_ras;
	}
	public BigDecimal getR37_amount_uae_ras() {
		return r37_amount_uae_ras;
	}
	public void setR37_amount_uae_ras(BigDecimal r37_amount_uae_ras) {
		this.r37_amount_uae_ras = r37_amount_uae_ras;
	}
	public BigDecimal getR37_no_of_accounts_non_uae_ras() {
		return r37_no_of_accounts_non_uae_ras;
	}
	public void setR37_no_of_accounts_non_uae_ras(BigDecimal r37_no_of_accounts_non_uae_ras) {
		this.r37_no_of_accounts_non_uae_ras = r37_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR37_amount_non_uae_ras() {
		return r37_amount_non_uae_ras;
	}
	public void setR37_amount_non_uae_ras(BigDecimal r37_amount_non_uae_ras) {
		this.r37_amount_non_uae_ras = r37_amount_non_uae_ras;
	}
	public BigDecimal getR37_total_ras() {
		return r37_total_ras;
	}
	public void setR37_total_ras(BigDecimal r37_total_ras) {
		this.r37_total_ras = r37_total_ras;
	}
	public BigDecimal getR37_no_of_accounts_uae_umm() {
		return r37_no_of_accounts_uae_umm;
	}
	public void setR37_no_of_accounts_uae_umm(BigDecimal r37_no_of_accounts_uae_umm) {
		this.r37_no_of_accounts_uae_umm = r37_no_of_accounts_uae_umm;
	}
	public BigDecimal getR37_amount_uae_umm() {
		return r37_amount_uae_umm;
	}
	public void setR37_amount_uae_umm(BigDecimal r37_amount_uae_umm) {
		this.r37_amount_uae_umm = r37_amount_uae_umm;
	}
	public BigDecimal getR37_no_of_accounts_non_uae_umm() {
		return r37_no_of_accounts_non_uae_umm;
	}
	public void setR37_no_of_accounts_non_uae_umm(BigDecimal r37_no_of_accounts_non_uae_umm) {
		this.r37_no_of_accounts_non_uae_umm = r37_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR37_amount_non_uae_umm() {
		return r37_amount_non_uae_umm;
	}
	public void setR37_amount_non_uae_umm(BigDecimal r37_amount_non_uae_umm) {
		this.r37_amount_non_uae_umm = r37_amount_non_uae_umm;
	}
	public BigDecimal getR37_total_umm() {
		return r37_total_umm;
	}
	public void setR37_total_umm(BigDecimal r37_total_umm) {
		this.r37_total_umm = r37_total_umm;
	}
	public BigDecimal getR37_no_of_accounts_uae_fujairah() {
		return r37_no_of_accounts_uae_fujairah;
	}
	public void setR37_no_of_accounts_uae_fujairah(BigDecimal r37_no_of_accounts_uae_fujairah) {
		this.r37_no_of_accounts_uae_fujairah = r37_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR37_amount_uae_fujairah() {
		return r37_amount_uae_fujairah;
	}
	public void setR37_amount_uae_fujairah(BigDecimal r37_amount_uae_fujairah) {
		this.r37_amount_uae_fujairah = r37_amount_uae_fujairah;
	}
	public BigDecimal getR37_no_of_accounts_non_uae_fujairah() {
		return r37_no_of_accounts_non_uae_fujairah;
	}
	public void setR37_no_of_accounts_non_uae_fujairah(BigDecimal r37_no_of_accounts_non_uae_fujairah) {
		this.r37_no_of_accounts_non_uae_fujairah = r37_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR37_amount_non_uae_fujairah() {
		return r37_amount_non_uae_fujairah;
	}
	public void setR37_amount_non_uae_fujairah(BigDecimal r37_amount_non_uae_fujairah) {
		this.r37_amount_non_uae_fujairah = r37_amount_non_uae_fujairah;
	}
	public BigDecimal getR37_total_fujairah() {
		return r37_total_fujairah;
	}
	public void setR37_total_fujairah(BigDecimal r37_total_fujairah) {
		this.r37_total_fujairah = r37_total_fujairah;
	}
	public String getR38_product() {
		return r38_product;
	}
	public void setR38_product(String r38_product) {
		this.r38_product = r38_product;
	}
	public BigDecimal getR38_no_of_accounts_uae() {
		return r38_no_of_accounts_uae;
	}
	public void setR38_no_of_accounts_uae(BigDecimal r38_no_of_accounts_uae) {
		this.r38_no_of_accounts_uae = r38_no_of_accounts_uae;
	}
	public BigDecimal getR38_amount_uae() {
		return r38_amount_uae;
	}
	public void setR38_amount_uae(BigDecimal r38_amount_uae) {
		this.r38_amount_uae = r38_amount_uae;
	}
	public BigDecimal getR38_no_of_accounts_resident() {
		return r38_no_of_accounts_resident;
	}
	public void setR38_no_of_accounts_resident(BigDecimal r38_no_of_accounts_resident) {
		this.r38_no_of_accounts_resident = r38_no_of_accounts_resident;
	}
	public BigDecimal getR38_amount_resident() {
		return r38_amount_resident;
	}
	public void setR38_amount_resident(BigDecimal r38_amount_resident) {
		this.r38_amount_resident = r38_amount_resident;
	}
	public BigDecimal getR38_no_of_accounts_non_resident() {
		return r38_no_of_accounts_non_resident;
	}
	public void setR38_no_of_accounts_non_resident(BigDecimal r38_no_of_accounts_non_resident) {
		this.r38_no_of_accounts_non_resident = r38_no_of_accounts_non_resident;
	}
	public BigDecimal getR38_amount_non_resident() {
		return r38_amount_non_resident;
	}
	public void setR38_amount_non_resident(BigDecimal r38_amount_non_resident) {
		this.r38_amount_non_resident = r38_amount_non_resident;
	}
	public BigDecimal getR38_total_account() {
		return r38_total_account;
	}
	public void setR38_total_account(BigDecimal r38_total_account) {
		this.r38_total_account = r38_total_account;
	}
	public BigDecimal getR38_total_amount() {
		return r38_total_amount;
	}
	public void setR38_total_amount(BigDecimal r38_total_amount) {
		this.r38_total_amount = r38_total_amount;
	}
	public BigDecimal getR38_no_of_accounts_uae_abu() {
		return r38_no_of_accounts_uae_abu;
	}
	public void setR38_no_of_accounts_uae_abu(BigDecimal r38_no_of_accounts_uae_abu) {
		this.r38_no_of_accounts_uae_abu = r38_no_of_accounts_uae_abu;
	}
	public BigDecimal getR38_amount_uae_abu() {
		return r38_amount_uae_abu;
	}
	public void setR38_amount_uae_abu(BigDecimal r38_amount_uae_abu) {
		this.r38_amount_uae_abu = r38_amount_uae_abu;
	}
	public BigDecimal getR38_no_of_accounts_non_uae_abu() {
		return r38_no_of_accounts_non_uae_abu;
	}
	public void setR38_no_of_accounts_non_uae_abu(BigDecimal r38_no_of_accounts_non_uae_abu) {
		this.r38_no_of_accounts_non_uae_abu = r38_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR38_amount_non_uae_abu() {
		return r38_amount_non_uae_abu;
	}
	public void setR38_amount_non_uae_abu(BigDecimal r38_amount_non_uae_abu) {
		this.r38_amount_non_uae_abu = r38_amount_non_uae_abu;
	}
	public BigDecimal getR38_total_abu() {
		return r38_total_abu;
	}
	public void setR38_total_abu(BigDecimal r38_total_abu) {
		this.r38_total_abu = r38_total_abu;
	}
	public BigDecimal getR38_no_of_accounts_uae_dubai() {
		return r38_no_of_accounts_uae_dubai;
	}
	public void setR38_no_of_accounts_uae_dubai(BigDecimal r38_no_of_accounts_uae_dubai) {
		this.r38_no_of_accounts_uae_dubai = r38_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR38_amount_uae_dubai() {
		return r38_amount_uae_dubai;
	}
	public void setR38_amount_uae_dubai(BigDecimal r38_amount_uae_dubai) {
		this.r38_amount_uae_dubai = r38_amount_uae_dubai;
	}
	public BigDecimal getR38_no_of_accounts_non_uae_dubai() {
		return r38_no_of_accounts_non_uae_dubai;
	}
	public void setR38_no_of_accounts_non_uae_dubai(BigDecimal r38_no_of_accounts_non_uae_dubai) {
		this.r38_no_of_accounts_non_uae_dubai = r38_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR38_amount_non_uae_dubai() {
		return r38_amount_non_uae_dubai;
	}
	public void setR38_amount_non_uae_dubai(BigDecimal r38_amount_non_uae_dubai) {
		this.r38_amount_non_uae_dubai = r38_amount_non_uae_dubai;
	}
	public BigDecimal getR38_total_dubai() {
		return r38_total_dubai;
	}
	public void setR38_total_dubai(BigDecimal r38_total_dubai) {
		this.r38_total_dubai = r38_total_dubai;
	}
	public BigDecimal getR38_no_of_accounts_uae_sharjah() {
		return r38_no_of_accounts_uae_sharjah;
	}
	public void setR38_no_of_accounts_uae_sharjah(BigDecimal r38_no_of_accounts_uae_sharjah) {
		this.r38_no_of_accounts_uae_sharjah = r38_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR38_amount_uae_sharjah() {
		return r38_amount_uae_sharjah;
	}
	public void setR38_amount_uae_sharjah(BigDecimal r38_amount_uae_sharjah) {
		this.r38_amount_uae_sharjah = r38_amount_uae_sharjah;
	}
	public BigDecimal getR38_no_of_accounts_non_uae_sharjah() {
		return r38_no_of_accounts_non_uae_sharjah;
	}
	public void setR38_no_of_accounts_non_uae_sharjah(BigDecimal r38_no_of_accounts_non_uae_sharjah) {
		this.r38_no_of_accounts_non_uae_sharjah = r38_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR38_amount_non_uae_sharjah() {
		return r38_amount_non_uae_sharjah;
	}
	public void setR38_amount_non_uae_sharjah(BigDecimal r38_amount_non_uae_sharjah) {
		this.r38_amount_non_uae_sharjah = r38_amount_non_uae_sharjah;
	}
	public BigDecimal getR38_total_sharjah() {
		return r38_total_sharjah;
	}
	public void setR38_total_sharjah(BigDecimal r38_total_sharjah) {
		this.r38_total_sharjah = r38_total_sharjah;
	}
	public BigDecimal getR38_no_of_accounts_uae_ajman() {
		return r38_no_of_accounts_uae_ajman;
	}
	public void setR38_no_of_accounts_uae_ajman(BigDecimal r38_no_of_accounts_uae_ajman) {
		this.r38_no_of_accounts_uae_ajman = r38_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR38_amount_uae_ajman() {
		return r38_amount_uae_ajman;
	}
	public void setR38_amount_uae_ajman(BigDecimal r38_amount_uae_ajman) {
		this.r38_amount_uae_ajman = r38_amount_uae_ajman;
	}
	public BigDecimal getR38_no_of_accounts_non_uae_ajman() {
		return r38_no_of_accounts_non_uae_ajman;
	}
	public void setR38_no_of_accounts_non_uae_ajman(BigDecimal r38_no_of_accounts_non_uae_ajman) {
		this.r38_no_of_accounts_non_uae_ajman = r38_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR38_amount_non_uae_ajman() {
		return r38_amount_non_uae_ajman;
	}
	public void setR38_amount_non_uae_ajman(BigDecimal r38_amount_non_uae_ajman) {
		this.r38_amount_non_uae_ajman = r38_amount_non_uae_ajman;
	}
	public BigDecimal getR38_total_ajman() {
		return r38_total_ajman;
	}
	public void setR38_total_ajman(BigDecimal r38_total_ajman) {
		this.r38_total_ajman = r38_total_ajman;
	}
	public BigDecimal getR38_no_of_accounts_uae_ras() {
		return r38_no_of_accounts_uae_ras;
	}
	public void setR38_no_of_accounts_uae_ras(BigDecimal r38_no_of_accounts_uae_ras) {
		this.r38_no_of_accounts_uae_ras = r38_no_of_accounts_uae_ras;
	}
	public BigDecimal getR38_amount_uae_ras() {
		return r38_amount_uae_ras;
	}
	public void setR38_amount_uae_ras(BigDecimal r38_amount_uae_ras) {
		this.r38_amount_uae_ras = r38_amount_uae_ras;
	}
	public BigDecimal getR38_no_of_accounts_non_uae_ras() {
		return r38_no_of_accounts_non_uae_ras;
	}
	public void setR38_no_of_accounts_non_uae_ras(BigDecimal r38_no_of_accounts_non_uae_ras) {
		this.r38_no_of_accounts_non_uae_ras = r38_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR38_amount_non_uae_ras() {
		return r38_amount_non_uae_ras;
	}
	public void setR38_amount_non_uae_ras(BigDecimal r38_amount_non_uae_ras) {
		this.r38_amount_non_uae_ras = r38_amount_non_uae_ras;
	}
	public BigDecimal getR38_total_ras() {
		return r38_total_ras;
	}
	public void setR38_total_ras(BigDecimal r38_total_ras) {
		this.r38_total_ras = r38_total_ras;
	}
	public BigDecimal getR38_no_of_accounts_uae_umm() {
		return r38_no_of_accounts_uae_umm;
	}
	public void setR38_no_of_accounts_uae_umm(BigDecimal r38_no_of_accounts_uae_umm) {
		this.r38_no_of_accounts_uae_umm = r38_no_of_accounts_uae_umm;
	}
	public BigDecimal getR38_amount_uae_umm() {
		return r38_amount_uae_umm;
	}
	public void setR38_amount_uae_umm(BigDecimal r38_amount_uae_umm) {
		this.r38_amount_uae_umm = r38_amount_uae_umm;
	}
	public BigDecimal getR38_no_of_accounts_non_uae_umm() {
		return r38_no_of_accounts_non_uae_umm;
	}
	public void setR38_no_of_accounts_non_uae_umm(BigDecimal r38_no_of_accounts_non_uae_umm) {
		this.r38_no_of_accounts_non_uae_umm = r38_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR38_amount_non_uae_umm() {
		return r38_amount_non_uae_umm;
	}
	public void setR38_amount_non_uae_umm(BigDecimal r38_amount_non_uae_umm) {
		this.r38_amount_non_uae_umm = r38_amount_non_uae_umm;
	}
	public BigDecimal getR38_total_umm() {
		return r38_total_umm;
	}
	public void setR38_total_umm(BigDecimal r38_total_umm) {
		this.r38_total_umm = r38_total_umm;
	}
	public BigDecimal getR38_no_of_accounts_uae_fujairah() {
		return r38_no_of_accounts_uae_fujairah;
	}
	public void setR38_no_of_accounts_uae_fujairah(BigDecimal r38_no_of_accounts_uae_fujairah) {
		this.r38_no_of_accounts_uae_fujairah = r38_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR38_amount_uae_fujairah() {
		return r38_amount_uae_fujairah;
	}
	public void setR38_amount_uae_fujairah(BigDecimal r38_amount_uae_fujairah) {
		this.r38_amount_uae_fujairah = r38_amount_uae_fujairah;
	}
	public BigDecimal getR38_no_of_accounts_non_uae_fujairah() {
		return r38_no_of_accounts_non_uae_fujairah;
	}
	public void setR38_no_of_accounts_non_uae_fujairah(BigDecimal r38_no_of_accounts_non_uae_fujairah) {
		this.r38_no_of_accounts_non_uae_fujairah = r38_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR38_amount_non_uae_fujairah() {
		return r38_amount_non_uae_fujairah;
	}
	public void setR38_amount_non_uae_fujairah(BigDecimal r38_amount_non_uae_fujairah) {
		this.r38_amount_non_uae_fujairah = r38_amount_non_uae_fujairah;
	}
	public BigDecimal getR38_total_fujairah() {
		return r38_total_fujairah;
	}
	public void setR38_total_fujairah(BigDecimal r38_total_fujairah) {
		this.r38_total_fujairah = r38_total_fujairah;
	}
	public String getR39_product() {
		return r39_product;
	}
	public void setR39_product(String r39_product) {
		this.r39_product = r39_product;
	}
	public BigDecimal getR39_no_of_accounts_uae() {
		return r39_no_of_accounts_uae;
	}
	public void setR39_no_of_accounts_uae(BigDecimal r39_no_of_accounts_uae) {
		this.r39_no_of_accounts_uae = r39_no_of_accounts_uae;
	}
	public BigDecimal getR39_amount_uae() {
		return r39_amount_uae;
	}
	public void setR39_amount_uae(BigDecimal r39_amount_uae) {
		this.r39_amount_uae = r39_amount_uae;
	}
	public BigDecimal getR39_no_of_accounts_resident() {
		return r39_no_of_accounts_resident;
	}
	public void setR39_no_of_accounts_resident(BigDecimal r39_no_of_accounts_resident) {
		this.r39_no_of_accounts_resident = r39_no_of_accounts_resident;
	}
	public BigDecimal getR39_amount_resident() {
		return r39_amount_resident;
	}
	public void setR39_amount_resident(BigDecimal r39_amount_resident) {
		this.r39_amount_resident = r39_amount_resident;
	}
	public BigDecimal getR39_no_of_accounts_non_resident() {
		return r39_no_of_accounts_non_resident;
	}
	public void setR39_no_of_accounts_non_resident(BigDecimal r39_no_of_accounts_non_resident) {
		this.r39_no_of_accounts_non_resident = r39_no_of_accounts_non_resident;
	}
	public BigDecimal getR39_amount_non_resident() {
		return r39_amount_non_resident;
	}
	public void setR39_amount_non_resident(BigDecimal r39_amount_non_resident) {
		this.r39_amount_non_resident = r39_amount_non_resident;
	}
	public BigDecimal getR39_total_account() {
		return r39_total_account;
	}
	public void setR39_total_account(BigDecimal r39_total_account) {
		this.r39_total_account = r39_total_account;
	}
	public BigDecimal getR39_total_amount() {
		return r39_total_amount;
	}
	public void setR39_total_amount(BigDecimal r39_total_amount) {
		this.r39_total_amount = r39_total_amount;
	}
	public BigDecimal getR39_no_of_accounts_uae_abu() {
		return r39_no_of_accounts_uae_abu;
	}
	public void setR39_no_of_accounts_uae_abu(BigDecimal r39_no_of_accounts_uae_abu) {
		this.r39_no_of_accounts_uae_abu = r39_no_of_accounts_uae_abu;
	}
	public BigDecimal getR39_amount_uae_abu() {
		return r39_amount_uae_abu;
	}
	public void setR39_amount_uae_abu(BigDecimal r39_amount_uae_abu) {
		this.r39_amount_uae_abu = r39_amount_uae_abu;
	}
	public BigDecimal getR39_no_of_accounts_non_uae_abu() {
		return r39_no_of_accounts_non_uae_abu;
	}
	public void setR39_no_of_accounts_non_uae_abu(BigDecimal r39_no_of_accounts_non_uae_abu) {
		this.r39_no_of_accounts_non_uae_abu = r39_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR39_amount_non_uae_abu() {
		return r39_amount_non_uae_abu;
	}
	public void setR39_amount_non_uae_abu(BigDecimal r39_amount_non_uae_abu) {
		this.r39_amount_non_uae_abu = r39_amount_non_uae_abu;
	}
	public BigDecimal getR39_total_abu() {
		return r39_total_abu;
	}
	public void setR39_total_abu(BigDecimal r39_total_abu) {
		this.r39_total_abu = r39_total_abu;
	}
	public BigDecimal getR39_no_of_accounts_uae_dubai() {
		return r39_no_of_accounts_uae_dubai;
	}
	public void setR39_no_of_accounts_uae_dubai(BigDecimal r39_no_of_accounts_uae_dubai) {
		this.r39_no_of_accounts_uae_dubai = r39_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR39_amount_uae_dubai() {
		return r39_amount_uae_dubai;
	}
	public void setR39_amount_uae_dubai(BigDecimal r39_amount_uae_dubai) {
		this.r39_amount_uae_dubai = r39_amount_uae_dubai;
	}
	public BigDecimal getR39_no_of_accounts_non_uae_dubai() {
		return r39_no_of_accounts_non_uae_dubai;
	}
	public void setR39_no_of_accounts_non_uae_dubai(BigDecimal r39_no_of_accounts_non_uae_dubai) {
		this.r39_no_of_accounts_non_uae_dubai = r39_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR39_amount_non_uae_dubai() {
		return r39_amount_non_uae_dubai;
	}
	public void setR39_amount_non_uae_dubai(BigDecimal r39_amount_non_uae_dubai) {
		this.r39_amount_non_uae_dubai = r39_amount_non_uae_dubai;
	}
	public BigDecimal getR39_total_dubai() {
		return r39_total_dubai;
	}
	public void setR39_total_dubai(BigDecimal r39_total_dubai) {
		this.r39_total_dubai = r39_total_dubai;
	}
	public BigDecimal getR39_no_of_accounts_uae_sharjah() {
		return r39_no_of_accounts_uae_sharjah;
	}
	public void setR39_no_of_accounts_uae_sharjah(BigDecimal r39_no_of_accounts_uae_sharjah) {
		this.r39_no_of_accounts_uae_sharjah = r39_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR39_amount_uae_sharjah() {
		return r39_amount_uae_sharjah;
	}
	public void setR39_amount_uae_sharjah(BigDecimal r39_amount_uae_sharjah) {
		this.r39_amount_uae_sharjah = r39_amount_uae_sharjah;
	}
	public BigDecimal getR39_no_of_accounts_non_uae_sharjah() {
		return r39_no_of_accounts_non_uae_sharjah;
	}
	public void setR39_no_of_accounts_non_uae_sharjah(BigDecimal r39_no_of_accounts_non_uae_sharjah) {
		this.r39_no_of_accounts_non_uae_sharjah = r39_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR39_amount_non_uae_sharjah() {
		return r39_amount_non_uae_sharjah;
	}
	public void setR39_amount_non_uae_sharjah(BigDecimal r39_amount_non_uae_sharjah) {
		this.r39_amount_non_uae_sharjah = r39_amount_non_uae_sharjah;
	}
	public BigDecimal getR39_total_sharjah() {
		return r39_total_sharjah;
	}
	public void setR39_total_sharjah(BigDecimal r39_total_sharjah) {
		this.r39_total_sharjah = r39_total_sharjah;
	}
	public BigDecimal getR39_no_of_accounts_uae_ajman() {
		return r39_no_of_accounts_uae_ajman;
	}
	public void setR39_no_of_accounts_uae_ajman(BigDecimal r39_no_of_accounts_uae_ajman) {
		this.r39_no_of_accounts_uae_ajman = r39_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR39_amount_uae_ajman() {
		return r39_amount_uae_ajman;
	}
	public void setR39_amount_uae_ajman(BigDecimal r39_amount_uae_ajman) {
		this.r39_amount_uae_ajman = r39_amount_uae_ajman;
	}
	public BigDecimal getR39_no_of_accounts_non_uae_ajman() {
		return r39_no_of_accounts_non_uae_ajman;
	}
	public void setR39_no_of_accounts_non_uae_ajman(BigDecimal r39_no_of_accounts_non_uae_ajman) {
		this.r39_no_of_accounts_non_uae_ajman = r39_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR39_amount_non_uae_ajman() {
		return r39_amount_non_uae_ajman;
	}
	public void setR39_amount_non_uae_ajman(BigDecimal r39_amount_non_uae_ajman) {
		this.r39_amount_non_uae_ajman = r39_amount_non_uae_ajman;
	}
	public BigDecimal getR39_total_ajman() {
		return r39_total_ajman;
	}
	public void setR39_total_ajman(BigDecimal r39_total_ajman) {
		this.r39_total_ajman = r39_total_ajman;
	}
	public BigDecimal getR39_no_of_accounts_uae_ras() {
		return r39_no_of_accounts_uae_ras;
	}
	public void setR39_no_of_accounts_uae_ras(BigDecimal r39_no_of_accounts_uae_ras) {
		this.r39_no_of_accounts_uae_ras = r39_no_of_accounts_uae_ras;
	}
	public BigDecimal getR39_amount_uae_ras() {
		return r39_amount_uae_ras;
	}
	public void setR39_amount_uae_ras(BigDecimal r39_amount_uae_ras) {
		this.r39_amount_uae_ras = r39_amount_uae_ras;
	}
	public BigDecimal getR39_no_of_accounts_non_uae_ras() {
		return r39_no_of_accounts_non_uae_ras;
	}
	public void setR39_no_of_accounts_non_uae_ras(BigDecimal r39_no_of_accounts_non_uae_ras) {
		this.r39_no_of_accounts_non_uae_ras = r39_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR39_amount_non_uae_ras() {
		return r39_amount_non_uae_ras;
	}
	public void setR39_amount_non_uae_ras(BigDecimal r39_amount_non_uae_ras) {
		this.r39_amount_non_uae_ras = r39_amount_non_uae_ras;
	}
	public BigDecimal getR39_total_ras() {
		return r39_total_ras;
	}
	public void setR39_total_ras(BigDecimal r39_total_ras) {
		this.r39_total_ras = r39_total_ras;
	}
	public BigDecimal getR39_no_of_accounts_uae_umm() {
		return r39_no_of_accounts_uae_umm;
	}
	public void setR39_no_of_accounts_uae_umm(BigDecimal r39_no_of_accounts_uae_umm) {
		this.r39_no_of_accounts_uae_umm = r39_no_of_accounts_uae_umm;
	}
	public BigDecimal getR39_amount_uae_umm() {
		return r39_amount_uae_umm;
	}
	public void setR39_amount_uae_umm(BigDecimal r39_amount_uae_umm) {
		this.r39_amount_uae_umm = r39_amount_uae_umm;
	}
	public BigDecimal getR39_no_of_accounts_non_uae_umm() {
		return r39_no_of_accounts_non_uae_umm;
	}
	public void setR39_no_of_accounts_non_uae_umm(BigDecimal r39_no_of_accounts_non_uae_umm) {
		this.r39_no_of_accounts_non_uae_umm = r39_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR39_amount_non_uae_umm() {
		return r39_amount_non_uae_umm;
	}
	public void setR39_amount_non_uae_umm(BigDecimal r39_amount_non_uae_umm) {
		this.r39_amount_non_uae_umm = r39_amount_non_uae_umm;
	}
	public BigDecimal getR39_total_umm() {
		return r39_total_umm;
	}
	public void setR39_total_umm(BigDecimal r39_total_umm) {
		this.r39_total_umm = r39_total_umm;
	}
	public BigDecimal getR39_no_of_accounts_uae_fujairah() {
		return r39_no_of_accounts_uae_fujairah;
	}
	public void setR39_no_of_accounts_uae_fujairah(BigDecimal r39_no_of_accounts_uae_fujairah) {
		this.r39_no_of_accounts_uae_fujairah = r39_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR39_amount_uae_fujairah() {
		return r39_amount_uae_fujairah;
	}
	public void setR39_amount_uae_fujairah(BigDecimal r39_amount_uae_fujairah) {
		this.r39_amount_uae_fujairah = r39_amount_uae_fujairah;
	}
	public BigDecimal getR39_no_of_accounts_non_uae_fujairah() {
		return r39_no_of_accounts_non_uae_fujairah;
	}
	public void setR39_no_of_accounts_non_uae_fujairah(BigDecimal r39_no_of_accounts_non_uae_fujairah) {
		this.r39_no_of_accounts_non_uae_fujairah = r39_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR39_amount_non_uae_fujairah() {
		return r39_amount_non_uae_fujairah;
	}
	public void setR39_amount_non_uae_fujairah(BigDecimal r39_amount_non_uae_fujairah) {
		this.r39_amount_non_uae_fujairah = r39_amount_non_uae_fujairah;
	}
	public BigDecimal getR39_total_fujairah() {
		return r39_total_fujairah;
	}
	public void setR39_total_fujairah(BigDecimal r39_total_fujairah) {
		this.r39_total_fujairah = r39_total_fujairah;
	}
	public String getR40_product() {
		return r40_product;
	}
	public void setR40_product(String r40_product) {
		this.r40_product = r40_product;
	}
	public BigDecimal getR40_no_of_accounts_uae() {
		return r40_no_of_accounts_uae;
	}
	public void setR40_no_of_accounts_uae(BigDecimal r40_no_of_accounts_uae) {
		this.r40_no_of_accounts_uae = r40_no_of_accounts_uae;
	}
	public BigDecimal getR40_amount_uae() {
		return r40_amount_uae;
	}
	public void setR40_amount_uae(BigDecimal r40_amount_uae) {
		this.r40_amount_uae = r40_amount_uae;
	}
	public BigDecimal getR40_no_of_accounts_resident() {
		return r40_no_of_accounts_resident;
	}
	public void setR40_no_of_accounts_resident(BigDecimal r40_no_of_accounts_resident) {
		this.r40_no_of_accounts_resident = r40_no_of_accounts_resident;
	}
	public BigDecimal getR40_amount_resident() {
		return r40_amount_resident;
	}
	public void setR40_amount_resident(BigDecimal r40_amount_resident) {
		this.r40_amount_resident = r40_amount_resident;
	}
	public BigDecimal getR40_no_of_accounts_non_resident() {
		return r40_no_of_accounts_non_resident;
	}
	public void setR40_no_of_accounts_non_resident(BigDecimal r40_no_of_accounts_non_resident) {
		this.r40_no_of_accounts_non_resident = r40_no_of_accounts_non_resident;
	}
	public BigDecimal getR40_amount_non_resident() {
		return r40_amount_non_resident;
	}
	public void setR40_amount_non_resident(BigDecimal r40_amount_non_resident) {
		this.r40_amount_non_resident = r40_amount_non_resident;
	}
	public BigDecimal getR40_total_account() {
		return r40_total_account;
	}
	public void setR40_total_account(BigDecimal r40_total_account) {
		this.r40_total_account = r40_total_account;
	}
	public BigDecimal getR40_total_amount() {
		return r40_total_amount;
	}
	public void setR40_total_amount(BigDecimal r40_total_amount) {
		this.r40_total_amount = r40_total_amount;
	}
	public BigDecimal getR40_no_of_accounts_uae_abu() {
		return r40_no_of_accounts_uae_abu;
	}
	public void setR40_no_of_accounts_uae_abu(BigDecimal r40_no_of_accounts_uae_abu) {
		this.r40_no_of_accounts_uae_abu = r40_no_of_accounts_uae_abu;
	}
	public BigDecimal getR40_amount_uae_abu() {
		return r40_amount_uae_abu;
	}
	public void setR40_amount_uae_abu(BigDecimal r40_amount_uae_abu) {
		this.r40_amount_uae_abu = r40_amount_uae_abu;
	}
	public BigDecimal getR40_no_of_accounts_non_uae_abu() {
		return r40_no_of_accounts_non_uae_abu;
	}
	public void setR40_no_of_accounts_non_uae_abu(BigDecimal r40_no_of_accounts_non_uae_abu) {
		this.r40_no_of_accounts_non_uae_abu = r40_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR40_amount_non_uae_abu() {
		return r40_amount_non_uae_abu;
	}
	public void setR40_amount_non_uae_abu(BigDecimal r40_amount_non_uae_abu) {
		this.r40_amount_non_uae_abu = r40_amount_non_uae_abu;
	}
	public BigDecimal getR40_total_abu() {
		return r40_total_abu;
	}
	public void setR40_total_abu(BigDecimal r40_total_abu) {
		this.r40_total_abu = r40_total_abu;
	}
	public BigDecimal getR40_no_of_accounts_uae_dubai() {
		return r40_no_of_accounts_uae_dubai;
	}
	public void setR40_no_of_accounts_uae_dubai(BigDecimal r40_no_of_accounts_uae_dubai) {
		this.r40_no_of_accounts_uae_dubai = r40_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR40_amount_uae_dubai() {
		return r40_amount_uae_dubai;
	}
	public void setR40_amount_uae_dubai(BigDecimal r40_amount_uae_dubai) {
		this.r40_amount_uae_dubai = r40_amount_uae_dubai;
	}
	public BigDecimal getR40_no_of_accounts_non_uae_dubai() {
		return r40_no_of_accounts_non_uae_dubai;
	}
	public void setR40_no_of_accounts_non_uae_dubai(BigDecimal r40_no_of_accounts_non_uae_dubai) {
		this.r40_no_of_accounts_non_uae_dubai = r40_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR40_amount_non_uae_dubai() {
		return r40_amount_non_uae_dubai;
	}
	public void setR40_amount_non_uae_dubai(BigDecimal r40_amount_non_uae_dubai) {
		this.r40_amount_non_uae_dubai = r40_amount_non_uae_dubai;
	}
	public BigDecimal getR40_total_dubai() {
		return r40_total_dubai;
	}
	public void setR40_total_dubai(BigDecimal r40_total_dubai) {
		this.r40_total_dubai = r40_total_dubai;
	}
	public BigDecimal getR40_no_of_accounts_uae_sharjah() {
		return r40_no_of_accounts_uae_sharjah;
	}
	public void setR40_no_of_accounts_uae_sharjah(BigDecimal r40_no_of_accounts_uae_sharjah) {
		this.r40_no_of_accounts_uae_sharjah = r40_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR40_amount_uae_sharjah() {
		return r40_amount_uae_sharjah;
	}
	public void setR40_amount_uae_sharjah(BigDecimal r40_amount_uae_sharjah) {
		this.r40_amount_uae_sharjah = r40_amount_uae_sharjah;
	}
	public BigDecimal getR40_no_of_accounts_non_uae_sharjah() {
		return r40_no_of_accounts_non_uae_sharjah;
	}
	public void setR40_no_of_accounts_non_uae_sharjah(BigDecimal r40_no_of_accounts_non_uae_sharjah) {
		this.r40_no_of_accounts_non_uae_sharjah = r40_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR40_amount_non_uae_sharjah() {
		return r40_amount_non_uae_sharjah;
	}
	public void setR40_amount_non_uae_sharjah(BigDecimal r40_amount_non_uae_sharjah) {
		this.r40_amount_non_uae_sharjah = r40_amount_non_uae_sharjah;
	}
	public BigDecimal getR40_total_sharjah() {
		return r40_total_sharjah;
	}
	public void setR40_total_sharjah(BigDecimal r40_total_sharjah) {
		this.r40_total_sharjah = r40_total_sharjah;
	}
	public BigDecimal getR40_no_of_accounts_uae_ajman() {
		return r40_no_of_accounts_uae_ajman;
	}
	public void setR40_no_of_accounts_uae_ajman(BigDecimal r40_no_of_accounts_uae_ajman) {
		this.r40_no_of_accounts_uae_ajman = r40_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR40_amount_uae_ajman() {
		return r40_amount_uae_ajman;
	}
	public void setR40_amount_uae_ajman(BigDecimal r40_amount_uae_ajman) {
		this.r40_amount_uae_ajman = r40_amount_uae_ajman;
	}
	public BigDecimal getR40_no_of_accounts_non_uae_ajman() {
		return r40_no_of_accounts_non_uae_ajman;
	}
	public void setR40_no_of_accounts_non_uae_ajman(BigDecimal r40_no_of_accounts_non_uae_ajman) {
		this.r40_no_of_accounts_non_uae_ajman = r40_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR40_amount_non_uae_ajman() {
		return r40_amount_non_uae_ajman;
	}
	public void setR40_amount_non_uae_ajman(BigDecimal r40_amount_non_uae_ajman) {
		this.r40_amount_non_uae_ajman = r40_amount_non_uae_ajman;
	}
	public BigDecimal getR40_total_ajman() {
		return r40_total_ajman;
	}
	public void setR40_total_ajman(BigDecimal r40_total_ajman) {
		this.r40_total_ajman = r40_total_ajman;
	}
	public BigDecimal getR40_no_of_accounts_uae_ras() {
		return r40_no_of_accounts_uae_ras;
	}
	public void setR40_no_of_accounts_uae_ras(BigDecimal r40_no_of_accounts_uae_ras) {
		this.r40_no_of_accounts_uae_ras = r40_no_of_accounts_uae_ras;
	}
	public BigDecimal getR40_amount_uae_ras() {
		return r40_amount_uae_ras;
	}
	public void setR40_amount_uae_ras(BigDecimal r40_amount_uae_ras) {
		this.r40_amount_uae_ras = r40_amount_uae_ras;
	}
	public BigDecimal getR40_no_of_accounts_non_uae_ras() {
		return r40_no_of_accounts_non_uae_ras;
	}
	public void setR40_no_of_accounts_non_uae_ras(BigDecimal r40_no_of_accounts_non_uae_ras) {
		this.r40_no_of_accounts_non_uae_ras = r40_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR40_amount_non_uae_ras() {
		return r40_amount_non_uae_ras;
	}
	public void setR40_amount_non_uae_ras(BigDecimal r40_amount_non_uae_ras) {
		this.r40_amount_non_uae_ras = r40_amount_non_uae_ras;
	}
	public BigDecimal getR40_total_ras() {
		return r40_total_ras;
	}
	public void setR40_total_ras(BigDecimal r40_total_ras) {
		this.r40_total_ras = r40_total_ras;
	}
	public BigDecimal getR40_no_of_accounts_uae_umm() {
		return r40_no_of_accounts_uae_umm;
	}
	public void setR40_no_of_accounts_uae_umm(BigDecimal r40_no_of_accounts_uae_umm) {
		this.r40_no_of_accounts_uae_umm = r40_no_of_accounts_uae_umm;
	}
	public BigDecimal getR40_amount_uae_umm() {
		return r40_amount_uae_umm;
	}
	public void setR40_amount_uae_umm(BigDecimal r40_amount_uae_umm) {
		this.r40_amount_uae_umm = r40_amount_uae_umm;
	}
	public BigDecimal getR40_no_of_accounts_non_uae_umm() {
		return r40_no_of_accounts_non_uae_umm;
	}
	public void setR40_no_of_accounts_non_uae_umm(BigDecimal r40_no_of_accounts_non_uae_umm) {
		this.r40_no_of_accounts_non_uae_umm = r40_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR40_amount_non_uae_umm() {
		return r40_amount_non_uae_umm;
	}
	public void setR40_amount_non_uae_umm(BigDecimal r40_amount_non_uae_umm) {
		this.r40_amount_non_uae_umm = r40_amount_non_uae_umm;
	}
	public BigDecimal getR40_total_umm() {
		return r40_total_umm;
	}
	public void setR40_total_umm(BigDecimal r40_total_umm) {
		this.r40_total_umm = r40_total_umm;
	}
	public BigDecimal getR40_no_of_accounts_uae_fujairah() {
		return r40_no_of_accounts_uae_fujairah;
	}
	public void setR40_no_of_accounts_uae_fujairah(BigDecimal r40_no_of_accounts_uae_fujairah) {
		this.r40_no_of_accounts_uae_fujairah = r40_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR40_amount_uae_fujairah() {
		return r40_amount_uae_fujairah;
	}
	public void setR40_amount_uae_fujairah(BigDecimal r40_amount_uae_fujairah) {
		this.r40_amount_uae_fujairah = r40_amount_uae_fujairah;
	}
	public BigDecimal getR40_no_of_accounts_non_uae_fujairah() {
		return r40_no_of_accounts_non_uae_fujairah;
	}
	public void setR40_no_of_accounts_non_uae_fujairah(BigDecimal r40_no_of_accounts_non_uae_fujairah) {
		this.r40_no_of_accounts_non_uae_fujairah = r40_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR40_amount_non_uae_fujairah() {
		return r40_amount_non_uae_fujairah;
	}
	public void setR40_amount_non_uae_fujairah(BigDecimal r40_amount_non_uae_fujairah) {
		this.r40_amount_non_uae_fujairah = r40_amount_non_uae_fujairah;
	}
	public BigDecimal getR40_total_fujairah() {
		return r40_total_fujairah;
	}
	public void setR40_total_fujairah(BigDecimal r40_total_fujairah) {
		this.r40_total_fujairah = r40_total_fujairah;
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
	public BRF41_Entity2() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
