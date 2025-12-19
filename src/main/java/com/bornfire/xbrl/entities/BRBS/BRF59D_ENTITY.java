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
@Table(name = "BRF59D_SUMMARYTABLE")

public class BRF59D_ENTITY {

	private String r64_product;
	private BigDecimal r64_nbfi;
	private BigDecimal r64_interbank;
	private BigDecimal r64_gov;
	private BigDecimal r64_corporate;
	private BigDecimal r64_gre;
	private BigDecimal r64_trade;
	private BigDecimal r64_individuals;
	private BigDecimal r64_investment;
	private BigDecimal r64_nbfi1;
	private BigDecimal r64_interbank1;
	private BigDecimal r64_gov1;
	private BigDecimal r64_corporate1;
	private BigDecimal r64_gre1;
	private BigDecimal r64_trade1;
	private BigDecimal r64_individuals1;
	private BigDecimal r64_investment1;
	private BigDecimal r64_zer0;
	private BigDecimal r64_three;
	private BigDecimal r64_six;
	private BigDecimal r64_oneyear;
	private BigDecimal r64_foreign;
	private BigDecimal r64_banks;
	private BigDecimal r64_gov2;
	private BigDecimal r64_other;
	private BigDecimal r64_banks1;
	private BigDecimal r64_individuals2;
	private BigDecimal r64_other1;
	private BigDecimal r64_banks2;
	private BigDecimal r64_gov3;
	private BigDecimal r64_others2;
	private BigDecimal r64_banks3;
	private BigDecimal r64_gov4;
	private BigDecimal r64_others3;
	private BigDecimal r64_foreign1;
	private BigDecimal r64_guarantees;
	private BigDecimal r64_nbfi2;
	private BigDecimal r64_interbank2;
	private BigDecimal r64_gov5;
	private BigDecimal r64_corporate2;
	private BigDecimal r64_gre2;
	private BigDecimal r64_individuals3;
	private BigDecimal r64_zero1;
	private BigDecimal r64_three1;
	private BigDecimal r64_six1;
	private BigDecimal r64_oneyear1;
	private String r64_empty;
	private String r65_product;
	private BigDecimal r65_nbfi;
	private BigDecimal r65_interbank;
	private BigDecimal r65_gov;
	private BigDecimal r65_corporate;
	private BigDecimal r65_gre;
	private BigDecimal r65_trade;
	private BigDecimal r65_individuals;
	private BigDecimal r65_investment;
	private BigDecimal r65_nbfi1;
	private BigDecimal r65_interbank1;
	private BigDecimal r65_gov1;
	private BigDecimal r65_corporate1;
	private BigDecimal r65_gre1;
	private BigDecimal r65_trade1;
	private BigDecimal r65_individuals1;
	private BigDecimal r65_investment1;
	private BigDecimal r65_zer0;
	private BigDecimal r65_three;
	private BigDecimal r65_six;
	private BigDecimal r65_oneyear;
	private BigDecimal r65_foreign;
	private BigDecimal r65_banks;
	private BigDecimal r65_gov2;
	private BigDecimal r65_other;
	private BigDecimal r65_banks1;
	private BigDecimal r65_individuals2;
	private BigDecimal r65_other1;
	private BigDecimal r65_banks2;
	private BigDecimal r65_gov3;
	private BigDecimal r65_others2;
	private BigDecimal r65_banks3;
	private BigDecimal r65_gov4;
	private BigDecimal r65_others3;
	private BigDecimal r65_foreign1;
	private BigDecimal r65_guarantees;
	private BigDecimal r65_nbfi2;
	private BigDecimal r65_interbank2;
	private BigDecimal r65_gov5;
	private BigDecimal r65_corporate2;
	private BigDecimal r65_gre2;
	private BigDecimal r65_individuals3;
	private BigDecimal r65_zero1;
	private BigDecimal r65_three1;
	private BigDecimal r65_six1;
	private BigDecimal r65_oneyear1;
	private String r65_empty;
	private String r66_product;
	private BigDecimal r66_nbfi;
	private BigDecimal r66_interbank;
	private BigDecimal r66_gov;
	private BigDecimal r66_corporate;
	private BigDecimal r66_gre;
	private BigDecimal r66_trade;
	private BigDecimal r66_individuals;
	private BigDecimal r66_investment;
	private BigDecimal r66_nbfi1;
	private BigDecimal r66_interbank1;
	private BigDecimal r66_gov1;
	private BigDecimal r66_corporate1;
	private BigDecimal r66_gre1;
	private BigDecimal r66_trade1;
	private BigDecimal r66_individuals1;
	private BigDecimal r66_investment1;
	private BigDecimal r66_zer0;
	private BigDecimal r66_three;
	private BigDecimal r66_six;
	private BigDecimal r66_oneyear;
	private BigDecimal r66_foreign;
	private BigDecimal r66_banks;
	private BigDecimal r66_gov2;
	private BigDecimal r66_other;
	private BigDecimal r66_banks1;
	private BigDecimal r66_individuals2;
	private BigDecimal r66_other1;
	private BigDecimal r66_banks2;
	private BigDecimal r66_gov3;
	private BigDecimal r66_others2;
	private BigDecimal r66_banks3;
	private BigDecimal r66_gov4;
	private BigDecimal r66_others3;
	private BigDecimal r66_foreign1;
	private BigDecimal r66_guarantees;
	private BigDecimal r66_nbfi2;
	private BigDecimal r66_interbank2;
	private BigDecimal r66_gov5;
	private BigDecimal r66_corporate2;
	private BigDecimal r66_gre2;
	private BigDecimal r66_individuals3;
	private BigDecimal r66_zero1;
	private BigDecimal r66_three1;
	private BigDecimal r66_six1;
	private BigDecimal r66_oneyear1;
	private String r66_empty;
	private String r67_product;
	private BigDecimal r67_nbfi;
	private BigDecimal r67_interbank;
	private BigDecimal r67_gov;
	private BigDecimal r67_corporate;
	private BigDecimal r67_gre;
	private BigDecimal r67_trade;
	private BigDecimal r67_individuals;
	private BigDecimal r67_investment;
	private BigDecimal r67_nbfi1;
	private BigDecimal r67_interbank1;
	private BigDecimal r67_gov1;
	private BigDecimal r67_corporate1;
	private BigDecimal r67_gre1;
	private BigDecimal r67_trade1;
	private BigDecimal r67_individuals1;
	private BigDecimal r67_investment1;
	private BigDecimal r67_zer0;
	private BigDecimal r67_three;
	private BigDecimal r67_six;
	private BigDecimal r67_oneyear;
	private BigDecimal r67_foreign;
	private BigDecimal r67_banks;
	private BigDecimal r67_gov2;
	private BigDecimal r67_other;
	private BigDecimal r67_banks1;
	private BigDecimal r67_individuals2;
	private BigDecimal r67_other1;
	private BigDecimal r67_banks2;
	private BigDecimal r67_gov3;
	private BigDecimal r67_others2;
	private BigDecimal r67_banks3;
	private BigDecimal r67_gov4;
	private BigDecimal r67_others3;
	private BigDecimal r67_foreign1;
	private BigDecimal r67_guarantees;
	private BigDecimal r67_nbfi2;
	private BigDecimal r67_interbank2;
	private BigDecimal r67_gov5;
	private BigDecimal r67_corporate2;
	private BigDecimal r67_gre2;
	private BigDecimal r67_individuals3;
	private BigDecimal r67_zero1;
	private BigDecimal r67_three1;
	private BigDecimal r67_six1;
	private BigDecimal r67_oneyear1;
	private String r67_empty;
	private String r68_product;
	private BigDecimal r68_nbfi;
	private BigDecimal r68_interbank;
	private BigDecimal r68_gov;
	private BigDecimal r68_corporate;
	private BigDecimal r68_gre;
	private BigDecimal r68_trade;
	private BigDecimal r68_individuals;
	private BigDecimal r68_investment;
	private BigDecimal r68_nbfi1;
	private BigDecimal r68_interbank1;
	private BigDecimal r68_gov1;
	private BigDecimal r68_corporate1;
	private BigDecimal r68_gre1;
	private BigDecimal r68_trade1;
	private BigDecimal r68_individuals1;
	private BigDecimal r68_investment1;
	private BigDecimal r68_zer0;
	private BigDecimal r68_three;
	private BigDecimal r68_six;
	private BigDecimal r68_oneyear;
	private BigDecimal r68_foreign;
	private BigDecimal r68_banks;
	private BigDecimal r68_gov2;
	private BigDecimal r68_other;
	private BigDecimal r68_banks1;
	private BigDecimal r68_individuals2;
	private BigDecimal r68_other1;
	private BigDecimal r68_banks2;
	private BigDecimal r68_gov3;
	private BigDecimal r68_others2;
	private BigDecimal r68_banks3;
	private BigDecimal r68_gov4;
	private BigDecimal r68_others3;
	private BigDecimal r68_foreign1;
	private BigDecimal r68_guarantees;
	private BigDecimal r68_nbfi2;
	private BigDecimal r68_interbank2;
	private BigDecimal r68_gov5;
	private BigDecimal r68_corporate2;
	private BigDecimal r68_gre2;
	private BigDecimal r68_individuals3;
	private BigDecimal r68_zero1;
	private BigDecimal r68_three1;
	private BigDecimal r68_six1;
	private BigDecimal r68_oneyear1;
	private String r68_empty;
	private String r69_product;
	private BigDecimal r69_nbfi;
	private BigDecimal r69_interbank;
	private BigDecimal r69_gov;
	private BigDecimal r69_corporate;
	private BigDecimal r69_gre;
	private BigDecimal r69_trade;
	private BigDecimal r69_individuals;
	private BigDecimal r69_investment;
	private BigDecimal r69_nbfi1;
	private BigDecimal r69_interbank1;
	private BigDecimal r69_gov1;
	private BigDecimal r69_corporate1;
	private BigDecimal r69_gre1;
	private BigDecimal r69_trade1;
	private BigDecimal r69_individuals1;
	private BigDecimal r69_investment1;
	private BigDecimal r69_zer0;
	private BigDecimal r69_three;
	private BigDecimal r69_six;
	private BigDecimal r69_oneyear;
	private BigDecimal r69_foreign;
	private BigDecimal r69_banks;
	private BigDecimal r69_gov2;
	private BigDecimal r69_other;
	private BigDecimal r69_banks1;
	private BigDecimal r69_individuals2;
	private BigDecimal r69_other1;
	private BigDecimal r69_banks2;
	private BigDecimal r69_gov3;
	private BigDecimal r69_others2;
	private BigDecimal r69_banks3;
	private BigDecimal r69_gov4;
	private BigDecimal r69_others3;
	private BigDecimal r69_foreign1;
	private BigDecimal r69_guarantees;
	private BigDecimal r69_nbfi2;
	private BigDecimal r69_interbank2;
	private BigDecimal r69_gov5;
	private BigDecimal r69_corporate2;
	private BigDecimal r69_gre2;
	private BigDecimal r69_individuals3;
	private BigDecimal r69_zero1;
	private BigDecimal r69_three1;
	private BigDecimal r69_six1;
	private BigDecimal r69_oneyear1;
	private String r69_empty;
	private String r70_product;
	private BigDecimal r70_nbfi;
	private BigDecimal r70_interbank;
	private BigDecimal r70_gov;
	private BigDecimal r70_corporate;
	private BigDecimal r70_gre;
	private BigDecimal r70_trade;
	private BigDecimal r70_individuals;
	private BigDecimal r70_investment;
	private BigDecimal r70_nbfi1;
	private BigDecimal r70_interbank1;
	private BigDecimal r70_gov1;
	private BigDecimal r70_corporate1;
	private BigDecimal r70_gre1;
	private BigDecimal r70_trade1;
	private BigDecimal r70_individuals1;
	private BigDecimal r70_investment1;
	private BigDecimal r70_zer0;
	private BigDecimal r70_three;
	private BigDecimal r70_six;
	private BigDecimal r70_oneyear;
	private BigDecimal r70_foreign;
	private BigDecimal r70_banks;
	private BigDecimal r70_gov2;
	private BigDecimal r70_other;
	private BigDecimal r70_banks1;
	private BigDecimal r70_individuals2;
	private BigDecimal r70_other1;
	private BigDecimal r70_banks2;
	private BigDecimal r70_gov3;
	private BigDecimal r70_others2;
	private BigDecimal r70_banks3;
	private BigDecimal r70_gov4;
	private BigDecimal r70_others3;
	private BigDecimal r70_foreign1;
	private BigDecimal r70_guarantees;
	private BigDecimal r70_nbfi2;
	private BigDecimal r70_interbank2;
	private BigDecimal r70_gov5;
	private BigDecimal r70_corporate2;
	private BigDecimal r70_gre2;
	private BigDecimal r70_individuals3;
	private BigDecimal r70_zero1;
	private BigDecimal r70_three1;
	private BigDecimal r70_six1;
	private BigDecimal r70_oneyear1;
	private String r70_empty;
	private String r71_product;
	private BigDecimal r71_nbfi;
	private BigDecimal r71_interbank;
	private BigDecimal r71_gov;
	private BigDecimal r71_corporate;
	private BigDecimal r71_gre;
	private BigDecimal r71_trade;
	private BigDecimal r71_individuals;
	private BigDecimal r71_investment;
	private BigDecimal r71_nbfi1;
	private BigDecimal r71_interbank1;
	private BigDecimal r71_gov1;
	private BigDecimal r71_corporate1;
	private BigDecimal r71_gre1;
	private BigDecimal r71_trade1;
	private BigDecimal r71_individuals1;
	private BigDecimal r71_investment1;
	private BigDecimal r71_zer0;
	private BigDecimal r71_three;
	private BigDecimal r71_six;
	private BigDecimal r71_oneyear;
	private BigDecimal r71_foreign;
	private BigDecimal r71_banks;
	private BigDecimal r71_gov2;
	private BigDecimal r71_other;
	private BigDecimal r71_banks1;
	private BigDecimal r71_individuals2;
	private BigDecimal r71_other1;
	private BigDecimal r71_banks2;
	private BigDecimal r71_gov3;
	private BigDecimal r71_others2;
	private BigDecimal r71_banks3;
	private BigDecimal r71_gov4;
	private BigDecimal r71_others3;
	private BigDecimal r71_foreign1;
	private BigDecimal r71_guarantees;
	private BigDecimal r71_nbfi2;
	private BigDecimal r71_interbank2;
	private BigDecimal r71_gov5;
	private BigDecimal r71_corporate2;
	private BigDecimal r71_gre2;
	private BigDecimal r71_individuals3;
	private BigDecimal r71_zero1;
	private BigDecimal r71_three1;
	private BigDecimal r71_six1;
	private BigDecimal r71_oneyear1;
	private String r71_empty;
	private String r72_product;
	private BigDecimal r72_nbfi;
	private BigDecimal r72_interbank;
	private BigDecimal r72_gov;
	private BigDecimal r72_corporate;
	private BigDecimal r72_gre;
	private BigDecimal r72_trade;
	private BigDecimal r72_individuals;
	private BigDecimal r72_investment;
	private BigDecimal r72_nbfi1;
	private BigDecimal r72_interbank1;
	private BigDecimal r72_gov1;
	private BigDecimal r72_corporate1;
	private BigDecimal r72_gre1;
	private BigDecimal r72_trade1;
	private BigDecimal r72_individuals1;
	private BigDecimal r72_investment1;
	private BigDecimal r72_zer0;
	private BigDecimal r72_three;
	private BigDecimal r72_six;
	private BigDecimal r72_oneyear;
	private BigDecimal r72_foreign;
	private BigDecimal r72_banks;
	private BigDecimal r72_gov2;
	private BigDecimal r72_other;
	private BigDecimal r72_banks1;
	private BigDecimal r72_individuals2;
	private BigDecimal r72_other1;
	private BigDecimal r72_banks2;
	private BigDecimal r72_gov3;
	private BigDecimal r72_others2;
	private BigDecimal r72_banks3;
	private BigDecimal r72_gov4;
	private BigDecimal r72_others3;
	private BigDecimal r72_foreign1;
	private BigDecimal r72_guarantees;
	private BigDecimal r72_nbfi2;
	private BigDecimal r72_interbank2;
	private BigDecimal r72_gov5;
	private BigDecimal r72_corporate2;
	private BigDecimal r72_gre2;
	private BigDecimal r72_individuals3;
	private BigDecimal r72_zero1;
	private BigDecimal r72_three1;
	private BigDecimal r72_six1;
	private BigDecimal r72_oneyear1;
	private String r72_empty;
	private String r73_product;
	private BigDecimal r73_nbfi;
	private BigDecimal r73_interbank;
	private BigDecimal r73_gov;
	private BigDecimal r73_corporate;
	private BigDecimal r73_gre;
	private BigDecimal r73_trade;
	private BigDecimal r73_individuals;
	private BigDecimal r73_investment;
	private BigDecimal r73_nbfi1;
	private BigDecimal r73_interbank1;
	private BigDecimal r73_gov1;
	private BigDecimal r73_corporate1;
	private BigDecimal r73_gre1;
	private BigDecimal r73_trade1;
	private BigDecimal r73_individuals1;
	private BigDecimal r73_investment1;
	private BigDecimal r73_zer0;
	private BigDecimal r73_three;
	private BigDecimal r73_six;
	private BigDecimal r73_oneyear;
	private BigDecimal r73_foreign;
	private BigDecimal r73_banks;
	private BigDecimal r73_gov2;
	private BigDecimal r73_other;
	private BigDecimal r73_banks1;
	private BigDecimal r73_individuals2;
	private BigDecimal r73_other1;
	private BigDecimal r73_banks2;
	private BigDecimal r73_gov3;
	private BigDecimal r73_others2;
	private BigDecimal r73_banks3;
	private BigDecimal r73_gov4;
	private BigDecimal r73_others3;
	private BigDecimal r73_foreign1;
	private BigDecimal r73_guarantees;
	private BigDecimal r73_nbfi2;
	private BigDecimal r73_interbank2;
	private BigDecimal r73_gov5;
	private BigDecimal r73_corporate2;
	private BigDecimal r73_gre2;
	private BigDecimal r73_individuals3;
	private BigDecimal r73_zero1;
	private BigDecimal r73_three1;
	private BigDecimal r73_six1;
	private BigDecimal r73_oneyear1;
	private String r73_empty;
	private String r74_product;
	private BigDecimal r74_nbfi;
	private BigDecimal r74_interbank;
	private BigDecimal r74_gov;
	private BigDecimal r74_corporate;
	private BigDecimal r74_gre;
	private BigDecimal r74_trade;
	private BigDecimal r74_individuals;
	private BigDecimal r74_investment;
	private BigDecimal r74_nbfi1;
	private BigDecimal r74_interbank1;
	private BigDecimal r74_gov1;
	private BigDecimal r74_corporate1;
	private BigDecimal r74_gre1;
	private BigDecimal r74_trade1;
	private BigDecimal r74_individuals1;
	private BigDecimal r74_investment1;
	private BigDecimal r74_zer0;
	private BigDecimal r74_three;
	private BigDecimal r74_six;
	private BigDecimal r74_oneyear;
	private BigDecimal r74_foreign;
	private BigDecimal r74_banks;
	private BigDecimal r74_gov2;
	private BigDecimal r74_other;
	private BigDecimal r74_banks1;
	private BigDecimal r74_individuals2;
	private BigDecimal r74_other1;
	private BigDecimal r74_banks2;
	private BigDecimal r74_gov3;
	private BigDecimal r74_others2;
	private BigDecimal r74_banks3;
	private BigDecimal r74_gov4;
	private BigDecimal r74_others3;
	private BigDecimal r74_foreign1;
	private BigDecimal r74_guarantees;
	private BigDecimal r74_nbfi2;
	private BigDecimal r74_interbank2;
	private BigDecimal r74_gov5;
	private BigDecimal r74_corporate2;
	private BigDecimal r74_gre2;
	private BigDecimal r74_individuals3;
	private BigDecimal r74_zero1;
	private BigDecimal r74_three1;
	private BigDecimal r74_six1;
	private BigDecimal r74_oneyear1;
	private String r74_empty;
	private String r75_product;
	private BigDecimal r75_nbfi;
	private BigDecimal r75_interbank;
	private BigDecimal r75_gov;
	private BigDecimal r75_corporate;
	private BigDecimal r75_gre;
	private BigDecimal r75_trade;
	private BigDecimal r75_individuals;
	private BigDecimal r75_investment;
	private BigDecimal r75_nbfi1;
	private BigDecimal r75_interbank1;
	private BigDecimal r75_gov1;
	private BigDecimal r75_corporate1;
	private BigDecimal r75_gre1;
	private BigDecimal r75_trade1;
	private BigDecimal r75_individuals1;
	private BigDecimal r75_investment1;
	private BigDecimal r75_zer0;
	private BigDecimal r75_three;
	private BigDecimal r75_six;
	private BigDecimal r75_oneyear;
	private BigDecimal r75_foreign;
	private BigDecimal r75_banks;
	private BigDecimal r75_gov2;
	private BigDecimal r75_other;
	private BigDecimal r75_banks1;
	private BigDecimal r75_individuals2;
	private BigDecimal r75_other1;
	private BigDecimal r75_banks2;
	private BigDecimal r75_gov3;
	private BigDecimal r75_others2;
	private BigDecimal r75_banks3;
	private BigDecimal r75_gov4;
	private BigDecimal r75_others3;
	private BigDecimal r75_foreign1;
	private BigDecimal r75_guarantees;
	private BigDecimal r75_nbfi2;
	private BigDecimal r75_interbank2;
	private BigDecimal r75_gov5;
	private BigDecimal r75_corporate2;
	private BigDecimal r75_gre2;
	private BigDecimal r75_individuals3;
	private BigDecimal r75_zero1;
	private BigDecimal r75_three1;
	private BigDecimal r75_six1;
	private BigDecimal r75_oneyear1;
	private String r75_empty;
	private String r76_product;
	private BigDecimal r76_nbfi;
	private BigDecimal r76_interbank;
	private BigDecimal r76_gov;
	private BigDecimal r76_corporate;
	private BigDecimal r76_gre;
	private BigDecimal r76_trade;
	private BigDecimal r76_individuals;
	private BigDecimal r76_investment;
	private BigDecimal r76_nbfi1;
	private BigDecimal r76_interbank1;
	private BigDecimal r76_gov1;
	private BigDecimal r76_corporate1;
	private BigDecimal r76_gre1;
	private BigDecimal r76_trade1;
	private BigDecimal r76_individuals1;
	private BigDecimal r76_investment1;
	private BigDecimal r76_zer0;
	private BigDecimal r76_three;
	private BigDecimal r76_six;
	private BigDecimal r76_oneyear;
	private BigDecimal r76_foreign;
	private BigDecimal r76_banks;
	private BigDecimal r76_gov2;
	private BigDecimal r76_other;
	private BigDecimal r76_banks1;
	private BigDecimal r76_individuals2;
	private BigDecimal r76_other1;
	private BigDecimal r76_banks2;
	private BigDecimal r76_gov3;
	private BigDecimal r76_others2;
	private BigDecimal r76_banks3;
	private BigDecimal r76_gov4;
	private BigDecimal r76_others3;
	private BigDecimal r76_foreign1;
	private BigDecimal r76_guarantees;
	private BigDecimal r76_nbfi2;
	private BigDecimal r76_interbank2;
	private BigDecimal r76_gov5;
	private BigDecimal r76_corporate2;
	private BigDecimal r76_gre2;
	private BigDecimal r76_individuals3;
	private BigDecimal r76_zero1;
	private BigDecimal r76_three1;
	private BigDecimal r76_six1;
	private BigDecimal r76_oneyear1;
	private String r76_empty;
	private String r77_product;
	private BigDecimal r77_nbfi;
	private BigDecimal r77_interbank;
	private BigDecimal r77_gov;
	private BigDecimal r77_corporate;
	private BigDecimal r77_gre;
	private BigDecimal r77_trade;
	private BigDecimal r77_individuals;
	private BigDecimal r77_investment;
	private BigDecimal r77_nbfi1;
	private BigDecimal r77_interbank1;
	private BigDecimal r77_gov1;
	private BigDecimal r77_corporate1;
	private BigDecimal r77_gre1;
	private BigDecimal r77_trade1;
	private BigDecimal r77_individuals1;
	private BigDecimal r77_investment1;
	private BigDecimal r77_zer0;
	private BigDecimal r77_three;
	private BigDecimal r77_six;
	private BigDecimal r77_oneyear;
	private BigDecimal r77_foreign;
	private BigDecimal r77_banks;
	private BigDecimal r77_gov2;
	private BigDecimal r77_other;
	private BigDecimal r77_banks1;
	private BigDecimal r77_individuals2;
	private BigDecimal r77_other1;
	private BigDecimal r77_banks2;
	private BigDecimal r77_gov3;
	private BigDecimal r77_others2;
	private BigDecimal r77_banks3;
	private BigDecimal r77_gov4;
	private BigDecimal r77_others3;
	private BigDecimal r77_foreign1;
	private BigDecimal r77_guarantees;
	private BigDecimal r77_nbfi2;
	private BigDecimal r77_interbank2;
	private BigDecimal r77_gov5;
	private BigDecimal r77_corporate2;
	private BigDecimal r77_gre2;
	private BigDecimal r77_individuals3;
	private BigDecimal r77_zero1;
	private BigDecimal r77_three1;
	private BigDecimal r77_six1;
	private BigDecimal r77_oneyear1;
	private String r77_empty;
	private String r78_product;
	private BigDecimal r78_nbfi;
	private BigDecimal r78_interbank;
	private BigDecimal r78_gov;
	private BigDecimal r78_corporate;
	private BigDecimal r78_gre;
	private BigDecimal r78_trade;
	private BigDecimal r78_individuals;
	private BigDecimal r78_investment;
	private BigDecimal r78_nbfi1;
	private BigDecimal r78_interbank1;
	private BigDecimal r78_gov1;
	private BigDecimal r78_corporate1;
	private BigDecimal r78_gre1;
	private BigDecimal r78_trade1;
	private BigDecimal r78_individuals1;
	private BigDecimal r78_investment1;
	private BigDecimal r78_zer0;
	private BigDecimal r78_three;
	private BigDecimal r78_six;
	private BigDecimal r78_oneyear;
	private BigDecimal r78_foreign;
	private BigDecimal r78_banks;
	private BigDecimal r78_gov2;
	private BigDecimal r78_other;
	private BigDecimal r78_banks1;
	private BigDecimal r78_individuals2;
	private BigDecimal r78_other1;
	private BigDecimal r78_banks2;
	private BigDecimal r78_gov3;
	private BigDecimal r78_others2;
	private BigDecimal r78_banks3;
	private BigDecimal r78_gov4;
	private BigDecimal r78_others3;
	private BigDecimal r78_foreign1;
	private BigDecimal r78_guarantees;
	private BigDecimal r78_nbfi2;
	private BigDecimal r78_interbank2;
	private BigDecimal r78_gov5;
	private BigDecimal r78_corporate2;
	private BigDecimal r78_gre2;
	private BigDecimal r78_individuals3;
	private BigDecimal r78_zero1;
	private BigDecimal r78_three1;
	private BigDecimal r78_six1;
	private BigDecimal r78_oneyear1;
	private String r78_empty;
	private String r79_product;
	private BigDecimal r79_nbfi;
	private BigDecimal r79_interbank;
	private BigDecimal r79_gov;
	private BigDecimal r79_corporate;
	private BigDecimal r79_gre;
	private BigDecimal r79_trade;
	private BigDecimal r79_individuals;
	private BigDecimal r79_investment;
	private BigDecimal r79_nbfi1;
	private BigDecimal r79_interbank1;
	private BigDecimal r79_gov1;
	private BigDecimal r79_corporate1;
	private BigDecimal r79_gre1;
	private BigDecimal r79_trade1;
	private BigDecimal r79_individuals1;
	private BigDecimal r79_investment1;
	private BigDecimal r79_zer0;
	private BigDecimal r79_three;
	private BigDecimal r79_six;
	private BigDecimal r79_oneyear;
	private BigDecimal r79_foreign;
	private BigDecimal r79_banks;
	private BigDecimal r79_gov2;
	private BigDecimal r79_other;
	private BigDecimal r79_banks1;
	private BigDecimal r79_individuals2;
	private BigDecimal r79_other1;
	private BigDecimal r79_banks2;
	private BigDecimal r79_gov3;
	private BigDecimal r79_others2;
	private BigDecimal r79_banks3;
	private BigDecimal r79_gov4;
	private BigDecimal r79_others3;
	private BigDecimal r79_foreign1;
	private BigDecimal r79_guarantees;
	private BigDecimal r79_nbfi2;
	private BigDecimal r79_interbank2;
	private BigDecimal r79_gov5;
	private BigDecimal r79_corporate2;
	private BigDecimal r79_gre2;
	private BigDecimal r79_individuals3;
	private BigDecimal r79_zero1;
	private BigDecimal r79_three1;
	private BigDecimal r79_six1;
	private BigDecimal r79_oneyear1;
	private String r79_empty;
	private String r80_product;
	private BigDecimal r80_nbfi;
	private BigDecimal r80_interbank;
	private BigDecimal r80_gov;
	private BigDecimal r80_corporate;
	private BigDecimal r80_gre;
	private BigDecimal r80_trade;
	private BigDecimal r80_individuals;
	private BigDecimal r80_investment;
	private BigDecimal r80_nbfi1;
	private BigDecimal r80_interbank1;
	private BigDecimal r80_gov1;
	private BigDecimal r80_corporate1;
	private BigDecimal r80_gre1;
	private BigDecimal r80_trade1;
	private BigDecimal r80_individuals1;
	private BigDecimal r80_investment1;
	private BigDecimal r80_zer0;
	private BigDecimal r80_three;
	private BigDecimal r80_six;
	private BigDecimal r80_oneyear;
	private BigDecimal r80_foreign;
	private BigDecimal r80_banks;
	private BigDecimal r80_gov2;
	private BigDecimal r80_other;
	private BigDecimal r80_banks1;
	private BigDecimal r80_individuals2;
	private BigDecimal r80_other1;
	private BigDecimal r80_banks2;
	private BigDecimal r80_gov3;
	private BigDecimal r80_others2;
	private BigDecimal r80_banks3;
	private BigDecimal r80_gov4;
	private BigDecimal r80_others3;
	private BigDecimal r80_foreign1;
	private BigDecimal r80_guarantees;
	private BigDecimal r80_nbfi2;
	private BigDecimal r80_interbank2;
	private BigDecimal r80_gov5;
	private BigDecimal r80_corporate2;
	private BigDecimal r80_gre2;
	private BigDecimal r80_individuals3;
	private BigDecimal r80_zero1;
	private BigDecimal r80_three1;
	private BigDecimal r80_six1;
	private BigDecimal r80_oneyear1;
	private String r80_empty;
	private String	product;
	private BigDecimal	nbfi_total;
	private BigDecimal	interbank_total;
	private BigDecimal	gov_total;
	private BigDecimal	corporate_total;
	private BigDecimal	gre_total;
	private BigDecimal	trade_total;
	private BigDecimal	individuals_total;
	private BigDecimal	investment_total;
	private BigDecimal	nbfi1_total;
	private BigDecimal	interbank1_total;
	private BigDecimal	gov1_total;
	private BigDecimal	corporate1_total;
	private BigDecimal	gre1_total;
	private BigDecimal	trade1_total;
	private BigDecimal	individuals1_total;
	private BigDecimal	investment1_total;
	private BigDecimal	zer0_total;
	private BigDecimal	three_total;
	private BigDecimal	six_total;
	private BigDecimal	oneyear_total;
	private BigDecimal	foreign_total;
	private BigDecimal	banks_total;
	private BigDecimal	gov2_total;
	private BigDecimal	other_total;
	private BigDecimal	banks1_total;
	private BigDecimal	individuals2_total;
	private BigDecimal	other1_total;
	private BigDecimal	banks2_total;
	private BigDecimal	gov3_total;
	private BigDecimal	others2_total;
	private BigDecimal	banks3_total;
	private BigDecimal	gov4_total;
	private BigDecimal	others3_total;
	private BigDecimal	foreign1_total;
	private BigDecimal	guarantees_total;
	private BigDecimal	nbfi2_total;
	private BigDecimal	interbank2_total;
	private BigDecimal	gov5_total;
	private BigDecimal	corporate2_total;
	private BigDecimal	gre2_total;
	private BigDecimal	individuals3_total;
	private BigDecimal	zero1_total;
	private BigDecimal	three1_total;
	private BigDecimal	six1_total;
	private BigDecimal	oneyear1_total;
	private String	empty_total;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date report_date;
	private Date report_from_date;
	private Date report_to_date;
	private String entity_flg;
	private String modify_flg;
	private String del_flg;
	private String report_code;
	private String	repdesc;
	private String	frequency;
	public String getR64_product() {
		return r64_product;
	}
	public void setR64_product(String r64_product) {
		this.r64_product = r64_product;
	}
	public BigDecimal getR64_nbfi() {
		return r64_nbfi;
	}
	public void setR64_nbfi(BigDecimal r64_nbfi) {
		this.r64_nbfi = r64_nbfi;
	}
	public BigDecimal getR64_interbank() {
		return r64_interbank;
	}
	public void setR64_interbank(BigDecimal r64_interbank) {
		this.r64_interbank = r64_interbank;
	}
	public BigDecimal getR64_gov() {
		return r64_gov;
	}
	public void setR64_gov(BigDecimal r64_gov) {
		this.r64_gov = r64_gov;
	}
	public BigDecimal getR64_corporate() {
		return r64_corporate;
	}
	public void setR64_corporate(BigDecimal r64_corporate) {
		this.r64_corporate = r64_corporate;
	}
	public BigDecimal getR64_gre() {
		return r64_gre;
	}
	public void setR64_gre(BigDecimal r64_gre) {
		this.r64_gre = r64_gre;
	}
	public BigDecimal getR64_trade() {
		return r64_trade;
	}
	public void setR64_trade(BigDecimal r64_trade) {
		this.r64_trade = r64_trade;
	}
	public BigDecimal getR64_individuals() {
		return r64_individuals;
	}
	public void setR64_individuals(BigDecimal r64_individuals) {
		this.r64_individuals = r64_individuals;
	}
	public BigDecimal getR64_investment() {
		return r64_investment;
	}
	public void setR64_investment(BigDecimal r64_investment) {
		this.r64_investment = r64_investment;
	}
	public BigDecimal getR64_nbfi1() {
		return r64_nbfi1;
	}
	public void setR64_nbfi1(BigDecimal r64_nbfi1) {
		this.r64_nbfi1 = r64_nbfi1;
	}
	public BigDecimal getR64_interbank1() {
		return r64_interbank1;
	}
	public void setR64_interbank1(BigDecimal r64_interbank1) {
		this.r64_interbank1 = r64_interbank1;
	}
	public BigDecimal getR64_gov1() {
		return r64_gov1;
	}
	public void setR64_gov1(BigDecimal r64_gov1) {
		this.r64_gov1 = r64_gov1;
	}
	public BigDecimal getR64_corporate1() {
		return r64_corporate1;
	}
	public void setR64_corporate1(BigDecimal r64_corporate1) {
		this.r64_corporate1 = r64_corporate1;
	}
	public BigDecimal getR64_gre1() {
		return r64_gre1;
	}
	public void setR64_gre1(BigDecimal r64_gre1) {
		this.r64_gre1 = r64_gre1;
	}
	public BigDecimal getR64_trade1() {
		return r64_trade1;
	}
	public void setR64_trade1(BigDecimal r64_trade1) {
		this.r64_trade1 = r64_trade1;
	}
	public BigDecimal getR64_individuals1() {
		return r64_individuals1;
	}
	public void setR64_individuals1(BigDecimal r64_individuals1) {
		this.r64_individuals1 = r64_individuals1;
	}
	public BigDecimal getR64_investment1() {
		return r64_investment1;
	}
	public void setR64_investment1(BigDecimal r64_investment1) {
		this.r64_investment1 = r64_investment1;
	}
	public BigDecimal getR64_zer0() {
		return r64_zer0;
	}
	public void setR64_zer0(BigDecimal r64_zer0) {
		this.r64_zer0 = r64_zer0;
	}
	public BigDecimal getR64_three() {
		return r64_three;
	}
	public void setR64_three(BigDecimal r64_three) {
		this.r64_three = r64_three;
	}
	public BigDecimal getR64_six() {
		return r64_six;
	}
	public void setR64_six(BigDecimal r64_six) {
		this.r64_six = r64_six;
	}
	public BigDecimal getR64_oneyear() {
		return r64_oneyear;
	}
	public void setR64_oneyear(BigDecimal r64_oneyear) {
		this.r64_oneyear = r64_oneyear;
	}
	public BigDecimal getR64_foreign() {
		return r64_foreign;
	}
	public void setR64_foreign(BigDecimal r64_foreign) {
		this.r64_foreign = r64_foreign;
	}
	public BigDecimal getR64_banks() {
		return r64_banks;
	}
	public void setR64_banks(BigDecimal r64_banks) {
		this.r64_banks = r64_banks;
	}
	public BigDecimal getR64_gov2() {
		return r64_gov2;
	}
	public void setR64_gov2(BigDecimal r64_gov2) {
		this.r64_gov2 = r64_gov2;
	}
	public BigDecimal getR64_other() {
		return r64_other;
	}
	public void setR64_other(BigDecimal r64_other) {
		this.r64_other = r64_other;
	}
	public BigDecimal getR64_banks1() {
		return r64_banks1;
	}
	public void setR64_banks1(BigDecimal r64_banks1) {
		this.r64_banks1 = r64_banks1;
	}
	public BigDecimal getR64_individuals2() {
		return r64_individuals2;
	}
	public void setR64_individuals2(BigDecimal r64_individuals2) {
		this.r64_individuals2 = r64_individuals2;
	}
	public BigDecimal getR64_other1() {
		return r64_other1;
	}
	public void setR64_other1(BigDecimal r64_other1) {
		this.r64_other1 = r64_other1;
	}
	public BigDecimal getR64_banks2() {
		return r64_banks2;
	}
	public void setR64_banks2(BigDecimal r64_banks2) {
		this.r64_banks2 = r64_banks2;
	}
	public BigDecimal getR64_gov3() {
		return r64_gov3;
	}
	public void setR64_gov3(BigDecimal r64_gov3) {
		this.r64_gov3 = r64_gov3;
	}
	public BigDecimal getR64_others2() {
		return r64_others2;
	}
	public void setR64_others2(BigDecimal r64_others2) {
		this.r64_others2 = r64_others2;
	}
	public BigDecimal getR64_banks3() {
		return r64_banks3;
	}
	public void setR64_banks3(BigDecimal r64_banks3) {
		this.r64_banks3 = r64_banks3;
	}
	public BigDecimal getR64_gov4() {
		return r64_gov4;
	}
	public void setR64_gov4(BigDecimal r64_gov4) {
		this.r64_gov4 = r64_gov4;
	}
	public BigDecimal getR64_others3() {
		return r64_others3;
	}
	public void setR64_others3(BigDecimal r64_others3) {
		this.r64_others3 = r64_others3;
	}
	public BigDecimal getR64_foreign1() {
		return r64_foreign1;
	}
	public void setR64_foreign1(BigDecimal r64_foreign1) {
		this.r64_foreign1 = r64_foreign1;
	}
	public BigDecimal getR64_guarantees() {
		return r64_guarantees;
	}
	public void setR64_guarantees(BigDecimal r64_guarantees) {
		this.r64_guarantees = r64_guarantees;
	}
	public BigDecimal getR64_nbfi2() {
		return r64_nbfi2;
	}
	public void setR64_nbfi2(BigDecimal r64_nbfi2) {
		this.r64_nbfi2 = r64_nbfi2;
	}
	public BigDecimal getR64_interbank2() {
		return r64_interbank2;
	}
	public void setR64_interbank2(BigDecimal r64_interbank2) {
		this.r64_interbank2 = r64_interbank2;
	}
	public BigDecimal getR64_gov5() {
		return r64_gov5;
	}
	public void setR64_gov5(BigDecimal r64_gov5) {
		this.r64_gov5 = r64_gov5;
	}
	public BigDecimal getR64_corporate2() {
		return r64_corporate2;
	}
	public void setR64_corporate2(BigDecimal r64_corporate2) {
		this.r64_corporate2 = r64_corporate2;
	}
	public BigDecimal getR64_gre2() {
		return r64_gre2;
	}
	public void setR64_gre2(BigDecimal r64_gre2) {
		this.r64_gre2 = r64_gre2;
	}
	public BigDecimal getR64_individuals3() {
		return r64_individuals3;
	}
	public void setR64_individuals3(BigDecimal r64_individuals3) {
		this.r64_individuals3 = r64_individuals3;
	}
	public BigDecimal getR64_zero1() {
		return r64_zero1;
	}
	public void setR64_zero1(BigDecimal r64_zero1) {
		this.r64_zero1 = r64_zero1;
	}
	public BigDecimal getR64_three1() {
		return r64_three1;
	}
	public void setR64_three1(BigDecimal r64_three1) {
		this.r64_three1 = r64_three1;
	}
	public BigDecimal getR64_six1() {
		return r64_six1;
	}
	public void setR64_six1(BigDecimal r64_six1) {
		this.r64_six1 = r64_six1;
	}
	public BigDecimal getR64_oneyear1() {
		return r64_oneyear1;
	}
	public void setR64_oneyear1(BigDecimal r64_oneyear1) {
		this.r64_oneyear1 = r64_oneyear1;
	}
	public String getR64_empty() {
		return r64_empty;
	}
	public void setR64_empty(String r64_empty) {
		this.r64_empty = r64_empty;
	}
	public String getR65_product() {
		return r65_product;
	}
	public void setR65_product(String r65_product) {
		this.r65_product = r65_product;
	}
	public BigDecimal getR65_nbfi() {
		return r65_nbfi;
	}
	public void setR65_nbfi(BigDecimal r65_nbfi) {
		this.r65_nbfi = r65_nbfi;
	}
	public BigDecimal getR65_interbank() {
		return r65_interbank;
	}
	public void setR65_interbank(BigDecimal r65_interbank) {
		this.r65_interbank = r65_interbank;
	}
	public BigDecimal getR65_gov() {
		return r65_gov;
	}
	public void setR65_gov(BigDecimal r65_gov) {
		this.r65_gov = r65_gov;
	}
	public BigDecimal getR65_corporate() {
		return r65_corporate;
	}
	public void setR65_corporate(BigDecimal r65_corporate) {
		this.r65_corporate = r65_corporate;
	}
	public BigDecimal getR65_gre() {
		return r65_gre;
	}
	public void setR65_gre(BigDecimal r65_gre) {
		this.r65_gre = r65_gre;
	}
	public BigDecimal getR65_trade() {
		return r65_trade;
	}
	public void setR65_trade(BigDecimal r65_trade) {
		this.r65_trade = r65_trade;
	}
	public BigDecimal getR65_individuals() {
		return r65_individuals;
	}
	public void setR65_individuals(BigDecimal r65_individuals) {
		this.r65_individuals = r65_individuals;
	}
	public BigDecimal getR65_investment() {
		return r65_investment;
	}
	public void setR65_investment(BigDecimal r65_investment) {
		this.r65_investment = r65_investment;
	}
	public BigDecimal getR65_nbfi1() {
		return r65_nbfi1;
	}
	public void setR65_nbfi1(BigDecimal r65_nbfi1) {
		this.r65_nbfi1 = r65_nbfi1;
	}
	public BigDecimal getR65_interbank1() {
		return r65_interbank1;
	}
	public void setR65_interbank1(BigDecimal r65_interbank1) {
		this.r65_interbank1 = r65_interbank1;
	}
	public BigDecimal getR65_gov1() {
		return r65_gov1;
	}
	public void setR65_gov1(BigDecimal r65_gov1) {
		this.r65_gov1 = r65_gov1;
	}
	public BigDecimal getR65_corporate1() {
		return r65_corporate1;
	}
	public void setR65_corporate1(BigDecimal r65_corporate1) {
		this.r65_corporate1 = r65_corporate1;
	}
	public BigDecimal getR65_gre1() {
		return r65_gre1;
	}
	public void setR65_gre1(BigDecimal r65_gre1) {
		this.r65_gre1 = r65_gre1;
	}
	public BigDecimal getR65_trade1() {
		return r65_trade1;
	}
	public void setR65_trade1(BigDecimal r65_trade1) {
		this.r65_trade1 = r65_trade1;
	}
	public BigDecimal getR65_individuals1() {
		return r65_individuals1;
	}
	public void setR65_individuals1(BigDecimal r65_individuals1) {
		this.r65_individuals1 = r65_individuals1;
	}
	public BigDecimal getR65_investment1() {
		return r65_investment1;
	}
	public void setR65_investment1(BigDecimal r65_investment1) {
		this.r65_investment1 = r65_investment1;
	}
	public BigDecimal getR65_zer0() {
		return r65_zer0;
	}
	public void setR65_zer0(BigDecimal r65_zer0) {
		this.r65_zer0 = r65_zer0;
	}
	public BigDecimal getR65_three() {
		return r65_three;
	}
	public void setR65_three(BigDecimal r65_three) {
		this.r65_three = r65_three;
	}
	public BigDecimal getR65_six() {
		return r65_six;
	}
	public void setR65_six(BigDecimal r65_six) {
		this.r65_six = r65_six;
	}
	public BigDecimal getR65_oneyear() {
		return r65_oneyear;
	}
	public void setR65_oneyear(BigDecimal r65_oneyear) {
		this.r65_oneyear = r65_oneyear;
	}
	public BigDecimal getR65_foreign() {
		return r65_foreign;
	}
	public void setR65_foreign(BigDecimal r65_foreign) {
		this.r65_foreign = r65_foreign;
	}
	public BigDecimal getR65_banks() {
		return r65_banks;
	}
	public void setR65_banks(BigDecimal r65_banks) {
		this.r65_banks = r65_banks;
	}
	public BigDecimal getR65_gov2() {
		return r65_gov2;
	}
	public void setR65_gov2(BigDecimal r65_gov2) {
		this.r65_gov2 = r65_gov2;
	}
	public BigDecimal getR65_other() {
		return r65_other;
	}
	public void setR65_other(BigDecimal r65_other) {
		this.r65_other = r65_other;
	}
	public BigDecimal getR65_banks1() {
		return r65_banks1;
	}
	public void setR65_banks1(BigDecimal r65_banks1) {
		this.r65_banks1 = r65_banks1;
	}
	public BigDecimal getR65_individuals2() {
		return r65_individuals2;
	}
	public void setR65_individuals2(BigDecimal r65_individuals2) {
		this.r65_individuals2 = r65_individuals2;
	}
	public BigDecimal getR65_other1() {
		return r65_other1;
	}
	public void setR65_other1(BigDecimal r65_other1) {
		this.r65_other1 = r65_other1;
	}
	public BigDecimal getR65_banks2() {
		return r65_banks2;
	}
	public void setR65_banks2(BigDecimal r65_banks2) {
		this.r65_banks2 = r65_banks2;
	}
	public BigDecimal getR65_gov3() {
		return r65_gov3;
	}
	public void setR65_gov3(BigDecimal r65_gov3) {
		this.r65_gov3 = r65_gov3;
	}
	public BigDecimal getR65_others2() {
		return r65_others2;
	}
	public void setR65_others2(BigDecimal r65_others2) {
		this.r65_others2 = r65_others2;
	}
	public BigDecimal getR65_banks3() {
		return r65_banks3;
	}
	public void setR65_banks3(BigDecimal r65_banks3) {
		this.r65_banks3 = r65_banks3;
	}
	public BigDecimal getR65_gov4() {
		return r65_gov4;
	}
	public void setR65_gov4(BigDecimal r65_gov4) {
		this.r65_gov4 = r65_gov4;
	}
	public BigDecimal getR65_others3() {
		return r65_others3;
	}
	public void setR65_others3(BigDecimal r65_others3) {
		this.r65_others3 = r65_others3;
	}
	public BigDecimal getR65_foreign1() {
		return r65_foreign1;
	}
	public void setR65_foreign1(BigDecimal r65_foreign1) {
		this.r65_foreign1 = r65_foreign1;
	}
	public BigDecimal getR65_guarantees() {
		return r65_guarantees;
	}
	public void setR65_guarantees(BigDecimal r65_guarantees) {
		this.r65_guarantees = r65_guarantees;
	}
	public BigDecimal getR65_nbfi2() {
		return r65_nbfi2;
	}
	public void setR65_nbfi2(BigDecimal r65_nbfi2) {
		this.r65_nbfi2 = r65_nbfi2;
	}
	public BigDecimal getR65_interbank2() {
		return r65_interbank2;
	}
	public void setR65_interbank2(BigDecimal r65_interbank2) {
		this.r65_interbank2 = r65_interbank2;
	}
	public BigDecimal getR65_gov5() {
		return r65_gov5;
	}
	public void setR65_gov5(BigDecimal r65_gov5) {
		this.r65_gov5 = r65_gov5;
	}
	public BigDecimal getR65_corporate2() {
		return r65_corporate2;
	}
	public void setR65_corporate2(BigDecimal r65_corporate2) {
		this.r65_corporate2 = r65_corporate2;
	}
	public BigDecimal getR65_gre2() {
		return r65_gre2;
	}
	public void setR65_gre2(BigDecimal r65_gre2) {
		this.r65_gre2 = r65_gre2;
	}
	public BigDecimal getR65_individuals3() {
		return r65_individuals3;
	}
	public void setR65_individuals3(BigDecimal r65_individuals3) {
		this.r65_individuals3 = r65_individuals3;
	}
	public BigDecimal getR65_zero1() {
		return r65_zero1;
	}
	public void setR65_zero1(BigDecimal r65_zero1) {
		this.r65_zero1 = r65_zero1;
	}
	public BigDecimal getR65_three1() {
		return r65_three1;
	}
	public void setR65_three1(BigDecimal r65_three1) {
		this.r65_three1 = r65_three1;
	}
	public BigDecimal getR65_six1() {
		return r65_six1;
	}
	public void setR65_six1(BigDecimal r65_six1) {
		this.r65_six1 = r65_six1;
	}
	public BigDecimal getR65_oneyear1() {
		return r65_oneyear1;
	}
	public void setR65_oneyear1(BigDecimal r65_oneyear1) {
		this.r65_oneyear1 = r65_oneyear1;
	}
	public String getR65_empty() {
		return r65_empty;
	}
	public void setR65_empty(String r65_empty) {
		this.r65_empty = r65_empty;
	}
	public String getR66_product() {
		return r66_product;
	}
	public void setR66_product(String r66_product) {
		this.r66_product = r66_product;
	}
	public BigDecimal getR66_nbfi() {
		return r66_nbfi;
	}
	public void setR66_nbfi(BigDecimal r66_nbfi) {
		this.r66_nbfi = r66_nbfi;
	}
	public BigDecimal getR66_interbank() {
		return r66_interbank;
	}
	public void setR66_interbank(BigDecimal r66_interbank) {
		this.r66_interbank = r66_interbank;
	}
	public BigDecimal getR66_gov() {
		return r66_gov;
	}
	public void setR66_gov(BigDecimal r66_gov) {
		this.r66_gov = r66_gov;
	}
	public BigDecimal getR66_corporate() {
		return r66_corporate;
	}
	public void setR66_corporate(BigDecimal r66_corporate) {
		this.r66_corporate = r66_corporate;
	}
	public BigDecimal getR66_gre() {
		return r66_gre;
	}
	public void setR66_gre(BigDecimal r66_gre) {
		this.r66_gre = r66_gre;
	}
	public BigDecimal getR66_trade() {
		return r66_trade;
	}
	public void setR66_trade(BigDecimal r66_trade) {
		this.r66_trade = r66_trade;
	}
	public BigDecimal getR66_individuals() {
		return r66_individuals;
	}
	public void setR66_individuals(BigDecimal r66_individuals) {
		this.r66_individuals = r66_individuals;
	}
	public BigDecimal getR66_investment() {
		return r66_investment;
	}
	public void setR66_investment(BigDecimal r66_investment) {
		this.r66_investment = r66_investment;
	}
	public BigDecimal getR66_nbfi1() {
		return r66_nbfi1;
	}
	public void setR66_nbfi1(BigDecimal r66_nbfi1) {
		this.r66_nbfi1 = r66_nbfi1;
	}
	public BigDecimal getR66_interbank1() {
		return r66_interbank1;
	}
	public void setR66_interbank1(BigDecimal r66_interbank1) {
		this.r66_interbank1 = r66_interbank1;
	}
	public BigDecimal getR66_gov1() {
		return r66_gov1;
	}
	public void setR66_gov1(BigDecimal r66_gov1) {
		this.r66_gov1 = r66_gov1;
	}
	public BigDecimal getR66_corporate1() {
		return r66_corporate1;
	}
	public void setR66_corporate1(BigDecimal r66_corporate1) {
		this.r66_corporate1 = r66_corporate1;
	}
	public BigDecimal getR66_gre1() {
		return r66_gre1;
	}
	public void setR66_gre1(BigDecimal r66_gre1) {
		this.r66_gre1 = r66_gre1;
	}
	public BigDecimal getR66_trade1() {
		return r66_trade1;
	}
	public void setR66_trade1(BigDecimal r66_trade1) {
		this.r66_trade1 = r66_trade1;
	}
	public BigDecimal getR66_individuals1() {
		return r66_individuals1;
	}
	public void setR66_individuals1(BigDecimal r66_individuals1) {
		this.r66_individuals1 = r66_individuals1;
	}
	public BigDecimal getR66_investment1() {
		return r66_investment1;
	}
	public void setR66_investment1(BigDecimal r66_investment1) {
		this.r66_investment1 = r66_investment1;
	}
	public BigDecimal getR66_zer0() {
		return r66_zer0;
	}
	public void setR66_zer0(BigDecimal r66_zer0) {
		this.r66_zer0 = r66_zer0;
	}
	public BigDecimal getR66_three() {
		return r66_three;
	}
	public void setR66_three(BigDecimal r66_three) {
		this.r66_three = r66_three;
	}
	public BigDecimal getR66_six() {
		return r66_six;
	}
	public void setR66_six(BigDecimal r66_six) {
		this.r66_six = r66_six;
	}
	public BigDecimal getR66_oneyear() {
		return r66_oneyear;
	}
	public void setR66_oneyear(BigDecimal r66_oneyear) {
		this.r66_oneyear = r66_oneyear;
	}
	public BigDecimal getR66_foreign() {
		return r66_foreign;
	}
	public void setR66_foreign(BigDecimal r66_foreign) {
		this.r66_foreign = r66_foreign;
	}
	public BigDecimal getR66_banks() {
		return r66_banks;
	}
	public void setR66_banks(BigDecimal r66_banks) {
		this.r66_banks = r66_banks;
	}
	public BigDecimal getR66_gov2() {
		return r66_gov2;
	}
	public void setR66_gov2(BigDecimal r66_gov2) {
		this.r66_gov2 = r66_gov2;
	}
	public BigDecimal getR66_other() {
		return r66_other;
	}
	public void setR66_other(BigDecimal r66_other) {
		this.r66_other = r66_other;
	}
	public BigDecimal getR66_banks1() {
		return r66_banks1;
	}
	public void setR66_banks1(BigDecimal r66_banks1) {
		this.r66_banks1 = r66_banks1;
	}
	public BigDecimal getR66_individuals2() {
		return r66_individuals2;
	}
	public void setR66_individuals2(BigDecimal r66_individuals2) {
		this.r66_individuals2 = r66_individuals2;
	}
	public BigDecimal getR66_other1() {
		return r66_other1;
	}
	public void setR66_other1(BigDecimal r66_other1) {
		this.r66_other1 = r66_other1;
	}
	public BigDecimal getR66_banks2() {
		return r66_banks2;
	}
	public void setR66_banks2(BigDecimal r66_banks2) {
		this.r66_banks2 = r66_banks2;
	}
	public BigDecimal getR66_gov3() {
		return r66_gov3;
	}
	public void setR66_gov3(BigDecimal r66_gov3) {
		this.r66_gov3 = r66_gov3;
	}
	public BigDecimal getR66_others2() {
		return r66_others2;
	}
	public void setR66_others2(BigDecimal r66_others2) {
		this.r66_others2 = r66_others2;
	}
	public BigDecimal getR66_banks3() {
		return r66_banks3;
	}
	public void setR66_banks3(BigDecimal r66_banks3) {
		this.r66_banks3 = r66_banks3;
	}
	public BigDecimal getR66_gov4() {
		return r66_gov4;
	}
	public void setR66_gov4(BigDecimal r66_gov4) {
		this.r66_gov4 = r66_gov4;
	}
	public BigDecimal getR66_others3() {
		return r66_others3;
	}
	public void setR66_others3(BigDecimal r66_others3) {
		this.r66_others3 = r66_others3;
	}
	public BigDecimal getR66_foreign1() {
		return r66_foreign1;
	}
	public void setR66_foreign1(BigDecimal r66_foreign1) {
		this.r66_foreign1 = r66_foreign1;
	}
	public BigDecimal getR66_guarantees() {
		return r66_guarantees;
	}
	public void setR66_guarantees(BigDecimal r66_guarantees) {
		this.r66_guarantees = r66_guarantees;
	}
	public BigDecimal getR66_nbfi2() {
		return r66_nbfi2;
	}
	public void setR66_nbfi2(BigDecimal r66_nbfi2) {
		this.r66_nbfi2 = r66_nbfi2;
	}
	public BigDecimal getR66_interbank2() {
		return r66_interbank2;
	}
	public void setR66_interbank2(BigDecimal r66_interbank2) {
		this.r66_interbank2 = r66_interbank2;
	}
	public BigDecimal getR66_gov5() {
		return r66_gov5;
	}
	public void setR66_gov5(BigDecimal r66_gov5) {
		this.r66_gov5 = r66_gov5;
	}
	public BigDecimal getR66_corporate2() {
		return r66_corporate2;
	}
	public void setR66_corporate2(BigDecimal r66_corporate2) {
		this.r66_corporate2 = r66_corporate2;
	}
	public BigDecimal getR66_gre2() {
		return r66_gre2;
	}
	public void setR66_gre2(BigDecimal r66_gre2) {
		this.r66_gre2 = r66_gre2;
	}
	public BigDecimal getR66_individuals3() {
		return r66_individuals3;
	}
	public void setR66_individuals3(BigDecimal r66_individuals3) {
		this.r66_individuals3 = r66_individuals3;
	}
	public BigDecimal getR66_zero1() {
		return r66_zero1;
	}
	public void setR66_zero1(BigDecimal r66_zero1) {
		this.r66_zero1 = r66_zero1;
	}
	public BigDecimal getR66_three1() {
		return r66_three1;
	}
	public void setR66_three1(BigDecimal r66_three1) {
		this.r66_three1 = r66_three1;
	}
	public BigDecimal getR66_six1() {
		return r66_six1;
	}
	public void setR66_six1(BigDecimal r66_six1) {
		this.r66_six1 = r66_six1;
	}
	public BigDecimal getR66_oneyear1() {
		return r66_oneyear1;
	}
	public void setR66_oneyear1(BigDecimal r66_oneyear1) {
		this.r66_oneyear1 = r66_oneyear1;
	}
	public String getR66_empty() {
		return r66_empty;
	}
	public void setR66_empty(String r66_empty) {
		this.r66_empty = r66_empty;
	}
	public String getR67_product() {
		return r67_product;
	}
	public void setR67_product(String r67_product) {
		this.r67_product = r67_product;
	}
	public BigDecimal getR67_nbfi() {
		return r67_nbfi;
	}
	public void setR67_nbfi(BigDecimal r67_nbfi) {
		this.r67_nbfi = r67_nbfi;
	}
	public BigDecimal getR67_interbank() {
		return r67_interbank;
	}
	public void setR67_interbank(BigDecimal r67_interbank) {
		this.r67_interbank = r67_interbank;
	}
	public BigDecimal getR67_gov() {
		return r67_gov;
	}
	public void setR67_gov(BigDecimal r67_gov) {
		this.r67_gov = r67_gov;
	}
	public BigDecimal getR67_corporate() {
		return r67_corporate;
	}
	public void setR67_corporate(BigDecimal r67_corporate) {
		this.r67_corporate = r67_corporate;
	}
	public BigDecimal getR67_gre() {
		return r67_gre;
	}
	public void setR67_gre(BigDecimal r67_gre) {
		this.r67_gre = r67_gre;
	}
	public BigDecimal getR67_trade() {
		return r67_trade;
	}
	public void setR67_trade(BigDecimal r67_trade) {
		this.r67_trade = r67_trade;
	}
	public BigDecimal getR67_individuals() {
		return r67_individuals;
	}
	public void setR67_individuals(BigDecimal r67_individuals) {
		this.r67_individuals = r67_individuals;
	}
	public BigDecimal getR67_investment() {
		return r67_investment;
	}
	public void setR67_investment(BigDecimal r67_investment) {
		this.r67_investment = r67_investment;
	}
	public BigDecimal getR67_nbfi1() {
		return r67_nbfi1;
	}
	public void setR67_nbfi1(BigDecimal r67_nbfi1) {
		this.r67_nbfi1 = r67_nbfi1;
	}
	public BigDecimal getR67_interbank1() {
		return r67_interbank1;
	}
	public void setR67_interbank1(BigDecimal r67_interbank1) {
		this.r67_interbank1 = r67_interbank1;
	}
	public BigDecimal getR67_gov1() {
		return r67_gov1;
	}
	public void setR67_gov1(BigDecimal r67_gov1) {
		this.r67_gov1 = r67_gov1;
	}
	public BigDecimal getR67_corporate1() {
		return r67_corporate1;
	}
	public void setR67_corporate1(BigDecimal r67_corporate1) {
		this.r67_corporate1 = r67_corporate1;
	}
	public BigDecimal getR67_gre1() {
		return r67_gre1;
	}
	public void setR67_gre1(BigDecimal r67_gre1) {
		this.r67_gre1 = r67_gre1;
	}
	public BigDecimal getR67_trade1() {
		return r67_trade1;
	}
	public void setR67_trade1(BigDecimal r67_trade1) {
		this.r67_trade1 = r67_trade1;
	}
	public BigDecimal getR67_individuals1() {
		return r67_individuals1;
	}
	public void setR67_individuals1(BigDecimal r67_individuals1) {
		this.r67_individuals1 = r67_individuals1;
	}
	public BigDecimal getR67_investment1() {
		return r67_investment1;
	}
	public void setR67_investment1(BigDecimal r67_investment1) {
		this.r67_investment1 = r67_investment1;
	}
	public BigDecimal getR67_zer0() {
		return r67_zer0;
	}
	public void setR67_zer0(BigDecimal r67_zer0) {
		this.r67_zer0 = r67_zer0;
	}
	public BigDecimal getR67_three() {
		return r67_three;
	}
	public void setR67_three(BigDecimal r67_three) {
		this.r67_three = r67_three;
	}
	public BigDecimal getR67_six() {
		return r67_six;
	}
	public void setR67_six(BigDecimal r67_six) {
		this.r67_six = r67_six;
	}
	public BigDecimal getR67_oneyear() {
		return r67_oneyear;
	}
	public void setR67_oneyear(BigDecimal r67_oneyear) {
		this.r67_oneyear = r67_oneyear;
	}
	public BigDecimal getR67_foreign() {
		return r67_foreign;
	}
	public void setR67_foreign(BigDecimal r67_foreign) {
		this.r67_foreign = r67_foreign;
	}
	public BigDecimal getR67_banks() {
		return r67_banks;
	}
	public void setR67_banks(BigDecimal r67_banks) {
		this.r67_banks = r67_banks;
	}
	public BigDecimal getR67_gov2() {
		return r67_gov2;
	}
	public void setR67_gov2(BigDecimal r67_gov2) {
		this.r67_gov2 = r67_gov2;
	}
	public BigDecimal getR67_other() {
		return r67_other;
	}
	public void setR67_other(BigDecimal r67_other) {
		this.r67_other = r67_other;
	}
	public BigDecimal getR67_banks1() {
		return r67_banks1;
	}
	public void setR67_banks1(BigDecimal r67_banks1) {
		this.r67_banks1 = r67_banks1;
	}
	public BigDecimal getR67_individuals2() {
		return r67_individuals2;
	}
	public void setR67_individuals2(BigDecimal r67_individuals2) {
		this.r67_individuals2 = r67_individuals2;
	}
	public BigDecimal getR67_other1() {
		return r67_other1;
	}
	public void setR67_other1(BigDecimal r67_other1) {
		this.r67_other1 = r67_other1;
	}
	public BigDecimal getR67_banks2() {
		return r67_banks2;
	}
	public void setR67_banks2(BigDecimal r67_banks2) {
		this.r67_banks2 = r67_banks2;
	}
	public BigDecimal getR67_gov3() {
		return r67_gov3;
	}
	public void setR67_gov3(BigDecimal r67_gov3) {
		this.r67_gov3 = r67_gov3;
	}
	public BigDecimal getR67_others2() {
		return r67_others2;
	}
	public void setR67_others2(BigDecimal r67_others2) {
		this.r67_others2 = r67_others2;
	}
	public BigDecimal getR67_banks3() {
		return r67_banks3;
	}
	public void setR67_banks3(BigDecimal r67_banks3) {
		this.r67_banks3 = r67_banks3;
	}
	public BigDecimal getR67_gov4() {
		return r67_gov4;
	}
	public void setR67_gov4(BigDecimal r67_gov4) {
		this.r67_gov4 = r67_gov4;
	}
	public BigDecimal getR67_others3() {
		return r67_others3;
	}
	public void setR67_others3(BigDecimal r67_others3) {
		this.r67_others3 = r67_others3;
	}
	public BigDecimal getR67_foreign1() {
		return r67_foreign1;
	}
	public void setR67_foreign1(BigDecimal r67_foreign1) {
		this.r67_foreign1 = r67_foreign1;
	}
	public BigDecimal getR67_guarantees() {
		return r67_guarantees;
	}
	public void setR67_guarantees(BigDecimal r67_guarantees) {
		this.r67_guarantees = r67_guarantees;
	}
	public BigDecimal getR67_nbfi2() {
		return r67_nbfi2;
	}
	public void setR67_nbfi2(BigDecimal r67_nbfi2) {
		this.r67_nbfi2 = r67_nbfi2;
	}
	public BigDecimal getR67_interbank2() {
		return r67_interbank2;
	}
	public void setR67_interbank2(BigDecimal r67_interbank2) {
		this.r67_interbank2 = r67_interbank2;
	}
	public BigDecimal getR67_gov5() {
		return r67_gov5;
	}
	public void setR67_gov5(BigDecimal r67_gov5) {
		this.r67_gov5 = r67_gov5;
	}
	public BigDecimal getR67_corporate2() {
		return r67_corporate2;
	}
	public void setR67_corporate2(BigDecimal r67_corporate2) {
		this.r67_corporate2 = r67_corporate2;
	}
	public BigDecimal getR67_gre2() {
		return r67_gre2;
	}
	public void setR67_gre2(BigDecimal r67_gre2) {
		this.r67_gre2 = r67_gre2;
	}
	public BigDecimal getR67_individuals3() {
		return r67_individuals3;
	}
	public void setR67_individuals3(BigDecimal r67_individuals3) {
		this.r67_individuals3 = r67_individuals3;
	}
	public BigDecimal getR67_zero1() {
		return r67_zero1;
	}
	public void setR67_zero1(BigDecimal r67_zero1) {
		this.r67_zero1 = r67_zero1;
	}
	public BigDecimal getR67_three1() {
		return r67_three1;
	}
	public void setR67_three1(BigDecimal r67_three1) {
		this.r67_three1 = r67_three1;
	}
	public BigDecimal getR67_six1() {
		return r67_six1;
	}
	public void setR67_six1(BigDecimal r67_six1) {
		this.r67_six1 = r67_six1;
	}
	public BigDecimal getR67_oneyear1() {
		return r67_oneyear1;
	}
	public void setR67_oneyear1(BigDecimal r67_oneyear1) {
		this.r67_oneyear1 = r67_oneyear1;
	}
	public String getR67_empty() {
		return r67_empty;
	}
	public void setR67_empty(String r67_empty) {
		this.r67_empty = r67_empty;
	}
	public String getR68_product() {
		return r68_product;
	}
	public void setR68_product(String r68_product) {
		this.r68_product = r68_product;
	}
	public BigDecimal getR68_nbfi() {
		return r68_nbfi;
	}
	public void setR68_nbfi(BigDecimal r68_nbfi) {
		this.r68_nbfi = r68_nbfi;
	}
	public BigDecimal getR68_interbank() {
		return r68_interbank;
	}
	public void setR68_interbank(BigDecimal r68_interbank) {
		this.r68_interbank = r68_interbank;
	}
	public BigDecimal getR68_gov() {
		return r68_gov;
	}
	public void setR68_gov(BigDecimal r68_gov) {
		this.r68_gov = r68_gov;
	}
	public BigDecimal getR68_corporate() {
		return r68_corporate;
	}
	public void setR68_corporate(BigDecimal r68_corporate) {
		this.r68_corporate = r68_corporate;
	}
	public BigDecimal getR68_gre() {
		return r68_gre;
	}
	public void setR68_gre(BigDecimal r68_gre) {
		this.r68_gre = r68_gre;
	}
	public BigDecimal getR68_trade() {
		return r68_trade;
	}
	public void setR68_trade(BigDecimal r68_trade) {
		this.r68_trade = r68_trade;
	}
	public BigDecimal getR68_individuals() {
		return r68_individuals;
	}
	public void setR68_individuals(BigDecimal r68_individuals) {
		this.r68_individuals = r68_individuals;
	}
	public BigDecimal getR68_investment() {
		return r68_investment;
	}
	public void setR68_investment(BigDecimal r68_investment) {
		this.r68_investment = r68_investment;
	}
	public BigDecimal getR68_nbfi1() {
		return r68_nbfi1;
	}
	public void setR68_nbfi1(BigDecimal r68_nbfi1) {
		this.r68_nbfi1 = r68_nbfi1;
	}
	public BigDecimal getR68_interbank1() {
		return r68_interbank1;
	}
	public void setR68_interbank1(BigDecimal r68_interbank1) {
		this.r68_interbank1 = r68_interbank1;
	}
	public BigDecimal getR68_gov1() {
		return r68_gov1;
	}
	public void setR68_gov1(BigDecimal r68_gov1) {
		this.r68_gov1 = r68_gov1;
	}
	public BigDecimal getR68_corporate1() {
		return r68_corporate1;
	}
	public void setR68_corporate1(BigDecimal r68_corporate1) {
		this.r68_corporate1 = r68_corporate1;
	}
	public BigDecimal getR68_gre1() {
		return r68_gre1;
	}
	public void setR68_gre1(BigDecimal r68_gre1) {
		this.r68_gre1 = r68_gre1;
	}
	public BigDecimal getR68_trade1() {
		return r68_trade1;
	}
	public void setR68_trade1(BigDecimal r68_trade1) {
		this.r68_trade1 = r68_trade1;
	}
	public BigDecimal getR68_individuals1() {
		return r68_individuals1;
	}
	public void setR68_individuals1(BigDecimal r68_individuals1) {
		this.r68_individuals1 = r68_individuals1;
	}
	public BigDecimal getR68_investment1() {
		return r68_investment1;
	}
	public void setR68_investment1(BigDecimal r68_investment1) {
		this.r68_investment1 = r68_investment1;
	}
	public BigDecimal getR68_zer0() {
		return r68_zer0;
	}
	public void setR68_zer0(BigDecimal r68_zer0) {
		this.r68_zer0 = r68_zer0;
	}
	public BigDecimal getR68_three() {
		return r68_three;
	}
	public void setR68_three(BigDecimal r68_three) {
		this.r68_three = r68_three;
	}
	public BigDecimal getR68_six() {
		return r68_six;
	}
	public void setR68_six(BigDecimal r68_six) {
		this.r68_six = r68_six;
	}
	public BigDecimal getR68_oneyear() {
		return r68_oneyear;
	}
	public void setR68_oneyear(BigDecimal r68_oneyear) {
		this.r68_oneyear = r68_oneyear;
	}
	public BigDecimal getR68_foreign() {
		return r68_foreign;
	}
	public void setR68_foreign(BigDecimal r68_foreign) {
		this.r68_foreign = r68_foreign;
	}
	public BigDecimal getR68_banks() {
		return r68_banks;
	}
	public void setR68_banks(BigDecimal r68_banks) {
		this.r68_banks = r68_banks;
	}
	public BigDecimal getR68_gov2() {
		return r68_gov2;
	}
	public void setR68_gov2(BigDecimal r68_gov2) {
		this.r68_gov2 = r68_gov2;
	}
	public BigDecimal getR68_other() {
		return r68_other;
	}
	public void setR68_other(BigDecimal r68_other) {
		this.r68_other = r68_other;
	}
	public BigDecimal getR68_banks1() {
		return r68_banks1;
	}
	public void setR68_banks1(BigDecimal r68_banks1) {
		this.r68_banks1 = r68_banks1;
	}
	public BigDecimal getR68_individuals2() {
		return r68_individuals2;
	}
	public void setR68_individuals2(BigDecimal r68_individuals2) {
		this.r68_individuals2 = r68_individuals2;
	}
	public BigDecimal getR68_other1() {
		return r68_other1;
	}
	public void setR68_other1(BigDecimal r68_other1) {
		this.r68_other1 = r68_other1;
	}
	public BigDecimal getR68_banks2() {
		return r68_banks2;
	}
	public void setR68_banks2(BigDecimal r68_banks2) {
		this.r68_banks2 = r68_banks2;
	}
	public BigDecimal getR68_gov3() {
		return r68_gov3;
	}
	public void setR68_gov3(BigDecimal r68_gov3) {
		this.r68_gov3 = r68_gov3;
	}
	public BigDecimal getR68_others2() {
		return r68_others2;
	}
	public void setR68_others2(BigDecimal r68_others2) {
		this.r68_others2 = r68_others2;
	}
	public BigDecimal getR68_banks3() {
		return r68_banks3;
	}
	public void setR68_banks3(BigDecimal r68_banks3) {
		this.r68_banks3 = r68_banks3;
	}
	public BigDecimal getR68_gov4() {
		return r68_gov4;
	}
	public void setR68_gov4(BigDecimal r68_gov4) {
		this.r68_gov4 = r68_gov4;
	}
	public BigDecimal getR68_others3() {
		return r68_others3;
	}
	public void setR68_others3(BigDecimal r68_others3) {
		this.r68_others3 = r68_others3;
	}
	public BigDecimal getR68_foreign1() {
		return r68_foreign1;
	}
	public void setR68_foreign1(BigDecimal r68_foreign1) {
		this.r68_foreign1 = r68_foreign1;
	}
	public BigDecimal getR68_guarantees() {
		return r68_guarantees;
	}
	public void setR68_guarantees(BigDecimal r68_guarantees) {
		this.r68_guarantees = r68_guarantees;
	}
	public BigDecimal getR68_nbfi2() {
		return r68_nbfi2;
	}
	public void setR68_nbfi2(BigDecimal r68_nbfi2) {
		this.r68_nbfi2 = r68_nbfi2;
	}
	public BigDecimal getR68_interbank2() {
		return r68_interbank2;
	}
	public void setR68_interbank2(BigDecimal r68_interbank2) {
		this.r68_interbank2 = r68_interbank2;
	}
	public BigDecimal getR68_gov5() {
		return r68_gov5;
	}
	public void setR68_gov5(BigDecimal r68_gov5) {
		this.r68_gov5 = r68_gov5;
	}
	public BigDecimal getR68_corporate2() {
		return r68_corporate2;
	}
	public void setR68_corporate2(BigDecimal r68_corporate2) {
		this.r68_corporate2 = r68_corporate2;
	}
	public BigDecimal getR68_gre2() {
		return r68_gre2;
	}
	public void setR68_gre2(BigDecimal r68_gre2) {
		this.r68_gre2 = r68_gre2;
	}
	public BigDecimal getR68_individuals3() {
		return r68_individuals3;
	}
	public void setR68_individuals3(BigDecimal r68_individuals3) {
		this.r68_individuals3 = r68_individuals3;
	}
	public BigDecimal getR68_zero1() {
		return r68_zero1;
	}
	public void setR68_zero1(BigDecimal r68_zero1) {
		this.r68_zero1 = r68_zero1;
	}
	public BigDecimal getR68_three1() {
		return r68_three1;
	}
	public void setR68_three1(BigDecimal r68_three1) {
		this.r68_three1 = r68_three1;
	}
	public BigDecimal getR68_six1() {
		return r68_six1;
	}
	public void setR68_six1(BigDecimal r68_six1) {
		this.r68_six1 = r68_six1;
	}
	public BigDecimal getR68_oneyear1() {
		return r68_oneyear1;
	}
	public void setR68_oneyear1(BigDecimal r68_oneyear1) {
		this.r68_oneyear1 = r68_oneyear1;
	}
	public String getR68_empty() {
		return r68_empty;
	}
	public void setR68_empty(String r68_empty) {
		this.r68_empty = r68_empty;
	}
	public String getR69_product() {
		return r69_product;
	}
	public void setR69_product(String r69_product) {
		this.r69_product = r69_product;
	}
	public BigDecimal getR69_nbfi() {
		return r69_nbfi;
	}
	public void setR69_nbfi(BigDecimal r69_nbfi) {
		this.r69_nbfi = r69_nbfi;
	}
	public BigDecimal getR69_interbank() {
		return r69_interbank;
	}
	public void setR69_interbank(BigDecimal r69_interbank) {
		this.r69_interbank = r69_interbank;
	}
	public BigDecimal getR69_gov() {
		return r69_gov;
	}
	public void setR69_gov(BigDecimal r69_gov) {
		this.r69_gov = r69_gov;
	}
	public BigDecimal getR69_corporate() {
		return r69_corporate;
	}
	public void setR69_corporate(BigDecimal r69_corporate) {
		this.r69_corporate = r69_corporate;
	}
	public BigDecimal getR69_gre() {
		return r69_gre;
	}
	public void setR69_gre(BigDecimal r69_gre) {
		this.r69_gre = r69_gre;
	}
	public BigDecimal getR69_trade() {
		return r69_trade;
	}
	public void setR69_trade(BigDecimal r69_trade) {
		this.r69_trade = r69_trade;
	}
	public BigDecimal getR69_individuals() {
		return r69_individuals;
	}
	public void setR69_individuals(BigDecimal r69_individuals) {
		this.r69_individuals = r69_individuals;
	}
	public BigDecimal getR69_investment() {
		return r69_investment;
	}
	public void setR69_investment(BigDecimal r69_investment) {
		this.r69_investment = r69_investment;
	}
	public BigDecimal getR69_nbfi1() {
		return r69_nbfi1;
	}
	public void setR69_nbfi1(BigDecimal r69_nbfi1) {
		this.r69_nbfi1 = r69_nbfi1;
	}
	public BigDecimal getR69_interbank1() {
		return r69_interbank1;
	}
	public void setR69_interbank1(BigDecimal r69_interbank1) {
		this.r69_interbank1 = r69_interbank1;
	}
	public BigDecimal getR69_gov1() {
		return r69_gov1;
	}
	public void setR69_gov1(BigDecimal r69_gov1) {
		this.r69_gov1 = r69_gov1;
	}
	public BigDecimal getR69_corporate1() {
		return r69_corporate1;
	}
	public void setR69_corporate1(BigDecimal r69_corporate1) {
		this.r69_corporate1 = r69_corporate1;
	}
	public BigDecimal getR69_gre1() {
		return r69_gre1;
	}
	public void setR69_gre1(BigDecimal r69_gre1) {
		this.r69_gre1 = r69_gre1;
	}
	public BigDecimal getR69_trade1() {
		return r69_trade1;
	}
	public void setR69_trade1(BigDecimal r69_trade1) {
		this.r69_trade1 = r69_trade1;
	}
	public BigDecimal getR69_individuals1() {
		return r69_individuals1;
	}
	public void setR69_individuals1(BigDecimal r69_individuals1) {
		this.r69_individuals1 = r69_individuals1;
	}
	public BigDecimal getR69_investment1() {
		return r69_investment1;
	}
	public void setR69_investment1(BigDecimal r69_investment1) {
		this.r69_investment1 = r69_investment1;
	}
	public BigDecimal getR69_zer0() {
		return r69_zer0;
	}
	public void setR69_zer0(BigDecimal r69_zer0) {
		this.r69_zer0 = r69_zer0;
	}
	public BigDecimal getR69_three() {
		return r69_three;
	}
	public void setR69_three(BigDecimal r69_three) {
		this.r69_three = r69_three;
	}
	public BigDecimal getR69_six() {
		return r69_six;
	}
	public void setR69_six(BigDecimal r69_six) {
		this.r69_six = r69_six;
	}
	public BigDecimal getR69_oneyear() {
		return r69_oneyear;
	}
	public void setR69_oneyear(BigDecimal r69_oneyear) {
		this.r69_oneyear = r69_oneyear;
	}
	public BigDecimal getR69_foreign() {
		return r69_foreign;
	}
	public void setR69_foreign(BigDecimal r69_foreign) {
		this.r69_foreign = r69_foreign;
	}
	public BigDecimal getR69_banks() {
		return r69_banks;
	}
	public void setR69_banks(BigDecimal r69_banks) {
		this.r69_banks = r69_banks;
	}
	public BigDecimal getR69_gov2() {
		return r69_gov2;
	}
	public void setR69_gov2(BigDecimal r69_gov2) {
		this.r69_gov2 = r69_gov2;
	}
	public BigDecimal getR69_other() {
		return r69_other;
	}
	public void setR69_other(BigDecimal r69_other) {
		this.r69_other = r69_other;
	}
	public BigDecimal getR69_banks1() {
		return r69_banks1;
	}
	public void setR69_banks1(BigDecimal r69_banks1) {
		this.r69_banks1 = r69_banks1;
	}
	public BigDecimal getR69_individuals2() {
		return r69_individuals2;
	}
	public void setR69_individuals2(BigDecimal r69_individuals2) {
		this.r69_individuals2 = r69_individuals2;
	}
	public BigDecimal getR69_other1() {
		return r69_other1;
	}
	public void setR69_other1(BigDecimal r69_other1) {
		this.r69_other1 = r69_other1;
	}
	public BigDecimal getR69_banks2() {
		return r69_banks2;
	}
	public void setR69_banks2(BigDecimal r69_banks2) {
		this.r69_banks2 = r69_banks2;
	}
	public BigDecimal getR69_gov3() {
		return r69_gov3;
	}
	public void setR69_gov3(BigDecimal r69_gov3) {
		this.r69_gov3 = r69_gov3;
	}
	public BigDecimal getR69_others2() {
		return r69_others2;
	}
	public void setR69_others2(BigDecimal r69_others2) {
		this.r69_others2 = r69_others2;
	}
	public BigDecimal getR69_banks3() {
		return r69_banks3;
	}
	public void setR69_banks3(BigDecimal r69_banks3) {
		this.r69_banks3 = r69_banks3;
	}
	public BigDecimal getR69_gov4() {
		return r69_gov4;
	}
	public void setR69_gov4(BigDecimal r69_gov4) {
		this.r69_gov4 = r69_gov4;
	}
	public BigDecimal getR69_others3() {
		return r69_others3;
	}
	public void setR69_others3(BigDecimal r69_others3) {
		this.r69_others3 = r69_others3;
	}
	public BigDecimal getR69_foreign1() {
		return r69_foreign1;
	}
	public void setR69_foreign1(BigDecimal r69_foreign1) {
		this.r69_foreign1 = r69_foreign1;
	}
	public BigDecimal getR69_guarantees() {
		return r69_guarantees;
	}
	public void setR69_guarantees(BigDecimal r69_guarantees) {
		this.r69_guarantees = r69_guarantees;
	}
	public BigDecimal getR69_nbfi2() {
		return r69_nbfi2;
	}
	public void setR69_nbfi2(BigDecimal r69_nbfi2) {
		this.r69_nbfi2 = r69_nbfi2;
	}
	public BigDecimal getR69_interbank2() {
		return r69_interbank2;
	}
	public void setR69_interbank2(BigDecimal r69_interbank2) {
		this.r69_interbank2 = r69_interbank2;
	}
	public BigDecimal getR69_gov5() {
		return r69_gov5;
	}
	public void setR69_gov5(BigDecimal r69_gov5) {
		this.r69_gov5 = r69_gov5;
	}
	public BigDecimal getR69_corporate2() {
		return r69_corporate2;
	}
	public void setR69_corporate2(BigDecimal r69_corporate2) {
		this.r69_corporate2 = r69_corporate2;
	}
	public BigDecimal getR69_gre2() {
		return r69_gre2;
	}
	public void setR69_gre2(BigDecimal r69_gre2) {
		this.r69_gre2 = r69_gre2;
	}
	public BigDecimal getR69_individuals3() {
		return r69_individuals3;
	}
	public void setR69_individuals3(BigDecimal r69_individuals3) {
		this.r69_individuals3 = r69_individuals3;
	}
	public BigDecimal getR69_zero1() {
		return r69_zero1;
	}
	public void setR69_zero1(BigDecimal r69_zero1) {
		this.r69_zero1 = r69_zero1;
	}
	public BigDecimal getR69_three1() {
		return r69_three1;
	}
	public void setR69_three1(BigDecimal r69_three1) {
		this.r69_three1 = r69_three1;
	}
	public BigDecimal getR69_six1() {
		return r69_six1;
	}
	public void setR69_six1(BigDecimal r69_six1) {
		this.r69_six1 = r69_six1;
	}
	public BigDecimal getR69_oneyear1() {
		return r69_oneyear1;
	}
	public void setR69_oneyear1(BigDecimal r69_oneyear1) {
		this.r69_oneyear1 = r69_oneyear1;
	}
	public String getR69_empty() {
		return r69_empty;
	}
	public void setR69_empty(String r69_empty) {
		this.r69_empty = r69_empty;
	}
	public String getR70_product() {
		return r70_product;
	}
	public void setR70_product(String r70_product) {
		this.r70_product = r70_product;
	}
	public BigDecimal getR70_nbfi() {
		return r70_nbfi;
	}
	public void setR70_nbfi(BigDecimal r70_nbfi) {
		this.r70_nbfi = r70_nbfi;
	}
	public BigDecimal getR70_interbank() {
		return r70_interbank;
	}
	public void setR70_interbank(BigDecimal r70_interbank) {
		this.r70_interbank = r70_interbank;
	}
	public BigDecimal getR70_gov() {
		return r70_gov;
	}
	public void setR70_gov(BigDecimal r70_gov) {
		this.r70_gov = r70_gov;
	}
	public BigDecimal getR70_corporate() {
		return r70_corporate;
	}
	public void setR70_corporate(BigDecimal r70_corporate) {
		this.r70_corporate = r70_corporate;
	}
	public BigDecimal getR70_gre() {
		return r70_gre;
	}
	public void setR70_gre(BigDecimal r70_gre) {
		this.r70_gre = r70_gre;
	}
	public BigDecimal getR70_trade() {
		return r70_trade;
	}
	public void setR70_trade(BigDecimal r70_trade) {
		this.r70_trade = r70_trade;
	}
	public BigDecimal getR70_individuals() {
		return r70_individuals;
	}
	public void setR70_individuals(BigDecimal r70_individuals) {
		this.r70_individuals = r70_individuals;
	}
	public BigDecimal getR70_investment() {
		return r70_investment;
	}
	public void setR70_investment(BigDecimal r70_investment) {
		this.r70_investment = r70_investment;
	}
	public BigDecimal getR70_nbfi1() {
		return r70_nbfi1;
	}
	public void setR70_nbfi1(BigDecimal r70_nbfi1) {
		this.r70_nbfi1 = r70_nbfi1;
	}
	public BigDecimal getR70_interbank1() {
		return r70_interbank1;
	}
	public void setR70_interbank1(BigDecimal r70_interbank1) {
		this.r70_interbank1 = r70_interbank1;
	}
	public BigDecimal getR70_gov1() {
		return r70_gov1;
	}
	public void setR70_gov1(BigDecimal r70_gov1) {
		this.r70_gov1 = r70_gov1;
	}
	public BigDecimal getR70_corporate1() {
		return r70_corporate1;
	}
	public void setR70_corporate1(BigDecimal r70_corporate1) {
		this.r70_corporate1 = r70_corporate1;
	}
	public BigDecimal getR70_gre1() {
		return r70_gre1;
	}
	public void setR70_gre1(BigDecimal r70_gre1) {
		this.r70_gre1 = r70_gre1;
	}
	public BigDecimal getR70_trade1() {
		return r70_trade1;
	}
	public void setR70_trade1(BigDecimal r70_trade1) {
		this.r70_trade1 = r70_trade1;
	}
	public BigDecimal getR70_individuals1() {
		return r70_individuals1;
	}
	public void setR70_individuals1(BigDecimal r70_individuals1) {
		this.r70_individuals1 = r70_individuals1;
	}
	public BigDecimal getR70_investment1() {
		return r70_investment1;
	}
	public void setR70_investment1(BigDecimal r70_investment1) {
		this.r70_investment1 = r70_investment1;
	}
	public BigDecimal getR70_zer0() {
		return r70_zer0;
	}
	public void setR70_zer0(BigDecimal r70_zer0) {
		this.r70_zer0 = r70_zer0;
	}
	public BigDecimal getR70_three() {
		return r70_three;
	}
	public void setR70_three(BigDecimal r70_three) {
		this.r70_three = r70_three;
	}
	public BigDecimal getR70_six() {
		return r70_six;
	}
	public void setR70_six(BigDecimal r70_six) {
		this.r70_six = r70_six;
	}
	public BigDecimal getR70_oneyear() {
		return r70_oneyear;
	}
	public void setR70_oneyear(BigDecimal r70_oneyear) {
		this.r70_oneyear = r70_oneyear;
	}
	public BigDecimal getR70_foreign() {
		return r70_foreign;
	}
	public void setR70_foreign(BigDecimal r70_foreign) {
		this.r70_foreign = r70_foreign;
	}
	public BigDecimal getR70_banks() {
		return r70_banks;
	}
	public void setR70_banks(BigDecimal r70_banks) {
		this.r70_banks = r70_banks;
	}
	public BigDecimal getR70_gov2() {
		return r70_gov2;
	}
	public void setR70_gov2(BigDecimal r70_gov2) {
		this.r70_gov2 = r70_gov2;
	}
	public BigDecimal getR70_other() {
		return r70_other;
	}
	public void setR70_other(BigDecimal r70_other) {
		this.r70_other = r70_other;
	}
	public BigDecimal getR70_banks1() {
		return r70_banks1;
	}
	public void setR70_banks1(BigDecimal r70_banks1) {
		this.r70_banks1 = r70_banks1;
	}
	public BigDecimal getR70_individuals2() {
		return r70_individuals2;
	}
	public void setR70_individuals2(BigDecimal r70_individuals2) {
		this.r70_individuals2 = r70_individuals2;
	}
	public BigDecimal getR70_other1() {
		return r70_other1;
	}
	public void setR70_other1(BigDecimal r70_other1) {
		this.r70_other1 = r70_other1;
	}
	public BigDecimal getR70_banks2() {
		return r70_banks2;
	}
	public void setR70_banks2(BigDecimal r70_banks2) {
		this.r70_banks2 = r70_banks2;
	}
	public BigDecimal getR70_gov3() {
		return r70_gov3;
	}
	public void setR70_gov3(BigDecimal r70_gov3) {
		this.r70_gov3 = r70_gov3;
	}
	public BigDecimal getR70_others2() {
		return r70_others2;
	}
	public void setR70_others2(BigDecimal r70_others2) {
		this.r70_others2 = r70_others2;
	}
	public BigDecimal getR70_banks3() {
		return r70_banks3;
	}
	public void setR70_banks3(BigDecimal r70_banks3) {
		this.r70_banks3 = r70_banks3;
	}
	public BigDecimal getR70_gov4() {
		return r70_gov4;
	}
	public void setR70_gov4(BigDecimal r70_gov4) {
		this.r70_gov4 = r70_gov4;
	}
	public BigDecimal getR70_others3() {
		return r70_others3;
	}
	public void setR70_others3(BigDecimal r70_others3) {
		this.r70_others3 = r70_others3;
	}
	public BigDecimal getR70_foreign1() {
		return r70_foreign1;
	}
	public void setR70_foreign1(BigDecimal r70_foreign1) {
		this.r70_foreign1 = r70_foreign1;
	}
	public BigDecimal getR70_guarantees() {
		return r70_guarantees;
	}
	public void setR70_guarantees(BigDecimal r70_guarantees) {
		this.r70_guarantees = r70_guarantees;
	}
	public BigDecimal getR70_nbfi2() {
		return r70_nbfi2;
	}
	public void setR70_nbfi2(BigDecimal r70_nbfi2) {
		this.r70_nbfi2 = r70_nbfi2;
	}
	public BigDecimal getR70_interbank2() {
		return r70_interbank2;
	}
	public void setR70_interbank2(BigDecimal r70_interbank2) {
		this.r70_interbank2 = r70_interbank2;
	}
	public BigDecimal getR70_gov5() {
		return r70_gov5;
	}
	public void setR70_gov5(BigDecimal r70_gov5) {
		this.r70_gov5 = r70_gov5;
	}
	public BigDecimal getR70_corporate2() {
		return r70_corporate2;
	}
	public void setR70_corporate2(BigDecimal r70_corporate2) {
		this.r70_corporate2 = r70_corporate2;
	}
	public BigDecimal getR70_gre2() {
		return r70_gre2;
	}
	public void setR70_gre2(BigDecimal r70_gre2) {
		this.r70_gre2 = r70_gre2;
	}
	public BigDecimal getR70_individuals3() {
		return r70_individuals3;
	}
	public void setR70_individuals3(BigDecimal r70_individuals3) {
		this.r70_individuals3 = r70_individuals3;
	}
	public BigDecimal getR70_zero1() {
		return r70_zero1;
	}
	public void setR70_zero1(BigDecimal r70_zero1) {
		this.r70_zero1 = r70_zero1;
	}
	public BigDecimal getR70_three1() {
		return r70_three1;
	}
	public void setR70_three1(BigDecimal r70_three1) {
		this.r70_three1 = r70_three1;
	}
	public BigDecimal getR70_six1() {
		return r70_six1;
	}
	public void setR70_six1(BigDecimal r70_six1) {
		this.r70_six1 = r70_six1;
	}
	public BigDecimal getR70_oneyear1() {
		return r70_oneyear1;
	}
	public void setR70_oneyear1(BigDecimal r70_oneyear1) {
		this.r70_oneyear1 = r70_oneyear1;
	}
	public String getR70_empty() {
		return r70_empty;
	}
	public void setR70_empty(String r70_empty) {
		this.r70_empty = r70_empty;
	}
	public String getR71_product() {
		return r71_product;
	}
	public void setR71_product(String r71_product) {
		this.r71_product = r71_product;
	}
	public BigDecimal getR71_nbfi() {
		return r71_nbfi;
	}
	public void setR71_nbfi(BigDecimal r71_nbfi) {
		this.r71_nbfi = r71_nbfi;
	}
	public BigDecimal getR71_interbank() {
		return r71_interbank;
	}
	public void setR71_interbank(BigDecimal r71_interbank) {
		this.r71_interbank = r71_interbank;
	}
	public BigDecimal getR71_gov() {
		return r71_gov;
	}
	public void setR71_gov(BigDecimal r71_gov) {
		this.r71_gov = r71_gov;
	}
	public BigDecimal getR71_corporate() {
		return r71_corporate;
	}
	public void setR71_corporate(BigDecimal r71_corporate) {
		this.r71_corporate = r71_corporate;
	}
	public BigDecimal getR71_gre() {
		return r71_gre;
	}
	public void setR71_gre(BigDecimal r71_gre) {
		this.r71_gre = r71_gre;
	}
	public BigDecimal getR71_trade() {
		return r71_trade;
	}
	public void setR71_trade(BigDecimal r71_trade) {
		this.r71_trade = r71_trade;
	}
	public BigDecimal getR71_individuals() {
		return r71_individuals;
	}
	public void setR71_individuals(BigDecimal r71_individuals) {
		this.r71_individuals = r71_individuals;
	}
	public BigDecimal getR71_investment() {
		return r71_investment;
	}
	public void setR71_investment(BigDecimal r71_investment) {
		this.r71_investment = r71_investment;
	}
	public BigDecimal getR71_nbfi1() {
		return r71_nbfi1;
	}
	public void setR71_nbfi1(BigDecimal r71_nbfi1) {
		this.r71_nbfi1 = r71_nbfi1;
	}
	public BigDecimal getR71_interbank1() {
		return r71_interbank1;
	}
	public void setR71_interbank1(BigDecimal r71_interbank1) {
		this.r71_interbank1 = r71_interbank1;
	}
	public BigDecimal getR71_gov1() {
		return r71_gov1;
	}
	public void setR71_gov1(BigDecimal r71_gov1) {
		this.r71_gov1 = r71_gov1;
	}
	public BigDecimal getR71_corporate1() {
		return r71_corporate1;
	}
	public void setR71_corporate1(BigDecimal r71_corporate1) {
		this.r71_corporate1 = r71_corporate1;
	}
	public BigDecimal getR71_gre1() {
		return r71_gre1;
	}
	public void setR71_gre1(BigDecimal r71_gre1) {
		this.r71_gre1 = r71_gre1;
	}
	public BigDecimal getR71_trade1() {
		return r71_trade1;
	}
	public void setR71_trade1(BigDecimal r71_trade1) {
		this.r71_trade1 = r71_trade1;
	}
	public BigDecimal getR71_individuals1() {
		return r71_individuals1;
	}
	public void setR71_individuals1(BigDecimal r71_individuals1) {
		this.r71_individuals1 = r71_individuals1;
	}
	public BigDecimal getR71_investment1() {
		return r71_investment1;
	}
	public void setR71_investment1(BigDecimal r71_investment1) {
		this.r71_investment1 = r71_investment1;
	}
	public BigDecimal getR71_zer0() {
		return r71_zer0;
	}
	public void setR71_zer0(BigDecimal r71_zer0) {
		this.r71_zer0 = r71_zer0;
	}
	public BigDecimal getR71_three() {
		return r71_three;
	}
	public void setR71_three(BigDecimal r71_three) {
		this.r71_three = r71_three;
	}
	public BigDecimal getR71_six() {
		return r71_six;
	}
	public void setR71_six(BigDecimal r71_six) {
		this.r71_six = r71_six;
	}
	public BigDecimal getR71_oneyear() {
		return r71_oneyear;
	}
	public void setR71_oneyear(BigDecimal r71_oneyear) {
		this.r71_oneyear = r71_oneyear;
	}
	public BigDecimal getR71_foreign() {
		return r71_foreign;
	}
	public void setR71_foreign(BigDecimal r71_foreign) {
		this.r71_foreign = r71_foreign;
	}
	public BigDecimal getR71_banks() {
		return r71_banks;
	}
	public void setR71_banks(BigDecimal r71_banks) {
		this.r71_banks = r71_banks;
	}
	public BigDecimal getR71_gov2() {
		return r71_gov2;
	}
	public void setR71_gov2(BigDecimal r71_gov2) {
		this.r71_gov2 = r71_gov2;
	}
	public BigDecimal getR71_other() {
		return r71_other;
	}
	public void setR71_other(BigDecimal r71_other) {
		this.r71_other = r71_other;
	}
	public BigDecimal getR71_banks1() {
		return r71_banks1;
	}
	public void setR71_banks1(BigDecimal r71_banks1) {
		this.r71_banks1 = r71_banks1;
	}
	public BigDecimal getR71_individuals2() {
		return r71_individuals2;
	}
	public void setR71_individuals2(BigDecimal r71_individuals2) {
		this.r71_individuals2 = r71_individuals2;
	}
	public BigDecimal getR71_other1() {
		return r71_other1;
	}
	public void setR71_other1(BigDecimal r71_other1) {
		this.r71_other1 = r71_other1;
	}
	public BigDecimal getR71_banks2() {
		return r71_banks2;
	}
	public void setR71_banks2(BigDecimal r71_banks2) {
		this.r71_banks2 = r71_banks2;
	}
	public BigDecimal getR71_gov3() {
		return r71_gov3;
	}
	public void setR71_gov3(BigDecimal r71_gov3) {
		this.r71_gov3 = r71_gov3;
	}
	public BigDecimal getR71_others2() {
		return r71_others2;
	}
	public void setR71_others2(BigDecimal r71_others2) {
		this.r71_others2 = r71_others2;
	}
	public BigDecimal getR71_banks3() {
		return r71_banks3;
	}
	public void setR71_banks3(BigDecimal r71_banks3) {
		this.r71_banks3 = r71_banks3;
	}
	public BigDecimal getR71_gov4() {
		return r71_gov4;
	}
	public void setR71_gov4(BigDecimal r71_gov4) {
		this.r71_gov4 = r71_gov4;
	}
	public BigDecimal getR71_others3() {
		return r71_others3;
	}
	public void setR71_others3(BigDecimal r71_others3) {
		this.r71_others3 = r71_others3;
	}
	public BigDecimal getR71_foreign1() {
		return r71_foreign1;
	}
	public void setR71_foreign1(BigDecimal r71_foreign1) {
		this.r71_foreign1 = r71_foreign1;
	}
	public BigDecimal getR71_guarantees() {
		return r71_guarantees;
	}
	public void setR71_guarantees(BigDecimal r71_guarantees) {
		this.r71_guarantees = r71_guarantees;
	}
	public BigDecimal getR71_nbfi2() {
		return r71_nbfi2;
	}
	public void setR71_nbfi2(BigDecimal r71_nbfi2) {
		this.r71_nbfi2 = r71_nbfi2;
	}
	public BigDecimal getR71_interbank2() {
		return r71_interbank2;
	}
	public void setR71_interbank2(BigDecimal r71_interbank2) {
		this.r71_interbank2 = r71_interbank2;
	}
	public BigDecimal getR71_gov5() {
		return r71_gov5;
	}
	public void setR71_gov5(BigDecimal r71_gov5) {
		this.r71_gov5 = r71_gov5;
	}
	public BigDecimal getR71_corporate2() {
		return r71_corporate2;
	}
	public void setR71_corporate2(BigDecimal r71_corporate2) {
		this.r71_corporate2 = r71_corporate2;
	}
	public BigDecimal getR71_gre2() {
		return r71_gre2;
	}
	public void setR71_gre2(BigDecimal r71_gre2) {
		this.r71_gre2 = r71_gre2;
	}
	public BigDecimal getR71_individuals3() {
		return r71_individuals3;
	}
	public void setR71_individuals3(BigDecimal r71_individuals3) {
		this.r71_individuals3 = r71_individuals3;
	}
	public BigDecimal getR71_zero1() {
		return r71_zero1;
	}
	public void setR71_zero1(BigDecimal r71_zero1) {
		this.r71_zero1 = r71_zero1;
	}
	public BigDecimal getR71_three1() {
		return r71_three1;
	}
	public void setR71_three1(BigDecimal r71_three1) {
		this.r71_three1 = r71_three1;
	}
	public BigDecimal getR71_six1() {
		return r71_six1;
	}
	public void setR71_six1(BigDecimal r71_six1) {
		this.r71_six1 = r71_six1;
	}
	public BigDecimal getR71_oneyear1() {
		return r71_oneyear1;
	}
	public void setR71_oneyear1(BigDecimal r71_oneyear1) {
		this.r71_oneyear1 = r71_oneyear1;
	}
	public String getR71_empty() {
		return r71_empty;
	}
	public void setR71_empty(String r71_empty) {
		this.r71_empty = r71_empty;
	}
	public String getR72_product() {
		return r72_product;
	}
	public void setR72_product(String r72_product) {
		this.r72_product = r72_product;
	}
	public BigDecimal getR72_nbfi() {
		return r72_nbfi;
	}
	public void setR72_nbfi(BigDecimal r72_nbfi) {
		this.r72_nbfi = r72_nbfi;
	}
	public BigDecimal getR72_interbank() {
		return r72_interbank;
	}
	public void setR72_interbank(BigDecimal r72_interbank) {
		this.r72_interbank = r72_interbank;
	}
	public BigDecimal getR72_gov() {
		return r72_gov;
	}
	public void setR72_gov(BigDecimal r72_gov) {
		this.r72_gov = r72_gov;
	}
	public BigDecimal getR72_corporate() {
		return r72_corporate;
	}
	public void setR72_corporate(BigDecimal r72_corporate) {
		this.r72_corporate = r72_corporate;
	}
	public BigDecimal getR72_gre() {
		return r72_gre;
	}
	public void setR72_gre(BigDecimal r72_gre) {
		this.r72_gre = r72_gre;
	}
	public BigDecimal getR72_trade() {
		return r72_trade;
	}
	public void setR72_trade(BigDecimal r72_trade) {
		this.r72_trade = r72_trade;
	}
	public BigDecimal getR72_individuals() {
		return r72_individuals;
	}
	public void setR72_individuals(BigDecimal r72_individuals) {
		this.r72_individuals = r72_individuals;
	}
	public BigDecimal getR72_investment() {
		return r72_investment;
	}
	public void setR72_investment(BigDecimal r72_investment) {
		this.r72_investment = r72_investment;
	}
	public BigDecimal getR72_nbfi1() {
		return r72_nbfi1;
	}
	public void setR72_nbfi1(BigDecimal r72_nbfi1) {
		this.r72_nbfi1 = r72_nbfi1;
	}
	public BigDecimal getR72_interbank1() {
		return r72_interbank1;
	}
	public void setR72_interbank1(BigDecimal r72_interbank1) {
		this.r72_interbank1 = r72_interbank1;
	}
	public BigDecimal getR72_gov1() {
		return r72_gov1;
	}
	public void setR72_gov1(BigDecimal r72_gov1) {
		this.r72_gov1 = r72_gov1;
	}
	public BigDecimal getR72_corporate1() {
		return r72_corporate1;
	}
	public void setR72_corporate1(BigDecimal r72_corporate1) {
		this.r72_corporate1 = r72_corporate1;
	}
	public BigDecimal getR72_gre1() {
		return r72_gre1;
	}
	public void setR72_gre1(BigDecimal r72_gre1) {
		this.r72_gre1 = r72_gre1;
	}
	public BigDecimal getR72_trade1() {
		return r72_trade1;
	}
	public void setR72_trade1(BigDecimal r72_trade1) {
		this.r72_trade1 = r72_trade1;
	}
	public BigDecimal getR72_individuals1() {
		return r72_individuals1;
	}
	public void setR72_individuals1(BigDecimal r72_individuals1) {
		this.r72_individuals1 = r72_individuals1;
	}
	public BigDecimal getR72_investment1() {
		return r72_investment1;
	}
	public void setR72_investment1(BigDecimal r72_investment1) {
		this.r72_investment1 = r72_investment1;
	}
	public BigDecimal getR72_zer0() {
		return r72_zer0;
	}
	public void setR72_zer0(BigDecimal r72_zer0) {
		this.r72_zer0 = r72_zer0;
	}
	public BigDecimal getR72_three() {
		return r72_three;
	}
	public void setR72_three(BigDecimal r72_three) {
		this.r72_three = r72_three;
	}
	public BigDecimal getR72_six() {
		return r72_six;
	}
	public void setR72_six(BigDecimal r72_six) {
		this.r72_six = r72_six;
	}
	public BigDecimal getR72_oneyear() {
		return r72_oneyear;
	}
	public void setR72_oneyear(BigDecimal r72_oneyear) {
		this.r72_oneyear = r72_oneyear;
	}
	public BigDecimal getR72_foreign() {
		return r72_foreign;
	}
	public void setR72_foreign(BigDecimal r72_foreign) {
		this.r72_foreign = r72_foreign;
	}
	public BigDecimal getR72_banks() {
		return r72_banks;
	}
	public void setR72_banks(BigDecimal r72_banks) {
		this.r72_banks = r72_banks;
	}
	public BigDecimal getR72_gov2() {
		return r72_gov2;
	}
	public void setR72_gov2(BigDecimal r72_gov2) {
		this.r72_gov2 = r72_gov2;
	}
	public BigDecimal getR72_other() {
		return r72_other;
	}
	public void setR72_other(BigDecimal r72_other) {
		this.r72_other = r72_other;
	}
	public BigDecimal getR72_banks1() {
		return r72_banks1;
	}
	public void setR72_banks1(BigDecimal r72_banks1) {
		this.r72_banks1 = r72_banks1;
	}
	public BigDecimal getR72_individuals2() {
		return r72_individuals2;
	}
	public void setR72_individuals2(BigDecimal r72_individuals2) {
		this.r72_individuals2 = r72_individuals2;
	}
	public BigDecimal getR72_other1() {
		return r72_other1;
	}
	public void setR72_other1(BigDecimal r72_other1) {
		this.r72_other1 = r72_other1;
	}
	public BigDecimal getR72_banks2() {
		return r72_banks2;
	}
	public void setR72_banks2(BigDecimal r72_banks2) {
		this.r72_banks2 = r72_banks2;
	}
	public BigDecimal getR72_gov3() {
		return r72_gov3;
	}
	public void setR72_gov3(BigDecimal r72_gov3) {
		this.r72_gov3 = r72_gov3;
	}
	public BigDecimal getR72_others2() {
		return r72_others2;
	}
	public void setR72_others2(BigDecimal r72_others2) {
		this.r72_others2 = r72_others2;
	}
	public BigDecimal getR72_banks3() {
		return r72_banks3;
	}
	public void setR72_banks3(BigDecimal r72_banks3) {
		this.r72_banks3 = r72_banks3;
	}
	public BigDecimal getR72_gov4() {
		return r72_gov4;
	}
	public void setR72_gov4(BigDecimal r72_gov4) {
		this.r72_gov4 = r72_gov4;
	}
	public BigDecimal getR72_others3() {
		return r72_others3;
	}
	public void setR72_others3(BigDecimal r72_others3) {
		this.r72_others3 = r72_others3;
	}
	public BigDecimal getR72_foreign1() {
		return r72_foreign1;
	}
	public void setR72_foreign1(BigDecimal r72_foreign1) {
		this.r72_foreign1 = r72_foreign1;
	}
	public BigDecimal getR72_guarantees() {
		return r72_guarantees;
	}
	public void setR72_guarantees(BigDecimal r72_guarantees) {
		this.r72_guarantees = r72_guarantees;
	}
	public BigDecimal getR72_nbfi2() {
		return r72_nbfi2;
	}
	public void setR72_nbfi2(BigDecimal r72_nbfi2) {
		this.r72_nbfi2 = r72_nbfi2;
	}
	public BigDecimal getR72_interbank2() {
		return r72_interbank2;
	}
	public void setR72_interbank2(BigDecimal r72_interbank2) {
		this.r72_interbank2 = r72_interbank2;
	}
	public BigDecimal getR72_gov5() {
		return r72_gov5;
	}
	public void setR72_gov5(BigDecimal r72_gov5) {
		this.r72_gov5 = r72_gov5;
	}
	public BigDecimal getR72_corporate2() {
		return r72_corporate2;
	}
	public void setR72_corporate2(BigDecimal r72_corporate2) {
		this.r72_corporate2 = r72_corporate2;
	}
	public BigDecimal getR72_gre2() {
		return r72_gre2;
	}
	public void setR72_gre2(BigDecimal r72_gre2) {
		this.r72_gre2 = r72_gre2;
	}
	public BigDecimal getR72_individuals3() {
		return r72_individuals3;
	}
	public void setR72_individuals3(BigDecimal r72_individuals3) {
		this.r72_individuals3 = r72_individuals3;
	}
	public BigDecimal getR72_zero1() {
		return r72_zero1;
	}
	public void setR72_zero1(BigDecimal r72_zero1) {
		this.r72_zero1 = r72_zero1;
	}
	public BigDecimal getR72_three1() {
		return r72_three1;
	}
	public void setR72_three1(BigDecimal r72_three1) {
		this.r72_three1 = r72_three1;
	}
	public BigDecimal getR72_six1() {
		return r72_six1;
	}
	public void setR72_six1(BigDecimal r72_six1) {
		this.r72_six1 = r72_six1;
	}
	public BigDecimal getR72_oneyear1() {
		return r72_oneyear1;
	}
	public void setR72_oneyear1(BigDecimal r72_oneyear1) {
		this.r72_oneyear1 = r72_oneyear1;
	}
	public String getR72_empty() {
		return r72_empty;
	}
	public void setR72_empty(String r72_empty) {
		this.r72_empty = r72_empty;
	}
	public String getR73_product() {
		return r73_product;
	}
	public void setR73_product(String r73_product) {
		this.r73_product = r73_product;
	}
	public BigDecimal getR73_nbfi() {
		return r73_nbfi;
	}
	public void setR73_nbfi(BigDecimal r73_nbfi) {
		this.r73_nbfi = r73_nbfi;
	}
	public BigDecimal getR73_interbank() {
		return r73_interbank;
	}
	public void setR73_interbank(BigDecimal r73_interbank) {
		this.r73_interbank = r73_interbank;
	}
	public BigDecimal getR73_gov() {
		return r73_gov;
	}
	public void setR73_gov(BigDecimal r73_gov) {
		this.r73_gov = r73_gov;
	}
	public BigDecimal getR73_corporate() {
		return r73_corporate;
	}
	public void setR73_corporate(BigDecimal r73_corporate) {
		this.r73_corporate = r73_corporate;
	}
	public BigDecimal getR73_gre() {
		return r73_gre;
	}
	public void setR73_gre(BigDecimal r73_gre) {
		this.r73_gre = r73_gre;
	}
	public BigDecimal getR73_trade() {
		return r73_trade;
	}
	public void setR73_trade(BigDecimal r73_trade) {
		this.r73_trade = r73_trade;
	}
	public BigDecimal getR73_individuals() {
		return r73_individuals;
	}
	public void setR73_individuals(BigDecimal r73_individuals) {
		this.r73_individuals = r73_individuals;
	}
	public BigDecimal getR73_investment() {
		return r73_investment;
	}
	public void setR73_investment(BigDecimal r73_investment) {
		this.r73_investment = r73_investment;
	}
	public BigDecimal getR73_nbfi1() {
		return r73_nbfi1;
	}
	public void setR73_nbfi1(BigDecimal r73_nbfi1) {
		this.r73_nbfi1 = r73_nbfi1;
	}
	public BigDecimal getR73_interbank1() {
		return r73_interbank1;
	}
	public void setR73_interbank1(BigDecimal r73_interbank1) {
		this.r73_interbank1 = r73_interbank1;
	}
	public BigDecimal getR73_gov1() {
		return r73_gov1;
	}
	public void setR73_gov1(BigDecimal r73_gov1) {
		this.r73_gov1 = r73_gov1;
	}
	public BigDecimal getR73_corporate1() {
		return r73_corporate1;
	}
	public void setR73_corporate1(BigDecimal r73_corporate1) {
		this.r73_corporate1 = r73_corporate1;
	}
	public BigDecimal getR73_gre1() {
		return r73_gre1;
	}
	public void setR73_gre1(BigDecimal r73_gre1) {
		this.r73_gre1 = r73_gre1;
	}
	public BigDecimal getR73_trade1() {
		return r73_trade1;
	}
	public void setR73_trade1(BigDecimal r73_trade1) {
		this.r73_trade1 = r73_trade1;
	}
	public BigDecimal getR73_individuals1() {
		return r73_individuals1;
	}
	public void setR73_individuals1(BigDecimal r73_individuals1) {
		this.r73_individuals1 = r73_individuals1;
	}
	public BigDecimal getR73_investment1() {
		return r73_investment1;
	}
	public void setR73_investment1(BigDecimal r73_investment1) {
		this.r73_investment1 = r73_investment1;
	}
	public BigDecimal getR73_zer0() {
		return r73_zer0;
	}
	public void setR73_zer0(BigDecimal r73_zer0) {
		this.r73_zer0 = r73_zer0;
	}
	public BigDecimal getR73_three() {
		return r73_three;
	}
	public void setR73_three(BigDecimal r73_three) {
		this.r73_three = r73_three;
	}
	public BigDecimal getR73_six() {
		return r73_six;
	}
	public void setR73_six(BigDecimal r73_six) {
		this.r73_six = r73_six;
	}
	public BigDecimal getR73_oneyear() {
		return r73_oneyear;
	}
	public void setR73_oneyear(BigDecimal r73_oneyear) {
		this.r73_oneyear = r73_oneyear;
	}
	public BigDecimal getR73_foreign() {
		return r73_foreign;
	}
	public void setR73_foreign(BigDecimal r73_foreign) {
		this.r73_foreign = r73_foreign;
	}
	public BigDecimal getR73_banks() {
		return r73_banks;
	}
	public void setR73_banks(BigDecimal r73_banks) {
		this.r73_banks = r73_banks;
	}
	public BigDecimal getR73_gov2() {
		return r73_gov2;
	}
	public void setR73_gov2(BigDecimal r73_gov2) {
		this.r73_gov2 = r73_gov2;
	}
	public BigDecimal getR73_other() {
		return r73_other;
	}
	public void setR73_other(BigDecimal r73_other) {
		this.r73_other = r73_other;
	}
	public BigDecimal getR73_banks1() {
		return r73_banks1;
	}
	public void setR73_banks1(BigDecimal r73_banks1) {
		this.r73_banks1 = r73_banks1;
	}
	public BigDecimal getR73_individuals2() {
		return r73_individuals2;
	}
	public void setR73_individuals2(BigDecimal r73_individuals2) {
		this.r73_individuals2 = r73_individuals2;
	}
	public BigDecimal getR73_other1() {
		return r73_other1;
	}
	public void setR73_other1(BigDecimal r73_other1) {
		this.r73_other1 = r73_other1;
	}
	public BigDecimal getR73_banks2() {
		return r73_banks2;
	}
	public void setR73_banks2(BigDecimal r73_banks2) {
		this.r73_banks2 = r73_banks2;
	}
	public BigDecimal getR73_gov3() {
		return r73_gov3;
	}
	public void setR73_gov3(BigDecimal r73_gov3) {
		this.r73_gov3 = r73_gov3;
	}
	public BigDecimal getR73_others2() {
		return r73_others2;
	}
	public void setR73_others2(BigDecimal r73_others2) {
		this.r73_others2 = r73_others2;
	}
	public BigDecimal getR73_banks3() {
		return r73_banks3;
	}
	public void setR73_banks3(BigDecimal r73_banks3) {
		this.r73_banks3 = r73_banks3;
	}
	public BigDecimal getR73_gov4() {
		return r73_gov4;
	}
	public void setR73_gov4(BigDecimal r73_gov4) {
		this.r73_gov4 = r73_gov4;
	}
	public BigDecimal getR73_others3() {
		return r73_others3;
	}
	public void setR73_others3(BigDecimal r73_others3) {
		this.r73_others3 = r73_others3;
	}
	public BigDecimal getR73_foreign1() {
		return r73_foreign1;
	}
	public void setR73_foreign1(BigDecimal r73_foreign1) {
		this.r73_foreign1 = r73_foreign1;
	}
	public BigDecimal getR73_guarantees() {
		return r73_guarantees;
	}
	public void setR73_guarantees(BigDecimal r73_guarantees) {
		this.r73_guarantees = r73_guarantees;
	}
	public BigDecimal getR73_nbfi2() {
		return r73_nbfi2;
	}
	public void setR73_nbfi2(BigDecimal r73_nbfi2) {
		this.r73_nbfi2 = r73_nbfi2;
	}
	public BigDecimal getR73_interbank2() {
		return r73_interbank2;
	}
	public void setR73_interbank2(BigDecimal r73_interbank2) {
		this.r73_interbank2 = r73_interbank2;
	}
	public BigDecimal getR73_gov5() {
		return r73_gov5;
	}
	public void setR73_gov5(BigDecimal r73_gov5) {
		this.r73_gov5 = r73_gov5;
	}
	public BigDecimal getR73_corporate2() {
		return r73_corporate2;
	}
	public void setR73_corporate2(BigDecimal r73_corporate2) {
		this.r73_corporate2 = r73_corporate2;
	}
	public BigDecimal getR73_gre2() {
		return r73_gre2;
	}
	public void setR73_gre2(BigDecimal r73_gre2) {
		this.r73_gre2 = r73_gre2;
	}
	public BigDecimal getR73_individuals3() {
		return r73_individuals3;
	}
	public void setR73_individuals3(BigDecimal r73_individuals3) {
		this.r73_individuals3 = r73_individuals3;
	}
	public BigDecimal getR73_zero1() {
		return r73_zero1;
	}
	public void setR73_zero1(BigDecimal r73_zero1) {
		this.r73_zero1 = r73_zero1;
	}
	public BigDecimal getR73_three1() {
		return r73_three1;
	}
	public void setR73_three1(BigDecimal r73_three1) {
		this.r73_three1 = r73_three1;
	}
	public BigDecimal getR73_six1() {
		return r73_six1;
	}
	public void setR73_six1(BigDecimal r73_six1) {
		this.r73_six1 = r73_six1;
	}
	public BigDecimal getR73_oneyear1() {
		return r73_oneyear1;
	}
	public void setR73_oneyear1(BigDecimal r73_oneyear1) {
		this.r73_oneyear1 = r73_oneyear1;
	}
	public String getR73_empty() {
		return r73_empty;
	}
	public void setR73_empty(String r73_empty) {
		this.r73_empty = r73_empty;
	}
	public String getR74_product() {
		return r74_product;
	}
	public void setR74_product(String r74_product) {
		this.r74_product = r74_product;
	}
	public BigDecimal getR74_nbfi() {
		return r74_nbfi;
	}
	public void setR74_nbfi(BigDecimal r74_nbfi) {
		this.r74_nbfi = r74_nbfi;
	}
	public BigDecimal getR74_interbank() {
		return r74_interbank;
	}
	public void setR74_interbank(BigDecimal r74_interbank) {
		this.r74_interbank = r74_interbank;
	}
	public BigDecimal getR74_gov() {
		return r74_gov;
	}
	public void setR74_gov(BigDecimal r74_gov) {
		this.r74_gov = r74_gov;
	}
	public BigDecimal getR74_corporate() {
		return r74_corporate;
	}
	public void setR74_corporate(BigDecimal r74_corporate) {
		this.r74_corporate = r74_corporate;
	}
	public BigDecimal getR74_gre() {
		return r74_gre;
	}
	public void setR74_gre(BigDecimal r74_gre) {
		this.r74_gre = r74_gre;
	}
	public BigDecimal getR74_trade() {
		return r74_trade;
	}
	public void setR74_trade(BigDecimal r74_trade) {
		this.r74_trade = r74_trade;
	}
	public BigDecimal getR74_individuals() {
		return r74_individuals;
	}
	public void setR74_individuals(BigDecimal r74_individuals) {
		this.r74_individuals = r74_individuals;
	}
	public BigDecimal getR74_investment() {
		return r74_investment;
	}
	public void setR74_investment(BigDecimal r74_investment) {
		this.r74_investment = r74_investment;
	}
	public BigDecimal getR74_nbfi1() {
		return r74_nbfi1;
	}
	public void setR74_nbfi1(BigDecimal r74_nbfi1) {
		this.r74_nbfi1 = r74_nbfi1;
	}
	public BigDecimal getR74_interbank1() {
		return r74_interbank1;
	}
	public void setR74_interbank1(BigDecimal r74_interbank1) {
		this.r74_interbank1 = r74_interbank1;
	}
	public BigDecimal getR74_gov1() {
		return r74_gov1;
	}
	public void setR74_gov1(BigDecimal r74_gov1) {
		this.r74_gov1 = r74_gov1;
	}
	public BigDecimal getR74_corporate1() {
		return r74_corporate1;
	}
	public void setR74_corporate1(BigDecimal r74_corporate1) {
		this.r74_corporate1 = r74_corporate1;
	}
	public BigDecimal getR74_gre1() {
		return r74_gre1;
	}
	public void setR74_gre1(BigDecimal r74_gre1) {
		this.r74_gre1 = r74_gre1;
	}
	public BigDecimal getR74_trade1() {
		return r74_trade1;
	}
	public void setR74_trade1(BigDecimal r74_trade1) {
		this.r74_trade1 = r74_trade1;
	}
	public BigDecimal getR74_individuals1() {
		return r74_individuals1;
	}
	public void setR74_individuals1(BigDecimal r74_individuals1) {
		this.r74_individuals1 = r74_individuals1;
	}
	public BigDecimal getR74_investment1() {
		return r74_investment1;
	}
	public void setR74_investment1(BigDecimal r74_investment1) {
		this.r74_investment1 = r74_investment1;
	}
	public BigDecimal getR74_zer0() {
		return r74_zer0;
	}
	public void setR74_zer0(BigDecimal r74_zer0) {
		this.r74_zer0 = r74_zer0;
	}
	public BigDecimal getR74_three() {
		return r74_three;
	}
	public void setR74_three(BigDecimal r74_three) {
		this.r74_three = r74_three;
	}
	public BigDecimal getR74_six() {
		return r74_six;
	}
	public void setR74_six(BigDecimal r74_six) {
		this.r74_six = r74_six;
	}
	public BigDecimal getR74_oneyear() {
		return r74_oneyear;
	}
	public void setR74_oneyear(BigDecimal r74_oneyear) {
		this.r74_oneyear = r74_oneyear;
	}
	public BigDecimal getR74_foreign() {
		return r74_foreign;
	}
	public void setR74_foreign(BigDecimal r74_foreign) {
		this.r74_foreign = r74_foreign;
	}
	public BigDecimal getR74_banks() {
		return r74_banks;
	}
	public void setR74_banks(BigDecimal r74_banks) {
		this.r74_banks = r74_banks;
	}
	public BigDecimal getR74_gov2() {
		return r74_gov2;
	}
	public void setR74_gov2(BigDecimal r74_gov2) {
		this.r74_gov2 = r74_gov2;
	}
	public BigDecimal getR74_other() {
		return r74_other;
	}
	public void setR74_other(BigDecimal r74_other) {
		this.r74_other = r74_other;
	}
	public BigDecimal getR74_banks1() {
		return r74_banks1;
	}
	public void setR74_banks1(BigDecimal r74_banks1) {
		this.r74_banks1 = r74_banks1;
	}
	public BigDecimal getR74_individuals2() {
		return r74_individuals2;
	}
	public void setR74_individuals2(BigDecimal r74_individuals2) {
		this.r74_individuals2 = r74_individuals2;
	}
	public BigDecimal getR74_other1() {
		return r74_other1;
	}
	public void setR74_other1(BigDecimal r74_other1) {
		this.r74_other1 = r74_other1;
	}
	public BigDecimal getR74_banks2() {
		return r74_banks2;
	}
	public void setR74_banks2(BigDecimal r74_banks2) {
		this.r74_banks2 = r74_banks2;
	}
	public BigDecimal getR74_gov3() {
		return r74_gov3;
	}
	public void setR74_gov3(BigDecimal r74_gov3) {
		this.r74_gov3 = r74_gov3;
	}
	public BigDecimal getR74_others2() {
		return r74_others2;
	}
	public void setR74_others2(BigDecimal r74_others2) {
		this.r74_others2 = r74_others2;
	}
	public BigDecimal getR74_banks3() {
		return r74_banks3;
	}
	public void setR74_banks3(BigDecimal r74_banks3) {
		this.r74_banks3 = r74_banks3;
	}
	public BigDecimal getR74_gov4() {
		return r74_gov4;
	}
	public void setR74_gov4(BigDecimal r74_gov4) {
		this.r74_gov4 = r74_gov4;
	}
	public BigDecimal getR74_others3() {
		return r74_others3;
	}
	public void setR74_others3(BigDecimal r74_others3) {
		this.r74_others3 = r74_others3;
	}
	public BigDecimal getR74_foreign1() {
		return r74_foreign1;
	}
	public void setR74_foreign1(BigDecimal r74_foreign1) {
		this.r74_foreign1 = r74_foreign1;
	}
	public BigDecimal getR74_guarantees() {
		return r74_guarantees;
	}
	public void setR74_guarantees(BigDecimal r74_guarantees) {
		this.r74_guarantees = r74_guarantees;
	}
	public BigDecimal getR74_nbfi2() {
		return r74_nbfi2;
	}
	public void setR74_nbfi2(BigDecimal r74_nbfi2) {
		this.r74_nbfi2 = r74_nbfi2;
	}
	public BigDecimal getR74_interbank2() {
		return r74_interbank2;
	}
	public void setR74_interbank2(BigDecimal r74_interbank2) {
		this.r74_interbank2 = r74_interbank2;
	}
	public BigDecimal getR74_gov5() {
		return r74_gov5;
	}
	public void setR74_gov5(BigDecimal r74_gov5) {
		this.r74_gov5 = r74_gov5;
	}
	public BigDecimal getR74_corporate2() {
		return r74_corporate2;
	}
	public void setR74_corporate2(BigDecimal r74_corporate2) {
		this.r74_corporate2 = r74_corporate2;
	}
	public BigDecimal getR74_gre2() {
		return r74_gre2;
	}
	public void setR74_gre2(BigDecimal r74_gre2) {
		this.r74_gre2 = r74_gre2;
	}
	public BigDecimal getR74_individuals3() {
		return r74_individuals3;
	}
	public void setR74_individuals3(BigDecimal r74_individuals3) {
		this.r74_individuals3 = r74_individuals3;
	}
	public BigDecimal getR74_zero1() {
		return r74_zero1;
	}
	public void setR74_zero1(BigDecimal r74_zero1) {
		this.r74_zero1 = r74_zero1;
	}
	public BigDecimal getR74_three1() {
		return r74_three1;
	}
	public void setR74_three1(BigDecimal r74_three1) {
		this.r74_three1 = r74_three1;
	}
	public BigDecimal getR74_six1() {
		return r74_six1;
	}
	public void setR74_six1(BigDecimal r74_six1) {
		this.r74_six1 = r74_six1;
	}
	public BigDecimal getR74_oneyear1() {
		return r74_oneyear1;
	}
	public void setR74_oneyear1(BigDecimal r74_oneyear1) {
		this.r74_oneyear1 = r74_oneyear1;
	}
	public String getR74_empty() {
		return r74_empty;
	}
	public void setR74_empty(String r74_empty) {
		this.r74_empty = r74_empty;
	}
	public String getR75_product() {
		return r75_product;
	}
	public void setR75_product(String r75_product) {
		this.r75_product = r75_product;
	}
	public BigDecimal getR75_nbfi() {
		return r75_nbfi;
	}
	public void setR75_nbfi(BigDecimal r75_nbfi) {
		this.r75_nbfi = r75_nbfi;
	}
	public BigDecimal getR75_interbank() {
		return r75_interbank;
	}
	public void setR75_interbank(BigDecimal r75_interbank) {
		this.r75_interbank = r75_interbank;
	}
	public BigDecimal getR75_gov() {
		return r75_gov;
	}
	public void setR75_gov(BigDecimal r75_gov) {
		this.r75_gov = r75_gov;
	}
	public BigDecimal getR75_corporate() {
		return r75_corporate;
	}
	public void setR75_corporate(BigDecimal r75_corporate) {
		this.r75_corporate = r75_corporate;
	}
	public BigDecimal getR75_gre() {
		return r75_gre;
	}
	public void setR75_gre(BigDecimal r75_gre) {
		this.r75_gre = r75_gre;
	}
	public BigDecimal getR75_trade() {
		return r75_trade;
	}
	public void setR75_trade(BigDecimal r75_trade) {
		this.r75_trade = r75_trade;
	}
	public BigDecimal getR75_individuals() {
		return r75_individuals;
	}
	public void setR75_individuals(BigDecimal r75_individuals) {
		this.r75_individuals = r75_individuals;
	}
	public BigDecimal getR75_investment() {
		return r75_investment;
	}
	public void setR75_investment(BigDecimal r75_investment) {
		this.r75_investment = r75_investment;
	}
	public BigDecimal getR75_nbfi1() {
		return r75_nbfi1;
	}
	public void setR75_nbfi1(BigDecimal r75_nbfi1) {
		this.r75_nbfi1 = r75_nbfi1;
	}
	public BigDecimal getR75_interbank1() {
		return r75_interbank1;
	}
	public void setR75_interbank1(BigDecimal r75_interbank1) {
		this.r75_interbank1 = r75_interbank1;
	}
	public BigDecimal getR75_gov1() {
		return r75_gov1;
	}
	public void setR75_gov1(BigDecimal r75_gov1) {
		this.r75_gov1 = r75_gov1;
	}
	public BigDecimal getR75_corporate1() {
		return r75_corporate1;
	}
	public void setR75_corporate1(BigDecimal r75_corporate1) {
		this.r75_corporate1 = r75_corporate1;
	}
	public BigDecimal getR75_gre1() {
		return r75_gre1;
	}
	public void setR75_gre1(BigDecimal r75_gre1) {
		this.r75_gre1 = r75_gre1;
	}
	public BigDecimal getR75_trade1() {
		return r75_trade1;
	}
	public void setR75_trade1(BigDecimal r75_trade1) {
		this.r75_trade1 = r75_trade1;
	}
	public BigDecimal getR75_individuals1() {
		return r75_individuals1;
	}
	public void setR75_individuals1(BigDecimal r75_individuals1) {
		this.r75_individuals1 = r75_individuals1;
	}
	public BigDecimal getR75_investment1() {
		return r75_investment1;
	}
	public void setR75_investment1(BigDecimal r75_investment1) {
		this.r75_investment1 = r75_investment1;
	}
	public BigDecimal getR75_zer0() {
		return r75_zer0;
	}
	public void setR75_zer0(BigDecimal r75_zer0) {
		this.r75_zer0 = r75_zer0;
	}
	public BigDecimal getR75_three() {
		return r75_three;
	}
	public void setR75_three(BigDecimal r75_three) {
		this.r75_three = r75_three;
	}
	public BigDecimal getR75_six() {
		return r75_six;
	}
	public void setR75_six(BigDecimal r75_six) {
		this.r75_six = r75_six;
	}
	public BigDecimal getR75_oneyear() {
		return r75_oneyear;
	}
	public void setR75_oneyear(BigDecimal r75_oneyear) {
		this.r75_oneyear = r75_oneyear;
	}
	public BigDecimal getR75_foreign() {
		return r75_foreign;
	}
	public void setR75_foreign(BigDecimal r75_foreign) {
		this.r75_foreign = r75_foreign;
	}
	public BigDecimal getR75_banks() {
		return r75_banks;
	}
	public void setR75_banks(BigDecimal r75_banks) {
		this.r75_banks = r75_banks;
	}
	public BigDecimal getR75_gov2() {
		return r75_gov2;
	}
	public void setR75_gov2(BigDecimal r75_gov2) {
		this.r75_gov2 = r75_gov2;
	}
	public BigDecimal getR75_other() {
		return r75_other;
	}
	public void setR75_other(BigDecimal r75_other) {
		this.r75_other = r75_other;
	}
	public BigDecimal getR75_banks1() {
		return r75_banks1;
	}
	public void setR75_banks1(BigDecimal r75_banks1) {
		this.r75_banks1 = r75_banks1;
	}
	public BigDecimal getR75_individuals2() {
		return r75_individuals2;
	}
	public void setR75_individuals2(BigDecimal r75_individuals2) {
		this.r75_individuals2 = r75_individuals2;
	}
	public BigDecimal getR75_other1() {
		return r75_other1;
	}
	public void setR75_other1(BigDecimal r75_other1) {
		this.r75_other1 = r75_other1;
	}
	public BigDecimal getR75_banks2() {
		return r75_banks2;
	}
	public void setR75_banks2(BigDecimal r75_banks2) {
		this.r75_banks2 = r75_banks2;
	}
	public BigDecimal getR75_gov3() {
		return r75_gov3;
	}
	public void setR75_gov3(BigDecimal r75_gov3) {
		this.r75_gov3 = r75_gov3;
	}
	public BigDecimal getR75_others2() {
		return r75_others2;
	}
	public void setR75_others2(BigDecimal r75_others2) {
		this.r75_others2 = r75_others2;
	}
	public BigDecimal getR75_banks3() {
		return r75_banks3;
	}
	public void setR75_banks3(BigDecimal r75_banks3) {
		this.r75_banks3 = r75_banks3;
	}
	public BigDecimal getR75_gov4() {
		return r75_gov4;
	}
	public void setR75_gov4(BigDecimal r75_gov4) {
		this.r75_gov4 = r75_gov4;
	}
	public BigDecimal getR75_others3() {
		return r75_others3;
	}
	public void setR75_others3(BigDecimal r75_others3) {
		this.r75_others3 = r75_others3;
	}
	public BigDecimal getR75_foreign1() {
		return r75_foreign1;
	}
	public void setR75_foreign1(BigDecimal r75_foreign1) {
		this.r75_foreign1 = r75_foreign1;
	}
	public BigDecimal getR75_guarantees() {
		return r75_guarantees;
	}
	public void setR75_guarantees(BigDecimal r75_guarantees) {
		this.r75_guarantees = r75_guarantees;
	}
	public BigDecimal getR75_nbfi2() {
		return r75_nbfi2;
	}
	public void setR75_nbfi2(BigDecimal r75_nbfi2) {
		this.r75_nbfi2 = r75_nbfi2;
	}
	public BigDecimal getR75_interbank2() {
		return r75_interbank2;
	}
	public void setR75_interbank2(BigDecimal r75_interbank2) {
		this.r75_interbank2 = r75_interbank2;
	}
	public BigDecimal getR75_gov5() {
		return r75_gov5;
	}
	public void setR75_gov5(BigDecimal r75_gov5) {
		this.r75_gov5 = r75_gov5;
	}
	public BigDecimal getR75_corporate2() {
		return r75_corporate2;
	}
	public void setR75_corporate2(BigDecimal r75_corporate2) {
		this.r75_corporate2 = r75_corporate2;
	}
	public BigDecimal getR75_gre2() {
		return r75_gre2;
	}
	public void setR75_gre2(BigDecimal r75_gre2) {
		this.r75_gre2 = r75_gre2;
	}
	public BigDecimal getR75_individuals3() {
		return r75_individuals3;
	}
	public void setR75_individuals3(BigDecimal r75_individuals3) {
		this.r75_individuals3 = r75_individuals3;
	}
	public BigDecimal getR75_zero1() {
		return r75_zero1;
	}
	public void setR75_zero1(BigDecimal r75_zero1) {
		this.r75_zero1 = r75_zero1;
	}
	public BigDecimal getR75_three1() {
		return r75_three1;
	}
	public void setR75_three1(BigDecimal r75_three1) {
		this.r75_three1 = r75_three1;
	}
	public BigDecimal getR75_six1() {
		return r75_six1;
	}
	public void setR75_six1(BigDecimal r75_six1) {
		this.r75_six1 = r75_six1;
	}
	public BigDecimal getR75_oneyear1() {
		return r75_oneyear1;
	}
	public void setR75_oneyear1(BigDecimal r75_oneyear1) {
		this.r75_oneyear1 = r75_oneyear1;
	}
	public String getR75_empty() {
		return r75_empty;
	}
	public void setR75_empty(String r75_empty) {
		this.r75_empty = r75_empty;
	}
	public String getR76_product() {
		return r76_product;
	}
	public void setR76_product(String r76_product) {
		this.r76_product = r76_product;
	}
	public BigDecimal getR76_nbfi() {
		return r76_nbfi;
	}
	public void setR76_nbfi(BigDecimal r76_nbfi) {
		this.r76_nbfi = r76_nbfi;
	}
	public BigDecimal getR76_interbank() {
		return r76_interbank;
	}
	public void setR76_interbank(BigDecimal r76_interbank) {
		this.r76_interbank = r76_interbank;
	}
	public BigDecimal getR76_gov() {
		return r76_gov;
	}
	public void setR76_gov(BigDecimal r76_gov) {
		this.r76_gov = r76_gov;
	}
	public BigDecimal getR76_corporate() {
		return r76_corporate;
	}
	public void setR76_corporate(BigDecimal r76_corporate) {
		this.r76_corporate = r76_corporate;
	}
	public BigDecimal getR76_gre() {
		return r76_gre;
	}
	public void setR76_gre(BigDecimal r76_gre) {
		this.r76_gre = r76_gre;
	}
	public BigDecimal getR76_trade() {
		return r76_trade;
	}
	public void setR76_trade(BigDecimal r76_trade) {
		this.r76_trade = r76_trade;
	}
	public BigDecimal getR76_individuals() {
		return r76_individuals;
	}
	public void setR76_individuals(BigDecimal r76_individuals) {
		this.r76_individuals = r76_individuals;
	}
	public BigDecimal getR76_investment() {
		return r76_investment;
	}
	public void setR76_investment(BigDecimal r76_investment) {
		this.r76_investment = r76_investment;
	}
	public BigDecimal getR76_nbfi1() {
		return r76_nbfi1;
	}
	public void setR76_nbfi1(BigDecimal r76_nbfi1) {
		this.r76_nbfi1 = r76_nbfi1;
	}
	public BigDecimal getR76_interbank1() {
		return r76_interbank1;
	}
	public void setR76_interbank1(BigDecimal r76_interbank1) {
		this.r76_interbank1 = r76_interbank1;
	}
	public BigDecimal getR76_gov1() {
		return r76_gov1;
	}
	public void setR76_gov1(BigDecimal r76_gov1) {
		this.r76_gov1 = r76_gov1;
	}
	public BigDecimal getR76_corporate1() {
		return r76_corporate1;
	}
	public void setR76_corporate1(BigDecimal r76_corporate1) {
		this.r76_corporate1 = r76_corporate1;
	}
	public BigDecimal getR76_gre1() {
		return r76_gre1;
	}
	public void setR76_gre1(BigDecimal r76_gre1) {
		this.r76_gre1 = r76_gre1;
	}
	public BigDecimal getR76_trade1() {
		return r76_trade1;
	}
	public void setR76_trade1(BigDecimal r76_trade1) {
		this.r76_trade1 = r76_trade1;
	}
	public BigDecimal getR76_individuals1() {
		return r76_individuals1;
	}
	public void setR76_individuals1(BigDecimal r76_individuals1) {
		this.r76_individuals1 = r76_individuals1;
	}
	public BigDecimal getR76_investment1() {
		return r76_investment1;
	}
	public void setR76_investment1(BigDecimal r76_investment1) {
		this.r76_investment1 = r76_investment1;
	}
	public BigDecimal getR76_zer0() {
		return r76_zer0;
	}
	public void setR76_zer0(BigDecimal r76_zer0) {
		this.r76_zer0 = r76_zer0;
	}
	public BigDecimal getR76_three() {
		return r76_three;
	}
	public void setR76_three(BigDecimal r76_three) {
		this.r76_three = r76_three;
	}
	public BigDecimal getR76_six() {
		return r76_six;
	}
	public void setR76_six(BigDecimal r76_six) {
		this.r76_six = r76_six;
	}
	public BigDecimal getR76_oneyear() {
		return r76_oneyear;
	}
	public void setR76_oneyear(BigDecimal r76_oneyear) {
		this.r76_oneyear = r76_oneyear;
	}
	public BigDecimal getR76_foreign() {
		return r76_foreign;
	}
	public void setR76_foreign(BigDecimal r76_foreign) {
		this.r76_foreign = r76_foreign;
	}
	public BigDecimal getR76_banks() {
		return r76_banks;
	}
	public void setR76_banks(BigDecimal r76_banks) {
		this.r76_banks = r76_banks;
	}
	public BigDecimal getR76_gov2() {
		return r76_gov2;
	}
	public void setR76_gov2(BigDecimal r76_gov2) {
		this.r76_gov2 = r76_gov2;
	}
	public BigDecimal getR76_other() {
		return r76_other;
	}
	public void setR76_other(BigDecimal r76_other) {
		this.r76_other = r76_other;
	}
	public BigDecimal getR76_banks1() {
		return r76_banks1;
	}
	public void setR76_banks1(BigDecimal r76_banks1) {
		this.r76_banks1 = r76_banks1;
	}
	public BigDecimal getR76_individuals2() {
		return r76_individuals2;
	}
	public void setR76_individuals2(BigDecimal r76_individuals2) {
		this.r76_individuals2 = r76_individuals2;
	}
	public BigDecimal getR76_other1() {
		return r76_other1;
	}
	public void setR76_other1(BigDecimal r76_other1) {
		this.r76_other1 = r76_other1;
	}
	public BigDecimal getR76_banks2() {
		return r76_banks2;
	}
	public void setR76_banks2(BigDecimal r76_banks2) {
		this.r76_banks2 = r76_banks2;
	}
	public BigDecimal getR76_gov3() {
		return r76_gov3;
	}
	public void setR76_gov3(BigDecimal r76_gov3) {
		this.r76_gov3 = r76_gov3;
	}
	public BigDecimal getR76_others2() {
		return r76_others2;
	}
	public void setR76_others2(BigDecimal r76_others2) {
		this.r76_others2 = r76_others2;
	}
	public BigDecimal getR76_banks3() {
		return r76_banks3;
	}
	public void setR76_banks3(BigDecimal r76_banks3) {
		this.r76_banks3 = r76_banks3;
	}
	public BigDecimal getR76_gov4() {
		return r76_gov4;
	}
	public void setR76_gov4(BigDecimal r76_gov4) {
		this.r76_gov4 = r76_gov4;
	}
	public BigDecimal getR76_others3() {
		return r76_others3;
	}
	public void setR76_others3(BigDecimal r76_others3) {
		this.r76_others3 = r76_others3;
	}
	public BigDecimal getR76_foreign1() {
		return r76_foreign1;
	}
	public void setR76_foreign1(BigDecimal r76_foreign1) {
		this.r76_foreign1 = r76_foreign1;
	}
	public BigDecimal getR76_guarantees() {
		return r76_guarantees;
	}
	public void setR76_guarantees(BigDecimal r76_guarantees) {
		this.r76_guarantees = r76_guarantees;
	}
	public BigDecimal getR76_nbfi2() {
		return r76_nbfi2;
	}
	public void setR76_nbfi2(BigDecimal r76_nbfi2) {
		this.r76_nbfi2 = r76_nbfi2;
	}
	public BigDecimal getR76_interbank2() {
		return r76_interbank2;
	}
	public void setR76_interbank2(BigDecimal r76_interbank2) {
		this.r76_interbank2 = r76_interbank2;
	}
	public BigDecimal getR76_gov5() {
		return r76_gov5;
	}
	public void setR76_gov5(BigDecimal r76_gov5) {
		this.r76_gov5 = r76_gov5;
	}
	public BigDecimal getR76_corporate2() {
		return r76_corporate2;
	}
	public void setR76_corporate2(BigDecimal r76_corporate2) {
		this.r76_corporate2 = r76_corporate2;
	}
	public BigDecimal getR76_gre2() {
		return r76_gre2;
	}
	public void setR76_gre2(BigDecimal r76_gre2) {
		this.r76_gre2 = r76_gre2;
	}
	public BigDecimal getR76_individuals3() {
		return r76_individuals3;
	}
	public void setR76_individuals3(BigDecimal r76_individuals3) {
		this.r76_individuals3 = r76_individuals3;
	}
	public BigDecimal getR76_zero1() {
		return r76_zero1;
	}
	public void setR76_zero1(BigDecimal r76_zero1) {
		this.r76_zero1 = r76_zero1;
	}
	public BigDecimal getR76_three1() {
		return r76_three1;
	}
	public void setR76_three1(BigDecimal r76_three1) {
		this.r76_three1 = r76_three1;
	}
	public BigDecimal getR76_six1() {
		return r76_six1;
	}
	public void setR76_six1(BigDecimal r76_six1) {
		this.r76_six1 = r76_six1;
	}
	public BigDecimal getR76_oneyear1() {
		return r76_oneyear1;
	}
	public void setR76_oneyear1(BigDecimal r76_oneyear1) {
		this.r76_oneyear1 = r76_oneyear1;
	}
	public String getR76_empty() {
		return r76_empty;
	}
	public void setR76_empty(String r76_empty) {
		this.r76_empty = r76_empty;
	}
	public String getR77_product() {
		return r77_product;
	}
	public void setR77_product(String r77_product) {
		this.r77_product = r77_product;
	}
	public BigDecimal getR77_nbfi() {
		return r77_nbfi;
	}
	public void setR77_nbfi(BigDecimal r77_nbfi) {
		this.r77_nbfi = r77_nbfi;
	}
	public BigDecimal getR77_interbank() {
		return r77_interbank;
	}
	public void setR77_interbank(BigDecimal r77_interbank) {
		this.r77_interbank = r77_interbank;
	}
	public BigDecimal getR77_gov() {
		return r77_gov;
	}
	public void setR77_gov(BigDecimal r77_gov) {
		this.r77_gov = r77_gov;
	}
	public BigDecimal getR77_corporate() {
		return r77_corporate;
	}
	public void setR77_corporate(BigDecimal r77_corporate) {
		this.r77_corporate = r77_corporate;
	}
	public BigDecimal getR77_gre() {
		return r77_gre;
	}
	public void setR77_gre(BigDecimal r77_gre) {
		this.r77_gre = r77_gre;
	}
	public BigDecimal getR77_trade() {
		return r77_trade;
	}
	public void setR77_trade(BigDecimal r77_trade) {
		this.r77_trade = r77_trade;
	}
	public BigDecimal getR77_individuals() {
		return r77_individuals;
	}
	public void setR77_individuals(BigDecimal r77_individuals) {
		this.r77_individuals = r77_individuals;
	}
	public BigDecimal getR77_investment() {
		return r77_investment;
	}
	public void setR77_investment(BigDecimal r77_investment) {
		this.r77_investment = r77_investment;
	}
	public BigDecimal getR77_nbfi1() {
		return r77_nbfi1;
	}
	public void setR77_nbfi1(BigDecimal r77_nbfi1) {
		this.r77_nbfi1 = r77_nbfi1;
	}
	public BigDecimal getR77_interbank1() {
		return r77_interbank1;
	}
	public void setR77_interbank1(BigDecimal r77_interbank1) {
		this.r77_interbank1 = r77_interbank1;
	}
	public BigDecimal getR77_gov1() {
		return r77_gov1;
	}
	public void setR77_gov1(BigDecimal r77_gov1) {
		this.r77_gov1 = r77_gov1;
	}
	public BigDecimal getR77_corporate1() {
		return r77_corporate1;
	}
	public void setR77_corporate1(BigDecimal r77_corporate1) {
		this.r77_corporate1 = r77_corporate1;
	}
	public BigDecimal getR77_gre1() {
		return r77_gre1;
	}
	public void setR77_gre1(BigDecimal r77_gre1) {
		this.r77_gre1 = r77_gre1;
	}
	public BigDecimal getR77_trade1() {
		return r77_trade1;
	}
	public void setR77_trade1(BigDecimal r77_trade1) {
		this.r77_trade1 = r77_trade1;
	}
	public BigDecimal getR77_individuals1() {
		return r77_individuals1;
	}
	public void setR77_individuals1(BigDecimal r77_individuals1) {
		this.r77_individuals1 = r77_individuals1;
	}
	public BigDecimal getR77_investment1() {
		return r77_investment1;
	}
	public void setR77_investment1(BigDecimal r77_investment1) {
		this.r77_investment1 = r77_investment1;
	}
	public BigDecimal getR77_zer0() {
		return r77_zer0;
	}
	public void setR77_zer0(BigDecimal r77_zer0) {
		this.r77_zer0 = r77_zer0;
	}
	public BigDecimal getR77_three() {
		return r77_three;
	}
	public void setR77_three(BigDecimal r77_three) {
		this.r77_three = r77_three;
	}
	public BigDecimal getR77_six() {
		return r77_six;
	}
	public void setR77_six(BigDecimal r77_six) {
		this.r77_six = r77_six;
	}
	public BigDecimal getR77_oneyear() {
		return r77_oneyear;
	}
	public void setR77_oneyear(BigDecimal r77_oneyear) {
		this.r77_oneyear = r77_oneyear;
	}
	public BigDecimal getR77_foreign() {
		return r77_foreign;
	}
	public void setR77_foreign(BigDecimal r77_foreign) {
		this.r77_foreign = r77_foreign;
	}
	public BigDecimal getR77_banks() {
		return r77_banks;
	}
	public void setR77_banks(BigDecimal r77_banks) {
		this.r77_banks = r77_banks;
	}
	public BigDecimal getR77_gov2() {
		return r77_gov2;
	}
	public void setR77_gov2(BigDecimal r77_gov2) {
		this.r77_gov2 = r77_gov2;
	}
	public BigDecimal getR77_other() {
		return r77_other;
	}
	public void setR77_other(BigDecimal r77_other) {
		this.r77_other = r77_other;
	}
	public BigDecimal getR77_banks1() {
		return r77_banks1;
	}
	public void setR77_banks1(BigDecimal r77_banks1) {
		this.r77_banks1 = r77_banks1;
	}
	public BigDecimal getR77_individuals2() {
		return r77_individuals2;
	}
	public void setR77_individuals2(BigDecimal r77_individuals2) {
		this.r77_individuals2 = r77_individuals2;
	}
	public BigDecimal getR77_other1() {
		return r77_other1;
	}
	public void setR77_other1(BigDecimal r77_other1) {
		this.r77_other1 = r77_other1;
	}
	public BigDecimal getR77_banks2() {
		return r77_banks2;
	}
	public void setR77_banks2(BigDecimal r77_banks2) {
		this.r77_banks2 = r77_banks2;
	}
	public BigDecimal getR77_gov3() {
		return r77_gov3;
	}
	public void setR77_gov3(BigDecimal r77_gov3) {
		this.r77_gov3 = r77_gov3;
	}
	public BigDecimal getR77_others2() {
		return r77_others2;
	}
	public void setR77_others2(BigDecimal r77_others2) {
		this.r77_others2 = r77_others2;
	}
	public BigDecimal getR77_banks3() {
		return r77_banks3;
	}
	public void setR77_banks3(BigDecimal r77_banks3) {
		this.r77_banks3 = r77_banks3;
	}
	public BigDecimal getR77_gov4() {
		return r77_gov4;
	}
	public void setR77_gov4(BigDecimal r77_gov4) {
		this.r77_gov4 = r77_gov4;
	}
	public BigDecimal getR77_others3() {
		return r77_others3;
	}
	public void setR77_others3(BigDecimal r77_others3) {
		this.r77_others3 = r77_others3;
	}
	public BigDecimal getR77_foreign1() {
		return r77_foreign1;
	}
	public void setR77_foreign1(BigDecimal r77_foreign1) {
		this.r77_foreign1 = r77_foreign1;
	}
	public BigDecimal getR77_guarantees() {
		return r77_guarantees;
	}
	public void setR77_guarantees(BigDecimal r77_guarantees) {
		this.r77_guarantees = r77_guarantees;
	}
	public BigDecimal getR77_nbfi2() {
		return r77_nbfi2;
	}
	public void setR77_nbfi2(BigDecimal r77_nbfi2) {
		this.r77_nbfi2 = r77_nbfi2;
	}
	public BigDecimal getR77_interbank2() {
		return r77_interbank2;
	}
	public void setR77_interbank2(BigDecimal r77_interbank2) {
		this.r77_interbank2 = r77_interbank2;
	}
	public BigDecimal getR77_gov5() {
		return r77_gov5;
	}
	public void setR77_gov5(BigDecimal r77_gov5) {
		this.r77_gov5 = r77_gov5;
	}
	public BigDecimal getR77_corporate2() {
		return r77_corporate2;
	}
	public void setR77_corporate2(BigDecimal r77_corporate2) {
		this.r77_corporate2 = r77_corporate2;
	}
	public BigDecimal getR77_gre2() {
		return r77_gre2;
	}
	public void setR77_gre2(BigDecimal r77_gre2) {
		this.r77_gre2 = r77_gre2;
	}
	public BigDecimal getR77_individuals3() {
		return r77_individuals3;
	}
	public void setR77_individuals3(BigDecimal r77_individuals3) {
		this.r77_individuals3 = r77_individuals3;
	}
	public BigDecimal getR77_zero1() {
		return r77_zero1;
	}
	public void setR77_zero1(BigDecimal r77_zero1) {
		this.r77_zero1 = r77_zero1;
	}
	public BigDecimal getR77_three1() {
		return r77_three1;
	}
	public void setR77_three1(BigDecimal r77_three1) {
		this.r77_three1 = r77_three1;
	}
	public BigDecimal getR77_six1() {
		return r77_six1;
	}
	public void setR77_six1(BigDecimal r77_six1) {
		this.r77_six1 = r77_six1;
	}
	public BigDecimal getR77_oneyear1() {
		return r77_oneyear1;
	}
	public void setR77_oneyear1(BigDecimal r77_oneyear1) {
		this.r77_oneyear1 = r77_oneyear1;
	}
	public String getR77_empty() {
		return r77_empty;
	}
	public void setR77_empty(String r77_empty) {
		this.r77_empty = r77_empty;
	}
	public String getR78_product() {
		return r78_product;
	}
	public void setR78_product(String r78_product) {
		this.r78_product = r78_product;
	}
	public BigDecimal getR78_nbfi() {
		return r78_nbfi;
	}
	public void setR78_nbfi(BigDecimal r78_nbfi) {
		this.r78_nbfi = r78_nbfi;
	}
	public BigDecimal getR78_interbank() {
		return r78_interbank;
	}
	public void setR78_interbank(BigDecimal r78_interbank) {
		this.r78_interbank = r78_interbank;
	}
	public BigDecimal getR78_gov() {
		return r78_gov;
	}
	public void setR78_gov(BigDecimal r78_gov) {
		this.r78_gov = r78_gov;
	}
	public BigDecimal getR78_corporate() {
		return r78_corporate;
	}
	public void setR78_corporate(BigDecimal r78_corporate) {
		this.r78_corporate = r78_corporate;
	}
	public BigDecimal getR78_gre() {
		return r78_gre;
	}
	public void setR78_gre(BigDecimal r78_gre) {
		this.r78_gre = r78_gre;
	}
	public BigDecimal getR78_trade() {
		return r78_trade;
	}
	public void setR78_trade(BigDecimal r78_trade) {
		this.r78_trade = r78_trade;
	}
	public BigDecimal getR78_individuals() {
		return r78_individuals;
	}
	public void setR78_individuals(BigDecimal r78_individuals) {
		this.r78_individuals = r78_individuals;
	}
	public BigDecimal getR78_investment() {
		return r78_investment;
	}
	public void setR78_investment(BigDecimal r78_investment) {
		this.r78_investment = r78_investment;
	}
	public BigDecimal getR78_nbfi1() {
		return r78_nbfi1;
	}
	public void setR78_nbfi1(BigDecimal r78_nbfi1) {
		this.r78_nbfi1 = r78_nbfi1;
	}
	public BigDecimal getR78_interbank1() {
		return r78_interbank1;
	}
	public void setR78_interbank1(BigDecimal r78_interbank1) {
		this.r78_interbank1 = r78_interbank1;
	}
	public BigDecimal getR78_gov1() {
		return r78_gov1;
	}
	public void setR78_gov1(BigDecimal r78_gov1) {
		this.r78_gov1 = r78_gov1;
	}
	public BigDecimal getR78_corporate1() {
		return r78_corporate1;
	}
	public void setR78_corporate1(BigDecimal r78_corporate1) {
		this.r78_corporate1 = r78_corporate1;
	}
	public BigDecimal getR78_gre1() {
		return r78_gre1;
	}
	public void setR78_gre1(BigDecimal r78_gre1) {
		this.r78_gre1 = r78_gre1;
	}
	public BigDecimal getR78_trade1() {
		return r78_trade1;
	}
	public void setR78_trade1(BigDecimal r78_trade1) {
		this.r78_trade1 = r78_trade1;
	}
	public BigDecimal getR78_individuals1() {
		return r78_individuals1;
	}
	public void setR78_individuals1(BigDecimal r78_individuals1) {
		this.r78_individuals1 = r78_individuals1;
	}
	public BigDecimal getR78_investment1() {
		return r78_investment1;
	}
	public void setR78_investment1(BigDecimal r78_investment1) {
		this.r78_investment1 = r78_investment1;
	}
	public BigDecimal getR78_zer0() {
		return r78_zer0;
	}
	public void setR78_zer0(BigDecimal r78_zer0) {
		this.r78_zer0 = r78_zer0;
	}
	public BigDecimal getR78_three() {
		return r78_three;
	}
	public void setR78_three(BigDecimal r78_three) {
		this.r78_three = r78_three;
	}
	public BigDecimal getR78_six() {
		return r78_six;
	}
	public void setR78_six(BigDecimal r78_six) {
		this.r78_six = r78_six;
	}
	public BigDecimal getR78_oneyear() {
		return r78_oneyear;
	}
	public void setR78_oneyear(BigDecimal r78_oneyear) {
		this.r78_oneyear = r78_oneyear;
	}
	public BigDecimal getR78_foreign() {
		return r78_foreign;
	}
	public void setR78_foreign(BigDecimal r78_foreign) {
		this.r78_foreign = r78_foreign;
	}
	public BigDecimal getR78_banks() {
		return r78_banks;
	}
	public void setR78_banks(BigDecimal r78_banks) {
		this.r78_banks = r78_banks;
	}
	public BigDecimal getR78_gov2() {
		return r78_gov2;
	}
	public void setR78_gov2(BigDecimal r78_gov2) {
		this.r78_gov2 = r78_gov2;
	}
	public BigDecimal getR78_other() {
		return r78_other;
	}
	public void setR78_other(BigDecimal r78_other) {
		this.r78_other = r78_other;
	}
	public BigDecimal getR78_banks1() {
		return r78_banks1;
	}
	public void setR78_banks1(BigDecimal r78_banks1) {
		this.r78_banks1 = r78_banks1;
	}
	public BigDecimal getR78_individuals2() {
		return r78_individuals2;
	}
	public void setR78_individuals2(BigDecimal r78_individuals2) {
		this.r78_individuals2 = r78_individuals2;
	}
	public BigDecimal getR78_other1() {
		return r78_other1;
	}
	public void setR78_other1(BigDecimal r78_other1) {
		this.r78_other1 = r78_other1;
	}
	public BigDecimal getR78_banks2() {
		return r78_banks2;
	}
	public void setR78_banks2(BigDecimal r78_banks2) {
		this.r78_banks2 = r78_banks2;
	}
	public BigDecimal getR78_gov3() {
		return r78_gov3;
	}
	public void setR78_gov3(BigDecimal r78_gov3) {
		this.r78_gov3 = r78_gov3;
	}
	public BigDecimal getR78_others2() {
		return r78_others2;
	}
	public void setR78_others2(BigDecimal r78_others2) {
		this.r78_others2 = r78_others2;
	}
	public BigDecimal getR78_banks3() {
		return r78_banks3;
	}
	public void setR78_banks3(BigDecimal r78_banks3) {
		this.r78_banks3 = r78_banks3;
	}
	public BigDecimal getR78_gov4() {
		return r78_gov4;
	}
	public void setR78_gov4(BigDecimal r78_gov4) {
		this.r78_gov4 = r78_gov4;
	}
	public BigDecimal getR78_others3() {
		return r78_others3;
	}
	public void setR78_others3(BigDecimal r78_others3) {
		this.r78_others3 = r78_others3;
	}
	public BigDecimal getR78_foreign1() {
		return r78_foreign1;
	}
	public void setR78_foreign1(BigDecimal r78_foreign1) {
		this.r78_foreign1 = r78_foreign1;
	}
	public BigDecimal getR78_guarantees() {
		return r78_guarantees;
	}
	public void setR78_guarantees(BigDecimal r78_guarantees) {
		this.r78_guarantees = r78_guarantees;
	}
	public BigDecimal getR78_nbfi2() {
		return r78_nbfi2;
	}
	public void setR78_nbfi2(BigDecimal r78_nbfi2) {
		this.r78_nbfi2 = r78_nbfi2;
	}
	public BigDecimal getR78_interbank2() {
		return r78_interbank2;
	}
	public void setR78_interbank2(BigDecimal r78_interbank2) {
		this.r78_interbank2 = r78_interbank2;
	}
	public BigDecimal getR78_gov5() {
		return r78_gov5;
	}
	public void setR78_gov5(BigDecimal r78_gov5) {
		this.r78_gov5 = r78_gov5;
	}
	public BigDecimal getR78_corporate2() {
		return r78_corporate2;
	}
	public void setR78_corporate2(BigDecimal r78_corporate2) {
		this.r78_corporate2 = r78_corporate2;
	}
	public BigDecimal getR78_gre2() {
		return r78_gre2;
	}
	public void setR78_gre2(BigDecimal r78_gre2) {
		this.r78_gre2 = r78_gre2;
	}
	public BigDecimal getR78_individuals3() {
		return r78_individuals3;
	}
	public void setR78_individuals3(BigDecimal r78_individuals3) {
		this.r78_individuals3 = r78_individuals3;
	}
	public BigDecimal getR78_zero1() {
		return r78_zero1;
	}
	public void setR78_zero1(BigDecimal r78_zero1) {
		this.r78_zero1 = r78_zero1;
	}
	public BigDecimal getR78_three1() {
		return r78_three1;
	}
	public void setR78_three1(BigDecimal r78_three1) {
		this.r78_three1 = r78_three1;
	}
	public BigDecimal getR78_six1() {
		return r78_six1;
	}
	public void setR78_six1(BigDecimal r78_six1) {
		this.r78_six1 = r78_six1;
	}
	public BigDecimal getR78_oneyear1() {
		return r78_oneyear1;
	}
	public void setR78_oneyear1(BigDecimal r78_oneyear1) {
		this.r78_oneyear1 = r78_oneyear1;
	}
	public String getR78_empty() {
		return r78_empty;
	}
	public void setR78_empty(String r78_empty) {
		this.r78_empty = r78_empty;
	}
	public String getR79_product() {
		return r79_product;
	}
	public void setR79_product(String r79_product) {
		this.r79_product = r79_product;
	}
	public BigDecimal getR79_nbfi() {
		return r79_nbfi;
	}
	public void setR79_nbfi(BigDecimal r79_nbfi) {
		this.r79_nbfi = r79_nbfi;
	}
	public BigDecimal getR79_interbank() {
		return r79_interbank;
	}
	public void setR79_interbank(BigDecimal r79_interbank) {
		this.r79_interbank = r79_interbank;
	}
	public BigDecimal getR79_gov() {
		return r79_gov;
	}
	public void setR79_gov(BigDecimal r79_gov) {
		this.r79_gov = r79_gov;
	}
	public BigDecimal getR79_corporate() {
		return r79_corporate;
	}
	public void setR79_corporate(BigDecimal r79_corporate) {
		this.r79_corporate = r79_corporate;
	}
	public BigDecimal getR79_gre() {
		return r79_gre;
	}
	public void setR79_gre(BigDecimal r79_gre) {
		this.r79_gre = r79_gre;
	}
	public BigDecimal getR79_trade() {
		return r79_trade;
	}
	public void setR79_trade(BigDecimal r79_trade) {
		this.r79_trade = r79_trade;
	}
	public BigDecimal getR79_individuals() {
		return r79_individuals;
	}
	public void setR79_individuals(BigDecimal r79_individuals) {
		this.r79_individuals = r79_individuals;
	}
	public BigDecimal getR79_investment() {
		return r79_investment;
	}
	public void setR79_investment(BigDecimal r79_investment) {
		this.r79_investment = r79_investment;
	}
	public BigDecimal getR79_nbfi1() {
		return r79_nbfi1;
	}
	public void setR79_nbfi1(BigDecimal r79_nbfi1) {
		this.r79_nbfi1 = r79_nbfi1;
	}
	public BigDecimal getR79_interbank1() {
		return r79_interbank1;
	}
	public void setR79_interbank1(BigDecimal r79_interbank1) {
		this.r79_interbank1 = r79_interbank1;
	}
	public BigDecimal getR79_gov1() {
		return r79_gov1;
	}
	public void setR79_gov1(BigDecimal r79_gov1) {
		this.r79_gov1 = r79_gov1;
	}
	public BigDecimal getR79_corporate1() {
		return r79_corporate1;
	}
	public void setR79_corporate1(BigDecimal r79_corporate1) {
		this.r79_corporate1 = r79_corporate1;
	}
	public BigDecimal getR79_gre1() {
		return r79_gre1;
	}
	public void setR79_gre1(BigDecimal r79_gre1) {
		this.r79_gre1 = r79_gre1;
	}
	public BigDecimal getR79_trade1() {
		return r79_trade1;
	}
	public void setR79_trade1(BigDecimal r79_trade1) {
		this.r79_trade1 = r79_trade1;
	}
	public BigDecimal getR79_individuals1() {
		return r79_individuals1;
	}
	public void setR79_individuals1(BigDecimal r79_individuals1) {
		this.r79_individuals1 = r79_individuals1;
	}
	public BigDecimal getR79_investment1() {
		return r79_investment1;
	}
	public void setR79_investment1(BigDecimal r79_investment1) {
		this.r79_investment1 = r79_investment1;
	}
	public BigDecimal getR79_zer0() {
		return r79_zer0;
	}
	public void setR79_zer0(BigDecimal r79_zer0) {
		this.r79_zer0 = r79_zer0;
	}
	public BigDecimal getR79_three() {
		return r79_three;
	}
	public void setR79_three(BigDecimal r79_three) {
		this.r79_three = r79_three;
	}
	public BigDecimal getR79_six() {
		return r79_six;
	}
	public void setR79_six(BigDecimal r79_six) {
		this.r79_six = r79_six;
	}
	public BigDecimal getR79_oneyear() {
		return r79_oneyear;
	}
	public void setR79_oneyear(BigDecimal r79_oneyear) {
		this.r79_oneyear = r79_oneyear;
	}
	public BigDecimal getR79_foreign() {
		return r79_foreign;
	}
	public void setR79_foreign(BigDecimal r79_foreign) {
		this.r79_foreign = r79_foreign;
	}
	public BigDecimal getR79_banks() {
		return r79_banks;
	}
	public void setR79_banks(BigDecimal r79_banks) {
		this.r79_banks = r79_banks;
	}
	public BigDecimal getR79_gov2() {
		return r79_gov2;
	}
	public void setR79_gov2(BigDecimal r79_gov2) {
		this.r79_gov2 = r79_gov2;
	}
	public BigDecimal getR79_other() {
		return r79_other;
	}
	public void setR79_other(BigDecimal r79_other) {
		this.r79_other = r79_other;
	}
	public BigDecimal getR79_banks1() {
		return r79_banks1;
	}
	public void setR79_banks1(BigDecimal r79_banks1) {
		this.r79_banks1 = r79_banks1;
	}
	public BigDecimal getR79_individuals2() {
		return r79_individuals2;
	}
	public void setR79_individuals2(BigDecimal r79_individuals2) {
		this.r79_individuals2 = r79_individuals2;
	}
	public BigDecimal getR79_other1() {
		return r79_other1;
	}
	public void setR79_other1(BigDecimal r79_other1) {
		this.r79_other1 = r79_other1;
	}
	public BigDecimal getR79_banks2() {
		return r79_banks2;
	}
	public void setR79_banks2(BigDecimal r79_banks2) {
		this.r79_banks2 = r79_banks2;
	}
	public BigDecimal getR79_gov3() {
		return r79_gov3;
	}
	public void setR79_gov3(BigDecimal r79_gov3) {
		this.r79_gov3 = r79_gov3;
	}
	public BigDecimal getR79_others2() {
		return r79_others2;
	}
	public void setR79_others2(BigDecimal r79_others2) {
		this.r79_others2 = r79_others2;
	}
	public BigDecimal getR79_banks3() {
		return r79_banks3;
	}
	public void setR79_banks3(BigDecimal r79_banks3) {
		this.r79_banks3 = r79_banks3;
	}
	public BigDecimal getR79_gov4() {
		return r79_gov4;
	}
	public void setR79_gov4(BigDecimal r79_gov4) {
		this.r79_gov4 = r79_gov4;
	}
	public BigDecimal getR79_others3() {
		return r79_others3;
	}
	public void setR79_others3(BigDecimal r79_others3) {
		this.r79_others3 = r79_others3;
	}
	public BigDecimal getR79_foreign1() {
		return r79_foreign1;
	}
	public void setR79_foreign1(BigDecimal r79_foreign1) {
		this.r79_foreign1 = r79_foreign1;
	}
	public BigDecimal getR79_guarantees() {
		return r79_guarantees;
	}
	public void setR79_guarantees(BigDecimal r79_guarantees) {
		this.r79_guarantees = r79_guarantees;
	}
	public BigDecimal getR79_nbfi2() {
		return r79_nbfi2;
	}
	public void setR79_nbfi2(BigDecimal r79_nbfi2) {
		this.r79_nbfi2 = r79_nbfi2;
	}
	public BigDecimal getR79_interbank2() {
		return r79_interbank2;
	}
	public void setR79_interbank2(BigDecimal r79_interbank2) {
		this.r79_interbank2 = r79_interbank2;
	}
	public BigDecimal getR79_gov5() {
		return r79_gov5;
	}
	public void setR79_gov5(BigDecimal r79_gov5) {
		this.r79_gov5 = r79_gov5;
	}
	public BigDecimal getR79_corporate2() {
		return r79_corporate2;
	}
	public void setR79_corporate2(BigDecimal r79_corporate2) {
		this.r79_corporate2 = r79_corporate2;
	}
	public BigDecimal getR79_gre2() {
		return r79_gre2;
	}
	public void setR79_gre2(BigDecimal r79_gre2) {
		this.r79_gre2 = r79_gre2;
	}
	public BigDecimal getR79_individuals3() {
		return r79_individuals3;
	}
	public void setR79_individuals3(BigDecimal r79_individuals3) {
		this.r79_individuals3 = r79_individuals3;
	}
	public BigDecimal getR79_zero1() {
		return r79_zero1;
	}
	public void setR79_zero1(BigDecimal r79_zero1) {
		this.r79_zero1 = r79_zero1;
	}
	public BigDecimal getR79_three1() {
		return r79_three1;
	}
	public void setR79_three1(BigDecimal r79_three1) {
		this.r79_three1 = r79_three1;
	}
	public BigDecimal getR79_six1() {
		return r79_six1;
	}
	public void setR79_six1(BigDecimal r79_six1) {
		this.r79_six1 = r79_six1;
	}
	public BigDecimal getR79_oneyear1() {
		return r79_oneyear1;
	}
	public void setR79_oneyear1(BigDecimal r79_oneyear1) {
		this.r79_oneyear1 = r79_oneyear1;
	}
	public String getR79_empty() {
		return r79_empty;
	}
	public void setR79_empty(String r79_empty) {
		this.r79_empty = r79_empty;
	}
	public String getR80_product() {
		return r80_product;
	}
	public void setR80_product(String r80_product) {
		this.r80_product = r80_product;
	}
	public BigDecimal getR80_nbfi() {
		return r80_nbfi;
	}
	public void setR80_nbfi(BigDecimal r80_nbfi) {
		this.r80_nbfi = r80_nbfi;
	}
	public BigDecimal getR80_interbank() {
		return r80_interbank;
	}
	public void setR80_interbank(BigDecimal r80_interbank) {
		this.r80_interbank = r80_interbank;
	}
	public BigDecimal getR80_gov() {
		return r80_gov;
	}
	public void setR80_gov(BigDecimal r80_gov) {
		this.r80_gov = r80_gov;
	}
	public BigDecimal getR80_corporate() {
		return r80_corporate;
	}
	public void setR80_corporate(BigDecimal r80_corporate) {
		this.r80_corporate = r80_corporate;
	}
	public BigDecimal getR80_gre() {
		return r80_gre;
	}
	public void setR80_gre(BigDecimal r80_gre) {
		this.r80_gre = r80_gre;
	}
	public BigDecimal getR80_trade() {
		return r80_trade;
	}
	public void setR80_trade(BigDecimal r80_trade) {
		this.r80_trade = r80_trade;
	}
	public BigDecimal getR80_individuals() {
		return r80_individuals;
	}
	public void setR80_individuals(BigDecimal r80_individuals) {
		this.r80_individuals = r80_individuals;
	}
	public BigDecimal getR80_investment() {
		return r80_investment;
	}
	public void setR80_investment(BigDecimal r80_investment) {
		this.r80_investment = r80_investment;
	}
	public BigDecimal getR80_nbfi1() {
		return r80_nbfi1;
	}
	public void setR80_nbfi1(BigDecimal r80_nbfi1) {
		this.r80_nbfi1 = r80_nbfi1;
	}
	public BigDecimal getR80_interbank1() {
		return r80_interbank1;
	}
	public void setR80_interbank1(BigDecimal r80_interbank1) {
		this.r80_interbank1 = r80_interbank1;
	}
	public BigDecimal getR80_gov1() {
		return r80_gov1;
	}
	public void setR80_gov1(BigDecimal r80_gov1) {
		this.r80_gov1 = r80_gov1;
	}
	public BigDecimal getR80_corporate1() {
		return r80_corporate1;
	}
	public void setR80_corporate1(BigDecimal r80_corporate1) {
		this.r80_corporate1 = r80_corporate1;
	}
	public BigDecimal getR80_gre1() {
		return r80_gre1;
	}
	public void setR80_gre1(BigDecimal r80_gre1) {
		this.r80_gre1 = r80_gre1;
	}
	public BigDecimal getR80_trade1() {
		return r80_trade1;
	}
	public void setR80_trade1(BigDecimal r80_trade1) {
		this.r80_trade1 = r80_trade1;
	}
	public BigDecimal getR80_individuals1() {
		return r80_individuals1;
	}
	public void setR80_individuals1(BigDecimal r80_individuals1) {
		this.r80_individuals1 = r80_individuals1;
	}
	public BigDecimal getR80_investment1() {
		return r80_investment1;
	}
	public void setR80_investment1(BigDecimal r80_investment1) {
		this.r80_investment1 = r80_investment1;
	}
	public BigDecimal getR80_zer0() {
		return r80_zer0;
	}
	public void setR80_zer0(BigDecimal r80_zer0) {
		this.r80_zer0 = r80_zer0;
	}
	public BigDecimal getR80_three() {
		return r80_three;
	}
	public void setR80_three(BigDecimal r80_three) {
		this.r80_three = r80_three;
	}
	public BigDecimal getR80_six() {
		return r80_six;
	}
	public void setR80_six(BigDecimal r80_six) {
		this.r80_six = r80_six;
	}
	public BigDecimal getR80_oneyear() {
		return r80_oneyear;
	}
	public void setR80_oneyear(BigDecimal r80_oneyear) {
		this.r80_oneyear = r80_oneyear;
	}
	public BigDecimal getR80_foreign() {
		return r80_foreign;
	}
	public void setR80_foreign(BigDecimal r80_foreign) {
		this.r80_foreign = r80_foreign;
	}
	public BigDecimal getR80_banks() {
		return r80_banks;
	}
	public void setR80_banks(BigDecimal r80_banks) {
		this.r80_banks = r80_banks;
	}
	public BigDecimal getR80_gov2() {
		return r80_gov2;
	}
	public void setR80_gov2(BigDecimal r80_gov2) {
		this.r80_gov2 = r80_gov2;
	}
	public BigDecimal getR80_other() {
		return r80_other;
	}
	public void setR80_other(BigDecimal r80_other) {
		this.r80_other = r80_other;
	}
	public BigDecimal getR80_banks1() {
		return r80_banks1;
	}
	public void setR80_banks1(BigDecimal r80_banks1) {
		this.r80_banks1 = r80_banks1;
	}
	public BigDecimal getR80_individuals2() {
		return r80_individuals2;
	}
	public void setR80_individuals2(BigDecimal r80_individuals2) {
		this.r80_individuals2 = r80_individuals2;
	}
	public BigDecimal getR80_other1() {
		return r80_other1;
	}
	public void setR80_other1(BigDecimal r80_other1) {
		this.r80_other1 = r80_other1;
	}
	public BigDecimal getR80_banks2() {
		return r80_banks2;
	}
	public void setR80_banks2(BigDecimal r80_banks2) {
		this.r80_banks2 = r80_banks2;
	}
	public BigDecimal getR80_gov3() {
		return r80_gov3;
	}
	public void setR80_gov3(BigDecimal r80_gov3) {
		this.r80_gov3 = r80_gov3;
	}
	public BigDecimal getR80_others2() {
		return r80_others2;
	}
	public void setR80_others2(BigDecimal r80_others2) {
		this.r80_others2 = r80_others2;
	}
	public BigDecimal getR80_banks3() {
		return r80_banks3;
	}
	public void setR80_banks3(BigDecimal r80_banks3) {
		this.r80_banks3 = r80_banks3;
	}
	public BigDecimal getR80_gov4() {
		return r80_gov4;
	}
	public void setR80_gov4(BigDecimal r80_gov4) {
		this.r80_gov4 = r80_gov4;
	}
	public BigDecimal getR80_others3() {
		return r80_others3;
	}
	public void setR80_others3(BigDecimal r80_others3) {
		this.r80_others3 = r80_others3;
	}
	public BigDecimal getR80_foreign1() {
		return r80_foreign1;
	}
	public void setR80_foreign1(BigDecimal r80_foreign1) {
		this.r80_foreign1 = r80_foreign1;
	}
	public BigDecimal getR80_guarantees() {
		return r80_guarantees;
	}
	public void setR80_guarantees(BigDecimal r80_guarantees) {
		this.r80_guarantees = r80_guarantees;
	}
	public BigDecimal getR80_nbfi2() {
		return r80_nbfi2;
	}
	public void setR80_nbfi2(BigDecimal r80_nbfi2) {
		this.r80_nbfi2 = r80_nbfi2;
	}
	public BigDecimal getR80_interbank2() {
		return r80_interbank2;
	}
	public void setR80_interbank2(BigDecimal r80_interbank2) {
		this.r80_interbank2 = r80_interbank2;
	}
	public BigDecimal getR80_gov5() {
		return r80_gov5;
	}
	public void setR80_gov5(BigDecimal r80_gov5) {
		this.r80_gov5 = r80_gov5;
	}
	public BigDecimal getR80_corporate2() {
		return r80_corporate2;
	}
	public void setR80_corporate2(BigDecimal r80_corporate2) {
		this.r80_corporate2 = r80_corporate2;
	}
	public BigDecimal getR80_gre2() {
		return r80_gre2;
	}
	public void setR80_gre2(BigDecimal r80_gre2) {
		this.r80_gre2 = r80_gre2;
	}
	public BigDecimal getR80_individuals3() {
		return r80_individuals3;
	}
	public void setR80_individuals3(BigDecimal r80_individuals3) {
		this.r80_individuals3 = r80_individuals3;
	}
	public BigDecimal getR80_zero1() {
		return r80_zero1;
	}
	public void setR80_zero1(BigDecimal r80_zero1) {
		this.r80_zero1 = r80_zero1;
	}
	public BigDecimal getR80_three1() {
		return r80_three1;
	}
	public void setR80_three1(BigDecimal r80_three1) {
		this.r80_three1 = r80_three1;
	}
	public BigDecimal getR80_six1() {
		return r80_six1;
	}
	public void setR80_six1(BigDecimal r80_six1) {
		this.r80_six1 = r80_six1;
	}
	public BigDecimal getR80_oneyear1() {
		return r80_oneyear1;
	}
	public void setR80_oneyear1(BigDecimal r80_oneyear1) {
		this.r80_oneyear1 = r80_oneyear1;
	}
	public String getR80_empty() {
		return r80_empty;
	}
	public void setR80_empty(String r80_empty) {
		this.r80_empty = r80_empty;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public BigDecimal getNbfi_total() {
		return nbfi_total;
	}
	public void setNbfi_total(BigDecimal nbfi_total) {
		this.nbfi_total = nbfi_total;
	}
	public BigDecimal getInterbank_total() {
		return interbank_total;
	}
	public void setInterbank_total(BigDecimal interbank_total) {
		this.interbank_total = interbank_total;
	}
	public BigDecimal getGov_total() {
		return gov_total;
	}
	public void setGov_total(BigDecimal gov_total) {
		this.gov_total = gov_total;
	}
	public BigDecimal getCorporate_total() {
		return corporate_total;
	}
	public void setCorporate_total(BigDecimal corporate_total) {
		this.corporate_total = corporate_total;
	}
	public BigDecimal getGre_total() {
		return gre_total;
	}
	public void setGre_total(BigDecimal gre_total) {
		this.gre_total = gre_total;
	}
	public BigDecimal getTrade_total() {
		return trade_total;
	}
	public void setTrade_total(BigDecimal trade_total) {
		this.trade_total = trade_total;
	}
	public BigDecimal getIndividuals_total() {
		return individuals_total;
	}
	public void setIndividuals_total(BigDecimal individuals_total) {
		this.individuals_total = individuals_total;
	}
	public BigDecimal getInvestment_total() {
		return investment_total;
	}
	public void setInvestment_total(BigDecimal investment_total) {
		this.investment_total = investment_total;
	}
	public BigDecimal getNbfi1_total() {
		return nbfi1_total;
	}
	public void setNbfi1_total(BigDecimal nbfi1_total) {
		this.nbfi1_total = nbfi1_total;
	}
	public BigDecimal getInterbank1_total() {
		return interbank1_total;
	}
	public void setInterbank1_total(BigDecimal interbank1_total) {
		this.interbank1_total = interbank1_total;
	}
	public BigDecimal getGov1_total() {
		return gov1_total;
	}
	public void setGov1_total(BigDecimal gov1_total) {
		this.gov1_total = gov1_total;
	}
	public BigDecimal getCorporate1_total() {
		return corporate1_total;
	}
	public void setCorporate1_total(BigDecimal corporate1_total) {
		this.corporate1_total = corporate1_total;
	}
	public BigDecimal getGre1_total() {
		return gre1_total;
	}
	public void setGre1_total(BigDecimal gre1_total) {
		this.gre1_total = gre1_total;
	}
	public BigDecimal getTrade1_total() {
		return trade1_total;
	}
	public void setTrade1_total(BigDecimal trade1_total) {
		this.trade1_total = trade1_total;
	}
	public BigDecimal getIndividuals1_total() {
		return individuals1_total;
	}
	public void setIndividuals1_total(BigDecimal individuals1_total) {
		this.individuals1_total = individuals1_total;
	}
	public BigDecimal getInvestment1_total() {
		return investment1_total;
	}
	public void setInvestment1_total(BigDecimal investment1_total) {
		this.investment1_total = investment1_total;
	}
	public BigDecimal getZer0_total() {
		return zer0_total;
	}
	public void setZer0_total(BigDecimal zer0_total) {
		this.zer0_total = zer0_total;
	}
	public BigDecimal getThree_total() {
		return three_total;
	}
	public void setThree_total(BigDecimal three_total) {
		this.three_total = three_total;
	}
	public BigDecimal getSix_total() {
		return six_total;
	}
	public void setSix_total(BigDecimal six_total) {
		this.six_total = six_total;
	}
	public BigDecimal getOneyear_total() {
		return oneyear_total;
	}
	public void setOneyear_total(BigDecimal oneyear_total) {
		this.oneyear_total = oneyear_total;
	}
	public BigDecimal getForeign_total() {
		return foreign_total;
	}
	public void setForeign_total(BigDecimal foreign_total) {
		this.foreign_total = foreign_total;
	}
	public BigDecimal getBanks_total() {
		return banks_total;
	}
	public void setBanks_total(BigDecimal banks_total) {
		this.banks_total = banks_total;
	}
	public BigDecimal getGov2_total() {
		return gov2_total;
	}
	public void setGov2_total(BigDecimal gov2_total) {
		this.gov2_total = gov2_total;
	}
	public BigDecimal getOther_total() {
		return other_total;
	}
	public void setOther_total(BigDecimal other_total) {
		this.other_total = other_total;
	}
	public BigDecimal getBanks1_total() {
		return banks1_total;
	}
	public void setBanks1_total(BigDecimal banks1_total) {
		this.banks1_total = banks1_total;
	}
	public BigDecimal getIndividuals2_total() {
		return individuals2_total;
	}
	public void setIndividuals2_total(BigDecimal individuals2_total) {
		this.individuals2_total = individuals2_total;
	}
	public BigDecimal getOther1_total() {
		return other1_total;
	}
	public void setOther1_total(BigDecimal other1_total) {
		this.other1_total = other1_total;
	}
	public BigDecimal getBanks2_total() {
		return banks2_total;
	}
	public void setBanks2_total(BigDecimal banks2_total) {
		this.banks2_total = banks2_total;
	}
	public BigDecimal getGov3_total() {
		return gov3_total;
	}
	public void setGov3_total(BigDecimal gov3_total) {
		this.gov3_total = gov3_total;
	}
	public BigDecimal getOthers2_total() {
		return others2_total;
	}
	public void setOthers2_total(BigDecimal others2_total) {
		this.others2_total = others2_total;
	}
	public BigDecimal getBanks3_total() {
		return banks3_total;
	}
	public void setBanks3_total(BigDecimal banks3_total) {
		this.banks3_total = banks3_total;
	}
	public BigDecimal getGov4_total() {
		return gov4_total;
	}
	public void setGov4_total(BigDecimal gov4_total) {
		this.gov4_total = gov4_total;
	}
	public BigDecimal getOthers3_total() {
		return others3_total;
	}
	public void setOthers3_total(BigDecimal others3_total) {
		this.others3_total = others3_total;
	}
	public BigDecimal getForeign1_total() {
		return foreign1_total;
	}
	public void setForeign1_total(BigDecimal foreign1_total) {
		this.foreign1_total = foreign1_total;
	}
	public BigDecimal getGuarantees_total() {
		return guarantees_total;
	}
	public void setGuarantees_total(BigDecimal guarantees_total) {
		this.guarantees_total = guarantees_total;
	}
	public BigDecimal getNbfi2_total() {
		return nbfi2_total;
	}
	public void setNbfi2_total(BigDecimal nbfi2_total) {
		this.nbfi2_total = nbfi2_total;
	}
	public BigDecimal getInterbank2_total() {
		return interbank2_total;
	}
	public void setInterbank2_total(BigDecimal interbank2_total) {
		this.interbank2_total = interbank2_total;
	}
	public BigDecimal getGov5_total() {
		return gov5_total;
	}
	public void setGov5_total(BigDecimal gov5_total) {
		this.gov5_total = gov5_total;
	}
	public BigDecimal getCorporate2_total() {
		return corporate2_total;
	}
	public void setCorporate2_total(BigDecimal corporate2_total) {
		this.corporate2_total = corporate2_total;
	}
	public BigDecimal getGre2_total() {
		return gre2_total;
	}
	public void setGre2_total(BigDecimal gre2_total) {
		this.gre2_total = gre2_total;
	}
	public BigDecimal getIndividuals3_total() {
		return individuals3_total;
	}
	public void setIndividuals3_total(BigDecimal individuals3_total) {
		this.individuals3_total = individuals3_total;
	}
	public BigDecimal getZero1_total() {
		return zero1_total;
	}
	public void setZero1_total(BigDecimal zero1_total) {
		this.zero1_total = zero1_total;
	}
	public BigDecimal getThree1_total() {
		return three1_total;
	}
	public void setThree1_total(BigDecimal three1_total) {
		this.three1_total = three1_total;
	}
	public BigDecimal getSix1_total() {
		return six1_total;
	}
	public void setSix1_total(BigDecimal six1_total) {
		this.six1_total = six1_total;
	}
	public BigDecimal getOneyear1_total() {
		return oneyear1_total;
	}
	public void setOneyear1_total(BigDecimal oneyear1_total) {
		this.oneyear1_total = oneyear1_total;
	}
	public String getEmpty_total() {
		return empty_total;
	}
	public void setEmpty_total(String empty_total) {
		this.empty_total = empty_total;
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
	public BRF59D_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
	
		