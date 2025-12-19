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
@Table(name="BANKING_BOOK2")


public class Banking_Book2 {
	private String	r61_product;
	private BigDecimal	r61_1_to_28days;
	private BigDecimal	r61_29days_to_3months;
	private BigDecimal	r61_3months_6months;
	private BigDecimal	r61_6months_upto1year;
	private BigDecimal	r61_1year_upto3years;
	private BigDecimal	r61_3year_upto5years;
	private BigDecimal	r61_5year_upto7years;
	private BigDecimal	r61_7year_upto10years;
	private BigDecimal	r61_10year_upto15years;
	private BigDecimal	r61_15years;
	private BigDecimal	r61_nonsensitive;
	private BigDecimal	r61_total_rsl;
	private BigDecimal	r61_total;
	private String	r62_product;
	private BigDecimal	r62_1_to_28days;
	private BigDecimal	r62_29days_to_3months;
	private BigDecimal	r62_3months_6months;
	private BigDecimal	r62_6months_upto1year;
	private BigDecimal	r62_1year_upto3years;
	private BigDecimal	r62_3year_upto5years;
	private BigDecimal	r62_5year_upto7years;
	private BigDecimal	r62_7year_upto10years;
	private BigDecimal	r62_10year_upto15years;
	private BigDecimal	r62_15years;
	private BigDecimal	r62_nonsensitive;
	private BigDecimal	r62_total_rsl;
	private BigDecimal	r62_total;
	private String	r63_product;
	private BigDecimal	r63_1_to_28days;
	private BigDecimal	r63_29days_to_3months;
	private BigDecimal	r63_3months_6months;
	private BigDecimal	r63_6months_upto1year;
	private BigDecimal	r63_1year_upto3years;
	private BigDecimal	r63_3year_upto5years;
	private BigDecimal	r63_5year_upto7years;
	private BigDecimal	r63_7year_upto10years;
	private BigDecimal	r63_10year_upto15years;
	private BigDecimal	r63_15years;
	private BigDecimal	r63_nonsensitive;
	private BigDecimal	r63_total_rsl;
	private BigDecimal	r63_total;
	private String	r64_product;
	private BigDecimal	r64_1_to_28days;
	private BigDecimal	r64_29days_to_3months;
	private BigDecimal	r64_3months_6months;
	private BigDecimal	r64_6months_upto1year;
	private BigDecimal	r64_1year_upto3years;
	private BigDecimal	r64_3year_upto5years;
	private BigDecimal	r64_5year_upto7years;
	private BigDecimal	r64_7year_upto10years;
	private BigDecimal	r64_10year_upto15years;
	private BigDecimal	r64_15years;
	private BigDecimal	r64_nonsensitive;
	private BigDecimal	r64_total_rsl;
	private BigDecimal	r64_total;
	private String	r65_product;
	private BigDecimal	r65_1_to_28days;
	private BigDecimal	r65_29days_to_3months;
	private BigDecimal	r65_3months_6months;
	private BigDecimal	r65_6months_upto1year;
	private BigDecimal	r65_1year_upto3years;
	private BigDecimal	r65_3year_upto5years;
	private BigDecimal	r65_5year_upto7years;
	private BigDecimal	r65_7year_upto10years;
	private BigDecimal	r65_10year_upto15years;
	private BigDecimal	r65_15years;
	private BigDecimal	r65_nonsensitive;
	private BigDecimal	r65_total_rsl;
	private BigDecimal	r65_total;
	private String	r66_product;
	private BigDecimal	r66_1_to_28days;
	private BigDecimal	r66_29days_to_3months;
	private BigDecimal	r66_3months_6months;
	private BigDecimal	r66_6months_upto1year;
	private BigDecimal	r66_1year_upto3years;
	private BigDecimal	r66_3year_upto5years;
	private BigDecimal	r66_5year_upto7years;
	private BigDecimal	r66_7year_upto10years;
	private BigDecimal	r66_10year_upto15years;
	private BigDecimal	r66_15years;
	private BigDecimal	r66_nonsensitive;
	private BigDecimal	r66_total_rsl;
	private BigDecimal	r66_total;
	private String	r67_product;
	private BigDecimal	r67_1_to_28days;
	private BigDecimal	r67_29days_to_3months;
	private BigDecimal	r67_3months_6months;
	private BigDecimal	r67_6months_upto1year;
	private BigDecimal	r67_1year_upto3years;
	private BigDecimal	r67_3year_upto5years;
	private BigDecimal	r67_5year_upto7years;
	private BigDecimal	r67_7year_upto10years;
	private BigDecimal	r67_10year_upto15years;
	private BigDecimal	r67_15years;
	private BigDecimal	r67_nonsensitive;
	private BigDecimal	r67_total_rsl;
	private BigDecimal	r67_total;
	private String	r68_product;
	private BigDecimal	r68_1_to_28days;
	private BigDecimal	r68_29days_to_3months;
	private BigDecimal	r68_3months_6months;
	private BigDecimal	r68_6months_upto1year;
	private BigDecimal	r68_1year_upto3years;
	private BigDecimal	r68_3year_upto5years;
	private BigDecimal	r68_5year_upto7years;
	private BigDecimal	r68_7year_upto10years;
	private BigDecimal	r68_10year_upto15years;
	private BigDecimal	r68_15years;
	private BigDecimal	r68_nonsensitive;
	private BigDecimal	r68_total_rsl;
	private BigDecimal	r68_total;
	private String	r69_product;
	private BigDecimal	r69_1_to_28days;
	private BigDecimal	r69_29days_to_3months;
	private BigDecimal	r69_3months_6months;
	private BigDecimal	r69_6months_upto1year;
	private BigDecimal	r69_1year_upto3years;
	private BigDecimal	r69_3year_upto5years;
	private BigDecimal	r69_5year_upto7years;
	private BigDecimal	r69_7year_upto10years;
	private BigDecimal	r69_10year_upto15years;
	private BigDecimal	r69_15years;
	private BigDecimal	r69_nonsensitive;
	private BigDecimal	r69_total_rsl;
	private BigDecimal	r69_total;
	private String	r70_product;
	private BigDecimal	r70_1_to_28days;
	private BigDecimal	r70_29days_to_3months;
	private BigDecimal	r70_3months_6months;
	private BigDecimal	r70_6months_upto1year;
	private BigDecimal	r70_1year_upto3years;
	private BigDecimal	r70_3year_upto5years;
	private BigDecimal	r70_5year_upto7years;
	private BigDecimal	r70_7year_upto10years;
	private BigDecimal	r70_10year_upto15years;
	private BigDecimal	r70_15years;
	private BigDecimal	r70_nonsensitive;
	private BigDecimal	r70_total_rsl;
	private BigDecimal	r70_total;
	private String	r71_product;
	private BigDecimal	r71_1_to_28days;
	private BigDecimal	r71_29days_to_3months;
	private BigDecimal	r71_3months_6months;
	private BigDecimal	r71_6months_upto1year;
	private BigDecimal	r71_1year_upto3years;
	private BigDecimal	r71_3year_upto5years;
	private BigDecimal	r71_5year_upto7years;
	private BigDecimal	r71_7year_upto10years;
	private BigDecimal	r71_10year_upto15years;
	private BigDecimal	r71_15years;
	private BigDecimal	r71_nonsensitive;
	private BigDecimal	r71_total_rsl;
	private BigDecimal	r71_total;
	private String	r72_product;
	private BigDecimal	r72_1_to_28days;
	private BigDecimal	r72_29days_to_3months;
	private BigDecimal	r72_3months_6months;
	private BigDecimal	r72_6months_upto1year;
	private BigDecimal	r72_1year_upto3years;
	private BigDecimal	r72_3year_upto5years;
	private BigDecimal	r72_5year_upto7years;
	private BigDecimal	r72_7year_upto10years;
	private BigDecimal	r72_10year_upto15years;
	private BigDecimal	r72_15years;
	private BigDecimal	r72_nonsensitive;
	private BigDecimal	r72_total_rsl;
	private BigDecimal	r72_total;
	private String	r73_product;
	private BigDecimal	r73_1_to_28days;
	private BigDecimal	r73_29days_to_3months;
	private BigDecimal	r73_3months_6months;
	private BigDecimal	r73_6months_upto1year;
	private BigDecimal	r73_1year_upto3years;
	private BigDecimal	r73_3year_upto5years;
	private BigDecimal	r73_5year_upto7years;
	private BigDecimal	r73_7year_upto10years;
	private BigDecimal	r73_10year_upto15years;
	private BigDecimal	r73_15years;
	private BigDecimal	r73_nonsensitive;
	private BigDecimal	r73_total_rsl;
	private BigDecimal	r73_total;
	private String	r74_product;
	private BigDecimal	r74_1_to_28days;
	private BigDecimal	r74_29days_to_3months;
	private BigDecimal	r74_3months_6months;
	private BigDecimal	r74_6months_upto1year;
	private BigDecimal	r74_1year_upto3years;
	private BigDecimal	r74_3year_upto5years;
	private BigDecimal	r74_5year_upto7years;
	private BigDecimal	r74_7year_upto10years;
	private BigDecimal	r74_10year_upto15years;
	private BigDecimal	r74_15years;
	private BigDecimal	r74_nonsensitive;
	private BigDecimal	r74_total_rsl;
	private BigDecimal	r74_total;
	private String	r75_product;
	private BigDecimal	r75_1_to_28days;
	private BigDecimal	r75_29days_to_3months;
	private BigDecimal	r75_3months_6months;
	private BigDecimal	r75_6months_upto1year;
	private BigDecimal	r75_1year_upto3years;
	private BigDecimal	r75_3year_upto5years;
	private BigDecimal	r75_5year_upto7years;
	private BigDecimal	r75_7year_upto10years;
	private BigDecimal	r75_10year_upto15years;
	private BigDecimal	r75_15years;
	private BigDecimal	r75_nonsensitive;
	private BigDecimal	r75_total_rsl;
	private BigDecimal	r75_total;
	private String	r76_product;
	private BigDecimal	r76_1_to_28days;
	private BigDecimal	r76_29days_to_3months;
	private BigDecimal	r76_3months_6months;
	private BigDecimal	r76_6months_upto1year;
	private BigDecimal	r76_1year_upto3years;
	private BigDecimal	r76_3year_upto5years;
	private BigDecimal	r76_5year_upto7years;
	private BigDecimal	r76_7year_upto10years;
	private BigDecimal	r76_10year_upto15years;
	private BigDecimal	r76_15years;
	private BigDecimal	r76_nonsensitive;
	private BigDecimal	r76_total_rsl;
	private BigDecimal	r76_total;
	private String	r77_product;
	private BigDecimal	r77_1_to_28days;
	private BigDecimal	r77_29days_to_3months;
	private BigDecimal	r77_3months_6months;
	private BigDecimal	r77_6months_upto1year;
	private BigDecimal	r77_1year_upto3years;
	private BigDecimal	r77_3year_upto5years;
	private BigDecimal	r77_5year_upto7years;
	private BigDecimal	r77_7year_upto10years;
	private BigDecimal	r77_10year_upto15years;
	private BigDecimal	r77_15years;
	private BigDecimal	r77_nonsensitive;
	private BigDecimal	r77_total_rsl;
	private BigDecimal	r77_total;
	private String	r78_product;
	private BigDecimal	r78_1_to_28days;
	private BigDecimal	r78_29days_to_3months;
	private BigDecimal	r78_3months_6months;
	private BigDecimal	r78_6months_upto1year;
	private BigDecimal	r78_1year_upto3years;
	private BigDecimal	r78_3year_upto5years;
	private BigDecimal	r78_5year_upto7years;
	private BigDecimal	r78_7year_upto10years;
	private BigDecimal	r78_10year_upto15years;
	private BigDecimal	r78_15years;
	private BigDecimal	r78_nonsensitive;
	private BigDecimal	r78_total_rsl;
	private BigDecimal	r78_total;
	private String	r79_product;
	private BigDecimal	r79_1_to_28days;
	private BigDecimal	r79_29days_to_3months;
	private BigDecimal	r79_3months_6months;
	private BigDecimal	r79_6months_upto1year;
	private BigDecimal	r79_1year_upto3years;
	private BigDecimal	r79_3year_upto5years;
	private BigDecimal	r79_5year_upto7years;
	private BigDecimal	r79_7year_upto10years;
	private BigDecimal	r79_10year_upto15years;
	private BigDecimal	r79_15years;
	private BigDecimal	r79_nonsensitive;
	private BigDecimal	r79_total_rsl;
	private BigDecimal	r79_total;
	private String	r80_product;
	private BigDecimal	r80_1_to_28days;
	private BigDecimal	r80_29days_to_3months;
	private BigDecimal	r80_3months_6months;
	private BigDecimal	r80_6months_upto1year;
	private BigDecimal	r80_1year_upto3years;
	private BigDecimal	r80_3year_upto5years;
	private BigDecimal	r80_5year_upto7years;
	private BigDecimal	r80_7year_upto10years;
	private BigDecimal	r80_10year_upto15years;
	private BigDecimal	r80_15years;
	private BigDecimal	r80_nonsensitive;
	private BigDecimal	r80_total_rsl;
	private BigDecimal	r80_total;
	private String	r81_product;
	private BigDecimal	r81_1_to_28days;
	private BigDecimal	r81_29days_to_3months;
	private BigDecimal	r81_3months_6months;
	private BigDecimal	r81_6months_upto1year;
	private BigDecimal	r81_1year_upto3years;
	private BigDecimal	r81_3year_upto5years;
	private BigDecimal	r81_5year_upto7years;
	private BigDecimal	r81_7year_upto10years;
	private BigDecimal	r81_10year_upto15years;
	private BigDecimal	r81_15years;
	private BigDecimal	r81_nonsensitive;
	private BigDecimal	r81_total_rsl;
	private BigDecimal	r81_total;
	private String	r82_product;
	private BigDecimal	r82_1_to_28days;
	private BigDecimal	r82_29days_to_3months;
	private BigDecimal	r82_3months_6months;
	private BigDecimal	r82_6months_upto1year;
	private BigDecimal	r82_1year_upto3years;
	private BigDecimal	r82_3year_upto5years;
	private BigDecimal	r82_5year_upto7years;
	private BigDecimal	r82_7year_upto10years;
	private BigDecimal	r82_10year_upto15years;
	private BigDecimal	r82_15years;
	private BigDecimal	r82_nonsensitive;
	private BigDecimal	r82_total_rsl;
	private BigDecimal	r82_total;
	private String	r83_product;
	private BigDecimal	r83_1_to_28days;
	private BigDecimal	r83_29days_to_3months;
	private BigDecimal	r83_3months_6months;
	private BigDecimal	r83_6months_upto1year;
	private BigDecimal	r83_1year_upto3years;
	private BigDecimal	r83_3year_upto5years;
	private BigDecimal	r83_5year_upto7years;
	private BigDecimal	r83_7year_upto10years;
	private BigDecimal	r83_10year_upto15years;
	private BigDecimal	r83_15years;
	private BigDecimal	r83_nonsensitive;
	private BigDecimal	r83_total_rsl;
	private BigDecimal	r83_total;
	private String	r84_product;
	private BigDecimal	r84_1_to_28days;
	private BigDecimal	r84_29days_to_3months;
	private BigDecimal	r84_3months_6months;
	private BigDecimal	r84_6months_upto1year;
	private BigDecimal	r84_1year_upto3years;
	private BigDecimal	r84_3year_upto5years;
	private BigDecimal	r84_5year_upto7years;
	private BigDecimal	r84_7year_upto10years;
	private BigDecimal	r84_10year_upto15years;
	private BigDecimal	r84_15years;
	private BigDecimal	r84_nonsensitive;
	private BigDecimal	r84_total_rsl;
	private BigDecimal	r84_total;
	private String	r85_product;
	private BigDecimal	r85_1_to_28days;
	private BigDecimal	r85_29days_to_3months;
	private BigDecimal	r85_3months_6months;
	private BigDecimal	r85_6months_upto1year;
	private BigDecimal	r85_1year_upto3years;
	private BigDecimal	r85_3year_upto5years;
	private BigDecimal	r85_5year_upto7years;
	private BigDecimal	r85_7year_upto10years;
	private BigDecimal	r85_10year_upto15years;
	private BigDecimal	r85_15years;
	private BigDecimal	r85_nonsensitive;
	private BigDecimal	r85_total_rsl;
	private BigDecimal	r85_total;
	private String	r86_product;
	private BigDecimal	r86_1_to_28days;
	private BigDecimal	r86_29days_to_3months;
	private BigDecimal	r86_3months_6months;
	private BigDecimal	r86_6months_upto1year;
	private BigDecimal	r86_1year_upto3years;
	private BigDecimal	r86_3year_upto5years;
	private BigDecimal	r86_5year_upto7years;
	private BigDecimal	r86_7year_upto10years;
	private BigDecimal	r86_10year_upto15years;
	private BigDecimal	r86_15years;
	private BigDecimal	r86_nonsensitive;
	private BigDecimal	r86_total_rsl;
	private BigDecimal	r86_total;
	private String	r87_product;
	private BigDecimal	r87_1_to_28days;
	private BigDecimal	r87_29days_to_3months;
	private BigDecimal	r87_3months_6months;
	private BigDecimal	r87_6months_upto1year;
	private BigDecimal	r87_1year_upto3years;
	private BigDecimal	r87_3year_upto5years;
	private BigDecimal	r87_5year_upto7years;
	private BigDecimal	r87_7year_upto10years;
	private BigDecimal	r87_10year_upto15years;
	private BigDecimal	r87_15years;
	private BigDecimal	r87_nonsensitive;
	private BigDecimal	r87_total_rsl;
	private BigDecimal	r87_total;
	private String	r88_product;
	private BigDecimal	r88_1_to_28days;
	private BigDecimal	r88_29days_to_3months;
	private BigDecimal	r88_3months_6months;
	private BigDecimal	r88_6months_upto1year;
	private BigDecimal	r88_1year_upto3years;
	private BigDecimal	r88_3year_upto5years;
	private BigDecimal	r88_5year_upto7years;
	private BigDecimal	r88_7year_upto10years;
	private BigDecimal	r88_10year_upto15years;
	private BigDecimal	r88_15years;
	private BigDecimal	r88_nonsensitive;
	private BigDecimal	r88_total_rsl;
	private BigDecimal	r88_total;
	private String	r89_product;
	private BigDecimal	r89_1_to_28days;
	private BigDecimal	r89_29days_to_3months;
	private BigDecimal	r89_3months_6months;
	private BigDecimal	r89_6months_upto1year;
	private BigDecimal	r89_1year_upto3years;
	private BigDecimal	r89_3year_upto5years;
	private BigDecimal	r89_5year_upto7years;
	private BigDecimal	r89_7year_upto10years;
	private BigDecimal	r89_10year_upto15years;
	private BigDecimal	r89_15years;
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
	public String getR61_product() {
		return r61_product;
	}
	public void setR61_product(String r61_product) {
		this.r61_product = r61_product;
	}
	public BigDecimal getR61_1_to_28days() {
		return r61_1_to_28days;
	}
	public void setR61_1_to_28days(BigDecimal r61_1_to_28days) {
		this.r61_1_to_28days = r61_1_to_28days;
	}
	public BigDecimal getR61_29days_to_3months() {
		return r61_29days_to_3months;
	}
	public void setR61_29days_to_3months(BigDecimal r61_29days_to_3months) {
		this.r61_29days_to_3months = r61_29days_to_3months;
	}
	public BigDecimal getR61_3months_6months() {
		return r61_3months_6months;
	}
	public void setR61_3months_6months(BigDecimal r61_3months_6months) {
		this.r61_3months_6months = r61_3months_6months;
	}
	public BigDecimal getR61_6months_upto1year() {
		return r61_6months_upto1year;
	}
	public void setR61_6months_upto1year(BigDecimal r61_6months_upto1year) {
		this.r61_6months_upto1year = r61_6months_upto1year;
	}
	public BigDecimal getR61_1year_upto3years() {
		return r61_1year_upto3years;
	}
	public void setR61_1year_upto3years(BigDecimal r61_1year_upto3years) {
		this.r61_1year_upto3years = r61_1year_upto3years;
	}
	public BigDecimal getR61_3year_upto5years() {
		return r61_3year_upto5years;
	}
	public void setR61_3year_upto5years(BigDecimal r61_3year_upto5years) {
		this.r61_3year_upto5years = r61_3year_upto5years;
	}
	public BigDecimal getR61_5year_upto7years() {
		return r61_5year_upto7years;
	}
	public void setR61_5year_upto7years(BigDecimal r61_5year_upto7years) {
		this.r61_5year_upto7years = r61_5year_upto7years;
	}
	public BigDecimal getR61_7year_upto10years() {
		return r61_7year_upto10years;
	}
	public void setR61_7year_upto10years(BigDecimal r61_7year_upto10years) {
		this.r61_7year_upto10years = r61_7year_upto10years;
	}
	public BigDecimal getR61_10year_upto15years() {
		return r61_10year_upto15years;
	}
	public void setR61_10year_upto15years(BigDecimal r61_10year_upto15years) {
		this.r61_10year_upto15years = r61_10year_upto15years;
	}
	public BigDecimal getR61_15years() {
		return r61_15years;
	}
	public void setR61_15years(BigDecimal r61_15years) {
		this.r61_15years = r61_15years;
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
	public BigDecimal getR62_1_to_28days() {
		return r62_1_to_28days;
	}
	public void setR62_1_to_28days(BigDecimal r62_1_to_28days) {
		this.r62_1_to_28days = r62_1_to_28days;
	}
	public BigDecimal getR62_29days_to_3months() {
		return r62_29days_to_3months;
	}
	public void setR62_29days_to_3months(BigDecimal r62_29days_to_3months) {
		this.r62_29days_to_3months = r62_29days_to_3months;
	}
	public BigDecimal getR62_3months_6months() {
		return r62_3months_6months;
	}
	public void setR62_3months_6months(BigDecimal r62_3months_6months) {
		this.r62_3months_6months = r62_3months_6months;
	}
	public BigDecimal getR62_6months_upto1year() {
		return r62_6months_upto1year;
	}
	public void setR62_6months_upto1year(BigDecimal r62_6months_upto1year) {
		this.r62_6months_upto1year = r62_6months_upto1year;
	}
	public BigDecimal getR62_1year_upto3years() {
		return r62_1year_upto3years;
	}
	public void setR62_1year_upto3years(BigDecimal r62_1year_upto3years) {
		this.r62_1year_upto3years = r62_1year_upto3years;
	}
	public BigDecimal getR62_3year_upto5years() {
		return r62_3year_upto5years;
	}
	public void setR62_3year_upto5years(BigDecimal r62_3year_upto5years) {
		this.r62_3year_upto5years = r62_3year_upto5years;
	}
	public BigDecimal getR62_5year_upto7years() {
		return r62_5year_upto7years;
	}
	public void setR62_5year_upto7years(BigDecimal r62_5year_upto7years) {
		this.r62_5year_upto7years = r62_5year_upto7years;
	}
	public BigDecimal getR62_7year_upto10years() {
		return r62_7year_upto10years;
	}
	public void setR62_7year_upto10years(BigDecimal r62_7year_upto10years) {
		this.r62_7year_upto10years = r62_7year_upto10years;
	}
	public BigDecimal getR62_10year_upto15years() {
		return r62_10year_upto15years;
	}
	public void setR62_10year_upto15years(BigDecimal r62_10year_upto15years) {
		this.r62_10year_upto15years = r62_10year_upto15years;
	}
	public BigDecimal getR62_15years() {
		return r62_15years;
	}
	public void setR62_15years(BigDecimal r62_15years) {
		this.r62_15years = r62_15years;
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
	public BigDecimal getR63_1_to_28days() {
		return r63_1_to_28days;
	}
	public void setR63_1_to_28days(BigDecimal r63_1_to_28days) {
		this.r63_1_to_28days = r63_1_to_28days;
	}
	public BigDecimal getR63_29days_to_3months() {
		return r63_29days_to_3months;
	}
	public void setR63_29days_to_3months(BigDecimal r63_29days_to_3months) {
		this.r63_29days_to_3months = r63_29days_to_3months;
	}
	public BigDecimal getR63_3months_6months() {
		return r63_3months_6months;
	}
	public void setR63_3months_6months(BigDecimal r63_3months_6months) {
		this.r63_3months_6months = r63_3months_6months;
	}
	public BigDecimal getR63_6months_upto1year() {
		return r63_6months_upto1year;
	}
	public void setR63_6months_upto1year(BigDecimal r63_6months_upto1year) {
		this.r63_6months_upto1year = r63_6months_upto1year;
	}
	public BigDecimal getR63_1year_upto3years() {
		return r63_1year_upto3years;
	}
	public void setR63_1year_upto3years(BigDecimal r63_1year_upto3years) {
		this.r63_1year_upto3years = r63_1year_upto3years;
	}
	public BigDecimal getR63_3year_upto5years() {
		return r63_3year_upto5years;
	}
	public void setR63_3year_upto5years(BigDecimal r63_3year_upto5years) {
		this.r63_3year_upto5years = r63_3year_upto5years;
	}
	public BigDecimal getR63_5year_upto7years() {
		return r63_5year_upto7years;
	}
	public void setR63_5year_upto7years(BigDecimal r63_5year_upto7years) {
		this.r63_5year_upto7years = r63_5year_upto7years;
	}
	public BigDecimal getR63_7year_upto10years() {
		return r63_7year_upto10years;
	}
	public void setR63_7year_upto10years(BigDecimal r63_7year_upto10years) {
		this.r63_7year_upto10years = r63_7year_upto10years;
	}
	public BigDecimal getR63_10year_upto15years() {
		return r63_10year_upto15years;
	}
	public void setR63_10year_upto15years(BigDecimal r63_10year_upto15years) {
		this.r63_10year_upto15years = r63_10year_upto15years;
	}
	public BigDecimal getR63_15years() {
		return r63_15years;
	}
	public void setR63_15years(BigDecimal r63_15years) {
		this.r63_15years = r63_15years;
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
	public BigDecimal getR64_1_to_28days() {
		return r64_1_to_28days;
	}
	public void setR64_1_to_28days(BigDecimal r64_1_to_28days) {
		this.r64_1_to_28days = r64_1_to_28days;
	}
	public BigDecimal getR64_29days_to_3months() {
		return r64_29days_to_3months;
	}
	public void setR64_29days_to_3months(BigDecimal r64_29days_to_3months) {
		this.r64_29days_to_3months = r64_29days_to_3months;
	}
	public BigDecimal getR64_3months_6months() {
		return r64_3months_6months;
	}
	public void setR64_3months_6months(BigDecimal r64_3months_6months) {
		this.r64_3months_6months = r64_3months_6months;
	}
	public BigDecimal getR64_6months_upto1year() {
		return r64_6months_upto1year;
	}
	public void setR64_6months_upto1year(BigDecimal r64_6months_upto1year) {
		this.r64_6months_upto1year = r64_6months_upto1year;
	}
	public BigDecimal getR64_1year_upto3years() {
		return r64_1year_upto3years;
	}
	public void setR64_1year_upto3years(BigDecimal r64_1year_upto3years) {
		this.r64_1year_upto3years = r64_1year_upto3years;
	}
	public BigDecimal getR64_3year_upto5years() {
		return r64_3year_upto5years;
	}
	public void setR64_3year_upto5years(BigDecimal r64_3year_upto5years) {
		this.r64_3year_upto5years = r64_3year_upto5years;
	}
	public BigDecimal getR64_5year_upto7years() {
		return r64_5year_upto7years;
	}
	public void setR64_5year_upto7years(BigDecimal r64_5year_upto7years) {
		this.r64_5year_upto7years = r64_5year_upto7years;
	}
	public BigDecimal getR64_7year_upto10years() {
		return r64_7year_upto10years;
	}
	public void setR64_7year_upto10years(BigDecimal r64_7year_upto10years) {
		this.r64_7year_upto10years = r64_7year_upto10years;
	}
	public BigDecimal getR64_10year_upto15years() {
		return r64_10year_upto15years;
	}
	public void setR64_10year_upto15years(BigDecimal r64_10year_upto15years) {
		this.r64_10year_upto15years = r64_10year_upto15years;
	}
	public BigDecimal getR64_15years() {
		return r64_15years;
	}
	public void setR64_15years(BigDecimal r64_15years) {
		this.r64_15years = r64_15years;
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
	public BigDecimal getR65_1_to_28days() {
		return r65_1_to_28days;
	}
	public void setR65_1_to_28days(BigDecimal r65_1_to_28days) {
		this.r65_1_to_28days = r65_1_to_28days;
	}
	public BigDecimal getR65_29days_to_3months() {
		return r65_29days_to_3months;
	}
	public void setR65_29days_to_3months(BigDecimal r65_29days_to_3months) {
		this.r65_29days_to_3months = r65_29days_to_3months;
	}
	public BigDecimal getR65_3months_6months() {
		return r65_3months_6months;
	}
	public void setR65_3months_6months(BigDecimal r65_3months_6months) {
		this.r65_3months_6months = r65_3months_6months;
	}
	public BigDecimal getR65_6months_upto1year() {
		return r65_6months_upto1year;
	}
	public void setR65_6months_upto1year(BigDecimal r65_6months_upto1year) {
		this.r65_6months_upto1year = r65_6months_upto1year;
	}
	public BigDecimal getR65_1year_upto3years() {
		return r65_1year_upto3years;
	}
	public void setR65_1year_upto3years(BigDecimal r65_1year_upto3years) {
		this.r65_1year_upto3years = r65_1year_upto3years;
	}
	public BigDecimal getR65_3year_upto5years() {
		return r65_3year_upto5years;
	}
	public void setR65_3year_upto5years(BigDecimal r65_3year_upto5years) {
		this.r65_3year_upto5years = r65_3year_upto5years;
	}
	public BigDecimal getR65_5year_upto7years() {
		return r65_5year_upto7years;
	}
	public void setR65_5year_upto7years(BigDecimal r65_5year_upto7years) {
		this.r65_5year_upto7years = r65_5year_upto7years;
	}
	public BigDecimal getR65_7year_upto10years() {
		return r65_7year_upto10years;
	}
	public void setR65_7year_upto10years(BigDecimal r65_7year_upto10years) {
		this.r65_7year_upto10years = r65_7year_upto10years;
	}
	public BigDecimal getR65_10year_upto15years() {
		return r65_10year_upto15years;
	}
	public void setR65_10year_upto15years(BigDecimal r65_10year_upto15years) {
		this.r65_10year_upto15years = r65_10year_upto15years;
	}
	public BigDecimal getR65_15years() {
		return r65_15years;
	}
	public void setR65_15years(BigDecimal r65_15years) {
		this.r65_15years = r65_15years;
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
	public BigDecimal getR66_1_to_28days() {
		return r66_1_to_28days;
	}
	public void setR66_1_to_28days(BigDecimal r66_1_to_28days) {
		this.r66_1_to_28days = r66_1_to_28days;
	}
	public BigDecimal getR66_29days_to_3months() {
		return r66_29days_to_3months;
	}
	public void setR66_29days_to_3months(BigDecimal r66_29days_to_3months) {
		this.r66_29days_to_3months = r66_29days_to_3months;
	}
	public BigDecimal getR66_3months_6months() {
		return r66_3months_6months;
	}
	public void setR66_3months_6months(BigDecimal r66_3months_6months) {
		this.r66_3months_6months = r66_3months_6months;
	}
	public BigDecimal getR66_6months_upto1year() {
		return r66_6months_upto1year;
	}
	public void setR66_6months_upto1year(BigDecimal r66_6months_upto1year) {
		this.r66_6months_upto1year = r66_6months_upto1year;
	}
	public BigDecimal getR66_1year_upto3years() {
		return r66_1year_upto3years;
	}
	public void setR66_1year_upto3years(BigDecimal r66_1year_upto3years) {
		this.r66_1year_upto3years = r66_1year_upto3years;
	}
	public BigDecimal getR66_3year_upto5years() {
		return r66_3year_upto5years;
	}
	public void setR66_3year_upto5years(BigDecimal r66_3year_upto5years) {
		this.r66_3year_upto5years = r66_3year_upto5years;
	}
	public BigDecimal getR66_5year_upto7years() {
		return r66_5year_upto7years;
	}
	public void setR66_5year_upto7years(BigDecimal r66_5year_upto7years) {
		this.r66_5year_upto7years = r66_5year_upto7years;
	}
	public BigDecimal getR66_7year_upto10years() {
		return r66_7year_upto10years;
	}
	public void setR66_7year_upto10years(BigDecimal r66_7year_upto10years) {
		this.r66_7year_upto10years = r66_7year_upto10years;
	}
	public BigDecimal getR66_10year_upto15years() {
		return r66_10year_upto15years;
	}
	public void setR66_10year_upto15years(BigDecimal r66_10year_upto15years) {
		this.r66_10year_upto15years = r66_10year_upto15years;
	}
	public BigDecimal getR66_15years() {
		return r66_15years;
	}
	public void setR66_15years(BigDecimal r66_15years) {
		this.r66_15years = r66_15years;
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
	public BigDecimal getR67_1_to_28days() {
		return r67_1_to_28days;
	}
	public void setR67_1_to_28days(BigDecimal r67_1_to_28days) {
		this.r67_1_to_28days = r67_1_to_28days;
	}
	public BigDecimal getR67_29days_to_3months() {
		return r67_29days_to_3months;
	}
	public void setR67_29days_to_3months(BigDecimal r67_29days_to_3months) {
		this.r67_29days_to_3months = r67_29days_to_3months;
	}
	public BigDecimal getR67_3months_6months() {
		return r67_3months_6months;
	}
	public void setR67_3months_6months(BigDecimal r67_3months_6months) {
		this.r67_3months_6months = r67_3months_6months;
	}
	public BigDecimal getR67_6months_upto1year() {
		return r67_6months_upto1year;
	}
	public void setR67_6months_upto1year(BigDecimal r67_6months_upto1year) {
		this.r67_6months_upto1year = r67_6months_upto1year;
	}
	public BigDecimal getR67_1year_upto3years() {
		return r67_1year_upto3years;
	}
	public void setR67_1year_upto3years(BigDecimal r67_1year_upto3years) {
		this.r67_1year_upto3years = r67_1year_upto3years;
	}
	public BigDecimal getR67_3year_upto5years() {
		return r67_3year_upto5years;
	}
	public void setR67_3year_upto5years(BigDecimal r67_3year_upto5years) {
		this.r67_3year_upto5years = r67_3year_upto5years;
	}
	public BigDecimal getR67_5year_upto7years() {
		return r67_5year_upto7years;
	}
	public void setR67_5year_upto7years(BigDecimal r67_5year_upto7years) {
		this.r67_5year_upto7years = r67_5year_upto7years;
	}
	public BigDecimal getR67_7year_upto10years() {
		return r67_7year_upto10years;
	}
	public void setR67_7year_upto10years(BigDecimal r67_7year_upto10years) {
		this.r67_7year_upto10years = r67_7year_upto10years;
	}
	public BigDecimal getR67_10year_upto15years() {
		return r67_10year_upto15years;
	}
	public void setR67_10year_upto15years(BigDecimal r67_10year_upto15years) {
		this.r67_10year_upto15years = r67_10year_upto15years;
	}
	public BigDecimal getR67_15years() {
		return r67_15years;
	}
	public void setR67_15years(BigDecimal r67_15years) {
		this.r67_15years = r67_15years;
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
	public BigDecimal getR68_1_to_28days() {
		return r68_1_to_28days;
	}
	public void setR68_1_to_28days(BigDecimal r68_1_to_28days) {
		this.r68_1_to_28days = r68_1_to_28days;
	}
	public BigDecimal getR68_29days_to_3months() {
		return r68_29days_to_3months;
	}
	public void setR68_29days_to_3months(BigDecimal r68_29days_to_3months) {
		this.r68_29days_to_3months = r68_29days_to_3months;
	}
	public BigDecimal getR68_3months_6months() {
		return r68_3months_6months;
	}
	public void setR68_3months_6months(BigDecimal r68_3months_6months) {
		this.r68_3months_6months = r68_3months_6months;
	}
	public BigDecimal getR68_6months_upto1year() {
		return r68_6months_upto1year;
	}
	public void setR68_6months_upto1year(BigDecimal r68_6months_upto1year) {
		this.r68_6months_upto1year = r68_6months_upto1year;
	}
	public BigDecimal getR68_1year_upto3years() {
		return r68_1year_upto3years;
	}
	public void setR68_1year_upto3years(BigDecimal r68_1year_upto3years) {
		this.r68_1year_upto3years = r68_1year_upto3years;
	}
	public BigDecimal getR68_3year_upto5years() {
		return r68_3year_upto5years;
	}
	public void setR68_3year_upto5years(BigDecimal r68_3year_upto5years) {
		this.r68_3year_upto5years = r68_3year_upto5years;
	}
	public BigDecimal getR68_5year_upto7years() {
		return r68_5year_upto7years;
	}
	public void setR68_5year_upto7years(BigDecimal r68_5year_upto7years) {
		this.r68_5year_upto7years = r68_5year_upto7years;
	}
	public BigDecimal getR68_7year_upto10years() {
		return r68_7year_upto10years;
	}
	public void setR68_7year_upto10years(BigDecimal r68_7year_upto10years) {
		this.r68_7year_upto10years = r68_7year_upto10years;
	}
	public BigDecimal getR68_10year_upto15years() {
		return r68_10year_upto15years;
	}
	public void setR68_10year_upto15years(BigDecimal r68_10year_upto15years) {
		this.r68_10year_upto15years = r68_10year_upto15years;
	}
	public BigDecimal getR68_15years() {
		return r68_15years;
	}
	public void setR68_15years(BigDecimal r68_15years) {
		this.r68_15years = r68_15years;
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
	public BigDecimal getR69_1_to_28days() {
		return r69_1_to_28days;
	}
	public void setR69_1_to_28days(BigDecimal r69_1_to_28days) {
		this.r69_1_to_28days = r69_1_to_28days;
	}
	public BigDecimal getR69_29days_to_3months() {
		return r69_29days_to_3months;
	}
	public void setR69_29days_to_3months(BigDecimal r69_29days_to_3months) {
		this.r69_29days_to_3months = r69_29days_to_3months;
	}
	public BigDecimal getR69_3months_6months() {
		return r69_3months_6months;
	}
	public void setR69_3months_6months(BigDecimal r69_3months_6months) {
		this.r69_3months_6months = r69_3months_6months;
	}
	public BigDecimal getR69_6months_upto1year() {
		return r69_6months_upto1year;
	}
	public void setR69_6months_upto1year(BigDecimal r69_6months_upto1year) {
		this.r69_6months_upto1year = r69_6months_upto1year;
	}
	public BigDecimal getR69_1year_upto3years() {
		return r69_1year_upto3years;
	}
	public void setR69_1year_upto3years(BigDecimal r69_1year_upto3years) {
		this.r69_1year_upto3years = r69_1year_upto3years;
	}
	public BigDecimal getR69_3year_upto5years() {
		return r69_3year_upto5years;
	}
	public void setR69_3year_upto5years(BigDecimal r69_3year_upto5years) {
		this.r69_3year_upto5years = r69_3year_upto5years;
	}
	public BigDecimal getR69_5year_upto7years() {
		return r69_5year_upto7years;
	}
	public void setR69_5year_upto7years(BigDecimal r69_5year_upto7years) {
		this.r69_5year_upto7years = r69_5year_upto7years;
	}
	public BigDecimal getR69_7year_upto10years() {
		return r69_7year_upto10years;
	}
	public void setR69_7year_upto10years(BigDecimal r69_7year_upto10years) {
		this.r69_7year_upto10years = r69_7year_upto10years;
	}
	public BigDecimal getR69_10year_upto15years() {
		return r69_10year_upto15years;
	}
	public void setR69_10year_upto15years(BigDecimal r69_10year_upto15years) {
		this.r69_10year_upto15years = r69_10year_upto15years;
	}
	public BigDecimal getR69_15years() {
		return r69_15years;
	}
	public void setR69_15years(BigDecimal r69_15years) {
		this.r69_15years = r69_15years;
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
	public BigDecimal getR70_1_to_28days() {
		return r70_1_to_28days;
	}
	public void setR70_1_to_28days(BigDecimal r70_1_to_28days) {
		this.r70_1_to_28days = r70_1_to_28days;
	}
	public BigDecimal getR70_29days_to_3months() {
		return r70_29days_to_3months;
	}
	public void setR70_29days_to_3months(BigDecimal r70_29days_to_3months) {
		this.r70_29days_to_3months = r70_29days_to_3months;
	}
	public BigDecimal getR70_3months_6months() {
		return r70_3months_6months;
	}
	public void setR70_3months_6months(BigDecimal r70_3months_6months) {
		this.r70_3months_6months = r70_3months_6months;
	}
	public BigDecimal getR70_6months_upto1year() {
		return r70_6months_upto1year;
	}
	public void setR70_6months_upto1year(BigDecimal r70_6months_upto1year) {
		this.r70_6months_upto1year = r70_6months_upto1year;
	}
	public BigDecimal getR70_1year_upto3years() {
		return r70_1year_upto3years;
	}
	public void setR70_1year_upto3years(BigDecimal r70_1year_upto3years) {
		this.r70_1year_upto3years = r70_1year_upto3years;
	}
	public BigDecimal getR70_3year_upto5years() {
		return r70_3year_upto5years;
	}
	public void setR70_3year_upto5years(BigDecimal r70_3year_upto5years) {
		this.r70_3year_upto5years = r70_3year_upto5years;
	}
	public BigDecimal getR70_5year_upto7years() {
		return r70_5year_upto7years;
	}
	public void setR70_5year_upto7years(BigDecimal r70_5year_upto7years) {
		this.r70_5year_upto7years = r70_5year_upto7years;
	}
	public BigDecimal getR70_7year_upto10years() {
		return r70_7year_upto10years;
	}
	public void setR70_7year_upto10years(BigDecimal r70_7year_upto10years) {
		this.r70_7year_upto10years = r70_7year_upto10years;
	}
	public BigDecimal getR70_10year_upto15years() {
		return r70_10year_upto15years;
	}
	public void setR70_10year_upto15years(BigDecimal r70_10year_upto15years) {
		this.r70_10year_upto15years = r70_10year_upto15years;
	}
	public BigDecimal getR70_15years() {
		return r70_15years;
	}
	public void setR70_15years(BigDecimal r70_15years) {
		this.r70_15years = r70_15years;
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
	public BigDecimal getR71_1_to_28days() {
		return r71_1_to_28days;
	}
	public void setR71_1_to_28days(BigDecimal r71_1_to_28days) {
		this.r71_1_to_28days = r71_1_to_28days;
	}
	public BigDecimal getR71_29days_to_3months() {
		return r71_29days_to_3months;
	}
	public void setR71_29days_to_3months(BigDecimal r71_29days_to_3months) {
		this.r71_29days_to_3months = r71_29days_to_3months;
	}
	public BigDecimal getR71_3months_6months() {
		return r71_3months_6months;
	}
	public void setR71_3months_6months(BigDecimal r71_3months_6months) {
		this.r71_3months_6months = r71_3months_6months;
	}
	public BigDecimal getR71_6months_upto1year() {
		return r71_6months_upto1year;
	}
	public void setR71_6months_upto1year(BigDecimal r71_6months_upto1year) {
		this.r71_6months_upto1year = r71_6months_upto1year;
	}
	public BigDecimal getR71_1year_upto3years() {
		return r71_1year_upto3years;
	}
	public void setR71_1year_upto3years(BigDecimal r71_1year_upto3years) {
		this.r71_1year_upto3years = r71_1year_upto3years;
	}
	public BigDecimal getR71_3year_upto5years() {
		return r71_3year_upto5years;
	}
	public void setR71_3year_upto5years(BigDecimal r71_3year_upto5years) {
		this.r71_3year_upto5years = r71_3year_upto5years;
	}
	public BigDecimal getR71_5year_upto7years() {
		return r71_5year_upto7years;
	}
	public void setR71_5year_upto7years(BigDecimal r71_5year_upto7years) {
		this.r71_5year_upto7years = r71_5year_upto7years;
	}
	public BigDecimal getR71_7year_upto10years() {
		return r71_7year_upto10years;
	}
	public void setR71_7year_upto10years(BigDecimal r71_7year_upto10years) {
		this.r71_7year_upto10years = r71_7year_upto10years;
	}
	public BigDecimal getR71_10year_upto15years() {
		return r71_10year_upto15years;
	}
	public void setR71_10year_upto15years(BigDecimal r71_10year_upto15years) {
		this.r71_10year_upto15years = r71_10year_upto15years;
	}
	public BigDecimal getR71_15years() {
		return r71_15years;
	}
	public void setR71_15years(BigDecimal r71_15years) {
		this.r71_15years = r71_15years;
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
	public BigDecimal getR72_1_to_28days() {
		return r72_1_to_28days;
	}
	public void setR72_1_to_28days(BigDecimal r72_1_to_28days) {
		this.r72_1_to_28days = r72_1_to_28days;
	}
	public BigDecimal getR72_29days_to_3months() {
		return r72_29days_to_3months;
	}
	public void setR72_29days_to_3months(BigDecimal r72_29days_to_3months) {
		this.r72_29days_to_3months = r72_29days_to_3months;
	}
	public BigDecimal getR72_3months_6months() {
		return r72_3months_6months;
	}
	public void setR72_3months_6months(BigDecimal r72_3months_6months) {
		this.r72_3months_6months = r72_3months_6months;
	}
	public BigDecimal getR72_6months_upto1year() {
		return r72_6months_upto1year;
	}
	public void setR72_6months_upto1year(BigDecimal r72_6months_upto1year) {
		this.r72_6months_upto1year = r72_6months_upto1year;
	}
	public BigDecimal getR72_1year_upto3years() {
		return r72_1year_upto3years;
	}
	public void setR72_1year_upto3years(BigDecimal r72_1year_upto3years) {
		this.r72_1year_upto3years = r72_1year_upto3years;
	}
	public BigDecimal getR72_3year_upto5years() {
		return r72_3year_upto5years;
	}
	public void setR72_3year_upto5years(BigDecimal r72_3year_upto5years) {
		this.r72_3year_upto5years = r72_3year_upto5years;
	}
	public BigDecimal getR72_5year_upto7years() {
		return r72_5year_upto7years;
	}
	public void setR72_5year_upto7years(BigDecimal r72_5year_upto7years) {
		this.r72_5year_upto7years = r72_5year_upto7years;
	}
	public BigDecimal getR72_7year_upto10years() {
		return r72_7year_upto10years;
	}
	public void setR72_7year_upto10years(BigDecimal r72_7year_upto10years) {
		this.r72_7year_upto10years = r72_7year_upto10years;
	}
	public BigDecimal getR72_10year_upto15years() {
		return r72_10year_upto15years;
	}
	public void setR72_10year_upto15years(BigDecimal r72_10year_upto15years) {
		this.r72_10year_upto15years = r72_10year_upto15years;
	}
	public BigDecimal getR72_15years() {
		return r72_15years;
	}
	public void setR72_15years(BigDecimal r72_15years) {
		this.r72_15years = r72_15years;
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
	public BigDecimal getR73_1_to_28days() {
		return r73_1_to_28days;
	}
	public void setR73_1_to_28days(BigDecimal r73_1_to_28days) {
		this.r73_1_to_28days = r73_1_to_28days;
	}
	public BigDecimal getR73_29days_to_3months() {
		return r73_29days_to_3months;
	}
	public void setR73_29days_to_3months(BigDecimal r73_29days_to_3months) {
		this.r73_29days_to_3months = r73_29days_to_3months;
	}
	public BigDecimal getR73_3months_6months() {
		return r73_3months_6months;
	}
	public void setR73_3months_6months(BigDecimal r73_3months_6months) {
		this.r73_3months_6months = r73_3months_6months;
	}
	public BigDecimal getR73_6months_upto1year() {
		return r73_6months_upto1year;
	}
	public void setR73_6months_upto1year(BigDecimal r73_6months_upto1year) {
		this.r73_6months_upto1year = r73_6months_upto1year;
	}
	public BigDecimal getR73_1year_upto3years() {
		return r73_1year_upto3years;
	}
	public void setR73_1year_upto3years(BigDecimal r73_1year_upto3years) {
		this.r73_1year_upto3years = r73_1year_upto3years;
	}
	public BigDecimal getR73_3year_upto5years() {
		return r73_3year_upto5years;
	}
	public void setR73_3year_upto5years(BigDecimal r73_3year_upto5years) {
		this.r73_3year_upto5years = r73_3year_upto5years;
	}
	public BigDecimal getR73_5year_upto7years() {
		return r73_5year_upto7years;
	}
	public void setR73_5year_upto7years(BigDecimal r73_5year_upto7years) {
		this.r73_5year_upto7years = r73_5year_upto7years;
	}
	public BigDecimal getR73_7year_upto10years() {
		return r73_7year_upto10years;
	}
	public void setR73_7year_upto10years(BigDecimal r73_7year_upto10years) {
		this.r73_7year_upto10years = r73_7year_upto10years;
	}
	public BigDecimal getR73_10year_upto15years() {
		return r73_10year_upto15years;
	}
	public void setR73_10year_upto15years(BigDecimal r73_10year_upto15years) {
		this.r73_10year_upto15years = r73_10year_upto15years;
	}
	public BigDecimal getR73_15years() {
		return r73_15years;
	}
	public void setR73_15years(BigDecimal r73_15years) {
		this.r73_15years = r73_15years;
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
	public BigDecimal getR74_1_to_28days() {
		return r74_1_to_28days;
	}
	public void setR74_1_to_28days(BigDecimal r74_1_to_28days) {
		this.r74_1_to_28days = r74_1_to_28days;
	}
	public BigDecimal getR74_29days_to_3months() {
		return r74_29days_to_3months;
	}
	public void setR74_29days_to_3months(BigDecimal r74_29days_to_3months) {
		this.r74_29days_to_3months = r74_29days_to_3months;
	}
	public BigDecimal getR74_3months_6months() {
		return r74_3months_6months;
	}
	public void setR74_3months_6months(BigDecimal r74_3months_6months) {
		this.r74_3months_6months = r74_3months_6months;
	}
	public BigDecimal getR74_6months_upto1year() {
		return r74_6months_upto1year;
	}
	public void setR74_6months_upto1year(BigDecimal r74_6months_upto1year) {
		this.r74_6months_upto1year = r74_6months_upto1year;
	}
	public BigDecimal getR74_1year_upto3years() {
		return r74_1year_upto3years;
	}
	public void setR74_1year_upto3years(BigDecimal r74_1year_upto3years) {
		this.r74_1year_upto3years = r74_1year_upto3years;
	}
	public BigDecimal getR74_3year_upto5years() {
		return r74_3year_upto5years;
	}
	public void setR74_3year_upto5years(BigDecimal r74_3year_upto5years) {
		this.r74_3year_upto5years = r74_3year_upto5years;
	}
	public BigDecimal getR74_5year_upto7years() {
		return r74_5year_upto7years;
	}
	public void setR74_5year_upto7years(BigDecimal r74_5year_upto7years) {
		this.r74_5year_upto7years = r74_5year_upto7years;
	}
	public BigDecimal getR74_7year_upto10years() {
		return r74_7year_upto10years;
	}
	public void setR74_7year_upto10years(BigDecimal r74_7year_upto10years) {
		this.r74_7year_upto10years = r74_7year_upto10years;
	}
	public BigDecimal getR74_10year_upto15years() {
		return r74_10year_upto15years;
	}
	public void setR74_10year_upto15years(BigDecimal r74_10year_upto15years) {
		this.r74_10year_upto15years = r74_10year_upto15years;
	}
	public BigDecimal getR74_15years() {
		return r74_15years;
	}
	public void setR74_15years(BigDecimal r74_15years) {
		this.r74_15years = r74_15years;
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
	public BigDecimal getR75_1_to_28days() {
		return r75_1_to_28days;
	}
	public void setR75_1_to_28days(BigDecimal r75_1_to_28days) {
		this.r75_1_to_28days = r75_1_to_28days;
	}
	public BigDecimal getR75_29days_to_3months() {
		return r75_29days_to_3months;
	}
	public void setR75_29days_to_3months(BigDecimal r75_29days_to_3months) {
		this.r75_29days_to_3months = r75_29days_to_3months;
	}
	public BigDecimal getR75_3months_6months() {
		return r75_3months_6months;
	}
	public void setR75_3months_6months(BigDecimal r75_3months_6months) {
		this.r75_3months_6months = r75_3months_6months;
	}
	public BigDecimal getR75_6months_upto1year() {
		return r75_6months_upto1year;
	}
	public void setR75_6months_upto1year(BigDecimal r75_6months_upto1year) {
		this.r75_6months_upto1year = r75_6months_upto1year;
	}
	public BigDecimal getR75_1year_upto3years() {
		return r75_1year_upto3years;
	}
	public void setR75_1year_upto3years(BigDecimal r75_1year_upto3years) {
		this.r75_1year_upto3years = r75_1year_upto3years;
	}
	public BigDecimal getR75_3year_upto5years() {
		return r75_3year_upto5years;
	}
	public void setR75_3year_upto5years(BigDecimal r75_3year_upto5years) {
		this.r75_3year_upto5years = r75_3year_upto5years;
	}
	public BigDecimal getR75_5year_upto7years() {
		return r75_5year_upto7years;
	}
	public void setR75_5year_upto7years(BigDecimal r75_5year_upto7years) {
		this.r75_5year_upto7years = r75_5year_upto7years;
	}
	public BigDecimal getR75_7year_upto10years() {
		return r75_7year_upto10years;
	}
	public void setR75_7year_upto10years(BigDecimal r75_7year_upto10years) {
		this.r75_7year_upto10years = r75_7year_upto10years;
	}
	public BigDecimal getR75_10year_upto15years() {
		return r75_10year_upto15years;
	}
	public void setR75_10year_upto15years(BigDecimal r75_10year_upto15years) {
		this.r75_10year_upto15years = r75_10year_upto15years;
	}
	public BigDecimal getR75_15years() {
		return r75_15years;
	}
	public void setR75_15years(BigDecimal r75_15years) {
		this.r75_15years = r75_15years;
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
	public BigDecimal getR76_1_to_28days() {
		return r76_1_to_28days;
	}
	public void setR76_1_to_28days(BigDecimal r76_1_to_28days) {
		this.r76_1_to_28days = r76_1_to_28days;
	}
	public BigDecimal getR76_29days_to_3months() {
		return r76_29days_to_3months;
	}
	public void setR76_29days_to_3months(BigDecimal r76_29days_to_3months) {
		this.r76_29days_to_3months = r76_29days_to_3months;
	}
	public BigDecimal getR76_3months_6months() {
		return r76_3months_6months;
	}
	public void setR76_3months_6months(BigDecimal r76_3months_6months) {
		this.r76_3months_6months = r76_3months_6months;
	}
	public BigDecimal getR76_6months_upto1year() {
		return r76_6months_upto1year;
	}
	public void setR76_6months_upto1year(BigDecimal r76_6months_upto1year) {
		this.r76_6months_upto1year = r76_6months_upto1year;
	}
	public BigDecimal getR76_1year_upto3years() {
		return r76_1year_upto3years;
	}
	public void setR76_1year_upto3years(BigDecimal r76_1year_upto3years) {
		this.r76_1year_upto3years = r76_1year_upto3years;
	}
	public BigDecimal getR76_3year_upto5years() {
		return r76_3year_upto5years;
	}
	public void setR76_3year_upto5years(BigDecimal r76_3year_upto5years) {
		this.r76_3year_upto5years = r76_3year_upto5years;
	}
	public BigDecimal getR76_5year_upto7years() {
		return r76_5year_upto7years;
	}
	public void setR76_5year_upto7years(BigDecimal r76_5year_upto7years) {
		this.r76_5year_upto7years = r76_5year_upto7years;
	}
	public BigDecimal getR76_7year_upto10years() {
		return r76_7year_upto10years;
	}
	public void setR76_7year_upto10years(BigDecimal r76_7year_upto10years) {
		this.r76_7year_upto10years = r76_7year_upto10years;
	}
	public BigDecimal getR76_10year_upto15years() {
		return r76_10year_upto15years;
	}
	public void setR76_10year_upto15years(BigDecimal r76_10year_upto15years) {
		this.r76_10year_upto15years = r76_10year_upto15years;
	}
	public BigDecimal getR76_15years() {
		return r76_15years;
	}
	public void setR76_15years(BigDecimal r76_15years) {
		this.r76_15years = r76_15years;
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
	public BigDecimal getR77_1_to_28days() {
		return r77_1_to_28days;
	}
	public void setR77_1_to_28days(BigDecimal r77_1_to_28days) {
		this.r77_1_to_28days = r77_1_to_28days;
	}
	public BigDecimal getR77_29days_to_3months() {
		return r77_29days_to_3months;
	}
	public void setR77_29days_to_3months(BigDecimal r77_29days_to_3months) {
		this.r77_29days_to_3months = r77_29days_to_3months;
	}
	public BigDecimal getR77_3months_6months() {
		return r77_3months_6months;
	}
	public void setR77_3months_6months(BigDecimal r77_3months_6months) {
		this.r77_3months_6months = r77_3months_6months;
	}
	public BigDecimal getR77_6months_upto1year() {
		return r77_6months_upto1year;
	}
	public void setR77_6months_upto1year(BigDecimal r77_6months_upto1year) {
		this.r77_6months_upto1year = r77_6months_upto1year;
	}
	public BigDecimal getR77_1year_upto3years() {
		return r77_1year_upto3years;
	}
	public void setR77_1year_upto3years(BigDecimal r77_1year_upto3years) {
		this.r77_1year_upto3years = r77_1year_upto3years;
	}
	public BigDecimal getR77_3year_upto5years() {
		return r77_3year_upto5years;
	}
	public void setR77_3year_upto5years(BigDecimal r77_3year_upto5years) {
		this.r77_3year_upto5years = r77_3year_upto5years;
	}
	public BigDecimal getR77_5year_upto7years() {
		return r77_5year_upto7years;
	}
	public void setR77_5year_upto7years(BigDecimal r77_5year_upto7years) {
		this.r77_5year_upto7years = r77_5year_upto7years;
	}
	public BigDecimal getR77_7year_upto10years() {
		return r77_7year_upto10years;
	}
	public void setR77_7year_upto10years(BigDecimal r77_7year_upto10years) {
		this.r77_7year_upto10years = r77_7year_upto10years;
	}
	public BigDecimal getR77_10year_upto15years() {
		return r77_10year_upto15years;
	}
	public void setR77_10year_upto15years(BigDecimal r77_10year_upto15years) {
		this.r77_10year_upto15years = r77_10year_upto15years;
	}
	public BigDecimal getR77_15years() {
		return r77_15years;
	}
	public void setR77_15years(BigDecimal r77_15years) {
		this.r77_15years = r77_15years;
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
	public BigDecimal getR78_1_to_28days() {
		return r78_1_to_28days;
	}
	public void setR78_1_to_28days(BigDecimal r78_1_to_28days) {
		this.r78_1_to_28days = r78_1_to_28days;
	}
	public BigDecimal getR78_29days_to_3months() {
		return r78_29days_to_3months;
	}
	public void setR78_29days_to_3months(BigDecimal r78_29days_to_3months) {
		this.r78_29days_to_3months = r78_29days_to_3months;
	}
	public BigDecimal getR78_3months_6months() {
		return r78_3months_6months;
	}
	public void setR78_3months_6months(BigDecimal r78_3months_6months) {
		this.r78_3months_6months = r78_3months_6months;
	}
	public BigDecimal getR78_6months_upto1year() {
		return r78_6months_upto1year;
	}
	public void setR78_6months_upto1year(BigDecimal r78_6months_upto1year) {
		this.r78_6months_upto1year = r78_6months_upto1year;
	}
	public BigDecimal getR78_1year_upto3years() {
		return r78_1year_upto3years;
	}
	public void setR78_1year_upto3years(BigDecimal r78_1year_upto3years) {
		this.r78_1year_upto3years = r78_1year_upto3years;
	}
	public BigDecimal getR78_3year_upto5years() {
		return r78_3year_upto5years;
	}
	public void setR78_3year_upto5years(BigDecimal r78_3year_upto5years) {
		this.r78_3year_upto5years = r78_3year_upto5years;
	}
	public BigDecimal getR78_5year_upto7years() {
		return r78_5year_upto7years;
	}
	public void setR78_5year_upto7years(BigDecimal r78_5year_upto7years) {
		this.r78_5year_upto7years = r78_5year_upto7years;
	}
	public BigDecimal getR78_7year_upto10years() {
		return r78_7year_upto10years;
	}
	public void setR78_7year_upto10years(BigDecimal r78_7year_upto10years) {
		this.r78_7year_upto10years = r78_7year_upto10years;
	}
	public BigDecimal getR78_10year_upto15years() {
		return r78_10year_upto15years;
	}
	public void setR78_10year_upto15years(BigDecimal r78_10year_upto15years) {
		this.r78_10year_upto15years = r78_10year_upto15years;
	}
	public BigDecimal getR78_15years() {
		return r78_15years;
	}
	public void setR78_15years(BigDecimal r78_15years) {
		this.r78_15years = r78_15years;
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
	public BigDecimal getR79_1_to_28days() {
		return r79_1_to_28days;
	}
	public void setR79_1_to_28days(BigDecimal r79_1_to_28days) {
		this.r79_1_to_28days = r79_1_to_28days;
	}
	public BigDecimal getR79_29days_to_3months() {
		return r79_29days_to_3months;
	}
	public void setR79_29days_to_3months(BigDecimal r79_29days_to_3months) {
		this.r79_29days_to_3months = r79_29days_to_3months;
	}
	public BigDecimal getR79_3months_6months() {
		return r79_3months_6months;
	}
	public void setR79_3months_6months(BigDecimal r79_3months_6months) {
		this.r79_3months_6months = r79_3months_6months;
	}
	public BigDecimal getR79_6months_upto1year() {
		return r79_6months_upto1year;
	}
	public void setR79_6months_upto1year(BigDecimal r79_6months_upto1year) {
		this.r79_6months_upto1year = r79_6months_upto1year;
	}
	public BigDecimal getR79_1year_upto3years() {
		return r79_1year_upto3years;
	}
	public void setR79_1year_upto3years(BigDecimal r79_1year_upto3years) {
		this.r79_1year_upto3years = r79_1year_upto3years;
	}
	public BigDecimal getR79_3year_upto5years() {
		return r79_3year_upto5years;
	}
	public void setR79_3year_upto5years(BigDecimal r79_3year_upto5years) {
		this.r79_3year_upto5years = r79_3year_upto5years;
	}
	public BigDecimal getR79_5year_upto7years() {
		return r79_5year_upto7years;
	}
	public void setR79_5year_upto7years(BigDecimal r79_5year_upto7years) {
		this.r79_5year_upto7years = r79_5year_upto7years;
	}
	public BigDecimal getR79_7year_upto10years() {
		return r79_7year_upto10years;
	}
	public void setR79_7year_upto10years(BigDecimal r79_7year_upto10years) {
		this.r79_7year_upto10years = r79_7year_upto10years;
	}
	public BigDecimal getR79_10year_upto15years() {
		return r79_10year_upto15years;
	}
	public void setR79_10year_upto15years(BigDecimal r79_10year_upto15years) {
		this.r79_10year_upto15years = r79_10year_upto15years;
	}
	public BigDecimal getR79_15years() {
		return r79_15years;
	}
	public void setR79_15years(BigDecimal r79_15years) {
		this.r79_15years = r79_15years;
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
	public BigDecimal getR80_1_to_28days() {
		return r80_1_to_28days;
	}
	public void setR80_1_to_28days(BigDecimal r80_1_to_28days) {
		this.r80_1_to_28days = r80_1_to_28days;
	}
	public BigDecimal getR80_29days_to_3months() {
		return r80_29days_to_3months;
	}
	public void setR80_29days_to_3months(BigDecimal r80_29days_to_3months) {
		this.r80_29days_to_3months = r80_29days_to_3months;
	}
	public BigDecimal getR80_3months_6months() {
		return r80_3months_6months;
	}
	public void setR80_3months_6months(BigDecimal r80_3months_6months) {
		this.r80_3months_6months = r80_3months_6months;
	}
	public BigDecimal getR80_6months_upto1year() {
		return r80_6months_upto1year;
	}
	public void setR80_6months_upto1year(BigDecimal r80_6months_upto1year) {
		this.r80_6months_upto1year = r80_6months_upto1year;
	}
	public BigDecimal getR80_1year_upto3years() {
		return r80_1year_upto3years;
	}
	public void setR80_1year_upto3years(BigDecimal r80_1year_upto3years) {
		this.r80_1year_upto3years = r80_1year_upto3years;
	}
	public BigDecimal getR80_3year_upto5years() {
		return r80_3year_upto5years;
	}
	public void setR80_3year_upto5years(BigDecimal r80_3year_upto5years) {
		this.r80_3year_upto5years = r80_3year_upto5years;
	}
	public BigDecimal getR80_5year_upto7years() {
		return r80_5year_upto7years;
	}
	public void setR80_5year_upto7years(BigDecimal r80_5year_upto7years) {
		this.r80_5year_upto7years = r80_5year_upto7years;
	}
	public BigDecimal getR80_7year_upto10years() {
		return r80_7year_upto10years;
	}
	public void setR80_7year_upto10years(BigDecimal r80_7year_upto10years) {
		this.r80_7year_upto10years = r80_7year_upto10years;
	}
	public BigDecimal getR80_10year_upto15years() {
		return r80_10year_upto15years;
	}
	public void setR80_10year_upto15years(BigDecimal r80_10year_upto15years) {
		this.r80_10year_upto15years = r80_10year_upto15years;
	}
	public BigDecimal getR80_15years() {
		return r80_15years;
	}
	public void setR80_15years(BigDecimal r80_15years) {
		this.r80_15years = r80_15years;
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
	public BigDecimal getR81_1_to_28days() {
		return r81_1_to_28days;
	}
	public void setR81_1_to_28days(BigDecimal r81_1_to_28days) {
		this.r81_1_to_28days = r81_1_to_28days;
	}
	public BigDecimal getR81_29days_to_3months() {
		return r81_29days_to_3months;
	}
	public void setR81_29days_to_3months(BigDecimal r81_29days_to_3months) {
		this.r81_29days_to_3months = r81_29days_to_3months;
	}
	public BigDecimal getR81_3months_6months() {
		return r81_3months_6months;
	}
	public void setR81_3months_6months(BigDecimal r81_3months_6months) {
		this.r81_3months_6months = r81_3months_6months;
	}
	public BigDecimal getR81_6months_upto1year() {
		return r81_6months_upto1year;
	}
	public void setR81_6months_upto1year(BigDecimal r81_6months_upto1year) {
		this.r81_6months_upto1year = r81_6months_upto1year;
	}
	public BigDecimal getR81_1year_upto3years() {
		return r81_1year_upto3years;
	}
	public void setR81_1year_upto3years(BigDecimal r81_1year_upto3years) {
		this.r81_1year_upto3years = r81_1year_upto3years;
	}
	public BigDecimal getR81_3year_upto5years() {
		return r81_3year_upto5years;
	}
	public void setR81_3year_upto5years(BigDecimal r81_3year_upto5years) {
		this.r81_3year_upto5years = r81_3year_upto5years;
	}
	public BigDecimal getR81_5year_upto7years() {
		return r81_5year_upto7years;
	}
	public void setR81_5year_upto7years(BigDecimal r81_5year_upto7years) {
		this.r81_5year_upto7years = r81_5year_upto7years;
	}
	public BigDecimal getR81_7year_upto10years() {
		return r81_7year_upto10years;
	}
	public void setR81_7year_upto10years(BigDecimal r81_7year_upto10years) {
		this.r81_7year_upto10years = r81_7year_upto10years;
	}
	public BigDecimal getR81_10year_upto15years() {
		return r81_10year_upto15years;
	}
	public void setR81_10year_upto15years(BigDecimal r81_10year_upto15years) {
		this.r81_10year_upto15years = r81_10year_upto15years;
	}
	public BigDecimal getR81_15years() {
		return r81_15years;
	}
	public void setR81_15years(BigDecimal r81_15years) {
		this.r81_15years = r81_15years;
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
	public BigDecimal getR82_1_to_28days() {
		return r82_1_to_28days;
	}
	public void setR82_1_to_28days(BigDecimal r82_1_to_28days) {
		this.r82_1_to_28days = r82_1_to_28days;
	}
	public BigDecimal getR82_29days_to_3months() {
		return r82_29days_to_3months;
	}
	public void setR82_29days_to_3months(BigDecimal r82_29days_to_3months) {
		this.r82_29days_to_3months = r82_29days_to_3months;
	}
	public BigDecimal getR82_3months_6months() {
		return r82_3months_6months;
	}
	public void setR82_3months_6months(BigDecimal r82_3months_6months) {
		this.r82_3months_6months = r82_3months_6months;
	}
	public BigDecimal getR82_6months_upto1year() {
		return r82_6months_upto1year;
	}
	public void setR82_6months_upto1year(BigDecimal r82_6months_upto1year) {
		this.r82_6months_upto1year = r82_6months_upto1year;
	}
	public BigDecimal getR82_1year_upto3years() {
		return r82_1year_upto3years;
	}
	public void setR82_1year_upto3years(BigDecimal r82_1year_upto3years) {
		this.r82_1year_upto3years = r82_1year_upto3years;
	}
	public BigDecimal getR82_3year_upto5years() {
		return r82_3year_upto5years;
	}
	public void setR82_3year_upto5years(BigDecimal r82_3year_upto5years) {
		this.r82_3year_upto5years = r82_3year_upto5years;
	}
	public BigDecimal getR82_5year_upto7years() {
		return r82_5year_upto7years;
	}
	public void setR82_5year_upto7years(BigDecimal r82_5year_upto7years) {
		this.r82_5year_upto7years = r82_5year_upto7years;
	}
	public BigDecimal getR82_7year_upto10years() {
		return r82_7year_upto10years;
	}
	public void setR82_7year_upto10years(BigDecimal r82_7year_upto10years) {
		this.r82_7year_upto10years = r82_7year_upto10years;
	}
	public BigDecimal getR82_10year_upto15years() {
		return r82_10year_upto15years;
	}
	public void setR82_10year_upto15years(BigDecimal r82_10year_upto15years) {
		this.r82_10year_upto15years = r82_10year_upto15years;
	}
	public BigDecimal getR82_15years() {
		return r82_15years;
	}
	public void setR82_15years(BigDecimal r82_15years) {
		this.r82_15years = r82_15years;
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
	public BigDecimal getR83_1_to_28days() {
		return r83_1_to_28days;
	}
	public void setR83_1_to_28days(BigDecimal r83_1_to_28days) {
		this.r83_1_to_28days = r83_1_to_28days;
	}
	public BigDecimal getR83_29days_to_3months() {
		return r83_29days_to_3months;
	}
	public void setR83_29days_to_3months(BigDecimal r83_29days_to_3months) {
		this.r83_29days_to_3months = r83_29days_to_3months;
	}
	public BigDecimal getR83_3months_6months() {
		return r83_3months_6months;
	}
	public void setR83_3months_6months(BigDecimal r83_3months_6months) {
		this.r83_3months_6months = r83_3months_6months;
	}
	public BigDecimal getR83_6months_upto1year() {
		return r83_6months_upto1year;
	}
	public void setR83_6months_upto1year(BigDecimal r83_6months_upto1year) {
		this.r83_6months_upto1year = r83_6months_upto1year;
	}
	public BigDecimal getR83_1year_upto3years() {
		return r83_1year_upto3years;
	}
	public void setR83_1year_upto3years(BigDecimal r83_1year_upto3years) {
		this.r83_1year_upto3years = r83_1year_upto3years;
	}
	public BigDecimal getR83_3year_upto5years() {
		return r83_3year_upto5years;
	}
	public void setR83_3year_upto5years(BigDecimal r83_3year_upto5years) {
		this.r83_3year_upto5years = r83_3year_upto5years;
	}
	public BigDecimal getR83_5year_upto7years() {
		return r83_5year_upto7years;
	}
	public void setR83_5year_upto7years(BigDecimal r83_5year_upto7years) {
		this.r83_5year_upto7years = r83_5year_upto7years;
	}
	public BigDecimal getR83_7year_upto10years() {
		return r83_7year_upto10years;
	}
	public void setR83_7year_upto10years(BigDecimal r83_7year_upto10years) {
		this.r83_7year_upto10years = r83_7year_upto10years;
	}
	public BigDecimal getR83_10year_upto15years() {
		return r83_10year_upto15years;
	}
	public void setR83_10year_upto15years(BigDecimal r83_10year_upto15years) {
		this.r83_10year_upto15years = r83_10year_upto15years;
	}
	public BigDecimal getR83_15years() {
		return r83_15years;
	}
	public void setR83_15years(BigDecimal r83_15years) {
		this.r83_15years = r83_15years;
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
	public BigDecimal getR84_1_to_28days() {
		return r84_1_to_28days;
	}
	public void setR84_1_to_28days(BigDecimal r84_1_to_28days) {
		this.r84_1_to_28days = r84_1_to_28days;
	}
	public BigDecimal getR84_29days_to_3months() {
		return r84_29days_to_3months;
	}
	public void setR84_29days_to_3months(BigDecimal r84_29days_to_3months) {
		this.r84_29days_to_3months = r84_29days_to_3months;
	}
	public BigDecimal getR84_3months_6months() {
		return r84_3months_6months;
	}
	public void setR84_3months_6months(BigDecimal r84_3months_6months) {
		this.r84_3months_6months = r84_3months_6months;
	}
	public BigDecimal getR84_6months_upto1year() {
		return r84_6months_upto1year;
	}
	public void setR84_6months_upto1year(BigDecimal r84_6months_upto1year) {
		this.r84_6months_upto1year = r84_6months_upto1year;
	}
	public BigDecimal getR84_1year_upto3years() {
		return r84_1year_upto3years;
	}
	public void setR84_1year_upto3years(BigDecimal r84_1year_upto3years) {
		this.r84_1year_upto3years = r84_1year_upto3years;
	}
	public BigDecimal getR84_3year_upto5years() {
		return r84_3year_upto5years;
	}
	public void setR84_3year_upto5years(BigDecimal r84_3year_upto5years) {
		this.r84_3year_upto5years = r84_3year_upto5years;
	}
	public BigDecimal getR84_5year_upto7years() {
		return r84_5year_upto7years;
	}
	public void setR84_5year_upto7years(BigDecimal r84_5year_upto7years) {
		this.r84_5year_upto7years = r84_5year_upto7years;
	}
	public BigDecimal getR84_7year_upto10years() {
		return r84_7year_upto10years;
	}
	public void setR84_7year_upto10years(BigDecimal r84_7year_upto10years) {
		this.r84_7year_upto10years = r84_7year_upto10years;
	}
	public BigDecimal getR84_10year_upto15years() {
		return r84_10year_upto15years;
	}
	public void setR84_10year_upto15years(BigDecimal r84_10year_upto15years) {
		this.r84_10year_upto15years = r84_10year_upto15years;
	}
	public BigDecimal getR84_15years() {
		return r84_15years;
	}
	public void setR84_15years(BigDecimal r84_15years) {
		this.r84_15years = r84_15years;
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
	public BigDecimal getR85_1_to_28days() {
		return r85_1_to_28days;
	}
	public void setR85_1_to_28days(BigDecimal r85_1_to_28days) {
		this.r85_1_to_28days = r85_1_to_28days;
	}
	public BigDecimal getR85_29days_to_3months() {
		return r85_29days_to_3months;
	}
	public void setR85_29days_to_3months(BigDecimal r85_29days_to_3months) {
		this.r85_29days_to_3months = r85_29days_to_3months;
	}
	public BigDecimal getR85_3months_6months() {
		return r85_3months_6months;
	}
	public void setR85_3months_6months(BigDecimal r85_3months_6months) {
		this.r85_3months_6months = r85_3months_6months;
	}
	public BigDecimal getR85_6months_upto1year() {
		return r85_6months_upto1year;
	}
	public void setR85_6months_upto1year(BigDecimal r85_6months_upto1year) {
		this.r85_6months_upto1year = r85_6months_upto1year;
	}
	public BigDecimal getR85_1year_upto3years() {
		return r85_1year_upto3years;
	}
	public void setR85_1year_upto3years(BigDecimal r85_1year_upto3years) {
		this.r85_1year_upto3years = r85_1year_upto3years;
	}
	public BigDecimal getR85_3year_upto5years() {
		return r85_3year_upto5years;
	}
	public void setR85_3year_upto5years(BigDecimal r85_3year_upto5years) {
		this.r85_3year_upto5years = r85_3year_upto5years;
	}
	public BigDecimal getR85_5year_upto7years() {
		return r85_5year_upto7years;
	}
	public void setR85_5year_upto7years(BigDecimal r85_5year_upto7years) {
		this.r85_5year_upto7years = r85_5year_upto7years;
	}
	public BigDecimal getR85_7year_upto10years() {
		return r85_7year_upto10years;
	}
	public void setR85_7year_upto10years(BigDecimal r85_7year_upto10years) {
		this.r85_7year_upto10years = r85_7year_upto10years;
	}
	public BigDecimal getR85_10year_upto15years() {
		return r85_10year_upto15years;
	}
	public void setR85_10year_upto15years(BigDecimal r85_10year_upto15years) {
		this.r85_10year_upto15years = r85_10year_upto15years;
	}
	public BigDecimal getR85_15years() {
		return r85_15years;
	}
	public void setR85_15years(BigDecimal r85_15years) {
		this.r85_15years = r85_15years;
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
	public BigDecimal getR86_1_to_28days() {
		return r86_1_to_28days;
	}
	public void setR86_1_to_28days(BigDecimal r86_1_to_28days) {
		this.r86_1_to_28days = r86_1_to_28days;
	}
	public BigDecimal getR86_29days_to_3months() {
		return r86_29days_to_3months;
	}
	public void setR86_29days_to_3months(BigDecimal r86_29days_to_3months) {
		this.r86_29days_to_3months = r86_29days_to_3months;
	}
	public BigDecimal getR86_3months_6months() {
		return r86_3months_6months;
	}
	public void setR86_3months_6months(BigDecimal r86_3months_6months) {
		this.r86_3months_6months = r86_3months_6months;
	}
	public BigDecimal getR86_6months_upto1year() {
		return r86_6months_upto1year;
	}
	public void setR86_6months_upto1year(BigDecimal r86_6months_upto1year) {
		this.r86_6months_upto1year = r86_6months_upto1year;
	}
	public BigDecimal getR86_1year_upto3years() {
		return r86_1year_upto3years;
	}
	public void setR86_1year_upto3years(BigDecimal r86_1year_upto3years) {
		this.r86_1year_upto3years = r86_1year_upto3years;
	}
	public BigDecimal getR86_3year_upto5years() {
		return r86_3year_upto5years;
	}
	public void setR86_3year_upto5years(BigDecimal r86_3year_upto5years) {
		this.r86_3year_upto5years = r86_3year_upto5years;
	}
	public BigDecimal getR86_5year_upto7years() {
		return r86_5year_upto7years;
	}
	public void setR86_5year_upto7years(BigDecimal r86_5year_upto7years) {
		this.r86_5year_upto7years = r86_5year_upto7years;
	}
	public BigDecimal getR86_7year_upto10years() {
		return r86_7year_upto10years;
	}
	public void setR86_7year_upto10years(BigDecimal r86_7year_upto10years) {
		this.r86_7year_upto10years = r86_7year_upto10years;
	}
	public BigDecimal getR86_10year_upto15years() {
		return r86_10year_upto15years;
	}
	public void setR86_10year_upto15years(BigDecimal r86_10year_upto15years) {
		this.r86_10year_upto15years = r86_10year_upto15years;
	}
	public BigDecimal getR86_15years() {
		return r86_15years;
	}
	public void setR86_15years(BigDecimal r86_15years) {
		this.r86_15years = r86_15years;
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
	public BigDecimal getR87_1_to_28days() {
		return r87_1_to_28days;
	}
	public void setR87_1_to_28days(BigDecimal r87_1_to_28days) {
		this.r87_1_to_28days = r87_1_to_28days;
	}
	public BigDecimal getR87_29days_to_3months() {
		return r87_29days_to_3months;
	}
	public void setR87_29days_to_3months(BigDecimal r87_29days_to_3months) {
		this.r87_29days_to_3months = r87_29days_to_3months;
	}
	public BigDecimal getR87_3months_6months() {
		return r87_3months_6months;
	}
	public void setR87_3months_6months(BigDecimal r87_3months_6months) {
		this.r87_3months_6months = r87_3months_6months;
	}
	public BigDecimal getR87_6months_upto1year() {
		return r87_6months_upto1year;
	}
	public void setR87_6months_upto1year(BigDecimal r87_6months_upto1year) {
		this.r87_6months_upto1year = r87_6months_upto1year;
	}
	public BigDecimal getR87_1year_upto3years() {
		return r87_1year_upto3years;
	}
	public void setR87_1year_upto3years(BigDecimal r87_1year_upto3years) {
		this.r87_1year_upto3years = r87_1year_upto3years;
	}
	public BigDecimal getR87_3year_upto5years() {
		return r87_3year_upto5years;
	}
	public void setR87_3year_upto5years(BigDecimal r87_3year_upto5years) {
		this.r87_3year_upto5years = r87_3year_upto5years;
	}
	public BigDecimal getR87_5year_upto7years() {
		return r87_5year_upto7years;
	}
	public void setR87_5year_upto7years(BigDecimal r87_5year_upto7years) {
		this.r87_5year_upto7years = r87_5year_upto7years;
	}
	public BigDecimal getR87_7year_upto10years() {
		return r87_7year_upto10years;
	}
	public void setR87_7year_upto10years(BigDecimal r87_7year_upto10years) {
		this.r87_7year_upto10years = r87_7year_upto10years;
	}
	public BigDecimal getR87_10year_upto15years() {
		return r87_10year_upto15years;
	}
	public void setR87_10year_upto15years(BigDecimal r87_10year_upto15years) {
		this.r87_10year_upto15years = r87_10year_upto15years;
	}
	public BigDecimal getR87_15years() {
		return r87_15years;
	}
	public void setR87_15years(BigDecimal r87_15years) {
		this.r87_15years = r87_15years;
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
	public BigDecimal getR88_1_to_28days() {
		return r88_1_to_28days;
	}
	public void setR88_1_to_28days(BigDecimal r88_1_to_28days) {
		this.r88_1_to_28days = r88_1_to_28days;
	}
	public BigDecimal getR88_29days_to_3months() {
		return r88_29days_to_3months;
	}
	public void setR88_29days_to_3months(BigDecimal r88_29days_to_3months) {
		this.r88_29days_to_3months = r88_29days_to_3months;
	}
	public BigDecimal getR88_3months_6months() {
		return r88_3months_6months;
	}
	public void setR88_3months_6months(BigDecimal r88_3months_6months) {
		this.r88_3months_6months = r88_3months_6months;
	}
	public BigDecimal getR88_6months_upto1year() {
		return r88_6months_upto1year;
	}
	public void setR88_6months_upto1year(BigDecimal r88_6months_upto1year) {
		this.r88_6months_upto1year = r88_6months_upto1year;
	}
	public BigDecimal getR88_1year_upto3years() {
		return r88_1year_upto3years;
	}
	public void setR88_1year_upto3years(BigDecimal r88_1year_upto3years) {
		this.r88_1year_upto3years = r88_1year_upto3years;
	}
	public BigDecimal getR88_3year_upto5years() {
		return r88_3year_upto5years;
	}
	public void setR88_3year_upto5years(BigDecimal r88_3year_upto5years) {
		this.r88_3year_upto5years = r88_3year_upto5years;
	}
	public BigDecimal getR88_5year_upto7years() {
		return r88_5year_upto7years;
	}
	public void setR88_5year_upto7years(BigDecimal r88_5year_upto7years) {
		this.r88_5year_upto7years = r88_5year_upto7years;
	}
	public BigDecimal getR88_7year_upto10years() {
		return r88_7year_upto10years;
	}
	public void setR88_7year_upto10years(BigDecimal r88_7year_upto10years) {
		this.r88_7year_upto10years = r88_7year_upto10years;
	}
	public BigDecimal getR88_10year_upto15years() {
		return r88_10year_upto15years;
	}
	public void setR88_10year_upto15years(BigDecimal r88_10year_upto15years) {
		this.r88_10year_upto15years = r88_10year_upto15years;
	}
	public BigDecimal getR88_15years() {
		return r88_15years;
	}
	public void setR88_15years(BigDecimal r88_15years) {
		this.r88_15years = r88_15years;
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
	public BigDecimal getR89_1_to_28days() {
		return r89_1_to_28days;
	}
	public void setR89_1_to_28days(BigDecimal r89_1_to_28days) {
		this.r89_1_to_28days = r89_1_to_28days;
	}
	public BigDecimal getR89_29days_to_3months() {
		return r89_29days_to_3months;
	}
	public void setR89_29days_to_3months(BigDecimal r89_29days_to_3months) {
		this.r89_29days_to_3months = r89_29days_to_3months;
	}
	public BigDecimal getR89_3months_6months() {
		return r89_3months_6months;
	}
	public void setR89_3months_6months(BigDecimal r89_3months_6months) {
		this.r89_3months_6months = r89_3months_6months;
	}
	public BigDecimal getR89_6months_upto1year() {
		return r89_6months_upto1year;
	}
	public void setR89_6months_upto1year(BigDecimal r89_6months_upto1year) {
		this.r89_6months_upto1year = r89_6months_upto1year;
	}
	public BigDecimal getR89_1year_upto3years() {
		return r89_1year_upto3years;
	}
	public void setR89_1year_upto3years(BigDecimal r89_1year_upto3years) {
		this.r89_1year_upto3years = r89_1year_upto3years;
	}
	public BigDecimal getR89_3year_upto5years() {
		return r89_3year_upto5years;
	}
	public void setR89_3year_upto5years(BigDecimal r89_3year_upto5years) {
		this.r89_3year_upto5years = r89_3year_upto5years;
	}
	public BigDecimal getR89_5year_upto7years() {
		return r89_5year_upto7years;
	}
	public void setR89_5year_upto7years(BigDecimal r89_5year_upto7years) {
		this.r89_5year_upto7years = r89_5year_upto7years;
	}
	public BigDecimal getR89_7year_upto10years() {
		return r89_7year_upto10years;
	}
	public void setR89_7year_upto10years(BigDecimal r89_7year_upto10years) {
		this.r89_7year_upto10years = r89_7year_upto10years;
	}
	public BigDecimal getR89_10year_upto15years() {
		return r89_10year_upto15years;
	}
	public void setR89_10year_upto15years(BigDecimal r89_10year_upto15years) {
		this.r89_10year_upto15years = r89_10year_upto15years;
	}
	public BigDecimal getR89_15years() {
		return r89_15years;
	}
	public void setR89_15years(BigDecimal r89_15years) {
		this.r89_15years = r89_15years;
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
	public Banking_Book2() {
		super();
		// TODO Auto-generated constructor stub
	}
}