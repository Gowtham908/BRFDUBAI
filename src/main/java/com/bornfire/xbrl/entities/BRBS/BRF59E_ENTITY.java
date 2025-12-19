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
@Table(name="BRF59E_SUMMARYTABLE")
public class BRF59E_ENTITY {
	private String	country_break_down;
    private String	remaining;
	private BigDecimal	nbfi;
	private BigDecimal	interbank;
	private BigDecimal	gov;
	private BigDecimal	corporate;
	private BigDecimal	gre;
	private BigDecimal	trade;
	private BigDecimal	individuals;
	private BigDecimal	investment;
	private BigDecimal	nbfi1;
	private BigDecimal	interbank1;
	private BigDecimal	gov1;
	private BigDecimal	corporate1;
	private BigDecimal	gre1;
	private BigDecimal	trade1;
	private BigDecimal	individuals1;
	private BigDecimal	investment1;
	private BigDecimal	zer0;
	private BigDecimal	three;
	private BigDecimal	six;
	private BigDecimal	oneyear;
	private BigDecimal	foreign;
	private BigDecimal	banks;
	private BigDecimal	gov2;
	private BigDecimal	other;
	private BigDecimal	banks1;
	private BigDecimal	individuals2;
	private BigDecimal	other1;
	private BigDecimal	banks2;
	private BigDecimal	gov3;
	private BigDecimal	others2;
	private BigDecimal	banks3;
	private BigDecimal	gov4;
	private BigDecimal	others3;
	private BigDecimal	foreign1;
	private BigDecimal	guarantees;
	private BigDecimal	nbfi2;
	private BigDecimal	interbank2;
	private BigDecimal	gov5;
	private BigDecimal	corporate2;
	private BigDecimal	gre2;
	private BigDecimal	individuals3;
	private BigDecimal	zero1;
	private BigDecimal	three1;
	private BigDecimal	six1;
	private BigDecimal	oneyear1;
	private String	empty;
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
	private String	row_label; 
	private String	repdesc;
	private String	frequency;
	public String getCountry_break_down() {
		return country_break_down;
	}
	public void setCountry_break_down(String country_break_down) {
		this.country_break_down = country_break_down;
	}
	public String getRemaining() {
		return remaining;
	}
	public void setRemaining(String remaining) {
		this.remaining = remaining;
	}
	public BigDecimal getNbfi() {
		return nbfi;
	}
	public void setNbfi(BigDecimal nbfi) {
		this.nbfi = nbfi;
	}
	public BigDecimal getInterbank() {
		return interbank;
	}
	public void setInterbank(BigDecimal interbank) {
		this.interbank = interbank;
	}
	public BigDecimal getGov() {
		return gov;
	}
	public void setGov(BigDecimal gov) {
		this.gov = gov;
	}
	public BigDecimal getCorporate() {
		return corporate;
	}
	public void setCorporate(BigDecimal corporate) {
		this.corporate = corporate;
	}
	public BigDecimal getGre() {
		return gre;
	}
	public void setGre(BigDecimal gre) {
		this.gre = gre;
	}
	public BigDecimal getTrade() {
		return trade;
	}
	public void setTrade(BigDecimal trade) {
		this.trade = trade;
	}
	public BigDecimal getIndividuals() {
		return individuals;
	}
	public void setIndividuals(BigDecimal individuals) {
		this.individuals = individuals;
	}
	public BigDecimal getInvestment() {
		return investment;
	}
	public void setInvestment(BigDecimal investment) {
		this.investment = investment;
	}
	public BigDecimal getNbfi1() {
		return nbfi1;
	}
	public void setNbfi1(BigDecimal nbfi1) {
		this.nbfi1 = nbfi1;
	}
	public BigDecimal getInterbank1() {
		return interbank1;
	}
	public void setInterbank1(BigDecimal interbank1) {
		this.interbank1 = interbank1;
	}
	public BigDecimal getGov1() {
		return gov1;
	}
	public void setGov1(BigDecimal gov1) {
		this.gov1 = gov1;
	}
	public BigDecimal getCorporate1() {
		return corporate1;
	}
	public void setCorporate1(BigDecimal corporate1) {
		this.corporate1 = corporate1;
	}
	public BigDecimal getGre1() {
		return gre1;
	}
	public void setGre1(BigDecimal gre1) {
		this.gre1 = gre1;
	}
	public BigDecimal getTrade1() {
		return trade1;
	}
	public void setTrade1(BigDecimal trade1) {
		this.trade1 = trade1;
	}
	public BigDecimal getIndividuals1() {
		return individuals1;
	}
	public void setIndividuals1(BigDecimal individuals1) {
		this.individuals1 = individuals1;
	}
	public BigDecimal getInvestment1() {
		return investment1;
	}
	public void setInvestment1(BigDecimal investment1) {
		this.investment1 = investment1;
	}
	public BigDecimal getZer0() {
		return zer0;
	}
	public void setZer0(BigDecimal zer0) {
		this.zer0 = zer0;
	}
	public BigDecimal getThree() {
		return three;
	}
	public void setThree(BigDecimal three) {
		this.three = three;
	}
	public BigDecimal getSix() {
		return six;
	}
	public void setSix(BigDecimal six) {
		this.six = six;
	}
	public BigDecimal getOneyear() {
		return oneyear;
	}
	public void setOneyear(BigDecimal oneyear) {
		this.oneyear = oneyear;
	}
	public BigDecimal getForeign() {
		return foreign;
	}
	public void setForeign(BigDecimal foreign) {
		this.foreign = foreign;
	}
	public BigDecimal getBanks() {
		return banks;
	}
	public void setBanks(BigDecimal banks) {
		this.banks = banks;
	}
	public BigDecimal getGov2() {
		return gov2;
	}
	public void setGov2(BigDecimal gov2) {
		this.gov2 = gov2;
	}
	public BigDecimal getOther() {
		return other;
	}
	public void setOther(BigDecimal other) {
		this.other = other;
	}
	public BigDecimal getBanks1() {
		return banks1;
	}
	public void setBanks1(BigDecimal banks1) {
		this.banks1 = banks1;
	}
	public BigDecimal getIndividuals2() {
		return individuals2;
	}
	public void setIndividuals2(BigDecimal individuals2) {
		this.individuals2 = individuals2;
	}
	public BigDecimal getOther1() {
		return other1;
	}
	public void setOther1(BigDecimal other1) {
		this.other1 = other1;
	}
	public BigDecimal getBanks2() {
		return banks2;
	}
	public void setBanks2(BigDecimal banks2) {
		this.banks2 = banks2;
	}
	public BigDecimal getGov3() {
		return gov3;
	}
	public void setGov3(BigDecimal gov3) {
		this.gov3 = gov3;
	}
	public BigDecimal getOthers2() {
		return others2;
	}
	public void setOthers2(BigDecimal others2) {
		this.others2 = others2;
	}
	public BigDecimal getBanks3() {
		return banks3;
	}
	public void setBanks3(BigDecimal banks3) {
		this.banks3 = banks3;
	}
	public BigDecimal getGov4() {
		return gov4;
	}
	public void setGov4(BigDecimal gov4) {
		this.gov4 = gov4;
	}
	public BigDecimal getOthers3() {
		return others3;
	}
	public void setOthers3(BigDecimal others3) {
		this.others3 = others3;
	}
	public BigDecimal getForeign1() {
		return foreign1;
	}
	public void setForeign1(BigDecimal foreign1) {
		this.foreign1 = foreign1;
	}
	public BigDecimal getGuarantees() {
		return guarantees;
	}
	public void setGuarantees(BigDecimal guarantees) {
		this.guarantees = guarantees;
	}
	public BigDecimal getNbfi2() {
		return nbfi2;
	}
	public void setNbfi2(BigDecimal nbfi2) {
		this.nbfi2 = nbfi2;
	}
	public BigDecimal getInterbank2() {
		return interbank2;
	}
	public void setInterbank2(BigDecimal interbank2) {
		this.interbank2 = interbank2;
	}
	public BigDecimal getGov5() {
		return gov5;
	}
	public void setGov5(BigDecimal gov5) {
		this.gov5 = gov5;
	}
	public BigDecimal getCorporate2() {
		return corporate2;
	}
	public void setCorporate2(BigDecimal corporate2) {
		this.corporate2 = corporate2;
	}
	public BigDecimal getGre2() {
		return gre2;
	}
	public void setGre2(BigDecimal gre2) {
		this.gre2 = gre2;
	}
	public BigDecimal getIndividuals3() {
		return individuals3;
	}
	public void setIndividuals3(BigDecimal individuals3) {
		this.individuals3 = individuals3;
	}
	public BigDecimal getZero1() {
		return zero1;
	}
	public void setZero1(BigDecimal zero1) {
		this.zero1 = zero1;
	}
	public BigDecimal getThree1() {
		return three1;
	}
	public void setThree1(BigDecimal three1) {
		this.three1 = three1;
	}
	public BigDecimal getSix1() {
		return six1;
	}
	public void setSix1(BigDecimal six1) {
		this.six1 = six1;
	}
	public BigDecimal getOneyear1() {
		return oneyear1;
	}
	public void setOneyear1(BigDecimal oneyear1) {
		this.oneyear1 = oneyear1;
	}
	public String getEmpty() {
		return empty;
	}
	public void setEmpty(String empty) {
		this.empty = empty;
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
	public String getRow_label() {
		return row_label;
	}
	public void setRow_label(String row_label) {
		this.row_label = row_label;
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
	public BRF59E_ENTITY() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
	
	