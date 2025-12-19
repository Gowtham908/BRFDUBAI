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
@Table(name="BRF95_NONFUND_BASED_TABLE2")
public class BRF95_NONFUND_BASED_TABLE2 {
	private BigDecimal	r100_bnk_0_total_0_percen;
	private BigDecimal	r100_bnk_0_total_20_percen;
	private BigDecimal	r100_bnk_0_total_50_percen;
	private BigDecimal	r100_bnk_0_total_100_percen;
	private BigDecimal	r100_bnk_0_ccf_non_fund_0_percen;
	private BigDecimal	r100_bnk_0_ccf_non_fund_20_percen;
	private BigDecimal	r100_bnk_0_ccf_non_fund_50_percen;
	private BigDecimal	r100_bnk_0_ccf_non_fund_100_percen;
	private BigDecimal	r100_bnk_0_ccf_fund_0_percen;
	private BigDecimal	r100_bnk_0_ccf_fund_20_percen;
	private BigDecimal	r100_bnk_0_ccf_fund_50_percen;
	private BigDecimal	r100_bnk_0_ccf_fund_100_percen;
	private BigDecimal	r100_bnk_0_ccf_non_fund_und_0_percen;
	private BigDecimal	r100_bnk_0_ccf_non_fund_und_20_percen;
	private BigDecimal	r100_bnk_0_ccf_non_fund_und_50_percen;
	private BigDecimal	r100_bnk_0_ccf_non_fund_und_100_percen;
	private BigDecimal	r101_bnk_20_total_0_percen;
	private BigDecimal	r101_bnk_20_total_20_percen;
	private BigDecimal	r101_bnk_20_total_50_percen;
	private BigDecimal	r101_bnk_20_total_100_percen;
	private BigDecimal	r101_bnk_20_ccf_non_fund_0_percen;
	private BigDecimal	r101_bnk_20_ccf_non_fund_20_percen;
	private BigDecimal	r101_bnk_20_ccf_non_fund_50_percen;
	private BigDecimal	r101_bnk_20_ccf_non_fund_100_percen;
	private BigDecimal	r101_bnk_20_ccf_fund_0_percen;
	private BigDecimal	r101_bnk_20_ccf_fund_20_percen;
	private BigDecimal	r101_bnk_20_ccf_fund_50_percen;
	private BigDecimal	r101_bnk_20_ccf_fund_100_percen;
	private BigDecimal	r101_bnk_20_ccf_non_fund_und_0_percen;
	private BigDecimal	r101_bnk_20_ccf_non_fund_und_20_percen;
	private BigDecimal	r101_bnk_20_ccf_non_fund_und_50_percen;
	private BigDecimal	r101_bnk_20_ccf_non_fund_und_100_percen;
	private BigDecimal	r102_bnk_50_total_0_percen;
	private BigDecimal	r102_bnk_50_total_20_percen;
	private BigDecimal	r102_bnk_50_total_50_percen;
	private BigDecimal	r102_bnk_50_total_100_percen;
	private BigDecimal	r102_bnk_50_ccf_non_fund_0_percen;
	private BigDecimal	r102_bnk_50_ccf_non_fund_20_percen;
	private BigDecimal	r102_bnk_50_ccf_non_fund_50_percen;
	private BigDecimal	r102_bnk_50_ccf_non_fund_100_percen;
	private BigDecimal	r102_bnk_50_ccf_fund_0_percen;
	private BigDecimal	r102_bnk_50_ccf_fund_20_percen;
	private BigDecimal	r102_bnk_50_ccf_fund_50_percen;
	private BigDecimal	r102_bnk_50_ccf_fund_100_percen;
	private BigDecimal	r102_bnk_50_ccf_non_fund_und_0_percen;
	private BigDecimal	r102_bnk_50_ccf_non_fund_und_20_percen;
	private BigDecimal	r102_bnk_50_ccf_non_fund_und_50_percen;
	private BigDecimal	r102_bnk_50_ccf_non_fund_und_100_percen;
	private BigDecimal	r103_bnk_100_total_0_percen;
	private BigDecimal	r103_bnk_100_total_20_percen;
	private BigDecimal	r103_bnk_100_total_50_percen;
	private BigDecimal	r103_bnk_100_total_100_percen;
	private BigDecimal	r103_bnk_100_ccf_non_fund_0_percen;
	private BigDecimal	r103_bnk_100_ccf_non_fund_20_percen;
	private BigDecimal	r103_bnk_100_ccf_non_fund_50_percen;
	private BigDecimal	r103_bnk_100_ccf_non_fund_100_percen;
	private BigDecimal	r103_bnk_100_ccf_fund_0_percen;
	private BigDecimal	r103_bnk_100_ccf_fund_20_percen;
	private BigDecimal	r103_bnk_100_ccf_fund_50_percen;
	private BigDecimal	r103_bnk_100_ccf_fund_100_percen;
	private BigDecimal	r103_bnk_100_ccf_non_fund_und_0_percen;
	private BigDecimal	r103_bnk_100_ccf_non_fund_und_20_percen;
	private BigDecimal	r103_bnk_100_ccf_non_fund_und_50_percen;
	private BigDecimal	r103_bnk_100_ccf_non_fund_und_100_percen;
	private BigDecimal	r104_bnk_150_total_0_percen;
	private BigDecimal	r104_bnk_150_total_20_percen;
	private BigDecimal	r104_bnk_150_total_50_percen;
	private BigDecimal	r104_bnk_150_total_100_percen;
	private BigDecimal	r104_bnk_150_ccf_non_fund_0_percen;
	private BigDecimal	r104_bnk_150_ccf_non_fund_20_percen;
	private BigDecimal	r104_bnk_150_ccf_non_fund_50_percen;
	private BigDecimal	r104_bnk_150_ccf_non_fund_100_percen;
	private BigDecimal	r104_bnk_150_ccf_fund_0_percen;
	private BigDecimal	r104_bnk_150_ccf_fund_20_percen;
	private BigDecimal	r104_bnk_150_ccf_fund_50_percen;
	private BigDecimal	r104_bnk_150_ccf_fund_100_percen;
	private BigDecimal	r104_bnk_150_ccf_non_fund_und_0_percen;
	private BigDecimal	r104_bnk_150_ccf_non_fund_und_20_percen;
	private BigDecimal	r104_bnk_150_ccf_non_fund_und_50_percen;
	private BigDecimal	r104_bnk_150_ccf_non_fund_und_100_percen;
	private BigDecimal	r105_cbs_0_total_0_percen;
	private BigDecimal	r105_cbs_0_total_20_percen;
	private BigDecimal	r105_cbs_0_total_50_percen;
	private BigDecimal	r105_cbs_0_total_100_percen;
	private BigDecimal	r105_cbs_0_ccf_non_fund_0_percen;
	private BigDecimal	r105_cbs_0_ccf_non_fund_20_percen;
	private BigDecimal	r105_cbs_0_ccf_non_fund_50_percen;
	private BigDecimal	r105_cbs_0_ccf_non_fund_100_percen;
	private BigDecimal	r105_cbs_0_ccf_fund_0_percen;
	private BigDecimal	r105_cbs_0_ccf_fund_20_percen;
	private BigDecimal	r105_cbs_0_ccf_fund_50_percen;
	private BigDecimal	r105_cbs_0_ccf_fund_100_percen;
	private BigDecimal	r105_cbs_0_ccf_non_fund_und_0_percen;
	private BigDecimal	r105_cbs_0_ccf_non_fund_und_20_percen;
	private BigDecimal	r105_cbs_0_ccf_non_fund_und_50_percen;
	private BigDecimal	r105_cbs_0_ccf_non_fund_und_100_percen;
	private BigDecimal	r106_cbs_20_total_0_percen;
	private BigDecimal	r106_cbs_20_total_20_percen;
	private BigDecimal	r106_cbs_20_total_50_percen;
	private BigDecimal	r106_cbs_20_total_100_percen;
	private BigDecimal	r106_cbs_20_ccf_non_fund_0_percen;
	private BigDecimal	r106_cbs_20_ccf_non_fund_20_percen;
	private BigDecimal	r106_cbs_20_ccf_non_fund_50_percen;
	private BigDecimal	r106_cbs_20_ccf_non_fund_100_percen;
	private BigDecimal	r106_cbs_20_ccf_fund_0_percen;
	private BigDecimal	r106_cbs_20_ccf_fund_20_percen;
	private BigDecimal	r106_cbs_20_ccf_fund_50_percen;
	private BigDecimal	r106_cbs_20_ccf_fund_100_percen;
	private BigDecimal	r106_cbs_20_ccf_non_fund_und_0_percen;
	private BigDecimal	r106_cbs_20_ccf_non_fund_und_20_percen;
	private BigDecimal	r106_cbs_20_ccf_non_fund_und_50_percen;
	private BigDecimal	r106_cbs_20_ccf_non_fund_und_100_percen;
	private BigDecimal	r107_cbs_20_total_0_percen;
	private BigDecimal	r107_cbs_20_total_20_percen;
	private BigDecimal	r107_cbs_20_total_50_percen;
	private BigDecimal	r107_cbs_20_total_100_percen;
	private BigDecimal	r107_cbs_20_ccf_non_fund_0_percen;
	private BigDecimal	r107_cbs_20_ccf_non_fund_20_percen;
	private BigDecimal	r107_cbs_20_ccf_non_fund_50_percen;
	private BigDecimal	r107_cbs_20_ccf_non_fund_100_percen;
	private BigDecimal	r107_cbs_20_ccf_fund_0_percen;
	private BigDecimal	r107_cbs_20_ccf_fund_20_percen;
	private BigDecimal	r107_cbs_20_ccf_fund_50_percen;
	private BigDecimal	r107_cbs_20_ccf_fund_100_percen;
	private BigDecimal	r107_cbs_20_ccf_non_fund_und_0_percen;
	private BigDecimal	r107_cbs_20_ccf_non_fund_und_20_percen;
	private BigDecimal	r107_cbs_20_ccf_non_fund_und_50_percen;
	private BigDecimal	r107_cbs_20_ccf_non_fund_und_100_percen;
	private BigDecimal	r108_cbs_0_total_0_percen;
	private BigDecimal	r108_cbs_0_total_20_percen;
	private BigDecimal	r108_cbs_0_total_50_percen;
	private BigDecimal	r108_cbs_0_total_100_percen;
	private BigDecimal	r108_cbs_0_ccf_non_fund_0_percen;
	private BigDecimal	r108_cbs_0_ccf_non_fund_20_percen;
	private BigDecimal	r108_cbs_0_ccf_non_fund_50_percen;
	private BigDecimal	r108_cbs_0_ccf_non_fund_100_percen;
	private BigDecimal	r108_cbs_0_ccf_fund_0_percen;
	private BigDecimal	r108_cbs_0_ccf_fund_20_percen;
	private BigDecimal	r108_cbs_0_ccf_fund_50_percen;
	private BigDecimal	r108_cbs_0_ccf_fund_100_percen;
	private BigDecimal	r108_cbs_0_ccf_non_fund_und_0_percen;
	private BigDecimal	r108_cbs_0_ccf_non_fund_und_20_percen;
	private BigDecimal	r108_cbs_0_ccf_non_fund_und_50_percen;
	private BigDecimal	r108_cbs_0_ccf_non_fund_und_100_percen;
	private BigDecimal	r109_cbs_20_total_0_percen;
	private BigDecimal	r109_cbs_20_total_20_percen;
	private BigDecimal	r109_cbs_20_total_50_percen;
	private BigDecimal	r109_cbs_20_total_100_percen;
	private BigDecimal	r109_cbs_20_ccf_non_fund_0_percen;
	private BigDecimal	r109_cbs_20_ccf_non_fund_20_percen;
	private BigDecimal	r109_cbs_20_ccf_non_fund_50_percen;
	private BigDecimal	r109_cbs_20_ccf_non_fund_100_percen;
	private BigDecimal	r109_cbs_20_ccf_fund_0_percen;
	private BigDecimal	r109_cbs_20_ccf_fund_20_percen;
	private BigDecimal	r109_cbs_20_ccf_fund_50_percen;
	private BigDecimal	r109_cbs_20_ccf_fund_100_percen;
	private BigDecimal	r109_cbs_20_ccf_non_fund_und_0_percen;
	private BigDecimal	r109_cbs_20_ccf_non_fund_und_20_percen;
	private BigDecimal	r109_cbs_20_ccf_non_fund_und_50_percen;
	private BigDecimal	r109_cbs_20_ccf_non_fund_und_100_percen;
	private BigDecimal	r110_cbs_50_total_0_percen;
	private BigDecimal	r110_cbs_50_total_20_percen;
	private BigDecimal	r110_cbs_50_total_50_percen;
	private BigDecimal	r110_cbs_50_total_100_percen;
	private BigDecimal	r110_cbs_50_ccf_non_fund_0_percen;
	private BigDecimal	r110_cbs_50_ccf_non_fund_20_percen;
	private BigDecimal	r110_cbs_50_ccf_non_fund_50_percen;
	private BigDecimal	r110_cbs_50_ccf_non_fund_100_percen;
	private BigDecimal	r110_cbs_50_ccf_fund_0_percen;
	private BigDecimal	r110_cbs_50_ccf_fund_20_percen;
	private BigDecimal	r110_cbs_50_ccf_fund_50_percen;
	private BigDecimal	r110_cbs_50_ccf_fund_100_percen;
	private BigDecimal	r110_cbs_50_ccf_non_fund_und_0_percen;
	private BigDecimal	r110_cbs_50_ccf_non_fund_und_20_percen;
	private BigDecimal	r110_cbs_50_ccf_non_fund_und_50_percen;
	private BigDecimal	r110_cbs_50_ccf_non_fund_und_100_percen;
	private BigDecimal	r111_cbs_100_total_0_percen;
	private BigDecimal	r111_cbs_100_total_20_percen;
	private BigDecimal	r111_cbs_100_total_50_percen;
	private BigDecimal	r111_cbs_100_total_100_percen;
	private BigDecimal	r111_cbs_100_ccf_non_fund_0_percen;
	private BigDecimal	r111_cbs_100_ccf_non_fund_20_percen;
	private BigDecimal	r111_cbs_100_ccf_non_fund_50_percen;
	private BigDecimal	r111_cbs_100_ccf_non_fund_100_percen;
	private BigDecimal	r111_cbs_100_ccf_fund_0_percen;
	private BigDecimal	r111_cbs_100_ccf_fund_20_percen;
	private BigDecimal	r111_cbs_100_ccf_fund_50_percen;
	private BigDecimal	r111_cbs_100_ccf_fund_100_percen;
	private BigDecimal	r111_cbs_100_ccf_non_fund_und_0_percen;
	private BigDecimal	r111_cbs_100_ccf_non_fund_und_20_percen;
	private BigDecimal	r111_cbs_100_ccf_non_fund_und_50_percen;
	private BigDecimal	r111_cbs_100_ccf_non_fund_und_100_percen;
	private BigDecimal	r112_cbs_150_total_0_percen;
	private BigDecimal	r112_cbs_150_total_20_percen;
	private BigDecimal	r112_cbs_150_total_50_percen;
	private BigDecimal	r112_cbs_150_total_100_percen;
	private BigDecimal	r112_cbs_150_ccf_non_fund_0_percen;
	private BigDecimal	r112_cbs_150_ccf_non_fund_20_percen;
	private BigDecimal	r112_cbs_150_ccf_non_fund_50_percen;
	private BigDecimal	r112_cbs_150_ccf_non_fund_100_percen;
	private BigDecimal	r112_cbs_150_ccf_fund_0_percen;
	private BigDecimal	r112_cbs_150_ccf_fund_20_percen;
	private BigDecimal	r112_cbs_150_ccf_fund_50_percen;
	private BigDecimal	r112_cbs_150_ccf_fund_100_percen;
	private BigDecimal	r112_cbs_150_ccf_non_fund_und_0_percen;
	private BigDecimal	r112_cbs_150_ccf_non_fund_und_20_percen;
	private BigDecimal	r112_cbs_150_ccf_non_fund_und_50_percen;
	private BigDecimal	r112_cbs_150_ccf_non_fund_und_100_percen;
	private BigDecimal	r113_cre_0_total_0_percen;
	private BigDecimal	r113_cre_0_total_20_percen;
	private BigDecimal	r113_cre_0_total_50_percen;
	private BigDecimal	r113_cre_0_total_100_percen;
	private BigDecimal	r113_cre_0_ccf_non_fund_0_percen;
	private BigDecimal	r113_cre_0_ccf_non_fund_20_percen;
	private BigDecimal	r113_cre_0_ccf_non_fund_50_percen;
	private BigDecimal	r113_cre_0_ccf_non_fund_100_percen;
	private BigDecimal	r113_cre_0_ccf_fund_0_percen;
	private BigDecimal	r113_cre_0_ccf_fund_20_percen;
	private BigDecimal	r113_cre_0_ccf_fund_50_percen;
	private BigDecimal	r113_cre_0_ccf_fund_100_percen;
	private BigDecimal	r113_cre_0_ccf_non_fund_und_0_percen;
	private BigDecimal	r113_cre_0_ccf_non_fund_und_20_percen;
	private BigDecimal	r113_cre_0_ccf_non_fund_und_50_percen;
	private BigDecimal	r113_cre_0_ccf_non_fund_und_100_percen;
	private BigDecimal	r114_cre_20_total_0_percen;
	private BigDecimal	r114_cre_20_total_20_percen;
	private BigDecimal	r114_cre_20_total_50_percen;
	private BigDecimal	r114_cre_20_total_100_percen;
	private BigDecimal	r114_cre_20_ccf_non_fund_0_percen;
	private BigDecimal	r114_cre_20_ccf_non_fund_20_percen;
	private BigDecimal	r114_cre_20_ccf_non_fund_50_percen;
	private BigDecimal	r114_cre_20_ccf_non_fund_100_percen;
	private BigDecimal	r114_cre_20_ccf_fund_0_percen;
	private BigDecimal	r114_cre_20_ccf_fund_20_percen;
	private BigDecimal	r114_cre_20_ccf_fund_50_percen;
	private BigDecimal	r114_cre_20_ccf_fund_100_percen;
	private BigDecimal	r114_cre_20_ccf_non_fund_und_0_percen;
	private BigDecimal	r114_cre_20_ccf_non_fund_und_20_percen;
	private BigDecimal	r114_cre_20_ccf_non_fund_und_50_percen;
	private BigDecimal	r114_cre_20_ccf_non_fund_und_100_percen;
	private BigDecimal	r115_cre_50_total_0_percen;
	private BigDecimal	r115_cre_50_total_20_percen;
	private BigDecimal	r115_cre_50_total_50_percen;
	private BigDecimal	r115_cre_50_total_100_percen;
	private BigDecimal	r115_cre_50_ccf_non_fund_0_percen;
	private BigDecimal	r115_cre_50_ccf_non_fund_20_percen;
	private BigDecimal	r115_cre_50_ccf_non_fund_50_percen;
	private BigDecimal	r115_cre_50_ccf_non_fund_100_percen;
	private BigDecimal	r115_cre_50_ccf_fund_0_percen;
	private BigDecimal	r115_cre_50_ccf_fund_20_percen;
	private BigDecimal	r115_cre_50_ccf_fund_50_percen;
	private BigDecimal	r115_cre_50_ccf_fund_100_percen;
	private BigDecimal	r115_cre_50_ccf_non_fund_und_0_percen;
	private BigDecimal	r115_cre_50_ccf_non_fund_und_20_percen;
	private BigDecimal	r115_cre_50_ccf_non_fund_und_50_percen;
	private BigDecimal	r115_cre_50_ccf_non_fund_und_100_percen;
	private BigDecimal	r116_cre_100_total_0_percen;
	private BigDecimal	r116_cre_100_total_20_percen;
	private BigDecimal	r116_cre_100_total_50_percen;
	private BigDecimal	r116_cre_100_total_100_percen;
	private BigDecimal	r116_cre_100_ccf_non_fund_0_percen;
	private BigDecimal	r116_cre_100_ccf_non_fund_20_percen;
	private BigDecimal	r116_cre_100_ccf_non_fund_50_percen;
	private BigDecimal	r116_cre_100_ccf_non_fund_100_percen;
	private BigDecimal	r116_cre_100_ccf_fund_0_percen;
	private BigDecimal	r116_cre_100_ccf_fund_20_percen;
	private BigDecimal	r116_cre_100_ccf_fund_50_percen;
	private BigDecimal	r116_cre_100_ccf_fund_100_percen;
	private BigDecimal	r116_cre_100_ccf_non_fund_und_0_percen;
	private BigDecimal	r116_cre_100_ccf_non_fund_und_20_percen;
	private BigDecimal	r116_cre_100_ccf_non_fund_und_50_percen;
	private BigDecimal	r116_cre_100_ccf_non_fund_und_100_percen;
	private BigDecimal	r117_cre_150_total_0_percen;
	private BigDecimal	r117_cre_150_total_20_percen;
	private BigDecimal	r117_cre_150_total_50_percen;
	private BigDecimal	r117_cre_150_total_100_percen;
	private BigDecimal	r117_cre_150_ccf_non_fund_0_percen;
	private BigDecimal	r117_cre_150_ccf_non_fund_20_percen;
	private BigDecimal	r117_cre_150_ccf_non_fund_50_percen;
	private BigDecimal	r117_cre_150_ccf_non_fund_100_percen;
	private BigDecimal	r117_cre_150_ccf_fund_0_percen;
	private BigDecimal	r117_cre_150_ccf_fund_20_percen;
	private BigDecimal	r117_cre_150_ccf_fund_50_percen;
	private BigDecimal	r117_cre_150_ccf_fund_100_percen;
	private BigDecimal	r117_cre_150_ccf_non_fund_und_0_percen;
	private BigDecimal	r117_cre_150_ccf_non_fund_und_20_percen;
	private BigDecimal	r117_cre_150_ccf_non_fund_und_50_percen;
	private BigDecimal	r117_cre_150_ccf_non_fund_und_100_percen;
	private BigDecimal	r118_crt_0_total_0_percen;
	private BigDecimal	r118_crt_0_total_20_percen;
	private BigDecimal	r118_crt_0_total_50_percen;
	private BigDecimal	r118_crt_0_total_100_percen;
	private BigDecimal	r118_crt_0_ccf_non_fund_0_percen;
	private BigDecimal	r118_crt_0_ccf_non_fund_20_percen;
	private BigDecimal	r118_crt_0_ccf_non_fund_50_percen;
	private BigDecimal	r118_crt_0_ccf_non_fund_100_percen;
	private BigDecimal	r118_crt_0_ccf_fund_0_percen;
	private BigDecimal	r118_crt_0_ccf_fund_20_percen;
	private BigDecimal	r118_crt_0_ccf_fund_50_percen;
	private BigDecimal	r118_crt_0_ccf_fund_100_percen;
	private BigDecimal	r118_crt_0_ccf_non_fund_und_0_percen;
	private BigDecimal	r118_crt_0_ccf_non_fund_und_20_percen;
	private BigDecimal	r118_crt_0_ccf_non_fund_und_50_percen;
	private BigDecimal	r118_crt_0_ccf_non_fund_und_100_percen;
	private BigDecimal	r119_crt_20_total_0_percen;
	private BigDecimal	r119_crt_20_total_20_percen;
	private BigDecimal	r119_crt_20_total_50_percen;
	private BigDecimal	r119_crt_20_total_100_percen;
	private BigDecimal	r119_crt_20_ccf_non_fund_0_percen;
	private BigDecimal	r119_crt_20_ccf_non_fund_20_percen;
	private BigDecimal	r119_crt_20_ccf_non_fund_50_percen;
	private BigDecimal	r119_crt_20_ccf_non_fund_100_percen;
	private BigDecimal	r119_crt_20_ccf_fund_0_percen;
	private BigDecimal	r119_crt_20_ccf_fund_20_percen;
	private BigDecimal	r119_crt_20_ccf_fund_50_percen;
	private BigDecimal	r119_crt_20_ccf_fund_100_percen;
	private BigDecimal	r119_crt_20_ccf_non_fund_und_0_percen;
	private BigDecimal	r119_crt_20_ccf_non_fund_und_20_percen;
	private BigDecimal	r119_crt_20_ccf_non_fund_und_50_percen;
	private BigDecimal	r119_crt_20_ccf_non_fund_und_100_percen;
	private BigDecimal	r120_crt_50_total_0_percen;
	private BigDecimal	r120_crt_50_total_20_percen;
	private BigDecimal	r120_crt_50_total_50_percen;
	private BigDecimal	r120_crt_50_total_100_percen;
	private BigDecimal	r120_crt_50_ccf_non_fund_0_percen;
	private BigDecimal	r120_crt_50_ccf_non_fund_20_percen;
	private BigDecimal	r120_crt_50_ccf_non_fund_50_percen;
	private BigDecimal	r120_crt_50_ccf_non_fund_100_percen;
	private BigDecimal	r120_crt_50_ccf_fund_0_percen;
	private BigDecimal	r120_crt_50_ccf_fund_20_percen;
	private BigDecimal	r120_crt_50_ccf_fund_50_percen;
	private BigDecimal	r120_crt_50_ccf_fund_100_percen;
	private BigDecimal	r120_crt_50_ccf_non_fund_und_0_percen;
	private BigDecimal	r120_crt_50_ccf_non_fund_und_20_percen;
	private BigDecimal	r120_crt_50_ccf_non_fund_und_50_percen;
	private BigDecimal	r120_crt_50_ccf_non_fund_und_100_percen;
	private BigDecimal	r121_crt_100_total_0_percen;
	private BigDecimal	r121_crt_100_total_20_percen;
	private BigDecimal	r121_crt_100_total_50_percen;
	private BigDecimal	r121_crt_100_total_100_percen;
	private BigDecimal	r121_crt_100_ccf_non_fund_0_percen;
	private BigDecimal	r121_crt_100_ccf_non_fund_20_percen;
	private BigDecimal	r121_crt_100_ccf_non_fund_50_percen;
	private BigDecimal	r121_crt_100_ccf_non_fund_100_percen;
	private BigDecimal	r121_crt_100_ccf_fund_0_percen;
	private BigDecimal	r121_crt_100_ccf_fund_20_percen;
	private BigDecimal	r121_crt_100_ccf_fund_50_percen;
	private BigDecimal	r121_crt_100_ccf_fund_100_percen;
	private BigDecimal	r121_crt_100_ccf_non_fund_und_0_percen;
	private BigDecimal	r121_crt_100_ccf_non_fund_und_20_percen;
	private BigDecimal	r121_crt_100_ccf_non_fund_und_50_percen;
	private BigDecimal	r121_crt_100_ccf_non_fund_und_100_percen;
	private BigDecimal	r122_crt_150_total_0_percen;
	private BigDecimal	r122_crt_150_total_20_percen;
	private BigDecimal	r122_crt_150_total_50_percen;
	private BigDecimal	r122_crt_150_total_100_percen;
	private BigDecimal	r122_crt_150_ccf_non_fund_0_percen;
	private BigDecimal	r122_crt_150_ccf_non_fund_20_percen;
	private BigDecimal	r122_crt_150_ccf_non_fund_50_percen;
	private BigDecimal	r122_crt_150_ccf_non_fund_100_percen;
	private BigDecimal	r122_crt_150_ccf_fund_0_percen;
	private BigDecimal	r122_crt_150_ccf_fund_20_percen;
	private BigDecimal	r122_crt_150_ccf_fund_50_percen;
	private BigDecimal	r122_crt_150_ccf_fund_100_percen;
	private BigDecimal	r122_crt_150_ccf_non_fund_und_0_percen;
	private BigDecimal	r122_crt_150_ccf_non_fund_und_20_percen;
	private BigDecimal	r122_crt_150_ccf_non_fund_und_50_percen;
	private BigDecimal	r122_crt_150_ccf_non_fund_und_100_percen;
	private BigDecimal	r123_hni_100_total_0_percen;
	private BigDecimal	r123_hni_100_total_20_percen;
	private BigDecimal	r123_hni_100_total_50_percen;
	private BigDecimal	r123_hni_100_total_100_percen;
	private BigDecimal	r123_hni_100_ccf_non_fund_0_percen;
	private BigDecimal	r123_hni_100_ccf_non_fund_20_percen;
	private BigDecimal	r123_hni_100_ccf_non_fund_50_percen;
	private BigDecimal	r123_hni_100_ccf_non_fund_100_percen;
	private BigDecimal	r123_hni_100_ccf_fund_0_percen;
	private BigDecimal	r123_hni_100_ccf_fund_20_percen;
	private BigDecimal	r123_hni_100_ccf_fund_50_percen;
	private BigDecimal	r123_hni_100_ccf_fund_100_percen;
	private BigDecimal	r123_hni_100_ccf_non_fund_und_0_percen;
	private BigDecimal	r123_hni_100_ccf_non_fund_und_20_percen;
	private BigDecimal	r123_hni_100_ccf_non_fund_und_50_percen;
	private BigDecimal	r123_hni_100_ccf_non_fund_und_100_percen;
	private BigDecimal	r124_pdl_100_total_0_percen;
	private BigDecimal	r124_pdl_100_total_20_percen;
	private BigDecimal	r124_pdl_100_total_50_percen;
	private BigDecimal	r124_pdl_100_total_100_percen;
	private BigDecimal	r124_pdl_100_ccf_non_fund_0_percen;
	private BigDecimal	r124_pdl_100_ccf_non_fund_20_percen;
	private BigDecimal	r124_pdl_100_ccf_non_fund_50_percen;
	private BigDecimal	r124_pdl_100_ccf_non_fund_100_percen;
	private BigDecimal	r124_pdl_100_ccf_fund_0_percen;
	private BigDecimal	r124_pdl_100_ccf_fund_20_percen;
	private BigDecimal	r124_pdl_100_ccf_fund_50_percen;
	private BigDecimal	r124_pdl_100_ccf_fund_100_percen;
	private BigDecimal	r124_pdl_100_ccf_non_fund_und_0_percen;
	private BigDecimal	r124_pdl_100_ccf_non_fund_und_20_percen;
	private BigDecimal	r124_pdl_100_ccf_non_fund_und_50_percen;
	private BigDecimal	r124_pdl_100_ccf_non_fund_und_100_percen;
	private BigDecimal	r125_pdl_150_total_0_percen;
	private BigDecimal	r125_pdl_150_total_20_percen;
	private BigDecimal	r125_pdl_150_total_50_percen;
	private BigDecimal	r125_pdl_150_total_100_percen;
	private BigDecimal	r125_pdl_150_ccf_non_fund_0_percen;
	private BigDecimal	r125_pdl_150_ccf_non_fund_20_percen;
	private BigDecimal	r125_pdl_150_ccf_non_fund_50_percen;
	private BigDecimal	r125_pdl_150_ccf_non_fund_100_percen;
	private BigDecimal	r125_pdl_150_ccf_fund_0_percen;
	private BigDecimal	r125_pdl_150_ccf_fund_20_percen;
	private BigDecimal	r125_pdl_150_ccf_fund_50_percen;
	private BigDecimal	r125_pdl_150_ccf_fund_100_percen;
	private BigDecimal	r125_pdl_150_ccf_non_fund_und_0_percen;
	private BigDecimal	r125_pdl_150_ccf_non_fund_und_20_percen;
	private BigDecimal	r125_pdl_150_ccf_non_fund_und_50_percen;
	private BigDecimal	r125_pdl_150_ccf_non_fund_und_100_percen;
	private BigDecimal	r126_pse_0_total_0_percen;
	private BigDecimal	r126_pse_0_total_20_percen;
	private BigDecimal	r126_pse_0_total_50_percen;
	private BigDecimal	r126_pse_0_total_100_percen;
	private BigDecimal	r126_pse_0_ccf_non_fund_0_percen;
	private BigDecimal	r126_pse_0_ccf_non_fund_20_percen;
	private BigDecimal	r126_pse_0_ccf_non_fund_50_percen;
	private BigDecimal	r126_pse_0_ccf_non_fund_100_percen;
	private BigDecimal	r126_pse_0_ccf_fund_0_percen;
	private BigDecimal	r126_pse_0_ccf_fund_20_percen;
	private BigDecimal	r126_pse_0_ccf_fund_50_percen;
	private BigDecimal	r126_pse_0_ccf_fund_100_percen;
	private BigDecimal	r126_pse_0_ccf_non_fund_und_0_percen;
	private BigDecimal	r126_pse_0_ccf_non_fund_und_20_percen;
	private BigDecimal	r126_pse_0_ccf_non_fund_und_50_percen;
	private BigDecimal	r126_pse_0_ccf_non_fund_und_100_percen;
	private BigDecimal	r127_pse_20_total_0_percen;
	private BigDecimal	r127_pse_20_total_20_percen;
	private BigDecimal	r127_pse_20_total_50_percen;
	private BigDecimal	r127_pse_20_total_100_percen;
	private BigDecimal	r127_pse_20_ccf_non_fund_0_percen;
	private BigDecimal	r127_pse_20_ccf_non_fund_20_percen;
	private BigDecimal	r127_pse_20_ccf_non_fund_50_percen;
	private BigDecimal	r127_pse_20_ccf_non_fund_100_percen;
	private BigDecimal	r127_pse_20_ccf_fund_0_percen;
	private BigDecimal	r127_pse_20_ccf_fund_20_percen;
	private BigDecimal	r127_pse_20_ccf_fund_50_percen;
	private BigDecimal	r127_pse_20_ccf_fund_100_percen;
	private BigDecimal	r127_pse_20_ccf_non_fund_und_0_percen;
	private BigDecimal	r127_pse_20_ccf_non_fund_und_20_percen;
	private BigDecimal	r127_pse_20_ccf_non_fund_und_50_percen;
	private BigDecimal	r127_pse_20_ccf_non_fund_und_100_percen;
	private BigDecimal	r128_pse_50_total_0_percen;
	private BigDecimal	r128_pse_50_total_20_percen;
	private BigDecimal	r128_pse_50_total_50_percen;
	private BigDecimal	r128_pse_50_total_100_percen;
	private BigDecimal	r128_pse_50_ccf_non_fund_0_percen;
	private BigDecimal	r128_pse_50_ccf_non_fund_20_percen;
	private BigDecimal	r128_pse_50_ccf_non_fund_50_percen;
	private BigDecimal	r128_pse_50_ccf_non_fund_100_percen;
	private BigDecimal	r128_pse_50_ccf_fund_0_percen;
	private BigDecimal	r128_pse_50_ccf_fund_20_percen;
	private BigDecimal	r128_pse_50_ccf_fund_50_percen;
	private BigDecimal	r128_pse_50_ccf_fund_100_percen;
	private BigDecimal	r128_pse_50_ccf_non_fund_und_0_percen;
	private BigDecimal	r128_pse_50_ccf_non_fund_und_20_percen;
	private BigDecimal	r128_pse_50_ccf_non_fund_und_50_percen;
	private BigDecimal	r128_pse_50_ccf_non_fund_und_100_percen;
	private BigDecimal	r129_pse_100_total_0_percen;
	private BigDecimal	r129_pse_100_total_20_percen;
	private BigDecimal	r129_pse_100_total_50_percen;
	private BigDecimal	r129_pse_100_total_100_percen;
	private BigDecimal	r129_pse_100_ccf_non_fund_0_percen;
	private BigDecimal	r129_pse_100_ccf_non_fund_20_percen;
	private BigDecimal	r129_pse_100_ccf_non_fund_50_percen;
	private BigDecimal	r129_pse_100_ccf_non_fund_100_percen;
	private BigDecimal	r129_pse_100_ccf_fund_0_percen;
	private BigDecimal	r129_pse_100_ccf_fund_20_percen;
	private BigDecimal	r129_pse_100_ccf_fund_50_percen;
	private BigDecimal	r129_pse_100_ccf_fund_100_percen;
	private BigDecimal	r129_pse_100_ccf_non_fund_und_0_percen;
	private BigDecimal	r129_pse_100_ccf_non_fund_und_20_percen;
	private BigDecimal	r129_pse_100_ccf_non_fund_und_50_percen;
	private BigDecimal	r129_pse_100_ccf_non_fund_und_100_percen;
	private BigDecimal	r130_pse_150_total_0_percen;
	private BigDecimal	r130_pse_150_total_20_percen;
	private BigDecimal	r130_pse_150_total_50_percen;
	private BigDecimal	r130_pse_150_total_100_percen;
	private BigDecimal	r130_pse_150_ccf_non_fund_0_percen;
	private BigDecimal	r130_pse_150_ccf_non_fund_20_percen;
	private BigDecimal	r130_pse_150_ccf_non_fund_50_percen;
	private BigDecimal	r130_pse_150_ccf_non_fund_100_percen;
	private BigDecimal	r130_pse_150_ccf_fund_0_percen;
	private BigDecimal	r130_pse_150_ccf_fund_20_percen;
	private BigDecimal	r130_pse_150_ccf_fund_50_percen;
	private BigDecimal	r130_pse_150_ccf_fund_100_percen;
	private BigDecimal	r130_pse_150_ccf_non_fund_und_0_percen;
	private BigDecimal	r130_pse_150_ccf_non_fund_und_20_percen;
	private BigDecimal	r130_pse_150_ccf_non_fund_und_50_percen;
	private BigDecimal	r130_pse_150_ccf_non_fund_und_100_percen;
	private BigDecimal	r131_res_35_total_0_percen;
	private BigDecimal	r131_res_35_total_20_percen;
	private BigDecimal	r131_res_35_total_50_percen;
	private BigDecimal	r131_res_35_total_100_percen;
	private BigDecimal	r131_res_35_ccf_non_fund_0_percen;
	private BigDecimal	r131_res_35_ccf_non_fund_20_percen;
	private BigDecimal	r131_res_35_ccf_non_fund_50_percen;
	private BigDecimal	r131_res_35_ccf_non_fund_100_percen;
	private BigDecimal	r131_res_35_ccf_fund_0_percen;
	private BigDecimal	r131_res_35_ccf_fund_20_percen;
	private BigDecimal	r131_res_35_ccf_fund_50_percen;
	private BigDecimal	r131_res_35_ccf_fund_100_percen;
	private BigDecimal	r131_res_35_ccf_non_fund_und_0_percen;
	private BigDecimal	r131_res_35_ccf_non_fund_und_20_percen;
	private BigDecimal	r131_res_35_ccf_non_fund_und_50_percen;
	private BigDecimal	r131_res_35_ccf_non_fund_und_100_percen;
	private BigDecimal	r132_res_100_total_0_percen;
	private BigDecimal	r132_res_100_total_20_percen;
	private BigDecimal	r132_res_100_total_50_percen;
	private BigDecimal	r132_res_100_total_100_percen;
	private BigDecimal	r132_res_100_ccf_non_fund_0_percen;
	private BigDecimal	r132_res_100_ccf_non_fund_20_percen;
	private BigDecimal	r132_res_100_ccf_non_fund_50_percen;
	private BigDecimal	r132_res_100_ccf_non_fund_100_percen;
	private BigDecimal	r132_res_100_ccf_fund_0_percen;
	private BigDecimal	r132_res_100_ccf_fund_20_percen;
	private BigDecimal	r132_res_100_ccf_fund_50_percen;
	private BigDecimal	r132_res_100_ccf_fund_100_percen;
	private BigDecimal	r132_res_100_ccf_non_fund_und_0_percen;
	private BigDecimal	r132_res_100_ccf_non_fund_und_20_percen;
	private BigDecimal	r132_res_100_ccf_non_fund_und_50_percen;
	private BigDecimal	r132_res_100_ccf_non_fund_und_100_percen;
	private BigDecimal	r133_rrp_75_total_0_percen;
	private BigDecimal	r133_rrp_75_total_20_percen;
	private BigDecimal	r133_rrp_75_total_50_percen;
	private BigDecimal	r133_rrp_75_total_100_percen;
	private BigDecimal	r133_rrp_75_ccf_non_fund_0_percen;
	private BigDecimal	r133_rrp_75_ccf_non_fund_20_percen;
	private BigDecimal	r133_rrp_75_ccf_non_fund_50_percen;
	private BigDecimal	r133_rrp_75_ccf_non_fund_100_percen;
	private BigDecimal	r133_rrp_75_ccf_fund_0_percen;
	private BigDecimal	r133_rrp_75_ccf_fund_20_percen;
	private BigDecimal	r133_rrp_75_ccf_fund_50_percen;
	private BigDecimal	r133_rrp_75_ccf_fund_100_percen;
	private BigDecimal	r133_rrp_75_ccf_non_fund_und_0_percen;
	private BigDecimal	r133_rrp_75_ccf_non_fund_und_20_percen;
	private BigDecimal	r133_rrp_75_ccf_non_fund_und_50_percen;
	private BigDecimal	r133_rrp_75_ccf_non_fund_und_100_percen;
	private BigDecimal	r134_rrp_100_total_0_percen;
	private BigDecimal	r134_rrp_100_total_20_percen;
	private BigDecimal	r134_rrp_100_total_50_percen;
	private BigDecimal	r134_rrp_100_total_100_percen;
	private BigDecimal	r134_rrp_100_ccf_non_fund_0_percen;
	private BigDecimal	r134_rrp_100_ccf_non_fund_20_percen;
	private BigDecimal	r134_rrp_100_ccf_non_fund_50_percen;
	private BigDecimal	r134_rrp_100_ccf_non_fund_100_percen;
	private BigDecimal	r134_rrp_100_ccf_fund_0_percen;
	private BigDecimal	r134_rrp_100_ccf_fund_20_percen;
	private BigDecimal	r134_rrp_100_ccf_fund_50_percen;
	private BigDecimal	r134_rrp_100_ccf_fund_100_percen;
	private BigDecimal	r134_rrp_100_ccf_non_fund_und_0_percen;
	private BigDecimal	r134_rrp_100_ccf_non_fund_und_20_percen;
	private BigDecimal	r134_rrp_100_ccf_non_fund_und_50_percen;
	private BigDecimal	r134_rrp_100_ccf_non_fund_und_100_percen;
	private BigDecimal	r135_rrp_75_total_0_percen;
	private BigDecimal	r135_rrp_75_total_20_percen;
	private BigDecimal	r135_rrp_75_total_50_percen;
	private BigDecimal	r135_rrp_75_total_100_percen;
	private BigDecimal	r135_rrp_75_ccf_non_fund_0_percen;
	private BigDecimal	r135_rrp_75_ccf_non_fund_20_percen;
	private BigDecimal	r135_rrp_75_ccf_non_fund_50_percen;
	private BigDecimal	r135_rrp_75_ccf_non_fund_100_percen;
	private BigDecimal	r135_rrp_75_ccf_fund_0_percen;
	private BigDecimal	r135_rrp_75_ccf_fund_20_percen;
	private BigDecimal	r135_rrp_75_ccf_fund_50_percen;
	private BigDecimal	r135_rrp_75_ccf_fund_100_percen;
	private BigDecimal	r135_rrp_75_ccf_non_fund_und_0_percen;
	private BigDecimal	r135_rrp_75_ccf_non_fund_und_20_percen;
	private BigDecimal	r135_rrp_75_ccf_non_fund_und_50_percen;
	private BigDecimal	r135_rrp_75_ccf_non_fund_und_100_percen;
	private BigDecimal	r136_rrp_85_total_0_percen;
	private BigDecimal	r136_rrp_85_total_20_percen;
	private BigDecimal	r136_rrp_85_total_50_percen;
	private BigDecimal	r136_rrp_85_total_100_percen;
	private BigDecimal	r136_rrp_85_ccf_non_fund_0_percen;
	private BigDecimal	r136_rrp_85_ccf_non_fund_20_percen;
	private BigDecimal	r136_rrp_85_ccf_non_fund_50_percen;
	private BigDecimal	r136_rrp_85_ccf_non_fund_100_percen;
	private BigDecimal	r136_rrp_85_ccf_fund_0_percen;
	private BigDecimal	r136_rrp_85_ccf_fund_20_percen;
	private BigDecimal	r136_rrp_85_ccf_fund_50_percen;
	private BigDecimal	r136_rrp_85_ccf_fund_100_percen;
	private BigDecimal	r136_rrp_85_ccf_non_fund_und_0_percen;
	private BigDecimal	r136_rrp_85_ccf_non_fund_und_20_percen;
	private BigDecimal	r136_rrp_85_ccf_non_fund_und_50_percen;
	private BigDecimal	r136_rrp_85_ccf_non_fund_und_100_percen;
	private Date	report_submit_date;
	@Id
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date	report_date;
	private Date	report_from_date;
	private Date	report_to_date;
	private String	report_code;
	private String	entity_flg;
	private String	modify_flg;
	private String	del_flg;
	public BigDecimal getR100_bnk_0_total_0_percen() {
		return r100_bnk_0_total_0_percen;
	}
	public void setR100_bnk_0_total_0_percen(BigDecimal r100_bnk_0_total_0_percen) {
		this.r100_bnk_0_total_0_percen = r100_bnk_0_total_0_percen;
	}
	public BigDecimal getR100_bnk_0_total_20_percen() {
		return r100_bnk_0_total_20_percen;
	}
	public void setR100_bnk_0_total_20_percen(BigDecimal r100_bnk_0_total_20_percen) {
		this.r100_bnk_0_total_20_percen = r100_bnk_0_total_20_percen;
	}
	public BigDecimal getR100_bnk_0_total_50_percen() {
		return r100_bnk_0_total_50_percen;
	}
	public void setR100_bnk_0_total_50_percen(BigDecimal r100_bnk_0_total_50_percen) {
		this.r100_bnk_0_total_50_percen = r100_bnk_0_total_50_percen;
	}
	public BigDecimal getR100_bnk_0_total_100_percen() {
		return r100_bnk_0_total_100_percen;
	}
	public void setR100_bnk_0_total_100_percen(BigDecimal r100_bnk_0_total_100_percen) {
		this.r100_bnk_0_total_100_percen = r100_bnk_0_total_100_percen;
	}
	public BigDecimal getR100_bnk_0_ccf_non_fund_0_percen() {
		return r100_bnk_0_ccf_non_fund_0_percen;
	}
	public void setR100_bnk_0_ccf_non_fund_0_percen(BigDecimal r100_bnk_0_ccf_non_fund_0_percen) {
		this.r100_bnk_0_ccf_non_fund_0_percen = r100_bnk_0_ccf_non_fund_0_percen;
	}
	public BigDecimal getR100_bnk_0_ccf_non_fund_20_percen() {
		return r100_bnk_0_ccf_non_fund_20_percen;
	}
	public void setR100_bnk_0_ccf_non_fund_20_percen(BigDecimal r100_bnk_0_ccf_non_fund_20_percen) {
		this.r100_bnk_0_ccf_non_fund_20_percen = r100_bnk_0_ccf_non_fund_20_percen;
	}
	public BigDecimal getR100_bnk_0_ccf_non_fund_50_percen() {
		return r100_bnk_0_ccf_non_fund_50_percen;
	}
	public void setR100_bnk_0_ccf_non_fund_50_percen(BigDecimal r100_bnk_0_ccf_non_fund_50_percen) {
		this.r100_bnk_0_ccf_non_fund_50_percen = r100_bnk_0_ccf_non_fund_50_percen;
	}
	public BigDecimal getR100_bnk_0_ccf_non_fund_100_percen() {
		return r100_bnk_0_ccf_non_fund_100_percen;
	}
	public void setR100_bnk_0_ccf_non_fund_100_percen(BigDecimal r100_bnk_0_ccf_non_fund_100_percen) {
		this.r100_bnk_0_ccf_non_fund_100_percen = r100_bnk_0_ccf_non_fund_100_percen;
	}
	public BigDecimal getR100_bnk_0_ccf_fund_0_percen() {
		return r100_bnk_0_ccf_fund_0_percen;
	}
	public void setR100_bnk_0_ccf_fund_0_percen(BigDecimal r100_bnk_0_ccf_fund_0_percen) {
		this.r100_bnk_0_ccf_fund_0_percen = r100_bnk_0_ccf_fund_0_percen;
	}
	public BigDecimal getR100_bnk_0_ccf_fund_20_percen() {
		return r100_bnk_0_ccf_fund_20_percen;
	}
	public void setR100_bnk_0_ccf_fund_20_percen(BigDecimal r100_bnk_0_ccf_fund_20_percen) {
		this.r100_bnk_0_ccf_fund_20_percen = r100_bnk_0_ccf_fund_20_percen;
	}
	public BigDecimal getR100_bnk_0_ccf_fund_50_percen() {
		return r100_bnk_0_ccf_fund_50_percen;
	}
	public void setR100_bnk_0_ccf_fund_50_percen(BigDecimal r100_bnk_0_ccf_fund_50_percen) {
		this.r100_bnk_0_ccf_fund_50_percen = r100_bnk_0_ccf_fund_50_percen;
	}
	public BigDecimal getR100_bnk_0_ccf_fund_100_percen() {
		return r100_bnk_0_ccf_fund_100_percen;
	}
	public void setR100_bnk_0_ccf_fund_100_percen(BigDecimal r100_bnk_0_ccf_fund_100_percen) {
		this.r100_bnk_0_ccf_fund_100_percen = r100_bnk_0_ccf_fund_100_percen;
	}
	public BigDecimal getR100_bnk_0_ccf_non_fund_und_0_percen() {
		return r100_bnk_0_ccf_non_fund_und_0_percen;
	}
	public void setR100_bnk_0_ccf_non_fund_und_0_percen(BigDecimal r100_bnk_0_ccf_non_fund_und_0_percen) {
		this.r100_bnk_0_ccf_non_fund_und_0_percen = r100_bnk_0_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR100_bnk_0_ccf_non_fund_und_20_percen() {
		return r100_bnk_0_ccf_non_fund_und_20_percen;
	}
	public void setR100_bnk_0_ccf_non_fund_und_20_percen(BigDecimal r100_bnk_0_ccf_non_fund_und_20_percen) {
		this.r100_bnk_0_ccf_non_fund_und_20_percen = r100_bnk_0_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR100_bnk_0_ccf_non_fund_und_50_percen() {
		return r100_bnk_0_ccf_non_fund_und_50_percen;
	}
	public void setR100_bnk_0_ccf_non_fund_und_50_percen(BigDecimal r100_bnk_0_ccf_non_fund_und_50_percen) {
		this.r100_bnk_0_ccf_non_fund_und_50_percen = r100_bnk_0_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR100_bnk_0_ccf_non_fund_und_100_percen() {
		return r100_bnk_0_ccf_non_fund_und_100_percen;
	}
	public void setR100_bnk_0_ccf_non_fund_und_100_percen(BigDecimal r100_bnk_0_ccf_non_fund_und_100_percen) {
		this.r100_bnk_0_ccf_non_fund_und_100_percen = r100_bnk_0_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR101_bnk_20_total_0_percen() {
		return r101_bnk_20_total_0_percen;
	}
	public void setR101_bnk_20_total_0_percen(BigDecimal r101_bnk_20_total_0_percen) {
		this.r101_bnk_20_total_0_percen = r101_bnk_20_total_0_percen;
	}
	public BigDecimal getR101_bnk_20_total_20_percen() {
		return r101_bnk_20_total_20_percen;
	}
	public void setR101_bnk_20_total_20_percen(BigDecimal r101_bnk_20_total_20_percen) {
		this.r101_bnk_20_total_20_percen = r101_bnk_20_total_20_percen;
	}
	public BigDecimal getR101_bnk_20_total_50_percen() {
		return r101_bnk_20_total_50_percen;
	}
	public void setR101_bnk_20_total_50_percen(BigDecimal r101_bnk_20_total_50_percen) {
		this.r101_bnk_20_total_50_percen = r101_bnk_20_total_50_percen;
	}
	public BigDecimal getR101_bnk_20_total_100_percen() {
		return r101_bnk_20_total_100_percen;
	}
	public void setR101_bnk_20_total_100_percen(BigDecimal r101_bnk_20_total_100_percen) {
		this.r101_bnk_20_total_100_percen = r101_bnk_20_total_100_percen;
	}
	public BigDecimal getR101_bnk_20_ccf_non_fund_0_percen() {
		return r101_bnk_20_ccf_non_fund_0_percen;
	}
	public void setR101_bnk_20_ccf_non_fund_0_percen(BigDecimal r101_bnk_20_ccf_non_fund_0_percen) {
		this.r101_bnk_20_ccf_non_fund_0_percen = r101_bnk_20_ccf_non_fund_0_percen;
	}
	public BigDecimal getR101_bnk_20_ccf_non_fund_20_percen() {
		return r101_bnk_20_ccf_non_fund_20_percen;
	}
	public void setR101_bnk_20_ccf_non_fund_20_percen(BigDecimal r101_bnk_20_ccf_non_fund_20_percen) {
		this.r101_bnk_20_ccf_non_fund_20_percen = r101_bnk_20_ccf_non_fund_20_percen;
	}
	public BigDecimal getR101_bnk_20_ccf_non_fund_50_percen() {
		return r101_bnk_20_ccf_non_fund_50_percen;
	}
	public void setR101_bnk_20_ccf_non_fund_50_percen(BigDecimal r101_bnk_20_ccf_non_fund_50_percen) {
		this.r101_bnk_20_ccf_non_fund_50_percen = r101_bnk_20_ccf_non_fund_50_percen;
	}
	public BigDecimal getR101_bnk_20_ccf_non_fund_100_percen() {
		return r101_bnk_20_ccf_non_fund_100_percen;
	}
	public void setR101_bnk_20_ccf_non_fund_100_percen(BigDecimal r101_bnk_20_ccf_non_fund_100_percen) {
		this.r101_bnk_20_ccf_non_fund_100_percen = r101_bnk_20_ccf_non_fund_100_percen;
	}
	public BigDecimal getR101_bnk_20_ccf_fund_0_percen() {
		return r101_bnk_20_ccf_fund_0_percen;
	}
	public void setR101_bnk_20_ccf_fund_0_percen(BigDecimal r101_bnk_20_ccf_fund_0_percen) {
		this.r101_bnk_20_ccf_fund_0_percen = r101_bnk_20_ccf_fund_0_percen;
	}
	public BigDecimal getR101_bnk_20_ccf_fund_20_percen() {
		return r101_bnk_20_ccf_fund_20_percen;
	}
	public void setR101_bnk_20_ccf_fund_20_percen(BigDecimal r101_bnk_20_ccf_fund_20_percen) {
		this.r101_bnk_20_ccf_fund_20_percen = r101_bnk_20_ccf_fund_20_percen;
	}
	public BigDecimal getR101_bnk_20_ccf_fund_50_percen() {
		return r101_bnk_20_ccf_fund_50_percen;
	}
	public void setR101_bnk_20_ccf_fund_50_percen(BigDecimal r101_bnk_20_ccf_fund_50_percen) {
		this.r101_bnk_20_ccf_fund_50_percen = r101_bnk_20_ccf_fund_50_percen;
	}
	public BigDecimal getR101_bnk_20_ccf_fund_100_percen() {
		return r101_bnk_20_ccf_fund_100_percen;
	}
	public void setR101_bnk_20_ccf_fund_100_percen(BigDecimal r101_bnk_20_ccf_fund_100_percen) {
		this.r101_bnk_20_ccf_fund_100_percen = r101_bnk_20_ccf_fund_100_percen;
	}
	public BigDecimal getR101_bnk_20_ccf_non_fund_und_0_percen() {
		return r101_bnk_20_ccf_non_fund_und_0_percen;
	}
	public void setR101_bnk_20_ccf_non_fund_und_0_percen(BigDecimal r101_bnk_20_ccf_non_fund_und_0_percen) {
		this.r101_bnk_20_ccf_non_fund_und_0_percen = r101_bnk_20_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR101_bnk_20_ccf_non_fund_und_20_percen() {
		return r101_bnk_20_ccf_non_fund_und_20_percen;
	}
	public void setR101_bnk_20_ccf_non_fund_und_20_percen(BigDecimal r101_bnk_20_ccf_non_fund_und_20_percen) {
		this.r101_bnk_20_ccf_non_fund_und_20_percen = r101_bnk_20_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR101_bnk_20_ccf_non_fund_und_50_percen() {
		return r101_bnk_20_ccf_non_fund_und_50_percen;
	}
	public void setR101_bnk_20_ccf_non_fund_und_50_percen(BigDecimal r101_bnk_20_ccf_non_fund_und_50_percen) {
		this.r101_bnk_20_ccf_non_fund_und_50_percen = r101_bnk_20_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR101_bnk_20_ccf_non_fund_und_100_percen() {
		return r101_bnk_20_ccf_non_fund_und_100_percen;
	}
	public void setR101_bnk_20_ccf_non_fund_und_100_percen(BigDecimal r101_bnk_20_ccf_non_fund_und_100_percen) {
		this.r101_bnk_20_ccf_non_fund_und_100_percen = r101_bnk_20_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR102_bnk_50_total_0_percen() {
		return r102_bnk_50_total_0_percen;
	}
	public void setR102_bnk_50_total_0_percen(BigDecimal r102_bnk_50_total_0_percen) {
		this.r102_bnk_50_total_0_percen = r102_bnk_50_total_0_percen;
	}
	public BigDecimal getR102_bnk_50_total_20_percen() {
		return r102_bnk_50_total_20_percen;
	}
	public void setR102_bnk_50_total_20_percen(BigDecimal r102_bnk_50_total_20_percen) {
		this.r102_bnk_50_total_20_percen = r102_bnk_50_total_20_percen;
	}
	public BigDecimal getR102_bnk_50_total_50_percen() {
		return r102_bnk_50_total_50_percen;
	}
	public void setR102_bnk_50_total_50_percen(BigDecimal r102_bnk_50_total_50_percen) {
		this.r102_bnk_50_total_50_percen = r102_bnk_50_total_50_percen;
	}
	public BigDecimal getR102_bnk_50_total_100_percen() {
		return r102_bnk_50_total_100_percen;
	}
	public void setR102_bnk_50_total_100_percen(BigDecimal r102_bnk_50_total_100_percen) {
		this.r102_bnk_50_total_100_percen = r102_bnk_50_total_100_percen;
	}
	public BigDecimal getR102_bnk_50_ccf_non_fund_0_percen() {
		return r102_bnk_50_ccf_non_fund_0_percen;
	}
	public void setR102_bnk_50_ccf_non_fund_0_percen(BigDecimal r102_bnk_50_ccf_non_fund_0_percen) {
		this.r102_bnk_50_ccf_non_fund_0_percen = r102_bnk_50_ccf_non_fund_0_percen;
	}
	public BigDecimal getR102_bnk_50_ccf_non_fund_20_percen() {
		return r102_bnk_50_ccf_non_fund_20_percen;
	}
	public void setR102_bnk_50_ccf_non_fund_20_percen(BigDecimal r102_bnk_50_ccf_non_fund_20_percen) {
		this.r102_bnk_50_ccf_non_fund_20_percen = r102_bnk_50_ccf_non_fund_20_percen;
	}
	public BigDecimal getR102_bnk_50_ccf_non_fund_50_percen() {
		return r102_bnk_50_ccf_non_fund_50_percen;
	}
	public void setR102_bnk_50_ccf_non_fund_50_percen(BigDecimal r102_bnk_50_ccf_non_fund_50_percen) {
		this.r102_bnk_50_ccf_non_fund_50_percen = r102_bnk_50_ccf_non_fund_50_percen;
	}
	public BigDecimal getR102_bnk_50_ccf_non_fund_100_percen() {
		return r102_bnk_50_ccf_non_fund_100_percen;
	}
	public void setR102_bnk_50_ccf_non_fund_100_percen(BigDecimal r102_bnk_50_ccf_non_fund_100_percen) {
		this.r102_bnk_50_ccf_non_fund_100_percen = r102_bnk_50_ccf_non_fund_100_percen;
	}
	public BigDecimal getR102_bnk_50_ccf_fund_0_percen() {
		return r102_bnk_50_ccf_fund_0_percen;
	}
	public void setR102_bnk_50_ccf_fund_0_percen(BigDecimal r102_bnk_50_ccf_fund_0_percen) {
		this.r102_bnk_50_ccf_fund_0_percen = r102_bnk_50_ccf_fund_0_percen;
	}
	public BigDecimal getR102_bnk_50_ccf_fund_20_percen() {
		return r102_bnk_50_ccf_fund_20_percen;
	}
	public void setR102_bnk_50_ccf_fund_20_percen(BigDecimal r102_bnk_50_ccf_fund_20_percen) {
		this.r102_bnk_50_ccf_fund_20_percen = r102_bnk_50_ccf_fund_20_percen;
	}
	public BigDecimal getR102_bnk_50_ccf_fund_50_percen() {
		return r102_bnk_50_ccf_fund_50_percen;
	}
	public void setR102_bnk_50_ccf_fund_50_percen(BigDecimal r102_bnk_50_ccf_fund_50_percen) {
		this.r102_bnk_50_ccf_fund_50_percen = r102_bnk_50_ccf_fund_50_percen;
	}
	public BigDecimal getR102_bnk_50_ccf_fund_100_percen() {
		return r102_bnk_50_ccf_fund_100_percen;
	}
	public void setR102_bnk_50_ccf_fund_100_percen(BigDecimal r102_bnk_50_ccf_fund_100_percen) {
		this.r102_bnk_50_ccf_fund_100_percen = r102_bnk_50_ccf_fund_100_percen;
	}
	public BigDecimal getR102_bnk_50_ccf_non_fund_und_0_percen() {
		return r102_bnk_50_ccf_non_fund_und_0_percen;
	}
	public void setR102_bnk_50_ccf_non_fund_und_0_percen(BigDecimal r102_bnk_50_ccf_non_fund_und_0_percen) {
		this.r102_bnk_50_ccf_non_fund_und_0_percen = r102_bnk_50_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR102_bnk_50_ccf_non_fund_und_20_percen() {
		return r102_bnk_50_ccf_non_fund_und_20_percen;
	}
	public void setR102_bnk_50_ccf_non_fund_und_20_percen(BigDecimal r102_bnk_50_ccf_non_fund_und_20_percen) {
		this.r102_bnk_50_ccf_non_fund_und_20_percen = r102_bnk_50_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR102_bnk_50_ccf_non_fund_und_50_percen() {
		return r102_bnk_50_ccf_non_fund_und_50_percen;
	}
	public void setR102_bnk_50_ccf_non_fund_und_50_percen(BigDecimal r102_bnk_50_ccf_non_fund_und_50_percen) {
		this.r102_bnk_50_ccf_non_fund_und_50_percen = r102_bnk_50_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR102_bnk_50_ccf_non_fund_und_100_percen() {
		return r102_bnk_50_ccf_non_fund_und_100_percen;
	}
	public void setR102_bnk_50_ccf_non_fund_und_100_percen(BigDecimal r102_bnk_50_ccf_non_fund_und_100_percen) {
		this.r102_bnk_50_ccf_non_fund_und_100_percen = r102_bnk_50_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR103_bnk_100_total_0_percen() {
		return r103_bnk_100_total_0_percen;
	}
	public void setR103_bnk_100_total_0_percen(BigDecimal r103_bnk_100_total_0_percen) {
		this.r103_bnk_100_total_0_percen = r103_bnk_100_total_0_percen;
	}
	public BigDecimal getR103_bnk_100_total_20_percen() {
		return r103_bnk_100_total_20_percen;
	}
	public void setR103_bnk_100_total_20_percen(BigDecimal r103_bnk_100_total_20_percen) {
		this.r103_bnk_100_total_20_percen = r103_bnk_100_total_20_percen;
	}
	public BigDecimal getR103_bnk_100_total_50_percen() {
		return r103_bnk_100_total_50_percen;
	}
	public void setR103_bnk_100_total_50_percen(BigDecimal r103_bnk_100_total_50_percen) {
		this.r103_bnk_100_total_50_percen = r103_bnk_100_total_50_percen;
	}
	public BigDecimal getR103_bnk_100_total_100_percen() {
		return r103_bnk_100_total_100_percen;
	}
	public void setR103_bnk_100_total_100_percen(BigDecimal r103_bnk_100_total_100_percen) {
		this.r103_bnk_100_total_100_percen = r103_bnk_100_total_100_percen;
	}
	public BigDecimal getR103_bnk_100_ccf_non_fund_0_percen() {
		return r103_bnk_100_ccf_non_fund_0_percen;
	}
	public void setR103_bnk_100_ccf_non_fund_0_percen(BigDecimal r103_bnk_100_ccf_non_fund_0_percen) {
		this.r103_bnk_100_ccf_non_fund_0_percen = r103_bnk_100_ccf_non_fund_0_percen;
	}
	public BigDecimal getR103_bnk_100_ccf_non_fund_20_percen() {
		return r103_bnk_100_ccf_non_fund_20_percen;
	}
	public void setR103_bnk_100_ccf_non_fund_20_percen(BigDecimal r103_bnk_100_ccf_non_fund_20_percen) {
		this.r103_bnk_100_ccf_non_fund_20_percen = r103_bnk_100_ccf_non_fund_20_percen;
	}
	public BigDecimal getR103_bnk_100_ccf_non_fund_50_percen() {
		return r103_bnk_100_ccf_non_fund_50_percen;
	}
	public void setR103_bnk_100_ccf_non_fund_50_percen(BigDecimal r103_bnk_100_ccf_non_fund_50_percen) {
		this.r103_bnk_100_ccf_non_fund_50_percen = r103_bnk_100_ccf_non_fund_50_percen;
	}
	public BigDecimal getR103_bnk_100_ccf_non_fund_100_percen() {
		return r103_bnk_100_ccf_non_fund_100_percen;
	}
	public void setR103_bnk_100_ccf_non_fund_100_percen(BigDecimal r103_bnk_100_ccf_non_fund_100_percen) {
		this.r103_bnk_100_ccf_non_fund_100_percen = r103_bnk_100_ccf_non_fund_100_percen;
	}
	public BigDecimal getR103_bnk_100_ccf_fund_0_percen() {
		return r103_bnk_100_ccf_fund_0_percen;
	}
	public void setR103_bnk_100_ccf_fund_0_percen(BigDecimal r103_bnk_100_ccf_fund_0_percen) {
		this.r103_bnk_100_ccf_fund_0_percen = r103_bnk_100_ccf_fund_0_percen;
	}
	public BigDecimal getR103_bnk_100_ccf_fund_20_percen() {
		return r103_bnk_100_ccf_fund_20_percen;
	}
	public void setR103_bnk_100_ccf_fund_20_percen(BigDecimal r103_bnk_100_ccf_fund_20_percen) {
		this.r103_bnk_100_ccf_fund_20_percen = r103_bnk_100_ccf_fund_20_percen;
	}
	public BigDecimal getR103_bnk_100_ccf_fund_50_percen() {
		return r103_bnk_100_ccf_fund_50_percen;
	}
	public void setR103_bnk_100_ccf_fund_50_percen(BigDecimal r103_bnk_100_ccf_fund_50_percen) {
		this.r103_bnk_100_ccf_fund_50_percen = r103_bnk_100_ccf_fund_50_percen;
	}
	public BigDecimal getR103_bnk_100_ccf_fund_100_percen() {
		return r103_bnk_100_ccf_fund_100_percen;
	}
	public void setR103_bnk_100_ccf_fund_100_percen(BigDecimal r103_bnk_100_ccf_fund_100_percen) {
		this.r103_bnk_100_ccf_fund_100_percen = r103_bnk_100_ccf_fund_100_percen;
	}
	public BigDecimal getR103_bnk_100_ccf_non_fund_und_0_percen() {
		return r103_bnk_100_ccf_non_fund_und_0_percen;
	}
	public void setR103_bnk_100_ccf_non_fund_und_0_percen(BigDecimal r103_bnk_100_ccf_non_fund_und_0_percen) {
		this.r103_bnk_100_ccf_non_fund_und_0_percen = r103_bnk_100_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR103_bnk_100_ccf_non_fund_und_20_percen() {
		return r103_bnk_100_ccf_non_fund_und_20_percen;
	}
	public void setR103_bnk_100_ccf_non_fund_und_20_percen(BigDecimal r103_bnk_100_ccf_non_fund_und_20_percen) {
		this.r103_bnk_100_ccf_non_fund_und_20_percen = r103_bnk_100_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR103_bnk_100_ccf_non_fund_und_50_percen() {
		return r103_bnk_100_ccf_non_fund_und_50_percen;
	}
	public void setR103_bnk_100_ccf_non_fund_und_50_percen(BigDecimal r103_bnk_100_ccf_non_fund_und_50_percen) {
		this.r103_bnk_100_ccf_non_fund_und_50_percen = r103_bnk_100_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR103_bnk_100_ccf_non_fund_und_100_percen() {
		return r103_bnk_100_ccf_non_fund_und_100_percen;
	}
	public void setR103_bnk_100_ccf_non_fund_und_100_percen(BigDecimal r103_bnk_100_ccf_non_fund_und_100_percen) {
		this.r103_bnk_100_ccf_non_fund_und_100_percen = r103_bnk_100_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR104_bnk_150_total_0_percen() {
		return r104_bnk_150_total_0_percen;
	}
	public void setR104_bnk_150_total_0_percen(BigDecimal r104_bnk_150_total_0_percen) {
		this.r104_bnk_150_total_0_percen = r104_bnk_150_total_0_percen;
	}
	public BigDecimal getR104_bnk_150_total_20_percen() {
		return r104_bnk_150_total_20_percen;
	}
	public void setR104_bnk_150_total_20_percen(BigDecimal r104_bnk_150_total_20_percen) {
		this.r104_bnk_150_total_20_percen = r104_bnk_150_total_20_percen;
	}
	public BigDecimal getR104_bnk_150_total_50_percen() {
		return r104_bnk_150_total_50_percen;
	}
	public void setR104_bnk_150_total_50_percen(BigDecimal r104_bnk_150_total_50_percen) {
		this.r104_bnk_150_total_50_percen = r104_bnk_150_total_50_percen;
	}
	public BigDecimal getR104_bnk_150_total_100_percen() {
		return r104_bnk_150_total_100_percen;
	}
	public void setR104_bnk_150_total_100_percen(BigDecimal r104_bnk_150_total_100_percen) {
		this.r104_bnk_150_total_100_percen = r104_bnk_150_total_100_percen;
	}
	public BigDecimal getR104_bnk_150_ccf_non_fund_0_percen() {
		return r104_bnk_150_ccf_non_fund_0_percen;
	}
	public void setR104_bnk_150_ccf_non_fund_0_percen(BigDecimal r104_bnk_150_ccf_non_fund_0_percen) {
		this.r104_bnk_150_ccf_non_fund_0_percen = r104_bnk_150_ccf_non_fund_0_percen;
	}
	public BigDecimal getR104_bnk_150_ccf_non_fund_20_percen() {
		return r104_bnk_150_ccf_non_fund_20_percen;
	}
	public void setR104_bnk_150_ccf_non_fund_20_percen(BigDecimal r104_bnk_150_ccf_non_fund_20_percen) {
		this.r104_bnk_150_ccf_non_fund_20_percen = r104_bnk_150_ccf_non_fund_20_percen;
	}
	public BigDecimal getR104_bnk_150_ccf_non_fund_50_percen() {
		return r104_bnk_150_ccf_non_fund_50_percen;
	}
	public void setR104_bnk_150_ccf_non_fund_50_percen(BigDecimal r104_bnk_150_ccf_non_fund_50_percen) {
		this.r104_bnk_150_ccf_non_fund_50_percen = r104_bnk_150_ccf_non_fund_50_percen;
	}
	public BigDecimal getR104_bnk_150_ccf_non_fund_100_percen() {
		return r104_bnk_150_ccf_non_fund_100_percen;
	}
	public void setR104_bnk_150_ccf_non_fund_100_percen(BigDecimal r104_bnk_150_ccf_non_fund_100_percen) {
		this.r104_bnk_150_ccf_non_fund_100_percen = r104_bnk_150_ccf_non_fund_100_percen;
	}
	public BigDecimal getR104_bnk_150_ccf_fund_0_percen() {
		return r104_bnk_150_ccf_fund_0_percen;
	}
	public void setR104_bnk_150_ccf_fund_0_percen(BigDecimal r104_bnk_150_ccf_fund_0_percen) {
		this.r104_bnk_150_ccf_fund_0_percen = r104_bnk_150_ccf_fund_0_percen;
	}
	public BigDecimal getR104_bnk_150_ccf_fund_20_percen() {
		return r104_bnk_150_ccf_fund_20_percen;
	}
	public void setR104_bnk_150_ccf_fund_20_percen(BigDecimal r104_bnk_150_ccf_fund_20_percen) {
		this.r104_bnk_150_ccf_fund_20_percen = r104_bnk_150_ccf_fund_20_percen;
	}
	public BigDecimal getR104_bnk_150_ccf_fund_50_percen() {
		return r104_bnk_150_ccf_fund_50_percen;
	}
	public void setR104_bnk_150_ccf_fund_50_percen(BigDecimal r104_bnk_150_ccf_fund_50_percen) {
		this.r104_bnk_150_ccf_fund_50_percen = r104_bnk_150_ccf_fund_50_percen;
	}
	public BigDecimal getR104_bnk_150_ccf_fund_100_percen() {
		return r104_bnk_150_ccf_fund_100_percen;
	}
	public void setR104_bnk_150_ccf_fund_100_percen(BigDecimal r104_bnk_150_ccf_fund_100_percen) {
		this.r104_bnk_150_ccf_fund_100_percen = r104_bnk_150_ccf_fund_100_percen;
	}
	public BigDecimal getR104_bnk_150_ccf_non_fund_und_0_percen() {
		return r104_bnk_150_ccf_non_fund_und_0_percen;
	}
	public void setR104_bnk_150_ccf_non_fund_und_0_percen(BigDecimal r104_bnk_150_ccf_non_fund_und_0_percen) {
		this.r104_bnk_150_ccf_non_fund_und_0_percen = r104_bnk_150_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR104_bnk_150_ccf_non_fund_und_20_percen() {
		return r104_bnk_150_ccf_non_fund_und_20_percen;
	}
	public void setR104_bnk_150_ccf_non_fund_und_20_percen(BigDecimal r104_bnk_150_ccf_non_fund_und_20_percen) {
		this.r104_bnk_150_ccf_non_fund_und_20_percen = r104_bnk_150_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR104_bnk_150_ccf_non_fund_und_50_percen() {
		return r104_bnk_150_ccf_non_fund_und_50_percen;
	}
	public void setR104_bnk_150_ccf_non_fund_und_50_percen(BigDecimal r104_bnk_150_ccf_non_fund_und_50_percen) {
		this.r104_bnk_150_ccf_non_fund_und_50_percen = r104_bnk_150_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR104_bnk_150_ccf_non_fund_und_100_percen() {
		return r104_bnk_150_ccf_non_fund_und_100_percen;
	}
	public void setR104_bnk_150_ccf_non_fund_und_100_percen(BigDecimal r104_bnk_150_ccf_non_fund_und_100_percen) {
		this.r104_bnk_150_ccf_non_fund_und_100_percen = r104_bnk_150_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR105_cbs_0_total_0_percen() {
		return r105_cbs_0_total_0_percen;
	}
	public void setR105_cbs_0_total_0_percen(BigDecimal r105_cbs_0_total_0_percen) {
		this.r105_cbs_0_total_0_percen = r105_cbs_0_total_0_percen;
	}
	public BigDecimal getR105_cbs_0_total_20_percen() {
		return r105_cbs_0_total_20_percen;
	}
	public void setR105_cbs_0_total_20_percen(BigDecimal r105_cbs_0_total_20_percen) {
		this.r105_cbs_0_total_20_percen = r105_cbs_0_total_20_percen;
	}
	public BigDecimal getR105_cbs_0_total_50_percen() {
		return r105_cbs_0_total_50_percen;
	}
	public void setR105_cbs_0_total_50_percen(BigDecimal r105_cbs_0_total_50_percen) {
		this.r105_cbs_0_total_50_percen = r105_cbs_0_total_50_percen;
	}
	public BigDecimal getR105_cbs_0_total_100_percen() {
		return r105_cbs_0_total_100_percen;
	}
	public void setR105_cbs_0_total_100_percen(BigDecimal r105_cbs_0_total_100_percen) {
		this.r105_cbs_0_total_100_percen = r105_cbs_0_total_100_percen;
	}
	public BigDecimal getR105_cbs_0_ccf_non_fund_0_percen() {
		return r105_cbs_0_ccf_non_fund_0_percen;
	}
	public void setR105_cbs_0_ccf_non_fund_0_percen(BigDecimal r105_cbs_0_ccf_non_fund_0_percen) {
		this.r105_cbs_0_ccf_non_fund_0_percen = r105_cbs_0_ccf_non_fund_0_percen;
	}
	public BigDecimal getR105_cbs_0_ccf_non_fund_20_percen() {
		return r105_cbs_0_ccf_non_fund_20_percen;
	}
	public void setR105_cbs_0_ccf_non_fund_20_percen(BigDecimal r105_cbs_0_ccf_non_fund_20_percen) {
		this.r105_cbs_0_ccf_non_fund_20_percen = r105_cbs_0_ccf_non_fund_20_percen;
	}
	public BigDecimal getR105_cbs_0_ccf_non_fund_50_percen() {
		return r105_cbs_0_ccf_non_fund_50_percen;
	}
	public void setR105_cbs_0_ccf_non_fund_50_percen(BigDecimal r105_cbs_0_ccf_non_fund_50_percen) {
		this.r105_cbs_0_ccf_non_fund_50_percen = r105_cbs_0_ccf_non_fund_50_percen;
	}
	public BigDecimal getR105_cbs_0_ccf_non_fund_100_percen() {
		return r105_cbs_0_ccf_non_fund_100_percen;
	}
	public void setR105_cbs_0_ccf_non_fund_100_percen(BigDecimal r105_cbs_0_ccf_non_fund_100_percen) {
		this.r105_cbs_0_ccf_non_fund_100_percen = r105_cbs_0_ccf_non_fund_100_percen;
	}
	public BigDecimal getR105_cbs_0_ccf_fund_0_percen() {
		return r105_cbs_0_ccf_fund_0_percen;
	}
	public void setR105_cbs_0_ccf_fund_0_percen(BigDecimal r105_cbs_0_ccf_fund_0_percen) {
		this.r105_cbs_0_ccf_fund_0_percen = r105_cbs_0_ccf_fund_0_percen;
	}
	public BigDecimal getR105_cbs_0_ccf_fund_20_percen() {
		return r105_cbs_0_ccf_fund_20_percen;
	}
	public void setR105_cbs_0_ccf_fund_20_percen(BigDecimal r105_cbs_0_ccf_fund_20_percen) {
		this.r105_cbs_0_ccf_fund_20_percen = r105_cbs_0_ccf_fund_20_percen;
	}
	public BigDecimal getR105_cbs_0_ccf_fund_50_percen() {
		return r105_cbs_0_ccf_fund_50_percen;
	}
	public void setR105_cbs_0_ccf_fund_50_percen(BigDecimal r105_cbs_0_ccf_fund_50_percen) {
		this.r105_cbs_0_ccf_fund_50_percen = r105_cbs_0_ccf_fund_50_percen;
	}
	public BigDecimal getR105_cbs_0_ccf_fund_100_percen() {
		return r105_cbs_0_ccf_fund_100_percen;
	}
	public void setR105_cbs_0_ccf_fund_100_percen(BigDecimal r105_cbs_0_ccf_fund_100_percen) {
		this.r105_cbs_0_ccf_fund_100_percen = r105_cbs_0_ccf_fund_100_percen;
	}
	public BigDecimal getR105_cbs_0_ccf_non_fund_und_0_percen() {
		return r105_cbs_0_ccf_non_fund_und_0_percen;
	}
	public void setR105_cbs_0_ccf_non_fund_und_0_percen(BigDecimal r105_cbs_0_ccf_non_fund_und_0_percen) {
		this.r105_cbs_0_ccf_non_fund_und_0_percen = r105_cbs_0_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR105_cbs_0_ccf_non_fund_und_20_percen() {
		return r105_cbs_0_ccf_non_fund_und_20_percen;
	}
	public void setR105_cbs_0_ccf_non_fund_und_20_percen(BigDecimal r105_cbs_0_ccf_non_fund_und_20_percen) {
		this.r105_cbs_0_ccf_non_fund_und_20_percen = r105_cbs_0_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR105_cbs_0_ccf_non_fund_und_50_percen() {
		return r105_cbs_0_ccf_non_fund_und_50_percen;
	}
	public void setR105_cbs_0_ccf_non_fund_und_50_percen(BigDecimal r105_cbs_0_ccf_non_fund_und_50_percen) {
		this.r105_cbs_0_ccf_non_fund_und_50_percen = r105_cbs_0_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR105_cbs_0_ccf_non_fund_und_100_percen() {
		return r105_cbs_0_ccf_non_fund_und_100_percen;
	}
	public void setR105_cbs_0_ccf_non_fund_und_100_percen(BigDecimal r105_cbs_0_ccf_non_fund_und_100_percen) {
		this.r105_cbs_0_ccf_non_fund_und_100_percen = r105_cbs_0_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR106_cbs_20_total_0_percen() {
		return r106_cbs_20_total_0_percen;
	}
	public void setR106_cbs_20_total_0_percen(BigDecimal r106_cbs_20_total_0_percen) {
		this.r106_cbs_20_total_0_percen = r106_cbs_20_total_0_percen;
	}
	public BigDecimal getR106_cbs_20_total_20_percen() {
		return r106_cbs_20_total_20_percen;
	}
	public void setR106_cbs_20_total_20_percen(BigDecimal r106_cbs_20_total_20_percen) {
		this.r106_cbs_20_total_20_percen = r106_cbs_20_total_20_percen;
	}
	public BigDecimal getR106_cbs_20_total_50_percen() {
		return r106_cbs_20_total_50_percen;
	}
	public void setR106_cbs_20_total_50_percen(BigDecimal r106_cbs_20_total_50_percen) {
		this.r106_cbs_20_total_50_percen = r106_cbs_20_total_50_percen;
	}
	public BigDecimal getR106_cbs_20_total_100_percen() {
		return r106_cbs_20_total_100_percen;
	}
	public void setR106_cbs_20_total_100_percen(BigDecimal r106_cbs_20_total_100_percen) {
		this.r106_cbs_20_total_100_percen = r106_cbs_20_total_100_percen;
	}
	public BigDecimal getR106_cbs_20_ccf_non_fund_0_percen() {
		return r106_cbs_20_ccf_non_fund_0_percen;
	}
	public void setR106_cbs_20_ccf_non_fund_0_percen(BigDecimal r106_cbs_20_ccf_non_fund_0_percen) {
		this.r106_cbs_20_ccf_non_fund_0_percen = r106_cbs_20_ccf_non_fund_0_percen;
	}
	public BigDecimal getR106_cbs_20_ccf_non_fund_20_percen() {
		return r106_cbs_20_ccf_non_fund_20_percen;
	}
	public void setR106_cbs_20_ccf_non_fund_20_percen(BigDecimal r106_cbs_20_ccf_non_fund_20_percen) {
		this.r106_cbs_20_ccf_non_fund_20_percen = r106_cbs_20_ccf_non_fund_20_percen;
	}
	public BigDecimal getR106_cbs_20_ccf_non_fund_50_percen() {
		return r106_cbs_20_ccf_non_fund_50_percen;
	}
	public void setR106_cbs_20_ccf_non_fund_50_percen(BigDecimal r106_cbs_20_ccf_non_fund_50_percen) {
		this.r106_cbs_20_ccf_non_fund_50_percen = r106_cbs_20_ccf_non_fund_50_percen;
	}
	public BigDecimal getR106_cbs_20_ccf_non_fund_100_percen() {
		return r106_cbs_20_ccf_non_fund_100_percen;
	}
	public void setR106_cbs_20_ccf_non_fund_100_percen(BigDecimal r106_cbs_20_ccf_non_fund_100_percen) {
		this.r106_cbs_20_ccf_non_fund_100_percen = r106_cbs_20_ccf_non_fund_100_percen;
	}
	public BigDecimal getR106_cbs_20_ccf_fund_0_percen() {
		return r106_cbs_20_ccf_fund_0_percen;
	}
	public void setR106_cbs_20_ccf_fund_0_percen(BigDecimal r106_cbs_20_ccf_fund_0_percen) {
		this.r106_cbs_20_ccf_fund_0_percen = r106_cbs_20_ccf_fund_0_percen;
	}
	public BigDecimal getR106_cbs_20_ccf_fund_20_percen() {
		return r106_cbs_20_ccf_fund_20_percen;
	}
	public void setR106_cbs_20_ccf_fund_20_percen(BigDecimal r106_cbs_20_ccf_fund_20_percen) {
		this.r106_cbs_20_ccf_fund_20_percen = r106_cbs_20_ccf_fund_20_percen;
	}
	public BigDecimal getR106_cbs_20_ccf_fund_50_percen() {
		return r106_cbs_20_ccf_fund_50_percen;
	}
	public void setR106_cbs_20_ccf_fund_50_percen(BigDecimal r106_cbs_20_ccf_fund_50_percen) {
		this.r106_cbs_20_ccf_fund_50_percen = r106_cbs_20_ccf_fund_50_percen;
	}
	public BigDecimal getR106_cbs_20_ccf_fund_100_percen() {
		return r106_cbs_20_ccf_fund_100_percen;
	}
	public void setR106_cbs_20_ccf_fund_100_percen(BigDecimal r106_cbs_20_ccf_fund_100_percen) {
		this.r106_cbs_20_ccf_fund_100_percen = r106_cbs_20_ccf_fund_100_percen;
	}
	public BigDecimal getR106_cbs_20_ccf_non_fund_und_0_percen() {
		return r106_cbs_20_ccf_non_fund_und_0_percen;
	}
	public void setR106_cbs_20_ccf_non_fund_und_0_percen(BigDecimal r106_cbs_20_ccf_non_fund_und_0_percen) {
		this.r106_cbs_20_ccf_non_fund_und_0_percen = r106_cbs_20_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR106_cbs_20_ccf_non_fund_und_20_percen() {
		return r106_cbs_20_ccf_non_fund_und_20_percen;
	}
	public void setR106_cbs_20_ccf_non_fund_und_20_percen(BigDecimal r106_cbs_20_ccf_non_fund_und_20_percen) {
		this.r106_cbs_20_ccf_non_fund_und_20_percen = r106_cbs_20_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR106_cbs_20_ccf_non_fund_und_50_percen() {
		return r106_cbs_20_ccf_non_fund_und_50_percen;
	}
	public void setR106_cbs_20_ccf_non_fund_und_50_percen(BigDecimal r106_cbs_20_ccf_non_fund_und_50_percen) {
		this.r106_cbs_20_ccf_non_fund_und_50_percen = r106_cbs_20_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR106_cbs_20_ccf_non_fund_und_100_percen() {
		return r106_cbs_20_ccf_non_fund_und_100_percen;
	}
	public void setR106_cbs_20_ccf_non_fund_und_100_percen(BigDecimal r106_cbs_20_ccf_non_fund_und_100_percen) {
		this.r106_cbs_20_ccf_non_fund_und_100_percen = r106_cbs_20_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR107_cbs_20_total_0_percen() {
		return r107_cbs_20_total_0_percen;
	}
	public void setR107_cbs_20_total_0_percen(BigDecimal r107_cbs_20_total_0_percen) {
		this.r107_cbs_20_total_0_percen = r107_cbs_20_total_0_percen;
	}
	public BigDecimal getR107_cbs_20_total_20_percen() {
		return r107_cbs_20_total_20_percen;
	}
	public void setR107_cbs_20_total_20_percen(BigDecimal r107_cbs_20_total_20_percen) {
		this.r107_cbs_20_total_20_percen = r107_cbs_20_total_20_percen;
	}
	public BigDecimal getR107_cbs_20_total_50_percen() {
		return r107_cbs_20_total_50_percen;
	}
	public void setR107_cbs_20_total_50_percen(BigDecimal r107_cbs_20_total_50_percen) {
		this.r107_cbs_20_total_50_percen = r107_cbs_20_total_50_percen;
	}
	public BigDecimal getR107_cbs_20_total_100_percen() {
		return r107_cbs_20_total_100_percen;
	}
	public void setR107_cbs_20_total_100_percen(BigDecimal r107_cbs_20_total_100_percen) {
		this.r107_cbs_20_total_100_percen = r107_cbs_20_total_100_percen;
	}
	public BigDecimal getR107_cbs_20_ccf_non_fund_0_percen() {
		return r107_cbs_20_ccf_non_fund_0_percen;
	}
	public void setR107_cbs_20_ccf_non_fund_0_percen(BigDecimal r107_cbs_20_ccf_non_fund_0_percen) {
		this.r107_cbs_20_ccf_non_fund_0_percen = r107_cbs_20_ccf_non_fund_0_percen;
	}
	public BigDecimal getR107_cbs_20_ccf_non_fund_20_percen() {
		return r107_cbs_20_ccf_non_fund_20_percen;
	}
	public void setR107_cbs_20_ccf_non_fund_20_percen(BigDecimal r107_cbs_20_ccf_non_fund_20_percen) {
		this.r107_cbs_20_ccf_non_fund_20_percen = r107_cbs_20_ccf_non_fund_20_percen;
	}
	public BigDecimal getR107_cbs_20_ccf_non_fund_50_percen() {
		return r107_cbs_20_ccf_non_fund_50_percen;
	}
	public void setR107_cbs_20_ccf_non_fund_50_percen(BigDecimal r107_cbs_20_ccf_non_fund_50_percen) {
		this.r107_cbs_20_ccf_non_fund_50_percen = r107_cbs_20_ccf_non_fund_50_percen;
	}
	public BigDecimal getR107_cbs_20_ccf_non_fund_100_percen() {
		return r107_cbs_20_ccf_non_fund_100_percen;
	}
	public void setR107_cbs_20_ccf_non_fund_100_percen(BigDecimal r107_cbs_20_ccf_non_fund_100_percen) {
		this.r107_cbs_20_ccf_non_fund_100_percen = r107_cbs_20_ccf_non_fund_100_percen;
	}
	public BigDecimal getR107_cbs_20_ccf_fund_0_percen() {
		return r107_cbs_20_ccf_fund_0_percen;
	}
	public void setR107_cbs_20_ccf_fund_0_percen(BigDecimal r107_cbs_20_ccf_fund_0_percen) {
		this.r107_cbs_20_ccf_fund_0_percen = r107_cbs_20_ccf_fund_0_percen;
	}
	public BigDecimal getR107_cbs_20_ccf_fund_20_percen() {
		return r107_cbs_20_ccf_fund_20_percen;
	}
	public void setR107_cbs_20_ccf_fund_20_percen(BigDecimal r107_cbs_20_ccf_fund_20_percen) {
		this.r107_cbs_20_ccf_fund_20_percen = r107_cbs_20_ccf_fund_20_percen;
	}
	public BigDecimal getR107_cbs_20_ccf_fund_50_percen() {
		return r107_cbs_20_ccf_fund_50_percen;
	}
	public void setR107_cbs_20_ccf_fund_50_percen(BigDecimal r107_cbs_20_ccf_fund_50_percen) {
		this.r107_cbs_20_ccf_fund_50_percen = r107_cbs_20_ccf_fund_50_percen;
	}
	public BigDecimal getR107_cbs_20_ccf_fund_100_percen() {
		return r107_cbs_20_ccf_fund_100_percen;
	}
	public void setR107_cbs_20_ccf_fund_100_percen(BigDecimal r107_cbs_20_ccf_fund_100_percen) {
		this.r107_cbs_20_ccf_fund_100_percen = r107_cbs_20_ccf_fund_100_percen;
	}
	public BigDecimal getR107_cbs_20_ccf_non_fund_und_0_percen() {
		return r107_cbs_20_ccf_non_fund_und_0_percen;
	}
	public void setR107_cbs_20_ccf_non_fund_und_0_percen(BigDecimal r107_cbs_20_ccf_non_fund_und_0_percen) {
		this.r107_cbs_20_ccf_non_fund_und_0_percen = r107_cbs_20_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR107_cbs_20_ccf_non_fund_und_20_percen() {
		return r107_cbs_20_ccf_non_fund_und_20_percen;
	}
	public void setR107_cbs_20_ccf_non_fund_und_20_percen(BigDecimal r107_cbs_20_ccf_non_fund_und_20_percen) {
		this.r107_cbs_20_ccf_non_fund_und_20_percen = r107_cbs_20_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR107_cbs_20_ccf_non_fund_und_50_percen() {
		return r107_cbs_20_ccf_non_fund_und_50_percen;
	}
	public void setR107_cbs_20_ccf_non_fund_und_50_percen(BigDecimal r107_cbs_20_ccf_non_fund_und_50_percen) {
		this.r107_cbs_20_ccf_non_fund_und_50_percen = r107_cbs_20_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR107_cbs_20_ccf_non_fund_und_100_percen() {
		return r107_cbs_20_ccf_non_fund_und_100_percen;
	}
	public void setR107_cbs_20_ccf_non_fund_und_100_percen(BigDecimal r107_cbs_20_ccf_non_fund_und_100_percen) {
		this.r107_cbs_20_ccf_non_fund_und_100_percen = r107_cbs_20_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR108_cbs_0_total_0_percen() {
		return r108_cbs_0_total_0_percen;
	}
	public void setR108_cbs_0_total_0_percen(BigDecimal r108_cbs_0_total_0_percen) {
		this.r108_cbs_0_total_0_percen = r108_cbs_0_total_0_percen;
	}
	public BigDecimal getR108_cbs_0_total_20_percen() {
		return r108_cbs_0_total_20_percen;
	}
	public void setR108_cbs_0_total_20_percen(BigDecimal r108_cbs_0_total_20_percen) {
		this.r108_cbs_0_total_20_percen = r108_cbs_0_total_20_percen;
	}
	public BigDecimal getR108_cbs_0_total_50_percen() {
		return r108_cbs_0_total_50_percen;
	}
	public void setR108_cbs_0_total_50_percen(BigDecimal r108_cbs_0_total_50_percen) {
		this.r108_cbs_0_total_50_percen = r108_cbs_0_total_50_percen;
	}
	public BigDecimal getR108_cbs_0_total_100_percen() {
		return r108_cbs_0_total_100_percen;
	}
	public void setR108_cbs_0_total_100_percen(BigDecimal r108_cbs_0_total_100_percen) {
		this.r108_cbs_0_total_100_percen = r108_cbs_0_total_100_percen;
	}
	public BigDecimal getR108_cbs_0_ccf_non_fund_0_percen() {
		return r108_cbs_0_ccf_non_fund_0_percen;
	}
	public void setR108_cbs_0_ccf_non_fund_0_percen(BigDecimal r108_cbs_0_ccf_non_fund_0_percen) {
		this.r108_cbs_0_ccf_non_fund_0_percen = r108_cbs_0_ccf_non_fund_0_percen;
	}
	public BigDecimal getR108_cbs_0_ccf_non_fund_20_percen() {
		return r108_cbs_0_ccf_non_fund_20_percen;
	}
	public void setR108_cbs_0_ccf_non_fund_20_percen(BigDecimal r108_cbs_0_ccf_non_fund_20_percen) {
		this.r108_cbs_0_ccf_non_fund_20_percen = r108_cbs_0_ccf_non_fund_20_percen;
	}
	public BigDecimal getR108_cbs_0_ccf_non_fund_50_percen() {
		return r108_cbs_0_ccf_non_fund_50_percen;
	}
	public void setR108_cbs_0_ccf_non_fund_50_percen(BigDecimal r108_cbs_0_ccf_non_fund_50_percen) {
		this.r108_cbs_0_ccf_non_fund_50_percen = r108_cbs_0_ccf_non_fund_50_percen;
	}
	public BigDecimal getR108_cbs_0_ccf_non_fund_100_percen() {
		return r108_cbs_0_ccf_non_fund_100_percen;
	}
	public void setR108_cbs_0_ccf_non_fund_100_percen(BigDecimal r108_cbs_0_ccf_non_fund_100_percen) {
		this.r108_cbs_0_ccf_non_fund_100_percen = r108_cbs_0_ccf_non_fund_100_percen;
	}
	public BigDecimal getR108_cbs_0_ccf_fund_0_percen() {
		return r108_cbs_0_ccf_fund_0_percen;
	}
	public void setR108_cbs_0_ccf_fund_0_percen(BigDecimal r108_cbs_0_ccf_fund_0_percen) {
		this.r108_cbs_0_ccf_fund_0_percen = r108_cbs_0_ccf_fund_0_percen;
	}
	public BigDecimal getR108_cbs_0_ccf_fund_20_percen() {
		return r108_cbs_0_ccf_fund_20_percen;
	}
	public void setR108_cbs_0_ccf_fund_20_percen(BigDecimal r108_cbs_0_ccf_fund_20_percen) {
		this.r108_cbs_0_ccf_fund_20_percen = r108_cbs_0_ccf_fund_20_percen;
	}
	public BigDecimal getR108_cbs_0_ccf_fund_50_percen() {
		return r108_cbs_0_ccf_fund_50_percen;
	}
	public void setR108_cbs_0_ccf_fund_50_percen(BigDecimal r108_cbs_0_ccf_fund_50_percen) {
		this.r108_cbs_0_ccf_fund_50_percen = r108_cbs_0_ccf_fund_50_percen;
	}
	public BigDecimal getR108_cbs_0_ccf_fund_100_percen() {
		return r108_cbs_0_ccf_fund_100_percen;
	}
	public void setR108_cbs_0_ccf_fund_100_percen(BigDecimal r108_cbs_0_ccf_fund_100_percen) {
		this.r108_cbs_0_ccf_fund_100_percen = r108_cbs_0_ccf_fund_100_percen;
	}
	public BigDecimal getR108_cbs_0_ccf_non_fund_und_0_percen() {
		return r108_cbs_0_ccf_non_fund_und_0_percen;
	}
	public void setR108_cbs_0_ccf_non_fund_und_0_percen(BigDecimal r108_cbs_0_ccf_non_fund_und_0_percen) {
		this.r108_cbs_0_ccf_non_fund_und_0_percen = r108_cbs_0_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR108_cbs_0_ccf_non_fund_und_20_percen() {
		return r108_cbs_0_ccf_non_fund_und_20_percen;
	}
	public void setR108_cbs_0_ccf_non_fund_und_20_percen(BigDecimal r108_cbs_0_ccf_non_fund_und_20_percen) {
		this.r108_cbs_0_ccf_non_fund_und_20_percen = r108_cbs_0_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR108_cbs_0_ccf_non_fund_und_50_percen() {
		return r108_cbs_0_ccf_non_fund_und_50_percen;
	}
	public void setR108_cbs_0_ccf_non_fund_und_50_percen(BigDecimal r108_cbs_0_ccf_non_fund_und_50_percen) {
		this.r108_cbs_0_ccf_non_fund_und_50_percen = r108_cbs_0_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR108_cbs_0_ccf_non_fund_und_100_percen() {
		return r108_cbs_0_ccf_non_fund_und_100_percen;
	}
	public void setR108_cbs_0_ccf_non_fund_und_100_percen(BigDecimal r108_cbs_0_ccf_non_fund_und_100_percen) {
		this.r108_cbs_0_ccf_non_fund_und_100_percen = r108_cbs_0_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR109_cbs_20_total_0_percen() {
		return r109_cbs_20_total_0_percen;
	}
	public void setR109_cbs_20_total_0_percen(BigDecimal r109_cbs_20_total_0_percen) {
		this.r109_cbs_20_total_0_percen = r109_cbs_20_total_0_percen;
	}
	public BigDecimal getR109_cbs_20_total_20_percen() {
		return r109_cbs_20_total_20_percen;
	}
	public void setR109_cbs_20_total_20_percen(BigDecimal r109_cbs_20_total_20_percen) {
		this.r109_cbs_20_total_20_percen = r109_cbs_20_total_20_percen;
	}
	public BigDecimal getR109_cbs_20_total_50_percen() {
		return r109_cbs_20_total_50_percen;
	}
	public void setR109_cbs_20_total_50_percen(BigDecimal r109_cbs_20_total_50_percen) {
		this.r109_cbs_20_total_50_percen = r109_cbs_20_total_50_percen;
	}
	public BigDecimal getR109_cbs_20_total_100_percen() {
		return r109_cbs_20_total_100_percen;
	}
	public void setR109_cbs_20_total_100_percen(BigDecimal r109_cbs_20_total_100_percen) {
		this.r109_cbs_20_total_100_percen = r109_cbs_20_total_100_percen;
	}
	public BigDecimal getR109_cbs_20_ccf_non_fund_0_percen() {
		return r109_cbs_20_ccf_non_fund_0_percen;
	}
	public void setR109_cbs_20_ccf_non_fund_0_percen(BigDecimal r109_cbs_20_ccf_non_fund_0_percen) {
		this.r109_cbs_20_ccf_non_fund_0_percen = r109_cbs_20_ccf_non_fund_0_percen;
	}
	public BigDecimal getR109_cbs_20_ccf_non_fund_20_percen() {
		return r109_cbs_20_ccf_non_fund_20_percen;
	}
	public void setR109_cbs_20_ccf_non_fund_20_percen(BigDecimal r109_cbs_20_ccf_non_fund_20_percen) {
		this.r109_cbs_20_ccf_non_fund_20_percen = r109_cbs_20_ccf_non_fund_20_percen;
	}
	public BigDecimal getR109_cbs_20_ccf_non_fund_50_percen() {
		return r109_cbs_20_ccf_non_fund_50_percen;
	}
	public void setR109_cbs_20_ccf_non_fund_50_percen(BigDecimal r109_cbs_20_ccf_non_fund_50_percen) {
		this.r109_cbs_20_ccf_non_fund_50_percen = r109_cbs_20_ccf_non_fund_50_percen;
	}
	public BigDecimal getR109_cbs_20_ccf_non_fund_100_percen() {
		return r109_cbs_20_ccf_non_fund_100_percen;
	}
	public void setR109_cbs_20_ccf_non_fund_100_percen(BigDecimal r109_cbs_20_ccf_non_fund_100_percen) {
		this.r109_cbs_20_ccf_non_fund_100_percen = r109_cbs_20_ccf_non_fund_100_percen;
	}
	public BigDecimal getR109_cbs_20_ccf_fund_0_percen() {
		return r109_cbs_20_ccf_fund_0_percen;
	}
	public void setR109_cbs_20_ccf_fund_0_percen(BigDecimal r109_cbs_20_ccf_fund_0_percen) {
		this.r109_cbs_20_ccf_fund_0_percen = r109_cbs_20_ccf_fund_0_percen;
	}
	public BigDecimal getR109_cbs_20_ccf_fund_20_percen() {
		return r109_cbs_20_ccf_fund_20_percen;
	}
	public void setR109_cbs_20_ccf_fund_20_percen(BigDecimal r109_cbs_20_ccf_fund_20_percen) {
		this.r109_cbs_20_ccf_fund_20_percen = r109_cbs_20_ccf_fund_20_percen;
	}
	public BigDecimal getR109_cbs_20_ccf_fund_50_percen() {
		return r109_cbs_20_ccf_fund_50_percen;
	}
	public void setR109_cbs_20_ccf_fund_50_percen(BigDecimal r109_cbs_20_ccf_fund_50_percen) {
		this.r109_cbs_20_ccf_fund_50_percen = r109_cbs_20_ccf_fund_50_percen;
	}
	public BigDecimal getR109_cbs_20_ccf_fund_100_percen() {
		return r109_cbs_20_ccf_fund_100_percen;
	}
	public void setR109_cbs_20_ccf_fund_100_percen(BigDecimal r109_cbs_20_ccf_fund_100_percen) {
		this.r109_cbs_20_ccf_fund_100_percen = r109_cbs_20_ccf_fund_100_percen;
	}
	public BigDecimal getR109_cbs_20_ccf_non_fund_und_0_percen() {
		return r109_cbs_20_ccf_non_fund_und_0_percen;
	}
	public void setR109_cbs_20_ccf_non_fund_und_0_percen(BigDecimal r109_cbs_20_ccf_non_fund_und_0_percen) {
		this.r109_cbs_20_ccf_non_fund_und_0_percen = r109_cbs_20_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR109_cbs_20_ccf_non_fund_und_20_percen() {
		return r109_cbs_20_ccf_non_fund_und_20_percen;
	}
	public void setR109_cbs_20_ccf_non_fund_und_20_percen(BigDecimal r109_cbs_20_ccf_non_fund_und_20_percen) {
		this.r109_cbs_20_ccf_non_fund_und_20_percen = r109_cbs_20_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR109_cbs_20_ccf_non_fund_und_50_percen() {
		return r109_cbs_20_ccf_non_fund_und_50_percen;
	}
	public void setR109_cbs_20_ccf_non_fund_und_50_percen(BigDecimal r109_cbs_20_ccf_non_fund_und_50_percen) {
		this.r109_cbs_20_ccf_non_fund_und_50_percen = r109_cbs_20_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR109_cbs_20_ccf_non_fund_und_100_percen() {
		return r109_cbs_20_ccf_non_fund_und_100_percen;
	}
	public void setR109_cbs_20_ccf_non_fund_und_100_percen(BigDecimal r109_cbs_20_ccf_non_fund_und_100_percen) {
		this.r109_cbs_20_ccf_non_fund_und_100_percen = r109_cbs_20_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR110_cbs_50_total_0_percen() {
		return r110_cbs_50_total_0_percen;
	}
	public void setR110_cbs_50_total_0_percen(BigDecimal r110_cbs_50_total_0_percen) {
		this.r110_cbs_50_total_0_percen = r110_cbs_50_total_0_percen;
	}
	public BigDecimal getR110_cbs_50_total_20_percen() {
		return r110_cbs_50_total_20_percen;
	}
	public void setR110_cbs_50_total_20_percen(BigDecimal r110_cbs_50_total_20_percen) {
		this.r110_cbs_50_total_20_percen = r110_cbs_50_total_20_percen;
	}
	public BigDecimal getR110_cbs_50_total_50_percen() {
		return r110_cbs_50_total_50_percen;
	}
	public void setR110_cbs_50_total_50_percen(BigDecimal r110_cbs_50_total_50_percen) {
		this.r110_cbs_50_total_50_percen = r110_cbs_50_total_50_percen;
	}
	public BigDecimal getR110_cbs_50_total_100_percen() {
		return r110_cbs_50_total_100_percen;
	}
	public void setR110_cbs_50_total_100_percen(BigDecimal r110_cbs_50_total_100_percen) {
		this.r110_cbs_50_total_100_percen = r110_cbs_50_total_100_percen;
	}
	public BigDecimal getR110_cbs_50_ccf_non_fund_0_percen() {
		return r110_cbs_50_ccf_non_fund_0_percen;
	}
	public void setR110_cbs_50_ccf_non_fund_0_percen(BigDecimal r110_cbs_50_ccf_non_fund_0_percen) {
		this.r110_cbs_50_ccf_non_fund_0_percen = r110_cbs_50_ccf_non_fund_0_percen;
	}
	public BigDecimal getR110_cbs_50_ccf_non_fund_20_percen() {
		return r110_cbs_50_ccf_non_fund_20_percen;
	}
	public void setR110_cbs_50_ccf_non_fund_20_percen(BigDecimal r110_cbs_50_ccf_non_fund_20_percen) {
		this.r110_cbs_50_ccf_non_fund_20_percen = r110_cbs_50_ccf_non_fund_20_percen;
	}
	public BigDecimal getR110_cbs_50_ccf_non_fund_50_percen() {
		return r110_cbs_50_ccf_non_fund_50_percen;
	}
	public void setR110_cbs_50_ccf_non_fund_50_percen(BigDecimal r110_cbs_50_ccf_non_fund_50_percen) {
		this.r110_cbs_50_ccf_non_fund_50_percen = r110_cbs_50_ccf_non_fund_50_percen;
	}
	public BigDecimal getR110_cbs_50_ccf_non_fund_100_percen() {
		return r110_cbs_50_ccf_non_fund_100_percen;
	}
	public void setR110_cbs_50_ccf_non_fund_100_percen(BigDecimal r110_cbs_50_ccf_non_fund_100_percen) {
		this.r110_cbs_50_ccf_non_fund_100_percen = r110_cbs_50_ccf_non_fund_100_percen;
	}
	public BigDecimal getR110_cbs_50_ccf_fund_0_percen() {
		return r110_cbs_50_ccf_fund_0_percen;
	}
	public void setR110_cbs_50_ccf_fund_0_percen(BigDecimal r110_cbs_50_ccf_fund_0_percen) {
		this.r110_cbs_50_ccf_fund_0_percen = r110_cbs_50_ccf_fund_0_percen;
	}
	public BigDecimal getR110_cbs_50_ccf_fund_20_percen() {
		return r110_cbs_50_ccf_fund_20_percen;
	}
	public void setR110_cbs_50_ccf_fund_20_percen(BigDecimal r110_cbs_50_ccf_fund_20_percen) {
		this.r110_cbs_50_ccf_fund_20_percen = r110_cbs_50_ccf_fund_20_percen;
	}
	public BigDecimal getR110_cbs_50_ccf_fund_50_percen() {
		return r110_cbs_50_ccf_fund_50_percen;
	}
	public void setR110_cbs_50_ccf_fund_50_percen(BigDecimal r110_cbs_50_ccf_fund_50_percen) {
		this.r110_cbs_50_ccf_fund_50_percen = r110_cbs_50_ccf_fund_50_percen;
	}
	public BigDecimal getR110_cbs_50_ccf_fund_100_percen() {
		return r110_cbs_50_ccf_fund_100_percen;
	}
	public void setR110_cbs_50_ccf_fund_100_percen(BigDecimal r110_cbs_50_ccf_fund_100_percen) {
		this.r110_cbs_50_ccf_fund_100_percen = r110_cbs_50_ccf_fund_100_percen;
	}
	public BigDecimal getR110_cbs_50_ccf_non_fund_und_0_percen() {
		return r110_cbs_50_ccf_non_fund_und_0_percen;
	}
	public void setR110_cbs_50_ccf_non_fund_und_0_percen(BigDecimal r110_cbs_50_ccf_non_fund_und_0_percen) {
		this.r110_cbs_50_ccf_non_fund_und_0_percen = r110_cbs_50_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR110_cbs_50_ccf_non_fund_und_20_percen() {
		return r110_cbs_50_ccf_non_fund_und_20_percen;
	}
	public void setR110_cbs_50_ccf_non_fund_und_20_percen(BigDecimal r110_cbs_50_ccf_non_fund_und_20_percen) {
		this.r110_cbs_50_ccf_non_fund_und_20_percen = r110_cbs_50_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR110_cbs_50_ccf_non_fund_und_50_percen() {
		return r110_cbs_50_ccf_non_fund_und_50_percen;
	}
	public void setR110_cbs_50_ccf_non_fund_und_50_percen(BigDecimal r110_cbs_50_ccf_non_fund_und_50_percen) {
		this.r110_cbs_50_ccf_non_fund_und_50_percen = r110_cbs_50_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR110_cbs_50_ccf_non_fund_und_100_percen() {
		return r110_cbs_50_ccf_non_fund_und_100_percen;
	}
	public void setR110_cbs_50_ccf_non_fund_und_100_percen(BigDecimal r110_cbs_50_ccf_non_fund_und_100_percen) {
		this.r110_cbs_50_ccf_non_fund_und_100_percen = r110_cbs_50_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR111_cbs_100_total_0_percen() {
		return r111_cbs_100_total_0_percen;
	}
	public void setR111_cbs_100_total_0_percen(BigDecimal r111_cbs_100_total_0_percen) {
		this.r111_cbs_100_total_0_percen = r111_cbs_100_total_0_percen;
	}
	public BigDecimal getR111_cbs_100_total_20_percen() {
		return r111_cbs_100_total_20_percen;
	}
	public void setR111_cbs_100_total_20_percen(BigDecimal r111_cbs_100_total_20_percen) {
		this.r111_cbs_100_total_20_percen = r111_cbs_100_total_20_percen;
	}
	public BigDecimal getR111_cbs_100_total_50_percen() {
		return r111_cbs_100_total_50_percen;
	}
	public void setR111_cbs_100_total_50_percen(BigDecimal r111_cbs_100_total_50_percen) {
		this.r111_cbs_100_total_50_percen = r111_cbs_100_total_50_percen;
	}
	public BigDecimal getR111_cbs_100_total_100_percen() {
		return r111_cbs_100_total_100_percen;
	}
	public void setR111_cbs_100_total_100_percen(BigDecimal r111_cbs_100_total_100_percen) {
		this.r111_cbs_100_total_100_percen = r111_cbs_100_total_100_percen;
	}
	public BigDecimal getR111_cbs_100_ccf_non_fund_0_percen() {
		return r111_cbs_100_ccf_non_fund_0_percen;
	}
	public void setR111_cbs_100_ccf_non_fund_0_percen(BigDecimal r111_cbs_100_ccf_non_fund_0_percen) {
		this.r111_cbs_100_ccf_non_fund_0_percen = r111_cbs_100_ccf_non_fund_0_percen;
	}
	public BigDecimal getR111_cbs_100_ccf_non_fund_20_percen() {
		return r111_cbs_100_ccf_non_fund_20_percen;
	}
	public void setR111_cbs_100_ccf_non_fund_20_percen(BigDecimal r111_cbs_100_ccf_non_fund_20_percen) {
		this.r111_cbs_100_ccf_non_fund_20_percen = r111_cbs_100_ccf_non_fund_20_percen;
	}
	public BigDecimal getR111_cbs_100_ccf_non_fund_50_percen() {
		return r111_cbs_100_ccf_non_fund_50_percen;
	}
	public void setR111_cbs_100_ccf_non_fund_50_percen(BigDecimal r111_cbs_100_ccf_non_fund_50_percen) {
		this.r111_cbs_100_ccf_non_fund_50_percen = r111_cbs_100_ccf_non_fund_50_percen;
	}
	public BigDecimal getR111_cbs_100_ccf_non_fund_100_percen() {
		return r111_cbs_100_ccf_non_fund_100_percen;
	}
	public void setR111_cbs_100_ccf_non_fund_100_percen(BigDecimal r111_cbs_100_ccf_non_fund_100_percen) {
		this.r111_cbs_100_ccf_non_fund_100_percen = r111_cbs_100_ccf_non_fund_100_percen;
	}
	public BigDecimal getR111_cbs_100_ccf_fund_0_percen() {
		return r111_cbs_100_ccf_fund_0_percen;
	}
	public void setR111_cbs_100_ccf_fund_0_percen(BigDecimal r111_cbs_100_ccf_fund_0_percen) {
		this.r111_cbs_100_ccf_fund_0_percen = r111_cbs_100_ccf_fund_0_percen;
	}
	public BigDecimal getR111_cbs_100_ccf_fund_20_percen() {
		return r111_cbs_100_ccf_fund_20_percen;
	}
	public void setR111_cbs_100_ccf_fund_20_percen(BigDecimal r111_cbs_100_ccf_fund_20_percen) {
		this.r111_cbs_100_ccf_fund_20_percen = r111_cbs_100_ccf_fund_20_percen;
	}
	public BigDecimal getR111_cbs_100_ccf_fund_50_percen() {
		return r111_cbs_100_ccf_fund_50_percen;
	}
	public void setR111_cbs_100_ccf_fund_50_percen(BigDecimal r111_cbs_100_ccf_fund_50_percen) {
		this.r111_cbs_100_ccf_fund_50_percen = r111_cbs_100_ccf_fund_50_percen;
	}
	public BigDecimal getR111_cbs_100_ccf_fund_100_percen() {
		return r111_cbs_100_ccf_fund_100_percen;
	}
	public void setR111_cbs_100_ccf_fund_100_percen(BigDecimal r111_cbs_100_ccf_fund_100_percen) {
		this.r111_cbs_100_ccf_fund_100_percen = r111_cbs_100_ccf_fund_100_percen;
	}
	public BigDecimal getR111_cbs_100_ccf_non_fund_und_0_percen() {
		return r111_cbs_100_ccf_non_fund_und_0_percen;
	}
	public void setR111_cbs_100_ccf_non_fund_und_0_percen(BigDecimal r111_cbs_100_ccf_non_fund_und_0_percen) {
		this.r111_cbs_100_ccf_non_fund_und_0_percen = r111_cbs_100_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR111_cbs_100_ccf_non_fund_und_20_percen() {
		return r111_cbs_100_ccf_non_fund_und_20_percen;
	}
	public void setR111_cbs_100_ccf_non_fund_und_20_percen(BigDecimal r111_cbs_100_ccf_non_fund_und_20_percen) {
		this.r111_cbs_100_ccf_non_fund_und_20_percen = r111_cbs_100_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR111_cbs_100_ccf_non_fund_und_50_percen() {
		return r111_cbs_100_ccf_non_fund_und_50_percen;
	}
	public void setR111_cbs_100_ccf_non_fund_und_50_percen(BigDecimal r111_cbs_100_ccf_non_fund_und_50_percen) {
		this.r111_cbs_100_ccf_non_fund_und_50_percen = r111_cbs_100_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR111_cbs_100_ccf_non_fund_und_100_percen() {
		return r111_cbs_100_ccf_non_fund_und_100_percen;
	}
	public void setR111_cbs_100_ccf_non_fund_und_100_percen(BigDecimal r111_cbs_100_ccf_non_fund_und_100_percen) {
		this.r111_cbs_100_ccf_non_fund_und_100_percen = r111_cbs_100_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR112_cbs_150_total_0_percen() {
		return r112_cbs_150_total_0_percen;
	}
	public void setR112_cbs_150_total_0_percen(BigDecimal r112_cbs_150_total_0_percen) {
		this.r112_cbs_150_total_0_percen = r112_cbs_150_total_0_percen;
	}
	public BigDecimal getR112_cbs_150_total_20_percen() {
		return r112_cbs_150_total_20_percen;
	}
	public void setR112_cbs_150_total_20_percen(BigDecimal r112_cbs_150_total_20_percen) {
		this.r112_cbs_150_total_20_percen = r112_cbs_150_total_20_percen;
	}
	public BigDecimal getR112_cbs_150_total_50_percen() {
		return r112_cbs_150_total_50_percen;
	}
	public void setR112_cbs_150_total_50_percen(BigDecimal r112_cbs_150_total_50_percen) {
		this.r112_cbs_150_total_50_percen = r112_cbs_150_total_50_percen;
	}
	public BigDecimal getR112_cbs_150_total_100_percen() {
		return r112_cbs_150_total_100_percen;
	}
	public void setR112_cbs_150_total_100_percen(BigDecimal r112_cbs_150_total_100_percen) {
		this.r112_cbs_150_total_100_percen = r112_cbs_150_total_100_percen;
	}
	public BigDecimal getR112_cbs_150_ccf_non_fund_0_percen() {
		return r112_cbs_150_ccf_non_fund_0_percen;
	}
	public void setR112_cbs_150_ccf_non_fund_0_percen(BigDecimal r112_cbs_150_ccf_non_fund_0_percen) {
		this.r112_cbs_150_ccf_non_fund_0_percen = r112_cbs_150_ccf_non_fund_0_percen;
	}
	public BigDecimal getR112_cbs_150_ccf_non_fund_20_percen() {
		return r112_cbs_150_ccf_non_fund_20_percen;
	}
	public void setR112_cbs_150_ccf_non_fund_20_percen(BigDecimal r112_cbs_150_ccf_non_fund_20_percen) {
		this.r112_cbs_150_ccf_non_fund_20_percen = r112_cbs_150_ccf_non_fund_20_percen;
	}
	public BigDecimal getR112_cbs_150_ccf_non_fund_50_percen() {
		return r112_cbs_150_ccf_non_fund_50_percen;
	}
	public void setR112_cbs_150_ccf_non_fund_50_percen(BigDecimal r112_cbs_150_ccf_non_fund_50_percen) {
		this.r112_cbs_150_ccf_non_fund_50_percen = r112_cbs_150_ccf_non_fund_50_percen;
	}
	public BigDecimal getR112_cbs_150_ccf_non_fund_100_percen() {
		return r112_cbs_150_ccf_non_fund_100_percen;
	}
	public void setR112_cbs_150_ccf_non_fund_100_percen(BigDecimal r112_cbs_150_ccf_non_fund_100_percen) {
		this.r112_cbs_150_ccf_non_fund_100_percen = r112_cbs_150_ccf_non_fund_100_percen;
	}
	public BigDecimal getR112_cbs_150_ccf_fund_0_percen() {
		return r112_cbs_150_ccf_fund_0_percen;
	}
	public void setR112_cbs_150_ccf_fund_0_percen(BigDecimal r112_cbs_150_ccf_fund_0_percen) {
		this.r112_cbs_150_ccf_fund_0_percen = r112_cbs_150_ccf_fund_0_percen;
	}
	public BigDecimal getR112_cbs_150_ccf_fund_20_percen() {
		return r112_cbs_150_ccf_fund_20_percen;
	}
	public void setR112_cbs_150_ccf_fund_20_percen(BigDecimal r112_cbs_150_ccf_fund_20_percen) {
		this.r112_cbs_150_ccf_fund_20_percen = r112_cbs_150_ccf_fund_20_percen;
	}
	public BigDecimal getR112_cbs_150_ccf_fund_50_percen() {
		return r112_cbs_150_ccf_fund_50_percen;
	}
	public void setR112_cbs_150_ccf_fund_50_percen(BigDecimal r112_cbs_150_ccf_fund_50_percen) {
		this.r112_cbs_150_ccf_fund_50_percen = r112_cbs_150_ccf_fund_50_percen;
	}
	public BigDecimal getR112_cbs_150_ccf_fund_100_percen() {
		return r112_cbs_150_ccf_fund_100_percen;
	}
	public void setR112_cbs_150_ccf_fund_100_percen(BigDecimal r112_cbs_150_ccf_fund_100_percen) {
		this.r112_cbs_150_ccf_fund_100_percen = r112_cbs_150_ccf_fund_100_percen;
	}
	public BigDecimal getR112_cbs_150_ccf_non_fund_und_0_percen() {
		return r112_cbs_150_ccf_non_fund_und_0_percen;
	}
	public void setR112_cbs_150_ccf_non_fund_und_0_percen(BigDecimal r112_cbs_150_ccf_non_fund_und_0_percen) {
		this.r112_cbs_150_ccf_non_fund_und_0_percen = r112_cbs_150_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR112_cbs_150_ccf_non_fund_und_20_percen() {
		return r112_cbs_150_ccf_non_fund_und_20_percen;
	}
	public void setR112_cbs_150_ccf_non_fund_und_20_percen(BigDecimal r112_cbs_150_ccf_non_fund_und_20_percen) {
		this.r112_cbs_150_ccf_non_fund_und_20_percen = r112_cbs_150_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR112_cbs_150_ccf_non_fund_und_50_percen() {
		return r112_cbs_150_ccf_non_fund_und_50_percen;
	}
	public void setR112_cbs_150_ccf_non_fund_und_50_percen(BigDecimal r112_cbs_150_ccf_non_fund_und_50_percen) {
		this.r112_cbs_150_ccf_non_fund_und_50_percen = r112_cbs_150_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR112_cbs_150_ccf_non_fund_und_100_percen() {
		return r112_cbs_150_ccf_non_fund_und_100_percen;
	}
	public void setR112_cbs_150_ccf_non_fund_und_100_percen(BigDecimal r112_cbs_150_ccf_non_fund_und_100_percen) {
		this.r112_cbs_150_ccf_non_fund_und_100_percen = r112_cbs_150_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR113_cre_0_total_0_percen() {
		return r113_cre_0_total_0_percen;
	}
	public void setR113_cre_0_total_0_percen(BigDecimal r113_cre_0_total_0_percen) {
		this.r113_cre_0_total_0_percen = r113_cre_0_total_0_percen;
	}
	public BigDecimal getR113_cre_0_total_20_percen() {
		return r113_cre_0_total_20_percen;
	}
	public void setR113_cre_0_total_20_percen(BigDecimal r113_cre_0_total_20_percen) {
		this.r113_cre_0_total_20_percen = r113_cre_0_total_20_percen;
	}
	public BigDecimal getR113_cre_0_total_50_percen() {
		return r113_cre_0_total_50_percen;
	}
	public void setR113_cre_0_total_50_percen(BigDecimal r113_cre_0_total_50_percen) {
		this.r113_cre_0_total_50_percen = r113_cre_0_total_50_percen;
	}
	public BigDecimal getR113_cre_0_total_100_percen() {
		return r113_cre_0_total_100_percen;
	}
	public void setR113_cre_0_total_100_percen(BigDecimal r113_cre_0_total_100_percen) {
		this.r113_cre_0_total_100_percen = r113_cre_0_total_100_percen;
	}
	public BigDecimal getR113_cre_0_ccf_non_fund_0_percen() {
		return r113_cre_0_ccf_non_fund_0_percen;
	}
	public void setR113_cre_0_ccf_non_fund_0_percen(BigDecimal r113_cre_0_ccf_non_fund_0_percen) {
		this.r113_cre_0_ccf_non_fund_0_percen = r113_cre_0_ccf_non_fund_0_percen;
	}
	public BigDecimal getR113_cre_0_ccf_non_fund_20_percen() {
		return r113_cre_0_ccf_non_fund_20_percen;
	}
	public void setR113_cre_0_ccf_non_fund_20_percen(BigDecimal r113_cre_0_ccf_non_fund_20_percen) {
		this.r113_cre_0_ccf_non_fund_20_percen = r113_cre_0_ccf_non_fund_20_percen;
	}
	public BigDecimal getR113_cre_0_ccf_non_fund_50_percen() {
		return r113_cre_0_ccf_non_fund_50_percen;
	}
	public void setR113_cre_0_ccf_non_fund_50_percen(BigDecimal r113_cre_0_ccf_non_fund_50_percen) {
		this.r113_cre_0_ccf_non_fund_50_percen = r113_cre_0_ccf_non_fund_50_percen;
	}
	public BigDecimal getR113_cre_0_ccf_non_fund_100_percen() {
		return r113_cre_0_ccf_non_fund_100_percen;
	}
	public void setR113_cre_0_ccf_non_fund_100_percen(BigDecimal r113_cre_0_ccf_non_fund_100_percen) {
		this.r113_cre_0_ccf_non_fund_100_percen = r113_cre_0_ccf_non_fund_100_percen;
	}
	public BigDecimal getR113_cre_0_ccf_fund_0_percen() {
		return r113_cre_0_ccf_fund_0_percen;
	}
	public void setR113_cre_0_ccf_fund_0_percen(BigDecimal r113_cre_0_ccf_fund_0_percen) {
		this.r113_cre_0_ccf_fund_0_percen = r113_cre_0_ccf_fund_0_percen;
	}
	public BigDecimal getR113_cre_0_ccf_fund_20_percen() {
		return r113_cre_0_ccf_fund_20_percen;
	}
	public void setR113_cre_0_ccf_fund_20_percen(BigDecimal r113_cre_0_ccf_fund_20_percen) {
		this.r113_cre_0_ccf_fund_20_percen = r113_cre_0_ccf_fund_20_percen;
	}
	public BigDecimal getR113_cre_0_ccf_fund_50_percen() {
		return r113_cre_0_ccf_fund_50_percen;
	}
	public void setR113_cre_0_ccf_fund_50_percen(BigDecimal r113_cre_0_ccf_fund_50_percen) {
		this.r113_cre_0_ccf_fund_50_percen = r113_cre_0_ccf_fund_50_percen;
	}
	public BigDecimal getR113_cre_0_ccf_fund_100_percen() {
		return r113_cre_0_ccf_fund_100_percen;
	}
	public void setR113_cre_0_ccf_fund_100_percen(BigDecimal r113_cre_0_ccf_fund_100_percen) {
		this.r113_cre_0_ccf_fund_100_percen = r113_cre_0_ccf_fund_100_percen;
	}
	public BigDecimal getR113_cre_0_ccf_non_fund_und_0_percen() {
		return r113_cre_0_ccf_non_fund_und_0_percen;
	}
	public void setR113_cre_0_ccf_non_fund_und_0_percen(BigDecimal r113_cre_0_ccf_non_fund_und_0_percen) {
		this.r113_cre_0_ccf_non_fund_und_0_percen = r113_cre_0_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR113_cre_0_ccf_non_fund_und_20_percen() {
		return r113_cre_0_ccf_non_fund_und_20_percen;
	}
	public void setR113_cre_0_ccf_non_fund_und_20_percen(BigDecimal r113_cre_0_ccf_non_fund_und_20_percen) {
		this.r113_cre_0_ccf_non_fund_und_20_percen = r113_cre_0_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR113_cre_0_ccf_non_fund_und_50_percen() {
		return r113_cre_0_ccf_non_fund_und_50_percen;
	}
	public void setR113_cre_0_ccf_non_fund_und_50_percen(BigDecimal r113_cre_0_ccf_non_fund_und_50_percen) {
		this.r113_cre_0_ccf_non_fund_und_50_percen = r113_cre_0_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR113_cre_0_ccf_non_fund_und_100_percen() {
		return r113_cre_0_ccf_non_fund_und_100_percen;
	}
	public void setR113_cre_0_ccf_non_fund_und_100_percen(BigDecimal r113_cre_0_ccf_non_fund_und_100_percen) {
		this.r113_cre_0_ccf_non_fund_und_100_percen = r113_cre_0_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR114_cre_20_total_0_percen() {
		return r114_cre_20_total_0_percen;
	}
	public void setR114_cre_20_total_0_percen(BigDecimal r114_cre_20_total_0_percen) {
		this.r114_cre_20_total_0_percen = r114_cre_20_total_0_percen;
	}
	public BigDecimal getR114_cre_20_total_20_percen() {
		return r114_cre_20_total_20_percen;
	}
	public void setR114_cre_20_total_20_percen(BigDecimal r114_cre_20_total_20_percen) {
		this.r114_cre_20_total_20_percen = r114_cre_20_total_20_percen;
	}
	public BigDecimal getR114_cre_20_total_50_percen() {
		return r114_cre_20_total_50_percen;
	}
	public void setR114_cre_20_total_50_percen(BigDecimal r114_cre_20_total_50_percen) {
		this.r114_cre_20_total_50_percen = r114_cre_20_total_50_percen;
	}
	public BigDecimal getR114_cre_20_total_100_percen() {
		return r114_cre_20_total_100_percen;
	}
	public void setR114_cre_20_total_100_percen(BigDecimal r114_cre_20_total_100_percen) {
		this.r114_cre_20_total_100_percen = r114_cre_20_total_100_percen;
	}
	public BigDecimal getR114_cre_20_ccf_non_fund_0_percen() {
		return r114_cre_20_ccf_non_fund_0_percen;
	}
	public void setR114_cre_20_ccf_non_fund_0_percen(BigDecimal r114_cre_20_ccf_non_fund_0_percen) {
		this.r114_cre_20_ccf_non_fund_0_percen = r114_cre_20_ccf_non_fund_0_percen;
	}
	public BigDecimal getR114_cre_20_ccf_non_fund_20_percen() {
		return r114_cre_20_ccf_non_fund_20_percen;
	}
	public void setR114_cre_20_ccf_non_fund_20_percen(BigDecimal r114_cre_20_ccf_non_fund_20_percen) {
		this.r114_cre_20_ccf_non_fund_20_percen = r114_cre_20_ccf_non_fund_20_percen;
	}
	public BigDecimal getR114_cre_20_ccf_non_fund_50_percen() {
		return r114_cre_20_ccf_non_fund_50_percen;
	}
	public void setR114_cre_20_ccf_non_fund_50_percen(BigDecimal r114_cre_20_ccf_non_fund_50_percen) {
		this.r114_cre_20_ccf_non_fund_50_percen = r114_cre_20_ccf_non_fund_50_percen;
	}
	public BigDecimal getR114_cre_20_ccf_non_fund_100_percen() {
		return r114_cre_20_ccf_non_fund_100_percen;
	}
	public void setR114_cre_20_ccf_non_fund_100_percen(BigDecimal r114_cre_20_ccf_non_fund_100_percen) {
		this.r114_cre_20_ccf_non_fund_100_percen = r114_cre_20_ccf_non_fund_100_percen;
	}
	public BigDecimal getR114_cre_20_ccf_fund_0_percen() {
		return r114_cre_20_ccf_fund_0_percen;
	}
	public void setR114_cre_20_ccf_fund_0_percen(BigDecimal r114_cre_20_ccf_fund_0_percen) {
		this.r114_cre_20_ccf_fund_0_percen = r114_cre_20_ccf_fund_0_percen;
	}
	public BigDecimal getR114_cre_20_ccf_fund_20_percen() {
		return r114_cre_20_ccf_fund_20_percen;
	}
	public void setR114_cre_20_ccf_fund_20_percen(BigDecimal r114_cre_20_ccf_fund_20_percen) {
		this.r114_cre_20_ccf_fund_20_percen = r114_cre_20_ccf_fund_20_percen;
	}
	public BigDecimal getR114_cre_20_ccf_fund_50_percen() {
		return r114_cre_20_ccf_fund_50_percen;
	}
	public void setR114_cre_20_ccf_fund_50_percen(BigDecimal r114_cre_20_ccf_fund_50_percen) {
		this.r114_cre_20_ccf_fund_50_percen = r114_cre_20_ccf_fund_50_percen;
	}
	public BigDecimal getR114_cre_20_ccf_fund_100_percen() {
		return r114_cre_20_ccf_fund_100_percen;
	}
	public void setR114_cre_20_ccf_fund_100_percen(BigDecimal r114_cre_20_ccf_fund_100_percen) {
		this.r114_cre_20_ccf_fund_100_percen = r114_cre_20_ccf_fund_100_percen;
	}
	public BigDecimal getR114_cre_20_ccf_non_fund_und_0_percen() {
		return r114_cre_20_ccf_non_fund_und_0_percen;
	}
	public void setR114_cre_20_ccf_non_fund_und_0_percen(BigDecimal r114_cre_20_ccf_non_fund_und_0_percen) {
		this.r114_cre_20_ccf_non_fund_und_0_percen = r114_cre_20_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR114_cre_20_ccf_non_fund_und_20_percen() {
		return r114_cre_20_ccf_non_fund_und_20_percen;
	}
	public void setR114_cre_20_ccf_non_fund_und_20_percen(BigDecimal r114_cre_20_ccf_non_fund_und_20_percen) {
		this.r114_cre_20_ccf_non_fund_und_20_percen = r114_cre_20_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR114_cre_20_ccf_non_fund_und_50_percen() {
		return r114_cre_20_ccf_non_fund_und_50_percen;
	}
	public void setR114_cre_20_ccf_non_fund_und_50_percen(BigDecimal r114_cre_20_ccf_non_fund_und_50_percen) {
		this.r114_cre_20_ccf_non_fund_und_50_percen = r114_cre_20_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR114_cre_20_ccf_non_fund_und_100_percen() {
		return r114_cre_20_ccf_non_fund_und_100_percen;
	}
	public void setR114_cre_20_ccf_non_fund_und_100_percen(BigDecimal r114_cre_20_ccf_non_fund_und_100_percen) {
		this.r114_cre_20_ccf_non_fund_und_100_percen = r114_cre_20_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR115_cre_50_total_0_percen() {
		return r115_cre_50_total_0_percen;
	}
	public void setR115_cre_50_total_0_percen(BigDecimal r115_cre_50_total_0_percen) {
		this.r115_cre_50_total_0_percen = r115_cre_50_total_0_percen;
	}
	public BigDecimal getR115_cre_50_total_20_percen() {
		return r115_cre_50_total_20_percen;
	}
	public void setR115_cre_50_total_20_percen(BigDecimal r115_cre_50_total_20_percen) {
		this.r115_cre_50_total_20_percen = r115_cre_50_total_20_percen;
	}
	public BigDecimal getR115_cre_50_total_50_percen() {
		return r115_cre_50_total_50_percen;
	}
	public void setR115_cre_50_total_50_percen(BigDecimal r115_cre_50_total_50_percen) {
		this.r115_cre_50_total_50_percen = r115_cre_50_total_50_percen;
	}
	public BigDecimal getR115_cre_50_total_100_percen() {
		return r115_cre_50_total_100_percen;
	}
	public void setR115_cre_50_total_100_percen(BigDecimal r115_cre_50_total_100_percen) {
		this.r115_cre_50_total_100_percen = r115_cre_50_total_100_percen;
	}
	public BigDecimal getR115_cre_50_ccf_non_fund_0_percen() {
		return r115_cre_50_ccf_non_fund_0_percen;
	}
	public void setR115_cre_50_ccf_non_fund_0_percen(BigDecimal r115_cre_50_ccf_non_fund_0_percen) {
		this.r115_cre_50_ccf_non_fund_0_percen = r115_cre_50_ccf_non_fund_0_percen;
	}
	public BigDecimal getR115_cre_50_ccf_non_fund_20_percen() {
		return r115_cre_50_ccf_non_fund_20_percen;
	}
	public void setR115_cre_50_ccf_non_fund_20_percen(BigDecimal r115_cre_50_ccf_non_fund_20_percen) {
		this.r115_cre_50_ccf_non_fund_20_percen = r115_cre_50_ccf_non_fund_20_percen;
	}
	public BigDecimal getR115_cre_50_ccf_non_fund_50_percen() {
		return r115_cre_50_ccf_non_fund_50_percen;
	}
	public void setR115_cre_50_ccf_non_fund_50_percen(BigDecimal r115_cre_50_ccf_non_fund_50_percen) {
		this.r115_cre_50_ccf_non_fund_50_percen = r115_cre_50_ccf_non_fund_50_percen;
	}
	public BigDecimal getR115_cre_50_ccf_non_fund_100_percen() {
		return r115_cre_50_ccf_non_fund_100_percen;
	}
	public void setR115_cre_50_ccf_non_fund_100_percen(BigDecimal r115_cre_50_ccf_non_fund_100_percen) {
		this.r115_cre_50_ccf_non_fund_100_percen = r115_cre_50_ccf_non_fund_100_percen;
	}
	public BigDecimal getR115_cre_50_ccf_fund_0_percen() {
		return r115_cre_50_ccf_fund_0_percen;
	}
	public void setR115_cre_50_ccf_fund_0_percen(BigDecimal r115_cre_50_ccf_fund_0_percen) {
		this.r115_cre_50_ccf_fund_0_percen = r115_cre_50_ccf_fund_0_percen;
	}
	public BigDecimal getR115_cre_50_ccf_fund_20_percen() {
		return r115_cre_50_ccf_fund_20_percen;
	}
	public void setR115_cre_50_ccf_fund_20_percen(BigDecimal r115_cre_50_ccf_fund_20_percen) {
		this.r115_cre_50_ccf_fund_20_percen = r115_cre_50_ccf_fund_20_percen;
	}
	public BigDecimal getR115_cre_50_ccf_fund_50_percen() {
		return r115_cre_50_ccf_fund_50_percen;
	}
	public void setR115_cre_50_ccf_fund_50_percen(BigDecimal r115_cre_50_ccf_fund_50_percen) {
		this.r115_cre_50_ccf_fund_50_percen = r115_cre_50_ccf_fund_50_percen;
	}
	public BigDecimal getR115_cre_50_ccf_fund_100_percen() {
		return r115_cre_50_ccf_fund_100_percen;
	}
	public void setR115_cre_50_ccf_fund_100_percen(BigDecimal r115_cre_50_ccf_fund_100_percen) {
		this.r115_cre_50_ccf_fund_100_percen = r115_cre_50_ccf_fund_100_percen;
	}
	public BigDecimal getR115_cre_50_ccf_non_fund_und_0_percen() {
		return r115_cre_50_ccf_non_fund_und_0_percen;
	}
	public void setR115_cre_50_ccf_non_fund_und_0_percen(BigDecimal r115_cre_50_ccf_non_fund_und_0_percen) {
		this.r115_cre_50_ccf_non_fund_und_0_percen = r115_cre_50_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR115_cre_50_ccf_non_fund_und_20_percen() {
		return r115_cre_50_ccf_non_fund_und_20_percen;
	}
	public void setR115_cre_50_ccf_non_fund_und_20_percen(BigDecimal r115_cre_50_ccf_non_fund_und_20_percen) {
		this.r115_cre_50_ccf_non_fund_und_20_percen = r115_cre_50_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR115_cre_50_ccf_non_fund_und_50_percen() {
		return r115_cre_50_ccf_non_fund_und_50_percen;
	}
	public void setR115_cre_50_ccf_non_fund_und_50_percen(BigDecimal r115_cre_50_ccf_non_fund_und_50_percen) {
		this.r115_cre_50_ccf_non_fund_und_50_percen = r115_cre_50_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR115_cre_50_ccf_non_fund_und_100_percen() {
		return r115_cre_50_ccf_non_fund_und_100_percen;
	}
	public void setR115_cre_50_ccf_non_fund_und_100_percen(BigDecimal r115_cre_50_ccf_non_fund_und_100_percen) {
		this.r115_cre_50_ccf_non_fund_und_100_percen = r115_cre_50_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR116_cre_100_total_0_percen() {
		return r116_cre_100_total_0_percen;
	}
	public void setR116_cre_100_total_0_percen(BigDecimal r116_cre_100_total_0_percen) {
		this.r116_cre_100_total_0_percen = r116_cre_100_total_0_percen;
	}
	public BigDecimal getR116_cre_100_total_20_percen() {
		return r116_cre_100_total_20_percen;
	}
	public void setR116_cre_100_total_20_percen(BigDecimal r116_cre_100_total_20_percen) {
		this.r116_cre_100_total_20_percen = r116_cre_100_total_20_percen;
	}
	public BigDecimal getR116_cre_100_total_50_percen() {
		return r116_cre_100_total_50_percen;
	}
	public void setR116_cre_100_total_50_percen(BigDecimal r116_cre_100_total_50_percen) {
		this.r116_cre_100_total_50_percen = r116_cre_100_total_50_percen;
	}
	public BigDecimal getR116_cre_100_total_100_percen() {
		return r116_cre_100_total_100_percen;
	}
	public void setR116_cre_100_total_100_percen(BigDecimal r116_cre_100_total_100_percen) {
		this.r116_cre_100_total_100_percen = r116_cre_100_total_100_percen;
	}
	public BigDecimal getR116_cre_100_ccf_non_fund_0_percen() {
		return r116_cre_100_ccf_non_fund_0_percen;
	}
	public void setR116_cre_100_ccf_non_fund_0_percen(BigDecimal r116_cre_100_ccf_non_fund_0_percen) {
		this.r116_cre_100_ccf_non_fund_0_percen = r116_cre_100_ccf_non_fund_0_percen;
	}
	public BigDecimal getR116_cre_100_ccf_non_fund_20_percen() {
		return r116_cre_100_ccf_non_fund_20_percen;
	}
	public void setR116_cre_100_ccf_non_fund_20_percen(BigDecimal r116_cre_100_ccf_non_fund_20_percen) {
		this.r116_cre_100_ccf_non_fund_20_percen = r116_cre_100_ccf_non_fund_20_percen;
	}
	public BigDecimal getR116_cre_100_ccf_non_fund_50_percen() {
		return r116_cre_100_ccf_non_fund_50_percen;
	}
	public void setR116_cre_100_ccf_non_fund_50_percen(BigDecimal r116_cre_100_ccf_non_fund_50_percen) {
		this.r116_cre_100_ccf_non_fund_50_percen = r116_cre_100_ccf_non_fund_50_percen;
	}
	public BigDecimal getR116_cre_100_ccf_non_fund_100_percen() {
		return r116_cre_100_ccf_non_fund_100_percen;
	}
	public void setR116_cre_100_ccf_non_fund_100_percen(BigDecimal r116_cre_100_ccf_non_fund_100_percen) {
		this.r116_cre_100_ccf_non_fund_100_percen = r116_cre_100_ccf_non_fund_100_percen;
	}
	public BigDecimal getR116_cre_100_ccf_fund_0_percen() {
		return r116_cre_100_ccf_fund_0_percen;
	}
	public void setR116_cre_100_ccf_fund_0_percen(BigDecimal r116_cre_100_ccf_fund_0_percen) {
		this.r116_cre_100_ccf_fund_0_percen = r116_cre_100_ccf_fund_0_percen;
	}
	public BigDecimal getR116_cre_100_ccf_fund_20_percen() {
		return r116_cre_100_ccf_fund_20_percen;
	}
	public void setR116_cre_100_ccf_fund_20_percen(BigDecimal r116_cre_100_ccf_fund_20_percen) {
		this.r116_cre_100_ccf_fund_20_percen = r116_cre_100_ccf_fund_20_percen;
	}
	public BigDecimal getR116_cre_100_ccf_fund_50_percen() {
		return r116_cre_100_ccf_fund_50_percen;
	}
	public void setR116_cre_100_ccf_fund_50_percen(BigDecimal r116_cre_100_ccf_fund_50_percen) {
		this.r116_cre_100_ccf_fund_50_percen = r116_cre_100_ccf_fund_50_percen;
	}
	public BigDecimal getR116_cre_100_ccf_fund_100_percen() {
		return r116_cre_100_ccf_fund_100_percen;
	}
	public void setR116_cre_100_ccf_fund_100_percen(BigDecimal r116_cre_100_ccf_fund_100_percen) {
		this.r116_cre_100_ccf_fund_100_percen = r116_cre_100_ccf_fund_100_percen;
	}
	public BigDecimal getR116_cre_100_ccf_non_fund_und_0_percen() {
		return r116_cre_100_ccf_non_fund_und_0_percen;
	}
	public void setR116_cre_100_ccf_non_fund_und_0_percen(BigDecimal r116_cre_100_ccf_non_fund_und_0_percen) {
		this.r116_cre_100_ccf_non_fund_und_0_percen = r116_cre_100_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR116_cre_100_ccf_non_fund_und_20_percen() {
		return r116_cre_100_ccf_non_fund_und_20_percen;
	}
	public void setR116_cre_100_ccf_non_fund_und_20_percen(BigDecimal r116_cre_100_ccf_non_fund_und_20_percen) {
		this.r116_cre_100_ccf_non_fund_und_20_percen = r116_cre_100_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR116_cre_100_ccf_non_fund_und_50_percen() {
		return r116_cre_100_ccf_non_fund_und_50_percen;
	}
	public void setR116_cre_100_ccf_non_fund_und_50_percen(BigDecimal r116_cre_100_ccf_non_fund_und_50_percen) {
		this.r116_cre_100_ccf_non_fund_und_50_percen = r116_cre_100_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR116_cre_100_ccf_non_fund_und_100_percen() {
		return r116_cre_100_ccf_non_fund_und_100_percen;
	}
	public void setR116_cre_100_ccf_non_fund_und_100_percen(BigDecimal r116_cre_100_ccf_non_fund_und_100_percen) {
		this.r116_cre_100_ccf_non_fund_und_100_percen = r116_cre_100_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR117_cre_150_total_0_percen() {
		return r117_cre_150_total_0_percen;
	}
	public void setR117_cre_150_total_0_percen(BigDecimal r117_cre_150_total_0_percen) {
		this.r117_cre_150_total_0_percen = r117_cre_150_total_0_percen;
	}
	public BigDecimal getR117_cre_150_total_20_percen() {
		return r117_cre_150_total_20_percen;
	}
	public void setR117_cre_150_total_20_percen(BigDecimal r117_cre_150_total_20_percen) {
		this.r117_cre_150_total_20_percen = r117_cre_150_total_20_percen;
	}
	public BigDecimal getR117_cre_150_total_50_percen() {
		return r117_cre_150_total_50_percen;
	}
	public void setR117_cre_150_total_50_percen(BigDecimal r117_cre_150_total_50_percen) {
		this.r117_cre_150_total_50_percen = r117_cre_150_total_50_percen;
	}
	public BigDecimal getR117_cre_150_total_100_percen() {
		return r117_cre_150_total_100_percen;
	}
	public void setR117_cre_150_total_100_percen(BigDecimal r117_cre_150_total_100_percen) {
		this.r117_cre_150_total_100_percen = r117_cre_150_total_100_percen;
	}
	public BigDecimal getR117_cre_150_ccf_non_fund_0_percen() {
		return r117_cre_150_ccf_non_fund_0_percen;
	}
	public void setR117_cre_150_ccf_non_fund_0_percen(BigDecimal r117_cre_150_ccf_non_fund_0_percen) {
		this.r117_cre_150_ccf_non_fund_0_percen = r117_cre_150_ccf_non_fund_0_percen;
	}
	public BigDecimal getR117_cre_150_ccf_non_fund_20_percen() {
		return r117_cre_150_ccf_non_fund_20_percen;
	}
	public void setR117_cre_150_ccf_non_fund_20_percen(BigDecimal r117_cre_150_ccf_non_fund_20_percen) {
		this.r117_cre_150_ccf_non_fund_20_percen = r117_cre_150_ccf_non_fund_20_percen;
	}
	public BigDecimal getR117_cre_150_ccf_non_fund_50_percen() {
		return r117_cre_150_ccf_non_fund_50_percen;
	}
	public void setR117_cre_150_ccf_non_fund_50_percen(BigDecimal r117_cre_150_ccf_non_fund_50_percen) {
		this.r117_cre_150_ccf_non_fund_50_percen = r117_cre_150_ccf_non_fund_50_percen;
	}
	public BigDecimal getR117_cre_150_ccf_non_fund_100_percen() {
		return r117_cre_150_ccf_non_fund_100_percen;
	}
	public void setR117_cre_150_ccf_non_fund_100_percen(BigDecimal r117_cre_150_ccf_non_fund_100_percen) {
		this.r117_cre_150_ccf_non_fund_100_percen = r117_cre_150_ccf_non_fund_100_percen;
	}
	public BigDecimal getR117_cre_150_ccf_fund_0_percen() {
		return r117_cre_150_ccf_fund_0_percen;
	}
	public void setR117_cre_150_ccf_fund_0_percen(BigDecimal r117_cre_150_ccf_fund_0_percen) {
		this.r117_cre_150_ccf_fund_0_percen = r117_cre_150_ccf_fund_0_percen;
	}
	public BigDecimal getR117_cre_150_ccf_fund_20_percen() {
		return r117_cre_150_ccf_fund_20_percen;
	}
	public void setR117_cre_150_ccf_fund_20_percen(BigDecimal r117_cre_150_ccf_fund_20_percen) {
		this.r117_cre_150_ccf_fund_20_percen = r117_cre_150_ccf_fund_20_percen;
	}
	public BigDecimal getR117_cre_150_ccf_fund_50_percen() {
		return r117_cre_150_ccf_fund_50_percen;
	}
	public void setR117_cre_150_ccf_fund_50_percen(BigDecimal r117_cre_150_ccf_fund_50_percen) {
		this.r117_cre_150_ccf_fund_50_percen = r117_cre_150_ccf_fund_50_percen;
	}
	public BigDecimal getR117_cre_150_ccf_fund_100_percen() {
		return r117_cre_150_ccf_fund_100_percen;
	}
	public void setR117_cre_150_ccf_fund_100_percen(BigDecimal r117_cre_150_ccf_fund_100_percen) {
		this.r117_cre_150_ccf_fund_100_percen = r117_cre_150_ccf_fund_100_percen;
	}
	public BigDecimal getR117_cre_150_ccf_non_fund_und_0_percen() {
		return r117_cre_150_ccf_non_fund_und_0_percen;
	}
	public void setR117_cre_150_ccf_non_fund_und_0_percen(BigDecimal r117_cre_150_ccf_non_fund_und_0_percen) {
		this.r117_cre_150_ccf_non_fund_und_0_percen = r117_cre_150_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR117_cre_150_ccf_non_fund_und_20_percen() {
		return r117_cre_150_ccf_non_fund_und_20_percen;
	}
	public void setR117_cre_150_ccf_non_fund_und_20_percen(BigDecimal r117_cre_150_ccf_non_fund_und_20_percen) {
		this.r117_cre_150_ccf_non_fund_und_20_percen = r117_cre_150_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR117_cre_150_ccf_non_fund_und_50_percen() {
		return r117_cre_150_ccf_non_fund_und_50_percen;
	}
	public void setR117_cre_150_ccf_non_fund_und_50_percen(BigDecimal r117_cre_150_ccf_non_fund_und_50_percen) {
		this.r117_cre_150_ccf_non_fund_und_50_percen = r117_cre_150_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR117_cre_150_ccf_non_fund_und_100_percen() {
		return r117_cre_150_ccf_non_fund_und_100_percen;
	}
	public void setR117_cre_150_ccf_non_fund_und_100_percen(BigDecimal r117_cre_150_ccf_non_fund_und_100_percen) {
		this.r117_cre_150_ccf_non_fund_und_100_percen = r117_cre_150_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR118_crt_0_total_0_percen() {
		return r118_crt_0_total_0_percen;
	}
	public void setR118_crt_0_total_0_percen(BigDecimal r118_crt_0_total_0_percen) {
		this.r118_crt_0_total_0_percen = r118_crt_0_total_0_percen;
	}
	public BigDecimal getR118_crt_0_total_20_percen() {
		return r118_crt_0_total_20_percen;
	}
	public void setR118_crt_0_total_20_percen(BigDecimal r118_crt_0_total_20_percen) {
		this.r118_crt_0_total_20_percen = r118_crt_0_total_20_percen;
	}
	public BigDecimal getR118_crt_0_total_50_percen() {
		return r118_crt_0_total_50_percen;
	}
	public void setR118_crt_0_total_50_percen(BigDecimal r118_crt_0_total_50_percen) {
		this.r118_crt_0_total_50_percen = r118_crt_0_total_50_percen;
	}
	public BigDecimal getR118_crt_0_total_100_percen() {
		return r118_crt_0_total_100_percen;
	}
	public void setR118_crt_0_total_100_percen(BigDecimal r118_crt_0_total_100_percen) {
		this.r118_crt_0_total_100_percen = r118_crt_0_total_100_percen;
	}
	public BigDecimal getR118_crt_0_ccf_non_fund_0_percen() {
		return r118_crt_0_ccf_non_fund_0_percen;
	}
	public void setR118_crt_0_ccf_non_fund_0_percen(BigDecimal r118_crt_0_ccf_non_fund_0_percen) {
		this.r118_crt_0_ccf_non_fund_0_percen = r118_crt_0_ccf_non_fund_0_percen;
	}
	public BigDecimal getR118_crt_0_ccf_non_fund_20_percen() {
		return r118_crt_0_ccf_non_fund_20_percen;
	}
	public void setR118_crt_0_ccf_non_fund_20_percen(BigDecimal r118_crt_0_ccf_non_fund_20_percen) {
		this.r118_crt_0_ccf_non_fund_20_percen = r118_crt_0_ccf_non_fund_20_percen;
	}
	public BigDecimal getR118_crt_0_ccf_non_fund_50_percen() {
		return r118_crt_0_ccf_non_fund_50_percen;
	}
	public void setR118_crt_0_ccf_non_fund_50_percen(BigDecimal r118_crt_0_ccf_non_fund_50_percen) {
		this.r118_crt_0_ccf_non_fund_50_percen = r118_crt_0_ccf_non_fund_50_percen;
	}
	public BigDecimal getR118_crt_0_ccf_non_fund_100_percen() {
		return r118_crt_0_ccf_non_fund_100_percen;
	}
	public void setR118_crt_0_ccf_non_fund_100_percen(BigDecimal r118_crt_0_ccf_non_fund_100_percen) {
		this.r118_crt_0_ccf_non_fund_100_percen = r118_crt_0_ccf_non_fund_100_percen;
	}
	public BigDecimal getR118_crt_0_ccf_fund_0_percen() {
		return r118_crt_0_ccf_fund_0_percen;
	}
	public void setR118_crt_0_ccf_fund_0_percen(BigDecimal r118_crt_0_ccf_fund_0_percen) {
		this.r118_crt_0_ccf_fund_0_percen = r118_crt_0_ccf_fund_0_percen;
	}
	public BigDecimal getR118_crt_0_ccf_fund_20_percen() {
		return r118_crt_0_ccf_fund_20_percen;
	}
	public void setR118_crt_0_ccf_fund_20_percen(BigDecimal r118_crt_0_ccf_fund_20_percen) {
		this.r118_crt_0_ccf_fund_20_percen = r118_crt_0_ccf_fund_20_percen;
	}
	public BigDecimal getR118_crt_0_ccf_fund_50_percen() {
		return r118_crt_0_ccf_fund_50_percen;
	}
	public void setR118_crt_0_ccf_fund_50_percen(BigDecimal r118_crt_0_ccf_fund_50_percen) {
		this.r118_crt_0_ccf_fund_50_percen = r118_crt_0_ccf_fund_50_percen;
	}
	public BigDecimal getR118_crt_0_ccf_fund_100_percen() {
		return r118_crt_0_ccf_fund_100_percen;
	}
	public void setR118_crt_0_ccf_fund_100_percen(BigDecimal r118_crt_0_ccf_fund_100_percen) {
		this.r118_crt_0_ccf_fund_100_percen = r118_crt_0_ccf_fund_100_percen;
	}
	public BigDecimal getR118_crt_0_ccf_non_fund_und_0_percen() {
		return r118_crt_0_ccf_non_fund_und_0_percen;
	}
	public void setR118_crt_0_ccf_non_fund_und_0_percen(BigDecimal r118_crt_0_ccf_non_fund_und_0_percen) {
		this.r118_crt_0_ccf_non_fund_und_0_percen = r118_crt_0_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR118_crt_0_ccf_non_fund_und_20_percen() {
		return r118_crt_0_ccf_non_fund_und_20_percen;
	}
	public void setR118_crt_0_ccf_non_fund_und_20_percen(BigDecimal r118_crt_0_ccf_non_fund_und_20_percen) {
		this.r118_crt_0_ccf_non_fund_und_20_percen = r118_crt_0_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR118_crt_0_ccf_non_fund_und_50_percen() {
		return r118_crt_0_ccf_non_fund_und_50_percen;
	}
	public void setR118_crt_0_ccf_non_fund_und_50_percen(BigDecimal r118_crt_0_ccf_non_fund_und_50_percen) {
		this.r118_crt_0_ccf_non_fund_und_50_percen = r118_crt_0_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR118_crt_0_ccf_non_fund_und_100_percen() {
		return r118_crt_0_ccf_non_fund_und_100_percen;
	}
	public void setR118_crt_0_ccf_non_fund_und_100_percen(BigDecimal r118_crt_0_ccf_non_fund_und_100_percen) {
		this.r118_crt_0_ccf_non_fund_und_100_percen = r118_crt_0_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR119_crt_20_total_0_percen() {
		return r119_crt_20_total_0_percen;
	}
	public void setR119_crt_20_total_0_percen(BigDecimal r119_crt_20_total_0_percen) {
		this.r119_crt_20_total_0_percen = r119_crt_20_total_0_percen;
	}
	public BigDecimal getR119_crt_20_total_20_percen() {
		return r119_crt_20_total_20_percen;
	}
	public void setR119_crt_20_total_20_percen(BigDecimal r119_crt_20_total_20_percen) {
		this.r119_crt_20_total_20_percen = r119_crt_20_total_20_percen;
	}
	public BigDecimal getR119_crt_20_total_50_percen() {
		return r119_crt_20_total_50_percen;
	}
	public void setR119_crt_20_total_50_percen(BigDecimal r119_crt_20_total_50_percen) {
		this.r119_crt_20_total_50_percen = r119_crt_20_total_50_percen;
	}
	public BigDecimal getR119_crt_20_total_100_percen() {
		return r119_crt_20_total_100_percen;
	}
	public void setR119_crt_20_total_100_percen(BigDecimal r119_crt_20_total_100_percen) {
		this.r119_crt_20_total_100_percen = r119_crt_20_total_100_percen;
	}
	public BigDecimal getR119_crt_20_ccf_non_fund_0_percen() {
		return r119_crt_20_ccf_non_fund_0_percen;
	}
	public void setR119_crt_20_ccf_non_fund_0_percen(BigDecimal r119_crt_20_ccf_non_fund_0_percen) {
		this.r119_crt_20_ccf_non_fund_0_percen = r119_crt_20_ccf_non_fund_0_percen;
	}
	public BigDecimal getR119_crt_20_ccf_non_fund_20_percen() {
		return r119_crt_20_ccf_non_fund_20_percen;
	}
	public void setR119_crt_20_ccf_non_fund_20_percen(BigDecimal r119_crt_20_ccf_non_fund_20_percen) {
		this.r119_crt_20_ccf_non_fund_20_percen = r119_crt_20_ccf_non_fund_20_percen;
	}
	public BigDecimal getR119_crt_20_ccf_non_fund_50_percen() {
		return r119_crt_20_ccf_non_fund_50_percen;
	}
	public void setR119_crt_20_ccf_non_fund_50_percen(BigDecimal r119_crt_20_ccf_non_fund_50_percen) {
		this.r119_crt_20_ccf_non_fund_50_percen = r119_crt_20_ccf_non_fund_50_percen;
	}
	public BigDecimal getR119_crt_20_ccf_non_fund_100_percen() {
		return r119_crt_20_ccf_non_fund_100_percen;
	}
	public void setR119_crt_20_ccf_non_fund_100_percen(BigDecimal r119_crt_20_ccf_non_fund_100_percen) {
		this.r119_crt_20_ccf_non_fund_100_percen = r119_crt_20_ccf_non_fund_100_percen;
	}
	public BigDecimal getR119_crt_20_ccf_fund_0_percen() {
		return r119_crt_20_ccf_fund_0_percen;
	}
	public void setR119_crt_20_ccf_fund_0_percen(BigDecimal r119_crt_20_ccf_fund_0_percen) {
		this.r119_crt_20_ccf_fund_0_percen = r119_crt_20_ccf_fund_0_percen;
	}
	public BigDecimal getR119_crt_20_ccf_fund_20_percen() {
		return r119_crt_20_ccf_fund_20_percen;
	}
	public void setR119_crt_20_ccf_fund_20_percen(BigDecimal r119_crt_20_ccf_fund_20_percen) {
		this.r119_crt_20_ccf_fund_20_percen = r119_crt_20_ccf_fund_20_percen;
	}
	public BigDecimal getR119_crt_20_ccf_fund_50_percen() {
		return r119_crt_20_ccf_fund_50_percen;
	}
	public void setR119_crt_20_ccf_fund_50_percen(BigDecimal r119_crt_20_ccf_fund_50_percen) {
		this.r119_crt_20_ccf_fund_50_percen = r119_crt_20_ccf_fund_50_percen;
	}
	public BigDecimal getR119_crt_20_ccf_fund_100_percen() {
		return r119_crt_20_ccf_fund_100_percen;
	}
	public void setR119_crt_20_ccf_fund_100_percen(BigDecimal r119_crt_20_ccf_fund_100_percen) {
		this.r119_crt_20_ccf_fund_100_percen = r119_crt_20_ccf_fund_100_percen;
	}
	public BigDecimal getR119_crt_20_ccf_non_fund_und_0_percen() {
		return r119_crt_20_ccf_non_fund_und_0_percen;
	}
	public void setR119_crt_20_ccf_non_fund_und_0_percen(BigDecimal r119_crt_20_ccf_non_fund_und_0_percen) {
		this.r119_crt_20_ccf_non_fund_und_0_percen = r119_crt_20_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR119_crt_20_ccf_non_fund_und_20_percen() {
		return r119_crt_20_ccf_non_fund_und_20_percen;
	}
	public void setR119_crt_20_ccf_non_fund_und_20_percen(BigDecimal r119_crt_20_ccf_non_fund_und_20_percen) {
		this.r119_crt_20_ccf_non_fund_und_20_percen = r119_crt_20_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR119_crt_20_ccf_non_fund_und_50_percen() {
		return r119_crt_20_ccf_non_fund_und_50_percen;
	}
	public void setR119_crt_20_ccf_non_fund_und_50_percen(BigDecimal r119_crt_20_ccf_non_fund_und_50_percen) {
		this.r119_crt_20_ccf_non_fund_und_50_percen = r119_crt_20_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR119_crt_20_ccf_non_fund_und_100_percen() {
		return r119_crt_20_ccf_non_fund_und_100_percen;
	}
	public void setR119_crt_20_ccf_non_fund_und_100_percen(BigDecimal r119_crt_20_ccf_non_fund_und_100_percen) {
		this.r119_crt_20_ccf_non_fund_und_100_percen = r119_crt_20_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR120_crt_50_total_0_percen() {
		return r120_crt_50_total_0_percen;
	}
	public void setR120_crt_50_total_0_percen(BigDecimal r120_crt_50_total_0_percen) {
		this.r120_crt_50_total_0_percen = r120_crt_50_total_0_percen;
	}
	public BigDecimal getR120_crt_50_total_20_percen() {
		return r120_crt_50_total_20_percen;
	}
	public void setR120_crt_50_total_20_percen(BigDecimal r120_crt_50_total_20_percen) {
		this.r120_crt_50_total_20_percen = r120_crt_50_total_20_percen;
	}
	public BigDecimal getR120_crt_50_total_50_percen() {
		return r120_crt_50_total_50_percen;
	}
	public void setR120_crt_50_total_50_percen(BigDecimal r120_crt_50_total_50_percen) {
		this.r120_crt_50_total_50_percen = r120_crt_50_total_50_percen;
	}
	public BigDecimal getR120_crt_50_total_100_percen() {
		return r120_crt_50_total_100_percen;
	}
	public void setR120_crt_50_total_100_percen(BigDecimal r120_crt_50_total_100_percen) {
		this.r120_crt_50_total_100_percen = r120_crt_50_total_100_percen;
	}
	public BigDecimal getR120_crt_50_ccf_non_fund_0_percen() {
		return r120_crt_50_ccf_non_fund_0_percen;
	}
	public void setR120_crt_50_ccf_non_fund_0_percen(BigDecimal r120_crt_50_ccf_non_fund_0_percen) {
		this.r120_crt_50_ccf_non_fund_0_percen = r120_crt_50_ccf_non_fund_0_percen;
	}
	public BigDecimal getR120_crt_50_ccf_non_fund_20_percen() {
		return r120_crt_50_ccf_non_fund_20_percen;
	}
	public void setR120_crt_50_ccf_non_fund_20_percen(BigDecimal r120_crt_50_ccf_non_fund_20_percen) {
		this.r120_crt_50_ccf_non_fund_20_percen = r120_crt_50_ccf_non_fund_20_percen;
	}
	public BigDecimal getR120_crt_50_ccf_non_fund_50_percen() {
		return r120_crt_50_ccf_non_fund_50_percen;
	}
	public void setR120_crt_50_ccf_non_fund_50_percen(BigDecimal r120_crt_50_ccf_non_fund_50_percen) {
		this.r120_crt_50_ccf_non_fund_50_percen = r120_crt_50_ccf_non_fund_50_percen;
	}
	public BigDecimal getR120_crt_50_ccf_non_fund_100_percen() {
		return r120_crt_50_ccf_non_fund_100_percen;
	}
	public void setR120_crt_50_ccf_non_fund_100_percen(BigDecimal r120_crt_50_ccf_non_fund_100_percen) {
		this.r120_crt_50_ccf_non_fund_100_percen = r120_crt_50_ccf_non_fund_100_percen;
	}
	public BigDecimal getR120_crt_50_ccf_fund_0_percen() {
		return r120_crt_50_ccf_fund_0_percen;
	}
	public void setR120_crt_50_ccf_fund_0_percen(BigDecimal r120_crt_50_ccf_fund_0_percen) {
		this.r120_crt_50_ccf_fund_0_percen = r120_crt_50_ccf_fund_0_percen;
	}
	public BigDecimal getR120_crt_50_ccf_fund_20_percen() {
		return r120_crt_50_ccf_fund_20_percen;
	}
	public void setR120_crt_50_ccf_fund_20_percen(BigDecimal r120_crt_50_ccf_fund_20_percen) {
		this.r120_crt_50_ccf_fund_20_percen = r120_crt_50_ccf_fund_20_percen;
	}
	public BigDecimal getR120_crt_50_ccf_fund_50_percen() {
		return r120_crt_50_ccf_fund_50_percen;
	}
	public void setR120_crt_50_ccf_fund_50_percen(BigDecimal r120_crt_50_ccf_fund_50_percen) {
		this.r120_crt_50_ccf_fund_50_percen = r120_crt_50_ccf_fund_50_percen;
	}
	public BigDecimal getR120_crt_50_ccf_fund_100_percen() {
		return r120_crt_50_ccf_fund_100_percen;
	}
	public void setR120_crt_50_ccf_fund_100_percen(BigDecimal r120_crt_50_ccf_fund_100_percen) {
		this.r120_crt_50_ccf_fund_100_percen = r120_crt_50_ccf_fund_100_percen;
	}
	public BigDecimal getR120_crt_50_ccf_non_fund_und_0_percen() {
		return r120_crt_50_ccf_non_fund_und_0_percen;
	}
	public void setR120_crt_50_ccf_non_fund_und_0_percen(BigDecimal r120_crt_50_ccf_non_fund_und_0_percen) {
		this.r120_crt_50_ccf_non_fund_und_0_percen = r120_crt_50_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR120_crt_50_ccf_non_fund_und_20_percen() {
		return r120_crt_50_ccf_non_fund_und_20_percen;
	}
	public void setR120_crt_50_ccf_non_fund_und_20_percen(BigDecimal r120_crt_50_ccf_non_fund_und_20_percen) {
		this.r120_crt_50_ccf_non_fund_und_20_percen = r120_crt_50_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR120_crt_50_ccf_non_fund_und_50_percen() {
		return r120_crt_50_ccf_non_fund_und_50_percen;
	}
	public void setR120_crt_50_ccf_non_fund_und_50_percen(BigDecimal r120_crt_50_ccf_non_fund_und_50_percen) {
		this.r120_crt_50_ccf_non_fund_und_50_percen = r120_crt_50_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR120_crt_50_ccf_non_fund_und_100_percen() {
		return r120_crt_50_ccf_non_fund_und_100_percen;
	}
	public void setR120_crt_50_ccf_non_fund_und_100_percen(BigDecimal r120_crt_50_ccf_non_fund_und_100_percen) {
		this.r120_crt_50_ccf_non_fund_und_100_percen = r120_crt_50_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR121_crt_100_total_0_percen() {
		return r121_crt_100_total_0_percen;
	}
	public void setR121_crt_100_total_0_percen(BigDecimal r121_crt_100_total_0_percen) {
		this.r121_crt_100_total_0_percen = r121_crt_100_total_0_percen;
	}
	public BigDecimal getR121_crt_100_total_20_percen() {
		return r121_crt_100_total_20_percen;
	}
	public void setR121_crt_100_total_20_percen(BigDecimal r121_crt_100_total_20_percen) {
		this.r121_crt_100_total_20_percen = r121_crt_100_total_20_percen;
	}
	public BigDecimal getR121_crt_100_total_50_percen() {
		return r121_crt_100_total_50_percen;
	}
	public void setR121_crt_100_total_50_percen(BigDecimal r121_crt_100_total_50_percen) {
		this.r121_crt_100_total_50_percen = r121_crt_100_total_50_percen;
	}
	public BigDecimal getR121_crt_100_total_100_percen() {
		return r121_crt_100_total_100_percen;
	}
	public void setR121_crt_100_total_100_percen(BigDecimal r121_crt_100_total_100_percen) {
		this.r121_crt_100_total_100_percen = r121_crt_100_total_100_percen;
	}
	public BigDecimal getR121_crt_100_ccf_non_fund_0_percen() {
		return r121_crt_100_ccf_non_fund_0_percen;
	}
	public void setR121_crt_100_ccf_non_fund_0_percen(BigDecimal r121_crt_100_ccf_non_fund_0_percen) {
		this.r121_crt_100_ccf_non_fund_0_percen = r121_crt_100_ccf_non_fund_0_percen;
	}
	public BigDecimal getR121_crt_100_ccf_non_fund_20_percen() {
		return r121_crt_100_ccf_non_fund_20_percen;
	}
	public void setR121_crt_100_ccf_non_fund_20_percen(BigDecimal r121_crt_100_ccf_non_fund_20_percen) {
		this.r121_crt_100_ccf_non_fund_20_percen = r121_crt_100_ccf_non_fund_20_percen;
	}
	public BigDecimal getR121_crt_100_ccf_non_fund_50_percen() {
		return r121_crt_100_ccf_non_fund_50_percen;
	}
	public void setR121_crt_100_ccf_non_fund_50_percen(BigDecimal r121_crt_100_ccf_non_fund_50_percen) {
		this.r121_crt_100_ccf_non_fund_50_percen = r121_crt_100_ccf_non_fund_50_percen;
	}
	public BigDecimal getR121_crt_100_ccf_non_fund_100_percen() {
		return r121_crt_100_ccf_non_fund_100_percen;
	}
	public void setR121_crt_100_ccf_non_fund_100_percen(BigDecimal r121_crt_100_ccf_non_fund_100_percen) {
		this.r121_crt_100_ccf_non_fund_100_percen = r121_crt_100_ccf_non_fund_100_percen;
	}
	public BigDecimal getR121_crt_100_ccf_fund_0_percen() {
		return r121_crt_100_ccf_fund_0_percen;
	}
	public void setR121_crt_100_ccf_fund_0_percen(BigDecimal r121_crt_100_ccf_fund_0_percen) {
		this.r121_crt_100_ccf_fund_0_percen = r121_crt_100_ccf_fund_0_percen;
	}
	public BigDecimal getR121_crt_100_ccf_fund_20_percen() {
		return r121_crt_100_ccf_fund_20_percen;
	}
	public void setR121_crt_100_ccf_fund_20_percen(BigDecimal r121_crt_100_ccf_fund_20_percen) {
		this.r121_crt_100_ccf_fund_20_percen = r121_crt_100_ccf_fund_20_percen;
	}
	public BigDecimal getR121_crt_100_ccf_fund_50_percen() {
		return r121_crt_100_ccf_fund_50_percen;
	}
	public void setR121_crt_100_ccf_fund_50_percen(BigDecimal r121_crt_100_ccf_fund_50_percen) {
		this.r121_crt_100_ccf_fund_50_percen = r121_crt_100_ccf_fund_50_percen;
	}
	public BigDecimal getR121_crt_100_ccf_fund_100_percen() {
		return r121_crt_100_ccf_fund_100_percen;
	}
	public void setR121_crt_100_ccf_fund_100_percen(BigDecimal r121_crt_100_ccf_fund_100_percen) {
		this.r121_crt_100_ccf_fund_100_percen = r121_crt_100_ccf_fund_100_percen;
	}
	public BigDecimal getR121_crt_100_ccf_non_fund_und_0_percen() {
		return r121_crt_100_ccf_non_fund_und_0_percen;
	}
	public void setR121_crt_100_ccf_non_fund_und_0_percen(BigDecimal r121_crt_100_ccf_non_fund_und_0_percen) {
		this.r121_crt_100_ccf_non_fund_und_0_percen = r121_crt_100_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR121_crt_100_ccf_non_fund_und_20_percen() {
		return r121_crt_100_ccf_non_fund_und_20_percen;
	}
	public void setR121_crt_100_ccf_non_fund_und_20_percen(BigDecimal r121_crt_100_ccf_non_fund_und_20_percen) {
		this.r121_crt_100_ccf_non_fund_und_20_percen = r121_crt_100_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR121_crt_100_ccf_non_fund_und_50_percen() {
		return r121_crt_100_ccf_non_fund_und_50_percen;
	}
	public void setR121_crt_100_ccf_non_fund_und_50_percen(BigDecimal r121_crt_100_ccf_non_fund_und_50_percen) {
		this.r121_crt_100_ccf_non_fund_und_50_percen = r121_crt_100_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR121_crt_100_ccf_non_fund_und_100_percen() {
		return r121_crt_100_ccf_non_fund_und_100_percen;
	}
	public void setR121_crt_100_ccf_non_fund_und_100_percen(BigDecimal r121_crt_100_ccf_non_fund_und_100_percen) {
		this.r121_crt_100_ccf_non_fund_und_100_percen = r121_crt_100_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR122_crt_150_total_0_percen() {
		return r122_crt_150_total_0_percen;
	}
	public void setR122_crt_150_total_0_percen(BigDecimal r122_crt_150_total_0_percen) {
		this.r122_crt_150_total_0_percen = r122_crt_150_total_0_percen;
	}
	public BigDecimal getR122_crt_150_total_20_percen() {
		return r122_crt_150_total_20_percen;
	}
	public void setR122_crt_150_total_20_percen(BigDecimal r122_crt_150_total_20_percen) {
		this.r122_crt_150_total_20_percen = r122_crt_150_total_20_percen;
	}
	public BigDecimal getR122_crt_150_total_50_percen() {
		return r122_crt_150_total_50_percen;
	}
	public void setR122_crt_150_total_50_percen(BigDecimal r122_crt_150_total_50_percen) {
		this.r122_crt_150_total_50_percen = r122_crt_150_total_50_percen;
	}
	public BigDecimal getR122_crt_150_total_100_percen() {
		return r122_crt_150_total_100_percen;
	}
	public void setR122_crt_150_total_100_percen(BigDecimal r122_crt_150_total_100_percen) {
		this.r122_crt_150_total_100_percen = r122_crt_150_total_100_percen;
	}
	public BigDecimal getR122_crt_150_ccf_non_fund_0_percen() {
		return r122_crt_150_ccf_non_fund_0_percen;
	}
	public void setR122_crt_150_ccf_non_fund_0_percen(BigDecimal r122_crt_150_ccf_non_fund_0_percen) {
		this.r122_crt_150_ccf_non_fund_0_percen = r122_crt_150_ccf_non_fund_0_percen;
	}
	public BigDecimal getR122_crt_150_ccf_non_fund_20_percen() {
		return r122_crt_150_ccf_non_fund_20_percen;
	}
	public void setR122_crt_150_ccf_non_fund_20_percen(BigDecimal r122_crt_150_ccf_non_fund_20_percen) {
		this.r122_crt_150_ccf_non_fund_20_percen = r122_crt_150_ccf_non_fund_20_percen;
	}
	public BigDecimal getR122_crt_150_ccf_non_fund_50_percen() {
		return r122_crt_150_ccf_non_fund_50_percen;
	}
	public void setR122_crt_150_ccf_non_fund_50_percen(BigDecimal r122_crt_150_ccf_non_fund_50_percen) {
		this.r122_crt_150_ccf_non_fund_50_percen = r122_crt_150_ccf_non_fund_50_percen;
	}
	public BigDecimal getR122_crt_150_ccf_non_fund_100_percen() {
		return r122_crt_150_ccf_non_fund_100_percen;
	}
	public void setR122_crt_150_ccf_non_fund_100_percen(BigDecimal r122_crt_150_ccf_non_fund_100_percen) {
		this.r122_crt_150_ccf_non_fund_100_percen = r122_crt_150_ccf_non_fund_100_percen;
	}
	public BigDecimal getR122_crt_150_ccf_fund_0_percen() {
		return r122_crt_150_ccf_fund_0_percen;
	}
	public void setR122_crt_150_ccf_fund_0_percen(BigDecimal r122_crt_150_ccf_fund_0_percen) {
		this.r122_crt_150_ccf_fund_0_percen = r122_crt_150_ccf_fund_0_percen;
	}
	public BigDecimal getR122_crt_150_ccf_fund_20_percen() {
		return r122_crt_150_ccf_fund_20_percen;
	}
	public void setR122_crt_150_ccf_fund_20_percen(BigDecimal r122_crt_150_ccf_fund_20_percen) {
		this.r122_crt_150_ccf_fund_20_percen = r122_crt_150_ccf_fund_20_percen;
	}
	public BigDecimal getR122_crt_150_ccf_fund_50_percen() {
		return r122_crt_150_ccf_fund_50_percen;
	}
	public void setR122_crt_150_ccf_fund_50_percen(BigDecimal r122_crt_150_ccf_fund_50_percen) {
		this.r122_crt_150_ccf_fund_50_percen = r122_crt_150_ccf_fund_50_percen;
	}
	public BigDecimal getR122_crt_150_ccf_fund_100_percen() {
		return r122_crt_150_ccf_fund_100_percen;
	}
	public void setR122_crt_150_ccf_fund_100_percen(BigDecimal r122_crt_150_ccf_fund_100_percen) {
		this.r122_crt_150_ccf_fund_100_percen = r122_crt_150_ccf_fund_100_percen;
	}
	public BigDecimal getR122_crt_150_ccf_non_fund_und_0_percen() {
		return r122_crt_150_ccf_non_fund_und_0_percen;
	}
	public void setR122_crt_150_ccf_non_fund_und_0_percen(BigDecimal r122_crt_150_ccf_non_fund_und_0_percen) {
		this.r122_crt_150_ccf_non_fund_und_0_percen = r122_crt_150_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR122_crt_150_ccf_non_fund_und_20_percen() {
		return r122_crt_150_ccf_non_fund_und_20_percen;
	}
	public void setR122_crt_150_ccf_non_fund_und_20_percen(BigDecimal r122_crt_150_ccf_non_fund_und_20_percen) {
		this.r122_crt_150_ccf_non_fund_und_20_percen = r122_crt_150_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR122_crt_150_ccf_non_fund_und_50_percen() {
		return r122_crt_150_ccf_non_fund_und_50_percen;
	}
	public void setR122_crt_150_ccf_non_fund_und_50_percen(BigDecimal r122_crt_150_ccf_non_fund_und_50_percen) {
		this.r122_crt_150_ccf_non_fund_und_50_percen = r122_crt_150_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR122_crt_150_ccf_non_fund_und_100_percen() {
		return r122_crt_150_ccf_non_fund_und_100_percen;
	}
	public void setR122_crt_150_ccf_non_fund_und_100_percen(BigDecimal r122_crt_150_ccf_non_fund_und_100_percen) {
		this.r122_crt_150_ccf_non_fund_und_100_percen = r122_crt_150_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR123_hni_100_total_0_percen() {
		return r123_hni_100_total_0_percen;
	}
	public void setR123_hni_100_total_0_percen(BigDecimal r123_hni_100_total_0_percen) {
		this.r123_hni_100_total_0_percen = r123_hni_100_total_0_percen;
	}
	public BigDecimal getR123_hni_100_total_20_percen() {
		return r123_hni_100_total_20_percen;
	}
	public void setR123_hni_100_total_20_percen(BigDecimal r123_hni_100_total_20_percen) {
		this.r123_hni_100_total_20_percen = r123_hni_100_total_20_percen;
	}
	public BigDecimal getR123_hni_100_total_50_percen() {
		return r123_hni_100_total_50_percen;
	}
	public void setR123_hni_100_total_50_percen(BigDecimal r123_hni_100_total_50_percen) {
		this.r123_hni_100_total_50_percen = r123_hni_100_total_50_percen;
	}
	public BigDecimal getR123_hni_100_total_100_percen() {
		return r123_hni_100_total_100_percen;
	}
	public void setR123_hni_100_total_100_percen(BigDecimal r123_hni_100_total_100_percen) {
		this.r123_hni_100_total_100_percen = r123_hni_100_total_100_percen;
	}
	public BigDecimal getR123_hni_100_ccf_non_fund_0_percen() {
		return r123_hni_100_ccf_non_fund_0_percen;
	}
	public void setR123_hni_100_ccf_non_fund_0_percen(BigDecimal r123_hni_100_ccf_non_fund_0_percen) {
		this.r123_hni_100_ccf_non_fund_0_percen = r123_hni_100_ccf_non_fund_0_percen;
	}
	public BigDecimal getR123_hni_100_ccf_non_fund_20_percen() {
		return r123_hni_100_ccf_non_fund_20_percen;
	}
	public void setR123_hni_100_ccf_non_fund_20_percen(BigDecimal r123_hni_100_ccf_non_fund_20_percen) {
		this.r123_hni_100_ccf_non_fund_20_percen = r123_hni_100_ccf_non_fund_20_percen;
	}
	public BigDecimal getR123_hni_100_ccf_non_fund_50_percen() {
		return r123_hni_100_ccf_non_fund_50_percen;
	}
	public void setR123_hni_100_ccf_non_fund_50_percen(BigDecimal r123_hni_100_ccf_non_fund_50_percen) {
		this.r123_hni_100_ccf_non_fund_50_percen = r123_hni_100_ccf_non_fund_50_percen;
	}
	public BigDecimal getR123_hni_100_ccf_non_fund_100_percen() {
		return r123_hni_100_ccf_non_fund_100_percen;
	}
	public void setR123_hni_100_ccf_non_fund_100_percen(BigDecimal r123_hni_100_ccf_non_fund_100_percen) {
		this.r123_hni_100_ccf_non_fund_100_percen = r123_hni_100_ccf_non_fund_100_percen;
	}
	public BigDecimal getR123_hni_100_ccf_fund_0_percen() {
		return r123_hni_100_ccf_fund_0_percen;
	}
	public void setR123_hni_100_ccf_fund_0_percen(BigDecimal r123_hni_100_ccf_fund_0_percen) {
		this.r123_hni_100_ccf_fund_0_percen = r123_hni_100_ccf_fund_0_percen;
	}
	public BigDecimal getR123_hni_100_ccf_fund_20_percen() {
		return r123_hni_100_ccf_fund_20_percen;
	}
	public void setR123_hni_100_ccf_fund_20_percen(BigDecimal r123_hni_100_ccf_fund_20_percen) {
		this.r123_hni_100_ccf_fund_20_percen = r123_hni_100_ccf_fund_20_percen;
	}
	public BigDecimal getR123_hni_100_ccf_fund_50_percen() {
		return r123_hni_100_ccf_fund_50_percen;
	}
	public void setR123_hni_100_ccf_fund_50_percen(BigDecimal r123_hni_100_ccf_fund_50_percen) {
		this.r123_hni_100_ccf_fund_50_percen = r123_hni_100_ccf_fund_50_percen;
	}
	public BigDecimal getR123_hni_100_ccf_fund_100_percen() {
		return r123_hni_100_ccf_fund_100_percen;
	}
	public void setR123_hni_100_ccf_fund_100_percen(BigDecimal r123_hni_100_ccf_fund_100_percen) {
		this.r123_hni_100_ccf_fund_100_percen = r123_hni_100_ccf_fund_100_percen;
	}
	public BigDecimal getR123_hni_100_ccf_non_fund_und_0_percen() {
		return r123_hni_100_ccf_non_fund_und_0_percen;
	}
	public void setR123_hni_100_ccf_non_fund_und_0_percen(BigDecimal r123_hni_100_ccf_non_fund_und_0_percen) {
		this.r123_hni_100_ccf_non_fund_und_0_percen = r123_hni_100_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR123_hni_100_ccf_non_fund_und_20_percen() {
		return r123_hni_100_ccf_non_fund_und_20_percen;
	}
	public void setR123_hni_100_ccf_non_fund_und_20_percen(BigDecimal r123_hni_100_ccf_non_fund_und_20_percen) {
		this.r123_hni_100_ccf_non_fund_und_20_percen = r123_hni_100_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR123_hni_100_ccf_non_fund_und_50_percen() {
		return r123_hni_100_ccf_non_fund_und_50_percen;
	}
	public void setR123_hni_100_ccf_non_fund_und_50_percen(BigDecimal r123_hni_100_ccf_non_fund_und_50_percen) {
		this.r123_hni_100_ccf_non_fund_und_50_percen = r123_hni_100_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR123_hni_100_ccf_non_fund_und_100_percen() {
		return r123_hni_100_ccf_non_fund_und_100_percen;
	}
	public void setR123_hni_100_ccf_non_fund_und_100_percen(BigDecimal r123_hni_100_ccf_non_fund_und_100_percen) {
		this.r123_hni_100_ccf_non_fund_und_100_percen = r123_hni_100_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR124_pdl_100_total_0_percen() {
		return r124_pdl_100_total_0_percen;
	}
	public void setR124_pdl_100_total_0_percen(BigDecimal r124_pdl_100_total_0_percen) {
		this.r124_pdl_100_total_0_percen = r124_pdl_100_total_0_percen;
	}
	public BigDecimal getR124_pdl_100_total_20_percen() {
		return r124_pdl_100_total_20_percen;
	}
	public void setR124_pdl_100_total_20_percen(BigDecimal r124_pdl_100_total_20_percen) {
		this.r124_pdl_100_total_20_percen = r124_pdl_100_total_20_percen;
	}
	public BigDecimal getR124_pdl_100_total_50_percen() {
		return r124_pdl_100_total_50_percen;
	}
	public void setR124_pdl_100_total_50_percen(BigDecimal r124_pdl_100_total_50_percen) {
		this.r124_pdl_100_total_50_percen = r124_pdl_100_total_50_percen;
	}
	public BigDecimal getR124_pdl_100_total_100_percen() {
		return r124_pdl_100_total_100_percen;
	}
	public void setR124_pdl_100_total_100_percen(BigDecimal r124_pdl_100_total_100_percen) {
		this.r124_pdl_100_total_100_percen = r124_pdl_100_total_100_percen;
	}
	public BigDecimal getR124_pdl_100_ccf_non_fund_0_percen() {
		return r124_pdl_100_ccf_non_fund_0_percen;
	}
	public void setR124_pdl_100_ccf_non_fund_0_percen(BigDecimal r124_pdl_100_ccf_non_fund_0_percen) {
		this.r124_pdl_100_ccf_non_fund_0_percen = r124_pdl_100_ccf_non_fund_0_percen;
	}
	public BigDecimal getR124_pdl_100_ccf_non_fund_20_percen() {
		return r124_pdl_100_ccf_non_fund_20_percen;
	}
	public void setR124_pdl_100_ccf_non_fund_20_percen(BigDecimal r124_pdl_100_ccf_non_fund_20_percen) {
		this.r124_pdl_100_ccf_non_fund_20_percen = r124_pdl_100_ccf_non_fund_20_percen;
	}
	public BigDecimal getR124_pdl_100_ccf_non_fund_50_percen() {
		return r124_pdl_100_ccf_non_fund_50_percen;
	}
	public void setR124_pdl_100_ccf_non_fund_50_percen(BigDecimal r124_pdl_100_ccf_non_fund_50_percen) {
		this.r124_pdl_100_ccf_non_fund_50_percen = r124_pdl_100_ccf_non_fund_50_percen;
	}
	public BigDecimal getR124_pdl_100_ccf_non_fund_100_percen() {
		return r124_pdl_100_ccf_non_fund_100_percen;
	}
	public void setR124_pdl_100_ccf_non_fund_100_percen(BigDecimal r124_pdl_100_ccf_non_fund_100_percen) {
		this.r124_pdl_100_ccf_non_fund_100_percen = r124_pdl_100_ccf_non_fund_100_percen;
	}
	public BigDecimal getR124_pdl_100_ccf_fund_0_percen() {
		return r124_pdl_100_ccf_fund_0_percen;
	}
	public void setR124_pdl_100_ccf_fund_0_percen(BigDecimal r124_pdl_100_ccf_fund_0_percen) {
		this.r124_pdl_100_ccf_fund_0_percen = r124_pdl_100_ccf_fund_0_percen;
	}
	public BigDecimal getR124_pdl_100_ccf_fund_20_percen() {
		return r124_pdl_100_ccf_fund_20_percen;
	}
	public void setR124_pdl_100_ccf_fund_20_percen(BigDecimal r124_pdl_100_ccf_fund_20_percen) {
		this.r124_pdl_100_ccf_fund_20_percen = r124_pdl_100_ccf_fund_20_percen;
	}
	public BigDecimal getR124_pdl_100_ccf_fund_50_percen() {
		return r124_pdl_100_ccf_fund_50_percen;
	}
	public void setR124_pdl_100_ccf_fund_50_percen(BigDecimal r124_pdl_100_ccf_fund_50_percen) {
		this.r124_pdl_100_ccf_fund_50_percen = r124_pdl_100_ccf_fund_50_percen;
	}
	public BigDecimal getR124_pdl_100_ccf_fund_100_percen() {
		return r124_pdl_100_ccf_fund_100_percen;
	}
	public void setR124_pdl_100_ccf_fund_100_percen(BigDecimal r124_pdl_100_ccf_fund_100_percen) {
		this.r124_pdl_100_ccf_fund_100_percen = r124_pdl_100_ccf_fund_100_percen;
	}
	public BigDecimal getR124_pdl_100_ccf_non_fund_und_0_percen() {
		return r124_pdl_100_ccf_non_fund_und_0_percen;
	}
	public void setR124_pdl_100_ccf_non_fund_und_0_percen(BigDecimal r124_pdl_100_ccf_non_fund_und_0_percen) {
		this.r124_pdl_100_ccf_non_fund_und_0_percen = r124_pdl_100_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR124_pdl_100_ccf_non_fund_und_20_percen() {
		return r124_pdl_100_ccf_non_fund_und_20_percen;
	}
	public void setR124_pdl_100_ccf_non_fund_und_20_percen(BigDecimal r124_pdl_100_ccf_non_fund_und_20_percen) {
		this.r124_pdl_100_ccf_non_fund_und_20_percen = r124_pdl_100_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR124_pdl_100_ccf_non_fund_und_50_percen() {
		return r124_pdl_100_ccf_non_fund_und_50_percen;
	}
	public void setR124_pdl_100_ccf_non_fund_und_50_percen(BigDecimal r124_pdl_100_ccf_non_fund_und_50_percen) {
		this.r124_pdl_100_ccf_non_fund_und_50_percen = r124_pdl_100_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR124_pdl_100_ccf_non_fund_und_100_percen() {
		return r124_pdl_100_ccf_non_fund_und_100_percen;
	}
	public void setR124_pdl_100_ccf_non_fund_und_100_percen(BigDecimal r124_pdl_100_ccf_non_fund_und_100_percen) {
		this.r124_pdl_100_ccf_non_fund_und_100_percen = r124_pdl_100_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR125_pdl_150_total_0_percen() {
		return r125_pdl_150_total_0_percen;
	}
	public void setR125_pdl_150_total_0_percen(BigDecimal r125_pdl_150_total_0_percen) {
		this.r125_pdl_150_total_0_percen = r125_pdl_150_total_0_percen;
	}
	public BigDecimal getR125_pdl_150_total_20_percen() {
		return r125_pdl_150_total_20_percen;
	}
	public void setR125_pdl_150_total_20_percen(BigDecimal r125_pdl_150_total_20_percen) {
		this.r125_pdl_150_total_20_percen = r125_pdl_150_total_20_percen;
	}
	public BigDecimal getR125_pdl_150_total_50_percen() {
		return r125_pdl_150_total_50_percen;
	}
	public void setR125_pdl_150_total_50_percen(BigDecimal r125_pdl_150_total_50_percen) {
		this.r125_pdl_150_total_50_percen = r125_pdl_150_total_50_percen;
	}
	public BigDecimal getR125_pdl_150_total_100_percen() {
		return r125_pdl_150_total_100_percen;
	}
	public void setR125_pdl_150_total_100_percen(BigDecimal r125_pdl_150_total_100_percen) {
		this.r125_pdl_150_total_100_percen = r125_pdl_150_total_100_percen;
	}
	public BigDecimal getR125_pdl_150_ccf_non_fund_0_percen() {
		return r125_pdl_150_ccf_non_fund_0_percen;
	}
	public void setR125_pdl_150_ccf_non_fund_0_percen(BigDecimal r125_pdl_150_ccf_non_fund_0_percen) {
		this.r125_pdl_150_ccf_non_fund_0_percen = r125_pdl_150_ccf_non_fund_0_percen;
	}
	public BigDecimal getR125_pdl_150_ccf_non_fund_20_percen() {
		return r125_pdl_150_ccf_non_fund_20_percen;
	}
	public void setR125_pdl_150_ccf_non_fund_20_percen(BigDecimal r125_pdl_150_ccf_non_fund_20_percen) {
		this.r125_pdl_150_ccf_non_fund_20_percen = r125_pdl_150_ccf_non_fund_20_percen;
	}
	public BigDecimal getR125_pdl_150_ccf_non_fund_50_percen() {
		return r125_pdl_150_ccf_non_fund_50_percen;
	}
	public void setR125_pdl_150_ccf_non_fund_50_percen(BigDecimal r125_pdl_150_ccf_non_fund_50_percen) {
		this.r125_pdl_150_ccf_non_fund_50_percen = r125_pdl_150_ccf_non_fund_50_percen;
	}
	public BigDecimal getR125_pdl_150_ccf_non_fund_100_percen() {
		return r125_pdl_150_ccf_non_fund_100_percen;
	}
	public void setR125_pdl_150_ccf_non_fund_100_percen(BigDecimal r125_pdl_150_ccf_non_fund_100_percen) {
		this.r125_pdl_150_ccf_non_fund_100_percen = r125_pdl_150_ccf_non_fund_100_percen;
	}
	public BigDecimal getR125_pdl_150_ccf_fund_0_percen() {
		return r125_pdl_150_ccf_fund_0_percen;
	}
	public void setR125_pdl_150_ccf_fund_0_percen(BigDecimal r125_pdl_150_ccf_fund_0_percen) {
		this.r125_pdl_150_ccf_fund_0_percen = r125_pdl_150_ccf_fund_0_percen;
	}
	public BigDecimal getR125_pdl_150_ccf_fund_20_percen() {
		return r125_pdl_150_ccf_fund_20_percen;
	}
	public void setR125_pdl_150_ccf_fund_20_percen(BigDecimal r125_pdl_150_ccf_fund_20_percen) {
		this.r125_pdl_150_ccf_fund_20_percen = r125_pdl_150_ccf_fund_20_percen;
	}
	public BigDecimal getR125_pdl_150_ccf_fund_50_percen() {
		return r125_pdl_150_ccf_fund_50_percen;
	}
	public void setR125_pdl_150_ccf_fund_50_percen(BigDecimal r125_pdl_150_ccf_fund_50_percen) {
		this.r125_pdl_150_ccf_fund_50_percen = r125_pdl_150_ccf_fund_50_percen;
	}
	public BigDecimal getR125_pdl_150_ccf_fund_100_percen() {
		return r125_pdl_150_ccf_fund_100_percen;
	}
	public void setR125_pdl_150_ccf_fund_100_percen(BigDecimal r125_pdl_150_ccf_fund_100_percen) {
		this.r125_pdl_150_ccf_fund_100_percen = r125_pdl_150_ccf_fund_100_percen;
	}
	public BigDecimal getR125_pdl_150_ccf_non_fund_und_0_percen() {
		return r125_pdl_150_ccf_non_fund_und_0_percen;
	}
	public void setR125_pdl_150_ccf_non_fund_und_0_percen(BigDecimal r125_pdl_150_ccf_non_fund_und_0_percen) {
		this.r125_pdl_150_ccf_non_fund_und_0_percen = r125_pdl_150_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR125_pdl_150_ccf_non_fund_und_20_percen() {
		return r125_pdl_150_ccf_non_fund_und_20_percen;
	}
	public void setR125_pdl_150_ccf_non_fund_und_20_percen(BigDecimal r125_pdl_150_ccf_non_fund_und_20_percen) {
		this.r125_pdl_150_ccf_non_fund_und_20_percen = r125_pdl_150_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR125_pdl_150_ccf_non_fund_und_50_percen() {
		return r125_pdl_150_ccf_non_fund_und_50_percen;
	}
	public void setR125_pdl_150_ccf_non_fund_und_50_percen(BigDecimal r125_pdl_150_ccf_non_fund_und_50_percen) {
		this.r125_pdl_150_ccf_non_fund_und_50_percen = r125_pdl_150_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR125_pdl_150_ccf_non_fund_und_100_percen() {
		return r125_pdl_150_ccf_non_fund_und_100_percen;
	}
	public void setR125_pdl_150_ccf_non_fund_und_100_percen(BigDecimal r125_pdl_150_ccf_non_fund_und_100_percen) {
		this.r125_pdl_150_ccf_non_fund_und_100_percen = r125_pdl_150_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR126_pse_0_total_0_percen() {
		return r126_pse_0_total_0_percen;
	}
	public void setR126_pse_0_total_0_percen(BigDecimal r126_pse_0_total_0_percen) {
		this.r126_pse_0_total_0_percen = r126_pse_0_total_0_percen;
	}
	public BigDecimal getR126_pse_0_total_20_percen() {
		return r126_pse_0_total_20_percen;
	}
	public void setR126_pse_0_total_20_percen(BigDecimal r126_pse_0_total_20_percen) {
		this.r126_pse_0_total_20_percen = r126_pse_0_total_20_percen;
	}
	public BigDecimal getR126_pse_0_total_50_percen() {
		return r126_pse_0_total_50_percen;
	}
	public void setR126_pse_0_total_50_percen(BigDecimal r126_pse_0_total_50_percen) {
		this.r126_pse_0_total_50_percen = r126_pse_0_total_50_percen;
	}
	public BigDecimal getR126_pse_0_total_100_percen() {
		return r126_pse_0_total_100_percen;
	}
	public void setR126_pse_0_total_100_percen(BigDecimal r126_pse_0_total_100_percen) {
		this.r126_pse_0_total_100_percen = r126_pse_0_total_100_percen;
	}
	public BigDecimal getR126_pse_0_ccf_non_fund_0_percen() {
		return r126_pse_0_ccf_non_fund_0_percen;
	}
	public void setR126_pse_0_ccf_non_fund_0_percen(BigDecimal r126_pse_0_ccf_non_fund_0_percen) {
		this.r126_pse_0_ccf_non_fund_0_percen = r126_pse_0_ccf_non_fund_0_percen;
	}
	public BigDecimal getR126_pse_0_ccf_non_fund_20_percen() {
		return r126_pse_0_ccf_non_fund_20_percen;
	}
	public void setR126_pse_0_ccf_non_fund_20_percen(BigDecimal r126_pse_0_ccf_non_fund_20_percen) {
		this.r126_pse_0_ccf_non_fund_20_percen = r126_pse_0_ccf_non_fund_20_percen;
	}
	public BigDecimal getR126_pse_0_ccf_non_fund_50_percen() {
		return r126_pse_0_ccf_non_fund_50_percen;
	}
	public void setR126_pse_0_ccf_non_fund_50_percen(BigDecimal r126_pse_0_ccf_non_fund_50_percen) {
		this.r126_pse_0_ccf_non_fund_50_percen = r126_pse_0_ccf_non_fund_50_percen;
	}
	public BigDecimal getR126_pse_0_ccf_non_fund_100_percen() {
		return r126_pse_0_ccf_non_fund_100_percen;
	}
	public void setR126_pse_0_ccf_non_fund_100_percen(BigDecimal r126_pse_0_ccf_non_fund_100_percen) {
		this.r126_pse_0_ccf_non_fund_100_percen = r126_pse_0_ccf_non_fund_100_percen;
	}
	public BigDecimal getR126_pse_0_ccf_fund_0_percen() {
		return r126_pse_0_ccf_fund_0_percen;
	}
	public void setR126_pse_0_ccf_fund_0_percen(BigDecimal r126_pse_0_ccf_fund_0_percen) {
		this.r126_pse_0_ccf_fund_0_percen = r126_pse_0_ccf_fund_0_percen;
	}
	public BigDecimal getR126_pse_0_ccf_fund_20_percen() {
		return r126_pse_0_ccf_fund_20_percen;
	}
	public void setR126_pse_0_ccf_fund_20_percen(BigDecimal r126_pse_0_ccf_fund_20_percen) {
		this.r126_pse_0_ccf_fund_20_percen = r126_pse_0_ccf_fund_20_percen;
	}
	public BigDecimal getR126_pse_0_ccf_fund_50_percen() {
		return r126_pse_0_ccf_fund_50_percen;
	}
	public void setR126_pse_0_ccf_fund_50_percen(BigDecimal r126_pse_0_ccf_fund_50_percen) {
		this.r126_pse_0_ccf_fund_50_percen = r126_pse_0_ccf_fund_50_percen;
	}
	public BigDecimal getR126_pse_0_ccf_fund_100_percen() {
		return r126_pse_0_ccf_fund_100_percen;
	}
	public void setR126_pse_0_ccf_fund_100_percen(BigDecimal r126_pse_0_ccf_fund_100_percen) {
		this.r126_pse_0_ccf_fund_100_percen = r126_pse_0_ccf_fund_100_percen;
	}
	public BigDecimal getR126_pse_0_ccf_non_fund_und_0_percen() {
		return r126_pse_0_ccf_non_fund_und_0_percen;
	}
	public void setR126_pse_0_ccf_non_fund_und_0_percen(BigDecimal r126_pse_0_ccf_non_fund_und_0_percen) {
		this.r126_pse_0_ccf_non_fund_und_0_percen = r126_pse_0_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR126_pse_0_ccf_non_fund_und_20_percen() {
		return r126_pse_0_ccf_non_fund_und_20_percen;
	}
	public void setR126_pse_0_ccf_non_fund_und_20_percen(BigDecimal r126_pse_0_ccf_non_fund_und_20_percen) {
		this.r126_pse_0_ccf_non_fund_und_20_percen = r126_pse_0_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR126_pse_0_ccf_non_fund_und_50_percen() {
		return r126_pse_0_ccf_non_fund_und_50_percen;
	}
	public void setR126_pse_0_ccf_non_fund_und_50_percen(BigDecimal r126_pse_0_ccf_non_fund_und_50_percen) {
		this.r126_pse_0_ccf_non_fund_und_50_percen = r126_pse_0_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR126_pse_0_ccf_non_fund_und_100_percen() {
		return r126_pse_0_ccf_non_fund_und_100_percen;
	}
	public void setR126_pse_0_ccf_non_fund_und_100_percen(BigDecimal r126_pse_0_ccf_non_fund_und_100_percen) {
		this.r126_pse_0_ccf_non_fund_und_100_percen = r126_pse_0_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR127_pse_20_total_0_percen() {
		return r127_pse_20_total_0_percen;
	}
	public void setR127_pse_20_total_0_percen(BigDecimal r127_pse_20_total_0_percen) {
		this.r127_pse_20_total_0_percen = r127_pse_20_total_0_percen;
	}
	public BigDecimal getR127_pse_20_total_20_percen() {
		return r127_pse_20_total_20_percen;
	}
	public void setR127_pse_20_total_20_percen(BigDecimal r127_pse_20_total_20_percen) {
		this.r127_pse_20_total_20_percen = r127_pse_20_total_20_percen;
	}
	public BigDecimal getR127_pse_20_total_50_percen() {
		return r127_pse_20_total_50_percen;
	}
	public void setR127_pse_20_total_50_percen(BigDecimal r127_pse_20_total_50_percen) {
		this.r127_pse_20_total_50_percen = r127_pse_20_total_50_percen;
	}
	public BigDecimal getR127_pse_20_total_100_percen() {
		return r127_pse_20_total_100_percen;
	}
	public void setR127_pse_20_total_100_percen(BigDecimal r127_pse_20_total_100_percen) {
		this.r127_pse_20_total_100_percen = r127_pse_20_total_100_percen;
	}
	public BigDecimal getR127_pse_20_ccf_non_fund_0_percen() {
		return r127_pse_20_ccf_non_fund_0_percen;
	}
	public void setR127_pse_20_ccf_non_fund_0_percen(BigDecimal r127_pse_20_ccf_non_fund_0_percen) {
		this.r127_pse_20_ccf_non_fund_0_percen = r127_pse_20_ccf_non_fund_0_percen;
	}
	public BigDecimal getR127_pse_20_ccf_non_fund_20_percen() {
		return r127_pse_20_ccf_non_fund_20_percen;
	}
	public void setR127_pse_20_ccf_non_fund_20_percen(BigDecimal r127_pse_20_ccf_non_fund_20_percen) {
		this.r127_pse_20_ccf_non_fund_20_percen = r127_pse_20_ccf_non_fund_20_percen;
	}
	public BigDecimal getR127_pse_20_ccf_non_fund_50_percen() {
		return r127_pse_20_ccf_non_fund_50_percen;
	}
	public void setR127_pse_20_ccf_non_fund_50_percen(BigDecimal r127_pse_20_ccf_non_fund_50_percen) {
		this.r127_pse_20_ccf_non_fund_50_percen = r127_pse_20_ccf_non_fund_50_percen;
	}
	public BigDecimal getR127_pse_20_ccf_non_fund_100_percen() {
		return r127_pse_20_ccf_non_fund_100_percen;
	}
	public void setR127_pse_20_ccf_non_fund_100_percen(BigDecimal r127_pse_20_ccf_non_fund_100_percen) {
		this.r127_pse_20_ccf_non_fund_100_percen = r127_pse_20_ccf_non_fund_100_percen;
	}
	public BigDecimal getR127_pse_20_ccf_fund_0_percen() {
		return r127_pse_20_ccf_fund_0_percen;
	}
	public void setR127_pse_20_ccf_fund_0_percen(BigDecimal r127_pse_20_ccf_fund_0_percen) {
		this.r127_pse_20_ccf_fund_0_percen = r127_pse_20_ccf_fund_0_percen;
	}
	public BigDecimal getR127_pse_20_ccf_fund_20_percen() {
		return r127_pse_20_ccf_fund_20_percen;
	}
	public void setR127_pse_20_ccf_fund_20_percen(BigDecimal r127_pse_20_ccf_fund_20_percen) {
		this.r127_pse_20_ccf_fund_20_percen = r127_pse_20_ccf_fund_20_percen;
	}
	public BigDecimal getR127_pse_20_ccf_fund_50_percen() {
		return r127_pse_20_ccf_fund_50_percen;
	}
	public void setR127_pse_20_ccf_fund_50_percen(BigDecimal r127_pse_20_ccf_fund_50_percen) {
		this.r127_pse_20_ccf_fund_50_percen = r127_pse_20_ccf_fund_50_percen;
	}
	public BigDecimal getR127_pse_20_ccf_fund_100_percen() {
		return r127_pse_20_ccf_fund_100_percen;
	}
	public void setR127_pse_20_ccf_fund_100_percen(BigDecimal r127_pse_20_ccf_fund_100_percen) {
		this.r127_pse_20_ccf_fund_100_percen = r127_pse_20_ccf_fund_100_percen;
	}
	public BigDecimal getR127_pse_20_ccf_non_fund_und_0_percen() {
		return r127_pse_20_ccf_non_fund_und_0_percen;
	}
	public void setR127_pse_20_ccf_non_fund_und_0_percen(BigDecimal r127_pse_20_ccf_non_fund_und_0_percen) {
		this.r127_pse_20_ccf_non_fund_und_0_percen = r127_pse_20_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR127_pse_20_ccf_non_fund_und_20_percen() {
		return r127_pse_20_ccf_non_fund_und_20_percen;
	}
	public void setR127_pse_20_ccf_non_fund_und_20_percen(BigDecimal r127_pse_20_ccf_non_fund_und_20_percen) {
		this.r127_pse_20_ccf_non_fund_und_20_percen = r127_pse_20_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR127_pse_20_ccf_non_fund_und_50_percen() {
		return r127_pse_20_ccf_non_fund_und_50_percen;
	}
	public void setR127_pse_20_ccf_non_fund_und_50_percen(BigDecimal r127_pse_20_ccf_non_fund_und_50_percen) {
		this.r127_pse_20_ccf_non_fund_und_50_percen = r127_pse_20_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR127_pse_20_ccf_non_fund_und_100_percen() {
		return r127_pse_20_ccf_non_fund_und_100_percen;
	}
	public void setR127_pse_20_ccf_non_fund_und_100_percen(BigDecimal r127_pse_20_ccf_non_fund_und_100_percen) {
		this.r127_pse_20_ccf_non_fund_und_100_percen = r127_pse_20_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR128_pse_50_total_0_percen() {
		return r128_pse_50_total_0_percen;
	}
	public void setR128_pse_50_total_0_percen(BigDecimal r128_pse_50_total_0_percen) {
		this.r128_pse_50_total_0_percen = r128_pse_50_total_0_percen;
	}
	public BigDecimal getR128_pse_50_total_20_percen() {
		return r128_pse_50_total_20_percen;
	}
	public void setR128_pse_50_total_20_percen(BigDecimal r128_pse_50_total_20_percen) {
		this.r128_pse_50_total_20_percen = r128_pse_50_total_20_percen;
	}
	public BigDecimal getR128_pse_50_total_50_percen() {
		return r128_pse_50_total_50_percen;
	}
	public void setR128_pse_50_total_50_percen(BigDecimal r128_pse_50_total_50_percen) {
		this.r128_pse_50_total_50_percen = r128_pse_50_total_50_percen;
	}
	public BigDecimal getR128_pse_50_total_100_percen() {
		return r128_pse_50_total_100_percen;
	}
	public void setR128_pse_50_total_100_percen(BigDecimal r128_pse_50_total_100_percen) {
		this.r128_pse_50_total_100_percen = r128_pse_50_total_100_percen;
	}
	public BigDecimal getR128_pse_50_ccf_non_fund_0_percen() {
		return r128_pse_50_ccf_non_fund_0_percen;
	}
	public void setR128_pse_50_ccf_non_fund_0_percen(BigDecimal r128_pse_50_ccf_non_fund_0_percen) {
		this.r128_pse_50_ccf_non_fund_0_percen = r128_pse_50_ccf_non_fund_0_percen;
	}
	public BigDecimal getR128_pse_50_ccf_non_fund_20_percen() {
		return r128_pse_50_ccf_non_fund_20_percen;
	}
	public void setR128_pse_50_ccf_non_fund_20_percen(BigDecimal r128_pse_50_ccf_non_fund_20_percen) {
		this.r128_pse_50_ccf_non_fund_20_percen = r128_pse_50_ccf_non_fund_20_percen;
	}
	public BigDecimal getR128_pse_50_ccf_non_fund_50_percen() {
		return r128_pse_50_ccf_non_fund_50_percen;
	}
	public void setR128_pse_50_ccf_non_fund_50_percen(BigDecimal r128_pse_50_ccf_non_fund_50_percen) {
		this.r128_pse_50_ccf_non_fund_50_percen = r128_pse_50_ccf_non_fund_50_percen;
	}
	public BigDecimal getR128_pse_50_ccf_non_fund_100_percen() {
		return r128_pse_50_ccf_non_fund_100_percen;
	}
	public void setR128_pse_50_ccf_non_fund_100_percen(BigDecimal r128_pse_50_ccf_non_fund_100_percen) {
		this.r128_pse_50_ccf_non_fund_100_percen = r128_pse_50_ccf_non_fund_100_percen;
	}
	public BigDecimal getR128_pse_50_ccf_fund_0_percen() {
		return r128_pse_50_ccf_fund_0_percen;
	}
	public void setR128_pse_50_ccf_fund_0_percen(BigDecimal r128_pse_50_ccf_fund_0_percen) {
		this.r128_pse_50_ccf_fund_0_percen = r128_pse_50_ccf_fund_0_percen;
	}
	public BigDecimal getR128_pse_50_ccf_fund_20_percen() {
		return r128_pse_50_ccf_fund_20_percen;
	}
	public void setR128_pse_50_ccf_fund_20_percen(BigDecimal r128_pse_50_ccf_fund_20_percen) {
		this.r128_pse_50_ccf_fund_20_percen = r128_pse_50_ccf_fund_20_percen;
	}
	public BigDecimal getR128_pse_50_ccf_fund_50_percen() {
		return r128_pse_50_ccf_fund_50_percen;
	}
	public void setR128_pse_50_ccf_fund_50_percen(BigDecimal r128_pse_50_ccf_fund_50_percen) {
		this.r128_pse_50_ccf_fund_50_percen = r128_pse_50_ccf_fund_50_percen;
	}
	public BigDecimal getR128_pse_50_ccf_fund_100_percen() {
		return r128_pse_50_ccf_fund_100_percen;
	}
	public void setR128_pse_50_ccf_fund_100_percen(BigDecimal r128_pse_50_ccf_fund_100_percen) {
		this.r128_pse_50_ccf_fund_100_percen = r128_pse_50_ccf_fund_100_percen;
	}
	public BigDecimal getR128_pse_50_ccf_non_fund_und_0_percen() {
		return r128_pse_50_ccf_non_fund_und_0_percen;
	}
	public void setR128_pse_50_ccf_non_fund_und_0_percen(BigDecimal r128_pse_50_ccf_non_fund_und_0_percen) {
		this.r128_pse_50_ccf_non_fund_und_0_percen = r128_pse_50_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR128_pse_50_ccf_non_fund_und_20_percen() {
		return r128_pse_50_ccf_non_fund_und_20_percen;
	}
	public void setR128_pse_50_ccf_non_fund_und_20_percen(BigDecimal r128_pse_50_ccf_non_fund_und_20_percen) {
		this.r128_pse_50_ccf_non_fund_und_20_percen = r128_pse_50_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR128_pse_50_ccf_non_fund_und_50_percen() {
		return r128_pse_50_ccf_non_fund_und_50_percen;
	}
	public void setR128_pse_50_ccf_non_fund_und_50_percen(BigDecimal r128_pse_50_ccf_non_fund_und_50_percen) {
		this.r128_pse_50_ccf_non_fund_und_50_percen = r128_pse_50_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR128_pse_50_ccf_non_fund_und_100_percen() {
		return r128_pse_50_ccf_non_fund_und_100_percen;
	}
	public void setR128_pse_50_ccf_non_fund_und_100_percen(BigDecimal r128_pse_50_ccf_non_fund_und_100_percen) {
		this.r128_pse_50_ccf_non_fund_und_100_percen = r128_pse_50_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR129_pse_100_total_0_percen() {
		return r129_pse_100_total_0_percen;
	}
	public void setR129_pse_100_total_0_percen(BigDecimal r129_pse_100_total_0_percen) {
		this.r129_pse_100_total_0_percen = r129_pse_100_total_0_percen;
	}
	public BigDecimal getR129_pse_100_total_20_percen() {
		return r129_pse_100_total_20_percen;
	}
	public void setR129_pse_100_total_20_percen(BigDecimal r129_pse_100_total_20_percen) {
		this.r129_pse_100_total_20_percen = r129_pse_100_total_20_percen;
	}
	public BigDecimal getR129_pse_100_total_50_percen() {
		return r129_pse_100_total_50_percen;
	}
	public void setR129_pse_100_total_50_percen(BigDecimal r129_pse_100_total_50_percen) {
		this.r129_pse_100_total_50_percen = r129_pse_100_total_50_percen;
	}
	public BigDecimal getR129_pse_100_total_100_percen() {
		return r129_pse_100_total_100_percen;
	}
	public void setR129_pse_100_total_100_percen(BigDecimal r129_pse_100_total_100_percen) {
		this.r129_pse_100_total_100_percen = r129_pse_100_total_100_percen;
	}
	public BigDecimal getR129_pse_100_ccf_non_fund_0_percen() {
		return r129_pse_100_ccf_non_fund_0_percen;
	}
	public void setR129_pse_100_ccf_non_fund_0_percen(BigDecimal r129_pse_100_ccf_non_fund_0_percen) {
		this.r129_pse_100_ccf_non_fund_0_percen = r129_pse_100_ccf_non_fund_0_percen;
	}
	public BigDecimal getR129_pse_100_ccf_non_fund_20_percen() {
		return r129_pse_100_ccf_non_fund_20_percen;
	}
	public void setR129_pse_100_ccf_non_fund_20_percen(BigDecimal r129_pse_100_ccf_non_fund_20_percen) {
		this.r129_pse_100_ccf_non_fund_20_percen = r129_pse_100_ccf_non_fund_20_percen;
	}
	public BigDecimal getR129_pse_100_ccf_non_fund_50_percen() {
		return r129_pse_100_ccf_non_fund_50_percen;
	}
	public void setR129_pse_100_ccf_non_fund_50_percen(BigDecimal r129_pse_100_ccf_non_fund_50_percen) {
		this.r129_pse_100_ccf_non_fund_50_percen = r129_pse_100_ccf_non_fund_50_percen;
	}
	public BigDecimal getR129_pse_100_ccf_non_fund_100_percen() {
		return r129_pse_100_ccf_non_fund_100_percen;
	}
	public void setR129_pse_100_ccf_non_fund_100_percen(BigDecimal r129_pse_100_ccf_non_fund_100_percen) {
		this.r129_pse_100_ccf_non_fund_100_percen = r129_pse_100_ccf_non_fund_100_percen;
	}
	public BigDecimal getR129_pse_100_ccf_fund_0_percen() {
		return r129_pse_100_ccf_fund_0_percen;
	}
	public void setR129_pse_100_ccf_fund_0_percen(BigDecimal r129_pse_100_ccf_fund_0_percen) {
		this.r129_pse_100_ccf_fund_0_percen = r129_pse_100_ccf_fund_0_percen;
	}
	public BigDecimal getR129_pse_100_ccf_fund_20_percen() {
		return r129_pse_100_ccf_fund_20_percen;
	}
	public void setR129_pse_100_ccf_fund_20_percen(BigDecimal r129_pse_100_ccf_fund_20_percen) {
		this.r129_pse_100_ccf_fund_20_percen = r129_pse_100_ccf_fund_20_percen;
	}
	public BigDecimal getR129_pse_100_ccf_fund_50_percen() {
		return r129_pse_100_ccf_fund_50_percen;
	}
	public void setR129_pse_100_ccf_fund_50_percen(BigDecimal r129_pse_100_ccf_fund_50_percen) {
		this.r129_pse_100_ccf_fund_50_percen = r129_pse_100_ccf_fund_50_percen;
	}
	public BigDecimal getR129_pse_100_ccf_fund_100_percen() {
		return r129_pse_100_ccf_fund_100_percen;
	}
	public void setR129_pse_100_ccf_fund_100_percen(BigDecimal r129_pse_100_ccf_fund_100_percen) {
		this.r129_pse_100_ccf_fund_100_percen = r129_pse_100_ccf_fund_100_percen;
	}
	public BigDecimal getR129_pse_100_ccf_non_fund_und_0_percen() {
		return r129_pse_100_ccf_non_fund_und_0_percen;
	}
	public void setR129_pse_100_ccf_non_fund_und_0_percen(BigDecimal r129_pse_100_ccf_non_fund_und_0_percen) {
		this.r129_pse_100_ccf_non_fund_und_0_percen = r129_pse_100_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR129_pse_100_ccf_non_fund_und_20_percen() {
		return r129_pse_100_ccf_non_fund_und_20_percen;
	}
	public void setR129_pse_100_ccf_non_fund_und_20_percen(BigDecimal r129_pse_100_ccf_non_fund_und_20_percen) {
		this.r129_pse_100_ccf_non_fund_und_20_percen = r129_pse_100_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR129_pse_100_ccf_non_fund_und_50_percen() {
		return r129_pse_100_ccf_non_fund_und_50_percen;
	}
	public void setR129_pse_100_ccf_non_fund_und_50_percen(BigDecimal r129_pse_100_ccf_non_fund_und_50_percen) {
		this.r129_pse_100_ccf_non_fund_und_50_percen = r129_pse_100_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR129_pse_100_ccf_non_fund_und_100_percen() {
		return r129_pse_100_ccf_non_fund_und_100_percen;
	}
	public void setR129_pse_100_ccf_non_fund_und_100_percen(BigDecimal r129_pse_100_ccf_non_fund_und_100_percen) {
		this.r129_pse_100_ccf_non_fund_und_100_percen = r129_pse_100_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR130_pse_150_total_0_percen() {
		return r130_pse_150_total_0_percen;
	}
	public void setR130_pse_150_total_0_percen(BigDecimal r130_pse_150_total_0_percen) {
		this.r130_pse_150_total_0_percen = r130_pse_150_total_0_percen;
	}
	public BigDecimal getR130_pse_150_total_20_percen() {
		return r130_pse_150_total_20_percen;
	}
	public void setR130_pse_150_total_20_percen(BigDecimal r130_pse_150_total_20_percen) {
		this.r130_pse_150_total_20_percen = r130_pse_150_total_20_percen;
	}
	public BigDecimal getR130_pse_150_total_50_percen() {
		return r130_pse_150_total_50_percen;
	}
	public void setR130_pse_150_total_50_percen(BigDecimal r130_pse_150_total_50_percen) {
		this.r130_pse_150_total_50_percen = r130_pse_150_total_50_percen;
	}
	public BigDecimal getR130_pse_150_total_100_percen() {
		return r130_pse_150_total_100_percen;
	}
	public void setR130_pse_150_total_100_percen(BigDecimal r130_pse_150_total_100_percen) {
		this.r130_pse_150_total_100_percen = r130_pse_150_total_100_percen;
	}
	public BigDecimal getR130_pse_150_ccf_non_fund_0_percen() {
		return r130_pse_150_ccf_non_fund_0_percen;
	}
	public void setR130_pse_150_ccf_non_fund_0_percen(BigDecimal r130_pse_150_ccf_non_fund_0_percen) {
		this.r130_pse_150_ccf_non_fund_0_percen = r130_pse_150_ccf_non_fund_0_percen;
	}
	public BigDecimal getR130_pse_150_ccf_non_fund_20_percen() {
		return r130_pse_150_ccf_non_fund_20_percen;
	}
	public void setR130_pse_150_ccf_non_fund_20_percen(BigDecimal r130_pse_150_ccf_non_fund_20_percen) {
		this.r130_pse_150_ccf_non_fund_20_percen = r130_pse_150_ccf_non_fund_20_percen;
	}
	public BigDecimal getR130_pse_150_ccf_non_fund_50_percen() {
		return r130_pse_150_ccf_non_fund_50_percen;
	}
	public void setR130_pse_150_ccf_non_fund_50_percen(BigDecimal r130_pse_150_ccf_non_fund_50_percen) {
		this.r130_pse_150_ccf_non_fund_50_percen = r130_pse_150_ccf_non_fund_50_percen;
	}
	public BigDecimal getR130_pse_150_ccf_non_fund_100_percen() {
		return r130_pse_150_ccf_non_fund_100_percen;
	}
	public void setR130_pse_150_ccf_non_fund_100_percen(BigDecimal r130_pse_150_ccf_non_fund_100_percen) {
		this.r130_pse_150_ccf_non_fund_100_percen = r130_pse_150_ccf_non_fund_100_percen;
	}
	public BigDecimal getR130_pse_150_ccf_fund_0_percen() {
		return r130_pse_150_ccf_fund_0_percen;
	}
	public void setR130_pse_150_ccf_fund_0_percen(BigDecimal r130_pse_150_ccf_fund_0_percen) {
		this.r130_pse_150_ccf_fund_0_percen = r130_pse_150_ccf_fund_0_percen;
	}
	public BigDecimal getR130_pse_150_ccf_fund_20_percen() {
		return r130_pse_150_ccf_fund_20_percen;
	}
	public void setR130_pse_150_ccf_fund_20_percen(BigDecimal r130_pse_150_ccf_fund_20_percen) {
		this.r130_pse_150_ccf_fund_20_percen = r130_pse_150_ccf_fund_20_percen;
	}
	public BigDecimal getR130_pse_150_ccf_fund_50_percen() {
		return r130_pse_150_ccf_fund_50_percen;
	}
	public void setR130_pse_150_ccf_fund_50_percen(BigDecimal r130_pse_150_ccf_fund_50_percen) {
		this.r130_pse_150_ccf_fund_50_percen = r130_pse_150_ccf_fund_50_percen;
	}
	public BigDecimal getR130_pse_150_ccf_fund_100_percen() {
		return r130_pse_150_ccf_fund_100_percen;
	}
	public void setR130_pse_150_ccf_fund_100_percen(BigDecimal r130_pse_150_ccf_fund_100_percen) {
		this.r130_pse_150_ccf_fund_100_percen = r130_pse_150_ccf_fund_100_percen;
	}
	public BigDecimal getR130_pse_150_ccf_non_fund_und_0_percen() {
		return r130_pse_150_ccf_non_fund_und_0_percen;
	}
	public void setR130_pse_150_ccf_non_fund_und_0_percen(BigDecimal r130_pse_150_ccf_non_fund_und_0_percen) {
		this.r130_pse_150_ccf_non_fund_und_0_percen = r130_pse_150_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR130_pse_150_ccf_non_fund_und_20_percen() {
		return r130_pse_150_ccf_non_fund_und_20_percen;
	}
	public void setR130_pse_150_ccf_non_fund_und_20_percen(BigDecimal r130_pse_150_ccf_non_fund_und_20_percen) {
		this.r130_pse_150_ccf_non_fund_und_20_percen = r130_pse_150_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR130_pse_150_ccf_non_fund_und_50_percen() {
		return r130_pse_150_ccf_non_fund_und_50_percen;
	}
	public void setR130_pse_150_ccf_non_fund_und_50_percen(BigDecimal r130_pse_150_ccf_non_fund_und_50_percen) {
		this.r130_pse_150_ccf_non_fund_und_50_percen = r130_pse_150_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR130_pse_150_ccf_non_fund_und_100_percen() {
		return r130_pse_150_ccf_non_fund_und_100_percen;
	}
	public void setR130_pse_150_ccf_non_fund_und_100_percen(BigDecimal r130_pse_150_ccf_non_fund_und_100_percen) {
		this.r130_pse_150_ccf_non_fund_und_100_percen = r130_pse_150_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR131_res_35_total_0_percen() {
		return r131_res_35_total_0_percen;
	}
	public void setR131_res_35_total_0_percen(BigDecimal r131_res_35_total_0_percen) {
		this.r131_res_35_total_0_percen = r131_res_35_total_0_percen;
	}
	public BigDecimal getR131_res_35_total_20_percen() {
		return r131_res_35_total_20_percen;
	}
	public void setR131_res_35_total_20_percen(BigDecimal r131_res_35_total_20_percen) {
		this.r131_res_35_total_20_percen = r131_res_35_total_20_percen;
	}
	public BigDecimal getR131_res_35_total_50_percen() {
		return r131_res_35_total_50_percen;
	}
	public void setR131_res_35_total_50_percen(BigDecimal r131_res_35_total_50_percen) {
		this.r131_res_35_total_50_percen = r131_res_35_total_50_percen;
	}
	public BigDecimal getR131_res_35_total_100_percen() {
		return r131_res_35_total_100_percen;
	}
	public void setR131_res_35_total_100_percen(BigDecimal r131_res_35_total_100_percen) {
		this.r131_res_35_total_100_percen = r131_res_35_total_100_percen;
	}
	public BigDecimal getR131_res_35_ccf_non_fund_0_percen() {
		return r131_res_35_ccf_non_fund_0_percen;
	}
	public void setR131_res_35_ccf_non_fund_0_percen(BigDecimal r131_res_35_ccf_non_fund_0_percen) {
		this.r131_res_35_ccf_non_fund_0_percen = r131_res_35_ccf_non_fund_0_percen;
	}
	public BigDecimal getR131_res_35_ccf_non_fund_20_percen() {
		return r131_res_35_ccf_non_fund_20_percen;
	}
	public void setR131_res_35_ccf_non_fund_20_percen(BigDecimal r131_res_35_ccf_non_fund_20_percen) {
		this.r131_res_35_ccf_non_fund_20_percen = r131_res_35_ccf_non_fund_20_percen;
	}
	public BigDecimal getR131_res_35_ccf_non_fund_50_percen() {
		return r131_res_35_ccf_non_fund_50_percen;
	}
	public void setR131_res_35_ccf_non_fund_50_percen(BigDecimal r131_res_35_ccf_non_fund_50_percen) {
		this.r131_res_35_ccf_non_fund_50_percen = r131_res_35_ccf_non_fund_50_percen;
	}
	public BigDecimal getR131_res_35_ccf_non_fund_100_percen() {
		return r131_res_35_ccf_non_fund_100_percen;
	}
	public void setR131_res_35_ccf_non_fund_100_percen(BigDecimal r131_res_35_ccf_non_fund_100_percen) {
		this.r131_res_35_ccf_non_fund_100_percen = r131_res_35_ccf_non_fund_100_percen;
	}
	public BigDecimal getR131_res_35_ccf_fund_0_percen() {
		return r131_res_35_ccf_fund_0_percen;
	}
	public void setR131_res_35_ccf_fund_0_percen(BigDecimal r131_res_35_ccf_fund_0_percen) {
		this.r131_res_35_ccf_fund_0_percen = r131_res_35_ccf_fund_0_percen;
	}
	public BigDecimal getR131_res_35_ccf_fund_20_percen() {
		return r131_res_35_ccf_fund_20_percen;
	}
	public void setR131_res_35_ccf_fund_20_percen(BigDecimal r131_res_35_ccf_fund_20_percen) {
		this.r131_res_35_ccf_fund_20_percen = r131_res_35_ccf_fund_20_percen;
	}
	public BigDecimal getR131_res_35_ccf_fund_50_percen() {
		return r131_res_35_ccf_fund_50_percen;
	}
	public void setR131_res_35_ccf_fund_50_percen(BigDecimal r131_res_35_ccf_fund_50_percen) {
		this.r131_res_35_ccf_fund_50_percen = r131_res_35_ccf_fund_50_percen;
	}
	public BigDecimal getR131_res_35_ccf_fund_100_percen() {
		return r131_res_35_ccf_fund_100_percen;
	}
	public void setR131_res_35_ccf_fund_100_percen(BigDecimal r131_res_35_ccf_fund_100_percen) {
		this.r131_res_35_ccf_fund_100_percen = r131_res_35_ccf_fund_100_percen;
	}
	public BigDecimal getR131_res_35_ccf_non_fund_und_0_percen() {
		return r131_res_35_ccf_non_fund_und_0_percen;
	}
	public void setR131_res_35_ccf_non_fund_und_0_percen(BigDecimal r131_res_35_ccf_non_fund_und_0_percen) {
		this.r131_res_35_ccf_non_fund_und_0_percen = r131_res_35_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR131_res_35_ccf_non_fund_und_20_percen() {
		return r131_res_35_ccf_non_fund_und_20_percen;
	}
	public void setR131_res_35_ccf_non_fund_und_20_percen(BigDecimal r131_res_35_ccf_non_fund_und_20_percen) {
		this.r131_res_35_ccf_non_fund_und_20_percen = r131_res_35_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR131_res_35_ccf_non_fund_und_50_percen() {
		return r131_res_35_ccf_non_fund_und_50_percen;
	}
	public void setR131_res_35_ccf_non_fund_und_50_percen(BigDecimal r131_res_35_ccf_non_fund_und_50_percen) {
		this.r131_res_35_ccf_non_fund_und_50_percen = r131_res_35_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR131_res_35_ccf_non_fund_und_100_percen() {
		return r131_res_35_ccf_non_fund_und_100_percen;
	}
	public void setR131_res_35_ccf_non_fund_und_100_percen(BigDecimal r131_res_35_ccf_non_fund_und_100_percen) {
		this.r131_res_35_ccf_non_fund_und_100_percen = r131_res_35_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR132_res_100_total_0_percen() {
		return r132_res_100_total_0_percen;
	}
	public void setR132_res_100_total_0_percen(BigDecimal r132_res_100_total_0_percen) {
		this.r132_res_100_total_0_percen = r132_res_100_total_0_percen;
	}
	public BigDecimal getR132_res_100_total_20_percen() {
		return r132_res_100_total_20_percen;
	}
	public void setR132_res_100_total_20_percen(BigDecimal r132_res_100_total_20_percen) {
		this.r132_res_100_total_20_percen = r132_res_100_total_20_percen;
	}
	public BigDecimal getR132_res_100_total_50_percen() {
		return r132_res_100_total_50_percen;
	}
	public void setR132_res_100_total_50_percen(BigDecimal r132_res_100_total_50_percen) {
		this.r132_res_100_total_50_percen = r132_res_100_total_50_percen;
	}
	public BigDecimal getR132_res_100_total_100_percen() {
		return r132_res_100_total_100_percen;
	}
	public void setR132_res_100_total_100_percen(BigDecimal r132_res_100_total_100_percen) {
		this.r132_res_100_total_100_percen = r132_res_100_total_100_percen;
	}
	public BigDecimal getR132_res_100_ccf_non_fund_0_percen() {
		return r132_res_100_ccf_non_fund_0_percen;
	}
	public void setR132_res_100_ccf_non_fund_0_percen(BigDecimal r132_res_100_ccf_non_fund_0_percen) {
		this.r132_res_100_ccf_non_fund_0_percen = r132_res_100_ccf_non_fund_0_percen;
	}
	public BigDecimal getR132_res_100_ccf_non_fund_20_percen() {
		return r132_res_100_ccf_non_fund_20_percen;
	}
	public void setR132_res_100_ccf_non_fund_20_percen(BigDecimal r132_res_100_ccf_non_fund_20_percen) {
		this.r132_res_100_ccf_non_fund_20_percen = r132_res_100_ccf_non_fund_20_percen;
	}
	public BigDecimal getR132_res_100_ccf_non_fund_50_percen() {
		return r132_res_100_ccf_non_fund_50_percen;
	}
	public void setR132_res_100_ccf_non_fund_50_percen(BigDecimal r132_res_100_ccf_non_fund_50_percen) {
		this.r132_res_100_ccf_non_fund_50_percen = r132_res_100_ccf_non_fund_50_percen;
	}
	public BigDecimal getR132_res_100_ccf_non_fund_100_percen() {
		return r132_res_100_ccf_non_fund_100_percen;
	}
	public void setR132_res_100_ccf_non_fund_100_percen(BigDecimal r132_res_100_ccf_non_fund_100_percen) {
		this.r132_res_100_ccf_non_fund_100_percen = r132_res_100_ccf_non_fund_100_percen;
	}
	public BigDecimal getR132_res_100_ccf_fund_0_percen() {
		return r132_res_100_ccf_fund_0_percen;
	}
	public void setR132_res_100_ccf_fund_0_percen(BigDecimal r132_res_100_ccf_fund_0_percen) {
		this.r132_res_100_ccf_fund_0_percen = r132_res_100_ccf_fund_0_percen;
	}
	public BigDecimal getR132_res_100_ccf_fund_20_percen() {
		return r132_res_100_ccf_fund_20_percen;
	}
	public void setR132_res_100_ccf_fund_20_percen(BigDecimal r132_res_100_ccf_fund_20_percen) {
		this.r132_res_100_ccf_fund_20_percen = r132_res_100_ccf_fund_20_percen;
	}
	public BigDecimal getR132_res_100_ccf_fund_50_percen() {
		return r132_res_100_ccf_fund_50_percen;
	}
	public void setR132_res_100_ccf_fund_50_percen(BigDecimal r132_res_100_ccf_fund_50_percen) {
		this.r132_res_100_ccf_fund_50_percen = r132_res_100_ccf_fund_50_percen;
	}
	public BigDecimal getR132_res_100_ccf_fund_100_percen() {
		return r132_res_100_ccf_fund_100_percen;
	}
	public void setR132_res_100_ccf_fund_100_percen(BigDecimal r132_res_100_ccf_fund_100_percen) {
		this.r132_res_100_ccf_fund_100_percen = r132_res_100_ccf_fund_100_percen;
	}
	public BigDecimal getR132_res_100_ccf_non_fund_und_0_percen() {
		return r132_res_100_ccf_non_fund_und_0_percen;
	}
	public void setR132_res_100_ccf_non_fund_und_0_percen(BigDecimal r132_res_100_ccf_non_fund_und_0_percen) {
		this.r132_res_100_ccf_non_fund_und_0_percen = r132_res_100_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR132_res_100_ccf_non_fund_und_20_percen() {
		return r132_res_100_ccf_non_fund_und_20_percen;
	}
	public void setR132_res_100_ccf_non_fund_und_20_percen(BigDecimal r132_res_100_ccf_non_fund_und_20_percen) {
		this.r132_res_100_ccf_non_fund_und_20_percen = r132_res_100_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR132_res_100_ccf_non_fund_und_50_percen() {
		return r132_res_100_ccf_non_fund_und_50_percen;
	}
	public void setR132_res_100_ccf_non_fund_und_50_percen(BigDecimal r132_res_100_ccf_non_fund_und_50_percen) {
		this.r132_res_100_ccf_non_fund_und_50_percen = r132_res_100_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR132_res_100_ccf_non_fund_und_100_percen() {
		return r132_res_100_ccf_non_fund_und_100_percen;
	}
	public void setR132_res_100_ccf_non_fund_und_100_percen(BigDecimal r132_res_100_ccf_non_fund_und_100_percen) {
		this.r132_res_100_ccf_non_fund_und_100_percen = r132_res_100_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR133_rrp_75_total_0_percen() {
		return r133_rrp_75_total_0_percen;
	}
	public void setR133_rrp_75_total_0_percen(BigDecimal r133_rrp_75_total_0_percen) {
		this.r133_rrp_75_total_0_percen = r133_rrp_75_total_0_percen;
	}
	public BigDecimal getR133_rrp_75_total_20_percen() {
		return r133_rrp_75_total_20_percen;
	}
	public void setR133_rrp_75_total_20_percen(BigDecimal r133_rrp_75_total_20_percen) {
		this.r133_rrp_75_total_20_percen = r133_rrp_75_total_20_percen;
	}
	public BigDecimal getR133_rrp_75_total_50_percen() {
		return r133_rrp_75_total_50_percen;
	}
	public void setR133_rrp_75_total_50_percen(BigDecimal r133_rrp_75_total_50_percen) {
		this.r133_rrp_75_total_50_percen = r133_rrp_75_total_50_percen;
	}
	public BigDecimal getR133_rrp_75_total_100_percen() {
		return r133_rrp_75_total_100_percen;
	}
	public void setR133_rrp_75_total_100_percen(BigDecimal r133_rrp_75_total_100_percen) {
		this.r133_rrp_75_total_100_percen = r133_rrp_75_total_100_percen;
	}
	public BigDecimal getR133_rrp_75_ccf_non_fund_0_percen() {
		return r133_rrp_75_ccf_non_fund_0_percen;
	}
	public void setR133_rrp_75_ccf_non_fund_0_percen(BigDecimal r133_rrp_75_ccf_non_fund_0_percen) {
		this.r133_rrp_75_ccf_non_fund_0_percen = r133_rrp_75_ccf_non_fund_0_percen;
	}
	public BigDecimal getR133_rrp_75_ccf_non_fund_20_percen() {
		return r133_rrp_75_ccf_non_fund_20_percen;
	}
	public void setR133_rrp_75_ccf_non_fund_20_percen(BigDecimal r133_rrp_75_ccf_non_fund_20_percen) {
		this.r133_rrp_75_ccf_non_fund_20_percen = r133_rrp_75_ccf_non_fund_20_percen;
	}
	public BigDecimal getR133_rrp_75_ccf_non_fund_50_percen() {
		return r133_rrp_75_ccf_non_fund_50_percen;
	}
	public void setR133_rrp_75_ccf_non_fund_50_percen(BigDecimal r133_rrp_75_ccf_non_fund_50_percen) {
		this.r133_rrp_75_ccf_non_fund_50_percen = r133_rrp_75_ccf_non_fund_50_percen;
	}
	public BigDecimal getR133_rrp_75_ccf_non_fund_100_percen() {
		return r133_rrp_75_ccf_non_fund_100_percen;
	}
	public void setR133_rrp_75_ccf_non_fund_100_percen(BigDecimal r133_rrp_75_ccf_non_fund_100_percen) {
		this.r133_rrp_75_ccf_non_fund_100_percen = r133_rrp_75_ccf_non_fund_100_percen;
	}
	public BigDecimal getR133_rrp_75_ccf_fund_0_percen() {
		return r133_rrp_75_ccf_fund_0_percen;
	}
	public void setR133_rrp_75_ccf_fund_0_percen(BigDecimal r133_rrp_75_ccf_fund_0_percen) {
		this.r133_rrp_75_ccf_fund_0_percen = r133_rrp_75_ccf_fund_0_percen;
	}
	public BigDecimal getR133_rrp_75_ccf_fund_20_percen() {
		return r133_rrp_75_ccf_fund_20_percen;
	}
	public void setR133_rrp_75_ccf_fund_20_percen(BigDecimal r133_rrp_75_ccf_fund_20_percen) {
		this.r133_rrp_75_ccf_fund_20_percen = r133_rrp_75_ccf_fund_20_percen;
	}
	public BigDecimal getR133_rrp_75_ccf_fund_50_percen() {
		return r133_rrp_75_ccf_fund_50_percen;
	}
	public void setR133_rrp_75_ccf_fund_50_percen(BigDecimal r133_rrp_75_ccf_fund_50_percen) {
		this.r133_rrp_75_ccf_fund_50_percen = r133_rrp_75_ccf_fund_50_percen;
	}
	public BigDecimal getR133_rrp_75_ccf_fund_100_percen() {
		return r133_rrp_75_ccf_fund_100_percen;
	}
	public void setR133_rrp_75_ccf_fund_100_percen(BigDecimal r133_rrp_75_ccf_fund_100_percen) {
		this.r133_rrp_75_ccf_fund_100_percen = r133_rrp_75_ccf_fund_100_percen;
	}
	public BigDecimal getR133_rrp_75_ccf_non_fund_und_0_percen() {
		return r133_rrp_75_ccf_non_fund_und_0_percen;
	}
	public void setR133_rrp_75_ccf_non_fund_und_0_percen(BigDecimal r133_rrp_75_ccf_non_fund_und_0_percen) {
		this.r133_rrp_75_ccf_non_fund_und_0_percen = r133_rrp_75_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR133_rrp_75_ccf_non_fund_und_20_percen() {
		return r133_rrp_75_ccf_non_fund_und_20_percen;
	}
	public void setR133_rrp_75_ccf_non_fund_und_20_percen(BigDecimal r133_rrp_75_ccf_non_fund_und_20_percen) {
		this.r133_rrp_75_ccf_non_fund_und_20_percen = r133_rrp_75_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR133_rrp_75_ccf_non_fund_und_50_percen() {
		return r133_rrp_75_ccf_non_fund_und_50_percen;
	}
	public void setR133_rrp_75_ccf_non_fund_und_50_percen(BigDecimal r133_rrp_75_ccf_non_fund_und_50_percen) {
		this.r133_rrp_75_ccf_non_fund_und_50_percen = r133_rrp_75_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR133_rrp_75_ccf_non_fund_und_100_percen() {
		return r133_rrp_75_ccf_non_fund_und_100_percen;
	}
	public void setR133_rrp_75_ccf_non_fund_und_100_percen(BigDecimal r133_rrp_75_ccf_non_fund_und_100_percen) {
		this.r133_rrp_75_ccf_non_fund_und_100_percen = r133_rrp_75_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR134_rrp_100_total_0_percen() {
		return r134_rrp_100_total_0_percen;
	}
	public void setR134_rrp_100_total_0_percen(BigDecimal r134_rrp_100_total_0_percen) {
		this.r134_rrp_100_total_0_percen = r134_rrp_100_total_0_percen;
	}
	public BigDecimal getR134_rrp_100_total_20_percen() {
		return r134_rrp_100_total_20_percen;
	}
	public void setR134_rrp_100_total_20_percen(BigDecimal r134_rrp_100_total_20_percen) {
		this.r134_rrp_100_total_20_percen = r134_rrp_100_total_20_percen;
	}
	public BigDecimal getR134_rrp_100_total_50_percen() {
		return r134_rrp_100_total_50_percen;
	}
	public void setR134_rrp_100_total_50_percen(BigDecimal r134_rrp_100_total_50_percen) {
		this.r134_rrp_100_total_50_percen = r134_rrp_100_total_50_percen;
	}
	public BigDecimal getR134_rrp_100_total_100_percen() {
		return r134_rrp_100_total_100_percen;
	}
	public void setR134_rrp_100_total_100_percen(BigDecimal r134_rrp_100_total_100_percen) {
		this.r134_rrp_100_total_100_percen = r134_rrp_100_total_100_percen;
	}
	public BigDecimal getR134_rrp_100_ccf_non_fund_0_percen() {
		return r134_rrp_100_ccf_non_fund_0_percen;
	}
	public void setR134_rrp_100_ccf_non_fund_0_percen(BigDecimal r134_rrp_100_ccf_non_fund_0_percen) {
		this.r134_rrp_100_ccf_non_fund_0_percen = r134_rrp_100_ccf_non_fund_0_percen;
	}
	public BigDecimal getR134_rrp_100_ccf_non_fund_20_percen() {
		return r134_rrp_100_ccf_non_fund_20_percen;
	}
	public void setR134_rrp_100_ccf_non_fund_20_percen(BigDecimal r134_rrp_100_ccf_non_fund_20_percen) {
		this.r134_rrp_100_ccf_non_fund_20_percen = r134_rrp_100_ccf_non_fund_20_percen;
	}
	public BigDecimal getR134_rrp_100_ccf_non_fund_50_percen() {
		return r134_rrp_100_ccf_non_fund_50_percen;
	}
	public void setR134_rrp_100_ccf_non_fund_50_percen(BigDecimal r134_rrp_100_ccf_non_fund_50_percen) {
		this.r134_rrp_100_ccf_non_fund_50_percen = r134_rrp_100_ccf_non_fund_50_percen;
	}
	public BigDecimal getR134_rrp_100_ccf_non_fund_100_percen() {
		return r134_rrp_100_ccf_non_fund_100_percen;
	}
	public void setR134_rrp_100_ccf_non_fund_100_percen(BigDecimal r134_rrp_100_ccf_non_fund_100_percen) {
		this.r134_rrp_100_ccf_non_fund_100_percen = r134_rrp_100_ccf_non_fund_100_percen;
	}
	public BigDecimal getR134_rrp_100_ccf_fund_0_percen() {
		return r134_rrp_100_ccf_fund_0_percen;
	}
	public void setR134_rrp_100_ccf_fund_0_percen(BigDecimal r134_rrp_100_ccf_fund_0_percen) {
		this.r134_rrp_100_ccf_fund_0_percen = r134_rrp_100_ccf_fund_0_percen;
	}
	public BigDecimal getR134_rrp_100_ccf_fund_20_percen() {
		return r134_rrp_100_ccf_fund_20_percen;
	}
	public void setR134_rrp_100_ccf_fund_20_percen(BigDecimal r134_rrp_100_ccf_fund_20_percen) {
		this.r134_rrp_100_ccf_fund_20_percen = r134_rrp_100_ccf_fund_20_percen;
	}
	public BigDecimal getR134_rrp_100_ccf_fund_50_percen() {
		return r134_rrp_100_ccf_fund_50_percen;
	}
	public void setR134_rrp_100_ccf_fund_50_percen(BigDecimal r134_rrp_100_ccf_fund_50_percen) {
		this.r134_rrp_100_ccf_fund_50_percen = r134_rrp_100_ccf_fund_50_percen;
	}
	public BigDecimal getR134_rrp_100_ccf_fund_100_percen() {
		return r134_rrp_100_ccf_fund_100_percen;
	}
	public void setR134_rrp_100_ccf_fund_100_percen(BigDecimal r134_rrp_100_ccf_fund_100_percen) {
		this.r134_rrp_100_ccf_fund_100_percen = r134_rrp_100_ccf_fund_100_percen;
	}
	public BigDecimal getR134_rrp_100_ccf_non_fund_und_0_percen() {
		return r134_rrp_100_ccf_non_fund_und_0_percen;
	}
	public void setR134_rrp_100_ccf_non_fund_und_0_percen(BigDecimal r134_rrp_100_ccf_non_fund_und_0_percen) {
		this.r134_rrp_100_ccf_non_fund_und_0_percen = r134_rrp_100_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR134_rrp_100_ccf_non_fund_und_20_percen() {
		return r134_rrp_100_ccf_non_fund_und_20_percen;
	}
	public void setR134_rrp_100_ccf_non_fund_und_20_percen(BigDecimal r134_rrp_100_ccf_non_fund_und_20_percen) {
		this.r134_rrp_100_ccf_non_fund_und_20_percen = r134_rrp_100_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR134_rrp_100_ccf_non_fund_und_50_percen() {
		return r134_rrp_100_ccf_non_fund_und_50_percen;
	}
	public void setR134_rrp_100_ccf_non_fund_und_50_percen(BigDecimal r134_rrp_100_ccf_non_fund_und_50_percen) {
		this.r134_rrp_100_ccf_non_fund_und_50_percen = r134_rrp_100_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR134_rrp_100_ccf_non_fund_und_100_percen() {
		return r134_rrp_100_ccf_non_fund_und_100_percen;
	}
	public void setR134_rrp_100_ccf_non_fund_und_100_percen(BigDecimal r134_rrp_100_ccf_non_fund_und_100_percen) {
		this.r134_rrp_100_ccf_non_fund_und_100_percen = r134_rrp_100_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR135_rrp_75_total_0_percen() {
		return r135_rrp_75_total_0_percen;
	}
	public void setR135_rrp_75_total_0_percen(BigDecimal r135_rrp_75_total_0_percen) {
		this.r135_rrp_75_total_0_percen = r135_rrp_75_total_0_percen;
	}
	public BigDecimal getR135_rrp_75_total_20_percen() {
		return r135_rrp_75_total_20_percen;
	}
	public void setR135_rrp_75_total_20_percen(BigDecimal r135_rrp_75_total_20_percen) {
		this.r135_rrp_75_total_20_percen = r135_rrp_75_total_20_percen;
	}
	public BigDecimal getR135_rrp_75_total_50_percen() {
		return r135_rrp_75_total_50_percen;
	}
	public void setR135_rrp_75_total_50_percen(BigDecimal r135_rrp_75_total_50_percen) {
		this.r135_rrp_75_total_50_percen = r135_rrp_75_total_50_percen;
	}
	public BigDecimal getR135_rrp_75_total_100_percen() {
		return r135_rrp_75_total_100_percen;
	}
	public void setR135_rrp_75_total_100_percen(BigDecimal r135_rrp_75_total_100_percen) {
		this.r135_rrp_75_total_100_percen = r135_rrp_75_total_100_percen;
	}
	public BigDecimal getR135_rrp_75_ccf_non_fund_0_percen() {
		return r135_rrp_75_ccf_non_fund_0_percen;
	}
	public void setR135_rrp_75_ccf_non_fund_0_percen(BigDecimal r135_rrp_75_ccf_non_fund_0_percen) {
		this.r135_rrp_75_ccf_non_fund_0_percen = r135_rrp_75_ccf_non_fund_0_percen;
	}
	public BigDecimal getR135_rrp_75_ccf_non_fund_20_percen() {
		return r135_rrp_75_ccf_non_fund_20_percen;
	}
	public void setR135_rrp_75_ccf_non_fund_20_percen(BigDecimal r135_rrp_75_ccf_non_fund_20_percen) {
		this.r135_rrp_75_ccf_non_fund_20_percen = r135_rrp_75_ccf_non_fund_20_percen;
	}
	public BigDecimal getR135_rrp_75_ccf_non_fund_50_percen() {
		return r135_rrp_75_ccf_non_fund_50_percen;
	}
	public void setR135_rrp_75_ccf_non_fund_50_percen(BigDecimal r135_rrp_75_ccf_non_fund_50_percen) {
		this.r135_rrp_75_ccf_non_fund_50_percen = r135_rrp_75_ccf_non_fund_50_percen;
	}
	public BigDecimal getR135_rrp_75_ccf_non_fund_100_percen() {
		return r135_rrp_75_ccf_non_fund_100_percen;
	}
	public void setR135_rrp_75_ccf_non_fund_100_percen(BigDecimal r135_rrp_75_ccf_non_fund_100_percen) {
		this.r135_rrp_75_ccf_non_fund_100_percen = r135_rrp_75_ccf_non_fund_100_percen;
	}
	public BigDecimal getR135_rrp_75_ccf_fund_0_percen() {
		return r135_rrp_75_ccf_fund_0_percen;
	}
	public void setR135_rrp_75_ccf_fund_0_percen(BigDecimal r135_rrp_75_ccf_fund_0_percen) {
		this.r135_rrp_75_ccf_fund_0_percen = r135_rrp_75_ccf_fund_0_percen;
	}
	public BigDecimal getR135_rrp_75_ccf_fund_20_percen() {
		return r135_rrp_75_ccf_fund_20_percen;
	}
	public void setR135_rrp_75_ccf_fund_20_percen(BigDecimal r135_rrp_75_ccf_fund_20_percen) {
		this.r135_rrp_75_ccf_fund_20_percen = r135_rrp_75_ccf_fund_20_percen;
	}
	public BigDecimal getR135_rrp_75_ccf_fund_50_percen() {
		return r135_rrp_75_ccf_fund_50_percen;
	}
	public void setR135_rrp_75_ccf_fund_50_percen(BigDecimal r135_rrp_75_ccf_fund_50_percen) {
		this.r135_rrp_75_ccf_fund_50_percen = r135_rrp_75_ccf_fund_50_percen;
	}
	public BigDecimal getR135_rrp_75_ccf_fund_100_percen() {
		return r135_rrp_75_ccf_fund_100_percen;
	}
	public void setR135_rrp_75_ccf_fund_100_percen(BigDecimal r135_rrp_75_ccf_fund_100_percen) {
		this.r135_rrp_75_ccf_fund_100_percen = r135_rrp_75_ccf_fund_100_percen;
	}
	public BigDecimal getR135_rrp_75_ccf_non_fund_und_0_percen() {
		return r135_rrp_75_ccf_non_fund_und_0_percen;
	}
	public void setR135_rrp_75_ccf_non_fund_und_0_percen(BigDecimal r135_rrp_75_ccf_non_fund_und_0_percen) {
		this.r135_rrp_75_ccf_non_fund_und_0_percen = r135_rrp_75_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR135_rrp_75_ccf_non_fund_und_20_percen() {
		return r135_rrp_75_ccf_non_fund_und_20_percen;
	}
	public void setR135_rrp_75_ccf_non_fund_und_20_percen(BigDecimal r135_rrp_75_ccf_non_fund_und_20_percen) {
		this.r135_rrp_75_ccf_non_fund_und_20_percen = r135_rrp_75_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR135_rrp_75_ccf_non_fund_und_50_percen() {
		return r135_rrp_75_ccf_non_fund_und_50_percen;
	}
	public void setR135_rrp_75_ccf_non_fund_und_50_percen(BigDecimal r135_rrp_75_ccf_non_fund_und_50_percen) {
		this.r135_rrp_75_ccf_non_fund_und_50_percen = r135_rrp_75_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR135_rrp_75_ccf_non_fund_und_100_percen() {
		return r135_rrp_75_ccf_non_fund_und_100_percen;
	}
	public void setR135_rrp_75_ccf_non_fund_und_100_percen(BigDecimal r135_rrp_75_ccf_non_fund_und_100_percen) {
		this.r135_rrp_75_ccf_non_fund_und_100_percen = r135_rrp_75_ccf_non_fund_und_100_percen;
	}
	public BigDecimal getR136_rrp_85_total_0_percen() {
		return r136_rrp_85_total_0_percen;
	}
	public void setR136_rrp_85_total_0_percen(BigDecimal r136_rrp_85_total_0_percen) {
		this.r136_rrp_85_total_0_percen = r136_rrp_85_total_0_percen;
	}
	public BigDecimal getR136_rrp_85_total_20_percen() {
		return r136_rrp_85_total_20_percen;
	}
	public void setR136_rrp_85_total_20_percen(BigDecimal r136_rrp_85_total_20_percen) {
		this.r136_rrp_85_total_20_percen = r136_rrp_85_total_20_percen;
	}
	public BigDecimal getR136_rrp_85_total_50_percen() {
		return r136_rrp_85_total_50_percen;
	}
	public void setR136_rrp_85_total_50_percen(BigDecimal r136_rrp_85_total_50_percen) {
		this.r136_rrp_85_total_50_percen = r136_rrp_85_total_50_percen;
	}
	public BigDecimal getR136_rrp_85_total_100_percen() {
		return r136_rrp_85_total_100_percen;
	}
	public void setR136_rrp_85_total_100_percen(BigDecimal r136_rrp_85_total_100_percen) {
		this.r136_rrp_85_total_100_percen = r136_rrp_85_total_100_percen;
	}
	public BigDecimal getR136_rrp_85_ccf_non_fund_0_percen() {
		return r136_rrp_85_ccf_non_fund_0_percen;
	}
	public void setR136_rrp_85_ccf_non_fund_0_percen(BigDecimal r136_rrp_85_ccf_non_fund_0_percen) {
		this.r136_rrp_85_ccf_non_fund_0_percen = r136_rrp_85_ccf_non_fund_0_percen;
	}
	public BigDecimal getR136_rrp_85_ccf_non_fund_20_percen() {
		return r136_rrp_85_ccf_non_fund_20_percen;
	}
	public void setR136_rrp_85_ccf_non_fund_20_percen(BigDecimal r136_rrp_85_ccf_non_fund_20_percen) {
		this.r136_rrp_85_ccf_non_fund_20_percen = r136_rrp_85_ccf_non_fund_20_percen;
	}
	public BigDecimal getR136_rrp_85_ccf_non_fund_50_percen() {
		return r136_rrp_85_ccf_non_fund_50_percen;
	}
	public void setR136_rrp_85_ccf_non_fund_50_percen(BigDecimal r136_rrp_85_ccf_non_fund_50_percen) {
		this.r136_rrp_85_ccf_non_fund_50_percen = r136_rrp_85_ccf_non_fund_50_percen;
	}
	public BigDecimal getR136_rrp_85_ccf_non_fund_100_percen() {
		return r136_rrp_85_ccf_non_fund_100_percen;
	}
	public void setR136_rrp_85_ccf_non_fund_100_percen(BigDecimal r136_rrp_85_ccf_non_fund_100_percen) {
		this.r136_rrp_85_ccf_non_fund_100_percen = r136_rrp_85_ccf_non_fund_100_percen;
	}
	public BigDecimal getR136_rrp_85_ccf_fund_0_percen() {
		return r136_rrp_85_ccf_fund_0_percen;
	}
	public void setR136_rrp_85_ccf_fund_0_percen(BigDecimal r136_rrp_85_ccf_fund_0_percen) {
		this.r136_rrp_85_ccf_fund_0_percen = r136_rrp_85_ccf_fund_0_percen;
	}
	public BigDecimal getR136_rrp_85_ccf_fund_20_percen() {
		return r136_rrp_85_ccf_fund_20_percen;
	}
	public void setR136_rrp_85_ccf_fund_20_percen(BigDecimal r136_rrp_85_ccf_fund_20_percen) {
		this.r136_rrp_85_ccf_fund_20_percen = r136_rrp_85_ccf_fund_20_percen;
	}
	public BigDecimal getR136_rrp_85_ccf_fund_50_percen() {
		return r136_rrp_85_ccf_fund_50_percen;
	}
	public void setR136_rrp_85_ccf_fund_50_percen(BigDecimal r136_rrp_85_ccf_fund_50_percen) {
		this.r136_rrp_85_ccf_fund_50_percen = r136_rrp_85_ccf_fund_50_percen;
	}
	public BigDecimal getR136_rrp_85_ccf_fund_100_percen() {
		return r136_rrp_85_ccf_fund_100_percen;
	}
	public void setR136_rrp_85_ccf_fund_100_percen(BigDecimal r136_rrp_85_ccf_fund_100_percen) {
		this.r136_rrp_85_ccf_fund_100_percen = r136_rrp_85_ccf_fund_100_percen;
	}
	public BigDecimal getR136_rrp_85_ccf_non_fund_und_0_percen() {
		return r136_rrp_85_ccf_non_fund_und_0_percen;
	}
	public void setR136_rrp_85_ccf_non_fund_und_0_percen(BigDecimal r136_rrp_85_ccf_non_fund_und_0_percen) {
		this.r136_rrp_85_ccf_non_fund_und_0_percen = r136_rrp_85_ccf_non_fund_und_0_percen;
	}
	public BigDecimal getR136_rrp_85_ccf_non_fund_und_20_percen() {
		return r136_rrp_85_ccf_non_fund_und_20_percen;
	}
	public void setR136_rrp_85_ccf_non_fund_und_20_percen(BigDecimal r136_rrp_85_ccf_non_fund_und_20_percen) {
		this.r136_rrp_85_ccf_non_fund_und_20_percen = r136_rrp_85_ccf_non_fund_und_20_percen;
	}
	public BigDecimal getR136_rrp_85_ccf_non_fund_und_50_percen() {
		return r136_rrp_85_ccf_non_fund_und_50_percen;
	}
	public void setR136_rrp_85_ccf_non_fund_und_50_percen(BigDecimal r136_rrp_85_ccf_non_fund_und_50_percen) {
		this.r136_rrp_85_ccf_non_fund_und_50_percen = r136_rrp_85_ccf_non_fund_und_50_percen;
	}
	public BigDecimal getR136_rrp_85_ccf_non_fund_und_100_percen() {
		return r136_rrp_85_ccf_non_fund_und_100_percen;
	}
	public void setR136_rrp_85_ccf_non_fund_und_100_percen(BigDecimal r136_rrp_85_ccf_non_fund_und_100_percen) {
		this.r136_rrp_85_ccf_non_fund_und_100_percen = r136_rrp_85_ccf_non_fund_und_100_percen;
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
	public String getReport_code() {
		return report_code;
	}
	public void setReport_code(String report_code) {
		this.report_code = report_code;
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
	
	public BRF95_NONFUND_BASED_TABLE2() {
		super();
		// TODO Auto-generated constructor stub
	}
}