package com.bornfire.xbrl.entities.BRBS;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name ="BRF_MAST_TABLE")
public class BRF_MAST_ENTITY {
	
	private String	acct_crncy_code;
	private String	glsh_code;
	private String	sch_type;
	private String	sch_code;
	private String	cust_id;
	private String	acct_no;
	private String	acct_name;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	eab_date;
	private BigDecimal	eab_bal;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	report_date;
	private String	del_flg;
	private String	rcre_user_id;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	rcre_time;
	private String	lchg_user_id;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	lchg_time;
	private String	verify_user_id;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	verify_time;
	private String	sol_id;
	private BigDecimal	eab_bal_lc;
	private BigDecimal	accr_bal;
	private String	nre_flg;
	private String	gl_code;
	private String	cust_type;
	private String	bls_mapping;
	private String	constitution_code;
	private String	deposit_type;
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Date	maturity_date;
	private String	cell_mapping;
	@Id
	private BigDecimal srl_num;
	
	public String getAcct_crncy_code() {
		return acct_crncy_code;
	}

	public void setAcct_crncy_code(String acct_crncy_code) {
		this.acct_crncy_code = acct_crncy_code;
	}

	public String getGlsh_code() {
		return glsh_code;
	}

	public void setGlsh_code(String glsh_code) {
		this.glsh_code = glsh_code;
	}

	public String getSch_type() {
		return sch_type;
	}

	public void setSch_type(String sch_type) {
		this.sch_type = sch_type;
	}

	public String getSch_code() {
		return sch_code;
	}

	public void setSch_code(String sch_code) {
		this.sch_code = sch_code;
	}

