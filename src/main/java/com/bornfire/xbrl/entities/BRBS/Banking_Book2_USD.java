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
@Table(name="BANKING_BOOK1_USD2")
public class Banking_Book2_USD {
	private String	r50_product;
	private BigDecimal	r50_tequalon;
	private BigDecimal	r50_on_t_equalto_1m;
	private BigDecimal	r50_1m_t_equalto_3m;
	private BigDecimal	r50_3m_t_equalto_6m;
	private BigDecimal	r50_6m_t_equalto_9m;
	private BigDecimal	r50_9m_t_equalto_1y;
	private BigDecimal	r50_1y_t_equalto_1point5y;
	private BigDecimal	r50_1point5y_t_equalto_2y;
	private BigDecimal	r50_2y_t_equalto_3y;
	private BigDecimal	r50_3y_t_equalto_4y;
	private BigDecimal	r50_4y_lt_t_ltequalto_5y;
	private BigDecimal	r50_5y_lt_t_ltequalto_6y;
	private BigDecimal	r50_6y_lt_t_ltequalto_7y;
	private BigDecimal	r50_7y_lt_t_ltequalto_8y;
	private BigDecimal	r50_8y_lt_t_ltequalto_9y;
	private BigDecimal	r50_9y_lt_t_ltequalto_10y;
	private BigDecimal	r50_10y_lt_t_ltequalto_15y;
	private BigDecimal	r50_15y_lt_t_ltequalto_20y;
	private BigDecimal	r50_tl_20y;
	private BigDecimal	r50_nonsensitive;
	private BigDecimal	r50_total_rsl;
	private BigDecimal	r50_total;
	private String	r51_product;
	private BigDecimal	r51_tequalon;
	private BigDecimal	r51_on_t_equalto_1m;
	private BigDecimal	r51_1m_t_equalto_3m;
	private BigDecimal	r51_3m_t_equalto_6m;
	private BigDecimal	r51_6m_t_equalto_9m;
	private BigDecimal	r51_9m_t_equalto_1y;
	private BigDecimal	r51_1y_t_equalto_1point5y;
	private BigDecimal	r51_1point5y_t_equalto_2y;
	private BigDecimal	r51_2y_t_equalto_3y;
	private BigDecimal	r51_3y_t_equalto_4y;
	private BigDecimal	r51_4y_lt_t_ltequalto_5y;
	private BigDecimal	r51_5y_lt_t_ltequalto_6y;
	private BigDecimal	r51_6y_lt_t_ltequalto_7y;
	private BigDecimal	r51_7y_lt_t_ltequalto_8y;
	private BigDecimal	r51_8y_lt_t_ltequalto_9y;
	private BigDecimal	r51_9y_lt_t_ltequalto_10y;
	private BigDecimal	r51_10y_lt_t_ltequalto_15y;
	private BigDecimal	r51_15y_lt_t_ltequalto_20y;
	private BigDecimal	r51_tl_20y;
	private BigDecimal	r51_nonsensitive;
	private BigDecimal	r51_total_rsl;
	private BigDecimal	r51_total;
	private String	r52_product;
	private BigDecimal	r52_tequalon;
	private BigDecimal	r52_on_t_equalto_1m;
	private BigDecimal	r52_1m_t_equalto_3m;
	private BigDecimal	r52_3m_t_equalto_6m;
	private BigDecimal	r52_6m_t_equalto_9m;
	private BigDecimal	r52_9m_t_equalto_1y;
	private BigDecimal	r52_1y_t_equalto_1point5y;
	private BigDecimal	r52_1point5y_t_equalto_2y;
	private BigDecimal	r52_2y_t_equalto_3y;
	private BigDecimal	r52_3y_t_equalto_4y;
	private BigDecimal	r52_4y_lt_t_ltequalto_5y;
	private BigDecimal	r52_5y_lt_t_ltequalto_6y;
	private BigDecimal	r52_6y_lt_t_ltequalto_7y;
	private BigDecimal	r52_7y_lt_t_ltequalto_8y;
	private BigDecimal	r52_8y_lt_t_ltequalto_9y;
	private BigDecimal	r52_9y_lt_t_ltequalto_10y;
	private BigDecimal	r52_10y_lt_t_ltequalto_15y;
	private BigDecimal	r52_15y_lt_t_ltequalto_20y;
	private BigDecimal	r52_tl_20y;
	private BigDecimal	r52_nonsensitive;
	private BigDecimal	r52_total_rsl;
	private BigDecimal	r52_total;
	private String	r53_product;
	private BigDecimal	r53_tequalon;
	private BigDecimal	r53_on_t_equalto_1m;
	private BigDecimal	r53_1m_t_equalto_3m;
	private BigDecimal	r53_3m_t_equalto_6m;
	private BigDecimal	r53_6m_t_equalto_9m;
	private BigDecimal	r53_9m_t_equalto_1y;
	private BigDecimal	r53_1y_t_equalto_1point5y;
	private BigDecimal	r53_1point5y_t_equalto_2y;
	private BigDecimal	r53_2y_t_equalto_3y;
	private BigDecimal	r53_3y_t_equalto_4y;
	private BigDecimal	r53_4y_lt_t_ltequalto_5y;
	private BigDecimal	r53_5y_lt_t_ltequalto_6y;
	private BigDecimal	r53_6y_lt_t_ltequalto_7y;
	private BigDecimal	r53_7y_lt_t_ltequalto_8y;
	private BigDecimal	r53_8y_lt_t_ltequalto_9y;
	private BigDecimal	r53_9y_lt_t_ltequalto_10y;
	private BigDecimal	r53_10y_lt_t_ltequalto_15y;
	private BigDecimal	r53_15y_lt_t_ltequalto_20y;
	private BigDecimal	r53_tl_20y;
	private BigDecimal	r53_nonsensitive;
	private BigDecimal	r53_total_rsl;
	private BigDecimal	r53_total;
	private String	r54_product;
	private BigDecimal	r54_tequalon;
	private BigDecimal	r54_on_t_equalto_1m;
	private BigDecimal	r54_1m_t_equalto_3m;
	private BigDecimal	r54_3m_t_equalto_6m;
	private BigDecimal	r54_6m_t_equalto_9m;
	private BigDecimal	r54_9m_t_equalto_1y;
	private BigDecimal	r54_1y_t_equalto_1point5y;
	private BigDecimal	r54_1point5y_t_equalto_2y;
	private BigDecimal	r54_2y_t_equalto_3y;
	private BigDecimal	r54_3y_t_equalto_4y;
	private BigDecimal	r54_4y_lt_t_ltequalto_5y;
	private BigDecimal	r54_5y_lt_t_ltequalto_6y;
	private BigDecimal	r54_6y_lt_t_ltequalto_7y;
	private BigDecimal	r54_7y_lt_t_ltequalto_8y;
	private BigDecimal	r54_8y_lt_t_ltequalto_9y;
	private BigDecimal	r54_9y_lt_t_ltequalto_10y;
	private BigDecimal	r54_10y_lt_t_ltequalto_15y;
	private BigDecimal	r54_15y_lt_t_ltequalto_20y;
	private BigDecimal	r54_tl_20y;
	private BigDecimal	r54_nonsensitive;
	private BigDecimal	r54_total_rsl;
	private BigDecimal	r54_total;
	private String	r55_product;
	private BigDecimal	r55_tequalon;
	private BigDecimal	r55_on_t_equalto_1m;
	private BigDecimal	r55_1m_t_equalto_3m;
	private BigDecimal	r55_3m_t_equalto_6m;
	private BigDecimal	r55_6m_t_equalto_9m;
	private BigDecimal	r55_9m_t_equalto_1y;
	private BigDecimal	r55_1y_t_equalto_1point5y;
	private BigDecimal	r55_1point5y_t_equalto_2y;
	private BigDecimal	r55_2y_t_equalto_3y;
	private BigDecimal	r55_3y_t_equalto_4y;
	private BigDecimal	r55_4y_lt_t_ltequalto_5y;
	private BigDecimal	r55_5y_lt_t_ltequalto_6y;
	private BigDecimal	r55_6y_lt_t_ltequalto_7y;
	private BigDecimal	r55_7y_lt_t_ltequalto_8y;
	private BigDecimal	r55_8y_lt_t_ltequalto_9y;
	private BigDecimal	r55_9y_lt_t_ltequalto_10y;
	private BigDecimal	r55_10y_lt_t_ltequalto_15y;
	private BigDecimal	r55_15y_lt_t_ltequalto_20y;
	private BigDecimal	r55_tl_20y;
	private BigDecimal	r55_nonsensitive;
	private BigDecimal	r55_total_rsl;
	private BigDecimal	r55_total;
	private String	r56_product;
	private BigDecimal	r56_tequalon;
	private BigDecimal	r56_on_t_equalto_1m;
	private BigDecimal	r56_1m_t_equalto_3m;
	private BigDecimal	r56_3m_t_equalto_6m;
	private BigDecimal	r56_6m_t_equalto_9m;
	private BigDecimal	r56_9m_t_equalto_1y;
	private BigDecimal	r56_1y_t_equalto_1point5y;
	private BigDecimal	r56_1point5y_t_equalto_2y;
	private BigDecimal	r56_2y_t_equalto_3y;
	private BigDecimal	r56_3y_t_equalto_4y;
	private BigDecimal	r56_4y_lt_t_ltequalto_5y;
	private BigDecimal	r56_5y_lt_t_ltequalto_6y;
	private BigDecimal	r56_6y_lt_t_ltequalto_7y;
	private BigDecimal	r56_7y_lt_t_ltequalto_8y;
	private BigDecimal	r56_8y_lt_t_ltequalto_9y;
	private BigDecimal	r56_9y_lt_t_ltequalto_10y;
	private BigDecimal	r56_10y_lt_t_ltequalto_15y;
	private BigDecimal	r56_15y_lt_t_ltequalto_20y;
	private BigDecimal	r56_tl_20y;
	private BigDecimal	r56_nonsensitive;
	private BigDecimal	r56_total_rsl;
	private BigDecimal	r56_total;
	private String	r57_product;
	private BigDecimal	r57_tequalon;
	private BigDecimal	r57_on_t_equalto_1m;
	private BigDecimal	r57_1m_t_equalto_3m;
	private BigDecimal	r57_3m_t_equalto_6m;
	private BigDecimal	r57_6m_t_equalto_9m;
	private BigDecimal	r57_9m_t_equalto_1y;
	private BigDecimal	r57_1y_t_equalto_1point5y;
	private BigDecimal	r57_1point5y_t_equalto_2y;
	private BigDecimal	r57_2y_t_equalto_3y;
	private BigDecimal	r57_3y_t_equalto_4y;
	private BigDecimal	r57_4y_lt_t_ltequalto_5y;
	private BigDecimal	r57_5y_lt_t_ltequalto_6y;
	private BigDecimal	r57_6y_lt_t_ltequalto_7y;
	private BigDecimal	r57_7y_lt_t_ltequalto_8y;
	private BigDecimal	r57_8y_lt_t_ltequalto_9y;
	private BigDecimal	r57_9y_lt_t_ltequalto_10y;
	private BigDecimal	r57_10y_lt_t_ltequalto_15y;
	private BigDecimal	r57_15y_lt_t_ltequalto_20y;
	private BigDecimal	r57_tl_20y;
	private BigDecimal	r57_nonsensitive;
	private BigDecimal	r57_total_rsl;
	private BigDecimal	r57_total;
	private String	r58_product;
	private BigDecimal	r58_tequalon;
	private BigDecimal	r58_on_t_equalto_1m;
	private BigDecimal	r58_1m_t_equalto_3m;
	private BigDecimal	r58_3m_t_equalto_6m;
	private BigDecimal	r58_6m_t_equalto_9m;
	private BigDecimal	r58_9m_t_equalto_1y;
	private BigDecimal	r58_1y_t_equalto_1point5y;
	private BigDecimal	r58_1point5y_t_equalto_2y;
	private BigDecimal	r58_2y_t_equalto_3y;
	private BigDecimal	r58_3y_t_equalto_4y;
	private BigDecimal	r58_4y_lt_t_ltequalto_5y;
	private BigDecimal	r58_5y_lt_t_ltequalto_6y;
	private BigDecimal	r58_6y_lt_t_ltequalto_7y;
	private BigDecimal	r58_7y_lt_t_ltequalto_8y;
	private BigDecimal	r58_8y_lt_t_ltequalto_9y;
	private BigDecimal	r58_9y_lt_t_ltequalto_10y;
	private BigDecimal	r58_10y_lt_t_ltequalto_15y;
	private BigDecimal	r58_15y_lt_t_ltequalto_20y;
	private BigDecimal	r58_tl_20y;
	private BigDecimal	r58_nonsensitive;
	private BigDecimal	r58_total_rsl;
	private BigDecimal	r58_total;
	private String	r59_product;
	private BigDecimal	r59_tequalon;
	private BigDecimal	r59_on_t_equalto_1m;
	private BigDecimal	r59_1m_t_equalto_3m;
	private BigDecimal	r59_3m_t_equalto_6m;
	private BigDecimal	r59_6m_t_equalto_9m;
	private BigDecimal	r59_9m_t_equalto_1y;
	private BigDecimal	r59_1y_t_equalto_1point5y;
	private BigDecimal	r59_1point5y_t_equalto_2y;
	private BigDecimal	r59_2y_t_equalto_3y;
	private BigDecimal	r59_3y_t_equalto_4y;
	private BigDecimal	r59_4y_lt_t_ltequalto_5y;
	private BigDecimal	r59_5y_lt_t_ltequalto_6y;
	private BigDecimal	r59_6y_lt_t_ltequalto_7y;
	private BigDecimal	r59_7y_lt_t_ltequalto_8y;
	private BigDecimal	r59_8y_lt_t_ltequalto_9y;
	private BigDecimal	r59_9y_lt_t_ltequalto_10y;
	private BigDecimal	r59_10y_lt_t_ltequalto_15y;
	private BigDecimal	r59_15y_lt_t_ltequalto_20y;
	private BigDecimal	r59_tl_20y;
	private BigDecimal	r59_nonsensitive;
	private BigDecimal	r59_total_rsl;
	private BigDecimal	r59_total;
	private String	r60_product;
	private BigDecimal	r60_tequalon;
	private BigDecimal	r60_on_t_equalto_1m;
	private BigDecimal	r60_1m_t_equalto_3m;
	private BigDecimal	r60_3m_t_equalto_6m;
	private BigDecimal	r60_6m_t_equalto_9m;
	private BigDecimal	r60_9m_t_equalto_1y;
	private BigDecimal	r60_1y_t_equalto_1point5y;
	private BigDecimal	r60_1point5y_t_equalto_2y;
	private BigDecimal	r60_2y_t_equalto_3y;
	private BigDecimal	r60_3y_t_equalto_4y;
	private BigDecimal	r60_4y_lt_t_ltequalto_5y;
	private BigDecimal	r60_5y_lt_t_ltequalto_6y;
	private BigDecimal	r60_6y_lt_t_ltequalto_7y;
	private BigDecimal	r60_7y_lt_t_ltequalto_8y;
	private BigDecimal	r60_8y_lt_t_ltequalto_9y;
	private BigDecimal	r60_9y_lt_t_ltequalto_10y;
	private BigDecimal	r60_10y_lt_t_ltequalto_15y;
	private BigDecimal	r60_15y_lt_t_ltequalto_20y;
	private BigDecimal	r60_tl_20y;
	private BigDecimal	r60_nonsensitive;
	private BigDecimal	r60_total_rsl;
	private BigDecimal	r60_total;
	private String	r61_product;
	private BigDecimal	r61_tequalon;
	private BigDecimal	r61_on_t_equalto_1m;
	private BigDecimal	r61_1m_t_equalto_3m;
	private BigDecimal	r61_3m_t_equalto_6m;
	private BigDecimal	r61_6m_t_equalto_9m;
	private BigDecimal	r61_9m_t_equalto_1y;
	private BigDecimal	r61_1y_t_equalto_1point5y;
	private BigDecimal	r61_1point5y_t_equalto_2y;
	private BigDecimal	r61_2y_t_equalto_3y;
	private BigDecimal	r61_3y_t_equalto_4y;
	private BigDecimal	r61_4y_lt_t_ltequalto_5y;
	private BigDecimal	r61_5y_lt_t_ltequalto_6y;
	private BigDecimal	r61_6y_lt_t_ltequalto_7y;
	private BigDecimal	r61_7y_lt_t_ltequalto_8y;
	private BigDecimal	r61_8y_lt_t_ltequalto_9y;
	private BigDecimal	r61_9y_lt_t_ltequalto_10y;
	private BigDecimal	r61_10y_lt_t_ltequalto_15y;
	private BigDecimal	r61_15y_lt_t_ltequalto_20y;
	private BigDecimal	r61_tl_20y;
	private BigDecimal	r61_nonsensitive;
	private BigDecimal	r61_total_rsl;
	private BigDecimal	r61_total;
	private String	r62_product;
	private BigDecimal	r62_tequalon;
	private BigDecimal	r62_on_t_equalto_1m;
	private BigDecimal	r62_1m_t_equalto_3m;
	private BigDecimal	r62_3m_t_equalto_6m;
	private BigDecimal	r62_6m_t_equalto_9m;
	private BigDecimal	r62_9m_t_equalto_1y;
	private BigDecimal	r62_1y_t_equalto_1point5y;
	private BigDecimal	r62_1point5y_t_equalto_2y;
	private BigDecimal	r62_2y_t_equalto_3y;
	private BigDecimal	r62_3y_t_equalto_4y;
	private BigDecimal	r62_4y_lt_t_ltequalto_5y;
	private BigDecimal	r62_5y_lt_t_ltequalto_6y;
	private BigDecimal	r62_6y_lt_t_ltequalto_7y;
	private BigDecimal	r62_7y_lt_t_ltequalto_8y;
	private BigDecimal	r62_8y_lt_t_ltequalto_9y;
	private BigDecimal	r62_9y_lt_t_ltequalto_10y;
	private BigDecimal	r62_10y_lt_t_ltequalto_15y;
	private BigDecimal	r62_15y_lt_t_ltequalto_20y;
	private BigDecimal	r62_tl_20y;
	private BigDecimal	r62_nonsensitive;
	private BigDecimal	r62_total_rsl;
	private BigDecimal	r62_total;
	private String	r63_product;
	private BigDecimal	r63_tequalon;
	private BigDecimal	r63_on_t_equalto_1m;
	private BigDecimal	r63_1m_t_equalto_3m;
	private BigDecimal	r63_3m_t_equalto_6m;
	private BigDecimal	r63_6m_t_equalto_9m;
	private BigDecimal	r63_9m_t_equalto_1y;
	private BigDecimal	r63_1y_t_equalto_1point5y;
	private BigDecimal	r63_1point5y_t_equalto_2y;
	private BigDecimal	r63_2y_t_equalto_3y;
	private BigDecimal	r63_3y_t_equalto_4y;
	private BigDecimal	r63_4y_lt_t_ltequalto_5y;
	private BigDecimal	r63_5y_lt_t_ltequalto_6y;
	private BigDecimal	r63_6y_lt_t_ltequalto_7y;
	private BigDecimal	r63_7y_lt_t_ltequalto_8y;
	private BigDecimal	r63_8y_lt_t_ltequalto_9y;
	private BigDecimal	r63_9y_lt_t_ltequalto_10y;
	private BigDecimal	r63_10y_lt_t_ltequalto_15y;
	private BigDecimal	r63_15y_lt_t_ltequalto_20y;
	private BigDecimal	r63_tl_20y;
	private BigDecimal	r63_nonsensitive;
	private BigDecimal	r63_total_rsl;
	private BigDecimal	r63_total;
	private String	r64_product;
	private BigDecimal	r64_tequalon;
	private BigDecimal	r64_on_t_equalto_1m;
	private BigDecimal	r64_1m_t_equalto_3m;
	private BigDecimal	r64_3m_t_equalto_6m;
	private BigDecimal	r64_6m_t_equalto_9m;
	private BigDecimal	r64_9m_t_equalto_1y;
	private BigDecimal	r64_1y_t_equalto_1point5y;
	private BigDecimal	r64_1point5y_t_equalto_2y;
	private BigDecimal	r64_2y_t_equalto_3y;
	private BigDecimal	r64_3y_t_equalto_4y;
	private BigDecimal	r64_4y_lt_t_ltequalto_5y;
	private BigDecimal	r64_5y_lt_t_ltequalto_6y;
	private BigDecimal	r64_6y_lt_t_ltequalto_7y;
	private BigDecimal	r64_7y_lt_t_ltequalto_8y;
	private BigDecimal	r64_8y_lt_t_ltequalto_9y;
	private BigDecimal	r64_9y_lt_t_ltequalto_10y;
	private BigDecimal	r64_10y_lt_t_ltequalto_15y;
	private BigDecimal	r64_15y_lt_t_ltequalto_20y;
	private BigDecimal	r64_tl_20y;
	private BigDecimal	r64_nonsensitive;
	private BigDecimal	r64_total_rsl;
	private BigDecimal	r64_total;
	private String	r65_product;
	private BigDecimal	r65_tequalon;
	private BigDecimal	r65_on_t_equalto_1m;
	private BigDecimal	r65_1m_t_equalto_3m;
	private BigDecimal	r65_3m_t_equalto_6m;
	private BigDecimal	r65_6m_t_equalto_9m;
	private BigDecimal	r65_9m_t_equalto_1y;
	private BigDecimal	r65_1y_t_equalto_1point5y;
	private BigDecimal	r65_1point5y_t_equalto_2y;
	private BigDecimal	r65_2y_t_equalto_3y;
	private BigDecimal	r65_3y_t_equalto_4y;
	private BigDecimal	r65_4y_lt_t_ltequalto_5y;
	private BigDecimal	r65_5y_lt_t_ltequalto_6y;
	private BigDecimal	r65_6y_lt_t_ltequalto_7y;
	private BigDecimal	r65_7y_lt_t_ltequalto_8y;
	private BigDecimal	r65_8y_lt_t_ltequalto_9y;
	private BigDecimal	r65_9y_lt_t_ltequalto_10y;
	private BigDecimal	r65_10y_lt_t_ltequalto_15y;
	private BigDecimal	r65_15y_lt_t_ltequalto_20y;
	private BigDecimal	r65_tl_20y;
	private BigDecimal	r65_nonsensitive;
	private BigDecimal	r65_total_rsl;
	private BigDecimal	r65_total;
	private String	r66_product;
	private BigDecimal	r66_tequalon;
	private BigDecimal	r66_on_t_equalto_1m;
	private BigDecimal	r66_1m_t_equalto_3m;
	private BigDecimal	r66_3m_t_equalto_6m;
	private BigDecimal	r66_6m_t_equalto_9m;
	private BigDecimal	r66_9m_t_equalto_1y;
	private BigDecimal	r66_1y_t_equalto_1point5y;
	private BigDecimal	r66_1point5y_t_equalto_2y;
	private BigDecimal	r66_2y_t_equalto_3y;
	private BigDecimal	r66_3y_t_equalto_4y;
	private BigDecimal	r66_4y_lt_t_ltequalto_5y;
	private BigDecimal	r66_5y_lt_t_ltequalto_6y;
	private BigDecimal	r66_6y_lt_t_ltequalto_7y;
	private BigDecimal	r66_7y_lt_t_ltequalto_8y;
	private BigDecimal	r66_8y_lt_t_ltequalto_9y;
	private BigDecimal	r66_9y_lt_t_ltequalto_10y;
	private BigDecimal	r66_10y_lt_t_ltequalto_15y;
	private BigDecimal	r66_15y_lt_t_ltequalto_20y;
	private BigDecimal	r66_tl_20y;
	private BigDecimal	r66_nonsensitive;
	private BigDecimal	r66_total_rsl;
	private BigDecimal	r66_total;
	private String	r67_product;
	private BigDecimal	r67_tequalon;
	private BigDecimal	r67_on_t_equalto_1m;
	private BigDecimal	r67_1m_t_equalto_3m;
	private BigDecimal	r67_3m_t_equalto_6m;
	private BigDecimal	r67_6m_t_equalto_9m;
	private BigDecimal	r67_9m_t_equalto_1y;
	private BigDecimal	r67_1y_t_equalto_1point5y;
	private BigDecimal	r67_1point5y_t_equalto_2y;
	private BigDecimal	r67_2y_t_equalto_3y;
	private BigDecimal	r67_3y_t_equalto_4y;
	private BigDecimal	r67_4y_lt_t_ltequalto_5y;
	private BigDecimal	r67_5y_lt_t_ltequalto_6y;
	private BigDecimal	r67_6y_lt_t_ltequalto_7y;
	private BigDecimal	r67_7y_lt_t_ltequalto_8y;
	private BigDecimal	r67_8y_lt_t_ltequalto_9y;
	private BigDecimal	r67_9y_lt_t_ltequalto_10y;
	private BigDecimal	r67_10y_lt_t_ltequalto_15y;
	private BigDecimal	r67_15y_lt_t_ltequalto_20y;
	private BigDecimal	r67_tl_20y;
	private BigDecimal	r67_nonsensitive;
	private BigDecimal	r67_total_rsl;
	private BigDecimal	r67_total;
	private String	r68_product;
	private BigDecimal	r68_tequalon;
	private BigDecimal	r68_on_t_equalto_1m;
	private BigDecimal	r68_1m_t_equalto_3m;
	private BigDecimal	r68_3m_t_equalto_6m;
	private BigDecimal	r68_6m_t_equalto_9m;
	private BigDecimal	r68_9m_t_equalto_1y;
	private BigDecimal	r68_1y_t_equalto_1point5y;
	private BigDecimal	r68_1point5y_t_equalto_2y;
	private BigDecimal	r68_2y_t_equalto_3y;
	private BigDecimal	r68_3y_t_equalto_4y;
	private BigDecimal	r68_4y_lt_t_ltequalto_5y;
	private BigDecimal	r68_5y_lt_t_ltequalto_6y;
	private BigDecimal	r68_6y_lt_t_ltequalto_7y;
	private BigDecimal	r68_7y_lt_t_ltequalto_8y;
	private BigDecimal	r68_8y_lt_t_ltequalto_9y;
	private BigDecimal	r68_9y_lt_t_ltequalto_10y;
	private BigDecimal	r68_10y_lt_t_ltequalto_15y;
	private BigDecimal	r68_15y_lt_t_ltequalto_20y;
	private BigDecimal	r68_tl_20y;
	private BigDecimal	r68_nonsensitive;
	private BigDecimal	r68_total_rsl;
	private BigDecimal	r68_total;
	private String	r69_product;
	private BigDecimal	r69_tequalon;
	private BigDecimal	r69_on_t_equalto_1m;
	private BigDecimal	r69_1m_t_equalto_3m;
	private BigDecimal	r69_3m_t_equalto_6m;
	private BigDecimal	r69_6m_t_equalto_9m;
	private BigDecimal	r69_9m_t_equalto_1y;
	private BigDecimal	r69_1y_t_equalto_1point5y;
	private BigDecimal	r69_1point5y_t_equalto_2y;
	private BigDecimal	r69_2y_t_equalto_3y;
	private BigDecimal	r69_3y_t_equalto_4y;
	private BigDecimal	r69_4y_lt_t_ltequalto_5y;
	private BigDecimal	r69_5y_lt_t_ltequalto_6y;
	private BigDecimal	r69_6y_lt_t_ltequalto_7y;
	private BigDecimal	r69_7y_lt_t_ltequalto_8y;
	private BigDecimal	r69_8y_lt_t_ltequalto_9y;
	private BigDecimal	r69_9y_lt_t_ltequalto_10y;
	private BigDecimal	r69_10y_lt_t_ltequalto_15y;
	private BigDecimal	r69_15y_lt_t_ltequalto_20y;
	private BigDecimal	r69_tl_20y;
	private BigDecimal	r69_nonsensitive;
	private BigDecimal	r69_total_rsl;
	private BigDecimal	r69_total;
	private String	r70_product;
	private BigDecimal	r70_tequalon;
	private BigDecimal	r70_on_t_equalto_1m;
	private BigDecimal	r70_1m_t_equalto_3m;
	private BigDecimal	r70_3m_t_equalto_6m;
	private BigDecimal	r70_6m_t_equalto_9m;
	private BigDecimal	r70_9m_t_equalto_1y;
	private BigDecimal	r70_1y_t_equalto_1point5y;
	private BigDecimal	r70_1point5y_t_equalto_2y;
	private BigDecimal	r70_2y_t_equalto_3y;
	private BigDecimal	r70_3y_t_equalto_4y;
	private BigDecimal	r70_4y_lt_t_ltequalto_5y;
	private BigDecimal	r70_5y_lt_t_ltequalto_6y;
	private BigDecimal	r70_6y_lt_t_ltequalto_7y;
	private BigDecimal	r70_7y_lt_t_ltequalto_8y;
	private BigDecimal	r70_8y_lt_t_ltequalto_9y;
	private BigDecimal	r70_9y_lt_t_ltequalto_10y;
	private BigDecimal	r70_10y_lt_t_ltequalto_15y;
	private BigDecimal	r70_15y_lt_t_ltequalto_20y;
	private BigDecimal	r70_tl_20y;
	private BigDecimal	r70_nonsensitive;
	private BigDecimal	r70_total_rsl;
	private BigDecimal	r70_total;
	private String	r71_product;
	private BigDecimal	r71_tequalon;
	private BigDecimal	r71_on_t_equalto_1m;
	private BigDecimal	r71_1m_t_equalto_3m;
	private BigDecimal	r71_3m_t_equalto_6m;
	private BigDecimal	r71_6m_t_equalto_9m;
	private BigDecimal	r71_9m_t_equalto_1y;
	private BigDecimal	r71_1y_t_equalto_1point5y;
	private BigDecimal	r71_1point5y_t_equalto_2y;
	private BigDecimal	r71_2y_t_equalto_3y;
	private BigDecimal	r71_3y_t_equalto_4y;
	private BigDecimal	r71_4y_lt_t_ltequalto_5y;
	private BigDecimal	r71_5y_lt_t_ltequalto_6y;
	private BigDecimal	r71_6y_lt_t_ltequalto_7y;
	private BigDecimal	r71_7y_lt_t_ltequalto_8y;
	private BigDecimal	r71_8y_lt_t_ltequalto_9y;
	private BigDecimal	r71_9y_lt_t_ltequalto_10y;
	private BigDecimal	r71_10y_lt_t_ltequalto_15y;
	private BigDecimal	r71_15y_lt_t_ltequalto_20y;
	private BigDecimal	r71_tl_20y;
	private BigDecimal	r71_nonsensitive;
	private BigDecimal	r71_total_rsl;
	private BigDecimal	r71_total;
	private String	r72_product;
	private BigDecimal	r72_tequalon;
	private BigDecimal	r72_on_t_equalto_1m;
	private BigDecimal	r72_1m_t_equalto_3m;
	private BigDecimal	r72_3m_t_equalto_6m;
	private BigDecimal	r72_6m_t_equalto_9m;
	private BigDecimal	r72_9m_t_equalto_1y;
	private BigDecimal	r72_1y_t_equalto_1point5y;
	private BigDecimal	r72_1point5y_t_equalto_2y;
	private BigDecimal	r72_2y_t_equalto_3y;
	private BigDecimal	r72_3y_t_equalto_4y;
	private BigDecimal	r72_4y_lt_t_ltequalto_5y;
	private BigDecimal	r72_5y_lt_t_ltequalto_6y;
	private BigDecimal	r72_6y_lt_t_ltequalto_7y;
	private BigDecimal	r72_7y_lt_t_ltequalto_8y;
	private BigDecimal	r72_8y_lt_t_ltequalto_9y;
	private BigDecimal	r72_9y_lt_t_ltequalto_10y;
	private BigDecimal	r72_10y_lt_t_ltequalto_15y;
	private BigDecimal	r72_15y_lt_t_ltequalto_20y;
	private BigDecimal	r72_tl_20y;
	private BigDecimal	r72_nonsensitive;
	private BigDecimal	r72_total_rsl;
	private BigDecimal	r72_total;
	private String	r73_product;
	private BigDecimal	r73_tequalon;
	private BigDecimal	r73_on_t_equalto_1m;
	private BigDecimal	r73_1m_t_equalto_3m;
	private BigDecimal	r73_3m_t_equalto_6m;
	private BigDecimal	r73_6m_t_equalto_9m;
	private BigDecimal	r73_9m_t_equalto_1y;
	private BigDecimal	r73_1y_t_equalto_1point5y;
	private BigDecimal	r73_1point5y_t_equalto_2y;
	private BigDecimal	r73_2y_t_equalto_3y;
	private BigDecimal	r73_3y_t_equalto_4y;
	private BigDecimal	r73_4y_lt_t_ltequalto_5y;
	private BigDecimal	r73_5y_lt_t_ltequalto_6y;
	private BigDecimal	r73_6y_lt_t_ltequalto_7y;
	private BigDecimal	r73_7y_lt_t_ltequalto_8y;
	private BigDecimal	r73_8y_lt_t_ltequalto_9y;
	private BigDecimal	r73_9y_lt_t_ltequalto_10y;
	private BigDecimal	r73_10y_lt_t_ltequalto_15y;
	private BigDecimal	r73_15y_lt_t_ltequalto_20y;
	private BigDecimal	r73_tl_20y;
	private BigDecimal	r73_nonsensitive;
	private BigDecimal	r73_total_rsl;
	private BigDecimal	r73_total;
	private String	r74_product;
	private BigDecimal	r74_tequalon;
	private BigDecimal	r74_on_t_equalto_1m;
	private BigDecimal	r74_1m_t_equalto_3m;
	private BigDecimal	r74_3m_t_equalto_6m;
	private BigDecimal	r74_6m_t_equalto_9m;
	private BigDecimal	r74_9m_t_equalto_1y;
	private BigDecimal	r74_1y_t_equalto_1point5y;
	private BigDecimal	r74_1point5y_t_equalto_2y;
	private BigDecimal	r74_2y_t_equalto_3y;
	private BigDecimal	r74_3y_t_equalto_4y;
	private BigDecimal	r74_4y_lt_t_ltequalto_5y;
	private BigDecimal	r74_5y_lt_t_ltequalto_6y;
	private BigDecimal	r74_6y_lt_t_ltequalto_7y;
	private BigDecimal	r74_7y_lt_t_ltequalto_8y;
	private BigDecimal	r74_8y_lt_t_ltequalto_9y;
	private BigDecimal	r74_9y_lt_t_ltequalto_10y;
	private BigDecimal	r74_10y_lt_t_ltequalto_15y;
	private BigDecimal	r74_15y_lt_t_ltequalto_20y;
	private BigDecimal	r74_tl_20y;
	private BigDecimal	r74_nonsensitive;
	private BigDecimal	r74_total_rsl;
	private BigDecimal	r74_total;
	private String	r75_product;
	private BigDecimal	r75_tequalon;
	private BigDecimal	r75_on_t_equalto_1m;
	private BigDecimal	r75_1m_t_equalto_3m;
	private BigDecimal	r75_3m_t_equalto_6m;
	private BigDecimal	r75_6m_t_equalto_9m;
	private BigDecimal	r75_9m_t_equalto_1y;
	private BigDecimal	r75_1y_t_equalto_1point5y;
	private BigDecimal	r75_1point5y_t_equalto_2y;
	private BigDecimal	r75_2y_t_equalto_3y;
	private BigDecimal	r75_3y_t_equalto_4y;
	private BigDecimal	r75_4y_lt_t_ltequalto_5y;
	private BigDecimal	r75_5y_lt_t_ltequalto_6y;
	private BigDecimal	r75_6y_lt_t_ltequalto_7y;
	private BigDecimal	r75_7y_lt_t_ltequalto_8y;
	private BigDecimal	r75_8y_lt_t_ltequalto_9y;
	private BigDecimal	r75_9y_lt_t_ltequalto_10y;
	private BigDecimal	r75_10y_lt_t_ltequalto_15y;
	private BigDecimal	r75_15y_lt_t_ltequalto_20y;
	private BigDecimal	r75_tl_20y;
	private BigDecimal	r75_nonsensitive;
	private BigDecimal	r75_total_rsl;
	private BigDecimal	r75_total;
	private String	r76_product;
	private BigDecimal	r76_tequalon;
	private BigDecimal	r76_on_t_equalto_1m;
	private BigDecimal	r76_1m_t_equalto_3m;
	private BigDecimal	r76_3m_t_equalto_6m;
	private BigDecimal	r76_6m_t_equalto_9m;
	private BigDecimal	r76_9m_t_equalto_1y;
	private BigDecimal	r76_1y_t_equalto_1point5y;
	private BigDecimal	r76_1point5y_t_equalto_2y;
	private BigDecimal	r76_2y_t_equalto_3y;
	private BigDecimal	r76_3y_t_equalto_4y;
	private BigDecimal	r76_4y_lt_t_ltequalto_5y;
	private BigDecimal	r76_5y_lt_t_ltequalto_6y;
	private BigDecimal	r76_6y_lt_t_ltequalto_7y;
	private BigDecimal	r76_7y_lt_t_ltequalto_8y;
	private BigDecimal	r76_8y_lt_t_ltequalto_9y;
	private BigDecimal	r76_9y_lt_t_ltequalto_10y;
	private BigDecimal	r76_10y_lt_t_ltequalto_15y;
	private BigDecimal	r76_15y_lt_t_ltequalto_20y;
	private BigDecimal	r76_tl_20y;
	private BigDecimal	r76_nonsensitive;
	private BigDecimal	r76_total_rsl;
	private BigDecimal	r76_total;
	private String	r77_product;
	private BigDecimal	r77_tequalon;
	private BigDecimal	r77_on_t_equalto_1m;
	private BigDecimal	r77_1m_t_equalto_3m;
	private BigDecimal	r77_3m_t_equalto_6m;
	private BigDecimal	r77_6m_t_equalto_9m;
	private BigDecimal	r77_9m_t_equalto_1y;
	private BigDecimal	r77_1y_t_equalto_1point5y;
	private BigDecimal	r77_1point5y_t_equalto_2y;
	private BigDecimal	r77_2y_t_equalto_3y;
	private BigDecimal	r77_3y_t_equalto_4y;
	private BigDecimal	r77_4y_lt_t_ltequalto_5y;
	private BigDecimal	r77_5y_lt_t_ltequalto_6y;
	private BigDecimal	r77_6y_lt_t_ltequalto_7y;
	private BigDecimal	r77_7y_lt_t_ltequalto_8y;
	private BigDecimal	r77_8y_lt_t_ltequalto_9y;
	private BigDecimal	r77_9y_lt_t_ltequalto_10y;
	private BigDecimal	r77_10y_lt_t_ltequalto_15y;
	private BigDecimal	r77_15y_lt_t_ltequalto_20y;
	private BigDecimal	r77_tl_20y;
	private BigDecimal	r77_nonsensitive;
	private BigDecimal	r77_total_rsl;
	private BigDecimal	r77_total;
	private String	r78_product;
	private BigDecimal	r78_tequalon;
	private BigDecimal	r78_on_t_equalto_1m;
	private BigDecimal	r78_1m_t_equalto_3m;
	private BigDecimal	r78_3m_t_equalto_6m;
	private BigDecimal	r78_6m_t_equalto_9m;
	private BigDecimal	r78_9m_t_equalto_1y;
	private BigDecimal	r78_1y_t_equalto_1point5y;
	private BigDecimal	r78_1point5y_t_equalto_2y;
	private BigDecimal	r78_2y_t_equalto_3y;
	private BigDecimal	r78_3y_t_equalto_4y;
	private BigDecimal	r78_4y_lt_t_ltequalto_5y;
	private BigDecimal	r78_5y_lt_t_ltequalto_6y;
	private BigDecimal	r78_6y_lt_t_ltequalto_7y;
	private BigDecimal	r78_7y_lt_t_ltequalto_8y;
	private BigDecimal	r78_8y_lt_t_ltequalto_9y;
	private BigDecimal	r78_9y_lt_t_ltequalto_10y;
	private BigDecimal	r78_10y_lt_t_ltequalto_15y;
	private BigDecimal	r78_15y_lt_t_ltequalto_20y;
	private BigDecimal	r78_tl_20y;
	private BigDecimal	r78_nonsensitive;
	private BigDecimal	r78_total_rsl;
	private BigDecimal	r78_total;
	private String	r79_product;
	private BigDecimal	r79_tequalon;
	private BigDecimal	r79_on_t_equalto_1m;
	private BigDecimal	r79_1m_t_equalto_3m;
	private BigDecimal	r79_3m_t_equalto_6m;
	private BigDecimal	r79_6m_t_equalto_9m;
	private BigDecimal	r79_9m_t_equalto_1y;
	private BigDecimal	r79_1y_t_equalto_1point5y;
	private BigDecimal	r79_1point5y_t_equalto_2y;
	private BigDecimal	r79_2y_t_equalto_3y;
	private BigDecimal	r79_3y_t_equalto_4y;
	private BigDecimal	r79_4y_lt_t_ltequalto_5y;
	private BigDecimal	r79_5y_lt_t_ltequalto_6y;
	private BigDecimal	r79_6y_lt_t_ltequalto_7y;
	private BigDecimal	r79_7y_lt_t_ltequalto_8y;
	private BigDecimal	r79_8y_lt_t_ltequalto_9y;
	private BigDecimal	r79_9y_lt_t_ltequalto_10y;
	private BigDecimal	r79_10y_lt_t_ltequalto_15y;
	private BigDecimal	r79_15y_lt_t_ltequalto_20y;
	private BigDecimal	r79_tl_20y;
	private BigDecimal	r79_nonsensitive;
	private BigDecimal	r79_total_rsl;
	private BigDecimal	r79_total;
	private String	r80_product;
	private BigDecimal	r80_tequalon;
	private BigDecimal	r80_on_t_equalto_1m;
	private BigDecimal	r80_1m_t_equalto_3m;
	private BigDecimal	r80_3m_t_equalto_6m;
	private BigDecimal	r80_6m_t_equalto_9m;
	private BigDecimal	r80_9m_t_equalto_1y;
	private BigDecimal	r80_1y_t_equalto_1point5y;
	private BigDecimal	r80_1point5y_t_equalto_2y;
	private BigDecimal	r80_2y_t_equalto_3y;
	private BigDecimal	r80_3y_t_equalto_4y;
	private BigDecimal	r80_4y_lt_t_ltequalto_5y;
	private BigDecimal	r80_5y_lt_t_ltequalto_6y;
	private BigDecimal	r80_6y_lt_t_ltequalto_7y;
	private BigDecimal	r80_7y_lt_t_ltequalto_8y;
	private BigDecimal	r80_8y_lt_t_ltequalto_9y;
	private BigDecimal	r80_9y_lt_t_ltequalto_10y;
	private BigDecimal	r80_10y_lt_t_ltequalto_15y;
	private BigDecimal	r80_15y_lt_t_ltequalto_20y;
	private BigDecimal	r80_tl_20y;
	private BigDecimal	r80_nonsensitive;
	private BigDecimal	r80_total_rsl;
	private BigDecimal	r80_total;
	private String	r81_product;
	private BigDecimal	r81_tequalon;
	private BigDecimal	r81_on_t_equalto_1m;
	private BigDecimal	r81_1m_t_equalto_3m;
	private BigDecimal	r81_3m_t_equalto_6m;
	private BigDecimal	r81_6m_t_equalto_9m;
	private BigDecimal	r81_9m_t_equalto_1y;
	private BigDecimal	r81_1y_t_equalto_1point5y;
	private BigDecimal	r81_1point5y_t_equalto_2y;
	private BigDecimal	r81_2y_t_equalto_3y;
	private BigDecimal	r81_3y_t_equalto_4y;
	private BigDecimal	r81_4y_lt_t_ltequalto_5y;
	private BigDecimal	r81_5y_lt_t_ltequalto_6y;
	private BigDecimal	r81_6y_lt_t_ltequalto_7y;
	private BigDecimal	r81_7y_lt_t_ltequalto_8y;
	private BigDecimal	r81_8y_lt_t_ltequalto_9y;
	private BigDecimal	r81_9y_lt_t_ltequalto_10y;
	private BigDecimal	r81_10y_lt_t_ltequalto_15y;
	private BigDecimal	r81_15y_lt_t_ltequalto_20y;
	private BigDecimal	r81_tl_20y;
	private BigDecimal	r81_nonsensitive;
	private BigDecimal	r81_total_rsl;
	private BigDecimal	r81_total;
	private String	r82_product;
	private BigDecimal	r82_tequalon;
	private BigDecimal	r82_on_t_equalto_1m;
	private BigDecimal	r82_1m_t_equalto_3m;
	private BigDecimal	r82_3m_t_equalto_6m;
	private BigDecimal	r82_6m_t_equalto_9m;
	private BigDecimal	r82_9m_t_equalto_1y;
	private BigDecimal	r82_1y_t_equalto_1point5y;
	private BigDecimal	r82_1point5y_t_equalto_2y;
	private BigDecimal	r82_2y_t_equalto_3y;
	private BigDecimal	r82_3y_t_equalto_4y;
	private BigDecimal	r82_4y_lt_t_ltequalto_5y;
	private BigDecimal	r82_5y_lt_t_ltequalto_6y;
	private BigDecimal	r82_6y_lt_t_ltequalto_7y;
	private BigDecimal	r82_7y_lt_t_ltequalto_8y;
	private BigDecimal	r82_8y_lt_t_ltequalto_9y;
	private BigDecimal	r82_9y_lt_t_ltequalto_10y;
	private BigDecimal	r82_10y_lt_t_ltequalto_15y;
	private BigDecimal	r82_15y_lt_t_ltequalto_20y;
	private BigDecimal	r82_tl_20y;
	private BigDecimal	r82_nonsensitive;
	private BigDecimal	r82_total_rsl;
	private BigDecimal	r82_total;
	private String	r83_product;
	private BigDecimal	r83_tequalon;
	private BigDecimal	r83_on_t_equalto_1m;
	private BigDecimal	r83_1m_t_equalto_3m;
	private BigDecimal	r83_3m_t_equalto_6m;
	private BigDecimal	r83_6m_t_equalto_9m;
	private BigDecimal	r83_9m_t_equalto_1y;
	private BigDecimal	r83_1y_t_equalto_1point5y;
	private BigDecimal	r83_1point5y_t_equalto_2y;
	private BigDecimal	r83_2y_t_equalto_3y;
	private BigDecimal	r83_3y_t_equalto_4y;
	private BigDecimal	r83_4y_lt_t_ltequalto_5y;
	private BigDecimal	r83_5y_lt_t_ltequalto_6y;
	private BigDecimal	r83_6y_lt_t_ltequalto_7y;
	private BigDecimal	r83_7y_lt_t_ltequalto_8y;
	private BigDecimal	r83_8y_lt_t_ltequalto_9y;
	private BigDecimal	r83_9y_lt_t_ltequalto_10y;
	private BigDecimal	r83_10y_lt_t_ltequalto_15y;
	private BigDecimal	r83_15y_lt_t_ltequalto_20y;
	private BigDecimal	r83_tl_20y;
	private BigDecimal	r83_nonsensitive;
	private BigDecimal	r83_total_rsl;
	private BigDecimal	r83_total;
	private String	r84_product;
	private BigDecimal	r84_tequalon;
	private BigDecimal	r84_on_t_equalto_1m;
	private BigDecimal	r84_1m_t_equalto_3m;
	private BigDecimal	r84_3m_t_equalto_6m;
	private BigDecimal	r84_6m_t_equalto_9m;
	private BigDecimal	r84_9m_t_equalto_1y;
	private BigDecimal	r84_1y_t_equalto_1point5y;
	private BigDecimal	r84_1point5y_t_equalto_2y;
	private BigDecimal	r84_2y_t_equalto_3y;
	private BigDecimal	r84_3y_t_equalto_4y;
	private BigDecimal	r84_4y_lt_t_ltequalto_5y;
	private BigDecimal	r84_5y_lt_t_ltequalto_6y;
	private BigDecimal	r84_6y_lt_t_ltequalto_7y;
	private BigDecimal	r84_7y_lt_t_ltequalto_8y;
	private BigDecimal	r84_8y_lt_t_ltequalto_9y;
	private BigDecimal	r84_9y_lt_t_ltequalto_10y;
	private BigDecimal	r84_10y_lt_t_ltequalto_15y;
	private BigDecimal	r84_15y_lt_t_ltequalto_20y;
	private BigDecimal	r84_tl_20y;
	private BigDecimal	r84_nonsensitive;
	private BigDecimal	r84_total_rsl;
	private BigDecimal	r84_total;
	private String	r85_product;
	private BigDecimal	r85_tequalon;
	private BigDecimal	r85_on_t_equalto_1m;
	private BigDecimal	r85_1m_t_equalto_3m;
	private BigDecimal	r85_3m_t_equalto_6m;
	private BigDecimal	r85_6m_t_equalto_9m;
	private BigDecimal	r85_9m_t_equalto_1y;
	private BigDecimal	r85_1y_t_equalto_1point5y;
	private BigDecimal	r85_1point5y_t_equalto_2y;
	private BigDecimal	r85_2y_t_equalto_3y;
	private BigDecimal	r85_3y_t_equalto_4y;
	private BigDecimal	r85_4y_lt_t_ltequalto_5y;
	private BigDecimal	r85_5y_lt_t_ltequalto_6y;
	private BigDecimal	r85_6y_lt_t_ltequalto_7y;
	private BigDecimal	r85_7y_lt_t_ltequalto_8y;
	private BigDecimal	r85_8y_lt_t_ltequalto_9y;
	private BigDecimal	r85_9y_lt_t_ltequalto_10y;
	private BigDecimal	r85_10y_lt_t_ltequalto_15y;
	private BigDecimal	r85_15y_lt_t_ltequalto_20y;
	private BigDecimal	r85_tl_20y;
	private BigDecimal	r85_nonsensitive;
	private BigDecimal	r85_total_rsl;
	private BigDecimal	r85_total;
	private String	r86_product;
	private BigDecimal	r86_tequalon;
	private BigDecimal	r86_on_t_equalto_1m;
	private BigDecimal	r86_1m_t_equalto_3m;
	private BigDecimal	r86_3m_t_equalto_6m;
	private BigDecimal	r86_6m_t_equalto_9m;
	private BigDecimal	r86_9m_t_equalto_1y;
	private BigDecimal	r86_1y_t_equalto_1point5y;
	private BigDecimal	r86_1point5y_t_equalto_2y;
	private BigDecimal	r86_2y_t_equalto_3y;
	private BigDecimal	r86_3y_t_equalto_4y;
	private BigDecimal	r86_4y_lt_t_ltequalto_5y;
	private BigDecimal	r86_5y_lt_t_ltequalto_6y;
	private BigDecimal	r86_6y_lt_t_ltequalto_7y;
	private BigDecimal	r86_7y_lt_t_ltequalto_8y;
	private BigDecimal	r86_8y_lt_t_ltequalto_9y;
	private BigDecimal	r86_9y_lt_t_ltequalto_10y;
	private BigDecimal	r86_10y_lt_t_ltequalto_15y;
	private BigDecimal	r86_15y_lt_t_ltequalto_20y;
	private BigDecimal	r86_tl_20y;
	private BigDecimal	r86_nonsensitive;
	private BigDecimal	r86_total_rsl;
	private BigDecimal	r86_total;
	private String	r87_product;
	private BigDecimal	r87_tequalon;
	private BigDecimal	r87_on_t_equalto_1m;
	private BigDecimal	r87_1m_t_equalto_3m;
	private BigDecimal	r87_3m_t_equalto_6m;
	private BigDecimal	r87_6m_t_equalto_9m;
	private BigDecimal	r87_9m_t_equalto_1y;
	private BigDecimal	r87_1y_t_equalto_1point5y;
	private BigDecimal	r87_1point5y_t_equalto_2y;
	private BigDecimal	r87_2y_t_equalto_3y;
	private BigDecimal	r87_3y_t_equalto_4y;
	private BigDecimal	r87_4y_lt_t_ltequalto_5y;
	private BigDecimal	r87_5y_lt_t_ltequalto_6y;
	private BigDecimal	r87_6y_lt_t_ltequalto_7y;
	private BigDecimal	r87_7y_lt_t_ltequalto_8y;
	private BigDecimal	r87_8y_lt_t_ltequalto_9y;
	private BigDecimal	r87_9y_lt_t_ltequalto_10y;
	private BigDecimal	r87_10y_lt_t_ltequalto_15y;
	private BigDecimal	r87_15y_lt_t_ltequalto_20y;
	private BigDecimal	r87_tl_20y;
	private BigDecimal	r87_nonsensitive;
	private BigDecimal	r87_total_rsl;
	private BigDecimal	r87_total;
	private String	r88_product;
	private BigDecimal	r88_tequalon;
	private BigDecimal	r88_on_t_equalto_1m;
	private BigDecimal	r88_1m_t_equalto_3m;
	private BigDecimal	r88_3m_t_equalto_6m;
	private BigDecimal	r88_6m_t_equalto_9m;
	private BigDecimal	r88_9m_t_equalto_1y;
	private BigDecimal	r88_1y_t_equalto_1point5y;
	private BigDecimal	r88_1point5y_t_equalto_2y;
	private BigDecimal	r88_2y_t_equalto_3y;
	private BigDecimal	r88_3y_t_equalto_4y;
	private BigDecimal	r88_4y_lt_t_ltequalto_5y;
	private BigDecimal	r88_5y_lt_t_ltequalto_6y;
	private BigDecimal	r88_6y_lt_t_ltequalto_7y;
	private BigDecimal	r88_7y_lt_t_ltequalto_8y;
	private BigDecimal	r88_8y_lt_t_ltequalto_9y;
	private BigDecimal	r88_9y_lt_t_ltequalto_10y;
	private BigDecimal	r88_10y_lt_t_ltequalto_15y;
	private BigDecimal	r88_15y_lt_t_ltequalto_20y;
	private BigDecimal	r88_tl_20y;
	private BigDecimal	r88_nonsensitive;
	private BigDecimal	r88_total_rsl;
	private BigDecimal	r88_total;
	private String	r89_product;
	private BigDecimal	r89_tequalon;
	private BigDecimal	r89_on_t_equalto_1m;
	private BigDecimal	r89_1m_t_equalto_3m;
	private BigDecimal	r89_3m_t_equalto_6m;
	private BigDecimal	r89_6m_t_equalto_9m;
	private BigDecimal	r89_9m_t_equalto_1y;
	private BigDecimal	r89_1y_t_equalto_1point5y;
	private BigDecimal	r89_1point5y_t_equalto_2y;
	private BigDecimal	r89_2y_t_equalto_3y;
	private BigDecimal	r89_3y_t_equalto_4y;
	private BigDecimal	r89_4y_lt_t_ltequalto_5y;
	private BigDecimal	r89_5y_lt_t_ltequalto_6y;
	private BigDecimal	r89_6y_lt_t_ltequalto_7y;
	private BigDecimal	r89_7y_lt_t_ltequalto_8y;
	private BigDecimal	r89_8y_lt_t_ltequalto_9y;
	private BigDecimal	r89_9y_lt_t_ltequalto_10y;
	private BigDecimal	r89_10y_lt_t_ltequalto_15y;
	private BigDecimal	r89_15y_lt_t_ltequalto_20y;
	private BigDecimal	r89_tl_20y;
	private BigDecimal	r89_nonsensitive;
	private BigDecimal	r89_total_rsl;
	private BigDecimal	r89_total;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	report_date;

