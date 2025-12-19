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
@Table(name="BRF95_NONFUND_BASED_TABLE1")
public class BRF95_NONFUND_BASED_TABLE1 {
	private BigDecimal	r100_bnk_0_lcbg_balance;
	private BigDecimal	r100_bnk_0_acceptance_amount;
	private BigDecimal	r100_bnk_0_lcbg_crm;
	private BigDecimal	r100_bnk_0_rwa;
	private BigDecimal	r100_bnk_0_under_ccf_amt;
	private BigDecimal	r101_bnk_0_lcbg_balance;
	private BigDecimal	r101_bnk_0_acceptance_amount;
	private BigDecimal	r101_bnk_0_lcbg_crm;
	private BigDecimal	r101_bnk_0_rwa;
	private BigDecimal	r101_bnk_0_under_ccf_amt;
	private BigDecimal	r102_bnk_0_lcbg_balance;
	private BigDecimal	r102_bnk_0_acceptance_amount;
	private BigDecimal	r102_bnk_0_lcbg_crm;
	private BigDecimal	r102_bnk_0_rwa;
	private BigDecimal	r102_bnk_0_under_ccf_amt;
	private BigDecimal	r103_bnk_lcbg_balance;
	private BigDecimal	r103_bnk_acceptance_amount;
	private BigDecimal	r103_bnk_lcbg_crm;
	private BigDecimal	r103_bnk_rwa;
	private BigDecimal	r103_bnk_under_ccf_amt;
	private BigDecimal	r104_bnk_20_lcbg_balance;
	private BigDecimal	r104_bnk_20_acceptance_amount;
	private BigDecimal	r104_bnk_20_lcbg_crm;
	private BigDecimal	r104_bnk_20_rwa;
	private BigDecimal	r104_bnk_20_under_ccf_amt;
	private BigDecimal	r105_bnk_20_lcbg_balance;
	private BigDecimal	r105_bnk_20_acceptance_amount;
	private BigDecimal	r105_bnk_20_lcbg_crm;
	private BigDecimal	r105_bnk_20_rwa;
	private BigDecimal	r105_bnk_20_under_ccf_amt;
	private BigDecimal	r106_bnk_20_lcbg_balance;
	private BigDecimal	r106_bnk_20_acceptance_amount;
	private BigDecimal	r106_bnk_20_lcbg_crm;
	private BigDecimal	r106_bnk_20_rwa;
	private BigDecimal	r106_bnk_20_under_ccf_amt;
	private BigDecimal	r107_bnk_lcbg_balance;
	private BigDecimal	r107_bnk_acceptance_amount;
	private BigDecimal	r107_bnk_lcbg_crm;
	private BigDecimal	r107_bnk_rwa;
	private BigDecimal	r107_bnk_under_ccf_amt;
	private BigDecimal	r108_bnk_50_lcbg_balance;
	private BigDecimal	r108_bnk_50_acceptance_amount;
	private BigDecimal	r108_bnk_50_lcbg_crm;
	private BigDecimal	r108_bnk_50_rwa;
	private BigDecimal	r108_bnk_50_under_ccf_amt;
	private BigDecimal	r109_bnk_50_lcbg_balance;
	private BigDecimal	r109_bnk_50_acceptance_amount;
	private BigDecimal	r109_bnk_50_lcbg_crm;
	private BigDecimal	r109_bnk_50_rwa;
	private BigDecimal	r109_bnk_50_under_ccf_amt;
	private BigDecimal	r110_bnk_50_lcbg_balance;
	private BigDecimal	r110_bnk_50_acceptance_amount;
	private BigDecimal	r110_bnk_50_lcbg_crm;
	private BigDecimal	r110_bnk_50_rwa;
	private BigDecimal	r110_bnk_50_under_ccf_amt;
	private BigDecimal	r111_bnk_lcbg_balance;
	private BigDecimal	r111_bnk_acceptance_amount;
	private BigDecimal	r111_bnk_lcbg_crm;
	private BigDecimal	r111_bnk_rwa;
	private BigDecimal	r111_bnk_under_ccf_amt;
	private BigDecimal	r112_bnk_100_lcbg_balance;
	private BigDecimal	r112_bnk_100_acceptance_amount;
	private BigDecimal	r112_bnk_100_lcbg_crm;
	private BigDecimal	r112_bnk_100_rwa;
	private BigDecimal	r112_bnk_100_under_ccf_amt;
	private BigDecimal	r113_bnk_100_lcbg_balance;
	private BigDecimal	r113_bnk_100_acceptance_amount;
	private BigDecimal	r113_bnk_100_lcbg_crm;
	private BigDecimal	r113_bnk_100_rwa;
	private BigDecimal	r113_bnk_100_under_ccf_amt;
	private BigDecimal	r114_bnk_100_lcbg_balance;
	private BigDecimal	r114_bnk_100_acceptance_amount;
	private BigDecimal	r114_bnk_100_lcbg_crm;
	private BigDecimal	r114_bnk_100_rwa;
	private BigDecimal	r114_bnk_100_under_ccf_amt;
	private BigDecimal	r115_bnk_lcbg_balance;
	private BigDecimal	r115_bnk_acceptance_amount;
	private BigDecimal	r115_bnk_lcbg_crm;
	private BigDecimal	r115_bnk_rwa;
	private BigDecimal	r115_bnk_under_ccf_amt;
	private BigDecimal	r116_bnk_150_lcbg_balance;
	private BigDecimal	r116_bnk_150_acceptance_amount;
	private BigDecimal	r116_bnk_150_lcbg_crm;
	private BigDecimal	r116_bnk_150_rwa;
	private BigDecimal	r116_bnk_150_under_ccf_amt;
	private BigDecimal	r117_bnk_150_lcbg_balance;
	private BigDecimal	r117_bnk_150_acceptance_amount;
	private BigDecimal	r117_bnk_150_lcbg_crm;
	private BigDecimal	r117_bnk_150_rwa;
	private BigDecimal	r117_bnk_150_under_ccf_amt;
	private BigDecimal	r118_bnk_150_lcbg_balance;
	private BigDecimal	r118_bnk_150_acceptance_amount;
	private BigDecimal	r118_bnk_150_lcbg_crm;
	private BigDecimal	r118_bnk_150_rwa;
	private BigDecimal	r118_bnk_150_under_ccf_amt;
	private BigDecimal	r119_bnk_lcbg_balance;
	private BigDecimal	r119_bnk_acceptance_amount;
	private BigDecimal	r119_bnk_lcbg_crm;
	private BigDecimal	r119_bnk_rwa;
	private BigDecimal	r119_bnk_under_ccf_amt;
	private BigDecimal	r120_cbs_0_lcbg_balance;
	private BigDecimal	r120_cbs_0_acceptance_amount;
	private BigDecimal	r120_cbs_0_lcbg_crm;
	private BigDecimal	r120_cbs_0_rwa;
	private BigDecimal	r120_cbs_0_under_ccf_amt;
	private BigDecimal	r121_cbs_0_lcbg_balance;
	private BigDecimal	r121_cbs_0_acceptance_amount;
	private BigDecimal	r121_cbs_0_lcbg_crm;
	private BigDecimal	r121_cbs_0_rwa;
	private BigDecimal	r121_cbs_0_under_ccf_amt;
	private BigDecimal	r122_cbs_0_lcbg_balance;
	private BigDecimal	r122_cbs_0_acceptance_amount;
	private BigDecimal	r122_cbs_0_lcbg_crm;
	private BigDecimal	r122_cbs_0_rwa;
	private BigDecimal	r122_cbs_0_under_ccf_amt;
	private BigDecimal	r123_cbs_lcbg_balance;
	private BigDecimal	r123_cbs_acceptance_amount;
	private BigDecimal	r123_cbs_lcbg_crm;
	private BigDecimal	r123_cbs_rwa;
	private BigDecimal	r123_cbs_under_ccf_amt;
	private BigDecimal	r124_cbs_20_lcbg_balance;
	private BigDecimal	r124_cbs_20_acceptance_amount;
	private BigDecimal	r124_cbs_20_lcbg_crm;
	private BigDecimal	r124_cbs_20_rwa;
	private BigDecimal	r124_cbs_20_under_ccf_amt;
	private BigDecimal	r125_cbs_20_lcbg_balance;
	private BigDecimal	r125_cbs_20_acceptance_amount;
	private BigDecimal	r125_cbs_20_lcbg_crm;
	private BigDecimal	r125_cbs_20_rwa;
	private BigDecimal	r125_cbs_20_under_ccf_amt;
	private BigDecimal	r126_cbs_20_lcbg_balance;
	private BigDecimal	r126_cbs_20_acceptance_amount;
	private BigDecimal	r126_cbs_20_lcbg_crm;
	private BigDecimal	r126_cbs_20_rwa;
	private BigDecimal	r126_cbs_20_under_ccf_amt;
	private BigDecimal	r127_cbs_lcbg_balance;
	private BigDecimal	r127_cbs_acceptance_amount;
	private BigDecimal	r127_cbs_lcbg_crm;
	private BigDecimal	r127_cbs_rwa;
	private BigDecimal	r127_cbs_under_ccf_amt;
	private BigDecimal	r128_cbs_20_lcbg_balance;
	private BigDecimal	r128_cbs_20_acceptance_amount;
	private BigDecimal	r128_cbs_20_lcbg_crm;
	private BigDecimal	r128_cbs_20_rwa;
	private BigDecimal	r128_cbs_20_under_ccf_amt;
	private BigDecimal	r129_cbs_20_lcbg_balance;
	private BigDecimal	r129_cbs_20_acceptance_amount;
	private BigDecimal	r129_cbs_20_lcbg_crm;
	private BigDecimal	r129_cbs_20_rwa;
	private BigDecimal	r129_cbs_20_under_ccf_amt;
	private BigDecimal	r130_cbs_20_lcbg_balance;
	private BigDecimal	r130_cbs_20_acceptance_amount;
	private BigDecimal	r130_cbs_20_lcbg_crm;
	private BigDecimal	r130_cbs_20_rwa;
	private BigDecimal	r130_cbs_20_under_ccf_amt;
	private BigDecimal	r131_cbs_lcbg_balance;
	private BigDecimal	r131_cbs_acceptance_amount;
	private BigDecimal	r131_cbs_lcbg_crm;
	private BigDecimal	r131_cbs_rwa;
	private BigDecimal	r131_cbs_under_ccf_amt;
	private BigDecimal	r132_cbs_0_lcbg_balance;
	private BigDecimal	r132_cbs_0_acceptance_amount;
	private BigDecimal	r132_cbs_0_lcbg_crm;
	private BigDecimal	r132_cbs_0_rwa;
	private BigDecimal	r132_cbs_0_under_ccf_amt;
	private BigDecimal	r133_cbs_0_lcbg_balance;
	private BigDecimal	r133_cbs_0_acceptance_amount;
	private BigDecimal	r133_cbs_0_lcbg_crm;
	private BigDecimal	r133_cbs_0_rwa;
	private BigDecimal	r133_cbs_0_under_ccf_amt;
	private BigDecimal	r134_cbs_0_lcbg_balance;
	private BigDecimal	r134_cbs_0_acceptance_amount;
	private BigDecimal	r134_cbs_0_lcbg_crm;
	private BigDecimal	r134_cbs_0_rwa;
	private BigDecimal	r134_cbs_0_under_ccf_amt;
	private BigDecimal	r135_cbs_lcbg_balance;
	private BigDecimal	r135_cbs_acceptance_amount;
	private BigDecimal	r135_cbs_lcbg_crm;
	private BigDecimal	r135_cbs_rwa;
	private BigDecimal	r135_cbs_under_ccf_amt;
	private BigDecimal	r136_cbs_20_lcbg_balance;
	private BigDecimal	r136_cbs_20_acceptance_amount;
	private BigDecimal	r136_cbs_20_lcbg_crm;
	private BigDecimal	r136_cbs_20_rwa;
	private BigDecimal	r136_cbs_20_under_ccf_amt;
	private BigDecimal	r137_cbs_20_lcbg_balance;
	private BigDecimal	r137_cbs_20_acceptance_amount;
	private BigDecimal	r137_cbs_20_lcbg_crm;
	private BigDecimal	r137_cbs_20_rwa;
	private BigDecimal	r137_cbs_20_under_ccf_amt;
	private BigDecimal	r138_cbs_20_lcbg_balance;
	private BigDecimal	r138_cbs_20_acceptance_amount;
	private BigDecimal	r138_cbs_20_lcbg_crm;
	private BigDecimal	r138_cbs_20_rwa;
	private BigDecimal	r138_cbs_20_under_ccf_amt;
	private BigDecimal	r139_cbs_lcbg_balance;
	private BigDecimal	r139_cbs_acceptance_amount;
	private BigDecimal	r139_cbs_lcbg_crm;
	private BigDecimal	r139_cbs_rwa;
	private BigDecimal	r139_cbs_under_ccf_amt;
	private BigDecimal	r140_cbs_50_lcbg_balance;
	private BigDecimal	r140_cbs_50_acceptance_amount;
	private BigDecimal	r140_cbs_50_lcbg_crm;
	private BigDecimal	r140_cbs_50_rwa;
	private BigDecimal	r140_cbs_50_under_ccf_amt;
	private BigDecimal	r141_cbs_50_lcbg_balance;
	private BigDecimal	r141_cbs_50_acceptance_amount;
	private BigDecimal	r141_cbs_50_lcbg_crm;
	private BigDecimal	r141_cbs_50_rwa;
	private BigDecimal	r141_cbs_50_under_ccf_amt;
	private BigDecimal	r142_cbs_50_lcbg_balance;
	private BigDecimal	r142_cbs_50_acceptance_amount;
	private BigDecimal	r142_cbs_50_lcbg_crm;
	private BigDecimal	r142_cbs_50_rwa;
	private BigDecimal	r142_cbs_50_under_ccf_amt;
	private BigDecimal	r143_cbs_lcbg_balance;
	private BigDecimal	r143_cbs_acceptance_amount;
	private BigDecimal	r143_cbs_lcbg_crm;
	private BigDecimal	r143_cbs_rwa;
	private BigDecimal	r143_cbs_under_ccf_amt;
	private BigDecimal	r144_cbs_100_lcbg_balance;
	private BigDecimal	r144_cbs_100_acceptance_amount;
	private BigDecimal	r144_cbs_100_lcbg_crm;
	private BigDecimal	r144_cbs_100_rwa;
	private BigDecimal	r144_cbs_100_under_ccf_amt;
	private BigDecimal	r145_cbs_100_lcbg_balance;
	private BigDecimal	r145_cbs_100_acceptance_amount;
	private BigDecimal	r145_cbs_100_lcbg_crm;
	private BigDecimal	r145_cbs_100_rwa;
	private BigDecimal	r145_cbs_100_under_ccf_amt;
	private BigDecimal	r146_cbs_100_lcbg_balance;
	private BigDecimal	r146_cbs_100_acceptance_amount;
	private BigDecimal	r146_cbs_100_lcbg_crm;
	private BigDecimal	r146_cbs_100_rwa;
	private BigDecimal	r146_cbs_100_under_ccf_amt;
	private BigDecimal	r147_cbs_lcbg_balance;
	private BigDecimal	r147_cbs_acceptance_amount;
	private BigDecimal	r147_cbs_lcbg_crm;
	private BigDecimal	r147_cbs_rwa;
	private BigDecimal	r147_cbs_under_ccf_amt;
	private BigDecimal	r148_cbs_150_lcbg_balance;
	private BigDecimal	r148_cbs_150_acceptance_amount;
	private BigDecimal	r148_cbs_150_lcbg_crm;
	private BigDecimal	r148_cbs_150_rwa;
	private BigDecimal	r148_cbs_150_under_ccf_amt;
	private BigDecimal	r149_cbs_150_lcbg_balance;
	private BigDecimal	r149_cbs_150_acceptance_amount;
	private BigDecimal	r149_cbs_150_lcbg_crm;
	private BigDecimal	r149_cbs_150_rwa;
	private BigDecimal	r149_cbs_150_under_ccf_amt;
	private BigDecimal	r150_cbs_150_lcbg_balance;
	private BigDecimal	r150_cbs_150_acceptance_amount;
	private BigDecimal	r150_cbs_150_lcbg_crm;
	private BigDecimal	r150_cbs_150_rwa;
	private BigDecimal	r150_cbs_150_under_ccf_amt;
	private BigDecimal	r151_cbs_lcbg_balance;
	private BigDecimal	r151_cbs_acceptance_amount;
	private BigDecimal	r151_cbs_lcbg_crm;
	private BigDecimal	r151_cbs_rwa;
	private BigDecimal	r151_cbs_under_ccf_amt;
	private BigDecimal	r152_cre_0_lcbg_balance;
	private BigDecimal	r152_cre_0_acceptance_amount;
	private BigDecimal	r152_cre_0_lcbg_crm;
	private BigDecimal	r152_cre_0_rwa;
	private BigDecimal	r152_cre_0_under_ccf_amt;
	private BigDecimal	r153_cre_0_lcbg_balance;
	private BigDecimal	r153_cre_0_acceptance_amount;
	private BigDecimal	r153_cre_0_lcbg_crm;
	private BigDecimal	r153_cre_0_rwa;
	private BigDecimal	r153_cre_0_under_ccf_amt;
	private BigDecimal	r154_cre_0_lcbg_balance;
	private BigDecimal	r154_cre_0_acceptance_amount;
	private BigDecimal	r154_cre_0_lcbg_crm;
	private BigDecimal	r154_cre_0_rwa;
	private BigDecimal	r154_cre_0_under_ccf_amt;
	private BigDecimal	r155_cre_lcbg_balance;
	private BigDecimal	r155_cre_acceptance_amount;
	private BigDecimal	r155_cre_lcbg_crm;
	private BigDecimal	r155_cre_rwa;
	private BigDecimal	r155_cre_under_ccf_amt;
	private BigDecimal	r156_cre_20_lcbg_balance;
	private BigDecimal	r156_cre_20_acceptance_amount;
	private BigDecimal	r156_cre_20_lcbg_crm;
	private BigDecimal	r156_cre_20_rwa;
	private BigDecimal	r156_cre_20_under_ccf_amt;
	private BigDecimal	r157_cre_20_lcbg_balance;
	private BigDecimal	r157_cre_20_acceptance_amount;
	private BigDecimal	r157_cre_20_lcbg_crm;
	private BigDecimal	r157_cre_20_rwa;
	private BigDecimal	r157_cre_20_under_ccf_amt;
	private BigDecimal	r158_cre_20_lcbg_balance;
	private BigDecimal	r158_cre_20_acceptance_amount;
	private BigDecimal	r158_cre_20_lcbg_crm;
	private BigDecimal	r158_cre_20_rwa;
	private BigDecimal	r158_cre_20_under_ccf_amt;
	private BigDecimal	r159_cre_lcbg_balance;
	private BigDecimal	r159_cre_acceptance_amount;
	private BigDecimal	r159_cre_lcbg_crm;
	private BigDecimal	r159_cre_rwa;
	private BigDecimal	r159_cre_under_ccf_amt;
	private BigDecimal	r160_cre_50_lcbg_balance;
	private BigDecimal	r160_cre_50_acceptance_amount;
	private BigDecimal	r160_cre_50_lcbg_crm;
	private BigDecimal	r160_cre_50_rwa;
	private BigDecimal	r160_cre_50_under_ccf_amt;
	private BigDecimal	r161_cre_50_lcbg_balance;
	private BigDecimal	r161_cre_50_acceptance_amount;
	private BigDecimal	r161_cre_50_lcbg_crm;
	private BigDecimal	r161_cre_50_rwa;
	private BigDecimal	r161_cre_50_under_ccf_amt;
	private BigDecimal	r162_cre_50_lcbg_balance;
	private BigDecimal	r162_cre_50_acceptance_amount;
	private BigDecimal	r162_cre_50_lcbg_crm;
	private BigDecimal	r162_cre_50_rwa;
	private BigDecimal	r162_cre_50_under_ccf_amt;
	private BigDecimal	r163_cre_lcbg_balance;
	private BigDecimal	r163_cre_acceptance_amount;
	private BigDecimal	r163_cre_lcbg_crm;
	private BigDecimal	r163_cre_rwa;
	private BigDecimal	r163_cre_under_ccf_amt;
	private BigDecimal	r164_cre_100_lcbg_balance;
	private BigDecimal	r164_cre_100_acceptance_amount;
	private BigDecimal	r164_cre_100_lcbg_crm;
	private BigDecimal	r164_cre_100_rwa;
	private BigDecimal	r164_cre_100_under_ccf_amt;
	private BigDecimal	r165_cre_100_lcbg_balance;
	private BigDecimal	r165_cre_100_acceptance_amount;
	private BigDecimal	r165_cre_100_lcbg_crm;
	private BigDecimal	r165_cre_100_rwa;
	private BigDecimal	r165_cre_100_under_ccf_amt;
	private BigDecimal	r166_cre_100_lcbg_balance;
	private BigDecimal	r166_cre_100_acceptance_amount;
	private BigDecimal	r166_cre_100_lcbg_crm;
	private BigDecimal	r166_cre_100_rwa;
	private BigDecimal	r166_cre_100_under_ccf_amt;
	private BigDecimal	r167_cre_lcbg_balance;
	private BigDecimal	r167_cre_acceptance_amount;
	private BigDecimal	r167_cre_lcbg_crm;
	private BigDecimal	r167_cre_rwa;
	private BigDecimal	r167_cre_under_ccf_amt;
	private BigDecimal	r168_cre_150_lcbg_balance;
	private BigDecimal	r168_cre_150_acceptance_amount;
	private BigDecimal	r168_cre_150_lcbg_crm;
	private BigDecimal	r168_cre_150_rwa;
	private BigDecimal	r168_cre_150_under_ccf_amt;
	private BigDecimal	r169_cre_150_lcbg_balance;
	private BigDecimal	r169_cre_150_acceptance_amount;
	private BigDecimal	r169_cre_150_lcbg_crm;
	private BigDecimal	r169_cre_150_rwa;
	private BigDecimal	r169_cre_150_under_ccf_amt;
	private BigDecimal	r170_cre_150_lcbg_balance;
	private BigDecimal	r170_cre_150_acceptance_amount;
	private BigDecimal	r170_cre_150_lcbg_crm;
	private BigDecimal	r170_cre_150_rwa;
	private BigDecimal	r170_cre_150_under_ccf_amt;
	private BigDecimal	r171_cre_lcbg_balance;
	private BigDecimal	r171_cre_acceptance_amount;
	private BigDecimal	r171_cre_lcbg_crm;
	private BigDecimal	r171_cre_rwa;
	private BigDecimal	r171_cre_under_ccf_amt;
	private BigDecimal	r172_crt_0_lcbg_balance;
	private BigDecimal	r172_crt_0_acceptance_amount;
	private BigDecimal	r172_crt_0_lcbg_crm;
	private BigDecimal	r172_crt_0_rwa;
	private BigDecimal	r172_crt_0_under_ccf_amt;
	private BigDecimal	r173_crt_0_lcbg_balance;
	private BigDecimal	r173_crt_0_acceptance_amount;
	private BigDecimal	r173_crt_0_lcbg_crm;
	private BigDecimal	r173_crt_0_rwa;
	private BigDecimal	r173_crt_0_under_ccf_amt;
	private BigDecimal	r174_crt_0_lcbg_balance;
	private BigDecimal	r174_crt_0_acceptance_amount;
	private BigDecimal	r174_crt_0_lcbg_crm;
	private BigDecimal	r174_crt_0_rwa;
	private BigDecimal	r174_crt_0_under_ccf_amt;
	private BigDecimal	r175_crt_lcbg_balance;
	private BigDecimal	r175_crt_acceptance_amount;
	private BigDecimal	r175_crt_lcbg_crm;
	private BigDecimal	r175_crt_rwa;
	private BigDecimal	r175_crt_under_ccf_amt;
	private BigDecimal	r176_crt_20_lcbg_balance;
	private BigDecimal	r176_crt_20_acceptance_amount;
	private BigDecimal	r176_crt_20_lcbg_crm;
	private BigDecimal	r176_crt_20_rwa;
	private BigDecimal	r176_crt_20_under_ccf_amt;
	private BigDecimal	r177_crt_20_lcbg_balance;
	private BigDecimal	r177_crt_20_acceptance_amount;
	private BigDecimal	r177_crt_20_lcbg_crm;
	private BigDecimal	r177_crt_20_rwa;
	private BigDecimal	r177_crt_20_under_ccf_amt;
	private BigDecimal	r178_crt_20_lcbg_balance;
	private BigDecimal	r178_crt_20_acceptance_amount;
	private BigDecimal	r178_crt_20_lcbg_crm;
	private BigDecimal	r178_crt_20_rwa;
	private BigDecimal	r178_crt_20_under_ccf_amt;
	private BigDecimal	r179_crt_lcbg_balance;
	private BigDecimal	r179_crt_acceptance_amount;
	private BigDecimal	r179_crt_lcbg_crm;
	private BigDecimal	r179_crt_rwa;
	private BigDecimal	r179_crt_under_ccf_amt;
	private BigDecimal	r180_crt_50_lcbg_balance;
	private BigDecimal	r180_crt_50_acceptance_amount;
	private BigDecimal	r180_crt_50_lcbg_crm;
	private BigDecimal	r180_crt_50_rwa;
	private BigDecimal	r180_crt_50_under_ccf_amt;
	private BigDecimal	r181_crt_50_lcbg_balance;
	private BigDecimal	r181_crt_50_acceptance_amount;
	private BigDecimal	r181_crt_50_lcbg_crm;
	private BigDecimal	r181_crt_50_rwa;
	private BigDecimal	r181_crt_50_under_ccf_amt;
	private BigDecimal	r182_crt_50_lcbg_balance;
	private BigDecimal	r182_crt_50_acceptance_amount;
	private BigDecimal	r182_crt_50_lcbg_crm;
	private BigDecimal	r182_crt_50_rwa;
	private BigDecimal	r182_crt_50_under_ccf_amt;
	private BigDecimal	r183_crt_lcbg_balance;
	private BigDecimal	r183_crt_acceptance_amount;
	private BigDecimal	r183_crt_lcbg_crm;
	private BigDecimal	r183_crt_rwa;
	private BigDecimal	r183_crt_under_ccf_amt;
	private BigDecimal	r184_crt_100_lcbg_balance;
	private BigDecimal	r184_crt_100_acceptance_amount;
	private BigDecimal	r184_crt_100_lcbg_crm;
	private BigDecimal	r184_crt_100_rwa;
	private BigDecimal	r184_crt_100_under_ccf_amt;
	private BigDecimal	r185_crt_100_lcbg_balance;
	private BigDecimal	r185_crt_100_acceptance_amount;
	private BigDecimal	r185_crt_100_lcbg_crm;
	private BigDecimal	r185_crt_100_rwa;
	private BigDecimal	r185_crt_100_under_ccf_amt;
	private BigDecimal	r186_crt_100_lcbg_balance;
	private BigDecimal	r186_crt_100_acceptance_amount;
	private BigDecimal	r186_crt_100_lcbg_crm;
	private BigDecimal	r186_crt_100_rwa;
	private BigDecimal	r186_crt_100_under_ccf_amt;
	private BigDecimal	r187_crt_lcbg_balance;
	private BigDecimal	r187_crt_acceptance_amount;
	private BigDecimal	r187_crt_lcbg_crm;
	private BigDecimal	r187_crt_rwa;
	private BigDecimal	r187_crt_under_ccf_amt;
	private BigDecimal	r188_crt_150_lcbg_balance;
	private BigDecimal	r188_crt_150_acceptance_amount;
	private BigDecimal	r188_crt_150_lcbg_crm;
	private BigDecimal	r188_crt_150_rwa;
	private BigDecimal	r188_crt_150_under_ccf_amt;
	private BigDecimal	r189_crt_150_lcbg_balance;
	private BigDecimal	r189_crt_150_acceptance_amount;
	private BigDecimal	r189_crt_150_lcbg_crm;
	private BigDecimal	r189_crt_150_rwa;
	private BigDecimal	r189_crt_150_under_ccf_amt;
	private BigDecimal	r190_crt_150_lcbg_balance;
	private BigDecimal	r190_crt_150_acceptance_amount;
	private BigDecimal	r190_crt_150_lcbg_crm;
	private BigDecimal	r190_crt_150_rwa;
	private BigDecimal	r190_crt_150_under_ccf_amt;
	private BigDecimal	r191_crt_lcbg_balance;
	private BigDecimal	r191_crt_acceptance_amount;
	private BigDecimal	r191_crt_lcbg_crm;
	private BigDecimal	r191_crt_rwa;
	private BigDecimal	r191_crt_under_ccf_amt;
	private BigDecimal	r192_hni_100_lcbg_balance;
	private BigDecimal	r192_hni_100_acceptance_amount;
	private BigDecimal	r192_hni_100_lcbg_crm;
	private BigDecimal	r192_hni_100_rwa;
	private BigDecimal	r192_hni_100_under_ccf_amt;
	private BigDecimal	r193_hni_100_lcbg_balance;
	private BigDecimal	r193_hni_100_acceptance_amount;
	private BigDecimal	r193_hni_100_lcbg_crm;
	private BigDecimal	r193_hni_100_rwa;
	private BigDecimal	r193_hni_100_under_ccf_amt;
	private BigDecimal	r194_hni_100_lcbg_balance;
	private BigDecimal	r194_hni_100_acceptance_amount;
	private BigDecimal	r194_hni_100_lcbg_crm;
	private BigDecimal	r194_hni_100_rwa;
	private BigDecimal	r194_hni_100_under_ccf_amt;
	private BigDecimal	r195_hni_lcbg_balance;
	private BigDecimal	r195_hni_acceptance_amount;
	private BigDecimal	r195_hni_lcbg_crm;
	private BigDecimal	r195_hni_rwa;
	private BigDecimal	r195_hni_under_ccf_amt;
	private BigDecimal	r196_pdl_100_lcbg_balance;
	private BigDecimal	r196_pdl_100_acceptance_amount;
	private BigDecimal	r196_pdl_100_lcbg_crm;
	private BigDecimal	r196_pdl_100_rwa;
	private BigDecimal	r196_pdl_100_under_ccf_amt;
	private BigDecimal	r197_pdl_100_lcbg_balance;
	private BigDecimal	r197_pdl_100_acceptance_amount;
	private BigDecimal	r197_pdl_100_lcbg_crm;
	private BigDecimal	r197_pdl_100_rwa;
	private BigDecimal	r197_pdl_100_under_ccf_amt;
	private BigDecimal	r198_pdl_100_lcbg_balance;
	private BigDecimal	r198_pdl_100_acceptance_amount;
	private BigDecimal	r198_pdl_100_lcbg_crm;
	private BigDecimal	r198_pdl_100_rwa;
	private BigDecimal	r198_pdl_100_under_ccf_amt;
	private BigDecimal	r199_pdl_lcbg_balance;
	private BigDecimal	r199_pdl_acceptance_amount;
	private BigDecimal	r199_pdl_lcbg_crm;
	private BigDecimal	r199_pdl_rwa;
	private BigDecimal	r199_pdl_under_ccf_amt;
	private BigDecimal	r200_pdl_150_lcbg_balance;
	private BigDecimal	r200_pdl_150_acceptance_amount;
	private BigDecimal	r200_pdl_150_lcbg_crm;
	private BigDecimal	r200_pdl_150_rwa;
	private BigDecimal	r200_pdl_150_under_ccf_amt;
	private BigDecimal	r201_pdl_150_lcbg_balance;
	private BigDecimal	r201_pdl_150_acceptance_amount;
	private BigDecimal	r201_pdl_150_lcbg_crm;
	private BigDecimal	r201_pdl_150_rwa;
	private BigDecimal	r201_pdl_150_under_ccf_amt;
	private BigDecimal	r202_pdl_150_lcbg_balance;
	private BigDecimal	r202_pdl_150_acceptance_amount;
	private BigDecimal	r202_pdl_150_lcbg_crm;
	private BigDecimal	r202_pdl_150_rwa;
	private BigDecimal	r202_pdl_150_under_ccf_amt;
	private BigDecimal	r203_pdl_lcbg_balance;
	private BigDecimal	r203_pdl_acceptance_amount;
	private BigDecimal	r203_pdl_lcbg_crm;
	private BigDecimal	r203_pdl_rwa;
	private BigDecimal	r203_pdl_under_ccf_amt;
	private BigDecimal	r204_pse_0_lcbg_balance;
	private BigDecimal	r204_pse_0_acceptance_amount;
	private BigDecimal	r204_pse_0_lcbg_crm;
	private BigDecimal	r204_pse_0_rwa;
	private BigDecimal	r204_pse_0_under_ccf_amt;
	private BigDecimal	r205_pse_0_lcbg_balance;
	private BigDecimal	r205_pse_0_acceptance_amount;
	private BigDecimal	r205_pse_0_lcbg_crm;
	private BigDecimal	r205_pse_0_rwa;
	private BigDecimal	r205_pse_0_under_ccf_amt;
	private BigDecimal	r206_pse_0_lcbg_balance;
	private BigDecimal	r206_pse_0_acceptance_amount;
	private BigDecimal	r206_pse_0_lcbg_crm;
	private BigDecimal	r206_pse_0_rwa;
	private BigDecimal	r206_pse_0_under_ccf_amt;
	private BigDecimal	r207_pse_lcbg_balance;
	private BigDecimal	r207_pse_acceptance_amount;
	private BigDecimal	r207_pse_lcbg_crm;
	private BigDecimal	r207_pse_rwa;
	private BigDecimal	r207_pse_under_ccf_amt;
	private BigDecimal	r208_pse_20_lcbg_balance;
	private BigDecimal	r208_pse_20_acceptance_amount;
	private BigDecimal	r208_pse_20_lcbg_crm;
	private BigDecimal	r208_pse_20_rwa;
	private BigDecimal	r208_pse_20_under_ccf_amt;
	private BigDecimal	r209_pse_20_lcbg_balance;
	private BigDecimal	r209_pse_20_acceptance_amount;
	private BigDecimal	r209_pse_20_lcbg_crm;
	private BigDecimal	r209_pse_20_rwa;
	private BigDecimal	r209_pse_20_under_ccf_amt;
	private BigDecimal	r210_pse_20_lcbg_balance;
	private BigDecimal	r210_pse_20_acceptance_amount;
	private BigDecimal	r210_pse_20_lcbg_crm;
	private BigDecimal	r210_pse_20_rwa;
	private BigDecimal	r210_pse_20_under_ccf_amt;
	private BigDecimal	r211_pse_lcbg_balance;
	private BigDecimal	r211_pse_acceptance_amount;
	private BigDecimal	r211_pse_lcbg_crm;
	private BigDecimal	r211_pse_rwa;
	private BigDecimal	r211_pse_under_ccf_amt;
	private BigDecimal	r212_pse_50_lcbg_balance;
	private BigDecimal	r212_pse_50_acceptance_amount;
	private BigDecimal	r212_pse_50_lcbg_crm;
	private BigDecimal	r212_pse_50_rwa;
	private BigDecimal	r212_pse_50_under_ccf_amt;
	private BigDecimal	r213_pse_50_lcbg_balance;
	private BigDecimal	r213_pse_50_acceptance_amount;
	private BigDecimal	r213_pse_50_lcbg_crm;
	private BigDecimal	r213_pse_50_rwa;
	private BigDecimal	r213_pse_50_under_ccf_amt;
	private BigDecimal	r214_pse_50_lcbg_balance;
	private BigDecimal	r214_pse_50_acceptance_amount;
	private BigDecimal	r214_pse_50_lcbg_crm;
	private BigDecimal	r214_pse_50_rwa;
	private BigDecimal	r214_pse_50_under_ccf_amt;
	private BigDecimal	r215_pse_lcbg_balance;
	private BigDecimal	r215_pse_acceptance_amount;
	private BigDecimal	r215_pse_lcbg_crm;
	private BigDecimal	r215_pse_rwa;
	private BigDecimal	r215_pse_under_ccf_amt;
	private BigDecimal	r216_pse_100_lcbg_balance;
	private BigDecimal	r216_pse_100_acceptance_amount;
	private BigDecimal	r216_pse_100_lcbg_crm;
	private BigDecimal	r216_pse_100_rwa;
	private BigDecimal	r216_pse_100_under_ccf_amt;
	private BigDecimal	r217_pse_100_lcbg_balance;
	private BigDecimal	r217_pse_100_acceptance_amount;
	private BigDecimal	r217_pse_100_lcbg_crm;
	private BigDecimal	r217_pse_100_rwa;
	private BigDecimal	r217_pse_100_under_ccf_amt;
	private BigDecimal	r218_pse_100_lcbg_balance;
	private BigDecimal	r218_pse_100_acceptance_amount;
	private BigDecimal	r218_pse_100_lcbg_crm;
	private BigDecimal	r218_pse_100_rwa;
	private BigDecimal	r218_pse_100_under_ccf_amt;
	private BigDecimal	r219_pse_lcbg_balance;
	private BigDecimal	r219_pse_acceptance_amount;
	private BigDecimal	r219_pse_lcbg_crm;
	private BigDecimal	r219_pse_rwa;
	private BigDecimal	r219_pse_under_ccf_amt;
	private BigDecimal	r220_pse_150_lcbg_balance;
	private BigDecimal	r220_pse_150_acceptance_amount;
	private BigDecimal	r220_pse_150_lcbg_crm;
	private BigDecimal	r220_pse_150_rwa;
	private BigDecimal	r220_pse_150_under_ccf_amt;
	private BigDecimal	r221_pse_150_lcbg_balance;
	private BigDecimal	r221_pse_150_acceptance_amount;
	private BigDecimal	r221_pse_150_lcbg_crm;
	private BigDecimal	r221_pse_150_rwa;
	private BigDecimal	r221_pse_150_under_ccf_amt;
	private BigDecimal	r222_pse_150_lcbg_balance;
	private BigDecimal	r222_pse_150_acceptance_amount;
	private BigDecimal	r222_pse_150_lcbg_crm;
	private BigDecimal	r222_pse_150_rwa;
	private BigDecimal	r222_pse_150_under_ccf_amt;
	private BigDecimal	r223_pse_lcbg_balance;
	private BigDecimal	r223_pse_acceptance_amount;
	private BigDecimal	r223_pse_lcbg_crm;
	private BigDecimal	r223_pse_rwa;
	private BigDecimal	r223_pse_under_ccf_amt;
	private BigDecimal	r224_res_35_lcbg_balance;
	private BigDecimal	r224_res_35_acceptance_amount;
	private BigDecimal	r224_res_35_lcbg_crm;
	private BigDecimal	r224_res_35_rwa;
	private BigDecimal	r224_res_35_under_ccf_amt;
	private BigDecimal	r225_res_35_lcbg_balance;
	private BigDecimal	r225_res_35_acceptance_amount;
	private BigDecimal	r225_res_35_lcbg_crm;
	private BigDecimal	r225_res_35_rwa;
	private BigDecimal	r225_res_35_under_ccf_amt;
	private BigDecimal	r226_res_35_lcbg_balance;
	private BigDecimal	r226_res_35_acceptance_amount;
	private BigDecimal	r226_res_35_lcbg_crm;
	private BigDecimal	r226_res_35_rwa;
	private BigDecimal	r226_res_35_under_ccf_amt;
	private BigDecimal	r227_res_lcbg_balance;
	private BigDecimal	r227_res_acceptance_amount;
	private BigDecimal	r227_res_lcbg_crm;
	private BigDecimal	r227_res_rwa;
	private BigDecimal	r227_res_under_ccf_amt;
	private BigDecimal	r228_res_100_lcbg_balance;
	private BigDecimal	r228_res_100_acceptance_amount;
	private BigDecimal	r228_res_100_lcbg_crm;
	private BigDecimal	r228_res_100_rwa;
	private BigDecimal	r228_res_100_under_ccf_amt;
	private BigDecimal	r229_res_100_lcbg_balance;
	private BigDecimal	r229_res_100_acceptance_amount;
	private BigDecimal	r229_res_100_lcbg_crm;
	private BigDecimal	r229_res_100_rwa;
	private BigDecimal	r229_res_100_under_ccf_amt;
	private BigDecimal	r230_res_100_lcbg_balance;
	private BigDecimal	r230_res_100_acceptance_amount;
	private BigDecimal	r230_res_100_lcbg_crm;
	private BigDecimal	r230_res_100_rwa;
	private BigDecimal	r230_res_100_under_ccf_amt;
	private BigDecimal	r231_res_lcbg_balance;
	private BigDecimal	r231_res_acceptance_amount;
	private BigDecimal	r231_res_lcbg_crm;
	private BigDecimal	r231_res_rwa;
	private BigDecimal	r231_res_under_ccf_amt;
	private BigDecimal	r232_rrp_75_lcbg_balance;
	private BigDecimal	r232_rrp_75_acceptance_amount;
	private BigDecimal	r232_rrp_75_lcbg_crm;
	private BigDecimal	r232_rrp_75_rwa;
	private BigDecimal	r232_rrp_75_under_ccf_amt;
	private BigDecimal	r233_rrp_75_lcbg_balance;
	private BigDecimal	r233_rrp_75_acceptance_amount;
	private BigDecimal	r233_rrp_75_lcbg_crm;
	private BigDecimal	r233_rrp_75_rwa;
	private BigDecimal	r233_rrp_75_under_ccf_amt;
	private BigDecimal	r234_rrp_75_lcbg_balance;
	private BigDecimal	r234_rrp_75_acceptance_amount;
	private BigDecimal	r234_rrp_75_lcbg_crm;
	private BigDecimal	r234_rrp_75_rwa;
	private BigDecimal	r234_rrp_75_under_ccf_amt;
	private BigDecimal	r235_rrp_lcbg_balance;
	private BigDecimal	r235_rrp_acceptance_amount;
	private BigDecimal	r235_rrp_lcbg_crm;
	private BigDecimal	r235_rrp_rwa;
	private BigDecimal	r235_rrp_under_ccf_amt;
	private BigDecimal	r236_rrp_100_lcbg_balance;
	private BigDecimal	r236_rrp_100_acceptance_amount;
	private BigDecimal	r236_rrp_100_lcbg_crm;
	private BigDecimal	r236_rrp_100_rwa;
	private BigDecimal	r236_rrp_100_under_ccf_amt;
	private BigDecimal	r237_rrp_100_lcbg_balance;
	private BigDecimal	r237_rrp_100_acceptance_amount;
	private BigDecimal	r237_rrp_100_lcbg_crm;
	private BigDecimal	r237_rrp_100_rwa;
	private BigDecimal	r237_rrp_100_under_ccf_amt;
	private BigDecimal	r238_rrp_100_lcbg_balance;
	private BigDecimal	r238_rrp_100_acceptance_amount;
	private BigDecimal	r238_rrp_100_lcbg_crm;
	private BigDecimal	r238_rrp_100_rwa;
	private BigDecimal	r238_rrp_100_under_ccf_amt;
	private BigDecimal	r239_rrp_lcbg_balance;
	private BigDecimal	r239_rrp_acceptance_amount;
	private BigDecimal	r239_rrp_lcbg_crm;
	private BigDecimal	r239_rrp_rwa;
	private BigDecimal	r239_rrp_under_ccf_amt;
	private BigDecimal	r240_rrp_75_lcbg_balance;
	private BigDecimal	r240_rrp_75_acceptance_amount;
	private BigDecimal	r240_rrp_75_lcbg_crm;
	private BigDecimal	r240_rrp_75_rwa;
	private BigDecimal	r240_rrp_75_under_ccf_amt;
	private BigDecimal	r241_rrp_75_lcbg_balance;
	private BigDecimal	r241_rrp_75_acceptance_amount;
	private BigDecimal	r241_rrp_75_lcbg_crm;
	private BigDecimal	r241_rrp_75_rwa;
	private BigDecimal	r241_rrp_75_under_ccf_amt;
	private BigDecimal	r242_rrp_75_lcbg_balance;
	private BigDecimal	r242_rrp_75_acceptance_amount;
	private BigDecimal	r242_rrp_75_lcbg_crm;
	private BigDecimal	r242_rrp_75_rwa;
	private BigDecimal	r242_rrp_75_under_ccf_amt;
	private BigDecimal	r243_rrp_lcbg_balance;
	private BigDecimal	r243_rrp_acceptance_amount;
	private BigDecimal	r243_rrp_lcbg_crm;
	private BigDecimal	r243_rrp_rwa;
	private BigDecimal	r243_rrp_under_ccf_amt;
	private BigDecimal	r244_rrp_85_lcbg_balance;
	private BigDecimal	r244_rrp_85_acceptance_amount;
	private BigDecimal	r244_rrp_85_lcbg_crm;
	private BigDecimal	r244_rrp_85_rwa;
	private BigDecimal	r244_rrp_85_under_ccf_amt;
	private BigDecimal	r245_rrp_85_lcbg_balance;
	private BigDecimal	r245_rrp_85_acceptance_amount;
	private BigDecimal	r245_rrp_85_lcbg_crm;
	private BigDecimal	r245_rrp_85_rwa;
	private BigDecimal	r245_rrp_85_under_ccf_amt;
	private BigDecimal	r246_rrp_85_lcbg_balance;
	private BigDecimal	r246_rrp_85_acceptance_amount;
	private BigDecimal	r246_rrp_85_lcbg_crm;
	private BigDecimal	r246_rrp_85_rwa;
	private BigDecimal	r246_rrp_85_under_ccf_amt;
	private BigDecimal	r247_rrp_lcbg_balance;
	private BigDecimal	r247_rrp_acceptance_amount;
	private BigDecimal	r247_rrp_lcbg_crm;
	private BigDecimal	r247_rrp_rwa;
	private BigDecimal	r247_rrp_under_ccf_amt;
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
	public BigDecimal getR100_bnk_0_lcbg_balance() {
		return r100_bnk_0_lcbg_balance;
	}
	public void setR100_bnk_0_lcbg_balance(BigDecimal r100_bnk_0_lcbg_balance) {
		this.r100_bnk_0_lcbg_balance = r100_bnk_0_lcbg_balance;
	}
	public BigDecimal getR100_bnk_0_acceptance_amount() {
		return r100_bnk_0_acceptance_amount;
	}
	public void setR100_bnk_0_acceptance_amount(BigDecimal r100_bnk_0_acceptance_amount) {
		this.r100_bnk_0_acceptance_amount = r100_bnk_0_acceptance_amount;
	}
	public BigDecimal getR100_bnk_0_lcbg_crm() {
		return r100_bnk_0_lcbg_crm;
	}
	public void setR100_bnk_0_lcbg_crm(BigDecimal r100_bnk_0_lcbg_crm) {
		this.r100_bnk_0_lcbg_crm = r100_bnk_0_lcbg_crm;
	}
	public BigDecimal getR100_bnk_0_rwa() {
		return r100_bnk_0_rwa;
	}
	public void setR100_bnk_0_rwa(BigDecimal r100_bnk_0_rwa) {
		this.r100_bnk_0_rwa = r100_bnk_0_rwa;
	}
	public BigDecimal getR100_bnk_0_under_ccf_amt() {
		return r100_bnk_0_under_ccf_amt;
	}
	public void setR100_bnk_0_under_ccf_amt(BigDecimal r100_bnk_0_under_ccf_amt) {
		this.r100_bnk_0_under_ccf_amt = r100_bnk_0_under_ccf_amt;
	}
	public BigDecimal getR101_bnk_0_lcbg_balance() {
		return r101_bnk_0_lcbg_balance;
	}
	public void setR101_bnk_0_lcbg_balance(BigDecimal r101_bnk_0_lcbg_balance) {
		this.r101_bnk_0_lcbg_balance = r101_bnk_0_lcbg_balance;
	}
	public BigDecimal getR101_bnk_0_acceptance_amount() {
		return r101_bnk_0_acceptance_amount;
	}
	public void setR101_bnk_0_acceptance_amount(BigDecimal r101_bnk_0_acceptance_amount) {
		this.r101_bnk_0_acceptance_amount = r101_bnk_0_acceptance_amount;
	}
	public BigDecimal getR101_bnk_0_lcbg_crm() {
		return r101_bnk_0_lcbg_crm;
	}
	public void setR101_bnk_0_lcbg_crm(BigDecimal r101_bnk_0_lcbg_crm) {
		this.r101_bnk_0_lcbg_crm = r101_bnk_0_lcbg_crm;
	}
	public BigDecimal getR101_bnk_0_rwa() {
		return r101_bnk_0_rwa;
	}
	public void setR101_bnk_0_rwa(BigDecimal r101_bnk_0_rwa) {
		this.r101_bnk_0_rwa = r101_bnk_0_rwa;
	}
	public BigDecimal getR101_bnk_0_under_ccf_amt() {
		return r101_bnk_0_under_ccf_amt;
	}
	public void setR101_bnk_0_under_ccf_amt(BigDecimal r101_bnk_0_under_ccf_amt) {
		this.r101_bnk_0_under_ccf_amt = r101_bnk_0_under_ccf_amt;
	}
	public BigDecimal getR102_bnk_0_lcbg_balance() {
		return r102_bnk_0_lcbg_balance;
	}
	public void setR102_bnk_0_lcbg_balance(BigDecimal r102_bnk_0_lcbg_balance) {
		this.r102_bnk_0_lcbg_balance = r102_bnk_0_lcbg_balance;
	}
	public BigDecimal getR102_bnk_0_acceptance_amount() {
		return r102_bnk_0_acceptance_amount;
	}
	public void setR102_bnk_0_acceptance_amount(BigDecimal r102_bnk_0_acceptance_amount) {
		this.r102_bnk_0_acceptance_amount = r102_bnk_0_acceptance_amount;
	}
	public BigDecimal getR102_bnk_0_lcbg_crm() {
		return r102_bnk_0_lcbg_crm;
	}
	public void setR102_bnk_0_lcbg_crm(BigDecimal r102_bnk_0_lcbg_crm) {
		this.r102_bnk_0_lcbg_crm = r102_bnk_0_lcbg_crm;
	}
	public BigDecimal getR102_bnk_0_rwa() {
		return r102_bnk_0_rwa;
	}
	public void setR102_bnk_0_rwa(BigDecimal r102_bnk_0_rwa) {
		this.r102_bnk_0_rwa = r102_bnk_0_rwa;
	}
	public BigDecimal getR102_bnk_0_under_ccf_amt() {
		return r102_bnk_0_under_ccf_amt;
	}
	public void setR102_bnk_0_under_ccf_amt(BigDecimal r102_bnk_0_under_ccf_amt) {
		this.r102_bnk_0_under_ccf_amt = r102_bnk_0_under_ccf_amt;
	}
	public BigDecimal getR103_bnk_lcbg_balance() {
		return r103_bnk_lcbg_balance;
	}
	public void setR103_bnk_lcbg_balance(BigDecimal r103_bnk_lcbg_balance) {
		this.r103_bnk_lcbg_balance = r103_bnk_lcbg_balance;
	}
	public BigDecimal getR103_bnk_acceptance_amount() {
		return r103_bnk_acceptance_amount;
	}
	public void setR103_bnk_acceptance_amount(BigDecimal r103_bnk_acceptance_amount) {
		this.r103_bnk_acceptance_amount = r103_bnk_acceptance_amount;
	}
	public BigDecimal getR103_bnk_lcbg_crm() {
		return r103_bnk_lcbg_crm;
	}
	public void setR103_bnk_lcbg_crm(BigDecimal r103_bnk_lcbg_crm) {
		this.r103_bnk_lcbg_crm = r103_bnk_lcbg_crm;
	}
	public BigDecimal getR103_bnk_rwa() {
		return r103_bnk_rwa;
	}
	public void setR103_bnk_rwa(BigDecimal r103_bnk_rwa) {
		this.r103_bnk_rwa = r103_bnk_rwa;
	}
	public BigDecimal getR103_bnk_under_ccf_amt() {
		return r103_bnk_under_ccf_amt;
	}
	public void setR103_bnk_under_ccf_amt(BigDecimal r103_bnk_under_ccf_amt) {
		this.r103_bnk_under_ccf_amt = r103_bnk_under_ccf_amt;
	}
	public BigDecimal getR104_bnk_20_lcbg_balance() {
		return r104_bnk_20_lcbg_balance;
	}
	public void setR104_bnk_20_lcbg_balance(BigDecimal r104_bnk_20_lcbg_balance) {
		this.r104_bnk_20_lcbg_balance = r104_bnk_20_lcbg_balance;
	}
	public BigDecimal getR104_bnk_20_acceptance_amount() {
		return r104_bnk_20_acceptance_amount;
	}
	public void setR104_bnk_20_acceptance_amount(BigDecimal r104_bnk_20_acceptance_amount) {
		this.r104_bnk_20_acceptance_amount = r104_bnk_20_acceptance_amount;
	}
	public BigDecimal getR104_bnk_20_lcbg_crm() {
		return r104_bnk_20_lcbg_crm;
	}
	public void setR104_bnk_20_lcbg_crm(BigDecimal r104_bnk_20_lcbg_crm) {
		this.r104_bnk_20_lcbg_crm = r104_bnk_20_lcbg_crm;
	}
	public BigDecimal getR104_bnk_20_rwa() {
		return r104_bnk_20_rwa;
	}
	public void setR104_bnk_20_rwa(BigDecimal r104_bnk_20_rwa) {
		this.r104_bnk_20_rwa = r104_bnk_20_rwa;
	}
	public BigDecimal getR104_bnk_20_under_ccf_amt() {
		return r104_bnk_20_under_ccf_amt;
	}
	public void setR104_bnk_20_under_ccf_amt(BigDecimal r104_bnk_20_under_ccf_amt) {
		this.r104_bnk_20_under_ccf_amt = r104_bnk_20_under_ccf_amt;
	}
	public BigDecimal getR105_bnk_20_lcbg_balance() {
		return r105_bnk_20_lcbg_balance;
	}
	public void setR105_bnk_20_lcbg_balance(BigDecimal r105_bnk_20_lcbg_balance) {
		this.r105_bnk_20_lcbg_balance = r105_bnk_20_lcbg_balance;
	}
	public BigDecimal getR105_bnk_20_acceptance_amount() {
		return r105_bnk_20_acceptance_amount;
	}
	public void setR105_bnk_20_acceptance_amount(BigDecimal r105_bnk_20_acceptance_amount) {
		this.r105_bnk_20_acceptance_amount = r105_bnk_20_acceptance_amount;
	}
	public BigDecimal getR105_bnk_20_lcbg_crm() {
		return r105_bnk_20_lcbg_crm;
	}
	public void setR105_bnk_20_lcbg_crm(BigDecimal r105_bnk_20_lcbg_crm) {
		this.r105_bnk_20_lcbg_crm = r105_bnk_20_lcbg_crm;
	}
	public BigDecimal getR105_bnk_20_rwa() {
		return r105_bnk_20_rwa;
	}
	public void setR105_bnk_20_rwa(BigDecimal r105_bnk_20_rwa) {
		this.r105_bnk_20_rwa = r105_bnk_20_rwa;
	}
	public BigDecimal getR105_bnk_20_under_ccf_amt() {
		return r105_bnk_20_under_ccf_amt;
	}
	public void setR105_bnk_20_under_ccf_amt(BigDecimal r105_bnk_20_under_ccf_amt) {
		this.r105_bnk_20_under_ccf_amt = r105_bnk_20_under_ccf_amt;
	}
	public BigDecimal getR106_bnk_20_lcbg_balance() {
		return r106_bnk_20_lcbg_balance;
	}
	public void setR106_bnk_20_lcbg_balance(BigDecimal r106_bnk_20_lcbg_balance) {
		this.r106_bnk_20_lcbg_balance = r106_bnk_20_lcbg_balance;
	}
	public BigDecimal getR106_bnk_20_acceptance_amount() {
		return r106_bnk_20_acceptance_amount;
	}
	public void setR106_bnk_20_acceptance_amount(BigDecimal r106_bnk_20_acceptance_amount) {
		this.r106_bnk_20_acceptance_amount = r106_bnk_20_acceptance_amount;
	}
	public BigDecimal getR106_bnk_20_lcbg_crm() {
		return r106_bnk_20_lcbg_crm;
	}
	public void setR106_bnk_20_lcbg_crm(BigDecimal r106_bnk_20_lcbg_crm) {
		this.r106_bnk_20_lcbg_crm = r106_bnk_20_lcbg_crm;
	}
	public BigDecimal getR106_bnk_20_rwa() {
		return r106_bnk_20_rwa;
	}
	public void setR106_bnk_20_rwa(BigDecimal r106_bnk_20_rwa) {
		this.r106_bnk_20_rwa = r106_bnk_20_rwa;
	}
	public BigDecimal getR106_bnk_20_under_ccf_amt() {
		return r106_bnk_20_under_ccf_amt;
	}
	public void setR106_bnk_20_under_ccf_amt(BigDecimal r106_bnk_20_under_ccf_amt) {
		this.r106_bnk_20_under_ccf_amt = r106_bnk_20_under_ccf_amt;
	}
	public BigDecimal getR107_bnk_lcbg_balance() {
		return r107_bnk_lcbg_balance;
	}
	public void setR107_bnk_lcbg_balance(BigDecimal r107_bnk_lcbg_balance) {
		this.r107_bnk_lcbg_balance = r107_bnk_lcbg_balance;
	}
	public BigDecimal getR107_bnk_acceptance_amount() {
		return r107_bnk_acceptance_amount;
	}
	public void setR107_bnk_acceptance_amount(BigDecimal r107_bnk_acceptance_amount) {
		this.r107_bnk_acceptance_amount = r107_bnk_acceptance_amount;
	}
	public BigDecimal getR107_bnk_lcbg_crm() {
		return r107_bnk_lcbg_crm;
	}
	public void setR107_bnk_lcbg_crm(BigDecimal r107_bnk_lcbg_crm) {
		this.r107_bnk_lcbg_crm = r107_bnk_lcbg_crm;
	}
	public BigDecimal getR107_bnk_rwa() {
		return r107_bnk_rwa;
	}
	public void setR107_bnk_rwa(BigDecimal r107_bnk_rwa) {
		this.r107_bnk_rwa = r107_bnk_rwa;
	}
	public BigDecimal getR107_bnk_under_ccf_amt() {
		return r107_bnk_under_ccf_amt;
	}
	public void setR107_bnk_under_ccf_amt(BigDecimal r107_bnk_under_ccf_amt) {
		this.r107_bnk_under_ccf_amt = r107_bnk_under_ccf_amt;
	}
	public BigDecimal getR108_bnk_50_lcbg_balance() {
		return r108_bnk_50_lcbg_balance;
	}
	public void setR108_bnk_50_lcbg_balance(BigDecimal r108_bnk_50_lcbg_balance) {
		this.r108_bnk_50_lcbg_balance = r108_bnk_50_lcbg_balance;
	}
	public BigDecimal getR108_bnk_50_acceptance_amount() {
		return r108_bnk_50_acceptance_amount;
	}
	public void setR108_bnk_50_acceptance_amount(BigDecimal r108_bnk_50_acceptance_amount) {
		this.r108_bnk_50_acceptance_amount = r108_bnk_50_acceptance_amount;
	}
	public BigDecimal getR108_bnk_50_lcbg_crm() {
		return r108_bnk_50_lcbg_crm;
	}
	public void setR108_bnk_50_lcbg_crm(BigDecimal r108_bnk_50_lcbg_crm) {
		this.r108_bnk_50_lcbg_crm = r108_bnk_50_lcbg_crm;
	}
	public BigDecimal getR108_bnk_50_rwa() {
		return r108_bnk_50_rwa;
	}
	public void setR108_bnk_50_rwa(BigDecimal r108_bnk_50_rwa) {
		this.r108_bnk_50_rwa = r108_bnk_50_rwa;
	}
	public BigDecimal getR108_bnk_50_under_ccf_amt() {
		return r108_bnk_50_under_ccf_amt;
	}
	public void setR108_bnk_50_under_ccf_amt(BigDecimal r108_bnk_50_under_ccf_amt) {
		this.r108_bnk_50_under_ccf_amt = r108_bnk_50_under_ccf_amt;
	}
	public BigDecimal getR109_bnk_50_lcbg_balance() {
		return r109_bnk_50_lcbg_balance;
	}
	public void setR109_bnk_50_lcbg_balance(BigDecimal r109_bnk_50_lcbg_balance) {
		this.r109_bnk_50_lcbg_balance = r109_bnk_50_lcbg_balance;
	}
	public BigDecimal getR109_bnk_50_acceptance_amount() {
		return r109_bnk_50_acceptance_amount;
	}
	public void setR109_bnk_50_acceptance_amount(BigDecimal r109_bnk_50_acceptance_amount) {
		this.r109_bnk_50_acceptance_amount = r109_bnk_50_acceptance_amount;
	}
	public BigDecimal getR109_bnk_50_lcbg_crm() {
		return r109_bnk_50_lcbg_crm;
	}
	public void setR109_bnk_50_lcbg_crm(BigDecimal r109_bnk_50_lcbg_crm) {
		this.r109_bnk_50_lcbg_crm = r109_bnk_50_lcbg_crm;
	}
	public BigDecimal getR109_bnk_50_rwa() {
		return r109_bnk_50_rwa;
	}
	public void setR109_bnk_50_rwa(BigDecimal r109_bnk_50_rwa) {
		this.r109_bnk_50_rwa = r109_bnk_50_rwa;
	}
	public BigDecimal getR109_bnk_50_under_ccf_amt() {
		return r109_bnk_50_under_ccf_amt;
	}
	public void setR109_bnk_50_under_ccf_amt(BigDecimal r109_bnk_50_under_ccf_amt) {
		this.r109_bnk_50_under_ccf_amt = r109_bnk_50_under_ccf_amt;
	}
	public BigDecimal getR110_bnk_50_lcbg_balance() {
		return r110_bnk_50_lcbg_balance;
	}
	public void setR110_bnk_50_lcbg_balance(BigDecimal r110_bnk_50_lcbg_balance) {
		this.r110_bnk_50_lcbg_balance = r110_bnk_50_lcbg_balance;
	}
	public BigDecimal getR110_bnk_50_acceptance_amount() {
		return r110_bnk_50_acceptance_amount;
	}
	public void setR110_bnk_50_acceptance_amount(BigDecimal r110_bnk_50_acceptance_amount) {
		this.r110_bnk_50_acceptance_amount = r110_bnk_50_acceptance_amount;
	}
	public BigDecimal getR110_bnk_50_lcbg_crm() {
		return r110_bnk_50_lcbg_crm;
	}
	public void setR110_bnk_50_lcbg_crm(BigDecimal r110_bnk_50_lcbg_crm) {
		this.r110_bnk_50_lcbg_crm = r110_bnk_50_lcbg_crm;
	}
	public BigDecimal getR110_bnk_50_rwa() {
		return r110_bnk_50_rwa;
	}
	public void setR110_bnk_50_rwa(BigDecimal r110_bnk_50_rwa) {
		this.r110_bnk_50_rwa = r110_bnk_50_rwa;
	}
	public BigDecimal getR110_bnk_50_under_ccf_amt() {
		return r110_bnk_50_under_ccf_amt;
	}
	public void setR110_bnk_50_under_ccf_amt(BigDecimal r110_bnk_50_under_ccf_amt) {
		this.r110_bnk_50_under_ccf_amt = r110_bnk_50_under_ccf_amt;
	}
	public BigDecimal getR111_bnk_lcbg_balance() {
		return r111_bnk_lcbg_balance;
	}
	public void setR111_bnk_lcbg_balance(BigDecimal r111_bnk_lcbg_balance) {
		this.r111_bnk_lcbg_balance = r111_bnk_lcbg_balance;
	}
	public BigDecimal getR111_bnk_acceptance_amount() {
		return r111_bnk_acceptance_amount;
	}
	public void setR111_bnk_acceptance_amount(BigDecimal r111_bnk_acceptance_amount) {
		this.r111_bnk_acceptance_amount = r111_bnk_acceptance_amount;
	}
	public BigDecimal getR111_bnk_lcbg_crm() {
		return r111_bnk_lcbg_crm;
	}
	public void setR111_bnk_lcbg_crm(BigDecimal r111_bnk_lcbg_crm) {
		this.r111_bnk_lcbg_crm = r111_bnk_lcbg_crm;
	}
	public BigDecimal getR111_bnk_rwa() {
		return r111_bnk_rwa;
	}
	public void setR111_bnk_rwa(BigDecimal r111_bnk_rwa) {
		this.r111_bnk_rwa = r111_bnk_rwa;
	}
	public BigDecimal getR111_bnk_under_ccf_amt() {
		return r111_bnk_under_ccf_amt;
	}
	public void setR111_bnk_under_ccf_amt(BigDecimal r111_bnk_under_ccf_amt) {
		this.r111_bnk_under_ccf_amt = r111_bnk_under_ccf_amt;
	}
	public BigDecimal getR112_bnk_100_lcbg_balance() {
		return r112_bnk_100_lcbg_balance;
	}
	public void setR112_bnk_100_lcbg_balance(BigDecimal r112_bnk_100_lcbg_balance) {
		this.r112_bnk_100_lcbg_balance = r112_bnk_100_lcbg_balance;
	}
	public BigDecimal getR112_bnk_100_acceptance_amount() {
		return r112_bnk_100_acceptance_amount;
	}
	public void setR112_bnk_100_acceptance_amount(BigDecimal r112_bnk_100_acceptance_amount) {
		this.r112_bnk_100_acceptance_amount = r112_bnk_100_acceptance_amount;
	}
	public BigDecimal getR112_bnk_100_lcbg_crm() {
		return r112_bnk_100_lcbg_crm;
	}
	public void setR112_bnk_100_lcbg_crm(BigDecimal r112_bnk_100_lcbg_crm) {
		this.r112_bnk_100_lcbg_crm = r112_bnk_100_lcbg_crm;
	}
	public BigDecimal getR112_bnk_100_rwa() {
		return r112_bnk_100_rwa;
	}
	public void setR112_bnk_100_rwa(BigDecimal r112_bnk_100_rwa) {
		this.r112_bnk_100_rwa = r112_bnk_100_rwa;
	}
	public BigDecimal getR112_bnk_100_under_ccf_amt() {
		return r112_bnk_100_under_ccf_amt;
	}
	public void setR112_bnk_100_under_ccf_amt(BigDecimal r112_bnk_100_under_ccf_amt) {
		this.r112_bnk_100_under_ccf_amt = r112_bnk_100_under_ccf_amt;
	}
	public BigDecimal getR113_bnk_100_lcbg_balance() {
		return r113_bnk_100_lcbg_balance;
	}
	public void setR113_bnk_100_lcbg_balance(BigDecimal r113_bnk_100_lcbg_balance) {
		this.r113_bnk_100_lcbg_balance = r113_bnk_100_lcbg_balance;
	}
	public BigDecimal getR113_bnk_100_acceptance_amount() {
		return r113_bnk_100_acceptance_amount;
	}
	public void setR113_bnk_100_acceptance_amount(BigDecimal r113_bnk_100_acceptance_amount) {
		this.r113_bnk_100_acceptance_amount = r113_bnk_100_acceptance_amount;
	}
	public BigDecimal getR113_bnk_100_lcbg_crm() {
		return r113_bnk_100_lcbg_crm;
	}
	public void setR113_bnk_100_lcbg_crm(BigDecimal r113_bnk_100_lcbg_crm) {
		this.r113_bnk_100_lcbg_crm = r113_bnk_100_lcbg_crm;
	}
	public BigDecimal getR113_bnk_100_rwa() {
		return r113_bnk_100_rwa;
	}
	public void setR113_bnk_100_rwa(BigDecimal r113_bnk_100_rwa) {
		this.r113_bnk_100_rwa = r113_bnk_100_rwa;
	}
	public BigDecimal getR113_bnk_100_under_ccf_amt() {
		return r113_bnk_100_under_ccf_amt;
	}
	public void setR113_bnk_100_under_ccf_amt(BigDecimal r113_bnk_100_under_ccf_amt) {
		this.r113_bnk_100_under_ccf_amt = r113_bnk_100_under_ccf_amt;
	}
	public BigDecimal getR114_bnk_100_lcbg_balance() {
		return r114_bnk_100_lcbg_balance;
	}
	public void setR114_bnk_100_lcbg_balance(BigDecimal r114_bnk_100_lcbg_balance) {
		this.r114_bnk_100_lcbg_balance = r114_bnk_100_lcbg_balance;
	}
	public BigDecimal getR114_bnk_100_acceptance_amount() {
		return r114_bnk_100_acceptance_amount;
	}
	public void setR114_bnk_100_acceptance_amount(BigDecimal r114_bnk_100_acceptance_amount) {
		this.r114_bnk_100_acceptance_amount = r114_bnk_100_acceptance_amount;
	}
	public BigDecimal getR114_bnk_100_lcbg_crm() {
		return r114_bnk_100_lcbg_crm;
	}
	public void setR114_bnk_100_lcbg_crm(BigDecimal r114_bnk_100_lcbg_crm) {
		this.r114_bnk_100_lcbg_crm = r114_bnk_100_lcbg_crm;
	}
	public BigDecimal getR114_bnk_100_rwa() {
		return r114_bnk_100_rwa;
	}
	public void setR114_bnk_100_rwa(BigDecimal r114_bnk_100_rwa) {
		this.r114_bnk_100_rwa = r114_bnk_100_rwa;
	}
	public BigDecimal getR114_bnk_100_under_ccf_amt() {
		return r114_bnk_100_under_ccf_amt;
	}
	public void setR114_bnk_100_under_ccf_amt(BigDecimal r114_bnk_100_under_ccf_amt) {
		this.r114_bnk_100_under_ccf_amt = r114_bnk_100_under_ccf_amt;
	}
	public BigDecimal getR115_bnk_lcbg_balance() {
		return r115_bnk_lcbg_balance;
	}
	public void setR115_bnk_lcbg_balance(BigDecimal r115_bnk_lcbg_balance) {
		this.r115_bnk_lcbg_balance = r115_bnk_lcbg_balance;
	}
	public BigDecimal getR115_bnk_acceptance_amount() {
		return r115_bnk_acceptance_amount;
	}
	public void setR115_bnk_acceptance_amount(BigDecimal r115_bnk_acceptance_amount) {
		this.r115_bnk_acceptance_amount = r115_bnk_acceptance_amount;
	}
	public BigDecimal getR115_bnk_lcbg_crm() {
		return r115_bnk_lcbg_crm;
	}
	public void setR115_bnk_lcbg_crm(BigDecimal r115_bnk_lcbg_crm) {
		this.r115_bnk_lcbg_crm = r115_bnk_lcbg_crm;
	}
	public BigDecimal getR115_bnk_rwa() {
		return r115_bnk_rwa;
	}
	public void setR115_bnk_rwa(BigDecimal r115_bnk_rwa) {
		this.r115_bnk_rwa = r115_bnk_rwa;
	}
	public BigDecimal getR115_bnk_under_ccf_amt() {
		return r115_bnk_under_ccf_amt;
	}
	public void setR115_bnk_under_ccf_amt(BigDecimal r115_bnk_under_ccf_amt) {
		this.r115_bnk_under_ccf_amt = r115_bnk_under_ccf_amt;
	}
	public BigDecimal getR116_bnk_150_lcbg_balance() {
		return r116_bnk_150_lcbg_balance;
	}
	public void setR116_bnk_150_lcbg_balance(BigDecimal r116_bnk_150_lcbg_balance) {
		this.r116_bnk_150_lcbg_balance = r116_bnk_150_lcbg_balance;
	}
	public BigDecimal getR116_bnk_150_acceptance_amount() {
		return r116_bnk_150_acceptance_amount;
	}
	public void setR116_bnk_150_acceptance_amount(BigDecimal r116_bnk_150_acceptance_amount) {
		this.r116_bnk_150_acceptance_amount = r116_bnk_150_acceptance_amount;
	}
	public BigDecimal getR116_bnk_150_lcbg_crm() {
		return r116_bnk_150_lcbg_crm;
	}
	public void setR116_bnk_150_lcbg_crm(BigDecimal r116_bnk_150_lcbg_crm) {
		this.r116_bnk_150_lcbg_crm = r116_bnk_150_lcbg_crm;
	}
	public BigDecimal getR116_bnk_150_rwa() {
		return r116_bnk_150_rwa;
	}
	public void setR116_bnk_150_rwa(BigDecimal r116_bnk_150_rwa) {
		this.r116_bnk_150_rwa = r116_bnk_150_rwa;
	}
	public BigDecimal getR116_bnk_150_under_ccf_amt() {
		return r116_bnk_150_under_ccf_amt;
	}
	public void setR116_bnk_150_under_ccf_amt(BigDecimal r116_bnk_150_under_ccf_amt) {
		this.r116_bnk_150_under_ccf_amt = r116_bnk_150_under_ccf_amt;
	}
	public BigDecimal getR117_bnk_150_lcbg_balance() {
		return r117_bnk_150_lcbg_balance;
	}
	public void setR117_bnk_150_lcbg_balance(BigDecimal r117_bnk_150_lcbg_balance) {
		this.r117_bnk_150_lcbg_balance = r117_bnk_150_lcbg_balance;
	}
	public BigDecimal getR117_bnk_150_acceptance_amount() {
		return r117_bnk_150_acceptance_amount;
	}
	public void setR117_bnk_150_acceptance_amount(BigDecimal r117_bnk_150_acceptance_amount) {
		this.r117_bnk_150_acceptance_amount = r117_bnk_150_acceptance_amount;
	}
	public BigDecimal getR117_bnk_150_lcbg_crm() {
		return r117_bnk_150_lcbg_crm;
	}
	public void setR117_bnk_150_lcbg_crm(BigDecimal r117_bnk_150_lcbg_crm) {
		this.r117_bnk_150_lcbg_crm = r117_bnk_150_lcbg_crm;
	}
	public BigDecimal getR117_bnk_150_rwa() {
		return r117_bnk_150_rwa;
	}
	public void setR117_bnk_150_rwa(BigDecimal r117_bnk_150_rwa) {
		this.r117_bnk_150_rwa = r117_bnk_150_rwa;
	}
	public BigDecimal getR117_bnk_150_under_ccf_amt() {
		return r117_bnk_150_under_ccf_amt;
	}
	public void setR117_bnk_150_under_ccf_amt(BigDecimal r117_bnk_150_under_ccf_amt) {
		this.r117_bnk_150_under_ccf_amt = r117_bnk_150_under_ccf_amt;
	}
	public BigDecimal getR118_bnk_150_lcbg_balance() {
		return r118_bnk_150_lcbg_balance;
	}
	public void setR118_bnk_150_lcbg_balance(BigDecimal r118_bnk_150_lcbg_balance) {
		this.r118_bnk_150_lcbg_balance = r118_bnk_150_lcbg_balance;
	}
	public BigDecimal getR118_bnk_150_acceptance_amount() {
		return r118_bnk_150_acceptance_amount;
	}
	public void setR118_bnk_150_acceptance_amount(BigDecimal r118_bnk_150_acceptance_amount) {
		this.r118_bnk_150_acceptance_amount = r118_bnk_150_acceptance_amount;
	}
	public BigDecimal getR118_bnk_150_lcbg_crm() {
		return r118_bnk_150_lcbg_crm;
	}
	public void setR118_bnk_150_lcbg_crm(BigDecimal r118_bnk_150_lcbg_crm) {
		this.r118_bnk_150_lcbg_crm = r118_bnk_150_lcbg_crm;
	}
	public BigDecimal getR118_bnk_150_rwa() {
		return r118_bnk_150_rwa;
	}
	public void setR118_bnk_150_rwa(BigDecimal r118_bnk_150_rwa) {
		this.r118_bnk_150_rwa = r118_bnk_150_rwa;
	}
	public BigDecimal getR118_bnk_150_under_ccf_amt() {
		return r118_bnk_150_under_ccf_amt;
	}
	public void setR118_bnk_150_under_ccf_amt(BigDecimal r118_bnk_150_under_ccf_amt) {
		this.r118_bnk_150_under_ccf_amt = r118_bnk_150_under_ccf_amt;
	}
	public BigDecimal getR119_bnk_lcbg_balance() {
		return r119_bnk_lcbg_balance;
	}
	public void setR119_bnk_lcbg_balance(BigDecimal r119_bnk_lcbg_balance) {
		this.r119_bnk_lcbg_balance = r119_bnk_lcbg_balance;
	}
	public BigDecimal getR119_bnk_acceptance_amount() {
		return r119_bnk_acceptance_amount;
	}
	public void setR119_bnk_acceptance_amount(BigDecimal r119_bnk_acceptance_amount) {
		this.r119_bnk_acceptance_amount = r119_bnk_acceptance_amount;
	}
	public BigDecimal getR119_bnk_lcbg_crm() {
		return r119_bnk_lcbg_crm;
	}
	public void setR119_bnk_lcbg_crm(BigDecimal r119_bnk_lcbg_crm) {
		this.r119_bnk_lcbg_crm = r119_bnk_lcbg_crm;
	}
	public BigDecimal getR119_bnk_rwa() {
		return r119_bnk_rwa;
	}
	public void setR119_bnk_rwa(BigDecimal r119_bnk_rwa) {
		this.r119_bnk_rwa = r119_bnk_rwa;
	}
	public BigDecimal getR119_bnk_under_ccf_amt() {
		return r119_bnk_under_ccf_amt;
	}
	public void setR119_bnk_under_ccf_amt(BigDecimal r119_bnk_under_ccf_amt) {
		this.r119_bnk_under_ccf_amt = r119_bnk_under_ccf_amt;
	}
	public BigDecimal getR120_cbs_0_lcbg_balance() {
		return r120_cbs_0_lcbg_balance;
	}
	public void setR120_cbs_0_lcbg_balance(BigDecimal r120_cbs_0_lcbg_balance) {
		this.r120_cbs_0_lcbg_balance = r120_cbs_0_lcbg_balance;
	}
	public BigDecimal getR120_cbs_0_acceptance_amount() {
		return r120_cbs_0_acceptance_amount;
	}
	public void setR120_cbs_0_acceptance_amount(BigDecimal r120_cbs_0_acceptance_amount) {
		this.r120_cbs_0_acceptance_amount = r120_cbs_0_acceptance_amount;
	}
	public BigDecimal getR120_cbs_0_lcbg_crm() {
		return r120_cbs_0_lcbg_crm;
	}
	public void setR120_cbs_0_lcbg_crm(BigDecimal r120_cbs_0_lcbg_crm) {
		this.r120_cbs_0_lcbg_crm = r120_cbs_0_lcbg_crm;
	}
	public BigDecimal getR120_cbs_0_rwa() {
		return r120_cbs_0_rwa;
	}
	public void setR120_cbs_0_rwa(BigDecimal r120_cbs_0_rwa) {
		this.r120_cbs_0_rwa = r120_cbs_0_rwa;
	}
	public BigDecimal getR120_cbs_0_under_ccf_amt() {
		return r120_cbs_0_under_ccf_amt;
	}
	public void setR120_cbs_0_under_ccf_amt(BigDecimal r120_cbs_0_under_ccf_amt) {
		this.r120_cbs_0_under_ccf_amt = r120_cbs_0_under_ccf_amt;
	}
	public BigDecimal getR121_cbs_0_lcbg_balance() {
		return r121_cbs_0_lcbg_balance;
	}
	public void setR121_cbs_0_lcbg_balance(BigDecimal r121_cbs_0_lcbg_balance) {
		this.r121_cbs_0_lcbg_balance = r121_cbs_0_lcbg_balance;
	}
	public BigDecimal getR121_cbs_0_acceptance_amount() {
		return r121_cbs_0_acceptance_amount;
	}
	public void setR121_cbs_0_acceptance_amount(BigDecimal r121_cbs_0_acceptance_amount) {
		this.r121_cbs_0_acceptance_amount = r121_cbs_0_acceptance_amount;
	}
	public BigDecimal getR121_cbs_0_lcbg_crm() {
		return r121_cbs_0_lcbg_crm;
	}
	public void setR121_cbs_0_lcbg_crm(BigDecimal r121_cbs_0_lcbg_crm) {
		this.r121_cbs_0_lcbg_crm = r121_cbs_0_lcbg_crm;
	}
	public BigDecimal getR121_cbs_0_rwa() {
		return r121_cbs_0_rwa;
	}
	public void setR121_cbs_0_rwa(BigDecimal r121_cbs_0_rwa) {
		this.r121_cbs_0_rwa = r121_cbs_0_rwa;
	}
	public BigDecimal getR121_cbs_0_under_ccf_amt() {
		return r121_cbs_0_under_ccf_amt;
	}
	public void setR121_cbs_0_under_ccf_amt(BigDecimal r121_cbs_0_under_ccf_amt) {
		this.r121_cbs_0_under_ccf_amt = r121_cbs_0_under_ccf_amt;
	}
	public BigDecimal getR122_cbs_0_lcbg_balance() {
		return r122_cbs_0_lcbg_balance;
	}
	public void setR122_cbs_0_lcbg_balance(BigDecimal r122_cbs_0_lcbg_balance) {
		this.r122_cbs_0_lcbg_balance = r122_cbs_0_lcbg_balance;
	}
	public BigDecimal getR122_cbs_0_acceptance_amount() {
		return r122_cbs_0_acceptance_amount;
	}
	public void setR122_cbs_0_acceptance_amount(BigDecimal r122_cbs_0_acceptance_amount) {
		this.r122_cbs_0_acceptance_amount = r122_cbs_0_acceptance_amount;
	}
	public BigDecimal getR122_cbs_0_lcbg_crm() {
		return r122_cbs_0_lcbg_crm;
	}
	public void setR122_cbs_0_lcbg_crm(BigDecimal r122_cbs_0_lcbg_crm) {
		this.r122_cbs_0_lcbg_crm = r122_cbs_0_lcbg_crm;
	}
	public BigDecimal getR122_cbs_0_rwa() {
		return r122_cbs_0_rwa;
	}
	public void setR122_cbs_0_rwa(BigDecimal r122_cbs_0_rwa) {
		this.r122_cbs_0_rwa = r122_cbs_0_rwa;
	}
	public BigDecimal getR122_cbs_0_under_ccf_amt() {
		return r122_cbs_0_under_ccf_amt;
	}
	public void setR122_cbs_0_under_ccf_amt(BigDecimal r122_cbs_0_under_ccf_amt) {
		this.r122_cbs_0_under_ccf_amt = r122_cbs_0_under_ccf_amt;
	}
	public BigDecimal getR123_cbs_lcbg_balance() {
		return r123_cbs_lcbg_balance;
	}
	public void setR123_cbs_lcbg_balance(BigDecimal r123_cbs_lcbg_balance) {
		this.r123_cbs_lcbg_balance = r123_cbs_lcbg_balance;
	}
	public BigDecimal getR123_cbs_acceptance_amount() {
		return r123_cbs_acceptance_amount;
	}
	public void setR123_cbs_acceptance_amount(BigDecimal r123_cbs_acceptance_amount) {
		this.r123_cbs_acceptance_amount = r123_cbs_acceptance_amount;
	}
	public BigDecimal getR123_cbs_lcbg_crm() {
		return r123_cbs_lcbg_crm;
	}
	public void setR123_cbs_lcbg_crm(BigDecimal r123_cbs_lcbg_crm) {
		this.r123_cbs_lcbg_crm = r123_cbs_lcbg_crm;
	}
	public BigDecimal getR123_cbs_rwa() {
		return r123_cbs_rwa;
	}
	public void setR123_cbs_rwa(BigDecimal r123_cbs_rwa) {
		this.r123_cbs_rwa = r123_cbs_rwa;
	}
	public BigDecimal getR123_cbs_under_ccf_amt() {
		return r123_cbs_under_ccf_amt;
	}
	public void setR123_cbs_under_ccf_amt(BigDecimal r123_cbs_under_ccf_amt) {
		this.r123_cbs_under_ccf_amt = r123_cbs_under_ccf_amt;
	}
	public BigDecimal getR124_cbs_20_lcbg_balance() {
		return r124_cbs_20_lcbg_balance;
	}
	public void setR124_cbs_20_lcbg_balance(BigDecimal r124_cbs_20_lcbg_balance) {
		this.r124_cbs_20_lcbg_balance = r124_cbs_20_lcbg_balance;
	}
	public BigDecimal getR124_cbs_20_acceptance_amount() {
		return r124_cbs_20_acceptance_amount;
	}
	public void setR124_cbs_20_acceptance_amount(BigDecimal r124_cbs_20_acceptance_amount) {
		this.r124_cbs_20_acceptance_amount = r124_cbs_20_acceptance_amount;
	}
	public BigDecimal getR124_cbs_20_lcbg_crm() {
		return r124_cbs_20_lcbg_crm;
	}
	public void setR124_cbs_20_lcbg_crm(BigDecimal r124_cbs_20_lcbg_crm) {
		this.r124_cbs_20_lcbg_crm = r124_cbs_20_lcbg_crm;
	}
	public BigDecimal getR124_cbs_20_rwa() {
		return r124_cbs_20_rwa;
	}
	public void setR124_cbs_20_rwa(BigDecimal r124_cbs_20_rwa) {
		this.r124_cbs_20_rwa = r124_cbs_20_rwa;
	}
	public BigDecimal getR124_cbs_20_under_ccf_amt() {
		return r124_cbs_20_under_ccf_amt;
	}
	public void setR124_cbs_20_under_ccf_amt(BigDecimal r124_cbs_20_under_ccf_amt) {
		this.r124_cbs_20_under_ccf_amt = r124_cbs_20_under_ccf_amt;
	}
	public BigDecimal getR125_cbs_20_lcbg_balance() {
		return r125_cbs_20_lcbg_balance;
	}
	public void setR125_cbs_20_lcbg_balance(BigDecimal r125_cbs_20_lcbg_balance) {
		this.r125_cbs_20_lcbg_balance = r125_cbs_20_lcbg_balance;
	}
	public BigDecimal getR125_cbs_20_acceptance_amount() {
		return r125_cbs_20_acceptance_amount;
	}
	public void setR125_cbs_20_acceptance_amount(BigDecimal r125_cbs_20_acceptance_amount) {
		this.r125_cbs_20_acceptance_amount = r125_cbs_20_acceptance_amount;
	}
	public BigDecimal getR125_cbs_20_lcbg_crm() {
		return r125_cbs_20_lcbg_crm;
	}
	public void setR125_cbs_20_lcbg_crm(BigDecimal r125_cbs_20_lcbg_crm) {
		this.r125_cbs_20_lcbg_crm = r125_cbs_20_lcbg_crm;
	}
	public BigDecimal getR125_cbs_20_rwa() {
		return r125_cbs_20_rwa;
	}
	public void setR125_cbs_20_rwa(BigDecimal r125_cbs_20_rwa) {
		this.r125_cbs_20_rwa = r125_cbs_20_rwa;
	}
	public BigDecimal getR125_cbs_20_under_ccf_amt() {
		return r125_cbs_20_under_ccf_amt;
	}
	public void setR125_cbs_20_under_ccf_amt(BigDecimal r125_cbs_20_under_ccf_amt) {
		this.r125_cbs_20_under_ccf_amt = r125_cbs_20_under_ccf_amt;
	}
	public BigDecimal getR126_cbs_20_lcbg_balance() {
		return r126_cbs_20_lcbg_balance;
	}
	public void setR126_cbs_20_lcbg_balance(BigDecimal r126_cbs_20_lcbg_balance) {
		this.r126_cbs_20_lcbg_balance = r126_cbs_20_lcbg_balance;
	}
	public BigDecimal getR126_cbs_20_acceptance_amount() {
		return r126_cbs_20_acceptance_amount;
	}
	public void setR126_cbs_20_acceptance_amount(BigDecimal r126_cbs_20_acceptance_amount) {
		this.r126_cbs_20_acceptance_amount = r126_cbs_20_acceptance_amount;
	}
	public BigDecimal getR126_cbs_20_lcbg_crm() {
		return r126_cbs_20_lcbg_crm;
	}
	public void setR126_cbs_20_lcbg_crm(BigDecimal r126_cbs_20_lcbg_crm) {
		this.r126_cbs_20_lcbg_crm = r126_cbs_20_lcbg_crm;
	}
	public BigDecimal getR126_cbs_20_rwa() {
		return r126_cbs_20_rwa;
	}
	public void setR126_cbs_20_rwa(BigDecimal r126_cbs_20_rwa) {
		this.r126_cbs_20_rwa = r126_cbs_20_rwa;
	}
	public BigDecimal getR126_cbs_20_under_ccf_amt() {
		return r126_cbs_20_under_ccf_amt;
	}
	public void setR126_cbs_20_under_ccf_amt(BigDecimal r126_cbs_20_under_ccf_amt) {
		this.r126_cbs_20_under_ccf_amt = r126_cbs_20_under_ccf_amt;
	}
	public BigDecimal getR127_cbs_lcbg_balance() {
		return r127_cbs_lcbg_balance;
	}
	public void setR127_cbs_lcbg_balance(BigDecimal r127_cbs_lcbg_balance) {
		this.r127_cbs_lcbg_balance = r127_cbs_lcbg_balance;
	}
	public BigDecimal getR127_cbs_acceptance_amount() {
		return r127_cbs_acceptance_amount;
	}
	public void setR127_cbs_acceptance_amount(BigDecimal r127_cbs_acceptance_amount) {
		this.r127_cbs_acceptance_amount = r127_cbs_acceptance_amount;
	}
	public BigDecimal getR127_cbs_lcbg_crm() {
		return r127_cbs_lcbg_crm;
	}
	public void setR127_cbs_lcbg_crm(BigDecimal r127_cbs_lcbg_crm) {
		this.r127_cbs_lcbg_crm = r127_cbs_lcbg_crm;
	}
	public BigDecimal getR127_cbs_rwa() {
		return r127_cbs_rwa;
	}
	public void setR127_cbs_rwa(BigDecimal r127_cbs_rwa) {
		this.r127_cbs_rwa = r127_cbs_rwa;
	}
	public BigDecimal getR127_cbs_under_ccf_amt() {
		return r127_cbs_under_ccf_amt;
	}
	public void setR127_cbs_under_ccf_amt(BigDecimal r127_cbs_under_ccf_amt) {
		this.r127_cbs_under_ccf_amt = r127_cbs_under_ccf_amt;
	}
	public BigDecimal getR128_cbs_20_lcbg_balance() {
		return r128_cbs_20_lcbg_balance;
	}
	public void setR128_cbs_20_lcbg_balance(BigDecimal r128_cbs_20_lcbg_balance) {
		this.r128_cbs_20_lcbg_balance = r128_cbs_20_lcbg_balance;
	}
	public BigDecimal getR128_cbs_20_acceptance_amount() {
		return r128_cbs_20_acceptance_amount;
	}
	public void setR128_cbs_20_acceptance_amount(BigDecimal r128_cbs_20_acceptance_amount) {
		this.r128_cbs_20_acceptance_amount = r128_cbs_20_acceptance_amount;
	}
	public BigDecimal getR128_cbs_20_lcbg_crm() {
		return r128_cbs_20_lcbg_crm;
	}
	public void setR128_cbs_20_lcbg_crm(BigDecimal r128_cbs_20_lcbg_crm) {
		this.r128_cbs_20_lcbg_crm = r128_cbs_20_lcbg_crm;
	}
	public BigDecimal getR128_cbs_20_rwa() {
		return r128_cbs_20_rwa;
	}
	public void setR128_cbs_20_rwa(BigDecimal r128_cbs_20_rwa) {
		this.r128_cbs_20_rwa = r128_cbs_20_rwa;
	}
	public BigDecimal getR128_cbs_20_under_ccf_amt() {
		return r128_cbs_20_under_ccf_amt;
	}
	public void setR128_cbs_20_under_ccf_amt(BigDecimal r128_cbs_20_under_ccf_amt) {
		this.r128_cbs_20_under_ccf_amt = r128_cbs_20_under_ccf_amt;
	}
	public BigDecimal getR129_cbs_20_lcbg_balance() {
		return r129_cbs_20_lcbg_balance;
	}
	public void setR129_cbs_20_lcbg_balance(BigDecimal r129_cbs_20_lcbg_balance) {
		this.r129_cbs_20_lcbg_balance = r129_cbs_20_lcbg_balance;
	}
	public BigDecimal getR129_cbs_20_acceptance_amount() {
		return r129_cbs_20_acceptance_amount;
	}
	public void setR129_cbs_20_acceptance_amount(BigDecimal r129_cbs_20_acceptance_amount) {
		this.r129_cbs_20_acceptance_amount = r129_cbs_20_acceptance_amount;
	}
	public BigDecimal getR129_cbs_20_lcbg_crm() {
		return r129_cbs_20_lcbg_crm;
	}
	public void setR129_cbs_20_lcbg_crm(BigDecimal r129_cbs_20_lcbg_crm) {
		this.r129_cbs_20_lcbg_crm = r129_cbs_20_lcbg_crm;
	}
	public BigDecimal getR129_cbs_20_rwa() {
		return r129_cbs_20_rwa;
	}
	public void setR129_cbs_20_rwa(BigDecimal r129_cbs_20_rwa) {
		this.r129_cbs_20_rwa = r129_cbs_20_rwa;
	}
	public BigDecimal getR129_cbs_20_under_ccf_amt() {
		return r129_cbs_20_under_ccf_amt;
	}
	public void setR129_cbs_20_under_ccf_amt(BigDecimal r129_cbs_20_under_ccf_amt) {
		this.r129_cbs_20_under_ccf_amt = r129_cbs_20_under_ccf_amt;
	}
	public BigDecimal getR130_cbs_20_lcbg_balance() {
		return r130_cbs_20_lcbg_balance;
	}
	public void setR130_cbs_20_lcbg_balance(BigDecimal r130_cbs_20_lcbg_balance) {
		this.r130_cbs_20_lcbg_balance = r130_cbs_20_lcbg_balance;
	}
	public BigDecimal getR130_cbs_20_acceptance_amount() {
		return r130_cbs_20_acceptance_amount;
	}
	public void setR130_cbs_20_acceptance_amount(BigDecimal r130_cbs_20_acceptance_amount) {
		this.r130_cbs_20_acceptance_amount = r130_cbs_20_acceptance_amount;
	}
	public BigDecimal getR130_cbs_20_lcbg_crm() {
		return r130_cbs_20_lcbg_crm;
	}
	public void setR130_cbs_20_lcbg_crm(BigDecimal r130_cbs_20_lcbg_crm) {
		this.r130_cbs_20_lcbg_crm = r130_cbs_20_lcbg_crm;
	}
	public BigDecimal getR130_cbs_20_rwa() {
		return r130_cbs_20_rwa;
	}
	public void setR130_cbs_20_rwa(BigDecimal r130_cbs_20_rwa) {
		this.r130_cbs_20_rwa = r130_cbs_20_rwa;
	}
	public BigDecimal getR130_cbs_20_under_ccf_amt() {
		return r130_cbs_20_under_ccf_amt;
	}
	public void setR130_cbs_20_under_ccf_amt(BigDecimal r130_cbs_20_under_ccf_amt) {
		this.r130_cbs_20_under_ccf_amt = r130_cbs_20_under_ccf_amt;
	}
	public BigDecimal getR131_cbs_lcbg_balance() {
		return r131_cbs_lcbg_balance;
	}
	public void setR131_cbs_lcbg_balance(BigDecimal r131_cbs_lcbg_balance) {
		this.r131_cbs_lcbg_balance = r131_cbs_lcbg_balance;
	}
	public BigDecimal getR131_cbs_acceptance_amount() {
		return r131_cbs_acceptance_amount;
	}
	public void setR131_cbs_acceptance_amount(BigDecimal r131_cbs_acceptance_amount) {
		this.r131_cbs_acceptance_amount = r131_cbs_acceptance_amount;
	}
	public BigDecimal getR131_cbs_lcbg_crm() {
		return r131_cbs_lcbg_crm;
	}
	public void setR131_cbs_lcbg_crm(BigDecimal r131_cbs_lcbg_crm) {
		this.r131_cbs_lcbg_crm = r131_cbs_lcbg_crm;
	}
	public BigDecimal getR131_cbs_rwa() {
		return r131_cbs_rwa;
	}
	public void setR131_cbs_rwa(BigDecimal r131_cbs_rwa) {
		this.r131_cbs_rwa = r131_cbs_rwa;
	}
	public BigDecimal getR131_cbs_under_ccf_amt() {
		return r131_cbs_under_ccf_amt;
	}
	public void setR131_cbs_under_ccf_amt(BigDecimal r131_cbs_under_ccf_amt) {
		this.r131_cbs_under_ccf_amt = r131_cbs_under_ccf_amt;
	}
	public BigDecimal getR132_cbs_0_lcbg_balance() {
		return r132_cbs_0_lcbg_balance;
	}
	public void setR132_cbs_0_lcbg_balance(BigDecimal r132_cbs_0_lcbg_balance) {
		this.r132_cbs_0_lcbg_balance = r132_cbs_0_lcbg_balance;
	}
	public BigDecimal getR132_cbs_0_acceptance_amount() {
		return r132_cbs_0_acceptance_amount;
	}
	public void setR132_cbs_0_acceptance_amount(BigDecimal r132_cbs_0_acceptance_amount) {
		this.r132_cbs_0_acceptance_amount = r132_cbs_0_acceptance_amount;
	}
	public BigDecimal getR132_cbs_0_lcbg_crm() {
		return r132_cbs_0_lcbg_crm;
	}
	public void setR132_cbs_0_lcbg_crm(BigDecimal r132_cbs_0_lcbg_crm) {
		this.r132_cbs_0_lcbg_crm = r132_cbs_0_lcbg_crm;
	}
	public BigDecimal getR132_cbs_0_rwa() {
		return r132_cbs_0_rwa;
	}
	public void setR132_cbs_0_rwa(BigDecimal r132_cbs_0_rwa) {
		this.r132_cbs_0_rwa = r132_cbs_0_rwa;
	}
	public BigDecimal getR132_cbs_0_under_ccf_amt() {
		return r132_cbs_0_under_ccf_amt;
	}
	public void setR132_cbs_0_under_ccf_amt(BigDecimal r132_cbs_0_under_ccf_amt) {
		this.r132_cbs_0_under_ccf_amt = r132_cbs_0_under_ccf_amt;
	}
	public BigDecimal getR133_cbs_0_lcbg_balance() {
		return r133_cbs_0_lcbg_balance;
	}
	public void setR133_cbs_0_lcbg_balance(BigDecimal r133_cbs_0_lcbg_balance) {
		this.r133_cbs_0_lcbg_balance = r133_cbs_0_lcbg_balance;
	}
	public BigDecimal getR133_cbs_0_acceptance_amount() {
		return r133_cbs_0_acceptance_amount;
	}
	public void setR133_cbs_0_acceptance_amount(BigDecimal r133_cbs_0_acceptance_amount) {
		this.r133_cbs_0_acceptance_amount = r133_cbs_0_acceptance_amount;
	}
	public BigDecimal getR133_cbs_0_lcbg_crm() {
		return r133_cbs_0_lcbg_crm;
	}
	public void setR133_cbs_0_lcbg_crm(BigDecimal r133_cbs_0_lcbg_crm) {
		this.r133_cbs_0_lcbg_crm = r133_cbs_0_lcbg_crm;
	}
	public BigDecimal getR133_cbs_0_rwa() {
		return r133_cbs_0_rwa;
	}
	public void setR133_cbs_0_rwa(BigDecimal r133_cbs_0_rwa) {
		this.r133_cbs_0_rwa = r133_cbs_0_rwa;
	}
	public BigDecimal getR133_cbs_0_under_ccf_amt() {
		return r133_cbs_0_under_ccf_amt;
	}
	public void setR133_cbs_0_under_ccf_amt(BigDecimal r133_cbs_0_under_ccf_amt) {
		this.r133_cbs_0_under_ccf_amt = r133_cbs_0_under_ccf_amt;
	}
	public BigDecimal getR134_cbs_0_lcbg_balance() {
		return r134_cbs_0_lcbg_balance;
	}
	public void setR134_cbs_0_lcbg_balance(BigDecimal r134_cbs_0_lcbg_balance) {
		this.r134_cbs_0_lcbg_balance = r134_cbs_0_lcbg_balance;
	}
	public BigDecimal getR134_cbs_0_acceptance_amount() {
		return r134_cbs_0_acceptance_amount;
	}
	public void setR134_cbs_0_acceptance_amount(BigDecimal r134_cbs_0_acceptance_amount) {
		this.r134_cbs_0_acceptance_amount = r134_cbs_0_acceptance_amount;
	}
	public BigDecimal getR134_cbs_0_lcbg_crm() {
		return r134_cbs_0_lcbg_crm;
	}
	public void setR134_cbs_0_lcbg_crm(BigDecimal r134_cbs_0_lcbg_crm) {
		this.r134_cbs_0_lcbg_crm = r134_cbs_0_lcbg_crm;
	}
	public BigDecimal getR134_cbs_0_rwa() {
		return r134_cbs_0_rwa;
	}
	public void setR134_cbs_0_rwa(BigDecimal r134_cbs_0_rwa) {
		this.r134_cbs_0_rwa = r134_cbs_0_rwa;
	}
	public BigDecimal getR134_cbs_0_under_ccf_amt() {
		return r134_cbs_0_under_ccf_amt;
	}
	public void setR134_cbs_0_under_ccf_amt(BigDecimal r134_cbs_0_under_ccf_amt) {
		this.r134_cbs_0_under_ccf_amt = r134_cbs_0_under_ccf_amt;
	}
	public BigDecimal getR135_cbs_lcbg_balance() {
		return r135_cbs_lcbg_balance;
	}
	public void setR135_cbs_lcbg_balance(BigDecimal r135_cbs_lcbg_balance) {
		this.r135_cbs_lcbg_balance = r135_cbs_lcbg_balance;
	}
	public BigDecimal getR135_cbs_acceptance_amount() {
		return r135_cbs_acceptance_amount;
	}
	public void setR135_cbs_acceptance_amount(BigDecimal r135_cbs_acceptance_amount) {
		this.r135_cbs_acceptance_amount = r135_cbs_acceptance_amount;
	}
	public BigDecimal getR135_cbs_lcbg_crm() {
		return r135_cbs_lcbg_crm;
	}
	public void setR135_cbs_lcbg_crm(BigDecimal r135_cbs_lcbg_crm) {
		this.r135_cbs_lcbg_crm = r135_cbs_lcbg_crm;
	}
	public BigDecimal getR135_cbs_rwa() {
		return r135_cbs_rwa;
	}
	public void setR135_cbs_rwa(BigDecimal r135_cbs_rwa) {
		this.r135_cbs_rwa = r135_cbs_rwa;
	}
	public BigDecimal getR135_cbs_under_ccf_amt() {
		return r135_cbs_under_ccf_amt;
	}
	public void setR135_cbs_under_ccf_amt(BigDecimal r135_cbs_under_ccf_amt) {
		this.r135_cbs_under_ccf_amt = r135_cbs_under_ccf_amt;
	}
	public BigDecimal getR136_cbs_20_lcbg_balance() {
		return r136_cbs_20_lcbg_balance;
	}
	public void setR136_cbs_20_lcbg_balance(BigDecimal r136_cbs_20_lcbg_balance) {
		this.r136_cbs_20_lcbg_balance = r136_cbs_20_lcbg_balance;
	}
	public BigDecimal getR136_cbs_20_acceptance_amount() {
		return r136_cbs_20_acceptance_amount;
	}
	public void setR136_cbs_20_acceptance_amount(BigDecimal r136_cbs_20_acceptance_amount) {
		this.r136_cbs_20_acceptance_amount = r136_cbs_20_acceptance_amount;
	}
	public BigDecimal getR136_cbs_20_lcbg_crm() {
		return r136_cbs_20_lcbg_crm;
	}
	public void setR136_cbs_20_lcbg_crm(BigDecimal r136_cbs_20_lcbg_crm) {
		this.r136_cbs_20_lcbg_crm = r136_cbs_20_lcbg_crm;
	}
	public BigDecimal getR136_cbs_20_rwa() {
		return r136_cbs_20_rwa;
	}
	public void setR136_cbs_20_rwa(BigDecimal r136_cbs_20_rwa) {
		this.r136_cbs_20_rwa = r136_cbs_20_rwa;
	}
	public BigDecimal getR136_cbs_20_under_ccf_amt() {
		return r136_cbs_20_under_ccf_amt;
	}
	public void setR136_cbs_20_under_ccf_amt(BigDecimal r136_cbs_20_under_ccf_amt) {
		this.r136_cbs_20_under_ccf_amt = r136_cbs_20_under_ccf_amt;
	}
	public BigDecimal getR137_cbs_20_lcbg_balance() {
		return r137_cbs_20_lcbg_balance;
	}
	public void setR137_cbs_20_lcbg_balance(BigDecimal r137_cbs_20_lcbg_balance) {
		this.r137_cbs_20_lcbg_balance = r137_cbs_20_lcbg_balance;
	}
	public BigDecimal getR137_cbs_20_acceptance_amount() {
		return r137_cbs_20_acceptance_amount;
	}
	public void setR137_cbs_20_acceptance_amount(BigDecimal r137_cbs_20_acceptance_amount) {
		this.r137_cbs_20_acceptance_amount = r137_cbs_20_acceptance_amount;
	}
	public BigDecimal getR137_cbs_20_lcbg_crm() {
		return r137_cbs_20_lcbg_crm;
	}
	public void setR137_cbs_20_lcbg_crm(BigDecimal r137_cbs_20_lcbg_crm) {
		this.r137_cbs_20_lcbg_crm = r137_cbs_20_lcbg_crm;
	}
	public BigDecimal getR137_cbs_20_rwa() {
		return r137_cbs_20_rwa;
	}
	public void setR137_cbs_20_rwa(BigDecimal r137_cbs_20_rwa) {
		this.r137_cbs_20_rwa = r137_cbs_20_rwa;
	}
	public BigDecimal getR137_cbs_20_under_ccf_amt() {
		return r137_cbs_20_under_ccf_amt;
	}
	public void setR137_cbs_20_under_ccf_amt(BigDecimal r137_cbs_20_under_ccf_amt) {
		this.r137_cbs_20_under_ccf_amt = r137_cbs_20_under_ccf_amt;
	}
	public BigDecimal getR138_cbs_20_lcbg_balance() {
		return r138_cbs_20_lcbg_balance;
	}
	public void setR138_cbs_20_lcbg_balance(BigDecimal r138_cbs_20_lcbg_balance) {
		this.r138_cbs_20_lcbg_balance = r138_cbs_20_lcbg_balance;
	}
	public BigDecimal getR138_cbs_20_acceptance_amount() {
		return r138_cbs_20_acceptance_amount;
	}
	public void setR138_cbs_20_acceptance_amount(BigDecimal r138_cbs_20_acceptance_amount) {
		this.r138_cbs_20_acceptance_amount = r138_cbs_20_acceptance_amount;
	}
	public BigDecimal getR138_cbs_20_lcbg_crm() {
		return r138_cbs_20_lcbg_crm;
	}
	public void setR138_cbs_20_lcbg_crm(BigDecimal r138_cbs_20_lcbg_crm) {
		this.r138_cbs_20_lcbg_crm = r138_cbs_20_lcbg_crm;
	}
	public BigDecimal getR138_cbs_20_rwa() {
		return r138_cbs_20_rwa;
	}
	public void setR138_cbs_20_rwa(BigDecimal r138_cbs_20_rwa) {
		this.r138_cbs_20_rwa = r138_cbs_20_rwa;
	}
	public BigDecimal getR138_cbs_20_under_ccf_amt() {
		return r138_cbs_20_under_ccf_amt;
	}
	public void setR138_cbs_20_under_ccf_amt(BigDecimal r138_cbs_20_under_ccf_amt) {
		this.r138_cbs_20_under_ccf_amt = r138_cbs_20_under_ccf_amt;
	}
	public BigDecimal getR139_cbs_lcbg_balance() {
		return r139_cbs_lcbg_balance;
	}
	public void setR139_cbs_lcbg_balance(BigDecimal r139_cbs_lcbg_balance) {
		this.r139_cbs_lcbg_balance = r139_cbs_lcbg_balance;
	}
	public BigDecimal getR139_cbs_acceptance_amount() {
		return r139_cbs_acceptance_amount;
	}
	public void setR139_cbs_acceptance_amount(BigDecimal r139_cbs_acceptance_amount) {
		this.r139_cbs_acceptance_amount = r139_cbs_acceptance_amount;
	}
	public BigDecimal getR139_cbs_lcbg_crm() {
		return r139_cbs_lcbg_crm;
	}
	public void setR139_cbs_lcbg_crm(BigDecimal r139_cbs_lcbg_crm) {
		this.r139_cbs_lcbg_crm = r139_cbs_lcbg_crm;
	}
	public BigDecimal getR139_cbs_rwa() {
		return r139_cbs_rwa;
	}
	public void setR139_cbs_rwa(BigDecimal r139_cbs_rwa) {
		this.r139_cbs_rwa = r139_cbs_rwa;
	}
	public BigDecimal getR139_cbs_under_ccf_amt() {
		return r139_cbs_under_ccf_amt;
	}
	public void setR139_cbs_under_ccf_amt(BigDecimal r139_cbs_under_ccf_amt) {
		this.r139_cbs_under_ccf_amt = r139_cbs_under_ccf_amt;
	}
	public BigDecimal getR140_cbs_50_lcbg_balance() {
		return r140_cbs_50_lcbg_balance;
	}
	public void setR140_cbs_50_lcbg_balance(BigDecimal r140_cbs_50_lcbg_balance) {
		this.r140_cbs_50_lcbg_balance = r140_cbs_50_lcbg_balance;
	}
	public BigDecimal getR140_cbs_50_acceptance_amount() {
		return r140_cbs_50_acceptance_amount;
	}
	public void setR140_cbs_50_acceptance_amount(BigDecimal r140_cbs_50_acceptance_amount) {
		this.r140_cbs_50_acceptance_amount = r140_cbs_50_acceptance_amount;
	}
	public BigDecimal getR140_cbs_50_lcbg_crm() {
		return r140_cbs_50_lcbg_crm;
	}
	public void setR140_cbs_50_lcbg_crm(BigDecimal r140_cbs_50_lcbg_crm) {
		this.r140_cbs_50_lcbg_crm = r140_cbs_50_lcbg_crm;
	}
	public BigDecimal getR140_cbs_50_rwa() {
		return r140_cbs_50_rwa;
	}
	public void setR140_cbs_50_rwa(BigDecimal r140_cbs_50_rwa) {
		this.r140_cbs_50_rwa = r140_cbs_50_rwa;
	}
	public BigDecimal getR140_cbs_50_under_ccf_amt() {
		return r140_cbs_50_under_ccf_amt;
	}
	public void setR140_cbs_50_under_ccf_amt(BigDecimal r140_cbs_50_under_ccf_amt) {
		this.r140_cbs_50_under_ccf_amt = r140_cbs_50_under_ccf_amt;
	}
	public BigDecimal getR141_cbs_50_lcbg_balance() {
		return r141_cbs_50_lcbg_balance;
	}
	public void setR141_cbs_50_lcbg_balance(BigDecimal r141_cbs_50_lcbg_balance) {
		this.r141_cbs_50_lcbg_balance = r141_cbs_50_lcbg_balance;
	}
	public BigDecimal getR141_cbs_50_acceptance_amount() {
		return r141_cbs_50_acceptance_amount;
	}
	public void setR141_cbs_50_acceptance_amount(BigDecimal r141_cbs_50_acceptance_amount) {
		this.r141_cbs_50_acceptance_amount = r141_cbs_50_acceptance_amount;
	}
	public BigDecimal getR141_cbs_50_lcbg_crm() {
		return r141_cbs_50_lcbg_crm;
	}
	public void setR141_cbs_50_lcbg_crm(BigDecimal r141_cbs_50_lcbg_crm) {
		this.r141_cbs_50_lcbg_crm = r141_cbs_50_lcbg_crm;
	}
	public BigDecimal getR141_cbs_50_rwa() {
		return r141_cbs_50_rwa;
	}
	public void setR141_cbs_50_rwa(BigDecimal r141_cbs_50_rwa) {
		this.r141_cbs_50_rwa = r141_cbs_50_rwa;
	}
	public BigDecimal getR141_cbs_50_under_ccf_amt() {
		return r141_cbs_50_under_ccf_amt;
	}
	public void setR141_cbs_50_under_ccf_amt(BigDecimal r141_cbs_50_under_ccf_amt) {
		this.r141_cbs_50_under_ccf_amt = r141_cbs_50_under_ccf_amt;
	}
	public BigDecimal getR142_cbs_50_lcbg_balance() {
		return r142_cbs_50_lcbg_balance;
	}
	public void setR142_cbs_50_lcbg_balance(BigDecimal r142_cbs_50_lcbg_balance) {
		this.r142_cbs_50_lcbg_balance = r142_cbs_50_lcbg_balance;
	}
	public BigDecimal getR142_cbs_50_acceptance_amount() {
		return r142_cbs_50_acceptance_amount;
	}
	public void setR142_cbs_50_acceptance_amount(BigDecimal r142_cbs_50_acceptance_amount) {
		this.r142_cbs_50_acceptance_amount = r142_cbs_50_acceptance_amount;
	}
	public BigDecimal getR142_cbs_50_lcbg_crm() {
		return r142_cbs_50_lcbg_crm;
	}
	public void setR142_cbs_50_lcbg_crm(BigDecimal r142_cbs_50_lcbg_crm) {
		this.r142_cbs_50_lcbg_crm = r142_cbs_50_lcbg_crm;
	}
	public BigDecimal getR142_cbs_50_rwa() {
		return r142_cbs_50_rwa;
	}
	public void setR142_cbs_50_rwa(BigDecimal r142_cbs_50_rwa) {
		this.r142_cbs_50_rwa = r142_cbs_50_rwa;
	}
	public BigDecimal getR142_cbs_50_under_ccf_amt() {
		return r142_cbs_50_under_ccf_amt;
	}
	public void setR142_cbs_50_under_ccf_amt(BigDecimal r142_cbs_50_under_ccf_amt) {
		this.r142_cbs_50_under_ccf_amt = r142_cbs_50_under_ccf_amt;
	}
	public BigDecimal getR143_cbs_lcbg_balance() {
		return r143_cbs_lcbg_balance;
	}
	public void setR143_cbs_lcbg_balance(BigDecimal r143_cbs_lcbg_balance) {
		this.r143_cbs_lcbg_balance = r143_cbs_lcbg_balance;
	}
	public BigDecimal getR143_cbs_acceptance_amount() {
		return r143_cbs_acceptance_amount;
	}
	public void setR143_cbs_acceptance_amount(BigDecimal r143_cbs_acceptance_amount) {
		this.r143_cbs_acceptance_amount = r143_cbs_acceptance_amount;
	}
	public BigDecimal getR143_cbs_lcbg_crm() {
		return r143_cbs_lcbg_crm;
	}
	public void setR143_cbs_lcbg_crm(BigDecimal r143_cbs_lcbg_crm) {
		this.r143_cbs_lcbg_crm = r143_cbs_lcbg_crm;
	}
	public BigDecimal getR143_cbs_rwa() {
		return r143_cbs_rwa;
	}
	public void setR143_cbs_rwa(BigDecimal r143_cbs_rwa) {
		this.r143_cbs_rwa = r143_cbs_rwa;
	}
	public BigDecimal getR143_cbs_under_ccf_amt() {
		return r143_cbs_under_ccf_amt;
	}
	public void setR143_cbs_under_ccf_amt(BigDecimal r143_cbs_under_ccf_amt) {
		this.r143_cbs_under_ccf_amt = r143_cbs_under_ccf_amt;
	}
	public BigDecimal getR144_cbs_100_lcbg_balance() {
		return r144_cbs_100_lcbg_balance;
	}
	public void setR144_cbs_100_lcbg_balance(BigDecimal r144_cbs_100_lcbg_balance) {
		this.r144_cbs_100_lcbg_balance = r144_cbs_100_lcbg_balance;
	}
	public BigDecimal getR144_cbs_100_acceptance_amount() {
		return r144_cbs_100_acceptance_amount;
	}
	public void setR144_cbs_100_acceptance_amount(BigDecimal r144_cbs_100_acceptance_amount) {
		this.r144_cbs_100_acceptance_amount = r144_cbs_100_acceptance_amount;
	}
	public BigDecimal getR144_cbs_100_lcbg_crm() {
		return r144_cbs_100_lcbg_crm;
	}
	public void setR144_cbs_100_lcbg_crm(BigDecimal r144_cbs_100_lcbg_crm) {
		this.r144_cbs_100_lcbg_crm = r144_cbs_100_lcbg_crm;
	}
	public BigDecimal getR144_cbs_100_rwa() {
		return r144_cbs_100_rwa;
	}
	public void setR144_cbs_100_rwa(BigDecimal r144_cbs_100_rwa) {
		this.r144_cbs_100_rwa = r144_cbs_100_rwa;
	}
	public BigDecimal getR144_cbs_100_under_ccf_amt() {
		return r144_cbs_100_under_ccf_amt;
	}
	public void setR144_cbs_100_under_ccf_amt(BigDecimal r144_cbs_100_under_ccf_amt) {
		this.r144_cbs_100_under_ccf_amt = r144_cbs_100_under_ccf_amt;
	}
	public BigDecimal getR145_cbs_100_lcbg_balance() {
		return r145_cbs_100_lcbg_balance;
	}
	public void setR145_cbs_100_lcbg_balance(BigDecimal r145_cbs_100_lcbg_balance) {
		this.r145_cbs_100_lcbg_balance = r145_cbs_100_lcbg_balance;
	}
	public BigDecimal getR145_cbs_100_acceptance_amount() {
		return r145_cbs_100_acceptance_amount;
	}
	public void setR145_cbs_100_acceptance_amount(BigDecimal r145_cbs_100_acceptance_amount) {
		this.r145_cbs_100_acceptance_amount = r145_cbs_100_acceptance_amount;
	}
	public BigDecimal getR145_cbs_100_lcbg_crm() {
		return r145_cbs_100_lcbg_crm;
	}
	public void setR145_cbs_100_lcbg_crm(BigDecimal r145_cbs_100_lcbg_crm) {
		this.r145_cbs_100_lcbg_crm = r145_cbs_100_lcbg_crm;
	}
	public BigDecimal getR145_cbs_100_rwa() {
		return r145_cbs_100_rwa;
	}
	public void setR145_cbs_100_rwa(BigDecimal r145_cbs_100_rwa) {
		this.r145_cbs_100_rwa = r145_cbs_100_rwa;
	}
	public BigDecimal getR145_cbs_100_under_ccf_amt() {
		return r145_cbs_100_under_ccf_amt;
	}
	public void setR145_cbs_100_under_ccf_amt(BigDecimal r145_cbs_100_under_ccf_amt) {
		this.r145_cbs_100_under_ccf_amt = r145_cbs_100_under_ccf_amt;
	}
	public BigDecimal getR146_cbs_100_lcbg_balance() {
		return r146_cbs_100_lcbg_balance;
	}
	public void setR146_cbs_100_lcbg_balance(BigDecimal r146_cbs_100_lcbg_balance) {
		this.r146_cbs_100_lcbg_balance = r146_cbs_100_lcbg_balance;
	}
	public BigDecimal getR146_cbs_100_acceptance_amount() {
		return r146_cbs_100_acceptance_amount;
	}
	public void setR146_cbs_100_acceptance_amount(BigDecimal r146_cbs_100_acceptance_amount) {
		this.r146_cbs_100_acceptance_amount = r146_cbs_100_acceptance_amount;
	}
	public BigDecimal getR146_cbs_100_lcbg_crm() {
		return r146_cbs_100_lcbg_crm;
	}
	public void setR146_cbs_100_lcbg_crm(BigDecimal r146_cbs_100_lcbg_crm) {
		this.r146_cbs_100_lcbg_crm = r146_cbs_100_lcbg_crm;
	}
	public BigDecimal getR146_cbs_100_rwa() {
		return r146_cbs_100_rwa;
	}
	public void setR146_cbs_100_rwa(BigDecimal r146_cbs_100_rwa) {
		this.r146_cbs_100_rwa = r146_cbs_100_rwa;
	}
	public BigDecimal getR146_cbs_100_under_ccf_amt() {
		return r146_cbs_100_under_ccf_amt;
	}
	public void setR146_cbs_100_under_ccf_amt(BigDecimal r146_cbs_100_under_ccf_amt) {
		this.r146_cbs_100_under_ccf_amt = r146_cbs_100_under_ccf_amt;
	}
	public BigDecimal getR147_cbs_lcbg_balance() {
		return r147_cbs_lcbg_balance;
	}
	public void setR147_cbs_lcbg_balance(BigDecimal r147_cbs_lcbg_balance) {
		this.r147_cbs_lcbg_balance = r147_cbs_lcbg_balance;
	}
	public BigDecimal getR147_cbs_acceptance_amount() {
		return r147_cbs_acceptance_amount;
	}
	public void setR147_cbs_acceptance_amount(BigDecimal r147_cbs_acceptance_amount) {
		this.r147_cbs_acceptance_amount = r147_cbs_acceptance_amount;
	}
	public BigDecimal getR147_cbs_lcbg_crm() {
		return r147_cbs_lcbg_crm;
	}
	public void setR147_cbs_lcbg_crm(BigDecimal r147_cbs_lcbg_crm) {
		this.r147_cbs_lcbg_crm = r147_cbs_lcbg_crm;
	}
	public BigDecimal getR147_cbs_rwa() {
		return r147_cbs_rwa;
	}
	public void setR147_cbs_rwa(BigDecimal r147_cbs_rwa) {
		this.r147_cbs_rwa = r147_cbs_rwa;
	}
	public BigDecimal getR147_cbs_under_ccf_amt() {
		return r147_cbs_under_ccf_amt;
	}
	public void setR147_cbs_under_ccf_amt(BigDecimal r147_cbs_under_ccf_amt) {
		this.r147_cbs_under_ccf_amt = r147_cbs_under_ccf_amt;
	}
	public BigDecimal getR148_cbs_150_lcbg_balance() {
		return r148_cbs_150_lcbg_balance;
	}
	public void setR148_cbs_150_lcbg_balance(BigDecimal r148_cbs_150_lcbg_balance) {
		this.r148_cbs_150_lcbg_balance = r148_cbs_150_lcbg_balance;
	}
	public BigDecimal getR148_cbs_150_acceptance_amount() {
		return r148_cbs_150_acceptance_amount;
	}
	public void setR148_cbs_150_acceptance_amount(BigDecimal r148_cbs_150_acceptance_amount) {
		this.r148_cbs_150_acceptance_amount = r148_cbs_150_acceptance_amount;
	}
	public BigDecimal getR148_cbs_150_lcbg_crm() {
		return r148_cbs_150_lcbg_crm;
	}
	public void setR148_cbs_150_lcbg_crm(BigDecimal r148_cbs_150_lcbg_crm) {
		this.r148_cbs_150_lcbg_crm = r148_cbs_150_lcbg_crm;
	}
	public BigDecimal getR148_cbs_150_rwa() {
		return r148_cbs_150_rwa;
	}
	public void setR148_cbs_150_rwa(BigDecimal r148_cbs_150_rwa) {
		this.r148_cbs_150_rwa = r148_cbs_150_rwa;
	}
	public BigDecimal getR148_cbs_150_under_ccf_amt() {
		return r148_cbs_150_under_ccf_amt;
	}
	public void setR148_cbs_150_under_ccf_amt(BigDecimal r148_cbs_150_under_ccf_amt) {
		this.r148_cbs_150_under_ccf_amt = r148_cbs_150_under_ccf_amt;
	}
	public BigDecimal getR149_cbs_150_lcbg_balance() {
		return r149_cbs_150_lcbg_balance;
	}
	public void setR149_cbs_150_lcbg_balance(BigDecimal r149_cbs_150_lcbg_balance) {
		this.r149_cbs_150_lcbg_balance = r149_cbs_150_lcbg_balance;
	}
	public BigDecimal getR149_cbs_150_acceptance_amount() {
		return r149_cbs_150_acceptance_amount;
	}
	public void setR149_cbs_150_acceptance_amount(BigDecimal r149_cbs_150_acceptance_amount) {
		this.r149_cbs_150_acceptance_amount = r149_cbs_150_acceptance_amount;
	}
	public BigDecimal getR149_cbs_150_lcbg_crm() {
		return r149_cbs_150_lcbg_crm;
	}
	public void setR149_cbs_150_lcbg_crm(BigDecimal r149_cbs_150_lcbg_crm) {
		this.r149_cbs_150_lcbg_crm = r149_cbs_150_lcbg_crm;
	}
	public BigDecimal getR149_cbs_150_rwa() {
		return r149_cbs_150_rwa;
	}
	public void setR149_cbs_150_rwa(BigDecimal r149_cbs_150_rwa) {
		this.r149_cbs_150_rwa = r149_cbs_150_rwa;
	}
	public BigDecimal getR149_cbs_150_under_ccf_amt() {
		return r149_cbs_150_under_ccf_amt;
	}
	public void setR149_cbs_150_under_ccf_amt(BigDecimal r149_cbs_150_under_ccf_amt) {
		this.r149_cbs_150_under_ccf_amt = r149_cbs_150_under_ccf_amt;
	}
	public BigDecimal getR150_cbs_150_lcbg_balance() {
		return r150_cbs_150_lcbg_balance;
	}
	public void setR150_cbs_150_lcbg_balance(BigDecimal r150_cbs_150_lcbg_balance) {
		this.r150_cbs_150_lcbg_balance = r150_cbs_150_lcbg_balance;
	}
	public BigDecimal getR150_cbs_150_acceptance_amount() {
		return r150_cbs_150_acceptance_amount;
	}
	public void setR150_cbs_150_acceptance_amount(BigDecimal r150_cbs_150_acceptance_amount) {
		this.r150_cbs_150_acceptance_amount = r150_cbs_150_acceptance_amount;
	}
	public BigDecimal getR150_cbs_150_lcbg_crm() {
		return r150_cbs_150_lcbg_crm;
	}
	public void setR150_cbs_150_lcbg_crm(BigDecimal r150_cbs_150_lcbg_crm) {
		this.r150_cbs_150_lcbg_crm = r150_cbs_150_lcbg_crm;
	}
	public BigDecimal getR150_cbs_150_rwa() {
		return r150_cbs_150_rwa;
	}
	public void setR150_cbs_150_rwa(BigDecimal r150_cbs_150_rwa) {
		this.r150_cbs_150_rwa = r150_cbs_150_rwa;
	}
	public BigDecimal getR150_cbs_150_under_ccf_amt() {
		return r150_cbs_150_under_ccf_amt;
	}
	public void setR150_cbs_150_under_ccf_amt(BigDecimal r150_cbs_150_under_ccf_amt) {
		this.r150_cbs_150_under_ccf_amt = r150_cbs_150_under_ccf_amt;
	}
	public BigDecimal getR151_cbs_lcbg_balance() {
		return r151_cbs_lcbg_balance;
	}
	public void setR151_cbs_lcbg_balance(BigDecimal r151_cbs_lcbg_balance) {
		this.r151_cbs_lcbg_balance = r151_cbs_lcbg_balance;
	}
	public BigDecimal getR151_cbs_acceptance_amount() {
		return r151_cbs_acceptance_amount;
	}
	public void setR151_cbs_acceptance_amount(BigDecimal r151_cbs_acceptance_amount) {
		this.r151_cbs_acceptance_amount = r151_cbs_acceptance_amount;
	}
	public BigDecimal getR151_cbs_lcbg_crm() {
		return r151_cbs_lcbg_crm;
	}
	public void setR151_cbs_lcbg_crm(BigDecimal r151_cbs_lcbg_crm) {
		this.r151_cbs_lcbg_crm = r151_cbs_lcbg_crm;
	}
	public BigDecimal getR151_cbs_rwa() {
		return r151_cbs_rwa;
	}
	public void setR151_cbs_rwa(BigDecimal r151_cbs_rwa) {
		this.r151_cbs_rwa = r151_cbs_rwa;
	}
	public BigDecimal getR151_cbs_under_ccf_amt() {
		return r151_cbs_under_ccf_amt;
	}
	public void setR151_cbs_under_ccf_amt(BigDecimal r151_cbs_under_ccf_amt) {
		this.r151_cbs_under_ccf_amt = r151_cbs_under_ccf_amt;
	}
	public BigDecimal getR152_cre_0_lcbg_balance() {
		return r152_cre_0_lcbg_balance;
	}
	public void setR152_cre_0_lcbg_balance(BigDecimal r152_cre_0_lcbg_balance) {
		this.r152_cre_0_lcbg_balance = r152_cre_0_lcbg_balance;
	}
	public BigDecimal getR152_cre_0_acceptance_amount() {
		return r152_cre_0_acceptance_amount;
	}
	public void setR152_cre_0_acceptance_amount(BigDecimal r152_cre_0_acceptance_amount) {
		this.r152_cre_0_acceptance_amount = r152_cre_0_acceptance_amount;
	}
	public BigDecimal getR152_cre_0_lcbg_crm() {
		return r152_cre_0_lcbg_crm;
	}
	public void setR152_cre_0_lcbg_crm(BigDecimal r152_cre_0_lcbg_crm) {
		this.r152_cre_0_lcbg_crm = r152_cre_0_lcbg_crm;
	}
	public BigDecimal getR152_cre_0_rwa() {
		return r152_cre_0_rwa;
	}
	public void setR152_cre_0_rwa(BigDecimal r152_cre_0_rwa) {
		this.r152_cre_0_rwa = r152_cre_0_rwa;
	}
	public BigDecimal getR152_cre_0_under_ccf_amt() {
		return r152_cre_0_under_ccf_amt;
	}
	public void setR152_cre_0_under_ccf_amt(BigDecimal r152_cre_0_under_ccf_amt) {
		this.r152_cre_0_under_ccf_amt = r152_cre_0_under_ccf_amt;
	}
	public BigDecimal getR153_cre_0_lcbg_balance() {
		return r153_cre_0_lcbg_balance;
	}
	public void setR153_cre_0_lcbg_balance(BigDecimal r153_cre_0_lcbg_balance) {
		this.r153_cre_0_lcbg_balance = r153_cre_0_lcbg_balance;
	}
	public BigDecimal getR153_cre_0_acceptance_amount() {
		return r153_cre_0_acceptance_amount;
	}
	public void setR153_cre_0_acceptance_amount(BigDecimal r153_cre_0_acceptance_amount) {
		this.r153_cre_0_acceptance_amount = r153_cre_0_acceptance_amount;
	}
	public BigDecimal getR153_cre_0_lcbg_crm() {
		return r153_cre_0_lcbg_crm;
	}
	public void setR153_cre_0_lcbg_crm(BigDecimal r153_cre_0_lcbg_crm) {
		this.r153_cre_0_lcbg_crm = r153_cre_0_lcbg_crm;
	}
	public BigDecimal getR153_cre_0_rwa() {
		return r153_cre_0_rwa;
	}
	public void setR153_cre_0_rwa(BigDecimal r153_cre_0_rwa) {
		this.r153_cre_0_rwa = r153_cre_0_rwa;
	}
	public BigDecimal getR153_cre_0_under_ccf_amt() {
		return r153_cre_0_under_ccf_amt;
	}
	public void setR153_cre_0_under_ccf_amt(BigDecimal r153_cre_0_under_ccf_amt) {
		this.r153_cre_0_under_ccf_amt = r153_cre_0_under_ccf_amt;
	}
	public BigDecimal getR154_cre_0_lcbg_balance() {
		return r154_cre_0_lcbg_balance;
	}
	public void setR154_cre_0_lcbg_balance(BigDecimal r154_cre_0_lcbg_balance) {
		this.r154_cre_0_lcbg_balance = r154_cre_0_lcbg_balance;
	}
	public BigDecimal getR154_cre_0_acceptance_amount() {
		return r154_cre_0_acceptance_amount;
	}
	public void setR154_cre_0_acceptance_amount(BigDecimal r154_cre_0_acceptance_amount) {
		this.r154_cre_0_acceptance_amount = r154_cre_0_acceptance_amount;
	}
	public BigDecimal getR154_cre_0_lcbg_crm() {
		return r154_cre_0_lcbg_crm;
	}
	public void setR154_cre_0_lcbg_crm(BigDecimal r154_cre_0_lcbg_crm) {
		this.r154_cre_0_lcbg_crm = r154_cre_0_lcbg_crm;
	}
	public BigDecimal getR154_cre_0_rwa() {
		return r154_cre_0_rwa;
	}
	public void setR154_cre_0_rwa(BigDecimal r154_cre_0_rwa) {
		this.r154_cre_0_rwa = r154_cre_0_rwa;
	}
	public BigDecimal getR154_cre_0_under_ccf_amt() {
		return r154_cre_0_under_ccf_amt;
	}
	public void setR154_cre_0_under_ccf_amt(BigDecimal r154_cre_0_under_ccf_amt) {
		this.r154_cre_0_under_ccf_amt = r154_cre_0_under_ccf_amt;
	}
	public BigDecimal getR155_cre_lcbg_balance() {
		return r155_cre_lcbg_balance;
	}
	public void setR155_cre_lcbg_balance(BigDecimal r155_cre_lcbg_balance) {
		this.r155_cre_lcbg_balance = r155_cre_lcbg_balance;
	}
	public BigDecimal getR155_cre_acceptance_amount() {
		return r155_cre_acceptance_amount;
	}
	public void setR155_cre_acceptance_amount(BigDecimal r155_cre_acceptance_amount) {
		this.r155_cre_acceptance_amount = r155_cre_acceptance_amount;
	}
	public BigDecimal getR155_cre_lcbg_crm() {
		return r155_cre_lcbg_crm;
	}
	public void setR155_cre_lcbg_crm(BigDecimal r155_cre_lcbg_crm) {
		this.r155_cre_lcbg_crm = r155_cre_lcbg_crm;
	}
	public BigDecimal getR155_cre_rwa() {
		return r155_cre_rwa;
	}
	public void setR155_cre_rwa(BigDecimal r155_cre_rwa) {
		this.r155_cre_rwa = r155_cre_rwa;
	}
	public BigDecimal getR155_cre_under_ccf_amt() {
		return r155_cre_under_ccf_amt;
	}
	public void setR155_cre_under_ccf_amt(BigDecimal r155_cre_under_ccf_amt) {
		this.r155_cre_under_ccf_amt = r155_cre_under_ccf_amt;
	}
	public BigDecimal getR156_cre_20_lcbg_balance() {
		return r156_cre_20_lcbg_balance;
	}
	public void setR156_cre_20_lcbg_balance(BigDecimal r156_cre_20_lcbg_balance) {
		this.r156_cre_20_lcbg_balance = r156_cre_20_lcbg_balance;
	}
	public BigDecimal getR156_cre_20_acceptance_amount() {
		return r156_cre_20_acceptance_amount;
	}
	public void setR156_cre_20_acceptance_amount(BigDecimal r156_cre_20_acceptance_amount) {
		this.r156_cre_20_acceptance_amount = r156_cre_20_acceptance_amount;
	}
	public BigDecimal getR156_cre_20_lcbg_crm() {
		return r156_cre_20_lcbg_crm;
	}
	public void setR156_cre_20_lcbg_crm(BigDecimal r156_cre_20_lcbg_crm) {
		this.r156_cre_20_lcbg_crm = r156_cre_20_lcbg_crm;
	}
	public BigDecimal getR156_cre_20_rwa() {
		return r156_cre_20_rwa;
	}
	public void setR156_cre_20_rwa(BigDecimal r156_cre_20_rwa) {
		this.r156_cre_20_rwa = r156_cre_20_rwa;
	}
	public BigDecimal getR156_cre_20_under_ccf_amt() {
		return r156_cre_20_under_ccf_amt;
	}
	public void setR156_cre_20_under_ccf_amt(BigDecimal r156_cre_20_under_ccf_amt) {
		this.r156_cre_20_under_ccf_amt = r156_cre_20_under_ccf_amt;
	}
	public BigDecimal getR157_cre_20_lcbg_balance() {
		return r157_cre_20_lcbg_balance;
	}
	public void setR157_cre_20_lcbg_balance(BigDecimal r157_cre_20_lcbg_balance) {
		this.r157_cre_20_lcbg_balance = r157_cre_20_lcbg_balance;
	}
	public BigDecimal getR157_cre_20_acceptance_amount() {
		return r157_cre_20_acceptance_amount;
	}
	public void setR157_cre_20_acceptance_amount(BigDecimal r157_cre_20_acceptance_amount) {
		this.r157_cre_20_acceptance_amount = r157_cre_20_acceptance_amount;
	}
	public BigDecimal getR157_cre_20_lcbg_crm() {
		return r157_cre_20_lcbg_crm;
	}
	public void setR157_cre_20_lcbg_crm(BigDecimal r157_cre_20_lcbg_crm) {
		this.r157_cre_20_lcbg_crm = r157_cre_20_lcbg_crm;
	}
	public BigDecimal getR157_cre_20_rwa() {
		return r157_cre_20_rwa;
	}
	public void setR157_cre_20_rwa(BigDecimal r157_cre_20_rwa) {
		this.r157_cre_20_rwa = r157_cre_20_rwa;
	}
	public BigDecimal getR157_cre_20_under_ccf_amt() {
		return r157_cre_20_under_ccf_amt;
	}
	public void setR157_cre_20_under_ccf_amt(BigDecimal r157_cre_20_under_ccf_amt) {
		this.r157_cre_20_under_ccf_amt = r157_cre_20_under_ccf_amt;
	}
	public BigDecimal getR158_cre_20_lcbg_balance() {
		return r158_cre_20_lcbg_balance;
	}
	public void setR158_cre_20_lcbg_balance(BigDecimal r158_cre_20_lcbg_balance) {
		this.r158_cre_20_lcbg_balance = r158_cre_20_lcbg_balance;
	}
	public BigDecimal getR158_cre_20_acceptance_amount() {
		return r158_cre_20_acceptance_amount;
	}
	public void setR158_cre_20_acceptance_amount(BigDecimal r158_cre_20_acceptance_amount) {
		this.r158_cre_20_acceptance_amount = r158_cre_20_acceptance_amount;
	}
	public BigDecimal getR158_cre_20_lcbg_crm() {
		return r158_cre_20_lcbg_crm;
	}
	public void setR158_cre_20_lcbg_crm(BigDecimal r158_cre_20_lcbg_crm) {
		this.r158_cre_20_lcbg_crm = r158_cre_20_lcbg_crm;
	}
	public BigDecimal getR158_cre_20_rwa() {
		return r158_cre_20_rwa;
	}
	public void setR158_cre_20_rwa(BigDecimal r158_cre_20_rwa) {
		this.r158_cre_20_rwa = r158_cre_20_rwa;
	}
	public BigDecimal getR158_cre_20_under_ccf_amt() {
		return r158_cre_20_under_ccf_amt;
	}
	public void setR158_cre_20_under_ccf_amt(BigDecimal r158_cre_20_under_ccf_amt) {
		this.r158_cre_20_under_ccf_amt = r158_cre_20_under_ccf_amt;
	}
	public BigDecimal getR159_cre_lcbg_balance() {
		return r159_cre_lcbg_balance;
	}
	public void setR159_cre_lcbg_balance(BigDecimal r159_cre_lcbg_balance) {
		this.r159_cre_lcbg_balance = r159_cre_lcbg_balance;
	}
	public BigDecimal getR159_cre_acceptance_amount() {
		return r159_cre_acceptance_amount;
	}
	public void setR159_cre_acceptance_amount(BigDecimal r159_cre_acceptance_amount) {
		this.r159_cre_acceptance_amount = r159_cre_acceptance_amount;
	}
	public BigDecimal getR159_cre_lcbg_crm() {
		return r159_cre_lcbg_crm;
	}
	public void setR159_cre_lcbg_crm(BigDecimal r159_cre_lcbg_crm) {
		this.r159_cre_lcbg_crm = r159_cre_lcbg_crm;
	}
	public BigDecimal getR159_cre_rwa() {
		return r159_cre_rwa;
	}
	public void setR159_cre_rwa(BigDecimal r159_cre_rwa) {
		this.r159_cre_rwa = r159_cre_rwa;
	}
	public BigDecimal getR159_cre_under_ccf_amt() {
		return r159_cre_under_ccf_amt;
	}
	public void setR159_cre_under_ccf_amt(BigDecimal r159_cre_under_ccf_amt) {
		this.r159_cre_under_ccf_amt = r159_cre_under_ccf_amt;
	}
	public BigDecimal getR160_cre_50_lcbg_balance() {
		return r160_cre_50_lcbg_balance;
	}
	public void setR160_cre_50_lcbg_balance(BigDecimal r160_cre_50_lcbg_balance) {
		this.r160_cre_50_lcbg_balance = r160_cre_50_lcbg_balance;
	}
	public BigDecimal getR160_cre_50_acceptance_amount() {
		return r160_cre_50_acceptance_amount;
	}
	public void setR160_cre_50_acceptance_amount(BigDecimal r160_cre_50_acceptance_amount) {
		this.r160_cre_50_acceptance_amount = r160_cre_50_acceptance_amount;
	}
	public BigDecimal getR160_cre_50_lcbg_crm() {
		return r160_cre_50_lcbg_crm;
	}
	public void setR160_cre_50_lcbg_crm(BigDecimal r160_cre_50_lcbg_crm) {
		this.r160_cre_50_lcbg_crm = r160_cre_50_lcbg_crm;
	}
	public BigDecimal getR160_cre_50_rwa() {
		return r160_cre_50_rwa;
	}
	public void setR160_cre_50_rwa(BigDecimal r160_cre_50_rwa) {
		this.r160_cre_50_rwa = r160_cre_50_rwa;
	}
	public BigDecimal getR160_cre_50_under_ccf_amt() {
		return r160_cre_50_under_ccf_amt;
	}
	public void setR160_cre_50_under_ccf_amt(BigDecimal r160_cre_50_under_ccf_amt) {
		this.r160_cre_50_under_ccf_amt = r160_cre_50_under_ccf_amt;
	}
	public BigDecimal getR161_cre_50_lcbg_balance() {
		return r161_cre_50_lcbg_balance;
	}
	public void setR161_cre_50_lcbg_balance(BigDecimal r161_cre_50_lcbg_balance) {
		this.r161_cre_50_lcbg_balance = r161_cre_50_lcbg_balance;
	}
	public BigDecimal getR161_cre_50_acceptance_amount() {
		return r161_cre_50_acceptance_amount;
	}
	public void setR161_cre_50_acceptance_amount(BigDecimal r161_cre_50_acceptance_amount) {
		this.r161_cre_50_acceptance_amount = r161_cre_50_acceptance_amount;
	}
	public BigDecimal getR161_cre_50_lcbg_crm() {
		return r161_cre_50_lcbg_crm;
	}
	public void setR161_cre_50_lcbg_crm(BigDecimal r161_cre_50_lcbg_crm) {
		this.r161_cre_50_lcbg_crm = r161_cre_50_lcbg_crm;
	}
	public BigDecimal getR161_cre_50_rwa() {
		return r161_cre_50_rwa;
	}
	public void setR161_cre_50_rwa(BigDecimal r161_cre_50_rwa) {
		this.r161_cre_50_rwa = r161_cre_50_rwa;
	}
	public BigDecimal getR161_cre_50_under_ccf_amt() {
		return r161_cre_50_under_ccf_amt;
	}
	public void setR161_cre_50_under_ccf_amt(BigDecimal r161_cre_50_under_ccf_amt) {
		this.r161_cre_50_under_ccf_amt = r161_cre_50_under_ccf_amt;
	}
	public BigDecimal getR162_cre_50_lcbg_balance() {
		return r162_cre_50_lcbg_balance;
	}
	public void setR162_cre_50_lcbg_balance(BigDecimal r162_cre_50_lcbg_balance) {
		this.r162_cre_50_lcbg_balance = r162_cre_50_lcbg_balance;
	}
	public BigDecimal getR162_cre_50_acceptance_amount() {
		return r162_cre_50_acceptance_amount;
	}
	public void setR162_cre_50_acceptance_amount(BigDecimal r162_cre_50_acceptance_amount) {
		this.r162_cre_50_acceptance_amount = r162_cre_50_acceptance_amount;
	}
	public BigDecimal getR162_cre_50_lcbg_crm() {
		return r162_cre_50_lcbg_crm;
	}
	public void setR162_cre_50_lcbg_crm(BigDecimal r162_cre_50_lcbg_crm) {
		this.r162_cre_50_lcbg_crm = r162_cre_50_lcbg_crm;
	}
	public BigDecimal getR162_cre_50_rwa() {
		return r162_cre_50_rwa;
	}
	public void setR162_cre_50_rwa(BigDecimal r162_cre_50_rwa) {
		this.r162_cre_50_rwa = r162_cre_50_rwa;
	}
	public BigDecimal getR162_cre_50_under_ccf_amt() {
		return r162_cre_50_under_ccf_amt;
	}
	public void setR162_cre_50_under_ccf_amt(BigDecimal r162_cre_50_under_ccf_amt) {
		this.r162_cre_50_under_ccf_amt = r162_cre_50_under_ccf_amt;
	}
	public BigDecimal getR163_cre_lcbg_balance() {
		return r163_cre_lcbg_balance;
	}
	public void setR163_cre_lcbg_balance(BigDecimal r163_cre_lcbg_balance) {
		this.r163_cre_lcbg_balance = r163_cre_lcbg_balance;
	}
	public BigDecimal getR163_cre_acceptance_amount() {
		return r163_cre_acceptance_amount;
	}
	public void setR163_cre_acceptance_amount(BigDecimal r163_cre_acceptance_amount) {
		this.r163_cre_acceptance_amount = r163_cre_acceptance_amount;
	}
	public BigDecimal getR163_cre_lcbg_crm() {
		return r163_cre_lcbg_crm;
	}
	public void setR163_cre_lcbg_crm(BigDecimal r163_cre_lcbg_crm) {
		this.r163_cre_lcbg_crm = r163_cre_lcbg_crm;
	}
	public BigDecimal getR163_cre_rwa() {
		return r163_cre_rwa;
	}
	public void setR163_cre_rwa(BigDecimal r163_cre_rwa) {
		this.r163_cre_rwa = r163_cre_rwa;
	}
	public BigDecimal getR163_cre_under_ccf_amt() {
		return r163_cre_under_ccf_amt;
	}
	public void setR163_cre_under_ccf_amt(BigDecimal r163_cre_under_ccf_amt) {
		this.r163_cre_under_ccf_amt = r163_cre_under_ccf_amt;
	}
	public BigDecimal getR164_cre_100_lcbg_balance() {
		return r164_cre_100_lcbg_balance;
	}
	public void setR164_cre_100_lcbg_balance(BigDecimal r164_cre_100_lcbg_balance) {
		this.r164_cre_100_lcbg_balance = r164_cre_100_lcbg_balance;
	}
	public BigDecimal getR164_cre_100_acceptance_amount() {
		return r164_cre_100_acceptance_amount;
	}
	public void setR164_cre_100_acceptance_amount(BigDecimal r164_cre_100_acceptance_amount) {
		this.r164_cre_100_acceptance_amount = r164_cre_100_acceptance_amount;
	}
	public BigDecimal getR164_cre_100_lcbg_crm() {
		return r164_cre_100_lcbg_crm;
	}
	public void setR164_cre_100_lcbg_crm(BigDecimal r164_cre_100_lcbg_crm) {
		this.r164_cre_100_lcbg_crm = r164_cre_100_lcbg_crm;
	}
	public BigDecimal getR164_cre_100_rwa() {
		return r164_cre_100_rwa;
	}
	public void setR164_cre_100_rwa(BigDecimal r164_cre_100_rwa) {
		this.r164_cre_100_rwa = r164_cre_100_rwa;
	}
	public BigDecimal getR164_cre_100_under_ccf_amt() {
		return r164_cre_100_under_ccf_amt;
	}
	public void setR164_cre_100_under_ccf_amt(BigDecimal r164_cre_100_under_ccf_amt) {
		this.r164_cre_100_under_ccf_amt = r164_cre_100_under_ccf_amt;
	}
	public BigDecimal getR165_cre_100_lcbg_balance() {
		return r165_cre_100_lcbg_balance;
	}
	public void setR165_cre_100_lcbg_balance(BigDecimal r165_cre_100_lcbg_balance) {
		this.r165_cre_100_lcbg_balance = r165_cre_100_lcbg_balance;
	}
	public BigDecimal getR165_cre_100_acceptance_amount() {
		return r165_cre_100_acceptance_amount;
	}
	public void setR165_cre_100_acceptance_amount(BigDecimal r165_cre_100_acceptance_amount) {
		this.r165_cre_100_acceptance_amount = r165_cre_100_acceptance_amount;
	}
	public BigDecimal getR165_cre_100_lcbg_crm() {
		return r165_cre_100_lcbg_crm;
	}
	public void setR165_cre_100_lcbg_crm(BigDecimal r165_cre_100_lcbg_crm) {
		this.r165_cre_100_lcbg_crm = r165_cre_100_lcbg_crm;
	}
	public BigDecimal getR165_cre_100_rwa() {
		return r165_cre_100_rwa;
	}
	public void setR165_cre_100_rwa(BigDecimal r165_cre_100_rwa) {
		this.r165_cre_100_rwa = r165_cre_100_rwa;
	}
	public BigDecimal getR165_cre_100_under_ccf_amt() {
		return r165_cre_100_under_ccf_amt;
	}
	public void setR165_cre_100_under_ccf_amt(BigDecimal r165_cre_100_under_ccf_amt) {
		this.r165_cre_100_under_ccf_amt = r165_cre_100_under_ccf_amt;
	}
	public BigDecimal getR166_cre_100_lcbg_balance() {
		return r166_cre_100_lcbg_balance;
	}
	public void setR166_cre_100_lcbg_balance(BigDecimal r166_cre_100_lcbg_balance) {
		this.r166_cre_100_lcbg_balance = r166_cre_100_lcbg_balance;
	}
	public BigDecimal getR166_cre_100_acceptance_amount() {
		return r166_cre_100_acceptance_amount;
	}
	public void setR166_cre_100_acceptance_amount(BigDecimal r166_cre_100_acceptance_amount) {
		this.r166_cre_100_acceptance_amount = r166_cre_100_acceptance_amount;
	}
	public BigDecimal getR166_cre_100_lcbg_crm() {
		return r166_cre_100_lcbg_crm;
	}
	public void setR166_cre_100_lcbg_crm(BigDecimal r166_cre_100_lcbg_crm) {
		this.r166_cre_100_lcbg_crm = r166_cre_100_lcbg_crm;
	}
	public BigDecimal getR166_cre_100_rwa() {
		return r166_cre_100_rwa;
	}
	public void setR166_cre_100_rwa(BigDecimal r166_cre_100_rwa) {
		this.r166_cre_100_rwa = r166_cre_100_rwa;
	}
	public BigDecimal getR166_cre_100_under_ccf_amt() {
		return r166_cre_100_under_ccf_amt;
	}
	public void setR166_cre_100_under_ccf_amt(BigDecimal r166_cre_100_under_ccf_amt) {
		this.r166_cre_100_under_ccf_amt = r166_cre_100_under_ccf_amt;
	}
	public BigDecimal getR167_cre_lcbg_balance() {
		return r167_cre_lcbg_balance;
	}
	public void setR167_cre_lcbg_balance(BigDecimal r167_cre_lcbg_balance) {
		this.r167_cre_lcbg_balance = r167_cre_lcbg_balance;
	}
	public BigDecimal getR167_cre_acceptance_amount() {
		return r167_cre_acceptance_amount;
	}
	public void setR167_cre_acceptance_amount(BigDecimal r167_cre_acceptance_amount) {
		this.r167_cre_acceptance_amount = r167_cre_acceptance_amount;
	}
	public BigDecimal getR167_cre_lcbg_crm() {
		return r167_cre_lcbg_crm;
	}
	public void setR167_cre_lcbg_crm(BigDecimal r167_cre_lcbg_crm) {
		this.r167_cre_lcbg_crm = r167_cre_lcbg_crm;
	}
	public BigDecimal getR167_cre_rwa() {
		return r167_cre_rwa;
	}
	public void setR167_cre_rwa(BigDecimal r167_cre_rwa) {
		this.r167_cre_rwa = r167_cre_rwa;
	}
	public BigDecimal getR167_cre_under_ccf_amt() {
		return r167_cre_under_ccf_amt;
	}
	public void setR167_cre_under_ccf_amt(BigDecimal r167_cre_under_ccf_amt) {
		this.r167_cre_under_ccf_amt = r167_cre_under_ccf_amt;
	}
	public BigDecimal getR168_cre_150_lcbg_balance() {
		return r168_cre_150_lcbg_balance;
	}
	public void setR168_cre_150_lcbg_balance(BigDecimal r168_cre_150_lcbg_balance) {
		this.r168_cre_150_lcbg_balance = r168_cre_150_lcbg_balance;
	}
	public BigDecimal getR168_cre_150_acceptance_amount() {
		return r168_cre_150_acceptance_amount;
	}
	public void setR168_cre_150_acceptance_amount(BigDecimal r168_cre_150_acceptance_amount) {
		this.r168_cre_150_acceptance_amount = r168_cre_150_acceptance_amount;
	}
	public BigDecimal getR168_cre_150_lcbg_crm() {
		return r168_cre_150_lcbg_crm;
	}
	public void setR168_cre_150_lcbg_crm(BigDecimal r168_cre_150_lcbg_crm) {
		this.r168_cre_150_lcbg_crm = r168_cre_150_lcbg_crm;
	}
	public BigDecimal getR168_cre_150_rwa() {
		return r168_cre_150_rwa;
	}
	public void setR168_cre_150_rwa(BigDecimal r168_cre_150_rwa) {
		this.r168_cre_150_rwa = r168_cre_150_rwa;
	}
	public BigDecimal getR168_cre_150_under_ccf_amt() {
		return r168_cre_150_under_ccf_amt;
	}
	public void setR168_cre_150_under_ccf_amt(BigDecimal r168_cre_150_under_ccf_amt) {
		this.r168_cre_150_under_ccf_amt = r168_cre_150_under_ccf_amt;
	}
	public BigDecimal getR169_cre_150_lcbg_balance() {
		return r169_cre_150_lcbg_balance;
	}
	public void setR169_cre_150_lcbg_balance(BigDecimal r169_cre_150_lcbg_balance) {
		this.r169_cre_150_lcbg_balance = r169_cre_150_lcbg_balance;
	}
	public BigDecimal getR169_cre_150_acceptance_amount() {
		return r169_cre_150_acceptance_amount;
	}
	public void setR169_cre_150_acceptance_amount(BigDecimal r169_cre_150_acceptance_amount) {
		this.r169_cre_150_acceptance_amount = r169_cre_150_acceptance_amount;
	}
	public BigDecimal getR169_cre_150_lcbg_crm() {
		return r169_cre_150_lcbg_crm;
	}
	public void setR169_cre_150_lcbg_crm(BigDecimal r169_cre_150_lcbg_crm) {
		this.r169_cre_150_lcbg_crm = r169_cre_150_lcbg_crm;
	}
	public BigDecimal getR169_cre_150_rwa() {
		return r169_cre_150_rwa;
	}
	public void setR169_cre_150_rwa(BigDecimal r169_cre_150_rwa) {
		this.r169_cre_150_rwa = r169_cre_150_rwa;
	}
	public BigDecimal getR169_cre_150_under_ccf_amt() {
		return r169_cre_150_under_ccf_amt;
	}
	public void setR169_cre_150_under_ccf_amt(BigDecimal r169_cre_150_under_ccf_amt) {
		this.r169_cre_150_under_ccf_amt = r169_cre_150_under_ccf_amt;
	}
	public BigDecimal getR170_cre_150_lcbg_balance() {
		return r170_cre_150_lcbg_balance;
	}
	public void setR170_cre_150_lcbg_balance(BigDecimal r170_cre_150_lcbg_balance) {
		this.r170_cre_150_lcbg_balance = r170_cre_150_lcbg_balance;
	}
	public BigDecimal getR170_cre_150_acceptance_amount() {
		return r170_cre_150_acceptance_amount;
	}
	public void setR170_cre_150_acceptance_amount(BigDecimal r170_cre_150_acceptance_amount) {
		this.r170_cre_150_acceptance_amount = r170_cre_150_acceptance_amount;
	}
	public BigDecimal getR170_cre_150_lcbg_crm() {
		return r170_cre_150_lcbg_crm;
	}
	public void setR170_cre_150_lcbg_crm(BigDecimal r170_cre_150_lcbg_crm) {
		this.r170_cre_150_lcbg_crm = r170_cre_150_lcbg_crm;
	}
	public BigDecimal getR170_cre_150_rwa() {
		return r170_cre_150_rwa;
	}
	public void setR170_cre_150_rwa(BigDecimal r170_cre_150_rwa) {
		this.r170_cre_150_rwa = r170_cre_150_rwa;
	}
	public BigDecimal getR170_cre_150_under_ccf_amt() {
		return r170_cre_150_under_ccf_amt;
	}
	public void setR170_cre_150_under_ccf_amt(BigDecimal r170_cre_150_under_ccf_amt) {
		this.r170_cre_150_under_ccf_amt = r170_cre_150_under_ccf_amt;
	}
	public BigDecimal getR171_cre_lcbg_balance() {
		return r171_cre_lcbg_balance;
	}
	public void setR171_cre_lcbg_balance(BigDecimal r171_cre_lcbg_balance) {
		this.r171_cre_lcbg_balance = r171_cre_lcbg_balance;
	}
	public BigDecimal getR171_cre_acceptance_amount() {
		return r171_cre_acceptance_amount;
	}
	public void setR171_cre_acceptance_amount(BigDecimal r171_cre_acceptance_amount) {
		this.r171_cre_acceptance_amount = r171_cre_acceptance_amount;
	}
	public BigDecimal getR171_cre_lcbg_crm() {
		return r171_cre_lcbg_crm;
	}
	public void setR171_cre_lcbg_crm(BigDecimal r171_cre_lcbg_crm) {
		this.r171_cre_lcbg_crm = r171_cre_lcbg_crm;
	}
	public BigDecimal getR171_cre_rwa() {
		return r171_cre_rwa;
	}
	public void setR171_cre_rwa(BigDecimal r171_cre_rwa) {
		this.r171_cre_rwa = r171_cre_rwa;
	}
	public BigDecimal getR171_cre_under_ccf_amt() {
		return r171_cre_under_ccf_amt;
	}
	public void setR171_cre_under_ccf_amt(BigDecimal r171_cre_under_ccf_amt) {
		this.r171_cre_under_ccf_amt = r171_cre_under_ccf_amt;
	}
	public BigDecimal getR172_crt_0_lcbg_balance() {
		return r172_crt_0_lcbg_balance;
	}
	public void setR172_crt_0_lcbg_balance(BigDecimal r172_crt_0_lcbg_balance) {
		this.r172_crt_0_lcbg_balance = r172_crt_0_lcbg_balance;
	}
	public BigDecimal getR172_crt_0_acceptance_amount() {
		return r172_crt_0_acceptance_amount;
	}
	public void setR172_crt_0_acceptance_amount(BigDecimal r172_crt_0_acceptance_amount) {
		this.r172_crt_0_acceptance_amount = r172_crt_0_acceptance_amount;
	}
	public BigDecimal getR172_crt_0_lcbg_crm() {
		return r172_crt_0_lcbg_crm;
	}
	public void setR172_crt_0_lcbg_crm(BigDecimal r172_crt_0_lcbg_crm) {
		this.r172_crt_0_lcbg_crm = r172_crt_0_lcbg_crm;
	}
	public BigDecimal getR172_crt_0_rwa() {
		return r172_crt_0_rwa;
	}
	public void setR172_crt_0_rwa(BigDecimal r172_crt_0_rwa) {
		this.r172_crt_0_rwa = r172_crt_0_rwa;
	}
	public BigDecimal getR172_crt_0_under_ccf_amt() {
		return r172_crt_0_under_ccf_amt;
	}
	public void setR172_crt_0_under_ccf_amt(BigDecimal r172_crt_0_under_ccf_amt) {
		this.r172_crt_0_under_ccf_amt = r172_crt_0_under_ccf_amt;
	}
	public BigDecimal getR173_crt_0_lcbg_balance() {
		return r173_crt_0_lcbg_balance;
	}
	public void setR173_crt_0_lcbg_balance(BigDecimal r173_crt_0_lcbg_balance) {
		this.r173_crt_0_lcbg_balance = r173_crt_0_lcbg_balance;
	}
	public BigDecimal getR173_crt_0_acceptance_amount() {
		return r173_crt_0_acceptance_amount;
	}
	public void setR173_crt_0_acceptance_amount(BigDecimal r173_crt_0_acceptance_amount) {
		this.r173_crt_0_acceptance_amount = r173_crt_0_acceptance_amount;
	}
	public BigDecimal getR173_crt_0_lcbg_crm() {
		return r173_crt_0_lcbg_crm;
	}
	public void setR173_crt_0_lcbg_crm(BigDecimal r173_crt_0_lcbg_crm) {
		this.r173_crt_0_lcbg_crm = r173_crt_0_lcbg_crm;
	}
	public BigDecimal getR173_crt_0_rwa() {
		return r173_crt_0_rwa;
	}
	public void setR173_crt_0_rwa(BigDecimal r173_crt_0_rwa) {
		this.r173_crt_0_rwa = r173_crt_0_rwa;
	}
	public BigDecimal getR173_crt_0_under_ccf_amt() {
		return r173_crt_0_under_ccf_amt;
	}
	public void setR173_crt_0_under_ccf_amt(BigDecimal r173_crt_0_under_ccf_amt) {
		this.r173_crt_0_under_ccf_amt = r173_crt_0_under_ccf_amt;
	}
	public BigDecimal getR174_crt_0_lcbg_balance() {
		return r174_crt_0_lcbg_balance;
	}
	public void setR174_crt_0_lcbg_balance(BigDecimal r174_crt_0_lcbg_balance) {
		this.r174_crt_0_lcbg_balance = r174_crt_0_lcbg_balance;
	}
	public BigDecimal getR174_crt_0_acceptance_amount() {
		return r174_crt_0_acceptance_amount;
	}
	public void setR174_crt_0_acceptance_amount(BigDecimal r174_crt_0_acceptance_amount) {
		this.r174_crt_0_acceptance_amount = r174_crt_0_acceptance_amount;
	}
	public BigDecimal getR174_crt_0_lcbg_crm() {
		return r174_crt_0_lcbg_crm;
	}
	public void setR174_crt_0_lcbg_crm(BigDecimal r174_crt_0_lcbg_crm) {
		this.r174_crt_0_lcbg_crm = r174_crt_0_lcbg_crm;
	}
	public BigDecimal getR174_crt_0_rwa() {
		return r174_crt_0_rwa;
	}
	public void setR174_crt_0_rwa(BigDecimal r174_crt_0_rwa) {
		this.r174_crt_0_rwa = r174_crt_0_rwa;
	}
	public BigDecimal getR174_crt_0_under_ccf_amt() {
		return r174_crt_0_under_ccf_amt;
	}
	public void setR174_crt_0_under_ccf_amt(BigDecimal r174_crt_0_under_ccf_amt) {
		this.r174_crt_0_under_ccf_amt = r174_crt_0_under_ccf_amt;
	}
	public BigDecimal getR175_crt_lcbg_balance() {
		return r175_crt_lcbg_balance;
	}
	public void setR175_crt_lcbg_balance(BigDecimal r175_crt_lcbg_balance) {
		this.r175_crt_lcbg_balance = r175_crt_lcbg_balance;
	}
	public BigDecimal getR175_crt_acceptance_amount() {
		return r175_crt_acceptance_amount;
	}
	public void setR175_crt_acceptance_amount(BigDecimal r175_crt_acceptance_amount) {
		this.r175_crt_acceptance_amount = r175_crt_acceptance_amount;
	}
	public BigDecimal getR175_crt_lcbg_crm() {
		return r175_crt_lcbg_crm;
	}
	public void setR175_crt_lcbg_crm(BigDecimal r175_crt_lcbg_crm) {
		this.r175_crt_lcbg_crm = r175_crt_lcbg_crm;
	}
	public BigDecimal getR175_crt_rwa() {
		return r175_crt_rwa;
	}
	public void setR175_crt_rwa(BigDecimal r175_crt_rwa) {
		this.r175_crt_rwa = r175_crt_rwa;
	}
	public BigDecimal getR175_crt_under_ccf_amt() {
		return r175_crt_under_ccf_amt;
	}
	public void setR175_crt_under_ccf_amt(BigDecimal r175_crt_under_ccf_amt) {
		this.r175_crt_under_ccf_amt = r175_crt_under_ccf_amt;
	}
	public BigDecimal getR176_crt_20_lcbg_balance() {
		return r176_crt_20_lcbg_balance;
	}
	public void setR176_crt_20_lcbg_balance(BigDecimal r176_crt_20_lcbg_balance) {
		this.r176_crt_20_lcbg_balance = r176_crt_20_lcbg_balance;
	}
	public BigDecimal getR176_crt_20_acceptance_amount() {
		return r176_crt_20_acceptance_amount;
	}
	public void setR176_crt_20_acceptance_amount(BigDecimal r176_crt_20_acceptance_amount) {
		this.r176_crt_20_acceptance_amount = r176_crt_20_acceptance_amount;
	}
	public BigDecimal getR176_crt_20_lcbg_crm() {
		return r176_crt_20_lcbg_crm;
	}
	public void setR176_crt_20_lcbg_crm(BigDecimal r176_crt_20_lcbg_crm) {
		this.r176_crt_20_lcbg_crm = r176_crt_20_lcbg_crm;
	}
	public BigDecimal getR176_crt_20_rwa() {
		return r176_crt_20_rwa;
	}
	public void setR176_crt_20_rwa(BigDecimal r176_crt_20_rwa) {
		this.r176_crt_20_rwa = r176_crt_20_rwa;
	}
	public BigDecimal getR176_crt_20_under_ccf_amt() {
		return r176_crt_20_under_ccf_amt;
	}
	public void setR176_crt_20_under_ccf_amt(BigDecimal r176_crt_20_under_ccf_amt) {
		this.r176_crt_20_under_ccf_amt = r176_crt_20_under_ccf_amt;
	}
	public BigDecimal getR177_crt_20_lcbg_balance() {
		return r177_crt_20_lcbg_balance;
	}
	public void setR177_crt_20_lcbg_balance(BigDecimal r177_crt_20_lcbg_balance) {
		this.r177_crt_20_lcbg_balance = r177_crt_20_lcbg_balance;
	}
	public BigDecimal getR177_crt_20_acceptance_amount() {
		return r177_crt_20_acceptance_amount;
	}
	public void setR177_crt_20_acceptance_amount(BigDecimal r177_crt_20_acceptance_amount) {
		this.r177_crt_20_acceptance_amount = r177_crt_20_acceptance_amount;
	}
	public BigDecimal getR177_crt_20_lcbg_crm() {
		return r177_crt_20_lcbg_crm;
	}
	public void setR177_crt_20_lcbg_crm(BigDecimal r177_crt_20_lcbg_crm) {
		this.r177_crt_20_lcbg_crm = r177_crt_20_lcbg_crm;
	}
	public BigDecimal getR177_crt_20_rwa() {
		return r177_crt_20_rwa;
	}
	public void setR177_crt_20_rwa(BigDecimal r177_crt_20_rwa) {
		this.r177_crt_20_rwa = r177_crt_20_rwa;
	}
	public BigDecimal getR177_crt_20_under_ccf_amt() {
		return r177_crt_20_under_ccf_amt;
	}
	public void setR177_crt_20_under_ccf_amt(BigDecimal r177_crt_20_under_ccf_amt) {
		this.r177_crt_20_under_ccf_amt = r177_crt_20_under_ccf_amt;
	}
	public BigDecimal getR178_crt_20_lcbg_balance() {
		return r178_crt_20_lcbg_balance;
	}
	public void setR178_crt_20_lcbg_balance(BigDecimal r178_crt_20_lcbg_balance) {
		this.r178_crt_20_lcbg_balance = r178_crt_20_lcbg_balance;
	}
	public BigDecimal getR178_crt_20_acceptance_amount() {
		return r178_crt_20_acceptance_amount;
	}
	public void setR178_crt_20_acceptance_amount(BigDecimal r178_crt_20_acceptance_amount) {
		this.r178_crt_20_acceptance_amount = r178_crt_20_acceptance_amount;
	}
	public BigDecimal getR178_crt_20_lcbg_crm() {
		return r178_crt_20_lcbg_crm;
	}
	public void setR178_crt_20_lcbg_crm(BigDecimal r178_crt_20_lcbg_crm) {
		this.r178_crt_20_lcbg_crm = r178_crt_20_lcbg_crm;
	}
	public BigDecimal getR178_crt_20_rwa() {
		return r178_crt_20_rwa;
	}
	public void setR178_crt_20_rwa(BigDecimal r178_crt_20_rwa) {
		this.r178_crt_20_rwa = r178_crt_20_rwa;
	}
	public BigDecimal getR178_crt_20_under_ccf_amt() {
		return r178_crt_20_under_ccf_amt;
	}
	public void setR178_crt_20_under_ccf_amt(BigDecimal r178_crt_20_under_ccf_amt) {
		this.r178_crt_20_under_ccf_amt = r178_crt_20_under_ccf_amt;
	}
	public BigDecimal getR179_crt_lcbg_balance() {
		return r179_crt_lcbg_balance;
	}
	public void setR179_crt_lcbg_balance(BigDecimal r179_crt_lcbg_balance) {
		this.r179_crt_lcbg_balance = r179_crt_lcbg_balance;
	}
	public BigDecimal getR179_crt_acceptance_amount() {
		return r179_crt_acceptance_amount;
	}
	public void setR179_crt_acceptance_amount(BigDecimal r179_crt_acceptance_amount) {
		this.r179_crt_acceptance_amount = r179_crt_acceptance_amount;
	}
	public BigDecimal getR179_crt_lcbg_crm() {
		return r179_crt_lcbg_crm;
	}
	public void setR179_crt_lcbg_crm(BigDecimal r179_crt_lcbg_crm) {
		this.r179_crt_lcbg_crm = r179_crt_lcbg_crm;
	}
	public BigDecimal getR179_crt_rwa() {
		return r179_crt_rwa;
	}
	public void setR179_crt_rwa(BigDecimal r179_crt_rwa) {
		this.r179_crt_rwa = r179_crt_rwa;
	}
	public BigDecimal getR179_crt_under_ccf_amt() {
		return r179_crt_under_ccf_amt;
	}
	public void setR179_crt_under_ccf_amt(BigDecimal r179_crt_under_ccf_amt) {
		this.r179_crt_under_ccf_amt = r179_crt_under_ccf_amt;
	}
	public BigDecimal getR180_crt_50_lcbg_balance() {
		return r180_crt_50_lcbg_balance;
	}
	public void setR180_crt_50_lcbg_balance(BigDecimal r180_crt_50_lcbg_balance) {
		this.r180_crt_50_lcbg_balance = r180_crt_50_lcbg_balance;
	}
	public BigDecimal getR180_crt_50_acceptance_amount() {
		return r180_crt_50_acceptance_amount;
	}
	public void setR180_crt_50_acceptance_amount(BigDecimal r180_crt_50_acceptance_amount) {
		this.r180_crt_50_acceptance_amount = r180_crt_50_acceptance_amount;
	}
	public BigDecimal getR180_crt_50_lcbg_crm() {
		return r180_crt_50_lcbg_crm;
	}
	public void setR180_crt_50_lcbg_crm(BigDecimal r180_crt_50_lcbg_crm) {
		this.r180_crt_50_lcbg_crm = r180_crt_50_lcbg_crm;
	}
	public BigDecimal getR180_crt_50_rwa() {
		return r180_crt_50_rwa;
	}
	public void setR180_crt_50_rwa(BigDecimal r180_crt_50_rwa) {
		this.r180_crt_50_rwa = r180_crt_50_rwa;
	}
	public BigDecimal getR180_crt_50_under_ccf_amt() {
		return r180_crt_50_under_ccf_amt;
	}
	public void setR180_crt_50_under_ccf_amt(BigDecimal r180_crt_50_under_ccf_amt) {
		this.r180_crt_50_under_ccf_amt = r180_crt_50_under_ccf_amt;
	}
	public BigDecimal getR181_crt_50_lcbg_balance() {
		return r181_crt_50_lcbg_balance;
	}
	public void setR181_crt_50_lcbg_balance(BigDecimal r181_crt_50_lcbg_balance) {
		this.r181_crt_50_lcbg_balance = r181_crt_50_lcbg_balance;
	}
	public BigDecimal getR181_crt_50_acceptance_amount() {
		return r181_crt_50_acceptance_amount;
	}
	public void setR181_crt_50_acceptance_amount(BigDecimal r181_crt_50_acceptance_amount) {
		this.r181_crt_50_acceptance_amount = r181_crt_50_acceptance_amount;
	}
	public BigDecimal getR181_crt_50_lcbg_crm() {
		return r181_crt_50_lcbg_crm;
	}
	public void setR181_crt_50_lcbg_crm(BigDecimal r181_crt_50_lcbg_crm) {
		this.r181_crt_50_lcbg_crm = r181_crt_50_lcbg_crm;
	}
	public BigDecimal getR181_crt_50_rwa() {
		return r181_crt_50_rwa;
	}
	public void setR181_crt_50_rwa(BigDecimal r181_crt_50_rwa) {
		this.r181_crt_50_rwa = r181_crt_50_rwa;
	}
	public BigDecimal getR181_crt_50_under_ccf_amt() {
		return r181_crt_50_under_ccf_amt;
	}
	public void setR181_crt_50_under_ccf_amt(BigDecimal r181_crt_50_under_ccf_amt) {
		this.r181_crt_50_under_ccf_amt = r181_crt_50_under_ccf_amt;
	}
	public BigDecimal getR182_crt_50_lcbg_balance() {
		return r182_crt_50_lcbg_balance;
	}
	public void setR182_crt_50_lcbg_balance(BigDecimal r182_crt_50_lcbg_balance) {
		this.r182_crt_50_lcbg_balance = r182_crt_50_lcbg_balance;
	}
	public BigDecimal getR182_crt_50_acceptance_amount() {
		return r182_crt_50_acceptance_amount;
	}
	public void setR182_crt_50_acceptance_amount(BigDecimal r182_crt_50_acceptance_amount) {
		this.r182_crt_50_acceptance_amount = r182_crt_50_acceptance_amount;
	}
	public BigDecimal getR182_crt_50_lcbg_crm() {
		return r182_crt_50_lcbg_crm;
	}
	public void setR182_crt_50_lcbg_crm(BigDecimal r182_crt_50_lcbg_crm) {
		this.r182_crt_50_lcbg_crm = r182_crt_50_lcbg_crm;
	}
	public BigDecimal getR182_crt_50_rwa() {
		return r182_crt_50_rwa;
	}
	public void setR182_crt_50_rwa(BigDecimal r182_crt_50_rwa) {
		this.r182_crt_50_rwa = r182_crt_50_rwa;
	}
	public BigDecimal getR182_crt_50_under_ccf_amt() {
		return r182_crt_50_under_ccf_amt;
	}
	public void setR182_crt_50_under_ccf_amt(BigDecimal r182_crt_50_under_ccf_amt) {
		this.r182_crt_50_under_ccf_amt = r182_crt_50_under_ccf_amt;
	}
	public BigDecimal getR183_crt_lcbg_balance() {
		return r183_crt_lcbg_balance;
	}
	public void setR183_crt_lcbg_balance(BigDecimal r183_crt_lcbg_balance) {
		this.r183_crt_lcbg_balance = r183_crt_lcbg_balance;
	}
	public BigDecimal getR183_crt_acceptance_amount() {
		return r183_crt_acceptance_amount;
	}
	public void setR183_crt_acceptance_amount(BigDecimal r183_crt_acceptance_amount) {
		this.r183_crt_acceptance_amount = r183_crt_acceptance_amount;
	}
	public BigDecimal getR183_crt_lcbg_crm() {
		return r183_crt_lcbg_crm;
	}
	public void setR183_crt_lcbg_crm(BigDecimal r183_crt_lcbg_crm) {
		this.r183_crt_lcbg_crm = r183_crt_lcbg_crm;
	}
	public BigDecimal getR183_crt_rwa() {
		return r183_crt_rwa;
	}
	public void setR183_crt_rwa(BigDecimal r183_crt_rwa) {
		this.r183_crt_rwa = r183_crt_rwa;
	}
	public BigDecimal getR183_crt_under_ccf_amt() {
		return r183_crt_under_ccf_amt;
	}
	public void setR183_crt_under_ccf_amt(BigDecimal r183_crt_under_ccf_amt) {
		this.r183_crt_under_ccf_amt = r183_crt_under_ccf_amt;
	}
	public BigDecimal getR184_crt_100_lcbg_balance() {
		return r184_crt_100_lcbg_balance;
	}
	public void setR184_crt_100_lcbg_balance(BigDecimal r184_crt_100_lcbg_balance) {
		this.r184_crt_100_lcbg_balance = r184_crt_100_lcbg_balance;
	}
	public BigDecimal getR184_crt_100_acceptance_amount() {
		return r184_crt_100_acceptance_amount;
	}
	public void setR184_crt_100_acceptance_amount(BigDecimal r184_crt_100_acceptance_amount) {
		this.r184_crt_100_acceptance_amount = r184_crt_100_acceptance_amount;
	}
	public BigDecimal getR184_crt_100_lcbg_crm() {
		return r184_crt_100_lcbg_crm;
	}
	public void setR184_crt_100_lcbg_crm(BigDecimal r184_crt_100_lcbg_crm) {
		this.r184_crt_100_lcbg_crm = r184_crt_100_lcbg_crm;
	}
	public BigDecimal getR184_crt_100_rwa() {
		return r184_crt_100_rwa;
	}
	public void setR184_crt_100_rwa(BigDecimal r184_crt_100_rwa) {
		this.r184_crt_100_rwa = r184_crt_100_rwa;
	}
	public BigDecimal getR184_crt_100_under_ccf_amt() {
		return r184_crt_100_under_ccf_amt;
	}
	public void setR184_crt_100_under_ccf_amt(BigDecimal r184_crt_100_under_ccf_amt) {
		this.r184_crt_100_under_ccf_amt = r184_crt_100_under_ccf_amt;
	}
	public BigDecimal getR185_crt_100_lcbg_balance() {
		return r185_crt_100_lcbg_balance;
	}
	public void setR185_crt_100_lcbg_balance(BigDecimal r185_crt_100_lcbg_balance) {
		this.r185_crt_100_lcbg_balance = r185_crt_100_lcbg_balance;
	}
	public BigDecimal getR185_crt_100_acceptance_amount() {
		return r185_crt_100_acceptance_amount;
	}
	public void setR185_crt_100_acceptance_amount(BigDecimal r185_crt_100_acceptance_amount) {
		this.r185_crt_100_acceptance_amount = r185_crt_100_acceptance_amount;
	}
	public BigDecimal getR185_crt_100_lcbg_crm() {
		return r185_crt_100_lcbg_crm;
	}
	public void setR185_crt_100_lcbg_crm(BigDecimal r185_crt_100_lcbg_crm) {
		this.r185_crt_100_lcbg_crm = r185_crt_100_lcbg_crm;
	}
	public BigDecimal getR185_crt_100_rwa() {
		return r185_crt_100_rwa;
	}
	public void setR185_crt_100_rwa(BigDecimal r185_crt_100_rwa) {
		this.r185_crt_100_rwa = r185_crt_100_rwa;
	}
	public BigDecimal getR185_crt_100_under_ccf_amt() {
		return r185_crt_100_under_ccf_amt;
	}
	public void setR185_crt_100_under_ccf_amt(BigDecimal r185_crt_100_under_ccf_amt) {
		this.r185_crt_100_under_ccf_amt = r185_crt_100_under_ccf_amt;
	}
	public BigDecimal getR186_crt_100_lcbg_balance() {
		return r186_crt_100_lcbg_balance;
	}
	public void setR186_crt_100_lcbg_balance(BigDecimal r186_crt_100_lcbg_balance) {
		this.r186_crt_100_lcbg_balance = r186_crt_100_lcbg_balance;
	}
	public BigDecimal getR186_crt_100_acceptance_amount() {
		return r186_crt_100_acceptance_amount;
	}
	public void setR186_crt_100_acceptance_amount(BigDecimal r186_crt_100_acceptance_amount) {
		this.r186_crt_100_acceptance_amount = r186_crt_100_acceptance_amount;
	}
	public BigDecimal getR186_crt_100_lcbg_crm() {
		return r186_crt_100_lcbg_crm;
	}
	public void setR186_crt_100_lcbg_crm(BigDecimal r186_crt_100_lcbg_crm) {
		this.r186_crt_100_lcbg_crm = r186_crt_100_lcbg_crm;
	}
	public BigDecimal getR186_crt_100_rwa() {
		return r186_crt_100_rwa;
	}
	public void setR186_crt_100_rwa(BigDecimal r186_crt_100_rwa) {
		this.r186_crt_100_rwa = r186_crt_100_rwa;
	}
	public BigDecimal getR186_crt_100_under_ccf_amt() {
		return r186_crt_100_under_ccf_amt;
	}
	public void setR186_crt_100_under_ccf_amt(BigDecimal r186_crt_100_under_ccf_amt) {
		this.r186_crt_100_under_ccf_amt = r186_crt_100_under_ccf_amt;
	}
	public BigDecimal getR187_crt_lcbg_balance() {
		return r187_crt_lcbg_balance;
	}
	public void setR187_crt_lcbg_balance(BigDecimal r187_crt_lcbg_balance) {
		this.r187_crt_lcbg_balance = r187_crt_lcbg_balance;
	}
	public BigDecimal getR187_crt_acceptance_amount() {
		return r187_crt_acceptance_amount;
	}
	public void setR187_crt_acceptance_amount(BigDecimal r187_crt_acceptance_amount) {
		this.r187_crt_acceptance_amount = r187_crt_acceptance_amount;
	}
	public BigDecimal getR187_crt_lcbg_crm() {
		return r187_crt_lcbg_crm;
	}
	public void setR187_crt_lcbg_crm(BigDecimal r187_crt_lcbg_crm) {
		this.r187_crt_lcbg_crm = r187_crt_lcbg_crm;
	}
	public BigDecimal getR187_crt_rwa() {
		return r187_crt_rwa;
	}
	public void setR187_crt_rwa(BigDecimal r187_crt_rwa) {
		this.r187_crt_rwa = r187_crt_rwa;
	}
	public BigDecimal getR187_crt_under_ccf_amt() {
		return r187_crt_under_ccf_amt;
	}
	public void setR187_crt_under_ccf_amt(BigDecimal r187_crt_under_ccf_amt) {
		this.r187_crt_under_ccf_amt = r187_crt_under_ccf_amt;
	}
	public BigDecimal getR188_crt_150_lcbg_balance() {
		return r188_crt_150_lcbg_balance;
	}
	public void setR188_crt_150_lcbg_balance(BigDecimal r188_crt_150_lcbg_balance) {
		this.r188_crt_150_lcbg_balance = r188_crt_150_lcbg_balance;
	}
	public BigDecimal getR188_crt_150_acceptance_amount() {
		return r188_crt_150_acceptance_amount;
	}
	public void setR188_crt_150_acceptance_amount(BigDecimal r188_crt_150_acceptance_amount) {
		this.r188_crt_150_acceptance_amount = r188_crt_150_acceptance_amount;
	}
	public BigDecimal getR188_crt_150_lcbg_crm() {
		return r188_crt_150_lcbg_crm;
	}
	public void setR188_crt_150_lcbg_crm(BigDecimal r188_crt_150_lcbg_crm) {
		this.r188_crt_150_lcbg_crm = r188_crt_150_lcbg_crm;
	}
	public BigDecimal getR188_crt_150_rwa() {
		return r188_crt_150_rwa;
	}
	public void setR188_crt_150_rwa(BigDecimal r188_crt_150_rwa) {
		this.r188_crt_150_rwa = r188_crt_150_rwa;
	}
	public BigDecimal getR188_crt_150_under_ccf_amt() {
		return r188_crt_150_under_ccf_amt;
	}
	public void setR188_crt_150_under_ccf_amt(BigDecimal r188_crt_150_under_ccf_amt) {
		this.r188_crt_150_under_ccf_amt = r188_crt_150_under_ccf_amt;
	}
	public BigDecimal getR189_crt_150_lcbg_balance() {
		return r189_crt_150_lcbg_balance;
	}
	public void setR189_crt_150_lcbg_balance(BigDecimal r189_crt_150_lcbg_balance) {
		this.r189_crt_150_lcbg_balance = r189_crt_150_lcbg_balance;
	}
	public BigDecimal getR189_crt_150_acceptance_amount() {
		return r189_crt_150_acceptance_amount;
	}
	public void setR189_crt_150_acceptance_amount(BigDecimal r189_crt_150_acceptance_amount) {
		this.r189_crt_150_acceptance_amount = r189_crt_150_acceptance_amount;
	}
	public BigDecimal getR189_crt_150_lcbg_crm() {
		return r189_crt_150_lcbg_crm;
	}
	public void setR189_crt_150_lcbg_crm(BigDecimal r189_crt_150_lcbg_crm) {
		this.r189_crt_150_lcbg_crm = r189_crt_150_lcbg_crm;
	}
	public BigDecimal getR189_crt_150_rwa() {
		return r189_crt_150_rwa;
	}
	public void setR189_crt_150_rwa(BigDecimal r189_crt_150_rwa) {
		this.r189_crt_150_rwa = r189_crt_150_rwa;
	}
	public BigDecimal getR189_crt_150_under_ccf_amt() {
		return r189_crt_150_under_ccf_amt;
	}
	public void setR189_crt_150_under_ccf_amt(BigDecimal r189_crt_150_under_ccf_amt) {
		this.r189_crt_150_under_ccf_amt = r189_crt_150_under_ccf_amt;
	}
	public BigDecimal getR190_crt_150_lcbg_balance() {
		return r190_crt_150_lcbg_balance;
	}
	public void setR190_crt_150_lcbg_balance(BigDecimal r190_crt_150_lcbg_balance) {
		this.r190_crt_150_lcbg_balance = r190_crt_150_lcbg_balance;
	}
	public BigDecimal getR190_crt_150_acceptance_amount() {
		return r190_crt_150_acceptance_amount;
	}
	public void setR190_crt_150_acceptance_amount(BigDecimal r190_crt_150_acceptance_amount) {
		this.r190_crt_150_acceptance_amount = r190_crt_150_acceptance_amount;
	}
	public BigDecimal getR190_crt_150_lcbg_crm() {
		return r190_crt_150_lcbg_crm;
	}
	public void setR190_crt_150_lcbg_crm(BigDecimal r190_crt_150_lcbg_crm) {
		this.r190_crt_150_lcbg_crm = r190_crt_150_lcbg_crm;
	}
	public BigDecimal getR190_crt_150_rwa() {
		return r190_crt_150_rwa;
	}
	public void setR190_crt_150_rwa(BigDecimal r190_crt_150_rwa) {
		this.r190_crt_150_rwa = r190_crt_150_rwa;
	}
	public BigDecimal getR190_crt_150_under_ccf_amt() {
		return r190_crt_150_under_ccf_amt;
	}
	public void setR190_crt_150_under_ccf_amt(BigDecimal r190_crt_150_under_ccf_amt) {
		this.r190_crt_150_under_ccf_amt = r190_crt_150_under_ccf_amt;
	}
	public BigDecimal getR191_crt_lcbg_balance() {
		return r191_crt_lcbg_balance;
	}
	public void setR191_crt_lcbg_balance(BigDecimal r191_crt_lcbg_balance) {
		this.r191_crt_lcbg_balance = r191_crt_lcbg_balance;
	}
	public BigDecimal getR191_crt_acceptance_amount() {
		return r191_crt_acceptance_amount;
	}
	public void setR191_crt_acceptance_amount(BigDecimal r191_crt_acceptance_amount) {
		this.r191_crt_acceptance_amount = r191_crt_acceptance_amount;
	}
	public BigDecimal getR191_crt_lcbg_crm() {
		return r191_crt_lcbg_crm;
	}
	public void setR191_crt_lcbg_crm(BigDecimal r191_crt_lcbg_crm) {
		this.r191_crt_lcbg_crm = r191_crt_lcbg_crm;
	}
	public BigDecimal getR191_crt_rwa() {
		return r191_crt_rwa;
	}
	public void setR191_crt_rwa(BigDecimal r191_crt_rwa) {
		this.r191_crt_rwa = r191_crt_rwa;
	}
	public BigDecimal getR191_crt_under_ccf_amt() {
		return r191_crt_under_ccf_amt;
	}
	public void setR191_crt_under_ccf_amt(BigDecimal r191_crt_under_ccf_amt) {
		this.r191_crt_under_ccf_amt = r191_crt_under_ccf_amt;
	}
	public BigDecimal getR192_hni_100_lcbg_balance() {
		return r192_hni_100_lcbg_balance;
	}
	public void setR192_hni_100_lcbg_balance(BigDecimal r192_hni_100_lcbg_balance) {
		this.r192_hni_100_lcbg_balance = r192_hni_100_lcbg_balance;
	}
	public BigDecimal getR192_hni_100_acceptance_amount() {
		return r192_hni_100_acceptance_amount;
	}
	public void setR192_hni_100_acceptance_amount(BigDecimal r192_hni_100_acceptance_amount) {
		this.r192_hni_100_acceptance_amount = r192_hni_100_acceptance_amount;
	}
	public BigDecimal getR192_hni_100_lcbg_crm() {
		return r192_hni_100_lcbg_crm;
	}
	public void setR192_hni_100_lcbg_crm(BigDecimal r192_hni_100_lcbg_crm) {
		this.r192_hni_100_lcbg_crm = r192_hni_100_lcbg_crm;
	}
	public BigDecimal getR192_hni_100_rwa() {
		return r192_hni_100_rwa;
	}
	public void setR192_hni_100_rwa(BigDecimal r192_hni_100_rwa) {
		this.r192_hni_100_rwa = r192_hni_100_rwa;
	}
	public BigDecimal getR192_hni_100_under_ccf_amt() {
		return r192_hni_100_under_ccf_amt;
	}
	public void setR192_hni_100_under_ccf_amt(BigDecimal r192_hni_100_under_ccf_amt) {
		this.r192_hni_100_under_ccf_amt = r192_hni_100_under_ccf_amt;
	}
	public BigDecimal getR193_hni_100_lcbg_balance() {
		return r193_hni_100_lcbg_balance;
	}
	public void setR193_hni_100_lcbg_balance(BigDecimal r193_hni_100_lcbg_balance) {
		this.r193_hni_100_lcbg_balance = r193_hni_100_lcbg_balance;
	}
	public BigDecimal getR193_hni_100_acceptance_amount() {
		return r193_hni_100_acceptance_amount;
	}
	public void setR193_hni_100_acceptance_amount(BigDecimal r193_hni_100_acceptance_amount) {
		this.r193_hni_100_acceptance_amount = r193_hni_100_acceptance_amount;
	}
	public BigDecimal getR193_hni_100_lcbg_crm() {
		return r193_hni_100_lcbg_crm;
	}
	public void setR193_hni_100_lcbg_crm(BigDecimal r193_hni_100_lcbg_crm) {
		this.r193_hni_100_lcbg_crm = r193_hni_100_lcbg_crm;
	}
	public BigDecimal getR193_hni_100_rwa() {
		return r193_hni_100_rwa;
	}
	public void setR193_hni_100_rwa(BigDecimal r193_hni_100_rwa) {
		this.r193_hni_100_rwa = r193_hni_100_rwa;
	}
	public BigDecimal getR193_hni_100_under_ccf_amt() {
		return r193_hni_100_under_ccf_amt;
	}
	public void setR193_hni_100_under_ccf_amt(BigDecimal r193_hni_100_under_ccf_amt) {
		this.r193_hni_100_under_ccf_amt = r193_hni_100_under_ccf_amt;
	}
	public BigDecimal getR194_hni_100_lcbg_balance() {
		return r194_hni_100_lcbg_balance;
	}
	public void setR194_hni_100_lcbg_balance(BigDecimal r194_hni_100_lcbg_balance) {
		this.r194_hni_100_lcbg_balance = r194_hni_100_lcbg_balance;
	}
	public BigDecimal getR194_hni_100_acceptance_amount() {
		return r194_hni_100_acceptance_amount;
	}
	public void setR194_hni_100_acceptance_amount(BigDecimal r194_hni_100_acceptance_amount) {
		this.r194_hni_100_acceptance_amount = r194_hni_100_acceptance_amount;
	}
	public BigDecimal getR194_hni_100_lcbg_crm() {
		return r194_hni_100_lcbg_crm;
	}
	public void setR194_hni_100_lcbg_crm(BigDecimal r194_hni_100_lcbg_crm) {
		this.r194_hni_100_lcbg_crm = r194_hni_100_lcbg_crm;
	}
	public BigDecimal getR194_hni_100_rwa() {
		return r194_hni_100_rwa;
	}
	public void setR194_hni_100_rwa(BigDecimal r194_hni_100_rwa) {
		this.r194_hni_100_rwa = r194_hni_100_rwa;
	}
	public BigDecimal getR194_hni_100_under_ccf_amt() {
		return r194_hni_100_under_ccf_amt;
	}
	public void setR194_hni_100_under_ccf_amt(BigDecimal r194_hni_100_under_ccf_amt) {
		this.r194_hni_100_under_ccf_amt = r194_hni_100_under_ccf_amt;
	}
	public BigDecimal getR195_hni_lcbg_balance() {
		return r195_hni_lcbg_balance;
	}
	public void setR195_hni_lcbg_balance(BigDecimal r195_hni_lcbg_balance) {
		this.r195_hni_lcbg_balance = r195_hni_lcbg_balance;
	}
	public BigDecimal getR195_hni_acceptance_amount() {
		return r195_hni_acceptance_amount;
	}
	public void setR195_hni_acceptance_amount(BigDecimal r195_hni_acceptance_amount) {
		this.r195_hni_acceptance_amount = r195_hni_acceptance_amount;
	}
	public BigDecimal getR195_hni_lcbg_crm() {
		return r195_hni_lcbg_crm;
	}
	public void setR195_hni_lcbg_crm(BigDecimal r195_hni_lcbg_crm) {
		this.r195_hni_lcbg_crm = r195_hni_lcbg_crm;
	}
	public BigDecimal getR195_hni_rwa() {
		return r195_hni_rwa;
	}
	public void setR195_hni_rwa(BigDecimal r195_hni_rwa) {
		this.r195_hni_rwa = r195_hni_rwa;
	}
	public BigDecimal getR195_hni_under_ccf_amt() {
		return r195_hni_under_ccf_amt;
	}
	public void setR195_hni_under_ccf_amt(BigDecimal r195_hni_under_ccf_amt) {
		this.r195_hni_under_ccf_amt = r195_hni_under_ccf_amt;
	}
	public BigDecimal getR196_pdl_100_lcbg_balance() {
		return r196_pdl_100_lcbg_balance;
	}
	public void setR196_pdl_100_lcbg_balance(BigDecimal r196_pdl_100_lcbg_balance) {
		this.r196_pdl_100_lcbg_balance = r196_pdl_100_lcbg_balance;
	}
	public BigDecimal getR196_pdl_100_acceptance_amount() {
		return r196_pdl_100_acceptance_amount;
	}
	public void setR196_pdl_100_acceptance_amount(BigDecimal r196_pdl_100_acceptance_amount) {
		this.r196_pdl_100_acceptance_amount = r196_pdl_100_acceptance_amount;
	}
	public BigDecimal getR196_pdl_100_lcbg_crm() {
		return r196_pdl_100_lcbg_crm;
	}
	public void setR196_pdl_100_lcbg_crm(BigDecimal r196_pdl_100_lcbg_crm) {
		this.r196_pdl_100_lcbg_crm = r196_pdl_100_lcbg_crm;
	}
	public BigDecimal getR196_pdl_100_rwa() {
		return r196_pdl_100_rwa;
	}
	public void setR196_pdl_100_rwa(BigDecimal r196_pdl_100_rwa) {
		this.r196_pdl_100_rwa = r196_pdl_100_rwa;
	}
	public BigDecimal getR196_pdl_100_under_ccf_amt() {
		return r196_pdl_100_under_ccf_amt;
	}
	public void setR196_pdl_100_under_ccf_amt(BigDecimal r196_pdl_100_under_ccf_amt) {
		this.r196_pdl_100_under_ccf_amt = r196_pdl_100_under_ccf_amt;
	}
	public BigDecimal getR197_pdl_100_lcbg_balance() {
		return r197_pdl_100_lcbg_balance;
	}
	public void setR197_pdl_100_lcbg_balance(BigDecimal r197_pdl_100_lcbg_balance) {
		this.r197_pdl_100_lcbg_balance = r197_pdl_100_lcbg_balance;
	}
	public BigDecimal getR197_pdl_100_acceptance_amount() {
		return r197_pdl_100_acceptance_amount;
	}
	public void setR197_pdl_100_acceptance_amount(BigDecimal r197_pdl_100_acceptance_amount) {
		this.r197_pdl_100_acceptance_amount = r197_pdl_100_acceptance_amount;
	}
	public BigDecimal getR197_pdl_100_lcbg_crm() {
		return r197_pdl_100_lcbg_crm;
	}
	public void setR197_pdl_100_lcbg_crm(BigDecimal r197_pdl_100_lcbg_crm) {
		this.r197_pdl_100_lcbg_crm = r197_pdl_100_lcbg_crm;
	}
	public BigDecimal getR197_pdl_100_rwa() {
		return r197_pdl_100_rwa;
	}
	public void setR197_pdl_100_rwa(BigDecimal r197_pdl_100_rwa) {
		this.r197_pdl_100_rwa = r197_pdl_100_rwa;
	}
	public BigDecimal getR197_pdl_100_under_ccf_amt() {
		return r197_pdl_100_under_ccf_amt;
	}
	public void setR197_pdl_100_under_ccf_amt(BigDecimal r197_pdl_100_under_ccf_amt) {
		this.r197_pdl_100_under_ccf_amt = r197_pdl_100_under_ccf_amt;
	}
	public BigDecimal getR198_pdl_100_lcbg_balance() {
		return r198_pdl_100_lcbg_balance;
	}
	public void setR198_pdl_100_lcbg_balance(BigDecimal r198_pdl_100_lcbg_balance) {
		this.r198_pdl_100_lcbg_balance = r198_pdl_100_lcbg_balance;
	}
	public BigDecimal getR198_pdl_100_acceptance_amount() {
		return r198_pdl_100_acceptance_amount;
	}
	public void setR198_pdl_100_acceptance_amount(BigDecimal r198_pdl_100_acceptance_amount) {
		this.r198_pdl_100_acceptance_amount = r198_pdl_100_acceptance_amount;
	}
	public BigDecimal getR198_pdl_100_lcbg_crm() {
		return r198_pdl_100_lcbg_crm;
	}
	public void setR198_pdl_100_lcbg_crm(BigDecimal r198_pdl_100_lcbg_crm) {
		this.r198_pdl_100_lcbg_crm = r198_pdl_100_lcbg_crm;
	}
	public BigDecimal getR198_pdl_100_rwa() {
		return r198_pdl_100_rwa;
	}
	public void setR198_pdl_100_rwa(BigDecimal r198_pdl_100_rwa) {
		this.r198_pdl_100_rwa = r198_pdl_100_rwa;
	}
	public BigDecimal getR198_pdl_100_under_ccf_amt() {
		return r198_pdl_100_under_ccf_amt;
	}
	public void setR198_pdl_100_under_ccf_amt(BigDecimal r198_pdl_100_under_ccf_amt) {
		this.r198_pdl_100_under_ccf_amt = r198_pdl_100_under_ccf_amt;
	}
	public BigDecimal getR199_pdl_lcbg_balance() {
		return r199_pdl_lcbg_balance;
	}
	public void setR199_pdl_lcbg_balance(BigDecimal r199_pdl_lcbg_balance) {
		this.r199_pdl_lcbg_balance = r199_pdl_lcbg_balance;
	}
	public BigDecimal getR199_pdl_acceptance_amount() {
		return r199_pdl_acceptance_amount;
	}
	public void setR199_pdl_acceptance_amount(BigDecimal r199_pdl_acceptance_amount) {
		this.r199_pdl_acceptance_amount = r199_pdl_acceptance_amount;
	}
	public BigDecimal getR199_pdl_lcbg_crm() {
		return r199_pdl_lcbg_crm;
	}
	public void setR199_pdl_lcbg_crm(BigDecimal r199_pdl_lcbg_crm) {
		this.r199_pdl_lcbg_crm = r199_pdl_lcbg_crm;
	}
	public BigDecimal getR199_pdl_rwa() {
		return r199_pdl_rwa;
	}
	public void setR199_pdl_rwa(BigDecimal r199_pdl_rwa) {
		this.r199_pdl_rwa = r199_pdl_rwa;
	}
	public BigDecimal getR199_pdl_under_ccf_amt() {
		return r199_pdl_under_ccf_amt;
	}
	public void setR199_pdl_under_ccf_amt(BigDecimal r199_pdl_under_ccf_amt) {
		this.r199_pdl_under_ccf_amt = r199_pdl_under_ccf_amt;
	}
	public BigDecimal getR200_pdl_150_lcbg_balance() {
		return r200_pdl_150_lcbg_balance;
	}
	public void setR200_pdl_150_lcbg_balance(BigDecimal r200_pdl_150_lcbg_balance) {
		this.r200_pdl_150_lcbg_balance = r200_pdl_150_lcbg_balance;
	}
	public BigDecimal getR200_pdl_150_acceptance_amount() {
		return r200_pdl_150_acceptance_amount;
	}
	public void setR200_pdl_150_acceptance_amount(BigDecimal r200_pdl_150_acceptance_amount) {
		this.r200_pdl_150_acceptance_amount = r200_pdl_150_acceptance_amount;
	}
	public BigDecimal getR200_pdl_150_lcbg_crm() {
		return r200_pdl_150_lcbg_crm;
	}
	public void setR200_pdl_150_lcbg_crm(BigDecimal r200_pdl_150_lcbg_crm) {
		this.r200_pdl_150_lcbg_crm = r200_pdl_150_lcbg_crm;
	}
	public BigDecimal getR200_pdl_150_rwa() {
		return r200_pdl_150_rwa;
	}
	public void setR200_pdl_150_rwa(BigDecimal r200_pdl_150_rwa) {
		this.r200_pdl_150_rwa = r200_pdl_150_rwa;
	}
	public BigDecimal getR200_pdl_150_under_ccf_amt() {
		return r200_pdl_150_under_ccf_amt;
	}
	public void setR200_pdl_150_under_ccf_amt(BigDecimal r200_pdl_150_under_ccf_amt) {
		this.r200_pdl_150_under_ccf_amt = r200_pdl_150_under_ccf_amt;
	}
	public BigDecimal getR201_pdl_150_lcbg_balance() {
		return r201_pdl_150_lcbg_balance;
	}
	public void setR201_pdl_150_lcbg_balance(BigDecimal r201_pdl_150_lcbg_balance) {
		this.r201_pdl_150_lcbg_balance = r201_pdl_150_lcbg_balance;
	}
	public BigDecimal getR201_pdl_150_acceptance_amount() {
		return r201_pdl_150_acceptance_amount;
	}
	public void setR201_pdl_150_acceptance_amount(BigDecimal r201_pdl_150_acceptance_amount) {
		this.r201_pdl_150_acceptance_amount = r201_pdl_150_acceptance_amount;
	}
	public BigDecimal getR201_pdl_150_lcbg_crm() {
		return r201_pdl_150_lcbg_crm;
	}
	public void setR201_pdl_150_lcbg_crm(BigDecimal r201_pdl_150_lcbg_crm) {
		this.r201_pdl_150_lcbg_crm = r201_pdl_150_lcbg_crm;
	}
	public BigDecimal getR201_pdl_150_rwa() {
		return r201_pdl_150_rwa;
	}
	public void setR201_pdl_150_rwa(BigDecimal r201_pdl_150_rwa) {
		this.r201_pdl_150_rwa = r201_pdl_150_rwa;
	}
	public BigDecimal getR201_pdl_150_under_ccf_amt() {
		return r201_pdl_150_under_ccf_amt;
	}
	public void setR201_pdl_150_under_ccf_amt(BigDecimal r201_pdl_150_under_ccf_amt) {
		this.r201_pdl_150_under_ccf_amt = r201_pdl_150_under_ccf_amt;
	}
	public BigDecimal getR202_pdl_150_lcbg_balance() {
		return r202_pdl_150_lcbg_balance;
	}
	public void setR202_pdl_150_lcbg_balance(BigDecimal r202_pdl_150_lcbg_balance) {
		this.r202_pdl_150_lcbg_balance = r202_pdl_150_lcbg_balance;
	}
	public BigDecimal getR202_pdl_150_acceptance_amount() {
		return r202_pdl_150_acceptance_amount;
	}
	public void setR202_pdl_150_acceptance_amount(BigDecimal r202_pdl_150_acceptance_amount) {
		this.r202_pdl_150_acceptance_amount = r202_pdl_150_acceptance_amount;
	}
	public BigDecimal getR202_pdl_150_lcbg_crm() {
		return r202_pdl_150_lcbg_crm;
	}
	public void setR202_pdl_150_lcbg_crm(BigDecimal r202_pdl_150_lcbg_crm) {
		this.r202_pdl_150_lcbg_crm = r202_pdl_150_lcbg_crm;
	}
	public BigDecimal getR202_pdl_150_rwa() {
		return r202_pdl_150_rwa;
	}
	public void setR202_pdl_150_rwa(BigDecimal r202_pdl_150_rwa) {
		this.r202_pdl_150_rwa = r202_pdl_150_rwa;
	}
	public BigDecimal getR202_pdl_150_under_ccf_amt() {
		return r202_pdl_150_under_ccf_amt;
	}
	public void setR202_pdl_150_under_ccf_amt(BigDecimal r202_pdl_150_under_ccf_amt) {
		this.r202_pdl_150_under_ccf_amt = r202_pdl_150_under_ccf_amt;
	}
	public BigDecimal getR203_pdl_lcbg_balance() {
		return r203_pdl_lcbg_balance;
	}
	public void setR203_pdl_lcbg_balance(BigDecimal r203_pdl_lcbg_balance) {
		this.r203_pdl_lcbg_balance = r203_pdl_lcbg_balance;
	}
	public BigDecimal getR203_pdl_acceptance_amount() {
		return r203_pdl_acceptance_amount;
	}
	public void setR203_pdl_acceptance_amount(BigDecimal r203_pdl_acceptance_amount) {
		this.r203_pdl_acceptance_amount = r203_pdl_acceptance_amount;
	}
	public BigDecimal getR203_pdl_lcbg_crm() {
		return r203_pdl_lcbg_crm;
	}
	public void setR203_pdl_lcbg_crm(BigDecimal r203_pdl_lcbg_crm) {
		this.r203_pdl_lcbg_crm = r203_pdl_lcbg_crm;
	}
	public BigDecimal getR203_pdl_rwa() {
		return r203_pdl_rwa;
	}
	public void setR203_pdl_rwa(BigDecimal r203_pdl_rwa) {
		this.r203_pdl_rwa = r203_pdl_rwa;
	}
	public BigDecimal getR203_pdl_under_ccf_amt() {
		return r203_pdl_under_ccf_amt;
	}
	public void setR203_pdl_under_ccf_amt(BigDecimal r203_pdl_under_ccf_amt) {
		this.r203_pdl_under_ccf_amt = r203_pdl_under_ccf_amt;
	}
	public BigDecimal getR204_pse_0_lcbg_balance() {
		return r204_pse_0_lcbg_balance;
	}
	public void setR204_pse_0_lcbg_balance(BigDecimal r204_pse_0_lcbg_balance) {
		this.r204_pse_0_lcbg_balance = r204_pse_0_lcbg_balance;
	}
	public BigDecimal getR204_pse_0_acceptance_amount() {
		return r204_pse_0_acceptance_amount;
	}
	public void setR204_pse_0_acceptance_amount(BigDecimal r204_pse_0_acceptance_amount) {
		this.r204_pse_0_acceptance_amount = r204_pse_0_acceptance_amount;
	}
	public BigDecimal getR204_pse_0_lcbg_crm() {
		return r204_pse_0_lcbg_crm;
	}
	public void setR204_pse_0_lcbg_crm(BigDecimal r204_pse_0_lcbg_crm) {
		this.r204_pse_0_lcbg_crm = r204_pse_0_lcbg_crm;
	}
	public BigDecimal getR204_pse_0_rwa() {
		return r204_pse_0_rwa;
	}
	public void setR204_pse_0_rwa(BigDecimal r204_pse_0_rwa) {
		this.r204_pse_0_rwa = r204_pse_0_rwa;
	}
	public BigDecimal getR204_pse_0_under_ccf_amt() {
		return r204_pse_0_under_ccf_amt;
	}
	public void setR204_pse_0_under_ccf_amt(BigDecimal r204_pse_0_under_ccf_amt) {
		this.r204_pse_0_under_ccf_amt = r204_pse_0_under_ccf_amt;
	}
	public BigDecimal getR205_pse_0_lcbg_balance() {
		return r205_pse_0_lcbg_balance;
	}
	public void setR205_pse_0_lcbg_balance(BigDecimal r205_pse_0_lcbg_balance) {
		this.r205_pse_0_lcbg_balance = r205_pse_0_lcbg_balance;
	}
	public BigDecimal getR205_pse_0_acceptance_amount() {
		return r205_pse_0_acceptance_amount;
	}
	public void setR205_pse_0_acceptance_amount(BigDecimal r205_pse_0_acceptance_amount) {
		this.r205_pse_0_acceptance_amount = r205_pse_0_acceptance_amount;
	}
	public BigDecimal getR205_pse_0_lcbg_crm() {
		return r205_pse_0_lcbg_crm;
	}
	public void setR205_pse_0_lcbg_crm(BigDecimal r205_pse_0_lcbg_crm) {
		this.r205_pse_0_lcbg_crm = r205_pse_0_lcbg_crm;
	}
	public BigDecimal getR205_pse_0_rwa() {
		return r205_pse_0_rwa;
	}
	public void setR205_pse_0_rwa(BigDecimal r205_pse_0_rwa) {
		this.r205_pse_0_rwa = r205_pse_0_rwa;
	}
	public BigDecimal getR205_pse_0_under_ccf_amt() {
		return r205_pse_0_under_ccf_amt;
	}
	public void setR205_pse_0_under_ccf_amt(BigDecimal r205_pse_0_under_ccf_amt) {
		this.r205_pse_0_under_ccf_amt = r205_pse_0_under_ccf_amt;
	}
	public BigDecimal getR206_pse_0_lcbg_balance() {
		return r206_pse_0_lcbg_balance;
	}
	public void setR206_pse_0_lcbg_balance(BigDecimal r206_pse_0_lcbg_balance) {
		this.r206_pse_0_lcbg_balance = r206_pse_0_lcbg_balance;
	}
	public BigDecimal getR206_pse_0_acceptance_amount() {
		return r206_pse_0_acceptance_amount;
	}
	public void setR206_pse_0_acceptance_amount(BigDecimal r206_pse_0_acceptance_amount) {
		this.r206_pse_0_acceptance_amount = r206_pse_0_acceptance_amount;
	}
	public BigDecimal getR206_pse_0_lcbg_crm() {
		return r206_pse_0_lcbg_crm;
	}
	public void setR206_pse_0_lcbg_crm(BigDecimal r206_pse_0_lcbg_crm) {
		this.r206_pse_0_lcbg_crm = r206_pse_0_lcbg_crm;
	}
	public BigDecimal getR206_pse_0_rwa() {
		return r206_pse_0_rwa;
	}
	public void setR206_pse_0_rwa(BigDecimal r206_pse_0_rwa) {
		this.r206_pse_0_rwa = r206_pse_0_rwa;
	}
	public BigDecimal getR206_pse_0_under_ccf_amt() {
		return r206_pse_0_under_ccf_amt;
	}
	public void setR206_pse_0_under_ccf_amt(BigDecimal r206_pse_0_under_ccf_amt) {
		this.r206_pse_0_under_ccf_amt = r206_pse_0_under_ccf_amt;
	}
	public BigDecimal getR207_pse_lcbg_balance() {
		return r207_pse_lcbg_balance;
	}
	public void setR207_pse_lcbg_balance(BigDecimal r207_pse_lcbg_balance) {
		this.r207_pse_lcbg_balance = r207_pse_lcbg_balance;
	}
	public BigDecimal getR207_pse_acceptance_amount() {
		return r207_pse_acceptance_amount;
	}
	public void setR207_pse_acceptance_amount(BigDecimal r207_pse_acceptance_amount) {
		this.r207_pse_acceptance_amount = r207_pse_acceptance_amount;
	}
	public BigDecimal getR207_pse_lcbg_crm() {
		return r207_pse_lcbg_crm;
	}
	public void setR207_pse_lcbg_crm(BigDecimal r207_pse_lcbg_crm) {
		this.r207_pse_lcbg_crm = r207_pse_lcbg_crm;
	}
	public BigDecimal getR207_pse_rwa() {
		return r207_pse_rwa;
	}
	public void setR207_pse_rwa(BigDecimal r207_pse_rwa) {
		this.r207_pse_rwa = r207_pse_rwa;
	}
	public BigDecimal getR207_pse_under_ccf_amt() {
		return r207_pse_under_ccf_amt;
	}
	public void setR207_pse_under_ccf_amt(BigDecimal r207_pse_under_ccf_amt) {
		this.r207_pse_under_ccf_amt = r207_pse_under_ccf_amt;
	}
	public BigDecimal getR208_pse_20_lcbg_balance() {
		return r208_pse_20_lcbg_balance;
	}
	public void setR208_pse_20_lcbg_balance(BigDecimal r208_pse_20_lcbg_balance) {
		this.r208_pse_20_lcbg_balance = r208_pse_20_lcbg_balance;
	}
	public BigDecimal getR208_pse_20_acceptance_amount() {
		return r208_pse_20_acceptance_amount;
	}
	public void setR208_pse_20_acceptance_amount(BigDecimal r208_pse_20_acceptance_amount) {
		this.r208_pse_20_acceptance_amount = r208_pse_20_acceptance_amount;
	}
	public BigDecimal getR208_pse_20_lcbg_crm() {
		return r208_pse_20_lcbg_crm;
	}
	public void setR208_pse_20_lcbg_crm(BigDecimal r208_pse_20_lcbg_crm) {
		this.r208_pse_20_lcbg_crm = r208_pse_20_lcbg_crm;
	}
	public BigDecimal getR208_pse_20_rwa() {
		return r208_pse_20_rwa;
	}
	public void setR208_pse_20_rwa(BigDecimal r208_pse_20_rwa) {
		this.r208_pse_20_rwa = r208_pse_20_rwa;
	}
	public BigDecimal getR208_pse_20_under_ccf_amt() {
		return r208_pse_20_under_ccf_amt;
	}
	public void setR208_pse_20_under_ccf_amt(BigDecimal r208_pse_20_under_ccf_amt) {
		this.r208_pse_20_under_ccf_amt = r208_pse_20_under_ccf_amt;
	}
	public BigDecimal getR209_pse_20_lcbg_balance() {
		return r209_pse_20_lcbg_balance;
	}
	public void setR209_pse_20_lcbg_balance(BigDecimal r209_pse_20_lcbg_balance) {
		this.r209_pse_20_lcbg_balance = r209_pse_20_lcbg_balance;
	}
	public BigDecimal getR209_pse_20_acceptance_amount() {
		return r209_pse_20_acceptance_amount;
	}
	public void setR209_pse_20_acceptance_amount(BigDecimal r209_pse_20_acceptance_amount) {
		this.r209_pse_20_acceptance_amount = r209_pse_20_acceptance_amount;
	}
	public BigDecimal getR209_pse_20_lcbg_crm() {
		return r209_pse_20_lcbg_crm;
	}
	public void setR209_pse_20_lcbg_crm(BigDecimal r209_pse_20_lcbg_crm) {
		this.r209_pse_20_lcbg_crm = r209_pse_20_lcbg_crm;
	}
	public BigDecimal getR209_pse_20_rwa() {
		return r209_pse_20_rwa;
	}
	public void setR209_pse_20_rwa(BigDecimal r209_pse_20_rwa) {
		this.r209_pse_20_rwa = r209_pse_20_rwa;
	}
	public BigDecimal getR209_pse_20_under_ccf_amt() {
		return r209_pse_20_under_ccf_amt;
	}
	public void setR209_pse_20_under_ccf_amt(BigDecimal r209_pse_20_under_ccf_amt) {
		this.r209_pse_20_under_ccf_amt = r209_pse_20_under_ccf_amt;
	}
	public BigDecimal getR210_pse_20_lcbg_balance() {
		return r210_pse_20_lcbg_balance;
	}
	public void setR210_pse_20_lcbg_balance(BigDecimal r210_pse_20_lcbg_balance) {
		this.r210_pse_20_lcbg_balance = r210_pse_20_lcbg_balance;
	}
	public BigDecimal getR210_pse_20_acceptance_amount() {
		return r210_pse_20_acceptance_amount;
	}
	public void setR210_pse_20_acceptance_amount(BigDecimal r210_pse_20_acceptance_amount) {
		this.r210_pse_20_acceptance_amount = r210_pse_20_acceptance_amount;
	}
	public BigDecimal getR210_pse_20_lcbg_crm() {
		return r210_pse_20_lcbg_crm;
	}
	public void setR210_pse_20_lcbg_crm(BigDecimal r210_pse_20_lcbg_crm) {
		this.r210_pse_20_lcbg_crm = r210_pse_20_lcbg_crm;
	}
	public BigDecimal getR210_pse_20_rwa() {
		return r210_pse_20_rwa;
	}
	public void setR210_pse_20_rwa(BigDecimal r210_pse_20_rwa) {
		this.r210_pse_20_rwa = r210_pse_20_rwa;
	}
	public BigDecimal getR210_pse_20_under_ccf_amt() {
		return r210_pse_20_under_ccf_amt;
	}
	public void setR210_pse_20_under_ccf_amt(BigDecimal r210_pse_20_under_ccf_amt) {
		this.r210_pse_20_under_ccf_amt = r210_pse_20_under_ccf_amt;
	}
	public BigDecimal getR211_pse_lcbg_balance() {
		return r211_pse_lcbg_balance;
	}
	public void setR211_pse_lcbg_balance(BigDecimal r211_pse_lcbg_balance) {
		this.r211_pse_lcbg_balance = r211_pse_lcbg_balance;
	}
	public BigDecimal getR211_pse_acceptance_amount() {
		return r211_pse_acceptance_amount;
	}
	public void setR211_pse_acceptance_amount(BigDecimal r211_pse_acceptance_amount) {
		this.r211_pse_acceptance_amount = r211_pse_acceptance_amount;
	}
	public BigDecimal getR211_pse_lcbg_crm() {
		return r211_pse_lcbg_crm;
	}
	public void setR211_pse_lcbg_crm(BigDecimal r211_pse_lcbg_crm) {
		this.r211_pse_lcbg_crm = r211_pse_lcbg_crm;
	}
	public BigDecimal getR211_pse_rwa() {
		return r211_pse_rwa;
	}
	public void setR211_pse_rwa(BigDecimal r211_pse_rwa) {
		this.r211_pse_rwa = r211_pse_rwa;
	}
	public BigDecimal getR211_pse_under_ccf_amt() {
		return r211_pse_under_ccf_amt;
	}
	public void setR211_pse_under_ccf_amt(BigDecimal r211_pse_under_ccf_amt) {
		this.r211_pse_under_ccf_amt = r211_pse_under_ccf_amt;
	}
	public BigDecimal getR212_pse_50_lcbg_balance() {
		return r212_pse_50_lcbg_balance;
	}
	public void setR212_pse_50_lcbg_balance(BigDecimal r212_pse_50_lcbg_balance) {
		this.r212_pse_50_lcbg_balance = r212_pse_50_lcbg_balance;
	}
	public BigDecimal getR212_pse_50_acceptance_amount() {
		return r212_pse_50_acceptance_amount;
	}
	public void setR212_pse_50_acceptance_amount(BigDecimal r212_pse_50_acceptance_amount) {
		this.r212_pse_50_acceptance_amount = r212_pse_50_acceptance_amount;
	}
	public BigDecimal getR212_pse_50_lcbg_crm() {
		return r212_pse_50_lcbg_crm;
	}
	public void setR212_pse_50_lcbg_crm(BigDecimal r212_pse_50_lcbg_crm) {
		this.r212_pse_50_lcbg_crm = r212_pse_50_lcbg_crm;
	}
	public BigDecimal getR212_pse_50_rwa() {
		return r212_pse_50_rwa;
	}
	public void setR212_pse_50_rwa(BigDecimal r212_pse_50_rwa) {
		this.r212_pse_50_rwa = r212_pse_50_rwa;
	}
	public BigDecimal getR212_pse_50_under_ccf_amt() {
		return r212_pse_50_under_ccf_amt;
	}
	public void setR212_pse_50_under_ccf_amt(BigDecimal r212_pse_50_under_ccf_amt) {
		this.r212_pse_50_under_ccf_amt = r212_pse_50_under_ccf_amt;
	}
	public BigDecimal getR213_pse_50_lcbg_balance() {
		return r213_pse_50_lcbg_balance;
	}
	public void setR213_pse_50_lcbg_balance(BigDecimal r213_pse_50_lcbg_balance) {
		this.r213_pse_50_lcbg_balance = r213_pse_50_lcbg_balance;
	}
	public BigDecimal getR213_pse_50_acceptance_amount() {
		return r213_pse_50_acceptance_amount;
	}
	public void setR213_pse_50_acceptance_amount(BigDecimal r213_pse_50_acceptance_amount) {
		this.r213_pse_50_acceptance_amount = r213_pse_50_acceptance_amount;
	}
	public BigDecimal getR213_pse_50_lcbg_crm() {
		return r213_pse_50_lcbg_crm;
	}
	public void setR213_pse_50_lcbg_crm(BigDecimal r213_pse_50_lcbg_crm) {
		this.r213_pse_50_lcbg_crm = r213_pse_50_lcbg_crm;
	}
	public BigDecimal getR213_pse_50_rwa() {
		return r213_pse_50_rwa;
	}
	public void setR213_pse_50_rwa(BigDecimal r213_pse_50_rwa) {
		this.r213_pse_50_rwa = r213_pse_50_rwa;
	}
	public BigDecimal getR213_pse_50_under_ccf_amt() {
		return r213_pse_50_under_ccf_amt;
	}
	public void setR213_pse_50_under_ccf_amt(BigDecimal r213_pse_50_under_ccf_amt) {
		this.r213_pse_50_under_ccf_amt = r213_pse_50_under_ccf_amt;
	}
	public BigDecimal getR214_pse_50_lcbg_balance() {
		return r214_pse_50_lcbg_balance;
	}
	public void setR214_pse_50_lcbg_balance(BigDecimal r214_pse_50_lcbg_balance) {
		this.r214_pse_50_lcbg_balance = r214_pse_50_lcbg_balance;
	}
	public BigDecimal getR214_pse_50_acceptance_amount() {
		return r214_pse_50_acceptance_amount;
	}
	public void setR214_pse_50_acceptance_amount(BigDecimal r214_pse_50_acceptance_amount) {
		this.r214_pse_50_acceptance_amount = r214_pse_50_acceptance_amount;
	}
	public BigDecimal getR214_pse_50_lcbg_crm() {
		return r214_pse_50_lcbg_crm;
	}
	public void setR214_pse_50_lcbg_crm(BigDecimal r214_pse_50_lcbg_crm) {
		this.r214_pse_50_lcbg_crm = r214_pse_50_lcbg_crm;
	}
	public BigDecimal getR214_pse_50_rwa() {
		return r214_pse_50_rwa;
	}
	public void setR214_pse_50_rwa(BigDecimal r214_pse_50_rwa) {
		this.r214_pse_50_rwa = r214_pse_50_rwa;
	}
	public BigDecimal getR214_pse_50_under_ccf_amt() {
		return r214_pse_50_under_ccf_amt;
	}
	public void setR214_pse_50_under_ccf_amt(BigDecimal r214_pse_50_under_ccf_amt) {
		this.r214_pse_50_under_ccf_amt = r214_pse_50_under_ccf_amt;
	}
	public BigDecimal getR215_pse_lcbg_balance() {
		return r215_pse_lcbg_balance;
	}
	public void setR215_pse_lcbg_balance(BigDecimal r215_pse_lcbg_balance) {
		this.r215_pse_lcbg_balance = r215_pse_lcbg_balance;
	}
	public BigDecimal getR215_pse_acceptance_amount() {
		return r215_pse_acceptance_amount;
	}
	public void setR215_pse_acceptance_amount(BigDecimal r215_pse_acceptance_amount) {
		this.r215_pse_acceptance_amount = r215_pse_acceptance_amount;
	}
	public BigDecimal getR215_pse_lcbg_crm() {
		return r215_pse_lcbg_crm;
	}
	public void setR215_pse_lcbg_crm(BigDecimal r215_pse_lcbg_crm) {
		this.r215_pse_lcbg_crm = r215_pse_lcbg_crm;
	}
	public BigDecimal getR215_pse_rwa() {
		return r215_pse_rwa;
	}
	public void setR215_pse_rwa(BigDecimal r215_pse_rwa) {
		this.r215_pse_rwa = r215_pse_rwa;
	}
	public BigDecimal getR215_pse_under_ccf_amt() {
		return r215_pse_under_ccf_amt;
	}
	public void setR215_pse_under_ccf_amt(BigDecimal r215_pse_under_ccf_amt) {
		this.r215_pse_under_ccf_amt = r215_pse_under_ccf_amt;
	}
	public BigDecimal getR216_pse_100_lcbg_balance() {
		return r216_pse_100_lcbg_balance;
	}
	public void setR216_pse_100_lcbg_balance(BigDecimal r216_pse_100_lcbg_balance) {
		this.r216_pse_100_lcbg_balance = r216_pse_100_lcbg_balance;
	}
	public BigDecimal getR216_pse_100_acceptance_amount() {
		return r216_pse_100_acceptance_amount;
	}
	public void setR216_pse_100_acceptance_amount(BigDecimal r216_pse_100_acceptance_amount) {
		this.r216_pse_100_acceptance_amount = r216_pse_100_acceptance_amount;
	}
	public BigDecimal getR216_pse_100_lcbg_crm() {
		return r216_pse_100_lcbg_crm;
	}
	public void setR216_pse_100_lcbg_crm(BigDecimal r216_pse_100_lcbg_crm) {
		this.r216_pse_100_lcbg_crm = r216_pse_100_lcbg_crm;
	}
	public BigDecimal getR216_pse_100_rwa() {
		return r216_pse_100_rwa;
	}
	public void setR216_pse_100_rwa(BigDecimal r216_pse_100_rwa) {
		this.r216_pse_100_rwa = r216_pse_100_rwa;
	}
	public BigDecimal getR216_pse_100_under_ccf_amt() {
		return r216_pse_100_under_ccf_amt;
	}
	public void setR216_pse_100_under_ccf_amt(BigDecimal r216_pse_100_under_ccf_amt) {
		this.r216_pse_100_under_ccf_amt = r216_pse_100_under_ccf_amt;
	}
	public BigDecimal getR217_pse_100_lcbg_balance() {
		return r217_pse_100_lcbg_balance;
	}
	public void setR217_pse_100_lcbg_balance(BigDecimal r217_pse_100_lcbg_balance) {
		this.r217_pse_100_lcbg_balance = r217_pse_100_lcbg_balance;
	}
	public BigDecimal getR217_pse_100_acceptance_amount() {
		return r217_pse_100_acceptance_amount;
	}
	public void setR217_pse_100_acceptance_amount(BigDecimal r217_pse_100_acceptance_amount) {
		this.r217_pse_100_acceptance_amount = r217_pse_100_acceptance_amount;
	}
	public BigDecimal getR217_pse_100_lcbg_crm() {
		return r217_pse_100_lcbg_crm;
	}
	public void setR217_pse_100_lcbg_crm(BigDecimal r217_pse_100_lcbg_crm) {
		this.r217_pse_100_lcbg_crm = r217_pse_100_lcbg_crm;
	}
	public BigDecimal getR217_pse_100_rwa() {
		return r217_pse_100_rwa;
	}
	public void setR217_pse_100_rwa(BigDecimal r217_pse_100_rwa) {
		this.r217_pse_100_rwa = r217_pse_100_rwa;
	}
	public BigDecimal getR217_pse_100_under_ccf_amt() {
		return r217_pse_100_under_ccf_amt;
	}
	public void setR217_pse_100_under_ccf_amt(BigDecimal r217_pse_100_under_ccf_amt) {
		this.r217_pse_100_under_ccf_amt = r217_pse_100_under_ccf_amt;
	}
	public BigDecimal getR218_pse_100_lcbg_balance() {
		return r218_pse_100_lcbg_balance;
	}
	public void setR218_pse_100_lcbg_balance(BigDecimal r218_pse_100_lcbg_balance) {
		this.r218_pse_100_lcbg_balance = r218_pse_100_lcbg_balance;
	}
	public BigDecimal getR218_pse_100_acceptance_amount() {
		return r218_pse_100_acceptance_amount;
	}
	public void setR218_pse_100_acceptance_amount(BigDecimal r218_pse_100_acceptance_amount) {
		this.r218_pse_100_acceptance_amount = r218_pse_100_acceptance_amount;
	}
	public BigDecimal getR218_pse_100_lcbg_crm() {
		return r218_pse_100_lcbg_crm;
	}
	public void setR218_pse_100_lcbg_crm(BigDecimal r218_pse_100_lcbg_crm) {
		this.r218_pse_100_lcbg_crm = r218_pse_100_lcbg_crm;
	}
	public BigDecimal getR218_pse_100_rwa() {
		return r218_pse_100_rwa;
	}
	public void setR218_pse_100_rwa(BigDecimal r218_pse_100_rwa) {
		this.r218_pse_100_rwa = r218_pse_100_rwa;
	}
	public BigDecimal getR218_pse_100_under_ccf_amt() {
		return r218_pse_100_under_ccf_amt;
	}
	public void setR218_pse_100_under_ccf_amt(BigDecimal r218_pse_100_under_ccf_amt) {
		this.r218_pse_100_under_ccf_amt = r218_pse_100_under_ccf_amt;
	}
	public BigDecimal getR219_pse_lcbg_balance() {
		return r219_pse_lcbg_balance;
	}
	public void setR219_pse_lcbg_balance(BigDecimal r219_pse_lcbg_balance) {
		this.r219_pse_lcbg_balance = r219_pse_lcbg_balance;
	}
	public BigDecimal getR219_pse_acceptance_amount() {
		return r219_pse_acceptance_amount;
	}
	public void setR219_pse_acceptance_amount(BigDecimal r219_pse_acceptance_amount) {
		this.r219_pse_acceptance_amount = r219_pse_acceptance_amount;
	}
	public BigDecimal getR219_pse_lcbg_crm() {
		return r219_pse_lcbg_crm;
	}
	public void setR219_pse_lcbg_crm(BigDecimal r219_pse_lcbg_crm) {
		this.r219_pse_lcbg_crm = r219_pse_lcbg_crm;
	}
	public BigDecimal getR219_pse_rwa() {
		return r219_pse_rwa;
	}
	public void setR219_pse_rwa(BigDecimal r219_pse_rwa) {
		this.r219_pse_rwa = r219_pse_rwa;
	}
	public BigDecimal getR219_pse_under_ccf_amt() {
		return r219_pse_under_ccf_amt;
	}
	public void setR219_pse_under_ccf_amt(BigDecimal r219_pse_under_ccf_amt) {
		this.r219_pse_under_ccf_amt = r219_pse_under_ccf_amt;
	}
	public BigDecimal getR220_pse_150_lcbg_balance() {
		return r220_pse_150_lcbg_balance;
	}
	public void setR220_pse_150_lcbg_balance(BigDecimal r220_pse_150_lcbg_balance) {
		this.r220_pse_150_lcbg_balance = r220_pse_150_lcbg_balance;
	}
	public BigDecimal getR220_pse_150_acceptance_amount() {
		return r220_pse_150_acceptance_amount;
	}
	public void setR220_pse_150_acceptance_amount(BigDecimal r220_pse_150_acceptance_amount) {
		this.r220_pse_150_acceptance_amount = r220_pse_150_acceptance_amount;
	}
	public BigDecimal getR220_pse_150_lcbg_crm() {
		return r220_pse_150_lcbg_crm;
	}
	public void setR220_pse_150_lcbg_crm(BigDecimal r220_pse_150_lcbg_crm) {
		this.r220_pse_150_lcbg_crm = r220_pse_150_lcbg_crm;
	}
	public BigDecimal getR220_pse_150_rwa() {
		return r220_pse_150_rwa;
	}
	public void setR220_pse_150_rwa(BigDecimal r220_pse_150_rwa) {
		this.r220_pse_150_rwa = r220_pse_150_rwa;
	}
	public BigDecimal getR220_pse_150_under_ccf_amt() {
		return r220_pse_150_under_ccf_amt;
	}
	public void setR220_pse_150_under_ccf_amt(BigDecimal r220_pse_150_under_ccf_amt) {
		this.r220_pse_150_under_ccf_amt = r220_pse_150_under_ccf_amt;
	}
	public BigDecimal getR221_pse_150_lcbg_balance() {
		return r221_pse_150_lcbg_balance;
	}
	public void setR221_pse_150_lcbg_balance(BigDecimal r221_pse_150_lcbg_balance) {
		this.r221_pse_150_lcbg_balance = r221_pse_150_lcbg_balance;
	}
	public BigDecimal getR221_pse_150_acceptance_amount() {
		return r221_pse_150_acceptance_amount;
	}
	public void setR221_pse_150_acceptance_amount(BigDecimal r221_pse_150_acceptance_amount) {
		this.r221_pse_150_acceptance_amount = r221_pse_150_acceptance_amount;
	}
	public BigDecimal getR221_pse_150_lcbg_crm() {
		return r221_pse_150_lcbg_crm;
	}
	public void setR221_pse_150_lcbg_crm(BigDecimal r221_pse_150_lcbg_crm) {
		this.r221_pse_150_lcbg_crm = r221_pse_150_lcbg_crm;
	}
	public BigDecimal getR221_pse_150_rwa() {
		return r221_pse_150_rwa;
	}
	public void setR221_pse_150_rwa(BigDecimal r221_pse_150_rwa) {
		this.r221_pse_150_rwa = r221_pse_150_rwa;
	}
	public BigDecimal getR221_pse_150_under_ccf_amt() {
		return r221_pse_150_under_ccf_amt;
	}
	public void setR221_pse_150_under_ccf_amt(BigDecimal r221_pse_150_under_ccf_amt) {
		this.r221_pse_150_under_ccf_amt = r221_pse_150_under_ccf_amt;
	}
	public BigDecimal getR222_pse_150_lcbg_balance() {
		return r222_pse_150_lcbg_balance;
	}
	public void setR222_pse_150_lcbg_balance(BigDecimal r222_pse_150_lcbg_balance) {
		this.r222_pse_150_lcbg_balance = r222_pse_150_lcbg_balance;
	}
	public BigDecimal getR222_pse_150_acceptance_amount() {
		return r222_pse_150_acceptance_amount;
	}
	public void setR222_pse_150_acceptance_amount(BigDecimal r222_pse_150_acceptance_amount) {
		this.r222_pse_150_acceptance_amount = r222_pse_150_acceptance_amount;
	}
	public BigDecimal getR222_pse_150_lcbg_crm() {
		return r222_pse_150_lcbg_crm;
	}
	public void setR222_pse_150_lcbg_crm(BigDecimal r222_pse_150_lcbg_crm) {
		this.r222_pse_150_lcbg_crm = r222_pse_150_lcbg_crm;
	}
	public BigDecimal getR222_pse_150_rwa() {
		return r222_pse_150_rwa;
	}
	public void setR222_pse_150_rwa(BigDecimal r222_pse_150_rwa) {
		this.r222_pse_150_rwa = r222_pse_150_rwa;
	}
	public BigDecimal getR222_pse_150_under_ccf_amt() {
		return r222_pse_150_under_ccf_amt;
	}
	public void setR222_pse_150_under_ccf_amt(BigDecimal r222_pse_150_under_ccf_amt) {
		this.r222_pse_150_under_ccf_amt = r222_pse_150_under_ccf_amt;
	}
	public BigDecimal getR223_pse_lcbg_balance() {
		return r223_pse_lcbg_balance;
	}
	public void setR223_pse_lcbg_balance(BigDecimal r223_pse_lcbg_balance) {
		this.r223_pse_lcbg_balance = r223_pse_lcbg_balance;
	}
	public BigDecimal getR223_pse_acceptance_amount() {
		return r223_pse_acceptance_amount;
	}
	public void setR223_pse_acceptance_amount(BigDecimal r223_pse_acceptance_amount) {
		this.r223_pse_acceptance_amount = r223_pse_acceptance_amount;
	}
	public BigDecimal getR223_pse_lcbg_crm() {
		return r223_pse_lcbg_crm;
	}
	public void setR223_pse_lcbg_crm(BigDecimal r223_pse_lcbg_crm) {
		this.r223_pse_lcbg_crm = r223_pse_lcbg_crm;
	}
	public BigDecimal getR223_pse_rwa() {
		return r223_pse_rwa;
	}
	public void setR223_pse_rwa(BigDecimal r223_pse_rwa) {
		this.r223_pse_rwa = r223_pse_rwa;
	}
	public BigDecimal getR223_pse_under_ccf_amt() {
		return r223_pse_under_ccf_amt;
	}
	public void setR223_pse_under_ccf_amt(BigDecimal r223_pse_under_ccf_amt) {
		this.r223_pse_under_ccf_amt = r223_pse_under_ccf_amt;
	}
	public BigDecimal getR224_res_35_lcbg_balance() {
		return r224_res_35_lcbg_balance;
	}
	public void setR224_res_35_lcbg_balance(BigDecimal r224_res_35_lcbg_balance) {
		this.r224_res_35_lcbg_balance = r224_res_35_lcbg_balance;
	}
	public BigDecimal getR224_res_35_acceptance_amount() {
		return r224_res_35_acceptance_amount;
	}
	public void setR224_res_35_acceptance_amount(BigDecimal r224_res_35_acceptance_amount) {
		this.r224_res_35_acceptance_amount = r224_res_35_acceptance_amount;
	}
	public BigDecimal getR224_res_35_lcbg_crm() {
		return r224_res_35_lcbg_crm;
	}
	public void setR224_res_35_lcbg_crm(BigDecimal r224_res_35_lcbg_crm) {
		this.r224_res_35_lcbg_crm = r224_res_35_lcbg_crm;
	}
	public BigDecimal getR224_res_35_rwa() {
		return r224_res_35_rwa;
	}
	public void setR224_res_35_rwa(BigDecimal r224_res_35_rwa) {
		this.r224_res_35_rwa = r224_res_35_rwa;
	}
	public BigDecimal getR224_res_35_under_ccf_amt() {
		return r224_res_35_under_ccf_amt;
	}
	public void setR224_res_35_under_ccf_amt(BigDecimal r224_res_35_under_ccf_amt) {
		this.r224_res_35_under_ccf_amt = r224_res_35_under_ccf_amt;
	}
	public BigDecimal getR225_res_35_lcbg_balance() {
		return r225_res_35_lcbg_balance;
	}
	public void setR225_res_35_lcbg_balance(BigDecimal r225_res_35_lcbg_balance) {
		this.r225_res_35_lcbg_balance = r225_res_35_lcbg_balance;
	}
	public BigDecimal getR225_res_35_acceptance_amount() {
		return r225_res_35_acceptance_amount;
	}
	public void setR225_res_35_acceptance_amount(BigDecimal r225_res_35_acceptance_amount) {
		this.r225_res_35_acceptance_amount = r225_res_35_acceptance_amount;
	}
	public BigDecimal getR225_res_35_lcbg_crm() {
		return r225_res_35_lcbg_crm;
	}
	public void setR225_res_35_lcbg_crm(BigDecimal r225_res_35_lcbg_crm) {
		this.r225_res_35_lcbg_crm = r225_res_35_lcbg_crm;
	}
	public BigDecimal getR225_res_35_rwa() {
		return r225_res_35_rwa;
	}
	public void setR225_res_35_rwa(BigDecimal r225_res_35_rwa) {
		this.r225_res_35_rwa = r225_res_35_rwa;
	}
	public BigDecimal getR225_res_35_under_ccf_amt() {
		return r225_res_35_under_ccf_amt;
	}
	public void setR225_res_35_under_ccf_amt(BigDecimal r225_res_35_under_ccf_amt) {
		this.r225_res_35_under_ccf_amt = r225_res_35_under_ccf_amt;
	}
	public BigDecimal getR226_res_35_lcbg_balance() {
		return r226_res_35_lcbg_balance;
	}
	public void setR226_res_35_lcbg_balance(BigDecimal r226_res_35_lcbg_balance) {
		this.r226_res_35_lcbg_balance = r226_res_35_lcbg_balance;
	}
	public BigDecimal getR226_res_35_acceptance_amount() {
		return r226_res_35_acceptance_amount;
	}
	public void setR226_res_35_acceptance_amount(BigDecimal r226_res_35_acceptance_amount) {
		this.r226_res_35_acceptance_amount = r226_res_35_acceptance_amount;
	}
	public BigDecimal getR226_res_35_lcbg_crm() {
		return r226_res_35_lcbg_crm;
	}
	public void setR226_res_35_lcbg_crm(BigDecimal r226_res_35_lcbg_crm) {
		this.r226_res_35_lcbg_crm = r226_res_35_lcbg_crm;
	}
	public BigDecimal getR226_res_35_rwa() {
		return r226_res_35_rwa;
	}
	public void setR226_res_35_rwa(BigDecimal r226_res_35_rwa) {
		this.r226_res_35_rwa = r226_res_35_rwa;
	}
	public BigDecimal getR226_res_35_under_ccf_amt() {
		return r226_res_35_under_ccf_amt;
	}
	public void setR226_res_35_under_ccf_amt(BigDecimal r226_res_35_under_ccf_amt) {
		this.r226_res_35_under_ccf_amt = r226_res_35_under_ccf_amt;
	}
	public BigDecimal getR227_res_lcbg_balance() {
		return r227_res_lcbg_balance;
	}
	public void setR227_res_lcbg_balance(BigDecimal r227_res_lcbg_balance) {
		this.r227_res_lcbg_balance = r227_res_lcbg_balance;
	}
	public BigDecimal getR227_res_acceptance_amount() {
		return r227_res_acceptance_amount;
	}
	public void setR227_res_acceptance_amount(BigDecimal r227_res_acceptance_amount) {
		this.r227_res_acceptance_amount = r227_res_acceptance_amount;
	}
	public BigDecimal getR227_res_lcbg_crm() {
		return r227_res_lcbg_crm;
	}
	public void setR227_res_lcbg_crm(BigDecimal r227_res_lcbg_crm) {
		this.r227_res_lcbg_crm = r227_res_lcbg_crm;
	}
	public BigDecimal getR227_res_rwa() {
		return r227_res_rwa;
	}
	public void setR227_res_rwa(BigDecimal r227_res_rwa) {
		this.r227_res_rwa = r227_res_rwa;
	}
	public BigDecimal getR227_res_under_ccf_amt() {
		return r227_res_under_ccf_amt;
	}
	public void setR227_res_under_ccf_amt(BigDecimal r227_res_under_ccf_amt) {
		this.r227_res_under_ccf_amt = r227_res_under_ccf_amt;
	}
	public BigDecimal getR228_res_100_lcbg_balance() {
		return r228_res_100_lcbg_balance;
	}
	public void setR228_res_100_lcbg_balance(BigDecimal r228_res_100_lcbg_balance) {
		this.r228_res_100_lcbg_balance = r228_res_100_lcbg_balance;
	}
	public BigDecimal getR228_res_100_acceptance_amount() {
		return r228_res_100_acceptance_amount;
	}
	public void setR228_res_100_acceptance_amount(BigDecimal r228_res_100_acceptance_amount) {
		this.r228_res_100_acceptance_amount = r228_res_100_acceptance_amount;
	}
	public BigDecimal getR228_res_100_lcbg_crm() {
		return r228_res_100_lcbg_crm;
	}
	public void setR228_res_100_lcbg_crm(BigDecimal r228_res_100_lcbg_crm) {
		this.r228_res_100_lcbg_crm = r228_res_100_lcbg_crm;
	}
	public BigDecimal getR228_res_100_rwa() {
		return r228_res_100_rwa;
	}
	public void setR228_res_100_rwa(BigDecimal r228_res_100_rwa) {
		this.r228_res_100_rwa = r228_res_100_rwa;
	}
	public BigDecimal getR228_res_100_under_ccf_amt() {
		return r228_res_100_under_ccf_amt;
	}
	public void setR228_res_100_under_ccf_amt(BigDecimal r228_res_100_under_ccf_amt) {
		this.r228_res_100_under_ccf_amt = r228_res_100_under_ccf_amt;
	}
	public BigDecimal getR229_res_100_lcbg_balance() {
		return r229_res_100_lcbg_balance;
	}
	public void setR229_res_100_lcbg_balance(BigDecimal r229_res_100_lcbg_balance) {
		this.r229_res_100_lcbg_balance = r229_res_100_lcbg_balance;
	}
	public BigDecimal getR229_res_100_acceptance_amount() {
		return r229_res_100_acceptance_amount;
	}
	public void setR229_res_100_acceptance_amount(BigDecimal r229_res_100_acceptance_amount) {
		this.r229_res_100_acceptance_amount = r229_res_100_acceptance_amount;
	}
	public BigDecimal getR229_res_100_lcbg_crm() {
		return r229_res_100_lcbg_crm;
	}
	public void setR229_res_100_lcbg_crm(BigDecimal r229_res_100_lcbg_crm) {
		this.r229_res_100_lcbg_crm = r229_res_100_lcbg_crm;
	}
	public BigDecimal getR229_res_100_rwa() {
		return r229_res_100_rwa;
	}
	public void setR229_res_100_rwa(BigDecimal r229_res_100_rwa) {
		this.r229_res_100_rwa = r229_res_100_rwa;
	}
	public BigDecimal getR229_res_100_under_ccf_amt() {
		return r229_res_100_under_ccf_amt;
	}
	public void setR229_res_100_under_ccf_amt(BigDecimal r229_res_100_under_ccf_amt) {
		this.r229_res_100_under_ccf_amt = r229_res_100_under_ccf_amt;
	}
	public BigDecimal getR230_res_100_lcbg_balance() {
		return r230_res_100_lcbg_balance;
	}
	public void setR230_res_100_lcbg_balance(BigDecimal r230_res_100_lcbg_balance) {
		this.r230_res_100_lcbg_balance = r230_res_100_lcbg_balance;
	}
	public BigDecimal getR230_res_100_acceptance_amount() {
		return r230_res_100_acceptance_amount;
	}
	public void setR230_res_100_acceptance_amount(BigDecimal r230_res_100_acceptance_amount) {
		this.r230_res_100_acceptance_amount = r230_res_100_acceptance_amount;
	}
	public BigDecimal getR230_res_100_lcbg_crm() {
		return r230_res_100_lcbg_crm;
	}
	public void setR230_res_100_lcbg_crm(BigDecimal r230_res_100_lcbg_crm) {
		this.r230_res_100_lcbg_crm = r230_res_100_lcbg_crm;
	}
	public BigDecimal getR230_res_100_rwa() {
		return r230_res_100_rwa;
	}
	public void setR230_res_100_rwa(BigDecimal r230_res_100_rwa) {
		this.r230_res_100_rwa = r230_res_100_rwa;
	}
	public BigDecimal getR230_res_100_under_ccf_amt() {
		return r230_res_100_under_ccf_amt;
	}
	public void setR230_res_100_under_ccf_amt(BigDecimal r230_res_100_under_ccf_amt) {
		this.r230_res_100_under_ccf_amt = r230_res_100_under_ccf_amt;
	}
	public BigDecimal getR231_res_lcbg_balance() {
		return r231_res_lcbg_balance;
	}
	public void setR231_res_lcbg_balance(BigDecimal r231_res_lcbg_balance) {
		this.r231_res_lcbg_balance = r231_res_lcbg_balance;
	}
	public BigDecimal getR231_res_acceptance_amount() {
		return r231_res_acceptance_amount;
	}
	public void setR231_res_acceptance_amount(BigDecimal r231_res_acceptance_amount) {
		this.r231_res_acceptance_amount = r231_res_acceptance_amount;
	}
	public BigDecimal getR231_res_lcbg_crm() {
		return r231_res_lcbg_crm;
	}
	public void setR231_res_lcbg_crm(BigDecimal r231_res_lcbg_crm) {
		this.r231_res_lcbg_crm = r231_res_lcbg_crm;
	}
	public BigDecimal getR231_res_rwa() {
		return r231_res_rwa;
	}
	public void setR231_res_rwa(BigDecimal r231_res_rwa) {
		this.r231_res_rwa = r231_res_rwa;
	}
	public BigDecimal getR231_res_under_ccf_amt() {
		return r231_res_under_ccf_amt;
	}
	public void setR231_res_under_ccf_amt(BigDecimal r231_res_under_ccf_amt) {
		this.r231_res_under_ccf_amt = r231_res_under_ccf_amt;
	}
	public BigDecimal getR232_rrp_75_lcbg_balance() {
		return r232_rrp_75_lcbg_balance;
	}
	public void setR232_rrp_75_lcbg_balance(BigDecimal r232_rrp_75_lcbg_balance) {
		this.r232_rrp_75_lcbg_balance = r232_rrp_75_lcbg_balance;
	}
	public BigDecimal getR232_rrp_75_acceptance_amount() {
		return r232_rrp_75_acceptance_amount;
	}
	public void setR232_rrp_75_acceptance_amount(BigDecimal r232_rrp_75_acceptance_amount) {
		this.r232_rrp_75_acceptance_amount = r232_rrp_75_acceptance_amount;
	}
	public BigDecimal getR232_rrp_75_lcbg_crm() {
		return r232_rrp_75_lcbg_crm;
	}
	public void setR232_rrp_75_lcbg_crm(BigDecimal r232_rrp_75_lcbg_crm) {
		this.r232_rrp_75_lcbg_crm = r232_rrp_75_lcbg_crm;
	}
	public BigDecimal getR232_rrp_75_rwa() {
		return r232_rrp_75_rwa;
	}
	public void setR232_rrp_75_rwa(BigDecimal r232_rrp_75_rwa) {
		this.r232_rrp_75_rwa = r232_rrp_75_rwa;
	}
	public BigDecimal getR232_rrp_75_under_ccf_amt() {
		return r232_rrp_75_under_ccf_amt;
	}
	public void setR232_rrp_75_under_ccf_amt(BigDecimal r232_rrp_75_under_ccf_amt) {
		this.r232_rrp_75_under_ccf_amt = r232_rrp_75_under_ccf_amt;
	}
	public BigDecimal getR233_rrp_75_lcbg_balance() {
		return r233_rrp_75_lcbg_balance;
	}
	public void setR233_rrp_75_lcbg_balance(BigDecimal r233_rrp_75_lcbg_balance) {
		this.r233_rrp_75_lcbg_balance = r233_rrp_75_lcbg_balance;
	}
	public BigDecimal getR233_rrp_75_acceptance_amount() {
		return r233_rrp_75_acceptance_amount;
	}
	public void setR233_rrp_75_acceptance_amount(BigDecimal r233_rrp_75_acceptance_amount) {
		this.r233_rrp_75_acceptance_amount = r233_rrp_75_acceptance_amount;
	}
	public BigDecimal getR233_rrp_75_lcbg_crm() {
		return r233_rrp_75_lcbg_crm;
	}
	public void setR233_rrp_75_lcbg_crm(BigDecimal r233_rrp_75_lcbg_crm) {
		this.r233_rrp_75_lcbg_crm = r233_rrp_75_lcbg_crm;
	}
	public BigDecimal getR233_rrp_75_rwa() {
		return r233_rrp_75_rwa;
	}
	public void setR233_rrp_75_rwa(BigDecimal r233_rrp_75_rwa) {
		this.r233_rrp_75_rwa = r233_rrp_75_rwa;
	}
	public BigDecimal getR233_rrp_75_under_ccf_amt() {
		return r233_rrp_75_under_ccf_amt;
	}
	public void setR233_rrp_75_under_ccf_amt(BigDecimal r233_rrp_75_under_ccf_amt) {
		this.r233_rrp_75_under_ccf_amt = r233_rrp_75_under_ccf_amt;
	}
	public BigDecimal getR234_rrp_75_lcbg_balance() {
		return r234_rrp_75_lcbg_balance;
	}
	public void setR234_rrp_75_lcbg_balance(BigDecimal r234_rrp_75_lcbg_balance) {
		this.r234_rrp_75_lcbg_balance = r234_rrp_75_lcbg_balance;
	}
	public BigDecimal getR234_rrp_75_acceptance_amount() {
		return r234_rrp_75_acceptance_amount;
	}
	public void setR234_rrp_75_acceptance_amount(BigDecimal r234_rrp_75_acceptance_amount) {
		this.r234_rrp_75_acceptance_amount = r234_rrp_75_acceptance_amount;
	}
	public BigDecimal getR234_rrp_75_lcbg_crm() {
		return r234_rrp_75_lcbg_crm;
	}
	public void setR234_rrp_75_lcbg_crm(BigDecimal r234_rrp_75_lcbg_crm) {
		this.r234_rrp_75_lcbg_crm = r234_rrp_75_lcbg_crm;
	}
	public BigDecimal getR234_rrp_75_rwa() {
		return r234_rrp_75_rwa;
	}
	public void setR234_rrp_75_rwa(BigDecimal r234_rrp_75_rwa) {
		this.r234_rrp_75_rwa = r234_rrp_75_rwa;
	}
	public BigDecimal getR234_rrp_75_under_ccf_amt() {
		return r234_rrp_75_under_ccf_amt;
	}
	public void setR234_rrp_75_under_ccf_amt(BigDecimal r234_rrp_75_under_ccf_amt) {
		this.r234_rrp_75_under_ccf_amt = r234_rrp_75_under_ccf_amt;
	}
	public BigDecimal getR235_rrp_lcbg_balance() {
		return r235_rrp_lcbg_balance;
	}
	public void setR235_rrp_lcbg_balance(BigDecimal r235_rrp_lcbg_balance) {
		this.r235_rrp_lcbg_balance = r235_rrp_lcbg_balance;
	}
	public BigDecimal getR235_rrp_acceptance_amount() {
		return r235_rrp_acceptance_amount;
	}
	public void setR235_rrp_acceptance_amount(BigDecimal r235_rrp_acceptance_amount) {
		this.r235_rrp_acceptance_amount = r235_rrp_acceptance_amount;
	}
	public BigDecimal getR235_rrp_lcbg_crm() {
		return r235_rrp_lcbg_crm;
	}
	public void setR235_rrp_lcbg_crm(BigDecimal r235_rrp_lcbg_crm) {
		this.r235_rrp_lcbg_crm = r235_rrp_lcbg_crm;
	}
	public BigDecimal getR235_rrp_rwa() {
		return r235_rrp_rwa;
	}
	public void setR235_rrp_rwa(BigDecimal r235_rrp_rwa) {
		this.r235_rrp_rwa = r235_rrp_rwa;
	}
	public BigDecimal getR235_rrp_under_ccf_amt() {
		return r235_rrp_under_ccf_amt;
	}
	public void setR235_rrp_under_ccf_amt(BigDecimal r235_rrp_under_ccf_amt) {
		this.r235_rrp_under_ccf_amt = r235_rrp_under_ccf_amt;
	}
	public BigDecimal getR236_rrp_100_lcbg_balance() {
		return r236_rrp_100_lcbg_balance;
	}
	public void setR236_rrp_100_lcbg_balance(BigDecimal r236_rrp_100_lcbg_balance) {
		this.r236_rrp_100_lcbg_balance = r236_rrp_100_lcbg_balance;
	}
	public BigDecimal getR236_rrp_100_acceptance_amount() {
		return r236_rrp_100_acceptance_amount;
	}
	public void setR236_rrp_100_acceptance_amount(BigDecimal r236_rrp_100_acceptance_amount) {
		this.r236_rrp_100_acceptance_amount = r236_rrp_100_acceptance_amount;
	}
	public BigDecimal getR236_rrp_100_lcbg_crm() {
		return r236_rrp_100_lcbg_crm;
	}
	public void setR236_rrp_100_lcbg_crm(BigDecimal r236_rrp_100_lcbg_crm) {
		this.r236_rrp_100_lcbg_crm = r236_rrp_100_lcbg_crm;
	}
	public BigDecimal getR236_rrp_100_rwa() {
		return r236_rrp_100_rwa;
	}
	public void setR236_rrp_100_rwa(BigDecimal r236_rrp_100_rwa) {
		this.r236_rrp_100_rwa = r236_rrp_100_rwa;
	}
	public BigDecimal getR236_rrp_100_under_ccf_amt() {
		return r236_rrp_100_under_ccf_amt;
	}
	public void setR236_rrp_100_under_ccf_amt(BigDecimal r236_rrp_100_under_ccf_amt) {
		this.r236_rrp_100_under_ccf_amt = r236_rrp_100_under_ccf_amt;
	}
	public BigDecimal getR237_rrp_100_lcbg_balance() {
		return r237_rrp_100_lcbg_balance;
	}
	public void setR237_rrp_100_lcbg_balance(BigDecimal r237_rrp_100_lcbg_balance) {
		this.r237_rrp_100_lcbg_balance = r237_rrp_100_lcbg_balance;
	}
	public BigDecimal getR237_rrp_100_acceptance_amount() {
		return r237_rrp_100_acceptance_amount;
	}
	public void setR237_rrp_100_acceptance_amount(BigDecimal r237_rrp_100_acceptance_amount) {
		this.r237_rrp_100_acceptance_amount = r237_rrp_100_acceptance_amount;
	}
	public BigDecimal getR237_rrp_100_lcbg_crm() {
		return r237_rrp_100_lcbg_crm;
	}
	public void setR237_rrp_100_lcbg_crm(BigDecimal r237_rrp_100_lcbg_crm) {
		this.r237_rrp_100_lcbg_crm = r237_rrp_100_lcbg_crm;
	}
	public BigDecimal getR237_rrp_100_rwa() {
		return r237_rrp_100_rwa;
	}
	public void setR237_rrp_100_rwa(BigDecimal r237_rrp_100_rwa) {
		this.r237_rrp_100_rwa = r237_rrp_100_rwa;
	}
	public BigDecimal getR237_rrp_100_under_ccf_amt() {
		return r237_rrp_100_under_ccf_amt;
	}
	public void setR237_rrp_100_under_ccf_amt(BigDecimal r237_rrp_100_under_ccf_amt) {
		this.r237_rrp_100_under_ccf_amt = r237_rrp_100_under_ccf_amt;
	}
	public BigDecimal getR238_rrp_100_lcbg_balance() {
		return r238_rrp_100_lcbg_balance;
	}
	public void setR238_rrp_100_lcbg_balance(BigDecimal r238_rrp_100_lcbg_balance) {
		this.r238_rrp_100_lcbg_balance = r238_rrp_100_lcbg_balance;
	}
	public BigDecimal getR238_rrp_100_acceptance_amount() {
		return r238_rrp_100_acceptance_amount;
	}
	public void setR238_rrp_100_acceptance_amount(BigDecimal r238_rrp_100_acceptance_amount) {
		this.r238_rrp_100_acceptance_amount = r238_rrp_100_acceptance_amount;
	}
	public BigDecimal getR238_rrp_100_lcbg_crm() {
		return r238_rrp_100_lcbg_crm;
	}
	public void setR238_rrp_100_lcbg_crm(BigDecimal r238_rrp_100_lcbg_crm) {
		this.r238_rrp_100_lcbg_crm = r238_rrp_100_lcbg_crm;
	}
	public BigDecimal getR238_rrp_100_rwa() {
		return r238_rrp_100_rwa;
	}
	public void setR238_rrp_100_rwa(BigDecimal r238_rrp_100_rwa) {
		this.r238_rrp_100_rwa = r238_rrp_100_rwa;
	}
	public BigDecimal getR238_rrp_100_under_ccf_amt() {
		return r238_rrp_100_under_ccf_amt;
	}
	public void setR238_rrp_100_under_ccf_amt(BigDecimal r238_rrp_100_under_ccf_amt) {
		this.r238_rrp_100_under_ccf_amt = r238_rrp_100_under_ccf_amt;
	}
	public BigDecimal getR239_rrp_lcbg_balance() {
		return r239_rrp_lcbg_balance;
	}
	public void setR239_rrp_lcbg_balance(BigDecimal r239_rrp_lcbg_balance) {
		this.r239_rrp_lcbg_balance = r239_rrp_lcbg_balance;
	}
	public BigDecimal getR239_rrp_acceptance_amount() {
		return r239_rrp_acceptance_amount;
	}
	public void setR239_rrp_acceptance_amount(BigDecimal r239_rrp_acceptance_amount) {
		this.r239_rrp_acceptance_amount = r239_rrp_acceptance_amount;
	}
	public BigDecimal getR239_rrp_lcbg_crm() {
		return r239_rrp_lcbg_crm;
	}
	public void setR239_rrp_lcbg_crm(BigDecimal r239_rrp_lcbg_crm) {
		this.r239_rrp_lcbg_crm = r239_rrp_lcbg_crm;
	}
	public BigDecimal getR239_rrp_rwa() {
		return r239_rrp_rwa;
	}
	public void setR239_rrp_rwa(BigDecimal r239_rrp_rwa) {
		this.r239_rrp_rwa = r239_rrp_rwa;
	}
	public BigDecimal getR239_rrp_under_ccf_amt() {
		return r239_rrp_under_ccf_amt;
	}
	public void setR239_rrp_under_ccf_amt(BigDecimal r239_rrp_under_ccf_amt) {
		this.r239_rrp_under_ccf_amt = r239_rrp_under_ccf_amt;
	}
	public BigDecimal getR240_rrp_75_lcbg_balance() {
		return r240_rrp_75_lcbg_balance;
	}
	public void setR240_rrp_75_lcbg_balance(BigDecimal r240_rrp_75_lcbg_balance) {
		this.r240_rrp_75_lcbg_balance = r240_rrp_75_lcbg_balance;
	}
	public BigDecimal getR240_rrp_75_acceptance_amount() {
		return r240_rrp_75_acceptance_amount;
	}
	public void setR240_rrp_75_acceptance_amount(BigDecimal r240_rrp_75_acceptance_amount) {
		this.r240_rrp_75_acceptance_amount = r240_rrp_75_acceptance_amount;
	}
	public BigDecimal getR240_rrp_75_lcbg_crm() {
		return r240_rrp_75_lcbg_crm;
	}
	public void setR240_rrp_75_lcbg_crm(BigDecimal r240_rrp_75_lcbg_crm) {
		this.r240_rrp_75_lcbg_crm = r240_rrp_75_lcbg_crm;
	}
	public BigDecimal getR240_rrp_75_rwa() {
		return r240_rrp_75_rwa;
	}
	public void setR240_rrp_75_rwa(BigDecimal r240_rrp_75_rwa) {
		this.r240_rrp_75_rwa = r240_rrp_75_rwa;
	}
	public BigDecimal getR240_rrp_75_under_ccf_amt() {
		return r240_rrp_75_under_ccf_amt;
	}
	public void setR240_rrp_75_under_ccf_amt(BigDecimal r240_rrp_75_under_ccf_amt) {
		this.r240_rrp_75_under_ccf_amt = r240_rrp_75_under_ccf_amt;
	}
	public BigDecimal getR241_rrp_75_lcbg_balance() {
		return r241_rrp_75_lcbg_balance;
	}
	public void setR241_rrp_75_lcbg_balance(BigDecimal r241_rrp_75_lcbg_balance) {
		this.r241_rrp_75_lcbg_balance = r241_rrp_75_lcbg_balance;
	}
	public BigDecimal getR241_rrp_75_acceptance_amount() {
		return r241_rrp_75_acceptance_amount;
	}
	public void setR241_rrp_75_acceptance_amount(BigDecimal r241_rrp_75_acceptance_amount) {
		this.r241_rrp_75_acceptance_amount = r241_rrp_75_acceptance_amount;
	}
	public BigDecimal getR241_rrp_75_lcbg_crm() {
		return r241_rrp_75_lcbg_crm;
	}
	public void setR241_rrp_75_lcbg_crm(BigDecimal r241_rrp_75_lcbg_crm) {
		this.r241_rrp_75_lcbg_crm = r241_rrp_75_lcbg_crm;
	}
	public BigDecimal getR241_rrp_75_rwa() {
		return r241_rrp_75_rwa;
	}
	public void setR241_rrp_75_rwa(BigDecimal r241_rrp_75_rwa) {
		this.r241_rrp_75_rwa = r241_rrp_75_rwa;
	}
	public BigDecimal getR241_rrp_75_under_ccf_amt() {
		return r241_rrp_75_under_ccf_amt;
	}
	public void setR241_rrp_75_under_ccf_amt(BigDecimal r241_rrp_75_under_ccf_amt) {
		this.r241_rrp_75_under_ccf_amt = r241_rrp_75_under_ccf_amt;
	}
	public BigDecimal getR242_rrp_75_lcbg_balance() {
		return r242_rrp_75_lcbg_balance;
	}
	public void setR242_rrp_75_lcbg_balance(BigDecimal r242_rrp_75_lcbg_balance) {
		this.r242_rrp_75_lcbg_balance = r242_rrp_75_lcbg_balance;
	}
	public BigDecimal getR242_rrp_75_acceptance_amount() {
		return r242_rrp_75_acceptance_amount;
	}
	public void setR242_rrp_75_acceptance_amount(BigDecimal r242_rrp_75_acceptance_amount) {
		this.r242_rrp_75_acceptance_amount = r242_rrp_75_acceptance_amount;
	}
	public BigDecimal getR242_rrp_75_lcbg_crm() {
		return r242_rrp_75_lcbg_crm;
	}
	public void setR242_rrp_75_lcbg_crm(BigDecimal r242_rrp_75_lcbg_crm) {
		this.r242_rrp_75_lcbg_crm = r242_rrp_75_lcbg_crm;
	}
	public BigDecimal getR242_rrp_75_rwa() {
		return r242_rrp_75_rwa;
	}
	public void setR242_rrp_75_rwa(BigDecimal r242_rrp_75_rwa) {
		this.r242_rrp_75_rwa = r242_rrp_75_rwa;
	}
	public BigDecimal getR242_rrp_75_under_ccf_amt() {
		return r242_rrp_75_under_ccf_amt;
	}
	public void setR242_rrp_75_under_ccf_amt(BigDecimal r242_rrp_75_under_ccf_amt) {
		this.r242_rrp_75_under_ccf_amt = r242_rrp_75_under_ccf_amt;
	}
	public BigDecimal getR243_rrp_lcbg_balance() {
		return r243_rrp_lcbg_balance;
	}
	public void setR243_rrp_lcbg_balance(BigDecimal r243_rrp_lcbg_balance) {
		this.r243_rrp_lcbg_balance = r243_rrp_lcbg_balance;
	}
	public BigDecimal getR243_rrp_acceptance_amount() {
		return r243_rrp_acceptance_amount;
	}
	public void setR243_rrp_acceptance_amount(BigDecimal r243_rrp_acceptance_amount) {
		this.r243_rrp_acceptance_amount = r243_rrp_acceptance_amount;
	}
	public BigDecimal getR243_rrp_lcbg_crm() {
		return r243_rrp_lcbg_crm;
	}
	public void setR243_rrp_lcbg_crm(BigDecimal r243_rrp_lcbg_crm) {
		this.r243_rrp_lcbg_crm = r243_rrp_lcbg_crm;
	}
	public BigDecimal getR243_rrp_rwa() {
		return r243_rrp_rwa;
	}
	public void setR243_rrp_rwa(BigDecimal r243_rrp_rwa) {
		this.r243_rrp_rwa = r243_rrp_rwa;
	}
	public BigDecimal getR243_rrp_under_ccf_amt() {
		return r243_rrp_under_ccf_amt;
	}
	public void setR243_rrp_under_ccf_amt(BigDecimal r243_rrp_under_ccf_amt) {
		this.r243_rrp_under_ccf_amt = r243_rrp_under_ccf_amt;
	}
	public BigDecimal getR244_rrp_85_lcbg_balance() {
		return r244_rrp_85_lcbg_balance;
	}
	public void setR244_rrp_85_lcbg_balance(BigDecimal r244_rrp_85_lcbg_balance) {
		this.r244_rrp_85_lcbg_balance = r244_rrp_85_lcbg_balance;
	}
	public BigDecimal getR244_rrp_85_acceptance_amount() {
		return r244_rrp_85_acceptance_amount;
	}
	public void setR244_rrp_85_acceptance_amount(BigDecimal r244_rrp_85_acceptance_amount) {
		this.r244_rrp_85_acceptance_amount = r244_rrp_85_acceptance_amount;
	}
	public BigDecimal getR244_rrp_85_lcbg_crm() {
		return r244_rrp_85_lcbg_crm;
	}
	public void setR244_rrp_85_lcbg_crm(BigDecimal r244_rrp_85_lcbg_crm) {
		this.r244_rrp_85_lcbg_crm = r244_rrp_85_lcbg_crm;
	}
	public BigDecimal getR244_rrp_85_rwa() {
		return r244_rrp_85_rwa;
	}
	public void setR244_rrp_85_rwa(BigDecimal r244_rrp_85_rwa) {
		this.r244_rrp_85_rwa = r244_rrp_85_rwa;
	}
	public BigDecimal getR244_rrp_85_under_ccf_amt() {
		return r244_rrp_85_under_ccf_amt;
	}
	public void setR244_rrp_85_under_ccf_amt(BigDecimal r244_rrp_85_under_ccf_amt) {
		this.r244_rrp_85_under_ccf_amt = r244_rrp_85_under_ccf_amt;
	}
	public BigDecimal getR245_rrp_85_lcbg_balance() {
		return r245_rrp_85_lcbg_balance;
	}
	public void setR245_rrp_85_lcbg_balance(BigDecimal r245_rrp_85_lcbg_balance) {
		this.r245_rrp_85_lcbg_balance = r245_rrp_85_lcbg_balance;
	}
	public BigDecimal getR245_rrp_85_acceptance_amount() {
		return r245_rrp_85_acceptance_amount;
	}
	public void setR245_rrp_85_acceptance_amount(BigDecimal r245_rrp_85_acceptance_amount) {
		this.r245_rrp_85_acceptance_amount = r245_rrp_85_acceptance_amount;
	}
	public BigDecimal getR245_rrp_85_lcbg_crm() {
		return r245_rrp_85_lcbg_crm;
	}
	public void setR245_rrp_85_lcbg_crm(BigDecimal r245_rrp_85_lcbg_crm) {
		this.r245_rrp_85_lcbg_crm = r245_rrp_85_lcbg_crm;
	}
	public BigDecimal getR245_rrp_85_rwa() {
		return r245_rrp_85_rwa;
	}
	public void setR245_rrp_85_rwa(BigDecimal r245_rrp_85_rwa) {
		this.r245_rrp_85_rwa = r245_rrp_85_rwa;
	}
	public BigDecimal getR245_rrp_85_under_ccf_amt() {
		return r245_rrp_85_under_ccf_amt;
	}
	public void setR245_rrp_85_under_ccf_amt(BigDecimal r245_rrp_85_under_ccf_amt) {
		this.r245_rrp_85_under_ccf_amt = r245_rrp_85_under_ccf_amt;
	}
	public BigDecimal getR246_rrp_85_lcbg_balance() {
		return r246_rrp_85_lcbg_balance;
	}
	public void setR246_rrp_85_lcbg_balance(BigDecimal r246_rrp_85_lcbg_balance) {
		this.r246_rrp_85_lcbg_balance = r246_rrp_85_lcbg_balance;
	}
	public BigDecimal getR246_rrp_85_acceptance_amount() {
		return r246_rrp_85_acceptance_amount;
	}
	public void setR246_rrp_85_acceptance_amount(BigDecimal r246_rrp_85_acceptance_amount) {
		this.r246_rrp_85_acceptance_amount = r246_rrp_85_acceptance_amount;
	}
	public BigDecimal getR246_rrp_85_lcbg_crm() {
		return r246_rrp_85_lcbg_crm;
	}
	public void setR246_rrp_85_lcbg_crm(BigDecimal r246_rrp_85_lcbg_crm) {
		this.r246_rrp_85_lcbg_crm = r246_rrp_85_lcbg_crm;
	}
	public BigDecimal getR246_rrp_85_rwa() {
		return r246_rrp_85_rwa;
	}
	public void setR246_rrp_85_rwa(BigDecimal r246_rrp_85_rwa) {
		this.r246_rrp_85_rwa = r246_rrp_85_rwa;
	}
	public BigDecimal getR246_rrp_85_under_ccf_amt() {
		return r246_rrp_85_under_ccf_amt;
	}
	public void setR246_rrp_85_under_ccf_amt(BigDecimal r246_rrp_85_under_ccf_amt) {
		this.r246_rrp_85_under_ccf_amt = r246_rrp_85_under_ccf_amt;
	}
	public BigDecimal getR247_rrp_lcbg_balance() {
		return r247_rrp_lcbg_balance;
	}
	public void setR247_rrp_lcbg_balance(BigDecimal r247_rrp_lcbg_balance) {
		this.r247_rrp_lcbg_balance = r247_rrp_lcbg_balance;
	}
	public BigDecimal getR247_rrp_acceptance_amount() {
		return r247_rrp_acceptance_amount;
	}
	public void setR247_rrp_acceptance_amount(BigDecimal r247_rrp_acceptance_amount) {
		this.r247_rrp_acceptance_amount = r247_rrp_acceptance_amount;
	}
	public BigDecimal getR247_rrp_lcbg_crm() {
		return r247_rrp_lcbg_crm;
	}
	public void setR247_rrp_lcbg_crm(BigDecimal r247_rrp_lcbg_crm) {
		this.r247_rrp_lcbg_crm = r247_rrp_lcbg_crm;
	}
	public BigDecimal getR247_rrp_rwa() {
		return r247_rrp_rwa;
	}
	public void setR247_rrp_rwa(BigDecimal r247_rrp_rwa) {
		this.r247_rrp_rwa = r247_rrp_rwa;
	}
	public BigDecimal getR247_rrp_under_ccf_amt() {
		return r247_rrp_under_ccf_amt;
	}
	public void setR247_rrp_under_ccf_amt(BigDecimal r247_rrp_under_ccf_amt) {
		this.r247_rrp_under_ccf_amt = r247_rrp_under_ccf_amt;
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
	public BRF95_NONFUND_BASED_TABLE1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}