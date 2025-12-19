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
@Table(name="BRF52_SUMMARYTABLE3")

public class BRF52_ENTITY3 {
	private String	r82_assets;
	private BigDecimal	r82_global_amount;
	private BigDecimal	r82_uae_amount;
	private BigDecimal	r82_amount1;
	private BigDecimal	r82_amount2;
	private BigDecimal	r82_amount3;
	private BigDecimal	r82_amount4;
	private BigDecimal	r82_amount5;
	private BigDecimal	r82_amount6;
	private BigDecimal	r82_amount7;
	private BigDecimal	r82_amount8;
	private BigDecimal	r82_amount9;
	private BigDecimal	r82_amount10;
	private BigDecimal	r82_amount11;
	private BigDecimal	r82_amount12;
	private BigDecimal	r82_amount13;
	private BigDecimal	r82_amount14;
	private BigDecimal	r82_amount15;
	private BigDecimal	r82_amount16;
	private BigDecimal	r82_amount17;
	private BigDecimal	r82_amount18;
	private BigDecimal	r82_amount19;
	private BigDecimal	r82_amount20;
	private BigDecimal	r82_amount21;
	private String	r83_assets;
	private BigDecimal	r83_global_amount;
	private BigDecimal	r83_uae_amount;
	private BigDecimal	r83_amount1;
	private BigDecimal	r83_amount2;
	private BigDecimal	r83_amount3;
	private BigDecimal	r83_amount4;
	private BigDecimal	r83_amount5;
	private BigDecimal	r83_amount6;
	private BigDecimal	r83_amount7;
	private BigDecimal	r83_amount8;
	private BigDecimal	r83_amount9;
	private BigDecimal	r83_amount10;
	private BigDecimal	r83_amount11;
	private BigDecimal	r83_amount12;
	private BigDecimal	r83_amount13;
	private BigDecimal	r83_amount14;
	private BigDecimal	r83_amount15;
	private BigDecimal	r83_amount16;
	private BigDecimal	r83_amount17;
	private BigDecimal	r83_amount18;
	private BigDecimal	r83_amount19;
	private BigDecimal	r83_amount20;
	private BigDecimal	r83_amount21;
	private String	r84_assets;
	private BigDecimal	r84_global_amount;
	private BigDecimal	r84_uae_amount;
	private BigDecimal	r84_amount1;
	private BigDecimal	r84_amount2;
	private BigDecimal	r84_amount3;
	private BigDecimal	r84_amount4;
	private BigDecimal	r84_amount5;
	private BigDecimal	r84_amount6;
	private BigDecimal	r84_amount7;
	private BigDecimal	r84_amount8;
	private BigDecimal	r84_amount9;
	private BigDecimal	r84_amount10;
	private BigDecimal	r84_amount11;
	private BigDecimal	r84_amount12;
	private BigDecimal	r84_amount13;
	private BigDecimal	r84_amount14;
	private BigDecimal	r84_amount15;
	private BigDecimal	r84_amount16;
	private BigDecimal	r84_amount17;
	private BigDecimal	r84_amount18;
	private BigDecimal	r84_amount19;
	private BigDecimal	r84_amount20;
	private BigDecimal	r84_amount21;
	private String	r85_assets;
	private BigDecimal	r85_global_amount;
	private BigDecimal	r85_uae_amount;
	private BigDecimal	r85_amount1;
	private BigDecimal	r85_amount2;
	private BigDecimal	r85_amount3;
	private BigDecimal	r85_amount4;
	private BigDecimal	r85_amount5;
	private BigDecimal	r85_amount6;
	private BigDecimal	r85_amount7;
	private BigDecimal	r85_amount8;
	private BigDecimal	r85_amount9;
	private BigDecimal	r85_amount10;
	private BigDecimal	r85_amount11;
	private BigDecimal	r85_amount12;
	private BigDecimal	r85_amount13;
	private BigDecimal	r85_amount14;
	private BigDecimal	r85_amount15;
	private BigDecimal	r85_amount16;
	private BigDecimal	r85_amount17;
	private BigDecimal	r85_amount18;
	private BigDecimal	r85_amount19;
	private BigDecimal	r85_amount20;
	private BigDecimal	r85_amount21;
	private String	r86_assets;
	private BigDecimal	r86_global_amount;
	private BigDecimal	r86_uae_amount;
	private BigDecimal	r86_amount1;
	private BigDecimal	r86_amount2;
	private BigDecimal	r86_amount3;
	private BigDecimal	r86_amount4;
	private BigDecimal	r86_amount5;
	private BigDecimal	r86_amount6;
	private BigDecimal	r86_amount7;
	private BigDecimal	r86_amount8;
	private BigDecimal	r86_amount9;
	private BigDecimal	r86_amount10;
	private BigDecimal	r86_amount11;
	private BigDecimal	r86_amount12;
	private BigDecimal	r86_amount13;
	private BigDecimal	r86_amount14;
	private BigDecimal	r86_amount15;
	private BigDecimal	r86_amount16;
	private BigDecimal	r86_amount17;
	private BigDecimal	r86_amount18;
	private BigDecimal	r86_amount19;
	private BigDecimal	r86_amount20;
	private BigDecimal	r86_amount21;
	
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
	public String getR82_assets() {
		return r82_assets;
	}
	public void setR82_assets(String r82_assets) {
		this.r82_assets = r82_assets;
	}
	public BigDecimal getR82_global_amount() {
		return r82_global_amount;
	}
	public void setR82_global_amount(BigDecimal r82_global_amount) {
		this.r82_global_amount = r82_global_amount;
	}
	public BigDecimal getR82_uae_amount() {
		return r82_uae_amount;
	}
	public void setR82_uae_amount(BigDecimal r82_uae_amount) {
		this.r82_uae_amount = r82_uae_amount;
	}
	public BigDecimal getR82_amount1() {
		return r82_amount1;
	}
	public void setR82_amount1(BigDecimal r82_amount1) {
		this.r82_amount1 = r82_amount1;
	}
	public BigDecimal getR82_amount2() {
		return r82_amount2;
	}
	public void setR82_amount2(BigDecimal r82_amount2) {
		this.r82_amount2 = r82_amount2;
	}
	public BigDecimal getR82_amount3() {
		return r82_amount3;
	}
	public void setR82_amount3(BigDecimal r82_amount3) {
		this.r82_amount3 = r82_amount3;
	}
	public BigDecimal getR82_amount4() {
		return r82_amount4;
	}
	public void setR82_amount4(BigDecimal r82_amount4) {
		this.r82_amount4 = r82_amount4;
	}
	public BigDecimal getR82_amount5() {
		return r82_amount5;
	}
	public void setR82_amount5(BigDecimal r82_amount5) {
		this.r82_amount5 = r82_amount5;
	}
	public BigDecimal getR82_amount6() {
		return r82_amount6;
	}
	public void setR82_amount6(BigDecimal r82_amount6) {
		this.r82_amount6 = r82_amount6;
	}
	public BigDecimal getR82_amount7() {
		return r82_amount7;
	}
	public void setR82_amount7(BigDecimal r82_amount7) {
		this.r82_amount7 = r82_amount7;
	}
	public BigDecimal getR82_amount8() {
		return r82_amount8;
	}
	public void setR82_amount8(BigDecimal r82_amount8) {
		this.r82_amount8 = r82_amount8;
	}
	public BigDecimal getR82_amount9() {
		return r82_amount9;
	}
	public void setR82_amount9(BigDecimal r82_amount9) {
		this.r82_amount9 = r82_amount9;
	}
	public BigDecimal getR82_amount10() {
		return r82_amount10;
	}
	public void setR82_amount10(BigDecimal r82_amount10) {
		this.r82_amount10 = r82_amount10;
	}
	public BigDecimal getR82_amount11() {
		return r82_amount11;
	}
	public void setR82_amount11(BigDecimal r82_amount11) {
		this.r82_amount11 = r82_amount11;
	}
	public BigDecimal getR82_amount12() {
		return r82_amount12;
	}
	public void setR82_amount12(BigDecimal r82_amount12) {
		this.r82_amount12 = r82_amount12;
	}
	public BigDecimal getR82_amount13() {
		return r82_amount13;
	}
	public void setR82_amount13(BigDecimal r82_amount13) {
		this.r82_amount13 = r82_amount13;
	}
	public BigDecimal getR82_amount14() {
		return r82_amount14;
	}
	public void setR82_amount14(BigDecimal r82_amount14) {
		this.r82_amount14 = r82_amount14;
	}
	public BigDecimal getR82_amount15() {
		return r82_amount15;
	}
	public void setR82_amount15(BigDecimal r82_amount15) {
		this.r82_amount15 = r82_amount15;
	}
	public BigDecimal getR82_amount16() {
		return r82_amount16;
	}
	public void setR82_amount16(BigDecimal r82_amount16) {
		this.r82_amount16 = r82_amount16;
	}
	public BigDecimal getR82_amount17() {
		return r82_amount17;
	}
	public void setR82_amount17(BigDecimal r82_amount17) {
		this.r82_amount17 = r82_amount17;
	}
	public BigDecimal getR82_amount18() {
		return r82_amount18;
	}
	public void setR82_amount18(BigDecimal r82_amount18) {
		this.r82_amount18 = r82_amount18;
	}
	public BigDecimal getR82_amount19() {
		return r82_amount19;
	}
	public void setR82_amount19(BigDecimal r82_amount19) {
		this.r82_amount19 = r82_amount19;
	}
	public BigDecimal getR82_amount20() {
		return r82_amount20;
	}
	public void setR82_amount20(BigDecimal r82_amount20) {
		this.r82_amount20 = r82_amount20;
	}
	public BigDecimal getR82_amount21() {
		return r82_amount21;
	}
	public void setR82_amount21(BigDecimal r82_amount21) {
		this.r82_amount21 = r82_amount21;
	}
	public String getR83_assets() {
		return r83_assets;
	}
	public void setR83_assets(String r83_assets) {
		this.r83_assets = r83_assets;
	}
	public BigDecimal getR83_global_amount() {
		return r83_global_amount;
	}
	public void setR83_global_amount(BigDecimal r83_global_amount) {
		this.r83_global_amount = r83_global_amount;
	}
	public BigDecimal getR83_uae_amount() {
		return r83_uae_amount;
	}
	public void setR83_uae_amount(BigDecimal r83_uae_amount) {
		this.r83_uae_amount = r83_uae_amount;
	}
	public BigDecimal getR83_amount1() {
		return r83_amount1;
	}
	public void setR83_amount1(BigDecimal r83_amount1) {
		this.r83_amount1 = r83_amount1;
	}
	public BigDecimal getR83_amount2() {
		return r83_amount2;
	}
	public void setR83_amount2(BigDecimal r83_amount2) {
		this.r83_amount2 = r83_amount2;
	}
	public BigDecimal getR83_amount3() {
		return r83_amount3;
	}
	public void setR83_amount3(BigDecimal r83_amount3) {
		this.r83_amount3 = r83_amount3;
	}
	public BigDecimal getR83_amount4() {
		return r83_amount4;
	}
	public void setR83_amount4(BigDecimal r83_amount4) {
		this.r83_amount4 = r83_amount4;
	}
	public BigDecimal getR83_amount5() {
		return r83_amount5;
	}
	public void setR83_amount5(BigDecimal r83_amount5) {
		this.r83_amount5 = r83_amount5;
	}
	public BigDecimal getR83_amount6() {
		return r83_amount6;
	}
	public void setR83_amount6(BigDecimal r83_amount6) {
		this.r83_amount6 = r83_amount6;
	}
	public BigDecimal getR83_amount7() {
		return r83_amount7;
	}
	public void setR83_amount7(BigDecimal r83_amount7) {
		this.r83_amount7 = r83_amount7;
	}
	public BigDecimal getR83_amount8() {
		return r83_amount8;
	}
	public void setR83_amount8(BigDecimal r83_amount8) {
		this.r83_amount8 = r83_amount8;
	}
	public BigDecimal getR83_amount9() {
		return r83_amount9;
	}
	public void setR83_amount9(BigDecimal r83_amount9) {
		this.r83_amount9 = r83_amount9;
	}
	public BigDecimal getR83_amount10() {
		return r83_amount10;
	}
	public void setR83_amount10(BigDecimal r83_amount10) {
		this.r83_amount10 = r83_amount10;
	}
	public BigDecimal getR83_amount11() {
		return r83_amount11;
	}
	public void setR83_amount11(BigDecimal r83_amount11) {
		this.r83_amount11 = r83_amount11;
	}
	public BigDecimal getR83_amount12() {
		return r83_amount12;
	}
	public void setR83_amount12(BigDecimal r83_amount12) {
		this.r83_amount12 = r83_amount12;
	}
	public BigDecimal getR83_amount13() {
		return r83_amount13;
	}
	public void setR83_amount13(BigDecimal r83_amount13) {
		this.r83_amount13 = r83_amount13;
	}
	public BigDecimal getR83_amount14() {
		return r83_amount14;
	}
	public void setR83_amount14(BigDecimal r83_amount14) {
		this.r83_amount14 = r83_amount14;
	}
	public BigDecimal getR83_amount15() {
		return r83_amount15;
	}
	public void setR83_amount15(BigDecimal r83_amount15) {
		this.r83_amount15 = r83_amount15;
	}
	public BigDecimal getR83_amount16() {
		return r83_amount16;
	}
	public void setR83_amount16(BigDecimal r83_amount16) {
		this.r83_amount16 = r83_amount16;
	}
	public BigDecimal getR83_amount17() {
		return r83_amount17;
	}
	public void setR83_amount17(BigDecimal r83_amount17) {
		this.r83_amount17 = r83_amount17;
	}
	public BigDecimal getR83_amount18() {
		return r83_amount18;
	}
	public void setR83_amount18(BigDecimal r83_amount18) {
		this.r83_amount18 = r83_amount18;
	}
	public BigDecimal getR83_amount19() {
		return r83_amount19;
	}
	public void setR83_amount19(BigDecimal r83_amount19) {
		this.r83_amount19 = r83_amount19;
	}
	public BigDecimal getR83_amount20() {
		return r83_amount20;
	}
	public void setR83_amount20(BigDecimal r83_amount20) {
		this.r83_amount20 = r83_amount20;
	}
	public BigDecimal getR83_amount21() {
		return r83_amount21;
	}
	public void setR83_amount21(BigDecimal r83_amount21) {
		this.r83_amount21 = r83_amount21;
	}
	public String getR84_assets() {
		return r84_assets;
	}
	public void setR84_assets(String r84_assets) {
		this.r84_assets = r84_assets;
	}
	public BigDecimal getR84_global_amount() {
		return r84_global_amount;
	}
	public void setR84_global_amount(BigDecimal r84_global_amount) {
		this.r84_global_amount = r84_global_amount;
	}
	public BigDecimal getR84_uae_amount() {
		return r84_uae_amount;
	}
	public void setR84_uae_amount(BigDecimal r84_uae_amount) {
		this.r84_uae_amount = r84_uae_amount;
	}
	public BigDecimal getR84_amount1() {
		return r84_amount1;
	}
	public void setR84_amount1(BigDecimal r84_amount1) {
		this.r84_amount1 = r84_amount1;
	}
	public BigDecimal getR84_amount2() {
		return r84_amount2;
	}
	public void setR84_amount2(BigDecimal r84_amount2) {
		this.r84_amount2 = r84_amount2;
	}
	public BigDecimal getR84_amount3() {
		return r84_amount3;
	}
	public void setR84_amount3(BigDecimal r84_amount3) {
		this.r84_amount3 = r84_amount3;
	}
	public BigDecimal getR84_amount4() {
		return r84_amount4;
	}
	public void setR84_amount4(BigDecimal r84_amount4) {
		this.r84_amount4 = r84_amount4;
	}
	public BigDecimal getR84_amount5() {
		return r84_amount5;
	}
	public void setR84_amount5(BigDecimal r84_amount5) {
		this.r84_amount5 = r84_amount5;
	}
	public BigDecimal getR84_amount6() {
		return r84_amount6;
	}
	public void setR84_amount6(BigDecimal r84_amount6) {
		this.r84_amount6 = r84_amount6;
	}
	public BigDecimal getR84_amount7() {
		return r84_amount7;
	}
	public void setR84_amount7(BigDecimal r84_amount7) {
		this.r84_amount7 = r84_amount7;
	}
	public BigDecimal getR84_amount8() {
		return r84_amount8;
	}
	public void setR84_amount8(BigDecimal r84_amount8) {
		this.r84_amount8 = r84_amount8;
	}
	public BigDecimal getR84_amount9() {
		return r84_amount9;
	}
	public void setR84_amount9(BigDecimal r84_amount9) {
		this.r84_amount9 = r84_amount9;
	}
	public BigDecimal getR84_amount10() {
		return r84_amount10;
	}
	public void setR84_amount10(BigDecimal r84_amount10) {
		this.r84_amount10 = r84_amount10;
	}
	public BigDecimal getR84_amount11() {
		return r84_amount11;
	}
	public void setR84_amount11(BigDecimal r84_amount11) {
		this.r84_amount11 = r84_amount11;
	}
	public BigDecimal getR84_amount12() {
		return r84_amount12;
	}
	public void setR84_amount12(BigDecimal r84_amount12) {
		this.r84_amount12 = r84_amount12;
	}
	public BigDecimal getR84_amount13() {
		return r84_amount13;
	}
	public void setR84_amount13(BigDecimal r84_amount13) {
		this.r84_amount13 = r84_amount13;
	}
	public BigDecimal getR84_amount14() {
		return r84_amount14;
	}
	public void setR84_amount14(BigDecimal r84_amount14) {
		this.r84_amount14 = r84_amount14;
	}
	public BigDecimal getR84_amount15() {
		return r84_amount15;
	}
	public void setR84_amount15(BigDecimal r84_amount15) {
		this.r84_amount15 = r84_amount15;
	}
	public BigDecimal getR84_amount16() {
		return r84_amount16;
	}
	public void setR84_amount16(BigDecimal r84_amount16) {
		this.r84_amount16 = r84_amount16;
	}
	public BigDecimal getR84_amount17() {
		return r84_amount17;
	}
	public void setR84_amount17(BigDecimal r84_amount17) {
		this.r84_amount17 = r84_amount17;
	}
	public BigDecimal getR84_amount18() {
		return r84_amount18;
	}
	public void setR84_amount18(BigDecimal r84_amount18) {
		this.r84_amount18 = r84_amount18;
	}
	public BigDecimal getR84_amount19() {
		return r84_amount19;
	}
	public void setR84_amount19(BigDecimal r84_amount19) {
		this.r84_amount19 = r84_amount19;
	}
	public BigDecimal getR84_amount20() {
		return r84_amount20;
	}
	public void setR84_amount20(BigDecimal r84_amount20) {
		this.r84_amount20 = r84_amount20;
	}
	public BigDecimal getR84_amount21() {
		return r84_amount21;
	}
	public void setR84_amount21(BigDecimal r84_amount21) {
		this.r84_amount21 = r84_amount21;
	}
	public String getR85_assets() {
		return r85_assets;
	}
	public void setR85_assets(String r85_assets) {
		this.r85_assets = r85_assets;
	}
	public BigDecimal getR85_global_amount() {
		return r85_global_amount;
	}
	public void setR85_global_amount(BigDecimal r85_global_amount) {
		this.r85_global_amount = r85_global_amount;
	}
	public BigDecimal getR85_uae_amount() {
		return r85_uae_amount;
	}
	public void setR85_uae_amount(BigDecimal r85_uae_amount) {
		this.r85_uae_amount = r85_uae_amount;
	}
	public BigDecimal getR85_amount1() {
		return r85_amount1;
	}
	public void setR85_amount1(BigDecimal r85_amount1) {
		this.r85_amount1 = r85_amount1;
	}
	public BigDecimal getR85_amount2() {
		return r85_amount2;
	}
	public void setR85_amount2(BigDecimal r85_amount2) {
		this.r85_amount2 = r85_amount2;
	}
	public BigDecimal getR85_amount3() {
		return r85_amount3;
	}
	public void setR85_amount3(BigDecimal r85_amount3) {
		this.r85_amount3 = r85_amount3;
	}
	public BigDecimal getR85_amount4() {
		return r85_amount4;
	}
	public void setR85_amount4(BigDecimal r85_amount4) {
		this.r85_amount4 = r85_amount4;
	}
	public BigDecimal getR85_amount5() {
		return r85_amount5;
	}
	public void setR85_amount5(BigDecimal r85_amount5) {
		this.r85_amount5 = r85_amount5;
	}
	public BigDecimal getR85_amount6() {
		return r85_amount6;
	}
	public void setR85_amount6(BigDecimal r85_amount6) {
		this.r85_amount6 = r85_amount6;
	}
	public BigDecimal getR85_amount7() {
		return r85_amount7;
	}
	public void setR85_amount7(BigDecimal r85_amount7) {
		this.r85_amount7 = r85_amount7;
	}
	public BigDecimal getR85_amount8() {
		return r85_amount8;
	}
	public void setR85_amount8(BigDecimal r85_amount8) {
		this.r85_amount8 = r85_amount8;
	}
	public BigDecimal getR85_amount9() {
		return r85_amount9;
	}
	public void setR85_amount9(BigDecimal r85_amount9) {
		this.r85_amount9 = r85_amount9;
	}
	public BigDecimal getR85_amount10() {
		return r85_amount10;
	}
	public void setR85_amount10(BigDecimal r85_amount10) {
		this.r85_amount10 = r85_amount10;
	}
	public BigDecimal getR85_amount11() {
		return r85_amount11;
	}
	public void setR85_amount11(BigDecimal r85_amount11) {
		this.r85_amount11 = r85_amount11;
	}
	public BigDecimal getR85_amount12() {
		return r85_amount12;
	}
	public void setR85_amount12(BigDecimal r85_amount12) {
		this.r85_amount12 = r85_amount12;
	}
	public BigDecimal getR85_amount13() {
		return r85_amount13;
	}
	public void setR85_amount13(BigDecimal r85_amount13) {
		this.r85_amount13 = r85_amount13;
	}
	public BigDecimal getR85_amount14() {
		return r85_amount14;
	}
	public void setR85_amount14(BigDecimal r85_amount14) {
		this.r85_amount14 = r85_amount14;
	}
	public BigDecimal getR85_amount15() {
		return r85_amount15;
	}
	public void setR85_amount15(BigDecimal r85_amount15) {
		this.r85_amount15 = r85_amount15;
	}
	public BigDecimal getR85_amount16() {
		return r85_amount16;
	}
	public void setR85_amount16(BigDecimal r85_amount16) {
		this.r85_amount16 = r85_amount16;
	}
	public BigDecimal getR85_amount17() {
		return r85_amount17;
	}
	public void setR85_amount17(BigDecimal r85_amount17) {
		this.r85_amount17 = r85_amount17;
	}
	public BigDecimal getR85_amount18() {
		return r85_amount18;
	}
	public void setR85_amount18(BigDecimal r85_amount18) {
		this.r85_amount18 = r85_amount18;
	}
	public BigDecimal getR85_amount19() {
		return r85_amount19;
	}
	public void setR85_amount19(BigDecimal r85_amount19) {
		this.r85_amount19 = r85_amount19;
	}
	public BigDecimal getR85_amount20() {
		return r85_amount20;
	}
	public void setR85_amount20(BigDecimal r85_amount20) {
		this.r85_amount20 = r85_amount20;
	}
	public BigDecimal getR85_amount21() {
		return r85_amount21;
	}
	public void setR85_amount21(BigDecimal r85_amount21) {
		this.r85_amount21 = r85_amount21;
	}
	public String getR86_assets() {
		return r86_assets;
	}
	public void setR86_assets(String r86_assets) {
		this.r86_assets = r86_assets;
	}
	public BigDecimal getR86_global_amount() {
		return r86_global_amount;
	}
	public void setR86_global_amount(BigDecimal r86_global_amount) {
		this.r86_global_amount = r86_global_amount;
	}
	public BigDecimal getR86_uae_amount() {
		return r86_uae_amount;
	}
	public void setR86_uae_amount(BigDecimal r86_uae_amount) {
		this.r86_uae_amount = r86_uae_amount;
	}
	public BigDecimal getR86_amount1() {
		return r86_amount1;
	}
	public void setR86_amount1(BigDecimal r86_amount1) {
		this.r86_amount1 = r86_amount1;
	}
	public BigDecimal getR86_amount2() {
		return r86_amount2;
	}
	public void setR86_amount2(BigDecimal r86_amount2) {
		this.r86_amount2 = r86_amount2;
	}
	public BigDecimal getR86_amount3() {
		return r86_amount3;
	}
	public void setR86_amount3(BigDecimal r86_amount3) {
		this.r86_amount3 = r86_amount3;
	}
	public BigDecimal getR86_amount4() {
		return r86_amount4;
	}
	public void setR86_amount4(BigDecimal r86_amount4) {
		this.r86_amount4 = r86_amount4;
	}
	public BigDecimal getR86_amount5() {
		return r86_amount5;
	}
	public void setR86_amount5(BigDecimal r86_amount5) {
		this.r86_amount5 = r86_amount5;
	}
	public BigDecimal getR86_amount6() {
		return r86_amount6;
	}
	public void setR86_amount6(BigDecimal r86_amount6) {
		this.r86_amount6 = r86_amount6;
	}
	public BigDecimal getR86_amount7() {
		return r86_amount7;
	}
	public void setR86_amount7(BigDecimal r86_amount7) {
		this.r86_amount7 = r86_amount7;
	}
	public BigDecimal getR86_amount8() {
		return r86_amount8;
	}
	public void setR86_amount8(BigDecimal r86_amount8) {
		this.r86_amount8 = r86_amount8;
	}
	public BigDecimal getR86_amount9() {
		return r86_amount9;
	}
	public void setR86_amount9(BigDecimal r86_amount9) {
		this.r86_amount9 = r86_amount9;
	}
	public BigDecimal getR86_amount10() {
		return r86_amount10;
	}
	public void setR86_amount10(BigDecimal r86_amount10) {
		this.r86_amount10 = r86_amount10;
	}
	public BigDecimal getR86_amount11() {
		return r86_amount11;
	}
	public void setR86_amount11(BigDecimal r86_amount11) {
		this.r86_amount11 = r86_amount11;
	}
	public BigDecimal getR86_amount12() {
		return r86_amount12;
	}
	public void setR86_amount12(BigDecimal r86_amount12) {
		this.r86_amount12 = r86_amount12;
	}
	public BigDecimal getR86_amount13() {
		return r86_amount13;
	}
	public void setR86_amount13(BigDecimal r86_amount13) {
		this.r86_amount13 = r86_amount13;
	}
	public BigDecimal getR86_amount14() {
		return r86_amount14;
	}
	public void setR86_amount14(BigDecimal r86_amount14) {
		this.r86_amount14 = r86_amount14;
	}
	public BigDecimal getR86_amount15() {
		return r86_amount15;
	}
	public void setR86_amount15(BigDecimal r86_amount15) {
		this.r86_amount15 = r86_amount15;
	}
	public BigDecimal getR86_amount16() {
		return r86_amount16;
	}
	public void setR86_amount16(BigDecimal r86_amount16) {
		this.r86_amount16 = r86_amount16;
	}
	public BigDecimal getR86_amount17() {
		return r86_amount17;
	}
	public void setR86_amount17(BigDecimal r86_amount17) {
		this.r86_amount17 = r86_amount17;
	}
	public BigDecimal getR86_amount18() {
		return r86_amount18;
	}
	public void setR86_amount18(BigDecimal r86_amount18) {
		this.r86_amount18 = r86_amount18;
	}
	public BigDecimal getR86_amount19() {
		return r86_amount19;
	}
	public void setR86_amount19(BigDecimal r86_amount19) {
		this.r86_amount19 = r86_amount19;
	}
	public BigDecimal getR86_amount20() {
		return r86_amount20;
	}
	public void setR86_amount20(BigDecimal r86_amount20) {
		this.r86_amount20 = r86_amount20;
	}
	public BigDecimal getR86_amount21() {
		return r86_amount21;
	}
	public void setR86_amount21(BigDecimal r86_amount21) {
		this.r86_amount21 = r86_amount21;
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
	
}