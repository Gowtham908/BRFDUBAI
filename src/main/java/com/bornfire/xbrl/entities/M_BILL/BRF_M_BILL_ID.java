package com.bornfire.xbrl.entities.M_BILL;
import java.io.Serializable;


import java.util.Objects;

import javax.persistence.Embeddable;


@Embeddable
public class BRF_M_BILL_ID implements Serializable {
	
	private static final long serialVersionUID = 1L;
		private String	compte;
        private String  report_date;
		
		public String getCompte() {
			return compte;
		}
		public void setCompte(String compte) {
			this.compte = compte;
		}
		public String getReport_date() {
			return report_date;
		}
		public void setReport_date(String report_date) {
			this.report_date = report_date;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public BRF_M_BILL_ID(String num_compta, String report_date) {
			super();
			this.compte = num_compta;
			this.report_date = report_date;
		}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((compte == null) ? 0 : compte.hashCode());
			result = prime * result + ((report_date == null) ? 0 : report_date.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			BRF_M_BILL_ID other = (BRF_M_BILL_ID) obj;
			if (compte == null) {
				if (other.compte != null)
					return false;
			} else if (!compte.equals(other.compte))
				return false;
			if (report_date == null) {
				if (other.report_date != null)
					return false;
			} else if (!report_date.equals(other.report_date))
				return false;
			return true;
		}
		public BRF_M_BILL_ID() {
			super();
			// TODO Auto-generated constructor stub
		}
        
        
}
