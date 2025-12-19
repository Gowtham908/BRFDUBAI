package com.bornfire.xbrl.entities.FWD_REVEAL;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="BRF_FORWARD_REVEAL_H_TB")
public class BRF_FORWARD_REVEAL_History {
	
			@EmbeddedId
			BRF_FORWARD_REVEALDetail_Id BRF_FORWARD_REVEAL_HistoryId;


				private String	report_ref_no;
				private BigDecimal	resident;
				private BigDecimal	non_resident;
				//private BigDecimal total;
				private Character	del_flg;
				private String	rcre_user_id;
				private Date	rcre_time;
				private String	lchg_user_id;
				private Date	lchg_time;
				private String	verify_user_id;
				private Date	verify_time;
				
				
				
				
				

				public BRF_FORWARD_REVEALDetail_Id getBRF_FORWARD_REVEAL_HistoryId() {
					return BRF_FORWARD_REVEAL_HistoryId;
				}
				public void setBRF_FORWARD_REVEAL_HistoryId(BRF_FORWARD_REVEALDetail_Id bRF_FORWARD_REVEAL_HistoryId) {
					BRF_FORWARD_REVEAL_HistoryId = bRF_FORWARD_REVEAL_HistoryId;
				}
				public String getReport_ref_no() {
					return report_ref_no;
				}
				public void setReport_ref_no(String report_ref_no) {
					this.report_ref_no = report_ref_no;
				}
				public BigDecimal getResident() {
					return resident;
				}
				public void setResident(BigDecimal resident) {
					this.resident = resident;
				}
				public BigDecimal getNon_resident() {
					return non_resident;
				}
				public void setNon_resident(BigDecimal non_resident) {
					this.non_resident = non_resident;
				}
				public Character getDel_flg() {
					return del_flg;
				}
				public void setDel_flg(Character del_flg) {
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
				
				public BRF_FORWARD_REVEAL_History() {
					
				}
				
				
		
			public BRF_FORWARD_REVEAL_History(BRF_FORWARD_REVEALDetail_Id BRF_FORWARD_REVEAL_HistoryId, String report_ref_no, BigDecimal resident,
						BigDecimal non_resident, Character del_flg, String rcre_user_id, Date rcre_time,
						String lchg_user_id, Date lchg_time, String verify_user_id, Date verify_time) {
					super();
					this.BRF_FORWARD_REVEAL_HistoryId = BRF_FORWARD_REVEAL_HistoryId;
					this.report_ref_no = report_ref_no;
					this.resident = resident;
					this.non_resident = non_resident;
					this.del_flg = del_flg;
					this.rcre_user_id = rcre_user_id;
					this.rcre_time = rcre_time;
					this.lchg_user_id = lchg_user_id;
					this.lchg_time = lchg_time;
					this.verify_user_id = verify_user_id;
					this.verify_time = verify_time;
				}
				

	
	
	
	
}
