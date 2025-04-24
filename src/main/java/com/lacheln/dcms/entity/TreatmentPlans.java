package com.lacheln.dcms.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.lacheln.dcms.utilities.StringPrefixedSequenceIdGenerator;

@Entity(name="treatment_plans")
public class TreatmentPlans implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id   // To define the primary key column of the table
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "treatmentPlan_seq")
	@GenericGenerator(name = "treatmentPlan_seq", strategy = "com.lacheln.dcms.utilities.StringPrefixedSequenceIdGenerator",
		parameters = { 
				@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
				@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "TP"),
				@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
		})
	
	private String tpId;
	private String caseNo;
	private String totalAmount;
	private String totalBalanceAmount;
	private String totalPaidAmount;
	private String regDate;
	private String status;
	
	@Transient
	private String treatmentStartDate;
	
	@Transient
	private String treatmentEndDate;
		
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
	public String getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(String totalAmount) {
		this.totalAmount = totalAmount;
	}
	public String getTotalBalanceAmount() {
		return totalBalanceAmount;
	}
	public void setTotalBalanceAmount(String totalBalanceAmount) {
		this.totalBalanceAmount = totalBalanceAmount;
	}
	public String getTotalPaidAmount() {
		return totalPaidAmount;
	}
	public void setTotalPaidAmount(String totalPaidAmount) {
		this.totalPaidAmount = totalPaidAmount;
	}
	public String getRegDate() {
		return regDate;
	}
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTreatmentStartDate() {
		return treatmentStartDate;
	}
	public void setTreatmentStartDate(String treatmentStartDate) {
		this.treatmentStartDate = treatmentStartDate;
	}
	public String getTreatmentEndDate() {
		return treatmentEndDate;
	}
	public void setTreatmentEndDate(String treatmentEndDate) {
		this.treatmentEndDate = treatmentEndDate;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	//For any column needs not to be stored in DB
	@Transient
	private List<Plans> plans;

	public List<Plans> getPlans() {
		return plans;
	}
	public void setPlans(List<Plans> plans) {
		this.plans = plans;
	}
	
}