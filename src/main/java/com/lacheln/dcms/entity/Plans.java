package com.lacheln.dcms.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.lacheln.dcms.utilities.StringPrefixedSequenceIdGenerator;

@Entity(name="treatment_plan_units")
public class Plans implements Serializable {

	//@Id   // To define the primary key column of the table
	//@GeneratedValue(strategy = GenerationType.AUTO)
	
	
	@Id   // To define the primary key column of the table
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "treatmentPlanUnit_seq")
	@GenericGenerator(name = "treatmentPlanUnit_seq", strategy = "com.lacheln.dcms.utilities.StringPrefixedSequenceIdGenerator",
		parameters = { 
				@Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "50"),
				@Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "TPU"),
				@Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%05d")
		})
	
	private String tpuId;
	private String tpId;
	private String treatment;
	private String estimatedAmount;
	private String upperLeftTooth;
	private String upperRightTooth;
	private String lowerLeftTooth;
	private String lowerRightTooth;
	
	public String getTpuId() {
		return tpuId;
	}
	public void setTpuId(String tpuId) {
		this.tpuId = tpuId;
	}
	public String getTpId() {
		return tpId;
	}
	public void setTpId(String tpId) {
		this.tpId = tpId;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getEstimatedAmount() {
		return estimatedAmount;
	}
	public void setEstimatedAmount(String estimatedAmount) {
		this.estimatedAmount = estimatedAmount;
	}
	public String getUpperLeftTooth() {
		return upperLeftTooth;
	}
	public void setUpperLeftTooth(String upperLeftTooth) {
		this.upperLeftTooth = upperLeftTooth;
	}
	public String getUpperRightTooth() {
		return upperRightTooth;
	}
	public void setUpperRightTooth(String upperRightTooth) {
		this.upperRightTooth = upperRightTooth;
	}
	public String getLowerLeftTooth() {
		return lowerLeftTooth;
	}
	public void setLowerLeftTooth(String lowerLeftTooth) {
		this.lowerLeftTooth = lowerLeftTooth;
	}
	public String getLowerRightTooth() {
		return lowerRightTooth;
	}
	public void setLowerRightTooth(String lowerRightTooth) {
		this.lowerRightTooth = lowerRightTooth;
	}
	
	
	
}