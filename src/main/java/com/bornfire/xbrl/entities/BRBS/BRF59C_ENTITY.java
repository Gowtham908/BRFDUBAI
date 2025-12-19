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
@Table(name="BRF59C_SUMMARYTABLE")

public class BRF59C_ENTITY {

	private String	r43_product;
	private BigDecimal	r43_nbfi;
	private BigDecimal	r43_interbank;
	private BigDecimal	r43_gov;
	private BigDecimal	r43_corporate;
	private BigDecimal	r43_gre;
	private BigDecimal	r43_trade;
	private BigDecimal	r43_individuals;
	private BigDecimal	r43_investment;
	private BigDecimal	r43_nbfi1;
	private BigDecimal	r43_interbank1;
	private BigDecimal	r43_gov1;
	private BigDecimal	r43_corporate1;
	private BigDecimal	r43_gre1;
	private BigDecimal	r43_trade1;
	private BigDecimal	r43_individuals1;
	private BigDecimal	r43_investment1;
	private BigDecimal	r43_zer0;
	private BigDecimal	r43_three;
	private BigDecimal	r43_six;
	private BigDecimal	r43_oneyear;
	private BigDecimal	r43_foreign;
	private BigDecimal	r43_banks;
	private BigDecimal	r43_gov2;
	private BigDecimal	r43_other;
	private BigDecimal	r43_banks1;
	private BigDecimal	r43_individuals2;
	private BigDecimal	r43_other1;
	private BigDecimal	r43_banks2;
	private BigDecimal	r43_gov3;
	private BigDecimal	r43_others2;
	private BigDecimal	r43_banks3;
	private BigDecimal	r43_gov4;
	private BigDecimal	r43_others3;
	private BigDecimal	r43_foreign1;
	private BigDecimal	r43_guarantees;
	private BigDecimal	r43_nbfi2;
	private BigDecimal	r43_interbank2;
	private BigDecimal	r43_gov5;
	private BigDecimal	r43_corporate2;
	private BigDecimal	r43_gre2;
	private BigDecimal	r43_individuals3;
	private BigDecimal	r43_zero1;
	private BigDecimal	r43_three1;
	private BigDecimal	r43_six1;
	private BigDecimal	r43_oneyear1;
	private String	r43_empty;
	private String	r44_product;
	private BigDecimal	r44_nbfi;
	private BigDecimal	r44_interbank;
	private BigDecimal	r44_gov;
	private BigDecimal	r44_corporate;
	private BigDecimal	r44_gre;
	private BigDecimal	r44_trade;
	private BigDecimal	r44_individuals;
	private BigDecimal	r44_investment;
	private BigDecimal	r44_nbfi1;
	private BigDecimal	r44_interbank1;
	private BigDecimal	r44_gov1;
	private BigDecimal	r44_corporate1;
	private BigDecimal	r44_gre1;
	private BigDecimal	r44_trade1;
	private BigDecimal	r44_individuals1;
	private BigDecimal	r44_investment1;
	private BigDecimal	r44_zer0;
	private BigDecimal	r44_three;
	private BigDecimal	r44_six;
	private BigDecimal	r44_oneyear;
	private BigDecimal	r44_foreign;
	private BigDecimal	r44_banks;
	private BigDecimal	r44_gov2;
	private BigDecimal	r44_other;
	private BigDecimal	r44_banks1;
	private BigDecimal	r44_individuals2;
	private BigDecimal	r44_other1;
	private BigDecimal	r44_banks2;
	private BigDecimal	r44_gov3;
	private BigDecimal	r44_others2;
	private BigDecimal	r44_banks3;
	private BigDecimal	r44_gov4;
	private BigDecimal	r44_others3;
	private BigDecimal	r44_foreign1;
	private BigDecimal	r44_guarantees;
	private BigDecimal	r44_nbfi2;
	private BigDecimal	r44_interbank2;
	private BigDecimal	r44_gov5;
	private BigDecimal	r44_corporate2;
	private BigDecimal	r44_gre2;
	private BigDecimal	r44_individuals3;
	private BigDecimal	r44_zero1;
	private BigDecimal	r44_three1;
	private BigDecimal	r44_six1;
	private BigDecimal	r44_oneyear1;
	private String	r44_empty;
	private String	r45_product;
	private BigDecimal	r45_nbfi;
	private BigDecimal	r45_interbank;
	private BigDecimal	r45_gov;
	private BigDecimal	r45_corporate;
	private BigDecimal	r45_gre;
	private BigDecimal	r45_trade;
	private BigDecimal	r45_individuals;
	private BigDecimal	r45_investment;
	private BigDecimal	r45_nbfi1;
	private BigDecimal	r45_interbank1;
	private BigDecimal	r45_gov1;
	private BigDecimal	r45_corporate1;
	private BigDecimal	r45_gre1;
	private BigDecimal	r45_trade1;
	private BigDecimal	r45_individuals1;
	private BigDecimal	r45_investment1;
	private BigDecimal	r45_zer0;
	private BigDecimal	r45_three;
	private BigDecimal	r45_six;
	private BigDecimal	r45_oneyear;
	private BigDecimal	r45_foreign;
	private BigDecimal	r45_banks;
	private BigDecimal	r45_gov2;
	private BigDecimal	r45_other;
	private BigDecimal	r45_banks1;
	private BigDecimal	r45_individuals2;
	private BigDecimal	r45_other1;
	private BigDecimal	r45_banks2;
	private BigDecimal	r45_gov3;
	private BigDecimal	r45_others2;
	private BigDecimal	r45_banks3;
	private BigDecimal	r45_gov4;
	private BigDecimal	r45_others3;
	private BigDecimal	r45_foreign1;
	private BigDecimal	r45_guarantees;
	private BigDecimal	r45_nbfi2;
	private BigDecimal	r45_interbank2;
	private BigDecimal	r45_gov5;
	private BigDecimal	r45_corporate2;
	private BigDecimal	r45_gre2;
	private BigDecimal	r45_individuals3;
	private BigDecimal	r45_zero1;
	private BigDecimal	r45_three1;
	private BigDecimal	r45_six1;
	private BigDecimal	r45_oneyear1;
	private String	r45_empty;
	private String	r46_product;
	private BigDecimal	r46_nbfi;
	private BigDecimal	r46_interbank;
	private BigDecimal	r46_gov;
	private BigDecimal	r46_corporate;
	private BigDecimal	r46_gre;
	private BigDecimal	r46_trade;
	private BigDecimal	r46_individuals;
	private BigDecimal	r46_investment;
	private BigDecimal	r46_nbfi1;
	private BigDecimal	r46_interbank1;
	private BigDecimal	r46_gov1;
	private BigDecimal	r46_corporate1;
	private BigDecimal	r46_gre1;
	private BigDecimal	r46_trade1;
	private BigDecimal	r46_individuals1;
	private BigDecimal	r46_investment1;
	private BigDecimal	r46_zer0;
	private BigDecimal	r46_three;
	private BigDecimal	r46_six;
	private BigDecimal	r46_oneyear;
	private BigDecimal	r46_foreign;
	private BigDecimal	r46_banks;
	private BigDecimal	r46_gov2;
	private BigDecimal	r46_other;
	private BigDecimal	r46_banks1;
	private BigDecimal	r46_individuals2;
	private BigDecimal	r46_other1;
	private BigDecimal	r46_banks2;
	private BigDecimal	r46_gov3;
	private BigDecimal	r46_others2;
	private BigDecimal	r46_banks3;
	private BigDecimal	r46_gov4;
	private BigDecimal	r46_others3;
	private BigDecimal	r46_foreign1;
	private BigDecimal	r46_guarantees;
	private BigDecimal	r46_nbfi2;
	private BigDecimal	r46_interbank2;
	private BigDecimal	r46_gov5;
	private BigDecimal	r46_corporate2;
	private BigDecimal	r46_gre2;
	private BigDecimal	r46_individuals3;
	private BigDecimal	r46_zero1;
	private BigDecimal	r46_three1;
	private BigDecimal	r46_six1;
	private BigDecimal	r46_oneyear1;
	private String	r46_empty;
	private String	r47_product;
	private BigDecimal	r47_nbfi;
	private BigDecimal	r47_interbank;
	private BigDecimal	r47_gov;
	private BigDecimal	r47_corporate;
	private BigDecimal	r47_gre;
	private BigDecimal	r47_trade;
	private BigDecimal	r47_individuals;
	private BigDecimal	r47_investment;
	private BigDecimal	r47_nbfi1;
	private BigDecimal	r47_interbank1;
	private BigDecimal	r47_gov1;
	private BigDecimal	r47_corporate1;
	private BigDecimal	r47_gre1;
	private BigDecimal	r47_trade1;
	private BigDecimal	r47_individuals1;
	private BigDecimal	r47_investment1;
	private BigDecimal	r47_zer0;
	private BigDecimal	r47_three;
	private BigDecimal	r47_six;
	private BigDecimal	r47_oneyear;
	private BigDecimal	r47_foreign;
	private BigDecimal	r47_banks;
	private BigDecimal	r47_gov2;
	private BigDecimal	r47_other;
	private BigDecimal	r47_banks1;
	private BigDecimal	r47_individuals2;
	private BigDecimal	r47_other1;
	private BigDecimal	r47_banks2;
	private BigDecimal	r47_gov3;
	private BigDecimal	r47_others2;
	private BigDecimal	r47_banks3;
	private BigDecimal	r47_gov4;
	private BigDecimal	r47_others3;
	private BigDecimal	r47_foreign1;
	private BigDecimal	r47_guarantees;
	private BigDecimal	r47_nbfi2;
	private BigDecimal	r47_interbank2;
	private BigDecimal	r47_gov5;
	private BigDecimal	r47_corporate2;
	private BigDecimal	r47_gre2;
	private BigDecimal	r47_individuals3;
	private BigDecimal	r47_zero1;
	private BigDecimal	r47_three1;
	private BigDecimal	r47_six1;
	private BigDecimal	r47_oneyear1;
	private String	r47_empty;
	private String	r48_product;
	private BigDecimal	r48_nbfi;
	private BigDecimal	r48_interbank;
	private BigDecimal	r48_gov;
	private BigDecimal	r48_corporate;
	private BigDecimal	r48_gre;
	private BigDecimal	r48_trade;
	private BigDecimal	r48_individuals;
	private BigDecimal	r48_investment;
	private BigDecimal	r48_nbfi1;
	private BigDecimal	r48_interbank1;
	private BigDecimal	r48_gov1;
	private BigDecimal	r48_corporate1;
	private BigDecimal	r48_gre1;
	private BigDecimal	r48_trade1;
	private BigDecimal	r48_individuals1;
	private BigDecimal	r48_investment1;
	private BigDecimal	r48_zer0;
	private BigDecimal	r48_three;
	private BigDecimal	r48_six;
	private BigDecimal	r48_oneyear;
	private BigDecimal	r48_foreign;
	private BigDecimal	r48_banks;
	private BigDecimal	r48_gov2;
	private BigDecimal	r48_other;
	private BigDecimal	r48_banks1;
	private BigDecimal	r48_individuals2;
	private BigDecimal	r48_other1;
	private BigDecimal	r48_banks2;
	private BigDecimal	r48_gov3;
	private BigDecimal	r48_others2;
	private BigDecimal	r48_banks3;
	private BigDecimal	r48_gov4;
	private BigDecimal	r48_others3;
	private BigDecimal	r48_foreign1;
	private BigDecimal	r48_guarantees;
	private BigDecimal	r48_nbfi2;
	private BigDecimal	r48_interbank2;
	private BigDecimal	r48_gov5;
	private BigDecimal	r48_corporate2;
	private BigDecimal	r48_gre2;
	private BigDecimal	r48_individuals3;
	private BigDecimal	r48_zero1;
	private BigDecimal	r48_three1;
	private BigDecimal	r48_six1;
	private BigDecimal	r48_oneyear1;
	private String	r48_empty;
	private String	r49_product;
	private BigDecimal	r49_nbfi;
	private BigDecimal	r49_interbank;
	private BigDecimal	r49_gov;
	private BigDecimal	r49_corporate;
	private BigDecimal	r49_gre;
	private BigDecimal	r49_trade;
	private BigDecimal	r49_individuals;
	private BigDecimal	r49_investment;
	private BigDecimal	r49_nbfi1;
	private BigDecimal	r49_interbank1;
	private BigDecimal	r49_gov1;
	private BigDecimal	r49_corporate1;
	private BigDecimal	r49_gre1;
	private BigDecimal	r49_trade1;
	private BigDecimal	r49_individuals1;
	private BigDecimal	r49_investment1;
	private BigDecimal	r49_zer0;
	private BigDecimal	r49_three;
	private BigDecimal	r49_six;
	private BigDecimal	r49_oneyear;
	private BigDecimal	r49_foreign;
	private BigDecimal	r49_banks;
	private BigDecimal	r49_gov2;
	private BigDecimal	r49_other;
	private BigDecimal	r49_banks1;
	private BigDecimal	r49_individuals2;
	private BigDecimal	r49_other1;
	private BigDecimal	r49_banks2;
	private BigDecimal	r49_gov3;
	private BigDecimal	r49_others2;
	private BigDecimal	r49_banks3;
	private BigDecimal	r49_gov4;
	private BigDecimal	r49_others3;
	private BigDecimal	r49_foreign1;
	private BigDecimal	r49_guarantees;
	private BigDecimal	r49_nbfi2;
	private BigDecimal	r49_interbank2;
	private BigDecimal	r49_gov5;
	private BigDecimal	r49_corporate2;
	private BigDecimal	r49_gre2;
	private BigDecimal	r49_individuals3;
	private BigDecimal	r49_zero1;
	private BigDecimal	r49_three1;
	private BigDecimal	r49_six1;
	private BigDecimal	r49_oneyear1;
	private String	r49_empty;
	private String	r50_product;
	private BigDecimal	r50_nbfi;
	private BigDecimal	r50_interbank;
	private BigDecimal	r50_gov;
	private BigDecimal	r50_corporate;
	private BigDecimal	r50_gre;
	private BigDecimal	r50_trade;
	private BigDecimal	r50_individuals;
	private BigDecimal	r50_investment;
	private BigDecimal	r50_nbfi1;
	private BigDecimal	r50_interbank1;
	private BigDecimal	r50_gov1;
	private BigDecimal	r50_corporate1;
	private BigDecimal	r50_gre1;
	private BigDecimal	r50_trade1;
	private BigDecimal	r50_individuals1;
	private BigDecimal	r50_investment1;
	private BigDecimal	r50_zer0;
	private BigDecimal	r50_three;
	private BigDecimal	r50_six;
	private BigDecimal	r50_oneyear;
	private BigDecimal	r50_foreign;
	private BigDecimal	r50_banks;
	private BigDecimal	r50_gov2;
	private BigDecimal	r50_other;
	private BigDecimal	r50_banks1;
	private BigDecimal	r50_individuals2;
	private BigDecimal	r50_other1;
	private BigDecimal	r50_banks2;
	private BigDecimal	r50_gov3;
	private BigDecimal	r50_others2;
	private BigDecimal	r50_banks3;
	private BigDecimal	r50_gov4;
	private BigDecimal	r50_others3;
	private BigDecimal	r50_foreign1;
	private BigDecimal	r50_guarantees;
	private BigDecimal	r50_nbfi2;
	private BigDecimal	r50_interbank2;
	private BigDecimal	r50_gov5;
	private BigDecimal	r50_corporate2;
	private BigDecimal	r50_gre2;
	private BigDecimal	r50_individuals3;
	private BigDecimal	r50_zero1;
	private BigDecimal	r50_three1;
	private BigDecimal	r50_six1;
	private BigDecimal	r50_oneyear1;
	private String	r50_empty;
	private String	r51_product;
	private BigDecimal	r51_nbfi;
	private BigDecimal	r51_interbank;
	private BigDecimal	r51_gov;
	private BigDecimal	r51_corporate;
	private BigDecimal	r51_gre;
	private BigDecimal	r51_trade;
	private BigDecimal	r51_individuals;
	private BigDecimal	r51_investment;
	private BigDecimal	r51_nbfi1;
	private BigDecimal	r51_interbank1;
	private BigDecimal	r51_gov1;
	private BigDecimal	r51_corporate1;
	private BigDecimal	r51_gre1;
	private BigDecimal	r51_trade1;
	private BigDecimal	r51_individuals1;
	private BigDecimal	r51_investment1;
	private BigDecimal	r51_zer0;
	private BigDecimal	r51_three;
	private BigDecimal	r51_six;
	private BigDecimal	r51_oneyear;
	private BigDecimal	r51_foreign;
	private BigDecimal	r51_banks;
	private BigDecimal	r51_gov2;
	private BigDecimal	r51_other;
	private BigDecimal	r51_banks1;
	private BigDecimal	r51_individuals2;
	private BigDecimal	r51_other1;
	private BigDecimal	r51_banks2;
	private BigDecimal	r51_gov3;
	private BigDecimal	r51_others2;
	private BigDecimal	r51_banks3;
	private BigDecimal	r51_gov4;
	private BigDecimal	r51_others3;
	private BigDecimal	r51_foreign1;
	private BigDecimal	r51_guarantees;
	private BigDecimal	r51_nbfi2;
	private BigDecimal	r51_interbank2;
	private BigDecimal	r51_gov5;
	private BigDecimal	r51_corporate2;
	private BigDecimal	r51_gre2;
	private BigDecimal	r51_individuals3;
	private BigDecimal	r51_zero1;
	private BigDecimal	r51_three1;
	private BigDecimal	r51_six1;
	private BigDecimal	r51_oneyear1;
	private String	r51_empty;
	private String	r52_product;
	private BigDecimal	r52_nbfi;
	private BigDecimal	r52_interbank;
	private BigDecimal	r52_gov;
	private BigDecimal	r52_corporate;
	private BigDecimal	r52_gre;
	private BigDecimal	r52_trade;
	private BigDecimal	r52_individuals;
	private BigDecimal	r52_investment;
	private BigDecimal	r52_nbfi1;
	private BigDecimal	r52_interbank1;
	private BigDecimal	r52_gov1;
	private BigDecimal	r52_corporate1;
	private BigDecimal	r52_gre1;
	private BigDecimal	r52_trade1;
	private BigDecimal	r52_individuals1;
	private BigDecimal	r52_investment1;
	private BigDecimal	r52_zer0;
	private BigDecimal	r52_three;
	private BigDecimal	r52_six;
	private BigDecimal	r52_oneyear;
	private BigDecimal	r52_foreign;
	private BigDecimal	r52_banks;
	private BigDecimal	r52_gov2;
	private BigDecimal	r52_other;
	private BigDecimal	r52_banks1;
	private BigDecimal	r52_individuals2;
	private BigDecimal	r52_other1;
	private BigDecimal	r52_banks2;
	private BigDecimal	r52_gov3;
	private BigDecimal	r52_others2;
	private BigDecimal	r52_banks3;
	private BigDecimal	r52_gov4;
	private BigDecimal	r52_others3;
	private BigDecimal	r52_foreign1;
	private BigDecimal	r52_guarantees;
	private BigDecimal	r52_nbfi2;
	private BigDecimal	r52_interbank2;
	private BigDecimal	r52_gov5;
	private BigDecimal	r52_corporate2;
	private BigDecimal	r52_gre2;
	private BigDecimal	r52_individuals3;
	private BigDecimal	r52_zero1;
	private BigDecimal	r52_three1;
	private BigDecimal	r52_six1;
	private BigDecimal	r52_oneyear1;
	private String	r52_empty;
	private String	r53_product;
	private BigDecimal	r53_nbfi;
	private BigDecimal	r53_interbank;
	private BigDecimal	r53_gov;
	private BigDecimal	r53_corporate;
	private BigDecimal	r53_gre;
	private BigDecimal	r53_trade;
	private BigDecimal	r53_individuals;
	private BigDecimal	r53_investment;
	private BigDecimal	r53_nbfi1;
	private BigDecimal	r53_interbank1;
	private BigDecimal	r53_gov1;
	private BigDecimal	r53_corporate1;
	private BigDecimal	r53_gre1;
	private BigDecimal	r53_trade1;
	private BigDecimal	r53_individuals1;
	private BigDecimal	r53_investment1;
	private BigDecimal	r53_zer0;
	private BigDecimal	r53_three;
	private BigDecimal	r53_six;
	private BigDecimal	r53_oneyear;
	private BigDecimal	r53_foreign;
	private BigDecimal	r53_banks;
	private BigDecimal	r53_gov2;
	private BigDecimal	r53_other;
	private BigDecimal	r53_banks1;
	private BigDecimal	r53_individuals2;
	private BigDecimal	r53_other1;
	private BigDecimal	r53_banks2;
	private BigDecimal	r53_gov3;
	private BigDecimal	r53_others2;
	private BigDecimal	r53_banks3;
	private BigDecimal	r53_gov4;
	private BigDecimal	r53_others3;
	private BigDecimal	r53_foreign1;
	private BigDecimal	r53_guarantees;
	private BigDecimal	r53_nbfi2;
	private BigDecimal	r53_interbank2;
	private BigDecimal	r53_gov5;
	private BigDecimal	r53_corporate2;
	private BigDecimal	r53_gre2;
	private BigDecimal	r53_individuals3;
	private BigDecimal	r53_zero1;
	private BigDecimal	r53_three1;
	private BigDecimal	r53_six1;
	private BigDecimal	r53_oneyear1;
	private String	r53_empty;
	private String	r54_product;
	private BigDecimal	r54_nbfi;
	private BigDecimal	r54_interbank;
	private BigDecimal	r54_gov;
	private BigDecimal	r54_corporate;
	private BigDecimal	r54_gre;
	private BigDecimal	r54_trade;
	private BigDecimal	r54_individuals;
	private BigDecimal	r54_investment;
	private BigDecimal	r54_nbfi1;
	private BigDecimal	r54_interbank1;
	private BigDecimal	r54_gov1;
	private BigDecimal	r54_corporate1;
	private BigDecimal	r54_gre1;
	private BigDecimal	r54_trade1;
	private BigDecimal	r54_individuals1;
	private BigDecimal	r54_investment1;
	private BigDecimal	r54_zer0;
	private BigDecimal	r54_three;
	private BigDecimal	r54_six;
	private BigDecimal	r54_oneyear;
	private BigDecimal	r54_foreign;
	private BigDecimal	r54_banks;
	private BigDecimal	r54_gov2;
	private BigDecimal	r54_other;
	private BigDecimal	r54_banks1;
	private BigDecimal	r54_individuals2;
	private BigDecimal	r54_other1;
	private BigDecimal	r54_banks2;
	private BigDecimal	r54_gov3;
	private BigDecimal	r54_others2;
	private BigDecimal	r54_banks3;
	private BigDecimal	r54_gov4;
	private BigDecimal	r54_others3;
	private BigDecimal	r54_foreign1;
	private BigDecimal	r54_guarantees;
	private BigDecimal	r54_nbfi2;
	private BigDecimal	r54_interbank2;
	private BigDecimal	r54_gov5;
	private BigDecimal	r54_corporate2;
	private BigDecimal	r54_gre2;
	private BigDecimal	r54_individuals3;
	private BigDecimal	r54_zero1;
	private BigDecimal	r54_three1;
	private BigDecimal	r54_six1;
	private BigDecimal	r54_oneyear1;
	private String	r54_empty;
	private String	r55_product;
	private BigDecimal	r55_nbfi;
	private BigDecimal	r55_interbank;
	private BigDecimal	r55_gov;
	private BigDecimal	r55_corporate;
	private BigDecimal	r55_gre;
	private BigDecimal	r55_trade;
	private BigDecimal	r55_individuals;
	private BigDecimal	r55_investment;
	private BigDecimal	r55_nbfi1;
	private BigDecimal	r55_interbank1;
	private BigDecimal	r55_gov1;
	private BigDecimal	r55_corporate1;
	private BigDecimal	r55_gre1;
	private BigDecimal	r55_trade1;
	private BigDecimal	r55_individuals1;
	private BigDecimal	r55_investment1;
	private BigDecimal	r55_zer0;
	private BigDecimal	r55_three;
	private BigDecimal	r55_six;
	private BigDecimal	r55_oneyear;
	private BigDecimal	r55_foreign;
	private BigDecimal	r55_banks;
	private BigDecimal	r55_gov2;
	private BigDecimal	r55_other;
	private BigDecimal	r55_banks1;
	private BigDecimal	r55_individuals2;
	private BigDecimal	r55_other1;
	private BigDecimal	r55_banks2;
	private BigDecimal	r55_gov3;
	private BigDecimal	r55_others2;
	private BigDecimal	r55_banks3;
	private BigDecimal	r55_gov4;
	private BigDecimal	r55_others3;
	private BigDecimal	r55_foreign1;
	private BigDecimal	r55_guarantees;
	private BigDecimal	r55_nbfi2;
	private BigDecimal	r55_interbank2;
	private BigDecimal	r55_gov5;
	private BigDecimal	r55_corporate2;
	private BigDecimal	r55_gre2;
	private BigDecimal	r55_individuals3;
	private BigDecimal	r55_zero1;
	private BigDecimal	r55_three1;
	private BigDecimal	r55_six1;
	private BigDecimal	r55_oneyear1;
	private String	r55_empty;
	private String	r56_product;
	private BigDecimal	r56_nbfi;
	private BigDecimal	r56_interbank;
	private BigDecimal	r56_gov;
	private BigDecimal	r56_corporate;
	private BigDecimal	r56_gre;
	private BigDecimal	r56_trade;
	private BigDecimal	r56_individuals;
	private BigDecimal	r56_investment;
	private BigDecimal	r56_nbfi1;
	private BigDecimal	r56_interbank1;
	private BigDecimal	r56_gov1;
	private BigDecimal	r56_corporate1;
	private BigDecimal	r56_gre1;
	private BigDecimal	r56_trade1;
	private BigDecimal	r56_individuals1;
	private BigDecimal	r56_investment1;
	private BigDecimal	r56_zer0;
	private BigDecimal	r56_three;
	private BigDecimal	r56_six;
	private BigDecimal	r56_oneyear;
	private BigDecimal	r56_foreign;
	private BigDecimal	r56_banks;
	private BigDecimal	r56_gov2;
	private BigDecimal	r56_other;
	private BigDecimal	r56_banks1;
	private BigDecimal	r56_individuals2;
	private BigDecimal	r56_other1;
	private BigDecimal	r56_banks2;
	private BigDecimal	r56_gov3;
	private BigDecimal	r56_others2;
	private BigDecimal	r56_banks3;
	private BigDecimal	r56_gov4;
	private BigDecimal	r56_others3;
	private BigDecimal	r56_foreign1;
	private BigDecimal	r56_guarantees;
	private BigDecimal	r56_nbfi2;
	private BigDecimal	r56_interbank2;
	private BigDecimal	r56_gov5;
	private BigDecimal	r56_corporate2;
	private BigDecimal	r56_gre2;
	private BigDecimal	r56_individuals3;
	private BigDecimal	r56_zero1;
	private BigDecimal	r56_three1;
	private BigDecimal	r56_six1;
	private BigDecimal	r56_oneyear1;
	private String	r56_empty;
	private String	r57_product;
	private BigDecimal	r57_nbfi;
	private BigDecimal	r57_interbank;
	private BigDecimal	r57_gov;
	private BigDecimal	r57_corporate;
	private BigDecimal	r57_gre;
	private BigDecimal	r57_trade;
	private BigDecimal	r57_individuals;
	private BigDecimal	r57_investment;
	private BigDecimal	r57_nbfi1;
	private BigDecimal	r57_interbank1;
	private BigDecimal	r57_gov1;
	private BigDecimal	r57_corporate1;
	private BigDecimal	r57_gre1;
	private BigDecimal	r57_trade1;
	private BigDecimal	r57_individuals1;
	private BigDecimal	r57_investment1;
	private BigDecimal	r57_zer0;
	private BigDecimal	r57_three;
	private BigDecimal	r57_six;
	private BigDecimal	r57_oneyear;
	private BigDecimal	r57_foreign;
	private BigDecimal	r57_banks;
	private BigDecimal	r57_gov2;
	private BigDecimal	r57_other;
	private BigDecimal	r57_banks1;
	private BigDecimal	r57_individuals2;
	private BigDecimal	r57_other1;
	private BigDecimal	r57_banks2;
	private BigDecimal	r57_gov3;
	private BigDecimal	r57_others2;
	private BigDecimal	r57_banks3;
	private BigDecimal	r57_gov4;
	private BigDecimal	r57_others3;
	private BigDecimal	r57_foreign1;
	private BigDecimal	r57_guarantees;
	private BigDecimal	r57_nbfi2;
	private BigDecimal	r57_interbank2;
	private BigDecimal	r57_gov5;
	private BigDecimal	r57_corporate2;
	private BigDecimal	r57_gre2;
	private BigDecimal	r57_individuals3;
	private BigDecimal	r57_zero1;
	private BigDecimal	r57_three1;
	private BigDecimal	r57_six1;
	private BigDecimal	r57_oneyear1;
	private String	r57_empty;
	private String	r58_product;
	private BigDecimal	r58_nbfi;
	private BigDecimal	r58_interbank;
	private BigDecimal	r58_gov;
	private BigDecimal	r58_corporate;
	private BigDecimal	r58_gre;
	private BigDecimal	r58_trade;
	private BigDecimal	r58_individuals;
	private BigDecimal	r58_investment;
	private BigDecimal	r58_nbfi1;
	private BigDecimal	r58_interbank1;
	private BigDecimal	r58_gov1;
	private BigDecimal	r58_corporate1;
	private BigDecimal	r58_gre1;
	private BigDecimal	r58_trade1;
	private BigDecimal	r58_individuals1;
	private BigDecimal	r58_investment1;
	private BigDecimal	r58_zer0;
	private BigDecimal	r58_three;
	private BigDecimal	r58_six;
	private BigDecimal	r58_oneyear;
	private BigDecimal	r58_foreign;
	private BigDecimal	r58_banks;
	private BigDecimal	r58_gov2;
	private BigDecimal	r58_other;
	private BigDecimal	r58_banks1;
	private BigDecimal	r58_individuals2;
	private BigDecimal	r58_other1;
	private BigDecimal	r58_banks2;
	private BigDecimal	r58_gov3;
	private BigDecimal	r58_others2;
	private BigDecimal	r58_banks3;
	private BigDecimal	r58_gov4;
	private BigDecimal	r58_others3;
	private BigDecimal	r58_foreign1;
	private BigDecimal	r58_guarantees;
	private BigDecimal	r58_nbfi2;
	private BigDecimal	r58_interbank2;
	private BigDecimal	r58_gov5;
	private BigDecimal	r58_corporate2;
	private BigDecimal	r58_gre2;
	private BigDecimal	r58_individuals3;
	private BigDecimal	r58_zero1;
	private BigDecimal	r58_three1;
	private BigDecimal	r58_six1;
	private BigDecimal	r58_oneyear1;
	private String	r58_empty;
	private String	r59_product;
	private BigDecimal	r59_nbfi;
	private BigDecimal	r59_interbank;
	private BigDecimal	r59_gov;
	private BigDecimal	r59_corporate;
	private BigDecimal	r59_gre;
	private BigDecimal	r59_trade;
	private BigDecimal	r59_individuals;
	private BigDecimal	r59_investment;
	private BigDecimal	r59_nbfi1;
	private BigDecimal	r59_interbank1;
	private BigDecimal	r59_gov1;
	private BigDecimal	r59_corporate1;
	private BigDecimal	r59_gre1;
	private BigDecimal	r59_trade1;
	private BigDecimal	r59_individuals1;
	private BigDecimal	r59_investment1;
	private BigDecimal	r59_zer0;
	private BigDecimal	r59_three;
	private BigDecimal	r59_six;
	private BigDecimal	r59_oneyear;
	private BigDecimal	r59_foreign;
	private BigDecimal	r59_banks;
	private BigDecimal	r59_gov2;
	private BigDecimal	r59_other;
	private BigDecimal	r59_banks1;
	private BigDecimal	r59_individuals2;
	private BigDecimal	r59_other1;
	private BigDecimal	r59_banks2;
	private BigDecimal	r59_gov3;
	private BigDecimal	r59_others2;
	private BigDecimal	r59_banks3;
	private BigDecimal	r59_gov4;
	private BigDecimal	r59_others3;
	private BigDecimal	r59_foreign1;
	private BigDecimal	r59_guarantees;
	private BigDecimal	r59_nbfi2;
	private BigDecimal	r59_interbank2;
	private BigDecimal	r59_gov5;
	private BigDecimal	r59_corporate2;
	private BigDecimal	r59_gre2;
	private BigDecimal	r59_individuals3;
	private BigDecimal	r59_zero1;
	private BigDecimal	r59_three1;
	private BigDecimal	r59_six1;
	private BigDecimal	r59_oneyear1;
	private String	r59_empty;
	private String	r60_product;
	private BigDecimal	r60_nbfi;
	private BigDecimal	r60_interbank;
	private BigDecimal	r60_gov;
	private BigDecimal	r60_corporate;
	private BigDecimal	r60_gre;
	private BigDecimal	r60_trade;
	private BigDecimal	r60_individuals;
	private BigDecimal	r60_investment;
	private BigDecimal	r60_nbfi1;
	private BigDecimal	r60_interbank1;
	private BigDecimal	r60_gov1;
	private BigDecimal	r60_corporate1;
	private BigDecimal	r60_gre1;
	private BigDecimal	r60_trade1;
	private BigDecimal	r60_individuals1;
	private BigDecimal	r60_investment1;
	private BigDecimal	r60_zer0;
	private BigDecimal	r60_three;
	private BigDecimal	r60_six;
	private BigDecimal	r60_oneyear;
	private BigDecimal	r60_foreign;
	private BigDecimal	r60_banks;
	private BigDecimal	r60_gov2;
	private BigDecimal	r60_other;
	private BigDecimal	r60_banks1;
	private BigDecimal	r60_individuals2;
	private BigDecimal	r60_other1;
	private BigDecimal	r60_banks2;
	private BigDecimal	r60_gov3;
	private BigDecimal	r60_others2;
	private BigDecimal	r60_banks3;
	private BigDecimal	r60_gov4;
	private BigDecimal	r60_others3;
	private BigDecimal	r60_foreign1;
	private BigDecimal	r60_guarantees;
	private BigDecimal	r60_nbfi2;
	private BigDecimal	r60_interbank2;
	private BigDecimal	r60_gov5;
	private BigDecimal	r60_corporate2;
	private BigDecimal	r60_gre2;
	private BigDecimal	r60_individuals3;
	private BigDecimal	r60_zero1;
	private BigDecimal	r60_three1;
	private BigDecimal	r60_six1;
	private BigDecimal	r60_oneyear1;
	private String	r60_empty;
	private String	r61_product;
	private BigDecimal	r61_nbfi;
	private BigDecimal	r61_interbank;
	private BigDecimal	r61_gov;
	private BigDecimal	r61_corporate;
	private BigDecimal	r61_gre;
	private BigDecimal	r61_trade;
	private BigDecimal	r61_individuals;
	private BigDecimal	r61_investment;
	private BigDecimal	r61_nbfi1;
	private BigDecimal	r61_interbank1;
	private BigDecimal	r61_gov1;
	private BigDecimal	r61_corporate1;
	private BigDecimal	r61_gre1;
	private BigDecimal	r61_trade1;
	private BigDecimal	r61_individuals1;
	private BigDecimal	r61_investment1;
	private BigDecimal	r61_zer0;
	private BigDecimal	r61_three;
	private BigDecimal	r61_six;
	private BigDecimal	r61_oneyear;
	private BigDecimal	r61_foreign;
	private BigDecimal	r61_banks;
	private BigDecimal	r61_gov2;
	private BigDecimal	r61_other;
	private BigDecimal	r61_banks1;
	private BigDecimal	r61_individuals2;
	private BigDecimal	r61_other1;
	private BigDecimal	r61_banks2;
	private BigDecimal	r61_gov3;
	private BigDecimal	r61_others2;
	private BigDecimal	r61_banks3;
	private BigDecimal	r61_gov4;
	private BigDecimal	r61_others3;
	private BigDecimal	r61_foreign1;
	private BigDecimal	r61_guarantees;
	private BigDecimal	r61_nbfi2;
	private BigDecimal	r61_interbank2;
	private BigDecimal	r61_gov5;
	private BigDecimal	r61_corporate2;
	private BigDecimal	r61_gre2;
	private BigDecimal	r61_individuals3;
	private BigDecimal	r61_zero1;
	private BigDecimal	r61_three1;
	private BigDecimal	r61_six1;
	private BigDecimal	r61_oneyear1;
	private String	r61_empty;
	private String	r62_product;
	private BigDecimal	r62_nbfi;
	private BigDecimal	r62_interbank;
	private BigDecimal	r62_gov;
	private BigDecimal	r62_corporate;
	private BigDecimal	r62_gre;
	private BigDecimal	r62_trade;
	private BigDecimal	r62_individuals;
	private BigDecimal	r62_investment;
	private BigDecimal	r62_nbfi1;
	private BigDecimal	r62_interbank1;
	private BigDecimal	r62_gov1;
	private BigDecimal	r62_corporate1;
	private BigDecimal	r62_gre1;
	private BigDecimal	r62_trade1;
	private BigDecimal	r62_individuals1;
	private BigDecimal	r62_investment1;
	private BigDecimal	r62_zer0;
	private BigDecimal	r62_three;
	private BigDecimal	r62_six;
	private BigDecimal	r62_oneyear;
	private BigDecimal	r62_foreign;
	private BigDecimal	r62_banks;
	private BigDecimal	r62_gov2;
	private BigDecimal	r62_other;
	private BigDecimal	r62_banks1;
	private BigDecimal	r62_individuals2;
	private BigDecimal	r62_other1;
	private BigDecimal	r62_banks2;
	private BigDecimal	r62_gov3;
	private BigDecimal	r62_others2;
	private BigDecimal	r62_banks3;
	private BigDecimal	r62_gov4;
	private BigDecimal	r62_others3;
	private BigDecimal	r62_foreign1;
	private BigDecimal	r62_guarantees;
	private BigDecimal	r62_nbfi2;
	private BigDecimal	r62_interbank2;
	private BigDecimal	r62_gov5;
	private BigDecimal	r62_corporate2;
	private BigDecimal	r62_gre2;
	private BigDecimal	r62_individuals3;
	private BigDecimal	r62_zero1;
	private BigDecimal	r62_three1;
	private BigDecimal	r62_six1;
	private BigDecimal	r62_oneyear1;
	private String	r62_empty;
	private String	r63_product;
	private BigDecimal	r63_nbfi;
	private BigDecimal	r63_interbank;
	private BigDecimal	r63_gov;
	private BigDecimal	r63_corporate;
	private BigDecimal	r63_gre;
	private BigDecimal	r63_trade;
	private BigDecimal	r63_individuals;
	private BigDecimal	r63_investment;
	private BigDecimal	r63_nbfi1;
	private BigDecimal	r63_interbank1;
	private BigDecimal	r63_gov1;
	private BigDecimal	r63_corporate1;
	private BigDecimal	r63_gre1;
	private BigDecimal	r63_trade1;
	private BigDecimal	r63_individuals1;
	private BigDecimal	r63_investment1;
	private BigDecimal	r63_zer0;
	private BigDecimal	r63_three;
	private BigDecimal	r63_six;
	private BigDecimal	r63_oneyear;
	private BigDecimal	r63_foreign;
	private BigDecimal	r63_banks;
	private BigDecimal	r63_gov2;
	private BigDecimal	r63_other;
	private BigDecimal	r63_banks1;
	private BigDecimal	r63_individuals2;
	private BigDecimal	r63_other1;
	private BigDecimal	r63_banks2;
	private BigDecimal	r63_gov3;
	private BigDecimal	r63_others2;
	private BigDecimal	r63_banks3;
	private BigDecimal	r63_gov4;
	private BigDecimal	r63_others3;
	private BigDecimal	r63_foreign1;
	private BigDecimal	r63_guarantees;
	private BigDecimal	r63_nbfi2;
	private BigDecimal	r63_interbank2;
	private BigDecimal	r63_gov5;
	private BigDecimal	r63_corporate2;
	private BigDecimal	r63_gre2;
	private BigDecimal	r63_individuals3;
	private BigDecimal	r63_zero1;
	private BigDecimal	r63_three1;
	private BigDecimal	r63_six1;
	private BigDecimal	r63_oneyear1;
	private String	r63_empty;
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
	public String getR43_product() {
		return r43_product;
	}
	public void setR43_product(String r43_product) {
		this.r43_product = r43_product;
	}
	public BigDecimal getR43_nbfi() {
		return r43_nbfi;
	}
	public void setR43_nbfi(BigDecimal r43_nbfi) {
		this.r43_nbfi = r43_nbfi;
	}
	public BigDecimal getR43_interbank() {
		return r43_interbank;
	}
	public void setR43_interbank(BigDecimal r43_interbank) {
		this.r43_interbank = r43_interbank;
	}
	public BigDecimal getR43_gov() {
		return r43_gov;
	}
	public void setR43_gov(BigDecimal r43_gov) {
		this.r43_gov = r43_gov;
	}
	public BigDecimal getR43_corporate() {
		return r43_corporate;
	}
	public void setR43_corporate(BigDecimal r43_corporate) {
		this.r43_corporate = r43_corporate;
	}
	public BigDecimal getR43_gre() {
		return r43_gre;
	}
	public void setR43_gre(BigDecimal r43_gre) {
		this.r43_gre = r43_gre;
	}
	public BigDecimal getR43_trade() {
		return r43_trade;
	}
	public void setR43_trade(BigDecimal r43_trade) {
		this.r43_trade = r43_trade;
	}
	public BigDecimal getR43_individuals() {
		return r43_individuals;
	}
	public void setR43_individuals(BigDecimal r43_individuals) {
		this.r43_individuals = r43_individuals;
	}
	public BigDecimal getR43_investment() {
		return r43_investment;
	}
	public void setR43_investment(BigDecimal r43_investment) {
		this.r43_investment = r43_investment;
	}
	public BigDecimal getR43_nbfi1() {
		return r43_nbfi1;
	}
	public void setR43_nbfi1(BigDecimal r43_nbfi1) {
		this.r43_nbfi1 = r43_nbfi1;
	}
	public BigDecimal getR43_interbank1() {
		return r43_interbank1;
	}
	public void setR43_interbank1(BigDecimal r43_interbank1) {
		this.r43_interbank1 = r43_interbank1;
	}
	public BigDecimal getR43_gov1() {
		return r43_gov1;
	}
	public void setR43_gov1(BigDecimal r43_gov1) {
		this.r43_gov1 = r43_gov1;
	}
	public BigDecimal getR43_corporate1() {
		return r43_corporate1;
	}
	public void setR43_corporate1(BigDecimal r43_corporate1) {
		this.r43_corporate1 = r43_corporate1;
	}
	public BigDecimal getR43_gre1() {
		return r43_gre1;
	}
	public void setR43_gre1(BigDecimal r43_gre1) {
		this.r43_gre1 = r43_gre1;
	}
	public BigDecimal getR43_trade1() {
		return r43_trade1;
	}
	public void setR43_trade1(BigDecimal r43_trade1) {
		this.r43_trade1 = r43_trade1;
	}
	public BigDecimal getR43_individuals1() {
		return r43_individuals1;
	}
	public void setR43_individuals1(BigDecimal r43_individuals1) {
		this.r43_individuals1 = r43_individuals1;
	}
	public BigDecimal getR43_investment1() {
		return r43_investment1;
	}
	public void setR43_investment1(BigDecimal r43_investment1) {
		this.r43_investment1 = r43_investment1;
	}
	public BigDecimal getR43_zer0() {
		return r43_zer0;
	}
	public void setR43_zer0(BigDecimal r43_zer0) {
		this.r43_zer0 = r43_zer0;
	}
	public BigDecimal getR43_three() {
		return r43_three;
	}
	public void setR43_three(BigDecimal r43_three) {
		this.r43_three = r43_three;
	}
	public BigDecimal getR43_six() {
		return r43_six;
	}
	public void setR43_six(BigDecimal r43_six) {
		this.r43_six = r43_six;
	}
	public BigDecimal getR43_oneyear() {
		return r43_oneyear;
	}
	public void setR43_oneyear(BigDecimal r43_oneyear) {
		this.r43_oneyear = r43_oneyear;
	}
	public BigDecimal getR43_foreign() {
		return r43_foreign;
	}
	public void setR43_foreign(BigDecimal r43_foreign) {
		this.r43_foreign = r43_foreign;
	}
	public BigDecimal getR43_banks() {
		return r43_banks;
	}
	public void setR43_banks(BigDecimal r43_banks) {
		this.r43_banks = r43_banks;
	}
	public BigDecimal getR43_gov2() {
		return r43_gov2;
	}
	public void setR43_gov2(BigDecimal r43_gov2) {
		this.r43_gov2 = r43_gov2;
	}
	public BigDecimal getR43_other() {
		return r43_other;
	}
	public void setR43_other(BigDecimal r43_other) {
		this.r43_other = r43_other;
	}
	public BigDecimal getR43_banks1() {
		return r43_banks1;
	}
	public void setR43_banks1(BigDecimal r43_banks1) {
		this.r43_banks1 = r43_banks1;
	}
	public BigDecimal getR43_individuals2() {
		return r43_individuals2;
	}
	public void setR43_individuals2(BigDecimal r43_individuals2) {
		this.r43_individuals2 = r43_individuals2;
	}
	public BigDecimal getR43_other1() {
		return r43_other1;
	}
	public void setR43_other1(BigDecimal r43_other1) {
		this.r43_other1 = r43_other1;
	}
	public BigDecimal getR43_banks2() {
		return r43_banks2;
	}
	public void setR43_banks2(BigDecimal r43_banks2) {
		this.r43_banks2 = r43_banks2;
	}
	public BigDecimal getR43_gov3() {
		return r43_gov3;
	}
	public void setR43_gov3(BigDecimal r43_gov3) {
		this.r43_gov3 = r43_gov3;
	}
	public BigDecimal getR43_others2() {
		return r43_others2;
	}
	public void setR43_others2(BigDecimal r43_others2) {
		this.r43_others2 = r43_others2;
	}
	public BigDecimal getR43_banks3() {
		return r43_banks3;
	}
	public void setR43_banks3(BigDecimal r43_banks3) {
		this.r43_banks3 = r43_banks3;
	}
	public BigDecimal getR43_gov4() {
		return r43_gov4;
	}
	public void setR43_gov4(BigDecimal r43_gov4) {
		this.r43_gov4 = r43_gov4;
	}
	public BigDecimal getR43_others3() {
		return r43_others3;
	}
	public void setR43_others3(BigDecimal r43_others3) {
		this.r43_others3 = r43_others3;
	}
	public BigDecimal getR43_foreign1() {
		return r43_foreign1;
	}
	public void setR43_foreign1(BigDecimal r43_foreign1) {
		this.r43_foreign1 = r43_foreign1;
	}
	public BigDecimal getR43_guarantees() {
		return r43_guarantees;
	}
	public void setR43_guarantees(BigDecimal r43_guarantees) {
		this.r43_guarantees = r43_guarantees;
	}
	public BigDecimal getR43_nbfi2() {
		return r43_nbfi2;
	}
	public void setR43_nbfi2(BigDecimal r43_nbfi2) {
		this.r43_nbfi2 = r43_nbfi2;
	}
	public BigDecimal getR43_interbank2() {
		return r43_interbank2;
	}
	public void setR43_interbank2(BigDecimal r43_interbank2) {
		this.r43_interbank2 = r43_interbank2;
	}
	public BigDecimal getR43_gov5() {
		return r43_gov5;
	}
	public void setR43_gov5(BigDecimal r43_gov5) {
		this.r43_gov5 = r43_gov5;
	}
	public BigDecimal getR43_corporate2() {
		return r43_corporate2;
	}
	public void setR43_corporate2(BigDecimal r43_corporate2) {
		this.r43_corporate2 = r43_corporate2;
	}
	public BigDecimal getR43_gre2() {
		return r43_gre2;
	}
	public void setR43_gre2(BigDecimal r43_gre2) {
		this.r43_gre2 = r43_gre2;
	}
	public BigDecimal getR43_individuals3() {
		return r43_individuals3;
	}
	public void setR43_individuals3(BigDecimal r43_individuals3) {
		this.r43_individuals3 = r43_individuals3;
	}
	public BigDecimal getR43_zero1() {
		return r43_zero1;
	}
	public void setR43_zero1(BigDecimal r43_zero1) {
		this.r43_zero1 = r43_zero1;
	}
	public BigDecimal getR43_three1() {
		return r43_three1;
	}
	public void setR43_three1(BigDecimal r43_three1) {
		this.r43_three1 = r43_three1;
	}
	public BigDecimal getR43_six1() {
		return r43_six1;
	}
	public void setR43_six1(BigDecimal r43_six1) {
		this.r43_six1 = r43_six1;
	}
	public BigDecimal getR43_oneyear1() {
		return r43_oneyear1;
	}
	public void setR43_oneyear1(BigDecimal r43_oneyear1) {
		this.r43_oneyear1 = r43_oneyear1;
	}
	public String getR43_empty() {
		return r43_empty;
	}
	public void setR43_empty(String r43_empty) {
		this.r43_empty = r43_empty;
	}
	public String getR44_product() {
		return r44_product;
	}
	public void setR44_product(String r44_product) {
		this.r44_product = r44_product;
	}
	public BigDecimal getR44_nbfi() {
		return r44_nbfi;
	}
	public void setR44_nbfi(BigDecimal r44_nbfi) {
		this.r44_nbfi = r44_nbfi;
	}
	public BigDecimal getR44_interbank() {
		return r44_interbank;
	}
	public void setR44_interbank(BigDecimal r44_interbank) {
		this.r44_interbank = r44_interbank;
	}
	public BigDecimal getR44_gov() {
		return r44_gov;
	}
	public void setR44_gov(BigDecimal r44_gov) {
		this.r44_gov = r44_gov;
	}
	public BigDecimal getR44_corporate() {
		return r44_corporate;
	}
	public void setR44_corporate(BigDecimal r44_corporate) {
		this.r44_corporate = r44_corporate;
	}
	public BigDecimal getR44_gre() {
		return r44_gre;
	}
	public void setR44_gre(BigDecimal r44_gre) {
		this.r44_gre = r44_gre;
	}
	public BigDecimal getR44_trade() {
		return r44_trade;
	}
	public void setR44_trade(BigDecimal r44_trade) {
		this.r44_trade = r44_trade;
	}
	public BigDecimal getR44_individuals() {
		return r44_individuals;
	}
	public void setR44_individuals(BigDecimal r44_individuals) {
		this.r44_individuals = r44_individuals;
	}
	public BigDecimal getR44_investment() {
		return r44_investment;
	}
	public void setR44_investment(BigDecimal r44_investment) {
		this.r44_investment = r44_investment;
	}
	public BigDecimal getR44_nbfi1() {
		return r44_nbfi1;
	}
	public void setR44_nbfi1(BigDecimal r44_nbfi1) {
		this.r44_nbfi1 = r44_nbfi1;
	}
	public BigDecimal getR44_interbank1() {
		return r44_interbank1;
	}
	public void setR44_interbank1(BigDecimal r44_interbank1) {
		this.r44_interbank1 = r44_interbank1;
	}
	public BigDecimal getR44_gov1() {
		return r44_gov1;
	}
	public void setR44_gov1(BigDecimal r44_gov1) {
		this.r44_gov1 = r44_gov1;
	}
	public BigDecimal getR44_corporate1() {
		return r44_corporate1;
	}
	public void setR44_corporate1(BigDecimal r44_corporate1) {
		this.r44_corporate1 = r44_corporate1;
	}
	public BigDecimal getR44_gre1() {
		return r44_gre1;
	}
	public void setR44_gre1(BigDecimal r44_gre1) {
		this.r44_gre1 = r44_gre1;
	}
	public BigDecimal getR44_trade1() {
		return r44_trade1;
	}
	public void setR44_trade1(BigDecimal r44_trade1) {
		this.r44_trade1 = r44_trade1;
	}
	public BigDecimal getR44_individuals1() {
		return r44_individuals1;
	}
	public void setR44_individuals1(BigDecimal r44_individuals1) {
		this.r44_individuals1 = r44_individuals1;
	}
	public BigDecimal getR44_investment1() {
		return r44_investment1;
	}
	public void setR44_investment1(BigDecimal r44_investment1) {
		this.r44_investment1 = r44_investment1;
	}
	public BigDecimal getR44_zer0() {
		return r44_zer0;
	}
	public void setR44_zer0(BigDecimal r44_zer0) {
		this.r44_zer0 = r44_zer0;
	}
	public BigDecimal getR44_three() {
		return r44_three;
	}
	public void setR44_three(BigDecimal r44_three) {
		this.r44_three = r44_three;
	}
	public BigDecimal getR44_six() {
		return r44_six;
	}
	public void setR44_six(BigDecimal r44_six) {
		this.r44_six = r44_six;
	}
	public BigDecimal getR44_oneyear() {
		return r44_oneyear;
	}
	public void setR44_oneyear(BigDecimal r44_oneyear) {
		this.r44_oneyear = r44_oneyear;
	}
	public BigDecimal getR44_foreign() {
		return r44_foreign;
	}
	public void setR44_foreign(BigDecimal r44_foreign) {
		this.r44_foreign = r44_foreign;
	}
	public BigDecimal getR44_banks() {
		return r44_banks;
	}
	public void setR44_banks(BigDecimal r44_banks) {
		this.r44_banks = r44_banks;
	}
	public BigDecimal getR44_gov2() {
		return r44_gov2;
	}
	public void setR44_gov2(BigDecimal r44_gov2) {
		this.r44_gov2 = r44_gov2;
	}
	public BigDecimal getR44_other() {
		return r44_other;
	}
	public void setR44_other(BigDecimal r44_other) {
		this.r44_other = r44_other;
	}
	public BigDecimal getR44_banks1() {
		return r44_banks1;
	}
	public void setR44_banks1(BigDecimal r44_banks1) {
		this.r44_banks1 = r44_banks1;
	}
	public BigDecimal getR44_individuals2() {
		return r44_individuals2;
	}
	public void setR44_individuals2(BigDecimal r44_individuals2) {
		this.r44_individuals2 = r44_individuals2;
	}
	public BigDecimal getR44_other1() {
		return r44_other1;
	}
	public void setR44_other1(BigDecimal r44_other1) {
		this.r44_other1 = r44_other1;
	}
	public BigDecimal getR44_banks2() {
		return r44_banks2;
	}
	public void setR44_banks2(BigDecimal r44_banks2) {
		this.r44_banks2 = r44_banks2;
	}
	public BigDecimal getR44_gov3() {
		return r44_gov3;
	}
	public void setR44_gov3(BigDecimal r44_gov3) {
		this.r44_gov3 = r44_gov3;
	}
	public BigDecimal getR44_others2() {
		return r44_others2;
	}
	public void setR44_others2(BigDecimal r44_others2) {
		this.r44_others2 = r44_others2;
	}
	public BigDecimal getR44_banks3() {
		return r44_banks3;
	}
	public void setR44_banks3(BigDecimal r44_banks3) {
		this.r44_banks3 = r44_banks3;
	}
	public BigDecimal getR44_gov4() {
		return r44_gov4;
	}
	public void setR44_gov4(BigDecimal r44_gov4) {
		this.r44_gov4 = r44_gov4;
	}
	public BigDecimal getR44_others3() {
		return r44_others3;
	}
	public void setR44_others3(BigDecimal r44_others3) {
		this.r44_others3 = r44_others3;
	}
	public BigDecimal getR44_foreign1() {
		return r44_foreign1;
	}
	public void setR44_foreign1(BigDecimal r44_foreign1) {
		this.r44_foreign1 = r44_foreign1;
	}
	public BigDecimal getR44_guarantees() {
		return r44_guarantees;
	}
	public void setR44_guarantees(BigDecimal r44_guarantees) {
		this.r44_guarantees = r44_guarantees;
	}
	public BigDecimal getR44_nbfi2() {
		return r44_nbfi2;
	}
	public void setR44_nbfi2(BigDecimal r44_nbfi2) {
		this.r44_nbfi2 = r44_nbfi2;
	}
	public BigDecimal getR44_interbank2() {
		return r44_interbank2;
	}
	public void setR44_interbank2(BigDecimal r44_interbank2) {
		this.r44_interbank2 = r44_interbank2;
	}
	public BigDecimal getR44_gov5() {
		return r44_gov5;
	}
	public void setR44_gov5(BigDecimal r44_gov5) {
		this.r44_gov5 = r44_gov5;
	}
	public BigDecimal getR44_corporate2() {
		return r44_corporate2;
	}
	public void setR44_corporate2(BigDecimal r44_corporate2) {
		this.r44_corporate2 = r44_corporate2;
	}
	public BigDecimal getR44_gre2() {
		return r44_gre2;
	}
	public void setR44_gre2(BigDecimal r44_gre2) {
		this.r44_gre2 = r44_gre2;
	}
	public BigDecimal getR44_individuals3() {
		return r44_individuals3;
	}
	public void setR44_individuals3(BigDecimal r44_individuals3) {
		this.r44_individuals3 = r44_individuals3;
	}
	public BigDecimal getR44_zero1() {
		return r44_zero1;
	}
	public void setR44_zero1(BigDecimal r44_zero1) {
		this.r44_zero1 = r44_zero1;
	}
	public BigDecimal getR44_three1() {
		return r44_three1;
	}
	public void setR44_three1(BigDecimal r44_three1) {
		this.r44_three1 = r44_three1;
	}
	public BigDecimal getR44_six1() {
		return r44_six1;
	}
	public void setR44_six1(BigDecimal r44_six1) {
		this.r44_six1 = r44_six1;
	}
	public BigDecimal getR44_oneyear1() {
		return r44_oneyear1;
	}
	public void setR44_oneyear1(BigDecimal r44_oneyear1) {
		this.r44_oneyear1 = r44_oneyear1;
	}
	public String getR44_empty() {
		return r44_empty;
	}
	public void setR44_empty(String r44_empty) {
		this.r44_empty = r44_empty;
	}
	public String getR45_product() {
		return r45_product;
	}
	public void setR45_product(String r45_product) {
		this.r45_product = r45_product;
	}
	public BigDecimal getR45_nbfi() {
		return r45_nbfi;
	}
	public void setR45_nbfi(BigDecimal r45_nbfi) {
		this.r45_nbfi = r45_nbfi;
	}
	public BigDecimal getR45_interbank() {
		return r45_interbank;
	}
	public void setR45_interbank(BigDecimal r45_interbank) {
		this.r45_interbank = r45_interbank;
	}
	public BigDecimal getR45_gov() {
		return r45_gov;
	}
	public void setR45_gov(BigDecimal r45_gov) {
		this.r45_gov = r45_gov;
	}
	public BigDecimal getR45_corporate() {
		return r45_corporate;
	}
	public void setR45_corporate(BigDecimal r45_corporate) {
		this.r45_corporate = r45_corporate;
	}
	public BigDecimal getR45_gre() {
		return r45_gre;
	}
	public void setR45_gre(BigDecimal r45_gre) {
		this.r45_gre = r45_gre;
	}
	public BigDecimal getR45_trade() {
		return r45_trade;
	}
	public void setR45_trade(BigDecimal r45_trade) {
		this.r45_trade = r45_trade;
	}
	public BigDecimal getR45_individuals() {
		return r45_individuals;
	}
	public void setR45_individuals(BigDecimal r45_individuals) {
		this.r45_individuals = r45_individuals;
	}
	public BigDecimal getR45_investment() {
		return r45_investment;
	}
	public void setR45_investment(BigDecimal r45_investment) {
		this.r45_investment = r45_investment;
	}
	public BigDecimal getR45_nbfi1() {
		return r45_nbfi1;
	}
	public void setR45_nbfi1(BigDecimal r45_nbfi1) {
		this.r45_nbfi1 = r45_nbfi1;
	}
	public BigDecimal getR45_interbank1() {
		return r45_interbank1;
	}
	public void setR45_interbank1(BigDecimal r45_interbank1) {
		this.r45_interbank1 = r45_interbank1;
	}
	public BigDecimal getR45_gov1() {
		return r45_gov1;
	}
	public void setR45_gov1(BigDecimal r45_gov1) {
		this.r45_gov1 = r45_gov1;
	}
	public BigDecimal getR45_corporate1() {
		return r45_corporate1;
	}
	public void setR45_corporate1(BigDecimal r45_corporate1) {
		this.r45_corporate1 = r45_corporate1;
	}
	public BigDecimal getR45_gre1() {
		return r45_gre1;
	}
	public void setR45_gre1(BigDecimal r45_gre1) {
		this.r45_gre1 = r45_gre1;
	}
	public BigDecimal getR45_trade1() {
		return r45_trade1;
	}
	public void setR45_trade1(BigDecimal r45_trade1) {
		this.r45_trade1 = r45_trade1;
	}
	public BigDecimal getR45_individuals1() {
		return r45_individuals1;
	}
	public void setR45_individuals1(BigDecimal r45_individuals1) {
		this.r45_individuals1 = r45_individuals1;
	}
	public BigDecimal getR45_investment1() {
		return r45_investment1;
	}
	public void setR45_investment1(BigDecimal r45_investment1) {
		this.r45_investment1 = r45_investment1;
	}
	public BigDecimal getR45_zer0() {
		return r45_zer0;
	}
	public void setR45_zer0(BigDecimal r45_zer0) {
		this.r45_zer0 = r45_zer0;
	}
	public BigDecimal getR45_three() {
		return r45_three;
	}
	public void setR45_three(BigDecimal r45_three) {
		this.r45_three = r45_three;
	}
	public BigDecimal getR45_six() {
		return r45_six;
	}
	public void setR45_six(BigDecimal r45_six) {
		this.r45_six = r45_six;
	}
	public BigDecimal getR45_oneyear() {
		return r45_oneyear;
	}
	public void setR45_oneyear(BigDecimal r45_oneyear) {
		this.r45_oneyear = r45_oneyear;
	}
	public BigDecimal getR45_foreign() {
		return r45_foreign;
	}
	public void setR45_foreign(BigDecimal r45_foreign) {
		this.r45_foreign = r45_foreign;
	}
	public BigDecimal getR45_banks() {
		return r45_banks;
	}
	public void setR45_banks(BigDecimal r45_banks) {
		this.r45_banks = r45_banks;
	}
	public BigDecimal getR45_gov2() {
		return r45_gov2;
	}
	public void setR45_gov2(BigDecimal r45_gov2) {
		this.r45_gov2 = r45_gov2;
	}
	public BigDecimal getR45_other() {
		return r45_other;
	}
	public void setR45_other(BigDecimal r45_other) {
		this.r45_other = r45_other;
	}
	public BigDecimal getR45_banks1() {
		return r45_banks1;
	}
	public void setR45_banks1(BigDecimal r45_banks1) {
		this.r45_banks1 = r45_banks1;
	}
	public BigDecimal getR45_individuals2() {
		return r45_individuals2;
	}
	public void setR45_individuals2(BigDecimal r45_individuals2) {
		this.r45_individuals2 = r45_individuals2;
	}
	public BigDecimal getR45_other1() {
		return r45_other1;
	}
	public void setR45_other1(BigDecimal r45_other1) {
		this.r45_other1 = r45_other1;
	}
	public BigDecimal getR45_banks2() {
		return r45_banks2;
	}
	public void setR45_banks2(BigDecimal r45_banks2) {
		this.r45_banks2 = r45_banks2;
	}
	public BigDecimal getR45_gov3() {
		return r45_gov3;
	}
	public void setR45_gov3(BigDecimal r45_gov3) {
		this.r45_gov3 = r45_gov3;
	}
	public BigDecimal getR45_others2() {
		return r45_others2;
	}
	public void setR45_others2(BigDecimal r45_others2) {
		this.r45_others2 = r45_others2;
	}
	public BigDecimal getR45_banks3() {
		return r45_banks3;
	}
	public void setR45_banks3(BigDecimal r45_banks3) {
		this.r45_banks3 = r45_banks3;
	}
	public BigDecimal getR45_gov4() {
		return r45_gov4;
	}
	public void setR45_gov4(BigDecimal r45_gov4) {
		this.r45_gov4 = r45_gov4;
	}
	public BigDecimal getR45_others3() {
		return r45_others3;
	}
	public void setR45_others3(BigDecimal r45_others3) {
		this.r45_others3 = r45_others3;
	}
	public BigDecimal getR45_foreign1() {
		return r45_foreign1;
	}
	public void setR45_foreign1(BigDecimal r45_foreign1) {
		this.r45_foreign1 = r45_foreign1;
	}
	public BigDecimal getR45_guarantees() {
		return r45_guarantees;
	}
	public void setR45_guarantees(BigDecimal r45_guarantees) {
		this.r45_guarantees = r45_guarantees;
	}
	public BigDecimal getR45_nbfi2() {
		return r45_nbfi2;
	}
	public void setR45_nbfi2(BigDecimal r45_nbfi2) {
		this.r45_nbfi2 = r45_nbfi2;
	}
	public BigDecimal getR45_interbank2() {
		return r45_interbank2;
	}
	public void setR45_interbank2(BigDecimal r45_interbank2) {
		this.r45_interbank2 = r45_interbank2;
	}
	public BigDecimal getR45_gov5() {
		return r45_gov5;
	}
	public void setR45_gov5(BigDecimal r45_gov5) {
		this.r45_gov5 = r45_gov5;
	}
	public BigDecimal getR45_corporate2() {
		return r45_corporate2;
	}
	public void setR45_corporate2(BigDecimal r45_corporate2) {
		this.r45_corporate2 = r45_corporate2;
	}
	public BigDecimal getR45_gre2() {
		return r45_gre2;
	}
	public void setR45_gre2(BigDecimal r45_gre2) {
		this.r45_gre2 = r45_gre2;
	}
	public BigDecimal getR45_individuals3() {
		return r45_individuals3;
	}
	public void setR45_individuals3(BigDecimal r45_individuals3) {
		this.r45_individuals3 = r45_individuals3;
	}
	public BigDecimal getR45_zero1() {
		return r45_zero1;
	}
	public void setR45_zero1(BigDecimal r45_zero1) {
		this.r45_zero1 = r45_zero1;
	}
	public BigDecimal getR45_three1() {
		return r45_three1;
	}
	public void setR45_three1(BigDecimal r45_three1) {
		this.r45_three1 = r45_three1;
	}
	public BigDecimal getR45_six1() {
		return r45_six1;
	}
	public void setR45_six1(BigDecimal r45_six1) {
		this.r45_six1 = r45_six1;
	}
	public BigDecimal getR45_oneyear1() {
		return r45_oneyear1;
	}
	public void setR45_oneyear1(BigDecimal r45_oneyear1) {
		this.r45_oneyear1 = r45_oneyear1;
	}
	public String getR45_empty() {
		return r45_empty;
	}
	public void setR45_empty(String r45_empty) {
		this.r45_empty = r45_empty;
	}
	public String getR46_product() {
		return r46_product;
	}
	public void setR46_product(String r46_product) {
		this.r46_product = r46_product;
	}
	public BigDecimal getR46_nbfi() {
		return r46_nbfi;
	}
	public void setR46_nbfi(BigDecimal r46_nbfi) {
		this.r46_nbfi = r46_nbfi;
	}
	public BigDecimal getR46_interbank() {
		return r46_interbank;
	}
	public void setR46_interbank(BigDecimal r46_interbank) {
		this.r46_interbank = r46_interbank;
	}
	public BigDecimal getR46_gov() {
		return r46_gov;
	}
	public void setR46_gov(BigDecimal r46_gov) {
		this.r46_gov = r46_gov;
	}
	public BigDecimal getR46_corporate() {
		return r46_corporate;
	}
	public void setR46_corporate(BigDecimal r46_corporate) {
		this.r46_corporate = r46_corporate;
	}
	public BigDecimal getR46_gre() {
		return r46_gre;
	}
	public void setR46_gre(BigDecimal r46_gre) {
		this.r46_gre = r46_gre;
	}
	public BigDecimal getR46_trade() {
		return r46_trade;
	}
	public void setR46_trade(BigDecimal r46_trade) {
		this.r46_trade = r46_trade;
	}
	public BigDecimal getR46_individuals() {
		return r46_individuals;
	}
	public void setR46_individuals(BigDecimal r46_individuals) {
		this.r46_individuals = r46_individuals;
	}
	public BigDecimal getR46_investment() {
		return r46_investment;
	}
	public void setR46_investment(BigDecimal r46_investment) {
		this.r46_investment = r46_investment;
	}
	public BigDecimal getR46_nbfi1() {
		return r46_nbfi1;
	}
	public void setR46_nbfi1(BigDecimal r46_nbfi1) {
		this.r46_nbfi1 = r46_nbfi1;
	}
	public BigDecimal getR46_interbank1() {
		return r46_interbank1;
	}
	public void setR46_interbank1(BigDecimal r46_interbank1) {
		this.r46_interbank1 = r46_interbank1;
	}
	public BigDecimal getR46_gov1() {
		return r46_gov1;
	}
	public void setR46_gov1(BigDecimal r46_gov1) {
		this.r46_gov1 = r46_gov1;
	}
	public BigDecimal getR46_corporate1() {
		return r46_corporate1;
	}
	public void setR46_corporate1(BigDecimal r46_corporate1) {
		this.r46_corporate1 = r46_corporate1;
	}
	public BigDecimal getR46_gre1() {
		return r46_gre1;
	}
	public void setR46_gre1(BigDecimal r46_gre1) {
		this.r46_gre1 = r46_gre1;
	}
	public BigDecimal getR46_trade1() {
		return r46_trade1;
	}
	public void setR46_trade1(BigDecimal r46_trade1) {
		this.r46_trade1 = r46_trade1;
	}
	public BigDecimal getR46_individuals1() {
		return r46_individuals1;
	}
	public void setR46_individuals1(BigDecimal r46_individuals1) {
		this.r46_individuals1 = r46_individuals1;
	}
	public BigDecimal getR46_investment1() {
		return r46_investment1;
	}
	public void setR46_investment1(BigDecimal r46_investment1) {
		this.r46_investment1 = r46_investment1;
	}
	public BigDecimal getR46_zer0() {
		return r46_zer0;
	}
	public void setR46_zer0(BigDecimal r46_zer0) {
		this.r46_zer0 = r46_zer0;
	}
	public BigDecimal getR46_three() {
		return r46_three;
	}
	public void setR46_three(BigDecimal r46_three) {
		this.r46_three = r46_three;
	}
	public BigDecimal getR46_six() {
		return r46_six;
	}
	public void setR46_six(BigDecimal r46_six) {
		this.r46_six = r46_six;
	}
	public BigDecimal getR46_oneyear() {
		return r46_oneyear;
	}
	public void setR46_oneyear(BigDecimal r46_oneyear) {
		this.r46_oneyear = r46_oneyear;
	}
	public BigDecimal getR46_foreign() {
		return r46_foreign;
	}
	public void setR46_foreign(BigDecimal r46_foreign) {
		this.r46_foreign = r46_foreign;
	}
	public BigDecimal getR46_banks() {
		return r46_banks;
	}
	public void setR46_banks(BigDecimal r46_banks) {
		this.r46_banks = r46_banks;
	}
	public BigDecimal getR46_gov2() {
		return r46_gov2;
	}
	public void setR46_gov2(BigDecimal r46_gov2) {
		this.r46_gov2 = r46_gov2;
	}
	public BigDecimal getR46_other() {
		return r46_other;
	}
	public void setR46_other(BigDecimal r46_other) {
		this.r46_other = r46_other;
	}
	public BigDecimal getR46_banks1() {
		return r46_banks1;
	}
	public void setR46_banks1(BigDecimal r46_banks1) {
		this.r46_banks1 = r46_banks1;
	}
	public BigDecimal getR46_individuals2() {
		return r46_individuals2;
	}
	public void setR46_individuals2(BigDecimal r46_individuals2) {
		this.r46_individuals2 = r46_individuals2;
	}
	public BigDecimal getR46_other1() {
		return r46_other1;
	}
	public void setR46_other1(BigDecimal r46_other1) {
		this.r46_other1 = r46_other1;
	}
	public BigDecimal getR46_banks2() {
		return r46_banks2;
	}
	public void setR46_banks2(BigDecimal r46_banks2) {
		this.r46_banks2 = r46_banks2;
	}
	public BigDecimal getR46_gov3() {
		return r46_gov3;
	}
	public void setR46_gov3(BigDecimal r46_gov3) {
		this.r46_gov3 = r46_gov3;
	}
	public BigDecimal getR46_others2() {
		return r46_others2;
	}
	public void setR46_others2(BigDecimal r46_others2) {
		this.r46_others2 = r46_others2;
	}
	public BigDecimal getR46_banks3() {
		return r46_banks3;
	}
	public void setR46_banks3(BigDecimal r46_banks3) {
		this.r46_banks3 = r46_banks3;
	}
	public BigDecimal getR46_gov4() {
		return r46_gov4;
	}
	public void setR46_gov4(BigDecimal r46_gov4) {
		this.r46_gov4 = r46_gov4;
	}
	public BigDecimal getR46_others3() {
		return r46_others3;
	}
	public void setR46_others3(BigDecimal r46_others3) {
		this.r46_others3 = r46_others3;
	}
	public BigDecimal getR46_foreign1() {
		return r46_foreign1;
	}
	public void setR46_foreign1(BigDecimal r46_foreign1) {
		this.r46_foreign1 = r46_foreign1;
	}
	public BigDecimal getR46_guarantees() {
		return r46_guarantees;
	}
	public void setR46_guarantees(BigDecimal r46_guarantees) {
		this.r46_guarantees = r46_guarantees;
	}
	public BigDecimal getR46_nbfi2() {
		return r46_nbfi2;
	}
	public void setR46_nbfi2(BigDecimal r46_nbfi2) {
		this.r46_nbfi2 = r46_nbfi2;
	}
	public BigDecimal getR46_interbank2() {
		return r46_interbank2;
	}
	public void setR46_interbank2(BigDecimal r46_interbank2) {
		this.r46_interbank2 = r46_interbank2;
	}
	public BigDecimal getR46_gov5() {
		return r46_gov5;
	}
	public void setR46_gov5(BigDecimal r46_gov5) {
		this.r46_gov5 = r46_gov5;
	}
	public BigDecimal getR46_corporate2() {
		return r46_corporate2;
	}
	public void setR46_corporate2(BigDecimal r46_corporate2) {
		this.r46_corporate2 = r46_corporate2;
	}
	public BigDecimal getR46_gre2() {
		return r46_gre2;
	}
	public void setR46_gre2(BigDecimal r46_gre2) {
		this.r46_gre2 = r46_gre2;
	}
	public BigDecimal getR46_individuals3() {
		return r46_individuals3;
	}
	public void setR46_individuals3(BigDecimal r46_individuals3) {
		this.r46_individuals3 = r46_individuals3;
	}
	public BigDecimal getR46_zero1() {
		return r46_zero1;
	}
	public void setR46_zero1(BigDecimal r46_zero1) {
		this.r46_zero1 = r46_zero1;
	}
	public BigDecimal getR46_three1() {
		return r46_three1;
	}
	public void setR46_three1(BigDecimal r46_three1) {
		this.r46_three1 = r46_three1;
	}
	public BigDecimal getR46_six1() {
		return r46_six1;
	}
	public void setR46_six1(BigDecimal r46_six1) {
		this.r46_six1 = r46_six1;
	}
	public BigDecimal getR46_oneyear1() {
		return r46_oneyear1;
	}
	public void setR46_oneyear1(BigDecimal r46_oneyear1) {
		this.r46_oneyear1 = r46_oneyear1;
	}
	public String getR46_empty() {
		return r46_empty;
	}
	public void setR46_empty(String r46_empty) {
		this.r46_empty = r46_empty;
	}
	public String getR47_product() {
		return r47_product;
	}
	public void setR47_product(String r47_product) {
		this.r47_product = r47_product;
	}
	public BigDecimal getR47_nbfi() {
		return r47_nbfi;
	}
	public void setR47_nbfi(BigDecimal r47_nbfi) {
		this.r47_nbfi = r47_nbfi;
	}
	public BigDecimal getR47_interbank() {
		return r47_interbank;
	}
	public void setR47_interbank(BigDecimal r47_interbank) {
		this.r47_interbank = r47_interbank;
	}
	public BigDecimal getR47_gov() {
		return r47_gov;
	}
	public void setR47_gov(BigDecimal r47_gov) {
		this.r47_gov = r47_gov;
	}
	public BigDecimal getR47_corporate() {
		return r47_corporate;
	}
	public void setR47_corporate(BigDecimal r47_corporate) {
		this.r47_corporate = r47_corporate;
	}
	public BigDecimal getR47_gre() {
		return r47_gre;
	}
	public void setR47_gre(BigDecimal r47_gre) {
		this.r47_gre = r47_gre;
	}
	public BigDecimal getR47_trade() {
		return r47_trade;
	}
	public void setR47_trade(BigDecimal r47_trade) {
		this.r47_trade = r47_trade;
	}
	public BigDecimal getR47_individuals() {
		return r47_individuals;
	}
	public void setR47_individuals(BigDecimal r47_individuals) {
		this.r47_individuals = r47_individuals;
	}
	public BigDecimal getR47_investment() {
		return r47_investment;
	}
	public void setR47_investment(BigDecimal r47_investment) {
		this.r47_investment = r47_investment;
	}
	public BigDecimal getR47_nbfi1() {
		return r47_nbfi1;
	}
	public void setR47_nbfi1(BigDecimal r47_nbfi1) {
		this.r47_nbfi1 = r47_nbfi1;
	}
	public BigDecimal getR47_interbank1() {
		return r47_interbank1;
	}
	public void setR47_interbank1(BigDecimal r47_interbank1) {
		this.r47_interbank1 = r47_interbank1;
	}
	public BigDecimal getR47_gov1() {
		return r47_gov1;
	}
	public void setR47_gov1(BigDecimal r47_gov1) {
		this.r47_gov1 = r47_gov1;
	}
	public BigDecimal getR47_corporate1() {
		return r47_corporate1;
	}
	public void setR47_corporate1(BigDecimal r47_corporate1) {
		this.r47_corporate1 = r47_corporate1;
	}
	public BigDecimal getR47_gre1() {
		return r47_gre1;
	}
	public void setR47_gre1(BigDecimal r47_gre1) {
		this.r47_gre1 = r47_gre1;
	}
	public BigDecimal getR47_trade1() {
		return r47_trade1;
	}
	public void setR47_trade1(BigDecimal r47_trade1) {
		this.r47_trade1 = r47_trade1;
	}
	public BigDecimal getR47_individuals1() {
		return r47_individuals1;
	}
	public void setR47_individuals1(BigDecimal r47_individuals1) {
		this.r47_individuals1 = r47_individuals1;
	}
	public BigDecimal getR47_investment1() {
		return r47_investment1;
	}
	public void setR47_investment1(BigDecimal r47_investment1) {
		this.r47_investment1 = r47_investment1;
	}
	public BigDecimal getR47_zer0() {
		return r47_zer0;
	}
	public void setR47_zer0(BigDecimal r47_zer0) {
		this.r47_zer0 = r47_zer0;
	}
	public BigDecimal getR47_three() {
		return r47_three;
	}
	public void setR47_three(BigDecimal r47_three) {
		this.r47_three = r47_three;
	}
	public BigDecimal getR47_six() {
		return r47_six;
	}
	public void setR47_six(BigDecimal r47_six) {
		this.r47_six = r47_six;
	}
	public BigDecimal getR47_oneyear() {
		return r47_oneyear;
	}
	public void setR47_oneyear(BigDecimal r47_oneyear) {
		this.r47_oneyear = r47_oneyear;
	}
	public BigDecimal getR47_foreign() {
		return r47_foreign;
	}
	public void setR47_foreign(BigDecimal r47_foreign) {
		this.r47_foreign = r47_foreign;
	}
	public BigDecimal getR47_banks() {
		return r47_banks;
	}
	public void setR47_banks(BigDecimal r47_banks) {
		this.r47_banks = r47_banks;
	}
	public BigDecimal getR47_gov2() {
		return r47_gov2;
	}
	public void setR47_gov2(BigDecimal r47_gov2) {
		this.r47_gov2 = r47_gov2;
	}
	public BigDecimal getR47_other() {
		return r47_other;
	}
	public void setR47_other(BigDecimal r47_other) {
		this.r47_other = r47_other;
	}
	public BigDecimal getR47_banks1() {
		return r47_banks1;
	}
	public void setR47_banks1(BigDecimal r47_banks1) {
		this.r47_banks1 = r47_banks1;
	}
	public BigDecimal getR47_individuals2() {
		return r47_individuals2;
	}
	public void setR47_individuals2(BigDecimal r47_individuals2) {
		this.r47_individuals2 = r47_individuals2;
	}
	public BigDecimal getR47_other1() {
		return r47_other1;
	}
	public void setR47_other1(BigDecimal r47_other1) {
		this.r47_other1 = r47_other1;
	}
	public BigDecimal getR47_banks2() {
		return r47_banks2;
	}
	public void setR47_banks2(BigDecimal r47_banks2) {
		this.r47_banks2 = r47_banks2;
	}
	public BigDecimal getR47_gov3() {
		return r47_gov3;
	}
	public void setR47_gov3(BigDecimal r47_gov3) {
		this.r47_gov3 = r47_gov3;
	}
	public BigDecimal getR47_others2() {
		return r47_others2;
	}
	public void setR47_others2(BigDecimal r47_others2) {
		this.r47_others2 = r47_others2;
	}
	public BigDecimal getR47_banks3() {
		return r47_banks3;
	}
	public void setR47_banks3(BigDecimal r47_banks3) {
		this.r47_banks3 = r47_banks3;
	}
	public BigDecimal getR47_gov4() {
		return r47_gov4;
	}
	public void setR47_gov4(BigDecimal r47_gov4) {
		this.r47_gov4 = r47_gov4;
	}
	public BigDecimal getR47_others3() {
		return r47_others3;
	}
	public void setR47_others3(BigDecimal r47_others3) {
		this.r47_others3 = r47_others3;
	}
	public BigDecimal getR47_foreign1() {
		return r47_foreign1;
	}
	public void setR47_foreign1(BigDecimal r47_foreign1) {
		this.r47_foreign1 = r47_foreign1;
	}
	public BigDecimal getR47_guarantees() {
		return r47_guarantees;
	}
	public void setR47_guarantees(BigDecimal r47_guarantees) {
		this.r47_guarantees = r47_guarantees;
	}
	public BigDecimal getR47_nbfi2() {
		return r47_nbfi2;
	}
	public void setR47_nbfi2(BigDecimal r47_nbfi2) {
		this.r47_nbfi2 = r47_nbfi2;
	}
	public BigDecimal getR47_interbank2() {
		return r47_interbank2;
	}
	public void setR47_interbank2(BigDecimal r47_interbank2) {
		this.r47_interbank2 = r47_interbank2;
	}
	public BigDecimal getR47_gov5() {
		return r47_gov5;
	}
	public void setR47_gov5(BigDecimal r47_gov5) {
		this.r47_gov5 = r47_gov5;
	}
	public BigDecimal getR47_corporate2() {
		return r47_corporate2;
	}
	public void setR47_corporate2(BigDecimal r47_corporate2) {
		this.r47_corporate2 = r47_corporate2;
	}
	public BigDecimal getR47_gre2() {
		return r47_gre2;
	}
	public void setR47_gre2(BigDecimal r47_gre2) {
		this.r47_gre2 = r47_gre2;
	}
	public BigDecimal getR47_individuals3() {
		return r47_individuals3;
	}
	public void setR47_individuals3(BigDecimal r47_individuals3) {
		this.r47_individuals3 = r47_individuals3;
	}
	public BigDecimal getR47_zero1() {
		return r47_zero1;
	}
	public void setR47_zero1(BigDecimal r47_zero1) {
		this.r47_zero1 = r47_zero1;
	}
	public BigDecimal getR47_three1() {
		return r47_three1;
	}
	public void setR47_three1(BigDecimal r47_three1) {
		this.r47_three1 = r47_three1;
	}
	public BigDecimal getR47_six1() {
		return r47_six1;
	}
	public void setR47_six1(BigDecimal r47_six1) {
		this.r47_six1 = r47_six1;
	}
	public BigDecimal getR47_oneyear1() {
		return r47_oneyear1;
	}
	public void setR47_oneyear1(BigDecimal r47_oneyear1) {
		this.r47_oneyear1 = r47_oneyear1;
	}
	public String getR47_empty() {
		return r47_empty;
	}
	public void setR47_empty(String r47_empty) {
		this.r47_empty = r47_empty;
	}
	public String getR48_product() {
		return r48_product;
	}
	public void setR48_product(String r48_product) {
		this.r48_product = r48_product;
	}
	public BigDecimal getR48_nbfi() {
		return r48_nbfi;
	}
	public void setR48_nbfi(BigDecimal r48_nbfi) {
		this.r48_nbfi = r48_nbfi;
	}
	public BigDecimal getR48_interbank() {
		return r48_interbank;
	}
	public void setR48_interbank(BigDecimal r48_interbank) {
		this.r48_interbank = r48_interbank;
	}
	public BigDecimal getR48_gov() {
		return r48_gov;
	}
	public void setR48_gov(BigDecimal r48_gov) {
		this.r48_gov = r48_gov;
	}
	public BigDecimal getR48_corporate() {
		return r48_corporate;
	}
	public void setR48_corporate(BigDecimal r48_corporate) {
		this.r48_corporate = r48_corporate;
	}
	public BigDecimal getR48_gre() {
		return r48_gre;
	}
	public void setR48_gre(BigDecimal r48_gre) {
		this.r48_gre = r48_gre;
	}
	public BigDecimal getR48_trade() {
		return r48_trade;
	}
	public void setR48_trade(BigDecimal r48_trade) {
		this.r48_trade = r48_trade;
	}
	public BigDecimal getR48_individuals() {
		return r48_individuals;
	}
	public void setR48_individuals(BigDecimal r48_individuals) {
		this.r48_individuals = r48_individuals;
	}
	public BigDecimal getR48_investment() {
		return r48_investment;
	}
	public void setR48_investment(BigDecimal r48_investment) {
		this.r48_investment = r48_investment;
	}
	public BigDecimal getR48_nbfi1() {
		return r48_nbfi1;
	}
	public void setR48_nbfi1(BigDecimal r48_nbfi1) {
		this.r48_nbfi1 = r48_nbfi1;
	}
	public BigDecimal getR48_interbank1() {
		return r48_interbank1;
	}
	public void setR48_interbank1(BigDecimal r48_interbank1) {
		this.r48_interbank1 = r48_interbank1;
	}
	public BigDecimal getR48_gov1() {
		return r48_gov1;
	}
	public void setR48_gov1(BigDecimal r48_gov1) {
		this.r48_gov1 = r48_gov1;
	}
	public BigDecimal getR48_corporate1() {
		return r48_corporate1;
	}
	public void setR48_corporate1(BigDecimal r48_corporate1) {
		this.r48_corporate1 = r48_corporate1;
	}
	public BigDecimal getR48_gre1() {
		return r48_gre1;
	}
	public void setR48_gre1(BigDecimal r48_gre1) {
		this.r48_gre1 = r48_gre1;
	}
	public BigDecimal getR48_trade1() {
		return r48_trade1;
	}
	public void setR48_trade1(BigDecimal r48_trade1) {
		this.r48_trade1 = r48_trade1;
	}
	public BigDecimal getR48_individuals1() {
		return r48_individuals1;
	}
	public void setR48_individuals1(BigDecimal r48_individuals1) {
		this.r48_individuals1 = r48_individuals1;
	}
	public BigDecimal getR48_investment1() {
		return r48_investment1;
	}
	public void setR48_investment1(BigDecimal r48_investment1) {
		this.r48_investment1 = r48_investment1;
	}
	public BigDecimal getR48_zer0() {
		return r48_zer0;
	}
	public void setR48_zer0(BigDecimal r48_zer0) {
		this.r48_zer0 = r48_zer0;
	}
	public BigDecimal getR48_three() {
		return r48_three;
	}
	public void setR48_three(BigDecimal r48_three) {
		this.r48_three = r48_three;
	}
	public BigDecimal getR48_six() {
		return r48_six;
	}
	public void setR48_six(BigDecimal r48_six) {
		this.r48_six = r48_six;
	}
	public BigDecimal getR48_oneyear() {
		return r48_oneyear;
	}
	public void setR48_oneyear(BigDecimal r48_oneyear) {
		this.r48_oneyear = r48_oneyear;
	}
	public BigDecimal getR48_foreign() {
		return r48_foreign;
	}
	public void setR48_foreign(BigDecimal r48_foreign) {
		this.r48_foreign = r48_foreign;
	}
	public BigDecimal getR48_banks() {
		return r48_banks;
	}
	public void setR48_banks(BigDecimal r48_banks) {
		this.r48_banks = r48_banks;
	}
	public BigDecimal getR48_gov2() {
		return r48_gov2;
	}
	public void setR48_gov2(BigDecimal r48_gov2) {
		this.r48_gov2 = r48_gov2;
	}
	public BigDecimal getR48_other() {
		return r48_other;
	}
	public void setR48_other(BigDecimal r48_other) {
		this.r48_other = r48_other;
	}
	public BigDecimal getR48_banks1() {
		return r48_banks1;
	}
	public void setR48_banks1(BigDecimal r48_banks1) {
		this.r48_banks1 = r48_banks1;
	}
	public BigDecimal getR48_individuals2() {
		return r48_individuals2;
	}
	public void setR48_individuals2(BigDecimal r48_individuals2) {
		this.r48_individuals2 = r48_individuals2;
	}
	public BigDecimal getR48_other1() {
		return r48_other1;
	}
	public void setR48_other1(BigDecimal r48_other1) {
		this.r48_other1 = r48_other1;
	}
	public BigDecimal getR48_banks2() {
		return r48_banks2;
	}
	public void setR48_banks2(BigDecimal r48_banks2) {
		this.r48_banks2 = r48_banks2;
	}
	public BigDecimal getR48_gov3() {
		return r48_gov3;
	}
	public void setR48_gov3(BigDecimal r48_gov3) {
		this.r48_gov3 = r48_gov3;
	}
	public BigDecimal getR48_others2() {
		return r48_others2;
	}
	public void setR48_others2(BigDecimal r48_others2) {
		this.r48_others2 = r48_others2;
	}
	public BigDecimal getR48_banks3() {
		return r48_banks3;
	}
	public void setR48_banks3(BigDecimal r48_banks3) {
		this.r48_banks3 = r48_banks3;
	}
	public BigDecimal getR48_gov4() {
		return r48_gov4;
	}
	public void setR48_gov4(BigDecimal r48_gov4) {
		this.r48_gov4 = r48_gov4;
	}
	public BigDecimal getR48_others3() {
		return r48_others3;
	}
	public void setR48_others3(BigDecimal r48_others3) {
		this.r48_others3 = r48_others3;
	}
	public BigDecimal getR48_foreign1() {
		return r48_foreign1;
	}
	public void setR48_foreign1(BigDecimal r48_foreign1) {
		this.r48_foreign1 = r48_foreign1;
	}
	public BigDecimal getR48_guarantees() {
		return r48_guarantees;
	}
	public void setR48_guarantees(BigDecimal r48_guarantees) {
		this.r48_guarantees = r48_guarantees;
	}
	public BigDecimal getR48_nbfi2() {
		return r48_nbfi2;
	}
	public void setR48_nbfi2(BigDecimal r48_nbfi2) {
		this.r48_nbfi2 = r48_nbfi2;
	}
	public BigDecimal getR48_interbank2() {
		return r48_interbank2;
	}
	public void setR48_interbank2(BigDecimal r48_interbank2) {
		this.r48_interbank2 = r48_interbank2;
	}
	public BigDecimal getR48_gov5() {
		return r48_gov5;
	}
	public void setR48_gov5(BigDecimal r48_gov5) {
		this.r48_gov5 = r48_gov5;
	}
	public BigDecimal getR48_corporate2() {
		return r48_corporate2;
	}
	public void setR48_corporate2(BigDecimal r48_corporate2) {
		this.r48_corporate2 = r48_corporate2;
	}
	public BigDecimal getR48_gre2() {
		return r48_gre2;
	}
	public void setR48_gre2(BigDecimal r48_gre2) {
		this.r48_gre2 = r48_gre2;
	}
	public BigDecimal getR48_individuals3() {
		return r48_individuals3;
	}
	public void setR48_individuals3(BigDecimal r48_individuals3) {
		this.r48_individuals3 = r48_individuals3;
	}
	public BigDecimal getR48_zero1() {
		return r48_zero1;
	}
	public void setR48_zero1(BigDecimal r48_zero1) {
		this.r48_zero1 = r48_zero1;
	}
	public BigDecimal getR48_three1() {
		return r48_three1;
	}
	public void setR48_three1(BigDecimal r48_three1) {
		this.r48_three1 = r48_three1;
	}
	public BigDecimal getR48_six1() {
		return r48_six1;
	}
	public void setR48_six1(BigDecimal r48_six1) {
		this.r48_six1 = r48_six1;
	}
	public BigDecimal getR48_oneyear1() {
		return r48_oneyear1;
	}
	public void setR48_oneyear1(BigDecimal r48_oneyear1) {
		this.r48_oneyear1 = r48_oneyear1;
	}
	public String getR48_empty() {
		return r48_empty;
	}
	public void setR48_empty(String r48_empty) {
		this.r48_empty = r48_empty;
	}
	public String getR49_product() {
		return r49_product;
	}
	public void setR49_product(String r49_product) {
		this.r49_product = r49_product;
	}
	public BigDecimal getR49_nbfi() {
		return r49_nbfi;
	}
	public void setR49_nbfi(BigDecimal r49_nbfi) {
		this.r49_nbfi = r49_nbfi;
	}
	public BigDecimal getR49_interbank() {
		return r49_interbank;
	}
	public void setR49_interbank(BigDecimal r49_interbank) {
		this.r49_interbank = r49_interbank;
	}
	public BigDecimal getR49_gov() {
		return r49_gov;
	}
	public void setR49_gov(BigDecimal r49_gov) {
		this.r49_gov = r49_gov;
	}
	public BigDecimal getR49_corporate() {
		return r49_corporate;
	}
	public void setR49_corporate(BigDecimal r49_corporate) {
		this.r49_corporate = r49_corporate;
	}
	public BigDecimal getR49_gre() {
		return r49_gre;
	}
	public void setR49_gre(BigDecimal r49_gre) {
		this.r49_gre = r49_gre;
	}
	public BigDecimal getR49_trade() {
		return r49_trade;
	}
	public void setR49_trade(BigDecimal r49_trade) {
		this.r49_trade = r49_trade;
	}
	public BigDecimal getR49_individuals() {
		return r49_individuals;
	}
	public void setR49_individuals(BigDecimal r49_individuals) {
		this.r49_individuals = r49_individuals;
	}
	public BigDecimal getR49_investment() {
		return r49_investment;
	}
	public void setR49_investment(BigDecimal r49_investment) {
		this.r49_investment = r49_investment;
	}
	public BigDecimal getR49_nbfi1() {
		return r49_nbfi1;
	}
	public void setR49_nbfi1(BigDecimal r49_nbfi1) {
		this.r49_nbfi1 = r49_nbfi1;
	}
	public BigDecimal getR49_interbank1() {
		return r49_interbank1;
	}
	public void setR49_interbank1(BigDecimal r49_interbank1) {
		this.r49_interbank1 = r49_interbank1;
	}
	public BigDecimal getR49_gov1() {
		return r49_gov1;
	}
	public void setR49_gov1(BigDecimal r49_gov1) {
		this.r49_gov1 = r49_gov1;
	}
	public BigDecimal getR49_corporate1() {
		return r49_corporate1;
	}
	public void setR49_corporate1(BigDecimal r49_corporate1) {
		this.r49_corporate1 = r49_corporate1;
	}
	public BigDecimal getR49_gre1() {
		return r49_gre1;
	}
	public void setR49_gre1(BigDecimal r49_gre1) {
		this.r49_gre1 = r49_gre1;
	}
	public BigDecimal getR49_trade1() {
		return r49_trade1;
	}
	public void setR49_trade1(BigDecimal r49_trade1) {
		this.r49_trade1 = r49_trade1;
	}
	public BigDecimal getR49_individuals1() {
		return r49_individuals1;
	}
	public void setR49_individuals1(BigDecimal r49_individuals1) {
		this.r49_individuals1 = r49_individuals1;
	}
	public BigDecimal getR49_investment1() {
		return r49_investment1;
	}
	public void setR49_investment1(BigDecimal r49_investment1) {
		this.r49_investment1 = r49_investment1;
	}
	public BigDecimal getR49_zer0() {
		return r49_zer0;
	}
	public void setR49_zer0(BigDecimal r49_zer0) {
		this.r49_zer0 = r49_zer0;
	}
	public BigDecimal getR49_three() {
		return r49_three;
	}
	public void setR49_three(BigDecimal r49_three) {
		this.r49_three = r49_three;
	}
	public BigDecimal getR49_six() {
		return r49_six;
	}
	public void setR49_six(BigDecimal r49_six) {
		this.r49_six = r49_six;
	}
	public BigDecimal getR49_oneyear() {
		return r49_oneyear;
	}
	public void setR49_oneyear(BigDecimal r49_oneyear) {
		this.r49_oneyear = r49_oneyear;
	}
	public BigDecimal getR49_foreign() {
		return r49_foreign;
	}
	public void setR49_foreign(BigDecimal r49_foreign) {
		this.r49_foreign = r49_foreign;
	}
	public BigDecimal getR49_banks() {
		return r49_banks;
	}
	public void setR49_banks(BigDecimal r49_banks) {
		this.r49_banks = r49_banks;
	}
	public BigDecimal getR49_gov2() {
		return r49_gov2;
	}
	public void setR49_gov2(BigDecimal r49_gov2) {
		this.r49_gov2 = r49_gov2;
	}
	public BigDecimal getR49_other() {
		return r49_other;
	}
	public void setR49_other(BigDecimal r49_other) {
		this.r49_other = r49_other;
	}
	public BigDecimal getR49_banks1() {
		return r49_banks1;
	}
	public void setR49_banks1(BigDecimal r49_banks1) {
		this.r49_banks1 = r49_banks1;
	}
	public BigDecimal getR49_individuals2() {
		return r49_individuals2;
	}
	public void setR49_individuals2(BigDecimal r49_individuals2) {
		this.r49_individuals2 = r49_individuals2;
	}
	public BigDecimal getR49_other1() {
		return r49_other1;
	}
	public void setR49_other1(BigDecimal r49_other1) {
		this.r49_other1 = r49_other1;
	}
	public BigDecimal getR49_banks2() {
		return r49_banks2;
	}
	public void setR49_banks2(BigDecimal r49_banks2) {
		this.r49_banks2 = r49_banks2;
	}
	public BigDecimal getR49_gov3() {
		return r49_gov3;
	}
	public void setR49_gov3(BigDecimal r49_gov3) {
		this.r49_gov3 = r49_gov3;
	}
	public BigDecimal getR49_others2() {
		return r49_others2;
	}
	public void setR49_others2(BigDecimal r49_others2) {
		this.r49_others2 = r49_others2;
	}
	public BigDecimal getR49_banks3() {
		return r49_banks3;
	}
	public void setR49_banks3(BigDecimal r49_banks3) {
		this.r49_banks3 = r49_banks3;
	}
	public BigDecimal getR49_gov4() {
		return r49_gov4;
	}
	public void setR49_gov4(BigDecimal r49_gov4) {
		this.r49_gov4 = r49_gov4;
	}
	public BigDecimal getR49_others3() {
		return r49_others3;
	}
	public void setR49_others3(BigDecimal r49_others3) {
		this.r49_others3 = r49_others3;
	}
	public BigDecimal getR49_foreign1() {
		return r49_foreign1;
	}
	public void setR49_foreign1(BigDecimal r49_foreign1) {
		this.r49_foreign1 = r49_foreign1;
	}
	public BigDecimal getR49_guarantees() {
		return r49_guarantees;
	}
	public void setR49_guarantees(BigDecimal r49_guarantees) {
		this.r49_guarantees = r49_guarantees;
	}
	public BigDecimal getR49_nbfi2() {
		return r49_nbfi2;
	}
	public void setR49_nbfi2(BigDecimal r49_nbfi2) {
		this.r49_nbfi2 = r49_nbfi2;
	}
	public BigDecimal getR49_interbank2() {
		return r49_interbank2;
	}
	public void setR49_interbank2(BigDecimal r49_interbank2) {
		this.r49_interbank2 = r49_interbank2;
	}
	public BigDecimal getR49_gov5() {
		return r49_gov5;
	}
	public void setR49_gov5(BigDecimal r49_gov5) {
		this.r49_gov5 = r49_gov5;
	}
	public BigDecimal getR49_corporate2() {
		return r49_corporate2;
	}
	public void setR49_corporate2(BigDecimal r49_corporate2) {
		this.r49_corporate2 = r49_corporate2;
	}
	public BigDecimal getR49_gre2() {
		return r49_gre2;
	}
	public void setR49_gre2(BigDecimal r49_gre2) {
		this.r49_gre2 = r49_gre2;
	}
	public BigDecimal getR49_individuals3() {
		return r49_individuals3;
	}
	public void setR49_individuals3(BigDecimal r49_individuals3) {
		this.r49_individuals3 = r49_individuals3;
	}
	public BigDecimal getR49_zero1() {
		return r49_zero1;
	}
	public void setR49_zero1(BigDecimal r49_zero1) {
		this.r49_zero1 = r49_zero1;
	}
	public BigDecimal getR49_three1() {
		return r49_three1;
	}
	public void setR49_three1(BigDecimal r49_three1) {
		this.r49_three1 = r49_three1;
	}
	public BigDecimal getR49_six1() {
		return r49_six1;
	}
	public void setR49_six1(BigDecimal r49_six1) {
		this.r49_six1 = r49_six1;
	}
	public BigDecimal getR49_oneyear1() {
		return r49_oneyear1;
	}
	public void setR49_oneyear1(BigDecimal r49_oneyear1) {
		this.r49_oneyear1 = r49_oneyear1;
	}
	public String getR49_empty() {
		return r49_empty;
	}
	public void setR49_empty(String r49_empty) {
		this.r49_empty = r49_empty;
	}
	public String getR50_product() {
		return r50_product;
	}
	public void setR50_product(String r50_product) {
		this.r50_product = r50_product;
	}
	public BigDecimal getR50_nbfi() {
		return r50_nbfi;
	}
	public void setR50_nbfi(BigDecimal r50_nbfi) {
		this.r50_nbfi = r50_nbfi;
	}
	public BigDecimal getR50_interbank() {
		return r50_interbank;
	}
	public void setR50_interbank(BigDecimal r50_interbank) {
		this.r50_interbank = r50_interbank;
	}
	public BigDecimal getR50_gov() {
		return r50_gov;
	}
	public void setR50_gov(BigDecimal r50_gov) {
		this.r50_gov = r50_gov;
	}
	public BigDecimal getR50_corporate() {
		return r50_corporate;
	}
	public void setR50_corporate(BigDecimal r50_corporate) {
		this.r50_corporate = r50_corporate;
	}
	public BigDecimal getR50_gre() {
		return r50_gre;
	}
	public void setR50_gre(BigDecimal r50_gre) {
		this.r50_gre = r50_gre;
	}
	public BigDecimal getR50_trade() {
		return r50_trade;
	}
	public void setR50_trade(BigDecimal r50_trade) {
		this.r50_trade = r50_trade;
	}
	public BigDecimal getR50_individuals() {
		return r50_individuals;
	}
	public void setR50_individuals(BigDecimal r50_individuals) {
		this.r50_individuals = r50_individuals;
	}
	public BigDecimal getR50_investment() {
		return r50_investment;
	}
	public void setR50_investment(BigDecimal r50_investment) {
		this.r50_investment = r50_investment;
	}
	public BigDecimal getR50_nbfi1() {
		return r50_nbfi1;
	}
	public void setR50_nbfi1(BigDecimal r50_nbfi1) {
		this.r50_nbfi1 = r50_nbfi1;
	}
	public BigDecimal getR50_interbank1() {
		return r50_interbank1;
	}
	public void setR50_interbank1(BigDecimal r50_interbank1) {
		this.r50_interbank1 = r50_interbank1;
	}
	public BigDecimal getR50_gov1() {
		return r50_gov1;
	}
	public void setR50_gov1(BigDecimal r50_gov1) {
		this.r50_gov1 = r50_gov1;
	}
	public BigDecimal getR50_corporate1() {
		return r50_corporate1;
	}
	public void setR50_corporate1(BigDecimal r50_corporate1) {
		this.r50_corporate1 = r50_corporate1;
	}
	public BigDecimal getR50_gre1() {
		return r50_gre1;
	}
	public void setR50_gre1(BigDecimal r50_gre1) {
		this.r50_gre1 = r50_gre1;
	}
	public BigDecimal getR50_trade1() {
		return r50_trade1;
	}
	public void setR50_trade1(BigDecimal r50_trade1) {
		this.r50_trade1 = r50_trade1;
	}
	public BigDecimal getR50_individuals1() {
		return r50_individuals1;
	}
	public void setR50_individuals1(BigDecimal r50_individuals1) {
		this.r50_individuals1 = r50_individuals1;
	}
	public BigDecimal getR50_investment1() {
		return r50_investment1;
	}
	public void setR50_investment1(BigDecimal r50_investment1) {
		this.r50_investment1 = r50_investment1;
	}
	public BigDecimal getR50_zer0() {
		return r50_zer0;
	}
	public void setR50_zer0(BigDecimal r50_zer0) {
		this.r50_zer0 = r50_zer0;
	}
	public BigDecimal getR50_three() {
		return r50_three;
	}
	public void setR50_three(BigDecimal r50_three) {
		this.r50_three = r50_three;
	}
	public BigDecimal getR50_six() {
		return r50_six;
	}
	public void setR50_six(BigDecimal r50_six) {
		this.r50_six = r50_six;
	}
	public BigDecimal getR50_oneyear() {
		return r50_oneyear;
	}
	public void setR50_oneyear(BigDecimal r50_oneyear) {
		this.r50_oneyear = r50_oneyear;
	}
	public BigDecimal getR50_foreign() {
		return r50_foreign;
	}
	public void setR50_foreign(BigDecimal r50_foreign) {
		this.r50_foreign = r50_foreign;
	}
	public BigDecimal getR50_banks() {
		return r50_banks;
	}
	public void setR50_banks(BigDecimal r50_banks) {
		this.r50_banks = r50_banks;
	}
	public BigDecimal getR50_gov2() {
		return r50_gov2;
	}
	public void setR50_gov2(BigDecimal r50_gov2) {
		this.r50_gov2 = r50_gov2;
	}
	public BigDecimal getR50_other() {
		return r50_other;
	}
	public void setR50_other(BigDecimal r50_other) {
		this.r50_other = r50_other;
	}
	public BigDecimal getR50_banks1() {
		return r50_banks1;
	}
	public void setR50_banks1(BigDecimal r50_banks1) {
		this.r50_banks1 = r50_banks1;
	}
	public BigDecimal getR50_individuals2() {
		return r50_individuals2;
	}
	public void setR50_individuals2(BigDecimal r50_individuals2) {
		this.r50_individuals2 = r50_individuals2;
	}
	public BigDecimal getR50_other1() {
		return r50_other1;
	}
	public void setR50_other1(BigDecimal r50_other1) {
		this.r50_other1 = r50_other1;
	}
	public BigDecimal getR50_banks2() {
		return r50_banks2;
	}
	public void setR50_banks2(BigDecimal r50_banks2) {
		this.r50_banks2 = r50_banks2;
	}
	public BigDecimal getR50_gov3() {
		return r50_gov3;
	}
	public void setR50_gov3(BigDecimal r50_gov3) {
		this.r50_gov3 = r50_gov3;
	}
	public BigDecimal getR50_others2() {
		return r50_others2;
	}
	public void setR50_others2(BigDecimal r50_others2) {
		this.r50_others2 = r50_others2;
	}
	public BigDecimal getR50_banks3() {
		return r50_banks3;
	}
	public void setR50_banks3(BigDecimal r50_banks3) {
		this.r50_banks3 = r50_banks3;
	}
	public BigDecimal getR50_gov4() {
		return r50_gov4;
	}
	public void setR50_gov4(BigDecimal r50_gov4) {
		this.r50_gov4 = r50_gov4;
	}
	public BigDecimal getR50_others3() {
		return r50_others3;
	}
	public void setR50_others3(BigDecimal r50_others3) {
		this.r50_others3 = r50_others3;
	}
	public BigDecimal getR50_foreign1() {
		return r50_foreign1;
	}
	public void setR50_foreign1(BigDecimal r50_foreign1) {
		this.r50_foreign1 = r50_foreign1;
	}
	public BigDecimal getR50_guarantees() {
		return r50_guarantees;
	}
	public void setR50_guarantees(BigDecimal r50_guarantees) {
		this.r50_guarantees = r50_guarantees;
	}
	public BigDecimal getR50_nbfi2() {
		return r50_nbfi2;
	}
	public void setR50_nbfi2(BigDecimal r50_nbfi2) {
		this.r50_nbfi2 = r50_nbfi2;
	}
	public BigDecimal getR50_interbank2() {
		return r50_interbank2;
	}
	public void setR50_interbank2(BigDecimal r50_interbank2) {
		this.r50_interbank2 = r50_interbank2;
	}
	public BigDecimal getR50_gov5() {
		return r50_gov5;
	}
	public void setR50_gov5(BigDecimal r50_gov5) {
		this.r50_gov5 = r50_gov5;
	}
	public BigDecimal getR50_corporate2() {
		return r50_corporate2;
	}
	public void setR50_corporate2(BigDecimal r50_corporate2) {
		this.r50_corporate2 = r50_corporate2;
	}
	public BigDecimal getR50_gre2() {
		return r50_gre2;
	}
	public void setR50_gre2(BigDecimal r50_gre2) {
		this.r50_gre2 = r50_gre2;
	}
	public BigDecimal getR50_individuals3() {
		return r50_individuals3;
	}
	public void setR50_individuals3(BigDecimal r50_individuals3) {
		this.r50_individuals3 = r50_individuals3;
	}
	public BigDecimal getR50_zero1() {
		return r50_zero1;
	}
	public void setR50_zero1(BigDecimal r50_zero1) {
		this.r50_zero1 = r50_zero1;
	}
	public BigDecimal getR50_three1() {
		return r50_three1;
	}
	public void setR50_three1(BigDecimal r50_three1) {
		this.r50_three1 = r50_three1;
	}
	public BigDecimal getR50_six1() {
		return r50_six1;
	}
	public void setR50_six1(BigDecimal r50_six1) {
		this.r50_six1 = r50_six1;
	}
	public BigDecimal getR50_oneyear1() {
		return r50_oneyear1;
	}
	public void setR50_oneyear1(BigDecimal r50_oneyear1) {
		this.r50_oneyear1 = r50_oneyear1;
	}
	public String getR50_empty() {
		return r50_empty;
	}
	public void setR50_empty(String r50_empty) {
		this.r50_empty = r50_empty;
	}
	public String getR51_product() {
		return r51_product;
	}
	public void setR51_product(String r51_product) {
		this.r51_product = r51_product;
	}
	public BigDecimal getR51_nbfi() {
		return r51_nbfi;
	}
	public void setR51_nbfi(BigDecimal r51_nbfi) {
		this.r51_nbfi = r51_nbfi;
	}
	public BigDecimal getR51_interbank() {
		return r51_interbank;
	}
	public void setR51_interbank(BigDecimal r51_interbank) {
		this.r51_interbank = r51_interbank;
	}
	public BigDecimal getR51_gov() {
		return r51_gov;
	}
	public void setR51_gov(BigDecimal r51_gov) {
		this.r51_gov = r51_gov;
	}
	public BigDecimal getR51_corporate() {
		return r51_corporate;
	}
	public void setR51_corporate(BigDecimal r51_corporate) {
		this.r51_corporate = r51_corporate;
	}
	public BigDecimal getR51_gre() {
		return r51_gre;
	}
	public void setR51_gre(BigDecimal r51_gre) {
		this.r51_gre = r51_gre;
	}
	public BigDecimal getR51_trade() {
		return r51_trade;
	}
	public void setR51_trade(BigDecimal r51_trade) {
		this.r51_trade = r51_trade;
	}
	public BigDecimal getR51_individuals() {
		return r51_individuals;
	}
	public void setR51_individuals(BigDecimal r51_individuals) {
		this.r51_individuals = r51_individuals;
	}
	public BigDecimal getR51_investment() {
		return r51_investment;
	}
	public void setR51_investment(BigDecimal r51_investment) {
		this.r51_investment = r51_investment;
	}
	public BigDecimal getR51_nbfi1() {
		return r51_nbfi1;
	}
	public void setR51_nbfi1(BigDecimal r51_nbfi1) {
		this.r51_nbfi1 = r51_nbfi1;
	}
	public BigDecimal getR51_interbank1() {
		return r51_interbank1;
	}
	public void setR51_interbank1(BigDecimal r51_interbank1) {
		this.r51_interbank1 = r51_interbank1;
	}
	public BigDecimal getR51_gov1() {
		return r51_gov1;
	}
	public void setR51_gov1(BigDecimal r51_gov1) {
		this.r51_gov1 = r51_gov1;
	}
	public BigDecimal getR51_corporate1() {
		return r51_corporate1;
	}
	public void setR51_corporate1(BigDecimal r51_corporate1) {
		this.r51_corporate1 = r51_corporate1;
	}
	public BigDecimal getR51_gre1() {
		return r51_gre1;
	}
	public void setR51_gre1(BigDecimal r51_gre1) {
		this.r51_gre1 = r51_gre1;
	}
	public BigDecimal getR51_trade1() {
		return r51_trade1;
	}
	public void setR51_trade1(BigDecimal r51_trade1) {
		this.r51_trade1 = r51_trade1;
	}
	public BigDecimal getR51_individuals1() {
		return r51_individuals1;
	}
	public void setR51_individuals1(BigDecimal r51_individuals1) {
		this.r51_individuals1 = r51_individuals1;
	}
	public BigDecimal getR51_investment1() {
		return r51_investment1;
	}
	public void setR51_investment1(BigDecimal r51_investment1) {
		this.r51_investment1 = r51_investment1;
	}
	public BigDecimal getR51_zer0() {
		return r51_zer0;
	}
	public void setR51_zer0(BigDecimal r51_zer0) {
		this.r51_zer0 = r51_zer0;
	}
	public BigDecimal getR51_three() {
		return r51_three;
	}
	public void setR51_three(BigDecimal r51_three) {
		this.r51_three = r51_three;
	}
	public BigDecimal getR51_six() {
		return r51_six;
	}
	public void setR51_six(BigDecimal r51_six) {
		this.r51_six = r51_six;
	}
	public BigDecimal getR51_oneyear() {
		return r51_oneyear;
	}
	public void setR51_oneyear(BigDecimal r51_oneyear) {
		this.r51_oneyear = r51_oneyear;
	}
	public BigDecimal getR51_foreign() {
		return r51_foreign;
	}
	public void setR51_foreign(BigDecimal r51_foreign) {
		this.r51_foreign = r51_foreign;
	}
	public BigDecimal getR51_banks() {
		return r51_banks;
	}
	public void setR51_banks(BigDecimal r51_banks) {
		this.r51_banks = r51_banks;
	}
	public BigDecimal getR51_gov2() {
		return r51_gov2;
	}
	public void setR51_gov2(BigDecimal r51_gov2) {
		this.r51_gov2 = r51_gov2;
	}
	public BigDecimal getR51_other() {
		return r51_other;
	}
	public void setR51_other(BigDecimal r51_other) {
		this.r51_other = r51_other;
	}
	public BigDecimal getR51_banks1() {
		return r51_banks1;
	}
	public void setR51_banks1(BigDecimal r51_banks1) {
		this.r51_banks1 = r51_banks1;
	}
	public BigDecimal getR51_individuals2() {
		return r51_individuals2;
	}
	public void setR51_individuals2(BigDecimal r51_individuals2) {
		this.r51_individuals2 = r51_individuals2;
	}
	public BigDecimal getR51_other1() {
		return r51_other1;
	}
	public void setR51_other1(BigDecimal r51_other1) {
		this.r51_other1 = r51_other1;
	}
	public BigDecimal getR51_banks2() {
		return r51_banks2;
	}
	public void setR51_banks2(BigDecimal r51_banks2) {
		this.r51_banks2 = r51_banks2;
	}
	public BigDecimal getR51_gov3() {
		return r51_gov3;
	}
	public void setR51_gov3(BigDecimal r51_gov3) {
		this.r51_gov3 = r51_gov3;
	}
	public BigDecimal getR51_others2() {
		return r51_others2;
	}
	public void setR51_others2(BigDecimal r51_others2) {
		this.r51_others2 = r51_others2;
	}
	public BigDecimal getR51_banks3() {
		return r51_banks3;
	}
	public void setR51_banks3(BigDecimal r51_banks3) {
		this.r51_banks3 = r51_banks3;
	}
	public BigDecimal getR51_gov4() {
		return r51_gov4;
	}
	public void setR51_gov4(BigDecimal r51_gov4) {
		this.r51_gov4 = r51_gov4;
	}
	public BigDecimal getR51_others3() {
		return r51_others3;
	}
	public void setR51_others3(BigDecimal r51_others3) {
		this.r51_others3 = r51_others3;
	}
	public BigDecimal getR51_foreign1() {
		return r51_foreign1;
	}
	public void setR51_foreign1(BigDecimal r51_foreign1) {
		this.r51_foreign1 = r51_foreign1;
	}
	public BigDecimal getR51_guarantees() {
		return r51_guarantees;
	}
	public void setR51_guarantees(BigDecimal r51_guarantees) {
		this.r51_guarantees = r51_guarantees;
	}
	public BigDecimal getR51_nbfi2() {
		return r51_nbfi2;
	}
	public void setR51_nbfi2(BigDecimal r51_nbfi2) {
		this.r51_nbfi2 = r51_nbfi2;
	}
	public BigDecimal getR51_interbank2() {
		return r51_interbank2;
	}
	public void setR51_interbank2(BigDecimal r51_interbank2) {
		this.r51_interbank2 = r51_interbank2;
	}
	public BigDecimal getR51_gov5() {
		return r51_gov5;
	}
	public void setR51_gov5(BigDecimal r51_gov5) {
		this.r51_gov5 = r51_gov5;
	}
	public BigDecimal getR51_corporate2() {
		return r51_corporate2;
	}
	public void setR51_corporate2(BigDecimal r51_corporate2) {
		this.r51_corporate2 = r51_corporate2;
	}
	public BigDecimal getR51_gre2() {
		return r51_gre2;
	}
	public void setR51_gre2(BigDecimal r51_gre2) {
		this.r51_gre2 = r51_gre2;
	}
	public BigDecimal getR51_individuals3() {
		return r51_individuals3;
	}
	public void setR51_individuals3(BigDecimal r51_individuals3) {
		this.r51_individuals3 = r51_individuals3;
	}
	public BigDecimal getR51_zero1() {
		return r51_zero1;
	}
	public void setR51_zero1(BigDecimal r51_zero1) {
		this.r51_zero1 = r51_zero1;
	}
	public BigDecimal getR51_three1() {
		return r51_three1;
	}
	public void setR51_three1(BigDecimal r51_three1) {
		this.r51_three1 = r51_three1;
	}
	public BigDecimal getR51_six1() {
		return r51_six1;
	}
	public void setR51_six1(BigDecimal r51_six1) {
		this.r51_six1 = r51_six1;
	}
	public BigDecimal getR51_oneyear1() {
		return r51_oneyear1;
	}
	public void setR51_oneyear1(BigDecimal r51_oneyear1) {
		this.r51_oneyear1 = r51_oneyear1;
	}
	public String getR51_empty() {
		return r51_empty;
	}
	public void setR51_empty(String r51_empty) {
		this.r51_empty = r51_empty;
	}
	public String getR52_product() {
		return r52_product;
	}
	public void setR52_product(String r52_product) {
		this.r52_product = r52_product;
	}
	public BigDecimal getR52_nbfi() {
		return r52_nbfi;
	}
	public void setR52_nbfi(BigDecimal r52_nbfi) {
		this.r52_nbfi = r52_nbfi;
	}
	public BigDecimal getR52_interbank() {
		return r52_interbank;
	}
	public void setR52_interbank(BigDecimal r52_interbank) {
		this.r52_interbank = r52_interbank;
	}
	public BigDecimal getR52_gov() {
		return r52_gov;
	}
	public void setR52_gov(BigDecimal r52_gov) {
		this.r52_gov = r52_gov;
	}
	public BigDecimal getR52_corporate() {
		return r52_corporate;
	}
	public void setR52_corporate(BigDecimal r52_corporate) {
		this.r52_corporate = r52_corporate;
	}
	public BigDecimal getR52_gre() {
		return r52_gre;
	}
	public void setR52_gre(BigDecimal r52_gre) {
		this.r52_gre = r52_gre;
	}
	public BigDecimal getR52_trade() {
		return r52_trade;
	}
	public void setR52_trade(BigDecimal r52_trade) {
		this.r52_trade = r52_trade;
	}
	public BigDecimal getR52_individuals() {
		return r52_individuals;
	}
	public void setR52_individuals(BigDecimal r52_individuals) {
		this.r52_individuals = r52_individuals;
	}
	public BigDecimal getR52_investment() {
		return r52_investment;
	}
	public void setR52_investment(BigDecimal r52_investment) {
		this.r52_investment = r52_investment;
	}
	public BigDecimal getR52_nbfi1() {
		return r52_nbfi1;
	}
	public void setR52_nbfi1(BigDecimal r52_nbfi1) {
		this.r52_nbfi1 = r52_nbfi1;
	}
	public BigDecimal getR52_interbank1() {
		return r52_interbank1;
	}
	public void setR52_interbank1(BigDecimal r52_interbank1) {
		this.r52_interbank1 = r52_interbank1;
	}
	public BigDecimal getR52_gov1() {
		return r52_gov1;
	}
	public void setR52_gov1(BigDecimal r52_gov1) {
		this.r52_gov1 = r52_gov1;
	}
	public BigDecimal getR52_corporate1() {
		return r52_corporate1;
	}
	public void setR52_corporate1(BigDecimal r52_corporate1) {
		this.r52_corporate1 = r52_corporate1;
	}
	public BigDecimal getR52_gre1() {
		return r52_gre1;
	}
	public void setR52_gre1(BigDecimal r52_gre1) {
		this.r52_gre1 = r52_gre1;
	}
	public BigDecimal getR52_trade1() {
		return r52_trade1;
	}
	public void setR52_trade1(BigDecimal r52_trade1) {
		this.r52_trade1 = r52_trade1;
	}
	public BigDecimal getR52_individuals1() {
		return r52_individuals1;
	}
	public void setR52_individuals1(BigDecimal r52_individuals1) {
		this.r52_individuals1 = r52_individuals1;
	}
	public BigDecimal getR52_investment1() {
		return r52_investment1;
	}
	public void setR52_investment1(BigDecimal r52_investment1) {
		this.r52_investment1 = r52_investment1;
	}
	public BigDecimal getR52_zer0() {
		return r52_zer0;
	}
	public void setR52_zer0(BigDecimal r52_zer0) {
		this.r52_zer0 = r52_zer0;
	}
	public BigDecimal getR52_three() {
		return r52_three;
	}
	public void setR52_three(BigDecimal r52_three) {
		this.r52_three = r52_three;
	}
	public BigDecimal getR52_six() {
		return r52_six;
	}
	public void setR52_six(BigDecimal r52_six) {
		this.r52_six = r52_six;
	}
	public BigDecimal getR52_oneyear() {
		return r52_oneyear;
	}
	public void setR52_oneyear(BigDecimal r52_oneyear) {
		this.r52_oneyear = r52_oneyear;
	}
	public BigDecimal getR52_foreign() {
		return r52_foreign;
	}
	public void setR52_foreign(BigDecimal r52_foreign) {
		this.r52_foreign = r52_foreign;
	}
	public BigDecimal getR52_banks() {
		return r52_banks;
	}
	public void setR52_banks(BigDecimal r52_banks) {
		this.r52_banks = r52_banks;
	}
	public BigDecimal getR52_gov2() {
		return r52_gov2;
	}
	public void setR52_gov2(BigDecimal r52_gov2) {
		this.r52_gov2 = r52_gov2;
	}
	public BigDecimal getR52_other() {
		return r52_other;
	}
	public void setR52_other(BigDecimal r52_other) {
		this.r52_other = r52_other;
	}
	public BigDecimal getR52_banks1() {
		return r52_banks1;
	}
	public void setR52_banks1(BigDecimal r52_banks1) {
		this.r52_banks1 = r52_banks1;
	}
	public BigDecimal getR52_individuals2() {
		return r52_individuals2;
	}
	public void setR52_individuals2(BigDecimal r52_individuals2) {
		this.r52_individuals2 = r52_individuals2;
	}
	public BigDecimal getR52_other1() {
		return r52_other1;
	}
	public void setR52_other1(BigDecimal r52_other1) {
		this.r52_other1 = r52_other1;
	}
	public BigDecimal getR52_banks2() {
		return r52_banks2;
	}
	public void setR52_banks2(BigDecimal r52_banks2) {
		this.r52_banks2 = r52_banks2;
	}
	public BigDecimal getR52_gov3() {
		return r52_gov3;
	}
	public void setR52_gov3(BigDecimal r52_gov3) {
		this.r52_gov3 = r52_gov3;
	}
	public BigDecimal getR52_others2() {
		return r52_others2;
	}
	public void setR52_others2(BigDecimal r52_others2) {
		this.r52_others2 = r52_others2;
	}
	public BigDecimal getR52_banks3() {
		return r52_banks3;
	}
	public void setR52_banks3(BigDecimal r52_banks3) {
		this.r52_banks3 = r52_banks3;
	}
	public BigDecimal getR52_gov4() {
		return r52_gov4;
	}
	public void setR52_gov4(BigDecimal r52_gov4) {
		this.r52_gov4 = r52_gov4;
	}
	public BigDecimal getR52_others3() {
		return r52_others3;
	}
	public void setR52_others3(BigDecimal r52_others3) {
		this.r52_others3 = r52_others3;
	}
	public BigDecimal getR52_foreign1() {
		return r52_foreign1;
	}
	public void setR52_foreign1(BigDecimal r52_foreign1) {
		this.r52_foreign1 = r52_foreign1;
	}
	public BigDecimal getR52_guarantees() {
		return r52_guarantees;
	}
	public void setR52_guarantees(BigDecimal r52_guarantees) {
		this.r52_guarantees = r52_guarantees;
	}
	public BigDecimal getR52_nbfi2() {
		return r52_nbfi2;
	}
	public void setR52_nbfi2(BigDecimal r52_nbfi2) {
		this.r52_nbfi2 = r52_nbfi2;
	}
	public BigDecimal getR52_interbank2() {
		return r52_interbank2;
	}
	public void setR52_interbank2(BigDecimal r52_interbank2) {
		this.r52_interbank2 = r52_interbank2;
	}
	public BigDecimal getR52_gov5() {
		return r52_gov5;
	}
	public void setR52_gov5(BigDecimal r52_gov5) {
		this.r52_gov5 = r52_gov5;
	}
	public BigDecimal getR52_corporate2() {
		return r52_corporate2;
	}
	public void setR52_corporate2(BigDecimal r52_corporate2) {
		this.r52_corporate2 = r52_corporate2;
	}
	public BigDecimal getR52_gre2() {
		return r52_gre2;
	}
	public void setR52_gre2(BigDecimal r52_gre2) {
		this.r52_gre2 = r52_gre2;
	}
	public BigDecimal getR52_individuals3() {
		return r52_individuals3;
	}
	public void setR52_individuals3(BigDecimal r52_individuals3) {
		this.r52_individuals3 = r52_individuals3;
	}
	public BigDecimal getR52_zero1() {
		return r52_zero1;
	}
	public void setR52_zero1(BigDecimal r52_zero1) {
		this.r52_zero1 = r52_zero1;
	}
	public BigDecimal getR52_three1() {
		return r52_three1;
	}
	public void setR52_three1(BigDecimal r52_three1) {
		this.r52_three1 = r52_three1;
	}
	public BigDecimal getR52_six1() {
		return r52_six1;
	}
	public void setR52_six1(BigDecimal r52_six1) {
		this.r52_six1 = r52_six1;
	}
	public BigDecimal getR52_oneyear1() {
		return r52_oneyear1;
	}
	public void setR52_oneyear1(BigDecimal r52_oneyear1) {
		this.r52_oneyear1 = r52_oneyear1;
	}
	public String getR52_empty() {
		return r52_empty;
	}
	public void setR52_empty(String r52_empty) {
		this.r52_empty = r52_empty;
	}
	public String getR53_product() {
		return r53_product;
	}
	public void setR53_product(String r53_product) {
		this.r53_product = r53_product;
	}
	public BigDecimal getR53_nbfi() {
		return r53_nbfi;
	}
	public void setR53_nbfi(BigDecimal r53_nbfi) {
		this.r53_nbfi = r53_nbfi;
	}
	public BigDecimal getR53_interbank() {
		return r53_interbank;
	}
	public void setR53_interbank(BigDecimal r53_interbank) {
		this.r53_interbank = r53_interbank;
	}
	public BigDecimal getR53_gov() {
		return r53_gov;
	}
	public void setR53_gov(BigDecimal r53_gov) {
		this.r53_gov = r53_gov;
	}
	public BigDecimal getR53_corporate() {
		return r53_corporate;
	}
	public void setR53_corporate(BigDecimal r53_corporate) {
		this.r53_corporate = r53_corporate;
	}
	public BigDecimal getR53_gre() {
		return r53_gre;
	}
	public void setR53_gre(BigDecimal r53_gre) {
		this.r53_gre = r53_gre;
	}
	public BigDecimal getR53_trade() {
		return r53_trade;
	}
	public void setR53_trade(BigDecimal r53_trade) {
		this.r53_trade = r53_trade;
	}
	public BigDecimal getR53_individuals() {
		return r53_individuals;
	}
	public void setR53_individuals(BigDecimal r53_individuals) {
		this.r53_individuals = r53_individuals;
	}
	public BigDecimal getR53_investment() {
		return r53_investment;
	}
	public void setR53_investment(BigDecimal r53_investment) {
		this.r53_investment = r53_investment;
	}
	public BigDecimal getR53_nbfi1() {
		return r53_nbfi1;
	}
	public void setR53_nbfi1(BigDecimal r53_nbfi1) {
		this.r53_nbfi1 = r53_nbfi1;
	}
	public BigDecimal getR53_interbank1() {
		return r53_interbank1;
	}
	public void setR53_interbank1(BigDecimal r53_interbank1) {
		this.r53_interbank1 = r53_interbank1;
	}
	public BigDecimal getR53_gov1() {
		return r53_gov1;
	}
	public void setR53_gov1(BigDecimal r53_gov1) {
		this.r53_gov1 = r53_gov1;
	}
	public BigDecimal getR53_corporate1() {
		return r53_corporate1;
	}
	public void setR53_corporate1(BigDecimal r53_corporate1) {
		this.r53_corporate1 = r53_corporate1;
	}
	public BigDecimal getR53_gre1() {
		return r53_gre1;
	}
	public void setR53_gre1(BigDecimal r53_gre1) {
		this.r53_gre1 = r53_gre1;
	}
	public BigDecimal getR53_trade1() {
		return r53_trade1;
	}
	public void setR53_trade1(BigDecimal r53_trade1) {
		this.r53_trade1 = r53_trade1;
	}
	public BigDecimal getR53_individuals1() {
		return r53_individuals1;
	}
	public void setR53_individuals1(BigDecimal r53_individuals1) {
		this.r53_individuals1 = r53_individuals1;
	}
	public BigDecimal getR53_investment1() {
		return r53_investment1;
	}
	public void setR53_investment1(BigDecimal r53_investment1) {
		this.r53_investment1 = r53_investment1;
	}
	public BigDecimal getR53_zer0() {
		return r53_zer0;
	}
	public void setR53_zer0(BigDecimal r53_zer0) {
		this.r53_zer0 = r53_zer0;
	}
	public BigDecimal getR53_three() {
		return r53_three;
	}
	public void setR53_three(BigDecimal r53_three) {
		this.r53_three = r53_three;
	}
	public BigDecimal getR53_six() {
		return r53_six;
	}
	public void setR53_six(BigDecimal r53_six) {
		this.r53_six = r53_six;
	}
	public BigDecimal getR53_oneyear() {
		return r53_oneyear;
	}
	public void setR53_oneyear(BigDecimal r53_oneyear) {
		this.r53_oneyear = r53_oneyear;
	}
	public BigDecimal getR53_foreign() {
		return r53_foreign;
	}
	public void setR53_foreign(BigDecimal r53_foreign) {
		this.r53_foreign = r53_foreign;
	}
	public BigDecimal getR53_banks() {
		return r53_banks;
	}
	public void setR53_banks(BigDecimal r53_banks) {
		this.r53_banks = r53_banks;
	}
	public BigDecimal getR53_gov2() {
		return r53_gov2;
	}
	public void setR53_gov2(BigDecimal r53_gov2) {
		this.r53_gov2 = r53_gov2;
	}
	public BigDecimal getR53_other() {
		return r53_other;
	}
	public void setR53_other(BigDecimal r53_other) {
		this.r53_other = r53_other;
	}
	public BigDecimal getR53_banks1() {
		return r53_banks1;
	}
	public void setR53_banks1(BigDecimal r53_banks1) {
		this.r53_banks1 = r53_banks1;
	}
	public BigDecimal getR53_individuals2() {
		return r53_individuals2;
	}
	public void setR53_individuals2(BigDecimal r53_individuals2) {
		this.r53_individuals2 = r53_individuals2;
	}
	public BigDecimal getR53_other1() {
		return r53_other1;
	}
	public void setR53_other1(BigDecimal r53_other1) {
		this.r53_other1 = r53_other1;
	}
	public BigDecimal getR53_banks2() {
		return r53_banks2;
	}
	public void setR53_banks2(BigDecimal r53_banks2) {
		this.r53_banks2 = r53_banks2;
	}
	public BigDecimal getR53_gov3() {
		return r53_gov3;
	}
	public void setR53_gov3(BigDecimal r53_gov3) {
		this.r53_gov3 = r53_gov3;
	}
	public BigDecimal getR53_others2() {
		return r53_others2;
	}
	public void setR53_others2(BigDecimal r53_others2) {
		this.r53_others2 = r53_others2;
	}
	public BigDecimal getR53_banks3() {
		return r53_banks3;
	}
	public void setR53_banks3(BigDecimal r53_banks3) {
		this.r53_banks3 = r53_banks3;
	}
	public BigDecimal getR53_gov4() {
		return r53_gov4;
	}
	public void setR53_gov4(BigDecimal r53_gov4) {
		this.r53_gov4 = r53_gov4;
	}
	public BigDecimal getR53_others3() {
		return r53_others3;
	}
	public void setR53_others3(BigDecimal r53_others3) {
		this.r53_others3 = r53_others3;
	}
	public BigDecimal getR53_foreign1() {
		return r53_foreign1;
	}
	public void setR53_foreign1(BigDecimal r53_foreign1) {
		this.r53_foreign1 = r53_foreign1;
	}
	public BigDecimal getR53_guarantees() {
		return r53_guarantees;
	}
	public void setR53_guarantees(BigDecimal r53_guarantees) {
		this.r53_guarantees = r53_guarantees;
	}
	public BigDecimal getR53_nbfi2() {
		return r53_nbfi2;
	}
	public void setR53_nbfi2(BigDecimal r53_nbfi2) {
		this.r53_nbfi2 = r53_nbfi2;
	}
	public BigDecimal getR53_interbank2() {
		return r53_interbank2;
	}
	public void setR53_interbank2(BigDecimal r53_interbank2) {
		this.r53_interbank2 = r53_interbank2;
	}
	public BigDecimal getR53_gov5() {
		return r53_gov5;
	}
	public void setR53_gov5(BigDecimal r53_gov5) {
		this.r53_gov5 = r53_gov5;
	}
	public BigDecimal getR53_corporate2() {
		return r53_corporate2;
	}
	public void setR53_corporate2(BigDecimal r53_corporate2) {
		this.r53_corporate2 = r53_corporate2;
	}
	public BigDecimal getR53_gre2() {
		return r53_gre2;
	}
	public void setR53_gre2(BigDecimal r53_gre2) {
		this.r53_gre2 = r53_gre2;
	}
	public BigDecimal getR53_individuals3() {
		return r53_individuals3;
	}
	public void setR53_individuals3(BigDecimal r53_individuals3) {
		this.r53_individuals3 = r53_individuals3;
	}
	public BigDecimal getR53_zero1() {
		return r53_zero1;
	}
	public void setR53_zero1(BigDecimal r53_zero1) {
		this.r53_zero1 = r53_zero1;
	}
	public BigDecimal getR53_three1() {
		return r53_three1;
	}
	public void setR53_three1(BigDecimal r53_three1) {
		this.r53_three1 = r53_three1;
	}
	public BigDecimal getR53_six1() {
		return r53_six1;
	}
	public void setR53_six1(BigDecimal r53_six1) {
		this.r53_six1 = r53_six1;
	}
	public BigDecimal getR53_oneyear1() {
		return r53_oneyear1;
	}
	public void setR53_oneyear1(BigDecimal r53_oneyear1) {
		this.r53_oneyear1 = r53_oneyear1;
	}
	public String getR53_empty() {
		return r53_empty;
	}
	public void setR53_empty(String r53_empty) {
		this.r53_empty = r53_empty;
	}
	public String getR54_product() {
		return r54_product;
	}
	public void setR54_product(String r54_product) {
		this.r54_product = r54_product;
	}
	public BigDecimal getR54_nbfi() {
		return r54_nbfi;
	}
	public void setR54_nbfi(BigDecimal r54_nbfi) {
		this.r54_nbfi = r54_nbfi;
	}
	public BigDecimal getR54_interbank() {
		return r54_interbank;
	}
	public void setR54_interbank(BigDecimal r54_interbank) {
		this.r54_interbank = r54_interbank;
	}
	public BigDecimal getR54_gov() {
		return r54_gov;
	}
	public void setR54_gov(BigDecimal r54_gov) {
		this.r54_gov = r54_gov;
	}
	public BigDecimal getR54_corporate() {
		return r54_corporate;
	}
	public void setR54_corporate(BigDecimal r54_corporate) {
		this.r54_corporate = r54_corporate;
	}
	public BigDecimal getR54_gre() {
		return r54_gre;
	}
	public void setR54_gre(BigDecimal r54_gre) {
		this.r54_gre = r54_gre;
	}
	public BigDecimal getR54_trade() {
		return r54_trade;
	}
	public void setR54_trade(BigDecimal r54_trade) {
		this.r54_trade = r54_trade;
	}
	public BigDecimal getR54_individuals() {
		return r54_individuals;
	}
	public void setR54_individuals(BigDecimal r54_individuals) {
		this.r54_individuals = r54_individuals;
	}
	public BigDecimal getR54_investment() {
		return r54_investment;
	}
	public void setR54_investment(BigDecimal r54_investment) {
		this.r54_investment = r54_investment;
	}
	public BigDecimal getR54_nbfi1() {
		return r54_nbfi1;
	}
	public void setR54_nbfi1(BigDecimal r54_nbfi1) {
		this.r54_nbfi1 = r54_nbfi1;
	}
	public BigDecimal getR54_interbank1() {
		return r54_interbank1;
	}
	public void setR54_interbank1(BigDecimal r54_interbank1) {
		this.r54_interbank1 = r54_interbank1;
	}
	public BigDecimal getR54_gov1() {
		return r54_gov1;
	}
	public void setR54_gov1(BigDecimal r54_gov1) {
		this.r54_gov1 = r54_gov1;
	}
	public BigDecimal getR54_corporate1() {
		return r54_corporate1;
	}
	public void setR54_corporate1(BigDecimal r54_corporate1) {
		this.r54_corporate1 = r54_corporate1;
	}
	public BigDecimal getR54_gre1() {
		return r54_gre1;
	}
	public void setR54_gre1(BigDecimal r54_gre1) {
		this.r54_gre1 = r54_gre1;
	}
	public BigDecimal getR54_trade1() {
		return r54_trade1;
	}
	public void setR54_trade1(BigDecimal r54_trade1) {
		this.r54_trade1 = r54_trade1;
	}
	public BigDecimal getR54_individuals1() {
		return r54_individuals1;
	}
	public void setR54_individuals1(BigDecimal r54_individuals1) {
		this.r54_individuals1 = r54_individuals1;
	}
	public BigDecimal getR54_investment1() {
		return r54_investment1;
	}
	public void setR54_investment1(BigDecimal r54_investment1) {
		this.r54_investment1 = r54_investment1;
	}
	public BigDecimal getR54_zer0() {
		return r54_zer0;
	}
	public void setR54_zer0(BigDecimal r54_zer0) {
		this.r54_zer0 = r54_zer0;
	}
	public BigDecimal getR54_three() {
		return r54_three;
	}
	public void setR54_three(BigDecimal r54_three) {
		this.r54_three = r54_three;
	}
	public BigDecimal getR54_six() {
		return r54_six;
	}
	public void setR54_six(BigDecimal r54_six) {
		this.r54_six = r54_six;
	}
	public BigDecimal getR54_oneyear() {
		return r54_oneyear;
	}
	public void setR54_oneyear(BigDecimal r54_oneyear) {
		this.r54_oneyear = r54_oneyear;
	}
	public BigDecimal getR54_foreign() {
		return r54_foreign;
	}
	public void setR54_foreign(BigDecimal r54_foreign) {
		this.r54_foreign = r54_foreign;
	}
	public BigDecimal getR54_banks() {
		return r54_banks;
	}
	public void setR54_banks(BigDecimal r54_banks) {
		this.r54_banks = r54_banks;
	}
	public BigDecimal getR54_gov2() {
		return r54_gov2;
	}
	public void setR54_gov2(BigDecimal r54_gov2) {
		this.r54_gov2 = r54_gov2;
	}
	public BigDecimal getR54_other() {
		return r54_other;
	}
	public void setR54_other(BigDecimal r54_other) {
		this.r54_other = r54_other;
	}
	public BigDecimal getR54_banks1() {
		return r54_banks1;
	}
	public void setR54_banks1(BigDecimal r54_banks1) {
		this.r54_banks1 = r54_banks1;
	}
	public BigDecimal getR54_individuals2() {
		return r54_individuals2;
	}
	public void setR54_individuals2(BigDecimal r54_individuals2) {
		this.r54_individuals2 = r54_individuals2;
	}
	public BigDecimal getR54_other1() {
		return r54_other1;
	}
	public void setR54_other1(BigDecimal r54_other1) {
		this.r54_other1 = r54_other1;
	}
	public BigDecimal getR54_banks2() {
		return r54_banks2;
	}
	public void setR54_banks2(BigDecimal r54_banks2) {
		this.r54_banks2 = r54_banks2;
	}
	public BigDecimal getR54_gov3() {
		return r54_gov3;
	}
	public void setR54_gov3(BigDecimal r54_gov3) {
		this.r54_gov3 = r54_gov3;
	}
	public BigDecimal getR54_others2() {
		return r54_others2;
	}
	public void setR54_others2(BigDecimal r54_others2) {
		this.r54_others2 = r54_others2;
	}
	public BigDecimal getR54_banks3() {
		return r54_banks3;
	}
	public void setR54_banks3(BigDecimal r54_banks3) {
		this.r54_banks3 = r54_banks3;
	}
	public BigDecimal getR54_gov4() {
		return r54_gov4;
	}
	public void setR54_gov4(BigDecimal r54_gov4) {
		this.r54_gov4 = r54_gov4;
	}
	public BigDecimal getR54_others3() {
		return r54_others3;
	}
	public void setR54_others3(BigDecimal r54_others3) {
		this.r54_others3 = r54_others3;
	}
	public BigDecimal getR54_foreign1() {
		return r54_foreign1;
	}
	public void setR54_foreign1(BigDecimal r54_foreign1) {
		this.r54_foreign1 = r54_foreign1;
	}
	public BigDecimal getR54_guarantees() {
		return r54_guarantees;
	}
	public void setR54_guarantees(BigDecimal r54_guarantees) {
		this.r54_guarantees = r54_guarantees;
	}
	public BigDecimal getR54_nbfi2() {
		return r54_nbfi2;
	}
	public void setR54_nbfi2(BigDecimal r54_nbfi2) {
		this.r54_nbfi2 = r54_nbfi2;
	}
	public BigDecimal getR54_interbank2() {
		return r54_interbank2;
	}
	public void setR54_interbank2(BigDecimal r54_interbank2) {
		this.r54_interbank2 = r54_interbank2;
	}
	public BigDecimal getR54_gov5() {
		return r54_gov5;
	}
	public void setR54_gov5(BigDecimal r54_gov5) {
		this.r54_gov5 = r54_gov5;
	}
	public BigDecimal getR54_corporate2() {
		return r54_corporate2;
	}
	public void setR54_corporate2(BigDecimal r54_corporate2) {
		this.r54_corporate2 = r54_corporate2;
	}
	public BigDecimal getR54_gre2() {
		return r54_gre2;
	}
	public void setR54_gre2(BigDecimal r54_gre2) {
		this.r54_gre2 = r54_gre2;
	}
	public BigDecimal getR54_individuals3() {
		return r54_individuals3;
	}
	public void setR54_individuals3(BigDecimal r54_individuals3) {
		this.r54_individuals3 = r54_individuals3;
	}
	public BigDecimal getR54_zero1() {
		return r54_zero1;
	}
	public void setR54_zero1(BigDecimal r54_zero1) {
		this.r54_zero1 = r54_zero1;
	}
	public BigDecimal getR54_three1() {
		return r54_three1;
	}
	public void setR54_three1(BigDecimal r54_three1) {
		this.r54_three1 = r54_three1;
	}
	public BigDecimal getR54_six1() {
		return r54_six1;
	}
	public void setR54_six1(BigDecimal r54_six1) {
		this.r54_six1 = r54_six1;
	}
	public BigDecimal getR54_oneyear1() {
		return r54_oneyear1;
	}
	public void setR54_oneyear1(BigDecimal r54_oneyear1) {
		this.r54_oneyear1 = r54_oneyear1;
	}
	public String getR54_empty() {
		return r54_empty;
	}
	public void setR54_empty(String r54_empty) {
		this.r54_empty = r54_empty;
	}
	public String getR55_product() {
		return r55_product;
	}
	public void setR55_product(String r55_product) {
		this.r55_product = r55_product;
	}
	public BigDecimal getR55_nbfi() {
		return r55_nbfi;
	}
	public void setR55_nbfi(BigDecimal r55_nbfi) {
		this.r55_nbfi = r55_nbfi;
	}
	public BigDecimal getR55_interbank() {
		return r55_interbank;
	}
	public void setR55_interbank(BigDecimal r55_interbank) {
		this.r55_interbank = r55_interbank;
	}
	public BigDecimal getR55_gov() {
		return r55_gov;
	}
	public void setR55_gov(BigDecimal r55_gov) {
		this.r55_gov = r55_gov;
	}
	public BigDecimal getR55_corporate() {
		return r55_corporate;
	}
	public void setR55_corporate(BigDecimal r55_corporate) {
		this.r55_corporate = r55_corporate;
	}
	public BigDecimal getR55_gre() {
		return r55_gre;
	}
	public void setR55_gre(BigDecimal r55_gre) {
		this.r55_gre = r55_gre;
	}
	public BigDecimal getR55_trade() {
		return r55_trade;
	}
	public void setR55_trade(BigDecimal r55_trade) {
		this.r55_trade = r55_trade;
	}
	public BigDecimal getR55_individuals() {
		return r55_individuals;
	}
	public void setR55_individuals(BigDecimal r55_individuals) {
		this.r55_individuals = r55_individuals;
	}
	public BigDecimal getR55_investment() {
		return r55_investment;
	}
	public void setR55_investment(BigDecimal r55_investment) {
		this.r55_investment = r55_investment;
	}
	public BigDecimal getR55_nbfi1() {
		return r55_nbfi1;
	}
	public void setR55_nbfi1(BigDecimal r55_nbfi1) {
		this.r55_nbfi1 = r55_nbfi1;
	}
	public BigDecimal getR55_interbank1() {
		return r55_interbank1;
	}
	public void setR55_interbank1(BigDecimal r55_interbank1) {
		this.r55_interbank1 = r55_interbank1;
	}
	public BigDecimal getR55_gov1() {
		return r55_gov1;
	}
	public void setR55_gov1(BigDecimal r55_gov1) {
		this.r55_gov1 = r55_gov1;
	}
	public BigDecimal getR55_corporate1() {
		return r55_corporate1;
	}
	public void setR55_corporate1(BigDecimal r55_corporate1) {
		this.r55_corporate1 = r55_corporate1;
	}
	public BigDecimal getR55_gre1() {
		return r55_gre1;
	}
	public void setR55_gre1(BigDecimal r55_gre1) {
		this.r55_gre1 = r55_gre1;
	}
	public BigDecimal getR55_trade1() {
		return r55_trade1;
	}
	public void setR55_trade1(BigDecimal r55_trade1) {
		this.r55_trade1 = r55_trade1;
	}
	public BigDecimal getR55_individuals1() {
		return r55_individuals1;
	}
	public void setR55_individuals1(BigDecimal r55_individuals1) {
		this.r55_individuals1 = r55_individuals1;
	}
	public BigDecimal getR55_investment1() {
		return r55_investment1;
	}
	public void setR55_investment1(BigDecimal r55_investment1) {
		this.r55_investment1 = r55_investment1;
	}
	public BigDecimal getR55_zer0() {
		return r55_zer0;
	}
	public void setR55_zer0(BigDecimal r55_zer0) {
		this.r55_zer0 = r55_zer0;
	}
	public BigDecimal getR55_three() {
		return r55_three;
	}
	public void setR55_three(BigDecimal r55_three) {
		this.r55_three = r55_three;
	}
	public BigDecimal getR55_six() {
		return r55_six;
	}
	public void setR55_six(BigDecimal r55_six) {
		this.r55_six = r55_six;
	}
	public BigDecimal getR55_oneyear() {
		return r55_oneyear;
	}
	public void setR55_oneyear(BigDecimal r55_oneyear) {
		this.r55_oneyear = r55_oneyear;
	}
	public BigDecimal getR55_foreign() {
		return r55_foreign;
	}
	public void setR55_foreign(BigDecimal r55_foreign) {
		this.r55_foreign = r55_foreign;
	}
	public BigDecimal getR55_banks() {
		return r55_banks;
	}
	public void setR55_banks(BigDecimal r55_banks) {
		this.r55_banks = r55_banks;
	}
	public BigDecimal getR55_gov2() {
		return r55_gov2;
	}
	public void setR55_gov2(BigDecimal r55_gov2) {
		this.r55_gov2 = r55_gov2;
	}
	public BigDecimal getR55_other() {
		return r55_other;
	}
	public void setR55_other(BigDecimal r55_other) {
		this.r55_other = r55_other;
	}
	public BigDecimal getR55_banks1() {
		return r55_banks1;
	}
	public void setR55_banks1(BigDecimal r55_banks1) {
		this.r55_banks1 = r55_banks1;
	}
	public BigDecimal getR55_individuals2() {
		return r55_individuals2;
	}
	public void setR55_individuals2(BigDecimal r55_individuals2) {
		this.r55_individuals2 = r55_individuals2;
	}
	public BigDecimal getR55_other1() {
		return r55_other1;
	}
	public void setR55_other1(BigDecimal r55_other1) {
		this.r55_other1 = r55_other1;
	}
	public BigDecimal getR55_banks2() {
		return r55_banks2;
	}
	public void setR55_banks2(BigDecimal r55_banks2) {
		this.r55_banks2 = r55_banks2;
	}
	public BigDecimal getR55_gov3() {
		return r55_gov3;
	}
	public void setR55_gov3(BigDecimal r55_gov3) {
		this.r55_gov3 = r55_gov3;
	}
	public BigDecimal getR55_others2() {
		return r55_others2;
	}
	public void setR55_others2(BigDecimal r55_others2) {
		this.r55_others2 = r55_others2;
	}
	public BigDecimal getR55_banks3() {
		return r55_banks3;
	}
	public void setR55_banks3(BigDecimal r55_banks3) {
		this.r55_banks3 = r55_banks3;
	}
	public BigDecimal getR55_gov4() {
		return r55_gov4;
	}
	public void setR55_gov4(BigDecimal r55_gov4) {
		this.r55_gov4 = r55_gov4;
	}
	public BigDecimal getR55_others3() {
		return r55_others3;
	}
	public void setR55_others3(BigDecimal r55_others3) {
		this.r55_others3 = r55_others3;
	}
	public BigDecimal getR55_foreign1() {
		return r55_foreign1;
	}
	public void setR55_foreign1(BigDecimal r55_foreign1) {
		this.r55_foreign1 = r55_foreign1;
	}
	public BigDecimal getR55_guarantees() {
		return r55_guarantees;
	}
	public void setR55_guarantees(BigDecimal r55_guarantees) {
		this.r55_guarantees = r55_guarantees;
	}
	public BigDecimal getR55_nbfi2() {
		return r55_nbfi2;
	}
	public void setR55_nbfi2(BigDecimal r55_nbfi2) {
		this.r55_nbfi2 = r55_nbfi2;
	}
	public BigDecimal getR55_interbank2() {
		return r55_interbank2;
	}
	public void setR55_interbank2(BigDecimal r55_interbank2) {
		this.r55_interbank2 = r55_interbank2;
	}
	public BigDecimal getR55_gov5() {
		return r55_gov5;
	}
	public void setR55_gov5(BigDecimal r55_gov5) {
		this.r55_gov5 = r55_gov5;
	}
	public BigDecimal getR55_corporate2() {
		return r55_corporate2;
	}
	public void setR55_corporate2(BigDecimal r55_corporate2) {
		this.r55_corporate2 = r55_corporate2;
	}
	public BigDecimal getR55_gre2() {
		return r55_gre2;
	}
	public void setR55_gre2(BigDecimal r55_gre2) {
		this.r55_gre2 = r55_gre2;
	}
	public BigDecimal getR55_individuals3() {
		return r55_individuals3;
	}
	public void setR55_individuals3(BigDecimal r55_individuals3) {
		this.r55_individuals3 = r55_individuals3;
	}
	public BigDecimal getR55_zero1() {
		return r55_zero1;
	}
	public void setR55_zero1(BigDecimal r55_zero1) {
		this.r55_zero1 = r55_zero1;
	}
	public BigDecimal getR55_three1() {
		return r55_three1;
	}
	public void setR55_three1(BigDecimal r55_three1) {
		this.r55_three1 = r55_three1;
	}
	public BigDecimal getR55_six1() {
		return r55_six1;
	}
	public void setR55_six1(BigDecimal r55_six1) {
		this.r55_six1 = r55_six1;
	}
	public BigDecimal getR55_oneyear1() {
		return r55_oneyear1;
	}
	public void setR55_oneyear1(BigDecimal r55_oneyear1) {
		this.r55_oneyear1 = r55_oneyear1;
	}
	public String getR55_empty() {
		return r55_empty;
	}
	public void setR55_empty(String r55_empty) {
		this.r55_empty = r55_empty;
	}
	public String getR56_product() {
		return r56_product;
	}
	public void setR56_product(String r56_product) {
		this.r56_product = r56_product;
	}
	public BigDecimal getR56_nbfi() {
		return r56_nbfi;
	}
	public void setR56_nbfi(BigDecimal r56_nbfi) {
		this.r56_nbfi = r56_nbfi;
	}
	public BigDecimal getR56_interbank() {
		return r56_interbank;
	}
	public void setR56_interbank(BigDecimal r56_interbank) {
		this.r56_interbank = r56_interbank;
	}
	public BigDecimal getR56_gov() {
		return r56_gov;
	}
	public void setR56_gov(BigDecimal r56_gov) {
		this.r56_gov = r56_gov;
	}
	public BigDecimal getR56_corporate() {
		return r56_corporate;
	}
	public void setR56_corporate(BigDecimal r56_corporate) {
		this.r56_corporate = r56_corporate;
	}
	public BigDecimal getR56_gre() {
		return r56_gre;
	}
	public void setR56_gre(BigDecimal r56_gre) {
		this.r56_gre = r56_gre;
	}
	public BigDecimal getR56_trade() {
		return r56_trade;
	}
	public void setR56_trade(BigDecimal r56_trade) {
		this.r56_trade = r56_trade;
	}
	public BigDecimal getR56_individuals() {
		return r56_individuals;
	}
	public void setR56_individuals(BigDecimal r56_individuals) {
		this.r56_individuals = r56_individuals;
	}
	public BigDecimal getR56_investment() {
		return r56_investment;
	}
	public void setR56_investment(BigDecimal r56_investment) {
		this.r56_investment = r56_investment;
	}
	public BigDecimal getR56_nbfi1() {
		return r56_nbfi1;
	}
	public void setR56_nbfi1(BigDecimal r56_nbfi1) {
		this.r56_nbfi1 = r56_nbfi1;
	}
	public BigDecimal getR56_interbank1() {
		return r56_interbank1;
	}
	public void setR56_interbank1(BigDecimal r56_interbank1) {
		this.r56_interbank1 = r56_interbank1;
	}
	public BigDecimal getR56_gov1() {
		return r56_gov1;
	}
	public void setR56_gov1(BigDecimal r56_gov1) {
		this.r56_gov1 = r56_gov1;
	}
	public BigDecimal getR56_corporate1() {
		return r56_corporate1;
	}
	public void setR56_corporate1(BigDecimal r56_corporate1) {
		this.r56_corporate1 = r56_corporate1;
	}
	public BigDecimal getR56_gre1() {
		return r56_gre1;
	}
	public void setR56_gre1(BigDecimal r56_gre1) {
		this.r56_gre1 = r56_gre1;
	}
	public BigDecimal getR56_trade1() {
		return r56_trade1;
	}
	public void setR56_trade1(BigDecimal r56_trade1) {
		this.r56_trade1 = r56_trade1;
	}
	public BigDecimal getR56_individuals1() {
		return r56_individuals1;
	}
	public void setR56_individuals1(BigDecimal r56_individuals1) {
		this.r56_individuals1 = r56_individuals1;
	}
	public BigDecimal getR56_investment1() {
		return r56_investment1;
	}
	public void setR56_investment1(BigDecimal r56_investment1) {
		this.r56_investment1 = r56_investment1;
	}
	public BigDecimal getR56_zer0() {
		return r56_zer0;
	}
	public void setR56_zer0(BigDecimal r56_zer0) {
		this.r56_zer0 = r56_zer0;
	}
	public BigDecimal getR56_three() {
		return r56_three;
	}
	public void setR56_three(BigDecimal r56_three) {
		this.r56_three = r56_three;
	}
	public BigDecimal getR56_six() {
		return r56_six;
	}
	public void setR56_six(BigDecimal r56_six) {
		this.r56_six = r56_six;
	}
	public BigDecimal getR56_oneyear() {
		return r56_oneyear;
	}
	public void setR56_oneyear(BigDecimal r56_oneyear) {
		this.r56_oneyear = r56_oneyear;
	}
	public BigDecimal getR56_foreign() {
		return r56_foreign;
	}
	public void setR56_foreign(BigDecimal r56_foreign) {
		this.r56_foreign = r56_foreign;
	}
	public BigDecimal getR56_banks() {
		return r56_banks;
	}
	public void setR56_banks(BigDecimal r56_banks) {
		this.r56_banks = r56_banks;
	}
	public BigDecimal getR56_gov2() {
		return r56_gov2;
	}
	public void setR56_gov2(BigDecimal r56_gov2) {
		this.r56_gov2 = r56_gov2;
	}
	public BigDecimal getR56_other() {
		return r56_other;
	}
	public void setR56_other(BigDecimal r56_other) {
		this.r56_other = r56_other;
	}
	public BigDecimal getR56_banks1() {
		return r56_banks1;
	}
	public void setR56_banks1(BigDecimal r56_banks1) {
		this.r56_banks1 = r56_banks1;
	}
	public BigDecimal getR56_individuals2() {
		return r56_individuals2;
	}
	public void setR56_individuals2(BigDecimal r56_individuals2) {
		this.r56_individuals2 = r56_individuals2;
	}
	public BigDecimal getR56_other1() {
		return r56_other1;
	}
	public void setR56_other1(BigDecimal r56_other1) {
		this.r56_other1 = r56_other1;
	}
	public BigDecimal getR56_banks2() {
		return r56_banks2;
	}
	public void setR56_banks2(BigDecimal r56_banks2) {
		this.r56_banks2 = r56_banks2;
	}
	public BigDecimal getR56_gov3() {
		return r56_gov3;
	}
	public void setR56_gov3(BigDecimal r56_gov3) {
		this.r56_gov3 = r56_gov3;
	}
	public BigDecimal getR56_others2() {
		return r56_others2;
	}
	public void setR56_others2(BigDecimal r56_others2) {
		this.r56_others2 = r56_others2;
	}
	public BigDecimal getR56_banks3() {
		return r56_banks3;
	}
	public void setR56_banks3(BigDecimal r56_banks3) {
		this.r56_banks3 = r56_banks3;
	}
	public BigDecimal getR56_gov4() {
		return r56_gov4;
	}
	public void setR56_gov4(BigDecimal r56_gov4) {
		this.r56_gov4 = r56_gov4;
	}
	public BigDecimal getR56_others3() {
		return r56_others3;
	}
	public void setR56_others3(BigDecimal r56_others3) {
		this.r56_others3 = r56_others3;
	}
	public BigDecimal getR56_foreign1() {
		return r56_foreign1;
	}
	public void setR56_foreign1(BigDecimal r56_foreign1) {
		this.r56_foreign1 = r56_foreign1;
	}
	public BigDecimal getR56_guarantees() {
		return r56_guarantees;
	}
	public void setR56_guarantees(BigDecimal r56_guarantees) {
		this.r56_guarantees = r56_guarantees;
	}
	public BigDecimal getR56_nbfi2() {
		return r56_nbfi2;
	}
	public void setR56_nbfi2(BigDecimal r56_nbfi2) {
		this.r56_nbfi2 = r56_nbfi2;
	}
	public BigDecimal getR56_interbank2() {
		return r56_interbank2;
	}
	public void setR56_interbank2(BigDecimal r56_interbank2) {
		this.r56_interbank2 = r56_interbank2;
	}
	public BigDecimal getR56_gov5() {
		return r56_gov5;
	}
	public void setR56_gov5(BigDecimal r56_gov5) {
		this.r56_gov5 = r56_gov5;
	}
	public BigDecimal getR56_corporate2() {
		return r56_corporate2;
	}
	public void setR56_corporate2(BigDecimal r56_corporate2) {
		this.r56_corporate2 = r56_corporate2;
	}
	public BigDecimal getR56_gre2() {
		return r56_gre2;
	}
	public void setR56_gre2(BigDecimal r56_gre2) {
		this.r56_gre2 = r56_gre2;
	}
	public BigDecimal getR56_individuals3() {
		return r56_individuals3;
	}
	public void setR56_individuals3(BigDecimal r56_individuals3) {
		this.r56_individuals3 = r56_individuals3;
	}
	public BigDecimal getR56_zero1() {
		return r56_zero1;
	}
	public void setR56_zero1(BigDecimal r56_zero1) {
		this.r56_zero1 = r56_zero1;
	}
	public BigDecimal getR56_three1() {
		return r56_three1;
	}
	public void setR56_three1(BigDecimal r56_three1) {
		this.r56_three1 = r56_three1;
	}
	public BigDecimal getR56_six1() {
		return r56_six1;
	}
	public void setR56_six1(BigDecimal r56_six1) {
		this.r56_six1 = r56_six1;
	}
	public BigDecimal getR56_oneyear1() {
		return r56_oneyear1;
	}
	public void setR56_oneyear1(BigDecimal r56_oneyear1) {
		this.r56_oneyear1 = r56_oneyear1;
	}
	public String getR56_empty() {
		return r56_empty;
	}
	public void setR56_empty(String r56_empty) {
		this.r56_empty = r56_empty;
	}
	public String getR57_product() {
		return r57_product;
	}
	public void setR57_product(String r57_product) {
		this.r57_product = r57_product;
	}
	public BigDecimal getR57_nbfi() {
		return r57_nbfi;
	}
	public void setR57_nbfi(BigDecimal r57_nbfi) {
		this.r57_nbfi = r57_nbfi;
	}
	public BigDecimal getR57_interbank() {
		return r57_interbank;
	}
	public void setR57_interbank(BigDecimal r57_interbank) {
		this.r57_interbank = r57_interbank;
	}
	public BigDecimal getR57_gov() {
		return r57_gov;
	}
	public void setR57_gov(BigDecimal r57_gov) {
		this.r57_gov = r57_gov;
	}
	public BigDecimal getR57_corporate() {
		return r57_corporate;
	}
	public void setR57_corporate(BigDecimal r57_corporate) {
		this.r57_corporate = r57_corporate;
	}
	public BigDecimal getR57_gre() {
		return r57_gre;
	}
	public void setR57_gre(BigDecimal r57_gre) {
		this.r57_gre = r57_gre;
	}
	public BigDecimal getR57_trade() {
		return r57_trade;
	}
	public void setR57_trade(BigDecimal r57_trade) {
		this.r57_trade = r57_trade;
	}
	public BigDecimal getR57_individuals() {
		return r57_individuals;
	}
	public void setR57_individuals(BigDecimal r57_individuals) {
		this.r57_individuals = r57_individuals;
	}
	public BigDecimal getR57_investment() {
		return r57_investment;
	}
	public void setR57_investment(BigDecimal r57_investment) {
		this.r57_investment = r57_investment;
	}
	public BigDecimal getR57_nbfi1() {
		return r57_nbfi1;
	}
	public void setR57_nbfi1(BigDecimal r57_nbfi1) {
		this.r57_nbfi1 = r57_nbfi1;
	}
	public BigDecimal getR57_interbank1() {
		return r57_interbank1;
	}
	public void setR57_interbank1(BigDecimal r57_interbank1) {
		this.r57_interbank1 = r57_interbank1;
	}
	public BigDecimal getR57_gov1() {
		return r57_gov1;
	}
	public void setR57_gov1(BigDecimal r57_gov1) {
		this.r57_gov1 = r57_gov1;
	}
	public BigDecimal getR57_corporate1() {
		return r57_corporate1;
	}
	public void setR57_corporate1(BigDecimal r57_corporate1) {
		this.r57_corporate1 = r57_corporate1;
	}
	public BigDecimal getR57_gre1() {
		return r57_gre1;
	}
	public void setR57_gre1(BigDecimal r57_gre1) {
		this.r57_gre1 = r57_gre1;
	}
	public BigDecimal getR57_trade1() {
		return r57_trade1;
	}
	public void setR57_trade1(BigDecimal r57_trade1) {
		this.r57_trade1 = r57_trade1;
	}
	public BigDecimal getR57_individuals1() {
		return r57_individuals1;
	}
	public void setR57_individuals1(BigDecimal r57_individuals1) {
		this.r57_individuals1 = r57_individuals1;
	}
	public BigDecimal getR57_investment1() {
		return r57_investment1;
	}
	public void setR57_investment1(BigDecimal r57_investment1) {
		this.r57_investment1 = r57_investment1;
	}
	public BigDecimal getR57_zer0() {
		return r57_zer0;
	}
	public void setR57_zer0(BigDecimal r57_zer0) {
		this.r57_zer0 = r57_zer0;
	}
	public BigDecimal getR57_three() {
		return r57_three;
	}
	public void setR57_three(BigDecimal r57_three) {
		this.r57_three = r57_three;
	}
	public BigDecimal getR57_six() {
		return r57_six;
	}
	public void setR57_six(BigDecimal r57_six) {
		this.r57_six = r57_six;
	}
	public BigDecimal getR57_oneyear() {
		return r57_oneyear;
	}
	public void setR57_oneyear(BigDecimal r57_oneyear) {
		this.r57_oneyear = r57_oneyear;
	}
	public BigDecimal getR57_foreign() {
		return r57_foreign;
	}
	public void setR57_foreign(BigDecimal r57_foreign) {
		this.r57_foreign = r57_foreign;
	}
	public BigDecimal getR57_banks() {
		return r57_banks;
	}
	public void setR57_banks(BigDecimal r57_banks) {
		this.r57_banks = r57_banks;
	}
	public BigDecimal getR57_gov2() {
		return r57_gov2;
	}
	public void setR57_gov2(BigDecimal r57_gov2) {
		this.r57_gov2 = r57_gov2;
	}
	public BigDecimal getR57_other() {
		return r57_other;
	}
	public void setR57_other(BigDecimal r57_other) {
		this.r57_other = r57_other;
	}
	public BigDecimal getR57_banks1() {
		return r57_banks1;
	}
	public void setR57_banks1(BigDecimal r57_banks1) {
		this.r57_banks1 = r57_banks1;
	}
	public BigDecimal getR57_individuals2() {
		return r57_individuals2;
	}
	public void setR57_individuals2(BigDecimal r57_individuals2) {
		this.r57_individuals2 = r57_individuals2;
	}
	public BigDecimal getR57_other1() {
		return r57_other1;
	}
	public void setR57_other1(BigDecimal r57_other1) {
		this.r57_other1 = r57_other1;
	}
	public BigDecimal getR57_banks2() {
		return r57_banks2;
	}
	public void setR57_banks2(BigDecimal r57_banks2) {
		this.r57_banks2 = r57_banks2;
	}
	public BigDecimal getR57_gov3() {
		return r57_gov3;
	}
	public void setR57_gov3(BigDecimal r57_gov3) {
		this.r57_gov3 = r57_gov3;
	}
	public BigDecimal getR57_others2() {
		return r57_others2;
	}
	public void setR57_others2(BigDecimal r57_others2) {
		this.r57_others2 = r57_others2;
	}
	public BigDecimal getR57_banks3() {
		return r57_banks3;
	}
	public void setR57_banks3(BigDecimal r57_banks3) {
		this.r57_banks3 = r57_banks3;
	}
	public BigDecimal getR57_gov4() {
		return r57_gov4;
	}
	public void setR57_gov4(BigDecimal r57_gov4) {
		this.r57_gov4 = r57_gov4;
	}
	public BigDecimal getR57_others3() {
		return r57_others3;
	}
	public void setR57_others3(BigDecimal r57_others3) {
		this.r57_others3 = r57_others3;
	}
	public BigDecimal getR57_foreign1() {
		return r57_foreign1;
	}
	public void setR57_foreign1(BigDecimal r57_foreign1) {
		this.r57_foreign1 = r57_foreign1;
	}
	public BigDecimal getR57_guarantees() {
		return r57_guarantees;
	}
	public void setR57_guarantees(BigDecimal r57_guarantees) {
		this.r57_guarantees = r57_guarantees;
	}
	public BigDecimal getR57_nbfi2() {
		return r57_nbfi2;
	}
	public void setR57_nbfi2(BigDecimal r57_nbfi2) {
		this.r57_nbfi2 = r57_nbfi2;
	}
	public BigDecimal getR57_interbank2() {
		return r57_interbank2;
	}
	public void setR57_interbank2(BigDecimal r57_interbank2) {
		this.r57_interbank2 = r57_interbank2;
	}
	public BigDecimal getR57_gov5() {
		return r57_gov5;
	}
	public void setR57_gov5(BigDecimal r57_gov5) {
		this.r57_gov5 = r57_gov5;
	}
	public BigDecimal getR57_corporate2() {
		return r57_corporate2;
	}
	public void setR57_corporate2(BigDecimal r57_corporate2) {
		this.r57_corporate2 = r57_corporate2;
	}
	public BigDecimal getR57_gre2() {
		return r57_gre2;
	}
	public void setR57_gre2(BigDecimal r57_gre2) {
		this.r57_gre2 = r57_gre2;
	}
	public BigDecimal getR57_individuals3() {
		return r57_individuals3;
	}
	public void setR57_individuals3(BigDecimal r57_individuals3) {
		this.r57_individuals3 = r57_individuals3;
	}
	public BigDecimal getR57_zero1() {
		return r57_zero1;
	}
	public void setR57_zero1(BigDecimal r57_zero1) {
		this.r57_zero1 = r57_zero1;
	}
	public BigDecimal getR57_three1() {
		return r57_three1;
	}
	public void setR57_three1(BigDecimal r57_three1) {
		this.r57_three1 = r57_three1;
	}
	public BigDecimal getR57_six1() {
		return r57_six1;
	}
	public void setR57_six1(BigDecimal r57_six1) {
		this.r57_six1 = r57_six1;
	}
	public BigDecimal getR57_oneyear1() {
		return r57_oneyear1;
	}
	public void setR57_oneyear1(BigDecimal r57_oneyear1) {
		this.r57_oneyear1 = r57_oneyear1;
	}
	public String getR57_empty() {
		return r57_empty;
	}
	public void setR57_empty(String r57_empty) {
		this.r57_empty = r57_empty;
	}
	public String getR58_product() {
		return r58_product;
	}
	public void setR58_product(String r58_product) {
		this.r58_product = r58_product;
	}
	public BigDecimal getR58_nbfi() {
		return r58_nbfi;
	}
	public void setR58_nbfi(BigDecimal r58_nbfi) {
		this.r58_nbfi = r58_nbfi;
	}
	public BigDecimal getR58_interbank() {
		return r58_interbank;
	}
	public void setR58_interbank(BigDecimal r58_interbank) {
		this.r58_interbank = r58_interbank;
	}
	public BigDecimal getR58_gov() {
		return r58_gov;
	}
	public void setR58_gov(BigDecimal r58_gov) {
		this.r58_gov = r58_gov;
	}
	public BigDecimal getR58_corporate() {
		return r58_corporate;
	}
	public void setR58_corporate(BigDecimal r58_corporate) {
		this.r58_corporate = r58_corporate;
	}
	public BigDecimal getR58_gre() {
		return r58_gre;
	}
	public void setR58_gre(BigDecimal r58_gre) {
		this.r58_gre = r58_gre;
	}
	public BigDecimal getR58_trade() {
		return r58_trade;
	}
	public void setR58_trade(BigDecimal r58_trade) {
		this.r58_trade = r58_trade;
	}
	public BigDecimal getR58_individuals() {
		return r58_individuals;
	}
	public void setR58_individuals(BigDecimal r58_individuals) {
		this.r58_individuals = r58_individuals;
	}
	public BigDecimal getR58_investment() {
		return r58_investment;
	}
	public void setR58_investment(BigDecimal r58_investment) {
		this.r58_investment = r58_investment;
	}
	public BigDecimal getR58_nbfi1() {
		return r58_nbfi1;
	}
	public void setR58_nbfi1(BigDecimal r58_nbfi1) {
		this.r58_nbfi1 = r58_nbfi1;
	}
	public BigDecimal getR58_interbank1() {
		return r58_interbank1;
	}
	public void setR58_interbank1(BigDecimal r58_interbank1) {
		this.r58_interbank1 = r58_interbank1;
	}
	public BigDecimal getR58_gov1() {
		return r58_gov1;
	}
	public void setR58_gov1(BigDecimal r58_gov1) {
		this.r58_gov1 = r58_gov1;
	}
	public BigDecimal getR58_corporate1() {
		return r58_corporate1;
	}
	public void setR58_corporate1(BigDecimal r58_corporate1) {
		this.r58_corporate1 = r58_corporate1;
	}
	public BigDecimal getR58_gre1() {
		return r58_gre1;
	}
	public void setR58_gre1(BigDecimal r58_gre1) {
		this.r58_gre1 = r58_gre1;
	}
	public BigDecimal getR58_trade1() {
		return r58_trade1;
	}
	public void setR58_trade1(BigDecimal r58_trade1) {
		this.r58_trade1 = r58_trade1;
	}
	public BigDecimal getR58_individuals1() {
		return r58_individuals1;
	}
	public void setR58_individuals1(BigDecimal r58_individuals1) {
		this.r58_individuals1 = r58_individuals1;
	}
	public BigDecimal getR58_investment1() {
		return r58_investment1;
	}
	public void setR58_investment1(BigDecimal r58_investment1) {
		this.r58_investment1 = r58_investment1;
	}
	public BigDecimal getR58_zer0() {
		return r58_zer0;
	}
	public void setR58_zer0(BigDecimal r58_zer0) {
		this.r58_zer0 = r58_zer0;
	}
	public BigDecimal getR58_three() {
		return r58_three;
	}
	public void setR58_three(BigDecimal r58_three) {
		this.r58_three = r58_three;
	}
	public BigDecimal getR58_six() {
		return r58_six;
	}
	public void setR58_six(BigDecimal r58_six) {
		this.r58_six = r58_six;
	}
	public BigDecimal getR58_oneyear() {
		return r58_oneyear;
	}
	public void setR58_oneyear(BigDecimal r58_oneyear) {
		this.r58_oneyear = r58_oneyear;
	}
	public BigDecimal getR58_foreign() {
		return r58_foreign;
	}
	public void setR58_foreign(BigDecimal r58_foreign) {
		this.r58_foreign = r58_foreign;
	}
	public BigDecimal getR58_banks() {
		return r58_banks;
	}
	public void setR58_banks(BigDecimal r58_banks) {
		this.r58_banks = r58_banks;
	}
	public BigDecimal getR58_gov2() {
		return r58_gov2;
	}
	public void setR58_gov2(BigDecimal r58_gov2) {
		this.r58_gov2 = r58_gov2;
	}
	public BigDecimal getR58_other() {
		return r58_other;
	}
	public void setR58_other(BigDecimal r58_other) {
		this.r58_other = r58_other;
	}
	public BigDecimal getR58_banks1() {
		return r58_banks1;
	}
	public void setR58_banks1(BigDecimal r58_banks1) {
		this.r58_banks1 = r58_banks1;
	}
	public BigDecimal getR58_individuals2() {
		return r58_individuals2;
	}
	public void setR58_individuals2(BigDecimal r58_individuals2) {
		this.r58_individuals2 = r58_individuals2;
	}
	public BigDecimal getR58_other1() {
		return r58_other1;
	}
	public void setR58_other1(BigDecimal r58_other1) {
		this.r58_other1 = r58_other1;
	}
	public BigDecimal getR58_banks2() {
		return r58_banks2;
	}
	public void setR58_banks2(BigDecimal r58_banks2) {
		this.r58_banks2 = r58_banks2;
	}
	public BigDecimal getR58_gov3() {
		return r58_gov3;
	}
	public void setR58_gov3(BigDecimal r58_gov3) {
		this.r58_gov3 = r58_gov3;
	}
	public BigDecimal getR58_others2() {
		return r58_others2;
	}
	public void setR58_others2(BigDecimal r58_others2) {
		this.r58_others2 = r58_others2;
	}
	public BigDecimal getR58_banks3() {
		return r58_banks3;
	}
	public void setR58_banks3(BigDecimal r58_banks3) {
		this.r58_banks3 = r58_banks3;
	}
	public BigDecimal getR58_gov4() {
		return r58_gov4;
	}
	public void setR58_gov4(BigDecimal r58_gov4) {
		this.r58_gov4 = r58_gov4;
	}
	public BigDecimal getR58_others3() {
		return r58_others3;
	}
	public void setR58_others3(BigDecimal r58_others3) {
		this.r58_others3 = r58_others3;
	}
	public BigDecimal getR58_foreign1() {
		return r58_foreign1;
	}
	public void setR58_foreign1(BigDecimal r58_foreign1) {
		this.r58_foreign1 = r58_foreign1;
	}
	public BigDecimal getR58_guarantees() {
		return r58_guarantees;
	}
	public void setR58_guarantees(BigDecimal r58_guarantees) {
		this.r58_guarantees = r58_guarantees;
	}
	public BigDecimal getR58_nbfi2() {
		return r58_nbfi2;
	}
	public void setR58_nbfi2(BigDecimal r58_nbfi2) {
		this.r58_nbfi2 = r58_nbfi2;
	}
	public BigDecimal getR58_interbank2() {
		return r58_interbank2;
	}
	public void setR58_interbank2(BigDecimal r58_interbank2) {
		this.r58_interbank2 = r58_interbank2;
	}
	public BigDecimal getR58_gov5() {
		return r58_gov5;
	}
	public void setR58_gov5(BigDecimal r58_gov5) {
		this.r58_gov5 = r58_gov5;
	}
	public BigDecimal getR58_corporate2() {
		return r58_corporate2;
	}
	public void setR58_corporate2(BigDecimal r58_corporate2) {
		this.r58_corporate2 = r58_corporate2;
	}
	public BigDecimal getR58_gre2() {
		return r58_gre2;
	}
	public void setR58_gre2(BigDecimal r58_gre2) {
		this.r58_gre2 = r58_gre2;
	}
	public BigDecimal getR58_individuals3() {
		return r58_individuals3;
	}
	public void setR58_individuals3(BigDecimal r58_individuals3) {
		this.r58_individuals3 = r58_individuals3;
	}
	public BigDecimal getR58_zero1() {
		return r58_zero1;
	}
	public void setR58_zero1(BigDecimal r58_zero1) {
		this.r58_zero1 = r58_zero1;
	}
	public BigDecimal getR58_three1() {
		return r58_three1;
	}
	public void setR58_three1(BigDecimal r58_three1) {
		this.r58_three1 = r58_three1;
	}
	public BigDecimal getR58_six1() {
		return r58_six1;
	}
	public void setR58_six1(BigDecimal r58_six1) {
		this.r58_six1 = r58_six1;
	}
	public BigDecimal getR58_oneyear1() {
		return r58_oneyear1;
	}
	public void setR58_oneyear1(BigDecimal r58_oneyear1) {
		this.r58_oneyear1 = r58_oneyear1;
	}
	public String getR58_empty() {
		return r58_empty;
	}
	public void setR58_empty(String r58_empty) {
		this.r58_empty = r58_empty;
	}
	public String getR59_product() {
		return r59_product;
	}
	public void setR59_product(String r59_product) {
		this.r59_product = r59_product;
	}
	public BigDecimal getR59_nbfi() {
		return r59_nbfi;
	}
	public void setR59_nbfi(BigDecimal r59_nbfi) {
		this.r59_nbfi = r59_nbfi;
	}
	public BigDecimal getR59_interbank() {
		return r59_interbank;
	}
	public void setR59_interbank(BigDecimal r59_interbank) {
		this.r59_interbank = r59_interbank;
	}
	public BigDecimal getR59_gov() {
		return r59_gov;
	}
	public void setR59_gov(BigDecimal r59_gov) {
		this.r59_gov = r59_gov;
	}
	public BigDecimal getR59_corporate() {
		return r59_corporate;
	}
	public void setR59_corporate(BigDecimal r59_corporate) {
		this.r59_corporate = r59_corporate;
	}
	public BigDecimal getR59_gre() {
		return r59_gre;
	}
	public void setR59_gre(BigDecimal r59_gre) {
		this.r59_gre = r59_gre;
	}
	public BigDecimal getR59_trade() {
		return r59_trade;
	}
	public void setR59_trade(BigDecimal r59_trade) {
		this.r59_trade = r59_trade;
	}
	public BigDecimal getR59_individuals() {
		return r59_individuals;
	}
	public void setR59_individuals(BigDecimal r59_individuals) {
		this.r59_individuals = r59_individuals;
	}
	public BigDecimal getR59_investment() {
		return r59_investment;
	}
	public void setR59_investment(BigDecimal r59_investment) {
		this.r59_investment = r59_investment;
	}
	public BigDecimal getR59_nbfi1() {
		return r59_nbfi1;
	}
	public void setR59_nbfi1(BigDecimal r59_nbfi1) {
		this.r59_nbfi1 = r59_nbfi1;
	}
	public BigDecimal getR59_interbank1() {
		return r59_interbank1;
	}
	public void setR59_interbank1(BigDecimal r59_interbank1) {
		this.r59_interbank1 = r59_interbank1;
	}
	public BigDecimal getR59_gov1() {
		return r59_gov1;
	}
	public void setR59_gov1(BigDecimal r59_gov1) {
		this.r59_gov1 = r59_gov1;
	}
	public BigDecimal getR59_corporate1() {
		return r59_corporate1;
	}
	public void setR59_corporate1(BigDecimal r59_corporate1) {
		this.r59_corporate1 = r59_corporate1;
	}
	public BigDecimal getR59_gre1() {
		return r59_gre1;
	}
	public void setR59_gre1(BigDecimal r59_gre1) {
		this.r59_gre1 = r59_gre1;
	}
	public BigDecimal getR59_trade1() {
		return r59_trade1;
	}
	public void setR59_trade1(BigDecimal r59_trade1) {
		this.r59_trade1 = r59_trade1;
	}
	public BigDecimal getR59_individuals1() {
		return r59_individuals1;
	}
	public void setR59_individuals1(BigDecimal r59_individuals1) {
		this.r59_individuals1 = r59_individuals1;
	}
	public BigDecimal getR59_investment1() {
		return r59_investment1;
	}
	public void setR59_investment1(BigDecimal r59_investment1) {
		this.r59_investment1 = r59_investment1;
	}
	public BigDecimal getR59_zer0() {
		return r59_zer0;
	}
	public void setR59_zer0(BigDecimal r59_zer0) {
		this.r59_zer0 = r59_zer0;
	}
	public BigDecimal getR59_three() {
		return r59_three;
	}
	public void setR59_three(BigDecimal r59_three) {
		this.r59_three = r59_three;
	}
	public BigDecimal getR59_six() {
		return r59_six;
	}
	public void setR59_six(BigDecimal r59_six) {
		this.r59_six = r59_six;
	}
	public BigDecimal getR59_oneyear() {
		return r59_oneyear;
	}
	public void setR59_oneyear(BigDecimal r59_oneyear) {
		this.r59_oneyear = r59_oneyear;
	}
	public BigDecimal getR59_foreign() {
		return r59_foreign;
	}
	public void setR59_foreign(BigDecimal r59_foreign) {
		this.r59_foreign = r59_foreign;
	}
	public BigDecimal getR59_banks() {
		return r59_banks;
	}
	public void setR59_banks(BigDecimal r59_banks) {
		this.r59_banks = r59_banks;
	}
	public BigDecimal getR59_gov2() {
		return r59_gov2;
	}
	public void setR59_gov2(BigDecimal r59_gov2) {
		this.r59_gov2 = r59_gov2;
	}
	public BigDecimal getR59_other() {
		return r59_other;
	}
	public void setR59_other(BigDecimal r59_other) {
		this.r59_other = r59_other;
	}
	public BigDecimal getR59_banks1() {
		return r59_banks1;
	}
	public void setR59_banks1(BigDecimal r59_banks1) {
		this.r59_banks1 = r59_banks1;
	}
	public BigDecimal getR59_individuals2() {
		return r59_individuals2;
	}
	public void setR59_individuals2(BigDecimal r59_individuals2) {
		this.r59_individuals2 = r59_individuals2;
	}
	public BigDecimal getR59_other1() {
		return r59_other1;
	}
	public void setR59_other1(BigDecimal r59_other1) {
		this.r59_other1 = r59_other1;
	}
	public BigDecimal getR59_banks2() {
		return r59_banks2;
	}
	public void setR59_banks2(BigDecimal r59_banks2) {
		this.r59_banks2 = r59_banks2;
	}
	public BigDecimal getR59_gov3() {
		return r59_gov3;
	}
	public void setR59_gov3(BigDecimal r59_gov3) {
		this.r59_gov3 = r59_gov3;
	}
	public BigDecimal getR59_others2() {
		return r59_others2;
	}
	public void setR59_others2(BigDecimal r59_others2) {
		this.r59_others2 = r59_others2;
	}
	public BigDecimal getR59_banks3() {
		return r59_banks3;
	}
	public void setR59_banks3(BigDecimal r59_banks3) {
		this.r59_banks3 = r59_banks3;
	}
	public BigDecimal getR59_gov4() {
		return r59_gov4;
	}
	public void setR59_gov4(BigDecimal r59_gov4) {
		this.r59_gov4 = r59_gov4;
	}
	public BigDecimal getR59_others3() {
		return r59_others3;
	}
	public void setR59_others3(BigDecimal r59_others3) {
		this.r59_others3 = r59_others3;
	}
	public BigDecimal getR59_foreign1() {
		return r59_foreign1;
	}
	public void setR59_foreign1(BigDecimal r59_foreign1) {
		this.r59_foreign1 = r59_foreign1;
	}
	public BigDecimal getR59_guarantees() {
		return r59_guarantees;
	}
	public void setR59_guarantees(BigDecimal r59_guarantees) {
		this.r59_guarantees = r59_guarantees;
	}
	public BigDecimal getR59_nbfi2() {
		return r59_nbfi2;
	}
	public void setR59_nbfi2(BigDecimal r59_nbfi2) {
		this.r59_nbfi2 = r59_nbfi2;
	}
	public BigDecimal getR59_interbank2() {
		return r59_interbank2;
	}
	public void setR59_interbank2(BigDecimal r59_interbank2) {
		this.r59_interbank2 = r59_interbank2;
	}
	public BigDecimal getR59_gov5() {
		return r59_gov5;
	}
	public void setR59_gov5(BigDecimal r59_gov5) {
		this.r59_gov5 = r59_gov5;
	}
	public BigDecimal getR59_corporate2() {
		return r59_corporate2;
	}
	public void setR59_corporate2(BigDecimal r59_corporate2) {
		this.r59_corporate2 = r59_corporate2;
	}
	public BigDecimal getR59_gre2() {
		return r59_gre2;
	}
	public void setR59_gre2(BigDecimal r59_gre2) {
		this.r59_gre2 = r59_gre2;
	}
	public BigDecimal getR59_individuals3() {
		return r59_individuals3;
	}
	public void setR59_individuals3(BigDecimal r59_individuals3) {
		this.r59_individuals3 = r59_individuals3;
	}
	public BigDecimal getR59_zero1() {
		return r59_zero1;
	}
	public void setR59_zero1(BigDecimal r59_zero1) {
		this.r59_zero1 = r59_zero1;
	}
	public BigDecimal getR59_three1() {
		return r59_three1;
	}
	public void setR59_three1(BigDecimal r59_three1) {
		this.r59_three1 = r59_three1;
	}
	public BigDecimal getR59_six1() {
		return r59_six1;
	}
	public void setR59_six1(BigDecimal r59_six1) {
		this.r59_six1 = r59_six1;
	}
	public BigDecimal getR59_oneyear1() {
		return r59_oneyear1;
	}
	public void setR59_oneyear1(BigDecimal r59_oneyear1) {
		this.r59_oneyear1 = r59_oneyear1;
	}
	public String getR59_empty() {
		return r59_empty;
	}
	public void setR59_empty(String r59_empty) {
		this.r59_empty = r59_empty;
	}
	public String getR60_product() {
		return r60_product;
	}
	public void setR60_product(String r60_product) {
		this.r60_product = r60_product;
	}
	public BigDecimal getR60_nbfi() {
		return r60_nbfi;
	}
	public void setR60_nbfi(BigDecimal r60_nbfi) {
		this.r60_nbfi = r60_nbfi;
	}
	public BigDecimal getR60_interbank() {
		return r60_interbank;
	}
	public void setR60_interbank(BigDecimal r60_interbank) {
		this.r60_interbank = r60_interbank;
	}
	public BigDecimal getR60_gov() {
		return r60_gov;
	}
	public void setR60_gov(BigDecimal r60_gov) {
		this.r60_gov = r60_gov;
	}
	public BigDecimal getR60_corporate() {
		return r60_corporate;
	}
	public void setR60_corporate(BigDecimal r60_corporate) {
		this.r60_corporate = r60_corporate;
	}
	public BigDecimal getR60_gre() {
		return r60_gre;
	}
	public void setR60_gre(BigDecimal r60_gre) {
		this.r60_gre = r60_gre;
	}
	public BigDecimal getR60_trade() {
		return r60_trade;
	}
	public void setR60_trade(BigDecimal r60_trade) {
		this.r60_trade = r60_trade;
	}
	public BigDecimal getR60_individuals() {
		return r60_individuals;
	}
	public void setR60_individuals(BigDecimal r60_individuals) {
		this.r60_individuals = r60_individuals;
	}
	public BigDecimal getR60_investment() {
		return r60_investment;
	}
	public void setR60_investment(BigDecimal r60_investment) {
		this.r60_investment = r60_investment;
	}
	public BigDecimal getR60_nbfi1() {
		return r60_nbfi1;
	}
	public void setR60_nbfi1(BigDecimal r60_nbfi1) {
		this.r60_nbfi1 = r60_nbfi1;
	}
	public BigDecimal getR60_interbank1() {
		return r60_interbank1;
	}
	public void setR60_interbank1(BigDecimal r60_interbank1) {
		this.r60_interbank1 = r60_interbank1;
	}
	public BigDecimal getR60_gov1() {
		return r60_gov1;
	}
	public void setR60_gov1(BigDecimal r60_gov1) {
		this.r60_gov1 = r60_gov1;
	}
	public BigDecimal getR60_corporate1() {
		return r60_corporate1;
	}
	public void setR60_corporate1(BigDecimal r60_corporate1) {
		this.r60_corporate1 = r60_corporate1;
	}
	public BigDecimal getR60_gre1() {
		return r60_gre1;
	}
	public void setR60_gre1(BigDecimal r60_gre1) {
		this.r60_gre1 = r60_gre1;
	}
	public BigDecimal getR60_trade1() {
		return r60_trade1;
	}
	public void setR60_trade1(BigDecimal r60_trade1) {
		this.r60_trade1 = r60_trade1;
	}
	public BigDecimal getR60_individuals1() {
		return r60_individuals1;
	}
	public void setR60_individuals1(BigDecimal r60_individuals1) {
		this.r60_individuals1 = r60_individuals1;
	}
	public BigDecimal getR60_investment1() {
		return r60_investment1;
	}
	public void setR60_investment1(BigDecimal r60_investment1) {
		this.r60_investment1 = r60_investment1;
	}
	public BigDecimal getR60_zer0() {
		return r60_zer0;
	}
	public void setR60_zer0(BigDecimal r60_zer0) {
		this.r60_zer0 = r60_zer0;
	}
	public BigDecimal getR60_three() {
		return r60_three;
	}
	public void setR60_three(BigDecimal r60_three) {
		this.r60_three = r60_three;
	}
	public BigDecimal getR60_six() {
		return r60_six;
	}
	public void setR60_six(BigDecimal r60_six) {
		this.r60_six = r60_six;
	}
	public BigDecimal getR60_oneyear() {
		return r60_oneyear;
	}
	public void setR60_oneyear(BigDecimal r60_oneyear) {
		this.r60_oneyear = r60_oneyear;
	}
	public BigDecimal getR60_foreign() {
		return r60_foreign;
	}
	public void setR60_foreign(BigDecimal r60_foreign) {
		this.r60_foreign = r60_foreign;
	}
	public BigDecimal getR60_banks() {
		return r60_banks;
	}
	public void setR60_banks(BigDecimal r60_banks) {
		this.r60_banks = r60_banks;
	}
	public BigDecimal getR60_gov2() {
		return r60_gov2;
	}
	public void setR60_gov2(BigDecimal r60_gov2) {
		this.r60_gov2 = r60_gov2;
	}
	public BigDecimal getR60_other() {
		return r60_other;
	}
	public void setR60_other(BigDecimal r60_other) {
		this.r60_other = r60_other;
	}
	public BigDecimal getR60_banks1() {
		return r60_banks1;
	}
	public void setR60_banks1(BigDecimal r60_banks1) {
		this.r60_banks1 = r60_banks1;
	}
	public BigDecimal getR60_individuals2() {
		return r60_individuals2;
	}
	public void setR60_individuals2(BigDecimal r60_individuals2) {
		this.r60_individuals2 = r60_individuals2;
	}
	public BigDecimal getR60_other1() {
		return r60_other1;
	}
	public void setR60_other1(BigDecimal r60_other1) {
		this.r60_other1 = r60_other1;
	}
	public BigDecimal getR60_banks2() {
		return r60_banks2;
	}
	public void setR60_banks2(BigDecimal r60_banks2) {
		this.r60_banks2 = r60_banks2;
	}
	public BigDecimal getR60_gov3() {
		return r60_gov3;
	}
	public void setR60_gov3(BigDecimal r60_gov3) {
		this.r60_gov3 = r60_gov3;
	}
	public BigDecimal getR60_others2() {
		return r60_others2;
	}
	public void setR60_others2(BigDecimal r60_others2) {
		this.r60_others2 = r60_others2;
	}
	public BigDecimal getR60_banks3() {
		return r60_banks3;
	}
	public void setR60_banks3(BigDecimal r60_banks3) {
		this.r60_banks3 = r60_banks3;
	}
	public BigDecimal getR60_gov4() {
		return r60_gov4;
	}
	public void setR60_gov4(BigDecimal r60_gov4) {
		this.r60_gov4 = r60_gov4;
	}
	public BigDecimal getR60_others3() {
		return r60_others3;
	}
	public void setR60_others3(BigDecimal r60_others3) {
		this.r60_others3 = r60_others3;
	}
	public BigDecimal getR60_foreign1() {
		return r60_foreign1;
	}
	public void setR60_foreign1(BigDecimal r60_foreign1) {
		this.r60_foreign1 = r60_foreign1;
	}
	public BigDecimal getR60_guarantees() {
		return r60_guarantees;
	}
	public void setR60_guarantees(BigDecimal r60_guarantees) {
		this.r60_guarantees = r60_guarantees;
	}
	public BigDecimal getR60_nbfi2() {
		return r60_nbfi2;
	}
	public void setR60_nbfi2(BigDecimal r60_nbfi2) {
		this.r60_nbfi2 = r60_nbfi2;
	}
	public BigDecimal getR60_interbank2() {
		return r60_interbank2;
	}
	public void setR60_interbank2(BigDecimal r60_interbank2) {
		this.r60_interbank2 = r60_interbank2;
	}
	public BigDecimal getR60_gov5() {
		return r60_gov5;
	}
	public void setR60_gov5(BigDecimal r60_gov5) {
		this.r60_gov5 = r60_gov5;
	}
	public BigDecimal getR60_corporate2() {
		return r60_corporate2;
	}
	public void setR60_corporate2(BigDecimal r60_corporate2) {
		this.r60_corporate2 = r60_corporate2;
	}
	public BigDecimal getR60_gre2() {
		return r60_gre2;
	}
	public void setR60_gre2(BigDecimal r60_gre2) {
		this.r60_gre2 = r60_gre2;
	}
	public BigDecimal getR60_individuals3() {
		return r60_individuals3;
	}
	public void setR60_individuals3(BigDecimal r60_individuals3) {
		this.r60_individuals3 = r60_individuals3;
	}
	public BigDecimal getR60_zero1() {
		return r60_zero1;
	}
	public void setR60_zero1(BigDecimal r60_zero1) {
		this.r60_zero1 = r60_zero1;
	}
	public BigDecimal getR60_three1() {
		return r60_three1;
	}
	public void setR60_three1(BigDecimal r60_three1) {
		this.r60_three1 = r60_three1;
	}
	public BigDecimal getR60_six1() {
		return r60_six1;
	}
	public void setR60_six1(BigDecimal r60_six1) {
		this.r60_six1 = r60_six1;
	}
	public BigDecimal getR60_oneyear1() {
		return r60_oneyear1;
	}
	public void setR60_oneyear1(BigDecimal r60_oneyear1) {
		this.r60_oneyear1 = r60_oneyear1;
	}
	public String getR60_empty() {
		return r60_empty;
	}
	public void setR60_empty(String r60_empty) {
		this.r60_empty = r60_empty;
	}
	public String getR61_product() {
		return r61_product;
	}
	public void setR61_product(String r61_product) {
		this.r61_product = r61_product;
	}
	public BigDecimal getR61_nbfi() {
		return r61_nbfi;
	}
	public void setR61_nbfi(BigDecimal r61_nbfi) {
		this.r61_nbfi = r61_nbfi;
	}
	public BigDecimal getR61_interbank() {
		return r61_interbank;
	}
	public void setR61_interbank(BigDecimal r61_interbank) {
		this.r61_interbank = r61_interbank;
	}
	public BigDecimal getR61_gov() {
		return r61_gov;
	}
	public void setR61_gov(BigDecimal r61_gov) {
		this.r61_gov = r61_gov;
	}
	public BigDecimal getR61_corporate() {
		return r61_corporate;
	}
	public void setR61_corporate(BigDecimal r61_corporate) {
		this.r61_corporate = r61_corporate;
	}
	public BigDecimal getR61_gre() {
		return r61_gre;
	}
	public void setR61_gre(BigDecimal r61_gre) {
		this.r61_gre = r61_gre;
	}
	public BigDecimal getR61_trade() {
		return r61_trade;
	}
	public void setR61_trade(BigDecimal r61_trade) {
		this.r61_trade = r61_trade;
	}
	public BigDecimal getR61_individuals() {
		return r61_individuals;
	}
	public void setR61_individuals(BigDecimal r61_individuals) {
		this.r61_individuals = r61_individuals;
	}
	public BigDecimal getR61_investment() {
		return r61_investment;
	}
	public void setR61_investment(BigDecimal r61_investment) {
		this.r61_investment = r61_investment;
	}
	public BigDecimal getR61_nbfi1() {
		return r61_nbfi1;
	}
	public void setR61_nbfi1(BigDecimal r61_nbfi1) {
		this.r61_nbfi1 = r61_nbfi1;
	}
	public BigDecimal getR61_interbank1() {
		return r61_interbank1;
	}
	public void setR61_interbank1(BigDecimal r61_interbank1) {
		this.r61_interbank1 = r61_interbank1;
	}
	public BigDecimal getR61_gov1() {
		return r61_gov1;
	}
	public void setR61_gov1(BigDecimal r61_gov1) {
		this.r61_gov1 = r61_gov1;
	}
	public BigDecimal getR61_corporate1() {
		return r61_corporate1;
	}
	public void setR61_corporate1(BigDecimal r61_corporate1) {
		this.r61_corporate1 = r61_corporate1;
	}
	public BigDecimal getR61_gre1() {
		return r61_gre1;
	}
	public void setR61_gre1(BigDecimal r61_gre1) {
		this.r61_gre1 = r61_gre1;
	}
	public BigDecimal getR61_trade1() {
		return r61_trade1;
	}
	public void setR61_trade1(BigDecimal r61_trade1) {
		this.r61_trade1 = r61_trade1;
	}
	public BigDecimal getR61_individuals1() {
		return r61_individuals1;
	}
	public void setR61_individuals1(BigDecimal r61_individuals1) {
		this.r61_individuals1 = r61_individuals1;
	}
	public BigDecimal getR61_investment1() {
		return r61_investment1;
	}
	public void setR61_investment1(BigDecimal r61_investment1) {
		this.r61_investment1 = r61_investment1;
	}
	public BigDecimal getR61_zer0() {
		return r61_zer0;
	}
	public void setR61_zer0(BigDecimal r61_zer0) {
		this.r61_zer0 = r61_zer0;
	}
	public BigDecimal getR61_three() {
		return r61_three;
	}
	public void setR61_three(BigDecimal r61_three) {
		this.r61_three = r61_three;
	}
	public BigDecimal getR61_six() {
		return r61_six;
	}
	public void setR61_six(BigDecimal r61_six) {
		this.r61_six = r61_six;
	}
	public BigDecimal getR61_oneyear() {
		return r61_oneyear;
	}
	public void setR61_oneyear(BigDecimal r61_oneyear) {
		this.r61_oneyear = r61_oneyear;
	}
	public BigDecimal getR61_foreign() {
		return r61_foreign;
	}
	public void setR61_foreign(BigDecimal r61_foreign) {
		this.r61_foreign = r61_foreign;
	}
	public BigDecimal getR61_banks() {
		return r61_banks;
	}
	public void setR61_banks(BigDecimal r61_banks) {
		this.r61_banks = r61_banks;
	}
	public BigDecimal getR61_gov2() {
		return r61_gov2;
	}
	public void setR61_gov2(BigDecimal r61_gov2) {
		this.r61_gov2 = r61_gov2;
	}
	public BigDecimal getR61_other() {
		return r61_other;
	}
	public void setR61_other(BigDecimal r61_other) {
		this.r61_other = r61_other;
	}
	public BigDecimal getR61_banks1() {
		return r61_banks1;
	}
	public void setR61_banks1(BigDecimal r61_banks1) {
		this.r61_banks1 = r61_banks1;
	}
	public BigDecimal getR61_individuals2() {
		return r61_individuals2;
	}
	public void setR61_individuals2(BigDecimal r61_individuals2) {
		this.r61_individuals2 = r61_individuals2;
	}
	public BigDecimal getR61_other1() {
		return r61_other1;
	}
	public void setR61_other1(BigDecimal r61_other1) {
		this.r61_other1 = r61_other1;
	}
	public BigDecimal getR61_banks2() {
		return r61_banks2;
	}
	public void setR61_banks2(BigDecimal r61_banks2) {
		this.r61_banks2 = r61_banks2;
	}
	public BigDecimal getR61_gov3() {
		return r61_gov3;
	}
	public void setR61_gov3(BigDecimal r61_gov3) {
		this.r61_gov3 = r61_gov3;
	}
	public BigDecimal getR61_others2() {
		return r61_others2;
	}
	public void setR61_others2(BigDecimal r61_others2) {
		this.r61_others2 = r61_others2;
	}
	public BigDecimal getR61_banks3() {
		return r61_banks3;
	}
	public void setR61_banks3(BigDecimal r61_banks3) {
		this.r61_banks3 = r61_banks3;
	}
	public BigDecimal getR61_gov4() {
		return r61_gov4;
	}
	public void setR61_gov4(BigDecimal r61_gov4) {
		this.r61_gov4 = r61_gov4;
	}
	public BigDecimal getR61_others3() {
		return r61_others3;
	}
	public void setR61_others3(BigDecimal r61_others3) {
		this.r61_others3 = r61_others3;
	}
	public BigDecimal getR61_foreign1() {
		return r61_foreign1;
	}
	public void setR61_foreign1(BigDecimal r61_foreign1) {
		this.r61_foreign1 = r61_foreign1;
	}
	public BigDecimal getR61_guarantees() {
		return r61_guarantees;
	}
	public void setR61_guarantees(BigDecimal r61_guarantees) {
		this.r61_guarantees = r61_guarantees;
	}
	public BigDecimal getR61_nbfi2() {
		return r61_nbfi2;
	}
	public void setR61_nbfi2(BigDecimal r61_nbfi2) {
		this.r61_nbfi2 = r61_nbfi2;
	}
	public BigDecimal getR61_interbank2() {
		return r61_interbank2;
	}
	public void setR61_interbank2(BigDecimal r61_interbank2) {
		this.r61_interbank2 = r61_interbank2;
	}
	public BigDecimal getR61_gov5() {
		return r61_gov5;
	}
	public void setR61_gov5(BigDecimal r61_gov5) {
		this.r61_gov5 = r61_gov5;
	}
	public BigDecimal getR61_corporate2() {
		return r61_corporate2;
	}
	public void setR61_corporate2(BigDecimal r61_corporate2) {
		this.r61_corporate2 = r61_corporate2;
	}
	public BigDecimal getR61_gre2() {
		return r61_gre2;
	}
	public void setR61_gre2(BigDecimal r61_gre2) {
		this.r61_gre2 = r61_gre2;
	}
	public BigDecimal getR61_individuals3() {
		return r61_individuals3;
	}
	public void setR61_individuals3(BigDecimal r61_individuals3) {
		this.r61_individuals3 = r61_individuals3;
	}
	public BigDecimal getR61_zero1() {
		return r61_zero1;
	}
	public void setR61_zero1(BigDecimal r61_zero1) {
		this.r61_zero1 = r61_zero1;
	}
	public BigDecimal getR61_three1() {
		return r61_three1;
	}
	public void setR61_three1(BigDecimal r61_three1) {
		this.r61_three1 = r61_three1;
	}
	public BigDecimal getR61_six1() {
		return r61_six1;
	}
	public void setR61_six1(BigDecimal r61_six1) {
		this.r61_six1 = r61_six1;
	}
	public BigDecimal getR61_oneyear1() {
		return r61_oneyear1;
	}
	public void setR61_oneyear1(BigDecimal r61_oneyear1) {
		this.r61_oneyear1 = r61_oneyear1;
	}
	public String getR61_empty() {
		return r61_empty;
	}
	public void setR61_empty(String r61_empty) {
		this.r61_empty = r61_empty;
	}
	public String getR62_product() {
		return r62_product;
	}
	public void setR62_product(String r62_product) {
		this.r62_product = r62_product;
	}
	public BigDecimal getR62_nbfi() {
		return r62_nbfi;
	}
	public void setR62_nbfi(BigDecimal r62_nbfi) {
		this.r62_nbfi = r62_nbfi;
	}
	public BigDecimal getR62_interbank() {
		return r62_interbank;
	}
	public void setR62_interbank(BigDecimal r62_interbank) {
		this.r62_interbank = r62_interbank;
	}
	public BigDecimal getR62_gov() {
		return r62_gov;
	}
	public void setR62_gov(BigDecimal r62_gov) {
		this.r62_gov = r62_gov;
	}
	public BigDecimal getR62_corporate() {
		return r62_corporate;
	}
	public void setR62_corporate(BigDecimal r62_corporate) {
		this.r62_corporate = r62_corporate;
	}
	public BigDecimal getR62_gre() {
		return r62_gre;
	}
	public void setR62_gre(BigDecimal r62_gre) {
		this.r62_gre = r62_gre;
	}
	public BigDecimal getR62_trade() {
		return r62_trade;
	}
	public void setR62_trade(BigDecimal r62_trade) {
		this.r62_trade = r62_trade;
	}
	public BigDecimal getR62_individuals() {
		return r62_individuals;
	}
	public void setR62_individuals(BigDecimal r62_individuals) {
		this.r62_individuals = r62_individuals;
	}
	public BigDecimal getR62_investment() {
		return r62_investment;
	}
	public void setR62_investment(BigDecimal r62_investment) {
		this.r62_investment = r62_investment;
	}
	public BigDecimal getR62_nbfi1() {
		return r62_nbfi1;
	}
	public void setR62_nbfi1(BigDecimal r62_nbfi1) {
		this.r62_nbfi1 = r62_nbfi1;
	}
	public BigDecimal getR62_interbank1() {
		return r62_interbank1;
	}
	public void setR62_interbank1(BigDecimal r62_interbank1) {
		this.r62_interbank1 = r62_interbank1;
	}
	public BigDecimal getR62_gov1() {
		return r62_gov1;
	}
	public void setR62_gov1(BigDecimal r62_gov1) {
		this.r62_gov1 = r62_gov1;
	}
	public BigDecimal getR62_corporate1() {
		return r62_corporate1;
	}
	public void setR62_corporate1(BigDecimal r62_corporate1) {
		this.r62_corporate1 = r62_corporate1;
	}
	public BigDecimal getR62_gre1() {
		return r62_gre1;
	}
	public void setR62_gre1(BigDecimal r62_gre1) {
		this.r62_gre1 = r62_gre1;
	}
	public BigDecimal getR62_trade1() {
		return r62_trade1;
	}
	public void setR62_trade1(BigDecimal r62_trade1) {
		this.r62_trade1 = r62_trade1;
	}
	public BigDecimal getR62_individuals1() {
		return r62_individuals1;
	}
	public void setR62_individuals1(BigDecimal r62_individuals1) {
		this.r62_individuals1 = r62_individuals1;
	}
	public BigDecimal getR62_investment1() {
		return r62_investment1;
	}
	public void setR62_investment1(BigDecimal r62_investment1) {
		this.r62_investment1 = r62_investment1;
	}
	public BigDecimal getR62_zer0() {
		return r62_zer0;
	}
	public void setR62_zer0(BigDecimal r62_zer0) {
		this.r62_zer0 = r62_zer0;
	}
	public BigDecimal getR62_three() {
		return r62_three;
	}
	public void setR62_three(BigDecimal r62_three) {
		this.r62_three = r62_three;
	}
	public BigDecimal getR62_six() {
		return r62_six;
	}
	public void setR62_six(BigDecimal r62_six) {
		this.r62_six = r62_six;
	}
	public BigDecimal getR62_oneyear() {
		return r62_oneyear;
	}
	public void setR62_oneyear(BigDecimal r62_oneyear) {
		this.r62_oneyear = r62_oneyear;
	}
	public BigDecimal getR62_foreign() {
		return r62_foreign;
	}
	public void setR62_foreign(BigDecimal r62_foreign) {
		this.r62_foreign = r62_foreign;
	}
	public BigDecimal getR62_banks() {
		return r62_banks;
	}
	public void setR62_banks(BigDecimal r62_banks) {
		this.r62_banks = r62_banks;
	}
	public BigDecimal getR62_gov2() {
		return r62_gov2;
	}
	public void setR62_gov2(BigDecimal r62_gov2) {
		this.r62_gov2 = r62_gov2;
	}
	public BigDecimal getR62_other() {
		return r62_other;
	}
	public void setR62_other(BigDecimal r62_other) {
		this.r62_other = r62_other;
	}
	public BigDecimal getR62_banks1() {
		return r62_banks1;
	}
	public void setR62_banks1(BigDecimal r62_banks1) {
		this.r62_banks1 = r62_banks1;
	}
	public BigDecimal getR62_individuals2() {
		return r62_individuals2;
	}
	public void setR62_individuals2(BigDecimal r62_individuals2) {
		this.r62_individuals2 = r62_individuals2;
	}
	public BigDecimal getR62_other1() {
		return r62_other1;
	}
	public void setR62_other1(BigDecimal r62_other1) {
		this.r62_other1 = r62_other1;
	}
	public BigDecimal getR62_banks2() {
		return r62_banks2;
	}
	public void setR62_banks2(BigDecimal r62_banks2) {
		this.r62_banks2 = r62_banks2;
	}
	public BigDecimal getR62_gov3() {
		return r62_gov3;
	}
	public void setR62_gov3(BigDecimal r62_gov3) {
		this.r62_gov3 = r62_gov3;
	}
	public BigDecimal getR62_others2() {
		return r62_others2;
	}
	public void setR62_others2(BigDecimal r62_others2) {
		this.r62_others2 = r62_others2;
	}
	public BigDecimal getR62_banks3() {
		return r62_banks3;
	}
	public void setR62_banks3(BigDecimal r62_banks3) {
		this.r62_banks3 = r62_banks3;
	}
	public BigDecimal getR62_gov4() {
		return r62_gov4;
	}
	public void setR62_gov4(BigDecimal r62_gov4) {
		this.r62_gov4 = r62_gov4;
	}
	public BigDecimal getR62_others3() {
		return r62_others3;
	}
	public void setR62_others3(BigDecimal r62_others3) {
		this.r62_others3 = r62_others3;
	}
	public BigDecimal getR62_foreign1() {
		return r62_foreign1;
	}
	public void setR62_foreign1(BigDecimal r62_foreign1) {
		this.r62_foreign1 = r62_foreign1;
	}
	public BigDecimal getR62_guarantees() {
		return r62_guarantees;
	}
	public void setR62_guarantees(BigDecimal r62_guarantees) {
		this.r62_guarantees = r62_guarantees;
	}
	public BigDecimal getR62_nbfi2() {
		return r62_nbfi2;
	}
	public void setR62_nbfi2(BigDecimal r62_nbfi2) {
		this.r62_nbfi2 = r62_nbfi2;
	}
	public BigDecimal getR62_interbank2() {
		return r62_interbank2;
	}
	public void setR62_interbank2(BigDecimal r62_interbank2) {
		this.r62_interbank2 = r62_interbank2;
	}
	public BigDecimal getR62_gov5() {
		return r62_gov5;
	}
	public void setR62_gov5(BigDecimal r62_gov5) {
		this.r62_gov5 = r62_gov5;
	}
	public BigDecimal getR62_corporate2() {
		return r62_corporate2;
	}
	public void setR62_corporate2(BigDecimal r62_corporate2) {
		this.r62_corporate2 = r62_corporate2;
	}
	public BigDecimal getR62_gre2() {
		return r62_gre2;
	}
	public void setR62_gre2(BigDecimal r62_gre2) {
		this.r62_gre2 = r62_gre2;
	}
	public BigDecimal getR62_individuals3() {
		return r62_individuals3;
	}
	public void setR62_individuals3(BigDecimal r62_individuals3) {
		this.r62_individuals3 = r62_individuals3;
	}
	public BigDecimal getR62_zero1() {
		return r62_zero1;
	}
	public void setR62_zero1(BigDecimal r62_zero1) {
		this.r62_zero1 = r62_zero1;
	}
	public BigDecimal getR62_three1() {
		return r62_three1;
	}
	public void setR62_three1(BigDecimal r62_three1) {
		this.r62_three1 = r62_three1;
	}
	public BigDecimal getR62_six1() {
		return r62_six1;
	}
	public void setR62_six1(BigDecimal r62_six1) {
		this.r62_six1 = r62_six1;
	}
	public BigDecimal getR62_oneyear1() {
		return r62_oneyear1;
	}
	public void setR62_oneyear1(BigDecimal r62_oneyear1) {
		this.r62_oneyear1 = r62_oneyear1;
	}
	public String getR62_empty() {
		return r62_empty;
	}
	public void setR62_empty(String r62_empty) {
		this.r62_empty = r62_empty;
	}
	public String getR63_product() {
		return r63_product;
	}
	public void setR63_product(String r63_product) {
		this.r63_product = r63_product;
	}
	public BigDecimal getR63_nbfi() {
		return r63_nbfi;
	}
	public void setR63_nbfi(BigDecimal r63_nbfi) {
		this.r63_nbfi = r63_nbfi;
	}
	public BigDecimal getR63_interbank() {
		return r63_interbank;
	}
	public void setR63_interbank(BigDecimal r63_interbank) {
		this.r63_interbank = r63_interbank;
	}
	public BigDecimal getR63_gov() {
		return r63_gov;
	}
	public void setR63_gov(BigDecimal r63_gov) {
		this.r63_gov = r63_gov;
	}
	public BigDecimal getR63_corporate() {
		return r63_corporate;
	}
	public void setR63_corporate(BigDecimal r63_corporate) {
		this.r63_corporate = r63_corporate;
	}
	public BigDecimal getR63_gre() {
		return r63_gre;
	}
	public void setR63_gre(BigDecimal r63_gre) {
		this.r63_gre = r63_gre;
	}
	public BigDecimal getR63_trade() {
		return r63_trade;
	}
	public void setR63_trade(BigDecimal r63_trade) {
		this.r63_trade = r63_trade;
	}
	public BigDecimal getR63_individuals() {
		return r63_individuals;
	}
	public void setR63_individuals(BigDecimal r63_individuals) {
		this.r63_individuals = r63_individuals;
	}
	public BigDecimal getR63_investment() {
		return r63_investment;
	}
	public void setR63_investment(BigDecimal r63_investment) {
		this.r63_investment = r63_investment;
	}
	public BigDecimal getR63_nbfi1() {
		return r63_nbfi1;
	}
	public void setR63_nbfi1(BigDecimal r63_nbfi1) {
		this.r63_nbfi1 = r63_nbfi1;
	}
	public BigDecimal getR63_interbank1() {
		return r63_interbank1;
	}
	public void setR63_interbank1(BigDecimal r63_interbank1) {
		this.r63_interbank1 = r63_interbank1;
	}
	public BigDecimal getR63_gov1() {
		return r63_gov1;
	}
	public void setR63_gov1(BigDecimal r63_gov1) {
		this.r63_gov1 = r63_gov1;
	}
	public BigDecimal getR63_corporate1() {
		return r63_corporate1;
	}
	public void setR63_corporate1(BigDecimal r63_corporate1) {
		this.r63_corporate1 = r63_corporate1;
	}
	public BigDecimal getR63_gre1() {
		return r63_gre1;
	}
	public void setR63_gre1(BigDecimal r63_gre1) {
		this.r63_gre1 = r63_gre1;
	}
	public BigDecimal getR63_trade1() {
		return r63_trade1;
	}
	public void setR63_trade1(BigDecimal r63_trade1) {
		this.r63_trade1 = r63_trade1;
	}
	public BigDecimal getR63_individuals1() {
		return r63_individuals1;
	}
	public void setR63_individuals1(BigDecimal r63_individuals1) {
		this.r63_individuals1 = r63_individuals1;
	}
	public BigDecimal getR63_investment1() {
		return r63_investment1;
	}
	public void setR63_investment1(BigDecimal r63_investment1) {
		this.r63_investment1 = r63_investment1;
	}
	public BigDecimal getR63_zer0() {
		return r63_zer0;
	}
	public void setR63_zer0(BigDecimal r63_zer0) {
		this.r63_zer0 = r63_zer0;
	}
	public BigDecimal getR63_three() {
		return r63_three;
	}
	public void setR63_three(BigDecimal r63_three) {
		this.r63_three = r63_three;
	}
	public BigDecimal getR63_six() {
		return r63_six;
	}
	public void setR63_six(BigDecimal r63_six) {
		this.r63_six = r63_six;
	}
	public BigDecimal getR63_oneyear() {
		return r63_oneyear;
	}
	public void setR63_oneyear(BigDecimal r63_oneyear) {
		this.r63_oneyear = r63_oneyear;
	}
	public BigDecimal getR63_foreign() {
		return r63_foreign;
	}
	public void setR63_foreign(BigDecimal r63_foreign) {
		this.r63_foreign = r63_foreign;
	}
	public BigDecimal getR63_banks() {
		return r63_banks;
	}
	public void setR63_banks(BigDecimal r63_banks) {
		this.r63_banks = r63_banks;
	}
	public BigDecimal getR63_gov2() {
		return r63_gov2;
	}
	public void setR63_gov2(BigDecimal r63_gov2) {
		this.r63_gov2 = r63_gov2;
	}
	public BigDecimal getR63_other() {
		return r63_other;
	}
	public void setR63_other(BigDecimal r63_other) {
		this.r63_other = r63_other;
	}
	public BigDecimal getR63_banks1() {
		return r63_banks1;
	}
	public void setR63_banks1(BigDecimal r63_banks1) {
		this.r63_banks1 = r63_banks1;
	}
	public BigDecimal getR63_individuals2() {
		return r63_individuals2;
	}
	public void setR63_individuals2(BigDecimal r63_individuals2) {
		this.r63_individuals2 = r63_individuals2;
	}
	public BigDecimal getR63_other1() {
		return r63_other1;
	}
	public void setR63_other1(BigDecimal r63_other1) {
		this.r63_other1 = r63_other1;
	}
	public BigDecimal getR63_banks2() {
		return r63_banks2;
	}
	public void setR63_banks2(BigDecimal r63_banks2) {
		this.r63_banks2 = r63_banks2;
	}
	public BigDecimal getR63_gov3() {
		return r63_gov3;
	}
	public void setR63_gov3(BigDecimal r63_gov3) {
		this.r63_gov3 = r63_gov3;
	}
	public BigDecimal getR63_others2() {
		return r63_others2;
	}
	public void setR63_others2(BigDecimal r63_others2) {
		this.r63_others2 = r63_others2;
	}
	public BigDecimal getR63_banks3() {
		return r63_banks3;
	}
	public void setR63_banks3(BigDecimal r63_banks3) {
		this.r63_banks3 = r63_banks3;
	}
	public BigDecimal getR63_gov4() {
		return r63_gov4;
	}
	public void setR63_gov4(BigDecimal r63_gov4) {
		this.r63_gov4 = r63_gov4;
	}
	public BigDecimal getR63_others3() {
		return r63_others3;
	}
	public void setR63_others3(BigDecimal r63_others3) {
		this.r63_others3 = r63_others3;
	}
	public BigDecimal getR63_foreign1() {
		return r63_foreign1;
	}
	public void setR63_foreign1(BigDecimal r63_foreign1) {
		this.r63_foreign1 = r63_foreign1;
	}
	public BigDecimal getR63_guarantees() {
		return r63_guarantees;
	}
	public void setR63_guarantees(BigDecimal r63_guarantees) {
		this.r63_guarantees = r63_guarantees;
	}
	public BigDecimal getR63_nbfi2() {
		return r63_nbfi2;
	}
	public void setR63_nbfi2(BigDecimal r63_nbfi2) {
		this.r63_nbfi2 = r63_nbfi2;
	}
	public BigDecimal getR63_interbank2() {
		return r63_interbank2;
	}
	public void setR63_interbank2(BigDecimal r63_interbank2) {
		this.r63_interbank2 = r63_interbank2;
	}
	public BigDecimal getR63_gov5() {
		return r63_gov5;
	}
	public void setR63_gov5(BigDecimal r63_gov5) {
		this.r63_gov5 = r63_gov5;
	}
	public BigDecimal getR63_corporate2() {
		return r63_corporate2;
	}
	public void setR63_corporate2(BigDecimal r63_corporate2) {
		this.r63_corporate2 = r63_corporate2;
	}
	public BigDecimal getR63_gre2() {
		return r63_gre2;
	}
	public void setR63_gre2(BigDecimal r63_gre2) {
		this.r63_gre2 = r63_gre2;
	}
	public BigDecimal getR63_individuals3() {
		return r63_individuals3;
	}
	public void setR63_individuals3(BigDecimal r63_individuals3) {
		this.r63_individuals3 = r63_individuals3;
	}
	public BigDecimal getR63_zero1() {
		return r63_zero1;
	}
	public void setR63_zero1(BigDecimal r63_zero1) {
		this.r63_zero1 = r63_zero1;
	}
	public BigDecimal getR63_three1() {
		return r63_three1;
	}
	public void setR63_three1(BigDecimal r63_three1) {
		this.r63_three1 = r63_three1;
	}
	public BigDecimal getR63_six1() {
		return r63_six1;
	}
	public void setR63_six1(BigDecimal r63_six1) {
		this.r63_six1 = r63_six1;
	}
	public BigDecimal getR63_oneyear1() {
		return r63_oneyear1;
	}
	public void setR63_oneyear1(BigDecimal r63_oneyear1) {
		this.r63_oneyear1 = r63_oneyear1;
	}
	public String getR63_empty() {
		return r63_empty;
	}
	public void setR63_empty(String r63_empty) {
		this.r63_empty = r63_empty;
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
	public BRF59C_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}