	private Date	report_from_date;
	private Date	report_to_date;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	private String	report_code;
	private Date	report_submit_date;
	public String getR50_product() {
		return r50_product;
	}
	public void setR50_product(String r50_product) {
		this.r50_product = r50_product;
	}
	public BigDecimal getR50_tequalon() {
		return r50_tequalon;
	}
	public void setR50_tequalon(BigDecimal r50_tequalon) {
		this.r50_tequalon = r50_tequalon;
	}
	public BigDecimal getR50_on_t_equalto_1m() {
		return r50_on_t_equalto_1m;
	}
	public void setR50_on_t_equalto_1m(BigDecimal r50_on_t_equalto_1m) {
		this.r50_on_t_equalto_1m = r50_on_t_equalto_1m;
	}
	public BigDecimal getR50_1m_t_equalto_3m() {
		return r50_1m_t_equalto_3m;
	}
	public void setR50_1m_t_equalto_3m(BigDecimal r50_1m_t_equalto_3m) {
		this.r50_1m_t_equalto_3m = r50_1m_t_equalto_3m;
	}
	public BigDecimal getR50_3m_t_equalto_6m() {
		return r50_3m_t_equalto_6m;
	}
	public void setR50_3m_t_equalto_6m(BigDecimal r50_3m_t_equalto_6m) {
		this.r50_3m_t_equalto_6m = r50_3m_t_equalto_6m;
	}
	public BigDecimal getR50_6m_t_equalto_9m() {
		return r50_6m_t_equalto_9m;
	}
	public void setR50_6m_t_equalto_9m(BigDecimal r50_6m_t_equalto_9m) {
		this.r50_6m_t_equalto_9m = r50_6m_t_equalto_9m;
	}
	public BigDecimal getR50_9m_t_equalto_1y() {
		return r50_9m_t_equalto_1y;
	}
	public void setR50_9m_t_equalto_1y(BigDecimal r50_9m_t_equalto_1y) {
		this.r50_9m_t_equalto_1y = r50_9m_t_equalto_1y;
	}
	public BigDecimal getR50_1y_t_equalto_1point5y() {
		return r50_1y_t_equalto_1point5y;
	}
	public void setR50_1y_t_equalto_1point5y(BigDecimal r50_1y_t_equalto_1point5y) {
		this.r50_1y_t_equalto_1point5y = r50_1y_t_equalto_1point5y;
	}
	public BigDecimal getR50_1point5y_t_equalto_2y() {
		return r50_1point5y_t_equalto_2y;
	}
	public void setR50_1point5y_t_equalto_2y(BigDecimal r50_1point5y_t_equalto_2y) {
		this.r50_1point5y_t_equalto_2y = r50_1point5y_t_equalto_2y;
	}
	public BigDecimal getR50_2y_t_equalto_3y() {
		return r50_2y_t_equalto_3y;
	}
	public void setR50_2y_t_equalto_3y(BigDecimal r50_2y_t_equalto_3y) {
		this.r50_2y_t_equalto_3y = r50_2y_t_equalto_3y;
	}
	public BigDecimal getR50_3y_t_equalto_4y() {
		return r50_3y_t_equalto_4y;
	}
	public void setR50_3y_t_equalto_4y(BigDecimal r50_3y_t_equalto_4y) {
		this.r50_3y_t_equalto_4y = r50_3y_t_equalto_4y;
	}
	public BigDecimal getR50_4y_lt_t_ltequalto_5y() {
		return r50_4y_lt_t_ltequalto_5y;
	}
	public void setR50_4y_lt_t_ltequalto_5y(BigDecimal r50_4y_lt_t_ltequalto_5y) {
		this.r50_4y_lt_t_ltequalto_5y = r50_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR50_5y_lt_t_ltequalto_6y() {
		return r50_5y_lt_t_ltequalto_6y;
	}
	public void setR50_5y_lt_t_ltequalto_6y(BigDecimal r50_5y_lt_t_ltequalto_6y) {
		this.r50_5y_lt_t_ltequalto_6y = r50_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR50_6y_lt_t_ltequalto_7y() {
		return r50_6y_lt_t_ltequalto_7y;
	}
	public void setR50_6y_lt_t_ltequalto_7y(BigDecimal r50_6y_lt_t_ltequalto_7y) {
		this.r50_6y_lt_t_ltequalto_7y = r50_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR50_7y_lt_t_ltequalto_8y() {
		return r50_7y_lt_t_ltequalto_8y;
	}
	public void setR50_7y_lt_t_ltequalto_8y(BigDecimal r50_7y_lt_t_ltequalto_8y) {
		this.r50_7y_lt_t_ltequalto_8y = r50_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR50_8y_lt_t_ltequalto_9y() {
		return r50_8y_lt_t_ltequalto_9y;
	}
	public void setR50_8y_lt_t_ltequalto_9y(BigDecimal r50_8y_lt_t_ltequalto_9y) {
		this.r50_8y_lt_t_ltequalto_9y = r50_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR50_9y_lt_t_ltequalto_10y() {
		return r50_9y_lt_t_ltequalto_10y;
	}
	public void setR50_9y_lt_t_ltequalto_10y(BigDecimal r50_9y_lt_t_ltequalto_10y) {
		this.r50_9y_lt_t_ltequalto_10y = r50_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR50_10y_lt_t_ltequalto_15y() {
		return r50_10y_lt_t_ltequalto_15y;
	}
	public void setR50_10y_lt_t_ltequalto_15y(BigDecimal r50_10y_lt_t_ltequalto_15y) {
		this.r50_10y_lt_t_ltequalto_15y = r50_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR50_15y_lt_t_ltequalto_20y() {
		return r50_15y_lt_t_ltequalto_20y;
	}
	public void setR50_15y_lt_t_ltequalto_20y(BigDecimal r50_15y_lt_t_ltequalto_20y) {
		this.r50_15y_lt_t_ltequalto_20y = r50_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR50_tl_20y() {
		return r50_tl_20y;
	}
	public void setR50_tl_20y(BigDecimal r50_tl_20y) {
		this.r50_tl_20y = r50_tl_20y;
	}
	public BigDecimal getR50_nonsensitive() {
		return r50_nonsensitive;
	}
	public void setR50_nonsensitive(BigDecimal r50_nonsensitive) {
		this.r50_nonsensitive = r50_nonsensitive;
	}
	public BigDecimal getR50_total_rsl() {
		return r50_total_rsl;
	}
	public void setR50_total_rsl(BigDecimal r50_total_rsl) {
		this.r50_total_rsl = r50_total_rsl;
	}
	public BigDecimal getR50_total() {
		return r50_total;
	}
	public void setR50_total(BigDecimal r50_total) {
		this.r50_total = r50_total;
	}
	public String getR51_product() {
		return r51_product;
	}
	public void setR51_product(String r51_product) {
		this.r51_product = r51_product;
	}
	public BigDecimal getR51_tequalon() {
		return r51_tequalon;
	}
	public void setR51_tequalon(BigDecimal r51_tequalon) {
		this.r51_tequalon = r51_tequalon;
	}
	public BigDecimal getR51_on_t_equalto_1m() {
		return r51_on_t_equalto_1m;
	}
	public void setR51_on_t_equalto_1m(BigDecimal r51_on_t_equalto_1m) {
		this.r51_on_t_equalto_1m = r51_on_t_equalto_1m;
	}
	public BigDecimal getR51_1m_t_equalto_3m() {
		return r51_1m_t_equalto_3m;
	}
	public void setR51_1m_t_equalto_3m(BigDecimal r51_1m_t_equalto_3m) {
		this.r51_1m_t_equalto_3m = r51_1m_t_equalto_3m;
	}
	public BigDecimal getR51_3m_t_equalto_6m() {
		return r51_3m_t_equalto_6m;
	}
	public void setR51_3m_t_equalto_6m(BigDecimal r51_3m_t_equalto_6m) {
		this.r51_3m_t_equalto_6m = r51_3m_t_equalto_6m;
	}
	public BigDecimal getR51_6m_t_equalto_9m() {
		return r51_6m_t_equalto_9m;
	}
	public void setR51_6m_t_equalto_9m(BigDecimal r51_6m_t_equalto_9m) {
		this.r51_6m_t_equalto_9m = r51_6m_t_equalto_9m;
	}
	public BigDecimal getR51_9m_t_equalto_1y() {
		return r51_9m_t_equalto_1y;
	}
	public void setR51_9m_t_equalto_1y(BigDecimal r51_9m_t_equalto_1y) {
		this.r51_9m_t_equalto_1y = r51_9m_t_equalto_1y;
	}
	public BigDecimal getR51_1y_t_equalto_1point5y() {
		return r51_1y_t_equalto_1point5y;
	}
	public void setR51_1y_t_equalto_1point5y(BigDecimal r51_1y_t_equalto_1point5y) {
		this.r51_1y_t_equalto_1point5y = r51_1y_t_equalto_1point5y;
	}
	public BigDecimal getR51_1point5y_t_equalto_2y() {
		return r51_1point5y_t_equalto_2y;
	}
	public void setR51_1point5y_t_equalto_2y(BigDecimal r51_1point5y_t_equalto_2y) {
		this.r51_1point5y_t_equalto_2y = r51_1point5y_t_equalto_2y;
	}
	public BigDecimal getR51_2y_t_equalto_3y() {
		return r51_2y_t_equalto_3y;
	}
	public void setR51_2y_t_equalto_3y(BigDecimal r51_2y_t_equalto_3y) {
		this.r51_2y_t_equalto_3y = r51_2y_t_equalto_3y;
	}
	public BigDecimal getR51_3y_t_equalto_4y() {
		return r51_3y_t_equalto_4y;
	}
	public void setR51_3y_t_equalto_4y(BigDecimal r51_3y_t_equalto_4y) {
		this.r51_3y_t_equalto_4y = r51_3y_t_equalto_4y;
	}
	public BigDecimal getR51_4y_lt_t_ltequalto_5y() {
		return r51_4y_lt_t_ltequalto_5y;
	}
	public void setR51_4y_lt_t_ltequalto_5y(BigDecimal r51_4y_lt_t_ltequalto_5y) {
		this.r51_4y_lt_t_ltequalto_5y = r51_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR51_5y_lt_t_ltequalto_6y() {
		return r51_5y_lt_t_ltequalto_6y;
	}
	public void setR51_5y_lt_t_ltequalto_6y(BigDecimal r51_5y_lt_t_ltequalto_6y) {
		this.r51_5y_lt_t_ltequalto_6y = r51_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR51_6y_lt_t_ltequalto_7y() {
		return r51_6y_lt_t_ltequalto_7y;
	}
	public void setR51_6y_lt_t_ltequalto_7y(BigDecimal r51_6y_lt_t_ltequalto_7y) {
		this.r51_6y_lt_t_ltequalto_7y = r51_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR51_7y_lt_t_ltequalto_8y() {
		return r51_7y_lt_t_ltequalto_8y;
	}
	public void setR51_7y_lt_t_ltequalto_8y(BigDecimal r51_7y_lt_t_ltequalto_8y) {
		this.r51_7y_lt_t_ltequalto_8y = r51_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR51_8y_lt_t_ltequalto_9y() {
		return r51_8y_lt_t_ltequalto_9y;
	}
	public void setR51_8y_lt_t_ltequalto_9y(BigDecimal r51_8y_lt_t_ltequalto_9y) {
		this.r51_8y_lt_t_ltequalto_9y = r51_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR51_9y_lt_t_ltequalto_10y() {
		return r51_9y_lt_t_ltequalto_10y;
	}
	public void setR51_9y_lt_t_ltequalto_10y(BigDecimal r51_9y_lt_t_ltequalto_10y) {
		this.r51_9y_lt_t_ltequalto_10y = r51_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR51_10y_lt_t_ltequalto_15y() {
		return r51_10y_lt_t_ltequalto_15y;
	}
	public void setR51_10y_lt_t_ltequalto_15y(BigDecimal r51_10y_lt_t_ltequalto_15y) {
		this.r51_10y_lt_t_ltequalto_15y = r51_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR51_15y_lt_t_ltequalto_20y() {
		return r51_15y_lt_t_ltequalto_20y;
	}
	public void setR51_15y_lt_t_ltequalto_20y(BigDecimal r51_15y_lt_t_ltequalto_20y) {
		this.r51_15y_lt_t_ltequalto_20y = r51_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR51_tl_20y() {
		return r51_tl_20y;
	}
	public void setR51_tl_20y(BigDecimal r51_tl_20y) {
		this.r51_tl_20y = r51_tl_20y;
	}
	public BigDecimal getR51_nonsensitive() {
		return r51_nonsensitive;
	}
	public void setR51_nonsensitive(BigDecimal r51_nonsensitive) {
		this.r51_nonsensitive = r51_nonsensitive;
	}
	public BigDecimal getR51_total_rsl() {
		return r51_total_rsl;
	}
	public void setR51_total_rsl(BigDecimal r51_total_rsl) {
		this.r51_total_rsl = r51_total_rsl;
	}
	public BigDecimal getR51_total() {
		return r51_total;
	}
	public void setR51_total(BigDecimal r51_total) {
		this.r51_total = r51_total;
	}
	public String getR52_product() {
		return r52_product;
	}
	public void setR52_product(String r52_product) {
		this.r52_product = r52_product;
	}
	public BigDecimal getR52_tequalon() {
		return r52_tequalon;
	}
	public void setR52_tequalon(BigDecimal r52_tequalon) {
		this.r52_tequalon = r52_tequalon;
	}
	public BigDecimal getR52_on_t_equalto_1m() {
		return r52_on_t_equalto_1m;
	}
	public void setR52_on_t_equalto_1m(BigDecimal r52_on_t_equalto_1m) {
		this.r52_on_t_equalto_1m = r52_on_t_equalto_1m;
	}
	public BigDecimal getR52_1m_t_equalto_3m() {
		return r52_1m_t_equalto_3m;
	}
	public void setR52_1m_t_equalto_3m(BigDecimal r52_1m_t_equalto_3m) {
		this.r52_1m_t_equalto_3m = r52_1m_t_equalto_3m;
	}
	public BigDecimal getR52_3m_t_equalto_6m() {
		return r52_3m_t_equalto_6m;
	}
	public void setR52_3m_t_equalto_6m(BigDecimal r52_3m_t_equalto_6m) {
		this.r52_3m_t_equalto_6m = r52_3m_t_equalto_6m;
	}
	public BigDecimal getR52_6m_t_equalto_9m() {
		return r52_6m_t_equalto_9m;
	}
	public void setR52_6m_t_equalto_9m(BigDecimal r52_6m_t_equalto_9m) {
		this.r52_6m_t_equalto_9m = r52_6m_t_equalto_9m;
	}
	public BigDecimal getR52_9m_t_equalto_1y() {
		return r52_9m_t_equalto_1y;
	}
	public void setR52_9m_t_equalto_1y(BigDecimal r52_9m_t_equalto_1y) {
		this.r52_9m_t_equalto_1y = r52_9m_t_equalto_1y;
	}
	public BigDecimal getR52_1y_t_equalto_1point5y() {
		return r52_1y_t_equalto_1point5y;
	}
	public void setR52_1y_t_equalto_1point5y(BigDecimal r52_1y_t_equalto_1point5y) {
		this.r52_1y_t_equalto_1point5y = r52_1y_t_equalto_1point5y;
	}
	public BigDecimal getR52_1point5y_t_equalto_2y() {
		return r52_1point5y_t_equalto_2y;
	}
	public void setR52_1point5y_t_equalto_2y(BigDecimal r52_1point5y_t_equalto_2y) {
		this.r52_1point5y_t_equalto_2y = r52_1point5y_t_equalto_2y;
	}
	public BigDecimal getR52_2y_t_equalto_3y() {
		return r52_2y_t_equalto_3y;
	}
	public void setR52_2y_t_equalto_3y(BigDecimal r52_2y_t_equalto_3y) {
		this.r52_2y_t_equalto_3y = r52_2y_t_equalto_3y;
	}
	public BigDecimal getR52_3y_t_equalto_4y() {
		return r52_3y_t_equalto_4y;
	}
	public void setR52_3y_t_equalto_4y(BigDecimal r52_3y_t_equalto_4y) {
		this.r52_3y_t_equalto_4y = r52_3y_t_equalto_4y;
	}
	public BigDecimal getR52_4y_lt_t_ltequalto_5y() {
		return r52_4y_lt_t_ltequalto_5y;
	}
	public void setR52_4y_lt_t_ltequalto_5y(BigDecimal r52_4y_lt_t_ltequalto_5y) {
		this.r52_4y_lt_t_ltequalto_5y = r52_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR52_5y_lt_t_ltequalto_6y() {
		return r52_5y_lt_t_ltequalto_6y;
	}
	public void setR52_5y_lt_t_ltequalto_6y(BigDecimal r52_5y_lt_t_ltequalto_6y) {
		this.r52_5y_lt_t_ltequalto_6y = r52_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR52_6y_lt_t_ltequalto_7y() {
		return r52_6y_lt_t_ltequalto_7y;
	}
	public void setR52_6y_lt_t_ltequalto_7y(BigDecimal r52_6y_lt_t_ltequalto_7y) {
		this.r52_6y_lt_t_ltequalto_7y = r52_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR52_7y_lt_t_ltequalto_8y() {
		return r52_7y_lt_t_ltequalto_8y;
	}
	public void setR52_7y_lt_t_ltequalto_8y(BigDecimal r52_7y_lt_t_ltequalto_8y) {
		this.r52_7y_lt_t_ltequalto_8y = r52_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR52_8y_lt_t_ltequalto_9y() {
		return r52_8y_lt_t_ltequalto_9y;
	}
	public void setR52_8y_lt_t_ltequalto_9y(BigDecimal r52_8y_lt_t_ltequalto_9y) {
		this.r52_8y_lt_t_ltequalto_9y = r52_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR52_9y_lt_t_ltequalto_10y() {
		return r52_9y_lt_t_ltequalto_10y;
	}
	public void setR52_9y_lt_t_ltequalto_10y(BigDecimal r52_9y_lt_t_ltequalto_10y) {
		this.r52_9y_lt_t_ltequalto_10y = r52_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR52_10y_lt_t_ltequalto_15y() {
		return r52_10y_lt_t_ltequalto_15y;
	}
	public void setR52_10y_lt_t_ltequalto_15y(BigDecimal r52_10y_lt_t_ltequalto_15y) {
		this.r52_10y_lt_t_ltequalto_15y = r52_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR52_15y_lt_t_ltequalto_20y() {
		return r52_15y_lt_t_ltequalto_20y;
	}
	public void setR52_15y_lt_t_ltequalto_20y(BigDecimal r52_15y_lt_t_ltequalto_20y) {
		this.r52_15y_lt_t_ltequalto_20y = r52_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR52_tl_20y() {
		return r52_tl_20y;
	}
	public void setR52_tl_20y(BigDecimal r52_tl_20y) {
		this.r52_tl_20y = r52_tl_20y;
	}
	public BigDecimal getR52_nonsensitive() {
		return r52_nonsensitive;
	}
	public void setR52_nonsensitive(BigDecimal r52_nonsensitive) {
		this.r52_nonsensitive = r52_nonsensitive;
	}
	public BigDecimal getR52_total_rsl() {
		return r52_total_rsl;
	}
	public void setR52_total_rsl(BigDecimal r52_total_rsl) {
		this.r52_total_rsl = r52_total_rsl;
	}
	public BigDecimal getR52_total() {
		return r52_total;
	}
	public void setR52_total(BigDecimal r52_total) {
		this.r52_total = r52_total;
	}
	public String getR53_product() {
		return r53_product;
	}
	public void setR53_product(String r53_product) {
		this.r53_product = r53_product;
	}
	public BigDecimal getR53_tequalon() {
		return r53_tequalon;
	}
	public void setR53_tequalon(BigDecimal r53_tequalon) {
		this.r53_tequalon = r53_tequalon;
	}
	public BigDecimal getR53_on_t_equalto_1m() {
		return r53_on_t_equalto_1m;
	}
	public void setR53_on_t_equalto_1m(BigDecimal r53_on_t_equalto_1m) {
		this.r53_on_t_equalto_1m = r53_on_t_equalto_1m;
	}
	public BigDecimal getR53_1m_t_equalto_3m() {
		return r53_1m_t_equalto_3m;
	}
	public void setR53_1m_t_equalto_3m(BigDecimal r53_1m_t_equalto_3m) {
		this.r53_1m_t_equalto_3m = r53_1m_t_equalto_3m;
	}
	public BigDecimal getR53_3m_t_equalto_6m() {
		return r53_3m_t_equalto_6m;
	}
	public void setR53_3m_t_equalto_6m(BigDecimal r53_3m_t_equalto_6m) {
		this.r53_3m_t_equalto_6m = r53_3m_t_equalto_6m;
	}
	public BigDecimal getR53_6m_t_equalto_9m() {
		return r53_6m_t_equalto_9m;
	}
	public void setR53_6m_t_equalto_9m(BigDecimal r53_6m_t_equalto_9m) {
		this.r53_6m_t_equalto_9m = r53_6m_t_equalto_9m;
	}
	public BigDecimal getR53_9m_t_equalto_1y() {
		return r53_9m_t_equalto_1y;
	}
	public void setR53_9m_t_equalto_1y(BigDecimal r53_9m_t_equalto_1y) {
		this.r53_9m_t_equalto_1y = r53_9m_t_equalto_1y;
	}
	public BigDecimal getR53_1y_t_equalto_1point5y() {
		return r53_1y_t_equalto_1point5y;
	}
	public void setR53_1y_t_equalto_1point5y(BigDecimal r53_1y_t_equalto_1point5y) {
		this.r53_1y_t_equalto_1point5y = r53_1y_t_equalto_1point5y;
	}
	public BigDecimal getR53_1point5y_t_equalto_2y() {
		return r53_1point5y_t_equalto_2y;
	}
	public void setR53_1point5y_t_equalto_2y(BigDecimal r53_1point5y_t_equalto_2y) {
		this.r53_1point5y_t_equalto_2y = r53_1point5y_t_equalto_2y;
	}
	public BigDecimal getR53_2y_t_equalto_3y() {
		return r53_2y_t_equalto_3y;
	}
	public void setR53_2y_t_equalto_3y(BigDecimal r53_2y_t_equalto_3y) {
		this.r53_2y_t_equalto_3y = r53_2y_t_equalto_3y;
	}
	public BigDecimal getR53_3y_t_equalto_4y() {
		return r53_3y_t_equalto_4y;
	}
	public void setR53_3y_t_equalto_4y(BigDecimal r53_3y_t_equalto_4y) {
		this.r53_3y_t_equalto_4y = r53_3y_t_equalto_4y;
	}
	public BigDecimal getR53_4y_lt_t_ltequalto_5y() {
		return r53_4y_lt_t_ltequalto_5y;
	}
	public void setR53_4y_lt_t_ltequalto_5y(BigDecimal r53_4y_lt_t_ltequalto_5y) {
		this.r53_4y_lt_t_ltequalto_5y = r53_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR53_5y_lt_t_ltequalto_6y() {
		return r53_5y_lt_t_ltequalto_6y;
	}
	public void setR53_5y_lt_t_ltequalto_6y(BigDecimal r53_5y_lt_t_ltequalto_6y) {
		this.r53_5y_lt_t_ltequalto_6y = r53_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR53_6y_lt_t_ltequalto_7y() {
		return r53_6y_lt_t_ltequalto_7y;
	}
	public void setR53_6y_lt_t_ltequalto_7y(BigDecimal r53_6y_lt_t_ltequalto_7y) {
		this.r53_6y_lt_t_ltequalto_7y = r53_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR53_7y_lt_t_ltequalto_8y() {
		return r53_7y_lt_t_ltequalto_8y;
	}
	public void setR53_7y_lt_t_ltequalto_8y(BigDecimal r53_7y_lt_t_ltequalto_8y) {
		this.r53_7y_lt_t_ltequalto_8y = r53_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR53_8y_lt_t_ltequalto_9y() {
		return r53_8y_lt_t_ltequalto_9y;
	}
	public void setR53_8y_lt_t_ltequalto_9y(BigDecimal r53_8y_lt_t_ltequalto_9y) {
		this.r53_8y_lt_t_ltequalto_9y = r53_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR53_9y_lt_t_ltequalto_10y() {
		return r53_9y_lt_t_ltequalto_10y;
	}
	public void setR53_9y_lt_t_ltequalto_10y(BigDecimal r53_9y_lt_t_ltequalto_10y) {
		this.r53_9y_lt_t_ltequalto_10y = r53_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR53_10y_lt_t_ltequalto_15y() {
		return r53_10y_lt_t_ltequalto_15y;
	}
	public void setR53_10y_lt_t_ltequalto_15y(BigDecimal r53_10y_lt_t_ltequalto_15y) {
		this.r53_10y_lt_t_ltequalto_15y = r53_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR53_15y_lt_t_ltequalto_20y() {
		return r53_15y_lt_t_ltequalto_20y;
	}
	public void setR53_15y_lt_t_ltequalto_20y(BigDecimal r53_15y_lt_t_ltequalto_20y) {
		this.r53_15y_lt_t_ltequalto_20y = r53_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR53_tl_20y() {
		return r53_tl_20y;
	}
	public void setR53_tl_20y(BigDecimal r53_tl_20y) {
		this.r53_tl_20y = r53_tl_20y;
	}
	public BigDecimal getR53_nonsensitive() {
		return r53_nonsensitive;
	}
	public void setR53_nonsensitive(BigDecimal r53_nonsensitive) {
		this.r53_nonsensitive = r53_nonsensitive;
	}
	public BigDecimal getR53_total_rsl() {
		return r53_total_rsl;
	}
	public void setR53_total_rsl(BigDecimal r53_total_rsl) {
		this.r53_total_rsl = r53_total_rsl;
	}
	public BigDecimal getR53_total() {
		return r53_total;
	}
	public void setR53_total(BigDecimal r53_total) {
		this.r53_total = r53_total;
	}
	public String getR54_product() {
		return r54_product;
	}
	public void setR54_product(String r54_product) {
		this.r54_product = r54_product;
	}
	public BigDecimal getR54_tequalon() {
		return r54_tequalon;
	}
	public void setR54_tequalon(BigDecimal r54_tequalon) {
		this.r54_tequalon = r54_tequalon;
	}
	public BigDecimal getR54_on_t_equalto_1m() {
		return r54_on_t_equalto_1m;
	}
	public void setR54_on_t_equalto_1m(BigDecimal r54_on_t_equalto_1m) {
		this.r54_on_t_equalto_1m = r54_on_t_equalto_1m;
	}
	public BigDecimal getR54_1m_t_equalto_3m() {
		return r54_1m_t_equalto_3m;
	}
	public void setR54_1m_t_equalto_3m(BigDecimal r54_1m_t_equalto_3m) {
		this.r54_1m_t_equalto_3m = r54_1m_t_equalto_3m;
	}
	public BigDecimal getR54_3m_t_equalto_6m() {
		return r54_3m_t_equalto_6m;
	}
	public void setR54_3m_t_equalto_6m(BigDecimal r54_3m_t_equalto_6m) {
		this.r54_3m_t_equalto_6m = r54_3m_t_equalto_6m;
	}
	public BigDecimal getR54_6m_t_equalto_9m() {
		return r54_6m_t_equalto_9m;
	}
	public void setR54_6m_t_equalto_9m(BigDecimal r54_6m_t_equalto_9m) {
		this.r54_6m_t_equalto_9m = r54_6m_t_equalto_9m;
	}
	public BigDecimal getR54_9m_t_equalto_1y() {
		return r54_9m_t_equalto_1y;
	}
	public void setR54_9m_t_equalto_1y(BigDecimal r54_9m_t_equalto_1y) {
		this.r54_9m_t_equalto_1y = r54_9m_t_equalto_1y;
	}
	public BigDecimal getR54_1y_t_equalto_1point5y() {
		return r54_1y_t_equalto_1point5y;
	}
	public void setR54_1y_t_equalto_1point5y(BigDecimal r54_1y_t_equalto_1point5y) {
		this.r54_1y_t_equalto_1point5y = r54_1y_t_equalto_1point5y;
	}
	public BigDecimal getR54_1point5y_t_equalto_2y() {
		return r54_1point5y_t_equalto_2y;
	}
	public void setR54_1point5y_t_equalto_2y(BigDecimal r54_1point5y_t_equalto_2y) {
		this.r54_1point5y_t_equalto_2y = r54_1point5y_t_equalto_2y;
	}
	public BigDecimal getR54_2y_t_equalto_3y() {
		return r54_2y_t_equalto_3y;
	}
	public void setR54_2y_t_equalto_3y(BigDecimal r54_2y_t_equalto_3y) {
		this.r54_2y_t_equalto_3y = r54_2y_t_equalto_3y;
	}
	public BigDecimal getR54_3y_t_equalto_4y() {
		return r54_3y_t_equalto_4y;
	}
	public void setR54_3y_t_equalto_4y(BigDecimal r54_3y_t_equalto_4y) {
		this.r54_3y_t_equalto_4y = r54_3y_t_equalto_4y;
	}
	public BigDecimal getR54_4y_lt_t_ltequalto_5y() {
		return r54_4y_lt_t_ltequalto_5y;
	}
	public void setR54_4y_lt_t_ltequalto_5y(BigDecimal r54_4y_lt_t_ltequalto_5y) {
		this.r54_4y_lt_t_ltequalto_5y = r54_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR54_5y_lt_t_ltequalto_6y() {
		return r54_5y_lt_t_ltequalto_6y;
	}
	public void setR54_5y_lt_t_ltequalto_6y(BigDecimal r54_5y_lt_t_ltequalto_6y) {
		this.r54_5y_lt_t_ltequalto_6y = r54_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR54_6y_lt_t_ltequalto_7y() {
		return r54_6y_lt_t_ltequalto_7y;
	}
	public void setR54_6y_lt_t_ltequalto_7y(BigDecimal r54_6y_lt_t_ltequalto_7y) {
		this.r54_6y_lt_t_ltequalto_7y = r54_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR54_7y_lt_t_ltequalto_8y() {
		return r54_7y_lt_t_ltequalto_8y;
	}
	public void setR54_7y_lt_t_ltequalto_8y(BigDecimal r54_7y_lt_t_ltequalto_8y) {
		this.r54_7y_lt_t_ltequalto_8y = r54_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR54_8y_lt_t_ltequalto_9y() {
		return r54_8y_lt_t_ltequalto_9y;
	}
	public void setR54_8y_lt_t_ltequalto_9y(BigDecimal r54_8y_lt_t_ltequalto_9y) {
		this.r54_8y_lt_t_ltequalto_9y = r54_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR54_9y_lt_t_ltequalto_10y() {
		return r54_9y_lt_t_ltequalto_10y;
	}
	public void setR54_9y_lt_t_ltequalto_10y(BigDecimal r54_9y_lt_t_ltequalto_10y) {
		this.r54_9y_lt_t_ltequalto_10y = r54_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR54_10y_lt_t_ltequalto_15y() {
		return r54_10y_lt_t_ltequalto_15y;
	}
	public void setR54_10y_lt_t_ltequalto_15y(BigDecimal r54_10y_lt_t_ltequalto_15y) {
		this.r54_10y_lt_t_ltequalto_15y = r54_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR54_15y_lt_t_ltequalto_20y() {
		return r54_15y_lt_t_ltequalto_20y;
	}
	public void setR54_15y_lt_t_ltequalto_20y(BigDecimal r54_15y_lt_t_ltequalto_20y) {
		this.r54_15y_lt_t_ltequalto_20y = r54_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR54_tl_20y() {
		return r54_tl_20y;
	}
	public void setR54_tl_20y(BigDecimal r54_tl_20y) {
		this.r54_tl_20y = r54_tl_20y;
	}
	public BigDecimal getR54_nonsensitive() {
		return r54_nonsensitive;
	}
	public void setR54_nonsensitive(BigDecimal r54_nonsensitive) {
		this.r54_nonsensitive = r54_nonsensitive;
	}
	public BigDecimal getR54_total_rsl() {
		return r54_total_rsl;
	}
	public void setR54_total_rsl(BigDecimal r54_total_rsl) {
		this.r54_total_rsl = r54_total_rsl;
	}
	public BigDecimal getR54_total() {
		return r54_total;
	}
	public void setR54_total(BigDecimal r54_total) {
		this.r54_total = r54_total;
	}
	public String getR55_product() {
		return r55_product;
	}
	public void setR55_product(String r55_product) {
		this.r55_product = r55_product;
	}
	public BigDecimal getR55_tequalon() {
		return r55_tequalon;
	}
	public void setR55_tequalon(BigDecimal r55_tequalon) {
		this.r55_tequalon = r55_tequalon;
	}
	public BigDecimal getR55_on_t_equalto_1m() {
		return r55_on_t_equalto_1m;
	}
	public void setR55_on_t_equalto_1m(BigDecimal r55_on_t_equalto_1m) {
		this.r55_on_t_equalto_1m = r55_on_t_equalto_1m;
	}
	public BigDecimal getR55_1m_t_equalto_3m() {
		return r55_1m_t_equalto_3m;
	}
	public void setR55_1m_t_equalto_3m(BigDecimal r55_1m_t_equalto_3m) {
		this.r55_1m_t_equalto_3m = r55_1m_t_equalto_3m;
	}
	public BigDecimal getR55_3m_t_equalto_6m() {
		return r55_3m_t_equalto_6m;
	}
	public void setR55_3m_t_equalto_6m(BigDecimal r55_3m_t_equalto_6m) {
		this.r55_3m_t_equalto_6m = r55_3m_t_equalto_6m;
	}
	public BigDecimal getR55_6m_t_equalto_9m() {
		return r55_6m_t_equalto_9m;
	}
	public void setR55_6m_t_equalto_9m(BigDecimal r55_6m_t_equalto_9m) {
		this.r55_6m_t_equalto_9m = r55_6m_t_equalto_9m;
	}
	public BigDecimal getR55_9m_t_equalto_1y() {
		return r55_9m_t_equalto_1y;
	}
	public void setR55_9m_t_equalto_1y(BigDecimal r55_9m_t_equalto_1y) {
		this.r55_9m_t_equalto_1y = r55_9m_t_equalto_1y;
	}
	public BigDecimal getR55_1y_t_equalto_1point5y() {
		return r55_1y_t_equalto_1point5y;
	}
	public void setR55_1y_t_equalto_1point5y(BigDecimal r55_1y_t_equalto_1point5y) {
		this.r55_1y_t_equalto_1point5y = r55_1y_t_equalto_1point5y;
	}
	public BigDecimal getR55_1point5y_t_equalto_2y() {
		return r55_1point5y_t_equalto_2y;
	}
	public void setR55_1point5y_t_equalto_2y(BigDecimal r55_1point5y_t_equalto_2y) {
		this.r55_1point5y_t_equalto_2y = r55_1point5y_t_equalto_2y;
	}
	public BigDecimal getR55_2y_t_equalto_3y() {
		return r55_2y_t_equalto_3y;
	}
	public void setR55_2y_t_equalto_3y(BigDecimal r55_2y_t_equalto_3y) {
		this.r55_2y_t_equalto_3y = r55_2y_t_equalto_3y;
	}
	public BigDecimal getR55_3y_t_equalto_4y() {
		return r55_3y_t_equalto_4y;
	}
	public void setR55_3y_t_equalto_4y(BigDecimal r55_3y_t_equalto_4y) {
		this.r55_3y_t_equalto_4y = r55_3y_t_equalto_4y;
	}
	public BigDecimal getR55_4y_lt_t_ltequalto_5y() {
		return r55_4y_lt_t_ltequalto_5y;
	}
	public void setR55_4y_lt_t_ltequalto_5y(BigDecimal r55_4y_lt_t_ltequalto_5y) {
		this.r55_4y_lt_t_ltequalto_5y = r55_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR55_5y_lt_t_ltequalto_6y() {
		return r55_5y_lt_t_ltequalto_6y;
	}
	public void setR55_5y_lt_t_ltequalto_6y(BigDecimal r55_5y_lt_t_ltequalto_6y) {
		this.r55_5y_lt_t_ltequalto_6y = r55_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR55_6y_lt_t_ltequalto_7y() {
		return r55_6y_lt_t_ltequalto_7y;
	}
	public void setR55_6y_lt_t_ltequalto_7y(BigDecimal r55_6y_lt_t_ltequalto_7y) {
		this.r55_6y_lt_t_ltequalto_7y = r55_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR55_7y_lt_t_ltequalto_8y() {
		return r55_7y_lt_t_ltequalto_8y;
	}
	public void setR55_7y_lt_t_ltequalto_8y(BigDecimal r55_7y_lt_t_ltequalto_8y) {
		this.r55_7y_lt_t_ltequalto_8y = r55_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR55_8y_lt_t_ltequalto_9y() {
		return r55_8y_lt_t_ltequalto_9y;
	}
	public void setR55_8y_lt_t_ltequalto_9y(BigDecimal r55_8y_lt_t_ltequalto_9y) {
		this.r55_8y_lt_t_ltequalto_9y = r55_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR55_9y_lt_t_ltequalto_10y() {
		return r55_9y_lt_t_ltequalto_10y;
	}
	public void setR55_9y_lt_t_ltequalto_10y(BigDecimal r55_9y_lt_t_ltequalto_10y) {
		this.r55_9y_lt_t_ltequalto_10y = r55_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR55_10y_lt_t_ltequalto_15y() {
		return r55_10y_lt_t_ltequalto_15y;
	}
	public void setR55_10y_lt_t_ltequalto_15y(BigDecimal r55_10y_lt_t_ltequalto_15y) {
		this.r55_10y_lt_t_ltequalto_15y = r55_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR55_15y_lt_t_ltequalto_20y() {
		return r55_15y_lt_t_ltequalto_20y;
	}
	public void setR55_15y_lt_t_ltequalto_20y(BigDecimal r55_15y_lt_t_ltequalto_20y) {
		this.r55_15y_lt_t_ltequalto_20y = r55_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR55_tl_20y() {
		return r55_tl_20y;
	}
	public void setR55_tl_20y(BigDecimal r55_tl_20y) {
		this.r55_tl_20y = r55_tl_20y;
	}
	public BigDecimal getR55_nonsensitive() {
		return r55_nonsensitive;
	}
	public void setR55_nonsensitive(BigDecimal r55_nonsensitive) {
		this.r55_nonsensitive = r55_nonsensitive;
	}
	public BigDecimal getR55_total_rsl() {
		return r55_total_rsl;
	}
	public void setR55_total_rsl(BigDecimal r55_total_rsl) {
		this.r55_total_rsl = r55_total_rsl;
	}
	public BigDecimal getR55_total() {
		return r55_total;
	}
	public void setR55_total(BigDecimal r55_total) {
		this.r55_total = r55_total;
	}
	public String getR56_product() {
		return r56_product;
	}
	public void setR56_product(String r56_product) {
		this.r56_product = r56_product;
	}
	public BigDecimal getR56_tequalon() {
		return r56_tequalon;
	}
	public void setR56_tequalon(BigDecimal r56_tequalon) {
		this.r56_tequalon = r56_tequalon;
	}
	public BigDecimal getR56_on_t_equalto_1m() {
		return r56_on_t_equalto_1m;
	}
	public void setR56_on_t_equalto_1m(BigDecimal r56_on_t_equalto_1m) {
		this.r56_on_t_equalto_1m = r56_on_t_equalto_1m;
	}
	public BigDecimal getR56_1m_t_equalto_3m() {
		return r56_1m_t_equalto_3m;
	}
	public void setR56_1m_t_equalto_3m(BigDecimal r56_1m_t_equalto_3m) {
		this.r56_1m_t_equalto_3m = r56_1m_t_equalto_3m;
	}
	public BigDecimal getR56_3m_t_equalto_6m() {
		return r56_3m_t_equalto_6m;
	}
	public void setR56_3m_t_equalto_6m(BigDecimal r56_3m_t_equalto_6m) {
		this.r56_3m_t_equalto_6m = r56_3m_t_equalto_6m;
	}
	public BigDecimal getR56_6m_t_equalto_9m() {
		return r56_6m_t_equalto_9m;
	}
	public void setR56_6m_t_equalto_9m(BigDecimal r56_6m_t_equalto_9m) {
		this.r56_6m_t_equalto_9m = r56_6m_t_equalto_9m;
	}
	public BigDecimal getR56_9m_t_equalto_1y() {
		return r56_9m_t_equalto_1y;
	}
	public void setR56_9m_t_equalto_1y(BigDecimal r56_9m_t_equalto_1y) {
		this.r56_9m_t_equalto_1y = r56_9m_t_equalto_1y;
	}
	public BigDecimal getR56_1y_t_equalto_1point5y() {
		return r56_1y_t_equalto_1point5y;
	}
	public void setR56_1y_t_equalto_1point5y(BigDecimal r56_1y_t_equalto_1point5y) {
		this.r56_1y_t_equalto_1point5y = r56_1y_t_equalto_1point5y;
	}
	public BigDecimal getR56_1point5y_t_equalto_2y() {
		return r56_1point5y_t_equalto_2y;
	}
	public void setR56_1point5y_t_equalto_2y(BigDecimal r56_1point5y_t_equalto_2y) {
		this.r56_1point5y_t_equalto_2y = r56_1point5y_t_equalto_2y;
	}
	public BigDecimal getR56_2y_t_equalto_3y() {
		return r56_2y_t_equalto_3y;
	}
	public void setR56_2y_t_equalto_3y(BigDecimal r56_2y_t_equalto_3y) {
		this.r56_2y_t_equalto_3y = r56_2y_t_equalto_3y;
	}
	public BigDecimal getR56_3y_t_equalto_4y() {
		return r56_3y_t_equalto_4y;
	}
	public void setR56_3y_t_equalto_4y(BigDecimal r56_3y_t_equalto_4y) {
		this.r56_3y_t_equalto_4y = r56_3y_t_equalto_4y;
	}
	public BigDecimal getR56_4y_lt_t_ltequalto_5y() {
		return r56_4y_lt_t_ltequalto_5y;
	}
	public void setR56_4y_lt_t_ltequalto_5y(BigDecimal r56_4y_lt_t_ltequalto_5y) {
		this.r56_4y_lt_t_ltequalto_5y = r56_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR56_5y_lt_t_ltequalto_6y() {
		return r56_5y_lt_t_ltequalto_6y;
	}
	public void setR56_5y_lt_t_ltequalto_6y(BigDecimal r56_5y_lt_t_ltequalto_6y) {
		this.r56_5y_lt_t_ltequalto_6y = r56_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR56_6y_lt_t_ltequalto_7y() {
		return r56_6y_lt_t_ltequalto_7y;
	}
	public void setR56_6y_lt_t_ltequalto_7y(BigDecimal r56_6y_lt_t_ltequalto_7y) {
		this.r56_6y_lt_t_ltequalto_7y = r56_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR56_7y_lt_t_ltequalto_8y() {
		return r56_7y_lt_t_ltequalto_8y;
	}
	public void setR56_7y_lt_t_ltequalto_8y(BigDecimal r56_7y_lt_t_ltequalto_8y) {
		this.r56_7y_lt_t_ltequalto_8y = r56_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR56_8y_lt_t_ltequalto_9y() {
		return r56_8y_lt_t_ltequalto_9y;
	}
	public void setR56_8y_lt_t_ltequalto_9y(BigDecimal r56_8y_lt_t_ltequalto_9y) {
		this.r56_8y_lt_t_ltequalto_9y = r56_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR56_9y_lt_t_ltequalto_10y() {
		return r56_9y_lt_t_ltequalto_10y;
	}
	public void setR56_9y_lt_t_ltequalto_10y(BigDecimal r56_9y_lt_t_ltequalto_10y) {
		this.r56_9y_lt_t_ltequalto_10y = r56_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR56_10y_lt_t_ltequalto_15y() {
		return r56_10y_lt_t_ltequalto_15y;
	}
	public void setR56_10y_lt_t_ltequalto_15y(BigDecimal r56_10y_lt_t_ltequalto_15y) {
		this.r56_10y_lt_t_ltequalto_15y = r56_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR56_15y_lt_t_ltequalto_20y() {
		return r56_15y_lt_t_ltequalto_20y;
	}
	public void setR56_15y_lt_t_ltequalto_20y(BigDecimal r56_15y_lt_t_ltequalto_20y) {
		this.r56_15y_lt_t_ltequalto_20y = r56_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR56_tl_20y() {
		return r56_tl_20y;
	}
	public void setR56_tl_20y(BigDecimal r56_tl_20y) {
		this.r56_tl_20y = r56_tl_20y;
	}
	public BigDecimal getR56_nonsensitive() {
		return r56_nonsensitive;
	}
	public void setR56_nonsensitive(BigDecimal r56_nonsensitive) {
		this.r56_nonsensitive = r56_nonsensitive;
	}
	public BigDecimal getR56_total_rsl() {
		return r56_total_rsl;
	}
	public void setR56_total_rsl(BigDecimal r56_total_rsl) {
		this.r56_total_rsl = r56_total_rsl;
	}
	public BigDecimal getR56_total() {
		return r56_total;
	}
	public void setR56_total(BigDecimal r56_total) {
		this.r56_total = r56_total;
	}
	public String getR57_product() {
		return r57_product;
	}
	public void setR57_product(String r57_product) {
		this.r57_product = r57_product;
	}
	public BigDecimal getR57_tequalon() {
		return r57_tequalon;
	}
	public void setR57_tequalon(BigDecimal r57_tequalon) {
		this.r57_tequalon = r57_tequalon;
	}
	public BigDecimal getR57_on_t_equalto_1m() {
		return r57_on_t_equalto_1m;
	}
	public void setR57_on_t_equalto_1m(BigDecimal r57_on_t_equalto_1m) {
		this.r57_on_t_equalto_1m = r57_on_t_equalto_1m;
	}
	public BigDecimal getR57_1m_t_equalto_3m() {
		return r57_1m_t_equalto_3m;
	}
	public void setR57_1m_t_equalto_3m(BigDecimal r57_1m_t_equalto_3m) {
		this.r57_1m_t_equalto_3m = r57_1m_t_equalto_3m;
	}
	public BigDecimal getR57_3m_t_equalto_6m() {
		return r57_3m_t_equalto_6m;
	}
	public void setR57_3m_t_equalto_6m(BigDecimal r57_3m_t_equalto_6m) {
		this.r57_3m_t_equalto_6m = r57_3m_t_equalto_6m;
	}
	public BigDecimal getR57_6m_t_equalto_9m() {
		return r57_6m_t_equalto_9m;
	}
	public void setR57_6m_t_equalto_9m(BigDecimal r57_6m_t_equalto_9m) {
		this.r57_6m_t_equalto_9m = r57_6m_t_equalto_9m;
	}
	public BigDecimal getR57_9m_t_equalto_1y() {
		return r57_9m_t_equalto_1y;
	}
	public void setR57_9m_t_equalto_1y(BigDecimal r57_9m_t_equalto_1y) {
		this.r57_9m_t_equalto_1y = r57_9m_t_equalto_1y;
	}
	public BigDecimal getR57_1y_t_equalto_1point5y() {
		return r57_1y_t_equalto_1point5y;
	}
	public void setR57_1y_t_equalto_1point5y(BigDecimal r57_1y_t_equalto_1point5y) {
		this.r57_1y_t_equalto_1point5y = r57_1y_t_equalto_1point5y;
	}
	public BigDecimal getR57_1point5y_t_equalto_2y() {
		return r57_1point5y_t_equalto_2y;
	}
	public void setR57_1point5y_t_equalto_2y(BigDecimal r57_1point5y_t_equalto_2y) {
		this.r57_1point5y_t_equalto_2y = r57_1point5y_t_equalto_2y;
	}
	public BigDecimal getR57_2y_t_equalto_3y() {
		return r57_2y_t_equalto_3y;
	}
	public void setR57_2y_t_equalto_3y(BigDecimal r57_2y_t_equalto_3y) {
		this.r57_2y_t_equalto_3y = r57_2y_t_equalto_3y;
	}
	public BigDecimal getR57_3y_t_equalto_4y() {
		return r57_3y_t_equalto_4y;
	}
	public void setR57_3y_t_equalto_4y(BigDecimal r57_3y_t_equalto_4y) {
		this.r57_3y_t_equalto_4y = r57_3y_t_equalto_4y;
	}
	public BigDecimal getR57_4y_lt_t_ltequalto_5y() {
		return r57_4y_lt_t_ltequalto_5y;
	}
	public void setR57_4y_lt_t_ltequalto_5y(BigDecimal r57_4y_lt_t_ltequalto_5y) {
		this.r57_4y_lt_t_ltequalto_5y = r57_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR57_5y_lt_t_ltequalto_6y() {
		return r57_5y_lt_t_ltequalto_6y;
	}
	public void setR57_5y_lt_t_ltequalto_6y(BigDecimal r57_5y_lt_t_ltequalto_6y) {
		this.r57_5y_lt_t_ltequalto_6y = r57_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR57_6y_lt_t_ltequalto_7y() {
		return r57_6y_lt_t_ltequalto_7y;
	}
	public void setR57_6y_lt_t_ltequalto_7y(BigDecimal r57_6y_lt_t_ltequalto_7y) {
		this.r57_6y_lt_t_ltequalto_7y = r57_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR57_7y_lt_t_ltequalto_8y() {
		return r57_7y_lt_t_ltequalto_8y;
	}
	public void setR57_7y_lt_t_ltequalto_8y(BigDecimal r57_7y_lt_t_ltequalto_8y) {
		this.r57_7y_lt_t_ltequalto_8y = r57_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR57_8y_lt_t_ltequalto_9y() {
		return r57_8y_lt_t_ltequalto_9y;
	}
	public void setR57_8y_lt_t_ltequalto_9y(BigDecimal r57_8y_lt_t_ltequalto_9y) {
		this.r57_8y_lt_t_ltequalto_9y = r57_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR57_9y_lt_t_ltequalto_10y() {
		return r57_9y_lt_t_ltequalto_10y;
	}
	public void setR57_9y_lt_t_ltequalto_10y(BigDecimal r57_9y_lt_t_ltequalto_10y) {
		this.r57_9y_lt_t_ltequalto_10y = r57_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR57_10y_lt_t_ltequalto_15y() {
		return r57_10y_lt_t_ltequalto_15y;
	}
	public void setR57_10y_lt_t_ltequalto_15y(BigDecimal r57_10y_lt_t_ltequalto_15y) {
		this.r57_10y_lt_t_ltequalto_15y = r57_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR57_15y_lt_t_ltequalto_20y() {
		return r57_15y_lt_t_ltequalto_20y;
	}
	public void setR57_15y_lt_t_ltequalto_20y(BigDecimal r57_15y_lt_t_ltequalto_20y) {
		this.r57_15y_lt_t_ltequalto_20y = r57_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR57_tl_20y() {
		return r57_tl_20y;
	}
	public void setR57_tl_20y(BigDecimal r57_tl_20y) {
		this.r57_tl_20y = r57_tl_20y;
	}
	public BigDecimal getR57_nonsensitive() {
		return r57_nonsensitive;
	}
	public void setR57_nonsensitive(BigDecimal r57_nonsensitive) {
		this.r57_nonsensitive = r57_nonsensitive;
	}
	public BigDecimal getR57_total_rsl() {
		return r57_total_rsl;
	}
	public void setR57_total_rsl(BigDecimal r57_total_rsl) {
		this.r57_total_rsl = r57_total_rsl;
	}
	public BigDecimal getR57_total() {
		return r57_total;
	}
	public void setR57_total(BigDecimal r57_total) {
		this.r57_total = r57_total;
	}
	public String getR58_product() {
		return r58_product;
	}
	public void setR58_product(String r58_product) {
		this.r58_product = r58_product;
	}
	public BigDecimal getR58_tequalon() {
		return r58_tequalon;
	}
	public void setR58_tequalon(BigDecimal r58_tequalon) {
		this.r58_tequalon = r58_tequalon;
	}
	public BigDecimal getR58_on_t_equalto_1m() {
		return r58_on_t_equalto_1m;
	}
	public void setR58_on_t_equalto_1m(BigDecimal r58_on_t_equalto_1m) {
		this.r58_on_t_equalto_1m = r58_on_t_equalto_1m;
	}
	public BigDecimal getR58_1m_t_equalto_3m() {
		return r58_1m_t_equalto_3m;
	}
	public void setR58_1m_t_equalto_3m(BigDecimal r58_1m_t_equalto_3m) {
		this.r58_1m_t_equalto_3m = r58_1m_t_equalto_3m;
	}
	public BigDecimal getR58_3m_t_equalto_6m() {
		return r58_3m_t_equalto_6m;
	}
	public void setR58_3m_t_equalto_6m(BigDecimal r58_3m_t_equalto_6m) {
		this.r58_3m_t_equalto_6m = r58_3m_t_equalto_6m;
	}
	public BigDecimal getR58_6m_t_equalto_9m() {
		return r58_6m_t_equalto_9m;
	}
	public void setR58_6m_t_equalto_9m(BigDecimal r58_6m_t_equalto_9m) {
		this.r58_6m_t_equalto_9m = r58_6m_t_equalto_9m;
	}
	public BigDecimal getR58_9m_t_equalto_1y() {
		return r58_9m_t_equalto_1y;
	}
	public void setR58_9m_t_equalto_1y(BigDecimal r58_9m_t_equalto_1y) {
		this.r58_9m_t_equalto_1y = r58_9m_t_equalto_1y;
	}
	public BigDecimal getR58_1y_t_equalto_1point5y() {
		return r58_1y_t_equalto_1point5y;
	}
	public void setR58_1y_t_equalto_1point5y(BigDecimal r58_1y_t_equalto_1point5y) {
		this.r58_1y_t_equalto_1point5y = r58_1y_t_equalto_1point5y;
	}
	public BigDecimal getR58_1point5y_t_equalto_2y() {
		return r58_1point5y_t_equalto_2y;
	}
	public void setR58_1point5y_t_equalto_2y(BigDecimal r58_1point5y_t_equalto_2y) {
		this.r58_1point5y_t_equalto_2y = r58_1point5y_t_equalto_2y;
	}
	public BigDecimal getR58_2y_t_equalto_3y() {
		return r58_2y_t_equalto_3y;
	}
	public void setR58_2y_t_equalto_3y(BigDecimal r58_2y_t_equalto_3y) {
		this.r58_2y_t_equalto_3y = r58_2y_t_equalto_3y;
	}
	public BigDecimal getR58_3y_t_equalto_4y() {
		return r58_3y_t_equalto_4y;
	}
	public void setR58_3y_t_equalto_4y(BigDecimal r58_3y_t_equalto_4y) {
		this.r58_3y_t_equalto_4y = r58_3y_t_equalto_4y;
	}
	public BigDecimal getR58_4y_lt_t_ltequalto_5y() {
		return r58_4y_lt_t_ltequalto_5y;
	}
	public void setR58_4y_lt_t_ltequalto_5y(BigDecimal r58_4y_lt_t_ltequalto_5y) {
		this.r58_4y_lt_t_ltequalto_5y = r58_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR58_5y_lt_t_ltequalto_6y() {
		return r58_5y_lt_t_ltequalto_6y;
	}
	public void setR58_5y_lt_t_ltequalto_6y(BigDecimal r58_5y_lt_t_ltequalto_6y) {
		this.r58_5y_lt_t_ltequalto_6y = r58_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR58_6y_lt_t_ltequalto_7y() {
		return r58_6y_lt_t_ltequalto_7y;
	}
	public void setR58_6y_lt_t_ltequalto_7y(BigDecimal r58_6y_lt_t_ltequalto_7y) {
		this.r58_6y_lt_t_ltequalto_7y = r58_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR58_7y_lt_t_ltequalto_8y() {
		return r58_7y_lt_t_ltequalto_8y;
	}
	public void setR58_7y_lt_t_ltequalto_8y(BigDecimal r58_7y_lt_t_ltequalto_8y) {
		this.r58_7y_lt_t_ltequalto_8y = r58_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR58_8y_lt_t_ltequalto_9y() {
		return r58_8y_lt_t_ltequalto_9y;
	}
	public void setR58_8y_lt_t_ltequalto_9y(BigDecimal r58_8y_lt_t_ltequalto_9y) {
		this.r58_8y_lt_t_ltequalto_9y = r58_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR58_9y_lt_t_ltequalto_10y() {
		return r58_9y_lt_t_ltequalto_10y;
	}
	public void setR58_9y_lt_t_ltequalto_10y(BigDecimal r58_9y_lt_t_ltequalto_10y) {
		this.r58_9y_lt_t_ltequalto_10y = r58_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR58_10y_lt_t_ltequalto_15y() {
		return r58_10y_lt_t_ltequalto_15y;
	}
	public void setR58_10y_lt_t_ltequalto_15y(BigDecimal r58_10y_lt_t_ltequalto_15y) {
		this.r58_10y_lt_t_ltequalto_15y = r58_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR58_15y_lt_t_ltequalto_20y() {
		return r58_15y_lt_t_ltequalto_20y;
	}
	public void setR58_15y_lt_t_ltequalto_20y(BigDecimal r58_15y_lt_t_ltequalto_20y) {
		this.r58_15y_lt_t_ltequalto_20y = r58_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR58_tl_20y() {
		return r58_tl_20y;
	}
	public void setR58_tl_20y(BigDecimal r58_tl_20y) {
		this.r58_tl_20y = r58_tl_20y;
	}
	public BigDecimal getR58_nonsensitive() {
		return r58_nonsensitive;
	}
	public void setR58_nonsensitive(BigDecimal r58_nonsensitive) {
		this.r58_nonsensitive = r58_nonsensitive;
	}
	public BigDecimal getR58_total_rsl() {
		return r58_total_rsl;
	}
	public void setR58_total_rsl(BigDecimal r58_total_rsl) {
		this.r58_total_rsl = r58_total_rsl;
	}
	public BigDecimal getR58_total() {
		return r58_total;
	}
	public void setR58_total(BigDecimal r58_total) {
		this.r58_total = r58_total;
	}
	public String getR59_product() {
		return r59_product;
	}
	public void setR59_product(String r59_product) {
		this.r59_product = r59_product;
	}
	public BigDecimal getR59_tequalon() {
		return r59_tequalon;
	}
	public void setR59_tequalon(BigDecimal r59_tequalon) {
		this.r59_tequalon = r59_tequalon;
	}
	public BigDecimal getR59_on_t_equalto_1m() {
		return r59_on_t_equalto_1m;
	}
	public void setR59_on_t_equalto_1m(BigDecimal r59_on_t_equalto_1m) {
		this.r59_on_t_equalto_1m = r59_on_t_equalto_1m;
	}
	public BigDecimal getR59_1m_t_equalto_3m() {
		return r59_1m_t_equalto_3m;
	}
	public void setR59_1m_t_equalto_3m(BigDecimal r59_1m_t_equalto_3m) {
		this.r59_1m_t_equalto_3m = r59_1m_t_equalto_3m;
	}
	public BigDecimal getR59_3m_t_equalto_6m() {
		return r59_3m_t_equalto_6m;
	}
	public void setR59_3m_t_equalto_6m(BigDecimal r59_3m_t_equalto_6m) {
		this.r59_3m_t_equalto_6m = r59_3m_t_equalto_6m;
	}
	public BigDecimal getR59_6m_t_equalto_9m() {
		return r59_6m_t_equalto_9m;
	}
	public void setR59_6m_t_equalto_9m(BigDecimal r59_6m_t_equalto_9m) {
		this.r59_6m_t_equalto_9m = r59_6m_t_equalto_9m;
	}
	public BigDecimal getR59_9m_t_equalto_1y() {
		return r59_9m_t_equalto_1y;
	}
	public void setR59_9m_t_equalto_1y(BigDecimal r59_9m_t_equalto_1y) {
		this.r59_9m_t_equalto_1y = r59_9m_t_equalto_1y;
	}
	public BigDecimal getR59_1y_t_equalto_1point5y() {
		return r59_1y_t_equalto_1point5y;
	}
	public void setR59_1y_t_equalto_1point5y(BigDecimal r59_1y_t_equalto_1point5y) {
		this.r59_1y_t_equalto_1point5y = r59_1y_t_equalto_1point5y;
	}
	public BigDecimal getR59_1point5y_t_equalto_2y() {
		return r59_1point5y_t_equalto_2y;
	}
	public void setR59_1point5y_t_equalto_2y(BigDecimal r59_1point5y_t_equalto_2y) {
		this.r59_1point5y_t_equalto_2y = r59_1point5y_t_equalto_2y;
	}
	public BigDecimal getR59_2y_t_equalto_3y() {
		return r59_2y_t_equalto_3y;
	}
	public void setR59_2y_t_equalto_3y(BigDecimal r59_2y_t_equalto_3y) {
		this.r59_2y_t_equalto_3y = r59_2y_t_equalto_3y;
	}
	public BigDecimal getR59_3y_t_equalto_4y() {
		return r59_3y_t_equalto_4y;
	}
	public void setR59_3y_t_equalto_4y(BigDecimal r59_3y_t_equalto_4y) {
		this.r59_3y_t_equalto_4y = r59_3y_t_equalto_4y;
	}
	public BigDecimal getR59_4y_lt_t_ltequalto_5y() {
		return r59_4y_lt_t_ltequalto_5y;
	}
	public void setR59_4y_lt_t_ltequalto_5y(BigDecimal r59_4y_lt_t_ltequalto_5y) {
		this.r59_4y_lt_t_ltequalto_5y = r59_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR59_5y_lt_t_ltequalto_6y() {
		return r59_5y_lt_t_ltequalto_6y;
	}
	public void setR59_5y_lt_t_ltequalto_6y(BigDecimal r59_5y_lt_t_ltequalto_6y) {
		this.r59_5y_lt_t_ltequalto_6y = r59_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR59_6y_lt_t_ltequalto_7y() {
		return r59_6y_lt_t_ltequalto_7y;
	}
	public void setR59_6y_lt_t_ltequalto_7y(BigDecimal r59_6y_lt_t_ltequalto_7y) {
		this.r59_6y_lt_t_ltequalto_7y = r59_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR59_7y_lt_t_ltequalto_8y() {
		return r59_7y_lt_t_ltequalto_8y;
	}
	public void setR59_7y_lt_t_ltequalto_8y(BigDecimal r59_7y_lt_t_ltequalto_8y) {
		this.r59_7y_lt_t_ltequalto_8y = r59_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR59_8y_lt_t_ltequalto_9y() {
		return r59_8y_lt_t_ltequalto_9y;
	}
	public void setR59_8y_lt_t_ltequalto_9y(BigDecimal r59_8y_lt_t_ltequalto_9y) {
		this.r59_8y_lt_t_ltequalto_9y = r59_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR59_9y_lt_t_ltequalto_10y() {
		return r59_9y_lt_t_ltequalto_10y;
	}
	public void setR59_9y_lt_t_ltequalto_10y(BigDecimal r59_9y_lt_t_ltequalto_10y) {
		this.r59_9y_lt_t_ltequalto_10y = r59_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR59_10y_lt_t_ltequalto_15y() {
		return r59_10y_lt_t_ltequalto_15y;
	}
	public void setR59_10y_lt_t_ltequalto_15y(BigDecimal r59_10y_lt_t_ltequalto_15y) {
		this.r59_10y_lt_t_ltequalto_15y = r59_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR59_15y_lt_t_ltequalto_20y() {
		return r59_15y_lt_t_ltequalto_20y;
	}
	public void setR59_15y_lt_t_ltequalto_20y(BigDecimal r59_15y_lt_t_ltequalto_20y) {
		this.r59_15y_lt_t_ltequalto_20y = r59_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR59_tl_20y() {
		return r59_tl_20y;
	}
	public void setR59_tl_20y(BigDecimal r59_tl_20y) {
		this.r59_tl_20y = r59_tl_20y;
	}
	public BigDecimal getR59_nonsensitive() {
		return r59_nonsensitive;
	}
	public void setR59_nonsensitive(BigDecimal r59_nonsensitive) {
		this.r59_nonsensitive = r59_nonsensitive;
	}
	public BigDecimal getR59_total_rsl() {
		return r59_total_rsl;
	}
	public void setR59_total_rsl(BigDecimal r59_total_rsl) {
		this.r59_total_rsl = r59_total_rsl;
	}
	public BigDecimal getR59_total() {
		return r59_total;
	}
	public void setR59_total(BigDecimal r59_total) {
		this.r59_total = r59_total;
	}
	public String getR60_product() {
		return r60_product;
	}
	public void setR60_product(String r60_product) {
		this.r60_product = r60_product;
	}
	public BigDecimal getR60_tequalon() {
		return r60_tequalon;
	}
	public void setR60_tequalon(BigDecimal r60_tequalon) {
		this.r60_tequalon = r60_tequalon;
	}
	public BigDecimal getR60_on_t_equalto_1m() {
		return r60_on_t_equalto_1m;
	}
	public void setR60_on_t_equalto_1m(BigDecimal r60_on_t_equalto_1m) {
		this.r60_on_t_equalto_1m = r60_on_t_equalto_1m;
	}
	public BigDecimal getR60_1m_t_equalto_3m() {
		return r60_1m_t_equalto_3m;
	}
	public void setR60_1m_t_equalto_3m(BigDecimal r60_1m_t_equalto_3m) {
		this.r60_1m_t_equalto_3m = r60_1m_t_equalto_3m;
	}
	public BigDecimal getR60_3m_t_equalto_6m() {
		return r60_3m_t_equalto_6m;
	}
	public void setR60_3m_t_equalto_6m(BigDecimal r60_3m_t_equalto_6m) {
		this.r60_3m_t_equalto_6m = r60_3m_t_equalto_6m;
	}
	public BigDecimal getR60_6m_t_equalto_9m() {
		return r60_6m_t_equalto_9m;
	}
	public void setR60_6m_t_equalto_9m(BigDecimal r60_6m_t_equalto_9m) {
		this.r60_6m_t_equalto_9m = r60_6m_t_equalto_9m;
	}
	public BigDecimal getR60_9m_t_equalto_1y() {
		return r60_9m_t_equalto_1y;
	}
	public void setR60_9m_t_equalto_1y(BigDecimal r60_9m_t_equalto_1y) {
		this.r60_9m_t_equalto_1y = r60_9m_t_equalto_1y;
	}
	public BigDecimal getR60_1y_t_equalto_1point5y() {
		return r60_1y_t_equalto_1point5y;
	}
	public void setR60_1y_t_equalto_1point5y(BigDecimal r60_1y_t_equalto_1point5y) {
		this.r60_1y_t_equalto_1point5y = r60_1y_t_equalto_1point5y;
	}
	public BigDecimal getR60_1point5y_t_equalto_2y() {
		return r60_1point5y_t_equalto_2y;
	}
	public void setR60_1point5y_t_equalto_2y(BigDecimal r60_1point5y_t_equalto_2y) {
		this.r60_1point5y_t_equalto_2y = r60_1point5y_t_equalto_2y;
	}
	public BigDecimal getR60_2y_t_equalto_3y() {
		return r60_2y_t_equalto_3y;
	}
	public void setR60_2y_t_equalto_3y(BigDecimal r60_2y_t_equalto_3y) {
		this.r60_2y_t_equalto_3y = r60_2y_t_equalto_3y;
	}
	public BigDecimal getR60_3y_t_equalto_4y() {
		return r60_3y_t_equalto_4y;
	}
	public void setR60_3y_t_equalto_4y(BigDecimal r60_3y_t_equalto_4y) {
		this.r60_3y_t_equalto_4y = r60_3y_t_equalto_4y;
	}
	public BigDecimal getR60_4y_lt_t_ltequalto_5y() {
		return r60_4y_lt_t_ltequalto_5y;
	}
	public void setR60_4y_lt_t_ltequalto_5y(BigDecimal r60_4y_lt_t_ltequalto_5y) {
		this.r60_4y_lt_t_ltequalto_5y = r60_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR60_5y_lt_t_ltequalto_6y() {
		return r60_5y_lt_t_ltequalto_6y;
	}
	public void setR60_5y_lt_t_ltequalto_6y(BigDecimal r60_5y_lt_t_ltequalto_6y) {
		this.r60_5y_lt_t_ltequalto_6y = r60_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR60_6y_lt_t_ltequalto_7y() {
		return r60_6y_lt_t_ltequalto_7y;
	}
	public void setR60_6y_lt_t_ltequalto_7y(BigDecimal r60_6y_lt_t_ltequalto_7y) {
		this.r60_6y_lt_t_ltequalto_7y = r60_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR60_7y_lt_t_ltequalto_8y() {
		return r60_7y_lt_t_ltequalto_8y;
	}
	public void setR60_7y_lt_t_ltequalto_8y(BigDecimal r60_7y_lt_t_ltequalto_8y) {
		this.r60_7y_lt_t_ltequalto_8y = r60_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR60_8y_lt_t_ltequalto_9y() {
		return r60_8y_lt_t_ltequalto_9y;
	}
	public void setR60_8y_lt_t_ltequalto_9y(BigDecimal r60_8y_lt_t_ltequalto_9y) {
		this.r60_8y_lt_t_ltequalto_9y = r60_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR60_9y_lt_t_ltequalto_10y() {
		return r60_9y_lt_t_ltequalto_10y;
	}
	public void setR60_9y_lt_t_ltequalto_10y(BigDecimal r60_9y_lt_t_ltequalto_10y) {
		this.r60_9y_lt_t_ltequalto_10y = r60_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR60_10y_lt_t_ltequalto_15y() {
		return r60_10y_lt_t_ltequalto_15y;
	}
	public void setR60_10y_lt_t_ltequalto_15y(BigDecimal r60_10y_lt_t_ltequalto_15y) {
		this.r60_10y_lt_t_ltequalto_15y = r60_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR60_15y_lt_t_ltequalto_20y() {
		return r60_15y_lt_t_ltequalto_20y;
	}
	public void setR60_15y_lt_t_ltequalto_20y(BigDecimal r60_15y_lt_t_ltequalto_20y) {
		this.r60_15y_lt_t_ltequalto_20y = r60_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR60_tl_20y() {
		return r60_tl_20y;
	}
	public void setR60_tl_20y(BigDecimal r60_tl_20y) {
		this.r60_tl_20y = r60_tl_20y;
	}
	public BigDecimal getR60_nonsensitive() {
		return r60_nonsensitive;
	}
	public void setR60_nonsensitive(BigDecimal r60_nonsensitive) {
		this.r60_nonsensitive = r60_nonsensitive;
	}
	public BigDecimal getR60_total_rsl() {
		return r60_total_rsl;
	}
	public void setR60_total_rsl(BigDecimal r60_total_rsl) {
		this.r60_total_rsl = r60_total_rsl;
	}
	public BigDecimal getR60_total() {
		return r60_total;
	}
	public void setR60_total(BigDecimal r60_total) {
		this.r60_total = r60_total;
	}
	public String getR61_product() {
		return r61_product;
	}
	public void setR61_product(String r61_product) {
		this.r61_product = r61_product;
	}
	public BigDecimal getR61_tequalon() {
		return r61_tequalon;
	}
	public void setR61_tequalon(BigDecimal r61_tequalon) {
		this.r61_tequalon = r61_tequalon;
	}
	public BigDecimal getR61_on_t_equalto_1m() {
		return r61_on_t_equalto_1m;
	}
	public void setR61_on_t_equalto_1m(BigDecimal r61_on_t_equalto_1m) {
		this.r61_on_t_equalto_1m = r61_on_t_equalto_1m;
	}
	public BigDecimal getR61_1m_t_equalto_3m() {
		return r61_1m_t_equalto_3m;
	}
	public void setR61_1m_t_equalto_3m(BigDecimal r61_1m_t_equalto_3m) {
		this.r61_1m_t_equalto_3m = r61_1m_t_equalto_3m;
	}
	public BigDecimal getR61_3m_t_equalto_6m() {
		return r61_3m_t_equalto_6m;
	}
	public void setR61_3m_t_equalto_6m(BigDecimal r61_3m_t_equalto_6m) {
		this.r61_3m_t_equalto_6m = r61_3m_t_equalto_6m;
	}
	public BigDecimal getR61_6m_t_equalto_9m() {
		return r61_6m_t_equalto_9m;
	}
	public void setR61_6m_t_equalto_9m(BigDecimal r61_6m_t_equalto_9m) {
		this.r61_6m_t_equalto_9m = r61_6m_t_equalto_9m;
	}
	public BigDecimal getR61_9m_t_equalto_1y() {
		return r61_9m_t_equalto_1y;
	}
	public void setR61_9m_t_equalto_1y(BigDecimal r61_9m_t_equalto_1y) {
		this.r61_9m_t_equalto_1y = r61_9m_t_equalto_1y;
	}
	public BigDecimal getR61_1y_t_equalto_1point5y() {
		return r61_1y_t_equalto_1point5y;
	}
	public void setR61_1y_t_equalto_1point5y(BigDecimal r61_1y_t_equalto_1point5y) {
		this.r61_1y_t_equalto_1point5y = r61_1y_t_equalto_1point5y;
	}
	public BigDecimal getR61_1point5y_t_equalto_2y() {
		return r61_1point5y_t_equalto_2y;
	}
	public void setR61_1point5y_t_equalto_2y(BigDecimal r61_1point5y_t_equalto_2y) {
		this.r61_1point5y_t_equalto_2y = r61_1point5y_t_equalto_2y;
	}
	public BigDecimal getR61_2y_t_equalto_3y() {
		return r61_2y_t_equalto_3y;
	}
	public void setR61_2y_t_equalto_3y(BigDecimal r61_2y_t_equalto_3y) {
		this.r61_2y_t_equalto_3y = r61_2y_t_equalto_3y;
	}
	public BigDecimal getR61_3y_t_equalto_4y() {
		return r61_3y_t_equalto_4y;
	}
	public void setR61_3y_t_equalto_4y(BigDecimal r61_3y_t_equalto_4y) {
		this.r61_3y_t_equalto_4y = r61_3y_t_equalto_4y;
	}
	public BigDecimal getR61_4y_lt_t_ltequalto_5y() {
		return r61_4y_lt_t_ltequalto_5y;
	}
	public void setR61_4y_lt_t_ltequalto_5y(BigDecimal r61_4y_lt_t_ltequalto_5y) {
		this.r61_4y_lt_t_ltequalto_5y = r61_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR61_5y_lt_t_ltequalto_6y() {
		return r61_5y_lt_t_ltequalto_6y;
	}
	public void setR61_5y_lt_t_ltequalto_6y(BigDecimal r61_5y_lt_t_ltequalto_6y) {
		this.r61_5y_lt_t_ltequalto_6y = r61_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR61_6y_lt_t_ltequalto_7y() {
		return r61_6y_lt_t_ltequalto_7y;
	}
	public void setR61_6y_lt_t_ltequalto_7y(BigDecimal r61_6y_lt_t_ltequalto_7y) {
		this.r61_6y_lt_t_ltequalto_7y = r61_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR61_7y_lt_t_ltequalto_8y() {
		return r61_7y_lt_t_ltequalto_8y;
	}
	public void setR61_7y_lt_t_ltequalto_8y(BigDecimal r61_7y_lt_t_ltequalto_8y) {
		this.r61_7y_lt_t_ltequalto_8y = r61_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR61_8y_lt_t_ltequalto_9y() {
		return r61_8y_lt_t_ltequalto_9y;
	}
	public void setR61_8y_lt_t_ltequalto_9y(BigDecimal r61_8y_lt_t_ltequalto_9y) {
		this.r61_8y_lt_t_ltequalto_9y = r61_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR61_9y_lt_t_ltequalto_10y() {
		return r61_9y_lt_t_ltequalto_10y;
	}
	public void setR61_9y_lt_t_ltequalto_10y(BigDecimal r61_9y_lt_t_ltequalto_10y) {
		this.r61_9y_lt_t_ltequalto_10y = r61_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR61_10y_lt_t_ltequalto_15y() {
		return r61_10y_lt_t_ltequalto_15y;
	}
	public void setR61_10y_lt_t_ltequalto_15y(BigDecimal r61_10y_lt_t_ltequalto_15y) {
		this.r61_10y_lt_t_ltequalto_15y = r61_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR61_15y_lt_t_ltequalto_20y() {
		return r61_15y_lt_t_ltequalto_20y;
	}
	public void setR61_15y_lt_t_ltequalto_20y(BigDecimal r61_15y_lt_t_ltequalto_20y) {
		this.r61_15y_lt_t_ltequalto_20y = r61_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR61_tl_20y() {
		return r61_tl_20y;
	}
	public void setR61_tl_20y(BigDecimal r61_tl_20y) {
		this.r61_tl_20y = r61_tl_20y;
	}
	public BigDecimal getR61_nonsensitive() {
		return r61_nonsensitive;
	}
	public void setR61_nonsensitive(BigDecimal r61_nonsensitive) {
		this.r61_nonsensitive = r61_nonsensitive;
	}
	public BigDecimal getR61_total_rsl() {
		return r61_total_rsl;
	}
	public void setR61_total_rsl(BigDecimal r61_total_rsl) {
		this.r61_total_rsl = r61_total_rsl;
	}
	public BigDecimal getR61_total() {
		return r61_total;
	}
	public void setR61_total(BigDecimal r61_total) {
		this.r61_total = r61_total;
	}
	public String getR62_product() {
		return r62_product;
	}
	public void setR62_product(String r62_product) {
		this.r62_product = r62_product;
	}
	public BigDecimal getR62_tequalon() {
		return r62_tequalon;
	}
	public void setR62_tequalon(BigDecimal r62_tequalon) {
		this.r62_tequalon = r62_tequalon;
	}
	public BigDecimal getR62_on_t_equalto_1m() {
		return r62_on_t_equalto_1m;
	}
	public void setR62_on_t_equalto_1m(BigDecimal r62_on_t_equalto_1m) {
		this.r62_on_t_equalto_1m = r62_on_t_equalto_1m;
	}
	public BigDecimal getR62_1m_t_equalto_3m() {
		return r62_1m_t_equalto_3m;
	}
	public void setR62_1m_t_equalto_3m(BigDecimal r62_1m_t_equalto_3m) {
		this.r62_1m_t_equalto_3m = r62_1m_t_equalto_3m;
	}
	public BigDecimal getR62_3m_t_equalto_6m() {
		return r62_3m_t_equalto_6m;
	}
	public void setR62_3m_t_equalto_6m(BigDecimal r62_3m_t_equalto_6m) {
		this.r62_3m_t_equalto_6m = r62_3m_t_equalto_6m;
	}
	public BigDecimal getR62_6m_t_equalto_9m() {
		return r62_6m_t_equalto_9m;
	}
	public void setR62_6m_t_equalto_9m(BigDecimal r62_6m_t_equalto_9m) {
		this.r62_6m_t_equalto_9m = r62_6m_t_equalto_9m;
	}
	public BigDecimal getR62_9m_t_equalto_1y() {
		return r62_9m_t_equalto_1y;
	}
	public void setR62_9m_t_equalto_1y(BigDecimal r62_9m_t_equalto_1y) {
		this.r62_9m_t_equalto_1y = r62_9m_t_equalto_1y;
	}
	public BigDecimal getR62_1y_t_equalto_1point5y() {
		return r62_1y_t_equalto_1point5y;
	}
	public void setR62_1y_t_equalto_1point5y(BigDecimal r62_1y_t_equalto_1point5y) {
		this.r62_1y_t_equalto_1point5y = r62_1y_t_equalto_1point5y;
	}
	public BigDecimal getR62_1point5y_t_equalto_2y() {
		return r62_1point5y_t_equalto_2y;
	}
	public void setR62_1point5y_t_equalto_2y(BigDecimal r62_1point5y_t_equalto_2y) {
		this.r62_1point5y_t_equalto_2y = r62_1point5y_t_equalto_2y;
	}
	public BigDecimal getR62_2y_t_equalto_3y() {
		return r62_2y_t_equalto_3y;
	}
	public void setR62_2y_t_equalto_3y(BigDecimal r62_2y_t_equalto_3y) {
		this.r62_2y_t_equalto_3y = r62_2y_t_equalto_3y;
	}
	public BigDecimal getR62_3y_t_equalto_4y() {
		return r62_3y_t_equalto_4y;
	}
	public void setR62_3y_t_equalto_4y(BigDecimal r62_3y_t_equalto_4y) {
		this.r62_3y_t_equalto_4y = r62_3y_t_equalto_4y;
	}
	public BigDecimal getR62_4y_lt_t_ltequalto_5y() {
		return r62_4y_lt_t_ltequalto_5y;
	}
	public void setR62_4y_lt_t_ltequalto_5y(BigDecimal r62_4y_lt_t_ltequalto_5y) {
		this.r62_4y_lt_t_ltequalto_5y = r62_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR62_5y_lt_t_ltequalto_6y() {
		return r62_5y_lt_t_ltequalto_6y;
	}
	public void setR62_5y_lt_t_ltequalto_6y(BigDecimal r62_5y_lt_t_ltequalto_6y) {
		this.r62_5y_lt_t_ltequalto_6y = r62_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR62_6y_lt_t_ltequalto_7y() {
		return r62_6y_lt_t_ltequalto_7y;
	}
	public void setR62_6y_lt_t_ltequalto_7y(BigDecimal r62_6y_lt_t_ltequalto_7y) {
		this.r62_6y_lt_t_ltequalto_7y = r62_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR62_7y_lt_t_ltequalto_8y() {
		return r62_7y_lt_t_ltequalto_8y;
	}
	public void setR62_7y_lt_t_ltequalto_8y(BigDecimal r62_7y_lt_t_ltequalto_8y) {
		this.r62_7y_lt_t_ltequalto_8y = r62_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR62_8y_lt_t_ltequalto_9y() {
		return r62_8y_lt_t_ltequalto_9y;
	}
	public void setR62_8y_lt_t_ltequalto_9y(BigDecimal r62_8y_lt_t_ltequalto_9y) {
		this.r62_8y_lt_t_ltequalto_9y = r62_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR62_9y_lt_t_ltequalto_10y() {
		return r62_9y_lt_t_ltequalto_10y;
	}
	public void setR62_9y_lt_t_ltequalto_10y(BigDecimal r62_9y_lt_t_ltequalto_10y) {
		this.r62_9y_lt_t_ltequalto_10y = r62_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR62_10y_lt_t_ltequalto_15y() {
		return r62_10y_lt_t_ltequalto_15y;
	}
	public void setR62_10y_lt_t_ltequalto_15y(BigDecimal r62_10y_lt_t_ltequalto_15y) {
		this.r62_10y_lt_t_ltequalto_15y = r62_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR62_15y_lt_t_ltequalto_20y() {
		return r62_15y_lt_t_ltequalto_20y;
	}
	public void setR62_15y_lt_t_ltequalto_20y(BigDecimal r62_15y_lt_t_ltequalto_20y) {
		this.r62_15y_lt_t_ltequalto_20y = r62_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR62_tl_20y() {
		return r62_tl_20y;
	}
	public void setR62_tl_20y(BigDecimal r62_tl_20y) {
		this.r62_tl_20y = r62_tl_20y;
	}
	public BigDecimal getR62_nonsensitive() {
		return r62_nonsensitive;
	}
	public void setR62_nonsensitive(BigDecimal r62_nonsensitive) {
		this.r62_nonsensitive = r62_nonsensitive;
	}
	public BigDecimal getR62_total_rsl() {
		return r62_total_rsl;
	}
	public void setR62_total_rsl(BigDecimal r62_total_rsl) {
		this.r62_total_rsl = r62_total_rsl;
	}
	public BigDecimal getR62_total() {
		return r62_total;
	}
	public void setR62_total(BigDecimal r62_total) {
		this.r62_total = r62_total;
	}
	public String getR63_product() {
		return r63_product;
	}
	public void setR63_product(String r63_product) {
		this.r63_product = r63_product;
	}
	public BigDecimal getR63_tequalon() {
		return r63_tequalon;
	}
	public void setR63_tequalon(BigDecimal r63_tequalon) {
		this.r63_tequalon = r63_tequalon;
	}
	public BigDecimal getR63_on_t_equalto_1m() {
		return r63_on_t_equalto_1m;
	}
	public void setR63_on_t_equalto_1m(BigDecimal r63_on_t_equalto_1m) {
		this.r63_on_t_equalto_1m = r63_on_t_equalto_1m;
	}
	public BigDecimal getR63_1m_t_equalto_3m() {
		return r63_1m_t_equalto_3m;
	}
	public void setR63_1m_t_equalto_3m(BigDecimal r63_1m_t_equalto_3m) {
		this.r63_1m_t_equalto_3m = r63_1m_t_equalto_3m;
	}
	public BigDecimal getR63_3m_t_equalto_6m() {
		return r63_3m_t_equalto_6m;
	}
	public void setR63_3m_t_equalto_6m(BigDecimal r63_3m_t_equalto_6m) {
		this.r63_3m_t_equalto_6m = r63_3m_t_equalto_6m;
	}
	public BigDecimal getR63_6m_t_equalto_9m() {
		return r63_6m_t_equalto_9m;
	}
	public void setR63_6m_t_equalto_9m(BigDecimal r63_6m_t_equalto_9m) {
		this.r63_6m_t_equalto_9m = r63_6m_t_equalto_9m;
	}
	public BigDecimal getR63_9m_t_equalto_1y() {
		return r63_9m_t_equalto_1y;
	}
	public void setR63_9m_t_equalto_1y(BigDecimal r63_9m_t_equalto_1y) {
		this.r63_9m_t_equalto_1y = r63_9m_t_equalto_1y;
	}
	public BigDecimal getR63_1y_t_equalto_1point5y() {
		return r63_1y_t_equalto_1point5y;
	}
	public void setR63_1y_t_equalto_1point5y(BigDecimal r63_1y_t_equalto_1point5y) {
		this.r63_1y_t_equalto_1point5y = r63_1y_t_equalto_1point5y;
	}
	public BigDecimal getR63_1point5y_t_equalto_2y() {
		return r63_1point5y_t_equalto_2y;
	}
	public void setR63_1point5y_t_equalto_2y(BigDecimal r63_1point5y_t_equalto_2y) {
		this.r63_1point5y_t_equalto_2y = r63_1point5y_t_equalto_2y;
	}
	public BigDecimal getR63_2y_t_equalto_3y() {
		return r63_2y_t_equalto_3y;
	}
	public void setR63_2y_t_equalto_3y(BigDecimal r63_2y_t_equalto_3y) {
		this.r63_2y_t_equalto_3y = r63_2y_t_equalto_3y;
	}
	public BigDecimal getR63_3y_t_equalto_4y() {
		return r63_3y_t_equalto_4y;
	}
	public void setR63_3y_t_equalto_4y(BigDecimal r63_3y_t_equalto_4y) {
		this.r63_3y_t_equalto_4y = r63_3y_t_equalto_4y;
	}
	public BigDecimal getR63_4y_lt_t_ltequalto_5y() {
		return r63_4y_lt_t_ltequalto_5y;
	}
	public void setR63_4y_lt_t_ltequalto_5y(BigDecimal r63_4y_lt_t_ltequalto_5y) {
		this.r63_4y_lt_t_ltequalto_5y = r63_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR63_5y_lt_t_ltequalto_6y() {
		return r63_5y_lt_t_ltequalto_6y;
	}
	public void setR63_5y_lt_t_ltequalto_6y(BigDecimal r63_5y_lt_t_ltequalto_6y) {
		this.r63_5y_lt_t_ltequalto_6y = r63_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR63_6y_lt_t_ltequalto_7y() {
		return r63_6y_lt_t_ltequalto_7y;
	}
	public void setR63_6y_lt_t_ltequalto_7y(BigDecimal r63_6y_lt_t_ltequalto_7y) {
		this.r63_6y_lt_t_ltequalto_7y = r63_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR63_7y_lt_t_ltequalto_8y() {
		return r63_7y_lt_t_ltequalto_8y;
	}
	public void setR63_7y_lt_t_ltequalto_8y(BigDecimal r63_7y_lt_t_ltequalto_8y) {
		this.r63_7y_lt_t_ltequalto_8y = r63_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR63_8y_lt_t_ltequalto_9y() {
		return r63_8y_lt_t_ltequalto_9y;
	}
	public void setR63_8y_lt_t_ltequalto_9y(BigDecimal r63_8y_lt_t_ltequalto_9y) {
		this.r63_8y_lt_t_ltequalto_9y = r63_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR63_9y_lt_t_ltequalto_10y() {
		return r63_9y_lt_t_ltequalto_10y;
	}
	public void setR63_9y_lt_t_ltequalto_10y(BigDecimal r63_9y_lt_t_ltequalto_10y) {
		this.r63_9y_lt_t_ltequalto_10y = r63_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR63_10y_lt_t_ltequalto_15y() {
		return r63_10y_lt_t_ltequalto_15y;
	}
	public void setR63_10y_lt_t_ltequalto_15y(BigDecimal r63_10y_lt_t_ltequalto_15y) {
		this.r63_10y_lt_t_ltequalto_15y = r63_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR63_15y_lt_t_ltequalto_20y() {
		return r63_15y_lt_t_ltequalto_20y;
	}
	public void setR63_15y_lt_t_ltequalto_20y(BigDecimal r63_15y_lt_t_ltequalto_20y) {
		this.r63_15y_lt_t_ltequalto_20y = r63_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR63_tl_20y() {
		return r63_tl_20y;
	}
	public void setR63_tl_20y(BigDecimal r63_tl_20y) {
		this.r63_tl_20y = r63_tl_20y;
	}
	public BigDecimal getR63_nonsensitive() {
		return r63_nonsensitive;
	}
	public void setR63_nonsensitive(BigDecimal r63_nonsensitive) {
		this.r63_nonsensitive = r63_nonsensitive;
	}
	public BigDecimal getR63_total_rsl() {
		return r63_total_rsl;
	}
	public void setR63_total_rsl(BigDecimal r63_total_rsl) {
		this.r63_total_rsl = r63_total_rsl;
	}
	public BigDecimal getR63_total() {
		return r63_total;
	}
	public void setR63_total(BigDecimal r63_total) {
		this.r63_total = r63_total;
	}
	public String getR64_product() {
		return r64_product;
	}
	public void setR64_product(String r64_product) {
		this.r64_product = r64_product;
	}
	public BigDecimal getR64_tequalon() {
		return r64_tequalon;
	}
	public void setR64_tequalon(BigDecimal r64_tequalon) {
		this.r64_tequalon = r64_tequalon;
	}
	public BigDecimal getR64_on_t_equalto_1m() {
		return r64_on_t_equalto_1m;
	}
	public void setR64_on_t_equalto_1m(BigDecimal r64_on_t_equalto_1m) {
		this.r64_on_t_equalto_1m = r64_on_t_equalto_1m;
	}
	public BigDecimal getR64_1m_t_equalto_3m() {
		return r64_1m_t_equalto_3m;
	}
	public void setR64_1m_t_equalto_3m(BigDecimal r64_1m_t_equalto_3m) {
		this.r64_1m_t_equalto_3m = r64_1m_t_equalto_3m;
	}
	public BigDecimal getR64_3m_t_equalto_6m() {
		return r64_3m_t_equalto_6m;
	}
	public void setR64_3m_t_equalto_6m(BigDecimal r64_3m_t_equalto_6m) {
		this.r64_3m_t_equalto_6m = r64_3m_t_equalto_6m;
	}
	public BigDecimal getR64_6m_t_equalto_9m() {
		return r64_6m_t_equalto_9m;
	}
	public void setR64_6m_t_equalto_9m(BigDecimal r64_6m_t_equalto_9m) {
		this.r64_6m_t_equalto_9m = r64_6m_t_equalto_9m;
	}
	public BigDecimal getR64_9m_t_equalto_1y() {
		return r64_9m_t_equalto_1y;
	}
	public void setR64_9m_t_equalto_1y(BigDecimal r64_9m_t_equalto_1y) {
		this.r64_9m_t_equalto_1y = r64_9m_t_equalto_1y;
	}
	public BigDecimal getR64_1y_t_equalto_1point5y() {
		return r64_1y_t_equalto_1point5y;
	}
	public void setR64_1y_t_equalto_1point5y(BigDecimal r64_1y_t_equalto_1point5y) {
		this.r64_1y_t_equalto_1point5y = r64_1y_t_equalto_1point5y;
	}
	public BigDecimal getR64_1point5y_t_equalto_2y() {
		return r64_1point5y_t_equalto_2y;
	}
	public void setR64_1point5y_t_equalto_2y(BigDecimal r64_1point5y_t_equalto_2y) {
		this.r64_1point5y_t_equalto_2y = r64_1point5y_t_equalto_2y;
	}
	public BigDecimal getR64_2y_t_equalto_3y() {
		return r64_2y_t_equalto_3y;
	}
	public void setR64_2y_t_equalto_3y(BigDecimal r64_2y_t_equalto_3y) {
		this.r64_2y_t_equalto_3y = r64_2y_t_equalto_3y;
	}
	public BigDecimal getR64_3y_t_equalto_4y() {
		return r64_3y_t_equalto_4y;
	}
	public void setR64_3y_t_equalto_4y(BigDecimal r64_3y_t_equalto_4y) {
		this.r64_3y_t_equalto_4y = r64_3y_t_equalto_4y;
	}
	public BigDecimal getR64_4y_lt_t_ltequalto_5y() {
		return r64_4y_lt_t_ltequalto_5y;
	}
	public void setR64_4y_lt_t_ltequalto_5y(BigDecimal r64_4y_lt_t_ltequalto_5y) {
		this.r64_4y_lt_t_ltequalto_5y = r64_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR64_5y_lt_t_ltequalto_6y() {
		return r64_5y_lt_t_ltequalto_6y;
	}
	public void setR64_5y_lt_t_ltequalto_6y(BigDecimal r64_5y_lt_t_ltequalto_6y) {
		this.r64_5y_lt_t_ltequalto_6y = r64_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR64_6y_lt_t_ltequalto_7y() {
		return r64_6y_lt_t_ltequalto_7y;
	}
	public void setR64_6y_lt_t_ltequalto_7y(BigDecimal r64_6y_lt_t_ltequalto_7y) {
		this.r64_6y_lt_t_ltequalto_7y = r64_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR64_7y_lt_t_ltequalto_8y() {
		return r64_7y_lt_t_ltequalto_8y;
	}
	public void setR64_7y_lt_t_ltequalto_8y(BigDecimal r64_7y_lt_t_ltequalto_8y) {
		this.r64_7y_lt_t_ltequalto_8y = r64_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR64_8y_lt_t_ltequalto_9y() {
		return r64_8y_lt_t_ltequalto_9y;
	}
	public void setR64_8y_lt_t_ltequalto_9y(BigDecimal r64_8y_lt_t_ltequalto_9y) {
		this.r64_8y_lt_t_ltequalto_9y = r64_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR64_9y_lt_t_ltequalto_10y() {
		return r64_9y_lt_t_ltequalto_10y;
	}
	public void setR64_9y_lt_t_ltequalto_10y(BigDecimal r64_9y_lt_t_ltequalto_10y) {
		this.r64_9y_lt_t_ltequalto_10y = r64_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR64_10y_lt_t_ltequalto_15y() {
		return r64_10y_lt_t_ltequalto_15y;
	}
	public void setR64_10y_lt_t_ltequalto_15y(BigDecimal r64_10y_lt_t_ltequalto_15y) {
		this.r64_10y_lt_t_ltequalto_15y = r64_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR64_15y_lt_t_ltequalto_20y() {
		return r64_15y_lt_t_ltequalto_20y;
	}
	public void setR64_15y_lt_t_ltequalto_20y(BigDecimal r64_15y_lt_t_ltequalto_20y) {
		this.r64_15y_lt_t_ltequalto_20y = r64_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR64_tl_20y() {
		return r64_tl_20y;
	}
	public void setR64_tl_20y(BigDecimal r64_tl_20y) {
		this.r64_tl_20y = r64_tl_20y;
	}
	public BigDecimal getR64_nonsensitive() {
		return r64_nonsensitive;
	}
	public void setR64_nonsensitive(BigDecimal r64_nonsensitive) {
		this.r64_nonsensitive = r64_nonsensitive;
	}
	public BigDecimal getR64_total_rsl() {
		return r64_total_rsl;
	}
	public void setR64_total_rsl(BigDecimal r64_total_rsl) {
		this.r64_total_rsl = r64_total_rsl;
	}
	public BigDecimal getR64_total() {
		return r64_total;
	}
	public void setR64_total(BigDecimal r64_total) {
		this.r64_total = r64_total;
	}
	public String getR65_product() {
		return r65_product;
	}
	public void setR65_product(String r65_product) {
		this.r65_product = r65_product;
	}
	public BigDecimal getR65_tequalon() {
		return r65_tequalon;
	}
	public void setR65_tequalon(BigDecimal r65_tequalon) {
		this.r65_tequalon = r65_tequalon;
	}
	public BigDecimal getR65_on_t_equalto_1m() {
		return r65_on_t_equalto_1m;
	}
	public void setR65_on_t_equalto_1m(BigDecimal r65_on_t_equalto_1m) {
		this.r65_on_t_equalto_1m = r65_on_t_equalto_1m;
	}
	public BigDecimal getR65_1m_t_equalto_3m() {
		return r65_1m_t_equalto_3m;
	}
	public void setR65_1m_t_equalto_3m(BigDecimal r65_1m_t_equalto_3m) {
		this.r65_1m_t_equalto_3m = r65_1m_t_equalto_3m;
	}
	public BigDecimal getR65_3m_t_equalto_6m() {
		return r65_3m_t_equalto_6m;
	}
	public void setR65_3m_t_equalto_6m(BigDecimal r65_3m_t_equalto_6m) {
		this.r65_3m_t_equalto_6m = r65_3m_t_equalto_6m;
	}
	public BigDecimal getR65_6m_t_equalto_9m() {
		return r65_6m_t_equalto_9m;
	}
	public void setR65_6m_t_equalto_9m(BigDecimal r65_6m_t_equalto_9m) {
		this.r65_6m_t_equalto_9m = r65_6m_t_equalto_9m;
	}
	public BigDecimal getR65_9m_t_equalto_1y() {
		return r65_9m_t_equalto_1y;
	}
	public void setR65_9m_t_equalto_1y(BigDecimal r65_9m_t_equalto_1y) {
		this.r65_9m_t_equalto_1y = r65_9m_t_equalto_1y;
	}
	public BigDecimal getR65_1y_t_equalto_1point5y() {
		return r65_1y_t_equalto_1point5y;
	}
	public void setR65_1y_t_equalto_1point5y(BigDecimal r65_1y_t_equalto_1point5y) {
		this.r65_1y_t_equalto_1point5y = r65_1y_t_equalto_1point5y;
	}
	public BigDecimal getR65_1point5y_t_equalto_2y() {
		return r65_1point5y_t_equalto_2y;
	}
	public void setR65_1point5y_t_equalto_2y(BigDecimal r65_1point5y_t_equalto_2y) {
		this.r65_1point5y_t_equalto_2y = r65_1point5y_t_equalto_2y;
	}
	public BigDecimal getR65_2y_t_equalto_3y() {
		return r65_2y_t_equalto_3y;
	}
	public void setR65_2y_t_equalto_3y(BigDecimal r65_2y_t_equalto_3y) {
		this.r65_2y_t_equalto_3y = r65_2y_t_equalto_3y;
	}
	public BigDecimal getR65_3y_t_equalto_4y() {
		return r65_3y_t_equalto_4y;
	}
	public void setR65_3y_t_equalto_4y(BigDecimal r65_3y_t_equalto_4y) {
		this.r65_3y_t_equalto_4y = r65_3y_t_equalto_4y;
	}
	public BigDecimal getR65_4y_lt_t_ltequalto_5y() {
		return r65_4y_lt_t_ltequalto_5y;
	}
	public void setR65_4y_lt_t_ltequalto_5y(BigDecimal r65_4y_lt_t_ltequalto_5y) {
		this.r65_4y_lt_t_ltequalto_5y = r65_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR65_5y_lt_t_ltequalto_6y() {
		return r65_5y_lt_t_ltequalto_6y;
	}
	public void setR65_5y_lt_t_ltequalto_6y(BigDecimal r65_5y_lt_t_ltequalto_6y) {
		this.r65_5y_lt_t_ltequalto_6y = r65_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR65_6y_lt_t_ltequalto_7y() {
		return r65_6y_lt_t_ltequalto_7y;
	}
	public void setR65_6y_lt_t_ltequalto_7y(BigDecimal r65_6y_lt_t_ltequalto_7y) {
		this.r65_6y_lt_t_ltequalto_7y = r65_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR65_7y_lt_t_ltequalto_8y() {
		return r65_7y_lt_t_ltequalto_8y;
	}
	public void setR65_7y_lt_t_ltequalto_8y(BigDecimal r65_7y_lt_t_ltequalto_8y) {
		this.r65_7y_lt_t_ltequalto_8y = r65_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR65_8y_lt_t_ltequalto_9y() {
		return r65_8y_lt_t_ltequalto_9y;
	}
	public void setR65_8y_lt_t_ltequalto_9y(BigDecimal r65_8y_lt_t_ltequalto_9y) {
		this.r65_8y_lt_t_ltequalto_9y = r65_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR65_9y_lt_t_ltequalto_10y() {
		return r65_9y_lt_t_ltequalto_10y;
	}
	public void setR65_9y_lt_t_ltequalto_10y(BigDecimal r65_9y_lt_t_ltequalto_10y) {
		this.r65_9y_lt_t_ltequalto_10y = r65_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR65_10y_lt_t_ltequalto_15y() {
		return r65_10y_lt_t_ltequalto_15y;
	}
	public void setR65_10y_lt_t_ltequalto_15y(BigDecimal r65_10y_lt_t_ltequalto_15y) {
		this.r65_10y_lt_t_ltequalto_15y = r65_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR65_15y_lt_t_ltequalto_20y() {
		return r65_15y_lt_t_ltequalto_20y;
	}
	public void setR65_15y_lt_t_ltequalto_20y(BigDecimal r65_15y_lt_t_ltequalto_20y) {
		this.r65_15y_lt_t_ltequalto_20y = r65_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR65_tl_20y() {
		return r65_tl_20y;
	}
	public void setR65_tl_20y(BigDecimal r65_tl_20y) {
		this.r65_tl_20y = r65_tl_20y;
	}
	public BigDecimal getR65_nonsensitive() {
		return r65_nonsensitive;
	}
	public void setR65_nonsensitive(BigDecimal r65_nonsensitive) {
		this.r65_nonsensitive = r65_nonsensitive;
	}
	public BigDecimal getR65_total_rsl() {
		return r65_total_rsl;
	}
	public void setR65_total_rsl(BigDecimal r65_total_rsl) {
		this.r65_total_rsl = r65_total_rsl;
	}
	public BigDecimal getR65_total() {
		return r65_total;
	}
	public void setR65_total(BigDecimal r65_total) {
		this.r65_total = r65_total;
	}
	public String getR66_product() {
		return r66_product;
	}
	public void setR66_product(String r66_product) {
		this.r66_product = r66_product;
	}
	public BigDecimal getR66_tequalon() {
		return r66_tequalon;
	}
	public void setR66_tequalon(BigDecimal r66_tequalon) {
		this.r66_tequalon = r66_tequalon;
	}
	public BigDecimal getR66_on_t_equalto_1m() {
		return r66_on_t_equalto_1m;
	}
	public void setR66_on_t_equalto_1m(BigDecimal r66_on_t_equalto_1m) {
		this.r66_on_t_equalto_1m = r66_on_t_equalto_1m;
	}
	public BigDecimal getR66_1m_t_equalto_3m() {
		return r66_1m_t_equalto_3m;
	}
	public void setR66_1m_t_equalto_3m(BigDecimal r66_1m_t_equalto_3m) {
		this.r66_1m_t_equalto_3m = r66_1m_t_equalto_3m;
	}
	public BigDecimal getR66_3m_t_equalto_6m() {
		return r66_3m_t_equalto_6m;
	}
	public void setR66_3m_t_equalto_6m(BigDecimal r66_3m_t_equalto_6m) {
		this.r66_3m_t_equalto_6m = r66_3m_t_equalto_6m;
	}
	public BigDecimal getR66_6m_t_equalto_9m() {
		return r66_6m_t_equalto_9m;
	}
	public void setR66_6m_t_equalto_9m(BigDecimal r66_6m_t_equalto_9m) {
		this.r66_6m_t_equalto_9m = r66_6m_t_equalto_9m;
	}
	public BigDecimal getR66_9m_t_equalto_1y() {
		return r66_9m_t_equalto_1y;
	}
	public void setR66_9m_t_equalto_1y(BigDecimal r66_9m_t_equalto_1y) {
		this.r66_9m_t_equalto_1y = r66_9m_t_equalto_1y;
	}
	public BigDecimal getR66_1y_t_equalto_1point5y() {
		return r66_1y_t_equalto_1point5y;
	}
	public void setR66_1y_t_equalto_1point5y(BigDecimal r66_1y_t_equalto_1point5y) {
		this.r66_1y_t_equalto_1point5y = r66_1y_t_equalto_1point5y;
	}
	public BigDecimal getR66_1point5y_t_equalto_2y() {
		return r66_1point5y_t_equalto_2y;
	}
	public void setR66_1point5y_t_equalto_2y(BigDecimal r66_1point5y_t_equalto_2y) {
		this.r66_1point5y_t_equalto_2y = r66_1point5y_t_equalto_2y;
	}
	public BigDecimal getR66_2y_t_equalto_3y() {
		return r66_2y_t_equalto_3y;
	}
	public void setR66_2y_t_equalto_3y(BigDecimal r66_2y_t_equalto_3y) {
		this.r66_2y_t_equalto_3y = r66_2y_t_equalto_3y;
	}
	public BigDecimal getR66_3y_t_equalto_4y() {
		return r66_3y_t_equalto_4y;
	}
	public void setR66_3y_t_equalto_4y(BigDecimal r66_3y_t_equalto_4y) {
		this.r66_3y_t_equalto_4y = r66_3y_t_equalto_4y;
	}
	public BigDecimal getR66_4y_lt_t_ltequalto_5y() {
		return r66_4y_lt_t_ltequalto_5y;
	}
	public void setR66_4y_lt_t_ltequalto_5y(BigDecimal r66_4y_lt_t_ltequalto_5y) {
		this.r66_4y_lt_t_ltequalto_5y = r66_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR66_5y_lt_t_ltequalto_6y() {
		return r66_5y_lt_t_ltequalto_6y;
	}
	public void setR66_5y_lt_t_ltequalto_6y(BigDecimal r66_5y_lt_t_ltequalto_6y) {
		this.r66_5y_lt_t_ltequalto_6y = r66_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR66_6y_lt_t_ltequalto_7y() {
		return r66_6y_lt_t_ltequalto_7y;
	}
	public void setR66_6y_lt_t_ltequalto_7y(BigDecimal r66_6y_lt_t_ltequalto_7y) {
		this.r66_6y_lt_t_ltequalto_7y = r66_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR66_7y_lt_t_ltequalto_8y() {
		return r66_7y_lt_t_ltequalto_8y;
	}
	public void setR66_7y_lt_t_ltequalto_8y(BigDecimal r66_7y_lt_t_ltequalto_8y) {
		this.r66_7y_lt_t_ltequalto_8y = r66_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR66_8y_lt_t_ltequalto_9y() {
		return r66_8y_lt_t_ltequalto_9y;
	}
	public void setR66_8y_lt_t_ltequalto_9y(BigDecimal r66_8y_lt_t_ltequalto_9y) {
		this.r66_8y_lt_t_ltequalto_9y = r66_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR66_9y_lt_t_ltequalto_10y() {
		return r66_9y_lt_t_ltequalto_10y;
	}
	public void setR66_9y_lt_t_ltequalto_10y(BigDecimal r66_9y_lt_t_ltequalto_10y) {
		this.r66_9y_lt_t_ltequalto_10y = r66_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR66_10y_lt_t_ltequalto_15y() {
		return r66_10y_lt_t_ltequalto_15y;
	}
	public void setR66_10y_lt_t_ltequalto_15y(BigDecimal r66_10y_lt_t_ltequalto_15y) {
		this.r66_10y_lt_t_ltequalto_15y = r66_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR66_15y_lt_t_ltequalto_20y() {
		return r66_15y_lt_t_ltequalto_20y;
	}
	public void setR66_15y_lt_t_ltequalto_20y(BigDecimal r66_15y_lt_t_ltequalto_20y) {
		this.r66_15y_lt_t_ltequalto_20y = r66_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR66_tl_20y() {
		return r66_tl_20y;
	}
	public void setR66_tl_20y(BigDecimal r66_tl_20y) {
		this.r66_tl_20y = r66_tl_20y;
	}
	public BigDecimal getR66_nonsensitive() {
		return r66_nonsensitive;
	}
	public void setR66_nonsensitive(BigDecimal r66_nonsensitive) {
		this.r66_nonsensitive = r66_nonsensitive;
	}
	public BigDecimal getR66_total_rsl() {
		return r66_total_rsl;
	}
	public void setR66_total_rsl(BigDecimal r66_total_rsl) {
		this.r66_total_rsl = r66_total_rsl;
	}
	public BigDecimal getR66_total() {
		return r66_total;
	}
	public void setR66_total(BigDecimal r66_total) {
		this.r66_total = r66_total;
	}
	public String getR67_product() {
		return r67_product;
	}
	public void setR67_product(String r67_product) {
		this.r67_product = r67_product;
	}
	public BigDecimal getR67_tequalon() {
		return r67_tequalon;
	}
	public void setR67_tequalon(BigDecimal r67_tequalon) {
		this.r67_tequalon = r67_tequalon;
	}
	public BigDecimal getR67_on_t_equalto_1m() {
		return r67_on_t_equalto_1m;
	}
	public void setR67_on_t_equalto_1m(BigDecimal r67_on_t_equalto_1m) {
		this.r67_on_t_equalto_1m = r67_on_t_equalto_1m;
	}
	public BigDecimal getR67_1m_t_equalto_3m() {
		return r67_1m_t_equalto_3m;
	}
	public void setR67_1m_t_equalto_3m(BigDecimal r67_1m_t_equalto_3m) {
		this.r67_1m_t_equalto_3m = r67_1m_t_equalto_3m;
	}
	public BigDecimal getR67_3m_t_equalto_6m() {
		return r67_3m_t_equalto_6m;
	}
	public void setR67_3m_t_equalto_6m(BigDecimal r67_3m_t_equalto_6m) {
		this.r67_3m_t_equalto_6m = r67_3m_t_equalto_6m;
	}
	public BigDecimal getR67_6m_t_equalto_9m() {
		return r67_6m_t_equalto_9m;
	}
	public void setR67_6m_t_equalto_9m(BigDecimal r67_6m_t_equalto_9m) {
		this.r67_6m_t_equalto_9m = r67_6m_t_equalto_9m;
	}
	public BigDecimal getR67_9m_t_equalto_1y() {
		return r67_9m_t_equalto_1y;
	}
	public void setR67_9m_t_equalto_1y(BigDecimal r67_9m_t_equalto_1y) {
		this.r67_9m_t_equalto_1y = r67_9m_t_equalto_1y;
	}
	public BigDecimal getR67_1y_t_equalto_1point5y() {
		return r67_1y_t_equalto_1point5y;
	}
	public void setR67_1y_t_equalto_1point5y(BigDecimal r67_1y_t_equalto_1point5y) {
		this.r67_1y_t_equalto_1point5y = r67_1y_t_equalto_1point5y;
	}
	public BigDecimal getR67_1point5y_t_equalto_2y() {
		return r67_1point5y_t_equalto_2y;
	}
	public void setR67_1point5y_t_equalto_2y(BigDecimal r67_1point5y_t_equalto_2y) {
		this.r67_1point5y_t_equalto_2y = r67_1point5y_t_equalto_2y;
	}
	public BigDecimal getR67_2y_t_equalto_3y() {
		return r67_2y_t_equalto_3y;
	}
	public void setR67_2y_t_equalto_3y(BigDecimal r67_2y_t_equalto_3y) {
		this.r67_2y_t_equalto_3y = r67_2y_t_equalto_3y;
	}
	public BigDecimal getR67_3y_t_equalto_4y() {
		return r67_3y_t_equalto_4y;
	}
	public void setR67_3y_t_equalto_4y(BigDecimal r67_3y_t_equalto_4y) {
		this.r67_3y_t_equalto_4y = r67_3y_t_equalto_4y;
	}
	public BigDecimal getR67_4y_lt_t_ltequalto_5y() {
		return r67_4y_lt_t_ltequalto_5y;
	}
	public void setR67_4y_lt_t_ltequalto_5y(BigDecimal r67_4y_lt_t_ltequalto_5y) {
		this.r67_4y_lt_t_ltequalto_5y = r67_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR67_5y_lt_t_ltequalto_6y() {
		return r67_5y_lt_t_ltequalto_6y;
	}
	public void setR67_5y_lt_t_ltequalto_6y(BigDecimal r67_5y_lt_t_ltequalto_6y) {
		this.r67_5y_lt_t_ltequalto_6y = r67_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR67_6y_lt_t_ltequalto_7y() {
		return r67_6y_lt_t_ltequalto_7y;
	}
	public void setR67_6y_lt_t_ltequalto_7y(BigDecimal r67_6y_lt_t_ltequalto_7y) {
		this.r67_6y_lt_t_ltequalto_7y = r67_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR67_7y_lt_t_ltequalto_8y() {
		return r67_7y_lt_t_ltequalto_8y;
	}
	public void setR67_7y_lt_t_ltequalto_8y(BigDecimal r67_7y_lt_t_ltequalto_8y) {
		this.r67_7y_lt_t_ltequalto_8y = r67_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR67_8y_lt_t_ltequalto_9y() {
		return r67_8y_lt_t_ltequalto_9y;
	}
	public void setR67_8y_lt_t_ltequalto_9y(BigDecimal r67_8y_lt_t_ltequalto_9y) {
		this.r67_8y_lt_t_ltequalto_9y = r67_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR67_9y_lt_t_ltequalto_10y() {
		return r67_9y_lt_t_ltequalto_10y;
	}
	public void setR67_9y_lt_t_ltequalto_10y(BigDecimal r67_9y_lt_t_ltequalto_10y) {
		this.r67_9y_lt_t_ltequalto_10y = r67_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR67_10y_lt_t_ltequalto_15y() {
		return r67_10y_lt_t_ltequalto_15y;
	}
	public void setR67_10y_lt_t_ltequalto_15y(BigDecimal r67_10y_lt_t_ltequalto_15y) {
		this.r67_10y_lt_t_ltequalto_15y = r67_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR67_15y_lt_t_ltequalto_20y() {
		return r67_15y_lt_t_ltequalto_20y;
	}
	public void setR67_15y_lt_t_ltequalto_20y(BigDecimal r67_15y_lt_t_ltequalto_20y) {
		this.r67_15y_lt_t_ltequalto_20y = r67_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR67_tl_20y() {
		return r67_tl_20y;
	}
	public void setR67_tl_20y(BigDecimal r67_tl_20y) {
		this.r67_tl_20y = r67_tl_20y;
	}
	public BigDecimal getR67_nonsensitive() {
		return r67_nonsensitive;
	}
	public void setR67_nonsensitive(BigDecimal r67_nonsensitive) {
		this.r67_nonsensitive = r67_nonsensitive;
	}
	public BigDecimal getR67_total_rsl() {
		return r67_total_rsl;
	}
	public void setR67_total_rsl(BigDecimal r67_total_rsl) {
		this.r67_total_rsl = r67_total_rsl;
	}
	public BigDecimal getR67_total() {
		return r67_total;
	}
	public void setR67_total(BigDecimal r67_total) {
		this.r67_total = r67_total;
	}
	public String getR68_product() {
		return r68_product;
	}
	public void setR68_product(String r68_product) {
		this.r68_product = r68_product;
	}
	public BigDecimal getR68_tequalon() {
		return r68_tequalon;
	}
	public void setR68_tequalon(BigDecimal r68_tequalon) {
		this.r68_tequalon = r68_tequalon;
	}
	public BigDecimal getR68_on_t_equalto_1m() {
		return r68_on_t_equalto_1m;
	}
	public void setR68_on_t_equalto_1m(BigDecimal r68_on_t_equalto_1m) {
		this.r68_on_t_equalto_1m = r68_on_t_equalto_1m;
	}
	public BigDecimal getR68_1m_t_equalto_3m() {
		return r68_1m_t_equalto_3m;
	}
	public void setR68_1m_t_equalto_3m(BigDecimal r68_1m_t_equalto_3m) {
		this.r68_1m_t_equalto_3m = r68_1m_t_equalto_3m;
	}
	public BigDecimal getR68_3m_t_equalto_6m() {
		return r68_3m_t_equalto_6m;
	}
	public void setR68_3m_t_equalto_6m(BigDecimal r68_3m_t_equalto_6m) {
		this.r68_3m_t_equalto_6m = r68_3m_t_equalto_6m;
	}
	public BigDecimal getR68_6m_t_equalto_9m() {
		return r68_6m_t_equalto_9m;
	}
	public void setR68_6m_t_equalto_9m(BigDecimal r68_6m_t_equalto_9m) {
		this.r68_6m_t_equalto_9m = r68_6m_t_equalto_9m;
	}
	public BigDecimal getR68_9m_t_equalto_1y() {
		return r68_9m_t_equalto_1y;
	}
	public void setR68_9m_t_equalto_1y(BigDecimal r68_9m_t_equalto_1y) {
		this.r68_9m_t_equalto_1y = r68_9m_t_equalto_1y;
	}
	public BigDecimal getR68_1y_t_equalto_1point5y() {
		return r68_1y_t_equalto_1point5y;
	}
	public void setR68_1y_t_equalto_1point5y(BigDecimal r68_1y_t_equalto_1point5y) {
		this.r68_1y_t_equalto_1point5y = r68_1y_t_equalto_1point5y;
	}
	public BigDecimal getR68_1point5y_t_equalto_2y() {
		return r68_1point5y_t_equalto_2y;
	}
	public void setR68_1point5y_t_equalto_2y(BigDecimal r68_1point5y_t_equalto_2y) {
		this.r68_1point5y_t_equalto_2y = r68_1point5y_t_equalto_2y;
	}
	public BigDecimal getR68_2y_t_equalto_3y() {
		return r68_2y_t_equalto_3y;
	}
	public void setR68_2y_t_equalto_3y(BigDecimal r68_2y_t_equalto_3y) {
		this.r68_2y_t_equalto_3y = r68_2y_t_equalto_3y;
	}
	public BigDecimal getR68_3y_t_equalto_4y() {
		return r68_3y_t_equalto_4y;
	}
	public void setR68_3y_t_equalto_4y(BigDecimal r68_3y_t_equalto_4y) {
		this.r68_3y_t_equalto_4y = r68_3y_t_equalto_4y;
	}
	public BigDecimal getR68_4y_lt_t_ltequalto_5y() {
		return r68_4y_lt_t_ltequalto_5y;
	}
	public void setR68_4y_lt_t_ltequalto_5y(BigDecimal r68_4y_lt_t_ltequalto_5y) {
		this.r68_4y_lt_t_ltequalto_5y = r68_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR68_5y_lt_t_ltequalto_6y() {
		return r68_5y_lt_t_ltequalto_6y;
	}
	public void setR68_5y_lt_t_ltequalto_6y(BigDecimal r68_5y_lt_t_ltequalto_6y) {
		this.r68_5y_lt_t_ltequalto_6y = r68_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR68_6y_lt_t_ltequalto_7y() {
		return r68_6y_lt_t_ltequalto_7y;
	}
	public void setR68_6y_lt_t_ltequalto_7y(BigDecimal r68_6y_lt_t_ltequalto_7y) {
		this.r68_6y_lt_t_ltequalto_7y = r68_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR68_7y_lt_t_ltequalto_8y() {
		return r68_7y_lt_t_ltequalto_8y;
	}
	public void setR68_7y_lt_t_ltequalto_8y(BigDecimal r68_7y_lt_t_ltequalto_8y) {
		this.r68_7y_lt_t_ltequalto_8y = r68_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR68_8y_lt_t_ltequalto_9y() {
		return r68_8y_lt_t_ltequalto_9y;
	}
	public void setR68_8y_lt_t_ltequalto_9y(BigDecimal r68_8y_lt_t_ltequalto_9y) {
		this.r68_8y_lt_t_ltequalto_9y = r68_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR68_9y_lt_t_ltequalto_10y() {
		return r68_9y_lt_t_ltequalto_10y;
	}
	public void setR68_9y_lt_t_ltequalto_10y(BigDecimal r68_9y_lt_t_ltequalto_10y) {
		this.r68_9y_lt_t_ltequalto_10y = r68_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR68_10y_lt_t_ltequalto_15y() {
		return r68_10y_lt_t_ltequalto_15y;
	}
	public void setR68_10y_lt_t_ltequalto_15y(BigDecimal r68_10y_lt_t_ltequalto_15y) {
		this.r68_10y_lt_t_ltequalto_15y = r68_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR68_15y_lt_t_ltequalto_20y() {
		return r68_15y_lt_t_ltequalto_20y;
	}
	public void setR68_15y_lt_t_ltequalto_20y(BigDecimal r68_15y_lt_t_ltequalto_20y) {
		this.r68_15y_lt_t_ltequalto_20y = r68_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR68_tl_20y() {
		return r68_tl_20y;
	}
	public void setR68_tl_20y(BigDecimal r68_tl_20y) {
		this.r68_tl_20y = r68_tl_20y;
	}
	public BigDecimal getR68_nonsensitive() {
		return r68_nonsensitive;
	}
	public void setR68_nonsensitive(BigDecimal r68_nonsensitive) {
		this.r68_nonsensitive = r68_nonsensitive;
	}
	public BigDecimal getR68_total_rsl() {
		return r68_total_rsl;
	}
	public void setR68_total_rsl(BigDecimal r68_total_rsl) {
		this.r68_total_rsl = r68_total_rsl;
	}
	public BigDecimal getR68_total() {
		return r68_total;
	}
	public void setR68_total(BigDecimal r68_total) {
		this.r68_total = r68_total;
	}
	public String getR69_product() {
		return r69_product;
	}
	public void setR69_product(String r69_product) {
		this.r69_product = r69_product;
	}
	public BigDecimal getR69_tequalon() {
		return r69_tequalon;
	}
	public void setR69_tequalon(BigDecimal r69_tequalon) {
		this.r69_tequalon = r69_tequalon;
	}
	public BigDecimal getR69_on_t_equalto_1m() {
		return r69_on_t_equalto_1m;
	}
	public void setR69_on_t_equalto_1m(BigDecimal r69_on_t_equalto_1m) {
		this.r69_on_t_equalto_1m = r69_on_t_equalto_1m;
	}
	public BigDecimal getR69_1m_t_equalto_3m() {
		return r69_1m_t_equalto_3m;
	}
	public void setR69_1m_t_equalto_3m(BigDecimal r69_1m_t_equalto_3m) {
		this.r69_1m_t_equalto_3m = r69_1m_t_equalto_3m;
	}
	public BigDecimal getR69_3m_t_equalto_6m() {
		return r69_3m_t_equalto_6m;
	}
	public void setR69_3m_t_equalto_6m(BigDecimal r69_3m_t_equalto_6m) {
		this.r69_3m_t_equalto_6m = r69_3m_t_equalto_6m;
	}
	public BigDecimal getR69_6m_t_equalto_9m() {
		return r69_6m_t_equalto_9m;
	}
	public void setR69_6m_t_equalto_9m(BigDecimal r69_6m_t_equalto_9m) {
		this.r69_6m_t_equalto_9m = r69_6m_t_equalto_9m;
	}
	public BigDecimal getR69_9m_t_equalto_1y() {
		return r69_9m_t_equalto_1y;
	}
	public void setR69_9m_t_equalto_1y(BigDecimal r69_9m_t_equalto_1y) {
		this.r69_9m_t_equalto_1y = r69_9m_t_equalto_1y;
	}
	public BigDecimal getR69_1y_t_equalto_1point5y() {
		return r69_1y_t_equalto_1point5y;
	}
	public void setR69_1y_t_equalto_1point5y(BigDecimal r69_1y_t_equalto_1point5y) {
		this.r69_1y_t_equalto_1point5y = r69_1y_t_equalto_1point5y;
	}
	public BigDecimal getR69_1point5y_t_equalto_2y() {
		return r69_1point5y_t_equalto_2y;
	}
	public void setR69_1point5y_t_equalto_2y(BigDecimal r69_1point5y_t_equalto_2y) {
		this.r69_1point5y_t_equalto_2y = r69_1point5y_t_equalto_2y;
	}
	public BigDecimal getR69_2y_t_equalto_3y() {
		return r69_2y_t_equalto_3y;
	}
	public void setR69_2y_t_equalto_3y(BigDecimal r69_2y_t_equalto_3y) {
		this.r69_2y_t_equalto_3y = r69_2y_t_equalto_3y;
	}
	public BigDecimal getR69_3y_t_equalto_4y() {
		return r69_3y_t_equalto_4y;
	}
	public void setR69_3y_t_equalto_4y(BigDecimal r69_3y_t_equalto_4y) {
		this.r69_3y_t_equalto_4y = r69_3y_t_equalto_4y;
	}
	public BigDecimal getR69_4y_lt_t_ltequalto_5y() {
		return r69_4y_lt_t_ltequalto_5y;
	}
	public void setR69_4y_lt_t_ltequalto_5y(BigDecimal r69_4y_lt_t_ltequalto_5y) {
		this.r69_4y_lt_t_ltequalto_5y = r69_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR69_5y_lt_t_ltequalto_6y() {
		return r69_5y_lt_t_ltequalto_6y;
	}
	public void setR69_5y_lt_t_ltequalto_6y(BigDecimal r69_5y_lt_t_ltequalto_6y) {
		this.r69_5y_lt_t_ltequalto_6y = r69_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR69_6y_lt_t_ltequalto_7y() {
		return r69_6y_lt_t_ltequalto_7y;
	}
	public void setR69_6y_lt_t_ltequalto_7y(BigDecimal r69_6y_lt_t_ltequalto_7y) {
		this.r69_6y_lt_t_ltequalto_7y = r69_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR69_7y_lt_t_ltequalto_8y() {
		return r69_7y_lt_t_ltequalto_8y;
	}
	public void setR69_7y_lt_t_ltequalto_8y(BigDecimal r69_7y_lt_t_ltequalto_8y) {
		this.r69_7y_lt_t_ltequalto_8y = r69_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR69_8y_lt_t_ltequalto_9y() {
		return r69_8y_lt_t_ltequalto_9y;
	}
	public void setR69_8y_lt_t_ltequalto_9y(BigDecimal r69_8y_lt_t_ltequalto_9y) {
		this.r69_8y_lt_t_ltequalto_9y = r69_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR69_9y_lt_t_ltequalto_10y() {
		return r69_9y_lt_t_ltequalto_10y;
	}
	public void setR69_9y_lt_t_ltequalto_10y(BigDecimal r69_9y_lt_t_ltequalto_10y) {
		this.r69_9y_lt_t_ltequalto_10y = r69_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR69_10y_lt_t_ltequalto_15y() {
		return r69_10y_lt_t_ltequalto_15y;
	}
	public void setR69_10y_lt_t_ltequalto_15y(BigDecimal r69_10y_lt_t_ltequalto_15y) {
		this.r69_10y_lt_t_ltequalto_15y = r69_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR69_15y_lt_t_ltequalto_20y() {
		return r69_15y_lt_t_ltequalto_20y;
	}
	public void setR69_15y_lt_t_ltequalto_20y(BigDecimal r69_15y_lt_t_ltequalto_20y) {
		this.r69_15y_lt_t_ltequalto_20y = r69_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR69_tl_20y() {
		return r69_tl_20y;
	}
	public void setR69_tl_20y(BigDecimal r69_tl_20y) {
		this.r69_tl_20y = r69_tl_20y;
	}
	public BigDecimal getR69_nonsensitive() {
		return r69_nonsensitive;
	}
	public void setR69_nonsensitive(BigDecimal r69_nonsensitive) {
		this.r69_nonsensitive = r69_nonsensitive;
	}
	public BigDecimal getR69_total_rsl() {
		return r69_total_rsl;
	}
	public void setR69_total_rsl(BigDecimal r69_total_rsl) {
		this.r69_total_rsl = r69_total_rsl;
	}
	public BigDecimal getR69_total() {
		return r69_total;
	}
	public void setR69_total(BigDecimal r69_total) {
		this.r69_total = r69_total;
	}
	public String getR70_product() {
		return r70_product;
	}
	public void setR70_product(String r70_product) {
		this.r70_product = r70_product;
	}
	public BigDecimal getR70_tequalon() {
		return r70_tequalon;
	}
	public void setR70_tequalon(BigDecimal r70_tequalon) {
		this.r70_tequalon = r70_tequalon;
	}
	public BigDecimal getR70_on_t_equalto_1m() {
		return r70_on_t_equalto_1m;
	}
	public void setR70_on_t_equalto_1m(BigDecimal r70_on_t_equalto_1m) {
		this.r70_on_t_equalto_1m = r70_on_t_equalto_1m;
	}
	public BigDecimal getR70_1m_t_equalto_3m() {
		return r70_1m_t_equalto_3m;
	}
	public void setR70_1m_t_equalto_3m(BigDecimal r70_1m_t_equalto_3m) {
		this.r70_1m_t_equalto_3m = r70_1m_t_equalto_3m;
	}
	public BigDecimal getR70_3m_t_equalto_6m() {
		return r70_3m_t_equalto_6m;
	}
	public void setR70_3m_t_equalto_6m(BigDecimal r70_3m_t_equalto_6m) {
		this.r70_3m_t_equalto_6m = r70_3m_t_equalto_6m;
	}
	public BigDecimal getR70_6m_t_equalto_9m() {
		return r70_6m_t_equalto_9m;
	}
	public void setR70_6m_t_equalto_9m(BigDecimal r70_6m_t_equalto_9m) {
		this.r70_6m_t_equalto_9m = r70_6m_t_equalto_9m;
	}
	public BigDecimal getR70_9m_t_equalto_1y() {
		return r70_9m_t_equalto_1y;
	}
	public void setR70_9m_t_equalto_1y(BigDecimal r70_9m_t_equalto_1y) {
		this.r70_9m_t_equalto_1y = r70_9m_t_equalto_1y;
	}
	public BigDecimal getR70_1y_t_equalto_1point5y() {
		return r70_1y_t_equalto_1point5y;
	}
	public void setR70_1y_t_equalto_1point5y(BigDecimal r70_1y_t_equalto_1point5y) {
		this.r70_1y_t_equalto_1point5y = r70_1y_t_equalto_1point5y;
	}
	public BigDecimal getR70_1point5y_t_equalto_2y() {
		return r70_1point5y_t_equalto_2y;
	}
	public void setR70_1point5y_t_equalto_2y(BigDecimal r70_1point5y_t_equalto_2y) {
		this.r70_1point5y_t_equalto_2y = r70_1point5y_t_equalto_2y;
	}
	public BigDecimal getR70_2y_t_equalto_3y() {
		return r70_2y_t_equalto_3y;
	}
	public void setR70_2y_t_equalto_3y(BigDecimal r70_2y_t_equalto_3y) {
		this.r70_2y_t_equalto_3y = r70_2y_t_equalto_3y;
	}
	public BigDecimal getR70_3y_t_equalto_4y() {
		return r70_3y_t_equalto_4y;
	}
	public void setR70_3y_t_equalto_4y(BigDecimal r70_3y_t_equalto_4y) {
		this.r70_3y_t_equalto_4y = r70_3y_t_equalto_4y;
	}
	public BigDecimal getR70_4y_lt_t_ltequalto_5y() {
		return r70_4y_lt_t_ltequalto_5y;
	}
	public void setR70_4y_lt_t_ltequalto_5y(BigDecimal r70_4y_lt_t_ltequalto_5y) {
		this.r70_4y_lt_t_ltequalto_5y = r70_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR70_5y_lt_t_ltequalto_6y() {
		return r70_5y_lt_t_ltequalto_6y;
	}
	public void setR70_5y_lt_t_ltequalto_6y(BigDecimal r70_5y_lt_t_ltequalto_6y) {
		this.r70_5y_lt_t_ltequalto_6y = r70_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR70_6y_lt_t_ltequalto_7y() {
		return r70_6y_lt_t_ltequalto_7y;
	}
	public void setR70_6y_lt_t_ltequalto_7y(BigDecimal r70_6y_lt_t_ltequalto_7y) {
		this.r70_6y_lt_t_ltequalto_7y = r70_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR70_7y_lt_t_ltequalto_8y() {
		return r70_7y_lt_t_ltequalto_8y;
	}
	public void setR70_7y_lt_t_ltequalto_8y(BigDecimal r70_7y_lt_t_ltequalto_8y) {
		this.r70_7y_lt_t_ltequalto_8y = r70_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR70_8y_lt_t_ltequalto_9y() {
		return r70_8y_lt_t_ltequalto_9y;
	}
	public void setR70_8y_lt_t_ltequalto_9y(BigDecimal r70_8y_lt_t_ltequalto_9y) {
		this.r70_8y_lt_t_ltequalto_9y = r70_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR70_9y_lt_t_ltequalto_10y() {
		return r70_9y_lt_t_ltequalto_10y;
	}
	public void setR70_9y_lt_t_ltequalto_10y(BigDecimal r70_9y_lt_t_ltequalto_10y) {
		this.r70_9y_lt_t_ltequalto_10y = r70_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR70_10y_lt_t_ltequalto_15y() {
		return r70_10y_lt_t_ltequalto_15y;
	}
	public void setR70_10y_lt_t_ltequalto_15y(BigDecimal r70_10y_lt_t_ltequalto_15y) {
		this.r70_10y_lt_t_ltequalto_15y = r70_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR70_15y_lt_t_ltequalto_20y() {
		return r70_15y_lt_t_ltequalto_20y;
	}
	public void setR70_15y_lt_t_ltequalto_20y(BigDecimal r70_15y_lt_t_ltequalto_20y) {
		this.r70_15y_lt_t_ltequalto_20y = r70_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR70_tl_20y() {
		return r70_tl_20y;
	}
	public void setR70_tl_20y(BigDecimal r70_tl_20y) {
		this.r70_tl_20y = r70_tl_20y;
	}
	public BigDecimal getR70_nonsensitive() {
		return r70_nonsensitive;
	}
	public void setR70_nonsensitive(BigDecimal r70_nonsensitive) {
		this.r70_nonsensitive = r70_nonsensitive;
	}
	public BigDecimal getR70_total_rsl() {
		return r70_total_rsl;
	}
	public void setR70_total_rsl(BigDecimal r70_total_rsl) {
		this.r70_total_rsl = r70_total_rsl;
	}
	public BigDecimal getR70_total() {
		return r70_total;
	}
	public void setR70_total(BigDecimal r70_total) {
		this.r70_total = r70_total;
	}
	public String getR71_product() {
		return r71_product;
	}
	public void setR71_product(String r71_product) {
		this.r71_product = r71_product;
	}
	public BigDecimal getR71_tequalon() {
		return r71_tequalon;
	}
	public void setR71_tequalon(BigDecimal r71_tequalon) {
		this.r71_tequalon = r71_tequalon;
	}
	public BigDecimal getR71_on_t_equalto_1m() {
		return r71_on_t_equalto_1m;
	}
	public void setR71_on_t_equalto_1m(BigDecimal r71_on_t_equalto_1m) {
		this.r71_on_t_equalto_1m = r71_on_t_equalto_1m;
	}
	public BigDecimal getR71_1m_t_equalto_3m() {
		return r71_1m_t_equalto_3m;
	}
	public void setR71_1m_t_equalto_3m(BigDecimal r71_1m_t_equalto_3m) {
		this.r71_1m_t_equalto_3m = r71_1m_t_equalto_3m;
	}
	public BigDecimal getR71_3m_t_equalto_6m() {
		return r71_3m_t_equalto_6m;
	}
	public void setR71_3m_t_equalto_6m(BigDecimal r71_3m_t_equalto_6m) {
		this.r71_3m_t_equalto_6m = r71_3m_t_equalto_6m;
	}
	public BigDecimal getR71_6m_t_equalto_9m() {
		return r71_6m_t_equalto_9m;
	}
	public void setR71_6m_t_equalto_9m(BigDecimal r71_6m_t_equalto_9m) {
		this.r71_6m_t_equalto_9m = r71_6m_t_equalto_9m;
	}
	public BigDecimal getR71_9m_t_equalto_1y() {
		return r71_9m_t_equalto_1y;
	}
	public void setR71_9m_t_equalto_1y(BigDecimal r71_9m_t_equalto_1y) {
		this.r71_9m_t_equalto_1y = r71_9m_t_equalto_1y;
	}
	public BigDecimal getR71_1y_t_equalto_1point5y() {
		return r71_1y_t_equalto_1point5y;
	}
	public void setR71_1y_t_equalto_1point5y(BigDecimal r71_1y_t_equalto_1point5y) {
		this.r71_1y_t_equalto_1point5y = r71_1y_t_equalto_1point5y;
	}
	public BigDecimal getR71_1point5y_t_equalto_2y() {
		return r71_1point5y_t_equalto_2y;
	}
	public void setR71_1point5y_t_equalto_2y(BigDecimal r71_1point5y_t_equalto_2y) {
		this.r71_1point5y_t_equalto_2y = r71_1point5y_t_equalto_2y;
	}
	public BigDecimal getR71_2y_t_equalto_3y() {
		return r71_2y_t_equalto_3y;
	}
	public void setR71_2y_t_equalto_3y(BigDecimal r71_2y_t_equalto_3y) {
		this.r71_2y_t_equalto_3y = r71_2y_t_equalto_3y;
	}
	public BigDecimal getR71_3y_t_equalto_4y() {
		return r71_3y_t_equalto_4y;
	}
	public void setR71_3y_t_equalto_4y(BigDecimal r71_3y_t_equalto_4y) {
		this.r71_3y_t_equalto_4y = r71_3y_t_equalto_4y;
	}
	public BigDecimal getR71_4y_lt_t_ltequalto_5y() {
		return r71_4y_lt_t_ltequalto_5y;
	}
	public void setR71_4y_lt_t_ltequalto_5y(BigDecimal r71_4y_lt_t_ltequalto_5y) {
		this.r71_4y_lt_t_ltequalto_5y = r71_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR71_5y_lt_t_ltequalto_6y() {
		return r71_5y_lt_t_ltequalto_6y;
	}
	public void setR71_5y_lt_t_ltequalto_6y(BigDecimal r71_5y_lt_t_ltequalto_6y) {
		this.r71_5y_lt_t_ltequalto_6y = r71_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR71_6y_lt_t_ltequalto_7y() {
		return r71_6y_lt_t_ltequalto_7y;
	}
	public void setR71_6y_lt_t_ltequalto_7y(BigDecimal r71_6y_lt_t_ltequalto_7y) {
		this.r71_6y_lt_t_ltequalto_7y = r71_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR71_7y_lt_t_ltequalto_8y() {
		return r71_7y_lt_t_ltequalto_8y;
	}
	public void setR71_7y_lt_t_ltequalto_8y(BigDecimal r71_7y_lt_t_ltequalto_8y) {
		this.r71_7y_lt_t_ltequalto_8y = r71_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR71_8y_lt_t_ltequalto_9y() {
		return r71_8y_lt_t_ltequalto_9y;
	}
	public void setR71_8y_lt_t_ltequalto_9y(BigDecimal r71_8y_lt_t_ltequalto_9y) {
		this.r71_8y_lt_t_ltequalto_9y = r71_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR71_9y_lt_t_ltequalto_10y() {
		return r71_9y_lt_t_ltequalto_10y;
	}
	public void setR71_9y_lt_t_ltequalto_10y(BigDecimal r71_9y_lt_t_ltequalto_10y) {
		this.r71_9y_lt_t_ltequalto_10y = r71_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR71_10y_lt_t_ltequalto_15y() {
		return r71_10y_lt_t_ltequalto_15y;
	}
	public void setR71_10y_lt_t_ltequalto_15y(BigDecimal r71_10y_lt_t_ltequalto_15y) {
		this.r71_10y_lt_t_ltequalto_15y = r71_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR71_15y_lt_t_ltequalto_20y() {
		return r71_15y_lt_t_ltequalto_20y;
	}
	public void setR71_15y_lt_t_ltequalto_20y(BigDecimal r71_15y_lt_t_ltequalto_20y) {
		this.r71_15y_lt_t_ltequalto_20y = r71_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR71_tl_20y() {
		return r71_tl_20y;
	}
	public void setR71_tl_20y(BigDecimal r71_tl_20y) {
		this.r71_tl_20y = r71_tl_20y;
	}
	public BigDecimal getR71_nonsensitive() {
		return r71_nonsensitive;
	}
	public void setR71_nonsensitive(BigDecimal r71_nonsensitive) {
		this.r71_nonsensitive = r71_nonsensitive;
	}
	public BigDecimal getR71_total_rsl() {
		return r71_total_rsl;
	}
	public void setR71_total_rsl(BigDecimal r71_total_rsl) {
		this.r71_total_rsl = r71_total_rsl;
	}
	public BigDecimal getR71_total() {
		return r71_total;
	}
	public void setR71_total(BigDecimal r71_total) {
		this.r71_total = r71_total;
	}
	public String getR72_product() {
		return r72_product;
	}
	public void setR72_product(String r72_product) {
		this.r72_product = r72_product;
	}
	public BigDecimal getR72_tequalon() {
		return r72_tequalon;
	}
	public void setR72_tequalon(BigDecimal r72_tequalon) {
		this.r72_tequalon = r72_tequalon;
	}
	public BigDecimal getR72_on_t_equalto_1m() {
		return r72_on_t_equalto_1m;
	}
	public void setR72_on_t_equalto_1m(BigDecimal r72_on_t_equalto_1m) {
		this.r72_on_t_equalto_1m = r72_on_t_equalto_1m;
	}
	public BigDecimal getR72_1m_t_equalto_3m() {
		return r72_1m_t_equalto_3m;
	}
	public void setR72_1m_t_equalto_3m(BigDecimal r72_1m_t_equalto_3m) {
		this.r72_1m_t_equalto_3m = r72_1m_t_equalto_3m;
	}
	public BigDecimal getR72_3m_t_equalto_6m() {
		return r72_3m_t_equalto_6m;
	}
	public void setR72_3m_t_equalto_6m(BigDecimal r72_3m_t_equalto_6m) {
		this.r72_3m_t_equalto_6m = r72_3m_t_equalto_6m;
	}
	public BigDecimal getR72_6m_t_equalto_9m() {
		return r72_6m_t_equalto_9m;
	}
	public void setR72_6m_t_equalto_9m(BigDecimal r72_6m_t_equalto_9m) {
		this.r72_6m_t_equalto_9m = r72_6m_t_equalto_9m;
	}
	public BigDecimal getR72_9m_t_equalto_1y() {
		return r72_9m_t_equalto_1y;
	}
	public void setR72_9m_t_equalto_1y(BigDecimal r72_9m_t_equalto_1y) {
		this.r72_9m_t_equalto_1y = r72_9m_t_equalto_1y;
	}
	public BigDecimal getR72_1y_t_equalto_1point5y() {
		return r72_1y_t_equalto_1point5y;
	}
	public void setR72_1y_t_equalto_1point5y(BigDecimal r72_1y_t_equalto_1point5y) {
		this.r72_1y_t_equalto_1point5y = r72_1y_t_equalto_1point5y;
	}
	public BigDecimal getR72_1point5y_t_equalto_2y() {
		return r72_1point5y_t_equalto_2y;
	}
	public void setR72_1point5y_t_equalto_2y(BigDecimal r72_1point5y_t_equalto_2y) {
		this.r72_1point5y_t_equalto_2y = r72_1point5y_t_equalto_2y;
	}
	public BigDecimal getR72_2y_t_equalto_3y() {
		return r72_2y_t_equalto_3y;
	}
	public void setR72_2y_t_equalto_3y(BigDecimal r72_2y_t_equalto_3y) {
		this.r72_2y_t_equalto_3y = r72_2y_t_equalto_3y;
	}
	public BigDecimal getR72_3y_t_equalto_4y() {
		return r72_3y_t_equalto_4y;
	}
	public void setR72_3y_t_equalto_4y(BigDecimal r72_3y_t_equalto_4y) {
		this.r72_3y_t_equalto_4y = r72_3y_t_equalto_4y;
	}
	public BigDecimal getR72_4y_lt_t_ltequalto_5y() {
		return r72_4y_lt_t_ltequalto_5y;
	}
	public void setR72_4y_lt_t_ltequalto_5y(BigDecimal r72_4y_lt_t_ltequalto_5y) {
		this.r72_4y_lt_t_ltequalto_5y = r72_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR72_5y_lt_t_ltequalto_6y() {
		return r72_5y_lt_t_ltequalto_6y;
	}
	public void setR72_5y_lt_t_ltequalto_6y(BigDecimal r72_5y_lt_t_ltequalto_6y) {
		this.r72_5y_lt_t_ltequalto_6y = r72_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR72_6y_lt_t_ltequalto_7y() {
		return r72_6y_lt_t_ltequalto_7y;
	}
	public void setR72_6y_lt_t_ltequalto_7y(BigDecimal r72_6y_lt_t_ltequalto_7y) {
		this.r72_6y_lt_t_ltequalto_7y = r72_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR72_7y_lt_t_ltequalto_8y() {
		return r72_7y_lt_t_ltequalto_8y;
	}
	public void setR72_7y_lt_t_ltequalto_8y(BigDecimal r72_7y_lt_t_ltequalto_8y) {
		this.r72_7y_lt_t_ltequalto_8y = r72_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR72_8y_lt_t_ltequalto_9y() {
		return r72_8y_lt_t_ltequalto_9y;
	}
	public void setR72_8y_lt_t_ltequalto_9y(BigDecimal r72_8y_lt_t_ltequalto_9y) {
		this.r72_8y_lt_t_ltequalto_9y = r72_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR72_9y_lt_t_ltequalto_10y() {
		return r72_9y_lt_t_ltequalto_10y;
	}
	public void setR72_9y_lt_t_ltequalto_10y(BigDecimal r72_9y_lt_t_ltequalto_10y) {
		this.r72_9y_lt_t_ltequalto_10y = r72_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR72_10y_lt_t_ltequalto_15y() {
		return r72_10y_lt_t_ltequalto_15y;
	}
	public void setR72_10y_lt_t_ltequalto_15y(BigDecimal r72_10y_lt_t_ltequalto_15y) {
		this.r72_10y_lt_t_ltequalto_15y = r72_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR72_15y_lt_t_ltequalto_20y() {
		return r72_15y_lt_t_ltequalto_20y;
	}
	public void setR72_15y_lt_t_ltequalto_20y(BigDecimal r72_15y_lt_t_ltequalto_20y) {
		this.r72_15y_lt_t_ltequalto_20y = r72_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR72_tl_20y() {
		return r72_tl_20y;
	}
	public void setR72_tl_20y(BigDecimal r72_tl_20y) {
		this.r72_tl_20y = r72_tl_20y;
	}
	public BigDecimal getR72_nonsensitive() {
		return r72_nonsensitive;
	}
	public void setR72_nonsensitive(BigDecimal r72_nonsensitive) {
		this.r72_nonsensitive = r72_nonsensitive;
	}
	public BigDecimal getR72_total_rsl() {
		return r72_total_rsl;
	}
	public void setR72_total_rsl(BigDecimal r72_total_rsl) {
		this.r72_total_rsl = r72_total_rsl;
	}
	public BigDecimal getR72_total() {
		return r72_total;
	}
	public void setR72_total(BigDecimal r72_total) {
		this.r72_total = r72_total;
	}
	public String getR73_product() {
		return r73_product;
	}
	public void setR73_product(String r73_product) {
		this.r73_product = r73_product;
	}
	public BigDecimal getR73_tequalon() {
		return r73_tequalon;
	}
	public void setR73_tequalon(BigDecimal r73_tequalon) {
		this.r73_tequalon = r73_tequalon;
	}
	public BigDecimal getR73_on_t_equalto_1m() {
		return r73_on_t_equalto_1m;
	}
	public void setR73_on_t_equalto_1m(BigDecimal r73_on_t_equalto_1m) {
		this.r73_on_t_equalto_1m = r73_on_t_equalto_1m;
	}
	public BigDecimal getR73_1m_t_equalto_3m() {
		return r73_1m_t_equalto_3m;
	}
	public void setR73_1m_t_equalto_3m(BigDecimal r73_1m_t_equalto_3m) {
		this.r73_1m_t_equalto_3m = r73_1m_t_equalto_3m;
	}
	public BigDecimal getR73_3m_t_equalto_6m() {
		return r73_3m_t_equalto_6m;
	}
	public void setR73_3m_t_equalto_6m(BigDecimal r73_3m_t_equalto_6m) {
		this.r73_3m_t_equalto_6m = r73_3m_t_equalto_6m;
	}
	public BigDecimal getR73_6m_t_equalto_9m() {
		return r73_6m_t_equalto_9m;
	}
	public void setR73_6m_t_equalto_9m(BigDecimal r73_6m_t_equalto_9m) {
		this.r73_6m_t_equalto_9m = r73_6m_t_equalto_9m;
	}
	public BigDecimal getR73_9m_t_equalto_1y() {
		return r73_9m_t_equalto_1y;
	}
	public void setR73_9m_t_equalto_1y(BigDecimal r73_9m_t_equalto_1y) {
		this.r73_9m_t_equalto_1y = r73_9m_t_equalto_1y;
	}
	public BigDecimal getR73_1y_t_equalto_1point5y() {
		return r73_1y_t_equalto_1point5y;
	}
	public void setR73_1y_t_equalto_1point5y(BigDecimal r73_1y_t_equalto_1point5y) {
		this.r73_1y_t_equalto_1point5y = r73_1y_t_equalto_1point5y;
	}
	public BigDecimal getR73_1point5y_t_equalto_2y() {
		return r73_1point5y_t_equalto_2y;
	}
	public void setR73_1point5y_t_equalto_2y(BigDecimal r73_1point5y_t_equalto_2y) {
		this.r73_1point5y_t_equalto_2y = r73_1point5y_t_equalto_2y;
	}
	public BigDecimal getR73_2y_t_equalto_3y() {
		return r73_2y_t_equalto_3y;
	}
	public void setR73_2y_t_equalto_3y(BigDecimal r73_2y_t_equalto_3y) {
		this.r73_2y_t_equalto_3y = r73_2y_t_equalto_3y;
	}
	public BigDecimal getR73_3y_t_equalto_4y() {
		return r73_3y_t_equalto_4y;
	}
	public void setR73_3y_t_equalto_4y(BigDecimal r73_3y_t_equalto_4y) {
		this.r73_3y_t_equalto_4y = r73_3y_t_equalto_4y;
	}
	public BigDecimal getR73_4y_lt_t_ltequalto_5y() {
		return r73_4y_lt_t_ltequalto_5y;
	}
	public void setR73_4y_lt_t_ltequalto_5y(BigDecimal r73_4y_lt_t_ltequalto_5y) {
		this.r73_4y_lt_t_ltequalto_5y = r73_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR73_5y_lt_t_ltequalto_6y() {
		return r73_5y_lt_t_ltequalto_6y;
	}
	public void setR73_5y_lt_t_ltequalto_6y(BigDecimal r73_5y_lt_t_ltequalto_6y) {
		this.r73_5y_lt_t_ltequalto_6y = r73_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR73_6y_lt_t_ltequalto_7y() {
		return r73_6y_lt_t_ltequalto_7y;
	}
	public void setR73_6y_lt_t_ltequalto_7y(BigDecimal r73_6y_lt_t_ltequalto_7y) {
		this.r73_6y_lt_t_ltequalto_7y = r73_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR73_7y_lt_t_ltequalto_8y() {
		return r73_7y_lt_t_ltequalto_8y;
	}
	public void setR73_7y_lt_t_ltequalto_8y(BigDecimal r73_7y_lt_t_ltequalto_8y) {
		this.r73_7y_lt_t_ltequalto_8y = r73_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR73_8y_lt_t_ltequalto_9y() {
		return r73_8y_lt_t_ltequalto_9y;
	}
	public void setR73_8y_lt_t_ltequalto_9y(BigDecimal r73_8y_lt_t_ltequalto_9y) {
		this.r73_8y_lt_t_ltequalto_9y = r73_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR73_9y_lt_t_ltequalto_10y() {
		return r73_9y_lt_t_ltequalto_10y;
	}
	public void setR73_9y_lt_t_ltequalto_10y(BigDecimal r73_9y_lt_t_ltequalto_10y) {
		this.r73_9y_lt_t_ltequalto_10y = r73_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR73_10y_lt_t_ltequalto_15y() {
		return r73_10y_lt_t_ltequalto_15y;
	}
	public void setR73_10y_lt_t_ltequalto_15y(BigDecimal r73_10y_lt_t_ltequalto_15y) {
		this.r73_10y_lt_t_ltequalto_15y = r73_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR73_15y_lt_t_ltequalto_20y() {
		return r73_15y_lt_t_ltequalto_20y;
	}
	public void setR73_15y_lt_t_ltequalto_20y(BigDecimal r73_15y_lt_t_ltequalto_20y) {
		this.r73_15y_lt_t_ltequalto_20y = r73_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR73_tl_20y() {
		return r73_tl_20y;
	}
	public void setR73_tl_20y(BigDecimal r73_tl_20y) {
		this.r73_tl_20y = r73_tl_20y;
	}
	public BigDecimal getR73_nonsensitive() {
		return r73_nonsensitive;
	}
	public void setR73_nonsensitive(BigDecimal r73_nonsensitive) {
		this.r73_nonsensitive = r73_nonsensitive;
	}
	public BigDecimal getR73_total_rsl() {
		return r73_total_rsl;
	}
	public void setR73_total_rsl(BigDecimal r73_total_rsl) {
		this.r73_total_rsl = r73_total_rsl;
	}
	public BigDecimal getR73_total() {
		return r73_total;
	}
	public void setR73_total(BigDecimal r73_total) {
		this.r73_total = r73_total;
	}
	public String getR74_product() {
		return r74_product;
	}
	public void setR74_product(String r74_product) {
		this.r74_product = r74_product;
	}
	public BigDecimal getR74_tequalon() {
		return r74_tequalon;
	}
	public void setR74_tequalon(BigDecimal r74_tequalon) {
		this.r74_tequalon = r74_tequalon;
	}
	public BigDecimal getR74_on_t_equalto_1m() {
		return r74_on_t_equalto_1m;
	}
	public void setR74_on_t_equalto_1m(BigDecimal r74_on_t_equalto_1m) {
		this.r74_on_t_equalto_1m = r74_on_t_equalto_1m;
	}
	public BigDecimal getR74_1m_t_equalto_3m() {
		return r74_1m_t_equalto_3m;
	}
	public void setR74_1m_t_equalto_3m(BigDecimal r74_1m_t_equalto_3m) {
		this.r74_1m_t_equalto_3m = r74_1m_t_equalto_3m;
	}
	public BigDecimal getR74_3m_t_equalto_6m() {
		return r74_3m_t_equalto_6m;
	}
	public void setR74_3m_t_equalto_6m(BigDecimal r74_3m_t_equalto_6m) {
		this.r74_3m_t_equalto_6m = r74_3m_t_equalto_6m;
	}
	public BigDecimal getR74_6m_t_equalto_9m() {
		return r74_6m_t_equalto_9m;
	}
	public void setR74_6m_t_equalto_9m(BigDecimal r74_6m_t_equalto_9m) {
		this.r74_6m_t_equalto_9m = r74_6m_t_equalto_9m;
	}
	public BigDecimal getR74_9m_t_equalto_1y() {
		return r74_9m_t_equalto_1y;
	}
	public void setR74_9m_t_equalto_1y(BigDecimal r74_9m_t_equalto_1y) {
		this.r74_9m_t_equalto_1y = r74_9m_t_equalto_1y;
	}
	public BigDecimal getR74_1y_t_equalto_1point5y() {
		return r74_1y_t_equalto_1point5y;
	}
	public void setR74_1y_t_equalto_1point5y(BigDecimal r74_1y_t_equalto_1point5y) {
		this.r74_1y_t_equalto_1point5y = r74_1y_t_equalto_1point5y;
	}
	public BigDecimal getR74_1point5y_t_equalto_2y() {
		return r74_1point5y_t_equalto_2y;
	}
	public void setR74_1point5y_t_equalto_2y(BigDecimal r74_1point5y_t_equalto_2y) {
		this.r74_1point5y_t_equalto_2y = r74_1point5y_t_equalto_2y;
	}
	public BigDecimal getR74_2y_t_equalto_3y() {
		return r74_2y_t_equalto_3y;
	}
	public void setR74_2y_t_equalto_3y(BigDecimal r74_2y_t_equalto_3y) {
		this.r74_2y_t_equalto_3y = r74_2y_t_equalto_3y;
	}
	public BigDecimal getR74_3y_t_equalto_4y() {
		return r74_3y_t_equalto_4y;
	}
	public void setR74_3y_t_equalto_4y(BigDecimal r74_3y_t_equalto_4y) {
		this.r74_3y_t_equalto_4y = r74_3y_t_equalto_4y;
	}
	public BigDecimal getR74_4y_lt_t_ltequalto_5y() {
		return r74_4y_lt_t_ltequalto_5y;
	}
	public void setR74_4y_lt_t_ltequalto_5y(BigDecimal r74_4y_lt_t_ltequalto_5y) {
		this.r74_4y_lt_t_ltequalto_5y = r74_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR74_5y_lt_t_ltequalto_6y() {
		return r74_5y_lt_t_ltequalto_6y;
	}
	public void setR74_5y_lt_t_ltequalto_6y(BigDecimal r74_5y_lt_t_ltequalto_6y) {
		this.r74_5y_lt_t_ltequalto_6y = r74_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR74_6y_lt_t_ltequalto_7y() {
		return r74_6y_lt_t_ltequalto_7y;
	}
	public void setR74_6y_lt_t_ltequalto_7y(BigDecimal r74_6y_lt_t_ltequalto_7y) {
		this.r74_6y_lt_t_ltequalto_7y = r74_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR74_7y_lt_t_ltequalto_8y() {
		return r74_7y_lt_t_ltequalto_8y;
	}
	public void setR74_7y_lt_t_ltequalto_8y(BigDecimal r74_7y_lt_t_ltequalto_8y) {
		this.r74_7y_lt_t_ltequalto_8y = r74_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR74_8y_lt_t_ltequalto_9y() {
		return r74_8y_lt_t_ltequalto_9y;
	}
	public void setR74_8y_lt_t_ltequalto_9y(BigDecimal r74_8y_lt_t_ltequalto_9y) {
		this.r74_8y_lt_t_ltequalto_9y = r74_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR74_9y_lt_t_ltequalto_10y() {
		return r74_9y_lt_t_ltequalto_10y;
	}
	public void setR74_9y_lt_t_ltequalto_10y(BigDecimal r74_9y_lt_t_ltequalto_10y) {
		this.r74_9y_lt_t_ltequalto_10y = r74_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR74_10y_lt_t_ltequalto_15y() {
		return r74_10y_lt_t_ltequalto_15y;
	}
	public void setR74_10y_lt_t_ltequalto_15y(BigDecimal r74_10y_lt_t_ltequalto_15y) {
		this.r74_10y_lt_t_ltequalto_15y = r74_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR74_15y_lt_t_ltequalto_20y() {
		return r74_15y_lt_t_ltequalto_20y;
	}
	public void setR74_15y_lt_t_ltequalto_20y(BigDecimal r74_15y_lt_t_ltequalto_20y) {
		this.r74_15y_lt_t_ltequalto_20y = r74_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR74_tl_20y() {
		return r74_tl_20y;
	}
	public void setR74_tl_20y(BigDecimal r74_tl_20y) {
		this.r74_tl_20y = r74_tl_20y;
	}
	public BigDecimal getR74_nonsensitive() {
		return r74_nonsensitive;
	}
	public void setR74_nonsensitive(BigDecimal r74_nonsensitive) {
		this.r74_nonsensitive = r74_nonsensitive;
	}
	public BigDecimal getR74_total_rsl() {
		return r74_total_rsl;
	}
	public void setR74_total_rsl(BigDecimal r74_total_rsl) {
		this.r74_total_rsl = r74_total_rsl;
	}
	public BigDecimal getR74_total() {
		return r74_total;
	}
	public void setR74_total(BigDecimal r74_total) {
		this.r74_total = r74_total;
	}
	public String getR75_product() {
		return r75_product;
	}
	public void setR75_product(String r75_product) {
		this.r75_product = r75_product;
	}
	public BigDecimal getR75_tequalon() {
		return r75_tequalon;
	}
	public void setR75_tequalon(BigDecimal r75_tequalon) {
		this.r75_tequalon = r75_tequalon;
	}
	public BigDecimal getR75_on_t_equalto_1m() {
		return r75_on_t_equalto_1m;
	}
	public void setR75_on_t_equalto_1m(BigDecimal r75_on_t_equalto_1m) {
		this.r75_on_t_equalto_1m = r75_on_t_equalto_1m;
	}
	public BigDecimal getR75_1m_t_equalto_3m() {
		return r75_1m_t_equalto_3m;
	}
	public void setR75_1m_t_equalto_3m(BigDecimal r75_1m_t_equalto_3m) {
		this.r75_1m_t_equalto_3m = r75_1m_t_equalto_3m;
	}
	public BigDecimal getR75_3m_t_equalto_6m() {
		return r75_3m_t_equalto_6m;
	}
	public void setR75_3m_t_equalto_6m(BigDecimal r75_3m_t_equalto_6m) {
		this.r75_3m_t_equalto_6m = r75_3m_t_equalto_6m;
	}
	public BigDecimal getR75_6m_t_equalto_9m() {
		return r75_6m_t_equalto_9m;
	}
	public void setR75_6m_t_equalto_9m(BigDecimal r75_6m_t_equalto_9m) {
		this.r75_6m_t_equalto_9m = r75_6m_t_equalto_9m;
	}
	public BigDecimal getR75_9m_t_equalto_1y() {
		return r75_9m_t_equalto_1y;
	}
	public void setR75_9m_t_equalto_1y(BigDecimal r75_9m_t_equalto_1y) {
		this.r75_9m_t_equalto_1y = r75_9m_t_equalto_1y;
	}
	public BigDecimal getR75_1y_t_equalto_1point5y() {
		return r75_1y_t_equalto_1point5y;
	}
	public void setR75_1y_t_equalto_1point5y(BigDecimal r75_1y_t_equalto_1point5y) {
		this.r75_1y_t_equalto_1point5y = r75_1y_t_equalto_1point5y;
	}
	public BigDecimal getR75_1point5y_t_equalto_2y() {
		return r75_1point5y_t_equalto_2y;
	}
	public void setR75_1point5y_t_equalto_2y(BigDecimal r75_1point5y_t_equalto_2y) {
		this.r75_1point5y_t_equalto_2y = r75_1point5y_t_equalto_2y;
	}
	public BigDecimal getR75_2y_t_equalto_3y() {
		return r75_2y_t_equalto_3y;
	}
	public void setR75_2y_t_equalto_3y(BigDecimal r75_2y_t_equalto_3y) {
		this.r75_2y_t_equalto_3y = r75_2y_t_equalto_3y;
	}
	public BigDecimal getR75_3y_t_equalto_4y() {
		return r75_3y_t_equalto_4y;
	}
	public void setR75_3y_t_equalto_4y(BigDecimal r75_3y_t_equalto_4y) {
		this.r75_3y_t_equalto_4y = r75_3y_t_equalto_4y;
	}
	public BigDecimal getR75_4y_lt_t_ltequalto_5y() {
		return r75_4y_lt_t_ltequalto_5y;
	}
	public void setR75_4y_lt_t_ltequalto_5y(BigDecimal r75_4y_lt_t_ltequalto_5y) {
		this.r75_4y_lt_t_ltequalto_5y = r75_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR75_5y_lt_t_ltequalto_6y() {
		return r75_5y_lt_t_ltequalto_6y;
	}
	public void setR75_5y_lt_t_ltequalto_6y(BigDecimal r75_5y_lt_t_ltequalto_6y) {
		this.r75_5y_lt_t_ltequalto_6y = r75_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR75_6y_lt_t_ltequalto_7y() {
		return r75_6y_lt_t_ltequalto_7y;
	}
	public void setR75_6y_lt_t_ltequalto_7y(BigDecimal r75_6y_lt_t_ltequalto_7y) {
		this.r75_6y_lt_t_ltequalto_7y = r75_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR75_7y_lt_t_ltequalto_8y() {
		return r75_7y_lt_t_ltequalto_8y;
	}
	public void setR75_7y_lt_t_ltequalto_8y(BigDecimal r75_7y_lt_t_ltequalto_8y) {
		this.r75_7y_lt_t_ltequalto_8y = r75_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR75_8y_lt_t_ltequalto_9y() {
		return r75_8y_lt_t_ltequalto_9y;
	}
	public void setR75_8y_lt_t_ltequalto_9y(BigDecimal r75_8y_lt_t_ltequalto_9y) {
		this.r75_8y_lt_t_ltequalto_9y = r75_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR75_9y_lt_t_ltequalto_10y() {
		return r75_9y_lt_t_ltequalto_10y;
	}
	public void setR75_9y_lt_t_ltequalto_10y(BigDecimal r75_9y_lt_t_ltequalto_10y) {
		this.r75_9y_lt_t_ltequalto_10y = r75_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR75_10y_lt_t_ltequalto_15y() {
		return r75_10y_lt_t_ltequalto_15y;
	}
	public void setR75_10y_lt_t_ltequalto_15y(BigDecimal r75_10y_lt_t_ltequalto_15y) {
		this.r75_10y_lt_t_ltequalto_15y = r75_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR75_15y_lt_t_ltequalto_20y() {
		return r75_15y_lt_t_ltequalto_20y;
	}
	public void setR75_15y_lt_t_ltequalto_20y(BigDecimal r75_15y_lt_t_ltequalto_20y) {
		this.r75_15y_lt_t_ltequalto_20y = r75_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR75_tl_20y() {
		return r75_tl_20y;
	}
	public void setR75_tl_20y(BigDecimal r75_tl_20y) {
		this.r75_tl_20y = r75_tl_20y;
	}
	public BigDecimal getR75_nonsensitive() {
		return r75_nonsensitive;
	}
	public void setR75_nonsensitive(BigDecimal r75_nonsensitive) {
		this.r75_nonsensitive = r75_nonsensitive;
	}
	public BigDecimal getR75_total_rsl() {
		return r75_total_rsl;
	}
	public void setR75_total_rsl(BigDecimal r75_total_rsl) {
		this.r75_total_rsl = r75_total_rsl;
	}
	public BigDecimal getR75_total() {
		return r75_total;
	}
	public void setR75_total(BigDecimal r75_total) {
		this.r75_total = r75_total;
	}
	public String getR76_product() {
		return r76_product;
	}
	public void setR76_product(String r76_product) {
		this.r76_product = r76_product;
	}
	public BigDecimal getR76_tequalon() {
		return r76_tequalon;
	}
	public void setR76_tequalon(BigDecimal r76_tequalon) {
		this.r76_tequalon = r76_tequalon;
	}
	public BigDecimal getR76_on_t_equalto_1m() {
		return r76_on_t_equalto_1m;
	}
	public void setR76_on_t_equalto_1m(BigDecimal r76_on_t_equalto_1m) {
		this.r76_on_t_equalto_1m = r76_on_t_equalto_1m;
	}
	public BigDecimal getR76_1m_t_equalto_3m() {
		return r76_1m_t_equalto_3m;
	}
	public void setR76_1m_t_equalto_3m(BigDecimal r76_1m_t_equalto_3m) {
		this.r76_1m_t_equalto_3m = r76_1m_t_equalto_3m;
	}
	public BigDecimal getR76_3m_t_equalto_6m() {
		return r76_3m_t_equalto_6m;
	}
	public void setR76_3m_t_equalto_6m(BigDecimal r76_3m_t_equalto_6m) {
		this.r76_3m_t_equalto_6m = r76_3m_t_equalto_6m;
	}
	public BigDecimal getR76_6m_t_equalto_9m() {
		return r76_6m_t_equalto_9m;
	}
	public void setR76_6m_t_equalto_9m(BigDecimal r76_6m_t_equalto_9m) {
		this.r76_6m_t_equalto_9m = r76_6m_t_equalto_9m;
	}
	public BigDecimal getR76_9m_t_equalto_1y() {
		return r76_9m_t_equalto_1y;
	}
	public void setR76_9m_t_equalto_1y(BigDecimal r76_9m_t_equalto_1y) {
		this.r76_9m_t_equalto_1y = r76_9m_t_equalto_1y;
	}
	public BigDecimal getR76_1y_t_equalto_1point5y() {
		return r76_1y_t_equalto_1point5y;
	}
	public void setR76_1y_t_equalto_1point5y(BigDecimal r76_1y_t_equalto_1point5y) {
		this.r76_1y_t_equalto_1point5y = r76_1y_t_equalto_1point5y;
	}
	public BigDecimal getR76_1point5y_t_equalto_2y() {
		return r76_1point5y_t_equalto_2y;
	}
	public void setR76_1point5y_t_equalto_2y(BigDecimal r76_1point5y_t_equalto_2y) {
		this.r76_1point5y_t_equalto_2y = r76_1point5y_t_equalto_2y;
	}
	public BigDecimal getR76_2y_t_equalto_3y() {
		return r76_2y_t_equalto_3y;
	}
	public void setR76_2y_t_equalto_3y(BigDecimal r76_2y_t_equalto_3y) {
		this.r76_2y_t_equalto_3y = r76_2y_t_equalto_3y;
	}
	public BigDecimal getR76_3y_t_equalto_4y() {
		return r76_3y_t_equalto_4y;
	}
	public void setR76_3y_t_equalto_4y(BigDecimal r76_3y_t_equalto_4y) {
		this.r76_3y_t_equalto_4y = r76_3y_t_equalto_4y;
	}
	public BigDecimal getR76_4y_lt_t_ltequalto_5y() {
		return r76_4y_lt_t_ltequalto_5y;
	}
	public void setR76_4y_lt_t_ltequalto_5y(BigDecimal r76_4y_lt_t_ltequalto_5y) {
		this.r76_4y_lt_t_ltequalto_5y = r76_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR76_5y_lt_t_ltequalto_6y() {
		return r76_5y_lt_t_ltequalto_6y;
	}
	public void setR76_5y_lt_t_ltequalto_6y(BigDecimal r76_5y_lt_t_ltequalto_6y) {
		this.r76_5y_lt_t_ltequalto_6y = r76_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR76_6y_lt_t_ltequalto_7y() {
		return r76_6y_lt_t_ltequalto_7y;
	}
	public void setR76_6y_lt_t_ltequalto_7y(BigDecimal r76_6y_lt_t_ltequalto_7y) {
		this.r76_6y_lt_t_ltequalto_7y = r76_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR76_7y_lt_t_ltequalto_8y() {
		return r76_7y_lt_t_ltequalto_8y;
	}
	public void setR76_7y_lt_t_ltequalto_8y(BigDecimal r76_7y_lt_t_ltequalto_8y) {
		this.r76_7y_lt_t_ltequalto_8y = r76_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR76_8y_lt_t_ltequalto_9y() {
		return r76_8y_lt_t_ltequalto_9y;
	}
	public void setR76_8y_lt_t_ltequalto_9y(BigDecimal r76_8y_lt_t_ltequalto_9y) {
		this.r76_8y_lt_t_ltequalto_9y = r76_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR76_9y_lt_t_ltequalto_10y() {
		return r76_9y_lt_t_ltequalto_10y;
	}
	public void setR76_9y_lt_t_ltequalto_10y(BigDecimal r76_9y_lt_t_ltequalto_10y) {
		this.r76_9y_lt_t_ltequalto_10y = r76_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR76_10y_lt_t_ltequalto_15y() {
		return r76_10y_lt_t_ltequalto_15y;
	}
	public void setR76_10y_lt_t_ltequalto_15y(BigDecimal r76_10y_lt_t_ltequalto_15y) {
		this.r76_10y_lt_t_ltequalto_15y = r76_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR76_15y_lt_t_ltequalto_20y() {
		return r76_15y_lt_t_ltequalto_20y;
	}
	public void setR76_15y_lt_t_ltequalto_20y(BigDecimal r76_15y_lt_t_ltequalto_20y) {
		this.r76_15y_lt_t_ltequalto_20y = r76_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR76_tl_20y() {
		return r76_tl_20y;
	}
	public void setR76_tl_20y(BigDecimal r76_tl_20y) {
		this.r76_tl_20y = r76_tl_20y;
	}
	public BigDecimal getR76_nonsensitive() {
		return r76_nonsensitive;
	}
	public void setR76_nonsensitive(BigDecimal r76_nonsensitive) {
		this.r76_nonsensitive = r76_nonsensitive;
	}
	public BigDecimal getR76_total_rsl() {
		return r76_total_rsl;
	}
	public void setR76_total_rsl(BigDecimal r76_total_rsl) {
		this.r76_total_rsl = r76_total_rsl;
	}
	public BigDecimal getR76_total() {
		return r76_total;
	}
	public void setR76_total(BigDecimal r76_total) {
		this.r76_total = r76_total;
	}
	public String getR77_product() {
		return r77_product;
	}
	public void setR77_product(String r77_product) {
		this.r77_product = r77_product;
	}
	public BigDecimal getR77_tequalon() {
		return r77_tequalon;
	}
	public void setR77_tequalon(BigDecimal r77_tequalon) {
		this.r77_tequalon = r77_tequalon;
	}
	public BigDecimal getR77_on_t_equalto_1m() {
		return r77_on_t_equalto_1m;
	}
	public void setR77_on_t_equalto_1m(BigDecimal r77_on_t_equalto_1m) {
		this.r77_on_t_equalto_1m = r77_on_t_equalto_1m;
	}
	public BigDecimal getR77_1m_t_equalto_3m() {
		return r77_1m_t_equalto_3m;
	}
	public void setR77_1m_t_equalto_3m(BigDecimal r77_1m_t_equalto_3m) {
		this.r77_1m_t_equalto_3m = r77_1m_t_equalto_3m;
	}
	public BigDecimal getR77_3m_t_equalto_6m() {
		return r77_3m_t_equalto_6m;
	}
	public void setR77_3m_t_equalto_6m(BigDecimal r77_3m_t_equalto_6m) {
		this.r77_3m_t_equalto_6m = r77_3m_t_equalto_6m;
	}
	public BigDecimal getR77_6m_t_equalto_9m() {
		return r77_6m_t_equalto_9m;
	}
	public void setR77_6m_t_equalto_9m(BigDecimal r77_6m_t_equalto_9m) {
		this.r77_6m_t_equalto_9m = r77_6m_t_equalto_9m;
	}
	public BigDecimal getR77_9m_t_equalto_1y() {
		return r77_9m_t_equalto_1y;
	}
	public void setR77_9m_t_equalto_1y(BigDecimal r77_9m_t_equalto_1y) {
		this.r77_9m_t_equalto_1y = r77_9m_t_equalto_1y;
	}
	public BigDecimal getR77_1y_t_equalto_1point5y() {
		return r77_1y_t_equalto_1point5y;
	}
	public void setR77_1y_t_equalto_1point5y(BigDecimal r77_1y_t_equalto_1point5y) {
		this.r77_1y_t_equalto_1point5y = r77_1y_t_equalto_1point5y;
	}
	public BigDecimal getR77_1point5y_t_equalto_2y() {
		return r77_1point5y_t_equalto_2y;
	}
	public void setR77_1point5y_t_equalto_2y(BigDecimal r77_1point5y_t_equalto_2y) {
		this.r77_1point5y_t_equalto_2y = r77_1point5y_t_equalto_2y;
	}
	public BigDecimal getR77_2y_t_equalto_3y() {
		return r77_2y_t_equalto_3y;
	}
	public void setR77_2y_t_equalto_3y(BigDecimal r77_2y_t_equalto_3y) {
		this.r77_2y_t_equalto_3y = r77_2y_t_equalto_3y;
	}
	public BigDecimal getR77_3y_t_equalto_4y() {
		return r77_3y_t_equalto_4y;
	}
	public void setR77_3y_t_equalto_4y(BigDecimal r77_3y_t_equalto_4y) {
		this.r77_3y_t_equalto_4y = r77_3y_t_equalto_4y;
	}
	public BigDecimal getR77_4y_lt_t_ltequalto_5y() {
		return r77_4y_lt_t_ltequalto_5y;
	}
	public void setR77_4y_lt_t_ltequalto_5y(BigDecimal r77_4y_lt_t_ltequalto_5y) {
		this.r77_4y_lt_t_ltequalto_5y = r77_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR77_5y_lt_t_ltequalto_6y() {
		return r77_5y_lt_t_ltequalto_6y;
	}
	public void setR77_5y_lt_t_ltequalto_6y(BigDecimal r77_5y_lt_t_ltequalto_6y) {
		this.r77_5y_lt_t_ltequalto_6y = r77_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR77_6y_lt_t_ltequalto_7y() {
		return r77_6y_lt_t_ltequalto_7y;
	}
	public void setR77_6y_lt_t_ltequalto_7y(BigDecimal r77_6y_lt_t_ltequalto_7y) {
		this.r77_6y_lt_t_ltequalto_7y = r77_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR77_7y_lt_t_ltequalto_8y() {
		return r77_7y_lt_t_ltequalto_8y;
	}
	public void setR77_7y_lt_t_ltequalto_8y(BigDecimal r77_7y_lt_t_ltequalto_8y) {
		this.r77_7y_lt_t_ltequalto_8y = r77_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR77_8y_lt_t_ltequalto_9y() {
		return r77_8y_lt_t_ltequalto_9y;
	}
	public void setR77_8y_lt_t_ltequalto_9y(BigDecimal r77_8y_lt_t_ltequalto_9y) {
		this.r77_8y_lt_t_ltequalto_9y = r77_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR77_9y_lt_t_ltequalto_10y() {
		return r77_9y_lt_t_ltequalto_10y;
	}
	public void setR77_9y_lt_t_ltequalto_10y(BigDecimal r77_9y_lt_t_ltequalto_10y) {
		this.r77_9y_lt_t_ltequalto_10y = r77_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR77_10y_lt_t_ltequalto_15y() {
		return r77_10y_lt_t_ltequalto_15y;
	}
	public void setR77_10y_lt_t_ltequalto_15y(BigDecimal r77_10y_lt_t_ltequalto_15y) {
		this.r77_10y_lt_t_ltequalto_15y = r77_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR77_15y_lt_t_ltequalto_20y() {
		return r77_15y_lt_t_ltequalto_20y;
	}
	public void setR77_15y_lt_t_ltequalto_20y(BigDecimal r77_15y_lt_t_ltequalto_20y) {
		this.r77_15y_lt_t_ltequalto_20y = r77_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR77_tl_20y() {
		return r77_tl_20y;
	}
	public void setR77_tl_20y(BigDecimal r77_tl_20y) {
		this.r77_tl_20y = r77_tl_20y;
	}
	public BigDecimal getR77_nonsensitive() {
		return r77_nonsensitive;
	}
	public void setR77_nonsensitive(BigDecimal r77_nonsensitive) {
		this.r77_nonsensitive = r77_nonsensitive;
	}
	public BigDecimal getR77_total_rsl() {
		return r77_total_rsl;
	}
	public void setR77_total_rsl(BigDecimal r77_total_rsl) {
		this.r77_total_rsl = r77_total_rsl;
	}
	public BigDecimal getR77_total() {
		return r77_total;
	}
	public void setR77_total(BigDecimal r77_total) {
		this.r77_total = r77_total;
	}
	public String getR78_product() {
		return r78_product;
	}
	public void setR78_product(String r78_product) {
		this.r78_product = r78_product;
	}
	public BigDecimal getR78_tequalon() {
		return r78_tequalon;
	}
	public void setR78_tequalon(BigDecimal r78_tequalon) {
		this.r78_tequalon = r78_tequalon;
	}
	public BigDecimal getR78_on_t_equalto_1m() {
		return r78_on_t_equalto_1m;
	}
	public void setR78_on_t_equalto_1m(BigDecimal r78_on_t_equalto_1m) {
		this.r78_on_t_equalto_1m = r78_on_t_equalto_1m;
	}
	public BigDecimal getR78_1m_t_equalto_3m() {
		return r78_1m_t_equalto_3m;
	}
	public void setR78_1m_t_equalto_3m(BigDecimal r78_1m_t_equalto_3m) {
		this.r78_1m_t_equalto_3m = r78_1m_t_equalto_3m;
	}
	public BigDecimal getR78_3m_t_equalto_6m() {
		return r78_3m_t_equalto_6m;
	}
	public void setR78_3m_t_equalto_6m(BigDecimal r78_3m_t_equalto_6m) {
		this.r78_3m_t_equalto_6m = r78_3m_t_equalto_6m;
	}
	public BigDecimal getR78_6m_t_equalto_9m() {
		return r78_6m_t_equalto_9m;
	}
	public void setR78_6m_t_equalto_9m(BigDecimal r78_6m_t_equalto_9m) {
		this.r78_6m_t_equalto_9m = r78_6m_t_equalto_9m;
	}
	public BigDecimal getR78_9m_t_equalto_1y() {
		return r78_9m_t_equalto_1y;
	}
	public void setR78_9m_t_equalto_1y(BigDecimal r78_9m_t_equalto_1y) {
		this.r78_9m_t_equalto_1y = r78_9m_t_equalto_1y;
	}
	public BigDecimal getR78_1y_t_equalto_1point5y() {
		return r78_1y_t_equalto_1point5y;
	}
	public void setR78_1y_t_equalto_1point5y(BigDecimal r78_1y_t_equalto_1point5y) {
		this.r78_1y_t_equalto_1point5y = r78_1y_t_equalto_1point5y;
	}
	public BigDecimal getR78_1point5y_t_equalto_2y() {
		return r78_1point5y_t_equalto_2y;
	}
	public void setR78_1point5y_t_equalto_2y(BigDecimal r78_1point5y_t_equalto_2y) {
		this.r78_1point5y_t_equalto_2y = r78_1point5y_t_equalto_2y;
	}
	public BigDecimal getR78_2y_t_equalto_3y() {
		return r78_2y_t_equalto_3y;
	}
	public void setR78_2y_t_equalto_3y(BigDecimal r78_2y_t_equalto_3y) {
		this.r78_2y_t_equalto_3y = r78_2y_t_equalto_3y;
	}
	public BigDecimal getR78_3y_t_equalto_4y() {
		return r78_3y_t_equalto_4y;
	}
	public void setR78_3y_t_equalto_4y(BigDecimal r78_3y_t_equalto_4y) {
		this.r78_3y_t_equalto_4y = r78_3y_t_equalto_4y;
	}
	public BigDecimal getR78_4y_lt_t_ltequalto_5y() {
		return r78_4y_lt_t_ltequalto_5y;
	}
	public void setR78_4y_lt_t_ltequalto_5y(BigDecimal r78_4y_lt_t_ltequalto_5y) {
		this.r78_4y_lt_t_ltequalto_5y = r78_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR78_5y_lt_t_ltequalto_6y() {
		return r78_5y_lt_t_ltequalto_6y;
	}
	public void setR78_5y_lt_t_ltequalto_6y(BigDecimal r78_5y_lt_t_ltequalto_6y) {
		this.r78_5y_lt_t_ltequalto_6y = r78_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR78_6y_lt_t_ltequalto_7y() {
		return r78_6y_lt_t_ltequalto_7y;
	}
	public void setR78_6y_lt_t_ltequalto_7y(BigDecimal r78_6y_lt_t_ltequalto_7y) {
		this.r78_6y_lt_t_ltequalto_7y = r78_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR78_7y_lt_t_ltequalto_8y() {
		return r78_7y_lt_t_ltequalto_8y;
	}
	public void setR78_7y_lt_t_ltequalto_8y(BigDecimal r78_7y_lt_t_ltequalto_8y) {
		this.r78_7y_lt_t_ltequalto_8y = r78_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR78_8y_lt_t_ltequalto_9y() {
		return r78_8y_lt_t_ltequalto_9y;
	}
	public void setR78_8y_lt_t_ltequalto_9y(BigDecimal r78_8y_lt_t_ltequalto_9y) {
		this.r78_8y_lt_t_ltequalto_9y = r78_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR78_9y_lt_t_ltequalto_10y() {
		return r78_9y_lt_t_ltequalto_10y;
	}
	public void setR78_9y_lt_t_ltequalto_10y(BigDecimal r78_9y_lt_t_ltequalto_10y) {
		this.r78_9y_lt_t_ltequalto_10y = r78_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR78_10y_lt_t_ltequalto_15y() {
		return r78_10y_lt_t_ltequalto_15y;
	}
	public void setR78_10y_lt_t_ltequalto_15y(BigDecimal r78_10y_lt_t_ltequalto_15y) {
		this.r78_10y_lt_t_ltequalto_15y = r78_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR78_15y_lt_t_ltequalto_20y() {
		return r78_15y_lt_t_ltequalto_20y;
	}
	public void setR78_15y_lt_t_ltequalto_20y(BigDecimal r78_15y_lt_t_ltequalto_20y) {
		this.r78_15y_lt_t_ltequalto_20y = r78_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR78_tl_20y() {
		return r78_tl_20y;
	}
	public void setR78_tl_20y(BigDecimal r78_tl_20y) {
		this.r78_tl_20y = r78_tl_20y;
	}
	public BigDecimal getR78_nonsensitive() {
		return r78_nonsensitive;
	}
	public void setR78_nonsensitive(BigDecimal r78_nonsensitive) {
		this.r78_nonsensitive = r78_nonsensitive;
	}
	public BigDecimal getR78_total_rsl() {
		return r78_total_rsl;
	}
	public void setR78_total_rsl(BigDecimal r78_total_rsl) {
		this.r78_total_rsl = r78_total_rsl;
	}
	public BigDecimal getR78_total() {
		return r78_total;
	}
	public void setR78_total(BigDecimal r78_total) {
		this.r78_total = r78_total;
	}
	public String getR79_product() {
		return r79_product;
	}
	public void setR79_product(String r79_product) {
		this.r79_product = r79_product;
	}
	public BigDecimal getR79_tequalon() {
		return r79_tequalon;
	}
	public void setR79_tequalon(BigDecimal r79_tequalon) {
		this.r79_tequalon = r79_tequalon;
	}
	public BigDecimal getR79_on_t_equalto_1m() {
		return r79_on_t_equalto_1m;
	}
	public void setR79_on_t_equalto_1m(BigDecimal r79_on_t_equalto_1m) {
		this.r79_on_t_equalto_1m = r79_on_t_equalto_1m;
	}
	public BigDecimal getR79_1m_t_equalto_3m() {
		return r79_1m_t_equalto_3m;
	}
	public void setR79_1m_t_equalto_3m(BigDecimal r79_1m_t_equalto_3m) {
		this.r79_1m_t_equalto_3m = r79_1m_t_equalto_3m;
	}
	public BigDecimal getR79_3m_t_equalto_6m() {
		return r79_3m_t_equalto_6m;
	}
	public void setR79_3m_t_equalto_6m(BigDecimal r79_3m_t_equalto_6m) {
		this.r79_3m_t_equalto_6m = r79_3m_t_equalto_6m;
	}
	public BigDecimal getR79_6m_t_equalto_9m() {
		return r79_6m_t_equalto_9m;
	}
	public void setR79_6m_t_equalto_9m(BigDecimal r79_6m_t_equalto_9m) {
		this.r79_6m_t_equalto_9m = r79_6m_t_equalto_9m;
	}
	public BigDecimal getR79_9m_t_equalto_1y() {
		return r79_9m_t_equalto_1y;
	}
	public void setR79_9m_t_equalto_1y(BigDecimal r79_9m_t_equalto_1y) {
		this.r79_9m_t_equalto_1y = r79_9m_t_equalto_1y;
	}
	public BigDecimal getR79_1y_t_equalto_1point5y() {
		return r79_1y_t_equalto_1point5y;
	}
	public void setR79_1y_t_equalto_1point5y(BigDecimal r79_1y_t_equalto_1point5y) {
		this.r79_1y_t_equalto_1point5y = r79_1y_t_equalto_1point5y;
	}
	public BigDecimal getR79_1point5y_t_equalto_2y() {
		return r79_1point5y_t_equalto_2y;
	}
	public void setR79_1point5y_t_equalto_2y(BigDecimal r79_1point5y_t_equalto_2y) {
		this.r79_1point5y_t_equalto_2y = r79_1point5y_t_equalto_2y;
	}
	public BigDecimal getR79_2y_t_equalto_3y() {
		return r79_2y_t_equalto_3y;
	}
	public void setR79_2y_t_equalto_3y(BigDecimal r79_2y_t_equalto_3y) {
		this.r79_2y_t_equalto_3y = r79_2y_t_equalto_3y;
	}
	public BigDecimal getR79_3y_t_equalto_4y() {
		return r79_3y_t_equalto_4y;
	}
	public void setR79_3y_t_equalto_4y(BigDecimal r79_3y_t_equalto_4y) {
		this.r79_3y_t_equalto_4y = r79_3y_t_equalto_4y;
	}
	public BigDecimal getR79_4y_lt_t_ltequalto_5y() {
		return r79_4y_lt_t_ltequalto_5y;
	}
	public void setR79_4y_lt_t_ltequalto_5y(BigDecimal r79_4y_lt_t_ltequalto_5y) {
		this.r79_4y_lt_t_ltequalto_5y = r79_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR79_5y_lt_t_ltequalto_6y() {
		return r79_5y_lt_t_ltequalto_6y;
	}
	public void setR79_5y_lt_t_ltequalto_6y(BigDecimal r79_5y_lt_t_ltequalto_6y) {
		this.r79_5y_lt_t_ltequalto_6y = r79_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR79_6y_lt_t_ltequalto_7y() {
		return r79_6y_lt_t_ltequalto_7y;
	}
	public void setR79_6y_lt_t_ltequalto_7y(BigDecimal r79_6y_lt_t_ltequalto_7y) {
		this.r79_6y_lt_t_ltequalto_7y = r79_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR79_7y_lt_t_ltequalto_8y() {
		return r79_7y_lt_t_ltequalto_8y;
	}
	public void setR79_7y_lt_t_ltequalto_8y(BigDecimal r79_7y_lt_t_ltequalto_8y) {
		this.r79_7y_lt_t_ltequalto_8y = r79_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR79_8y_lt_t_ltequalto_9y() {
		return r79_8y_lt_t_ltequalto_9y;
	}
	public void setR79_8y_lt_t_ltequalto_9y(BigDecimal r79_8y_lt_t_ltequalto_9y) {
		this.r79_8y_lt_t_ltequalto_9y = r79_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR79_9y_lt_t_ltequalto_10y() {
		return r79_9y_lt_t_ltequalto_10y;
	}
	public void setR79_9y_lt_t_ltequalto_10y(BigDecimal r79_9y_lt_t_ltequalto_10y) {
		this.r79_9y_lt_t_ltequalto_10y = r79_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR79_10y_lt_t_ltequalto_15y() {
		return r79_10y_lt_t_ltequalto_15y;
	}
	public void setR79_10y_lt_t_ltequalto_15y(BigDecimal r79_10y_lt_t_ltequalto_15y) {
		this.r79_10y_lt_t_ltequalto_15y = r79_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR79_15y_lt_t_ltequalto_20y() {
		return r79_15y_lt_t_ltequalto_20y;
	}
	public void setR79_15y_lt_t_ltequalto_20y(BigDecimal r79_15y_lt_t_ltequalto_20y) {
		this.r79_15y_lt_t_ltequalto_20y = r79_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR79_tl_20y() {
		return r79_tl_20y;
	}
	public void setR79_tl_20y(BigDecimal r79_tl_20y) {
		this.r79_tl_20y = r79_tl_20y;
	}
	public BigDecimal getR79_nonsensitive() {
		return r79_nonsensitive;
	}
	public void setR79_nonsensitive(BigDecimal r79_nonsensitive) {
		this.r79_nonsensitive = r79_nonsensitive;
	}
	public BigDecimal getR79_total_rsl() {
		return r79_total_rsl;
	}
	public void setR79_total_rsl(BigDecimal r79_total_rsl) {
		this.r79_total_rsl = r79_total_rsl;
	}
	public BigDecimal getR79_total() {
		return r79_total;
	}
	public void setR79_total(BigDecimal r79_total) {
		this.r79_total = r79_total;
	}
	public String getR80_product() {
		return r80_product;
	}
	public void setR80_product(String r80_product) {
		this.r80_product = r80_product;
	}
	public BigDecimal getR80_tequalon() {
		return r80_tequalon;
	}
	public void setR80_tequalon(BigDecimal r80_tequalon) {
		this.r80_tequalon = r80_tequalon;
	}
	public BigDecimal getR80_on_t_equalto_1m() {
		return r80_on_t_equalto_1m;
	}
	public void setR80_on_t_equalto_1m(BigDecimal r80_on_t_equalto_1m) {
		this.r80_on_t_equalto_1m = r80_on_t_equalto_1m;
	}
	public BigDecimal getR80_1m_t_equalto_3m() {
		return r80_1m_t_equalto_3m;
	}
	public void setR80_1m_t_equalto_3m(BigDecimal r80_1m_t_equalto_3m) {
		this.r80_1m_t_equalto_3m = r80_1m_t_equalto_3m;
	}
	public BigDecimal getR80_3m_t_equalto_6m() {
		return r80_3m_t_equalto_6m;
	}
	public void setR80_3m_t_equalto_6m(BigDecimal r80_3m_t_equalto_6m) {
		this.r80_3m_t_equalto_6m = r80_3m_t_equalto_6m;
	}
	public BigDecimal getR80_6m_t_equalto_9m() {
		return r80_6m_t_equalto_9m;
	}
	public void setR80_6m_t_equalto_9m(BigDecimal r80_6m_t_equalto_9m) {
		this.r80_6m_t_equalto_9m = r80_6m_t_equalto_9m;
	}
	public BigDecimal getR80_9m_t_equalto_1y() {
		return r80_9m_t_equalto_1y;
	}
	public void setR80_9m_t_equalto_1y(BigDecimal r80_9m_t_equalto_1y) {
		this.r80_9m_t_equalto_1y = r80_9m_t_equalto_1y;
	}
	public BigDecimal getR80_1y_t_equalto_1point5y() {
		return r80_1y_t_equalto_1point5y;
	}
	public void setR80_1y_t_equalto_1point5y(BigDecimal r80_1y_t_equalto_1point5y) {
		this.r80_1y_t_equalto_1point5y = r80_1y_t_equalto_1point5y;
	}
	public BigDecimal getR80_1point5y_t_equalto_2y() {
		return r80_1point5y_t_equalto_2y;
	}
	public void setR80_1point5y_t_equalto_2y(BigDecimal r80_1point5y_t_equalto_2y) {
		this.r80_1point5y_t_equalto_2y = r80_1point5y_t_equalto_2y;
	}
	public BigDecimal getR80_2y_t_equalto_3y() {
		return r80_2y_t_equalto_3y;
	}
	public void setR80_2y_t_equalto_3y(BigDecimal r80_2y_t_equalto_3y) {
		this.r80_2y_t_equalto_3y = r80_2y_t_equalto_3y;
	}
	public BigDecimal getR80_3y_t_equalto_4y() {
		return r80_3y_t_equalto_4y;
	}
	public void setR80_3y_t_equalto_4y(BigDecimal r80_3y_t_equalto_4y) {
		this.r80_3y_t_equalto_4y = r80_3y_t_equalto_4y;
	}
	public BigDecimal getR80_4y_lt_t_ltequalto_5y() {
		return r80_4y_lt_t_ltequalto_5y;
	}
	public void setR80_4y_lt_t_ltequalto_5y(BigDecimal r80_4y_lt_t_ltequalto_5y) {
		this.r80_4y_lt_t_ltequalto_5y = r80_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR80_5y_lt_t_ltequalto_6y() {
		return r80_5y_lt_t_ltequalto_6y;
	}
	public void setR80_5y_lt_t_ltequalto_6y(BigDecimal r80_5y_lt_t_ltequalto_6y) {
		this.r80_5y_lt_t_ltequalto_6y = r80_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR80_6y_lt_t_ltequalto_7y() {
		return r80_6y_lt_t_ltequalto_7y;
	}
	public void setR80_6y_lt_t_ltequalto_7y(BigDecimal r80_6y_lt_t_ltequalto_7y) {
		this.r80_6y_lt_t_ltequalto_7y = r80_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR80_7y_lt_t_ltequalto_8y() {
		return r80_7y_lt_t_ltequalto_8y;
	}
	public void setR80_7y_lt_t_ltequalto_8y(BigDecimal r80_7y_lt_t_ltequalto_8y) {
		this.r80_7y_lt_t_ltequalto_8y = r80_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR80_8y_lt_t_ltequalto_9y() {
		return r80_8y_lt_t_ltequalto_9y;
	}
	public void setR80_8y_lt_t_ltequalto_9y(BigDecimal r80_8y_lt_t_ltequalto_9y) {
		this.r80_8y_lt_t_ltequalto_9y = r80_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR80_9y_lt_t_ltequalto_10y() {
		return r80_9y_lt_t_ltequalto_10y;
	}
	public void setR80_9y_lt_t_ltequalto_10y(BigDecimal r80_9y_lt_t_ltequalto_10y) {
		this.r80_9y_lt_t_ltequalto_10y = r80_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR80_10y_lt_t_ltequalto_15y() {
		return r80_10y_lt_t_ltequalto_15y;
	}
	public void setR80_10y_lt_t_ltequalto_15y(BigDecimal r80_10y_lt_t_ltequalto_15y) {
		this.r80_10y_lt_t_ltequalto_15y = r80_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR80_15y_lt_t_ltequalto_20y() {
		return r80_15y_lt_t_ltequalto_20y;
	}
	public void setR80_15y_lt_t_ltequalto_20y(BigDecimal r80_15y_lt_t_ltequalto_20y) {
		this.r80_15y_lt_t_ltequalto_20y = r80_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR80_tl_20y() {
		return r80_tl_20y;
	}
	public void setR80_tl_20y(BigDecimal r80_tl_20y) {
		this.r80_tl_20y = r80_tl_20y;
	}
	public BigDecimal getR80_nonsensitive() {
		return r80_nonsensitive;
	}
	public void setR80_nonsensitive(BigDecimal r80_nonsensitive) {
		this.r80_nonsensitive = r80_nonsensitive;
	}
	public BigDecimal getR80_total_rsl() {
		return r80_total_rsl;
	}
	public void setR80_total_rsl(BigDecimal r80_total_rsl) {
		this.r80_total_rsl = r80_total_rsl;
	}
	public BigDecimal getR80_total() {
		return r80_total;
	}
	public void setR80_total(BigDecimal r80_total) {
		this.r80_total = r80_total;
	}
	public String getR81_product() {
		return r81_product;
	}
	public void setR81_product(String r81_product) {
		this.r81_product = r81_product;
	}
	public BigDecimal getR81_tequalon() {
		return r81_tequalon;
	}
	public void setR81_tequalon(BigDecimal r81_tequalon) {
		this.r81_tequalon = r81_tequalon;
	}
	public BigDecimal getR81_on_t_equalto_1m() {
		return r81_on_t_equalto_1m;
	}
	public void setR81_on_t_equalto_1m(BigDecimal r81_on_t_equalto_1m) {
		this.r81_on_t_equalto_1m = r81_on_t_equalto_1m;
	}
	public BigDecimal getR81_1m_t_equalto_3m() {
		return r81_1m_t_equalto_3m;
	}
	public void setR81_1m_t_equalto_3m(BigDecimal r81_1m_t_equalto_3m) {
		this.r81_1m_t_equalto_3m = r81_1m_t_equalto_3m;
	}
	public BigDecimal getR81_3m_t_equalto_6m() {
		return r81_3m_t_equalto_6m;
	}
	public void setR81_3m_t_equalto_6m(BigDecimal r81_3m_t_equalto_6m) {
		this.r81_3m_t_equalto_6m = r81_3m_t_equalto_6m;
	}
	public BigDecimal getR81_6m_t_equalto_9m() {
		return r81_6m_t_equalto_9m;
	}
	public void setR81_6m_t_equalto_9m(BigDecimal r81_6m_t_equalto_9m) {
		this.r81_6m_t_equalto_9m = r81_6m_t_equalto_9m;
	}
	public BigDecimal getR81_9m_t_equalto_1y() {
		return r81_9m_t_equalto_1y;
	}
	public void setR81_9m_t_equalto_1y(BigDecimal r81_9m_t_equalto_1y) {
		this.r81_9m_t_equalto_1y = r81_9m_t_equalto_1y;
	}
	public BigDecimal getR81_1y_t_equalto_1point5y() {
		return r81_1y_t_equalto_1point5y;
	}
	public void setR81_1y_t_equalto_1point5y(BigDecimal r81_1y_t_equalto_1point5y) {
		this.r81_1y_t_equalto_1point5y = r81_1y_t_equalto_1point5y;
	}
	public BigDecimal getR81_1point5y_t_equalto_2y() {
		return r81_1point5y_t_equalto_2y;
	}
	public void setR81_1point5y_t_equalto_2y(BigDecimal r81_1point5y_t_equalto_2y) {
		this.r81_1point5y_t_equalto_2y = r81_1point5y_t_equalto_2y;
	}
	public BigDecimal getR81_2y_t_equalto_3y() {
		return r81_2y_t_equalto_3y;
	}
	public void setR81_2y_t_equalto_3y(BigDecimal r81_2y_t_equalto_3y) {
		this.r81_2y_t_equalto_3y = r81_2y_t_equalto_3y;
	}
	public BigDecimal getR81_3y_t_equalto_4y() {
		return r81_3y_t_equalto_4y;
	}
	public void setR81_3y_t_equalto_4y(BigDecimal r81_3y_t_equalto_4y) {
		this.r81_3y_t_equalto_4y = r81_3y_t_equalto_4y;
	}
	public BigDecimal getR81_4y_lt_t_ltequalto_5y() {
		return r81_4y_lt_t_ltequalto_5y;
	}
	public void setR81_4y_lt_t_ltequalto_5y(BigDecimal r81_4y_lt_t_ltequalto_5y) {
		this.r81_4y_lt_t_ltequalto_5y = r81_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR81_5y_lt_t_ltequalto_6y() {
		return r81_5y_lt_t_ltequalto_6y;
	}
	public void setR81_5y_lt_t_ltequalto_6y(BigDecimal r81_5y_lt_t_ltequalto_6y) {
		this.r81_5y_lt_t_ltequalto_6y = r81_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR81_6y_lt_t_ltequalto_7y() {
		return r81_6y_lt_t_ltequalto_7y;
	}
	public void setR81_6y_lt_t_ltequalto_7y(BigDecimal r81_6y_lt_t_ltequalto_7y) {
		this.r81_6y_lt_t_ltequalto_7y = r81_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR81_7y_lt_t_ltequalto_8y() {
		return r81_7y_lt_t_ltequalto_8y;
	}
	public void setR81_7y_lt_t_ltequalto_8y(BigDecimal r81_7y_lt_t_ltequalto_8y) {
		this.r81_7y_lt_t_ltequalto_8y = r81_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR81_8y_lt_t_ltequalto_9y() {
		return r81_8y_lt_t_ltequalto_9y;
	}
	public void setR81_8y_lt_t_ltequalto_9y(BigDecimal r81_8y_lt_t_ltequalto_9y) {
		this.r81_8y_lt_t_ltequalto_9y = r81_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR81_9y_lt_t_ltequalto_10y() {
		return r81_9y_lt_t_ltequalto_10y;
	}
	public void setR81_9y_lt_t_ltequalto_10y(BigDecimal r81_9y_lt_t_ltequalto_10y) {
		this.r81_9y_lt_t_ltequalto_10y = r81_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR81_10y_lt_t_ltequalto_15y() {
		return r81_10y_lt_t_ltequalto_15y;
	}
	public void setR81_10y_lt_t_ltequalto_15y(BigDecimal r81_10y_lt_t_ltequalto_15y) {
		this.r81_10y_lt_t_ltequalto_15y = r81_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR81_15y_lt_t_ltequalto_20y() {
		return r81_15y_lt_t_ltequalto_20y;
	}
	public void setR81_15y_lt_t_ltequalto_20y(BigDecimal r81_15y_lt_t_ltequalto_20y) {
		this.r81_15y_lt_t_ltequalto_20y = r81_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR81_tl_20y() {
		return r81_tl_20y;
	}
	public void setR81_tl_20y(BigDecimal r81_tl_20y) {
		this.r81_tl_20y = r81_tl_20y;
	}
	public BigDecimal getR81_nonsensitive() {
		return r81_nonsensitive;
	}
	public void setR81_nonsensitive(BigDecimal r81_nonsensitive) {
		this.r81_nonsensitive = r81_nonsensitive;
	}
	public BigDecimal getR81_total_rsl() {
		return r81_total_rsl;
	}
	public void setR81_total_rsl(BigDecimal r81_total_rsl) {
		this.r81_total_rsl = r81_total_rsl;
	}
	public BigDecimal getR81_total() {
		return r81_total;
	}
	public void setR81_total(BigDecimal r81_total) {
		this.r81_total = r81_total;
	}
	public String getR82_product() {
		return r82_product;
	}
	public void setR82_product(String r82_product) {
		this.r82_product = r82_product;
	}
	public BigDecimal getR82_tequalon() {
		return r82_tequalon;
	}
	public void setR82_tequalon(BigDecimal r82_tequalon) {
		this.r82_tequalon = r82_tequalon;
	}
	public BigDecimal getR82_on_t_equalto_1m() {
		return r82_on_t_equalto_1m;
	}
	public void setR82_on_t_equalto_1m(BigDecimal r82_on_t_equalto_1m) {
		this.r82_on_t_equalto_1m = r82_on_t_equalto_1m;
	}
	public BigDecimal getR82_1m_t_equalto_3m() {
		return r82_1m_t_equalto_3m;
	}
	public void setR82_1m_t_equalto_3m(BigDecimal r82_1m_t_equalto_3m) {
		this.r82_1m_t_equalto_3m = r82_1m_t_equalto_3m;
	}
	public BigDecimal getR82_3m_t_equalto_6m() {
		return r82_3m_t_equalto_6m;
	}
	public void setR82_3m_t_equalto_6m(BigDecimal r82_3m_t_equalto_6m) {
		this.r82_3m_t_equalto_6m = r82_3m_t_equalto_6m;
	}
	public BigDecimal getR82_6m_t_equalto_9m() {
		return r82_6m_t_equalto_9m;
	}
	public void setR82_6m_t_equalto_9m(BigDecimal r82_6m_t_equalto_9m) {
		this.r82_6m_t_equalto_9m = r82_6m_t_equalto_9m;
	}
	public BigDecimal getR82_9m_t_equalto_1y() {
		return r82_9m_t_equalto_1y;
	}
	public void setR82_9m_t_equalto_1y(BigDecimal r82_9m_t_equalto_1y) {
		this.r82_9m_t_equalto_1y = r82_9m_t_equalto_1y;
	}
	public BigDecimal getR82_1y_t_equalto_1point5y() {
		return r82_1y_t_equalto_1point5y;
	}
	public void setR82_1y_t_equalto_1point5y(BigDecimal r82_1y_t_equalto_1point5y) {
		this.r82_1y_t_equalto_1point5y = r82_1y_t_equalto_1point5y;
	}
	public BigDecimal getR82_1point5y_t_equalto_2y() {
		return r82_1point5y_t_equalto_2y;
	}
	public void setR82_1point5y_t_equalto_2y(BigDecimal r82_1point5y_t_equalto_2y) {
		this.r82_1point5y_t_equalto_2y = r82_1point5y_t_equalto_2y;
	}
	public BigDecimal getR82_2y_t_equalto_3y() {
		return r82_2y_t_equalto_3y;
	}
	public void setR82_2y_t_equalto_3y(BigDecimal r82_2y_t_equalto_3y) {
		this.r82_2y_t_equalto_3y = r82_2y_t_equalto_3y;
	}
	public BigDecimal getR82_3y_t_equalto_4y() {
		return r82_3y_t_equalto_4y;
	}
	public void setR82_3y_t_equalto_4y(BigDecimal r82_3y_t_equalto_4y) {
		this.r82_3y_t_equalto_4y = r82_3y_t_equalto_4y;
	}
	public BigDecimal getR82_4y_lt_t_ltequalto_5y() {
		return r82_4y_lt_t_ltequalto_5y;
	}
	public void setR82_4y_lt_t_ltequalto_5y(BigDecimal r82_4y_lt_t_ltequalto_5y) {
		this.r82_4y_lt_t_ltequalto_5y = r82_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR82_5y_lt_t_ltequalto_6y() {
		return r82_5y_lt_t_ltequalto_6y;
	}
	public void setR82_5y_lt_t_ltequalto_6y(BigDecimal r82_5y_lt_t_ltequalto_6y) {
		this.r82_5y_lt_t_ltequalto_6y = r82_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR82_6y_lt_t_ltequalto_7y() {
		return r82_6y_lt_t_ltequalto_7y;
	}
	public void setR82_6y_lt_t_ltequalto_7y(BigDecimal r82_6y_lt_t_ltequalto_7y) {
		this.r82_6y_lt_t_ltequalto_7y = r82_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR82_7y_lt_t_ltequalto_8y() {
		return r82_7y_lt_t_ltequalto_8y;
	}
	public void setR82_7y_lt_t_ltequalto_8y(BigDecimal r82_7y_lt_t_ltequalto_8y) {
		this.r82_7y_lt_t_ltequalto_8y = r82_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR82_8y_lt_t_ltequalto_9y() {
		return r82_8y_lt_t_ltequalto_9y;
	}
	public void setR82_8y_lt_t_ltequalto_9y(BigDecimal r82_8y_lt_t_ltequalto_9y) {
		this.r82_8y_lt_t_ltequalto_9y = r82_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR82_9y_lt_t_ltequalto_10y() {
		return r82_9y_lt_t_ltequalto_10y;
	}
	public void setR82_9y_lt_t_ltequalto_10y(BigDecimal r82_9y_lt_t_ltequalto_10y) {
		this.r82_9y_lt_t_ltequalto_10y = r82_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR82_10y_lt_t_ltequalto_15y() {
		return r82_10y_lt_t_ltequalto_15y;
	}
	public void setR82_10y_lt_t_ltequalto_15y(BigDecimal r82_10y_lt_t_ltequalto_15y) {
		this.r82_10y_lt_t_ltequalto_15y = r82_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR82_15y_lt_t_ltequalto_20y() {
		return r82_15y_lt_t_ltequalto_20y;
	}
	public void setR82_15y_lt_t_ltequalto_20y(BigDecimal r82_15y_lt_t_ltequalto_20y) {
		this.r82_15y_lt_t_ltequalto_20y = r82_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR82_tl_20y() {
		return r82_tl_20y;
	}
	public void setR82_tl_20y(BigDecimal r82_tl_20y) {
		this.r82_tl_20y = r82_tl_20y;
	}
	public BigDecimal getR82_nonsensitive() {
		return r82_nonsensitive;
	}
	public void setR82_nonsensitive(BigDecimal r82_nonsensitive) {
		this.r82_nonsensitive = r82_nonsensitive;
	}
	public BigDecimal getR82_total_rsl() {
		return r82_total_rsl;
	}
	public void setR82_total_rsl(BigDecimal r82_total_rsl) {
		this.r82_total_rsl = r82_total_rsl;
	}
	public BigDecimal getR82_total() {
		return r82_total;
	}
	public void setR82_total(BigDecimal r82_total) {
		this.r82_total = r82_total;
	}
	public String getR83_product() {
		return r83_product;
	}
	public void setR83_product(String r83_product) {
		this.r83_product = r83_product;
	}
	public BigDecimal getR83_tequalon() {
		return r83_tequalon;
	}
	public void setR83_tequalon(BigDecimal r83_tequalon) {
		this.r83_tequalon = r83_tequalon;
	}
	public BigDecimal getR83_on_t_equalto_1m() {
		return r83_on_t_equalto_1m;
	}
	public void setR83_on_t_equalto_1m(BigDecimal r83_on_t_equalto_1m) {
		this.r83_on_t_equalto_1m = r83_on_t_equalto_1m;
	}
	public BigDecimal getR83_1m_t_equalto_3m() {
		return r83_1m_t_equalto_3m;
	}
	public void setR83_1m_t_equalto_3m(BigDecimal r83_1m_t_equalto_3m) {
		this.r83_1m_t_equalto_3m = r83_1m_t_equalto_3m;
	}
	public BigDecimal getR83_3m_t_equalto_6m() {
		return r83_3m_t_equalto_6m;
	}
	public void setR83_3m_t_equalto_6m(BigDecimal r83_3m_t_equalto_6m) {
		this.r83_3m_t_equalto_6m = r83_3m_t_equalto_6m;
	}
	public BigDecimal getR83_6m_t_equalto_9m() {
		return r83_6m_t_equalto_9m;
	}
	public void setR83_6m_t_equalto_9m(BigDecimal r83_6m_t_equalto_9m) {
		this.r83_6m_t_equalto_9m = r83_6m_t_equalto_9m;
	}
	public BigDecimal getR83_9m_t_equalto_1y() {
		return r83_9m_t_equalto_1y;
	}
	public void setR83_9m_t_equalto_1y(BigDecimal r83_9m_t_equalto_1y) {
		this.r83_9m_t_equalto_1y = r83_9m_t_equalto_1y;
	}
	public BigDecimal getR83_1y_t_equalto_1point5y() {
		return r83_1y_t_equalto_1point5y;
	}
	public void setR83_1y_t_equalto_1point5y(BigDecimal r83_1y_t_equalto_1point5y) {
		this.r83_1y_t_equalto_1point5y = r83_1y_t_equalto_1point5y;
	}
	public BigDecimal getR83_1point5y_t_equalto_2y() {
		return r83_1point5y_t_equalto_2y;
	}
	public void setR83_1point5y_t_equalto_2y(BigDecimal r83_1point5y_t_equalto_2y) {
		this.r83_1point5y_t_equalto_2y = r83_1point5y_t_equalto_2y;
	}
	public BigDecimal getR83_2y_t_equalto_3y() {
		return r83_2y_t_equalto_3y;
	}
	public void setR83_2y_t_equalto_3y(BigDecimal r83_2y_t_equalto_3y) {
		this.r83_2y_t_equalto_3y = r83_2y_t_equalto_3y;
	}
	public BigDecimal getR83_3y_t_equalto_4y() {
		return r83_3y_t_equalto_4y;
	}
	public void setR83_3y_t_equalto_4y(BigDecimal r83_3y_t_equalto_4y) {
		this.r83_3y_t_equalto_4y = r83_3y_t_equalto_4y;
	}
	public BigDecimal getR83_4y_lt_t_ltequalto_5y() {
		return r83_4y_lt_t_ltequalto_5y;
	}
	public void setR83_4y_lt_t_ltequalto_5y(BigDecimal r83_4y_lt_t_ltequalto_5y) {
		this.r83_4y_lt_t_ltequalto_5y = r83_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR83_5y_lt_t_ltequalto_6y() {
		return r83_5y_lt_t_ltequalto_6y;
	}
	public void setR83_5y_lt_t_ltequalto_6y(BigDecimal r83_5y_lt_t_ltequalto_6y) {
		this.r83_5y_lt_t_ltequalto_6y = r83_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR83_6y_lt_t_ltequalto_7y() {
		return r83_6y_lt_t_ltequalto_7y;
	}
	public void setR83_6y_lt_t_ltequalto_7y(BigDecimal r83_6y_lt_t_ltequalto_7y) {
		this.r83_6y_lt_t_ltequalto_7y = r83_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR83_7y_lt_t_ltequalto_8y() {
		return r83_7y_lt_t_ltequalto_8y;
	}
	public void setR83_7y_lt_t_ltequalto_8y(BigDecimal r83_7y_lt_t_ltequalto_8y) {
		this.r83_7y_lt_t_ltequalto_8y = r83_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR83_8y_lt_t_ltequalto_9y() {
		return r83_8y_lt_t_ltequalto_9y;
	}
	public void setR83_8y_lt_t_ltequalto_9y(BigDecimal r83_8y_lt_t_ltequalto_9y) {
		this.r83_8y_lt_t_ltequalto_9y = r83_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR83_9y_lt_t_ltequalto_10y() {
		return r83_9y_lt_t_ltequalto_10y;
	}
	public void setR83_9y_lt_t_ltequalto_10y(BigDecimal r83_9y_lt_t_ltequalto_10y) {
		this.r83_9y_lt_t_ltequalto_10y = r83_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR83_10y_lt_t_ltequalto_15y() {
		return r83_10y_lt_t_ltequalto_15y;
	}
	public void setR83_10y_lt_t_ltequalto_15y(BigDecimal r83_10y_lt_t_ltequalto_15y) {
		this.r83_10y_lt_t_ltequalto_15y = r83_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR83_15y_lt_t_ltequalto_20y() {
		return r83_15y_lt_t_ltequalto_20y;
	}
	public void setR83_15y_lt_t_ltequalto_20y(BigDecimal r83_15y_lt_t_ltequalto_20y) {
		this.r83_15y_lt_t_ltequalto_20y = r83_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR83_tl_20y() {
		return r83_tl_20y;
	}
	public void setR83_tl_20y(BigDecimal r83_tl_20y) {
		this.r83_tl_20y = r83_tl_20y;
	}
	public BigDecimal getR83_nonsensitive() {
		return r83_nonsensitive;
	}
	public void setR83_nonsensitive(BigDecimal r83_nonsensitive) {
		this.r83_nonsensitive = r83_nonsensitive;
	}
	public BigDecimal getR83_total_rsl() {
		return r83_total_rsl;
	}
	public void setR83_total_rsl(BigDecimal r83_total_rsl) {
		this.r83_total_rsl = r83_total_rsl;
	}
	public BigDecimal getR83_total() {
		return r83_total;
	}
	public void setR83_total(BigDecimal r83_total) {
		this.r83_total = r83_total;
	}
	public String getR84_product() {
		return r84_product;
	}
	public void setR84_product(String r84_product) {
		this.r84_product = r84_product;
	}
	public BigDecimal getR84_tequalon() {
		return r84_tequalon;
	}
	public void setR84_tequalon(BigDecimal r84_tequalon) {
		this.r84_tequalon = r84_tequalon;
	}
	public BigDecimal getR84_on_t_equalto_1m() {
		return r84_on_t_equalto_1m;
	}
	public void setR84_on_t_equalto_1m(BigDecimal r84_on_t_equalto_1m) {
		this.r84_on_t_equalto_1m = r84_on_t_equalto_1m;
	}
	public BigDecimal getR84_1m_t_equalto_3m() {
		return r84_1m_t_equalto_3m;
	}
	public void setR84_1m_t_equalto_3m(BigDecimal r84_1m_t_equalto_3m) {
		this.r84_1m_t_equalto_3m = r84_1m_t_equalto_3m;
	}
	public BigDecimal getR84_3m_t_equalto_6m() {
		return r84_3m_t_equalto_6m;
	}
	public void setR84_3m_t_equalto_6m(BigDecimal r84_3m_t_equalto_6m) {
		this.r84_3m_t_equalto_6m = r84_3m_t_equalto_6m;
	}
	public BigDecimal getR84_6m_t_equalto_9m() {
		return r84_6m_t_equalto_9m;
	}
	public void setR84_6m_t_equalto_9m(BigDecimal r84_6m_t_equalto_9m) {
		this.r84_6m_t_equalto_9m = r84_6m_t_equalto_9m;
	}
	public BigDecimal getR84_9m_t_equalto_1y() {
		return r84_9m_t_equalto_1y;
	}
	public void setR84_9m_t_equalto_1y(BigDecimal r84_9m_t_equalto_1y) {
		this.r84_9m_t_equalto_1y = r84_9m_t_equalto_1y;
	}
	public BigDecimal getR84_1y_t_equalto_1point5y() {
		return r84_1y_t_equalto_1point5y;
	}
	public void setR84_1y_t_equalto_1point5y(BigDecimal r84_1y_t_equalto_1point5y) {
		this.r84_1y_t_equalto_1point5y = r84_1y_t_equalto_1point5y;
	}
	public BigDecimal getR84_1point5y_t_equalto_2y() {
		return r84_1point5y_t_equalto_2y;
	}
	public void setR84_1point5y_t_equalto_2y(BigDecimal r84_1point5y_t_equalto_2y) {
		this.r84_1point5y_t_equalto_2y = r84_1point5y_t_equalto_2y;
	}
	public BigDecimal getR84_2y_t_equalto_3y() {
		return r84_2y_t_equalto_3y;
	}
	public void setR84_2y_t_equalto_3y(BigDecimal r84_2y_t_equalto_3y) {
		this.r84_2y_t_equalto_3y = r84_2y_t_equalto_3y;
	}
	public BigDecimal getR84_3y_t_equalto_4y() {
		return r84_3y_t_equalto_4y;
	}
	public void setR84_3y_t_equalto_4y(BigDecimal r84_3y_t_equalto_4y) {
		this.r84_3y_t_equalto_4y = r84_3y_t_equalto_4y;
	}
	public BigDecimal getR84_4y_lt_t_ltequalto_5y() {
		return r84_4y_lt_t_ltequalto_5y;
	}
	public void setR84_4y_lt_t_ltequalto_5y(BigDecimal r84_4y_lt_t_ltequalto_5y) {
		this.r84_4y_lt_t_ltequalto_5y = r84_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR84_5y_lt_t_ltequalto_6y() {
		return r84_5y_lt_t_ltequalto_6y;
	}
	public void setR84_5y_lt_t_ltequalto_6y(BigDecimal r84_5y_lt_t_ltequalto_6y) {
		this.r84_5y_lt_t_ltequalto_6y = r84_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR84_6y_lt_t_ltequalto_7y() {
		return r84_6y_lt_t_ltequalto_7y;
	}
	public void setR84_6y_lt_t_ltequalto_7y(BigDecimal r84_6y_lt_t_ltequalto_7y) {
		this.r84_6y_lt_t_ltequalto_7y = r84_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR84_7y_lt_t_ltequalto_8y() {
		return r84_7y_lt_t_ltequalto_8y;
	}
	public void setR84_7y_lt_t_ltequalto_8y(BigDecimal r84_7y_lt_t_ltequalto_8y) {
		this.r84_7y_lt_t_ltequalto_8y = r84_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR84_8y_lt_t_ltequalto_9y() {
		return r84_8y_lt_t_ltequalto_9y;
	}
	public void setR84_8y_lt_t_ltequalto_9y(BigDecimal r84_8y_lt_t_ltequalto_9y) {
		this.r84_8y_lt_t_ltequalto_9y = r84_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR84_9y_lt_t_ltequalto_10y() {
		return r84_9y_lt_t_ltequalto_10y;
	}
	public void setR84_9y_lt_t_ltequalto_10y(BigDecimal r84_9y_lt_t_ltequalto_10y) {
		this.r84_9y_lt_t_ltequalto_10y = r84_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR84_10y_lt_t_ltequalto_15y() {
		return r84_10y_lt_t_ltequalto_15y;
	}
	public void setR84_10y_lt_t_ltequalto_15y(BigDecimal r84_10y_lt_t_ltequalto_15y) {
		this.r84_10y_lt_t_ltequalto_15y = r84_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR84_15y_lt_t_ltequalto_20y() {
		return r84_15y_lt_t_ltequalto_20y;
	}
	public void setR84_15y_lt_t_ltequalto_20y(BigDecimal r84_15y_lt_t_ltequalto_20y) {
		this.r84_15y_lt_t_ltequalto_20y = r84_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR84_tl_20y() {
		return r84_tl_20y;
	}
	public void setR84_tl_20y(BigDecimal r84_tl_20y) {
		this.r84_tl_20y = r84_tl_20y;
	}
	public BigDecimal getR84_nonsensitive() {
		return r84_nonsensitive;
	}
	public void setR84_nonsensitive(BigDecimal r84_nonsensitive) {
		this.r84_nonsensitive = r84_nonsensitive;
	}
	public BigDecimal getR84_total_rsl() {
		return r84_total_rsl;
	}
	public void setR84_total_rsl(BigDecimal r84_total_rsl) {
		this.r84_total_rsl = r84_total_rsl;
	}
	public BigDecimal getR84_total() {
		return r84_total;
	}
	public void setR84_total(BigDecimal r84_total) {
		this.r84_total = r84_total;
	}
	public String getR85_product() {
		return r85_product;
	}
	public void setR85_product(String r85_product) {
		this.r85_product = r85_product;
	}
	public BigDecimal getR85_tequalon() {
		return r85_tequalon;
	}
	public void setR85_tequalon(BigDecimal r85_tequalon) {
		this.r85_tequalon = r85_tequalon;
	}
	public BigDecimal getR85_on_t_equalto_1m() {
		return r85_on_t_equalto_1m;
	}
	public void setR85_on_t_equalto_1m(BigDecimal r85_on_t_equalto_1m) {
		this.r85_on_t_equalto_1m = r85_on_t_equalto_1m;
	}
	public BigDecimal getR85_1m_t_equalto_3m() {
		return r85_1m_t_equalto_3m;
	}
	public void setR85_1m_t_equalto_3m(BigDecimal r85_1m_t_equalto_3m) {
		this.r85_1m_t_equalto_3m = r85_1m_t_equalto_3m;
	}
	public BigDecimal getR85_3m_t_equalto_6m() {
		return r85_3m_t_equalto_6m;
	}
	public void setR85_3m_t_equalto_6m(BigDecimal r85_3m_t_equalto_6m) {
		this.r85_3m_t_equalto_6m = r85_3m_t_equalto_6m;
	}
	public BigDecimal getR85_6m_t_equalto_9m() {
		return r85_6m_t_equalto_9m;
	}
	public void setR85_6m_t_equalto_9m(BigDecimal r85_6m_t_equalto_9m) {
		this.r85_6m_t_equalto_9m = r85_6m_t_equalto_9m;
	}
	public BigDecimal getR85_9m_t_equalto_1y() {
		return r85_9m_t_equalto_1y;
	}
	public void setR85_9m_t_equalto_1y(BigDecimal r85_9m_t_equalto_1y) {
		this.r85_9m_t_equalto_1y = r85_9m_t_equalto_1y;
	}
	public BigDecimal getR85_1y_t_equalto_1point5y() {
		return r85_1y_t_equalto_1point5y;
	}
	public void setR85_1y_t_equalto_1point5y(BigDecimal r85_1y_t_equalto_1point5y) {
		this.r85_1y_t_equalto_1point5y = r85_1y_t_equalto_1point5y;
	}
	public BigDecimal getR85_1point5y_t_equalto_2y() {
		return r85_1point5y_t_equalto_2y;
	}
	public void setR85_1point5y_t_equalto_2y(BigDecimal r85_1point5y_t_equalto_2y) {
		this.r85_1point5y_t_equalto_2y = r85_1point5y_t_equalto_2y;
	}
	public BigDecimal getR85_2y_t_equalto_3y() {
		return r85_2y_t_equalto_3y;
	}
	public void setR85_2y_t_equalto_3y(BigDecimal r85_2y_t_equalto_3y) {
		this.r85_2y_t_equalto_3y = r85_2y_t_equalto_3y;
	}
	public BigDecimal getR85_3y_t_equalto_4y() {
		return r85_3y_t_equalto_4y;
	}
	public void setR85_3y_t_equalto_4y(BigDecimal r85_3y_t_equalto_4y) {
		this.r85_3y_t_equalto_4y = r85_3y_t_equalto_4y;
	}
	public BigDecimal getR85_4y_lt_t_ltequalto_5y() {
		return r85_4y_lt_t_ltequalto_5y;
	}
	public void setR85_4y_lt_t_ltequalto_5y(BigDecimal r85_4y_lt_t_ltequalto_5y) {
		this.r85_4y_lt_t_ltequalto_5y = r85_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR85_5y_lt_t_ltequalto_6y() {
		return r85_5y_lt_t_ltequalto_6y;
	}
	public void setR85_5y_lt_t_ltequalto_6y(BigDecimal r85_5y_lt_t_ltequalto_6y) {
		this.r85_5y_lt_t_ltequalto_6y = r85_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR85_6y_lt_t_ltequalto_7y() {
		return r85_6y_lt_t_ltequalto_7y;
	}
	public void setR85_6y_lt_t_ltequalto_7y(BigDecimal r85_6y_lt_t_ltequalto_7y) {
		this.r85_6y_lt_t_ltequalto_7y = r85_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR85_7y_lt_t_ltequalto_8y() {
		return r85_7y_lt_t_ltequalto_8y;
	}
	public void setR85_7y_lt_t_ltequalto_8y(BigDecimal r85_7y_lt_t_ltequalto_8y) {
		this.r85_7y_lt_t_ltequalto_8y = r85_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR85_8y_lt_t_ltequalto_9y() {
		return r85_8y_lt_t_ltequalto_9y;
	}
	public void setR85_8y_lt_t_ltequalto_9y(BigDecimal r85_8y_lt_t_ltequalto_9y) {
		this.r85_8y_lt_t_ltequalto_9y = r85_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR85_9y_lt_t_ltequalto_10y() {
		return r85_9y_lt_t_ltequalto_10y;
	}
	public void setR85_9y_lt_t_ltequalto_10y(BigDecimal r85_9y_lt_t_ltequalto_10y) {
		this.r85_9y_lt_t_ltequalto_10y = r85_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR85_10y_lt_t_ltequalto_15y() {
		return r85_10y_lt_t_ltequalto_15y;
	}
	public void setR85_10y_lt_t_ltequalto_15y(BigDecimal r85_10y_lt_t_ltequalto_15y) {
		this.r85_10y_lt_t_ltequalto_15y = r85_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR85_15y_lt_t_ltequalto_20y() {
		return r85_15y_lt_t_ltequalto_20y;
	}
	public void setR85_15y_lt_t_ltequalto_20y(BigDecimal r85_15y_lt_t_ltequalto_20y) {
		this.r85_15y_lt_t_ltequalto_20y = r85_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR85_tl_20y() {
		return r85_tl_20y;
	}
	public void setR85_tl_20y(BigDecimal r85_tl_20y) {
		this.r85_tl_20y = r85_tl_20y;
	}
	public BigDecimal getR85_nonsensitive() {
		return r85_nonsensitive;
	}
	public void setR85_nonsensitive(BigDecimal r85_nonsensitive) {
		this.r85_nonsensitive = r85_nonsensitive;
	}
	public BigDecimal getR85_total_rsl() {
		return r85_total_rsl;
	}
	public void setR85_total_rsl(BigDecimal r85_total_rsl) {
		this.r85_total_rsl = r85_total_rsl;
	}
	public BigDecimal getR85_total() {
		return r85_total;
	}
	public void setR85_total(BigDecimal r85_total) {
		this.r85_total = r85_total;
	}
	public String getR86_product() {
		return r86_product;
	}
	public void setR86_product(String r86_product) {
		this.r86_product = r86_product;
	}
	public BigDecimal getR86_tequalon() {
		return r86_tequalon;
	}
	public void setR86_tequalon(BigDecimal r86_tequalon) {
		this.r86_tequalon = r86_tequalon;
	}
	public BigDecimal getR86_on_t_equalto_1m() {
		return r86_on_t_equalto_1m;
	}
	public void setR86_on_t_equalto_1m(BigDecimal r86_on_t_equalto_1m) {
		this.r86_on_t_equalto_1m = r86_on_t_equalto_1m;
	}
	public BigDecimal getR86_1m_t_equalto_3m() {
		return r86_1m_t_equalto_3m;
	}
	public void setR86_1m_t_equalto_3m(BigDecimal r86_1m_t_equalto_3m) {
		this.r86_1m_t_equalto_3m = r86_1m_t_equalto_3m;
	}
	public BigDecimal getR86_3m_t_equalto_6m() {
		return r86_3m_t_equalto_6m;
	}
	public void setR86_3m_t_equalto_6m(BigDecimal r86_3m_t_equalto_6m) {
		this.r86_3m_t_equalto_6m = r86_3m_t_equalto_6m;
	}
	public BigDecimal getR86_6m_t_equalto_9m() {
		return r86_6m_t_equalto_9m;
	}
	public void setR86_6m_t_equalto_9m(BigDecimal r86_6m_t_equalto_9m) {
		this.r86_6m_t_equalto_9m = r86_6m_t_equalto_9m;
	}
	public BigDecimal getR86_9m_t_equalto_1y() {
		return r86_9m_t_equalto_1y;
	}
	public void setR86_9m_t_equalto_1y(BigDecimal r86_9m_t_equalto_1y) {
		this.r86_9m_t_equalto_1y = r86_9m_t_equalto_1y;
	}
	public BigDecimal getR86_1y_t_equalto_1point5y() {
		return r86_1y_t_equalto_1point5y;
	}
	public void setR86_1y_t_equalto_1point5y(BigDecimal r86_1y_t_equalto_1point5y) {
		this.r86_1y_t_equalto_1point5y = r86_1y_t_equalto_1point5y;
	}
	public BigDecimal getR86_1point5y_t_equalto_2y() {
		return r86_1point5y_t_equalto_2y;
	}
	public void setR86_1point5y_t_equalto_2y(BigDecimal r86_1point5y_t_equalto_2y) {
		this.r86_1point5y_t_equalto_2y = r86_1point5y_t_equalto_2y;
	}
	public BigDecimal getR86_2y_t_equalto_3y() {
		return r86_2y_t_equalto_3y;
	}
	public void setR86_2y_t_equalto_3y(BigDecimal r86_2y_t_equalto_3y) {
		this.r86_2y_t_equalto_3y = r86_2y_t_equalto_3y;
	}
	public BigDecimal getR86_3y_t_equalto_4y() {
		return r86_3y_t_equalto_4y;
	}
	public void setR86_3y_t_equalto_4y(BigDecimal r86_3y_t_equalto_4y) {
		this.r86_3y_t_equalto_4y = r86_3y_t_equalto_4y;
	}
	public BigDecimal getR86_4y_lt_t_ltequalto_5y() {
		return r86_4y_lt_t_ltequalto_5y;
	}
	public void setR86_4y_lt_t_ltequalto_5y(BigDecimal r86_4y_lt_t_ltequalto_5y) {
		this.r86_4y_lt_t_ltequalto_5y = r86_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR86_5y_lt_t_ltequalto_6y() {
		return r86_5y_lt_t_ltequalto_6y;
	}
	public void setR86_5y_lt_t_ltequalto_6y(BigDecimal r86_5y_lt_t_ltequalto_6y) {
		this.r86_5y_lt_t_ltequalto_6y = r86_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR86_6y_lt_t_ltequalto_7y() {
		return r86_6y_lt_t_ltequalto_7y;
	}
	public void setR86_6y_lt_t_ltequalto_7y(BigDecimal r86_6y_lt_t_ltequalto_7y) {
		this.r86_6y_lt_t_ltequalto_7y = r86_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR86_7y_lt_t_ltequalto_8y() {
		return r86_7y_lt_t_ltequalto_8y;
	}
	public void setR86_7y_lt_t_ltequalto_8y(BigDecimal r86_7y_lt_t_ltequalto_8y) {
		this.r86_7y_lt_t_ltequalto_8y = r86_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR86_8y_lt_t_ltequalto_9y() {
		return r86_8y_lt_t_ltequalto_9y;
	}
	public void setR86_8y_lt_t_ltequalto_9y(BigDecimal r86_8y_lt_t_ltequalto_9y) {
		this.r86_8y_lt_t_ltequalto_9y = r86_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR86_9y_lt_t_ltequalto_10y() {
		return r86_9y_lt_t_ltequalto_10y;
	}
	public void setR86_9y_lt_t_ltequalto_10y(BigDecimal r86_9y_lt_t_ltequalto_10y) {
		this.r86_9y_lt_t_ltequalto_10y = r86_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR86_10y_lt_t_ltequalto_15y() {
		return r86_10y_lt_t_ltequalto_15y;
	}
	public void setR86_10y_lt_t_ltequalto_15y(BigDecimal r86_10y_lt_t_ltequalto_15y) {
		this.r86_10y_lt_t_ltequalto_15y = r86_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR86_15y_lt_t_ltequalto_20y() {
		return r86_15y_lt_t_ltequalto_20y;
	}
	public void setR86_15y_lt_t_ltequalto_20y(BigDecimal r86_15y_lt_t_ltequalto_20y) {
		this.r86_15y_lt_t_ltequalto_20y = r86_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR86_tl_20y() {
		return r86_tl_20y;
	}
	public void setR86_tl_20y(BigDecimal r86_tl_20y) {
		this.r86_tl_20y = r86_tl_20y;
	}
	public BigDecimal getR86_nonsensitive() {
		return r86_nonsensitive;
	}
	public void setR86_nonsensitive(BigDecimal r86_nonsensitive) {
		this.r86_nonsensitive = r86_nonsensitive;
	}
	public BigDecimal getR86_total_rsl() {
		return r86_total_rsl;
	}
	public void setR86_total_rsl(BigDecimal r86_total_rsl) {
		this.r86_total_rsl = r86_total_rsl;
	}
	public BigDecimal getR86_total() {
		return r86_total;
	}
	public void setR86_total(BigDecimal r86_total) {
		this.r86_total = r86_total;
	}
	public String getR87_product() {
		return r87_product;
	}
	public void setR87_product(String r87_product) {
		this.r87_product = r87_product;
	}
	public BigDecimal getR87_tequalon() {
		return r87_tequalon;
	}
	public void setR87_tequalon(BigDecimal r87_tequalon) {
		this.r87_tequalon = r87_tequalon;
	}
	public BigDecimal getR87_on_t_equalto_1m() {
		return r87_on_t_equalto_1m;
	}
	public void setR87_on_t_equalto_1m(BigDecimal r87_on_t_equalto_1m) {
		this.r87_on_t_equalto_1m = r87_on_t_equalto_1m;
	}
	public BigDecimal getR87_1m_t_equalto_3m() {
		return r87_1m_t_equalto_3m;
	}
	public void setR87_1m_t_equalto_3m(BigDecimal r87_1m_t_equalto_3m) {
		this.r87_1m_t_equalto_3m = r87_1m_t_equalto_3m;
	}
	public BigDecimal getR87_3m_t_equalto_6m() {
		return r87_3m_t_equalto_6m;
	}
	public void setR87_3m_t_equalto_6m(BigDecimal r87_3m_t_equalto_6m) {
		this.r87_3m_t_equalto_6m = r87_3m_t_equalto_6m;
	}
	public BigDecimal getR87_6m_t_equalto_9m() {
		return r87_6m_t_equalto_9m;
	}
	public void setR87_6m_t_equalto_9m(BigDecimal r87_6m_t_equalto_9m) {
		this.r87_6m_t_equalto_9m = r87_6m_t_equalto_9m;
	}
	public BigDecimal getR87_9m_t_equalto_1y() {
		return r87_9m_t_equalto_1y;
	}
	public void setR87_9m_t_equalto_1y(BigDecimal r87_9m_t_equalto_1y) {
		this.r87_9m_t_equalto_1y = r87_9m_t_equalto_1y;
	}
	public BigDecimal getR87_1y_t_equalto_1point5y() {
		return r87_1y_t_equalto_1point5y;
	}
	public void setR87_1y_t_equalto_1point5y(BigDecimal r87_1y_t_equalto_1point5y) {
		this.r87_1y_t_equalto_1point5y = r87_1y_t_equalto_1point5y;
	}
	public BigDecimal getR87_1point5y_t_equalto_2y() {
		return r87_1point5y_t_equalto_2y;
	}
	public void setR87_1point5y_t_equalto_2y(BigDecimal r87_1point5y_t_equalto_2y) {
		this.r87_1point5y_t_equalto_2y = r87_1point5y_t_equalto_2y;
	}
	public BigDecimal getR87_2y_t_equalto_3y() {
		return r87_2y_t_equalto_3y;
	}
	public void setR87_2y_t_equalto_3y(BigDecimal r87_2y_t_equalto_3y) {
		this.r87_2y_t_equalto_3y = r87_2y_t_equalto_3y;
	}
	public BigDecimal getR87_3y_t_equalto_4y() {
		return r87_3y_t_equalto_4y;
	}
	public void setR87_3y_t_equalto_4y(BigDecimal r87_3y_t_equalto_4y) {
		this.r87_3y_t_equalto_4y = r87_3y_t_equalto_4y;
	}
	public BigDecimal getR87_4y_lt_t_ltequalto_5y() {
		return r87_4y_lt_t_ltequalto_5y;
	}
	public void setR87_4y_lt_t_ltequalto_5y(BigDecimal r87_4y_lt_t_ltequalto_5y) {
		this.r87_4y_lt_t_ltequalto_5y = r87_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR87_5y_lt_t_ltequalto_6y() {
		return r87_5y_lt_t_ltequalto_6y;
	}
	public void setR87_5y_lt_t_ltequalto_6y(BigDecimal r87_5y_lt_t_ltequalto_6y) {
		this.r87_5y_lt_t_ltequalto_6y = r87_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR87_6y_lt_t_ltequalto_7y() {
		return r87_6y_lt_t_ltequalto_7y;
	}
	public void setR87_6y_lt_t_ltequalto_7y(BigDecimal r87_6y_lt_t_ltequalto_7y) {
		this.r87_6y_lt_t_ltequalto_7y = r87_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR87_7y_lt_t_ltequalto_8y() {
		return r87_7y_lt_t_ltequalto_8y;
	}
	public void setR87_7y_lt_t_ltequalto_8y(BigDecimal r87_7y_lt_t_ltequalto_8y) {
		this.r87_7y_lt_t_ltequalto_8y = r87_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR87_8y_lt_t_ltequalto_9y() {
		return r87_8y_lt_t_ltequalto_9y;
	}
	public void setR87_8y_lt_t_ltequalto_9y(BigDecimal r87_8y_lt_t_ltequalto_9y) {
		this.r87_8y_lt_t_ltequalto_9y = r87_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR87_9y_lt_t_ltequalto_10y() {
		return r87_9y_lt_t_ltequalto_10y;
	}
	public void setR87_9y_lt_t_ltequalto_10y(BigDecimal r87_9y_lt_t_ltequalto_10y) {
		this.r87_9y_lt_t_ltequalto_10y = r87_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR87_10y_lt_t_ltequalto_15y() {
		return r87_10y_lt_t_ltequalto_15y;
	}
	public void setR87_10y_lt_t_ltequalto_15y(BigDecimal r87_10y_lt_t_ltequalto_15y) {
		this.r87_10y_lt_t_ltequalto_15y = r87_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR87_15y_lt_t_ltequalto_20y() {
		return r87_15y_lt_t_ltequalto_20y;
	}
	public void setR87_15y_lt_t_ltequalto_20y(BigDecimal r87_15y_lt_t_ltequalto_20y) {
		this.r87_15y_lt_t_ltequalto_20y = r87_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR87_tl_20y() {
		return r87_tl_20y;
	}
	public void setR87_tl_20y(BigDecimal r87_tl_20y) {
		this.r87_tl_20y = r87_tl_20y;
	}
	public BigDecimal getR87_nonsensitive() {
		return r87_nonsensitive;
	}
	public void setR87_nonsensitive(BigDecimal r87_nonsensitive) {
		this.r87_nonsensitive = r87_nonsensitive;
	}
	public BigDecimal getR87_total_rsl() {
		return r87_total_rsl;
	}
	public void setR87_total_rsl(BigDecimal r87_total_rsl) {
		this.r87_total_rsl = r87_total_rsl;
	}
	public BigDecimal getR87_total() {
		return r87_total;
	}
	public void setR87_total(BigDecimal r87_total) {
		this.r87_total = r87_total;
	}
	public String getR88_product() {
		return r88_product;
	}
	public void setR88_product(String r88_product) {
		this.r88_product = r88_product;
	}
	public BigDecimal getR88_tequalon() {
		return r88_tequalon;
	}
	public void setR88_tequalon(BigDecimal r88_tequalon) {
		this.r88_tequalon = r88_tequalon;
	}
	public BigDecimal getR88_on_t_equalto_1m() {
		return r88_on_t_equalto_1m;
	}
	public void setR88_on_t_equalto_1m(BigDecimal r88_on_t_equalto_1m) {
		this.r88_on_t_equalto_1m = r88_on_t_equalto_1m;
	}
	public BigDecimal getR88_1m_t_equalto_3m() {
		return r88_1m_t_equalto_3m;
	}
	public void setR88_1m_t_equalto_3m(BigDecimal r88_1m_t_equalto_3m) {
		this.r88_1m_t_equalto_3m = r88_1m_t_equalto_3m;
	}
	public BigDecimal getR88_3m_t_equalto_6m() {
		return r88_3m_t_equalto_6m;
	}
	public void setR88_3m_t_equalto_6m(BigDecimal r88_3m_t_equalto_6m) {
		this.r88_3m_t_equalto_6m = r88_3m_t_equalto_6m;
	}
	public BigDecimal getR88_6m_t_equalto_9m() {
		return r88_6m_t_equalto_9m;
	}
	public void setR88_6m_t_equalto_9m(BigDecimal r88_6m_t_equalto_9m) {
		this.r88_6m_t_equalto_9m = r88_6m_t_equalto_9m;
	}
	public BigDecimal getR88_9m_t_equalto_1y() {
		return r88_9m_t_equalto_1y;
	}
	public void setR88_9m_t_equalto_1y(BigDecimal r88_9m_t_equalto_1y) {
		this.r88_9m_t_equalto_1y = r88_9m_t_equalto_1y;
	}
	public BigDecimal getR88_1y_t_equalto_1point5y() {
		return r88_1y_t_equalto_1point5y;
	}
	public void setR88_1y_t_equalto_1point5y(BigDecimal r88_1y_t_equalto_1point5y) {
		this.r88_1y_t_equalto_1point5y = r88_1y_t_equalto_1point5y;
	}
	public BigDecimal getR88_1point5y_t_equalto_2y() {
		return r88_1point5y_t_equalto_2y;
	}
	public void setR88_1point5y_t_equalto_2y(BigDecimal r88_1point5y_t_equalto_2y) {
		this.r88_1point5y_t_equalto_2y = r88_1point5y_t_equalto_2y;
	}
	public BigDecimal getR88_2y_t_equalto_3y() {
		return r88_2y_t_equalto_3y;
	}
	public void setR88_2y_t_equalto_3y(BigDecimal r88_2y_t_equalto_3y) {
		this.r88_2y_t_equalto_3y = r88_2y_t_equalto_3y;
	}
	public BigDecimal getR88_3y_t_equalto_4y() {
		return r88_3y_t_equalto_4y;
	}
	public void setR88_3y_t_equalto_4y(BigDecimal r88_3y_t_equalto_4y) {
		this.r88_3y_t_equalto_4y = r88_3y_t_equalto_4y;
	}
	public BigDecimal getR88_4y_lt_t_ltequalto_5y() {
		return r88_4y_lt_t_ltequalto_5y;
	}
	public void setR88_4y_lt_t_ltequalto_5y(BigDecimal r88_4y_lt_t_ltequalto_5y) {
		this.r88_4y_lt_t_ltequalto_5y = r88_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR88_5y_lt_t_ltequalto_6y() {
		return r88_5y_lt_t_ltequalto_6y;
	}
	public void setR88_5y_lt_t_ltequalto_6y(BigDecimal r88_5y_lt_t_ltequalto_6y) {
		this.r88_5y_lt_t_ltequalto_6y = r88_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR88_6y_lt_t_ltequalto_7y() {
		return r88_6y_lt_t_ltequalto_7y;
	}
	public void setR88_6y_lt_t_ltequalto_7y(BigDecimal r88_6y_lt_t_ltequalto_7y) {
		this.r88_6y_lt_t_ltequalto_7y = r88_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR88_7y_lt_t_ltequalto_8y() {
		return r88_7y_lt_t_ltequalto_8y;
	}
	public void setR88_7y_lt_t_ltequalto_8y(BigDecimal r88_7y_lt_t_ltequalto_8y) {
		this.r88_7y_lt_t_ltequalto_8y = r88_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR88_8y_lt_t_ltequalto_9y() {
		return r88_8y_lt_t_ltequalto_9y;
	}
	public void setR88_8y_lt_t_ltequalto_9y(BigDecimal r88_8y_lt_t_ltequalto_9y) {
		this.r88_8y_lt_t_ltequalto_9y = r88_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR88_9y_lt_t_ltequalto_10y() {
		return r88_9y_lt_t_ltequalto_10y;
	}
	public void setR88_9y_lt_t_ltequalto_10y(BigDecimal r88_9y_lt_t_ltequalto_10y) {
		this.r88_9y_lt_t_ltequalto_10y = r88_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR88_10y_lt_t_ltequalto_15y() {
		return r88_10y_lt_t_ltequalto_15y;
	}
	public void setR88_10y_lt_t_ltequalto_15y(BigDecimal r88_10y_lt_t_ltequalto_15y) {
		this.r88_10y_lt_t_ltequalto_15y = r88_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR88_15y_lt_t_ltequalto_20y() {
		return r88_15y_lt_t_ltequalto_20y;
	}
	public void setR88_15y_lt_t_ltequalto_20y(BigDecimal r88_15y_lt_t_ltequalto_20y) {
		this.r88_15y_lt_t_ltequalto_20y = r88_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR88_tl_20y() {
		return r88_tl_20y;
	}
	public void setR88_tl_20y(BigDecimal r88_tl_20y) {
		this.r88_tl_20y = r88_tl_20y;
	}
	public BigDecimal getR88_nonsensitive() {
		return r88_nonsensitive;
	}
	public void setR88_nonsensitive(BigDecimal r88_nonsensitive) {
		this.r88_nonsensitive = r88_nonsensitive;
	}
	public BigDecimal getR88_total_rsl() {
		return r88_total_rsl;
	}
	public void setR88_total_rsl(BigDecimal r88_total_rsl) {
		this.r88_total_rsl = r88_total_rsl;
	}
	public BigDecimal getR88_total() {
		return r88_total;
	}
	public void setR88_total(BigDecimal r88_total) {
		this.r88_total = r88_total;
	}
	public String getR89_product() {
		return r89_product;
	}
	public void setR89_product(String r89_product) {
		this.r89_product = r89_product;
	}
	public BigDecimal getR89_tequalon() {
		return r89_tequalon;
	}
	public void setR89_tequalon(BigDecimal r89_tequalon) {
		this.r89_tequalon = r89_tequalon;
	}
	public BigDecimal getR89_on_t_equalto_1m() {
		return r89_on_t_equalto_1m;
	}
	public void setR89_on_t_equalto_1m(BigDecimal r89_on_t_equalto_1m) {
		this.r89_on_t_equalto_1m = r89_on_t_equalto_1m;
	}
	public BigDecimal getR89_1m_t_equalto_3m() {
		return r89_1m_t_equalto_3m;
	}
	public void setR89_1m_t_equalto_3m(BigDecimal r89_1m_t_equalto_3m) {
		this.r89_1m_t_equalto_3m = r89_1m_t_equalto_3m;
	}
	public BigDecimal getR89_3m_t_equalto_6m() {
		return r89_3m_t_equalto_6m;
	}
	public void setR89_3m_t_equalto_6m(BigDecimal r89_3m_t_equalto_6m) {
		this.r89_3m_t_equalto_6m = r89_3m_t_equalto_6m;
	}
	public BigDecimal getR89_6m_t_equalto_9m() {
		return r89_6m_t_equalto_9m;
	}
	public void setR89_6m_t_equalto_9m(BigDecimal r89_6m_t_equalto_9m) {
		this.r89_6m_t_equalto_9m = r89_6m_t_equalto_9m;
	}
	public BigDecimal getR89_9m_t_equalto_1y() {
		return r89_9m_t_equalto_1y;
	}
	public void setR89_9m_t_equalto_1y(BigDecimal r89_9m_t_equalto_1y) {
		this.r89_9m_t_equalto_1y = r89_9m_t_equalto_1y;
	}
	public BigDecimal getR89_1y_t_equalto_1point5y() {
		return r89_1y_t_equalto_1point5y;
	}
	public void setR89_1y_t_equalto_1point5y(BigDecimal r89_1y_t_equalto_1point5y) {
		this.r89_1y_t_equalto_1point5y = r89_1y_t_equalto_1point5y;
	}
	public BigDecimal getR89_1point5y_t_equalto_2y() {
		return r89_1point5y_t_equalto_2y;
	}
	public void setR89_1point5y_t_equalto_2y(BigDecimal r89_1point5y_t_equalto_2y) {
		this.r89_1point5y_t_equalto_2y = r89_1point5y_t_equalto_2y;
	}
	public BigDecimal getR89_2y_t_equalto_3y() {
		return r89_2y_t_equalto_3y;
	}
	public void setR89_2y_t_equalto_3y(BigDecimal r89_2y_t_equalto_3y) {
		this.r89_2y_t_equalto_3y = r89_2y_t_equalto_3y;
	}
	public BigDecimal getR89_3y_t_equalto_4y() {
		return r89_3y_t_equalto_4y;
	}
	public void setR89_3y_t_equalto_4y(BigDecimal r89_3y_t_equalto_4y) {
		this.r89_3y_t_equalto_4y = r89_3y_t_equalto_4y;
	}
	public BigDecimal getR89_4y_lt_t_ltequalto_5y() {
		return r89_4y_lt_t_ltequalto_5y;
	}
	public void setR89_4y_lt_t_ltequalto_5y(BigDecimal r89_4y_lt_t_ltequalto_5y) {
		this.r89_4y_lt_t_ltequalto_5y = r89_4y_lt_t_ltequalto_5y;
	}
	public BigDecimal getR89_5y_lt_t_ltequalto_6y() {
		return r89_5y_lt_t_ltequalto_6y;
	}
	public void setR89_5y_lt_t_ltequalto_6y(BigDecimal r89_5y_lt_t_ltequalto_6y) {
		this.r89_5y_lt_t_ltequalto_6y = r89_5y_lt_t_ltequalto_6y;
	}
	public BigDecimal getR89_6y_lt_t_ltequalto_7y() {
		return r89_6y_lt_t_ltequalto_7y;
	}
	public void setR89_6y_lt_t_ltequalto_7y(BigDecimal r89_6y_lt_t_ltequalto_7y) {
		this.r89_6y_lt_t_ltequalto_7y = r89_6y_lt_t_ltequalto_7y;
	}
	public BigDecimal getR89_7y_lt_t_ltequalto_8y() {
		return r89_7y_lt_t_ltequalto_8y;
	}
	public void setR89_7y_lt_t_ltequalto_8y(BigDecimal r89_7y_lt_t_ltequalto_8y) {
		this.r89_7y_lt_t_ltequalto_8y = r89_7y_lt_t_ltequalto_8y;
	}
	public BigDecimal getR89_8y_lt_t_ltequalto_9y() {
		return r89_8y_lt_t_ltequalto_9y;
	}
	public void setR89_8y_lt_t_ltequalto_9y(BigDecimal r89_8y_lt_t_ltequalto_9y) {
		this.r89_8y_lt_t_ltequalto_9y = r89_8y_lt_t_ltequalto_9y;
	}
	public BigDecimal getR89_9y_lt_t_ltequalto_10y() {
		return r89_9y_lt_t_ltequalto_10y;
	}
	public void setR89_9y_lt_t_ltequalto_10y(BigDecimal r89_9y_lt_t_ltequalto_10y) {
		this.r89_9y_lt_t_ltequalto_10y = r89_9y_lt_t_ltequalto_10y;
	}
	public BigDecimal getR89_10y_lt_t_ltequalto_15y() {
		return r89_10y_lt_t_ltequalto_15y;
	}
	public void setR89_10y_lt_t_ltequalto_15y(BigDecimal r89_10y_lt_t_ltequalto_15y) {
		this.r89_10y_lt_t_ltequalto_15y = r89_10y_lt_t_ltequalto_15y;
	}
	public BigDecimal getR89_15y_lt_t_ltequalto_20y() {
		return r89_15y_lt_t_ltequalto_20y;
	}
	public void setR89_15y_lt_t_ltequalto_20y(BigDecimal r89_15y_lt_t_ltequalto_20y) {
		this.r89_15y_lt_t_ltequalto_20y = r89_15y_lt_t_ltequalto_20y;
	}
	public BigDecimal getR89_tl_20y() {
		return r89_tl_20y;
	}
	public void setR89_tl_20y(BigDecimal r89_tl_20y) {
		this.r89_tl_20y = r89_tl_20y;
	}
	public BigDecimal getR89_nonsensitive() {
		return r89_nonsensitive;
	}
	public void setR89_nonsensitive(BigDecimal r89_nonsensitive) {
		this.r89_nonsensitive = r89_nonsensitive;
	}
	public BigDecimal getR89_total_rsl() {
		return r89_total_rsl;
	}
	public void setR89_total_rsl(BigDecimal r89_total_rsl) {
		this.r89_total_rsl = r89_total_rsl;
	}
	public BigDecimal getR89_total() {
		return r89_total;
	}
	public void setR89_total(BigDecimal r89_total) {
		this.r89_total = r89_total;
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
	public Banking_Book2_USD() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


}