	public String getCust_id() {
		return cust_id;
	}

	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}

	public String getAcct_no() {
		return acct_no;
	}

	public void setAcct_no(String acct_no) {
		this.acct_no = acct_no;
	}

	public String getAcct_name() {
		return acct_name;
	}

	public void setAcct_name(String acct_name) {
		this.acct_name = acct_name;
	}

	public Date getEab_date() {
		return eab_date;
	}

	public void setEab_date(Date eab_date) {
		this.eab_date = eab_date;
	}

	public BigDecimal getEab_bal() {
		return eab_bal;
	}

	public void setEab_bal(BigDecimal eab_bal) {
		this.eab_bal = eab_bal;
	}

	public Date getReport_date() {
		return report_date;
	}

	public void setReport_date(Date report_date) {
		this.report_date = report_date;
	}

	public String getDel_flg() {
		return del_flg;
	}

	public void setDel_flg(String del_flg) {
		this.del_flg = del_flg;
	}

	public String getRcre_user_id() {
		return rcre_user_id;
	}

	public void setRcre_user_id(String rcre_user_id) {
		this.rcre_user_id = rcre_user_id;
	}

	public Date getRcre_time() {
		return rcre_time;
	}

	public void setRcre_time(Date rcre_time) {
		this.rcre_time = rcre_time;
	}

	public String getLchg_user_id() {
		return lchg_user_id;
	}

	public void setLchg_user_id(String lchg_user_id) {
		this.lchg_user_id = lchg_user_id;
	}

	public Date getLchg_time() {
		return lchg_time;
	}

	public void setLchg_time(Date lchg_time) {
		this.lchg_time = lchg_time;
	}

	public String getVerify_user_id() {
		return verify_user_id;
	}

	public void setVerify_user_id(String verify_user_id) {
		this.verify_user_id = verify_user_id;
	}

	public Date getVerify_time() {
		return verify_time;
	}

	public void setVerify_time(Date verify_time) {
		this.verify_time = verify_time;
	}

	public String getSol_id() {
		return sol_id;
	}

	public void setSol_id(String sol_id) {
		this.sol_id = sol_id;
	}

	public BigDecimal getEab_bal_lc() {
		return eab_bal_lc;
	}

	public void setEab_bal_lc(BigDecimal eab_bal_lc) {
		this.eab_bal_lc = eab_bal_lc;
	}

	public BigDecimal getAccr_bal() {
		return accr_bal;
	}

	public void setAccr_bal(BigDecimal accr_bal) {
		this.accr_bal = accr_bal;
	}

	public String getNre_flg() {
		return nre_flg;
	}

	public void setNre_flg(String nre_flg) {
		this.nre_flg = nre_flg;
	}

	public String getGl_code() {
		return gl_code;
	}

	public void setGl_code(String gl_code) {
		this.gl_code = gl_code;
	}

	public String getCust_type() {
		return cust_type;
	}

	public void setCust_type(String cust_type) {
		this.cust_type = cust_type;
	}

	public String getBls_mapping() {
		return bls_mapping;
	}

	public void setBls_mapping(String bls_mapping) {
		this.bls_mapping = bls_mapping;
	}

	public String getConstitution_code() {
		return constitution_code;
	}

	public void setConstitution_code(String constitution_code) {
		this.constitution_code = constitution_code;
	}

	public String getDeposit_type() {
		return deposit_type;
	}

	public void setDeposit_type(String deposit_type) {
		this.deposit_type = deposit_type;
	}

	public Date getMaturity_date() {
		return maturity_date;
	}

	public void setMaturity_date(Date maturity_date) {
		this.maturity_date = maturity_date;
	}

	public String getCell_mapping() {
		return cell_mapping;
	}

	public void setCell_mapping(String cell_mapping) {
		this.cell_mapping = cell_mapping;
	}

	public BigDecimal getSrl_num() {
		return srl_num;
	}

	public void setSrl_num(BigDecimal srl_num) {
		this.srl_num = srl_num;
	}

	
	
	public BRF_MAST_ENTITY(String acct_crncy_code, String glsh_code, String sch_type, String sch_code, String cust_id,
			String acct_no, String acct_name, Date eab_date, BigDecimal eab_bal, Date report_date, String del_flg,
			String rcre_user_id, Date rcre_time, String lchg_user_id, Date lchg_time, String verify_user_id,
			Date verify_time, String sol_id, BigDecimal eab_bal_lc, BigDecimal accr_bal, String nre_flg, String gl_code,
			String cust_type, String bls_mapping, String constitution_code, String deposit_type, Date maturity_date,
			String cell_mapping, BigDecimal srl_num) {
		super();
		this.acct_crncy_code = acct_crncy_code;
		this.glsh_code = glsh_code;
		this.sch_type = sch_type;
		this.sch_code = sch_code;
		this.cust_id = cust_id;
		this.acct_no = acct_no;
		this.acct_name = acct_name;
		this.eab_date = eab_date;
		this.eab_bal = eab_bal;
		this.report_date = report_date;
		this.del_flg = del_flg;
		this.rcre_user_id = rcre_user_id;
		this.rcre_time = rcre_time;
		this.lchg_user_id = lchg_user_id;
		this.lchg_time = lchg_time;
		this.verify_user_id = verify_user_id;
		this.verify_time = verify_time;
		this.sol_id = sol_id;
		this.eab_bal_lc = eab_bal_lc;
		this.accr_bal = accr_bal;
		this.nre_flg = nre_flg;
		this.gl_code = gl_code;
		this.cust_type = cust_type;
		this.bls_mapping = bls_mapping;
		this.constitution_code = constitution_code;
		this.deposit_type = deposit_type;
		this.maturity_date = maturity_date;
		this.cell_mapping = cell_mapping;
		this.srl_num = srl_num;
	}
	
	

	public BRF_MAST_ENTITY() {
		super();
		
	}

	public BRF_MAST_ENTITY(String acct_crncy_code, String glsh_code, String sch_type, String sch_code,
			String cust_id, String acct_no, String acct_name, Date eab_date, BigDecimal eab_bal, Date report_date,
			String del_flg, String rcre_user_id, String rcre_time, String lchg_user_id, Date lchg_time,
			String verify_user_id, Date verify_time, String sol_id, BigDecimal eab_bal_lc, BigDecimal accr_bal,
			String nre_flg, String gl_code, String cust_type, String bls_mapping, String constitution_code,
			String deposit_type, Date maturity_date, String cell_mapping, BigDecimal srl_num)
	{
		this.acct_crncy_code = acct_crncy_code;
		this.glsh_code = glsh_code;
		this.sch_type = sch_type;
		this.sch_code = sch_code;
		this.cust_id = cust_id;
		this.acct_no = acct_no;
		this.acct_name = acct_name;
		this.eab_date = eab_date;
		this.eab_bal = eab_bal;
		this.report_date = report_date;
		this.del_flg = del_flg;
		this.rcre_user_id = rcre_user_id;
		
		this.lchg_user_id = lchg_user_id;
		this.lchg_time = lchg_time;
		this.verify_user_id = verify_user_id;
		this.verify_time = verify_time;
		this.sol_id = sol_id;
		this.eab_bal_lc = eab_bal_lc;
		this.accr_bal = accr_bal;
		this.nre_flg = nre_flg;
		this.gl_code = gl_code;
		this.cust_type = cust_type;
		this.bls_mapping = bls_mapping;
		this.constitution_code = constitution_code;
		this.deposit_type = deposit_type;
		this.maturity_date = maturity_date;
		this.cell_mapping = cell_mapping;
		this.srl_num = srl_num;
	}

	
	
	
	


}
