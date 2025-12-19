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
@Table(name = "BRF41C_SUMMARYTABLE")
public class BRF41_Entity3 {
	private String	r41_product;
	private BigDecimal	r41_no_of_accounts_uae;
	private BigDecimal	r41_amount_uae;
	private BigDecimal	r41_no_of_accounts_resident;
	private BigDecimal	r41_amount_resident;
	private BigDecimal	r41_no_of_accounts_non_resident;
	private BigDecimal	r41_amount_non_resident;
	private BigDecimal	r41_total_account;
	private BigDecimal	r41_total_amount;
	private BigDecimal	r41_no_of_accounts_uae_abu;
	private BigDecimal	r41_amount_uae_abu;
	private BigDecimal	r41_no_of_accounts_non_uae_abu;
	private BigDecimal	r41_amount_non_uae_abu;
	private BigDecimal	r41_total_abu;
	private BigDecimal	r41_no_of_accounts_uae_dubai;
	private BigDecimal	r41_amount_uae_dubai;
	private BigDecimal	r41_no_of_accounts_non_uae_dubai;
	private BigDecimal	r41_amount_non_uae_dubai;
	private BigDecimal	r41_total_dubai;
	private BigDecimal	r41_no_of_accounts_uae_sharjah;
	private BigDecimal	r41_amount_uae_sharjah;
	private BigDecimal	r41_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r41_amount_non_uae_sharjah;
	private BigDecimal	r41_total_sharjah;
	private BigDecimal	r41_no_of_accounts_uae_ajman;
	private BigDecimal	r41_amount_uae_ajman;
	private BigDecimal	r41_no_of_accounts_non_uae_ajman;
	private BigDecimal	r41_amount_non_uae_ajman;
	private BigDecimal	r41_total_ajman;
	private BigDecimal	r41_no_of_accounts_uae_ras ;
	private BigDecimal	r41_amount_uae_ras ;
	private BigDecimal	r41_no_of_accounts_non_uae_ras ;
	private BigDecimal	r41_amount_non_uae_ras ;
	private BigDecimal	r41_total_ras ;
	private BigDecimal	r41_no_of_accounts_uae_umm ;
	private BigDecimal	r41_amount_uae_umm ;
	private BigDecimal	r41_no_of_accounts_non_uae_umm ;
	private BigDecimal	r41_amount_non_uae_umm ;
	private BigDecimal	r41_total_umm ;
	private BigDecimal	r41_no_of_accounts_uae_fujairah;
	private BigDecimal	r41_amount_uae_fujairah;
	private BigDecimal	r41_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r41_amount_non_uae_fujairah;
	private BigDecimal	r41_total_fujairah;
	private String	r42_product;
	private BigDecimal	r42_no_of_accounts_uae;
	private BigDecimal	r42_amount_uae;
	private BigDecimal	r42_no_of_accounts_resident;
	private BigDecimal	r42_amount_resident;
	private BigDecimal	r42_no_of_accounts_non_resident;
	private BigDecimal	r42_amount_non_resident;
	private BigDecimal	r42_total_account;
	private BigDecimal	r42_total_amount;
	private BigDecimal	r42_no_of_accounts_uae_abu;
	private BigDecimal	r42_amount_uae_abu;
	private BigDecimal	r42_no_of_accounts_non_uae_abu;
	private BigDecimal	r42_amount_non_uae_abu;
	private BigDecimal	r42_total_abu;
	private BigDecimal	r42_no_of_accounts_uae_dubai;
	private BigDecimal	r42_amount_uae_dubai;
	private BigDecimal	r42_no_of_accounts_non_uae_dubai;
	private BigDecimal	r42_amount_non_uae_dubai;
	private BigDecimal	r42_total_dubai;
	private BigDecimal	r42_no_of_accounts_uae_sharjah;
	private BigDecimal	r42_amount_uae_sharjah;
	private BigDecimal	r42_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r42_amount_non_uae_sharjah;
	private BigDecimal	r42_total_sharjah;
	private BigDecimal	r42_no_of_accounts_uae_ajman;
	private BigDecimal	r42_amount_uae_ajman;
	private BigDecimal	r42_no_of_accounts_non_uae_ajman;
	private BigDecimal	r42_amount_non_uae_ajman;
	private BigDecimal	r42_total_ajman;
	private BigDecimal	r42_no_of_accounts_uae_ras ;
	private BigDecimal	r42_amount_uae_ras ;
	private BigDecimal	r42_no_of_accounts_non_uae_ras ;
	private BigDecimal	r42_amount_non_uae_ras ;
	private BigDecimal	r42_total_ras ;
	private BigDecimal	r42_no_of_accounts_uae_umm ;
	private BigDecimal	r42_amount_uae_umm ;
	private BigDecimal	r42_no_of_accounts_non_uae_umm ;
	private BigDecimal	r42_amount_non_uae_umm ;
	private BigDecimal	r42_total_umm ;
	private BigDecimal	r42_no_of_accounts_uae_fujairah;
	private BigDecimal	r42_amount_uae_fujairah;
	private BigDecimal	r42_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r42_amount_non_uae_fujairah;
	private BigDecimal	r42_total_fujairah;
	private String	r43_product;
	private BigDecimal	r43_no_of_accounts_uae;
	private BigDecimal	r43_amount_uae;
	private BigDecimal	r43_no_of_accounts_resident;
	private BigDecimal	r43_amount_resident;
	private BigDecimal	r43_no_of_accounts_non_resident;
	private BigDecimal	r43_amount_non_resident;
	private BigDecimal	r43_total_account;
	private BigDecimal	r43_total_amount;
	private BigDecimal	r43_no_of_accounts_uae_abu;
	private BigDecimal	r43_amount_uae_abu;
	private BigDecimal	r43_no_of_accounts_non_uae_abu;
	private BigDecimal	r43_amount_non_uae_abu;
	private BigDecimal	r43_total_abu;
	private BigDecimal	r43_no_of_accounts_uae_dubai;
	private BigDecimal	r43_amount_uae_dubai;
	private BigDecimal	r43_no_of_accounts_non_uae_dubai;
	private BigDecimal	r43_amount_non_uae_dubai;
	private BigDecimal	r43_total_dubai;
	private BigDecimal	r43_no_of_accounts_uae_sharjah;
	private BigDecimal	r43_amount_uae_sharjah;
	private BigDecimal	r43_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r43_amount_non_uae_sharjah;
	private BigDecimal	r43_total_sharjah;
	private BigDecimal	r43_no_of_accounts_uae_ajman;
	private BigDecimal	r43_amount_uae_ajman;
	private BigDecimal	r43_no_of_accounts_non_uae_ajman;
	private BigDecimal	r43_amount_non_uae_ajman;
	private BigDecimal	r43_total_ajman;
	private BigDecimal	r43_no_of_accounts_uae_ras ;
	private BigDecimal	r43_amount_uae_ras ;
	private BigDecimal	r43_no_of_accounts_non_uae_ras ;
	private BigDecimal	r43_amount_non_uae_ras ;
	private BigDecimal	r43_total_ras ;
	private BigDecimal	r43_no_of_accounts_uae_umm ;
	private BigDecimal	r43_amount_uae_umm ;
	private BigDecimal	r43_no_of_accounts_non_uae_umm ;
	private BigDecimal	r43_amount_non_uae_umm ;
	private BigDecimal	r43_total_umm ;
	private BigDecimal	r43_no_of_accounts_uae_fujairah;
	private BigDecimal	r43_amount_uae_fujairah;
	private BigDecimal	r43_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r43_amount_non_uae_fujairah;
	private BigDecimal	r43_total_fujairah;
	private String	r44_product;
	private BigDecimal	r44_no_of_accounts_uae;
	private BigDecimal	r44_amount_uae;
	private BigDecimal	r44_no_of_accounts_resident;
	private BigDecimal	r44_amount_resident;
	private BigDecimal	r44_no_of_accounts_non_resident;
	private BigDecimal	r44_amount_non_resident;
	private BigDecimal	r44_total_account;
	private BigDecimal	r44_total_amount;
	private BigDecimal	r44_no_of_accounts_uae_abu;
	private BigDecimal	r44_amount_uae_abu;
	private BigDecimal	r44_no_of_accounts_non_uae_abu;
	private BigDecimal	r44_amount_non_uae_abu;
	private BigDecimal	r44_total_abu;
	private BigDecimal	r44_no_of_accounts_uae_dubai;
	private BigDecimal	r44_amount_uae_dubai;
	private BigDecimal	r44_no_of_accounts_non_uae_dubai;
	private BigDecimal	r44_amount_non_uae_dubai;
	private BigDecimal	r44_total_dubai;
	private BigDecimal	r44_no_of_accounts_uae_sharjah;
	private BigDecimal	r44_amount_uae_sharjah;
	private BigDecimal	r44_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r44_amount_non_uae_sharjah;
	private BigDecimal	r44_total_sharjah;
	private BigDecimal	r44_no_of_accounts_uae_ajman;
	private BigDecimal	r44_amount_uae_ajman;
	private BigDecimal	r44_no_of_accounts_non_uae_ajman;
	private BigDecimal	r44_amount_non_uae_ajman;
	private BigDecimal	r44_total_ajman;
	private BigDecimal	r44_no_of_accounts_uae_ras ;
	private BigDecimal	r44_amount_uae_ras ;
	private BigDecimal	r44_no_of_accounts_non_uae_ras ;
	private BigDecimal	r44_amount_non_uae_ras ;
	private BigDecimal	r44_total_ras ;
	private BigDecimal	r44_no_of_accounts_uae_umm ;
	private BigDecimal	r44_amount_uae_umm ;
	private BigDecimal	r44_no_of_accounts_non_uae_umm ;
	private BigDecimal	r44_amount_non_uae_umm ;
	private BigDecimal	r44_total_umm ;
	private BigDecimal	r44_no_of_accounts_uae_fujairah;
	private BigDecimal	r44_amount_uae_fujairah;
	private BigDecimal	r44_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r44_amount_non_uae_fujairah;
	private BigDecimal	r44_total_fujairah;
	private String	r45_product;
	private BigDecimal	r45_no_of_accounts_uae;
	private BigDecimal	r45_amount_uae;
	private BigDecimal	r45_no_of_accounts_resident;
	private BigDecimal	r45_amount_resident;
	private BigDecimal	r45_no_of_accounts_non_resident;
	private BigDecimal	r45_amount_non_resident;
	private BigDecimal	r45_total_account;
	private BigDecimal	r45_total_amount;
	private BigDecimal	r45_no_of_accounts_uae_abu;
	private BigDecimal	r45_amount_uae_abu;
	private BigDecimal	r45_no_of_accounts_non_uae_abu;
	private BigDecimal	r45_amount_non_uae_abu;
	private BigDecimal	r45_total_abu;
	private BigDecimal	r45_no_of_accounts_uae_dubai;
	private BigDecimal	r45_amount_uae_dubai;
	private BigDecimal	r45_no_of_accounts_non_uae_dubai;
	private BigDecimal	r45_amount_non_uae_dubai;
	private BigDecimal	r45_total_dubai;
	private BigDecimal	r45_no_of_accounts_uae_sharjah;
	private BigDecimal	r45_amount_uae_sharjah;
	private BigDecimal	r45_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r45_amount_non_uae_sharjah;
	private BigDecimal	r45_total_sharjah;
	private BigDecimal	r45_no_of_accounts_uae_ajman;
	private BigDecimal	r45_amount_uae_ajman;
	private BigDecimal	r45_no_of_accounts_non_uae_ajman;
	private BigDecimal	r45_amount_non_uae_ajman;
	private BigDecimal	r45_total_ajman;
	private BigDecimal	r45_no_of_accounts_uae_ras ;
	private BigDecimal	r45_amount_uae_ras ;
	private BigDecimal	r45_no_of_accounts_non_uae_ras ;
	private BigDecimal	r45_amount_non_uae_ras ;
	private BigDecimal	r45_total_ras ;
	private BigDecimal	r45_no_of_accounts_uae_umm ;
	private BigDecimal	r45_amount_uae_umm ;
	private BigDecimal	r45_no_of_accounts_non_uae_umm ;
	private BigDecimal	r45_amount_non_uae_umm ;
	private BigDecimal	r45_total_umm ;
	private BigDecimal	r45_no_of_accounts_uae_fujairah;
	private BigDecimal	r45_amount_uae_fujairah;
	private BigDecimal	r45_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r45_amount_non_uae_fujairah;
	private BigDecimal	r45_total_fujairah;
	private String	r46_product;
	private BigDecimal	r46_no_of_accounts_uae;
	private BigDecimal	r46_amount_uae;
	private BigDecimal	r46_no_of_accounts_resident;
	private BigDecimal	r46_amount_resident;
	private BigDecimal	r46_no_of_accounts_non_resident;
	private BigDecimal	r46_amount_non_resident;
	private BigDecimal	r46_total_account;
	private BigDecimal	r46_total_amount;
	private BigDecimal	r46_no_of_accounts_uae_abu;
	private BigDecimal	r46_amount_uae_abu;
	private BigDecimal	r46_no_of_accounts_non_uae_abu;
	private BigDecimal	r46_amount_non_uae_abu;
	private BigDecimal	r46_total_abu;
	private BigDecimal	r46_no_of_accounts_uae_dubai;
	private BigDecimal	r46_amount_uae_dubai;
	private BigDecimal	r46_no_of_accounts_non_uae_dubai;
	private BigDecimal	r46_amount_non_uae_dubai;
	private BigDecimal	r46_total_dubai;
	private BigDecimal	r46_no_of_accounts_uae_sharjah;
	private BigDecimal	r46_amount_uae_sharjah;
	private BigDecimal	r46_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r46_amount_non_uae_sharjah;
	private BigDecimal	r46_total_sharjah;
	private BigDecimal	r46_no_of_accounts_uae_ajman;
	private BigDecimal	r46_amount_uae_ajman;
	private BigDecimal	r46_no_of_accounts_non_uae_ajman;
	private BigDecimal	r46_amount_non_uae_ajman;
	private BigDecimal	r46_total_ajman;
	private BigDecimal	r46_no_of_accounts_uae_ras ;
	private BigDecimal	r46_amount_uae_ras ;
	private BigDecimal	r46_no_of_accounts_non_uae_ras ;
	private BigDecimal	r46_amount_non_uae_ras ;
	private BigDecimal	r46_total_ras ;
	private BigDecimal	r46_no_of_accounts_uae_umm ;
	private BigDecimal	r46_amount_uae_umm ;
	private BigDecimal	r46_no_of_accounts_non_uae_umm ;
	private BigDecimal	r46_amount_non_uae_umm ;
	private BigDecimal	r46_total_umm ;
	private BigDecimal	r46_no_of_accounts_uae_fujairah;
	private BigDecimal	r46_amount_uae_fujairah;
	private BigDecimal	r46_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r46_amount_non_uae_fujairah;
	private BigDecimal	r46_total_fujairah;
	private String	r47_product;
	private BigDecimal	r47_no_of_accounts_uae;
	private BigDecimal	r47_amount_uae;
	private BigDecimal	r47_no_of_accounts_resident;
	private BigDecimal	r47_amount_resident;
	private BigDecimal	r47_no_of_accounts_non_resident;
	private BigDecimal	r47_amount_non_resident;
	private BigDecimal	r47_total_account;
	private BigDecimal	r47_total_amount;
	private BigDecimal	r47_no_of_accounts_uae_abu;
	private BigDecimal	r47_amount_uae_abu;
	private BigDecimal	r47_no_of_accounts_non_uae_abu;
	private BigDecimal	r47_amount_non_uae_abu;
	private BigDecimal	r47_total_abu;
	private BigDecimal	r47_no_of_accounts_uae_dubai;
	private BigDecimal	r47_amount_uae_dubai;
	private BigDecimal	r47_no_of_accounts_non_uae_dubai;
	private BigDecimal	r47_amount_non_uae_dubai;
	private BigDecimal	r47_total_dubai;
	private BigDecimal	r47_no_of_accounts_uae_sharjah;
	private BigDecimal	r47_amount_uae_sharjah;
	private BigDecimal	r47_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r47_amount_non_uae_sharjah;
	private BigDecimal	r47_total_sharjah;
	private BigDecimal	r47_no_of_accounts_uae_ajman;
	private BigDecimal	r47_amount_uae_ajman;
	private BigDecimal	r47_no_of_accounts_non_uae_ajman;
	private BigDecimal	r47_amount_non_uae_ajman;
	private BigDecimal	r47_total_ajman;
	private BigDecimal	r47_no_of_accounts_uae_ras ;
	private BigDecimal	r47_amount_uae_ras ;
	private BigDecimal	r47_no_of_accounts_non_uae_ras ;
	private BigDecimal	r47_amount_non_uae_ras ;
	private BigDecimal	r47_total_ras ;
	private BigDecimal	r47_no_of_accounts_uae_umm ;
	private BigDecimal	r47_amount_uae_umm ;
	private BigDecimal	r47_no_of_accounts_non_uae_umm ;
	private BigDecimal	r47_amount_non_uae_umm ;
	private BigDecimal	r47_total_umm ;
	private BigDecimal	r47_no_of_accounts_uae_fujairah;
	private BigDecimal	r47_amount_uae_fujairah;
	private BigDecimal	r47_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r47_amount_non_uae_fujairah;
	private BigDecimal	r47_total_fujairah;
	private String	r48_product;
	private BigDecimal	r48_no_of_accounts_uae;
	private BigDecimal	r48_amount_uae;
	private BigDecimal	r48_no_of_accounts_resident;
	private BigDecimal	r48_amount_resident;
	private BigDecimal	r48_no_of_accounts_non_resident;
	private BigDecimal	r48_amount_non_resident;
	private BigDecimal	r48_total_account;
	private BigDecimal	r48_total_amount;
	private BigDecimal	r48_no_of_accounts_uae_abu;
	private BigDecimal	r48_amount_uae_abu;
	private BigDecimal	r48_no_of_accounts_non_uae_abu;
	private BigDecimal	r48_amount_non_uae_abu;
	private BigDecimal	r48_total_abu;
	private BigDecimal	r48_no_of_accounts_uae_dubai;
	private BigDecimal	r48_amount_uae_dubai;
	private BigDecimal	r48_no_of_accounts_non_uae_dubai;
	private BigDecimal	r48_amount_non_uae_dubai;
	private BigDecimal	r48_total_dubai;
	private BigDecimal	r48_no_of_accounts_uae_sharjah;
	private BigDecimal	r48_amount_uae_sharjah;
	private BigDecimal	r48_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r48_amount_non_uae_sharjah;
	private BigDecimal	r48_total_sharjah;
	private BigDecimal	r48_no_of_accounts_uae_ajman;
	private BigDecimal	r48_amount_uae_ajman;
	private BigDecimal	r48_no_of_accounts_non_uae_ajman;
	private BigDecimal	r48_amount_non_uae_ajman;
	private BigDecimal	r48_total_ajman;
	private BigDecimal	r48_no_of_accounts_uae_ras ;
	private BigDecimal	r48_amount_uae_ras ;
	private BigDecimal	r48_no_of_accounts_non_uae_ras ;
	private BigDecimal	r48_amount_non_uae_ras ;
	private BigDecimal	r48_total_ras ;
	private BigDecimal	r48_no_of_accounts_uae_umm ;
	private BigDecimal	r48_amount_uae_umm ;
	private BigDecimal	r48_no_of_accounts_non_uae_umm ;
	private BigDecimal	r48_amount_non_uae_umm ;
	private BigDecimal	r48_total_umm ;
	private BigDecimal	r48_no_of_accounts_uae_fujairah;
	private BigDecimal	r48_amount_uae_fujairah;
	private BigDecimal	r48_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r48_amount_non_uae_fujairah;
	private BigDecimal	r48_total_fujairah;
	private String	r49_product;
	private BigDecimal	r49_no_of_accounts_uae;
	private BigDecimal	r49_amount_uae;
	private BigDecimal	r49_no_of_accounts_resident;
	private BigDecimal	r49_amount_resident;
	private BigDecimal	r49_no_of_accounts_non_resident;
	private BigDecimal	r49_amount_non_resident;
	private BigDecimal	r49_total_account;
	private BigDecimal	r49_total_amount;
	private BigDecimal	r49_no_of_accounts_uae_abu;
	private BigDecimal	r49_amount_uae_abu;
	private BigDecimal	r49_no_of_accounts_non_uae_abu;
	private BigDecimal	r49_amount_non_uae_abu;
	private BigDecimal	r49_total_abu;
	private BigDecimal	r49_no_of_accounts_uae_dubai;
	private BigDecimal	r49_amount_uae_dubai;
	private BigDecimal	r49_no_of_accounts_non_uae_dubai;
	private BigDecimal	r49_amount_non_uae_dubai;
	private BigDecimal	r49_total_dubai;
	private BigDecimal	r49_no_of_accounts_uae_sharjah;
	private BigDecimal	r49_amount_uae_sharjah;
	private BigDecimal	r49_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r49_amount_non_uae_sharjah;
	private BigDecimal	r49_total_sharjah;
	private BigDecimal	r49_no_of_accounts_uae_ajman;
	private BigDecimal	r49_amount_uae_ajman;
	private BigDecimal	r49_no_of_accounts_non_uae_ajman;
	private BigDecimal	r49_amount_non_uae_ajman;
	private BigDecimal	r49_total_ajman;
	private BigDecimal	r49_no_of_accounts_uae_ras ;
	private BigDecimal	r49_amount_uae_ras ;
	private BigDecimal	r49_no_of_accounts_non_uae_ras ;
	private BigDecimal	r49_amount_non_uae_ras ;
	private BigDecimal	r49_total_ras ;
	private BigDecimal	r49_no_of_accounts_uae_umm ;
	private BigDecimal	r49_amount_uae_umm ;
	private BigDecimal	r49_no_of_accounts_non_uae_umm ;
	private BigDecimal	r49_amount_non_uae_umm ;
	private BigDecimal	r49_total_umm ;
	private BigDecimal	r49_no_of_accounts_uae_fujairah;
	private BigDecimal	r49_amount_uae_fujairah;
	private BigDecimal	r49_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r49_amount_non_uae_fujairah;
	private BigDecimal	r49_total_fujairah;
	private String	r50_product;
	private BigDecimal	r50_no_of_accounts_uae;
	private BigDecimal	r50_amount_uae;
	private BigDecimal	r50_no_of_accounts_resident;
	private BigDecimal	r50_amount_resident;
	private BigDecimal	r50_no_of_accounts_non_resident;
	private BigDecimal	r50_amount_non_resident;
	private BigDecimal	r50_total_account;
	private BigDecimal	r50_total_amount;
	private BigDecimal	r50_no_of_accounts_uae_abu;
	private BigDecimal	r50_amount_uae_abu;
	private BigDecimal	r50_no_of_accounts_non_uae_abu;
	private BigDecimal	r50_amount_non_uae_abu;
	private BigDecimal	r50_total_abu;
	private BigDecimal	r50_no_of_accounts_uae_dubai;
	private BigDecimal	r50_amount_uae_dubai;
	private BigDecimal	r50_no_of_accounts_non_uae_dubai;
	private BigDecimal	r50_amount_non_uae_dubai;
	private BigDecimal	r50_total_dubai;
	private BigDecimal	r50_no_of_accounts_uae_sharjah;
	private BigDecimal	r50_amount_uae_sharjah;
	private BigDecimal	r50_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r50_amount_non_uae_sharjah;
	private BigDecimal	r50_total_sharjah;
	private BigDecimal	r50_no_of_accounts_uae_ajman;
	private BigDecimal	r50_amount_uae_ajman;
	private BigDecimal	r50_no_of_accounts_non_uae_ajman;
	private BigDecimal	r50_amount_non_uae_ajman;
	private BigDecimal	r50_total_ajman;
	private BigDecimal	r50_no_of_accounts_uae_ras ;
	private BigDecimal	r50_amount_uae_ras ;
	private BigDecimal	r50_no_of_accounts_non_uae_ras ;
	private BigDecimal	r50_amount_non_uae_ras ;
	private BigDecimal	r50_total_ras ;
	private BigDecimal	r50_no_of_accounts_uae_umm ;
	private BigDecimal	r50_amount_uae_umm ;
	private BigDecimal	r50_no_of_accounts_non_uae_umm ;
	private BigDecimal	r50_amount_non_uae_umm ;
	private BigDecimal	r50_total_umm ;
	private BigDecimal	r50_no_of_accounts_uae_fujairah;
	private BigDecimal	r50_amount_uae_fujairah;
	private BigDecimal	r50_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r50_amount_non_uae_fujairah;
	private BigDecimal	r50_total_fujairah;
	private String	r51_product;
	private BigDecimal	r51_no_of_accounts_uae;
	private BigDecimal	r51_amount_uae;
	private BigDecimal	r51_no_of_accounts_resident;
	private BigDecimal	r51_amount_resident;
	private BigDecimal	r51_no_of_accounts_non_resident;
	private BigDecimal	r51_amount_non_resident;
	private BigDecimal	r51_total_account;
	private BigDecimal	r51_total_amount;
	private BigDecimal	r51_no_of_accounts_uae_abu;
	private BigDecimal	r51_amount_uae_abu;
	private BigDecimal	r51_no_of_accounts_non_uae_abu;
	private BigDecimal	r51_amount_non_uae_abu;
	private BigDecimal	r51_total_abu;
	private BigDecimal	r51_no_of_accounts_uae_dubai;
	private BigDecimal	r51_amount_uae_dubai;
	private BigDecimal	r51_no_of_accounts_non_uae_dubai;
	private BigDecimal	r51_amount_non_uae_dubai;
	private BigDecimal	r51_total_dubai;
	private BigDecimal	r51_no_of_accounts_uae_sharjah;
	private BigDecimal	r51_amount_uae_sharjah;
	private BigDecimal	r51_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r51_amount_non_uae_sharjah;
	private BigDecimal	r51_total_sharjah;
	private BigDecimal	r51_no_of_accounts_uae_ajman;
	private BigDecimal	r51_amount_uae_ajman;
	private BigDecimal	r51_no_of_accounts_non_uae_ajman;
	private BigDecimal	r51_amount_non_uae_ajman;
	private BigDecimal	r51_total_ajman;
	private BigDecimal	r51_no_of_accounts_uae_ras ;
	private BigDecimal	r51_amount_uae_ras ;
	private BigDecimal	r51_no_of_accounts_non_uae_ras ;
	private BigDecimal	r51_amount_non_uae_ras ;
	private BigDecimal	r51_total_ras ;
	private BigDecimal	r51_no_of_accounts_uae_umm ;
	private BigDecimal	r51_amount_uae_umm ;
	private BigDecimal	r51_no_of_accounts_non_uae_umm ;
	private BigDecimal	r51_amount_non_uae_umm ;
	private BigDecimal	r51_total_umm ;
	private BigDecimal	r51_no_of_accounts_uae_fujairah;
	private BigDecimal	r51_amount_uae_fujairah;
	private BigDecimal	r51_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r51_amount_non_uae_fujairah;
	private BigDecimal	r51_total_fujairah;
	private String	r52_product;
	private BigDecimal	r52_no_of_accounts_uae;
	private BigDecimal	r52_amount_uae;
	private BigDecimal	r52_no_of_accounts_resident;
	private BigDecimal	r52_amount_resident;
	private BigDecimal	r52_no_of_accounts_non_resident;
	private BigDecimal	r52_amount_non_resident;
	private BigDecimal	r52_total_account;
	private BigDecimal	r52_total_amount;
	private BigDecimal	r52_no_of_accounts_uae_abu;
	private BigDecimal	r52_amount_uae_abu;
	private BigDecimal	r52_no_of_accounts_non_uae_abu;
	private BigDecimal	r52_amount_non_uae_abu;
	private BigDecimal	r52_total_abu;
	private BigDecimal	r52_no_of_accounts_uae_dubai;
	private BigDecimal	r52_amount_uae_dubai;
	private BigDecimal	r52_no_of_accounts_non_uae_dubai;
	private BigDecimal	r52_amount_non_uae_dubai;
	private BigDecimal	r52_total_dubai;
	private BigDecimal	r52_no_of_accounts_uae_sharjah;
	private BigDecimal	r52_amount_uae_sharjah;
	private BigDecimal	r52_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r52_amount_non_uae_sharjah;
	private BigDecimal	r52_total_sharjah;
	private BigDecimal	r52_no_of_accounts_uae_ajman;
	private BigDecimal	r52_amount_uae_ajman;
	private BigDecimal	r52_no_of_accounts_non_uae_ajman;
	private BigDecimal	r52_amount_non_uae_ajman;
	private BigDecimal	r52_total_ajman;
	private BigDecimal	r52_no_of_accounts_uae_ras ;
	private BigDecimal	r52_amount_uae_ras ;
	private BigDecimal	r52_no_of_accounts_non_uae_ras ;
	private BigDecimal	r52_amount_non_uae_ras ;
	private BigDecimal	r52_total_ras ;
	private BigDecimal	r52_no_of_accounts_uae_umm ;
	private BigDecimal	r52_amount_uae_umm ;
	private BigDecimal	r52_no_of_accounts_non_uae_umm ;
	private BigDecimal	r52_amount_non_uae_umm ;
	private BigDecimal	r52_total_umm ;
	private BigDecimal	r52_no_of_accounts_uae_fujairah;
	private BigDecimal	r52_amount_uae_fujairah;
	private BigDecimal	r52_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r52_amount_non_uae_fujairah;
	private BigDecimal	r52_total_fujairah;
	private String	r53_product;
	private BigDecimal	r53_no_of_accounts_uae;
	private BigDecimal	r53_amount_uae;
	private BigDecimal	r53_no_of_accounts_resident;
	private BigDecimal	r53_amount_resident;
	private BigDecimal	r53_no_of_accounts_non_resident;
	private BigDecimal	r53_amount_non_resident;
	private BigDecimal	r53_total_account;
	private BigDecimal	r53_total_amount;
	private BigDecimal	r53_no_of_accounts_uae_abu;
	private BigDecimal	r53_amount_uae_abu;
	private BigDecimal	r53_no_of_accounts_non_uae_abu;
	private BigDecimal	r53_amount_non_uae_abu;
	private BigDecimal	r53_total_abu;
	private BigDecimal	r53_no_of_accounts_uae_dubai;
	private BigDecimal	r53_amount_uae_dubai;
	private BigDecimal	r53_no_of_accounts_non_uae_dubai;
	private BigDecimal	r53_amount_non_uae_dubai;
	private BigDecimal	r53_total_dubai;
	private BigDecimal	r53_no_of_accounts_uae_sharjah;
	private BigDecimal	r53_amount_uae_sharjah;
	private BigDecimal	r53_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r53_amount_non_uae_sharjah;
	private BigDecimal	r53_total_sharjah;
	private BigDecimal	r53_no_of_accounts_uae_ajman;
	private BigDecimal	r53_amount_uae_ajman;
	private BigDecimal	r53_no_of_accounts_non_uae_ajman;
	private BigDecimal	r53_amount_non_uae_ajman;
	private BigDecimal	r53_total_ajman;
	private BigDecimal	r53_no_of_accounts_uae_ras ;
	private BigDecimal	r53_amount_uae_ras ;
	private BigDecimal	r53_no_of_accounts_non_uae_ras ;
	private BigDecimal	r53_amount_non_uae_ras ;
	private BigDecimal	r53_total_ras ;
	private BigDecimal	r53_no_of_accounts_uae_umm ;
	private BigDecimal	r53_amount_uae_umm ;
	private BigDecimal	r53_no_of_accounts_non_uae_umm ;
	private BigDecimal	r53_amount_non_uae_umm ;
	private BigDecimal	r53_total_umm ;
	private BigDecimal	r53_no_of_accounts_uae_fujairah;
	private BigDecimal	r53_amount_uae_fujairah;
	private BigDecimal	r53_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r53_amount_non_uae_fujairah;
	private BigDecimal	r53_total_fujairah;
	private String	r54_product;
	private BigDecimal	r54_no_of_accounts_uae;
	private BigDecimal	r54_amount_uae;
	private BigDecimal	r54_no_of_accounts_resident;
	private BigDecimal	r54_amount_resident;
	private BigDecimal	r54_no_of_accounts_non_resident;
	private BigDecimal	r54_amount_non_resident;
	private BigDecimal	r54_total_account;
	private BigDecimal	r54_total_amount;
	private BigDecimal	r54_no_of_accounts_uae_abu;
	private BigDecimal	r54_amount_uae_abu;
	private BigDecimal	r54_no_of_accounts_non_uae_abu;
	private BigDecimal	r54_amount_non_uae_abu;
	private BigDecimal	r54_total_abu;
	private BigDecimal	r54_no_of_accounts_uae_dubai;
	private BigDecimal	r54_amount_uae_dubai;
	private BigDecimal	r54_no_of_accounts_non_uae_dubai;
	private BigDecimal	r54_amount_non_uae_dubai;
	private BigDecimal	r54_total_dubai;
	private BigDecimal	r54_no_of_accounts_uae_sharjah;
	private BigDecimal	r54_amount_uae_sharjah;
	private BigDecimal	r54_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r54_amount_non_uae_sharjah;
	private BigDecimal	r54_total_sharjah;
	private BigDecimal	r54_no_of_accounts_uae_ajman;
	private BigDecimal	r54_amount_uae_ajman;
	private BigDecimal	r54_no_of_accounts_non_uae_ajman;
	private BigDecimal	r54_amount_non_uae_ajman;
	private BigDecimal	r54_total_ajman;
	private BigDecimal	r54_no_of_accounts_uae_ras ;
	private BigDecimal	r54_amount_uae_ras ;
	private BigDecimal	r54_no_of_accounts_non_uae_ras ;
	private BigDecimal	r54_amount_non_uae_ras ;
	private BigDecimal	r54_total_ras ;
	private BigDecimal	r54_no_of_accounts_uae_umm ;
	private BigDecimal	r54_amount_uae_umm ;
	private BigDecimal	r54_no_of_accounts_non_uae_umm ;
	private BigDecimal	r54_amount_non_uae_umm ;
	private BigDecimal	r54_total_umm ;
	private BigDecimal	r54_no_of_accounts_uae_fujairah;
	private BigDecimal	r54_amount_uae_fujairah;
	private BigDecimal	r54_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r54_amount_non_uae_fujairah;
	private BigDecimal	r54_total_fujairah;
	private String	r55_product;
	private BigDecimal	r55_no_of_accounts_uae;
	private BigDecimal	r55_amount_uae;
	private BigDecimal	r55_no_of_accounts_resident;
	private BigDecimal	r55_amount_resident;
	private BigDecimal	r55_no_of_accounts_non_resident;
	private BigDecimal	r55_amount_non_resident;
	private BigDecimal	r55_total_account;
	private BigDecimal	r55_total_amount;
	private BigDecimal	r55_no_of_accounts_uae_abu;
	private BigDecimal	r55_amount_uae_abu;
	private BigDecimal	r55_no_of_accounts_non_uae_abu;
	private BigDecimal	r55_amount_non_uae_abu;
	private BigDecimal	r55_total_abu;
	private BigDecimal	r55_no_of_accounts_uae_dubai;
	private BigDecimal	r55_amount_uae_dubai;
	private BigDecimal	r55_no_of_accounts_non_uae_dubai;
	private BigDecimal	r55_amount_non_uae_dubai;
	private BigDecimal	r55_total_dubai;
	private BigDecimal	r55_no_of_accounts_uae_sharjah;
	private BigDecimal	r55_amount_uae_sharjah;
	private BigDecimal	r55_no_of_accounts_non_uae_sharjah;
	private BigDecimal	r55_amount_non_uae_sharjah;
	private BigDecimal	r55_total_sharjah;
	private BigDecimal	r55_no_of_accounts_uae_ajman;
	private BigDecimal	r55_amount_uae_ajman;
	private BigDecimal	r55_no_of_accounts_non_uae_ajman;
	private BigDecimal	r55_amount_non_uae_ajman;
	private BigDecimal	r55_total_ajman;
	private BigDecimal	r55_no_of_accounts_uae_ras ;
	private BigDecimal	r55_amount_uae_ras ;
	private BigDecimal	r55_no_of_accounts_non_uae_ras ;
	private BigDecimal	r55_amount_non_uae_ras ;
	private BigDecimal	r55_total_ras ;
	private BigDecimal	r55_no_of_accounts_uae_umm ;
	private BigDecimal	r55_amount_uae_umm ;
	private BigDecimal	r55_no_of_accounts_non_uae_umm ;
	private BigDecimal	r55_amount_non_uae_umm ;
	private BigDecimal	r55_total_umm ;
	private BigDecimal	r55_no_of_accounts_uae_fujairah;
	private BigDecimal	r55_amount_uae_fujairah;
	private BigDecimal	r55_no_of_accounts_non_uae_fujairah;
	private BigDecimal	r55_amount_non_uae_fujairah;
	private BigDecimal	r55_total_fujairah;
	private String	r56_product;
	private BigDecimal	r56_amount_total;
	private String	r57_product;
	private BigDecimal	r57_amount_total;
	private String	r58_product;
	private BigDecimal	r58_amount_total;
	private String	r59_product;
	private BigDecimal	r59_amount_total;
	private String	r60_product;
	private BigDecimal	r60_amount_total;
	private String	r61_product;
	private BigDecimal	r61_amount_total;
	private String	r62_product;
	private BigDecimal	r62_amount_total;
	private String	r63_product;
	private BigDecimal	r63_amount_total;
	private String	r64_product;
	private BigDecimal	r64_amount_total;
	private String	r65_product;
	private BigDecimal	r65_amount_total;
	private String	r66_product;
	private BigDecimal	r66_amount_total;
	private String	r67_product;
	private BigDecimal	r67_amount_total;
	private String	r68_product;
	private BigDecimal	r68_amount_total;
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
	public String getR41_product() {
		return r41_product;
	}
	public void setR41_product(String r41_product) {
		this.r41_product = r41_product;
	}
	public BigDecimal getR41_no_of_accounts_uae() {
		return r41_no_of_accounts_uae;
	}
	public void setR41_no_of_accounts_uae(BigDecimal r41_no_of_accounts_uae) {
		this.r41_no_of_accounts_uae = r41_no_of_accounts_uae;
	}
	public BigDecimal getR41_amount_uae() {
		return r41_amount_uae;
	}
	public void setR41_amount_uae(BigDecimal r41_amount_uae) {
		this.r41_amount_uae = r41_amount_uae;
	}
	public BigDecimal getR41_no_of_accounts_resident() {
		return r41_no_of_accounts_resident;
	}
	public void setR41_no_of_accounts_resident(BigDecimal r41_no_of_accounts_resident) {
		this.r41_no_of_accounts_resident = r41_no_of_accounts_resident;
	}
	public BigDecimal getR41_amount_resident() {
		return r41_amount_resident;
	}
	public void setR41_amount_resident(BigDecimal r41_amount_resident) {
		this.r41_amount_resident = r41_amount_resident;
	}
	public BigDecimal getR41_no_of_accounts_non_resident() {
		return r41_no_of_accounts_non_resident;
	}
	public void setR41_no_of_accounts_non_resident(BigDecimal r41_no_of_accounts_non_resident) {
		this.r41_no_of_accounts_non_resident = r41_no_of_accounts_non_resident;
	}
	public BigDecimal getR41_amount_non_resident() {
		return r41_amount_non_resident;
	}
	public void setR41_amount_non_resident(BigDecimal r41_amount_non_resident) {
		this.r41_amount_non_resident = r41_amount_non_resident;
	}
	public BigDecimal getR41_total_account() {
		return r41_total_account;
	}
	public void setR41_total_account(BigDecimal r41_total_account) {
		this.r41_total_account = r41_total_account;
	}
	public BigDecimal getR41_total_amount() {
		return r41_total_amount;
	}
	public void setR41_total_amount(BigDecimal r41_total_amount) {
		this.r41_total_amount = r41_total_amount;
	}
	public BigDecimal getR41_no_of_accounts_uae_abu() {
		return r41_no_of_accounts_uae_abu;
	}
	public void setR41_no_of_accounts_uae_abu(BigDecimal r41_no_of_accounts_uae_abu) {
		this.r41_no_of_accounts_uae_abu = r41_no_of_accounts_uae_abu;
	}
	public BigDecimal getR41_amount_uae_abu() {
		return r41_amount_uae_abu;
	}
	public void setR41_amount_uae_abu(BigDecimal r41_amount_uae_abu) {
		this.r41_amount_uae_abu = r41_amount_uae_abu;
	}
	public BigDecimal getR41_no_of_accounts_non_uae_abu() {
		return r41_no_of_accounts_non_uae_abu;
	}
	public void setR41_no_of_accounts_non_uae_abu(BigDecimal r41_no_of_accounts_non_uae_abu) {
		this.r41_no_of_accounts_non_uae_abu = r41_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR41_amount_non_uae_abu() {
		return r41_amount_non_uae_abu;
	}
	public void setR41_amount_non_uae_abu(BigDecimal r41_amount_non_uae_abu) {
		this.r41_amount_non_uae_abu = r41_amount_non_uae_abu;
	}
	public BigDecimal getR41_total_abu() {
		return r41_total_abu;
	}
	public void setR41_total_abu(BigDecimal r41_total_abu) {
		this.r41_total_abu = r41_total_abu;
	}
	public BigDecimal getR41_no_of_accounts_uae_dubai() {
		return r41_no_of_accounts_uae_dubai;
	}
	public void setR41_no_of_accounts_uae_dubai(BigDecimal r41_no_of_accounts_uae_dubai) {
		this.r41_no_of_accounts_uae_dubai = r41_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR41_amount_uae_dubai() {
		return r41_amount_uae_dubai;
	}
	public void setR41_amount_uae_dubai(BigDecimal r41_amount_uae_dubai) {
		this.r41_amount_uae_dubai = r41_amount_uae_dubai;
	}
	public BigDecimal getR41_no_of_accounts_non_uae_dubai() {
		return r41_no_of_accounts_non_uae_dubai;
	}
	public void setR41_no_of_accounts_non_uae_dubai(BigDecimal r41_no_of_accounts_non_uae_dubai) {
		this.r41_no_of_accounts_non_uae_dubai = r41_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR41_amount_non_uae_dubai() {
		return r41_amount_non_uae_dubai;
	}
	public void setR41_amount_non_uae_dubai(BigDecimal r41_amount_non_uae_dubai) {
		this.r41_amount_non_uae_dubai = r41_amount_non_uae_dubai;
	}
	public BigDecimal getR41_total_dubai() {
		return r41_total_dubai;
	}
	public void setR41_total_dubai(BigDecimal r41_total_dubai) {
		this.r41_total_dubai = r41_total_dubai;
	}
	public BigDecimal getR41_no_of_accounts_uae_sharjah() {
		return r41_no_of_accounts_uae_sharjah;
	}
	public void setR41_no_of_accounts_uae_sharjah(BigDecimal r41_no_of_accounts_uae_sharjah) {
		this.r41_no_of_accounts_uae_sharjah = r41_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR41_amount_uae_sharjah() {
		return r41_amount_uae_sharjah;
	}
	public void setR41_amount_uae_sharjah(BigDecimal r41_amount_uae_sharjah) {
		this.r41_amount_uae_sharjah = r41_amount_uae_sharjah;
	}
	public BigDecimal getR41_no_of_accounts_non_uae_sharjah() {
		return r41_no_of_accounts_non_uae_sharjah;
	}
	public void setR41_no_of_accounts_non_uae_sharjah(BigDecimal r41_no_of_accounts_non_uae_sharjah) {
		this.r41_no_of_accounts_non_uae_sharjah = r41_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR41_amount_non_uae_sharjah() {
		return r41_amount_non_uae_sharjah;
	}
	public void setR41_amount_non_uae_sharjah(BigDecimal r41_amount_non_uae_sharjah) {
		this.r41_amount_non_uae_sharjah = r41_amount_non_uae_sharjah;
	}
	public BigDecimal getR41_total_sharjah() {
		return r41_total_sharjah;
	}
	public void setR41_total_sharjah(BigDecimal r41_total_sharjah) {
		this.r41_total_sharjah = r41_total_sharjah;
	}
	public BigDecimal getR41_no_of_accounts_uae_ajman() {
		return r41_no_of_accounts_uae_ajman;
	}
	public void setR41_no_of_accounts_uae_ajman(BigDecimal r41_no_of_accounts_uae_ajman) {
		this.r41_no_of_accounts_uae_ajman = r41_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR41_amount_uae_ajman() {
		return r41_amount_uae_ajman;
	}
	public void setR41_amount_uae_ajman(BigDecimal r41_amount_uae_ajman) {
		this.r41_amount_uae_ajman = r41_amount_uae_ajman;
	}
	public BigDecimal getR41_no_of_accounts_non_uae_ajman() {
		return r41_no_of_accounts_non_uae_ajman;
	}
	public void setR41_no_of_accounts_non_uae_ajman(BigDecimal r41_no_of_accounts_non_uae_ajman) {
		this.r41_no_of_accounts_non_uae_ajman = r41_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR41_amount_non_uae_ajman() {
		return r41_amount_non_uae_ajman;
	}
	public void setR41_amount_non_uae_ajman(BigDecimal r41_amount_non_uae_ajman) {
		this.r41_amount_non_uae_ajman = r41_amount_non_uae_ajman;
	}
	public BigDecimal getR41_total_ajman() {
		return r41_total_ajman;
	}
	public void setR41_total_ajman(BigDecimal r41_total_ajman) {
		this.r41_total_ajman = r41_total_ajman;
	}
	public BigDecimal getR41_no_of_accounts_uae_ras() {
		return r41_no_of_accounts_uae_ras;
	}
	public void setR41_no_of_accounts_uae_ras(BigDecimal r41_no_of_accounts_uae_ras) {
		this.r41_no_of_accounts_uae_ras = r41_no_of_accounts_uae_ras;
	}
	public BigDecimal getR41_amount_uae_ras() {
		return r41_amount_uae_ras;
	}
	public void setR41_amount_uae_ras(BigDecimal r41_amount_uae_ras) {
		this.r41_amount_uae_ras = r41_amount_uae_ras;
	}
	public BigDecimal getR41_no_of_accounts_non_uae_ras() {
		return r41_no_of_accounts_non_uae_ras;
	}
	public void setR41_no_of_accounts_non_uae_ras(BigDecimal r41_no_of_accounts_non_uae_ras) {
		this.r41_no_of_accounts_non_uae_ras = r41_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR41_amount_non_uae_ras() {
		return r41_amount_non_uae_ras;
	}
	public void setR41_amount_non_uae_ras(BigDecimal r41_amount_non_uae_ras) {
		this.r41_amount_non_uae_ras = r41_amount_non_uae_ras;
	}
	public BigDecimal getR41_total_ras() {
		return r41_total_ras;
	}
	public void setR41_total_ras(BigDecimal r41_total_ras) {
		this.r41_total_ras = r41_total_ras;
	}
	public BigDecimal getR41_no_of_accounts_uae_umm() {
		return r41_no_of_accounts_uae_umm;
	}
	public void setR41_no_of_accounts_uae_umm(BigDecimal r41_no_of_accounts_uae_umm) {
		this.r41_no_of_accounts_uae_umm = r41_no_of_accounts_uae_umm;
	}
	public BigDecimal getR41_amount_uae_umm() {
		return r41_amount_uae_umm;
	}
	public void setR41_amount_uae_umm(BigDecimal r41_amount_uae_umm) {
		this.r41_amount_uae_umm = r41_amount_uae_umm;
	}
	public BigDecimal getR41_no_of_accounts_non_uae_umm() {
		return r41_no_of_accounts_non_uae_umm;
	}
	public void setR41_no_of_accounts_non_uae_umm(BigDecimal r41_no_of_accounts_non_uae_umm) {
		this.r41_no_of_accounts_non_uae_umm = r41_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR41_amount_non_uae_umm() {
		return r41_amount_non_uae_umm;
	}
	public void setR41_amount_non_uae_umm(BigDecimal r41_amount_non_uae_umm) {
		this.r41_amount_non_uae_umm = r41_amount_non_uae_umm;
	}
	public BigDecimal getR41_total_umm() {
		return r41_total_umm;
	}
	public void setR41_total_umm(BigDecimal r41_total_umm) {
		this.r41_total_umm = r41_total_umm;
	}
	public BigDecimal getR41_no_of_accounts_uae_fujairah() {
		return r41_no_of_accounts_uae_fujairah;
	}
	public void setR41_no_of_accounts_uae_fujairah(BigDecimal r41_no_of_accounts_uae_fujairah) {
		this.r41_no_of_accounts_uae_fujairah = r41_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR41_amount_uae_fujairah() {
		return r41_amount_uae_fujairah;
	}
	public void setR41_amount_uae_fujairah(BigDecimal r41_amount_uae_fujairah) {
		this.r41_amount_uae_fujairah = r41_amount_uae_fujairah;
	}
	public BigDecimal getR41_no_of_accounts_non_uae_fujairah() {
		return r41_no_of_accounts_non_uae_fujairah;
	}
	public void setR41_no_of_accounts_non_uae_fujairah(BigDecimal r41_no_of_accounts_non_uae_fujairah) {
		this.r41_no_of_accounts_non_uae_fujairah = r41_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR41_amount_non_uae_fujairah() {
		return r41_amount_non_uae_fujairah;
	}
	public void setR41_amount_non_uae_fujairah(BigDecimal r41_amount_non_uae_fujairah) {
		this.r41_amount_non_uae_fujairah = r41_amount_non_uae_fujairah;
	}
	public BigDecimal getR41_total_fujairah() {
		return r41_total_fujairah;
	}
	public void setR41_total_fujairah(BigDecimal r41_total_fujairah) {
		this.r41_total_fujairah = r41_total_fujairah;
	}
	public String getR42_product() {
		return r42_product;
	}
	public void setR42_product(String r42_product) {
		this.r42_product = r42_product;
	}
	public BigDecimal getR42_no_of_accounts_uae() {
		return r42_no_of_accounts_uae;
	}
	public void setR42_no_of_accounts_uae(BigDecimal r42_no_of_accounts_uae) {
		this.r42_no_of_accounts_uae = r42_no_of_accounts_uae;
	}
	public BigDecimal getR42_amount_uae() {
		return r42_amount_uae;
	}
	public void setR42_amount_uae(BigDecimal r42_amount_uae) {
		this.r42_amount_uae = r42_amount_uae;
	}
	public BigDecimal getR42_no_of_accounts_resident() {
		return r42_no_of_accounts_resident;
	}
	public void setR42_no_of_accounts_resident(BigDecimal r42_no_of_accounts_resident) {
		this.r42_no_of_accounts_resident = r42_no_of_accounts_resident;
	}
	public BigDecimal getR42_amount_resident() {
		return r42_amount_resident;
	}
	public void setR42_amount_resident(BigDecimal r42_amount_resident) {
		this.r42_amount_resident = r42_amount_resident;
	}
	public BigDecimal getR42_no_of_accounts_non_resident() {
		return r42_no_of_accounts_non_resident;
	}
	public void setR42_no_of_accounts_non_resident(BigDecimal r42_no_of_accounts_non_resident) {
		this.r42_no_of_accounts_non_resident = r42_no_of_accounts_non_resident;
	}
	public BigDecimal getR42_amount_non_resident() {
		return r42_amount_non_resident;
	}
	public void setR42_amount_non_resident(BigDecimal r42_amount_non_resident) {
		this.r42_amount_non_resident = r42_amount_non_resident;
	}
	public BigDecimal getR42_total_account() {
		return r42_total_account;
	}
	public void setR42_total_account(BigDecimal r42_total_account) {
		this.r42_total_account = r42_total_account;
	}
	public BigDecimal getR42_total_amount() {
		return r42_total_amount;
	}
	public void setR42_total_amount(BigDecimal r42_total_amount) {
		this.r42_total_amount = r42_total_amount;
	}
	public BigDecimal getR42_no_of_accounts_uae_abu() {
		return r42_no_of_accounts_uae_abu;
	}
	public void setR42_no_of_accounts_uae_abu(BigDecimal r42_no_of_accounts_uae_abu) {
		this.r42_no_of_accounts_uae_abu = r42_no_of_accounts_uae_abu;
	}
	public BigDecimal getR42_amount_uae_abu() {
		return r42_amount_uae_abu;
	}
	public void setR42_amount_uae_abu(BigDecimal r42_amount_uae_abu) {
		this.r42_amount_uae_abu = r42_amount_uae_abu;
	}
	public BigDecimal getR42_no_of_accounts_non_uae_abu() {
		return r42_no_of_accounts_non_uae_abu;
	}
	public void setR42_no_of_accounts_non_uae_abu(BigDecimal r42_no_of_accounts_non_uae_abu) {
		this.r42_no_of_accounts_non_uae_abu = r42_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR42_amount_non_uae_abu() {
		return r42_amount_non_uae_abu;
	}
	public void setR42_amount_non_uae_abu(BigDecimal r42_amount_non_uae_abu) {
		this.r42_amount_non_uae_abu = r42_amount_non_uae_abu;
	}
	public BigDecimal getR42_total_abu() {
		return r42_total_abu;
	}
	public void setR42_total_abu(BigDecimal r42_total_abu) {
		this.r42_total_abu = r42_total_abu;
	}
	public BigDecimal getR42_no_of_accounts_uae_dubai() {
		return r42_no_of_accounts_uae_dubai;
	}
	public void setR42_no_of_accounts_uae_dubai(BigDecimal r42_no_of_accounts_uae_dubai) {
		this.r42_no_of_accounts_uae_dubai = r42_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR42_amount_uae_dubai() {
		return r42_amount_uae_dubai;
	}
	public void setR42_amount_uae_dubai(BigDecimal r42_amount_uae_dubai) {
		this.r42_amount_uae_dubai = r42_amount_uae_dubai;
	}
	public BigDecimal getR42_no_of_accounts_non_uae_dubai() {
		return r42_no_of_accounts_non_uae_dubai;
	}
	public void setR42_no_of_accounts_non_uae_dubai(BigDecimal r42_no_of_accounts_non_uae_dubai) {
		this.r42_no_of_accounts_non_uae_dubai = r42_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR42_amount_non_uae_dubai() {
		return r42_amount_non_uae_dubai;
	}
	public void setR42_amount_non_uae_dubai(BigDecimal r42_amount_non_uae_dubai) {
		this.r42_amount_non_uae_dubai = r42_amount_non_uae_dubai;
	}
	public BigDecimal getR42_total_dubai() {
		return r42_total_dubai;
	}
	public void setR42_total_dubai(BigDecimal r42_total_dubai) {
		this.r42_total_dubai = r42_total_dubai;
	}
	public BigDecimal getR42_no_of_accounts_uae_sharjah() {
		return r42_no_of_accounts_uae_sharjah;
	}
	public void setR42_no_of_accounts_uae_sharjah(BigDecimal r42_no_of_accounts_uae_sharjah) {
		this.r42_no_of_accounts_uae_sharjah = r42_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR42_amount_uae_sharjah() {
		return r42_amount_uae_sharjah;
	}
	public void setR42_amount_uae_sharjah(BigDecimal r42_amount_uae_sharjah) {
		this.r42_amount_uae_sharjah = r42_amount_uae_sharjah;
	}
	public BigDecimal getR42_no_of_accounts_non_uae_sharjah() {
		return r42_no_of_accounts_non_uae_sharjah;
	}
	public void setR42_no_of_accounts_non_uae_sharjah(BigDecimal r42_no_of_accounts_non_uae_sharjah) {
		this.r42_no_of_accounts_non_uae_sharjah = r42_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR42_amount_non_uae_sharjah() {
		return r42_amount_non_uae_sharjah;
	}
	public void setR42_amount_non_uae_sharjah(BigDecimal r42_amount_non_uae_sharjah) {
		this.r42_amount_non_uae_sharjah = r42_amount_non_uae_sharjah;
	}
	public BigDecimal getR42_total_sharjah() {
		return r42_total_sharjah;
	}
	public void setR42_total_sharjah(BigDecimal r42_total_sharjah) {
		this.r42_total_sharjah = r42_total_sharjah;
	}
	public BigDecimal getR42_no_of_accounts_uae_ajman() {
		return r42_no_of_accounts_uae_ajman;
	}
	public void setR42_no_of_accounts_uae_ajman(BigDecimal r42_no_of_accounts_uae_ajman) {
		this.r42_no_of_accounts_uae_ajman = r42_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR42_amount_uae_ajman() {
		return r42_amount_uae_ajman;
	}
	public void setR42_amount_uae_ajman(BigDecimal r42_amount_uae_ajman) {
		this.r42_amount_uae_ajman = r42_amount_uae_ajman;
	}
	public BigDecimal getR42_no_of_accounts_non_uae_ajman() {
		return r42_no_of_accounts_non_uae_ajman;
	}
	public void setR42_no_of_accounts_non_uae_ajman(BigDecimal r42_no_of_accounts_non_uae_ajman) {
		this.r42_no_of_accounts_non_uae_ajman = r42_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR42_amount_non_uae_ajman() {
		return r42_amount_non_uae_ajman;
	}
	public void setR42_amount_non_uae_ajman(BigDecimal r42_amount_non_uae_ajman) {
		this.r42_amount_non_uae_ajman = r42_amount_non_uae_ajman;
	}
	public BigDecimal getR42_total_ajman() {
		return r42_total_ajman;
	}
	public void setR42_total_ajman(BigDecimal r42_total_ajman) {
		this.r42_total_ajman = r42_total_ajman;
	}
	public BigDecimal getR42_no_of_accounts_uae_ras() {
		return r42_no_of_accounts_uae_ras;
	}
	public void setR42_no_of_accounts_uae_ras(BigDecimal r42_no_of_accounts_uae_ras) {
		this.r42_no_of_accounts_uae_ras = r42_no_of_accounts_uae_ras;
	}
	public BigDecimal getR42_amount_uae_ras() {
		return r42_amount_uae_ras;
	}
	public void setR42_amount_uae_ras(BigDecimal r42_amount_uae_ras) {
		this.r42_amount_uae_ras = r42_amount_uae_ras;
	}
	public BigDecimal getR42_no_of_accounts_non_uae_ras() {
		return r42_no_of_accounts_non_uae_ras;
	}
	public void setR42_no_of_accounts_non_uae_ras(BigDecimal r42_no_of_accounts_non_uae_ras) {
		this.r42_no_of_accounts_non_uae_ras = r42_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR42_amount_non_uae_ras() {
		return r42_amount_non_uae_ras;
	}
	public void setR42_amount_non_uae_ras(BigDecimal r42_amount_non_uae_ras) {
		this.r42_amount_non_uae_ras = r42_amount_non_uae_ras;
	}
	public BigDecimal getR42_total_ras() {
		return r42_total_ras;
	}
	public void setR42_total_ras(BigDecimal r42_total_ras) {
		this.r42_total_ras = r42_total_ras;
	}
	public BigDecimal getR42_no_of_accounts_uae_umm() {
		return r42_no_of_accounts_uae_umm;
	}
	public void setR42_no_of_accounts_uae_umm(BigDecimal r42_no_of_accounts_uae_umm) {
		this.r42_no_of_accounts_uae_umm = r42_no_of_accounts_uae_umm;
	}
	public BigDecimal getR42_amount_uae_umm() {
		return r42_amount_uae_umm;
	}
	public void setR42_amount_uae_umm(BigDecimal r42_amount_uae_umm) {
		this.r42_amount_uae_umm = r42_amount_uae_umm;
	}
	public BigDecimal getR42_no_of_accounts_non_uae_umm() {
		return r42_no_of_accounts_non_uae_umm;
	}
	public void setR42_no_of_accounts_non_uae_umm(BigDecimal r42_no_of_accounts_non_uae_umm) {
		this.r42_no_of_accounts_non_uae_umm = r42_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR42_amount_non_uae_umm() {
		return r42_amount_non_uae_umm;
	}
	public void setR42_amount_non_uae_umm(BigDecimal r42_amount_non_uae_umm) {
		this.r42_amount_non_uae_umm = r42_amount_non_uae_umm;
	}
	public BigDecimal getR42_total_umm() {
		return r42_total_umm;
	}
	public void setR42_total_umm(BigDecimal r42_total_umm) {
		this.r42_total_umm = r42_total_umm;
	}
	public BigDecimal getR42_no_of_accounts_uae_fujairah() {
		return r42_no_of_accounts_uae_fujairah;
	}
	public void setR42_no_of_accounts_uae_fujairah(BigDecimal r42_no_of_accounts_uae_fujairah) {
		this.r42_no_of_accounts_uae_fujairah = r42_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR42_amount_uae_fujairah() {
		return r42_amount_uae_fujairah;
	}
	public void setR42_amount_uae_fujairah(BigDecimal r42_amount_uae_fujairah) {
		this.r42_amount_uae_fujairah = r42_amount_uae_fujairah;
	}
	public BigDecimal getR42_no_of_accounts_non_uae_fujairah() {
		return r42_no_of_accounts_non_uae_fujairah;
	}
	public void setR42_no_of_accounts_non_uae_fujairah(BigDecimal r42_no_of_accounts_non_uae_fujairah) {
		this.r42_no_of_accounts_non_uae_fujairah = r42_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR42_amount_non_uae_fujairah() {
		return r42_amount_non_uae_fujairah;
	}
	public void setR42_amount_non_uae_fujairah(BigDecimal r42_amount_non_uae_fujairah) {
		this.r42_amount_non_uae_fujairah = r42_amount_non_uae_fujairah;
	}
	public BigDecimal getR42_total_fujairah() {
		return r42_total_fujairah;
	}
	public void setR42_total_fujairah(BigDecimal r42_total_fujairah) {
		this.r42_total_fujairah = r42_total_fujairah;
	}
	public String getR43_product() {
		return r43_product;
	}
	public void setR43_product(String r43_product) {
		this.r43_product = r43_product;
	}
	public BigDecimal getR43_no_of_accounts_uae() {
		return r43_no_of_accounts_uae;
	}
	public void setR43_no_of_accounts_uae(BigDecimal r43_no_of_accounts_uae) {
		this.r43_no_of_accounts_uae = r43_no_of_accounts_uae;
	}
	public BigDecimal getR43_amount_uae() {
		return r43_amount_uae;
	}
	public void setR43_amount_uae(BigDecimal r43_amount_uae) {
		this.r43_amount_uae = r43_amount_uae;
	}
	public BigDecimal getR43_no_of_accounts_resident() {
		return r43_no_of_accounts_resident;
	}
	public void setR43_no_of_accounts_resident(BigDecimal r43_no_of_accounts_resident) {
		this.r43_no_of_accounts_resident = r43_no_of_accounts_resident;
	}
	public BigDecimal getR43_amount_resident() {
		return r43_amount_resident;
	}
	public void setR43_amount_resident(BigDecimal r43_amount_resident) {
		this.r43_amount_resident = r43_amount_resident;
	}
	public BigDecimal getR43_no_of_accounts_non_resident() {
		return r43_no_of_accounts_non_resident;
	}
	public void setR43_no_of_accounts_non_resident(BigDecimal r43_no_of_accounts_non_resident) {
		this.r43_no_of_accounts_non_resident = r43_no_of_accounts_non_resident;
	}
	public BigDecimal getR43_amount_non_resident() {
		return r43_amount_non_resident;
	}
	public void setR43_amount_non_resident(BigDecimal r43_amount_non_resident) {
		this.r43_amount_non_resident = r43_amount_non_resident;
	}
	public BigDecimal getR43_total_account() {
		return r43_total_account;
	}
	public void setR43_total_account(BigDecimal r43_total_account) {
		this.r43_total_account = r43_total_account;
	}
	public BigDecimal getR43_total_amount() {
		return r43_total_amount;
	}
	public void setR43_total_amount(BigDecimal r43_total_amount) {
		this.r43_total_amount = r43_total_amount;
	}
	public BigDecimal getR43_no_of_accounts_uae_abu() {
		return r43_no_of_accounts_uae_abu;
	}
	public void setR43_no_of_accounts_uae_abu(BigDecimal r43_no_of_accounts_uae_abu) {
		this.r43_no_of_accounts_uae_abu = r43_no_of_accounts_uae_abu;
	}
	public BigDecimal getR43_amount_uae_abu() {
		return r43_amount_uae_abu;
	}
	public void setR43_amount_uae_abu(BigDecimal r43_amount_uae_abu) {
		this.r43_amount_uae_abu = r43_amount_uae_abu;
	}
	public BigDecimal getR43_no_of_accounts_non_uae_abu() {
		return r43_no_of_accounts_non_uae_abu;
	}
	public void setR43_no_of_accounts_non_uae_abu(BigDecimal r43_no_of_accounts_non_uae_abu) {
		this.r43_no_of_accounts_non_uae_abu = r43_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR43_amount_non_uae_abu() {
		return r43_amount_non_uae_abu;
	}
	public void setR43_amount_non_uae_abu(BigDecimal r43_amount_non_uae_abu) {
		this.r43_amount_non_uae_abu = r43_amount_non_uae_abu;
	}
	public BigDecimal getR43_total_abu() {
		return r43_total_abu;
	}
	public void setR43_total_abu(BigDecimal r43_total_abu) {
		this.r43_total_abu = r43_total_abu;
	}
	public BigDecimal getR43_no_of_accounts_uae_dubai() {
		return r43_no_of_accounts_uae_dubai;
	}
	public void setR43_no_of_accounts_uae_dubai(BigDecimal r43_no_of_accounts_uae_dubai) {
		this.r43_no_of_accounts_uae_dubai = r43_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR43_amount_uae_dubai() {
		return r43_amount_uae_dubai;
	}
	public void setR43_amount_uae_dubai(BigDecimal r43_amount_uae_dubai) {
		this.r43_amount_uae_dubai = r43_amount_uae_dubai;
	}
	public BigDecimal getR43_no_of_accounts_non_uae_dubai() {
		return r43_no_of_accounts_non_uae_dubai;
	}
	public void setR43_no_of_accounts_non_uae_dubai(BigDecimal r43_no_of_accounts_non_uae_dubai) {
		this.r43_no_of_accounts_non_uae_dubai = r43_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR43_amount_non_uae_dubai() {
		return r43_amount_non_uae_dubai;
	}
	public void setR43_amount_non_uae_dubai(BigDecimal r43_amount_non_uae_dubai) {
		this.r43_amount_non_uae_dubai = r43_amount_non_uae_dubai;
	}
	public BigDecimal getR43_total_dubai() {
		return r43_total_dubai;
	}
	public void setR43_total_dubai(BigDecimal r43_total_dubai) {
		this.r43_total_dubai = r43_total_dubai;
	}
	public BigDecimal getR43_no_of_accounts_uae_sharjah() {
		return r43_no_of_accounts_uae_sharjah;
	}
	public void setR43_no_of_accounts_uae_sharjah(BigDecimal r43_no_of_accounts_uae_sharjah) {
		this.r43_no_of_accounts_uae_sharjah = r43_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR43_amount_uae_sharjah() {
		return r43_amount_uae_sharjah;
	}
	public void setR43_amount_uae_sharjah(BigDecimal r43_amount_uae_sharjah) {
		this.r43_amount_uae_sharjah = r43_amount_uae_sharjah;
	}
	public BigDecimal getR43_no_of_accounts_non_uae_sharjah() {
		return r43_no_of_accounts_non_uae_sharjah;
	}
	public void setR43_no_of_accounts_non_uae_sharjah(BigDecimal r43_no_of_accounts_non_uae_sharjah) {
		this.r43_no_of_accounts_non_uae_sharjah = r43_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR43_amount_non_uae_sharjah() {
		return r43_amount_non_uae_sharjah;
	}
	public void setR43_amount_non_uae_sharjah(BigDecimal r43_amount_non_uae_sharjah) {
		this.r43_amount_non_uae_sharjah = r43_amount_non_uae_sharjah;
	}
	public BigDecimal getR43_total_sharjah() {
		return r43_total_sharjah;
	}
	public void setR43_total_sharjah(BigDecimal r43_total_sharjah) {
		this.r43_total_sharjah = r43_total_sharjah;
	}
	public BigDecimal getR43_no_of_accounts_uae_ajman() {
		return r43_no_of_accounts_uae_ajman;
	}
	public void setR43_no_of_accounts_uae_ajman(BigDecimal r43_no_of_accounts_uae_ajman) {
		this.r43_no_of_accounts_uae_ajman = r43_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR43_amount_uae_ajman() {
		return r43_amount_uae_ajman;
	}
	public void setR43_amount_uae_ajman(BigDecimal r43_amount_uae_ajman) {
		this.r43_amount_uae_ajman = r43_amount_uae_ajman;
	}
	public BigDecimal getR43_no_of_accounts_non_uae_ajman() {
		return r43_no_of_accounts_non_uae_ajman;
	}
	public void setR43_no_of_accounts_non_uae_ajman(BigDecimal r43_no_of_accounts_non_uae_ajman) {
		this.r43_no_of_accounts_non_uae_ajman = r43_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR43_amount_non_uae_ajman() {
		return r43_amount_non_uae_ajman;
	}
	public void setR43_amount_non_uae_ajman(BigDecimal r43_amount_non_uae_ajman) {
		this.r43_amount_non_uae_ajman = r43_amount_non_uae_ajman;
	}
	public BigDecimal getR43_total_ajman() {
		return r43_total_ajman;
	}
	public void setR43_total_ajman(BigDecimal r43_total_ajman) {
		this.r43_total_ajman = r43_total_ajman;
	}
	public BigDecimal getR43_no_of_accounts_uae_ras() {
		return r43_no_of_accounts_uae_ras;
	}
	public void setR43_no_of_accounts_uae_ras(BigDecimal r43_no_of_accounts_uae_ras) {
		this.r43_no_of_accounts_uae_ras = r43_no_of_accounts_uae_ras;
	}
	public BigDecimal getR43_amount_uae_ras() {
		return r43_amount_uae_ras;
	}
	public void setR43_amount_uae_ras(BigDecimal r43_amount_uae_ras) {
		this.r43_amount_uae_ras = r43_amount_uae_ras;
	}
	public BigDecimal getR43_no_of_accounts_non_uae_ras() {
		return r43_no_of_accounts_non_uae_ras;
	}
	public void setR43_no_of_accounts_non_uae_ras(BigDecimal r43_no_of_accounts_non_uae_ras) {
		this.r43_no_of_accounts_non_uae_ras = r43_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR43_amount_non_uae_ras() {
		return r43_amount_non_uae_ras;
	}
	public void setR43_amount_non_uae_ras(BigDecimal r43_amount_non_uae_ras) {
		this.r43_amount_non_uae_ras = r43_amount_non_uae_ras;
	}
	public BigDecimal getR43_total_ras() {
		return r43_total_ras;
	}
	public void setR43_total_ras(BigDecimal r43_total_ras) {
		this.r43_total_ras = r43_total_ras;
	}
	public BigDecimal getR43_no_of_accounts_uae_umm() {
		return r43_no_of_accounts_uae_umm;
	}
	public void setR43_no_of_accounts_uae_umm(BigDecimal r43_no_of_accounts_uae_umm) {
		this.r43_no_of_accounts_uae_umm = r43_no_of_accounts_uae_umm;
	}
	public BigDecimal getR43_amount_uae_umm() {
		return r43_amount_uae_umm;
	}
	public void setR43_amount_uae_umm(BigDecimal r43_amount_uae_umm) {
		this.r43_amount_uae_umm = r43_amount_uae_umm;
	}
	public BigDecimal getR43_no_of_accounts_non_uae_umm() {
		return r43_no_of_accounts_non_uae_umm;
	}
	public void setR43_no_of_accounts_non_uae_umm(BigDecimal r43_no_of_accounts_non_uae_umm) {
		this.r43_no_of_accounts_non_uae_umm = r43_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR43_amount_non_uae_umm() {
		return r43_amount_non_uae_umm;
	}
	public void setR43_amount_non_uae_umm(BigDecimal r43_amount_non_uae_umm) {
		this.r43_amount_non_uae_umm = r43_amount_non_uae_umm;
	}
	public BigDecimal getR43_total_umm() {
		return r43_total_umm;
	}
	public void setR43_total_umm(BigDecimal r43_total_umm) {
		this.r43_total_umm = r43_total_umm;
	}
	public BigDecimal getR43_no_of_accounts_uae_fujairah() {
		return r43_no_of_accounts_uae_fujairah;
	}
	public void setR43_no_of_accounts_uae_fujairah(BigDecimal r43_no_of_accounts_uae_fujairah) {
		this.r43_no_of_accounts_uae_fujairah = r43_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR43_amount_uae_fujairah() {
		return r43_amount_uae_fujairah;
	}
	public void setR43_amount_uae_fujairah(BigDecimal r43_amount_uae_fujairah) {
		this.r43_amount_uae_fujairah = r43_amount_uae_fujairah;
	}
	public BigDecimal getR43_no_of_accounts_non_uae_fujairah() {
		return r43_no_of_accounts_non_uae_fujairah;
	}
	public void setR43_no_of_accounts_non_uae_fujairah(BigDecimal r43_no_of_accounts_non_uae_fujairah) {
		this.r43_no_of_accounts_non_uae_fujairah = r43_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR43_amount_non_uae_fujairah() {
		return r43_amount_non_uae_fujairah;
	}
	public void setR43_amount_non_uae_fujairah(BigDecimal r43_amount_non_uae_fujairah) {
		this.r43_amount_non_uae_fujairah = r43_amount_non_uae_fujairah;
	}
	public BigDecimal getR43_total_fujairah() {
		return r43_total_fujairah;
	}
	public void setR43_total_fujairah(BigDecimal r43_total_fujairah) {
		this.r43_total_fujairah = r43_total_fujairah;
	}
	public String getR44_product() {
		return r44_product;
	}
	public void setR44_product(String r44_product) {
		this.r44_product = r44_product;
	}
	public BigDecimal getR44_no_of_accounts_uae() {
		return r44_no_of_accounts_uae;
	}
	public void setR44_no_of_accounts_uae(BigDecimal r44_no_of_accounts_uae) {
		this.r44_no_of_accounts_uae = r44_no_of_accounts_uae;
	}
	public BigDecimal getR44_amount_uae() {
		return r44_amount_uae;
	}
	public void setR44_amount_uae(BigDecimal r44_amount_uae) {
		this.r44_amount_uae = r44_amount_uae;
	}
	public BigDecimal getR44_no_of_accounts_resident() {
		return r44_no_of_accounts_resident;
	}
	public void setR44_no_of_accounts_resident(BigDecimal r44_no_of_accounts_resident) {
		this.r44_no_of_accounts_resident = r44_no_of_accounts_resident;
	}
	public BigDecimal getR44_amount_resident() {
		return r44_amount_resident;
	}
	public void setR44_amount_resident(BigDecimal r44_amount_resident) {
		this.r44_amount_resident = r44_amount_resident;
	}
	public BigDecimal getR44_no_of_accounts_non_resident() {
		return r44_no_of_accounts_non_resident;
	}
	public void setR44_no_of_accounts_non_resident(BigDecimal r44_no_of_accounts_non_resident) {
		this.r44_no_of_accounts_non_resident = r44_no_of_accounts_non_resident;
	}
	public BigDecimal getR44_amount_non_resident() {
		return r44_amount_non_resident;
	}
	public void setR44_amount_non_resident(BigDecimal r44_amount_non_resident) {
		this.r44_amount_non_resident = r44_amount_non_resident;
	}
	public BigDecimal getR44_total_account() {
		return r44_total_account;
	}
	public void setR44_total_account(BigDecimal r44_total_account) {
		this.r44_total_account = r44_total_account;
	}
	public BigDecimal getR44_total_amount() {
		return r44_total_amount;
	}
	public void setR44_total_amount(BigDecimal r44_total_amount) {
		this.r44_total_amount = r44_total_amount;
	}
	public BigDecimal getR44_no_of_accounts_uae_abu() {
		return r44_no_of_accounts_uae_abu;
	}
	public void setR44_no_of_accounts_uae_abu(BigDecimal r44_no_of_accounts_uae_abu) {
		this.r44_no_of_accounts_uae_abu = r44_no_of_accounts_uae_abu;
	}
	public BigDecimal getR44_amount_uae_abu() {
		return r44_amount_uae_abu;
	}
	public void setR44_amount_uae_abu(BigDecimal r44_amount_uae_abu) {
		this.r44_amount_uae_abu = r44_amount_uae_abu;
	}
	public BigDecimal getR44_no_of_accounts_non_uae_abu() {
		return r44_no_of_accounts_non_uae_abu;
	}
	public void setR44_no_of_accounts_non_uae_abu(BigDecimal r44_no_of_accounts_non_uae_abu) {
		this.r44_no_of_accounts_non_uae_abu = r44_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR44_amount_non_uae_abu() {
		return r44_amount_non_uae_abu;
	}
	public void setR44_amount_non_uae_abu(BigDecimal r44_amount_non_uae_abu) {
		this.r44_amount_non_uae_abu = r44_amount_non_uae_abu;
	}
	public BigDecimal getR44_total_abu() {
		return r44_total_abu;
	}
	public void setR44_total_abu(BigDecimal r44_total_abu) {
		this.r44_total_abu = r44_total_abu;
	}
	public BigDecimal getR44_no_of_accounts_uae_dubai() {
		return r44_no_of_accounts_uae_dubai;
	}
	public void setR44_no_of_accounts_uae_dubai(BigDecimal r44_no_of_accounts_uae_dubai) {
		this.r44_no_of_accounts_uae_dubai = r44_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR44_amount_uae_dubai() {
		return r44_amount_uae_dubai;
	}
	public void setR44_amount_uae_dubai(BigDecimal r44_amount_uae_dubai) {
		this.r44_amount_uae_dubai = r44_amount_uae_dubai;
	}
	public BigDecimal getR44_no_of_accounts_non_uae_dubai() {
		return r44_no_of_accounts_non_uae_dubai;
	}
	public void setR44_no_of_accounts_non_uae_dubai(BigDecimal r44_no_of_accounts_non_uae_dubai) {
		this.r44_no_of_accounts_non_uae_dubai = r44_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR44_amount_non_uae_dubai() {
		return r44_amount_non_uae_dubai;
	}
	public void setR44_amount_non_uae_dubai(BigDecimal r44_amount_non_uae_dubai) {
		this.r44_amount_non_uae_dubai = r44_amount_non_uae_dubai;
	}
	public BigDecimal getR44_total_dubai() {
		return r44_total_dubai;
	}
	public void setR44_total_dubai(BigDecimal r44_total_dubai) {
		this.r44_total_dubai = r44_total_dubai;
	}
	public BigDecimal getR44_no_of_accounts_uae_sharjah() {
		return r44_no_of_accounts_uae_sharjah;
	}
	public void setR44_no_of_accounts_uae_sharjah(BigDecimal r44_no_of_accounts_uae_sharjah) {
		this.r44_no_of_accounts_uae_sharjah = r44_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR44_amount_uae_sharjah() {
		return r44_amount_uae_sharjah;
	}
	public void setR44_amount_uae_sharjah(BigDecimal r44_amount_uae_sharjah) {
		this.r44_amount_uae_sharjah = r44_amount_uae_sharjah;
	}
	public BigDecimal getR44_no_of_accounts_non_uae_sharjah() {
		return r44_no_of_accounts_non_uae_sharjah;
	}
	public void setR44_no_of_accounts_non_uae_sharjah(BigDecimal r44_no_of_accounts_non_uae_sharjah) {
		this.r44_no_of_accounts_non_uae_sharjah = r44_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR44_amount_non_uae_sharjah() {
		return r44_amount_non_uae_sharjah;
	}
	public void setR44_amount_non_uae_sharjah(BigDecimal r44_amount_non_uae_sharjah) {
		this.r44_amount_non_uae_sharjah = r44_amount_non_uae_sharjah;
	}
	public BigDecimal getR44_total_sharjah() {
		return r44_total_sharjah;
	}
	public void setR44_total_sharjah(BigDecimal r44_total_sharjah) {
		this.r44_total_sharjah = r44_total_sharjah;
	}
	public BigDecimal getR44_no_of_accounts_uae_ajman() {
		return r44_no_of_accounts_uae_ajman;
	}
	public void setR44_no_of_accounts_uae_ajman(BigDecimal r44_no_of_accounts_uae_ajman) {
		this.r44_no_of_accounts_uae_ajman = r44_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR44_amount_uae_ajman() {
		return r44_amount_uae_ajman;
	}
	public void setR44_amount_uae_ajman(BigDecimal r44_amount_uae_ajman) {
		this.r44_amount_uae_ajman = r44_amount_uae_ajman;
	}
	public BigDecimal getR44_no_of_accounts_non_uae_ajman() {
		return r44_no_of_accounts_non_uae_ajman;
	}
	public void setR44_no_of_accounts_non_uae_ajman(BigDecimal r44_no_of_accounts_non_uae_ajman) {
		this.r44_no_of_accounts_non_uae_ajman = r44_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR44_amount_non_uae_ajman() {
		return r44_amount_non_uae_ajman;
	}
	public void setR44_amount_non_uae_ajman(BigDecimal r44_amount_non_uae_ajman) {
		this.r44_amount_non_uae_ajman = r44_amount_non_uae_ajman;
	}
	public BigDecimal getR44_total_ajman() {
		return r44_total_ajman;
	}
	public void setR44_total_ajman(BigDecimal r44_total_ajman) {
		this.r44_total_ajman = r44_total_ajman;
	}
	public BigDecimal getR44_no_of_accounts_uae_ras() {
		return r44_no_of_accounts_uae_ras;
	}
	public void setR44_no_of_accounts_uae_ras(BigDecimal r44_no_of_accounts_uae_ras) {
		this.r44_no_of_accounts_uae_ras = r44_no_of_accounts_uae_ras;
	}
	public BigDecimal getR44_amount_uae_ras() {
		return r44_amount_uae_ras;
	}
	public void setR44_amount_uae_ras(BigDecimal r44_amount_uae_ras) {
		this.r44_amount_uae_ras = r44_amount_uae_ras;
	}
	public BigDecimal getR44_no_of_accounts_non_uae_ras() {
		return r44_no_of_accounts_non_uae_ras;
	}
	public void setR44_no_of_accounts_non_uae_ras(BigDecimal r44_no_of_accounts_non_uae_ras) {
		this.r44_no_of_accounts_non_uae_ras = r44_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR44_amount_non_uae_ras() {
		return r44_amount_non_uae_ras;
	}
	public void setR44_amount_non_uae_ras(BigDecimal r44_amount_non_uae_ras) {
		this.r44_amount_non_uae_ras = r44_amount_non_uae_ras;
	}
	public BigDecimal getR44_total_ras() {
		return r44_total_ras;
	}
	public void setR44_total_ras(BigDecimal r44_total_ras) {
		this.r44_total_ras = r44_total_ras;
	}
	public BigDecimal getR44_no_of_accounts_uae_umm() {
		return r44_no_of_accounts_uae_umm;
	}
	public void setR44_no_of_accounts_uae_umm(BigDecimal r44_no_of_accounts_uae_umm) {
		this.r44_no_of_accounts_uae_umm = r44_no_of_accounts_uae_umm;
	}
	public BigDecimal getR44_amount_uae_umm() {
		return r44_amount_uae_umm;
	}
	public void setR44_amount_uae_umm(BigDecimal r44_amount_uae_umm) {
		this.r44_amount_uae_umm = r44_amount_uae_umm;
	}
	public BigDecimal getR44_no_of_accounts_non_uae_umm() {
		return r44_no_of_accounts_non_uae_umm;
	}
	public void setR44_no_of_accounts_non_uae_umm(BigDecimal r44_no_of_accounts_non_uae_umm) {
		this.r44_no_of_accounts_non_uae_umm = r44_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR44_amount_non_uae_umm() {
		return r44_amount_non_uae_umm;
	}
	public void setR44_amount_non_uae_umm(BigDecimal r44_amount_non_uae_umm) {
		this.r44_amount_non_uae_umm = r44_amount_non_uae_umm;
	}
	public BigDecimal getR44_total_umm() {
		return r44_total_umm;
	}
	public void setR44_total_umm(BigDecimal r44_total_umm) {
		this.r44_total_umm = r44_total_umm;
	}
	public BigDecimal getR44_no_of_accounts_uae_fujairah() {
		return r44_no_of_accounts_uae_fujairah;
	}
	public void setR44_no_of_accounts_uae_fujairah(BigDecimal r44_no_of_accounts_uae_fujairah) {
		this.r44_no_of_accounts_uae_fujairah = r44_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR44_amount_uae_fujairah() {
		return r44_amount_uae_fujairah;
	}
	public void setR44_amount_uae_fujairah(BigDecimal r44_amount_uae_fujairah) {
		this.r44_amount_uae_fujairah = r44_amount_uae_fujairah;
	}
	public BigDecimal getR44_no_of_accounts_non_uae_fujairah() {
		return r44_no_of_accounts_non_uae_fujairah;
	}
	public void setR44_no_of_accounts_non_uae_fujairah(BigDecimal r44_no_of_accounts_non_uae_fujairah) {
		this.r44_no_of_accounts_non_uae_fujairah = r44_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR44_amount_non_uae_fujairah() {
		return r44_amount_non_uae_fujairah;
	}
	public void setR44_amount_non_uae_fujairah(BigDecimal r44_amount_non_uae_fujairah) {
		this.r44_amount_non_uae_fujairah = r44_amount_non_uae_fujairah;
	}
	public BigDecimal getR44_total_fujairah() {
		return r44_total_fujairah;
	}
	public void setR44_total_fujairah(BigDecimal r44_total_fujairah) {
		this.r44_total_fujairah = r44_total_fujairah;
	}
	public String getR45_product() {
		return r45_product;
	}
	public void setR45_product(String r45_product) {
		this.r45_product = r45_product;
	}
	public BigDecimal getR45_no_of_accounts_uae() {
		return r45_no_of_accounts_uae;
	}
	public void setR45_no_of_accounts_uae(BigDecimal r45_no_of_accounts_uae) {
		this.r45_no_of_accounts_uae = r45_no_of_accounts_uae;
	}
	public BigDecimal getR45_amount_uae() {
		return r45_amount_uae;
	}
	public void setR45_amount_uae(BigDecimal r45_amount_uae) {
		this.r45_amount_uae = r45_amount_uae;
	}
	public BigDecimal getR45_no_of_accounts_resident() {
		return r45_no_of_accounts_resident;
	}
	public void setR45_no_of_accounts_resident(BigDecimal r45_no_of_accounts_resident) {
		this.r45_no_of_accounts_resident = r45_no_of_accounts_resident;
	}
	public BigDecimal getR45_amount_resident() {
		return r45_amount_resident;
	}
	public void setR45_amount_resident(BigDecimal r45_amount_resident) {
		this.r45_amount_resident = r45_amount_resident;
	}
	public BigDecimal getR45_no_of_accounts_non_resident() {
		return r45_no_of_accounts_non_resident;
	}
	public void setR45_no_of_accounts_non_resident(BigDecimal r45_no_of_accounts_non_resident) {
		this.r45_no_of_accounts_non_resident = r45_no_of_accounts_non_resident;
	}
	public BigDecimal getR45_amount_non_resident() {
		return r45_amount_non_resident;
	}
	public void setR45_amount_non_resident(BigDecimal r45_amount_non_resident) {
		this.r45_amount_non_resident = r45_amount_non_resident;
	}
	public BigDecimal getR45_total_account() {
		return r45_total_account;
	}
	public void setR45_total_account(BigDecimal r45_total_account) {
		this.r45_total_account = r45_total_account;
	}
	public BigDecimal getR45_total_amount() {
		return r45_total_amount;
	}
	public void setR45_total_amount(BigDecimal r45_total_amount) {
		this.r45_total_amount = r45_total_amount;
	}
	public BigDecimal getR45_no_of_accounts_uae_abu() {
		return r45_no_of_accounts_uae_abu;
	}
	public void setR45_no_of_accounts_uae_abu(BigDecimal r45_no_of_accounts_uae_abu) {
		this.r45_no_of_accounts_uae_abu = r45_no_of_accounts_uae_abu;
	}
	public BigDecimal getR45_amount_uae_abu() {
		return r45_amount_uae_abu;
	}
	public void setR45_amount_uae_abu(BigDecimal r45_amount_uae_abu) {
		this.r45_amount_uae_abu = r45_amount_uae_abu;
	}
	public BigDecimal getR45_no_of_accounts_non_uae_abu() {
		return r45_no_of_accounts_non_uae_abu;
	}
	public void setR45_no_of_accounts_non_uae_abu(BigDecimal r45_no_of_accounts_non_uae_abu) {
		this.r45_no_of_accounts_non_uae_abu = r45_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR45_amount_non_uae_abu() {
		return r45_amount_non_uae_abu;
	}
	public void setR45_amount_non_uae_abu(BigDecimal r45_amount_non_uae_abu) {
		this.r45_amount_non_uae_abu = r45_amount_non_uae_abu;
	}
	public BigDecimal getR45_total_abu() {
		return r45_total_abu;
	}
	public void setR45_total_abu(BigDecimal r45_total_abu) {
		this.r45_total_abu = r45_total_abu;
	}
	public BigDecimal getR45_no_of_accounts_uae_dubai() {
		return r45_no_of_accounts_uae_dubai;
	}
	public void setR45_no_of_accounts_uae_dubai(BigDecimal r45_no_of_accounts_uae_dubai) {
		this.r45_no_of_accounts_uae_dubai = r45_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR45_amount_uae_dubai() {
		return r45_amount_uae_dubai;
	}
	public void setR45_amount_uae_dubai(BigDecimal r45_amount_uae_dubai) {
		this.r45_amount_uae_dubai = r45_amount_uae_dubai;
	}
	public BigDecimal getR45_no_of_accounts_non_uae_dubai() {
		return r45_no_of_accounts_non_uae_dubai;
	}
	public void setR45_no_of_accounts_non_uae_dubai(BigDecimal r45_no_of_accounts_non_uae_dubai) {
		this.r45_no_of_accounts_non_uae_dubai = r45_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR45_amount_non_uae_dubai() {
		return r45_amount_non_uae_dubai;
	}
	public void setR45_amount_non_uae_dubai(BigDecimal r45_amount_non_uae_dubai) {
		this.r45_amount_non_uae_dubai = r45_amount_non_uae_dubai;
	}
	public BigDecimal getR45_total_dubai() {
		return r45_total_dubai;
	}
	public void setR45_total_dubai(BigDecimal r45_total_dubai) {
		this.r45_total_dubai = r45_total_dubai;
	}
	public BigDecimal getR45_no_of_accounts_uae_sharjah() {
		return r45_no_of_accounts_uae_sharjah;
	}
	public void setR45_no_of_accounts_uae_sharjah(BigDecimal r45_no_of_accounts_uae_sharjah) {
		this.r45_no_of_accounts_uae_sharjah = r45_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR45_amount_uae_sharjah() {
		return r45_amount_uae_sharjah;
	}
	public void setR45_amount_uae_sharjah(BigDecimal r45_amount_uae_sharjah) {
		this.r45_amount_uae_sharjah = r45_amount_uae_sharjah;
	}
	public BigDecimal getR45_no_of_accounts_non_uae_sharjah() {
		return r45_no_of_accounts_non_uae_sharjah;
	}
	public void setR45_no_of_accounts_non_uae_sharjah(BigDecimal r45_no_of_accounts_non_uae_sharjah) {
		this.r45_no_of_accounts_non_uae_sharjah = r45_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR45_amount_non_uae_sharjah() {
		return r45_amount_non_uae_sharjah;
	}
	public void setR45_amount_non_uae_sharjah(BigDecimal r45_amount_non_uae_sharjah) {
		this.r45_amount_non_uae_sharjah = r45_amount_non_uae_sharjah;
	}
	public BigDecimal getR45_total_sharjah() {
		return r45_total_sharjah;
	}
	public void setR45_total_sharjah(BigDecimal r45_total_sharjah) {
		this.r45_total_sharjah = r45_total_sharjah;
	}
	public BigDecimal getR45_no_of_accounts_uae_ajman() {
		return r45_no_of_accounts_uae_ajman;
	}
	public void setR45_no_of_accounts_uae_ajman(BigDecimal r45_no_of_accounts_uae_ajman) {
		this.r45_no_of_accounts_uae_ajman = r45_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR45_amount_uae_ajman() {
		return r45_amount_uae_ajman;
	}
	public void setR45_amount_uae_ajman(BigDecimal r45_amount_uae_ajman) {
		this.r45_amount_uae_ajman = r45_amount_uae_ajman;
	}
	public BigDecimal getR45_no_of_accounts_non_uae_ajman() {
		return r45_no_of_accounts_non_uae_ajman;
	}
	public void setR45_no_of_accounts_non_uae_ajman(BigDecimal r45_no_of_accounts_non_uae_ajman) {
		this.r45_no_of_accounts_non_uae_ajman = r45_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR45_amount_non_uae_ajman() {
		return r45_amount_non_uae_ajman;
	}
	public void setR45_amount_non_uae_ajman(BigDecimal r45_amount_non_uae_ajman) {
		this.r45_amount_non_uae_ajman = r45_amount_non_uae_ajman;
	}
	public BigDecimal getR45_total_ajman() {
		return r45_total_ajman;
	}
	public void setR45_total_ajman(BigDecimal r45_total_ajman) {
		this.r45_total_ajman = r45_total_ajman;
	}
	public BigDecimal getR45_no_of_accounts_uae_ras() {
		return r45_no_of_accounts_uae_ras;
	}
	public void setR45_no_of_accounts_uae_ras(BigDecimal r45_no_of_accounts_uae_ras) {
		this.r45_no_of_accounts_uae_ras = r45_no_of_accounts_uae_ras;
	}
	public BigDecimal getR45_amount_uae_ras() {
		return r45_amount_uae_ras;
	}
	public void setR45_amount_uae_ras(BigDecimal r45_amount_uae_ras) {
		this.r45_amount_uae_ras = r45_amount_uae_ras;
	}
	public BigDecimal getR45_no_of_accounts_non_uae_ras() {
		return r45_no_of_accounts_non_uae_ras;
	}
	public void setR45_no_of_accounts_non_uae_ras(BigDecimal r45_no_of_accounts_non_uae_ras) {
		this.r45_no_of_accounts_non_uae_ras = r45_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR45_amount_non_uae_ras() {
		return r45_amount_non_uae_ras;
	}
	public void setR45_amount_non_uae_ras(BigDecimal r45_amount_non_uae_ras) {
		this.r45_amount_non_uae_ras = r45_amount_non_uae_ras;
	}
	public BigDecimal getR45_total_ras() {
		return r45_total_ras;
	}
	public void setR45_total_ras(BigDecimal r45_total_ras) {
		this.r45_total_ras = r45_total_ras;
	}
	public BigDecimal getR45_no_of_accounts_uae_umm() {
		return r45_no_of_accounts_uae_umm;
	}
	public void setR45_no_of_accounts_uae_umm(BigDecimal r45_no_of_accounts_uae_umm) {
		this.r45_no_of_accounts_uae_umm = r45_no_of_accounts_uae_umm;
	}
	public BigDecimal getR45_amount_uae_umm() {
		return r45_amount_uae_umm;
	}
	public void setR45_amount_uae_umm(BigDecimal r45_amount_uae_umm) {
		this.r45_amount_uae_umm = r45_amount_uae_umm;
	}
	public BigDecimal getR45_no_of_accounts_non_uae_umm() {
		return r45_no_of_accounts_non_uae_umm;
	}
	public void setR45_no_of_accounts_non_uae_umm(BigDecimal r45_no_of_accounts_non_uae_umm) {
		this.r45_no_of_accounts_non_uae_umm = r45_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR45_amount_non_uae_umm() {
		return r45_amount_non_uae_umm;
	}
	public void setR45_amount_non_uae_umm(BigDecimal r45_amount_non_uae_umm) {
		this.r45_amount_non_uae_umm = r45_amount_non_uae_umm;
	}
	public BigDecimal getR45_total_umm() {
		return r45_total_umm;
	}
	public void setR45_total_umm(BigDecimal r45_total_umm) {
		this.r45_total_umm = r45_total_umm;
	}
	public BigDecimal getR45_no_of_accounts_uae_fujairah() {
		return r45_no_of_accounts_uae_fujairah;
	}
	public void setR45_no_of_accounts_uae_fujairah(BigDecimal r45_no_of_accounts_uae_fujairah) {
		this.r45_no_of_accounts_uae_fujairah = r45_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR45_amount_uae_fujairah() {
		return r45_amount_uae_fujairah;
	}
	public void setR45_amount_uae_fujairah(BigDecimal r45_amount_uae_fujairah) {
		this.r45_amount_uae_fujairah = r45_amount_uae_fujairah;
	}
	public BigDecimal getR45_no_of_accounts_non_uae_fujairah() {
		return r45_no_of_accounts_non_uae_fujairah;
	}
	public void setR45_no_of_accounts_non_uae_fujairah(BigDecimal r45_no_of_accounts_non_uae_fujairah) {
		this.r45_no_of_accounts_non_uae_fujairah = r45_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR45_amount_non_uae_fujairah() {
		return r45_amount_non_uae_fujairah;
	}
	public void setR45_amount_non_uae_fujairah(BigDecimal r45_amount_non_uae_fujairah) {
		this.r45_amount_non_uae_fujairah = r45_amount_non_uae_fujairah;
	}
	public BigDecimal getR45_total_fujairah() {
		return r45_total_fujairah;
	}
	public void setR45_total_fujairah(BigDecimal r45_total_fujairah) {
		this.r45_total_fujairah = r45_total_fujairah;
	}
	public String getR46_product() {
		return r46_product;
	}
	public void setR46_product(String r46_product) {
		this.r46_product = r46_product;
	}
	public BigDecimal getR46_no_of_accounts_uae() {
		return r46_no_of_accounts_uae;
	}
	public void setR46_no_of_accounts_uae(BigDecimal r46_no_of_accounts_uae) {
		this.r46_no_of_accounts_uae = r46_no_of_accounts_uae;
	}
	public BigDecimal getR46_amount_uae() {
		return r46_amount_uae;
	}
	public void setR46_amount_uae(BigDecimal r46_amount_uae) {
		this.r46_amount_uae = r46_amount_uae;
	}
	public BigDecimal getR46_no_of_accounts_resident() {
		return r46_no_of_accounts_resident;
	}
	public void setR46_no_of_accounts_resident(BigDecimal r46_no_of_accounts_resident) {
		this.r46_no_of_accounts_resident = r46_no_of_accounts_resident;
	}
	public BigDecimal getR46_amount_resident() {
		return r46_amount_resident;
	}
	public void setR46_amount_resident(BigDecimal r46_amount_resident) {
		this.r46_amount_resident = r46_amount_resident;
	}
	public BigDecimal getR46_no_of_accounts_non_resident() {
		return r46_no_of_accounts_non_resident;
	}
	public void setR46_no_of_accounts_non_resident(BigDecimal r46_no_of_accounts_non_resident) {
		this.r46_no_of_accounts_non_resident = r46_no_of_accounts_non_resident;
	}
	public BigDecimal getR46_amount_non_resident() {
		return r46_amount_non_resident;
	}
	public void setR46_amount_non_resident(BigDecimal r46_amount_non_resident) {
		this.r46_amount_non_resident = r46_amount_non_resident;
	}
	public BigDecimal getR46_total_account() {
		return r46_total_account;
	}
	public void setR46_total_account(BigDecimal r46_total_account) {
		this.r46_total_account = r46_total_account;
	}
	public BigDecimal getR46_total_amount() {
		return r46_total_amount;
	}
	public void setR46_total_amount(BigDecimal r46_total_amount) {
		this.r46_total_amount = r46_total_amount;
	}
	public BigDecimal getR46_no_of_accounts_uae_abu() {
		return r46_no_of_accounts_uae_abu;
	}
	public void setR46_no_of_accounts_uae_abu(BigDecimal r46_no_of_accounts_uae_abu) {
		this.r46_no_of_accounts_uae_abu = r46_no_of_accounts_uae_abu;
	}
	public BigDecimal getR46_amount_uae_abu() {
		return r46_amount_uae_abu;
	}
	public void setR46_amount_uae_abu(BigDecimal r46_amount_uae_abu) {
		this.r46_amount_uae_abu = r46_amount_uae_abu;
	}
	public BigDecimal getR46_no_of_accounts_non_uae_abu() {
		return r46_no_of_accounts_non_uae_abu;
	}
	public void setR46_no_of_accounts_non_uae_abu(BigDecimal r46_no_of_accounts_non_uae_abu) {
		this.r46_no_of_accounts_non_uae_abu = r46_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR46_amount_non_uae_abu() {
		return r46_amount_non_uae_abu;
	}
	public void setR46_amount_non_uae_abu(BigDecimal r46_amount_non_uae_abu) {
		this.r46_amount_non_uae_abu = r46_amount_non_uae_abu;
	}
	public BigDecimal getR46_total_abu() {
		return r46_total_abu;
	}
	public void setR46_total_abu(BigDecimal r46_total_abu) {
		this.r46_total_abu = r46_total_abu;
	}
	public BigDecimal getR46_no_of_accounts_uae_dubai() {
		return r46_no_of_accounts_uae_dubai;
	}
	public void setR46_no_of_accounts_uae_dubai(BigDecimal r46_no_of_accounts_uae_dubai) {
		this.r46_no_of_accounts_uae_dubai = r46_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR46_amount_uae_dubai() {
		return r46_amount_uae_dubai;
	}
	public void setR46_amount_uae_dubai(BigDecimal r46_amount_uae_dubai) {
		this.r46_amount_uae_dubai = r46_amount_uae_dubai;
	}
	public BigDecimal getR46_no_of_accounts_non_uae_dubai() {
		return r46_no_of_accounts_non_uae_dubai;
	}
	public void setR46_no_of_accounts_non_uae_dubai(BigDecimal r46_no_of_accounts_non_uae_dubai) {
		this.r46_no_of_accounts_non_uae_dubai = r46_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR46_amount_non_uae_dubai() {
		return r46_amount_non_uae_dubai;
	}
	public void setR46_amount_non_uae_dubai(BigDecimal r46_amount_non_uae_dubai) {
		this.r46_amount_non_uae_dubai = r46_amount_non_uae_dubai;
	}
	public BigDecimal getR46_total_dubai() {
		return r46_total_dubai;
	}
	public void setR46_total_dubai(BigDecimal r46_total_dubai) {
		this.r46_total_dubai = r46_total_dubai;
	}
	public BigDecimal getR46_no_of_accounts_uae_sharjah() {
		return r46_no_of_accounts_uae_sharjah;
	}
	public void setR46_no_of_accounts_uae_sharjah(BigDecimal r46_no_of_accounts_uae_sharjah) {
		this.r46_no_of_accounts_uae_sharjah = r46_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR46_amount_uae_sharjah() {
		return r46_amount_uae_sharjah;
	}
	public void setR46_amount_uae_sharjah(BigDecimal r46_amount_uae_sharjah) {
		this.r46_amount_uae_sharjah = r46_amount_uae_sharjah;
	}
	public BigDecimal getR46_no_of_accounts_non_uae_sharjah() {
		return r46_no_of_accounts_non_uae_sharjah;
	}
	public void setR46_no_of_accounts_non_uae_sharjah(BigDecimal r46_no_of_accounts_non_uae_sharjah) {
		this.r46_no_of_accounts_non_uae_sharjah = r46_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR46_amount_non_uae_sharjah() {
		return r46_amount_non_uae_sharjah;
	}
	public void setR46_amount_non_uae_sharjah(BigDecimal r46_amount_non_uae_sharjah) {
		this.r46_amount_non_uae_sharjah = r46_amount_non_uae_sharjah;
	}
	public BigDecimal getR46_total_sharjah() {
		return r46_total_sharjah;
	}
	public void setR46_total_sharjah(BigDecimal r46_total_sharjah) {
		this.r46_total_sharjah = r46_total_sharjah;
	}
	public BigDecimal getR46_no_of_accounts_uae_ajman() {
		return r46_no_of_accounts_uae_ajman;
	}
	public void setR46_no_of_accounts_uae_ajman(BigDecimal r46_no_of_accounts_uae_ajman) {
		this.r46_no_of_accounts_uae_ajman = r46_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR46_amount_uae_ajman() {
		return r46_amount_uae_ajman;
	}
	public void setR46_amount_uae_ajman(BigDecimal r46_amount_uae_ajman) {
		this.r46_amount_uae_ajman = r46_amount_uae_ajman;
	}
	public BigDecimal getR46_no_of_accounts_non_uae_ajman() {
		return r46_no_of_accounts_non_uae_ajman;
	}
	public void setR46_no_of_accounts_non_uae_ajman(BigDecimal r46_no_of_accounts_non_uae_ajman) {
		this.r46_no_of_accounts_non_uae_ajman = r46_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR46_amount_non_uae_ajman() {
		return r46_amount_non_uae_ajman;
	}
	public void setR46_amount_non_uae_ajman(BigDecimal r46_amount_non_uae_ajman) {
		this.r46_amount_non_uae_ajman = r46_amount_non_uae_ajman;
	}
	public BigDecimal getR46_total_ajman() {
		return r46_total_ajman;
	}
	public void setR46_total_ajman(BigDecimal r46_total_ajman) {
		this.r46_total_ajman = r46_total_ajman;
	}
	public BigDecimal getR46_no_of_accounts_uae_ras() {
		return r46_no_of_accounts_uae_ras;
	}
	public void setR46_no_of_accounts_uae_ras(BigDecimal r46_no_of_accounts_uae_ras) {
		this.r46_no_of_accounts_uae_ras = r46_no_of_accounts_uae_ras;
	}
	public BigDecimal getR46_amount_uae_ras() {
		return r46_amount_uae_ras;
	}
	public void setR46_amount_uae_ras(BigDecimal r46_amount_uae_ras) {
		this.r46_amount_uae_ras = r46_amount_uae_ras;
	}
	public BigDecimal getR46_no_of_accounts_non_uae_ras() {
		return r46_no_of_accounts_non_uae_ras;
	}
	public void setR46_no_of_accounts_non_uae_ras(BigDecimal r46_no_of_accounts_non_uae_ras) {
		this.r46_no_of_accounts_non_uae_ras = r46_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR46_amount_non_uae_ras() {
		return r46_amount_non_uae_ras;
	}
	public void setR46_amount_non_uae_ras(BigDecimal r46_amount_non_uae_ras) {
		this.r46_amount_non_uae_ras = r46_amount_non_uae_ras;
	}
	public BigDecimal getR46_total_ras() {
		return r46_total_ras;
	}
	public void setR46_total_ras(BigDecimal r46_total_ras) {
		this.r46_total_ras = r46_total_ras;
	}
	public BigDecimal getR46_no_of_accounts_uae_umm() {
		return r46_no_of_accounts_uae_umm;
	}
	public void setR46_no_of_accounts_uae_umm(BigDecimal r46_no_of_accounts_uae_umm) {
		this.r46_no_of_accounts_uae_umm = r46_no_of_accounts_uae_umm;
	}
	public BigDecimal getR46_amount_uae_umm() {
		return r46_amount_uae_umm;
	}
	public void setR46_amount_uae_umm(BigDecimal r46_amount_uae_umm) {
		this.r46_amount_uae_umm = r46_amount_uae_umm;
	}
	public BigDecimal getR46_no_of_accounts_non_uae_umm() {
		return r46_no_of_accounts_non_uae_umm;
	}
	public void setR46_no_of_accounts_non_uae_umm(BigDecimal r46_no_of_accounts_non_uae_umm) {
		this.r46_no_of_accounts_non_uae_umm = r46_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR46_amount_non_uae_umm() {
		return r46_amount_non_uae_umm;
	}
	public void setR46_amount_non_uae_umm(BigDecimal r46_amount_non_uae_umm) {
		this.r46_amount_non_uae_umm = r46_amount_non_uae_umm;
	}
	public BigDecimal getR46_total_umm() {
		return r46_total_umm;
	}
	public void setR46_total_umm(BigDecimal r46_total_umm) {
		this.r46_total_umm = r46_total_umm;
	}
	public BigDecimal getR46_no_of_accounts_uae_fujairah() {
		return r46_no_of_accounts_uae_fujairah;
	}
	public void setR46_no_of_accounts_uae_fujairah(BigDecimal r46_no_of_accounts_uae_fujairah) {
		this.r46_no_of_accounts_uae_fujairah = r46_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR46_amount_uae_fujairah() {
		return r46_amount_uae_fujairah;
	}
	public void setR46_amount_uae_fujairah(BigDecimal r46_amount_uae_fujairah) {
		this.r46_amount_uae_fujairah = r46_amount_uae_fujairah;
	}
	public BigDecimal getR46_no_of_accounts_non_uae_fujairah() {
		return r46_no_of_accounts_non_uae_fujairah;
	}
	public void setR46_no_of_accounts_non_uae_fujairah(BigDecimal r46_no_of_accounts_non_uae_fujairah) {
		this.r46_no_of_accounts_non_uae_fujairah = r46_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR46_amount_non_uae_fujairah() {
		return r46_amount_non_uae_fujairah;
	}
	public void setR46_amount_non_uae_fujairah(BigDecimal r46_amount_non_uae_fujairah) {
		this.r46_amount_non_uae_fujairah = r46_amount_non_uae_fujairah;
	}
	public BigDecimal getR46_total_fujairah() {
		return r46_total_fujairah;
	}
	public void setR46_total_fujairah(BigDecimal r46_total_fujairah) {
		this.r46_total_fujairah = r46_total_fujairah;
	}
	public String getR47_product() {
		return r47_product;
	}
	public void setR47_product(String r47_product) {
		this.r47_product = r47_product;
	}
	public BigDecimal getR47_no_of_accounts_uae() {
		return r47_no_of_accounts_uae;
	}
	public void setR47_no_of_accounts_uae(BigDecimal r47_no_of_accounts_uae) {
		this.r47_no_of_accounts_uae = r47_no_of_accounts_uae;
	}
	public BigDecimal getR47_amount_uae() {
		return r47_amount_uae;
	}
	public void setR47_amount_uae(BigDecimal r47_amount_uae) {
		this.r47_amount_uae = r47_amount_uae;
	}
	public BigDecimal getR47_no_of_accounts_resident() {
		return r47_no_of_accounts_resident;
	}
	public void setR47_no_of_accounts_resident(BigDecimal r47_no_of_accounts_resident) {
		this.r47_no_of_accounts_resident = r47_no_of_accounts_resident;
	}
	public BigDecimal getR47_amount_resident() {
		return r47_amount_resident;
	}
	public void setR47_amount_resident(BigDecimal r47_amount_resident) {
		this.r47_amount_resident = r47_amount_resident;
	}
	public BigDecimal getR47_no_of_accounts_non_resident() {
		return r47_no_of_accounts_non_resident;
	}
	public void setR47_no_of_accounts_non_resident(BigDecimal r47_no_of_accounts_non_resident) {
		this.r47_no_of_accounts_non_resident = r47_no_of_accounts_non_resident;
	}
	public BigDecimal getR47_amount_non_resident() {
		return r47_amount_non_resident;
	}
	public void setR47_amount_non_resident(BigDecimal r47_amount_non_resident) {
		this.r47_amount_non_resident = r47_amount_non_resident;
	}
	public BigDecimal getR47_total_account() {
		return r47_total_account;
	}
	public void setR47_total_account(BigDecimal r47_total_account) {
		this.r47_total_account = r47_total_account;
	}
	public BigDecimal getR47_total_amount() {
		return r47_total_amount;
	}
	public void setR47_total_amount(BigDecimal r47_total_amount) {
		this.r47_total_amount = r47_total_amount;
	}
	public BigDecimal getR47_no_of_accounts_uae_abu() {
		return r47_no_of_accounts_uae_abu;
	}
	public void setR47_no_of_accounts_uae_abu(BigDecimal r47_no_of_accounts_uae_abu) {
		this.r47_no_of_accounts_uae_abu = r47_no_of_accounts_uae_abu;
	}
	public BigDecimal getR47_amount_uae_abu() {
		return r47_amount_uae_abu;
	}
	public void setR47_amount_uae_abu(BigDecimal r47_amount_uae_abu) {
		this.r47_amount_uae_abu = r47_amount_uae_abu;
	}
	public BigDecimal getR47_no_of_accounts_non_uae_abu() {
		return r47_no_of_accounts_non_uae_abu;
	}
	public void setR47_no_of_accounts_non_uae_abu(BigDecimal r47_no_of_accounts_non_uae_abu) {
		this.r47_no_of_accounts_non_uae_abu = r47_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR47_amount_non_uae_abu() {
		return r47_amount_non_uae_abu;
	}
	public void setR47_amount_non_uae_abu(BigDecimal r47_amount_non_uae_abu) {
		this.r47_amount_non_uae_abu = r47_amount_non_uae_abu;
	}
	public BigDecimal getR47_total_abu() {
		return r47_total_abu;
	}
	public void setR47_total_abu(BigDecimal r47_total_abu) {
		this.r47_total_abu = r47_total_abu;
	}
	public BigDecimal getR47_no_of_accounts_uae_dubai() {
		return r47_no_of_accounts_uae_dubai;
	}
	public void setR47_no_of_accounts_uae_dubai(BigDecimal r47_no_of_accounts_uae_dubai) {
		this.r47_no_of_accounts_uae_dubai = r47_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR47_amount_uae_dubai() {
		return r47_amount_uae_dubai;
	}
	public void setR47_amount_uae_dubai(BigDecimal r47_amount_uae_dubai) {
		this.r47_amount_uae_dubai = r47_amount_uae_dubai;
	}
	public BigDecimal getR47_no_of_accounts_non_uae_dubai() {
		return r47_no_of_accounts_non_uae_dubai;
	}
	public void setR47_no_of_accounts_non_uae_dubai(BigDecimal r47_no_of_accounts_non_uae_dubai) {
		this.r47_no_of_accounts_non_uae_dubai = r47_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR47_amount_non_uae_dubai() {
		return r47_amount_non_uae_dubai;
	}
	public void setR47_amount_non_uae_dubai(BigDecimal r47_amount_non_uae_dubai) {
		this.r47_amount_non_uae_dubai = r47_amount_non_uae_dubai;
	}
	public BigDecimal getR47_total_dubai() {
		return r47_total_dubai;
	}
	public void setR47_total_dubai(BigDecimal r47_total_dubai) {
		this.r47_total_dubai = r47_total_dubai;
	}
	public BigDecimal getR47_no_of_accounts_uae_sharjah() {
		return r47_no_of_accounts_uae_sharjah;
	}
	public void setR47_no_of_accounts_uae_sharjah(BigDecimal r47_no_of_accounts_uae_sharjah) {
		this.r47_no_of_accounts_uae_sharjah = r47_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR47_amount_uae_sharjah() {
		return r47_amount_uae_sharjah;
	}
	public void setR47_amount_uae_sharjah(BigDecimal r47_amount_uae_sharjah) {
		this.r47_amount_uae_sharjah = r47_amount_uae_sharjah;
	}
	public BigDecimal getR47_no_of_accounts_non_uae_sharjah() {
		return r47_no_of_accounts_non_uae_sharjah;
	}
	public void setR47_no_of_accounts_non_uae_sharjah(BigDecimal r47_no_of_accounts_non_uae_sharjah) {
		this.r47_no_of_accounts_non_uae_sharjah = r47_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR47_amount_non_uae_sharjah() {
		return r47_amount_non_uae_sharjah;
	}
	public void setR47_amount_non_uae_sharjah(BigDecimal r47_amount_non_uae_sharjah) {
		this.r47_amount_non_uae_sharjah = r47_amount_non_uae_sharjah;
	}
	public BigDecimal getR47_total_sharjah() {
		return r47_total_sharjah;
	}
	public void setR47_total_sharjah(BigDecimal r47_total_sharjah) {
		this.r47_total_sharjah = r47_total_sharjah;
	}
	public BigDecimal getR47_no_of_accounts_uae_ajman() {
		return r47_no_of_accounts_uae_ajman;
	}
	public void setR47_no_of_accounts_uae_ajman(BigDecimal r47_no_of_accounts_uae_ajman) {
		this.r47_no_of_accounts_uae_ajman = r47_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR47_amount_uae_ajman() {
		return r47_amount_uae_ajman;
	}
	public void setR47_amount_uae_ajman(BigDecimal r47_amount_uae_ajman) {
		this.r47_amount_uae_ajman = r47_amount_uae_ajman;
	}
	public BigDecimal getR47_no_of_accounts_non_uae_ajman() {
		return r47_no_of_accounts_non_uae_ajman;
	}
	public void setR47_no_of_accounts_non_uae_ajman(BigDecimal r47_no_of_accounts_non_uae_ajman) {
		this.r47_no_of_accounts_non_uae_ajman = r47_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR47_amount_non_uae_ajman() {
		return r47_amount_non_uae_ajman;
	}
	public void setR47_amount_non_uae_ajman(BigDecimal r47_amount_non_uae_ajman) {
		this.r47_amount_non_uae_ajman = r47_amount_non_uae_ajman;
	}
	public BigDecimal getR47_total_ajman() {
		return r47_total_ajman;
	}
	public void setR47_total_ajman(BigDecimal r47_total_ajman) {
		this.r47_total_ajman = r47_total_ajman;
	}
	public BigDecimal getR47_no_of_accounts_uae_ras() {
		return r47_no_of_accounts_uae_ras;
	}
	public void setR47_no_of_accounts_uae_ras(BigDecimal r47_no_of_accounts_uae_ras) {
		this.r47_no_of_accounts_uae_ras = r47_no_of_accounts_uae_ras;
	}
	public BigDecimal getR47_amount_uae_ras() {
		return r47_amount_uae_ras;
	}
	public void setR47_amount_uae_ras(BigDecimal r47_amount_uae_ras) {
		this.r47_amount_uae_ras = r47_amount_uae_ras;
	}
	public BigDecimal getR47_no_of_accounts_non_uae_ras() {
		return r47_no_of_accounts_non_uae_ras;
	}
	public void setR47_no_of_accounts_non_uae_ras(BigDecimal r47_no_of_accounts_non_uae_ras) {
		this.r47_no_of_accounts_non_uae_ras = r47_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR47_amount_non_uae_ras() {
		return r47_amount_non_uae_ras;
	}
	public void setR47_amount_non_uae_ras(BigDecimal r47_amount_non_uae_ras) {
		this.r47_amount_non_uae_ras = r47_amount_non_uae_ras;
	}
	public BigDecimal getR47_total_ras() {
		return r47_total_ras;
	}
	public void setR47_total_ras(BigDecimal r47_total_ras) {
		this.r47_total_ras = r47_total_ras;
	}
	public BigDecimal getR47_no_of_accounts_uae_umm() {
		return r47_no_of_accounts_uae_umm;
	}
	public void setR47_no_of_accounts_uae_umm(BigDecimal r47_no_of_accounts_uae_umm) {
		this.r47_no_of_accounts_uae_umm = r47_no_of_accounts_uae_umm;
	}
	public BigDecimal getR47_amount_uae_umm() {
		return r47_amount_uae_umm;
	}
	public void setR47_amount_uae_umm(BigDecimal r47_amount_uae_umm) {
		this.r47_amount_uae_umm = r47_amount_uae_umm;
	}
	public BigDecimal getR47_no_of_accounts_non_uae_umm() {
		return r47_no_of_accounts_non_uae_umm;
	}
	public void setR47_no_of_accounts_non_uae_umm(BigDecimal r47_no_of_accounts_non_uae_umm) {
		this.r47_no_of_accounts_non_uae_umm = r47_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR47_amount_non_uae_umm() {
		return r47_amount_non_uae_umm;
	}
	public void setR47_amount_non_uae_umm(BigDecimal r47_amount_non_uae_umm) {
		this.r47_amount_non_uae_umm = r47_amount_non_uae_umm;
	}
	public BigDecimal getR47_total_umm() {
		return r47_total_umm;
	}
	public void setR47_total_umm(BigDecimal r47_total_umm) {
		this.r47_total_umm = r47_total_umm;
	}
	public BigDecimal getR47_no_of_accounts_uae_fujairah() {
		return r47_no_of_accounts_uae_fujairah;
	}
	public void setR47_no_of_accounts_uae_fujairah(BigDecimal r47_no_of_accounts_uae_fujairah) {
		this.r47_no_of_accounts_uae_fujairah = r47_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR47_amount_uae_fujairah() {
		return r47_amount_uae_fujairah;
	}
	public void setR47_amount_uae_fujairah(BigDecimal r47_amount_uae_fujairah) {
		this.r47_amount_uae_fujairah = r47_amount_uae_fujairah;
	}
	public BigDecimal getR47_no_of_accounts_non_uae_fujairah() {
		return r47_no_of_accounts_non_uae_fujairah;
	}
	public void setR47_no_of_accounts_non_uae_fujairah(BigDecimal r47_no_of_accounts_non_uae_fujairah) {
		this.r47_no_of_accounts_non_uae_fujairah = r47_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR47_amount_non_uae_fujairah() {
		return r47_amount_non_uae_fujairah;
	}
	public void setR47_amount_non_uae_fujairah(BigDecimal r47_amount_non_uae_fujairah) {
		this.r47_amount_non_uae_fujairah = r47_amount_non_uae_fujairah;
	}
	public BigDecimal getR47_total_fujairah() {
		return r47_total_fujairah;
	}
	public void setR47_total_fujairah(BigDecimal r47_total_fujairah) {
		this.r47_total_fujairah = r47_total_fujairah;
	}
	public String getR48_product() {
		return r48_product;
	}
	public void setR48_product(String r48_product) {
		this.r48_product = r48_product;
	}
	public BigDecimal getR48_no_of_accounts_uae() {
		return r48_no_of_accounts_uae;
	}
	public void setR48_no_of_accounts_uae(BigDecimal r48_no_of_accounts_uae) {
		this.r48_no_of_accounts_uae = r48_no_of_accounts_uae;
	}
	public BigDecimal getR48_amount_uae() {
		return r48_amount_uae;
	}
	public void setR48_amount_uae(BigDecimal r48_amount_uae) {
		this.r48_amount_uae = r48_amount_uae;
	}
	public BigDecimal getR48_no_of_accounts_resident() {
		return r48_no_of_accounts_resident;
	}
	public void setR48_no_of_accounts_resident(BigDecimal r48_no_of_accounts_resident) {
		this.r48_no_of_accounts_resident = r48_no_of_accounts_resident;
	}
	public BigDecimal getR48_amount_resident() {
		return r48_amount_resident;
	}
	public void setR48_amount_resident(BigDecimal r48_amount_resident) {
		this.r48_amount_resident = r48_amount_resident;
	}
	public BigDecimal getR48_no_of_accounts_non_resident() {
		return r48_no_of_accounts_non_resident;
	}
	public void setR48_no_of_accounts_non_resident(BigDecimal r48_no_of_accounts_non_resident) {
		this.r48_no_of_accounts_non_resident = r48_no_of_accounts_non_resident;
	}
	public BigDecimal getR48_amount_non_resident() {
		return r48_amount_non_resident;
	}
	public void setR48_amount_non_resident(BigDecimal r48_amount_non_resident) {
		this.r48_amount_non_resident = r48_amount_non_resident;
	}
	public BigDecimal getR48_total_account() {
		return r48_total_account;
	}
	public void setR48_total_account(BigDecimal r48_total_account) {
		this.r48_total_account = r48_total_account;
	}
	public BigDecimal getR48_total_amount() {
		return r48_total_amount;
	}
	public void setR48_total_amount(BigDecimal r48_total_amount) {
		this.r48_total_amount = r48_total_amount;
	}
	public BigDecimal getR48_no_of_accounts_uae_abu() {
		return r48_no_of_accounts_uae_abu;
	}
	public void setR48_no_of_accounts_uae_abu(BigDecimal r48_no_of_accounts_uae_abu) {
		this.r48_no_of_accounts_uae_abu = r48_no_of_accounts_uae_abu;
	}
	public BigDecimal getR48_amount_uae_abu() {
		return r48_amount_uae_abu;
	}
	public void setR48_amount_uae_abu(BigDecimal r48_amount_uae_abu) {
		this.r48_amount_uae_abu = r48_amount_uae_abu;
	}
	public BigDecimal getR48_no_of_accounts_non_uae_abu() {
		return r48_no_of_accounts_non_uae_abu;
	}
	public void setR48_no_of_accounts_non_uae_abu(BigDecimal r48_no_of_accounts_non_uae_abu) {
		this.r48_no_of_accounts_non_uae_abu = r48_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR48_amount_non_uae_abu() {
		return r48_amount_non_uae_abu;
	}
	public void setR48_amount_non_uae_abu(BigDecimal r48_amount_non_uae_abu) {
		this.r48_amount_non_uae_abu = r48_amount_non_uae_abu;
	}
	public BigDecimal getR48_total_abu() {
		return r48_total_abu;
	}
	public void setR48_total_abu(BigDecimal r48_total_abu) {
		this.r48_total_abu = r48_total_abu;
	}
	public BigDecimal getR48_no_of_accounts_uae_dubai() {
		return r48_no_of_accounts_uae_dubai;
	}
	public void setR48_no_of_accounts_uae_dubai(BigDecimal r48_no_of_accounts_uae_dubai) {
		this.r48_no_of_accounts_uae_dubai = r48_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR48_amount_uae_dubai() {
		return r48_amount_uae_dubai;
	}
	public void setR48_amount_uae_dubai(BigDecimal r48_amount_uae_dubai) {
		this.r48_amount_uae_dubai = r48_amount_uae_dubai;
	}
	public BigDecimal getR48_no_of_accounts_non_uae_dubai() {
		return r48_no_of_accounts_non_uae_dubai;
	}
	public void setR48_no_of_accounts_non_uae_dubai(BigDecimal r48_no_of_accounts_non_uae_dubai) {
		this.r48_no_of_accounts_non_uae_dubai = r48_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR48_amount_non_uae_dubai() {
		return r48_amount_non_uae_dubai;
	}
	public void setR48_amount_non_uae_dubai(BigDecimal r48_amount_non_uae_dubai) {
		this.r48_amount_non_uae_dubai = r48_amount_non_uae_dubai;
	}
	public BigDecimal getR48_total_dubai() {
		return r48_total_dubai;
	}
	public void setR48_total_dubai(BigDecimal r48_total_dubai) {
		this.r48_total_dubai = r48_total_dubai;
	}
	public BigDecimal getR48_no_of_accounts_uae_sharjah() {
		return r48_no_of_accounts_uae_sharjah;
	}
	public void setR48_no_of_accounts_uae_sharjah(BigDecimal r48_no_of_accounts_uae_sharjah) {
		this.r48_no_of_accounts_uae_sharjah = r48_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR48_amount_uae_sharjah() {
		return r48_amount_uae_sharjah;
	}
	public void setR48_amount_uae_sharjah(BigDecimal r48_amount_uae_sharjah) {
		this.r48_amount_uae_sharjah = r48_amount_uae_sharjah;
	}
	public BigDecimal getR48_no_of_accounts_non_uae_sharjah() {
		return r48_no_of_accounts_non_uae_sharjah;
	}
	public void setR48_no_of_accounts_non_uae_sharjah(BigDecimal r48_no_of_accounts_non_uae_sharjah) {
		this.r48_no_of_accounts_non_uae_sharjah = r48_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR48_amount_non_uae_sharjah() {
		return r48_amount_non_uae_sharjah;
	}
	public void setR48_amount_non_uae_sharjah(BigDecimal r48_amount_non_uae_sharjah) {
		this.r48_amount_non_uae_sharjah = r48_amount_non_uae_sharjah;
	}
	public BigDecimal getR48_total_sharjah() {
		return r48_total_sharjah;
	}
	public void setR48_total_sharjah(BigDecimal r48_total_sharjah) {
		this.r48_total_sharjah = r48_total_sharjah;
	}
	public BigDecimal getR48_no_of_accounts_uae_ajman() {
		return r48_no_of_accounts_uae_ajman;
	}
	public void setR48_no_of_accounts_uae_ajman(BigDecimal r48_no_of_accounts_uae_ajman) {
		this.r48_no_of_accounts_uae_ajman = r48_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR48_amount_uae_ajman() {
		return r48_amount_uae_ajman;
	}
	public void setR48_amount_uae_ajman(BigDecimal r48_amount_uae_ajman) {
		this.r48_amount_uae_ajman = r48_amount_uae_ajman;
	}
	public BigDecimal getR48_no_of_accounts_non_uae_ajman() {
		return r48_no_of_accounts_non_uae_ajman;
	}
	public void setR48_no_of_accounts_non_uae_ajman(BigDecimal r48_no_of_accounts_non_uae_ajman) {
		this.r48_no_of_accounts_non_uae_ajman = r48_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR48_amount_non_uae_ajman() {
		return r48_amount_non_uae_ajman;
	}
	public void setR48_amount_non_uae_ajman(BigDecimal r48_amount_non_uae_ajman) {
		this.r48_amount_non_uae_ajman = r48_amount_non_uae_ajman;
	}
	public BigDecimal getR48_total_ajman() {
		return r48_total_ajman;
	}
	public void setR48_total_ajman(BigDecimal r48_total_ajman) {
		this.r48_total_ajman = r48_total_ajman;
	}
	public BigDecimal getR48_no_of_accounts_uae_ras() {
		return r48_no_of_accounts_uae_ras;
	}
	public void setR48_no_of_accounts_uae_ras(BigDecimal r48_no_of_accounts_uae_ras) {
		this.r48_no_of_accounts_uae_ras = r48_no_of_accounts_uae_ras;
	}
	public BigDecimal getR48_amount_uae_ras() {
		return r48_amount_uae_ras;
	}
	public void setR48_amount_uae_ras(BigDecimal r48_amount_uae_ras) {
		this.r48_amount_uae_ras = r48_amount_uae_ras;
	}
	public BigDecimal getR48_no_of_accounts_non_uae_ras() {
		return r48_no_of_accounts_non_uae_ras;
	}
	public void setR48_no_of_accounts_non_uae_ras(BigDecimal r48_no_of_accounts_non_uae_ras) {
		this.r48_no_of_accounts_non_uae_ras = r48_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR48_amount_non_uae_ras() {
		return r48_amount_non_uae_ras;
	}
	public void setR48_amount_non_uae_ras(BigDecimal r48_amount_non_uae_ras) {
		this.r48_amount_non_uae_ras = r48_amount_non_uae_ras;
	}
	public BigDecimal getR48_total_ras() {
		return r48_total_ras;
	}
	public void setR48_total_ras(BigDecimal r48_total_ras) {
		this.r48_total_ras = r48_total_ras;
	}
	public BigDecimal getR48_no_of_accounts_uae_umm() {
		return r48_no_of_accounts_uae_umm;
	}
	public void setR48_no_of_accounts_uae_umm(BigDecimal r48_no_of_accounts_uae_umm) {
		this.r48_no_of_accounts_uae_umm = r48_no_of_accounts_uae_umm;
	}
	public BigDecimal getR48_amount_uae_umm() {
		return r48_amount_uae_umm;
	}
	public void setR48_amount_uae_umm(BigDecimal r48_amount_uae_umm) {
		this.r48_amount_uae_umm = r48_amount_uae_umm;
	}
	public BigDecimal getR48_no_of_accounts_non_uae_umm() {
		return r48_no_of_accounts_non_uae_umm;
	}
	public void setR48_no_of_accounts_non_uae_umm(BigDecimal r48_no_of_accounts_non_uae_umm) {
		this.r48_no_of_accounts_non_uae_umm = r48_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR48_amount_non_uae_umm() {
		return r48_amount_non_uae_umm;
	}
	public void setR48_amount_non_uae_umm(BigDecimal r48_amount_non_uae_umm) {
		this.r48_amount_non_uae_umm = r48_amount_non_uae_umm;
	}
	public BigDecimal getR48_total_umm() {
		return r48_total_umm;
	}
	public void setR48_total_umm(BigDecimal r48_total_umm) {
		this.r48_total_umm = r48_total_umm;
	}
	public BigDecimal getR48_no_of_accounts_uae_fujairah() {
		return r48_no_of_accounts_uae_fujairah;
	}
	public void setR48_no_of_accounts_uae_fujairah(BigDecimal r48_no_of_accounts_uae_fujairah) {
		this.r48_no_of_accounts_uae_fujairah = r48_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR48_amount_uae_fujairah() {
		return r48_amount_uae_fujairah;
	}
	public void setR48_amount_uae_fujairah(BigDecimal r48_amount_uae_fujairah) {
		this.r48_amount_uae_fujairah = r48_amount_uae_fujairah;
	}
	public BigDecimal getR48_no_of_accounts_non_uae_fujairah() {
		return r48_no_of_accounts_non_uae_fujairah;
	}
	public void setR48_no_of_accounts_non_uae_fujairah(BigDecimal r48_no_of_accounts_non_uae_fujairah) {
		this.r48_no_of_accounts_non_uae_fujairah = r48_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR48_amount_non_uae_fujairah() {
		return r48_amount_non_uae_fujairah;
	}
	public void setR48_amount_non_uae_fujairah(BigDecimal r48_amount_non_uae_fujairah) {
		this.r48_amount_non_uae_fujairah = r48_amount_non_uae_fujairah;
	}
	public BigDecimal getR48_total_fujairah() {
		return r48_total_fujairah;
	}
	public void setR48_total_fujairah(BigDecimal r48_total_fujairah) {
		this.r48_total_fujairah = r48_total_fujairah;
	}
	public String getR49_product() {
		return r49_product;
	}
	public void setR49_product(String r49_product) {
		this.r49_product = r49_product;
	}
	public BigDecimal getR49_no_of_accounts_uae() {
		return r49_no_of_accounts_uae;
	}
	public void setR49_no_of_accounts_uae(BigDecimal r49_no_of_accounts_uae) {
		this.r49_no_of_accounts_uae = r49_no_of_accounts_uae;
	}
	public BigDecimal getR49_amount_uae() {
		return r49_amount_uae;
	}
	public void setR49_amount_uae(BigDecimal r49_amount_uae) {
		this.r49_amount_uae = r49_amount_uae;
	}
	public BigDecimal getR49_no_of_accounts_resident() {
		return r49_no_of_accounts_resident;
	}
	public void setR49_no_of_accounts_resident(BigDecimal r49_no_of_accounts_resident) {
		this.r49_no_of_accounts_resident = r49_no_of_accounts_resident;
	}
	public BigDecimal getR49_amount_resident() {
		return r49_amount_resident;
	}
	public void setR49_amount_resident(BigDecimal r49_amount_resident) {
		this.r49_amount_resident = r49_amount_resident;
	}
	public BigDecimal getR49_no_of_accounts_non_resident() {
		return r49_no_of_accounts_non_resident;
	}
	public void setR49_no_of_accounts_non_resident(BigDecimal r49_no_of_accounts_non_resident) {
		this.r49_no_of_accounts_non_resident = r49_no_of_accounts_non_resident;
	}
	public BigDecimal getR49_amount_non_resident() {
		return r49_amount_non_resident;
	}
	public void setR49_amount_non_resident(BigDecimal r49_amount_non_resident) {
		this.r49_amount_non_resident = r49_amount_non_resident;
	}
	public BigDecimal getR49_total_account() {
		return r49_total_account;
	}
	public void setR49_total_account(BigDecimal r49_total_account) {
		this.r49_total_account = r49_total_account;
	}
	public BigDecimal getR49_total_amount() {
		return r49_total_amount;
	}
	public void setR49_total_amount(BigDecimal r49_total_amount) {
		this.r49_total_amount = r49_total_amount;
	}
	public BigDecimal getR49_no_of_accounts_uae_abu() {
		return r49_no_of_accounts_uae_abu;
	}
	public void setR49_no_of_accounts_uae_abu(BigDecimal r49_no_of_accounts_uae_abu) {
		this.r49_no_of_accounts_uae_abu = r49_no_of_accounts_uae_abu;
	}
	public BigDecimal getR49_amount_uae_abu() {
		return r49_amount_uae_abu;
	}
	public void setR49_amount_uae_abu(BigDecimal r49_amount_uae_abu) {
		this.r49_amount_uae_abu = r49_amount_uae_abu;
	}
	public BigDecimal getR49_no_of_accounts_non_uae_abu() {
		return r49_no_of_accounts_non_uae_abu;
	}
	public void setR49_no_of_accounts_non_uae_abu(BigDecimal r49_no_of_accounts_non_uae_abu) {
		this.r49_no_of_accounts_non_uae_abu = r49_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR49_amount_non_uae_abu() {
		return r49_amount_non_uae_abu;
	}
	public void setR49_amount_non_uae_abu(BigDecimal r49_amount_non_uae_abu) {
		this.r49_amount_non_uae_abu = r49_amount_non_uae_abu;
	}
	public BigDecimal getR49_total_abu() {
		return r49_total_abu;
	}
	public void setR49_total_abu(BigDecimal r49_total_abu) {
		this.r49_total_abu = r49_total_abu;
	}
	public BigDecimal getR49_no_of_accounts_uae_dubai() {
		return r49_no_of_accounts_uae_dubai;
	}
	public void setR49_no_of_accounts_uae_dubai(BigDecimal r49_no_of_accounts_uae_dubai) {
		this.r49_no_of_accounts_uae_dubai = r49_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR49_amount_uae_dubai() {
		return r49_amount_uae_dubai;
	}
	public void setR49_amount_uae_dubai(BigDecimal r49_amount_uae_dubai) {
		this.r49_amount_uae_dubai = r49_amount_uae_dubai;
	}
	public BigDecimal getR49_no_of_accounts_non_uae_dubai() {
		return r49_no_of_accounts_non_uae_dubai;
	}
	public void setR49_no_of_accounts_non_uae_dubai(BigDecimal r49_no_of_accounts_non_uae_dubai) {
		this.r49_no_of_accounts_non_uae_dubai = r49_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR49_amount_non_uae_dubai() {
		return r49_amount_non_uae_dubai;
	}
	public void setR49_amount_non_uae_dubai(BigDecimal r49_amount_non_uae_dubai) {
		this.r49_amount_non_uae_dubai = r49_amount_non_uae_dubai;
	}
	public BigDecimal getR49_total_dubai() {
		return r49_total_dubai;
	}
	public void setR49_total_dubai(BigDecimal r49_total_dubai) {
		this.r49_total_dubai = r49_total_dubai;
	}
	public BigDecimal getR49_no_of_accounts_uae_sharjah() {
		return r49_no_of_accounts_uae_sharjah;
	}
	public void setR49_no_of_accounts_uae_sharjah(BigDecimal r49_no_of_accounts_uae_sharjah) {
		this.r49_no_of_accounts_uae_sharjah = r49_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR49_amount_uae_sharjah() {
		return r49_amount_uae_sharjah;
	}
	public void setR49_amount_uae_sharjah(BigDecimal r49_amount_uae_sharjah) {
		this.r49_amount_uae_sharjah = r49_amount_uae_sharjah;
	}
	public BigDecimal getR49_no_of_accounts_non_uae_sharjah() {
		return r49_no_of_accounts_non_uae_sharjah;
	}
	public void setR49_no_of_accounts_non_uae_sharjah(BigDecimal r49_no_of_accounts_non_uae_sharjah) {
		this.r49_no_of_accounts_non_uae_sharjah = r49_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR49_amount_non_uae_sharjah() {
		return r49_amount_non_uae_sharjah;
	}
	public void setR49_amount_non_uae_sharjah(BigDecimal r49_amount_non_uae_sharjah) {
		this.r49_amount_non_uae_sharjah = r49_amount_non_uae_sharjah;
	}
	public BigDecimal getR49_total_sharjah() {
		return r49_total_sharjah;
	}
	public void setR49_total_sharjah(BigDecimal r49_total_sharjah) {
		this.r49_total_sharjah = r49_total_sharjah;
	}
	public BigDecimal getR49_no_of_accounts_uae_ajman() {
		return r49_no_of_accounts_uae_ajman;
	}
	public void setR49_no_of_accounts_uae_ajman(BigDecimal r49_no_of_accounts_uae_ajman) {
		this.r49_no_of_accounts_uae_ajman = r49_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR49_amount_uae_ajman() {
		return r49_amount_uae_ajman;
	}
	public void setR49_amount_uae_ajman(BigDecimal r49_amount_uae_ajman) {
		this.r49_amount_uae_ajman = r49_amount_uae_ajman;
	}
	public BigDecimal getR49_no_of_accounts_non_uae_ajman() {
		return r49_no_of_accounts_non_uae_ajman;
	}
	public void setR49_no_of_accounts_non_uae_ajman(BigDecimal r49_no_of_accounts_non_uae_ajman) {
		this.r49_no_of_accounts_non_uae_ajman = r49_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR49_amount_non_uae_ajman() {
		return r49_amount_non_uae_ajman;
	}
	public void setR49_amount_non_uae_ajman(BigDecimal r49_amount_non_uae_ajman) {
		this.r49_amount_non_uae_ajman = r49_amount_non_uae_ajman;
	}
	public BigDecimal getR49_total_ajman() {
		return r49_total_ajman;
	}
	public void setR49_total_ajman(BigDecimal r49_total_ajman) {
		this.r49_total_ajman = r49_total_ajman;
	}
	public BigDecimal getR49_no_of_accounts_uae_ras() {
		return r49_no_of_accounts_uae_ras;
	}
	public void setR49_no_of_accounts_uae_ras(BigDecimal r49_no_of_accounts_uae_ras) {
		this.r49_no_of_accounts_uae_ras = r49_no_of_accounts_uae_ras;
	}
	public BigDecimal getR49_amount_uae_ras() {
		return r49_amount_uae_ras;
	}
	public void setR49_amount_uae_ras(BigDecimal r49_amount_uae_ras) {
		this.r49_amount_uae_ras = r49_amount_uae_ras;
	}
	public BigDecimal getR49_no_of_accounts_non_uae_ras() {
		return r49_no_of_accounts_non_uae_ras;
	}
	public void setR49_no_of_accounts_non_uae_ras(BigDecimal r49_no_of_accounts_non_uae_ras) {
		this.r49_no_of_accounts_non_uae_ras = r49_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR49_amount_non_uae_ras() {
		return r49_amount_non_uae_ras;
	}
	public void setR49_amount_non_uae_ras(BigDecimal r49_amount_non_uae_ras) {
		this.r49_amount_non_uae_ras = r49_amount_non_uae_ras;
	}
	public BigDecimal getR49_total_ras() {
		return r49_total_ras;
	}
	public void setR49_total_ras(BigDecimal r49_total_ras) {
		this.r49_total_ras = r49_total_ras;
	}
	public BigDecimal getR49_no_of_accounts_uae_umm() {
		return r49_no_of_accounts_uae_umm;
	}
	public void setR49_no_of_accounts_uae_umm(BigDecimal r49_no_of_accounts_uae_umm) {
		this.r49_no_of_accounts_uae_umm = r49_no_of_accounts_uae_umm;
	}
	public BigDecimal getR49_amount_uae_umm() {
		return r49_amount_uae_umm;
	}
	public void setR49_amount_uae_umm(BigDecimal r49_amount_uae_umm) {
		this.r49_amount_uae_umm = r49_amount_uae_umm;
	}
	public BigDecimal getR49_no_of_accounts_non_uae_umm() {
		return r49_no_of_accounts_non_uae_umm;
	}
	public void setR49_no_of_accounts_non_uae_umm(BigDecimal r49_no_of_accounts_non_uae_umm) {
		this.r49_no_of_accounts_non_uae_umm = r49_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR49_amount_non_uae_umm() {
		return r49_amount_non_uae_umm;
	}
	public void setR49_amount_non_uae_umm(BigDecimal r49_amount_non_uae_umm) {
		this.r49_amount_non_uae_umm = r49_amount_non_uae_umm;
	}
	public BigDecimal getR49_total_umm() {
		return r49_total_umm;
	}
	public void setR49_total_umm(BigDecimal r49_total_umm) {
		this.r49_total_umm = r49_total_umm;
	}
	public BigDecimal getR49_no_of_accounts_uae_fujairah() {
		return r49_no_of_accounts_uae_fujairah;
	}
	public void setR49_no_of_accounts_uae_fujairah(BigDecimal r49_no_of_accounts_uae_fujairah) {
		this.r49_no_of_accounts_uae_fujairah = r49_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR49_amount_uae_fujairah() {
		return r49_amount_uae_fujairah;
	}
	public void setR49_amount_uae_fujairah(BigDecimal r49_amount_uae_fujairah) {
		this.r49_amount_uae_fujairah = r49_amount_uae_fujairah;
	}
	public BigDecimal getR49_no_of_accounts_non_uae_fujairah() {
		return r49_no_of_accounts_non_uae_fujairah;
	}
	public void setR49_no_of_accounts_non_uae_fujairah(BigDecimal r49_no_of_accounts_non_uae_fujairah) {
		this.r49_no_of_accounts_non_uae_fujairah = r49_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR49_amount_non_uae_fujairah() {
		return r49_amount_non_uae_fujairah;
	}
	public void setR49_amount_non_uae_fujairah(BigDecimal r49_amount_non_uae_fujairah) {
		this.r49_amount_non_uae_fujairah = r49_amount_non_uae_fujairah;
	}
	public BigDecimal getR49_total_fujairah() {
		return r49_total_fujairah;
	}
	public void setR49_total_fujairah(BigDecimal r49_total_fujairah) {
		this.r49_total_fujairah = r49_total_fujairah;
	}
	public String getR50_product() {
		return r50_product;
	}
	public void setR50_product(String r50_product) {
		this.r50_product = r50_product;
	}
	public BigDecimal getR50_no_of_accounts_uae() {
		return r50_no_of_accounts_uae;
	}
	public void setR50_no_of_accounts_uae(BigDecimal r50_no_of_accounts_uae) {
		this.r50_no_of_accounts_uae = r50_no_of_accounts_uae;
	}
	public BigDecimal getR50_amount_uae() {
		return r50_amount_uae;
	}
	public void setR50_amount_uae(BigDecimal r50_amount_uae) {
		this.r50_amount_uae = r50_amount_uae;
	}
	public BigDecimal getR50_no_of_accounts_resident() {
		return r50_no_of_accounts_resident;
	}
	public void setR50_no_of_accounts_resident(BigDecimal r50_no_of_accounts_resident) {
		this.r50_no_of_accounts_resident = r50_no_of_accounts_resident;
	}
	public BigDecimal getR50_amount_resident() {
		return r50_amount_resident;
	}
	public void setR50_amount_resident(BigDecimal r50_amount_resident) {
		this.r50_amount_resident = r50_amount_resident;
	}
	public BigDecimal getR50_no_of_accounts_non_resident() {
		return r50_no_of_accounts_non_resident;
	}
	public void setR50_no_of_accounts_non_resident(BigDecimal r50_no_of_accounts_non_resident) {
		this.r50_no_of_accounts_non_resident = r50_no_of_accounts_non_resident;
	}
	public BigDecimal getR50_amount_non_resident() {
		return r50_amount_non_resident;
	}
	public void setR50_amount_non_resident(BigDecimal r50_amount_non_resident) {
		this.r50_amount_non_resident = r50_amount_non_resident;
	}
	public BigDecimal getR50_total_account() {
		return r50_total_account;
	}
	public void setR50_total_account(BigDecimal r50_total_account) {
		this.r50_total_account = r50_total_account;
	}
	public BigDecimal getR50_total_amount() {
		return r50_total_amount;
	}
	public void setR50_total_amount(BigDecimal r50_total_amount) {
		this.r50_total_amount = r50_total_amount;
	}
	public BigDecimal getR50_no_of_accounts_uae_abu() {
		return r50_no_of_accounts_uae_abu;
	}
	public void setR50_no_of_accounts_uae_abu(BigDecimal r50_no_of_accounts_uae_abu) {
		this.r50_no_of_accounts_uae_abu = r50_no_of_accounts_uae_abu;
	}
	public BigDecimal getR50_amount_uae_abu() {
		return r50_amount_uae_abu;
	}
	public void setR50_amount_uae_abu(BigDecimal r50_amount_uae_abu) {
		this.r50_amount_uae_abu = r50_amount_uae_abu;
	}
	public BigDecimal getR50_no_of_accounts_non_uae_abu() {
		return r50_no_of_accounts_non_uae_abu;
	}
	public void setR50_no_of_accounts_non_uae_abu(BigDecimal r50_no_of_accounts_non_uae_abu) {
		this.r50_no_of_accounts_non_uae_abu = r50_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR50_amount_non_uae_abu() {
		return r50_amount_non_uae_abu;
	}
	public void setR50_amount_non_uae_abu(BigDecimal r50_amount_non_uae_abu) {
		this.r50_amount_non_uae_abu = r50_amount_non_uae_abu;
	}
	public BigDecimal getR50_total_abu() {
		return r50_total_abu;
	}
	public void setR50_total_abu(BigDecimal r50_total_abu) {
		this.r50_total_abu = r50_total_abu;
	}
	public BigDecimal getR50_no_of_accounts_uae_dubai() {
		return r50_no_of_accounts_uae_dubai;
	}
	public void setR50_no_of_accounts_uae_dubai(BigDecimal r50_no_of_accounts_uae_dubai) {
		this.r50_no_of_accounts_uae_dubai = r50_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR50_amount_uae_dubai() {
		return r50_amount_uae_dubai;
	}
	public void setR50_amount_uae_dubai(BigDecimal r50_amount_uae_dubai) {
		this.r50_amount_uae_dubai = r50_amount_uae_dubai;
	}
	public BigDecimal getR50_no_of_accounts_non_uae_dubai() {
		return r50_no_of_accounts_non_uae_dubai;
	}
	public void setR50_no_of_accounts_non_uae_dubai(BigDecimal r50_no_of_accounts_non_uae_dubai) {
		this.r50_no_of_accounts_non_uae_dubai = r50_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR50_amount_non_uae_dubai() {
		return r50_amount_non_uae_dubai;
	}
	public void setR50_amount_non_uae_dubai(BigDecimal r50_amount_non_uae_dubai) {
		this.r50_amount_non_uae_dubai = r50_amount_non_uae_dubai;
	}
	public BigDecimal getR50_total_dubai() {
		return r50_total_dubai;
	}
	public void setR50_total_dubai(BigDecimal r50_total_dubai) {
		this.r50_total_dubai = r50_total_dubai;
	}
	public BigDecimal getR50_no_of_accounts_uae_sharjah() {
		return r50_no_of_accounts_uae_sharjah;
	}
	public void setR50_no_of_accounts_uae_sharjah(BigDecimal r50_no_of_accounts_uae_sharjah) {
		this.r50_no_of_accounts_uae_sharjah = r50_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR50_amount_uae_sharjah() {
		return r50_amount_uae_sharjah;
	}
	public void setR50_amount_uae_sharjah(BigDecimal r50_amount_uae_sharjah) {
		this.r50_amount_uae_sharjah = r50_amount_uae_sharjah;
	}
	public BigDecimal getR50_no_of_accounts_non_uae_sharjah() {
		return r50_no_of_accounts_non_uae_sharjah;
	}
	public void setR50_no_of_accounts_non_uae_sharjah(BigDecimal r50_no_of_accounts_non_uae_sharjah) {
		this.r50_no_of_accounts_non_uae_sharjah = r50_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR50_amount_non_uae_sharjah() {
		return r50_amount_non_uae_sharjah;
	}
	public void setR50_amount_non_uae_sharjah(BigDecimal r50_amount_non_uae_sharjah) {
		this.r50_amount_non_uae_sharjah = r50_amount_non_uae_sharjah;
	}
	public BigDecimal getR50_total_sharjah() {
		return r50_total_sharjah;
	}
	public void setR50_total_sharjah(BigDecimal r50_total_sharjah) {
		this.r50_total_sharjah = r50_total_sharjah;
	}
	public BigDecimal getR50_no_of_accounts_uae_ajman() {
		return r50_no_of_accounts_uae_ajman;
	}
	public void setR50_no_of_accounts_uae_ajman(BigDecimal r50_no_of_accounts_uae_ajman) {
		this.r50_no_of_accounts_uae_ajman = r50_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR50_amount_uae_ajman() {
		return r50_amount_uae_ajman;
	}
	public void setR50_amount_uae_ajman(BigDecimal r50_amount_uae_ajman) {
		this.r50_amount_uae_ajman = r50_amount_uae_ajman;
	}
	public BigDecimal getR50_no_of_accounts_non_uae_ajman() {
		return r50_no_of_accounts_non_uae_ajman;
	}
	public void setR50_no_of_accounts_non_uae_ajman(BigDecimal r50_no_of_accounts_non_uae_ajman) {
		this.r50_no_of_accounts_non_uae_ajman = r50_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR50_amount_non_uae_ajman() {
		return r50_amount_non_uae_ajman;
	}
	public void setR50_amount_non_uae_ajman(BigDecimal r50_amount_non_uae_ajman) {
		this.r50_amount_non_uae_ajman = r50_amount_non_uae_ajman;
	}
	public BigDecimal getR50_total_ajman() {
		return r50_total_ajman;
	}
	public void setR50_total_ajman(BigDecimal r50_total_ajman) {
		this.r50_total_ajman = r50_total_ajman;
	}
	public BigDecimal getR50_no_of_accounts_uae_ras() {
		return r50_no_of_accounts_uae_ras;
	}
	public void setR50_no_of_accounts_uae_ras(BigDecimal r50_no_of_accounts_uae_ras) {
		this.r50_no_of_accounts_uae_ras = r50_no_of_accounts_uae_ras;
	}
	public BigDecimal getR50_amount_uae_ras() {
		return r50_amount_uae_ras;
	}
	public void setR50_amount_uae_ras(BigDecimal r50_amount_uae_ras) {
		this.r50_amount_uae_ras = r50_amount_uae_ras;
	}
	public BigDecimal getR50_no_of_accounts_non_uae_ras() {
		return r50_no_of_accounts_non_uae_ras;
	}
	public void setR50_no_of_accounts_non_uae_ras(BigDecimal r50_no_of_accounts_non_uae_ras) {
		this.r50_no_of_accounts_non_uae_ras = r50_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR50_amount_non_uae_ras() {
		return r50_amount_non_uae_ras;
	}
	public void setR50_amount_non_uae_ras(BigDecimal r50_amount_non_uae_ras) {
		this.r50_amount_non_uae_ras = r50_amount_non_uae_ras;
	}
	public BigDecimal getR50_total_ras() {
		return r50_total_ras;
	}
	public void setR50_total_ras(BigDecimal r50_total_ras) {
		this.r50_total_ras = r50_total_ras;
	}
	public BigDecimal getR50_no_of_accounts_uae_umm() {
		return r50_no_of_accounts_uae_umm;
	}
	public void setR50_no_of_accounts_uae_umm(BigDecimal r50_no_of_accounts_uae_umm) {
		this.r50_no_of_accounts_uae_umm = r50_no_of_accounts_uae_umm;
	}
	public BigDecimal getR50_amount_uae_umm() {
		return r50_amount_uae_umm;
	}
	public void setR50_amount_uae_umm(BigDecimal r50_amount_uae_umm) {
		this.r50_amount_uae_umm = r50_amount_uae_umm;
	}
	public BigDecimal getR50_no_of_accounts_non_uae_umm() {
		return r50_no_of_accounts_non_uae_umm;
	}
	public void setR50_no_of_accounts_non_uae_umm(BigDecimal r50_no_of_accounts_non_uae_umm) {
		this.r50_no_of_accounts_non_uae_umm = r50_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR50_amount_non_uae_umm() {
		return r50_amount_non_uae_umm;
	}
	public void setR50_amount_non_uae_umm(BigDecimal r50_amount_non_uae_umm) {
		this.r50_amount_non_uae_umm = r50_amount_non_uae_umm;
	}
	public BigDecimal getR50_total_umm() {
		return r50_total_umm;
	}
	public void setR50_total_umm(BigDecimal r50_total_umm) {
		this.r50_total_umm = r50_total_umm;
	}
	public BigDecimal getR50_no_of_accounts_uae_fujairah() {
		return r50_no_of_accounts_uae_fujairah;
	}
	public void setR50_no_of_accounts_uae_fujairah(BigDecimal r50_no_of_accounts_uae_fujairah) {
		this.r50_no_of_accounts_uae_fujairah = r50_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR50_amount_uae_fujairah() {
		return r50_amount_uae_fujairah;
	}
	public void setR50_amount_uae_fujairah(BigDecimal r50_amount_uae_fujairah) {
		this.r50_amount_uae_fujairah = r50_amount_uae_fujairah;
	}
	public BigDecimal getR50_no_of_accounts_non_uae_fujairah() {
		return r50_no_of_accounts_non_uae_fujairah;
	}
	public void setR50_no_of_accounts_non_uae_fujairah(BigDecimal r50_no_of_accounts_non_uae_fujairah) {
		this.r50_no_of_accounts_non_uae_fujairah = r50_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR50_amount_non_uae_fujairah() {
		return r50_amount_non_uae_fujairah;
	}
	public void setR50_amount_non_uae_fujairah(BigDecimal r50_amount_non_uae_fujairah) {
		this.r50_amount_non_uae_fujairah = r50_amount_non_uae_fujairah;
	}
	public BigDecimal getR50_total_fujairah() {
		return r50_total_fujairah;
	}
	public void setR50_total_fujairah(BigDecimal r50_total_fujairah) {
		this.r50_total_fujairah = r50_total_fujairah;
	}
	public String getR51_product() {
		return r51_product;
	}
	public void setR51_product(String r51_product) {
		this.r51_product = r51_product;
	}
	public BigDecimal getR51_no_of_accounts_uae() {
		return r51_no_of_accounts_uae;
	}
	public void setR51_no_of_accounts_uae(BigDecimal r51_no_of_accounts_uae) {
		this.r51_no_of_accounts_uae = r51_no_of_accounts_uae;
	}
	public BigDecimal getR51_amount_uae() {
		return r51_amount_uae;
	}
	public void setR51_amount_uae(BigDecimal r51_amount_uae) {
		this.r51_amount_uae = r51_amount_uae;
	}
	public BigDecimal getR51_no_of_accounts_resident() {
		return r51_no_of_accounts_resident;
	}
	public void setR51_no_of_accounts_resident(BigDecimal r51_no_of_accounts_resident) {
		this.r51_no_of_accounts_resident = r51_no_of_accounts_resident;
	}
	public BigDecimal getR51_amount_resident() {
		return r51_amount_resident;
	}
	public void setR51_amount_resident(BigDecimal r51_amount_resident) {
		this.r51_amount_resident = r51_amount_resident;
	}
	public BigDecimal getR51_no_of_accounts_non_resident() {
		return r51_no_of_accounts_non_resident;
	}
	public void setR51_no_of_accounts_non_resident(BigDecimal r51_no_of_accounts_non_resident) {
		this.r51_no_of_accounts_non_resident = r51_no_of_accounts_non_resident;
	}
	public BigDecimal getR51_amount_non_resident() {
		return r51_amount_non_resident;
	}
	public void setR51_amount_non_resident(BigDecimal r51_amount_non_resident) {
		this.r51_amount_non_resident = r51_amount_non_resident;
	}
	public BigDecimal getR51_total_account() {
		return r51_total_account;
	}
	public void setR51_total_account(BigDecimal r51_total_account) {
		this.r51_total_account = r51_total_account;
	}
	public BigDecimal getR51_total_amount() {
		return r51_total_amount;
	}
	public void setR51_total_amount(BigDecimal r51_total_amount) {
		this.r51_total_amount = r51_total_amount;
	}
	public BigDecimal getR51_no_of_accounts_uae_abu() {
		return r51_no_of_accounts_uae_abu;
	}
	public void setR51_no_of_accounts_uae_abu(BigDecimal r51_no_of_accounts_uae_abu) {
		this.r51_no_of_accounts_uae_abu = r51_no_of_accounts_uae_abu;
	}
	public BigDecimal getR51_amount_uae_abu() {
		return r51_amount_uae_abu;
	}
	public void setR51_amount_uae_abu(BigDecimal r51_amount_uae_abu) {
		this.r51_amount_uae_abu = r51_amount_uae_abu;
	}
	public BigDecimal getR51_no_of_accounts_non_uae_abu() {
		return r51_no_of_accounts_non_uae_abu;
	}
	public void setR51_no_of_accounts_non_uae_abu(BigDecimal r51_no_of_accounts_non_uae_abu) {
		this.r51_no_of_accounts_non_uae_abu = r51_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR51_amount_non_uae_abu() {
		return r51_amount_non_uae_abu;
	}
	public void setR51_amount_non_uae_abu(BigDecimal r51_amount_non_uae_abu) {
		this.r51_amount_non_uae_abu = r51_amount_non_uae_abu;
	}
	public BigDecimal getR51_total_abu() {
		return r51_total_abu;
	}
	public void setR51_total_abu(BigDecimal r51_total_abu) {
		this.r51_total_abu = r51_total_abu;
	}
	public BigDecimal getR51_no_of_accounts_uae_dubai() {
		return r51_no_of_accounts_uae_dubai;
	}
	public void setR51_no_of_accounts_uae_dubai(BigDecimal r51_no_of_accounts_uae_dubai) {
		this.r51_no_of_accounts_uae_dubai = r51_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR51_amount_uae_dubai() {
		return r51_amount_uae_dubai;
	}
	public void setR51_amount_uae_dubai(BigDecimal r51_amount_uae_dubai) {
		this.r51_amount_uae_dubai = r51_amount_uae_dubai;
	}
	public BigDecimal getR51_no_of_accounts_non_uae_dubai() {
		return r51_no_of_accounts_non_uae_dubai;
	}
	public void setR51_no_of_accounts_non_uae_dubai(BigDecimal r51_no_of_accounts_non_uae_dubai) {
		this.r51_no_of_accounts_non_uae_dubai = r51_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR51_amount_non_uae_dubai() {
		return r51_amount_non_uae_dubai;
	}
	public void setR51_amount_non_uae_dubai(BigDecimal r51_amount_non_uae_dubai) {
		this.r51_amount_non_uae_dubai = r51_amount_non_uae_dubai;
	}
	public BigDecimal getR51_total_dubai() {
		return r51_total_dubai;
	}
	public void setR51_total_dubai(BigDecimal r51_total_dubai) {
		this.r51_total_dubai = r51_total_dubai;
	}
	public BigDecimal getR51_no_of_accounts_uae_sharjah() {
		return r51_no_of_accounts_uae_sharjah;
	}
	public void setR51_no_of_accounts_uae_sharjah(BigDecimal r51_no_of_accounts_uae_sharjah) {
		this.r51_no_of_accounts_uae_sharjah = r51_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR51_amount_uae_sharjah() {
		return r51_amount_uae_sharjah;
	}
	public void setR51_amount_uae_sharjah(BigDecimal r51_amount_uae_sharjah) {
		this.r51_amount_uae_sharjah = r51_amount_uae_sharjah;
	}
	public BigDecimal getR51_no_of_accounts_non_uae_sharjah() {
		return r51_no_of_accounts_non_uae_sharjah;
	}
	public void setR51_no_of_accounts_non_uae_sharjah(BigDecimal r51_no_of_accounts_non_uae_sharjah) {
		this.r51_no_of_accounts_non_uae_sharjah = r51_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR51_amount_non_uae_sharjah() {
		return r51_amount_non_uae_sharjah;
	}
	public void setR51_amount_non_uae_sharjah(BigDecimal r51_amount_non_uae_sharjah) {
		this.r51_amount_non_uae_sharjah = r51_amount_non_uae_sharjah;
	}
	public BigDecimal getR51_total_sharjah() {
		return r51_total_sharjah;
	}
	public void setR51_total_sharjah(BigDecimal r51_total_sharjah) {
		this.r51_total_sharjah = r51_total_sharjah;
	}
	public BigDecimal getR51_no_of_accounts_uae_ajman() {
		return r51_no_of_accounts_uae_ajman;
	}
	public void setR51_no_of_accounts_uae_ajman(BigDecimal r51_no_of_accounts_uae_ajman) {
		this.r51_no_of_accounts_uae_ajman = r51_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR51_amount_uae_ajman() {
		return r51_amount_uae_ajman;
	}
	public void setR51_amount_uae_ajman(BigDecimal r51_amount_uae_ajman) {
		this.r51_amount_uae_ajman = r51_amount_uae_ajman;
	}
	public BigDecimal getR51_no_of_accounts_non_uae_ajman() {
		return r51_no_of_accounts_non_uae_ajman;
	}
	public void setR51_no_of_accounts_non_uae_ajman(BigDecimal r51_no_of_accounts_non_uae_ajman) {
		this.r51_no_of_accounts_non_uae_ajman = r51_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR51_amount_non_uae_ajman() {
		return r51_amount_non_uae_ajman;
	}
	public void setR51_amount_non_uae_ajman(BigDecimal r51_amount_non_uae_ajman) {
		this.r51_amount_non_uae_ajman = r51_amount_non_uae_ajman;
	}
	public BigDecimal getR51_total_ajman() {
		return r51_total_ajman;
	}
	public void setR51_total_ajman(BigDecimal r51_total_ajman) {
		this.r51_total_ajman = r51_total_ajman;
	}
	public BigDecimal getR51_no_of_accounts_uae_ras() {
		return r51_no_of_accounts_uae_ras;
	}
	public void setR51_no_of_accounts_uae_ras(BigDecimal r51_no_of_accounts_uae_ras) {
		this.r51_no_of_accounts_uae_ras = r51_no_of_accounts_uae_ras;
	}
	public BigDecimal getR51_amount_uae_ras() {
		return r51_amount_uae_ras;
	}
	public void setR51_amount_uae_ras(BigDecimal r51_amount_uae_ras) {
		this.r51_amount_uae_ras = r51_amount_uae_ras;
	}
	public BigDecimal getR51_no_of_accounts_non_uae_ras() {
		return r51_no_of_accounts_non_uae_ras;
	}
	public void setR51_no_of_accounts_non_uae_ras(BigDecimal r51_no_of_accounts_non_uae_ras) {
		this.r51_no_of_accounts_non_uae_ras = r51_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR51_amount_non_uae_ras() {
		return r51_amount_non_uae_ras;
	}
	public void setR51_amount_non_uae_ras(BigDecimal r51_amount_non_uae_ras) {
		this.r51_amount_non_uae_ras = r51_amount_non_uae_ras;
	}
	public BigDecimal getR51_total_ras() {
		return r51_total_ras;
	}
	public void setR51_total_ras(BigDecimal r51_total_ras) {
		this.r51_total_ras = r51_total_ras;
	}
	public BigDecimal getR51_no_of_accounts_uae_umm() {
		return r51_no_of_accounts_uae_umm;
	}
	public void setR51_no_of_accounts_uae_umm(BigDecimal r51_no_of_accounts_uae_umm) {
		this.r51_no_of_accounts_uae_umm = r51_no_of_accounts_uae_umm;
	}
	public BigDecimal getR51_amount_uae_umm() {
		return r51_amount_uae_umm;
	}
	public void setR51_amount_uae_umm(BigDecimal r51_amount_uae_umm) {
		this.r51_amount_uae_umm = r51_amount_uae_umm;
	}
	public BigDecimal getR51_no_of_accounts_non_uae_umm() {
		return r51_no_of_accounts_non_uae_umm;
	}
	public void setR51_no_of_accounts_non_uae_umm(BigDecimal r51_no_of_accounts_non_uae_umm) {
		this.r51_no_of_accounts_non_uae_umm = r51_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR51_amount_non_uae_umm() {
		return r51_amount_non_uae_umm;
	}
	public void setR51_amount_non_uae_umm(BigDecimal r51_amount_non_uae_umm) {
		this.r51_amount_non_uae_umm = r51_amount_non_uae_umm;
	}
	public BigDecimal getR51_total_umm() {
		return r51_total_umm;
	}
	public void setR51_total_umm(BigDecimal r51_total_umm) {
		this.r51_total_umm = r51_total_umm;
	}
	public BigDecimal getR51_no_of_accounts_uae_fujairah() {
		return r51_no_of_accounts_uae_fujairah;
	}
	public void setR51_no_of_accounts_uae_fujairah(BigDecimal r51_no_of_accounts_uae_fujairah) {
		this.r51_no_of_accounts_uae_fujairah = r51_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR51_amount_uae_fujairah() {
		return r51_amount_uae_fujairah;
	}
	public void setR51_amount_uae_fujairah(BigDecimal r51_amount_uae_fujairah) {
		this.r51_amount_uae_fujairah = r51_amount_uae_fujairah;
	}
	public BigDecimal getR51_no_of_accounts_non_uae_fujairah() {
		return r51_no_of_accounts_non_uae_fujairah;
	}
	public void setR51_no_of_accounts_non_uae_fujairah(BigDecimal r51_no_of_accounts_non_uae_fujairah) {
		this.r51_no_of_accounts_non_uae_fujairah = r51_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR51_amount_non_uae_fujairah() {
		return r51_amount_non_uae_fujairah;
	}
	public void setR51_amount_non_uae_fujairah(BigDecimal r51_amount_non_uae_fujairah) {
		this.r51_amount_non_uae_fujairah = r51_amount_non_uae_fujairah;
	}
	public BigDecimal getR51_total_fujairah() {
		return r51_total_fujairah;
	}
	public void setR51_total_fujairah(BigDecimal r51_total_fujairah) {
		this.r51_total_fujairah = r51_total_fujairah;
	}
	public String getR52_product() {
		return r52_product;
	}
	public void setR52_product(String r52_product) {
		this.r52_product = r52_product;
	}
	public BigDecimal getR52_no_of_accounts_uae() {
		return r52_no_of_accounts_uae;
	}
	public void setR52_no_of_accounts_uae(BigDecimal r52_no_of_accounts_uae) {
		this.r52_no_of_accounts_uae = r52_no_of_accounts_uae;
	}
	public BigDecimal getR52_amount_uae() {
		return r52_amount_uae;
	}
	public void setR52_amount_uae(BigDecimal r52_amount_uae) {
		this.r52_amount_uae = r52_amount_uae;
	}
	public BigDecimal getR52_no_of_accounts_resident() {
		return r52_no_of_accounts_resident;
	}
	public void setR52_no_of_accounts_resident(BigDecimal r52_no_of_accounts_resident) {
		this.r52_no_of_accounts_resident = r52_no_of_accounts_resident;
	}
	public BigDecimal getR52_amount_resident() {
		return r52_amount_resident;
	}
	public void setR52_amount_resident(BigDecimal r52_amount_resident) {
		this.r52_amount_resident = r52_amount_resident;
	}
	public BigDecimal getR52_no_of_accounts_non_resident() {
		return r52_no_of_accounts_non_resident;
	}
	public void setR52_no_of_accounts_non_resident(BigDecimal r52_no_of_accounts_non_resident) {
		this.r52_no_of_accounts_non_resident = r52_no_of_accounts_non_resident;
	}
	public BigDecimal getR52_amount_non_resident() {
		return r52_amount_non_resident;
	}
	public void setR52_amount_non_resident(BigDecimal r52_amount_non_resident) {
		this.r52_amount_non_resident = r52_amount_non_resident;
	}
	public BigDecimal getR52_total_account() {
		return r52_total_account;
	}
	public void setR52_total_account(BigDecimal r52_total_account) {
		this.r52_total_account = r52_total_account;
	}
	public BigDecimal getR52_total_amount() {
		return r52_total_amount;
	}
	public void setR52_total_amount(BigDecimal r52_total_amount) {
		this.r52_total_amount = r52_total_amount;
	}
	public BigDecimal getR52_no_of_accounts_uae_abu() {
		return r52_no_of_accounts_uae_abu;
	}
	public void setR52_no_of_accounts_uae_abu(BigDecimal r52_no_of_accounts_uae_abu) {
		this.r52_no_of_accounts_uae_abu = r52_no_of_accounts_uae_abu;
	}
	public BigDecimal getR52_amount_uae_abu() {
		return r52_amount_uae_abu;
	}
	public void setR52_amount_uae_abu(BigDecimal r52_amount_uae_abu) {
		this.r52_amount_uae_abu = r52_amount_uae_abu;
	}
	public BigDecimal getR52_no_of_accounts_non_uae_abu() {
		return r52_no_of_accounts_non_uae_abu;
	}
	public void setR52_no_of_accounts_non_uae_abu(BigDecimal r52_no_of_accounts_non_uae_abu) {
		this.r52_no_of_accounts_non_uae_abu = r52_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR52_amount_non_uae_abu() {
		return r52_amount_non_uae_abu;
	}
	public void setR52_amount_non_uae_abu(BigDecimal r52_amount_non_uae_abu) {
		this.r52_amount_non_uae_abu = r52_amount_non_uae_abu;
	}
	public BigDecimal getR52_total_abu() {
		return r52_total_abu;
	}
	public void setR52_total_abu(BigDecimal r52_total_abu) {
		this.r52_total_abu = r52_total_abu;
	}
	public BigDecimal getR52_no_of_accounts_uae_dubai() {
		return r52_no_of_accounts_uae_dubai;
	}
	public void setR52_no_of_accounts_uae_dubai(BigDecimal r52_no_of_accounts_uae_dubai) {
		this.r52_no_of_accounts_uae_dubai = r52_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR52_amount_uae_dubai() {
		return r52_amount_uae_dubai;
	}
	public void setR52_amount_uae_dubai(BigDecimal r52_amount_uae_dubai) {
		this.r52_amount_uae_dubai = r52_amount_uae_dubai;
	}
	public BigDecimal getR52_no_of_accounts_non_uae_dubai() {
		return r52_no_of_accounts_non_uae_dubai;
	}
	public void setR52_no_of_accounts_non_uae_dubai(BigDecimal r52_no_of_accounts_non_uae_dubai) {
		this.r52_no_of_accounts_non_uae_dubai = r52_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR52_amount_non_uae_dubai() {
		return r52_amount_non_uae_dubai;
	}
	public void setR52_amount_non_uae_dubai(BigDecimal r52_amount_non_uae_dubai) {
		this.r52_amount_non_uae_dubai = r52_amount_non_uae_dubai;
	}
	public BigDecimal getR52_total_dubai() {
		return r52_total_dubai;
	}
	public void setR52_total_dubai(BigDecimal r52_total_dubai) {
		this.r52_total_dubai = r52_total_dubai;
	}
	public BigDecimal getR52_no_of_accounts_uae_sharjah() {
		return r52_no_of_accounts_uae_sharjah;
	}
	public void setR52_no_of_accounts_uae_sharjah(BigDecimal r52_no_of_accounts_uae_sharjah) {
		this.r52_no_of_accounts_uae_sharjah = r52_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR52_amount_uae_sharjah() {
		return r52_amount_uae_sharjah;
	}
	public void setR52_amount_uae_sharjah(BigDecimal r52_amount_uae_sharjah) {
		this.r52_amount_uae_sharjah = r52_amount_uae_sharjah;
	}
	public BigDecimal getR52_no_of_accounts_non_uae_sharjah() {
		return r52_no_of_accounts_non_uae_sharjah;
	}
	public void setR52_no_of_accounts_non_uae_sharjah(BigDecimal r52_no_of_accounts_non_uae_sharjah) {
		this.r52_no_of_accounts_non_uae_sharjah = r52_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR52_amount_non_uae_sharjah() {
		return r52_amount_non_uae_sharjah;
	}
	public void setR52_amount_non_uae_sharjah(BigDecimal r52_amount_non_uae_sharjah) {
		this.r52_amount_non_uae_sharjah = r52_amount_non_uae_sharjah;
	}
	public BigDecimal getR52_total_sharjah() {
		return r52_total_sharjah;
	}
	public void setR52_total_sharjah(BigDecimal r52_total_sharjah) {
		this.r52_total_sharjah = r52_total_sharjah;
	}
	public BigDecimal getR52_no_of_accounts_uae_ajman() {
		return r52_no_of_accounts_uae_ajman;
	}
	public void setR52_no_of_accounts_uae_ajman(BigDecimal r52_no_of_accounts_uae_ajman) {
		this.r52_no_of_accounts_uae_ajman = r52_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR52_amount_uae_ajman() {
		return r52_amount_uae_ajman;
	}
	public void setR52_amount_uae_ajman(BigDecimal r52_amount_uae_ajman) {
		this.r52_amount_uae_ajman = r52_amount_uae_ajman;
	}
	public BigDecimal getR52_no_of_accounts_non_uae_ajman() {
		return r52_no_of_accounts_non_uae_ajman;
	}
	public void setR52_no_of_accounts_non_uae_ajman(BigDecimal r52_no_of_accounts_non_uae_ajman) {
		this.r52_no_of_accounts_non_uae_ajman = r52_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR52_amount_non_uae_ajman() {
		return r52_amount_non_uae_ajman;
	}
	public void setR52_amount_non_uae_ajman(BigDecimal r52_amount_non_uae_ajman) {
		this.r52_amount_non_uae_ajman = r52_amount_non_uae_ajman;
	}
	public BigDecimal getR52_total_ajman() {
		return r52_total_ajman;
	}
	public void setR52_total_ajman(BigDecimal r52_total_ajman) {
		this.r52_total_ajman = r52_total_ajman;
	}
	public BigDecimal getR52_no_of_accounts_uae_ras() {
		return r52_no_of_accounts_uae_ras;
	}
	public void setR52_no_of_accounts_uae_ras(BigDecimal r52_no_of_accounts_uae_ras) {
		this.r52_no_of_accounts_uae_ras = r52_no_of_accounts_uae_ras;
	}
	public BigDecimal getR52_amount_uae_ras() {
		return r52_amount_uae_ras;
	}
	public void setR52_amount_uae_ras(BigDecimal r52_amount_uae_ras) {
		this.r52_amount_uae_ras = r52_amount_uae_ras;
	}
	public BigDecimal getR52_no_of_accounts_non_uae_ras() {
		return r52_no_of_accounts_non_uae_ras;
	}
	public void setR52_no_of_accounts_non_uae_ras(BigDecimal r52_no_of_accounts_non_uae_ras) {
		this.r52_no_of_accounts_non_uae_ras = r52_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR52_amount_non_uae_ras() {
		return r52_amount_non_uae_ras;
	}
	public void setR52_amount_non_uae_ras(BigDecimal r52_amount_non_uae_ras) {
		this.r52_amount_non_uae_ras = r52_amount_non_uae_ras;
	}
	public BigDecimal getR52_total_ras() {
		return r52_total_ras;
	}
	public void setR52_total_ras(BigDecimal r52_total_ras) {
		this.r52_total_ras = r52_total_ras;
	}
	public BigDecimal getR52_no_of_accounts_uae_umm() {
		return r52_no_of_accounts_uae_umm;
	}
	public void setR52_no_of_accounts_uae_umm(BigDecimal r52_no_of_accounts_uae_umm) {
		this.r52_no_of_accounts_uae_umm = r52_no_of_accounts_uae_umm;
	}
	public BigDecimal getR52_amount_uae_umm() {
		return r52_amount_uae_umm;
	}
	public void setR52_amount_uae_umm(BigDecimal r52_amount_uae_umm) {
		this.r52_amount_uae_umm = r52_amount_uae_umm;
	}
	public BigDecimal getR52_no_of_accounts_non_uae_umm() {
		return r52_no_of_accounts_non_uae_umm;
	}
	public void setR52_no_of_accounts_non_uae_umm(BigDecimal r52_no_of_accounts_non_uae_umm) {
		this.r52_no_of_accounts_non_uae_umm = r52_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR52_amount_non_uae_umm() {
		return r52_amount_non_uae_umm;
	}
	public void setR52_amount_non_uae_umm(BigDecimal r52_amount_non_uae_umm) {
		this.r52_amount_non_uae_umm = r52_amount_non_uae_umm;
	}
	public BigDecimal getR52_total_umm() {
		return r52_total_umm;
	}
	public void setR52_total_umm(BigDecimal r52_total_umm) {
		this.r52_total_umm = r52_total_umm;
	}
	public BigDecimal getR52_no_of_accounts_uae_fujairah() {
		return r52_no_of_accounts_uae_fujairah;
	}
	public void setR52_no_of_accounts_uae_fujairah(BigDecimal r52_no_of_accounts_uae_fujairah) {
		this.r52_no_of_accounts_uae_fujairah = r52_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR52_amount_uae_fujairah() {
		return r52_amount_uae_fujairah;
	}
	public void setR52_amount_uae_fujairah(BigDecimal r52_amount_uae_fujairah) {
		this.r52_amount_uae_fujairah = r52_amount_uae_fujairah;
	}
	public BigDecimal getR52_no_of_accounts_non_uae_fujairah() {
		return r52_no_of_accounts_non_uae_fujairah;
	}
	public void setR52_no_of_accounts_non_uae_fujairah(BigDecimal r52_no_of_accounts_non_uae_fujairah) {
		this.r52_no_of_accounts_non_uae_fujairah = r52_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR52_amount_non_uae_fujairah() {
		return r52_amount_non_uae_fujairah;
	}
	public void setR52_amount_non_uae_fujairah(BigDecimal r52_amount_non_uae_fujairah) {
		this.r52_amount_non_uae_fujairah = r52_amount_non_uae_fujairah;
	}
	public BigDecimal getR52_total_fujairah() {
		return r52_total_fujairah;
	}
	public void setR52_total_fujairah(BigDecimal r52_total_fujairah) {
		this.r52_total_fujairah = r52_total_fujairah;
	}
	public String getR53_product() {
		return r53_product;
	}
	public void setR53_product(String r53_product) {
		this.r53_product = r53_product;
	}
	public BigDecimal getR53_no_of_accounts_uae() {
		return r53_no_of_accounts_uae;
	}
	public void setR53_no_of_accounts_uae(BigDecimal r53_no_of_accounts_uae) {
		this.r53_no_of_accounts_uae = r53_no_of_accounts_uae;
	}
	public BigDecimal getR53_amount_uae() {
		return r53_amount_uae;
	}
	public void setR53_amount_uae(BigDecimal r53_amount_uae) {
		this.r53_amount_uae = r53_amount_uae;
	}
	public BigDecimal getR53_no_of_accounts_resident() {
		return r53_no_of_accounts_resident;
	}
	public void setR53_no_of_accounts_resident(BigDecimal r53_no_of_accounts_resident) {
		this.r53_no_of_accounts_resident = r53_no_of_accounts_resident;
	}
	public BigDecimal getR53_amount_resident() {
		return r53_amount_resident;
	}
	public void setR53_amount_resident(BigDecimal r53_amount_resident) {
		this.r53_amount_resident = r53_amount_resident;
	}
	public BigDecimal getR53_no_of_accounts_non_resident() {
		return r53_no_of_accounts_non_resident;
	}
	public void setR53_no_of_accounts_non_resident(BigDecimal r53_no_of_accounts_non_resident) {
		this.r53_no_of_accounts_non_resident = r53_no_of_accounts_non_resident;
	}
	public BigDecimal getR53_amount_non_resident() {
		return r53_amount_non_resident;
	}
	public void setR53_amount_non_resident(BigDecimal r53_amount_non_resident) {
		this.r53_amount_non_resident = r53_amount_non_resident;
	}
	public BigDecimal getR53_total_account() {
		return r53_total_account;
	}
	public void setR53_total_account(BigDecimal r53_total_account) {
		this.r53_total_account = r53_total_account;
	}
	public BigDecimal getR53_total_amount() {
		return r53_total_amount;
	}
	public void setR53_total_amount(BigDecimal r53_total_amount) {
		this.r53_total_amount = r53_total_amount;
	}
	public BigDecimal getR53_no_of_accounts_uae_abu() {
		return r53_no_of_accounts_uae_abu;
	}
	public void setR53_no_of_accounts_uae_abu(BigDecimal r53_no_of_accounts_uae_abu) {
		this.r53_no_of_accounts_uae_abu = r53_no_of_accounts_uae_abu;
	}
	public BigDecimal getR53_amount_uae_abu() {
		return r53_amount_uae_abu;
	}
	public void setR53_amount_uae_abu(BigDecimal r53_amount_uae_abu) {
		this.r53_amount_uae_abu = r53_amount_uae_abu;
	}
	public BigDecimal getR53_no_of_accounts_non_uae_abu() {
		return r53_no_of_accounts_non_uae_abu;
	}
	public void setR53_no_of_accounts_non_uae_abu(BigDecimal r53_no_of_accounts_non_uae_abu) {
		this.r53_no_of_accounts_non_uae_abu = r53_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR53_amount_non_uae_abu() {
		return r53_amount_non_uae_abu;
	}
	public void setR53_amount_non_uae_abu(BigDecimal r53_amount_non_uae_abu) {
		this.r53_amount_non_uae_abu = r53_amount_non_uae_abu;
	}
	public BigDecimal getR53_total_abu() {
		return r53_total_abu;
	}
	public void setR53_total_abu(BigDecimal r53_total_abu) {
		this.r53_total_abu = r53_total_abu;
	}
	public BigDecimal getR53_no_of_accounts_uae_dubai() {
		return r53_no_of_accounts_uae_dubai;
	}
	public void setR53_no_of_accounts_uae_dubai(BigDecimal r53_no_of_accounts_uae_dubai) {
		this.r53_no_of_accounts_uae_dubai = r53_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR53_amount_uae_dubai() {
		return r53_amount_uae_dubai;
	}
	public void setR53_amount_uae_dubai(BigDecimal r53_amount_uae_dubai) {
		this.r53_amount_uae_dubai = r53_amount_uae_dubai;
	}
	public BigDecimal getR53_no_of_accounts_non_uae_dubai() {
		return r53_no_of_accounts_non_uae_dubai;
	}
	public void setR53_no_of_accounts_non_uae_dubai(BigDecimal r53_no_of_accounts_non_uae_dubai) {
		this.r53_no_of_accounts_non_uae_dubai = r53_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR53_amount_non_uae_dubai() {
		return r53_amount_non_uae_dubai;
	}
	public void setR53_amount_non_uae_dubai(BigDecimal r53_amount_non_uae_dubai) {
		this.r53_amount_non_uae_dubai = r53_amount_non_uae_dubai;
	}
	public BigDecimal getR53_total_dubai() {
		return r53_total_dubai;
	}
	public void setR53_total_dubai(BigDecimal r53_total_dubai) {
		this.r53_total_dubai = r53_total_dubai;
	}
	public BigDecimal getR53_no_of_accounts_uae_sharjah() {
		return r53_no_of_accounts_uae_sharjah;
	}
	public void setR53_no_of_accounts_uae_sharjah(BigDecimal r53_no_of_accounts_uae_sharjah) {
		this.r53_no_of_accounts_uae_sharjah = r53_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR53_amount_uae_sharjah() {
		return r53_amount_uae_sharjah;
	}
	public void setR53_amount_uae_sharjah(BigDecimal r53_amount_uae_sharjah) {
		this.r53_amount_uae_sharjah = r53_amount_uae_sharjah;
	}
	public BigDecimal getR53_no_of_accounts_non_uae_sharjah() {
		return r53_no_of_accounts_non_uae_sharjah;
	}
	public void setR53_no_of_accounts_non_uae_sharjah(BigDecimal r53_no_of_accounts_non_uae_sharjah) {
		this.r53_no_of_accounts_non_uae_sharjah = r53_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR53_amount_non_uae_sharjah() {
		return r53_amount_non_uae_sharjah;
	}
	public void setR53_amount_non_uae_sharjah(BigDecimal r53_amount_non_uae_sharjah) {
		this.r53_amount_non_uae_sharjah = r53_amount_non_uae_sharjah;
	}
	public BigDecimal getR53_total_sharjah() {
		return r53_total_sharjah;
	}
	public void setR53_total_sharjah(BigDecimal r53_total_sharjah) {
		this.r53_total_sharjah = r53_total_sharjah;
	}
	public BigDecimal getR53_no_of_accounts_uae_ajman() {
		return r53_no_of_accounts_uae_ajman;
	}
	public void setR53_no_of_accounts_uae_ajman(BigDecimal r53_no_of_accounts_uae_ajman) {
		this.r53_no_of_accounts_uae_ajman = r53_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR53_amount_uae_ajman() {
		return r53_amount_uae_ajman;
	}
	public void setR53_amount_uae_ajman(BigDecimal r53_amount_uae_ajman) {
		this.r53_amount_uae_ajman = r53_amount_uae_ajman;
	}
	public BigDecimal getR53_no_of_accounts_non_uae_ajman() {
		return r53_no_of_accounts_non_uae_ajman;
	}
	public void setR53_no_of_accounts_non_uae_ajman(BigDecimal r53_no_of_accounts_non_uae_ajman) {
		this.r53_no_of_accounts_non_uae_ajman = r53_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR53_amount_non_uae_ajman() {
		return r53_amount_non_uae_ajman;
	}
	public void setR53_amount_non_uae_ajman(BigDecimal r53_amount_non_uae_ajman) {
		this.r53_amount_non_uae_ajman = r53_amount_non_uae_ajman;
	}
	public BigDecimal getR53_total_ajman() {
		return r53_total_ajman;
	}
	public void setR53_total_ajman(BigDecimal r53_total_ajman) {
		this.r53_total_ajman = r53_total_ajman;
	}
	public BigDecimal getR53_no_of_accounts_uae_ras() {
		return r53_no_of_accounts_uae_ras;
	}
	public void setR53_no_of_accounts_uae_ras(BigDecimal r53_no_of_accounts_uae_ras) {
		this.r53_no_of_accounts_uae_ras = r53_no_of_accounts_uae_ras;
	}
	public BigDecimal getR53_amount_uae_ras() {
		return r53_amount_uae_ras;
	}
	public void setR53_amount_uae_ras(BigDecimal r53_amount_uae_ras) {
		this.r53_amount_uae_ras = r53_amount_uae_ras;
	}
	public BigDecimal getR53_no_of_accounts_non_uae_ras() {
		return r53_no_of_accounts_non_uae_ras;
	}
	public void setR53_no_of_accounts_non_uae_ras(BigDecimal r53_no_of_accounts_non_uae_ras) {
		this.r53_no_of_accounts_non_uae_ras = r53_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR53_amount_non_uae_ras() {
		return r53_amount_non_uae_ras;
	}
	public void setR53_amount_non_uae_ras(BigDecimal r53_amount_non_uae_ras) {
		this.r53_amount_non_uae_ras = r53_amount_non_uae_ras;
	}
	public BigDecimal getR53_total_ras() {
		return r53_total_ras;
	}
	public void setR53_total_ras(BigDecimal r53_total_ras) {
		this.r53_total_ras = r53_total_ras;
	}
	public BigDecimal getR53_no_of_accounts_uae_umm() {
		return r53_no_of_accounts_uae_umm;
	}
	public void setR53_no_of_accounts_uae_umm(BigDecimal r53_no_of_accounts_uae_umm) {
		this.r53_no_of_accounts_uae_umm = r53_no_of_accounts_uae_umm;
	}
	public BigDecimal getR53_amount_uae_umm() {
		return r53_amount_uae_umm;
	}
	public void setR53_amount_uae_umm(BigDecimal r53_amount_uae_umm) {
		this.r53_amount_uae_umm = r53_amount_uae_umm;
	}
	public BigDecimal getR53_no_of_accounts_non_uae_umm() {
		return r53_no_of_accounts_non_uae_umm;
	}
	public void setR53_no_of_accounts_non_uae_umm(BigDecimal r53_no_of_accounts_non_uae_umm) {
		this.r53_no_of_accounts_non_uae_umm = r53_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR53_amount_non_uae_umm() {
		return r53_amount_non_uae_umm;
	}
	public void setR53_amount_non_uae_umm(BigDecimal r53_amount_non_uae_umm) {
		this.r53_amount_non_uae_umm = r53_amount_non_uae_umm;
	}
	public BigDecimal getR53_total_umm() {
		return r53_total_umm;
	}
	public void setR53_total_umm(BigDecimal r53_total_umm) {
		this.r53_total_umm = r53_total_umm;
	}
	public BigDecimal getR53_no_of_accounts_uae_fujairah() {
		return r53_no_of_accounts_uae_fujairah;
	}
	public void setR53_no_of_accounts_uae_fujairah(BigDecimal r53_no_of_accounts_uae_fujairah) {
		this.r53_no_of_accounts_uae_fujairah = r53_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR53_amount_uae_fujairah() {
		return r53_amount_uae_fujairah;
	}
	public void setR53_amount_uae_fujairah(BigDecimal r53_amount_uae_fujairah) {
		this.r53_amount_uae_fujairah = r53_amount_uae_fujairah;
	}
	public BigDecimal getR53_no_of_accounts_non_uae_fujairah() {
		return r53_no_of_accounts_non_uae_fujairah;
	}
	public void setR53_no_of_accounts_non_uae_fujairah(BigDecimal r53_no_of_accounts_non_uae_fujairah) {
		this.r53_no_of_accounts_non_uae_fujairah = r53_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR53_amount_non_uae_fujairah() {
		return r53_amount_non_uae_fujairah;
	}
	public void setR53_amount_non_uae_fujairah(BigDecimal r53_amount_non_uae_fujairah) {
		this.r53_amount_non_uae_fujairah = r53_amount_non_uae_fujairah;
	}
	public BigDecimal getR53_total_fujairah() {
		return r53_total_fujairah;
	}
	public void setR53_total_fujairah(BigDecimal r53_total_fujairah) {
		this.r53_total_fujairah = r53_total_fujairah;
	}
	public String getR54_product() {
		return r54_product;
	}
	public void setR54_product(String r54_product) {
		this.r54_product = r54_product;
	}
	public BigDecimal getR54_no_of_accounts_uae() {
		return r54_no_of_accounts_uae;
	}
	public void setR54_no_of_accounts_uae(BigDecimal r54_no_of_accounts_uae) {
		this.r54_no_of_accounts_uae = r54_no_of_accounts_uae;
	}
	public BigDecimal getR54_amount_uae() {
		return r54_amount_uae;
	}
	public void setR54_amount_uae(BigDecimal r54_amount_uae) {
		this.r54_amount_uae = r54_amount_uae;
	}
	public BigDecimal getR54_no_of_accounts_resident() {
		return r54_no_of_accounts_resident;
	}
	public void setR54_no_of_accounts_resident(BigDecimal r54_no_of_accounts_resident) {
		this.r54_no_of_accounts_resident = r54_no_of_accounts_resident;
	}
	public BigDecimal getR54_amount_resident() {
		return r54_amount_resident;
	}
	public void setR54_amount_resident(BigDecimal r54_amount_resident) {
		this.r54_amount_resident = r54_amount_resident;
	}
	public BigDecimal getR54_no_of_accounts_non_resident() {
		return r54_no_of_accounts_non_resident;
	}
	public void setR54_no_of_accounts_non_resident(BigDecimal r54_no_of_accounts_non_resident) {
		this.r54_no_of_accounts_non_resident = r54_no_of_accounts_non_resident;
	}
	public BigDecimal getR54_amount_non_resident() {
		return r54_amount_non_resident;
	}
	public void setR54_amount_non_resident(BigDecimal r54_amount_non_resident) {
		this.r54_amount_non_resident = r54_amount_non_resident;
	}
	public BigDecimal getR54_total_account() {
		return r54_total_account;
	}
	public void setR54_total_account(BigDecimal r54_total_account) {
		this.r54_total_account = r54_total_account;
	}
	public BigDecimal getR54_total_amount() {
		return r54_total_amount;
	}
	public void setR54_total_amount(BigDecimal r54_total_amount) {
		this.r54_total_amount = r54_total_amount;
	}
	public BigDecimal getR54_no_of_accounts_uae_abu() {
		return r54_no_of_accounts_uae_abu;
	}
	public void setR54_no_of_accounts_uae_abu(BigDecimal r54_no_of_accounts_uae_abu) {
		this.r54_no_of_accounts_uae_abu = r54_no_of_accounts_uae_abu;
	}
	public BigDecimal getR54_amount_uae_abu() {
		return r54_amount_uae_abu;
	}
	public void setR54_amount_uae_abu(BigDecimal r54_amount_uae_abu) {
		this.r54_amount_uae_abu = r54_amount_uae_abu;
	}
	public BigDecimal getR54_no_of_accounts_non_uae_abu() {
		return r54_no_of_accounts_non_uae_abu;
	}
	public void setR54_no_of_accounts_non_uae_abu(BigDecimal r54_no_of_accounts_non_uae_abu) {
		this.r54_no_of_accounts_non_uae_abu = r54_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR54_amount_non_uae_abu() {
		return r54_amount_non_uae_abu;
	}
	public void setR54_amount_non_uae_abu(BigDecimal r54_amount_non_uae_abu) {
		this.r54_amount_non_uae_abu = r54_amount_non_uae_abu;
	}
	public BigDecimal getR54_total_abu() {
		return r54_total_abu;
	}
	public void setR54_total_abu(BigDecimal r54_total_abu) {
		this.r54_total_abu = r54_total_abu;
	}
	public BigDecimal getR54_no_of_accounts_uae_dubai() {
		return r54_no_of_accounts_uae_dubai;
	}
	public void setR54_no_of_accounts_uae_dubai(BigDecimal r54_no_of_accounts_uae_dubai) {
		this.r54_no_of_accounts_uae_dubai = r54_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR54_amount_uae_dubai() {
		return r54_amount_uae_dubai;
	}
	public void setR54_amount_uae_dubai(BigDecimal r54_amount_uae_dubai) {
		this.r54_amount_uae_dubai = r54_amount_uae_dubai;
	}
	public BigDecimal getR54_no_of_accounts_non_uae_dubai() {
		return r54_no_of_accounts_non_uae_dubai;
	}
	public void setR54_no_of_accounts_non_uae_dubai(BigDecimal r54_no_of_accounts_non_uae_dubai) {
		this.r54_no_of_accounts_non_uae_dubai = r54_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR54_amount_non_uae_dubai() {
		return r54_amount_non_uae_dubai;
	}
	public void setR54_amount_non_uae_dubai(BigDecimal r54_amount_non_uae_dubai) {
		this.r54_amount_non_uae_dubai = r54_amount_non_uae_dubai;
	}
	public BigDecimal getR54_total_dubai() {
		return r54_total_dubai;
	}
	public void setR54_total_dubai(BigDecimal r54_total_dubai) {
		this.r54_total_dubai = r54_total_dubai;
	}
	public BigDecimal getR54_no_of_accounts_uae_sharjah() {
		return r54_no_of_accounts_uae_sharjah;
	}
	public void setR54_no_of_accounts_uae_sharjah(BigDecimal r54_no_of_accounts_uae_sharjah) {
		this.r54_no_of_accounts_uae_sharjah = r54_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR54_amount_uae_sharjah() {
		return r54_amount_uae_sharjah;
	}
	public void setR54_amount_uae_sharjah(BigDecimal r54_amount_uae_sharjah) {
		this.r54_amount_uae_sharjah = r54_amount_uae_sharjah;
	}
	public BigDecimal getR54_no_of_accounts_non_uae_sharjah() {
		return r54_no_of_accounts_non_uae_sharjah;
	}
	public void setR54_no_of_accounts_non_uae_sharjah(BigDecimal r54_no_of_accounts_non_uae_sharjah) {
		this.r54_no_of_accounts_non_uae_sharjah = r54_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR54_amount_non_uae_sharjah() {
		return r54_amount_non_uae_sharjah;
	}
	public void setR54_amount_non_uae_sharjah(BigDecimal r54_amount_non_uae_sharjah) {
		this.r54_amount_non_uae_sharjah = r54_amount_non_uae_sharjah;
	}
	public BigDecimal getR54_total_sharjah() {
		return r54_total_sharjah;
	}
	public void setR54_total_sharjah(BigDecimal r54_total_sharjah) {
		this.r54_total_sharjah = r54_total_sharjah;
	}
	public BigDecimal getR54_no_of_accounts_uae_ajman() {
		return r54_no_of_accounts_uae_ajman;
	}
	public void setR54_no_of_accounts_uae_ajman(BigDecimal r54_no_of_accounts_uae_ajman) {
		this.r54_no_of_accounts_uae_ajman = r54_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR54_amount_uae_ajman() {
		return r54_amount_uae_ajman;
	}
	public void setR54_amount_uae_ajman(BigDecimal r54_amount_uae_ajman) {
		this.r54_amount_uae_ajman = r54_amount_uae_ajman;
	}
	public BigDecimal getR54_no_of_accounts_non_uae_ajman() {
		return r54_no_of_accounts_non_uae_ajman;
	}
	public void setR54_no_of_accounts_non_uae_ajman(BigDecimal r54_no_of_accounts_non_uae_ajman) {
		this.r54_no_of_accounts_non_uae_ajman = r54_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR54_amount_non_uae_ajman() {
		return r54_amount_non_uae_ajman;
	}
	public void setR54_amount_non_uae_ajman(BigDecimal r54_amount_non_uae_ajman) {
		this.r54_amount_non_uae_ajman = r54_amount_non_uae_ajman;
	}
	public BigDecimal getR54_total_ajman() {
		return r54_total_ajman;
	}
	public void setR54_total_ajman(BigDecimal r54_total_ajman) {
		this.r54_total_ajman = r54_total_ajman;
	}
	public BigDecimal getR54_no_of_accounts_uae_ras() {
		return r54_no_of_accounts_uae_ras;
	}
	public void setR54_no_of_accounts_uae_ras(BigDecimal r54_no_of_accounts_uae_ras) {
		this.r54_no_of_accounts_uae_ras = r54_no_of_accounts_uae_ras;
	}
	public BigDecimal getR54_amount_uae_ras() {
		return r54_amount_uae_ras;
	}
	public void setR54_amount_uae_ras(BigDecimal r54_amount_uae_ras) {
		this.r54_amount_uae_ras = r54_amount_uae_ras;
	}
	public BigDecimal getR54_no_of_accounts_non_uae_ras() {
		return r54_no_of_accounts_non_uae_ras;
	}
	public void setR54_no_of_accounts_non_uae_ras(BigDecimal r54_no_of_accounts_non_uae_ras) {
		this.r54_no_of_accounts_non_uae_ras = r54_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR54_amount_non_uae_ras() {
		return r54_amount_non_uae_ras;
	}
	public void setR54_amount_non_uae_ras(BigDecimal r54_amount_non_uae_ras) {
		this.r54_amount_non_uae_ras = r54_amount_non_uae_ras;
	}
	public BigDecimal getR54_total_ras() {
		return r54_total_ras;
	}
	public void setR54_total_ras(BigDecimal r54_total_ras) {
		this.r54_total_ras = r54_total_ras;
	}
	public BigDecimal getR54_no_of_accounts_uae_umm() {
		return r54_no_of_accounts_uae_umm;
	}
	public void setR54_no_of_accounts_uae_umm(BigDecimal r54_no_of_accounts_uae_umm) {
		this.r54_no_of_accounts_uae_umm = r54_no_of_accounts_uae_umm;
	}
	public BigDecimal getR54_amount_uae_umm() {
		return r54_amount_uae_umm;
	}
	public void setR54_amount_uae_umm(BigDecimal r54_amount_uae_umm) {
		this.r54_amount_uae_umm = r54_amount_uae_umm;
	}
	public BigDecimal getR54_no_of_accounts_non_uae_umm() {
		return r54_no_of_accounts_non_uae_umm;
	}
	public void setR54_no_of_accounts_non_uae_umm(BigDecimal r54_no_of_accounts_non_uae_umm) {
		this.r54_no_of_accounts_non_uae_umm = r54_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR54_amount_non_uae_umm() {
		return r54_amount_non_uae_umm;
	}
	public void setR54_amount_non_uae_umm(BigDecimal r54_amount_non_uae_umm) {
		this.r54_amount_non_uae_umm = r54_amount_non_uae_umm;
	}
	public BigDecimal getR54_total_umm() {
		return r54_total_umm;
	}
	public void setR54_total_umm(BigDecimal r54_total_umm) {
		this.r54_total_umm = r54_total_umm;
	}
	public BigDecimal getR54_no_of_accounts_uae_fujairah() {
		return r54_no_of_accounts_uae_fujairah;
	}
	public void setR54_no_of_accounts_uae_fujairah(BigDecimal r54_no_of_accounts_uae_fujairah) {
		this.r54_no_of_accounts_uae_fujairah = r54_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR54_amount_uae_fujairah() {
		return r54_amount_uae_fujairah;
	}
	public void setR54_amount_uae_fujairah(BigDecimal r54_amount_uae_fujairah) {
		this.r54_amount_uae_fujairah = r54_amount_uae_fujairah;
	}
	public BigDecimal getR54_no_of_accounts_non_uae_fujairah() {
		return r54_no_of_accounts_non_uae_fujairah;
	}
	public void setR54_no_of_accounts_non_uae_fujairah(BigDecimal r54_no_of_accounts_non_uae_fujairah) {
		this.r54_no_of_accounts_non_uae_fujairah = r54_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR54_amount_non_uae_fujairah() {
		return r54_amount_non_uae_fujairah;
	}
	public void setR54_amount_non_uae_fujairah(BigDecimal r54_amount_non_uae_fujairah) {
		this.r54_amount_non_uae_fujairah = r54_amount_non_uae_fujairah;
	}
	public BigDecimal getR54_total_fujairah() {
		return r54_total_fujairah;
	}
	public void setR54_total_fujairah(BigDecimal r54_total_fujairah) {
		this.r54_total_fujairah = r54_total_fujairah;
	}
	public String getR55_product() {
		return r55_product;
	}
	public void setR55_product(String r55_product) {
		this.r55_product = r55_product;
	}
	public BigDecimal getR55_no_of_accounts_uae() {
		return r55_no_of_accounts_uae;
	}
	public void setR55_no_of_accounts_uae(BigDecimal r55_no_of_accounts_uae) {
		this.r55_no_of_accounts_uae = r55_no_of_accounts_uae;
	}
	public BigDecimal getR55_amount_uae() {
		return r55_amount_uae;
	}
	public void setR55_amount_uae(BigDecimal r55_amount_uae) {
		this.r55_amount_uae = r55_amount_uae;
	}
	public BigDecimal getR55_no_of_accounts_resident() {
		return r55_no_of_accounts_resident;
	}
	public void setR55_no_of_accounts_resident(BigDecimal r55_no_of_accounts_resident) {
		this.r55_no_of_accounts_resident = r55_no_of_accounts_resident;
	}
	public BigDecimal getR55_amount_resident() {
		return r55_amount_resident;
	}
	public void setR55_amount_resident(BigDecimal r55_amount_resident) {
		this.r55_amount_resident = r55_amount_resident;
	}
	public BigDecimal getR55_no_of_accounts_non_resident() {
		return r55_no_of_accounts_non_resident;
	}
	public void setR55_no_of_accounts_non_resident(BigDecimal r55_no_of_accounts_non_resident) {
		this.r55_no_of_accounts_non_resident = r55_no_of_accounts_non_resident;
	}
	public BigDecimal getR55_amount_non_resident() {
		return r55_amount_non_resident;
	}
	public void setR55_amount_non_resident(BigDecimal r55_amount_non_resident) {
		this.r55_amount_non_resident = r55_amount_non_resident;
	}
	public BigDecimal getR55_total_account() {
		return r55_total_account;
	}
	public void setR55_total_account(BigDecimal r55_total_account) {
		this.r55_total_account = r55_total_account;
	}
	public BigDecimal getR55_total_amount() {
		return r55_total_amount;
	}
	public void setR55_total_amount(BigDecimal r55_total_amount) {
		this.r55_total_amount = r55_total_amount;
	}
	public BigDecimal getR55_no_of_accounts_uae_abu() {
		return r55_no_of_accounts_uae_abu;
	}
	public void setR55_no_of_accounts_uae_abu(BigDecimal r55_no_of_accounts_uae_abu) {
		this.r55_no_of_accounts_uae_abu = r55_no_of_accounts_uae_abu;
	}
	public BigDecimal getR55_amount_uae_abu() {
		return r55_amount_uae_abu;
	}
	public void setR55_amount_uae_abu(BigDecimal r55_amount_uae_abu) {
		this.r55_amount_uae_abu = r55_amount_uae_abu;
	}
	public BigDecimal getR55_no_of_accounts_non_uae_abu() {
		return r55_no_of_accounts_non_uae_abu;
	}
	public void setR55_no_of_accounts_non_uae_abu(BigDecimal r55_no_of_accounts_non_uae_abu) {
		this.r55_no_of_accounts_non_uae_abu = r55_no_of_accounts_non_uae_abu;
	}
	public BigDecimal getR55_amount_non_uae_abu() {
		return r55_amount_non_uae_abu;
	}
	public void setR55_amount_non_uae_abu(BigDecimal r55_amount_non_uae_abu) {
		this.r55_amount_non_uae_abu = r55_amount_non_uae_abu;
	}
	public BigDecimal getR55_total_abu() {
		return r55_total_abu;
	}
	public void setR55_total_abu(BigDecimal r55_total_abu) {
		this.r55_total_abu = r55_total_abu;
	}
	public BigDecimal getR55_no_of_accounts_uae_dubai() {
		return r55_no_of_accounts_uae_dubai;
	}
	public void setR55_no_of_accounts_uae_dubai(BigDecimal r55_no_of_accounts_uae_dubai) {
		this.r55_no_of_accounts_uae_dubai = r55_no_of_accounts_uae_dubai;
	}
	public BigDecimal getR55_amount_uae_dubai() {
		return r55_amount_uae_dubai;
	}
	public void setR55_amount_uae_dubai(BigDecimal r55_amount_uae_dubai) {
		this.r55_amount_uae_dubai = r55_amount_uae_dubai;
	}
	public BigDecimal getR55_no_of_accounts_non_uae_dubai() {
		return r55_no_of_accounts_non_uae_dubai;
	}
	public void setR55_no_of_accounts_non_uae_dubai(BigDecimal r55_no_of_accounts_non_uae_dubai) {
		this.r55_no_of_accounts_non_uae_dubai = r55_no_of_accounts_non_uae_dubai;
	}
	public BigDecimal getR55_amount_non_uae_dubai() {
		return r55_amount_non_uae_dubai;
	}
	public void setR55_amount_non_uae_dubai(BigDecimal r55_amount_non_uae_dubai) {
		this.r55_amount_non_uae_dubai = r55_amount_non_uae_dubai;
	}
	public BigDecimal getR55_total_dubai() {
		return r55_total_dubai;
	}
	public void setR55_total_dubai(BigDecimal r55_total_dubai) {
		this.r55_total_dubai = r55_total_dubai;
	}
	public BigDecimal getR55_no_of_accounts_uae_sharjah() {
		return r55_no_of_accounts_uae_sharjah;
	}
	public void setR55_no_of_accounts_uae_sharjah(BigDecimal r55_no_of_accounts_uae_sharjah) {
		this.r55_no_of_accounts_uae_sharjah = r55_no_of_accounts_uae_sharjah;
	}
	public BigDecimal getR55_amount_uae_sharjah() {
		return r55_amount_uae_sharjah;
	}
	public void setR55_amount_uae_sharjah(BigDecimal r55_amount_uae_sharjah) {
		this.r55_amount_uae_sharjah = r55_amount_uae_sharjah;
	}
	public BigDecimal getR55_no_of_accounts_non_uae_sharjah() {
		return r55_no_of_accounts_non_uae_sharjah;
	}
	public void setR55_no_of_accounts_non_uae_sharjah(BigDecimal r55_no_of_accounts_non_uae_sharjah) {
		this.r55_no_of_accounts_non_uae_sharjah = r55_no_of_accounts_non_uae_sharjah;
	}
	public BigDecimal getR55_amount_non_uae_sharjah() {
		return r55_amount_non_uae_sharjah;
	}
	public void setR55_amount_non_uae_sharjah(BigDecimal r55_amount_non_uae_sharjah) {
		this.r55_amount_non_uae_sharjah = r55_amount_non_uae_sharjah;
	}
	public BigDecimal getR55_total_sharjah() {
		return r55_total_sharjah;
	}
	public void setR55_total_sharjah(BigDecimal r55_total_sharjah) {
		this.r55_total_sharjah = r55_total_sharjah;
	}
	public BigDecimal getR55_no_of_accounts_uae_ajman() {
		return r55_no_of_accounts_uae_ajman;
	}
	public void setR55_no_of_accounts_uae_ajman(BigDecimal r55_no_of_accounts_uae_ajman) {
		this.r55_no_of_accounts_uae_ajman = r55_no_of_accounts_uae_ajman;
	}
	public BigDecimal getR55_amount_uae_ajman() {
		return r55_amount_uae_ajman;
	}
	public void setR55_amount_uae_ajman(BigDecimal r55_amount_uae_ajman) {
		this.r55_amount_uae_ajman = r55_amount_uae_ajman;
	}
	public BigDecimal getR55_no_of_accounts_non_uae_ajman() {
		return r55_no_of_accounts_non_uae_ajman;
	}
	public void setR55_no_of_accounts_non_uae_ajman(BigDecimal r55_no_of_accounts_non_uae_ajman) {
		this.r55_no_of_accounts_non_uae_ajman = r55_no_of_accounts_non_uae_ajman;
	}
	public BigDecimal getR55_amount_non_uae_ajman() {
		return r55_amount_non_uae_ajman;
	}
	public void setR55_amount_non_uae_ajman(BigDecimal r55_amount_non_uae_ajman) {
		this.r55_amount_non_uae_ajman = r55_amount_non_uae_ajman;
	}
	public BigDecimal getR55_total_ajman() {
		return r55_total_ajman;
	}
	public void setR55_total_ajman(BigDecimal r55_total_ajman) {
		this.r55_total_ajman = r55_total_ajman;
	}
	public BigDecimal getR55_no_of_accounts_uae_ras() {
		return r55_no_of_accounts_uae_ras;
	}
	public void setR55_no_of_accounts_uae_ras(BigDecimal r55_no_of_accounts_uae_ras) {
		this.r55_no_of_accounts_uae_ras = r55_no_of_accounts_uae_ras;
	}
	public BigDecimal getR55_amount_uae_ras() {
		return r55_amount_uae_ras;
	}
	public void setR55_amount_uae_ras(BigDecimal r55_amount_uae_ras) {
		this.r55_amount_uae_ras = r55_amount_uae_ras;
	}
	public BigDecimal getR55_no_of_accounts_non_uae_ras() {
		return r55_no_of_accounts_non_uae_ras;
	}
	public void setR55_no_of_accounts_non_uae_ras(BigDecimal r55_no_of_accounts_non_uae_ras) {
		this.r55_no_of_accounts_non_uae_ras = r55_no_of_accounts_non_uae_ras;
	}
	public BigDecimal getR55_amount_non_uae_ras() {
		return r55_amount_non_uae_ras;
	}
	public void setR55_amount_non_uae_ras(BigDecimal r55_amount_non_uae_ras) {
		this.r55_amount_non_uae_ras = r55_amount_non_uae_ras;
	}
	public BigDecimal getR55_total_ras() {
		return r55_total_ras;
	}
	public void setR55_total_ras(BigDecimal r55_total_ras) {
		this.r55_total_ras = r55_total_ras;
	}
	public BigDecimal getR55_no_of_accounts_uae_umm() {
		return r55_no_of_accounts_uae_umm;
	}
	public void setR55_no_of_accounts_uae_umm(BigDecimal r55_no_of_accounts_uae_umm) {
		this.r55_no_of_accounts_uae_umm = r55_no_of_accounts_uae_umm;
	}
	public BigDecimal getR55_amount_uae_umm() {
		return r55_amount_uae_umm;
	}
	public void setR55_amount_uae_umm(BigDecimal r55_amount_uae_umm) {
		this.r55_amount_uae_umm = r55_amount_uae_umm;
	}
	public BigDecimal getR55_no_of_accounts_non_uae_umm() {
		return r55_no_of_accounts_non_uae_umm;
	}
	public void setR55_no_of_accounts_non_uae_umm(BigDecimal r55_no_of_accounts_non_uae_umm) {
		this.r55_no_of_accounts_non_uae_umm = r55_no_of_accounts_non_uae_umm;
	}
	public BigDecimal getR55_amount_non_uae_umm() {
		return r55_amount_non_uae_umm;
	}
	public void setR55_amount_non_uae_umm(BigDecimal r55_amount_non_uae_umm) {
		this.r55_amount_non_uae_umm = r55_amount_non_uae_umm;
	}
	public BigDecimal getR55_total_umm() {
		return r55_total_umm;
	}
	public void setR55_total_umm(BigDecimal r55_total_umm) {
		this.r55_total_umm = r55_total_umm;
	}
	public BigDecimal getR55_no_of_accounts_uae_fujairah() {
		return r55_no_of_accounts_uae_fujairah;
	}
	public void setR55_no_of_accounts_uae_fujairah(BigDecimal r55_no_of_accounts_uae_fujairah) {
		this.r55_no_of_accounts_uae_fujairah = r55_no_of_accounts_uae_fujairah;
	}
	public BigDecimal getR55_amount_uae_fujairah() {
		return r55_amount_uae_fujairah;
	}
	public void setR55_amount_uae_fujairah(BigDecimal r55_amount_uae_fujairah) {
		this.r55_amount_uae_fujairah = r55_amount_uae_fujairah;
	}
	public BigDecimal getR55_no_of_accounts_non_uae_fujairah() {
		return r55_no_of_accounts_non_uae_fujairah;
	}
	public void setR55_no_of_accounts_non_uae_fujairah(BigDecimal r55_no_of_accounts_non_uae_fujairah) {
		this.r55_no_of_accounts_non_uae_fujairah = r55_no_of_accounts_non_uae_fujairah;
	}
	public BigDecimal getR55_amount_non_uae_fujairah() {
		return r55_amount_non_uae_fujairah;
	}
	public void setR55_amount_non_uae_fujairah(BigDecimal r55_amount_non_uae_fujairah) {
		this.r55_amount_non_uae_fujairah = r55_amount_non_uae_fujairah;
	}
	public BigDecimal getR55_total_fujairah() {
		return r55_total_fujairah;
	}
	public void setR55_total_fujairah(BigDecimal r55_total_fujairah) {
		this.r55_total_fujairah = r55_total_fujairah;
	}
	public String getR56_product() {
		return r56_product;
	}
	public void setR56_product(String r56_product) {
		this.r56_product = r56_product;
	}
	public BigDecimal getR56_amount_total() {
		return r56_amount_total;
	}
	public void setR56_amount_total(BigDecimal r56_amount_total) {
		this.r56_amount_total = r56_amount_total;
	}
	public String getR57_product() {
		return r57_product;
	}
	public void setR57_product(String r57_product) {
		this.r57_product = r57_product;
	}
	public BigDecimal getR57_amount_total() {
		return r57_amount_total;
	}
	public void setR57_amount_total(BigDecimal r57_amount_total) {
		this.r57_amount_total = r57_amount_total;
	}
	public String getR58_product() {
		return r58_product;
	}
	public void setR58_product(String r58_product) {
		this.r58_product = r58_product;
	}
	public BigDecimal getR58_amount_total() {
		return r58_amount_total;
	}
	public void setR58_amount_total(BigDecimal r58_amount_total) {
		this.r58_amount_total = r58_amount_total;
	}
	public String getR59_product() {
		return r59_product;
	}
	public void setR59_product(String r59_product) {
		this.r59_product = r59_product;
	}
	public BigDecimal getR59_amount_total() {
		return r59_amount_total;
	}
	public void setR59_amount_total(BigDecimal r59_amount_total) {
		this.r59_amount_total = r59_amount_total;
	}
	public String getR60_product() {
		return r60_product;
	}
	public void setR60_product(String r60_product) {
		this.r60_product = r60_product;
	}
	public BigDecimal getR60_amount_total() {
		return r60_amount_total;
	}
	public void setR60_amount_total(BigDecimal r60_amount_total) {
		this.r60_amount_total = r60_amount_total;
	}
	public String getR61_product() {
		return r61_product;
	}
	public void setR61_product(String r61_product) {
		this.r61_product = r61_product;
	}
	public BigDecimal getR61_amount_total() {
		return r61_amount_total;
	}
	public void setR61_amount_total(BigDecimal r61_amount_total) {
		this.r61_amount_total = r61_amount_total;
	}
	public String getR62_product() {
		return r62_product;
	}
	public void setR62_product(String r62_product) {
		this.r62_product = r62_product;
	}
	public BigDecimal getR62_amount_total() {
		return r62_amount_total;
	}
	public void setR62_amount_total(BigDecimal r62_amount_total) {
		this.r62_amount_total = r62_amount_total;
	}
	public String getR63_product() {
		return r63_product;
	}
	public void setR63_product(String r63_product) {
		this.r63_product = r63_product;
	}
	public BigDecimal getR63_amount_total() {
		return r63_amount_total;
	}
	public void setR63_amount_total(BigDecimal r63_amount_total) {
		this.r63_amount_total = r63_amount_total;
	}
	public String getR64_product() {
		return r64_product;
	}
	public void setR64_product(String r64_product) {
		this.r64_product = r64_product;
	}
	public BigDecimal getR64_amount_total() {
		return r64_amount_total;
	}
	public void setR64_amount_total(BigDecimal r64_amount_total) {
		this.r64_amount_total = r64_amount_total;
	}
	public String getR65_product() {
		return r65_product;
	}
	public void setR65_product(String r65_product) {
		this.r65_product = r65_product;
	}
	public BigDecimal getR65_amount_total() {
		return r65_amount_total;
	}
	public void setR65_amount_total(BigDecimal r65_amount_total) {
		this.r65_amount_total = r65_amount_total;
	}
	public String getR66_product() {
		return r66_product;
	}
	public void setR66_product(String r66_product) {
		this.r66_product = r66_product;
	}
	public BigDecimal getR66_amount_total() {
		return r66_amount_total;
	}
	public void setR66_amount_total(BigDecimal r66_amount_total) {
		this.r66_amount_total = r66_amount_total;
	}
	public String getR67_product() {
		return r67_product;
	}
	public void setR67_product(String r67_product) {
		this.r67_product = r67_product;
	}
	public BigDecimal getR67_amount_total() {
		return r67_amount_total;
	}
	public void setR67_amount_total(BigDecimal r67_amount_total) {
		this.r67_amount_total = r67_amount_total;
	}
	public String getR68_product() {
		return r68_product;
	}
	public void setR68_product(String r68_product) {
		this.r68_product = r68_product;
	}
	public BigDecimal getR68_amount_total() {
		return r68_amount_total;
	}
	public void setR68_amount_total(BigDecimal r68_amount_total) {
		this.r68_amount_total = r68_amount_total;
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
	public BRF41_Entity3() {
		super();
		// TODO Auto-generated constructor stub
	}

}
