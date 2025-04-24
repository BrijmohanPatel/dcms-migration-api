package com.lacheln.dcms.dto;

import java.math.BigDecimal;
import java.util.List;

public class TreatmentPlanDTO {
	
	private String tpId;
	private String caseNo;
	private List<PlansDTO> plans;
	private BigDecimal totalAmount;
	private String regDate;
	private String planStatus;
	
	public String getTpId() {
		return tpId;
	}
	public void setTpId(String tpId) {
		this.tpId = tpId;
	}
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public List<PlansDTO> getPlans() {
		return plans;
	}
	public void setPlans(List<PlansDTO> plans) {
		this.plans = plans;
	}
	public BigDecimal getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	
	@Override
	public String toString() {
		return "TreatmentPlanDTO [tpId=" + tpId + ", caseNo=" + caseNo + ", plans=" + plans + ", totalAmount="
				+ totalAmount + ", regDate=" + regDate + ", planStatus=" + planStatus + "]";
	}
	
}
