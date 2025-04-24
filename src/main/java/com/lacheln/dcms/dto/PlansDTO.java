package com.lacheln.dcms.dto;

public class PlansDTO {
	
	private String tpuId;
	private String 	treatment;
	private String	estimatedAmount;
	private String  upperLeftTooth;
	private String  upperRightTooth;
	private String  lowerLeftTooth;
	private String  lowerRightTooth;
		
	
	public String getTpuId() {
		return tpuId;
	}
	public void setTpuId(String tpuId) {
		this.tpuId = tpuId;
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
	
	@Override
	public String toString() {
		return "PlansDTO [tpuId=" + tpuId + ", treatment=" + treatment + ", estimatedAmount=" + estimatedAmount
				+ ", upperLeftTooth=" + upperLeftTooth + ", upperRightTooth=" + upperRightTooth + ", lowerLeftTooth="
				+ lowerLeftTooth + ", lowerRightTooth=" + lowerRightTooth + "]";
	}	
}
